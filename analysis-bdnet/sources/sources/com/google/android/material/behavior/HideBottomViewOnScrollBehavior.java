package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
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
import defpackage.ViewOnAttachStateChangeListenerC2970ec;
import defpackage.W50;
import defpackage.X0;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends AbstractC0327Mg {
    public int b;
    public int c;
    public TimeInterpolator d;
    public TimeInterpolator e;
    public AccessibilityManager g;
    public AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv h;
    public ViewPropertyAnimator k;
    public final LinkedHashSet a = new LinkedHashSet();
    public int f = 0;
    public final boolean i = true;
    public int j = 2;

    public HideBottomViewOnScrollBehavior() {
    }

    @Override // defpackage.AbstractC0327Mg
    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.b = AbstractC0731aZ.a0(view.getContext(), R.attr.motionDurationLong2, 225);
        this.c = AbstractC0731aZ.a0(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.d = AbstractC0731aZ.b0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC4434x4.d);
        this.e = AbstractC0731aZ.b0(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC4434x4.c);
        if (this.g == null) {
            this.g = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.g;
        if (accessibilityManager == null || this.h != null) {
            return false;
        }
        AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv accessibilityManagerTouchExplorationStateChangeListenerC0472Rv = new AccessibilityManagerTouchExplorationStateChangeListenerC0472Rv(this, view, 0);
        this.h = accessibilityManagerTouchExplorationStateChangeListenerC0472Rv;
        accessibilityManager.addTouchExplorationStateChangeListener(accessibilityManagerTouchExplorationStateChangeListenerC0472Rv);
        view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC2970ec(this, 3));
        return false;
    }

    @Override // defpackage.AbstractC0327Mg
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i <= 0) {
            if (i < 0) {
                s(view);
                return;
            }
            return;
        }
        if (this.j == 1) {
            return;
        }
        if (this.i && (accessibilityManager = this.g) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.j = 1;
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw W50.f(it);
        }
        this.k = view.animate().translationY(this.f).setInterpolator(this.e).setDuration(this.c).setListener(new X0(this, 3));
    }

    @Override // defpackage.AbstractC0327Mg
    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public final void s(View view) {
        if (this.j == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.k;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.j = 2;
        Iterator it = this.a.iterator();
        if (it.hasNext()) {
            throw W50.f(it);
        }
        this.k = view.animate().translationY(0).setInterpolator(this.d).setDuration(this.b).setListener(new X0(this, 3));
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
