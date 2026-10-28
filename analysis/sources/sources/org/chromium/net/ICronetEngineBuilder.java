package org.chromium.net;

import com.liapp.y;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import org.chromium.net.CronetEngine;

/* loaded from: classes2.dex */
public abstract class ICronetEngineBuilder {
    public static final int CONNECTION_MIGRATION_OPTIONS = 1;
    public static final int DNS_OPTIONS = 2;
    public static final int PROXY_OPTIONS = 4;
    public static final int QUIC_OPTIONS = 3;

    public abstract ICronetEngineBuilder addPublicKeyPins(String str, Set<byte[]> set, boolean z, Date date);

    public abstract ICronetEngineBuilder addQuicHint(String str, int i, int i2);

    public abstract ExperimentalCronetEngine build();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder enableBrotli(boolean z) {
        return this;
    }

    public abstract ICronetEngineBuilder enableHttp2(boolean z);

    public abstract ICronetEngineBuilder enableHttpCache(int i, long j);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder enableNetworkQualityEstimator(boolean z) {
        return this;
    }

    public abstract ICronetEngineBuilder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z);

    public abstract ICronetEngineBuilder enableQuic(boolean z);

    public abstract ICronetEngineBuilder enableSdch(boolean z);

    public abstract String getDefaultUserAgent();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLogCronetInitializationRef() {
        return 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<Integer> getSupportedConfigOptions() {
        return Collections.emptySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder setConnectionMigrationOptions(ConnectionMigrationOptions connectionMigrationOptions) {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder setDnsOptions(DnsOptions dnsOptions) {
        return this;
    }

    public abstract ICronetEngineBuilder setExperimentalOptions(String str);

    public abstract ICronetEngineBuilder setLibraryLoader(CronetEngine.Builder.LibraryLoader libraryLoader);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder setProxyOptions(ProxyOptions proxyOptions) {
        throw new UnsupportedOperationException(y.گ֮۬۲ݮ(2086542547));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder setQuicOptions(QuicOptions quicOptions) {
        return this;
    }

    public abstract ICronetEngineBuilder setStoragePath(String str);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ICronetEngineBuilder setThreadPriority(int i) {
        return this;
    }

    public abstract ICronetEngineBuilder setUserAgent(String str);
}
