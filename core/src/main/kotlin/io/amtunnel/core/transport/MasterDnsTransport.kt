package io.amtunnel.core.transport

import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.net.SocketProtector
import io.amtunnel.core.util.TunnelLog
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.PriorityBlockingQueue
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicLong

/**
 * DNS-tunnel transport: a protocol-compatible client for the
 * MasterDnsVPN server (MIT, masterking32/MasterDnsVPN).
 *
 * Design notes
 * ------------
 * * A single "pump" thread performs all resolver I/O. DNS queries are
 *   request/response over UDP, so serialising them keeps the retransmission
 *   logic deterministic and makes resolver failover trivial.
 * * Every outbound frame is a standalone DNS query. The response to that query
 *   may carry an inbound frame (data, ACK, control) - this is how the tunnel
 *   gets a downstream direction for free.
 * * Resolver selection is delegated to [ResolverSelector]. Because the session
 *   is identified by `(session id, session cookie)` and lives on the server,
 *   switching resolvers mid-session works as long as all resolvers forward to
 *   the same authoritative server.
 * * If every resolver fails, the transport re-runs SESSION_INIT (recovery) and
 *   fails the existing streams, mirroring what the original client does after
 *   a server restart.
 */
class MasterDnsTransport(
    val config: TunnelConfig,
    private val selector: ResolverSelector,
    private val log: TunnelLog,
    private val protector: SocketProtector = SocketProtector.Noop,
) : TunnelTransport {

    /** Present when the caller supplied [BalancerResolverSelector]. */
    val balancer: MasterBalancer? =
        (selector as? BalancerResolverSelector)?.balancer

    private val session = TunnelSession(config, log, protector)
    private val streams = ConcurrentHashMap<Int, DnsTunnelStream>()
    private val outbox = PriorityBlockingQueue<Outbound>()
    private val pending = ConcurrentHashMap<AckSpec, Outbound>()

    private val sent = AtomicLong()
    private val responses = AtomicLong()
    private val retransmits = AtomicLong()
    private val timeouts = AtomicLong()
    private val bytesUp = AtomicLong()
    private val bytesDown = AtomicLong()
    private val lastRtt = AtomicLong(-1)
    private val switches = AtomicInteger()
    private val duplicates = AtomicLong()
    private val duplicateExecutor: java.util.concurrent.ExecutorService =
        java.util.concurrent.Executors.newFixedThreadPool(2) { runnable ->
            Thread(runnable, "dns-duplicate").apply { isDaemon = true }
        }
    private val recoveries = AtomicInteger()

    @Volatile private var state = TransportState.IDLE
    @Volatile private var running = false
    @Volatile private var pump: Thread? = null
    @Volatile private var activeEndpointKey: String? = null
    @Volatile private var consecutiveEndpointFailures = 0
    @Volatile private var consecutiveTotalFailures = 0
    @Volatile private var lastPingMs = 0L
    @Volatile private var lastRecheckMs = 0L
    private val sequence = AtomicLong()
    private val streamIdCounter = AtomicInteger(java.security.SecureRandom().nextInt(0x4000) + 1)

    override val isReady: Boolean get() = state == TransportState.READY || state == TransportState.DEGRADED

    fun state(): TransportState = state

    override fun stats(): TransportStats = TransportStats(
        state = state,
        packetsSent = sent.get(),
        duplicatesSent = duplicates.get(),
        responsesReceived = responses.get(),
        retransmits = retransmits.get(),
        timeouts = timeouts.get(),
        bytesUp = bytesUp.get(),
        bytesDown = bytesDown.get(),
        lastRttMs = lastRtt.get(),
        resolverSwitches = switches.get(),
        recoveries = recoveries.get(),
        activeStreams = streams.size,
        currentResolver = activeEndpointKey ?: "-",
        sessionId = session.sessionId,
    )

    fun sessionDebug(): String = session.debugInfo()

    // ------------------------------------------------------------------ lifecycle

    override fun start(timeoutMs: Int): Boolean {
        val problems = config.validate()
        if (problems.isNotEmpty()) {
            log.error("transport", "invalid configuration: ${problems.joinToString("; ")}")
            state = TransportState.FAILED
            return false
        }
        if (running) return isReady

        state = TransportState.INITIALIZING
        log.info("transport", "session init: domain=${config.domain} ${session.debugInfo()}")

        val deadline = System.currentTimeMillis() + maxOf(2_000, timeoutMs)
        var attempts = 0
        while (System.currentTimeMillis() < deadline) {
            attempts++
            val endpoint = pickEndpoint()
            if (endpoint == null) {
                log.error("transport", "no usable resolver: add or re-scan resolvers")
                state = TransportState.FAILED
                return false
            }
            when (val outcome = session.initialize(endpoint, config.retryCount)) {
                is TunnelSession.InitOutcome.Success -> {
                    selector.reportSuccess(endpoint, outcome.handshakeMs)
                    state = TransportState.READY
                    running = true
                    startPump()
                    log.info("transport", "READY via ${endpoint.key} (handshake ${outcome.handshakeMs}ms)")
                    return true
                }
                is TunnelSession.InitOutcome.Busy -> {
                    log.warn("transport", "server busy via ${endpoint.key}, retrying")
                    Thread.sleep(750)
                }
                is TunnelSession.InitOutcome.Failure -> {
                    selector.reportFailure(endpoint, outcome.error)
                    log.warn("transport", "handshake via ${endpoint.key} failed: ${outcome.error}")
                    activeEndpointKey = null
                }
            }
        }
        log.error("transport", "could not establish a session after $attempts attempts")
        state = TransportState.FAILED
        return false
    }

    override fun stop() {
        running = false
        pump?.interrupt()
        pump = null
        streams.values.forEach { it.onClosed() }
        streams.clear()
        pickEndpoint()?.let { runCatching { session.sendClose(it) } }
        pending.clear()
        outbox.clear()
        duplicateExecutor.shutdownNow()
        state = TransportState.STOPPED
        log.info("transport", "stopped")
    }

    private fun startPump() {
        val thread = Thread({ pumpLoop() }, "tunnel-pump")
        thread.isDaemon = true
        pump = thread
        thread.start()
    }

    // ------------------------------------------------------------------ streams

    override fun openStream(host: String, port: Int, timeoutMs: Int): TunnelStream? {
        if (!isReady) {
            log.error("stream", "transport not ready")
            return null
        }
        var id = streamIdCounter.incrementAndGet() and 0xFFFF
        if (id == 0) id = streamIdCounter.incrementAndGet() and 0xFFFF
        val stream = DnsTunnelStream(id, host, port, this, log)
        streams[id] = stream

        val payload = buildTargetPayload(host, port)
        if (payload == null) {
            log.error("stream", "unsupported target address: $host")
            streams.remove(id)
            return null
        }

        val sn = 0
        val frame = VpnFrame(
            sessionId = session.sessionId,
            packetType = PacketType.SOCKS5_SYN,
            sessionCookie = session.sessionCookie,
            streamId = id,
            sequenceNum = sn,
            fragmentId = 0,
            totalFragments = 1,
            payload = payload,
        )
        log.info("stream", "opening ${stream.describe()} (${payload.size}B SYN)")
        enqueue(
            frame,
            priority = 0,
            ackSpec = AckSpec(
                id, sn,
                intArrayOf(
                    PacketType.SOCKS5_SYN_ACK,
                    PacketType.SOCKS5_CONNECTED,
                    PacketType.SOCKS5_CONNECT_FAIL,
                    PacketType.SOCKS5_HOST_UNREACHABLE,
                    PacketType.SOCKS5_CONNECTION_REFUSED,
                    PacketType.SOCKS5_NETWORK_UNREACHABLE,
                    PacketType.SOCKS5_UPSTREAM_UNAVAILABLE,
                    PacketType.SOCKS5_AUTH_FAILED,
                ),
            ),
        )

        val deadline = System.currentTimeMillis() + maxOf(2_000, timeoutMs)
        while (stream.connectResult == null && System.currentTimeMillis() < deadline) {
            stream.connectLatch.await(
                minOf(200L, maxOf(1L, deadline - System.currentTimeMillis())),
                java.util.concurrent.TimeUnit.MILLISECONDS,
            )
        }
        return when (stream.connectResult) {
            true -> {
                log.info("stream", "connected ${stream.describe()}")
                stream
            }
            false -> {
                log.warn("stream", "connect failed ${stream.describe()}: ${stream.connectError}")
                streams.remove(id)
                enqueueControl(PacketType.STREAM_RST, id, 0)
                null
            }
            null -> {
                log.warn("stream", "connect timeout ${stream.describe()}")
                streams.remove(id)
                stream.onClosed()
                enqueueControl(PacketType.STREAM_RST, id, 0)
                null
            }
        }
    }

    internal fun streamPayloadBudget(): Int =
        session.payloadBudget(PacketType.STREAM_DATA).coerceIn(16, 1024)

    internal fun sendStreamData(stream: DnsTunnelStream, sn: Int, payload: ByteArray) {
        val frame = VpnFrame(
            sessionId = session.sessionId,
            packetType = PacketType.STREAM_DATA,
            sessionCookie = session.sessionCookie,
            streamId = stream.streamId,
            sequenceNum = sn,
            fragmentId = 0,
            totalFragments = 1,
            payload = payload,
        )
        bytesUp.addAndGet(payload.size.toLong())
        enqueue(frame, priority = 3, ackSpec = AckSpec(stream.streamId, sn, intArrayOf(PacketType.STREAM_DATA_ACK)))
    }

    internal fun sendStreamClose(stream: DnsTunnelStream) {
        val sn = stream.nextSequence()
        val frame = VpnFrame(
            sessionId = session.sessionId,
            packetType = PacketType.STREAM_CLOSE_WRITE,
            sessionCookie = session.sessionCookie,
            streamId = stream.streamId,
            sequenceNum = sn,
            payload = ByteArray(0),
        )
        log.info("stream", "closing ${stream.describe()}")
        enqueue(frame, priority = 4, ackSpec = AckSpec(stream.streamId, sn, intArrayOf(PacketType.STREAM_CLOSE_WRITE_ACK)))
        streams.remove(stream.streamId)
    }

    private fun enqueueControl(type: Int, streamId: Int, sn: Int) {
        val frame = VpnFrame(
            sessionId = session.sessionId,
            packetType = type,
            sessionCookie = session.sessionCookie,
            streamId = streamId,
            sequenceNum = sn,
            payload = ByteArray(0),
        )
        enqueue(frame, priority = 1, ackSpec = null)
    }

    private fun buildTargetPayload(host: String, port: Int): ByteArray? {
        val addressBytes = try {
            val ip = java.net.InetAddress.getByName(host)
            ip.address
        } catch (e: Exception) {
            null
        }
        val out = java.io.ByteArrayOutputStream()
        if (addressBytes != null && addressBytes.size == 4) {
            out.write(ATYP_IPV4)
            out.write(addressBytes)
        } else if (addressBytes != null && addressBytes.size == 16) {
            out.write(ATYP_IPV6)
            out.write(addressBytes)
        } else {
            val name = host.toByteArray(Charsets.US_ASCII)
            if (name.size > 255) return null
            out.write(ATYP_DOMAIN)
            out.write(name.size)
            out.write(name)
        }
        out.write((port ushr 8) and 0xFF)
        out.write(port and 0xFF)
        return out.toByteArray()
    }

    // ------------------------------------------------------------------ pump

    private class Outbound(
        val frame: VpnFrame,
        val priority: Int,
        val order: Long,
        val ackSpec: AckSpec?,
    ) : Comparable<Outbound> {
        @Volatile var attempts: Int = 0
        @Volatile var deadlineMs: Long = 0

        override fun compareTo(other: Outbound): Int {
            val byPriority = priority.compareTo(other.priority)
            return if (byPriority != 0) byPriority else order.compareTo(other.order)
        }
    }

    data class AckSpec(val streamId: Int, val sn: Int, val acceptableTypes: IntArray) {
        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (other !is AckSpec) return false
            return streamId == other.streamId && sn == other.sn
        }

        override fun hashCode(): Int = streamId * 31 + sn
    }

    private fun enqueue(frame: VpnFrame, priority: Int, ackSpec: AckSpec?) {
        val item = Outbound(frame, priority, sequence.incrementAndGet(), ackSpec)
        if (ackSpec != null) {
            item.deadlineMs = System.currentTimeMillis() + rtoMs(item.attempts)
            pending[ackSpec] = item
        }
        outbox.add(item)
    }

    private fun rtoMs(attempt: Int): Long =
        (config.queryTimeoutMs.toLong() + 500L * attempt).coerceAtMost(15_000L)

    private fun pumpLoop() {
        log.debug("pump", "pump thread started")
        while (running) {
            try {
                retransmitDue()
                maybePing()
                maybeRecheckResolvers()
                if (consecutiveTotalFailures >= 4 && isReady) {
                    if (!recoverSession()) continue
                }
                val item = outbox.poll(50, java.util.concurrent.TimeUnit.MILLISECONDS) ?: continue
                transmit(item)
            } catch (e: InterruptedException) {
                break
            } catch (e: Exception) {
                log.error("pump", "pump error: ${e.message ?: e.javaClass.simpleName}")
            }
        }
        log.debug("pump", "pump thread exited")
    }

    private fun maybePing() {
        val now = System.currentTimeMillis()
        if (now - lastPingMs < config.pingIntervalMs) return
        lastPingMs = now
        val frame = VpnFrame(
            sessionId = session.sessionId,
            packetType = PacketType.PING,
            sessionCookie = session.sessionCookie,
            payload = ByteArray(0),
        )
        val item = Outbound(frame, priority = 5, order = sequence.incrementAndGet(), ackSpec = null)
        outbox.add(item)
    }

    /**
     * MasterDnsVPN-style packet duplication: put the same frame on the wire via
     * additional healthy resolvers. Only the primary response is processed; the
     * copies exist to beat lossy resolvers, and the server drops duplicate
     * sequence numbers itself.
     */
    private fun duplicateToAlternates(frame: VpnFrame, primary: ResolverEndpoint) {
        val copies = config.packetDuplication - 1
        if (copies <= 0) return
        // The balancer picks the extra paths, like upstream SelectTargets: the
        // primary is the sticky stream resolver, the rest are the best others.
        val alternates = selector.targets(copies + 1, emptySet())
            .filter { it.key != primary.key }
            .take(copies)
        for (alternate in alternates) {
            duplicates.incrementAndGet()
            selector.reportSend(alternate)
            duplicateExecutor.execute {
                try {
                    session.exchange(frame, alternate, config.queryTimeoutMs)
                } catch (_: Exception) {
                    // A duplicate failing is not an error: the primary still owns the result.
                }
            }
        }
    }

    private fun transmit(item: Outbound) {
        val endpoint = pickEndpoint(item.frame.streamId)
        if (endpoint == null) {
            failStream(item, "no usable resolver")
            return
        }
        if (config.packetDuplication > 1 && item.attempts == 0) {
            duplicateToAlternates(item.frame, endpoint)
        }
        sent.incrementAndGet()
        selector.reportSend(endpoint)
        selector.notifyResolverChanged(endpoint)
        try {
            val exchange = session.exchange(item.frame, endpoint, config.queryTimeoutMs)
            responses.incrementAndGet()
            selector.reportSuccess(endpoint, exchange.rttMs)
            lastRtt.set(exchange.rttMs)
            consecutiveEndpointFailures = 0
            consecutiveTotalFailures = 0
            if (state == TransportState.DEGRADED) state = TransportState.READY

            val frame = exchange.frame
            if (frame != null) {
                handleInbound(frame)
            }
            // A frame that we were waiting on an ACK for is retransmitted by the
            // deadline sweep if the ACK did not arrive on this response.
        } catch (e: Exception) {
            timeouts.incrementAndGet()
            consecutiveEndpointFailures++
            consecutiveTotalFailures++
            val reason = e.message ?: e.javaClass.simpleName
            selector.reportFailure(endpoint, reason)
            if (state == TransportState.READY) state = TransportState.DEGRADED
            // Stream-level failover: after N resends (and past the cooldown)
            // move only that stream, leaving the rest of the traffic alone.
            if (item.frame.streamId != 0) balancer?.noteStreamResend(item.frame.streamId)
            if (consecutiveEndpointFailures >= 2) {
                val previous = activeEndpointKey
                activeEndpointKey = null
                switches.incrementAndGet()
                log.warn(
                    "transport",
                    "resolver $previous timed out ($reason) - failing over to ${pickEndpoint()?.key ?: "none"}",
                )
            } else {
                log.debug("transport", "query via ${endpoint.key} failed: $reason")
            }
        }
    }

    private fun failStream(item: Outbound, reason: String) {
        if (item.frame.streamId != 0) balancer?.clearStream(item.frame.streamId)
        item.ackSpec?.let { spec ->
            pending.remove(spec)
            streams[spec.streamId]?.let { stream ->
                if (stream.connectResult == null) stream.onConnectFailed(reason) else stream.onClosed()
                streams.remove(spec.streamId)
            }
        }
        log.warn("transport", "dropping ${PacketType.name(item.frame.packetType)} stream=${item.frame.streamId}: $reason")
    }

    private fun retransmitDue() {
        if (pending.isEmpty()) return
        val now = System.currentTimeMillis()
        val iterator = pending.entries.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            val item = entry.value
            if (item.deadlineMs > now) continue
            if (item.attempts >= config.retryCount + 2) {
                iterator.remove()
                failStream(item, "no acknowledgement after ${item.attempts} attempts")
                continue
            }
            item.attempts++
            item.deadlineMs = now + rtoMs(item.attempts)
            retransmits.incrementAndGet()
            log.debug(
                "transport",
                "retransmit ${PacketType.name(item.frame.packetType)} stream=${item.frame.streamId} " +
                    "sn=${item.frame.sequenceNum} attempt=${item.attempts}",
            )
            outbox.add(item)
        }
    }

    // ------------------------------------------------------------------ inbound

    private fun handleInbound(frame: VpnFrame) {
        if (frame.sessionId != session.sessionId && frame.sessionId != 0) {
            log.debug("transport", "ignoring frame for foreign session ${frame.sessionId}")
            return
        }
        if (frame.packetType != PacketType.STREAM_DATA) {
            log.debug("transport", "rx ${frame.describe()}")
        }

        // Remove the matching pending entry (ACK).
        val acked = pending.keys.filter { spec ->
            spec.streamId == frame.streamId &&
                spec.acceptableTypes.contains(frame.packetType) &&
                (spec.sn == frame.sequenceNum ||
                    frame.packetType == PacketType.SOCKS5_CONNECTED ||
                    frame.packetType == PacketType.SOCKS5_SYN_ACK)
        }
        acked.forEach { pending.remove(it) }

        when (frame.packetType) {
            PacketType.PONG -> {
                lastRtt.set(System.currentTimeMillis() - lastPingMs)
            }
            PacketType.STREAM_DATA -> {
                bytesDown.addAndGet(frame.payload.size.toLong())
                val stream = streams[frame.streamId]
                if (stream != null) {
                    stream.onRemoteData(frame.sequenceNum, frame.payload)
                } else {
                    log.debug("stream", "data for unknown stream ${frame.streamId}, sending RST")
                    enqueueControl(PacketType.STREAM_RST, frame.streamId, frame.sequenceNum)
                }
                enqueueControl(PacketType.STREAM_DATA_ACK, frame.streamId, frame.sequenceNum)
            }
            PacketType.STREAM_DATA_ACK -> {
                streams[frame.streamId]?.onAck()
            }
            PacketType.STREAM_DATA_NACK -> {
                // Re-queue the frame for immediate retransmission.
                val spec = AckSpec(frame.streamId, frame.sequenceNum, intArrayOf(PacketType.STREAM_DATA_ACK))
                pending[spec]?.let {
                    it.deadlineMs = 0
                }
            }
            PacketType.SOCKS5_SYN_ACK, PacketType.SOCKS5_CONNECTED -> {
                streams[frame.streamId]?.onConnected()
                // Acknowledge the setup result so the server can release the timer.
                if (frame.packetType == PacketType.SOCKS5_CONNECTED) {
                    enqueueControl(PacketType.SOCKS5_CONNECTED_ACK, frame.streamId, frame.sequenceNum)
                }
            }
            PacketType.STREAM_CONNECTED -> {
                streams[frame.streamId]?.onConnected()
                enqueueControl(PacketType.STREAM_CONNECTED_ACK, frame.streamId, frame.sequenceNum)
            }
            PacketType.STREAM_CONNECT_FAIL -> {
                streams[frame.streamId]?.onConnectFailed("server reported connect failure")
                enqueueControl(PacketType.STREAM_CONNECT_FAIL_ACK, frame.streamId, frame.sequenceNum)
            }
            PacketType.STREAM_CLOSE_READ -> {
                streams[frame.streamId]?.onRemoteEof()
                enqueueControl(PacketType.STREAM_CLOSE_READ_ACK, frame.streamId, frame.sequenceNum)
            }
            PacketType.STREAM_CLOSE_WRITE -> {
                enqueueControl(PacketType.STREAM_CLOSE_WRITE_ACK, frame.streamId, frame.sequenceNum)
            }
            PacketType.STREAM_CLOSE_WRITE_ACK -> {
                streams.remove(frame.streamId)
            }
            PacketType.STREAM_RST, PacketType.STREAM_RST_ACK -> {
                streams[frame.streamId]?.onClosed()
                streams.remove(frame.streamId)
                if (frame.packetType == PacketType.STREAM_RST) {
                    enqueueControl(PacketType.STREAM_RST_ACK, frame.streamId, frame.sequenceNum)
                }
            }
            PacketType.PACKED_CONTROL_BLOCKS -> {
                var offset = 0
                while (offset + 7 <= frame.payload.size) {
                    val type = frame.payload[offset].toInt() and 0xFF
                    val streamId = ((frame.payload[offset + 1].toInt() and 0xFF) shl 8) or
                        (frame.payload[offset + 2].toInt() and 0xFF)
                    val sn = ((frame.payload[offset + 3].toInt() and 0xFF) shl 8) or
                        (frame.payload[offset + 4].toInt() and 0xFF)
                    if (type == PacketType.STREAM_DATA_ACK) streams[streamId]?.onAck()
                    offset += 7
                }
            }
            PacketType.SESSION_BUSY -> {
                log.warn("transport", "server reported session busy")
            }
            else -> {
                val ack = PacketType.socksFailureAck(frame.packetType)
                if (ack != null) {
                    streams[frame.streamId]?.onConnectFailed("server rejected connect: ${PacketType.name(frame.packetType)}")
                    enqueueControl(ack, frame.streamId, frame.sequenceNum)
                }
            }
        }
    }

    // ------------------------------------------------------------------ recovery

    private fun recoverSession(): Boolean {
        val previous = state
        state = TransportState.RECOVERING
        log.warn("transport", "recovering session after $consecutiveTotalFailures consecutive failures")
        session.reset()
        streams.values.forEach { it.onClosed() }
        streams.clear()
        pending.clear()

        val endpoint = pickEndpoint()
        if (endpoint == null) {
            log.error("transport", "recovery failed: no resolver available")
            state = if (previous == TransportState.READY) TransportState.DEGRADED else TransportState.FAILED
            return false
        }
        when (val outcome = session.initialize(endpoint, 2)) {
            is TunnelSession.InitOutcome.Success -> {
                recoveries.incrementAndGet()
                consecutiveTotalFailures = 0
                state = TransportState.READY
                log.info("transport", "recovered: new session ${session.sessionId} via ${endpoint.key}")
                return true
            }
            is TunnelSession.InitOutcome.Busy -> {
                consecutiveTotalFailures = 0
                state = TransportState.DEGRADED
                log.warn("transport", "recovery postponed: server busy")
                return false
            }
            is TunnelSession.InitOutcome.Failure -> {
                selector.reportFailure(endpoint, outcome.error)
                activeEndpointKey = null
                state = TransportState.DEGRADED
                log.warn("transport", "recovery attempt failed: ${outcome.error}")
                return false
            }
        }
    }

    /**
     * Resolver selection is delegated to the [selector]; a
     * [BalancerResolverSelector] applies the MasterDnsVPN strategy (round robin
     * by default) instead of pinning one box.
     *
     * Stream traffic is sticky: a stream keeps its resolver until it has to
     * fail over, so packets of one stream do not arrive out of order at the
     * server just because the balancer rotated.
     */
    private fun pickEndpoint(streamId: Int = 0): ResolverEndpoint? {
        val balancer = balancer
        if (balancer != null && streamId != 0) {
            balancer.preferredForKey(streamId)?.let { key ->
                balancer.endpointFor(key)?.let { endpoint ->
                    noteEndpoint(endpoint)
                    return endpoint
                }
            }
        }
        val chosen = selector.next(emptySet()) ?: return null
        if (activeEndpointKey != null && chosen.key != activeEndpointKey) switches.incrementAndGet()
        noteEndpoint(chosen)
        return chosen
    }

    private fun noteEndpoint(endpoint: ResolverEndpoint) {
        if (endpoint.key != activeEndpointKey) {
            activeEndpointKey = endpoint.key
            selector.notifyResolverChanged(endpoint)
            log.debug("transport", "using resolver ${endpoint.key}")
        }
    }

    /**
     * `RECHECK_INACTIVE_SERVERS_ENABLED`: probe one parked resolver with a PING
     * and put it back only if it answers, so a dead resolver costs one probe
     * per interval instead of being rotated at random.
     */
    private fun maybeRecheckResolvers() {
        val balancer = balancer ?: return
        if (!config.recheckInactiveResolvers) return
        val now = System.currentTimeMillis()
        if (now - lastRecheckMs < 1_000) return
        lastRecheckMs = now
        val key = balancer.nextForRecheck(now) ?: return
        val endpoint = balancer.endpointFor(key) ?: return
        val frame = VpnFrame(
            sessionId = session.sessionId,
            packetType = PacketType.PING,
            sessionCookie = session.sessionCookie,
            payload = ByteArray(0),
        )
        try {
            val exchange = session.exchange(frame, endpoint, minOf(config.queryTimeoutMs, 1_500))
            balancer.reportSuccess(key, exchange.rttMs)
            balancer.reactivate(key)
            log.info("transport", "resolver $key answered a recheck - back in the pool")
        } catch (_: Exception) {
            log.debug("transport", "recheck: $key still down")
        }
    }

    companion object {
        const val ATYP_IPV4 = 1
        const val ATYP_DOMAIN = 3
        const val ATYP_IPV6 = 4
    }
}
