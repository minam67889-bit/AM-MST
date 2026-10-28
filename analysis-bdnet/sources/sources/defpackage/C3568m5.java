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
import dastan.prince.bdfreevpn.R;

/* renamed from: m5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3568m5 extends EditText implements InterfaceC3347jJ {
    public final K4 a;
    public final P5 b;
    public final ML c;
    public final HW d;
    public final ML e;
    public C3488l5 f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3568m5(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.editTextStyle);
        AbstractC2884dX.a(context);
        JW.a(this, getContext());
        K4 k4 = new K4(this);
        this.a = k4;
        k4.q(attributeSet, R.attr.editTextStyle);
        P5 p5 = new P5(this);
        this.b = p5;
        p5.f(attributeSet, R.attr.editTextStyle);
        p5.b();
        ML ml = new ML(11, false);
        ml.b = this;
        this.c = ml;
        this.d = new HW();
        ML ml2 = new ML((EditText) this, 10);
        this.e = ml2;
        ml2.n(attributeSet, R.attr.editTextStyle);
        KeyListener keyListener = getKeyListener();
        if (keyListener instanceof NumberKeyListener) {
            return;
        }
        boolean isFocusable = super.isFocusable();
        boolean isClickable = super.isClickable();
        boolean isLongClickable = super.isLongClickable();
        int inputType = super.getInputType();
        KeyListener m = ml2.m(keyListener);
        if (m == keyListener) {
            return;
        }
        super.setKeyListener(m);
        super.setRawInputType(inputType);
        super.setFocusable(isFocusable);
        super.setClickable(isClickable);
        super.setLongClickable(isLongClickable);
    }

    private C3488l5 getSuperCaller() {
        if (this.f == null) {
            this.f = new C3488l5(this);
        }
        return this.f;
    }

    @Override // defpackage.InterfaceC3347jJ
    public final C0042Bg a(C0042Bg c0042Bg) {
        this.d.getClass();
        return HW.a(this, c0042Bg);
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

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        ML ml;
        if (Build.VERSION.SDK_INT >= 28 || (ml = this.c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) ml.c;
        return textClassifier == null ? J5.a((TextView) ml.b) : textClassifier;
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
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        int i;
        String[] g;
        String[] stringArray;
        InputConnection c3949qx;
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.b.getClass();
        P5.h(editorInfo, onCreateInputConnection, this);
        AbstractC3634my.w(editorInfo, onCreateInputConnection, this);
        if (onCreateInputConnection != null && (i = Build.VERSION.SDK_INT) <= 30 && (g = AbstractC2925e20.g(this)) != null) {
            if (i >= 25) {
                editorInfo.contentMimeTypes = g;
            } else {
                if (editorInfo.extras == null) {
                    editorInfo.extras = new Bundle();
                }
                editorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", g);
                editorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", g);
            }
            C3290ic c3290ic = new C3290ic(this, 15);
            if (i >= 25) {
                c3949qx = new C3870px(onCreateInputConnection, c3290ic);
            } else {
                String[] strArr = AbstractC0731aZ.e;
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
                        c3949qx = new C3949qx(onCreateInputConnection, c3290ic);
                    }
                }
            }
            onCreateInputConnection = c3949qx;
        }
        return this.e.o(onCreateInputConnection, editorInfo);
    }

    @Override // android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        int i = Build.VERSION.SDK_INT;
        if (i < 30 || i >= 33) {
            return;
        }
        ((InputMethodManager) getContext().getSystemService("input_method")).isActive(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onDragEvent(DragEvent dragEvent) {
        Activity activity;
        boolean z = false;
        if (Build.VERSION.SDK_INT < 31 && dragEvent.getLocalState() == null && AbstractC2925e20.g(this) != null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    activity = null;
                    break;
                }
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (activity == null) {
                Log.i("ReceiveContent", "Can't handle drop: no activity: view=" + this);
            } else if (dragEvent.getAction() != 1 && dragEvent.getAction() == 3) {
                z = AbstractC4278v5.a(dragEvent, this, activity);
            }
        }
        if (z) {
            return true;
        }
        return super.onDragEvent(dragEvent);
    }

    @Override // android.widget.EditText, android.widget.TextView
    public final boolean onTextContextMenuItem(int i) {
        InterfaceC4563yg interfaceC4563yg;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 31 || AbstractC2925e20.g(this) == null || !(i == 16908322 || i == 16908337)) {
            return super.onTextContextMenuItem(i);
        }
        ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
        ClipData primaryClip = clipboardManager == null ? null : clipboardManager.getPrimaryClip();
        if (primaryClip != null && primaryClip.getItemCount() > 0) {
            if (i2 >= 31) {
                interfaceC4563yg = new C0136Ew(primaryClip, 1);
            } else {
                C4642zg c4642zg = new C4642zg();
                c4642zg.b = primaryClip;
                c4642zg.c = 1;
                interfaceC4563yg = c4642zg;
            }
            interfaceC4563yg.d(i == 16908322 ? 0 : 1);
            AbstractC2925e20.i(this, interfaceC4563yg.build());
        }
        return true;
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
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
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

    public void setEmojiCompatEnabled(boolean z) {
        this.e.w(z);
    }

    @Override // android.widget.TextView
    public void setKeyListener(KeyListener keyListener) {
        super.setKeyListener(this.e.m(keyListener));
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

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        ML ml;
        if (Build.VERSION.SDK_INT >= 28 || (ml = this.c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            ml.c = textClassifier;
        }
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        return Build.VERSION.SDK_INT >= 28 ? super.getText() : super.getEditableText();
    }
}
