package io.amtunnel.core.net

import io.amtunnel.core.transport.TunnelTransport
import io.amtunnel.core.util.TunnelLog

/**
 * Resolves DNS queries *through* the tunnel.
 *
 * Every query is wrapped in DNS-over-TCP framing and sent over a tunnel stream
 * to a public resolver. This is what makes the optional "DNS mode" VPN useful:
 * a device's DNS lookups leave through the same tunnel as the rest of the
 * traffic would, rather than leaking to the local network.
 */
class DnsTunnelRelay(
    private val transportProvider: () -> TunnelTransport?,
    private val log: TunnelLog,
    private val upstreamHost: String = "1.1.1.1",
    private val upstreamPort: Int = 53,
) {
    fun resolve(query: ByteArray, timeoutMs: Int = 5000): ByteArray? {
        val transport = transportProvider()
        if (transport == null || !transport.isReady) return null
        repeat(2) { attempt ->
            val stream = transport.openStream(upstreamHost, upstreamPort, timeoutMs) ?: return@repeat
            try {
                val framed = ByteArray(query.size + 2)
                framed[0] = ((query.size ushr 8) and 0xFF).toByte()
                framed[1] = (query.size and 0xFF).toByte()
                System.arraycopy(query, 0, framed, 2, query.size)
                stream.write(framed)

                val header = ByteArray(2)
                var headerRead = 0
                val deadline = System.currentTimeMillis() + timeoutMs
                while (headerRead < 2 && System.currentTimeMillis() < deadline) {
                    val n = stream.read(header, headerRead, 2 - headerRead, 1000)
                    if (n < 0) return@repeat
                    headerRead += n
                }
                if (headerRead < 2) return@repeat
                val length = ((header[0].toInt() and 0xFF) shl 8) or (header[1].toInt() and 0xFF)
                val response = ByteArray(length)
                var read = 0
                while (read < length && System.currentTimeMillis() < deadline) {
                    val n = stream.read(response, read, length - read, 1000)
                    if (n < 0) break
                    read += n
                }
                if (read == length) return response
                log.debug("dns-relay", "short DNS response ($read/$length) on attempt ${attempt + 1}")
            } catch (e: Exception) {
                log.debug("dns-relay", "query failed: ${e.message}")
            } finally {
                runCatching { stream.close() }
            }
        }
        return null
    }
}
