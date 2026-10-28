package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import prince.dastan.vpn.tethering.ProxyService;

/* renamed from: bM, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0798bM extends BroadcastReceiver {
    public final /* synthetic */ int a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                String action = intent.getAction();
                if (action != null && action.equals(ProxyService.h) && ProxyService.g != null) {
                    ProxyService.g.a();
                    break;
                }
                break;
            default:
                if (intent.getAction() == "android.media.action.HDMI_AUDIO_PLUG") {
                    int intExtra = intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", -1);
                    if (intExtra != 0) {
                        if (intExtra == 1) {
                            M30.a = 2;
                            break;
                        }
                    } else {
                        M30.a = 1;
                        break;
                    }
                }
                break;
        }
    }
}
