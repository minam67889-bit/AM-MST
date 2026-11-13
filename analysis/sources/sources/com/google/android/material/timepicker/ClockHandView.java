package com.google.android.material.timepicker;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC3778l4;
import defpackage.C0072Cd;
import defpackage.CL;
import defpackage.InterfaceC0098Dd;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class ClockHandView extends View {
    public static final /* synthetic */ int n = 0;
    public final ValueAnimator a;
    public boolean b;
    public final ArrayList c;
    public final int d;
    public final float e;
    public final Paint f;
    public final RectF g;
    public final int h;
    public float i;
    public boolean j;
    public double k;
    public int l;
    public int m;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ClockHandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.materialClockStyle);
        ValueAnimator valueAnimator = new ValueAnimator();
        this.a = valueAnimator;
        this.c = new ArrayList();
        Paint paint = new Paint();
        this.f = paint;
        this.g = new RectF();
        this.m = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CL.g, R.attr.materialClockStyle, R.style.Widget_MaterialComponents_TimePicker_Clock);
        AbstractC0363Nj.z(context, R.attr.motionDurationLong2, 200);
        AbstractC0363Nj.A(context, R.attr.motionEasingEmphasizedInterpolator, AbstractC3778l4.b);
        this.l = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.d = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        this.h = getResources().getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.e = r5.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        paint.setAntiAlias(true);
        paint.setColor(color);
        b(0.0f);
        ViewConfiguration.get(context).getScaledTouchSlop();
        setImportantForAccessibility(2);
        obtainStyledAttributes.recycle();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.timepicker.d
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                int i = ClockHandView.n;
                ClockHandView clockHandView = ClockHandView.this;
                clockHandView.getClass();
                clockHandView.c(((Float) valueAnimator2.getAnimatedValue()).floatValue());
            }
        });
        valueAnimator.addListener(new C0072Cd());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int a(int i) {
        return i == 2 ? Math.round(this.l * 0.66f) : this.l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(float f) {
        this.a.cancel();
        c(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(float f) {
        float f2 = f % 360.0f;
        this.i = f2;
        this.k = Math.toRadians(f2 - 90.0f);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float a = a(this.m);
        float cos = (((float) Math.cos(this.k)) * a) + width;
        float sin = (a * ((float) Math.sin(this.k))) + height;
        float f3 = this.d;
        this.g.set(cos - f3, sin - f3, cos + f3, sin + f3);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ClockFaceView clockFaceView = (ClockFaceView) ((InterfaceC0098Dd) it.next());
            if (Math.abs(clockFaceView.I - f2) > 0.001f) {
                clockFaceView.I = f2;
                clockFaceView.n();
            }
        }
        invalidate();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = width;
        float a = a(this.m);
        float cos = (((float) Math.cos(this.k)) * a) + f;
        float f2 = height;
        float sin = (a * ((float) Math.sin(this.k))) + f2;
        Paint paint = this.f;
        paint.setStrokeWidth(0.0f);
        canvas.drawCircle(cos, sin, this.d, paint);
        double sin2 = Math.sin(this.k);
        paint.setStrokeWidth(this.h);
        canvas.drawLine(f, f2, width + ((int) (Math.cos(this.k) * r12)), height + ((int) (r12 * sin2)), paint);
        canvas.drawCircle(f, f2, this.e, paint);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.a.isRunning()) {
            return;
        }
        b(this.i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        boolean z3 = false;
        if (actionMasked == 0) {
            this.j = false;
            z = true;
            z2 = false;
        } else if (actionMasked == 1 || actionMasked == 2) {
            z2 = this.j;
            if (this.b) {
                this.m = ((float) Math.hypot((double) (x - ((float) (getWidth() / 2))), (double) (y - ((float) (getHeight() / 2))))) <= ((float) a(2)) + TypedValue.applyDimension(1, (float) 12, getContext().getResources().getDisplayMetrics()) ? 2 : 1;
            }
            z = false;
        } else {
            z2 = false;
            z = false;
        }
        boolean z4 = this.j;
        int degrees = (int) Math.toDegrees(Math.atan2(y - (getHeight() / 2), x - (getWidth() / 2)));
        int i = degrees + 90;
        if (i < 0) {
            i = degrees + 450;
        }
        float f = i;
        boolean z5 = this.i != f;
        if (!z || !z5) {
            if (z5 || z2) {
                b(f);
            }
            this.j = z4 | z3;
            return true;
        }
        z3 = true;
        this.j = z4 | z3;
        return true;
    }
}
