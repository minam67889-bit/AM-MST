package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.material.sidesheet.SideSheetBehavior;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0327Mg;
import defpackage.AbstractC0731aZ;
import defpackage.AbstractC2925e20;
import defpackage.C0296La;
import defpackage.C0347Na;
import defpackage.C0405Pg;
import defpackage.C2862dB;
import defpackage.C3165h20;
import defpackage.C3317j;
import defpackage.C3755oT;
import defpackage.C4385wS;
import defpackage.C4464xS;
import defpackage.F0;
import defpackage.FM;
import defpackage.JE;
import defpackage.V0;
import defpackage.W50;
import defpackage.W80;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends AbstractC0327Mg {
    public W80 a;
    public final JE b;
    public final ColorStateList c;
    public final C4464xS d;
    public final C0347Na e;
    public final float f;
    public final boolean g;
    public int h;
    public C3165h20 i;
    public boolean j;
    public final float k;
    public int l;
    public int m;
    public int n;
    public int o;
    public WeakReference p;
    public WeakReference q;
    public final int r;
    public VelocityTracker s;
    public int t;
    public final LinkedHashSet u;
    public final C0296La v;

    public SideSheetBehavior() {
        this.e = new C0347Na(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.r = -1;
        this.u = new LinkedHashSet();
        this.v = new C0296La(this, 1);
    }

    @Override // defpackage.AbstractC0327Mg
    public final void c(C0405Pg c0405Pg) {
        this.p = null;
        this.i = null;
    }

    @Override // defpackage.AbstractC0327Mg
    public final void f() {
        this.p = null;
        this.i = null;
    }

    @Override // defpackage.AbstractC0327Mg
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        C3165h20 c3165h20;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && AbstractC2925e20.e(view) == null) || !this.g) {
            this.j = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 && (velocityTracker = this.s) != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        if (actionMasked == 0) {
            this.t = (int) motionEvent.getX();
        } else if ((actionMasked == 1 || actionMasked == 3) && this.j) {
            this.j = false;
            return false;
        }
        return (this.j || (c3165h20 = this.i) == null || !c3165h20.r(motionEvent)) ? false : true;
    }

    @Override // defpackage.AbstractC0327Mg
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
        View view2;
        View view3;
        int i2;
        View findViewById;
        int i3 = 0;
        JE je = this.b;
        int i4 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.p == null) {
            this.p = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            AbstractC0731aZ.a0(context, R.attr.motionDurationMedium2, AdSize.MEDIUM_RECTANGLE_WIDTH);
            AbstractC0731aZ.a0(context, R.attr.motionDurationShort3, 150);
            AbstractC0731aZ.a0(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (je != null) {
                view.setBackground(je);
                float f = this.f;
                if (f == -1.0f) {
                    f = view.getElevation();
                }
                je.m(f);
            } else {
                ColorStateList colorStateList = this.c;
                if (colorStateList != null) {
                    WeakHashMap weakHashMap = AbstractC2925e20.a;
                    view.setBackgroundTintList(colorStateList);
                }
            }
            int i5 = this.h == 5 ? 4 : 0;
            if (view.getVisibility() != i5) {
                view.setVisibility(i5);
            }
            v();
            if (view.getImportantForAccessibility() == 0) {
                view.setImportantForAccessibility(1);
            }
            if (AbstractC2925e20.e(view) == null) {
                AbstractC2925e20.n(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i6 = Gravity.getAbsoluteGravity(((C0405Pg) view.getLayoutParams()).c, i) == 3 ? 1 : 0;
        W80 w80 = this.a;
        if (w80 == null || w80.G() != i6) {
            C4464xS c4464xS = this.d;
            C0405Pg c0405Pg = null;
            if (i6 == 0) {
                this.a = new C2862dB(this, i4);
                if (c4464xS != null) {
                    WeakReference weakReference = this.p;
                    if (weakReference != null && (view3 = (View) weakReference.get()) != null && (view3.getLayoutParams() instanceof C0405Pg)) {
                        c0405Pg = (C0405Pg) view3.getLayoutParams();
                    }
                    if (c0405Pg == null || ((ViewGroup.MarginLayoutParams) c0405Pg).rightMargin <= 0) {
                        C4385wS f2 = c4464xS.f();
                        f2.f = new C3317j(0.0f);
                        f2.g = new C3317j(0.0f);
                        C4464xS a = f2.a();
                        if (je != null) {
                            je.setShapeAppearanceModel(a);
                        }
                    }
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalArgumentException(W50.j(i6, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.a = new C2862dB(this, i3);
                if (c4464xS != null) {
                    WeakReference weakReference2 = this.p;
                    if (weakReference2 != null && (view2 = (View) weakReference2.get()) != null && (view2.getLayoutParams() instanceof C0405Pg)) {
                        c0405Pg = (C0405Pg) view2.getLayoutParams();
                    }
                    if (c0405Pg == null || ((ViewGroup.MarginLayoutParams) c0405Pg).leftMargin <= 0) {
                        C4385wS f3 = c4464xS.f();
                        f3.e = new C3317j(0.0f);
                        f3.h = new C3317j(0.0f);
                        C4464xS a2 = f3.a();
                        if (je != null) {
                            je.setShapeAppearanceModel(a2);
                        }
                    }
                }
            }
        }
        if (this.i == null) {
            this.i = new C3165h20(coordinatorLayout.getContext(), coordinatorLayout, this.v);
        }
        int B = this.a.B(view);
        coordinatorLayout.q(view, i);
        this.m = coordinatorLayout.getWidth();
        this.n = this.a.F(coordinatorLayout);
        this.l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.o = marginLayoutParams != null ? this.a.e(marginLayoutParams) : 0;
        int i7 = this.h;
        if (i7 == 1 || i7 == 2) {
            i3 = B - this.a.B(view);
        } else if (i7 != 3) {
            if (i7 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.h);
            }
            i3 = this.a.x();
        }
        WeakHashMap weakHashMap2 = AbstractC2925e20.a;
        view.offsetLeftAndRight(i3);
        if (this.q == null && (i2 = this.r) != -1 && (findViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.q = new WeakReference(findViewById);
        }
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            if (it.next() != null) {
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // defpackage.AbstractC0327Mg
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    @Override // defpackage.AbstractC0327Mg
    public final void n(View view, Parcelable parcelable) {
        int i = ((C3755oT) parcelable).c;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.h = i;
    }

    @Override // defpackage.AbstractC0327Mg
    public final Parcelable o(View view) {
        AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
        return new C3755oT(this);
    }

    @Override // defpackage.AbstractC0327Mg
    public final boolean r(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        if (!view.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.h == 1 && actionMasked == 0) {
            return true;
        }
        if (t()) {
            this.i.k(motionEvent);
        }
        if (actionMasked == 0 && (velocityTracker = this.s) != null) {
            velocityTracker.recycle();
            this.s = null;
        }
        if (this.s == null) {
            this.s = VelocityTracker.obtain();
        }
        this.s.addMovement(motionEvent);
        if (t() && actionMasked == 2 && !this.j && t()) {
            float abs = Math.abs(this.t - motionEvent.getX());
            C3165h20 c3165h20 = this.i;
            if (abs > c3165h20.b) {
                c3165h20.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.j;
    }

    public final void s(int i) {
        View view;
        if (this.h == i) {
            return;
        }
        this.h = i;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        int i2 = this.h == 5 ? 4 : 0;
        if (view.getVisibility() != i2) {
            view.setVisibility(i2);
        }
        Iterator it = this.u.iterator();
        if (it.hasNext()) {
            throw W50.f(it);
        }
        v();
    }

    public final boolean t() {
        if (this.i != null) {
            return this.g || this.h == 1;
        }
        return false;
    }

    public final void u(View view, int i, boolean z) {
        int w;
        if (i == 3) {
            w = this.a.w();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(W50.i(i, "Invalid state to get outer edge offset: "));
            }
            w = this.a.x();
        }
        C3165h20 c3165h20 = this.i;
        if (c3165h20 == null || (!z ? c3165h20.s(view, w, view.getTop()) : c3165h20.q(w, view.getTop()))) {
            s(i);
        } else {
            s(2);
            this.e.a(i);
        }
    }

    public final void v() {
        View view;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        AbstractC2925e20.j(view, 262144);
        AbstractC2925e20.h(view, 0);
        AbstractC2925e20.j(view, 1048576);
        AbstractC2925e20.h(view, 0);
        final int i = 5;
        if (this.h != 5) {
            AbstractC2925e20.k(view, F0.l, new V0() { // from class: nT
                @Override // defpackage.V0
                public final boolean d(View view2) {
                    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                    sideSheetBehavior.getClass();
                    int i2 = i;
                    if (i2 == 1 || i2 == 2) {
                        throw new IllegalArgumentException(W50.q(i2 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally.", new StringBuilder("STATE_")));
                    }
                    WeakReference weakReference2 = sideSheetBehavior.p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.s(i2);
                        return true;
                    }
                    View view3 = (View) sideSheetBehavior.p.get();
                    RunnableC4539yO runnableC4539yO = new RunnableC4539yO(sideSheetBehavior, i2, 1);
                    ViewParent parent = view3.getParent();
                    if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                        view3.post(runnableC4539yO);
                        return true;
                    }
                    runnableC4539yO.run();
                    return true;
                }
            });
        }
        final int i2 = 3;
        if (this.h != 3) {
            AbstractC2925e20.k(view, F0.j, new V0() { // from class: nT
                @Override // defpackage.V0
                public final boolean d(View view2) {
                    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                    sideSheetBehavior.getClass();
                    int i22 = i2;
                    if (i22 == 1 || i22 == 2) {
                        throw new IllegalArgumentException(W50.q(i22 == 1 ? "DRAGGING" : "SETTLING", " should not be set externally.", new StringBuilder("STATE_")));
                    }
                    WeakReference weakReference2 = sideSheetBehavior.p;
                    if (weakReference2 == null || weakReference2.get() == null) {
                        sideSheetBehavior.s(i22);
                        return true;
                    }
                    View view3 = (View) sideSheetBehavior.p.get();
                    RunnableC4539yO runnableC4539yO = new RunnableC4539yO(sideSheetBehavior, i22, 1);
                    ViewParent parent = view3.getParent();
                    if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                        view3.post(runnableC4539yO);
                        return true;
                    }
                    runnableC4539yO.run();
                    return true;
                }
            });
        }
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.e = new C0347Na(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.r = -1;
        this.u = new LinkedHashSet();
        this.v = new C0296La(this, 1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.B);
        if (obtainStyledAttributes.hasValue(3)) {
            this.c = W80.s(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.d = C4464xS.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
        }
        if (obtainStyledAttributes.hasValue(5)) {
            int resourceId = obtainStyledAttributes.getResourceId(5, -1);
            this.r = resourceId;
            WeakReference weakReference = this.q;
            if (weakReference != null) {
                weakReference.clear();
            }
            this.q = null;
            WeakReference weakReference2 = this.p;
            if (weakReference2 != null) {
                View view = (View) weakReference2.get();
                if (resourceId != -1 && view.isLaidOut()) {
                    view.requestLayout();
                }
            }
        }
        C4464xS c4464xS = this.d;
        if (c4464xS != null) {
            JE je = new JE(c4464xS);
            this.b = je;
            je.k(context);
            ColorStateList colorStateList = this.c;
            if (colorStateList != null) {
                this.b.n(colorStateList);
            } else {
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
                this.b.setTint(typedValue.data);
            }
        }
        this.f = obtainStyledAttributes.getDimension(2, -1.0f);
        this.g = obtainStyledAttributes.getBoolean(4, true);
        obtainStyledAttributes.recycle();
        ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
