package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;

/* renamed from: l1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3480l1 implements InterfaceC4530yF {
    public final Context a;
    public Context b;
    public MenuC2945eF c;
    public final LayoutInflater d;
    public InterfaceC4451xF e;
    public BF h;
    public C3400k1 i;
    public Drawable j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public C3162h1 s;
    public C3162h1 t;
    public RunnableC3320j1 u;
    public C3242i1 v;
    public final int f = R.layout.abc_action_menu_layout;
    public final int g = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray r = new SparseBooleanArray();
    public final C0136Ew w = new C0136Ew(this, 2);

    public C3480l1(Context context) {
        this.a = context;
        this.d = LayoutInflater.from(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [AF] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    public final View a(C3503lF c3503lF, View view, ViewGroup viewGroup) {
        View actionView = c3503lF.getActionView();
        if (actionView == null || c3503lF.e()) {
            ActionMenuItemView actionMenuItemView = view instanceof AF ? (AF) view : (AF) this.d.inflate(this.g, viewGroup, false);
            actionMenuItemView.c(c3503lF);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.h);
            if (this.v == null) {
                this.v = new C3242i1(this);
            }
            actionMenuItemView2.setPopupCallback(this.v);
            actionView = actionMenuItemView;
        }
        actionView.setVisibility(c3503lF.C ? 8 : 0);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C3639n1)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    @Override // defpackage.InterfaceC4530yF
    public final void b(MenuC2945eF menuC2945eF, boolean z) {
        g();
        C3162h1 c3162h1 = this.t;
        if (c3162h1 != null && c3162h1.b()) {
            c3162h1.i.dismiss();
        }
        InterfaceC4451xF interfaceC4451xF = this.e;
        if (interfaceC4451xF != null) {
            interfaceC4451xF.b(menuC2945eF, z);
        }
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean c(C3503lF c3503lF) {
        return false;
    }

    @Override // defpackage.InterfaceC4530yF
    public final void d(InterfaceC4451xF interfaceC4451xF) {
        throw null;
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean e(C3503lF c3503lF) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC4530yF
    public final void f() {
        int i;
        ViewGroup viewGroup = (ViewGroup) this.h;
        ArrayList arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            MenuC2945eF menuC2945eF = this.c;
            if (menuC2945eF != null) {
                menuC2945eF.i();
                ArrayList l = this.c.l();
                int size = l.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    C3503lF c3503lF = (C3503lF) l.get(i2);
                    if ((c3503lF.x & 32) == 32) {
                        View childAt = viewGroup.getChildAt(i);
                        C3503lF itemData = childAt instanceof AF ? ((AF) childAt).getItemData() : null;
                        View a = a(c3503lF, childAt, viewGroup);
                        if (c3503lF != itemData) {
                            a.setPressed(false);
                            a.jumpDrawablesToCurrentState();
                        }
                        if (a != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) a.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(a);
                            }
                            ((ViewGroup) this.h).addView(a, i);
                        }
                        i++;
                    }
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (viewGroup.getChildAt(i) == this.i) {
                    i++;
                } else {
                    viewGroup.removeViewAt(i);
                }
            }
        }
        ((View) this.h).requestLayout();
        MenuC2945eF menuC2945eF2 = this.c;
        if (menuC2945eF2 != null) {
            menuC2945eF2.i();
            ArrayList arrayList2 = menuC2945eF2.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ActionProviderVisibilityListenerC3583mF actionProviderVisibilityListenerC3583mF = ((C3503lF) arrayList2.get(i3)).A;
            }
        }
        MenuC2945eF menuC2945eF3 = this.c;
        if (menuC2945eF3 != null) {
            menuC2945eF3.i();
            arrayList = menuC2945eF3.j;
        }
        if (this.l && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((C3503lF) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z = true;
            }
        }
        if (z) {
            if (this.i == null) {
                this.i = new C3400k1(this, this.a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.i.getParent();
            if (viewGroup3 != this.h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.h;
                C3400k1 c3400k1 = this.i;
                actionMenuView.getClass();
                C3639n1 j = ActionMenuView.j();
                j.a = true;
                actionMenuView.addView(c3400k1, j);
            }
        } else {
            C3400k1 c3400k12 = this.i;
            if (c3400k12 != null) {
                Object parent = c3400k12.getParent();
                Object obj = this.h;
                if (parent == obj) {
                    ((ViewGroup) obj).removeView(this.i);
                }
            }
        }
        ((ActionMenuView) this.h).setOverflowReserved(this.l);
    }

    public final boolean g() {
        Object obj;
        RunnableC3320j1 runnableC3320j1 = this.u;
        if (runnableC3320j1 != null && (obj = this.h) != null) {
            ((View) obj).removeCallbacks(runnableC3320j1);
            this.u = null;
            return true;
        }
        C3162h1 c3162h1 = this.s;
        if (c3162h1 == null) {
            return false;
        }
        if (c3162h1.b()) {
            c3162h1.i.dismiss();
        }
        return true;
    }

    @Override // defpackage.InterfaceC4530yF
    public final void h(Context context, MenuC2945eF menuC2945eF) {
        this.b = context;
        LayoutInflater.from(context);
        this.c = menuC2945eF;
        Resources resources = context.getResources();
        if (!this.m) {
            this.l = true;
        }
        int i = 2;
        this.n = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp > 600 || i2 > 600 || ((i2 > 960 && i3 > 720) || (i2 > 720 && i3 > 960))) {
            i = 5;
        } else if (i2 >= 500 || ((i2 > 640 && i3 > 480) || (i2 > 480 && i3 > 640))) {
            i = 4;
        } else if (i2 >= 360) {
            i = 3;
        }
        this.p = i;
        int i4 = this.n;
        if (this.l) {
            if (this.i == null) {
                C3400k1 c3400k1 = new C3400k1(this, this.a);
                this.i = c3400k1;
                if (this.k) {
                    c3400k1.setImageDrawable(this.j);
                    this.j = null;
                    this.k = false;
                }
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                this.i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i4 -= this.i.getMeasuredWidth();
        } else {
            this.i = null;
        }
        this.o = i4;
        float f = resources.getDisplayMetrics().density;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.InterfaceC4530yF
    public final boolean i(SubMenuC4625zV subMenuC4625zV) {
        boolean z;
        if (subMenuC4625zV.hasVisibleItems()) {
            SubMenuC4625zV subMenuC4625zV2 = subMenuC4625zV;
            while (true) {
                MenuC2945eF menuC2945eF = subMenuC4625zV2.z;
                if (menuC2945eF == this.c) {
                    break;
                }
                subMenuC4625zV2 = (SubMenuC4625zV) menuC2945eF;
            }
            ViewGroup viewGroup = (ViewGroup) this.h;
            View view = null;
            if (viewGroup != null) {
                int childCount = viewGroup.getChildCount();
                int i = 0;
                while (true) {
                    if (i >= childCount) {
                        break;
                    }
                    View childAt = viewGroup.getChildAt(i);
                    if ((childAt instanceof AF) && ((AF) childAt).getItemData() == subMenuC4625zV2.A) {
                        view = childAt;
                        break;
                    }
                    i++;
                }
            }
            if (view != null) {
                subMenuC4625zV.A.getClass();
                int size = subMenuC4625zV.f.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        z = false;
                        break;
                    }
                    MenuItem item = subMenuC4625zV.getItem(i2);
                    if (item.isVisible() && item.getIcon() != null) {
                        z = true;
                        break;
                    }
                    i2++;
                }
                C3162h1 c3162h1 = new C3162h1(this, this.b, subMenuC4625zV, view);
                this.t = c3162h1;
                c3162h1.g = z;
                AbstractC3899qF abstractC3899qF = c3162h1.i;
                if (abstractC3899qF != null) {
                    abstractC3899qF.n(z);
                }
                C3162h1 c3162h12 = this.t;
                if (!c3162h12.b()) {
                    if (c3162h12.e == null) {
                        throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
                    }
                    c3162h12.d(0, 0, false, false);
                }
                InterfaceC4451xF interfaceC4451xF = this.e;
                if (interfaceC4451xF != null) {
                    interfaceC4451xF.k(subMenuC4625zV);
                }
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean j() {
        int i;
        ArrayList arrayList;
        int i2;
        boolean z;
        C3480l1 c3480l1 = this;
        MenuC2945eF menuC2945eF = c3480l1.c;
        if (menuC2945eF != null) {
            arrayList = menuC2945eF.l();
            i = arrayList.size();
        } else {
            i = 0;
            arrayList = null;
        }
        int i3 = c3480l1.p;
        int i4 = c3480l1.o;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) c3480l1.h;
        int i5 = 0;
        boolean z2 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= i) {
                break;
            }
            C3503lF c3503lF = (C3503lF) arrayList.get(i5);
            int i8 = c3503lF.y;
            if ((i8 & 2) == 2) {
                i6++;
            } else if ((i8 & 1) == 1) {
                i7++;
            } else {
                z2 = true;
            }
            if (c3480l1.q && c3503lF.C) {
                i3 = 0;
            }
            i5++;
        }
        if (c3480l1.l && (z2 || i7 + i6 > i3)) {
            i3--;
        }
        int i9 = i3 - i6;
        SparseBooleanArray sparseBooleanArray = c3480l1.r;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            C3503lF c3503lF2 = (C3503lF) arrayList.get(i10);
            int i12 = c3503lF2.y;
            boolean z3 = (i12 & 2) == i2 ? z : false;
            int i13 = c3503lF2.b;
            if (z3) {
                View a = c3480l1.a(c3503lF2, null, viewGroup);
                a.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = a.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                c3503lF2.f(z);
            } else if ((i12 & 1) == z) {
                boolean z4 = sparseBooleanArray.get(i13);
                boolean z5 = ((i9 > 0 || z4) && i4 > 0) ? z : false;
                if (z5) {
                    View a2 = c3480l1.a(c3503lF2, null, viewGroup);
                    a2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = a2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    z5 &= i4 + i11 > 0;
                }
                if (z5 && i13 != 0) {
                    sparseBooleanArray.put(i13, true);
                } else if (z4) {
                    sparseBooleanArray.put(i13, false);
                    for (int i14 = 0; i14 < i10; i14++) {
                        C3503lF c3503lF3 = (C3503lF) arrayList.get(i14);
                        if (c3503lF3.b == i13) {
                            if ((c3503lF3.x & 32) == 32) {
                                i9++;
                            }
                            c3503lF3.f(false);
                        }
                    }
                }
                if (z5) {
                    i9--;
                }
                c3503lF2.f(z5);
            } else {
                c3503lF2.f(false);
                i10++;
                i2 = 2;
                c3480l1 = this;
                z = true;
            }
            i10++;
            i2 = 2;
            c3480l1 = this;
            z = true;
        }
        return z;
    }

    public final boolean k() {
        C3162h1 c3162h1 = this.s;
        return c3162h1 != null && c3162h1.b();
    }

    public final boolean l() {
        MenuC2945eF menuC2945eF;
        if (!this.l || k() || (menuC2945eF = this.c) == null || this.h == null || this.u != null) {
            return false;
        }
        menuC2945eF.i();
        if (menuC2945eF.j.isEmpty()) {
            return false;
        }
        RunnableC3320j1 runnableC3320j1 = new RunnableC3320j1(0, this, new C3162h1(this, this.b, this.c, this.i));
        this.u = runnableC3320j1;
        ((View) this.h).post(runnableC3320j1);
        return true;
    }
}
