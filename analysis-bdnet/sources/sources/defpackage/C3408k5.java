package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import dastan.prince.bdfreevpn.R;

/* renamed from: k5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3408k5 {
    public static final PorterDuff.Mode b = PorterDuff.Mode.SRC_IN;
    public static C3408k5 c;
    public C4302vO a;

    public static synchronized C3408k5 a() {
        C3408k5 c3408k5;
        synchronized (C3408k5.class) {
            try {
                if (c == null) {
                    d();
                }
                c3408k5 = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c3408k5;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter e;
        synchronized (C3408k5.class) {
            e = C4302vO.e(i, mode);
        }
        return e;
    }

    public static synchronized void d() {
        synchronized (C3408k5.class) {
            if (c == null) {
                C3408k5 c3408k5 = new C3408k5();
                c = c3408k5;
                c3408k5.a = C4302vO.b();
                C4302vO c4302vO = c.a;
                P2 p2 = new P2();
                p2.a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
                p2.b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
                p2.c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
                p2.d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
                p2.e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
                p2.f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
                synchronized (c4302vO) {
                    c4302vO.e = p2;
                }
            }
        }
    }

    public static void e(Drawable drawable, C2963eX c2963eX, int[] iArr) {
        PorterDuff.Mode mode = C4302vO.f;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = c2963eX.b;
        if (!z && !c2963eX.a) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilter = null;
        ColorStateList colorStateList = z ? (ColorStateList) c2963eX.c : null;
        PorterDuff.Mode mode2 = c2963eX.a ? (PorterDuff.Mode) c2963eX.d : C4302vO.f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilter = C4302vO.e(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilter);
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.a.c(context, i);
    }
}
