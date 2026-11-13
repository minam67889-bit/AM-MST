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
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

/* loaded from: classes.dex */
public class J4 extends AutoCompleteTextView {
    public static final int[] d = {R.attr.popupBackground};
    public final K4 a;
    public final P5 b;
    public final ML c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public J4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dastan.prince.bdfreevpn.R.attr.autoCompleteTextViewStyle);
        AbstractC2884dX.a(context);
        JW.a(this, getContext());
        C4452xG n = C4452xG.n(getContext(), attributeSet, d, dastan.prince.bdfreevpn.R.attr.autoCompleteTextViewStyle);
        if (((TypedArray) n.c).hasValue(0)) {
            setDropDownBackgroundDrawable(n.i(0));
        }
        n.q();
        K4 k4 = new K4(this);
        this.a = k4;
        k4.q(attributeSet, dastan.prince.bdfreevpn.R.attr.autoCompleteTextViewStyle);
        P5 p5 = new P5(this);
        this.b = p5;
        p5.f(attributeSet, dastan.prince.bdfreevpn.R.attr.autoCompleteTextViewStyle);
        p5.b();
        ML ml = new ML((EditText) this, 10);
        this.c = ml;
        ml.n(attributeSet, dastan.prince.bdfreevpn.R.attr.autoCompleteTextViewStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = super.isFocusable();
        boolean isClickable = super.isClickable();
        boolean isLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener m = ml.m(keyListener);
        if (m == keyListener) {
            return;
        }
        super.setKeyListener(m);
        super.setRawInputType(inputType);
        super.setFocusable(isFocusable);
        super.setClickable(isClickable);
        super.setLongClickable(isLongClickable);
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        K4 k4 = this.a;
        if (k4 != null) {
            k4.a();
        }
        P5 p5 = this.b;
        if (p5 != null) {
            p5.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0538Uj.g0(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        K4 k4 = this.a;
        if (k4 != null) {
            return k4.o();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        K4 k4 = this.a;
        if (k4 != null) {
            return k4.p();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.e();
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC3634my.w(editorInfo, onCreateInputConnection, this);
        return this.c.o(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        K4 k4 = this.a;
        if (k4 != null) {
            k4.r();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        K4 k4 = this.a;
        if (k4 != null) {
            k4.s(i);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        P5 p5 = this.b;
        if (p5 != null) {
            p5.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        P5 p5 = this.b;
        if (p5 != null) {
            p5.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0538Uj.j0(callback, this));
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(XE.k(getContext(), i));
    }

    public void setEmojiCompatEnabled(boolean z) {
        this.c.w(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.c.m(keyListener));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        K4 k4 = this.a;
        if (k4 != null) {
            k4.u(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        K4 k4 = this.a;
        if (k4 != null) {
            k4.v(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        P5 p5 = this.b;
        p5.l(colorStateList);
        p5.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        P5 p5 = this.b;
        p5.m(mode);
        p5.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        P5 p5 = this.b;
        if (p5 != null) {
            p5.g(context, i);
        }
    }
}
