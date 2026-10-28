# Implemented / verified / blocked

Prebuilt APK: <https://github.com/minam67889-bit/AM-MST/releases/latest>
(`amtunnel-mst-*.apk`, debug-signed).

Last verified end-to-end in CI run **40713951951** (`Live DNS-tunnel integration: success`,
`Unit tests + APK: success`).

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
| SESSION_INIT/ACCEPT + verify code, encryption key exchange | Verified | `TunnelIntegrationTest.test1` against the real Go server (`handshake ok ... id=2 cookie=41 uploadMtu=110 downloadMtu=900`) |
| SOCKS5-in-tunnel stream (SYN → CONNECTED → DATA → ACK → CLOSE) | Verified | `test2`: `SOCKS5_SYN_ACK` for a real target, then HTTP data both ways |
| Real payload transfer (bytes through DNS tunnel) | Verified | `test2`: live HTTP response received through the tunnel — `tx=12 rx=11 up=61B down=851B rtt=3ms` |
| Resolver reachability/latency probing | Verified | `ResolverScanner` used by `test1`; unit tests for parsing |
| Resolver *tunnel-capability* probing | Verified | `test1`: DNS-only resolver is reported NOT capable |
| Ranking / scoring / parking of failing resolvers | Verified | `RankingTest` |
| Resolver persistence | Verified | `ResolverStoreTest` |
| Failover to another resolver without reconnect | Verified | `test3`: relay A killed mid-session → `resolver=…:35235 switches=1 recoveries=0 timeouts=1`, HTTP still flowed |
| Session recovery after session loss | Implemented | `MasterDnsTransport.recoverSession`, retriggered by 4 consecutive failures; not exercised by CI |
| Adaptive scan scheduling | Implemented | `ScanScheduler` (interval logic unit-adjacent, not time-tested) |
| Android UI (connect, resolvers, scan, diagnostics) | Implemented | compiles into the shipped debug APK; UI behaviour itself is not device-tested |
| Debug APK produced by CI | Verified (structure) | 962,646 B, `sha256 4e9c0f2858c11e6788fe81c664611ab457db55e5c672fbb4ccb7753a6f2b24cd`; `aapt2` checks: debug applicationId, INTERNET, FOREGROUND_SERVICE, `TunnelVpnService` + `android.net.VpnService` filter, launcher activity, minSdk 26 / targetSdk 34; transport classes found in `classes7.dex` |
| APK installs and runs on a device | **Not verified** | no Android device, emulator or ADB in this environment |
| Foreground `VpnService` lifecycle, `protect()` | Implemented | compiles; no on-device run available |
| DNS-mode tun capture (DNS over tunnel) | Implemented | `IpPacket` + `DnsTunnelRelay`; not exercised on a device |
| Full-device TCP routing (tun2socks) | Blocked (by design) | would require a userland TCP/IP stack or a native tun2socks library; not shipped. SOCKS5 proxy mode is the verified traffic path |
| MTU discovery packets | Not implemented | fixed/configurable MTU used instead (server clamps to its policy) |
| Compression negotiation | Not implemented | client always negotiates OFF; server accepts |
| **AM Tunnel protocol** | **Analysed** | real APK decompiled in CI: `app.vpn.amtunnellite` v63, Hysteria 2 ("UDP-Q by Prince") + WireGuard + Xray + pdnsd + tun2socks, LIAPP-protected. See `docs/AM-TUNNEL-PROTOCOL.md` |
| **Baseline test of the original AM Tunnel client** | **Blocked** | the APK runs only against vendor backend credentials held in a LIAPP-encrypted payload; no device/emulator either |
| **BD NET string table** | **Extracted in CI** | `tools/lsparanoid_decode.py` + `analysis-bdnet/obfuscation/decrypted.txt`; self-test round-trips through the obfuscator's own encoder, so the port is proven rather than assumed |
| **BD NET APK analysis** | **Analysed** | `dastan.prince.bdfreevpn` v106 (patched "Mod" build). Carries **dnstt** (`libxdnstt.so`: KCP + Noise + `DeriveNoise`) = the SlowDNS family, plus Hysteria 2, Xray, pdnsd, tun2socks. See `docs/BDNET-PROTOCOL.md` |
| **dnstt / SlowDNS transport** | **In progress** | protocol fixed from real source (Noise_NK_25519_ChaChaPoly_BLAKE2s + KCP + smux + turbotunnel, 8-byte client id, base32 QNAME). Spec: `docs/DNSTT-PLAN.md`. Verifiable against open-source `dnstt-server` in CI. |
| **Using BD NET's own servers** | **Config source found — cipher not cracked** | `docs/BDNET-CONFIGS.md`. The app pulls per-mode bundles from `raw.githubusercontent.com/panigbatanc/BDNET2023/main/<JSON…>` (`JSONDNSTT`, `JSONFASTDNS`, `JSONXRAY`, …) and ships `assets/server.psi`. Bundles are base64 + stream-ciphered; the in-app AES helper is dead code with no callers. An earlier "nothing to extract" verdict was based on a partial decompile and is withdrawn |
| **MasterDnsVPN balancing engine (9 strategies)** | **Verified** | ported from `balancer.go` (commit `5f83ee9`); 19 unit tests pin the exact formulas; live `test4` with 10 resolvers, 5 killed mid-session kept `state=READY` and traffic flowing |
| Packet duplication (`PACKET_DUPLICATION_COUNT`, default 2) | Verified | `test2`: `duplicatesSent > 0`, HTTP through the tunnel |
| Auto-disable (`AUTO_DISABLE_TIMEOUT_SERVERS`, 30 s) | Verified | window rule + 3-consecutive-timeout rule; unit tests `auto disable parks…`, `three timeouts in a row…` |
| Recheck of parked resolvers (`RECHECK_INACTIVE_SERVERS_ENABLED`) | Verified | unit test `a parked resolver returns after a successful recheck`; live recheck probes in the transport pump |
| Stream-sticky failover (threshold 2, cooldown 2.5 s) | Verified | unit tests `a stream keeps its resolver…`, `failover respects the cooldown` |

## How the AM Tunnel APK was finally obtained and analysed

The sandbox itself only reaches six hosts, so the download had to happen in CI
(`.github/workflows/analyze-apk.yml`):

1. the supplied `filebin.net/6kebb3eierc437j7/app.vpn.amtunnellite.zip` is
   **dead** — it answers `200` with a 5,412-byte HTML page (the bin expired);
2. the apkpure mirror `https://d.apkpure.net/b/APK/app.vpn.amtunnellite?version=latest`
   served the real 63,738,028-byte bundle;
3. the bundle is an App Bundle with per-ABI splits, so the workflow picks the
   split that actually contains `classes*.dex` as the base APK, decompiles it
   with `apktool` + `jadx`, mines strings out of every native library and
   commits the report to `analysis/`.

Result: the protocol is identified (Hysteria 2 / QUIC + WireGuard + Xray, with
pdnsd for local DNS) and the server credentials are proven to be inside a
LIAPP-encrypted payload. Full write-up: `docs/AM-TUNNEL-PROTOCOL.md`.

**No claim is made that this client talks to AM Tunnel servers**, because doing
so would require their backend credentials.

## How the live tests reach a target

The upstream Go server's `validateSOCKSTargetHost` refuses **loopback, private,
link-local and other non-global addresses** — a deliberate SSRF guard. That
behaviour was left untouched. The integration tests therefore point the tunnel
at a globally routable address:

1. first choice: this runner's own global IPv4 (the kernel routes it back to
   the local HTTP probe server on `0.0.0.0`);
2. fallback: a public web server (`example.com:80`) when the runner has no
   global address.

Run 40713951951 used path 2 (`tunnel target: example.com:80 (local=false)`), so
the bytes proven to cross the tunnel were a real HTTP exchange with a third
party, not a loopback shortcut.

## Environment limitations

* No Android device or emulator; no ADB. APK behaviour is therefore *implemented*
  but not device-verified.
* No JDK/Android SDK in the analysis sandbox: all compilation and execution
  happens in GitHub Actions.
