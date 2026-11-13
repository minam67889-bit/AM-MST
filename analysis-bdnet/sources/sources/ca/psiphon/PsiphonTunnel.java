package ca.psiphon;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.net.VpnService;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import defpackage.C0223If;
import defpackage.ZT;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.vpn.logger.SkStatus;
import psi.Psi;
import psi.PsiphonProvider;
import psi.PsiphonProviderFeedbackHandler;
import psi.PsiphonProviderNetwork;
import psi.PsiphonProviderNoticeHandler;

/* loaded from: classes.dex */
public class PsiphonTunnel {
    private static final int UDPGW_SERVER_PORT = 7300;
    private static final int VPN_INTERFACE_MTU = 1500;
    private static final String VPN_INTERFACE_NETMASK = Deobfuscator$BDNETVPN$app.getString(-16968747677579L);
    private static C0223If mConfig;
    private static PsiphonTunnel mPsiphonTunnel;
    private final HostService mHostService;
    private PrivateAddress mPrivateAddress;
    private final boolean mShouldRouteThroughTunnelAutomatically;
    private Thread mTun2SocksThread;
    private AtomicBoolean mVpnMode = new AtomicBoolean(false);
    private AtomicReference<ParcelFileDescriptor> mTunFd = new AtomicReference<>();
    private AtomicInteger mLocalSocksProxyPort = new AtomicInteger(0);
    private AtomicBoolean mRoutingThroughTunnel = new AtomicBoolean(false);
    private AtomicBoolean mIsWaitingForNetworkConnectivity = new AtomicBoolean(false);
    private AtomicReference<String> mClientPlatformPrefix = new AtomicReference<>(Deobfuscator$BDNETVPN$app.getString(-1438145935243L));
    private AtomicReference<String> mClientPlatformSuffix = new AtomicReference<>(Deobfuscator$BDNETVPN$app.getString(-1442440902539L));
    private AtomicReference<String> mActiveNetworkType = new AtomicReference<>(Deobfuscator$BDNETVPN$app.getString(-1446735869835L));
    private AtomicReference<String> mActiveNetworkDNSServers = new AtomicReference<>(Deobfuscator$BDNETVPN$app.getString(-1451030837131L));
    private final NetworkMonitor mNetworkMonitor = new NetworkMonitor(new NetworkMonitor.NetworkChangeListener() { // from class: ca.psiphon.PsiphonTunnel.1
        @Override // ca.psiphon.PsiphonTunnel.NetworkMonitor.NetworkChangeListener
        public void onChanged() {
            try {
                PsiphonTunnel.this.reconnectPsiphon();
            } catch (Exception e) {
                PsiphonTunnel.this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-3626858379L) + e);
            }
        }
    });

    public interface HostFeedbackHandler {
        default void sendFeedbackCompleted(java.lang.Exception exc) {
        }
    }

    public interface HostLibraryLoader {
        default void loadLibrary(String str) {
            System.loadLibrary(str);
        }
    }

    public interface HostLogger {
        default void onDiagnosticMessage(String str) {
        }
    }

    public interface HostService extends HostLogger, HostLibraryLoader {
        String getAppName();

        Context getContext();

        String getPsiphonConfig();

        Object getVpnService();

        Object newVpnServiceBuilder();

        default void onActiveAuthorizationIDs(List<String> list) {
        }

        default void onApplicationParameters(Object obj) {
        }

        default void onAvailableEgressRegions(List<String> list) {
        }

        default void onBytesTransferred(long j, long j2) {
        }

        default void onClientAddress(String str) {
        }

        default void onClientIsLatestVersion() {
        }

        default void onClientRegion(String str) {
        }

        default void onClientUpgradeDownloaded(String str) {
        }

        default void onConnected() {
        }

        default void onConnecting() {
        }

        default void onExiting() {
        }

        default void onHomepage(String str) {
        }

        default void onHttpProxyPortInUse(int i) {
        }

        default void onListeningHttpProxyPort(int i) {
        }

        default void onListeningSocksProxyPort(int i) {
        }

        default void onServerAlert(String str, String str2, List<String> list) {
        }

        default void onSocksProxyPortInUse(int i) {
        }

        default void onSplitTunnelRegions(List<String> list) {
        }

        default void onStartedWaitingForNetworkConnectivity() {
        }

        default void onStoppedWaitingForNetworkConnectivity() {
        }

        default void onTrafficRateLimits(long j, long j2) {
        }

        default void onUntunneledAddress(String str) {
        }

        default void onUpstreamProxyError(String str) {
        }
    }

    public static class NetworkMonitor {
        private final NetworkChangeListener listener;
        private ConnectivityManager.NetworkCallback networkCallback;

        public interface NetworkChangeListener {
            void onChanged();
        }

        public NetworkMonitor(NetworkChangeListener networkChangeListener) {
            this.listener = networkChangeListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void start(Context context) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            final ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-665051821963L));
            if (connectivityManager == null) {
                return;
            }
            this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: ca.psiphon.PsiphonTunnel.NetworkMonitor.1
                private Network currentActiveNetwork;
                private boolean isInitialState = true;

                private void consumeActiveNetwork(Network network) {
                    if (this.isInitialState) {
                        this.isInitialState = false;
                        setCurrentActiveNetworkAndProperties(network);
                    } else {
                        if (network.equals(this.currentActiveNetwork)) {
                            return;
                        }
                        setCurrentActiveNetworkAndProperties(network);
                        if (NetworkMonitor.this.listener != null) {
                            NetworkMonitor.this.listener.onChanged();
                        }
                    }
                }

                private void consumeLostNetwork(Network network) {
                    if (network.equals(this.currentActiveNetwork)) {
                        setCurrentActiveNetworkAndProperties(null);
                        if (NetworkMonitor.this.listener != null) {
                            NetworkMonitor.this.listener.onChanged();
                        }
                    }
                }

                private void setCurrentActiveNetworkAndProperties(Network network) {
                    this.currentActiveNetwork = network;
                    if (network == null) {
                        PsiphonTunnel.mPsiphonTunnel.mActiveNetworkType.set(Deobfuscator$BDNETVPN$app.getString(-93821171595L));
                        PsiphonTunnel.mPsiphonTunnel.mActiveNetworkDNSServers.set(Deobfuscator$BDNETVPN$app.getString(-115296008075L));
                        PsiphonTunnel.mPsiphonTunnel.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-119590975371L));
                    } else {
                        String string = Deobfuscator$BDNETVPN$app.getString(-312864503691L);
                        try {
                            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(network);
                            if (networkCapabilities.hasTransport(4)) {
                                string = Deobfuscator$BDNETVPN$app.getString(-347224242059L);
                            } else if (networkCapabilities.hasTransport(0)) {
                                string = Deobfuscator$BDNETVPN$app.getString(-364404111243L);
                            } else if (networkCapabilities.hasTransport(1)) {
                                string = Deobfuscator$BDNETVPN$app.getString(-394468882315L);
                            }
                        } catch (java.lang.Exception unused) {
                        }
                        PsiphonTunnel.mPsiphonTunnel.mActiveNetworkType.set(string);
                        ArrayList arrayList = new ArrayList();
                        try {
                            Iterator<InetAddress> it = connectivityManager.getLinkProperties(network).getDnsServers().iterator();
                            while (it.hasNext()) {
                                String inetAddress = it.next().toString();
                                if (inetAddress.startsWith(Deobfuscator$BDNETVPN$app.getString(-415943718795L))) {
                                    inetAddress = inetAddress.substring(1);
                                }
                                arrayList.add(inetAddress);
                            }
                        } catch (java.lang.Exception unused2) {
                        }
                        PsiphonTunnel.mPsiphonTunnel.mActiveNetworkDNSServers.set(TextUtils.join(Deobfuscator$BDNETVPN$app.getString(-424533653387L), arrayList));
                        String str = Deobfuscator$BDNETVPN$app.getString(-433123587979L) + string;
                        if (!arrayList.isEmpty()) {
                            StringBuilder m = ZT.m(str);
                            m.append(Deobfuscator$BDNETVPN$app.getString(-622102149003L));
                            str = m.toString();
                        }
                        PsiphonTunnel.mPsiphonTunnel.mHostService.onDiagnosticMessage(str);
                    }
                    countDownLatch.countDown();
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    if (Build.VERSION.SDK_INT >= 26) {
                        return;
                    }
                    consumeActiveNetwork(network);
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                    super.onCapabilitiesChanged(network, networkCapabilities);
                    if (networkCapabilities.hasCapability(16)) {
                        consumeActiveNetwork(network);
                    }
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    consumeLostNetwork(network);
                }
            };
            try {
                NetworkRequest.Builder addCapability = new NetworkRequest.Builder().addCapability(12);
                if (PsiphonTunnel.mPsiphonTunnel.mVpnMode.get()) {
                    addCapability.addCapability(15);
                } else {
                    addCapability.removeCapability(15);
                }
                connectivityManager.requestNetwork(addCapability.build(), this.networkCallback);
            } catch (RuntimeException unused) {
                this.networkCallback = null;
            }
            countDownLatch.await(1L, TimeUnit.SECONDS);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void stop(Context context) {
            ConnectivityManager connectivityManager;
            if (this.networkCallback == null || (connectivityManager = (ConnectivityManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-720886396811L))) == null) {
                return;
            }
            try {
                connectivityManager.unregisterNetworkCallback(this.networkCallback);
            } catch (RuntimeException unused) {
            }
            this.networkCallback = null;
        }
    }

    public static class PrivateAddress {
        public final String mIpAddress;
        public final int mPrefixLength;
        public final String mRouter;
        public final String mSubnet;

        public PrivateAddress(String str, String str2, int i, String str3) {
            this.mIpAddress = str;
            this.mSubnet = str2;
            this.mPrefixLength = i;
            this.mRouter = str3;
        }
    }

    public class PsiphonProviderShim implements PsiphonProvider {
        private PsiphonTunnel mPsiphonTunnel;

        public PsiphonProviderShim(PsiphonTunnel psiphonTunnel) {
            this.mPsiphonTunnel = psiphonTunnel;
        }

        @Override // psi.PsiphonProvider
        public String bindToDevice(long j) {
            return this.mPsiphonTunnel.bindToDevice(j);
        }

        @Override // psi.PsiphonProvider
        public String getDNSServersAsString() {
            return this.mPsiphonTunnel.getDNSServers(PsiphonTunnel.this.mHostService.getContext(), PsiphonTunnel.this.mHostService);
        }

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public String getNetworkID() {
            return PsiphonTunnel.getNetworkID(PsiphonTunnel.this.mHostService.getContext(), this.mPsiphonTunnel.isVpnMode());
        }

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public long hasIPv6Route() {
            return PsiphonTunnel.hasIPv6Route(PsiphonTunnel.this.mHostService.getContext(), PsiphonTunnel.this.mHostService);
        }

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public long hasNetworkConnectivity() {
            return this.mPsiphonTunnel.hasNetworkConnectivity();
        }

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public String iPv6Synthesize(String str) {
            return PsiphonTunnel.iPv6Synthesize(str);
        }

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNoticeHandler
        public void notice(String str) {
            this.mPsiphonTunnel.notice(str);
        }
    }

    public static class PsiphonTunnelFeedback {
        private final ExecutorService workQueue = Executors.newSingleThreadExecutor();
        private final ExecutorService callbackQueue = Executors.newSingleThreadExecutor();

        /* renamed from: ca.psiphon.PsiphonTunnel$PsiphonTunnelFeedback$1, reason: invalid class name */
        public class AnonymousClass1 implements Runnable {
            final /* synthetic */ String val$clientPlatformPrefix;
            final /* synthetic */ String val$clientPlatformSuffix;
            final /* synthetic */ Context val$context;
            final /* synthetic */ String val$diagnosticsJson;
            final /* synthetic */ String val$feedbackConfigJson;
            final /* synthetic */ HostFeedbackHandler val$feedbackHandler;
            final /* synthetic */ HostLogger val$logger;
            final /* synthetic */ String val$uploadPath;

            public AnonymousClass1(Context context, HostLogger hostLogger, String str, String str2, String str3, String str4, String str5, HostFeedbackHandler hostFeedbackHandler) {
                this.val$context = context;
                this.val$logger = hostLogger;
                this.val$feedbackConfigJson = str;
                this.val$clientPlatformPrefix = str2;
                this.val$clientPlatformSuffix = str3;
                this.val$diagnosticsJson = str4;
                this.val$uploadPath = str5;
                this.val$feedbackHandler = hostFeedbackHandler;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Psi.startSendFeedback(PsiphonTunnel.buildPsiphonConfig(this.val$context, this.val$logger, this.val$feedbackConfigJson, this.val$clientPlatformPrefix, this.val$clientPlatformSuffix, false, 0), this.val$diagnosticsJson, this.val$uploadPath, new PsiphonProviderFeedbackHandler() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.1
                        @Override // psi.PsiphonProviderFeedbackHandler
                        public void sendFeedbackCompleted(final java.lang.Exception exc) {
                            try {
                                PsiphonTunnelFeedback.this.callbackQueue.execute(new Runnable() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.1.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        AnonymousClass1.this.val$feedbackHandler.sendFeedbackCompleted(exc);
                                    }
                                });
                            } catch (RejectedExecutionException unused) {
                            }
                        }
                    }, new PsiphonProviderNetwork() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.2
                        @Override // psi.PsiphonProviderNetwork
                        public String getNetworkID() {
                            return PsiphonTunnel.getNetworkID(AnonymousClass1.this.val$context, false);
                        }

                        @Override // psi.PsiphonProviderNetwork
                        public long hasIPv6Route() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            return PsiphonTunnel.hasIPv6Route(anonymousClass1.val$context, anonymousClass1.val$logger);
                        }

                        @Override // psi.PsiphonProviderNetwork
                        public long hasNetworkConnectivity() {
                            return PsiphonTunnel.hasNetworkConnectivity(AnonymousClass1.this.val$context) ? 1L : 0L;
                        }

                        @Override // psi.PsiphonProviderNetwork
                        public String iPv6Synthesize(String str) {
                            return PsiphonTunnel.iPv6Synthesize(str);
                        }
                    }, new PsiphonProviderNoticeHandler() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.3
                        @Override // psi.PsiphonProviderNoticeHandler
                        public void notice(String str) {
                            JSONObject jSONObject;
                            try {
                                try {
                                    JSONObject jSONObject2 = new JSONObject(str);
                                    String string = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-875505219467L));
                                    if (string != null && (jSONObject = jSONObject2.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-922749859723L))) != null) {
                                        final String str2 = string + Deobfuscator$BDNETVPN$app.getString(-944224696203L) + jSONObject.toString();
                                        PsiphonTunnelFeedback.this.callbackQueue.execute(new Runnable() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.3.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                AnonymousClass1.this.val$logger.onDiagnosticMessage(str2);
                                            }
                                        });
                                    }
                                } catch (java.lang.Exception e) {
                                    PsiphonTunnelFeedback.this.callbackQueue.execute(new Runnable() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.3.2
                                        @Override // java.lang.Runnable
                                        public void run() {
                                            AnonymousClass1.this.val$logger.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-776720971659L) + e.toString());
                                        }
                                    });
                                }
                            } catch (RejectedExecutionException unused) {
                            }
                        }
                    }, false, true);
                } catch (java.lang.Exception e) {
                    try {
                        PsiphonTunnelFeedback.this.callbackQueue.execute(new Runnable() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.1.4
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass1.this.val$feedbackHandler.sendFeedbackCompleted(new Exception(Deobfuscator$BDNETVPN$app.getString(-957109598091L), e));
                            }
                        });
                    } catch (RejectedExecutionException unused) {
                    }
                }
            }
        }

        public void shutdown() {
            this.workQueue.execute(new Runnable() { // from class: ca.psiphon.PsiphonTunnel.PsiphonTunnelFeedback.2
                @Override // java.lang.Runnable
                public void run() {
                    Psi.stopSendFeedback();
                }
            });
            shutdownAndAwaitTermination(this.workQueue);
            shutdownAndAwaitTermination(this.callbackQueue);
        }

        public void shutdownAndAwaitTermination(ExecutorService executorService) {
            try {
                TimeUnit timeUnit = TimeUnit.SECONDS;
                if (executorService.awaitTermination(5L, timeUnit)) {
                    return;
                }
                executorService.shutdownNow();
                if (executorService.awaitTermination(5L, timeUnit)) {
                    return;
                }
                System.err.println(Deobfuscator$BDNETVPN$app.getString(-1055893845899L));
            } catch (InterruptedException unused) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }

        public void startSendFeedback(Context context, HostFeedbackHandler hostFeedbackHandler, HostLogger hostLogger, String str, String str2, String str3, String str4, String str5) {
            this.workQueue.execute(new AnonymousClass1(context, hostLogger, str, str4, str5, str2, str3, hostFeedbackHandler));
        }
    }

    private PsiphonTunnel(HostService hostService, boolean z) {
        this.mHostService = hostService;
        this.mShouldRouteThroughTunnelAutomatically = z;
    }

    private void applyPerAppRules(VpnService.Builder builder) {
        try {
            C0223If d = C0223If.d(this.mHostService.getContext());
            d.getClass();
            if (d.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162688398096267L), false)) {
                if (d.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162817247115147L), false)) {
                    for (String str : d.a()) {
                        try {
                            builder.addDisallowedApplication(str);
                            SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-1876232599435L) + str);
                        } catch (PackageManager.NameNotFoundException unused) {
                        }
                    }
                    return;
                }
                for (String str2 : d.a()) {
                    try {
                        builder.addAllowedApplication(str2);
                        SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-1983606781835L) + str2);
                    } catch (PackageManager.NameNotFoundException unused2) {
                    }
                }
            }
        } catch (Throwable th) {
            this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-2078096062347L) + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bindToDevice(long j) {
        if (((VpnService) this.mHostService.getVpnService()).protect((int) j)) {
            return Deobfuscator$BDNETVPN$app.getString(-3074528475019L);
        }
        throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2980039194507L));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String buildPsiphonConfig(Context context, HostLogger hostLogger, String str, String str2, String str3, boolean z, Integer num) {
        mConfig = C0223If.d(context);
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.has(Deobfuscator$BDNETVPN$app.getString(-4268529383307L))) {
            File defaultDataRootDirectory = defaultDataRootDirectory(context);
            if (!defaultDataRootDirectory.exists() && !defaultDataRootDirectory.mkdir()) {
                throw new Exception(Deobfuscator$BDNETVPN$app.getString(-4345838794635L) + defaultDataRootDirectory.getPath());
            }
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-4513342519179L), defaultDataRootDirectory(context));
        }
        if (!jSONObject.has(Deobfuscator$BDNETVPN$app.getString(-4590651930507L))) {
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-4672256309131L), context.getFilesDir());
        }
        if (!jSONObject.has(Deobfuscator$BDNETVPN$app.getString(-4783925458827L))) {
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-5024443627403L), new File(context.getFilesDir(), Deobfuscator$BDNETVPN$app.getString(-4925659379595L)).getAbsolutePath());
        }
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-5213422188427L), new File(context.getFilesDir(), Deobfuscator$BDNETVPN$app.getString(-5196242319243L)).getAbsolutePath());
        if (!jSONObject.has(Deobfuscator$BDNETVPN$app.getString(-5406695716747L))) {
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-5535544735627L), 0);
        }
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-5664393754507L), true);
        if (num.intValue() != 0 && (!jSONObject.has(Deobfuscator$BDNETVPN$app.getString(-5754588067723L)) || jSONObject.getInt(Deobfuscator$BDNETVPN$app.getString(-5840487413643L)) == 0)) {
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-5926386759563L), num);
        }
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-6141135124363L), getDeviceRegion(context));
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-6196969699211L), 1);
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-6274279110539L), true);
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-6368768391051L), Deobfuscator$BDNETVPN$app.getString(-6433192900491L));
        StringBuilder sb = new StringBuilder();
        if (str2.length() > 0) {
            sb.append(str2);
        }
        sb.append(Deobfuscator$BDNETVPN$app.getString(-6437487867787L));
        sb.append(Deobfuscator$BDNETVPN$app.getString(-6476142573451L));
        sb.append(Deobfuscator$BDNETVPN$app.getString(-6493322442635L));
        sb.append(Deobfuscator$BDNETVPN$app.getString(-6501912377227L));
        if (str3.length() > 0) {
            sb.append(str3);
        }
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-6656531199883L), sb.toString().replaceAll(Deobfuscator$BDNETVPN$app.getString(-6720955709323L), Deobfuscator$BDNETVPN$app.getString(-6763905382283L)));
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-6772495316875L), Deobfuscator$BDNETVPN$app.getString(-6922819172235L));
        jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-10071030200203L), Deobfuscator$BDNETVPN$app.getString(-10156929546123L));
        return jSONObject.toString();
    }

    private static File defaultDataRootDirectory(Context context) {
        return context.getFileStreamPath(Deobfuscator$BDNETVPN$app.getString(-1279232145291L));
    }

    private static native int disableUdpGwKeepalive();

    private static native int enableUdpGwKeepalive();

    private static Collection<InetAddress> getActiveNetworkDNSServerAddresses(Context context, boolean z) {
        Deobfuscator$BDNETVPN$app.getString(-16002380035979L);
        ArrayList arrayList = new ArrayList();
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-16182768662411L));
        if (connectivityManager == null) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-16238603237259L), new Throwable(Deobfuscator$BDNETVPN$app.getString(-16418991863691L)));
        }
        try {
            Class.forName(Deobfuscator$BDNETVPN$app.getString(-16625150293899L));
            Object invoke = ConnectivityManager.class.getMethod(Deobfuscator$BDNETVPN$app.getString(-16741114410891L), new Class[0]).invoke(connectivityManager, new Object[0]);
            if (invoke != null) {
                Iterator<InetAddress> it = ((LinkProperties) invoke).getDnsServers().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            }
        } catch (ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | NullPointerException | InvocationTargetException unused) {
        }
        if (arrayList.isEmpty()) {
            NetworkRequest.Builder addCapability = new NetworkRequest.Builder().addCapability(12);
            if (z) {
                addCapability.addCapability(15);
            }
            NetworkRequest build = addCapability.build();
            final ArrayList arrayList2 = new ArrayList();
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            try {
                ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: ca.psiphon.PsiphonTunnel.3
                    @Override // android.net.ConnectivityManager.NetworkCallback
                    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
                        synchronized (arrayList2) {
                            arrayList2.addAll(linkProperties.getDnsServers());
                        }
                        countDownLatch.countDown();
                    }
                };
                connectivityManager.registerNetworkCallback(build, networkCallback);
                countDownLatch.await(1L, TimeUnit.SECONDS);
                connectivityManager.unregisterNetworkCallback(networkCallback);
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            } catch (RuntimeException unused3) {
            }
            synchronized (arrayList2) {
                arrayList.addAll(arrayList2);
            }
        }
        return arrayList;
    }

    private static Collection<String> getActiveNetworkDNSServers(Context context, boolean z) {
        ArrayList arrayList = new ArrayList();
        Iterator<InetAddress> it = getActiveNetworkDNSServerAddresses(context, z).iterator();
        while (it.hasNext()) {
            String inetAddress = it.next().toString();
            if (inetAddress.startsWith(Deobfuscator$BDNETVPN$app.getString(-15860646115211L))) {
                inetAddress = inetAddress.substring(1);
            }
            arrayList.add(inetAddress);
        }
        if (arrayList.isEmpty()) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-15869236049803L));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getDNSServers(Context context, HostLogger hostLogger) {
        String str = this.mActiveNetworkDNSServers.get();
        if (str == Deobfuscator$BDNETVPN$app.getString(-3078823442315L)) {
            try {
                return TextUtils.join(Deobfuscator$BDNETVPN$app.getString(-3083118409611L), getActiveNetworkDNSServers(context, this.mVpnMode.get()));
            } catch (Exception e) {
                hostLogger.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-3091708344203L) + e.getMessage());
            }
        }
        return str;
    }

    public static String getDefaultUpgradeDownloadFilePath(Context context) {
        return Psi.upgradeDownloadFilePath(defaultDataRootDirectory(context).getAbsolutePath());
    }

    private static String getDeviceRegion(Context context) {
        Locale locale;
        String string = Deobfuscator$BDNETVPN$app.getString(-14378882398091L);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-14383177365387L));
        if (telephonyManager != null) {
            if (telephonyManager.getPhoneType() != 2 && (string = telephonyManager.getNetworkCountryIso()) == null) {
                string = Deobfuscator$BDNETVPN$app.getString(-14408947169163L);
            }
            if (string.length() == 0 && (string = telephonyManager.getSimCountryIso()) == null) {
                string = Deobfuscator$BDNETVPN$app.getString(-14413242136459L);
            }
        }
        if (string.length() == 0 && (locale = Locale.getDefault()) != null) {
            string = locale.getCountry();
        }
        return string.toUpperCase(Locale.US);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getNetworkID(Context context, boolean z) {
        NetworkCapabilities networkCapabilities;
        String str;
        String string = Deobfuscator$BDNETVPN$app.getString(-3405240956811L);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-3439600695179L));
        NetworkInfo networkInfo = null;
        if (!z) {
            try {
                networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            } catch (java.lang.Exception unused) {
                networkCapabilities = null;
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                return Deobfuscator$BDNETVPN$app.getString(-3495435270027L);
            }
        }
        try {
            networkInfo = connectivityManager.getActiveNetworkInfo();
        } catch (java.lang.Exception unused2) {
        }
        try {
            if (networkInfo != null && networkInfo.getType() == 1) {
                String string2 = Deobfuscator$BDNETVPN$app.getString(-3512615139211L);
                WifiInfo connectionInfo = ((WifiManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-3534089975691L))).getConnectionInfo();
                if (connectionInfo == null) {
                    return string2;
                }
                String bssid = connectionInfo.getBSSID();
                if (bssid.equals(Deobfuscator$BDNETVPN$app.getString(-3555564812171L))) {
                    bssid = String.valueOf(connectionInfo.getIpAddress());
                }
                str = string2 + Deobfuscator$BDNETVPN$app.getString(-3632874223499L) + bssid;
            } else {
                if (networkInfo == null || networkInfo.getType() != 0) {
                    return string;
                }
                String string3 = Deobfuscator$BDNETVPN$app.getString(-3641464158091L);
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-3671528929163L));
                if (telephonyManager == null) {
                    return string3;
                }
                str = string3 + Deobfuscator$BDNETVPN$app.getString(-3697298732939L) + telephonyManager.getNetworkOperator();
            }
            return str;
        } catch (java.lang.Exception unused3) {
            return string;
        }
    }

    public static String getUpgradeDownloadFilePath(String str) {
        return Psi.upgradeDownloadFilePath(str);
    }

    private void handlePsiphonNotice(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-10483347060619L));
            if (string.equals(Deobfuscator$BDNETVPN$app.getString(-10530591700875L))) {
                int i = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-10564951439243L)).getInt(Deobfuscator$BDNETVPN$app.getString(-10586426275723L));
                if (i == 0) {
                    this.mHostService.onConnecting();
                } else if (i == 1) {
                    if (isVpnMode() && this.mShouldRouteThroughTunnelAutomatically) {
                        routeThroughTunnel();
                    }
                    this.mHostService.onConnected();
                }
            } else {
                int i2 = 0;
                if (string.equals(Deobfuscator$BDNETVPN$app.getString(-10612196079499L))) {
                    JSONArray jSONArray = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-10710980327307L)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-10732455163787L));
                    ArrayList arrayList = new ArrayList();
                    while (i2 < jSONArray.length()) {
                        arrayList.add(jSONArray.getString(i2));
                        i2++;
                    }
                    this.mHostService.onAvailableEgressRegions(arrayList);
                } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-10766814902155L))) {
                    this.mHostService.onSocksProxyPortInUse(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-10852714248075L)).getInt(Deobfuscator$BDNETVPN$app.getString(-10874189084555L)));
                } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-10895663921035L))) {
                    this.mHostService.onHttpProxyPortInUse(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-10977268299659L)).getInt(Deobfuscator$BDNETVPN$app.getString(-10998743136139L)));
                } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11020217972619L))) {
                    int i3 = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11123297187723L)).getInt(Deobfuscator$BDNETVPN$app.getString(-11144772024203L));
                    setLocalSocksProxyPort(i3);
                    this.mHostService.onListeningSocksProxyPort(i3);
                } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11166246860683L))) {
                    this.mHostService.onListeningHttpProxyPort(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11265031108491L)).getInt(Deobfuscator$BDNETVPN$app.getString(-11286505944971L)));
                } else {
                    if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11307980781451L))) {
                        this.mHostService.onUpstreamProxyError(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11389585160075L)).getString(Deobfuscator$BDNETVPN$app.getString(-11411059996555L)));
                        return;
                    }
                    if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11445419734923L))) {
                        this.mHostService.onClientUpgradeDownloaded(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11548498950027L)).getString(Deobfuscator$BDNETVPN$app.getString(-11569973786507L)));
                    } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11608628492171L))) {
                        this.mHostService.onClientIsLatestVersion();
                    } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11703117772683L))) {
                        this.mHostService.onHomepage(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11741772478347L)).getString(Deobfuscator$BDNETVPN$app.getString(-11763247314827L)));
                    } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11780427184011L))) {
                        this.mHostService.onClientRegion(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11836261758859L)).getString(Deobfuscator$BDNETVPN$app.getString(-11857736595339L)));
                    } else {
                        if (string.equals(Deobfuscator$BDNETVPN$app.getString(-11887801366411L))) {
                            this.mHostService.onClientAddress(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-11947930908555L)).getString(Deobfuscator$BDNETVPN$app.getString(-11969405745035L)));
                            return;
                        }
                        if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12003765483403L))) {
                            JSONArray jSONArray2 = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12085369862027L)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-12106844698507L));
                            ArrayList arrayList2 = new ArrayList();
                            while (i2 < jSONArray2.length()) {
                                arrayList2.add(jSONArray2.getString(i2));
                                i2++;
                            }
                            this.mHostService.onSplitTunnelRegions(arrayList2);
                        } else {
                            if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12141204436875L))) {
                                this.mHostService.onUntunneledAddress(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12188449077131L)).getString(Deobfuscator$BDNETVPN$app.getString(-12209923913611L)));
                                return;
                            }
                            if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12244283651979L))) {
                                JSONObject jSONObject2 = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12317298096011L));
                                this.mHostService.onBytesTransferred(jSONObject2.getLong(Deobfuscator$BDNETVPN$app.getString(-12338772932491L)), jSONObject2.getLong(Deobfuscator$BDNETVPN$app.getString(-12360247768971L)));
                                return;
                            }
                            if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12398902474635L))) {
                                JSONArray jSONArray3 = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12497686722443L)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-12519161558923L));
                                ArrayList arrayList3 = new ArrayList();
                                while (i2 < jSONArray3.length()) {
                                    arrayList3.add(jSONArray3.getString(i2));
                                    i2++;
                                }
                                this.mHostService.onActiveAuthorizationIDs(arrayList3);
                            } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12536341428107L))) {
                                this.mHostService.onExiting();
                            } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12570701166475L))) {
                                if (isVpnMode()) {
                                    if (jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12626535741323L)).getBoolean(Deobfuscator$BDNETVPN$app.getString(-12648010577803L))) {
                                        disableUdpGwKeepalive();
                                    } else {
                                        enableUdpGwKeepalive();
                                    }
                                }
                            } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12673780381579L))) {
                                this.mHostService.onApplicationParameters(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12768269662091L)).get(Deobfuscator$BDNETVPN$app.getString(-12789744498571L)));
                            } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-12836989138827L))) {
                                JSONArray jSONArray4 = jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12888528746379L)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-12910003582859L));
                                ArrayList arrayList4 = new ArrayList();
                                while (i2 < jSONArray4.length()) {
                                    arrayList4.add(jSONArray4.getString(i2));
                                    i2++;
                                }
                                this.mHostService.onServerAlert(jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-12957248223115L)).getString(Deobfuscator$BDNETVPN$app.getString(-12978723059595L)), jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-13008787830667L)).getString(Deobfuscator$BDNETVPN$app.getString(-13030262667147L)), arrayList4);
                            }
                        }
                    }
                }
            }
            this.mHostService.onDiagnosticMessage(string + Deobfuscator$BDNETVPN$app.getString(-13064622405515L) + jSONObject.getJSONObject(Deobfuscator$BDNETVPN$app.getString(-13077507307403L)).toString());
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long hasIPv6Route(Context context, HostLogger hostLogger) {
        boolean z;
        try {
            z = hasIPv6Route(context);
        } catch (Exception e) {
            hostLogger.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-3280686905227L) + e.getMessage());
            z = false;
        }
        return z ? 1L : 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long hasNetworkConnectivity() {
        boolean hasNetworkConnectivity = hasNetworkConnectivity(this.mHostService.getContext());
        boolean andSet = this.mIsWaitingForNetworkConnectivity.getAndSet(!hasNetworkConnectivity);
        if (!hasNetworkConnectivity && !andSet) {
            this.mHostService.onStartedWaitingForNetworkConnectivity();
        } else if (hasNetworkConnectivity && andSet) {
            this.mHostService.onStoppedWaitingForNetworkConnectivity();
        }
        return hasNetworkConnectivity ? 1L : 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String iPv6Synthesize(String str) {
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isVpnMode() {
        return this.mVpnMode.get();
    }

    private String loadPsiphonConfig(Context context) {
        HostService hostService = this.mHostService;
        return buildPsiphonConfig(context, hostService, hostService.getPsiphonConfig(), this.mClientPlatformPrefix.get(), this.mClientPlatformSuffix.get(), isVpnMode(), Integer.valueOf(this.mLocalSocksProxyPort.get()));
    }

    public static void logTun2Socks(String str, String str2, String str3) {
        mPsiphonTunnel.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-14572155926411L) + str + Deobfuscator$BDNETVPN$app.getString(-14623695533963L) + str2 + Deobfuscator$BDNETVPN$app.getString(-14632285468555L) + str3);
    }

    public static synchronized PsiphonTunnel newPsiphonTunnel(HostService hostService) {
        PsiphonTunnel newPsiphonTunnelImpl;
        synchronized (PsiphonTunnel.class) {
            newPsiphonTunnelImpl = newPsiphonTunnelImpl(hostService, true);
        }
        return newPsiphonTunnelImpl;
    }

    private static PsiphonTunnel newPsiphonTunnelImpl(HostService hostService, boolean z) {
        PsiphonTunnel psiphonTunnel = mPsiphonTunnel;
        if (psiphonTunnel != null) {
            psiphonTunnel.stop();
        }
        hostService.loadLibrary(Deobfuscator$BDNETVPN$app.getString(-1253462341515L));
        PsiphonTunnel psiphonTunnel2 = new PsiphonTunnel(hostService, z);
        mPsiphonTunnel = psiphonTunnel2;
        return psiphonTunnel2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notice(String str) {
        handlePsiphonNotice(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native int runTun2Socks(int i, int i2, String str, String str2, String str3, String str4, int i3);

    private static PrivateAddress selectPrivateAddress() {
        HashMap hashMap = new HashMap();
        hashMap.put(Deobfuscator$BDNETVPN$app.getString(-14705299912587L), new PrivateAddress(Deobfuscator$BDNETVPN$app.getString(-14718184814475L), Deobfuscator$BDNETVPN$app.getString(-14756839520139L), 8, Deobfuscator$BDNETVPN$app.getString(-14795494225803L)));
        hashMap.put(Deobfuscator$BDNETVPN$app.getString(-14834148931467L), new PrivateAddress(Deobfuscator$BDNETVPN$app.getString(-14851328800651L), Deobfuscator$BDNETVPN$app.getString(-14898573440907L), 12, Deobfuscator$BDNETVPN$app.getString(-14945818081163L)));
        hashMap.put(Deobfuscator$BDNETVPN$app.getString(-14993062721419L), new PrivateAddress(Deobfuscator$BDNETVPN$app.getString(-15010242590603L), Deobfuscator$BDNETVPN$app.getString(-15061782198155L), 16, Deobfuscator$BDNETVPN$app.getString(-15113321805707L)));
        hashMap.put(Deobfuscator$BDNETVPN$app.getString(-15164861413259L), new PrivateAddress(Deobfuscator$BDNETVPN$app.getString(-15182041282443L), Deobfuscator$BDNETVPN$app.getString(-15233580889995L), 24, Deobfuscator$BDNETVPN$app.getString(-15285120497547L)));
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                throw new Exception(Deobfuscator$BDNETVPN$app.getString(-15456919189387L));
            }
            Iterator it = Collections.list(networkInterfaces).iterator();
            while (it.hasNext()) {
                Iterator it2 = Collections.list(((NetworkInterface) it.next()).getInetAddresses()).iterator();
                while (it2.hasNext()) {
                    InetAddress inetAddress = (InetAddress) it2.next();
                    if (inetAddress instanceof Inet4Address) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.startsWith(Deobfuscator$BDNETVPN$app.getString(-15577178273675L))) {
                            hashMap.remove(Deobfuscator$BDNETVPN$app.getString(-15594358142859L));
                        } else if (hostAddress.length() >= 6 && hostAddress.substring(0, 6).compareTo(Deobfuscator$BDNETVPN$app.getString(-15607243044747L)) >= 0 && hostAddress.substring(0, 6).compareTo(Deobfuscator$BDNETVPN$app.getString(-15637307815819L)) <= 0) {
                            hashMap.remove(Deobfuscator$BDNETVPN$app.getString(-15667372586891L));
                        } else if (hostAddress.startsWith(Deobfuscator$BDNETVPN$app.getString(-15684552456075L))) {
                            hashMap.remove(Deobfuscator$BDNETVPN$app.getString(-15718912194443L));
                        }
                    }
                }
            }
            if (hashMap.size() > 0) {
                return (PrivateAddress) hashMap.values().iterator().next();
            }
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-15736092063627L));
        } catch (SocketException e) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-15336660105099L), e);
        }
    }

    private void setLocalSocksProxyPort(int i) {
        this.mLocalSocksProxyPort.set(i);
    }

    private static String setupTrustedCertificates(Context context, HostLogger hostLogger) {
        PrintStream printStream;
        Throwable th;
        File dir = context.getDir(Deobfuscator$BDNETVPN$app.getString(-13098982143883L), 0);
        Deobfuscator$BDNETVPN$app.getString(-13163406653323L);
        try {
            File file = new File(dir, Deobfuscator$BDNETVPN$app.getString(-13279370770315L));
            file.delete();
            try {
                printStream = new PrintStream(new FileOutputStream(file));
                try {
                    KeyStore keyStore = KeyStore.getInstance(Deobfuscator$BDNETVPN$app.getString(-13322320443275L));
                    keyStore.load(null, null);
                    Enumeration<String> aliases = keyStore.aliases();
                    while (aliases.hasMoreElements()) {
                        X509Certificate x509Certificate = (X509Certificate) keyStore.getCertificate(aliases.nextElement());
                        printStream.println(Deobfuscator$BDNETVPN$app.getString(-13554248677259L));
                        String str = new String(Base64.encode(x509Certificate.getEncoded(), 2), Deobfuscator$BDNETVPN$app.getString(-13674507761547L));
                        int i = 0;
                        while (i < str.length()) {
                            int i2 = i + 64;
                            printStream.println(str.substring(i, Math.min(i2, str.length())));
                            i = i2;
                        }
                        printStream.println(Deobfuscator$BDNETVPN$app.getString(-13700277565323L));
                    }
                    hostLogger.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-13811946715019L));
                    String absolutePath = file.getAbsolutePath();
                    printStream.close();
                    return absolutePath;
                } catch (Throwable th2) {
                    th = th2;
                    if (printStream == null) {
                        throw th;
                    }
                    printStream.close();
                    throw th;
                }
            } catch (Throwable th3) {
                printStream = null;
                th = th3;
            }
        } catch (IOException e) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-14262918281099L), e);
        } catch (KeyStoreException e2) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-13915025930123L), e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-14030990047115L), e3);
        } catch (CertificateException e4) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-14146954164107L), e4);
        }
    }

    private ParcelFileDescriptor startDummyVpn(VpnService.Builder builder) {
        PrivateAddress selectPrivateAddress = selectPrivateAddress();
        Locale locale = Locale.getDefault();
        Deobfuscator$BDNETVPN$app.getString(-2572017301387L);
        try {
            try {
                try {
                    Locale.setDefault(new Locale(Deobfuscator$BDNETVPN$app.getString(-2662211614603L)));
                    return builder.setSession(this.mHostService.getAppName()).setMtu(1500).addAddress(selectPrivateAddress.mIpAddress, selectPrivateAddress.mPrefixLength).addRoute(Deobfuscator$BDNETVPN$app.getString(-2675096516491L), 0).addRoute(selectPrivateAddress.mSubnet, selectPrivateAddress.mPrefixLength).addDnsServer(selectPrivateAddress.mRouter).establish();
                } catch (SecurityException e) {
                    throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2889844881291L), e);
                }
            } catch (IllegalArgumentException e2) {
                throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2709456254859L), e2);
            } catch (IllegalStateException e3) {
                throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2799650568075L), e3);
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    private void startPsiphon(String str) {
        stopPsiphon();
        this.mIsWaitingForNetworkConnectivity.set(false);
        this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-3705888667531L));
        try {
            this.mNetworkMonitor.start(this.mHostService.getContext());
            Psi.start(loadPsiphonConfig(this.mHostService.getContext()), str, Deobfuscator$BDNETVPN$app.getString(-3813262849931L), new PsiphonProviderShim(this), isVpnMode(), false, true);
            this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-3954996770699L));
        } catch (java.lang.Exception e) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-3817557817227L), e);
        }
    }

    private void startTun2Socks(final ParcelFileDescriptor parcelFileDescriptor, final int i, final String str, final String str2, final String str3, final String str4, final boolean z) {
        if (this.mTun2SocksThread != null) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: ca.psiphon.PsiphonTunnel.2
            @Override // java.lang.Runnable
            public void run() {
                PsiphonTunnel.runTun2Socks(parcelFileDescriptor.detachFd(), i, str, str2, str3, str4, z ? 1 : 0);
            }
        });
        this.mTun2SocksThread = thread;
        thread.start();
        this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-14417537103755L));
    }

    private boolean startVpn() {
        this.mVpnMode.set(true);
        this.mPrivateAddress = selectPrivateAddress();
        Locale locale = Locale.getDefault();
        Deobfuscator$BDNETVPN$app.getString(-2181175277451L);
        try {
            try {
                try {
                    try {
                        Locale.setDefault(new Locale(Deobfuscator$BDNETVPN$app.getString(-2249894754187L)));
                        String str = this.mPrivateAddress.mRouter;
                        VpnService.Builder builder = (VpnService.Builder) this.mHostService.newVpnServiceBuilder();
                        applyPerAppRules(builder);
                        VpnService.Builder mtu = builder.setSession(this.mHostService.getAppName()).setMtu(1500);
                        PrivateAddress privateAddress = this.mPrivateAddress;
                        VpnService.Builder addRoute = mtu.addAddress(privateAddress.mIpAddress, privateAddress.mPrefixLength).addRoute(Deobfuscator$BDNETVPN$app.getString(-2262779656075L), 0);
                        PrivateAddress privateAddress2 = this.mPrivateAddress;
                        ParcelFileDescriptor establish = addRoute.addRoute(privateAddress2.mSubnet, privateAddress2.mPrefixLength).addDnsServer(str).establish();
                        if (establish == null) {
                            return false;
                        }
                        this.mTunFd.set(establish);
                        this.mRoutingThroughTunnel.set(false);
                        this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-2297139394443L));
                        return true;
                    } catch (SecurityException e) {
                        throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2503297824651L), e);
                    }
                } catch (IllegalArgumentException e2) {
                    throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2365858871179L), e2);
                }
            } catch (IllegalStateException e3) {
                throw new Exception(Deobfuscator$BDNETVPN$app.getString(-2434578347915L), e3);
            }
        } finally {
            Locale.setDefault(locale);
        }
    }

    private void stopPsiphon() {
        this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-4058075985803L));
        this.mNetworkMonitor.stop(this.mHostService.getContext());
        Psi.stop();
        this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-4165450168203L));
    }

    private void stopTun2Socks() {
        if (this.mTun2SocksThread != null) {
            try {
                terminateTun2Socks();
                this.mTun2SocksThread.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            this.mTun2SocksThread = null;
            this.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-14494846515083L));
        }
    }

    private void stopVpn() {
        stopTun2Socks();
        ParcelFileDescriptor andSet = this.mTunFd.getAndSet(null);
        if (andSet != null) {
            try {
                andSet.close();
            } catch (IOException unused) {
            }
        }
        this.mRoutingThroughTunnel.set(false);
    }

    private static native int terminateTun2Socks();

    public Object clone() {
        throw new CloneNotSupportedException();
    }

    public String exportExchangePayload() {
        return Psi.exportExchangePayload();
    }

    public boolean importExchangePayload(String str) {
        return Psi.importExchangePayload(str);
    }

    public synchronized void reconnectPsiphon() {
        Psi.reconnectTunnel();
    }

    public synchronized void restartPsiphon() {
        stopPsiphon();
        startPsiphon(Deobfuscator$BDNETVPN$app.getString(-1871937632139L));
    }

    public void routeThroughTunnel() {
        ParcelFileDescriptor parcelFileDescriptor;
        PsiphonTunnel psiphonTunnel;
        if (this.mRoutingThroughTunnel.compareAndSet(false, true) && (parcelFileDescriptor = this.mTunFd.get()) != null) {
            try {
                psiphonTunnel = this;
            } catch (IOException e) {
                e = e;
                psiphonTunnel = this;
            }
            try {
                psiphonTunnel.startTun2Socks(parcelFileDescriptor.dup(), 1500, this.mPrivateAddress.mRouter, Deobfuscator$BDNETVPN$app.getString(-1579879856011L), Deobfuscator$BDNETVPN$app.getString(-1485390575499L) + Integer.toString(this.mLocalSocksProxyPort.get()), Deobfuscator$BDNETVPN$app.getString(-1532635215755L) + Integer.toString(UDPGW_SERVER_PORT), true);
                psiphonTunnel.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-1640009398155L));
            } catch (IOException e2) {
                e = e2;
                psiphonTunnel.mHostService.onDiagnosticMessage(Deobfuscator$BDNETVPN$app.getString(-1738793645963L) + e);
            }
        }
    }

    public void setClientPlatformAffixes(String str, String str2) {
        this.mClientPlatformPrefix.set(str);
        this.mClientPlatformSuffix.set(str2);
    }

    public synchronized boolean startRouting() {
        this.mHostService.loadLibrary(Deobfuscator$BDNETVPN$app.getString(-1455325804427L));
        return startVpn();
    }

    public synchronized void startTunneling(String str) {
        startPsiphon(str);
    }

    public synchronized void stop() {
        stopVpn();
        stopPsiphon();
        this.mVpnMode.set(false);
        this.mLocalSocksProxyPort.set(0);
    }

    public void stopRouteThroughTunnel() {
        if (this.mRoutingThroughTunnel.compareAndSet(true, false)) {
            stopTun2Socks();
        }
    }

    public void writeRuntimeProfiles(String str, int i, int i2) {
        Psi.writeRuntimeProfiles(str, i, i2);
    }

    public static synchronized PsiphonTunnel newPsiphonTunnel(HostService hostService, boolean z) {
        PsiphonTunnel newPsiphonTunnelImpl;
        synchronized (PsiphonTunnel.class) {
            newPsiphonTunnelImpl = newPsiphonTunnelImpl(hostService, z);
        }
        return newPsiphonTunnelImpl;
    }

    private static boolean hasIPv6Route(Context context) {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                NetworkInterface networkInterface = (NetworkInterface) it.next();
                if (networkInterface.isUp() && !networkInterface.isLoopback() && !networkInterface.isPointToPoint()) {
                    Iterator it2 = Collections.list(networkInterface.getInetAddresses()).iterator();
                    while (it2.hasNext()) {
                        InetAddress inetAddress = (InetAddress) it2.next();
                        if ((inetAddress instanceof Inet6Address) && !inetAddress.isLinkLocalAddress() && !inetAddress.isSiteLocalAddress() && !inetAddress.isMulticastAddress()) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (SocketException e) {
            throw new Exception(Deobfuscator$BDNETVPN$app.getString(-16882848331659L), e);
        }
    }

    public static class Exception extends java.lang.Exception {
        private static final long serialVersionUID = 1;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Exception(String str, Throwable th) {
            super(r3.toString());
            StringBuilder m = ZT.m(str);
            m.append(Deobfuscator$BDNETVPN$app.getString(-80936269707L));
            m.append(th.getMessage());
        }

        public Exception(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean hasNetworkConnectivity(Context context) {
        NetworkInfo activeNetworkInfo;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Deobfuscator$BDNETVPN$app.getString(-14649465337739L));
        return (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnected()) ? false : true;
    }
}
