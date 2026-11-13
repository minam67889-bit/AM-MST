package org.chromium.net;

/* loaded from: classes2.dex */
public final class ConnectionMigrationOptions {
    private final Boolean mAllowNonDefaultNetworkUsage;
    private final Boolean mAllowServerMigration;
    private final Boolean mEnableDefaultNetworkMigration;
    private final Boolean mEnablePathDegradationMigration;
    private final Long mIdleMigrationPeriodSeconds;
    private final Integer mMaxPathDegradingEagerMigrationsCount;
    private final Long mMaxTimeOnNonDefaultNetworkSeconds;
    private final Integer mMaxWriteErrorEagerMigrationsCount;
    private final Boolean mMigrateIdleConnections;
    private final Boolean mRetryPreHandshakeErrorsOnAlternateNetwork;

    public @interface Experimental {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getAllowNonDefaultNetworkUsage() {
        return this.mAllowNonDefaultNetworkUsage;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getAllowServerMigration() {
        return this.mAllowServerMigration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getEnableDefaultNetworkMigration() {
        return this.mEnableDefaultNetworkMigration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getEnablePathDegradationMigration() {
        return this.mEnablePathDegradationMigration;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Long getIdleMigrationPeriodSeconds() {
        return this.mIdleMigrationPeriodSeconds;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer getMaxPathDegradingEagerMigrationsCount() {
        return this.mMaxPathDegradingEagerMigrationsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Long getMaxTimeOnNonDefaultNetworkSeconds() {
        return this.mMaxTimeOnNonDefaultNetworkSeconds;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer getMaxWriteErrorEagerMigrationsCount() {
        return this.mMaxWriteErrorEagerMigrationsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getMigrateIdleConnections() {
        return this.mMigrateIdleConnections;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getRetryPreHandshakeErrorsOnAlternateNetwork() {
        return this.mRetryPreHandshakeErrorsOnAlternateNetwork;
    }

    public static class Builder {
        private Boolean mAllowNonDefaultNetworkUsage;
        private Boolean mAllowServerMigration;
        private Boolean mEnableDefaultNetworkConnectionMigration;
        private Boolean mEnablePathDegradationMigration;
        private Long mIdleConnectionMigrationPeriodSeconds;
        private Integer mMaxPathDegradingEagerMigrationsCount;
        private Long mMaxTimeOnNonDefaultNetworkSeconds;
        private Integer mMaxWriteErrorEagerMigrationsCount;
        private Boolean mMigrateIdleConnections;
        private Boolean mRetryPreHandshakeErrorsOnAlternateNetwork;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder allowNonDefaultNetworkUsage(boolean z) {
            this.mAllowNonDefaultNetworkUsage = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder allowServerMigration(boolean z) {
            this.mAllowServerMigration = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConnectionMigrationOptions build() {
            return new ConnectionMigrationOptions(this, 0);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder enableDefaultNetworkMigration(boolean z) {
            this.mEnableDefaultNetworkConnectionMigration = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder enablePathDegradationMigration(boolean z) {
            this.mEnablePathDegradationMigration = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder migrateIdleConnections(boolean z) {
            this.mMigrateIdleConnections = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder retryPreHandshakeErrorsOnNonDefaultNetwork(boolean z) {
            this.mRetryPreHandshakeErrorsOnAlternateNetwork = Boolean.valueOf(z);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder setIdleConnectionMigrationPeriodSeconds(long j) {
            this.mIdleConnectionMigrationPeriodSeconds = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder setMaxPathDegradingNonDefaultNetworkMigrationsCount(int i) {
            this.mMaxPathDegradingEagerMigrationsCount = Integer.valueOf(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder setMaxTimeOnNonDefaultNetworkSeconds(long j) {
            this.mMaxTimeOnNonDefaultNetworkSeconds = Long.valueOf(j);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Experimental
        public Builder setMaxWriteErrorNonDefaultNetworkMigrationsCount(int i) {
            this.mMaxWriteErrorEagerMigrationsCount = Integer.valueOf(i);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Builder(int i) {
            this();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConnectionMigrationOptions(Builder builder) {
        this.mEnableDefaultNetworkMigration = builder.mEnableDefaultNetworkConnectionMigration;
        this.mEnablePathDegradationMigration = builder.mEnablePathDegradationMigration;
        this.mAllowServerMigration = builder.mAllowServerMigration;
        this.mMigrateIdleConnections = builder.mMigrateIdleConnections;
        this.mIdleMigrationPeriodSeconds = builder.mIdleConnectionMigrationPeriodSeconds;
        this.mRetryPreHandshakeErrorsOnAlternateNetwork = builder.mRetryPreHandshakeErrorsOnAlternateNetwork;
        this.mAllowNonDefaultNetworkUsage = builder.mAllowNonDefaultNetworkUsage;
        this.mMaxTimeOnNonDefaultNetworkSeconds = builder.mMaxTimeOnNonDefaultNetworkSeconds;
        this.mMaxWriteErrorEagerMigrationsCount = builder.mMaxWriteErrorEagerMigrationsCount;
        this.mMaxPathDegradingEagerMigrationsCount = builder.mMaxPathDegradingEagerMigrationsCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ ConnectionMigrationOptions(Builder builder, int i) {
        this(builder);
    }
}
