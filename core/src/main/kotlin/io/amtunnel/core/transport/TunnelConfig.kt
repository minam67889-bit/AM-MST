package io.amtunnel.core.transport

/**
 * Everything the client needs to join a tunnel. These are exactly the values a
 * server operator publishes for a MasterDnsVPN-compatible endpoint:
 * the tunnel domain, the encryption method and the shared key.
 */
data class TunnelConfig(
    val domain: String,
    val encryptionMethod: Int = EncryptionMethod.XOR,
    val encryptionKey: String = "",
    /** Max raw frame bytes the client will place in one query. */
    val uploadMtu: Int = 120,
    /** Advertised download capability (server side chunking hint). */
    val downloadMtu: Int = 1200,
    val queryTimeoutMs: Int = 2500,
    val retryCount: Int = 3,
    val pingIntervalMs: Long = 12000,
    val responseMode: Int = DnsEnvelope.RESPONSE_MODE_RAW,
    val ednsUdpSize: Int = DnsEnvelope.DEFAULT_EDNS_UDP_SIZE,
    /**
     * MasterDnsVPN `PACKET_DUPLICATION_COUNT`: send every frame to this many
     * distinct resolvers. 1 = no duplication. The server ignores duplicate
     * sequence numbers, so this only costs upload bandwidth, never correctness.
     */
    val packetDuplication: Int = 1,
    /** MasterDnsVPN `MIN_UPLOAD_MTU` / `MAX_UPLOAD_MTU` - clamp for MTU probing. */
    val minUploadMtu: Int = 32,
    val maxUploadMtu: Int = 180,
) {
    fun validate(): List<String> {
        val problems = ArrayList<String>()
        if (DnsEnvelope.normalizeDomain(domain).isEmpty()) problems.add("tunnel domain is empty")
        if (encryptionMethod !in 0..5) problems.add("unsupported encryption method $encryptionMethod")
        if (encryptionMethod != EncryptionMethod.NONE && encryptionKey.isEmpty()) {
            problems.add("encryption key is required for ${EncryptionMethod.name(encryptionMethod)}")
        }
        if (uploadMtu < 32) problems.add("upload MTU too small ($uploadMtu)")
        if (queryTimeoutMs < 200) problems.add("query timeout too small (${queryTimeoutMs}ms)")
        if (responseMode !in 0..1) problems.add("invalid response mode $responseMode")
        if (packetDuplication !in 1..8) problems.add("packet duplication must be 1..8")
        if (minUploadMtu > maxUploadMtu) problems.add("min upload MTU exceeds max upload MTU")
        if (uploadMtu > maxUploadMtu) problems.add("upload MTU $uploadMtu exceeds max ${maxUploadMtu}")
        return problems
    }

    val compressionPair: Int get() = (CompressionType.OFF shl 4) or CompressionType.OFF
}
