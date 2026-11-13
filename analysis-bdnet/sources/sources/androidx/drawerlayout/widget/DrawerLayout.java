package androidx.drawerlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import defpackage.AbstractC2925e20;
import defpackage.BM;
import defpackage.C0592Wl;
import defpackage.C0618Xl;
import defpackage.C0670Zl;
import defpackage.C0751am;
import defpackage.C0831bm;
import defpackage.C2882dV;
import defpackage.C3165h20;
import defpackage.C4119t40;
import defpackage.C4501xx;
import defpackage.F0;
import defpackage.InterfaceC0644Yl;
import defpackage.ViewOnApplyWindowInsetsListenerC0566Vl;
import defpackage.W50;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class DrawerLayout extends ViewGroup {
    public static final int[] D = {R.attr.colorPrimaryDark};
    public static final int[] E = {R.attr.layout_gravity};
    public static final boolean F;
    public static final boolean G;
    public static final boolean H;
    public Rect A;
    public Matrix B;
    public final C2882dV C;
    public final C0618Xl a;
    public float b;
    public final int c;
    public int d;
    public float e;
    public final Paint f;
    public final C3165h20 g;
    public final C3165h20 h;
    public final C0831bm i;
    public final C0831bm j;
    public int k;
    public boolean l;
    public boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public boolean r;
    public InterfaceC0644Yl s;
    public ArrayList t;
    public float u;
    public float v;
    public Drawable w;
    public WindowInsets x;
    public boolean y;
    public final ArrayList z;

    static {
        int i = Build.VERSION.SDK_INT;
        F = true;
        G = true;
        H = i >= 29;
    }

    public DrawerLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, dastan.prince.bdfreevpn.R.attr.drawerLayoutStyle);
        this.a = new C0618Xl(0);
        this.d = -1728053248;
        this.f = new Paint();
        this.m = true;
        this.n = 3;
        this.o = 3;
        this.p = 3;
        this.q = 3;
        this.C = new C2882dV(this, 14);
        setDescendantFocusability(262144);
        float f = getResources().getDisplayMetrics().density;
        this.c = (int) ((64.0f * f) + 0.5f);
        float f2 = f * 400.0f;
        C0831bm c0831bm = new C0831bm(this, 3);
        this.i = c0831bm;
        C0831bm c0831bm2 = new C0831bm(this, 5);
        this.j = c0831bm2;
        C3165h20 c3165h20 = new C3165h20(getContext(), this, c0831bm);
        c3165h20.b = (int) (c3165h20.b * 1.0f);
        this.g = c3165h20;
        c3165h20.q = 1;
        c3165h20.n = f2;
        c0831bm.b = c3165h20;
        C3165h20 c3165h202 = new C3165h20(getContext(), this, c0831bm2);
        c3165h202.b = (int) (1.0f * c3165h202.b);
        this.h = c3165h202;
        c3165h202.q = 2;
        c3165h202.n = f2;
        c0831bm2.b = c3165h202;
        setFocusableInTouchMode(true);
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        setImportantForAccessibility(1);
        AbstractC2925e20.m(this, new C0592Wl(this));
        setMotionEventSplittingEnabled(false);
        if (getFitsSystemWindows()) {
            setOnApplyWindowInsetsListener(new ViewOnApplyWindowInsetsListenerC0566Vl());
            setSystemUiVisibility(1280);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(D);
            try {
                this.w = obtainStyledAttributes.getDrawable(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, BM.a, dastan.prince.bdfreevpn.R.attr.drawerLayoutStyle, 0);
        try {
            if (obtainStyledAttributes2.hasValue(0)) {
                this.b = obtainStyledAttributes2.getDimension(0, 0.0f);
            } else {
                this.b = getResources().getDimension(dastan.prince.bdfreevpn.R.dimen.def_drawer_elevation);
            }
            obtainStyledAttributes2.recycle();
            this.z = new ArrayList();
        } catch (Throwable th) {
            obtainStyledAttributes2.recycle();
            throw th;
        }
    }

    public static boolean i(View view) {
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        return (view.getImportantForAccessibility() == 4 || view.getImportantForAccessibility() == 2) ? false : true;
    }

    public static boolean j(View view) {
        return ((C0670Zl) view.getLayoutParams()).a == 0;
    }

    public static boolean k(View view) {
        if (l(view)) {
            return (((C0670Zl) view.getLayoutParams()).d & 1) == 1;
        }
        throw new IllegalArgumentException("View " + view + " is not a drawer");
    }

    public static boolean l(View view) {
        int i = ((C0670Zl) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, view.getLayoutDirection());
        return ((absoluteGravity & 3) == 0 && (absoluteGravity & 5) == 0) ? false : true;
    }

    public final boolean a(View view, int i) {
        return (h(view) & i) == i;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i2) {
        ArrayList arrayList2;
        if (getDescendantFocusability() == 393216) {
            return;
        }
        int childCount = getChildCount();
        int i3 = 0;
        boolean z = false;
        while (true) {
            arrayList2 = this.z;
            if (i3 >= childCount) {
                break;
            }
            View childAt = getChildAt(i3);
            if (!l(childAt)) {
                arrayList2.add(childAt);
            } else if (k(childAt)) {
                childAt.addFocusables(arrayList, i, i2);
                z = true;
            }
            i3++;
        }
        if (!z) {
            int size = arrayList2.size();
            for (int i4 = 0; i4 < size; i4++) {
                View view = (View) arrayList2.get(i4);
                if (view.getVisibility() == 0) {
                    view.addFocusables(arrayList, i, i2);
                }
            }
        }
        arrayList2.clear();
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (e() != null || l(view)) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            view.setImportantForAccessibility(4);
        } else {
            WeakHashMap weakHashMap2 = AbstractC2925e20.a;
            view.setImportantForAccessibility(1);
        }
        if (F) {
            return;
        }
        AbstractC2925e20.m(view, this.a);
    }

    public final void b(View view) {
        if (!l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        C0670Zl c0670Zl = (C0670Zl) view.getLayoutParams();
        if (this.m) {
            c0670Zl.b = 0.0f;
            c0670Zl.d = 0;
        } else {
            c0670Zl.d |= 4;
            if (a(view, 3)) {
                this.g.s(view, -view.getWidth(), view.getTop());
            } else {
                this.h.s(view, getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void c(boolean z) {
        int childCount = getChildCount();
        boolean z2 = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            C0670Zl c0670Zl = (C0670Zl) childAt.getLayoutParams();
            if (l(childAt) && (!z || c0670Zl.c)) {
                z2 |= a(childAt, 3) ? this.g.s(childAt, -childAt.getWidth(), childAt.getTop()) : this.h.s(childAt, getWidth(), childAt.getTop());
                c0670Zl.c = false;
            }
        }
        C0831bm c0831bm = this.i;
        c0831bm.d.removeCallbacks(c0831bm.c);
        C0831bm c0831bm2 = this.j;
        c0831bm2.d.removeCallbacks(c0831bm2.c);
        if (z2) {
            invalidate();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0670Zl) && super.checkLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public final void computeScroll() {
        int childCount = getChildCount();
        float f = 0.0f;
        for (int i = 0; i < childCount; i++) {
            f = Math.max(f, ((C0670Zl) getChildAt(i).getLayoutParams()).b);
        }
        this.e = f;
        boolean g = this.g.g();
        boolean g2 = this.h.g();
        if (g || g2) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            postInvalidateOnAnimation();
        }
    }

    public final View d(int i) {
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if ((h(childAt) & 7) == absoluteGravity) {
                return childAt;
            }
        }
        return null;
    }

    @Override // android.view.View
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        boolean dispatchGenericMotionEvent;
        if ((motionEvent.getSource() & 2) == 0 || motionEvent.getAction() == 10 || this.e <= 0.0f) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        int childCount = getChildCount();
        if (childCount == 0) {
            return false;
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        for (int i = childCount - 1; i >= 0; i--) {
            View childAt = getChildAt(i);
            if (this.A == null) {
                this.A = new Rect();
            }
            childAt.getHitRect(this.A);
            if (this.A.contains((int) x, (int) y) && !j(childAt)) {
                if (childAt.getMatrix().isIdentity()) {
                    float scrollX = getScrollX() - childAt.getLeft();
                    float scrollY = getScrollY() - childAt.getTop();
                    motionEvent.offsetLocation(scrollX, scrollY);
                    dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(motionEvent);
                    motionEvent.offsetLocation(-scrollX, -scrollY);
                } else {
                    float scrollX2 = getScrollX() - childAt.getLeft();
                    float scrollY2 = getScrollY() - childAt.getTop();
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    obtain.offsetLocation(scrollX2, scrollY2);
                    Matrix matrix = childAt.getMatrix();
                    if (!matrix.isIdentity()) {
                        if (this.B == null) {
                            this.B = new Matrix();
                        }
                        matrix.invert(this.B);
                        obtain.transform(this.B);
                    }
                    dispatchGenericMotionEvent = childAt.dispatchGenericMotionEvent(obtain);
                    obtain.recycle();
                }
                if (dispatchGenericMotionEvent) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        Drawable background;
        int height = getHeight();
        boolean j2 = j(view);
        int width = getWidth();
        int save = canvas.save();
        int i = 0;
        if (j2) {
            int childCount = getChildCount();
            int i2 = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt != view && childAt.getVisibility() == 0 && (background = childAt.getBackground()) != null && background.getOpacity() == -1 && l(childAt) && childAt.getHeight() >= height) {
                    if (a(childAt, 3)) {
                        int right = childAt.getRight();
                        if (right > i2) {
                            i2 = right;
                        }
                    } else {
                        int left = childAt.getLeft();
                        if (left < width) {
                            width = left;
                        }
                    }
                }
            }
            canvas.clipRect(i2, 0, width, getHeight());
            i = i2;
        }
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restoreToCount(save);
        float f = this.e;
        if (f > 0.0f && j2) {
            int i4 = this.d;
            Paint paint = this.f;
            paint.setColor((((int) ((((-16777216) & i4) >>> 24) * f)) << 24) | (i4 & 16777215));
            canvas.drawRect(i, 0.0f, width, getHeight(), paint);
        }
        return drawChild;
    }

    public final View e() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((((C0670Zl) childAt.getLayoutParams()).d & 1) == 1) {
                return childAt;
            }
        }
        return null;
    }

    public final View f() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (l(childAt)) {
                if (!l(childAt)) {
                    throw new IllegalArgumentException("View " + childAt + " is not a drawer");
                }
                if (((C0670Zl) childAt.getLayoutParams()).b > 0.0f) {
                    return childAt;
                }
            }
        }
        return null;
    }

    public final int g(View view) {
        if (!l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a drawer");
        }
        int i = ((C0670Zl) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int layoutDirection = getLayoutDirection();
        if (i == 3) {
            int i2 = this.n;
            if (i2 != 3) {
                return i2;
            }
            int i3 = layoutDirection == 0 ? this.p : this.q;
            if (i3 != 3) {
                return i3;
            }
            return 0;
        }
        if (i == 5) {
            int i4 = this.o;
            if (i4 != 3) {
                return i4;
            }
            int i5 = layoutDirection == 0 ? this.q : this.p;
            if (i5 != 3) {
                return i5;
            }
            return 0;
        }
        if (i == 8388611) {
            int i6 = this.p;
            if (i6 != 3) {
                return i6;
            }
            int i7 = layoutDirection == 0 ? this.n : this.o;
            if (i7 != 3) {
                return i7;
            }
            return 0;
        }
        if (i != 8388613) {
            return 0;
        }
        int i8 = this.q;
        if (i8 != 3) {
            return i8;
        }
        int i9 = layoutDirection == 0 ? this.o : this.n;
        if (i9 != 3) {
            return i9;
        }
        return 0;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        C0670Zl c0670Zl = new C0670Zl(-1, -1);
        c0670Zl.a = 0;
        return c0670Zl;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof C0670Zl) {
            C0670Zl c0670Zl = (C0670Zl) layoutParams;
            C0670Zl c0670Zl2 = new C0670Zl(c0670Zl);
            c0670Zl2.a = 0;
            c0670Zl2.a = c0670Zl.a;
            return c0670Zl2;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            C0670Zl c0670Zl3 = new C0670Zl((ViewGroup.MarginLayoutParams) layoutParams);
            c0670Zl3.a = 0;
            return c0670Zl3;
        }
        C0670Zl c0670Zl4 = new C0670Zl(layoutParams);
        c0670Zl4.a = 0;
        return c0670Zl4;
    }

    public float getDrawerElevation() {
        if (G) {
            return this.b;
        }
        return 0.0f;
    }

    public Drawable getStatusBarBackgroundDrawable() {
        return this.w;
    }

    public final int h(View view) {
        int i = ((C0670Zl) view.getLayoutParams()).a;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        return Gravity.getAbsoluteGravity(i, getLayoutDirection());
    }

    public final void m(View view) {
        if (!l(view)) {
            throw new IllegalArgumentException("View " + view + " is not a sliding drawer");
        }
        C0670Zl c0670Zl = (C0670Zl) view.getLayoutParams();
        if (this.m) {
            c0670Zl.b = 1.0f;
            c0670Zl.d = 1;
            q(view, true);
            p(view);
        } else {
            c0670Zl.d |= 2;
            if (a(view, 3)) {
                this.g.s(view, 0, view.getTop());
            } else {
                this.h.s(view, getWidth() - view.getWidth(), view.getTop());
            }
        }
        invalidate();
    }

    public final void n(int i, int i2) {
        View d;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int absoluteGravity = Gravity.getAbsoluteGravity(i2, getLayoutDirection());
        if (i2 == 3) {
            this.n = i;
        } else if (i2 == 5) {
            this.o = i;
        } else if (i2 == 8388611) {
            this.p = i;
        } else if (i2 == 8388613) {
            this.q = i;
        }
        if (i != 0) {
            (absoluteGravity == 3 ? this.g : this.h).a();
        }
        if (i != 1) {
            if (i == 2 && (d = d(absoluteGravity)) != null) {
                m(d);
                return;
            }
            return;
        }
        View d2 = d(absoluteGravity);
        if (d2 != null) {
            b(d2);
        }
    }

    public final void o(View view, float f) {
        C0670Zl c0670Zl = (C0670Zl) view.getLayoutParams();
        if (f == c0670Zl.b) {
            return;
        }
        c0670Zl.b = f;
        ArrayList arrayList = this.t;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((InterfaceC0644Yl) this.t.get(size)).getClass();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.m = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.m = true;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.y || this.w == null) {
            return;
        }
        WindowInsets windowInsets = this.x;
        int systemWindowInsetTop = windowInsets != null ? windowInsets.getSystemWindowInsetTop() : 0;
        if (systemWindowInsetTop > 0) {
            this.w.setBounds(0, 0, getWidth(), systemWindowInsetTop);
            this.w.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r0 != 3) goto L19;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z;
        View h;
        int actionMasked = motionEvent.getActionMasked();
        C3165h20 c3165h20 = this.g;
        boolean r = c3165h20.r(motionEvent) | this.h.r(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int length = c3165h20.d.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            break;
                        }
                        if ((c3165h20.k & (1 << i)) != 0) {
                            float f = c3165h20.f[i] - c3165h20.d[i];
                            float f2 = c3165h20.g[i] - c3165h20.e[i];
                            float f3 = (f2 * f2) + (f * f);
                            int i2 = c3165h20.b;
                            if (f3 > i2 * i2) {
                                C0831bm c0831bm = this.i;
                                c0831bm.d.removeCallbacks(c0831bm.c);
                                C0831bm c0831bm2 = this.j;
                                c0831bm2.d.removeCallbacks(c0831bm2.c);
                                break;
                            }
                        }
                        i++;
                    }
                }
                z = false;
            }
            c(true);
            this.r = false;
            z = false;
        } else {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.u = x;
            this.v = y;
            z = this.e > 0.0f && (h = c3165h20.h((int) x, (int) y)) != null && j(h);
            this.r = false;
        }
        if (!r && !z) {
            int childCount = getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    if (this.r) {
                        break;
                    }
                    return false;
                }
                if (((C0670Zl) getChildAt(i3).getLayoutParams()).c) {
                    break;
                }
                i3++;
            }
        }
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || f() == null) {
            return super.onKeyDown(i, keyEvent);
        }
        keyEvent.startTracking();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyUp(i, keyEvent);
        }
        View f = f();
        if (f != null && g(f) == 0) {
            c(false);
        }
        return f != null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        WindowInsets rootWindowInsets;
        float f;
        int i5;
        boolean z2 = true;
        this.l = true;
        int i6 = i3 - i;
        int childCount = getChildCount();
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                C0670Zl c0670Zl = (C0670Zl) childAt.getLayoutParams();
                if (j(childAt)) {
                    int i8 = ((ViewGroup.MarginLayoutParams) c0670Zl).leftMargin;
                    childAt.layout(i8, ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin, childAt.getMeasuredWidth() + i8, childAt.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin);
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a(childAt, 3)) {
                        float f2 = measuredWidth;
                        i5 = (-measuredWidth) + ((int) (c0670Zl.b * f2));
                        f = (measuredWidth + i5) / f2;
                    } else {
                        float f3 = measuredWidth;
                        f = (i6 - r11) / f3;
                        i5 = i6 - ((int) (c0670Zl.b * f3));
                    }
                    boolean z3 = f != c0670Zl.b ? z2 : false;
                    int i9 = c0670Zl.a & 112;
                    if (i9 == 16) {
                        int i10 = i4 - i2;
                        int i11 = (i10 - measuredHeight) / 2;
                        int i12 = ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin;
                        if (i11 < i12) {
                            i11 = i12;
                        } else {
                            int i13 = i11 + measuredHeight;
                            int i14 = i10 - ((ViewGroup.MarginLayoutParams) c0670Zl).bottomMargin;
                            if (i13 > i14) {
                                i11 = i14 - measuredHeight;
                            }
                        }
                        childAt.layout(i5, i11, measuredWidth + i5, measuredHeight + i11);
                    } else if (i9 != 80) {
                        int i15 = ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin;
                        childAt.layout(i5, i15, measuredWidth + i5, measuredHeight + i15);
                    } else {
                        int i16 = i4 - i2;
                        childAt.layout(i5, (i16 - ((ViewGroup.MarginLayoutParams) c0670Zl).bottomMargin) - childAt.getMeasuredHeight(), measuredWidth + i5, i16 - ((ViewGroup.MarginLayoutParams) c0670Zl).bottomMargin);
                    }
                    if (z3) {
                        o(childAt, f);
                    }
                    int i17 = c0670Zl.b > 0.0f ? 0 : 4;
                    if (childAt.getVisibility() != i17) {
                        childAt.setVisibility(i17);
                    }
                }
            }
            i7++;
            z2 = true;
        }
        if (H && (rootWindowInsets = getRootWindowInsets()) != null) {
            C4501xx k = C4119t40.g(null, rootWindowInsets).a.k();
            C3165h20 c3165h20 = this.g;
            c3165h20.o = Math.max(c3165h20.p, k.a);
            C3165h20 c3165h202 = this.h;
            c3165h202.o = Math.max(c3165h202.p, k.c);
        }
        this.l = false;
        this.m = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        boolean z;
        int childCount;
        int i3;
        int i4;
        int i5 = 3;
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        char c = 0;
        if (mode != 1073741824 || mode2 != 1073741824) {
            if (!isInEditMode()) {
                throw new IllegalArgumentException("DrawerLayout must be measured with MeasureSpec.EXACTLY.");
            }
            if (mode == 0) {
                size = 300;
            }
            if (mode2 == 0) {
                size2 = 300;
            }
        }
        setMeasuredDimension(size, size2);
        if (this.x != null) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            if (getFitsSystemWindows()) {
                z = true;
                WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                int layoutDirection = getLayoutDirection();
                childCount = getChildCount();
                i3 = 0;
                boolean z2 = false;
                boolean z3 = false;
                while (i3 < childCount) {
                    View childAt = getChildAt(i3);
                    if (childAt.getVisibility() != 8) {
                        C0670Zl c0670Zl = (C0670Zl) childAt.getLayoutParams();
                        if (z) {
                            int absoluteGravity = Gravity.getAbsoluteGravity(c0670Zl.a, layoutDirection);
                            if (childAt.getFitsSystemWindows()) {
                                WindowInsets windowInsets = this.x;
                                if (absoluteGravity == i5) {
                                    windowInsets = windowInsets.replaceSystemWindowInsets(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), 0, windowInsets.getSystemWindowInsetBottom());
                                } else if (absoluteGravity == 5) {
                                    windowInsets = windowInsets.replaceSystemWindowInsets(0, windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
                                }
                                childAt.dispatchApplyWindowInsets(windowInsets);
                            } else {
                                WindowInsets windowInsets2 = this.x;
                                if (absoluteGravity == 3) {
                                    windowInsets2 = windowInsets2.replaceSystemWindowInsets(windowInsets2.getSystemWindowInsetLeft(), windowInsets2.getSystemWindowInsetTop(), 0, windowInsets2.getSystemWindowInsetBottom());
                                } else if (absoluteGravity == 5) {
                                    windowInsets2 = windowInsets2.replaceSystemWindowInsets(0, windowInsets2.getSystemWindowInsetTop(), windowInsets2.getSystemWindowInsetRight(), windowInsets2.getSystemWindowInsetBottom());
                                }
                                ((ViewGroup.MarginLayoutParams) c0670Zl).leftMargin = windowInsets2.getSystemWindowInsetLeft();
                                ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin = windowInsets2.getSystemWindowInsetTop();
                                ((ViewGroup.MarginLayoutParams) c0670Zl).rightMargin = windowInsets2.getSystemWindowInsetRight();
                                ((ViewGroup.MarginLayoutParams) c0670Zl).bottomMargin = windowInsets2.getSystemWindowInsetBottom();
                            }
                        }
                        if (j(childAt)) {
                            childAt.measure(View.MeasureSpec.makeMeasureSpec((size - ((ViewGroup.MarginLayoutParams) c0670Zl).leftMargin) - ((ViewGroup.MarginLayoutParams) c0670Zl).rightMargin, 1073741824), View.MeasureSpec.makeMeasureSpec((size2 - ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin) - ((ViewGroup.MarginLayoutParams) c0670Zl).bottomMargin, 1073741824));
                        } else {
                            if (!l(childAt)) {
                                throw new IllegalStateException("Child " + childAt + " at index " + i3 + " does not have a valid layout_gravity - must be Gravity.LEFT, Gravity.RIGHT or Gravity.NO_GRAVITY");
                            }
                            if (G) {
                                float elevation = childAt.getElevation();
                                float f = this.b;
                                if (elevation != f) {
                                    childAt.setElevation(f);
                                }
                            }
                            int h = h(childAt);
                            int i6 = h & 7;
                            boolean z4 = i6 == 3;
                            if ((z4 && z2) || (!z4 && z3)) {
                                throw new IllegalStateException(W50.q((h & 3) != 3 ? (h & 5) == 5 ? "RIGHT" : Integer.toHexString(i6) : "LEFT", " but this DrawerLayout already has a drawer view along that edge", new StringBuilder("Child drawer has absolute gravity ")));
                            }
                            i4 = 3;
                            if (z4) {
                                z2 = true;
                            } else {
                                z3 = true;
                            }
                            childAt.measure(ViewGroup.getChildMeasureSpec(i, this.c + ((ViewGroup.MarginLayoutParams) c0670Zl).leftMargin + ((ViewGroup.MarginLayoutParams) c0670Zl).rightMargin, ((ViewGroup.MarginLayoutParams) c0670Zl).width), ViewGroup.getChildMeasureSpec(i2, ((ViewGroup.MarginLayoutParams) c0670Zl).topMargin + ((ViewGroup.MarginLayoutParams) c0670Zl).bottomMargin, ((ViewGroup.MarginLayoutParams) c0670Zl).height));
                            i3++;
                            i5 = i4;
                            c = 0;
                        }
                    }
                    i4 = 3;
                    i3++;
                    i5 = i4;
                    c = 0;
                }
            }
        }
        z = false;
        WeakHashMap weakHashMap22 = AbstractC2925e20.a;
        int layoutDirection2 = getLayoutDirection();
        childCount = getChildCount();
        i3 = 0;
        boolean z22 = false;
        boolean z32 = false;
        while (i3 < childCount) {
        }
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        View d;
        if (!(parcelable instanceof C0751am)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0751am c0751am = (C0751am) parcelable;
        super.onRestoreInstanceState(c0751am.a);
        int i = c0751am.c;
        if (i != 0 && (d = d(i)) != null) {
            m(d);
        }
        int i2 = c0751am.d;
        if (i2 != 3) {
            n(i2, 3);
        }
        int i3 = c0751am.e;
        if (i3 != 3) {
            n(i3, 5);
        }
        int i4 = c0751am.f;
        if (i4 != 3) {
            n(i4, 8388611);
        }
        int i5 = c0751am.g;
        if (i5 != 3) {
            n(i5, 8388613);
        }
    }

    @Override // android.view.View
    public final void onRtlPropertiesChanged(int i) {
        if (G) {
            return;
        }
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        getLayoutDirection();
        getLayoutDirection();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        C0751am c0751am = new C0751am(super.onSaveInstanceState());
        c0751am.c = 0;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            C0670Zl c0670Zl = (C0670Zl) getChildAt(i).getLayoutParams();
            int i2 = c0670Zl.d;
            boolean z = i2 == 1;
            boolean z2 = i2 == 2;
            if (z || z2) {
                c0751am.c = c0670Zl.a;
                break;
            }
        }
        c0751am.d = this.n;
        c0751am.e = this.o;
        c0751am.f = this.p;
        c0751am.g = this.q;
        return c0751am;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (g(r7) != 2) goto L21;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        C3165h20 c3165h20 = this.g;
        c3165h20.k(motionEvent);
        this.h.k(motionEvent);
        int action = motionEvent.getAction() & 255;
        boolean z = false;
        if (action == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            this.u = x;
            this.v = y;
            this.r = false;
            return true;
        }
        if (action != 1) {
            if (action != 3) {
                return true;
            }
            c(true);
            this.r = false;
            return true;
        }
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        View h = c3165h20.h((int) x2, (int) y2);
        if (h != null && j(h)) {
            float f = x2 - this.u;
            float f2 = y2 - this.v;
            int i = c3165h20.b;
            if ((f2 * f2) + (f * f) < i * i) {
                View e = e();
                if (e != null) {
                }
            }
        }
        z = true;
        c(z);
        return true;
    }

    public final void p(View view) {
        F0 f0 = F0.l;
        AbstractC2925e20.j(view, f0.a());
        AbstractC2925e20.h(view, 0);
        if (!k(view) || g(view) == 2) {
            return;
        }
        AbstractC2925e20.k(view, f0, this.C);
    }

    public final void q(View view, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if ((z || l(childAt)) && !(z && childAt == view)) {
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                childAt.setImportantForAccessibility(4);
            } else {
                WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                childAt.setImportantForAccessibility(1);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (z) {
            c(true);
        }
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.l) {
            return;
        }
        super.requestLayout();
    }

    public void setDrawerElevation(float f) {
        this.b = f;
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (l(childAt)) {
                float f2 = this.b;
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                childAt.setElevation(f2);
            }
        }
    }

    @Deprecated
    public void setDrawerListener(InterfaceC0644Yl interfaceC0644Yl) {
        ArrayList arrayList;
        InterfaceC0644Yl interfaceC0644Yl2 = this.s;
        if (interfaceC0644Yl2 != null && (arrayList = this.t) != null) {
            arrayList.remove(interfaceC0644Yl2);
        }
        if (interfaceC0644Yl != null) {
            if (this.t == null) {
                this.t = new ArrayList();
            }
            this.t.add(interfaceC0644Yl);
        }
        this.s = interfaceC0644Yl;
    }

    public void setDrawerLockMode(int i) {
        n(i, 3);
        n(i, 5);
    }

    public void setScrimColor(int i) {
        this.d = i;
        invalidate();
    }

    public void setStatusBarBackground(Drawable drawable) {
        this.w = drawable;
        invalidate();
    }

    public void setStatusBarBackgroundColor(int i) {
        this.w = new ColorDrawable(i);
        invalidate();
    }

    public void setStatusBarBackground(int i) {
        this.w = i != 0 ? getContext().getDrawable(i) : null;
        invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        C0670Zl c0670Zl = new C0670Zl(context, attributeSet);
        c0670Zl.a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, E);
        c0670Zl.a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        return c0670Zl;
    }
}
