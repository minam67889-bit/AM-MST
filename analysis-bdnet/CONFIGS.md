# BD NET — extracted configuration surface

Target: `dastan.prince.bdfreevpn`, versionCode 106, `PrinceBuild106` (the archive
`BDNET.VPN v106 Mod.zip`, package label "BD NET").

Everything below is produced by the CI job in `.github/workflows/analyze-apk.yml`
(step **Decrypt LSParanoid strings**) and committed to this folder, so it can be
re-derived from the APK at any time rather than being taken on trust.

## 1. How the strings were recovered

BD NET is obfuscated with [LSParanoid](https://github.com/LSPosed/LSParanoid). The
packer moves every string literal into one generated class
(`org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app`) that stores a 6-chunk,
41 966-character ciphertext table (5 × 8 191 + 1 011) and exposes `getString(long id)`.

The id is not an index: the table offset is derived from the id through
`RandomHelper.seed`/`RandomHelper.next`, and the characters are XORed with that
same stream. Recovering the table therefore needs the exact integer semantics of
the JVM (`short` rotations, 64-bit wrap-around, unsigned shifts).

Two false starts, both fixed:

| Attempt | Result | Cause |
| --- | --- | --- |
| Compile jadx's `DeobfuscatorHelper.java` and call it reflectively | 1 993 × `InvocationTargetException` | jadx rewrites the mask `0xffff0000` as `-65536`; inside a `long` that sign-extends and keeps bits above 31, so the computed index leaves the array |
| Compile LSParanoid's upstream sources instead | works, but needs a JVM + javac in CI and silently depends on the app's obfuscator release | — |

The shipped solution is `tools/lsparanoid_decode.py`: a literal port of the
obfuscator's own `RandomHelper`, `DeobfuscatorHelper` **and `StringRegistryImpl`
encoder**. `--selftest` encodes a known corpus (including a 9 000-character string
that spans two chunks and a non-ASCII string), decrypts it, and compares — so the
port proves itself before it touches the app's data:

```
$ python3 tools/lsparanoid_decode.py --selftest
SELFTEST PASS (7/7 strings, 2 chunk(s), multi-chunk=yes)
```

Full run:

```
chunks=6 chunk_chars=41966 ids=1992 decoded=1992 errors=0
```

Output: [`obfuscation/decrypted.txt`](obfuscation/decrypted.txt) — 1 992 ids,
1 851 non-empty plaintext strings. Hosts in
[`obfuscation/decrypted-hosts.txt`](obfuscation/decrypted-hosts.txt).

## 2. What the plaintext contains

### Network endpoints (complete list)

| String | Meaning |
| --- | --- |
| `https://raw.githubusercontent.com/panigbatanc/BDNET2023/main/JSONDEC2025` | Psiphon **RemoteServerListUrl** (set into the Psiphon config by `ca/psiphon/PsiphonTunnel.java`) |
| `https://s3.amazonaws.com//psiphon/web/mjr4-p23r-puwl/server_list_compressed` | Psiphon upstream server list (fallback) |
| `https://t.me/bdnetvpn` | developer Telegram channel |
| `https://raw.githubusercontent.com/vpnmarket/dialog15/refs/heads/main/BD%20106` | in-app announcement dialog for this build (fetched from the source tree, not the string table) |

Fetched for inspection: the `BD 106` file is an announcement JSON
(`title`/`description`/`download` → `tg://resolve?domain=VPNbaz`), **not** a server
config. `JSONDEC2025` is 469 KB of base64 that decodes to 351 KB of high-entropy
data — a Psiphon-encrypted server list, not a plaintext config.

### Protocol engines shipped

The string table names the tunnel types the UI can select; the APK's native
libraries implement them. All of them carry Go symbols, i.e. upstream Go engines
statically linked into `.so` files:

| UI value | Engine | Native library | Wire evidence |
| --- | --- | --- | --- |
| `SSH` | SSH + tun2socks | `libtun2socks.so` | `SSH_HOST`, `SSH_PORT`, `SSH Authenticating...` |
| `UDPQ` | dnstt-style DNS tunnel | `libudpq.so`, `libudpqtwo.so` | 375× `edns`, 25× `base32`, 8× `noise`, 3× `smux`, 2× `kcp` |
| `SLOWDNS` | **pdnsd** DNS forwarder | `libpdnsd.so` | `server { label=… ip=… }` config template in `Pdnsd.java` |
| `FASTDNS` | dnstt variant | `libxdnstt.so`, `libdns.so`, `libsuperdns.so` | `noise` ×12, `kcp` ×15, `base32`, `Failed to run DNSTT!` |
| `OVPN` | OpenVPN | bundled binary | `openvpn_userreq`, `openvpn_newstat` |
| `PSIPHON` | Psiphon tunnel core | `ca.psiphon.PsiphonTunnel` | `psiphonVpnStartBroadcast`, `Psiphon Running` |
| `SHADOWSOCKS` / `VLESS` | Xray 1.8.13 | bundled | full Xray JSON templates in the string table |

Important detail: BD NET's "SlowDNS" is **not** dnstt. `Pdnsd.java` writes a
`pdnsd.conf` (`server { label=…; ip=<resolver>; port=53; }`) and runs `libpdnsd`
as a local DNS forwarder for tun2socks. The dnstt-style code lives in
`libudpq` / `libxdnstt`, which the strings call `UDPQ` and `FASTDNS`.

### The configuration *fields* (i.e. what a BD NET "config" actually is)

`defpackage/C0223If.java` is the settings model. It reads
`SharedPreferences` — every value is user- or import-supplied:

| Key | Default in the app |
| --- | --- |
| `SSH_HOST` | `""` |
| `SSH_PORT` | `0` |
| `SNI` | `""` |
| `PROXY_HOST` | `""` |
| `DNS_SERVERS_NEW` | `"1.1.1.1;1.0.0.1"` |
| `DNS_FORWARD` | `false` |
| `AUTO_SELECT_SERVER` | `"true"` |
| `USE_HOST_SNI` | `false` |
| `TUNNEL_TYPE` | `0` |
| `PDNSD_TYPE` | *(null → compiled-in query method)* |
| `DNS_POSITION_NEW`, `SERVER_SELECTED_POSITION` | `0` |
| `RECONNECT_SECONDS` | `"false"` |
| `APPS_NEW` | *(empty set)* |

Additional keys present in the model: `NETWORK_MESSAGE`, `NETWORK_SELECTED_NAME`,
`BackQuery`, `isFastDns`, `isSlowDns`, `isUdpSet`, `isSshSet`, `isOvpnSet`,
`isPsiphonSet`, `isXRaySet`.

So a BD NET config is a bundle of *these fields* — imported through
`ImportTweakActivity` (`content://` / `file://` intent) or typed in the
"Custom Tweak" dialog (`name`, `message`, `mode`, `type`, payload, `SNI`,
proxy host/port, expiry). It is not a URL that can be downloaded and it is not
baked into the APK.

## 3. What is *not* in the app — verified, not assumed

There is no hidden server list and no dnstt key in this APK. Evidence:

1. **String table** — 1 851 strings: zero hostnames other than the three above,
   zero 64-hex-digit Noise public keys, no `*.ir` / `*.fun` / `*.online` server
   domain, and no `dnstt`/`pubkey`/`resolver` literal.
2. **Native libraries** — the only 64-hex strings in `libdns.so` /
   `libxdnstt.so` are Go generic type-shape hashes
   (`sync/atomic.(*XXiWi1I[go.shape.<64 hex>]).Load`), not keys. The remaining
   "domains" in `native/*.domains.txt` are Go symbol fragments (`4roIqmw4E.String.fun`).
3. **Defaults** — every connection field defaults to `""` or `0`; only the
   resolver list has a value, and it is Cloudflare/Google, not BD NET infrastructure.
4. **No assets** — the APK ships no JSON/config asset (`assets/sorter.json` is a
   JSON key-sorting helper for the Xray config builder).

## 4. Consequence for our client

* Our MasterDnsVPN-style engine needs a `(domain, server public key, resolvers)`
  triple. BD NET supplies `resolvers` (default `1.1.1.1;1.0.0.1`, user-editable,
  semicolon separated) and nothing else.
* The `UDPQ`/`FASTDNS` engines are dnstt-family, so a BD NET config *is*
  wire-compatible with our `docs/DNSTT-PLAN.md` transport — but only once a
  config file supplies the domain and the 32-byte server key. Those are
  distributed by the developer (Telegram `t.me/bdnetvpn`), not embedded.
* Therefore "extract BD NET's configs" yields the app's endpoints and the exact
  field list above. It does not yield a usable server: this build genuinely does
  not contain one, and the app cannot connect until the user imports a tweak.

## 5. Reproduce

```
python3 tools/lsparanoid_decode.py --selftest
python3 tools/lsparanoid_decode.py \
  --java 'analysis-bdnet/obfuscation/Deobfuscator$BDNETVPN$app.java' \
  --scan analysis-bdnet/sources/sources \
  --out analysis-bdnet/obfuscation/decrypted.txt \
  --hosts-out analysis-bdnet/obfuscation/decrypted-hosts.txt
```

The same two commands run in GitHub Actions on every push (step *Decrypt
LSParanoid strings*), against the freshly downloaded APK, so the committed
output is always regenerable.
