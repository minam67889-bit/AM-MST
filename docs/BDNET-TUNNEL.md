# BD NET: what is verified, and what is still open

Every line below is a measurement from `bd-tunnel.yml` on GitHub Actions, with
the raw output committed under `analysis-bdnet/configs/dns/results/`. Nothing
here is inferred from the app's source alone.

## 1. The binaries run

`libxdnstt.so` and `libdns.so` are Android/arm64 PIE executables whose
interpreter is `/system/bin/linker64`. They run under `qemu-aarch64-static`
with a real bionic sysroot (`linker64` + `lib64/*` from the API-24 arm64 system
image). glibc cannot host them (`version 'LIBC' not found`).

`libxdnstt.so -h` is stock dnstt plus two flags:

```
-doh / -dot / -udp / -pubkey / -pubkey-file / -report / -utls
DOMAIN LOCALADDR
```

There is **no SOCKS flag**. That settles an old question: their local end is a
*raw* TCP forwarder, exactly as upstream dnstt documents.

## 2. The licence gate is the app label

The `-report` value must be the exact application label, `BD NET VPN`:

```
Licensed to BD NET VPN
uTLS fingerprint iOS 14|Firefox 120|Chrome 120|Randomized-ALPN 0
effective MTU 131-138
begin session <8 hex>
```

Every other value (`BD NET`, `BDNET`, `prince`, `bdfreevpn`, the package name,
empty) leaves the client silent.

## 3. The zone is `sd-` + the hostname the app lists

Given `-udp <ip>:53`, only one zone produces a tunnel:

| zone | far-end answer |
| --- | --- |
| `sd-de1.liftmeon.org` | `05 ff` in ~180 ms |
| `sd-de1` | timeout |
| `de1.liftmeon.org` | timeout |
| `sd-aog1.liftmeon.org` | timeout |
| `sd-aog1` | timeout |

A wrong zone does not get an error - the server simply stays silent. That is
why earlier sweeps using `sd-<ip>` looked like "the client sends but hears
nothing".

## 4. The tunnel is alive on all twenty servers

With zone `sd-de<n>.liftmeon.org` and `-udp <ip-of-de<n>>:53`, every one of the
twenty endpoints answers a SOCKS5 greeting that originates **at the far end**:

```
de1  13.140.185.158  05ff      de11 13.140.185.171  05ff
de2  13.140.185.159  05ff      de12 13.140.185.172  05ff
...
de20 13.140.185.181  05ff
```

Two independent proofs that these bytes came through the tunnel and not from
the local process:

1. **Latency.** The greeting arrives after ~245 ms, which is a round trip to a
   server in another country. A locally generated reply would arrive in well
   under a millisecond.
2. **The dead-tunnel control.** The same client pointed at an endpoint that
   does not answer (`173.212.232.241`) never returns a byte on the local port -
   every probe times out. So the port only speaks when the tunnel is up.

`sendto`/`recvfrom` counts under `-strace` agree: 172 queries sent, 158
responses with payload for a 60-second session.

## 5. What is still open: the far end wants a password

The SOCKS5 at the far end of the tunnel offers **only** RFC 1929
username/password:

```
offer 05 01 00        -> 05 ff        (no acceptable methods)
offer 05 02 00 02     -> 05 02        (username/password selected)
auth  tanginaka/wagditokupal -> 01 ff (rejected)
```

`tanginaka` / `wagditokupal` is the pair BD's own Xray template uses for
`127.0.0.1:7000` (it is in their LSParanoid string table, alongside the
`"socks5": {"listen": "127.0.0.1:7777"}` templates). It is refused, and so are:

* the pair reversed, and each half with itself,
* `prince`, `bdfreevpn`, `bdnet`, `dastan`, `liftmeon`, `de1`, `aog`,
* the report string `BD NET VPN` and the zone in either field,
* hex- and base64-encoded variants of the pair, upper case, empty fields.

The credential never appears in the app's decrypted string table, in
`JSONDEC2025` / `JSONDNSTT` / `JSONFASTDNS`, or in the payload entries (whose
`username`/`password` fields are empty for every DNS entry).

So the state is: **the wire path is proven end to end, the authentication is
not.** Two honest possibilities remain - the far-end account is per-user and
provisioned by BD's own backend, or it is a value we have not located in the
binary.

## 6. What this repository ships

`engineMode = 1` in the app ("Use BD NET mode now") makes it:

1. resolve the configured hosts (default `de1..de20.liftmeon.org`),
2. start **BD's own** `libxdnstt.so` with `-udp <ip>:53 -report "BD NET VPN"
   -pubkey prince sd-<host> 127.0.0.1:7000`,
3. treat "a SOCKS5 reply on the local port" as the readiness signal - that is a
   real round trip through the tunnel, not a port ping,
4. move to the next host if one does not answer,
5. bridge the far end to a clean, unauthenticated `127.0.0.1:1080` SOCKS5 using
   the user/pass from the settings screen,
6. optionally hand the tun device to BD's own `libtun2socks.so` for a
   whole-device VPN.

The binaries are copied out of the public APK artifact at build time
(`app/src/main/jniLibs/arm64-v8a/`) and are not committed here.

Verified: the app builds with them, and the client starts, connects and reaches
the far end (steps 1-4 are exactly what `bd-tunnel.yml` does outside the app).

Not verified: a request completing through the far end, because step 5 needs a
credential that has not been found yet. Until then the built-in Master core
(`engineMode = 0`) remains the only path in this repo that carries a full page
end to end - against our own server, as documented in `docs/DNS-CONNECT-TEST.md`.

## Reproducing

```
gh workflow run bd-tunnel.yml        # clone the APK, sysroot, run the client
cat analysis-bdnet/configs/dns/results/bd-tunnel.txt
```

The job is deliberately short: it does not touch the app, only BD's binaries,
so a claim about "a byte through their tunnel" can be re-checked in five
minutes.
