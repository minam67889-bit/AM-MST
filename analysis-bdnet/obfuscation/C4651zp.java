package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.FWPuncherService;

/* renamed from: zp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C4651zp extends BroadcastReceiver {
    public final /* synthetic */ FWPuncherService a;

    public C4651zp(FWPuncherService fWPuncherService) {
        this.a = fWPuncherService;
    }

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (Deobfuscator$BDNETVPN$app.getString(-73146919909259L).equals(action)) {
                if (!intent.getBooleanExtra(Deobfuscator$BDNETVPN$app.getString(-73249999124363L), true)) {
                    this.a.i();
                }
            } else if (Deobfuscator$BDNETVPN$app.getString(-73365963241355L).equals(action)) {
                this.a.i();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
