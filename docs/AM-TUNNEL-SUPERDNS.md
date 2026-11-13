# AM TUNNEL LITE VPN — where the SuperDNS servers actually live

The MOD build (`app.vpn.amtunnellite`, "AM TUNNEL LITE VPN [MOD Universal]") does
not hardcode server names in its dex. Every string in the dex is LSParanoid
encrypted **and** the server catalogue itself is an encrypted asset. Both layers
are now open, and the catalogue is in
[`analysis-amtunnel/superdns.json`](../analysis-amtunnel/superdns.json).

## 1. The two layers

| layer | what it looks like | how it was opened |
| --- | --- | --- |
| dex strings | `Deobfuscator$AMTUNNELLITE$app.getString(750656514172678644L)` | chunk table taken from apktool smali (`<clinit>`), then `tools/lsparanoid_decode.py` — 492/529 ids decode |
| server catalogue | `assets/janny.json`, 121 952 bytes of base64 | XXTEA (`defpackage.AbstractC3622yh.b`) with the decoded key `...|...` — `tools/xxtea_janny.py` |

Both layers matter: the dex only says *how* a tunnel is started, the asset says
*where*. `janny.json` decrypts to
`{"Free_servers": […], "Payloads": […], "Username": …, "Password": …, "Version": "59.0"}`.

## 2. What "SuperDNS" is in this app

`SuperService` (string `SuperDNS`, prefs `SUPER_DNS`, `SUPER_CUSTOM_DNS`,
`SUPER_DNS_FREQUENCY`, category `ocsslow` in the catalogue) execs
`libsuperdns.so`:

```
libsuperdns.so -udp <resolver>:53 -utls <Chrome|Firefox> -frequency <SUPER_DNS_FREQUENCY> \
               -report "AM TUNNEL LITE VPN" -pubkey prince sl<SSH_HOST> 127.0.0.1:7000
```

* `-udp <host>:53`, `-doh https://<host>/dns-query`, `-dot <host>:853` — chosen by the
  `udp://` / `doh://` / `dot://` prefix of the selected *transport* entry.
* `-pubkey prince` — same identifier the BD NET client uses.
* `<domain>` is literally `"sl" + SSH_HOST`, where `SSH_HOST` is the selected
  server host (`SuperService.run`).
* `127.0.0.1:7000` is the local listener.

The binary is not dnstt: 16.6 MB of Go, aarch64, interpreter `/system/bin/linker64`,
linking `crypto/tls`, `http2`, QUIC and uTLS tables — a TLS/PSK style tunnel
(`psK`, `curveID`, `tlsState`, `socks5h`). It cannot be executed anywhere but
Android, which is why no handshake was driven off-device.

## 3. The servers

| category | engine | groups | unique hosts | A records (8.8.8.8) |
| --- | --- | --- | --- | --- |
| `ocsslow` | **SuperDNS** (`libsuperdns.so`) | 6 | **50** | **50/50** |
| `ocsdnstt` | SocksDNS / dnstt | 15 | 150 | 150/150 |
| `ocspdoq` | PDoQ | 14 | 270 | 0/270 (dead pool) |
| `ocsudp` | UDP (`libudpq.so`) | 100 | 800 | 796/800 |
| `ocsnormal` | HTTP/SOCKS (Xray 24.11.30) | 4 | 20 | 10/20 |

SuperDNS hosts are `sa1..sa50.supaghost.cc`, all resolving into `169.58.x.x`
(`sa1` → 169.58.203.175). dnstt hosts are `{gg,hh}1..100.apnacp.xyz`.

Transport entries the client is offered (46 for SuperDNS) are plain resolvers —
`udp://8.8.8.8`, `udp://1.1.1.1`, `doh://…`, `dot://…`, `udp://autodns1`, plus
per-carrier entries (Cuba, Egypt, Kenya, Morocco, Nigeria, Sudan, Yemen, …).

## 4. Credentials

`Username` and `Password` in the catalogue are XXTEA blobs too; both decrypt to
`tanginaka`.

## 5. Verified vs not

Verified: catalogue decrypted from the APK; 50/50 SuperDNS hosts resolve; the
SuperDNS endpoint IPs answer DNS on UDP/53 (NXDOMAIN for everything asked,
including a random tunnel label), TCP/53 refused; `library`/argv facts read from
decrypted code.

Not verified: any tunnel handshake. `sl<host>` has no public A/NS record, and the
whole `supaghost.cc` zone has no delegation, so the effective wire name cannot be
confirmed from outside; no page was fetched through this tunnel.

## 6. Reproducing

```bash
python3 tools/xxtea_janny.py analysis-amtunnel/report/janny.b64 '...|...' out.json
python3 tools/catalogue_census.py analysis-amtunnel/report/janny-decoded.json census.txt 8.8.8.8 12
python3 tools/superdns_probe.py sa1.supaghost.cc --resolver 8.8.8.8
python3 analysis-amtunnel/build_superdns_json.py
```

CI: `.github/workflows/amtunnel-superdns.yml` re-downloads the APK from filebin,
decrypts both layers, runs the census and the endpoint probes, and commits the
report into `analysis-amtunnel/report/`.
