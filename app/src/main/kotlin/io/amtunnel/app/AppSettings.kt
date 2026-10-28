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
) {
    fun isValid(): Boolean = domain.isNotBlank()

    companion object {
        private const val PREFS = "amtunnel.settings"

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
            }.apply()
        }
    }
}
