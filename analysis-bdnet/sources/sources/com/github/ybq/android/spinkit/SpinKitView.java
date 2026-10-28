package com.github.ybq.android.spinkit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3914qU;
import defpackage.C3292id;
import defpackage.C3370jd;
import defpackage.C3430kM;
import defpackage.C4012ri;
import defpackage.C4478xd;
import defpackage.EM;
import defpackage.ZT;

/* loaded from: classes.dex */
public class SpinKitView extends ProgressBar {
    public int a;
    public AbstractC3914qU b;

    public SpinKitView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.SpinKitViewStyle, R.style.SpinKitView);
        AbstractC3914qU c4012ri;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, EM.a, R.attr.SpinKitViewStyle, R.style.SpinKitView);
        int i = ZT.B(15)[obtainStyledAttributes.getInt(1, 0)];
        this.a = obtainStyledAttributes.getColor(0, -1);
        obtainStyledAttributes.recycle();
        switch (ZT.v(i)) {
            case 0:
                c4012ri = new C4012ri(2);
                break;
            case 1:
                c4012ri = new C3370jd(2);
                break;
            case 2:
                c4012ri = new C3370jd(8);
                break;
            case 3:
                c4012ri = new C3370jd(7);
                break;
            case 4:
                c4012ri = new C3292id(4);
                break;
            case 5:
                c4012ri = new C3370jd(0);
                break;
            case 6:
                c4012ri = new C3370jd(6);
                break;
            case 7:
                c4012ri = new C4478xd(0);
                break;
            case 8:
                c4012ri = new C3370jd(1);
                break;
            case 9:
                c4012ri = new C4478xd(1);
                break;
            case 10:
                c4012ri = new C3370jd(3);
                break;
            case 11:
                c4012ri = new C3292id(5, false);
                break;
            case 12:
                c4012ri = new C3370jd(4);
                break;
            case 13:
                c4012ri = new C3430kM();
                break;
            case 14:
                c4012ri = new C3370jd(5);
                break;
            default:
                c4012ri = null;
                break;
        }
        c4012ri.e(this.a);
        setIndeterminateDrawable(c4012ri);
        setIndeterminate(true);
    }

    @Override // android.view.View
    public final void onScreenStateChanged(int i) {
        AbstractC3914qU abstractC3914qU;
        super.onScreenStateChanged(i);
        if (i != 0 || (abstractC3914qU = this.b) == null) {
            return;
        }
        abstractC3914qU.stop();
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && this.b != null && getVisibility() == 0) {
            this.b.start();
        }
    }

    public void setColor(int i) {
        this.a = i;
        AbstractC3914qU abstractC3914qU = this.b;
        if (abstractC3914qU != null) {
            abstractC3914qU.e(i);
        }
        invalidate();
    }

    @Override // android.widget.ProgressBar
    public void setIndeterminateDrawable(Drawable drawable) {
        if (!(drawable instanceof AbstractC3914qU)) {
            throw new IllegalArgumentException("this d must be instanceof Sprite");
        }
        setIndeterminateDrawable((AbstractC3914qU) drawable);
    }

    @Override // android.view.View
    public final void unscheduleDrawable(Drawable drawable) {
        super.unscheduleDrawable(drawable);
        if (drawable instanceof AbstractC3914qU) {
            ((AbstractC3914qU) drawable).stop();
        }
    }

    @Override // android.widget.ProgressBar
    public AbstractC3914qU getIndeterminateDrawable() {
        return this.b;
    }

    public void setIndeterminateDrawable(AbstractC3914qU abstractC3914qU) {
        super.setIndeterminateDrawable((Drawable) abstractC3914qU);
        this.b = abstractC3914qU;
        if (abstractC3914qU.c() == 0) {
            this.b.e(this.a);
        }
        onSizeChanged(getWidth(), getHeight(), getWidth(), getHeight());
        if (getVisibility() == 0) {
            this.b.start();
        }
    }
}
