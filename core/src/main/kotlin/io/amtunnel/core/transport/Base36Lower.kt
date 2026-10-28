package io.amtunnel.core.transport

/**
 * Lower-case base36 block codec used to make tunnel frames DNS-label safe.
 *
 * Faithful port of `internal/basecodec/lowerbase36.go`:
 *  - input is processed in 7-byte blocks -> 11 base36 characters
 *  - a trailing partial block maps 1..6 bytes -> 2,4,5,7,8,10 characters
 *  - characters are `0-9a-z`, most significant first inside a block
 *
 * Every DNS label therefore only ever contains `[0-9a-z]`, which survives
 * case-insensitive resolvers and cannot be confused with a real hostname.
 */
object Base36Lower {
    private const val ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyz"
    private val ENC_CHARS_BY_BYTES = intArrayOf(0, 2, 4, 5, 7, 8, 10, 11)
    private val DEC_BYTES_BY_CHARS = intArrayOf(0, 0, 1, 0, 2, 3, 0, 4, 5, 0, 6, 7)

    private val DECODE = IntArray(256) { -1 }.also { table ->
        for (i in ALPHABET.indices) {
            table[ALPHABET[i].code] = i
            val upper = ALPHABET[i].uppercaseChar().code
            if (table[upper] == -1) table[upper] = i
        }
    }

    fun encodedLength(n: Int): Int {
        if (n <= 0) return 0
        return (n / 7) * 11 + ENC_CHARS_BY_BYTES[n % 7]
    }

    fun decodedLength(encodedLen: Int): Int {
        if (encodedLen <= 0) return 0
        val blocks = encodedLen / 11
        val rem = encodedLen % 11
        require(rem < DEC_BYTES_BY_CHARS.size) { "invalid base36 length: $encodedLen" }
        val decodedRem = DEC_BYTES_BY_CHARS[rem]
        require(rem == 0 || decodedRem != 0) { "invalid base36 length: $encodedLen" }
        return blocks * 7 + decodedRem
    }

    fun encode(data: ByteArray): String {
        if (data.isEmpty()) return ""
        val out = StringBuilder(encodedLength(data.size))
        var offset = 0
        while (offset + 7 <= data.size) {
            var value = 0L
            for (i in 0 until 7) {
                value = (value shl 8) or (data[offset + i].toLong() and 0xFF)
            }
            writeBlock(out, value, 11)
            offset += 7
        }
        val remaining = data.size - offset
        if (remaining > 0) {
            var value = 0L
            for (i in 0 until remaining) {
                value = (value shl 8) or (data[offset + i].toLong() and 0xFF)
            }
            writeBlock(out, value, ENC_CHARS_BY_BYTES[remaining])
        }
        return out.toString()
    }

    private fun writeBlock(out: StringBuilder, startValue: Long, count: Int) {
        var value = startValue
        val chars = CharArray(count)
        for (i in count - 1 downTo 0) {
            chars[i] = ALPHABET[(value % 36).toInt()]
            value /= 36
        }
        out.append(chars)
    }

    fun decode(encoded: String): ByteArray {
        if (encoded.isEmpty()) return ByteArray(0)
        val total = decodedLength(encoded.length)
        val out = ByteArray(total)
        var outOffset = 0
        var pos = 0
        while (pos < encoded.length) {
            val remaining = encoded.length - pos
            val charCount: Int
            val blockSize: Int
            if (remaining >= 11) {
                charCount = 11
                blockSize = 7
            } else {
                charCount = remaining
                blockSize = DEC_BYTES_BY_CHARS[remaining]
                require(blockSize != 0) { "invalid base36 tail length: $remaining" }
            }
            var value = 0L
            for (i in 0 until charCount) {
                val c = encoded[pos + i].code
                val digit = if (c in 0..255) DECODE[c] else -1
                require(digit >= 0) { "invalid base36 character at index ${pos + i}" }
                value = value * 36 + digit
            }
            for (i in blockSize - 1 downTo 0) {
                out[outOffset + i] = (value and 0xFF).toByte()
                value = value ushr 8
            }
            outOffset += blockSize
            pos += charCount
        }
        return out
    }
}
