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
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* renamed from: c5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class WindowCallbackC0855c5 implements Window.Callback {
    public final Window.Callback a;
    public boolean b;
    public boolean c;
    public boolean d;
    public final /* synthetic */ LayoutInflaterFactory2C3250i5 e;

    public WindowCallbackC0855c5(LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5, Window.Callback callback) {
        this.e = layoutInflaterFactory2C3250i5;
        if (callback == null) {
            throw new IllegalArgumentException("Window callback may not be null");
        }
        this.a = callback;
    }

    public final void a(Window.Callback callback) {
        try {
            this.b = true;
            callback.onContentChanged();
        } finally {
            this.b = false;
        }
    }

    public final boolean b(int i, Menu menu) {
        return this.a.onMenuOpened(i, menu);
    }

    public final void c(int i, Menu menu) {
        this.a.onPanelClosed(i, menu);
    }

    public final void d(List list, Menu menu, int i) {
        K30.a(this.a, list, menu, i);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        return this.a.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        boolean z = this.c;
        Window.Callback callback = this.a;
        return z ? callback.dispatchKeyEvent(keyEvent) : this.e.u(keyEvent) || callback.dispatchKeyEvent(keyEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0067, code lost:
    
        if (r7 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0039, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x006e A[RETURN] */
    @Override // android.view.Window.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        boolean z;
        MenuC2945eF menuC2945eF;
        boolean performShortcut;
        if (!this.a.dispatchKeyShortcutEvent(keyEvent)) {
            int keyCode = keyEvent.getKeyCode();
            LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.e;
            layoutInflaterFactory2C3250i5.A();
            P30 p30 = layoutInflaterFactory2C3250i5.o;
            if (p30 != null) {
                O30 o30 = p30.s;
                if (o30 == null || (menuC2945eF = o30.d) == null) {
                    performShortcut = false;
                } else {
                    menuC2945eF.setQwertyMode(KeyCharacterMap.load(keyEvent.getDeviceId()).getKeyboardType() != 1);
                    performShortcut = menuC2945eF.performShortcut(keyCode, keyEvent, 0);
                }
            }
            C3170h5 c3170h5 = layoutInflaterFactory2C3250i5.M;
            if (c3170h5 == null || !layoutInflaterFactory2C3250i5.F(c3170h5, keyEvent.getKeyCode(), keyEvent)) {
                if (layoutInflaterFactory2C3250i5.M == null) {
                    C3170h5 z2 = layoutInflaterFactory2C3250i5.z(0);
                    layoutInflaterFactory2C3250i5.G(z2, keyEvent);
                    boolean F = layoutInflaterFactory2C3250i5.F(z2, keyEvent.getKeyCode(), keyEvent);
                    z2.k = false;
                }
                z = false;
                if (z) {
                    return false;
                }
            } else {
                C3170h5 c3170h52 = layoutInflaterFactory2C3250i5.M;
                if (c3170h52 != null) {
                    c3170h52.l = true;
                }
            }
            z = true;
            if (z) {
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return this.a.dispatchPopulateAccessibilityEvent(accessibilityEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return this.a.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final boolean dispatchTrackballEvent(MotionEvent motionEvent) {
        return this.a.dispatchTrackballEvent(motionEvent);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeFinished(ActionMode actionMode) {
        this.a.onActionModeFinished(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onActionModeStarted(ActionMode actionMode) {
        this.a.onActionModeStarted(actionMode);
    }

    @Override // android.view.Window.Callback
    public final void onAttachedToWindow() {
        this.a.onAttachedToWindow();
    }

    @Override // android.view.Window.Callback
    public final void onContentChanged() {
        if (this.b) {
            this.a.onContentChanged();
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0 || (menu instanceof MenuC2945eF)) {
            return this.a.onCreatePanelMenu(i, menu);
        }
        return false;
    }

    @Override // android.view.Window.Callback
    public final View onCreatePanelView(int i) {
        return this.a.onCreatePanelView(i);
    }

    @Override // android.view.Window.Callback
    public final void onDetachedFromWindow() {
        this.a.onDetachedFromWindow();
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        return this.a.onMenuItemSelected(i, menuItem);
    }

    @Override // android.view.Window.Callback
    public final boolean onMenuOpened(int i, Menu menu) {
        b(i, menu);
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.e;
        if (i != 108) {
            layoutInflaterFactory2C3250i5.getClass();
            return true;
        }
        layoutInflaterFactory2C3250i5.A();
        P30 p30 = layoutInflaterFactory2C3250i5.o;
        if (p30 != null && true != p30.v) {
            p30.v = true;
            ArrayList arrayList = p30.w;
            if (arrayList.size() > 0) {
                arrayList.get(0).getClass();
                throw new ClassCastException();
            }
        }
        return true;
    }

    @Override // android.view.Window.Callback
    public final void onPanelClosed(int i, Menu menu) {
        if (this.d) {
            this.a.onPanelClosed(i, menu);
            return;
        }
        c(i, menu);
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.e;
        if (i != 108) {
            if (i != 0) {
                layoutInflaterFactory2C3250i5.getClass();
                return;
            }
            C3170h5 z = layoutInflaterFactory2C3250i5.z(i);
            if (z.m) {
                layoutInflaterFactory2C3250i5.s(z, false);
                return;
            }
            return;
        }
        layoutInflaterFactory2C3250i5.A();
        P30 p30 = layoutInflaterFactory2C3250i5.o;
        if (p30 == null || !p30.v) {
            return;
        }
        p30.v = false;
        ArrayList arrayList = p30.w;
        if (arrayList.size() <= 0) {
            return;
        }
        arrayList.get(0).getClass();
        throw new ClassCastException();
    }

    @Override // android.view.Window.Callback
    public final void onPointerCaptureChanged(boolean z) {
        L30.a(this.a, z);
    }

    @Override // android.view.Window.Callback
    public final boolean onPreparePanel(int i, View view, Menu menu) {
        MenuC2945eF menuC2945eF = menu instanceof MenuC2945eF ? (MenuC2945eF) menu : null;
        if (i == 0 && menuC2945eF == null) {
            return false;
        }
        if (menuC2945eF != null) {
            menuC2945eF.x = true;
        }
        boolean onPreparePanel = this.a.onPreparePanel(i, view, menu);
        if (menuC2945eF != null) {
            menuC2945eF.x = false;
        }
        return onPreparePanel;
    }

    @Override // android.view.Window.Callback
    public final void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
        MenuC2945eF menuC2945eF = this.e.z(0).h;
        if (menuC2945eF != null) {
            d(list, menuC2945eF, i);
        } else {
            d(list, menu, i);
        }
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested(SearchEvent searchEvent) {
        return J30.a(this.a, searchEvent);
    }

    @Override // android.view.Window.Callback
    public final void onWindowAttributesChanged(WindowManager.LayoutParams layoutParams) {
        this.a.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.view.Window.Callback
    public final void onWindowFocusChanged(boolean z) {
        this.a.onWindowFocusChanged(z);
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
        ViewGroup viewGroup;
        int i2 = 1;
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = this.e;
        layoutInflaterFactory2C3250i5.getClass();
        if (i != 0) {
            return J30.b(this.a, callback, i);
        }
        Context context = layoutInflaterFactory2C3250i5.k;
        FR fr = new FR();
        fr.b = context;
        fr.a = callback;
        fr.c = new ArrayList();
        fr.d = new C4386wT(0);
        AbstractC3797p1 abstractC3797p1 = layoutInflaterFactory2C3250i5.u;
        if (abstractC3797p1 != null) {
            abstractC3797p1.a();
        }
        ML ml = new ML(9, layoutInflaterFactory2C3250i5, fr);
        layoutInflaterFactory2C3250i5.A();
        P30 p30 = layoutInflaterFactory2C3250i5.o;
        if (p30 != null) {
            O30 o30 = p30.s;
            if (o30 != null) {
                o30.a();
            }
            p30.m.setHideOnContentScrollEnabled(false);
            p30.p.e();
            O30 o302 = new O30(p30, p30.p.getContext(), ml);
            MenuC2945eF menuC2945eF = o302.d;
            menuC2945eF.w();
            try {
                if (((FR) o302.e.b).k(o302, menuC2945eF)) {
                    p30.s = o302;
                    o302.g();
                    p30.p.c(o302);
                    p30.Z(true);
                } else {
                    o302 = null;
                }
                layoutInflaterFactory2C3250i5.u = o302;
            } finally {
                menuC2945eF.v();
            }
        }
        if (layoutInflaterFactory2C3250i5.u == null) {
            C4352w20 c4352w20 = layoutInflaterFactory2C3250i5.y;
            if (c4352w20 != null) {
                c4352w20.b();
            }
            AbstractC3797p1 abstractC3797p12 = layoutInflaterFactory2C3250i5.u;
            if (abstractC3797p12 != null) {
                abstractC3797p12.a();
            }
            if (layoutInflaterFactory2C3250i5.v == null) {
                boolean z = layoutInflaterFactory2C3250i5.I;
                Context context2 = layoutInflaterFactory2C3250i5.k;
                if (z) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = context2.getTheme();
                    theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Resources.Theme newTheme = context2.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        C0172Gg c0172Gg = new C0172Gg(context2, 0);
                        c0172Gg.getTheme().setTo(newTheme);
                        context2 = c0172Gg;
                    }
                    layoutInflaterFactory2C3250i5.v = new ActionBarContextView(context2, null);
                    PopupWindow popupWindow = new PopupWindow(context2, (AttributeSet) null, R.attr.actionModePopupWindowStyle);
                    layoutInflaterFactory2C3250i5.w = popupWindow;
                    popupWindow.setWindowLayoutType(2);
                    layoutInflaterFactory2C3250i5.w.setContentView(layoutInflaterFactory2C3250i5.v);
                    layoutInflaterFactory2C3250i5.w.setWidth(-1);
                    context2.getTheme().resolveAttribute(R.attr.actionBarSize, typedValue, true);
                    layoutInflaterFactory2C3250i5.v.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, context2.getResources().getDisplayMetrics()));
                    layoutInflaterFactory2C3250i5.w.setHeight(-2);
                    layoutInflaterFactory2C3250i5.x = new V4(layoutInflaterFactory2C3250i5, i2);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) layoutInflaterFactory2C3250i5.A.findViewById(R.id.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        layoutInflaterFactory2C3250i5.A();
                        P30 p302 = layoutInflaterFactory2C3250i5.o;
                        Context a0 = p302 != null ? p302.a0() : null;
                        if (a0 != null) {
                            context2 = a0;
                        }
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(context2));
                        layoutInflaterFactory2C3250i5.v = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (layoutInflaterFactory2C3250i5.v != null) {
                C4352w20 c4352w202 = layoutInflaterFactory2C3250i5.y;
                if (c4352w202 != null) {
                    c4352w202.b();
                }
                layoutInflaterFactory2C3250i5.v.e();
                Context context3 = layoutInflaterFactory2C3250i5.v.getContext();
                ActionBarContextView actionBarContextView = layoutInflaterFactory2C3250i5.v;
                KU ku = new KU();
                ku.c = context3;
                ku.d = actionBarContextView;
                ku.e = ml;
                MenuC2945eF menuC2945eF2 = new MenuC2945eF(actionBarContextView.getContext());
                menuC2945eF2.l = 1;
                ku.h = menuC2945eF2;
                menuC2945eF2.e = ku;
                if (((FR) ml.b).k(ku, menuC2945eF2)) {
                    ku.g();
                    layoutInflaterFactory2C3250i5.v.c(ku);
                    layoutInflaterFactory2C3250i5.u = ku;
                    if (layoutInflaterFactory2C3250i5.z && (viewGroup = layoutInflaterFactory2C3250i5.A) != null && viewGroup.isLaidOut()) {
                        layoutInflaterFactory2C3250i5.v.setAlpha(0.0f);
                        C4352w20 a = AbstractC2925e20.a(layoutInflaterFactory2C3250i5.v);
                        a.a(1.0f);
                        layoutInflaterFactory2C3250i5.y = a;
                        a.d(new X4(layoutInflaterFactory2C3250i5, i2));
                    } else {
                        layoutInflaterFactory2C3250i5.v.setAlpha(1.0f);
                        layoutInflaterFactory2C3250i5.v.setVisibility(0);
                        if (layoutInflaterFactory2C3250i5.v.getParent() instanceof View) {
                            View view = (View) layoutInflaterFactory2C3250i5.v.getParent();
                            WeakHashMap weakHashMap = AbstractC2925e20.a;
                            view.requestApplyInsets();
                        }
                    }
                    if (layoutInflaterFactory2C3250i5.w != null) {
                        layoutInflaterFactory2C3250i5.l.getDecorView().post(layoutInflaterFactory2C3250i5.x);
                    }
                } else {
                    layoutInflaterFactory2C3250i5.u = null;
                }
            }
            layoutInflaterFactory2C3250i5.I();
            layoutInflaterFactory2C3250i5.u = layoutInflaterFactory2C3250i5.u;
        }
        layoutInflaterFactory2C3250i5.I();
        AbstractC3797p1 abstractC3797p13 = layoutInflaterFactory2C3250i5.u;
        if (abstractC3797p13 != null) {
            return fr.d(abstractC3797p13);
        }
        return null;
    }

    @Override // android.view.Window.Callback
    public final boolean onSearchRequested() {
        return this.a.onSearchRequested();
    }

    @Override // android.view.Window.Callback
    public final ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
        return null;
    }
}
