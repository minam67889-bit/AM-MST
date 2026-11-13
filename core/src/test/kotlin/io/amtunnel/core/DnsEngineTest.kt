package io.amtunnel.core

import io.amtunnel.core.dns.FileResolverStore
import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.dns.ResolverHealthMonitor
import io.amtunnel.core.dns.ResolverSource
import io.amtunnel.core.dns.ResolverStatus
import io.amtunnel.core.transport.HealthResolverSelector
import io.amtunnel.core.transport.StaticResolverSelector
import io.amtunnel.core.util.TunnelLog
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.io.File

class ResolverParsingTest {
    @Test
    fun `parses ipv4 with and without port`() {
        assertEquals("1.1.1.1:53", ResolverEndpoint.parse("1.1.1.1")!!.key)
        assertEquals("1.1.1.1:5353", ResolverEndpoint.parse("1.1.1.1:5353")!!.key)
        assertEquals(5353, ResolverEndpoint.parse("1.1.1.1:5353")!!.port)
    }

    @Test
    fun `parses ipv6 with brackets and bare`() {
        assertEquals("[2606:4700:4700::1111]:53", ResolverEndpoint.parse("[2606:4700:4700::1111]:53")!!.key)
        assertEquals("[2606:4700:4700::1001]:53", ResolverEndpoint.parse("2606:4700:4700::1001")!!.key)
    }

    @Test
    fun `parses labels and hostnames`() {
        val labelled = ResolverEndpoint.parse("cloudflare=1.1.1.1:53")!!
        assertEquals("cloudflare", labelled.label)
        assertEquals("1.1.1.1:53", labelled.key)
        assertEquals("dns.google:53", ResolverEndpoint.parse("dns.google")!!.key)
    }

    @Test
    fun `rejects garbage`() {
        assertNull(ResolverEndpoint.parse(""))
        assertNull(ResolverEndpoint.parse("# comment"))
        assertNull(ResolverEndpoint.parse("1.1.1.1:99999"))
        assertNull(ResolverEndpoint.parse("not a host!"))
    }

    @Test
    fun `bulk import deduplicates and skips comments`() {
        val text = """
            # my resolvers
            1.1.1.1
            8.8.8.8:53, 9.9.9.9
            1.1.1.1
            ; comment
            [2001:4860:4860::8888]:53
        """.trimIndent()
        val list = ResolverEndpoint.parseMany(text)
        assertEquals(4, list.size)
        assertEquals(
            listOf("1.1.1.1:53", "8.8.8.8:53", "9.9.9.9:53", "[2001:4860:4860::8888]:53"),
            list.map { it.key },
        )
        assertTrue(list.all { it.source == ResolverSource.IMPORTED })
    }
}

class ResolverStoreTest {
    @Test
    fun `persists and restores resolver list`() {
        val file = File.createTempFile("resolvers", ".tsv")
        file.delete()
        val store = FileResolverStore(file)
        val endpoints = listOf(
            ResolverEndpoint("1.1.1.1", 53, "cf", ResolverSource.MANUAL, true),
            ResolverEndpoint("8.8.8.8", 5353, "google", ResolverSource.IMPORTED, false),
        )
        store.save(endpoints)
        val loaded = store.load()
        assertEquals(2, loaded.size)
        assertEquals("1.1.1.1:53", loaded[0].key)
        assertEquals("cf", loaded[0].label)
        assertEquals(5353, loaded[1].port)
        assertFalse(loaded[1].enabled)
        assertTrue(loaded[1].source == ResolverSource.IMPORTED)
        file.delete()
    }
}

class RankingTest {
    private fun monitor() = ResolverHealthMonitor(TunnelLog())

    @Test
    fun `tunnel capable resolver outranks a fast dns-only resolver`() {
        val m = monitor()
        val fastDnsOnly = ResolverEndpoint("10.0.0.1")
        val slowerTunnel = ResolverEndpoint("10.0.0.2")
        m.register(fastDnsOnly)
        m.register(slowerTunnel)

        m.reportProbeSuccess(fastDnsOnly, 5) // very fast, but never completes a handshake
        m.reportProbeSuccess(slowerTunnel, 120)
        m.reportTunnelSuccess(slowerTunnel, 150)

        val ranked = m.rankedCandidates()
        assertEquals(listOf(slowerTunnel.key), ranked.map { it.key })
    }

    @Test
    fun `failing resolver is parked and skipped`() {
        val m = monitor()
        val a = ResolverEndpoint("10.0.0.1")
        val b = ResolverEndpoint("10.0.0.2")
        m.reportTunnelSuccess(a, 100)
        m.reportTunnelSuccess(b, 200)

        repeat(3) { m.reportRuntimeFailure(a, "timeout") }
        val ranked = m.rankedCandidates().map { it.key }
        assertTrue(ranked.contains(b.key))
        assertFalse(ranked.contains(a.key))
    }

    @Test
    fun `latency influences ordering among capable resolvers`() {
        val m = monitor()
        val fast = ResolverEndpoint("10.0.0.1")
        val slow = ResolverEndpoint("10.0.0.2")
        m.reportProbeSuccess(fast, 20)
        m.reportTunnelSuccess(fast, 25)
        m.reportProbeSuccess(slow, 800)
        m.reportTunnelSuccess(slow, 820)
        assertEquals(fast.key, m.rankedCandidates().first().key)
    }

    @Test
    fun `status transitions reflect capability results`() {
        val m = monitor()
        val r = ResolverEndpoint("10.0.0.9")
        m.reportProbeSuccess(r, 30)
        assertEquals(ResolverStatus.DEGRADED, m.statsFor(r).snapshot().status)

        m.reportTunnelFailure(r, "no tunnel frame in answer")
        assertEquals(ResolverStatus.TUNNEL_INCAPABLE, m.statsFor(r).snapshot().status)

        m.reportTunnelSuccess(r, 40)
        assertEquals(ResolverStatus.HEALTHY, m.statsFor(r).snapshot().status)
    }

    @Test
    fun `disabled resolvers are never candidates`() {
        val m = monitor()
        val r = ResolverEndpoint("10.0.0.3", enabled = false)
        m.reportTunnelSuccess(r, 10)
        assertTrue(m.rankedCandidates().isEmpty())
    }

    @Test
    fun `selector adapter reports runtime results`() {
        val m = monitor()
        val r = ResolverEndpoint("10.0.0.4")
        m.reportTunnelSuccess(r, 10)
        val selector = HealthResolverSelector(m)
        assertEquals(1, selector.ranked().size)
        repeat(4) { selector.reportFailure(r, "timeout") }
        assertTrue(selector.ranked().isEmpty())
        selector.reportSuccess(r, 50)
        assertNotNull(selector.ranked().firstOrNull())
    }

    @Test
    fun `static selector always returns one endpoint`() {
        val r = ResolverEndpoint("192.0.2.1")
        val selector = StaticResolverSelector(r)
        assertEquals(listOf(r), selector.ranked())
    }
}
