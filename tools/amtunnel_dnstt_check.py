#!/usr/bin/env python3
"""Reachability + dnstt-signature sweep over AM TUNNEL's own endpoints.

The runner (unlike the sandbox) can send UDP to arbitrary hosts, so this is where
the endpoints can actually be measured. For every host in the catalogue we send
one small DNS query and record:

  FORMERR            -> this is a dnstt-style server for that qname
  NXDOMAIN + answer  -> an ordinary DNS server (or a tunnel server for another name)
  timeout            -> not reachable from here

We then repeat with `sl` + host and a couple of other name shapes, because the
server only answers FORMERR for names **under its configured tunnel domain**.

Usage: amtunnel_dnstt_check.py <janny-decoded.json> <out.txt> [--threads 24]
"""
from __future__ import annotations

import argparse
import collections
import concurrent.futures
import json
import pathlib
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
from dnsprobe import query  # noqa: E402
from dnstt_probe import ask, b32_payload  # noqa: E402

CATEGORIES = ("ocsslow", "ocsdnstt")


def a_record(host: str) -> str | None:
    answer = query("8.8.8.8", host, "A")
    return answer.split("AN:A=")[1].split()[0] if "AN:A=" in answer else None


def probe(host: str) -> dict:
    ip = a_record(host)
    row = {"host": host, "ip": ip, "trials": {}}
    if not ip:
        return row
    for label, name in (
        ("apex", host),
        ("b32", f"{b32_payload(16)}.{host}"),
        ("sl", f"sl{host}"),
        ("sl_b32", f"{b32_payload(16)}.sl{host}"),
        ("sd_b32", f"{b32_payload(16)}.sd.{host}"),
    ):
        row["trials"][label] = ask(f"{ip}:53", name, 16, timeout=3.0)
    return row


def verdict(row: dict) -> str:
    trials = row.get("trials") or {}
    if not row.get("ip"):
        return "no-a-record"
    if any("error" in t for t in trials.values()) and all("error" in t for t in trials.values()):
        return "unreachable"
    for label, result in trials.items():
        if result.get("rcode") == 1:
            return f"FORMERR/{label} (dnstt-shaped)"
    if any(t.get("rcode") == 3 for t in trials.values()):
        return "nxdomain (plain dns)"
    if any(t.get("an", 0) for t in trials.values()):
        return "answers (plain dns)"
    return "odd"


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("catalogue")
    ap.add_argument("out")
    ap.add_argument("--threads", type=int, default=24)
    args = ap.parse_args()

    data = json.loads(pathlib.Path(args.catalogue).read_text(encoding="utf-8"))
    hosts: list[tuple[str, str]] = []
    for entry in data.get("Free_servers", []):
        category = entry.get("category", "?")
        if category not in CATEGORIES:
            continue
        for host in str(entry.get("server_host", "")).split(";"):
            host = host.strip()
            if host and (host, category) not in hosts:
                hosts.append((host, category))

    rows: list[dict] = []
    with concurrent.futures.ThreadPoolExecutor(max_workers=args.threads) as pool:
        futures = {pool.submit(probe, host): (host, category) for host, category in hosts}
        for future in concurrent.futures.as_completed(futures):
            host, category = futures[future]
            try:
                row = future.result()
            except Exception as exc:  # noqa: BLE001
                row = {"host": host, "ip": None, "trials": {}, "error": str(exc)}
            row["category"] = category
            row["verdict"] = verdict(row)
            rows.append(row)

    rows.sort(key=lambda r: (r["category"], r["host"]))
    counts = collections.Counter((r["category"], r["verdict"].split()[0]) for r in rows)
    lines = ["=== verdict counts"]
    for (category, kind), count in sorted(counts.items()):
        lines.append(f"  {category:<9} {kind:<24} {count}")
    lines.append("")
    for category in CATEGORIES:
        subset = [r for r in rows if r["category"] == category]
        lines.append(f"=== {category}: {len(subset)} hosts")
        for row in subset:
            lines.append(f"  {row['host']:<22} {str(row['ip']):<16} {row['verdict']}")
            if row["verdict"].startswith("FORMERR") or row["verdict"] == "answers (plain dns)":
                for label, trial in row["trials"].items():
                    if trial.get("rcode") is not None:
                        lines.append(f"      {label:<7} rcode={trial.get('rcode')} "
                                     f"an={trial.get('an')} {trial.get('answers')}")
        lines.append("")

    reachable = [r for r in rows if "error" not in (r.get("trials") or {}).get("apex", {"error": "x"})]
    lines.append(f"endpoints that answered anything: {len(reachable)}/{len(rows)}")
    blob = "\n".join(lines) + "\n"
    pathlib.Path(args.out).write_text(blob, encoding="utf-8")
    print(blob[:6000])


if __name__ == "__main__":
    main()
