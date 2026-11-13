package defpackage;

import android.content.DialogInterface;
import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes2.dex */
public final /* synthetic */ class M00 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.a) {
            case 0:
                String str = VPNClient.f0;
                dialogInterface.dismiss();
                break;
            default:
                String str2 = VPNClient.f0;
                dialogInterface.dismiss();
                break;
        }
    }
}
