package io.amtunnel.app

import android.content.Context
import io.amtunnel.core.util.TunnelLog
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.InetAddress
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Runs BD NET's own tunnel client (`libxdnstt.so`, a dnstt fork) as a child
 * process and keeps it on a server that actually answers.
 *
 * Everything about the wire is theirs - we only drive it:
 *
 *     libxdnstt.so -udp <server-ip>:53 -report "BD NET VPN" -pubkey prince \
 *                  sd-<server-host> 127.0.0.1:<localPort>
 *
 * The zone is `sd-` + the hostname the app lists (`de1.liftmeon.org`), and the
 * report string is the app label, which is the licensing gate that unlocks the
 * binary. Those two facts were established empirically; see docs/BDNET-TUNNEL.md.
 *
 * Books: the client's local end is a *raw* TCP forwarder (stock dnstt has no
 * SOCKS of its own), so the SOCKS5 greeting we see on that port is produced by
 * the far end of the tunnel, a round-trip away. That makes a plain "does the
 * port answer at all" probe a genuinely end-to-end health check - and it is
 * exactly what [probe] uses to decide whether the tunnel on this server is up.
 */
class BdNativeClient(
    private val context: Context,
    private val log: TunnelLog,
) {
    data class Config(
        val hosts: List<String>,
        val zonePrefix: String = "sd-",
        val report: String = "BD NET VPN",
        val pubkey: String = "prince",
        val localPort: Int = 7000,
        val utls: String = "",
        val readyTimeoutMs: Long = 14_000,
    )

    private val running = AtomicBoolean(false)
    private var process: Process? = null
    private var pump: Thread? = null
    private val recent = CopyOnWriteArrayList<String>()

    @Volatile
    var activeHost: String? = null
        private set

    @Volatile
    var localPort: Int = 7000
        private set

    val isRunning: Boolean get() = running.get() && process?.isAlive == true

    fun binary(): File = File(context.applicationInfo.nativeLibraryDir, "libxdnstt.so")

    fun available(): Boolean = binary().let { it.exists() && it.canExecute() }

    /** Tries each host in order; returns the one whose tunnel answers. */
    fun start(config: Config): Boolean {
        if (isRunning) return true
        val bin = binary()
        if (!bin.exists()) {
            log.error("bd", "libxdnstt.so is not in this build (${bin.absolutePath})")
            return false
        }
        if (!bin.canExecute()) runCatching { bin.setExecutable(true) }

        for (host in config.hosts) {
            if (!running.get() && activeHost != null) break
            val ip = resolve(host)
            if (ip == null) {
                log.warn("bd", "cannot resolve $host - skipping")
                continue
            }
            val port = config.localPort
            val zone = config.zonePrefix + host
            val args = mutableListOf(
                bin.absolutePath,
                "-udp", "$ip:53",
                "-report", config.report,
                "-pubkey", config.pubkey,
            )
            if (config.utls.isNotBlank()) args += listOf("-utls", config.utls)
            args += listOf(zone, "127.0.0.1:$port")

            log.info("bd", "starting ${bin.name} against $host ($ip), zone $zone")
            val proc = try {
                ProcessBuilder(args).redirectErrorStream(true).start()
            } catch (e: Exception) {
                log.error("bd", "cannot start the client: ${e.message}")
                continue
            }
            process = proc
            localPort = port
            running.set(true)
            startPump(proc)

            if (probe(port, config.readyTimeoutMs)) {
                activeHost = host
                log.info("bd", "tunnel is live on $host - local SOCKS end at 127.0.0.1:$port")
                return true
            }
            log.warn("bd", "$host did not answer in ${config.readyTimeoutMs} ms - trying the next one")
            stop()
            running.set(false)
        }
        log.error("bd", "no server answered")
        return false
    }

    fun stop() {
        running.set(false)
        pump?.interrupt()
        pump = null
        process?.let { proc ->
            runCatching { proc.destroy() }
            runCatching { if (!proc.waitFor(2, java.util.concurrent.TimeUnit.SECONDS)) proc.destroyForcibly() }
        }
        process = null
        activeHost = null
    }

    fun tail(): List<String> = recent.toList()

    private fun startPump(proc: Process) {
        val thread = Thread({
            runCatching {
                BufferedReader(InputStreamReader(proc.inputStream)).useLines { lines ->
                    lines.forEach { line ->
                        if (line.isNotBlank()) {
                            recent.add(line)
                            while (recent.size > 200) recent.removeAt(0)
                            log.debug("bd", line)
                        }
                    }
                }
            }
        }, "bd-client-log")
        thread.isDaemon = true
        thread.start()
        pump = thread
    }

    /**
     * End-to-end health check: the SOCKS5 greeting we get back is produced by
     * the far end of the tunnel, roughly one round trip away. A dead tunnel
     * never answers - that was measured (see docs/BDNET-TUNNEL.md).
     */
    private fun probe(port: Int, timeoutMs: Long): Boolean {
        val deadline = System.currentTimeMillis() + timeoutMs
        while (System.currentTimeMillis() < deadline) {
            if (!isRunning) return false
            try {
                Socket().use { socket ->
                    socket.connect(InetSocketAddress("127.0.0.1", port), 2_000)
                    socket.soTimeout = 5_000
                    socket.getOutputStream().write(byteArrayOf(5, 1, 0))
                    socket.getOutputStream().flush()
                    val reply = ByteArray(2)
                    var read = 0
                    while (read < 2) {
                        val n = socket.getInputStream().read(reply, read, 2 - read)
                        if (n < 0) break
                        read += n
                    }
                    if (read == 2 && reply[0].toInt() == 5) return true
                }
            } catch (_: Exception) {
                // not up yet
            }
            Thread.sleep(700)
        }
        return false
    }

    private fun resolve(host: String): String? {
        if (host.matches(Regex("^\\d{1,3}(\\.\\d{1,3}){3}$"))) return host
        return runCatching { InetAddress.getByName(host).hostAddress }.getOrNull()
    }
}
