package org.chromium.net;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import defpackage.W50;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLStreamHandlerFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.chromium.net.BidirectionalStream;
import org.chromium.net.ConnectionMigrationOptions;
import org.chromium.net.CronetProvider;
import org.chromium.net.DnsOptions;
import org.chromium.net.ExperimentalOptionsTranslator;
import org.chromium.net.ProxyOptions;
import org.chromium.net.QuicOptions;
import org.chromium.net.RequestFinishedInfo;
import org.chromium.net.UrlRequest;
import org.chromium.net.impl.CronetLogger;
import org.chromium.net.impl.CronetLoggerFactory;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public abstract class CronetEngine {
    public static final int ACTIVE_REQUEST_COUNT_UNKNOWN = -1;
    public static final int CONNECTION_METRIC_UNKNOWN = -1;
    public static final int EFFECTIVE_CONNECTION_TYPE_2G = 3;
    public static final int EFFECTIVE_CONNECTION_TYPE_3G = 4;
    public static final int EFFECTIVE_CONNECTION_TYPE_4G = 5;
    public static final int EFFECTIVE_CONNECTION_TYPE_OFFLINE = 1;
    public static final int EFFECTIVE_CONNECTION_TYPE_SLOW_2G = 2;
    public static final int EFFECTIVE_CONNECTION_TYPE_UNKNOWN = 0;
    private static final String TAG = "CronetEngine";
    public static final long UNBIND_NETWORK_HANDLE = -1;

    public static class Builder {
        public static final int HTTP_CACHE_DISABLED = 0;
        public static final int HTTP_CACHE_DISK = 3;
        public static final int HTTP_CACHE_DISK_NO_HTTP = 2;
        public static final int HTTP_CACHE_IN_MEMORY = 1;
        private static final String TAG = "CronetEngine.Builder";
        protected final ICronetEngineBuilder mBuilderDelegate;
        private final List<ExperimentalOptionsTranslator.JsonPatch> mExperimentalOptionsPatches;
        protected JSONObject mParsedExperimentalOptions;

        public static abstract class LibraryLoader {
            public abstract void loadLibrary(String str);
        }

        public Builder(Context context) {
            this(createBuilderDelegate(context));
        }

        public static int compareVersions(String str, String str2) {
            if (str == null || str2 == null) {
                throw new IllegalArgumentException("The input values cannot be null");
            }
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            for (int i = 0; i < split.length && i < split2.length; i++) {
                try {
                    int parseInt = Integer.parseInt(split[i]);
                    int parseInt2 = Integer.parseInt(split2[i]);
                    if (parseInt != parseInt2) {
                        return Integer.signum(parseInt - parseInt2);
                    }
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException(W50.o("Unable to convert version segments into integers: ", split[i], " & ", split2[i]), e);
                }
            }
            return Integer.signum(split.length - split2.length);
        }

        private static ICronetEngineBuilder createBuilderDelegate(Context context) {
            ScopedSysTraceEvent scoped = ScopedSysTraceEvent.scoped("CronetEngine#createBuilderDelegate");
            try {
                long uptimeMillis = SystemClock.uptimeMillis();
                CronetProvider.ProviderInfo providerInfo = getEnabledCronetProviders(context, new ArrayList(CronetProvider.getAllProviderInfos(context))).get(0);
                CronetLogger createLogger = CronetLoggerFactory.createLogger(context, providerInfo.logSource);
                CronetLogger.CronetEngineBuilderInitializedInfo cronetEngineBuilderInitializedInfo = new CronetLogger.CronetEngineBuilderInitializedInfo();
                try {
                    cronetEngineBuilderInitializedInfo.creationSuccessful = Boolean.FALSE;
                    cronetEngineBuilderInitializedInfo.author = CronetLogger.CronetEngineBuilderInitializedInfo.Author.API;
                    cronetEngineBuilderInitializedInfo.source = providerInfo.logSource;
                    cronetEngineBuilderInitializedInfo.uid = Process.myUid();
                    cronetEngineBuilderInitializedInfo.apiVersion = new CronetLogger.CronetVersion(ApiVersion.getCronetVersion());
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, String.format("Using '%s' provider for creating CronetEngine.Builder.", providerInfo.provider));
                    }
                    ICronetEngineBuilder iCronetEngineBuilder = providerInfo.provider.createBuilder().mBuilderDelegate;
                    String implCronetVersion = getImplCronetVersion(iCronetEngineBuilder);
                    if (implCronetVersion != null) {
                        cronetEngineBuilderInitializedInfo.implVersion = new CronetLogger.CronetVersion(implCronetVersion);
                    }
                    cronetEngineBuilderInitializedInfo.cronetInitializationRef = iCronetEngineBuilder.getLogCronetInitializationRef();
                    cronetEngineBuilderInitializedInfo.creationSuccessful = Boolean.TRUE;
                    cronetEngineBuilderInitializedInfo.engineBuilderCreatedLatencyMillis = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                    createLogger.logCronetEngineBuilderInitializedInfo(cronetEngineBuilderInitializedInfo);
                    if (scoped != null) {
                        scoped.close();
                    }
                    return iCronetEngineBuilder;
                } catch (Throwable th) {
                    cronetEngineBuilderInitializedInfo.engineBuilderCreatedLatencyMillis = (int) (SystemClock.uptimeMillis() - uptimeMillis);
                    createLogger.logCronetEngineBuilderInitializedInfo(cronetEngineBuilderInitializedInfo);
                    throw th;
                }
            } catch (Throwable th2) {
                if (scoped != null) {
                    try {
                        scoped.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        }

        public static List<CronetProvider.ProviderInfo> getEnabledCronetProviders(Context context, List<CronetProvider.ProviderInfo> list) {
            if (list.isEmpty()) {
                throw new RuntimeException("Unable to find any Cronet provider. Have you included all necessary jars?");
            }
            Iterator<CronetProvider.ProviderInfo> it = list.iterator();
            while (it.hasNext()) {
                if (!it.next().provider.isEnabled()) {
                    it.remove();
                }
            }
            if (list.isEmpty()) {
                throw new RuntimeException("All available Cronet providers are disabled. A provider should be enabled before it can be used.");
            }
            Collections.sort(list, new Comparator<CronetProvider.ProviderInfo>() { // from class: org.chromium.net.CronetEngine.Builder.1
                @Override // java.util.Comparator
                public int compare(CronetProvider.ProviderInfo providerInfo, CronetProvider.ProviderInfo providerInfo2) {
                    if (CronetProvider.PROVIDER_NAME_FALLBACK.equals(providerInfo.provider.getName())) {
                        return 1;
                    }
                    if (CronetProvider.PROVIDER_NAME_FALLBACK.equals(providerInfo2.provider.getName())) {
                        return -1;
                    }
                    return -Builder.compareVersions(providerInfo.provider.getVersion(), providerInfo2.provider.getVersion());
                }
            });
            return list;
        }

        private static int getImplApiLevel(ICronetEngineBuilder iCronetEngineBuilder) {
            try {
                Method implVersionMethod = getImplVersionMethod(iCronetEngineBuilder, "getApiLevel");
                if (implVersionMethod == null) {
                    return -1;
                }
                return ((Integer) implVersionMethod.invoke(null, new Object[0])).intValue();
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Failed to retrieve Cronet impl API level", e);
            }
        }

        private static String getImplCronetVersion(ICronetEngineBuilder iCronetEngineBuilder) {
            try {
                Method implVersionMethod = getImplVersionMethod(iCronetEngineBuilder, "getCronetVersion");
                if (implVersionMethod == null) {
                    return null;
                }
                return (String) implVersionMethod.invoke(null, new Object[0]);
            } catch (ReflectiveOperationException e) {
                throw new RuntimeException("Failed to retrieve Cronet impl version", e);
            }
        }

        private static Method getImplVersionMethod(ICronetEngineBuilder iCronetEngineBuilder, String str) {
            try {
                return iCronetEngineBuilder.getClass().getClassLoader().loadClass("org.chromium.net.impl.ImplVersion").getMethod(str, new Class[0]);
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                return null;
            }
        }

        private int getMaximumApiLevel() {
            return ApiVersion.getMaximumAvailableApiLevel();
        }

        private void maybeSetExperimentalOptions() {
            JSONObject applyJsonPatches = ExperimentalOptionsTranslator.applyJsonPatches(this.mParsedExperimentalOptions, this.mExperimentalOptionsPatches);
            if (applyJsonPatches != null) {
                this.mBuilderDelegate.setExperimentalOptions(applyJsonPatches.toString());
            }
        }

        public Builder addPublicKeyPins(String str, Set<byte[]> set, boolean z, Date date) {
            this.mBuilderDelegate.addPublicKeyPins(str, set, z, date);
            return this;
        }

        public Builder addQuicHint(String str, int i, int i2) {
            this.mBuilderDelegate.addQuicHint(str, i, i2);
            return this;
        }

        public CronetEngine build() {
            return buildExperimental();
        }

        public ExperimentalCronetEngine buildExperimental() {
            int implApiLevel = getImplApiLevel(this.mBuilderDelegate);
            if (implApiLevel != -1 && implApiLevel < getMaximumApiLevel()) {
                Log.w(TAG, "The implementation version is lower than the API version. Calls to methods added in API " + (implApiLevel + 1) + " and newer will likely have no effect.");
            }
            maybeSetExperimentalOptions();
            return this.mBuilderDelegate.build();
        }

        public Builder enableBrotli(boolean z) {
            this.mBuilderDelegate.enableBrotli(z);
            return this;
        }

        public Builder enableHttp2(boolean z) {
            this.mBuilderDelegate.enableHttp2(z);
            return this;
        }

        public Builder enableHttpCache(int i, long j) {
            this.mBuilderDelegate.enableHttpCache(i, j);
            return this;
        }

        public Builder enableNetworkQualityEstimator(boolean z) {
            this.mBuilderDelegate.enableNetworkQualityEstimator(z);
            return this;
        }

        public Builder enablePublicKeyPinningBypassForLocalTrustAnchors(boolean z) {
            this.mBuilderDelegate.enablePublicKeyPinningBypassForLocalTrustAnchors(z);
            return this;
        }

        public Builder enableQuic(boolean z) {
            this.mBuilderDelegate.enableQuic(z);
            return this;
        }

        @Deprecated
        public Builder enableSdch(boolean z) {
            return this;
        }

        public String getDefaultUserAgent() {
            return this.mBuilderDelegate.getDefaultUserAgent();
        }

        @ConnectionMigrationOptions.Experimental
        public Builder setConnectionMigrationOptions(ConnectionMigrationOptions connectionMigrationOptions) {
            if (this.mBuilderDelegate.getSupportedConfigOptions().contains(1)) {
                this.mBuilderDelegate.setConnectionMigrationOptions(connectionMigrationOptions);
                return this;
            }
            this.mExperimentalOptionsPatches.add(new a(connectionMigrationOptions, 1));
            return this;
        }

        @DnsOptions.Experimental
        public Builder setDnsOptions(DnsOptions dnsOptions) {
            if (this.mBuilderDelegate.getSupportedConfigOptions().contains(2)) {
                this.mBuilderDelegate.setDnsOptions(dnsOptions);
                return this;
            }
            this.mExperimentalOptionsPatches.add(new a(dnsOptions, 2));
            return this;
        }

        public Builder setLibraryLoader(LibraryLoader libraryLoader) {
            this.mBuilderDelegate.setLibraryLoader(libraryLoader);
            return this;
        }

        @ProxyOptions.Experimental
        public Builder setProxyOptions(ProxyOptions proxyOptions) {
            if (!this.mBuilderDelegate.getSupportedConfigOptions().contains(4)) {
                throw new UnsupportedOperationException("This Cronet implementation does not support ProxyOptions");
            }
            this.mBuilderDelegate.setProxyOptions(proxyOptions);
            return this;
        }

        @QuicOptions.Experimental
        public Builder setQuicOptions(QuicOptions quicOptions) {
            if (this.mBuilderDelegate.getSupportedConfigOptions().contains(3)) {
                this.mBuilderDelegate.setQuicOptions(quicOptions);
                return this;
            }
            this.mExperimentalOptionsPatches.add(new a(quicOptions, 0));
            return this;
        }

        public Builder setStoragePath(String str) {
            this.mBuilderDelegate.setStoragePath(str);
            return this;
        }

        @Deprecated
        public Builder setThreadPriority(int i) {
            this.mBuilderDelegate.setThreadPriority(i);
            return this;
        }

        public Builder setUserAgent(String str) {
            this.mBuilderDelegate.setUserAgent(str);
            return this;
        }

        public Builder(ICronetEngineBuilder iCronetEngineBuilder) {
            this.mExperimentalOptionsPatches = new ArrayList();
            this.mBuilderDelegate = iCronetEngineBuilder;
        }

        @ConnectionMigrationOptions.Experimental
        public Builder setConnectionMigrationOptions(ConnectionMigrationOptions.Builder builder) {
            return setConnectionMigrationOptions(builder.build());
        }

        @DnsOptions.Experimental
        public Builder setDnsOptions(DnsOptions.Builder builder) {
            return setDnsOptions(builder.build());
        }

        @QuicOptions.Experimental
        public Builder setQuicOptions(QuicOptions.Builder builder) {
            return setQuicOptions(builder.build());
        }
    }

    public void addRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    public void addRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    public void addThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    public void bindToNetwork(long j) {
    }

    public void configureNetworkQualityEstimatorForTesting(boolean z, boolean z2, boolean z3) {
    }

    public abstract URLStreamHandlerFactory createURLStreamHandlerFactory();

    public int getActiveRequestCount() {
        return -1;
    }

    public int getDownstreamThroughputKbps() {
        return -1;
    }

    public int getEffectiveConnectionType() {
        return 0;
    }

    @Deprecated
    public abstract byte[] getGlobalMetricsDeltas();

    public int getHttpRttMs() {
        return -1;
    }

    public int getTransportRttMs() {
        return -1;
    }

    public abstract String getVersionString();

    public BidirectionalStream.Builder newBidirectionalStreamBuilder(String str, BidirectionalStream.Callback callback, Executor executor) {
        throw new UnsupportedOperationException("Not implemented.");
    }

    public abstract UrlRequest.Builder newUrlRequestBuilder(String str, UrlRequest.Callback callback, Executor executor);

    public abstract URLConnection openConnection(URL url);

    public void removeRequestFinishedListener(RequestFinishedInfo.Listener listener) {
    }

    public void removeRttListener(NetworkQualityRttListener networkQualityRttListener) {
    }

    public void removeThroughputListener(NetworkQualityThroughputListener networkQualityThroughputListener) {
    }

    public abstract void shutdown();

    public void startNetLogToDisk(String str, boolean z, int i) {
    }

    public abstract void startNetLogToFile(String str, boolean z);

    public abstract void stopNetLog();
}
