#!/usr/bin/env python3
"""Execute the app's own tunnel binary on a plain Linux runner.

`SuperService` execs `libsuperdns.so` directly (it is an executable, only named
`.so`), so the same argv can be replayed here to see whether the far end still
answers. Requires an x86_64 build inside the APK, which the universal MOD ships.

Usage: run_libsuperdns.py <libsuperdns-x86_64> <out.txt> <domain> [domain...]
"""
from __future__ import annotations

import pathlib
import subprocess
import sys
import time

RESOLVERS = ["8.8.8.8:53", "1.1.1.1:53"]
UTLS = ["Chrome", "Firefox"]


def run(binary: pathlib.Path, domain: str, resolver: str, utls: str, seconds: int = 18) -> str:
    argv = [str(binary), "-udp", resolver, "-utls", utls, "-frequency", "0",
            "-report", "AM TUNNEL LITE VPN", "-pubkey", "prince", domain,
            "127.0.0.1:7000"]
    started = time.time()
    try:
        proc = subprocess.Popen(argv, stdout=subprocess.PIPE, stderr=subprocess.STDOUT)
    except OSError as exc:
        return f"  spawn failed: {exc}"
    out = b""
    try:
        out, _ = proc.communicate(timeout=seconds)
    except subprocess.TimeoutExpired:
        proc.kill()
        try:
            out, _ = proc.communicate(timeout=5)
        except subprocess.TimeoutExpired:
            out = b""
    elapsed = time.time() - started
    status = proc.returncode if proc.returncode is not None else "killed"
    text = out.decode("utf-8", errors="replace").strip()
    lines = [line for line in text.splitlines()][-12:]
    body = "\n".join("    " + line for line in lines) if lines else "    (no output)"
    return (f"  $ {' '.join(argv[1:])}\n"
            f"  exit={status} after {elapsed:.1f}s, {len(out)} bytes of output\n{body}")


def main() -> None:
    binary = pathlib.Path(sys.argv[1])
    out_path = pathlib.Path(sys.argv[2])
    domains = sys.argv[3:] or ["sa1.supaghost.cc"]
    lines: list[str] = []
    print(f"binary: {binary} ({binary.stat().st_size if binary.exists() else 0} bytes)")
    if not binary.exists():
        out_path.write_text("binary missing\n")
        return
    binary.chmod(0o755)
    head = subprocess.run(["file", "-b", str(binary)], capture_output=True, text=True, check=False)
    lines.append(f"file: {head.stdout.strip()}")
    for domain in domains:
        for resolver in RESOLVERS:
            for utls in UTLS[:1]:
                lines.append(f"=== {domain} via {resolver} utls={utls}")
                lines.append(run(binary, domain, resolver, utls))
                lines.append("")
    blob = "\n".join(lines) + "\n"
    out_path.write_text(blob, encoding="utf-8")
    print(blob)


if __name__ == "__main__":
    main()
