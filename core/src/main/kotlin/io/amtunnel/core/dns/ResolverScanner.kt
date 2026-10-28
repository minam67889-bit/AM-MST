package io.amtunnel.core.dns

import io.amtunnel.core.net.SocketProtector
import io.amtunnel.core.transport.TunnelConfig
import io.amtunnel.core.util.TunnelLog
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.Semaphore
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

enum class ScanMode {
    /** Plain DNS reachability + latency only. Cheap. */
    REACHABILITY,

    /** Full SESSION_INIT through the resolver: proves tunnel capability. */
    TUNNEL,
}

data class ScanProgress(
    val mode: ScanMode,
    val completed: Int,
    val total: Int,
    val endpoint: ResolverEndpoint,
    val status: ResolverStatus,
    val rttMs: Long,
    val detail: String,
)

data class ScanSummary(
    val mode: ScanMode,
    val total: Int,
    val healthy: Int,
    val degraded: Int,
    val unreachable: Int,
    val tunnelIncapable: Int,
    val cancelled: Boolean,
    val durationMs: Long,
)

/**
 * Concurrent resolver scanner with bounded parallelism.
 *
 * At most [maxConcurrency] probes run at a time; every probe has its own socket
 * timeout, results are pushed into [ResolverHealthMonitor] as they arrive (so
 * the UI can stream them) and [cancel] stops the run at the next batch.
 */
class ResolverScanner(
    private val monitor: ResolverHealthMonitor,
    private val log: TunnelLog,
    private val config: TunnelConfig,
    private val protector: SocketProtector = SocketProtector.Noop,
    private val maxConcurrency: Int = 16,
) {
    private val probe = ResolverProbe(protector = protector)
    private val cancelFlag = AtomicBoolean(false)
    private val running = AtomicBoolean(false)

    val isRunning: Boolean get() = running.get()

    fun cancel() {
        cancelFlag.set(true)
    }

    private data class Outcome(val status: ResolverStatus, val rttMs: Long, val detail: String)

    fun scan(
        endpoints: List<ResolverEndpoint>,
        mode: ScanMode,
        onProgress: (ScanProgress) -> Unit = {},
        onFinished: (ScanSummary) -> Unit = {},
    ): ScanSummary {
        if (!running.compareAndSet(false, true)) {
            log.warn("scan", "a scan is already running")
            return ScanSummary(mode, 0, 0, 0, 0, 0, false, 0)
        }
        cancelFlag.set(false)
        val started = System.currentTimeMillis()
        val targets = endpoints.filter { it.enabled }
        val completed = AtomicInteger(0)
        val healthy = AtomicInteger()
        val degraded = AtomicInteger()
        val unreachable = AtomicInteger()
        val incapable = AtomicInteger()
        val pool = Executors.newFixedThreadPool(minOf(maxConcurrency, maxOf(1, targets.size)))
        val gate = Semaphore(maxConcurrency)

        log.info("scan", "starting ${mode.name} scan of ${targets.size} resolvers (parallel=$maxConcurrency)")

        try {
            for (endpoint in targets) {
                if (cancelFlag.get()) break
                gate.acquire()
                pool.execute {
                    try {
                        if (cancelFlag.get()) return@execute
                        val outcome = when (mode) {
                            ScanMode.REACHABILITY -> probeReachability(endpoint)
                            ScanMode.TUNNEL -> probeTunnel(endpoint)
                        }
                        when (outcome.status) {
                            ResolverStatus.HEALTHY -> healthy.incrementAndGet()
                            ResolverStatus.DEGRADED -> degraded.incrementAndGet()
                            ResolverStatus.UNREACHABLE -> unreachable.incrementAndGet()
                            ResolverStatus.TUNNEL_INCAPABLE -> incapable.incrementAndGet()
                            else -> {}
                        }
                        onProgress(
                            ScanProgress(
                                mode, completed.incrementAndGet(), targets.size, endpoint,
                                outcome.status, outcome.rttMs, outcome.detail,
                            ),
                        )
                    } catch (e: Exception) {
                        log.warn("scan", "probe of ${endpoint.key} failed: ${e.message}")
                    } finally {
                        gate.release()
                    }
                }
            }
            pool.shutdown()
            pool.awaitTermination(90, TimeUnit.SECONDS)
        } catch (e: InterruptedException) {
            log.warn("scan", "scan interrupted")
        } finally {
            pool.shutdownNow()
            running.set(false)
        }

        val summary = ScanSummary(
            mode = mode,
            total = targets.size,
            healthy = healthy.get(),
            degraded = degraded.get(),
            unreachable = unreachable.get(),
            tunnelIncapable = incapable.get(),
            cancelled = cancelFlag.get(),
            durationMs = System.currentTimeMillis() - started,
        )
        log.info(
            "scan",
            "${mode.name} scan finished in ${summary.durationMs}ms: healthy=${summary.healthy} " +
                "degraded=${summary.degraded} unreachable=${summary.unreachable} " +
                "tunnel-incapable=${summary.tunnelIncapable}",
        )
        onFinished(summary)
        return summary
    }

    private fun probeReachability(endpoint: ResolverEndpoint): Outcome {
        val result = probe.probe(endpoint)
        if (!result.reachable) {
            monitor.reportProbeFailure(endpoint, result.error)
            return Outcome(ResolverStatus.UNREACHABLE, -1, result.error)
        }
        monitor.reportProbeSuccess(endpoint, result.rttMs)
        val status = if (result.rttMs > 900) ResolverStatus.DEGRADED else ResolverStatus.HEALTHY
        return Outcome(status, result.rttMs, "rcode=${result.rcode} jitter=${result.jitterMs.toInt()}ms")
    }

    private fun probeTunnel(endpoint: ResolverEndpoint): Outcome {
        val reach = probe.probe(endpoint)
        if (!reach.reachable) {
            monitor.reportProbeFailure(endpoint, reach.error)
            return Outcome(ResolverStatus.UNREACHABLE, -1, reach.error)
        }
        monitor.reportProbeSuccess(endpoint, reach.rttMs)

        val tunnel = TunnelCapabilityProbe(config, log, protector).probe(endpoint)
        return if (tunnel.capable) {
            monitor.reportTunnelSuccess(endpoint, tunnel.handshakeMs)
            Outcome(ResolverStatus.HEALTHY, tunnel.handshakeMs, "tunnel handshake ${tunnel.handshakeMs}ms")
        } else {
            monitor.reportTunnelFailure(endpoint, tunnel.detail)
            Outcome(ResolverStatus.TUNNEL_INCAPABLE, reach.rttMs, tunnel.detail)
        }
    }
}

/**
 * Adaptive scan scheduler.
 *
 * Cheap reachability scans run often; tunnel-capability scans run less often
 * because each performs a full handshake. Cadence tightens when the pool is
 * unhealthy and relaxes when it is stable. Resolvers parked by backoff are
 * still re-checked so they can rejoin automatically.
 */
class ScanScheduler(
    private val scannerProvider: () -> ResolverScanner,
    private val monitor: ResolverHealthMonitor,
    private val log: TunnelLog,
    private val resolversProvider: () -> List<ResolverEndpoint>,
    private val recreateScanner: () -> Unit,
    private val onStateChanged: () -> Unit = {},
) {
    private var thread: Thread? = null
    private var current: ScheduledExecutorService? = null
    private val running = AtomicBoolean(false)

    @Volatile private var nextReachabilityMs: Long = 0
    @Volatile private var nextTunnelMs: Long = 0

    fun start() {
        if (!running.compareAndSet(false, true)) return
        val now = System.currentTimeMillis()
        nextReachabilityMs = now + 3_000
        nextTunnelMs = now + 20_000
        thread = Thread({
            while (running.get()) {
                try {
                    Thread.sleep(1_000)
                    val nowMs = System.currentTimeMillis()
                    if (nowMs >= nextReachabilityMs) {
                        nextReachabilityMs = nowMs + reachabilityInterval()
                        runScan(ScanMode.REACHABILITY)
                    }
                    if (nowMs >= nextTunnelMs) {
                        nextTunnelMs = nowMs + tunnelInterval()
                        runScan(ScanMode.TUNNEL)
                    }
                } catch (e: InterruptedException) {
                    return@Thread
                } catch (e: Exception) {
                    log.warn("scheduler", "scheduled scan failed: ${e.message}")
                }
            }
        }, "resolver-scan-scheduler").apply {
            isDaemon = true
            start()
        }
        log.info("scheduler", "adaptive scan scheduler started")
    }

    private fun runScan(mode: ScanMode) {
        val scanner = scannerProvider()
        if (scanner.isRunning) return
        if (resolversProvider().none { it.enabled }) return
        recreateScanner()
        scannerProvider().scan(resolversProvider(), mode)
        onStateChanged()
    }

    fun stop() {
        running.set(false)
        thread?.interrupt()
        thread = null
        current?.shutdownNow()
        current = null
    }

    private fun reachabilityInterval(): Long {
        val health = monitor.snapshot()
        val healthy = health.count { it.status == ResolverStatus.HEALTHY }
        return when {
            health.isEmpty() -> 30_000
            healthy == 0 -> 15_000
            healthy < (health.size + 1) / 2 -> 30_000
            else -> 120_000
        }
    }

    private fun tunnelInterval(): Long {
        val health = monitor.snapshot()
        val capable = health.count { it.tunnelCapable }
        return when {
            health.isEmpty() -> 60_000
            capable == 0 -> 30_000
            capable < 2 -> 90_000
            else -> 300_000
        }
    }
}
