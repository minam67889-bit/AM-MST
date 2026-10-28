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
public final class P30 extends W80 implements Z0 {
    public static final AccelerateInterpolator I = new AccelerateInterpolator();
    public static final DecelerateInterpolator J = new DecelerateInterpolator();
    public boolean A;
    public boolean B;
    public C4431x20 C;
    public boolean D;
    public boolean E;
    public final N30 F;
    public final N30 G;
    public final TO H;
    public Context k;
    public Context l;
    public ActionBarOverlayLayout m;
    public ActionBarContainer n;
    public InterfaceC0590Wj o;
    public ActionBarContextView p;
    public final View q;
    public boolean r;
    public O30 s;
    public O30 t;
    public ML u;
    public boolean v;
    public final ArrayList w;
    public int x;
    public boolean y;
    public boolean z;

    public P30(Activity activity, boolean z) {
        new ArrayList();
        this.w = new ArrayList();
        this.x = 0;
        this.y = true;
        this.B = true;
        this.F = new N30(this, 0);
        this.G = new N30(this, 1);
        this.H = new TO(this, 8);
        View decorView = activity.getWindow().getDecorView();
        b0(decorView);
        if (z) {
            return;
        }
        this.q = decorView.findViewById(R.id.content);
    }

    public final void Z(boolean z) {
        C4352w20 i;
        C4352w20 c4352w20;
        if (z) {
            if (!this.A) {
                this.A = true;
                ActionBarOverlayLayout actionBarOverlayLayout = this.m;
                if (actionBarOverlayLayout != null) {
                    actionBarOverlayLayout.setShowingForActionMode(true);
                }
                e0(false);
            }
        } else if (this.A) {
            this.A = false;
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.m;
            if (actionBarOverlayLayout2 != null) {
                actionBarOverlayLayout2.setShowingForActionMode(false);
            }
            e0(false);
        }
        if (!this.n.isLaidOut()) {
            if (z) {
                ((C4232uX) this.o).a.setVisibility(4);
                this.p.setVisibility(0);
                return;
            } else {
                ((C4232uX) this.o).a.setVisibility(0);
                this.p.setVisibility(8);
                return;
            }
        }
        if (z) {
            C4232uX c4232uX = (C4232uX) this.o;
            i = AbstractC2925e20.a(c4232uX.a);
            i.a(0.0f);
            i.c(100L);
            i.d(new C4153tX(c4232uX, 4));
            c4352w20 = this.p.i(0, 200L);
        } else {
            C4232uX c4232uX2 = (C4232uX) this.o;
            C4352w20 a = AbstractC2925e20.a(c4232uX2.a);
            a.a(1.0f);
            a.c(200L);
            a.d(new C4153tX(c4232uX2, 0));
            i = this.p.i(8, 100L);
            c4352w20 = a;
        }
        C4431x20 c4431x20 = new C4431x20();
        ArrayList arrayList = c4431x20.a;
        arrayList.add(i);
        View view = (View) i.a.get();
        long duration = view != null ? view.animate().getDuration() : 0L;
        View view2 = (View) c4352w20.a.get();
        if (view2 != null) {
            view2.animate().setStartDelay(duration);
        }
        arrayList.add(c4352w20);
        c4431x20.b();
    }

    public final Context a0() {
        if (this.l == null) {
            TypedValue typedValue = new TypedValue();
            this.k.getTheme().resolveAttribute(dastan.prince.bdfreevpn.R.attr.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.l = new ContextThemeWrapper(this.k, i);
            } else {
                this.l = this.k;
            }
        }
        return this.l;
    }

    public final void b0(View view) {
        InterfaceC0590Wj wrapper;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) view.findViewById(dastan.prince.bdfreevpn.R.id.decor_content_parent);
        this.m = actionBarOverlayLayout;
        if (actionBarOverlayLayout != null) {
            actionBarOverlayLayout.setActionBarVisibilityCallback(this);
        }
        KeyEvent.Callback findViewById = view.findViewById(dastan.prince.bdfreevpn.R.id.action_bar);
        if (findViewById instanceof InterfaceC0590Wj) {
            wrapper = (InterfaceC0590Wj) findViewById;
        } else {
            if (!(findViewById instanceof Toolbar)) {
                throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById != null ? findViewById.getClass().getSimpleName() : "null"));
            }
            wrapper = ((Toolbar) findViewById).getWrapper();
        }
        this.o = wrapper;
        this.p = (ActionBarContextView) view.findViewById(dastan.prince.bdfreevpn.R.id.action_context_bar);
        ActionBarContainer actionBarContainer = (ActionBarContainer) view.findViewById(dastan.prince.bdfreevpn.R.id.action_bar_container);
        this.n = actionBarContainer;
        InterfaceC0590Wj interfaceC0590Wj = this.o;
        if (interfaceC0590Wj == null || this.p == null || actionBarContainer == null) {
            throw new IllegalStateException(P30.class.getSimpleName().concat(" can only be used with a compatible window decor layout"));
        }
        Context context = ((C4232uX) interfaceC0590Wj).a.getContext();
        this.k = context;
        if ((((C4232uX) this.o).b & 4) != 0) {
            this.r = true;
        }
        int i = context.getApplicationInfo().targetSdkVersion;
        this.o.getClass();
        d0(context.getResources().getBoolean(dastan.prince.bdfreevpn.R.bool.abc_action_bar_embed_tabs));
        TypedArray obtainStyledAttributes = this.k.obtainStyledAttributes(null, GM.a, dastan.prince.bdfreevpn.R.attr.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(14, false)) {
            ActionBarOverlayLayout actionBarOverlayLayout2 = this.m;
            if (!actionBarOverlayLayout2.g) {
                throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
            }
            this.E = true;
            actionBarOverlayLayout2.setHideOnContentScrollEnabled(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(12, 0);
        if (dimensionPixelSize != 0) {
            ActionBarContainer actionBarContainer2 = this.n;
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            actionBarContainer2.setElevation(dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    public final void c0(boolean z) {
        if (this.r) {
            return;
        }
        int i = z ? 4 : 0;
        C4232uX c4232uX = (C4232uX) this.o;
        int i2 = c4232uX.b;
        this.r = true;
        c4232uX.a((i & 4) | (i2 & (-5)));
    }

    public final void d0(boolean z) {
        if (z) {
            this.n.setTabContainer(null);
            ((C4232uX) this.o).getClass();
        } else {
            ((C4232uX) this.o).getClass();
            this.n.setTabContainer(null);
        }
        this.o.getClass();
        ((C4232uX) this.o).a.setCollapsible(false);
        this.m.setHasNonEmbeddedTabs(false);
    }

    public final void e0(boolean z) {
        int i = 1;
        boolean z2 = this.A || !this.z;
        View view = this.q;
        TO to = this.H;
        if (!z2) {
            if (this.B) {
                this.B = false;
                C4431x20 c4431x20 = this.C;
                if (c4431x20 != null) {
                    c4431x20.a();
                }
                int i2 = this.x;
                N30 n30 = this.F;
                if (i2 != 0 || (!this.D && !z)) {
                    n30.a();
                    return;
                }
                this.n.setAlpha(1.0f);
                this.n.setTransitioning(true);
                C4431x20 c4431x202 = new C4431x20();
                float f = -this.n.getHeight();
                if (z) {
                    this.n.getLocationInWindow(new int[]{0, 0});
                    f -= r12[1];
                }
                C4352w20 a = AbstractC2925e20.a(this.n);
                a.e(f);
                View view2 = (View) a.a.get();
                if (view2 != null) {
                    view2.animate().setUpdateListener(to != null ? new E4(i, to, view2) : null);
                }
                boolean z3 = c4431x202.e;
                ArrayList arrayList = c4431x202.a;
                if (!z3) {
                    arrayList.add(a);
                }
                if (this.y && view != null) {
                    C4352w20 a2 = AbstractC2925e20.a(view);
                    a2.e(f);
                    if (!c4431x202.e) {
                        arrayList.add(a2);
                    }
                }
                AccelerateInterpolator accelerateInterpolator = I;
                boolean z4 = c4431x202.e;
                if (!z4) {
                    c4431x202.c = accelerateInterpolator;
                }
                if (!z4) {
                    c4431x202.b = 250L;
                }
                if (!z4) {
                    c4431x202.d = n30;
                }
                this.C = c4431x202;
                c4431x202.b();
                return;
            }
            return;
        }
        if (this.B) {
            return;
        }
        this.B = true;
        C4431x20 c4431x203 = this.C;
        if (c4431x203 != null) {
            c4431x203.a();
        }
        this.n.setVisibility(0);
        int i3 = this.x;
        N30 n302 = this.G;
        if (i3 == 0 && (this.D || z)) {
            this.n.setTranslationY(0.0f);
            float f2 = -this.n.getHeight();
            if (z) {
                this.n.getLocationInWindow(new int[]{0, 0});
                f2 -= r12[1];
            }
            this.n.setTranslationY(f2);
            C4431x20 c4431x204 = new C4431x20();
            C4352w20 a3 = AbstractC2925e20.a(this.n);
            a3.e(0.0f);
            View view3 = (View) a3.a.get();
            if (view3 != null) {
                view3.animate().setUpdateListener(to != null ? new E4(i, to, view3) : null);
            }
            boolean z5 = c4431x204.e;
            ArrayList arrayList2 = c4431x204.a;
            if (!z5) {
                arrayList2.add(a3);
            }
            if (this.y && view != null) {
                view.setTranslationY(f2);
                C4352w20 a4 = AbstractC2925e20.a(view);
                a4.e(0.0f);
                if (!c4431x204.e) {
                    arrayList2.add(a4);
                }
            }
            DecelerateInterpolator decelerateInterpolator = J;
            boolean z6 = c4431x204.e;
            if (!z6) {
                c4431x204.c = decelerateInterpolator;
            }
            if (!z6) {
                c4431x204.b = 250L;
            }
            if (!z6) {
                c4431x204.d = n302;
            }
            this.C = c4431x204;
            c4431x204.b();
        } else {
            this.n.setAlpha(1.0f);
            this.n.setTranslationY(0.0f);
            if (this.y && view != null) {
                view.setTranslationY(0.0f);
            }
            n302.a();
        }
        ActionBarOverlayLayout actionBarOverlayLayout = this.m;
        if (actionBarOverlayLayout != null) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            actionBarOverlayLayout.requestApplyInsets();
        }
    }

    public P30(Dialog dialog) {
        new ArrayList();
        this.w = new ArrayList();
        this.x = 0;
        this.y = true;
        this.B = true;
        this.F = new N30(this, 0);
        this.G = new N30(this, 1);
        this.H = new TO(this, 8);
        b0(dialog.getWindow().getDecorView());
    }
}
