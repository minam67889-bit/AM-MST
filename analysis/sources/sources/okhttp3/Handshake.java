package okhttp3;

import defpackage.AbstractC3411gE;
import defpackage.AbstractC3595ie;
import defpackage.AbstractC4766xx;
import defpackage.C0471Rn;
import defpackage.C3274eV;
import defpackage.InterfaceC4147pt;
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

/* loaded from: classes.dex */
public final class Handshake {
    public static final Companion e = new Companion(0);
    public final TlsVersion a;
    public final CipherSuite b;
    public final List c;
    public final C3274eV d;

    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static Handshake a(SSLSession sSLSession) {
            List list;
            Certificate[] localCertificates;
            Certificate[] peerCertificates;
            List list2 = C0471Rn.a;
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            if (AbstractC4766xx.d(cipherSuite, "TLS_NULL_WITH_NULL_NULL") ? true : AbstractC4766xx.d(cipherSuite, "SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException(AbstractC4766xx.Y(cipherSuite, "cipherSuite == "));
            }
            CipherSuite b = CipherSuite.b.b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (AbstractC4766xx.d("NONE", protocol)) {
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

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(int i) {
            this();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List list, InterfaceC4147pt interfaceC4147pt) {
        AbstractC4766xx.p(tlsVersion, "tlsVersion");
        AbstractC4766xx.p(cipherSuite, "cipherSuite");
        AbstractC4766xx.p(list, "localCertificates");
        this.a = tlsVersion;
        this.b = cipherSuite;
        this.c = list;
        this.d = AbstractC3411gE.B0(new Handshake$peerCertificates$2(interfaceC4147pt));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final List a() {
        return (List) this.d.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj instanceof Handshake) {
            Handshake handshake = (Handshake) obj;
            if (handshake.a == this.a && AbstractC4766xx.d(handshake.b, this.b) && AbstractC4766xx.d(handshake.a(), a()) && AbstractC4766xx.d(handshake.c, this.c)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.c.hashCode() + ((a().hashCode() + ((this.b.hashCode() + ((this.a.hashCode() + 527) * 31)) * 31)) * 31);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String type;
        String type2;
        List<Certificate> a = a();
        ArrayList arrayList = new ArrayList(AbstractC3595ie.W(a, 10));
        for (Certificate certificate : a) {
            if (certificate instanceof X509Certificate) {
                type2 = ((X509Certificate) certificate).getSubjectDN().toString();
            } else {
                type2 = certificate.getType();
                AbstractC4766xx.o(type2, "type");
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
        ArrayList arrayList2 = new ArrayList(AbstractC3595ie.W(list, 10));
        for (Certificate certificate2 : list) {
            if (certificate2 instanceof X509Certificate) {
                type = ((X509Certificate) certificate2).getSubjectDN().toString();
            } else {
                type = certificate2.getType();
                AbstractC4766xx.o(type, "type");
            }
            arrayList2.add(type);
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
