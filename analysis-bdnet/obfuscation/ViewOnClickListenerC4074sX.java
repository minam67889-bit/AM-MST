package defpackage;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: sX, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC4074sX implements View.OnClickListener {
    public final /* synthetic */ int a = 1;
    public final Object b;
    public final /* synthetic */ Object c;

    public ViewOnClickListenerC4074sX(C4232uX c4232uX) {
        this.c = c4232uX;
        Context context = c4232uX.a.getContext();
        CharSequence charSequence = c4232uX.h;
        C2922e1 c2922e1 = new C2922e1();
        c2922e1.e = 4096;
        c2922e1.g = 4096;
        c2922e1.l = null;
        c2922e1.m = null;
        c2922e1.n = false;
        c2922e1.o = false;
        c2922e1.p = 16;
        c2922e1.i = context;
        c2922e1.a = charSequence;
        this.b = c2922e1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.a) {
            case 0:
                C4232uX c4232uX = (C4232uX) this.c;
                Window.Callback callback = c4232uX.k;
                if (callback != null && c4232uX.l) {
                    callback.onMenuItemSelected(0, (C2922e1) this.b);
                    break;
                }
                break;
            default:
                Intent intent = new Intent(Deobfuscator$BDNETVPN$app.getString(-40994794731403L));
                intent.setType(Deobfuscator$BDNETVPN$app.getString(-41140823619467L));
                intent.addCategory(Deobfuscator$BDNETVPN$app.getString(-41158003488651L));
                ((VPNClient) this.c).startActivityForResult(intent, 1001);
                ((V3) this.b).dismiss();
                break;
        }
    }

    public ViewOnClickListenerC4074sX(VPNClient vPNClient, V3 v3) {
        this.c = vPNClient;
        this.b = v3;
    }
}
