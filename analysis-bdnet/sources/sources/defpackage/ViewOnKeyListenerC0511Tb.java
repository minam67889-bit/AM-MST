package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: Tb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC0511Tb extends AE implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public boolean A;
    public final Context b;
    public final int c;
    public final int d;
    public final int e;
    public final boolean f;
    public final Handler g;
    public View o;
    public View p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public int u;
    public boolean w;
    public HE x;
    public ViewTreeObserver y;
    public PopupWindow.OnDismissListener z;
    public final ArrayList h = new ArrayList();
    public final ArrayList i = new ArrayList();
    public final ViewTreeObserverOnGlobalLayoutListenerC4011o5 j = new ViewTreeObserverOnGlobalLayoutListenerC4011o5(this, 2);
    public final ViewOnAttachStateChangeListenerC0433Qb k = new ViewOnAttachStateChangeListenerC0433Qb(this, 0);
    public final C4532uu l = new C4532uu(this, 15);
    public int m = 0;
    public int n = 0;
    public boolean v = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ViewOnKeyListenerC0511Tb(Context context, View view, int i, int i2, boolean z) {
        this.b = context;
        this.o = view;
        this.d = i;
        this.e = i2;
        this.f = z;
        this.q = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.g = new Handler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void a(MenuC3948nE menuC3948nE, boolean z) {
        int i;
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i2 = 0;
        while (true) {
            if (i2 < size) {
                if (menuC3948nE == ((C0485Sb) arrayList.get(i2)).b) {
                    break;
                } else {
                    i2++;
                }
            } else {
                i2 = -1;
                break;
            }
        }
        if (i2 < 0) {
            return;
        }
        int i3 = i2 + 1;
        if (i3 < arrayList.size()) {
            ((C0485Sb) arrayList.get(i3)).b.c(false);
        }
        C0485Sb c0485Sb = (C0485Sb) arrayList.remove(i2);
        c0485Sb.b.r(this);
        boolean z2 = this.A;
        GE ge = c0485Sb.a;
        if (z2) {
            DE.b(ge.z, null);
            ge.z.setAnimationStyle(0);
        }
        ge.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            i = ((C0485Sb) arrayList.get(size2 - 1)).c;
        } else if (this.o.getLayoutDirection() == 1) {
            i = 0;
        } else {
            i = 1;
        }
        this.q = i;
        if (size2 == 0) {
            dismiss();
            HE he = this.x;
            if (he != null) {
                he.a(menuC3948nE, true);
            }
            ViewTreeObserver viewTreeObserver = this.y;
            if (viewTreeObserver != null) {
                if (viewTreeObserver.isAlive()) {
                    this.y.removeGlobalOnLayoutListener(this.j);
                }
                this.y = null;
            }
            this.p.removeOnAttachStateChangeListener(this.k);
            this.z.onDismiss();
            return;
        }
        if (z) {
            ((C0485Sb) arrayList.get(0)).b.c(false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final boolean b() {
        ArrayList arrayList = this.i;
        if (arrayList.size() <= 0 || !((C0485Sb) arrayList.get(0)).a.z.isShowing()) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void d(HE he) {
        this.x = he;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final void dismiss() {
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        if (size > 0) {
            C0485Sb[] c0485SbArr = (C0485Sb[]) arrayList.toArray(new C0485Sb[size]);
            for (int i = size - 1; i >= 0; i--) {
                C0485Sb c0485Sb = c0485SbArr[i];
                if (c0485Sb.a.z.isShowing()) {
                    c0485Sb.a.dismiss();
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final void f() {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C0485Sb) it.next()).a.c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((C3717kE) adapter).notifyDataSetChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final C3219dm g() {
        ArrayList arrayList = this.i;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C0485Sb) arrayList.get(arrayList.size() - 1)).a.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.IE
    public final boolean i(AU au) {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            C0485Sb c0485Sb = (C0485Sb) it.next();
            if (au == c0485Sb.b) {
                c0485Sb.a.c.requestFocus();
                return true;
            }
        }
        if (au.hasVisibleItems()) {
            k(au);
            HE he = this.x;
            if (he != null) {
                he.r(au);
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
        menuC3948nE.b(this, this.b);
        if (b()) {
            u(menuC3948nE);
        } else {
            this.h.add(menuC3948nE);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void m(View view) {
        if (this.o != view) {
            this.o = view;
            this.n = Gravity.getAbsoluteGravity(this.m, view.getLayoutDirection());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void n(boolean z) {
        this.v = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void o(int i) {
        if (this.m != i) {
            this.m = i;
            this.n = Gravity.getAbsoluteGravity(i, this.o.getLayoutDirection());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C0485Sb c0485Sb;
        ArrayList arrayList = this.i;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i < size) {
                c0485Sb = (C0485Sb) arrayList.get(i);
                if (!c0485Sb.a.z.isShowing()) {
                    break;
                } else {
                    i++;
                }
            } else {
                c0485Sb = null;
                break;
            }
        }
        if (c0485Sb != null) {
            c0485Sb.b.c(false);
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
        this.r = true;
        this.t = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.z = onDismissListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void r(boolean z) {
        this.w = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AE
    public final void s(int i) {
        this.s = true;
        this.u = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4423tS
    public final void show() {
        boolean z;
        if (b()) {
            return;
        }
        ArrayList arrayList = this.h;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            u((MenuC3948nE) it.next());
        }
        arrayList.clear();
        View view = this.o;
        this.p = view;
        if (view != null) {
            if (this.y == null) {
                z = true;
            } else {
                z = false;
            }
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.y = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.j);
            }
            this.p.addOnAttachStateChangeListener(this.k);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0141, code lost:
    
        if (((r8.getWidth() + r11[0]) + r5) > r10.right) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0143, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0146, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x014b, code lost:
    
        if ((r11[0] - r5) < 0) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01b4  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(MenuC3948nE menuC3948nE) {
        C0485Sb c0485Sb;
        View view;
        Rect rect;
        int i;
        boolean z;
        int i2;
        int i3;
        int width;
        MenuItem menuItem;
        C3717kE c3717kE;
        int i4;
        int firstVisiblePosition;
        Context context = this.b;
        LayoutInflater from = LayoutInflater.from(context);
        C3717kE c3717kE2 = new C3717kE(menuC3948nE, from, this.f, R.layout.abc_cascading_menu_item_layout);
        if (!b() && this.v) {
            c3717kE2.c = true;
        } else if (b()) {
            c3717kE2.c = AE.t(menuC3948nE);
        }
        int l = AE.l(c3717kE2, context, this.c);
        GE ge = new GE(context, null, this.d, this.e);
        ge.C = this.l;
        ge.p = this;
        ge.z.setOnDismissListener(this);
        ge.o = this.o;
        ge.l = this.n;
        ge.y = true;
        ge.z.setFocusable(true);
        ge.z.setInputMethodMode(2);
        ge.p(c3717kE2);
        ge.q(l);
        ge.l = this.n;
        ArrayList arrayList = this.i;
        if (arrayList.size() > 0) {
            c0485Sb = (C0485Sb) arrayList.get(arrayList.size() - 1);
            MenuC3948nE menuC3948nE2 = c0485Sb.b;
            int size = menuC3948nE2.f.size();
            int i5 = 0;
            while (true) {
                if (i5 < size) {
                    menuItem = menuC3948nE2.getItem(i5);
                    if (menuItem.hasSubMenu() && menuC3948nE == menuItem.getSubMenu()) {
                        break;
                    } else {
                        i5++;
                    }
                } else {
                    menuItem = null;
                    break;
                }
            }
            if (menuItem == null) {
                view = null;
            } else {
                C3219dm c3219dm = c0485Sb.a.c;
                ListAdapter adapter = c3219dm.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i4 = headerViewListAdapter.getHeadersCount();
                    c3717kE = (C3717kE) headerViewListAdapter.getWrappedAdapter();
                } else {
                    c3717kE = (C3717kE) adapter;
                    i4 = 0;
                }
                int count = c3717kE.getCount();
                int i6 = 0;
                while (true) {
                    if (i6 < count) {
                        if (menuItem == c3717kE.getItem(i6)) {
                            break;
                        } else {
                            i6++;
                        }
                    } else {
                        i6 = -1;
                        break;
                    }
                }
                if (i6 != -1 && (firstVisiblePosition = (i6 + i4) - c3219dm.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < c3219dm.getChildCount()) {
                    view = c3219dm.getChildAt(firstVisiblePosition);
                }
            }
            if (view == null) {
                int i7 = Build.VERSION.SDK_INT;
                C3474h5 c3474h5 = ge.z;
                if (i7 <= 28) {
                    Method method = GE.D;
                    if (method != null) {
                        try {
                            method.invoke(c3474h5, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    EE.a(c3474h5, false);
                }
                DE.a(ge.z, null);
                C3219dm c3219dm2 = ((C0485Sb) arrayList.get(arrayList.size() - 1)).a.c;
                int[] iArr = new int[2];
                c3219dm2.getLocationOnScreen(iArr);
                Rect rect2 = new Rect();
                this.p.getWindowVisibleDisplayFrame(rect2);
                if (this.q == 1) {
                }
                if (i == 1) {
                    z = true;
                } else {
                    z = false;
                }
                this.q = i;
                if (Build.VERSION.SDK_INT >= 26) {
                    ge.o = view;
                    i3 = 0;
                    i2 = 0;
                } else {
                    int[] iArr2 = new int[2];
                    this.o.getLocationOnScreen(iArr2);
                    int[] iArr3 = new int[2];
                    view.getLocationOnScreen(iArr3);
                    if ((this.n & 7) == 5) {
                        iArr2[0] = this.o.getWidth() + iArr2[0];
                        iArr3[0] = view.getWidth() + iArr3[0];
                    }
                    i2 = iArr3[0] - iArr2[0];
                    i3 = iArr3[1] - iArr2[1];
                }
                if ((this.n & 5) == 5) {
                    if (z) {
                        width = i2 + l;
                        ge.f = width;
                        ge.k = true;
                        ge.j = true;
                        ge.j(i3);
                    } else {
                        l = view.getWidth();
                        width = i2 - l;
                        ge.f = width;
                        ge.k = true;
                        ge.j = true;
                        ge.j(i3);
                    }
                } else {
                    if (z) {
                        width = i2 + view.getWidth();
                        ge.f = width;
                        ge.k = true;
                        ge.j = true;
                        ge.j(i3);
                    }
                    width = i2 - l;
                    ge.f = width;
                    ge.k = true;
                    ge.j = true;
                    ge.j(i3);
                }
            } else {
                if (this.r) {
                    ge.f = this.t;
                }
                if (this.s) {
                    ge.j(this.u);
                }
                Rect rect3 = this.a;
                if (rect3 != null) {
                    rect = new Rect(rect3);
                } else {
                    rect = null;
                }
                ge.x = rect;
            }
            arrayList.add(new C0485Sb(ge, menuC3948nE, this.q));
            ge.show();
            C3219dm c3219dm3 = ge.c;
            c3219dm3.setOnKeyListener(this);
            if (c0485Sb != null && this.w && menuC3948nE.m != null) {
                FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c3219dm3, false);
                TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
                frameLayout.setEnabled(false);
                textView.setText(menuC3948nE.m);
                c3219dm3.addHeaderView(frameLayout, null, false);
                ge.show();
                return;
            }
            return;
        }
        c0485Sb = null;
        view = null;
        if (view == null) {
        }
        arrayList.add(new C0485Sb(ge, menuC3948nE, this.q));
        ge.show();
        C3219dm c3219dm32 = ge.c;
        c3219dm32.setOnKeyListener(this);
        if (c0485Sb != null) {
        }
    }
}
