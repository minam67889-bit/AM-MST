package io.amtunnel.it

import io.amtunnel.core.dns.ResolverHealthMonitor
import io.amtunnel.core.dns.TunnelCapabilityProbe
import io.amtunnel.core.transport.EncryptionMethod
import io.amtunnel.core.transport.HealthResolverSelector
import io.amtunnel.core.transport.MasterDnsTransport
import io.amtunnel.core.transport.TunnelConfig
import io.amtunnel.core.util.TunnelLog
import org.junit.AfterClass
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.BeforeClass
import org.junit.FixMethodOrder
import org.junit.Test
import org.junit.runners.MethodSorters

/**
 * End-to-end tests against a *real* DNS tunnel server.
 *
 * The server is the upstream MasterDnsVPN Go implementation, compiled from
 * source and started by the CI workflow. Nothing here is mocked: the tunnel
 * frames, the encryption, the base36 QNAME encoding, the DNS envelope and the
 * SOCKS5-in-tunnel stream setup all have to be byte-compatible or these tests
 * fail.
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class TunnelIntegrationTest {

    companion object {
        private val log = TunnelLog()
        private val body = "AMTUNNEL-OK-" + "payload".repeat(20)

        private lateinit var http: HttpProbeServer
        private lateinit var relayA: UdpRelay
        private lateinit var relayB: UdpRelay
        private lateinit var dnsOnly: PlainDnsStub

        private val domain: String = System.getenv("AMTUNNEL_DOMAIN") ?: "t.amtunnel.test"
        private val key: String = System.getenv("AMTUNNEL_KEY") ?: ""
        private val serverHost: String = System.getenv("AMTUNNEL_SERVER_HOST") ?: "127.0.0.1"
        private val serverPort: Int = System.getenv("AMTUNNEL_SERVER_PORT")?.toIntOrNull() ?: 15353
        private val encMethod: Int = System.getenv("AMTUNNEL_ENC")?.toIntOrNull() ?: EncryptionMethod.XOR

        private fun config(): TunnelConfig = TunnelConfig(
            domain = domain,
            encryptionMethod = encMethod,
            encryptionKey = key,
            uploadMtu = 110,
            downloadMtu = 900,
            queryTimeoutMs = 1500,
            retryCount = 4,
            pingIntervalMs = 5000,
        )

        private fun selector(): Pair<ResolverHealthMonitor, HealthResolverSelector> {
            val monitor = ResolverHealthMonitor(log)
            monitor.reportTunnelSuccess(relayA.endpoint, 40)
            monitor.reportTunnelSuccess(relayB.endpoint, 90)
            return monitor to HealthResolverSelector(monitor)
        }

        @BeforeClass
        @JvmStatic
        fun setUp() {
            require(key.isNotEmpty()) { "AMTUNNEL_KEY is required for the integration suite" }
            http = HttpProbeServer(body)
            http.start()
            relayA = UdpRelay("relay-a", serverHost, serverPort)
            relayB = UdpRelay("relay-b", serverHost, serverPort)
            relayA.start()
            relayB.start()
            dnsOnly = PlainDnsStub()
            dnsOnly.start()
            log.info("it", "http probe on 127.0.0.1:${http.port}, relays ${relayA.port}/${relayB.port}, server $serverHost:$serverPort")
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            runCatching { relayA.kill() }
            runCatching { relayB.kill() }
            runCatching { dnsOnly.kill() }
            runCatching { http.stop() }
            println("=== tunnel log ===")
            println(log.dump())
        }
    }

    @Test
    fun test1_tunnelCapabilityProbeSeparatesRealFromDnsOnlyResolvers() {
        val probe = TunnelCapabilityProbe(config(), log)

        val capable = probe.probe(relayA.endpoint)
        assertTrue("relay in front of a real server must be tunnel capable: ${capable.detail}", capable.capable)
        assertTrue("handshake should have been measured", capable.handshakeMs >= 0)

        val incapable = probe.probe(dnsOnly.endpoint)
        assertFalse(
            "a resolver that only answers A queries must NOT be reported as tunnel capable",
            incapable.capable,
        )
        println("dns-only resolver reported: ${incapable.detail}")
        assertTrue("the dns-only stub should have been queried", dnsOnly.answered.get() > 0)
    }

    @Test
    fun test2_realHttpTrafficFlowsThroughTheDnsTunnel() {
        val (_, selector) = selector()
        val transport = MasterDnsTransport(config(), selector, log)
        try {
            assertTrue("session handshake failed", transport.start(20_000))
            assertTrue("transport must be ready", transport.isReady)

            val stream = transport.openStream("127.0.0.1", http.port, 20_000)
            assertNotNull("stream setup through the tunnel failed", stream)

            val request = "GET /probe HTTP/1.1\r\nHost: 127.0.0.1\r\nConnection: close\r\n\r\n"
            stream!!.write(request.toByteArray())

            val response = StringBuilder()
            val buffer = ByteArray(2048)
            val deadline = System.currentTimeMillis() + 40_000
            while (System.currentTimeMillis() < deadline) {
                val n = stream.read(buffer, 0, buffer.size, 2000)
                if (n < 0) break
                if (n > 0) response.append(String(buffer, 0, n))
                if (response.contains(body)) break
            }
            stream.close()

            val text = response.toString()
            assertTrue("expected HTTP 200, got: ${text.take(120)}", text.contains("200"))
            assertTrue("expected tunneled payload in response", text.contains(body))
            val stats = transport.stats()
            assertTrue("packets were sent", stats.packetsSent > 0)
            assertTrue("download bytes were received", stats.bytesDown > 0)
            println(
                "tunnel stats: tx=${stats.packetsSent} rx=${stats.responsesReceived} " +
                    "up=${stats.bytesUp}B down=${stats.bytesDown}B rtt=${stats.lastRttMs}ms",
            )
        } finally {
            transport.stop()
        }
    }

    @Test
    fun test3_failoverSurvivesResolverLossWithoutReconnecting() {
        val (monitor, selector) = selector()
        val transport = MasterDnsTransport(config(), selector, log)
        try {
            assertTrue("session handshake failed", transport.start(20_000))
            val firstResolver = transport.stats().currentResolver
            assertEquals("should start on relay A (lowest handshake time)", relayA.endpoint.key, firstResolver)

            // Kill the resolver the session is currently using. The tunnel server
            // itself stays up: only the forwarding path breaks.
            relayA.kill()
            log.info("it", "killed relay A (${relayA.endpoint.key}) - expecting failover to relay B")

            // Any packet now hits relay A first and must time out, then the
            // transport must move to relay B without re-running SESSION_INIT.
            val stream = transport.openStream("127.0.0.1", http.port, 30_000)
            assertNotNull("stream setup failed after resolver loss", stream)
            val request = "GET /probe HTTP/1.1\r\nHost: 127.0.0.1\r\nConnection: close\r\n\r\n"
            stream!!.write(request.toByteArray())

            val response = StringBuilder()
            val buffer = ByteArray(2048)
            val deadline = System.currentTimeMillis() + 40_000
            while (System.currentTimeMillis() < deadline) {
                val n = stream.read(buffer, 0, buffer.size, 2000)
                if (n < 0) break
                if (n > 0) response.append(String(buffer, 0, n))
                if (response.contains(body)) break
            }
            stream.close()

            val stats = transport.stats()
            assertTrue("traffic must still flow through the surviving resolver", response.contains(body))
            assertEquals("failover should have moved to relay B", relayB.endpoint.key, stats.currentResolver)
            assertTrue("resolver switch counter should increment", stats.resolverSwitches > 0)
            assertEquals("no session re-handshake should have been required", 0, stats.recoveries)
            println(
                "failover stats: resolver=${stats.currentResolver} switches=${stats.resolverSwitches} " +
                    "recoveries=${stats.recoveries} timeouts=${stats.timeouts}",
            )
            monitor.snapshot().forEach { println("health: ${it.endpoint.key} ${it.status} ${it.lastError}") }
        } finally {
            transport.stop()
        }
    }
}
