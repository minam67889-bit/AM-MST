package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import app.vpn.amtunnellite.R;
import java.util.List;

/* loaded from: classes.dex */
public final class I20 extends M20 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final C4912zp f = new C4912zp(0);
    public static final DecelerateInterpolator g = new DecelerateInterpolator();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void e(View view) {
        C0247Iw j = j(view);
        if (j != null) {
            ((View) j.d).setTranslationY(0.0f);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void f(View view, WindowInsets windowInsets, boolean z) {
        C0247Iw j = j(view);
        if (j != null) {
            j.c = windowInsets;
            if (!z) {
                View view2 = (View) j.d;
                int[] iArr = (int[]) j.e;
                view2.getLocationOnScreen(iArr);
                z = true;
                j.a = iArr[1];
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), windowInsets, z);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void g(View view, C0700a30 c0700a30, List list) {
        C0247Iw j = j(view);
        if (j != null) {
            j.f(c0700a30, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), c0700a30, list);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void h(View view, C4142po c4142po) {
        C0247Iw j = j(view);
        if (j != null) {
            View view2 = (View) j.d;
            int[] iArr = (int[]) j.e;
            view2.getLocationOnScreen(iArr);
            int i = j.a - iArr[1];
            j.b = i;
            view2.setTranslationY(i);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                h(viewGroup.getChildAt(i2), c4142po);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static WindowInsets i(View view, WindowInsets windowInsets) {
        if (view.getTag(R.id.tag_on_apply_window_listener) != null) {
            return windowInsets;
        }
        return view.onApplyWindowInsets(windowInsets);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C0247Iw j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof H20) {
            return ((H20) tag).a;
        }
        return null;
    }
}
