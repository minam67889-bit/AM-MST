#!/usr/bin/env python3
"""Logging UDP DNS proxy: client -> 127.0.0.1:<port> -> <upstream>:53.

Counts how many queries a tunnel client emits and how many replies come back,
which is the difference between "the resolver path works but the handshake
fails" and "nothing is reachable at all".

Usage: dns_proxy.py <listen-port> <seconds> [upstream] [outfile]
"""
from __future__ import annotations

import socket
import sys
import time


def main() -> None:
    port = int(sys.argv[1]) if len(sys.argv) > 1 else 5300
    seconds = float(sys.argv[2]) if len(sys.argv) > 2 else 20.0
    upstream = (sys.argv[3] if len(sys.argv) > 3 else "8.8.8.8", 53)
    out = sys.argv[4] if len(sys.argv) > 4 else ""
    srv = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    srv.bind(("127.0.0.1", port))
    srv.settimeout(2.0)
    up = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    up.settimeout(3.0)
    sent = replied = 0
    qsizes: set[int] = set()
    rsizes: set[int] = set()
    started = time.time()
    while time.time() - started < seconds:
        try:
            data, client = srv.recvfrom(4096)
        except socket.timeout:
            continue
        sent += 1
        qsizes.add(len(data))
        try:
            up.sendto(data, upstream)
            answer, _ = up.recvfrom(4096)
            replied += 1
            rsizes.add(len(answer))
            srv.sendto(answer, client)
        except socket.timeout:
            pass
    line = (f"queries={sent} replies={replied} "
            f"q_sizes={sorted(qsizes)[:6]} r_sizes={sorted(rsizes)[:6]}")
    print(line, flush=True)
    if out:
        with open(out, "a", encoding="utf-8") as fh:
            fh.write(line + "\n")


if __name__ == "__main__":
    main()
