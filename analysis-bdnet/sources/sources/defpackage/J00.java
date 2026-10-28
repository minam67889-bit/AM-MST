package defpackage;

import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNApplication;

/* loaded from: classes2.dex */
public final class J00 implements InterfaceC3649n6 {
    public final /* synthetic */ K00 a;
    public final /* synthetic */ C2963eX b;

    public J00(C2963eX c2963eX, K00 k00) {
        this.b = c2963eX;
        this.a = k00;
    }

    @Override // defpackage.M1
    public final void a(C0418Pt c0418Pt) {
        C2963eX c2963eX = this.b;
        c2963eX.c = null;
        c2963eX.b = false;
        this.a.b();
        long j = ((VPNApplication) c2963eX.d).c.getLong(Deobfuscator$BDNETVPN$app.getString(-17131956434827L), 0L);
        if (j == 0) {
            c2963eX.a();
        } else {
            if (j == 0 || System.currentTimeMillis() < j + 14400000) {
                return;
            }
            c2963eX.a();
        }
    }

    @Override // defpackage.M1
    public final void b() {
        C2963eX c2963eX = this.b;
        c2963eX.c = null;
        c2963eX.b = false;
        this.a.b();
        long j = ((VPNApplication) c2963eX.d).c.getLong(Deobfuscator$BDNETVPN$app.getString(-17080416827275L), 0L);
        if (j == 0) {
            c2963eX.a();
        } else {
            if (j == 0 || System.currentTimeMillis() < j + 14400000) {
                return;
            }
            c2963eX.a();
        }
    }
}
