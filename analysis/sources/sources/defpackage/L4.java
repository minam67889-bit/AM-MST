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
import app.vpn.amtunnellite.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class L4 implements PH, InterfaceC3596ig, HE {
    public final /* synthetic */ int a;
    public final /* synthetic */ X4 b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ L4(X4 x4, int i) {
        this.a = i;
        this.b = x4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.HE
    public void a(MenuC3948nE menuC3948nE, boolean z) {
        boolean z2;
        int i;
        W4 w4;
        switch (this.a) {
            case 2:
                this.b.r(menuC3948nE);
                break;
            default:
                MenuC3948nE k = menuC3948nE.k();
                int i2 = 0;
                if (k != menuC3948nE) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (z2) {
                    menuC3948nE = k;
                }
                X4 x4 = this.b;
                W4[] w4Arr = x4.L;
                if (w4Arr != null) {
                    i = w4Arr.length;
                } else {
                    i = 0;
                }
                while (true) {
                    if (i2 < i) {
                        w4 = w4Arr[i2];
                        if (w4 == null || w4.h != menuC3948nE) {
                            i2++;
                        }
                    } else {
                        w4 = null;
                    }
                }
                if (w4 != null) {
                    if (z2) {
                        x4.q(w4.a, w4, k);
                        x4.s(w4, true);
                        break;
                    } else {
                        x4.s(w4, z);
                        break;
                    }
                }
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.PH
    public C0700a30 h(View view, C0700a30 c0700a30) {
        int i;
        boolean z;
        C0700a30 c0700a302;
        R20 o20;
        int i2;
        int b;
        int c;
        boolean z2;
        int i3;
        int d = c0700a30.d();
        X4 x4 = this.b;
        x4.getClass();
        int d2 = c0700a30.d();
        ActionBarContextView actionBarContextView = x4.v;
        if (actionBarContextView != null && (actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) x4.v.getLayoutParams();
            boolean z3 = true;
            if (x4.v.isShown()) {
                if (x4.c0 == null) {
                    x4.c0 = new Rect();
                    x4.d0 = new Rect();
                }
                Rect rect = x4.c0;
                Rect rect2 = x4.d0;
                rect.set(c0700a30.b(), c0700a30.d(), c0700a30.c(), c0700a30.a());
                ViewGroup viewGroup = x4.A;
                if (Build.VERSION.SDK_INT >= 29) {
                    boolean z4 = AbstractC4388t10.a;
                    AbstractC4081p10.a(viewGroup, rect, rect2);
                } else {
                    if (!AbstractC4388t10.a) {
                        AbstractC4388t10.a = true;
                        try {
                            Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", Rect.class, Rect.class);
                            AbstractC4388t10.b = declaredMethod;
                            if (!declaredMethod.isAccessible()) {
                                AbstractC4388t10.b.setAccessible(true);
                            }
                        } catch (NoSuchMethodException unused) {
                            Log.d("ViewUtils", "Could not find method computeFitSystemWindows. Oh well.");
                        }
                    }
                    Method method = AbstractC4388t10.b;
                    if (method != null) {
                        try {
                            method.invoke(viewGroup, rect, rect2);
                        } catch (Exception e) {
                            Log.d("ViewUtils", "Could not invoke computeFitSystemWindows", e);
                        }
                    }
                }
                int i4 = rect.top;
                int i5 = rect.left;
                int i6 = rect.right;
                ViewGroup viewGroup2 = x4.A;
                WeakHashMap weakHashMap = T00.a;
                C0700a30 a = M00.a(viewGroup2);
                if (a == null) {
                    b = 0;
                } else {
                    b = a.b();
                }
                if (a == null) {
                    c = 0;
                } else {
                    c = a.c();
                }
                if (marginLayoutParams.topMargin == i4 && marginLayoutParams.leftMargin == i5 && marginLayoutParams.rightMargin == i6) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i4;
                    marginLayoutParams.leftMargin = i5;
                    marginLayoutParams.rightMargin = i6;
                    z2 = true;
                }
                Context context = x4.k;
                if (i4 > 0 && x4.C == null) {
                    View view2 = new View(context);
                    x4.C = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = b;
                    layoutParams.rightMargin = c;
                    x4.A.addView(x4.C, -1, layoutParams);
                } else {
                    View view3 = x4.C;
                    if (view3 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
                        int i7 = marginLayoutParams2.height;
                        int i8 = marginLayoutParams.topMargin;
                        if (i7 != i8 || marginLayoutParams2.leftMargin != b || marginLayoutParams2.rightMargin != c) {
                            marginLayoutParams2.height = i8;
                            marginLayoutParams2.leftMargin = b;
                            marginLayoutParams2.rightMargin = c;
                            x4.C.setLayoutParams(marginLayoutParams2);
                        }
                    }
                }
                View view4 = x4.C;
                if (view4 == null) {
                    z3 = false;
                }
                if (z3 && view4.getVisibility() != 0) {
                    View view5 = x4.C;
                    if ((view5.getWindowSystemUiVisibility() & JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE) != 0) {
                        i3 = R.color.abc_decor_view_status_guard_light;
                    } else {
                        i3 = R.color.abc_decor_view_status_guard;
                    }
                    view5.setBackgroundColor(context.getColor(i3));
                }
                if (!x4.H && z3) {
                    d2 = 0;
                }
                z = z3;
                z3 = z2;
                i = 0;
            } else {
                i = 0;
                if (marginLayoutParams.topMargin != 0) {
                    marginLayoutParams.topMargin = 0;
                    z = false;
                } else {
                    z = false;
                    z3 = false;
                }
            }
            if (z3) {
                x4.v.setLayoutParams(marginLayoutParams);
            }
        } else {
            i = 0;
            z = false;
        }
        View view6 = x4.C;
        if (view6 != null) {
            if (z) {
                i2 = i;
            } else {
                i2 = 8;
            }
            view6.setVisibility(i2);
        }
        if (d != d2) {
            int b2 = c0700a30.b();
            int c2 = c0700a30.c();
            int a2 = c0700a30.a();
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 30) {
                o20 = new Q20(c0700a30);
            } else if (i9 >= 29) {
                o20 = new P20(c0700a30);
            } else {
                o20 = new O20(c0700a30);
            }
            o20.g(C0221Hw.b(b2, d2, c2, a2));
            c0700a302 = o20.b();
        } else {
            c0700a302 = c0700a30;
        }
        WeakHashMap weakHashMap2 = T00.a;
        WindowInsets f = c0700a302.f();
        if (f != null) {
            WindowInsets b3 = J00.b(view, f);
            if (!b3.equals(f)) {
                return C0700a30.g(view, b3);
            }
            return c0700a302;
        }
        return c0700a302;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.HE
    public boolean r(MenuC3948nE menuC3948nE) {
        Window.Callback callback;
        switch (this.a) {
            case 2:
                Window.Callback callback2 = this.b.l.getCallback();
                if (callback2 != null) {
                    callback2.onMenuOpened(108, menuC3948nE);
                    break;
                }
                break;
            default:
                if (menuC3948nE == menuC3948nE.k()) {
                    X4 x4 = this.b;
                    if (x4.F && (callback = x4.l.getCallback()) != null && !x4.Q) {
                        callback.onMenuOpened(108, menuC3948nE);
                        break;
                    }
                }
                break;
        }
        return true;
    }
}
