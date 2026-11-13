package io.amtunnel.core.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.CopyOnWriteArrayList

enum class LogLevel { DEBUG, INFO, WARN, ERROR }

data class LogEntry(
    val timestampMs: Long,
    val level: LogLevel,
    val tag: String,
    val message: String,
) {
    fun format(): String {
        val time = SimpleDateFormat("HH:mm:ss.SSS", Locale.US).format(Date(timestampMs))
        return "$time ${level.name.padEnd(5)} [$tag] $message"
    }
}

/**
 * Small thread-safe ring-buffer logger. The Android UI renders the tail of this
 * buffer; tests assert on it; nothing is written to disk unless asked.
 */
class TunnelLog(private val capacity: Int = 600) {
    private val entries = ArrayDeque<LogEntry>(capacity)
    private val listeners = CopyOnWriteArrayList<(LogEntry) -> Unit>()
    private val lock = Any()

    var minLevel: LogLevel = LogLevel.DEBUG

    fun debug(tag: String, message: String) = log(LogLevel.DEBUG, tag, message)
    fun info(tag: String, message: String) = log(LogLevel.INFO, tag, message)
    fun warn(tag: String, message: String) = log(LogLevel.WARN, tag, message)
    fun error(tag: String, message: String) = log(LogLevel.ERROR, tag, message)

    fun log(level: LogLevel, tag: String, message: String) {
        if (level.ordinal < minLevel.ordinal) return
        val entry = LogEntry(System.currentTimeMillis(), level, tag, message)
        synchronized(lock) {
            if (entries.size >= capacity) entries.removeFirst()
            entries.addLast(entry)
        }
        listeners.forEach { it(entry) }
    }

    fun addListener(listener: (LogEntry) -> Unit) {
        listeners.add(listener)
    }

    fun removeListener(listener: (LogEntry) -> Unit) {
        listeners.remove(listener)
    }

    fun snapshot(limit: Int = capacity): List<LogEntry> = synchronized(lock) {
        if (entries.size <= limit) entries.toList() else entries.toList().takeLast(limit)
    }

    fun clear() = synchronized(lock) { entries.clear() }

    fun dump(): String = snapshot().joinToString("\n") { it.format() }
}
