package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import java.util.Locale;

/* loaded from: classes.dex */
public final class Q50 extends XM {
    public final C4608zE d;

    public Q50(C4608zE c4608zE) {
        this.d = c4608zE;
    }

    @Override // defpackage.XM
    public final int a() {
        return this.d.c.f;
    }

    @Override // defpackage.XM
    public final void c(AbstractC4143tN abstractC4143tN, int i) {
        C4608zE c4608zE = this.d;
        int i2 = c4608zE.c.a.c + i;
        String format = String.format(Locale.getDefault(), "%d", Integer.valueOf(i2));
        TextView textView = ((P50) abstractC4143tN).u;
        textView.setText(format);
        Context context = textView.getContext();
        textView.setContentDescription(AbstractC3717o00.b().get(1) == i2 ? String.format(context.getString(R.string.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i2)) : String.format(context.getString(R.string.mtrl_picker_navigate_to_year_description), Integer.valueOf(i2)));
        ML ml = c4608zE.f;
        if (AbstractC3717o00.b().get(1) == i2) {
            Object obj = ml.c;
        } else {
            Object obj2 = ml.b;
        }
        throw null;
    }

    @Override // defpackage.XM
    public final AbstractC4143tN d(ViewGroup viewGroup) {
        return new P50((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
