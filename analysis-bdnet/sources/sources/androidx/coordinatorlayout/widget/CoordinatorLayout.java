package androidx.coordinatorlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0327Mg;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3483l20;
import defpackage.AbstractC4616zM;
import defpackage.C0405Pg;
import defpackage.C0457Rg;
import defpackage.C2835cv;
import defpackage.C3092g6;
import defpackage.C3588mK;
import defpackage.C3667nK;
import defpackage.C3827pM;
import defpackage.C4119t40;
import defpackage.C4386wT;
import defpackage.InterfaceC0302Lg;
import defpackage.InterfaceC0353Ng;
import defpackage.LH;
import defpackage.MH;
import defpackage.NX;
import defpackage.ViewGroupOnHierarchyChangeListenerC0379Og;
import defpackage.ViewTreeObserverOnPreDrawListenerC0431Qg;
import defpackage.W10;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class CoordinatorLayout extends ViewGroup implements LH, MH {
    public static final String t;
    public static final Class[] u;
    public static final ThreadLocal v;
    public static final C3092g6 w;
    public static final C3667nK x;
    public final ArrayList a;
    public final NX b;
    public final ArrayList c;
    public final ArrayList d;
    public final int[] e;
    public final int[] f;
    public boolean g;
    public boolean h;
    public final int[] i;
    public View j;
    public View k;
    public ViewTreeObserverOnPreDrawListenerC0431Qg l;
    public boolean m;
    public C4119t40 n;
    public boolean o;
    public Drawable p;
    public ViewGroup.OnHierarchyChangeListener q;
    public C2835cv r;
    public final C3827pM s;

    static {
        Package r0 = CoordinatorLayout.class.getPackage();
        t = r0 != null ? r0.getName() : null;
        w = new C3092g6(2);
        u = new Class[]{Context.class, AttributeSet.class};
        v = new ThreadLocal();
        x = new C3667nK();
    }

    public CoordinatorLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.coordinatorLayoutStyle);
        this.a = new ArrayList();
        this.b = new NX(4);
        this.c = new ArrayList();
        this.d = new ArrayList();
        this.e = new int[2];
        this.f = new int[2];
        this.s = new C3827pM(2);
        int[] iArr = AbstractC4616zM.a;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, R.attr.coordinatorLayoutStyle, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, iArr, attributeSet, obtainStyledAttributes, R.attr.coordinatorLayoutStyle, 0);
        }
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            Resources resources = context.getResources();
            int[] intArray = resources.getIntArray(resourceId);
            this.i = intArray;
            float f = resources.getDisplayMetrics().density;
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                this.i[i] = (int) (r1[i] * f);
            }
        }
        this.p = obtainStyledAttributes.getDrawable(1);
        obtainStyledAttributes.recycle();
        x();
        super.setOnHierarchyChangeListener(new ViewGroupOnHierarchyChangeListenerC0379Og(this));
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    public static Rect g() {
        Rect rect = (Rect) x.a();
        return rect == null ? new Rect() : rect;
    }

    public static void l(int i, Rect rect, Rect rect2, C0405Pg c0405Pg, int i2, int i3) {
        int i4 = c0405Pg.c;
        if (i4 == 0) {
            i4 = 17;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = c0405Pg.d;
        if ((i5 & 7) == 0) {
            i5 |= 8388611;
        }
        if ((i5 & 112) == 0) {
            i5 |= 48;
        }
        int absoluteGravity2 = Gravity.getAbsoluteGravity(i5, i);
        int i6 = absoluteGravity & 7;
        int i7 = absoluteGravity & 112;
        int i8 = absoluteGravity2 & 7;
        int i9 = absoluteGravity2 & 112;
        int width = i8 != 1 ? i8 != 5 ? rect.left : rect.right : rect.left + (rect.width() / 2);
        int height = i9 != 16 ? i9 != 80 ? rect.top : rect.bottom : rect.top + (rect.height() / 2);
        if (i6 == 1) {
            width -= i2 / 2;
        } else if (i6 != 5) {
            width -= i2;
        }
        if (i7 == 16) {
            height -= i3 / 2;
        } else if (i7 != 80) {
            height -= i3;
        }
        rect2.set(width, height, i2 + width, i3 + height);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C0405Pg n(View view) {
        C0405Pg c0405Pg = (C0405Pg) view.getLayoutParams();
        if (!c0405Pg.b) {
            if (view instanceof InterfaceC0302Lg) {
                AbstractC0327Mg behavior = ((InterfaceC0302Lg) view).getBehavior();
                if (behavior == null) {
                    Log.e("CoordinatorLayout", "Attached behavior class is null");
                }
                c0405Pg.b(behavior);
                c0405Pg.b = true;
                return c0405Pg;
            }
            InterfaceC0353Ng interfaceC0353Ng = null;
            for (Class<?> cls = view.getClass(); cls != null; cls = cls.getSuperclass()) {
                interfaceC0353Ng = (InterfaceC0353Ng) cls.getAnnotation(InterfaceC0353Ng.class);
                if (interfaceC0353Ng != null) {
                    break;
                }
            }
            if (interfaceC0353Ng != null) {
                try {
                    c0405Pg.b((AbstractC0327Mg) interfaceC0353Ng.value().getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
                } catch (Exception e) {
                    Log.e("CoordinatorLayout", "Default behavior class " + interfaceC0353Ng.value().getName() + " could not be instantiated. Did you forget a default constructor?", e);
                }
            }
            c0405Pg.b = true;
        }
        return c0405Pg;
    }

    public static void v(View view, int i) {
        C0405Pg c0405Pg = (C0405Pg) view.getLayoutParams();
        int i2 = c0405Pg.i;
        if (i2 != i) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            view.offsetLeftAndRight(i - i2);
            c0405Pg.i = i;
        }
    }

    public static void w(View view, int i) {
        C0405Pg c0405Pg = (C0405Pg) view.getLayoutParams();
        int i2 = c0405Pg.j;
        if (i2 != i) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            view.offsetTopAndBottom(i - i2);
            c0405Pg.j = i;
        }
    }

    @Override // defpackage.LH
    public final void a(View view, View view2, int i, int i2) {
        C3827pM c3827pM = this.s;
        if (i2 == 1) {
            c3827pM.c = i;
        } else {
            c3827pM.b = i;
        }
        this.k = view2;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            ((C0405Pg) getChildAt(i3).getLayoutParams()).getClass();
        }
    }

    @Override // defpackage.LH
    public final void b(View view, int i) {
        C3827pM c3827pM = this.s;
        if (i == 1) {
            c3827pM.c = 0;
        } else {
            c3827pM.b = 0;
        }
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C0405Pg c0405Pg = (C0405Pg) childAt.getLayoutParams();
            if (c0405Pg.a(i)) {
                AbstractC0327Mg abstractC0327Mg = c0405Pg.a;
                if (abstractC0327Mg != null) {
                    abstractC0327Mg.q(this, childAt, view, i);
                }
                if (i == 0) {
                    c0405Pg.m = false;
                } else if (i == 1) {
                    c0405Pg.n = false;
                }
                c0405Pg.o = false;
            }
        }
        this.k = null;
    }

    @Override // defpackage.LH
    public final void c(View view, int i, int i2, int[] iArr, int i3) {
        AbstractC0327Mg abstractC0327Mg;
        int childCount = getChildCount();
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt.getVisibility() != 8) {
                C0405Pg c0405Pg = (C0405Pg) childAt.getLayoutParams();
                if (c0405Pg.a(i3) && (abstractC0327Mg = c0405Pg.a) != null) {
                    int[] iArr2 = this.e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC0327Mg.k(this, childAt, view, i, i2, iArr2, i3);
                    i4 = i > 0 ? Math.max(i4, iArr2[0]) : Math.min(i4, iArr2[0]);
                    i5 = i2 > 0 ? Math.max(i5, iArr2[1]) : Math.min(i5, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = i4;
        iArr[1] = i5;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof C0405Pg) && super.checkLayoutParams(layoutParams);
    }

    @Override // defpackage.MH
    public final void d(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        AbstractC0327Mg abstractC0327Mg;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        boolean z = false;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                C0405Pg c0405Pg = (C0405Pg) childAt.getLayoutParams();
                if (c0405Pg.a(i5) && (abstractC0327Mg = c0405Pg.a) != null) {
                    int[] iArr2 = this.e;
                    iArr2[0] = 0;
                    iArr2[1] = 0;
                    abstractC0327Mg.l(this, childAt, i2, i3, i4, iArr2);
                    i6 = i3 > 0 ? Math.max(i6, iArr2[0]) : Math.min(i6, iArr2[0]);
                    i7 = i4 > 0 ? Math.max(i7, iArr2[1]) : Math.min(i7, iArr2[1]);
                    z = true;
                }
            }
        }
        iArr[0] = iArr[0] + i6;
        iArr[1] = iArr[1] + i7;
        if (z) {
            p(1);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        AbstractC0327Mg abstractC0327Mg = ((C0405Pg) view.getLayoutParams()).a;
        if (abstractC0327Mg != null) {
            abstractC0327Mg.getClass();
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.p;
        if ((drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState)) {
            invalidate();
        }
    }

    @Override // defpackage.LH
    public final void e(View view, int i, int i2, int i3, int i4, int i5) {
        d(view, i, i2, i3, i4, 0, this.f);
    }

    @Override // defpackage.LH
    public final boolean f(View view, View view2, int i, int i2) {
        View view3;
        int i3;
        int i4;
        int childCount = getChildCount();
        int i5 = 0;
        boolean z = false;
        while (i5 < childCount) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() == 8) {
                view3 = view;
                i3 = i;
                i4 = i2;
            } else {
                C0405Pg c0405Pg = (C0405Pg) childAt.getLayoutParams();
                AbstractC0327Mg abstractC0327Mg = c0405Pg.a;
                if (abstractC0327Mg != null) {
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    boolean p = abstractC0327Mg.p(this, childAt, view3, i3, i4);
                    z |= p;
                    if (i4 == 0) {
                        c0405Pg.m = p;
                    } else if (i4 == 1) {
                        c0405Pg.n = p;
                    }
                } else {
                    view3 = view;
                    i3 = i;
                    i4 = i2;
                    if (i4 == 0) {
                        c0405Pg.m = false;
                    } else if (i4 == 1) {
                        c0405Pg.n = false;
                    }
                }
            }
            i5++;
            view = view3;
            i = i3;
            i2 = i4;
        }
        return z;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new C0405Pg();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0405Pg(getContext(), attributeSet);
    }

    public final List<View> getDependencySortedChildren() {
        t();
        return Collections.unmodifiableList(this.a);
    }

    public final C4119t40 getLastWindowInsets() {
        return this.n;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        C3827pM c3827pM = this.s;
        return c3827pM.c | c3827pM.b;
    }

    public Drawable getStatusBarBackground() {
        return this.p;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        return Math.max(super.getSuggestedMinimumHeight(), getPaddingBottom() + getPaddingTop());
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        return Math.max(super.getSuggestedMinimumWidth(), getPaddingRight() + getPaddingLeft());
    }

    public final void h(C0405Pg c0405Pg, Rect rect, int i, int i2) {
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0405Pg).leftMargin, Math.min(rect.left, ((width - getPaddingRight()) - i) - ((ViewGroup.MarginLayoutParams) c0405Pg).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0405Pg).topMargin, Math.min(rect.top, ((height - getPaddingBottom()) - i2) - ((ViewGroup.MarginLayoutParams) c0405Pg).bottomMargin));
        rect.set(max, max2, i + max, i2 + max2);
    }

    public final void i(View view, Rect rect, boolean z) {
        if (view.isLayoutRequested() || view.getVisibility() == 8) {
            rect.setEmpty();
        } else if (z) {
            k(view, rect);
        } else {
            rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        }
    }

    public final ArrayList j(View view) {
        C4386wT c4386wT = (C4386wT) this.b.b;
        int i = c4386wT.c;
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < i; i2++) {
            ArrayList arrayList2 = (ArrayList) c4386wT.i(i2);
            if (arrayList2 != null && arrayList2.contains(view)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(c4386wT.f(i2));
            }
        }
        ArrayList arrayList3 = this.d;
        arrayList3.clear();
        if (arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        return arrayList3;
    }

    public final void k(View view, Rect rect) {
        ThreadLocal threadLocal = AbstractC3483l20.a;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        ThreadLocal threadLocal2 = AbstractC3483l20.a;
        Matrix matrix = (Matrix) threadLocal2.get();
        if (matrix == null) {
            matrix = new Matrix();
            threadLocal2.set(matrix);
        } else {
            matrix.reset();
        }
        AbstractC3483l20.a(this, view, matrix);
        ThreadLocal threadLocal3 = AbstractC3483l20.b;
        RectF rectF = (RectF) threadLocal3.get();
        if (rectF == null) {
            rectF = new RectF();
            threadLocal3.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    public final int m(int i) {
        int[] iArr = this.i;
        if (iArr == null) {
            Log.e("CoordinatorLayout", "No keylines defined for " + this + " - attempted index lookup " + i);
            return 0;
        }
        if (i >= 0 && i < iArr.length) {
            return iArr[i];
        }
        Log.e("CoordinatorLayout", "Keyline index " + i + " out of range for " + this);
        return 0;
    }

    public final boolean o(View view, int i, int i2) {
        C3667nK c3667nK = x;
        Rect g = g();
        k(view, g);
        try {
            return g.contains(i, i2);
        } finally {
            g.setEmpty();
            c3667nK.c(g);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        u(false);
        if (this.m) {
            if (this.l == null) {
                this.l = new ViewTreeObserverOnPreDrawListenerC0431Qg(this);
            }
            getViewTreeObserver().addOnPreDrawListener(this.l);
        }
        if (this.n == null) {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            if (getFitsSystemWindows()) {
                requestApplyInsets();
            }
        }
        this.h = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u(false);
        if (this.m && this.l != null) {
            getViewTreeObserver().removeOnPreDrawListener(this.l);
        }
        View view = this.k;
        if (view != null) {
            b(view, 0);
        }
        this.h = false;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.o || this.p == null) {
            return;
        }
        C4119t40 c4119t40 = this.n;
        int d = c4119t40 != null ? c4119t40.d() : 0;
        if (d > 0) {
            this.p.setBounds(0, 0, getWidth(), d);
            this.p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            u(true);
        }
        boolean s = s(motionEvent, 0);
        if (actionMasked != 1 && actionMasked != 3) {
            return s;
        }
        u(true);
        return s;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AbstractC0327Mg abstractC0327Mg;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            View view = (View) arrayList.get(i5);
            if (view.getVisibility() != 8 && ((abstractC0327Mg = ((C0405Pg) view.getLayoutParams()).a) == null || !abstractC0327Mg.h(this, view, layoutDirection))) {
                q(view, layoutDirection);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x018c  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        AbstractC0327Mg abstractC0327Mg;
        int i9;
        View view;
        ArrayList arrayList;
        int i10;
        int i11;
        int i12;
        boolean z2;
        int i13;
        int i14;
        int i15;
        int max;
        CoordinatorLayout coordinatorLayout = this;
        coordinatorLayout.t();
        int childCount = coordinatorLayout.getChildCount();
        int i16 = 0;
        loop0: while (true) {
            if (i16 >= childCount) {
                z = false;
                break;
            }
            View childAt = coordinatorLayout.getChildAt(i16);
            C4386wT c4386wT = (C4386wT) coordinatorLayout.b.b;
            int i17 = c4386wT.c;
            for (int i18 = 0; i18 < i17; i18++) {
                ArrayList arrayList2 = (ArrayList) c4386wT.i(i18);
                if (arrayList2 != null && arrayList2.contains(childAt)) {
                    z = true;
                    break loop0;
                }
            }
            i16++;
        }
        if (z != coordinatorLayout.m) {
            if (z) {
                if (coordinatorLayout.h) {
                    if (coordinatorLayout.l == null) {
                        coordinatorLayout.l = new ViewTreeObserverOnPreDrawListenerC0431Qg(coordinatorLayout);
                    }
                    coordinatorLayout.getViewTreeObserver().addOnPreDrawListener(coordinatorLayout.l);
                }
                coordinatorLayout.m = true;
            } else {
                if (coordinatorLayout.h && coordinatorLayout.l != null) {
                    coordinatorLayout.getViewTreeObserver().removeOnPreDrawListener(coordinatorLayout.l);
                }
                coordinatorLayout.m = false;
            }
        }
        int paddingLeft = coordinatorLayout.getPaddingLeft();
        int paddingTop = coordinatorLayout.getPaddingTop();
        int paddingRight = coordinatorLayout.getPaddingRight();
        int paddingBottom = coordinatorLayout.getPaddingBottom();
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int layoutDirection = coordinatorLayout.getLayoutDirection();
        boolean z3 = layoutDirection == 1;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        int i19 = paddingLeft + paddingRight;
        int i20 = paddingTop + paddingBottom;
        int suggestedMinimumWidth = coordinatorLayout.getSuggestedMinimumWidth();
        int suggestedMinimumHeight = coordinatorLayout.getSuggestedMinimumHeight();
        boolean z4 = coordinatorLayout.n != null && coordinatorLayout.getFitsSystemWindows();
        ArrayList arrayList3 = coordinatorLayout.a;
        int size3 = arrayList3.size();
        int i21 = 0;
        int i22 = 0;
        while (i21 < size3) {
            View view2 = (View) arrayList3.get(i21);
            int i23 = suggestedMinimumWidth;
            if (view2.getVisibility() == 8) {
                arrayList = arrayList3;
                i6 = size3;
                i13 = paddingLeft;
                i11 = paddingRight;
                suggestedMinimumWidth = i23;
                z2 = false;
                i15 = i21;
            } else {
                C0405Pg c0405Pg = (C0405Pg) view2.getLayoutParams();
                int i24 = c0405Pg.e;
                if (i24 < 0 || mode == 0) {
                    i3 = suggestedMinimumHeight;
                } else {
                    int m = coordinatorLayout.m(i24);
                    int i25 = c0405Pg.c;
                    if (i25 == 0) {
                        i25 = 8388661;
                    }
                    int absoluteGravity = Gravity.getAbsoluteGravity(i25, layoutDirection) & 7;
                    i3 = suggestedMinimumHeight;
                    if ((absoluteGravity == 3 && !z3) || (absoluteGravity == 5 && z3)) {
                        max = Math.max(0, (size - paddingRight) - m);
                    } else if ((absoluteGravity == 5 && !z3) || (absoluteGravity == 3 && z3)) {
                        max = Math.max(0, m - paddingLeft);
                    }
                    int i26 = size3;
                    i5 = max;
                    i4 = i26;
                    if (z4 || view2.getFitsSystemWindows()) {
                        i6 = i4;
                        i7 = i;
                        i8 = i2;
                    } else {
                        i6 = i4;
                        int c = coordinatorLayout.n.c() + coordinatorLayout.n.b();
                        int a = coordinatorLayout.n.a() + coordinatorLayout.n.d();
                        i7 = View.MeasureSpec.makeMeasureSpec(size - c, mode);
                        i8 = View.MeasureSpec.makeMeasureSpec(size2 - a, mode2);
                    }
                    abstractC0327Mg = c0405Pg.a;
                    if (abstractC0327Mg == null) {
                        ArrayList arrayList4 = arrayList3;
                        int i27 = i7;
                        arrayList = arrayList4;
                        z2 = false;
                        i11 = paddingRight;
                        i12 = i3;
                        i13 = paddingLeft;
                        i14 = i23;
                        i15 = i21;
                        int i28 = i8;
                        boolean i29 = abstractC0327Mg.i(this, view2, i27, i5, i28);
                        view = view2;
                        i7 = i27;
                        i10 = i5;
                        i9 = i28;
                        if (i29) {
                            coordinatorLayout = this;
                            int max2 = Math.max(i14, view.getMeasuredWidth() + i19 + ((ViewGroup.MarginLayoutParams) c0405Pg).leftMargin + ((ViewGroup.MarginLayoutParams) c0405Pg).rightMargin);
                            int max3 = Math.max(i12, view.getMeasuredHeight() + i20 + ((ViewGroup.MarginLayoutParams) c0405Pg).topMargin + ((ViewGroup.MarginLayoutParams) c0405Pg).bottomMargin);
                            i22 = View.combineMeasuredStates(i22, view.getMeasuredState());
                            suggestedMinimumWidth = max2;
                            suggestedMinimumHeight = max3;
                        }
                    } else {
                        int i30 = i5;
                        i9 = i8;
                        view = view2;
                        arrayList = arrayList3;
                        i10 = i30;
                        i11 = paddingRight;
                        i12 = i3;
                        z2 = false;
                        i13 = paddingLeft;
                        i14 = i23;
                        i15 = i21;
                    }
                    coordinatorLayout = this;
                    coordinatorLayout.measureChildWithMargins(view, i7, i10, i9, 0);
                    int max22 = Math.max(i14, view.getMeasuredWidth() + i19 + ((ViewGroup.MarginLayoutParams) c0405Pg).leftMargin + ((ViewGroup.MarginLayoutParams) c0405Pg).rightMargin);
                    int max32 = Math.max(i12, view.getMeasuredHeight() + i20 + ((ViewGroup.MarginLayoutParams) c0405Pg).topMargin + ((ViewGroup.MarginLayoutParams) c0405Pg).bottomMargin);
                    i22 = View.combineMeasuredStates(i22, view.getMeasuredState());
                    suggestedMinimumWidth = max22;
                    suggestedMinimumHeight = max32;
                }
                i4 = size3;
                i5 = 0;
                if (z4) {
                }
                i6 = i4;
                i7 = i;
                i8 = i2;
                abstractC0327Mg = c0405Pg.a;
                if (abstractC0327Mg == null) {
                }
                coordinatorLayout = this;
                coordinatorLayout.measureChildWithMargins(view, i7, i10, i9, 0);
                int max222 = Math.max(i14, view.getMeasuredWidth() + i19 + ((ViewGroup.MarginLayoutParams) c0405Pg).leftMargin + ((ViewGroup.MarginLayoutParams) c0405Pg).rightMargin);
                int max322 = Math.max(i12, view.getMeasuredHeight() + i20 + ((ViewGroup.MarginLayoutParams) c0405Pg).topMargin + ((ViewGroup.MarginLayoutParams) c0405Pg).bottomMargin);
                i22 = View.combineMeasuredStates(i22, view.getMeasuredState());
                suggestedMinimumWidth = max222;
                suggestedMinimumHeight = max322;
            }
            i21 = i15 + 1;
            arrayList3 = arrayList;
            size3 = i6;
            paddingLeft = i13;
            paddingRight = i11;
        }
        coordinatorLayout.setMeasuredDimension(View.resolveSizeAndState(suggestedMinimumWidth, i, (-16777216) & i22), View.resolveSizeAndState(suggestedMinimumHeight, i2, i22 << 16));
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f2, boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0405Pg c0405Pg = (C0405Pg) childAt.getLayoutParams();
                if (c0405Pg.a(0)) {
                    AbstractC0327Mg abstractC0327Mg = c0405Pg.a;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f2) {
        AbstractC0327Mg abstractC0327Mg;
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() != 8) {
                C0405Pg c0405Pg = (C0405Pg) childAt.getLayoutParams();
                if (c0405Pg.a(0) && (abstractC0327Mg = c0405Pg.a) != null) {
                    z |= abstractC0327Mg.j(view);
                }
            }
        }
        return z;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        c(view, i, i2, iArr, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        e(view, i, i2, i3, i4, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        a(view, view2, i, 0);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof C0457Rg)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        C0457Rg c0457Rg = (C0457Rg) parcelable;
        super.onRestoreInstanceState(c0457Rg.a);
        SparseArray sparseArray = c0457Rg.c;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            AbstractC0327Mg abstractC0327Mg = n(childAt).a;
            if (id != -1 && abstractC0327Mg != null && (parcelable2 = (Parcelable) sparseArray.get(id)) != null) {
                abstractC0327Mg.n(childAt, parcelable2);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable o;
        C0457Rg c0457Rg = new C0457Rg(super.onSaveInstanceState());
        SparseArray sparseArray = new SparseArray();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int id = childAt.getId();
            AbstractC0327Mg abstractC0327Mg = ((C0405Pg) childAt.getLayoutParams()).a;
            if (id != -1 && abstractC0327Mg != null && (o = abstractC0327Mg.o(childAt)) != null) {
                sparseArray.append(id, o);
            }
        }
        c0457Rg.c = sparseArray;
        return c0457Rg;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return f(view, view2, i, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        b(view, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0012, code lost:
    
        if (r3 != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002f  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean r;
        MotionEvent motionEvent2;
        int actionMasked = motionEvent.getActionMasked();
        if (this.j == null) {
            z = s(motionEvent, 1);
        } else {
            z = false;
        }
        AbstractC0327Mg abstractC0327Mg = ((C0405Pg) this.j.getLayoutParams()).a;
        if (abstractC0327Mg != null) {
            r = abstractC0327Mg.r(this, this.j, motionEvent);
            motionEvent2 = null;
            if (this.j != null) {
                r |= super.onTouchEvent(motionEvent);
            } else if (z) {
                long uptimeMillis = SystemClock.uptimeMillis();
                motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                super.onTouchEvent(motionEvent2);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            if (actionMasked == 1 && actionMasked != 3) {
                return r;
            }
            u(false);
            return r;
        }
        r = false;
        motionEvent2 = null;
        if (this.j != null) {
        }
        if (motionEvent2 != null) {
        }
        if (actionMasked == 1) {
        }
        u(false);
        return r;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0291 A[EDGE_INSN: B:133:0x0291->B:105:0x0291 BREAK  A[LOOP:2: B:110:0x02a9->B:121:0x02e5], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p(int i) {
        Rect rect;
        int i2;
        Rect rect2;
        int i3;
        int i4;
        ArrayList arrayList;
        int i5;
        boolean z;
        boolean z2;
        boolean z3;
        int width;
        int i6;
        int i7;
        int i8;
        int height;
        int i9;
        int i10;
        int i11;
        int i12;
        ArrayList arrayList2;
        Rect rect3;
        Rect rect4;
        int i13;
        C3667nK c3667nK;
        int i14;
        AbstractC0327Mg abstractC0327Mg;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        int layoutDirection = getLayoutDirection();
        ArrayList arrayList3 = this.a;
        int size = arrayList3.size();
        Rect g = g();
        Rect g2 = g();
        Rect g3 = g();
        int i15 = 0;
        while (true) {
            C3667nK c3667nK2 = x;
            if (i15 >= size) {
                Rect rect5 = g2;
                Rect rect6 = g3;
                g.setEmpty();
                c3667nK2.c(g);
                rect5.setEmpty();
                c3667nK2.c(rect5);
                rect6.setEmpty();
                c3667nK2.c(rect6);
                return;
            }
            View view = (View) arrayList3.get(i15);
            C0405Pg c0405Pg = (C0405Pg) view.getLayoutParams();
            if (i == 0 && view.getVisibility() == 8) {
                int i16 = size;
                arrayList = arrayList3;
                i4 = i16;
                rect = g2;
                rect2 = g3;
                i2 = i15;
            } else {
                int i17 = 0;
                while (i17 < i15) {
                    if (c0405Pg.l == ((View) arrayList3.get(i17))) {
                        C0405Pg c0405Pg2 = (C0405Pg) view.getLayoutParams();
                        if (c0405Pg2.k != null) {
                            rect3 = g2;
                            Rect g4 = g();
                            Rect g5 = g();
                            Rect rect7 = g3;
                            Rect g6 = g();
                            i12 = i17;
                            k(c0405Pg2.k, g4);
                            i(view, g5, false);
                            i13 = i15;
                            int measuredWidth = view.getMeasuredWidth();
                            C3667nK c3667nK3 = c3667nK2;
                            int measuredHeight = view.getMeasuredHeight();
                            c3667nK = c3667nK3;
                            arrayList2 = arrayList3;
                            l(layoutDirection, g4, g6, c0405Pg2, measuredWidth, measuredHeight);
                            i14 = size;
                            rect4 = rect7;
                            boolean z4 = (g6.left == g5.left && g6.top == g5.top) ? false : true;
                            h(c0405Pg2, g6, measuredWidth, measuredHeight);
                            int i18 = g6.left - g5.left;
                            int i19 = g6.top - g5.top;
                            if (i18 != 0) {
                                WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                                view.offsetLeftAndRight(i18);
                            }
                            if (i19 != 0) {
                                WeakHashMap weakHashMap3 = AbstractC2925e20.a;
                                view.offsetTopAndBottom(i19);
                            }
                            if (z4 && (abstractC0327Mg = c0405Pg2.a) != null) {
                                abstractC0327Mg.d(this, view, c0405Pg2.k);
                            }
                            g4.setEmpty();
                            c3667nK.c(g4);
                            g5.setEmpty();
                            c3667nK.c(g5);
                            g6.setEmpty();
                            c3667nK.c(g6);
                            c3667nK2 = c3667nK;
                            i17 = i12 + 1;
                            g2 = rect3;
                            i15 = i13;
                            arrayList3 = arrayList2;
                            size = i14;
                            g3 = rect4;
                        }
                    }
                    i12 = i17;
                    arrayList2 = arrayList3;
                    rect3 = g2;
                    rect4 = g3;
                    i13 = i15;
                    c3667nK = c3667nK2;
                    i14 = size;
                    c3667nK2 = c3667nK;
                    i17 = i12 + 1;
                    g2 = rect3;
                    i15 = i13;
                    arrayList3 = arrayList2;
                    size = i14;
                    g3 = rect4;
                }
                ArrayList arrayList4 = arrayList3;
                rect = g2;
                Rect rect8 = g3;
                i2 = i15;
                C3588mK c3588mK = c3667nK2;
                int i20 = size;
                i(view, rect, true);
                if (c0405Pg.g != 0 && !rect.isEmpty()) {
                    int absoluteGravity = Gravity.getAbsoluteGravity(c0405Pg.g, layoutDirection);
                    int i21 = absoluteGravity & 112;
                    if (i21 == 48) {
                        g.top = Math.max(g.top, rect.bottom);
                    } else if (i21 == 80) {
                        g.bottom = Math.max(g.bottom, getHeight() - rect.top);
                    }
                    int i22 = absoluteGravity & 7;
                    if (i22 == 3) {
                        g.left = Math.max(g.left, rect.right);
                    } else if (i22 == 5) {
                        g.right = Math.max(g.right, getWidth() - rect.left);
                    }
                }
                if (c0405Pg.h != 0 && view.getVisibility() == 0) {
                    WeakHashMap weakHashMap4 = AbstractC2925e20.a;
                    if (view.isLaidOut() && view.getWidth() > 0 && view.getHeight() > 0) {
                        C0405Pg c0405Pg3 = (C0405Pg) view.getLayoutParams();
                        AbstractC0327Mg abstractC0327Mg2 = c0405Pg3.a;
                        Rect g7 = g();
                        Rect g8 = g();
                        g8.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
                        if (abstractC0327Mg2 == null || !abstractC0327Mg2.a(view)) {
                            g7.set(g8);
                        } else if (!g8.contains(g7)) {
                            throw new IllegalArgumentException("Rect should be within the child's bounds. Rect:" + g7.toShortString() + " | Bounds:" + g8.toShortString());
                        }
                        g8.setEmpty();
                        c3588mK.c(g8);
                        if (!g7.isEmpty()) {
                            int absoluteGravity2 = Gravity.getAbsoluteGravity(c0405Pg3.h, layoutDirection);
                            if ((absoluteGravity2 & 48) != 48 || (i10 = (g7.top - ((ViewGroup.MarginLayoutParams) c0405Pg3).topMargin) - c0405Pg3.j) >= (i11 = g.top)) {
                                z2 = false;
                            } else {
                                w(view, i11 - i10);
                                z2 = true;
                            }
                            if ((absoluteGravity2 & 80) == 80 && (height = ((getHeight() - g7.bottom) - ((ViewGroup.MarginLayoutParams) c0405Pg3).bottomMargin) + c0405Pg3.j) < (i9 = g.bottom)) {
                                w(view, height - i9);
                                z2 = true;
                            }
                            if (!z2) {
                                w(view, 0);
                            }
                            if ((absoluteGravity2 & 3) != 3 || (i7 = (g7.left - ((ViewGroup.MarginLayoutParams) c0405Pg3).leftMargin) - c0405Pg3.i) >= (i8 = g.left)) {
                                z3 = false;
                            } else {
                                v(view, i8 - i7);
                                z3 = true;
                            }
                            if ((absoluteGravity2 & 5) == 5 && (width = ((getWidth() - g7.right) - ((ViewGroup.MarginLayoutParams) c0405Pg3).rightMargin) + c0405Pg3.i) < (i6 = g.right)) {
                                v(view, width - i6);
                                z3 = true;
                            }
                            if (!z3) {
                                v(view, 0);
                            }
                            g7.setEmpty();
                            c3588mK.c(g7);
                            if (i == 2) {
                                rect2 = rect8;
                                rect2.set(((C0405Pg) view.getLayoutParams()).p);
                                if (rect2.equals(rect)) {
                                    arrayList = arrayList4;
                                    i4 = i20;
                                } else {
                                    ((C0405Pg) view.getLayoutParams()).p.set(rect);
                                }
                            } else {
                                rect2 = rect8;
                            }
                            i3 = i2 + 1;
                            i4 = i20;
                            while (true) {
                                arrayList = arrayList4;
                                if (i3 < i4) {
                                    break;
                                }
                                View view2 = (View) arrayList.get(i3);
                                C0405Pg c0405Pg4 = (C0405Pg) view2.getLayoutParams();
                                AbstractC0327Mg abstractC0327Mg3 = c0405Pg4.a;
                                if (abstractC0327Mg3 == null || !abstractC0327Mg3.b(view2, view)) {
                                    i5 = 1;
                                } else if (i == 0 && c0405Pg4.o) {
                                    c0405Pg4.o = false;
                                    i5 = 1;
                                } else {
                                    if (i != 2) {
                                        z = abstractC0327Mg3.d(this, view2, view);
                                    } else {
                                        abstractC0327Mg3.e(this, view);
                                        z = true;
                                    }
                                    i5 = 1;
                                    if (i == 1) {
                                        c0405Pg4.o = z;
                                    }
                                }
                                i3 += i5;
                                arrayList4 = arrayList;
                            }
                        } else {
                            g7.setEmpty();
                            c3588mK.c(g7);
                        }
                    }
                }
                if (i == 2) {
                }
                i3 = i2 + 1;
                i4 = i20;
                while (true) {
                    arrayList = arrayList4;
                    if (i3 < i4) {
                    }
                    i3 += i5;
                    arrayList4 = arrayList;
                }
            }
            i15 = i2 + 1;
            ArrayList arrayList5 = arrayList;
            size = i4;
            arrayList3 = arrayList5;
            g3 = rect2;
            g2 = rect;
        }
    }

    public final void q(View view, int i) {
        Rect g;
        Rect g2;
        C0405Pg c0405Pg = (C0405Pg) view.getLayoutParams();
        View view2 = c0405Pg.k;
        if (view2 == null && c0405Pg.f != -1) {
            throw new IllegalStateException("An anchor may not be changed after CoordinatorLayout measurement begins before layout is complete.");
        }
        C3667nK c3667nK = x;
        if (view2 != null) {
            g = g();
            g2 = g();
            try {
                k(view2, g);
                C0405Pg c0405Pg2 = (C0405Pg) view.getLayoutParams();
                int measuredWidth = view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight();
                l(i, g, g2, c0405Pg2, measuredWidth, measuredHeight);
                h(c0405Pg2, g2, measuredWidth, measuredHeight);
                view.layout(g2.left, g2.top, g2.right, g2.bottom);
                return;
            } finally {
                g.setEmpty();
                c3667nK.c(g);
                g2.setEmpty();
                c3667nK.c(g2);
            }
        }
        int i2 = c0405Pg.e;
        if (i2 < 0) {
            C0405Pg c0405Pg3 = (C0405Pg) view.getLayoutParams();
            g = g();
            g.set(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0405Pg3).leftMargin, getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0405Pg3).topMargin, (getWidth() - getPaddingRight()) - ((ViewGroup.MarginLayoutParams) c0405Pg3).rightMargin, (getHeight() - getPaddingBottom()) - ((ViewGroup.MarginLayoutParams) c0405Pg3).bottomMargin);
            if (this.n != null) {
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                if (getFitsSystemWindows() && !view.getFitsSystemWindows()) {
                    g.left = this.n.b() + g.left;
                    g.top = this.n.d() + g.top;
                    g.right -= this.n.c();
                    g.bottom -= this.n.a();
                }
            }
            g2 = g();
            int i3 = c0405Pg3.c;
            if ((i3 & 7) == 0) {
                i3 |= 8388611;
            }
            if ((i3 & 112) == 0) {
                i3 |= 48;
            }
            Gravity.apply(i3, view.getMeasuredWidth(), view.getMeasuredHeight(), g, g2, i);
            view.layout(g2.left, g2.top, g2.right, g2.bottom);
            return;
        }
        C0405Pg c0405Pg4 = (C0405Pg) view.getLayoutParams();
        int i4 = c0405Pg4.c;
        if (i4 == 0) {
            i4 = 8388661;
        }
        int absoluteGravity = Gravity.getAbsoluteGravity(i4, i);
        int i5 = absoluteGravity & 7;
        int i6 = absoluteGravity & 112;
        int width = getWidth();
        int height = getHeight();
        int measuredWidth2 = view.getMeasuredWidth();
        int measuredHeight2 = view.getMeasuredHeight();
        if (i == 1) {
            i2 = width - i2;
        }
        int m = m(i2) - measuredWidth2;
        if (i5 == 1) {
            m += measuredWidth2 / 2;
        } else if (i5 == 5) {
            m += measuredWidth2;
        }
        int i7 = i6 != 16 ? i6 != 80 ? 0 : measuredHeight2 : measuredHeight2 / 2;
        int max = Math.max(getPaddingLeft() + ((ViewGroup.MarginLayoutParams) c0405Pg4).leftMargin, Math.min(m, ((width - getPaddingRight()) - measuredWidth2) - ((ViewGroup.MarginLayoutParams) c0405Pg4).rightMargin));
        int max2 = Math.max(getPaddingTop() + ((ViewGroup.MarginLayoutParams) c0405Pg4).topMargin, Math.min(i7, ((height - getPaddingBottom()) - measuredHeight2) - ((ViewGroup.MarginLayoutParams) c0405Pg4).bottomMargin));
        view.layout(max, max2, measuredWidth2 + max, measuredHeight2 + max2);
    }

    public final void r(View view, int i, int i2, int i3) {
        measureChildWithMargins(view, i, i2, i3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        AbstractC0327Mg abstractC0327Mg = ((C0405Pg) view.getLayoutParams()).a;
        if (abstractC0327Mg == null || !abstractC0327Mg.m(this, view, rect, z)) {
            return super.requestChildRectangleOnScreen(view, rect, z);
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        if (!z || this.g) {
            return;
        }
        u(false);
        this.g = true;
    }

    public final boolean s(MotionEvent motionEvent, int i) {
        int actionMasked = motionEvent.getActionMasked();
        ArrayList arrayList = this.c;
        arrayList.clear();
        boolean isChildrenDrawingOrderEnabled = isChildrenDrawingOrderEnabled();
        int childCount = getChildCount();
        for (int i2 = childCount - 1; i2 >= 0; i2--) {
            arrayList.add(getChildAt(isChildrenDrawingOrderEnabled ? getChildDrawingOrder(childCount, i2) : i2));
        }
        C3092g6 c3092g6 = w;
        if (c3092g6 != null) {
            Collections.sort(arrayList, c3092g6);
        }
        int size = arrayList.size();
        MotionEvent motionEvent2 = null;
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            View view = (View) arrayList.get(i3);
            AbstractC0327Mg abstractC0327Mg = ((C0405Pg) view.getLayoutParams()).a;
            if (z && actionMasked != 0) {
                if (abstractC0327Mg != null) {
                    if (motionEvent2 == null) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        motionEvent2 = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    }
                    if (i == 0) {
                        abstractC0327Mg.g(this, view, motionEvent2);
                    } else if (i == 1) {
                        abstractC0327Mg.r(this, view, motionEvent2);
                    }
                }
            } else if (!z && abstractC0327Mg != null) {
                if (i == 0) {
                    z = abstractC0327Mg.g(this, view, motionEvent);
                } else if (i == 1) {
                    z = abstractC0327Mg.r(this, view, motionEvent);
                }
                if (z) {
                    this.j = view;
                }
            }
        }
        arrayList.clear();
        return z;
    }

    @Override // android.view.View
    public void setFitsSystemWindows(boolean z) {
        super.setFitsSystemWindows(z);
        x();
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.q = onHierarchyChangeListener;
    }

    public void setStatusBarBackground(Drawable drawable) {
        Drawable drawable2 = this.p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.p = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.p.setState(getDrawableState());
                }
                Drawable drawable3 = this.p;
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                drawable3.setLayoutDirection(getLayoutDirection());
                this.p.setVisible(getVisibility() == 0, false);
                this.p.setCallback(this);
            }
            WeakHashMap weakHashMap2 = AbstractC2925e20.a;
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarBackgroundColor(int i) {
        setStatusBarBackground(new ColorDrawable(i));
    }

    public void setStatusBarBackgroundResource(int i) {
        setStatusBarBackground(i != 0 ? getContext().getDrawable(i) : null);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.p;
        if (drawable == null || drawable.isVisible() == z) {
            return;
        }
        this.p.setVisible(z, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00f9, code lost:
    
        if ((android.view.Gravity.getAbsoluteGravity(r8.h, r12) & r13) == r13) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0146, code lost:
    
        throw new java.lang.IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void t() {
        C3588mK c3588mK;
        ArrayList arrayList = this.a;
        arrayList.clear();
        NX nx = this.b;
        C4386wT c4386wT = (C4386wT) nx.b;
        int i = c4386wT.c;
        int i2 = 0;
        while (true) {
            c3588mK = (C3588mK) nx.a;
            if (i2 >= i) {
                break;
            }
            ArrayList arrayList2 = (ArrayList) c4386wT.i(i2);
            if (arrayList2 != null) {
                arrayList2.clear();
                c3588mK.c(arrayList2);
            }
            i2++;
        }
        c4386wT.clear();
        int childCount = getChildCount();
        int i3 = 0;
        loop1: while (true) {
            C4386wT c4386wT2 = (C4386wT) nx.b;
            if (i3 >= childCount) {
                ArrayList arrayList3 = (ArrayList) nx.c;
                arrayList3.clear();
                HashSet hashSet = (HashSet) nx.d;
                hashSet.clear();
                int i4 = c4386wT2.c;
                for (int i5 = 0; i5 < i4; i5++) {
                    nx.d(c4386wT2.f(i5), arrayList3, hashSet);
                }
                arrayList.addAll(arrayList3);
                Collections.reverse(arrayList);
                return;
            }
            View childAt = getChildAt(i3);
            C0405Pg n = n(childAt);
            int i6 = n.f;
            if (i6 == -1) {
                n.l = null;
                n.k = null;
            } else {
                View view = n.k;
                if (view != null && view.getId() == i6) {
                    View view2 = n.k;
                    for (ViewParent parent = view2.getParent(); parent != this; parent = parent.getParent()) {
                        if (parent == null || parent == childAt) {
                            n.l = null;
                            n.k = null;
                        } else {
                            if (parent instanceof View) {
                                view2 = parent;
                            }
                        }
                    }
                    n.l = view2;
                }
                View findViewById = findViewById(i6);
                n.k = findViewById;
                if (findViewById == null) {
                    if (!isInEditMode()) {
                        throw new IllegalStateException("Could not find CoordinatorLayout descendant view with id " + getResources().getResourceName(i6) + " to anchor view " + childAt);
                    }
                    n.l = null;
                    n.k = null;
                } else if (findViewById != this) {
                    for (ViewParent parent2 = findViewById.getParent(); parent2 != this && parent2 != null; parent2 = parent2.getParent()) {
                        if (parent2 != childAt) {
                            if (parent2 instanceof View) {
                                findViewById = parent2;
                            }
                        } else {
                            if (!isInEditMode()) {
                                throw new IllegalStateException("Anchor must not be a descendant of the anchored view");
                            }
                            n.l = null;
                            n.k = null;
                        }
                    }
                    n.l = findViewById;
                } else {
                    if (!isInEditMode()) {
                        throw new IllegalStateException("View can not be anchored to the the parent CoordinatorLayout");
                    }
                    n.l = null;
                    n.k = null;
                }
            }
            if (!c4386wT2.containsKey(childAt)) {
                c4386wT2.put(childAt, null);
            }
            for (int i7 = 0; i7 < childCount; i7++) {
                if (i7 != i3) {
                    View childAt2 = getChildAt(i7);
                    if (childAt2 != n.l) {
                        WeakHashMap weakHashMap = AbstractC2925e20.a;
                        int layoutDirection = getLayoutDirection();
                        int absoluteGravity = Gravity.getAbsoluteGravity(((C0405Pg) childAt2.getLayoutParams()).g, layoutDirection);
                        if (absoluteGravity != 0) {
                        }
                        AbstractC0327Mg abstractC0327Mg = n.a;
                        if (abstractC0327Mg == null) {
                            continue;
                        } else if (!abstractC0327Mg.b(childAt, childAt2)) {
                            continue;
                        }
                    }
                    if (!c4386wT2.containsKey(childAt2) && !c4386wT2.containsKey(childAt2)) {
                        c4386wT2.put(childAt2, null);
                    }
                    if (!c4386wT2.containsKey(childAt2) || !c4386wT2.containsKey(childAt)) {
                        break loop1;
                    }
                    ArrayList arrayList4 = (ArrayList) c4386wT2.get(childAt2);
                    if (arrayList4 == null) {
                        arrayList4 = (ArrayList) c3588mK.a();
                        if (arrayList4 == null) {
                            arrayList4 = new ArrayList();
                        }
                        c4386wT2.put(childAt2, arrayList4);
                    }
                    arrayList4.add(childAt);
                }
            }
            i3++;
        }
    }

    public final void u(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            AbstractC0327Mg abstractC0327Mg = ((C0405Pg) childAt.getLayoutParams()).a;
            if (abstractC0327Mg != null) {
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                if (z) {
                    abstractC0327Mg.g(this, childAt, obtain);
                } else {
                    abstractC0327Mg.r(this, childAt, obtain);
                }
                obtain.recycle();
            }
        }
        for (int i2 = 0; i2 < childCount; i2++) {
            ((C0405Pg) getChildAt(i2).getLayoutParams()).getClass();
        }
        this.j = null;
        this.g = false;
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.p;
    }

    public final void x() {
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        if (!getFitsSystemWindows()) {
            W10.c(this, null);
            return;
        }
        if (this.r == null) {
            this.r = new C2835cv(this, 11);
        }
        W10.c(this, this.r);
        setSystemUiVisibility(1280);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0405Pg ? new C0405Pg((C0405Pg) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new C0405Pg((ViewGroup.MarginLayoutParams) layoutParams) : new C0405Pg(layoutParams);
    }
}
