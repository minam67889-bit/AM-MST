package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.appcompat.widget.ActionBarContextView;
import dastan.prince.bdfreevpn.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class W4 implements OI, InterfaceC4451xF {
    public final /* synthetic */ LayoutInflaterFactory2C3250i5 a;

    public /* synthetic */ W4(LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5) {
        this.a = layoutInflaterFactory2C3250i5;
    }

    @Override // defpackage.InterfaceC4451xF
    public void b(MenuC2945eF menuC2945eF, boolean z) {
        C3170h5 c3170h5;
        MenuC2945eF k = menuC2945eF.k();
        int i = 0;
        boolean z2 = k != menuC2945eF;
        if (z2) {
            menuC2945eF = k;
        }
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.a;
        C3170h5[] c3170h5Arr = layoutInflaterFactory2C3250i5.L;
        int length = c3170h5Arr != null ? c3170h5Arr.length : 0;
        while (true) {
            if (i < length) {
                c3170h5 = c3170h5Arr[i];
                if (c3170h5 != null && c3170h5.h == menuC2945eF) {
                    break;
                } else {
                    i++;
                }
            } else {
                c3170h5 = null;
                break;
            }
        }
        if (c3170h5 != null) {
            if (!z2) {
                layoutInflaterFactory2C3250i5.s(c3170h5, z);
            } else {
                layoutInflaterFactory2C3250i5.p(c3170h5.a, c3170h5, k);
                layoutInflaterFactory2C3250i5.s(c3170h5, true);
            }
        }
    }

    @Override // defpackage.InterfaceC4451xF
    public boolean k(MenuC2945eF menuC2945eF) {
        Window.Callback callback;
        if (menuC2945eF != menuC2945eF.k()) {
            return true;
        }
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.a;
        if (!layoutInflaterFactory2C3250i5.F || (callback = layoutInflaterFactory2C3250i5.l.getCallback()) == null || layoutInflaterFactory2C3250i5.Q) {
            return true;
        }
        callback.onMenuOpened(108, menuC2945eF);
        return true;
    }

    @Override // defpackage.OI
    public C4119t40 m(View view, C4119t40 c4119t40) {
        int i;
        boolean z;
        C4119t40 c4119t402;
        boolean z2;
        int d = c4119t40.d();
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.a;
        layoutInflaterFactory2C3250i5.getClass();
        int d2 = c4119t40.d();
        ActionBarContextView actionBarContextView = layoutInflaterFactory2C3250i5.v;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            i = 0;
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutInflaterFactory2C3250i5.v.getLayoutParams();
            if (layoutInflaterFactory2C3250i5.v.isShown()) {
                if (layoutInflaterFactory2C3250i5.c0 == null) {
                    layoutInflaterFactory2C3250i5.c0 = new Rect();
                    layoutInflaterFactory2C3250i5.d0 = new Rect();
                }
                Rect rect = layoutInflaterFactory2C3250i5.c0;
                Rect rect2 = layoutInflaterFactory2C3250i5.d0;
                rect.set(c4119t40.b(), c4119t40.d(), c4119t40.c(), c4119t40.a());
                ViewGroup viewGroup = layoutInflaterFactory2C3250i5.A;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z3 = G20.a;
                    C20.a(viewGroup, rect, rect2);
                } else {
                    if (!G20.a) {
                        G20.a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            G20.b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                G20.b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = G20.b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                }
                int i2 = rect.top;
                int i3 = rect.left;
                int i4 = rect.right;
                ViewGroup viewGroup2 = layoutInflaterFactory2C3250i5.A;
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                C4119t40 a = X10.a(viewGroup2);
                int b = a == null ? 0 : a.b();
                int c = a == null ? 0 : a.c();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                Context context = layoutInflaterFactory2C3250i5.k;
                if (i2 <= 0 || layoutInflaterFactory2C3250i5.C != null) {
                    View view2 = layoutInflaterFactory2C3250i5.C;
                    if (view2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != b || marginLayoutParams2.rightMargin != c) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = b;
                            marginLayoutParams2.rightMargin = c;
                            layoutInflaterFactory2C3250i5.C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view3 = new View(context);
                    layoutInflaterFactory2C3250i5.C = view3;
                    view3.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b;
                    layoutParams.rightMargin = c;
                    layoutInflaterFactory2C3250i5.A.addView(layoutInflaterFactory2C3250i5.C, -1, layoutParams);
                }
                View view4 = layoutInflaterFactory2C3250i5.C;
                r11 = view4 != null;
                if (r11 && view4.getVisibility() != 0) {
                    View view5 = layoutInflaterFactory2C3250i5.C;
                    view5.setBackgroundColor((view5.getWindowSystemUiVisibility() & JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE) != 0 ? context.getColor(R.color.abc_decor_view_status_guard_light) : context.getColor(R.color.abc_decor_view_status_guard));
                }
                if (!layoutInflaterFactory2C3250i5.H && r11) {
                    d2 = 0;
                }
                z = r11;
                r11 = z2;
                i = 0;
            } else {
                i = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                } else {
                    z = false;
                    r11 = false;
                }
            }
            if (r11) {
                layoutInflaterFactory2C3250i5.v.setLayoutParams(marginLayoutParams);
            }
        }
        View view6 = layoutInflaterFactory2C3250i5.C;
        if (view6 != null) {
            view6.setVisibility(z ? i : 8);
        }
        if (d != d2) {
            int b2 = c4119t40.b();
            int c2 = c4119t40.c();
            int a2 = c4119t40.a();
            int i7 = Build.VERSION.SDK_INT;
            AbstractC2929e40 c2850d40 = i7 >= 36 ? new C2850d40(c4119t40) : i7 >= 35 ? new C0854c40(c4119t40) : i7 >= 34 ? new C0775b40(c4119t40) : i7 >= 31 ? new C0695a40(c4119t40) : i7 >= 30 ? new Z30(c4119t40) : i7 >= 29 ? new Y30(c4119t40) : new X30(c4119t40);
            c2850d40.h(C4501xx.b(b2, d2, c2, a2));
            c4119t402 = c2850d40.b();
        } else {
            c4119t402 = c4119t40;
        }
        WeakHashMap weakHashMap2 = AbstractC2925e20.a;
        WindowInsets f = c4119t402.f();
        if (f == null) {
            return c4119t402;
        }
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        return !onApplyWindowInsets.equals(f) ? C4119t40.g(view, onApplyWindowInsets) : c4119t402;
    }
}
