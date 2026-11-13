package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import app.vpn.amtunnellite.R;

/* renamed from: wp, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4681wp extends AnimatorListenerAdapter implements WW {
    public final View a;
    public boolean b = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4681wp(View view) {
        this.a = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.WW
    public final void a(XW xw) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.WW
    public final void b() {
        float f;
        View view = this.a;
        if (view.getVisibility() == 0) {
            f = AbstractC4234r10.a.h(view);
        } else {
            f = 0.0f;
        }
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.WW
    public final void c() {
        this.a.setTag(R.id.transition_pause_alpha, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.WW
    public final void d(XW xw) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.WW
    public final void e(XW xw) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.WW
    public final void f(XW xw) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        AbstractC4234r10.a.i(this.a, 1.0f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.b = true;
            view.setLayerType(2, null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        boolean z2 = this.b;
        View view = this.a;
        if (z2) {
            view.setLayerType(0, null);
        }
        if (z) {
            return;
        }
        C4850z10 c4850z10 = AbstractC4234r10.a;
        c4850z10.i(view, 1.0f);
        c4850z10.getClass();
    }
}
