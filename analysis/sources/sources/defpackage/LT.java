package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class LT extends AE implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public final Context b;
    public final MenuC3948nE c;
    public final C3717kE d;
    public final boolean e;
    public final int f;
    public final int g;
    public final int h;
    public final GE i;
    public PopupWindow.OnDismissListener l;
    public View m;
    public View n;
    public HE o;
    public ViewTreeObserver p;
    public boolean q;
    public boolean r;
    public int s;
    public boolean u;
    public final ViewTreeObserverOnGlobalLayoutListenerC4011o5 j = new ViewTreeObserverOnGlobalLayoutListenerC4011o5(this, 3);
    public final ViewOnAttachStateChangeListenerC0433Qb k = new ViewOnAttachStateChangeListenerC0433Qb(this, 5);
    public int t = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LT(int i, int i2, MenuC3948nE menuC3948nE, Context context, View view, boolean z) {
        this.b = context;
        this.c = menuC3948nE;
        this.e = z;
        this.d = new C3717kE(menuC3948nE, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.g = i;
        this.h = i2;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.m = view;
        this.i = new GE(context, null, i, i2);
        menuC3948nE.b(this, context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void a(MenuC3948nE menuC3948nE, boolean z) {
        if (menuC3948nE != this.c) {
            return;
        }
        dismiss();
        HE he = this.o;
        if (he != null) {
            he.a(menuC3948nE, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final boolean b() {
        if (!this.q && this.i.z.isShowing()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void d(HE he) {
        this.o = he;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final void dismiss() {
        if (b()) {
            this.i.dismiss();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void f() {
        this.r = false;
        C3717kE c3717kE = this.d;
        if (c3717kE != null) {
            c3717kE.notifyDataSetChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final C3219dm g() {
        return this.i.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean i(AU au) {
        if (au.hasVisibleItems()) {
            View view = this.n;
            CE ce = new CE(this.g, this.h, au, this.b, view, this.e);
            HE he = this.o;
            ce.i = he;
            AE ae = ce.j;
            if (ae != null) {
                ae.d(he);
            }
            boolean t = AE.t(au);
            ce.h = t;
            AE ae2 = ce.j;
            if (ae2 != null) {
                ae2.n(t);
            }
            ce.k = this.l;
            this.l = null;
            this.c.c(false);
            GE ge = this.i;
            int i = ge.f;
            int n = ge.n();
            if ((Gravity.getAbsoluteGravity(this.t, this.m.getLayoutDirection()) & 7) == 5) {
                i += this.m.getWidth();
            }
            if (!ce.b()) {
                if (ce.f != null) {
                    ce.d(i, n, true, true);
                }
            }
            HE he2 = this.o;
            if (he2 != null) {
                he2.r(au);
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean j() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void k(MenuC3948nE menuC3948nE) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void m(View view) {
        this.m = view;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void n(boolean z) {
        this.d.c = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void o(int i) {
        this.t = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.q = true;
        this.c.c(true);
        ViewTreeObserver viewTreeObserver = this.p;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.p = this.n.getViewTreeObserver();
            }
            this.p.removeGlobalOnLayoutListener(this.j);
            this.p = null;
        }
        this.n.removeOnAttachStateChangeListener(this.k);
        PopupWindow.OnDismissListener onDismissListener = this.l;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 82) {
            dismiss();
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void p(int i) {
        this.i.f = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.l = onDismissListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void r(boolean z) {
        this.u = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void s(int i) {
        this.i.j(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final void show() {
        View view;
        boolean z;
        Rect rect;
        if (!b()) {
            if (!this.q && (view = this.m) != null) {
                this.n = view;
                GE ge = this.i;
                ge.z.setOnDismissListener(this);
                ge.p = this;
                ge.y = true;
                ge.z.setFocusable(true);
                View view2 = this.n;
                if (this.p == null) {
                    z = true;
                } else {
                    z = false;
                }
                ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
                this.p = viewTreeObserver;
                if (z) {
                    viewTreeObserver.addOnGlobalLayoutListener(this.j);
                }
                view2.addOnAttachStateChangeListener(this.k);
                ge.o = view2;
                ge.l = this.t;
                boolean z2 = this.r;
                Context context = this.b;
                C3717kE c3717kE = this.d;
                if (!z2) {
                    this.s = AE.l(c3717kE, context, this.f);
                    this.r = true;
                }
                ge.q(this.s);
                ge.z.setInputMethodMode(2);
                Rect rect2 = this.a;
                if (rect2 != null) {
                    rect = new Rect(rect2);
                } else {
                    rect = null;
                }
                ge.x = rect;
                ge.show();
                C3219dm c3219dm = ge.c;
                c3219dm.setOnKeyListener(this);
                if (this.u) {
                    MenuC3948nE menuC3948nE = this.c;
                    if (menuC3948nE.m != null) {
                        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c3219dm, false);
                        TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                        if (textView != null) {
                            textView.setText(menuC3948nE.m);
                        }
                        frameLayout.setEnabled(false);
                        c3219dm.addHeaderView(frameLayout, null, false);
                    }
                }
                ge.p(c3717kE);
                ge.show();
                return;
            }
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }
}
