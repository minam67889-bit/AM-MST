package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.PathInterpolator;
import dastan.prince.bdfreevpn.R;
import java.util.List;

/* loaded from: classes.dex */
public final class S30 extends V30 {
    public static final PathInterpolator e = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
    public static final C0544Up f = new C0544Up();
    public static final DecelerateInterpolator g = new DecelerateInterpolator(1.5f);
    public static final AccelerateInterpolator h = new AccelerateInterpolator(1.5f);

    public static void e(View view, W30 w30) {
        C4580yx j = j(view);
        if (j != null) {
            j.f(w30);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                e(viewGroup.getChildAt(i), w30);
            }
        }
    }

    public static void f(View view, W30 w30, C4119t40 c4119t40, boolean z) {
        C4580yx j = j(view);
        if (j != null) {
            j.c = c4119t40;
            if (!z) {
                j.g(w30);
                z = true;
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                f(viewGroup.getChildAt(i), w30, c4119t40, z);
            }
        }
    }

    public static void g(View view, C4119t40 c4119t40, List list) {
        C4580yx j = j(view);
        if (j != null) {
            j.h(c4119t40, list);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                g(viewGroup.getChildAt(i), c4119t40, list);
            }
        }
    }

    public static void h(View view, W30 w30, C0595Wo c0595Wo) {
        C4580yx j = j(view);
        if (j != null) {
            j.i(w30, c0595Wo);
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                h(viewGroup.getChildAt(i), w30, c0595Wo);
            }
        }
    }

    public static WindowInsets i(View view, WindowInsets windowInsets) {
        return view.getTag(R.id.tag_on_apply_window_listener) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
    }

    public static C4580yx j(View view) {
        Object tag = view.getTag(R.id.tag_window_insets_animation_callback);
        if (tag instanceof R30) {
            return ((R30) tag).a;
        }
        return null;
    }
}
