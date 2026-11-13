#!/usr/bin/env python3
"""Find and then actually use a dnstt tunnel among AM TUNNEL's servers.

Order of work, cheapest first:

  1. resolve every `ocsdnstt` host from the decrypted catalogue;
  2. send it a dnstt-shaped query (base32 payload in the qname, TXT) and compare
     the answer with the signature a dnstt server gives (FORMERR, no SOA) versus
     an ordinary authoritative server (NXDOMAIN + SOA);
  3. for the hosts that look like dnstt, run dnstt-client with each candidate
     public key and domain form, and try to fetch a real page through the SOCKS
     listener (Instagram by default).

Usage:
  dnstt_hunt.py --catalogue analysis-amtunnel/report/janny-decoded.json \
                --keys-file analysis-amtunnel/report/dnstt-keys.txt \
                --client tools/bin/dnstt-client-linux-amd64 \
                --out analysis-amtunnel/report/dnstt-test.txt
"""
from __future__ import annotations

import argparse
import json
import pathlib
import re
import sys

sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
from dnsprobe import query  # noqa: E402
from dnstt_probe import ask, b32_payload  # noqa: E402


def resolve(host: str, resolver: str = "8.8.8.8") -> str | None:
    answer = query(resolver, host, "A")
    return answer.split("AN:A=")[1].split()[0] if "AN:A=" in answer else None


def classify(server: str, domain: str) -> tuple[str, dict]:
    """dnstt answers malformed payloads with FORMERR and no SOA record."""
    shaped = ask(server, f"{b32_payload(24)}.{domain}", 16)
    apex = ask(server, domain, 16)
    if "error" in shaped:
        return "unreachable", {"shaped": shaped, "apex": apex}
    if shaped.get("rcode") == 1 and "SOA" not in " ".join(shaped.get("answers", [])):
        return "dnstt-like", {"shaped": shaped, "apex": apex}
    if shaped.get("an", 0) and any(a.startswith("TXT") for a in shaped.get("answers", [])):
        return "tunnel-shaped-txt", {"shaped": shaped, "apex": apex}
    return "plain-dns", {"shaped": shaped, "apex": apex}


def candidate_domains(host: str) -> list[str]:
    return [host, f"t.{host}", f"sd{host}", f"sd.{host}", f"sl{host}"]


def main() -> None:
    ap = argparse.ArgumentParser()
    ap.add_argument("--catalogue", default="analysis-amtunnel/report/janny-decoded.json")
    ap.add_argument("--keys-file", default="analysis-amtunnel/report/dnstt-keys.txt")
    ap.add_argument("--client", default="tools/bin/dnstt-client-linux-amd64")
    ap.add_argument("--out", default="analysis-amtunnel/report/dnstt-test.txt")
    ap.add_argument("--hosts", help="comma separated override")
    ap.add_argument("--key", action="append", help="extra 64-hex public key")
    ap.add_argument("--url", default="https://www.instagram.com/")
    ap.add_argument("--seconds", type=float, default=25.0)
    ap.add_argument("--probe-limit", type=int, default=8)
    ap.add_argument("--max-hosts", type=int, default=3)
    ap.add_argument("--max-keys", type=int, default=3)
    ap.add_argument("--max-domains", type=int, default=2)
    args = ap.parse_args()

    catalogue = json.loads(pathlib.Path(args.catalogue).read_text(encoding="utf-8"))
    hosts: list[str] = []
    if args.hosts:
        hosts = [h for h in args.hosts.split(",") if h]
    else:
        for entry in catalogue.get("Free_servers", []):
            if entry.get("category") != "ocsdnstt":
                continue
            for host in str(entry.get("server_host", "")).split(";"):
                host = host.strip()
                if host and host not in hosts:
                    hosts.append(host)

    keys: list[str] = list(dict.fromkeys(args.key or []))
    keys_file = pathlib.Path(args.keys_file)
    if keys_file.exists():
        for match in re.finditer(r"\b[0-9a-f]{64}\b", keys_file.read_text(errors="replace")):
            if match.group(0) not in keys:
                keys.append(match.group(0))

    lines: list[str] = []
    lines.append(f"catalogue: {args.catalogue}")
    lines.append(f"dnstt hosts in catalogue: {len(hosts)}")
    lines.append(f"key candidates: {len(keys)}")
    for key in keys:
        lines.append(f"  {key}")
    lines.append("")

    probe_sample = hosts[:args.probe_limit]
    good: list[tuple[str, str]] = []
    for host in probe_sample:
        ip = resolve(host)
        lines.append(f"=== {host} -> {ip}")
        if not ip:
            lines.append("  no A record")
            continue
        label, detail = classify(f"{ip}:53", host)
        lines.append(f"  shape: {label} {detail['shaped']}")
        lines.append(f"  apex : {detail['apex']}")
        if label in ("dnstt-like", "tunnel-shaped-txt"):
            good.append((host, ip))
    lines.append("")
    lines.append(f"dnstt-like endpoints: {len(good)} {[h for h, _ in good]}")
    lines.append("")

    sys.path.insert(0, str(pathlib.Path(__file__).resolve().parent))
    from dnstt_e2e import fetch, wait_port  # noqa: E402
    import socket
    import subprocess
    import tempfile
    import time

    attempts = 0
    success: dict | None = None
    targets = good or [(resolve(h), h) for h in probe_sample[:2] if resolve(h)]
    for host, ip in [(g[0], g[1]) for g in good][:args.max_hosts]:
        for key in keys[:args.max_keys]:
            for domain in candidate_domains(host)[:args.max_domains]:
                if success:
                    break
                attempts += 1
                port = 21000 + (attempts % 2000)
                argv = [args.client, "-udp", f"{ip}:53", "-pubkey", key, domain, f"127.0.0.1:{port}"]
                log = tempfile.TemporaryFile()
                proc = subprocess.Popen(argv, stdout=log, stderr=subprocess.STDOUT)
                lines.append(f"--- attempt {attempts}: {domain} via {ip}:53 key={key[:16]}…")
                try:
                    up = wait_port(port, 6)
                    result = {"ok": False, "stage": "client"}
                    if up:
                        result = fetch(port, args.url, timeout=args.seconds)
                    lines.append(f"    socks={up} result={json.dumps(result, ensure_ascii=False)}")
                    if result.get("ok"):
                        success = {"host": host, "ip": ip, "key": key, "domain": domain, "result": result}
                        lines.append("    *** TUNNEL CARRIES TRAFFIC ***")
                finally:
                    proc.terminate()
                    try:
                        proc.wait(timeout=5)
                    except subprocess.TimeoutExpired:
                        proc.kill()
                    log.seek(0)
                    tail = log.read().decode("utf-8", "replace").strip().splitlines()[-4:]
                    for line in tail:
                        lines.append("      log: " + line)
            if success:
                break
        if success:
            break

    lines.append("")
    if success:
        lines.append(f"RESULT: tunnel works via {success['domain']} @ {success['ip']} "
                     f"with key {success['key']}")
        lines.append(f"page: {json.dumps(success['result'], ensure_ascii=False)}")
    else:
        lines.append("RESULT: no tunnel carried traffic")
        lines.append(f"attempts: {attempts}")

    blob = "\n".join(lines) + "\n"
    pathlib.Path(args.out).write_text(blob, encoding="utf-8")
    print(blob)


if __name__ == "__main__":
    main()
