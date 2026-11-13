package okhttp3;

import defpackage.AbstractC3634my;
import defpackage.AbstractC4401we;
import defpackage.C3147go;
import defpackage.InterfaceC0470Rt;
import defpackage.W80;
import defpackage.YV;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.TlsVersion;
import okhttp3.internal.Util;

/* loaded from: classes2.dex */
public final class Handshake {
    public static final Companion e = new Companion(0);
    public final TlsVersion a;
    public final CipherSuite b;
    public final List c;
    public final YV d;

    public static final class Companion {
        public /* synthetic */ Companion(int i) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Handshake a(SSLSession sSLSession) {
            List list;
            Certificate[] localCertificates;
            Certificate[] peerCertificates;
            List list2 = C3147go.a;
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null");
            }
            if (cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") ? true : cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(AbstractC3634my.I(cipherSuite, "cipherSuite == "));
            }
            CipherSuite b = CipherSuite.b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            }
            if ("NONE".equals(protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            TlsVersion.b.getClass();
            TlsVersion a = TlsVersion.Companion.a(protocol);
            try {
                peerCertificates = sSLSession.getPeerCertificates();
            } catch (SSLPeerUnverifiedException unused) {
            }
            if (peerCertificates != null) {
                list = Util.j(Arrays.copyOf(peerCertificates, peerCertificates.length));
                localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = Util.j(Arrays.copyOf(localCertificates, localCertificates.length));
                }
                return new Handshake(a, b, list2, new Handshake$Companion$handshake$1(list));
            }
            list = list2;
            localCertificates = sSLSession.getLocalCertificates();
            if (localCertificates != null) {
            }
            return new Handshake(a, b, list2, new Handshake$Companion$handshake$1(list));
        }

        private Companion() {
        }
    }

    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, InterfaceC0470Rt interfaceC0470Rt) {
        this.a = tlsVersion;
        this.b = cipherSuite;
        this.c = list;
        this.d = W80.N(new Handshake$peerCertificates$2(interfaceC0470Rt));
    }

    public final List a() {
        return (List) this.d.getValue();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        return handshake.a == this.a && AbstractC3634my.a(handshake.b, this.b) && AbstractC3634my.a(handshake.a(), a()) && AbstractC3634my.a(handshake.c, this.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((a().hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    public final String toString() {
        String type;
        String type2;
        List<Certificate> a = a();
        ArrayList arrayList = new ArrayList(AbstractC4401we.n0(a, 10));
        for (Certificate certificate : a) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                AbstractC3634my.f(type2, "type");
            }
            arrayList.add(type2);
        }
        String obj = arrayList.toString();
        StringBuilder sb = new StringBuilder("Handshake{tlsVersion=");
        sb.append(this.a);
        sb.append(" cipherSuite=");
        sb.append(this.b);
        sb.append(" peerCertificates=");
        sb.append(obj);
        sb.append(" localCertificates=");
        List<Certificate> list = this.c;
        ArrayList arrayList2 = new ArrayList(AbstractC4401we.n0(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                AbstractC3634my.f(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
