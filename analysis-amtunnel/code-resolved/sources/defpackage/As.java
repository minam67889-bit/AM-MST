package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.view.View;
import android.widget.Toast;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes.dex */
public final class As implements View.OnLongClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ Ds b;

    public As(Ds ds, int i, String str) {
        this.b = ds;
        this.a = str;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Bs bs = this.b.n;
        if (bs == null) {
            return true;
        }
        String str = this.a;
        Activity activity = ((C2513dh) bs).a;
        try {
            ((ClipboardManager) activity.getSystemService("#ERR IndexError: list index out of range")).setPrimaryClip(ClipData.newPlainText("#ERR IndexError: list index out of range", str));
            return true;
        } catch (Exception e) {
            SkStatus.logException("Error copying log", e);
            Toast.makeText(activity, "Could not copy log!", 0).show();
            return true;
        }
    }
}
