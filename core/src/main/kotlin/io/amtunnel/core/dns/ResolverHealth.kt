package io.amtunnel.core.dns

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicLong

/** Mutable statistics for one resolver. All access is synchronized on the instance. */
class ResolverStats(val endpoint: ResolverEndpoint) {
    var probeSuccesses: Int = 0
    var probeFailures: Int = 0
    var tunnelSuccesses: Int = 0
    var tunnelFailures: Int = 0
    var consecutiveFailures: Int = 0

    var lastRttMs: Long = -1
    var ewmaRttMs: Double = -1.0
    var lastJitterMs: Double = -1.0
    var bestRttMs: Long = -1

    var lastCheckMs: Long = 0
    var lastError: String = ""
    var status: ResolverStatus = ResolverStatus.UNKNOWN
    var tunnelCapable: Boolean = false

    /** Wall-clock time until which this resolver is parked after a failure. */
    var backoffUntilMs: Long = 0

    fun successRate(): Double {
        val total = probeSuccesses + probeFailures
        if (total == 0) return 0.5 // neutral prior: no data must not look perfect
        // Bayesian smoothing keeps a single lucky probe from topping the list.
        return (probeSuccesses + 1.0) / (total + 2.0)
    }

    fun tunnelSuccessRate(): Double {
        val total = tunnelSuccesses + tunnelFailures
        if (total == 0) return 0.5
        return (tunnelSuccesses + 1.0) / (total + 2.0)
    }

    fun snapshot(): ResolverHealth = synchronized(this) {
        ResolverHealth(
            endpoint = endpoint,
            status = if (!endpoint.enabled) ResolverStatus.DISABLED else status,
            probeSuccesses = probeSuccesses,
            probeFailures = probeFailures,
            tunnelSuccesses = tunnelSuccesses,
            tunnelFailures = tunnelFailures,
            consecutiveFailures = consecutiveFailures,
            lastRttMs = lastRttMs,
            ewmaRttMs = ewmaRttMs,
            lastJitterMs = lastJitterMs,
            bestRttMs = bestRttMs,
            lastCheckMs = lastCheckMs,
            lastError = lastError,
            tunnelCapable = tunnelCapable,
            backoffUntilMs = backoffUntilMs,
        )
    }
}

/** Immutable view for the UI. */
data class ResolverHealth(
    val endpoint: ResolverEndpoint,
    val status: ResolverStatus,
    val probeSuccesses: Int,
    val probeFailures: Int,
    val tunnelSuccesses: Int,
    val tunnelFailures: Int,
    val consecutiveFailures: Int,
    val lastRttMs: Long,
    val ewmaRttMs: Double,
    val lastJitterMs: Double,
    val bestRttMs: Long,
    val lastCheckMs: Long,
    val lastError: String,
    val tunnelCapable: Boolean,
    val backoffUntilMs: Long,
) {
    val successRate: Double
        get() {
            val total = probeSuccesses + probeFailures
            return if (total == 0) 0.0 else probeSuccesses.toDouble() / total
        }

    fun rttText(): String = if (lastRttMs < 0) "-" else "${lastRttMs}ms"

    fun statusText(nowMs: Long): String = when {
        !endpoint.enabled -> "disabled"
        backoffUntilMs > nowMs -> "backoff ${(backoffUntilMs - nowMs) / 1000}s"
        else -> status.name.lowercase()
    }
}

/**
 * Source of truth for resolver health, ranking and failover decisions.
 *
 * Ranking formula (documented because it drives automatic selection):
 * ```
 * score = 0.42 * reliability        // Bayesian-smoothed probe success rate
 *       + 0.30 * tunnelCapability   // session handshake actually worked
 *       + 0.20 * latencyScore       // 1 - min(rtt,1500)/1500
 *       + 0.08 * freshness          // recent observation counts more
 *       - penalties for consecutive failures / backoff
 * ```
 * Higher is better. Resolvers that never completed a tunnel handshake are
 * never auto-selected while a tunnel-capable alternative exists.
 */
class ResolverHealthMonitor(
    private val log: io.amtunnel.core.util.TunnelLog,
    private val clock: () -> Long = { System.currentTimeMillis() },
) {
    private val stats = ConcurrentHashMap<String, ResolverStats>()
    private val listeners = CopyOnWriteArrayList<() -> Unit>()
    private val selectionCount = AtomicLong(0)

    fun register(endpoint: ResolverEndpoint): ResolverStats = synchronized(this) {
        stats.computeIfAbsent(endpoint.key) { ResolverStats(endpoint) }.also {
            if (it.endpoint != endpoint) {
                // endpoint metadata changed (label/enabled) - keep stats, refresh identity
                stats[endpoint.key] = ResolverStats(endpoint).also { fresh ->
                    fresh.probeSuccesses = it.probeSuccesses
                    fresh.probeFailures = it.probeFailures
                    fresh.tunnelSuccesses = it.tunnelSuccesses
                    fresh.tunnelFailures = it.tunnelFailures
                    fresh.consecutiveFailures = it.consecutiveFailures
                    fresh.lastRttMs = it.lastRttMs
                    fresh.ewmaRttMs = it.ewmaRttMs
                    fresh.lastJitterMs = it.lastJitterMs
                    fresh.bestRttMs = it.bestRttMs
                    fresh.lastCheckMs = it.lastCheckMs
                    fresh.lastError = it.lastError
                    fresh.status = it.status
                    fresh.tunnelCapable = it.tunnelCapable
                    fresh.backoffUntilMs = it.backoffUntilMs
                }
            }
        }
    }

    fun setEnabled(endpoint: ResolverEndpoint, enabled: Boolean) {
        val st = register(endpoint.copy(enabled = enabled))
        synchronized(st) {
            st.status = if (enabled) ResolverStatus.UNKNOWN else ResolverStatus.DISABLED
            if (enabled) st.backoffUntilMs = 0
        }
        notifyChanged()
    }

    fun statsFor(endpoint: ResolverEndpoint): ResolverStats = register(endpoint)

    fun reportProbeSuccess(endpoint: ResolverEndpoint, rttMs: Long) {
        val st = register(endpoint)
        synchronized(st) {
            st.probeSuccesses++
            st.consecutiveFailures = 0
            st.lastRttMs = rttMs
            st.bestRttMs = if (st.bestRttMs < 0) rttMs else minOf(st.bestRttMs, rttMs)
            st.ewmaRttMs = if (st.ewmaRttMs < 0) rttMs.toDouble() else st.ewmaRttMs * 0.7 + rttMs * 0.3
            st.lastCheckMs = clock()
            st.lastError = ""
            st.backoffUntilMs = 0
            if (st.tunnelCapable) {
                st.status = if (st.ewmaRttMs > 900) ResolverStatus.DEGRADED else ResolverStatus.HEALTHY
            } else if (st.status == ResolverStatus.UNREACHABLE || st.status == ResolverStatus.UNKNOWN) {
                st.status = ResolverStatus.DEGRADED
            }
        }
        notifyChanged()
    }

    fun reportProbeFailure(endpoint: ResolverEndpoint, reason: String) {
        val st = register(endpoint)
        synchronized(st) {
            st.probeFailures++
            st.consecutiveFailures++
            st.lastCheckMs = clock()
            st.lastError = reason
            st.status = ResolverStatus.UNREACHABLE
            st.backoffUntilMs = clock() + backoffFor(st.consecutiveFailures)
        }
        notifyChanged()
    }

    fun reportTunnelSuccess(endpoint: ResolverEndpoint, handshakeMs: Long) {
        val st = register(endpoint)
        synchronized(st) {
            st.tunnelSuccesses++
            st.tunnelCapable = true
            st.consecutiveFailures = 0
            st.backoffUntilMs = 0
            st.lastCheckMs = clock()
            st.status = if (st.ewmaRttMs > 900) ResolverStatus.DEGRADED else ResolverStatus.HEALTHY
            if (handshakeMs > 0 && st.ewmaRttMs < 0) st.ewmaRttMs = handshakeMs.toDouble()
        }
        notifyChanged()
    }

    fun reportTunnelFailure(endpoint: ResolverEndpoint, reason: String) {
        val st = register(endpoint)
        synchronized(st) {
            st.tunnelFailures++
            st.consecutiveFailures++
            st.lastCheckMs = clock()
            st.lastError = reason
            st.tunnelCapable = false
            // It answered DNS (probe) but cannot carry tunnel traffic.
            st.status = if (st.probeSuccesses > 0) ResolverStatus.TUNNEL_INCAPABLE else ResolverStatus.UNREACHABLE
            st.backoffUntilMs = clock() + backoffFor(st.consecutiveFailures)
        }
        notifyChanged()
    }

    /** Runtime feedback from the live transport (packet sent / no answer). */
    fun reportRuntimeFailure(endpoint: ResolverEndpoint, reason: String) {
        val st = register(endpoint)
        synchronized(st) {
            st.consecutiveFailures++
            st.lastError = reason
            st.lastCheckMs = clock()
            st.backoffUntilMs = clock() + backoffFor(st.consecutiveFailures)
            if (st.tunnelCapable) st.status = ResolverStatus.DEGRADED
        }
        notifyChanged()
    }

    fun reportRuntimeSuccess(endpoint: ResolverEndpoint, rttMs: Long) {
        val st = register(endpoint)
        synchronized(st) {
            st.consecutiveFailures = 0
            st.backoffUntilMs = 0
            if (rttMs > 0) {
                st.lastRttMs = rttMs
                st.ewmaRttMs = if (st.ewmaRttMs < 0) rttMs.toDouble() else st.ewmaRttMs * 0.8 + rttMs * 0.2
            }
            if (st.tunnelCapable) {
                st.status = if (st.ewmaRttMs > 900) ResolverStatus.DEGRADED else ResolverStatus.HEALTHY
            }
        }
    }

    private fun backoffFor(consecutiveFailures: Int): Long = when {
        consecutiveFailures <= 1 -> 5_000
        consecutiveFailures == 2 -> 15_000
        consecutiveFailures == 3 -> 45_000
        else -> 120_000
    }

    /** Ranking score; see class docs. */
    fun score(health: ResolverHealth, nowMs: Long): Double {
        if (!health.endpoint.enabled) return -1.0
        val reliability = 0.5 * health.successRate + 0.5 * tunnelSuccessRate(health)
        val capability = if (health.tunnelCapable) 1.0 else 0.0
        val rtt = if (health.ewmaRttMs > 0) health.ewmaRttMs else 1500.0
        val latencyScore = (1.0 - minOf(rtt, 1500.0) / 1500.0).coerceIn(0.0, 1.0)
        val ageMs = if (health.lastCheckMs == 0L) 1_000_000.0 else (nowMs - health.lastCheckMs).toDouble()
        val freshness = (1.0 - (ageMs / 600_000.0).coerceIn(0.0, 1.0))
        var score = 0.42 * reliability + 0.30 * capability + 0.20 * latencyScore + 0.08 * freshness
        score -= minOf(health.consecutiveFailures, 5) * 0.12
        if (health.backoffUntilMs > nowMs) score -= 0.5
        return score
    }

    private fun tunnelSuccessRate(health: ResolverHealth): Double {
        val total = health.tunnelSuccesses + health.tunnelFailures
        if (total == 0) return 0.5
        return (health.tunnelSuccesses + 1.0) / (total + 2.0)
    }

    fun snapshot(): List<ResolverHealth> = stats.values.map { it.snapshot() }.sortedByDescending {
        score(it, clock())
    }

    /** Ordered preference list for the transport, best first. */
    fun rankedCandidates(onlyTunnelCapable: Boolean = true): List<ResolverEndpoint> {
        val now = clock()
        val healthy = snapshot().filter { it.endpoint.enabled && it.backoffUntilMs <= now }
        val eligible = if (onlyTunnelCapable) {
            healthy.filter { it.tunnelCapable }.ifEmpty { healthy.filter { it.status != ResolverStatus.UNREACHABLE && it.status != ResolverStatus.TUNNEL_INCAPABLE } }
        } else {
            healthy
        }
        val ordered = eligible.sortedByDescending { score(it, now) }.map { it.endpoint }
        if (ordered.isNotEmpty()) selectionCount.incrementAndGet()
        return ordered
    }

    fun best(onlyTunnelCapable: Boolean = true): ResolverEndpoint? = rankedCandidates(onlyTunnelCapable).firstOrNull()

    fun addListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    fun removeListener(listener: () -> Unit) {
        listeners.remove(listener)
    }

    fun notifyChanged() {
        listeners.forEach { runCatching { it() } }
    }

    fun logSummary(): String {
        val snap = snapshot()
        if (snap.isEmpty()) return "no resolvers"
        return snap.joinToString(" | ") {
            "${it.endpoint.key}:${it.statusText(clock())}" +
                (if (it.lastRttMs >= 0) " ${it.lastRttMs}ms" else "") +
                (if (it.tunnelCapable) " tunnel=ok" else "")
        }
    }
}
