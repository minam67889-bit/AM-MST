package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class Z4 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static Z4 c;
    public C4803yN a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized Z4 a() {
        Z4 z4;
        synchronized (Z4.class) {
            try {
                if (c == null) {
                    c();
                }
                z4 = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void c() {
        synchronized (Z4.class) {
            if (c == null) {
                Z4 z4 = new Z4();
                c = z4;
                z4.a = C4803yN.c();
                C4803yN c4803yN = c.a;
                G2 g2 = new G2();
                g2.a = new int[]{2131230836, 2131230834, 2131230760};
                g2.b = new int[]{2131230784, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                g2.c = new int[]{2131230833, 2131230835, 2131230777, R.drawable.abc_text_cursor_material, 2131230830, 2131230831, 2131230832};
                g2.d = new int[]{2131230809, R.drawable.abc_cab_background_internal_bg, 2131230808};
                g2.e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                g2.f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                synchronized (c4803yN) {
                    c4803yN.e = g2;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void d(Drawable drawable, C3889mW c3889mW, int[] iArr) {
        ColorStateList colorStateList;
        PorterDuff.Mode mode;
        PorterDuff.Mode mode2 = C4803yN.f;
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = c3889mW.b;
            if (!z && !c3889mW.a) {
                drawable.clearColorFilter();
                return;
            }
            PorterDuffColorFilter porterDuffColorFilter = null;
            if (z) {
                colorStateList = (ColorStateList) c3889mW.c;
            } else {
                colorStateList = null;
            }
            if (c3889mW.a) {
                mode = (PorterDuff.Mode) c3889mW.d;
            } else {
                mode = C4803yN.f;
            }
            if (colorStateList != null && mode != null) {
                porterDuffColorFilter = C4803yN.g(colorStateList.getColorForState(iArr, 0), mode);
            }
            drawable.setColorFilter(porterDuffColorFilter);
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized Drawable b(Context context, int i) {
        return this.a.e(context, i);
    }
}
