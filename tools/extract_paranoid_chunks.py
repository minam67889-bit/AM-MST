#!/usr/bin/env python3
"""Pull the LSParanoid chunk array out of apktool smali.

jadx often refuses to decompile the generated `Deobfuscator$X$app` class, but
apktool always produces its smali. The class fills `static final String[] a`
in `<clinit>` with a run of `const-string` instructions; that run, in order, is
exactly the chunk table the decoder needs.

Usage: extract_paranoid_chunks.py <smali-dir> <out-file>
"""
from __future__ import annotations

import pathlib
import re
import sys

CONST = re.compile(r'^\s*const-string(?:/jumbo)?\s+v\d+,\s*"(.*)"\s*$', re.M)


def unescape(lit: str) -> str:
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
        if nxt == "n":
            out.append("\n")
        elif nxt == "t":
            out.append("\t")
        elif nxt == "r":
            out.append("\r")
        elif nxt == "u":
            out.append(chr(int(lit[i:i + 4], 16)))
            i += 4
        else:
            out.append(nxt)
    return "".join(out)


def main() -> None:
    root = pathlib.Path(sys.argv[1])
    out = pathlib.Path(sys.argv[2])
    candidates = sorted(root.rglob("Deobfuscator*app.smali"))
    candidates.sort(key=lambda p: p.stat().st_size, reverse=True)
    if not candidates:
        raise SystemExit("no Deobfuscator smali found")
    path = candidates[0]
    text = path.read_text(errors="replace")
    start = text.find(".method static constructor <clinit>()V")
    if start < 0:
        raise SystemExit("no <clinit> in " + str(path))
    end = text.find(".end method", start)
    body = text[start:end]
    chunks = [unescape(m.group(1)) for m in CONST.finditer(body) for _ in [0]]
    # Only the chunk table matters; ids/labels are short, chunks are long.
    long_chunks = [c for c in chunks if len(c) >= 1024]
    keep = long_chunks or chunks
    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_text("\n".join(keep) + "\n", encoding="utf-8")
    print(f"{path}: {len(chunks)} const-strings, kept {len(keep)} "
          f"(sizes {[len(c) for c in keep][:6]}) -> {out}")


if __name__ == "__main__":
    main()
