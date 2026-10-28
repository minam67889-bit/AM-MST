package okhttp3.internal.authenticator;

import defpackage.AbstractC3634my;
import defpackage.AbstractC4243ue;
import defpackage.C0451Ra;
import defpackage.C3147go;
import defpackage.C4316vb;
import java.io.EOFException;
import java.net.Authenticator;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Authenticator;
import okhttp3.Challenge;
import okhttp3.Credentials;
import okhttp3.Dns;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;

/* loaded from: classes2.dex */
public final class JavaNetAuthenticator implements Authenticator {
    public final Dns b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            a = iArr;
        }
    }

    public JavaNetAuthenticator() {
        this(0);
    }

    public static InetAddress b(Proxy proxy, HttpUrl httpUrl, Dns dns) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : WhenMappings.a[type.ordinal()]) == 1) {
            return (InetAddress) AbstractC4243ue.s0(dns.a(httpUrl.d));
        }
        SocketAddress address = proxy.address();
        if (address == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        AbstractC3634my.f(address2, "address() as InetSocketAddress).address");
        return address2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x006b  */
    @Override // okhttp3.Authenticator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Request a(Route route, Response response) {
        String str;
        List<Challenge> list;
        Proxy proxy;
        PasswordAuthentication requestPasswordAuthentication;
        Charset forName;
        AbstractC3634my.g(response, "response");
        Headers headers = response.f;
        int i = response.d;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                list = C3147go.a;
                Request request = response.a;
                HttpUrl httpUrl = request.a;
                boolean z = response.d == 407;
                proxy = route != null ? null : route.b;
                if (proxy == null) {
                    proxy = Proxy.NO_PROXY;
                }
                for (Challenge challenge : list) {
                    if ("Basic".equalsIgnoreCase(challenge.a)) {
                        Dns dns = route == null ? null : route.a.a;
                        if (dns == null) {
                            dns = this.b;
                        }
                        if (z) {
                            SocketAddress address = proxy.address();
                            if (address == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                            }
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                            try {
                                requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), b(proxy, httpUrl, dns), inetSocketAddress.getPort(), httpUrl.a, (String) challenge.b.get("realm"), challenge.a, new URL(httpUrl.h), Authenticator.RequestorType.PROXY);
                            } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            String str2 = httpUrl.d;
                            AbstractC3634my.f(proxy, "proxy");
                            try {
                                requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(str2, b(proxy, httpUrl, dns), httpUrl.e, httpUrl.a, (String) challenge.b.get("realm"), challenge.a, new URL(httpUrl.h), Authenticator.RequestorType.SERVER);
                            } catch (MalformedURLException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        if (requestPasswordAuthentication != null) {
                            String str3 = z ? "Proxy-Authorization" : "Authorization";
                            String userName = requestPasswordAuthentication.getUserName();
                            AbstractC3634my.f(userName, "auth.userName");
                            char[] password = requestPasswordAuthentication.getPassword();
                            AbstractC3634my.f(password, "auth.password");
                            String str4 = new String(password);
                            String str5 = (String) challenge.b.get("charset");
                            if (str5 != null) {
                                try {
                                    forName = Charset.forName(str5);
                                    AbstractC3634my.f(forName, "forName(charset)");
                                } catch (Exception unused) {
                                }
                                int i2 = Credentials.a;
                                String str6 = userName + ':' + str4;
                                C4316vb c4316vb = C4316vb.d;
                                AbstractC3634my.g(str6, "<this>");
                                byte[] bytes = str6.getBytes(forName);
                                AbstractC3634my.f(bytes, "this as java.lang.String).getBytes(charset)");
                                String I = AbstractC3634my.I(new C4316vb(bytes).a(), "Basic ");
                                Request.Builder a = request.a();
                                a.c(str3, I);
                                return a.b();
                            }
                            forName = StandardCharsets.ISO_8859_1;
                            AbstractC3634my.f(forName, "ISO_8859_1");
                            int i22 = Credentials.a;
                            String str62 = userName + ':' + str4;
                            C4316vb c4316vb2 = C4316vb.d;
                            AbstractC3634my.g(str62, "<this>");
                            byte[] bytes2 = str62.getBytes(forName);
                            AbstractC3634my.f(bytes2, "this as java.lang.String).getBytes(charset)");
                            String I2 = AbstractC3634my.I(new C4316vb(bytes2).a(), "Basic ");
                            Request.Builder a2 = request.a();
                            a2.c(str3, I2);
                            return a2.b();
                        }
                    }
                }
                return null;
            }
            str = "Proxy-Authenticate";
        }
        String str7 = str;
        C4316vb c4316vb3 = HttpHeaders.a;
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            if (str7.equalsIgnoreCase(headers.b(i3))) {
                C0451Ra c0451Ra = new C0451Ra();
                c0451Ra.C(headers.d(i3));
                try {
                    HttpHeaders.b(c0451Ra, arrayList);
                } catch (EOFException e3) {
                    Platform.a.getClass();
                    Platform.b.getClass();
                    Platform.i(5, "Unable to parse challenge", e3);
                }
            }
            i3 = i4;
        }
        list = arrayList;
        Request request2 = response.a;
        HttpUrl httpUrl2 = request2.a;
        if (response.d == 407) {
        }
        if (route != null) {
        }
        if (proxy == null) {
        }
        while (r0.hasNext()) {
        }
        return null;
    }

    public JavaNetAuthenticator(int i) {
        Dns dns = Dns.a;
        AbstractC3634my.g(dns, "defaultDns");
        this.b = dns;
    }
}
