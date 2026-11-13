#!/usr/bin/env python3
"""Fetch a page through a SOCKS5 that requires username/password.

This is the real end-to-end check for a dnstt tunnel: the local port is a raw
forwarder, the far end speaks SOCKS5 (RFC 1928 + RFC 1929), and only after a
successful CONNECT does a web server see our request.

Usage: socks5_page.py <port> <user> <pass> <host> <url-path> [https]
"""
from __future__ import annotations

import socket
import ssl
import struct
import sys
import time


def socks5(port: int, user: str, password: str, host: str, dport: int) -> socket.socket:
    sock = socket.create_connection(("127.0.0.1", port), timeout=15)
    sock.settimeout(40)
    sock.sendall(b"\x05\x02\x00\x02")
    hello = sock.recv(2)
    if hello != b"\x05\x02":
        raise RuntimeError(f"far end refused user/pass: {hello.hex()}")
    ub, pb = user.encode(), password.encode()
    sock.sendall(bytes([1, len(ub)]) + ub + bytes([len(pb)]) + pb)
    auth = sock.recv(2)
    if auth != b"\x01\x00":
        raise RuntimeError(f"auth rejected: {auth.hex()}")
    name = host.encode()
    sock.sendall(b"\x05\x01\x00\x03" + bytes([len(name)]) + name + struct.pack(">H", dport))
    reply = sock.recv(10)
    if len(reply) < 2 or reply[1] != 0:
        raise RuntimeError(f"connect refused: {reply.hex()}")
    return sock


def main() -> None:
    port, user, password, host, path = (sys.argv[1], sys.argv[2], sys.argv[3],
                                        sys.argv[4], sys.argv[5])
    tls = len(sys.argv) > 6 and sys.argv[6] == "https"
    dport = 443 if tls else 80
    started = time.time()
    try:
        sock = socks5(int(port), user, password, host, dport)
    except Exception as exc:  # noqa: BLE001
        print(f"  {host}: FAILED {type(exc).__name__}: {exc}")
        return
    try:
        if tls:
            ctx = ssl.create_default_context()
            sock = ctx.wrap_socket(sock, server_hostname=host)
        sock.sendall(f"GET {path} HTTP/1.0\r\nHost: {host}\r\n"
                     f"User-Agent: amtunnel-test\r\n\r\n".encode())
        data = b""
        while len(data) < 4096:
            chunk = sock.recv(4096)
            if not chunk:
                break
            data += chunk
            if b"\r\n\r\n" in data and len(data) > 200:
                break
    except Exception as exc:  # noqa: BLE001
        print(f"  {host}: FAILED after {time.time()-started:.1f}s "
              f"{type(exc).__name__}: {exc}")
        return
    finally:
        sock.close()
    status = data.split(b"\r\n", 1)[0].decode("latin-1") or "(empty)"
    print(f"  {host}{path}: {len(data)} B in {time.time()-started:.1f}s -> {status}")


if __name__ == "__main__":
    main()
