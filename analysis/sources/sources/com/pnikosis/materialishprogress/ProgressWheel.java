package com.pnikosis.materialishprogress;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import defpackage.AbstractC4493uL;
import defpackage.IK;
import defpackage.JK;

/* loaded from: classes.dex */
public class ProgressWheel extends View {
    public int a;
    public int b;
    public int c;
    public boolean d;
    public double e;
    public final double f;
    public float g;
    public boolean h;
    public long i;
    public int j;
    public int k;
    public final Paint l;
    public final Paint m;
    public RectF n;
    public float o;
    public long p;
    public boolean q;
    public float r;
    public float s;
    public boolean t;
    public final boolean u;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getBarColor() {
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getBarWidth() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getCircleRadius() {
        return this.a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getProgress() {
        if (this.t) {
            return -1.0f;
        }
        return this.r / 360.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRimColor() {
        return this.k;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRimWidth() {
        return this.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getSpinSpeed() {
        return this.o / 360.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingRight = getPaddingRight() + getPaddingLeft() + this.a;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + this.a;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingRight = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingRight = Math.min(paddingRight, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingBottom = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingBottom = Math.min(paddingBottom, size2);
        }
        setMeasuredDimension(paddingRight, paddingBottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof JK)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        JK jk = (JK) parcelable;
        super.onRestoreInstanceState(jk.getSuperState());
        this.r = jk.a;
        this.s = jk.b;
        this.t = jk.c;
        this.o = jk.d;
        this.b = jk.e;
        this.j = jk.f;
        this.c = jk.g;
        this.k = jk.h;
        this.a = jk.i;
        this.q = jk.j;
        this.d = jk.k;
        this.p = SystemClock.uptimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.p = SystemClock.uptimeMillis();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBarColor(int i) {
        this.j = i;
        a();
        if (this.t) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBarWidth(int i) {
        this.b = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCircleRadius(int i) {
        this.a = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInstantProgress(float f) {
        if (this.t) {
            this.r = 0.0f;
            this.t = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f == this.s) {
            return;
        }
        float min = Math.min(f * 360.0f, 360.0f);
        this.s = min;
        this.r = min;
        this.p = SystemClock.uptimeMillis();
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLinearProgress(boolean z) {
        this.q = z;
        if (this.t) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setProgress(float f) {
        if (this.t) {
            this.r = 0.0f;
            this.t = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        float f2 = this.s;
        if (f == f2) {
            return;
        }
        if (this.r == f2) {
            this.p = SystemClock.uptimeMillis();
        }
        this.s = Math.min(f * 360.0f, 360.0f);
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRimColor(int i) {
        this.k = i;
        a();
        if (this.t) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRimWidth(int i) {
        this.c = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSpinSpeed(float f) {
        this.o = f * 360.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 28;
        this.b = 4;
        this.c = 4;
        this.d = false;
        this.e = 0.0d;
        this.f = 460.0d;
        this.g = 0.0f;
        this.h = true;
        this.i = 0L;
        this.j = -1442840576;
        this.k = 16777215;
        this.l = new Paint();
        this.m = new Paint();
        this.n = new RectF();
        this.o = 230.0f;
        this.p = 0L;
        this.r = 0.0f;
        this.s = 0.0f;
        this.t = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4493uL.a);
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.b = (int) TypedValue.applyDimension(1, this.b, displayMetrics);
        this.c = (int) TypedValue.applyDimension(1, this.c, displayMetrics);
        int applyDimension = (int) TypedValue.applyDimension(1, this.a, displayMetrics);
        this.a = applyDimension;
        this.a = (int) obtainStyledAttributes.getDimension(3, applyDimension);
        this.d = obtainStyledAttributes.getBoolean(4, false);
        this.b = (int) obtainStyledAttributes.getDimension(2, this.b);
        this.c = (int) obtainStyledAttributes.getDimension(8, this.c);
        this.o = obtainStyledAttributes.getFloat(9, this.o / 360.0f) * 360.0f;
        this.f = obtainStyledAttributes.getInt(1, (int) this.f);
        this.j = obtainStyledAttributes.getColor(0, this.j);
        this.k = obtainStyledAttributes.getColor(7, this.k);
        this.q = obtainStyledAttributes.getBoolean(5, false);
        if (obtainStyledAttributes.getBoolean(6, false)) {
            this.p = SystemClock.uptimeMillis();
            this.t = true;
            invalidate();
        }
        obtainStyledAttributes.recycle();
        this.u = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f) != 0.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a() {
        Paint paint = this.l;
        paint.setColor(this.j);
        paint.setAntiAlias(true);
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        paint.setStrokeWidth(this.b);
        Paint paint2 = this.m;
        paint2.setColor(this.k);
        paint2.setAntiAlias(true);
        paint2.setStyle(style);
        paint2.setStrokeWidth(this.c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        float f2;
        boolean z;
        Canvas canvas2;
        RectF rectF;
        super.onDraw(canvas);
        canvas.drawArc(this.n, 360.0f, 360.0f, false, this.m);
        if (!this.u) {
            return;
        }
        boolean z2 = this.t;
        Paint paint = this.l;
        float f3 = 0.0f;
        boolean z3 = true;
        if (z2) {
            long uptimeMillis = SystemClock.uptimeMillis() - this.p;
            float f4 = (uptimeMillis * this.o) / 1000.0f;
            long j = this.i;
            if (j >= 200) {
                double d = this.e + uptimeMillis;
                this.e = d;
                double d2 = this.f;
                if (d > d2) {
                    this.e = d - d2;
                    this.i = 0L;
                    this.h = !this.h;
                }
                float cos = (((float) Math.cos(((this.e / d2) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
                if (this.h) {
                    this.g = cos * 254.0f;
                } else {
                    float f5 = (1.0f - cos) * 254.0f;
                    this.r = (this.g - f5) + this.r;
                    this.g = f5;
                }
            } else {
                this.i = j + uptimeMillis;
            }
            float f6 = this.r + f4;
            this.r = f6;
            if (f6 > 360.0f) {
                this.r = f6 - 360.0f;
            }
            this.p = SystemClock.uptimeMillis();
            float f7 = this.r - 90.0f;
            float f8 = this.g + 16.0f;
            if (isInEditMode()) {
                f = 135.0f;
                f2 = 0.0f;
            } else {
                f = f8;
                f2 = f7;
            }
            rectF = this.n;
            z = false;
            canvas2 = canvas;
        } else {
            if (this.r != this.s) {
                this.r = Math.min(this.r + (((SystemClock.uptimeMillis() - this.p) / 1000.0f) * this.o), this.s);
                this.p = SystemClock.uptimeMillis();
            } else {
                z3 = false;
            }
            float f9 = this.r;
            if (!this.q) {
                f3 = ((float) (1.0d - Math.pow(1.0f - (f9 / 360.0f), 4.0f))) * 360.0f;
                f9 = ((float) (1.0d - Math.pow(1.0f - (this.r / 360.0f), 2.0f))) * 360.0f;
            }
            if (isInEditMode()) {
                f = 360.0f;
            } else {
                f = f9;
            }
            f2 = f3 - 90.0f;
            z = false;
            canvas2 = canvas;
            rectF = this.n;
        }
        canvas2.drawArc(rectF, f2, f, z, paint);
        if (z3) {
            invalidate();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        JK jk = new JK(super.onSaveInstanceState());
        jk.a = this.r;
        jk.b = this.s;
        jk.c = this.t;
        jk.d = this.o;
        jk.e = this.b;
        jk.f = this.j;
        jk.g = this.c;
        jk.h = this.k;
        jk.i = this.a;
        jk.j = this.q;
        jk.k = this.d;
        return jk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.d) {
            int i5 = (i - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i5, (i2 - paddingBottom) - paddingTop), (this.a * 2) - (this.b * 2));
            int i6 = ((i5 - min) / 2) + paddingLeft;
            int i7 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i8 = this.b;
            this.n = new RectF(i6 + i8, i7 + i8, (i6 + min) - i8, (i7 + min) - i8);
        } else {
            int i9 = this.b;
            this.n = new RectF(paddingLeft + i9, paddingTop + i9, (i - paddingRight) - i9, (i2 - paddingBottom) - i9);
        }
        a();
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCallback(IK ik) {
    }
}
