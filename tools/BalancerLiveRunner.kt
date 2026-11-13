package io.amtunnel.core.transport

import io.amtunnel.core.dns.ResolverEndpoint
import io.amtunnel.core.dns.ResolverSource
import java.io.File
import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.InetSocketAddress
import kotlin.random.Random
import kotlin.system.exitProcess

/**
 * Host-side harness that runs the **shipping** balancer (`MasterBalancer.kt`,
 * the port of MasterDnsVPN's `internal/client/balancer.go`) against live
 * resolvers instead of a unit-test fake.
 *
 *     java -jar balancer-live.jar hosts.txt [strategy] [rounds]
 *
 * `hosts.txt` is one `host[:port]` per line.  Every probe below is a real
 * UDP/53 DNS query; the RTTs and timeouts it produces are fed straight into
 * `reportSend` / `reportSuccess` / `reportTimeout`, and the resolver the
 * balancer then hands out for the *next* packet is printed.  Nothing is
 * simulated, so a green run means the balancer picks working resolvers on a
 * network where some of them are dead.
 */
private const val QTYPE_TXT = 16

private data class Probe(val host: String, val ip: String, val port: Int, val latencyMs: Long?,
                         val rcode: Int?, val note: String)

private fun buildQuery(name: String, id: Int): ByteArray {
    val out = java.io.ByteArrayOutputStream()
    out.write(byteArrayOf((id ushr 8).toByte(), id.toByte(), 0x01, 0x00, 0, 1, 0, 0, 0, 0, 0, 0))
    for (label in name.split('.')) {
        if (label.isEmpty()) continue
        out.write(label.length)
        out.write(label.toByteArray(Charsets.US_ASCII))
    }
    out.write(0)
    out.write(byteArrayOf(0, QTYPE_TXT.toByte(), 0, 1))
    return out.toByteArray()
}

private fun probe(ip: String, port: Int, suffix: String, timeoutMs: Int): Probe {
    val name = "${(1..10).map { ('a' + Random.nextInt(26)) }.joinToString("")}.$suffix"
    val id = Random.nextInt(0x10000)
    val started = System.nanoTime()
    return try {
        DatagramSocket().use { socket ->
            socket.soTimeout = timeoutMs
            val query = buildQuery(name, id)
            socket.send(DatagramPacket(query, query.size, InetSocketAddress(ip, port)))
            val buf = ByteArray(4096)
            val reply = DatagramPacket(buf, buf.size)
            socket.receive(reply)
            val ms = (System.nanoTime() - started) / 1_000_000
            val rcode = if (reply.length > 3) buf[3].toInt() and 0x0F else -1
            val answers = if (reply.length > 7) ((buf[6].toInt() and 0xFF) shl 8) or (buf[7].toInt() and 0xFF) else 0
            Probe(ip, ip, port, ms, rcode, "answers=$answers bytes=${reply.length}")
        }
    } catch (e: Exception) {
        Probe(ip, ip, port, null, null, e.javaClass.simpleName)
    }
}

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        System.err.println("usage: BalancerLiveRunner <hosts.txt> [strategyId] [rounds]")
        exitProcess(2)
    }
    val hostsFile = File(args[0])
    val strategy = BalancingStrategy.fromId(args.getOrNull(1)?.toIntOrNull() ?: 5)
    val rounds = args.getOrNull(2)?.toIntOrNull() ?: 3
    val timeoutMs = 2_500

    val entries = hostsFile.readLines().map { it.trim() }.filter { it.isNotEmpty() && !it.startsWith("#") }
    if (entries.isEmpty()) {
        System.err.println("no hosts in ${hostsFile.path}")
        exitProcess(2)
    }

    // Resolve first: a tunnel server that does not even resolve is dead weight.
    val endpoints = ArrayList<ResolverEndpoint>()
    val dead = ArrayList<String>()
    for (line in entries) {
        val host = line.substringBefore(':').trim()
        val port = line.substringAfter(':', "53").trim().toIntOrNull() ?: 53
        val ip = try { InetAddress.getByName(host).hostAddress } catch (e: Exception) { null }
        if (ip == null) { dead.add("$host  (NXDOMAIN)") } else {
            endpoints.add(ResolverEndpoint(address = ip, port = port, label = host,
                                           source = ResolverSource.IMPORTED))
        }
    }

    println("== live balancer run ==")
    println("strategy      : ${strategy.name} (id=${strategy.id})")
    println("endpoints     : ${endpoints.size} resolved, ${dead.size} unresolvable")
    dumpLines(dead)

    val balancer = MasterBalancer(strategy = strategy, seed = 0x5EED)
    balancer.setResolvers(endpoints, activeKeys = endpoints.map { it.key }.toSet())
    val parked = ArrayList<String>()
    balancer.onResolverDisabled = { key, why -> parked.add("$key ($why)") }

    var ok = 0
    var total = 0
    for (round in 1..rounds) {
        println("\n-- round $round --")
        for (ep in endpoints) {
            val p = probe(ep.address, ep.port, suffixOf(ep), timeoutMs)
            total++
            balancer.reportSend(ep.key)
            if (p.latencyMs != null) {
                ok++
                balancer.reportSuccess(ep.key, p.latencyMs)
            } else {
                balancer.reportTimeout(ep.key)
            }
            val verdict = p.latencyMs?.let { "${it}ms  rcode=${p.rcode}  ${p.note}" }
                ?: "timeout  (${p.note})"
            println("  ${ep.label.padEnd(30)} ${ep.address.padEnd(16)} $verdict")
        }
    }

    println("\n-- balancer view --")
    println("  ${"resolver".padEnd(30)} ${"ip".padEnd(16)} ${"sent".padStart(5)} ${"lost".padStart(5)} " +
            "${"rtt".padStart(8)} ${"score".padStart(6)}  active")
    for (row in balancer.snapshot()) {
        val ep = endpoints.first { it.key == row.key }
        val rtt = row.latencyMs?.let { "%.1f".format(it) } ?: "-"
        println("  ${ep.label.padEnd(30)} ${ep.address.padEnd(16)} ${row.sent.toString().padStart(5)} " +
                "${row.lost.toString().padStart(5)} ${rtt.padStart(8)} ${row.hybridScore.toString().padStart(6)}  ${row.active}")
    }

    println("\n-- routing decisions the tunnel would use --")
    println("  active pool      : ${balancer.activeCount}/${balancer.totalCount}")
    println("  nextKey() x6     : " + (1..6).mapNotNull { balancer.nextKey() }.joinToString(" -> "))
    println("  selectTargets(2) : " + balancer.selectTargets(2).joinToString(" + ") + "   (packet duplication)")
    println("  nextForRecheck() : ${balancer.nextForRecheck() ?: "none parked"}")

    if (parked.isNotEmpty()) {
        println("\n-- auto-disabled by the balancer (30 s timeout window) --")
        dumpLines(parked)
    }
    println("\nLIVE RUN ${if (ok > 0) "PASS" else "FAIL"}: $ok/$total probes answered, " +
            "${balancer.activeCount} resolvers still routable")
    if (ok == 0) exitProcess(1)
}

/** Server identity for the probe qname: the parent zone of the tunnel host. */
private fun suffixOf(ep: ResolverEndpoint): String {
    val label = ep.label.ifBlank { ep.address }
    return if (label.contains('.') && !label.first().isDigit()) {
        label.split('.').drop(1).joinToString(".").ifEmpty { label }
    } else {
        "liftmeon.org"
    }
}

private fun dumpLines(lines: List<String>) {
    if (lines.isEmpty()) return
    lines.take(40).forEach { println("  - $it") }
    if (lines.size > 40) println("  ... and ${lines.size - 40} more")
}
