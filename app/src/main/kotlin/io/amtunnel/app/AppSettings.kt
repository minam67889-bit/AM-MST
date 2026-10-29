package io.amtunnel.app

import android.content.Context
import io.amtunnel.core.transport.EncryptionMethod

data class AppSettings(
    val domain: String = "",
    val encryptionMethod: Int = EncryptionMethod.XOR,
    val encryptionKey: String = "",
    val uploadMtu: Int = 120,
    val downloadMtu: Int = 1200,
    val socksPort: Int = 1080,
    val socksEnabled: Boolean = true,
    val autoFailover: Boolean = true,
    val autoScan: Boolean = true,
    val dnsMode: Boolean = false,
    val upstreamDns: String = "1.1.1.1",
    /** `RESOLVER_BALANCING_STRATEGY` 0..8, upstream default 2 (round robin). */
    val balancingStrategy: Int = 2,
    /** `PACKET_DUPLICATION_COUNT`, upstream default 2. */
    val packetDuplication: Int = 2,
    /** `STREAM_RESOLVER_FAILOVER_RESEND_THRESHOLD`, upstream default 2. */
    val streamFailoverThreshold: Int = 2,
    /** `AUTO_DISABLE_TIMEOUT_SERVERS`, upstream default true, 30 s window. */
    val autoDisableResolvers: Boolean = true,
    val autoDisableWindowSeconds: Int = 30,

    // ---- BD NET mode -------------------------------------------------------
    /**
     * 0 = our own Master core (DNS tunnel built in this repo),
     * 1 = drive BD NET's own dnstt client against BD's servers,
     * 2 = run Psiphon's tunnel core (the engine BD NET ships, no account).
     */
    val engineMode: Int = 0,
    val bdHosts: String = DEFAULT_BD_HOSTS,
    val bdZonePrefix: String = "sd-",
    val bdReport: String = "BD NET VPN",
    val bdPubkey: String = "prince",
    val bdUtls: String = "",
    val bdLocalPort: Int = 7000,
    val bdUpstreamUser: String = "tanginaka",
    val bdUpstreamPass: String = "wagditokupal",

    // ---- Psiphon mode ------------------------------------------------------
    /** Exit region ("US", "GB", ...); blank lets Psiphon pick the fastest. */
    val psiphonRegion: String = "",
) {
    fun isValid(): Boolean = domain.isNotBlank()

    companion object {
        private const val PREFS = "amtunnel.settings"

        const val ENGINE_MASTER = 0
        const val ENGINE_BD_NATIVE = 1
        const val ENGINE_PSIPHON = 2

        /**
         * The SlowDNS hosts BD NET bundles (config key `Free_servers` ->
         * `SlowDns Global`). The zone for each one is `sd-` + the hostname.
         */
        val DEFAULT_BD_HOSTS: String = (1..20).joinToString(";") { "de$it.liftmeon.org" }

        fun bdHostList(raw: String): List<String> =
            raw.split(';', ',', ' ', '\n').map { it.trim() }.filter { it.isNotEmpty() }

        fun load(context: Context): AppSettings {
            val p = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
            return AppSettings(
                domain = p.getString("domain", "") ?: "",
                encryptionMethod = p.getInt("encryption_method", EncryptionMethod.XOR),
                encryptionKey = p.getString("encryption_key", "") ?: "",
                uploadMtu = p.getInt("upload_mtu", 120),
                downloadMtu = p.getInt("download_mtu", 1200),
                socksPort = p.getInt("socks_port", 1080),
                socksEnabled = p.getBoolean("socks_enabled", true),
                autoFailover = p.getBoolean("auto_failover", true),
                autoScan = p.getBoolean("auto_scan", true),
                dnsMode = p.getBoolean("dns_mode", false),
                upstreamDns = p.getString("upstream_dns", "1.1.1.1") ?: "1.1.1.1",
                balancingStrategy = p.getInt("balancing_strategy", 2),
                packetDuplication = p.getInt("packet_duplication", 2),
                streamFailoverThreshold = p.getInt("stream_failover_threshold", 2),
                autoDisableResolvers = p.getBoolean("auto_disable_resolvers", true),
                autoDisableWindowSeconds = p.getInt("auto_disable_window_seconds", 30),
                engineMode = p.getInt("engine_mode", 0),
                bdHosts = p.getString("bd_hosts", DEFAULT_BD_HOSTS) ?: DEFAULT_BD_HOSTS,
                bdZonePrefix = p.getString("bd_zone_prefix", "sd-") ?: "sd-",
                bdReport = p.getString("bd_report", "BD NET VPN") ?: "BD NET VPN",
                bdPubkey = p.getString("bd_pubkey", "prince") ?: "prince",
                bdUtls = p.getString("bd_utls", "") ?: "",
                bdLocalPort = p.getInt("bd_local_port", 7000),
                bdUpstreamUser = p.getString("bd_upstream_user", "tanginaka") ?: "tanginaka",
                bdUpstreamPass = p.getString("bd_upstream_pass", "wagditokupal") ?: "wagditokupal",
                psiphonRegion = p.getString("psiphon_region", "") ?: "",
            )
        }

        fun save(context: Context, settings: AppSettings) {
            context.getSharedPreferences(PREFS, Context.MODE_PRIVATE).edit().apply {
                putString("domain", settings.domain)
                putInt("encryption_method", settings.encryptionMethod)
                putString("encryption_key", settings.encryptionKey)
                putInt("upload_mtu", settings.uploadMtu)
                putInt("download_mtu", settings.downloadMtu)
                putInt("socks_port", settings.socksPort)
                putBoolean("socks_enabled", settings.socksEnabled)
                putBoolean("auto_failover", settings.autoFailover)
                putBoolean("auto_scan", settings.autoScan)
                putBoolean("dns_mode", settings.dnsMode)
                putString("upstream_dns", settings.upstreamDns)
                putInt("balancing_strategy", settings.balancingStrategy)
                putInt("packet_duplication", settings.packetDuplication)
                putInt("stream_failover_threshold", settings.streamFailoverThreshold)
                putBoolean("auto_disable_resolvers", settings.autoDisableResolvers)
                putInt("auto_disable_window_seconds", settings.autoDisableWindowSeconds)
                putInt("engine_mode", settings.engineMode)
                putString("bd_hosts", settings.bdHosts)
                putString("bd_zone_prefix", settings.bdZonePrefix)
                putString("bd_report", settings.bdReport)
                putString("bd_pubkey", settings.bdPubkey)
                putString("bd_utls", settings.bdUtls)
                putInt("bd_local_port", settings.bdLocalPort)
                putString("bd_upstream_user", settings.bdUpstreamUser)
                putString("bd_upstream_pass", settings.bdUpstreamPass)
                putString("psiphon_region", settings.psiphonRegion)
            }.apply()
        }
    }
}
