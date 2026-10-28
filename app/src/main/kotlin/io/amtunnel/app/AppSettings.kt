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
            }.apply()
        }
    }
}
