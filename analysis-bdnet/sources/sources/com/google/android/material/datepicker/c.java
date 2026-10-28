package com.google.android.material.datepicker;

import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3717o00;
import defpackage.AbstractC4143tN;
import defpackage.C0115Eb;
import defpackage.C2835cv;
import defpackage.C3033fN;
import defpackage.C3821pG;
import defpackage.C3900qG;
import defpackage.FE;
import defpackage.XM;
import java.util.Calendar;

/* loaded from: classes.dex */
public final class c extends XM {
    public final C0115Eb d;
    public final C2835cv e;
    public final int f;

    public c(ContextThemeWrapper contextThemeWrapper, C0115Eb c0115Eb, C2835cv c2835cv) {
        C3821pG c3821pG = c0115Eb.a;
        C3821pG c3821pG2 = c0115Eb.d;
        if (c3821pG.a.compareTo(c3821pG2.a) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (c3821pG2.a.compareTo(c0115Eb.b.a) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f = (contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) * C3900qG.d) + (FE.i(contextThemeWrapper, android.R.attr.windowFullscreen) ? contextThemeWrapper.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height) : 0);
        this.d = c0115Eb;
        this.e = c2835cv;
        if (this.a.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.b = true;
    }

    @Override // defpackage.XM
    public final int a() {
        return this.d.g;
    }

    @Override // defpackage.XM
    public final long b(int i) {
        Calendar a = AbstractC3717o00.a(this.d.a.a);
        a.add(2, i);
        a.set(5, 1);
        Calendar a2 = AbstractC3717o00.a(a);
        a2.get(2);
        a2.get(1);
        a2.getMaximum(7);
        a2.getActualMaximum(5);
        a2.getTimeInMillis();
        return a2.getTimeInMillis();
    }

    @Override // defpackage.XM
    public final void c(AbstractC4143tN abstractC4143tN, int i) {
        b bVar = (b) abstractC4143tN;
        C0115Eb c0115Eb = this.d;
        Calendar a = AbstractC3717o00.a(c0115Eb.a.a);
        a.add(2, i);
        C3821pG c3821pG = new C3821pG(a);
        bVar.u.setText(c3821pG.c());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) bVar.v.findViewById(R.id.month_grid);
        if (materialCalendarGridView.a() == null || !c3821pG.equals(materialCalendarGridView.a().a)) {
            new C3900qG(c3821pG, c0115Eb);
            throw null;
        }
        materialCalendarGridView.invalidate();
        materialCalendarGridView.a().getClass();
        throw null;
    }

    @Override // defpackage.XM
    public final AbstractC4143tN d(ViewGroup viewGroup) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!FE.i(viewGroup.getContext(), android.R.attr.windowFullscreen)) {
            return new b(linearLayout, false);
        }
        linearLayout.setLayoutParams(new C3033fN(-1, this.f));
        return new b(linearLayout, true);
    }
}
