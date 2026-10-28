package io.amtunnel.core.transport

import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.dns.ResolverHealthMonitor
import io.amtunnel.core.util.TunnelLog

/**
 * Convenience factory that assembles the MasterDnsVPN-style stack:
 * health monitor -> balancer -> selector -> transport.
 *
 * The balancer owns resolver scoring and the balancing strategy; the transport
 * keeps owning the wire format. Nothing here changes a single byte on the wire,
 * so stock MasterDnsVPN servers stay compatible.
 */
object MasterStack {

    class Built(
        val balancer: MasterBalancer,
        val selector: BalancerResolverSelector,
        val transport: MasterDnsTransport,
    )

    fun build(
        config: TunnelConfig,
        resolvers: List<ResolverEndpoint>,
        log: TunnelLog,
        monitor: ResolverHealthMonitor? = null,
        protector: SocketProtector = SocketProtector.Noop,
    ): Built {
        val health = monitor ?: ResolverHealthMonitor(log)
        val balancer = MasterBalancer(
            strategy = BalancingStrategy.fromId(config.balancingStrategy),
        ).apply {
            failoverThreshold = config.streamFailoverThreshold
            failoverCooldownMs = config.streamFailoverCooldownMs
            setResolvers(resolvers)
        }
        val selector = BalancerResolverSelector(balancer)
        val transport = MasterDnsTransport(config, selector, log, protector)
        return Built(balancer, selector, transport)
    }

    /**
     * Push a fresh scan/health result into the balancer without losing the
     * learning it has done for resolvers that are still present.
     */
    fun applyHealth(balancer: MasterBalancer, monitor: ResolverHealthMonitor, config: TunnelConfig) {
        val snapshot = monitor.snapshot()
        val now = System.currentTimeMillis()
        val all = snapshot.map { it.endpoint }
        balancer.setResolvers(all)
        snapshot.forEach { health ->
            val timedOut = health.backoffUntilMs > now ||
                (health.consecutiveFailures > 0 && health.status.name == "UNREACHABLE")
            val usable = health.tunnelCapable || !config.autoDisableTimedOutResolvers
            balancer.setActive(health.endpoint.key, usable && !timedOut)
        }
    }
}
