package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import app.vpn.amtunnellite.R;
import defpackage.AF;
import defpackage.AbstractC4340sM;
import defpackage.BF;
import defpackage.C0338Mk;
import defpackage.C3265eM;
import defpackage.C4203qb;
import defpackage.OD;
import defpackage.RZ;
import defpackage.VL;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class c extends VL {
    public final C4203qb d;
    public final C0338Mk e;
    public final int f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public c(ContextThemeWrapper contextThemeWrapper, C4203qb c4203qb, C0338Mk c0338Mk) {
        AF af = c4203qb.a;
        AF af2 = c4203qb.d;
        if (af.a.compareTo(af2.a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (af2.a.compareTo(c4203qb.b.a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * BF.d) + (OD.i(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.d = c4203qb;
        this.e = c0338Mk;
        if (this.a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.b = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final int a() {
        return this.d.g;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final long b(int i) {
        Calendar b = RZ.b(this.d.a.a);
        b.add(2, i);
        return new AF(b).a.getTimeInMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final void c(AbstractC4340sM abstractC4340sM, int i) {
        b bVar = (b) abstractC4340sM;
        C4203qb c4203qb = this.d;
        Calendar b = RZ.b(c4203qb.a.a);
        b.add(2, i);
        AF af = new AF(b);
        bVar.u.setText(af.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.v.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !af.equals(materialCalendarGridView.a().a)) {
            new BF(af, c4203qb);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.VL
    public final AbstractC4340sM d(RecyclerView recyclerView) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(recyclerView.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, (ViewGroup) recyclerView, false);
        if (!OD.i(recyclerView.getContext(), android.R.attr.windowFullscreen)) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new C3265eM(-1, this.f));
        return new b(linearLayout, true);
    }
}
