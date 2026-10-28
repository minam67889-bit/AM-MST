package androidx.fragment.app;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3634my;
import defpackage.C2992et;
import defpackage.C4119t40;
import defpackage.CM;
import defpackage.W50;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class FragmentContainerView extends FrameLayout {
    public final ArrayList a;
    public final ArrayList b;
    public View.OnApplyWindowInsetsListener c;
    public boolean d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        String str;
        AbstractC3634my.g(context, "context");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        if (attributeSet != null) {
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CM.b, 0, 0);
            if (classAttribute == null) {
                classAttribute = obtainStyledAttributes.getString(0);
                str = "android:name";
            } else {
                str = "class";
            }
            obtainStyledAttributes.recycle();
            if (classAttribute == null || isInEditMode()) {
                return;
            }
            throw new UnsupportedOperationException("FragmentContainerView must be within a FragmentActivity to use " + str + "=\"" + classAttribute + '\"');
        }
    }

    public final void a(View view) {
        if (this.b.contains(view)) {
            this.a.add(view);
        }
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AbstractC3634my.g(view, "child");
        Object tag = view.getTag(R.id.fragment_container_view_tag);
        if ((tag instanceof l ? (l) tag : null) != null) {
            super.addView(view, i, layoutParams);
            return;
        }
        throw new IllegalStateException(("Views added to a FragmentContainerView must be associated with a Fragment. View " + view + " is not associated with a Fragment.").toString());
    }

    @Override // android.view.ViewGroup, android.view.View
    public final WindowInsets dispatchApplyWindowInsets(WindowInsets windowInsets) {
        C4119t40 c4119t40;
        AbstractC3634my.g(windowInsets, "insets");
        C4119t40 g = C4119t40.g(null, windowInsets);
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.c;
        if (onApplyWindowInsetsListener != null) {
            WindowInsets onApplyWindowInsets = onApplyWindowInsetsListener.onApplyWindowInsets(this, windowInsets);
            AbstractC3634my.f(onApplyWindowInsets, "onApplyWindowInsetsListe…lyWindowInsets(v, insets)");
            c4119t40 = C4119t40.g(null, onApplyWindowInsets);
        } else {
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            WindowInsets f = g.f();
            if (f != null) {
                onApplyWindowInsets(f);
                if (!f.equals(f)) {
                    g = C4119t40.g(this, f);
                }
            }
            c4119t40 = g;
        }
        if (!c4119t40.a.q()) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                AbstractC2925e20.b(getChildAt(i), c4119t40);
            }
        }
        return windowInsets;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        AbstractC3634my.g(canvas, "canvas");
        if (this.d) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                super.drawChild(canvas, (View) it.next(), getDrawingTime());
            }
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        AbstractC3634my.g(canvas, "canvas");
        AbstractC3634my.g(view, "child");
        if (this.d) {
            ArrayList arrayList = this.a;
            if (!arrayList.isEmpty() && arrayList.contains(view)) {
                return false;
            }
        }
        return super.drawChild(canvas, view, j);
    }

    @Override // android.view.ViewGroup
    public final void endViewTransition(View view) {
        AbstractC3634my.g(view, "view");
        this.b.remove(view);
        if (this.a.remove(view)) {
            this.d = true;
        }
        super.endViewTransition(view);
    }

    public final <F extends l> F getFragment() {
        q qVar;
        l lVar;
        t supportFragmentManager;
        View view = this;
        while (true) {
            qVar = null;
            if (view == null) {
                lVar = null;
                break;
            }
            Object tag = view.getTag(R.id.fragment_container_view_tag);
            lVar = tag instanceof l ? (l) tag : null;
            if (lVar != null) {
                break;
            }
            Object parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        if (lVar == null) {
            Context context = getContext();
            while (true) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                if (context instanceof q) {
                    qVar = (q) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (qVar == null) {
                throw new IllegalStateException("View " + this + " is not within a subclass of FragmentActivity.");
            }
            supportFragmentManager = qVar.getSupportFragmentManager();
        } else {
            if (!lVar.isAdded()) {
                throw new IllegalStateException("The Fragment " + lVar + " that owns View " + this + " has already been destroyed. Nested fragments should always use the child FragmentManager.");
            }
            supportFragmentManager = lVar.getChildFragmentManager();
        }
        return (F) supportFragmentManager.A(getId());
    }

    @Override // android.view.View
    public final WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        AbstractC3634my.g(windowInsets, "insets");
        return windowInsets;
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        int childCount = getChildCount();
        while (true) {
            childCount--;
            if (-1 >= childCount) {
                super.removeAllViewsInLayout();
                return;
            } else {
                View childAt = getChildAt(childCount);
                AbstractC3634my.f(childAt, "view");
                a(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        AbstractC3634my.g(view, "view");
        a(view);
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        View childAt = getChildAt(i);
        AbstractC3634my.f(childAt, "view");
        a(childAt);
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        AbstractC3634my.g(view, "view");
        a(view);
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViews(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            AbstractC3634my.f(childAt, "view");
            a(childAt);
        }
        super.removeViews(i, i2);
    }

    @Override // android.view.ViewGroup
    public final void removeViewsInLayout(int i, int i2) {
        int i3 = i + i2;
        for (int i4 = i; i4 < i3; i4++) {
            View childAt = getChildAt(i4);
            AbstractC3634my.f(childAt, "view");
            a(childAt);
        }
        super.removeViewsInLayout(i, i2);
    }

    public final void setDrawDisappearingViewsLast(boolean z) {
        this.d = z;
    }

    @Override // android.view.ViewGroup
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        throw new UnsupportedOperationException("FragmentContainerView does not support Layout Transitions or animateLayoutChanges=\"true\".");
    }

    @Override // android.view.View
    public void setOnApplyWindowInsetsListener(View.OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        AbstractC3634my.g(onApplyWindowInsetsListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = onApplyWindowInsetsListener;
    }

    @Override // android.view.ViewGroup
    public final void startViewTransition(View view) {
        AbstractC3634my.g(view, "view");
        if (view.getParent() == this) {
            this.b.add(view);
        }
        super.startViewTransition(view);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentContainerView(Context context, AttributeSet attributeSet, t tVar) {
        super(context, attributeSet);
        View view;
        AbstractC3634my.g(context, "context");
        AbstractC3634my.g(attributeSet, "attrs");
        AbstractC3634my.g(tVar, "fm");
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.d = true;
        String classAttribute = attributeSet.getClassAttribute();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, CM.b, 0, 0);
        classAttribute = classAttribute == null ? obtainStyledAttributes.getString(0) : classAttribute;
        String string = obtainStyledAttributes.getString(1);
        obtainStyledAttributes.recycle();
        int id = getId();
        l A = tVar.A(id);
        if (classAttribute != null && A == null) {
            if (id == -1) {
                throw new IllegalStateException(W50.D("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
            }
            C2992et D = tVar.D();
            context.getClassLoader();
            l instantiate = l.instantiate(D.a.t.b, classAttribute, null);
            AbstractC3634my.f(instantiate, "fm.fragmentFactory.insta…ontext.classLoader, name)");
            instantiate.onInflate(context, attributeSet, (Bundle) null);
            a aVar = new a(tVar);
            aVar.o = true;
            instantiate.mContainer = this;
            aVar.c(getId(), instantiate, string, 1);
            if (!aVar.g) {
                aVar.p.y(aVar, true);
            } else {
                throw new IllegalStateException("This transaction is already being added to the back stack");
            }
        }
        Iterator it = tVar.c.d().iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            l lVar = wVar.c;
            if (lVar.mContainerId == getId() && (view = lVar.mView) != null && view.getParent() == null) {
                lVar.mContainer = this;
                wVar.a();
            }
        }
    }
}
