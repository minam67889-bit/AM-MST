# dnstt / "SlowDNS" — the protocol BD NET uses for its DNS mode

Grounded in the real source: `github.com/Mygod/dnstt` (mirror of
`www.bamsoftware.com/git/dnstt.git`), which is the engine behind
`libxdnstt.so` in BD NET.

Confirmed from `go.mod` and `noise/noise.go`:

```
github.com/flynn/noise            Noise protocol framework
github.com/xtaci/kcp-go/v5        KCP reliable stream
github.com/xtaci/smux             stream multiplexer
github.com/refraction-networking/utls   (server-side TLS fingerprinting)
```

Handshake: **Noise_NK_25519_ChaChaPoly_BLAKE2s**, pattern `noise.HandshakeNK`,
DH25519 + CipherChaChaPoly + HashBLAKE2s, server public key is 32 bytes written
as 64 hex digits.

Packet path: `TCP → smux → KCP → Noise → turbotunnel → DNS`

* `turbotunnel.ClientID` = **8 random bytes**, attached to every frame so the
  server can keep a session alive across changing resolver IPs (the same
  property our MasterDnsVPN transport gets from `(sessionId, cookie)`).
* Data is carried in the **QNAME**: base32 expands 5 bytes to 8 characters, and
  labels are capped at 63 bytes like any DNS name; `dnsNameCapacity()` in
  `dnstt-client/main.go` computes the usable payload for a domain suffix.
* Answers come back as TXT records (same general family as the tunnel we
  already implement, different framing and crypto).

## What a dnstt client needs

| Layer | Size of the work | Notes |
| --- | --- | --- |
| base32 QNAME codec + name-capacity maths | small | mirror of our existing `Base36Lower` |
| turbotunnel framing (8-byte client id + length) | small | plain byte layout |
| Noise NK handshake + transport | medium | X25519 and ChaCha20-Poly1305 already exist in `Crypto.kt`; needs the Noise handshake state machine and BLAKE2s |
| KCP reliable stream | medium/large | retransmit, windows, RTO — the biggest piece |
| smux framing | small/medium | 8-byte header, version 1/2 |

Because dnstt is open source, the whole thing is verifiable the same way our
MasterDnsVPN transport is: compile `dnstt-server` in CI, run it against a local
authoritative resolver, and drive a real HTTP request through it.

## What this does *not* solve

The dnstt **server address and public key** are the tunnel configuration. They
are not in BD NET's APK in plaintext: the app imports them from a config
("tweak") file or fetches them from its backend, and its own strings are hidden
behind a runtime deobfuscator. A client can therefore only use a config that
somebody actually provides. Anyone claiming to have "BD NET's servers" baked
into a client is either shipping that config or pretending.
