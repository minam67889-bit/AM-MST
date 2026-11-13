#!/usr/bin/env python3
"""Tiny no-auth SOCKS5 server, used as the far end of a local dnstt-server.

dnstt-server forwards each tunnel stream to a SOCKS5 upstream. For the positive
control we need one that can actually reach the internet, so this is it.

Usage: socks5_server.py <port> [seconds]
"""
from __future__ import annotations

import selectors
import socket
import struct
import sys
import threading
import time


def pipe(src: socket.socket, dst: socket.socket) -> None:
    try:
        while True:
            data = src.recv(8192)
            if not data:
                break
            dst.sendall(data)
    except OSError:
        pass
    finally:
        for sock in (src, dst):
            try:
                sock.shutdown(socket.SHUT_RDWR)
            except OSError:
                pass


def handle(client: socket.socket) -> None:
    try:
        client.settimeout(20)
        head = client.recv(2)
        if len(head) < 2 or head[0] != 5:
            return
        methods = client.recv(head[1])
        client.sendall(b"\x05\x00")
        request = client.recv(4)
        if len(request) < 4:
            return
        atyp = request[3]
        if atyp == 1:
            host = socket.inet_ntoa(client.recv(4))
        elif atyp == 3:
            host = client.recv(client.recv(1)[0]).decode()
        else:
            host = socket.inet_ntop(socket.AF_INET6, client.recv(16))
        port = struct.unpack("!H", client.recv(2))[0]
        try:
            upstream = socket.create_connection((host, port), timeout=15)
        except OSError:
            client.sendall(b"\x05\x01\x00\x01\x00\x00\x00\x00\x00\x00")
            return
        client.sendall(b"\x05\x00\x00\x01" + socket.inet_aton("0.0.0.0") + b"\x00\x00")
        client.settimeout(None)
        upstream.settimeout(None)
        threading.Thread(target=pipe, args=(upstream, client), daemon=True).start()
        pipe(client, upstream)
    except OSError:
        pass
    finally:
        try:
            client.close()
        except OSError:
            pass


def main() -> None:
    port = int(sys.argv[1]) if len(sys.argv) > 1 else 1080
    seconds = float(sys.argv[2]) if len(sys.argv) > 2 else 300
    server = socket.socket()
    server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    server.bind(("127.0.0.1", port))
    server.listen(64)
    server.settimeout(1.0)
    deadline = time.time() + seconds
    print(f"socks5 on 127.0.0.1:{port} for {seconds:.0f}s", flush=True)
    while time.time() < deadline:
        try:
            client, _ = server.accept()
        except socket.timeout:
            continue
        threading.Thread(target=handle, args=(client,), daemon=True).start()


if __name__ == "__main__":
    main()
