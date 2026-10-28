package io.amtunnel.core.transport

import io.amtunnel.core.util.TunnelLog
import java.util.TreeMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

/**
 * A TCP-like stream carried by the DNS tunnel.
 *
 * Sequencing mirrors the upstream ARQ: client -> server `STREAM_DATA` frames are
 * numbered from 0 and acknowledged individually with `STREAM_DATA_ACK`, while
 * server -> client frames are acknowledged by us and re-ordered here before
 * being handed to the local socket.
 */
class DnsTunnelStream internal constructor(
    val streamId: Int,
    val host: String,
    val port: Int,
    private val transport: MasterDnsTransport,
    private val log: TunnelLog,
) : TunnelStream {

    internal val connectLatch = CountDownLatch(1)
    private val rxQueue = LinkedBlockingQueue<ByteArray>(512)
    private val reorder = TreeMap<Int, ByteArray>()
    private var nextRxSn = 0
    private var nextTxSn = 0
    private val unacked = AtomicInteger(0)
    private val window = 24

    private val lock = ReentrantLock()
    private val changed = lock.newCondition()

    @Volatile internal var connectResult: Boolean? = null
    @Volatile internal var connectError: String? = ""
    @Volatile private var eof = false
    @Volatile private var closed = false

    val isClosed: Boolean get() = closed
    val isEof: Boolean get() = eof

    private fun signal() {
        lock.lock()
        try {
            changed.signalAll()
        } finally {
            lock.unlock()
        }
    }

    internal fun onConnected() {
        connectResult = true
        connectLatch.countDown()
        signal()
    }

    internal fun onConnectFailed(reason: String) {
        if (connectResult == null) {
            connectResult = false
            connectError = reason
        }
        eof = true
        connectLatch.countDown()
        signal()
    }

    internal fun onRemoteData(sn: Int, payload: ByteArray) {
        synchronized(reorder) {
            if (sn < nextRxSn) return
            reorder[sn] = payload
            while (true) {
                val next = reorder.remove(nextRxSn) ?: break
                nextRxSn++
                if (!rxQueue.offer(next)) {
                    log.warn("stream", "rx queue full on stream $streamId, dropping ${next.size}B")
                }
            }
        }
        signal()
    }

    internal fun onRemoteEof() {
        eof = true
        signal()
    }

    internal fun onAck() {
        unacked.decrementAndGet()
        signal()
    }

    internal fun onClosed() {
        closed = true
        eof = true
        signal()
    }

    internal fun nextSequence(): Int = nextTxSn++

    internal fun registerUnacked() {
        unacked.incrementAndGet()
    }

    internal fun unackedCount(): Int = unacked.get()

    override fun write(data: ByteArray, offset: Int, length: Int): Int {
        if (closed) throw java.io.IOException("stream closed")
        var written = 0
        val maxPayload = transport.streamPayloadBudget().coerceAtLeast(16)
        while (written < length) {
            if (closed) throw java.io.IOException("stream closed")
            waitForWindow()
            val chunk = minOf(maxPayload, length - written)
            val payload = data.copyOfRange(offset + written, offset + written + chunk)
            val sn = nextSequence()
            registerUnacked()
            transport.sendStreamData(this, sn, payload)
            written += chunk
        }
        return written
    }

    private fun waitForWindow() {
        val deadline = System.currentTimeMillis() + 60_000
        lock.lock()
        try {
            while (unackedCount() >= window && !closed) {
                val remaining = deadline - System.currentTimeMillis()
                if (remaining <= 0) throw java.io.IOException("stream window timeout")
                changed.await(minOf(remaining, 250), TimeUnit.MILLISECONDS)
            }
            if (closed) throw java.io.IOException("stream closed")
        } finally {
            lock.unlock()
        }
    }

    override fun read(buffer: ByteArray, offset: Int, length: Int, timeoutMs: Int): Int {
        if (length <= 0) return 0
        val deadline = System.currentTimeMillis() + timeoutMs
        while (true) {
            val chunk = rxQueue.poll()
            if (chunk != null) {
                val n = minOf(length, chunk.size)
                System.arraycopy(chunk, 0, buffer, offset, n)
                if (n < chunk.size) {
                    val rest = chunk.copyOfRange(n, chunk.size)
                    val spill = ArrayList<ByteArray>()
                    spill.add(rest)
                    while (true) {
                        val more = rxQueue.poll() ?: break
                        spill.add(more)
                    }
                    spill.asReversed().forEach { rxQueue.offer(it) }
                }
                return n
            }
            if (eof && rxQueue.isEmpty()) return -1
            if (closed) return -1
            val remaining = deadline - System.currentTimeMillis()
            if (remaining <= 0) return 0
            lock.lock()
            try {
                changed.await(minOf(remaining, 100), TimeUnit.MILLISECONDS)
            } finally {
                lock.unlock()
            }
        }
    }

    override fun close() {
        if (closed) return
        closed = true
        eof = true
        transport.sendStreamClose(this)
        signal()
    }

    fun describe(): String = "stream#$streamId $host:$port"
}
