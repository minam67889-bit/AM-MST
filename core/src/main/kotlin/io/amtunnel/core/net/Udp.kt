package io.amtunnel.core.net

import java.io.IOException
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.net.SocketTimeoutException

/**
 * Hook that lets the Android layer keep tunnel sockets outside the VPN tunnel
 * (`VpnService.protect`). Without it a VPN capturing 0.0.0.0/0 would route the
 * tunnel's own DNS traffic back into the tunnel and loop.
 */
interface SocketProtector {
    fun protect(socket: DatagramSocket): Boolean
    fun protect(socket: Socket): Boolean

    object Noop : SocketProtector {
        override fun protect(socket: DatagramSocket): Boolean = false
        override fun protect(socket: Socket): Boolean = false
    }
}

class UdpExchangeException(message: String, cause: Throwable? = null) : IOException(message, cause)

data class UdpResult(val response: ByteArray, val rttMs: Long, val remote: String)

object UdpExchange {
    /**
     * Sends [payload] to [host]:[port] and waits for one datagram. When
     * [expectedId] is non-null, datagrams whose first two bytes (the DNS
     * transaction id) do not match are ignored.
     */
    fun exchange(
        host: String,
        port: Int,
        payload: ByteArray,
        timeoutMs: Int,
        expectedId: Int? = null,
        protector: SocketProtector = SocketProtector.Noop,
    ): UdpResult {
        val address = InetAddress.getByName(host)
        DatagramSocket().use { socket ->
            protector.protect(socket)
            socket.soTimeout = timeoutMs
            socket.connect(InetSocketAddress(address, port))
            val startedAt = System.nanoTime()
            socket.send(DatagramPacket(payload, payload.size, address, port))

            val buffer = ByteArray(4096)
            val deadline = startedAt + timeoutMs * 1_000_000L
            while (true) {
                val remainingNanos = deadline - System.nanoTime()
                if (remainingNanos <= 0) throw UdpExchangeException("timeout after ${timeoutMs}ms")
                socket.soTimeout = maxOf(1L, remainingNanos / 1_000_000L).toInt()
                val packet = DatagramPacket(buffer, buffer.size)
                try {
                    socket.receive(packet)
                } catch (e: SocketTimeoutException) {
                    throw UdpExchangeException("timeout after ${timeoutMs}ms", e)
                }
                val data = packet.data.copyOfRange(packet.offset, packet.offset + packet.length)
                if (expectedId != null) {
                    if (data.size < 2) continue
                    val id = ((data[0].toInt() and 0xFF) shl 8) or (data[1].toInt() and 0xFF)
                    if (id != expectedId) continue
                }
                val rttMs = (System.nanoTime() - startedAt) / 1_000_000L
                return UdpResult(data, rttMs, packet.address?.hostAddress ?: host)
            }
        }
    }

    /** Raw one-way send without waiting for an answer (used for fire-and-forget closes). */
    fun send(
        host: String,
        port: Int,
        payload: ByteArray,
        protector: SocketProtector = SocketProtector.Noop,
    ) {
        val address = InetAddress.getByName(host)
        DatagramSocket().use { socket ->
            protector.protect(socket)
            socket.send(DatagramPacket(payload, payload.size, address, port))
        }
    }
}
