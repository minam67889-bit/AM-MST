package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Insets;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public abstract class Y9 extends FrameLayout {
    public static final X9 l = new X9();
    public Z9 a;
    public final ER b;
    public int c;
    public final float d;
    public final float e;
    public final int f;
    public final int g;
    public ColorStateList h;
    public PorterDuff.Mode i;
    public Rect j;
    public boolean k;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Y9(Context context, AttributeSet attributeSet) {
        super(AbstractC4817ya0.f0(context, attributeSet, 0, 0), attributeSet);
        GradientDrawable gradientDrawable;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, CL.C);
        if (obtainStyledAttributes.hasValue(6)) {
            setElevation(obtainStyledAttributes.getDimensionPixelSize(6, 0));
        }
        this.c = obtainStyledAttributes.getInt(2, 0);
        if (obtainStyledAttributes.hasValue(8) || obtainStyledAttributes.hasValue(9)) {
            this.b = ER.b(context2, attributeSet, 0, 0).a();
        }
        this.d = obtainStyledAttributes.getFloat(3, 1.0f);
        setBackgroundTintList(AbstractC3411gE.d0(context2, obtainStyledAttributes, 4));
        setBackgroundTintMode(AbstractC4311s10.r(obtainStyledAttributes.getInt(5, -1), PorterDuff.Mode.SRC_IN));
        this.e = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f = obtainStyledAttributes.getDimensionPixelSize(0, -1);
        this.g = obtainStyledAttributes.getDimensionPixelSize(7, -1);
        obtainStyledAttributes.recycle();
        setOnTouchListener(l);
        setFocusable(true);
        if (getBackground() == null) {
            int K = AbstractC4766xx.K(AbstractC4766xx.B(this, R.attr.colorSurface), AbstractC4766xx.B(this, R.attr.colorOnSurface), getBackgroundOverlayColorAlpha());
            ER er = this.b;
            if (er != null) {
                C4912zp c4912zp = Z9.u;
                UD ud = new UD(er);
                ud.o(ColorStateList.valueOf(K));
                gradientDrawable = ud;
            } else {
                Resources resources = getResources();
                C4912zp c4912zp2 = Z9.u;
                float dimension = resources.getDimension(R.dimen.mtrl_snackbar_background_corner_radius);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setShape(0);
                gradientDrawable2.setCornerRadius(dimension);
                gradientDrawable2.setColor(K);
                gradientDrawable = gradientDrawable2;
            }
            ColorStateList colorStateList = this.h;
            if (colorStateList != null) {
                gradientDrawable.setTintList(colorStateList);
            }
            setBackground(gradientDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setBaseTransientBottomBar(Z9 z9) {
        this.a = z9;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getActionTextColorAlpha() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAnimationMode() {
        return this.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getBackgroundOverlayColorAlpha() {
        return this.d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxInlineActionWidth() {
        return this.g;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxWidth() {
        return this.f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        Insets mandatorySystemGestureInsets;
        int i;
        super.onAttachedToWindow();
        Z9 z9 = this.a;
        if (z9 != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                WindowInsets rootWindowInsets = z9.i.getRootWindowInsets();
                if (rootWindowInsets != null) {
                    mandatorySystemGestureInsets = rootWindowInsets.getMandatorySystemGestureInsets();
                    i = mandatorySystemGestureInsets.bottom;
                    z9.p = i;
                    z9.f();
                }
            } else {
                z9.getClass();
            }
        }
        requestApplyInsets();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Z9 z9 = this.a;
        if (z9 != null && z9.b()) {
            Z9.x.post(new T9(z9, 1));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        Z9 z9 = this.a;
        if (z9 != null && z9.r) {
            z9.e();
            z9.r = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.f;
        if (i3 > 0 && getMeasuredWidth() > i3) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAnimationMode(int i) {
        this.c = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.h != null) {
            drawable = drawable.mutate();
            drawable.setTintList(this.h);
            drawable.setTintMode(this.i);
        }
        super.setBackgroundDrawable(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.h = colorStateList;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            mutate.setTintList(colorStateList);
            mutate.setTintMode(this.i);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.i = mode;
        if (getBackground() != null) {
            Drawable mutate = getBackground().mutate();
            mutate.setTintMode(mode);
            if (mutate != getBackground()) {
                super.setBackgroundDrawable(mutate);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (!this.k && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.j = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
            Z9 z9 = this.a;
            if (z9 != null) {
                C4912zp c4912zp = Z9.u;
                z9.f();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        X9 x9;
        if (onClickListener != null) {
            x9 = null;
        } else {
            x9 = l;
        }
        setOnTouchListener(x9);
        super.setOnClickListener(onClickListener);
    }
}
