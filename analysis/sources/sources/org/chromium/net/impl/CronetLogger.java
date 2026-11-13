package org.chromium.net.impl;

import com.liapp.y;
import defpackage.F40;
import java.time.Duration;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class CronetLogger {

    public static class CronetEngineBuilderInfo {
        private final boolean mBrotiEnabled;
        private final long mCronetInitializationRef;
        private final String mExperimentalOptions;
        private final boolean mHttp2Enabled;
        private final int mHttpCacheMode;
        private final boolean mNetworkQualityEstimatorEnabled;
        private final boolean mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        private final boolean mQuicEnabled;
        private final String mStoragePath;
        private final int mThreadPriority;
        private final String mUserAgent;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CronetEngineBuilderInfo(boolean z, String str, String str2, boolean z2, boolean z3, boolean z4, int i, String str3, boolean z5, int i2, long j) {
            this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled = z;
            this.mUserAgent = str;
            this.mStoragePath = str2;
            this.mQuicEnabled = z2;
            this.mHttp2Enabled = z3;
            this.mBrotiEnabled = z4;
            this.mHttpCacheMode = i;
            this.mExperimentalOptions = str3;
            this.mNetworkQualityEstimatorEnabled = z5;
            this.mThreadPriority = i2;
            this.mCronetInitializationRef = j;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getCronetInitializationRef() {
            return this.mCronetInitializationRef;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getExperimentalOptions() {
            return this.mExperimentalOptions;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getHttpCacheMode() {
            return this.mHttpCacheMode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getStoragePath() {
            return this.mStoragePath;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getThreadPriority() {
            return this.mThreadPriority;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getUserAgent() {
            return this.mUserAgent;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isBrotliEnabled() {
            return this.mBrotiEnabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isHttp2Enabled() {
            return this.mHttp2Enabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isNetworkQualityEstimatorEnabled() {
            return this.mNetworkQualityEstimatorEnabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isPublicKeyPinningBypassForLocalTrustAnchorsEnabled() {
            return this.mPublicKeyPinningBypassForLocalTrustAnchorsEnabled;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isQuicEnabled() {
            return this.mQuicEnabled;
        }
    }

    public static final class CronetEngineBuilderInitializedInfo {
        public CronetVersion apiVersion;
        public Author author;
        public Boolean creationSuccessful;
        public long cronetInitializationRef;
        public CronetVersion implVersion;
        public int uid;
        public int engineBuilderCreatedLatencyMillis = -1;
        public CronetSource source = CronetSource.CRONET_SOURCE_UNSPECIFIED;

        public enum Author {
            API,
            IMPL
        }
    }

    public static final class CronetInitializedInfo {
        public String cronetImplVersion;
        public long cronetInitializationRef;
        public List<Long> httpFlagsNames;
        public Boolean httpFlagsSuccessful;
        public List<Long> httpFlagsValues;
        public int engineCreationLatencyMillis = -1;
        public int engineAsyncLatencyMillis = -1;
        public int httpFlagsLatencyMillis = -1;
        public CronetSource source = CronetSource.CRONET_SOURCE_UNSPECIFIED;
    }

    public enum CronetSource {
        CRONET_SOURCE_UNSPECIFIED,
        CRONET_SOURCE_STATICALLY_LINKED,
        CRONET_SOURCE_PLAY_SERVICES,
        CRONET_SOURCE_FALLBACK,
        CRONET_SOURCE_PLATFORM,
        CRONET_SOURCE_FAKE
    }

    public static class CronetTrafficInfo {
        private final CronetSource mCronetSource;
        private final String mCronetVersion;
        private final boolean mDidConnectionMigrationSucceed;
        private final RequestFailureReason mFailureReason;
        private final boolean mFinalUserCallbackThrew;
        private final Duration mHeadersLatency;
        private final boolean mIsBidiStream;
        private final String mNegotiatedProtocol;
        private final int mNetworkInternalErrorCode;
        private final int mNonfinalUserCallbackExceptionCount;
        private final int mOnUploadReadCount;
        private final int mQuicErrorCode;
        private final int mReadCount;
        private final long mRequestBodySizeInBytes;
        private final long mRequestHeaderSizeInBytes;
        private final long mResponseBodySizeInBytes;
        private final long mResponseHeaderSizeInBytes;
        private final int mResponseStatusCode;
        private final boolean mSocketReused;
        private final int mSource;
        private final RequestTerminalState mTerminalState;
        private final long mTimeToConnectMillis;
        private final long mTimeToEstablishDnsMillis;
        private final long mTimeToEstablishSSLMillis;
        private final long mTimeToSendFirstByteMillis;
        private final Duration mTotalLatency;
        private final int mUid;
        private final boolean mWasConnectionMigrationAttempted;

        public enum RequestFailureReason {
            UNKNOWN,
            NETWORK,
            OTHER
        }

        public enum RequestTerminalState {
            SUCCEEDED,
            ERROR,
            CANCELLED
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CronetTrafficInfo(long j, long j2, long j3, long j4, int i, Duration duration, Duration duration2, String str, boolean z, boolean z2, RequestTerminalState requestTerminalState, int i2, int i3, int i4, boolean z3, boolean z4, int i5, int i6, int i7, int i8, RequestFailureReason requestFailureReason, boolean z5, String str2, CronetSource cronetSource, long j5, long j6, long j7, long j8) {
            this.mRequestHeaderSizeInBytes = j;
            this.mRequestBodySizeInBytes = j2;
            this.mResponseHeaderSizeInBytes = j3;
            this.mResponseBodySizeInBytes = j4;
            this.mResponseStatusCode = i;
            this.mHeadersLatency = duration;
            this.mTotalLatency = duration2;
            this.mNegotiatedProtocol = str;
            this.mWasConnectionMigrationAttempted = z;
            this.mDidConnectionMigrationSucceed = z2;
            this.mTerminalState = requestTerminalState;
            this.mNonfinalUserCallbackExceptionCount = i2;
            this.mReadCount = i3;
            this.mOnUploadReadCount = i4;
            this.mIsBidiStream = z3;
            this.mFinalUserCallbackThrew = z4;
            this.mUid = i5;
            this.mNetworkInternalErrorCode = i6;
            this.mQuicErrorCode = i7;
            this.mSource = i8;
            this.mFailureReason = requestFailureReason;
            this.mSocketReused = z5;
            this.mCronetVersion = str2;
            this.mCronetSource = cronetSource;
            this.mTimeToEstablishDnsMillis = j5;
            this.mTimeToEstablishSSLMillis = j6;
            this.mTimeToConnectMillis = j7;
            this.mTimeToSendFirstByteMillis = j8;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean didConnectionMigrationSucceed() {
            return this.mDidConnectionMigrationSucceed;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getConnectionCloseSource() {
            return this.mSource;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CronetSource getCronetSource() {
            return this.mCronetSource;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getCronetVersion() {
            return this.mCronetVersion;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public RequestFailureReason getFailureReason() {
            return this.mFailureReason;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean getFinalUserCallbackThrew() {
            return this.mFinalUserCallbackThrew;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Duration getHeadersLatency() {
            return this.mHeadersLatency;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean getIsBidiStream() {
            return this.mIsBidiStream;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean getIsSocketReused() {
            return this.mSocketReused;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String getNegotiatedProtocol() {
            return this.mNegotiatedProtocol;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getNetworkInternalErrorCode() {
            return this.mNetworkInternalErrorCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getNonfinalUserCallbackExceptionCount() {
            return this.mNonfinalUserCallbackExceptionCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getOnUploadReadCount() {
            return this.mOnUploadReadCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getQuicErrorCode() {
            return this.mQuicErrorCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getReadCount() {
            return this.mReadCount;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getRequestBodySizeInBytes() {
            return this.mRequestBodySizeInBytes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getRequestHeaderSizeInBytes() {
            return this.mRequestHeaderSizeInBytes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getResponseBodySizeInBytes() {
            return this.mResponseBodySizeInBytes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getResponseHeaderSizeInBytes() {
            return this.mResponseHeaderSizeInBytes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getResponseStatusCode() {
            return this.mResponseStatusCode;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public RequestTerminalState getTerminalState() {
            return this.mTerminalState;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getTimeToConnectMillis() {
            return this.mTimeToConnectMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getTimeToEstablishDNSMillis() {
            return this.mTimeToEstablishDnsMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getTimeToEstablishSSLMillis() {
            return this.mTimeToEstablishSSLMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public long getTimeToSendFirstByteMillis() {
            return this.mTimeToSendFirstByteMillis;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Duration getTotalLatency() {
            return this.mTotalLatency;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getUid() {
            return this.mUid;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean wasConnectionMigrationAttempted() {
            return this.mWasConnectionMigrationAttempted;
        }
    }

    public abstract long generateId();

    public abstract void logCronetEngineBuilderInitializedInfo(CronetEngineBuilderInitializedInfo cronetEngineBuilderInitializedInfo);

    public abstract void logCronetEngineCreation(long j, CronetEngineBuilderInfo cronetEngineBuilderInfo, CronetVersion cronetVersion, CronetSource cronetSource);

    public abstract void logCronetInitializedInfo(CronetInitializedInfo cronetInitializedInfo);

    public abstract void logCronetTrafficInfo(long j, CronetTrafficInfo cronetTrafficInfo);

    public static class CronetVersion {
        private final int mBuildVersion;
        private final int mMajorVersion;
        private final int mMinorVersion;
        private final int mPatchVersion;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public CronetVersion(String str) {
            String[] split = str.split(y.ۮخݳ٬ۨ(1835642750));
            this.mMajorVersion = Integer.parseInt(split[0]);
            this.mMinorVersion = Integer.parseInt(split[1]);
            this.mBuildVersion = Integer.parseInt(split[2]);
            this.mPatchVersion = Integer.parseInt(split[3]);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getBuildVersion() {
            return this.mBuildVersion;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getMajorVersion() {
            return this.mMajorVersion;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getMinorVersion() {
            return this.mMinorVersion;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getPatchVersion() {
            return this.mPatchVersion;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            int i = this.mMajorVersion;
            int i2 = this.mMinorVersion;
            int i3 = this.mBuildVersion;
            int i4 = this.mPatchVersion;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            String str = y.ۮخݳ٬ۨ(1835537206);
            sb.append(str);
            sb.append(i2);
            sb.append(str);
            sb.append(i3);
            return F40.d(i4, str, sb);
        }
    }
}
