package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class WD extends I5 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int n(Context context, TypedArray typedArray, int... iArr) {
        int i = -1;
        for (int i2 = 0; i2 < iArr.length && i < 0; i2++) {
            int i3 = iArr[i2];
            TypedValue typedValue = new TypedValue();
            if (typedArray.getValue(i3, typedValue) && typedValue.type == 2) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{typedValue.data});
                int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, -1);
                obtainStyledAttributes.recycle();
                i = dimensionPixelSize;
            } else {
                i = typedArray.getDimensionPixelSize(i3, -1);
            }
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.I5, android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (AbstractC0427Pv.N(context, R.attr.textAppearanceLineHeightEnabled, true)) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(i, CL.v);
            int n = n(getContext(), obtainStyledAttributes, 2, 4);
            obtainStyledAttributes.recycle();
            if (n >= 0) {
                setLineHeight(n);
            }
        }
    }
}
