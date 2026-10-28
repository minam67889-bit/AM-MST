package com.google.android.material.sidesheet;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import app.vpn.amtunnellite.R;
import com.google.android.gms.ads.AdSize;
import com.google.android.material.sidesheet.SideSheetBehavior;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC3411gE;
import defpackage.AbstractC4575vQ;
import defpackage.AbstractC4826yg;
import defpackage.C0;
import defpackage.C0049Bg;
import defpackage.C3540i;
import defpackage.C4021oA;
import defpackage.C4508ua;
import defpackage.C4577vS;
import defpackage.C4662wa;
import defpackage.CL;
import defpackage.DR;
import defpackage.ER;
import defpackage.L00;
import defpackage.R0;
import defpackage.T00;
import defpackage.T60;
import defpackage.UD;
import defpackage.W00;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends AbstractC4826yg {
    public AbstractC3411gE a;
    public final UD b;
    public final ColorStateList c;
    public final ER d;
    public final C4662wa e;
    public final float f;
    public final boolean g;
    public int h;
    public W00 i;
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
    public final C4508ua v;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SideSheetBehavior() {
        this.e = new C4662wa(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.r = -1;
        this.u = new LinkedHashSet();
        this.v = new C4508ua(this, 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final void c(C0049Bg c0049Bg) {
        this.p = null;
        this.i = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final void f() {
        this.p = null;
        this.i = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final boolean g(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        W00 w00;
        VelocityTracker velocityTracker;
        if ((!view.isShown() && T00.d(view) == null) || !this.g) {
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
        return (this.j || (w00 = this.i) == null || !w00.r(motionEvent)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:83:0x010c, code lost:
    
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x010e, code lost:
    
        r1.setShapeAppearanceModel(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0155, code lost:
    
        if (r1 != null) goto L56;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
        ER a;
        View view2;
        View view3;
        int i2;
        View findViewById;
        int i3 = 0;
        UD ud = this.b;
        int i4 = 1;
        if (coordinatorLayout.getFitsSystemWindows() && !view.getFitsSystemWindows()) {
            view.setFitsSystemWindows(true);
        }
        if (this.p == null) {
            this.p = new WeakReference(view);
            new PathInterpolator(0.1f, 0.1f, 0.0f, 1.0f);
            Context context = view.getContext();
            AbstractC0363Nj.z(context, R.attr.motionDurationMedium2, AdSize.MEDIUM_RECTANGLE_WIDTH);
            AbstractC0363Nj.z(context, R.attr.motionDurationShort3, 150);
            AbstractC0363Nj.z(context, R.attr.motionDurationShort2, 100);
            Resources resources = view.getResources();
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_shrink);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_x_distance_grow);
            resources.getDimension(R.dimen.m3_back_progress_side_container_max_scale_y_distance);
            if (ud != null) {
                view.setBackground(ud);
                float f = this.f;
                if (f == -1.0f) {
                    f = view.getElevation();
                }
                ud.n(f);
            } else {
                ColorStateList colorStateList = this.c;
                if (colorStateList != null) {
                    WeakHashMap weakHashMap = T00.a;
                    L00.h(view, colorStateList);
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
            if (T00.d(view) == null) {
                T00.m(view, view.getResources().getString(R.string.side_sheet_accessibility_pane_title));
            }
        }
        int i6 = Gravity.getAbsoluteGravity(((C0049Bg) view.getLayoutParams()).c, i) == 3 ? 1 : 0;
        AbstractC3411gE abstractC3411gE = this.a;
        if (abstractC3411gE == null || abstractC3411gE.s0() != i6) {
            ER er = this.d;
            C0049Bg c0049Bg = null;
            if (i6 == 0) {
                this.a = new C4021oA(this, i4);
                if (er != null) {
                    WeakReference weakReference = this.p;
                    if (weakReference != null && (view3 = (View) weakReference.get()) != null && (view3.getLayoutParams() instanceof C0049Bg)) {
                        c0049Bg = (C0049Bg) view3.getLayoutParams();
                    }
                    if (c0049Bg == null || ((ViewGroup.MarginLayoutParams) c0049Bg).rightMargin <= 0) {
                        DR f2 = er.f();
                        f2.f = new C3540i(0.0f);
                        f2.g = new C3540i(0.0f);
                        a = f2.a();
                    }
                }
            } else {
                if (i6 != 1) {
                    throw new IllegalArgumentException(AbstractC4575vQ.n(i6, "Invalid sheet edge position value: ", ". Must be 0 or 1."));
                }
                this.a = new C4021oA(this, i3);
                if (er != null) {
                    WeakReference weakReference2 = this.p;
                    if (weakReference2 != null && (view2 = (View) weakReference2.get()) != null && (view2.getLayoutParams() instanceof C0049Bg)) {
                        c0049Bg = (C0049Bg) view2.getLayoutParams();
                    }
                    if (c0049Bg == null || ((ViewGroup.MarginLayoutParams) c0049Bg).leftMargin <= 0) {
                        DR f3 = er.f();
                        f3.e = new C3540i(0.0f);
                        f3.h = new C3540i(0.0f);
                        a = f3.a();
                    }
                }
            }
        }
        if (this.i == null) {
            this.i = new W00(coordinatorLayout.getContext(), coordinatorLayout, this.v);
        }
        int m0 = this.a.m0(view);
        coordinatorLayout.q(view, i);
        this.m = coordinatorLayout.getWidth();
        this.n = this.a.q0(coordinatorLayout);
        this.l = view.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        this.o = marginLayoutParams != null ? this.a.d(marginLayoutParams) : 0;
        int i7 = this.h;
        if (i7 == 1 || i7 == 2) {
            i3 = m0 - this.a.m0(view);
        } else if (i7 != 3) {
            if (i7 != 5) {
                throw new IllegalStateException("Unexpected value: " + this.h);
            }
            i3 = this.a.h0();
        }
        WeakHashMap weakHashMap2 = T00.a;
        view.offsetLeftAndRight(i3);
        if (this.q == null && (i2 = this.r) != -1 && (findViewById = coordinatorLayout.findViewById(i2)) != null) {
            this.q = new WeakReference(findViewById);
        }
        Iterator it = this.u.iterator();
        while (it.hasNext()) {
            AbstractC4575vQ.B(it.next());
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i, coordinatorLayout.getPaddingRight() + coordinatorLayout.getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, coordinatorLayout.getPaddingBottom() + coordinatorLayout.getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height));
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final void n(View view, Parcelable parcelable) {
        int i = ((C4577vS) parcelable).c;
        if (i == 1 || i == 2) {
            i = 5;
        }
        this.h = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final Parcelable o(View view) {
        return new C4577vS(View.BaseSavedState.EMPTY_STATE, this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
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
            W00 w00 = this.i;
            if (abs > w00.b) {
                w00.b(view, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
        }
        return !this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
            AbstractC4575vQ.B(it.next());
            throw null;
        }
        v();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean t() {
        return this.i != null && (this.g || this.h == 1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void u(View view, int i, boolean z) {
        int f0;
        if (i == 3) {
            f0 = this.a.f0();
        } else {
            if (i != 5) {
                throw new IllegalArgumentException(T60.w(i, "Invalid state to get outer edge offset: "));
            }
            f0 = this.a.h0();
        }
        W00 w00 = this.i;
        if (w00 == null || (!z ? w00.s(view, f0, view.getTop()) : w00.q(f0, view.getTop()))) {
            s(i);
        } else {
            s(2);
            this.e.a(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void v() {
        View view;
        WeakReference weakReference = this.p;
        if (weakReference == null || (view = (View) weakReference.get()) == null) {
            return;
        }
        T00.i(view, 262144);
        T00.g(view, 0);
        T00.i(view, 1048576);
        T00.g(view, 0);
        final int i = 5;
        if (this.h != 5) {
            T00.j(view, C0.l, new R0() { // from class: uS
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // defpackage.R0
                public final boolean a(View view2) {
                    String str;
                    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                    sideSheetBehavior.getClass();
                    int i2 = i;
                    if (i2 != 1 && i2 != 2) {
                        WeakReference weakReference2 = sideSheetBehavior.p;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            View view3 = (View) sideSheetBehavior.p.get();
                            BN bn = new BN(sideSheetBehavior, i2, 1);
                            ViewParent parent = view3.getParent();
                            if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                                view3.post(bn);
                            } else {
                                bn.run();
                            }
                        } else {
                            sideSheetBehavior.s(i2);
                        }
                        return true;
                    }
                    StringBuilder sb = new StringBuilder("STATE_");
                    if (i2 == 1) {
                        str = "DRAGGING";
                    } else {
                        str = "SETTLING";
                    }
                    throw new IllegalArgumentException(AbstractC4575vQ.t(str, " should not be set externally.", sb));
                }
            });
        }
        final int i2 = 3;
        if (this.h != 3) {
            T00.j(view, C0.j, new R0() { // from class: uS
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // defpackage.R0
                public final boolean a(View view2) {
                    String str;
                    SideSheetBehavior sideSheetBehavior = SideSheetBehavior.this;
                    sideSheetBehavior.getClass();
                    int i22 = i2;
                    if (i22 != 1 && i22 != 2) {
                        WeakReference weakReference2 = sideSheetBehavior.p;
                        if (weakReference2 != null && weakReference2.get() != null) {
                            View view3 = (View) sideSheetBehavior.p.get();
                            BN bn = new BN(sideSheetBehavior, i22, 1);
                            ViewParent parent = view3.getParent();
                            if (parent != null && parent.isLayoutRequested() && view3.isAttachedToWindow()) {
                                view3.post(bn);
                            } else {
                                bn.run();
                            }
                        } else {
                            sideSheetBehavior.s(i22);
                        }
                        return true;
                    }
                    StringBuilder sb = new StringBuilder("STATE_");
                    if (i22 == 1) {
                        str = "DRAGGING";
                    } else {
                        str = "SETTLING";
                    }
                    throw new IllegalArgumentException(AbstractC4575vQ.t(str, " should not be set externally.", sb));
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        this.e = new C4662wa(this);
        this.g = true;
        this.h = 5;
        this.k = 0.1f;
        this.r = -1;
        this.u = new LinkedHashSet();
        this.v = new C4508ua(this, 1);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CL.B);
        if (obtainStyledAttributes.hasValue(3)) {
            this.c = AbstractC3411gE.d0(context, obtainStyledAttributes, 3);
        }
        if (obtainStyledAttributes.hasValue(6)) {
            this.d = ER.b(context, attributeSet, 0, R.style.Widget_Material3_SideSheet).a();
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
        ER er = this.d;
        if (er != null) {
            UD ud = new UD(er);
            this.b = ud;
            ud.l(context);
            ColorStateList colorStateList = this.c;
            if (colorStateList != null) {
                this.b.o(colorStateList);
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
