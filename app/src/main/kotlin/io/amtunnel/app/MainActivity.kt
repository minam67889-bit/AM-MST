package io.amtunnel.app

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.net.VpnService
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.dns.ResolverStatus
import io.amtunnel.core.dns.ScanMode
import io.amtunnel.core.transport.EncryptionMethod
import io.amtunnel.core.transport.TransportState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import io.amtunnel.core.transport.BalancingStrategy
import io.amtunnel.core.transport.MasterBalancer

/**
 * Single-screen dashboard: connection state, resolver management, scanning,
 * failover settings and diagnostics.
 *
 * The whole UI is built in code (no XML, no AndroidX) so the debug APK builds
 * with a minimal dependency set.
 */
class MainActivity : Activity() {

    private lateinit var engine: TunnelEngine
    private val handler = Handler(Looper.getMainLooper())

    private lateinit var statusText: TextView
    private lateinit var detailText: TextView
    private lateinit var resolverList: LinearLayout
    private lateinit var logView: TextView
    private lateinit var balancerView: TextView
    private lateinit var connectButton: Button
    private lateinit var disconnectButton: Button
    private lateinit var scanStateText: TextView

    private var lastLogDump = ""

    private val ticker = object : Runnable {
        override fun run() {
            refresh()
            handler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        engine = TunnelRuntime.get(this)
        setContentView(buildUi())
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 11)
        }
    }

    override fun onStart() {
        super.onStart()
        handler.post(ticker)
    }

    override fun onStop() {
        handler.removeCallbacks(ticker)
        super.onStop()
    }

    override fun onResume() {
        super.onResume()
        refresh()
    }

    // --------------------------------------------------------------- UI build

    private val bg = Color.parseColor("#0E1116")
    private val cardBg = Color.parseColor("#171C25")
    private val textPrimary = Color.parseColor("#E6EDF3")
    private val textMuted = Color.parseColor("#8B98A9")
    private val accent = Color.parseColor("#2ECC71")
    private val danger = Color.parseColor("#FF6B6B")

    private fun dp(value: Int): Int = (value * resources.displayMetrics.density).toInt()

    /** Rebuild the form so imported values are visible in every field. */
    private fun rebuildUi() {
        window.decorView.post {
            setContentView(buildUi())
            refresh()
        }
    }

    private fun buildUi(): View {
        val root = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setBackgroundColor(bg)
            setPadding(dp(16), dp(20), dp(16), dp(20))
        }

        root.addView(TextView(this).apply {
            text = "AM Tunnel • MasterDNS engine"
            setTextColor(accent)
            textSize = 20f
            typeface = Typeface.DEFAULT_BOLD
        })
        root.addView(TextView(this).apply {
            text = "DNS-tunnel client with resolver scanning, ranking and failover"
            setTextColor(textMuted)
            textSize = 12f
            setPadding(0, dp(2), 0, dp(14))
        })

        // ---- status card
        statusText = TextView(this).apply {
            text = "Idle"
            setTextColor(textPrimary)
            textSize = 22f
            typeface = Typeface.DEFAULT_BOLD
        }
        detailText = TextView(this).apply {
            text = "-"
            setTextColor(textMuted)
            textSize = 12f
            typeface = Typeface.MONOSPACE
            setPadding(0, dp(4), 0, 0)
        }
        val statusCard = card()
        statusCard.addView(statusText)
        statusCard.addView(detailText)
        root.addView(statusCard)

        // ---- connect buttons
        val buttons = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, dp(12), 0, dp(4))
        }
        connectButton = button("Connect", accent) { connect() }
        disconnectButton = button("Disconnect", danger) { disconnect() }
        buttons.addView(connectButton, LinearLayout.LayoutParams(0, dp(48), 1f).apply { rightMargin = dp(8) })
        buttons.addView(disconnectButton, LinearLayout.LayoutParams(0, dp(48), 1f))
        root.addView(buttons)

        scanStateText = TextView(this).apply {
            text = ""
            setTextColor(textMuted)
            textSize = 12f
            setPadding(0, dp(6), 0, 0)
        }
        root.addView(scanStateText)

        // ---- tunnel settings
        root.addView(sectionHeader("Tunnel"))
        val domainField = field("Tunnel domain (e.g. v.example.com)", engine.settings.domain)
        val keyField = field("Encryption key", engine.settings.encryptionKey)
        val methodField = field("Encryption method 0-5 (1 = XOR, 2 = ChaCha20, 3-5 = AES-GCM)", engine.settings.encryptionMethod.toString())
        val mtuField = field("Upload MTU (bytes per query)", engine.settings.uploadMtu.toString())
        val socksPortField = field("Local SOCKS5 port", engine.settings.socksPort.toString())
        val socksCheck = checkbox("Enable local SOCKS5 proxy (real traffic path)", engine.settings.socksEnabled)
        val failoverCheck = checkbox("Automatic resolver failover", engine.settings.autoFailover)
        val autoScanCheck = checkbox("Adaptive background scanning", engine.settings.autoScan)
        val dnsModeCheck = checkbox("DNS-mode VPN (captures DNS only, experimental)", engine.settings.dnsMode)
        // MasterDnsVPN balancing knobs. Numbers are upstream's, so the labels
        // say what each one does rather than inventing new names.
        val strategyField = field(
            "RESOLVER_BALANCING_STRATEGY 0-8  (0 rrobin-default, 1 random, 2 round-robin, " +
                "3 least-loss, 4 lowest-latency, 5 hybrid, 6 loss-then-latency, " +
                "7 top-loss random, 8 top-loss rrobin)",
            engine.settings.balancingStrategy.toString(),
        )
        val duplicationField = field(
            "PACKET_DUPLICATION_COUNT 1-10 (Master default 2)",
            engine.settings.packetDuplication.toString(),
        )
        val autoDisableCheck = checkbox(
            "AUTO_DISABLE_TIMEOUT_SERVERS (park a resolver after it stops answering)",
            engine.settings.autoDisableResolvers,
        )

        val tunnelCard = card()
        tunnelCard.addView(domainField)
        tunnelCard.addView(keyField)
        tunnelCard.addView(methodField)
        tunnelCard.addView(mtuField)
        tunnelCard.addView(socksPortField)
        tunnelCard.addView(socksCheck)
        tunnelCard.addView(failoverCheck)
        tunnelCard.addView(autoScanCheck)
        tunnelCard.addView(dnsModeCheck)
        tunnelCard.addView(strategyField)
        tunnelCard.addView(duplicationField)
        tunnelCard.addView(autoDisableCheck)
        tunnelCard.addView(button("Save settings", Color.parseColor("#4C8DFF")) {
            val updated = engine.settings.copy(
                domain = domainField.text.toString().trim(),
                encryptionKey = keyField.text.toString(),
                encryptionMethod = methodField.text.toString().trim().toIntOrNull() ?: 1,
                uploadMtu = mtuField.text.toString().trim().toIntOrNull() ?: 120,
                socksPort = socksPortField.text.toString().trim().toIntOrNull() ?: 1080,
                socksEnabled = socksCheck.isChecked,
                autoFailover = failoverCheck.isChecked,
                autoScan = autoScanCheck.isChecked,
                dnsMode = dnsModeCheck.isChecked,
                balancingStrategy = (strategyField.text.toString().trim().toIntOrNull() ?: 2).coerceIn(0, 8),
                packetDuplication = (duplicationField.text.toString().trim().toIntOrNull() ?: 2).coerceIn(1, 10),
                autoDisableResolvers = autoDisableCheck.isChecked,
            )
            engine.updateSettings(updated)
            toast(if (updated.isValid()) "Settings saved" else "Saved - tunnel domain is still empty")
            refresh()
        })
        root.addView(tunnelCard)

        // ---- resolvers
        root.addView(sectionHeader("DNS resolvers"))
        val scanCard = card()
        resolverList = LinearLayout(this).apply { orientation = LinearLayout.VERTICAL }
        scanCard.addView(resolverList)
        val scanButtons = LinearLayout(this).apply {
            orientation = LinearLayout.HORIZONTAL
            setPadding(0, dp(8), 0, 0)
        }
        scanButtons.addView(button("Add / import", Color.parseColor("#4C8DFF")) { importDialog() }, weight(1f))
        scanButtons.addView(button("Server profile", Color.parseColor("#4C8DFF")) { profileDialog() }, weight(1f))
        scanButtons.addView(button("Ping scan", Color.parseColor("#9B7BFF")) { scan(ScanMode.REACHABILITY) }, weight(1f))
        scanButtons.addView(button("Tunnel scan", Color.parseColor("#9B7BFF")) { scan(ScanMode.TUNNEL) }, weight(1f))
        scanCard.addView(scanButtons)
        scanCard.addView(button("Stop scan", Color.parseColor("#6B7785")) { engine.stopScan(); refresh() })
        root.addView(scanCard)

        // ---- diagnostics
        root.addView(sectionHeader("Resolver scoring (live)"))
        balancerView = TextView(this).apply {
            setTextColor(Color.parseColor("#8FE3B0"))
            textSize = 10f
            typeface = android.graphics.Typeface.MONOSPACE
            setPadding(0, dp(4), 0, dp(4))
        }
        val balancerCard = card()
        balancerCard.addView(balancerView)
        root.addView(balancerCard)

        root.addView(sectionHeader("Diagnostics"))
        logView = TextView(this).apply {
            setTextColor(Color.parseColor("#B9C7D6"))
            textSize = 10f
            typeface = Typeface.MONOSPACE
            setPadding(dp(8), dp(8), dp(8), dp(8))
            setBackgroundColor(Color.parseColor("#0B0F14"))
            setTextIsSelectable(true)
            text = "(no log yet)"
        }
        val logCard = card()
        logCard.addView(logView, LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, dp(260)))
        val logButtons = LinearLayout(this).apply { orientation = LinearLayout.HORIZONTAL }
        logButtons.addView(button("Clear", Color.parseColor("#6B7785")) { engine.log.clear(); lastLogDump = ""; refresh() }, weight(1f))
        logButtons.addView(button("Copy", Color.parseColor("#6B7785")) {
            val clipboard = getSystemService(CLIPBOARD_SERVICE) as android.content.ClipboardManager
            clipboard.setPrimaryClip(android.content.ClipData.newPlainText("tunnel-log", engine.log.dump()))
            toast("Log copied")
        }, weight(1f))
        logCard.addView(logButtons)
        root.addView(logCard)

        root.addView(TextView(this).apply {
            text = "Protocol: MasterDnsVPN-compatible DNS tunnel (TXT QNAME/QNAME payloads). " +
                "Resolver changes are hot-swappable because the session lives on the server."
            setTextColor(textMuted)
            textSize = 10f
            setPadding(0, dp(16), 0, 0)
        })

        return ScrollView(this).apply { addView(root) }
    }

    private fun card(): LinearLayout = LinearLayout(this).apply {
        orientation = LinearLayout.VERTICAL
        setPadding(dp(12), dp(12), dp(12), dp(12))
        background = GradientDrawable().apply {
            setColor(cardBg)
            cornerRadius = dp(12).toFloat()
        }
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        ).apply { bottomMargin = dp(8) }
    }

    private fun weight(value: Float) =
        LinearLayout.LayoutParams(0, dp(42), value).apply { rightMargin = dp(6) }

    private fun sectionHeader(title: String): TextView = TextView(this).apply {
        text = title.uppercase(Locale.US)
        setTextColor(textMuted)
        textSize = 11f
        letterSpacing = 0.12f
        setPadding(dp(2), dp(14), 0, dp(6))
    }

    private fun field(hint: String, value: String): EditText = EditText(this).apply {
        this.hint = hint
        setText(value)
        setTextColor(textPrimary)
        setHintTextColor(Color.parseColor("#5E6B7C"))
        textSize = 13f
        inputType = InputType.TYPE_CLASS_TEXT
        setSingleLine(true)
        setPadding(dp(8), dp(6), dp(8), dp(6))
        background = GradientDrawable().apply {
            setColor(Color.parseColor("#11161D"))
            cornerRadius = dp(8).toFloat()
            setStroke(dp(1), Color.parseColor("#232B36"))
        }
    }

    private fun checkbox(text: String, checked: Boolean): CheckBox = CheckBox(this).apply {
        this.text = text
        isChecked = checked
        setTextColor(textMuted)
        textSize = 12f
        buttonTintList = android.content.res.ColorStateList.valueOf(accent)
    }

    private fun button(text: String, color: Int, onClick: () -> Unit): Button = Button(this).apply {
        this.text = text
        setTextColor(Color.WHITE)
        textSize = 12f
        isAllCaps = false
        background = GradientDrawable().apply {
            setColor(color)
            cornerRadius = dp(10).toFloat()
        }
        setOnClickListener { onClick() }
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,
        ).apply { topMargin = dp(6) }
    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // --------------------------------------------------------------- actions

    private fun connect() {
        val settings = engine.settings
        if (!settings.isValid()) {
            toast("Enter the tunnel domain first")
            return
        }
        if (settings.dnsMode) {
            @Suppress("DEPRECATION")
            val prepareIntent = VpnService.prepare(this)
            if (prepareIntent != null) {
                startActivityForResult(prepareIntent, REQUEST_VPN)
                return
            }
        }
        startTunnelService()
    }

    private fun startTunnelService() {
        val intent = Intent(this, TunnelVpnService::class.java).setAction(TunnelVpnService.ACTION_START)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            startForegroundService(intent)
        } else {
            startService(intent)
        }
        toast("Connecting…")
        handler.postDelayed({ refresh() }, 800)
    }

    private fun disconnect() {
        val intent = Intent(this, TunnelVpnService::class.java).setAction(TunnelVpnService.ACTION_STOP)
        startService(intent)
        engine.stop()
        refresh()
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_VPN) {
            if (resultCode == RESULT_OK) startTunnelService() else toast("VPN permission denied")
        }
    }

    private fun scan(mode: ScanMode) {
        toast("${mode.name.lowercase()} scan started")
        engine.scan(mode, onProgress = { progress ->
            handler.post {
                scanStateText.text = "scanning ${progress.completed}/${progress.total}: " +
                    "${progress.endpoint.key} → ${progress.status.name.lowercase()} ${progress.detail}"
            }
        }, onFinished = { summary ->
            handler.post {
                scanStateText.text = "${summary.mode.name.lowercase()} scan: ${summary.healthy} healthy, " +
                    "${summary.degraded} degraded, ${summary.unreachable} unreachable, " +
                    "${summary.tunnelIncapable} tunnel-incapable (${summary.durationMs} ms)"
                refresh()
            }
        })
    }

    /**
     * Paste the block printed by server/install-masterdnsvpn.sh: domain, key,
     * method, resolvers, strategy. One paste sets everything up.
     */
    private fun profileDialog() {
        val input = EditText(this).apply {
            hint = "domain = t.example.com\nkey = <hex>\nmethod = 1\nresolvers = 1.1.1.1, 8.8.8.8"
            setTextColor(textPrimary)
            setHintTextColor(textMuted)
            minLines = 8
            gravity = Gravity.TOP
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
        }
        AlertDialog.Builder(this)
            .setTitle("Import server profile")
            .setMessage("Paste the profile block from your server (docs/SERVER.md).")
            .setView(input)
            .setPositiveButton("Apply") { _, _ ->
                val result = engine.importProfile(input.text.toString())
                toast(result.message)
                if (result.ok) rebuildUi()
                refresh()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    private fun importDialog() {
        val input = EditText(this).apply {
            hint = "One per line: 1.1.1.1, 8.8.8.8:53, [2606:4700::1111]:53"
            setTextColor(textPrimary)
            setHintTextColor(textMuted)
            minLines = 6
            gravity = Gravity.TOP
            inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_FLAG_MULTI_LINE
        }
        AlertDialog.Builder(this)
            .setTitle("Add resolvers")
            .setView(input)
            .setPositiveButton("Import") { _, _ ->
                val added = engine.addResolvers(input.text.toString())
                toast("Imported $added resolver(s)")
                refresh()
            }
            .setNegativeButton("Cancel", null)
            .show()
    }

    // --------------------------------------------------------------- refresh

    private fun refresh() {
        val stats = engine.stats()
        if (::balancerView.isInitialized) {
            val rows = engine.balancerRows()
            balancerView.text = if (rows.isEmpty()) {
                "no live pool yet - start the tunnel to see strategy scoring"
            } else {
                val strategy = BalancingStrategy.fromId(engine.settings.balancingStrategy)
                buildString {
                    appendLine("strategy ${strategy.id} ${strategy.name}   pool ${rows.count { it.active }}/${rows.size}")
                    rows.sortedWith(compareByDescending<MasterBalancer.BalancerRow> { it.active }
                        .thenBy { it.hybridScore })
                        .take(25)
                        .forEach { row ->
                            val flag = if (row.active) "+" else "-"
                            val latency = row.latencyMs?.let { "%.0fms".format(it) } ?: "-"
                            appendLine(
                                "%s %-22s sent %-4d lost %-4d loss %-4d %s".format(
                                    flag, row.key, row.sent, row.lost, row.lossScore, latency,
                                ),
                            )
                        }
                }
            }
        }
        val state = stats.state
        statusText.text = when {
            TunnelVpnService.isActive && state == TransportState.READY -> "Connected"
            state == TransportState.INITIALIZING -> "Connecting…"
            state == TransportState.RECOVERING -> "Recovering…"
            state == TransportState.DEGRADED -> "Degraded (failover active)"
            state == TransportState.FAILED -> "Failed"
            else -> "Idle"
        }
        statusText.setTextColor(
            when (state) {
                TransportState.READY -> accent
                TransportState.DEGRADED, TransportState.RECOVERING, TransportState.INITIALIZING -> Color.parseColor("#F5A623")
                TransportState.FAILED -> danger
                else -> textPrimary
            },
        )

        val socksLine = if (engine.settings.socksEnabled) {
            "socks 127.0.0.1:${engine.socksPort()}"
        } else {
            "socks off"
        }
        detailText.text = buildString {
            appendLine("resolver  ${stats.currentResolver}")
            appendLine("session   ${if (stats.sessionId > 0) stats.sessionId else "-"}    $socksLine")
            appendLine("rtt       ${if (stats.lastRttMs >= 0) "${stats.lastRttMs} ms" else "-"}")
            appendLine("packets   tx ${stats.packetsSent}  rx ${stats.responsesReceived}  retx ${stats.retransmits}  timeouts ${stats.timeouts}")
            appendLine("traffic   up ${stats.bytesUp / 1024} KiB  down ${stats.bytesDown / 1024} KiB")
            appendLine("failover  switches ${stats.resolverSwitches}  recoveries ${stats.recoveries}  streams ${stats.activeStreams}")
            append(engine.sessionDebug())
        }

        connectButton.isEnabled = !TunnelVpnService.isActive
        disconnectButton.isEnabled = TunnelVpnService.isActive || state != TransportState.IDLE

        rebuildResolverList()
        refreshLog()
    }

    private fun rebuildResolverList() {
        val resolvers = engine.resolvers
        val health = engine.monitor.snapshot().associateBy { it.endpoint.key }
        val now = System.currentTimeMillis()
        resolverList.removeAllViews()
        if (resolvers.isEmpty()) {
            resolverList.addView(TextView(this).apply {
                text = "No resolvers yet. Use “Add / import”."
                setTextColor(textMuted)
                textSize = 12f
            })
            return
        }
        for (endpoint in resolvers) {
            val h = health[endpoint.key]
            val status = h?.status ?: ResolverStatus.UNKNOWN
            val color = when {
                !endpoint.enabled -> Color.parseColor("#5E6B7C")
                status == ResolverStatus.HEALTHY -> accent
                status == ResolverStatus.DEGRADED -> Color.parseColor("#F5A623")
                status == ResolverStatus.TUNNEL_INCAPABLE -> Color.parseColor("#E86AB2")
                status == ResolverStatus.UNREACHABLE -> danger
                else -> textMuted
            }
            val row = TextView(this).apply {
                text = buildString {
                    append(endpoint.key)
                    if (endpoint.label.isNotBlank()) append("  (${endpoint.label})")
                    append("   ")
                    append(if (h != null) h.statusText(now) else "unknown")
                    if (h != null && h.lastRttMs >= 0) append("  ${h.lastRttMs}ms")
                    if (h != null && h.tunnelCapable) append("  tunnel✓")
                    if (h != null && h.successRate > 0 && h.probeSuccesses + h.probeFailures > 0) {
                        append("  ${(h.successRate * 100).toInt()}%")
                    }
                }
                setTextColor(color)
                textSize = 12f
                typeface = Typeface.MONOSPACE
                setPadding(dp(2), dp(6), dp(2), dp(6))
                setOnClickListener {
                    engine.setResolverEnabled(endpoint, !endpoint.enabled)
                    refresh()
                }
                setOnLongClickListener {
                    AlertDialog.Builder(this@MainActivity)
                        .setTitle("Remove ${endpoint.key}?")
                        .setPositiveButton("Remove") { _, _ -> engine.removeResolver(endpoint); refresh() }
                        .setNegativeButton("Cancel", null)
                        .show()
                    true
                }
            }
            resolverList.addView(row)
        }
        resolverList.addView(TextView(this).apply {
            text = "tap = enable/disable • long-press = remove"
            setTextColor(Color.parseColor("#5E6B7C"))
            textSize = 10f
            setPadding(dp(2), dp(4), 0, 0)
        })
    }

    private fun refreshLog() {
        val dump = engine.log.snapshot(220).joinToString("\n") { entry ->
            val time = SimpleDateFormat("HH:mm:ss", Locale.US).format(Date(entry.timestampMs))
            "$time ${entry.level.name.first()} ${entry.message}"
        }
        if (dump != lastLogDump) {
            lastLogDump = dump
            logView.text = dump.ifEmpty { "(no log yet)" }
        }
    }

    companion object {
        private const val REQUEST_VPN = 42
    }
}
