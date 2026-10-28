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
import app.vpn.amtunnellite.R;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class FW implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static FW k;
    public static FW l;
    public final View a;
    public final CharSequence b;
    public final int c;
    public final EW d;
    public final EW e;
    public int f;
    public int g;
    public GW h;
    public boolean i;
    public boolean j;

    /* JADX WARN: Type inference failed for: r0v0, types: [EW] */
    /* JADX WARN: Type inference failed for: r0v1, types: [EW] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FW(View view, CharSequence charSequence) {
        int scaledTouchSlop;
        final int i = 0;
        this.d = new Runnable(this) { // from class: EW
            public final /* synthetic */ FW b;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.b = this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
        this.e = new Runnable(this) { // from class: EW
            public final /* synthetic */ FW b;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                this.b = this;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
        Method method = U00.a;
        if (Build.VERSION.SDK_INT >= 28) {
            scaledTouchSlop = AbstractC4753xk.k(viewConfiguration);
        } else {
            scaledTouchSlop = viewConfiguration.getScaledTouchSlop() / 2;
        }
        this.c = scaledTouchSlop;
        this.j = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void b(FW fw) {
        FW fw2 = k;
        if (fw2 != null) {
            fw2.a.removeCallbacks(fw2.d);
        }
        k = fw;
        if (fw != null) {
            fw.a.postDelayed(fw.d, ViewConfiguration.getLongPressTimeout());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a() {
        FW fw = l;
        View view = this.a;
        if (fw == this) {
            l = null;
            GW gw = this.h;
            if (gw != null) {
                View view2 = (View) gw.b;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) gw.a).getSystemService("window")).removeView(view2);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(boolean z) {
        int height;
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        int i4;
        long longPressTimeout;
        long j;
        long j2;
        View view = this.a;
        if (!view.isAttachedToWindow()) {
            return;
        }
        b(null);
        FW fw = l;
        if (fw != null) {
            fw.a();
        }
        l = this;
        this.i = z;
        GW gw = new GW(view.getContext());
        this.h = gw;
        int i5 = this.f;
        int i6 = this.g;
        boolean z2 = this.i;
        View view2 = (View) gw.b;
        ViewParent parent = view2.getParent();
        Context context = (Context) gw.a;
        if (parent != null && view2.getParent() != null) {
            ((WindowManager) context.getSystemService("window")).removeView(view2);
        }
        ((TextView) gw.c).setText(this.b);
        WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) gw.d;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i5 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i6 + dimensionPixelOffset2;
            i = i6 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = context.getResources();
        if (z2) {
            i2 = R.dimen.tooltip_y_offset_touch;
        } else {
            i2 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i2);
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
            str2 = "window";
        } else {
            Rect rect = (Rect) gw.e;
            rootView.getWindowVisibleDisplayFrame(rect);
            if (rect.left >= 0 || rect.top >= 0) {
                str = "window";
                i3 = 0;
            } else {
                Resources resources2 = context.getResources();
                str = "window";
                int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
                if (identifier != 0) {
                    i4 = resources2.getDimensionPixelSize(identifier);
                } else {
                    i4 = 0;
                }
                DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
                i3 = 0;
                rect.set(0, i4, displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
            int[] iArr = (int[]) gw.g;
            rootView.getLocationOnScreen(iArr);
            int[] iArr2 = (int[]) gw.f;
            view.getLocationOnScreen(iArr2);
            int i7 = iArr2[i3] - iArr[i3];
            iArr2[i3] = i7;
            iArr2[1] = iArr2[1] - iArr[1];
            layoutParams.x = (i7 + i5) - (rootView.getWidth() / 2);
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, i3);
            view2.measure(makeMeasureSpec, makeMeasureSpec);
            int measuredHeight = view2.getMeasuredHeight();
            int i8 = iArr2[1];
            int i9 = ((i + i8) - dimensionPixelOffset3) - measuredHeight;
            int i10 = i8 + height + dimensionPixelOffset3;
            if (!z2 ? measuredHeight + i10 > rect.height() : i9 >= 0) {
                layoutParams.y = i9;
            } else {
                layoutParams.y = i10;
            }
            str2 = str;
        }
        ((WindowManager) context.getSystemService(str2)).addView(view2, layoutParams);
        view.addOnAttachStateChangeListener(this);
        if (this.i) {
            j2 = 2500;
        } else {
            WeakHashMap weakHashMap = T00.a;
            if ((view.getWindowSystemUiVisibility() & 1) == 1) {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j = 3000;
            } else {
                longPressTimeout = ViewConfiguration.getLongPressTimeout();
                j = 15000;
            }
            j2 = j - longPressTimeout;
        }
        EW ew = this.e;
        view.removeCallbacks(ew);
        view.postDelayed(ew, j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        if (java.lang.Math.abs(r5 - r3.g) <= r2) goto L29;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean onHover(View view, MotionEvent motionEvent) {
        if (this.h != null && this.i) {
            return false;
        }
        View view2 = this.a;
        AccessibilityManager accessibilityManager = (AccessibilityManager) view2.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled() && accessibilityManager.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action != 7) {
            if (action == 10) {
                this.j = true;
                a();
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
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.f = view.getWidth() / 2;
        this.g = view.getHeight() / 2;
        c(true);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }
}
