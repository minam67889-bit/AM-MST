package androidx.cardview.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import defpackage.AbstractC4458xM;
import defpackage.C0213Hv;
import defpackage.ML;
import defpackage.UO;

/* loaded from: classes.dex */
public class CardView extends FrameLayout {
    public static final int[] f = {R.attr.colorBackground};
    public static final C0213Hv g = new C0213Hv(11);
    public boolean a;
    public boolean b;
    public final Rect c;
    public final Rect d;
    public final ML e;

    public CardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dastan.prince.bdfreevpn.R.attr.cardViewStyle);
        ColorStateList valueOf;
        Rect rect = new Rect();
        this.c = rect;
        this.d = new Rect();
        ML ml = new ML(this, 14);
        this.e = ml;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC4458xM.a, dastan.prince.bdfreevpn.R.attr.cardViewStyle, dastan.prince.bdfreevpn.R.style.CardView);
        if (obtainStyledAttributes.hasValue(2)) {
            valueOf = obtainStyledAttributes.getColorStateList(2);
        } else {
            TypedArray obtainStyledAttributes2 = getContext().obtainStyledAttributes(f);
            int color = obtainStyledAttributes2.getColor(0, 0);
            obtainStyledAttributes2.recycle();
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            valueOf = ColorStateList.valueOf(fArr[2] > 0.5f ? getResources().getColor(dastan.prince.bdfreevpn.R.color.cardview_light_background) : getResources().getColor(dastan.prince.bdfreevpn.R.color.cardview_dark_background));
        }
        float dimension = obtainStyledAttributes.getDimension(3, 0.0f);
        float dimension2 = obtainStyledAttributes.getDimension(4, 0.0f);
        float dimension3 = obtainStyledAttributes.getDimension(5, 0.0f);
        this.a = obtainStyledAttributes.getBoolean(7, false);
        this.b = obtainStyledAttributes.getBoolean(6, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(8, 0);
        rect.left = obtainStyledAttributes.getDimensionPixelSize(10, dimensionPixelSize);
        rect.top = obtainStyledAttributes.getDimensionPixelSize(12, dimensionPixelSize);
        rect.right = obtainStyledAttributes.getDimensionPixelSize(11, dimensionPixelSize);
        rect.bottom = obtainStyledAttributes.getDimensionPixelSize(9, dimensionPixelSize);
        dimension3 = dimension2 > dimension3 ? dimension2 : dimension3;
        obtainStyledAttributes.getDimensionPixelSize(0, 0);
        obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        C0213Hv c0213Hv = g;
        UO uo = new UO(valueOf, dimension);
        ml.b = uo;
        setBackgroundDrawable(uo);
        setClipToOutline(true);
        setElevation(dimension2);
        c0213Hv.k(ml, dimension3);
    }

    public ColorStateList getCardBackgroundColor() {
        return ((UO) ((Drawable) this.e.b)).h;
    }

    public float getCardElevation() {
        return ((CardView) this.e.c).getElevation();
    }

    public int getContentPaddingBottom() {
        return this.c.bottom;
    }

    public int getContentPaddingLeft() {
        return this.c.left;
    }

    public int getContentPaddingRight() {
        return this.c.right;
    }

    public int getContentPaddingTop() {
        return this.c.top;
    }

    public float getMaxCardElevation() {
        return ((UO) ((Drawable) this.e.b)).e;
    }

    public boolean getPreventCornerOverlap() {
        return this.b;
    }

    public float getRadius() {
        return ((UO) ((Drawable) this.e.b)).a;
    }

    public boolean getUseCompatPadding() {
        return this.a;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public void setCardBackgroundColor(int i) {
        ColorStateList valueOf = ColorStateList.valueOf(i);
        UO uo = (UO) ((Drawable) this.e.b);
        if (valueOf == null) {
            uo.getClass();
            valueOf = ColorStateList.valueOf(0);
        }
        uo.h = valueOf;
        uo.b.setColor(valueOf.getColorForState(uo.getState(), uo.h.getDefaultColor()));
        uo.invalidateSelf();
    }

    public void setCardElevation(float f2) {
        ((CardView) this.e.c).setElevation(f2);
    }

    public void setMaxCardElevation(float f2) {
        g.k(this.e, f2);
    }

    @Override // android.view.View
    public void setMinimumHeight(int i) {
        super.setMinimumHeight(i);
    }

    @Override // android.view.View
    public void setMinimumWidth(int i) {
        super.setMinimumWidth(i);
    }

    @Override // android.view.View
    public final void setPadding(int i, int i2, int i3, int i4) {
    }

    @Override // android.view.View
    public final void setPaddingRelative(int i, int i2, int i3, int i4) {
    }

    public void setPreventCornerOverlap(boolean z) {
        if (z != this.b) {
            this.b = z;
            C0213Hv c0213Hv = g;
            ML ml = this.e;
            c0213Hv.k(ml, ((UO) ((Drawable) ml.b)).e);
        }
    }

    public void setRadius(float f2) {
        UO uo = (UO) ((Drawable) this.e.b);
        if (f2 == uo.a) {
            return;
        }
        uo.a = f2;
        uo.b(null);
        uo.invalidateSelf();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.a != z) {
            this.a = z;
            C0213Hv c0213Hv = g;
            ML ml = this.e;
            c0213Hv.k(ml, ((UO) ((Drawable) ml.b)).e);
        }
    }

    public void setCardBackgroundColor(ColorStateList colorStateList) {
        UO uo = (UO) ((Drawable) this.e.b);
        if (colorStateList == null) {
            uo.getClass();
            colorStateList = ColorStateList.valueOf(0);
        }
        uo.h = colorStateList;
        uo.b.setColor(colorStateList.getColorForState(uo.getState(), uo.h.getDefaultColor()));
        uo.invalidateSelf();
    }
}
