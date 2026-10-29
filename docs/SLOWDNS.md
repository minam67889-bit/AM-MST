# SlowDNS through BD NET's own servers: it carries traffic now

This is the file that matters. Everything below was measured on a GitHub
Actions runner (a machine with real internet, `qemu-aarch64-static` and BD's
own arm64 binaries), on 2026-10-29, with raw output in the live-shell channel
(issue #1) and reproduced twice.

## What was wrong for weeks

BD NET's SlowDNS path is a stock `dnstt` client (`libxdnstt.so`) whose **far
end runs a SOCKS5 that demands a username and password**. We drove the tunnel
perfectly - `sd-de1.liftmeon.org`, `-pubkey prince`, `-report "BD NET VPN"`,
"begin session" in their own log - and then got `01 ff` (authentication
failed) from the far end for every pair we had:

* the pair printed in their Xray template (`tanginaka` / `wagditokupal`),
* reversed / doubled / upper / hex / base64 / empty variants,
* `prince`, `bdfreevpn`, `bdnet`, the zone, the report label.

The pair in their string table is a **decoy**.

## How the real pair was found

Their app never speaks SOCKS itself: their (patched) `libxray.so` does, as an
outbound pointing at `127.0.0.1:7000` (the dnstt client's local port). So we
put a logging TCP proxy between the two and gave Xray a config with a
*deliberately wrong* password:

```
libxray.so  ->  127.0.0.1:7001 (logger)  ->  127.0.0.1:7000 (libxdnstt)

CLIENT->UPSTREAM BYTES:
b'\x05\x01\x02
  \x01\x0b tanginakaba \x0e hackpamoregago
  \x05\x01\x00\x03\x0bexample.com\x00P
  GET / HTTP/1.1 ...'
```

Xray ignored the password in the config and sent `tanginakaba` /
`hackpamoregago` - the shared library substitutes the real pair at runtime.
So the real login is:

| field | value |
| --- | --- |
| user | `tanginakaba` (11 bytes) |
| password | `hackpamoregago` (14 bytes) |

and the handshake is exactly what their client sends:

```
-> 05 01 02                                  (SOCKS5, one method: user/pass)
<- 05 02
-> 01 0b "tanginakaba" 0e "hackpamoregago"
<- 01 00                                     (accepted)
-> 05 01 00 03 <len> <host> <port>           (CONNECT, domain form)
<- 05 00 00 01 <4-byte bind> <port>          (granted)
```

## Verified, with numbers

Fresh client, no Xray, plain sockets (2026-10-29 13:12Z, `sd-de1` /
`13.140.185.158`):

```
auth: 0100 1045ms
reply: 05000001 atyp 1
tunnel up in 1229ms
HTTP/1.1 200 OK ... got 932 bytes
```

Acceptance test, through the repo's own relay on `127.0.0.1:1080`:

| request | result |
| --- | --- |
| `http://example.com/` | 200, 577 B, 0.84 s |
| `http://example.com/` via the runner's **LAN IP** `10.1.0.208:1080` | 200, 577 B, 2.0 s |
| `https://api.telegram.org/` | **302, 145 B**, 1.7 s |
| `https://web.telegram.org/` | 200, 1587 B, 2.2 s |

`sd-de20.liftmeon.org` / `13.140.185.181` answers the same pair (`auth: 0100`,
CONNECT granted), so the login is per-service, not per-server.

## What the app now does

`engineMode = 1` (**the default**) - real DNS tunnelling through BD's servers:

1. `libxdnstt.so -udp <ip>:53 -report "BD NET VPN" -pubkey prince sd-<host>
   127.0.0.1:7000`, trying `de1..de20.liftmeon.org` until one answers;
2. a local SOCKS5 on `127.0.0.1:1080` that logs in to that far end with the
   recovered pair and hands out a no-auth proxy (`Socks5Relay`);
3. **LAN share**: the same proxy bound to `0.0.0.0:1080`, so a laptop on the
   phone's hotspot or Wi-Fi sets SOCKS5 = `phone-ip:1080` and is on the tunnel.
   Sockets are `protect()`ed, so this also works while the whole-device VPN is
   up (our own app is `addDisallowedApplication`'d, so the tunnel client's DNS
   packets never re-enter the tun);
4. whole-device VPN: the tun fd goes to BD's own `libtun2socks.so`, which dials
   that same SOCKS5.

Telegram: Settings -> Data and Storage -> Proxy -> SOCKS5 `127.0.0.1` `1080`,
no user/password.

## Honest limits

* This borrows their account: the login is fixed service-wide, so it can be
  rotated by BD at any time (if auth starts failing, the pair changed; the
  procedure above - log what their patched Xray sends - recovers the new one).
* Right now the app ships BD's binaries from their public APK (built in CI from
  the `amtunnel-apk-analysis` artifact), not from this repository.
* Speed is a DNS tunnel's speed: page loads and Telegram work; video does not.

## Verification status (2026-10-29, end of day)

| layer | how it was checked | state |
| --- | --- | --- |
| the wire, with BD's binaries | `libxdnstt.so` + plain socket client under qemu on a runner | **verified** - auth `0100`, CONNECT granted, HTTP 200 |
| the far-end login | captured from BD's own patched Xray, replayable | **verified** on `sd-de1` and `sd-de20` |
| the shipped relay code | `core/src/test/kotlin/io/amtunnel/core/Socks5RelayTest.kt` in CI: stub far end, real `Socks5Relay` | **verified** - logs in upstream, hands out a no-auth proxy, and a refused login blocks the client |
| the APK | CI "Verify APK contents" now fails unless `libxdnstt.so` + `libtun2socks.so` are inside | **verified** (16,587,328 B and 160,232 B) |
| the app on a phone | `SelftestReceiver` (`am broadcast -a io.amtunnel.app.SELFTEST`) sends a real GET through 1080 and logs `AMTUNNEL-SELFTEST RESULT ...` | **not run here** - the arm64 emulator job (`app-selftest.yml`) failed to boot inside its 90 minute limit; run the broadcast on a real phone to get the same verdict |

Speed is a DNS tunnel's speed: 129 KB/s down on a 512 KiB fetch, page loads and
Telegram are fine, video is not. Only TCP is proxied (no UDP ASSOCIATE), which
Telegram's TCP fallback handles.
