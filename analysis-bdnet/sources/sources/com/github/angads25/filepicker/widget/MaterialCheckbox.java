package com.github.angads25.filepicker.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import dastan.prince.bdfreevpn.R;
import defpackage.InterfaceC0795bJ;
import defpackage.ViewOnClickListenerC2840d;

/* loaded from: classes.dex */
public class MaterialCheckbox extends View {
    public final Context a;
    public int b;
    public final Paint c;
    public final RectF d;
    public boolean e;
    public InterfaceC0795bJ f;
    public final Path g;

    public MaterialCheckbox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = context;
        this.e = false;
        this.g = new Path();
        this.c = new Paint();
        this.d = new RectF();
        setOnClickListener(new ViewOnClickListenerC2840d(this, 8));
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.e) {
            this.c.reset();
            this.c.setAntiAlias(true);
            RectF rectF = this.d;
            int i = this.b;
            rectF.set(i / 10, i / 10, i - (i / 10), i - (i / 10));
            this.c.setColor(getResources().getColor(R.color.colorAccent, this.a.getTheme()));
            RectF rectF2 = this.d;
            int i2 = this.b;
            canvas.drawRoundRect(rectF2, i2 / 8, i2 / 8, this.c);
            this.c.setColor(Color.parseColor("#FFFFFF"));
            this.c.setStrokeWidth(this.b / 10);
            this.c.setStyle(Paint.Style.STROKE);
            this.c.setStrokeJoin(Paint.Join.BEVEL);
            canvas.drawPath(this.g, this.c);
            return;
        }
        this.c.reset();
        this.c.setAntiAlias(true);
        RectF rectF3 = this.d;
        int i3 = this.b;
        rectF3.set(i3 / 10, i3 / 10, i3 - (i3 / 10), i3 - (i3 / 10));
        this.c.setColor(Color.parseColor("#C1C1C1"));
        RectF rectF4 = this.d;
        int i4 = this.b;
        canvas.drawRoundRect(rectF4, i4 / 8, i4 / 8, this.c);
        RectF rectF5 = this.d;
        int i5 = this.b;
        rectF5.set(i5 / 5, i5 / 5, i5 - (i5 / 5), i5 - (i5 / 5));
        this.c.setColor(Color.parseColor("#FFFFFF"));
        canvas.drawRect(this.d, this.c);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.b = Math.min(measuredWidth, measuredHeight);
        this.d.set(r0 / 10, r0 / 10, r0 - (r0 / 10), r0 - (r0 / 10));
        Path path = this.g;
        int i3 = this.b;
        path.moveTo(i3 / 4, i3 / 2);
        this.g.lineTo(this.b / 2.5f, r1 - (r1 / 3));
        Path path2 = this.g;
        int i4 = this.b;
        path2.moveTo(i4 / 2.75f, i4 - (i4 / 3.25f));
        Path path3 = this.g;
        int i5 = this.b;
        path3.lineTo(i5 - (i5 / 4), i5 / 3);
        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    public void setChecked(boolean z) {
        this.e = z;
        invalidate();
    }

    public void setOnCheckedChangedListener(InterfaceC0795bJ interfaceC0795bJ) {
        this.f = interfaceC0795bJ;
    }
}
