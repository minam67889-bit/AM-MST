package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.SearchEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityEvent;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ViewStubCompat;
import app.vpn.amtunnellite.R;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class R4 implements Window.Callback {
    public final Window.Callback a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ X4 e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public R4(X4 x4, Window.Callback callback) {
        this.e = x4;
        if (callback != null) {
            this.a = callback;
            return;
        }
        throw new IllegalArgumentException("Window callback may not be null");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(Window.Callback callback) {
        try {
            this.b = true;
            callback.onContentChanged();
        } finally {
            this.b = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean b(int i, Menu menu) {
        return this.a.onMenuOpened(i, menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(int i, Menu menu) {
        this.a.onPanelClosed(i, menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(List list, Menu menu, int i) {
        A20.a(this.a, list, menu, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.c;
        Window.Callback callback = this.a;
        if (z) {
            return callback.dispatchKeyEvent(keyEvent);
        }
        if (!this.e.u(keyEvent) && !callback.dispatchKeyEvent(keyEvent)) {
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        boolean z;
        MenuC3948nE menuC3948nE;
        boolean z2;
        boolean performShortcut;
        if (this.a.dispatchKeyShortcutEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        X4 x4 = this.e;
        x4.A();
        F20 f20 = x4.o;
        if (f20 != null) {
            E20 e20 = f20.s;
            if (e20 == null || (menuC3948nE = e20.d) == null) {
                performShortcut = false;
            } else {
                if (KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                menuC3948nE.setQwertyMode(z2);
                performShortcut = menuC3948nE.performShortcut(keyCode, keyEvent, 0);
            }
        }
        W4 w4 = x4.M;
        if (w4 != null && x4.F(w4, keyEvent.getKeyCode(), keyEvent)) {
            W4 w42 = x4.M;
            if (w42 != null) {
                w42.l = true;
            }
        } else {
            if (x4.M == null) {
                W4 z3 = x4.z(0);
                x4.G(z3, keyEvent);
                boolean F = x4.F(z3, keyEvent.getKeyCode(), keyEvent);
                z3.k = false;
            }
            z = false;
            if (!z) {
                return true;
            }
            return false;
        }
        z = true;
        if (!z) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.a.onActionModeFinished(actionMode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.a.onActionModeStarted(actionMode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.b) {
            this.a.onContentChanged();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i == 0 && !(menu instanceof MenuC3948nE)) {
            return false;
        }
        return this.a.onCreatePanelMenu(i, menu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.a.onMenuItemSelected(i, menuItem);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        X4 x4 = this.e;
        if (i == 108) {
            x4.A();
            F20 f20 = x4.o;
            if (f20 != null && true != f20.v) {
                f20.v = true;
                ArrayList arrayList = f20.w;
                if (arrayList.size() > 0) {
                    AbstractC4575vQ.B(arrayList.get(0));
                    throw null;
                }
            }
        } else {
            x4.getClass();
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.d) {
            this.a.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        X4 x4 = this.e;
        if (i == 108) {
            x4.A();
            F20 f20 = x4.o;
            if (f20 != null && f20.v) {
                f20.v = false;
                ArrayList arrayList = f20.w;
                if (arrayList.size() > 0) {
                    AbstractC4575vQ.B(arrayList.get(0));
                    throw null;
                }
                return;
            }
            return;
        }
        if (i == 0) {
            W4 z = x4.z(i);
            if (z.m) {
                x4.s(z, false);
                return;
            }
            return;
        }
        x4.getClass();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        B20.a(this.a, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        MenuC3948nE menuC3948nE;
        if (menu instanceof MenuC3948nE) {
            menuC3948nE = (MenuC3948nE) menu;
        } else {
            menuC3948nE = null;
        }
        if (i == 0 && menuC3948nE == null) {
            return false;
        }
        if (menuC3948nE != null) {
            menuC3948nE.x = true;
        }
        boolean onPreparePanel = this.a.onPreparePanel(i, view, menu);
        if (menuC3948nE != null) {
            menuC3948nE.x = false;
        }
        return onPreparePanel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        MenuC3948nE menuC3948nE = this.e.z(0).h;
        if (menuC3948nE != null) {
            d(list, menuC3948nE, i);
        } else {
            d(list, menu, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.a.onWindowFocusChanged(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return AbstractC4852z20.a(this.a, searchEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        int i2 = 1;
        X4 x4 = this.e;
        x4.getClass();
        if (i != 0) {
            return AbstractC4852z20.b(this.a, callback, i);
        }
        Context context = x4.k;
        RW rw = new RW();
        rw.b = context;
        rw.a = callback;
        rw.c = new ArrayList();
        rw.d = new DS();
        AbstractC3926n1 abstractC3926n1 = x4.u;
        if (abstractC3926n1 != null) {
            abstractC3926n1.a();
        }
        QK qk = new QK(9, x4, rw);
        x4.A();
        F20 f20 = x4.o;
        if (f20 != null) {
            E20 e20 = f20.s;
            if (e20 != null) {
                e20.a();
            }
            f20.m.setHideOnContentScrollEnabled(false);
            f20.p.e();
            E20 e202 = new E20(f20, f20.p.getContext(), qk);
            MenuC3948nE menuC3948nE = e202.d;
            menuC3948nE.w();
            try {
                if (e202.e.e(e202, menuC3948nE)) {
                    f20.s = e202;
                    e202.h();
                    f20.p.c(e202);
                    f20.h0(true);
                } else {
                    e202 = null;
                }
                x4.u = e202;
            } finally {
                menuC3948nE.v();
            }
        }
        if (x4.u == null) {
            C3619j10 c3619j10 = x4.y;
            if (c3619j10 != null) {
                c3619j10.b();
            }
            AbstractC3926n1 abstractC3926n12 = x4.u;
            if (abstractC3926n12 != null) {
                abstractC3926n12.a();
            }
            if (x4.n != null) {
                boolean z = x4.Q;
            }
            if (x4.v == null) {
                boolean z2 = x4.I;
                Context context2 = x4.k;
                if (z2) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context2.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = context2.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        C4364sg c4364sg = new C4364sg(context2, 0);
                        c4364sg.getTheme().setTo(newTheme);
                        context2 = c4364sg;
                    }
                    x4.v = new ActionBarContextView(context2, null);
                    PopupWindow popupWindow = new PopupWindow(context2, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    x4.w = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    x4.w.setContentView(x4.v);
                    x4.w.setWidth(-1);
                    context2.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    x4.v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context2.getResources().getDisplayMetrics()));
                    x4.w.setHeight(-2);
                    x4.x = new K4(x4, i2);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) x4.A.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        x4.A();
                        F20 f202 = x4.o;
                        Context i0 = f202 != null ? f202.i0() : null;
                        if (i0 != null) {
                            context2 = i0;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context2));
                        x4.v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (x4.v != null) {
                C3619j10 c3619j102 = x4.y;
                if (c3619j102 != null) {
                    c3619j102.b();
                }
                x4.v.e();
                Context context3 = x4.v.getContext();
                ActionBarContextView actionBarContextView = x4.v;
                JT jt = new JT();
                jt.c = context3;
                jt.d = actionBarContextView;
                jt.e = qk;
                MenuC3948nE menuC3948nE2 = new MenuC3948nE(actionBarContextView.getContext());
                menuC3948nE2.l = 1;
                jt.h = menuC3948nE2;
                menuC3948nE2.e = jt;
                if (((InterfaceC3849m1) qk.b).e(jt, menuC3948nE2)) {
                    jt.h();
                    x4.v.c(jt);
                    x4.u = jt;
                    if (x4.z && (viewGroup = x4.A) != null && viewGroup.isLaidOut()) {
                        x4.v.setAlpha(0.0f);
                        C3619j10 a = T00.a(x4.v);
                        a.a(1.0f);
                        x4.y = a;
                        a.d(new M4(x4, i2));
                    } else {
                        x4.v.setAlpha(1.0f);
                        x4.v.setVisibility(0);
                        if (x4.v.getParent() instanceof View) {
                            View view = (View) x4.v.getParent();
                            WeakHashMap weakHashMap = T00.a;
                            J00.c(view);
                        }
                    }
                    if (x4.w != null) {
                        x4.l.getDecorView().post(x4.x);
                    }
                } else {
                    x4.u = null;
                }
            }
            x4.I();
            x4.u = x4.u;
        }
        x4.I();
        AbstractC3926n1 abstractC3926n13 = x4.u;
        if (abstractC3926n13 != null) {
            return rw.j(abstractC3926n13);
        }
        return null;
    }
}
