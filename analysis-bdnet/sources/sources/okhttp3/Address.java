package okhttp3;

import defpackage.AbstractC3634my;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class Address {
    public final Dns a;
    public final SocketFactory b;
    public final SSLSocketFactory c;
    public final HostnameVerifier d;
    public final CertificatePinner e;
    public final Authenticator f;
    public final ProxySelector g;
    public final HttpUrl h;
    public final List i;
    public final List j;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, List list, List list2, ProxySelector proxySelector) {
        AbstractC3634my.g(str, "uriHost");
        AbstractC3634my.g(dns, "dns");
        AbstractC3634my.g(socketFactory, "socketFactory");
        AbstractC3634my.g(authenticator, "proxyAuthenticator");
        AbstractC3634my.g(list, "protocols");
        AbstractC3634my.g(list2, "connectionSpecs");
        AbstractC3634my.g(proxySelector, "proxySelector");
        this.a = dns;
        this.b = socketFactory;
        this.c = sSLSocketFactory;
        this.d = hostnameVerifier;
        this.e = certificatePinner;
        this.f = authenticator;
        this.g = proxySelector;
        HttpUrl.Builder builder = new HttpUrl.Builder();
        String str2 = sSLSocketFactory != null ? "https" : "http";
        if (str2.equalsIgnoreCase("http")) {
            builder.a = "http";
        } else {
            if (!str2.equalsIgnoreCase("https")) {
                throw new IllegalArgumentException(AbstractC3634my.I(str2, "unexpected scheme: "));
            }
            builder.a = "https";
        }
        String b = HostnamesKt.b(HttpUrl.Companion.e(HttpUrl.j, str, 0, 0, 7));
        if (b == null) {
            throw new IllegalArgumentException(AbstractC3634my.I(str, "unexpected host: "));
        }
        builder.d = b;
        if (1 > i || i >= 65536) {
            throw new IllegalArgumentException(AbstractC3634my.I(Integer.valueOf(i), "unexpected port: ").toString());
        }
        builder.e = i;
        this.h = builder.a();
        this.i = Util.w(list);
        this.j = Util.w(list2);
    }

    public final boolean a(Address address) {
        AbstractC3634my.g(address, "that");
        return AbstractC3634my.a(this.a, address.a) && AbstractC3634my.a(this.f, address.f) && AbstractC3634my.a(this.i, address.i) && AbstractC3634my.a(this.j, address.j) && AbstractC3634my.a(this.g, address.g) && AbstractC3634my.a(this.c, address.c) && AbstractC3634my.a(this.d, address.d) && AbstractC3634my.a(this.e, address.e) && this.h.e == address.h.e;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return AbstractC3634my.a(this.h, address.h) && a(address);
    }

    public final int hashCode() {
        return Objects.hashCode(this.e) + ((Objects.hashCode(this.d) + ((Objects.hashCode(this.c) + ((this.g.hashCode() + ((this.j.hashCode() + ((this.i.hashCode() + ((this.f.hashCode() + ((this.a.hashCode() + ((this.h.h.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 961)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Address{");
        HttpUrl httpUrl = this.h;
        sb.append(httpUrl.d);
        sb.append(':');
        sb.append(httpUrl.e);
        sb.append(", ");
        sb.append(AbstractC3634my.I(this.g, "proxySelector="));
        sb.append('}');
        return sb.toString();
    }
}
