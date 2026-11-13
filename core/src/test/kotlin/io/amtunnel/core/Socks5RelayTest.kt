package io.amtunnel.core

import io.amtunnel.core.net.Socks5Relay
import io.amtunnel.core.util.TunnelLog
import java.io.DataInputStream
import java.io.OutputStream
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicReference
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

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

    private fun readByte(input: DataInputStream): Int = input.readUnsignedByte().toInt()

    private class StubFarEnd(val user: String, val pass: String) {
        val server = ServerSocket(0, 8, InetAddress.getByName("127.0.0.1"))
        val port: Int get() = server.localPort
        val seenUser = AtomicReference<String>()
        val seenPass = AtomicReference<String>()
        val seenTarget = AtomicReference<String>()
        val done = CountDownLatch(1)
        val failure = AtomicReference<String>()

        fun start() = Thread({
            try {
                server.accept().use { c ->
                    c.soTimeout = 10_000
                    val input = DataInputStream(c.getInputStream())
                    val out = c.getOutputStream()

                    check(input.readUnsignedByte().toInt() == 5) { "no socks version" }
                    val methods = ByteArray(input.readUnsignedByte().toInt()).also { input.readFully(it) }
                    check(methods.any { it.toInt() == 2 }) { "relay did not offer user/pass" }
                    out.write(byteArrayOf(5, 2)); out.flush()

                    val version = input.readUnsignedByte().toInt()
                    val ulen = input.readUnsignedByte().toInt()
                    val u = ByteArray(ulen).also { input.readFully(it) }.toString(Charsets.UTF_8)
                    val plen = input.readUnsignedByte().toInt()
                    val p = ByteArray(plen).also { input.readFully(it) }.toString(Charsets.UTF_8)
                    seenUser.set(u)
                    seenPass.set(p)
                    val ok = version == 1 && u == user && p == pass
                    out.write(byteArrayOf(1, if (ok) 0 else 0xFF.toByte())); out.flush()
                    if (!ok) return@use

                    check(input.readUnsignedByte().toInt() == 5)
                    check(input.readUnsignedByte().toInt() == 1)
                    input.readUnsignedByte()
                    check(input.readUnsignedByte().toInt() == 3)
                    val hostLen = input.readUnsignedByte().toInt()
                    val host = ByteArray(hostLen).also { input.readFully(it) }.toString(Charsets.US_ASCII)
                    val tport = (input.readUnsignedByte().toInt() shl 8) or input.readUnsignedByte().toInt()
                    seenTarget.set("$host:$tport")
                    out.write(byteArrayOf(5, 0, 0, 1, 0, 0, 0, 0, 0, 0)); out.flush()
                    val buffer = ByteArray(256)
                    if (input.read(buffer) > 0) out.write("HTTP/1.0 200 OK\r\n\r\n".toByteArray())
                    out.flush()
                }
            } catch (e: Throwable) {
                failure.set(e.toString())
            } finally {
                done.countDown()
            }
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
    fun logsInUpstreamAndHandsTheClientANoAuthProxy() {
        val far = StubFarEnd("tanginakaba", "hackpamoregago")
        far.start()
        val log = TunnelLog()
        val notices = CopyOnWriteArrayList<String>()
        val relay = Socks5Relay(
            upstreamHost = "127.0.0.1",
            upstreamPort = far.port,
            upstreamUser = "tanginakaba",
            upstreamPass = "hackpamoregago",
            log = log,
            listenPort = 0,
            onNotice = { notices.add(it) },
        )
        assertTrue("relay must bind: ${log.dump()}", relay.start())

        Socket().use { client ->
            client.connect(InetSocketAddress("127.0.0.1", relay.port), 5_000)
            client.soTimeout = 10_000
            val input = DataInputStream(client.getInputStream())
            val out: OutputStream = client.getOutputStream()

            out.write(byteArrayOf(5, 1, 0)); out.flush()          // we ask for no auth
            assertEquals(5, readByte(input).toLong())
            assertEquals("relay must accept us without credentials", 0, readByte(input).toLong())

            val host = "example.com".toByteArray(Charsets.US_ASCII)
            out.write(byteArrayOf(5, 1, 0, 3, host.size.toByte(), *host, 0, 80)); out.flush()
            // the whole reply: version, status, reserved, atyp, 4-byte address, port
            val reply = ByteArray(10).also { input.readFully(it) }
            assertEquals("CONNECT must succeed: ${log.dump()}", 5, reply[0].toInt())
            assertEquals("CONNECT must succeed: ${log.dump()}", 0, reply[1].toInt())

            out.write("GET / HTTP/1.0\r\n\r\n".toByteArray()); out.flush()
            assertEquals("HTTP/1.0 200 OK", readLine(input))
        }

        assertTrue("far end never finished", far.done.await(5, TimeUnit.SECONDS))
        assertEquals("stub failure", null, far.failure.get())
        assertEquals("tanginakaba", far.seenUser.get())
        assertEquals("hackpamoregago", far.seenPass.get())
        assertEquals("example.com:80", far.seenTarget.get())
        assertTrue(
            "the UI has to be able to show that the far end took the login: $notices",
            notices.any { it.contains("accepted the login") },
        )
        relay.stop()
    }

    @Test
    fun aRejectedLoginNeverLetsTheClientThrough() {
        val far = StubFarEnd("tanginakaba", "hackpamoregago")
        far.start()
        val log = TunnelLog()
        val notices = CopyOnWriteArrayList<String>()
        val relay = Socks5Relay(
            upstreamHost = "127.0.0.1",
            upstreamPort = far.port,
            upstreamUser = "tanginaka",              // the decoy pair
            upstreamPass = "wagditokupal",
            log = log,
            listenPort = 0,
            onNotice = { notices.add(it) },
        )
        assertTrue("relay must bind", relay.start())

        Socket().use { client ->
            client.connect(InetSocketAddress("127.0.0.1", relay.port), 5_000)
            client.soTimeout = 10_000
            val input = DataInputStream(client.getInputStream())
            val out: OutputStream = client.getOutputStream()
            out.write(byteArrayOf(5, 1, 0)); out.flush()
            readByte(input); readByte(input)
            val host = "example.com".toByteArray(Charsets.US_ASCII)
            out.write(byteArrayOf(5, 1, 0, 3, host.size.toByte(), *host, 0, 80)); out.flush()
            val reply = ByteArray(10).also { input.readFully(it) }
            assertEquals(5, reply[0].toInt())
            assertTrue("a refused login must not become a granted CONNECT", reply[1].toInt() != 0)
        }
        assertTrue(
            "the user has to see why nothing works: $notices",
            notices.any { it.contains("rejected") },
        )
        relay.stop()
    }
}
