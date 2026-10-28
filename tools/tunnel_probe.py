#!/usr/bin/env python3
"""Is there a live tunnel behind this local port?

Once a DNS-tunnel client is up it exposes a plain TCP listener.  What it
speaks on that port decides how you test it:

* `socks`  - SOCKS5 (``\\x05\\x01\\x00`` must be answered with ``\\x05\\x00``)
* `http`   - raw HTTP: send a request line and look for ``HTTP/``
* `raw`    - just show the first bytes that come back

All three are tried because the app's own client (libxdnstt) forwards raw TCP
to whatever the server side points at, while other builds expose SOCKS.

Usage::

    python3 tools/tunnel_probe.py 127.0.0.1:7000 --mode socks
    python3 tools/tunnel_probe.py 127.0.0.1:7000 --mode http --host example.com
    python3 tools/tunnel_probe.py 127.0.0.1:7000 --mode raw --payload '\\x05\\x01\\x00'
"""

from __future__ import annotations

import argparse
import socket
import sys
import time


def _recv_some(sock: socket.socket, limit: int = 4096, timeout: float = 20.0) -> bytes:
    sock.settimeout(timeout)
    buf = b""
    try:
        while len(buf) < limit:
            chunk = sock.recv(limit - len(buf))
            if not chunk:
                break
            buf += chunk
            if len(buf) >= 16:
                break
    except socket.timeout:
        pass
    return buf


def probe_socks(addr: tuple[str, int], timeout: float) -> tuple[bool, str]:
    with socket.create_connection(addr, timeout=timeout) as sock:
        sock.sendall(b"\x05\x01\x00")
        reply = _recv_some(sock, 2, timeout)
        if len(reply) < 2 or reply[0] != 0x05:
            return False, f"no SOCKS5 greeting ({reply.hex() or 'silence'})"
        if reply[1] != 0x00:
            return False, f"SOCKS5 wants auth method {reply[1]:#x}"
        # Ask for a CONNECT to a well-known host:port; any reply means the
        # tunnel carried it to the far side.
        host = b"example.com"
        req = b"\x05\x01\x00\x03" + bytes([len(host)]) + host + (443).to_bytes(2, "big")
        sock.sendall(req)
        ans = _recv_some(sock, 32, timeout)
        if len(ans) >= 2 and ans[0] == 0x05:
            codes = {0: "succeeded", 1: "general failure", 2: "not allowed",
                     3: "network unreachable", 4: "host unreachable",
                     5: "connection refused", 6: "TTL expired",
                     7: "command not supported", 8: "address type not supported"}
            return True, f"SOCKS5 CONNECT reply {codes.get(ans[1], ans[1])} ({ans.hex()})"
        return True, f"SOCKS5 greeting ok, no CONNECT reply ({ans.hex() or 'silence'})"


def probe_http(addr: tuple[str, int], host: str, timeout: float) -> tuple[bool, str]:
    req = (f"GET / HTTP/1.1\r\nHost: {host}\r\nUser-Agent: tunnel-probe\r\n"
           "Accept: */*\r\nConnection: close\r\n\r\n").encode()
    with socket.create_connection(addr, timeout=timeout) as sock:
        sock.sendall(req)
        data = _recv_some(sock, 2048, timeout)
    if not data:
        return False, "no response"
    head = data.split(b"\r\n", 1)[0][:80]
    return head.upper().startswith(b"HTTP/"), f"{len(data)} B: {data[:120]!r}"


def probe_raw(addr: tuple[str, int], payload: bytes, timeout: float) -> tuple[bool, str]:
    with socket.create_connection(addr, timeout=timeout) as sock:
        sock.sendall(payload)
        data = _recv_some(sock, 1024, timeout)
    return bool(data), f"{len(data)} B: {data[:120].hex()}"


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    ap.add_argument("target", help="host:port of the local tunnel listener")
    ap.add_argument("--mode", choices=("socks", "http", "raw"), default="http")
    ap.add_argument("--host", default="example.com", help="Host header / SNI for http mode")
    ap.add_argument("--payload", default="\\x05\\x01\\x00", help="hex or C-escaped bytes for raw")
    ap.add_argument("--timeout", type=float, default=45.0)
    ap.add_argument("--wait", type=float, default=0.0,
                    help="seconds to wait for the listener to appear")
    args = ap.parse_args(argv)

    host, _, port = args.target.rpartition(":")
    addr = (host or "127.0.0.1", int(port))

    deadline = time.time() + args.wait
    while True:
        try:
            with socket.create_connection(addr, timeout=2):
                break
        except OSError as exc:
            if time.time() >= deadline:
                print(f"PROBE FAIL: nothing listening on {addr[0]}:{addr[1]} ({exc})")
                return 1
            time.sleep(2)

    started = time.time()
    try:
        if args.mode == "socks":
            ok, detail = probe_socks(addr, args.timeout)
        elif args.mode == "http":
            ok, detail = probe_http(addr, args.host, args.timeout)
        else:
            payload = args.payload.encode().decode("unicode_escape").encode("latin-1")
            ok, detail = probe_raw(addr, payload, args.timeout)
    except OSError as exc:
        ok, detail = False, f"{type(exc).__name__}: {exc}"

    elapsed = time.time() - started
    print(f"{args.mode.upper()} probe -> {'PASS' if ok else 'FAIL'} in {elapsed:.1f}s: {detail}")
    return 0 if ok else 1


if __name__ == "__main__":
    sys.exit(main())
