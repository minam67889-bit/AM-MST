package io.amtunnel.core.transport

/**
 * Packet type identifiers of the DNS tunnel protocol implemented by the
 * MasterDnsVPN client/server pair (MIT, masterking32/MasterDnsVPN).
 *
 * These values are taken verbatim from the upstream `internal/enums/dns.go`.
 */
object PacketType {
    const val MTU_UP_REQ = 0x01
    const val MTU_UP_RES = 0x02
    const val MTU_DOWN_REQ = 0x03
    const val MTU_DOWN_RES = 0x04

    const val SESSION_INIT = 0x05
    const val SESSION_ACCEPT = 0x06
    const val PING = 0x07
    const val PONG = 0x08

    const val STREAM_SYN = 0x09
    const val STREAM_SYN_ACK = 0x0A
    const val STREAM_CONNECTED = 0x0B
    const val STREAM_CONNECTED_ACK = 0x0C
    const val STREAM_CONNECT_FAIL = 0x0D
    const val STREAM_CONNECT_FAIL_ACK = 0x0E
    const val STREAM_DATA = 0x0F
    const val STREAM_DATA_ACK = 0x10
    const val STREAM_DATA_NACK = 0x11
    const val STREAM_RESEND = 0x12
    const val PACKED_CONTROL_BLOCKS = 0x13
    const val STREAM_CLOSE_WRITE = 0x14
    const val STREAM_CLOSE_WRITE_ACK = 0x15
    const val STREAM_CLOSE_READ = 0x16
    const val STREAM_CLOSE_READ_ACK = 0x17
    const val STREAM_RST = 0x18
    const val STREAM_RST_ACK = 0x19

    const val SOCKS5_SYN = 0x1A
    const val SOCKS5_SYN_ACK = 0x1B

    const val SOCKS5_CONNECT_FAIL = 0x1C
    const val SOCKS5_CONNECT_FAIL_ACK = 0x1D
    const val SOCKS5_RULESET_DENIED = 0x1E
    const val SOCKS5_RULESET_DENIED_ACK = 0x1F
    const val SOCKS5_NETWORK_UNREACHABLE = 0x20
    const val SOCKS5_NETWORK_UNREACHABLE_ACK = 0x21
    const val SOCKS5_HOST_UNREACHABLE = 0x22
    const val SOCKS5_HOST_UNREACHABLE_ACK = 0x23
    const val SOCKS5_CONNECTION_REFUSED = 0x24
    const val SOCKS5_CONNECTION_REFUSED_ACK = 0x25
    const val SOCKS5_TTL_EXPIRED = 0x26
    const val SOCKS5_TTL_EXPIRED_ACK = 0x27
    const val SOCKS5_COMMAND_UNSUPPORTED = 0x28
    const val SOCKS5_COMMAND_UNSUPPORTED_ACK = 0x29
    const val SOCKS5_ADDRESS_TYPE_UNSUPPORTED = 0x2A
    const val SOCKS5_ADDRESS_TYPE_UNSUPPORTED_ACK = 0x2B
    const val SOCKS5_AUTH_FAILED = 0x2C
    const val SOCKS5_AUTH_FAILED_ACK = 0x2D
    const val SOCKS5_UPSTREAM_UNAVAILABLE = 0x2E
    const val SOCKS5_UPSTREAM_UNAVAILABLE_ACK = 0x2F
    const val SOCKS5_CONNECTED = 0x30
    const val SOCKS5_CONNECTED_ACK = 0x31

    const val DNS_QUERY_REQ = 0x32
    const val DNS_QUERY_RES = 0x33
    const val DNS_QUERY_REQ_ACK = 0x34
    const val DNS_QUERY_RES_ACK = 0x35

    const val SESSION_CLOSE = 0x36
    const val SESSION_BUSY = 0x37

    const val ERROR_DROP = 0xFF

    fun name(type: Int): String = when (type) {
        MTU_UP_REQ -> "MTU_UP_REQ"
        MTU_UP_RES -> "MTU_UP_RES"
        MTU_DOWN_REQ -> "MTU_DOWN_REQ"
        MTU_DOWN_RES -> "MTU_DOWN_RES"
        SESSION_INIT -> "SESSION_INIT"
        SESSION_ACCEPT -> "SESSION_ACCEPT"
        SESSION_BUSY -> "SESSION_BUSY"
        PING -> "PING"
        PONG -> "PONG"
        STREAM_SYN -> "STREAM_SYN"
        STREAM_SYN_ACK -> "STREAM_SYN_ACK"
        STREAM_CONNECTED -> "STREAM_CONNECTED"
        STREAM_CONNECTED_ACK -> "STREAM_CONNECTED_ACK"
        STREAM_CONNECT_FAIL -> "STREAM_CONNECT_FAIL"
        STREAM_CONNECT_FAIL_ACK -> "STREAM_CONNECT_FAIL_ACK"
        STREAM_DATA -> "STREAM_DATA"
        STREAM_DATA_ACK -> "STREAM_DATA_ACK"
        STREAM_DATA_NACK -> "STREAM_DATA_NACK"
        STREAM_CLOSE_WRITE -> "STREAM_CLOSE_WRITE"
        STREAM_CLOSE_WRITE_ACK -> "STREAM_CLOSE_WRITE_ACK"
        STREAM_CLOSE_READ -> "STREAM_CLOSE_READ"
        STREAM_CLOSE_READ_ACK -> "STREAM_CLOSE_READ_ACK"
        STREAM_RST -> "STREAM_RST"
        STREAM_RST_ACK -> "STREAM_RST_ACK"
        SOCKS5_SYN -> "SOCKS5_SYN"
        SOCKS5_SYN_ACK -> "SOCKS5_SYN_ACK"
        SOCKS5_CONNECTED -> "SOCKS5_CONNECTED"
        SOCKS5_CONNECTED_ACK -> "SOCKS5_CONNECTED_ACK"
        SOCKS5_CONNECT_FAIL -> "SOCKS5_CONNECT_FAIL"
        SOCKS5_HOST_UNREACHABLE -> "SOCKS5_HOST_UNREACHABLE"
        SOCKS5_CONNECTION_REFUSED -> "SOCKS5_CONNECTION_REFUSED"
        SOCKS5_NETWORK_UNREACHABLE -> "SOCKS5_NETWORK_UNREACHABLE"
        SOCKS5_UPSTREAM_UNAVAILABLE -> "SOCKS5_UPSTREAM_UNAVAILABLE"
        DNS_QUERY_REQ -> "DNS_QUERY_REQ"
        DNS_QUERY_RES -> "DNS_QUERY_RES"
        DNS_QUERY_REQ_ACK -> "DNS_QUERY_REQ_ACK"
        DNS_QUERY_RES_ACK -> "DNS_QUERY_RES_ACK"
        SESSION_CLOSE -> "SESSION_CLOSE"
        PACKED_CONTROL_BLOCKS -> "PACKED_CONTROL_BLOCKS"
        ERROR_DROP -> "ERROR_DROP"
        else -> "0x%02X".format(type)
    }

    /** All SOCKS5 failure result codes, mapped to their acknowledgement type. */
    fun socksFailureAck(type: Int): Int? = when (type) {
        SOCKS5_CONNECT_FAIL -> SOCKS5_CONNECT_FAIL_ACK
        SOCKS5_RULESET_DENIED -> SOCKS5_RULESET_DENIED_ACK
        SOCKS5_NETWORK_UNREACHABLE -> SOCKS5_NETWORK_UNREACHABLE_ACK
        SOCKS5_HOST_UNREACHABLE -> SOCKS5_HOST_UNREACHABLE_ACK
        SOCKS5_CONNECTION_REFUSED -> SOCKS5_CONNECTION_REFUSED_ACK
        SOCKS5_TTL_EXPIRED -> SOCKS5_TTL_EXPIRED_ACK
        SOCKS5_COMMAND_UNSUPPORTED -> SOCKS5_COMMAND_UNSUPPORTED_ACK
        SOCKS5_ADDRESS_TYPE_UNSUPPORTED -> SOCKS5_ADDRESS_TYPE_UNSUPPORTED_ACK
        SOCKS5_AUTH_FAILED -> SOCKS5_AUTH_FAILED_ACK
        SOCKS5_UPSTREAM_UNAVAILABLE -> SOCKS5_UPSTREAM_UNAVAILABLE_ACK
        else -> null
    }

    fun isSocksFailure(type: Int): Boolean = socksFailureAck(type) != null
}

/**
 * Per-packet-type header extension table, mirroring `buildPacketFlags()` in
 * upstream `internal/vpnproto/parser.go`.
 */
object PacketFlags {
    const val VALID = 1
    const val STREAM = 1 shl 1
    const val SEQUENCE = 1 shl 2
    const val FRAGMENT = 1 shl 3
    const val COMPRESSION = 1 shl 4

    private val table = IntArray(256)

    init {
        val validOnly = intArrayOf(
            PacketType.MTU_UP_RES, PacketType.MTU_DOWN_REQ, PacketType.SESSION_INIT,
            PacketType.SESSION_ACCEPT, PacketType.SESSION_BUSY, PacketType.SESSION_CLOSE,
            PacketType.PING, PacketType.PONG, PacketType.ERROR_DROP,
            PacketType.MTU_UP_REQ, PacketType.MTU_DOWN_RES,
        )
        for (t in validOnly) table[t] = table[t] or VALID

        val streamAndSeq = intArrayOf(
            PacketType.STREAM_SYN, PacketType.STREAM_SYN_ACK, PacketType.STREAM_DATA,
            PacketType.STREAM_DATA_ACK, PacketType.STREAM_DATA_NACK, PacketType.STREAM_RESEND,
            PacketType.STREAM_CLOSE_WRITE, PacketType.STREAM_CLOSE_WRITE_ACK,
            PacketType.STREAM_CLOSE_READ, PacketType.STREAM_CLOSE_READ_ACK,
            PacketType.STREAM_RST, PacketType.STREAM_RST_ACK,
            PacketType.MTU_UP_REQ, PacketType.MTU_DOWN_RES,
            PacketType.SOCKS5_SYN, PacketType.SOCKS5_SYN_ACK,
            PacketType.STREAM_CONNECTED, PacketType.STREAM_CONNECTED_ACK,
            PacketType.STREAM_CONNECT_FAIL, PacketType.STREAM_CONNECT_FAIL_ACK,
            PacketType.SOCKS5_CONNECT_FAIL, PacketType.SOCKS5_CONNECT_FAIL_ACK,
            PacketType.SOCKS5_RULESET_DENIED, PacketType.SOCKS5_RULESET_DENIED_ACK,
            PacketType.SOCKS5_NETWORK_UNREACHABLE, PacketType.SOCKS5_NETWORK_UNREACHABLE_ACK,
            PacketType.SOCKS5_HOST_UNREACHABLE, PacketType.SOCKS5_HOST_UNREACHABLE_ACK,
            PacketType.SOCKS5_CONNECTION_REFUSED, PacketType.SOCKS5_CONNECTION_REFUSED_ACK,
            PacketType.SOCKS5_TTL_EXPIRED, PacketType.SOCKS5_TTL_EXPIRED_ACK,
            PacketType.SOCKS5_COMMAND_UNSUPPORTED, PacketType.SOCKS5_COMMAND_UNSUPPORTED_ACK,
            PacketType.SOCKS5_ADDRESS_TYPE_UNSUPPORTED, PacketType.SOCKS5_ADDRESS_TYPE_UNSUPPORTED_ACK,
            PacketType.SOCKS5_AUTH_FAILED, PacketType.SOCKS5_AUTH_FAILED_ACK,
            PacketType.SOCKS5_UPSTREAM_UNAVAILABLE, PacketType.SOCKS5_UPSTREAM_UNAVAILABLE_ACK,
            PacketType.SOCKS5_CONNECTED, PacketType.SOCKS5_CONNECTED_ACK,
            PacketType.DNS_QUERY_REQ, PacketType.DNS_QUERY_RES,
            PacketType.DNS_QUERY_REQ_ACK, PacketType.DNS_QUERY_RES_ACK,
        )
        for (t in streamAndSeq) table[t] = table[t] or (VALID or STREAM or SEQUENCE)

        val frag = intArrayOf(
            PacketType.STREAM_DATA, PacketType.STREAM_RESEND, PacketType.SOCKS5_SYN,
            PacketType.DNS_QUERY_REQ, PacketType.DNS_QUERY_RES,
            PacketType.DNS_QUERY_REQ_ACK, PacketType.DNS_QUERY_RES_ACK,
            PacketType.MTU_UP_REQ, PacketType.MTU_DOWN_RES,
        )
        for (t in frag) table[t] = table[t] or FRAGMENT

        val comp = intArrayOf(
            PacketType.STREAM_DATA, PacketType.STREAM_RESEND, PacketType.PACKED_CONTROL_BLOCKS,
            PacketType.DNS_QUERY_REQ, PacketType.DNS_QUERY_RES,
            PacketType.MTU_UP_REQ, PacketType.MTU_DOWN_RES,
        )
        for (t in comp) table[t] = table[t] or (VALID or COMPRESSION)
    }

    fun of(type: Int): Int = table[type and 0xFF]
    fun valid(type: Int): Boolean = (of(type) and VALID) != 0
    fun hasStream(type: Int): Boolean = (of(type) and STREAM) != 0
    fun hasSequence(type: Int): Boolean = (of(type) and SEQUENCE) != 0
    fun hasFragment(type: Int): Boolean = (of(type) and FRAGMENT) != 0
    fun hasCompression(type: Int): Boolean = (of(type) and COMPRESSION) != 0
}

/** Encryption methods, identical to the server's `DATA_ENCRYPTION_METHOD`. */
object EncryptionMethod {
    const val NONE = 0
    const val XOR = 1
    const val CHACHA20 = 2
    const val AES_128_GCM = 3
    const val AES_192_GCM = 4
    const val AES_256_GCM = 5

    fun name(m: Int): String = when (m) {
        NONE -> "NONE"
        XOR -> "XOR"
        CHACHA20 -> "ChaCha20"
        AES_128_GCM -> "AES-128-GCM"
        AES_192_GCM -> "AES-192-GCM"
        AES_256_GCM -> "AES-256-GCM"
        else -> "UNKNOWN($m)"
    }
}

/** Compression types (we always negotiate OFF, but the parser must understand them). */
object CompressionType {
    const val OFF = 0
    const val ZSTD = 1
    const val LZ4 = 2
    const val ZLIB = 3
}

internal fun u8(v: Int): Int = v and 0xFF
internal fun u16hi(v: Int): Int = (v ushr 8) and 0xFF
internal fun u16lo(v: Int): Int = v and 0xFF
