#!/usr/bin/env python3
"""Minimal SOCKS5/TLS prober used against a dnstt-client local listener.

One line per target: target, outcome, bytes, first bytes. Deliberately dumb:
no third-party libraries, hard timeouts, so a hang is itself a measurement.
"""
from __future__ import annotations

import socket
import ssl
import struct
import sys
import time

SOCKS = ("127.0.0.1", 2222)
TIMEOUT = 30


def socks5_connect(host: str, port: int) -> socket.socket:
    s = socket.create_connection(SOCKS, timeout=TIMEOUT)
    s.settimeout(TIMEOUT)
    s.sendall(b"\x05\x01\x00")
    if s.recv(2) != b"\x05\x00":
        raise RuntimeError("socks greeting rejected")
    name = host.encode()
    s.sendall(b"\x05\x01\x00\x03" + bytes([len(name)]) + name + struct.pack(">H", port))
    reply = s.recv(10)
    if len(reply) < 2 or reply[1] != 0:
        raise RuntimeError(f"socks connect refused repr={reply!r}")
    return s


def probe(host: str, port: int, mode: str) -> None:
    label = f"{host}:{port} {mode}"
    started = time.time()
    try:
        s = socks5_connect(host, port)
    except Exception as exc:  # noqa: BLE001 - failure is the measurement
        print(f"  {label}: CONNECT-FAIL after {time.time()-started:.1f}s "
              f"{type(exc).__name__}: {exc}", flush=True)
        return
    got = b""
    try:
        if mode == "http":
            s.sendall(b"GET / HTTP/1.0\r\nHost: example.com\r\n\r\n")
            got = s.recv(96)
        elif mode == "tls":
            ctx = ssl.create_default_context()
            ctx.check_hostname = False
            ctx.verify_mode = ssl.CERT_NONE
            tls = ctx.wrap_socket(s, server_hostname=host if not host[0].isdigit() else None)
            got = tls.version().encode() + b" " + str(tls.cipher()[0]).encode()
            tls.close()
        else:                                    # banner
            got = s.recv(96)
    except Exception as exc:  # noqa: BLE001
        print(f"  {label}: DATA-FAIL after {time.time()-started:.1f}s "
              f"{type(exc).__name__}: {exc}", flush=True)
        return
    finally:
        try:
            s.close()
        except OSError:
            pass
    shown = got[:60].decode("latin-1").replace("\r", "\\r").replace("\n", "\\n")
    print(f"  {label}: OK {len(got)}B in {time.time()-started:.1f}s -> {shown}", flush=True)


if __name__ == "__main__":
    host = sys.argv[1] if len(sys.argv) > 1 else "127.0.0.1"
    probe("example.com", 80, "http")
    probe("api.telegram.org", 443, "tls")
    probe(host, 22, "banner")
    probe("1.1.1.1", 443, "tls")
