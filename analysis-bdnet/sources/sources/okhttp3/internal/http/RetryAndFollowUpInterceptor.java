package okhttp3.internal.http;

import com.google.android.gms.common.api.Api;
import defpackage.AbstractC3634my;
import defpackage.AbstractC4243ue;
import defpackage.C3147go;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.ExchangeFinder;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RealConnectionPool;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.tls.OkHostnameVerifier;

/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public final OkHttpClient a;

    public static final class Companion {
        public /* synthetic */ Companion(int i) {
            this();
        }

        private Companion() {
        }
    }

    static {
        new Companion(0);
    }

    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    public static int c(Response response, int i) {
        String b = Response.b("Retry-After", response);
        if (b == null) {
            return i;
        }
        Pattern compile = Pattern.compile("\\d+");
        AbstractC3634my.f(compile, "compile(...)");
        if (!compile.matcher(b).matches()) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        Integer valueOf = Integer.valueOf(b);
        AbstractC3634my.f(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    public final Request a(Response response, Exchange exchange) {
        RealConnection realConnection;
        String b;
        HttpUrl.Builder builder;
        Response response2;
        Route route = (exchange == null || (realConnection = exchange.f) == null) ? null : realConnection.b;
        int i = response.d;
        String str = response.a.b;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.a.g.a(route, response);
            }
            if (i != 421) {
                if (i == 503) {
                    Response response3 = response.j;
                    if ((response3 == null || response3.d != 503) && c(response, Api.BaseClientBuilder.API_PRIORITY_OTHER) == 0) {
                        return response.a;
                    }
                } else {
                    if (i == 407) {
                        AbstractC3634my.d(route);
                        if (route.b.type() == Proxy.Type.HTTP) {
                            return this.a.m.a(route, response);
                        }
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                    if (i != 408) {
                        switch (i) {
                        }
                    } else if (this.a.f && (((response2 = response.j) == null || response2.d != 408) && c(response, 0) <= 0)) {
                        return response.a;
                    }
                }
            } else if (exchange != null && !AbstractC3634my.a(exchange.c.b.h.d, exchange.f.b.a.h.d)) {
                RealConnection realConnection2 = exchange.f;
                synchronized (realConnection2) {
                    realConnection2.k = true;
                }
                return response.a;
            }
            return null;
        }
        OkHttpClient okHttpClient = this.a;
        if (okHttpClient.h && (b = Response.b("Location", response)) != null) {
            Request request = response.a;
            HttpUrl httpUrl = request.a;
            httpUrl.getClass();
            try {
                builder = new HttpUrl.Builder();
                builder.b(httpUrl, b);
            } catch (IllegalArgumentException unused) {
                builder = null;
            }
            HttpUrl a = builder == null ? null : builder.a();
            if (a != null) {
                if (AbstractC3634my.a(a.a, request.a.a) || okHttpClient.i) {
                    Request.Builder a2 = request.a();
                    if (HttpMethod.a(str)) {
                        HttpMethod.a.getClass();
                        boolean equals = str.equals("PROPFIND");
                        int i2 = response.d;
                        boolean z = equals || i2 == 308 || i2 == 307;
                        if (str.equals("PROPFIND") || i2 == 308 || i2 == 307) {
                            a2.d(str, z ? request.d : null);
                        } else {
                            a2.d("GET", null);
                        }
                        if (!z) {
                            a2.c.c("Transfer-Encoding");
                            a2.c.c("Content-Length");
                            a2.c.c("Content-Type");
                        }
                    }
                    if (!Util.a(request.a, a)) {
                        a2.c.c("Authorization");
                    }
                    a2.a = a;
                    return a2.b();
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001d, code lost:
    
        if (r7 == false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean b(IOException iOException, RealCall realCall, Request request, boolean z) {
        boolean z2;
        RouteSelector routeSelector;
        RealConnection realConnection;
        if (!this.a.f || ((z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException))) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (iOException instanceof SocketTimeoutException) {
            }
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.h;
        AbstractC3634my.d(exchangeFinder);
        int i = exchangeFinder.g;
        if (i == 0 && exchangeFinder.h == 0 && exchangeFinder.i == 0) {
            z2 = false;
        } else {
            if (exchangeFinder.j == null) {
                Route route = null;
                if (i <= 1 && exchangeFinder.h <= 1 && exchangeFinder.i <= 0 && (realConnection = exchangeFinder.c.i) != null) {
                    synchronized (realConnection) {
                        if (realConnection.l == 0) {
                            if (Util.a(realConnection.b.a.h, exchangeFinder.b.h)) {
                                route = realConnection.b;
                            }
                        }
                    }
                }
                if (route != null) {
                    exchangeFinder.j = route;
                } else {
                    RouteSelector.Selection selection = exchangeFinder.e;
                    if ((selection == null || !selection.a()) && (routeSelector = exchangeFinder.f) != null) {
                        z2 = routeSelector.a();
                    }
                }
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0082, code lost:
    
        if (r9 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0084, code lost:
    
        r0 = r0.d();
        r4 = r9.d();
        r4.g = null;
        r4 = r4.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0095, code lost:
    
        if (r4.g != null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0097, code lost:
    
        r0.j = r4;
        r0 = r0.a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009d, code lost:
    
        r9 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ad, code lost:
    
        r4 = a(r9, r3.j);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b3, code lost:
    
        if (r4 != null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ba, code lost:
    
        r0 = r9.g;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00bc, code lost:
    
        if (r0 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c2, code lost:
    
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00c6, code lost:
    
        if (r10 > 20) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00dd, code lost:
    
        throw new java.net.ProtocolException(defpackage.AbstractC3634my.I(java.lang.Integer.valueOf(r10), "Too many follow-up requests: "));
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bf, code lost:
    
        okhttp3.internal.Util.b(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b5, code lost:
    
        r3.d(false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b9, code lost:
    
        return r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00aa, code lost:
    
        throw new java.lang.IllegalArgumentException("priorResponse.body != null");
     */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response intercept(Interceptor.Chain chain) {
        SSLSocketFactory sSLSocketFactory;
        OkHostnameVerifier okHostnameVerifier;
        CertificatePinner certificatePinner;
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.e;
        RealCall realCall = realInterceptorChain.a;
        List list = C3147go.a;
        Response response = null;
        int i = 0;
        Request request2 = request;
        while (true) {
            boolean z = true;
            while (true) {
                realCall.getClass();
                if (realCall.j != null) {
                    throw new IllegalStateException("Check failed.");
                }
                synchronized (realCall) {
                    try {
                        if (realCall.l) {
                            throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                        }
                        if (realCall.k) {
                            throw new IllegalStateException("Check failed.");
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z) {
                    RealConnectionPool realConnectionPool = realCall.c;
                    HttpUrl httpUrl = request2.a;
                    boolean z2 = httpUrl.i;
                    OkHttpClient okHttpClient = realCall.a;
                    if (z2) {
                        SSLSocketFactory sSLSocketFactory2 = okHttpClient.o;
                        if (sSLSocketFactory2 == null) {
                            throw new IllegalStateException("CLEARTEXT-only client");
                        }
                        OkHostnameVerifier okHostnameVerifier2 = okHttpClient.s;
                        certificatePinner = okHttpClient.t;
                        sSLSocketFactory = sSLSocketFactory2;
                        okHostnameVerifier = okHostnameVerifier2;
                    } else {
                        sSLSocketFactory = null;
                        okHostnameVerifier = null;
                        certificatePinner = null;
                    }
                    realCall.h = new ExchangeFinder(realConnectionPool, new Address(httpUrl.d, httpUrl.e, okHttpClient.k, okHttpClient.n, sSLSocketFactory, okHostnameVerifier, certificatePinner, okHttpClient.m, okHttpClient.r, okHttpClient.q, okHttpClient.l), realCall, realCall.d);
                }
                try {
                    if (realCall.n) {
                        throw new IOException("Canceled");
                    }
                    try {
                        Response a = realInterceptorChain.a(request2);
                        break;
                    } catch (IOException e) {
                        if (!b(e, realCall, request2, !(e instanceof ConnectionShutdownException))) {
                            Util.z(e, list);
                            throw e;
                        }
                        list = AbstractC4243ue.A0(list, e);
                        realCall.d(true);
                        z = false;
                    } catch (RouteException e2) {
                        if (!b(e2.b, realCall, request2, false)) {
                            IOException iOException = e2.a;
                            Util.z(iOException, list);
                            throw iOException;
                        }
                        list = AbstractC4243ue.A0(list, e2.a);
                        realCall.d(true);
                        z = false;
                    }
                } catch (Throwable th2) {
                    realCall.d(true);
                    throw th2;
                }
            }
            realCall.d(true);
        }
    }
}
