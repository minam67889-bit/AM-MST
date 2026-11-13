#!/usr/bin/env python3
"""Find the real dnstt endpoint for each Ultra Tunnel SlowDNS domain.

A dnstt client sends its queries to the tunnel server itself (BD NET: `-udp
13.140.185.158:53`), or to a resolver that can reach it. Asking 8.8.8.8 is only
meaningful if the delegation is publicly resolvable, so walk the chain:

    parent zone NS -> delegation NS for the tunnel domain -> A of that NS
    -> TXT query straight at <ns-ip>:53

Prints one block per domain; a TXT answer with data means the server is up and
the IP is the address to put in `-udp <ip>:53`.
"""
from __future__ import annotations

import random
import sys

import dns.flags
import dns.message
import dns.name
import dns.query
import dns.rdatatype
import dns.resolver

TIMEOUT = 6


def txt(ip: str, name: str) -> str:
    label = "".join(random.choice("0123456789abcdef") for _ in range(32))
    q = dns.message.make_query(f"{label}.{name}", dns.rdatatype.TXT, use_edns=0, payload=1232)
    try:
        r = dns.query.udp(q, ip, timeout=TIMEOUT)
    except Exception as exc:  # noqa: BLE001
        return f"no reply ({type(exc).__name__})"
    rcode = dns.rcode.to_text(r.rcode())
    answers = [rr.to_text()[:90] for rrset in r.answer for rr in rrset]
    return f"rcode={rcode} answers={len(answers)} {answers[:1]}"


def delegation(name: str) -> list[str]:
    """Ask the parent zone's own nameservers for the delegation of `name`."""
    parts = name.split(".")
    for i in range(1, len(parts)):
        parent = ".".join(parts[i:])
        try:
            ns_answer = dns.resolver.resolve(parent, "NS", lifetime=TIMEOUT)
        except Exception:  # noqa: BLE001
            continue
        servers = [str(r.target).rstrip(".") for r in ns_answer]
        if not servers:
            continue
        ip = None
        for s in servers:
            try:
                ip = str(dns.resolver.resolve(s, "A", lifetime=TIMEOUT)[0])
                break
            except Exception:  # noqa: BLE001
                continue
        if not ip:
            continue
        q = dns.message.make_query(name, dns.rdatatype.NS)
        try:
            r = dns.query.udp(q, ip, timeout=TIMEOUT)
        except Exception:  # noqa: BLE001
            continue
        found = [rr.to_text().split()[-1].rstrip(".") for rrset in r.authority for rr in rrset
                 if rr.rdtype == dns.rdatatype.NS]
        found += [rr.to_text().split()[-1].rstrip(".") for rrset in r.answer for rr in rrset
                  if rr.rdtype == dns.rdatatype.NS]
        if found:
            return found
    return []


def main(domains: list[str]) -> None:
    for d in domains:
        print(f"==== {d}")
        ns = delegation(d)
        print(f"  delegation NS: {ns or '(none found)'}")
        ips: list[str] = []
        for s in ns:
            try:
                ips += [str(a) for a in dns.resolver.resolve(s, "A", lifetime=TIMEOUT)]
            except Exception:  # noqa: BLE001
                pass
        print(f"  NS addresses : {sorted(set(ips)) or '(none)'}")
        for ip in sorted(set(ips)):
            print(f"  TXT @{ip:16s}: {txt(ip, d)}")
        for ip in ("8.8.8.8", "1.1.1.1"):
            print(f"  TXT @{ip:16s}: {txt(ip, d)}")
        print()


if __name__ == "__main__":
    main(sys.argv[1:])
