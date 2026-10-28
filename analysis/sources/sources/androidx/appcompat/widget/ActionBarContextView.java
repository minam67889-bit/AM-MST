package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC3926n1;
import defpackage.AbstractC4388t10;
import defpackage.AbstractC4766xx;
import defpackage.C3156d;
import defpackage.C3235e1;
import defpackage.C3543i1;
import defpackage.C3619j10;
import defpackage.EL;
import defpackage.LE;
import defpackage.MenuC3948nE;
import defpackage.T0;
import defpackage.T00;

/* loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public final C3156d a;
    public final Context b;
    public ActionMenuView c;
    public C3543i1 d;
    public int e;
    public C3619j10 f;
    public boolean g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public View k;
    public View l;
    public View m;
    public LinearLayout n;
    public TextView o;
    public TextView p;
    public final int q;
    public final int r;
    public boolean s;
    public final int t;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, R.attr.actionModeStyle);
        int resourceId;
        this.a = new C3156d(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.b = context;
        } else {
            this.b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, EL.d, R.attr.actionModeStyle, 0);
        setBackground((!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) ? obtainStyledAttributes.getDrawable(0) : AbstractC4766xx.D(context, resourceId));
        this.q = obtainStyledAttributes.getResourceId(5, 0);
        this.r = obtainStyledAttributes.getResourceId(4, 0);
        this.e = obtainStyledAttributes.getLayoutDimension(3, 0);
        this.t = obtainStyledAttributes.getResourceId(2, R.layout.abc_action_mode_close_item_material);
        obtainStyledAttributes.recycle();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int f(View view, int i, int i2) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int g(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x003e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(AbstractC3926n1 abstractC3926n1) {
        View view;
        C3543i1 c3543i1;
        LE le;
        LE le2;
        View view2 = this.k;
        if (view2 != null) {
            if (view2.getParent() == null) {
                view = this.k;
            }
            View findViewById = this.k.findViewById(R.id.action_mode_close_button);
            this.l = findViewById;
            findViewById.setOnClickListener(new T0(abstractC3926n1, 0));
            MenuC3948nE c = abstractC3926n1.c();
            c3543i1 = this.d;
            if (c3543i1 != null) {
                c3543i1.g();
                C3235e1 c3235e1 = c3543i1.t;
                if (c3235e1 != null && c3235e1.b()) {
                    c3235e1.j.dismiss();
                }
            }
            C3543i1 c3543i12 = new C3543i1(getContext());
            this.d = c3543i12;
            c3543i12.l = true;
            c3543i12.m = true;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
            c.b(this.d, this.b);
            C3543i1 c3543i13 = this.d;
            le = c3543i13.h;
            if (le == null) {
                LE le3 = (LE) c3543i13.d.inflate(c3543i13.f, (ViewGroup) this, false);
                c3543i13.h = le3;
                le3.b(c3543i13.c);
                c3543i13.f();
            }
            le2 = c3543i13.h;
            if (le != le2) {
                ((ActionMenuView) le2).setPresenter(c3543i13);
            }
            ActionMenuView actionMenuView = (ActionMenuView) le2;
            this.c = actionMenuView;
            actionMenuView.setBackground(null);
            addView(this.c, layoutParams);
        }
        view = LayoutInflater.from(getContext()).inflate(this.t, (ViewGroup) this, false);
        this.k = view;
        addView(view);
        View findViewById2 = this.k.findViewById(R.id.action_mode_close_button);
        this.l = findViewById2;
        findViewById2.setOnClickListener(new T0(abstractC3926n1, 0));
        MenuC3948nE c2 = abstractC3926n1.c();
        c3543i1 = this.d;
        if (c3543i1 != null) {
        }
        C3543i1 c3543i122 = new C3543i1(getContext());
        this.d = c3543i122;
        c3543i122.l = true;
        c3543i122.m = true;
        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-2, -1);
        c2.b(this.d, this.b);
        C3543i1 c3543i132 = this.d;
        le = c3543i132.h;
        if (le == null) {
        }
        le2 = c3543i132.h;
        if (le != le2) {
        }
        ActionMenuView actionMenuView2 = (ActionMenuView) le2;
        this.c = actionMenuView2;
        actionMenuView2.setBackground(null);
        addView(this.c, layoutParams2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        if (this.n == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.n = linearLayout;
            this.o = (TextView) linearLayout.findViewById(R.id.action_bar_title);
            this.p = (TextView) this.n.findViewById(R.id.action_bar_subtitle);
            int i = this.q;
            if (i != 0) {
                this.o.setTextAppearance(getContext(), i);
            }
            int i2 = this.r;
            if (i2 != 0) {
                this.p.setTextAppearance(getContext(), i2);
            }
        }
        this.o.setText(this.i);
        this.p.setText(this.j);
        boolean z = !TextUtils.isEmpty(this.i);
        boolean z2 = !TextUtils.isEmpty(this.j);
        this.p.setVisibility(z2 ? 0 : 8);
        this.n.setVisibility((z || z2) ? 0 : 8);
        if (this.n.getParent() == null) {
            addView(this.n);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e() {
        removeAllViews();
        this.m = null;
        this.c = null;
        this.d = null;
        View view = this.l;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getAnimatedVisibility() {
        return this.f != null ? this.a.b : getVisibility();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getContentHeight() {
        return this.e;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getSubtitle() {
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CharSequence getTitle() {
        return this.i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            C3619j10 c3619j10 = this.f;
            if (c3619j10 != null) {
                c3619j10.b();
            }
            super.setVisibility(i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final C3619j10 i(int i, long j) {
        C3619j10 c3619j10 = this.f;
        if (c3619j10 != null) {
            c3619j10.b();
        }
        C3156d c3156d = this.a;
        if (i != 0) {
            C3619j10 a = T00.a(this);
            a.a(0.0f);
            a.c(j);
            c3156d.c.f = a;
            c3156d.b = i;
            a.d(c3156d);
            return a;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        C3619j10 a2 = T00.a(this);
        a2.a(1.0f);
        a2.c(j);
        c3156d.c.f = a2;
        c3156d.b = i;
        a2.d(c3156d);
        return a2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, EL.a, R.attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(13, 0));
        obtainStyledAttributes.recycle();
        C3543i1 c3543i1 = this.d;
        if (c3543i1 != null) {
            Configuration configuration2 = c3543i1.b.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i2 = configuration2.screenHeightDp;
            c3543i1.p = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i2 > 720) || (i > 720 && i2 > 960)) ? 5 : (i >= 500 || (i > 640 && i2 > 480) || (i > 480 && i2 > 640)) ? 4 : i >= 360 ? 3 : 2;
            MenuC3948nE menuC3948nE = c3543i1.c;
            if (menuC3948nE != null) {
                menuC3948nE.p(true);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C3543i1 c3543i1 = this.d;
        if (c3543i1 != null) {
            c3543i1.g();
            C3235e1 c3235e1 = this.d.t;
            if (c3235e1 == null || !c3235e1.b()) {
                return;
            }
            c3235e1.j.dismiss();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.h = false;
        }
        if (!this.h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.h = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.h = false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        boolean z2 = AbstractC4388t10.a;
        boolean z3 = getLayoutDirection() == 1;
        int paddingRight = z3 ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        View view = this.k;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            int i5 = z3 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = z3 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i7 = z3 ? paddingRight - i5 : paddingRight + i5;
            int g = g(this.k, i7, paddingTop, paddingTop2, z3) + i7;
            paddingRight = z3 ? g - i6 : g + i6;
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.m == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(this.n, paddingRight, paddingTop, paddingTop2, z3);
        }
        View view2 = this.m;
        if (view2 != null) {
            g(view2, paddingRight, paddingTop, paddingTop2, z3);
        }
        int paddingLeft = z3 ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null) {
            g(actionMenuView, paddingLeft, paddingTop, paddingTop2, !z3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.e;
        if (i3 <= 0) {
            i3 = View.MeasureSpec.getSize(i2);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i4 = i3 - paddingBottom;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        View view = this.k;
        if (view != null) {
            int f = f(view, paddingLeft, makeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.k.getLayoutParams();
            paddingLeft = f - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.c;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.c, paddingLeft, makeMeasureSpec);
        }
        LinearLayout linearLayout = this.n;
        if (linearLayout != null && this.m == null) {
            if (this.s) {
                this.n.measure(View.MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                int measuredWidth = this.n.getMeasuredWidth();
                boolean z = measuredWidth <= paddingLeft;
                if (z) {
                    paddingLeft -= measuredWidth;
                }
                this.n.setVisibility(z ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, makeMeasureSpec);
            }
        }
        View view2 = this.m;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i5 = layoutParams.width;
            int i6 = i5 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i5 >= 0) {
                paddingLeft = Math.min(i5, paddingLeft);
            }
            int i7 = layoutParams.height;
            int i8 = i7 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i7 >= 0) {
                i4 = Math.min(i7, i4);
            }
            this.m.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i6), View.MeasureSpec.makeMeasureSpec(i4, i8));
        }
        if (this.e <= 0) {
            int childCount = getChildCount();
            i3 = 0;
            for (int i9 = 0; i9 < childCount; i9++) {
                int measuredHeight = getChildAt(i9).getMeasuredHeight() + paddingBottom;
                if (measuredHeight > i3) {
                    i3 = measuredHeight;
                }
            }
        }
        setMeasuredDimension(size, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.g = false;
        }
        if (!this.g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.g = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setContentHeight(int i) {
        this.e = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.m;
        if (view2 != null) {
            removeView(view2);
        }
        this.m = view;
        if (view != null && (linearLayout = this.n) != null) {
            removeView(linearLayout);
            this.n = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setSubtitle(CharSequence charSequence) {
        this.j = charSequence;
        d();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitle(CharSequence charSequence) {
        this.i = charSequence;
        d();
        T00.m(this, charSequence);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setTitleOptional(boolean z) {
        if (z != this.s) {
            requestLayout();
        }
        this.s = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
