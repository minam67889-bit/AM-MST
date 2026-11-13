package defpackage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import com.google.android.material.textfield.TextInputLayout;
import java.util.ArrayList;

/* renamed from: ww, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4688ww {
    public ColorStateList A;
    public Typeface B;
    public final int a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final Context g;
    public final TextInputLayout h;
    public LinearLayout i;
    public int j;
    public FrameLayout k;
    public Animator l;
    public final float m;
    public int n;
    public int o;
    public CharSequence p;
    public boolean q;
    public I5 r;
    public CharSequence s;
    public int t;
    public int u;
    public ColorStateList v;
    public CharSequence w;
    public boolean x;
    public I5 y;
    public int z;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4688ww(TextInputLayout textInputLayout) {
        Context context = textInputLayout.getContext();
        this.g = context;
        this.h = textInputLayout;
        this.m = context.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
        this.a = AbstractC0363Nj.z(context, R.attr.motionDurationShort4, 217);
        this.b = AbstractC0363Nj.z(context, R.attr.motionDurationMedium4, 167);
        this.c = AbstractC0363Nj.z(context, R.attr.motionDurationShort4, 167);
        this.d = AbstractC0363Nj.A(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, AbstractC3778l4.d);
        LinearInterpolator linearInterpolator = AbstractC3778l4.a;
        this.e = AbstractC0363Nj.A(context, R.attr.motionEasingEmphasizedDecelerateInterpolator, linearInterpolator);
        this.f = AbstractC0363Nj.A(context, R.attr.motionEasingLinearInterpolator, linearInterpolator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(TextView textView, int i) {
        if (this.i == null && this.k == null) {
            Context context = this.g;
            LinearLayout linearLayout = new LinearLayout(context);
            this.i = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.i;
            TextInputLayout textInputLayout = this.h;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.k = new FrameLayout(context);
            this.i.addView(this.k, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i != 0 && i != 1) {
            this.i.addView(textView, new LinearLayout.LayoutParams(-2, -2));
        } else {
            this.k.setVisibility(0);
            this.k.addView(textView);
        }
        this.i.setVisibility(0);
        this.j++;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b() {
        if (this.i != null) {
            TextInputLayout textInputLayout = this.h;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.g;
                boolean x0 = AbstractC3411gE.x0(context);
                LinearLayout linearLayout = this.i;
                int paddingStart = editText.getPaddingStart();
                if (x0) {
                    paddingStart = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_default_padding_top);
                if (x0) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_top);
                }
                int paddingEnd = editText.getPaddingEnd();
                if (x0) {
                    paddingEnd = context.getResources().getDimensionPixelSize(R.dimen.material_helper_text_font_1_3_padding_horizontal);
                }
                linearLayout.setPaddingRelative(paddingStart, dimensionPixelSize, paddingEnd, 0);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c() {
        Animator animator = this.l;
        if (animator != null) {
            animator.cancel();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(ArrayList arrayList, boolean z, TextView textView, int i, int i2, int i3) {
        boolean z2;
        float f;
        long j;
        TimeInterpolator timeInterpolator;
        if (textView != null && z) {
            if (i == i3 || i == i2) {
                if (i3 == i) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, f);
                int i4 = this.c;
                if (z2) {
                    j = this.b;
                } else {
                    j = i4;
                }
                ofFloat.setDuration(j);
                if (z2) {
                    timeInterpolator = this.e;
                } else {
                    timeInterpolator = this.f;
                }
                ofFloat.setInterpolator(timeInterpolator);
                if (i == i3 && i2 != 0) {
                    ofFloat.setStartDelay(i4);
                }
                arrayList.add(ofFloat);
                if (i3 == i && i2 != 0) {
                    ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.m, 0.0f);
                    ofFloat2.setDuration(this.a);
                    ofFloat2.setInterpolator(this.d);
                    ofFloat2.setStartDelay(i4);
                    arrayList.add(ofFloat2);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TextView e(int i) {
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return this.y;
        }
        return this.r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f() {
        int i;
        this.p = null;
        c();
        if (this.n == 1) {
            if (this.x && !TextUtils.isEmpty(this.w)) {
                i = 2;
            } else {
                i = 0;
            }
            this.o = i;
        }
        i(this.n, h(this.r, ""), this.o);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g(TextView textView, int i) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.i;
        if (linearLayout == null) {
            return;
        }
        if ((i == 0 || i == 1) && (frameLayout = this.k) != null) {
            frameLayout.removeView(textView);
        } else {
            linearLayout.removeView(textView);
        }
        int i2 = this.j - 1;
        this.j = i2;
        LinearLayout linearLayout2 = this.i;
        if (i2 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean h(TextView textView, CharSequence charSequence) {
        TextInputLayout textInputLayout = this.h;
        if (textInputLayout.isLaidOut() && textInputLayout.isEnabled() && (this.o != this.n || textView == null || !TextUtils.equals(textView.getText(), charSequence))) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void i(int i, boolean z, int i2) {
        TextView e;
        TextView e2;
        if (i == i2) {
            return;
        }
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.l = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.x, this.y, 2, i, i2);
            d(arrayList, this.q, this.r, 1, i, i2);
            AbstractC0363Nj.u(animatorSet, arrayList);
            animatorSet.addListener(new C4534uw(this, i2, e(i), i, e(i2)));
            animatorSet.start();
        } else if (i != i2) {
            if (i2 != 0 && (e2 = e(i2)) != null) {
                e2.setVisibility(0);
                e2.setAlpha(1.0f);
            }
            if (i != 0 && (e = e(i)) != null) {
                e.setVisibility(4);
                if (i == 1) {
                    e.setText((CharSequence) null);
                }
            }
            this.n = i2;
        }
        TextInputLayout textInputLayout = this.h;
        textInputLayout.t();
        textInputLayout.w(z, false);
        textInputLayout.z();
    }
}
