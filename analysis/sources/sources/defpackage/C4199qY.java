package defpackage;

import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPApplication;

/* renamed from: qY, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4199qY implements H1 {
    public final /* synthetic */ InterfaceC4275rY a;
    public final /* synthetic */ C3889mW b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4199qY(C3889mW c3889mW, InterfaceC4275rY interfaceC4275rY) {
        this.b = c3889mW;
        this.a = interfaceC4275rY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.H1
    public final void a(C3993nt c3993nt) {
        C3889mW c3889mW = this.b;
        c3889mW.c = null;
        c3889mW.b = false;
        this.a.d();
        long j = ((UDPApplication) c3889mW.d).c.getLong(Deobfuscator$AMTUNNELLITE$app.getString(-149733981097633L), 0L);
        if (j == 0 || (j != 0 && System.currentTimeMillis() >= j + 3600000)) {
            c3889mW.a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.H1
    public final void b() {
        C3889mW c3889mW = this.b;
        c3889mW.c = null;
        c3889mW.b = false;
        this.a.d();
        long j = ((UDPApplication) c3889mW.d).c.getLong(Deobfuscator$AMTUNNELLITE$app.getString(-149785520705185L), 0L);
        if (j == 0 || (j != 0 && System.currentTimeMillis() >= j + 3600000)) {
            c3889mW.a();
        }
    }
}
