package io.amtunnel.core.transport

/**
 * DNS envelope handling: turning an encoded tunnel frame into a TXT query for
 * `<labels>.<domain>` and pulling the tunnel frame back out of the TXT answers.
 *
 * Faithful port of the relevant parts of upstream `internal/dnsparser/transport.go`.
 */
object DnsEnvelope {
    const val MAX_DNS_NAME_LEN = 253
    const val MAX_DNS_LABEL_LEN = 63
    const val DEFAULT_EDNS_UDP_SIZE = 4096
    const val TYPE_TXT = 16
    const val TYPE_A = 1
    const val CLASS_IN = 1

    /** Magic (0 = raw TXT payloads, 1 = base64-wrapped TXT payloads). */
    const val RESPONSE_MODE_RAW = 0
    const val RESPONSE_MODE_BASE64 = 1

    fun normalizeDomain(domain: String): String =
        domain.trim().trimEnd('.').lowercase()

    fun encodeName(name: String): ByteArray {
        val trimmed = name.trim().trimEnd('.')
        if (trimmed.isEmpty()) return byteArrayOf(0)
        require(trimmed.length <= MAX_DNS_NAME_LEN) { "dns name too long: ${trimmed.length}" }
        val out = java.io.ByteArrayOutputStream(trimmed.length + 2)
        for (label in trimmed.split('.')) {
            require(label.isNotEmpty()) { "empty dns label in $name" }
            require(label.length <= MAX_DNS_LABEL_LEN) { "dns label too long: ${label.length}" }
            out.write(label.length)
            out.write(label.toByteArray(Charsets.US_ASCII))
        }
        out.write(0)
        return out.toByteArray()
    }

    /** Number of encoded characters that still fit into one QNAME for this domain. */
    fun maxEncodedChars(domain: String): Int {
        val domainLen = normalizeDomain(domain).length
        if (domainLen <= 0) return MAX_DNS_NAME_LEN
        var best = 0
        for (chars in 1..MAX_DNS_NAME_LEN) {
            if (encodedQNameLen(chars, domainLen) <= MAX_DNS_NAME_LEN) best = chars else break
        }
        return best
    }

    private fun encodedQNameLen(encodedChars: Int, domainLen: Int): Int {
        if (encodedChars <= 0) return domainLen
        val splits = (encodedChars - 1) / MAX_DNS_LABEL_LEN
        return encodedChars + splits + 1 + domainLen
    }

    private fun nextId(): Int = java.security.SecureRandom().nextInt(0x10000)

    /**
     * Builds a TXT question whose leftmost labels carry [encodedFrame].
     * `encodedFrame` must already be encrypted + base36 encoded.
     */
    fun buildTunnelQuery(
        domain: String,
        encodedFrame: ByteArray,
        ednsUdpSize: Int = DEFAULT_EDNS_UDP_SIZE,
        qType: Int = TYPE_TXT,
        id: Int = nextId(),
    ): ByteArray {
        val normalized = normalizeDomain(domain)
        require(normalized.isNotEmpty()) { "tunnel domain is empty" }
        val domainQname = encodeName(normalized)
        val encoded = String(encodedFrame, Charsets.US_ASCII)

        val out = java.io.ByteArrayOutputStream()
        val optLength = if (ednsUdpSize > 0) 11 else 0

        val nameLabels = java.io.ByteArrayOutputStream()
        if (encoded.isNotEmpty()) {
            var start = 0
            while (start < encoded.length) {
                val end = minOf(start + MAX_DNS_LABEL_LEN, encoded.length)
                val label = encoded.substring(start, end)
                nameLabels.write(label.length)
                nameLabels.write(label.toByteArray(Charsets.US_ASCII))
                start = end
            }
        }

        val qnameLength = nameLabels.size() + domainQname.size
        require(13 + qnameLength + 4 + optLength <= 65535) { "query too large" }
        val labelSplits = if (encoded.isEmpty()) 0 else (encoded.length - 1) / MAX_DNS_LABEL_LEN
        val qnameTextLen = encoded.length + labelSplits + 1 + normalized.length
        require(qnameTextLen <= MAX_DNS_NAME_LEN) {
            "tunnel qname exceeds DNS limits: $qnameTextLen > $MAX_DNS_NAME_LEN"
        }

        writeU16(out, id, 2)
        writeU16(out, 0x0100, 2) // flags: RD
        writeU16(out, 1, 2) // QDCOUNT
        writeU16(out, 0, 2) // ANCOUNT
        writeU16(out, 0, 2) // NSCOUNT
        writeU16(out, if (ednsUdpSize > 0) 1 else 0, 2) // ARCOUNT

        out.write(nameLabels.toByteArray())
        out.write(domainQname)
        writeU16(out, qType and 0xFFFF, 2)
        writeU16(out, CLASS_IN, 2)

        if (ednsUdpSize > 0) {
            out.write(0x00) // root name
            writeU16(out, 41, 2) // OPT
            writeU16(out, ednsUdpSize and 0xFFFF, 2)
            writeU16(out, 0, 4) // extended rcode / version / flags
            writeU16(out, 0, 2) // RDLEN
        }
        return out.toByteArray()
    }

    /** Plain (non-tunnel) query, used for resolver reachability probing. */
    fun buildSimpleQuery(name: String, qType: Int = TYPE_A, id: Int = nextId()): ByteArray {
        val out = java.io.ByteArrayOutputStream()
        writeU16(out, id, 2)
        writeU16(out, 0x0100, 2)
        writeU16(out, 1, 2)
        writeU16(out, 0, 2)
        writeU16(out, 0, 2)
        writeU16(out, 0, 2)
        out.write(encodeName(name))
        writeU16(out, qType and 0xFFFF, 2)
        writeU16(out, CLASS_IN, 2)
        return out.toByteArray()
    }

    /** The DNS transaction id of a message. */
    fun messageId(data: ByteArray): Int {
        require(data.size >= 2) { "dns message too short" }
        return ((data[0].toInt() and 0xFF) shl 8) or (data[1].toInt() and 0xFF)
    }

    fun rcode(data: ByteArray): Int {
        require(data.size >= 4) { "dns message too short" }
        return data[3].toInt() and 0x0F
    }

    fun answerCount(data: ByteArray): Int {
        require(data.size >= 8) { "dns message too short" }
        return ((data[6].toInt() and 0xFF) shl 8) or (data[7].toInt() and 0xFF)
    }

    class DnsMessage(
        val id: Int,
        val rcode: Int,
        val txtPayloads: List<ByteArray>,
        val aRecords: List<ByteArray>,
    )

    fun parseMessage(data: ByteArray): DnsMessage {
        require(data.size >= 12) { "dns message too short" }
        val id = messageId(data)
        val rcodeValue = data[3].toInt() and 0x0F
        val qdCount = readU16(data, 4)
        val anCount = readU16(data, 6)
        val nsCount = readU16(data, 8)
        val arCount = readU16(data, 10)

        var offset = 12
        repeat(qdCount) {
            offset = skipName(data, offset)
            offset += 4
            if (offset > data.size) throw FrameException("truncated question section")
        }

        val txt = ArrayList<ByteArray>()
        val a = ArrayList<ByteArray>()
        repeat(anCount) {
            offset = skipName(data, offset)
            if (offset + 10 > data.size) throw FrameException("truncated answer record")
            val rType = readU16(data, offset)
            val rdLength = readU16(data, offset + 8)
            val rdStart = offset + 10
            val rdEnd = rdStart + rdLength
            if (rdEnd > data.size) throw FrameException("truncated answer data")
            when (rType) {
                TYPE_TXT -> {
                    val raw = extractTxtStrings(data, rdStart, rdEnd)
                    if (raw.isNotEmpty()) txt.add(raw)
                }
                TYPE_A -> if (rdLength == 4) a.add(data.copyOfRange(rdStart, rdEnd))
            }
            offset = rdEnd
        }
        // Authority + additional sections are irrelevant for the tunnel, but must be skipped
        repeat(nsCount + arCount) {
            if (offset >= data.size) return@repeat
            offset = skipName(data, offset)
            if (offset + 10 > data.size) return@repeat
            val rdLength = readU16(data, offset + 8)
            offset += 10 + rdLength
        }
        return DnsMessage(id, rcodeValue, txt, a)
    }

    /**
     * Assembles the tunnel frame carried by a response.
     * Returns null when the response carries no tunnel payload.
     */
    fun extractFrame(message: DnsMessage, base64Payloads: Boolean = false): VpnFrame? {
        var payloads = message.txtPayloads
        if (payloads.isEmpty()) return null
        if (base64Payloads) {
            payloads = payloads.map { decodeRawBase64(it) }
        }
        return assembleFrame(payloads)
    }

    private fun assembleFrame(rawAnswers: List<ByteArray>): VpnFrame? {
        if (rawAnswers.isEmpty()) return null
        if (rawAnswers.size == 1) {
            val raw = rawAnswers[0]
            return try {
                Frames.parse(raw)
            } catch (e: FrameException) {
                null
            }
        }

        var totalExpected = 0
        var header: VpnFrame? = null
        val chunks = arrayOfNulls<ByteArray>(256)
        var seen = 0
        for (raw in rawAnswers) {
            if (raw.isEmpty()) continue
            if ((raw[0].toInt() and 0xFF) == 0x00) {
                if (raw.size < 3) return null
                totalExpected = raw[1].toInt() and 0xFF
                if (totalExpected <= 0 || totalExpected > chunks.size) return null
                val parsed = try {
                    Frames.parse(raw, 2)
                } catch (e: FrameException) {
                    return null
                }
                header = parsed
                if (chunks[0] == null) seen++
                chunks[0] = parsed.payload
                continue
            }
            val chunkId = raw[0].toInt() and 0xFF
            if (chunkId >= chunks.size) return null
            if (chunks[chunkId] == null) seen++
            chunks[chunkId] = raw.copyOfRange(1, raw.size)
        }
        val base = header ?: return null
        if (totalExpected <= 0 || seen != totalExpected) return null
        for (i in 0 until totalExpected) {
            if (chunks[i] == null) return null
        }
        for (i in totalExpected until chunks.size) {
            if (chunks[i] != null) return null
        }
        val payload = java.io.ByteArrayOutputStream()
        for (i in 0 until totalExpected) payload.write(chunks[i]!!)
        return base.copy(payload = payload.toByteArray())
    }

    /** Extracts the concatenated character-strings of a TXT RDATA section. */
    fun extractTxtStrings(data: ByteArray, start: Int, end: Int): ByteArray {
        if (end <= start) return ByteArray(0)
        val firstLen = data[start].toInt() and 0xFF
        if (firstLen + 1 == end - start) {
            return data.copyOfRange(start + 1, end)
        }
        val out = java.io.ByteArrayOutputStream(end - start)
        var offset = start
        while (offset < end) {
            val len = data[offset].toInt() and 0xFF
            offset++
            if (len == 0) continue
            if (offset + len > end) {
                out.write(data, offset, end - offset)
                break
            }
            out.write(data, offset, len)
            offset += len
        }
        return out.toByteArray()
    }

    fun encodeRawBase64(data: ByteArray): ByteArray =
        java.util.Base64.getEncoder().withoutPadding().encode(data)

    fun decodeRawBase64(data: ByteArray): ByteArray =
        java.util.Base64.getDecoder().decode(String(data, Charsets.US_ASCII))

    internal fun skipName(data: ByteArray, start: Int): Int {
        var offset = start
        while (true) {
            if (offset >= data.size) throw FrameException("truncated dns name")
            val len = data[offset].toInt() and 0xFF
            if (len == 0) return offset + 1
            if (len and 0xC0 == 0xC0) {
                if (offset + 2 > data.size) throw FrameException("truncated dns name pointer")
                return offset + 2
            }
            offset += 1 + len
        }
    }

    private fun readU16(data: ByteArray, at: Int): Int =
        ((data[at].toInt() and 0xFF) shl 8) or (data[at + 1].toInt() and 0xFF)

    private fun writeU16(out: java.io.ByteArrayOutputStream, value: Int, bytes: Int) {
        for (i in bytes - 1 downTo 0) {
            out.write((value ushr (8 * i)) and 0xFF)
        }
    }
}
