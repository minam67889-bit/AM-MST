package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import defpackage.C0616Xc;
import defpackage.C3167d5;
import defpackage.T00;
import defpackage.V9;

/* loaded from: classes.dex */
public class CheckableImageButton extends C3167d5 implements Checkable {
    public static final int[] g = {R.attr.state_checked};
    public boolean d;
    public boolean e;
    public boolean f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, app.vpn.amtunnellite.R.attr.imageButtonStyle);
        this.e = true;
        this.f = true;
        T00.l(this, new V9(this, 1));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.d ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), g) : super.onCreateDrawableState(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C0616Xc)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0616Xc c0616Xc = (C0616Xc) parcelable;
        super.onRestoreInstanceState(c0616Xc.a);
        setChecked(c0616Xc.c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0616Xc c0616Xc = new C0616Xc(super.onSaveInstanceState());
        c0616Xc.c = this.d;
        return c0616Xc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCheckable(boolean z) {
        if (this.e != z) {
            this.e = z;
            sendAccessibilityEvent(0);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.e || this.d == z) {
            return;
        }
        this.d = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setPressable(boolean z) {
        this.f = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f) {
            super.setPressed(z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.d);
    }
}
