#!/usr/bin/env python3
"""Decrypt a BD NET config bundle (`sorter.json`, `JSONDEC2025`, ...).

A bundle is base64 text wrapping an **XXTEA** ciphertext.  The Java side is
`defpackage/AbstractC4569ym`:

    c(String s, String key) = new String(b(W80.m(s), key.getBytes("UTF-8")), "UTF-8")

where `b()` is XXTEA decrypt with a *non-standard delta* (-1638454863, i.e.
0x9E5729B1 rather than 0x9E3779B9) and the key is the literal string stored at
`AbstractC4569ym.a`, id -164539529000843 = `...|...` (7 chars, zero-padded to
16 bytes).  The plaintext length rides in the last 32-bit word instead of
PKCS padding, so `f(v, true)` validates it against `4n-7 .. 4n-4`.

Inside the decrypted JSON every `*Hosts`/`server_host`/`SRanges` field is
`hex(xor(plaintext, key))` with the same 12-byte key the native `xorWithKey`
uses, cycle starting at offset 0:

    34 25 50 64 58 63 68 3e 66 6b 50 5d        "4%PdXch>fkP]"

Usage::

    python3 tools/bdnet_sorter.py bundle.b64 --out configs/
    python3 tools/bdnet_sorter.py --selftest

Exit status is 0 only when the bundle decrypts and at least one server entry
has a deobfuscated host.
"""

from __future__ import annotations

import argparse
import base64
import binascii
import json
import pathlib
import re
import struct
import sys

DELTA = (1 << 32) - 1638454863          # 0x9E5729B1, not the textbook 0x9E3779B9
M32 = 0xFFFFFFFF
XXTEA_KEY = b"...|..." + b"\x00" * 9     # AbstractC4569ym.a, zero padded to 16
FIELD_KEY = bytes.fromhex("342550645863683e666b505d")


# --------------------------------------------------------------------------- #
# XXTEA (AbstractC4569ym.b / .f / .g)
# --------------------------------------------------------------------------- #
def xxtea_decrypt(data: bytes, key: bytes = XXTEA_KEY) -> bytes | None:
    if len(data) < 8 or len(data) % 4:
        return None
    n = len(data) // 4
    v = list(struct.unpack("<%dI" % n, data))
    k = list(struct.unpack("<4I", key[:16].ljust(16, b"\x00")))
    rounds = 6 + 52 // n
    total = (rounds * DELTA) & M32
    y = v[0]
    for _ in range(rounds):
        e = (total >> 2) & 3
        p = n - 1
        while p > 0:
            z = v[p - 1]
            mx = (((total ^ y) + (k[(p & 3) ^ e] ^ z))
                  ^ (((z >> 5) ^ ((y << 2) & M32)) + ((y >> 3) ^ ((z << 4) & M32)))) & M32
            v[p] = (v[p] - mx) & M32
            y = v[p]
            p -= 1
        z = v[n - 1]
        mx = (((total ^ y) + (k[e] ^ z))
              ^ (((z >> 5) ^ ((y << 2) & M32)) + ((y >> 3) ^ ((z << 4) & M32)))) & M32
        v[0] = (v[0] - mx) & M32
        y = v[0]
        total = (total - DELTA) & M32
    true_len = v[n - 1]
    if not (n * 4 - 7 <= true_len <= n * 4 - 4):
        return None
    return bytes((v[i >> 2] >> ((i & 3) << 3)) & 0xFF for i in range(true_len))


def decrypt_bundle(path: pathlib.Path) -> bytes | None:
    raw = re.sub(rb"\s+", b"", path.read_bytes())
    try:
        blob = base64.b64decode(raw + b"=" * (-len(raw) % 4))
    except binascii.Error:
        return None
    return xxtea_decrypt(blob)


# --------------------------------------------------------------------------- #
# field deobfuscation
# --------------------------------------------------------------------------- #
def deobfuscate(value: str) -> str:
    """hex -> xor with the 12-byte libputils key -> text ('' when not hex)."""
    if not value or len(value) % 2:
        return ""
    try:
        blob = binascii.unhexlify(value)
    except binascii.Error:
        return ""
    return bytes(b ^ FIELD_KEY[i % 12] for i, b in enumerate(blob)).decode("utf-8", "replace")


PLACEHOLDERS = {"[cdnh]", "[sip]", "[sr]", "auto", ""}


def split_hosts(host: str) -> list[str]:
    if host in PLACEHOLDERS:
        return [host]
    return [h for h in host.split(";") if h]


# --------------------------------------------------------------------------- #
# extraction
# --------------------------------------------------------------------------- #
CATEGORY_FILE = {
    "ocsslowdns": "slowdns",
    "ocsfastdns": "fastdns",
    "ocsudp": "udpq",
    "ocskp": "kp",
    "ocskpnormal": "kpn-normal",
    "ocskpcf": "kpn-cf",
    "ocspsiphon": "psiphon",
    "ocsxray": "xray",
    "ocsshadow": "shadowsocks",
    "ocsv2ray": "v2ray",
}


def extract(bundle: dict) -> dict:
    servers = []
    for section in ("Free_servers", "Premium_servers", "Vip_servers", "Private_servers"):
        for entry in bundle.get(section, []):
            host_field = entry.get("server_host", "")
            decoded = deobfuscate(host_field) if host_field not in PLACEHOLDERS else host_field
            servers.append({
                "section": section,
                "name": entry.get("server_name", ""),
                "category": entry.get("category", ""),
                "mode": CATEGORY_FILE.get(entry.get("category", ""), entry.get("category", "")),
                "port": entry.get("server_port", ""),
                "udp_port": entry.get("server_udp_port", ""),
                "ssl_port": entry.get("ssl_port", ""),
                "protected": entry.get("server_protected", ""),
                "hosts": split_hosts(decoded),
                "host_raw": host_field,
            })

    payloads = []
    for entry in bundle.get("Payloads", []):
        payloads.append({
            "name": entry.get("friendly_name", ""),
            "category": entry.get("category", ""),
            "host": deobfuscate(entry.get("host", "")) or entry.get("host", ""),
            "port": entry.get("port", ""),
            "query": entry.get("query", ""),
            "payload": deobfuscate(entry.get("payload", "")),
            "sausage": deobfuscate(entry.get("sausage", "")),
            "isHostSni": entry.get("isHostSni"),
            "isHostResolve": entry.get("isHostResolve"),
        })

    def hostlist(field: str) -> list[str]:
        field = bundle.get(field, "") or ""
        return [deobfuscate(h) for h in field.split(";") if h]

    return {
        "version": bundle.get("Version"),
        "udp_version": bundle.get("UDPVersion"),
        "pdnsd_type": bundle.get("PdnsdType"),
        "changelogs": bundle.get("Changelogs"),
        "servers": servers,
        "payloads": payloads,
        "cdnhosts": hostlist("CDNHosts"),
        "fronthosts": hostlist("FrontHosts"),
        "backhosts": hostlist("BackHosts"),
        # SIPs are plain dotted-quad addresses; SRanges are obfuscated.
        "sips": [s for s in (bundle.get("SIPs", "") or "").split(";") if s],
        "sranges": [deobfuscate(s) for s in (bundle.get("SRanges", "") or "").split(";") if s],
        "blocked_apps": [a for a in (bundle.get("BlockedApps", "") or "").split(";") if a],
    }


def write_outputs(data: dict, outdir: pathlib.Path) -> None:
    outdir.mkdir(parents=True, exist_ok=True)
    (outdir / "servers.json").write_text(
        json.dumps(data["servers"], indent=2, ensure_ascii=False) + "\n", encoding="utf-8")
    (outdir / "payloads.json").write_text(
        json.dumps(data["payloads"], indent=2, ensure_ascii=False) + "\n", encoding="utf-8")
    by_mode: dict[str, set[str]] = {}
    for srv in data["servers"]:
        if srv["hosts"] in (["[sip]"], ["[cdnh]"], ["[sr]"], ["auto"]):
            continue
        by_mode.setdefault(srv["mode"], set()).update(srv["hosts"])
    for mode, hosts in by_mode.items():
        (outdir / f"{mode or 'other'}.txt").write_text(
            "\n".join(sorted(hosts)) + "\n", encoding="utf-8")
    (outdir / "cdnhosts.txt").write_text("\n".join(data["cdnhosts"]) + "\n", encoding="utf-8")
    (outdir / "sips.txt").write_text("\n".join(data["sips"]) + "\n", encoding="utf-8")


SELFTEST_EXPECT = {
    "slowdns": "de1.liftmeon.org",
    "kpn-cf": "d34s3y8bmu8jw7.cloudfront.net",
    "cdnhosts": "1001freefonts.com",
}


def selftest() -> int:
    """Decrypt every bundle we ship and check known-good values in each."""
    here = pathlib.Path(__file__).resolve().parent.parent
    candidates = []
    asset = here / "analysis-bdnet" / "assets" / "assets_sorter.json"
    if asset.exists():
        candidates.append(asset)
    candidates += sorted((here / "analysis-bdnet" / "configs").glob("*.b64"))
    if not candidates:
        print("selftest: no bundle available — skipped")
        return 0
    total = passed_all = 0
    for bundle_path in candidates:
        plain = decrypt_bundle(bundle_path)
        if plain is None:
            print(f"{bundle_path.name}: did not decrypt")
            return 1
        data = extract(json.loads(plain.decode("utf-8")))
        by_mode: dict[str, set[str]] = {}
        for srv in data["servers"]:
            by_mode.setdefault(srv["mode"], set()).update(srv["hosts"])
        checks = {
            "slowdns": SELFTEST_EXPECT["slowdns"] in by_mode.get("slowdns", set()),
            "kpn-cf": SELFTEST_EXPECT["kpn-cf"] in by_mode.get("kpn-cf", set()),
            # the live bundle moved fronting hosts out of CDNHosts
            "cdnhosts": (not data["cdnhosts"]) or SELFTEST_EXPECT["cdnhosts"] in data["cdnhosts"],
            "servers": len(data["servers"]) >= 15 and len(by_mode.get("udpq", set())) >= 100,
            "payloads": len(data["payloads"]) >= 50,
        }
        ok = all(checks.values())
        total += 1
        passed_all += ok
        detail = " ".join(f"{n}={'PASS' if v else 'FAIL'}" for n, v in checks.items())
        print(f"{bundle_path.name:24s} v{data['version']!s:6s} {detail}")
    print(f"SELFTEST {'PASS' if passed_all == total else 'FAIL'} ({passed_all}/{total} bundles)")
    return 0 if passed_all == total else 1


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    ap.add_argument("bundle", nargs="?", type=pathlib.Path, help="base64 bundle file")
    ap.add_argument("-o", "--out", type=pathlib.Path, help="write extracted configs here")
    ap.add_argument("--json", action="store_true", help="also write the raw decrypted JSON")
    ap.add_argument("--selftest", action="store_true")
    args = ap.parse_args(argv)

    if args.selftest:
        return selftest()
    if not args.bundle:
        ap.error("bundle is required unless --selftest is used")

    plain = decrypt_bundle(args.bundle)
    if plain is None:
        print(f"{args.bundle}: XXTEA failed (bad key, bad base64 or length guard)", file=sys.stderr)
        return 1
    bundle = json.loads(plain.decode("utf-8"))
    data = extract(bundle)

    print(f"bundle        : {args.bundle} ({len(plain)} bytes plaintext)")
    print(f"version       : {data['version']!r}  udp={data['udp_version']!r}  "
          f"pdnsd={data['pdnsd_type']!r}")
    print(f"servers       : {len(data['servers'])}")
    for srv in data["servers"]:
        head = srv["hosts"][0] if srv["hosts"] else ""
        extra = f" (+{len(srv['hosts']) - 1} more)" if len(srv["hosts"]) > 1 else ""
        print(f"  {srv['name'][:26]:28s} {srv['mode']:14s} {srv['port'] or '-':>4s} "
              f"{head}{extra}")
    print(f"payloads      : {len(data['payloads'])}")
    print(f"cdn hosts     : {len(data['cdnhosts'])}")
    print(f"proxy ips     : {len(data['sips'])}")

    if args.out:
        write_outputs(data, args.out)
        if args.json:
            (args.out / "bundle_decrypted.json").write_text(
                json.dumps(bundle, indent=2, ensure_ascii=False) + "\n", encoding="utf-8")
        print(f"wrote         : {args.out}/")

    usable = [s for s in data["servers"]
              if s["hosts"] and s["hosts"][0] not in PLACEHOLDERS]
    return 0 if usable else 1


if __name__ == "__main__":
    sys.exit(main())
