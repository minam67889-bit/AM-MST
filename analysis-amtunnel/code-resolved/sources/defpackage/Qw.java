package defpackage;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.PDoQService;
import prince.udp.vpn.service.SuperService;

/* loaded from: classes.dex */
public final class Qw extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Service b;

    public /* synthetic */ Qw(Service service, int i) {
        this.a = i;
        this.b = service;
    }

    private final synchronized void a(Context context, Intent intent) {
        PDoQService pDoQService;
        try {
            String action = intent.getAction();
            if ("tunnelVpnStartBroadcast".equals(action)) {
                if (!intent.getBooleanExtra("tunnelVpnStartSuccessExtra", true)) {
                    pDoQService = (PDoQService) this.b;
                    pDoQService.h();
                }
            } else if ("tunnelVpnDisconnectBroadcast".equals(action)) {
                pDoQService = (PDoQService) this.b;
                pDoQService.h();
            }
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    private final synchronized void b(Context context, Intent intent) {
        SuperService superService;
        try {
            String action = intent.getAction();
            if ("tunnelVpnStartBroadcast".equals(action)) {
                if (!intent.getBooleanExtra("tunnelVpnStartSuccessExtra", true)) {
                    superService = (SuperService) this.b;
                    superService.g();
                }
            } else if ("tunnelVpnDisconnectBroadcast".equals(action)) {
                superService = (SuperService) this.b;
                superService.g();
            }
        } catch (Throwable th) {
            throw th;
        }
        throw th;
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                a(context, intent);
                return;
            default:
                b(context, intent);
                return;
        }
    }
}
