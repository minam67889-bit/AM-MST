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
import com.google.android.gms.ads.AdSize;
import com.google.android.material.behavior.SwipeDismissBehavior;
import com.google.android.material.snackbar.SnackbarContentLayout;
import dastan.prince.bdfreevpn.R;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: qa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC3920qa {
    public final int a;
    public final int b;
    public final int c;
    public final TimeInterpolator d;
    public final TimeInterpolator e;
    public final TimeInterpolator f;
    public final ViewGroup g;
    public final Context h;
    public final AbstractC3841pa i;
    public final SnackbarContentLayout j;
    public int k;
    public final RunnableC3524la l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public final AccessibilityManager s;
    public final C3683na t = new C3683na(this);
    public static final C0544Up u = AbstractC4434x4.b;
    public static final LinearInterpolator v = AbstractC4434x4.a;
    public static final C0544Up w = AbstractC4434x4.d;
    public static final int[] y = {R.attr.snackbarStyle};
    public static final String z = AbstractC3920qa.class.getSimpleName();
    public static final Handler x = new Handler(Looper.getMainLooper(), new C3444ka());

    public AbstractC3920qa(Context context, ViewGroup viewGroup, SnackbarContentLayout snackbarContentLayout, SnackbarContentLayout snackbarContentLayout2) {
        int i = 0;
        this.l = new RunnableC3524la(this, i);
        if (snackbarContentLayout == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null content");
        }
        if (snackbarContentLayout2 == null) {
            throw new IllegalArgumentException("Transient bottom bar must have non-null callback");
        }
        this.g = viewGroup;
        this.j = snackbarContentLayout2;
        this.h = context;
        AbstractC0641Yi.j(context, AbstractC0641Yi.l, "Theme.AppCompat");
        LayoutInflater from = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(y);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        AbstractC3841pa abstractC3841pa = (AbstractC3841pa) from.inflate(resourceId != -1 ? R.layout.mtrl_layout_snackbar : R.layout.design_layout_snackbar, viewGroup, false);
        this.i = abstractC3841pa;
        abstractC3841pa.setBaseTransientBottomBar(this);
        float actionTextColorAlpha = abstractC3841pa.getActionTextColorAlpha();
        if (actionTextColorAlpha != 1.0f) {
            snackbarContentLayout.b.setTextColor(S50.z(S50.u(snackbarContentLayout, R.attr.colorSurface), snackbarContentLayout.b.getCurrentTextColor(), actionTextColorAlpha));
        }
        snackbarContentLayout.setMaxInlineActionWidth(abstractC3841pa.getMaxInlineActionWidth());
        abstractC3841pa.addView(snackbarContentLayout);
        abstractC3841pa.setAccessibilityLiveRegion(1);
        abstractC3841pa.setImportantForAccessibility(1);
        abstractC3841pa.setFitsSystemWindows(true);
        C2882dV c2882dV = new C2882dV(this, 6);
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        W10.c(abstractC3841pa, c2882dV);
        AbstractC2925e20.m(abstractC3841pa, new C3604ma(this, i));
        this.s = (AccessibilityManager) context.getSystemService("accessibility");
        this.c = AbstractC0731aZ.a0(context, R.attr.motionDurationLong2, AdSize.MEDIUM_RECTANGLE_HEIGHT);
        this.a = AbstractC0731aZ.a0(context, R.attr.motionDurationLong2, 150);
        this.b = AbstractC0731aZ.a0(context, R.attr.motionDurationMedium1, 75);
        this.d = AbstractC0731aZ.b0(context, R.attr.motionEasingEmphasizedInterpolator, v);
        this.f = AbstractC0731aZ.b0(context, R.attr.motionEasingEmphasizedInterpolator, w);
        this.e = AbstractC0731aZ.b0(context, R.attr.motionEasingEmphasizedInterpolator, u);
    }

    public final void a(int i) {
        NX f = NX.f();
        C3683na c3683na = this.t;
        synchronized (f.a) {
            try {
                if (f.i(c3683na)) {
                    f.c((OT) f.c, i);
                } else {
                    OT ot = (OT) f.d;
                    if (ot != null && ot.a.get() == c3683na) {
                        f.c((OT) f.d, i);
                    }
                }
            } finally {
            }
        }
    }

    public final boolean b() {
        boolean z2;
        NX f = NX.f();
        C3683na c3683na = this.t;
        synchronized (f.a) {
            z2 = true;
            if (!f.i(c3683na)) {
                OT ot = (OT) f.d;
                if (!(ot != null && ot.a.get() == c3683na)) {
                    z2 = false;
                }
            }
        }
        return z2;
    }

    public final void c() {
        NX f = NX.f();
        C3683na c3683na = this.t;
        synchronized (f.a) {
            try {
                if (f.i(c3683na)) {
                    f.c = null;
                    if (((OT) f.d) != null) {
                        f.u();
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

    public final void d() {
        NX f = NX.f();
        C3683na c3683na = this.t;
        synchronized (f.a) {
            try {
                if (f.i(c3683na)) {
                    f.q((OT) f.c);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        boolean z2 = true;
        AccessibilityManager accessibilityManager = this.s;
        if (accessibilityManager != null && ((enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) == null || !enabledAccessibilityServiceList.isEmpty())) {
            z2 = false;
        }
        AbstractC3841pa abstractC3841pa = this.i;
        if (z2) {
            abstractC3841pa.post(new RunnableC3524la(this, 2));
            return;
        }
        if (abstractC3841pa.getParent() != null) {
            abstractC3841pa.setVisibility(0);
        }
        d();
    }

    public final void f() {
        AbstractC3841pa abstractC3841pa = this.i;
        ViewGroup.LayoutParams layoutParams = abstractC3841pa.getLayoutParams();
        boolean z2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        String str = z;
        if (!z2) {
            Log.w(str, "Unable to update margins because layout params are not MarginLayoutParams");
            return;
        }
        if (abstractC3841pa.j == null) {
            Log.w(str, "Unable to update margins because original view margins are not set");
            return;
        }
        if (abstractC3841pa.getParent() == null) {
            return;
        }
        int i = this.m;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        Rect rect = abstractC3841pa.j;
        int i2 = rect.bottom + i;
        int i3 = rect.left + this.n;
        int i4 = rect.right + this.o;
        int i5 = rect.top;
        boolean z3 = (marginLayoutParams.bottomMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4 && marginLayoutParams.topMargin == i5) ? false : true;
        if (z3) {
            marginLayoutParams.bottomMargin = i2;
            marginLayoutParams.leftMargin = i3;
            marginLayoutParams.rightMargin = i4;
            marginLayoutParams.topMargin = i5;
            abstractC3841pa.requestLayout();
        }
        if ((z3 || this.q != this.p) && Build.VERSION.SDK_INT >= 29 && this.p > 0) {
            ViewGroup.LayoutParams layoutParams2 = abstractC3841pa.getLayoutParams();
            if ((layoutParams2 instanceof C0405Pg) && (((C0405Pg) layoutParams2).a instanceof SwipeDismissBehavior)) {
                RunnableC3524la runnableC3524la = this.l;
                abstractC3841pa.removeCallbacks(runnableC3524la);
                abstractC3841pa.post(runnableC3524la);
            }
        }
    }
}
