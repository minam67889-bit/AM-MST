package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.SeekBar;
import app.vpn.amtunnellite.R;

/* renamed from: m5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3857m5 extends QK {
    public final SeekBar j;
    public Drawable k;
    public ColorStateList l;
    public PorterDuff.Mode m;
    public boolean n;
    public boolean o;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3857m5(SeekBar seekBar) {
        super(seekBar);
        this.l = null;
        this.m = null;
        this.n = false;
        this.o = false;
        this.j = seekBar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void D() {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void E(Canvas canvas) {
        int i;
        if (this.k != null) {
            int max = this.j.getMax();
            int i2 = 1;
            if (max > 1) {
                int intrinsicWidth = this.k.getIntrinsicWidth();
                int intrinsicHeight = this.k.getIntrinsicHeight();
                if (intrinsicWidth >= 0) {
                    i = intrinsicWidth / 2;
                } else {
                    i = 1;
                }
                if (intrinsicHeight >= 0) {
                    i2 = intrinsicHeight / 2;
                }
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.QK
    public final void s(AttributeSet attributeSet, int i) {
        super.s(attributeSet, R.attr.seekBarStyle);
        SeekBar seekBar = this.j;
        Context context = seekBar.getContext();
        int[] iArr = EL.g;
        LQ j = LQ.j(R.attr.seekBarStyle, 0, context, attributeSet, iArr);
        T00.k(seekBar, seekBar.getContext(), iArr, attributeSet, (TypedArray) j.b, R.attr.seekBarStyle);
        Drawable f = j.f(0);
        if (f != null) {
            seekBar.setThumb(f);
        }
        Drawable e = j.e(1);
        Drawable drawable = this.k;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.k = e;
        if (e != null) {
            e.setCallback(seekBar);
            e.setLayoutDirection(seekBar.getLayoutDirection());
            if (e.isStateful()) {
                e.setState(seekBar.getDrawableState());
            }
            D();
        }
        seekBar.invalidate();
        TypedArray typedArray = (TypedArray) j.b;
        if (typedArray.hasValue(3)) {
            this.m = AbstractC0417Pl.b(typedArray.getInt(3, -1), this.m);
            this.o = true;
        }
        if (typedArray.hasValue(2)) {
            this.l = j.d(2);
            this.n = true;
        }
        j.m();
        D();
    }
}
