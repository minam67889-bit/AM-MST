package defpackage;

import android.app.ActivityManager;
import android.content.DialogInterface;
import android.content.Intent;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes2.dex */
public final class CY implements DialogInterface.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ CY(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.a) {
            case 0:
                System.exit(0);
                ((UDPClient) this.b).finish();
                break;
            case 1:
                UDPClient uDPClient = (UDPClient) this.b;
                uDPClient.getClass();
                Intent intent = new Intent(Deobfuscator$AMTUNNELLITE$app.getString(-156764842561185L));
                intent.addCategory(Deobfuscator$AMTUNNELLITE$app.getString(-157190044323489L));
                intent.setFlags(268435456);
                uDPClient.startActivity(intent);
                break;
            case 2:
                try {
                    ((ActivityManager) ((UDPClient) this.b).getSystemService(Deobfuscator$AMTUNNELLITE$app.getString(-150696053771937L))).clearApplicationUserData();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            case 3:
                try {
                    ((ActivityManager) ((UDPClient) this.b).getSystemService(Deobfuscator$AMTUNNELLITE$app.getString(-152031788600993L))).clearApplicationUserData();
                    break;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            default:
                X1 x1 = (X1) this.b;
                x1.getClass();
                new W1(x1).filter(Deobfuscator$AMTUNNELLITE$app.getString(-152310961475233L));
                break;
        }
    }
}
