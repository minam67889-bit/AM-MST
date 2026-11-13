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
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class D4 extends CheckedTextView {
    public final E4 a;
    public final C4855z4 b;
    public final E5 c;
    public C0869c5 d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0086 A[Catch: all -> 0x0066, TryCatch #1 {all -> 0x0066, blocks: (B:3:0x004e, B:5:0x0054, B:8:0x005a, B:9:0x007f, B:11:0x0086, B:12:0x008d, B:14:0x0094, B:21:0x0068, B:23:0x006e, B:25:0x0074), top: B:2:0x004e }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0094 A[Catch: all -> 0x0066, TRY_LEAVE, TryCatch #1 {all -> 0x0066, blocks: (B:3:0x004e, B:5:0x0054, B:8:0x005a, B:9:0x007f, B:11:0x0086, B:12:0x008d, B:14:0x0094, B:21:0x0068, B:23:0x006e, B:25:0x0074), top: B:2:0x004e }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public D4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.checkedTextViewStyle);
        int resourceId;
        int resourceId2;
        AbstractC3812lW.a(context);
        QV.a(this, getContext());
        E5 e5 = new E5(this);
        this.c = e5;
        e5.f(attributeSet, R.attr.checkedTextViewStyle);
        e5.b();
        C4855z4 c4855z4 = new C4855z4(this);
        this.b = c4855z4;
        c4855z4.u(attributeSet, R.attr.checkedTextViewStyle);
        this.a = new E4(this);
        Context context2 = getContext();
        int[] iArr = EL.l;
        LQ j = LQ.j(R.attr.checkedTextViewStyle, 0, context2, attributeSet, iArr);
        TypedArray typedArray = (TypedArray) j.b;
        T00.k(this, getContext(), iArr, attributeSet, (TypedArray) j.b, R.attr.checkedTextViewStyle);
        try {
            if (typedArray.hasValue(1) && (resourceId2 = typedArray.getResourceId(1, 0)) != 0) {
                try {
                    setCheckMarkDrawable(AbstractC4766xx.D(getContext(), resourceId2));
                } catch (Resources.NotFoundException unused) {
                }
                if (typedArray.hasValue(2)) {
                    setCheckMarkTintList(j.d(2));
                }
                if (typedArray.hasValue(3)) {
                    setCheckMarkTintMode(AbstractC0417Pl.b(typedArray.getInt(3, -1), null));
                }
                j.m();
                getEmojiTextViewHelper().a(attributeSet, R.attr.checkedTextViewStyle);
            }
            if (typedArray.hasValue(0) && (resourceId = typedArray.getResourceId(0, 0)) != 0) {
                setCheckMarkDrawable(AbstractC4766xx.D(getContext(), resourceId));
            }
            if (typedArray.hasValue(2)) {
            }
            if (typedArray.hasValue(3)) {
            }
            j.m();
            getEmojiTextViewHelper().a(attributeSet, R.attr.checkedTextViewStyle);
        } catch (Throwable th) {
            j.m();
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C0869c5 getEmojiTextViewHelper() {
        if (this.d == null) {
            this.d = new C0869c5(this);
        }
        return this.d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.CheckedTextView, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        E5 e5 = this.c;
        if (e5 != null) {
            e5.b();
        }
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            c4855z4.b();
        }
        E4 e4 = this.a;
        if (e4 != null) {
            e4.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0440Qi.Q(super.getCustomSelectionActionModeCallback());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSupportBackgroundTintList() {
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            return c4855z4.s();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            return c4855z4.t();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSupportCheckMarkTintList() {
        E4 e4 = this.a;
        if (e4 != null) {
            return e4.a;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PorterDuff.Mode getSupportCheckMarkTintMode() {
        E4 e4 = this.a;
        if (e4 != null) {
            return e4.b;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.c.d();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.c.e();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        AbstractC0427Pv.H(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setAllCaps(boolean z) {
        super.setAllCaps(z);
        getEmojiTextViewHelper().b(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            c4855z4.v();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            c4855z4.w(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(AbstractC4766xx.D(getContext(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        E5 e5 = this.c;
        if (e5 != null) {
            e5.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        E5 e5 = this.c;
        if (e5 != null) {
            e5.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0440Qi.R(callback, this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEmojiCompatEnabled(boolean z) {
        getEmojiTextViewHelper().c(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            c4855z4.y(colorStateList);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C4855z4 c4855z4 = this.b;
        if (c4855z4 != null) {
            c4855z4.z(mode);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportCheckMarkTintList(ColorStateList colorStateList) {
        E4 e4 = this.a;
        if (e4 != null) {
            e4.a = colorStateList;
            e4.c = true;
            e4.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportCheckMarkTintMode(PorterDuff.Mode mode) {
        E4 e4 = this.a;
        if (e4 != null) {
            e4.b = mode;
            e4.d = true;
            e4.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        E5 e5 = this.c;
        e5.l(colorStateList);
        e5.b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        E5 e5 = this.c;
        e5.m(mode);
        e5.b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        E5 e5 = this.c;
        if (e5 != null) {
            e5.g(context, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(Drawable drawable) {
        super.setCheckMarkDrawable(drawable);
        E4 e4 = this.a;
        if (e4 != null) {
            if (e4.e) {
                e4.e = false;
            } else {
                e4.e = true;
                e4.b();
            }
        }
    }
}
