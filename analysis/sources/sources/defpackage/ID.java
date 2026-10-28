package defpackage;

import android.R;
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

/* loaded from: classes.dex */
public final class ID<S> extends AbstractC3339fJ {
    public int b;
    public C4203qb c;
    public AF d;
    public int e;
    public QK f;
    public RecyclerView g;
    public RecyclerView h;
    public View i;
    public View j;
    public View k;
    public View l;
    public MaterialButton m;
    public AccessibilityManager n;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f(AF af) {
        boolean z;
        RecyclerView recyclerView;
        RunnableC4818yb runnableC4818yb;
        c cVar = (c) this.h.getAdapter();
        int d = cVar.d.a.d(af);
        AccessibilityManager accessibilityManager = this.n;
        if (accessibilityManager != null && accessibilityManager.isEnabled()) {
            this.d = af;
            this.h.a0(d);
        } else {
            int d2 = d - cVar.d.a.d(this.d);
            boolean z2 = false;
            if (Math.abs(d2) > 3) {
                z = true;
            } else {
                z = false;
            }
            if (d2 > 0) {
                z2 = true;
            }
            this.d = af;
            if (z && z2) {
                this.h.a0(d - 3);
                recyclerView = this.h;
                runnableC4818yb = new RunnableC4818yb(this, d, 3);
            } else if (z) {
                this.h.a0(d + 3);
                recyclerView = this.h;
                runnableC4818yb = new RunnableC4818yb(this, d, 3);
            } else {
                recyclerView = this.h;
                runnableC4818yb = new RunnableC4818yb(this, d, 3);
            }
            recyclerView.post(runnableC4818yb);
        }
        h(d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g(int i) {
        this.e = i;
        if (i == 2) {
            this.g.getLayoutManager().p0(this.d.c - ((C4548v40) this.g.getAdapter()).d.c.a.c);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void h(int i) {
        boolean z;
        View view = this.j;
        boolean z2 = false;
        if (i + 1 < this.h.getAdapter().a()) {
            z = true;
        } else {
            z = false;
        }
        view.setEnabled(z);
        View view2 = this.i;
        if (i - 1 >= 0) {
            z2 = true;
        }
        view2.setEnabled(z2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.b = bundle.getInt("THEME_RES_ID_KEY");
        F40.n(bundle.getParcelable("GRID_SELECTOR_KEY"));
        this.c = (C4203qb) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        F40.n(bundle.getParcelable("DAY_VIEW_DECORATOR_KEY"));
        this.d = (AF) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        C0312Lj c0312Lj;
        HI hi;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.b);
        this.f = new QK(contextThemeWrapper, 12);
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        this.n = (AccessibilityManager) requireContext().getSystemService("accessibility");
        AF af = this.c.a;
        if (OD.i(contextThemeWrapper, R.attr.windowFullscreen)) {
            i = app.vpn.amtunnellite.R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = app.vpn.amtunnellite.R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        Resources resources = requireContext().getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(app.vpn.amtunnellite.R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelOffset(app.vpn.amtunnellite.R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelSize(app.vpn.amtunnellite.R.dimen.mtrl_calendar_navigation_height);
        int dimensionPixelSize = resources.getDimensionPixelSize(app.vpn.amtunnellite.R.dimen.mtrl_calendar_days_of_week_height);
        int i3 = BF.d;
        inflate.setMinimumHeight(dimensionPixelOffset + dimensionPixelSize + (resources.getDimensionPixelOffset(app.vpn.amtunnellite.R.dimen.mtrl_calendar_month_vertical_padding) * (i3 - 1)) + (resources.getDimensionPixelSize(app.vpn.amtunnellite.R.dimen.mtrl_calendar_day_height) * i3) + resources.getDimensionPixelOffset(app.vpn.amtunnellite.R.dimen.mtrl_calendar_bottom_padding));
        GridView gridView = (GridView) inflate.findViewById(app.vpn.amtunnellite.R.id.mtrl_calendar_days_of_week);
        T00.l(gridView, new C0495Sl(1));
        int i4 = this.c.e;
        if (i4 > 0) {
            c0312Lj = new C0312Lj(i4);
        } else {
            c0312Lj = new C0312Lj();
        }
        gridView.setAdapter((ListAdapter) c0312Lj);
        gridView.setNumColumns(af.d);
        gridView.setEnabled(false);
        this.h = (RecyclerView) inflate.findViewById(app.vpn.amtunnellite.R.id.mtrl_calendar_months);
        getContext();
        this.h.setLayoutManager(new FD(this, i2, i2));
        this.h.setTag("MONTHS_VIEW_GROUP_TAG");
        c cVar = new c(contextThemeWrapper, this.c, new C0338Mk(this));
        this.h.setAdapter(cVar);
        int integer = contextThemeWrapper.getResources().getInteger(app.vpn.amtunnellite.R.integer.mtrl_calendar_year_selector_span);
        RecyclerView recyclerView3 = (RecyclerView) inflate.findViewById(app.vpn.amtunnellite.R.id.mtrl_calendar_year_selector_frame);
        this.g = recyclerView3;
        if (recyclerView3 != null) {
            recyclerView3.setHasFixedSize(true);
            this.g.setLayoutManager(new GridLayoutManager(integer));
            this.g.setAdapter(new C4548v40(this));
            this.g.g(new GD(this));
        }
        View findViewById = inflate.findViewById(app.vpn.amtunnellite.R.id.month_navigation_fragment_toggle);
        C4203qb c4203qb = cVar.d;
        if (findViewById != null) {
            MaterialButton materialButton = (MaterialButton) inflate.findViewById(app.vpn.amtunnellite.R.id.month_navigation_fragment_toggle);
            this.m = materialButton;
            materialButton.setTag("SELECTOR_TOGGLE_TAG");
            T00.l(this.m, new V9(this, 3));
            View findViewById2 = inflate.findViewById(app.vpn.amtunnellite.R.id.month_navigation_previous);
            this.i = findViewById2;
            findViewById2.setTag("NAVIGATION_PREV_TAG");
            View findViewById3 = inflate.findViewById(app.vpn.amtunnellite.R.id.month_navigation_next);
            this.j = findViewById3;
            findViewById3.setTag("NAVIGATION_NEXT_TAG");
            this.k = inflate.findViewById(app.vpn.amtunnellite.R.id.mtrl_calendar_year_selector_frame);
            this.l = inflate.findViewById(app.vpn.amtunnellite.R.id.mtrl_calendar_day_selector_frame);
            g(1);
            this.m.setText(this.d.c());
            this.h.h(new HD(this, cVar));
            this.m.setOnClickListener(new T0(this, 4));
            this.j.setOnClickListener(new ED(this, cVar, 1));
            this.i.setOnClickListener(new ED(this, cVar, 0));
            h(c4203qb.a.d(this.d));
        }
        if (!OD.i(contextThemeWrapper, R.attr.windowFullscreen) && (recyclerView2 = (hi = new HI()).a) != (recyclerView = this.h)) {
            XS xs = hi.b;
            if (recyclerView2 != null) {
                ArrayList arrayList = recyclerView2.f0;
                if (arrayList != null) {
                    arrayList.remove(xs);
                }
                hi.a.setOnFlingListener(null);
            }
            hi.a = recyclerView;
            if (recyclerView != null) {
                if (recyclerView.getOnFlingListener() == null) {
                    hi.a.h(xs);
                    hi.a.setOnFlingListener(hi);
                    new Scroller(hi.a.getContext(), new DecelerateInterpolator());
                    hi.f();
                } else {
                    throw new IllegalStateException("An instance of OnFlingListener already set.");
                }
            }
        }
        this.h.a0(c4203qb.a.d(this.d));
        T00.l(this.h, new C0495Sl(2));
        return inflate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.l
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.b);
        bundle.putParcelable("GRID_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.c);
        bundle.putParcelable("DAY_VIEW_DECORATOR_KEY", null);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.d);
    }
}
