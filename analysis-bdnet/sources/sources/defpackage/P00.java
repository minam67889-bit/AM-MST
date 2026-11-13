package defpackage;

import ads_mobile_sdk.of0;
import android.content.DialogInterface;
import java.util.concurrent.atomic.AtomicInteger;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes2.dex */
public final /* synthetic */ class P00 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ P00(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                String str = VPNClient.f0;
                VPNClient vPNClient = (VPNClient) obj;
                vPNClient.getClass();
                vPNClient.V = Deobfuscator$BDNETVPN$app.getString(-70892062078859L);
                vPNClient.N.setChecked(false);
                dialogInterface.dismiss();
                break;
            case 1:
                String str2 = VPNClient.f0;
                VPNClient vPNClient2 = (VPNClient) obj;
                vPNClient2.getClass();
                vPNClient2.U = Deobfuscator$BDNETVPN$app.getString(-70990846326667L);
                vPNClient2.M.setChecked(false);
                dialogInterface.dismiss();
                break;
            default:
                of0.a((AtomicInteger) obj, dialogInterface, i);
                break;
        }
    }
}
