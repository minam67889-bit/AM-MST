package io.amtunnel.core.transport

import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.net.SocketProtector
import io.amtunnel.core.net.UdpExchange
import io.amtunnel.core.net.UdpExchangeException
import io.amtunnel.core.util.TunnelLog

/**
 * One tunnel session.
 *
 * The session lives on the *server*: `session id` + `session cookie` are handed
 * out once by SESSION_ACCEPT and are then carried in every frame header. Because
 * the server keys its state by those two bytes (see upstream
 * `internal/udpserver/server_session.go`, `sessions.Lookup(id)` +
 * `lookup.Cookie != vpnPacket.SessionCookie`), the client can send the same
 * session through a *different* DNS resolver at any time - the resolver is only
 * a forwarder. That property is what makes resolver failover possible without
 * tearing down the tunnel.
 */
class TunnelSession(
    val config: TunnelConfig,
    private val log: TunnelLog,
    private val protector: SocketProtector = SocketProtector.Noop,
) {
    private val codec: PayloadCodec = CodecFactory.create(config.encryptionMethod, config.encryptionKey)
    private val maxEncodedChars = DnsEnvelope.maxEncodedChars(config.domain)

    var sessionId: Int = 0
        private set
    var sessionCookie: Int = 0
        private set
    private var verifyCode: ByteArray = ByteArray(4)

    var uploadMtu: Int = config.uploadMtu
        private set
    var downloadMtu: Int = config.downloadMtu
        private set

    /** Server policy learned from SESSION_ACCEPT (when the server sends it). */
    var serverMaxUploadMtu: Int = 0
        private set
    var serverMaxDownloadMtu: Int = 0
        private set

    val isReady: Boolean get() = sessionId != 0

    private val cryptoOverhead: Int
        get() = when (config.encryptionMethod) {
            EncryptionMethod.CHACHA20 -> 16
            EncryptionMethod.AES_128_GCM, EncryptionMethod.AES_192_GCM, EncryptionMethod.AES_256_GCM -> 28
            EncryptionMethod.XOR -> 0
            else -> 0
        }

    /** Largest raw frame that still fits into one QNAME for this domain. */
    fun maxFrameBytesForName(): Int = maxRawForEncodedChars(maxEncodedChars)

    private fun maxRawForEncodedChars(chars: Int): Int {
        var best = 0
        var n = 0
        while (n <= 512) {
            if (Base36Lower.encodedLength(n + cryptoOverhead) <= chars) best = n else break
            n++
        }
        return best
    }

    /** Effective per-packet frame budget: min(upload MTU, QNAME budget). */
    fun frameBudget(): Int = minOf(uploadMtu, maxFrameBytesForName()).coerceAtLeast(16)

    /** Max payload for a packet type, accounting for its header size. */
    fun payloadBudget(packetType: Int): Int =
        (frameBudget() - Frames.headerLength(packetType)).coerceAtLeast(0)

    fun debugInfo(): String =
        "session=$sessionId cookie=$sessionCookie uploadMtu=$uploadMtu downloadMtu=$downloadMtu " +
            "frameBudget=${frameBudget()} qnameChars=$maxEncodedChars enc=${EncryptionMethod.name(config.encryptionMethod)}"

    sealed class InitOutcome {
        data class Success(val handshakeMs: Long, val acceptPayload: ByteArray) : InitOutcome()
        data class Busy(val handshakeMs: Long) : InitOutcome()
        data class Failure(val error: String, val attempts: Int) : InitOutcome()
    }

    class Exchange(
        val frame: VpnFrame?,
        val rttMs: Long,
        val rcode: Int,
        val answered: Boolean,
    )

    /** Builds + encodes + sends one frame and decodes the reply frame, if any. */
    fun exchange(
        frame: VpnFrame,
        endpoint: ResolverEndpoint,
        timeoutMs: Int = config.queryTimeoutMs,
    ): Exchange {
        val raw = Frames.build(frame)
        if (raw.size > frameBudget() && frame.packetType != PacketType.SESSION_INIT) {
            log.warn(
                "session",
                "frame ${raw.size}B exceeds budget ${frameBudget()}B for ${PacketType.name(frame.packetType)}",
            )
        }
        val encoded = codec.encryptAndEncode(raw)
        val id = java.security.SecureRandom().nextInt(0x10000)
        val query = DnsEnvelope.buildTunnelQuery(
            config.domain, encoded, config.ednsUdpSize, DnsEnvelope.TYPE_TXT, id,
        )
        val result = UdpExchange.exchange(
            endpoint.address, endpoint.port, query, timeoutMs, id, protector,
        )
        val message = DnsEnvelope.parseMessage(result.response)
        val responseFrame = try {
            DnsEnvelope.extractFrame(message, config.responseMode == DnsEnvelope.RESPONSE_MODE_BASE64)
        } catch (e: Exception) {
            log.debug("session", "unparsable tunnel payload from ${endpoint.key}: ${e.message}")
            null
        }
        return Exchange(responseFrame, result.rttMs, message.rcode, answered = true)
    }

    /**
     * SESSION_INIT handshake. Returns Success only when the server echoed our
     * verify code, which also proves the resolver forwards TXT payloads.
     */
    fun initialize(endpoint: ResolverEndpoint, attempts: Int = config.retryCount): InitOutcome {
        var lastError = "no response"
        var usedAttempts = 0
        val verify = ByteArray(4)
        java.security.SecureRandom().nextBytes(verify)
        verifyCode = verify

        val payload = ByteArray(10)
        payload[0] = config.responseMode.toByte()
        payload[1] = config.compressionPair.toByte()
        payload[2] = ((config.uploadMtu ushr 8) and 0xFF).toByte()
        payload[3] = (config.uploadMtu and 0xFF).toByte()
        payload[4] = ((config.downloadMtu ushr 8) and 0xFF).toByte()
        payload[5] = (config.downloadMtu and 0xFF).toByte()
        System.arraycopy(verify, 0, payload, 6, 4)

        val frame = VpnFrame(
            sessionId = 0,
            packetType = PacketType.SESSION_INIT,
            sessionCookie = 0,
            payload = payload,
        )

        repeat(maxOf(1, attempts)) { attempt ->
            usedAttempts = attempt + 1
            try {
                val started = System.nanoTime()
                val exchange = exchange(frame, endpoint, config.queryTimeoutMs)
                val handshakeMs = (System.nanoTime() - started) / 1_000_000L
                val response = exchange.frame
                if (response == null) {
                    lastError = "resolver answered (rcode=${exchange.rcode}) but carried no tunnel frame"
                    return@repeat
                }
                when (response.packetType) {
                    PacketType.SESSION_ACCEPT -> {
                        if (response.payload.size < 7) {
                            lastError = "short SESSION_ACCEPT payload (${response.payload.size}B)"
                            return@repeat
                        }
                        val echoed = response.payload.copyOfRange(3, 7)
                        if (!echoed.contentEquals(verify)) {
                            lastError = "verify code mismatch - wrong encryption key or foreign server"
                            return@repeat
                        }
                        sessionId = response.payload[0].toInt() and 0xFF
                        sessionCookie = response.payload[1].toInt() and 0xFF
                        if (response.payload.size >= 20) {
                            val policy = response.payload.copyOfRange(7, 20)
                            serverMaxUploadMtu = policy[1].toInt() and 0xFF
                            serverMaxDownloadMtu =
                                ((policy[2].toInt() and 0xFF) shl 8) or (policy[3].toInt() and 0xFF)
                            if (serverMaxUploadMtu in 1 until uploadMtu) uploadMtu = serverMaxUploadMtu
                            if (serverMaxDownloadMtu in 1 until downloadMtu) downloadMtu = serverMaxDownloadMtu
                        }
                        log.info(
                            "session",
                            "handshake ok via ${endpoint.key}: ${handshakeMs}ms, id=$sessionId, " +
                                "cookie=$sessionCookie, uploadMtu=$uploadMtu, downloadMtu=$downloadMtu",
                        )
                        return InitOutcome.Success(handshakeMs, response.payload)
                    }
                    PacketType.SESSION_BUSY -> {
                        log.warn("session", "server busy via ${endpoint.key}")
                        return InitOutcome.Busy(handshakeMs)
                    }
                    else -> {
                        lastError = "unexpected reply ${PacketType.name(response.packetType)}"
                    }
                }
            } catch (e: UdpExchangeException) {
                lastError = "no answer from ${endpoint.key}: ${e.message}"
            } catch (e: Exception) {
                lastError = e.message ?: e.javaClass.simpleName
            }
        }
        return InitOutcome.Failure(lastError, usedAttempts)
    }

    /** Fire-and-forget session teardown so the server frees the slot immediately. */
    fun sendClose(endpoint: ResolverEndpoint) {
        if (!isReady) return
        val frame = VpnFrame(
            sessionId = sessionId,
            packetType = PacketType.SESSION_CLOSE,
            sessionCookie = sessionCookie,
            payload = ByteArray(0),
        )
        runCatching { exchange(frame, endpoint, 700) }
        sessionId = 0
        sessionCookie = 0
    }

    /** Used by the capability probe to validate a resolver without keeping state. */
    fun reset() {
        sessionId = 0
        sessionCookie = 0
    }
}
