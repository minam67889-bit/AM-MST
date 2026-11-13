package okhttp3;

import defpackage.C3147go;
import defpackage.InterfaceC0470Rt;
import defpackage.RA;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes2.dex */
final class Handshake$peerCertificates$2 extends RA implements InterfaceC0470Rt {
    public final /* synthetic */ RA i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Handshake$peerCertificates$2(InterfaceC0470Rt interfaceC0470Rt) {
        super(0);
        this.i = (RA) interfaceC0470Rt;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [RA, Rt] */
    @Override // defpackage.InterfaceC0470Rt
    public final Object invoke() {
        try {
            return (List) this.i.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return C3147go.a;
        }
    }
}
