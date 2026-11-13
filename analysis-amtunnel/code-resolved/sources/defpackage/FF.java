package defpackage;

import android.os.Build;
import java.io.File;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes.dex */
public final class FF implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ SuperService b;

    public /* synthetic */ FF(SuperService superService, int i) {
        this.a = i;
        this.b = superService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                SuperService superService = this.b;
                superService.g();
                superService.stopForeground(true);
                superService.stopSelf();
                return;
            default:
                SuperService superService2 = this.b;
                synchronized (superService2) {
                    try {
                        SuperService.B = 0L;
                        superService2.r = false;
                        superService2.d();
                        try {
                            Thread thread = superService2.a;
                            if (thread != null) {
                                thread.interrupt();
                                SkStatus.logInfo(2131952221, new Object[0]);
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
                            File file2 = superService2.m;
                            if (file2 != null) {
                                VpnUtils.killProcess(file2);
                            }
                            Ww ww = superService2.p;
                            if (ww != null) {
                                ww.b = true;
                            }
                            File file3 = superService2.u;
                            if (file3 != null && file3.exists()) {
                                superService2.u.delete();
                            }
                            superService2.d = null;
                            superService2.f = null;
                            superService2.e = null;
                            superService2.m = null;
                        } catch (Exception unused) {
                        }
                        try {
                            superService2.unregisterReceiver(superService2.y);
                        } catch (IllegalArgumentException unused2) {
                        }
                        try {
                            if (Build.VERSION.SDK_INT >= 24) {
                                superService2.o.unregisterNetworkCallback(superService2.x);
                            }
                        } catch (IllegalArgumentException unused3) {
                        }
                        SkStatus.removeStateListener(superService2);
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
                ((UDPClient) SuperService.C).i("#ERR IndexError: list index out of range");
                return;
        }
    }
}
