# DNS tunnel wire protocol (verified from source)

This document describes the protocol implemented by
[`masterking32/MasterDnsVPN`](https://github.com/masterking32/MasterDnsVPN) (MIT),
which this project's `core` module implements on the client side.

Everything below was derived by reading the upstream Go source at tag
`v2026.10.26.100415-5f83ee9`, file by file. Where a claim is behavioural and
not just structural, it is also covered by an automated test in
`core/src/test` or by the live integration suite (`integration/src/test`).

---

## 1. Transport shape

| Property | Value |
| --- | --- |
| Client → server | A DNS **query** of type `TXT`, whose leftmost labels carry the tunnel frame |
| Server → client | A DNS **response** with one or more `TXT` answer records carrying the tunnel frame |
| Underlying datagram | UDP/53 (any port the server listens on), EDNS0 buffer size 4096 recommended |
| Encoding (upload) | frame → encrypt → lowercase base36 → DNS labels (max 63 chars each) |
| Encoding (download) | frame → raw TXT strings, or raw-base64 when "response mode 1" was negotiated |
| Fragmentation (upload) | one frame per query; must fit the QNAME budget |
| Fragmentation (download) | multi-chunk TXT: chunk 0 carries the header + payload prefix, chunks N carry `id + data` |

**Important asymmetry (verified in `internal/dnsparser/transport.go`,
`BuildVPNResponsePacket`)**: only client → server frames are encrypted. The
server writes the *raw* frame into TXT records. The `DATA_ENCRYPTION_METHOD`
therefore protects uploads only; download payloads rely on DNS transport
integrity/obscurity, not confidentiality. This is a property of the existing
server and cannot be changed client-side.

## 2. Base36 label codec

`internal/basecodec/lowerbase36.go`

* Alphabet `0123456789abcdefghijklmnopqrstuvwxyz`.
* Input is processed in **7-byte blocks → 11 characters**.
* A trailing partial block maps `1..6` bytes to `2,4,5,7,8,10` characters
  (`lowerBase36EncodedCharsByBytes = [0,2,4,5,7,8,10,11]`).
* Decoding inverts the same table (`[0,0,1,0,2,3,0,4,5,0,6,7]`) and accepts
  uppercase input.

Because every label is `[0-9a-z]`, the payload survives case-insensitive
resolvers and cannot collide with real hostnames.

## 3. Frame format

`internal/vpnproto/parser.go`, `builder.go`

```
offset  field
0       session id        (1)
1       packet type       (1)
2..     stream id         (2)   if flag STREAM
 +2     sequence number   (2)   if flag SEQUENCE
 +2     fragment id       (1) + total fragments (1)   if flag FRAGMENT
 +1     compression type  (1)   if flag COMPRESSION
 +1     session cookie    (1)
 +1     header check byte (1)
 ..     payload
```

Header integrity byte:

```
acc = (len(header) * 17 + 0x5D) & 0xFF
for i, value in header:            # including the cookie byte
    acc = (acc + value + i) & 0xFF
    acc ^= (value << (i & 3)) & 0xFF
```

### Packet types

| Type | Name | Extensions |
| --- | --- | --- |
| 0x01 | MTU_UP_REQ | stream, seq, frag, comp |
| 0x02 | MTU_UP_RES | — |
| 0x03 | MTU_DOWN_REQ | — |
| 0x04 | MTU_DOWN_RES | stream, seq, frag, comp |
| 0x05 | SESSION_INIT | — |
| 0x06 | SESSION_ACCEPT | — |
| 0x07 / 0x08 | PING / PONG | — |
| 0x09–0x12 | STREAM_SYN .. RESEND | stream, seq (+frag/comp for DATA/RESEND) |
| 0x13 | PACKED_CONTROL_BLOCKS | comp |
| 0x14–0x19 | CLOSE_WRITE .. RST_ACK | stream, seq |
| 0x1A / 0x1B | SOCKS5_SYN / SOCKS5_SYN_ACK | stream, seq (+frag for SYN) |
| 0x1C–0x31 | SOCKS5 result / failure codes | stream, seq |
| 0x32–0x35 | DNS_QUERY_REQ/RES/…_ACK | stream, seq, frag |
| 0x36 / 0x37 | SESSION_CLOSE / SESSION_BUSY | — |
| 0xFF | ERROR_DROP | — |

The full table (including which combinations are legal) is implemented in
`core/src/main/kotlin/io/amtunnel/core/transport/Protocol.kt` and unit-tested
against the upstream lengths.

## 4. Encryption methods (`internal/security/codec.go`)

| ID | Name | Key derivation | Wire overhead |
| --- | --- | --- | --- |
| 0 | none | — | 0 |
| 1 | XOR | raw key truncated/padded to 32 bytes | 0 |
| 2 | ChaCha20 | `SHA-256(raw key)` | 16-byte nonce prefix |
| 3 | AES-128-GCM | `MD5(raw key)` | 12-byte nonce + 16-byte tag |
| 4 | AES-192-GCM | raw key padded/truncated to 24 bytes | 12 + 16 |
| 5 | AES-256-GCM | `SHA-256(raw key)` | 12 + 16 |

ChaCha20 uses a 16-byte nonce where the **first four bytes are a little-endian
block counter** and the remaining 12 bytes are the RFC-7539 nonce. The codec is
unauthenticated (no Poly1305), exactly like upstream.

## 5. DNS envelope

`internal/dnsparser/transport.go`

* Query: header `id` (random), flags `0x0100`, `QDCOUNT=1`, `ARCOUNT=1`,
  labels = base36 frame split every 63 chars, then the tunnel domain, then
  `QTYPE=TXT`, `QCLASS=IN`, then an OPT RR (`type=41`, `class=<UDP size>`,
  `ttl=0`, `RDLEN=0`).
* The QNAME text length must stay ≤ 253 bytes; the client derives the maximum
  number of encoded characters per packet from the domain length
  (`encodedQNameLen`).
* Response: every `TXT` answer is a sequence of length-prefixed character
  strings; the client concatenates them.
* Single-chunk response: the whole frame is inside one answer.
* Multi-chunk response: chunk `0` starts with `0x00`, `totalChunks`, then the
  frame (header + payload prefix); chunks `1..N` start with the chunk id.
  Missing or duplicate chunks invalidate the frame.

## 6. Session lifecycle

`internal/client/session.go`, `internal/udpserver/server_session.go`

1. **SESSION_INIT** (session id **must be 0**), 10-byte payload:

   | byte | meaning |
   | --- | --- |
   | 0 | response mode: `0` = raw TXT, `1` = base64-wrapped TXT |
   | 1 | compression pair: `(upload << 4) | download` (0 = off) |
   | 2–3 | advertised upload MTU (big endian) |
   | 4–5 | advertised download MTU |
   | 6–9 | 4-byte random verify code |

2. **SESSION_ACCEPT**, 7 or 20 bytes:

   | byte | meaning |
   | --- | --- |
   | 0 | assigned session id |
   | 1 | session cookie |
   | 2 | compression pair |
   | 3–6 | verify code echoed (must match) |
   | 7–19 | optional server policy: duplication limits, max upload/download MTU, workers, ping interval, packets per batch, ARQ window, compression minimum, initial RTO |

3. **SESSION_BUSY**: 4-byte verify code prefix, means the session table is full.
4. Every later frame carries `session id` and `session cookie`. The server drops
   frames whose `(id, cookie)` pair is unknown or mismatched.
5. **SESSION_CLOSE** (4-byte payload-free frame) frees the slot.
6. Keepalive: **PING/PONG**.

### Why resolver switching does not need a reconnect

The session record lives in the server's session table, keyed by the 8-bit
session id, and validated with the 8-bit cookie. A DNS resolver is only a
forwarder between the client and the authoritative server. Therefore, as long
as a new resolver forwards UDP/53 to the *same* server, the client may send the
same session through it - no re-handshake required. The client in this repo
exploits exactly that for failover (`MasterDnsTransport.pickEndpoint`) and the
integration suite proves it (`test3_failoverSurvivesResolverLossWithoutReconnecting`).

The flip side: a resolver cannot be used to reach a *different* server. All
resolvers in one pool must ultimately talk to the same tunnel server.

## 7. Streams (SOCKS5 mode)

`internal/client/socks_manager.go`, `internal/udpserver/*`

1. Client allocates a stream id and sends **SOCKS5_SYN** with a target payload:

   ```
   atyp (1) | address | port (2, big endian)
   atyp 1 = IPv4 (4 bytes), 3 = domain (1-byte length prefix), 4 = IPv6 (16 bytes)
   ```

2. Server connects to the target and answers **SOCKS5_CONNECTED** (echoing the
   SYN sequence number) or one of the failure codes
   (`CONNECT_FAIL`, `HOST_UNREACHABLE`, `CONNECTION_REFUSED`, …).
3. Data: **STREAM_DATA** frames with an incrementing sequence number starting at
   0, acknowledged with **STREAM_DATA_ACK** (`sequence number` echoed).
   The server also sends data downstream with its own sequence numbers.
4. Close: **STREAM_CLOSE_WRITE** → `…_ACK`; errors: **STREAM_RST**.
5. Control acknowledgements may be batched into **PACKED_CONTROL_BLOCKS**
   (7-byte records: type, stream id, sequence, fragment id, total).

## 8. What the client in this repo implements

| Area | Status |
| --- | --- |
| Base36, frame build/parse, header check | complete, unit-tested |
| AES-GCM / ChaCha20 / XOR / none codecs | complete, unit-tested (ChaCha20 vs RFC 8439 vector) |
| DNS envelope build + single/multi-chunk parsing | complete, unit-tested |
| SESSION_INIT / ACCEPT / CLOSE, verify code, policy clamp | complete |
| PING/PONG keepalive | complete |
| SOCKS5_SYN, CONNECTED/FAIL, STREAM_DATA, ACK, CLOSE, RST | complete |
| Multi-resolver failover without re-handshake | complete, integration-tested |
| Session recovery after total resolver loss | complete |
| MTU probing (MTU_UP_REQ) | not implemented — fixed/configurable MTU is used instead |
| Compression (ZSTD/LZ4/ZLIB) | not implemented — the client always negotiates OFF |
| DNS-query relay packets (0x32–0x35) | not implemented (the SOCKS5 path is used instead) |
