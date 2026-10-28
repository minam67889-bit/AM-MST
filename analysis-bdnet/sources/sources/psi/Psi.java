package psi;

import go.Seq;

/* loaded from: classes2.dex */
public abstract class Psi {

    public static final class proxyPsiphonProvider implements Seq.Proxy, PsiphonProvider {
        private final int refnum;

        public proxyPsiphonProvider(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }

        @Override // psi.PsiphonProvider
        public native String bindToDevice(long j);

        @Override // psi.PsiphonProvider
        public native String getDNSServersAsString();

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public native String getNetworkID();

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public native long hasIPv6Route();

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public native long hasNetworkConnectivity();

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNetwork
        public native String iPv6Synthesize(String str);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        @Override // psi.PsiphonProvider, psi.PsiphonProviderNoticeHandler
        public native void notice(String str);
    }

    public static final class proxyPsiphonProviderFeedbackHandler implements Seq.Proxy, PsiphonProviderFeedbackHandler {
        private final int refnum;

        public proxyPsiphonProviderFeedbackHandler(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        @Override // psi.PsiphonProviderFeedbackHandler
        public native void sendFeedbackCompleted(Exception exc);
    }

    public static final class proxyPsiphonProviderNetwork implements Seq.Proxy, PsiphonProviderNetwork {
        private final int refnum;

        public proxyPsiphonProviderNetwork(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }

        @Override // psi.PsiphonProviderNetwork
        public native String getNetworkID();

        @Override // psi.PsiphonProviderNetwork
        public native long hasIPv6Route();

        @Override // psi.PsiphonProviderNetwork
        public native long hasNetworkConnectivity();

        @Override // psi.PsiphonProviderNetwork
        public native String iPv6Synthesize(String str);

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }
    }

    public static final class proxyPsiphonProviderNoticeHandler implements Seq.Proxy, PsiphonProviderNoticeHandler {
        private final int refnum;

        public proxyPsiphonProviderNoticeHandler(int i) {
            this.refnum = i;
            Seq.trackGoRef(i, this);
        }

        @Override // go.Seq.GoObject
        public final int incRefnum() {
            Seq.incGoRef(this.refnum, this);
            return this.refnum;
        }

        @Override // psi.PsiphonProviderNoticeHandler
        public native void notice(String str);
    }

    static {
        Seq.touch();
        _init();
    }

    private Psi() {
    }

    private static native void _init();

    public static native String exportExchangePayload();

    public static native String getBuildInfo();

    public static native long getPacketTunnelMTU();

    public static native String homepageFilePath(String str);

    public static native boolean importExchangePayload(String str);

    public static native void noticeUserLog(String str);

    public static native String noticesFilePath(String str);

    public static native String oldNoticesFilePath(String str);

    public static native void reconnectTunnel();

    public static native void setDynamicConfig(String str, String str2);

    public static native void start(String str, String str2, String str3, PsiphonProvider psiphonProvider, boolean z, boolean z2, boolean z3);

    public static native void startSendFeedback(String str, String str2, String str3, PsiphonProviderFeedbackHandler psiphonProviderFeedbackHandler, PsiphonProviderNetwork psiphonProviderNetwork, PsiphonProviderNoticeHandler psiphonProviderNoticeHandler, boolean z, boolean z2);

    public static native void stop();

    public static native void stopSendFeedback();

    public static void touch() {
    }

    public static native String upgradeDownloadFilePath(String str);

    public static native void writeRuntimeProfiles(String str, long j, long j2);
}
