package io.amtunnel.core.dns

import io.amtunnel.core.net.SocketProtector
import io.amtunnel.core.transport.TunnelConfig
import io.amtunnel.core.transport.TunnelSession
import io.amtunnel.core.util.TunnelLog

/**
 * Answers the question "will this resolver actually carry my tunnel?".
 *
 * A normal reachability probe is not enough: a resolver (or a transparent DNS
 * proxy) can answer `A` queries perfectly while dropping, truncating or
 * cache-poisoning the TXT payload traffic the tunnel depends on. The only
 * honest test is to run a real SESSION_INIT through the resolver and require a
 * valid SESSION_ACCEPT whose verify code matches.
 */
class TunnelCapabilityProbe(
    private val config: TunnelConfig,
    private val log: TunnelLog,
    private val protector: SocketProtector = SocketProtector.Noop,
) {
    data class Result(
        val capable: Boolean,
        val handshakeMs: Long,
        val detail: String,
    )

    fun probe(endpoint: ResolverEndpoint): Result {
        val session = TunnelSession(config, log, protector)
        return try {
            when (val outcome = session.initialize(endpoint, attempts = 1)) {
                is TunnelSession.InitOutcome.Success -> Result(true, outcome.handshakeMs, "handshake ok")
                is TunnelSession.InitOutcome.Busy -> Result(true, outcome.handshakeMs, "server busy (reachable)")
                is TunnelSession.InitOutcome.Failure -> Result(false, -1, outcome.error)
            }
        } catch (e: Exception) {
            Result(false, -1, e.message ?: e.javaClass.simpleName)
        } finally {
            runCatching { session.sendClose(endpoint) }
        }
    }
}
