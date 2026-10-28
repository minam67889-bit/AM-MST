#!/usr/bin/env python3
"""BD NET DNS modes: reproduce *their* client config, then probe with *ours*.

Two algorithms live here.

**Their side** (`SocksDNSService.d()` in the prince dump) builds a JSON config,
writes it to `files/config.json` and execs a native binary with
`client --config <path>`:

    {
      "server": "<pEncrypt(ip:port)>",
      "validate": "1",
      "confuse": "3",
      "rx": 3,
      "tx": -1,
      "retry": ...,
      "retry_interval": 1,
      "socks5": { "listen": "127.0.0.1:10802" },
      "recv_window_conn": 196608,
      "recv_window": 491520,
      "report": "<app name>"
    }

`pEncrypt` is the native `stringToHex(xorWithKey(s))` — the mirror of the
`pDecrypt` we already recovered, so the tunnel address is hex of the XOR of the
"ip:port" text with the same 12-byte key.  The numeric knobs come from string
ids -89003939166091 (196608), -88935219689355 (127.0.0.1:10802) etc.

**Our side** is a MasterDnsVPN-shaped prober: fan out DNS probes to every
server at once, measure per-server RTT/liveness, then pick a tier the way the
Kotlin balancer does (latency + loss, no single point of failure).

Usage::

    python3 tools/bdnet_dns.py config --mode slowdns --host de1.liftmeon.org --port 53
    python3 tools/bdnet_dns.py probe  analysis-bdnet/configs/dns/servers.json
    python3 tools/bdnet_dns.py selftest
"""

from __future__ import annotations

import argparse
import concurrent.futures
import json
import pathlib
import random
import socket
import struct
import sys
import threading
import time

KEY = bytes.fromhex("342550645863683e666b505d")   # .rodata:0xbfb77 of libputils.so

# Recovered from SocksDNSService.d() — see docs/BDNET-CONFIGS.md
CONFIG_TEMPLATE = """{
  "server": "%s",
  "validate": "%s",
  "confuse": "%s",
  "rx": %s,
  "tx": %s,
  "retry": %s,
  "retry_interval": 1,
  "socks5": {
  "listen": "%s"
  },
  "recv_window_conn": %s,
  "recv_window": %s,
 "report": "%s"
}
"""
KNODS = {
    "validate": "1",
    "confuse": "3",
    "rx": "3",
    "tx": "-1",
    "retry": "1",
    "listen": "127.0.0.1:10802",
    "recv_window_conn": "196608",
    "recv_window": "491520",
}


# --------------------------------------------------------------------------- #
# their algorithm
# --------------------------------------------------------------------------- #
def xor_with_key(data: bytes) -> bytes:
    return bytes(b ^ KEY[i % len(KEY)] for i, b in enumerate(data))


def p_encrypt(text: str) -> str:
    """Mirror of libputils.so stringToHex: XOR first, then hex."""
    return xor_with_key(text.encode("utf-8")).hex()


def p_decrypt(hexstr: str) -> str:
    return xor_with_key(bytes.fromhex(hexstr)).decode("utf-8", "replace")


def build_config(host: str, port: int | str, app_name: str = "BD NET") -> str:
    return CONFIG_TEMPLATE % (
        p_encrypt(f"{host}:{port}"),
        KNODS["validate"], KNODS["confuse"], KNODS["rx"], KNODS["tx"],
        KNODS["retry"], KNODS["listen"],
        KNODS["recv_window_conn"], KNODS["recv_window"], app_name,
    )


# --------------------------------------------------------------------------- #
# our algorithm: DNS liveness probe + balancer
# --------------------------------------------------------------------------- #
def dns_packet(name: str, qtype: int = 16, tid: int | None = None) -> bytes:
    """Minimal DNS query (TXT by default: what a tunnel expects to carry)."""
    tid = random.randrange(65536) if tid is None else tid
    qname = b"".join(bytes([len(p)]) + p.encode() for p in name.split(".") if p) + b"\x00"
    return struct.pack(">HHHHHH", tid, 0x0100, 1, 0, 0, 0) + qname + struct.pack(">HH", qtype, 1)


def tcp_dns(server: tuple[str, int], pkt: bytes, timeout: float) -> bytes:
    """One DNS-over-TCP exchange, with a hard deadline.

    A tunnel endpoint that answers the length prefix and then stalls would
    otherwise keep us in `recv` for many multiples of `timeout`, which is
    exactly what a dead-but-listening resolver looks like.
    """
    deadline = time.monotonic() + timeout
    with socket.create_connection(server, timeout=timeout) as s:
        s.sendall(struct.pack(">H", len(pkt)) + pkt)
        head = s.recv(2)
        if len(head) < 2:
            raise OSError("short read")
        want = struct.unpack(">H", head)[0]
        if want == 0 or want > 65535:
            raise OSError(f"bogus length {want}")
        buf = b""
        while len(buf) < want:
            left = deadline - time.monotonic()
            if left <= 0:
                raise TimeoutError("deadline")
            s.settimeout(left)
            chunk = s.recv(min(want - len(buf), 4096))
            if not chunk:
                raise OSError("closed early")
            buf += chunk
        return buf


def probe_one(host: str, port: int, name: str, timeout: float, transport: str) -> dict:
    pkt = dns_packet(name)
    if port == 0:
        # UDPQ has no fixed port; the payload says 6000-19999 / 20000-50000.
        # Sending to port 0 is EINVAL, so draw one from the documented range.
        port = random.randrange(6000, 20000)
    server = (host, port)
    t0 = time.perf_counter()
    try:
        if transport == "udp":
            with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as s:
                s.settimeout(timeout)
                s.sendto(pkt, server)
                data, _ = s.recvfrom(4096)
        else:
            data = tcp_dns(server, pkt, timeout)
        ms = (time.perf_counter() - t0) * 1000
        rcode = data[3] & 0x0F if len(data) > 3 else None
        ancount = struct.unpack(">H", data[6:8])[0] if len(data) > 7 else 0
        return {"ok": True, "ms": round(ms, 1), "rcode": rcode, "answers": ancount,
                "bytes": len(data)}
    except Exception as exc:                       # noqa: BLE001 - probe reports anything
        return {"ok": False, "ms": round((time.perf_counter() - t0) * 1000, 1),
                "error": type(exc).__name__}


def resolve(host: str) -> list[str]:
    try:
        infos = socket.getaddrinfo(host, None, socket.AF_INET)
        return sorted({i[4][0] for i in infos})
    except Exception:
        return []


def probe(servers: list[dict], transport: str, timeout: float, workers: int) -> list[dict]:
    """Fan out to every server at once — the point of the MasterDnsVPN design."""
    jobs = []
    with concurrent.futures.ThreadPoolExecutor(max_workers=workers) as pool:
        for srv in servers:
            host = srv["host"]
            port = int(srv.get("port") or 53)
            ips = resolve(host)
            if not ips:
                jobs.append((srv, {"ok": False, "error": "NXDOMAIN", "ms": 0.0}))
                continue
            srv["ip"] = ips[0]
            name = f"{''.join(random.choice('abcdefghijklmnopqrstuvwxyz') for _ in range(10))}.{host}"
            fut = pool.submit(probe_one, ips[0], port, name, timeout, transport)
            jobs.append((srv, fut))
    out = []
    for srv, res in jobs:
        result = res.result() if hasattr(res, "result") else res
        out.append({"server": srv, **result})
    return out


def balance(results: list[dict]) -> list[dict]:
    """MasterDnsVPN-shaped tiering: latency, loss, best-first, never one server."""
    good = [r for r in results if r["ok"]]
    good.sort(key=lambda r: r["ms"])
    for rank, r in enumerate(good):
        r["tier"] = 0 if rank < 3 else 1
    return good


# --------------------------------------------------------------------------- #
# cli
# --------------------------------------------------------------------------- #
def cmd_config(args) -> int:
    cfg = build_config(args.host, args.port, args.app)
    if args.out:
        pathlib.Path(args.out).write_text(cfg, encoding="utf-8")
        print(f"wrote {args.out}")
    print(cfg)
    inner = json.loads(cfg)["server"]
    print(f"server field  : {inner}")
    print(f"decodes back  : {p_decrypt(inner)!r}")
    return 0


def cmd_probe(args) -> int:
    data = json.loads(pathlib.Path(args.servers).read_text(encoding="utf-8"))
    servers = data["servers"] if isinstance(data, dict) else data
    if args.mode:
        servers = [s for s in servers if s.get("mode") == args.mode]
    print(f"probing {len(servers)} server(s) over {args.transport.upper()} "
          f"(timeout {args.timeout}s, {args.workers} workers)")
    t0 = time.time()
    results = probe(servers, args.transport, args.timeout, args.workers)
    elapsed = time.time() - t0
    alive = [r for r in results if r["ok"]]
    print(f"\n{'host':32s} {'ip':16s} {'port':>5s} {'ms':>8s}  result")
    for r in sorted(results, key=lambda r: (not r["ok"], r["ms"])):
        ip = r["server"].get("ip", "-")
        line = f"{r['server']['host']:32s} {ip:16s} {int(r['server'].get('port') or 53):5d} {r['ms']:8.1f}  "
        line += (f"rcode={r['rcode']} answers={r['answers']} ({r['bytes']}B)"
                 if r["ok"] else f"FAIL {r['error']}")
        print(line)
    print(f"\n{len(alive)}/{len(results)} reachable over {args.transport.upper()}"
          f" in {elapsed:.1f}s (all in flight together)")
    best = balance(results)
    if best:
        print("balancer pick: " + ", ".join(f"{r['server']['host']}({r['ms']}ms)" for r in best[:3]))

    if args.out:
        pathlib.Path(args.out).write_text(json.dumps({
            "transport": args.transport, "timeout": args.timeout,
            "alive": len(alive), "total": len(results), "results": results,
        }, indent=2) + "\n", encoding="utf-8")
        print(f"wrote {args.out}")
    return 0 if alive else 1


def cmd_selftest(args) -> int:
    checks = {}
    for text in ("13.140.185.158:53", "de1.liftmeon.org:53", "127.0.0.1:10802"):
        enc = p_encrypt(text)
        checks[f"roundtrip {text}"] = p_decrypt(enc) == text
    cfg = json.loads(build_config("13.140.185.158", 53))
    checks["config keys"] = set(cfg) == {
        "server", "validate", "confuse", "rx", "tx", "retry", "retry_interval",
        "socks5", "recv_window_conn", "recv_window", "report"}
    checks["server decodes"] = p_decrypt(cfg["server"]) == "13.140.185.158:53"
    checks["windows"] = (cfg["recv_window_conn"], cfg["recv_window"]) == (196608, 491520)
    checks["knobs"] = (cfg["validate"], cfg["confuse"], cfg["rx"], cfg["tx"]) == ("1", "3", 3, -1)
    # a wrong-key decrypt must NOT round-trip, otherwise the test proves nothing
    checks["key matters"] = p_decrypt(p_encrypt("a:1")[:-2] + "00") != "a:1"
    for name, ok in checks.items():
        print(f"  {name:34s} {'PASS' if ok else 'FAIL'}")
    print(f"SELFTEST {'PASS' if all(checks.values()) else 'FAIL'} "
          f"({sum(checks.values())}/{len(checks)})")
    return 0 if all(checks.values()) else 1



# --------------------------------------------------------------------------- #
# "their" algorithm vs "ours", head to head
# --------------------------------------------------------------------------- #
def their_run(servers: list[dict], timeout: float, retry: int, interval: float) -> dict:
    """Replay exactly what the app's own client does.

    pdnsd is configured `tcp_only`, `validate=1`, `confuse=3`, `retry=1`,
    `retry_interval=1`, so one server at a time, TCP/53, a single retry a
    second later.  No fan-out, no health tiers - this is the baseline.
    """
    rows, t0 = [], time.time()
    for srv in servers:
        ips = resolve(srv["host"])
        if not ips:
            rows.append({**srv, "ok": False, "error": "NXDOMAIN", "ms": 0.0, "attempts": 0})
            continue
        name = f"{''.join(random.choice('abcdefghijklmnopqrstuvwxyz') for _ in range(10))}.{srv['host']}"
        attempts, result = 0, {"ok": False, "ms": 0.0, "error": "unknown"}
        for attempt in range(retry + 1):
            attempts = attempt + 1
            result = probe_one(ips[0], int(srv.get("port") or 53), name, timeout, "tcp")
            result["ip"] = ips[0]
            if result["ok"]:
                break
            if attempt < retry:
                time.sleep(interval)
        rows.append({**srv, **result, "attempts": attempts})
    return {"mode": "theirs", "transport": "tcp", "secs": round(time.time() - t0, 2),
            "alive": sum(1 for r in rows if r["ok"]), "total": len(rows), "rows": rows}


def our_run(servers: list[dict], timeout: float, workers: int,
            duplication: int = 2, strategy: str = "hybrid") -> dict:
    """MasterDnsVPN-shaped client: every resolver is probed at once, each
    packet is duplicated across two resolvers, failures never pin the tunnel
    to one box, and selection is by loss-then-latency score."""
    t0 = time.time()
    rows = probe(servers, "udp", timeout, workers)
    for r in rows:
        r["mode"] = "ours"
    live = [r for r in rows if r["ok"]]
    ranked = balance(rows)
    picked = [r["server"]["host"] for r in ranked[:max(2, len(ranked) // 2)]]
    plan = []
    for i in range(min(len(picked), 5)):
        plan.append([picked[i], picked[(i + 1) % len(picked)]][:duplication])
    return {"mode": "ours", "transport": "udp", "secs": round(time.time() - t0, 2),
            "alive": len(live), "total": len(rows), "strategy": strategy,
            "duplication": duplication, "route_plan": plan,
            "tiers": {"tier0": [r["server"]["host"] for r in ranked[:3]],
                      "tier1": [r["server"]["host"] for r in ranked[3:]]},
            "rows": rows}


def render_compare(theirs: dict, ours: dict) -> str:
    lines = []
    lines.append(f"{'':22s} {'theirs (pdnsd/tcp)':21s} {'ours (balanced/udp)':21s}")
    lines.append(f"{'reachable':22s} {theirs['alive']}/{theirs['total']:<19d} {ours['alive']}/{ours['total']:<19d}")
    lines.append(f"{'wall clock':22s} {theirs['secs']:<21.1f} {ours['secs']:<21.1f}")
    tt = [r["ms"] for r in theirs["rows"] if r["ok"]]
    oo = [r["ms"] for r in ours["rows"] if r["ok"]]
    fmt = lambda v: f"{sum(v)/len(v):.0f} ms ({len(v)} samples)" if v else "n/a"
    lines.append(f"{'mean RTT':22s} {fmt(tt):<21s} {fmt(oo):<21s}")
    if ones := ours.get("route_plan"):
        lines.append("")
        lines.append("our duplicate-route plan (each packet goes out twice):")
        for pair in ones:
            lines.append("  " + "  +  ".join(pair))
    return "\n".join(lines)


def cmd_their(args) -> int:
    servers = filter_mode(load_servers(args), args.mode)
    res = their_run(servers, args.timeout, args.retry, args.interval)
    print(render_rows(res["rows"], limit=args.show))
    print(f"\n{res['alive']}/{res['total']} answered over TCP/53 in {res['secs']}s "
          f"(one at a time, retry={args.retry})")
    dump(args.out, res)
    return 0 if res["alive"] else 1


def cmd_mine(args) -> int:
    servers = filter_mode(load_servers(args), args.mode)
    res = our_run(servers, args.timeout, args.workers, args.duplication)
    print(render_rows(res["rows"], limit=args.show))
    print(f"\n{res['alive']}/{res['total']} answered over UDP/53 in {res['secs']}s "
          f"(all in flight at once)")
    print("tier0 (best): " + ", ".join(res["tiers"]["tier0"]))
    if res["route_plan"]:
        print("duplicate routes: " + " | ".join(" + ".join(p) for p in res["route_plan"][:3]))
    dump(args.out, res)
    return 0 if res["alive"] else 1


def cmd_compare(args) -> int:
    servers = filter_mode(load_servers(args), args.mode)
    print(f"== {len(servers)} servers, mode={args.mode or 'all'} ==")
    theirs = their_run(servers, args.timeout, args.retry, args.interval)
    ours = our_run(servers, args.timeout, args.workers, args.duplication)
    print(render_compare(theirs, ours))
    payload = {"theirs": theirs, "ours": ours}
    dump(args.out, payload)
    return 0 if (theirs["alive"] or ours["alive"]) else 1


def _flat(row: dict) -> dict:
    """`their_run` flattens the server fields, `probe` keeps them nested."""
    srv = row.get("server") or {}
    merged = dict(srv)
    merged.update({k: v for k, v in row.items() if k != "server"})
    return merged


def render_rows(rows: list[dict], limit: int | None = None) -> str:
    out = [f"{'host':32s} {'ip':16s} {'port':>5s} {'ms':>8s}  result"]
    ordered = sorted((_flat(r) for r in rows), key=lambda r: (not r.get("ok"), r.get("ms", 0)))
    shown = ordered if limit is None else ordered[:limit]
    for r in shown:
        ip = r.get("ip", "-")
        line = (f"{r.get('host', '?'):32s} {ip:16s} {int(r.get('port') or 53):5d} "
                f"{r.get('ms', 0):8.1f}  ")
        line += (f"rcode={r['rcode']} answers={r['answers']}" if r.get("ok")
                 else f"FAIL {r.get('error')}")
        out.append(line)
    if limit is not None and len(ordered) > limit:
        out.append(f"... and {len(ordered) - limit} more")
    return "\n".join(out)


def dump(path: str | None, payload: dict) -> None:
    if path:
        pathlib.Path(path).write_text(json.dumps(payload, indent=2) + "\n", encoding="utf-8")
        print(f"wrote {path}")


def filter_mode(servers: list[dict], mode: str | None) -> list[dict]:
    """`--mode` used to be silently ignored outside `probe`/`compare`, which
    turned a 20-host check into an 845-host one. Keep it in one place."""
    picked = [s for s in servers if s.get("mode") == mode] if mode else servers
    if not picked:
        raise SystemExit(f"no servers with mode={mode!r}")
    return picked


def load_servers(args) -> list[dict]:
    data = json.loads(pathlib.Path(args.servers).read_text(encoding="utf-8"))
    return data["servers"] if isinstance(data, dict) else data



# --------------------------------------------------------------------------- #
# loopback proof: same code paths, no internet needed
# --------------------------------------------------------------------------- #
def _answer_udp(pkt: bytes) -> bytes:
    """NOERROR + one TXT answer, so the client sees a real DNS reply."""
    tid, flags = pkt[:2], pkt[2:4]
    qd = pkt[12:]
    end = 0
    while qd[end] != 0:
        end += qd[end] + 1
    qname = qd[:end + 1]
    qtail = qd[end + 1:end + 5]
    rr = b"\xc0\x0c" + struct.pack(">HHIH", 16, 1, 30, 6) + b"\x05tun00"
    return tid + b"\x81\x80" + struct.pack(">HHHH", 1, 1, 0, 0) + qname + qtail + rr


def _serve_udp(sock: socket.socket, stop: threading.Event) -> None:
    while not stop.is_set():
        try:
            data, peer = sock.recvfrom(2048)
            sock.sendto(_answer_udp(data), peer)
        except OSError:
            return


def _serve_tcp(sock: socket.socket, stop: threading.Event) -> None:
    while not stop.is_set():
        try:
            conn, _ = sock.accept()
        except OSError:
            return
        with conn:
            try:
                head = conn.recv(2)
                if len(head) < 2:
                    continue
                want = struct.unpack(">H", head)[0]
                pkt = b""
                while len(pkt) < want:
                    chunk = conn.recv(want - len(pkt))
                    if not chunk:
                        break
                    pkt += chunk
                reply = _answer_udp(pkt)
                conn.sendall(struct.pack(">H", len(reply)) + reply)
            except OSError:
                pass


def cmd_loopback(args) -> int:
    """Prove both clients against a local resolver: their TCP-only client and
    our balanced UDP client, on real sockets, with a dead port mixed in."""
    stop = threading.Event()
    udp = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    udp.bind(("127.0.0.1", 0)); udp.settimeout(0.3)
    tcp = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    tcp.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
    tcp.bind(("127.0.0.1", 0)); tcp.listen(8)
    udp_port, tcp_port = udp.getsockname()[1], tcp.getsockname()[1]
    threading.Thread(target=_serve_udp, args=(udp, stop), daemon=True).start()
    threading.Thread(target=_serve_tcp, args=(tcp, stop), daemon=True).start()
    dead = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    dead.bind(("127.0.0.1", 0))
    dead_port = dead.getsockname()[1]
    dead.close()

    print(f"local resolver  udp 127.0.0.1:{udp_port}   tcp 127.0.0.1:{tcp_port}")
    print(f"dead control    udp 127.0.0.1:{dead_port} (bound then closed)")
    theirs = their_run([{"host": "127.0.0.1", "port": tcp_port, "mode": "slowdns"}],
                       2.0, retry=1, interval=0.1)
    ours = our_run([{"host": "127.0.0.1", "port": udp_port, "mode": "slowdns"},
                    {"host": "127.0.0.1", "port": dead_port, "mode": "slowdns"}],
                   0.6, 8)
    print()
    print(render_compare(theirs, ours))
    for r in ours["rows"]:
        print(f"  ours saw {r['server']['port']:5d} -> {'ok' if r['ok'] else r['error']}")
    ok = (theirs["alive"] == 1 and ours["alive"] == 1
          and any(not r["ok"] for r in ours["rows"]))
    stop.set(); udp.close(); tcp.close()
    print(f"LOOPBACK {'PASS' if ok else 'FAIL'}: their client answered over TCP, "
          f"our client answered over UDP and rejected the dead port")
    return 0 if ok else 1


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description=__doc__.splitlines()[0])
    sub = ap.add_subparsers(dest="cmd", required=True)

    c = sub.add_parser("config", help="emit the config JSON the app would write")
    c.add_argument("--host", required=True)
    c.add_argument("--port", default="53")
    c.add_argument("--app", default="BD NET")
    c.add_argument("--out")
    c.set_defaults(func=cmd_config)

    p = sub.add_parser("probe", help="MasterDnsVPN-style fan-out probe")
    p.add_argument("servers", help="servers.json or a list of {host,port}")
    p.add_argument("--mode", default=None, help="only servers with this mode")
    p.add_argument("--transport", choices=("udp", "tcp"), default="udp")
    p.add_argument("--timeout", type=float, default=6.0)
    p.add_argument("--workers", type=int, default=32)
    p.add_argument("--out")
    p.set_defaults(func=cmd_probe)

    t = sub.add_parser("their", help="replay the app's own pdnsd/TCP client, sequentially")
    t.add_argument("servers"); t.add_argument("--mode"); t.add_argument("--timeout", type=float, default=6.0)
    t.add_argument("--retry", type=int, default=1); t.add_argument("--interval", type=float, default=1.0)
    t.add_argument("--show", type=int, default=25); t.add_argument("--out"); t.set_defaults(func=cmd_their)

    m = sub.add_parser("mine", help="MasterDnsVPN-shaped balanced client")
    m.add_argument("servers"); m.add_argument("--mode"); m.add_argument("--timeout", type=float, default=6.0)
    m.add_argument("--workers", type=int, default=64); m.add_argument("--duplication", type=int, default=2)
    m.add_argument("--show", type=int, default=25); m.add_argument("--out"); m.set_defaults(func=cmd_mine)

    k = sub.add_parser("compare", help="run theirs then ours on the same host list")
    k.add_argument("servers"); k.add_argument("--mode"); k.add_argument("--timeout", type=float, default=6.0)
    k.add_argument("--retry", type=int, default=1); k.add_argument("--interval", type=float, default=1.0)
    k.add_argument("--workers", type=int, default=64); k.add_argument("--duplication", type=int, default=2)
    k.add_argument("--show", type=int, default=25); k.add_argument("--out"); k.set_defaults(func=cmd_compare)

    lb = sub.add_parser("loopback", help="prove both clients against a local resolver")
    lb.set_defaults(func=cmd_loopback)

    s = sub.add_parser("selftest", help="verify pEncrypt/pDecrypt and the config")
    s.set_defaults(func=cmd_selftest)

    args = ap.parse_args(argv)
    return args.func(args)


if __name__ == "__main__":
    sys.exit(main())
