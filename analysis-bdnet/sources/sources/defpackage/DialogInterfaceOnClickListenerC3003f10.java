package defpackage;

import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import dastan.prince.bdfreevpn.R;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: f10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnClickListenerC3003f10 implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNClient b;

    public /* synthetic */ DialogInterfaceOnClickListenerC3003f10(VPNClient vPNClient, int i) {
        this.a = i;
        this.b = vPNClient;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.a) {
            case 0:
                System.exit(0);
                this.b.finish();
                break;
            case 1:
                VPNClient vPNClient = this.b;
                vPNClient.getClass();
                Intent intent = new Intent(Deobfuscator$BDNETVPN$app.getString(-51367140751243L));
                intent.addCategory(Deobfuscator$BDNETVPN$app.getString(-51483104868235L));
                intent.setFlags(268435456);
                vPNClient.startActivity(intent);
                break;
            case 2:
                try {
                    ((ActivityManager) this.b.getSystemService(Deobfuscator$BDNETVPN$app.getString(-42291874854795L))).clearApplicationUserData();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 3:
                try {
                    ((ActivityManager) this.b.getSystemService(Deobfuscator$BDNETVPN$app.getString(-44143005759371L))).clearApplicationUserData();
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            case 4:
                VPNClient vPNClient2 = this.b;
                vPNClient2.l.setTextColor(-65536);
                vPNClient2.O(vPNClient2.getString(R.string.disconnected));
                vPNClient2.R();
                CountDownTimer countDownTimer = vPNClient2.C;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                if (vPNClient2.D.equals(Deobfuscator$BDNETVPN$app.getString(-44224610137995L))) {
                    vPNClient2.I = true;
                    InterfaceC3475ky interfaceC3475ky = vPNClient2.z;
                    if (interfaceC3475ky == null) {
                        vPNClient2.K();
                    } else if (!vPNClient2.E) {
                        interfaceC3475ky.show(vPNClient2);
                        vPNClient2.E = true;
                        vPNClient2.H = false;
                    }
                }
                vPNClient2.d0 = false;
                vPNClient2.H = false;
                break;
            default:
                F00.a(this.b.getApplicationContext(), VPNClient.y());
                break;
        }
    }
}
