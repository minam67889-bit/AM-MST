package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import app.vpn.amtunnellite.R;
import com.google.android.material.button.MaterialButton;
import defpackage.A4;
import defpackage.AbstractC0427Pv;
import defpackage.AbstractC3411gE;
import defpackage.AbstractC4702x40;
import defpackage.AbstractC4817ya0;
import defpackage.C3551i5;
import defpackage.C4;
import defpackage.C4716xD;
import defpackage.C4778y4;
import defpackage.CL;
import defpackage.I5;
import defpackage.LD;
import defpackage.Q5;
import defpackage.QD;
import defpackage.WD;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends Q5 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.Q5
    public final C4778y4 a(Context context, AttributeSet attributeSet) {
        return new C4716xD(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.Q5
    public final A4 b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.Q5
    public final C4 c(Context context, AttributeSet attributeSet) {
        return new LD(context, attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.Q5
    public final C3551i5 d(Context context, AttributeSet attributeSet) {
        QD qd = new QD(AbstractC4817ya0.f0(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet, 0);
        Context context2 = qd.getContext();
        TypedArray B = AbstractC4702x40.B(context2, attributeSet, CL.s, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (B.hasValue(0)) {
            qd.setButtonTintList(AbstractC3411gE.d0(context2, B, 0));
        }
        qd.f = B.getBoolean(1, false);
        B.recycle();
        return qd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.Q5
    public final I5 e(Context context, AttributeSet attributeSet) {
        WD wd = new WD(AbstractC4817ya0.f0(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = wd.getContext();
        if (AbstractC0427Pv.N(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = CL.w;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int n = WD.n(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (n == -1) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, CL.v);
                    int n2 = WD.n(wd.getContext(), obtainStyledAttributes3, 2, 4);
                    obtainStyledAttributes3.recycle();
                    if (n2 >= 0) {
                        wd.setLineHeight(n2);
                    }
                }
            }
        }
        return wd;
    }
}
