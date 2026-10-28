package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import dastan.prince.bdfreevpn.R;

/* renamed from: t5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4120t5 extends RadioButton implements InterfaceC3123gX {
    public final P4 a;
    public final K4 b;
    public final P5 c;
    public C3647n5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C4120t5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.radioButtonStyle);
        AbstractC2884dX.a(context);
        JW.a(this, getContext());
        P4 p4 = new P4(this);
        this.a = p4;
        p4.c(attributeSet, R.attr.radioButtonStyle);
        K4 k4 = new K4(this);
        this.b = k4;
        k4.q(attributeSet, R.attr.radioButtonStyle);
        P5 p5 = new P5(this);
        this.c = p5;
        p5.f(attributeSet, R.attr.radioButtonStyle);
        getEmojiTextViewHelper().b(attributeSet, R.attr.radioButtonStyle);
    }

    private C3647n5 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new C3647n5(this);
        }
        return this.d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        K4 k4 = this.b;
        if (k4 != null) {
            k4.a();
        }
        P5 p5 = this.c;
        if (p5 != null) {
            p5.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        K4 k4 = this.b;
        if (k4 != null) {
            return k4.o();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        K4 k4 = this.b;
        if (k4 != null) {
            return k4.p();
        }
        return null;
    }

    @Override // defpackage.InterfaceC3123gX
    public ColorStateList getSupportButtonTintList() {
        P4 p4 = this.a;
        if (p4 != null) {
            return p4.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        P4 p4 = this.a;
        if (p4 != null) {
            return p4.b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().c(z);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        K4 k4 = this.b;
        if (k4 != null) {
            k4.r();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        K4 k4 = this.b;
        if (k4 != null) {
            k4.s(i);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        P4 p4 = this.a;
        if (p4 != null) {
            if (p4.e) {
                p4.e = false;
            } else {
                p4.e = true;
                p4.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        P5 p5 = this.c;
        if (p5 != null) {
            p5.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        P5 p5 = this.c;
        if (p5 != null) {
            p5.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        K4 k4 = this.b;
        if (k4 != null) {
            k4.u(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        K4 k4 = this.b;
        if (k4 != null) {
            k4.v(mode);
        }
    }

    @Override // defpackage.InterfaceC3123gX
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        P4 p4 = this.a;
        if (p4 != null) {
            p4.a = colorStateList;
            p4.c = true;
            p4.a();
        }
    }

    @Override // defpackage.InterfaceC3123gX
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        P4 p4 = this.a;
        if (p4 != null) {
            p4.b = mode;
            p4.d = true;
            p4.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        P5 p5 = this.c;
        p5.l(colorStateList);
        p5.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        P5 p5 = this.c;
        p5.m(mode);
        p5.b();
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(XE.k(getContext(), i));
    }
}
