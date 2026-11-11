#!/usr/bin/env python3
"""Build analysis-ultra/slowdns.json from Ultra Tunnel's decrypted catalogues.

Inputs (both produced by decrypt_config.py):
  analysis-ultra/config-decoded.json         bundled asset, v3.95
  analysis-ultra/remote-config-decoded.json  live updater, v5.28 (newer)

Everything below comes from the app itself: the encrypted catalogue, the launch
line in DNSTunnelThread.java and the flag set of libdns.so.
"""
from __future__ import annotations

import json
import sys

src, dst, remote_path = sys.argv[1], sys.argv[2], (sys.argv[3] if len(sys.argv) > 3 else None)
bundled = json.load(open(src, encoding="utf-8"))
remote = json.load(open(remote_path, encoding="utf-8")) if remote_path else None

DNS_BIN = "libdns.so"          # stock dnstt client, 4_912_352 B, arm64-v8a
LOCAL_FWD = "127.0.0.1:2222"


def argv_for(resolver: str, key: str, domain: str) -> list[str]:
    return [DNS_BIN, "-udp", f"{resolver}:53", "-pubkey", key, domain, LOCAL_FWD]


# --- SlowDNS credentials ---------------------------------------------------
tunnels: dict[tuple[str, str], dict] = {}
for catalog, origin in ((bundled, "bundled asset"), (remote, "live updater")):
    if not catalog:
        continue
    for s in catalog["Servers"]:
        domain, key = s.get("SlowDNSHost"), s.get("SlowDNSKey")
        if not domain or not key:
            continue
        row = tunnels.setdefault((domain, key), {
            "slowdns_domain": domain,
            "slowdns_pubkey_hex": key,
            "names": [],
            "connect_hosts": [],
            "server_types": [],
            "ssl_port": s.get("SSLPort"),
            "ssh_port": s.get("SSH_Port"),
            "catalog_versions": [],
            "ssh_users": [],
        })
        if s["Name"].strip() not in row["names"]:
            row["names"].append(s["Name"].strip())
        for h in (s.get("ServerIPHost") or "").split(";"):
            if h and h not in row["connect_hosts"]:
                row["connect_hosts"].append(h)
        if s.get("ServerType") and s["ServerType"] not in row["server_types"]:
            row["server_types"].append(s["ServerType"])
        user, pwd = s.get("OVPNUser") or "", s.get("OVPNPass") or ""
        if user and all(u["user"] != user for u in row["ssh_users"]):
            row["ssh_users"].append({"user": user, "pass": pwd,
                                     "default_account": bool(s.get("isdefUser"))})
        ver = catalog.get("Version")
        if ver not in row["catalog_versions"]:
            row["catalog_versions"].append(ver)

servers = list(tunnels.values())
servers.sort(key=lambda r: -len(r["names"]))

# --- resolvers the Slow DNS networks ride on -------------------------------
resolvers: dict[str, list[str]] = {}
for catalog in (bundled, remote):
    if not catalog:
        continue
    for n in catalog["Networks"]:
        if n.get("TunnelType") != "Slow DNS":
            continue
        r = (n.get("BugDNS") or "").strip()
        if not r:
            continue
        name = n.get("Name", "").strip()
        if name not in resolvers.setdefault(r, []):
            resolvers[r].append(name)

resolver_rows = []
for addr, names in sorted(resolvers.items(), key=lambda kv: -len(kv[1])):
    is_ip = addr.replace(".", "").isdigit()
    resolver_rows.append({
        "resolver": addr,
        "used_by_networks": len(names),
        "examples": names[:4],
        "kind": ("public" if addr in {"8.8.8.8", "8.8.4.4", "9.9.9.9", "1.0.0.1"}
                 else "carrier/esim" if is_ip else "hostname"),
    })

# --- DNS endpoints, from analysis-ultra/report/dns-endpoints.txt -----------
def parse_endpoints(path: str) -> dict[str, dict]:
    import re
    rows: dict[str, dict] = {}
    cur = None
    try:
        text = open(path, encoding="utf-8").read()
    except OSError:
        return rows
    for line in text.splitlines():
        line = line.strip()
        m = re.match(r"^==== (\S+)$", line)
        if m:
            cur = rows.setdefault(m.group(1), {"ns": [], "ns_ips": [], "txt": {},
                                               "public": {}})
            continue
        if cur is None:
            continue
        if line.startswith("delegation NS:"):
            cur["ns"] = re.findall(r"'([^']+)'", line)
        elif line.startswith("NS addresses"):
            cur["ns_ips"] = re.findall(r"(\d+\.\d+\.\d+\.\d+)", line)
        elif line.startswith("TXT @"):
            m2 = re.match(r"TXT @([0-9.]+)\s*:\s*(.+)$", line)
            if m2:
                ip, res = m2.group(1), m2.group(2)
                if ip in ("8.8.8.8", "1.1.1.1"):
                    cur["public"][ip] = res.split(" answers")[0]
                else:
                    cur["txt"][ip] = res
    return rows


endpoints = parse_endpoints("analysis-ultra/report/dns-endpoints.txt")
for row in servers:
    ep = endpoints.get(row["slowdns_domain"])
    if not ep:
        continue
    row["delegation_ns"] = ep["ns"]
    row["endpoint_ips"] = ep["ns_ips"]
    row["txt_at_endpoint"] = ep["txt"]
    row["public_resolver_rcode"] = ep["public"]
    row["endpoint_answers_raw_dns"] = any("answers=" in v and "answers=0" not in v
                                          for v in ep["txt"].values())

# --- end-to-end verdict per domain, from analysis-ultra/report/e2e.txt ------
def parse_e2e(path: str) -> dict[str, list[dict]]:
    import re
    out: dict[str, list[dict]] = {}
    cur = None
    try:
        text = open(path, encoding="utf-8").read()
    except OSError:
        return out
    for line in text.splitlines():
        m = re.match(r"^==== (\S+) via (\S+)$", line.strip())
        if m:
            cur = {"endpoint": m.group(2), "outcome": "no data"}
            out.setdefault(m.group(1), []).append(cur)
            continue
        if cur is None:
            continue
        if "BANNER" in line:
            cur["outcome"] = "banner (tunnel live)"
        elif "HTTP" in line:
            cur["outcome"] = "http (tunnel live)"
        elif "NO-DATA" in line or "CONNECT-FAIL" in line:
            cur["outcome"] = "silent (no stream opened)"
    return out


e2e = parse_e2e("analysis-ultra/report/e2e.txt")
for row in servers:
    row["end_to_end"] = e2e.get(row["slowdns_domain"], [])
    row["usable_from_public_internet"] = any(
        "live" in probe["outcome"] for probe in row["end_to_end"])

# --- launch recipes ---------------------------------------------------------
recipes = []
for row in servers:
    for r in ("8.8.8.8", "8.8.4.4", "9.9.9.9", "1.0.0.1"):
        recipes.append({"domain": row["slowdns_domain"], "pubkey": row["slowdns_pubkey_hex"],
                        "resolver": r,
                        "argv": argv_for(r, row["slowdns_pubkey_hex"], row["slowdns_domain"])})

live = json.load(open("analysis-ultra/report/liveness.txt", encoding="utf-8")) \
    if False else None  # report is textual; referenced, not parsed

out = {
    "$schema_note": (
        "Ultra Tunnel (co.strongteam.ultra) SlowDNS material. The tunnel is stock "
        "dnstt: domain + 64-hex pubkey + resolver is the complete credential set, "
        "so nothing here is guessed. Both the bundled catalogue (v3.95) and the "
        "app's live updater (v5.28) were decrypted and merged."
    ),
    "app": {
        "package": "co.strongteam.ultra",
        "version": "v1.0.8.8 / build 59",
        "min_sdk": 32,
        "abi": "arm64-v8a",
        "engine_mode": "bTUNNEL_TYPE_SLOWDNS = 6",
    },
    "catalogue": {
        "bundled_version": bundled.get("Version"),
        "bundled_servers": len(bundled["Servers"]),
        "bundled_networks": len(bundled["Networks"]),
        "live_version": remote.get("Version") if remote else None,
        "live_servers": len(remote["Servers"]) if remote else None,
        "live_networks": len(remote["Networks"]) if remote else None,
        "distinct_slowdns_tunnels": len(servers),
        "slowdns_networks": sum(
            1 for c in (bundled, remote) if c
            for n in c["Networks"] if n.get("TunnelType") == "Slow DNS"),
        "tunnel_types": {
            t: sum(1 for n in (remote or bundled)["Networks"] if n.get("TunnelType") == t)
            for t in sorted({n.get("TunnelType") for n in (remote or bundled)["Networks"]})
        },
    },
    "encryption": {
        "format": "base64( salt[16] || nonce[12] || AES-256-GCM ciphertext || tag[16] ), AAD = salt",
        "kdf": "Argon2id v19, t=3, m=8192 KiB, p=1, 32-byte key",
        "bundled_asset_and_protected_fields": "NurChickenPowder",
        "remote_updater": ("/4ssU0OjjtKH8AheiAxnc3DwSGDzsy+8 -- export framing inserts one "
                           "random ASCII letter at index 3 after base64 (len%4==1)"),
        "protected_fields": [
            "ServerIPHost", "SlowDNSHost", "SlowDNSKey", "OVPNUser", "OVPNPass",
            "UDP_obfs", "UDP_user", "CustomCertificate", "V2rayUUID", "V2rayPath",
            "H2pass", "TrojanPass", "Payload", "CustomProxy", "SNI", "BugDNS",
        ],
        "where": "libgojni.so github.com/2dust/AndroidLibXrayLite.EO/DO",
        "decoder_in_repo": "analysis-ultra/decrypt_config.py",
        "decoded_catalogues": ["analysis-ultra/config-decoded.json",
                               "analysis-ultra/remote-config-decoded.json"],
        "remote_catalogue_url": "https://strongteam.co/api/ultrasystem/ultrav3.txt",
        "remote_catalogue_ua": "Ultra Tunnel",
    },
    "engine": {
        "mode": "slowdns (dnstt over DNS/UDP)",
        "binary": {"name": DNS_BIN, "size": 4912352, "abi": "arm64-v8a",
                   "origin": "lib/arm64-v8a/libdns.so inside Ultra Tunnel's XAPK",
                   "upstream": "stock dnstt client (www.bamsoftware.com/git/dnstt.git/dns)"},
        "argv_template": [DNS_BIN, "-udp", "<resolver>:53", "-pubkey", "<64-hex>",
                          "<domain>", LOCAL_FWD],
        "argv_example": argv_for("8.8.8.8", servers[0]["slowdns_pubkey_hex"],
                                 servers[0]["slowdns_domain"]),
        "flags": ["-udp ADDR", "-doh URL", "-dot ADDR", "-pubkey HEX64", "-pubkey-file FILE"],
        "not_present": ["-report (BD NET licence gate)", "-utls (BD NET camouflage)"],
        "source": ("DNSTunnelThread.java run(): exec(libdns -udp <dnsKey>:53 -pubkey "
                   "<chaveKey> <serverNameKey> 127.0.0.1:2222)"),
        "prefs": {"dnsKey": "resolver", "chaveKey": "64-hex pubkey",
                  "serverNameKey": "SlowDNS domain"},
    },
    "ports": {"dns_upstream": 53, "local_dnstt_forwarder": 2222,
              "ssl_tunnel_port": 443, "ssh_port": 22},
    "resolvers": {
        "count": len(resolver_rows),
        "note": ("the app lets the user pick any of these; many are carrier/eSIM "
                 "resolvers that only answer inside their own network, the public "
                 "ones work anywhere -- this is the multi-resolver knob to "
                 "auto-balance over"),
        "list": resolver_rows,
    },
    "servers": servers,
    "launch_recipes": recipes,
    "verification": {
        "decrypted_in_sandbox": True,
        "live_updater_fetch": "analysis-ultra/report/remote-fetch.txt (HTTP 200, 1,385,469 B)",
        "dns_liveness": "analysis-ultra/report/liveness.txt",
        "end_to_end": "analysis-ultra/report/e2e.txt",
        "toolchain_self_test": "analysis-ultra/report/selftest.txt",
        "summary": {
            "catalogue": "VERIFIED - both catalogues decrypt completely (v3.95 bundled, v5.28 live)",
            "credentials": "VERIFIED - domain + 64-hex dnstt pubkey + SSH account per SlowDNS server",
            "engine_argv": "VERIFIED - read from DNSTunnelThread.run(), matches libdns.so flags",
            "client_toolchain": ("VERIFIED - a fresh dnstt client built from source moved a real "
                                 "HTTP 200 through a local dnstt-server over UDP (self-test)"),
            "ultra_endpoints_from_public_internet": ("UNVERIFIED - all 8 domains are silent: no "
                                                     "stream opens, no TXT answer; their authoritative "
                                                     "NS IPs drop packets that do not come from the "
                                                     "carrier resolvers listed in `resolvers`"),
            "carrier_path": ("UNVERIFIED - none of the 49 non-public resolvers is reachable from a "
                             "cloud runner, so the carrier/eSIM data-free path can only be tested "
                             "from a device on one of those networks"),
        },
    },
}

with open(dst, "w", encoding="utf-8") as fh:
    json.dump(out, fh, ensure_ascii=False, indent=1)
print(f"wrote {dst}: {len(servers)} tunnels, {len(resolver_rows)} resolvers, "
      f"{len(recipes)} recipes")
