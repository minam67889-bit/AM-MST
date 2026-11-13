#!/usr/bin/env python3
"""DNS census over the decrypted AM TUNNEL LITE catalogue.

Reads `janny-decoded.json`, groups every `server_host` by its category, and
resolves a bounded sample of them (plus a random label under each zone, which
tells us whether the zone is actually delegated to a tunnel server).

Usage: catalogue_census.py <janny-decoded.json> <out.txt> [resolver] [sample]
"""
from __future__ import annotations

import collections
import json
import pathlib
import random
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
from dnsprobe import query  # noqa: E402

CATEGORY_MEANING = {
    "ocsslow": "SuperDNS / SlowDNS  (libsuperdns.so)",
    "ocsdnstt": "dnstt  (SocksDNSService)",
    "ocspdoq": "PDoQ  (libpdoq.so)",
    "ocsudp": "UDP  (libudpq.so)",
    "ocsnormal": "HTTP/SOCKS (libxray.so)",
}


def main() -> None:
    path = pathlib.Path(sys.argv[1])
    out = pathlib.Path(sys.argv[2])
    resolver = sys.argv[3] if len(sys.argv) > 3 else "8.8.8.8"
    sample = int(sys.argv[4]) if len(sys.argv) > 4 else 12

    data = json.loads(path.read_text(encoding="utf-8"))
    groups: dict[str, list[str]] = collections.defaultdict(list)
    for server in data.get("Free_servers", []):
        category = server.get("category", "?")
        for host in str(server.get("server_host", "")).split(";"):
            host = host.strip()
            if host and host not in groups[category]:
                groups[category].append(host)

    lines: list[str] = []
    random.seed(7)
    for category, hosts in sorted(groups.items()):
        lines.append(f"=== {category}  ({CATEGORY_MEANING.get(category, '?')})")
        lines.append(f"hosts in catalogue: {len(hosts)}")
        picked = hosts if len(hosts) <= sample else random.sample(hosts, sample)
        alive = 0
        for host in picked:
            result = query(resolver, host, "A")
            if "AN:A=" in result:
                alive += 1
            lines.append(f"  A   {host:<28} {result}")
        lines.append(f"  sample alive: {alive}/{len(picked)}")
        # Is any part of the name delegated to a tunnel server?
        for host in picked[:3]:
            label = f"x7q{random.randint(100, 999)}.{host}"
            lines.append(f"  NS  {host:<28} {query(resolver, host, 'NS')}")
            lines.append(f"  del {label:<28} {query(resolver, label, 'A')}")
        lines.append("")

    lines.append("=== transport payloads (the DNS resolver the client is told to use)")
    per_category: dict[str, list[str]] = collections.defaultdict(list)
    for entry in data.get("Payloads", []):
        payload = entry.get("payload", "")
        if payload and payload not in per_category[entry.get("category", "?")]:
            per_category[entry.get("category", "?")].append(payload)
    for category, payloads in sorted(per_category.items()):
        lines.append(f"  {category}: {len(payloads)} entries")
        for payload in payloads[:8]:
            lines.append(f"     {payload}")
        if len(payloads) > 8:
            lines.append(f"     ... {len(payloads) - 8} more")

    blob = "\n".join(lines) + "\n"
    out.write_text(blob, encoding="utf-8")
    print(blob)


if __name__ == "__main__":
    main()
