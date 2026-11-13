package io.amtunnel.core.transport

/**
 * A tunnel frame (the inner VPN packet).
 *
 * Wire layout (see upstream `internal/vpnproto/parser.go`):
 * ```
 *   [0]      session id
 *   [1]      packet type
 *   [2..3]   stream id          (if the type has the stream extension)
 *   [+2]     sequence number    (if the type has the sequence extension)
 *   [+2]     fragment id, total (if the type has the fragment extension)
 *   [+1]     compression type   (if the type has the compression extension)
 *   [+1]     session cookie
 *   [+1]     header check byte
 *   [..]     payload
 * ```
 */
data class VpnFrame(
    val sessionId: Int,
    val packetType: Int,
    val sessionCookie: Int,
    val streamId: Int = 0,
    val sequenceNum: Int = 0,
    val fragmentId: Int = 0,
    val totalFragments: Int = 0,
    val compressionType: Int = CompressionType.OFF,
    val payload: ByteArray = ByteArray(0),
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is VpnFrame) return false
        return sessionId == other.sessionId &&
            packetType == other.packetType &&
            sessionCookie == other.sessionCookie &&
            streamId == other.streamId &&
            sequenceNum == other.sequenceNum &&
            fragmentId == other.fragmentId &&
            totalFragments == other.totalFragments &&
            compressionType == other.compressionType &&
            payload.contentEquals(other.payload)
    }

    override fun hashCode(): Int {
        var result = sessionId
        result = 31 * result + packetType
        result = 31 * result + sessionCookie
        result = 31 * result + streamId
        result = 31 * result + sequenceNum
        result = 31 * result + fragmentId
        result = 31 * result + totalFragments
        result = 31 * result + compressionType
        result = 31 * result + payload.contentHashCode()
        return result
    }

    fun describe(): String =
        "type=${PacketType.name(packetType)} session=$sessionId cookie=$sessionCookie " +
            "stream=$streamId sn=$sequenceNum frag=$fragmentId/$totalFragments bytes=${payload.size}"
}

class FrameException(message: String) : Exception(message)

object Frames {
    const val INTEGRITY_LENGTH = 2
    const val MIN_HEADER_LENGTH = 4

    fun headerLength(packetType: Int): Int {
        val flags = PacketFlags.of(packetType)
        if (flags and PacketFlags.VALID == 0) return 0
        var len = 2 + INTEGRITY_LENGTH
        if (flags and PacketFlags.STREAM != 0) len += 2
        if (flags and PacketFlags.SEQUENCE != 0) len += 2
        if (flags and PacketFlags.FRAGMENT != 0) len += 2
        if (flags and PacketFlags.COMPRESSION != 0) len += 1
        return len
    }

    /**
     * Header integrity byte. Mirrors `computeHeaderCheckByte`:
     * `acc = len*17 + 0x5D`, then per byte `acc += value + index; acc ^= value << (index & 3)`.
     */
    fun headerCheck(header: ByteArray, length: Int = header.size): Int {
        var acc = (length * 17 + 0x5D) and 0xFF
        for (i in 0 until length) {
            val value = header[i].toInt() and 0xFF
            acc = (acc + value + i) and 0xFF
            acc = acc xor ((value shl (i and 0x03)) and 0xFF)
        }
        return acc and 0xFF
    }

    fun build(frame: VpnFrame): ByteArray {
        val flags = PacketFlags.of(frame.packetType)
        if (flags and PacketFlags.VALID == 0) {
            throw FrameException("invalid packet type ${frame.packetType}")
        }
        val headerLength = headerLength(frame.packetType)
        val out = ByteArray(headerLength + frame.payload.size)
        out[0] = frame.sessionId.toByte()
        out[1] = frame.packetType.toByte()
        var offset = 2
        if (flags and PacketFlags.STREAM != 0) {
            out[offset] = ((frame.streamId ushr 8) and 0xFF).toByte()
            out[offset + 1] = (frame.streamId and 0xFF).toByte()
            offset += 2
        }
        if (flags and PacketFlags.SEQUENCE != 0) {
            out[offset] = ((frame.sequenceNum ushr 8) and 0xFF).toByte()
            out[offset + 1] = (frame.sequenceNum and 0xFF).toByte()
            offset += 2
        }
        if (flags and PacketFlags.FRAGMENT != 0) {
            out[offset] = frame.fragmentId.toByte()
            out[offset + 1] = frame.totalFragments.toByte()
            offset += 2
        }
        if (flags and PacketFlags.COMPRESSION != 0) {
            out[offset] = frame.compressionType.toByte()
            offset += 1
        }
        out[offset] = frame.sessionCookie.toByte()
        offset += 1
        out[offset] = headerCheck(out, offset).toByte()
        offset += 1
        System.arraycopy(frame.payload, 0, out, offset, frame.payload.size)
        return out
    }

    fun parse(data: ByteArray, start: Int = 0): VpnFrame {
        if (data.size - start < MIN_HEADER_LENGTH) throw FrameException("frame too short")
        val packetType = data[start + 1].toInt() and 0xFF
        val flags = PacketFlags.of(packetType)
        if (flags and PacketFlags.VALID == 0) throw FrameException("invalid packet type $packetType")

        var minLen = 2 + INTEGRITY_LENGTH
        if (flags and PacketFlags.STREAM != 0) minLen += 2
        if (flags and PacketFlags.SEQUENCE != 0) minLen += 2
        if (flags and PacketFlags.FRAGMENT != 0) minLen += 2
        if (flags and PacketFlags.COMPRESSION != 0) minLen += 1
        if (data.size - start < minLen) throw FrameException("frame too short for type $packetType")

        var offset = start + 2
        var streamId = 0
        var sequenceNum = 0
        var fragmentId = 0
        var totalFragments = 0
        var compressionType = CompressionType.OFF

        if (flags and PacketFlags.STREAM != 0) {
            streamId = ((data[offset].toInt() and 0xFF) shl 8) or (data[offset + 1].toInt() and 0xFF)
            offset += 2
        }
        if (flags and PacketFlags.SEQUENCE != 0) {
            sequenceNum = ((data[offset].toInt() and 0xFF) shl 8) or (data[offset + 1].toInt() and 0xFF)
            offset += 2
        }
        if (flags and PacketFlags.FRAGMENT != 0) {
            fragmentId = data[offset].toInt() and 0xFF
            totalFragments = data[offset + 1].toInt() and 0xFF
            offset += 2
        }
        if (flags and PacketFlags.COMPRESSION != 0) {
            compressionType = data[offset].toInt() and 0xFF
            offset += 1
        }

        val cookie = data[offset].toInt() and 0xFF
        val check = data[offset + 1].toInt() and 0xFF
        val expected = headerCheck(data.copyOfRange(start, offset + 1), offset + 1 - start)
        if (check != expected) {
            throw FrameException("header check mismatch: got=$check want=$expected")
        }

        val headerEnd = offset + INTEGRITY_LENGTH
        val payload = data.copyOfRange(headerEnd, data.size)
        return VpnFrame(
            sessionId = data[start].toInt() and 0xFF,
            packetType = packetType,
            sessionCookie = cookie,
            streamId = streamId,
            sequenceNum = sequenceNum,
            fragmentId = fragmentId,
            totalFragments = totalFragments,
            compressionType = compressionType,
            payload = payload,
        )
    }
}
