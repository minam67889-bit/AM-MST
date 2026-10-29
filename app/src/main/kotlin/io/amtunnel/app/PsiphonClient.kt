package io.amtunnel.app

import android.content.Context
import android.os.Build
import io.amtunnel.core.util.TunnelLog
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader
import java.net.InetSocketAddress
import java.net.Socket
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean

/**
 * Runs Psiphon's own tunnel core as a child process and leaves a working
 * SOCKS5 proxy on the loopback interface.
 *
 * Why Psiphon: it is the one engine in this whole investigation that needs no
 * account, no credentials and no server of ours - exactly the "install, press
 * connect, it works" shape the user asked for. BD NET itself ships the same
 * code as `libgojni.so` and points it at Psiphon's public network with the
 * placeholder sponsor ids `FFFFFFFFFFFFFFFF`; we compiled the matching
 * command-line client from `psiphon-tunnel-core` v2.0.42 and ship it as
 * `libpsiphon.so` (a static aarch64 ELF, so it needs nothing from the system).
 *
 *     libpsiphon.so -config <filesDir>/psiphon.json
 *       -> SOCKS5 on 127.0.0.1:<socksPort>, HTTP proxy on <socksPort+1>
 *
 * The tunnel notices come back as one JSON object per line, which is how the
 * UI knows which protocol and which exit region are live.
 */
class PsiphonClient(
    private val context: Context,
    private val log: TunnelLog,
) {
    data class Config(
        val socksPort: Int = 1080,
        val httpPort: Int = 1081,
        val region: String = "",
        val readyTimeoutMs: Long = 45_000,
    )

    private val running = AtomicBoolean(false)
    private var process: Process? = null
    private var pump: Thread? = null
    private val recent = CopyOnWriteArrayList<String>()

    @Volatile
    var activeProtocol: String = ""
        private set

    @Volatile
    var activeRegion: String = ""
        private set

    @Volatile
    var socksPort: Int = 1080
        private set

    val isRunning: Boolean get() = running.get() && process?.isAlive == true

    fun binary(): File = File(context.applicationInfo.nativeLibraryDir, "libpsiphon.so")

    fun available(): Boolean = binary().let { it.exists() && it.canExecute() }

    fun configFile(): File = File(context.filesDir, "psiphon.json")

    fun writeConfig(config: Config) {
        val data = File(context.filesDir, "psiphon-data").apply { mkdirs() }
        val platform = "Android_${Build.VERSION.RELEASE}_${context.packageName}"
            .replace(Regex("[^\\w\\-.]"), "_")
        val json = buildString {
            append("{\n")
            append("  \"DataStoreDirectory\": ${quote(data.absolutePath)},\n")
            append("  \"PropagationChannelId\": \"FFFFFFFFFFFFFFFF\",\n")
            append("  \"SponsorId\": \"FFFFFFFFFFFFFFFF\",\n")
            append("  \"EgressRegion\": ${quote(config.region)},\n")
            append("  \"ClientPlatform\": ${quote(platform)},\n")
            append("  \"ClientVersion\": \"1\",\n")
            append("  \"LocalSocksProxyPort\": ${config.socksPort},\n")
            append("  \"LocalHttpProxyPort\": ${config.httpPort},\n")
            append("  \"RemoteServerListUrl\": ${quote(SERVER_LIST_URL)},\n")
            append("  \"RemoteServerListSignaturePublicKey\": ${quote(SERVER_LIST_KEY)},\n")
            append("  \"UseIndistinguishableTLS\": true,\n")
            append("  \"EmitDiagnosticNotices\": true,\n")
            append("  \"EstablishTunnelTimeoutSeconds\": 0\n")
            append("}\n")
        }
        configFile().writeText(json)
    }

    fun start(config: Config): Boolean {
        if (isRunning) return true
        val bin = binary()
        if (!bin.exists()) {
            log.error("psiphon", "libpsiphon.so is not in this build (${bin.absolutePath})")
            return false
        }
        if (!bin.canExecute()) runCatching { bin.setExecutable(true) }
        socksPort = config.socksPort
        runCatching { writeConfig(config) }
            .onFailure {
                log.error("psiphon", "cannot write the config: ${it.message}")
                return false
            }

        log.info(
            "psiphon",
            "starting Psiphon engine - SOCKS5 127.0.0.1:${config.socksPort}, HTTP ${config.httpPort}" +
                if (config.region.isBlank()) "" else ", exit region ${config.region}",
        )
        val proc = try {
            ProcessBuilder(bin.absolutePath, "-config", configFile().absolutePath)
                .redirectErrorStream(true)
                .start()
        } catch (e: Exception) {
            log.error("psiphon", "cannot start the engine: ${e.message}")
            return false
        }
        process = proc
        running.set(true)
        startPump(proc)

        if (probe(config.socksPort, config.readyTimeoutMs)) {
            log.info("psiphon", "SOCKS5 proxy is up on 127.0.0.1:${config.socksPort}")
            return true
        }
        log.warn("psiphon", "the SOCKS5 proxy did not come up in ${config.readyTimeoutMs} ms")
        stop()
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
        activeProtocol = ""
        activeRegion = ""
    }

    fun tail(): List<String> = recent.toList()

    private fun startPump(proc: Process) {
        val thread = Thread({
            runCatching {
                BufferedReader(InputStreamReader(proc.inputStream)).useLines { lines ->
                    lines.forEach { line ->
                        if (line.isBlank()) return@forEach
                        recent.add(line)
                        while (recent.size > 400) recent.removeAt(0)
                        readNotice(line)
                        log.debug("psiphon", summarise(line))
                    }
                }
            }
        }, "psiphon-log")
        thread.isDaemon = true
        thread.start()
        pump = thread
    }

    /** Turns Psiphon's JSON notices into two facts the UI can show. */
    private fun readNotice(line: String) {
        when {
            line.contains("\"noticeType\":\"ConnectedServer\"") -> {
                activeRegion = field(line, "region")
                log.info("psiphon", "tunnel established (${field(line, "protocol")}, ${activeRegion})")
            }
            line.contains("\"noticeType\":\"ActiveTunnel\"") -> {
                activeProtocol = field(line, "protocol")
            }
            line.contains("\"noticeType\":\"ConnectedServerRegion\"") -> {
                activeRegion = field(line, "serverRegion")
                log.info("psiphon", "exit region ${activeRegion.ifBlank { "?" }}")
            }
            line.contains("\"noticeType\":\"Tunnels\"") -> {
                log.info("psiphon", "tunnels: ${field(line, "count")}")
            }
            line.contains("\"noticeType\":\"Error\"") -> {
                log.warn("psiphon", field(line, "message").take(160))
            }
        }
    }

    private fun summarise(line: String): String {
        val message = field(line, "message")
        if (message.isNotBlank()) return message.take(200)
        return line.take(200)
    }

    private fun field(line: String, name: String): String {
        val key = "\"$name\":\""
        val at = line.indexOf(key)
        if (at < 0) {
            val numKey = "\"$name\":"
            val numAt = line.indexOf(numKey)
            if (numAt < 0) return ""
            return line.substring(numAt + numKey.length)
                .takeWhile { it.isDigit() || it == '.' }
        }
        val from = at + key.length
        val to = line.indexOf('"', from)
        if (to < 0) return ""
        return line.substring(from, to)
    }

    /**
     * The proxy listens before the tunnel is established, so the health check
     * is a SOCKS5 greeting answered with "no auth required" (05 00).
     */
    private fun probe(port: Int, timeoutMs: Long): Boolean {
        val deadline = System.currentTimeMillis() + timeoutMs
        while (System.currentTimeMillis() < deadline) {
            if (!isRunning) return false
            try {
                Socket().use { socket ->
                    socket.connect(InetSocketAddress("127.0.0.1", port), 2_000)
                    socket.soTimeout = 4_000
                    socket.getOutputStream().write(byteArrayOf(5, 1, 0))
                    socket.getOutputStream().flush()
                    val reply = ByteArray(2)
                    var read = 0
                    while (read < 2) {
                        val n = socket.getInputStream().read(reply, read, 2 - read)
                        if (n < 0) break
                        read += n
                    }
                    if (read == 2 && reply[0].toInt() == 5 && reply[1].toInt() == 0) return true
                }
            } catch (_: Exception) {
                // not up yet
            }
            Thread.sleep(700)
        }
        return false
    }

    private fun quote(value: String): String =
        "\"" + value.replace("\\", "\\\\").replace("\"", "\\\"") + "\""

    companion object {
        /**
         * Psiphon's public server list, and the key that signs it. These are
         * the same values Psiphon's own client builds ship; BD NET's asset
         * omits them and ships only the sponsor placeholders.
         */
        const val SERVER_LIST_URL =
            "https://s3.amazonaws.com//psiphon/web/mjr4-p23r-puwl/server_list_compressed"

        const val SERVER_LIST_KEY =
            "MIICIDANBgkqhkiG9w0BAQEFAAOCAg0AMIICCAKCAgEAt7Ls+/39r+T6zNW7GiVpJfzq/xvL9SBH5rIFnk0RXYEYavax" +
                "3WS6HOD35eTAqn8AniOwiH+DOkvgSKF2caqk/y1dfq47Pdymtwzp9ikpB1C5OfAysXzBiwVJlCdajBKvBZDerV1cMvRz" +
                "CKvKwRmvDmHgphQQ7WfXIGbRbmmk6opMBh3roE42KcotLFtqp0RRwLtcBRNtCdsrVsjiI1Lqz/lH+T61sGjSjQ3CHMuZY" +
                "SQJZo/KrvzgQXpkaCTdbObxHqb6/+i1qaVOfEsvjoiyzTxJADvSytVtcTjijhPEV6XskJVHE1Zgl+7rATr/pDQkw6DPCN" +
                "BS1+Y6fy7GstZALQXwEDN/qhQI9kWkHijT8ns+i1vGg00Mk/6J75arLhqcodWsdeG/M/moWgqQAnlZAGVtJI1OgeF5fsP" +
                "pXu4kctOfuZlGjVZXQNW34aOzm8r8S0eVZitPlbhcPiR4gT/aSMz/wd8lZlzZYsje/Jr8u/YtlwjjreZrGRmG8KMOzuk" +
                "V3lLmMppXFMvl4bxv6YFEmIuTsOhbLTwFgh7KYNjodLj/LsqRVfwz31PgWQFTEPICV7GCvgVlPRxnofqKSjgTWI4mxDh" +
                "BpVcATvaoBl1L/6WLbFvBsoAUBItWwctO2xalKxF5szhGm8lccoc5MZr8kfE0uxMgsxz4er68iCID+rsCAQM="
    }
}
