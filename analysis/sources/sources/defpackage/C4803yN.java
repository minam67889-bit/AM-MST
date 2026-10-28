package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.TypedValue;
import app.vpn.amtunnellite.R;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: yN, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4803yN {
    public static C4803yN g;
    public WeakHashMap a;
    public final WeakHashMap b = new WeakHashMap(0);
    public TypedValue c;
    public boolean d;
    public G2 e;
    public static final PorterDuff.Mode f = PorterDuff.Mode.SRC_IN;
    public static final C4726xN h = new C4726xN(6);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized C4803yN c() {
        C4803yN c4803yN;
        synchronized (C4803yN.class) {
            try {
                if (g == null) {
                    g = new C4803yN();
                }
                c4803yN = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c4803yN;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized PorterDuffColorFilter g(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilter;
        synchronized (C4803yN.class) {
            C4726xN c4726xN = h;
            c4726xN.getClass();
            int i2 = (31 + i) * 31;
            porterDuffColorFilter = (PorterDuffColorFilter) c4726xN.get(Integer.valueOf(mode.hashCode() + i2));
            if (porterDuffColorFilter == null) {
                porterDuffColorFilter = new PorterDuffColorFilter(i, mode);
            }
        }
        return porterDuffColorFilter;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(Context context, long j, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                LC lc = (LC) this.b.get(context);
                if (lc == null) {
                    lc = new LC();
                    this.b.put(context, lc);
                }
                lc.e(j, new WeakReference(constantState));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Drawable b(Context context, int i) {
        int i2;
        if (this.c == null) {
            this.c = new TypedValue();
        }
        TypedValue typedValue = this.c;
        context.getResources().getValue(i, typedValue, true);
        long j = (typedValue.assetCookie << 32) | typedValue.data;
        Drawable d = d(context, j);
        if (d != null) {
            return d;
        }
        LayerDrawable layerDrawable = null;
        if (this.e != null) {
            if (i == R.drawable.abc_cab_background_top_material) {
                layerDrawable = new LayerDrawable(new Drawable[]{e(context, R.drawable.abc_cab_background_internal_bg), e(context, 2131230777)});
            } else {
                if (i == R.drawable.abc_ratingbar_material) {
                    i2 = R.dimen.abc_star_big;
                } else if (i == R.drawable.abc_ratingbar_indicator_material) {
                    i2 = R.dimen.abc_star_medium;
                } else if (i == R.drawable.abc_ratingbar_small_material) {
                    i2 = R.dimen.abc_star_small;
                }
                layerDrawable = G2.q(this, context, i2);
            }
        }
        if (layerDrawable != null) {
            layerDrawable.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, j, layerDrawable);
        }
        return layerDrawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized Drawable d(Context context, long j) {
        LC lc = (LC) this.b.get(context);
        if (lc == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) lc.c(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            int i = AbstractC4747xe.i(lc.b, lc.d, j);
            if (i >= 0) {
                Object[] objArr = lc.c;
                Object obj = objArr[i];
                Object obj2 = I70.c;
                if (obj != obj2) {
                    objArr[i] = obj2;
                    lc.a = true;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized Drawable e(Context context, int i) {
        return f(context, i, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004e, code lost:
    
        r0.setTintMode(r2);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized Drawable f(Context context, int i, boolean z) {
        Drawable b;
        PorterDuff.Mode mode;
        Drawable findDrawableByLayerId;
        int c;
        if (!this.d) {
            this.d = true;
            Drawable e = e(context, R.drawable.abc_vector_test);
            if (e == null || (!(e instanceof C4540v00) && !"android.graphics.drawable.VectorDrawable".equals(e.getClass().getName()))) {
                this.d = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
        b = b(context, i);
        if (b == null) {
            b = context.getDrawable(i);
        }
        if (b != null) {
            ColorStateList h2 = h(context, i);
            PorterDuff.Mode mode2 = null;
            if (h2 != null) {
                b = b.mutate();
                b.setTintList(h2);
                if (this.e != null && i == R.drawable.abc_switch_thumb_material) {
                    mode2 = PorterDuff.Mode.MULTIPLY;
                }
            } else {
                if (this.e != null) {
                    if (i == R.drawable.abc_seekbar_track_material) {
                        LayerDrawable layerDrawable = (LayerDrawable) b;
                        Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(android.R.id.background);
                        int c2 = QV.c(context, R.attr.colorControlNormal);
                        mode = Z4.b;
                        G2.y(findDrawableByLayerId2, c2, mode);
                        G2.y(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), QV.c(context, R.attr.colorControlNormal), mode);
                        findDrawableByLayerId = layerDrawable.findDrawableByLayerId(android.R.id.progress);
                        c = QV.c(context, R.attr.colorControlActivated);
                    } else if (i == R.drawable.abc_ratingbar_material || i == R.drawable.abc_ratingbar_indicator_material || i == R.drawable.abc_ratingbar_small_material) {
                        LayerDrawable layerDrawable2 = (LayerDrawable) b;
                        Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(android.R.id.background);
                        int b2 = QV.b(context, R.attr.colorControlNormal);
                        mode = Z4.b;
                        G2.y(findDrawableByLayerId3, b2, mode);
                        G2.y(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), QV.c(context, R.attr.colorControlActivated), mode);
                        findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(android.R.id.progress);
                        c = QV.c(context, R.attr.colorControlActivated);
                    }
                    G2.y(findDrawableByLayerId, c, mode);
                }
                if (!i(context, i, b) && z) {
                    b = null;
                }
            }
        }
        if (b != null) {
            AbstractC0417Pl.a(b);
        }
        return b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized ColorStateList h(Context context, int i) {
        ColorStateList colorStateList;
        C3809lT c3809lT;
        WeakHashMap weakHashMap = this.a;
        ColorStateList colorStateList2 = null;
        if (weakHashMap != null && (c3809lT = (C3809lT) weakHashMap.get(context)) != null) {
            colorStateList = (ColorStateList) c3809lT.c(i);
        } else {
            colorStateList = null;
        }
        if (colorStateList == null) {
            G2 g2 = this.e;
            if (g2 != null) {
                colorStateList2 = g2.s(context, i);
            }
            if (colorStateList2 != null) {
                if (this.a == null) {
                    this.a = new WeakHashMap();
                }
                C3809lT c3809lT2 = (C3809lT) this.a.get(context);
                if (c3809lT2 == null) {
                    c3809lT2 = new C3809lT();
                    this.a.put(context, c3809lT2);
                }
                c3809lT2.a(i, colorStateList2);
            }
            colorStateList = colorStateList2;
        }
        return colorStateList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0057  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(Context context, int i, Drawable drawable) {
        int i2;
        boolean z;
        int round;
        PorterDuffColorFilter g2;
        G2 g22 = this.e;
        if (g22 == null) {
            return false;
        }
        PorterDuff.Mode mode = Z4.b;
        if (G2.k((int[]) g22.a, i)) {
            i2 = R.attr.colorControlNormal;
        } else if (G2.k((int[]) g22.c, i)) {
            i2 = R.attr.colorControlActivated;
        } else {
            if (G2.k((int[]) g22.d, i)) {
                mode = PorterDuff.Mode.MULTIPLY;
            } else {
                if (i == 2131230797) {
                    z = true;
                    round = Math.round(40.8f);
                    i2 = 16842800;
                    if (!z) {
                        return false;
                    }
                    Drawable mutate = drawable.mutate();
                    int c = QV.c(context, i2);
                    synchronized (Z4.class) {
                        g2 = g(c, mode);
                    }
                    mutate.setColorFilter(g2);
                    if (round != -1) {
                        mutate.setAlpha(round);
                    }
                    return true;
                }
                if (i != R.drawable.abc_dialog_material_background) {
                    i2 = 0;
                    z = false;
                    round = -1;
                    if (!z) {
                    }
                }
            }
            i2 = 16842801;
        }
        z = true;
        round = -1;
        if (!z) {
        }
    }
}
