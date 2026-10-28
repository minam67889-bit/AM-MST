package defpackage;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.LinearInterpolator;
import app.vpn.amtunnellite.R;
import com.google.android.gms.ads.AdSize;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.SnackbarContentLayout;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class Z9 {
    public final int a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final ViewGroup g;
    public final Context h;
    public final Y9 i;
    public final InterfaceC4134pg j;
    public int k;
    public final T9 l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public final AccessibilityManager s;
    public final W9 t = new W9(this);
    public static final C4912zp u = AbstractC3778l4.b;
    public static final LinearInterpolator v = AbstractC3778l4.a;
    public static final C4912zp w = AbstractC3778l4.d;
    public static final int[] y = {R.attr.snackbarStyle};
    public static final String z = Z9.class.getSimpleName();
    public static final Handler x = new Handler(Looper.getMainLooper(), new S9());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Z9(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        int i;
        int i2 = 0;
        this.l = new T9(this, i2);
        if (snackbarContentLayout != null) {
            if (snackbarContentLayout2 != null) {
                this.g = viewGroup;
                this.j = snackbarContentLayout2;
                this.h = context;
                AbstractC4702x40.k(context, AbstractC4702x40.g, "Theme.AppCompat");
                LayoutInflater from = LayoutInflater.from(context);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(y);
                int resourceId = obtainStyledAttributes.getResourceId(0, -1);
                obtainStyledAttributes.recycle();
                if (resourceId != -1) {
                    i = R.layout.mtrl_layout_snackbar;
                } else {
                    i = R.layout.design_layout_snackbar;
                }
                Y9 y9 = (Y9) from.inflate(i, viewGroup, false);
                this.i = y9;
                y9.setBaseTransientBottomBar(this);
                float actionTextColorAlpha = y9.getActionTextColorAlpha();
                if (actionTextColorAlpha != 1.0f) {
                    snackbarContentLayout.b.setTextColor(AbstractC4766xx.K(AbstractC4766xx.B(snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.b.getCurrentTextColor(), actionTextColorAlpha));
                }
                snackbarContentLayout.setMaxInlineActionWidth(y9.getMaxInlineActionWidth());
                y9.addView(snackbarContentLayout);
                y9.setAccessibilityLiveRegion(1);
                y9.setImportantForAccessibility(1);
                y9.setFitsSystemWindows(true);
                U9 u9 = new U9(this);
                WeakHashMap weakHashMap = T00.a;
                L00.k(y9, u9);
                T00.l(y9, new V9(this, i2));
                this.s = (AccessibilityManager) context.getSystemService("accessibility");
                this.c = AbstractC0363Nj.z(context, R.attr.motionDurationLong2, AdSize.MEDIUM_RECTANGLE_HEIGHT);
                this.a = AbstractC0363Nj.z(context, R.attr.motionDurationLong2, 150);
                this.b = AbstractC0363Nj.z(context, R.attr.motionDurationMedium1, 75);
                this.d = AbstractC0363Nj.A(context, R.attr.motionEasingEmphasizedInterpolator, v);
                this.f = AbstractC0363Nj.A(context, R.attr.motionEasingEmphasizedInterpolator, w);
                this.e = AbstractC0363Nj.A(context, R.attr.motionEasingEmphasizedInterpolator, u);
                return;
            }
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        throw new IllegalArgumentException("Transient bottom bar must have non-null content");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(int i) {
        WS ws;
        MQ h = MQ.h();
        W9 w9 = this.t;
        synchronized (h.b) {
            try {
                if (h.l(w9)) {
                    ws = (WS) h.d;
                } else {
                    WS ws2 = (WS) h.e;
                    if (ws2 != null && w9 != null && ws2.a.get() == w9) {
                        ws = (WS) h.e;
                    }
                }
                h.b(ws, i);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean b() {
        boolean z2;
        WS ws;
        MQ h = MQ.h();
        W9 w9 = this.t;
        synchronized (h.b) {
            if (!h.l(w9) && ((ws = (WS) h.e) == null || w9 == null || ws.a.get() != w9)) {
                z2 = false;
            }
            z2 = true;
        }
        return z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c() {
        MQ h = MQ.h();
        W9 w9 = this.t;
        synchronized (h.b) {
            try {
                if (h.l(w9)) {
                    h.d = null;
                    if (((WS) h.e) != null) {
                        h.z();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ViewParent parent = this.i.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        MQ h = MQ.h();
        W9 w9 = this.t;
        synchronized (h.b) {
            try {
                if (h.l(w9)) {
                    h.u((WS) h.d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z2 = true;
        AccessibilityManager accessibilityManager = this.s;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z2 = false;
        }
        Y9 y9 = this.i;
        if (z2) {
            y9.post(new T9(this, 2));
            return;
        }
        if (y9.getParent() != null) {
            y9.setVisibility(0);
        }
        d();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f() {
        boolean z2;
        Y9 y9 = this.i;
        ViewGroup.LayoutParams layoutParams = y9.getLayoutParams();
        boolean z3 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        String str = z;
        if (!z3) {
            Log.w(str, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (y9.j == null) {
            Log.w(str, "Unable to update margins because original view margins are not set");
            return;
        }
        if (y9.getParent() == null) {
            return;
        }
        int i = this.m;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = y9.j;
        int i2 = rect.bottom + i;
        int i3 = rect.left + this.n;
        int i4 = rect.right + this.o;
        int i5 = rect.top;
        if (marginLayoutParams.bottomMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.topMargin == i5) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z2) {
            marginLayoutParams.bottomMargin = i2;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i4;
            marginLayoutParams.topMargin = i5;
            y9.requestLayout();
        }
        if ((z2 || this.q != this.p) && Build.VERSION.SDK_INT >= 29 && this.p > 0) {
            ViewGroup.LayoutParams layoutParams2 = y9.getLayoutParams();
            if ((layoutParams2 instanceof C0049Bg) && (((C0049Bg) layoutParams2).a instanceof SwipeDismissBehavior)) {
                T9 t9 = this.l;
                y9.removeCallbacks(t9);
                y9.post(t9);
            }
        }
    }
}
