package io.amtunnel.core.net

import io.amtunnel.core.util.TunnelLog
import java.io.DataInputStream
import java.io.IOException
import java.io.OutputStream
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

/**
 * A local SOCKS5 proxy that speaks to *another* SOCKS5 proxy.
 *
 * Why this exists: BD NET's own tunnel client (`libxdnstt.so`, a dnstt fork)
 * listens on 127.0.0.1:7000 and forwards raw bytes to its server, which runs a
 * SOCKS5 that wants RFC 1929 credentials. Their tun2socks talks to that port
 * directly. We keep the credentials in one place (settings: user/pass), and
 * expose a clean, unauthenticated SOCKS5 on our side, so tun2socks, a browser
 * or curl can use it without knowing anything about BD.
 *
 * Note the deliberate split:
 *  * upstream hop  = authenticated (tanginaka/wagditokupal style pair)
 *  * local hop     = no-auth, loopback only
 */
class Socks5Relay(
    private val upstreamHost: String,
    private val upstreamPort: Int,
    private val upstreamUser: String,
    private val upstreamPass: String,
    private val log: TunnelLog,
    private val listenHost: String = "127.0.0.1",
    listenPort: Int = 1080,
) {
    private var server: ServerSocket? = null
    private val running = AtomicBoolean(false)
    private val clients = CopyOnWriteArrayList<Socket>()
    private val connections = AtomicInteger()

    @Volatile
    var port: Int = listenPort
        private set

    val activeConnections: Int get() = connections.get()

    fun start(): Boolean {
        if (running.get()) return true
        val socket = try {
            ServerSocket().apply {
                reuseAddress = true
                bind(InetSocketAddress(listenHost, port))
            }
        } catch (e: Exception) {
            log.error("relay", "cannot bind $listenHost:$port - ${e.message}")
            return false
        }
        port = socket.localPort
        server = socket
        running.set(true)
        Thread({ acceptLoop(socket) }, "socks5-relay").apply { isDaemon = true }.start()
        log.info("relay", "SOCKS5 $listenHost:$port -> socks5://$upstreamHost:$upstreamPort")
        return true
    }

    fun stop() {
        running.set(false)
        runCatching { server?.close() }
        server = null
        clients.forEach { runCatching { it.close() } }
        clients.clear()
        log.info("relay", "SOCKS5 relay stopped")
    }

    private fun acceptLoop(socket: ServerSocket) {
        while (running.get()) {
            val client = try {
                socket.accept()
            } catch (e: Exception) {
                break
            }
            clients.add(client)
            Thread({ handle(client) }, "socks5-relay-client").apply { isDaemon = true }.start()
        }
    }

    private fun handle(client: Socket) {
        var upstream: Socket? = null
        try {
            client.soTimeout = 30_000
            val input = DataInputStream(client.getInputStream())
            val output = client.getOutputStream()

            if (input.readUnsignedByte() != 5) return
            val methodCount = input.readUnsignedByte()
            val methods = ByteArray(methodCount).also { input.readFully(it) }
            if (methods.none { it.toInt() == 0 }) {
                output.write(byteArrayOf(5, 0xFF.toByte())); output.flush(); return
            }
            output.write(byteArrayOf(5, 0)); output.flush()

            if (input.readUnsignedByte() != 5) return
            val command = input.readUnsignedByte()
            input.readUnsignedByte()
            val atyp = input.readUnsignedByte()
            val host = when (atyp) {
                1 -> ByteArray(4).also { input.readFully(it) }
                    .joinToString(".") { (it.toInt() and 0xFF).toString() }
                3 -> ByteArray(input.readUnsignedByte()).also { input.readFully(it) }
                    .toString(Charsets.US_ASCII)
                4 -> ByteArray(16).also { input.readFully(it) }
                    .let { java.net.InetAddress.getByAddress(it).hostAddress ?: "::" }
                else -> { reply(output, 0x08); return }
            }
            val targetPort = input.readUnsignedShort()
            if (command != 1) { reply(output, 0x07); return }

            log.info("relay", "CONNECT $host:$targetPort")
            val up = Socket()
            up.tcpNoDelay = true
            up.connect(InetSocketAddress(upstreamHost, upstreamPort), 10_000)
            up.soTimeout = 15_000
            val upIn = DataInputStream(up.getInputStream())
            val upOut = up.getOutputStream()

            // SOCKS5 greeting to the upstream: offer no-auth plus user/pass.
            val wantsAuth = upstreamUser.isNotEmpty() || upstreamPass.isNotEmpty()
            if (wantsAuth) {
                upOut.write(byteArrayOf(5, 2, 0, 2))
            } else {
                upOut.write(byteArrayOf(5, 1, 0))
            }
            upOut.flush()
            val version = upIn.readUnsignedByte()
            val chosen = upIn.readUnsignedByte()
            if (version != 5) { log.warn("relay", "upstream is not SOCKS5 (v$version)"); reply(output, 0x01); return }
            if (chosen.toInt() == 0xFF) {
                log.warn("relay", "upstream rejected every auth method")
                reply(output, 0x02); return
            }
            if (chosen.toInt() == 2) {
                val user = upstreamUser.toByteArray(Charsets.UTF_8)
                val pass = upstreamPass.toByteArray(Charsets.UTF_8)
                val packet = ByteArray(3 + user.size + pass.size)
                packet[0] = 1
                packet[1] = user.size.toByte()
                user.copyInto(packet, 2)
                packet[2 + user.size] = pass.size.toByte()
                pass.copyInto(packet, 3 + user.size)
                upOut.write(packet); upOut.flush()
                upIn.readUnsignedByte()
                val status = upIn.readUnsignedByte()
                if (status.toInt() != 0) {
                    log.warn("relay", "upstream rejected the credentials (status $status)")
                    reply(output, 0x02); return
                }
            }

            // CONNECT, resolved by the upstream (ATYP=domain keeps DNS on the far side).
            val hostBytes = host.toByteArray(Charsets.US_ASCII)
            val packet = ByteArray(7 + hostBytes.size)
            packet[0] = 5; packet[1] = 1; packet[2] = 0; packet[3] = 3
            packet[4] = hostBytes.size.toByte()
            hostBytes.copyInto(packet, 5)
            packet[5 + hostBytes.size] = ((targetPort shr 8) and 0xFF).toByte()
            packet[6 + hostBytes.size] = (targetPort and 0xFF).toByte()
            upOut.write(packet); upOut.flush()
            upIn.readUnsignedByte()
            val result = upIn.readUnsignedByte()
            upIn.readUnsignedByte()
            when (upIn.readUnsignedByte()) { // skip bound address
                1 -> upIn.skipBytes(4)
                3 -> upIn.skipBytes(upIn.readUnsignedByte())
                4 -> upIn.skipBytes(16)
                else -> Unit
            }
            upIn.skipBytes(2)
            if (result.toInt() != 0) {
                log.warn("relay", "upstream CONNECT $host:$targetPort failed (code $result)")
                reply(output, result.toInt().coerceIn(1, 8)); return
            }

            upstream = up
            connections.incrementAndGet()
            reply(output, 0x00)
            client.soTimeout = 0
            up.soTimeout = 0

            val upThread = Thread({
                val buffer = ByteArray(8192)
                try {
                    while (true) {
                        val n = client.getInputStream().read(buffer)
                        if (n < 0) break
                        upOut.write(buffer, 0, n); upOut.flush()
                    }
                } catch (_: Exception) {
                } finally {
                    runCatching { up.close() }
                }
            }, "relay-up")
            upThread.isDaemon = true
            upThread.start()

            val buffer = ByteArray(8192)
            try {
                while (true) {
                    val n = upIn.read(buffer)
                    if (n < 0) break
                    output.write(buffer, 0, n); output.flush()
                }
            } catch (_: Exception) {
            }
        } catch (e: IOException) {
            log.debug("relay", "connection error: ${e.message}")
        } catch (e: Exception) {
            log.warn("relay", "handling error: ${e.message}")
        } finally {
            runCatching { upstream?.close() }
            runCatching { client.close() }
            clients.remove(client)
            if (connections.get() > 0) connections.decrementAndGet()
        }
    }

    private fun reply(out: OutputStream, code: Int) {
        out.write(byteArrayOf(5, code.toByte(), 0, 1, 0, 0, 0, 0, 0, 0))
        out.flush()
    }
}
