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
import app.vpn.amtunnellite.R;
import com.google.android.material.carousel.CarouselLayoutManager;
import defpackage.AbstractC0146Ez;
import defpackage.AbstractC3189dM;
import defpackage.C0355Nb;
import defpackage.C0381Ob;
import defpackage.C0407Pb;
import defpackage.C3265eM;
import defpackage.C3648jM;
import defpackage.C4063om;
import defpackage.C4110pM;
import defpackage.CL;
import defpackage.InterfaceC4033oM;
import defpackage.Q60;
import defpackage.T60;
import java.util.List;

/* loaded from: classes.dex */
public class CarouselLayoutManager extends AbstractC3189dM implements InterfaceC4033oM {
    public final C4063om p;
    public C0407Pb q;
    public final View.OnLayoutChangeListener r;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CarouselLayoutManager() {
        C4063om c4063om = new C4063om();
        new C0381Ob();
        this.r = new View.OnLayoutChangeListener() { // from class: Mb
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                carouselLayoutManager.getClass();
                if (i3 - i != i7 - i5 || i4 - i2 != i8 - i6) {
                    view.post(new RunnableC4080p1(carouselLayoutManager, 2));
                }
            }
        };
        this.p = c4063om;
        n0();
        I0(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Q60 F0(List list, float f, boolean z) {
        float f2 = Float.MAX_VALUE;
        int i = -1;
        int i2 = -1;
        int i3 = -1;
        int i4 = -1;
        float f3 = -3.4028235E38f;
        float f4 = Float.MAX_VALUE;
        float f5 = Float.MAX_VALUE;
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((AbstractC0146Ez) list.get(i5)).getClass();
            float abs = Math.abs(0.0f - f);
            if (0.0f <= f && abs <= f2) {
                i = i5;
                f2 = abs;
            }
            if (0.0f > f && abs <= f4) {
                i3 = i5;
                f4 = abs;
            }
            if (0.0f <= f5) {
                f5 = 0.0f;
                i2 = i5;
            }
            if (0.0f > f3) {
                f3 = 0.0f;
                i4 = i5;
            }
        }
        if (i == -1) {
            i = i2;
        }
        if (i3 == -1) {
            i3 = i4;
        }
        return new Q60((AbstractC0146Ez) list.get(i), (AbstractC0146Ez) list.get(i3));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float C0(float f, float f2) {
        return H0() ? f - f2 : f + f2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float D0(int i) {
        this.q.d();
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int E0() {
        return G0() ? this.n : this.o;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean G0() {
        return this.q.a == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean H0() {
        return G0() && C() == 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void I0(int i) {
        C0407Pb c0407Pb;
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(T60.w(i, "invalid orientation:"));
        }
        c(null);
        C0407Pb c0407Pb2 = this.q;
        if (c0407Pb2 == null || i != c0407Pb2.a) {
            if (i == 0) {
                c0407Pb = new C0407Pb(this, 1);
            } else {
                if (i != 1) {
                    throw new IllegalArgumentException("invalid orientation");
                }
                c0407Pb = new C0407Pb(this, 0);
            }
            this.q = c0407Pb;
            n0();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final boolean L() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void R(RecyclerView recyclerView) {
        C4063om c4063om = this.p;
        Context context = recyclerView.getContext();
        float f = c4063om.a;
        if (f <= 0.0f) {
            f = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_min);
        }
        c4063om.a = f;
        float f2 = c4063om.b;
        if (f2 <= 0.0f) {
            f2 = context.getResources().getDimension(R.dimen.m3_carousel_small_item_size_max);
        }
        c4063om.b = f2;
        h0();
        recyclerView.addOnLayoutChangeListener(this.r);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void S(RecyclerView recyclerView) {
        recyclerView.removeOnLayoutChangeListener(this.r);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x003a, code lost:
    
        if (r9 == 1) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0043, code lost:
    
        if (H0() != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0046, code lost:
    
        if (r9 == 1) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x004f, code lost:
    
        if (H0() != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View T(View view, int i, C3648jM c3648jM, C4110pM c4110pM) {
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
                int H = AbstractC3189dM.H(view);
                if (c == 65535) {
                    if (H == 0) {
                        return null;
                    }
                    int H2 = AbstractC3189dM.H(u(0)) - 1;
                    if (H2 < 0 || H2 >= B()) {
                        return u(H0() ? v() - 1 : 0);
                    }
                    D0(H2);
                    c3648jM.d(H2);
                    throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
                }
                if (H == B() - 1) {
                    return null;
                }
                int H3 = AbstractC3189dM.H(u(v() - 1)) + 1;
                if (H3 < 0 || H3 >= B()) {
                    return u(H0() ? 0 : v() - 1);
                }
                D0(H3);
                c3648jM.d(H3);
                throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
            }
            c = 1;
            if (c == 0) {
            }
        }
        c = 65535;
        if (c == 0) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            accessibilityEvent.setFromIndex(AbstractC3189dM.H(u(0)));
            accessibilityEvent.setToIndex(AbstractC3189dM.H(u(v() - 1)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void X(int i, int i2) {
        B();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void Y() {
        B();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4033oM
    public final PointF a(int i) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void a0(int i, int i2) {
        B();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void c0(C3648jM c3648jM, C4110pM c4110pM) {
        if (c4110pM.b() <= 0 || E0() <= 0.0f) {
            i0(c3648jM);
        } else {
            H0();
            c3648jM.d(0);
            throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final boolean d() {
        return G0();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void d0(C4110pM c4110pM) {
        if (v() == 0) {
            return;
        }
        AbstractC3189dM.H(u(0));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final boolean e() {
        return !G0();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int j(C4110pM c4110pM) {
        v();
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int k(C4110pM c4110pM) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int l(C4110pM c4110pM) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int m(C4110pM c4110pM) {
        v();
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final boolean m0(RecyclerView recyclerView, View view, Rect rect, boolean z, boolean z2) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int n(C4110pM c4110pM) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int o(C4110pM c4110pM) {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int o0(int i, C3648jM c3648jM, C4110pM c4110pM) {
        if (!G0() || v() == 0 || i == 0) {
            return 0;
        }
        c3648jM.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void p0(int i) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final int q0(int i, C3648jM c3648jM, C4110pM c4110pM) {
        if (!e() || v() == 0 || i == 0) {
            return 0;
        }
        c3648jM.d(0);
        throw new IllegalStateException("All children of a RecyclerView using CarouselLayoutManager must use MaskableFrameLayout as their root ViewGroup.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final C3265eM r() {
        return new C3265eM(-2, -2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void y(View view, Rect rect) {
        super.y(view, rect);
        rect.centerY();
        if (G0()) {
            rect.centerX();
        }
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3189dM
    public final void z0(RecyclerView recyclerView, int i) {
        C0355Nb c0355Nb = new C0355Nb(0, recyclerView.getContext(), this);
        c0355Nb.a = i;
        A0(c0355Nb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CarouselLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        new C0381Ob();
        this.r = new View.OnLayoutChangeListener() { // from class: Mb
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i22, int i32, int i4, int i5, int i6, int i7, int i8) {
                CarouselLayoutManager carouselLayoutManager = CarouselLayoutManager.this;
                carouselLayoutManager.getClass();
                if (i32 - i3 != i7 - i5 || i4 - i22 != i8 - i6) {
                    view.post(new RunnableC4080p1(carouselLayoutManager, 2));
                }
            }
        };
        this.p = new C4063om();
        n0();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CL.d);
            obtainStyledAttributes.getInt(0, 0);
            n0();
            I0(obtainStyledAttributes.getInt(0, 0));
            obtainStyledAttributes.recycle();
        }
    }
}
