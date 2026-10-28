package com.google.android.material.theme;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.button.MaterialButton;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC0731aZ;
import defpackage.C0778b6;
import defpackage.C3740oE;
import defpackage.C4120t5;
import defpackage.CE;
import defpackage.FM;
import defpackage.GE;
import defpackage.J4;
import defpackage.L4;
import defpackage.LE;
import defpackage.N4;
import defpackage.T5;
import defpackage.W80;
import defpackage.XE;

/* loaded from: classes.dex */
public class MaterialComponentsViewInflater extends C0778b6 {
    @Override // defpackage.C0778b6
    public final J4 a(Context context, AttributeSet attributeSet) {
        return new C3740oE(context, attributeSet);
    }

    @Override // defpackage.C0778b6
    public final L4 b(Context context, AttributeSet attributeSet) {
        return new MaterialButton(context, attributeSet);
    }

    @Override // defpackage.C0778b6
    public final N4 c(Context context, AttributeSet attributeSet) {
        return new CE(context, attributeSet);
    }

    @Override // defpackage.C0778b6
    public final C4120t5 d(Context context, AttributeSet attributeSet) {
        GE ge = new GE(XE.B(context, attributeSet, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton), attributeSet);
        Context context2 = ge.getContext();
        TypedArray G = AbstractC0641Yi.G(context2, attributeSet, FM.s, R.attr.radioButtonStyle, R.style.Widget_MaterialComponents_CompoundButton_RadioButton, new int[0]);
        if (G.hasValue(0)) {
            ge.setButtonTintList(W80.s(context2, G, 0));
        }
        ge.f = G.getBoolean(1, false);
        G.recycle();
        return ge;
    }

    @Override // defpackage.C0778b6
    public final T5 e(Context context, AttributeSet attributeSet) {
        LE le = new LE(XE.B(context, attributeSet, android.R.attr.textViewStyle, 0), attributeSet, android.R.attr.textViewStyle);
        Context context2 = le.getContext();
        if (AbstractC0731aZ.Z(context2, R.attr.textAppearanceLineHeightEnabled, true)) {
            Resources.Theme theme = context2.getTheme();
            int[] iArr = FM.w;
            TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
            int h = LE.h(context2, obtainStyledAttributes, 1, 2);
            obtainStyledAttributes.recycle();
            if (h == -1) {
                TypedArray obtainStyledAttributes2 = theme.obtainStyledAttributes(attributeSet, iArr, android.R.attr.textViewStyle, 0);
                int resourceId = obtainStyledAttributes2.getResourceId(0, -1);
                obtainStyledAttributes2.recycle();
                if (resourceId != -1) {
                    TypedArray obtainStyledAttributes3 = theme.obtainStyledAttributes(resourceId, FM.v);
                    int h2 = LE.h(le.getContext(), obtainStyledAttributes3, 2, 4);
                    obtainStyledAttributes3.recycle();
                    if (h2 >= 0) {
                        le.setLineHeight(h2);
                    }
                }
            }
        }
        return le;
    }
}
