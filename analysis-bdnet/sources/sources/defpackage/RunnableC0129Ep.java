package defpackage;

import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;

/* renamed from: Ep, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0129Ep implements Runnable {
    public final /* synthetic */ int a;
    public boolean b;

    public /* synthetic */ RunnableC0129Ep(int i) {
        this.a = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                while (!this.b) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused) {
                    }
                    VPNClient vPNClient = FWPuncherService.s;
                    if (vPNClient != null) {
                        vPNClient.runOnUiThread(new RunnableC3243i10(vPNClient, 4));
                    }
                }
                break;
            case 1:
                while (!this.b) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused2) {
                    }
                    VPNClient vPNClient2 = PsiphonDNSService.n;
                    if (vPNClient2 != null) {
                        vPNClient2.runOnUiThread(new RunnableC3243i10(vPNClient2, 4));
                    }
                }
                break;
            case 2:
                while (!this.b) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused3) {
                    }
                    VPNClient vPNClient3 = SocksDNSService.H;
                    if (vPNClient3 != null) {
                        vPNClient3.runOnUiThread(new RunnableC3243i10(vPNClient3, 4));
                    }
                }
                break;
            default:
                while (!this.b) {
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException unused4) {
                    }
                    VPNClient vPNClient4 = XRayDNSService.F;
                    if (vPNClient4 != null) {
                        vPNClient4.runOnUiThread(new RunnableC3243i10(vPNClient4, 4));
                    }
                }
                break;
        }
    }
}
