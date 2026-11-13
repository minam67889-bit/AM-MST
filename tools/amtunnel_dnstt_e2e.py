#!/usr/bin/env python3
"""Test AM TUNNEL's own SuperDNS endpoints as dnstt tunnels, and fetch a real page.

What the sweep established (`report/dnstt-sweep.txt`):

  * `saN.supaghost.cc` answers every query with NXDOMAIN **except** names under
    `sl` + host, which it answers with FORMERR — byte for byte the reaction of a
    real dnstt server for a malformed payload inside its own tunnel domain.
  * `libsuperdns.so` takes the same flags as dnstt-client (`-udp`, `-doh`,
    `-dot`, `-pubkey`, `-utls`).

So the endpoints are dnstt servers whose domain is `"sl" + host`, which is exactly
what `SuperService` feeds its binary. This script replays that with the reference
dnstt-client and then tries to load a page through the tunnel.

Usage:
  amtunnel_dnstt_e2e.py --client tools/bin/dnstt-client-linux-amd64 \
      --hosts sa1.supaghost.cc,sa11.supaghost.cc --keys <hex>,<hex> \
      --url https://www.instagram.com/ --out report/dnstt-live.txt
"""
from __future__ import annotations

import argparse
import json
import pathlib
import subprocess
import sys
import tempfile
import time

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
from dnsprobe import query  # noqa: E402
from dnstt_e2e import fetch, wait_port  # noqa: E402

DEFAULT_KEYS = [
    "ea0710d912261ce6c8a6c91ea69f308f3d93959fe0c1ec034c5de474e276239b",
    "a43ffc4a4831591b9de7c1ed0cb93795c1209295578eacf0b17a0150abe1d3e7",
    "2c587152c2f436fc5ec104c928e860879c863f40cd3cf40ed0b41cc2adca5048",
]


def resolve(host: str) -> str | None:
    answer = query("8.8.8.8", host, "A")
    return answer.split("AN:A=")[1].split()[0] if "AN:A=" in answer else None


def attempt(client: str, ip: str, key: str, domain: str, port: int,
            urls: list[str], seconds: float) -> dict:
    argv = [client, "-udp", f"{ip}:53", "-pubkey", key, domain, f"127.0.0.1:{port}"]
    log = tempfile.TemporaryFile()
    proc = subprocess.Popen(argv, stdout=log, stderr=subprocess.STDOUT)
    started = time.time()
    result: dict = {"ip": ip, "key": key, "domain": domain, "socks": False, "fetches": []}
    try:
        result["socks"] = wait_port(port, 8)
        if result["socks"]:
            result["socks_after"] = round(time.time() - started, 1)
            for url in urls:
                result["fetches"].append({"url": url, **fetch(port, url, timeout=seconds)})
                if result["fetches"][-1].get("ok"):
                    break
    finally:
        proc.terminate()
        try:
            proc.wait(timeout=5)
        except subprocess.TimeoutExpired:
            proc.kill()
        log.seek(0)
        text = log.read().decode("utf-8", "replace")
        result["log"] = [line for line in text.strip().splitlines() if line][-8:]
    result["begin_session"] = any("begin session" in line for line in result["log"])
    return result


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--client", default="tools/bin/dnstt-client-linux-amd64")
    ap.add_argument("--hosts", default="sa1.supaghost.cc,sa11.supaghost.cc,sa25.supaghost.cc")
    ap.add_argument("--keys", default=",".join(DEFAULT_KEYS))
    ap.add_argument("--url", action="append")
    ap.add_argument("--seconds", type=float, default=25.0)
    ap.add_argument("--out", default="analysis-amtunnel/report/dnstt-live.txt")
    args = ap.parse_args()

    hosts = [h for h in args.hosts.split(",") if h]
    keys = [k for k in args.keys.split(",") if k]
    urls = args.url or ["http://example.com/", "https://www.instagram.com/"]

    lines: list[str] = [f"client: {args.client}", f"urls: {urls}", ""]
    winner: dict | None = None
    port = 23000
    for host in hosts:
        ip = resolve(host)
        domain = f"sl{host}"
        lines.append(f"=== {host} -> {ip}, tunnel domain {domain}")
        if not ip:
            lines.append("  no A record")
            continue
        for key in keys:
            port += 1
            lines.append(f"--- key {key[:16]}… on {ip}:53")
            result = attempt(args.client, ip, key, domain, port, urls, args.seconds)
            lines.append(f"    socks={result['socks']} begin_session={result['begin_session']}")
            for line in result["log"]:
                lines.append("    log: " + line)
            for item in result["fetches"]:
                lines.append("    fetch: " + json.dumps(item, ensure_ascii=False))
            if any(f.get("ok") for f in result["fetches"]):
                winner = {"host": host, **result}
                lines.append("    *** PAGE LOADED THROUGH THE TUNNEL ***")
                break
            if result["begin_session"]:
                lines.append("    (session started, no page yet)")
        lines.append("")
        if winner:
            break

    lines.append("")
    if winner:
        lines.append(f"RESULT: tunnel carries traffic via {winner['domain']} @ {winner['ip']}")
        lines.append(f"key: {winner['key']}")
        lines.append(json.dumps(winner["fetches"], indent=2, ensure_ascii=False))
    else:
        lines.append("RESULT: no page through any combination tried")

    blob = "\n".join(lines) + "\n"
    pathlib.Path(args.out).write_text(blob, encoding="utf-8")
    print(blob)


if __name__ == "__main__":
    main()
