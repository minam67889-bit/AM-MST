package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import com.google.android.material.button.MaterialButton;
import dastan.prince.bdfreevpn.R;

/* renamed from: uE, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4213uE {
    public final MaterialButton a;
    public C4464xS b;
    public VU c;
    public C3677nU d;
    public C3290ic e;
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public PorterDuff.Mode l;
    public ColorStateList m;
    public ColorStateList n;
    public ColorStateList o;
    public JE p;
    public boolean t;
    public RippleDrawable v;
    public int w;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean u = true;

    public C4213uE(MaterialButton materialButton, C4464xS c4464xS) {
        this.a = materialButton;
        this.b = c4464xS;
    }

    public final JE a(boolean z) {
        RippleDrawable rippleDrawable = this.v;
        if (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (JE) ((LayerDrawable) ((InsetDrawable) this.v.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
    }

    public final void b(int i, int i2) {
        MaterialButton materialButton = this.a;
        int paddingStart = materialButton.getPaddingStart();
        int paddingTop = materialButton.getPaddingTop();
        int paddingEnd = materialButton.getPaddingEnd();
        int paddingBottom = materialButton.getPaddingBottom();
        int i3 = this.h;
        int i4 = this.i;
        this.i = i2;
        this.h = i;
        if (!this.r) {
            c();
        }
        materialButton.setPaddingRelative(paddingStart, (paddingTop + i) - i3, paddingEnd, (paddingBottom + i2) - i4);
    }

    public final void c() {
        JE je = new JE(this.b);
        VU vu = this.c;
        if (vu != null) {
            je.o(vu);
        }
        C3677nU c3677nU = this.d;
        if (c3677nU != null) {
            je.l(c3677nU);
        }
        C3290ic c3290ic = this.e;
        if (c3290ic != null) {
            je.E = c3290ic;
        }
        MaterialButton materialButton = this.a;
        je.k(materialButton.getContext());
        je.setTintList(this.m);
        PorterDuff.Mode mode = this.l;
        if (mode != null) {
            je.setTintMode(mode);
        }
        float f = this.k;
        ColorStateList colorStateList = this.n;
        je.b.k = f;
        je.invalidateSelf();
        HE he = je.b;
        if (he.e != colorStateList) {
            he.e = colorStateList;
            je.onStateChange(je.getState());
        }
        JE je2 = new JE(this.b);
        VU vu2 = this.c;
        if (vu2 != null) {
            je2.o(vu2);
        }
        C3677nU c3677nU2 = this.d;
        if (c3677nU2 != null) {
            je2.l(c3677nU2);
        }
        je2.setTint(0);
        float f2 = this.k;
        int u = this.q ? S50.u(materialButton, R.attr.colorSurface) : 0;
        je2.b.k = f2;
        je2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(u);
        HE he2 = je2.b;
        if (he2.e != valueOf) {
            he2.e = valueOf;
            je2.onStateChange(je2.getState());
        }
        JE je3 = new JE(this.b);
        this.p = je3;
        VU vu3 = this.c;
        if (vu3 != null) {
            je3.o(vu3);
        }
        C3677nU c3677nU3 = this.d;
        if (c3677nU3 != null) {
            this.p.l(c3677nU3);
        }
        this.p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(NO.a(this.o), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{je2, je}), this.f, this.h, this.g, this.i), this.p);
        this.v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        JE a = a(false);
        if (a != null) {
            a.m(this.w);
            a.setState(materialButton.getDrawableState());
        }
    }

    public final void d() {
        JE a = a(false);
        if (a != null) {
            VU vu = this.c;
            if (vu != null) {
                a.o(vu);
            } else {
                a.setShapeAppearanceModel(this.b);
            }
            C3677nU c3677nU = this.d;
            if (c3677nU != null) {
                a.l(c3677nU);
            }
        }
        JE a2 = a(true);
        if (a2 != null) {
            VU vu2 = this.c;
            if (vu2 != null) {
                a2.o(vu2);
            } else {
                a2.setShapeAppearanceModel(this.b);
            }
            C3677nU c3677nU2 = this.d;
            if (c3677nU2 != null) {
                a2.l(c3677nU2);
            }
        }
        RippleDrawable rippleDrawable = this.v;
        JS js = (rippleDrawable == null || rippleDrawable.getNumberOfLayers() <= 1) ? null : this.v.getNumberOfLayers() > 2 ? (JS) this.v.getDrawable(2) : (JS) this.v.getDrawable(1);
        if (js != null) {
            js.setShapeAppearanceModel(this.b);
            if (js instanceof JE) {
                JE je = (JE) js;
                VU vu3 = this.c;
                if (vu3 != null) {
                    je.o(vu3);
                }
                C3677nU c3677nU3 = this.d;
                if (c3677nU3 != null) {
                    je.l(c3677nU3);
                }
            }
        }
    }

    public final void e() {
        JE a = a(false);
        JE a2 = a(true);
        if (a != null) {
            float f = this.k;
            ColorStateList colorStateList = this.n;
            a.b.k = f;
            a.invalidateSelf();
            HE he = a.b;
            if (he.e != colorStateList) {
                he.e = colorStateList;
                a.onStateChange(a.getState());
            }
            if (a2 != null) {
                float f2 = this.k;
                int u = this.q ? S50.u(this.a, R.attr.colorSurface) : 0;
                a2.b.k = f2;
                a2.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(u);
                HE he2 = a2.b;
                if (he2.e != valueOf) {
                    he2.e = valueOf;
                    a2.onStateChange(a2.getState());
                }
            }
        }
    }
}
