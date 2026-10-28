package defpackage;

import app.vpn.amtunnellite.R;
import java.io.File;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.vpn.TunnelState;
import prince.udp.vpn.service.vpn.TunnelVpnManager;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* renamed from: Ai, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0025Ai implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ DNSLiteService b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC0025Ai(DNSLiteService dNSLiteService, int i) {
        this.a = i;
        this.b = dNSLiteService;
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
                DNSLiteService dNSLiteService = this.b;
                dNSLiteService.g();
                dNSLiteService.stopForeground(true);
                dNSLiteService.stopSelf();
                return;
            default:
                DNSLiteService dNSLiteService2 = this.b;
                synchronized (dNSLiteService2) {
                    try {
                        DNSLiteService.q = 0L;
                        dNSLiteService2.d();
                        try {
                            Thread thread = dNSLiteService2.a;
                            if (thread != null) {
                                thread.interrupt();
                                SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                            }
                            Process process = dNSLiteService2.d;
                            if (process != null) {
                                process.destroy();
                            }
                            File file = dNSLiteService2.e;
                            if (file != null) {
                                VpnUtils.killProcess(file);
                            }
                            RunnableC0207Hi runnableC0207Hi = dNSLiteService2.h;
                            if (runnableC0207Hi != null) {
                                runnableC0207Hi.b = true;
                            }
                            dNSLiteService2.d = null;
                            dNSLiteService2.e = null;
                        } catch (Exception unused) {
                        }
                        try {
                            dNSLiteService2.unregisterReceiver(dNSLiteService2.n);
                        } catch (IllegalArgumentException unused2) {
                        }
                        try {
                            dNSLiteService2.g.unregisterNetworkCallback(dNSLiteService2.m);
                        } catch (IllegalArgumentException unused3) {
                        }
                        SkStatus.removeStateListener(dNSLiteService2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                DNSLiteService dNSLiteService3 = this.b;
                synchronized (dNSLiteService3) {
                    synchronized (dNSLiteService3) {
                        TunnelState tunnelState = TunnelState.getTunnelState();
                        if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
                            SkStatus.logInfo(R.string.service_tunnel_stopping, new Object[0]);
                            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                            if (tunnelManager != null) {
                                tunnelManager.signalStopService();
                            }
                            try {
                                dNSLiteService3.unregisterReceiver(dNSLiteService3.k);
                            } catch (IllegalArgumentException unused4) {
                            }
                        }
                    }
                    Thread.sleep(1000L);
                    SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-170388478824097L), this.b.getString(R.string.state_disconnected));
                    DNSLiteService.r.i(Deobfuscator$AMTUNNELLITE$app.getString(-170392773791393L));
                    return;
                }
                Thread.sleep(1000L);
                SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-170388478824097L), this.b.getString(R.string.state_disconnected));
                DNSLiteService.r.i(Deobfuscator$AMTUNNELLITE$app.getString(-170392773791393L));
                return;
        }
    }
}
