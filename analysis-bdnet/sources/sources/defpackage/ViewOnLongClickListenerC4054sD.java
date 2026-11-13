package defpackage;

import android.view.View;
import android.widget.Toast;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: sD, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnLongClickListenerC4054sD implements View.OnLongClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ ViewOnTouchListenerC4212uD b;

    public ViewOnLongClickListenerC4054sD(ViewOnTouchListenerC4212uD viewOnTouchListenerC4212uD, int i, String str) {
        this.b = viewOnTouchListenerC4212uD;
        this.a = str;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        C0910cm c0910cm = this.b.h;
        if (c0910cm == null) {
            return true;
        }
        String str = this.a;
        VPNClient vPNClient = c0910cm.a;
        try {
            F00.a(vPNClient, str);
            return true;
        } catch (Exception e) {
            SkStatus.logException("Error copying log", e);
            Toast.makeText(vPNClient, "Could not copy log!", 0).show();
            return true;
        }
    }
}
