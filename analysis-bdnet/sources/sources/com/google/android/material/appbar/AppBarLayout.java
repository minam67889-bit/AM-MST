package com.google.android.material.appbar;

import android.animation.AnimatorInflater;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.AbsSavedState;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.gms.ads.AdSize;
import com.google.android.material.appbar.AppBarLayout;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0161Fv;
import defpackage.AbstractC0187Gv;
import defpackage.AbstractC0325Me;
import defpackage.AbstractC0327Mg;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC0731aZ;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3131gc0;
import defpackage.AbstractC3159h;
import defpackage.AbstractC3634my;
import defpackage.AbstractC4434x4;
import defpackage.C0405Pg;
import defpackage.C2835cv;
import defpackage.C4119t40;
import defpackage.C4386wT;
import defpackage.E4;
import defpackage.F4;
import defpackage.FM;
import defpackage.InterfaceC0302Lg;
import defpackage.JE;
import defpackage.JH;
import defpackage.ML;
import defpackage.R9;
import defpackage.W10;
import defpackage.W80;
import defpackage.XE;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout implements InterfaceC0302Lg {
    public static final /* synthetic */ int A = 0;
    public int a;
    public int b;
    public int c;
    public int d;
    public boolean e;
    public int f;
    public C4119t40 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public ColorStateList l;
    public int m;
    public WeakReference n;
    public ValueAnimator o;
    public ValueAnimator.AnimatorUpdateListener p;
    public final ArrayList q;
    public final LinkedHashSet r;
    public final long s;
    public final TimeInterpolator t;
    public int[] u;
    public int v;
    public Drawable w;
    public Integer x;
    public final float y;
    public Behavior z;

    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class ScrollingViewBehavior extends AbstractC0187Gv {
        public ScrollingViewBehavior() {
        }

        public static AppBarLayout v(ArrayList arrayList) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                View view = (View) arrayList.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }

        @Override // defpackage.AbstractC0327Mg
        public final boolean b(View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // defpackage.AbstractC0327Mg
        public boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            AbstractC0327Mg abstractC0327Mg = ((C0405Pg) view2.getLayoutParams()).a;
            if (abstractC0327Mg instanceof BaseBehavior) {
                int bottom = (((view2.getBottom() - view.getTop()) + ((BaseBehavior) abstractC0327Mg).j) + this.e) - u(view2);
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                view.offsetTopAndBottom(bottom);
            }
            if (!(view2 instanceof AppBarLayout)) {
                return false;
            }
            AppBarLayout appBarLayout = (AppBarLayout) view2;
            if (!appBarLayout.k) {
                return false;
            }
            appBarLayout.e(appBarLayout.f(view));
            return false;
        }

        @Override // defpackage.AbstractC0327Mg
        public final void e(CoordinatorLayout coordinatorLayout, View view) {
            if (view instanceof AppBarLayout) {
                AbstractC2925e20.m(coordinatorLayout, null);
            }
        }

        @Override // defpackage.AbstractC0327Mg
        public final boolean m(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout v = v(coordinatorLayout.j(view));
            if (v != null) {
                Rect rect2 = new Rect(rect);
                rect2.offset(view.getLeft(), view.getTop());
                int width = coordinatorLayout.getWidth();
                int height = coordinatorLayout.getHeight();
                Rect rect3 = this.c;
                rect3.set(0, 0, width, height);
                if (!rect3.contains(rect2)) {
                    v.d(false, !z, true);
                    return true;
                }
            }
            return false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.z);
            this.f = obtainStyledAttributes.getDimensionPixelSize(0, 0);
            obtainStyledAttributes.recycle();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(XE.B(context, attributeSet, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout), attributeSet, R.attr.appBarLayoutStyle);
        int i = 5;
        this.b = -1;
        this.c = -1;
        this.d = -1;
        this.f = 0;
        this.q = new ArrayList();
        this.r = new LinkedHashSet();
        Context context2 = getContext();
        setOrientation(1);
        if (getOutlineProvider() == ViewOutlineProvider.BACKGROUND) {
            setOutlineProvider(ViewOutlineProvider.BOUNDS);
        }
        Context context3 = getContext();
        TypedArray G = AbstractC0641Yi.G(context3, attributeSet, AbstractC0731aZ.j, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
        try {
            if (G.hasValue(0)) {
                setStateListAnimator(AnimatorInflater.loadStateListAnimator(context3, G.getResourceId(0, 0)));
            }
            G.recycle();
            TypedArray G2 = AbstractC0641Yi.G(context2, attributeSet, FM.a, R.attr.appBarLayoutStyle, R.style.Widget_Design_AppBarLayout, new int[0]);
            this.l = W80.s(context2, G2, 6);
            this.s = AbstractC0731aZ.a0(context2, R.attr.motionDurationMedium2, getResources().getInteger(R.integer.app_bar_elevation_anim_duration));
            this.t = AbstractC0731aZ.b0(context2, R.attr.motionEasingStandardInterpolator, AbstractC4434x4.a);
            if (G2.hasValue(4)) {
                d(G2.getBoolean(4, false), false, false);
            }
            if (G2.hasValue(3)) {
                AbstractC0731aZ.e0(this, G2.getDimensionPixelSize(3, 0));
            }
            setBackground(G2.getDrawable(0));
            if (Build.VERSION.SDK_INT >= 26) {
                if (G2.hasValue(2)) {
                    setKeyboardNavigationCluster(G2.getBoolean(2, false));
                }
                if (G2.hasValue(1)) {
                    setTouchscreenBlocksFocus(G2.getBoolean(1, false));
                }
            }
            this.y = getResources().getDimension(R.dimen.design_appbar_elevation);
            this.k = G2.getBoolean(5, false);
            this.m = G2.getResourceId(7, -1);
            setStatusBarForeground(G2.getDrawable(8));
            G2.recycle();
            C2835cv c2835cv = new C2835cv(this, i);
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            W10.c(this, c2835cv);
        } catch (Throwable th) {
            G.recycle();
            throw th;
        }
    }

    public static F4 b(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            F4 f4 = new F4((LinearLayout.LayoutParams) layoutParams);
            f4.a = 1;
            return f4;
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            F4 f42 = new F4((ViewGroup.MarginLayoutParams) layoutParams);
            f42.a = 1;
            return f42;
        }
        F4 f43 = new F4(layoutParams);
        f43.a = 1;
        return f43;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final F4 generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        F4 f4 = new F4(context, attributeSet);
        f4.a = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.b);
        f4.a = obtainStyledAttributes.getInt(1, 0);
        f4.b = obtainStyledAttributes.getInt(0, 0) != 1 ? null : new ML(8);
        if (obtainStyledAttributes.hasValue(2)) {
            f4.c = AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(2, 0));
        }
        obtainStyledAttributes.recycle();
        return f4;
    }

    public final void c() {
        Behavior behavior = this.z;
        d B = (behavior == null || this.b == -1 || this.f != 0) ? null : behavior.B(AbstractC3159h.b, this);
        this.b = -1;
        this.c = -1;
        this.d = -1;
        if (B != null) {
            Behavior behavior2 = this.z;
            if (behavior2.m != null) {
                return;
            }
            behavior2.m = B;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof F4;
    }

    public final void d(boolean z, boolean z2, boolean z3) {
        this.f = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.w == null || getTopInset() <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(0.0f, -this.a);
        this.w.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.w;
        if (drawable != null && drawable.isStateful() && drawable.setState(drawableState)) {
            invalidateDrawable(drawable);
        }
    }

    public final boolean e(boolean z) {
        if (this.h || this.j == z) {
            return false;
        }
        this.j = z;
        refreshDrawableState();
        if (!(getBackground() instanceof JE)) {
            return true;
        }
        if (this.l != null) {
            g(z ? 0.0f : 1.0f, z ? 1.0f : 0.0f);
            return true;
        }
        if (!this.k) {
            return true;
        }
        float f = this.y;
        g(z ? 0.0f : f, z ? f : 0.0f);
        return true;
    }

    public final boolean f(View view) {
        int i;
        if (this.n == null && (i = this.m) != -1) {
            View findViewById = view != null ? view.findViewById(i) : null;
            if (findViewById == null && (getParent() instanceof ViewGroup)) {
                findViewById = ((ViewGroup) getParent()).findViewById(this.m);
            }
            if (findViewById != null) {
                this.n = new WeakReference(findViewById);
            }
        }
        WeakReference weakReference = this.n;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view = view2;
        }
        if (view != null) {
            return view.canScrollVertically(-1) || view.getScrollY() > 0;
        }
        return false;
    }

    public final void g(float f, float f2) {
        ValueAnimator valueAnimator = this.o;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f, f2);
        this.o = ofFloat;
        ofFloat.setDuration(this.s);
        this.o.setInterpolator(this.t);
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.p;
        if (animatorUpdateListener != null) {
            this.o.addUpdateListener(animatorUpdateListener);
        }
        this.o.start();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        F4 f4 = new F4(-1, -2);
        f4.a = 1;
        return f4;
    }

    @Override // defpackage.InterfaceC0302Lg
    public AbstractC0327Mg getBehavior() {
        Behavior behavior = new Behavior();
        this.z = behavior;
        return behavior;
    }

    public int getDownNestedPreScrollRange() {
        int i;
        int minimumHeight;
        int i2 = this.c;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() != 8) {
                F4 f4 = (F4) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = f4.a;
                if ((i4 & 5) != 5) {
                    if (i3 > 0) {
                        break;
                    }
                } else {
                    int i5 = ((LinearLayout.LayoutParams) f4).topMargin + ((LinearLayout.LayoutParams) f4).bottomMargin;
                    if ((i4 & 8) != 0) {
                        minimumHeight = childAt.getMinimumHeight();
                    } else if ((i4 & 2) != 0) {
                        minimumHeight = measuredHeight - childAt.getMinimumHeight();
                    } else {
                        i = i5 + measuredHeight;
                        if (childCount == 0 && childAt.getFitsSystemWindows()) {
                            i = Math.min(i, measuredHeight - getTopInset());
                        }
                        i3 += i;
                    }
                    i = minimumHeight + i5;
                    if (childCount == 0) {
                        i = Math.min(i, measuredHeight - getTopInset());
                    }
                    i3 += i;
                }
            }
        }
        int max = Math.max(0, i3);
        this.c = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.d;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                F4 f4 = (F4) childAt.getLayoutParams();
                int measuredHeight = ((LinearLayout.LayoutParams) f4).topMargin + ((LinearLayout.LayoutParams) f4).bottomMargin + childAt.getMeasuredHeight();
                int i4 = f4.a;
                if ((i4 & 1) == 0) {
                    break;
                }
                i3 += measuredHeight;
                if ((i4 & 2) != 0) {
                    i3 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.d = max;
        return max;
    }

    public int getLiftOnScrollTargetViewId() {
        return this.m;
    }

    public JE getMaterialShapeBackground() {
        Drawable background = getBackground();
        if (background instanceof JE) {
            return (JE) background;
        }
        return null;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = getMinimumHeight();
        if (minimumHeight != 0) {
            int i = (minimumHeight * 2) + topInset;
            return i < getHeight() ? i : minimumHeight + topInset;
        }
        int childCount = getChildCount();
        int minimumHeight2 = childCount >= 1 ? getChildAt(childCount - 1).getMinimumHeight() : 0;
        if (minimumHeight2 == 0) {
            return getHeight() / 3;
        }
        int i2 = (minimumHeight2 * 2) + topInset;
        return i2 < getHeight() ? i2 : minimumHeight2 + topInset;
    }

    public int getPendingAction() {
        return this.f;
    }

    public Drawable getStatusBarForeground() {
        return this.w;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        C4119t40 c4119t40 = this.g;
        if (c4119t40 != null) {
            return c4119t40.d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.b;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                F4 f4 = (F4) childAt.getLayoutParams();
                int measuredHeight = childAt.getMeasuredHeight();
                int i4 = f4.a;
                if ((i4 & 1) == 0) {
                    break;
                }
                int i5 = measuredHeight + ((LinearLayout.LayoutParams) f4).topMargin + ((LinearLayout.LayoutParams) f4).bottomMargin + i3;
                if (i2 == 0 && childAt.getFitsSystemWindows()) {
                    i5 -= getTopInset();
                }
                i3 = i5;
                if ((i4 & 2) != 0) {
                    i3 -= childAt.getMinimumHeight();
                    break;
                }
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.b = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof JE) {
            AbstractC3131gc0.J(this, (JE) background);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        if (this.u == null) {
            this.u = new int[4];
        }
        int[] iArr = this.u;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.i;
        iArr[0] = z ? R.attr.state_liftable : -2130969741;
        iArr[1] = (z && this.j) ? R.attr.state_lifted : -2130969742;
        iArr[2] = z ? R.attr.state_collapsible : -2130969737;
        iArr[3] = (z && this.j) ? R.attr.state_collapsed : -2130969736;
        return View.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:43:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        boolean z2 = false;
        if (getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int topInset = getTopInset();
                for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
                    View childAt2 = getChildAt(childCount);
                    WeakHashMap weakHashMap = AbstractC2925e20.a;
                    childAt2.offsetTopAndBottom(topInset);
                }
            }
        }
        c();
        this.e = false;
        int childCount2 = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount2) {
                break;
            }
            if (((F4) getChildAt(i5).getLayoutParams()).c != null) {
                this.e = true;
                break;
            }
            i5++;
        }
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setBounds(0, 0, getWidth(), getTopInset());
        }
        if (this.h) {
            return;
        }
        if (!this.k) {
            int childCount3 = getChildCount();
            for (int i6 = 0; i6 < childCount3; i6++) {
                int i7 = ((F4) getChildAt(i6).getLayoutParams()).a;
                if ((i7 & 1) != 1 || (i7 & 10) == 0) {
                }
            }
            if (this.i == z2) {
                this.i = z2;
                refreshDrawableState();
                return;
            }
            return;
        }
        z2 = true;
        if (this.i == z2) {
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824 && getFitsSystemWindows() && getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (childAt.getVisibility() != 8 && !childAt.getFitsSystemWindows()) {
                int measuredHeight = getMeasuredHeight();
                if (mode == Integer.MIN_VALUE) {
                    measuredHeight = AbstractC0325Me.j(getTopInset() + getMeasuredHeight(), 0, View.MeasureSpec.getSize(i2));
                } else if (mode == 0) {
                    measuredHeight += getTopInset();
                }
                setMeasuredDimension(getMeasuredWidth(), measuredHeight);
            }
        }
        c();
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        final JE je;
        ColorStateList colorStateList;
        Context context = getContext();
        final Integer num = null;
        if (drawable instanceof JE) {
            je = (JE) drawable;
        } else {
            ColorStateList o = AbstractC3634my.o(drawable);
            if (o == null) {
                je = null;
            } else {
                JE je2 = new JE();
                je2.n(o);
                je = je2;
            }
        }
        if (je != null && (colorStateList = je.b.d) != null) {
            this.v = colorStateList.getDefaultColor();
            final ColorStateList colorStateList2 = this.l;
            if (colorStateList2 != null) {
                Context context2 = getContext();
                TypedValue Y = AbstractC0731aZ.Y(context2, R.attr.colorSurface);
                if (Y != null) {
                    int i = Y.resourceId;
                    num = Integer.valueOf(i != 0 ? context2.getColor(i) : Y.data);
                }
                this.p = new ValueAnimator.AnimatorUpdateListener() { // from class: D4
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        Integer num2;
                        int i2 = AppBarLayout.A;
                        AppBarLayout appBarLayout = AppBarLayout.this;
                        int z = S50.z(appBarLayout.v, colorStateList2.getDefaultColor(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
                        ColorStateList valueOf = ColorStateList.valueOf(z);
                        JE je3 = je;
                        je3.n(valueOf);
                        if (appBarLayout.w != null && (num2 = appBarLayout.x) != null && num2.equals(num)) {
                            appBarLayout.w.setTint(z);
                        }
                        ArrayList arrayList = appBarLayout.q;
                        if (!arrayList.isEmpty()) {
                            Iterator it = arrayList.iterator();
                            while (it.hasNext()) {
                                if (it.next() != null) {
                                    throw new ClassCastException();
                                }
                                if (je3.b.d != null) {
                                    throw null;
                                }
                            }
                        }
                        LinkedHashSet linkedHashSet = appBarLayout.r;
                        if (linkedHashSet.isEmpty()) {
                            return;
                        }
                        Iterator it2 = linkedHashSet.iterator();
                        if (it2.hasNext()) {
                            throw W50.f(it2);
                        }
                    }
                };
            } else {
                je.k(context);
                this.p = new E4(0, this, je);
            }
            drawable = je;
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof JE) {
            ((JE) background).m(f);
        }
    }

    public void setExpanded(boolean z) {
        d(z, isLaidOut(), true);
    }

    public void setLiftOnScroll(boolean z) {
        this.k = z;
    }

    public void setLiftOnScrollColor(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            setBackground(getBackground());
        }
    }

    public void setLiftOnScrollTargetView(View view) {
        this.m = -1;
        if (view != null) {
            this.n = new WeakReference(view);
            return;
        }
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public void setLiftOnScrollTargetViewId(int i) {
        this.m = i;
        WeakReference weakReference = this.n;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.n = null;
    }

    public void setLiftableOverrideEnabled(boolean z) {
        this.h = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public void setPendingAction(int i) {
        this.f = i;
    }

    public void setStatusBarForeground(Drawable drawable) {
        Drawable drawable2 = this.w;
        if (drawable2 != drawable) {
            Integer num = null;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.w = mutate;
            if (mutate instanceof JE) {
                num = Integer.valueOf(((JE) mutate).v);
            } else {
                ColorStateList o = AbstractC3634my.o(mutate);
                if (o != null) {
                    num = Integer.valueOf(o.getDefaultColor());
                }
            }
            this.x = num;
            Drawable drawable3 = this.w;
            boolean z = false;
            if (drawable3 != null) {
                if (drawable3.isStateful()) {
                    this.w.setState(getDrawableState());
                }
                this.w.setLayoutDirection(getLayoutDirection());
                this.w.setVisible(getVisibility() == 0, false);
                this.w.setCallback(this);
            }
            if (this.w != null && getTopInset() > 0) {
                z = true;
            }
            setWillNotDraw(!z);
            postInvalidateOnAnimation();
        }
    }

    public void setStatusBarForegroundColor(int i) {
        setStatusBarForeground(new ColorDrawable(i));
    }

    public void setStatusBarForegroundResource(int i) {
        setStatusBarForeground(XE.k(getContext(), i));
    }

    @Deprecated
    public void setTargetElevation(float f) {
        AbstractC0731aZ.e0(this, f);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        boolean z = i == 0;
        Drawable drawable = this.w;
        if (drawable != null) {
            drawable.setVisible(z, false);
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.w;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }

    public static class BaseBehavior<T extends AppBarLayout> extends AbstractC0161Fv {
        public int j;
        public int k;
        public ValueAnimator l;
        public d m;
        public WeakReference n;

        public BaseBehavior() {
            this.f = -1;
            this.h = -1;
        }

        public static void D(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i, int i2, boolean z) {
            View view;
            boolean z2;
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    view = null;
                    break;
                }
                view = appBarLayout.getChildAt(i3);
                if (abs >= view.getTop() && abs <= view.getBottom()) {
                    break;
                } else {
                    i3++;
                }
            }
            if (view != null) {
                int i4 = ((F4) view.getLayoutParams()).a;
                if ((i4 & 1) != 0) {
                    int minimumHeight = view.getMinimumHeight();
                    z2 = true;
                    if (i2 > 0) {
                    }
                }
            }
            z2 = false;
            if (appBarLayout.k) {
                z2 = appBarLayout.f(z(coordinatorLayout));
            }
            boolean e = appBarLayout.e(z2);
            if (!z) {
                if (e) {
                    List list = (List) ((C4386wT) coordinatorLayout.b.b).get(appBarLayout);
                    ArrayList arrayList = coordinatorLayout.d;
                    arrayList.clear();
                    if (list != null) {
                        arrayList.addAll(list);
                    }
                    int size = arrayList.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        AbstractC0327Mg abstractC0327Mg = ((C0405Pg) ((View) arrayList.get(i5)).getLayoutParams()).a;
                        if (abstractC0327Mg instanceof ScrollingViewBehavior) {
                            if (((ScrollingViewBehavior) abstractC0327Mg).f == 0) {
                                return;
                            }
                        }
                    }
                    return;
                }
                return;
            }
            if (appBarLayout.getBackground() != null) {
                appBarLayout.getBackground().jumpToCurrentState();
            }
            if (appBarLayout.getForeground() != null) {
                appBarLayout.getForeground().jumpToCurrentState();
            }
            if (appBarLayout.getStateListAnimator() != null) {
                appBarLayout.getStateListAnimator().jumpToCurrentState();
            }
        }

        public static View x(BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout) {
            baseBehavior.getClass();
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (((C0405Pg) childAt.getLayoutParams()).a instanceof ScrollingViewBehavior) {
                    return childAt;
                }
            }
            return null;
        }

        public static View z(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if ((childAt instanceof JH) || (childAt instanceof AbsListView) || (childAt instanceof ScrollView)) {
                    return childAt;
                }
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0030  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void A(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i, int[] iArr) {
            AppBarLayout appBarLayout2;
            int i2;
            int i3;
            if (i != 0) {
                if (i < 0) {
                    i2 = -appBarLayout.getTotalScrollRange();
                    i3 = appBarLayout.getDownNestedPreScrollRange() + i2;
                } else {
                    i2 = -appBarLayout.getUpNestedPreScrollRange();
                    i3 = 0;
                }
                int i4 = i2;
                int i5 = i3;
                if (i4 != i5) {
                    appBarLayout2 = appBarLayout;
                    iArr[1] = v(coordinatorLayout, appBarLayout2, u() - i, i4, i5);
                    if (appBarLayout2.k) {
                        return;
                    }
                    appBarLayout2.e(appBarLayout2.f(view));
                    return;
                }
            }
            appBarLayout2 = appBarLayout;
            if (appBarLayout2.k) {
            }
        }

        public final d B(Parcelable parcelable, AppBarLayout appBarLayout) {
            int s = s();
            int childCount = appBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = appBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + s;
                if (childAt.getTop() + s <= 0 && bottom >= 0) {
                    if (parcelable == null) {
                        parcelable = AbstractC3159h.b;
                    }
                    d dVar = new d(parcelable);
                    boolean z = s == 0;
                    dVar.d = z;
                    dVar.c = !z && (-s) >= appBarLayout.getTotalScrollRange();
                    dVar.e = i;
                    dVar.g = bottom == appBarLayout.getTopInset() + childAt.getMinimumHeight();
                    dVar.f = bottom / childAt.getHeight();
                    return dVar;
                }
            }
            return null;
        }

        public final void C(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
            int paddingTop = appBarLayout.getPaddingTop() + appBarLayout.getTopInset();
            int u = u() - paddingTop;
            int childCount = appBarLayout.getChildCount();
            int i = 0;
            while (true) {
                if (i >= childCount) {
                    i = -1;
                    break;
                }
                View childAt = appBarLayout.getChildAt(i);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                F4 f4 = (F4) childAt.getLayoutParams();
                if ((f4.a & 32) == 32) {
                    top -= ((LinearLayout.LayoutParams) f4).topMargin;
                    bottom += ((LinearLayout.LayoutParams) f4).bottomMargin;
                }
                int i2 = -u;
                if (top <= i2 && bottom >= i2) {
                    break;
                } else {
                    i++;
                }
            }
            if (i >= 0) {
                View childAt2 = appBarLayout.getChildAt(i);
                F4 f42 = (F4) childAt2.getLayoutParams();
                int i3 = f42.a;
                if ((i3 & 17) == 17) {
                    int i4 = -childAt2.getTop();
                    int i5 = -childAt2.getBottom();
                    if (i == 0 && appBarLayout.getFitsSystemWindows() && childAt2.getFitsSystemWindows()) {
                        i4 -= appBarLayout.getTopInset();
                    }
                    if ((i3 & 2) == 2) {
                        i5 += childAt2.getMinimumHeight();
                    } else if ((i3 & 5) == 5) {
                        int minimumHeight = childAt2.getMinimumHeight() + i5;
                        if (u < minimumHeight) {
                            i4 = minimumHeight;
                        } else {
                            i5 = minimumHeight;
                        }
                    }
                    if ((i3 & 32) == 32) {
                        i4 += ((LinearLayout.LayoutParams) f42).topMargin;
                        i5 -= ((LinearLayout.LayoutParams) f42).bottomMargin;
                    }
                    if (u < (i5 + i4) / 2) {
                        i4 = i5;
                    }
                    y(coordinatorLayout, appBarLayout, AbstractC0325Me.j(i4 + paddingTop, -appBarLayout.getTotalScrollRange(), 0));
                }
            }
        }

        @Override // defpackage.AbstractC4194u20, defpackage.AbstractC0327Mg
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            super.h(coordinatorLayout, appBarLayout, i);
            int pendingAction = appBarLayout.getPendingAction();
            d dVar = this.m;
            if (dVar == null || (pendingAction & 8) != 0) {
                if (pendingAction != 0) {
                    boolean z = (pendingAction & 4) != 0;
                    if ((pendingAction & 2) != 0) {
                        int i2 = -appBarLayout.getUpNestedPreScrollRange();
                        if (z) {
                            y(coordinatorLayout, appBarLayout, i2);
                        } else {
                            w(coordinatorLayout, appBarLayout, i2);
                        }
                    } else if ((pendingAction & 1) != 0) {
                        if (z) {
                            y(coordinatorLayout, appBarLayout, 0);
                        } else {
                            w(coordinatorLayout, appBarLayout, 0);
                        }
                    }
                }
            } else if (dVar.c) {
                w(coordinatorLayout, appBarLayout, -appBarLayout.getTotalScrollRange());
            } else if (dVar.d) {
                w(coordinatorLayout, appBarLayout, 0);
            } else {
                View childAt = appBarLayout.getChildAt(dVar.e);
                int i3 = -childAt.getBottom();
                w(coordinatorLayout, appBarLayout, this.m.g ? appBarLayout.getTopInset() + childAt.getMinimumHeight() + i3 : Math.round(childAt.getHeight() * this.m.f) + i3);
            }
            appBarLayout.f = 0;
            this.m = null;
            int j = AbstractC0325Me.j(s(), -appBarLayout.getTotalScrollRange(), 0);
            R9 r9 = this.a;
            if (r9 == null) {
                this.b = j;
            } else if (r9.d != j) {
                r9.d = j;
                r9.b();
            }
            D(coordinatorLayout, appBarLayout, s(), 0, true);
            appBarLayout.a = s();
            if (!appBarLayout.willNotDraw()) {
                appBarLayout.postInvalidateOnAnimation();
            }
            if (AbstractC2925e20.d(coordinatorLayout) != null) {
                return true;
            }
            AbstractC2925e20.m(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return true;
        }

        @Override // defpackage.AbstractC0327Mg
        public final boolean i(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (((ViewGroup.MarginLayoutParams) ((C0405Pg) appBarLayout.getLayoutParams())).height != -2) {
                return false;
            }
            coordinatorLayout.r(appBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0));
            return true;
        }

        @Override // defpackage.AbstractC0327Mg
        public final /* bridge */ /* synthetic */ void k(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            A(coordinatorLayout, (AppBarLayout) view, view2, i2, iArr);
        }

        @Override // defpackage.AbstractC0327Mg
        public final void l(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int[] iArr) {
            CoordinatorLayout coordinatorLayout2;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (i3 < 0) {
                coordinatorLayout2 = coordinatorLayout;
                iArr[1] = v(coordinatorLayout2, appBarLayout, u() - i3, -appBarLayout.getDownNestedScrollRange(), 0);
            } else {
                coordinatorLayout2 = coordinatorLayout;
            }
            if (i3 == 0 && AbstractC2925e20.d(coordinatorLayout2) == null) {
                AbstractC2925e20.m(coordinatorLayout2, new b(coordinatorLayout2, this, appBarLayout));
            }
        }

        @Override // defpackage.AbstractC0327Mg
        public final void n(View view, Parcelable parcelable) {
            if (parcelable instanceof d) {
                this.m = (d) parcelable;
            } else {
                this.m = null;
            }
        }

        @Override // defpackage.AbstractC0327Mg
        public final Parcelable o(View view) {
            AbsSavedState absSavedState = View.BaseSavedState.EMPTY_STATE;
            d B = B(absSavedState, (AppBarLayout) view);
            return B == null ? absSavedState : B;
        }

        @Override // defpackage.AbstractC0327Mg
        public final boolean p(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            boolean z = (i & 2) != 0 && (appBarLayout.k || appBarLayout.j || (appBarLayout.getTotalScrollRange() != 0 && coordinatorLayout.getHeight() - view2.getHeight() <= appBarLayout.getHeight()));
            if (z && (valueAnimator = this.l) != null) {
                valueAnimator.cancel();
            }
            this.n = null;
            this.k = i2;
            return z;
        }

        @Override // defpackage.AbstractC0327Mg
        public final void q(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            AppBarLayout appBarLayout = (AppBarLayout) view;
            if (this.k == 0 || i == 1) {
                C(coordinatorLayout, appBarLayout);
                if (appBarLayout.k) {
                    appBarLayout.e(appBarLayout.f(view2));
                }
            }
            this.n = new WeakReference(view2);
        }

        @Override // defpackage.AbstractC0161Fv
        public final int u() {
            return s() + this.j;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x016a  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x018c  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0191  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0193  */
        @Override // defpackage.AbstractC0161Fv
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final int v(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            int i4;
            boolean z;
            List list;
            int i5;
            int i6;
            AppBarLayout appBarLayout = (AppBarLayout) view;
            int u = u();
            int i7 = 0;
            if (i2 == 0 || u < i2 || u > i3) {
                this.j = 0;
            } else {
                int j = AbstractC0325Me.j(i, i2, i3);
                if (u != j) {
                    if (appBarLayout.e) {
                        int abs = Math.abs(j);
                        int childCount = appBarLayout.getChildCount();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= childCount) {
                                break;
                            }
                            View childAt = appBarLayout.getChildAt(i8);
                            F4 f4 = (F4) childAt.getLayoutParams();
                            Interpolator interpolator = f4.c;
                            if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                                i8++;
                            } else if (interpolator != null) {
                                int i9 = f4.a;
                                if ((i9 & 1) != 0) {
                                    i6 = childAt.getHeight() + ((LinearLayout.LayoutParams) f4).topMargin + ((LinearLayout.LayoutParams) f4).bottomMargin;
                                    if ((i9 & 2) != 0) {
                                        i6 -= childAt.getMinimumHeight();
                                    }
                                } else {
                                    i6 = 0;
                                }
                                if (childAt.getFitsSystemWindows()) {
                                    i6 -= appBarLayout.getTopInset();
                                }
                                if (i6 > 0) {
                                    float f = i6;
                                    i4 = (childAt.getTop() + Math.round(interpolator.getInterpolation((abs - childAt.getTop()) / f) * f)) * Integer.signum(j);
                                }
                            }
                        }
                    }
                    i4 = j;
                    R9 r9 = this.a;
                    int i10 = 1;
                    if (r9 == null) {
                        this.b = i4;
                    } else if (r9.d != i4) {
                        r9.d = i4;
                        r9.b();
                        z = true;
                        int i11 = u - j;
                        this.j = j - i4;
                        if (z) {
                            int i12 = 0;
                            while (i12 < appBarLayout.getChildCount()) {
                                F4 f42 = (F4) appBarLayout.getChildAt(i12).getLayoutParams();
                                ML ml = f42.b;
                                if (ml != null && (f42.a & i10) != 0) {
                                    View childAt2 = appBarLayout.getChildAt(i12);
                                    float s = s();
                                    Rect rect = (Rect) ml.b;
                                    childAt2.getDrawingRect(rect);
                                    appBarLayout.offsetDescendantRectToMyCoords(childAt2, rect);
                                    rect.offset(0, -appBarLayout.getTopInset());
                                    float abs2 = rect.top - Math.abs(s);
                                    if (abs2 <= 0.0f) {
                                        float abs3 = Math.abs(abs2 / rect.height());
                                        if (abs3 < 0.0f) {
                                            abs3 = 0.0f;
                                        } else if (abs3 > 1.0f) {
                                            abs3 = 1.0f;
                                        }
                                        float f2 = 1.0f - abs3;
                                        float height = (-abs2) - ((rect.height() * 0.3f) * (1.0f - (f2 * f2)));
                                        childAt2.setTranslationY(height);
                                        Rect rect2 = (Rect) ml.c;
                                        childAt2.getDrawingRect(rect2);
                                        rect2.offset(0, (int) (-height));
                                        if (height >= rect2.height()) {
                                            childAt2.setAlpha(0.0f);
                                        } else {
                                            childAt2.setAlpha(1.0f);
                                        }
                                        childAt2.setClipBounds(rect2);
                                    } else {
                                        childAt2.setClipBounds(null);
                                        childAt2.setTranslationY(0.0f);
                                        childAt2.setAlpha(1.0f);
                                    }
                                }
                                i12++;
                                i10 = 1;
                            }
                        }
                        if (!z && appBarLayout.e && (list = (List) ((C4386wT) coordinatorLayout.b.b).get(appBarLayout)) != null && !list.isEmpty()) {
                            for (i5 = 0; i5 < list.size(); i5++) {
                                View view2 = (View) list.get(i5);
                                AbstractC0327Mg abstractC0327Mg = ((C0405Pg) view2.getLayoutParams()).a;
                                if (abstractC0327Mg != null) {
                                    abstractC0327Mg.d(coordinatorLayout, view2, appBarLayout);
                                }
                            }
                        }
                        appBarLayout.a = s();
                        if (!appBarLayout.willNotDraw()) {
                            appBarLayout.postInvalidateOnAnimation();
                        }
                        D(coordinatorLayout, appBarLayout, j, j >= u ? -1 : 1, false);
                        i7 = i11;
                    }
                    z = false;
                    int i112 = u - j;
                    this.j = j - i4;
                    if (z) {
                    }
                    if (!z) {
                        while (i5 < list.size()) {
                        }
                    }
                    appBarLayout.a = s();
                    if (!appBarLayout.willNotDraw()) {
                    }
                    D(coordinatorLayout, appBarLayout, j, j >= u ? -1 : 1, false);
                    i7 = i112;
                }
            }
            if (AbstractC2925e20.d(coordinatorLayout) != null) {
                return i7;
            }
            AbstractC2925e20.m(coordinatorLayout, new b(coordinatorLayout, this, appBarLayout));
            return i7;
        }

        public final void y(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(u() - i);
            float abs2 = Math.abs(0.0f);
            int round = abs2 > 0.0f ? Math.round((abs / abs2) * 1000.0f) * 3 : (int) (((abs / appBarLayout.getHeight()) + 1.0f) * 150.0f);
            int u = u();
            if (u == i) {
                ValueAnimator valueAnimator = this.l;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.l.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.l;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.l = valueAnimator3;
                valueAnimator3.setInterpolator(AbstractC4434x4.e);
                this.l.addUpdateListener(new a(coordinatorLayout, this, appBarLayout));
            } else {
                valueAnimator2.cancel();
            }
            this.l.setDuration(Math.min(round, AdSize.WIDE_SKYSCRAPER_HEIGHT));
            this.l.setIntValues(u, i);
            this.l.start();
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(0);
            this.f = -1;
            this.h = -1;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final LinearLayout.LayoutParams generateDefaultLayoutParams() {
        F4 f4 = new F4(-1, -2);
        f4.a = 1;
        return f4;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public final /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return b(layoutParams);
    }
}
