# AM Tunnel MST — DNS tunnel client with a MasterDNSVPN-style resolver engine

A modified DNS-tunnel Android client whose DNS management layer is modelled on
MasterDnsVPN: manual entry and bulk import, concurrent scanning, reachability
**and** tunnel-capability testing, reliability scoring, automatic selection,
continuous health monitoring, failover, recovery, persistence and live
diagnostics.

The transport is a byte-compatible implementation of the MasterDnsVPN DNS
tunnel protocol (`docs/PROTOCOL.md`), rebuilt in Kotlin from the upstream Go
source and verified against the real Go server in CI. The DNS engine is
independent of the transport: it is plugged in through `ResolverSelector` /
`TunnelTransport`, so a different transport (for instance the original AM
Tunnel engine, once its protocol is confirmed from the APK) can be dropped in
without touching the resolver manager.

> **Read `docs/STATUS.md`, `docs/AM-TUNNEL-PROTOCOL.md` and
> `docs/BDNET-PROTOCOL.md` first.** Two real APKs have been decompiled in CI:
> AM Tunnel (`app.vpn.amtunnellite`, Hysteria 2 + WireGuard + Xray) and BD NET
> (`dastan.prince.bdfreevpn`, dnstt/SlowDNS + Hysteria 2 + Xray). The AM Tunnel
> APK has been decompiled and its real protocol identified: it is **Hysteria 2
> (QUIC/UDP) + WireGuard + Xray**, with pdnsd for local DNS — not a DNS-TXT
> tunnel. Its server credentials live in a LIAPP-encrypted payload, so this
> client does not pretend to reach their servers.

---

## Modules

| Module | Contents |
| --- | --- |
| `core` | Pure Kotlin/JVM. Protocol codec, DNS envelope, session/stream transport, resolver store, probes, scanner, ranking, health monitor, SOCKS5 server |
| `app` | Android application: programmatic UI, foreground `VpnService`, DNS-mode capture, settings |
| `integration` | JUnit suite that drives the client against a **real** tunnel server |

## Build

```bash
# JDK 17 + Android SDK 34 required; Gradle 8.9 (no wrapper is committed)
gradle :core:test          # unit tests
gradle :app:assembleDebug  # debug APK -> app/build/outputs/apk/debug/
```

CI does this automatically on every push (`.github/workflows/android.yml`). It
runs the unit tests, compiles every module, runs the live tunnel integration
suite against a freshly built MasterDnsVPN server inside the job, uploads the
APK as a build artifact **and** publishes it as a GitHub Release.

### Download the APK

Grab the newest `amtunnel-mst-*.apk` from the
[Releases page](https://github.com/minam67889-bit/AM-MST/releases/latest)
(latest verified build: `amtunnel-mst-71f365a.apk`, 962,646 bytes). It is a
debug-signed build (install with `adb install -r <file>.apk`); a release-signed
APK is built automatically when the signing secrets are configured.

## Run

1. Install the APK.
2. Enter the **tunnel domain**, the **encryption method** and the **shared key**
   published by the server operator.
3. Add or bulk-import DNS resolvers, then run a **Tunnel scan**. Only resolvers
   that complete a real SESSION_INIT are marked tunnel-capable.
4. Press **Connect**. The local SOCKS5 proxy (default `127.0.0.1:1080`) carries
   app TCP traffic through the tunnel.
5. Watch failover, latency and packet counters on the dashboard; the
   diagnostics pane keeps a rolling log.

## Testing

* Unit tests: codec/frame/DNS envelope vectors, ranking and persistence rules.
* Live integration (`:integration:test`, gated by `AMTUNNEL_IT=1`): builds the
  reference Go server, starts it, and proves
  * a real HTTP request/response travelling through the DNS tunnel,
  * that a resolver answering normal DNS is correctly reported as *not*
    tunnel-capable,
  * that killing the active resolver triggers failover without a new session.

## Repository layout

```
core/    protocol + DNS engine (no Android dependencies, unit-tested on the JVM)
app/     Android client (UI, VpnService, settings, persistence wiring)
integration/ live end-to-end tests against the reference server
docs/    PROTOCOL.md, REPORT.md, STATUS.md
```

## Licensing / attribution

The protocol implemented here comes from
[MasterDnsVPN](https://github.com/masterking32/MasterDnsVPN) by
Amin Mahmoudi (MIT). The wire format, packet-type table, codec and session
semantics are reproduced from that source. See `THIRD_PARTY_NOTICES.md`.
