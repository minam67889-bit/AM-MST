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
import defpackage.AbstractC4300vM;
import defpackage.EL;
import defpackage.FL;

/* loaded from: classes2.dex */
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
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4300vM.a);
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

    public int getBarColor() {
        return this.j;
    }

    public int getBarWidth() {
        return this.b;
    }

    public int getCircleRadius() {
        return this.a;
    }

    public float getProgress() {
        if (this.t) {
            return -1.0f;
        }
        return this.r / 360.0f;
    }

    public int getRimColor() {
        return this.k;
    }

    public int getRimWidth() {
        return this.c;
    }

    public float getSpinSpeed() {
        return this.o / 360.0f;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        canvas.drawArc(this.n, 360.0f, 360.0f, false, this.m);
        if (this.u) {
            boolean z = this.t;
            Paint paint = this.l;
            float f2 = 0.0f;
            boolean z2 = true;
            if (z) {
                long uptimeMillis = SystemClock.uptimeMillis() - this.p;
                float f3 = (uptimeMillis * this.o) / 1000.0f;
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
                        float f4 = (1.0f - cos) * 254.0f;
                        this.r = (this.g - f4) + this.r;
                        this.g = f4;
                    }
                } else {
                    this.i = j + uptimeMillis;
                }
                float f5 = this.r + f3;
                this.r = f5;
                if (f5 > 360.0f) {
                    this.r = f5 - 360.0f;
                }
                this.p = SystemClock.uptimeMillis();
                float f6 = this.r - 90.0f;
                float f7 = this.g + 16.0f;
                if (isInEditMode()) {
                    f7 = 135.0f;
                    f = 0.0f;
                } else {
                    f = f6;
                }
                canvas.drawArc(this.n, f, f7, false, paint);
            } else {
                if (this.r != this.s) {
                    this.r = Math.min(this.r + (((SystemClock.uptimeMillis() - this.p) / 1000.0f) * this.o), this.s);
                    this.p = SystemClock.uptimeMillis();
                } else {
                    z2 = false;
                }
                float f8 = this.r;
                if (!this.q) {
                    f2 = ((float) (1.0d - Math.pow(1.0f - (f8 / 360.0f), 4.0f))) * 360.0f;
                    f8 = ((float) (1.0d - Math.pow(1.0f - (this.r / 360.0f), 2.0f))) * 360.0f;
                }
                canvas.drawArc(this.n, f2 - 90.0f, isInEditMode() ? 360.0f : f8, false, paint);
            }
            if (z2) {
                invalidate();
            }
        }
    }

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

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof FL)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        FL fl = (FL) parcelable;
        super.onRestoreInstanceState(fl.getSuperState());
        this.r = fl.a;
        this.s = fl.b;
        this.t = fl.c;
        this.o = fl.d;
        this.b = fl.e;
        this.j = fl.f;
        this.c = fl.g;
        this.k = fl.h;
        this.a = fl.i;
        this.q = fl.j;
        this.d = fl.k;
        this.p = SystemClock.uptimeMillis();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        FL fl = new FL(super.onSaveInstanceState());
        fl.a = this.r;
        fl.b = this.s;
        fl.c = this.t;
        fl.d = this.o;
        fl.e = this.b;
        fl.f = this.j;
        fl.g = this.c;
        fl.h = this.k;
        fl.i = this.a;
        fl.j = this.q;
        fl.k = this.d;
        return fl;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (this.d) {
            int i5 = this.b;
            this.n = new RectF(paddingLeft + i5, paddingTop + i5, (i - paddingRight) - i5, (i2 - paddingBottom) - i5);
        } else {
            int i6 = (i - paddingLeft) - paddingRight;
            int min = Math.min(Math.min(i6, (i2 - paddingBottom) - paddingTop), (this.a * 2) - (this.b * 2));
            int i7 = ((i6 - min) / 2) + paddingLeft;
            int i8 = ((((i2 - paddingTop) - paddingBottom) - min) / 2) + paddingTop;
            int i9 = this.b;
            this.n = new RectF(i7 + i9, i8 + i9, (i7 + min) - i9, (i8 + min) - i9);
        }
        a();
        invalidate();
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.p = SystemClock.uptimeMillis();
        }
    }

    public void setBarColor(int i) {
        this.j = i;
        a();
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setBarWidth(int i) {
        this.b = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setCallback(EL el) {
    }

    public void setCircleRadius(int i) {
        this.a = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

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

    public void setLinearProgress(boolean z) {
        this.q = z;
        if (this.t) {
            return;
        }
        invalidate();
    }

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

    public void setRimColor(int i) {
        this.k = i;
        a();
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setRimWidth(int i) {
        this.c = i;
        if (this.t) {
            return;
        }
        invalidate();
    }

    public void setSpinSpeed(float f) {
        this.o = f * 360.0f;
    }
}
