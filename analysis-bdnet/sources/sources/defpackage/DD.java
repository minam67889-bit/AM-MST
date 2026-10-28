package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import app.vpn.amtunnellite.R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes.dex */
public final class DD {
    public final MaterialButton a;
    public ER b;
    public XT c;
    public C4347sT d;
    public C0384Oe e;
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
    public UD p;
    public boolean t;
    public RippleDrawable v;
    public int w;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean u = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DD(MaterialButton materialButton, ER er) {
        this.a = materialButton;
        this.b = er;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final UD a(boolean z) {
        RippleDrawable rippleDrawable = this.v;
        if (rippleDrawable != null && rippleDrawable.getNumberOfLayers() > 0) {
            return (UD) ((LayerDrawable) ((InsetDrawable) this.v.getDrawable(0)).getDrawable()).getDrawable(!z ? 1 : 0);
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c() {
        int i;
        UD ud = new UD(this.b);
        XT xt = this.c;
        if (xt != null) {
            ud.p(xt);
        }
        C4347sT c4347sT = this.d;
        if (c4347sT != null) {
            ud.m(c4347sT);
        }
        C0384Oe c0384Oe = this.e;
        if (c0384Oe != null) {
            ud.E = c0384Oe;
        }
        MaterialButton materialButton = this.a;
        ud.l(materialButton.getContext());
        ud.setTintList(this.m);
        PorterDuff.Mode mode = this.l;
        if (mode != null) {
            ud.setTintMode(mode);
        }
        float f = this.k;
        ColorStateList colorStateList = this.n;
        ud.b.l = f;
        ud.invalidateSelf();
        SD sd = ud.b;
        if (sd.e != colorStateList) {
            sd.e = colorStateList;
            ud.onStateChange(ud.getState());
        }
        UD ud2 = new UD(this.b);
        XT xt2 = this.c;
        if (xt2 != null) {
            ud2.p(xt2);
        }
        C4347sT c4347sT2 = this.d;
        if (c4347sT2 != null) {
            ud2.m(c4347sT2);
        }
        ud2.setTint(0);
        float f2 = this.k;
        if (this.q) {
            i = AbstractC4766xx.B(materialButton, R.attr.colorSurface);
        } else {
            i = 0;
        }
        ud2.b.l = f2;
        ud2.invalidateSelf();
        ColorStateList valueOf = ColorStateList.valueOf(i);
        SD sd2 = ud2.b;
        if (sd2.e != valueOf) {
            sd2.e = valueOf;
            ud2.onStateChange(ud2.getState());
        }
        UD ud3 = new UD(this.b);
        this.p = ud3;
        XT xt3 = this.c;
        if (xt3 != null) {
            ud3.p(xt3);
        }
        C4347sT c4347sT3 = this.d;
        if (c4347sT3 != null) {
            this.p.m(c4347sT3);
        }
        this.p.setTint(-1);
        RippleDrawable rippleDrawable = new RippleDrawable(QN.a(this.o), new InsetDrawable((Drawable) new LayerDrawable(new Drawable[]{ud2, ud}), this.f, this.h, this.g, this.i), this.p);
        this.v = rippleDrawable;
        materialButton.setInternalBackground(rippleDrawable);
        UD a = a(false);
        if (a != null) {
            a.n(this.w);
            a.setState(materialButton.getDrawableState());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        QR qr;
        Object drawable;
        UD a = a(false);
        if (a != null) {
            XT xt = this.c;
            if (xt != null) {
                a.p(xt);
            } else {
                a.setShapeAppearanceModel(this.b);
            }
            C4347sT c4347sT = this.d;
            if (c4347sT != null) {
                a.m(c4347sT);
            }
        }
        UD a2 = a(true);
        if (a2 != null) {
            XT xt2 = this.c;
            if (xt2 != null) {
                a2.p(xt2);
            } else {
                a2.setShapeAppearanceModel(this.b);
            }
            C4347sT c4347sT2 = this.d;
            if (c4347sT2 != null) {
                a2.m(c4347sT2);
            }
        }
        RippleDrawable rippleDrawable = this.v;
        if (rippleDrawable != null && rippleDrawable.getNumberOfLayers() > 1) {
            if (this.v.getNumberOfLayers() > 2) {
                drawable = this.v.getDrawable(2);
            } else {
                drawable = this.v.getDrawable(1);
            }
            qr = (QR) drawable;
        } else {
            qr = null;
        }
        if (qr != null) {
            qr.setShapeAppearanceModel(this.b);
            if (qr instanceof UD) {
                UD ud = (UD) qr;
                XT xt3 = this.c;
                if (xt3 != null) {
                    ud.p(xt3);
                }
                C4347sT c4347sT3 = this.d;
                if (c4347sT3 != null) {
                    ud.m(c4347sT3);
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e() {
        int i = 0;
        UD a = a(false);
        UD a2 = a(true);
        if (a != null) {
            float f = this.k;
            ColorStateList colorStateList = this.n;
            a.b.l = f;
            a.invalidateSelf();
            SD sd = a.b;
            if (sd.e != colorStateList) {
                sd.e = colorStateList;
                a.onStateChange(a.getState());
            }
            if (a2 != null) {
                float f2 = this.k;
                if (this.q) {
                    i = AbstractC4766xx.B(this.a, R.attr.colorSurface);
                }
                a2.b.l = f2;
                a2.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(i);
                SD sd2 = a2.b;
                if (sd2.e != valueOf) {
                    sd2.e = valueOf;
                    a2.onStateChange(a2.getState());
                }
            }
        }
    }
}
