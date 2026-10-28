package okhttp3.internal.connection;

import defpackage.AbstractC0802bA;
import defpackage.AbstractC4766xx;
import defpackage.InterfaceC4147pt;
import okhttp3.Address;
import okhttp3.CertificatePinner;
import okhttp3.Handshake;
import okhttp3.internal.tls.CertificateChainCleaner;

/* loaded from: classes.dex */
final class RealConnection$connectTls$1 extends AbstractC0802bA implements InterfaceC4147pt {
    public final /* synthetic */ CertificatePinner i;
    public final /* synthetic */ Handshake j;
    public final /* synthetic */ Address k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RealConnection$connectTls$1(CertificatePinner certificatePinner, Handshake handshake, Address address) {
        super(0);
        this.i = certificatePinner;
        this.j = handshake;
        this.k = address;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4147pt
    public final Object invoke() {
        CertificateChainCleaner certificateChainCleaner = this.i.b;
        AbstractC4766xx.m(certificateChainCleaner);
        return certificateChainCleaner.a(this.k.i.d, this.j.a());
    }
}
