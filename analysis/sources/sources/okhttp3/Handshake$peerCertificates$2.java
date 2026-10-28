package okhttp3;

import defpackage.AbstractC0802bA;
import defpackage.C0471Rn;
import defpackage.InterfaceC4147pt;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* loaded from: classes.dex */
final class Handshake$peerCertificates$2 extends AbstractC0802bA implements InterfaceC4147pt {
    public final /* synthetic */ InterfaceC4147pt i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Handshake$peerCertificates$2(InterfaceC4147pt interfaceC4147pt) {
        super(0);
        this.i = interfaceC4147pt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4147pt
    public final Object invoke() {
        try {
            return (List) this.i.invoke();
        } catch (SSLPeerUnverifiedException unused) {
            return C0471Rn.a;
        }
    }
}
