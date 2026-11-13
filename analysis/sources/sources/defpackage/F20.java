package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class F20 extends AbstractC4817ya0 implements W0 {
    public static final AccelerateInterpolator I = new AccelerateInterpolator();
    public static final DecelerateInterpolator J = new DecelerateInterpolator();
    public boolean A;
    public boolean B;
    public C3696k10 C;
    public boolean D;
    public boolean E;
    public final D20 F;
    public final D20 G;
    public final VP H;
    public Context k;
    public Context l;
    public ActionBarOverlayLayout m;
    public ActionBarContainer n;
    public InterfaceC0415Pj o;
    public ActionBarContextView p;
    public final View q;
    public boolean r;
    public E20 s;
    public E20 t;
    public InterfaceC3849m1 u;
    public boolean v;
    public final ArrayList w;
    public int x;
    public boolean y;
    public boolean z;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public F20(Activity activity, boolean z) {
        new ArrayList();
        this.w = new ArrayList();
        this.x = 0;
        this.y = true;
        this.B = true;
        this.F = new D20(this, 0);
        this.G = new D20(this, 1);
        this.H = new VP(this, 20);
        View decorView = activity.getWindow().getDecorView();
        j0(decorView);
        if (z) {
            return;
        }
        this.q = decorView.findViewById(R.id.content);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void h0(boolean z) {
        C3619j10 i;
        C3619j10 c3619j10;
        long j;
        if (z) {
            if (!this.A) {
                this.A = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.m;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                m0(false);
            }
        } else if (this.A) {
            this.A = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.m;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            m0(false);
        }
        if (this.n.isLaidOut()) {
            if (z) {
                CW cw = (CW) this.o;
                i = T00.a(cw.a);
                i.a(0.0f);
                i.c(100L);
                i.d(new BW(cw, 4));
                c3619j10 = this.p.i(0, 200L);
            } else {
                CW cw2 = (CW) this.o;
                C3619j10 a = T00.a(cw2.a);
                a.a(1.0f);
                a.c(200L);
                a.d(new BW(cw2, 0));
                i = this.p.i(8, 100L);
                c3619j10 = a;
            }
            C3696k10 c3696k10 = new C3696k10();
            ArrayList arrayList = c3696k10.a;
            arrayList.add(i);
            View view = (View) i.a.get();
            if (view != null) {
                j = view.animate().getDuration();
            } else {
                j = 0;
            }
            View view2 = (View) c3619j10.a.get();
            if (view2 != null) {
                view2.animate().setStartDelay(j);
            }
            arrayList.add(c3619j10);
            c3696k10.b();
            return;
        }
        if (z) {
            ((CW) this.o).a.setVisibility(4);
            this.p.setVisibility(0);
        } else {
            ((CW) this.o).a.setVisibility(0);
            this.p.setVisibility(8);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Context i0() {
        if (this.l == null) {
            TypedValue typedValue = new TypedValue();
            this.k.getTheme().resolveAttribute(app.vpn.amtunnellite.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.l = new ContextThemeWrapper(this.k, i);
            } else {
                this.l = this.k;
            }
        }
        return this.l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void j0(View view) {
        String str;
        InterfaceC0415Pj wrapper;
        boolean z;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(app.vpn.amtunnellite.R.id.decor_content_parent);
        this.m = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(app.vpn.amtunnellite.R.id.action_bar);
        if (findViewById instanceof InterfaceC0415Pj) {
            wrapper = (InterfaceC0415Pj) findViewById;
        } else if (findViewById instanceof Toolbar) {
            wrapper = ((Toolbar) findViewById).getWrapper();
        } else {
            if (findViewById != null) {
                str = findViewById.getClass().getSimpleName();
            } else {
                str = "null";
            }
            throw new IllegalStateException("Can't make a decor toolbar out of ".concat(str));
        }
        this.o = wrapper;
        this.p = (ActionBarContextView) view.findViewById(app.vpn.amtunnellite.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(app.vpn.amtunnellite.R.id.action_bar_container);
        this.n = actionBarContainer;
        InterfaceC0415Pj interfaceC0415Pj = this.o;
        if (interfaceC0415Pj != null && this.p != null && actionBarContainer != null) {
            Context context = ((CW) interfaceC0415Pj).a.getContext();
            this.k = context;
            if ((((CW) this.o).b & 4) != 0) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                this.r = true;
            }
            int i = context.getApplicationInfo().targetSdkVersion;
            this.o.getClass();
            l0(context.getResources().getBoolean(app.vpn.amtunnellite.R.bool.abc_action_bar_embed_tabs));
            TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(null, EL.a, app.vpn.amtunnellite.R.attr.actionBarStyle, 0);
            if (obtainStyledAttributes.getBoolean(14, false)) {
                ActionBarOverlayLayout actionBarOverlayLayout2 = this.m;
                if (actionBarOverlayLayout2.g) {
                    this.E = true;
                    actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
                } else {
                    throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
                }
            }
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
            if (dimensionPixelSize != 0) {
                ActionBarContainer actionBarContainer2 = this.n;
                WeakHashMap weakHashMap = T00.a;
                L00.j(actionBarContainer2, dimensionPixelSize);
            }
            obtainStyledAttributes.recycle();
            return;
        }
        throw new IllegalStateException(F20.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void k0(boolean z) {
        int i;
        if (!this.r) {
            if (z) {
                i = 4;
            } else {
                i = 0;
            }
            CW cw = (CW) this.o;
            int i2 = cw.b;
            this.r = true;
            cw.a((i & 4) | (i2 & (-5)));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void l0(boolean z) {
        if (!z) {
            ((CW) this.o).getClass();
            this.n.setTabContainer(null);
        } else {
            this.n.setTabContainer(null);
            ((CW) this.o).getClass();
        }
        this.o.getClass();
        ((CW) this.o).a.setCollapsible(false);
        this.m.setHasNonEmbeddedTabs(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void m0(boolean z) {
        boolean z2;
        int i = 1;
        boolean z3 = this.z;
        if (this.A || !z3) {
            z2 = true;
        } else {
            z2 = false;
        }
        View view = this.q;
        C4393t4 c4393t4 = null;
        VP vp = this.H;
        if (z2) {
            if (!this.B) {
                this.B = true;
                C3696k10 c3696k10 = this.C;
                if (c3696k10 != null) {
                    c3696k10.a();
                }
                this.n.setVisibility(0);
                int i2 = this.x;
                D20 d20 = this.G;
                if (i2 == 0 && (this.D || z)) {
                    this.n.setTranslationY(0.0f);
                    float f = -this.n.getHeight();
                    if (z) {
                        this.n.getLocationInWindow(new int[]{0, 0});
                        f -= r12[1];
                    }
                    this.n.setTranslationY(f);
                    C3696k10 c3696k102 = new C3696k10();
                    C3619j10 a = T00.a(this.n);
                    a.e(0.0f);
                    View view2 = (View) a.a.get();
                    if (view2 != null) {
                        if (vp != null) {
                            c4393t4 = new C4393t4(i, vp, view2);
                        }
                        view2.animate().setUpdateListener(c4393t4);
                    }
                    boolean z4 = c3696k102.e;
                    ArrayList arrayList = c3696k102.a;
                    if (!z4) {
                        arrayList.add(a);
                    }
                    if (this.y && view != null) {
                        view.setTranslationY(f);
                        C3619j10 a2 = T00.a(view);
                        a2.e(0.0f);
                        if (!c3696k102.e) {
                            arrayList.add(a2);
                        }
                    }
                    DecelerateInterpolator decelerateInterpolator = J;
                    boolean z5 = c3696k102.e;
                    if (!z5) {
                        c3696k102.c = decelerateInterpolator;
                    }
                    if (!z5) {
                        c3696k102.b = 250L;
                    }
                    if (!z5) {
                        c3696k102.d = d20;
                    }
                    this.C = c3696k102;
                    c3696k102.b();
                } else {
                    this.n.setAlpha(1.0f);
                    this.n.setTranslationY(0.0f);
                    if (this.y && view != null) {
                        view.setTranslationY(0.0f);
                    }
                    d20.a();
                }
                ActionBarOverlayLayout actionBarOverlayLayout = this.m;
                if (actionBarOverlayLayout != null) {
                    WeakHashMap weakHashMap = T00.a;
                    J00.c(actionBarOverlayLayout);
                    return;
                }
                return;
            }
            return;
        }
        if (this.B) {
            this.B = false;
            C3696k10 c3696k103 = this.C;
            if (c3696k103 != null) {
                c3696k103.a();
            }
            int i3 = this.x;
            D20 d202 = this.F;
            if (i3 == 0 && (this.D || z)) {
                this.n.setAlpha(1.0f);
                this.n.setTransitioning(true);
                C3696k10 c3696k104 = new C3696k10();
                float f2 = -this.n.getHeight();
                if (z) {
                    this.n.getLocationInWindow(new int[]{0, 0});
                    f2 -= r12[1];
                }
                C3619j10 a3 = T00.a(this.n);
                a3.e(f2);
                View view3 = (View) a3.a.get();
                if (view3 != null) {
                    if (vp != null) {
                        c4393t4 = new C4393t4(i, vp, view3);
                    }
                    view3.animate().setUpdateListener(c4393t4);
                }
                boolean z6 = c3696k104.e;
                ArrayList arrayList2 = c3696k104.a;
                if (!z6) {
                    arrayList2.add(a3);
                }
                if (this.y && view != null) {
                    C3619j10 a4 = T00.a(view);
                    a4.e(f2);
                    if (!c3696k104.e) {
                        arrayList2.add(a4);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = I;
                boolean z7 = c3696k104.e;
                if (!z7) {
                    c3696k104.c = accelerateInterpolator;
                }
                if (!z7) {
                    c3696k104.b = 250L;
                }
                if (!z7) {
                    c3696k104.d = d202;
                }
                this.C = c3696k104;
                c3696k104.b();
                return;
            }
            d202.a();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public F20(Dialog dialog) {
        new ArrayList();
        this.w = new ArrayList();
        this.x = 0;
        this.y = true;
        this.B = true;
        this.F = new D20(this, 0);
        this.G = new D20(this, 1);
        this.H = new VP(this, 20);
        j0(dialog.getWindow().getDecorView());
    }
}
