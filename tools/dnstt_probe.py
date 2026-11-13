#!/usr/bin/env python3
"""Send dnstt-shaped DNS queries and report what comes back.

A dnstt client sends queries whose qname is base32 payload + "." + the tunnel
domain, and the server answers with TXT records (and, for a live server, a
NOERROR that a normal authoritative server would never give for a random label).

This tool is deliberately protocol-agnostic: it only measures the *shape* of the
answer, so it can be calibrated against a dnstt server we run ourselves and then
pointed at a third-party server to see whether it behaves the same way.

Usage:
  dnstt_probe.py --server 1.2.3.4[:53] --domain t.example.com [--domain ...]
  dnstt_probe.py --server 127.0.0.1:5353 --domain t.test --label 40
"""
from __future__ import annotations

import argparse
import base64
import random
import socket
import struct
import sys


def encode_name(name: str) -> bytes:
    out = b""
    for label in name.strip(".").split("."):
        out += bytes([len(label)]) + label.encode()
    return out + b"\x00"


def skip_name(data: bytes, offset: int) -> int:
    while True:
        length = data[offset]
        if length == 0:
            return offset + 1
        if length & 0xC0 == 0xC0:
            return offset + 2
        offset += 1 + length


def read_name(data: bytes, offset: int) -> tuple[str, int]:
    parts: list[str] = []
    end = offset
    jumped = False
    for _ in range(40):
        length = data[offset]
        if length == 0:
            offset += 1
            if not jumped:
                end = offset
            break
        if length & 0xC0 == 0xC0:
            pointer = struct.unpack_from("!H", data, offset)[0] & 0x3FFF
            if not jumped:
                end = offset + 2
            offset = pointer
            jumped = True
            continue
        parts.append(data[offset + 1:offset + 1 + length].decode("latin-1"))
        offset += 1 + length
        if not jumped:
            end = offset
    return ".".join(parts), end


def ask(server: str, name: str, qtype: int = 16, timeout: float = 6.0) -> dict:
    host, _, port = server.partition(":")
    port = int(port or 53)
    qid = random.randint(0, 0xFFFF)
    packet = struct.pack("!HHHHHH", qid, 0x0100, 1, 0, 0, 0) + encode_name(name) + struct.pack("!HH", qtype, 1)
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.settimeout(timeout)
    try:
        sock.sendto(packet, (host, port))
        data, _ = sock.recvfrom(4096)
    except OSError as exc:
        return {"error": f"{type(exc).__name__}: {exc}"}
    finally:
        sock.close()
    _, flags, qd, an, ns, ar = struct.unpack_from("!HHHHHH", data, 0)
    offset = 12
    for _ in range(qd):
        offset = skip_name(data, offset) + 4
    records = []
    for _ in range(an + ns + ar):
        _, end = read_name(data, offset)
        rtype, rclass, ttl, rdlen = struct.unpack_from("!HHIH", data, end)
        rdata_off = end + 10
        if rtype == 16:
            chunks = []
            cursor = rdata_off
            stop = rdata_off + rdlen
            while cursor < stop:
                length = data[cursor]
                chunks.append(data[cursor + 1:cursor + 1 + length])
                cursor += 1 + length
            value = b"".join(chunks)
            records.append(f"TXT({len(value)}B {value[:12].hex()})")
        elif rtype in (2, 5):
            records.append(f"{'NS' if rtype == 2 else 'CNAME'}={read_name(data, rdata_off)[0]}")
        elif rtype == 1 and rdlen == 4:
            records.append("A=" + socket.inet_ntoa(data[rdata_off:rdata_off + 4]))
        elif rtype == 6:
            records.append("SOA")
        else:
            records.append(f"type{rtype}({rdlen}B)")
        offset = rdata_off + rdlen
    return {
        "rcode": flags & 0xF,
        "tc": (flags >> 9) & 1,
        "an": an,
        "size": len(data),
        "answers": records,
    }


def b32_payload(nbytes: int = 24) -> str:
    raw = bytes(random.getrandbits(8) for _ in range(nbytes))
    return base64.b32encode(raw).decode().rstrip("=").lower()


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--server", action="append", required=True, help="ip[:port]")
    ap.add_argument("--domain", action="append", required=True)
    ap.add_argument("--label-bytes", type=int, default=24)
    ap.add_argument("--queries", type=int, default=3)
    args = ap.parse_args()

    for server in args.server:
        for domain in args.domain:
            print(f"=== server={server} domain={domain}")
            for attempt in range(args.queries):
                name = f"{b32_payload(args.label_bytes)}.{domain}"
                result = ask(server, name, 16)
                print(f"  q{attempt} TXT {name[:44]}… -> {result}")
            for shape, name, qtype in (
                ("apex TXT", domain, 16),
                ("b32 A", f"{b32_payload(8)}.{domain}", 1),
            ):
                result = ask(server, name, qtype)
                print(f"  {shape:<8} {name[:40]} -> {result}")
            print()


if __name__ == "__main__":
    sys.exit(main())
