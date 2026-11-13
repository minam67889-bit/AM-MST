#!/usr/bin/env python3
"""Is there a live tunnel behind a local dnstt client port?

The local end of a dnstt client is a raw TCP forwarder. What answers at the far
end depends on the deployment; BD NET's runs a SOCKS5 that requires a login, so
greeting it with `05 01 00` must come back as `05 02`. Anything else means the
tunnel did not carry the bytes.

Usage: far_end_greeting.py <port> [timeout]
"""
from __future__ import annotations

import socket
import sys
import time


def main() -> None:
    port = int(sys.argv[1]) if len(sys.argv) > 1 else 7000
    timeout = float(sys.argv[2]) if len(sys.argv) > 2 else 30.0
    started = time.time()
    try:
        sock = socket.create_connection(("127.0.0.1", port), timeout=12)
        sock.settimeout(timeout)
        sock.sendall(b"\x05\x01\x00")
        got = sock.recv(8)
        sock.close()
    except Exception as exc:  # noqa: BLE001 - a failure is the measurement
        print(f"  {type(exc).__name__}: {exc} after {time.time()-started:.1f}s")
        return
    live = got[:2] == b"\x05\x02"
    print(f"  far-end greeting: {got.hex()} in {time.time()-started:.1f}s "
          f"({'LIVE' if live else 'no tunnel'})")


if __name__ == "__main__":
    main()
