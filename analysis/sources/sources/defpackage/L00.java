package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public abstract class L00 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C0700a30 b(View view, C0700a30 c0700a30, Rect rect) {
        WindowInsets f = c0700a30.f();
        if (f != null) {
            return C0700a30.g(view, view.computeSystemWindowInsets(f, rect));
        }
        rect.setEmpty();
        return c0700a30;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PorterDuff.Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float e(View view) {
        return view.getElevation();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String f(View view) {
        return view.getTransitionName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float g(View view) {
        return view.getZ();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void h(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void i(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void j(View view, float f) {
        view.setElevation(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void k(View view, PH ph) {
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, ph);
        }
        if (ph == null) {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        } else {
            view.setOnApplyWindowInsetsListener(new K00(view, ph));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void l(View view, String str) {
        view.setTransitionName(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void m(View view) {
        view.stopNestedScroll();
    }
}
