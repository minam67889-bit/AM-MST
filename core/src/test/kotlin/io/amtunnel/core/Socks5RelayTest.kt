package io.amtunnel.core

import io.amtunnel.core.net.Socks5Relay
import io.amtunnel.core.util.TunnelLog
import java.io.DataInputStream
import java.io.OutputStream
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * The local proxy that carries the SlowDNS tunnel, tested against a stub that
 * behaves exactly like the real far end (measured 2026-10-29, docs/SLOWDNS.md):
 *
 * ```
 * <- 05 01 02      greeting, user/pass only
 * -> 05 02
 * <- 01 ULEN user PLEN pass
 * -> 01 00         accepted
 * <- 05 01 00 03 .. CONNECT
 * -> 05 00 00 01 .. granted
 * ```
 *
 * A client that is *not* authenticated must never reach the far end: the relay
 * logs in for it. That is the whole point of shipping a clean 127.0.0.1:1080.
 */
class Socks5RelayTest {

    private class StubFarEnd(val user: String, val pass: String) {
        val server = ServerSocket(0, 8, java.net.InetAddress.getByName("127.0.0.1"))
        val port: Int get() = server.localPort
        val seenUser = java.util.concurrent.atomic.AtomicReference<String>()
        val seenPass = java.util.concurrent.atomic.AtomicReference<String>()
        val seenTarget = java.util.concurrent.atomic.AtomicReference<String>()
        val done = CountDownLatch(1)

        fun start() = Thread({
            runCatching {
                server.accept().use { c ->
                    c.soTimeout = 10_000
                    val input = DataInputStream(c.getInputStream())
                    val out = c.getOutputStream()

                    assertEquals(5, input.readUnsignedByte())
                    val methods = ByteArray(input.readUnsignedByte()).also { input.readFully(it) }
                    assertTrue(methods.any { it.toInt() == 2 }, "relay must offer user/pass")
                    out.write(byteArrayOf(5, 2)); out.flush()

                    val version = input.readUnsignedByte()
                    val ulen = input.readUnsignedByte()
                    val u = ByteArray(ulen).also { input.readFully(it) }.toString(Charsets.UTF_8)
                    val plen = input.readUnsignedByte()
                    val p = ByteArray(plen).also { input.readFully(it) }.toString(Charsets.UTF_8)
                    seenUser.set(u); seenPass.set(p)
                    val ok = version == 1 && u == user && p == pass
                    out.write(byteArrayOf(1, if (ok) 0 else 0xFF.toByte())); out.flush()
                    if (ok) {
                        assertEquals(5, input.readUnsignedByte())
                        assertEquals(1, input.readUnsignedByte())
                        input.readUnsignedByte()
                        assertEquals(3, input.readUnsignedByte())
                        val hostLen = input.readUnsignedByte()
                        val host = ByteArray(hostLen).also { input.readFully(it) }.toString(Charsets.US_ASCII)
                        val tport = (input.readUnsignedByte() shl 8) or input.readUnsignedByte()
                        seenTarget.set("$host:$tport")
                        out.write(byteArrayOf(5, 0, 0, 1, 0, 0, 0, 0, 0, 0)); out.flush()
                        // echo one plaintext line back, like an HTTP server would
                        val buffer = ByteArray(256)
                        val n = input.read(buffer)
                        if (n > 0) out.write("HTTP/1.0 200 OK\r\n\r\n".toByteArray())
                        out.flush()
                    }
                }
            }
            done.countDown()
        }, "stub-far-end").apply { isDaemon = true }.start()
    }

    private fun readLine(input: DataInputStream): String {
        val sb = StringBuilder()
        while (true) {
            val b = input.read()
            if (b < 0 || b == '\n'.code) break
            if (b != '\r'.code) sb.append(b.toChar())
        }
        return sb.toString()
    }

    @Test
    fun `logs in upstream and hands the client a no-auth proxy`() {
        val far = StubFarEnd("tanginakaba", "hackpamoregago")
        far.start()
        val log = TunnelLog()
        val notices = java.util.concurrent.CopyOnWriteArrayList<String>()
        val relay = Socks5Relay(
            upstreamHost = "127.0.0.1",
            upstreamPort = far.port,
            upstreamUser = "tanginakaba",
            upstreamPass = "hackpamoregago",
            log = log,
            listenPort = 0,
            onNotice = { notices.add(it) },
        )
        assertTrue(relay.start(), "relay must bind: ${log.dump()}")

        Socket().use { client ->
            client.connect(InetSocketAddress("127.0.0.1", relay.port), 5_000)
            client.soTimeout = 10_000
            val input = DataInputStream(client.getInputStream())
            val out: OutputStream = client.getOutputStream()

            out.write(byteArrayOf(5, 1, 0)); out.flush()          // we ask for no auth
            assertEquals(5, input.readUnsignedByte())
            assertEquals(0, input.readUnsignedByte(), "relay must accept us without credentials")

            val host = "example.com".toByteArray(Charsets.US_ASCII)
            out.write(byteArrayOf(5, 1, 0, 3, host.size.toByte(), *host, 0, 80)); out.flush()
            assertEquals(5, input.readUnsignedByte())
            assertEquals(0, input.readUnsignedByte(), "CONNECT must succeed: ${log.dump()}")

            out.write("GET / HTTP/1.0\r\n\r\n".toByteArray()); out.flush()
            assertEquals("HTTP/1.0 200 OK", readLine(input))
        }

        assertTrue(far.done.await(5, TimeUnit.SECONDS), "far end never finished")
        assertEquals("tanginakaba", far.seenUser.get())
        assertEquals("hackpamoregago", far.seenPass.get())
        assertEquals("example.com:80", far.seenTarget.get())
        assertTrue(
            notices.any { it.contains("accepted the login") },
            "the UI has to be able to show that the far end took the login: $notices",
        )
        relay.stop()
    }

    @Test
    fun `a rejected login never lets the client through`() {
        val far = StubFarEnd("tanginakaba", "hackpamoregago")
        far.start()
        val log = TunnelLog()
        val notices = java.util.concurrent.CopyOnWriteArrayList<String>()
        val relay = Socks5Relay(
            upstreamHost = "127.0.0.1",
            upstreamPort = far.port,
            upstreamUser = "tanginaka",              // the decoy pair
            upstreamPass = "wagditokupal",
            log = log,
            listenPort = 0,
            onNotice = { notices.add(it) },
        )
        assertTrue(relay.start(), "relay must bind")

        Socket().use { client ->
            client.connect(InetSocketAddress("127.0.0.1", relay.port), 5_000)
            client.soTimeout = 10_000
            val input = DataInputStream(client.getInputStream())
            val out: OutputStream = client.getOutputStream()
            out.write(byteArrayOf(5, 1, 0)); out.flush()
            input.readUnsignedByte(); input.readUnsignedByte()
            val host = "example.com".toByteArray(Charsets.US_ASCII)
            out.write(byteArrayOf(5, 1, 0, 3, host.size.toByte(), *host, 0, 80)); out.flush()
            assertEquals(5, input.readUnsignedByte())
            assertTrue(input.readUnsignedByte() != 0, "a refused login must not become a granted CONNECT")
        }
        assertTrue(
            notices.any { it.contains("rejected") },
            "the user has to see why nothing works: $notices",
        )
        relay.stop()
    }
}
