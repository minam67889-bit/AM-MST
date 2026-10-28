#!/usr/bin/env python3
"""Static analysis of the AM Tunnel APK.

Runs where a JDK / Android SDK / internet connection exist (GitHub Actions
runner). Produces a compact, text-only report that can be committed back to the
repository, plus a much larger artifact for deeper digging.

Usage:
    python3 tools/apk_analysis.py --apk app.apk --out analysis
"""

import argparse
import collections
import hashlib
import json
import os
import re
import subprocess
import sys
import zipfile

TLDS = (
    "com|net|org|io|me|xyz|top|site|online|vip|app|dev|cloud|link|live|pro|cc|tk|"
    "ru|ir|info|tech|store|fun|space|website|icu|cyou|cfd|click|shop|club|host|"
    "press|world|life|today|network|digital|sbs|bond|rest|bar|monster|quest|buzz|"
    "work|one|mobi|asia|in|uk|de|fr|nl|se|no|fi|pl|tr|ae|sa|id|my|sg|hk|jp|kr|br"
)
DOMAIN_RE = re.compile(r"\b((?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\.)+(?:" + TLDS + r"))\b", re.I)
URL_RE = re.compile(r"https?://[^\s\"'<>\\]{4,240}")

KEYWORDS = [
    "dns", "txt", "query", "qname", "base36", "base64", "chunk", "fragment",
    "session", "cookie", "handshake", "socks", "tunnel", "resolver", "mtu",
    "packet", "encrypt", "chacha", "aes", "xor", "zstd", "lz4", "compress",
    "doh", "dot", "udp", "vpn", "slowdns", "masterdns", "dnstt", "shadowsocks",
    "wireguard", "openvpn", "onion", "authoritative", "cname", "edns", "tcp",
    "stream", "sequence", "ack", "verify", "codec", "cipher", "nonce", "key",
]

PRINTABLE = re.compile(rb"[\x20-\x7e]{4,}")
UTF16 = re.compile(rb"(?:[\x20-\x7e]\x00){4,}")
CLASS_RE = re.compile(r"^L([\w/$]+);$")


def sh(cmd, timeout=900):
    proc = subprocess.run(cmd, shell=isinstance(cmd, str), capture_output=True,
                          text=True, timeout=timeout)
    return proc.returncode, proc.stdout or "", proc.stderr or ""


def sha256(path):
    digest = hashlib.sha256()
    with open(path, "rb") as handle:
        for block in iter(lambda: handle.read(1 << 20), b""):
            digest.update(block)
    return digest.hexdigest()


def extract_strings(blob):
    out = []
    for match in PRINTABLE.finditer(blob):
        out.append(match.group().decode("ascii", "ignore"))
    for match in UTF16.finditer(blob):
        out.append(match.group().decode("utf-16-le", "ignore").strip())
    return out


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--apk", required=True)
    parser.add_argument("--extra-apk", action="append", default=[],
                        help="additional split APKs whose native libs/assets are also mined")
    parser.add_argument("--out", default="analysis")
    args = parser.parse_args()

    out = args.out
    os.makedirs(out, exist_ok=True)
    apk = args.apk

    report = {
        "apk": os.path.basename(apk),
        "size": os.path.getsize(apk),
        "sha256": sha256(apk),
    }

    # ---------------------------------------------------------------- zip view
    with zipfile.ZipFile(apk) as archive:
        entries = [(i.filename, i.file_size, i.compress_size) for i in archive.infolist()]
        dex_files = [n for n, _, _ in entries if re.match(r"^classes\d*\.dex$", n)]
        native_libs = [n for n, _, _ in entries if n.startswith("lib/") and n.endswith(".so")]
        assets = [n for n, _, _ in entries if n.startswith("assets/")]
        raw = [n for n, _, _ in entries if n.startswith("res/raw")]
        report.update({
            "entries": len(entries),
            "dex": dex_files,
            "native_libs": native_libs,
            "assets": assets[:200],
            "res_raw": raw[:200],
        })
        with open(os.path.join(out, "apk-files.txt"), "w") as handle:
            for name, size, packed in sorted(entries, key=lambda e: -e[1]):
                handle.write(f"{size:>10}  {packed:>10}  {name}\n")

        dex_blobs = {name: archive.read(name) for name in dex_files}
        asset_blobs = {}
        for name in assets + raw:
            try:
                blob = archive.read(name)
            except Exception:
                continue
            asset_blobs[name] = blob

    # ---------------------------------------------------------------- strings
    per_source = {}
    all_strings = []
    for name, blob in dex_blobs.items():
        found = extract_strings(blob)
        per_source[name] = len(found)
        all_strings.extend(found)
    for name, blob in asset_blobs.items():
        all_strings.extend(extract_strings(blob))
    native_blobs = {}
    with zipfile.ZipFile(apk) as archive:
        for name in native_libs:
            try:
                native_blobs[f"{os.path.basename(apk)}!{name}"] = archive.read(name)
            except Exception:
                pass
    extra_libs = []
    for extra in args.extra_apk:
        try:
            with zipfile.ZipFile(extra) as archive:
                names = [n for n in archive.namelist() if n.endswith(".so")]
                extra_libs.extend(names)
                for name in names:
                    native_blobs[f"{os.path.basename(extra)}!{name}"] = archive.read(name)
        except Exception as exc:
            print(f"warning: cannot read split {extra}: {exc}")
    report["native_libs_extra"] = len(extra_libs)
    for blob in native_blobs.values():
        all_strings.extend(extract_strings(blob))
    report["raw_strings"] = len(all_strings)
    report["strings_per_dex"] = per_source

    unique = sorted(set(s.strip() for s in all_strings if len(s.strip()) >= 4))
    with open(os.path.join(out, "strings-all.txt"), "w", errors="replace") as handle:
        handle.write("\n".join(unique))

    domains = collections.Counter()
    urls = collections.Counter()
    for value in unique:
        for match in DOMAIN_RE.finditer(value):
            domains[match.group(1).lower()] += 1
        for match in URL_RE.finditer(value):
            urls[match.group(0)] += 1

    with open(os.path.join(out, "domains.txt"), "w") as handle:
        for domain, count in domains.most_common():
            handle.write(f"{count:>5}  {domain}\n")
    with open(os.path.join(out, "urls.txt"), "w") as handle:
        for url, count in urls.most_common():
            handle.write(f"{count:>5}  {url}\n")

    keyword_hits = collections.defaultdict(list)
    for value in unique:
        low = value.lower()
        for keyword in KEYWORDS:
            if keyword in low and len(value) < 200:
                keyword_hits[keyword].append(value)
                break
    with open(os.path.join(out, "keywords.txt"), "w", errors="replace") as handle:
        for keyword in KEYWORDS:
            hits = keyword_hits.get(keyword) or []
            handle.write(f"\n### {keyword} ({len(hits)})\n")
            for value in hits[:150]:
                handle.write(f"  {value}\n")

    # ------------------------------------------------------- deleted-file hints
    with open(os.path.join(out, "assets.txt"), "w", errors="replace") as handle:
        for name, blob in asset_blobs.items():
            if name.endswith((".dex", ".prof", ".profm", ".so")):
                handle.write(f"\n=== {name} ({len(blob)} B) binary, skipped ===\n")
                continue
            handle.write(f"\n=== {name} ({len(blob)} B) ===\n")
            try:
                handle.write(blob[:4000].decode("utf-8", "replace"))
            except Exception:
                handle.write(repr(blob[:400]))
            handle.write("\n")

    # ------------------------------------------------------------- java classes
    class_names = set()
    for name, blob in dex_blobs.items():
        for value in extract_strings(blob):
            match = CLASS_RE.match(value.strip())
            if match:
                class_names.add(match.group(1).replace("/", "."))
    with open(os.path.join(out, "classes.txt"), "w") as handle:
        handle.write("\n".join(sorted(class_names)))

    with open(os.path.join(out, "summary.json"), "w") as handle:
        json.dump(report, handle, indent=2)

    print(json.dumps({k: v for k, v in report.items() if k != "assets"}, indent=2)[:4000])
    print(f"domains: {len(domains)}  urls: {len(urls)}  classes: {len(class_names)}")


if __name__ == "__main__":
    sys.exit(main())
