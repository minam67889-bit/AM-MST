package defpackage;

import android.os.Message;
import android.view.View;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import app.vpn.amtunnellite.R;
import com.github.angads25.filepicker.widget.MaterialCheckbox;

/* loaded from: classes.dex */
public final class T0 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T0(DC dc, int i, String str) {
        this.a = 3;
        this.b = dc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        RecyclerView recyclerView;
        int i;
        C4563vE c4563vE;
        switch (this.a) {
            case 0:
                ((AbstractC3926n1) this.b).a();
                return;
            case 1:
                I3 i3 = (I3) this.b;
                if ((view == i3.k && (message3 = i3.m) != null) || (view == i3.o && (message3 = i3.q) != null)) {
                    message = Message.obtain(message3);
                } else if (view == i3.s && (message2 = i3.u) != null) {
                    message = Message.obtain(message2);
                } else {
                    message = null;
                }
                if (message != null) {
                    message.sendToTarget();
                }
                i3.K.obtainMessage(1, i3.b).sendToTarget();
                return;
            case 2:
                ((C4150pw) this.b).b.completeUpdate();
                return;
            case 3:
                BC bc = ((DC) this.b).h;
                if (bc != null) {
                    bc.getClass();
                    return;
                }
                return;
            case 4:
                ID id = (ID) this.b;
                int i2 = id.e;
                if (i2 == 2) {
                    id.g(1);
                    recyclerView = id.h;
                    i = R.string.mtrl_picker_toggled_to_day_selection;
                } else if (i2 == 1) {
                    id.g(2);
                    recyclerView = id.g;
                    i = R.string.mtrl_picker_toggled_to_year_selection;
                } else {
                    return;
                }
                recyclerView.announceForAccessibility(id.getString(i));
                return;
            case 5:
                MaterialCheckbox materialCheckbox = (MaterialCheckbox) this.b;
                materialCheckbox.setChecked(!materialCheckbox.e);
                materialCheckbox.getClass();
                boolean z = materialCheckbox.e;
                throw null;
            default:
                C4735xW c4735xW = ((Toolbar) this.b).L;
                if (c4735xW == null) {
                    c4563vE = null;
                } else {
                    c4563vE = c4735xW.b;
                }
                if (c4563vE != null) {
                    c4563vE.collapseActionView();
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ T0(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }
}
