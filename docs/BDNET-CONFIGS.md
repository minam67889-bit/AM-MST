# BD NET — where the servers actually come from

Target: `dastan.prince.bdfreevpn`, versionCode 106, `PrinceBuild106`
(`BDNET.VPN v106 Mod.zip`).

> **Correction.** An earlier revision of this file concluded that BD NET ships no
> server list. That conclusion was drawn from a *partial* jadx dump (364 files
> committed out of the full tree) and it was wrong. The app does load servers
> automatically, from the endpoints listed in §2. What is recorded below is what
> the full tree actually shows.
>
> **Update.** The bundle cipher is now solved as well: the bundled
> `assets/server.psi` decrypts to 18 live Psiphon server entries. See §3.

## 1. String deobfuscation (still solved)

BD NET is packed with [LSParanoid](https://github.com/LSPosed/LSParanoid). The
generated class `org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app` holds a
41 966-character ciphertext table (6 chunks: 5 × 8 191 + 1 011) and
`getString(long)` derives both the offset and the XOR stream from the id.

jadx mangles `DeobfuscatorHelper` (it rewrites `0xffff0000` as `-65536`, which
sign-extends inside a `long`), so replaying the decompiled helper on a JVM threw
`InvocationTargetException` for all 1 993 ids. `tools/lsparanoid_decode.py` is a
literal port of `RandomHelper` + `DeobfuscatorHelper` + the `StringRegistryImpl`
encoder; `--selftest` encodes a corpus, decrypts it and compares, so the port is
proven rather than assumed.

```
SELFTEST PASS (7/7 strings, 2 chunk(s), multi-chunk=yes)
chunks=6 chunk_attrs=41966 ids=1992 decoded=1992 errors=0
```

Output: `analysis-bdnet/obfuscation/decrypted.txt` (1 992 ids, 1 851 non-empty).

## 2. Where the servers come from — the real answer

The string table contains the config bundle URL twice:

```
https://raw.githubusercontent.com/panigbatanc/BDNET2023/main/JSONDEC2025
```

`defpackage/AbstractC0482Sf` is the constants holder. Its static initialiser
resolves four strings and parks `a = 7878` beside them:

| id | value |
| --- | --- |
| `-163397067700107` | the bundle URL above |
| `-163710600312715` | `https://t.me/bdnetvpn` |
| `-163805089593227` | `5FED785CA69AEC41CE2C925E8C8A5A738A6DE276` |
| `-163981183252363` | `B8B496A532852A50C2F992200DD8E2C43A8844F4` |

That repository (`panigbatanc/BDNET2023`, same author as the app) holds a bundle
per mode — the mode names match the app's own engine selectors (`UDPQ`,
`FASTDNS`, `SLOWDNS`, Xray, SSH, Psiphon):

| file | bytes | mode |
| --- | --- | --- |
| `JSONDNSTT` | 617 081 | dnstt / UDPQ |
| `JSONFASTDNS` | 154 125 | FastDNS (`libxdnstt`) |
| `JSONXRAY` | 215 297 | Xray / Shadowsocks / VLESS |
| `JSONNOCIPHER` | 582 445 | un-ciphered variant |
| `JSONFWPUNCHER` | 325 001 | FWPuncher |
| `JSONSPLITNEWERA` | 582 445 | split tunnelling |
| `JSONDEC2025` | 469 153 | current build's pointer |
| `JSONKYLE`, `AGITTY2025`, `JSONSEPT2025`, `JSONAUG2025`, `JSON061424`, `JSONSEPT132024`, `JSONSPLIT2024`, `JSONXRAYNOV29` | — | monthly rotations |

The same bundle set is mirrored in the author's other apps (`UrsaNetPRO`,
`Omanova2024`), so these are shared, rotated config drops — not per-app secrets.

Bundled server list inside the APK: `assets/server.psi` — 103 253 ASCII hex
characters that decrypt to **18 Psiphon SSH/OSSH server entries**, solved in §3.
`assets/sorter.json` (311 188 bytes base64) is referenced from many call sites
but is not a server list.

## 3. Solved: `assets/server.psi` holds 18 Psiphon server entries

`TunnelVpnManagerPsi.startPsiphon()` is the zero-input path — the mode that
connects with nothing typed in:

```java
string = loadServerDat(this.mContext, "server.psi");   // asset text, UTF-8
m_tunnel.startTunneling(PUtils.pDecrypt(this.mContext, string));
```

`loadServerDat` is `S50.D(context, str)`; the charset id `-95609598867339`
decodes to `UTF-8`, and `-95639663638411` decodes to `server.psi`. `pDecrypt`
is the native function in `libputils.so` (`0x147ef8`), whose body is
`hexToString` → `xorWithKey` → `new String(bytes)`.

The asset defeats the naive reading of that chain, which is why earlier
attempts produced junk. The working layer stack, verified byte-for-byte:

| step | operation | size |
| --- | --- | --- |
| 0 | `assets/server.psi` as shipped: ASCII hex, odd length | 103 253 chars |
| 1 | drop the first char (header nibble) | 103 252 chars |
| 2 | hex-decode | 51 626 bytes |
| 3 | XOR with the 12-byte `.rodata:0xbfb77` key **starting at offset 9** | 51 626 chars, 99.965 % printable ASCII |
| 4 | the result is 19 newline-separated hex lines | — |
| 5 | hex-decode each line | canonical Psiphon entries |

The key lives at file offset == vaddr `0xbfb77` (`.rodata` starts at
`0x0b8ef0`, length `0x436bc`), with no relocation:

```
34 25 50 64 58 63 68 3e 66 6b 50 5d        "4%PdXch>fkP]"
```

Step 3 needs that constant *rotated left by 9*: `6b 50 5d 34 25 50 64 58 63 68
3e 66` (`kP]4%PdXch>f`). That is not a guess — the twelve rotations were swept
and only this one lifts the printable ratio from ~68 % to 99.965 %, and only
this one yields JSON. Rotations at offset 0 (what the disassembly literally
does) and at any other phase produce binary noise.

Credit where due: `pDecrypt` itself is not the weak link, the **framing** is.
The payload carries one extra leading nibble, so `hexToString` on the raw
string is offset by half a byte for the whole file.

Step 5 output is the Psiphon `EncodeServerEntry` text form:

```
0 0 0 0 {"capabilities":["ssh-api-requests","SSH","OSSH",...],
         "configurationVersion":0,"ipAddress":"139.59.194.137",
         "meekCookieEncryptionPublicKey":"...","sshHostKey":"...",
         "sshObfuscatedPort":53,"sshPassword":"<64 hex>",
         "sshPort":22,"sshUsername":"psiphon_ssh_<16 hex>",
         "tag":"<44 char base64>"}
```

18 of the 19 lines parse as complete JSON. Line 0 is a tail fragment
(`...","sshObfuscatedPort":554,...`) — the asset itself starts mid-entry, a
defect in whoever generated it; it is dropped rather than guessed at.

### 3.1 The recovered servers

`analysis-bdnet/configs/psiphon_entries.txt` (+ `.json`, + `.hex.txt`), produced
by `tools/bdnet_decrypt.py`, which re-derives the rotation and fails closed:

| # | ip | region | ssh | obfuscated | provider |
| --- | --- | --- | --- | --- | --- |
| 1 | `139.59.194.137` | SG | 22 | 53 | `6F1EC65541D53546` |
| 2 | `108.165.21.18` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 3 | `108.165.21.70` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 4 | `108.165.21.226` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 5 | `108.165.21.185` | CA | 22 | 554 | `1E9F53D88A07EDCC` |
| 6 | `108.165.21.213` | CA | 22 | 554 | `1E9F53D88A07EDCC` |
| 7 | `108.165.21.59` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 8 | `108.165.21.179` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 9 | `172.105.79.225` | DE | 22 | 53 | `66FA5AFE5F394DE1` |
| 10 | `172.234.227.18` | US | 22 | 554 | `66FA5AFE5F394DE1` |
| 11 | `172.234.178.218` | FR | 22 | 554 | `66FA5AFE5F394DE1` |
| 12 | `151.243.14.61` | DE | 22 | 53 | `2A3E40141CD41783` |
| 13 | `151.243.14.99` | DE | 22 | 53 | `2A3E40141CD41783` |
| 14 | `151.243.14.113` | DE | 22 | 53 | `2A3E40141CD41783` |
| 15 | `151.243.14.214` | DE | 22 | 53 | `2A3E40141CD41783` |
| 16 | `185.218.23.208` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 17 | `185.218.23.46` | CA | 22 | 53 | `1E9F53D88A07EDCC` |
| 18 | `185.218.23.115` | CA | 22 | 53 | `1E9F53D88A07EDCC` |

Each entry carries its own `sshUsername`/`sshPassword` pair, so these are
working, self-contained Psiphon SSH/OSSH endpoints — no account needed.

### 3.2 What is *not* in the APK

The zero-input path is **Psiphon only**. There is no bundled SlowDNS / dnstt /
UDPQ server domain or public key anywhere: the only two non-code assets are
`server.psi` (above) and `sorter.json`, and `res/raw` holds just
`psiphon_config` (177 B) and `pdnsd_local` (293 B). The dnstt/UDPQ/Xray engines
take their `host:port`, SNI and key from the settings store
(`C0223If`: `SSH_HOST`, `SNI`, `PROXY_HOST`, `TUNNEL_TYPE`, `PDNSD_TYPE`), i.e.
from a config file the user imports — that is why a SlowDNS "tweak" is needed
while Psiphon "just works".

## 4. The remote bundles are a different cipher

Base64-decoding a bundle yields high-entropy bytes (`JSONDNSTT` 462 808 ≡ 8
mod 16, `sorter.json` 311 188 ≡ 4 mod 16) with **zero repeated 16-byte blocks**.
Swept against the recovered key at all 12 rotations, on the raw bytes, on the
base64 text, after a hex decode, with 0–2 leading chars trimmed: no hit. They
are not produced by `pDecrypt`, and they are not needed for Psiphon mode.

The one AES helper in the app is `smalihelper/heIran.decrypt`
(`AES/ECB/PKCS5`, key = SHA-256 of a password). It has **no callers** in the dex.

## 5. What is still true

* Every connection *setting* (`SSH_HOST`, `SNI`, `PROXY_HOST`, `TUNNEL_TYPE`,
  `PDNSD_TYPE`, …) defaults to `""`/`0` in `defpackage/C0223If`.
* Resolver default remains `1.1.1.1;1.0.0.1` (`DNS_SERVERS_NEW`).
* Endpoints not related to servers: `https://t.me/bdnetvpn`,
  `https://t.me/anty_filter`, the Psiphon remote list
  (`https://s3.amazonaws.com//psiphon/web/mjr4-p23r-puwl/server_list_compressed`,
  the stock Psiphon list, wired to `RemoteServerListUrl`), and the in-app
  announcement
  `https://raw.githubusercontent.com/vpnmarket/dialog15/refs/heads/main/BD%20106`
  (`AbstractC0482Sf`, whose `7878` constant is the announcement port, not a
  tunnel port).

## 6. Reproduce

```
# string table
python3 tools/lsparanoid_decode.py --selftest
python3 tools/lsparanoid_decode.py \
  --java 'analysis-bdnet/obfuscation/Deobfuscator$BDNETVPN$app.java' \
  --scan java --out analysis-bdnet/obfuscation/decrypted.txt

# server list
python3 tools/bdnet_decrypt.py analysis-bdnet/assets/assets_server.psi \
  -o analysis-bdnet/configs --json
```

CI: `.github/workflows/bdnet-servers.yml` re-downloads the analysed APK
artifact, extracts `assets/server.psi`, runs the decryptor, asserts 18 entries
and uploads them. `analyze-apk.yml` still commits `analysis-bdnet/assets/`
(asset dumps + `strings` + hostname extract) and `analysis-bdnet/hunt/`.
