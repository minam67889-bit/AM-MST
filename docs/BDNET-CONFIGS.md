# BD NET — where the servers actually come from

Target: `dastan.prince.bdfreevpn`, versionCode 106, `PrinceBuild106`
(`BDNET.VPN v106 Mod.zip`).

> **Both ciphers are now solved.** BD NET ships its whole server catalogue
> inside **`assets/sorter.json`**, an XXTEA-encrypted JSON bundle, and every
> host inside it is separately `hex(xor(…))`-obfuscated. That is why the app
> connects with no tweak, no account and no manual entry: nothing is fetched at
> runtime, the servers are already in the APK. Everything below is reproduced
> by `tools/bdnet_sorter.py` and `tools/bdnet_decrypt.py`.

## 1. String deobfuscation (LSParanoid)

`org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app` holds a 41 966-character
ciphertext table (6 chunks) and `getString(long)` derives offset and XOR stream
from the id. `tools/lsparanoid_decode.py` is a literal port of `RandomHelper` +
`DeobfuscatorHelper` + the `StringRegistryImpl` encoder, with `--selftest`.

```
SELFTEST PASS (7/7 strings, 2 chunk(s), multi-chunk=yes)
chunks=6 chunk_attrs=41966 ids=1992 decoded=1992 errors=0
```

Output: `analysis-bdnet/obfuscation/decrypted.txt` (1 841 non-empty strings).

## 2. The config bundles

Two kinds of bundle exist, and they are **not** the same format:

| payload | wrapper | cipher |
| --- | --- | --- |
| `assets/sorter.json` | base64 → 311 188 bytes | **XXTEA**, key `...\|...` |
| `assets/server.psi` | 103 253 ASCII hex chars | **hex + 12-byte XOR** (`pDecrypt`) |
| `JSONDEC2025`, `JSONDNSTT`, `JSONFASTDNS`, … (GitHub) | base64 | **XXTEA**, same key |

### 2.1 The XXTEA layer (`AbstractC4569ym`)

```java
String c(String s, String key) {
    return new String(b(W80.m(s), key.getBytes("UTF-8")), "UTF-8");   // b() = XXTEA decrypt
}
```

* `W80.m` is base64 decode.
* `b()` is textbook XXTEA (decrypt loop, `sum` counting down) with a
  **non-standard delta**: `-1638454863` = `0x9E5729B1`, not `0x9E3779B9`.
* The key is `AbstractC4569ym.a`, id `-164539529000843` = `...|...` — seven
  characters, zero-padded to 16 bytes by `g(bArr2, false)`.
* No PKCS padding: the plaintext length rides in the last 32-bit word, and
  `f(v, true)` rejects it unless `4n-7 ≤ len ≤ 4n-4`.

Decrypting `assets/sorter.json` yields 311 183 bytes of JSON with keys
`Payloads`, `Free_servers`, `HopPayload`, `DualConnectPayload`, `SSLPayload`,
`CDNCerts`, `SRanges`, `CDNHosts`, `FrontHosts`, `BackHosts`, `SIPs`,
`BlockedApps`, `PdnsdType`, `Version`, `UDPVersion`, `Changelogs`.

### 2.2 The per-field layer

Every host-ish string inside that JSON is `hex(xor(text))` with the same
12-byte key the native `xorWithKey` uses, cycle starting at **offset 0**:

```
34 25 50 64 58 63 68 3e 66 6b 50 5d        "4%PdXch>fkP]"
```

Sweeping all twelve rotations over 1 017 host fields gives
`offset 0 → 97.0 %` characters inside `[a-z0-9.-_]`, every other rotation
≤ 43 %. `[sip]`, `[cdnh]`, `[sr]` and `auto` are placeholders that the app
expands into `SIPs`, `CDNHosts`, `SRanges` and Psiphon's own list.

### 2.3 `assets/server.psi` (Psiphon fallback)

Different cipher — the native `pDecrypt` — and a half-byte framing bug in the
payload itself:

| step | operation | size |
| --- | --- | --- |
| 0 | as shipped: ASCII hex, odd length | 103 253 chars |
| 1 | drop the first char (header nibble) | 103 252 chars |
| 2 | hex-decode | 51 626 bytes |
| 3 | XOR with the `.rodata:0xbfb77` key **rotated left by 9** | 99.965 % printable |
| 4 | 19 newline-separated hex lines | — |
| 5 | hex-decode each line | `0 0 0 0 {json}` Psiphon entries |

18 of 19 lines are complete Psiphon SSH/OSSH entries with their own
credentials; line 0 is a truncated fragment (the asset starts mid-entry).

## 3. The recovered catalogue

All of this is in `analysis-bdnet/configs/` — `bundled/` from the v106 APK,
`current/` from the live `JSONDEC2025` (bundle version 56).

### 3.1 SlowDNS — 20 real tunnel domains

```
de1.liftmeon.org   …   de20.liftmeon.org
```
(category `ocsslowdns`, engine `libdns` / `pdnsd`, `PdnsdType=tcp_only`)

### 3.2 FastDNS — 100 IPv4 endpoints

`173.212.232.241`, `173.212.252.3`, `173.249.10.48`, … (`libxdnstt`)

### 3.3 UDPQ — 725 IPv4 endpoints

`161.97.73.205`, `161.97.73.250`, `109.123.242.174`, … (`libudpq`)

### 3.4 KP / SSH — 10 pools of SNI hosts

`kp.txt` holds 1 500+ hostnames in the `us1.relatrix.world`,
`sv1.cyverntech.live`, `pa1.cyphernode.fit`, `de1.scholarmatrix.art`,
`lv1.securevaultworks.club`, `ar1.vaultfrontier.live`, `mor1.keycoretech.online`,
`ice1.lockciphertech.live`, `uk1.paperpulseresearch.live`,
`eu1.ironvaultresearch.us` families. In the v106 build the same slots carried
`1:1505@.livingforwardtoday.com`-style entries.

### 3.5 CDN fronting — 1 000 hostnames

`cdnhosts.txt` (`1001freefonts.com`, `1news.az`, …) plus `CF Global`
`d34s3y8bmu8jw7.cloudfront.net` and `V2Ray` `*.sullycdn.space`.

### 3.6 Proxy IPs — 1 840 addresses

`sips.txt`, the pool that `Normal Global` / `XRay Global` / `SS Global`
expand `[sip]` into.

### 3.7 Psiphon — 18 SSH/OSSH entries

`psiphon_entries.txt`: 139.59.194.137 (SG), 108.165.21.x (CA, 7),
172.105.79.225 / 172.234.227.18 / 172.234.178.218 (DE/US/FR),
151.243.14.x (DE, 4), 185.218.23.x (CA, 3). Each carries `sshUsername`,
`sshPassword`, `sshHostKey`, `signature`, `region`.

### 3.8 Payloads — 262 trick definitions

`payloads.json`: name, category, port, query, `isHostSni`, `isHostResolve`,
`tlsVersion`, `reconnectSeconds`. The `payload`/`sausage` blobs inside are
obfuscated with a *different* key and are deliberately left undecoded.

## 4. The DNS clients — the exact command lines (was: "still unknown")

Earlier versions of this document said a 64-hex **dnstt public key** was
missing. That was wrong, and the call sites in `XRayDNSService.java` and
`SocksDNSService.java` settle it. Neither tunnel is handed a 64-hex key.

### 4.1 FastDNS — `libxdnstt.so`

```java
this.s = new File(nativeLibraryDir, this.q + ".so");      // q = "libxdnstt"
arrayList.add(binary);
arrayList.add("-udp");                                    // [-98598896105355]
arrayList.add(host + ":53");                              // [-98620370941835]
arrayList.add("-report");                                 // [-98637550811019]
arrayList.add(getString(R.string.app));                   // "BD NET"
arrayList.add("-pubkey");                                 // [-98671910549387]
arrayList.add("prince");                                  // [-98706270287755]
arrayList.add("sd-" + server);                            // [-98581716236171] = "sd-"
arrayList.add("127.0.0.1:7000");                          // [-98736335058827]
```

So the pubkey **is the literal string `prince`** — their fork's `-pubkey` is not
the stock 64-hex X25519 key, and the zone is `sd-<server>`. `libxdnstt` also
carries `kemKey`, `Kyber`, and a long `_`/`-` base64 token next to the
`Chrome/iOS_13/iOS_14` uTLS fingerprints, i.e. the fork replaced the stock
`Noise_NK_25519_ChaChaPoly_BLAKE2s` handshake with a KEM-based one. That is
why a stock `dnstt-client` cannot talk to these servers: the *dance* differs,
not just the key.

### 4.2 SlowDNS — `libdns.so`

```java
arrayList.add(binary);                                    // libdns.so
arrayList.add("-tunnel");                                 // [-85963102320523]
arrayList.add(PUtils.pEncrypt(ctx, host + ":53"));        // hex(xor("ip:53"))
arrayList.add("-report");                                 // [-86014641928075]
arrayList.add(getString(R.string.app));
```

The tunnel secret is never written down: `libdns.so` receives an obfuscated
`ip:53` and does everything else itself. It is a Go binary built on
`routedns` + `quic-go` + `pion/dtls` + `certmagic` + `goproxy`, i.e. a DNS
forwarder with DoH/DoQ/DTLS listeners rather than a dnstt client.

### 4.3 What this means for "the key"

* A dnstt key is generated **on the server** with `dnstt-server -gen-key`; the
  client only ever receives the public half. It cannot be derived from
  anything observable from the client side.
* For these two particular servers neither a 64-hex key nor a SlowDNS secret is
  in the APK, because the app ships the vendor's *pre-configured* clients and
  only passes a name.
* Testing therefore has to run **their own binary** (or reproduce their KEM
  handshake). `.github/workflows/dns-tunnel-live.yml` does the former under
  `qemu-aarch64`; `analysis-bdnet/configs/dns/results/native-shim.txt` records
  how far the shim got.

## 5. Reproduce

```
# string table
python3 tools/lsparanoid_decode.py --selftest

# bundled catalogue (v106)
python3 tools/bdnet_sorter.py analysis-bdnet/assets/assets_sorter.json \
  -o analysis-bdnet/configs/bundled --json

# live catalogue (JSONDEC2025, bundle version 56)
python3 tools/bdnet_sorter.py analysis-bdnet/configs/JSONDEC2025.b64 \
  -o analysis-bdnet/configs/current --json

# Psiphon fallback
python3 tools/bdnet_decrypt.py analysis-bdnet/assets/assets_server.psi \
  -o analysis-bdnet/configs --json
```

`.github/workflows/bdnet-configs.yml` re-downloads the live bundle with the API,
decrypts it, runs the self-test (SlowDNS/FastDNS/CDN spot checks plus entry
counts) and uploads the result.
