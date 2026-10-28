package defpackage;

import android.content.DialogInterface;
import android.widget.Spinner;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: m10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnClickListenerC3561m10 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Spinner a;
    public final /* synthetic */ String[] b;
    public final /* synthetic */ VPNClient c;

    public DialogInterfaceOnClickListenerC3561m10(VPNClient vPNClient, Spinner spinner, String[] strArr) {
        this.c = vPNClient;
        this.a = spinner;
        this.b = strArr;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        int selectedItemPosition = this.a.getSelectedItemPosition();
        String str = this.b[selectedItemPosition];
        VPNClient vPNClient = this.c;
        ZT.q(-162258901366667L, vPNClient.m.b, str);
        QQ qq = vPNClient.m.b;
        qq.putInt(Deobfuscator$BDNETVPN$app.getString(-162465059796875L), selectedItemPosition);
        qq.apply();
    }
}
