package defpackage;

import android.os.Trace;
import android.util.Log;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.PsiphonTunnelManagerThread;
import prince.dastan.vpn.service.vpn.TunnelManagerThread;

/* renamed from: Mn, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0334Mn implements Runnable {
    public final /* synthetic */ int a;

    public /* synthetic */ RunnableC0334Mn(int i) {
        this.a = i;
    }

    private final void a() {
    }

    private final void b() {
    }

    private final void c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                try {
                    int i = MX.a;
                    Trace.beginSection("EmojiCompat.EmojiCompatInitializer.run");
                    if (C0231In.k != null) {
                        C0231In.a().c();
                    }
                    Trace.endSection();
                    return;
                } catch (Throwable th) {
                    int i2 = MX.a;
                    Trace.endSection();
                    throw th;
                }
            case 1:
            case 2:
                return;
            case 3:
                break;
            case 4:
                PsiphonTunnelManagerThread psiphonTunnelManagerThread = PsiphonDNSService.m;
                if (psiphonTunnelManagerThread != null) {
                    psiphonTunnelManagerThread.reconnectSSH();
                    return;
                }
                return;
            case 5:
                TunnelManagerThread tunnelManagerThread = SocksDNSService.E;
                if (tunnelManagerThread != null) {
                    tunnelManagerThread.reconnectSSH();
                    return;
                }
                return;
            case 6:
                return;
            default:
                TunnelManagerThread tunnelManagerThread2 = XRayDNSService.C;
                if (tunnelManagerThread2 != null) {
                    tunnelManagerThread2.reconnectSSH();
                    return;
                }
                return;
        }
        while (true) {
            try {
                Thread.sleep(500L);
            } catch (Exception e) {
                Log.i("ProxyService", e.toString());
                return;
            }
        }
    }
}
