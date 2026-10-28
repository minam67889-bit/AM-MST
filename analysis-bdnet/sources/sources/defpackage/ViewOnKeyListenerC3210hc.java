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
import dastan.prince.bdfreevpn.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: hc, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnKeyListenerC3210hc extends AbstractC3899qF implements View.OnKeyListener, PopupWindow.OnDismissListener {
    public final Context b;
    public final int c;
    public final int d;
    public final boolean e;
    public final Handler f;
    public View n;
    public View o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;
    public int t;
    public boolean v;
    public InterfaceC4451xF w;
    public ViewTreeObserver x;
    public C3977rF y;
    public boolean z;
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();
    public final ViewTreeObserverOnGlobalLayoutListenerC4594z5 i = new ViewTreeObserverOnGlobalLayoutListenerC4594z5(this, 2);
    public final ViewOnAttachStateChangeListenerC2970ec j = new ViewOnAttachStateChangeListenerC2970ec(this, 0);
    public final C0136Ew k = new C0136Ew(this, 6);
    public int l = 0;
    public int m = 0;
    public boolean u = false;

    public ViewOnKeyListenerC3210hc(Context context, View view, int i, boolean z) {
        this.b = context;
        this.n = view;
        this.d = i;
        this.e = z;
        this.p = view.getLayoutDirection() != 1 ? 1 : 0;
        Resources resources = context.getResources();
        this.c = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(R.dimen.abc_config_prefDialogWidth));
        this.f = new Handler();
    }

    @Override // defpackage.InterfaceC3597mT
    public final boolean a() {
        ArrayList arrayList = this.h;
        return arrayList.size() > 0 && ((C3130gc) arrayList.get(0)).a.z.isShowing();
    }

    @Override // defpackage.InterfaceC4530yF
    public final void b(MenuC2945eF menuC2945eF, boolean z) {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (menuC2945eF == ((C3130gc) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return;
        }
        int i2 = i + 1;
        if (i2 < arrayList.size()) {
            ((C3130gc) arrayList.get(i2)).b.c(false);
        }
        C3130gc c3130gc = (C3130gc) arrayList.remove(i);
        c3130gc.b.r(this);
        boolean z2 = this.z;
        C4372wF c4372wF = c3130gc.a;
        if (z2) {
            AbstractC4135tF.b(c4372wF.z, null);
            c4372wF.z.setAnimationStyle(0);
        }
        c4372wF.dismiss();
        int size2 = arrayList.size();
        if (size2 > 0) {
            this.p = ((C3130gc) arrayList.get(size2 - 1)).c;
        } else {
            this.p = this.n.getLayoutDirection() == 1 ? 0 : 1;
        }
        if (size2 != 0) {
            if (z) {
                ((C3130gc) arrayList.get(0)).b.c(false);
                return;
            }
            return;
        }
        dismiss();
        InterfaceC4451xF interfaceC4451xF = this.w;
        if (interfaceC4451xF != null) {
            interfaceC4451xF.b(menuC2945eF, true);
        }
        ViewTreeObserver viewTreeObserver = this.x;
        if (viewTreeObserver != null) {
            if (viewTreeObserver.isAlive()) {
                this.x.removeGlobalOnLayoutListener(this.i);
            }
            this.x = null;
        }
        this.o.removeOnAttachStateChangeListener(this.j);
        this.y.onDismiss();
    }

    @Override // defpackage.InterfaceC4530yF
    public final void d(InterfaceC4451xF interfaceC4451xF) {
        this.w = interfaceC4451xF;
    }

    @Override // defpackage.InterfaceC3597mT
    public final void dismiss() {
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        if (size > 0) {
            C3130gc[] c3130gcArr = (C3130gc[]) arrayList.toArray(new C3130gc[size]);
            for (int i = size - 1; i >= 0; i--) {
                C3130gc c3130gc = c3130gcArr[i];
                if (c3130gc.a.z.isShowing()) {
                    c3130gc.a.dismiss();
                }
            }
        }
    }

    @Override // defpackage.InterfaceC4530yF
    public final void f() {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            ListAdapter adapter = ((C3130gc) it.next()).a.c.getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((C0791bF) adapter).notifyDataSetChanged();
        }
    }

    @Override // defpackage.InterfaceC3597mT
    public final C3304im g() {
        ArrayList arrayList = this.h;
        if (arrayList.isEmpty()) {
            return null;
        }
        return ((C3130gc) arrayList.get(arrayList.size() - 1)).a.c;
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean i(SubMenuC4625zV subMenuC4625zV) {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            C3130gc c3130gc = (C3130gc) it.next();
            if (subMenuC4625zV == c3130gc.b) {
                c3130gc.a.c.requestFocus();
                return true;
            }
        }
        if (!subMenuC4625zV.hasVisibleItems()) {
            return false;
        }
        k(subMenuC4625zV);
        InterfaceC4451xF interfaceC4451xF = this.w;
        if (interfaceC4451xF != null) {
            interfaceC4451xF.k(subMenuC4625zV);
        }
        return true;
    }

    @Override // defpackage.InterfaceC4530yF
    public final boolean j() {
        return false;
    }

    @Override // defpackage.AbstractC3899qF
    public final void k(MenuC2945eF menuC2945eF) {
        menuC2945eF.b(this, this.b);
        if (a()) {
            u(menuC2945eF);
        } else {
            this.g.add(menuC2945eF);
        }
    }

    @Override // defpackage.AbstractC3899qF
    public final void m(View view) {
        if (this.n != view) {
            this.n = view;
            this.m = Gravity.getAbsoluteGravity(this.l, view.getLayoutDirection());
        }
    }

    @Override // defpackage.AbstractC3899qF
    public final void n(boolean z) {
        this.u = z;
    }

    @Override // defpackage.AbstractC3899qF
    public final void o(int i) {
        if (this.l != i) {
            this.l = i;
            this.m = Gravity.getAbsoluteGravity(i, this.n.getLayoutDirection());
        }
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public final void onDismiss() {
        C3130gc c3130gc;
        ArrayList arrayList = this.h;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                c3130gc = null;
                break;
            }
            c3130gc = (C3130gc) arrayList.get(i);
            if (!c3130gc.a.z.isShowing()) {
                break;
            } else {
                i++;
            }
        }
        if (c3130gc != null) {
            c3130gc.b.c(false);
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
        this.q = true;
        this.s = i;
    }

    @Override // defpackage.AbstractC3899qF
    public final void q(PopupWindow.OnDismissListener onDismissListener) {
        this.y = (C3977rF) onDismissListener;
    }

    @Override // defpackage.AbstractC3899qF
    public final void r(boolean z) {
        this.v = z;
    }

    @Override // defpackage.AbstractC3899qF
    public final void s(int i) {
        this.r = true;
        this.t = i;
    }

    @Override // defpackage.InterfaceC3597mT
    public final void show() {
        if (a()) {
            return;
        }
        ArrayList arrayList = this.g;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            u((MenuC2945eF) it.next());
        }
        arrayList.clear();
        View view = this.n;
        this.o = view;
        if (view != null) {
            boolean z = this.x == null;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            this.x = viewTreeObserver;
            if (z) {
                viewTreeObserver.addOnGlobalLayoutListener(this.i);
            }
            this.o.addOnAttachStateChangeListener(this.j);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0146, code lost:
    
        if (((r8.getWidth() + r11[0]) + r5) > r9.right) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0148, code lost:
    
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x014b, code lost:
    
        r8 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0150, code lost:
    
        if ((r11[0] - r5) < 0) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u(MenuC2945eF menuC2945eF) {
        int i;
        C3130gc c3130gc;
        View view;
        int i2;
        int i3;
        int i4;
        int width;
        MenuItem menuItem;
        C0791bF c0791bF;
        int i5;
        int firstVisiblePosition;
        Context context = this.b;
        LayoutInflater from = LayoutInflater.from(context);
        C0791bF c0791bF2 = new C0791bF(menuC2945eF, from, this.e, R.layout.abc_cascading_menu_item_layout);
        if (!a() && this.u) {
            c0791bF2.c = true;
        } else if (a()) {
            c0791bF2.c = AbstractC3899qF.t(menuC2945eF);
        }
        int l = AbstractC3899qF.l(c0791bF2, context, this.c);
        C4372wF c4372wF = new C4372wF(context, null, this.d);
        c4372wF.C = this.k;
        c4372wF.p = this;
        c4372wF.z.setOnDismissListener(this);
        c4372wF.o = this.n;
        c4372wF.l = this.m;
        c4372wF.y = true;
        c4372wF.z.setFocusable(true);
        c4372wF.z.setInputMethodMode(2);
        c4372wF.o(c0791bF2);
        c4372wF.q(l);
        c4372wF.l = this.m;
        ArrayList arrayList = this.h;
        if (arrayList.size() > 0) {
            c3130gc = (C3130gc) arrayList.get(arrayList.size() - 1);
            MenuC2945eF menuC2945eF2 = c3130gc.b;
            int size = menuC2945eF2.f.size();
            int i6 = 0;
            while (true) {
                if (i6 >= size) {
                    menuItem = null;
                    break;
                }
                menuItem = menuC2945eF2.getItem(i6);
                if (menuItem.hasSubMenu() && menuC2945eF == menuItem.getSubMenu()) {
                    break;
                } else {
                    i6++;
                }
            }
            if (menuItem == null) {
                i = 1;
                view = null;
            } else {
                C3304im c3304im = c3130gc.a.c;
                ListAdapter adapter = c3304im.getAdapter();
                if (adapter instanceof HeaderViewListAdapter) {
                    HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                    i5 = headerViewListAdapter.getHeadersCount();
                    c0791bF = (C0791bF) headerViewListAdapter.getWrappedAdapter();
                } else {
                    c0791bF = (C0791bF) adapter;
                    i5 = 0;
                }
                int count = c0791bF.getCount();
                i = 1;
                int i7 = 0;
                while (true) {
                    if (i7 >= count) {
                        i7 = -1;
                        break;
                    } else if (menuItem == c0791bF.getItem(i7)) {
                        break;
                    } else {
                        i7++;
                    }
                }
                if (i7 != -1 && (firstVisiblePosition = (i7 + i5) - c3304im.getFirstVisiblePosition()) >= 0 && firstVisiblePosition < c3304im.getChildCount()) {
                    view = c3304im.getChildAt(firstVisiblePosition);
                }
            }
            if (view == null) {
                int i8 = Build.VERSION.SDK_INT;
                C4041s5 c4041s5 = c4372wF.z;
                if (i8 <= 28) {
                    Method method = C4372wF.D;
                    if (method != null) {
                        try {
                            method.invoke(c4041s5, Boolean.FALSE);
                        } catch (Exception unused) {
                            Log.i("MenuPopupWindow", "Could not invoke setTouchModal() on PopupWindow. Oh well.");
                        }
                    }
                } else {
                    AbstractC4214uF.a(c4041s5, false);
                }
                AbstractC4135tF.a(c4372wF.z, null);
                C3304im c3304im2 = ((C3130gc) arrayList.get(arrayList.size() - 1)).a.c;
                int[] iArr = new int[2];
                c3304im2.getLocationOnScreen(iArr);
                Rect rect = new Rect();
                this.o.getWindowVisibleDisplayFrame(rect);
                if (this.p == i) {
                }
                boolean z = i2 == 1;
                this.p = i2;
                if (Build.VERSION.SDK_INT >= 26) {
                    c4372wF.o = view;
                    i4 = 0;
                    i3 = 0;
                } else {
                    int[] iArr2 = new int[2];
                    this.n.getLocationOnScreen(iArr2);
                    int[] iArr3 = new int[2];
                    view.getLocationOnScreen(iArr3);
                    if ((this.m & 7) == 5) {
                        iArr2[0] = this.n.getWidth() + iArr2[0];
                        iArr3[0] = view.getWidth() + iArr3[0];
                    }
                    i3 = iArr3[0] - iArr2[0];
                    i4 = iArr3[1] - iArr2[1];
                }
                if ((this.m & 5) != 5) {
                    if (z) {
                        width = i3 + view.getWidth();
                        c4372wF.f = width;
                        c4372wF.k = true;
                        c4372wF.j = true;
                        c4372wF.f(i4);
                    }
                    width = i3 - l;
                    c4372wF.f = width;
                    c4372wF.k = true;
                    c4372wF.j = true;
                    c4372wF.f(i4);
                } else if (z) {
                    width = i3 + l;
                    c4372wF.f = width;
                    c4372wF.k = true;
                    c4372wF.j = true;
                    c4372wF.f(i4);
                } else {
                    l = view.getWidth();
                    width = i3 - l;
                    c4372wF.f = width;
                    c4372wF.k = true;
                    c4372wF.j = true;
                    c4372wF.f(i4);
                }
            } else {
                if (this.q) {
                    c4372wF.f = this.s;
                }
                if (this.r) {
                    c4372wF.f(this.t);
                }
                Rect rect2 = this.a;
                c4372wF.x = rect2 != null ? new Rect(rect2) : null;
            }
            arrayList.add(new C3130gc(c4372wF, menuC2945eF, this.p));
            c4372wF.show();
            C3304im c3304im3 = c4372wF.c;
            c3304im3.setOnKeyListener(this);
            if (c3130gc == null || !this.v || menuC2945eF.m == null) {
                return;
            }
            FrameLayout frameLayout = (FrameLayout) from.inflate(R.layout.abc_popup_menu_header_item_layout, (ViewGroup) c3304im3, false);
            TextView textView = (TextView) frameLayout.findViewById(android.R.id.title);
            frameLayout.setEnabled(false);
            textView.setText(menuC2945eF.m);
            c3304im3.addHeaderView(frameLayout, null, false);
            c4372wF.show();
            return;
        }
        i = 1;
        c3130gc = null;
        view = null;
        if (view == null) {
        }
        arrayList.add(new C3130gc(c4372wF, menuC2945eF, this.p));
        c4372wF.show();
        C3304im c3304im32 = c4372wF.c;
        c3304im32.setOnKeyListener(this);
        if (c3130gc == null) {
        }
    }
}
