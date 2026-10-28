package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;

/* renamed from: g5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3397g5 extends MultiAutoCompleteTextView {
    public static final int[] d = {R.attr.popupBackground};
    public final C4855z4 a;
    public final E5 b;
    public final QK c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3397g5(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, app.vpn.amtunnellite.R.attr.autoCompleteTextViewStyle);
        AbstractC3812lW.a(context);
        QV.a(this, getContext());
        LQ j = LQ.j(app.vpn.amtunnellite.R.attr.autoCompleteTextViewStyle, 0, getContext(), attributeSet, d);
        if (((TypedArray) j.b).hasValue(0)) {
            setDropDownBackgroundDrawable(j.e(0));
        }
        j.m();
        C4855z4 c4855z4 = new C4855z4(this);
        this.a = c4855z4;
        c4855z4.u(attributeSet, app.vpn.amtunnellite.R.attr.autoCompleteTextViewStyle);
        E5 e5 = new E5(this);
        this.b = e5;
        e5.f(attributeSet, app.vpn.amtunnellite.R.attr.autoCompleteTextViewStyle);
        e5.b();
        QK qk = new QK(this, 10);
        this.c = qk;
        qk.s(attributeSet, app.vpn.amtunnellite.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = isFocusable();
            boolean isClickable = isClickable();
            boolean isLongClickable = isLongClickable();
            int inputType = getInputType();
            KeyListener o = qk.o(keyListener);
            if (o != keyListener) {
                super.setKeyListener(o);
                setRawInputType(inputType);
                setFocusable(isFocusable);
                setClickable(isClickable);
                setLongClickable(isLongClickable);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.b();
        }
        E5 e5 = this.b;
        if (e5 != null) {
            e5.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSupportBackgroundTintList() {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            return c4855z4.s();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            return c4855z4.t();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.d();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.e();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC0427Pv.H(onCreateInputConnection, editorInfo, this);
        return this.c.t(onCreateInputConnection, editorInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.v();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.w(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E5 e5 = this.b;
        if (e5 != null) {
            e5.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E5 e5 = this.b;
        if (e5 != null) {
            e5.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(AbstractC4766xx.D(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEmojiCompatEnabled(boolean z) {
        this.c.z(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.c.o(keyListener));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.y(colorStateList);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C4855z4 c4855z4 = this.a;
        if (c4855z4 != null) {
            c4855z4.z(mode);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        E5 e5 = this.b;
        e5.l(colorStateList);
        e5.b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        E5 e5 = this.b;
        e5.m(mode);
        e5.b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        E5 e5 = this.b;
        if (e5 != null) {
            e5.g(context, i);
        }
    }
}
