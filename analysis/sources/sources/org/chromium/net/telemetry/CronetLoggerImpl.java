package org.chromium.net.telemetry;

import android.os.Build;
import android.os.Process;
import android.util.Log;
import com.liapp.y;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.chromium.net.impl.CronetLogger;

/* loaded from: classes2.dex */
public class CronetLoggerImpl extends CronetLogger {
    private static final String TAG = "CronetLoggerImpl";
    private final RateLimiter mRateLimiter;
    private final AtomicInteger mSamplesRateLimited;

    /* renamed from: org.chromium.net.telemetry.CronetLoggerImpl$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$chromium$net$impl$CronetLogger$CronetEngineBuilderInitializedInfo$Author;
        static final /* synthetic */ int[] $SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource;
        static final /* synthetic */ int[] $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestFailureReason;
        static final /* synthetic */ int[] $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestTerminalState;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[CronetLogger.CronetSource.values().length];
            $SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource = iArr;
            try {
                iArr[CronetLogger.CronetSource.CRONET_SOURCE_STATICALLY_LINKED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource[CronetLogger.CronetSource.CRONET_SOURCE_PLAY_SERVICES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource[CronetLogger.CronetSource.CRONET_SOURCE_FALLBACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource[CronetLogger.CronetSource.CRONET_SOURCE_PLATFORM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource[CronetLogger.CronetSource.CRONET_SOURCE_UNSPECIFIED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[CronetLogger.CronetTrafficInfo.RequestTerminalState.values().length];
            $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestTerminalState = iArr2;
            try {
                iArr2[CronetLogger.CronetTrafficInfo.RequestTerminalState.SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestTerminalState[CronetLogger.CronetTrafficInfo.RequestTerminalState.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestTerminalState[CronetLogger.CronetTrafficInfo.RequestTerminalState.CANCELLED.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[CronetLogger.CronetEngineBuilderInitializedInfo.Author.values().length];
            $SwitchMap$org$chromium$net$impl$CronetLogger$CronetEngineBuilderInitializedInfo$Author = iArr3;
            try {
                iArr3[CronetLogger.CronetEngineBuilderInitializedInfo.Author.API.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetEngineBuilderInitializedInfo$Author[CronetLogger.CronetEngineBuilderInitializedInfo.Author.IMPL.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr4 = new int[CronetLogger.CronetTrafficInfo.RequestFailureReason.values().length];
            $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestFailureReason = iArr4;
            try {
                iArr4[CronetLogger.CronetTrafficInfo.RequestFailureReason.NETWORK.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestFailureReason[CronetLogger.CronetTrafficInfo.RequestFailureReason.OTHER.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoConnectionCloseSource(int i) {
        if (i != 1) {
            return i != 2 ? 0 : 1;
        }
        return 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoCronetEngineBuilderInitializedAuthor(CronetLogger.CronetEngineBuilderInitializedInfo.Author author) {
        int i = AnonymousClass1.$SwitchMap$org$chromium$net$impl$CronetLogger$CronetEngineBuilderInitializedInfo$Author[author.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                return 0;
            }
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoCronetEngineBuilderInitializedSource(CronetLogger.CronetSource cronetSource) {
        int i = AnonymousClass1.$SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource[cronetSource.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoCronetEngineCreatedSource(CronetLogger.CronetSource cronetSource) {
        int i = AnonymousClass1.$SwitchMap$org$chromium$net$impl$CronetLogger$CronetSource[cronetSource.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    i2 = 4;
                    if (i != 4) {
                        return 0;
                    }
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoCronetRequestTerminalState(CronetLogger.CronetTrafficInfo.RequestTerminalState requestTerminalState) {
        int i = AnonymousClass1.$SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestTerminalState[requestTerminalState.ordinal()];
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2) {
                i2 = 3;
                if (i != 3) {
                    return 0;
                }
            }
        }
        return i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoFailureReason(CronetLogger.CronetTrafficInfo.RequestFailureReason requestFailureReason) {
        int i = AnonymousClass1.$SwitchMap$org$chromium$net$impl$CronetLogger$CronetTrafficInfo$RequestFailureReason[requestFailureReason.ordinal()];
        if (i != 1) {
            return i != 2 ? 0 : 100;
        }
        return 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int convertToProtoHttpCacheMode(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3) {
            return 4;
        }
        throw new IllegalArgumentException(y.ڮڴجۭݩ(1256688989));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.chromium.net.impl.CronetLogger
    public long generateId() {
        long nextLong = ThreadLocalRandom.current().nextLong(-9223372036854775807L, 9223372036854775805L);
        return nextLong >= -1 ? nextLong + 2 : nextLong;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.chromium.net.impl.CronetLogger
    public void logCronetEngineBuilderInitializedInfo(CronetLogger.CronetEngineBuilderInitializedInfo cronetEngineBuilderInitializedInfo) {
        ScopedSysTraceEvent scoped = ScopedSysTraceEvent.scoped(y.ش۳ֲ׬٨(1672384010));
        try {
            long j = cronetEngineBuilderInitializedInfo.cronetInitializationRef;
            int convertToProtoCronetEngineBuilderInitializedAuthor = convertToProtoCronetEngineBuilderInitializedAuthor(cronetEngineBuilderInitializedInfo.author);
            int i = cronetEngineBuilderInitializedInfo.engineBuilderCreatedLatencyMillis;
            int convertToProtoCronetEngineBuilderInitializedSource = convertToProtoCronetEngineBuilderInitializedSource(cronetEngineBuilderInitializedInfo.source);
            int value = OptionalBoolean.fromBoolean(cronetEngineBuilderInitializedInfo.creationSuccessful).getValue();
            int majorVersion = cronetEngineBuilderInitializedInfo.apiVersion.getMajorVersion();
            int minorVersion = cronetEngineBuilderInitializedInfo.apiVersion.getMinorVersion();
            int buildVersion = cronetEngineBuilderInitializedInfo.apiVersion.getBuildVersion();
            int patchVersion = cronetEngineBuilderInitializedInfo.apiVersion.getPatchVersion();
            CronetLogger.CronetVersion cronetVersion = cronetEngineBuilderInitializedInfo.implVersion;
            int majorVersion2 = cronetVersion == null ? -1 : cronetVersion.getMajorVersion();
            CronetLogger.CronetVersion cronetVersion2 = cronetEngineBuilderInitializedInfo.implVersion;
            int minorVersion2 = cronetVersion2 == null ? -1 : cronetVersion2.getMinorVersion();
            CronetLogger.CronetVersion cronetVersion3 = cronetEngineBuilderInitializedInfo.implVersion;
            int buildVersion2 = cronetVersion3 == null ? -1 : cronetVersion3.getBuildVersion();
            CronetLogger.CronetVersion cronetVersion4 = cronetEngineBuilderInitializedInfo.implVersion;
            CronetStatsLog.write(CronetStatsLog.CRONET_ENGINE_BUILDER_INITIALIZED, j, convertToProtoCronetEngineBuilderInitializedAuthor, i, convertToProtoCronetEngineBuilderInitializedSource, value, majorVersion, minorVersion, buildVersion, patchVersion, majorVersion2, minorVersion2, buildVersion2, cronetVersion4 == null ? -1 : cronetVersion4.getPatchVersion(), cronetEngineBuilderInitializedInfo.uid);
            if (scoped != null) {
                scoped.close();
            }
        } catch (Throwable th) {
            if (scoped == null) {
                throw th;
            }
            try {
                scoped.close();
                throw th;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.chromium.net.impl.CronetLogger
    public void logCronetEngineCreation(long j, CronetLogger.CronetEngineBuilderInfo cronetEngineBuilderInfo, CronetLogger.CronetVersion cronetVersion, CronetLogger.CronetSource cronetSource) {
        if (cronetEngineBuilderInfo == null || cronetVersion == null || cronetSource == null) {
            return;
        }
        writeCronetEngineCreation(j, cronetEngineBuilderInfo, cronetVersion, cronetSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.chromium.net.impl.CronetLogger
    public void logCronetInitializedInfo(CronetLogger.CronetInitializedInfo cronetInitializedInfo) {
        if (Build.VERSION.SDK_INT < 33) {
            return;
        }
        ScopedSysTraceEvent scoped = ScopedSysTraceEvent.scoped(y.ܴٳݴܯޫ(-170188055));
        try {
            CronetStatsLog.write(CronetStatsLog.CRONET_INITIALIZED, cronetInitializedInfo.cronetInitializationRef, cronetInitializedInfo.engineCreationLatencyMillis, cronetInitializedInfo.engineAsyncLatencyMillis, -1, OptionalBoolean.UNSET.getValue(), new long[0], new long[0], cronetInitializedInfo.cronetImplVersion, convertToProtoCronetEngineBuilderInitializedSource(cronetInitializedInfo.source), Process.myUid());
            if (scoped != null) {
                scoped.close();
            }
        } catch (Throwable th) {
            if (scoped != null) {
                try {
                    scoped.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.chromium.net.impl.CronetLogger
    public void logCronetTrafficInfo(long j, CronetLogger.CronetTrafficInfo cronetTrafficInfo) {
        if (cronetTrafficInfo == null) {
            return;
        }
        if (this.mRateLimiter.tryAcquire()) {
            writeCronetTrafficReported(j, cronetTrafficInfo, this.mSamplesRateLimited.getAndSet(0));
        } else {
            this.mSamplesRateLimited.incrementAndGet();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeCronetEngineCreation(long j, CronetLogger.CronetEngineBuilderInfo cronetEngineBuilderInfo, CronetLogger.CronetVersion cronetVersion, CronetLogger.CronetSource cronetSource) {
        try {
            ScopedSysTraceEvent scoped = ScopedSysTraceEvent.scoped("CronetLoggerImpl#writeCronetEngineCreation");
            try {
                ExperimentalOptions experimentalOptions = new ExperimentalOptions(cronetEngineBuilderInfo.getExperimentalOptions());
                CronetStatsLog.write(CronetStatsLog.CRONET_ENGINE_CREATED, j, cronetVersion.getMajorVersion(), cronetVersion.getMinorVersion(), cronetVersion.getBuildVersion(), cronetVersion.getPatchVersion(), convertToProtoCronetEngineCreatedSource(cronetSource), cronetEngineBuilderInfo.isBrotliEnabled(), cronetEngineBuilderInfo.isHttp2Enabled(), convertToProtoHttpCacheMode(cronetEngineBuilderInfo.getHttpCacheMode()), cronetEngineBuilderInfo.isPublicKeyPinningBypassForLocalTrustAnchorsEnabled(), cronetEngineBuilderInfo.isQuicEnabled(), cronetEngineBuilderInfo.isNetworkQualityEstimatorEnabled(), cronetEngineBuilderInfo.getThreadPriority(), experimentalOptions.getConnectionOptionsOption(), experimentalOptions.getStoreServerConfigsInPropertiesOption().getValue(), experimentalOptions.getMaxServerConfigsStoredInPropertiesOption(), experimentalOptions.getIdleConnectionTimeoutSecondsOption(), experimentalOptions.getGoawaySessionsOnIpChangeOption().getValue(), experimentalOptions.getCloseSessionsOnIpChangeOption().getValue(), experimentalOptions.getMigrateSessionsOnNetworkChangeV2Option().getValue(), experimentalOptions.getMigrateSessionsEarlyV2().getValue(), experimentalOptions.getDisableBidirectionalStreamsOption().getValue(), experimentalOptions.getMaxTimeBeforeCryptoHandshakeSecondsOption(), experimentalOptions.getMaxIdleTimeBeforeCryptoHandshakeSecondsOption(), experimentalOptions.getEnableSocketRecvOptimizationOption().getValue(), experimentalOptions.getAsyncDnsEnableOption().getValue(), experimentalOptions.getStaleDnsEnableOption().getValue(), experimentalOptions.getStaleDnsDelayMillisOption(), experimentalOptions.getStaleDnsMaxExpiredTimeMillisOption(), experimentalOptions.getStaleDnsMaxStaleUsesOption(), experimentalOptions.getStaleDnsAllowOtherNetworkOption().getValue(), experimentalOptions.getStaleDnsPersistToDiskOption().getValue(), experimentalOptions.getStaleDnsPersistDelayMillisOption(), experimentalOptions.getStaleDnsUseStaleOnNameNotResolvedOption().getValue(), experimentalOptions.getDisableIpv6OnWifiOption().getValue(), cronetEngineBuilderInfo.getCronetInitializationRef(), Process.myUid());
                if (scoped != null) {
                    scoped.close();
                }
            } finally {
            }
        } catch (Exception e) {
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, y.ش۳ֲ׬٨(1672393458) + j + y.ش۳ֲ׬٨(1672393226) + e.getMessage());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void writeCronetTrafficReported(long j, CronetLogger.CronetTrafficInfo cronetTrafficInfo, int i) {
        long millis;
        long millis2;
        try {
            ScopedSysTraceEvent scoped = ScopedSysTraceEvent.scoped("CronetLoggerImpl#writeCronetTrafficReported");
            try {
                int calcRequestHeadersSizeBucket = SizeBuckets.calcRequestHeadersSizeBucket(cronetTrafficInfo.getRequestHeaderSizeInBytes());
                int calcRequestBodySizeBucket = SizeBuckets.calcRequestBodySizeBucket(cronetTrafficInfo.getRequestBodySizeInBytes());
                int calcResponseHeadersSizeBucket = SizeBuckets.calcResponseHeadersSizeBucket(cronetTrafficInfo.getResponseHeaderSizeInBytes());
                int calcResponseBodySizeBucket = SizeBuckets.calcResponseBodySizeBucket(cronetTrafficInfo.getResponseBodySizeInBytes());
                int responseStatusCode = cronetTrafficInfo.getResponseStatusCode();
                long hash = Hash.hash(cronetTrafficInfo.getNegotiatedProtocol());
                millis = cronetTrafficInfo.getHeadersLatency().toMillis();
                int i2 = (int) millis;
                millis2 = cronetTrafficInfo.getTotalLatency().toMillis();
                CronetStatsLog.write(CronetStatsLog.CRONET_TRAFFIC_REPORTED, j, calcRequestHeadersSizeBucket, calcRequestBodySizeBucket, calcResponseHeadersSizeBucket, calcResponseBodySizeBucket, responseStatusCode, hash, i2, (int) millis2, cronetTrafficInfo.wasConnectionMigrationAttempted(), cronetTrafficInfo.didConnectionMigrationSucceed(), i, convertToProtoCronetRequestTerminalState(cronetTrafficInfo.getTerminalState()), cronetTrafficInfo.getNonfinalUserCallbackExceptionCount(), -1L, -1L, cronetTrafficInfo.getReadCount(), cronetTrafficInfo.getOnUploadReadCount(), OptionalBoolean.fromBoolean(Boolean.valueOf(cronetTrafficInfo.getIsBidiStream())).getValue(), OptionalBoolean.fromBoolean(Boolean.valueOf(cronetTrafficInfo.getFinalUserCallbackThrew())).getValue(), cronetTrafficInfo.getUid(), cronetTrafficInfo.getNetworkInternalErrorCode(), cronetTrafficInfo.getQuicErrorCode(), convertToProtoConnectionCloseSource(cronetTrafficInfo.getConnectionCloseSource()), convertToProtoFailureReason(cronetTrafficInfo.getFailureReason()), OptionalBoolean.fromBoolean(Boolean.valueOf(cronetTrafficInfo.getIsSocketReused())).getValue(), cronetTrafficInfo.getCronetVersion(), convertToProtoCronetEngineBuilderInitializedSource(cronetTrafficInfo.getCronetSource()), cronetTrafficInfo.getTimeToEstablishDNSMillis(), cronetTrafficInfo.getTimeToEstablishSSLMillis(), cronetTrafficInfo.getTimeToConnectMillis(), cronetTrafficInfo.getTimeToSendFirstByteMillis());
                if (scoped != null) {
                    scoped.close();
                }
            } finally {
            }
        } catch (Exception e) {
            this.mSamplesRateLimited.addAndGet(i);
            String str = TAG;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, y.۳׭خ۲ݮ(1787271783) + j + y.ڮڴجۭݩ(1256699333) + e.getMessage());
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CronetLoggerImpl(int i) {
        this(new RateLimiter(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CronetLoggerImpl(RateLimiter rateLimiter) {
        this.mSamplesRateLimited = new AtomicInteger();
        this.mRateLimiter = rateLimiter;
    }
}
