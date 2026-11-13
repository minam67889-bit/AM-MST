package io.amtunnel.core.dns

import io.amtunnel.core.net.SocketProtector
import io.amtunnel.core.net.UdpExchange
import io.amtunnel.core.net.UdpExchangeException
import io.amtunnel.core.transport.DnsEnvelope

data class ProbeResult(
    val reachable: Boolean,
    val rttMs: Long,
    val jitterMs: Double,
    val samples: List<Long>,
    val rcode: Int,
    val error: String,
) {
    companion object {
        fun failure(error: String) = ProbeResult(
            reachable = false, rttMs = -1, jitterMs = -1.0, samples = emptyList(), rcode = -1, error = error,
        )
    }
}

/**
 * Cheap reachability/latency probe: a plain A query to the resolver.
 *
 * This deliberately only proves that the resolver answers DNS. It says nothing
 * about whether it will carry tunnel payloads - see [TunnelCapabilityProbe].
 */
class ResolverProbe(
    private val queryName: String = DEFAULT_QUERY_NAME,
    private val samples: Int = 2,
    private val timeoutMs: Int = 1500,
    private val protector: SocketProtector = SocketProtector.Noop,
) {
    fun probe(endpoint: ResolverEndpoint): ProbeResult {
        val rtts = ArrayList<Long>(samples)
        var lastError = ""
        var lastRcode = -1
        repeat(maxOf(1, samples)) {
            val id = java.security.SecureRandom().nextInt(0x10000)
            val query = DnsEnvelope.buildSimpleQuery(queryName, DnsEnvelope.TYPE_A, id)
            try {
                val result = UdpExchange.exchange(
                    endpoint.address, endpoint.port, query, timeoutMs, id, protector,
                )
                rtts.add(result.rttMs)
                lastRcode = DnsEnvelope.rcode(result.response)
                // 0=NOERROR 1=FORMERR 2=SERVFAIL 3=NXDOMAIN all prove the resolver replied.
                if (lastRcode > 5) lastError = "unexpected rcode $lastRcode"
            } catch (e: UdpExchangeException) {
                lastError = e.message ?: "timeout"
            } catch (e: Exception) {
                lastError = e.message ?: e.javaClass.simpleName
            }
        }
        if (rtts.isEmpty()) return ProbeResult.failure(lastError.ifEmpty { "no response" })
        val sorted = rtts.sorted()
        val median = sorted[sorted.size / 2]
        val jitter = if (sorted.size > 1) (sorted.last() - sorted.first()).toDouble() else 0.0
        return ProbeResult(
            reachable = true,
            rttMs = median,
            jitterMs = jitter,
            samples = rtts,
            rcode = lastRcode,
            error = lastError,
        )
    }

    companion object {
        const val DEFAULT_QUERY_NAME = "dns.google"
    }
}
