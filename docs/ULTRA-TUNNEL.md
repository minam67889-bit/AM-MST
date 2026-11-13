# Ultra Tunnel (`co.strongteam.ultra`) — what actually drives it

Same exercise as BD NET (`docs/BDNET-TUNNEL.md`), same output: a machine-readable
file with the credentials a client needs. Deliverable:
[`analysis-ultra/slowdns.json`](../analysis-ultra/slowdns.json).

Build analysed: **v1.0.8.8 / build 59**, arm64-v8a, minSdk 32, base APK 32,381,008 B
inside a 58,559,179 B XAPK.

## 1. The tunnel is stock dnstt

`libdns.so` (4,912,352 B) is an unmodified dnstt client: it embeds
`www.bamsoftware.com/git/dnstt.git/dns`, its usage line is
`[-doh URL|-dot ADDR|-udp ADDR] -pubkey-file PUBKEYFILE DOMAIN LOCALADDR` and it
has neither of the two extras BD NET's fork carries (`-report` licence gate,
`-utls` fingerprint). So there is no proprietary handshake to reproduce: the
whole credential set is **domain + 64-hex pubkey + a resolver that can reach the
domain's authoritative server**.

`DNSTunnelThread.run()` builds the command line verbatim:

```java
sb.append(" -udp " + dnsKey + ":53   -pubkey " + chaveKey + " " + serverNameKey + " 127.0.0.1:2222");
Runtime.getRuntime().exec(sb.toString());
```

| pref (`SettingsConstants`) | value |
| --- | --- |
| `dnsKey` | resolver, `ip:53` |
| `chaveKey` | the 64-hex dnstt public key |
| `serverNameKey` | the `SlowDNSHost` domain |

Engine mode constant: `bTUNNEL_TYPE_SLOWDNS = 6`. Local forwarder: `127.0.0.1:2222`
(BD NET uses 7000). `libdns` has `-doh`/`-dot` too, but the app only ever calls
`-udp`.

## 2. Where the servers come from

There is no config URL in the dex and the panel (`panel.vpnprous.com`,
`10xbdnet.xyz`) is only a UI default and unreachable. The catalogue ships
**encrypted inside `assets/configfile.json`**:

`ServerStatusVIew.g()` → pref `KidConfigMM1` → else the asset → `Hometab.a()` →
`Libv2ray.do_(str)` (JNI, `libgojni.so`) → Gson → `ConfigData{Servers, Networks}`.

## 3. The encryption (this was the blocker)

`libgojni.so` is `AndroidLibXrayLite`, the same codec family as MM Tunnel
(`co.strongteam.marvsudp`). `EO`/`DO` wrap:

```
base64( salt[16] || nonce[12] || AES-256-GCM(ciphertext) || tag[16] )
key = Argon2id(passphrase, salt, t=3, m=8192 KiB, p=1, len=32, version 19)
AAD = salt
```

Two passphrases, both compiled into the .so:

| use | passphrase | framing |
| --- | --- | --- |
| bundled asset + every protected inner field | `NurChickenPowder` | plain base64 |
| remote updater (`encrypt`/`decrypt`) | `/4ssU0OjjtKH8AheiAxnc3DwSGDzsy+8` | one random ASCII letter inserted at index 3 *after* base64 (length % 4 == 1) |

The outer JSON is only half of it: `ServerIPHost`, `SlowDNSHost`, `SlowDNSKey`,
`OVPNUser/Pass`, `Payload`, `BugDNS`, `SNI`, … are each separately wrapped in the
same envelope with the same passphrase. Decoded in two passes, the catalogue
opens completely — 56 servers / 859 networks (v3.95).

Reproduce with [`analysis-ultra/decrypt_config.py`](../analysis-ultra/decrypt_config.py):

```bash
python3 analysis-ultra/decrypt_config.py analysis-ultra/assets/configfile.json out.json
```

## 4. The live updater still works

`https://strongteam.co/api/ultrasystem/ultrav3.txt`, `User-Agent: Ultra Tunnel`,
HTTP 200, 1,385,469 B, `last-modified` the day before this run. Decrypted with
the *remote* passphrase it yields **v5.28: 38 servers / 918 networks**, i.e. the
shipped asset is stale and the app refreshes it at runtime. Both catalogues are
merged in the deliverable.

## 5. What the catalogue contains

| tunnel type | networks (v5.28) |
| --- | ---: |
| Http/Ws Proxy | 302 |
| SSL Direct | 271 |
| V2ray | 156 |
| **Slow DNS** | **84** |
| SSL + Payload + WS | 72 |
| UDP Hysteria | 27 |
| Direct TCP | 4 |
| H2 | 2 |

Slow DNS entries are the interesting ones: each one names a **resolver**
(`BugDNS`) instead of a proxy. 56 distinct resolvers appear; 4 are public
(8.8.8.8, 8.8.4.4, 9.9.9.9, 1.0.0.1) and the rest are carrier/eSIM resolvers
(MTN, Tigo, Claro, Digicel, Turkcell, Mobily…) that answer DNS for their own
subscribers — the classic "free data with a DNS tunnel" pattern. That is the
multi-resolver pool to auto-balance over.

Servers carrying SlowDNS credentials (8 distinct tunnels across both catalogues):

| domain | pubkey (hex) | where |
| --- | --- | --- |
| `nssshtt.mdmonzo.com` | `5d30d1…f97032` | bundled + live |
| `slwdns.codefyinc.com` | `1f2596…012809` | bundled |
| `ns.rovox.wampipti.net` | `097256…243a40d` | bundled |
| `newca.dozapp.xyz` | `b4e0dc…fda9e79` | bundled |
| `dnsde1.dozapp.xyz` | `569486…6761809` | bundled |
| `nssshvip1.vpnprous.com` | `5d30d1…f97032` | bundled |
| `nsVIPSSH087.vpnprous.com` | `5d30d1…f97032` | bundled |
| `ns.up2.fcafessh.net` | `25978b…b7c026` | **live only (v5.28)** |

`5d30d1…f97032` is shared by four servers, so rotation happens at the DNS level,
not by changing keys.

## 6. Launch recipe

```bash
libdns.so -udp 8.8.8.8:53 -pubkey 1f259692993f67c5f5cba26da464ed16f57a394c20fb637d3d2a346781012809 \
          slwdns.codefyinc.com 127.0.0.1:2222
```

`analysis-ultra/slowdns.json → launch_recipes` has this pre-built for every
tunnel × (8.8.8.8, 8.8.4.4, 9.9.9.9, 1.0.0.1).

## 7. What the local end really is (and the mistake worth recording)

`dnstt-client`'s local listener is **not** a SOCKS proxy: it accepts a plain TCP
socket and opens one smux stream per connection, and `dnstt-server` forwards
every stream to one fixed upstream. Ultra's servers forward to their own
**sshd**, which is why every SlowDNS server in the catalogue also lists
`SSH_Port` 22 and an SSH account:

| server | account |
| --- | --- |
| `slwdns.codefyinc.com` | `islam` / `islam` |
| `ns.rovox.wampipti.net` | `tcx` / `tcx` |
| `newca.dozapp.xyz`, `dnsde1.dozapp.xyz` | `edozprodoings` / `doingsedozpro` |
| `ns.up2.fcafessh.net` (live v5.28) | `vertexsnipher` / `vertexsnipher` |
| `nssshvip1.*`, `nsVIPSSH087.*`, `nssshtt.mdmonzo.com` | default account (`isdefUser`) |

So "SlowDNS" in Ultra = SSH over dnstt, exactly like the classic SlowDNS apps:
`libdns` listens on 127.0.0.1:2222, the SSH client connects to it, the far end's
sshd answers. Probing that listener with a SOCKS5 handshake therefore hangs no
matter how healthy the server is.

## 8. Verification status

**Verified**

* Catalogue decryption: 925,416 B → `v3.95` 56 servers / 859 networks; live
  updater 1,385,469 B → `v5.28` 38 servers / 918 networks. Every protected field
  opened, including all `SlowDNSHost` / `SlowDNSKey`.
* Live updater reachability: HTTP 200, `last-modified` one day before the run.
* Engine line: read straight out of `DNSTunnelThread.run()`, matches the flag set
  of `libdns.so`.
* **Toolchain control** (`analysis-ultra/report/selftest.txt`): a dnstt client
  built from source in CI, pointed at a local `dnstt-server`, fetched
  `HTTP/1.0 200 OK` through the tunnel in 2.0 s. So the probe method can move
  bytes; a timeout means the server, not the harness.

**Not verified — and why**

* **Control, for comparison:** BD NET's zone answers a resolver-relayed query
  (`sd-de1.liftmeon.org` TXT via 8.8.8.8 → rcode 0, answer present) and BD's own
  client completes a far-end round trip through 8.8.8.8 in 0.4 s
  (`analysis-bdnet/report/transport-compare.txt`). Same kind of query against
  every Ultra zone returns NXDOMAIN or SERVFAIL
  (`analysis-ultra/report/sandbox-dns-test.txt`). The difference is the server,
  not the test.
* **All 8 Ultra endpoints are silent from the public internet.** With the
  working client: session logs `begin session`, no stream is ever opened, no
  bytes arrive. Raw DNS agrees — the authoritative NS addresses answer nothing
  (`dns-endpoints.txt`) and public resolvers return `SERVFAIL` with EDE 22
  "No Reachable Authority" (`dns-probe.txt`).
* Their delegation points at hosts that either have no A record
  (`slw.codefyinc.com`, `vipssh087.vpnprous.com`), sit behind Cloudflare with no
  records (`sierra/reese.ns.cloudflare.com`, `vita/kirk.ns.cloudflare.com`), or
  drop every packet from a non-carrier source address
  (`209.94.59.213`, `144.217.81.86`, `154.53.57.37`, `84.46.252.158`,
  `51.83.129.208`).
* **49 of the 56 resolvers the Slow DNS networks ride on are carrier/eSIM
  resolvers** (MTN, Tigo, Claro, Digicel, Turkcell, Mobily, Zain…). None answers
  from a cloud runner, and no packet from a cloud runner reaches the tunnel
  hosts. The data-free path can only be tested from a device inside one of those
  networks — which is also why the app badges those servers "Online 🟢": it
  measured them from a phone on the carrier.

That is the honest bottom line: **the Ultra Tunnel SlowDNS credential set is
fully recovered and reproducible; the servers themselves are not reachable from
anything outside their carrier networks.** BD NET remains the working
SlowDNS path in this project (`analysis-bdnet/configs/slowdns.json`,
`docs/SLOWDNS.md`), because BD's server answers the public internet directly at
`13.140.185.158:53`.
