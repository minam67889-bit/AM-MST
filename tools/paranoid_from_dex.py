#!/usr/bin/env python3
"""Recover an LSParanoid string table straight from the dex files.

Why: jadx frequently refuses to decompile the generated
`org.lsposed.lsparanoid.Deobfuscator$X$app` class, and apktool is not always
available. The chunk table is nevertheless plain data: a handful of very long
base64-ish string constants in the dex string pool. This script

  1. parses every `classes*.dex` string table (no external deps),
  2. picks the long printable constants (candidate chunks),
  3. tries every ordering of them (only a few chunks exist in practice),
  4. keeps the ordering whose decode yields readable text for a sample of ids,
  5. writes the `id<TAB>text` table plus a hosts file.

Usage: paranoid_from_dex.py <apk-or-dir> <ids-file> <out.tsv> [hosts-out]
"""
from __future__ import annotations

import itertools
import pathlib
import re
import struct
import sys
import zipfile

MAX_CHUNK_LENGTH = 0x1FFF
PRINTABLE = re.compile(r"^[ -~\t]{0,}$")


# ---------------------------------------------------------------- dex parsing
def dex_strings(blob: bytes) -> list[str]:
    if blob[:4] != b"dex\n":
        # A dex embedded in an apk may be compressed/obfuscated; skip quietly.
        return []
    (string_ids_size, string_ids_off) = struct.unpack_from("<II", blob, 56)
    if not (0 < string_ids_size < 4_000_000 and string_ids_off < len(blob)):
        return []
    out: list[str] = []
    for i in range(string_ids_size):
        try:
            (off,) = struct.unpack_from("<I", blob, string_ids_off + i * 4)
            pos = off
            # uleb128 utf16 length
            while blob[pos] & 0x80:
                pos += 1
            pos += 1
            end = blob.index(b"\x00", pos)
            raw = blob[pos:end]
        except (struct.error, IndexError, ValueError):
            continue
        try:
            out.append(raw.decode("utf-8", errors="replace"))
        except Exception:  # noqa: BLE001
            continue
    return out


def all_strings(path: pathlib.Path) -> list[str]:
    strings: list[str] = []
    if path.is_dir():
        for dex in sorted(path.rglob("classes*.dex")):
            strings += dex_strings(dex.read_bytes())
        return strings
    if zipfile.is_zipfile(path):
        with zipfile.ZipFile(path) as zf:
            for name in zf.namelist():
                if re.fullmatch(r"classes\d*\.dex", name):
                    strings += dex_strings(zf.read(name))
    return strings


# ------------------------------------------------- decoder port (verbatim)
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


# ---------------------------------------------------------------- main
def score(chunks: list[str], ids: list[int]) -> float:
    """Fraction of sampled ids that decode to plausible text."""
    good = 0
    total = 0
    for sid in ids:
        total += 1
        try:
            text = get_string(sid, chunks)
        except Exception:  # noqa: BLE001
            continue
        if not PRINTABLE.match(text):
            continue
        s = text.strip()
        if not s:
            good += 1                      # empty strings are legitimate
            continue
        alnum = sum(ch.isalnum() or ch in " .:/_-@%+?=&" for ch in s)
        if alnum / len(s) > 0.9 and len(s) < 2000:
            good += 1
    return good / total if total else 0.0


def main() -> None:
    src = pathlib.Path(sys.argv[1])
    ids_file = pathlib.Path(sys.argv[2])
    out = pathlib.Path(sys.argv[3])
    hosts_out = pathlib.Path(sys.argv[4]) if len(sys.argv) > 4 else None

    ids = sorted({int(line.strip()) for line in ids_file.read_text().splitlines()
                  if re.fullmatch(r"-?\d+", line.strip())})
    print(f"ids: {len(ids)}")

    strings = all_strings(src)
    print(f"dex strings: {len(strings)}")
    candidates = [s for s in strings
                  if len(s) >= 1024 and len(s) <= MAX_CHUNK_LENGTH + 8
                  and re.fullmatch(r"[A-Za-z0-9+/=]+", s)]
    candidates = sorted(set(candidates), key=len, reverse=True)
    print(f"chunk candidates: {len(candidates)} sizes={[len(c) for c in candidates][:8]}")
    if not candidates:
        raise SystemExit("no chunk candidates")
    if len(candidates) > 6:
        candidates = candidates[:6]

    sample = ids[:40] or [0]
    best = (0.0, None)
    for perm in itertools.permutations(candidates):
        s = score(list(perm), sample)
        if s > best[0]:
            best = (s, perm)
        if s == 1.0:
            break
    print(f"best ordering score: {best[0]:.3f} with {len(best[1])} chunks")
    if best[1] is None:
        raise SystemExit("could not order the chunks")
    chunks = list(best[1])

    rows = []
    for sid in ids:
        try:
            rows.append(f"{sid}\t{get_string(sid, chunks)}")
        except Exception as exc:  # noqa: BLE001
            rows.append(f"{sid}\t#ERR {type(exc).__name__}")
    rows = [r for r in rows if "#ERR" not in r]
    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_text("\n".join(rows) + "\n", encoding="utf-8", errors="replace")
    print(f"wrote {out} ({len(rows)} strings)")

    hosts = sorted({m.group(1).lower() for _, text in
                    (r.split("\t", 1) for r in rows)
                    for m in re.finditer(
                        r"\b([a-z0-9][a-z0-9.-]{2,60}\.(?:com|net|org|io|xyz|top|site|online|"
                        r"app|dev|cloud|link|live|pro|fun|info|tech|store|club|space|icu|"
                        r"click|shop|world|life|sbs|me|co|tk|ml|ga|cf|gq))\b", text, re.I)})
    if hosts_out:
        hosts_out.write_text("\n".join(hosts) + ("\n" if hosts else ""), encoding="utf-8")
        print(f"{len(hosts)} hosts")


if __name__ == "__main__":
    main()
