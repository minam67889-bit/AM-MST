package defpackage;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.chip.Chip;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* renamed from: vd, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4320vd extends JE implements Drawable.Callback, AW {
    public static final int[] P0 = {R.attr.state_enabled};
    public static final ShapeDrawable Q0 = new ShapeDrawable(new OvalShape());
    public int A0;
    public boolean B0;
    public int C0;
    public int D0;
    public ColorFilter E0;
    public PorterDuffColorFilter F0;
    public ColorStateList G0;
    public ColorStateList H;
    public PorterDuff.Mode H0;
    public ColorStateList I;
    public int[] I0;
    public float J;
    public ColorStateList J0;
    public float K;
    public WeakReference K0;
    public ColorStateList L;
    public TextUtils.TruncateAt L0;
    public float M;
    public boolean M0;
    public ColorStateList N;
    public int N0;
    public CharSequence O;
    public boolean O0;
    public boolean P;
    public Drawable Q;
    public ColorStateList R;
    public float S;
    public boolean T;
    public boolean U;
    public Drawable V;
    public RippleDrawable W;
    public ColorStateList X;
    public float Y;
    public SpannableStringBuilder Z;
    public boolean a0;
    public boolean b0;
    public Drawable c0;
    public ColorStateList d0;
    public C4610zG e0;
    public C4610zG f0;
    public float g0;
    public float h0;
    public float i0;
    public float j0;
    public float k0;
    public float l0;
    public float m0;
    public float n0;
    public final Context o0;
    public final Paint p0;
    public final Paint.FontMetrics q0;
    public final RectF r0;
    public final PointF s0;
    public final Path t0;
    public final BW u0;
    public int v0;
    public int w0;
    public int x0;
    public int y0;
    public int z0;

    public C4320vd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dastan.prince.bdfreevpn.R.attr.chipStyle, dastan.prince.bdfreevpn.R.style.Widget_MaterialComponents_Chip_Action);
        this.K = -1.0f;
        this.p0 = new Paint(1);
        this.q0 = new Paint.FontMetrics();
        this.r0 = new RectF();
        this.s0 = new PointF();
        this.t0 = new Path();
        this.D0 = 255;
        this.H0 = PorterDuff.Mode.SRC_IN;
        this.K0 = new WeakReference(null);
        k(context);
        this.o0 = context;
        BW bw = new BW(this);
        this.u0 = bw;
        this.O = "";
        bw.a.density = context.getResources().getDisplayMetrics().density;
        int[] iArr = P0;
        setState(iArr);
        R(iArr);
        this.M0 = true;
        Q0.setTint(-1);
    }

    public static void b0(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    public static boolean y(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    public static boolean z(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    public final void A() {
        InterfaceC4241ud interfaceC4241ud = (InterfaceC4241ud) this.K0.get();
        if (interfaceC4241ud != null) {
            Chip chip = (Chip) interfaceC4241ud;
            chip.b(chip.p);
            chip.requestLayout();
            chip.invalidateOutline();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x013a  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0149  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean B(int[] iArr, int[] iArr2) {
        int i;
        int colorForState;
        int[] state;
        boolean z;
        boolean z2;
        int colorForState2;
        float v;
        ColorStateList colorStateList;
        boolean z3 = true;
        boolean onStateChange = super.onStateChange(iArr);
        ColorStateList colorStateList2 = this.H;
        int c = c(colorStateList2 != null ? colorStateList2.getColorForState(iArr, this.v0) : 0);
        if (this.v0 != c) {
            this.v0 = c;
            onStateChange = true;
        }
        ColorStateList colorStateList3 = this.I;
        int c2 = c(colorStateList3 != null ? colorStateList3.getColorForState(iArr, this.w0) : 0);
        if (this.w0 != c2) {
            this.w0 = c2;
            onStateChange = true;
        }
        int b = AbstractC0118Ee.b(c2, c);
        if ((this.x0 != b) | (this.b.d == null)) {
            this.x0 = b;
            n(ColorStateList.valueOf(b));
            onStateChange = true;
        }
        ColorStateList colorStateList4 = this.L;
        int colorForState3 = colorStateList4 != null ? colorStateList4.getColorForState(iArr, this.y0) : 0;
        if (this.y0 != colorForState3) {
            this.y0 = colorForState3;
            onStateChange = true;
        }
        if (this.J0 != null) {
            int[] iArr3 = NO.a;
            boolean z4 = false;
            boolean z5 = false;
            for (int i2 : iArr) {
                if (i2 == 16842910) {
                    z4 = true;
                } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                    z5 = true;
                }
            }
            if (z4 && z5) {
                i = this.J0.getColorForState(iArr, this.z0);
                if (this.z0 != i) {
                    this.z0 = i;
                }
                C4547yW c4547yW = this.u0.f;
                colorForState = (c4547yW != null || (colorStateList = c4547yW.k) == null) ? 0 : colorStateList.getColorForState(iArr, this.A0);
                if (this.A0 != colorForState) {
                    this.A0 = colorForState;
                    onStateChange = true;
                }
                state = getState();
                if (state != null) {
                    int length = state.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        }
                        if (state[i3] != 16842912) {
                            i3++;
                        } else if (this.a0) {
                            z = true;
                        }
                    }
                }
                z = false;
                if (this.B0 != z && this.c0 != null) {
                    v = v();
                    this.B0 = z;
                    if (v == v()) {
                        onStateChange = true;
                        z2 = true;
                        ColorStateList colorStateList5 = this.G0;
                        colorForState2 = colorStateList5 != null ? colorStateList5.getColorForState(iArr, this.C0) : 0;
                        if (this.C0 != colorForState2) {
                            this.C0 = colorForState2;
                            ColorStateList colorStateList6 = this.G0;
                            PorterDuff.Mode mode = this.H0;
                            this.F0 = (colorStateList6 == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList6.getColorForState(getState(), 0), mode);
                        } else {
                            z3 = onStateChange;
                        }
                        if (z(this.Q)) {
                            z3 |= this.Q.setState(iArr);
                        }
                        if (z(this.c0)) {
                            z3 |= this.c0.setState(iArr);
                        }
                        if (z(this.V)) {
                            int[] iArr4 = new int[iArr.length + iArr2.length];
                            System.arraycopy(iArr, 0, iArr4, 0, iArr.length);
                            System.arraycopy(iArr2, 0, iArr4, iArr.length, iArr2.length);
                            z3 |= this.V.setState(iArr4);
                        }
                        if (z(this.W)) {
                            z3 |= this.W.setState(iArr2);
                        }
                        if (z3) {
                            invalidateSelf();
                        }
                        if (z2) {
                            A();
                        }
                        return z3;
                    }
                    onStateChange = true;
                }
                z2 = false;
                ColorStateList colorStateList52 = this.G0;
                if (colorStateList52 != null) {
                }
                if (this.C0 != colorForState2) {
                }
                if (z(this.Q)) {
                }
                if (z(this.c0)) {
                }
                if (z(this.V)) {
                }
                if (z(this.W)) {
                }
                if (z3) {
                }
                if (z2) {
                }
                return z3;
            }
        }
        i = 0;
        if (this.z0 != i) {
        }
        C4547yW c4547yW2 = this.u0.f;
        if (c4547yW2 != null) {
        }
        if (this.A0 != colorForState) {
        }
        state = getState();
        if (state != null) {
        }
        z = false;
        if (this.B0 != z) {
            v = v();
            this.B0 = z;
            if (v == v()) {
            }
        }
        z2 = false;
        ColorStateList colorStateList522 = this.G0;
        if (colorStateList522 != null) {
        }
        if (this.C0 != colorForState2) {
        }
        if (z(this.Q)) {
        }
        if (z(this.c0)) {
        }
        if (z(this.V)) {
        }
        if (z(this.W)) {
        }
        if (z3) {
        }
        if (z2) {
        }
        return z3;
    }

    public final void C(boolean z) {
        if (this.a0 != z) {
            this.a0 = z;
            float v = v();
            if (!z && this.B0) {
                this.B0 = false;
            }
            float v2 = v();
            invalidateSelf();
            if (v != v2) {
                A();
            }
        }
    }

    public final void D(Drawable drawable) {
        if (this.c0 != drawable) {
            float v = v();
            this.c0 = drawable;
            float v2 = v();
            b0(this.c0);
            t(this.c0);
            invalidateSelf();
            if (v != v2) {
                A();
            }
        }
    }

    public final void E(ColorStateList colorStateList) {
        Drawable drawable;
        if (this.d0 != colorStateList) {
            this.d0 = colorStateList;
            if (this.b0 && (drawable = this.c0) != null && this.a0) {
                drawable.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void F(boolean z) {
        if (this.b0 != z) {
            boolean Y = Y();
            this.b0 = z;
            boolean Y2 = Y();
            if (Y != Y2) {
                if (Y2) {
                    t(this.c0);
                } else {
                    b0(this.c0);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void G(float f) {
        if (this.K != f) {
            this.K = f;
            C4385wS f2 = this.b.a.f();
            f2.e = new C3317j(f);
            f2.f = new C3317j(f);
            f2.g = new C3317j(f);
            f2.h = new C3317j(f);
            setShapeAppearanceModel(f2.a());
        }
    }

    public final void H(Drawable drawable) {
        Drawable drawable2 = this.Q;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float v = v();
            this.Q = drawable != null ? drawable.mutate() : null;
            float v2 = v();
            b0(drawable2);
            if (Z()) {
                t(this.Q);
            }
            invalidateSelf();
            if (v != v2) {
                A();
            }
        }
    }

    public final void I(float f) {
        if (this.S != f) {
            float v = v();
            this.S = f;
            float v2 = v();
            invalidateSelf();
            if (v != v2) {
                A();
            }
        }
    }

    public final void J(ColorStateList colorStateList) {
        this.T = true;
        if (this.R != colorStateList) {
            this.R = colorStateList;
            if (Z()) {
                this.Q.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void K(boolean z) {
        if (this.P != z) {
            boolean Z = Z();
            this.P = z;
            boolean Z2 = Z();
            if (Z != Z2) {
                if (Z2) {
                    t(this.Q);
                } else {
                    b0(this.Q);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void L(ColorStateList colorStateList) {
        if (this.L != colorStateList) {
            this.L = colorStateList;
            if (this.O0) {
                HE he = this.b;
                if (he.e != colorStateList) {
                    he.e = colorStateList;
                    onStateChange(getState());
                }
            }
            onStateChange(getState());
        }
    }

    public final void M(float f) {
        if (this.M != f) {
            this.M = f;
            this.p0.setStrokeWidth(f);
            if (this.O0) {
                this.b.k = f;
                invalidateSelf();
            }
            invalidateSelf();
        }
    }

    public final void N(Drawable drawable) {
        Drawable drawable2 = this.V;
        if (drawable2 == null) {
            drawable2 = null;
        }
        if (drawable2 != drawable) {
            float w = w();
            this.V = drawable != null ? drawable.mutate() : null;
            this.W = new RippleDrawable(NO.a(this.N), this.V, Q0);
            float w2 = w();
            b0(drawable2);
            if (a0()) {
                t(this.V);
            }
            invalidateSelf();
            if (w != w2) {
                A();
            }
        }
    }

    public final void O(float f) {
        if (this.m0 != f) {
            this.m0 = f;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final void P(float f) {
        if (this.Y != f) {
            this.Y = f;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final void Q(float f) {
        if (this.l0 != f) {
            this.l0 = f;
            invalidateSelf();
            if (a0()) {
                A();
            }
        }
    }

    public final boolean R(int[] iArr) {
        if (Arrays.equals(this.I0, iArr)) {
            return false;
        }
        this.I0 = iArr;
        if (a0()) {
            return B(getState(), iArr);
        }
        return false;
    }

    public final void S(ColorStateList colorStateList) {
        if (this.X != colorStateList) {
            this.X = colorStateList;
            if (a0()) {
                this.V.setTintList(colorStateList);
            }
            onStateChange(getState());
        }
    }

    public final void T(boolean z) {
        if (this.U != z) {
            boolean a0 = a0();
            this.U = z;
            boolean a02 = a0();
            if (a0 != a02) {
                if (a02) {
                    t(this.V);
                } else {
                    b0(this.V);
                }
                invalidateSelf();
                A();
            }
        }
    }

    public final void U(float f) {
        if (this.i0 != f) {
            float v = v();
            this.i0 = f;
            float v2 = v();
            invalidateSelf();
            if (v != v2) {
                A();
            }
        }
    }

    public final void V(float f) {
        if (this.h0 != f) {
            float v = v();
            this.h0 = f;
            float v2 = v();
            invalidateSelf();
            if (v != v2) {
                A();
            }
        }
    }

    public final void W(ColorStateList colorStateList) {
        if (this.N != colorStateList) {
            this.N = colorStateList;
            this.J0 = null;
            onStateChange(getState());
        }
    }

    public final void X(C4547yW c4547yW) {
        BW bw = this.u0;
        if (bw.f != c4547yW) {
            bw.f = c4547yW;
            if (c4547yW != null) {
                TextPaint textPaint = bw.a;
                Context context = this.o0;
                C4004rd c4004rd = bw.b;
                c4547yW.e(context, textPaint, c4004rd);
                AW aw = (AW) bw.e.get();
                if (aw != null) {
                    textPaint.drawableState = aw.getState();
                }
                c4547yW.d(context, textPaint, c4004rd);
                bw.d = true;
            }
            AW aw2 = (AW) bw.e.get();
            if (aw2 != null) {
                C4320vd c4320vd = (C4320vd) aw2;
                c4320vd.A();
                c4320vd.invalidateSelf();
                c4320vd.onStateChange(aw2.getState());
            }
        }
    }

    public final boolean Y() {
        return this.b0 && this.c0 != null && this.B0;
    }

    public final boolean Z() {
        return this.P && this.Q != null;
    }

    public final boolean a0() {
        return this.U && this.V != null;
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Canvas canvas2;
        int i2;
        int i3;
        Rect bounds = getBounds();
        if (bounds.isEmpty() || (i = this.D0) == 0) {
            return;
        }
        if (i < 255) {
            canvas2 = canvas;
            i2 = canvas2.saveLayerAlpha(bounds.left, bounds.top, bounds.right, bounds.bottom, i);
        } else {
            canvas2 = canvas;
            i2 = 0;
        }
        boolean z = this.O0;
        Paint paint = this.p0;
        RectF rectF = this.r0;
        if (!z) {
            paint.setColor(this.v0);
            paint.setStyle(Paint.Style.FILL);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (!this.O0) {
            paint.setColor(this.w0);
            paint.setStyle(Paint.Style.FILL);
            ColorFilter colorFilter = this.E0;
            if (colorFilter == null) {
                colorFilter = this.F0;
            }
            paint.setColorFilter(colorFilter);
            rectF.set(bounds);
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (this.O0) {
            super.draw(canvas);
        }
        if (this.M > 0.0f && !this.O0) {
            paint.setColor(this.y0);
            paint.setStyle(Paint.Style.STROKE);
            if (!this.O0) {
                ColorFilter colorFilter2 = this.E0;
                if (colorFilter2 == null) {
                    colorFilter2 = this.F0;
                }
                paint.setColorFilter(colorFilter2);
            }
            float f = bounds.left;
            float f2 = this.M / 2.0f;
            rectF.set(f + f2, bounds.top + f2, bounds.right - f2, bounds.bottom - f2);
            float f3 = this.K - (this.M / 2.0f);
            canvas2.drawRoundRect(rectF, f3, f3, paint);
        }
        paint.setColor(this.z0);
        paint.setStyle(Paint.Style.FILL);
        rectF.set(bounds);
        if (this.O0) {
            RectF rectF2 = new RectF(bounds);
            Path path = this.t0;
            HE he = this.b;
            this.s.a(he.a, this.C, he.j, rectF2, this.r, path);
            e(canvas2, paint, path, this.b.a, this.C, g());
        } else {
            canvas2.drawRoundRect(rectF, x(), x(), paint);
        }
        if (Z()) {
            u(bounds, rectF);
            float f4 = rectF.left;
            float f5 = rectF.top;
            canvas2.translate(f4, f5);
            this.Q.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.Q.draw(canvas2);
            canvas2.translate(-f4, -f5);
        }
        if (Y()) {
            u(bounds, rectF);
            float f6 = rectF.left;
            float f7 = rectF.top;
            canvas2.translate(f6, f7);
            this.c0.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.c0.draw(canvas2);
            canvas2.translate(-f6, -f7);
        }
        if (this.M0 && this.O != null) {
            PointF pointF = this.s0;
            pointF.set(0.0f, 0.0f);
            Paint.Align align = Paint.Align.LEFT;
            CharSequence charSequence = this.O;
            BW bw = this.u0;
            if (charSequence != null) {
                float v = v() + this.g0 + this.j0;
                if (getLayoutDirection() == 0) {
                    pointF.x = bounds.left + v;
                } else {
                    pointF.x = bounds.right - v;
                    align = Paint.Align.RIGHT;
                }
                float centerY = bounds.centerY();
                TextPaint textPaint = bw.a;
                Paint.FontMetrics fontMetrics = this.q0;
                textPaint.getFontMetrics(fontMetrics);
                pointF.y = centerY - ((fontMetrics.descent + fontMetrics.ascent) / 2.0f);
            }
            rectF.setEmpty();
            if (this.O != null) {
                float v2 = v() + this.g0 + this.j0;
                float w = w() + this.n0 + this.k0;
                if (getLayoutDirection() == 0) {
                    rectF.left = bounds.left + v2;
                    rectF.right = bounds.right - w;
                } else {
                    rectF.left = bounds.left + w;
                    rectF.right = bounds.right - v2;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
            C4547yW c4547yW = bw.f;
            TextPaint textPaint2 = bw.a;
            if (c4547yW != null) {
                textPaint2.drawableState = getState();
                bw.f.d(this.o0, textPaint2, bw.b);
            }
            textPaint2.setTextAlign(align);
            boolean z2 = Math.round(bw.a(this.O.toString())) > Math.round(rectF.width());
            if (z2) {
                int save = canvas2.save();
                canvas2.clipRect(rectF);
                i3 = save;
            } else {
                i3 = 0;
            }
            CharSequence charSequence2 = this.O;
            if (z2 && this.L0 != null) {
                charSequence2 = TextUtils.ellipsize(charSequence2, textPaint2, rectF.width(), this.L0);
            }
            canvas.drawText(charSequence2, 0, charSequence2.length(), pointF.x, pointF.y, textPaint2);
            canvas2 = canvas;
            if (z2) {
                canvas2.restoreToCount(i3);
            }
        }
        if (a0()) {
            rectF.setEmpty();
            if (a0()) {
                float f8 = this.n0 + this.m0;
                if (getLayoutDirection() == 0) {
                    float f9 = bounds.right - f8;
                    rectF.right = f9;
                    rectF.left = f9 - this.Y;
                } else {
                    float f10 = bounds.left + f8;
                    rectF.left = f10;
                    rectF.right = f10 + this.Y;
                }
                float exactCenterY = bounds.exactCenterY();
                float f11 = this.Y;
                float f12 = exactCenterY - (f11 / 2.0f);
                rectF.top = f12;
                rectF.bottom = f12 + f11;
            }
            float f13 = rectF.left;
            float f14 = rectF.top;
            canvas2.translate(f13, f14);
            this.V.setBounds(0, 0, (int) rectF.width(), (int) rectF.height());
            this.W.setBounds(this.V.getBounds());
            this.W.jumpToCurrentState();
            this.W.draw(canvas2);
            canvas2.translate(-f13, -f14);
        }
        if (this.D0 < 255) {
            canvas2.restoreToCount(i2);
        }
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final int getAlpha() {
        return this.D0;
    }

    @Override // android.graphics.drawable.Drawable
    public final ColorFilter getColorFilter() {
        return this.E0;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return (int) this.J;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return Math.min(Math.round(w() + this.u0.a(this.O.toString()) + v() + this.g0 + this.j0 + this.k0 + this.n0), this.N0);
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final int getOpacity() {
        return -3;
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        Outline outline2;
        if (this.O0) {
            super.getOutline(outline);
            return;
        }
        Rect bounds = getBounds();
        if (bounds.isEmpty()) {
            outline2 = outline;
            outline2.setRoundRect(0, 0, getIntrinsicWidth(), (int) this.J, this.K);
        } else {
            outline.setRoundRect(bounds, this.K);
            outline2 = outline;
        }
        outline2.setAlpha(this.D0 / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final boolean isStateful() {
        ColorStateList colorStateList;
        if (y(this.H) || y(this.I) || y(this.L)) {
            return true;
        }
        C4547yW c4547yW = this.u0.f;
        if (c4547yW == null || (colorStateList = c4547yW.k) == null || !colorStateList.isStateful()) {
            return (this.b0 && this.c0 != null && this.a0) || z(this.Q) || z(this.c0) || y(this.G0);
        }
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        boolean onLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (Z()) {
            onLayoutDirectionChanged |= this.Q.setLayoutDirection(i);
        }
        if (Y()) {
            onLayoutDirectionChanged |= this.c0.setLayoutDirection(i);
        }
        if (a0()) {
            onLayoutDirectionChanged |= this.V.setLayoutDirection(i);
        }
        if (!onLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        boolean onLevelChange = super.onLevelChange(i);
        if (Z()) {
            onLevelChange |= this.Q.setLevel(i);
        }
        if (Y()) {
            onLevelChange |= this.c0.setLevel(i);
        }
        if (a0()) {
            onLevelChange |= this.V.setLevel(i);
        }
        if (onLevelChange) {
            invalidateSelf();
        }
        return onLevelChange;
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        if (this.O0) {
            super.onStateChange(iArr);
        }
        return B(iArr, this.I0);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        if (this.D0 != i) {
            this.D0 = i;
            invalidateSelf();
        }
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        if (this.E0 != colorFilter) {
            this.E0 = colorFilter;
            invalidateSelf();
        }
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (this.G0 != colorStateList) {
            this.G0 = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // defpackage.JE, android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (this.H0 != mode) {
            this.H0 = mode;
            ColorStateList colorStateList = this.G0;
            this.F0 = (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (Z()) {
            visible |= this.Q.setVisible(z, z2);
        }
        if (Y()) {
            visible |= this.c0.setVisible(z, z2);
        }
        if (a0()) {
            visible |= this.V.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    public final void t(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        drawable.setCallback(this);
        drawable.setLayoutDirection(getLayoutDirection());
        drawable.setLevel(getLevel());
        drawable.setVisible(isVisible(), false);
        if (drawable == this.V) {
            if (drawable.isStateful()) {
                drawable.setState(this.I0);
            }
            drawable.setTintList(this.X);
            return;
        }
        Drawable drawable2 = this.Q;
        if (drawable == drawable2 && this.T) {
            drawable2.setTintList(this.R);
        }
        if (drawable.isStateful()) {
            drawable.setState(getState());
        }
    }

    public final void u(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (Z() || Y()) {
            float f = this.g0 + this.h0;
            Drawable drawable = this.B0 ? this.c0 : this.Q;
            float f2 = this.S;
            if (f2 <= 0.0f && drawable != null) {
                f2 = drawable.getIntrinsicWidth();
            }
            if (getLayoutDirection() == 0) {
                float f3 = rect.left + f;
                rectF.left = f3;
                rectF.right = f3 + f2;
            } else {
                float f4 = rect.right - f;
                rectF.right = f4;
                rectF.left = f4 - f2;
            }
            Drawable drawable2 = this.B0 ? this.c0 : this.Q;
            float f5 = this.S;
            if (f5 <= 0.0f && drawable2 != null) {
                f5 = (float) Math.ceil(TypedValue.applyDimension(1, 24, this.o0.getResources().getDisplayMetrics()));
                if (drawable2.getIntrinsicHeight() <= f5) {
                    f5 = drawable2.getIntrinsicHeight();
                }
            }
            float exactCenterY = rect.exactCenterY() - (f5 / 2.0f);
            rectF.top = exactCenterY;
            rectF.bottom = exactCenterY + f5;
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    public final float v() {
        if (!Z() && !Y()) {
            return 0.0f;
        }
        float f = this.h0;
        Drawable drawable = this.B0 ? this.c0 : this.Q;
        float f2 = this.S;
        if (f2 <= 0.0f && drawable != null) {
            f2 = drawable.getIntrinsicWidth();
        }
        return f2 + f + this.i0;
    }

    public final float w() {
        if (a0()) {
            return this.l0 + this.Y + this.m0;
        }
        return 0.0f;
    }

    public final float x() {
        if (!this.O0) {
            return this.K;
        }
        float[] fArr = this.C;
        return fArr != null ? fArr[3] : this.b.a.e.a(g());
    }
}
