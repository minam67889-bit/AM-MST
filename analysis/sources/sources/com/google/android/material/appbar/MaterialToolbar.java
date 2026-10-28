package com.google.android.material.appbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC0427Pv;
import defpackage.AbstractC0440Qi;
import defpackage.AbstractC3354fY;
import defpackage.AbstractC4702x40;
import defpackage.AbstractC4817ya0;
import defpackage.C0432Qa;
import defpackage.CL;
import defpackage.UD;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class MaterialToolbar extends Toolbar {
    public static final ImageView.ScaleType[] W = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};
    public Integer R;
    public boolean S;
    public boolean T;
    public ImageView.ScaleType U;
    public Boolean V;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialToolbar(Context context, AttributeSet attributeSet) {
        super(AbstractC4817ya0.f0(context, attributeSet, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar), attributeSet, 0);
        Context context2 = getContext();
        TypedArray B = AbstractC4702x40.B(context2, attributeSet, CL.x, R.attr.toolbarStyle, R.style.Widget_MaterialComponents_Toolbar, new int[0]);
        if (B.hasValue(2)) {
            setNavigationIconTint(B.getColor(2, -1));
        }
        this.S = B.getBoolean(4, false);
        this.T = B.getBoolean(3, false);
        int i = B.getInt(1, -1);
        if (i >= 0) {
            ImageView.ScaleType[] scaleTypeArr = W;
            if (i < scaleTypeArr.length) {
                this.U = scaleTypeArr[i];
            }
        }
        if (B.hasValue(0)) {
            this.V = Boolean.valueOf(B.getBoolean(0, false));
        }
        B.recycle();
        Drawable background = getBackground();
        ColorStateList valueOf = background == null ? ColorStateList.valueOf(0) : AbstractC0427Pv.r(background);
        if (valueOf != null) {
            UD ud = new UD();
            ud.o(valueOf);
            ud.l(context2);
            ud.n(getElevation());
            setBackground(ud);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageView.ScaleType getLogoScaleType() {
        return this.U;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Integer getNavigationIconTint() {
        return this.R;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof UD) {
            AbstractC3354fY.j0(this, (UD) background);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ImageView imageView;
        Drawable drawable;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        ImageView imageView2 = null;
        if (this.S || this.T) {
            ArrayList t = AbstractC0440Qi.t(this, getTitle());
            boolean isEmpty = t.isEmpty();
            C0432Qa c0432Qa = AbstractC0440Qi.m;
            TextView textView = isEmpty ? null : (TextView) Collections.min(t, c0432Qa);
            ArrayList t2 = AbstractC0440Qi.t(this, getSubtitle());
            TextView textView2 = t2.isEmpty() ? null : (TextView) Collections.max(t2, c0432Qa);
            if (textView != null || textView2 != null) {
                int measuredWidth = getMeasuredWidth();
                int i6 = measuredWidth / 2;
                int paddingLeft = getPaddingLeft();
                int paddingRight = measuredWidth - getPaddingRight();
                for (int i7 = 0; i7 < getChildCount(); i7++) {
                    View childAt = getChildAt(i7);
                    if (childAt.getVisibility() != 8 && childAt != textView && childAt != textView2) {
                        if (childAt.getRight() < i6 && childAt.getRight() > paddingLeft) {
                            paddingLeft = childAt.getRight();
                        }
                        if (childAt.getLeft() > i6 && childAt.getLeft() < paddingRight) {
                            paddingRight = childAt.getLeft();
                        }
                    }
                }
                Pair pair = new Pair(Integer.valueOf(paddingLeft), Integer.valueOf(paddingRight));
                if (this.S && textView != null) {
                    u(textView, pair);
                }
                if (this.T && textView2 != null) {
                    u(textView2, pair);
                }
            }
        }
        Drawable logo = getLogo();
        if (logo != null) {
            while (true) {
                if (i5 >= getChildCount()) {
                    break;
                }
                View childAt2 = getChildAt(i5);
                if ((childAt2 instanceof ImageView) && (drawable = (imageView = (ImageView) childAt2).getDrawable()) != null && drawable.getConstantState() != null && drawable.getConstantState().equals(logo.getConstantState())) {
                    imageView2 = imageView;
                    break;
                }
                i5++;
            }
        }
        if (imageView2 != null) {
            Boolean bool = this.V;
            if (bool != null) {
                imageView2.setAdjustViewBounds(bool.booleanValue());
            }
            ImageView.ScaleType scaleType = this.U;
            if (scaleType != null) {
                imageView2.setScaleType(scaleType);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof UD) {
            ((UD) background).n(f);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLogoAdjustViewBounds(boolean z) {
        Boolean bool = this.V;
        if (bool == null || bool.booleanValue() != z) {
            this.V = Boolean.valueOf(z);
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLogoScaleType(ImageView.ScaleType scaleType) {
        if (this.U != scaleType) {
            this.U = scaleType;
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null && this.R != null) {
            drawable = drawable.mutate();
            drawable.setTint(this.R.intValue());
        }
        super.setNavigationIcon(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setNavigationIconTint(int i) {
        this.R = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSubtitleCentered(boolean z) {
        if (this.T != z) {
            this.T = z;
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitleCentered(boolean z) {
        if (this.S != z) {
            this.S = z;
            requestLayout();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void u(TextView textView, Pair pair) {
        int measuredWidth = getMeasuredWidth();
        int measuredWidth2 = textView.getMeasuredWidth();
        int i = (measuredWidth / 2) - (measuredWidth2 / 2);
        int i2 = measuredWidth2 + i;
        int max = Math.max(Math.max(((Integer) pair.first).intValue() - i, 0), Math.max(i2 - ((Integer) pair.second).intValue(), 0));
        if (max > 0) {
            i += max;
            i2 -= max;
            textView.measure(View.MeasureSpec.makeMeasureSpec(i2 - i, 1073741824), textView.getMeasuredHeightAndState());
        }
        textView.layout(i, textView.getTop(), i2, textView.getBottom());
    }
}
