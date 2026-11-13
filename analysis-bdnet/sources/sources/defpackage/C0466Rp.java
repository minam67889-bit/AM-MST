package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import dastan.prince.bdfreevpn.R;

/* renamed from: Rp, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0466Rp extends AnimatorListenerAdapter implements SX {
    public final View a;
    public boolean b = false;

    public C0466Rp(View view) {
        this.a = view;
    }

    @Override // defpackage.SX
    public final void a(TX tx) {
    }

    @Override // defpackage.SX
    public final void b() {
        View view = this.a;
        view.setTag(R.id.transition_pause_alpha, Float.valueOf(view.getVisibility() == 0 ? E20.a.l(view) : 0.0f));
    }

    @Override // defpackage.SX
    public final void c() {
        this.a.setTag(R.id.transition_pause_alpha, null);
    }

    @Override // defpackage.SX
    public final void d(TX tx) {
    }

    @Override // defpackage.SX
    public final void e(TX tx) {
    }

    @Override // defpackage.SX
    public final void f(TX tx) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        E20.a.m(this.a, 1.0f);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        onAnimationEnd(animator, false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        View view = this.a;
        if (view.hasOverlappingRendering() && view.getLayerType() == 0) {
            this.b = true;
            view.setLayerType(2, null);
        }
    }

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
        M20 m20 = E20.a;
        m20.m(view, 1.0f);
        m20.getClass();
    }
}
