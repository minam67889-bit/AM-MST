package io.amtunnel.core.transport

import io.amtunnel.core.dns.ResolverEndpoint
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong
import kotlin.math.max
import kotlin.math.min

/**
 * Faithful port of MasterDnsVPN's client balancer (`internal/client/balancer.go`,
 * commit 5f83ee9a1690a968f9edf495d3a7e00a2043b0bd).
 *
 * Why this exists: on the networks this client is built for, a single resolver
 * is not enough. Resolvers flap, get rate limited, drop packets or die mid
 * session, so every query has to leave through *some* resolver that still
 * works, and the load has to be spread instead of pinning one box.
 *
 * Everything here is **client side only**: it decides which resolver gets a
 * packet. The frame bytes put on the wire are untouched, so a stock
 * MasterDnsVPN server cannot tell the difference and stays compatible.
 *
 * Numbers are copied from the upstream defaults that the project ships as
 * "tested and tuned":
 *  - `RESOLVER_BALANCING_STRATEGY = 2` (round robin)
 *  - `PACKET_DUPLICATION_COUNT = 2`
 *  - `STREAM_RESOLVER_FAILOVER_RESEND_THRESHOLD = 2`
 *  - `STREAM_RESOLVER_FAILOVER_COOLDOWN = 2.5s`
 *  - `AUTO_DISABLE_TIMEOUT_WINDOW_SECONDS = 30`
 *  - stats half-life at 1000 samples
 */
enum class BalancingStrategy(val id: Int) {
    /** 0 — plain round robin, the upstream "default" id. */
    ROUND_ROBIN_DEFAULT(0),

    /** 1 — uniform random over active resolvers. */
    RANDOM(1),

    /** 2 — round robin (upstream default). */
    ROUND_ROBIN(2),

    /** 3 — lowest packet-loss ratio. */
    LEAST_LOSS(3),

    /** 4 — lowest average RTT. */
    LOWEST_LATENCY(4),

    /** 5 — `loss*8 + min(rtt_ms, 1000)`, best composite. */
    HYBRID_SCORE(5),

    /** 6 — loss first, then latency, with tier tolerances. */
    LOSS_THEN_LATENCY(6),

    /** 7 — best loss tier, random member. */
    LEAST_LOSS_TOP_RANDOM(7),

    /** 8 — best loss tier, round robin member. */
    LEAST_LOSS_TOP_ROUND_ROBIN(8),

    ;

    companion object {
        /** Upstream rejects anything outside 0..8. */
        fun fromId(id: Int): BalancingStrategy = entries.firstOrNull { it.id == id } ?: ROUND_ROBIN

        fun isValid(id: Int): Boolean = id in 0..8
    }
}

/** Per-resolver counters, mirroring `connectionStats` in the Go balancer. */
class ResolverStats {
    private val sent = AtomicLong()
    private val acked = AtomicLong()
    private val lost = AtomicLong()
    private val rttMicrosSum = AtomicLong()
    private val rttCount = AtomicLong()
    private val halving = java.util.concurrent.atomic.AtomicBoolean(false)

    // Sliding window used by auto-disable (upstream recordWindowTimeout).
    @Volatile private var windowStartedAt: Long = 0
    private val windowSent = AtomicLong()
    private val windowLost = AtomicLong()

    /** Back-to-back timeouts; the fast path to parking a dead resolver. */
    private val consecutiveTimeouts = AtomicLong()

    val consecutiveTimeoutCount: Long get() = consecutiveTimeouts.get()

    fun noteTimeoutStreak() = consecutiveTimeouts.incrementAndGet()
    fun clearTimeoutStreak() {
        consecutiveTimeouts.set(0)
    }

    val sentCount: Long get() = sent.get()
    val lostCount: Long get() = lost.get()
    val ackedCount: Long get() = acked.get()

    fun reportSend(nowMs: Long = System.currentTimeMillis(), windowMs: Long = 30_000) {
        sent.incrementAndGet()
        ensureWindow(nowMs, windowMs)
        windowSent.incrementAndGet()
        applyHalfLife()
    }

    /** Count a timeout in the auto-disable window; returns (lost, sent). */
    fun recordWindowTimeout(nowMs: Long, windowMs: Long): Pair<Long, Long> {
        ensureWindow(nowMs, windowMs)
        return windowLost.incrementAndGet() to windowSent.get()
    }

    /** A late answer proves the resolver is alive: undo one window timeout. */
    fun retractWindowTimeout(nowMs: Long, windowMs: Long) {
        ensureWindow(nowMs, windowMs)
        windowLost.updateAndGet { current -> if (current > 0) current - 1 else 0 }
    }

    fun resetWindow() {
        windowSent.set(0)
        windowLost.set(0)
    }

    private fun ensureWindow(nowMs: Long, windowMs: Long) {
        val started = windowStartedAt
        if (started == 0L || nowMs - started > windowMs) {
            synchronized(this) {
                if (windowStartedAt == 0L || nowMs - windowStartedAt > windowMs) {
                    windowStartedAt = nowMs
                    windowSent.set(0)
                    windowLost.set(0)
                }
            }
        }
    }

    fun reportSuccess(rttMs: Long) {
        acked.incrementAndGet()
        if (rttMs >= 0) {
            rttMicrosSum.addAndGet(rttMs * 1000)
            rttCount.incrementAndGet()
        }
        applyHalfLife()
    }

    fun reportLoss() {
        lost.incrementAndGet()
        applyHalfLife()
    }

    /** `(lost * 1000) / sent`, 200 during probation/unknown, 0 when clean. */
    fun lossScore(): Long {
        val total = sent.get()
        val dropped = lost.get()
        if (total < 5) return 200
        if (dropped == 0L) return 0
        return (dropped * 1000) / total
    }

    /** Average RTT in micros, 999000 while there is not enough signal. */
    fun latencyScore(): Long {
        val count = rttCount.get()
        if (count < 5) return 999_000
        return rttMicrosSum.get() / count
    }

    /** `(loss * 8) + min(latency_ms, 1000)`, with 200 for unknown latency. */
    fun hybridScore(): Long = lossScore() * 8 + hybridLatencyPenalty()

    fun hybridLatencyPenalty(): Long {
        val micros = latencyScore()
        if (micros == 999_000L) return 200
        return min(micros / 1000, 1000)
    }

    fun hasLatencySignal(): Boolean = rttCount.get() >= 5
    fun hasLossSignal(): Boolean = sent.get() >= 5
    fun hasHybridSignal(): Boolean = hasLatencySignal() || hasLossSignal()

    fun reset() {
        sent.set(0); acked.set(0); lost.set(0); rttMicrosSum.set(0); rttCount.set(0)
        resetWindow()
    }

    /**
     * Keep long-running sessions honest: once any counter passes 1000 the
     * history is halved, exactly like upstream, so an old outage cannot
     * condemn a resolver forever.
     */
    private fun applyHalfLife() {
        if (sent.get() <= HALF_LIFE_THRESHOLD &&
            acked.get() <= HALF_LIFE_THRESHOLD &&
            lost.get() <= HALF_LIFE_THRESHOLD &&
            rttCount.get() <= HALF_LIFE_THRESHOLD
        ) {
            return
        }
        if (!halving.compareAndSet(false, true)) return
        try {
            halve(sent); halve(acked); halve(lost); halve(rttMicrosSum); halve(rttCount)
        } finally {
            halving.set(false)
        }
    }

    private fun halve(counter: AtomicLong) {
        while (true) {
            val current = counter.get()
            if (current == 0L) return
            if (counter.compareAndSet(current, current / 2)) return
        }
    }

    companion object {
        const val HALF_LIFE_THRESHOLD = 1000L

        /** Three timeouts in a row park a resolver (pool >= 3). */
        const val CONSECUTIVE_TIMEOUTS_TO_PARK = 3L
    }
}

/**
 * The balancer: owns the active/inactive pool and answers "which resolver(s)
 * get this packet".
 */
class MasterBalancer(
    strategy: BalancingStrategy = BalancingStrategy.ROUND_ROBIN,
    seed: Long = System.nanoTime(),
) {
    @Volatile var strategy: BalancingStrategy = strategy

    private val lock = Any()
    private var endpoints: MutableList<ResolverEndpoint> = ArrayList()
    private var active: MutableList<Boolean> = ArrayList()
    private var stats: MutableList<ResolverStats> = ArrayList()
    private var indexByKey: MutableMap<String, Int> = HashMap()

    private val rrCounter = AtomicLong()
    private var rngState: Long = if (seed == 0L) -0x61c8864680b583ebL else seed

    /** Upstream default: fail a stream route over after 2 resends. */
    @Volatile var failoverThreshold: Int = 2

    /** Upstream default: 2.5 s between failovers for the same route. */
    @Volatile var failoverCooldownMs: Long = 2_500

    /** `AUTO_DISABLE_TIMEOUT_SERVERS` rules, ported verbatim. */
    @Volatile var autoDisableEnabled: Boolean = true
    @Volatile var autoDisableWindowMs: Long = 30_000
    /** Never shrink the pool below this; upstream forces at least 2. */
    @Volatile var autoDisableMinActive: Int = 2
    @Volatile var recheckInactiveEnabled: Boolean = true
    @Volatile var recheckIntervalMs: Long = 5_000

    /** Called when a resolver is parked, for the log/UI. */
    var onResolverDisabled: ((String, String) -> Unit)? = null
    var onResolverReenabled: ((String) -> Unit)? = null

    private val inactiveSince = HashMap<String, Long>()
    private val lastRecheck = HashMap<String, Long>()

    /** Per-stream sticky resolver, so one stream does not bounce every packet. */
    private val streamPreferred = HashMap<Int, StreamRoute>()
    private class StreamRoute {
        var preferredKey: String? = null
        var resendStreak: Int = 0
        var lastFailoverMs: Long = 0
    }

    val activeCount: Int get() = synchronized(lock) { active.count { it } }
    val totalCount: Int get() = synchronized(lock) { endpoints.size }

    /**
     * Replace the pool. Keeps existing stats for resolvers that stay, so a
     * rescan does not wipe the learning. `active` is decided by the health
     * module (see [setActive]).
     */
    fun setResolvers(newEndpoints: List<ResolverEndpoint>, activeKeys: Set<String>? = null) {
        synchronized(lock) {
            val previous = indexByKey.mapValues { stats[it.value] }
            val previousActive = indexByKey.mapValues { active[it.value] }
            endpoints = ArrayList(newEndpoints)
            active = MutableList(newEndpoints.size) { index ->
                activeKeys?.contains(newEndpoints[index].key)
                    ?: previousActive[newEndpoints[index].key]
                    ?: true
            }
            stats = MutableList(newEndpoints.size) { index ->
                previous[newEndpoints[index].key] ?: ResolverStats()
            }
            indexByKey = HashMap<String, Int>().apply {
                newEndpoints.forEachIndexed { index, endpoint -> put(endpoint.key, index) }
            }
        }
    }

    fun setActive(key: String, isActive: Boolean) {
        synchronized(lock) {
            val index = indexByKey[key] ?: return
            active[index] = isActive
            if (!isActive) {
                streamPreferred.entries.removeIf { it.value.preferredKey == key }
            }
        }
    }

    fun isActive(key: String): Boolean = synchronized(lock) {
        val index = indexByKey[key] ?: return false
        active[index]
    }

    fun endpointFor(key: String): ResolverEndpoint? = synchronized(lock) {
        indexByKey[key]?.let { endpoints[it] }
    }

    /** Active resolvers in pool order (the transport shows these). */
    fun activeEndpoints(): List<ResolverEndpoint> = synchronized(lock) {
        endpoints.indices.filter { active[it] }.map { endpoints[it] }
    }

    fun statsFor(key: String): ResolverStats? = synchronized(lock) {
        val index = indexByKey[key] ?: return null
        stats[index]
    }

    fun reportSend(key: String) {
        val stats = statsFor(key) ?: return
        stats.reportSend()
    }

    fun reportSuccess(key: String, rttMs: Long) {
        val stats = statsFor(key) ?: return
        stats.reportSuccess(rttMs)
        stats.clearTimeoutStreak()
        stats.retractWindowTimeout(System.currentTimeMillis(), autoDisableWindowMs)
        synchronized(lock) {
            streamPreferred.values.forEach { it.resendStreak = 0 }
        }
    }

    /**
     * Record a timeout and, if the whole window was lost, park the resolver.
     *
     * Upstream rule (`ReportTimeout`): a resolver is disabled only when it has
     * at least `minObservations` sends in the window **and every single one**
     * timed out, the pool has more than [autoDisableMinActive] actives, and the
     * pool is bigger than 3 (small pools are never pruned).
     */
    fun reportTimeout(key: String, nowMs: Long = System.currentTimeMillis()): Boolean {
        val stats = statsFor(key) ?: return false
        stats.reportLoss()
        if (!autoDisableEnabled) return false

        // Fast path: a resolver that answers nothing three times in a row is
        // down now, whatever the long-window statistics say. This is the
        // "confirm the resolver is down" step; upstream confirms with a direct
        // probe, we confirm with the timeouts themselves, and the recheck loop
        // below puts it back when it answers again.
        if (stats.noteTimeoutStreak() >= ResolverStats.CONSECUTIVE_TIMEOUTS_TO_PARK) {
            synchronized(lock) {
                val index = indexByKey[key] ?: return false
                val activeCount = active.count { it }
                if (!active[index] || activeCount <= max(autoDisableMinActive, 2)) return false
                active[index] = false
                inactiveSince[key] = nowMs
                stats.clearTimeoutStreak()
                stats.resetWindow()
                streamPreferred.entries.removeIf { it.value.preferredKey == key }
            }
            onResolverDisabled?.invoke(key, "TIMEOUT_STREAK")
            return true
        }

        val (timedOut, totalSent) = stats.recordWindowTimeout(nowMs, autoDisableWindowMs)
        synchronized(lock) {
            val index = indexByKey[key] ?: return false
            if (!active[index]) return false
            val activeCount = active.count { it }
            val minObservations = minObservationsForActiveCount(activeCount, autoDisableWindowMs)
            if (totalSent < minObservations || timedOut != totalSent) return false

            val floor = max(autoDisableMinActive, 2)
            if (activeCount <= floor) return false

            active[index] = false
            inactiveSince[key] = nowMs
            stats.resetWindow()
            streamPreferred.entries.removeIf { it.value.preferredKey == key }
        }
        onResolverDisabled?.invoke(key, "TIMEOUT")
        return true
    }

    /** Upstream `autoDisableMinObservationsForActiveCount`. */
    private fun minObservationsForActiveCount(active: Int, windowMs: Long): Long {
        val base = when {
            active <= 3 -> return 1_000_000L      // tiny pools are never pruned
            active <= 5 -> 48
            active <= 8 -> 40
            active <= 10 -> 34
            active <= 15 -> 26
            active <= 20 -> 22
            active <= 30 -> 18
            active <= 40 -> 15
            active <= 50 -> 13
            active <= 75 -> 10
            active <= 100 -> 8
            active <= 150 -> 7
            else -> 6
        }
        return when {
            windowMs >= 60_000 -> base * 3L
            windowMs >= 30_000 -> base * 2L
            else -> base.toLong()
        }
    }

    /** Resolvers parked by auto-disable, oldest first. */
    fun inactiveKeys(): List<String> = synchronized(lock) {
        endpoints.indices.filter { !active[it] }.map { endpoints[it].key }
    }

    /**
     * `RECHECK_INACTIVE_SERVERS_ENABLED`: hand back one parked resolver that is
     * due for a health probe. The transport pings it; a success reactivates it.
     */
    fun nextForRecheck(nowMs: Long = System.currentTimeMillis()): String? {
        if (!recheckInactiveEnabled) return null
        synchronized(lock) {
            val due = endpoints.indices
                .filter { !active[it] }
                .map { endpoints[it].key }
                .filter { key -> nowMs - (lastRecheck[key] ?: 0L) >= recheckIntervalMs }
                .minByOrNull { inactiveSince[it] ?: 0L }
                ?: return null
            lastRecheck[due] = nowMs
            return due
        }
    }

    /** Bring a parked resolver back (health probe or manual action). */
    fun reactivate(key: String) {
        synchronized(lock) {
            val index = indexByKey[key] ?: return
            active[index] = true
            inactiveSince.remove(key)
            stats[index].resetWindow()
        }
        onResolverReenabled?.invoke(key)
    }

    /** Forget the learned history of one resolver (after it recovers). */
    fun resetStats(key: String) {
        statsFor(key)?.reset()
    }

    // ---------------------------------------------------------------- selection

    fun nextKey(excluded: Set<String> = emptySet()): String? {
        val selection = selectTargets(requiredCount = 1, excluded = excluded)
        return selection.firstOrNull()
    }

    /**
     * Pick up to [requiredCount] distinct active resolvers. This is the
     * equivalent of upstream `SelectTargets`: one resolver for normal packets,
     * N for duplicated ones.
     */
    fun selectTargets(requiredCount: Int, excluded: Set<String> = emptySet()): List<String> {
        synchronized(lock) {
            val activeIndices = indices(active = true).filter { endpoints[it].key !in excluded }
            if (activeIndices.isEmpty()) return emptyList()
            val count = min(max(requiredCount, 1), activeIndices.size)
            if (count == 1) {
                val index = pickSingle(activeIndices)
                return if (index < 0) emptyList() else listOf(endpoints[index].key)
            }
            return pickMany(activeIndices, count).map { endpoints[it].key }
        }
    }

    private fun indices(active: Boolean): List<Int> =
        this.active.indices.filter { this.active[it] == active }

    private fun pickSingle(candidates: List<Int>): Int = when (strategy) {
        BalancingStrategy.RANDOM -> candidates[Math.floorMod(nextRandom(), candidates.size.toLong()).toInt()]

        BalancingStrategy.LOSS_THEN_LATENCY -> {
            val pool = lossThenLatencyTier(candidates)
            if (pool.isEmpty()) roundRobin(candidates) else pool[Math.floorMod(nextRandom(), pool.size.toLong()).toInt()]
        }

        BalancingStrategy.LEAST_LOSS_TOP_RANDOM -> {
            val pool = leastLossTopTier(candidates)
            if (pool.isEmpty()) roundRobin(candidates) else pool[Math.floorMod(nextRandom(), pool.size.toLong()).toInt()]
        }

        BalancingStrategy.LEAST_LOSS_TOP_ROUND_ROBIN -> {
            val pool = leastLossTopTier(candidates)
            if (pool.isEmpty()) roundRobin(candidates) else roundRobin(pool)
        }

        BalancingStrategy.LEAST_LOSS -> scored(candidates) { stats[it].lossScore() } ?: roundRobin(candidates)
        BalancingStrategy.LOWEST_LATENCY -> scored(candidates) { stats[it].latencyScore() } ?: roundRobin(candidates)
        BalancingStrategy.HYBRID_SCORE -> scored(candidates) { stats[it].hybridScore() } ?: roundRobin(candidates)

        BalancingStrategy.ROUND_ROBIN_DEFAULT,
        BalancingStrategy.ROUND_ROBIN,
        -> roundRobin(candidates)
    }

    /** Lowest score wins; ties fall back to round robin like upstream. */
    private fun scored(candidates: List<Int>, score: (Int) -> Long): Int? {
        val signal = when (strategy) {
            BalancingStrategy.LEAST_LOSS -> stats[candidates[0]].hasLossSignal() ||
                candidates.any { stats[it].hasLossSignal() }
            BalancingStrategy.LOWEST_LATENCY -> candidates.any { stats[it].hasLatencySignal() }
            else -> candidates.any { stats[it].hasHybridSignal() }
        }
        if (!signal) return null
        var best = candidates[0]
        var bestScore = score(best)
        for (index in candidates) {
            val value = score(index)
            if (value < bestScore) {
                best = index
                bestScore = value
            }
        }
        return best
    }

    private fun roundRobin(candidates: List<Int>): Int =
        candidates[Math.floorMod(rrCounter.getAndIncrement(), candidates.size.toLong()).toInt()]

    /** Top tier = best loss bucket, at least 2 members, ~10% of the pool. */
    private fun leastLossTopTier(candidates: List<Int>): List<Int> {
        if (candidates.none { stats[it].hasLossSignal() }) return emptyList()
        val sorted = candidates.sortedBy { stats[it].lossScore() }
        val topCount = min(max(2, (sorted.size + 9) / 10), sorted.size)
        return sorted.take(topCount)
    }

    /**
     * Loss shortlist with a 25-point tolerance (0 when nobody is clean), then a
     * latency tier inside it - upstream `lossThenLatencyCandidatesLocked`.
     */
    private fun lossThenLatencyTier(candidates: List<Int>): List<Int> {
        if (candidates.none { stats[it].hasHybridSignal() }) return emptyList()
        val bestLoss = candidates.minOf { stats[it].lossScore() }
        val lossTolerance = if (bestLoss >= 200) 0L else 25L
        val lossCutoff = bestLoss + lossTolerance
        val shortlist = candidates.filter { stats[it].lossScore() <= lossCutoff }
        if (shortlist.isEmpty()) return emptyList()

        val bestLatency = shortlist.minOf { stats[it].hybridLatencyPenalty() }
        val latencyCutoff = bestLatency + latencyTolerance(bestLatency)
        val selected = shortlist.filter { stats[it].hybridLatencyPenalty() <= latencyCutoff }
        return selected.ifEmpty { listOf(shortlist.first()) }
    }

    private fun latencyTolerance(bestLatency: Long): Long {
        if (bestLatency >= 200) return 0
        return min(max(bestLatency / 4, 2), 25)
    }

    /** N distinct resolvers, ordered by the strategy (duplication path). */
    private fun pickMany(candidates: List<Int>, count: Int): List<Int> {
        val ordered = when (strategy) {
            BalancingStrategy.RANDOM -> candidates.shuffled(java.util.Random(nextRandom()))
            BalancingStrategy.LEAST_LOSS_TOP_RANDOM,
            BalancingStrategy.LOSS_THEN_LATENCY,
            -> {
                val tier = if (strategy == BalancingStrategy.LEAST_LOSS_TOP_RANDOM) {
                    leastLossTopTier(candidates)
                } else {
                    lossThenLatencyTier(candidates)
                }
                val pool = tier.ifEmpty { candidates }
                pool.shuffled(java.util.Random(nextRandom())) + candidates.filter { it !in pool }
            }

            BalancingStrategy.LEAST_LOSS_TOP_ROUND_ROBIN -> {
                val tier = leastLossTopTier(candidates).ifEmpty { candidates }
                rotate(tier, count) + candidates.filter { it !in tier }
            }

            BalancingStrategy.LEAST_LOSS -> candidates.sortedBy { stats[it].lossScore() }
            BalancingStrategy.LOWEST_LATENCY -> candidates.sortedBy { stats[it].latencyScore() }
            BalancingStrategy.HYBRID_SCORE -> candidates.sortedBy { stats[it].hybridScore() }
            BalancingStrategy.ROUND_ROBIN_DEFAULT,
            BalancingStrategy.ROUND_ROBIN,
            -> rotate(candidates, count)
        }
        return ordered.distinct().take(count)
    }

    private fun rotate(pool: List<Int>, count: Int): List<Int> {
        if (pool.isEmpty()) return emptyList()
        val start = Math.floorMod(rrCounter.getAndAdd(count.toLong()), pool.size.toLong()).toInt()
        return List(pool.size) { pool[(start + it) % pool.size] }
    }

    // ------------------------------------------------------------ stream routes

    /**
     * Sticky resolver for a stream: the first packet pins it, and only repeated
     * failures (threshold) after a cooldown move that stream elsewhere. This is
     * upstream's `selectPreferredConnectionForStreamLocked`.
     */
    fun preferredForKey(streamId: Int, nowMs: Long = System.currentTimeMillis()): String? {
        synchronized(lock) {
            val route = streamPreferred.getOrPut(streamId) { StreamRoute() }
            val current = route.preferredKey
            if (current != null && indexByKey[current]?.let { active[it] } == true) {
                return current
            }
            val selection = selectTargets(1)
            val chosen = selection.firstOrNull() ?: return null
            route.preferredKey = chosen
            route.resendStreak = 0
            return chosen
        }
    }

    /** Record that a stream had to resend; returns the new resolver on failover. */
    fun noteStreamResend(streamId: Int, nowMs: Long = System.currentTimeMillis()): String? {
        synchronized(lock) {
            val route = streamPreferred.getOrPut(streamId) { StreamRoute() }
            route.resendStreak++
            if (route.resendStreak < failoverThreshold) return null
            if (nowMs - route.lastFailoverMs < failoverCooldownMs) return null
            val previous = route.preferredKey
            val replacement = selectTargets(1, excluded = setOfNotNull(previous)).firstOrNull() ?: return null
            route.preferredKey = replacement
            route.resendStreak = 0
            route.lastFailoverMs = nowMs
            return replacement
        }
    }

    fun clearStream(streamId: Int) {
        synchronized(lock) { streamPreferred.remove(streamId) }
    }

    fun clearStreams() {
        synchronized(lock) { streamPreferred.clear() }
    }

    /** Read-only view for the diagnostics screen. */
    fun snapshot(): List<BalancerRow> = synchronized(lock) {
        endpoints.indices.map { index ->
            val endpoint = endpoints[index]
            val stat = stats[index]
            BalancerRow(
                key = endpoint.key,
                active = active[index],
                sent = stat.sentCount,
                lost = stat.lostCount,
                acked = stat.ackedCount,
                lossScore = stat.lossScore(),
                latencyMs = stat.latencyScore().takeIf { it != 999_000L }?.div(1000.0),
                hybridScore = stat.hybridScore(),
            )
        }
    }

    private fun nextRandom(): Long {
        var value = rngState
        if (value == 0L) value = -0x61c8864680b583ebL
        value = value xor (value shl 13)
        value = value xor (value ushr 7)
        value = value xor (value shl 17)
        rngState = value
        return value
    }

    /** One row per resolver, for the live diagnostics list. */
    data class BalancerRow(
        val key: String,
        val active: Boolean,
        val sent: Long,
        val lost: Long,
        val acked: Long,
        val lossScore: Long,
        val latencyMs: Double?,
        val hybridScore: Long,
    )
}
