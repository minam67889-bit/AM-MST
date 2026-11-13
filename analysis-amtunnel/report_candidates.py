#!/usr/bin/env python3
"""Print the interesting parts of scan.json in a readable report.

Usage: report_candidates.py scan.json [--probe]
    --probe also resolves the top hosts and HEADs the top URLs (slow).
"""
from __future__ import annotations

import json
import subprocess
import sys


def main() -> None:
    scan = json.load(open(sys.argv[1], encoding="utf-8"))
    probe = "--probe" in sys.argv

    print("### hosts in the dex / libraries")
    for row in scan["hosts"][:60]:
        print(f"  {row['host']:44s} {row['hits']}")
    print()

    print("### urls")
    for url in scan["urls"][:60]:
        print("  ", url)
    print()

    print("### 64-hex keys (dnstt / crypto candidates)")
    for key in scan["hex64_keys"][:40]:
        print("  ", key)
    print()

    print("### base64 blobs")
    for blob in scan["base64_blobs"][:20]:
        print("  ", blob[:100])
    print()

    print("### lines mentioning super / dnstt / tunnel")
    for line in scan["interesting_lines"][:120]:
        print("  ", line[:220])
    print()

    if not probe:
        return

    print("### url probe")
    for url in [u for u in scan["urls"] if "firebase" not in u][:20]:
        r = subprocess.run(["curl", "-sS", "-m", "20", "-o", "/dev/null",
                            "-w", "%{http_code} %{size_download}B %{time_total}s", url],
                           capture_output=True, text=True)
        out = r.stdout.strip() or r.stderr.strip()[:60]
        print(f"  {url[:88]:90s} {out}")
    print()

    print("### dns probe of the top hosts")
    for row in scan["hosts"][:25]:
        host = row["host"]
        a = subprocess.run(["dig", "+short", "+time=4", "+tries=1", host, "A"],
                           capture_output=True, text=True).stdout.strip().replace("\n", " ")
        ns = subprocess.run(["dig", "+short", "+time=4", "+tries=1", host, "NS"],
                            capture_output=True, text=True).stdout.strip().replace("\n", " ")
        print(f"  {host:44s} A={a or '-'}  NS={ns or '-'}")


if __name__ == "__main__":
    main()
