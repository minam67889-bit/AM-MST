#!/usr/bin/env python3
"""Decrypt this build's `assets/janny.json` server catalogue.

Reverse engineered from `defpackage.AbstractC3622yh` (obfuscated XXTEA):

    c(String blobs, String key) = new String(b(base64decode(blobs), key), "UTF-8")
    b(byte[] data, byte[] key)  = XXTEA-decrypt(g(data, false), g(pad16(key), false))
                                  then f(..., true)   # strip the length word
    a(sum, y, z, p, e, k)       = ((sum ^ y) + (k[(p & 3) ^ e] ^ z))
                                  ^ (((z >>> 5) ^ (y << 2)) + ((y >>> 3) ^ (z << 4)))
    delta                       = -1638454863   (not the usual 0x9E3779B9)
    rounds                      = 6 + 52 / n

Usage: xxtea_janny.py <janny.b64|janny.json> <key> [out-file]
"""
from __future__ import annotations

import base64
import binascii
import pathlib
import re
import sys

M32 = 0xFFFFFFFF
DELTA = (-1638454863) & M32


def mx(sum_: int, y: int, z: int, p: int, e: int, k: list[int]) -> int:
    return ((((sum_ ^ y) + (k[(p & 3) ^ e] ^ z)) & M32)
            ^ ((((z >> 5) ^ ((y << 2) & M32)) + ((y >> 3) ^ ((z << 4) & M32))) & M32)) & M32


def words_le(data: bytes, with_length: bool = False) -> list[int]:
    """Port of AbstractC3622yh.g(byte[], boolean)."""
    n = len(data) // 4 + (0 if len(data) % 4 == 0 else 1)
    out = [0] * (n + 1 if with_length else n)
    for i, byte in enumerate(data):
        out[i >> 2] |= (byte & 0xFF) << ((i & 3) << 3)
    if with_length:
        out[n] = len(data)
    return out


def bytes_le(words: list[int], strip_length: bool) -> bytes | None:
    """Port of AbstractC3622yh.f(int[], boolean)."""
    total = len(words) * 4
    length = total
    if strip_length:
        stored = words[-1]
        if stored < total - 7 or stored > total - 4:
            return None
        length = stored
    return bytes((words[i >> 2] >> ((i & 3) << 3)) & 0xFF for i in range(length))


def xxtea_decrypt(data: bytes, key: bytes) -> bytes | None:
    """Port of AbstractC3622yh.b(byte[], byte[]), loop shape included.

    The Java decrypt loop keeps `y` (i6) from the previous step and feeds it
    into the p == 0 round, unlike the canonical XXTEA reference, so this is
    transcribed line by line instead of using a library.
    """
    v = words_le(data, with_length=False)
    k = words_le((key + b"\x00" * 16)[:16])
    i = len(v) - 1
    if i >= 1:
        rounds = 52 // len(v) + 6
        total = (rounds * DELTA) & M32
        y = v[0]
        while total != 0:
            e = (total >> 2) & 3
            y = v[0]
            p = i
            while p > 0:
                y = (v[p] - mx(total, y, v[p - 1], p, e, k)) & M32
                v[p] = y
                p -= 1
            y = (v[0] - mx(total, y, v[i], 0, e, k)) & M32
            v[0] = y
            total = (total - DELTA) & M32
    return bytes_le(v, strip_length=True)


def main() -> None:
    path = pathlib.Path(sys.argv[1])
    key = sys.argv[2].encode()
    out_path = pathlib.Path(sys.argv[3]) if len(sys.argv) > 3 else None
    raw = path.read_bytes()

    payloads: list[tuple[str, bytes]] = []
    text = raw.strip()
    if re.fullmatch(rb"[A-Za-z0-9+/=\s]+", text):
        try:
            payloads.append(("base64", base64.b64decode(text)))
        except (binascii.Error, ValueError):
            pass
    payloads.append(("raw", raw))

    for label, data in payloads:
        plain = xxtea_decrypt(data, key)
        if plain is None:
            print(f"{label}: length word invalid (wrong key?)")
            continue
        ratio = sum(1 for b in plain[:2048] if 32 <= b < 127 or b in (9, 10, 13)) / max(1, len(plain[:2048]))
        print(f"{label}: decoded {len(plain)} bytes, printable {ratio:.2f}, head={plain[:120]!r}")
        if ratio > 0.85:
            out = plain.decode("utf-8", errors="replace")
            if out_path:
                out_path.write_text(out, encoding="utf-8")
                print(f"wrote {out_path} ({len(out)} chars)")
            else:
                print(out[:2000])
            return
    print("no payload decrypted to text")


if __name__ == "__main__":
    main()
