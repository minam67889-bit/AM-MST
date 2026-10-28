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
import dastan.prince.bdfreevpn.R;

/* loaded from: classes.dex */
public final class MU extends AbstractC3899qF implements PopupWindow.OnDismissListener, View.OnKeyListener {
    public final Context b;
    public final MenuC2945eF c;
    public final C0791bF d;
    public final boolean e;
    public final int f;
    public final int g;
    public final C4372wF h;
    public C3977rF k;
    public View l;
    public View m;
    public InterfaceC4451xF n;
    public ViewTreeObserver o;
    public boolean p;
    public boolean q;
    public int r;
    public boolean t;
    public final ViewTreeObserverOnGlobalLayoutListenerC4594z5 i = new ViewTreeObserverOnGlobalLayoutListenerC4594z5(this, 3);
    public final ViewOnAttachStateChangeListenerC2970ec j = new ViewOnAttachStateChangeListenerC2970ec(this, 5);
    public int s = 0;

    public MU(int i, MenuC2945eF menuC2945eF, Context context, View view, boolean z) {
        this.b = context;
        this.c = menuC2945eF;
        this.e = z;
        this.d = new C0791bF(menuC2945eF, LayoutInflater.from(context), z, R.layout.abc_popup_menu_item_layout);
        this.g = i;
        Resources resources = context.getResources();
        this.f = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.l = view;
        this.h = new C4372wF(context, null, i);
        menuC2945eF.b(this, context);
    }

    @Override // defpackage.InterfaceC3597mT
    public final boolean a() {
        return !this.p && this.h.z.isShowing();
    }

    @Override // defpackage.InterfaceC4530yF
    public final void b(MenuC2945eF menuC2945eF, boolean z) {
        if (menuC2945eF != this.c) {
            return;
        }
        dismiss();
        InterfaceC4451xF interfaceC4451xF = this.n;
        if (interfaceC4451xF != null) {
            interfaceC4451xF.b(menuC2945eF, z);
        }
    }

    @Override // defpackage.InterfaceC4530yF
    public final void d(InterfaceC4451xF interfaceC4451xF) {
        this.n = interfaceC4451xF;
    }

    @Override // defpackage.InterfaceC3597mT
    public final void dismiss() {
        if (a()) {
            this.h.dismiss();
        }
    }

    @Override // defpackage.InterfaceC4530yF
    public final void f() {
        this.q = false;
        C0791bF c0791bF = this.d;
        if (c0791bF != null) {
            c0791bF.notifyDataSetChanged();
        }
    }

    @Override // defpackage.InterfaceC3597mT
    public final C3304im g() {
        return this.h.c;
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean i(SubMenuC4625zV subMenuC4625zV) {
        if (subMenuC4625zV.hasVisibleItems()) {
            View view = this.m;
            C4056sF c4056sF = new C4056sF(this.g, subMenuC4625zV, this.b, view, this.e);
            InterfaceC4451xF interfaceC4451xF = this.n;
            c4056sF.h = interfaceC4451xF;
            AbstractC3899qF abstractC3899qF = c4056sF.i;
            if (abstractC3899qF != null) {
                abstractC3899qF.d(interfaceC4451xF);
            }
            boolean t = AbstractC3899qF.t(subMenuC4625zV);
            c4056sF.g = t;
            AbstractC3899qF abstractC3899qF2 = c4056sF.i;
            if (abstractC3899qF2 != null) {
                abstractC3899qF2.n(t);
            }
            c4056sF.j = this.k;
            this.k = null;
            this.c.c(false);
            C4372wF c4372wF = this.h;
            int i = c4372wF.f;
            int m = c4372wF.m();
            if ((Gravity.getAbsoluteGravity(this.s, this.l.getLayoutDirection()) & 7) == 5) {
                i += this.l.getWidth();
            }
            if (!c4056sF.b()) {
                if (c4056sF.e != null) {
                    c4056sF.d(i, m, true, true);
                }
            }
            InterfaceC4451xF interfaceC4451xF2 = this.n;
            if (interfaceC4451xF2 != null) {
                interfaceC4451xF2.k(subMenuC4625zV);
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean j() {
        return false;
    }

    @Override // defpackage.AbstractC3899qF
    public final void k(MenuC2945eF menuC2945eF) {
    }

    @Override // defpackage.AbstractC3899qF
    public final void m(View view) {
        this.l = view;
    }

    @Override // defpackage.AbstractC3899qF
    public final void n(boolean z) {
        this.d.c = z;
    }

    @Override // defpackage.AbstractC3899qF
    public final void o(int i) {
        this.s = i;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        this.p = true;
        this.c.c(true);
        ViewTreeObserver viewTreeObserver = this.o;
        if (viewTreeObserver != null) {
            if (!viewTreeObserver.isAlive()) {
                this.o = this.m.getViewTreeObserver();
            }
            this.o.removeGlobalOnLayoutListener(this.i);
            this.o = null;
        }
        this.m.removeOnAttachStateChangeListener(this.j);
        C3977rF c3977rF = this.k;
        if (c3977rF != null) {
            c3977rF.onDismiss();
        }
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    @Override // defpackage.AbstractC3899qF
    public final void p(int i) {
        this.h.f = i;
    }

    @Override // defpackage.AbstractC3899qF
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.k = (C3977rF) onDismissListener;
    }

    @Override // defpackage.AbstractC3899qF
    public final void r(boolean z) {
        this.t = z;
    }

    @Override // defpackage.AbstractC3899qF
    public final void s(int i) {
        this.h.f(i);
    }

    @Override // defpackage.InterfaceC3597mT
    public final void show() {
        View view;
        if (a()) {
            return;
        }
        if (this.p || (view = this.l) == null) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
        this.m = view;
        C4372wF c4372wF = this.h;
        c4372wF.z.setOnDismissListener(this);
        c4372wF.p = this;
        c4372wF.y = true;
        c4372wF.z.setFocusable(true);
        View view2 = this.m;
        boolean z = this.o == null;
        ViewTreeObserver viewTreeObserver = view2.getViewTreeObserver();
        this.o = viewTreeObserver;
        if (z) {
            viewTreeObserver.addOnGlobalLayoutListener(this.i);
        }
        view2.addOnAttachStateChangeListener(this.j);
        c4372wF.o = view2;
        c4372wF.l = this.s;
        boolean z2 = this.q;
        Context context = this.b;
        C0791bF c0791bF = this.d;
        if (!z2) {
            this.r = AbstractC3899qF.l(c0791bF, context, this.f);
            this.q = true;
        }
        c4372wF.q(this.r);
        c4372wF.z.setInputMethodMode(2);
        Rect rect = this.a;
        c4372wF.x = rect != null ? new Rect(rect) : null;
        c4372wF.show();
        C3304im c3304im = c4372wF.c;
        c3304im.setOnKeyListener(this);
        if (this.t) {
            MenuC2945eF menuC2945eF = this.c;
            if (menuC2945eF.m != null) {
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c3304im, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                if (textView != null) {
                    textView.setText(menuC2945eF.m);
                }
                frameLayout.setEnabled(false);
                c3304im.addHeaderView(frameLayout, null, false);
            }
        }
        c4372wF.o(c0791bF);
        c4372wF.show();
    }
}
