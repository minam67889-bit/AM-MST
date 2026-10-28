package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.LongSparseArray;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.ExpandedMenuView;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.WeakHashMap;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* renamed from: i5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class LayoutInflaterFactory2C3250i5 extends U4 implements InterfaceC0870cF, LayoutInflater.Factory2 {
    public static final C4386wT h0 = new C4386wT(0);
    public static final int[] i0 = {R.attr.windowBackground};
    public static final boolean j0 = !"robolectric".equals(Build.FINGERPRINT);
    public ViewGroup A;
    public TextView B;
    public View C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public C3170h5[] L;
    public C3170h5 M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public Configuration R;
    public final int S;
    public int T;
    public int U;
    public boolean V;
    public C2851d5 W;
    public C2851d5 X;
    public boolean Y;
    public int Z;
    public boolean b0;
    public Rect c0;
    public Rect d0;
    public C0778b6 e0;
    public OnBackInvokedDispatcher f0;
    public OnBackInvokedCallback g0;
    public final Object j;
    public final Context k;
    public Window l;
    public WindowCallbackC0855c5 m;
    public final Object n;
    public P30 o;
    public MV p;
    public CharSequence q;
    public InterfaceC0564Vj r;
    public C2835cv s;
    public W4 t;
    public AbstractC3797p1 u;
    public ActionBarContextView v;
    public PopupWindow w;
    public V4 x;
    public boolean z;
    public C4352w20 y = null;
    public final V4 a0 = new V4(this, 0);

    public LayoutInflaterFactory2C3250i5(Context context, Window window, M4 m4, Object obj) {
        I4 i4 = null;
        this.S = -100;
        this.k = context;
        this.n = m4;
        this.j = obj;
        if (obj instanceof Dialog) {
            while (true) {
                if (context != null) {
                    if (!(context instanceof I4)) {
                        if (!(context instanceof ContextWrapper)) {
                            break;
                        } else {
                            context = ((ContextWrapper) context).getBaseContext();
                        }
                    } else {
                        i4 = (I4) context;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (i4 != null) {
                this.S = ((LayoutInflaterFactory2C3250i5) i4.g()).S;
            }
        }
        if (this.S == -100) {
            C4386wT c4386wT = h0;
            Integer num = (Integer) c4386wT.get(this.j.getClass().getName());
            if (num != null) {
                this.S = num.intValue();
                c4386wT.remove(this.j.getClass().getName());
            }
        }
        if (window != null) {
            n(window);
        }
        C3408k5.d();
    }

    public static C0868cD o(Context context) {
        C0868cD c0868cD;
        C0868cD c0868cD2;
        if (Build.VERSION.SDK_INT >= 33 || (c0868cD = U4.c) == null) {
            return null;
        }
        C0868cD b = Z4.b(context.getApplicationContext().getResources().getConfiguration());
        C2864dD c2864dD = c0868cD.a;
        if (c2864dD.a.isEmpty()) {
            c0868cD2 = C0868cD.b;
        } else {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            while (i < b.a.a.size() + c2864dD.a.size()) {
                Locale locale = i < c2864dD.a.size() ? c2864dD.a.get(i) : b.a.a.get(i - c2864dD.a.size());
                if (locale != null) {
                    linkedHashSet.add(locale);
                }
                i++;
            }
            c0868cD2 = new C0868cD(new C2864dD(new LocaleList((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]))));
        }
        return c0868cD2.a.a.isEmpty() ? b : c0868cD2;
    }

    public static Configuration t(Context context, int i, C0868cD c0868cD, Configuration configuration, boolean z) {
        int i2 = i != 1 ? i != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i2 | (configuration2.uiMode & (-49));
        if (c0868cD != null) {
            Z4.d(configuration2, c0868cD);
        }
        return configuration2;
    }

    public final void A() {
        w();
        if (this.F && this.o == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                this.o = new P30((Activity) obj, this.G);
            } else if (obj instanceof Dialog) {
                this.o = new P30((Dialog) obj);
            }
            P30 p30 = this.o;
            if (p30 != null) {
                p30.c0(this.b0);
            }
        }
    }

    public final void B(int i) {
        this.Z = (1 << i) | this.Z;
        if (this.Y) {
            return;
        }
        View decorView = this.l.getDecorView();
        V4 v4 = this.a0;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        decorView.postOnAnimation(v4);
        this.Y = true;
    }

    public final int C(Context context, int i) {
        if (i != -100) {
            if (i != -1) {
                if (i != 0) {
                    if (i != 1 && i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                        }
                        if (this.X == null) {
                            this.X = new C2851d5(this, context);
                        }
                        return this.X.e();
                    }
                } else if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() != 0) {
                    return y(context).e();
                }
            }
            return i;
        }
        return -1;
    }

    public final boolean D() {
        InterfaceC0590Wj interfaceC0590Wj;
        C3759oX c3759oX;
        boolean z = this.N;
        this.N = false;
        C3170h5 z2 = z(0);
        if (!z2.m) {
            AbstractC3797p1 abstractC3797p1 = this.u;
            if (abstractC3797p1 != null) {
                abstractC3797p1.a();
                return true;
            }
            A();
            P30 p30 = this.o;
            if (p30 == null || (interfaceC0590Wj = p30.o) == null || (c3759oX = ((C4232uX) interfaceC0590Wj).a.L) == null || c3759oX.b == null) {
                return false;
            }
            C3759oX c3759oX2 = ((C4232uX) interfaceC0590Wj).a.L;
            C3503lF c3503lF = c3759oX2 == null ? null : c3759oX2.b;
            if (c3503lF != null) {
                c3503lF.collapseActionView();
            }
        } else if (!z) {
            s(z2, true);
            return true;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x0175, code lost:
    
        if (r3.f.getCount() > 0) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0155, code lost:
    
        if (r3 != null) goto L77;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void E(C3170h5 c3170h5, KeyEvent keyEvent) {
        int i;
        ViewGroup.LayoutParams layoutParams;
        if (c3170h5.m || this.Q) {
            return;
        }
        int i2 = c3170h5.a;
        Context context = this.k;
        if (i2 == 0 && (context.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callback = this.l.getCallback();
        if (callback != null && !callback.onMenuOpened(i2, c3170h5.h)) {
            s(c3170h5, true);
            return;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || !G(c3170h5, keyEvent)) {
            return;
        }
        C3090g5 c3090g5 = c3170h5.e;
        if (c3090g5 == null || c3170h5.n) {
            if (c3090g5 == null) {
                A();
                P30 p30 = this.o;
                Context a0 = p30 != null ? p30.a0() : null;
                if (a0 != null) {
                    context = a0;
                }
                TypedValue typedValue = new TypedValue();
                Resources.Theme newTheme = context.getResources().newTheme();
                newTheme.setTo(context.getTheme());
                newTheme.resolveAttribute(dastan.prince.bdfreevpn.R.attr.actionBarPopupTheme, typedValue, true);
                int i3 = typedValue.resourceId;
                if (i3 != 0) {
                    newTheme.applyStyle(i3, true);
                }
                newTheme.resolveAttribute(dastan.prince.bdfreevpn.R.attr.panelMenuListTheme, typedValue, true);
                int i4 = typedValue.resourceId;
                if (i4 != 0) {
                    newTheme.applyStyle(i4, true);
                } else {
                    newTheme.applyStyle(dastan.prince.bdfreevpn.R.style.Theme_AppCompat_CompactMenu, true);
                }
                C0172Gg c0172Gg = new C0172Gg(context, 0);
                c0172Gg.getTheme().setTo(newTheme);
                c3170h5.j = c0172Gg;
                TypedArray obtainStyledAttributes = c0172Gg.obtainStyledAttributes(GM.j);
                c3170h5.b = obtainStyledAttributes.getResourceId(86, 0);
                c3170h5.d = obtainStyledAttributes.getResourceId(1, 0);
                obtainStyledAttributes.recycle();
                c3170h5.e = new C3090g5(this, c3170h5.j);
                c3170h5.c = 81;
            } else if (c3170h5.n && c3090g5.getChildCount() > 0) {
                c3170h5.e.removeAllViews();
            }
            View view = c3170h5.g;
            if (view == null) {
                if (c3170h5.h != null) {
                    if (this.t == null) {
                        this.t = new W4(this);
                    }
                    W4 w4 = this.t;
                    if (c3170h5.i == null) {
                        C4132tC c4132tC = new C4132tC(c3170h5.j);
                        c3170h5.i = c4132tC;
                        c4132tC.e = w4;
                        MenuC2945eF menuC2945eF = c3170h5.h;
                        menuC2945eF.b(c4132tC, menuC2945eF.a);
                    }
                    C4132tC c4132tC2 = c3170h5.i;
                    C3090g5 c3090g52 = c3170h5.e;
                    if (c4132tC2.d == null) {
                        c4132tC2.d = (ExpandedMenuView) c4132tC2.b.inflate(dastan.prince.bdfreevpn.R.layout.abc_expanded_menu_layout, (ViewGroup) c3090g52, false);
                        if (c4132tC2.f == null) {
                            c4132tC2.f = new C4053sC(c4132tC2);
                        }
                        c4132tC2.d.setAdapter((ListAdapter) c4132tC2.f);
                        c4132tC2.d.setOnItemClickListener(c4132tC2);
                    }
                    ExpandedMenuView expandedMenuView = c4132tC2.d;
                    c3170h5.f = expandedMenuView;
                }
                c3170h5.n = true;
                return;
            }
            c3170h5.f = view;
            if (c3170h5.f != null) {
                if (c3170h5.g == null) {
                    C4132tC c4132tC3 = c3170h5.i;
                    if (c4132tC3.f == null) {
                        c4132tC3.f = new C4053sC(c4132tC3);
                    }
                }
                ViewGroup.LayoutParams layoutParams2 = c3170h5.f.getLayoutParams();
                if (layoutParams2 == null) {
                    layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                }
                c3170h5.e.setBackgroundResource(c3170h5.b);
                ViewParent parent = c3170h5.f.getParent();
                if (parent instanceof ViewGroup) {
                    ((ViewGroup) parent).removeView(c3170h5.f);
                }
                c3170h5.e.addView(c3170h5.f, layoutParams2);
                if (!c3170h5.f.hasFocus()) {
                    c3170h5.f.requestFocus();
                }
            }
            c3170h5.n = true;
            return;
        }
        View view2 = c3170h5.g;
        if (view2 != null && (layoutParams = view2.getLayoutParams()) != null && layoutParams.width == -1) {
            i = -1;
            c3170h5.l = false;
            WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
            layoutParams3.gravity = c3170h5.c;
            layoutParams3.windowAnimations = c3170h5.d;
            windowManager.addView(c3170h5.e, layoutParams3);
            c3170h5.m = true;
            if (i2 != 0) {
                I();
                return;
            }
            return;
        }
        i = -2;
        c3170h5.l = false;
        WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i, -2, 0, 0, 1002, 8519680, -3);
        layoutParams32.gravity = c3170h5.c;
        layoutParams32.windowAnimations = c3170h5.d;
        windowManager.addView(c3170h5.e, layoutParams32);
        c3170h5.m = true;
        if (i2 != 0) {
        }
    }

    public final boolean F(C3170h5 c3170h5, int i, KeyEvent keyEvent) {
        MenuC2945eF menuC2945eF;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((c3170h5.k || G(c3170h5, keyEvent)) && (menuC2945eF = c3170h5.h) != null) {
            return menuC2945eF.performShortcut(i, keyEvent, 1);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cd, code lost:
    
        if (r13.h == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean G(C3170h5 c3170h5, KeyEvent keyEvent) {
        InterfaceC0564Vj interfaceC0564Vj;
        InterfaceC0564Vj interfaceC0564Vj2;
        Resources.Theme theme;
        InterfaceC0564Vj interfaceC0564Vj3;
        InterfaceC0564Vj interfaceC0564Vj4;
        if (!this.Q) {
            if (c3170h5.k) {
                return true;
            }
            C3170h5 c3170h52 = this.M;
            if (c3170h52 != null && c3170h52 != c3170h5) {
                s(c3170h52, false);
            }
            Window.Callback callback = this.l.getCallback();
            int i = c3170h5.a;
            if (callback != null) {
                c3170h5.g = callback.onCreatePanelView(i);
            }
            boolean z = i == 0 || i == 108;
            if (z && (interfaceC0564Vj4 = this.r) != null) {
                ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0564Vj4;
                actionBarOverlayLayout.k();
                ((C4232uX) actionBarOverlayLayout.e).l = true;
            }
            if (c3170h5.g == null) {
                MenuC2945eF menuC2945eF = c3170h5.h;
                if (menuC2945eF == null || c3170h5.o) {
                    if (menuC2945eF == null) {
                        Context context = this.k;
                        if ((i == 0 || i == 108) && this.r != null) {
                            TypedValue typedValue = new TypedValue();
                            Resources.Theme theme2 = context.getTheme();
                            theme2.resolveAttribute(dastan.prince.bdfreevpn.R.attr.actionBarTheme, typedValue, true);
                            if (typedValue.resourceId != 0) {
                                theme = context.getResources().newTheme();
                                theme.setTo(theme2);
                                theme.applyStyle(typedValue.resourceId, true);
                                theme.resolveAttribute(dastan.prince.bdfreevpn.R.attr.actionBarWidgetTheme, typedValue, true);
                            } else {
                                theme2.resolveAttribute(dastan.prince.bdfreevpn.R.attr.actionBarWidgetTheme, typedValue, true);
                                theme = null;
                            }
                            if (typedValue.resourceId != 0) {
                                if (theme == null) {
                                    theme = context.getResources().newTheme();
                                    theme.setTo(theme2);
                                }
                                theme.applyStyle(typedValue.resourceId, true);
                            }
                            if (theme != null) {
                                C0172Gg c0172Gg = new C0172Gg(context, 0);
                                c0172Gg.getTheme().setTo(theme);
                                context = c0172Gg;
                            }
                        }
                        MenuC2945eF menuC2945eF2 = new MenuC2945eF(context);
                        menuC2945eF2.e = this;
                        MenuC2945eF menuC2945eF3 = c3170h5.h;
                        if (menuC2945eF2 != menuC2945eF3) {
                            if (menuC2945eF3 != null) {
                                menuC2945eF3.r(c3170h5.i);
                            }
                            c3170h5.h = menuC2945eF2;
                            C4132tC c4132tC = c3170h5.i;
                            if (c4132tC != null) {
                                menuC2945eF2.b(c4132tC, menuC2945eF2.a);
                            }
                        }
                    }
                    if (z && (interfaceC0564Vj2 = this.r) != null) {
                        if (this.s == null) {
                            this.s = new C2835cv(this, 6);
                        }
                        ((ActionBarOverlayLayout) interfaceC0564Vj2).l(c3170h5.h, this.s);
                    }
                    c3170h5.h.w();
                    if (callback.onCreatePanelMenu(i, c3170h5.h)) {
                        c3170h5.o = false;
                    } else {
                        MenuC2945eF menuC2945eF4 = c3170h5.h;
                        if (menuC2945eF4 != null) {
                            if (menuC2945eF4 != null) {
                                menuC2945eF4.r(c3170h5.i);
                            }
                            c3170h5.h = null;
                        }
                        if (z && (interfaceC0564Vj = this.r) != null) {
                            ((ActionBarOverlayLayout) interfaceC0564Vj).l(null, this.s);
                        }
                    }
                }
                c3170h5.h.w();
                Bundle bundle = c3170h5.p;
                if (bundle != null) {
                    c3170h5.h.s(bundle);
                    c3170h5.p = null;
                }
                if (!callback.onPreparePanel(0, c3170h5.g, c3170h5.h)) {
                    if (z && (interfaceC0564Vj3 = this.r) != null) {
                        ((ActionBarOverlayLayout) interfaceC0564Vj3).l(null, this.s);
                    }
                    c3170h5.h.v();
                    return false;
                }
                c3170h5.h.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
                c3170h5.h.v();
            }
            c3170h5.k = true;
            c3170h5.l = false;
            this.M = c3170h5;
            return true;
        }
        return false;
    }

    public final void H() {
        if (this.z) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    public final void I() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean z = false;
            if (this.f0 != null && (z(0).m || this.u != null)) {
                z = true;
            }
            if (z && this.g0 == null) {
                this.g0 = AbstractC0776b5.b(this.f0, this);
            } else {
                if (z || (onBackInvokedCallback = this.g0) == null) {
                    return;
                }
                AbstractC0776b5.c(this.f0, onBackInvokedCallback);
                this.g0 = null;
            }
        }
    }

    @Override // defpackage.U4
    public final void a() {
        LayoutInflater from = LayoutInflater.from(this.k);
        if (from.getFactory() == null) {
            from.setFactory2(this);
        } else {
            if (from.getFactory2() instanceof LayoutInflaterFactory2C3250i5) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    @Override // defpackage.U4
    public final void b() {
        if (this.o != null) {
            A();
            this.o.getClass();
            B(0);
        }
    }

    @Override // defpackage.U4
    public final void d() {
        String str;
        this.O = true;
        m(false, true);
        x();
        Object obj = this.j;
        if (obj instanceof Activity) {
            try {
                Activity activity = (Activity) obj;
                try {
                    str = W80.E(activity, activity.getComponentName());
                } catch (PackageManager.NameNotFoundException e) {
                    throw new IllegalArgumentException(e);
                }
            } catch (IllegalArgumentException unused) {
                str = null;
            }
            if (str != null) {
                P30 p30 = this.o;
                if (p30 == null) {
                    this.b0 = true;
                } else {
                    p30.c0(true);
                }
            }
            synchronized (U4.h) {
                U4.f(this);
                U4.g.add(new WeakReference(this));
            }
        }
        this.R = new Configuration(this.k.getResources().getConfiguration());
        this.P = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    @Override // defpackage.U4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void e() {
        C2851d5 c2851d5;
        C2851d5 c2851d52;
        if (this.j instanceof Activity) {
            synchronized (U4.h) {
                U4.f(this);
            }
        }
        if (this.Y) {
            this.l.getDecorView().removeCallbacks(this.a0);
        }
        this.Q = true;
        if (this.S != -100) {
            Object obj = this.j;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                h0.put(this.j.getClass().getName(), Integer.valueOf(this.S));
                c2851d5 = this.W;
                if (c2851d5 != null) {
                    c2851d5.c();
                }
                c2851d52 = this.X;
                if (c2851d52 == null) {
                    c2851d52.c();
                    return;
                }
                return;
            }
        }
        h0.remove(this.j.getClass().getName());
        c2851d5 = this.W;
        if (c2851d5 != null) {
        }
        c2851d52 = this.X;
        if (c2851d52 == null) {
        }
    }

    @Override // defpackage.U4
    public final boolean g(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            i = 108;
        } else if (i == 9) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            i = 109;
        }
        if (this.J && i == 108) {
            return false;
        }
        if (this.F && i == 1) {
            this.F = false;
        }
        if (i == 1) {
            H();
            this.J = true;
            return true;
        }
        if (i == 2) {
            H();
            this.D = true;
            return true;
        }
        if (i == 5) {
            H();
            this.E = true;
            return true;
        }
        if (i == 10) {
            H();
            this.H = true;
            return true;
        }
        if (i == 108) {
            H();
            this.F = true;
            return true;
        }
        if (i != 109) {
            return this.l.requestFeature(i);
        }
        H();
        this.G = true;
        return true;
    }

    @Override // defpackage.U4
    public final void h(int i) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.k).inflate(i, viewGroup);
        this.m.a(this.l.getCallback());
    }

    @Override // defpackage.InterfaceC0870cF
    public final boolean i(MenuC2945eF menuC2945eF, MenuItem menuItem) {
        C3170h5 c3170h5;
        Window.Callback callback = this.l.getCallback();
        if (callback != null && !this.Q) {
            MenuC2945eF k = menuC2945eF.k();
            C3170h5[] c3170h5Arr = this.L;
            int length = c3170h5Arr != null ? c3170h5Arr.length : 0;
            int i = 0;
            while (true) {
                if (i < length) {
                    c3170h5 = c3170h5Arr[i];
                    if (c3170h5 != null && c3170h5.h == k) {
                        break;
                    }
                    i++;
                } else {
                    c3170h5 = null;
                    break;
                }
            }
            if (c3170h5 != null) {
                return callback.onMenuItemSelected(c3170h5.a, menuItem);
            }
        }
        return false;
    }

    @Override // defpackage.U4
    public final void j(View view) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.m.a(this.l.getCallback());
    }

    @Override // defpackage.U4
    public final void k(View view, ViewGroup.LayoutParams layoutParams) {
        w();
        ViewGroup viewGroup = (ViewGroup) this.A.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.m.a(this.l.getCallback());
    }

    @Override // defpackage.U4
    public final void l(CharSequence charSequence) {
        this.q = charSequence;
        InterfaceC0564Vj interfaceC0564Vj = this.r;
        if (interfaceC0564Vj != null) {
            interfaceC0564Vj.setWindowTitle(charSequence);
            return;
        }
        P30 p30 = this.o;
        if (p30 == null) {
            TextView textView = this.B;
            if (textView != null) {
                textView.setText(charSequence);
                return;
            }
            return;
        }
        C4232uX c4232uX = (C4232uX) p30.o;
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:145:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0243  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00fe A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0190  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m(boolean z, boolean z2) {
        int i;
        Configuration configuration;
        C0868cD b;
        int i2;
        boolean z3;
        Object obj;
        Object obj2;
        Activity activity;
        if (this.Q) {
            return false;
        }
        int i3 = this.S;
        if (i3 == -100) {
            i3 = U4.b;
        }
        int i4 = i3;
        Context context = this.k;
        int C = C(context, i4);
        int i5 = Build.VERSION.SDK_INT;
        LongSparseArray longSparseArray = null;
        C0868cD o = i5 < 33 ? o(context) : null;
        if (!z2 && o != null) {
            o = Z4.b(context.getResources().getConfiguration());
        }
        Configuration t = t(context, C, o, null, false);
        boolean z4 = this.V;
        Object obj3 = this.j;
        boolean z5 = true;
        if (!z4 && (obj3 instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                i = 0;
                configuration = this.R;
                if (configuration == null) {
                    configuration = context.getResources().getConfiguration();
                }
                int i6 = configuration.uiMode & 48;
                int i7 = t.uiMode & 48;
                C0868cD b2 = Z4.b(configuration);
                b = o != null ? null : Z4.b(t);
                i2 = i6 == i7 ? UserVerificationMethods.USER_VERIFY_NONE : 0;
                if (b != null && !b2.equals(b)) {
                    i2 |= 8196;
                }
                if (((~i) & i2) != 0 && z && this.O && ((j0 || this.P) && (obj3 instanceof Activity))) {
                    activity = (Activity) obj3;
                    if (!activity.isChild()) {
                        int i8 = Build.VERSION.SDK_INT;
                        if (i8 >= 31 && (i2 & JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE) != 0) {
                            activity.getWindow().getDecorView().setLayoutDirection(t.getLayoutDirection());
                        }
                        if (i8 >= 28) {
                            activity.recreate();
                        } else {
                            new Handler(activity.getMainLooper()).post(new RunnableC3954r1(activity, r3));
                        }
                        z3 = true;
                        if (!z3 || i2 == 0) {
                            z5 = z3;
                        } else {
                            r3 = (i & i2) == i2 ? 1 : 0;
                            Resources resources = context.getResources();
                            Configuration configuration2 = new Configuration(resources.getConfiguration());
                            configuration2.uiMode = (resources.getConfiguration().uiMode & (-49)) | i7;
                            if (b != null) {
                                Z4.d(configuration2, b);
                            }
                            resources.updateConfiguration(configuration2, null);
                            int i9 = Build.VERSION.SDK_INT;
                            if (i9 < 26 && i9 < 28) {
                                if (!S50.G) {
                                    try {
                                        Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                                        S50.F = declaredField;
                                        declaredField.setAccessible(true);
                                    } catch (NoSuchFieldException e) {
                                        Log.e("ResourcesFlusher", "Could not retrieve Resources#mResourcesImpl field", e);
                                    }
                                    S50.G = true;
                                }
                                Field field = S50.F;
                                if (field != null) {
                                    try {
                                        obj = field.get(resources);
                                    } catch (IllegalAccessException e2) {
                                        Log.e("ResourcesFlusher", "Could not retrieve value from Resources#mResourcesImpl", e2);
                                        obj = null;
                                    }
                                    if (obj != null) {
                                        if (!S50.A) {
                                            try {
                                                Field declaredField2 = obj.getClass().getDeclaredField("mDrawableCache");
                                                S50.z = declaredField2;
                                                declaredField2.setAccessible(true);
                                            } catch (NoSuchFieldException e3) {
                                                Log.e("ResourcesFlusher", "Could not retrieve ResourcesImpl#mDrawableCache field", e3);
                                            }
                                            S50.A = true;
                                        }
                                        Field field2 = S50.z;
                                        if (field2 != null) {
                                            try {
                                                obj2 = field2.get(obj);
                                            } catch (IllegalAccessException e4) {
                                                Log.e("ResourcesFlusher", "Could not retrieve value from ResourcesImpl#mDrawableCache", e4);
                                            }
                                            if (obj2 != null) {
                                                if (!S50.C) {
                                                    try {
                                                        S50.B = Class.forName("android.content.res.ThemedResourceCache");
                                                    } catch (ClassNotFoundException e5) {
                                                        Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e5);
                                                    }
                                                    S50.C = true;
                                                }
                                                Class cls = S50.B;
                                                if (cls != null) {
                                                    if (!S50.E) {
                                                        try {
                                                            Field declaredField3 = cls.getDeclaredField("mUnthemedEntries");
                                                            S50.D = declaredField3;
                                                            declaredField3.setAccessible(true);
                                                        } catch (NoSuchFieldException e6) {
                                                            Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e6);
                                                        }
                                                        S50.E = true;
                                                    }
                                                    Field field3 = S50.D;
                                                    if (field3 != null) {
                                                        try {
                                                            longSparseArray = (LongSparseArray) field3.get(obj2);
                                                        } catch (IllegalAccessException e7) {
                                                            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e7);
                                                        }
                                                        if (longSparseArray != null) {
                                                            longSparseArray.clear();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        obj2 = null;
                                        if (obj2 != null) {
                                        }
                                    }
                                }
                            }
                            int i10 = this.T;
                            if (i10 != 0) {
                                context.setTheme(i10);
                                context.getTheme().applyStyle(this.T, true);
                            }
                            if (r3 != 0 && (obj3 instanceof Activity)) {
                                Activity activity2 = (Activity) obj3;
                                if (activity2 instanceof EB) {
                                    if (((HB) ((EB) activity2).getLifecycle()).h.compareTo(EnumC4526yB.c) >= 0) {
                                        activity2.onConfigurationChanged(configuration2);
                                    }
                                } else if (this.P && !this.Q) {
                                    activity2.onConfigurationChanged(configuration2);
                                }
                            }
                        }
                        if (z5 && (obj3 instanceof I4)) {
                            if ((i2 & UserVerificationMethods.USER_VERIFY_NONE) != 0) {
                            }
                            if ((i2 & 4) != 0) {
                            }
                        }
                        if (b != null) {
                            Z4.c(Z4.b(context.getResources().getConfiguration()));
                        }
                        if (i4 == 0) {
                            y(context).h();
                        } else {
                            C2851d5 c2851d5 = this.W;
                            if (c2851d5 != null) {
                                c2851d5.c();
                            }
                        }
                        if (i4 == 3) {
                            if (this.X == null) {
                                this.X = new C2851d5(this, context);
                            }
                            this.X.h();
                        } else {
                            C2851d5 c2851d52 = this.X;
                            if (c2851d52 != null) {
                                c2851d52.c();
                            }
                        }
                        return z5;
                    }
                }
                z3 = false;
                if (z3) {
                }
                z5 = z3;
                if (z5) {
                    if ((i2 & UserVerificationMethods.USER_VERIFY_NONE) != 0) {
                    }
                    if ((i2 & 4) != 0) {
                    }
                }
                if (b != null) {
                }
                if (i4 == 0) {
                }
                if (i4 == 3) {
                }
                return z5;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, obj3.getClass()), i5 >= 29 ? 269221888 : 786432);
                if (activityInfo != null) {
                    this.U = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e8) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e8);
                this.U = 0;
            }
        }
        this.V = true;
        i = this.U;
        configuration = this.R;
        if (configuration == null) {
        }
        int i62 = configuration.uiMode & 48;
        int i72 = t.uiMode & 48;
        C0868cD b22 = Z4.b(configuration);
        if (o != null) {
        }
        if (i62 == i72) {
        }
        if (b != null) {
            i2 |= 8196;
        }
        if (((~i) & i2) != 0) {
            activity = (Activity) obj3;
            if (!activity.isChild()) {
            }
        }
        z3 = false;
        if (z3) {
        }
        z5 = z3;
        if (z5) {
        }
        if (b != null) {
        }
        if (i4 == 0) {
        }
        if (i4 == 3) {
        }
        return z5;
    }

    public final void n(Window window) {
        Drawable drawable;
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        OnBackInvokedCallback onBackInvokedCallback;
        int resourceId;
        if (this.l != null) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof WindowCallbackC0855c5) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        WindowCallbackC0855c5 windowCallbackC0855c5 = new WindowCallbackC0855c5(this, callback);
        this.m = windowCallbackC0855c5;
        window.setCallback(windowCallbackC0855c5);
        int[] iArr = i0;
        Context context = this.k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, iArr);
        if (!obtainStyledAttributes.hasValue(0) || (resourceId = obtainStyledAttributes.getResourceId(0, 0)) == 0) {
            drawable = null;
        } else {
            C3408k5 a = C3408k5.a();
            synchronized (a) {
                drawable = a.a.d(context, resourceId, true);
            }
        }
        if (drawable != null) {
            window.setBackgroundDrawable(drawable);
        }
        obtainStyledAttributes.recycle();
        this.l = window;
        if (Build.VERSION.SDK_INT < 33 || (onBackInvokedDispatcher = this.f0) != null) {
            return;
        }
        if (onBackInvokedDispatcher != null && (onBackInvokedCallback = this.g0) != null) {
            AbstractC0776b5.c(onBackInvokedDispatcher, onBackInvokedCallback);
            this.g0 = null;
        }
        Object obj = this.j;
        if (obj instanceof Activity) {
            Activity activity = (Activity) obj;
            if (activity.getWindow() != null) {
                this.f0 = AbstractC0776b5.a(activity);
                I();
            }
        }
        this.f0 = null;
        I();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0112, code lost:
    
        if (r13.equals("ImageButton") == false) goto L24;
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.view.LayoutInflater.Factory2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        View c4199u5;
        char c = 4;
        if (this.e0 == null) {
            int[] iArr = GM.j;
            Context context2 = this.k;
            TypedArray obtainStyledAttributes = context2.obtainStyledAttributes(iArr);
            String string = obtainStyledAttributes.getString(116);
            obtainStyledAttributes.recycle();
            if (string == null) {
                this.e0 = new C0778b6();
            } else {
                try {
                    this.e0 = (C0778b6) context2.getClassLoader().loadClass(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.e0 = new C0778b6();
                }
            }
        }
        C0778b6 c0778b6 = this.e0;
        int i = E10.a;
        c0778b6.getClass();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, GM.y, 0, 0);
        int resourceId = obtainStyledAttributes2.getResourceId(4, 0);
        if (resourceId != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        obtainStyledAttributes2.recycle();
        Context c0172Gg = (resourceId == 0 || ((context instanceof C0172Gg) && ((C0172Gg) context).a == resourceId)) ? context : new C0172Gg(context, resourceId);
        str.getClass();
        View view2 = null;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -937446323:
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 799298502:
                if (str.equals("ToggleButton")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                c4199u5 = new C4199u5(c0172Gg, attributeSet);
                break;
            case 1:
                c4199u5 = new O4(c0172Gg, attributeSet);
                break;
            case 2:
                c4199u5 = new C3962r5(c0172Gg, attributeSet);
                break;
            case 3:
                c4199u5 = c0778b6.e(c0172Gg, attributeSet);
                break;
            case 4:
                c4199u5 = new C3726o5(c0172Gg, attributeSet, dastan.prince.bdfreevpn.R.attr.imageButtonStyle);
                break;
            case 5:
                c4199u5 = new C4357w5(c0172Gg, attributeSet);
                break;
            case 6:
                c4199u5 = new I5(c0172Gg, attributeSet);
                break;
            case 7:
                c4199u5 = c0778b6.d(c0172Gg, attributeSet);
                break;
            case '\b':
                c4199u5 = new Z5(c0172Gg, attributeSet);
                break;
            case '\t':
                c4199u5 = new C3884q5(c0172Gg, attributeSet, 0);
                break;
            case '\n':
                c4199u5 = c0778b6.a(c0172Gg, attributeSet);
                break;
            case 11:
                c4199u5 = c0778b6.c(c0172Gg, attributeSet);
                break;
            case '\f':
                c4199u5 = new C3568m5(c0172Gg, attributeSet, 0);
                break;
            case '\r':
                c4199u5 = c0778b6.b(c0172Gg, attributeSet);
                break;
            default:
                c4199u5 = null;
                break;
        }
        if (c4199u5 == null && context != c0172Gg) {
            Object[] objArr = c0778b6.a;
            if (str.equals("view")) {
                str = attributeSet.getAttributeValue(null, "class");
            }
            try {
                objArr[0] = c0172Gg;
                objArr[1] = attributeSet;
                if (-1 == str.indexOf(46)) {
                    int i2 = 0;
                    while (true) {
                        String[] strArr = C0778b6.g;
                        if (i2 < 3) {
                            View f = c0778b6.f(c0172Gg, str, strArr[i2]);
                            if (f != null) {
                                objArr[0] = null;
                                objArr[1] = null;
                                view2 = f;
                            } else {
                                i2++;
                            }
                        } else {
                            objArr[0] = null;
                            objArr[1] = null;
                        }
                    }
                } else {
                    View f2 = c0778b6.f(c0172Gg, str, null);
                    objArr[0] = null;
                    objArr[1] = null;
                    view2 = f2;
                }
            } catch (Exception unused) {
                objArr[0] = null;
                objArr[1] = null;
            } catch (Throwable th2) {
                objArr[0] = null;
                objArr[1] = null;
                throw th2;
            }
            c4199u5 = view2;
        }
        if (c4199u5 != null) {
            Context context3 = c4199u5.getContext();
            if ((context3 instanceof ContextWrapper) && c4199u5.hasOnClickListeners()) {
                TypedArray obtainStyledAttributes3 = context3.obtainStyledAttributes(attributeSet, C0778b6.c);
                String string2 = obtainStyledAttributes3.getString(0);
                if (string2 != null) {
                    c4199u5.setOnClickListener(new ViewOnClickListenerC0698a6(c4199u5, string2));
                }
                obtainStyledAttributes3.recycle();
            }
            if (Build.VERSION.SDK_INT <= 28) {
                TypedArray obtainStyledAttributes4 = c0172Gg.obtainStyledAttributes(attributeSet, C0778b6.d);
                if (obtainStyledAttributes4.hasValue(0)) {
                    boolean z = obtainStyledAttributes4.getBoolean(0, false);
                    WeakHashMap weakHashMap = AbstractC2925e20.a;
                    new S10(dastan.prince.bdfreevpn.R.id.tag_accessibility_heading, Boolean.class, 0, 28, 3).f(c4199u5, Boolean.valueOf(z));
                }
                obtainStyledAttributes4.recycle();
                TypedArray obtainStyledAttributes5 = c0172Gg.obtainStyledAttributes(attributeSet, C0778b6.e);
                if (obtainStyledAttributes5.hasValue(0)) {
                    AbstractC2925e20.n(c4199u5, obtainStyledAttributes5.getString(0));
                }
                obtainStyledAttributes5.recycle();
                TypedArray obtainStyledAttributes6 = c0172Gg.obtainStyledAttributes(attributeSet, C0778b6.f);
                if (obtainStyledAttributes6.hasValue(0)) {
                    boolean z2 = obtainStyledAttributes6.getBoolean(0, false);
                    WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                    new S10(dastan.prince.bdfreevpn.R.id.tag_screen_reader_focusable, Boolean.class, 0, 28, 0).f(c4199u5, Boolean.valueOf(z2));
                }
                obtainStyledAttributes6.recycle();
            }
        }
        return c4199u5;
    }

    public final void p(int i, C3170h5 c3170h5, MenuC2945eF menuC2945eF) {
        if (menuC2945eF == null) {
            if (c3170h5 == null && i >= 0) {
                C3170h5[] c3170h5Arr = this.L;
                if (i < c3170h5Arr.length) {
                    c3170h5 = c3170h5Arr[i];
                }
            }
            if (c3170h5 != null) {
                menuC2945eF = c3170h5.h;
            }
        }
        if ((c3170h5 == null || c3170h5.m) && !this.Q) {
            WindowCallbackC0855c5 windowCallbackC0855c5 = this.m;
            Window.Callback callback = this.l.getCallback();
            windowCallbackC0855c5.getClass();
            try {
                windowCallbackC0855c5.d = true;
                callback.onPanelClosed(i, menuC2945eF);
            } finally {
                windowCallbackC0855c5.d = false;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0048, code lost:
    
        if (r6.k() != false) goto L20;
     */
    @Override // defpackage.InterfaceC0870cF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(MenuC2945eF menuC2945eF) {
        ActionMenuView actionMenuView;
        C3480l1 c3480l1;
        C3480l1 c3480l12;
        C3480l1 c3480l13;
        InterfaceC0564Vj interfaceC0564Vj = this.r;
        if (interfaceC0564Vj != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0564Vj;
            actionBarOverlayLayout.k();
            Toolbar toolbar = ((C4232uX) actionBarOverlayLayout.e).a;
            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.a) != null && actionMenuView.s) {
                if (ViewConfiguration.get(this.k).hasPermanentMenuKey()) {
                    ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.r;
                    actionBarOverlayLayout2.k();
                    ActionMenuView actionMenuView2 = ((C4232uX) actionBarOverlayLayout2.e).a.a;
                    if (actionMenuView2 != null) {
                        C3480l1 c3480l14 = actionMenuView2.t;
                        if (c3480l14 != null) {
                            if (c3480l14.u == null) {
                            }
                        }
                    }
                }
                Window.Callback callback = this.l.getCallback();
                ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.r;
                actionBarOverlayLayout3.k();
                ActionMenuView actionMenuView3 = ((C4232uX) actionBarOverlayLayout3.e).a.a;
                if ((actionMenuView3 == null || (c3480l13 = actionMenuView3.t) == null || !c3480l13.k()) ? false : true) {
                    ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.r;
                    actionBarOverlayLayout4.k();
                    ActionMenuView actionMenuView4 = ((C4232uX) actionBarOverlayLayout4.e).a.a;
                    if (actionMenuView4 != null && (c3480l12 = actionMenuView4.t) != null) {
                        c3480l12.g();
                    }
                    if (this.Q) {
                        return;
                    }
                    callback.onPanelClosed(108, z(0).h);
                    return;
                }
                if (callback == null || this.Q) {
                    return;
                }
                if (this.Y && (1 & this.Z) != 0) {
                    View decorView = this.l.getDecorView();
                    V4 v4 = this.a0;
                    decorView.removeCallbacks(v4);
                    v4.run();
                }
                C3170h5 z = z(0);
                MenuC2945eF menuC2945eF2 = z.h;
                if (menuC2945eF2 == null || z.o || !callback.onPreparePanel(0, z.g, menuC2945eF2)) {
                    return;
                }
                callback.onMenuOpened(108, z.h);
                ActionBarOverlayLayout actionBarOverlayLayout5 = (ActionBarOverlayLayout) this.r;
                actionBarOverlayLayout5.k();
                ActionMenuView actionMenuView5 = ((C4232uX) actionBarOverlayLayout5.e).a.a;
                if (actionMenuView5 == null || (c3480l1 = actionMenuView5.t) == null) {
                    return;
                }
                c3480l1.l();
                return;
            }
        }
        C3170h5 z2 = z(0);
        z2.n = true;
        s(z2, false);
        E(z2, null);
    }

    public final void r(MenuC2945eF menuC2945eF) {
        C3480l1 c3480l1;
        if (this.K) {
            return;
        }
        this.K = true;
        ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) this.r;
        actionBarOverlayLayout.k();
        ActionMenuView actionMenuView = ((C4232uX) actionBarOverlayLayout.e).a.a;
        if (actionMenuView != null && (c3480l1 = actionMenuView.t) != null) {
            c3480l1.g();
            C3162h1 c3162h1 = c3480l1.t;
            if (c3162h1 != null && c3162h1.b()) {
                c3162h1.i.dismiss();
            }
        }
        Window.Callback callback = this.l.getCallback();
        if (callback != null && !this.Q) {
            callback.onPanelClosed(108, menuC2945eF);
        }
        this.K = false;
    }

    public final void s(C3170h5 c3170h5, boolean z) {
        C3090g5 c3090g5;
        InterfaceC0564Vj interfaceC0564Vj;
        C3480l1 c3480l1;
        if (z && c3170h5.a == 0 && (interfaceC0564Vj = this.r) != null) {
            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0564Vj;
            actionBarOverlayLayout.k();
            ActionMenuView actionMenuView = ((C4232uX) actionBarOverlayLayout.e).a.a;
            if (actionMenuView != null && (c3480l1 = actionMenuView.t) != null && c3480l1.k()) {
                r(c3170h5.h);
                return;
            }
        }
        WindowManager windowManager = (WindowManager) this.k.getSystemService("window");
        if (windowManager != null && c3170h5.m && (c3090g5 = c3170h5.e) != null) {
            windowManager.removeView(c3090g5);
            if (z) {
                p(c3170h5.a, c3170h5, null);
            }
        }
        c3170h5.k = false;
        c3170h5.l = false;
        c3170h5.m = false;
        c3170h5.f = null;
        c3170h5.n = true;
        if (this.M == c3170h5) {
            this.M = null;
        }
        if (c3170h5.a == 0) {
            I();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0037, code lost:
    
        if (r4.dispatchKeyEvent(r7) != false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00dc, code lost:
    
        if (r7.g() != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0102, code lost:
    
        if (r7.l() != false) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean u(KeyEvent keyEvent) {
        View decorView;
        boolean z;
        boolean z2;
        ActionMenuView actionMenuView;
        C3480l1 c3480l1;
        Object obj = this.j;
        if ((!(obj instanceof InterfaceC3180hA) && !(obj instanceof V3)) || (decorView = this.l.getDecorView()) == null || !S50.p(decorView, keyEvent)) {
            if (keyEvent.getKeyCode() == 82) {
                WindowCallbackC0855c5 windowCallbackC0855c5 = this.m;
                Window.Callback callback = this.l.getCallback();
                windowCallbackC0855c5.getClass();
                try {
                    windowCallbackC0855c5.c = true;
                } finally {
                    windowCallbackC0855c5.c = false;
                }
            }
            int keyCode = keyEvent.getKeyCode();
            if (keyEvent.getAction() == 0) {
                if (keyCode == 4) {
                    this.N = (keyEvent.getFlags() & UserVerificationMethods.USER_VERIFY_PATTERN) != 0;
                    return false;
                }
                if (keyCode == 82) {
                    if (keyEvent.getRepeatCount() == 0) {
                        C3170h5 z3 = z(0);
                        if (!z3.m) {
                            G(z3, keyEvent);
                            return true;
                        }
                    }
                }
                return false;
            }
            if (keyCode != 4) {
                if (keyCode == 82) {
                    if (this.u == null) {
                        C3170h5 z4 = z(0);
                        InterfaceC0564Vj interfaceC0564Vj = this.r;
                        Context context = this.k;
                        if (interfaceC0564Vj != null) {
                            ActionBarOverlayLayout actionBarOverlayLayout = (ActionBarOverlayLayout) interfaceC0564Vj;
                            actionBarOverlayLayout.k();
                            Toolbar toolbar = ((C4232uX) actionBarOverlayLayout.e).a;
                            if (toolbar.getVisibility() == 0 && (actionMenuView = toolbar.a) != null && actionMenuView.s && !ViewConfiguration.get(context).hasPermanentMenuKey()) {
                                ActionBarOverlayLayout actionBarOverlayLayout2 = (ActionBarOverlayLayout) this.r;
                                actionBarOverlayLayout2.k();
                                ActionMenuView actionMenuView2 = ((C4232uX) actionBarOverlayLayout2.e).a.a;
                                if (actionMenuView2 == null || (c3480l1 = actionMenuView2.t) == null || !c3480l1.k()) {
                                    if (!this.Q && G(z4, keyEvent)) {
                                        ActionBarOverlayLayout actionBarOverlayLayout3 = (ActionBarOverlayLayout) this.r;
                                        actionBarOverlayLayout3.k();
                                        ActionMenuView actionMenuView3 = ((C4232uX) actionBarOverlayLayout3.e).a.a;
                                        if (actionMenuView3 != null) {
                                            C3480l1 c3480l12 = actionMenuView3.t;
                                            if (c3480l12 != null) {
                                            }
                                        }
                                    }
                                    z = false;
                                } else {
                                    ActionBarOverlayLayout actionBarOverlayLayout4 = (ActionBarOverlayLayout) this.r;
                                    actionBarOverlayLayout4.k();
                                    ActionMenuView actionMenuView4 = ((C4232uX) actionBarOverlayLayout4.e).a.a;
                                    if (actionMenuView4 != null) {
                                        C3480l1 c3480l13 = actionMenuView4.t;
                                        if (c3480l13 != null) {
                                        }
                                    }
                                    z = false;
                                }
                                if (z) {
                                    AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
                                    if (audioManager != null) {
                                        audioManager.playSoundEffect(0);
                                        return true;
                                    }
                                    Log.w("AppCompatDelegate", "Couldn't get audio manager");
                                    return true;
                                }
                            }
                        }
                        boolean z5 = z4.m;
                        if (z5 || z4.l) {
                            s(z4, true);
                            z = z5;
                            if (z) {
                            }
                        } else {
                            if (z4.k) {
                                if (z4.o) {
                                    z4.k = false;
                                    z2 = G(z4, keyEvent);
                                } else {
                                    z2 = true;
                                }
                                if (z2) {
                                    E(z4, keyEvent);
                                    z = true;
                                    if (z) {
                                    }
                                }
                            }
                            z = false;
                            if (z) {
                            }
                        }
                    }
                }
                return false;
            }
            if (!D()) {
                return false;
            }
        }
        return true;
    }

    public final void v(int i) {
        C3170h5 z = z(i);
        if (z.h != null) {
            Bundle bundle = new Bundle();
            z.h.t(bundle);
            if (bundle.size() > 0) {
                z.p = bundle;
            }
            z.h.w();
            z.h.clear();
        }
        z.o = true;
        z.n = true;
        if ((i == 108 || i == 0) && this.r != null) {
            C3170h5 z2 = z(0);
            z2.k = false;
            G(z2, null);
        }
    }

    public final void w() {
        ViewGroup viewGroup;
        if (this.z) {
            return;
        }
        int[] iArr = GM.j;
        Context context = this.k;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        if (!obtainStyledAttributes.hasValue(117)) {
            obtainStyledAttributes.recycle();
            throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
        }
        if (obtainStyledAttributes.getBoolean(126, false)) {
            g(1);
        } else if (obtainStyledAttributes.getBoolean(117, false)) {
            g(108);
        }
        if (obtainStyledAttributes.getBoolean(118, false)) {
            g(FacebookMediationAdapter.ERROR_CREATE_NATIVE_AD_FROM_BID_PAYLOAD);
        }
        if (obtainStyledAttributes.getBoolean(119, false)) {
            g(10);
        }
        this.I = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        x();
        this.l.getDecorView();
        LayoutInflater from = LayoutInflater.from(context);
        if (this.J) {
            viewGroup = this.H ? (ViewGroup) from.inflate(dastan.prince.bdfreevpn.R.layout.abc_screen_simple_overlay_action_mode, (ViewGroup) null) : (ViewGroup) from.inflate(dastan.prince.bdfreevpn.R.layout.abc_screen_simple, (ViewGroup) null);
        } else if (this.I) {
            viewGroup = (ViewGroup) from.inflate(dastan.prince.bdfreevpn.R.layout.abc_dialog_title_material, (ViewGroup) null);
            this.G = false;
            this.F = false;
        } else if (this.F) {
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(dastan.prince.bdfreevpn.R.attr.actionBarTheme, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0172Gg(context, typedValue.resourceId) : context).inflate(dastan.prince.bdfreevpn.R.layout.abc_screen_toolbar, (ViewGroup) null);
            InterfaceC0564Vj interfaceC0564Vj = (InterfaceC0564Vj) viewGroup.findViewById(dastan.prince.bdfreevpn.R.id.decor_content_parent);
            this.r = interfaceC0564Vj;
            interfaceC0564Vj.setWindowCallback(this.l.getCallback());
            if (this.G) {
                ((ActionBarOverlayLayout) this.r).j(FacebookMediationAdapter.ERROR_CREATE_NATIVE_AD_FROM_BID_PAYLOAD);
            }
            if (this.D) {
                ((ActionBarOverlayLayout) this.r).j(2);
            }
            if (this.E) {
                ((ActionBarOverlayLayout) this.r).j(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.F + ", windowActionBarOverlay: " + this.G + ", android:windowIsFloating: " + this.I + ", windowActionModeOverlay: " + this.H + ", windowNoTitle: " + this.J + " }");
        }
        W4 w4 = new W4(this);
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        W10.c(viewGroup, w4);
        if (this.r == null) {
            this.B = (TextView) viewGroup.findViewById(dastan.prince.bdfreevpn.R.id.title);
        }
        boolean z = G20.a;
        try {
            Method method = viewGroup.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            method.invoke(viewGroup, new Object[0]);
        } catch (IllegalAccessException e) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e);
        } catch (NoSuchMethodException unused) {
            Log.d("ViewUtils", "Could not find method makeOptionalFitsSystemWindows. Oh well...");
        } catch (InvocationTargetException e2) {
            Log.d("ViewUtils", "Could not invoke makeOptionalFitsSystemWindows", e2);
        }
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(dastan.prince.bdfreevpn.R.id.action_bar_activity_content);
        ViewGroup viewGroup2 = (ViewGroup) this.l.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.l.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new C2882dV(this, 4));
        this.A = viewGroup;
        Object obj = this.j;
        CharSequence title = obj instanceof Activity ? ((Activity) obj).getTitle() : this.q;
        if (!TextUtils.isEmpty(title)) {
            InterfaceC0564Vj interfaceC0564Vj2 = this.r;
            if (interfaceC0564Vj2 != null) {
                interfaceC0564Vj2.setWindowTitle(title);
            } else {
                P30 p30 = this.o;
                if (p30 != null) {
                    C4232uX c4232uX = (C4232uX) p30.o;
                    if (!c4232uX.g) {
                        c4232uX.h = title;
                        if ((c4232uX.b & 8) != 0) {
                            Toolbar toolbar = c4232uX.a;
                            toolbar.setTitle(title);
                            if (c4232uX.g) {
                                AbstractC2925e20.n(toolbar.getRootView(), title);
                            }
                        }
                    }
                } else {
                    TextView textView = this.B;
                    if (textView != null) {
                        textView.setText(title);
                    }
                }
            }
        }
        ContentFrameLayout contentFrameLayout2 = (ContentFrameLayout) this.A.findViewById(R.id.content);
        View decorView = this.l.getDecorView();
        contentFrameLayout2.g.set(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        if (contentFrameLayout2.isLaidOut()) {
            contentFrameLayout2.requestLayout();
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(iArr);
        obtainStyledAttributes2.getValue(124, contentFrameLayout2.getMinWidthMajor());
        obtainStyledAttributes2.getValue(125, contentFrameLayout2.getMinWidthMinor());
        if (obtainStyledAttributes2.hasValue(122)) {
            obtainStyledAttributes2.getValue(122, contentFrameLayout2.getFixedWidthMajor());
        }
        if (obtainStyledAttributes2.hasValue(123)) {
            obtainStyledAttributes2.getValue(123, contentFrameLayout2.getFixedWidthMinor());
        }
        if (obtainStyledAttributes2.hasValue(120)) {
            obtainStyledAttributes2.getValue(120, contentFrameLayout2.getFixedHeightMajor());
        }
        if (obtainStyledAttributes2.hasValue(121)) {
            obtainStyledAttributes2.getValue(121, contentFrameLayout2.getFixedHeightMinor());
        }
        obtainStyledAttributes2.recycle();
        contentFrameLayout2.requestLayout();
        this.z = true;
        C3170h5 z2 = z(0);
        if (this.Q || z2.h != null) {
            return;
        }
        B(108);
    }

    public final void x() {
        if (this.l == null) {
            Object obj = this.j;
            if (obj instanceof Activity) {
                n(((Activity) obj).getWindow());
            }
        }
        if (this.l == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    public final AbstractC3010f5 y(Context context) {
        if (this.W == null) {
            if (C4452xG.e == null) {
                Context applicationContext = context.getApplicationContext();
                C4452xG.e = new C4452xG(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
            }
            this.W = new C2851d5(this, C4452xG.e);
        }
        return this.W;
    }

    public final C3170h5 z(int i) {
        C3170h5[] c3170h5Arr = this.L;
        if (c3170h5Arr == null || c3170h5Arr.length <= i) {
            C3170h5[] c3170h5Arr2 = new C3170h5[i + 1];
            if (c3170h5Arr != null) {
                System.arraycopy(c3170h5Arr, 0, c3170h5Arr2, 0, c3170h5Arr.length);
            }
            this.L = c3170h5Arr2;
            c3170h5Arr = c3170h5Arr2;
        }
        C3170h5 c3170h5 = c3170h5Arr[i];
        if (c3170h5 != null) {
            return c3170h5;
        }
        C3170h5 c3170h52 = new C3170h5();
        c3170h52.a = i;
        c3170h52.n = false;
        c3170h5Arr[i] = c3170h52;
        return c3170h52;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }
}
