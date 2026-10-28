package io.amtunnel.core

import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.transport.BalancingStrategy
import io.amtunnel.core.transport.MasterBalancer
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * These assertions pin the *exact* numbers of MasterDnsVPN's balancer
 * (`internal/client/balancer.go`). If someone "improves" the scoring, these
 * fail on purpose: the upstream values are the tuned ones.
 */
class BalancerTest {

    private fun endpoint(host: String, port: Int = 53) = ResolverEndpoint(host, port, host)

    private fun pool(size: Int): List<ResolverEndpoint> =
        (1..size).map { endpoint("10.0.0.$it") }

    // ------------------------------------------------------------------ scoring

    @Test
    fun `loss score matches upstream formula`() {
        val balancer = MasterBalancer()
        balancer.setResolvers(listOf(endpoint("a")))
        val stats = balancer.statsFor("a:53")!!
        // probation: fewer than 5 sends scores 200
        repeat(4) { stats.reportSend() }
        assertEquals(200, stats.lossScore())

        repeat(6) { stats.reportSend() }        // 10 sent total
        repeat(3) { stats.reportLoss() }        // 3 lost
        assertEquals((3 * 1000) / 10, stats.lossScore())

        val clean = MasterBalancer().apply { setResolvers(listOf(endpoint("b"))) }
        val cleanStats = clean.statsFor("b:53")!!
        repeat(5) { cleanStats.reportSend() }
        assertEquals("a clean resolver scores 0", 0, cleanStats.lossScore())
    }

    @Test
    fun `latency score needs five samples then averages in micros`() {
        val balancer = MasterBalancer()
        balancer.setResolvers(listOf(endpoint("a")))
        val stats = balancer.statsFor("a:53")!!

        repeat(4) { stats.reportSuccess(10) }
        assertEquals(999_000, stats.latencyScore())

        stats.reportSuccess(20)
        // (10+10+10+10+20) / 5 = 12 ms = 12_000 micros
        assertEquals(12_000, stats.latencyScore())
    }

    @Test
    fun `hybrid score is loss times eight plus capped latency`() {
        val balancer = MasterBalancer()
        balancer.setResolvers(listOf(endpoint("a")))
        val stats = balancer.statsFor("a:53")!!

        repeat(10) { stats.reportSend() }
        repeat(2) { stats.reportLoss() }          // loss = 200
        repeat(5) { stats.reportSuccess(1500) }   // 1500 ms -> capped at 1000
        assertEquals(200 * 8 + 1000, stats.hybridScore())
    }

    @Test
    fun `half life halves counters past a thousand samples`() {
        val balancer = MasterBalancer()
        balancer.setResolvers(listOf(endpoint("a")))
        val stats = balancer.statsFor("a:53")!!
        // upstream halves only once a counter passes the threshold
        repeat(1000) { stats.reportSend() }
        assertEquals("exactly at the threshold nothing is halved yet", 1000, stats.sentCount)
        repeat(5) { stats.reportSend() }
        assertTrue("past 1000 samples the history must be halved", stats.sentCount < 1005)
    }

    // ------------------------------------------------------------- strategy ids

    @Test
    fun `strategy ids match master`() {
        assertEquals(0, BalancingStrategy.ROUND_ROBIN_DEFAULT.id)
        assertEquals(1, BalancingStrategy.RANDOM.id)
        assertEquals(2, BalancingStrategy.ROUND_ROBIN.id)
        assertEquals(3, BalancingStrategy.LEAST_LOSS.id)
        assertEquals(4, BalancingStrategy.LOWEST_LATENCY.id)
        assertEquals(5, BalancingStrategy.HYBRID_SCORE.id)
        assertEquals(6, BalancingStrategy.LOSS_THEN_LATENCY.id)
        assertEquals(7, BalancingStrategy.LEAST_LOSS_TOP_RANDOM.id)
        assertEquals(8, BalancingStrategy.LEAST_LOSS_TOP_ROUND_ROBIN.id)
        assertFalse(BalancingStrategy.isValid(9))
        assertEquals("unknown id falls back to the upstream default",
            BalancingStrategy.ROUND_ROBIN, BalancingStrategy.fromId(99))
    }

    // --------------------------------------------------------------- selection

    @Test
    fun `round robin spreads over the whole pool`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 1)
        balancer.setResolvers(pool(5))
        val picks = (1..25).map { balancer.nextKey()!! }
        assertEquals("all five resolvers must be used", 5, picks.distinct().size)
        // each appears exactly five times over five full rotations
        picks.groupingBy { it }.eachCount().values.forEach { assertEquals(5, it) }
    }

    @Test
    fun `random never leaves the active pool`() {
        val balancer = MasterBalancer(BalancingStrategy.RANDOM, seed = 7)
        balancer.setResolvers(pool(4))
        val keys = pool(4).map { it.key }.toSet()
        repeat(100) { assertTrue(balancer.nextKey()!! in keys) }
    }

    @Test
    fun `least loss prefers the resolver that drops nothing`() {
        val balancer = MasterBalancer(BalancingStrategy.LEAST_LOSS, seed = 3)
        balancer.setResolvers(pool(3))
        // make 10.0.0.1 and 10.0.0.2 miserable, keep 10.0.0.3 clean
        listOf("10.0.0.1:53", "10.0.0.2:53").forEach { key ->
            val stats = balancer.statsFor(key)!!
            repeat(20) { stats.reportSend() }
            repeat(10) { stats.reportLoss() }
        }
        val clean = balancer.statsFor("10.0.0.3:53")!!
        repeat(20) { clean.reportSend() }

        repeat(12) { assertEquals("10.0.0.3:53", balancer.nextKey()) }
    }

    @Test
    fun `lowest latency prefers the fastest resolver`() {
        val balancer = MasterBalancer(BalancingStrategy.LOWEST_LATENCY, seed = 5)
        balancer.setResolvers(pool(3))
        val fast = balancer.statsFor("10.0.0.2:53")!!
        repeat(10) { fast.reportSuccess(5) }
        listOf("10.0.0.1:53", "10.0.0.3:53").forEach { key ->
            val stats = balancer.statsFor(key)!!
            repeat(10) { stats.reportSuccess(400) }
        }
        repeat(10) { assertEquals("10.0.0.2:53", balancer.nextKey()) }
    }

    @Test
    fun `loss then latency uses a twenty five point loss tolerance`() {
        val balancer = MasterBalancer(BalancingStrategy.LOSS_THEN_LATENCY, seed = 11)
        balancer.setResolvers(pool(2))
        // A: 4% loss, fast.  B: 2% loss, slow.  Within tolerance => latency decides.
        val a = balancer.statsFor("10.0.0.1:53")!!
        repeat(100) { a.reportSend() }
        repeat(4) { a.reportLoss() }
        repeat(10) { a.reportSuccess(20) }

        val b = balancer.statsFor("10.0.0.2:53")!!
        repeat(100) { b.reportSend() }
        repeat(2) { b.reportLoss() }
        repeat(10) { b.reportSuccess(300) }

        val picks = (1..10).map { balancer.nextKey() }
        assertTrue("the fast resolver must win inside the loss tolerance",
            picks.count { it == "10.0.0.1:53" } >= 9)
    }

    @Test
    fun `least loss top tier keeps at least two candidates`() {
        val balancer = MasterBalancer(BalancingStrategy.LEAST_LOSS_TOP_ROUND_ROBIN, seed = 13)
        balancer.setResolvers(pool(6))
        pool(6).forEachIndexed { index, resolver ->
            val stats = balancer.statsFor(resolver.key)!!
            repeat(20) { stats.reportSend() }
            repeat(index) { stats.reportLoss() }
        }
        // tier size for 6 candidates = max(2, (6+9)/10) = 2
        val picks = (1..20).map { balancer.nextKey() }.toSet()
        assertEquals("top tier must be exactly two resolvers", 2, picks.size)
        assertTrue(picks.all { it in setOf("10.0.0.1:53", "10.0.0.2:53") })
    }

    @Test
    fun `duplication returns distinct resolvers`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 17)
        balancer.setResolvers(pool(10))
        val targets = balancer.selectTargets(3)
        assertEquals(3, targets.size)
        assertEquals("duplication must never reuse a resolver", 3, targets.distinct().size)
    }

    @Test
    fun `duplication is capped by pool size`() {
        val balancer = MasterBalancer()
        balancer.setResolvers(pool(2))
        assertEquals(2, balancer.selectTargets(5).size)
    }

    @Test
    fun `inactive resolvers are never selected`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 19)
        balancer.setResolvers(pool(4))
        balancer.setActive("10.0.0.1:53", false)
        balancer.setActive("10.0.0.2:53", false)
        val picks = (1..20).map { balancer.nextKey()!! }.toSet()
        assertEquals(setOf("10.0.0.3:53", "10.0.0.4:53"), picks)
    }

    @Test
    fun `excluding a resolver keeps failover distinct`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 23)
        balancer.setResolvers(pool(3))
        repeat(10) {
            assertNotNull(balancer.nextKey(excluded = setOf("10.0.0.1:53")))
            assertFalse(balancer.nextKey(excluded = setOf("10.0.0.1:53")) == "10.0.0.1:53")
        }
    }

    // ------------------------------------------------------------ stream routes

    @Test
    fun `a stream keeps its resolver until the resend threshold`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 29)
        balancer.setResolvers(pool(4))
        val first = balancer.preferredForKey(42)
        assertNotNull(first)
        repeat(5) { assertEquals(first, balancer.preferredForKey(42)) }

        // threshold is 2: the first resend must not move the stream
        assertEquals(null, balancer.noteStreamResend(42, nowMs = 1_000))
        val moved = balancer.noteStreamResend(42, nowMs = 4_000)
        assertNotNull("second resend past cooldown must fail over", moved)
        assertFalse("failover must pick a different resolver", moved == first)
    }

    @Test
    fun `failover respects the cooldown`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 31)
        balancer.setResolvers(pool(4))
        balancer.preferredForKey(7)
        balancer.noteStreamResend(7, nowMs = 1_000)
        assertNotNull(balancer.noteStreamResend(7, nowMs = 4_000))
        // immediately after a failover the cooldown blocks another move
        balancer.noteStreamResend(7, nowMs = 4_100)
        assertEquals(null, balancer.noteStreamResend(7, nowMs = 4_200))
    }

    @Test
    fun `scaling to a thousand resolvers stays fast and distinct`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 37)
        balancer.setResolvers(pool(1000))
        val sample = (1..1000).map { balancer.nextKey()!! }
        assertEquals("a thousand resolvers must all be reachable", 1000, sample.distinct().size)
    }

    @Test
    fun `auto disable parks a resolver whose whole window timed out`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 41)
        balancer.autoDisableEnabled = true
        // 5 s window keeps the observation requirement at the base 34 for a
        // pool of 10 (upstream scales it by the window).
        balancer.autoDisableWindowMs = 5_000
        balancer.autoDisableMinActive = 2
        balancer.setResolvers(pool(10))
        val victim = "10.0.0.1:53"
        val now = 1_000_000L
        repeat(40) { step ->
            balancer.reportSend(victim)
            balancer.reportTimeout(victim, now + step * 10L)
        }
        assertFalse("a resolver that lost 100% of its window must be parked", balancer.isActive(victim))
        assertTrue("the rest of the pool must stay usable", balancer.activeCount >= 9)
    }

    @Test
    fun `auto disable never empties a small pool`() {
        val balancer = MasterBalancer()
        balancer.autoDisableWindowMs = 5_000
        balancer.setResolvers(pool(3))
        val now = 2_000_000L
        pool(3).forEach { resolver ->
            repeat(80) { step ->
                balancer.reportSend(resolver.key)
                balancer.reportTimeout(resolver.key, now + step * 10L)
            }
        }
        assertTrue("upstream never prunes pools of three or fewer", balancer.activeCount >= 2)
    }

    @Test
    fun `a parked resolver returns after a successful recheck`() {
        val balancer = MasterBalancer()
        balancer.recheckInactiveEnabled = true
        balancer.recheckIntervalMs = 0
        balancer.setResolvers(pool(6))
        balancer.setActive("10.0.0.2:53", false)
        val due = balancer.nextForRecheck(nowMs = 10_000)
        assertEquals("10.0.0.2:53", due)
        balancer.reactivate("10.0.0.2:53")
        assertTrue(balancer.isActive("10.0.0.2:53"))
    }

    @Test
    fun `three timeouts in a row park a resolver immediately`() {
        val balancer = MasterBalancer(BalancingStrategy.ROUND_ROBIN, seed = 43)
        balancer.autoDisableWindowMs = 30_000
        balancer.setResolvers(pool(6))
        val victim = "10.0.0.4:53"
        repeat(3) { balancer.reportTimeout(victim, nowMs = 1_000L + it) }
        assertFalse("three consecutive timeouts must park it", balancer.isActive(victim))
        assertTrue("the rest of the pool stays", balancer.activeCount >= 5)

        // one success clears the streak, so a flaky-but-alive resolver stays
        val flaky = "10.0.0.5:53"
        balancer.reportTimeout(flaky, nowMs = 2_000)
        balancer.reportTimeout(flaky, nowMs = 2_001)
        balancer.reportSuccess(flaky, 40)
        balancer.reportTimeout(flaky, nowMs = 2_002)
        balancer.reportTimeout(flaky, nowMs = 2_003)
        assertTrue("a success must reset the streak", balancer.isActive(flaky))
    }
}
