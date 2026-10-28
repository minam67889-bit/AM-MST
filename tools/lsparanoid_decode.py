#!/usr/bin/env python3
"""LSParanoid string-table deobfuscator.

Why this exists
---------------
BD NET (`BDNET.VPN v106`) is obfuscated with LSParanoid. The generated class
`org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app` holds the ciphertext table
and delegates to `DeobfuscatorHelper.getString(long, String[])`.

jadx's decompilation of that helper is *wrong*: it rewrites the mask
`0xffff0000` as `-65536`, which sign-extends inside a `long` and keeps the
high 32 bits. The resulting string index is out of range, so every call throws
`InvocationTargetException` when replayed on a JVM. Compiling LSParanoid's
upstream sources also fails to help when the app was built with a different
release of the obfuscator.

This module is a literal port of LSParanoid's own algorithm (upstream
`RandomHelper` + `DeobfuscatorHelper`, plus the encoder in `StringRegistryImpl`
used only for the built-in round-trip self-test). Because the encoder is
included, `--selftest` proves the decoder is bit-exact instead of asserting it.

Usage
-----
    lsparanoid_decode.py --java <Deobfuscator$X.java> --scan <sources dir> \
                         --out decrypted.txt --hosts-out hosts.txt
    lsparanoid_decode.py --java <...> --ids-file ids.txt --selftest
"""

from __future__ import annotations

import argparse
import pathlib
import re
import sys

MAX_CHUNK_LENGTH = 0x1FFF  # DeobfuscatorHelper.MAX_CHUNK_LENGTH


# --------------------------------------------------------------------------
# 32/64-bit helpers. Java is explicit about widths; Python is not, so every
# intermediate value is truncated exactly where the JVM would truncate it.
# --------------------------------------------------------------------------
def i32(v: int) -> int:
    v &= 0xFFFFFFFF
    return v - 0x100000000 if v & 0x80000000 else v


def i64(v: int) -> int:
    v &= 0xFFFFFFFFFFFFFFFF
    return v - 0x10000000000000000 if v & 0x8000000000000000 else v


def i16(v: int) -> int:
    v &= 0xFFFF
    return v - 0x10000 if v & 0x8000 else v


def u64(v: int) -> int:
    return v & 0xFFFFFFFFFFFFFFFF


def rotl(x: int, k: int) -> int:
    """Java: (short)((x << k) | (x >>> (32 - k))) with x a sign-extended short."""
    shifted = i32(x << k) & 0xFFFFFFFF
    logical = (x & 0xFFFFFFFF) >> (32 - k)
    return i16(shifted | logical)


# --------------------------------------------------------------------------
# RandomHelper
# --------------------------------------------------------------------------
def seed(x: int) -> int:
    x = i64(x)
    z = i64(i64(x ^ (u64(x) >> 33)) * 0x62A9D9ED799705F5)
    return u64(i64(i64(z ^ (u64(z) >> 28)) * 0xCB24D0A5C88C35B3)) >> 32


def next_state(state: int) -> int:
    s0 = i16(state)
    s1 = i16(u64(state) >> 16)
    n = i16(s0 + s1)
    n = rotl(n, 9)
    n = i16(n + s0)
    s1 = i16(s1 ^ s0)
    s0 = rotl(s0, 13)
    s0 = i16(s0 ^ s1)
    s0 = i16(s0 ^ i16(s1 << 5))
    s1 = rotl(s1, 10)
    res = i64(n)
    res = i64(res << 16)
    res = i64(res | s1)
    res = i64(res << 16)
    res = i64(res | s0)
    return res


# --------------------------------------------------------------------------
# DeobfuscatorHelper
# --------------------------------------------------------------------------
def get_char_at(index: int, chunks: list[str], state: int) -> int:
    nxt = next_state(state)
    chunk = chunks[index // MAX_CHUNK_LENGTH]
    return i64(nxt ^ i64(ord(chunk[index % MAX_CHUNK_LENGTH]) << 32))


def get_string(sid: int, chunks: list[str]) -> str:
    state = seed(i64(sid) & 0xFFFFFFFF)
    state = next_state(state)
    low = (u64(state) >> 32) & 0xFFFF
    state = next_state(state)
    high = (u64(state) >> 16) & 0xFFFF0000
    index = i32((i64(sid) >> 32) ^ low ^ high) & 0xFFFFFFFF
    state = get_char_at(index, chunks, state)
    length = (u64(state) >> 32) & 0xFFFF
    out = []
    for i in range(length):
        state = get_char_at(index + i + 1, chunks, state)
        out.append(chr((u64(state) >> 32) & 0xFFFF))
    return "".join(out)


# --------------------------------------------------------------------------
# Encoder (StringRegistryImpl) - only used by --selftest.
# --------------------------------------------------------------------------
def encode(strings: list[str], seed32: int) -> tuple[list[int], list[str]]:
    s0 = seed32 & 0xFFFFFFFF
    buf: list[str] = []
    ids: list[int] = []
    for text in strings:
        mask = 0
        state = seed(s0)
        state = next_state(state)
        mask |= u64(state) & 0xFFFF00000000
        state = next_state(state)
        mask |= (u64(state) & 0xFFFF00000000) << 16
        index = len(buf)
        sid = i64(s0 | ((index << 32) ^ i64(mask)))
        state = next_state(state)
        buf.append(chr(((u64(state) >> 32) & 0xFFFF) ^ len(text)))
        for ch in text:
            state = next_state(state)
            buf.append(chr(((u64(state) >> 32) & 0xFFFF) ^ ord(ch)))
        ids.append(sid)
    joined = "".join(buf)
    return ids, [joined[i:i + MAX_CHUNK_LENGTH] for i in range(0, len(joined), MAX_CHUNK_LENGTH)]


# --------------------------------------------------------------------------
# Chunk-table extraction from jadx output
# --------------------------------------------------------------------------
_JAVA_ESCAPES = {"n": "\n", "t": "\t", "r": "\r", "b": "\b", "f": "\f", "0": "\0", "s": " "}


def _unescape(lit: str) -> str:
    out: list[str] = []
    i = 0
    while i < len(lit):
        ch = lit[i]
        if ch != "\\":
            out.append(ch)
            i += 1
            continue
        nxt = lit[i + 1]
        i += 2
        if nxt == "u":
            out.append(chr(int(lit[i:i + 4], 16)))
            i += 4
        else:
            out.append(_JAVA_ESCAPES.get(nxt, nxt))
    return "".join(out)


def load_chunks(java_path: pathlib.Path) -> list[str]:
    src = java_path.read_text(encoding="utf-8", errors="replace")
    marker = "String[] chunks = {"
    pos = src.find(marker)
    if pos < 0:
        marker = "chunks = {"
        pos = src.find(marker)
    if pos < 0:
        raise SystemExit(f"no chunks array literal in {java_path}")
    body = src[pos + len(marker):]
    body = body[:body.index("};")]
    literals = re.findall(r'"((?:[^"\\]|\\.)*)"', body)
    return [_unescape(lit) for lit in literals]


def scan_ids(sources: pathlib.Path) -> set[int]:
    ids: set[int] = set()
    pattern = re.compile(r"\$app\.getString\((-?\d+)L?\)")
    for path in sources.rglob("*.java"):
        try:
            ids.update(int(m) for m in pattern.findall(path.read_text(encoding="utf-8", errors="replace")))
        except OSError:
            continue
    return ids


HOST_RE = re.compile(
    r"\b([a-z0-9][a-z0-9-]{1,62}(?:\.[a-z0-9-]{1,62})+\.(?:com|net|org|io|ir|ru|xyz|top|site|"
    r"online|vip|app|dev|cloud|link|live|pro|fun|info|tech|store|club|host|space|icu|cyou|cfd|"
    r"click|shop|press|world|life|today|network|digital|sbs|bond|rest|bar|me|co|tk|ml|ga|cf|gq))\b",
    re.IGNORECASE,
)

URL_RE = re.compile(r"https?://[A-Za-z0-9._~:/?#@!$&'()*+,;=%-]{4,200}")


def selftest() -> None:
    sample = [
        "https://example.com/tunnel",
        "dns.example.org",
        "a" * 500,
        "",
        "\u0633\u0631\u0648\u0631",
        "bdnet.vpn",
        "x" * 9000,
    ]
    ids, chunks = encode(sample, 0xDEADBEEF)
    failures = 0
    for original, sid in zip(sample, ids):
        got = get_string(sid, chunks)
        if got != original:
            failures += 1
            print(f"SELFTEST FAIL id={sid} want={original[:40]!r} got={got[:40]!r}")
    print(f"SELFTEST {'PASS' if failures == 0 else 'FAIL'} ({len(sample) - failures}/{len(sample)} strings, "
          f"{len(chunks)} chunk(s), multi-chunk={'yes' if len(chunks) > 1 else 'no'})")
    if failures:
        raise SystemExit(1)


def main(argv: list[str]) -> int:
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("--java", type=pathlib.Path, help="jadx output of the generated Deobfuscator$*.java")
    ap.add_argument("--scan", type=pathlib.Path, help="jadx sources tree to harvest getString(<id>) ids from")
    ap.add_argument("--ids", help="comma separated ids")
    ap.add_argument("--ids-file", type=pathlib.Path, help="file with one id per line")
    ap.add_argument("--out", type=pathlib.Path, help="write 'id<TAB>decoded' lines here")
    ap.add_argument("--hosts-out", type=pathlib.Path, help="write unique hostnames found in the plaintext here")
    ap.add_argument("--selftest", action="store_true", help="verify the port against LSParanoid's encoder")
    args = ap.parse_args(argv)

    if args.selftest:
        selftest()

    if not args.java:
        if args.selftest:
            return 0
        ap.error("--java is required")

    chunks = load_chunks(args.java)
    total_chars = sum(len(c) for c in chunks)

    ids: set[int] = set()
    if args.scan:
        ids |= scan_ids(args.scan)
    if args.ids_file and args.ids_file.exists():
        for line in args.ids_file.read_text(errors="replace").splitlines():
            line = line.strip()
            if re.fullmatch(r"-?\d+", line):
                ids.add(int(line))
    if args.ids:
        ids |= {int(x) for x in args.ids.split(",") if x.strip()}

    header = [
        "# LSParanoid string table - decrypted by tools/lsparanoid_decode.py",
        f"# chunks={len(chunks)} chunk_chars={total_chars} ids={len(ids)}",
    ]
    decoded: list[tuple[int, str]] = []
    errors = 0
    for sid in sorted(ids):
        try:
            decoded.append((sid, get_string(sid, chunks)))
        except Exception as exc:  # a wrong id usually lands outside the table
            errors += 1
            decoded.append((sid, f"#ERR {type(exc).__name__}: {exc}"))

    clean = [(i, s) for i, s in decoded if not s.startswith("#ERR")]
    header.append(f"# decoded={len(clean)} errors={errors}")

    lines = header + [f"{sid}\t{text}" for sid, text in decoded]
    blob = "\n".join(lines) + "\n"
    if args.out:
        args.out.parent.mkdir(parents=True, exist_ok=True)
        args.out.write_text(blob, encoding="utf-8", errors="replace")
        print(f"wrote {args.out} ({len(lines)} lines)")
    else:
        sys.stdout.write(blob)

    hosts = sorted({m.group(1).lower() for _, text in clean for m in HOST_RE.finditer(text)})
    urls = sorted({m.group(0) for _, text in clean for m in URL_RE.finditer(text)})
    if args.hosts_out:
        args.hosts_out.parent.mkdir(parents=True, exist_ok=True)
        args.hosts_out.write_text("\n".join(hosts) + ("\n" if hosts else ""), encoding="utf-8")
        print(f"wrote {args.hosts_out} ({len(hosts)} hosts)")

    print(f"chunks={len(chunks)} ids={len(ids)} decoded={len(clean)} errors={errors}")
    for u in urls:
        print(f"URL {u}")
    for h in hosts:
        print(f"HOST {h}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
