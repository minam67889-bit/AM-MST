package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import dastan.prince.bdfreevpn.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: vO, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4302vO {
    public static C4302vO g;
    public WeakHashMap a;
    public final WeakHashMap b = new WeakHashMap(0);
    public TypedValue c;
    public boolean d;
    public P2 e;
    public static final PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
    public static final C4223uO h = new C4223uO(6);

    public static synchronized C4302vO b() {
        C4302vO c4302vO;
        synchronized (C4302vO.class) {
            try {
                if (g == null) {
                    g = new C4302vO();
                }
                c4302vO = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c4302vO;
    }

    public static synchronized PorterDuffColorFilter e(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (C4302vO.class) {
            C4223uO c4223uO = h;
            c4223uO.getClass();
            int i2 = (31 + i) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) c4223uO.get(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            }
        }
        return porterDuffColorFilter;
    }

    public final Drawable a(Context context, int i) {
        Drawable drawable;
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        context.getResources().getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        synchronized (this) {
            BD bd = (BD) this.b.get(context);
            drawable = null;
            if (bd != null) {
                WeakReference weakReference = (WeakReference) bd.b(j);
                if (weakReference != null) {
                    Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
                    if (constantState != null) {
                        drawable = constantState.newDrawable(context.getResources());
                    } else {
                        int j2 = AbstractC0199Hh.j(bd.b, bd.d, j);
                        if (j2 >= 0) {
                            Object[] objArr = bd.c;
                            Object obj = objArr[j2];
                            Object obj2 = AbstractC3634my.d;
                            if (obj != obj2) {
                                objArr[j2] = obj2;
                                bd.a = true;
                            }
                        }
                    }
                }
            }
        }
        if (drawable != null) {
            return drawable;
        }
        LayerDrawable layerDrawable = null;
        if (this.e != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{c(context, R.drawable.abc_cab_background_internal_bg), c(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
            } else if (i == R.drawable.abc_ratingbar_material) {
                layerDrawable = P2.p(this, context, R.dimen.abc_star_big);
            } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                layerDrawable = P2.p(this, context, R.dimen.abc_star_medium);
            } else if (i == R.drawable.abc_ratingbar_small_material) {
                layerDrawable = P2.p(this, context, R.dimen.abc_star_small);
            }
        }
        if (layerDrawable == null) {
            return layerDrawable;
        }
        layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
        synchronized (this) {
            try {
                Drawable.ConstantState constantState2 = layerDrawable.getConstantState();
                if (constantState2 != null) {
                    BD bd2 = (BD) this.b.get(context);
                    if (bd2 == null) {
                        bd2 = new BD();
                        this.b.put(context, bd2);
                    }
                    bd2.d(j, new WeakReference(constantState2));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return layerDrawable;
    }

    public final synchronized Drawable c(Context context, int i) {
        return d(context, i, false);
    }

    public final synchronized Drawable d(Context context, int i, boolean z) {
        Drawable a;
        try {
            if (!this.d) {
                this.d = true;
                Drawable c = c(context, R.drawable.abc_vector_test);
                if (c == null || (!(c instanceof D10) && !"android.graphics.drawable.VectorDrawable".equals(c.getClass().getName()))) {
                    this.d = false;
                    throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
                }
            }
            a = a(context, i);
            if (a == null) {
                a = context.getDrawable(i);
            }
            if (a != null) {
                a = g(context, i, z, a);
            }
            if (a != null) {
                AbstractC0540Ul.a(a);
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    public final synchronized ColorStateList f(Context context, int i) {
        ColorStateList colorStateList;
        C3120gU c3120gU;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateList2 = null;
        colorStateList = (weakHashMap == null || (c3120gU = (C3120gU) weakHashMap.get(context)) == null) ? null : (ColorStateList) c3120gU.b(i);
        if (colorStateList == null) {
            P2 p2 = this.e;
            if (p2 != null) {
                colorStateList2 = p2.r(context, i);
            }
            if (colorStateList2 != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                C3120gU c3120gU2 = (C3120gU) this.a.get(context);
                if (c3120gU2 == null) {
                    c3120gU2 = new C3120gU();
                    this.a.put(context, c3120gU2);
                }
                c3120gU2.a(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Drawable g(Context context, int i, boolean z, Drawable drawable) {
        int i2;
        boolean z2;
        int round;
        ColorStateList f2 = f(context, i);
        PorterDuff.Mode mode = null;
        if (f2 != null) {
            Drawable mutate = drawable.mutate();
            mutate.setTintList(f2);
            if (this.e != null && i == R.drawable.abc_switch_thumb_material) {
                mode = PorterDuff.Mode.MULTIPLY;
            }
            if (mode != null) {
                mutate.setTintMode(mode);
            }
            return mutate;
        }
        if (this.e != null) {
            if (i == R.drawable.abc_seekbar_track_material) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.background);
                int c = JW.c(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode2 = C3408k5.b;
                P2.x(findDrawableByLayerId, c, mode2);
                P2.x(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), JW.c(context, R.attr.colorControlNormal), mode2);
                P2.x(layerDrawable.findDrawableByLayerId(android.R.id.progress), JW.c(context, R.attr.colorControlActivated), mode2);
                return drawable;
            }
            if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                Drawable findDrawableByLayerId2 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                int b = JW.b(context, R.attr.colorControlNormal);
                PorterDuff.Mode mode3 = C3408k5.b;
                P2.x(findDrawableByLayerId2, b, mode3);
                P2.x(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), JW.c(context, R.attr.colorControlActivated), mode3);
                P2.x(layerDrawable2.findDrawableByLayerId(android.R.id.progress), JW.c(context, R.attr.colorControlActivated), mode3);
                return drawable;
            }
        }
        P2 p2 = this.e;
        boolean z3 = false;
        if (p2 != null) {
            PorterDuff.Mode mode4 = C3408k5.b;
            if (P2.k((int[]) p2.a, i)) {
                i2 = R.attr.colorControlNormal;
            } else if (P2.k((int[]) p2.c, i)) {
                i2 = R.attr.colorControlActivated;
            } else {
                if (P2.k((int[]) p2.d, i)) {
                    mode4 = PorterDuff.Mode.MULTIPLY;
                } else if (i == R.drawable.abc_list_divider_mtrl_alpha) {
                    round = Math.round(40.8f);
                    i2 = 16842800;
                    z2 = true;
                    if (z2) {
                        Drawable mutate2 = drawable.mutate();
                        mutate2.setColorFilter(C3408k5.c(JW.c(context, i2), mode4));
                        if (round != -1) {
                            mutate2.setAlpha(round);
                        }
                        z3 = true;
                    }
                } else if (i != R.drawable.abc_dialog_material_background) {
                    i2 = 0;
                    z2 = false;
                    round = -1;
                    if (z2) {
                    }
                }
                i2 = 16842801;
            }
            z2 = true;
            round = -1;
            if (z2) {
            }
        }
        if (z3 || !z) {
            return drawable;
        }
        return null;
    }
}
