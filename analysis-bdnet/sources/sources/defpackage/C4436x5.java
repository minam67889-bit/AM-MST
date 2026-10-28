package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import dastan.prince.bdfreevpn.R;

/* renamed from: x5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4436x5 extends ML {
    public final C4357w5 j;
    public Drawable k;
    public ColorStateList l;
    public PorterDuff.Mode m;
    public boolean n;
    public boolean o;

    public C4436x5(C4357w5 c4357w5) {
        super(c4357w5);
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.j = c4357w5;
    }

    public final void C() {
        Drawable drawable = this.k;
        if (drawable != null) {
            if (this.n || this.o) {
                Drawable mutate = drawable.mutate();
                this.k = mutate;
                if (this.n) {
                    mutate.setTintList(this.l);
                }
                if (this.o) {
                    this.k.setTintMode(this.m);
                }
                if (this.k.isStateful()) {
                    this.k.setState(this.j.getDrawableState());
                }
            }
        }
    }

    public final void D(Canvas canvas) {
        if (this.k != null) {
            int max = this.j.getMax();
            if (max > 1) {
                int intrinsicWidth = this.k.getIntrinsicWidth();
                int intrinsicHeight = this.k.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.k.setBounds(-i, -i2, i, i2);
                float width = ((r0.getWidth() - r0.getPaddingLeft()) - r0.getPaddingRight()) / max;
                int save = canvas.save();
                canvas.translate(r0.getPaddingLeft(), r0.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.k.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // defpackage.ML
    public final void n(AttributeSet attributeSet, int i) {
        super.n(attributeSet, R.attr.seekBarStyle);
        C4357w5 c4357w5 = this.j;
        Context context = c4357w5.getContext();
        int[] iArr = GM.g;
        C4452xG n = C4452xG.n(context, attributeSet, iArr, R.attr.seekBarStyle);
        AbstractC2925e20.l(c4357w5, c4357w5.getContext(), iArr, attributeSet, (TypedArray) n.c, R.attr.seekBarStyle);
        Drawable j = n.j(0);
        if (j != null) {
            c4357w5.setThumb(j);
        }
        Drawable i2 = n.i(1);
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.k = i2;
        if (i2 != null) {
            i2.setCallback(c4357w5);
            i2.setLayoutDirection(c4357w5.getLayoutDirection());
            if (i2.isStateful()) {
                i2.setState(c4357w5.getDrawableState());
            }
            C();
        }
        c4357w5.invalidate();
        TypedArray typedArray = (TypedArray) n.c;
        if (typedArray.hasValue(3)) {
            this.m = AbstractC0540Ul.c(typedArray.getInt(3, -1), this.m);
            this.o = true;
        }
        if (typedArray.hasValue(2)) {
            this.l = n.h(2);
            this.n = true;
        }
        n.q();
        C();
    }
}
