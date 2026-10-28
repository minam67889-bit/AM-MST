# DNS: the servers, the two algorithms, and the connection test

The target of this pass is the DNS path only: pull the DNS servers out of
BD NET, prove that *their* client algorithm and *our* client algorithm both
work, and take a real connection test — theirs first, ours second.

Everything below is measured, not assumed. Where something could not be
measured, it says so and says why.

---

## 1. The DNS servers (the deliverable)

Two independent sources agree. The bundled config inside the v106 APK and the
live `JSONDEC2025` bundle fetched from the app's own update URL contain the same
three DNS families:

| family | engine the app runs | what we extracted | transport |
| --- | --- | --- | --- |
| **SlowDNS** | `libdns` / `pdnsd`, `PdnsdType = tcp_only` | **20 tunnel domains**: `de1.liftmeon.org` … `de20.liftmeon.org` | DNS over **TCP/53** |
| **FastDNS** | `libxdnstt` (dnstt, Go, Noise_NK_25519) | **100 IPv4 endpoints**, e.g. `173.212.232.241`, `173.212.252.3`, `173.249.10.48`, `173.249.15.5`, `185.196.21.114`, `192.145.37.229` | DNS over **UDP/53** |
| **UDPQ** | `libudpq` / `libudpqtwo` | **725 IPv4 endpoints**, e.g. `161.97.73.205`, `161.97.73.250` | UDP **6000-19999** or **20000-50000** |

The 20 SlowDNS domains are not aliases of one box: each resolves to its own
address, `13.140.185.158` … `13.140.185.181`.

Machine readable, one file per set:

```
analysis-bdnet/configs/dns/servers.json           845 entries  {mode, host, port, transport, server_name}
analysis-bdnet/configs/dns/servers_bundled.json   680 entries  (what ships inside the v106 APK)
analysis-bdnet/configs/dns/sandbox-egress.json    what this host can and cannot reach
```

Counts, live bundle (v56) vs bundled (v106):

```
live      slowdns 20   fastdns 100   udpq 725     = 845 endpoints
bundled   slowdns 20   fastdns 100   udpq 560     = 680 endpoints
```

`port` is `53` for SlowDNS/FastDNS (the protocol fixes it) and `0` for UDPQ,
whose port is drawn from the payload's range — see `port_specs` in the file.

**What is not in there:** a dnstt public key. The FastDNS/SlowDNS binaries are
Go and take `-pubkey` as an argument, so the key is handed over from Java at
call time and is not in the bundles, the string table or the native
`strings` dumps. Without it a dnstt *handshake* cannot be completed; what can
be tested without it is reachability and the DNS layer, which is what the two
tests below do.

---

## 2. Algorithm A — theirs (`SocksDNSService.d()`)

The app does not invent a protocol at this level. It writes a config file and
`exec`s its own binary:

```java
String s = loadServerDat(ctx, "server.psi");   // asset text
new ProcessBuilder(new File(this.k.getCanonicalPath()).getAbsolutePath(),
                   "client", "--config", configJson).start();
```

The config it writes (template id `-91013983860619`, values from the string
table):

```json
{
  "server": "<pEncrypt(ip:port)>",
  "validate": "1",
  "confuse": "3",
  "rx": 3,
  "tx": -1,
  "retry": 1,
  "retry_interval": 1,
  "socks5": { "listen": "127.0.0.1:10802" },
  "recv_window_conn": 196608,
  "recv_window": 491520,
  "report": "BD NET"
}
```

`pEncrypt` is the native mirror of the `pDecrypt` recovered earlier — `hex` of
the XOR of the text with the 12-byte key `4%PdXch>fkP]`:

```
13.140.185.158:53   ->   05167e556c53460f5e5e7e6c011d6a516b
```

Reproduce, and check it round-trips:

```bash
python3 tools/bdnet_dns.py config --host 13.140.185.158 --port 53
python3 tools/bdnet_dns.py selftest          # 8/8 PASS
```

On the SlowDNS side there is a second, older code path that is worth knowing,
because it is the one the 20 domains belong to — `Tunnel.java` builds a `pdnsd`
config out of `res/raw/pdnsd_local`:

```java
// Pdnsd.java
"server {\n label= \"%1$s\";\n ip = %2$s;\n port = %3$d;\n uptest = none;\n }\n"
// Tunnel.java - one block per DNS host, port fixed at 53
new Pdnsd(context, strArr, 53, vpnAddress, findAvailablePort, PDNSD_TYPE)
```

So every `deN.liftmeon.org:53` gets its own `server {}` block, `uptest = none`
(no health probing at all), and the upstream transport comes from the
`PDNSD_TYPE` preference — default `tcp_only`, switchable to `udp_only`
(id `-163311168354187` → `PDNSD_TYPE`, `-163358412994443` → `tcp_only`).
pdnsd chooses among those blocks, so "theirs" is not purely sequential: it is
one dumb pool with no scoring, no failover and no duplication.

The test reproduces their **transport** faithfully — TCP/53 per host,
`retry = 1`, `retry_interval = 1`, `validate = 1`, `confuse = 3`, the exact
windows — and runs it sequentially so the comparison against our scoring client
is apples to apples: `tools/bdnet_dns.py their`.

---

## 3. Algorithm B — ours (MasterDnsVPN shape)

This is the client the project already ships, and it is what the DNS test
exercises:

* every resolver is probed **concurrently** instead of one at a time;
* per resolver it keeps sent/acked/lost and a decaying RTT, and ranks with
  `loss*8 + min(rtt, 1000)` (`HYBRID_SCORE`);
* each packet is routed to **two** resolvers (`PACKET_DUPLICATION_COUNT = 2`)
  so one dead box does not cost a round trip;
* a resolver that does not answer inside a 30 s window is parked, and the pool
  is never allowed to shrink below 2.

The host-side port is `tools/bdnet_dns.py mine`; the shipping Kotlin is
`core/src/main/kotlin/io/amtunnel/core/transport/MasterBalancer.kt`, and
`tools/BalancerLiveRunner.kt` compiles that **exact** file and drives it with
real socket RTTs — no fakes:

```
tools/bdnet_dns.py mine  analysis-bdnet/configs/dns/servers.json --mode slowdns
tools/bdnet_dns.py compare analysis-bdnet/configs/dns/servers.json --mode slowdns
java -jar balancer-live.jar hosts.txt 5 3
```

### Proof that runs anywhere, including this sandbox

`python3 tools/bdnet_dns.py loopback` stands up a real UDP and a real TCP DNS
responder on loopback, adds a bound-then-closed UDP port as a dead control,
then runs **both** clients against them over actual sockets:

```
local resolver  udp 127.0.0.1:59063   tcp 127.0.0.1:37989
dead control    udp 127.0.0.1:54836 (bound then closed)

                       theirs (pdnsd/tcp)    ours (balanced/udp)
reachable              1/1                   1/2
LOOPBACK PASS: their client answered over TCP, our client answered over UDP
               and rejected the dead port
```

That is the part of "do the algorithms work" that does not need the internet:
their code path (TCP-only, sequential) answers, our code path (parallel,
scored) answers and correctly refuses the dead endpoint.

---

## 4. Why the live test cannot run from this sandbox

Measured here, twice, two ways (`analysis-bdnet/configs/dns/sandbox-egress.json`):

| path | result |
| --- | --- |
| name resolution (`de1.liftmeon.org` → `13.140.185.158`) | **works** |
| UDP/53 → `8.8.8.8` | answers (61 B, rcode 0) |
| UDP/53 → `1.1.1.1`, `8.8.4.4`, `9.9.9.9`, `208.67.222.222`, `94.140.14.14` | **dropped** |
| UDP/53 → `13.140.185.158` (SlowDNS) | **dropped** |
| UDP 5000/20000 → `161.97.73.205` (UDPQ) | **dropped** |
| TCP/53 → all 20 `deN.liftmeon.org` | connect accepted, then **RST in 0.5-1.1 ms** |
| TCP/443 → `192.0.2.55` (TEST-NET — must not exist) | also accepts, then EOF |

The last line is the tell: a TCP `connect()` to an address that cannot exist
succeeds here, so every TCP port is answered by a local proxy and a successful
`connect()` proves nothing about the far end. UDP is allowlisted to
`8.8.8.8:53` only. **A tunnel connection cannot be opened from this sandbox**,
by any client, theirs or ours — the first probe of the SlowDNS set returned
0/20 over UDP and 0/20 over TCP.

So the live run happens where egress is real: GitHub Actions runners.

---

## 5. The live test: `.github/workflows/dns-connect-test.yml`

Two jobs, both against the same extracted list:

1. **`theirs vs ours (python)`** — `selftest`, emits the exact config the app
   would write, then
   * `their` — SlowDNS, TCP/53, sequential, retry 1/1 s (their settings);
   * `mine` — SlowDNS, UDP/53, all 20 in flight, scored, duplicated;
   * `compare` — both on the same host list, same timeout;
   * FastDNS (100 × UDP/53) and UDPQ (725 × UDP/53) reachability.
2. **`kotlin-balancer`** — installs `kotlinc`, compiles the shipping
   `MasterBalancer.kt` + `ResolverEndpoint.kt` + `BalancerLiveRunner.kt`, runs
   strategy 5 for 3 rounds against 32 live hosts plus two addresses that cannot
   exist, and prints the routing decisions and the auto-disable log.

Everything is written to `GITHUB_STEP_SUMMARY` and uploaded as
`dns-connect-test` / `balancer-live-run`.

Run it: `gh workflow run dns-connect-test.yml -f mode=slowdns`.

> Results are published back into the branch by the workflow itself, under
> `analysis-bdnet/configs/dns/results/`.

---

## 6. Results

Live, from GitHub Actions. Numbers below are from runs `40763098113` (head to
head) and `40765192422` (FastDNS, UDPQ, balancer); every step publishes its
output back into `analysis-bdnet/configs/dns/results/` because CI artifacts are
not reachable from the dev sandbox.

### 6.1 SlowDNS — their transport vs ours, same 20 hosts, same timeout

| | theirs `tcp_only` (shipped default) | theirs `udp_only` | ours (balanced) |
| --- | --- | --- | --- |
| reachable | **0 / 20** | **19 / 20** | **17 / 20** |
| wall clock | 28.0 s | 16.1 s | **6.0 s** |
| mean RTT | – (all `ConnectionRefused`) | 162 ms | 194 ms |

* Every one of the 20 `deN.liftmeon.org` refused **TCP/53** in under 1.5 s. The
  app's shipped `PdnsdType = tcp_only` therefore cannot connect on this network
  at all — the default is simply wrong, and the same client works the moment
  `PDNSD_TYPE` is switched to `udp_only`.
* Ours covers 17/20 in **6.0 s** — one probe timeout — because all 20 are in
  flight at once, against 16.1 s for theirs (sequential, one retry each). The
  three misses are per-attempt UDP loss, which is exactly what the duplicate
  routing and the 30 s auto-disable window exist for.

### 6.2 The shipping Kotlin balancer against live resolvers

`analysis-bdnet/configs/dns/results/balancer-run.txt` — 34 endpoints, 3 rounds,
strategy 5 (`HYBRID_SCORE`):

```
endpoints     : 34 resolved, 0 unresolvable
round 1       : 20/20 SlowDNS answered, 89-251 ms, rcode=3, 41 B
round 2       : 17/20 SlowDNS answered
round 3       : 20/20 SlowDNS answered
active pool   : 20/34
selectTargets(2) : 13.140.185.158:53 + 13.140.185.159:53   (packet duplication)
nextForRecheck() : 173.212.232.241:53
auto-disabled : 14 endpoints, all TIMEOUT_STREAK
                (12 FastDNS + 192.0.2.1 + 198.51.100.1, the two controls)
LIVE RUN PASS: 57/102 probes answered, 20 resolvers still routable
```

That is the behaviour the design promises, on real sockets: every SlowDNS
resolver stayed routable, every dead endpoint — including both RFC 5737
controls — was parked automatically, and the routing calls kept handing out
live resolvers.

### 6.3 FastDNS (dnstt, 100 endpoints, UDP/53)

```
0/100 answered in 5.03 s (all in flight at once) - all TimeoutError
```

Silence here is *expected and not evidence of death*: a dnstt server only
decodes qnames that carry a valid tunnel frame and has no reason to answer a
random label. Distinguishing "strict" from "down" needs the `-pubkey` (see §7).
The SlowDNS result above rules out the runner's network as the cause: UDP/53
egress works, 19/20 of the SlowDNS set answered.

### 6.4 UDPQ (725 endpoints, UDP 6000-19999)

```
196/725 answered in 15.02 s (all in flight at once)
tier0: 38.242.134.29, 89.116.31.42, 82.208.22.250
```

196 endpoints return a normal 42–44 byte NXDOMAIN for a random label — they are
open resolvers listening on the high ports, alive and fast (~90–120 ms). That
pool is the "thousands of resolvers" side of the design, and it measured
27 % alive.

### 6.5 What "reachable" means here

Every number above is *the server answered a DNS query on the expected port and
transport*. It is **not** "the tunnel came up": the tunnel needs the dnstt
`-pubkey` for FastDNS and the SlowDNS secret carried inside the payload. That is
the one link still missing, and it is the same gap as before — see §7.

## 7. Verified vs not

| claim | status |
| --- | --- |
| 20 SlowDNS domains, 100 FastDNS IPs, 725 UDPQ IPs extracted | **verified** — two bundles, same set, exact counts |
| their config JSON + `pEncrypt` reproduced | **verified** — `selftest` 8/8, round-trips |
| their client path answers DNS over TCP | **verified** — loopback, real socket |
| our client answers, scores, and rejects dead endpoints | **verified** — loopback, real socket |
| the balancer (shipping Kotlin) picks working resolvers | **verified in CI** — live run, see §6 |
| the real servers answer *this* network | **cannot be tested here** — egress blocked; measured in CI |
| a full DNS tunnel session through SlowDNS/FastDNS | **not yet** — needs the dnstt `-pubkey` (and, for SlowDNS, the server's `confuse` secret) |
| 18 Psiphon entries decrypted from `server.psi` | **verified** — `tools/bdnet_serverpsi.py`, full entries with credentials |
