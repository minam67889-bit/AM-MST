package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC2929e40;
import defpackage.C0688a1;
import defpackage.C0695a40;
import defpackage.C0768b1;
import defpackage.C0775b40;
import defpackage.C0854c40;
import defpackage.C2850d40;
import defpackage.C3480l1;
import defpackage.C3759oX;
import defpackage.C3804p40;
import defpackage.C3827pM;
import defpackage.C4119t40;
import defpackage.C4232uX;
import defpackage.C4431x20;
import defpackage.C4501xx;
import defpackage.InterfaceC0564Vj;
import defpackage.InterfaceC0590Wj;
import defpackage.InterfaceC4451xF;
import defpackage.LH;
import defpackage.MH;
import defpackage.MenuC2945eF;
import defpackage.P30;
import defpackage.W10;
import defpackage.X0;
import defpackage.X30;
import defpackage.XE;
import defpackage.Y0;
import defpackage.Y30;
import defpackage.Z0;
import defpackage.Z30;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ActionBarOverlayLayout extends ViewGroup implements InterfaceC0564Vj, LH, MH {
    public static final int[] C = {R.attr.actionBarSize, android.R.attr.windowContentOverlay};
    public static final C4119t40 D;
    public static final Rect E;
    public final C3827pM A;
    public final C0768b1 B;
    public int a;
    public int b;
    public ContentFrameLayout c;
    public ActionBarContainer d;
    public InterfaceC0590Wj e;
    public Drawable f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public final Rect m;
    public final Rect n;
    public final Rect o;
    public final Rect p;
    public C4119t40 q;
    public C4119t40 r;
    public C4119t40 s;
    public C4119t40 t;
    public Z0 u;
    public OverScroller v;
    public ViewPropertyAnimator w;
    public final X0 x;
    public final Y0 y;
    public final Y0 z;

    static {
        int i = Build.VERSION.SDK_INT;
        AbstractC2929e40 c2850d40 = i >= 36 ? new C2850d40() : i >= 35 ? new C0854c40() : i >= 34 ? new C0775b40() : i >= 31 ? new C0695a40() : i >= 30 ? new Z30() : i >= 29 ? new Y30() : new X30();
        c2850d40.h(C4501xx.b(0, 1, 0, 1));
        D = c2850d40.b();
        E = new Rect();
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = 0;
        this.m = new Rect();
        this.n = new Rect();
        this.o = new Rect();
        this.p = new Rect();
        new Rect();
        new Rect();
        new Rect();
        new Rect();
        C4119t40 c4119t40 = C4119t40.b;
        this.q = c4119t40;
        this.r = c4119t40;
        this.s = c4119t40;
        this.t = c4119t40;
        this.x = new X0(this, 0);
        this.y = new Y0(this, 0);
        this.z = new Y0(this, 1);
        i(context);
        this.A = new C3827pM(2);
        C0768b1 c0768b1 = new C0768b1(context);
        c0768b1.setWillNotDraw(true);
        this.B = c0768b1;
        addView(c0768b1);
    }

    public static boolean g(View view, Rect rect, boolean z) {
        boolean z2;
        C0688a1 c0688a1 = (C0688a1) view.getLayoutParams();
        int i = ((ViewGroup.MarginLayoutParams) c0688a1).leftMargin;
        int i2 = rect.left;
        if (i != i2) {
            ((ViewGroup.MarginLayoutParams) c0688a1).leftMargin = i2;
            z2 = true;
        } else {
            z2 = false;
        }
        int i3 = ((ViewGroup.MarginLayoutParams) c0688a1).topMargin;
        int i4 = rect.top;
        if (i3 != i4) {
            ((ViewGroup.MarginLayoutParams) c0688a1).topMargin = i4;
            z2 = true;
        }
        int i5 = ((ViewGroup.MarginLayoutParams) c0688a1).rightMargin;
        int i6 = rect.right;
        if (i5 != i6) {
            ((ViewGroup.MarginLayoutParams) c0688a1).rightMargin = i6;
            z2 = true;
        }
        if (z) {
            int i7 = ((ViewGroup.MarginLayoutParams) c0688a1).bottomMargin;
            int i8 = rect.bottom;
            if (i7 != i8) {
                ((ViewGroup.MarginLayoutParams) c0688a1).bottomMargin = i8;
                return true;
            }
        }
        return z2;
    }

    @Override // defpackage.LH
    public final void a(View view, View view2, int i, int i2) {
        if (i2 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // defpackage.LH
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // defpackage.LH
    public final void c(View view, int i, int i2, int[] iArr, int i3) {
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0688a1;
    }

    @Override // defpackage.MH
    public final void d(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        e(view, i, i2, i3, i4, i5);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int i;
        super.draw(canvas);
        if (this.f != null) {
            if (this.d.getVisibility() == 0) {
                i = (int) (this.d.getTranslationY() + this.d.getBottom() + 0.5f);
            } else {
                i = 0;
            }
            this.f.setBounds(0, i, getWidth(), this.f.getIntrinsicHeight() + i);
            this.f.draw(canvas);
        }
    }

    @Override // defpackage.LH
    public final void e(View view, int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            onNestedScroll(view, i, i2, i3, i4);
        }
    }

    @Override // defpackage.LH
    public final boolean f(View view, View view2, int i, int i2) {
        return i2 == 0 && onStartNestedScroll(view, view2, i);
    }

    @Override // android.view.View
    public final boolean fitSystemWindows(Rect rect) {
        return super.fitSystemWindows(rect);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0688a1(-1, -1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0688a1(getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.d;
        if (actionBarContainer != null) {
            return -((int) actionBarContainer.getTranslationY());
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C3827pM c3827pM = this.A;
        return c3827pM.c | c3827pM.b;
    }

    public CharSequence getTitle() {
        k();
        return ((C4232uX) this.e).a.getTitle();
    }

    public final void h() {
        removeCallbacks(this.y);
        removeCallbacks(this.z);
        ViewPropertyAnimator viewPropertyAnimator = this.w;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
        }
    }

    public final void i(Context context) {
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(C);
        this.a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(1);
        this.f = drawable;
        setWillNotDraw(drawable == null);
        obtainStyledAttributes.recycle();
        this.v = new OverScroller(context);
    }

    public final void j(int i) {
        k();
        if (i == 2) {
            ((C4232uX) this.e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else if (i == 5) {
            ((C4232uX) this.e).getClass();
            Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
        } else {
            if (i != 109) {
                return;
            }
            setOverlayMode(true);
        }
    }

    public final void k() {
        InterfaceC0590Wj wrapper;
        if (this.c == null) {
            this.c = (ContentFrameLayout) findViewById(R.id.action_bar_activity_content);
            this.d = (ActionBarContainer) findViewById(R.id.action_bar_container);
            KeyEvent.Callback findViewById = findViewById(R.id.action_bar);
            if (findViewById instanceof InterfaceC0590Wj) {
                wrapper = (InterfaceC0590Wj) findViewById;
            } else {
                if (!(findViewById instanceof Toolbar)) {
                    throw new IllegalStateException("Can't make a decor toolbar out of ".concat(findViewById.getClass().getSimpleName()));
                }
                wrapper = ((Toolbar) findViewById).getWrapper();
            }
            this.e = wrapper;
        }
    }

    public final void l(MenuC2945eF menuC2945eF, InterfaceC4451xF interfaceC4451xF) {
        k();
        C4232uX c4232uX = (C4232uX) this.e;
        C3480l1 c3480l1 = c4232uX.m;
        Toolbar toolbar = c4232uX.a;
        if (c3480l1 == null) {
            c4232uX.m = new C3480l1(toolbar.getContext());
        }
        C3480l1 c3480l12 = c4232uX.m;
        c3480l12.e = interfaceC4451xF;
        if (menuC2945eF == null && toolbar.a == null) {
            return;
        }
        toolbar.f();
        MenuC2945eF menuC2945eF2 = toolbar.a.p;
        if (menuC2945eF2 == menuC2945eF) {
            return;
        }
        if (menuC2945eF2 != null) {
            menuC2945eF2.r(toolbar.K);
            menuC2945eF2.r(toolbar.L);
        }
        if (toolbar.L == null) {
            toolbar.L = new C3759oX(toolbar);
        }
        c3480l12.q = true;
        if (menuC2945eF != null) {
            menuC2945eF.b(c3480l12, toolbar.j);
            menuC2945eF.b(toolbar.L, toolbar.j);
        } else {
            c3480l12.h(toolbar.j, null);
            toolbar.L.h(toolbar.j, null);
            c3480l12.f();
            toolbar.L.f();
        }
        toolbar.a.setPopupTheme(toolbar.k);
        toolbar.a.setPresenter(c3480l12);
        toolbar.K = c3480l12;
        toolbar.t();
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        k();
        C4119t40 g = C4119t40.g(this, windowInsets);
        boolean g2 = g(this.d, new Rect(g.b(), g.d(), g.c(), g.a()), false);
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        Rect rect = this.m;
        W10.b(this, g, rect);
        int i = rect.left;
        int i2 = rect.top;
        int i3 = rect.right;
        int i4 = rect.bottom;
        C3804p40 c3804p40 = g.a;
        C4119t40 p = c3804p40.p(i, i2, i3, i4);
        this.q = p;
        boolean z = true;
        if (!this.r.equals(p)) {
            this.r = this.q;
            g2 = true;
        }
        Rect rect2 = this.n;
        if (rect2.equals(rect)) {
            z = g2;
        } else {
            rect2.set(rect);
        }
        if (z) {
            requestLayout();
        }
        return c3804p40.a().a.c().a.b().f();
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        i(getContext());
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        h();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0688a1 c0688a1 = (C0688a1) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i6 = ((ViewGroup.MarginLayoutParams) c0688a1).leftMargin + paddingLeft;
                int i7 = ((ViewGroup.MarginLayoutParams) c0688a1).topMargin + paddingTop;
                childAt.layout(i6, i7, measuredWidth + i6, measuredHeight + i7);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0125  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        int measuredHeight;
        k();
        measureChildWithMargins(this.d, i, 0, i2, 0);
        C0688a1 c0688a1 = (C0688a1) this.d.getLayoutParams();
        int max = Math.max(0, this.d.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0688a1).leftMargin + ((ViewGroup.MarginLayoutParams) c0688a1).rightMargin);
        int max2 = Math.max(0, this.d.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0688a1).topMargin + ((ViewGroup.MarginLayoutParams) c0688a1).bottomMargin);
        int combineMeasuredStates = View.combineMeasuredStates(0, this.d.getMeasuredState());
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        boolean z = (getWindowSystemUiVisibility() & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0;
        if (z) {
            measuredHeight = this.a;
            if (this.h && this.d.getTabContainer() != null) {
                measuredHeight += this.a;
            }
        } else {
            measuredHeight = this.d.getVisibility() != 8 ? this.d.getMeasuredHeight() : 0;
        }
        Rect rect = this.m;
        Rect rect2 = this.o;
        rect2.set(rect);
        this.s = this.q;
        if (!this.g && !z) {
            C0768b1 c0768b1 = this.B;
            C4119t40 c4119t40 = D;
            Rect rect3 = this.p;
            W10.b(c0768b1, c4119t40, rect3);
            if (!rect3.equals(E)) {
                rect2.top += measuredHeight;
                rect2.bottom = rect2.bottom;
                this.s = this.s.a.p(0, measuredHeight, 0, 0);
                g(this.c, rect2, true);
                if (!this.t.equals(this.s)) {
                    C4119t40 c4119t402 = this.s;
                    this.t = c4119t402;
                    AbstractC2925e20.b(this.c, c4119t402);
                }
                measureChildWithMargins(this.c, i, 0, i2, 0);
                C0688a1 c0688a12 = (C0688a1) this.c.getLayoutParams();
                int max3 = Math.max(max, this.c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0688a12).leftMargin + ((ViewGroup.MarginLayoutParams) c0688a12).rightMargin);
                int max4 = Math.max(max2, this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0688a12).topMargin + ((ViewGroup.MarginLayoutParams) c0688a12).bottomMargin);
                int combineMeasuredStates2 = View.combineMeasuredStates(combineMeasuredStates, this.c.getMeasuredState());
                setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max3, getSuggestedMinimumWidth()), i, combineMeasuredStates2), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max4, getSuggestedMinimumHeight()), i2, combineMeasuredStates2 << 16));
            }
        }
        C4501xx b = C4501xx.b(this.s.b(), this.s.d() + measuredHeight, this.s.c(), this.s.a());
        C4119t40 c4119t403 = this.s;
        int i3 = Build.VERSION.SDK_INT;
        AbstractC2929e40 c2850d40 = i3 >= 36 ? new C2850d40(c4119t403) : i3 >= 35 ? new C0854c40(c4119t403) : i3 >= 34 ? new C0775b40(c4119t403) : i3 >= 31 ? new C0695a40(c4119t403) : i3 >= 30 ? new Z30(c4119t403) : i3 >= 29 ? new Y30(c4119t403) : new X30(c4119t403);
        c2850d40.h(b);
        this.s = c2850d40.b();
        g(this.c, rect2, true);
        if (!this.t.equals(this.s)) {
        }
        measureChildWithMargins(this.c, i, 0, i2, 0);
        C0688a1 c0688a122 = (C0688a1) this.c.getLayoutParams();
        int max32 = Math.max(max, this.c.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) c0688a122).leftMargin + ((ViewGroup.MarginLayoutParams) c0688a122).rightMargin);
        int max42 = Math.max(max2, this.c.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0688a122).topMargin + ((ViewGroup.MarginLayoutParams) c0688a122).bottomMargin);
        int combineMeasuredStates22 = View.combineMeasuredStates(combineMeasuredStates, this.c.getMeasuredState());
        setMeasuredDimension(View.resolveSizeAndState(Math.max(getPaddingRight() + getPaddingLeft() + max32, getSuggestedMinimumWidth()), i, combineMeasuredStates22), View.resolveSizeAndState(Math.max(getPaddingBottom() + getPaddingTop() + max42, getSuggestedMinimumHeight()), i2, combineMeasuredStates22 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.i || !z) {
            return false;
        }
        this.v.fling(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER);
        if (this.v.getFinalY() > this.d.getHeight()) {
            h();
            this.z.run();
        } else {
            h();
            this.y.run();
        }
        this.j = true;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int i5 = this.k + i2;
        this.k = i5;
        setActionBarHideOffset(i5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        P30 p30;
        C4431x20 c4431x20;
        this.A.b = i;
        this.k = getActionBarHideOffset();
        h();
        Z0 z0 = this.u;
        if (z0 == null || (c4431x20 = (p30 = (P30) z0).C) == null) {
            return;
        }
        c4431x20.a();
        p30.C = null;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.d.getVisibility() != 0) {
            return false;
        }
        return this.i;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        if (!this.i || this.j) {
            return;
        }
        if (this.k <= this.d.getHeight()) {
            h();
            postDelayed(this.y, 600L);
        } else {
            h();
            postDelayed(this.z, 600L);
        }
    }

    @Override // android.view.View
    public final void onWindowSystemUiVisibilityChanged(int i) {
        super.onWindowSystemUiVisibilityChanged(i);
        k();
        int i2 = this.l ^ i;
        this.l = i;
        boolean z = (i & 4) == 0;
        boolean z2 = (i & UserVerificationMethods.USER_VERIFY_HANDPRINT) != 0;
        Z0 z0 = this.u;
        if (z0 != null) {
            P30 p30 = (P30) z0;
            p30.y = !z2;
            if (z || !z2) {
                if (p30.z) {
                    p30.z = false;
                    p30.e0(true);
                }
            } else if (!p30.z) {
                p30.z = true;
                p30.e0(true);
            }
        }
        if ((i2 & UserVerificationMethods.USER_VERIFY_HANDPRINT) == 0 || this.u == null) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        requestApplyInsets();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.b = i;
        Z0 z0 = this.u;
        if (z0 != null) {
            ((P30) z0).x = i;
        }
    }

    public void setActionBarHideOffset(int i) {
        h();
        this.d.setTranslationY(-Math.max(0, Math.min(i, this.d.getHeight())));
    }

    public void setActionBarVisibilityCallback(Z0 z0) {
        this.u = z0;
        if (getWindowToken() != null) {
            ((P30) this.u).x = this.b;
            int i = this.l;
            if (i != 0) {
                onWindowSystemUiVisibilityChanged(i);
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                requestApplyInsets();
            }
        }
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.h = z;
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.i) {
            this.i = z;
            if (z) {
                return;
            }
            h();
            setActionBarHideOffset(0);
        }
    }

    public void setIcon(int i) {
        k();
        C4232uX c4232uX = (C4232uX) this.e;
        c4232uX.d = i != 0 ? XE.k(c4232uX.a.getContext(), i) : null;
        c4232uX.c();
    }

    public void setLogo(int i) {
        k();
        C4232uX c4232uX = (C4232uX) this.e;
        c4232uX.e = i != 0 ? XE.k(c4232uX.a.getContext(), i) : null;
        c4232uX.c();
    }

    public void setOverlayMode(boolean z) {
        this.g = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    public void setUiOptions(int i) {
    }

    @Override // defpackage.InterfaceC0564Vj
    public void setWindowCallback(Window.Callback callback) {
        k();
        ((C4232uX) this.e).k = callback;
    }

    @Override // defpackage.InterfaceC0564Vj
    public void setWindowTitle(CharSequence charSequence) {
        k();
        C4232uX c4232uX = (C4232uX) this.e;
        if (c4232uX.g) {
            return;
        }
        c4232uX.h = charSequence;
        if ((c4232uX.b & 8) != 0) {
            Toolbar toolbar = c4232uX.a;
            toolbar.setTitle(charSequence);
            if (c4232uX.g) {
                AbstractC2925e20.n(toolbar.getRootView(), charSequence);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new C0688a1(layoutParams);
    }

    public void setIcon(Drawable drawable) {
        k();
        C4232uX c4232uX = (C4232uX) this.e;
        c4232uX.d = drawable;
        c4232uX.c();
    }
}
