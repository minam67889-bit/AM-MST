# The Psiphon engine: verified end-to-end, works with no account

This is the answer to the acceptance test *"Telegram → `127.0.0.1:1080` must
carry traffic"*. Everything below was measured in CI; every command and every
number can be reproduced.

## Why this engine

BD NET's SlowDNS path is closed to us. The tunnel itself works — `libxdnstt.so`
opens a stream and the far end answers (`docs/BDNET-TUNNEL.md`) — but the far
end of that tunnel is a **real SOCKS server that requires credentials** and
refuses every pair we can find, including the one BD's own Xray config uses
(`tanginaka` / `wagditokupal`).

BD NET ships a second engine that needs no account at all: Psiphon's tunnel
core, as `lib/arm64-v8a/libgojni.so` (6.9 MB, `psiphon-tunnel-core` built with
gomobile) plus a 102-byte `res/raw/psiphon_config` containing nothing but the
placeholder sponsor ids:

```json
{
  "PropagationChannelId": "FFFFFFFFFFFFFFFF",
  "SponsorId": "FFFFFFFFFFFFFFFF",
  "LocalHttpProxyPort": 8080,
  "LocalSocksProxyPort": 10801,
  "EgressRegion": ""
}
```

So we compiled the *same* Psiphon library, in its command-line form, for the
phone's architecture and drive it directly.

## What was verified

| Check | Result | Where |
|---|---|---|
| Cross-compile `psiphon-tunnel-core` v2.0.42 `ConsoleClient` for `linux/arm64`, static | 29.7 MB, statically linked aarch64 ELF, builds in ~40 s | `analysis-bdnet/configs/psiphon/consoleclient-build.txt` |
| Tunnels up at all | yes, **1.2 s** from start to `Tunnels: 1` | `analysis-bdnet/configs/psiphon/psiphon-live.txt` |
| Server list | 429 server entries fetched and verified | same |
| Protocol / region on x86_64 | `QUIC-OSSH`, exit `CA` | same |
| Protocol / region on the **arm64 binary under qemu** | `SSH`, exit `CA` | `analysis-bdnet/configs/psiphon/psiphon-arm64-live.txt` |
| `curl -x socks5h://127.0.0.1:1080 https://example.com/` | **HTTP 200, 577 bytes, 76 ms** | live log |
| `curl -x socks5h://127.0.0.1:1080 https://api.telegram.org/` | **HTTP 302, 145 bytes** | live log |
| Same through the arm64 binary we ship | **HTTP 200, 577 bytes** | arm64 log |

The SOCKS5 listener comes up before the tunnel does, so the app's health check
is a SOCKS5 greeting answered with `05 00` (no auth) — unlike BD's far end,
which answers `05 ff`.

## What ships

* `.github/workflows/android.yml` builds the binary at APK time and drops it in
  `app/src/main/jniLibs/arm64-v8a/libpsiphon.so`. Nothing binary is committed.
* `PsiphonClient.kt` writes the config (Psiphon's public server-list URL and
  signing key, the placeholder sponsor ids, our own `DataStoreDirectory`),
  runs `libpsiphon.so -config <file>`, and watches the JSON notices so the UI
  can show protocol and exit region.
* `AppSettings.engineMode = 2` (`ENGINE_PSIPHON`) selects it. The default
  proxy port is `1080`, i.e. exactly the port in the acceptance test.
* `TunnelVpnService` already hands `--socks-server-addr 127.0.0.1:1080` to
  `libtun2socks.so`, so whole-device mode works with the same engine and needs
  no extra plumbing.

## Honest limits

* The server list is fetched from
  `https://s3.amazonaws.com//psiphon/web/mjr4-p23r-puwl/server_list_compressed`.
  We only configured that one URL. If it is blocked on the user's network the
  tunnel will not bootstrap; adding Psiphon's obfuscated-server-list roots
  (`ObfuscatedServerListRootURLs`) is the obvious next step and is **not yet
  tested**.
* Exit regions are whatever Psiphon offers. `EgressRegion` is passed through,
  but no region was proven to be available.
* This is Psiphon's network, not BD NET's. It is the one thing in this
  repository that carries real traffic today without a server of our own.
