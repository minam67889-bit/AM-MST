package io.amtunnel.core.transport

import java.security.MessageDigest
import javax.crypto.Cipher
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec

/**
 * Payload codec: encrypt-then-base36 (upload direction) and
 * base36-then-decrypt (download direction), matching `internal/security/codec.go`.
 *
 * Note a protocol asymmetry that was established from the server source:
 * only client -> server frames are encrypted. Server -> client frames are
 * written into TXT records as plain frames (optionally base64-wrapped so more
 * bytes fit into one TXT record). [decodeAndDecrypt] is therefore used for
 * building/validating uploads, while response parsing reads plain frames.
 */
interface PayloadCodec {
    val method: Int
    fun encryptAndEncode(raw: ByteArray): ByteArray
    fun decodeAndDecrypt(encoded: ByteArray): ByteArray
}

object CodecFactory {
    fun create(method: Int, rawKey: String): PayloadCodec {
        val keyBytes = rawKey.toByteArray(Charsets.UTF_8)
        return when (method) {
            EncryptionMethod.NONE -> IdentityCodec
            EncryptionMethod.XOR -> XorCodec(padKey(keyBytes, 32))
            EncryptionMethod.CHACHA20 -> ChaCha20Codec(sha256(keyBytes))
            EncryptionMethod.AES_128_GCM -> AesGcmCodec(md5(keyBytes))
            EncryptionMethod.AES_192_GCM -> AesGcmCodec(padKey(keyBytes, 24))
            EncryptionMethod.AES_256_GCM -> AesGcmCodec(sha256(keyBytes))
            else -> throw IllegalArgumentException("unsupported encryption method: $method")
        }
    }

    private fun padKey(key: ByteArray, size: Int): ByteArray {
        val out = ByteArray(size)
        System.arraycopy(key, 0, out, 0, minOf(key.size, size))
        return out
    }

    internal fun sha256(data: ByteArray): ByteArray =
        MessageDigest.getInstance("SHA-256").digest(data)

    internal fun md5(data: ByteArray): ByteArray =
        MessageDigest.getInstance("MD5").digest(data)
}

private object IdentityCodec : PayloadCodec {
    override val method = EncryptionMethod.NONE
    override fun encryptAndEncode(raw: ByteArray): ByteArray =
        Base36Lower.encode(raw).toByteArray(Charsets.US_ASCII)

    override fun decodeAndDecrypt(encoded: ByteArray): ByteArray =
        Base36Lower.decode(String(encoded, Charsets.US_ASCII))
}

private class XorCodec(private val key: ByteArray) : PayloadCodec {
    override val method = EncryptionMethod.XOR

    override fun encryptAndEncode(raw: ByteArray): ByteArray =
        Base36Lower.encode(xor(raw)).toByteArray(Charsets.US_ASCII)

    override fun decodeAndDecrypt(encoded: ByteArray): ByteArray =
        xor(Base36Lower.decode(String(encoded, Charsets.US_ASCII)))

    private fun xor(data: ByteArray): ByteArray {
        if (data.isEmpty()) return data
        val out = ByteArray(data.size)
        for (i in data.indices) {
            out[i] = (data[i].toInt() xor key[i % key.size].toInt()).toByte()
        }
        return out
    }
}

/**
 * ChaCha20 (RFC 7539) with a 16-byte wire nonce: the first 4 bytes are a
 * little-endian block counter, the remaining 12 bytes are the nonce.
 */
private class ChaCha20Codec(private val key: ByteArray) : PayloadCodec {
    override val method = EncryptionMethod.CHACHA20

    override fun encryptAndEncode(raw: ByteArray): ByteArray {
        if (raw.isEmpty()) return ByteArray(0)
        val nonce = ByteArray(16)
        val counter = java.security.SecureRandom().nextInt()
        nonce[0] = (counter and 0xFF).toByte()
        nonce[1] = ((counter ushr 8) and 0xFF).toByte()
        nonce[2] = ((counter ushr 16) and 0xFF).toByte()
        nonce[3] = ((counter ushr 24) and 0xFF).toByte()
        val random = ByteArray(12)
        java.security.SecureRandom().nextBytes(random)
        System.arraycopy(random, 0, nonce, 4, 12)

        val body = ChaCha20.xor(key, nonce.copyOfRange(4, 16), counter, raw)
        val framed = ByteArray(16 + body.size)
        System.arraycopy(nonce, 0, framed, 0, 16)
        System.arraycopy(body, 0, framed, 16, body.size)
        return Base36Lower.encode(framed).toByteArray(Charsets.US_ASCII)
    }

    override fun decodeAndDecrypt(encoded: ByteArray): ByteArray {
        val framed = Base36Lower.decode(String(encoded, Charsets.US_ASCII))
        require(framed.size > 16) { "chacha20 ciphertext too short" }
        val counter = (framed[0].toInt() and 0xFF) or
            ((framed[1].toInt() and 0xFF) shl 8) or
            ((framed[2].toInt() and 0xFF) shl 16) or
            ((framed[3].toInt() and 0xFF) shl 24)
        val nonce = framed.copyOfRange(4, 16)
        val ciphertext = framed.copyOfRange(16, framed.size)
        return ChaCha20.xor(key, nonce, counter, ciphertext)
    }
}

private class AesGcmCodec(private val key: ByteArray) : PayloadCodec {
    override val method = EncryptionMethod.AES_128_GCM
    private val tagBits = 128

    override fun encryptAndEncode(raw: ByteArray): ByteArray {
        if (raw.isEmpty()) return ByteArray(0)
        val nonce = ByteArray(12)
        java.security.SecureRandom().nextBytes(nonce)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.ENCRYPT_MODE, SecretKeySpec(key, "AES"), GCMParameterSpec(tagBits, nonce))
        val sealed = cipher.doFinal(raw)
        val framed = ByteArray(nonce.size + sealed.size)
        System.arraycopy(nonce, 0, framed, 0, nonce.size)
        System.arraycopy(sealed, 0, framed, nonce.size, sealed.size)
        return Base36Lower.encode(framed).toByteArray(Charsets.US_ASCII)
    }

    override fun decodeAndDecrypt(encoded: ByteArray): ByteArray {
        val framed = Base36Lower.decode(String(encoded, Charsets.US_ASCII))
        require(framed.size > 12) { "aes-gcm ciphertext too short" }
        val nonce = framed.copyOfRange(0, 12)
        val cipher = Cipher.getInstance("AES/GCM/NoPadding")
        cipher.init(Cipher.DECRYPT_MODE, SecretKeySpec(key, "AES"), GCMParameterSpec(tagBits, nonce))
        return cipher.doFinal(framed, 12, framed.size - 12)
    }
}

/** Minimal ChaCha20 block-function implementation (no Poly1305, as upstream). */
object ChaCha20 {
    private fun rotl(x: Int, n: Int): Int = (x shl n) or (x ushr (32 - n))

    private fun qr(s: IntArray, a: Int, b: Int, c: Int, d: Int) {
        s[a] += s[b]; s[d] = rotl(s[d] xor s[a], 16)
        s[c] += s[d]; s[b] = rotl(s[b] xor s[c], 12)
        s[a] += s[b]; s[d] = rotl(s[d] xor s[a], 8)
        s[c] += s[d]; s[b] = rotl(s[b] xor s[c], 7)
    }

    private fun le32(src: ByteArray, off: Int): Int =
        (src[off].toInt() and 0xFF) or
            ((src[off + 1].toInt() and 0xFF) shl 8) or
            ((src[off + 2].toInt() and 0xFF) shl 16) or
            ((src[off + 3].toInt() and 0xFF) shl 24)

    fun xor(key: ByteArray, nonce: ByteArray, initialCounter: Int, data: ByteArray): ByteArray {
        require(key.size == 32) { "chacha20 key must be 32 bytes" }
        require(nonce.size == 12) { "chacha20 nonce must be 12 bytes" }
        if (data.isEmpty()) return ByteArray(0)

        val state = IntArray(16)
        state[0] = 0x61707865
        state[1] = 0x3320646e
        state[2] = 0x79622d32
        state[3] = 0x6b206574
        for (i in 0 until 8) state[4 + i] = le32(key, i * 4)
        for (i in 0 until 3) state[13 + i] = le32(nonce, i * 4)

        val working = IntArray(16)
        val out = ByteArray(data.size)
        var counter = initialCounter
        var offset = 0
        while (offset < data.size) {
            state[12] = counter
            System.arraycopy(state, 0, working, 0, 16)
            repeat(10) {
                qr(working, 0, 4, 8, 12)
                qr(working, 1, 5, 9, 13)
                qr(working, 2, 6, 10, 14)
                qr(working, 3, 7, 11, 15)
                qr(working, 0, 5, 10, 15)
                qr(working, 1, 6, 11, 12)
                qr(working, 2, 7, 8, 13)
                qr(working, 3, 4, 9, 14)
            }
            for (i in 0 until 16) working[i] += state[i]
            val chunk = minOf(64, data.size - offset)
            for (i in 0 until chunk) {
                val word = working[i / 4]
                val shift = (i % 4) * 8
                out[offset + i] = (data[offset + i].toInt() xor ((word ushr shift) and 0xFF)).toByte()
            }
            offset += 64
            counter++
        }
        return out
    }
}
