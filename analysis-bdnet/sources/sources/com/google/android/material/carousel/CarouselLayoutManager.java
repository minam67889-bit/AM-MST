package com.google.android.material.carousel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.carousel.CarouselLayoutManager;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2953eN;
import defpackage.C0816bc;
import defpackage.C0895cc;
import defpackage.C2891dc;
import defpackage.C3033fN;
import defpackage.C3431kN;
import defpackage.C3907qN;
import defpackage.C4174tm;
import defpackage.FM;
import defpackage.InterfaceC3828pN;
import defpackage.W50;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends AbstractC2953eN implements InterfaceC3828pN {
    public final C4174tm p;
    public C2891dc q;
    public final View.OnLayoutChangeListener r;

    public CarouselLayoutManager() {
        C4174tm c4174tm = new C4174tm();
        new C0895cc();
        this.r = new View.OnLayoutChangeListener() { // from class: ac
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                if (i3 - i == i7 - i5 && i4 - i2 == i8 - i6) {
                    return;
                }
                view.post(new RunnableC3954r1(carouselLayoutManager, 2));
            }
        };
        this.p = c4174tm;
        m0();
        E0(0);
    }

    public final float B0(float f, float f2) {
        return D0() ? f - f2 : f + f2;
    }

    public final boolean C0() {
        return this.q.a == 0;
    }

    public final boolean D0() {
        return C0() && C() == 1;
    }

    public final void E0(int i) {
        C2891dc c2891dc;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(W50.i(i, "invalid orientation:"));
        }
        c(null);
        C2891dc c2891dc2 = this.q;
        if (c2891dc2 == null || i != c2891dc2.a) {
            if (i == 0) {
                c2891dc = new C2891dc(this, 1);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                c2891dc = new C2891dc(this, 0);
            }
            this.q = c2891dc;
            m0();
        }
    }

    @Override // defpackage.AbstractC2953eN
    public final boolean L() {
        return true;
    }

    @Override // defpackage.AbstractC2953eN
    public final void R(RecyclerView recyclerView) {
        C4174tm c4174tm = this.p;
        Context context = recyclerView.getContext();
        float f = c4174tm.a;
        if (f <= 0.0f) {
            f = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        c4174tm.a = f;
        float f2 = c4174tm.b;
        if (f2 <= 0.0f) {
            f2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        c4174tm.b = f2;
        m0();
        recyclerView.addOnLayoutChangeListener(this.r);
    }

    @Override // defpackage.AbstractC2953eN
    public final void S(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:
    
        if (r6 == 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0044, code lost:
    
        if (D0() != false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0048, code lost:
    
        if (r6 == 1) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0051, code lost:
    
        if (D0() != false) goto L20;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.AbstractC2953eN
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View T(View view, int i, C3431kN c3431kN, C3907qN c3907qN) {
        char c;
        if (v() == 0) {
            return null;
        }
        int i2 = this.q.a;
        if (i != 1) {
            if (i != 2) {
                if (i == 17) {
                    if (i2 == 0) {
                    }
                    c = 0;
                } else if (i != 33) {
                    if (i != 66) {
                        if (i != 130) {
                            Log.d("CarouselLayoutManager", "Unknown focus request:" + i);
                        }
                        c = 0;
                    } else {
                        if (i2 == 0) {
                        }
                        c = 0;
                    }
                }
                if (c == 0) {
                    return null;
                }
                if (c == 65535) {
                    if (AbstractC2953eN.H(view) == 0) {
                        return null;
                    }
                    int H = AbstractC2953eN.H(u(0)) - 1;
                    if (H < 0 || H >= B()) {
                        return u(D0() ? v() - 1 : 0);
                    }
                    this.q.a();
                    throw null;
                }
                if (AbstractC2953eN.H(view) == B() - 1) {
                    return null;
                }
                int H2 = AbstractC2953eN.H(u(v() - 1)) + 1;
                if (H2 < 0 || H2 >= B()) {
                    return u(D0() ? 0 : v() - 1);
                }
                this.q.a();
                throw null;
            }
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    @Override // defpackage.AbstractC2953eN
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(AbstractC2953eN.H(u(0)));
            accessibilityEvent.setToIndex(AbstractC2953eN.H(u(v() - 1)));
        }
    }

    @Override // defpackage.AbstractC2953eN
    public final void X(int i, int i2) {
        B();
    }

    @Override // defpackage.AbstractC2953eN
    public final void Y() {
        B();
    }

    @Override // defpackage.InterfaceC3828pN
    public final PointF a(int i) {
        return null;
    }

    @Override // defpackage.AbstractC2953eN
    public final void a0(int i, int i2) {
        B();
    }

    @Override // defpackage.AbstractC2953eN
    public final void c0(C3431kN c3431kN, C3907qN c3907qN) {
        if (c3907qN.b() > 0) {
            if ((C0() ? this.n : this.o) > 0.0f) {
                D0();
                c3431kN.d(0);
                throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
            }
        }
        h0(c3431kN);
    }

    @Override // defpackage.AbstractC2953eN
    public final boolean d() {
        return C0();
    }

    @Override // defpackage.AbstractC2953eN
    public final void d0(C3907qN c3907qN) {
        if (v() == 0) {
            return;
        }
        AbstractC2953eN.H(u(0));
    }

    @Override // defpackage.AbstractC2953eN
    public final boolean e() {
        return !C0();
    }

    @Override // defpackage.AbstractC2953eN
    public final int j(C3907qN c3907qN) {
        v();
        return 0;
    }

    @Override // defpackage.AbstractC2953eN
    public final int k(C3907qN c3907qN) {
        return 0;
    }

    @Override // defpackage.AbstractC2953eN
    public final int l(C3907qN c3907qN) {
        return 0;
    }

    @Override // defpackage.AbstractC2953eN
    public final boolean l0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    @Override // defpackage.AbstractC2953eN
    public final int m(C3907qN c3907qN) {
        v();
        return 0;
    }

    @Override // defpackage.AbstractC2953eN
    public final int n(C3907qN c3907qN) {
        return 0;
    }

    @Override // defpackage.AbstractC2953eN
    public final int n0(int i, C3431kN c3431kN, C3907qN c3907qN) {
        if (!C0() || v() == 0 || i == 0) {
            return 0;
        }
        c3431kN.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // defpackage.AbstractC2953eN
    public final int o(C3907qN c3907qN) {
        return 0;
    }

    @Override // defpackage.AbstractC2953eN
    public final void o0(int i) {
    }

    @Override // defpackage.AbstractC2953eN
    public final int p0(int i, C3431kN c3431kN, C3907qN c3907qN) {
        if (!e() || v() == 0 || i == 0) {
            return 0;
        }
        c3431kN.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    @Override // defpackage.AbstractC2953eN
    public final C3033fN r() {
        return new C3033fN(-2, -2);
    }

    @Override // defpackage.AbstractC2953eN
    public final void y(View view, Rect rect) {
        super.y(view, rect);
        rect.centerY();
        if (C0()) {
            rect.centerX();
        }
        throw null;
    }

    @Override // defpackage.AbstractC2953eN
    public final void y0(RecyclerView recyclerView, int i) {
        C0816bc c0816bc = new C0816bc(0, recyclerView.getContext(), this);
        c0816bc.a = i;
        z0(c0816bc);
    }

    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        new C0895cc();
        this.r = new View.OnLayoutChangeListener() { // from class: ac
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i22, int i32, int i4, int i5, int i6, int i7, int i8) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                if (i32 - i3 == i7 - i5 && i4 - i22 == i8 - i6) {
                    return;
                }
                view.post(new RunnableC3954r1(carouselLayoutManager, 2));
            }
        };
        this.p = new C4174tm();
        m0();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.d);
            obtainStyledAttributes.getInt(0, 0);
            m0();
            E0(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
