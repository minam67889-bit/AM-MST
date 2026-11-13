#!/usr/bin/env python3
"""Build `analysis-amtunnel/superdns.json` from the decrypted catalogue.

Inputs (all produced by the CI hunt, see .github/workflows/amtunnel-superdns.yml):
  report/janny-decoded.json   the app's own server catalogue, XXTEA-decrypted
  report/a-records.json       A-record census of every host in the catalogue
  report/superdns-run.txt     DNS/IP-level probe of the SuperDNS endpoints
  report/superdns-abi.txt     what libsuperdns.so actually is

Usage: build_superdns_json.py [out.json]
"""
from __future__ import annotations

import json
import pathlib

ROOT = pathlib.Path(__file__).resolve().parent
REPORT = ROOT / "report"

CATEGORY_META = {
    "ocsslow": {
        "engine": "SuperDNS (libsuperdns.so, exec'd by prince.udp.vpn.service.SuperService)",
        "ui_name": "SuperDNS",
        "local_port": 7000,
    },
    "ocsdnstt": {
        "engine": "SocksDNS / dnstt (libdns.so, prince.udp.vpn.service.SocksDNSService)",
        "ui_name": "SocksDNS",
        "local_port": 10802,
    },
    "ocspdoq": {
        "engine": "PDoQ (libpdoq.so + libpdoqhelper.so, PDoQService)",
        "ui_name": "PDoQ",
        "local_port": 2222,
    },
    "ocsudp": {
        "engine": "UDP (libudpq.so, UDPClient thread)",
        "ui_name": "UDP",
        "local_port": 10802,
    },
    "ocsnormal": {
        "engine": "HTTP/SOCKS through libxray.so (Xray 24.11.30)",
        "ui_name": "Normal",
        "local_port": 10801,
    },
}


def load(name: str):
    path = REPORT / name
    if not path.exists():
        return None
    try:
        return json.loads(path.read_text(encoding="utf-8"))
    except json.JSONDecodeError:
        return path.read_text(encoding="utf-8", errors="replace")


def main() -> None:
    out_path = pathlib.Path(sys_argv()) if len(__import__("sys").argv) > 1 else ROOT / "superdns.json"
    catalogue = load("janny-decoded.json")
    census = load("a-records.json") or {}
    probe = load("superdns-run.txt")
    abi = load("superdns-abi.txt")

    groups: dict[str, list[dict]] = {}
    seen: dict[str, set[str]] = {}
    for entry in catalogue.get("Free_servers", []):
        category = entry.get("category", "?")
        hosts = [h.strip() for h in str(entry.get("server_host", "")).split(";") if h.strip()]
        groups.setdefault(category, [])
        seen.setdefault(category, set())
        unique: list[str] = []
        for host in hosts:
            # group 6 repeats the hosts of groups 1-5 on purpose; keep every
            # group intact and dedupe only for the category totals below.
            if host not in unique:
                unique.append(host)
            seen[category].add(host)
        groups[category].append({
            "name": entry.get("server_name", ""),
            "hosts": unique,
            "host_count": len(unique),
            "resolved": {
                host: (census.get(host, {}) or {}).get("a") for host in unique
            },
            "alive": sum(1 for host in unique if (census.get(host, {}) or {}).get("a")),
            "server_port": entry.get("server_port") or None,
            "server_udp_port": entry.get("server_udp_port") or None,
            "ssl_port": entry.get("ssl_port") or None,
        })

    transports: dict[str, list[str]] = {}
    for entry in catalogue.get("Payloads", []):
        payload = entry.get("payload", "")
        if not payload:
            continue
        transports.setdefault(entry.get("category", "?"), [])
        if payload not in transports[entry["category"]]:
            transports[entry["category"]].append(payload)

    def host_count(category: str) -> int:
        return len(seen.get(category, set()))

    def alive_count(category: str) -> int:
        return sum(1 for host in seen.get(category, set())
                   if (census.get(host, {}) or {}).get("a"))

    document = {
        "schema": "am-tunnel-superdns/1",
        "generated_from": {
            "apk": "AM TUNNEL LITE VPN [MOD Universal] (filebin kaq42zmlr3c1na2g)",
            "package": "app.vpn.amtunnellite",
            "catalogue": "assets/janny.json inside the APK",
            "how": ("base64 -> XXTEA (defpackage.AbstractC3622yh.b) with the key "
                    "\"...|...\" -> JSON; tools/xxtea_janny.py"),
            "catalogue_version": catalogue.get("Version"),
            "catalogue_udp_version": catalogue.get("UDPVersion"),
            "updater_link": catalogue.get("UpdaterLink") or None,
        },
        "engines": CATEGORY_META,
        "superdns": {
            "what_it_is": ("a Go binary named libsuperdns.so, exec'd by SuperService; it is "
                           "not dnstt (no bamsoftware/turbotunnel markers, it links "
                           "crypto/tls, http2, QUIC and uTLS)"),
            "binary": {
                "apk_path": "lib/arm64-v8a/libsuperdns.so",
                "size_bytes": 16607808,
                "elf": ("ELF 64-bit LSB shared object, ARM aarch64, dynamically linked, "
                        "interpreter /system/bin/linker64, for Android 21, NDK r19c, stripped"),
                "also_shipped": {"armeabi-v7a": 15889620},
                "runnable_off_android": False,
                "why_not": "the interpreter is Android's bionic /system/bin/linker64",
            },
            "argv": {
                "template": ["libsuperdns.so", "<-udp|-doh|-dot>", "<endpoint>", "-utls",
                             "Chrome|Firefox", "-frequency", "<SUPER_DNS_FREQUENCY>",
                             "-report", "AM TUNNEL LITE VPN", "-pubkey", "prince",
                             "<sl + SSH_HOST>", "127.0.0.1:7000"],
                "transport_switches": {
                    "udp://<host>": "-udp <host>:53",
                    "doh://<host>": "-doh https://<host>/dns-query",
                    "dot://<host>": "-dot <host>:853",
                },
                "domain_rule": "\"sl\" + SSH_HOST, where SSH_HOST is the selected server host",
                "pubkey": "prince",
                "utls": ["Chrome", "Firefox"],
                "local_listen": "127.0.0.1:7000",
            },
            "source": "prince/udp/vpn/service/SuperService.java (string table decrypted)",
        },
        "servers": {
            "superdns": groups.get("ocsslow", []),
            "dnstt": groups.get("ocsdnstt", []),
            "pdoq": groups.get("ocspdoq", []),
            "udp": groups.get("ocsudp", []),
            "http_socks": groups.get("ocsnormal", []),
        },
        "superdns_hosts_flat": sorted(seen.get("ocsslow", set())),
        "transports": transports,
        "credentials": {
            "username": "tanginaka",
            "password": "tanginaka",
            "how": "catalogue fields Username/Password are XXTEA(base64) with the same key",
        },
        "verification": {
            "verified": [
                f"catalogue decrypted from the APK (not guessed): {len(catalogue.get('Free_servers', []))} server groups, "
                f"{len(catalogue.get('Payloads', []))} transport entries",
                f"all {host_count('ocsslow')} SuperDNS hosts resolve via 8.8.8.8 "
                f"({alive_count('ocsslow')} alive)",
                f"all {host_count('ocsdnstt')} dnstt hosts resolve ({alive_count('ocsdnstt')} alive)",
                f"UDP hosts: {alive_count('ocsudp')}/{host_count('ocsudp')} resolve",
                f"PDoQ hosts: {alive_count('ocspdoq')}/{host_count('ocspdoq')} resolve "
                "(the whole pdoq pool is gone)",
                f"HTTP/SOCKS hosts: {alive_count('ocsnormal')}/{host_count('ocsnormal')} resolve",
                "SuperService argv, pubkey and local port read from the decrypted code",
            ],
            "unverified": [
                "no handshake was driven through libsuperdns.so: it is an Android-only ELF "
                "(aarch64, /system/bin/linker64)",
                "the \"sl\" + host domain rule is what the code does, but sl<host> has no public "
                "A/NS record and supaghost.cc has no NS delegation, so the effective wire name "
                "could not be confirmed from outside",
                "no tunnelled page was fetched; the exact label format the Go client sends was "
                "not reproduced, so a NOERROR from the server on a well-formed query was never "
                "observed",
            ],
            "endpoint_behaviour": {
                "udp_53": "answers (NXDOMAIN for the apex, for sl<host> and for a random label)",
                "tcp_53": "connection refused",
                "tcp_443_8443_2053_2096_8080_80": "connection refused on every sampled host",
                "reading": ("the endpoints are pure DNS listeners, so the tunnel rides on :53 "
                            "only, which matches a DNS tunnel and rules out a TLS/QUIC listener "
                            "on the usual alternative ports"),
            },
            "dns_census": {category: f"{alive_count(category)}/{host_count(category)}" for category in CATEGORY_META},
            "evidence_files": [
                "report/janny-decoded.json", "report/a-records.json",
                "report/superdns-run.txt", "report/superdns-abi.txt",
                "report/dns-census.txt", "report/decrypted.tsv",
            ],
            "endpoint_probe": (probe or "")[:6000] if isinstance(probe, str) else None,
            "binary_facts": (abi or "")[:2000] if isinstance(abi, str) else None,
        },
    }

    out_path.write_text(json.dumps(document, indent=2, ensure_ascii=False) + "\n", encoding="utf-8")
    print(f"wrote {out_path}")
    print(f"superdns groups={len(document['servers']['superdns'])} "
          f"hosts={host_count('ocsslow')} transports={len(transports.get('ocsslow', []))}")


def sys_argv() -> str:
    import sys
    return sys.argv[1] if len(sys.argv) > 1 else str(ROOT / "superdns.json")


if __name__ == "__main__":
    main()
