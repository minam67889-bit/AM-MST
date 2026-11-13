#!/usr/bin/env python3
"""Rewrite LSParanoid call sites in jadx output into readable string literals.

The app never contains `"superdns.example.com"` as text; it contains
`Deobfuscator$AMTUNNELLITE$app.getString(750656514172678644L)`. Once
`tools/lsparanoid_decode.py` has produced the `id<TAB>text` table, this script
substitutes each call with the plaintext so the surrounding code (argument
lists, prefs keys, URLs) becomes readable.

Usage: resolve_paranoid_source.py <decoded.tsv> <src-dir> <out-dir> [glob...]
"""
from __future__ import annotations

import pathlib
import re
import sys

CALL = re.compile(r"Deobfuscator\$[A-Za-z0-9_$]+\$app\.getString\(\s*(-?\d+)L?\s*\)")


def load(path: pathlib.Path) -> dict[str, str]:
    table: dict[str, str] = {}
    for line in path.read_text(errors="replace").splitlines():
        if not line or line.startswith("#") or "\t" not in line:
            continue
        key, text = line.split("\t", 1)
        table[key.strip()] = text
    return table


def escape(text: str) -> str:
    return text.replace("\\", "\\\\").replace('"', '\\"').replace("\n", "\\n")


def main() -> None:
    table = load(pathlib.Path(sys.argv[1]))
    src = pathlib.Path(sys.argv[2])
    out = pathlib.Path(sys.argv[3])
    patterns = sys.argv[4:] or ["**/*.java"]
    written = resolved = 0
    for pattern in patterns:
        for path in src.glob(pattern):
            if not path.is_file():
                continue
            text = path.read_text(errors="replace")

            def repl(match: re.Match[str]) -> str:
                nonlocal resolved
                value = table.get(match.group(1))
                if value is None:
                    return match.group(0)
                resolved += 1
                return '"' + escape(value) + '"'

            new = CALL.sub(repl, text)
            if new != text:
                target = out / path.relative_to(src)
                target.parent.mkdir(parents=True, exist_ok=True)
                target.write_text(new, encoding="utf-8")
                written += 1
    print(f"resolved {resolved} call sites in {written} files -> {out}")


if __name__ == "__main__":
    main()
