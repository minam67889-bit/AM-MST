package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.IPHunterActivity;

/* renamed from: xw, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnClickListenerC4500xw implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ DialogInterfaceOnClickListenerC4500xw(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                int i2 = IPHunterActivity.j;
                IPHunterActivity iPHunterActivity = (IPHunterActivity) obj;
                iPHunterActivity.getClass();
                iPHunterActivity.startActivity(new Intent("android.settings.VOICE_INPUT_SETTINGS"));
                break;
            default:
                new C2845d2((C2924e2) obj).filter(Deobfuscator$BDNETVPN$app.getString(-44138710792075L));
                break;
        }
    }
}
