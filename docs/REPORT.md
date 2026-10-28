# Reverse-engineering report and delivery assessment

## 0. Executive summary

| Question | Answer |
| --- | --- |
| Was the AM Tunnel APK analysed? | **No — blocked.** The only supplied source (`filebin.net`) is unreachable from this environment: TCP connects but TLS is terminated at the edge (`SSL_ERROR_SYSCALL`), identically for `curl` and `wget`. GitHub release assets are blocked too, so no mirror could be fetched. |
| Was the original AM Tunnel client baselined against its servers? | **No — blocked**, because there is no client binary and no server configuration. No claim is made that the modified client reaches AM Tunnel servers. |
| What *was* verified? | A complete, byte-compatible client for a real DNS tunnel protocol (MasterDnsVPN, MIT, source supplied), including resolver management, capability probing, ranking, failover and session recovery — with live end-to-end tests against the reference server compiled from source. |
| Can the existing servers support a multi-resolver client? | For the protocol that *was* analysed: **yes, without any server change**, because the session is server-side and the resolver is only a forwarder. Two resolvers are never simultaneous data paths on the client side; one is active, the rest are standby/health-probed. |
| What remains to ship for AM Tunnel specifically? | One adapter class (`TunnelTransport`) plus its configuration mapping, written after the APK is available. The DNS engine and UI already exist and do not change. |

The rest of this document separates **verified**, **implemented-but-untested**
and **blocked** work, as required.

---

## 1. Inputs

| Input | Status |
| --- | --- |
| `MasterDnsVPN` source (GitHub) | available, cloned at `v2026.10.26.100415-5f83ee9`, 45,117 lines of Go |
| `app.vpn.amtunnellite.zip` (filebin) | **unreachable** from the build environment |
| Working AM Tunnel connection settings | not provided; the app is understood to auto-configure itself, which can only be recovered from the APK |

Environment limits worth stating up front: the analysis sandbox has no JDK, no
Android SDK, no device and no emulator, and its egress allow-list excludes the
file host. All compilation, unit testing and live integration testing therefore
runs in GitHub Actions; APK behaviour on a physical device remains
unverified.

---

## 2. AM Tunnel — what could and could not be established

Public facts (app stores, publisher listings), none of which are enough to
implement a client:

* package `app.vpn.amtunnellite`, publisher "APNA TUNNEL";
* described as a "DNS tunnel"-style VPN with a resolver/server list;
* the variant `co.strongteam.amlite` is a separate, older package;
* no public protocol documentation, no server address, no key material.

**Not established, and deliberately not guessed:**

1. The wire protocol (SlowDNS-like, DNSTT-like, MasterDnsVPN-like, or custom).
2. Whether the selected DNS resolver is used as a *resolver* (forwarder to the
   authoritative tunnel server) or as *the server itself* (tunnel endpoint).
3. Whether the resolvers in its list are interchangeable, i.e. whether they all
   forward to one authoritative server.
4. Authentication: whether the client ships a shared key, derives it, or
   receives a token from a control API.
5. Whether multiple resolvers can be used concurrently by the protocol.

Each of these changes the client design, so implementing the AM Tunnel transport
without the APK would be fabrication. Instead, the client was built so that the
answer plugs in without redesign (Section 6).

### Exact procedure once the APK is available

```bash
unzip app.vpn.amtunnellite.zip
apktool d app.apk -o amtunnel            # manifest, smali, resources
# native libraries and embedded engines:
unzip -l app.apk | grep -E "lib/|assets/" 
# string/endpoint sweep:
grep -RInE "([0-9]{1,3}\.){3}[0-9]{1,3}|:53|dns|tunnel|slowdns|dnstt|kcp|socks" amtunnel/smali* | head -200
jadx -d jadx-out app.apk                 # Java reconstruction
# resolver usage: find the preference key that stores the resolver and every
# call site that reads it; check whether it is passed to one engine instance
# (per-session) or to each query (per-query).
```

Deliverables of that step: a protocol note like `docs/PROTOCOL.md`, the
resolver-usage answer, and a `AmTunnelTransport : TunnelTransport`
implementation. Nothing about the servers needs to change: the client only has
to speak what they already speak.

### Baseline test procedure (blocked today)

With the APK and a legitimate configuration: install on a device, connect,
confirm traffic by fetching a page whose content is only reachable through the
tunnel, record connect time, errors, stability and throughput; then repeat with
the modified client. The plan and the checkpoints are recorded in
`docs/STATUS.md`; the measurements themselves cannot be produced here.

---

## 3. Protocol identification for the engine that *was* analysable

The supplied reference implementation is a DNS tunnel, not a proxy protocol:

* payloads travel in the **QNAME** of TXT queries (client → server) and in
  **TXT answer records** (server → client);
* frames are encrypted with AES-GCM / ChaCha20 / XOR and base36-encoded into
  DNS-safe labels;
* sessions are identified by an 8-bit id + 8-bit cookie issued by the server;
* streams are SOCKS5-style `CONNECT`s carried by sequenced data frames.

Full wire format: `docs/PROTOCOL.md`.

### Two findings that matter for the client design

1. **Only the upload direction is encrypted.** The server writes raw frames into
   TXT answers (`BuildVPNResponsePacket` never invokes the codec). This is a
   property of the existing server; a client cannot change it, and any claim of
   "full end-to-end encryption" for this protocol would be false.
2. **The selected resolver is only a forwarder.** The session lives in the
   server's session table, keyed by `(session id, cookie)`. Therefore a client
   may switch resolvers at any time — including mid-transfer — as long as the
   new resolver forwards UDP/53 to the same authoritative server. No server
   change and no authentication bypass are involved.

### What the protocol cannot do

* It cannot use several resolvers as simultaneous independent data paths in a
  way that increases throughput on the client side implemented here: each query
  is a single request/response, and the client pump serialises them. Upstream
  achieves "multipath" by duplicating packets across resolvers, not by striping.
  This client therefore treats one resolver as active and the rest as
  hot standbys — honest, and sufficient for failover.
* It cannot carry UDP traffic (no UDP ASSOCIATE).

---

## 4. Compatibility assessment for the existing AM Tunnel servers

**Cannot be answered yet, and no answer is invented.** Two sub-questions:

1. *Does the modified client speak AM Tunnel's protocol?* Unknown until the APK
   is analysed. The client is structured so this is a single adapter.
2. *Would the servers need changes?* For a protocol of this family — nothing
   server-side is touched by resolver management: the resolver pool lives
   entirely in the client, and the server only ever sees the queries that reach
   it through whichever resolver forwarded them.

Constraints that are respected in the implementation:

* no credential fabrication, no bypass of service-side access control, no
  traffic redirection to unrelated servers;
* the resolver manager never rewrites payloads; it only chooses *where to send
  the same query*.

---

## 5. Implemented DNS engine (MasterDNSVPN-style)

| Requirement | Implementation |
| --- | --- |
| Manual entry | `ResolverEndpoint.parse` accepts `a.b.c.d`, `host:port`, `[v6]:port`, `label=…` |
| Bulk import | `ResolverEndpoint.parseMany` splits on newline/comma/semicolon/space, skips comments, de-duplicates |
| Concurrent scanning | `ResolverScanner` — bounded pool (16 by default) + semaphore, per-probe timeout, cancellable |
| Reachability + response time | `ResolverProbe` (median RTT, jitter) |
| **Tunnel capability** | `TunnelCapabilityProbe` performs a real SESSION_INIT through the resolver; only a matching SESSION_ACCEPT marks it capable — a resolver that answers `A` queries is *not* assumed to work |
| Reliability scoring + ranking | `ResolverHealthMonitor.score()` = 0.42·reliability + 0.30·capability + 0.20·latency + 0.08·freshness − failure penalties; Bayesian smoothing on rates |
| Automatic selection | `HealthResolverSelector.ranked()` consumed by the transport |
| Continuous monitoring | runtime successes/failures feed the same monitor; degraded/backoff states are surfaced to the UI |
| Failure detection + failover | transport re-picks the best resolver after two consecutive timeouts; session unaffected |
| Recovery | after four consecutive failures across the pool, SESSION_INIT is re-run (`recoveries` counter) |
| Persistence | `FileResolverStore` (one line per resolver) + `SharedPreferences` for settings |
| Live results/diagnostics | log ring buffer, per-resolver status/RTT/success, packet counters, `sessionDebug()` |
| Adaptive scheduling | `ScanScheduler`: reachability every 15–120 s depending on pool health; tunnel scans every 30–300 s; parked resolvers are re-probed |
| Bounded resources | fixed thread pools, per-socket timeouts, 512-entry RX queues, windowed stream writes |

Design separation: the DNS engine talks to the transport only through
`ResolverSelector`; the transport knows nothing about scanning.

---

## 6. Delivered client

* `core` — protocol + engine (pure JVM, unit-tested).
* `app` — Android client: connect/disconnect, live status (resolver, RTT,
  packets, bytes, switches, recoveries), resolver list with tap-to-toggle and
  long-press-to-remove, bulk import dialog, ping scan / tunnel scan / stop scan,
  failover and adaptive-scan toggles, diagnostics log with copy.
* `app` also ships a foreground `VpnService` with `protect()` on every tunnel
  socket (loop protection) and an opt-in DNS-mode tun that resolves through the
  tunnel; full-device TCP routing would need a userland TCP stack (tun2socks)
  and is deliberately not shipped.
* The verified traffic path is the local SOCKS5 proxy.

---

## 7. Test results

See the CI run linked in the repository and `docs/STATUS.md` for the current
pass/fail matrix. Tests are not "green by construction": the integration job
compiles the reference server from source, starts it on a real UDP port, and
the client must complete a handshake, open a stream, move an HTTP response
through the tunnel, survive the death of its active resolver and keep the same
session across it.

---

## 8. Honest limitations

1. No device, no emulator, no ADB: the APK's runtime behaviour is unverified.
2. AM Tunnel itself is untouched (blocked, Section 2).
3. Upload-only encryption is a protocol property; the client documents it.
4. No MTU discovery and no compression: both are optional in the protocol and
   the client negotiates them off.
5. The integration suite depends on the upstream server compiling at a moving
   tag; the workflow pins nothing and would surface breakage as a test failure
   rather than a silent skip.
