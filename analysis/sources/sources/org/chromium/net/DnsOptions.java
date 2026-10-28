package org.chromium.net;

import java.time.Duration;
import java.util.Objects;

/* loaded from: classes2.dex */
public final class DnsOptions {
    private final Boolean mEnableStaleDns;
    private final Boolean mPersistHostCache;
    private final Long mPersistHostCachePeriodMillis;
    private final Boolean mPreestablishConnectionsToStaleDnsResults;
    private final StaleDnsOptions mStaleDnsOptions;
    private final Boolean mUseBuiltInDnsResolver;

    public @interface Experimental {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DnsOptions(Builder builder) {
        this.mEnableStaleDns = builder.mEnableStaleDns;
        this.mStaleDnsOptions = builder.mStaleDnsOptions;
        this.mPersistHostCachePeriodMillis = builder.mPersistHostCachePeriodMillis;
        this.mPreestablishConnectionsToStaleDnsResults = builder.mPreestablishConnectionsToStaleDnsResults;
        this.mUseBuiltInDnsResolver = builder.mUseBuiltInDnsResolver;
        this.mPersistHostCache = builder.mPersistHostCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getEnableStaleDns() {
        return this.mEnableStaleDns;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getPersistHostCache() {
        return this.mPersistHostCache;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Long getPersistHostCachePeriodMillis() {
        return this.mPersistHostCachePeriodMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getPreestablishConnectionsToStaleDnsResults() {
        return this.mPreestablishConnectionsToStaleDnsResults;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StaleDnsOptions getStaleDnsOptions() {
        return this.mStaleDnsOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getUseBuiltInDnsResolver() {
        return this.mUseBuiltInDnsResolver;
    }

    public static class StaleDnsOptions {
        private final Boolean mAllowCrossNetworkUsage;
        private final Long mFreshLookupTimeoutMillis;
        private final Long mMaxExpiredDelayMillis;
        private final Boolean mUseStaleOnNameNotResolved;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StaleDnsOptions(Builder builder) {
            this.mFreshLookupTimeoutMillis = builder.mFreshLookupTimeoutMillis;
            this.mMaxExpiredDelayMillis = builder.mMaxExpiredDelayMillis;
            this.mAllowCrossNetworkUsage = builder.mAllowCrossNetworkUsage;
            this.mUseStaleOnNameNotResolved = builder.mUseStaleOnNameNotResolved;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Builder builder() {
            return new Builder();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Boolean getAllowCrossNetworkUsage() {
            return this.mAllowCrossNetworkUsage;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Long getFreshLookupTimeoutMillis() {
            return this.mFreshLookupTimeoutMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Long getMaxExpiredDelayMillis() {
            return this.mMaxExpiredDelayMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Boolean getUseStaleOnNameNotResolved() {
            return this.mUseStaleOnNameNotResolved;
        }

        public static final class Builder {
            private Boolean mAllowCrossNetworkUsage;
            private Long mFreshLookupTimeoutMillis;
            private Long mMaxExpiredDelayMillis;
            private Boolean mUseStaleOnNameNotResolved;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder allowCrossNetworkUsage(boolean z) {
                this.mAllowCrossNetworkUsage = Boolean.valueOf(z);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public StaleDnsOptions build() {
                return new StaleDnsOptions(this);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFreshLookupTimeout(Duration duration) {
                long millis;
                Objects.requireNonNull(duration);
                millis = duration.toMillis();
                return setFreshLookupTimeoutMillis(millis);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setFreshLookupTimeoutMillis(long j) {
                this.mFreshLookupTimeoutMillis = Long.valueOf(j);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMaxExpiredDelay(Duration duration) {
                long millis;
                Objects.requireNonNull(duration);
                millis = duration.toMillis();
                return setMaxExpiredDelayMillis(millis);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder setMaxExpiredDelayMillis(long j) {
                this.mMaxExpiredDelayMillis = Long.valueOf(j);
                return this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Builder useStaleOnNameNotResolved(boolean z) {
                this.mUseStaleOnNameNotResolved = Boolean.valueOf(z);
                return this;
            }
        }
    }

    public static final class Builder {
        private Boolean mEnableStaleDns;
        private Boolean mPersistHostCache;
        private Long mPersistHostCachePeriodMillis;
        private Boolean mPreestablishConnectionsToStaleDnsResults;
        private StaleDnsOptions mStaleDnsOptions;
        private Boolean mUseBuiltInDnsResolver;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public DnsOptions build() {
            return new DnsOptions(this);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder enableStaleDns(boolean z) {
            this.mEnableStaleDns = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder persistHostCache(boolean z) {
            this.mPersistHostCache = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder preestablishConnectionsToStaleDnsResults(boolean z) {
            this.mPreestablishConnectionsToStaleDnsResults = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPersistDelay(Duration duration) {
            long millis;
            Objects.requireNonNull(duration);
            millis = duration.toMillis();
            return setPersistHostCachePeriodMillis(millis);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setPersistHostCachePeriodMillis(long j) {
            this.mPersistHostCachePeriodMillis = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder useBuiltInDnsResolver(boolean z) {
            this.mUseBuiltInDnsResolver = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder setStaleDnsOptions(StaleDnsOptions.Builder builder) {
            return setStaleDnsOptions(builder.build());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder setStaleDnsOptions(StaleDnsOptions staleDnsOptions) {
            this.mStaleDnsOptions = staleDnsOptions;
            return this;
        }
    }
}
