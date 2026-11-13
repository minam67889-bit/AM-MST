#!/usr/bin/env python3
"""Mine an APK's string tables for the SuperDNS server material.

Input: a directory of text files produced by `strings` over the dex/native
libraries. Output: a JSON block with every candidate the app could use to reach
a SuperDNS server - hostnames, dotted quads, 64-hex dnstt keys, base64 blobs,
URLs, and the raw lines that mention "super".

Usage: scan_superdns.py <strdir> <out.json>
"""
from __future__ import annotations

import json
import re
import sys
from pathlib import Path

HOST = re.compile(r"\b(?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\.)+"
                  r"(?:com|net|org|xyz|top|site|online|live|shop|app|io|me|tech|space|club|"
                  r"info|co|dev|pro|link|store|cloud|fun|life|world|icu|buzz|cyou|rest|"
                  r"sbs|cfd|click|quest|monster|buzz|pw|tk|ml|ga|cf|gq)\b", re.I)
HEX64 = re.compile(r"\b[0-9a-fA-F]{64}\b")
IPV4 = re.compile(r"\b(?:(?:25[0-5]|2[0-4]\d|1?\d?\d)\.){3}(?:25[0-5]|2[0-4]\d|1?\d?\d)\b")
URL = re.compile(r"https?://[^\s\"'<>]{4,120}")
B64 = re.compile(r"\b[A-Za-z0-9+/]{40,120}={0,2}\b")
INTEREST = re.compile(r"super|dnstt|slowdns|slow dns|tunnel|pubkey|nameserver", re.I)
NOISE = re.compile(r"(google|gstatic|android|schema|w3\.org|apache\.org|kotlin|jetbrains|"
                   r"facebook|firebase|admob|doubleclick|googlesyndication|github\.com|"
                   r"golang|xray|gvisor|zx2c4|kotlinx|okhttp|squareup|json-schema|json\.org|"
                   r"example\.com|localhost|schemas\.|mozilla\.org|openssl\.org)", re.I)


def main() -> None:
    src = Path(sys.argv[1])
    out = Path(sys.argv[2])
    hosts: dict[str, int] = {}
    ips: dict[str, int] = {}
    keys: set[str] = set()
    urls: set[str] = set()
    b64: set[str] = set()
    lines: list[str] = []
    for path in sorted(src.glob("*.txt")):
        text = path.read_text(errors="ignore")
        for m in HOST.finditer(text):
            h = m.group(0).lower()
            if not NOISE.search(h):
                hosts[h] = hosts.get(h, 0) + 1
        for m in IPV4.finditer(text):
            ip = m.group(0)
            if not ip.startswith(("0.", "127.", "255.")) and ip != "1.1.1.1":
                ips[ip] = ips.get(ip, 0) + 1
        for m in HEX64.finditer(text):
            keys.add(m.group(0).lower())
        for m in URL.finditer(text):
            u = m.group(0)
            if not NOISE.search(u):
                urls.add(u)
        for m in B64.finditer(text):
            b64.add(m.group(0))
        for line in text.splitlines():
            if INTEREST.search(line) and 6 < len(line) < 400:
                lines.append(f"{path.stem}: {line.strip()[:380]}")

    payload = {
        "hosts": [{"host": h, "hits": n} for h, n in
                  sorted(hosts.items(), key=lambda kv: -kv[1])][:200],
        "ips": [{"ip": ip, "hits": n} for ip, n in sorted(ips.items(), key=lambda kv: -kv[1])][:100],
        "hex64_keys": sorted(keys)[:80],
        "urls": sorted(urls)[:120],
        "base64_blobs": sorted(b64)[:80],
        "interesting_lines": lines[:400],
    }
    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_text(json.dumps(payload, indent=1, ensure_ascii=False))
    print(f"{out}: {len(hosts)} hosts, {len(ips)} IPs, {len(keys)} 64-hex keys, "
          f"{len(urls)} urls, {len(lines)} interesting lines")


if __name__ == "__main__":
    main()
