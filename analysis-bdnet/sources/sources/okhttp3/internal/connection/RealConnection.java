package okhttp3.internal.connection;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import defpackage.AbstractC0538Uj;
import defpackage.AbstractC3634my;
import defpackage.AbstractC3836pV;
import defpackage.AbstractC4243ue;
import defpackage.C0451Ra;
import defpackage.C4254un;
import defpackage.C4316vb;
import defpackage.RM;
import defpackage.SM;
import defpackage.SQ;
import defpackage.W50;
import defpackage.XE;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.InetSocketAddress;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.CertificatePinner;
import okhttp3.CipherSuite;
import okhttp3.Connection;
import okhttp3.ConnectionSpec;
import okhttp3.EventListener;
import okhttp3.EventListener$Companion$NONE$1;
import okhttp3.Handshake;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http1.Http1ExchangeCodec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2ExchangeCodec;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.http2.Http2Writer;
import okhttp3.internal.http2.Settings;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;

/* loaded from: classes2.dex */
public final class RealConnection extends Http2Connection.Listener implements Connection {
    public final Route b;
    public Socket c;
    public Socket d;
    public Handshake e;
    public Protocol f;
    public Http2Connection g;
    public SM h;
    public RM i;
    public boolean j;
    public boolean k;
    public int l;
    public int m;
    public int n;
    public int o;
    public final ArrayList p;
    public long q;

    public static final class Companion {
        public /* synthetic */ Companion(int i) {
            this();
        }

        private Companion() {
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            iArr[Proxy.Type.HTTP.ordinal()] = 2;
            a = iArr;
        }
    }

    static {
        new Companion(0);
    }

    public RealConnection(RealConnectionPool realConnectionPool, Route route) {
        AbstractC3634my.g(realConnectionPool, "connectionPool");
        AbstractC3634my.g(route, "route");
        this.b = route;
        this.o = 1;
        this.p = new ArrayList();
        this.q = Long.MAX_VALUE;
    }

    public static void d(OkHttpClient okHttpClient, Route route, IOException iOException) {
        AbstractC3634my.g(route, "failedRoute");
        AbstractC3634my.g(iOException, "failure");
        if (route.b.type() != Proxy.Type.DIRECT) {
            Address address = route.a;
            address.g.connectFailed(address.h.g(), route.b.address(), iOException);
        }
        RouteDatabase routeDatabase = okHttpClient.A;
        synchronized (routeDatabase) {
            routeDatabase.a.add(route);
        }
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final synchronized void a(Http2Connection http2Connection, Settings settings) {
        AbstractC3634my.g(http2Connection, "connection");
        AbstractC3634my.g(settings, "settings");
        this.o = (settings.a & 16) != 0 ? settings.b[4] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // okhttp3.internal.http2.Http2Connection.Listener
    public final void b(Http2Stream http2Stream) {
        http2Stream.c(ErrorCode.REFUSED_STREAM, null);
    }

    public final void c(int i, int i2, int i3, boolean z, Call call, EventListener eventListener) {
        Route route;
        AbstractC3634my.g(call, "call");
        AbstractC3634my.g(eventListener, "eventListener");
        if (this.f != null) {
            throw new IllegalStateException("already connected");
        }
        List list = this.b.a.j;
        ConnectionSpecSelector connectionSpecSelector = new ConnectionSpecSelector(list);
        Address address = this.b.a;
        if (address.c == null) {
            if (!list.contains(ConnectionSpec.f)) {
                throw new RouteException(new UnknownServiceException("CLEARTEXT communication not enabled for client"));
            }
            String str = this.b.a.h.d;
            Platform.a.getClass();
            if (!Platform.b.h(str)) {
                throw new RouteException(new UnknownServiceException(W50.D("CLEARTEXT communication to ", str, " not permitted by network security policy")));
            }
        } else if (address.i.contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            throw new RouteException(new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"));
        }
        RouteException routeException = null;
        do {
            try {
                Route route2 = this.b;
                if (route2.a.c != null && route2.b.type() == Proxy.Type.HTTP) {
                    f(i, i2, i3, call, eventListener);
                    if (this.c == null) {
                        route = this.b;
                        if (route.a.c == null && route.b.type() == Proxy.Type.HTTP && this.c == null) {
                            throw new RouteException(new ProtocolException("Too many tunnel connections attempted: 21"));
                        }
                        this.q = System.nanoTime();
                        return;
                    }
                } else {
                    e(i, i2, call, eventListener);
                }
                g(connectionSpecSelector, call, eventListener);
                InetSocketAddress inetSocketAddress = this.b.c;
                EventListener$Companion$NONE$1 eventListener$Companion$NONE$1 = EventListener.a;
                AbstractC3634my.g(inetSocketAddress, "inetSocketAddress");
                route = this.b;
                if (route.a.c == null) {
                }
                this.q = System.nanoTime();
                return;
            } catch (IOException e) {
                Socket socket = this.d;
                if (socket != null) {
                    Util.c(socket);
                }
                Socket socket2 = this.c;
                if (socket2 != null) {
                    Util.c(socket2);
                }
                this.d = null;
                this.c = null;
                this.h = null;
                this.i = null;
                this.e = null;
                this.f = null;
                this.g = null;
                this.o = 1;
                AbstractC3634my.g(this.b.c, "inetSocketAddress");
                if (routeException == null) {
                    routeException = new RouteException(e);
                } else {
                    XE.b(routeException.a, e);
                    routeException.b = e;
                }
                if (!z) {
                    throw routeException;
                }
                connectionSpecSelector.d = true;
                if (!connectionSpecSelector.c) {
                    throw routeException;
                }
                if (e instanceof ProtocolException) {
                    throw routeException;
                }
                if (e instanceof InterruptedIOException) {
                    throw routeException;
                }
                if ((e instanceof SSLHandshakeException) && (e.getCause() instanceof CertificateException)) {
                    throw routeException;
                }
                if (e instanceof SSLPeerUnverifiedException) {
                    throw routeException;
                }
            }
        } while (e instanceof SSLException);
        throw routeException;
    }

    public final void e(int i, int i2, Call call, EventListener eventListener) {
        Socket createSocket;
        Route route = this.b;
        Proxy proxy = route.b;
        Address address = route.a;
        Proxy.Type type = proxy.type();
        int i3 = type == null ? -1 : WhenMappings.a[type.ordinal()];
        if (i3 == 1 || i3 == 2) {
            createSocket = address.b.createSocket();
            AbstractC3634my.d(createSocket);
        } else {
            createSocket = new Socket(proxy);
        }
        this.c = createSocket;
        InetSocketAddress inetSocketAddress = this.b.c;
        eventListener.getClass();
        AbstractC3634my.g(call, "call");
        AbstractC3634my.g(inetSocketAddress, "inetSocketAddress");
        createSocket.setSoTimeout(i2);
        try {
            Platform.a.getClass();
            Platform.b.e(createSocket, this.b.c, i);
            try {
                this.h = new SM(AbstractC0538Uj.W(createSocket));
                this.i = AbstractC0538Uj.d(AbstractC0538Uj.R(createSocket));
            } catch (NullPointerException e) {
                if (AbstractC3634my.a(e.getMessage(), "throw with null exception")) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException(AbstractC3634my.I(this.b.c, "Failed to connect to "));
            connectException.initCause(e2);
            throw connectException;
        }
    }

    public final void f(int i, int i2, int i3, Call call, EventListener eventListener) {
        Request.Builder builder = new Request.Builder();
        Route route = this.b;
        HttpUrl httpUrl = route.a.h;
        AbstractC3634my.g(httpUrl, ImagesContract.URL);
        builder.a = httpUrl;
        builder.d("CONNECT", null);
        Address address = route.a;
        builder.c("Host", Util.v(address.h, true));
        builder.c("Proxy-Connection", "Keep-Alive");
        builder.c("User-Agent", "okhttp/4.11.0");
        Request b = builder.b();
        Response.Builder builder2 = new Response.Builder();
        builder2.a = b;
        builder2.b = Protocol.HTTP_1_1;
        builder2.c = 407;
        builder2.d = "Preemptive Authenticate";
        builder2.g = Util.c;
        builder2.k = -1L;
        builder2.l = -1L;
        Headers.Builder builder3 = builder2.f;
        builder3.getClass();
        Headers.b.getClass();
        Headers.Companion.a("Proxy-Authenticate");
        Headers.Companion.b("OkHttp-Preemptive", "Proxy-Authenticate");
        builder3.c("Proxy-Authenticate");
        builder3.a("Proxy-Authenticate", "OkHttp-Preemptive");
        Request a = address.f.a(route, builder2.a());
        if (a != null) {
            b = a;
        }
        e(i, i2, call, eventListener);
        String str = "CONNECT " + Util.v(b.a, true) + " HTTP/1.1";
        while (true) {
            SM sm = this.h;
            AbstractC3634my.d(sm);
            RM rm = this.i;
            AbstractC3634my.d(rm);
            Http1ExchangeCodec http1ExchangeCodec = new Http1ExchangeCodec(null, this, sm, rm);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            sm.a.timeout().g(i2, timeUnit);
            rm.a.timeout().g(i3, timeUnit);
            http1ExchangeCodec.k(b.c, str);
            http1ExchangeCodec.a();
            Response.Builder g = http1ExchangeCodec.g(false);
            AbstractC3634my.d(g);
            g.a = b;
            Response a2 = g.a();
            http1ExchangeCodec.j(a2);
            int i4 = a2.d;
            if (i4 == 200) {
                if (!sm.b.b() || !rm.b.b()) {
                    throw new IOException("TLS tunnel buffered too many bytes!");
                }
                return;
            } else {
                if (i4 != 407) {
                    throw new IOException(AbstractC3634my.I(Integer.valueOf(i4), "Unexpected response code for CONNECT: "));
                }
                Request a3 = address.f.a(route, a2);
                if (a3 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(Response.b("Connection", a2))) {
                    return;
                } else {
                    b = a3;
                }
            }
        }
    }

    public final void g(ConnectionSpecSelector connectionSpecSelector, Call call, EventListener eventListener) {
        Protocol protocol;
        Address address = this.b.a;
        if (address.c == null) {
            List list = address.i;
            Protocol protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
            if (!list.contains(protocol2)) {
                this.d = this.c;
                this.f = Protocol.HTTP_1_1;
                return;
            } else {
                this.d = this.c;
                this.f = protocol2;
                l();
                return;
            }
        }
        eventListener.getClass();
        AbstractC3634my.g(call, "call");
        Address address2 = this.b.a;
        SSLSocketFactory sSLSocketFactory = address2.c;
        SSLSocket sSLSocket = null;
        String str = null;
        try {
            AbstractC3634my.d(sSLSocketFactory);
            Socket socket = this.c;
            HttpUrl httpUrl = address2.h;
            Socket createSocket = sSLSocketFactory.createSocket(socket, httpUrl.d, httpUrl.e, true);
            if (createSocket == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.SSLSocket");
            }
            SSLSocket sSLSocket2 = (SSLSocket) createSocket;
            try {
                ConnectionSpec a = connectionSpecSelector.a(sSLSocket2);
                if (a.b) {
                    Platform.a.getClass();
                    Platform.b.d(sSLSocket2, address2.h.d, address2.i);
                }
                sSLSocket2.startHandshake();
                SSLSession session = sSLSocket2.getSession();
                Handshake.Companion companion = Handshake.e;
                AbstractC3634my.f(session, "sslSocketSession");
                companion.getClass();
                Handshake a2 = Handshake.Companion.a(session);
                HostnameVerifier hostnameVerifier = address2.d;
                AbstractC3634my.d(hostnameVerifier);
                if (hostnameVerifier.verify(address2.h.d, session)) {
                    CertificatePinner certificatePinner = address2.e;
                    AbstractC3634my.d(certificatePinner);
                    this.e = new Handshake(a2.a, a2.b, a2.c, new RealConnection$connectTls$1(certificatePinner, a2, address2));
                    certificatePinner.b(address2.h.d, new RealConnection$connectTls$2(this));
                    if (a.b) {
                        Platform.a.getClass();
                        str = Platform.b.f(sSLSocket2);
                    }
                    this.d = sSLSocket2;
                    this.h = new SM(AbstractC0538Uj.W(sSLSocket2));
                    this.i = AbstractC0538Uj.d(AbstractC0538Uj.R(sSLSocket2));
                    if (str != null) {
                        Protocol.b.getClass();
                        protocol = Protocol.Companion.a(str);
                    } else {
                        protocol = Protocol.HTTP_1_1;
                    }
                    this.f = protocol;
                    Platform.a.getClass();
                    Platform.b.a(sSLSocket2);
                    if (this.f == Protocol.HTTP_2) {
                        l();
                        return;
                    }
                    return;
                }
                List a3 = a2.a();
                if (a3.isEmpty()) {
                    throw new SSLPeerUnverifiedException("Hostname " + address2.h.d + " not verified (no certificates)");
                }
                X509Certificate x509Certificate = (X509Certificate) a3.get(0);
                StringBuilder sb = new StringBuilder("\n              |Hostname ");
                sb.append(address2.h.d);
                sb.append(" not verified:\n              |    certificate: ");
                CertificatePinner.c.getClass();
                AbstractC3634my.g(x509Certificate, "certificate");
                C4316vb c4316vb = C4316vb.d;
                byte[] encoded = x509Certificate.getPublicKey().getEncoded();
                AbstractC3634my.f(encoded, "publicKey.encoded");
                sb.append(AbstractC3634my.I(C4254un.s(encoded).b("SHA-256").a(), "sha256/"));
                sb.append("\n              |    DN: ");
                sb.append((Object) x509Certificate.getSubjectDN().getName());
                sb.append("\n              |    subjectAltNames: ");
                OkHostnameVerifier.a.getClass();
                sb.append(AbstractC4243ue.z0(OkHostnameVerifier.a(x509Certificate, 2), OkHostnameVerifier.a(x509Certificate, 7)));
                sb.append("\n              ");
                throw new SSLPeerUnverifiedException(AbstractC3836pV.k0(sb.toString()));
            } catch (Throwable th) {
                th = th;
                sSLSocket = sSLSocket2;
                if (sSLSocket != null) {
                    Platform.a.getClass();
                    Platform.b.a(sSLSocket);
                }
                if (sSLSocket != null) {
                    Util.c(sSLSocket);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ac, code lost:
    
        if (okhttp3.internal.tls.OkHostnameVerifier.c(r1, r0) != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(Address address, ArrayList arrayList) {
        Handshake handshake;
        byte[] bArr = Util.a;
        if (this.p.size() < this.o && !this.j) {
            Route route = this.b;
            if (route.a.a(address)) {
                HttpUrl httpUrl = address.h;
                String str = httpUrl.d;
                Address address2 = route.a;
                if (AbstractC3634my.a(str, address2.h.d)) {
                    return true;
                }
                if (this.g != null && arrayList != null && !arrayList.isEmpty()) {
                    Iterator it = arrayList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Route route2 = (Route) it.next();
                        Proxy.Type type = route2.b.type();
                        Proxy.Type type2 = Proxy.Type.DIRECT;
                        if (type == type2 && route.b.type() == type2) {
                            if (AbstractC3634my.a(route.c, route2.c)) {
                                OkHostnameVerifier okHostnameVerifier = OkHostnameVerifier.a;
                                if (address.d == okHostnameVerifier) {
                                    byte[] bArr2 = Util.a;
                                    HttpUrl httpUrl2 = address2.h;
                                    if (httpUrl.e == httpUrl2.e) {
                                        String str2 = httpUrl2.d;
                                        String str3 = httpUrl.d;
                                        if (!AbstractC3634my.a(str3, str2)) {
                                            if (!this.k && (handshake = this.e) != null) {
                                                List a = handshake.a();
                                                if (!a.isEmpty()) {
                                                    X509Certificate x509Certificate = (X509Certificate) a.get(0);
                                                    okHostnameVerifier.getClass();
                                                }
                                            }
                                        }
                                        try {
                                            CertificatePinner certificatePinner = address.e;
                                            AbstractC3634my.d(certificatePinner);
                                            Handshake handshake2 = this.e;
                                            AbstractC3634my.d(handshake2);
                                            certificatePinner.a(str3, handshake2.a());
                                            return true;
                                        } catch (SSLPeerUnverifiedException unused) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean i(boolean z) {
        long j;
        byte[] bArr = Util.a;
        long nanoTime = System.nanoTime();
        Socket socket = this.c;
        AbstractC3634my.d(socket);
        Socket socket2 = this.d;
        AbstractC3634my.d(socket2);
        AbstractC3634my.d(this.h);
        if (socket.isClosed() || socket2.isClosed() || socket2.isInputShutdown() || socket2.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.g;
        if (http2Connection != null) {
            synchronized (http2Connection) {
                if (http2Connection.f) {
                    return false;
                }
                if (http2Connection.o < http2Connection.n) {
                    if (nanoTime >= http2Connection.p) {
                        return false;
                    }
                }
                return true;
            }
        }
        synchronized (this) {
            j = nanoTime - this.q;
        }
        if (j < 10000000000L || !z) {
            return true;
        }
        try {
            int soTimeout = socket2.getSoTimeout();
            try {
                socket2.setSoTimeout(1);
                return !r4.b();
            } finally {
                socket2.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public final ExchangeCodec j(OkHttpClient okHttpClient, RealInterceptorChain realInterceptorChain) {
        Socket socket = this.d;
        AbstractC3634my.d(socket);
        SM sm = this.h;
        AbstractC3634my.d(sm);
        RM rm = this.i;
        AbstractC3634my.d(rm);
        Http2Connection http2Connection = this.g;
        if (http2Connection != null) {
            return new Http2ExchangeCodec(okHttpClient, this, realInterceptorChain, http2Connection);
        }
        int i = realInterceptorChain.g;
        socket.setSoTimeout(i);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        sm.a.timeout().g(i, timeUnit);
        rm.a.timeout().g(realInterceptorChain.h, timeUnit);
        return new Http1ExchangeCodec(okHttpClient, this, sm, rm);
    }

    public final synchronized void k() {
        this.j = true;
    }

    public final void l() {
        Socket socket = this.d;
        AbstractC3634my.d(socket);
        SM sm = this.h;
        AbstractC3634my.d(sm);
        RM rm = this.i;
        AbstractC3634my.d(rm);
        socket.setSoTimeout(0);
        TaskRunner taskRunner = TaskRunner.i;
        Http2Connection.Builder builder = new Http2Connection.Builder(taskRunner);
        String str = this.b.a.h.d;
        AbstractC3634my.g(str, "peerName");
        builder.b = socket;
        String str2 = Util.g + ' ' + str;
        AbstractC3634my.g(str2, "<set-?>");
        builder.c = str2;
        builder.d = sm;
        builder.e = rm;
        builder.f = this;
        Http2Connection http2Connection = new Http2Connection(builder);
        this.g = http2Connection;
        Http2Connection.A.getClass();
        Settings settings = Http2Connection.B;
        int i = 4;
        this.o = (settings.a & 16) != 0 ? settings.b[4] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        Http2Writer http2Writer = http2Connection.x;
        synchronized (http2Writer) {
            try {
                if (http2Writer.d) {
                    throw new IOException("closed");
                }
                Logger logger = Http2Writer.f;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Util.g(AbstractC3634my.I(Http2.b.d(), ">> CONNECTION "), new Object[0]));
                }
                http2Writer.a.d(Http2.b);
                http2Writer.a.flush();
            } finally {
            }
        }
        Http2Writer http2Writer2 = http2Connection.x;
        Settings settings2 = http2Connection.q;
        synchronized (http2Writer2) {
            try {
                AbstractC3634my.g(settings2, "settings");
                if (http2Writer2.d) {
                    throw new IOException("closed");
                }
                http2Writer2.f(0, Integer.bitCount(settings2.a) * 6, 4, 0);
                int i2 = 0;
                while (i2 < 10) {
                    int i3 = i2 + 1;
                    boolean z = true;
                    if (((1 << i2) & settings2.a) == 0) {
                        z = false;
                    }
                    if (z) {
                        int i4 = i2 != i ? i2 != 7 ? i2 : i : 3;
                        RM rm2 = http2Writer2.a;
                        if (rm2.c) {
                            throw new IllegalStateException("closed");
                        }
                        C0451Ra c0451Ra = rm2.b;
                        SQ t = c0451Ra.t(2);
                        int i5 = t.c;
                        byte[] bArr = t.a;
                        bArr[i5] = (byte) ((i4 >>> 8) & 255);
                        bArr[i5 + 1] = (byte) (i4 & 255);
                        t.c = i5 + 2;
                        c0451Ra.b += 2;
                        rm2.b();
                        http2Writer2.a.g(settings2.b[i2]);
                    }
                    i2 = i3;
                    i = 4;
                }
                http2Writer2.a.flush();
            } finally {
            }
        }
        if (http2Connection.q.a() != 65535) {
            http2Connection.x.m(0, r2 - 65535);
        }
        TaskQueue e = taskRunner.e();
        final String str3 = http2Connection.c;
        final Http2Connection.ReaderRunnable readerRunnable = http2Connection.y;
        e.c(new Task(str3) { // from class: okhttp3.internal.concurrent.TaskQueue$execute$1
            @Override // okhttp3.internal.concurrent.Task
            public final long a() {
                readerRunnable.invoke();
                return -1L;
            }
        }, 0L);
    }

    public final String toString() {
        CipherSuite cipherSuite;
        StringBuilder sb = new StringBuilder("Connection{");
        Route route = this.b;
        sb.append(route.a.h.d);
        sb.append(':');
        sb.append(route.a.h.e);
        sb.append(", proxy=");
        sb.append(route.b);
        sb.append(" hostAddress=");
        sb.append(route.c);
        sb.append(" cipherSuite=");
        Handshake handshake = this.e;
        Object obj = DevicePublicKeyStringDef.NONE;
        if (handshake != null && (cipherSuite = handshake.b) != null) {
            obj = cipherSuite;
        }
        sb.append(obj);
        sb.append(" protocol=");
        sb.append(this.f);
        sb.append('}');
        return sb.toString();
    }
}
