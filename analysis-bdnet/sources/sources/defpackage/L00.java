package defpackage;

import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes2.dex */
public final /* synthetic */ class L00 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNClient b;
    public final /* synthetic */ int c;

    public /* synthetic */ L00(VPNClient vPNClient, int i, int i2) {
        this.a = i2;
        this.b = vPNClient;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                this.b.x.setSelection(this.c);
                break;
            case 1:
                this.b.x.setSelection(this.c);
                break;
            default:
                this.b.x.setSelection(this.c);
                break;
        }
    }
}
