#!/usr/bin/env python3
"""Harvest LSParanoid string ids from apktool smali.

jadx only shows the ids of the classes it managed to decompile. In smali every
call site exists, but the id is not a literal: it is loaded into a register
first.

    const-wide v0, 0x00a6b1f0c7d2e4b4L
    invoke-static {v0, v1}, Lorg/lsposed/lsparanoid/Deobfuscator$X$app;->getString(J)Ljava/lang/String;

So this script tracks `const-wide` per register inside each method and resolves
the low register of each `getString(J)` call. As a fallback it also collects
every 64-bit constant in the plausible id range, because a wrong id simply
fails to decode and is dropped later.

Usage: ids_from_smali.py <smali-dir|apk> [out-file]
"""
from __future__ import annotations

import pathlib
import re
import sys
import zipfile

CONST_WIDE = re.compile(r"^\s*const-wide(?:/16|/32|/high16)?\s+(v\d+)\s*,\s*(0x[0-9a-fA-F]+|-?\d+)L?\s*$")
INVOKE_GET = re.compile(
    r"invoke-static(?:/range)?\s*\{([^}]*)\}\s*,\s*Lorg/lsposed/lsparanoid/"
    r"Deobfuscator\$[A-Za-z0-9_$]+\$app;->getString\(J\)")
MIN_ID = 1 << 32
MAX_ID = 1 << 62


def as_signed(value: int) -> int:
    value &= 0xFFFFFFFFFFFFFFFF
    return value - (1 << 64) if value & (1 << 63) else value


def scan_text(text: str, out: set[int], extra: set[int]) -> None:
    registers: dict[str, int] = {}
    for line in text.splitlines():
        if line.startswith(".method"):
            registers = {}
            continue
        match = CONST_WIDE.match(line)
        if match:
            reg = match.group(1)
            try:
                value = int(match.group(2).rstrip("L"), 0)
            except ValueError:
                continue
            registers[reg] = as_signed(value)
            continue
        if "getString(J)" not in line:
            continue
        match = INVOKE_GET.search(line)
        if not match:
            continue
        regs = [r.strip() for r in match.group(1).split(",") if r.strip()]
        if not regs:
            continue
        value = registers.get(regs[0])
        if value is not None and MIN_ID <= abs(value) < MAX_ID:
            out.add(value)


def scan_file(path: pathlib.Path, out: set[int], extra: set[int]) -> None:
    text = path.read_text(errors="replace")
    scan_text(text, out, extra)
    for match in CONST_WIDE.finditer(text):
        try:
            value = as_signed(int(match.group(2).rstrip("L"), 0))
        except ValueError:
            continue
        if MIN_ID <= abs(value) < MAX_ID:
            extra.add(value)


def main() -> None:
    root = pathlib.Path(sys.argv[1])
    files: list[pathlib.Path] = []
    if root.is_dir():
        files = sorted(root.rglob("*.smali"))
    elif zipfile.is_zipfile(root):
        raise SystemExit("point this at apktool output, not at the apk")
    out: set[int] = set()
    extra: set[int] = set()
    for path in files:
        scan_file(path, out, extra)
    ids = sorted(out | extra)
    print(f"{len(files)} smali files: {len(out)} call-site ids, "
          f"{len(extra)} 64-bit constants, {len(ids)} candidates")
    if len(sys.argv) > 2:
        pathlib.Path(sys.argv[2]).write_text("\n".join(str(i) for i in ids) + "\n")
    else:
        sys.stdout.write("\n".join(str(i) for i in ids) + "\n")


if __name__ == "__main__":
    main()
