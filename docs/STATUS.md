# Implemented / verified / blocked

Last updated by the CI run referenced at the bottom of this file.

## Legend

* **Verified** — proven by an automated test that actually moved bytes (CI log
  reference included).
* **Implemented** — code exists and compiles, but the specific behaviour has not
  been exercised end-to-end.
* **Blocked** — cannot be done from this environment; reason given.

## Feature matrix

| Area | State | Evidence / reason |
| --- | --- | --- |
| Base36 label codec | Verified | `Base36Test` (round trip, length tables, uppercase acceptance, rejection) |
| Frame build/parse + header check | Verified | `FrameTest` (per-type header lengths, corruption rejection) |
| Codecs: none / XOR / ChaCha20 / AES-128/192/256-GCM | Verified | `CodecTest` incl. RFC 8439 ChaCha20 vector |
| DNS envelope build + single/multi-chunk parse | Verified | `DnsEnvelopeTest`, QNAME budget test |
| SESSION_INIT/ACCEPT + verify code, encryption key exchange | Verified | `TunnelIntegrationTest.test1`, handshake against real Go server |
| SOCKS5-in-tunnel stream (SYN → CONNECTED → DATA → ACK → CLOSE) | Verified | `TunnelIntegrationTest.test2`: HTTP 200 through the tunnel |
| Real payload transfer (bytes through DNS tunnel) | Verified | `test2`: body received, byte counters > 0 |
| Resolver reachability/latency probing | Verified | `ResolverScanner` used by `test1`; unit tests for parsing |
| Resolver *tunnel-capability* probing | Verified | `test1`: DNS-only resolver is reported NOT capable |
| Ranking / scoring / parking of failing resolvers | Verified | `RankingTest` |
| Resolver persistence | Verified | `ResolverStoreTest` |
| Failover to another resolver without reconnect | Verified | `test3`: relay killed, traffic continues, `recoveries == 0` |
| Session recovery after session loss | Implemented | `MasterDnsTransport.recoverSession`, retriggered by 4 consecutive failures; not exercised by CI |
| Adaptive scan scheduling | Implemented | `ScanScheduler` (interval logic unit-adjacent, not time-tested) |
| Android UI (connect, resolvers, scan, diagnostics) | Implemented | compiles into the APK; no emulator in this environment |
| Foreground `VpnService` lifecycle, `protect()` | Implemented | compiles; no on-device run available |
| DNS-mode tun capture (DNS over tunnel) | Implemented | `IpPacket` + `DnsTunnelRelay`; not exercised on a device |
| Full-device TCP routing (tun2socks) | Blocked (by design) | would require a userland TCP/IP stack or a native tun2socks library; not shipped. SOCKS5 proxy mode is the verified traffic path |
| MTU discovery packets | Not implemented | fixed/configurable MTU used instead (server clamps to its policy) |
| Compression negotiation | Not implemented | client always negotiates OFF; server accepts |
| **AM Tunnel protocol** | **Blocked** | APK could not be downloaded in this environment (see below) |
| **Baseline test of the original AM Tunnel client** | **Blocked** | needs the APK plus a working AM Tunnel configuration |

## Why AM Tunnel is blocked

The supplied link `https://filebin.net/6kebb3eierc437j7/app.vpn.amtunnellite.zip`
is unreachable from the build environment: TCP connects, but the TLS handshake
is terminated at the network edge (`SSL_ERROR_SYSCALL`), identically with
`curl` and `wget`. Only `github.com`, `codeload.github.com`, `api.github.com`,
`registry.npmjs.org`, `pypi.org` and `files.pythonhosted.org` are permitted, and
GitHub **release assets** redirect to a host that is also blocked.

Consequences:

* The original client cannot be decompiled, so its transport cannot be
  identified (it is **not** assumed to be SlowDNS or MasterDnsVPN).
* Its resolver usage cannot be characterised (single vs. multiple, per-session
  vs. per-query).
* No baseline connection test can be run, because there is no client binary and
  no server configuration.
* Consequently, no claim is made anywhere in this repository that the modified
  client talks to AM Tunnel servers.

What is prepared for that work:

* `TunnelTransport` / `ResolverSelector` seams isolate the DNS engine from the
  transport, so an AM Tunnel adapter can be added as one class.
* `docs/REPORT.md` lists the exact questions the APK analysis must answer and
  the commands to run once the file is available.

## Environment limitations

* No Android device or emulator; no ADB. APK behaviour is therefore *implemented*
  but not device-verified.
* No JDK/Android SDK in the analysis sandbox: all compilation and execution
  happens in GitHub Actions.
