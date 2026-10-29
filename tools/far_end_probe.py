#!/usr/bin/env python3
"""Fingerprint whatever BD's tunnel far end is listening on.

The far end answered our SOCKS5 greeting with `05 02` and every RFC 1929 pair
we own with `01 ff`. Before spending more tunnel time on credentials, this
script works out *what* is on the other side: a real SOCKS5, an echo, an HTTP
proxy, a TLS endpoint, something else.

Each probe opens a fresh TCP connection to the local dnstt client (which
creates a fresh stream at the far end), writes one shape, and prints what
comes back inside a few seconds.

Usage: python3 tools/far_end_probe.py 7500 [--wait 8]
"""

from __future__ import annotations

import argparse
import socket
import sys
import time

USER = b"tanginaka"
PASS = b"wagditokupal"


def auth_bytes() -> bytes:
    return bytes([1, len(USER)]) + USER + bytes([len(PASS)]) + PASS


def connect_request(host: bytes, port: int, atyp: int = 3) -> bytes:
    head = bytes([5, 1, 0, atyp])
    body = (bytes([len(host)]) + host) if atyp == 3 else host
    return head + body + port.to_bytes(2, "big")


PROBES = [
    # name, bytes to send
    ("greeting: noauth only", b"\x05\x01\x00"),
    ("greeting: 3 methods", b"\x05\x03\x00\x01\x02"),
    ("greeting: userpass only", b"\x05\x01\x02"),
    ("socks4a 1.1.1.1:80", b"\x04\x01\x00\x50\x01\x01\x01\x01\x00usr\x00"),
    ("http absolute-form", b"GET http://example.com/ HTTP/1.0\r\nHost: example.com\r\n\r\n"),
    ("tls clienthello head", bytes.fromhex("160301002f0100002b0303") + b"\x11" * 32),
    ("auth only, no greeting", auth_bytes()),
    ("greeting+auth in one write", b"\x05\x02\x00\x02" + auth_bytes()),
    ("greeting+auth+connect one write",
     b"\x05\x02\x00\x02" + auth_bytes() + connect_request(b"example.com", 80)),
    ("socks5 connect 1.1.1.1:443 by ip",
     b"\x05\x01\x00" + bytes([5, 1, 0, 1, 1, 1, 1, 1]) + (443).to_bytes(2, "big")),
]


def one(port: int, payload: bytes, wait: float) -> str:
    started = time.time()
    try:
        s = socket.create_connection(("127.0.0.1", port), 5)
    except OSError as exc:
        return f"connect failed: {exc}"
    s.settimeout(wait)
    try:
        s.sendall(payload)
    except OSError as exc:
        s.close()
        return f"send failed: {exc}"

    chunks = []
    deadline = time.time() + wait
    try:
        while time.time() < deadline:
            s.settimeout(max(0.2, deadline - time.time()))
            data = s.recv(4096)
            if not data:
                chunks.append(b"<eof>")
                break
            chunks.append(data)
            if sum(len(c) for c in chunks) > 2048:
                break
    except socket.timeout:
        chunks.append(b"<timeout>")
    except OSError as exc:
        chunks.append(f"<{exc}>".encode())
    finally:
        s.close()
    elapsed = int((time.time() - started) * 1000)
    raw = b"".join(chunks)
    return f"{raw[:160]!r}  [{len(raw)} B, {elapsed} ms]"


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("port", type=int)
    ap.add_argument("--wait", type=float, default=8.0)
    args = ap.parse_args()

    print(f"far end probe on 127.0.0.1:{args.port}, {args.wait:.0f}s patience per shape")
    for name, payload in PROBES:
        print(f"  {name:36s} sent={payload[:24]!r}", flush=True)
        print(f"  {'':36s} got ={one(args.port, payload, args.wait)}", flush=True)
    return 0


if __name__ == "__main__":
    sys.exit(main())
