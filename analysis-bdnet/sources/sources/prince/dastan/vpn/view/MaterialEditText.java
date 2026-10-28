package prince.dastan.vpn.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC4379wM;
import defpackage.C3172h6;
import defpackage.C3568m5;

/* loaded from: classes2.dex */
public class MaterialEditText extends C3568m5 {
    public boolean g;
    public Drawable h;
    public final boolean i;
    public int j;
    public int k;
    public int l;
    public int m;

    public MaterialEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = false;
        this.i = true;
        this.j = 0;
        this.m = 40;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, AbstractC4379wM.c);
            this.k = obtainStyledAttributes.getResourceId(2, R.drawable.ic_visibility_grey_900_24dp);
            this.l = obtainStyledAttributes.getResourceId(1, R.drawable.ic_visibility_off_grey_900_24dp);
            this.j = obtainStyledAttributes.getColor(3, 0);
            this.m = obtainStyledAttributes.getDimensionPixelSize(0, 40);
            obtainStyledAttributes.recycle();
        } else {
            this.k = R.drawable.ic_visibility_grey_900_24dp;
            this.l = R.drawable.ic_visibility_off_grey_900_24dp;
        }
        this.i = getResources().getConfiguration().getLayoutDirection() != 1;
        setMaxLines(1);
        setSingleLine(true);
        this.g = false;
        setTransformationMethod(PasswordTransformationMethod.getInstance());
        setSaveEnabled(true);
        if (!TextUtils.isEmpty(getText())) {
            b(true);
        }
        addTextChangedListener(new C3172h6(this, 1));
    }

    public final void b(boolean z) {
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        if (!z) {
            boolean z2 = this.i;
            if (!z2) {
                drawable = null;
            }
            if (z2) {
                drawable3 = null;
            }
            setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        Drawable drawable5 = this.g ? getContext().getDrawable(this.l) : getContext().getDrawable(this.k);
        drawable5.mutate();
        int i = this.j;
        if (i == 0) {
            boolean z3 = this.i;
            if (!z3) {
                drawable = drawable5;
            }
            if (z3) {
                drawable3 = drawable5;
            }
            setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        drawable5.setTint(i);
        boolean z4 = this.i;
        if (!z4) {
            drawable = drawable5;
        }
        if (z4) {
            drawable3 = drawable5;
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    public final void finalize() {
        this.h = null;
        super.finalize();
    }

    public int getAdditionalTouchTargetSizePixels() {
        return this.m;
    }

    public int getVisibilityIndicatorHide() {
        return this.l;
    }

    public int getVisibilityIndicatorShow() {
        return this.k;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            boolean z = bundle.getBoolean("IS_SHOWING_PASSWORD_STATE_KEY", false);
            this.g = z;
            if (z) {
                setTransformationMethod(null);
            }
            parcelable = bundle.getParcelable("SUPER_STATE_KEY");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE_KEY", super.onSaveInstanceState());
        bundle.putBoolean("IS_SHOWING_PASSWORD_STATE_KEY", this.g);
        return bundle;
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        if (motionEvent.getAction() == 1 && (drawable = this.h) != null) {
            Rect bounds = drawable.getBounds();
            int x = (int) motionEvent.getX();
            int width = bounds.width() + (this.i ? getPaddingRight() : getPaddingLeft()) + this.m;
            if ((this.i && x >= getRight() - width) || (!this.i && x <= getLeft() + width)) {
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                if (this.g) {
                    setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    setTransformationMethod(null);
                }
                setSelection(selectionStart, selectionEnd);
                this.g = !this.g;
                b(true);
                motionEvent.setAction(3);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setAdditionalTouchTargetSizePixels(int i) {
        this.m = i;
    }

    @Override // defpackage.C3568m5, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = this.i;
        if (z && drawable3 != null) {
            this.h = drawable3;
        } else if (!z && drawable != null) {
            this.h = drawable;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    public void setTintColor(int i) {
        this.j = i;
    }

    public void setVisibilityIndicatorHide(int i) {
        this.l = i;
    }

    public void setVisibilityIndicatorShow(int i) {
        this.k = i;
    }
}
