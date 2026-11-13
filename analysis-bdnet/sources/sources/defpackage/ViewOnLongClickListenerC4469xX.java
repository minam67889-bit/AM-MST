package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* renamed from: xX, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnLongClickListenerC4469xX implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static ViewOnLongClickListenerC4469xX k;
    public static ViewOnLongClickListenerC4469xX l;
    public final View a;
    public final CharSequence b;
    public final int c;
    public final RunnableC4390wX d;
    public final RunnableC4390wX e;
    public int f;
    public int g;
    public C4548yX h;
    public boolean i;
    public boolean j;

    /* JADX WARN: Type inference failed for: r0v0, types: [wX] */
    /* JADX WARN: Type inference failed for: r0v1, types: [wX] */
    public ViewOnLongClickListenerC4469xX(View view, CharSequence charSequence) {
        final int i = 0;
        this.d = new Runnable(this) { // from class: wX
            public final /* synthetic */ ViewOnLongClickListenerC4469xX b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case 0:
                        this.b.c(false);
                        break;
                    default:
                        this.b.a();
                        break;
                }
            }
        };
        final int i2 = 1;
        this.e = new Runnable(this) { // from class: wX
            public final /* synthetic */ ViewOnLongClickListenerC4469xX b;

            {
                this.b = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i2) {
                    case 0:
                        this.b.c(false);
                        break;
                    default:
                        this.b.a();
                        break;
                }
            }
        };
        this.a = view;
        this.b = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = AbstractC3005f20.a;
        this.c = Build.VERSION.SDK_INT >= 28 ? AbstractC0072Ck.k(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.j = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(ViewOnLongClickListenerC4469xX viewOnLongClickListenerC4469xX) {
        ViewOnLongClickListenerC4469xX viewOnLongClickListenerC4469xX2 = k;
        if (viewOnLongClickListenerC4469xX2 != null) {
            viewOnLongClickListenerC4469xX2.a.removeCallbacks(viewOnLongClickListenerC4469xX2.d);
        }
        k = viewOnLongClickListenerC4469xX;
        if (viewOnLongClickListenerC4469xX != null) {
            viewOnLongClickListenerC4469xX.a.postDelayed(viewOnLongClickListenerC4469xX.d, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        ViewOnLongClickListenerC4469xX viewOnLongClickListenerC4469xX = l;
        View view = this.a;
        if (viewOnLongClickListenerC4469xX == this) {
            l = null;
            C4548yX c4548yX = this.h;
            if (c4548yX != null) {
                View view2 = (View) c4548yX.b;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) c4548yX.a).getSystemService("window")).removeView(view2);
                }
                this.h = null;
                this.j = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (k == this) {
            b(null);
        }
        view.removeCallbacks(this.e);
    }

    public final void c(boolean z) {
        int height;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.a;
        if (view.isAttachedToWindow()) {
            b(null);
            ViewOnLongClickListenerC4469xX viewOnLongClickListenerC4469xX = l;
            if (viewOnLongClickListenerC4469xX != null) {
                viewOnLongClickListenerC4469xX.a();
            }
            l = this;
            this.i = z;
            C4548yX c4548yX = new C4548yX(view.getContext());
            this.h = c4548yX;
            int i6 = this.f;
            int i7 = this.g;
            boolean z2 = this.i;
            View view2 = (View) c4548yX.b;
            ViewParent parent = view2.getParent();
            Context context = (Context) c4548yX.a;
            if (parent != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) c4548yX.c).setText(this.b);
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) c4548yX.d;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                i6 = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
                height = i7 + dimensionPixelOffset2;
                i = i7 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z2 ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i5 = 1;
            } else {
                Rect rect = (Rect) c4548yX.e;
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i2 = i6;
                    i3 = i;
                    i4 = 0;
                    i5 = 1;
                } else {
                    Resources resources = context.getResources();
                    i5 = 1;
                    i2 = i6;
                    i3 = i;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i4 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                int[] iArr = (int[]) c4548yX.g;
                rootView.getLocationOnScreen(iArr);
                int[] iArr2 = (int[]) c4548yX.f;
                view.getLocationOnScreen(iArr2);
                int i8 = iArr2[i4] - iArr[i4];
                iArr2[i4] = i8;
                iArr2[i5] = iArr2[i5] - iArr[i5];
                layoutParams.x = (i8 + i2) - (rootView.getWidth() / 2);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, i4);
                view2.measure(makeMeasureSpec, makeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i9 = iArr2[i5];
                int i10 = ((i9 + i3) - dimensionPixelOffset3) - measuredHeight;
                int i11 = i9 + height + dimensionPixelOffset3;
                if (z2) {
                    if (i10 >= 0) {
                        layoutParams.y = i10;
                    } else {
                        layoutParams.y = i11;
                    }
                } else if (measuredHeight + i11 <= rect.height()) {
                    layoutParams.y = i11;
                } else {
                    layoutParams.y = i10;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.i) {
                j2 = 2500;
            } else {
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                if ((view.getWindowSystemUiVisibility() & 1) == i5) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j = 15000;
                }
                j2 = j - longPressTimeout;
            }
            RunnableC4390wX runnableC4390wX = this.e;
            view.removeCallbacks(runnableC4390wX);
            view.postDelayed(runnableC4390wX, j2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.g) <= r2) goto L30;
     */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h == null || !this.i) {
            View view2 = this.a;
            AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
            if (!accessibilityManager.isEnabled() || !accessibilityManager.isTouchExplorationEnabled()) {
                int action = motionEvent.getAction();
                if (action != 7) {
                    if (action == 10) {
                        this.j = true;
                        a();
                        return false;
                    }
                } else if (view2.isEnabled() && this.h == null) {
                    int x = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    if (!this.j) {
                        int abs = Math.abs(x - this.f);
                        int i = this.c;
                        if (abs <= i) {
                        }
                    }
                    this.f = x;
                    this.g = y;
                    this.j = false;
                    b(this);
                }
            }
        }
        return false;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
