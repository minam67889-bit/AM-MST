package defpackage;

import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final class II implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ II(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.a) {
            case 0:
                System.exit(0);
                ((UDPClient) this.b).finish();
                return;
            case 1:
                UDPClient uDPClient = (UDPClient) this.b;
                uDPClient.getClass();
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.HOME");
                intent.setFlags(268435456);
                uDPClient.startActivity(intent);
                return;
            case 2:
                try {
                    ((ActivityManager) ((UDPClient) this.b).getSystemService("activity")).clearApplicationUserData();
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 3:
                try {
                    ((ActivityManager) ((UDPClient) this.b).getSystemService("activity")).clearApplicationUserData();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            default:
                C2481d1 c2481d1 = (C2481d1) this.b;
                c2481d1.getClass();
                new C0512c1(c2481d1).filter("");
                return;
        }
    }
}
