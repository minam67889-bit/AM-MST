package okhttp3;

import defpackage.AbstractC0014Ae;
import defpackage.AbstractC3634my;
import defpackage.C3290ic;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.WebSocket;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

/* loaded from: classes2.dex */
public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {
    public static final Companion B = new Companion(0);
    public static final List C = Util.j(Protocol.HTTP_2, Protocol.HTTP_1_1);
    public static final List D = Util.j(ConnectionSpec.e, ConnectionSpec.f);
    public final RouteDatabase A;
    public final Dispatcher a;
    public final ConnectionPool b;
    public final List c;
    public final List d;
    public final C3290ic e;
    public final boolean f;
    public final Authenticator g;
    public final boolean h;
    public final boolean i;
    public final CookieJar j;
    public final Dns k;
    public final ProxySelector l;
    public final Authenticator m;
    public final SocketFactory n;
    public final SSLSocketFactory o;
    public final X509TrustManager p;
    public final List q;
    public final List r;
    public final OkHostnameVerifier s;
    public final CertificatePinner t;
    public final CertificateChainCleaner u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final long z;

    public static final class Builder {
        public RouteDatabase A;
        public Dispatcher a = new Dispatcher();
        public ConnectionPool b = new ConnectionPool();
        public final ArrayList c = new ArrayList();
        public final ArrayList d = new ArrayList();
        public C3290ic e;
        public boolean f;
        public Authenticator g;
        public boolean h;
        public boolean i;
        public CookieJar j;
        public Dns k;
        public ProxySelector l;
        public Authenticator m;
        public SocketFactory n;
        public SSLSocketFactory o;
        public X509TrustManager p;
        public List q;
        public List r;
        public OkHostnameVerifier s;
        public CertificatePinner t;
        public CertificateChainCleaner u;
        public int v;
        public int w;
        public int x;
        public int y;
        public long z;

        public Builder() {
            EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = EventListener.a;
            byte[] bArr = Util.a;
            AbstractC3634my.g(eventListener$Companion$NONE$1, "<this>");
            this.e = new C3290ic(eventListener$Companion$NONE$1, 24);
            this.f = true;
            Authenticator authenticator = Authenticator.a;
            this.g = authenticator;
            this.h = true;
            this.i = true;
            this.j = CookieJar.a;
            this.k = Dns.a;
            this.m = authenticator;
            SocketFactory socketFactory = SocketFactory.getDefault();
            AbstractC3634my.f(socketFactory, "getDefault()");
            this.n = socketFactory;
            OkHttpClient.B.getClass();
            this.q = OkHttpClient.D;
            this.r = OkHttpClient.C;
            this.s = OkHostnameVerifier.a;
            this.t = CertificatePinner.d;
            this.w = 10000;
            this.x = 10000;
            this.y = 10000;
            this.z = 1024L;
        }

        public final void a(long j) {
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            AbstractC3634my.g(timeUnit, "unit");
            byte[] bArr = Util.a;
            if (j < 0) {
                throw new IllegalStateException(AbstractC3634my.I(" < 0", "timeout").toString());
            }
            long millis = timeUnit.toMillis(j);
            if (millis > 2147483647L) {
                throw new IllegalArgumentException(AbstractC3634my.I(" too large.", "timeout").toString());
            }
            if (millis == 0 && j > 0) {
                throw new IllegalArgumentException(AbstractC3634my.I(" too small.", "timeout").toString());
            }
            this.v = (int) millis;
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(int i) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0118  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public OkHttpClient(Builder builder) {
        List list;
        this.a = builder.a;
        this.b = builder.b;
        this.c = Util.w(builder.c);
        this.d = Util.w(builder.d);
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
        this.h = builder.h;
        this.i = builder.i;
        this.j = builder.j;
        this.k = builder.k;
        ProxySelector proxySelector = builder.l;
        proxySelector = proxySelector == null ? ProxySelector.getDefault() : proxySelector;
        this.l = proxySelector == null ? NullProxySelector.a : proxySelector;
        this.m = builder.m;
        this.n = builder.n;
        List list2 = builder.q;
        this.q = list2;
        this.r = builder.r;
        this.s = builder.s;
        this.v = builder.v;
        this.w = builder.w;
        this.x = builder.x;
        this.y = builder.y;
        this.z = builder.z;
        RouteDatabase routeDatabase = builder.A;
        this.A = routeDatabase == null ? new RouteDatabase() : routeDatabase;
        List list3 = list2;
        if (!(list3 instanceof Collection) || !list3.isEmpty()) {
            Iterator it = list3.iterator();
            while (it.hasNext()) {
                if (((ConnectionSpec) it.next()).a) {
                    SSLSocketFactory sSLSocketFactory = builder.o;
                    if (sSLSocketFactory != null) {
                        this.o = sSLSocketFactory;
                        CertificateChainCleaner certificateChainCleaner = builder.u;
                        AbstractC3634my.d(certificateChainCleaner);
                        this.u = certificateChainCleaner;
                        X509TrustManager x509TrustManager = builder.p;
                        AbstractC3634my.d(x509TrustManager);
                        this.p = x509TrustManager;
                        CertificatePinner certificatePinner = builder.t;
                        certificatePinner.getClass();
                        this.t = AbstractC3634my.a(certificatePinner.b, certificateChainCleaner) ? certificatePinner : new CertificatePinner(certificatePinner.a, certificateChainCleaner);
                    } else {
                        Platform.a.getClass();
                        X509TrustManager m = Platform.b.m();
                        this.p = m;
                        this.o = Platform.b.l(m);
                        CertificateChainCleaner.a.getClass();
                        CertificateChainCleaner b = Platform.b.b(m);
                        this.u = b;
                        CertificatePinner certificatePinner2 = builder.t;
                        certificatePinner2.getClass();
                        this.t = AbstractC3634my.a(certificatePinner2.b, b) ? certificatePinner2 : new CertificatePinner(certificatePinner2.a, b);
                    }
                    list = this.c;
                    if (!list.contains(null)) {
                        throw new IllegalStateException(AbstractC3634my.I(list, "Null interceptor: ").toString());
                    }
                    List list4 = this.d;
                    if (list4.contains(null)) {
                        throw new IllegalStateException(AbstractC3634my.I(list4, "Null network interceptor: ").toString());
                    }
                    List list5 = this.q;
                    boolean z = list5 instanceof Collection;
                    X509TrustManager x509TrustManager2 = this.p;
                    CertificateChainCleaner certificateChainCleaner2 = this.u;
                    SSLSocketFactory sSLSocketFactory2 = this.o;
                    if (!z || !list5.isEmpty()) {
                        Iterator it2 = list5.iterator();
                        while (it2.hasNext()) {
                            if (((ConnectionSpec) it2.next()).a) {
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("sslSocketFactory == null");
                                }
                                if (certificateChainCleaner2 == null) {
                                    throw new IllegalStateException("certificateChainCleaner == null");
                                }
                                if (x509TrustManager2 == null) {
                                    throw new IllegalStateException("x509TrustManager == null");
                                }
                                return;
                            }
                        }
                    }
                    if (sSLSocketFactory2 != null) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (certificateChainCleaner2 != null) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (x509TrustManager2 != null) {
                        throw new IllegalStateException("Check failed.");
                    }
                    if (!AbstractC3634my.a(this.t, CertificatePinner.d)) {
                        throw new IllegalStateException("Check failed.");
                    }
                    return;
                }
            }
        }
        this.o = null;
        this.u = null;
        this.p = null;
        this.t = CertificatePinner.d;
        list = this.c;
        if (!list.contains(null)) {
        }
    }

    public final Builder a() {
        Builder builder = new Builder();
        builder.a = this.a;
        builder.b = this.b;
        AbstractC0014Ae.o0(this.c, builder.c);
        AbstractC0014Ae.o0(this.d, builder.d);
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
        return builder;
    }

    public final Object clone() {
        return super.clone();
    }

    public OkHttpClient() {
        this(new Builder());
    }
}
