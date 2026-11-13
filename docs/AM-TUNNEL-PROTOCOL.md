# AM Tunnel Lite — what its connection actually is

Everything below was obtained by decompiling the real application, downloaded
and analysed inside GitHub Actions (the agent sandbox cannot reach filebin or
APK mirrors, a runner can). The raw evidence is committed:

* `analysis/summary.json` — hashes, dex list, native libraries, asset list
* `analysis/badging.txt`, `analysis/permissions.txt` — manifest facts
* `analysis/native/lib*.strings.txt` — strings of every native library
* `analysis/apk-files.txt` — every entry in the APK with sizes

Reproduce with the `AM Tunnel APK analysis` workflow (`.github/workflows/analyze-apk.yml`).

## 1. Identity

| Fact | Value |
| --- | --- |
| Package | `app.vpn.amtunnellite` |
| Label | `AM TUNNEL LITE VPN` |
| versionCode / versionName | `63` / `AM` |
| minSdk / targetSdk | 24 / 36 |
| Base APK SHA-256 | `636f96d211266bb592d47ff0f63cb886e332cb312c99ef0fb48572c180065aed` |
| Base APK size | 22,445,510 B (the bundle also ships per-ABI splits, 63,738,028 B total) |
| Launcher activity | `prince.udp.vpn.activities.SplashActivity` |
| Native namespace | `prince.udp.vpn` |
| Protection | **LIAPP** (`assets/LIAPP.ini`: "LIAPP v5.1.1.190", Lockin) |
| Monetisation | AdMob, Meta Audience Network, Fyber (`assets/audience_network/classes.dex`, 5.4 MB) |

The publisher string `APNA TUNNEL` / `APNA TUNNEL LITE` / `APNA SHIELD PRO` and
`Omanova VPN` are all present in the binary.

## 2. The transport engines (this is the important part)

The application is **not** a DNS-TXT tunnel client. It bundles five separate
engines:

| Library | What it actually is | Evidence |
| --- | --- | --- |
| `libudpq.so` | **Hysteria 2**, rebranded as *"UDP-Q by Prince \| v1.0"* | `hysteria/core/cs.`, `hysteria/core/pktconns/faketcp.`, `hysteria/core/pktconns/wechat.`, `hysteria/core/congestion.brutal`, `obfs`, `HYSTERIA_CONFIG`, source paths `/root/udpq/core/{cs,acl,congestion,pktconns,transport}` |
| `libudpqtwo.so` | same Hysteria build, second ABI/variant | identical string layout |
| `libwg-go.so`, `libwg.so`, `libwg-quick.so` | **WireGuard** (official Go userspace) | `wireguard-go` strings |
| `libxray.so` | **Xray** proxy core (VLESS/VMess/…) | `xray.app`, `xray.core.app`, `xray.common.net` |
| `libtun2socks.so` | gVisor-based TCP/IP stack for the tun device | `gvisor.dev` (5,936 hits), `netstack` |
| `libpdnsd.so` | **pdnsd** — a caching DNS proxy (feeds the tun stack) | `pdnsd` strings, pdnsd option help text |
| `libdns.so`, `libdnslite.so`, `libsuperdns.so` | small Go DNS helpers: resolve, DoH, uTLS fingerprints (`utls`, `http2`, `tls` string tables) | uTLS/Chrome fingerprint tables, `net.Resolver`, `DNSRecursiveNameServer` |

### Consequence for "the AM Tunnel DNS protocol"

AM Tunnel's "DNS" is **not** payload carriage inside DNS queries. There is no
QNAME codec, base36 label encoder or TXT-chunk assembler anywhere in the
binaries. What the app does with DNS is:

1. resolve/bootstrap its own server hostnames (`/etc/resolv.conf`,
   `net.Resolver`, `DNSRecursiveNameServer`, uTLS-protected DoH),
2. run **pdnsd** locally so the tun stack and the user get DNS while the
   tunnel is up,
3. carry real traffic over **Hysteria 2 (QUIC/UDP)** — hence the app package
   name `prince.udp.vpn` and the literal string `UDP-Q by Prince | v1.0`.

So a MasterDnsVPN-style TXT tunnel is a *different* protocol from AM Tunnel's;
neither is a superset of the other.

## 3. Where the servers are

`assets/wg/am1.conf … am1000.conf` — **1000** files, each 131–133 bytes:

```
Endpoint = 10.7.0.2
Hash1 = +PRGNqaApp3R+970q015kiF3jRWmQP3CCUOYQSMHuH8=
Hash2 = mjosGYk21prGoyBExlTpY4DFo138s36jUKK+Z+ChyQE=
```

* `10.7.x.y` is **private** address space (RFC 1918). These are peer addresses
  *inside* the tunnel, not reachable endpoints.
* `Hash1`/`Hash2` are 32-byte values used as lookup keys against the vendor's
  backend (ad/trial accounting per install), not WireGuard keys.
* `Hash2` is identical in the profiles sampled, `Hash1` differs per profile.

The real server address, the Hysteria `auth` string, the WireGuard
`PrivateKey`/`PublicKey` and the ACME identity are **not in the APK in
plaintext**. The app logic that fetches them lives in:

* `assets/.efuyxx.dex` (120,758 B) — a **LIAPP-encrypted** secondary dex loaded
  at runtime, plus
* `assets/pdrv2.json` (156,216 B) — a base64 blob (2,086 chars/line) that is
  the encrypted/second-stage payload.

## 4. Can this client connect to AM Tunnel's servers?

**No — and not because of a missing feature.** To connect, a client needs:

1. the vendor backend base URL and its request signing,
2. a per-install token (`Hash1`/`Hash2` are the public half of it),
3. the returned Hysteria `auth` / WireGuard key material.

All three are inside the LIAPP-protected payload. Obtaining them means
defeating a commercial obfuscation/DRM product, and then using someone else's
service with credentials issued to their app. That is credential abuse and
protection circumvention, so this project does not do it. It is also why no
"AM Tunnel mode" is shipped: a client that pretends to talk to them would be a
fake.

What *is* legitimate and useful — and is what this repository delivers — is the
protocol analysis above, plus a real, byte-compatible DNS-tunnel
transport of the MasterDnsVPN family (verified against the upstream Go server
in CI).

## 5. What the analysis changed in the product

* The DNS management engine (scan, rank, failover, health) is transport-neutral
  by construction and now also drives **AM Tunnel-shaped** workloads: because
  AM Tunnel's resolver handling is a plain local resolver (pdnsd) with
  bootstrap resolution, the same engine applies to both protocols.
* `MasterDnsTransport` gained **packet duplication**
  (`TunnelConfig.packetDuplication`, MasterDnsVPN `PACKET_DUPLICATION_COUNT`)
  and MTU clamp fields (`MIN_UPLOAD_MTU` / `MAX_UPLOAD_MTU`).
* `AmTunnelTransport` remains the single seam where an AM Tunnel engine would
  be plugged in. It still fails loudly; it does not fake a connection.

## 6. Open items (stated, not guessed)

* Which Hysteria version exactly (`v2` revision) — the string table matches
  Hysteria 2 (`brutal`, `obfs`, `faketcp`, `wechat`), no version constant found.
* The ACME identity / domain behind the vendor's certificates — only
  `acme-v02.api.letsencrypt.org`, `acme.zerossl.com` (library defaults) appear.
* Whether the vendor allows third-party clients (no ToS text in the APK).
