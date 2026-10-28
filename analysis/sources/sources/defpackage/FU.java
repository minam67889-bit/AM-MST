package defpackage;

import app.vpn.amtunnellite.R;
import java.io.File;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.vpn.TunnelState;
import prince.udp.vpn.service.vpn.TunnelVpnManager;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class FU implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ SuperService b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ FU(SuperService superService, int i) {
        this.a = i;
        this.b = superService;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:3|7|41|72|51|52|53|54|55|56) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        switch (this.a) {
            case 0:
                SuperService superService = this.b;
                superService.f();
                superService.stopForeground(true);
                superService.stopSelf();
                return;
            default:
                SuperService superService2 = this.b;
                synchronized (superService2) {
                    try {
                        SuperService.v = 0L;
                        superService2.l = false;
                        superService2.c();
                        try {
                            Thread thread = superService2.a;
                            if (thread != null) {
                                thread.interrupt();
                                SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                            }
                            Process process = superService2.d;
                            if (process != null) {
                                process.destroy();
                            }
                            File file = superService2.e;
                            if (file != null) {
                                VpnUtils.killProcess(file);
                            }
                            Process process2 = superService2.f;
                            if (process2 != null) {
                                process2.destroy();
                            }
                            File file2 = superService2.g;
                            if (file2 != null) {
                                VpnUtils.killProcess(file2);
                            }
                            RunnableC0207Hi runnableC0207Hi = superService2.j;
                            if (runnableC0207Hi != null) {
                                runnableC0207Hi.b = true;
                            }
                            File file3 = superService2.o;
                            if (file3 != null && file3.exists()) {
                                superService2.o.delete();
                            }
                            superService2.d = null;
                            superService2.f = null;
                            superService2.e = null;
                            superService2.g = null;
                        } catch (Exception unused) {
                        }
                        try {
                            superService2.unregisterReceiver(superService2.s);
                        } catch (IllegalArgumentException unused2) {
                        }
                        try {
                            superService2.i.unregisterNetworkCallback(superService2.r);
                        } catch (IllegalArgumentException unused3) {
                        }
                        SkStatus.removeStateListener(superService2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                SuperService superService3 = this.b;
                synchronized (superService3) {
                    synchronized (superService3) {
                        TunnelState tunnelState = TunnelState.getTunnelState();
                        if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
                            SkStatus.logInfo(R.string.service_tunnel_stopping, new Object[0]);
                            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                            if (tunnelManager != null) {
                                tunnelManager.signalStopService();
                            }
                            try {
                                superService3.unregisterReceiver(superService3.p);
                            } catch (IllegalArgumentException unused4) {
                            }
                        }
                    }
                    Thread.sleep(1000L);
                    SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-163031199846049L), this.b.getString(R.string.state_disconnected));
                    SuperService.w.i(Deobfuscator$AMTUNNELLITE$app.getString(-163052674682529L));
                    return;
                }
                Thread.sleep(1000L);
                SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-163031199846049L), this.b.getString(R.string.state_disconnected));
                SuperService.w.i(Deobfuscator$AMTUNNELLITE$app.getString(-163052674682529L));
                return;
        }
    }
}
