package io.amtunnel.core.net

import io.amtunnel.core.transport.TunnelTransport
import io.amtunnel.core.util.TunnelLog
import java.io.DataInputStream
import java.io.IOException
import java.net.InetSocketAddress
import java.net.ServerSocket
import java.net.Socket
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

/**
 * Local SOCKS5 proxy that forwards every CONNECT into the tunnel.
 *
 * This is the fully-verified path for real traffic: any app that understands
 * SOCKS5 (browsers, mail clients, most OS-level proxy settings) can send its
 * TCP traffic through the DNS tunnel this way, with no root and no tun2socks.
 */
class Socks5Server(
    private val transportProvider: () -> TunnelTransport?,
    private val log: TunnelLog,
    private val listenHost: String = "127.0.0.1",
    listenPort: Int = 1080,
) {
    private var server: ServerSocket? = null
    private val running = AtomicBoolean(false)
    private val clients = CopyOnWriteArrayList<Socket>()
    private val connections = AtomicInteger()
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
            log.error("socks", "cannot bind $listenHost:$port - ${e.message}")
            return false
        }
        port = socket.localPort
        server = socket
        running.set(true)
        val thread = Thread({ acceptLoop(socket) }, "socks5-accept")
        thread.isDaemon = true
        thread.start()
        log.info("socks", "SOCKS5 proxy listening on $listenHost:$port")
        return true
    }

    fun stop() {
        running.set(false)
        runCatching { server?.close() }
        server = null
        clients.forEach { runCatching { it.close() } }
        clients.clear()
        log.info("socks", "SOCKS5 proxy stopped")
    }

    private fun acceptLoop(socket: ServerSocket) {
        while (running.get()) {
            val client = try {
                socket.accept()
            } catch (e: Exception) {
                break
            }
            clients.add(client)
            val worker = Thread({ handleClient(client) }, "socks5-client")
            worker.isDaemon = true
            worker.start()
        }
    }

    private fun handleClient(client: Socket) {
        try {
            client.soTimeout = 30_000
            val input = DataInputStream(client.getInputStream())
            val output = client.getOutputStream()

            // --- greeting
            val version = input.readUnsignedByte()
            if (version != 5) {
                log.warn("socks", "unsupported SOCKS version $version")
                return
            }
            val methodCount = input.readUnsignedByte()
            val methods = ByteArray(methodCount)
            input.readFully(methods)
            if (!methods.any { it.toInt() == 0 }) {
                log.warn("socks", "client did not offer NO AUTH")
                output.write(byteArrayOf(5, 0xFF.toByte()))
                output.flush()
                return
            }
            output.write(byteArrayOf(5, 0))
            output.flush()

            // --- request
            val reqVersion = input.readUnsignedByte()
            val command = input.readUnsignedByte()
            input.readUnsignedByte() // reserved
            val atyp = input.readUnsignedByte()
            if (reqVersion != 5) return

            val host: String = when (atyp) {
                1 -> {
                    val raw = ByteArray(4)
                    input.readFully(raw)
                    raw.joinToString(".") { (it.toInt() and 0xFF).toString() }
                }
                3 -> {
                    val len = input.readUnsignedByte()
                    val raw = ByteArray(len)
                    input.readFully(raw)
                    String(raw, Charsets.US_ASCII)
                }
                4 -> {
                    val raw = ByteArray(16)
                    input.readFully(raw)
                    java.net.InetAddress.getByAddress(raw).hostAddress ?: "::"
                }
                else -> {
                    reply(output, 0x08) // address type not supported
                    return
                }
            }
            val port = input.readUnsignedShort()

            if (command != 1) {
                log.warn("socks", "unsupported command $command (only CONNECT)")
                reply(output, 0x07) // command not supported
                return
            }

            val transport = transportProvider()
            if (transport == null || !transport.isReady) {
                log.warn("socks", "CONNECT $host:$port rejected: tunnel not ready")
                reply(output, 0x03) // network unreachable
                return
            }

            log.info("socks", "CONNECT $host:$port")
            val stream = transport.openStream(host, port, 15_000)
            if (stream == null) {
                log.warn("socks", "CONNECT $host:$port failed inside the tunnel")
                reply(output, 0x05) // connection refused
                return
            }
            connections.incrementAndGet()
            reply(output, 0x00)
            client.soTimeout = 0

            val up = Thread({
                val buffer = ByteArray(4096)
                try {
                    while (true) {
                        val n = client.getInputStream().read(buffer)
                        if (n < 0) break
                        if (n > 0) stream.write(buffer, 0, n)
                    }
                } catch (e: Exception) {
                    log.debug("socks", "upload side finished: ${e.message}")
                } finally {
                    runCatching { stream.close() }
                }
            }, "socks5-up")
            up.isDaemon = true
            up.start()

            val buffer = ByteArray(4096)
            try {
                while (true) {
                    val n = stream.read(buffer, 0, buffer.size, 1000)
                    if (n < 0) break
                    if (n == 0) continue
                    output.write(buffer, 0, n)
                    output.flush()
                }
            } catch (e: Exception) {
                log.debug("socks", "download side finished: ${e.message}")
            } finally {
                runCatching { stream.close() }
                runCatching { client.close() }
                connections.decrementAndGet()
            }
        } catch (e: IOException) {
            log.debug("socks", "client connection error: ${e.message}")
        } catch (e: Exception) {
            log.warn("socks", "client handling error: ${e.message}")
        } finally {
            clients.remove(client)
            runCatching { client.close() }
        }
    }

    private fun reply(output: java.io.OutputStream, code: Int) {
        output.write(byteArrayOf(5, code.toByte(), 0, 1, 0, 0, 0, 0, 0, 0))
        output.flush()
    }
}
