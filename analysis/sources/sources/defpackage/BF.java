package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class BF extends BaseAdapter {
    public static final int d = RZ.d(null).getMaximum(4);
    public static final int e = (RZ.d(null).getMaximum(7) + RZ.d(null).getMaximum(5)) - 1;
    public final AF a;
    public QK b;
    public final C4203qb c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BF(AF af, C4203qb c4203qb) {
        this.a = af;
        this.c = c4203qb;
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int a() {
        int i = this.c.e;
        AF af = this.a;
        Calendar calendar = af.a;
        int i2 = calendar.get(7);
        if (i <= 0) {
            i = calendar.getFirstDayOfWeek();
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            return i3 + af.d;
        }
        return i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i >= a() && i <= c()) {
            int a = (i - a()) + 1;
            Calendar b = RZ.b(this.a.a);
            b.set(5, a);
            return Long.valueOf(b.getTimeInMillis());
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int c() {
        return (a() + this.a.e) - 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public final int getCount() {
        return e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.a.d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (this.b == null) {
            this.b = new QK(context, 12);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int a = i - a();
        if (a >= 0) {
            AF af = this.a;
            if (a < af.e) {
                textView.setTag(af);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(a + 1)));
                textView.setVisibility(0);
                textView.setEnabled(true);
                if (getItem(i) == null || textView == null) {
                    return textView;
                }
                textView.getContext();
                RZ.c().getTimeInMillis();
                throw null;
            }
        }
        textView.setVisibility(8);
        textView.setEnabled(false);
        if (getItem(i) == null) {
            textView.getContext();
            RZ.c().getTimeInMillis();
            throw null;
        }
        return textView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
