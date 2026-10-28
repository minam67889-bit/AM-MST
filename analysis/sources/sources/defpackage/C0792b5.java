package defpackage;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;
import android.view.DragEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import android.widget.TextView;
import app.vpn.amtunnellite.R;

/* renamed from: b5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0792b5 extends EditText implements InterfaceC3644jI {
    public final C4855z4 a;
    public final E5 b;
    public final QK c;
    public final OV d;
    public final QK e;
    public C0703a5 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C0792b5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.editTextStyle);
        AbstractC3812lW.a(context);
        QV.a(this, getContext());
        C4855z4 c4855z4 = new C4855z4(this);
        this.a = c4855z4;
        c4855z4.u(attributeSet, R.attr.editTextStyle);
        E5 e5 = new E5(this);
        this.b = e5;
        e5.f(attributeSet, R.attr.editTextStyle);
        e5.b();
        QK qk = new QK(11, false);
        qk.b = this;
        this.c = qk;
        this.d = new OV();
        QK qk2 = new QK(this, 10);
        this.e = qk2;
        qk2.s(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (!(keyListener instanceof NumberKeyListener)) {
            boolean isFocusable = super.isFocusable();
            boolean isClickable = super.isClickable();
            boolean isLongClickable = super.isLongClickable();
            int inputType = super.getInputType();
            KeyListener o = qk2.o(keyListener);
            if (o != keyListener) {
                super.setKeyListener(o);
                super.setRawInputType(inputType);
                super.setFocusable(isFocusable);
                super.setClickable(isClickable);
                super.setLongClickable(isLongClickable);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C0703a5 getSuperCaller() {
        if (this.f == null) {
            this.f = new C0703a5(this);
        }
        return this.f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC3644jI
    public final C3903mg a(C3903mg c3903mg) {
        this.d.getClass();
        return OV.a(this, c3903mg);
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
    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return AbstractC0440Qi.Q(super.getCustomSelectionActionModeCallback());
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
    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        QK qk;
        if (Build.VERSION.SDK_INT < 28 && (qk = this.c) != null) {
            TextClassifier textClassifier = (TextClassifier) qk.c;
            if (textClassifier == null) {
                return AbstractC4780y5.a((TextView) qk.b);
            }
            return textClassifier;
        }
        return super.getTextClassifier();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0056, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
    
        r6 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006b, code lost:
    
        if (r1 != null) goto L23;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        String[] f;
        String[] stringArray;
        InputConnection c0039Aw;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.b.getClass();
        E5.h(this, onCreateInputConnection, editorInfo);
        AbstractC0427Pv.H(onCreateInputConnection, editorInfo, this);
        if (onCreateInputConnection != null && (i = Build.VERSION.SDK_INT) <= 30 && (f = T00.f(this)) != null) {
            if (i >= 25) {
                editorInfo.contentMimeTypes = f;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", f);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", f);
            }
            C0384Oe c0384Oe = new C0384Oe(this, 10);
            if (i >= 25) {
                c0039Aw = new C4919zw(onCreateInputConnection, c0384Oe);
            } else {
                String[] strArr = AbstractC3354fY.j;
                if (i >= 25) {
                    stringArray = editorInfo.contentMimeTypes;
                } else {
                    Bundle bundle = editorInfo.extras;
                    if (bundle != null) {
                        stringArray = bundle.getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        if (stringArray == null) {
                            stringArray = editorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
                        }
                    }
                    if (strArr.length != 0) {
                        c0039Aw = new C0039Aw(onCreateInputConnection, c0384Oe);
                    }
                }
            }
            onCreateInputConnection = c0039Aw;
        }
        return this.e.t(onCreateInputConnection, editorInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 && i < 33) {
            ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && T00.f(this) != null) {
            Context context = getContext();
            while (true) {
                if (context instanceof ContextWrapper) {
                    if (context instanceof Activity) {
                        activity = (Activity) context;
                        break;
                    }
                    context = ((ContextWrapper) context).getBaseContext();
                } else {
                    activity = null;
                    break;
                }
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = AbstractC3703k5.a(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        ClipData primaryClip;
        InterfaceC3672jg interfaceC3672jg;
        int i2;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 31 && T00.f(this) != null && (i == 16908322 || i == 16908337)) {
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager == null) {
                primaryClip = null;
            } else {
                primaryClip = clipboardManager.getPrimaryClip();
            }
            if (primaryClip != null && primaryClip.getItemCount() > 0) {
                if (i3 >= 31) {
                    interfaceC3672jg = new C4532uu(primaryClip, 1);
                } else {
                    C3749kg c3749kg = new C3749kg();
                    c3749kg.b = primaryClip;
                    c3749kg.c = 1;
                    interfaceC3672jg = c3749kg;
                }
                if (i == 16908322) {
                    i2 = 0;
                } else {
                    i2 = 1;
                }
                interfaceC3672jg.s(i2);
                T00.h(this, interfaceC3672jg.build());
            }
            return true;
        }
        return super.onTextContextMenuItem(i);
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
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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
    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(AbstractC0440Qi.R(callback, this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setEmojiCompatEnabled(boolean z) {
        this.e.z(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.e.o(keyListener));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        QK qk;
        if (Build.VERSION.SDK_INT >= 28 || (qk = this.c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            qk.c = textClassifier;
        }
    }
}
