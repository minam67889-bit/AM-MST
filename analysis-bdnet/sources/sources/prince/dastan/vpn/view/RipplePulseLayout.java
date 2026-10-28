package prince.dastan.vpn.view;

import android.R;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;
import defpackage.AbstractC4379wM;

/* loaded from: classes2.dex */
public class RipplePulseLayout extends RelativeLayout {
    public final Paint a;
    public final AnimatorSet b;
    public boolean c;
    public final RippleView d;

    public static class RippleView extends View {
        private Paint mPaint;
        private float mRadius;

        public RippleView(Context context, Paint paint, float f) {
            super(context);
            this.mPaint = paint;
            this.mRadius = f;
        }

        public float getRadius() {
            return this.mRadius;
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            canvas.drawCircle(getWidth() / 2, getHeight() / 2, this.mRadius, this.mPaint);
        }

        public void setRadius(float f) {
            this.mRadius = f;
            invalidate();
        }
    }

    public RipplePulseLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (isInEditMode()) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4379wM.b);
        int color = obtainStyledAttributes.getColor(2, getResources().getColor(R.color.holo_blue_bright));
        float dimension = obtainStyledAttributes.getDimension(4, getMeasuredWidth());
        float dimension2 = obtainStyledAttributes.getDimension(1, getMeasuredWidth() * 2);
        float dimension3 = obtainStyledAttributes.getDimension(5, 4.0f);
        int integer = obtainStyledAttributes.getInteger(0, 2000);
        String string = obtainStyledAttributes.getString(3);
        string = TextUtils.isEmpty(string) ? "0" : string;
        Paint paint = new Paint();
        this.a = paint;
        paint.setColor(color);
        this.a.setAntiAlias(true);
        if (string.equals("1")) {
            this.a.setStyle(Paint.Style.STROKE);
            this.a.setStrokeWidth(dimension3);
        } else {
            this.a.setStyle(Paint.Style.FILL);
            this.a.setStrokeWidth(0.0f);
        }
        this.d = new RippleView(getContext(), this.a, dimension);
        int i = ((int) (dimension3 + dimension2)) * 2;
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i);
        layoutParams.addRule(13, -1);
        addView(this.d, layoutParams);
        this.d.setVisibility(4);
        this.b = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.d, "radius", dimension, dimension2);
        ofFloat.setRepeatCount(-1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.d, "alpha", 1.0f, 0.0f);
        ofFloat2.setRepeatCount(-1);
        this.b.setDuration(integer);
        this.b.setInterpolator(new AccelerateDecelerateInterpolator());
        this.b.playTogether(ofFloat, ofFloat2);
    }

    public final void a() {
        if (this.c) {
            return;
        }
        this.d.setVisibility(0);
        this.b.start();
        this.c = true;
    }

    public final void b() {
        if (this.c) {
            this.b.end();
            this.d.setVisibility(4);
            this.c = false;
        }
    }
}
