package defpackage;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.DecelerateInterpolator;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.Scroller;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.datepicker.c;
import java.util.ArrayList;

/* renamed from: zE, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4608zE<S> extends AbstractC0716aK {
    public int b;
    public C0115Eb c;
    public C3821pG d;
    public int e;
    public ML f;
    public RecyclerView g;
    public RecyclerView h;
    public View i;
    public View j;
    public View k;
    public View l;
    public MaterialButton m;
    public AccessibilityManager n;

    public final void f(C3821pG c3821pG) {
        c cVar = (c) this.h.getAdapter();
        int d = cVar.d.a.d(c3821pG);
        AccessibilityManager accessibilityManager = this.n;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            int d2 = d - cVar.d.a.d(this.d);
            boolean z = Math.abs(d2) > 3;
            boolean z2 = d2 > 0;
            this.d = c3821pG;
            if (z && z2) {
                this.h.Z(d - 3);
                this.h.post(new RunnableC0322Mb(this, d, 2));
            } else if (z) {
                this.h.Z(d + 3);
                this.h.post(new RunnableC0322Mb(this, d, 2));
            } else {
                this.h.post(new RunnableC0322Mb(this, d, 2));
            }
        } else {
            this.d = c3821pG;
            this.h.Z(d);
        }
        h(d);
    }

    public final void g(int i) {
        this.e = i;
        if (i == 2) {
            this.g.getLayoutManager().o0(this.d.c - ((Q50) this.g.getAdapter()).d.c.a.c);
            this.k.setVisibility(0);
            this.l.setVisibility(8);
            this.i.setVisibility(8);
            this.j.setVisibility(8);
            return;
        }
        if (i == 1) {
            this.k.setVisibility(8);
            this.l.setVisibility(0);
            this.i.setVisibility(0);
            this.j.setVisibility(0);
            f(this.d);
        }
    }

    public final void h(int i) {
        this.j.setEnabled(i + 1 < this.h.getAdapter().a());
        this.i.setEnabled(i - 1 >= 0);
    }

    @Override // androidx.fragment.app.l
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("GRID_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.c = (C0115Eb) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        if (bundle.getParcelable("DAY_VIEW_DECORATOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.d = (C3821pG) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.l
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        DJ dj;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.f = new ML((Context) contextThemeWrapper, 12);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.n = (AccessibilityManager) requireContext().getSystemService("accessibility");
        C3821pG c3821pG = this.c.a;
        if (FE.i(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = dastan.prince.bdfreevpn.R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = dastan.prince.bdfreevpn.R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_days_of_week_height);
        int i3 = C3900qG.d;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_month_vertical_padding) * (i3 - 1)) + (resources.getDimensionPixelSize(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_day_height) * i3) + resources.getDimensionPixelOffset(dastan.prince.bdfreevpn.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(dastan.prince.bdfreevpn.R.id.mtrl_calendar_days_of_week);
        AbstractC2925e20.m(gridView, new C0618Xl(1));
        int i4 = this.c.e;
        gridView.setAdapter((ListAdapter) (i4 > 0 ? new C0486Sj(i4) : new C0486Sj()));
        gridView.setNumColumns(c3821pG.d);
        gridView.setEnabled(false);
        this.h = (RecyclerView) inflate.findViewById(dastan.prince.bdfreevpn.R.id.mtrl_calendar_months);
        getContext();
        this.h.setLayoutManager(new C4371wE(this, i2, i2));
        this.h.setTag("MONTHS_VIEW_GROUP_TAG");
        c cVar = new c(contextThemeWrapper, this.c, new C2835cv(this, 23));
        this.h.setAdapter(cVar);
        int integer = contextThemeWrapper.getResources().getInteger(dastan.prince.bdfreevpn.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(dastan.prince.bdfreevpn.R.id.mtrl_calendar_year_selector_frame);
        this.g = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.g.setLayoutManager(new GridLayoutManager(integer));
            this.g.setAdapter(new Q50(this));
            RecyclerView recyclerView4 = this.g;
            C4450xE c4450xE = new C4450xE();
            AbstractC3717o00.c(null);
            AbstractC3717o00.c(null);
            recyclerView4.g(c4450xE);
        }
        View findViewById = inflate.findViewById(dastan.prince.bdfreevpn.R.id.month_navigation_fragment_toggle);
        C0115Eb c0115Eb = cVar.d;
        if (findViewById != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(dastan.prince.bdfreevpn.R.id.month_navigation_fragment_toggle);
            this.m = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            AbstractC2925e20.m(this.m, new C3604ma(this, 3));
            View findViewById2 = inflate.findViewById(dastan.prince.bdfreevpn.R.id.month_navigation_previous);
            this.i = findViewById2;
            findViewById2.setTag("NAVIGATION_PREV_TAG");
            View findViewById3 = inflate.findViewById(dastan.prince.bdfreevpn.R.id.month_navigation_next);
            this.j = findViewById3;
            findViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.k = inflate.findViewById(dastan.prince.bdfreevpn.R.id.mtrl_calendar_year_selector_frame);
            this.l = inflate.findViewById(dastan.prince.bdfreevpn.R.id.mtrl_calendar_day_selector_frame);
            g(1);
            this.m.setText(this.d.c());
            this.h.h(new C4529yE(this, cVar));
            this.m.setOnClickListener(new ViewOnClickListenerC2840d(this, 7));
            this.j.setOnClickListener(new ViewOnClickListenerC4292vE(this, cVar, 1));
            this.i.setOnClickListener(new ViewOnClickListenerC4292vE(this, cVar, 0));
            h(c0115Eb.a.d(this.d));
        }
        if (!FE.i(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (dj = new DJ()).a) != (recyclerView = this.h)) {
            PT pt = dj.b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f0;
                if (arrayList != null) {
                    arrayList.remove(pt);
                }
                dj.a.setOnFlingListener(null);
            }
            dj.a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() != null) {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
                dj.a.h(pt);
                dj.a.setOnFlingListener(dj);
                new Scroller(dj.a.getContext(), new DecelerateInterpolator());
                dj.f();
            }
        }
        this.h.Z(c0115Eb.a.d(this.d));
        AbstractC2925e20.m(this.h, new C0618Xl(2));
        return inflate;
    }

    @Override // androidx.fragment.app.l
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.c);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.d);
    }
}
