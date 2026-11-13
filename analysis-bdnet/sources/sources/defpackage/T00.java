package defpackage;

import ads_mobile_sdk.fp1;
import ads_mobile_sdk.ip1;
import ads_mobile_sdk.kn1;
import ads_mobile_sdk.ln1;
import ads_mobile_sdk.lw0;
import ads_mobile_sdk.of0;
import android.content.DialogInterface;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes2.dex */
public final /* synthetic */ class T00 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ T00(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = this.c;
        Object obj2 = this.b;
        switch (this.a) {
            case 0:
                String str = VPNClient.f0;
                VPNClient vPNClient = (VPNClient) obj2;
                F00.a(vPNClient.getApplicationContext(), vPNClient.X + ((String) obj));
                SweetToast.success(vPNClient, Deobfuscator$BDNETVPN$app.getString(-72249271744395L));
                break;
            case 1:
                fp1.a((ip1) obj2, (lw0) obj, dialogInterface, i);
                break;
            case 2:
                kn1.a((ln1) obj2, (lw0) obj, dialogInterface, i);
                break;
            default:
                of0.a((of0) obj2, (String) obj, dialogInterface, i);
                break;
        }
    }
}
