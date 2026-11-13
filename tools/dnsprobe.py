#!/usr/bin/env python3
"""Minimal DNS prober: A / NS / TXT / SOA over UDP, no third-party deps.

Usage: dnsprobe.py <resolver-ip> <name>[,<name>...] [type ...]
Prints one line per (name, type) with the answers, or the rcode.
"""
from __future__ import annotations

import random
import socket
import struct
import sys

TYPES = {"A": 1, "NS": 2, "CNAME": 5, "SOA": 6, "TXT": 16, "AAAA": 28, "CAA": 257}
RCODES = {0: "NOERROR", 1: "FORMERR", 2: "SERVFAIL", 3: "NXDOMAIN", 4: "NOTIMP", 5: "REFUSED"}


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
    jumped = False
    end = offset
    for _ in range(32):
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


def query(resolver: str, name: str, rtype: str, timeout: float = 5.0) -> str:
    qid = random.randint(0, 0xFFFF)
    header = struct.pack("!HHHHHH", qid, 0x0100, 1, 0, 0, 0)
    packet = header + encode_name(name) + struct.pack("!HH", TYPES[rtype], 1)
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.settimeout(timeout)
    try:
        sock.sendto(packet, (resolver, 53))
        data, _ = sock.recvfrom(4096)
    except OSError as exc:
        return f"ERROR {type(exc).__name__}: {exc}"
    finally:
        sock.close()
    _, flags, qd, an, ns, ar = struct.unpack_from("!HHHHHH", data, 0)
    rcode = flags & 0xF
    offset = 12
    for _ in range(qd):
        offset = skip_name(data, offset) + 4
    answers: list[str] = []
    for section, count in (("AN", an), ("NS", ns)):
        for _ in range(count):
            _, end = read_name(data, offset)
            rtype_num, _, _, rdlen = struct.unpack_from("!HHIH", data, end)
            rdata_off = end + 10
            if rtype_num == 1 and rdlen == 4:
                answers.append(f"{section}:A={socket.inet_ntoa(data[rdata_off:rdata_off + 4])}")
            elif rtype_num == 2:
                answers.append(f"{section}:NS={read_name(data, rdata_off)[0]}")
            elif rtype_num == 5:
                answers.append(f"{section}:CNAME={read_name(data, rdata_off)[0]}")
            elif rtype_num == 16:
                txt = data[rdata_off + 1:rdata_off + rdlen].decode("latin-1", "replace")
                answers.append(f"{section}:TXT={txt!r}")
            elif rtype_num == 6:
                mname, off2 = read_name(data, rdata_off)
                rname, _ = read_name(data, off2)
                answers.append(f"{section}:SOA={mname}/{rname}")
            offset = rdata_off + rdlen
    return f"{RCODES.get(rcode, rcode)} {' '.join(answers) if answers else ''}".strip()


def main() -> None:
    resolver = sys.argv[1]
    names = [n for n in sys.argv[2].split(",") if n]
    rtypes = sys.argv[3:] or ["A", "NS"]
    for name in names:
        for rtype in rtypes:
            print(f"{name}\t{rtype}\t{query(resolver, name, rtype)}")


if __name__ == "__main__":
    main()
