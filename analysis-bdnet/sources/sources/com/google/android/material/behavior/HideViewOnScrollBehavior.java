package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0327Mg;
import defpackage.AbstractC0731aZ;
import defpackage.AbstractC4434x4;
import defpackage.AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv;
import defpackage.C0405Pg;
import defpackage.C0498Sv;
import defpackage.Ke0;
import defpackage.ViewOnAttachStateChangeListenerC2970ec;
import defpackage.W50;
import defpackage.X0;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends AbstractC0327Mg {
    public Ke0 a;
    public AccessibilityManager b;
    public AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv c;
    public int e;
    public int f;
    public TimeInterpolator g;
    public TimeInterpolator h;
    public ViewPropertyAnimator k;
    public final LinkedHashSet d = new LinkedHashSet();
    public int i = 0;
    public int j = 2;

    public HideViewOnScrollBehavior() {
    }

    @Override // defpackage.AbstractC0327Mg
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
        if (this.b == null) {
            this.b = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.b;
        if (accessibilityManager != null && this.c == null) {
            AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv accessibilityManagerTouchExplorationStateChangeListenerC0472Rv = new AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv(this, view, 1);
            this.c = accessibilityManagerTouchExplorationStateChangeListenerC0472Rv;
            accessibilityManager.addTouchExplorationStateChangeListener(accessibilityManagerTouchExplorationStateChangeListenerC0472Rv);
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC2970ec(this, 4));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i2 = ((C0405Pg) view.getLayoutParams()).c;
        if (i2 == 80 || i2 == 81) {
            s(1);
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i2, i);
            s((absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0);
        }
        this.i = this.a.v(view, marginLayoutParams);
        this.e = AbstractC0731aZ.a0(view.getContext(), R.attr.motionDurationLong2, 225);
        this.f = AbstractC0731aZ.a0(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.g = AbstractC0731aZ.b0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC4434x4.d);
        this.h = AbstractC0731aZ.b0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC4434x4.c);
        return false;
    }

    @Override // defpackage.AbstractC0327Mg
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        if (i <= 0) {
            if (i < 0) {
                t(view);
                return;
            }
            return;
        }
        if (this.j == 1) {
            return;
        }
        AccessibilityManager accessibilityManager = this.b;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            ViewPropertyAnimator viewPropertyAnimator = this.k;
            if (viewPropertyAnimator != null) {
                viewPropertyAnimator.cancel();
                view.clearAnimation();
            }
            this.j = 1;
            Iterator it = this.d.iterator();
            if (it.hasNext()) {
                throw W50.f(it);
            }
            this.k = this.a.y(view, this.i).setInterpolator(this.h).setDuration(this.f).setListener(new X0(this, 4));
        }
    }

    @Override // defpackage.AbstractC0327Mg
    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public final void s(int i) {
        Ke0 ke0 = this.a;
        if (ke0 == null || ke0.x() != i) {
            if (i == 0) {
                this.a = new C0498Sv(2);
            } else if (i == 1) {
                this.a = new C0498Sv(0);
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException(W50.j(i, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                this.a = new C0498Sv(1);
            }
        }
    }

    public final void t(View view) {
        if (this.j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.j = 2;
        Iterator it = this.d.iterator();
        if (it.hasNext()) {
            throw W50.f(it);
        }
        this.a.getClass();
        this.k = this.a.y(view, 0).setInterpolator(this.g).setDuration(this.e).setListener(new X0(this, 4));
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
