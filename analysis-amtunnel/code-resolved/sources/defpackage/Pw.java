package defpackage;

import android.os.Build;
import java.io.File;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.PDoQService;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes.dex */
public final class Pw implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ PDoQService b;

    public /* synthetic */ Pw(PDoQService pDoQService, int i) {
        this.a = i;
        this.b = pDoQService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                PDoQService pDoQService = this.b;
                pDoQService.h();
                pDoQService.stopForeground(true);
                pDoQService.stopSelf();
                return;
            default:
                PDoQService pDoQService2 = this.b;
                synchronized (pDoQService2) {
                    try {
                        PDoQService.y = 0L;
                        pDoQService2.r = false;
                        pDoQService2.e();
                        try {
                            Thread thread = pDoQService2.a;
                            if (thread != null) {
                                thread.interrupt();
                                SkStatus.logInfo(2131952221, new Object[0]);
                            }
                            Process process = pDoQService2.d;
                            if (process != null) {
                                process.destroy();
                            }
                            File file = pDoQService2.e;
                            if (file != null) {
                                VpnUtils.killProcess(file);
                            }
                            Process process2 = pDoQService2.f;
                            if (process2 != null) {
                                process2.destroy();
                            }
                            File file2 = pDoQService2.m;
                            if (file2 != null) {
                                VpnUtils.killProcess(file2);
                            }
                            Ww ww = pDoQService2.p;
                            if (ww != null) {
                                ww.b = true;
                            }
                            pDoQService2.d = null;
                            pDoQService2.f = null;
                            pDoQService2.e = null;
                            pDoQService2.m = null;
                        } catch (Exception unused) {
                        }
                        try {
                            pDoQService2.unregisterReceiver(pDoQService2.v);
                        } catch (IllegalArgumentException unused2) {
                        }
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                pDoQService2.o.unregisterNetworkCallback(pDoQService2.u);
                            }
                        } catch (IllegalArgumentException unused3) {
                        }
                        SkStatus.removeStateListener(pDoQService2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                this.b.a();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused4) {
                }
                SkStatus.updateStateString("#ERR IndexError: list index out of range", this.b.getString(2131952180));
                ((UDPClient) PDoQService.z).i("#ERR IndexError: list index out of range");
                return;
        }
    }
}
