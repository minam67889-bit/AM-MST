package prince.dastan.vpn.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import defpackage.AbstractC4379wM;

/* loaded from: classes2.dex */
public class CircleProgressBar extends View {
    public float a;
    public float b;
    public int c;
    public int d;
    public final int e;
    public int f;
    public final RectF g;
    public final Paint h;
    public final Paint i;

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = 4.0f;
        this.b = 0.0f;
        this.c = 0;
        this.d = 100;
        this.e = -90;
        this.f = -12303292;
        this.g = new RectF();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, AbstractC4379wM.a, 0, 0);
        try {
            this.a = obtainStyledAttributes.getDimension(3, this.a);
            this.b = obtainStyledAttributes.getFloat(2, this.b);
            this.f = obtainStyledAttributes.getInt(4, this.f);
            this.c = obtainStyledAttributes.getInt(1, this.c);
            this.d = obtainStyledAttributes.getInt(0, this.d);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint(1);
            this.h = paint;
            int i = this.f;
            paint.setColor(Color.argb(Math.round(Color.alpha(i) * 0.3f), Color.red(i), Color.green(i), Color.blue(i)));
            Paint paint2 = this.h;
            Paint.Style style = Paint.Style.STROKE;
            paint2.setStyle(style);
            this.h.setStrokeWidth(this.a);
            Paint paint3 = new Paint(1);
            this.i = paint3;
            paint3.setColor(this.f);
            this.i.setStyle(style);
            this.i.setStrokeWidth(this.a);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public int getColor() {
        return this.f;
    }

    public int getMax() {
        return this.d;
    }

    public int getMin() {
        return this.c;
    }

    public float getProgress() {
        return this.b;
    }

    public float getStrokeWidth() {
        return this.a;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawOval(this.g, this.h);
        canvas.drawArc(this.g, this.e, (this.b * 360.0f) / this.d, false, this.i);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int min = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(min, min);
        RectF rectF = this.g;
        float f = this.a;
        float f2 = min;
        rectF.set((f / 2.0f) + 0.0f, (f / 2.0f) + 0.0f, f2 - (f / 2.0f), f2 - (f / 2.0f));
    }

    public void setColor(int i) {
        this.f = i;
        this.h.setColor(Color.argb(Math.round(Color.alpha(i) * 0.3f), Color.red(i), Color.green(i), Color.blue(i)));
        this.i.setColor(i);
        invalidate();
        requestLayout();
    }

    public void setMax(int i) {
        this.d = i;
        invalidate();
    }

    public void setMin(int i) {
        this.c = i;
        invalidate();
    }

    public void setProgress(float f) {
        this.b = f;
        invalidate();
    }

    public void setProgressWithAnimation(float f) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "progress", f);
        ofFloat.setDuration(1500L);
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
    }

    public void setStrokeWidth(float f) {
        this.a = f;
        this.h.setStrokeWidth(f);
        this.i.setStrokeWidth(f);
        invalidate();
        requestLayout();
    }
}
