package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public final class S20 extends AnimatorListenerAdapter implements SX {
    public final ViewGroup a;
    public final View b;
    public final View c;
    public boolean d = true;
    public final /* synthetic */ C0492Sp e;

    public S20(C0492Sp c0492Sp, ViewGroup viewGroup, View view, View view2) {
        this.e = c0492Sp;
        this.a = viewGroup;
        this.b = view;
        this.c = view2;
    }

    @Override // defpackage.SX
    public final void a(TX tx) {
    }

    @Override // defpackage.SX
    public final void b() {
    }

    @Override // defpackage.SX
    public final void c() {
    }

    @Override // defpackage.SX
    public final void d(TX tx) {
        tx.x(this);
    }

    @Override // defpackage.SX
    public final void f(TX tx) {
        if (this.d) {
            g();
        }
    }

    public final void g() {
        this.c.setTag(R.id.save_overlay_view, null);
        this.a.getOverlay().remove(this.b);
        this.d = false;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        g();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        this.a.getOverlay().remove(this.b);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        View view = this.b;
        if (view.getParent() == null) {
            this.a.getOverlay().add(view);
        } else {
            this.e.cancel();
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator, boolean z) {
        if (z) {
            View view = this.c;
            View view2 = this.b;
            view.setTag(R.id.save_overlay_view, view2);
            this.a.getOverlay().add(view2);
            this.d = true;
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator, boolean z) {
        if (z) {
            return;
        }
        g();
    }
}
