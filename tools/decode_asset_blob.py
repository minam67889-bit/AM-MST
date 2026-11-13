#!/usr/bin/env python3
"""Crack an obfuscated JSON asset shipped inside the APK (`assets/janny.json`).

These builds store their server catalogue as base64 of a XORed / compressed
blob. There is no crypto library involved in practice, so a bounded set of
transforms is enough to find the plaintext:

  * raw base64 decode
  * zlib / gzip / raw deflate after base64
  * single-byte XOR (0..255) scored on printable-ASCII ratio
  * repeating-key XOR with the obvious in-app keys ("prince", "superdns", ...)

Usage: decode_asset_blob.py <blob-file> [out-file]
"""
from __future__ import annotations

import base64
import binascii
import gzip
import pathlib
import re
import sys
import zlib

KEYS = [b"prince", b"superdns", b"SuperDNS", b"amtunnel", b"AMTUNNEL",
        b"AMTUNNELLITE", b"janny", b"tunnel", b"am tunnel", b"amtunnel.lite"]

JSON_HINT = re.compile(rb'[\[{]\s*"[ -~]{4,}"')


def printable_ratio(blob: bytes) -> float:
    if not blob:
        return 0.0
    good = sum(1 for b in blob if 32 <= b < 127 or b in (9, 10, 13))
    return good / len(blob)


def try_inflate(blob: bytes) -> bytes | None:
    for name, fn in (("zlib", zlib.decompress), ("raw-deflate", lambda d: zlib.decompress(d, -15)),
                     ("gzip", gzip.decompress)):
        try:
            out = fn(blob)
        except Exception:  # noqa: BLE001
            continue
        if out and printable_ratio(out) > 0.85:
            print(f"  inflate OK via {name} -> {len(out)} bytes")
            return out
    return None


def xor(blob: bytes, key: bytes) -> bytes:
    return bytes(b ^ key[i % len(key)] for i, b in enumerate(blob))


def looks_like_json(blob: bytes) -> bool:
    head = blob.lstrip()[:1]
    return head in (b"{", b"[") and printable_ratio(blob[:4096]) > 0.9


def main() -> None:
    path = pathlib.Path(sys.argv[1])
    out_path = pathlib.Path(sys.argv[2]) if len(sys.argv) > 2 else None
    raw = path.read_bytes().strip()
    print(f"blob: {len(raw)} bytes, head={raw[:40]!r}")

    data = raw
    if re.fullmatch(rb"[A-Za-z0-9+/=\s]+", raw):
        try:
            data = base64.b64decode(raw, validate=False)
            print(f"  base64 -> {len(data)} bytes, head={data[:32].hex()}")
        except (binascii.Error, ValueError) as exc:
            print(f"  base64 failed: {exc}")

    best: tuple[float, str, bytes] | None = None
    candidates: list[tuple[str, bytes]] = [("as-is", data)]
    inflated = try_inflate(data)
    if inflated:
        candidates.append(("inflate", inflated))

    for label, blob in list(candidates):
        if looks_like_json(blob):
            best = (1.0, label, blob)
            break
        for key in range(256):
            cand = xor(blob, bytes([key]))
            if looks_like_json(cand):
                best = (1.0, f"{label}/xor1=0x{key:02x}", cand)
                break
            if printable_ratio(cand[:4096]) > 0.92 and b'"' in cand[:4096]:
                score = printable_ratio(cand[:4096])
                if best is None or score > best[0]:
                    best = (score, f"{label}/xor1=0x{key:02x}", cand)
        if best and best[0] == 1.0:
            break

    for key in KEYS:
        for label, blob in list(candidates):
            cand = xor(blob, key)
            if looks_like_json(cand):
                best = (1.0, f"{label}/xor-key={key.decode()}", cand)
                break
            inflated_cand = try_inflate(cand)
            if inflated_cand and looks_like_json(inflated_cand):
                best = (1.0, f"{label}/xor-key={key.decode()}+inflate", inflated_cand)
                break
        if best and best[0] == 1.0:
            break

    if not best:
        print("  no transform produced JSON-ish plaintext")
        print(f"  as-is printable ratio: {printable_ratio(data[:4096]):.2f}")
        print(f"  first 256 bytes: {data[:256].hex()}")
        return

    score, label, blob = best
    print(f"BEST: {label} score={score:.2f} -> {len(blob)} bytes")
    text = blob.decode("utf-8", errors="replace")
    print(text[:4000])
    if out_path:
        out_path.write_text(text, encoding="utf-8", errors="replace")
        print(f"wrote {out_path}")


if __name__ == "__main__":
    main()
