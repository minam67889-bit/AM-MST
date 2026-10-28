package defpackage;

import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.PDRService;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.WGService;

/* renamed from: Hi, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0207Hi implements Runnable {
    public final /* synthetic */ int a;
    public boolean b;
    public long c;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                while (!this.b) {
                    try {
                        Thread.sleep(this.c);
                    } catch (InterruptedException unused) {
                    }
                    UDPClient uDPClient = DNSLiteService.s;
                    if (uDPClient != null) {
                        UDPClient uDPClient2 = uDPClient;
                        uDPClient2.runOnUiThread(new GY(uDPClient2, 3));
                    }
                }
                break;
            case 1:
                while (!this.b) {
                    try {
                        Thread.sleep(this.c);
                    } catch (InterruptedException unused2) {
                    }
                    UDPClient uDPClient3 = PDRService.r;
                    if (uDPClient3 != null) {
                        UDPClient uDPClient4 = uDPClient3;
                        uDPClient4.runOnUiThread(new GY(uDPClient4, 3));
                    }
                }
                break;
            case 2:
                while (!this.b) {
                    try {
                        Thread.sleep(this.c);
                    } catch (InterruptedException unused3) {
                    }
                    UDPClient uDPClient5 = SocksDNSService.o;
                    if (uDPClient5 != null) {
                        UDPClient uDPClient6 = uDPClient5;
                        uDPClient6.runOnUiThread(new GY(uDPClient6, 3));
                    }
                }
                break;
            case 3:
                while (!this.b) {
                    try {
                        Thread.sleep(this.c);
                    } catch (InterruptedException unused4) {
                    }
                    UDPClient uDPClient7 = SuperService.x;
                    if (uDPClient7 != null) {
                        UDPClient uDPClient8 = uDPClient7;
                        uDPClient8.runOnUiThread(new GY(uDPClient8, 3));
                    }
                }
                break;
            default:
                while (!this.b) {
                    try {
                        Thread.sleep(this.c);
                    } catch (InterruptedException unused5) {
                    }
                    UDPClient uDPClient9 = WGService.n;
                    if (uDPClient9 != null) {
                        UDPClient uDPClient10 = uDPClient9;
                        uDPClient10.runOnUiThread(new GY(uDPClient10, 3));
                    }
                }
                break;
        }
    }
}
