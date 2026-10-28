#!/usr/bin/env python3
"""Unpack BD NET's `assets/server.psi` into Psiphon server entries.

`SocksDNSService.d()` does exactly this at runtime:

    String s = loadServerDat(ctx, "server.psi");     // the asset text
    psiphonTunnel.startTunneling(PUtils.pDecrypt(ctx, s));

and `pDecrypt` is the native pair found in `libputils.so`:

    hexToString(str)   // two hex chars -> one byte, stops at the first pair
                       // that is not hex... except the shipped asset is one
                       // odd-length run, so the last nibble is dropped
    xorWithKey(bytes)  // 12-byte repeating key, .rodata:0xbfb77 of libputils.so

What comes out is *not* the entry list yet: it is the entry list hex-encoded
one more time, one entry per line, each entry being Psiphon's canonical text
form `0 0 0 0 {"ipAddress":...}`.  So the asset is hex(hex(list)) and the last
step is a per-line hex decode.

Two details that cost real time and are therefore asserted below:

* the asset begins with a single stray character (its length is odd: 103 253),
  so the payload starts at offset 1, not 0;
* the XOR phase that reproduces readable text is the recovered key rotated by
  9 bytes - i.e. the bytes on the wire are `kP]4%PdXch>f`; the key read out of
  `.rodata` (`4%PdXch>fkP]`) is the same 12 bytes with a different start.

Usage::

    python3 tools/bdnet_serverpsi.py analysis-bdnet/assets/assets_server.psi -o analysis-bdnet/configs
"""

from __future__ import annotations

import argparse
import json
import pathlib
import sys

# Same 12 bytes as tools/bdnet_dns.py, starting at the phase the asset uses.
KEY = bytes.fromhex("6b505d342550645863683e66")   # "kP]4%PdXch>f"


def peel_outer(asset_text: str) -> bytes:
    """hex -> XOR, i.e. what PUtils.pDecrypt does to the asset."""
    body = asset_text.strip()
    if len(body) % 2:
        body = body[1:]                    # the stray leading nibble
    raw = bytes.fromhex(body)
    return bytes(b ^ KEY[i % len(KEY)] for i, b in enumerate(raw))


def entries(inner_text: str) -> tuple[list[str], list[str]]:
    """Second hex layer: every line is one `0 0 0 0 {...}` server entry."""
    good, bad = [], []
    for line in inner_text.splitlines():
        line = line.strip()
        if not line:
            continue
        try:
            decoded = bytes.fromhex(line).decode("utf-8")
            json.loads(decoded.split(" ", 4)[4])
            good.append(decoded)
        except Exception as exc:            # noqa: BLE001 - collect, do not abort
            bad.append(f"{type(exc).__name__}: {line[:40]}...")
    return good, bad


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    ap.add_argument("asset", help="assets/server.psi")
    ap.add_argument("-o", "--outdir", default=".")
    ap.add_argument("--quiet", action="store_true")
    args = ap.parse_args(argv)

    asset = pathlib.Path(args.asset).read_text(encoding="utf-8", errors="replace")
    if not args.quiet:
        print(f"asset      : {len(asset)} chars")

    inner = peel_outer(asset).decode("latin-1")
    printable = sum(32 <= ord(c) < 127 for c in inner) / max(len(inner), 1)
    if not args.quiet:
        print(f"after XOR  : {len(inner)} chars, {printable:.4%} printable, "
              f"{inner.count(chr(10)) + 1} lines")
    assert printable > 0.99, "wrong key/phase - the XOR output must be clean ASCII"

    good, bad = entries(inner)
    if not args.quiet:
        print(f"entries    : {len(good)} valid, {len(bad)} unparsable")
        for b in bad:
            print(f"  skip: {b}")

    parsed = []
    for entry in good:
        prefix, payload = entry.split(" ", 4)[:2], entry.split(" ", 4)[4]
        obj = json.loads(payload)
        obj["_entry"] = entry
        obj["_prefix"] = prefix
        parsed.append(obj)

    out = pathlib.Path(args.outdir)
    out.mkdir(parents=True, exist_ok=True)
    (out / "psiphon_entries.txt").write_text("\n".join(good) + "\n", encoding="utf-8")
    (out / "psiphon_entries.json").write_text(json.dumps(parsed, indent=2) + "\n",
                                             encoding="utf-8")
    if not args.quiet:
        print(f"\n{'ip':18s} {'port':>5s} {'fronted':>8s}  capabilities")
        for obj in parsed:
            caps = ",".join(obj.get("capabilities", []))[:52]
            print(f"{obj.get('ipAddress', '?'):18s} {obj.get('meekServerPort', 0):5d} "
                  f"{str(obj.get('meekFrontingHosts') or obj.get('meekFrontingAddresses') or '-'):>8.8s}  {caps}")
        print(f"\nwrote {out / 'psiphon_entries.txt'} and psiphon_entries.json")
    return 0 if good else 1


if __name__ == "__main__":
    sys.exit(main())
