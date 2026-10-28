package io.amtunnel.core.dns

/** Where a resolver entry came from. */
enum class ResolverSource { MANUAL, IMPORTED, BUILTIN }

/** Result of the last thing we learned about a resolver. */
enum class ResolverStatus {
    /** No data yet. */
    UNKNOWN,

    /** Answers DNS and can carry tunnel traffic. */
    HEALTHY,

    /** Answers DNS, but slow / lossy. */
    DEGRADED,

    /** Does not answer DNS at all. */
    UNREACHABLE,

    /**
     * Answers ordinary DNS queries but did not complete a tunnel handshake.
     * This is the case that a plain "ping the resolver" scan cannot detect:
     * a hijacking/forwarding resolver may answer `A` queries happily while
     * silently dropping the tunnel's TXT payload traffic.
     */
    TUNNEL_INCAPABLE,

    DISABLED,
}

/**
 * A candidate DNS resolver endpoint.
 *
 * `key` is the stable identity used for statistics and persistence.
 */
data class ResolverEndpoint(
    val address: String,
    val port: Int = 53,
    val label: String = "",
    val source: ResolverSource = ResolverSource.MANUAL,
    val enabled: Boolean = true,
) {
    val key: String get() = formatKey(address, port)

    val display: String get() = if (label.isBlank()) key else "$label ($key)"

    fun withEnabled(value: Boolean): ResolverEndpoint = copy(enabled = value)

    companion object {
        fun formatKey(address: String, port: Int): String {
            val host = address.trim().lowercase()
            return if (host.contains(':')) "[$host]:$port" else "$host:$port"
        }

        /**
         * Parses one resolver entry. Accepts `1.1.1.1`, `1.1.1.1:5353`,
         * `[2606:4700::1111]:53`, `dns.example.net` and `label=1.1.1.1:53`.
         */
        fun parse(text: String, source: ResolverSource = ResolverSource.MANUAL): ResolverEndpoint? {
            var raw = text.trim()
            if (raw.isEmpty() || raw.startsWith("#") || raw.startsWith("//")) return null
            var label = ""
            val eq = raw.indexOf('=')
            if (eq > 0 && !raw.substring(0, eq).contains(':') && !raw.substring(0, eq).contains('.')) {
                label = raw.substring(0, eq).trim()
                raw = raw.substring(eq + 1).trim()
            }
            if (raw.isEmpty()) return null

            var host = raw
            var port = 53
            if (raw.startsWith("[")) {
                val close = raw.indexOf(']')
                if (close < 0) return null
                host = raw.substring(1, close)
                if (close + 1 < raw.length && raw[close + 1] == ':') {
                    port = raw.substring(close + 2).toIntOrNull() ?: return null
                }
            } else {
                val colonCount = raw.count { it == ':' }
                if (colonCount == 1) {
                    val idx = raw.lastIndexOf(':')
                    val maybePort = raw.substring(idx + 1)
                    val parsed = maybePort.toIntOrNull()
                    if (parsed != null) {
                        host = raw.substring(0, idx)
                        port = parsed
                    }
                }
                // colonCount > 1 without brackets => bare IPv6 literal, keep as-is
            }
            host = host.trim()
            if (host.isEmpty()) return null
            if (port !in 1..65535) return null
            if (!isValidHost(host)) return null
            return ResolverEndpoint(address = host, port = port, label = label, source = source)
        }

        private fun isValidHost(host: String): Boolean {
            if (host.contains(':')) {
                // IPv6 literal: require hex digits and colons only
                return host.all { it.isDigit() || it in "abcdefABCDEF" || it == ':' || it == '.' }
            }
            val labels = host.split('.')
            if (labels.any { it.isEmpty() }) return false
            return labels.all { part -> part.all { it.isLetterOrDigit() || it == '-' || it == '_' } }
        }

        /** Bulk import: split on newlines / commas / semicolons / whitespace. */
        fun parseMany(text: String, source: ResolverSource = ResolverSource.IMPORTED): List<ResolverEndpoint> {
            val seen = LinkedHashMap<String, ResolverEndpoint>()
            text.split('\n', '\r', ',', ';', '\t', ' ')
                .map { it.trim() }
                .filter { it.isNotEmpty() }
                .forEach { part ->
                    val endpoint = parse(part, source) ?: return@forEach
                    seen.putIfAbsent(endpoint.key, endpoint)
                }
            return seen.values.toList()
        }
    }
}
