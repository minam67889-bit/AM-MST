#!/usr/bin/env python3
"""Decrypt BD NET (dastan.prince.bdfreevpn v106) bundled server list.

Recovered from ``libputils.so`` (pDecrypt) plus a byte-level analysis of the
shipped payload.  Nothing here is guessed: every layer below was confirmed by
the structure it produces (a hex string that decodes to ``0 0 0 0 {json}``
lines, 18/19 of which parse as JSON server entries).

Layers of ``assets/server.psi`` (a 103 253 character ASCII hex string)::

    asset  --[drop 1 header char]-->  hex  --[hex decode]-->  bytes
    bytes  --[XOR, key "fkP]4%PdXch>" repeating]-->  plaintext (hex text)
    plaintext  --[hex decode, one line at a time]-->  psiphon server entries
                                                       "0 0 0 0 {json}"

The XOR key is the 12-byte constant stored at ``.rodata:0xbfb77`` of
``libputils.so`` (``34 25 50 64 58 63 68 3e 66 6b 50 5d``).  The native code
starts the cycle at offset 0, but the payload was produced against the cycle
rotated by 9, i.e. effectively ``66 6b 50 5d 34 25 50 64 58 63 68 3e``
("kP]4%PdXch>f").  Every other rotation yields binary junk; this one yields
99.97% printable ASCII, which is not something a wrong key can do.

Usage::

    python3 tools/bdnet_decrypt.py analysis-bdnet/assets/assets_server.psi
    python3 tools/bdnet_decrypt.py in.psi -o outdir --json

Exit code is 0 only when at least one complete server entry parses.
"""

from __future__ import annotations

import argparse
import binascii
import json
import pathlib
import sys

# 34 25 50 64 58 63 68 3e 66 6b 50 5d, rotated left by 9.
RODATA_KEY = bytes.fromhex("342550645863683e666b505d")
# RODATA_KEY rotated left by 9: 6b 50 5d 34 25 50 64 58 63 68 3e 66
KEY = RODATA_KEY[9:] + RODATA_KEY[:9]


def xor(data: bytes, key: bytes = KEY) -> bytes:
    return bytes(b ^ key[i % len(key)] for i, b in enumerate(data))


def decrypt_payload(asset: bytes) -> bytes:
    """asset -> plaintext hex text (the String passed to startTunneling)."""
    text = asset.strip()
    if len(text) % 2 == 0:      # v106 ships 103253 (odd); be defensive anyway
        text = text[:-1]
    text = text[1:]             # first char of the payload is a header nibble
    return xor(binascii.unhexlify(text))


def parse_entries(plaintext: bytes) -> tuple[list[str], list[str]]:
    """plaintext hex text -> (canonical entries, unparsed fragments)."""
    entries: list[str] = []
    bad: list[str] = []
    for line in plaintext.split(b"\n"):
        line = line.strip()
        if not line:
            continue
        if len(line) % 2:
            line = line[:-1]
        try:
            blob = binascii.unhexlify(line)
        except binascii.Error:
            bad.append(line.decode("latin1"))
            continue
        text = blob.decode("utf-8", "replace")
        if "{" not in text:
            bad.append(text)
            continue
        body = "{" + text.split("{", 1)[1]
        try:
            json.loads(body)
        except json.JSONDecodeError:
            bad.append(text)
            continue
        entries.append(text)
    return entries, bad


def crack_rotation(asset: bytes) -> int:
    """Sanity check: which rotation of the .rodata key makes the payload text."""
    text = asset.strip()[1:]
    if len(text) % 2:
        text = text[:-1]
    raw = binascii.unhexlify(text)
    best = (-1.0, -1)
    for rot in range(len(RODATA_KEY)):
        k = RODATA_KEY[rot:] + RODATA_KEY[:rot]
        out = xor(raw, k)
        printable = sum(1 for b in out if 32 <= b < 127 or b == 10) / len(out)
        if printable > best[0]:
            best = (printable, rot)
    return best[1]


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    ap.add_argument("asset", type=pathlib.Path, help="assets/server.psi")
    ap.add_argument("-o", "--outdir", type=pathlib.Path, default=None)
    ap.add_argument("--json", action="store_true", help="also dump a JSON array")
    args = ap.parse_args(argv)

    asset = args.asset.read_bytes()
    rot = crack_rotation(asset)
    print(f"asset            : {args.asset} ({len(asset)} chars)")
    print(f"key rotation     : {rot} of {len(RODATA_KEY)} (0 == native code order)")
    plaintext = decrypt_payload(asset)
    text = plaintext.decode("latin1")
    print(f"plaintext        : {len(plaintext)} chars, "
          f"{sum(1 for b in plaintext if 32 <= b < 127) / len(plaintext):.4%} printable")
    entries, bad = parse_entries(plaintext)
    print(f"server entries   : {len(entries)} complete, {len(bad)} fragment(s)")
    for i, entry in enumerate(entries, 1):
        ip = json.loads("{" + entry.split("{", 1)[1]).get("ipAddress", "?")
        print(f"  {i:2d}. {ip:16s} {entry[:11]}")
    print(f"  fragments      : {len(bad)} (first entry is truncated in the asset)")
    if bad:
        print(f"  e.g.           : {bad[0][:70]!r}")

    if args.outdir:
        args.outdir.mkdir(parents=True, exist_ok=True)
        (args.outdir / "psiphon_entries.txt").write_text(
            "\n".join(entries) + "\n", encoding="utf-8")
        (args.outdir / "psiphon_entries.hex.txt").write_text(
            text + "\n", encoding="utf-8")
        if args.json:
            (args.outdir / "psiphon_entries.json").write_text(
                json.dumps([json.loads("{" + e.split("{", 1)[1]) for e in entries],
                           indent=2) + "\n", encoding="utf-8")
        print(f"wrote            : {args.outdir}/psiphon_entries.txt")

    return 0 if entries else 1


if __name__ == "__main__":
    sys.exit(main())
