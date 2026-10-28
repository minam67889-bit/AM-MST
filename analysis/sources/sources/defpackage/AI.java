package defpackage;

import app.vpn.amtunnellite.R;
import java.io.File;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.PDRService;
import prince.udp.vpn.service.vpn.TunnelState;
import prince.udp.vpn.service.vpn.TunnelVpnManager;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class AI implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ PDRService b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AI(PDRService pDRService, int i) {
        this.a = i;
        this.b = pDRService;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|7|30|4f|40|41|42|43|44|45) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        switch (this.a) {
            case 0:
                PDRService pDRService = this.b;
                pDRService.f();
                pDRService.stopForeground(true);
                pDRService.stopSelf();
                return;
            default:
                PDRService pDRService2 = this.b;
                synchronized (pDRService2) {
                    try {
                        PDRService.p = 0L;
                        pDRService2.c();
                        try {
                            Thread thread = pDRService2.a;
                            if (thread != null) {
                                thread.interrupt();
                                SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                            }
                            Process process = pDRService2.d;
                            if (process != null) {
                                process.destroy();
                            }
                            File file = pDRService2.e;
                            if (file != null) {
                                VpnUtils.killProcess(file);
                            }
                            RunnableC0207Hi runnableC0207Hi = pDRService2.h;
                            if (runnableC0207Hi != null) {
                                runnableC0207Hi.b = true;
                            }
                            pDRService2.d = null;
                            pDRService2.e = null;
                        } catch (Exception unused) {
                        }
                        try {
                            pDRService2.unregisterReceiver(pDRService2.m);
                        } catch (IllegalArgumentException unused2) {
                        }
                        try {
                            pDRService2.g.unregisterNetworkCallback(pDRService2.l);
                        } catch (IllegalArgumentException unused3) {
                        }
                        SkStatus.removeStateListener(pDRService2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                PDRService pDRService3 = this.b;
                synchronized (pDRService3) {
                    synchronized (pDRService3) {
                        TunnelState tunnelState = TunnelState.getTunnelState();
                        if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
                            SkStatus.logInfo(R.string.service_tunnel_stopping, new Object[0]);
                            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                            if (tunnelManager != null) {
                                tunnelManager.signalStopService();
                            }
                            try {
                                pDRService3.unregisterReceiver(pDRService3.j);
                            } catch (IllegalArgumentException unused4) {
                            }
                        }
                    }
                    Thread.sleep(1000L);
                    SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-175443655331489L), this.b.getString(R.string.state_disconnected));
                    PDRService.q.i(Deobfuscator$AMTUNNELLITE$app.getString(-175396410691233L));
                    return;
                }
                Thread.sleep(1000L);
                SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-175443655331489L), this.b.getString(R.string.state_disconnected));
                PDRService.q.i(Deobfuscator$AMTUNNELLITE$app.getString(-175396410691233L));
                return;
        }
    }
}
