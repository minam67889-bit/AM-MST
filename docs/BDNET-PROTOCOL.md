# BD NET — the SlowDNS-family client

Second APK analysed with the same CI pipeline (`.github/workflows/analyze-apk.yml`,
target from `apk-target.env`, report committed to `analysis-bdnet/`).

## 1. Identity

| Fact | Value |
| --- | --- |
| Package | `dastan.prince.bdfreevpn` |
| versionCode / versionName | `106` / `PrinceBuild106` |
| minSdk / targetSdk | 24 / 36 |
| SHA-256 of the APK inside the zip | `b37a83b1e5044ebcce75554c0c413d20486d01824db97237fff1d8078cfaa811` |
| Size | 65,639,039 B |
| App namespace | `prince.dastan.vpn` — the **same "prince" author namespace** as AM Tunnel's `prince.udp.vpn` |
| Verdict | a **patched "Mod" build**: it ships `libs/arm64-v8a/libSignatureKiller.so` and `assets/SignatureKiller/origin.apk` |

## 2. Yes — it really does carry a SlowDNS-family DNS tunnel

| Library | What it is |
| --- | --- |
| **`libxdnstt.so`** | **dnstt** — TCP over DNS. The proofs are in the string table: `KCP` (15 hits), `Noise` (12), `X25519` (2), and the symbol `(*DqzdQ2zNwRuY).DeriveNoise.func1`. dnstt's stack is exactly Noise handshake + KCP stream + turbotunnel framing over TXT queries. Garbled symbol names show it was built with `garble`. |
| `libudpq.so`, `libudpqtwo.so` | Hysteria 2 again, identical to AM Tunnel (*"UDP-Q by Prince"*) |
| `libxray.so` | Xray proxy core |
| `libpdnsd.so` | pdnsd local DNS proxy |
| `libtun2socks.so` | gVisor netstack |
| `libfwpuncher.so` | "firewall puncher" (probes for open egress) |
| `libtunpsi.so`, `libgojni.so`, `libputils.so`, `libdns.so` | JNI helpers, DNS helpers |
| `libSignatureKiller.so` | strips the signature check — this is a cracked build |

Java side (`analysis-bdnet/app-sources/sources_prince/dastan/vpn/service/`):

* `SocksDNSService.java` — the SlowDNS mode. It builds a **command line and runs
  the repacked native binary** out of `nativeLibraryDir` (`Process`,
  `this.k = new File(nativeLibraryDir, …)`), picks a random server out of a
  `|`-separated list, resolves it, and pipes it into tun2socks.
* `XRayDNSService.java` — Xray mode.
* `PsiphonDNSService.java` — Psiphon mode.
* `IPHunterActivity`, `ImportTweakActivity` — "tweaks" (config files) are
  **imported by the user**, not baked in.

## 3. Where the tunnel configuration lives

There is **no** plaintext tunnel domain, server list or public key:

* the APK's own strings are hidden behind a runtime deobfuscator
  (`Deobfuscator$BDNETVPN$app.getString(long)` appears on nearly every line of
  the service code, so jadx cannot resolve a single literal);
* `assets/sorter.json` (414,920 B) is not JSON — it is a base64 blob;
* the server list and the DNS-tunnel domain arrive either from the vendor's
  backend or from a user-imported tweak file.

So — same conclusion as AM Tunnel, for the same reason: **the servers are not
reachable with information that is legitimate to extract from the APK**. What is
different here is that the *protocol* is an open one (dnstt), and dnstt servers
can be run by anyone.

## 4. Why this matters for our client

Our client already implements a DNS tunnel of the **MasterDnsVPN** family and
verifies it byte-for-byte against the real Go server. dnstt is a *different*
protocol in the same family:

| | MasterDnsVPN (ours, working) | dnstt / "SlowDNS" (BD NET) | AM Tunnel |
| --- | --- | --- | --- |
| Carriage | payload in QNAME labels, answer = raw TXT | turbotunnel frames in QNAME, TXT answers | none — QUIC/UDP |
| Stream layer | own ARQ (seq/frag/ack) | **KCP** | QUIC |
| Handshake | SESSION_INIT/ACCEPT + cookie + optional share-key verify | **Noise** (X25519, `DeriveNoise`) | TLS/Hysteria auth |
| Encoding | base36 labels | base32/hex labels | — |
| Server we can use | any MasterDnsVPN server (we build one in CI) | any dnstt server (open source) | vendor-only |

What a dnstt adapter would need in `core`:

1. base32 QNAME codec (a sibling of the existing `Base36Lower`),
2. Noise NK handshake (`flynn/noise` equivalent — X25519 + ChaCha20-Poly1305;
   the ChaCha20 and X25519 primitives already exist in `Crypto.kt`),
3. KCP reliable stream over the tunnel (retransmit/window logic — the ARQ in
   `MasterDnsTransport` is structurally similar but not wire-compatible),
4. turbotunnel framing (client session id + 2-byte length prefix).

That is a real, self-contained piece of work — and unlike AM Tunnel it is
**testable against a server we control** (dnstt is open source: build
`dnstt-server`, point it at a domain we own). It is *not* something that can be
honestly claimed in a single step, so it is listed as not-implemented rather
than faked.

## 5. Safety notes on this APK

* It is a **modified build** (`libSignatureKiller.so` + a pristine `origin.apk`
  inside `assets/`) — i.e. someone else's app repackaged. Do not trust it with
  credentials; it also bundles AdMob/Meta/Fyber ad SDKs.
* It ships a "firewall puncher" component; running it against production
  networks is not something this project will automate.

## 6. Reproduce

```bash
# point the pipeline at an APK, push, read the committed report
$EDITOR apk-target.env         # APK_URL=..., OUT_DIR=analysis-bdnet
git commit -am "analyse" && git push
```
