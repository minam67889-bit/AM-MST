package io.amtunnel.app

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.VpnService
import android.os.Build
import android.os.ParcelFileDescriptor
import io.amtunnel.core.net.SocketProtector
import java.io.FileInputStream
import java.io.FileOutputStream
import java.net.DatagramSocket
import java.net.Socket
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Foreground service that owns the tunnel.
 *
 * Two modes:
 *  * **Proxy mode** (default): the tunnel runs and exposes a local SOCKS5
 *    proxy. No tun interface is created, so no routing changes are made.
 *  * **DNS mode** (opt-in): a tun interface is created that only captures the
 *    virtual DNS address. Every captured DNS query is answered through the
 *    tunnel (DNS-over-TCP inside the tunnel), so lookups cannot leak to the
 *    local network. Full-device TCP routing would require a userland TCP/IP
 *    stack (tun2socks); that is intentionally not shipped - see docs/STATUS.md.
 */
class TunnelVpnService : VpnService() {

    companion object {
        const val ACTION_START = "io.amtunnel.app.action.START"
        const val ACTION_STOP = "io.amtunnel.app.action.STOP"
        private const val CHANNEL_ID = "tunnel"
        private const val NOTIFICATION_ID = 1001
        private const val VPN_ADDRESS = "10.111.222.2"
        private const val VPN_DNS = "10.111.222.1"

        @Volatile
        var isActive: Boolean = false
            private set
    }

    private lateinit var engine: TunnelEngine
    private var tun: ParcelFileDescriptor? = null
    private var tun2socks: Process? = null
    private var tunReader: Thread? = null
    private val running = AtomicBoolean(false)
    private val dnsExecutor = Executors.newFixedThreadPool(4)
    private val notificationManager by lazy { getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }

    override fun onCreate() {
        super.onCreate()
        engine = TunnelRuntime.get(this)
        engine.protector = object : SocketProtector {
            override fun protect(socket: DatagramSocket): Boolean =
                this@TunnelVpnService.protect(socket)

            override fun protect(socket: Socket): Boolean =
                this@TunnelVpnService.protect(socket)
        }
        createChannel()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            ACTION_STOP -> {
                shutdown()
                stopSelf()
                return START_NOT_STICKY
            }
            else -> {
                startForeground(NOTIFICATION_ID, buildNotification("Connecting…"))
                if (running.compareAndSet(false, true)) {
                    isActive = true
                    Thread({
                        val ok = engine.start()
                        if (ok) {
                            if (engine.isBdMode) {
                                establishFullTun()
                            } else if (engine.settings.dnsMode) {
                                establishTun()
                            }
                            updateNotification(buildConnectedText())
                            engine.log.info("service", "tunnel is up")
                        } else {
                            updateNotification("Connection failed - open the app")
                            engine.log.error("service", "tunnel failed to start")
                        }
                    }, "tunnel-start").start()
                } else {
                    updateNotification(buildConnectedText())
                }
            }
        }
        return START_STICKY
    }

    private fun buildConnectedText(): String {
        val socks = if (engine.settings.socksEnabled) "SOCKS5 on 127.0.0.1:${engine.socksPort()}" else "no proxy"
        if (engine.isBdMode) {
            return "BD NET via ${engine.bdHost ?: "?"} • $socks"
        }
        val stats = engine.stats()
        return "Connected via ${stats.currentResolver} • $socks"
    }

    override fun onDestroy() {
        shutdown()
        super.onDestroy()
    }

    override fun onRevoke() {
        engine.log.warn("service", "VPN permission revoked by the system")
        shutdown()
        stopSelf()
    }

    private fun shutdown() {
        running.set(false)
        isActive = false
        runCatching { tunReader?.interrupt() }
        tunReader = null
        runCatching { tun?.close() }
        tun = null
        runCatching { tun2socks?.destroy() }
        tun2socks = null
        runCatching { dnsExecutor.shutdownNow() }
        runCatching { engine.stop() }
        runCatching { stopForeground(android.app.Service.STOP_FOREGROUND_REMOVE) }
        runCatching { notificationManager.cancel(NOTIFICATION_ID) }
    }

    // ------------------------------------------------------------- DNS mode tun

    private fun establishTun() {
        if (tun != null) return
        val builder = Builder()
            .setSession("AM Tunnel MST")
            .setMtu(1500)
            .addAddress(VPN_ADDRESS, 32)
            .addDnsServer(VPN_DNS)
            .addRoute(VPN_DNS, 32)
        val descriptor = try {
            builder.establish()
        } catch (e: Exception) {
            engine.log.error("vpn", "could not establish tun: ${e.message}")
            null
        }
        if (descriptor == null) {
            engine.log.error("vpn", "tun establishment returned null (permission missing?)")
            return
        }
        tun = descriptor
        engine.log.info("vpn", "DNS-mode tun established ($VPN_ADDRESS, DNS $VPN_DNS)")
        val thread = Thread({ readTun(descriptor) }, "tun-reader")
        thread.isDaemon = true
        tunReader = thread
        thread.start()
    }

    private fun readTun(descriptor: ParcelFileDescriptor) {
        val input = FileInputStream(descriptor.fileDescriptor)
        val output = FileOutputStream(descriptor.fileDescriptor)
        val buffer = ByteArray(32767)
        while (running.get()) {
            val length = try {
                input.read(buffer)
            } catch (e: Exception) {
                break
            }
            if (length <= 0) continue
            val query = IpPacket.extractDnsQuery(buffer, length) ?: continue
            dnsExecutor.execute {
                val response = engine.dnsRelay().resolve(query.payload, 6000)
                if (response == null) {
                    engine.log.debug("vpn", "dns query for ${query.name} timed out through tunnel")
                } else {
                    val packet = IpPacket.buildUdpResponse(buffer, length, response)
                    runCatching { output.write(packet) }
                }
            }
        }
        engine.log.info("vpn", "tun reader stopped")
    }

    // ------------------------------------------------- BD mode: whole-device tun

    /**
     * Route everything through the relay.
     *
     * The tun is handed to BD NET's own `libtun2socks.so` (badvpn 1.999.127,
     * shipped in their APK) with `--tunfd`, and it dials our local SOCKS5
     * bridge, which forwards into their tunnel. This is the same arrangement
     * their app uses; the difference is that the SOCKS credentials live in our
     * settings instead of being fixed in their config.
     */
    private fun establishFullTun() {
        if (tun != null) return
        val bin = java.io.File(applicationInfo.nativeLibraryDir, "libtun2socks.so")
        if (!bin.exists()) {
            engine.log.warn("vpn", "libtun2socks.so is not in this build - whole-device VPN unavailable")
            return
        }
        val descriptor = try {
            Builder()
                .setSession("AM Tunnel MST")
                .setMtu(1500)
                .addAddress("10.111.222.2", 32)
                .addDnsServer("1.1.1.1")
                .addDnsServer("8.8.8.8")
                .addRoute("0.0.0.0", 0)
                .addDisallowedApplication(packageName)
                .establish()
        } catch (e: Exception) {
            engine.log.error("vpn", "could not establish tun: ${e.message}")
            null
        }
        if (descriptor == null) {
            engine.log.error("vpn", "tun establishment returned null (permission missing?)")
            return
        }
        val command = listOf(
            bin.absolutePath,
            "--tunfd", descriptor.fd.toString(),
            "--tunmtu", "1500",
            "--netif-ipaddr", "10.111.222.2",
            "--netif-netmask", "255.255.255.0",
            "--socks-server-addr", "127.0.0.1:${engine.socksPort()}",
            "--loglevel", "info",
        )
        val proc = try {
            ProcessBuilder(command).redirectErrorStream(true).start()
            // Keep the descriptor owned by the child: we only close our copy on shutdown.
        } catch (e: Exception) {
            engine.log.error("vpn", "could not start tun2socks: ${e.message}")
            return
        }
        tun2socks = proc
        tun = descriptor
        engine.log.info("vpn", "whole-device tunnel up (tun fd ${descriptor.fd} -> socks 127.0.0.1:${engine.socksPort()})")
        Thread({
            runCatching {
                proc.inputStream.bufferedReader().useLines { lines ->
                    lines.forEach { line -> if (line.isNotBlank()) engine.log.debug("tun2socks", line) }
                }
            }
            engine.log.warn("vpn", "tun2socks exited")
        }, "tun2socks-log").apply { isDaemon = true }.start()
    }

    // ------------------------------------------------------------- notification

    private fun createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(CHANNEL_ID, "Tunnel", NotificationManager.IMPORTANCE_LOW)
            channel.description = "DNS tunnel connection state"
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun buildNotification(text: String): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pending = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE,
        )
        val builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification.Builder(this, CHANNEL_ID)
        } else {
            @Suppress("DEPRECATION")
            Notification.Builder(this)
        }
        return builder
            .setContentTitle("AM Tunnel MST")
            .setContentText(text)
            .setSmallIcon(android.R.drawable.stat_sys_download_done)
            .setContentIntent(pending)
            .setOngoing(true)
            .build()
    }

    private fun updateNotification(text: String) {
        runCatching { notificationManager.notify(NOTIFICATION_ID, buildNotification(text)) }
    }
}
