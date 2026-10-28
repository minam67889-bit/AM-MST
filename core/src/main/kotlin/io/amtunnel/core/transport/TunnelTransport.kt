package io.amtunnel.core.transport

import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.dns.ResolverHealthMonitor

enum class TransportState { IDLE, INITIALIZING, READY, DEGRADED, RECOVERING, STOPPED, FAILED }

data class TransportStats(
    val state: TransportState = TransportState.IDLE,
    val packetsSent: Long = 0,
    val responsesReceived: Long = 0,
    val retransmits: Long = 0,
    val timeouts: Long = 0,
    val bytesUp: Long = 0,
    val bytesDown: Long = 0,
    val lastRttMs: Long = -1,
    val resolverSwitches: Int = 0,
    val recoveries: Int = 0,
    val activeStreams: Int = 0,
    val currentResolver: String = "-",
    val sessionId: Int = -1,
    /** Frames put on the wire through [TunnelConfig.packetDuplication]. */
    val duplicatesSent: Long = 0,
)

/**
 * Abstraction over "something that can carry a TCP stream to a host".
 *
 * The DNS engine (resolvers, scanning, ranking, failover) knows nothing about
 * this interface's implementation; [MasterDnsTransport] is one implementation.
 * A different upstream transport (for example the original AM Tunnel engine
 * once its protocol is confirmed from the APK) can be dropped in without
 * touching the resolver manager.
 */
interface TunnelTransport {
    fun start(timeoutMs: Int): Boolean
    fun stop()
    fun openStream(host: String, port: Int, timeoutMs: Int): TunnelStream?
    fun stats(): TransportStats
    val isReady: Boolean
}

interface TunnelStream {
    fun write(data: ByteArray, offset: Int = 0, length: Int = data.size): Int
    /** @return bytes read, 0 on timeout, -1 on EOF. */
    fun read(buffer: ByteArray, offset: Int = 0, length: Int = buffer.size, timeoutMs: Int = 1000): Int
    fun close()
}

/** Selector used by the transport to pick (and fail over between) resolvers. */
interface ResolverSelector {
    /** Resolvers ordered best-first. */
    fun ranked(): List<ResolverEndpoint>

    /** One resolver for the next packet (balancing strategy lives here). */
    fun next(excluded: Set<String> = emptySet()): ResolverEndpoint? =
        ranked().firstOrNull { it.key !in excluded }

    /** N distinct resolvers for a duplicated packet. */
    fun targets(count: Int, excluded: Set<String> = emptySet()): List<ResolverEndpoint> =
        ranked().filter { it.key !in excluded }.take(count.coerceAtLeast(1))

    /** One packet handed to this resolver (needed for the loss ratio). */
    fun reportSend(endpoint: ResolverEndpoint) {}

    fun reportSuccess(endpoint: ResolverEndpoint, rttMs: Long)
    fun reportFailure(endpoint: ResolverEndpoint, reason: String)
    fun notifyResolverChanged(endpoint: ResolverEndpoint?) {}
}

class HealthResolverSelector(private val monitor: ResolverHealthMonitor) : ResolverSelector {
    override fun ranked(): List<ResolverEndpoint> = monitor.rankedCandidates()
    override fun reportSuccess(endpoint: ResolverEndpoint, rttMs: Long) =
        monitor.reportRuntimeSuccess(endpoint, rttMs)

    override fun reportFailure(endpoint: ResolverEndpoint, reason: String) =
        monitor.reportRuntimeFailure(endpoint, reason)
}

/**
 * Bridges the ported MasterDnsVPN balancer to the transport. All strategy and
 * scoring logic lives in [MasterBalancer]; this only translates endpoints.
 */
class BalancerResolverSelector(val balancer: MasterBalancer) : ResolverSelector {
    override fun ranked(): List<ResolverEndpoint> = balancer.activeEndpoints()

    override fun next(excluded: Set<String>): ResolverEndpoint? =
        balancer.nextKey(excluded)?.let { balancer.endpointFor(it) }

    override fun targets(count: Int, excluded: Set<String>): List<ResolverEndpoint> =
        balancer.selectTargets(count, excluded).mapNotNull { balancer.endpointFor(it) }

    override fun reportSend(endpoint: ResolverEndpoint) = balancer.reportSend(endpoint.key)

    override fun reportSuccess(endpoint: ResolverEndpoint, rttMs: Long) =
        balancer.reportSuccess(endpoint.key, rttMs)

    /** Routes through the auto-disable rule, not just a loss counter. */
    override fun reportFailure(endpoint: ResolverEndpoint, reason: String) {
        balancer.reportTimeout(endpoint.key)
    }

    override fun notifyResolverChanged(endpoint: ResolverEndpoint?) {}
}

/** Fixed single-resolver selector (manual mode, matches the original app UX). */
class StaticResolverSelector(private val endpoint: ResolverEndpoint) : ResolverSelector {
    override fun ranked(): List<ResolverEndpoint> = listOf(endpoint)
    override fun reportSuccess(endpoint: ResolverEndpoint, rttMs: Long) {}
    override fun reportFailure(endpoint: ResolverEndpoint, reason: String) {}
}
