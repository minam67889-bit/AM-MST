#!/usr/bin/env python3
"""Drive dnstt-client and prove whether a tunnel actually carries traffic.

Steps: spawn the client, wait for its SOCKS5 listener, do a real SOCKS5 CONNECT
and an HTTP(S) GET through it, then report the page that came back. This is the
"open Instagram through the tunnel" test.

Usage:
  dnstt_e2e.py --client tools/bin/dnstt-client-linux-amd64 \
               --pubkey <64hex> --domain t.example.com --resolver 127.0.0.1:5353 \
               [--url https://www.instagram.com/] [--seconds 25]
"""
from __future__ import annotations

import argparse
import json
import pathlib
import socket
import ssl
import struct
import subprocess
import sys
import tempfile
import time


def wait_port(port: int, seconds: float) -> bool:
    deadline = time.time() + seconds
    while time.time() < deadline:
        try:
            with socket.create_connection(("127.0.0.1", port), timeout=1):
                return True
        except OSError:
            time.sleep(0.4)
    return False


def socks5_connect(port: int, host: str, dest_port: int = 80, timeout: float = 20.0) -> socket.socket:
    """SOCKS5 CONNECT through the tunnel.

    dnstt-client answers the greeting only after the tunnel stream is open, and
    the stream is opened when the CONNECT arrives, so greeting and request go out
    together and the replies are read as they come.
    """
    sock = socket.create_connection(("127.0.0.1", port), timeout=timeout)
    sock.settimeout(timeout)
    name = host.encode()
    request = (b"\x05\x01\x00"
               + b"\x05\x01\x00\x03" + bytes([len(name)]) + name
               + struct.pack("!H", dest_port))
    sock.sendall(request)
    buf = b""
    deadline = time.time() + timeout
    while time.time() < deadline:
        if b"\x05\x00\x00" in buf:
            break
        try:
            chunk = sock.recv(64)
        except socket.timeout:
            break
        if not chunk:
            break
        buf += chunk
    if b"\x05\x00\x00" not in buf:
        sock.close()
        raise OSError(f"SOCKS5 CONNECT not acknowledged (got {buf[:16]!r})")
    return sock


def fetch(port: int, url: str, timeout: float = 25.0) -> dict:
    scheme, _, rest = url.partition("://")
    host, _, path = rest.partition("/")
    hostname, _, port_str = host.partition(":")
    dest_port = int(port_str or (443 if scheme == "https" else 80))
    path = "/" + path
    started = time.time()
    try:
        sock = socks5_connect(port, hostname, dest_port, timeout)
    except OSError as exc:
        return {"ok": False, "stage": "socks", "error": str(exc), "seconds": round(time.time() - started, 1)}
    try:
        if scheme == "https":
            ctx = ssl.create_default_context()
            sock = ctx.wrap_socket(sock, server_hostname=hostname)
        request = (f"GET {path} HTTP/1.1\r\nHost: {hostname}\r\n"
                   "User-Agent: Mozilla/5.0 (Linux; Android 13) AppleWebKit/537.36 "
                   "(KHTML, like Gecko) Chrome/120 Mobile Safari/537.36\r\n"
                   "Accept: text/html,*/*\r\nConnection: close\r\n\r\n")
        sock.sendall(request.encode())
        chunks = []
        total = 0
        while total < 65536:
            data = sock.recv(8192)
            if not data:
                break
            chunks.append(data)
            total += len(data)
        blob = b"".join(chunks)
    except (OSError, ssl.SSLError) as exc:
        return {"ok": False, "stage": "http", "error": f"{type(exc).__name__}: {exc}",
                "seconds": round(time.time() - started, 1)}
    finally:
        sock.close()
    head = blob.split(b"\r\n\r\n", 1)[0].decode("latin-1", "replace")
    status = head.split("\r\n")[0] if head else ""
    body = blob.split(b"\r\n\r\n", 1)[1] if b"\r\n\r\n" in blob else b""
    title = ""
    if b"<title" in body.lower():
        chunk = body.lower().split(b"<title", 1)[1]
        title = chunk.split(b">", 1)[1].split(b"</title", 1)[0].decode("utf-8", "replace")[:120]
    return {
        "ok": bool(status.startswith("HTTP/")),
        "stage": "done",
        "status": status,
        "bytes": len(blob),
        "title": title,
        "first_line": body[:100].decode("utf-8", "replace").strip(),
        "seconds": round(time.time() - started, 1),
    }


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--client", required=True)
    ap.add_argument("--pubkey", required=True)
    ap.add_argument("--domain", required=True)
    ap.add_argument("--resolver", required=True, help="ip[:port] the client sends DNS to")
    ap.add_argument("--url", action="append", default=None)
    ap.add_argument("--seconds", type=float, default=25.0)
    ap.add_argument("--local-port", type=int, default=0)
    ap.add_argument("--json-out")
    args = ap.parse_args()

    urls = args.url or ["https://www.instagram.com/", "http://example.com/"]
    port = args.local_port or (20000 + (abs(hash((args.pubkey, args.domain))) % 20000))
    local = f"127.0.0.1:{port}"
    argv = [args.client, "-udp", args.resolver, "-pubkey", args.pubkey, args.domain, local]
    log = tempfile.TemporaryFile()
    started = time.time()
    proc = subprocess.Popen(argv, stdout=log, stderr=subprocess.STDOUT)
    result: dict = {
        "pubkey": args.pubkey, "domain": args.domain, "resolver": args.resolver,
        "argv": argv[1:], "socks_listening": False, "tunnel_up_seconds": None, "fetches": [],
    }
    try:
        result["socks_listening"] = wait_port(port, args.seconds)
        if result["socks_listening"]:
            result["tunnel_up_seconds"] = round(time.time() - started, 1)
            for url in urls:
                result["fetches"].append({"url": url, **fetch(port, url)})
    finally:
        proc.terminate()
        try:
            proc.wait(timeout=5)
        except subprocess.TimeoutExpired:
            proc.kill()
        log.seek(0)
        result["client_log"] = log.read().decode("utf-8", "replace")[-2000:]

    print(json.dumps(result, indent=2, ensure_ascii=False))
    if args.json_out:
        pathlib.Path(args.json_out).write_text(json.dumps(result, indent=2, ensure_ascii=False), encoding="utf-8")


if __name__ == "__main__":
    sys.exit(main())
