package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import java.util.Calendar;

/* renamed from: qG, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3900qG extends BaseAdapter {
    public static final int d = AbstractC3717o00.c(null).getMaximum(4);
    public static final int e = (AbstractC3717o00.c(null).getMaximum(7) + AbstractC3717o00.c(null).getMaximum(5)) - 1;
    public final C3821pG a;
    public ML b;
    public final C0115Eb c;

    public C3900qG(C3821pG c3821pG, C0115Eb c0115Eb) {
        this.a = c3821pG;
        this.c = c0115Eb;
        throw null;
    }

    public final int a() {
        int i = this.c.e;
        C3821pG c3821pG = this.a;
        Calendar calendar = c3821pG.a;
        int i2 = calendar.get(7);
        if (i <= 0) {
            i = calendar.getFirstDayOfWeek();
        }
        int i3 = i2 - i;
        return i3 < 0 ? i3 + c3821pG.d : i3;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i < a() || i > c()) {
            return null;
        }
        int a = (i - a()) + 1;
        Calendar a2 = AbstractC3717o00.a(this.a.a);
        a2.set(5, a);
        return Long.valueOf(a2.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.a.e) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return e;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.a.d;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.b == null) {
            this.b = new ML(context, 12);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int a = i - a();
        if (a >= 0) {
            C3821pG c3821pG = this.a;
            if (a < c3821pG.e) {
                textView.setTag(c3821pG);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(a + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                if (getItem(i) == null || textView == null) {
                    return textView;
                }
                textView.getContext();
                AbstractC3717o00.b().getTimeInMillis();
                throw null;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        if (getItem(i) == null) {
            textView.getContext();
            AbstractC3717o00.b().getTimeInMillis();
            throw null;
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
