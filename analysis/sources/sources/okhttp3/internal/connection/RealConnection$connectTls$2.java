package okhttp3.internal.connection;

import defpackage.AbstractC0802bA;
import defpackage.AbstractC3595ie;
import defpackage.AbstractC4766xx;
import defpackage.InterfaceC4147pt;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Handshake;

/* loaded from: classes.dex */
final class RealConnection$connectTls$2 extends AbstractC0802bA implements InterfaceC4147pt {
    public final /* synthetic */ RealConnection i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RealConnection$connectTls$2(RealConnection realConnection) {
        super(0);
        this.i = realConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4147pt
    public final Object invoke() {
        Handshake handshake = this.i.e;
        AbstractC4766xx.m(handshake);
        List a = handshake.a();
        ArrayList arrayList = new ArrayList(AbstractC3595ie.W(a, 10));
        Iterator it = a.iterator();
        while (it.hasNext()) {
            arrayList.add((X509Certificate) ((Certificate) it.next()));
        }
        return arrayList;
    }
}
