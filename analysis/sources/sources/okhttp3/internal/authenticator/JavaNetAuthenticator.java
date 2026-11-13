package okhttp3.internal.authenticator;

import defpackage.AbstractC3441ge;
import defpackage.AbstractC4733xU;
import defpackage.AbstractC4766xx;
import defpackage.C0017Aa;
import defpackage.C0471Rn;
import defpackage.C3512hb;
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
import okhttp3.Address;
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

/* loaded from: classes.dex */
public final class JavaNetAuthenticator implements Authenticator {
    public final Dns b;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] a;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Proxy.Type.values().length];
            iArr[Proxy.Type.DIRECT.ordinal()] = 1;
            a = iArr;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JavaNetAuthenticator() {
        this(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static InetAddress b(Proxy proxy, HttpUrl httpUrl, Dns dns) {
        Proxy.Type type = proxy.type();
        if ((type == null ? -1 : WhenMappings.a[type.ordinal()]) == 1) {
            return (InetAddress) AbstractC3441ge.c0(dns.a(httpUrl.d));
        }
        SocketAddress address = proxy.address();
        if (address == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
        }
        InetAddress address2 = ((InetSocketAddress) address).getAddress();
        AbstractC4766xx.o(address2, "address() as InetSocketAddress).address");
        return address2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0070  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Authenticator
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Request a(Route route, Response response) {
        String str;
        List<Challenge> list;
        Proxy proxy;
        Address address;
        PasswordAuthentication requestPasswordAuthentication;
        Charset forName;
        boolean z = true;
        AbstractC4766xx.p(response, "response");
        Headers headers = response.f;
        int i = response.d;
        if (i == 401) {
            str = "WWW-Authenticate";
        } else {
            if (i != 407) {
                list = C0471Rn.a;
                Request request = response.a;
                HttpUrl httpUrl = request.a;
                boolean z2 = response.d == 407;
                proxy = route != null ? null : route.b;
                if (proxy == null) {
                    proxy = Proxy.NO_PROXY;
                }
                for (Challenge challenge : list) {
                    if (AbstractC4733xU.k0("Basic", challenge.a, z)) {
                        Dns dns = (route == null || (address = route.a) == null) ? null : address.a;
                        if (dns == null) {
                            dns = this.b;
                        }
                        if (z2) {
                            SocketAddress address2 = proxy.address();
                            if (address2 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type java.net.InetSocketAddress");
                            }
                            InetSocketAddress inetSocketAddress = (InetSocketAddress) address2;
                            try {
                                requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(inetSocketAddress.getHostName(), b(proxy, httpUrl, dns), inetSocketAddress.getPort(), httpUrl.a, (String) challenge.b.get("realm"), challenge.a, new URL(httpUrl.i), Authenticator.RequestorType.PROXY);
                            } catch (MalformedURLException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            String str2 = httpUrl.d;
                            AbstractC4766xx.o(proxy, "proxy");
                            try {
                                requestPasswordAuthentication = java.net.Authenticator.requestPasswordAuthentication(str2, b(proxy, httpUrl, dns), httpUrl.e, httpUrl.a, (String) challenge.b.get("realm"), challenge.a, new URL(httpUrl.i), Authenticator.RequestorType.SERVER);
                            } catch (MalformedURLException e2) {
                                throw new RuntimeException(e2);
                            }
                        }
                        if (requestPasswordAuthentication != null) {
                            String str3 = z2 ? "Proxy-Authorization" : "Authorization";
                            String userName = requestPasswordAuthentication.getUserName();
                            AbstractC4766xx.o(userName, "auth.userName");
                            char[] password = requestPasswordAuthentication.getPassword();
                            AbstractC4766xx.o(password, "auth.password");
                            String str4 = new String(password);
                            String str5 = (String) challenge.b.get("charset");
                            if (str5 != null) {
                                try {
                                    forName = Charset.forName(str5);
                                    AbstractC4766xx.o(forName, "forName(charset)");
                                } catch (Exception unused) {
                                }
                                int i2 = Credentials.a;
                                String str6 = userName + ':' + str4;
                                C3512hb c3512hb = C3512hb.d;
                                AbstractC4766xx.p(str6, "<this>");
                                byte[] bytes = str6.getBytes(forName);
                                AbstractC4766xx.o(bytes, "this as java.lang.String).getBytes(charset)");
                                String Y = AbstractC4766xx.Y(new C3512hb(bytes).a(), "Basic ");
                                Request.Builder a = request.a();
                                a.c(str3, Y);
                                return a.b();
                            }
                            forName = StandardCharsets.ISO_8859_1;
                            AbstractC4766xx.o(forName, "ISO_8859_1");
                            int i22 = Credentials.a;
                            String str62 = userName + ':' + str4;
                            C3512hb c3512hb2 = C3512hb.d;
                            AbstractC4766xx.p(str62, "<this>");
                            byte[] bytes2 = str62.getBytes(forName);
                            AbstractC4766xx.o(bytes2, "this as java.lang.String).getBytes(charset)");
                            String Y2 = AbstractC4766xx.Y(new C3512hb(bytes2).a(), "Basic ");
                            Request.Builder a2 = request.a();
                            a2.c(str3, Y2);
                            return a2.b();
                        }
                        z = true;
                    }
                }
                return null;
            }
            str = "Proxy-Authenticate";
        }
        String str7 = str;
        C3512hb c3512hb3 = HttpHeaders.a;
        AbstractC4766xx.p(headers, "<this>");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        int i3 = 0;
        while (i3 < size) {
            int i4 = i3 + 1;
            if (AbstractC4733xU.k0(str7, headers.b(i3), true)) {
                C0017Aa c0017Aa = new C0017Aa();
                c0017Aa.S(headers.d(i3));
                try {
                    HttpHeaders.b(c0017Aa, arrayList);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JavaNetAuthenticator(int i) {
        Dns dns = Dns.a;
        AbstractC4766xx.p(dns, "defaultDns");
        this.b = dns;
    }
}
