package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import app.vpn.amtunnellite.R;
import java.util.Locale;

/* renamed from: v40, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4548v40 extends VL {
    public final ID d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4548v40(ID id) {
        this.d = id;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final int a() {
        return this.d.c.f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final void c(AbstractC4340sM abstractC4340sM, int i) {
        String format;
        ID id = this.d;
        int i2 = id.c.a.c + i;
        String format2 = String.format(Locale.getDefault(), "%d", Integer.valueOf(i2));
        TextView textView = ((C4471u40) abstractC4340sM).u;
        textView.setText(format2);
        Context context = textView.getContext();
        if (RZ.c().get(1) == i2) {
            format = String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i2));
        } else {
            format = String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i2));
        }
        textView.setContentDescription(format);
        QK qk = id.f;
        if (RZ.c().get(1) == i2) {
            Object obj = qk.c;
        } else {
            Object obj2 = qk.b;
        }
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final AbstractC4340sM d(RecyclerView recyclerView) {
        return new C4471u40((TextView) LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.mtrl_calendar_year, (ViewGroup) recyclerView, false));
    }
}
