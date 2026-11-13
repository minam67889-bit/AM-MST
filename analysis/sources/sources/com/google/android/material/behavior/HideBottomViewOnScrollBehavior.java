package com.google.android.material.behavior;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC3778l4;
import defpackage.AbstractC4575vQ;
import defpackage.AbstractC4826yg;
import defpackage.AccessibilityManagerTouchExplorationStateChangeListenerC3918mv;
import defpackage.U0;
import defpackage.ViewOnAttachStateChangeListenerC0433Qb;
import java.util.Iterator;
import java.util.LinkedHashSet;

@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends AbstractC4826yg {
    public int b;
    public int c;
    public TimeInterpolator d;
    public TimeInterpolator e;
    public AccessibilityManager g;
    public AccessibilityManager.TouchExplorationStateChangeListener h;
    public ViewPropertyAnimator k;
    public final LinkedHashSet a = new LinkedHashSet();
    public int f = 0;
    public final boolean i = true;
    public int j = 2;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HideBottomViewOnScrollBehavior() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
        this.f = view.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).bottomMargin;
        this.b = AbstractC0363Nj.z(view.getContext(), R.attr.motionDurationLong2, 225);
        this.c = AbstractC0363Nj.z(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.d = AbstractC0363Nj.A(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC3778l4.d);
        this.e = AbstractC0363Nj.A(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC3778l4.c);
        if (this.g == null) {
            this.g = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.g;
        if (accessibilityManager == null || this.h != null) {
            return false;
        }
        AccessibilityManagerTouchExplorationStateChangeListenerC3918mv accessibilityManagerTouchExplorationStateChangeListenerC3918mv = new AccessibilityManagerTouchExplorationStateChangeListenerC3918mv(this, view, 0);
        this.h = accessibilityManagerTouchExplorationStateChangeListenerC3918mv;
        accessibilityManager.addTouchExplorationStateChangeListener(accessibilityManagerTouchExplorationStateChangeListenerC3918mv);
        view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0433Qb(this, 3));
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
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
            AbstractC4575vQ.B(it.next());
            throw null;
        }
        this.k = view.animate().translationY(this.f).setInterpolator(this.e).setDuration(this.c).setListener(new U0(this, 3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
            AbstractC4575vQ.B(it.next());
            throw null;
        }
        this.k = view.animate().translationY(0).setInterpolator(this.d).setDuration(this.b).setListener(new U0(this, 3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
