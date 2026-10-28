package io.amtunnel.it

import com.sun.net.httpserver.HttpServer
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

/**
 * UDP forwarder that behaves like a real recursive resolver in front of the
 * tunnel server: it receives a query, forwards it to the server and relays the
 * answer back. Killing it simulates a resolver outage while the tunnel server
 * stays healthy - exactly the failover scenario we want to test.
 */
class UdpRelay(
    val name: String,
    private val targetHost: String,
    private val targetPort: Int,
) {
    private val socket = DatagramSocket(0, InetAddress.getByName("127.0.0.1"))
    private val running = AtomicBoolean(false)
    private var thread: Thread? = null
    val port: Int get() = socket.localPort
    val forwarded = AtomicLong()

    fun start() {
        running.set(true)
        val worker = Thread({
            val buffer = ByteArray(8192)
            while (running.get()) {
                try {
                    val packet = DatagramPacket(buffer, buffer.size)
                    socket.receive(packet)
                    forwarded.incrementAndGet()
                    val payload = packet.data.copyOfRange(packet.offset, packet.offset + packet.length)
                    val clientAddress = packet.address
                    val clientPort = packet.port
                    Thread {
                        try {
                            DatagramSocket().use { upstream ->
                                upstream.soTimeout = 5000
                                upstream.send(
                                    DatagramPacket(
                                        payload, payload.size,
                                        InetAddress.getByName(targetHost), targetPort,
                                    ),
                                )
                                val responseBuffer = ByteArray(8192)
                                val response = DatagramPacket(responseBuffer, responseBuffer.size)
                                upstream.receive(response)
                                val body = response.data.copyOfRange(0, response.length)
                                socket.send(DatagramPacket(body, body.size, clientAddress, clientPort))
                            }
                        } catch (e: Exception) {
                            // upstream silent: let the client time out
                        }
                    }.start()
                } catch (e: Exception) {
                    if (running.get()) continue else break
                }
            }
        }, "udp-relay-$name")
        worker.isDaemon = true
        thread = worker
        worker.start()
    }

    fun kill() {
        running.set(false)
        runCatching { socket.close() }
    }

    val endpoint get() = io.amtunnel.core.dns.ResolverEndpoint("127.0.0.1", port, name)
}

/**
 * A resolver that answers ordinary DNS correctly but never carries tunnel
 * payloads - the "hijacking / caching-only resolver" case.
 */
class PlainDnsStub {
    private val socket = DatagramSocket(0, InetAddress.getByName("127.0.0.1"))
    private val running = AtomicBoolean(false)
    val port: Int get() = socket.localPort
    val answered = AtomicLong()

    fun start() {
        running.set(true)
        Thread({
            val buffer = ByteArray(4096)
            while (running.get()) {
                try {
                    val packet = DatagramPacket(buffer, buffer.size)
                    socket.receive(packet)
                    answered.incrementAndGet()
                    val query = packet.data.copyOfRange(packet.offset, packet.offset + packet.length)
                    val response = emptyNoError(query)
                    socket.send(DatagramPacket(response, response.size, packet.address, packet.port))
                } catch (e: Exception) {
                    if (!running.get()) break
                }
            }
        }, "plain-dns-stub").apply { isDaemon = true }.start()
    }

    fun kill() {
        running.set(false)
        runCatching { socket.close() }
    }

    val endpoint get() = io.amtunnel.core.dns.ResolverEndpoint("127.0.0.1", port, "dns-only")

    /** NOERROR with the question echoed and no answers. */
    private fun emptyNoError(query: ByteArray): ByteArray {
        if (query.size < 12) return query
        var offset = 12
        while (offset < query.size && query[offset].toInt() != 0) {
            offset += (query[offset].toInt() and 0xFF) + 1
        }
        offset += 1
        val questionEnd = minOf(query.size, offset + 4)
        val out = ByteArray(questionEnd)
        System.arraycopy(query, 0, out, 0, questionEnd)
        out[2] = (0x81).toByte() // QR=1, RD
        out[3] = (0x80).toByte() // RA, rcode 0
        out[6] = 0; out[7] = 0 // ANCOUNT 0
        out[8] = 0; out[9] = 0
        out[10] = 0; out[11] = 0
        return out
    }
}

class HttpProbeServer(private val body: String) {
    private var server: HttpServer? = null
    var port: Int = 0
        private set

    fun start() {
        val http = HttpServer.create(InetSocketAddress("127.0.0.1", 0), 0)
        http.createContext("/probe") { exchange ->
            val payload = body.toByteArray()
            exchange.responseHeaders.add("Content-Type", "text/plain")
            exchange.sendResponseHeaders(200, payload.size.toLong())
            exchange.responseBody.use { it.write(payload) }
        }
        http.executor = java.util.concurrent.Executors.newFixedThreadPool(4)
        http.start()
        server = http
        port = http.address.port
    }

    fun stop() {
        runCatching { server?.stop(0) }
    }
}
