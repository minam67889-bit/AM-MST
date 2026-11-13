#!/usr/bin/env python3
"""Probe the SuperDNS endpoints at the DNS/IP layer (what we can do off-Android).

The app's own `libsuperdns.so` is an Android aarch64 executable (interpreter
`/system/bin/linker64`), so it cannot be replayed on a Linux runner. What can be
checked instead:

  * does the host resolve (A record)?
  * does that IP answer DNS on :53 at all (UDP and TCP)?
  * does it answer for the tunnel domain itself, and for `sl` + domain, which is
    the name SuperService feeds the binary?
  * what does it say for a random label under the domain (a tunnel server that
    is up usually answers even though the parent zone has no delegation)?

Usage: superdns_probe.py <host> [host...] [--resolver 8.8.8.8] [--seconds 5]
"""
from __future__ import annotations

import pathlib
import random
import socket
import string
import struct
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
from dnsprobe import RCODES, encode_name, query  # noqa: E402


def tcp_dns(ip: str, name: str, timeout: float = 5.0) -> str:
    packet = struct.pack("!HHHHHH", random.randint(0, 0xFFFF), 0x0100, 1, 0, 0, 0)
    packet += encode_name(name) + struct.pack("!HH", 1, 1)
    try:
        with socket.create_connection((ip, 53), timeout=timeout) as sock:
            sock.sendall(struct.pack("!H", len(packet)) + packet)
            head = sock.recv(2)
            if len(head) < 2:
                return "TCP closed after handshake"
            length = struct.unpack("!H", head)[0]
            data = sock.recv(length)
    except OSError as exc:
        return f"TCP {type(exc).__name__}: {exc}"
    if len(data) < 12:
        return "TCP short answer"
    flags = struct.unpack_from("!H", data, 2)[0]
    return f"TCP {RCODES.get(flags & 0xF, flags & 0xF)} ({len(data)}B)"


def udp_latency(ip: str, name: str, rtype: str = "A", timeout: float = 5.0) -> str:
    packet = struct.pack("!HHHHHH", random.randint(0, 0xFFFF), 0x0100, 1, 0, 0, 0)
    packet += encode_name(name) + struct.pack("!HH", 1 if rtype == "A" else 16, 1)
    sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    sock.settimeout(timeout)
    try:
        sock.sendto(packet, (ip, 53))
        data, _ = sock.recvfrom(4096)
    except OSError as exc:
        return f"no answer ({type(exc).__name__})"
    finally:
        sock.close()
    flags = struct.unpack_from("!H", data, 2)[0]
    return f"UDP {RCODES.get(flags & 0xF, flags & 0xF)} ({len(data)}B)"


def label() -> str:
    return "".join(random.choice(string.ascii_lowercase) for _ in range(8))


def main() -> None:
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    resolver = "8.8.8.8"
    if "--resolver" in sys.argv:
        resolver = sys.argv[sys.argv.index("--resolver") + 1]
        args = [a for a in args if a != resolver]
    lines: list[str] = []
    for host in args:
        ip = None
        answer = query(resolver, host, "A")
        if "AN:A=" in answer:
            ip = answer.split("AN:A=")[1].split()[0]
        lines.append(f"=== {host}  A={ip or 'none'}  ({answer})")
        if not ip:
            lines.append("")
            continue
        for name, note in ((host, "the domain itself"),
                           (f"sl{host}", "SuperService builds 'sl' + host"),
                           (f"{label()}.{host}", "random tunnel label")):
            lines.append(f"  @{ip} {name:<34} {udp_latency(ip, name)}  <- {note}")
        lines.append(f"  @{ip} TCP 53 {tcp_dns(ip, host)}")
        lines.append("")
    blob = "\n".join(lines) + "\n"
    out = pathlib.Path(sys.argv[0]).parent
    print(blob)


if __name__ == "__main__":
    main()
