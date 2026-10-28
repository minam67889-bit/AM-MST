package io.amtunnel.core

import io.amtunnel.core.transport.Base36Lower
import io.amtunnel.core.transport.CodecFactory
import io.amtunnel.core.transport.CompressionType
import io.amtunnel.core.transport.DnsEnvelope
import io.amtunnel.core.transport.EncryptionMethod
import io.amtunnel.core.transport.FrameException
import io.amtunnel.core.transport.Frames
import io.amtunnel.core.transport.PacketFlags
import io.amtunnel.core.transport.PacketType
import io.amtunnel.core.transport.VpnFrame
import org.junit.Assert.assertArrayEquals
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class Base36Test {
    private val vector = byteArrayOf(0x00, 0x01, 0x02, 0x10, 0x20, 0x30, 0x40, 0xFE.toByte(), 0xFF.toByte())

    @Test
    fun `round trips arbitrary bytes`() {
        val encoded = Base36Lower.encode(vector)
        assertArrayEquals(vector, Base36Lower.decode(encoded))
    }

    @Test
    fun `encoded output is lowercase alphanumeric only`() {
        val encoded = Base36Lower.encode("MasterDnsVPN-123".toByteArray())
        assertTrue(encoded.isNotEmpty())
        assertTrue(encoded.all { it in 'a'..'z' || it in '0'..'9' })
    }

    @Test
    fun `length mapping matches upstream tables`() {
        // 7 bytes -> 11 chars, and the documented remainder map.
        assertEquals(11, Base36Lower.encodedLength(7))
        assertEquals(22, Base36Lower.encodedLength(14))
        assertEquals(2, Base36Lower.encodedLength(1))
        assertEquals(4, Base36Lower.encodedLength(2))
        assertEquals(5, Base36Lower.encodedLength(3))
        assertEquals(7, Base36Lower.encodedLength(4))
        assertEquals(8, Base36Lower.encodedLength(5))
        assertEquals(10, Base36Lower.encodedLength(6))
        assertEquals(0, Base36Lower.encodedLength(0))
    }

    @Test
    fun `decoded length inverts encoded length`() {
        for (n in 1..40) {
            assertEquals(n, Base36Lower.decodedLength(Base36Lower.encodedLength(n)))
        }
    }

    @Test
    fun `round trips every length from 1 to 40`() {
        for (n in 1..40) {
            val data = ByteArray(n) { (it * 7 + 3).toByte() }
            val decoded = Base36Lower.decode(Base36Lower.encode(data))
            assertArrayEquals("length $n", data, decoded)
        }
    }

    @Test
    fun `accepts uppercase input like upstream`() {
        val encoded = Base36Lower.encode(vector).uppercase()
        assertArrayEquals(vector, Base36Lower.decode(encoded))
    }

    @Test
    fun `rejects invalid characters`() {
        for (sample in listOf("abc-123", "abc=", "abc_")) {
            try {
                Base36Lower.decode(sample)
                fail("expected rejection of $sample")
            } catch (e: IllegalArgumentException) {
                // expected
            }
        }
    }
}

class FrameTest {
    @Test
    fun `session init frame round trip`() {
        val payload = byteArrayOf(0, 0, 0, 120, 4, 176.toByte(), 1, 2, 3, 4)
        val frame = VpnFrame(
            sessionId = 7,
            packetType = PacketType.SESSION_INIT,
            sessionCookie = 9,
            payload = payload,
        )
        val raw = Frames.build(frame)
        // SESSION_INIT: 2 fixed + cookie + check = 4 bytes header
        assertEquals(4 + payload.size, raw.size)
        val parsed = Frames.parse(raw)
        assertEquals(frame, parsed)
    }

    @Test
    fun `stream data frame round trip`() {
        val payload = "hello tunnel".toByteArray()
        val frame = VpnFrame(
            sessionId = 42,
            packetType = PacketType.STREAM_DATA,
            sessionCookie = 17,
            streamId = 40000,
            sequenceNum = 1234,
            fragmentId = 0,
            totalFragments = 1,
            compressionType = CompressionType.OFF,
            payload = payload,
        )
        val raw = Frames.build(frame)
        assertEquals(Frames.headerLength(PacketType.STREAM_DATA) + payload.size, raw.size)
        val parsed = Frames.parse(raw)
        assertEquals(frame, parsed)
        assertEquals(40000, parsed.streamId)
        assertEquals(1234, parsed.sequenceNum)
    }

    @Test
    fun `header lengths match the upstream table`() {
        assertEquals(4, Frames.headerLength(PacketType.SESSION_INIT))
        assertEquals(4, Frames.headerLength(PacketType.PING))
        assertEquals(4, Frames.headerLength(PacketType.SESSION_CLOSE))
        assertEquals(4, Frames.headerLength(PacketType.MTU_UP_RES))
        assertEquals(10, Frames.headerLength(PacketType.SOCKS5_SYN))
        assertEquals(11, Frames.headerLength(PacketType.STREAM_DATA))
        assertEquals(8, Frames.headerLength(PacketType.STREAM_DATA_ACK))
        assertEquals(8, Frames.headerLength(PacketType.SOCKS5_CONNECTED))
    }

    @Test
    fun `flags match the upstream table`() {
        // MTU_UP_REQ has every extension
        val flags = PacketFlags.of(PacketType.MTU_UP_REQ)
        assertTrue(flags and PacketFlags.VALID != 0)
        assertTrue(flags and PacketFlags.STREAM != 0)
        assertTrue(flags and PacketFlags.SEQUENCE != 0)
        assertTrue(flags and PacketFlags.FRAGMENT != 0)
        assertTrue(flags and PacketFlags.COMPRESSION != 0)
        // PING is header-only
        assertEquals(PacketFlags.VALID, PacketFlags.of(PacketType.PING))
        // DATA_ACK: stream + sequence, no fragment/compression
        assertEquals(
            PacketFlags.VALID or PacketFlags.STREAM or PacketFlags.SEQUENCE,
            PacketFlags.of(PacketType.STREAM_DATA_ACK),
        )
        // Unknown type is invalid
        assertFalse(PacketFlags.valid(0x7F))
    }

    @Test
    fun `header check byte rejects corruption`() {
        val frame = VpnFrame(1, PacketType.PING, 2)
        val raw = Frames.build(frame)
        raw[raw.size - 1] = (raw[raw.size - 1].toInt() xor 0x55).toByte()
        try {
            Frames.parse(raw)
            fail("expected header check failure")
        } catch (e: FrameException) {
            assertTrue(e.message!!.contains("header check"))
        }
    }

    @Test
    fun `check byte is deterministic and covers the cookie`() {
        val a = Frames.build(VpnFrame(5, PacketType.PING, 1))
        val b = Frames.build(VpnFrame(5, PacketType.PING, 2))
        assertFalse(a.contentEquals(b))
    }
}

class CodecTest {
    private val plaintext = ("frame-bytes-" + "x".repeat(80)).toByteArray()

    @Test
    fun `none codec is identity plus base36`() {
        val codec = CodecFactory.create(EncryptionMethod.NONE, "")
        val encoded = codec.encryptAndEncode(plaintext)
        assertTrue(String(encoded).all { it in 'a'..'z' || it in '0'..'9' })
        assertArrayEquals(plaintext, codec.decodeAndDecrypt(encoded))
    }

    @Test
    fun `xor codec round trips`() {
        val codec = CodecFactory.create(EncryptionMethod.XOR, "secret-key")
        val encoded = codec.encryptAndEncode(plaintext)
        assertFalse(encoded.contentEquals(plaintext))
        assertArrayEquals(plaintext, codec.decodeAndDecrypt(encoded))
    }

    @Test
    fun `chacha20 codec round trips and is randomized`() {
        val codec = CodecFactory.create(EncryptionMethod.CHACHA20, "key-material")
        val first = codec.encryptAndEncode(plaintext)
        val second = codec.encryptAndEncode(plaintext)
        assertFalse(first.contentEquals(second))
        assertArrayEquals(plaintext, codec.decodeAndDecrypt(first))
        assertArrayEquals(plaintext, codec.decodeAndDecrypt(second))
    }

    @Test
    fun `aes gcm codecs round trip`() {
        for (method in listOf(EncryptionMethod.AES_128_GCM, EncryptionMethod.AES_192_GCM, EncryptionMethod.AES_256_GCM)) {
            val codec = CodecFactory.create(method, "another-key")
            val encoded = codec.encryptAndEncode(plaintext)
            assertArrayEquals("method $method", plaintext, codec.decodeAndDecrypt(encoded))
        }
    }

    @Test
    fun `chacha20 keystream matches the rfc 8439 test vector`() {
        // RFC 8439 2.4.2 test vector: key/nonce/counter -> first keystream bytes.
        val key = ByteArray(32) { it.toByte() }
        val nonce = byteArrayOf(
            0, 0, 0, 0x09, 0, 0, 0, 0x4a, 0, 0, 0, 0,
        )
        val counter = 1
        val keystream = io.amtunnel.core.transport.ChaCha20.xor(key, nonce, counter, ByteArray(64))
        val expectedFirst16 = byteArrayOf(
            0x10, 0xf1.toByte(), 0xe7.toByte(), 0xe4.toByte(), 0xd1.toByte(), 0x3b, 0x59, 0x15,
            0x50, 0x0f, 0xdd.toByte(), 0x1f, 0xa3.toByte(), 0x20, 0x71, 0xc4.toByte(),
        )
        assertArrayEquals(expectedFirst16, keystream.copyOfRange(0, 16))
    }
}

class DnsEnvelopeTest {
    private val domain = "t.example.com"

    @Test
    fun `builds a well formed txt query`() {
        val encoded = Base36Lower.encode(ByteArray(40) { it.toByte() }).toByteArray()
        val query = DnsEnvelope.buildTunnelQuery(domain, encoded, 4096, DnsEnvelope.TYPE_TXT, 0x1234)
        assertEquals(0x12, query[0].toInt() and 0xFF)
        assertEquals(0x34, query[1].toInt() and 0xFF)
        assertEquals(0x01, query[2].toInt() and 0xFF) // RD flag
        assertEquals(1, (query[4].toInt() and 0xFF) shl 8 or (query[5].toInt() and 0xFF)) // QDCOUNT
        assertEquals(1, (query[10].toInt() and 0xFF) shl 8 or (query[11].toInt() and 0xFF)) // ARCOUNT (EDNS)

        // Walk the QNAME on the wire (length-prefixed labels, not dot separated).
        var offset = 12
        val labels = ArrayList<String>()
        while (offset < query.size) {
            val len = query[offset].toInt() and 0xFF
            offset++
            if (len == 0) break
            labels.add(String(query, offset, len, Charsets.US_ASCII))
            offset += len
        }
        assertEquals("t.example.com", labels.takeLast(3).joinToString("."), "wire labels: $labels")
        assertEquals(
            Base36Lower.encode(ByteArray(40) { it.toByte() }),
            labels.dropLast(3).joinToString(""),
            "payload labels must carry the base36 frame",
        )
        val payloadLabels = labels.dropLast(3).joinToString("")
        assertTrue(
            "payload labels must only contain [0-9a-z]",
            payloadLabels.all { it in '0'..'9' || it in 'a'..'z' },
        )
    }

    @Test
    fun `max encoded chars respects the 253 byte name limit`() {
        val max = DnsEnvelope.maxEncodedChars(domain)
        assertTrue(max in 150..253)
        val encoded = ByteArray(max) { 'a'.code.toByte() }
        // must fit
        DnsEnvelope.buildTunnelQuery(domain, encoded, 0, DnsEnvelope.TYPE_TXT, 1)
        // one byte more must not fit
        try {
            DnsEnvelope.buildTunnelQuery(domain, ByteArray(max + 1) { 'a'.code.toByte() }, 0, DnsEnvelope.TYPE_TXT, 1)
            fail("expected qname overflow")
        } catch (e: IllegalArgumentException) {
            assertTrue(e.message!!.contains("DNS limits") || e.message!!.contains("too large"))
        }
    }

    @Test
    fun `parses a single chunk response`() {
        val frame = VpnFrame(
            sessionId = 3,
            packetType = PacketType.SOCKS5_CONNECTED,
            sessionCookie = 4,
            streamId = 9,
            sequenceNum = 0,
        )
        val raw = Frames.build(frame)
        val response = buildResponse(raw)
        val message = DnsEnvelope.parseMessage(response)
        assertEquals(1, message.txtPayloads.size)
        val parsed = DnsEnvelope.extractFrame(message)
        assertNotNull(parsed)
        assertEquals(frame.packetType, parsed!!.packetType)
        assertEquals(frame.streamId, parsed.streamId)
    }

    @Test
    fun `parses a multi chunk response`() {
        val header = VpnFrame(
            sessionId = 3,
            packetType = PacketType.STREAM_DATA,
            sessionCookie = 4,
            streamId = 9,
            sequenceNum = 5,
            fragmentId = 0,
            totalFragments = 1,
            payload = "0123456789abcdefg".toByteArray(),
        )
        val raw = Frames.build(header)
        val headerLength = Frames.headerLength(PacketType.STREAM_DATA)
        val firstData = raw.copyOfRange(headerLength, headerLength + 6)
        val rest = raw.copyOfRange(headerLength + 6, raw.size)

        val chunk0 = ByteArray(2 + headerLength + firstData.size)
        chunk0[0] = 0
        chunk0[1] = 2
        System.arraycopy(raw, 0, chunk0, 2, headerLength)
        System.arraycopy(firstData, 0, chunk0, 2 + headerLength, firstData.size)

        val chunk1 = ByteArray(1 + rest.size)
        chunk1[0] = 1
        System.arraycopy(rest, 0, chunk1, 1, rest.size)

        val response = buildResponse(listOf(chunk0, chunk1))
        val parsed = DnsEnvelope.extractFrame(DnsEnvelope.parseMessage(response))
        assertNotNull(parsed)
        assertArrayEquals("0123456789abcdefg".toByteArray(), parsed!!.payload)
    }

    @Test
    fun `ignores responses without txt payload`() {
        val response = buildResponse(emptyList())
        val message = DnsEnvelope.parseMessage(response)
        assertNull(DnsEnvelope.extractFrame(message))
    }

    private fun buildResponse(vararg payloads: ByteArray) = buildResponse(payloads.toList())

    private fun buildResponse(payloads: List<ByteArray>): ByteArray {
        val out = java.io.ByteArrayOutputStream()
        // header: id, flags (QR=1, RD/RA), QD=1, AN=n, NS=0, AR=0
        out.write(0x12); out.write(0x34)
        out.write(0x81); out.write(0x80)
        out.write(0x00); out.write(0x01)
        out.write(0x00); out.write(payloads.size)
        out.write(0x00); out.write(0x00)
        out.write(0x00); out.write(0x00)
        // question: tunnel domain, TXT, IN
        out.write(DnsEnvelope.encodeName(domain))
        out.write(0x00); out.write(0x10)
        out.write(0x00); out.write(0x01)
        for (payload in payloads) {
            out.write(0xC0); out.write(0x0C) // pointer to question name
            out.write(0x00); out.write(0x10) // TXT
            out.write(0x00); out.write(0x01) // IN
            out.write(0x00); out.write(0x00); out.write(0x00); out.write(0x00) // TTL
            val rdlen = payload.size + 1 + (payload.size / 255)
            out.write((rdlen ushr 8) and 0xFF); out.write(rdlen and 0xFF)
            var offset = 0
            while (offset < payload.size) {
                val chunk = minOf(255, payload.size - offset)
                out.write(chunk)
                out.write(payload, offset, chunk)
                offset += chunk
            }
        }
        return out.toByteArray()
    }
}
