#!/usr/bin/env python3
"""Print the TCP payloads out of a pcap, one line each.

Written for the BD NET capture job: the app speaks plain SOCKS5 to its own
loopback port before the bytes enter the tunnel, so the RFC 1929 username and
password are sitting in the capture in the clear.

Usage: python3 tools/pcap_auth.py <file.pcap> [--only-port 7000]
"""

from __future__ import annotations

import argparse
import struct
import sys


def ip_str(raw: bytes) -> str:
    if len(raw) == 4:
        return ".".join(str(b) for b in raw)
    return ":".join(f"{raw[i] << 8 | raw[i + 1]:x}" for i in range(0, 16, 2))


def walk(data: bytes):
    if len(data) < 24:
        return
    magic = data[:4]
    little = magic in (b"\xd4\xc3\xb2\xa1", b"\x4d\x3c\xb2\xa1")
    end = "<" if little else ">"
    linktype = struct.unpack_from(end + "I", data, 20)[0]
    off = 24
    while off + 16 <= len(data):
        _ts, _us, incl, _orig = struct.unpack_from(end + "IIII", data, off)
        off += 16
        pkt = data[off:off + incl]
        off += incl
        if linktype == 113:          # linux cooked
            ethertype = pkt[14:16]
            ip = pkt[16:]
        elif linktype == 1:          # ethernet
            ethertype = pkt[12:14]
            ip = pkt[14:]
        else:
            continue
        if ethertype == b"\x08\x00":
            yield ("ipv4", ip)
        elif ethertype == b"\x86\xdd":
            yield ("ipv6", ip)


def payloads(data: bytes):
    for kind, ip in walk(data):
        if not ip:
            continue
        if kind == "ipv4":
            ihl = (ip[0] & 0x0F) * 4
            if ip[9] != 6:
                continue
            src, dst = ip_str(ip[12:16]), ip_str(ip[16:20])
            l4 = ip[ihl:]
        else:
            if len(ip) < 40 or ip[6] != 6:
                continue
            src, dst = ip_str(ip[8:24]), ip_str(ip[24:40])
            l4 = ip[40:]
        if len(l4) < 20:
            continue
        sport, dport = struct.unpack_from(">HH", l4, 0)
        doff = (l4[12] >> 4) * 4
        body = l4[doff:]
        if body:
            yield src, sport, dst, dport, body


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("pcap")
    ap.add_argument("--only-port", type=int, default=0)
    args = ap.parse_args()

    try:
        data = open(args.pcap, "rb").read()
    except OSError as exc:
        print(f"cannot read {args.pcap}: {exc}")
        return 1

    print(f"pcap bytes: {len(data)}")
    seen = 0
    for src, sport, dst, dport, body in payloads(data):
        if args.only_port and args.only_port not in (sport, dport):
            continue
        seen += 1
        if seen <= 400:
            print(f"{src}:{sport} -> {dst}:{dport}  {body[:220]!r}")
    print(f"tcp payload segments: {seen}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
