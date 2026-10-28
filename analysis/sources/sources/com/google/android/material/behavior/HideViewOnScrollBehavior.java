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
import app.vpn.amtunnellite.R;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC3778l4;
import defpackage.AbstractC4575vQ;
import defpackage.AbstractC4817ya0;
import defpackage.AbstractC4826yg;
import defpackage.AccessibilityManagerTouchExplorationStateChangeListenerC3918mv;
import defpackage.C0049Bg;
import defpackage.C3995nv;
import defpackage.U0;
import defpackage.ViewOnAttachStateChangeListenerC0433Qb;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends AbstractC4826yg {
    public AbstractC4817ya0 a;
    public AccessibilityManager b;
    public AccessibilityManager.TouchExplorationStateChangeListener c;
    public int f;
    public int g;
    public TimeInterpolator h;
    public TimeInterpolator i;
    public ViewPropertyAnimator l;
    public final boolean d = true;
    public final LinkedHashSet e = new LinkedHashSet();
    public int j = 0;
    public int k = 2;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HideViewOnScrollBehavior() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
        int i2;
        if (this.b == null) {
            this.b = (AccessibilityManager) view.getContext().getSystemService(AccessibilityManager.class);
        }
        AccessibilityManager accessibilityManager = this.b;
        if (accessibilityManager != null && this.c == null) {
            AccessibilityManagerTouchExplorationStateChangeListenerC3918mv accessibilityManagerTouchExplorationStateChangeListenerC3918mv = new AccessibilityManagerTouchExplorationStateChangeListenerC3918mv(this, view, 1);
            this.c = accessibilityManagerTouchExplorationStateChangeListenerC3918mv;
            accessibilityManager.addTouchExplorationStateChangeListener(accessibilityManagerTouchExplorationStateChangeListenerC3918mv);
            view.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0433Qb(this, 4));
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i3 = ((C0049Bg) view.getLayoutParams()).c;
        if (i3 == 80 || i3 == 81) {
            i2 = 1;
        } else {
            int absoluteGravity = Gravity.getAbsoluteGravity(i3, i);
            i2 = (absoluteGravity == 3 || absoluteGravity == 19) ? 2 : 0;
        }
        s(i2);
        this.j = this.a.I(view, marginLayoutParams);
        this.f = AbstractC0363Nj.z(view.getContext(), R.attr.motionDurationLong2, 225);
        this.g = AbstractC0363Nj.z(view.getContext(), R.attr.motionDurationMedium4, 175);
        this.h = AbstractC0363Nj.A(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC3778l4.d);
        this.i = AbstractC0363Nj.A(view.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC3778l4.c);
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
        AccessibilityManager accessibilityManager;
        if (i <= 0) {
            if (i < 0) {
                t(view);
                return;
            }
            return;
        }
        if (this.k == 1) {
            return;
        }
        if (this.d && (accessibilityManager = this.b) != null && accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.k = 1;
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            AbstractC4575vQ.B(it.next());
            throw null;
        }
        this.l = this.a.K(view, this.j).setInterpolator(this.i).setDuration(this.g).setListener(new U0(this, 4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4826yg
    public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
        return i == 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void s(int i) {
        C3995nv c3995nv;
        AbstractC4817ya0 abstractC4817ya0 = this.a;
        if (abstractC4817ya0 == null || abstractC4817ya0.J() != i) {
            if (i == 0) {
                c3995nv = new C3995nv(2);
            } else if (i == 1) {
                c3995nv = new C3995nv(0);
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException(AbstractC4575vQ.n(i, "Invalid view edge position value: ", ". Must be 0, 1 or 2."));
                }
                c3995nv = new C3995nv(1);
            }
            this.a = c3995nv;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void t(View view) {
        if (this.k == 2) {
            return;
        }
        ViewPropertyAnimator viewPropertyAnimator = this.l;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.k = 2;
        Iterator it = this.e.iterator();
        if (it.hasNext()) {
            AbstractC4575vQ.B(it.next());
            throw null;
        }
        this.a.getClass();
        this.l = this.a.K(view, 0).setInterpolator(this.h).setDuration(this.f).setListener(new U0(this, 4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
    }
}
