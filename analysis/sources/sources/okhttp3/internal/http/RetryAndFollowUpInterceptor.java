package okhttp3.internal.http;

import ads_mobile_sdk.fh;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.api.Api;
import defpackage.AbstractC3441ge;
import defpackage.AbstractC4766xx;
import defpackage.C0471Rn;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.HostnameVerifier;
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
import okhttp3.ResponseBody;
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

/* loaded from: classes2.dex */
public final class RetryAndFollowUpInterceptor implements Interceptor {
    public final OkHttpClient a;

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
    static {
        new Companion(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RetryAndFollowUpInterceptor(OkHttpClient okHttpClient) {
        AbstractC4766xx.p(okHttpClient, "client");
        this.a = okHttpClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int c(Response response, int i) {
        String h = Response.h("Retry-After", response);
        if (h == null) {
            return i;
        }
        Pattern compile = Pattern.compile("\\d+");
        AbstractC4766xx.o(compile, "compile(...)");
        if (!compile.matcher(h).matches()) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        Integer valueOf = Integer.valueOf(h);
        AbstractC4766xx.o(valueOf, "valueOf(header)");
        return valueOf.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Request a(Response response, Exchange exchange) {
        RealConnection realConnection;
        String h;
        HttpUrl.Builder builder;
        Route route = (exchange == null || (realConnection = exchange.g) == null) ? null : realConnection.b;
        int i = response.d;
        String str = response.a.b;
        if (i != 307 && i != 308) {
            if (i == 401) {
                return this.a.g.a(route, response);
            }
            if (i == 421) {
                if (exchange == null || !(!AbstractC4766xx.d(exchange.c.b.i.d, exchange.g.b.a.i.d))) {
                    return null;
                }
                RealConnection realConnection2 = exchange.g;
                synchronized (realConnection2) {
                    realConnection2.k = true;
                }
                return response.a;
            }
            if (i == 503) {
                Response response2 = response.j;
                if ((response2 == null || response2.d != 503) && c(response, Api.BaseClientBuilder.API_PRIORITY_OTHER) == 0) {
                    return response.a;
                }
                return null;
            }
            if (i == 407) {
                AbstractC4766xx.m(route);
                if (route.b.type() == Proxy.Type.HTTP) {
                    return this.a.o.a(route, response);
                }
                throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
            }
            if (i == 408) {
                if (!this.a.f) {
                    return null;
                }
                Response response3 = response.j;
                if ((response3 == null || response3.d != 408) && c(response, 0) <= 0) {
                    return response.a;
                }
                return null;
            }
            switch (i) {
                case AdSize.MEDIUM_RECTANGLE_WIDTH /* 300 */:
                case fh.e1 /* 301 */:
                case fh.f1 /* 302 */:
                case 303:
                    break;
                default:
                    return null;
            }
        }
        OkHttpClient okHttpClient = this.a;
        if (!okHttpClient.h || (h = Response.h("Location", response)) == null) {
            return null;
        }
        Request request = response.a;
        HttpUrl httpUrl = request.a;
        httpUrl.getClass();
        try {
            builder = new HttpUrl.Builder();
            builder.b(httpUrl, h);
        } catch (IllegalArgumentException unused) {
            builder = null;
        }
        HttpUrl a = builder == null ? null : builder.a();
        if (a == null) {
            return null;
        }
        if (!AbstractC4766xx.d(a.a, request.a.a) && !okHttpClient.i) {
            return null;
        }
        Request.Builder a2 = request.a();
        if (HttpMethod.b(str)) {
            HttpMethod.a.getClass();
            boolean d = AbstractC4766xx.d(str, "PROPFIND");
            int i2 = response.d;
            boolean z = d || i2 == 308 || i2 == 307;
            if (!(true ^ AbstractC4766xx.d(str, "PROPFIND")) || i2 == 308 || i2 == 307) {
                a2.d(str, z ? request.d : null);
            } else {
                a2.d("GET", null);
            }
            if (!z) {
                a2.c.e("Transfer-Encoding");
                a2.c.e("Content-Length");
                a2.c.e("Content-Type");
            }
        }
        if (!Util.a(request.a, a)) {
            a2.c.e("Authorization");
        }
        a2.a = a;
        return a2.b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean b(IOException iOException, RealCall realCall, Request request, boolean z) {
        RouteSelector routeSelector;
        boolean a;
        RealConnection realConnection;
        if (!this.a.f) {
            return false;
        }
        if ((z && (iOException instanceof FileNotFoundException)) || (iOException instanceof ProtocolException) || (!(iOException instanceof InterruptedIOException) ? !(((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) : (iOException instanceof SocketTimeoutException) && !z)) {
            return false;
        }
        ExchangeFinder exchangeFinder = realCall.i;
        AbstractC4766xx.m(exchangeFinder);
        int i = exchangeFinder.g;
        if (i == 0 && exchangeFinder.h == 0 && exchangeFinder.i == 0) {
            a = false;
        } else {
            if (exchangeFinder.j == null) {
                Route route = null;
                if (i <= 1 && exchangeFinder.h <= 1 && exchangeFinder.i <= 0 && (realConnection = exchangeFinder.c.j) != null) {
                    synchronized (realConnection) {
                        if (realConnection.l == 0 && Util.a(realConnection.b.a.i, exchangeFinder.b.i)) {
                            route = realConnection.b;
                        }
                    }
                }
                if (route != null) {
                    exchangeFinder.j = route;
                } else {
                    RouteSelector.Selection selection = exchangeFinder.e;
                    if ((selection == null || !selection.a()) && (routeSelector = exchangeFinder.f) != null) {
                        a = routeSelector.a();
                    }
                }
            }
            a = true;
        }
        return a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Interceptor
    public final Response intercept(RealInterceptorChain realInterceptorChain) {
        List list;
        int i;
        Exchange exchange;
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        CertificatePinner certificatePinner;
        Request request = realInterceptorChain.e;
        RealCall realCall = realInterceptorChain.a;
        boolean z = true;
        List list2 = C0471Rn.a;
        Response response = null;
        int i2 = 0;
        Request request2 = request;
        boolean z2 = true;
        while (true) {
            realCall.getClass();
            AbstractC4766xx.p(request2, "request");
            if (realCall.l != null) {
                throw new IllegalStateException("Check failed.".toString());
            }
            synchronized (realCall) {
                try {
                    if (!(realCall.n ^ z)) {
                        throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString());
                    }
                    if (!(realCall.m ^ z)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (z2) {
                RealConnectionPool realConnectionPool = realCall.d;
                HttpUrl httpUrl = request2.a;
                boolean z3 = httpUrl.j;
                OkHttpClient okHttpClient = realCall.a;
                if (z3) {
                    SSLSocketFactory sSLSocketFactory2 = okHttpClient.q;
                    if (sSLSocketFactory2 == null) {
                        throw new IllegalStateException("CLEARTEXT-only client");
                    }
                    HostnameVerifier hostnameVerifier2 = okHttpClient.u;
                    certificatePinner = okHttpClient.v;
                    sSLSocketFactory = sSLSocketFactory2;
                    hostnameVerifier = hostnameVerifier2;
                } else {
                    sSLSocketFactory = null;
                    hostnameVerifier = null;
                    certificatePinner = null;
                }
                list = list2;
                i = i2;
                realCall.i = new ExchangeFinder(realConnectionPool, new Address(httpUrl.d, httpUrl.e, okHttpClient.l, okHttpClient.p, sSLSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.o, okHttpClient.m, okHttpClient.t, okHttpClient.s, okHttpClient.n), realCall, realCall.e);
            } else {
                list = list2;
                i = i2;
            }
            try {
                if (realCall.p) {
                    throw new IOException("Canceled");
                }
                try {
                    try {
                        Response b = realInterceptorChain.b(request2);
                        if (response != null) {
                            Response.Builder j = b.j();
                            Response.Builder j2 = response.j();
                            j2.g = null;
                            Response a = j2.a();
                            if (a.g != null) {
                                throw new IllegalArgumentException("priorResponse.body != null".toString());
                            }
                            j.j = a;
                            b = j.a();
                        }
                        response = b;
                        exchange = realCall.l;
                    } catch (Throwable th2) {
                        th = th2;
                        realCall.d(true);
                        throw th;
                    }
                } catch (IOException e) {
                    if (!b(e, realCall, request2, !(e instanceof ConnectionShutdownException))) {
                        Util.y(e, list);
                        throw e;
                    }
                    list2 = AbstractC3441ge.k0(list, e);
                    realCall.d(true);
                    z = true;
                    i2 = i;
                    z2 = false;
                } catch (RouteException e2) {
                    List list3 = list;
                    if (!b(e2.b, realCall, request2, false)) {
                        IOException iOException = e2.a;
                        Util.y(iOException, list3);
                        throw iOException;
                    }
                    list2 = AbstractC3441ge.k0(list3, e2.a);
                    realCall.d(true);
                    z = true;
                    z2 = false;
                    i2 = i;
                }
                try {
                    request2 = a(response, exchange);
                    if (request2 == null) {
                        if (exchange != null && exchange.e) {
                            if (!(!realCall.k)) {
                                throw new IllegalStateException("Check failed.".toString());
                            }
                            realCall.k = true;
                            realCall.f.i();
                        }
                        realCall.d(false);
                        return response;
                    }
                    ResponseBody responseBody = response.g;
                    if (responseBody != null) {
                        Util.b(responseBody);
                    }
                    i2 = i + 1;
                    if (i2 > 20) {
                        throw new ProtocolException(AbstractC4766xx.Y(Integer.valueOf(i2), "Too many follow-up requests: "));
                    }
                    realCall.d(true);
                    list2 = list;
                    z2 = true;
                    z = true;
                } catch (Throwable th3) {
                    th = th3;
                    realCall.d(true);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
    }
}
