package defpackage;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import app.vpn.amtunnellite.R;

/* renamed from: wd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4668wd extends AbstractC3297eo {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;
    public final ViewOnClickListenerC4360sd j;
    public final ViewOnFocusChangeListenerC4437td k;
    public AnimatorSet l;
    public ValueAnimator m;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4668wd(Cdo cdo) {
        super(cdo);
        this.j = new ViewOnClickListenerC4360sd(this, 0);
        this.k = new ViewOnFocusChangeListenerC4437td(this, 0);
        this.e = AbstractC0363Nj.z(cdo.getContext(), R.attr.motionDurationShort3, 100);
        this.f = AbstractC0363Nj.z(cdo.getContext(), R.attr.motionDurationShort3, 150);
        this.g = AbstractC0363Nj.A(cdo.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC3778l4.a);
        this.h = AbstractC0363Nj.A(cdo.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC3778l4.d);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void a() {
        if (this.b.p != null) {
            return;
        }
        t(u());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final View.OnClickListener f() {
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void m(EditText editText) {
        this.i = editText;
        this.a.setEndIconVisible(u());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void p(boolean z) {
        if (this.b.p == null) {
            return;
        }
        t(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.h);
        ofFloat.setDuration(this.f);
        ofFloat.addUpdateListener(new C4514ud(this, 1));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i = this.e;
        ofFloat2.setDuration(i);
        ofFloat2.addUpdateListener(new C4514ud(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.l.addListener(new C4591vd(this, 0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i);
        ofFloat3.addUpdateListener(new C4514ud(this, 0));
        this.m = ofFloat3;
        ofFloat3.addListener(new C4591vd(this, 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3297eo
    public final void s() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new RunnableC4080p1(this, 3));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void t(boolean z) {
        boolean z2;
        if (this.b.d() == z) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z2) {
                this.l.end();
                return;
            }
            return;
        }
        if (!z) {
            this.l.cancel();
            this.m.start();
            if (z2) {
                this.m.end();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean u() {
        EditText editText = this.i;
        if (editText != null && ((editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0)) {
            return true;
        }
        return false;
    }
}
