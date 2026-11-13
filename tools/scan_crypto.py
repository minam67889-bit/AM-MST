#!/usr/bin/env python3
"""Scan an Android native library for crypto fingerprints and embedded keys.

Written for `libputils.so`, the library behind `PUtils.pDecrypt(Context, String)`
in BD NET: the config bundles are decrypted there, not in Java. The goal is to
identify the primitive (AES / ChaCha / RC4 / a hash) from its characteristic
constant tables, and to surface any embedded key material, without a device.

Usage: scan_crypto.py libputils.so
"""

from __future__ import annotations

import re
import struct
import sys
from pathlib import Path

SIGNS = {
    "AES S-box": bytes.fromhex("637c777bf26b6fc53001672bfed7ab76"),
    "AES inverse S-box": bytes.fromhex("52096ad53036a538bf40a39e81f3d7fb"),
    "AES rcon": bytes.fromhex("01020408102040801b36"),
    "ChaCha sigma": b"expand 32-byte k",
    "ChaCha sigma (be)": b"expand 16-byte k",
    "MD5 init": struct.pack("<4I", 0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476),
    "SHA1 init": struct.pack(">5I", 0x67452301, 0xEFCDAB89, 0x98BADCFE, 0x10325476, 0xC3D2E1F0),
    "SHA256 init": struct.pack(">8I", 0x6A09E667, 0xBB67AE85, 0x3C6EF372, 0xA54FF53A,
                               0x510E527F, 0x9B05688C, 0x1F83D9AB, 0x5BE0CD19),
    "SHA256 K[0:8]": struct.pack(">8I", 0x428A2F98, 0x71374491, 0xB5C0FBCF, 0xE9B5DBA5,
                                 0x3956C25B, 0x59F111F1, 0x923F82A4, 0xAB1C5ED5),
    "Base64 alphabet": b"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/",
    "RC4-ish 0..255 table": bytes(range(256)),
}

# Words that betray what the routine does, in any obfuscation level.
HINTS = [b"aes", b"AES", b"cbc", b"CBC", b"ecb", b"gcm", b"chacha", b"poly1305",
         b"sha256", b"md5", b"rc4", b"xor", b"base64", b"signature", b"pDecrypt",
         b"pEncrypt", b"putils", b"getPackageName", b"getSignature", b"apk",
         b"openssl", b"mbedtls", b"boringssl", b"libcrypto"]

ASCII_RUN = re.compile(rb"[ -~]{6,}")

HEX32 = re.compile(rb"\b[0-9a-fA-F]{32,64}\b")
B64ISH = re.compile(rb"\b[A-Za-z0-9+/]{24,}={0,2}\b")


def main(argv: list[str]) -> int:
    if len(argv) != 1:
        print(__doc__)
        return 2
    path = Path(argv[0])
    blob = path.read_bytes()
    print(f"file    : {path} ({len(blob)} bytes)")
    print(f"elf     : {blob[:4]!r} class={blob[4]} data={blob[5]}")

    print("\n== constant tables ==")
    found_any = False
    for name, sig in SIGNS.items():
        idx = blob.find(sig)
        if idx >= 0:
            found_any = True
            print(f"  {name:24} at 0x{idx:x}")
    if not found_any:
        print("  none of the well-known tables are present verbatim")

    print("\n== keyword hints ==")
    low = blob.lower()
    for h in HINTS:
        n = low.count(h.lower())
        if n:
            print(f"  {h.decode(errors='replace'):16} x{n}")

    print("\n== printable strings ==")
    runs = [m.group(0) for m in ASCII_RUN.finditer(blob)]
    print(f"  {len(runs)} runs; showing the ones that look like keys or paths")
    for r in runs:
        s = r.decode(errors="replace")
        if (HEX32.search(r) or B64ISH.search(r)
                or any(k in s.lower() for k in ("key", "aes", "decrypt", "encrypt",
                                                "signature", "putils", "secret", "iv",
                                                "salt", "pass"))):
            print(f"  {s[:120]}")

    print("\n== hex-looking blobs ==")
    for m in dict.fromkeys(m.group(0) for m in HEX32.finditer(blob)):
        print(f"  {m.decode()}")

    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
