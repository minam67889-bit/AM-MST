package io.amtunnel.core.transport

/**
 * Explicit placeholder for the AM Tunnel adapter.
 *
 * The DNS engine in this repository is transport-agnostic: it only needs a
 * [TunnelTransport] plus a [ResolverSelector]. Implementing AM Tunnel support
 * means writing this one class, once the original client's protocol has been
 * identified from its APK (`docs/REPORT.md` §2 lists the exact steps).
 *
 * Why it is not implemented here
 * ------------------------------
 * The APK could not be obtained in the build environment (the file host is not
 * reachable and GitHub release assets are blocked), so the protocol is unknown.
 * Guessing it - SlowDNS, DNSTT, a custom framing, or the MasterDnsVPN dialect
 * already implemented in [MasterDnsTransport] - would produce a client that
 * silently fails, or worse, one that "connects" against the wrong server.
 *
 * This class intentionally fails loudly instead of pretending to work.
 */
class AmTunnelTransport(
    private val reason: String = DEFAULT_REASON,
) : TunnelTransport {

    override val isReady: Boolean = false

    override fun start(timeoutMs: Int): Boolean {
        throw UnsupportedOperationException(reason)
    }

    override fun stop() = Unit

    override fun openStream(host: String, port: Int, timeoutMs: Int): TunnelStream? {
        throw UnsupportedOperationException(reason)
    }

    override fun stats(): TransportStats =
        TransportStats(state = TransportState.FAILED, currentResolver = "-")

    override fun toString(): String = "AmTunnelTransport(not implemented: $reason)"

    companion object {
        const val DEFAULT_REASON: String =
            "AM Tunnel transport is not implemented: the original APK was not available in the " +
                "build environment, so its protocol could not be identified. See docs/REPORT.md."
    }
}
