#!/usr/bin/env python3
"""Ask each SuperDNS endpoint what it speaks on the common TLS ports.

`libsuperdns.so` links crypto/tls, http2, QUIC and uTLS and takes `-utls
Chrome|Firefox` plus `-pubkey prince`, so the tunnel is very likely TLS-based
with the DNS resolver only used for bootstrap. A plain ClientHello with the
tunnel name as SNI is enough to see whether a TLS listener exists (it will fail
the handshake without the PSK, but it answers).

Usage: tls_probe.py <host> [host...] [--ports 443,8443,2053]
"""
from __future__ import annotations

import json
import pathlib
import socket
import ssl
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
from dnsprobe import query  # noqa: E402

PORTS = [443, 8443, 2053, 2096, 8080, 80]


def tls(ip: str, host: str, port: int, timeout: float = 6.0) -> str:
    ctx = ssl.create_default_context()
    ctx.check_hostname = False
    ctx.verify_mode = ssl.CERT_NONE
    ctx.set_alpn_protocols(["h2", "http/1.1"])
    try:
        with socket.create_connection((ip, port), timeout=timeout) as raw:
            with ctx.wrap_socket(raw, server_hostname=host) as tls_sock:
                cert = tls_sock.getpeercert() or {}
                sub = dict(x[0] for x in cert.get("subject", ()) if x)
                issuer = dict(x[0] for x in cert.get("issuer", ()) if x)
                return (f"TLS OK {tls_sock.version()} alpn={tls_sock.selected_alpn_protocol()} "
                        f"subject={sub.get('commonName')} issuer={issuer.get('organizationName')}")
    except ssl.SSLError as exc:
        return f"TLS alert: {exc.reason or exc}"
    except socket.timeout:
        return "timeout"
    except OSError as exc:
        return f"{type(exc).__name__}: {exc.strerror or exc}"


def banner(ip: str, port: int, timeout: float = 5.0) -> str:
    try:
        with socket.create_connection((ip, port), timeout=timeout) as sock:
            sock.settimeout(timeout)
            try:
                data = sock.recv(64)
            except socket.timeout:
                return "open, no banner"
            return f"open, first bytes {data[:32]!r}"
    except socket.timeout:
        return "timeout"
    except OSError as exc:
        return f"{type(exc).__name__}: {exc.strerror or exc}"


def main() -> None:
    args = [a for a in sys.argv[1:] if not a.startswith("--")]
    if "--ports" in sys.argv:
        global PORTS
        PORTS = [int(p) for p in sys.argv[sys.argv.index("--ports") + 1].split(",")]
        args = [a for a in args if not a.replace(",", "").isdigit()]
    lines: list[str] = []
    for host in args:
        answer = query("8.8.8.8", host, "A")
        ip = answer.split("AN:A=")[1].split()[0] if "AN:A=" in answer else None
        lines.append(f"=== {host} -> {ip}")
        if not ip:
            lines.append("")
            continue
        for port in PORTS:
            result = tls(ip, host, port) if port != 80 else banner(ip, port)
            lines.append(f"  :{port:<5} {result}")
        lines.append("")
    print("\n".join(lines) + "\n")


if __name__ == "__main__":
    main()
