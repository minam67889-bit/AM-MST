package okhttp3;

import defpackage.AbstractC3901me;
import defpackage.AbstractC4766xx;
import defpackage.C0384Oe;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* loaded from: classes.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final Companion E = new Companion(0);
    public static final List F = Util.j(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List G = Util.j(ConnectionSpec.e, ConnectionSpec.f);
    public final int A;
    public final int B;
    public final long C;
    public final RouteDatabase D;
    public final Dispatcher a;
    public final ConnectionPool b;
    public final List c;
    public final List d;
    public final EventListener.Factory e;
    public final boolean f;
    public final Authenticator g;
    public final boolean h;
    public final boolean i;
    public final CookieJar j;
    public final Cache k;
    public final Dns l;
    public final Proxy m;
    public final ProxySelector n;
    public final Authenticator o;
    public final SocketFactory p;
    public final SSLSocketFactory q;
    public final X509TrustManager r;
    public final List s;
    public final List t;
    public final HostnameVerifier u;
    public final CertificatePinner v;
    public final CertificateChainCleaner w;
    public final int x;
    public final int y;
    public final int z;

    public static final class Builder {
        public int A;
        public int B;
        public long C;
        public RouteDatabase D;
        public Dispatcher a = new Dispatcher();
        public ConnectionPool b = new ConnectionPool();
        public final ArrayList c = new ArrayList();
        public final ArrayList d = new ArrayList();
        public EventListener.Factory e;
        public boolean f;
        public Authenticator g;
        public boolean h;
        public boolean i;
        public CookieJar j;
        public Cache k;
        public Dns l;
        public Proxy m;
        public ProxySelector n;
        public Authenticator o;
        public SocketFactory p;
        public SSLSocketFactory q;
        public X509TrustManager r;
        public List s;
        public List t;
        public HostnameVerifier u;
        public CertificatePinner v;
        public CertificateChainCleaner w;
        public int x;
        public int y;
        public int z;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder() {
            EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = EventListener.a;
            byte[] bArr = Util.a;
            AbstractC4766xx.p(eventListener$Companion$NONE$1, "<this>");
            this.e = new C0384Oe(eventListener$Companion$NONE$1, 20);
            this.f = true;
            Authenticator authenticator = Authenticator.a;
            this.g = authenticator;
            this.h = true;
            this.i = true;
            this.j = CookieJar.a;
            this.l = Dns.a;
            this.o = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            AbstractC4766xx.o(socketFactory, "getDefault()");
            this.p = socketFactory;
            OkHttpClient.E.getClass();
            this.s = OkHttpClient.G;
            this.t = OkHttpClient.F;
            this.u = OkHostnameVerifier.a;
            this.v = CertificatePinner.d;
            this.y = 10000;
            this.z = 10000;
            this.A = 10000;
            this.C = 1024L;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void a(long j, TimeUnit timeUnit) {
            AbstractC4766xx.p(timeUnit, "unit");
            byte[] bArr = Util.a;
            if (j < 0) {
                throw new IllegalStateException(AbstractC4766xx.Y(" < 0", "timeout").toString());
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(AbstractC4766xx.Y(" too large.", "timeout").toString());
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException(AbstractC4766xx.Y(" too small.", "timeout").toString());
            }
            this.x = (int) millis;
        }
    }

    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(int i) {
            this();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public OkHttpClient() {
        this(new Builder());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Builder a() {
        Builder builder = new Builder();
        builder.a = this.a;
        builder.b = this.b;
        AbstractC3901me.X(this.c, builder.c);
        AbstractC3901me.X(this.d, builder.d);
        builder.e = this.e;
        builder.f = this.f;
        builder.g = this.g;
        builder.h = this.h;
        builder.i = this.i;
        builder.j = this.j;
        builder.k = this.k;
        builder.l = this.l;
        builder.m = this.m;
        builder.n = this.n;
        builder.o = this.o;
        builder.p = this.p;
        builder.q = this.q;
        builder.r = this.r;
        builder.s = this.s;
        builder.t = this.t;
        builder.u = this.u;
        builder.v = this.v;
        builder.w = this.w;
        builder.x = this.x;
        builder.y = this.y;
        builder.z = this.z;
        builder.A = this.A;
        builder.B = this.B;
        builder.C = this.C;
        builder.D = this.D;
        return builder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object clone() {
        return super.clone();
    }

    /* JADX WARN: Code restructure failed: missing block: B:79:0x004c, code lost:
    
        if (r0 == null) goto L4;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01cc  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OkHttpClient(Builder builder) {
        ProxySelector proxySelector;
        CertificatePinner certificatePinner;
        CertificatePinner certificatePinner2;
        List list;
        this.a = builder.a;
        this.b = builder.b;
        this.c = Util.v(builder.c);
        this.d = Util.v(builder.d);
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        this.l = builder.l;
        Proxy proxy = builder.m;
        this.m = proxy;
        if (proxy == null) {
            proxySelector = builder.n;
            proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        }
        proxySelector = NullProxySelector.a;
        this.n = proxySelector;
        this.o = builder.o;
        this.p = builder.p;
        List list2 = builder.s;
        this.s = list2;
        this.t = builder.t;
        this.u = builder.u;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        this.A = builder.A;
        this.B = builder.B;
        this.C = builder.C;
        RouteDatabase routeDatabase = builder.D;
        this.D = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        List list3 = list2;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).a) {
                    SSLSocketFactory sSLSocketFactory = builder.q;
                    if (sSLSocketFactory != null) {
                        this.q = sSLSocketFactory;
                        CertificateChainCleaner certificateChainCleaner = builder.w;
                        AbstractC4766xx.m(certificateChainCleaner);
                        this.w = certificateChainCleaner;
                        X509TrustManager x509TrustManager = builder.r;
                        AbstractC4766xx.m(x509TrustManager);
                        this.r = x509TrustManager;
                        certificatePinner = builder.v;
                        if (!AbstractC4766xx.d(certificatePinner.b, certificateChainCleaner)) {
                            certificatePinner2 = new CertificatePinner(certificatePinner.a, certificateChainCleaner);
                            certificatePinner = certificatePinner2;
                        }
                    } else {
                        Platform.a.getClass();
                        X509TrustManager m = Platform.b.m();
                        this.r = m;
                        this.q = Platform.b.l(m);
                        CertificateChainCleaner.a.getClass();
                        CertificateChainCleaner b = Platform.b.b(m);
                        this.w = b;
                        certificatePinner = builder.v;
                        if (!AbstractC4766xx.d(certificatePinner.b, b)) {
                            certificatePinner2 = new CertificatePinner(certificatePinner.a, b);
                            certificatePinner = certificatePinner2;
                        }
                    }
                    this.v = certificatePinner;
                    list = this.c;
                    if (!list.contains(null)) {
                        throw new IllegalStateException(AbstractC4766xx.Y(list, "Null interceptor: ").toString());
                    }
                    List list4 = this.d;
                    if (!(!list4.contains(null))) {
                        throw new IllegalStateException(AbstractC4766xx.Y(list4, "Null network interceptor: ").toString());
                    }
                    List list5 = this.s;
                    boolean z = list5 instanceof Collection;
                    X509TrustManager x509TrustManager2 = this.r;
                    CertificateChainCleaner certificateChainCleaner2 = this.w;
                    SSLSocketFactory sSLSocketFactory2 = this.q;
                    if (!z || !list5.isEmpty()) {
                        Iterator it2 = list5.iterator();
                        while (it2.hasNext()) {
                            if (((ConnectionSpec) it2.next()).a) {
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("sslSocketFactory == null".toString());
                                }
                                if (certificateChainCleaner2 == null) {
                                    throw new IllegalStateException("certificateChainCleaner == null".toString());
                                }
                                if (x509TrustManager2 == null) {
                                    throw new IllegalStateException("x509TrustManager == null".toString());
                                }
                                return;
                            }
                        }
                    }
                    if (sSLSocketFactory2 != null) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (certificateChainCleaner2 != null) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (x509TrustManager2 != null) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (!AbstractC4766xx.d(this.v, CertificatePinner.d)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    return;
                }
            }
        }
        this.q = null;
        this.w = null;
        this.r = null;
        certificatePinner = CertificatePinner.d;
        this.v = certificatePinner;
        list = this.c;
        if (!list.contains(null)) {
        }
    }
}
