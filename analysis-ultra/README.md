# Ultra Tunnel (`co.strongteam.ultra`) — analysis output

**Start here:** [`slowdns.json`](slowdns.json) — the deliverable. 8 dnstt domains,
64-hex public keys, the SSH account each server expects, 56 resolvers, ports,
the exact `libdns` command line and 32 ready launch recipes, each with a
verified/unverified marker.

| file | what it is |
| --- | --- |
| `slowdns.json` | **the deliverable** (built by `build_slowdns_json.py`) |
| `config-decoded.json` | bundled catalogue, fully decrypted, `v3.95`, 56 servers / 859 networks |
| `remote-config-decoded.json` | live updater catalogue, `v5.28`, 38 servers / 918 networks |
| `assets/configfile.json` | the original encrypted asset (unchanged, as shipped) |
| `assets/remote-catalog.enc` | raw body of `strongteam.co/api/ultrasystem/ultrav3.txt` |
| `decrypt_config.py` | the Argon2id/AES-256-GCM decoder (outer envelope + inner fields) |
| `build_slowdns_json.py` | merges both catalogues + the probe reports into `slowdns.json` |
| `probe_dns.py` | walks the delegation chain to the tunnel server's real IP |
| `probe_tcp.py` | probes the local end the way dnstt actually works (raw TCP, not SOCKS5) |
| `report/` | every measurement: `liveness`, `dns-probe`, `dns-endpoints`, `e2e`, `selftest` |

Write-up: [`../docs/ULTRA-TUNNEL.md`](../docs/ULTRA-TUNNEL.md).

Reproduce the decryption:

```bash
pip install argon2-cffi pycryptodome
python3 decrypt_config.py assets/configfile.json out.json      # bundled
python3 decrypt_config.py assets/remote-catalog.enc out2.json  # live updater
```
