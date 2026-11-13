package com.google.android.material.divider;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC3411gE;
import defpackage.AbstractC4702x40;
import defpackage.AbstractC4817ya0;
import defpackage.CL;
import defpackage.UD;

/* loaded from: classes.dex */
public class MaterialDivider extends View {
    public final UD a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialDivider(Context context, AttributeSet attributeSet) {
        super(AbstractC4817ya0.f0(context, attributeSet, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider), attributeSet, R.attr.materialDividerStyle);
        Context context2 = getContext();
        this.a = new UD();
        TypedArray B = AbstractC4702x40.B(context2, attributeSet, CL.r, R.attr.materialDividerStyle, R.style.Widget_MaterialComponents_MaterialDivider, new int[0]);
        this.b = B.getDimensionPixelSize(3, getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.d = B.getDimensionPixelOffset(2, 0);
        this.e = B.getDimensionPixelOffset(1, 0);
        setDividerColor(AbstractC3411gE.d0(context2, B, 0).getDefaultColor());
        B.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerColor() {
        return this.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerInsetEnd() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerInsetStart() {
        return this.d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDividerThickness() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        int width;
        int i;
        super.onDraw(canvas);
        boolean z = getLayoutDirection() == 1;
        int i2 = z ? this.e : this.d;
        if (z) {
            width = getWidth();
            i = this.d;
        } else {
            width = getWidth();
            i = this.e;
        }
        int i3 = width - i;
        UD ud = this.a;
        ud.setBounds(i2, 0, i3, getBottom() - getTop());
        ud.draw(canvas);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        int measuredHeight = getMeasuredHeight();
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.b;
            if (i3 > 0 && measuredHeight != i3) {
                measuredHeight = i3;
            }
            setMeasuredDimension(getMeasuredWidth(), measuredHeight);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerColor(int i) {
        if (this.c != i) {
            this.c = i;
            this.a.o(ColorStateList.valueOf(i));
            invalidate();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerColorResource(int i) {
        setDividerColor(getContext().getColor(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetEnd(int i) {
        this.e = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetEndResource(int i) {
        setDividerInsetEnd(getContext().getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetStart(int i) {
        this.d = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerInsetStartResource(int i) {
        setDividerInsetStart(getContext().getResources().getDimensionPixelOffset(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerThickness(int i) {
        if (this.b != i) {
            this.b = i;
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDividerThicknessResource(int i) {
        setDividerThickness(getContext().getResources().getDimensionPixelSize(i));
    }
}
