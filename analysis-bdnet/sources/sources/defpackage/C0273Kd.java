package defpackage;

import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import android.widget.EditText;
import dastan.prince.bdfreevpn.R;

/* renamed from: Kd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0273Kd extends AbstractC4176to {
    public final int e;
    public final int f;
    public final TimeInterpolator g;
    public final TimeInterpolator h;
    public EditText i;
    public final ViewOnClickListenerC0169Gd j;
    public final ViewOnFocusChangeListenerC0195Hd k;
    public AnimatorSet l;
    public ValueAnimator m;

    public C0273Kd(C4097so c4097so) {
        super(c4097so);
        this.j = new ViewOnClickListenerC0169Gd(this, 0);
        this.k = new ViewOnFocusChangeListenerC0195Hd(this, 0);
        this.e = AbstractC0731aZ.a0(c4097so.getContext(), R.attr.motionDurationShort3, 100);
        this.f = AbstractC0731aZ.a0(c4097so.getContext(), R.attr.motionDurationShort3, 150);
        this.g = AbstractC0731aZ.b0(c4097so.getContext(), R.attr.motionEasingLinearInterpolator, AbstractC4434x4.a);
        this.h = AbstractC0731aZ.b0(c4097so.getContext(), R.attr.motionEasingEmphasizedInterpolator, AbstractC4434x4.d);
    }

    @Override // defpackage.AbstractC4176to
    public final void a() {
        if (this.b.p != null) {
            return;
        }
        t(u());
    }

    @Override // defpackage.AbstractC4176to
    public final int c() {
        return R.string.clear_text_end_icon_content_description;
    }

    @Override // defpackage.AbstractC4176to
    public final int d() {
        return R.drawable.mtrl_ic_cancel;
    }

    @Override // defpackage.AbstractC4176to
    public final View.OnFocusChangeListener e() {
        return this.k;
    }

    @Override // defpackage.AbstractC4176to
    public final View.OnClickListener f() {
        return this.j;
    }

    @Override // defpackage.AbstractC4176to
    public final View.OnFocusChangeListener g() {
        return this.k;
    }

    @Override // defpackage.AbstractC4176to
    public final void m(EditText editText) {
        this.i = editText;
        this.a.setEndIconVisible(u());
    }

    @Override // defpackage.AbstractC4176to
    public final void p(boolean z) {
        if (this.b.p == null) {
            return;
        }
        t(z);
    }

    @Override // defpackage.AbstractC4176to
    public final void r() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.8f, 1.0f);
        ofFloat.setInterpolator(this.h);
        ofFloat.setDuration(this.f);
        ofFloat.addUpdateListener(new C0221Id(this, 1));
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        ofFloat2.setInterpolator(timeInterpolator);
        int i = this.e;
        ofFloat2.setDuration(i);
        ofFloat2.addUpdateListener(new C0221Id(this, 0));
        AnimatorSet animatorSet = new AnimatorSet();
        this.l = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2);
        this.l.addListener(new C0247Jd(this, 0));
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat3.setInterpolator(timeInterpolator);
        ofFloat3.setDuration(i);
        ofFloat3.addUpdateListener(new C0221Id(this, 0));
        this.m = ofFloat3;
        ofFloat3.addListener(new C0247Jd(this, 1));
    }

    @Override // defpackage.AbstractC4176to
    public final void s() {
        EditText editText = this.i;
        if (editText != null) {
            editText.post(new RunnableC3954r1(this, 3));
        }
    }

    public final void t(boolean z) {
        boolean z2 = this.b.d() == z;
        if (z && !this.l.isRunning()) {
            this.m.cancel();
            this.l.start();
            if (z2) {
                this.l.end();
                return;
            }
            return;
        }
        if (z) {
            return;
        }
        this.l.cancel();
        this.m.start();
        if (z2) {
            this.m.end();
        }
    }

    public final boolean u() {
        EditText editText = this.i;
        if (editText != null) {
            return (editText.hasFocus() || this.d.hasFocus()) && this.i.getText().length() > 0;
        }
        return false;
    }
}
