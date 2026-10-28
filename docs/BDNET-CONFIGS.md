# BD NET — where the servers actually come from

Target: `dastan.prince.bdfreevpn`, versionCode 106, `PrinceBuild106`
(`BDNET.VPN v106 Mod.zip`).

> **Correction.** An earlier revision of this file concluded that BD NET ships no
> server list. That conclusion was drawn from a *partial* jadx dump (364 files
> committed out of the full tree) and it was wrong. The app does load servers
> automatically, from the endpoints listed in §2. What is recorded below is what
> the full tree actually shows.

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

Bundled fallback inside the APK: `assets/server.psi` (51 626 bytes, encoded in a
hex alphabet) and `assets/sorter.json` (311 188 bytes). `sorter.json` is
referenced from many call sites in the dex.

## 3. The blocker: how the bundles are ciphered

Base64-decoding a bundle yields high-entropy bytes of arbitrary length
(`JSONDNSTT` 462 808 ≡ 8 mod 16, `sorter.json` 311 188 ≡ 4 mod 16) with **zero
repeated 16-byte blocks**. That rules out AES-ECB over the whole blob and points
at a stream cipher or an AEAD (nonce ‖ ciphertext ‖ tag).

The one AES helper in the app is `smalihelper/heIran.decrypt`:

```java
key  = new SecretKeySpec(SHA-256(password).digest(), "AES");  // AES-256
Cipher.getInstance("AES");                                    // AES/ECB/PKCS5
cipher.init(DECRYPT_MODE, key);
return new String(cipher.doFinal(Base64.decode(text, 0)));
```

Tested against the bundles with both 40-hex secrets (as text, as raw bytes, as
AES-128/192/256 keys, at 16 offsets) — no plaintext. It also has **no callers** in
the dex, so it is dead code from the repack, not the config path. The real
decryption therefore lives in native code or in a class jadx dropped from the
decompile (the constants have no Java consumer at all).

## 4. What is still true

* Every connection *setting* (`SSH_HOST`, `SNI`, `PROXY_HOST`, `TUNNEL_TYPE`,
  `PDNSD_TYPE`, …) still defaults to `""`/`0` in `defpackage/C0223If`; the
  servers themselves arrive from the bundles above, not from those prefs.
* Resolver default remains `1.1.1.1;1.0.0.1` (`DNS_SERVERS_NEW`).
* Endpoints not related to servers: `https://t.me/bdnetvpn`,
  `https://t.me/anty_filter`, the Psiphon remote list
  (`raw.githubusercontent.com/panigbatanc/BDNET2023/main/JSONDEC2025` is passed to
  Psiphon as *RemoteServerListUrl* in one place), and the in-app announcement
  `https://raw.githubusercontent.com/vpnmarket/dialog15/refs/heads/main/BD%20106`.

## 5. Reproduce

```
python3 tools/lsparanoid_decode.py --selftest
python3 tools/lsparanoid_decode.py \
  --java 'analysis-bdnet/obfuscation/Deobfuscator$BDNETVPN$app.java' \
  --scan java --out analysis-bdnet/obfuscation/decrypted.txt
```

CI also commits, per run: `analysis-bdnet/assets/` (every bundled asset that
could be a server list, with `strings` and hostname extract), and
`analysis-bdnet/hunt/` (all URL literals, App Engine/Firebase identifiers,
server-list vocabulary, cipher sites, Base64 decode sites, and the smali
surrounding the config constants).
