package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public final class O4 extends CheckedTextView {
    public final P4 a;
    public final K4 b;
    public final P5 c;
    public C3647n5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0085 A[Catch: all -> 0x0064, TryCatch #1 {all -> 0x0064, blocks: (B:3:0x004b, B:5:0x0052, B:8:0x0058, B:9:0x007e, B:11:0x0085, B:12:0x008c, B:14:0x0093, B:21:0x0067, B:23:0x006d, B:25:0x0073), top: B:2:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0093 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #1 {all -> 0x0064, blocks: (B:3:0x004b, B:5:0x0052, B:8:0x0058, B:9:0x007e, B:11:0x0085, B:12:0x008c, B:14:0x0093, B:21:0x0067, B:23:0x006d, B:25:0x0073), top: B:2:0x004b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public O4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        int resourceId;
        int resourceId2;
        AbstractC2884dX.a(context);
        JW.a(this, getContext());
        P5 p5 = new P5(this);
        this.c = p5;
        p5.f(attributeSet, R.attr.checkedTextViewStyle);
        p5.b();
        K4 k4 = new K4(this);
        this.b = k4;
        k4.q(attributeSet, R.attr.checkedTextViewStyle);
        this.a = new P4(this);
        Context context2 = getContext();
        int[] iArr = GM.l;
        C4452xG n = C4452xG.n(context2, attributeSet, iArr, R.attr.checkedTextViewStyle);
        TypedArray typedArray = (TypedArray) n.c;
        AbstractC2925e20.l(this, getContext(), iArr, attributeSet, (TypedArray) n.c, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(XE.k(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
                if (typedArray.hasValue(2)) {
                    setCheckMarkTintList(n.h(2));
                }
                if (typedArray.hasValue(3)) {
                    setCheckMarkTintMode(AbstractC0540Ul.c(typedArray.getInt(3, -1), null));
                }
                n.q();
                getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
            }
            if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(XE.k(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
            }
            if (typedArray.hasValue(3)) {
            }
            n.q();
            getEmojiTextViewHelper().b(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            n.q();
            throw th;
        }
    }

    private C3647n5 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new C3647n5(this);
        }
        return this.d;
    }

    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        P5 p5 = this.c;
        if (p5 != null) {
            p5.b();
        }
        K4 k4 = this.b;
        if (k4 != null) {
            k4.a();
        }
        P4 p4 = this.a;
        if (p4 != null) {
            p4.b();
        }
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0538Uj.g0(super.getCustomSelectionActionModeCallback());
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

    public ColorStateList getSupportCheckMarkTintList() {
        P4 p4 = this.a;
        if (p4 != null) {
            return p4.a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportCheckMarkTintMode() {
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

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC3634my.w(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
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

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        P4 p4 = this.a;
        if (p4 != null) {
            if (p4.e) {
                p4.e = false;
            } else {
                p4.e = true;
                p4.b();
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

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0538Uj.j0(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().d(z);
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

    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        P4 p4 = this.a;
        if (p4 != null) {
            p4.a = colorStateList;
            p4.c = true;
            p4.b();
        }
    }

    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        P4 p4 = this.a;
        if (p4 != null) {
            p4.b = mode;
            p4.d = true;
            p4.b();
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

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        P5 p5 = this.c;
        if (p5 != null) {
            p5.g(context, i);
        }
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(XE.k(getContext(), i));
    }
}
