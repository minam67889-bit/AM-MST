package okhttp3;

import defpackage.AbstractC4733xU;
import defpackage.AbstractC4766xx;
import defpackage.F40;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public final class Address {
    public final Dns a;
    public final SocketFactory b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final CertificatePinner e;
    public final Authenticator f;
    public final Proxy g;
    public final ProxySelector h;
    public final HttpUrl i;
    public final List j;
    public final List k;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        AbstractC4766xx.p(str, "uriHost");
        AbstractC4766xx.p(dns, "dns");
        AbstractC4766xx.p(socketFactory, "socketFactory");
        AbstractC4766xx.p(authenticator, "proxyAuthenticator");
        AbstractC4766xx.p(list, "protocols");
        AbstractC4766xx.p(list2, "connectionSpecs");
        AbstractC4766xx.p(proxySelector, "proxySelector");
        this.a = dns;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = certificatePinner;
        this.f = authenticator;
        this.g = proxy;
        this.h = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (AbstractC4733xU.k0(str2, "http", true)) {
            builder.a = "http";
        } else {
            if (!AbstractC4733xU.k0(str2, "https", true)) {
                throw new IllegalArgumentException(AbstractC4766xx.Y(str2, "unexpected scheme: "));
            }
            builder.a = "https";
        }
        String b = HostnamesKt.b(HttpUrl.Companion.e(HttpUrl.k, str, 0, 0, false, 7));
        if (b == null) {
            throw new IllegalArgumentException(AbstractC4766xx.Y(str, "unexpected host: "));
        }
        builder.d = b;
        if (1 > i || i >= 65536) {
            throw new IllegalArgumentException(AbstractC4766xx.Y(Integer.valueOf(i), "unexpected port: ").toString());
        }
        builder.e = i;
        this.i = builder.a();
        this.j = Util.v(list);
        this.k = Util.v(list2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean a(Address address) {
        AbstractC4766xx.p(address, "that");
        return AbstractC4766xx.d(this.a, address.a) && AbstractC4766xx.d(this.f, address.f) && AbstractC4766xx.d(this.j, address.j) && AbstractC4766xx.d(this.k, address.k) && AbstractC4766xx.d(this.h, address.h) && AbstractC4766xx.d(this.g, address.g) && AbstractC4766xx.d(this.c, address.c) && AbstractC4766xx.d(this.d, address.d) && AbstractC4766xx.d(this.e, address.e) && this.i.e == address.i.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            if (AbstractC4766xx.d(this.i, address.i) && a(address)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((Objects.hashCode(this.g) + ((this.h.hashCode() + ((this.k.hashCode() + ((this.j.hashCode() + ((this.f.hashCode() + ((this.a.hashCode() + ((this.i.i.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        HttpUrl httpUrl = this.i;
        sb.append(httpUrl.d);
        sb.append(':');
        sb.append(httpUrl.e);
        sb.append(", ");
        Proxy proxy = this.g;
        return F40.g(sb, proxy != null ? AbstractC4766xx.Y(proxy, "proxy=") : AbstractC4766xx.Y(this.h, "proxySelector="), '}');
    }
}
