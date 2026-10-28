package okhttp3.internal.connection;

import defpackage.AbstractC3634my;
import defpackage.InterfaceC0470Rt;
import defpackage.RA;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: classes2.dex */
final class RealConnection$connectTls$1 extends RA implements InterfaceC0470Rt {
    public final /* synthetic */ CertificatePinner i;
    public final /* synthetic */ Handshake j;
    public final /* synthetic */ Address k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        super(0);
        this.i = certificatePinner;
        this.j = handshake;
        this.k = address;
    }

    @Override // defpackage.InterfaceC0470Rt
    public final Object invoke() {
        CertificateChainCleaner certificateChainCleaner = this.i.b;
        AbstractC3634my.d(certificateChainCleaner);
        return certificateChainCleaner.a(this.k.h.d, this.j.a());
    }
}
