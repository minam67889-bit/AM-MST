package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import defpackage.AbstractC2925e20;
import defpackage.C3450kd;
import defpackage.C3604ma;
import defpackage.C3726o5;

/* loaded from: classes.dex */
public class CheckableImageButton extends C3726o5 implements Checkable {
    public static final int[] g = {R.attr.state_checked};
    public boolean d;
    public boolean e;
    public boolean f;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dastan.prince.bdfreevpn.R.attr.imageButtonStyle);
        this.e = true;
        this.f = true;
        AbstractC2925e20.m(this, new C3604ma(this, 1));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.d;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.d ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), g) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof C3450kd)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C3450kd c3450kd = (C3450kd) parcelable;
        super.onRestoreInstanceState(c3450kd.a);
        setChecked(c3450kd.c);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C3450kd c3450kd = new C3450kd(super.onSaveInstanceState());
        c3450kd.c = this.d;
        return c3450kd;
    }

    public void setCheckable(boolean z) {
        if (this.e != z) {
            this.e = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (!this.e || this.d == z) {
            return;
        }
        this.d = z;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z) {
        this.f = z;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.f) {
            super.setPressed(z);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.d);
    }
}
