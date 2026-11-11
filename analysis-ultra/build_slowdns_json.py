#!/usr/bin/env python3
"""Build analysis-ultra/slowdns.json from the decrypted Ultra Tunnel catalogue.

Everything here is extracted from build 59 (co.strongteam.ultra v1.0.8.8),
assets/configfile.json -> Argon2id/AES-GCM -> ConfigData JSON, plus the launch
line read out of DNSTunnelThread.java and the flag set of libdns.so.
"""
from __future__ import annotations

import json
import sys

ARGS = dict(zip(("src", "dst", "cat"), sys.argv[1:4]))
cat = json.load(open(ARGS["cat"], encoding="utf-8"))
data = json.load(open(ARGS["src"], encoding="utf-8"))

DNS_BIN = "libdns.so"          # stock dnstt client, 4_912_352 B, arm64-v8a
LOCAL_FWD = "127.0.0.1:2222"


def argv_for(resolver: str, key: str, domain: str) -> list[str]:
    return [DNS_BIN, "-udp", f"{resolver}:53", "-pubkey", key, domain, LOCAL_FWD]


# --- servers that carry SlowDNS credentials -------------------------------
servers = []
for s in data["Servers"]:
    if not s.get("SlowDNSHost"):
        continue
    hosts = [h for h in (s.get("ServerIPHost") or "").split(";") if h]
    servers.append({
        "name": s["Name"].strip(),
        "slowdns_domain": s["SlowDNSHost"],
        "slowdns_pubkey_hex": s["SlowDNSKey"],
        "connect_hosts": hosts,
        "server_type": s.get("ServerType"),
        "server_protocol": s.get("ServerProtocol"),
        "ssl_port": s.get("SSLPort"),
        "ssh_port": s.get("SSH_Port"),
        "ovpn_user": s.get("OVPNUser"),
        "ovpn_pass": s.get("OVPNPass"),
        "udp_user": s.get("UDP_user"),
        "udp_obfs": s.get("UDP_obfs"),
        "custom_certificate": s.get("CustomCertificate"),
    })

# --- resolvers the Slow DNS networks ride on -------------------------------
resolvers: dict[str, list[str]] = {}
for n in data["Networks"]:
    if n.get("TunnelType") != "Slow DNS":
        continue
    r = (n.get("BugDNS") or "").strip()
    if not r:
        continue
    resolvers.setdefault(r, []).append(n.get("Name", "").strip())

resolver_rows = []
for addr, names in sorted(resolvers.items(), key=lambda kv: -len(kv[1])):
    resolver_rows.append({
        "resolver": addr,
        "used_by_networks": len(names),
        "examples": names[:4],
        "kind": ("public" if addr in {"8.8.8.8", "8.8.4.4", "9.9.9.9", "1.0.0.1"} else
                 "carrier/esim" if addr.replace(".", "").isdigit() else "hostname"),
    })

# --- what the app itself runs ---------------------------------------------
unique = {}
for s in servers:
    unique.setdefault((s["slowdns_domain"], s["slowdns_pubkey_hex"]), []).append(s["name"])

examples = []
for (domain, key), names in unique.items():
    for r in ("8.8.8.8", "8.8.4.4", "9.9.9.9", "1.0.0.1"):
        examples.append({"domain": domain, "pubkey": key, "resolver": r,
                         "argv": argv_for(r, key, domain)})

out = {
    "$schema_note": (
        "Ultra Tunnel (co.strongteam.ultra v1.0.8.8/build59) SlowDNS material. "
        "Recovered from the app's encrypted catalogue; the tunnel itself is stock "
        "dnstt, so nothing is guessed: host + 64-hex pubkey + resolver is the "
        "complete credential set."
    ),
    "app": {
        "package": "co.strongteam.ultra",
        "version": "v1.0.8.8 / build 59",
        "catalog_version": data.get("Version"),
        "min_sdk": 32,
        "abi": "arm64-v8a",
        "engine_mode": "bTUNNEL_TYPE_SLOWDNS = 6",
    },
    "catalogue": {
        "servers": len(data["Servers"]),
        "networks": len(data["Networks"]),
        "slowdns_servers": len(servers),
        "slowdns_networks": sum(1 for n in data["Networks"] if n.get("TunnelType") == "Slow DNS"),
        "distinct_tunnels": len(unique),
        "tunnel_types": {
            t: sum(1 for n in data["Networks"] if n.get("TunnelType") == t)
            for t in sorted({n.get("TunnelType") for n in data["Networks"]})
        },
    },
    "encryption": {
        "format": "base64( salt[16] || nonce[12] || AES-256-GCM ciphertext || tag[16] ), AAD = salt",
        "kdf": "Argon2id v19, t=3, m=8192 KiB, p=1, 32-byte key",
        "bundled_asset_and_protected_fields": "NurChickenPowder",
        "remote_updater": (
            "/4ssU0OjjtKH8AheiAxnc3DwSGDzsy+8 -- export framing inserts one "
            "random ASCII letter at index 3 after base64 (len%4==1)"
        ),
        "protected_fields": [
            "ServerIPHost", "SlowDNSHost", "SlowDNSKey", "OVPNUser", "OVPNPass",
            "UDP_obfs", "UDP_user", "CustomCertificate", "V2rayUUID", "V2rayPath",
            "H2pass", "TrojanPass", "Payload", "CustomProxy", "SNI", "BugDNS",
        ],
        "where": "libgojni.so github.com/2dust/AndroidLibXrayLite.EO/DO",
        "decoder_in_repo": "analysis-ultra/decrypt_config.py",
        "decoded_catalogue": "analysis-ultra/config-decoded.json",
        "remote_catalogue_url": "https://strongteam.co/api/ultrasystem/ultrav3.txt",
        "remote_catalogue_ua": "Ultra Tunnel",
    },
    "engine": {
        "mode": "slowdns (dnstt over DNS/UDP)",
        "binary": {"name": DNS_BIN, "size": 4912352, "abi": "arm64-v8a",
                   "origin": "lib/arm64-v8a/libdns.so inside Ultra Tunnel's XAPK",
                   "upstream": "stock dnstt client (uses www.bamsoftware.com/git/dnstt.git/dns)"},
        "argv_template": [DNS_BIN, "-udp", "<resolver>:53", "-pubkey", "<64-hex>",
                          "<domain>", LOCAL_FWD],
        "argv_example": argv_for("8.8.8.8", servers[0]["slowdns_pubkey_hex"],
                                 servers[0]["slowdns_domain"]),
        "flags": ["-udp ADDR", "-doh URL", "-dot ADDR", "-pubkey HEX64", "-pubkey-file FILE"],
        "not_present": ["-report (BD NET licence gate)", "-utls (BD NET camouflage)"],
        "source": "DNSTunnelThread.java run(): exec(libdns -udp <dnsKey>:53 -pubkey <chaveKey> <serverNameKey> 127.0.0.1:2222)",
        "prefs": {"dnsKey": "resolver", "chaveKey": "64-hex pubkey", "serverNameKey": "SlowDNS domain"},
    },
    "ports": {
        "dns_upstream": 53,
        "local_dnstt_forwarder": 2222,
        "ssl_tunnel_port": 443,
        "ssh_port": 22,
    },
    "resolvers": {
        "count": len(resolver_rows),
        "note": ("the app lets the user pick any of these; they are the DNS "
                 "recursors the Slow DNS networks are built around (many are "
                 "carrier/eSIM resolvers that answer to the tunnel domain)"),
        "list": resolver_rows,
    },
    "servers": servers,
    "launch_recipes": examples,
    "verification": {
        "decrypted_in_sandbox": True,
        "evidence": ["analysis-ultra/config-decoded.json",
                     "analysis-ultra/report/liveness.txt"],
        "live_dns_txt_probe": "see analysis-ultra/report/liveness.txt",
    },
}

with open(ARGS["dst"], "w", encoding="utf-8") as fh:
    json.dump(out, fh, ensure_ascii=False, indent=1)
print(f"wrote {ARGS['dst']}: {len(servers)} slowdns servers, "
      f"{len(unique)} distinct tunnels, {len(resolver_rows)} resolvers")
