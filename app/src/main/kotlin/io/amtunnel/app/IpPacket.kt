package io.amtunnel.app

/**
 * Minimal IPv4/UDP helpers for DNS-mode capture.
 *
 * We only ever look at IPv4 + UDP port 53 and synthesise the matching reply,
 * so no TCP/IP stack is needed for this mode.
 */
object IpPacket {

    /** @return query payload, queried name (best effort) and udp payload length */
    data class DnsQuery(val payload: ByteArray, val name: String, val payloadLength: Int)

    fun extractDnsQuery(buffer: ByteArray, length: Int): DnsQuery? {
        if (length < 28) return null
        val version = (buffer[0].toInt() shr 4) and 0x0F
        if (version != 4) return null
        val ihl = (buffer[0].toInt() and 0x0F) * 4
        if (ihl < 20 || length < ihl + 8) return null
        val protocol = buffer[9].toInt() and 0xFF
        if (protocol != 17) return null // UDP only
        val totalLength = ((buffer[2].toInt() and 0xFF) shl 8) or (buffer[3].toInt() and 0xFF)
        val end = minOf(length, if (totalLength in 28..length) totalLength else length)
        val udpStart = ihl
        val dstPort = ((buffer[udpStart + 2].toInt() and 0xFF) shl 8) or (buffer[udpStart + 3].toInt() and 0xFF)
        if (dstPort != 53) return null
        val udpLength = ((buffer[udpStart + 4].toInt() and 0xFF) shl 8) or (buffer[udpStart + 5].toInt() and 0xFF)
        if (udpLength < 8 || udpStart + udpLength > end) return null
        val payload = buffer.copyOfRange(udpStart + 8, udpStart + udpLength)
        if (payload.size < 12) return null
        return DnsQuery(payload, questionName(payload), udpLength - 8)
    }

    fun questionName(query: ByteArray): String {
        val sb = StringBuilder()
        var offset = 12
        while (offset < query.size) {
            val len = query[offset].toInt() and 0xFF
            offset++
            if (len == 0) break
            if (offset + len > query.size) break
            if (sb.isNotEmpty()) sb.append('.')
            sb.append(String(query, offset, len, Charsets.US_ASCII))
            offset += len
        }
        return sb.toString()
    }

    /** Builds the reply packet for a captured query (addresses/ports swapped). */
    fun buildUdpResponse(request: ByteArray, requestLength: Int, payload: ByteArray): ByteArray {
        val ihl = (request[0].toInt() and 0x0F) * 4
        val udpStart = ihl
        val udpLength = 8 + payload.size
        val totalLength = ihl + udpLength
        val out = ByteArray(totalLength)

        // IPv4 header
        out[0] = ((4 shl 4) or (ihl / 4)).toByte()
        out[1] = request[1] // DSCP/ECN
        out[2] = ((totalLength ushr 8) and 0xFF).toByte()
        out[3] = (totalLength and 0xFF).toByte()
        out[4] = 0; out[5] = 0 // identification
        out[6] = 0; out[7] = 0 // flags + fragment offset
        out[8] = 64 // TTL
        out[9] = 17 // UDP
        // checksum at 10..11 filled later
        // swap source and destination
        System.arraycopy(request, 16, out, 12, 4) // dst of request -> src of reply
        System.arraycopy(request, 12, out, 16, 4) // src of request -> dst of reply
        val checksum = ipChecksum(out, ihl)
        out[10] = ((checksum ushr 8) and 0xFF).toByte()
        out[11] = (checksum and 0xFF).toByte()

        // UDP header: swap ports
        System.arraycopy(request, udpStart + 2, out, udpStart, 2) // src port of request -> dst port
        System.arraycopy(request, udpStart, out, udpStart + 2, 2) // dst port of request -> src port
        out[udpStart + 4] = ((udpLength ushr 8) and 0xFF).toByte()
        out[udpStart + 5] = (udpLength and 0xFF).toByte()
        out[udpStart + 6] = 0; out[udpStart + 7] = 0 // checksum optional for IPv4
        System.arraycopy(payload, 0, out, udpStart + 8, payload.size)
        return out
    }

    private fun ipChecksum(data: ByteArray, length: Int): Int {
        var sum = 0
        var i = 0
        while (i + 1 < length) {
            sum += ((data[i].toInt() and 0xFF) shl 8) or (data[i + 1].toInt() and 0xFF)
            i += 2
        }
        if (i < length) sum += (data[i].toInt() and 0xFF) shl 8
        while (sum shr 16 != 0) {
            sum = (sum and 0xFFFF) + (sum shr 16)
        }
        return sum.inv() and 0xFFFF
    }
}
