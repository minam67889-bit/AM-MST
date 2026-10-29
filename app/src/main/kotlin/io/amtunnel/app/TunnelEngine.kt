package io.amtunnel.app

import android.content.Context
import io.amtunnel.core.dns.FileResolverStore
import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.dns.ResolverHealthMonitor
import io.amtunnel.core.dns.ResolverScanner
import io.amtunnel.core.dns.ResolverSource
import io.amtunnel.core.dns.ResolverStore
import io.amtunnel.core.dns.ScanMode
import io.amtunnel.core.dns.ScanProgress
import io.amtunnel.core.dns.ScanScheduler
import io.amtunnel.core.dns.ScanSummary
import io.amtunnel.core.net.DnsTunnelRelay
import io.amtunnel.core.net.SocketProtector
import io.amtunnel.core.net.Socks5Relay
import io.amtunnel.core.net.Socks5Server
import io.amtunnel.core.transport.EncryptionMethod
import io.amtunnel.core.transport.BalancerResolverSelector
import io.amtunnel.core.transport.BalancingStrategy
import io.amtunnel.core.transport.MasterBalancer
import io.amtunnel.core.transport.MasterDnsTransport
import io.amtunnel.core.transport.ResolverSelector
import io.amtunnel.core.transport.StaticResolverSelector
import io.amtunnel.core.transport.TransportState
import io.amtunnel.core.transport.TransportStats
import io.amtunnel.core.transport.TunnelConfig
import io.amtunnel.core.transport.TunnelTransport
import io.amtunnel.core.util.TunnelLog
import java.io.File
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Single owner of the DNS engine + tunnel transport + local proxy.
 *
 * The UI never talks to the transport directly: it reads state from here and
 * calls the small command surface (start/stop/scan/import).
 */
class TunnelEngine(private val context: Context) {

    val log = TunnelLog()
    val monitor = ResolverHealthMonitor(log)
    private val store: ResolverStore = FileResolverStore(File(context.filesDir, "resolvers.tsv"))

    @Volatile
    var settings: AppSettings = AppSettings.load(context)
        private set

    private val resolverList = CopyOnWriteArrayList<ResolverEndpoint>()
    private val starting = AtomicBoolean(false)

    @Volatile private var transport: MasterDnsTransport? = null
    @Volatile var balancer: MasterBalancer? = null
        private set
    @Volatile private var socks: Socks5Server? = null
    @Volatile private var relay: Socks5Relay? = null
    @Volatile private var bd: BdNativeClient? = null
    @Volatile private var psiphon: PsiphonClient? = null
    @Volatile private var scheduler: ScanScheduler? = null
    @Volatile private var scanner: ResolverScanner = ResolverScanner(
        monitor, log, TunnelConfig(domain = "invalid"), SocketProtector.Noop,
    )

    /** Set by the VpnService so tunnel sockets bypass the tun (loop protection). */
    @Volatile
    var protector: SocketProtector = SocketProtector.Noop

    private val stateListeners = CopyOnWriteArrayList<() -> Unit>()

    init {
        val loaded = store.load()
        resolverList.addAll(loaded)
        resolverList.forEach { monitor.register(it) }
        scanner = ResolverScanner(monitor, log, buildConfig(settings), protector)
        log.info("engine", "loaded ${resolverList.size} resolver(s) from storage")
    }

    val resolvers: List<ResolverEndpoint> get() = resolverList.toList()

    /** BD NET mode ignores the DNS transport entirely. */
    val isBdMode: Boolean get() = settings.engineMode == AppSettings.ENGINE_BD_NATIVE

    val isPsiphonMode: Boolean get() = settings.engineMode == AppSettings.ENGINE_PSIPHON

    val isRunning: Boolean
        get() = when {
            isBdMode -> bd?.isRunning == true
            isPsiphonMode -> psiphon?.isRunning == true
            else -> transport?.isReady == true
        }

    /** One line the UI can show about the last thing the far end said. */
    @Volatile
    var lastNotice: String = ""
        private set

    /** Which BD server the live tunnel is attached to, when in BD mode. */
    val bdHost: String? get() = bd?.activeHost

    val bdAvailable: Boolean get() = BdNativeClient(context, log).available()

    val isScanning: Boolean get() = scanner.isRunning

    fun stats(): TransportStats = transport?.stats() ?: TransportStats(state = TransportState.IDLE)

    fun socksPort(): Int = socks?.port ?: settings.socksPort

    fun sessionDebug(): String = transport?.sessionDebug() ?: "-"

    fun addListener(listener: () -> Unit) {
        stateListeners.add(listener)
    }

    fun removeListener(listener: () -> Unit) {
        stateListeners.remove(listener)
    }

    fun notifyStateChanged() {
        stateListeners.forEach { runCatching { it() } }
    }

    // ---------------------------------------------------------------- settings

    fun updateSettings(newSettings: AppSettings) {
        settings = newSettings
        AppSettings.save(context, newSettings)
        scanner = ResolverScanner(monitor, log, buildConfig(newSettings), protector)
        notifyStateChanged()
    }

    /**
     * Applies the `key = value` block that install-masterdnsvpn.sh prints, so a
     * fresh server can be set up by pasting one blob instead of typing five
     * fields. Unknown keys are ignored on purpose; `#` starts a comment line.
     */
    fun importProfile(text: String): ProfileImport {
        val values = HashMap<String, String>()
        var resolversText = ""
        text.lineSequence().forEach { raw ->
            val line = raw.substringBefore('#').trim()
            if (line.isEmpty()) return@forEach
            val cut = line.indexOf('=')
            if (cut <= 0) return@forEach
            val key = line.substring(0, cut).trim().lowercase()
            val value = line.substring(cut + 1).trim()
            if (key == "resolvers" || key == "resolver") {
                resolversText = if (resolversText.isEmpty()) value else "$resolversText,$value"
            } else {
                values[key] = value
            }
        }

        val domain = values["domain"]?.trim().orEmpty()
        if (domain.isEmpty()) {
            return ProfileImport(false, "The profile has no `domain = ...` line", 0)
        }

        val updated = settings.copy(
            domain = domain,
            encryptionKey = values["key"] ?: settings.encryptionKey,
            encryptionMethod = values["method"]?.toIntOrNull()?.coerceIn(0, 5) ?: settings.encryptionMethod,
            uploadMtu = values["upload_mtu"]?.toIntOrNull() ?: settings.uploadMtu,
            balancingStrategy = values["strategy"]?.toIntOrNull()?.coerceIn(0, 8)
                ?: settings.balancingStrategy,
            packetDuplication = values["duplication"]?.toIntOrNull()?.coerceIn(1, 10)
                ?: settings.packetDuplication,
        )
        updateSettings(updated)

        val added = if (resolversText.isEmpty()) 0 else addResolvers(resolversText)
        log.info(
            "engine",
            "imported server profile for $domain: ${EncryptionMethod.name(updated.encryptionMethod)}, " +
                "$added new resolver(s), strategy ${updated.balancingStrategy}, " +
                "duplication ${updated.packetDuplication}",
        )
        val problems = buildConfig(updated).validate()
        if (problems.isNotEmpty()) {
            return ProfileImport(false, problems.joinToString("; "), added)
        }
        return ProfileImport(true, "Profile applied for $domain", added)
    }

    data class ProfileImport(val ok: Boolean, val message: String, val resolversAdded: Int)

    private fun buildConfig(s: AppSettings) = TunnelConfig(
        domain = s.domain,
        encryptionMethod = s.encryptionMethod,
        encryptionKey = s.encryptionKey,
        uploadMtu = s.uploadMtu,
        downloadMtu = s.downloadMtu,
        packetDuplication = s.packetDuplication,
        balancingStrategy = s.balancingStrategy,
        streamFailoverThreshold = s.streamFailoverThreshold,
        autoDisableTimedOutResolvers = s.autoDisableResolvers,
        autoDisableWindowMs = s.autoDisableWindowSeconds * 1_000L,
    )

    // ---------------------------------------------------------------- resolvers

    fun addResolvers(text: String, source: ResolverSource = ResolverSource.IMPORTED): Int {
        val parsed = ResolverEndpoint.parseMany(text, source)
        var added = 0
        for (endpoint in parsed) {
            if (resolverList.none { it.key == endpoint.key }) {
                resolverList.add(endpoint)
                monitor.register(endpoint)
                added++
            }
        }
        persistResolvers()
        log.info("engine", "imported $added resolver(s) (${parsed.size} parsed, ${resolverList.size} total)")
        notifyStateChanged()
        return added
    }

    fun addResolver(endpoint: ResolverEndpoint) {
        if (resolverList.none { it.key == endpoint.key }) {
            resolverList.add(endpoint)
            monitor.register(endpoint)
            persistResolvers()
            log.info("engine", "added resolver ${endpoint.key}")
            notifyStateChanged()
        }
    }

    fun setResolverEnabled(endpoint: ResolverEndpoint, enabled: Boolean) {
        val index = resolverList.indexOfFirst { it.key == endpoint.key }
        if (index < 0) return
        resolverList[index] = resolverList[index].copy(enabled = enabled)
        monitor.setEnabled(endpoint, enabled)
        persistResolvers()
        notifyStateChanged()
    }

    fun removeResolver(endpoint: ResolverEndpoint) {
        resolverList.removeAll { it.key == endpoint.key }
        persistResolvers()
        log.info("engine", "removed resolver ${endpoint.key}")
        notifyStateChanged()
    }

    private fun persistResolvers() {
        runCatching { store.save(resolverList.toList()) }
    }

    // ---------------------------------------------------------------- scanning

    fun scan(mode: ScanMode, onProgress: (ScanProgress) -> Unit = {}, onFinished: (ScanSummary) -> Unit = {}) {
        if (resolverList.isEmpty()) {
            log.warn("scan", "no resolvers configured")
            return
        }
        val freshScanner = ResolverScanner(monitor, log, buildConfig(settings), protector)
        scanner = freshScanner
        Thread({
            freshScanner.scan(resolverList.toList(), mode, onProgress) { summary ->
                onFinished(summary)
                notifyStateChanged()
            }
        }, "resolver-scan-${mode.name.lowercase()}").apply {
            isDaemon = true
            start()
        }
    }

    fun stopScan() {
        scanner.cancel()
        log.info("scan", "scan cancellation requested")
    }

    private fun startScheduler(s: AppSettings) {
        if (!s.autoScan) return
        val scheduled = ScanScheduler(
            scannerProvider = { scanner },
            monitor = monitor,
            log = log,
            resolversProvider = { resolverList.toList() },
            recreateScanner = {
                scanner = ResolverScanner(monitor, log, buildConfig(settings), protector)
            },
            onStateChanged = { notifyStateChanged() },
        )
        scheduler = scheduled
        scheduled.start()
    }

    // ---------------------------------------------------------------- lifecycle

    /** Blocking: performs the tunnel handshake. Returns true when READY. */
    fun start(): Boolean {
        if (transport?.isReady == true) return true
        if (!starting.compareAndSet(false, true)) return false
        try {
            val s = settings
            if (s.engineMode == AppSettings.ENGINE_BD_NATIVE) {
                return startBdNative(s)
            }
            if (s.engineMode == AppSettings.ENGINE_PSIPHON) {
                return startPsiphon(s)
            }
            val problems = buildConfig(s).validate()
            if (problems.isNotEmpty()) {
                log.error("engine", "configuration rejected: ${problems.joinToString("; ")}")
                return false
            }
            val enabled = resolverList.filter { it.enabled }
            if (enabled.isEmpty()) {
                log.error("engine", "no enabled resolvers - import or add one first")
                return false
            }

            log.info(
                "engine",
                "starting tunnel: domain=${s.domain}, ${EncryptionMethod.name(s.encryptionMethod)}, " +
                    "${enabled.size} candidate resolver(s)",
            )

            // MasterDnsVPN-style stack: the balancer owns strategy, scoring,
            // auto-disable and stream-sticky failover. Wire format untouched.
            val config = buildConfig(s)
            val newBalancer = MasterBalancer(
                strategy = BalancingStrategy.fromId(config.balancingStrategy),
            ).apply {
                failoverThreshold = config.streamFailoverThreshold
                failoverCooldownMs = config.streamFailoverCooldownMs
                autoDisableEnabled = config.autoDisableTimedOutResolvers
                autoDisableWindowMs = config.autoDisableWindowMs
                recheckInactiveEnabled = config.recheckInactiveResolvers
                setResolvers(enabled)
                onResolverDisabled = { key, reason ->
                    log.warn("balancer", "resolver \$key parked (\$reason) - pool now \$activeCount")
                }
                onResolverReenabled = { key -> log.info("balancer", "resolver \$key is back") }
            }
            val selector: ResolverSelector = if (s.autoFailover) {
                BalancerResolverSelector(newBalancer)
            } else {
                StaticResolverSelector(enabled.first())
            }
            val newTransport = MasterDnsTransport(config, selector, log, protector)
            balancer = newBalancer
            transport = newTransport

            if (!newTransport.start(timeoutMs = 20_000)) {
                log.error("engine", "tunnel handshake failed - see diagnostics")
                transport = null
                return false
            }

            if (s.socksEnabled) {
                val server = Socks5Server({ transport }, log, "127.0.0.1", s.socksPort)
                if (server.start()) {
                    socks = server
                } else {
                    log.error("engine", "SOCKS5 listener failed on port ${s.socksPort}")
                }
            }
            startScheduler(s)
            notifyStateChanged()
            return true
        } finally {
            starting.set(false)
        }
    }

    /**
     * BD NET mode: their client owns the wire, we own the local proxy.
     *
     * `libxdnstt.so` -> 127.0.0.1:<bdLocalPort>  (raw forwarder, SOCKS5 that
     *                   lives at the far end of the tunnel)
     * [Socks5Relay]  -> 127.0.0.1:<socksPort>    (clean, no-auth, for the VPN
     *                   service or any local app)
     */
    private fun startBdNative(s: AppSettings): Boolean {
        val client = BdNativeClient(context, log)
        if (!client.available()) {
            log.error("engine", "BD client binary missing - this build was made without it")
            return false
        }
        val hosts = AppSettings.bdHostList(s.bdHosts)
        if (hosts.isEmpty()) {
            log.error("engine", "no BD server hosts configured")
            return false
        }
        log.info("engine", "BD NET mode: ${hosts.size} candidate server(s), zone ${s.bdZonePrefix}<host>")
        val started = client.start(
            BdNativeClient.Config(
                hosts = hosts,
                zonePrefix = s.bdZonePrefix,
                report = s.bdReport,
                pubkey = s.bdPubkey,
                localPort = s.bdLocalPort,
                utls = s.bdUtls,
            ),
        )
        if (!started) {
            log.error("engine", "BD NET mode: none of the ${hosts.size} server(s) answered")
            return false
        }
        bd = client
        if (s.socksEnabled) {
            val bridge = Socks5Relay(
                upstreamHost = "127.0.0.1",
                upstreamPort = s.bdLocalPort,
                upstreamUser = s.bdUpstreamUser,
                upstreamPass = s.bdUpstreamPass,
                log = log,
                listenPort = s.socksPort,
                onNotice = { message -> lastNotice = message },
            )
            if (bridge.start()) relay = bridge
            else log.error("engine", "could not open the local SOCKS5 bridge on ${s.socksPort}")
        }
        notifyStateChanged()
        return true
    }

    /**
     * Psiphon needs no domain, no resolver list and no account: the binary
     * fetches Psiphon's own server list and lands a no-auth SOCKS5 on the
     * configured port, which is exactly what the acceptance test asked for.
     */
    private fun startPsiphon(s: AppSettings): Boolean {
        val client = PsiphonClient(context, log)
        if (!client.available()) {
            log.error("engine", "Psiphon engine binary missing - this build was made without it")
            return false
        }
        val ok = client.start(
            PsiphonClient.Config(
                socksPort = s.socksPort,
                httpPort = if (s.socksPort == 65535) 65534 else s.socksPort + 1,
                region = s.psiphonRegion,
            ),
        )
        if (!ok) {
            log.error("engine", "Psiphon engine did not open 127.0.0.1:${s.socksPort}")
            return false
        }
        psiphon = client
        notifyStateChanged()
        return true
    }

    fun stop() {
        runCatching { relay?.stop() }
        relay = null
        runCatching { bd?.stop() }
        bd = null
        runCatching { psiphon?.stop() }
        psiphon = null
        balancer = null
        runCatching { scheduler?.stop() }
        scheduler = null
        runCatching { socks?.stop() }
        socks = null
        runCatching { transport?.stop() }
        transport = null
        notifyStateChanged()
    }

    /** Per-resolver live scoring rows for the diagnostics screen. */
    fun balancerRows(): List<MasterBalancer.BalancerRow> = balancer?.snapshot() ?: emptyList()

    fun dnsRelay(): DnsTunnelRelay = DnsTunnelRelay({ transport }, log, settings.upstreamDns, 53)

    fun transportOrNull(): TunnelTransport? = transport

    /** Raw log tail of the BD client, for the diagnostics screen. */
    fun bdTail(): List<String> = bd?.tail() ?: emptyList()

    /** Raw notice tail of the Psiphon engine, for the diagnostics screen. */
    fun psiphonTail(): List<String> = psiphon?.tail() ?: emptyList()

    fun psiphonProtocol(): String = psiphon?.activeProtocol ?: ""

    fun psiphonRegion(): String = psiphon?.activeRegion ?: ""
}

/** Process-wide accessor: the VPN service owns the lifecycle, the UI observes. */
object TunnelRuntime {
    @Volatile private var engine: TunnelEngine? = null

    fun get(context: Context): TunnelEngine {
        val current = engine
        if (current != null) return current
        return synchronized(this) {
            engine ?: TunnelEngine(context.applicationContext).also { engine = it }
        }
    }

    fun peek(): TunnelEngine? = engine
}
