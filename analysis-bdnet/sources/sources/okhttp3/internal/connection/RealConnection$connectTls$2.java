package okhttp3.internal.connection;

import defpackage.AbstractC3634my;
import defpackage.AbstractC4401we;
import defpackage.InterfaceC0470Rt;
import defpackage.RA;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.Handshake;

/* loaded from: classes2.dex */
final class RealConnection$connectTls$2 extends RA implements InterfaceC0470Rt {
    public final /* synthetic */ RealConnection i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealConnection$connectTls$2(RealConnection realConnection) {
        super(0);
        this.i = realConnection;
    }

    @Override // defpackage.InterfaceC0470Rt
    public final Object invoke() {
        Handshake handshake = this.i.e;
        AbstractC3634my.d(handshake);
        List a = handshake.a();
        ArrayList arrayList = new ArrayList(AbstractC4401we.n0(a, 10));
        Iterator it = a.iterator();
        while (it.hasNext()) {
            arrayList.add((X509Certificate) ((Certificate) it.next()));
        }
        return arrayList;
    }
}
