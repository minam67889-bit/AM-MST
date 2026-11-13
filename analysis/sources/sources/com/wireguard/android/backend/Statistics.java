package com.wireguard.android.backend;

import android.os.SystemClock;
import com.liapp.y;
import com.wireguard.crypto.Key;
import com.wireguard.util.NonNullForAll;
import defpackage.F40;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@NonNullForAll
/* loaded from: classes.dex */
public class Statistics {
    private final Map<Key, PeerStats> stats = new HashMap();
    private long lastTouched = SystemClock.elapsedRealtime();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(Key key, long j, long j2, long j3) {
        this.stats.put(key, new PeerStats(j, j2, j3));
        this.lastTouched = SystemClock.elapsedRealtime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStale() {
        return SystemClock.elapsedRealtime() - this.lastTouched > 900;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PeerStats peer(Key key) {
        return this.stats.get(key);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Key[] peers() {
        return (Key[]) this.stats.keySet().toArray(new Key[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long totalRx() {
        Iterator<PeerStats> it = this.stats.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().rxBytes;
        }
        return j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long totalTx() {
        Iterator<PeerStats> it = this.stats.values().iterator();
        long j = 0;
        while (it.hasNext()) {
            j += it.next().txBytes;
        }
        return j;
    }

    public static final class PeerStats extends F40 {
        private final long latestHandshakeEpochMillis;
        private final long rxBytes;
        private final long txBytes;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PeerStats(long j, long j2, long j3) {
            this.rxBytes = j;
            this.txBytes = j2;
            this.latestHandshakeEpochMillis = j3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean equals(Object obj) {
            if (obj != null && PeerStats.class == obj.getClass()) {
                return Arrays.equals(F(), ((PeerStats) obj).F());
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int hashCode() {
            return PeerStats.class.hashCode() + (Arrays.hashCode(F()) * 31);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long latestHandshakeEpochMillis() {
            return this.latestHandshakeEpochMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long rxBytes() {
            return this.rxBytes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String toString() {
            Object[] F = F();
            String str = y.گ֮۬۲ݮ(2086592331);
            String[] split = str.length() == 0 ? new String[0] : str.split(y.ܴٳݴܯޫ(-170202591));
            StringBuilder sb = new StringBuilder();
            sb.append(PeerStats.class.getSimpleName());
            sb.append(y.گ֮۬۲ݮ(2086592195));
            for (int i = 0; i < split.length; i++) {
                sb.append(split[i]);
                sb.append(y.۳׭خ۲ݮ(1787195287));
                sb.append(F[i]);
                if (i != split.length - 1) {
                    sb.append(y.گ֮۬۲ݮ(2086592147));
                }
            }
            sb.append(y.ܴ٭׮ڱܭ(-366252012));
            return sb.toString();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long txBytes() {
            return this.txBytes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final /* synthetic */ Object[] F() {
            return new Object[]{Long.valueOf(this.rxBytes), Long.valueOf(this.txBytes), Long.valueOf(this.latestHandshakeEpochMillis)};
        }
    }
}
