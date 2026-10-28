package prince.udp.vpn.view;

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
import app.vpn.amtunnellite.R;
import com.liapp.y;
import defpackage.BL;
import defpackage.C0792b5;
import defpackage.PD;

/* loaded from: classes2.dex */
public class MaterialEditText extends C0792b5 {
    public boolean g;
    public Drawable h;
    public final boolean i;
    public int j;
    public int k;
    public int l;
    public int m;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void finalize() {
        this.h = null;
        super.finalize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAdditionalTouchTargetSizePixels() {
        return this.m;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getVisibilityIndicatorHide() {
        return this.l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getVisibilityIndicatorShow() {
        return this.k;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(y.ڮڴجۭݩ(1256357837), super.onSaveInstanceState());
        bundle.putBoolean(y.گ֮۬۲ݮ(2086331507), this.g);
        return bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setAdditionalTouchTargetSizePixels(int i) {
        this.m = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.C0792b5, android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        boolean z = this.i;
        if (z && drawable3 != null) {
            this.h = drawable3;
        } else if (!z && drawable != null) {
            this.h = drawable;
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTintColor(int i) {
        this.j = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVisibilityIndicatorHide(int i) {
        this.l = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setVisibilityIndicatorShow(int i) {
        this.k = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MaterialEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        boolean z;
        this.g = false;
        this.i = true;
        this.j = 0;
        this.m = 40;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, BL.a);
            this.k = obtainStyledAttributes.getResourceId(2, R.drawable.ic_visibility_grey_900_24dp);
            this.l = obtainStyledAttributes.getResourceId(1, R.drawable.ic_visibility_off_grey_900_24dp);
            this.j = obtainStyledAttributes.getColor(3, 0);
            this.m = obtainStyledAttributes.getDimensionPixelSize(0, 40);
            obtainStyledAttributes.recycle();
        } else {
            this.k = R.drawable.ic_visibility_grey_900_24dp;
            this.l = R.drawable.ic_visibility_off_grey_900_24dp;
        }
        if (getResources().getConfiguration().getLayoutDirection() != 1) {
            z = true;
        } else {
            z = false;
        }
        this.i = z;
        setMaxLines(1);
        setSingleLine(true);
        this.g = false;
        setTransformationMethod(PasswordTransformationMethod.getInstance());
        setSaveEnabled(true);
        if (!TextUtils.isEmpty(getText())) {
            c(true);
        }
        addTextChangedListener(new PD(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r4 != false) goto L16;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(boolean z) {
        Context context;
        int i;
        Drawable[] compoundDrawables = getCompoundDrawables();
        Drawable drawable = compoundDrawables[0];
        Drawable drawable2 = compoundDrawables[1];
        Drawable drawable3 = compoundDrawables[2];
        Drawable drawable4 = compoundDrawables[3];
        if (z) {
            if (this.g) {
                context = getContext();
                i = this.l;
            } else {
                context = getContext();
                i = this.k;
            }
            Drawable drawable5 = context.getDrawable(i);
            drawable5.mutate();
            int i2 = this.j;
            if (i2 == 0) {
                boolean z2 = this.i;
                if (!z2) {
                    drawable = drawable5;
                }
            } else {
                drawable5.setTint(i2);
                boolean z3 = this.i;
                if (!z3) {
                    drawable = drawable5;
                }
            }
        } else {
            boolean z4 = this.i;
            if (!z4) {
                drawable = null;
            }
            if (z4) {
                drawable3 = null;
            }
        }
        setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            boolean z = bundle.getBoolean(y.گ֮۬۲ݮ(2086331507), false);
            this.g = z;
            if (z) {
                setTransformationMethod(null);
            }
            parcelable = bundle.getParcelable(y.ڮڴجۭݩ(1256357837));
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable drawable;
        int paddingLeft;
        if (motionEvent.getAction() == 1 && (drawable = this.h) != null) {
            Rect bounds = drawable.getBounds();
            int x = (int) motionEvent.getX();
            int width = bounds.width();
            if (this.i) {
                paddingLeft = getPaddingRight();
            } else {
                paddingLeft = getPaddingLeft();
            }
            int i = width + paddingLeft + this.m;
            if ((this.i && x >= getRight() - i) || (!this.i && x <= getLeft() + i)) {
                int selectionStart = getSelectionStart();
                int selectionEnd = getSelectionEnd();
                if (this.g) {
                    setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    setTransformationMethod(null);
                }
                setSelection(selectionStart, selectionEnd);
                this.g = !this.g;
                c(true);
                motionEvent.setAction(3);
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
