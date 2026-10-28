package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3680nX;
import defpackage.C2912dt;
import defpackage.C3343jF;
import defpackage.C3480l1;
import defpackage.C3503lF;
import defpackage.C3726o5;
import defpackage.C3759oX;
import defpackage.C3838pX;
import defpackage.C3884q5;
import defpackage.C3995rX;
import defpackage.C4232uX;
import defpackage.C4452xG;
import defpackage.G20;
import defpackage.GM;
import defpackage.InterfaceC0590Wj;
import defpackage.InterfaceC3105gF;
import defpackage.InterfaceC3917qX;
import defpackage.InterfaceC4609zF;
import defpackage.MP;
import defpackage.MV;
import defpackage.MenuC2945eF;
import defpackage.QO;
import defpackage.RunnableC3601mX;
import defpackage.S50;
import defpackage.S7;
import defpackage.T5;
import defpackage.TO;
import defpackage.ViewOnClickListenerC2840d;
import defpackage.ViewOnClickListenerC4074sX;
import defpackage.XE;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class Toolbar extends ViewGroup implements InterfaceC3105gF {
    public ColorStateList A;
    public boolean B;
    public boolean C;
    public final ArrayList D;
    public final ArrayList E;
    public final int[] F;
    public final C3343jF G;
    public ArrayList H;
    public final QO I;
    public C4232uX J;
    public C3480l1 K;
    public C3759oX L;
    public boolean M;
    public OnBackInvokedCallback N;
    public OnBackInvokedDispatcher O;
    public boolean P;
    public final S7 Q;
    public ActionMenuView a;
    public T5 b;
    public T5 c;
    public C3726o5 d;
    public C3884q5 e;
    public final Drawable f;
    public final CharSequence g;
    public C3726o5 h;
    public View i;
    public Context j;
    public int k;
    public int l;
    public int m;
    public final int n;
    public final int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public MP t;
    public int u;
    public int v;
    public final int w;
    public CharSequence x;
    public CharSequence y;
    public ColorStateList z;

    public Toolbar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private ArrayList<MenuItem> getCurrentMenuItems() {
        ArrayList<MenuItem> arrayList = new ArrayList<>();
        Menu menu = getMenu();
        for (int i = 0; i < menu.size(); i++) {
            arrayList.add(menu.getItem(i));
        }
        return arrayList;
    }

    private MenuInflater getMenuInflater() {
        return new MV(getContext());
    }

    public static C3838pX h() {
        C3838pX c3838pX = new C3838pX(-2, -2);
        c3838pX.b = 0;
        c3838pX.a = 8388627;
        return c3838pX;
    }

    public static C3838pX i(ViewGroup.LayoutParams layoutParams) {
        boolean z = layoutParams instanceof C3838pX;
        if (z) {
            C3838pX c3838pX = (C3838pX) layoutParams;
            C3838pX c3838pX2 = new C3838pX(c3838pX);
            c3838pX2.b = 0;
            c3838pX2.b = c3838pX.b;
            return c3838pX2;
        }
        if (z) {
            C3838pX c3838pX3 = new C3838pX((C3838pX) layoutParams);
            c3838pX3.b = 0;
            return c3838pX3;
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            C3838pX c3838pX4 = new C3838pX(layoutParams);
            c3838pX4.b = 0;
            return c3838pX4;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        C3838pX c3838pX5 = new C3838pX(marginLayoutParams);
        c3838pX5.b = 0;
        ((ViewGroup.MarginLayoutParams) c3838pX5).leftMargin = marginLayoutParams.leftMargin;
        ((ViewGroup.MarginLayoutParams) c3838pX5).topMargin = marginLayoutParams.topMargin;
        ((ViewGroup.MarginLayoutParams) c3838pX5).rightMargin = marginLayoutParams.rightMargin;
        ((ViewGroup.MarginLayoutParams) c3838pX5).bottomMargin = marginLayoutParams.bottomMargin;
        return c3838pX5;
    }

    public static int k(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.getMarginEnd() + marginLayoutParams.getMarginStart();
    }

    public static int l(View view) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        return marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
    }

    public final void a(int i, ArrayList arrayList) {
        boolean z = getLayoutDirection() == 1;
        int childCount = getChildCount();
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection());
        arrayList.clear();
        if (!z) {
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                C3838pX c3838pX = (C3838pX) childAt.getLayoutParams();
                if (c3838pX.b == 0 && s(childAt)) {
                    int i3 = c3838pX.a;
                    int layoutDirection = getLayoutDirection();
                    int absoluteGravity2 = Gravity.getAbsoluteGravity(i3, layoutDirection) & 7;
                    if (absoluteGravity2 != 1 && absoluteGravity2 != 3 && absoluteGravity2 != 5) {
                        absoluteGravity2 = layoutDirection == 1 ? 5 : 3;
                    }
                    if (absoluteGravity2 == absoluteGravity) {
                        arrayList.add(childAt);
                    }
                }
            }
            return;
        }
        for (int i4 = childCount - 1; i4 >= 0; i4--) {
            View childAt2 = getChildAt(i4);
            C3838pX c3838pX2 = (C3838pX) childAt2.getLayoutParams();
            if (c3838pX2.b == 0 && s(childAt2)) {
                int i5 = c3838pX2.a;
                int layoutDirection2 = getLayoutDirection();
                int absoluteGravity3 = Gravity.getAbsoluteGravity(i5, layoutDirection2) & 7;
                if (absoluteGravity3 != 1 && absoluteGravity3 != 3 && absoluteGravity3 != 5) {
                    absoluteGravity3 = layoutDirection2 == 1 ? 5 : 3;
                }
                if (absoluteGravity3 == absoluteGravity) {
                    arrayList.add(childAt2);
                }
            }
        }
    }

    @Override // defpackage.InterfaceC3105gF
    public final void addMenuProvider(InterfaceC4609zF interfaceC4609zF) {
        C3343jF c3343jF = this.G;
        c3343jF.b.add(interfaceC4609zF);
        c3343jF.a.run();
    }

    public final void b(View view, boolean z) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        C3838pX h = layoutParams == null ? h() : !checkLayoutParams(layoutParams) ? i(layoutParams) : (C3838pX) layoutParams;
        h.b = 1;
        if (!z || this.i == null) {
            addView(view, h);
        } else {
            view.setLayoutParams(h);
            this.E.add(view);
        }
    }

    public final void c() {
        if (this.h == null) {
            C3726o5 c3726o5 = new C3726o5(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            this.h = c3726o5;
            c3726o5.setImageDrawable(this.f);
            this.h.setContentDescription(this.g);
            C3838pX h = h();
            h.a = (this.n & 112) | 8388611;
            h.b = 2;
            this.h.setLayoutParams(h);
            this.h.setOnClickListener(new ViewOnClickListenerC2840d(this, 9));
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof C3838pX);
    }

    public final void d() {
        if (this.t == null) {
            MP mp = new MP();
            mp.a = 0;
            mp.b = 0;
            mp.c = Integer.MIN_VALUE;
            mp.d = Integer.MIN_VALUE;
            mp.e = 0;
            mp.f = 0;
            mp.g = false;
            mp.h = false;
            this.t = mp;
        }
    }

    public final void e() {
        f();
        ActionMenuView actionMenuView = this.a;
        if (actionMenuView.p == null) {
            MenuC2945eF menuC2945eF = (MenuC2945eF) actionMenuView.getMenu();
            if (this.L == null) {
                this.L = new C3759oX(this);
            }
            this.a.setExpandedActionViewsExclusive(true);
            menuC2945eF.b(this.L, this.j);
            t();
        }
    }

    public final void f() {
        if (this.a == null) {
            ActionMenuView actionMenuView = new ActionMenuView(getContext(), null);
            this.a = actionMenuView;
            actionMenuView.setPopupTheme(this.k);
            this.a.setOnMenuItemClickListener(this.I);
            ActionMenuView actionMenuView2 = this.a;
            TO to = new TO(this, 6);
            actionMenuView2.getClass();
            actionMenuView2.u = to;
            C3838pX h = h();
            h.a = (this.n & 112) | 8388613;
            this.a.setLayoutParams(h);
            b(this.a, false);
        }
    }

    public final void g() {
        if (this.d == null) {
            this.d = new C3726o5(getContext(), null, R.attr.toolbarNavigationButtonStyle);
            C3838pX h = h();
            h.a = (this.n & 112) | 8388611;
            this.d.setLayoutParams(h);
        }
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return h();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return i(layoutParams);
    }

    public CharSequence getCollapseContentDescription() {
        C3726o5 c3726o5 = this.h;
        if (c3726o5 != null) {
            return c3726o5.getContentDescription();
        }
        return null;
    }

    public Drawable getCollapseIcon() {
        C3726o5 c3726o5 = this.h;
        if (c3726o5 != null) {
            return c3726o5.getDrawable();
        }
        return null;
    }

    public int getContentInsetEnd() {
        MP mp = this.t;
        if (mp != null) {
            return mp.g ? mp.a : mp.b;
        }
        return 0;
    }

    public int getContentInsetEndWithActions() {
        int i = this.v;
        return i != Integer.MIN_VALUE ? i : getContentInsetEnd();
    }

    public int getContentInsetLeft() {
        MP mp = this.t;
        if (mp != null) {
            return mp.a;
        }
        return 0;
    }

    public int getContentInsetRight() {
        MP mp = this.t;
        if (mp != null) {
            return mp.b;
        }
        return 0;
    }

    public int getContentInsetStart() {
        MP mp = this.t;
        if (mp != null) {
            return mp.g ? mp.b : mp.a;
        }
        return 0;
    }

    public int getContentInsetStartWithNavigation() {
        int i = this.u;
        return i != Integer.MIN_VALUE ? i : getContentInsetStart();
    }

    public int getCurrentContentInsetEnd() {
        MenuC2945eF menuC2945eF;
        ActionMenuView actionMenuView = this.a;
        return (actionMenuView == null || (menuC2945eF = actionMenuView.p) == null || !menuC2945eF.hasVisibleItems()) ? getContentInsetEnd() : Math.max(getContentInsetEnd(), Math.max(this.v, 0));
    }

    public int getCurrentContentInsetLeft() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetEnd() : getCurrentContentInsetStart();
    }

    public int getCurrentContentInsetRight() {
        return getLayoutDirection() == 1 ? getCurrentContentInsetStart() : getCurrentContentInsetEnd();
    }

    public int getCurrentContentInsetStart() {
        return getNavigationIcon() != null ? Math.max(getContentInsetStart(), Math.max(this.u, 0)) : getContentInsetStart();
    }

    public Drawable getLogo() {
        C3884q5 c3884q5 = this.e;
        if (c3884q5 != null) {
            return c3884q5.getDrawable();
        }
        return null;
    }

    public CharSequence getLogoDescription() {
        C3884q5 c3884q5 = this.e;
        if (c3884q5 != null) {
            return c3884q5.getContentDescription();
        }
        return null;
    }

    public Menu getMenu() {
        e();
        return this.a.getMenu();
    }

    public View getNavButtonView() {
        return this.d;
    }

    public CharSequence getNavigationContentDescription() {
        C3726o5 c3726o5 = this.d;
        if (c3726o5 != null) {
            return c3726o5.getContentDescription();
        }
        return null;
    }

    public Drawable getNavigationIcon() {
        C3726o5 c3726o5 = this.d;
        if (c3726o5 != null) {
            return c3726o5.getDrawable();
        }
        return null;
    }

    public C3480l1 getOuterActionMenuPresenter() {
        return this.K;
    }

    public Drawable getOverflowIcon() {
        e();
        return this.a.getOverflowIcon();
    }

    public Context getPopupContext() {
        return this.j;
    }

    public int getPopupTheme() {
        return this.k;
    }

    public CharSequence getSubtitle() {
        return this.y;
    }

    public final TextView getSubtitleTextView() {
        return this.c;
    }

    public CharSequence getTitle() {
        return this.x;
    }

    public int getTitleMarginBottom() {
        return this.s;
    }

    public int getTitleMarginEnd() {
        return this.q;
    }

    public int getTitleMarginStart() {
        return this.p;
    }

    public int getTitleMarginTop() {
        return this.r;
    }

    public final TextView getTitleTextView() {
        return this.b;
    }

    public InterfaceC0590Wj getWrapper() {
        Drawable drawable;
        if (this.J == null) {
            C4232uX c4232uX = new C4232uX();
            c4232uX.n = 0;
            c4232uX.a = this;
            c4232uX.h = getTitle();
            c4232uX.i = getSubtitle();
            c4232uX.g = c4232uX.h != null;
            c4232uX.f = getNavigationIcon();
            C4452xG n = C4452xG.n(getContext(), null, GM.a, R.attr.actionBarStyle);
            c4232uX.o = n.i(15);
            TypedArray typedArray = (TypedArray) n.c;
            CharSequence text = typedArray.getText(27);
            if (!TextUtils.isEmpty(text)) {
                c4232uX.g = true;
                c4232uX.h = text;
                if ((c4232uX.b & 8) != 0) {
                    Toolbar toolbar = c4232uX.a;
                    toolbar.setTitle(text);
                    if (c4232uX.g) {
                        AbstractC2925e20.n(toolbar.getRootView(), text);
                    }
                }
            }
            CharSequence text2 = typedArray.getText(25);
            if (!TextUtils.isEmpty(text2)) {
                c4232uX.i = text2;
                if ((c4232uX.b & 8) != 0) {
                    setSubtitle(text2);
                }
            }
            Drawable i = n.i(20);
            if (i != null) {
                c4232uX.e = i;
                c4232uX.c();
            }
            Drawable i2 = n.i(17);
            if (i2 != null) {
                c4232uX.d = i2;
                c4232uX.c();
            }
            if (c4232uX.f == null && (drawable = c4232uX.o) != null) {
                c4232uX.f = drawable;
                int i3 = c4232uX.b & 4;
                Toolbar toolbar2 = c4232uX.a;
                if (i3 != 0) {
                    toolbar2.setNavigationIcon(drawable);
                } else {
                    toolbar2.setNavigationIcon((Drawable) null);
                }
            }
            c4232uX.a(typedArray.getInt(10, 0));
            int resourceId = typedArray.getResourceId(9, 0);
            if (resourceId != 0) {
                View inflate = LayoutInflater.from(getContext()).inflate(resourceId, (ViewGroup) this, false);
                View view = c4232uX.c;
                if (view != null && (c4232uX.b & 16) != 0) {
                    removeView(view);
                }
                c4232uX.c = inflate;
                if (inflate != null && (c4232uX.b & 16) != 0) {
                    addView(inflate);
                }
                c4232uX.a(c4232uX.b | 16);
            }
            int layoutDimension = typedArray.getLayoutDimension(13, 0);
            if (layoutDimension > 0) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                layoutParams.height = layoutDimension;
                setLayoutParams(layoutParams);
            }
            int dimensionPixelOffset = typedArray.getDimensionPixelOffset(7, -1);
            int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(3, -1);
            if (dimensionPixelOffset >= 0 || dimensionPixelOffset2 >= 0) {
                int max = Math.max(dimensionPixelOffset, 0);
                int max2 = Math.max(dimensionPixelOffset2, 0);
                d();
                this.t.a(max, max2);
            }
            int resourceId2 = typedArray.getResourceId(28, 0);
            if (resourceId2 != 0) {
                Context context = getContext();
                this.l = resourceId2;
                T5 t5 = this.b;
                if (t5 != null) {
                    t5.setTextAppearance(context, resourceId2);
                }
            }
            int resourceId3 = typedArray.getResourceId(26, 0);
            if (resourceId3 != 0) {
                Context context2 = getContext();
                this.m = resourceId3;
                T5 t52 = this.c;
                if (t52 != null) {
                    t52.setTextAppearance(context2, resourceId3);
                }
            }
            int resourceId4 = typedArray.getResourceId(22, 0);
            if (resourceId4 != 0) {
                setPopupTheme(resourceId4);
            }
            n.q();
            if (R.string.abc_action_bar_up_description != c4232uX.n) {
                c4232uX.n = R.string.abc_action_bar_up_description;
                if (TextUtils.isEmpty(getNavigationContentDescription())) {
                    int i4 = c4232uX.n;
                    c4232uX.j = i4 != 0 ? getContext().getString(i4) : null;
                    c4232uX.b();
                }
            }
            c4232uX.j = getNavigationContentDescription();
            setNavigationOnClickListener(new ViewOnClickListenerC4074sX(c4232uX));
            this.J = c4232uX;
        }
        return this.J;
    }

    public final int j(View view, int i) {
        C3838pX c3838pX = (C3838pX) view.getLayoutParams();
        int measuredHeight = view.getMeasuredHeight();
        int i2 = i > 0 ? (measuredHeight - i) / 2 : 0;
        int i3 = c3838pX.a & 112;
        if (i3 != 16 && i3 != 48 && i3 != 80) {
            i3 = this.w & 112;
        }
        if (i3 == 48) {
            return getPaddingTop() - i2;
        }
        if (i3 == 80) {
            return (((getHeight() - getPaddingBottom()) - measuredHeight) - ((ViewGroup.MarginLayoutParams) c3838pX).bottomMargin) - i2;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        int i4 = (((height - paddingTop) - paddingBottom) - measuredHeight) / 2;
        int i5 = ((ViewGroup.MarginLayoutParams) c3838pX).topMargin;
        if (i4 < i5) {
            i4 = i5;
        } else {
            int i6 = (((height - paddingBottom) - measuredHeight) - i4) - paddingTop;
            int i7 = ((ViewGroup.MarginLayoutParams) c3838pX).bottomMargin;
            if (i6 < i7) {
                i4 = Math.max(0, i4 - (i7 - i6));
            }
        }
        return paddingTop + i4;
    }

    public final void m() {
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            getMenu().removeItem(((MenuItem) it.next()).getItemId());
        }
        Menu menu = getMenu();
        ArrayList<MenuItem> currentMenuItems = getCurrentMenuItems();
        MenuInflater menuInflater = getMenuInflater();
        Iterator it2 = this.G.b.iterator();
        while (it2.hasNext()) {
            ((C2912dt) ((InterfaceC4609zF) it2.next())).a.j(menu, menuInflater);
        }
        ArrayList<MenuItem> currentMenuItems2 = getCurrentMenuItems();
        currentMenuItems2.removeAll(currentMenuItems);
        this.H = currentMenuItems2;
    }

    public final boolean n(View view) {
        return view.getParent() == this || this.E.contains(view);
    }

    public final int o(View view, int i, int i2, int[] iArr) {
        C3838pX c3838pX = (C3838pX) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c3838pX).leftMargin - iArr[0];
        int max = Math.max(0, i3) + i;
        iArr[0] = Math.max(0, -i3);
        int j = j(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max, j, max + measuredWidth, view.getMeasuredHeight() + j);
        return measuredWidth + ((ViewGroup.MarginLayoutParams) c3838pX).rightMargin + max;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.Q);
        t();
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.C = false;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0079  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x028f A[LOOP:0: B:39:0x028d->B:40:0x028f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x02a7 A[LOOP:1: B:43:0x02a5->B:44:0x02a7, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02c8 A[LOOP:2: B:47:0x02c6->B:48:0x02c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0318 A[LOOP:3: B:56:0x0316->B:57:0x0318, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0218  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int max;
        boolean s;
        boolean s2;
        boolean z2;
        int i7;
        int i8;
        int paddingTop;
        int i9;
        int i10;
        int i11;
        int i12;
        int size;
        int i13;
        int i14;
        int size2;
        int i15;
        int size3;
        int i16;
        int i17;
        int i18;
        int size4;
        boolean z3 = getLayoutDirection() == 1;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop2 = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i19 = width - paddingRight;
        int[] iArr = this.F;
        iArr[1] = 0;
        iArr[0] = 0;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int minimumHeight = getMinimumHeight();
        int min = minimumHeight >= 0 ? Math.min(minimumHeight, i4 - i2) : 0;
        if (!s(this.d)) {
            i5 = paddingLeft;
        } else {
            if (z3) {
                i6 = p(this.d, i19, min, iArr);
                i5 = paddingLeft;
                if (s(this.h)) {
                    if (z3) {
                        i6 = p(this.h, i6, min, iArr);
                    } else {
                        i5 = o(this.h, i5, min, iArr);
                    }
                }
                if (s(this.a)) {
                    if (z3) {
                        i5 = o(this.a, i5, min, iArr);
                    } else {
                        i6 = p(this.a, i6, min, iArr);
                    }
                }
                int currentContentInsetLeft = getCurrentContentInsetLeft();
                int currentContentInsetRight = getCurrentContentInsetRight();
                iArr[0] = Math.max(0, currentContentInsetLeft - i5);
                iArr[1] = Math.max(0, currentContentInsetRight - (i19 - i6));
                max = Math.max(i5, currentContentInsetLeft);
                int min2 = Math.min(i6, i19 - currentContentInsetRight);
                if (s(this.i)) {
                    if (z3) {
                        min2 = p(this.i, min2, min, iArr);
                    } else {
                        max = o(this.i, max, min, iArr);
                    }
                }
                if (s(this.e)) {
                    if (z3) {
                        min2 = p(this.e, min2, min, iArr);
                    } else {
                        max = o(this.e, max, min, iArr);
                    }
                }
                s = s(this.b);
                s2 = s(this.c);
                if (s) {
                    z2 = z3;
                    i7 = 0;
                } else {
                    C3838pX c3838pX = (C3838pX) this.b.getLayoutParams();
                    z2 = z3;
                    i7 = this.b.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c3838pX).topMargin + ((ViewGroup.MarginLayoutParams) c3838pX).bottomMargin;
                }
                if (!s2) {
                    C3838pX c3838pX2 = (C3838pX) this.c.getLayoutParams();
                    i7 = this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c3838pX2).topMargin + ((ViewGroup.MarginLayoutParams) c3838pX2).bottomMargin + i7;
                }
                if (!s || s2) {
                    T5 t5 = !s ? this.b : this.c;
                    T5 t52 = !s2 ? this.c : this.b;
                    C3838pX c3838pX3 = (C3838pX) t5.getLayoutParams();
                    C3838pX c3838pX4 = (C3838pX) t52.getLayoutParams();
                    int i20 = i7;
                    boolean z4 = (!s && this.b.getMeasuredWidth() > 0) || (s2 && this.c.getMeasuredWidth() > 0);
                    i8 = this.w & 112;
                    int i21 = max;
                    if (i8 != 48) {
                        paddingTop = getPaddingTop() + ((ViewGroup.MarginLayoutParams) c3838pX3).topMargin + this.r;
                    } else if (i8 != 80) {
                        int i22 = (((height - paddingTop2) - paddingBottom) - i20) / 2;
                        int i23 = ((ViewGroup.MarginLayoutParams) c3838pX3).topMargin + this.r;
                        if (i22 < i23) {
                            i22 = i23;
                        } else {
                            int i24 = (((height - paddingBottom) - i20) - i22) - paddingTop2;
                            int i25 = ((ViewGroup.MarginLayoutParams) c3838pX3).bottomMargin;
                            int i26 = this.s;
                            if (i24 < i25 + i26) {
                                i22 = Math.max(0, i22 - ((((ViewGroup.MarginLayoutParams) c3838pX4).bottomMargin + i26) - i24));
                            }
                        }
                        paddingTop = paddingTop2 + i22;
                    } else {
                        paddingTop = (((height - paddingBottom) - ((ViewGroup.MarginLayoutParams) c3838pX4).bottomMargin) - this.s) - i20;
                    }
                    if (z2) {
                        int i27 = (z4 ? this.p : 0) - iArr[0];
                        max = Math.max(0, i27) + i21;
                        iArr[0] = Math.max(0, -i27);
                        if (s) {
                            C3838pX c3838pX5 = (C3838pX) this.b.getLayoutParams();
                            int measuredWidth = this.b.getMeasuredWidth() + max;
                            int measuredHeight = this.b.getMeasuredHeight() + paddingTop;
                            this.b.layout(max, paddingTop, measuredWidth, measuredHeight);
                            i9 = measuredWidth + this.q;
                            paddingTop = measuredHeight + ((ViewGroup.MarginLayoutParams) c3838pX5).bottomMargin;
                        } else {
                            i9 = max;
                        }
                        if (s2) {
                            int i28 = paddingTop + ((ViewGroup.MarginLayoutParams) ((C3838pX) this.c.getLayoutParams())).topMargin;
                            int measuredWidth2 = this.c.getMeasuredWidth() + max;
                            this.c.layout(max, i28, measuredWidth2, this.c.getMeasuredHeight() + i28);
                            i10 = measuredWidth2 + this.q;
                        } else {
                            i10 = max;
                        }
                        if (z4) {
                            max = Math.max(i9, i10);
                        }
                    } else {
                        int i29 = (z4 ? this.p : 0) - iArr[1];
                        min2 -= Math.max(0, i29);
                        iArr[1] = Math.max(0, -i29);
                        if (s) {
                            C3838pX c3838pX6 = (C3838pX) this.b.getLayoutParams();
                            int measuredWidth3 = min2 - this.b.getMeasuredWidth();
                            int measuredHeight2 = this.b.getMeasuredHeight() + paddingTop;
                            this.b.layout(measuredWidth3, paddingTop, min2, measuredHeight2);
                            i11 = measuredWidth3 - this.q;
                            paddingTop = measuredHeight2 + ((ViewGroup.MarginLayoutParams) c3838pX6).bottomMargin;
                        } else {
                            i11 = min2;
                        }
                        if (s2) {
                            int i30 = paddingTop + ((ViewGroup.MarginLayoutParams) ((C3838pX) this.c.getLayoutParams())).topMargin;
                            this.c.layout(min2 - this.c.getMeasuredWidth(), i30, min2, this.c.getMeasuredHeight() + i30);
                            i12 = min2 - this.q;
                        } else {
                            i12 = min2;
                        }
                        if (z4) {
                            min2 = Math.min(i11, i12);
                        }
                        max = i21;
                    }
                }
                ArrayList arrayList = this.D;
                a(3, arrayList);
                size = arrayList.size();
                i13 = max;
                for (i14 = 0; i14 < size; i14++) {
                    i13 = o((View) arrayList.get(i14), i13, min, iArr);
                }
                a(5, arrayList);
                size2 = arrayList.size();
                for (i15 = 0; i15 < size2; i15++) {
                    min2 = p((View) arrayList.get(i15), min2, min, iArr);
                }
                a(1, arrayList);
                int i31 = iArr[0];
                int i32 = iArr[1];
                size3 = arrayList.size();
                int i33 = i32;
                int i34 = i31;
                i16 = 0;
                int i35 = 0;
                while (i16 < size3) {
                    View view = (View) arrayList.get(i16);
                    C3838pX c3838pX7 = (C3838pX) view.getLayoutParams();
                    int i36 = i16;
                    int i37 = ((ViewGroup.MarginLayoutParams) c3838pX7).leftMargin - i34;
                    int i38 = ((ViewGroup.MarginLayoutParams) c3838pX7).rightMargin - i33;
                    int max2 = Math.max(0, i37);
                    int max3 = Math.max(0, i38);
                    int max4 = Math.max(0, -i37);
                    int max5 = Math.max(0, -i38);
                    i35 += view.getMeasuredWidth() + max2 + max3;
                    i33 = max5;
                    i34 = max4;
                    i16 = i36 + 1;
                }
                i18 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i35 / 2);
                int i39 = i35 + i18;
                if (i18 >= i13) {
                    i13 = i39 > min2 ? i18 - (i39 - min2) : i18;
                }
                size4 = arrayList.size();
                for (i17 = 0; i17 < size4; i17++) {
                    i13 = o((View) arrayList.get(i17), i13, min, iArr);
                }
                arrayList.clear();
            }
            i5 = o(this.d, paddingLeft, min, iArr);
        }
        i6 = i19;
        if (s(this.h)) {
        }
        if (s(this.a)) {
        }
        int currentContentInsetLeft2 = getCurrentContentInsetLeft();
        int currentContentInsetRight2 = getCurrentContentInsetRight();
        iArr[0] = Math.max(0, currentContentInsetLeft2 - i5);
        iArr[1] = Math.max(0, currentContentInsetRight2 - (i19 - i6));
        max = Math.max(i5, currentContentInsetLeft2);
        int min22 = Math.min(i6, i19 - currentContentInsetRight2);
        if (s(this.i)) {
        }
        if (s(this.e)) {
        }
        s = s(this.b);
        s2 = s(this.c);
        if (s) {
        }
        if (!s2) {
        }
        if (!s) {
        }
        if (!s) {
        }
        if (!s2) {
        }
        C3838pX c3838pX32 = (C3838pX) t5.getLayoutParams();
        C3838pX c3838pX42 = (C3838pX) t52.getLayoutParams();
        int i202 = i7;
        if (s) {
        }
        i8 = this.w & 112;
        int i212 = max;
        if (i8 != 48) {
        }
        if (z2) {
        }
        ArrayList arrayList2 = this.D;
        a(3, arrayList2);
        size = arrayList2.size();
        i13 = max;
        while (i14 < size) {
        }
        a(5, arrayList2);
        size2 = arrayList2.size();
        while (i15 < size2) {
        }
        a(1, arrayList2);
        int i312 = iArr[0];
        int i322 = iArr[1];
        size3 = arrayList2.size();
        int i332 = i322;
        int i342 = i312;
        i16 = 0;
        int i352 = 0;
        while (i16 < size3) {
        }
        i18 = ((((width - paddingLeft) - paddingRight) / 2) + paddingLeft) - (i352 / 2);
        int i392 = i352 + i18;
        if (i18 >= i13) {
        }
        size4 = arrayList2.size();
        while (i17 < size4) {
        }
        arrayList2.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        char c;
        Object[] objArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z = G20.a;
        int i10 = 0;
        if (getLayoutDirection() == 1) {
            objArr = true;
            c = 0;
        } else {
            c = 1;
            objArr = false;
        }
        if (s(this.d)) {
            r(this.d, i, 0, i2, this.o);
            i3 = k(this.d) + this.d.getMeasuredWidth();
            i4 = Math.max(0, l(this.d) + this.d.getMeasuredHeight());
            i5 = View.combineMeasuredStates(0, this.d.getMeasuredState());
        } else {
            i3 = 0;
            i4 = 0;
            i5 = 0;
        }
        if (s(this.h)) {
            r(this.h, i, 0, i2, this.o);
            i3 = k(this.h) + this.h.getMeasuredWidth();
            i4 = Math.max(i4, l(this.h) + this.h.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.h.getMeasuredState());
        }
        int currentContentInsetStart = getCurrentContentInsetStart();
        int max = Math.max(currentContentInsetStart, i3);
        int max2 = Math.max(0, currentContentInsetStart - i3);
        Object[] objArr2 = objArr;
        int[] iArr = this.F;
        iArr[objArr2 == true ? 1 : 0] = max2;
        if (s(this.a)) {
            r(this.a, i, max, i2, this.o);
            i6 = k(this.a) + this.a.getMeasuredWidth();
            i4 = Math.max(i4, l(this.a) + this.a.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.a.getMeasuredState());
        } else {
            i6 = 0;
        }
        int currentContentInsetEnd = getCurrentContentInsetEnd();
        int max3 = max + Math.max(currentContentInsetEnd, i6);
        iArr[c] = Math.max(0, currentContentInsetEnd - i6);
        if (s(this.i)) {
            max3 += q(this.i, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, l(this.i) + this.i.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.i.getMeasuredState());
        }
        if (s(this.e)) {
            max3 += q(this.e, i, max3, i2, 0, iArr);
            i4 = Math.max(i4, l(this.e) + this.e.getMeasuredHeight());
            i5 = View.combineMeasuredStates(i5, this.e.getMeasuredState());
        }
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (((C3838pX) childAt.getLayoutParams()).b == 0 && s(childAt)) {
                max3 += q(childAt, i, max3, i2, 0, iArr);
                int max4 = Math.max(i4, l(childAt) + childAt.getMeasuredHeight());
                i5 = View.combineMeasuredStates(i5, childAt.getMeasuredState());
                i4 = max4;
            } else {
                max3 = max3;
            }
        }
        int i12 = max3;
        int i13 = this.r + this.s;
        int i14 = this.p + this.q;
        if (s(this.b)) {
            q(this.b, i, i12 + i14, i2, i13, iArr);
            int k = k(this.b) + this.b.getMeasuredWidth();
            i7 = l(this.b) + this.b.getMeasuredHeight();
            i8 = View.combineMeasuredStates(i5, this.b.getMeasuredState());
            i9 = k;
        } else {
            i7 = 0;
            i8 = i5;
            i9 = 0;
        }
        if (s(this.c)) {
            i9 = Math.max(i9, q(this.c, i, i12 + i14, i2, i13 + i7, iArr));
            i7 += l(this.c) + this.c.getMeasuredHeight();
            i8 = View.combineMeasuredStates(i8, this.c.getMeasuredState());
        }
        int max5 = Math.max(i4, i7);
        int paddingRight = getPaddingRight() + getPaddingLeft() + i12 + i9;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + max5;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, (-16777216) & i8);
        int resolveSizeAndState2 = View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, i8 << 16);
        if (this.M) {
            int childCount2 = getChildCount();
            for (int i15 = 0; i15 < childCount2; i15++) {
                View childAt2 = getChildAt(i15);
                if (!s(childAt2) || childAt2.getMeasuredWidth() <= 0 || childAt2.getMeasuredHeight() <= 0) {
                }
            }
            setMeasuredDimension(resolveSizeAndState, i10);
        }
        i10 = resolveSizeAndState2;
        setMeasuredDimension(resolveSizeAndState, i10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        MenuItem findItem;
        if (!(parcelable instanceof C3995rX)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C3995rX c3995rX = (C3995rX) parcelable;
        super.onRestoreInstanceState(c3995rX.a);
        ActionMenuView actionMenuView = this.a;
        MenuC2945eF menuC2945eF = actionMenuView != null ? actionMenuView.p : null;
        int i = c3995rX.c;
        if (i != 0 && this.L != null && menuC2945eF != null && (findItem = menuC2945eF.findItem(i)) != null) {
            findItem.expandActionView();
        }
        if (c3995rX.d) {
            S7 s7 = this.Q;
            removeCallbacks(s7);
            post(s7);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        d();
        MP mp = this.t;
        boolean z = i == 1;
        if (z == mp.g) {
            return;
        }
        mp.g = z;
        if (!mp.h) {
            mp.a = mp.e;
            mp.b = mp.f;
            return;
        }
        if (z) {
            int i2 = mp.d;
            if (i2 == Integer.MIN_VALUE) {
                i2 = mp.e;
            }
            mp.a = i2;
            int i3 = mp.c;
            if (i3 == Integer.MIN_VALUE) {
                i3 = mp.f;
            }
            mp.b = i3;
            return;
        }
        int i4 = mp.c;
        if (i4 == Integer.MIN_VALUE) {
            i4 = mp.e;
        }
        mp.a = i4;
        int i5 = mp.d;
        if (i5 == Integer.MIN_VALUE) {
            i5 = mp.f;
        }
        mp.b = i5;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C3480l1 c3480l1;
        C3503lF c3503lF;
        C3995rX c3995rX = new C3995rX(super.onSaveInstanceState());
        C3759oX c3759oX = this.L;
        if (c3759oX != null && (c3503lF = c3759oX.b) != null) {
            c3995rX.c = c3503lF.a;
        }
        ActionMenuView actionMenuView = this.a;
        c3995rX.d = (actionMenuView == null || (c3480l1 = actionMenuView.t) == null || !c3480l1.k()) ? false : true;
        return c3995rX;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.B = false;
        return true;
    }

    public final int p(View view, int i, int i2, int[] iArr) {
        C3838pX c3838pX = (C3838pX) view.getLayoutParams();
        int i3 = ((ViewGroup.MarginLayoutParams) c3838pX).rightMargin - iArr[1];
        int max = i - Math.max(0, i3);
        iArr[1] = Math.max(0, -i3);
        int j = j(view, i2);
        int measuredWidth = view.getMeasuredWidth();
        view.layout(max - measuredWidth, j, max, view.getMeasuredHeight() + j);
        return max - (measuredWidth + ((ViewGroup.MarginLayoutParams) c3838pX).leftMargin);
    }

    public final int q(View view, int i, int i2, int i3, int i4, int[] iArr) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int i5 = marginLayoutParams.leftMargin - iArr[0];
        int i6 = marginLayoutParams.rightMargin - iArr[1];
        int max = Math.max(0, i6) + Math.max(0, i5);
        iArr[0] = Math.max(0, -i5);
        iArr[1] = Math.max(0, -i6);
        view.measure(ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + max + i2, marginLayoutParams.width), ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, marginLayoutParams.height));
        return view.getMeasuredWidth() + max;
    }

    public final void r(View view, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, getPaddingRight() + getPaddingLeft() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, marginLayoutParams.width);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, getPaddingBottom() + getPaddingTop() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, marginLayoutParams.height);
        int mode = View.MeasureSpec.getMode(childMeasureSpec2);
        if (mode != 1073741824 && i4 >= 0) {
            if (mode != 0) {
                i4 = Math.min(View.MeasureSpec.getSize(childMeasureSpec2), i4);
            }
            childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
        }
        view.measure(childMeasureSpec, childMeasureSpec2);
    }

    @Override // defpackage.InterfaceC3105gF
    public final void removeMenuProvider(InterfaceC4609zF interfaceC4609zF) {
        this.G.b(interfaceC4609zF);
    }

    public final boolean s(View view) {
        return (view == null || view.getParent() != this || view.getVisibility() == 8) ? false : true;
    }

    public void setBackInvokedCallbackEnabled(boolean z) {
        if (this.P != z) {
            this.P = z;
            t();
        }
    }

    public void setCollapseContentDescription(int i) {
        setCollapseContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setCollapseIcon(int i) {
        setCollapseIcon(XE.k(getContext(), i));
    }

    public void setCollapsible(boolean z) {
        this.M = z;
        requestLayout();
    }

    public void setContentInsetEndWithActions(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.v) {
            this.v = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setContentInsetStartWithNavigation(int i) {
        if (i < 0) {
            i = Integer.MIN_VALUE;
        }
        if (i != this.u) {
            this.u = i;
            if (getNavigationIcon() != null) {
                requestLayout();
            }
        }
    }

    public void setLogo(int i) {
        setLogo(XE.k(getContext(), i));
    }

    public void setLogoDescription(int i) {
        setLogoDescription(getContext().getText(i));
    }

    public void setNavigationContentDescription(int i) {
        setNavigationContentDescription(i != 0 ? getContext().getText(i) : null);
    }

    public void setNavigationIcon(int i) {
        setNavigationIcon(XE.k(getContext(), i));
    }

    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        g();
        this.d.setOnClickListener(onClickListener);
    }

    public void setOnMenuItemClickListener(InterfaceC3917qX interfaceC3917qX) {
    }

    public void setOverflowIcon(Drawable drawable) {
        e();
        this.a.setOverflowIcon(drawable);
    }

    public void setPopupTheme(int i) {
        if (this.k != i) {
            this.k = i;
            if (i == 0) {
                this.j = getContext();
            } else {
                this.j = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setSubtitle(int i) {
        setSubtitle(getContext().getText(i));
    }

    public void setSubtitleTextColor(int i) {
        setSubtitleTextColor(ColorStateList.valueOf(i));
    }

    public void setTitle(int i) {
        setTitle(getContext().getText(i));
    }

    public void setTitleMarginBottom(int i) {
        this.s = i;
        requestLayout();
    }

    public void setTitleMarginEnd(int i) {
        this.q = i;
        requestLayout();
    }

    public void setTitleMarginStart(int i) {
        this.p = i;
        requestLayout();
    }

    public void setTitleMarginTop(int i) {
        this.r = i;
        requestLayout();
    }

    public void setTitleTextColor(int i) {
        setTitleTextColor(ColorStateList.valueOf(i));
    }

    public final void t() {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher a = AbstractC3680nX.a(this);
            C3759oX c3759oX = this.L;
            boolean z = (c3759oX == null || c3759oX.b == null || a == null || !isAttachedToWindow() || !this.P) ? false : true;
            if (z && this.O == null) {
                if (this.N == null) {
                    this.N = AbstractC3680nX.b(new RunnableC3601mX(this, 0));
                }
                AbstractC3680nX.c(a, this.N);
                this.O = a;
                return;
            }
            if (z || (onBackInvokedDispatcher = this.O) == null) {
                return;
            }
            AbstractC3680nX.d(onBackInvokedDispatcher, this.N);
            this.O = null;
        }
    }

    public Toolbar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, R.attr.toolbarStyle);
        this.w = 8388627;
        this.D = new ArrayList();
        this.E = new ArrayList();
        this.F = new int[2];
        this.G = new C3343jF(new RunnableC3601mX(this, 1));
        this.H = new ArrayList();
        this.I = new QO((Object) this);
        this.Q = new S7(this, 23);
        Context context2 = getContext();
        int[] iArr = GM.x;
        C4452xG n = C4452xG.n(context2, attributeSet, iArr, R.attr.toolbarStyle);
        AbstractC2925e20.l(this, context, iArr, attributeSet, (TypedArray) n.c, R.attr.toolbarStyle);
        TypedArray typedArray = (TypedArray) n.c;
        this.l = typedArray.getResourceId(28, 0);
        this.m = typedArray.getResourceId(19, 0);
        this.w = typedArray.getInteger(0, 8388627);
        this.n = typedArray.getInteger(2, 48);
        int dimensionPixelOffset = typedArray.getDimensionPixelOffset(22, 0);
        dimensionPixelOffset = typedArray.hasValue(27) ? typedArray.getDimensionPixelOffset(27, dimensionPixelOffset) : dimensionPixelOffset;
        this.s = dimensionPixelOffset;
        this.r = dimensionPixelOffset;
        this.q = dimensionPixelOffset;
        this.p = dimensionPixelOffset;
        int dimensionPixelOffset2 = typedArray.getDimensionPixelOffset(25, -1);
        if (dimensionPixelOffset2 >= 0) {
            this.p = dimensionPixelOffset2;
        }
        int dimensionPixelOffset3 = typedArray.getDimensionPixelOffset(24, -1);
        if (dimensionPixelOffset3 >= 0) {
            this.q = dimensionPixelOffset3;
        }
        int dimensionPixelOffset4 = typedArray.getDimensionPixelOffset(26, -1);
        if (dimensionPixelOffset4 >= 0) {
            this.r = dimensionPixelOffset4;
        }
        int dimensionPixelOffset5 = typedArray.getDimensionPixelOffset(23, -1);
        if (dimensionPixelOffset5 >= 0) {
            this.s = dimensionPixelOffset5;
        }
        this.o = typedArray.getDimensionPixelSize(13, -1);
        int dimensionPixelOffset6 = typedArray.getDimensionPixelOffset(9, Integer.MIN_VALUE);
        int dimensionPixelOffset7 = typedArray.getDimensionPixelOffset(5, Integer.MIN_VALUE);
        int dimensionPixelSize = typedArray.getDimensionPixelSize(7, 0);
        int dimensionPixelSize2 = typedArray.getDimensionPixelSize(8, 0);
        d();
        MP mp = this.t;
        mp.h = false;
        if (dimensionPixelSize != Integer.MIN_VALUE) {
            mp.e = dimensionPixelSize;
            mp.a = dimensionPixelSize;
        }
        if (dimensionPixelSize2 != Integer.MIN_VALUE) {
            mp.f = dimensionPixelSize2;
            mp.b = dimensionPixelSize2;
        }
        if (dimensionPixelOffset6 != Integer.MIN_VALUE || dimensionPixelOffset7 != Integer.MIN_VALUE) {
            mp.a(dimensionPixelOffset6, dimensionPixelOffset7);
        }
        this.u = typedArray.getDimensionPixelOffset(10, Integer.MIN_VALUE);
        this.v = typedArray.getDimensionPixelOffset(6, Integer.MIN_VALUE);
        this.f = n.i(4);
        this.g = typedArray.getText(3);
        CharSequence text = typedArray.getText(21);
        if (!TextUtils.isEmpty(text)) {
            setTitle(text);
        }
        CharSequence text2 = typedArray.getText(18);
        if (!TextUtils.isEmpty(text2)) {
            setSubtitle(text2);
        }
        this.j = getContext();
        setPopupTheme(typedArray.getResourceId(17, 0));
        Drawable i2 = n.i(16);
        if (i2 != null) {
            setNavigationIcon(i2);
        }
        CharSequence text3 = typedArray.getText(15);
        if (!TextUtils.isEmpty(text3)) {
            setNavigationContentDescription(text3);
        }
        Drawable i3 = n.i(11);
        if (i3 != null) {
            setLogo(i3);
        }
        CharSequence text4 = typedArray.getText(12);
        if (!TextUtils.isEmpty(text4)) {
            setLogoDescription(text4);
        }
        if (typedArray.hasValue(29)) {
            setTitleTextColor(n.h(29));
        }
        if (typedArray.hasValue(20)) {
            setSubtitleTextColor(n.h(20));
        }
        if (typedArray.hasValue(14)) {
            getMenuInflater().inflate(typedArray.getResourceId(14, 0), getMenu());
        }
        n.q();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C3838pX c3838pX = new C3838pX(context, attributeSet);
        c3838pX.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, GM.b);
        c3838pX.a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        c3838pX.b = 0;
        return c3838pX;
    }

    public void setCollapseContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            c();
        }
        C3726o5 c3726o5 = this.h;
        if (c3726o5 != null) {
            c3726o5.setContentDescription(charSequence);
        }
    }

    public void setCollapseIcon(Drawable drawable) {
        if (drawable != null) {
            c();
            this.h.setImageDrawable(drawable);
        } else {
            C3726o5 c3726o5 = this.h;
            if (c3726o5 != null) {
                c3726o5.setImageDrawable(this.f);
            }
        }
    }

    public void setLogo(Drawable drawable) {
        if (drawable != null) {
            if (this.e == null) {
                this.e = new C3884q5(getContext(), null, 0);
            }
            if (!n(this.e)) {
                b(this.e, true);
            }
        } else {
            C3884q5 c3884q5 = this.e;
            if (c3884q5 != null && n(c3884q5)) {
                removeView(this.e);
                this.E.remove(this.e);
            }
        }
        C3884q5 c3884q52 = this.e;
        if (c3884q52 != null) {
            c3884q52.setImageDrawable(drawable);
        }
    }

    public void setLogoDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence) && this.e == null) {
            this.e = new C3884q5(getContext(), null, 0);
        }
        C3884q5 c3884q5 = this.e;
        if (c3884q5 != null) {
            c3884q5.setContentDescription(charSequence);
        }
    }

    public void setNavigationContentDescription(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            g();
        }
        C3726o5 c3726o5 = this.d;
        if (c3726o5 != null) {
            c3726o5.setContentDescription(charSequence);
            S50.F(this.d, charSequence);
        }
    }

    public void setNavigationIcon(Drawable drawable) {
        if (drawable != null) {
            g();
            if (!n(this.d)) {
                b(this.d, true);
            }
        } else {
            C3726o5 c3726o5 = this.d;
            if (c3726o5 != null && n(c3726o5)) {
                removeView(this.d);
                this.E.remove(this.d);
            }
        }
        C3726o5 c3726o52 = this.d;
        if (c3726o52 != null) {
            c3726o52.setImageDrawable(drawable);
        }
    }

    public void setSubtitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            T5 t5 = this.c;
            if (t5 != null && n(t5)) {
                removeView(this.c);
                this.E.remove(this.c);
            }
        } else {
            if (this.c == null) {
                Context context = getContext();
                T5 t52 = new T5(context, null);
                this.c = t52;
                t52.setSingleLine();
                this.c.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.m;
                if (i != 0) {
                    this.c.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.A;
                if (colorStateList != null) {
                    this.c.setTextColor(colorStateList);
                }
            }
            if (!n(this.c)) {
                b(this.c, true);
            }
        }
        T5 t53 = this.c;
        if (t53 != null) {
            t53.setText(charSequence);
        }
        this.y = charSequence;
    }

    public void setSubtitleTextColor(ColorStateList colorStateList) {
        this.A = colorStateList;
        T5 t5 = this.c;
        if (t5 != null) {
            t5.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            T5 t5 = this.b;
            if (t5 != null && n(t5)) {
                removeView(this.b);
                this.E.remove(this.b);
            }
        } else {
            if (this.b == null) {
                Context context = getContext();
                T5 t52 = new T5(context, null);
                this.b = t52;
                t52.setSingleLine();
                this.b.setEllipsize(TextUtils.TruncateAt.END);
                int i = this.l;
                if (i != 0) {
                    this.b.setTextAppearance(context, i);
                }
                ColorStateList colorStateList = this.z;
                if (colorStateList != null) {
                    this.b.setTextColor(colorStateList);
                }
            }
            if (!n(this.b)) {
                b(this.b, true);
            }
        }
        T5 t53 = this.b;
        if (t53 != null) {
            t53.setText(charSequence);
        }
        this.x = charSequence;
    }

    public void setTitleTextColor(ColorStateList colorStateList) {
        this.z = colorStateList;
        T5 t5 = this.b;
        if (t5 != null) {
            t5.setTextColor(colorStateList);
        }
    }
}
