#!/usr/bin/env python3
"""Probe the local end of a stock dnstt client.

Important: dnstt-client's local listener is a **raw TCP forwarder**, not a SOCKS
proxy -- it opens one smux stream per accepted socket and pipes bytes. Any
SOCKS5 handshake sent there is simply forwarded to whatever the far end dials
(Ultra's servers forward to their own sshd), so the connection just hangs.

What a live server therefore looks like:
  * far end = sshd      -> "SSH-2.0-..." arrives without sending anything
  * far end = httpd     -> send a GET and read the response

Usage: probe_tcp.py <label> [port]
"""
from __future__ import annotations

import socket
import sys
import time

PORT = int(sys.argv[2]) if len(sys.argv) > 2 else 2222
GET = b"GET / HTTP/1.0\r\nHost: example.com\r\nUser-Agent: amtunnel-probe\r\n\r\n"


def main(label: str) -> None:
    started = time.time()
    try:
        s = socket.create_connection(("127.0.0.1", PORT), timeout=15)
    except Exception as exc:  # noqa: BLE001
        print(f"  {label}: LISTEN-FAIL {type(exc).__name__}: {exc}", flush=True)
        return
    s.settimeout(2)
    try:
        banner = s.recv(200)
    except socket.timeout:
        banner = b""
    except Exception as exc:  # noqa: BLE001
        banner = b""
        print(f"  {label}: banner error {type(exc).__name__}", flush=True)
    if banner:
        shown = banner[:80].decode("latin-1").replace("\r", "\\r").replace("\n", "\\n")
        print(f"  {label}: BANNER {len(banner)}B in {time.time()-started:.1f}s -> {shown}",
              flush=True)
        s.close()
        return
    s.settimeout(25)
    try:
        s.sendall(GET)
        data = s.recv(300)
    except Exception as exc:  # noqa: BLE001
        print(f"  {label}: NO-DATA after {time.time()-started:.1f}s "
              f"{type(exc).__name__}: {exc}", flush=True)
        s.close()
        return
    s.close()
    if not data:
        print(f"  {label}: EMPTY after {time.time()-started:.1f}s (stream closed)", flush=True)
        return
    shown = data[:100].decode("latin-1").replace("\r", "\\r").replace("\n", "\\n")
    print(f"  {label}: HTTP {len(data)}B in {time.time()-started:.1f}s -> {shown}", flush=True)


if __name__ == "__main__":
    main(sys.argv[1] if len(sys.argv) > 1 else "probe")
