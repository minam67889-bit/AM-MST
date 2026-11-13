#!/usr/bin/env python3
"""Extract one entry from an APK/zip, whatever it was compressed with.

Modern Android builds store native libraries with Zstandard (method 93) or
leave them stored/aligned, and stock `unzip` refuses some of those. This helper
tries the normal route first, then falls back to reading the raw entry and
decompressing it with the `zstd` CLI.

Usage: extract_apk_entry.py <archive> <entry-name> <output-path>
"""

import shutil
import struct
import subprocess
import sys
import zipfile

STORE = 0
DEFLATE = 8
ZSTD = 93


def raw_entry(path, name):
    """Return (method, raw_bytes) straight from the local file header."""
    with zipfile.ZipFile(path) as archive:
        info = archive.getinfo(name)
    with open(path, "rb") as handle:
        handle.seek(info.header_offset)
        header = handle.read(30)
        if header[:4] != b"PK\x03\x04":
            raise ValueError("bad local file header")
        name_len, extra_len = struct.unpack("<HH", header[26:30])
        handle.seek(info.header_offset + 30 + name_len + extra_len)
        return info.compress_type, handle.read(info.compress_size)


def main():
    if len(sys.argv) != 4:
        print(__doc__)
        return 2
    archive, name, out_path = sys.argv[1:4]

    try:
        with zipfile.ZipFile(archive) as zf:
            data = zf.read(name)
        with open(out_path, "wb") as handle:
            handle.write(data)
        print(f"extracted {name} ({len(data)} B, zipfile)")
        return 0
    except NotImplementedError:
        pass
    except Exception as exc:  # noqa: BLE001 - reported, then we try harder
        print(f"zipfile could not read {name}: {exc}")

    try:
        method, raw = raw_entry(archive, name)
    except Exception as exc:  # noqa: BLE001
        print(f"cannot locate {name}: {exc}")
        return 1

    print(f"{name}: compression method {method}, {len(raw)} B on disk")
    if method in (STORE, 0):
        with open(out_path, "wb") as handle:
            handle.write(raw)
        return 0
    if method == DEFLATE:
        import zlib
        with open(out_path, "wb") as handle:
            handle.write(zlib.decompressobj(-15).decompress(raw))
        return 0
    if method == ZSTD and shutil.which("zstd"):
        proc = subprocess.run(["zstd", "-d", "-q", "-c"], input=raw, capture_output=True)
        if proc.returncode == 0:
            with open(out_path, "wb") as handle:
                handle.write(proc.stdout)
            print(f"extracted {name} ({len(proc.stdout)} B, zstd)")
            return 0
        print(f"zstd failed: {proc.stderr.decode('utf-8', 'replace')[:200]}")
        return 1
    print(f"unsupported compression method {method} for {name}")
    return 1


if __name__ == "__main__":
    sys.exit(main())
