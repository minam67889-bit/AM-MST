package defpackage;

import android.app.Dialog;
import android.content.DialogInterface;
import androidx.fragment.app.g;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: l10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnCancelListenerC3481l10 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ DialogInterfaceOnCancelListenerC3481l10(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Dialog dialog;
        Dialog dialog2;
        switch (this.a) {
            case 0:
                VPNClient vPNClient = (VPNClient) this.b;
                vPNClient.L.setChecked(false);
                vPNClient.T = Deobfuscator$BDNETVPN$app.getString(-44267559810955L);
                break;
            case 1:
                VPNClient vPNClient2 = (VPNClient) this.b;
                vPNClient2.L.setChecked(false);
                vPNClient2.T = Deobfuscator$BDNETVPN$app.getString(-44271854778251L);
                break;
            default:
                g gVar = (g) this.b;
                dialog = gVar.mDialog;
                if (dialog != null) {
                    dialog2 = gVar.mDialog;
                    gVar.onCancel(dialog2);
                    break;
                }
                break;
        }
    }
}
