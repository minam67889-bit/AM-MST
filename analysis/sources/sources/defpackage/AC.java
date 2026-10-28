package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.Toast;
import com.liapp.y;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class AC implements View.OnLongClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ DC b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AC(DC dc, int i, String str) {
        this.b = dc;
        this.a = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        BC bc = this.b.h;
        if (bc != null) {
            String str = this.a;
            Activity activity = ((C0625Xl) bc).a;
            try {
                ((ClipboardManager) activity.getSystemService(Deobfuscator$AMTUNNELLITE$app.getString(-196961441484449L))).setPrimaryClip(ClipData.newPlainText(Deobfuscator$AMTUNNELLITE$app.getString(-196987211288225L), str));
                return true;
            } catch (Exception e) {
                SkStatus.logException("Error copying log", e);
                Toast makeText = Toast.makeText(activity, "Could not copy log!", 0);
                y.׳شڬزڮ();
                makeText.show();
                return true;
            }
        }
        return true;
    }
}
