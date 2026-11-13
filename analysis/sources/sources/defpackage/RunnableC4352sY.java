package defpackage;

import app.vpn.amtunnellite.R;
import prince.udp.vpn.activities.UDPClient;

/* renamed from: sY, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC4352sY implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ UDPClient b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC4352sY(UDPClient uDPClient, int i) {
        this.a = i;
        this.b = uDPClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                this.b.D.check(R.id.superDnsMode);
                break;
            case 1:
                this.b.D.check(R.id.udpMode);
                break;
            case 2:
                this.b.D.check(R.id.dnsliteMode);
                break;
            case 3:
                this.b.D.check(R.id.fdnsMode);
                break;
            default:
                this.b.D.check(R.id.pdrMode);
                break;
        }
    }
}
