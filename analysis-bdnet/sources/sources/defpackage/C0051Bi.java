package defpackage;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.PDRService;
import prince.udp.vpn.service.SuperService;

/* renamed from: Bi, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0051Bi extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Service b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ C0051Bi(Service service, int i) {
        this.a = i;
        this.b = service;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        DNSLiteService dNSLiteService;
        PDRService pDRService;
        SuperService superService;
        switch (this.a) {
            case 0:
                synchronized (this) {
                    try {
                        String action = intent.getAction();
                        if (Deobfuscator$AMTUNNELLITE$app.getString(-169632564580001L).equals(action)) {
                            if (!intent.getBooleanExtra(Deobfuscator$AMTUNNELLITE$app.getString(-170147960655521L), true)) {
                                dNSLiteService = (DNSLiteService) this.b;
                                dNSLiteService.g();
                            }
                        } else if (Deobfuscator$AMTUNNELLITE$app.getString(-169954687127201L).equals(action)) {
                            dNSLiteService = this.b;
                            dNSLiteService.g();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                    throw th;
                }
                return;
            case 1:
                synchronized (this) {
                    try {
                        String action2 = intent.getAction();
                        if (Deobfuscator$AMTUNNELLITE$app.getString(-175237496901281L).equals(action2)) {
                            if (!intent.getBooleanExtra(Deobfuscator$AMTUNNELLITE$app.getString(-175203137162913L), true)) {
                                pDRService = (PDRService) this.b;
                                pDRService.f();
                            }
                        } else if (Deobfuscator$AMTUNNELLITE$app.getString(-175645518794401L).equals(action2)) {
                            pDRService = this.b;
                            pDRService.f();
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                    throw th2;
                }
                return;
            default:
                synchronized (this) {
                    try {
                        String action3 = intent.getAction();
                        if (Deobfuscator$AMTUNNELLITE$app.getString(-162825041415841L).equals(action3)) {
                            if (!intent.getBooleanExtra(Deobfuscator$AMTUNNELLITE$app.getString(-162790681677473L), true)) {
                                superService = (SuperService) this.b;
                                superService.f();
                            }
                        } else if (Deobfuscator$AMTUNNELLITE$app.getString(-163164343832225L).equals(action3)) {
                            superService = this.b;
                            superService.f();
                        }
                    } finally {
                    }
                }
                return;
        }
    }
}
