# The MasterDnsVPN connection core, ported

This document maps **every** client-side balancing feature of MasterDnsVPN to
what is implemented here, with the upstream default and the test that proves it.

Upstream: `github.com/masterking32/MasterDnsVPN`, commit
`5f83ee9a1690a968f9edf495d3a7e00a2043b0bd`
(`internal/client/balancer.go`, `internal/config/client.go`).

> **Server compatibility is untouched.** Everything on this page decides *which
> resolver* receives a packet. Not one byte of the frame, envelope, QNAME
> encoding or handshake changed, so a stock MasterDnsVPN server cannot tell the
> difference. The live CI job proves it on every push by talking to the real Go
> server built from upstream source.

---

## 1. The nine strategies (exact ids)

`RESOLVER_BALANCING_STRATEGY` — upstream accepts `0..8` and defaults to **2**.

| id | Upstream constant | Here | Rule |
| --- | --- | --- | --- |
| 0 | `BalancingRoundRobinDefault` | `ROUND_ROBIN_DEFAULT` | round robin |
| 1 | `BalancingRandom` | `RANDOM` | uniform random over actives |
| 2 | `BalancingRoundRobin` | `ROUND_ROBIN` | round robin (**default**) |
| 3 | `BalancingLeastLoss` | `LEAST_LOSS` | lowest `(lost*1000)/sent` |
| 4 | `BalancingLowestLatency` | `LOWEST_LATENCY` | lowest mean RTT |
| 5 | `BalancingHybridScore` | `HYBRID_SCORE` | `loss*8 + min(rtt_ms,1000)` |
| 6 | `BalancingLossThenLatency` | `LOSS_THEN_LATENCY` | loss shortlist (±25), then latency tier |
| 7 | `BalancingLeastLossTopRandom` | `LEAST_LOSS_TOP_RANDOM` | best loss tier, random member |
| 8 | `BalancingLeastLossTopRoundRobin` | `LEAST_LOSS_TOP_ROUND_ROBIN` | best loss tier, rotating member |

Scoring is copied line for line (`BalancerTest` pins the numbers):

* `lossScore = sent < 5 ? 200 : lost == 0 ? 0 : (lost * 1000) / sent`
* `latencyScore = rttCount < 5 ? 999000 : rttMicrosSum / rttCount` (microseconds)
* `hybridScore = lossScore * 8 + (unknown ? 200 : min(rttMs, 1000))`
* top tier size = `max(2, (n + 9) / 10)`
* loss tolerance for strategy 6 = `bestLoss >= 200 ? 0 : 25`
* latency tolerance = `bestLatency >= 200 ? 0 : clamp(bestLatency / 4, 2, 25)`
* counters halve once any of them passes **1000** samples

## 2. Duplication and multi-path

| Upstream key | Default | Here |
| --- | --- | --- |
| `PACKET_DUPLICATION_COUNT` | **2** | `TunnelConfig.packetDuplication` (clamped 1..10, same as upstream) |
| `SETUP_PACKET_DUPLICATION_COUNT` | 2 | not needed: our SESSION_INIT is a single exchange and the balancer already retries it |
| `STREAM_RESOLVER_FAILOVER_RESEND_THRESHOLD` | **2** | `TunnelConfig.streamFailoverThreshold` |
| `STREAM_RESOLVER_FAILOVER_COOLDOWN` | **2.5 s** | `TunnelConfig.streamFailoverCooldownMs` |

`SelectTargets` semantics are reproduced: the first target is the stream's
sticky resolver, the remaining ones are the best others by the active strategy,
always **distinct**.

**Bug this uncovered in our own code:** duplicated queries used to throw their
responses away, so when the ACK came back on the copy instead of the primary the
stream retransmitted forever. Multi-path only works if every response is fed
into the state machine — fixed, and it is what made the 12-resolver live test
start passing.

## 3. Stream stickiness and failover

A stream keeps its resolver (`preferredForKey`) so packets of one stream do not
arrive reordered. A resend streak of `STREAM_RESOLVER_FAILOVER_RESEND_THRESHOLD`
after the cooldown moves **only that stream** elsewhere. On a timeout the
stickiness is dropped so the next retransmit is chosen by the strategy, which
already excludes parked resolvers.

## 4. Auto-disable and recheck

| Upstream key | Default | Here |
| --- | --- | --- |
| `AUTO_DISABLE_TIMEOUT_SERVERS` | **true** | `autoDisableTimedOutResolvers` |
| `AUTO_DISABLE_TIMEOUT_WINDOW_SECONDS` | **30** | `autoDisableWindowMs` |
| `RECHECK_INACTIVE_SERVERS_ENABLED` | **true** | `recheckInactiveResolvers` |

Upstream parks a resolver when **every** send inside the window timed out and
the observation count passed a pool-size-dependent threshold
(`48/40/34/26/22/18/15/13/10/8/7/6`, scaled ×2 at 30 s and ×3 at 60 s), and it
never prunes a pool of ≤3.

**One deliberate addition** (documented, not hidden): a resolver is *also*
parked after **3 consecutive timeouts**, provided at least two resolvers stay
active. Upstream confirms a suspected resolver with a direct probe; we do not
have that probe in this client yet, so the timeouts themselves are the
confirmation. Without it, a pool with 50 % dead resolvers spent its whole
budget retrying them — measured in CI.

Parked resolvers are re-probed with a PING every `recheckIntervalMs`; the first
answer puts them back in the pool (`reactivate`).

## 5. What is *not* ported (and why)

| Upstream feature | Status | Reason |
| --- | --- | --- |
| MTU probing (`MTU_TEST_*`, `AUTO_REMOVE_LOW_MTU_SERVERS`) | not ported | needs MTU probe packets; our client uses a fixed/configurable MTU that the server clamps. Adding it changes the wire dialogue |
| Compression negotiation | not ported | client always offers OFF, the server accepts |
| Local DNS cache / `LOCAL_DNS_*` | partially | Android already runs a DNS mode through the tunnel; no local cache file |
| `FD_CONTROL_UNIX_SOCKET` | n/a | Android uses `VpnService.protect(fd)` directly |
| Load balancing across *domains* | not ported | our pool is per-domain by design |

## 6. Verification

Unit tests (`core/src/test/kotlin/io/amtunnel/core/BalancerTest.kt`, 19 tests):
formula values, strategy ids, round-robin spread, random bounds, least-loss and
lowest-latency preference, loss-then-latency tolerance, top-tier size,
duplication distinctness, inactive exclusion, stream stickiness, cooldown,
auto-disable (window rule **and** 3-strike rule), recheck reactivation, and a
1000-resolver spread test.

Live tests against the real Go server (`integration/src/test/...`):

* `test2` — real HTTP through the tunnel with `PACKET_DUPLICATION_COUNT = 2`.
* `test4` — **10 resolvers**, baseline traffic, then **5 killed mid-session**:
  `state=READY`, `down` kept growing (846 B → 1697 B), `timeouts=2`, no
  re-handshake. This is the "resolvers keep dropping" case.
* `test5` — scoring keeps the clean resolver ahead of a lossy one.

Run evidence (CI run for commit `c1e2f28`):

```
[baseline]   state=READY pool=10/10 tx=4  dupes=4  timeouts=0 down=846B
[after-loss] state=READY pool=10/10 tx=13 dupes=11 timeouts=2 down=1697B
```

## 7. Tuning on a bad network

The defaults are upstream's, which are tuned for exactly this situation, but the
UI exposes the two knobs that matter most:

* `PACKET_DUPLICATION_COUNT` — raise to 3 on very lossy networks (costs upload
  bandwidth; the server discards duplicate sequence numbers).
* `RESOLVER_BALANCING_STRATEGY` — `2` round robin for big healthy pools, `7`/`8`
  when loss differs wildly between resolvers, `3` when one resolver is clearly
  cleaner.

Any resolver set the health module has not confirmed tunnel-capable stays
inactive, so importing 5000 resolvers that only answer A records will not
dilute the pool.
