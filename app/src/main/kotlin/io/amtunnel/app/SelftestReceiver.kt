package io.amtunnel.app

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import io.amtunnel.core.util.LogLevel

/**
 * Headless end-to-end check, made for CI and for "does my phone really work?"
 *
 * ```
 * adb shell am broadcast -a io.amtunnel.app.SELFTEST -n io.amtunnel.app/.SelftestReceiver
 * adb logcat -d | grep AMTUNNEL-SELFTEST
 * ```
 *
 * It starts whichever engine is configured (SlowDNS/BD NET by default), waits
 * for the local proxy, then sends one real `GET / HTTP/1.0` to example.com
 * *through that proxy* and logs the verdict. Nothing is faked: if the proxy
 * cannot carry the request, the line says so.
 */
class SelftestReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val pending = goAsync()
        val appContext = context.applicationContext
        Thread({
            val started = System.currentTimeMillis()
            var verdict: String
            try {
                val engine = TunnelRuntime.get(appContext)
                engine.log.minLevel = LogLevel.DEBUG
                engine.log.addListener { entry -> Log.i(TAG, "${entry.level} ${entry.tag}: ${entry.message}") }
                val up = engine.start()
                verdict = if (!up) {
                    "FAIL engine did not start (mode ${engine.settings.engineMode}) - ${engine.lastNotice}"
                } else {
                    val port = engine.socksPort()
                    val probe = throughProxy(port, "example.com", 80)
                    "PROXY 127.0.0.1:$port -> $probe"
                }
            } catch (e: Throwable) {
                verdict = "FAIL ${e.javaClass.simpleName}: ${e.message}"
            }
            val seconds = (System.currentTimeMillis() - started) / 1000.0
            Log.i(TAG, "RESULT ${if (verdict.contains("-> HTTP/1.") && !verdict.contains("000")) "OK" else "NO"} $verdict  (${"%.1f".format(seconds)}s)")
            runCatching { TunnelRuntime.peek()?.stop() }
            pending.finish()
        }, "selftest").start()
    }

    /** SOCKS5 (no auth, exactly what Telegram gets) -> CONNECT -> one HTTP GET. */
    private fun throughProxy(port: Int, host: String, targetPort: Int): String = try {
        java.net.Socket().use { socket ->
            socket.connect(java.net.InetSocketAddress("127.0.0.1", port), 5_000)
            socket.soTimeout = 60_000
            val out = socket.getOutputStream()
            val input = java.io.DataInputStream(socket.getInputStream())
            out.write(byteArrayOf(5, 1, 0)); out.flush()
            val ver = input.readUnsignedByte()
            val method = input.readUnsignedByte()
            if (ver != 5 || method != 0) return "FAIL proxy handshake $ver/$method"
            val name = host.toByteArray(Charsets.US_ASCII)
            out.write(byteArrayOf(5, 1, 0, 3, name.size.toByte(), *name,
                ((targetPort shr 8) and 0xFF).toByte(), (targetPort and 0xFF).toByte()))
            out.flush()
            val rep = ByteArray(4).also { input.readFully(it) }
            when (rep[3].toInt()) {
                1 -> input.skipBytes(4)
                3 -> input.skipBytes(input.readUnsignedByte())
                4 -> input.skipBytes(16)
                else -> Unit
            }
            input.skipBytes(2)
            if (rep[1].toInt() != 0) return "FAIL CONNECT code ${rep[1].toInt() and 0xFF}"
            out.write("GET / HTTP/1.0\r\nHost: $host\r\n\r\n".toByteArray(Charsets.US_ASCII))
            out.flush()
            val line = StringBuilder()
            var byte = input.read()
            while (byte >= 0 && line.length < 200 && byte != '\n'.code) {
                line.append(byte.toChar())
                byte = input.read()
            }
            "HTTP/" + line.toString().trim() + " (through the tunnel)"
        }
    } catch (e: Throwable) {
        "FAIL ${e.javaClass.simpleName}: ${e.message}"
    }

    private companion object {
        const val TAG = "AMTUNNEL-SELFTEST"
    }
}
