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
import app.vpn.amtunnellite.R;
import java.util.ArrayList;

/* renamed from: i1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3543i1 implements IE {
    public final Context a;
    public Context b;
    public MenuC3948nE c;
    public final LayoutInflater d;
    public HE e;
    public LE h;
    public C3466h1 i;
    public Drawable j;
    public boolean k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public C3235e1 s;
    public C3235e1 t;
    public RunnableC3389g1 u;
    public C3312f1 v;
    public final int f = R.layout.abc_action_menu_layout;
    public final int g = R.layout.abc_action_menu_item_layout;
    public final SparseBooleanArray r = new SparseBooleanArray();
    public final C4532uu w = new C4532uu(this, 5);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3543i1(Context context) {
        this.a = context;
        this.d = LayoutInflater.from(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void a(MenuC3948nE menuC3948nE, boolean z) {
        g();
        C3235e1 c3235e1 = this.t;
        if (c3235e1 != null && c3235e1.b()) {
            c3235e1.j.dismiss();
        }
        HE he = this.e;
        if (he != null) {
            he.a(menuC3948nE, z);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r5v4, types: [KE] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final View b(C4563vE c4563vE, View view, ViewGroup viewGroup) {
        ActionMenuItemView actionMenuItemView;
        View actionView = c4563vE.getActionView();
        int i = 0;
        if (actionView == null || c4563vE.d()) {
            if (view instanceof KE) {
                actionMenuItemView = (KE) view;
            } else {
                actionMenuItemView = (KE) this.d.inflate(this.g, viewGroup, false);
            }
            actionMenuItemView.c(c4563vE);
            ActionMenuItemView actionMenuItemView2 = actionMenuItemView;
            actionMenuItemView2.setItemInvoker((ActionMenuView) this.h);
            if (this.v == null) {
                this.v = new C3312f1(this);
            }
            actionMenuItemView2.setPopupCallback(this.v);
            actionView = actionMenuItemView;
        }
        if (c4563vE.C) {
            i = 8;
        }
        actionView.setVisibility(i);
        ViewGroup.LayoutParams layoutParams = actionView.getLayoutParams();
        ((ActionMenuView) viewGroup).getClass();
        if (!(layoutParams instanceof C3695k1)) {
            actionView.setLayoutParams(ActionMenuView.k(layoutParams));
        }
        return actionView;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean c(C4563vE c4563vE) {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void d(HE he) {
        this.e = he;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean e(C4563vE c4563vE) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void f() {
        int i;
        C4563vE c4563vE;
        ViewGroup viewGroup = (ViewGroup) this.h;
        ArrayList arrayList = null;
        boolean z = false;
        if (viewGroup != null) {
            MenuC3948nE menuC3948nE = this.c;
            if (menuC3948nE != null) {
                menuC3948nE.i();
                ArrayList l = this.c.l();
                int size = l.size();
                i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    C4563vE c4563vE2 = (C4563vE) l.get(i2);
                    if (c4563vE2.e()) {
                        View childAt = viewGroup.getChildAt(i);
                        if (childAt instanceof KE) {
                            c4563vE = ((KE) childAt).getItemData();
                        } else {
                            c4563vE = null;
                        }
                        View b = b(c4563vE2, childAt, viewGroup);
                        if (c4563vE2 != c4563vE) {
                            b.setPressed(false);
                            b.jumpDrawablesToCurrentState();
                        }
                        if (b != childAt) {
                            ViewGroup viewGroup2 = (ViewGroup) b.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(b);
                            }
                            ((ViewGroup) this.h).addView(b, i);
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
        MenuC3948nE menuC3948nE2 = this.c;
        if (menuC3948nE2 != null) {
            menuC3948nE2.i();
            ArrayList arrayList2 = menuC3948nE2.i;
            int size2 = arrayList2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                ActionProviderVisibilityListenerC4640wE actionProviderVisibilityListenerC4640wE = ((C4563vE) arrayList2.get(i3)).A;
            }
        }
        MenuC3948nE menuC3948nE3 = this.c;
        if (menuC3948nE3 != null) {
            menuC3948nE3.i();
            arrayList = menuC3948nE3.j;
        }
        if (this.l && arrayList != null) {
            int size3 = arrayList.size();
            if (size3 == 1) {
                z = !((C4563vE) arrayList.get(0)).C;
            } else if (size3 > 0) {
                z = true;
            }
        }
        C3466h1 c3466h1 = this.i;
        if (z) {
            if (c3466h1 == null) {
                this.i = new C3466h1(this, this.a);
            }
            ViewGroup viewGroup3 = (ViewGroup) this.i.getParent();
            if (viewGroup3 != this.h) {
                if (viewGroup3 != null) {
                    viewGroup3.removeView(this.i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.h;
                C3466h1 c3466h12 = this.i;
                actionMenuView.getClass();
                C3695k1 j = ActionMenuView.j();
                j.a = true;
                actionMenuView.addView(c3466h12, j);
            }
        } else if (c3466h1 != null) {
            Object parent = c3466h1.getParent();
            Object obj = this.h;
            if (parent == obj) {
                ((ViewGroup) obj).removeView(this.i);
            }
        }
        ((ActionMenuView) this.h).setOverflowReserved(this.l);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean g() {
        Object obj;
        RunnableC3389g1 runnableC3389g1 = this.u;
        if (runnableC3389g1 != null && (obj = this.h) != null) {
            ((View) obj).removeCallbacks(runnableC3389g1);
            this.u = null;
            return true;
        }
        C3235e1 c3235e1 = this.s;
        if (c3235e1 != null) {
            if (c3235e1.b()) {
                c3235e1.j.dismiss();
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void h(Context context, MenuC3948nE menuC3948nE) {
        this.b = context;
        LayoutInflater.from(context);
        this.c = menuC3948nE;
        Resources resources = context.getResources();
        if (!this.m) {
            this.l = true;
        }
        int i = 2;
        this.n = context.getResources().getDisplayMetrics().widthPixels / 2;
        Configuration configuration = context.getResources().getConfiguration();
        int i2 = configuration.screenWidthDp;
        int i3 = configuration.screenHeightDp;
        if (configuration.smallestScreenWidthDp <= 600 && i2 <= 600 && ((i2 <= 960 || i3 <= 720) && (i2 <= 720 || i3 <= 960))) {
            if (i2 < 500 && ((i2 <= 640 || i3 <= 480) && (i2 <= 480 || i3 <= 640))) {
                if (i2 >= 360) {
                    i = 3;
                }
            } else {
                i = 4;
            }
        } else {
            i = 5;
        }
        this.p = i;
        int i4 = this.n;
        if (this.l) {
            if (this.i == null) {
                C3466h1 c3466h1 = new C3466h1(this, this.a);
                this.i = c3466h1;
                if (this.k) {
                    c3466h1.setImageDrawable(this.j);
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
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean i(AU au) {
        boolean z;
        if (!au.hasVisibleItems()) {
            return false;
        }
        AU au2 = au;
        while (true) {
            MenuC3948nE menuC3948nE = au2.z;
            if (menuC3948nE == this.c) {
                break;
            }
            au2 = (AU) menuC3948nE;
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
                if ((childAt instanceof KE) && ((KE) childAt).getItemData() == au2.A) {
                    view = childAt;
                    break;
                }
                i++;
            }
        }
        if (view == null) {
            return false;
        }
        au.A.getClass();
        int size = au.f.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                MenuItem item = au.getItem(i2);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
                i2++;
            } else {
                z = false;
                break;
            }
        }
        C3235e1 c3235e1 = new C3235e1(this, this.b, au, view);
        this.t = c3235e1;
        c3235e1.h = z;
        AE ae = c3235e1.j;
        if (ae != null) {
            ae.n(z);
        }
        C3235e1 c3235e12 = this.t;
        if (!c3235e12.b()) {
            if (c3235e12.f != null) {
                c3235e12.d(0, 0, false, false);
            } else {
                throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
            }
        }
        HE he = this.e;
        if (he != null) {
            he.r(au);
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean j() {
        int i;
        ArrayList arrayList;
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        MenuC3948nE menuC3948nE = this.c;
        if (menuC3948nE != null) {
            arrayList = menuC3948nE.l();
            i = arrayList.size();
        } else {
            i = 0;
            arrayList = null;
        }
        int i3 = this.p;
        int i4 = this.o;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.h;
        int i5 = 0;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            i2 = 2;
            z = true;
            if (i5 >= i) {
                break;
            }
            C4563vE c4563vE = (C4563vE) arrayList.get(i5);
            int i8 = c4563vE.y;
            if ((i8 & 2) == 2) {
                i6++;
            } else if ((i8 & 1) == 1) {
                i7++;
            } else {
                z5 = true;
            }
            if (this.q && c4563vE.C) {
                i3 = 0;
            }
            i5++;
        }
        if (this.l && (z5 || i7 + i6 > i3)) {
            i3--;
        }
        int i9 = i3 - i6;
        SparseBooleanArray sparseBooleanArray = this.r;
        sparseBooleanArray.clear();
        int i10 = 0;
        int i11 = 0;
        while (i10 < i) {
            C4563vE c4563vE2 = (C4563vE) arrayList.get(i10);
            int i12 = c4563vE2.y;
            if ((i12 & 2) == i2) {
                z2 = z;
            } else {
                z2 = false;
            }
            int i13 = c4563vE2.b;
            if (z2) {
                View b = b(c4563vE2, null, viewGroup);
                b.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredWidth = b.getMeasuredWidth();
                i4 -= measuredWidth;
                if (i11 == 0) {
                    i11 = measuredWidth;
                }
                if (i13 != 0) {
                    sparseBooleanArray.put(i13, z);
                }
                c4563vE2.g(z);
            } else if ((i12 & 1) == z) {
                boolean z6 = sparseBooleanArray.get(i13);
                if ((i9 > 0 || z6) && i4 > 0) {
                    z3 = z;
                } else {
                    z3 = false;
                }
                if (z3) {
                    View b2 = b(c4563vE2, null, viewGroup);
                    b2.measure(makeMeasureSpec, makeMeasureSpec);
                    int measuredWidth2 = b2.getMeasuredWidth();
                    i4 -= measuredWidth2;
                    if (i11 == 0) {
                        i11 = measuredWidth2;
                    }
                    if (i4 + i11 > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    z3 &= z4;
                }
                if (z3 && i13 != 0) {
                    sparseBooleanArray.put(i13, true);
                } else if (z6) {
                    sparseBooleanArray.put(i13, false);
                    for (int i14 = 0; i14 < i10; i14++) {
                        C4563vE c4563vE3 = (C4563vE) arrayList.get(i14);
                        if (c4563vE3.b == i13) {
                            if (c4563vE3.e()) {
                                i9++;
                            }
                            c4563vE3.g(false);
                        }
                    }
                }
                if (z3) {
                    i9--;
                }
                c4563vE2.g(z3);
            } else {
                c4563vE2.g(false);
                i10++;
                i2 = 2;
                z = true;
            }
            i10++;
            i2 = 2;
            z = true;
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean k() {
        C3235e1 c3235e1 = this.s;
        if (c3235e1 != null && c3235e1.b()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean l() {
        MenuC3948nE menuC3948nE;
        if (this.l && !k() && (menuC3948nE = this.c) != null && this.h != null && this.u == null) {
            menuC3948nE.i();
            if (!menuC3948nE.j.isEmpty()) {
                RunnableC3389g1 runnableC3389g1 = new RunnableC3389g1(0, this, new C3235e1(this, this.b, this.c, this.i));
                this.u = runnableC3389g1;
                ((View) this.h).post(runnableC3389g1);
                return true;
            }
            return false;
        }
        return false;
    }
}
