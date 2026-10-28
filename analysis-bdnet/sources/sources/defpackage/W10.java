package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public abstract class W10 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static C4119t40 b(View view, C4119t40 c4119t40, Rect rect) {
        WindowInsets f = c4119t40.f();
        if (f != null) {
            return C4119t40.g(view, view.computeSystemWindowInsets(f, rect));
        }
        rect.setEmpty();
        return c4119t40;
    }

    public static void c(View view, OI oi) {
        V10 v10 = oi != null ? new V10(view, oi) : null;
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(R.id.tag_on_apply_window_listener, v10);
        }
        if (view.getTag(R.id.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (v10 != null) {
            view.setOnApplyWindowInsetsListener(v10);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(R.id.tag_window_insets_animation_callback));
        }
    }
}
