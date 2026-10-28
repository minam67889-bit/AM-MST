package defpackage;

import android.R;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.q;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class I4 extends q implements M4 {
    public LayoutInflaterFactory2C3250i5 a;

    public I4() {
        getSavedStateRegistry().c("androidx:appcompat", new G4(this));
        addOnContextAvailableListener(new H4(this));
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        layoutInflaterFactory2C3250i5.w();
        ((ViewGroup) layoutInflaterFactory2C3250i5.A.findViewById(R.id.content)).addView(view, layoutParams);
        layoutInflaterFactory2C3250i5.m.a(layoutInflaterFactory2C3250i5.l.getCallback());
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        Configuration configuration;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = 0;
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        layoutInflaterFactory2C3250i5.O = true;
        int i10 = layoutInflaterFactory2C3250i5.S;
        if (i10 == -100) {
            i10 = U4.b;
        }
        int C = layoutInflaterFactory2C3250i5.C(context, i10);
        if (U4.c(context) && U4.c(context)) {
            if (Build.VERSION.SDK_INT < 33) {
                synchronized (U4.i) {
                    try {
                        C0868cD c0868cD = U4.c;
                        if (c0868cD == null) {
                            if (U4.d == null) {
                                U4.d = C0868cD.a(AbstractC3634my.C(context));
                            }
                            if (!U4.d.a.a.isEmpty()) {
                                U4.c = U4.d;
                            }
                        } else if (!c0868cD.equals(U4.d)) {
                            C0868cD c0868cD2 = U4.c;
                            U4.d = c0868cD2;
                            AbstractC3634my.z(context, c0868cD2.a.a.toLanguageTags());
                        }
                    } finally {
                    }
                }
            } else if (!U4.f) {
                U4.a.execute(new Q4(context, i9));
            }
        }
        C0868cD o = LayoutInflaterFactory2C3250i5.o(context);
        if (context instanceof ContextThemeWrapper) {
            try {
                ((ContextThemeWrapper) context).applyOverrideConfiguration(LayoutInflaterFactory2C3250i5.t(context, C, o, null, false));
            } catch (IllegalStateException unused) {
            }
            super.attachBaseContext(context);
        }
        if (context instanceof C0172Gg) {
            try {
                ((C0172Gg) context).a(LayoutInflaterFactory2C3250i5.t(context, C, o, null, false));
            } catch (IllegalStateException unused2) {
            }
            super.attachBaseContext(context);
        }
        if (LayoutInflaterFactory2C3250i5.j0) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = context.createConfigurationContext(configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (configuration3.equals(configuration4)) {
                configuration = null;
            } else {
                configuration = new Configuration();
                configuration.fontScale = 0.0f;
                if (configuration3.diff(configuration4) != 0) {
                    float f = configuration3.fontScale;
                    float f2 = configuration4.fontScale;
                    if (f != f2) {
                        configuration.fontScale = f2;
                    }
                    int i11 = configuration3.mcc;
                    int i12 = configuration4.mcc;
                    if (i11 != i12) {
                        configuration.mcc = i12;
                    }
                    int i13 = configuration3.mnc;
                    int i14 = configuration4.mnc;
                    if (i13 != i14) {
                        configuration.mnc = i14;
                    }
                    int i15 = Build.VERSION.SDK_INT;
                    Z4.a(configuration3, configuration4, configuration);
                    int i16 = configuration3.touchscreen;
                    int i17 = configuration4.touchscreen;
                    if (i16 != i17) {
                        configuration.touchscreen = i17;
                    }
                    int i18 = configuration3.keyboard;
                    int i19 = configuration4.keyboard;
                    if (i18 != i19) {
                        configuration.keyboard = i19;
                    }
                    int i20 = configuration3.keyboardHidden;
                    int i21 = configuration4.keyboardHidden;
                    if (i20 != i21) {
                        configuration.keyboardHidden = i21;
                    }
                    int i22 = configuration3.navigation;
                    int i23 = configuration4.navigation;
                    if (i22 != i23) {
                        configuration.navigation = i23;
                    }
                    int i24 = configuration3.navigationHidden;
                    int i25 = configuration4.navigationHidden;
                    if (i24 != i25) {
                        configuration.navigationHidden = i25;
                    }
                    int i26 = configuration3.orientation;
                    int i27 = configuration4.orientation;
                    if (i26 != i27) {
                        configuration.orientation = i27;
                    }
                    int i28 = configuration3.screenLayout & 15;
                    int i29 = configuration4.screenLayout & 15;
                    if (i28 != i29) {
                        configuration.screenLayout |= i29;
                    }
                    int i30 = configuration3.screenLayout & 192;
                    int i31 = configuration4.screenLayout & 192;
                    if (i30 != i31) {
                        configuration.screenLayout |= i31;
                    }
                    int i32 = configuration3.screenLayout & 48;
                    int i33 = configuration4.screenLayout & 48;
                    if (i32 != i33) {
                        configuration.screenLayout |= i33;
                    }
                    int i34 = configuration3.screenLayout & 768;
                    int i35 = configuration4.screenLayout & 768;
                    if (i34 != i35) {
                        configuration.screenLayout |= i35;
                    }
                    if (i15 >= 26) {
                        i = configuration3.colorMode;
                        int i36 = i & 3;
                        i2 = configuration4.colorMode;
                        if (i36 != (i2 & 3)) {
                            i7 = configuration.colorMode;
                            i8 = configuration4.colorMode;
                            configuration.colorMode = i7 | (i8 & 3);
                        }
                        i3 = configuration3.colorMode;
                        int i37 = i3 & 12;
                        i4 = configuration4.colorMode;
                        if (i37 != (i4 & 12)) {
                            i5 = configuration.colorMode;
                            i6 = configuration4.colorMode;
                            configuration.colorMode = i5 | (i6 & 12);
                        }
                    }
                    int i38 = configuration3.uiMode & 15;
                    int i39 = configuration4.uiMode & 15;
                    if (i38 != i39) {
                        configuration.uiMode |= i39;
                    }
                    int i40 = configuration3.uiMode & 48;
                    int i41 = configuration4.uiMode & 48;
                    if (i40 != i41) {
                        configuration.uiMode |= i41;
                    }
                    int i42 = configuration3.screenWidthDp;
                    int i43 = configuration4.screenWidthDp;
                    if (i42 != i43) {
                        configuration.screenWidthDp = i43;
                    }
                    int i44 = configuration3.screenHeightDp;
                    int i45 = configuration4.screenHeightDp;
                    if (i44 != i45) {
                        configuration.screenHeightDp = i45;
                    }
                    int i46 = configuration3.smallestScreenWidthDp;
                    int i47 = configuration4.smallestScreenWidthDp;
                    if (i46 != i47) {
                        configuration.smallestScreenWidthDp = i47;
                    }
                    int i48 = configuration3.densityDpi;
                    int i49 = configuration4.densityDpi;
                    if (i48 != i49) {
                        configuration.densityDpi = i49;
                    }
                }
            }
            Configuration t = LayoutInflaterFactory2C3250i5.t(context, C, o, configuration, true);
            C0172Gg c0172Gg = new C0172Gg(context, dastan.prince.bdfreevpn.R.style.Theme_AppCompat_Empty);
            c0172Gg.a(t);
            try {
                if (context.getTheme() != null) {
                    Resources.Theme theme = c0172Gg.getTheme();
                    if (Build.VERSION.SDK_INT >= 29) {
                        AbstractC3728o6.c(theme);
                    } else {
                        synchronized (XE.f) {
                            if (!XE.h) {
                                try {
                                    Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", new Class[0]);
                                    XE.g = declaredMethod;
                                    declaredMethod.setAccessible(true);
                                } catch (NoSuchMethodException e) {
                                    Log.i("ResourcesCompat", "Failed to retrieve rebase() method", e);
                                }
                                XE.h = true;
                            }
                            Method method = XE.g;
                            if (method != null) {
                                try {
                                    method.invoke(theme, new Object[0]);
                                } catch (IllegalAccessException | InvocationTargetException e2) {
                                    Log.i("ResourcesCompat", "Failed to invoke rebase() method via reflection", e2);
                                    XE.g = null;
                                }
                            }
                        }
                    }
                }
            } catch (NullPointerException unused3) {
            }
            context = c0172Gg;
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void closeOptionsMenu() {
        ((LayoutInflaterFactory2C3250i5) g()).A();
        if (getWindow().hasFeature(0)) {
            super.closeOptionsMenu();
        }
    }

    @Override // defpackage.AbstractActivityC4008rf, android.app.Activity, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        keyEvent.getKeyCode();
        ((LayoutInflaterFactory2C3250i5) g()).A();
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity
    public final View findViewById(int i) {
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        layoutInflaterFactory2C3250i5.w();
        return layoutInflaterFactory2C3250i5.l.findViewById(i);
    }

    public final U4 g() {
        if (this.a == null) {
            T4 t4 = U4.a;
            this.a = new LayoutInflaterFactory2C3250i5(this, null, this, this);
        }
        return this.a;
    }

    @Override // android.app.Activity
    public final MenuInflater getMenuInflater() {
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        if (layoutInflaterFactory2C3250i5.p == null) {
            layoutInflaterFactory2C3250i5.A();
            P30 p30 = layoutInflaterFactory2C3250i5.o;
            layoutInflaterFactory2C3250i5.p = new MV(p30 != null ? p30.a0() : layoutInflaterFactory2C3250i5.k);
        }
        return layoutInflaterFactory2C3250i5.p;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        int i = E10.a;
        return super.getResources();
    }

    @Override // android.app.Activity
    public final void invalidateOptionsMenu() {
        g().b();
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        if (layoutInflaterFactory2C3250i5.F && layoutInflaterFactory2C3250i5.z) {
            layoutInflaterFactory2C3250i5.A();
            P30 p30 = layoutInflaterFactory2C3250i5.o;
            if (p30 != null) {
                p30.d0(p30.k.getResources().getBoolean(dastan.prince.bdfreevpn.R.bool.abc_action_bar_embed_tabs));
            }
        }
        C3408k5 a = C3408k5.a();
        Context context = layoutInflaterFactory2C3250i5.k;
        synchronized (a) {
            C4302vO c4302vO = a.a;
            synchronized (c4302vO) {
                BD bd = (BD) c4302vO.b.get(context);
                if (bd != null) {
                    bd.a();
                }
            }
        }
        layoutInflaterFactory2C3250i5.R = new Configuration(layoutInflaterFactory2C3250i5.k.getResources().getConfiguration());
        layoutInflaterFactory2C3250i5.m(false, false);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final void onContentChanged() {
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        g().e();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        Window window;
        if (Build.VERSION.SDK_INT >= 26 || keyEvent.isCtrlPressed() || KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState()) || keyEvent.getRepeatCount() != 0 || KeyEvent.isModifierKey(keyEvent.getKeyCode()) || (window = getWindow()) == null || window.getDecorView() == null || !window.getDecorView().dispatchKeyShortcutEvent(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, android.app.Activity, android.view.Window.Callback
    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        Intent C;
        if (!super.onMenuItemSelected(i, menuItem)) {
            LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
            layoutInflaterFactory2C3250i5.A();
            P30 p30 = layoutInflaterFactory2C3250i5.o;
            if (menuItem.getItemId() != 16908332 || p30 == null || (((C4232uX) p30.o).b & 4) == 0 || (C = W80.C(this)) == null) {
                return false;
            }
            if (!shouldUpRecreateTask(C)) {
                navigateUpTo(C);
                return true;
            }
            ArrayList arrayList = new ArrayList();
            Intent C2 = W80.C(this);
            if (C2 == null) {
                C2 = W80.C(this);
            }
            if (C2 != null) {
                ComponentName component = C2.getComponent();
                if (component == null) {
                    component = C2.resolveActivity(getPackageManager());
                }
                int size = arrayList.size();
                try {
                    Intent D = W80.D(this, component);
                    while (D != null) {
                        arrayList.add(size, D);
                        D = W80.D(this, D.getComponent());
                    }
                    arrayList.add(C2);
                } catch (PackageManager.NameNotFoundException e) {
                    Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                    throw new IllegalArgumentException(e);
                }
            }
            if (arrayList.isEmpty()) {
                throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
            }
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[0]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            startActivities(intentArr, null);
            try {
                finishAffinity();
            } catch (IllegalStateException unused) {
                finish();
            }
        }
        return true;
    }

    @Override // android.app.Activity
    public final void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        ((LayoutInflaterFactory2C3250i5) g()).w();
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onPostResume() {
        super.onPostResume();
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        layoutInflaterFactory2C3250i5.A();
        P30 p30 = layoutInflaterFactory2C3250i5.o;
        if (p30 != null) {
            p30.D = true;
        }
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onStart() {
        super.onStart();
        ((LayoutInflaterFactory2C3250i5) g()).m(true, false);
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public void onStop() {
        super.onStop();
        LayoutInflaterFactory2C3250i5 layoutInflaterFactory2C3250i5 = (LayoutInflaterFactory2C3250i5) g();
        layoutInflaterFactory2C3250i5.A();
        P30 p30 = layoutInflaterFactory2C3250i5.o;
        if (p30 != null) {
            p30.D = false;
            C4431x20 c4431x20 = p30.C;
            if (c4431x20 != null) {
                c4431x20.a();
            }
        }
    }

    @Override // android.app.Activity
    public final void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        g().l(charSequence);
    }

    @Override // android.app.Activity
    public final void openOptionsMenu() {
        ((LayoutInflaterFactory2C3250i5) g()).A();
        if (getWindow().hasFeature(0)) {
            super.openOptionsMenu();
        }
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void setContentView(int i) {
        initializeViewTreeOwners();
        g().h(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        super.setTheme(i);
        ((LayoutInflaterFactory2C3250i5) g()).T = i;
    }

    @Override // androidx.fragment.app.q
    public final void supportInvalidateOptionsMenu() {
        g().b();
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        g().j(view);
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        g().k(view, layoutParams);
    }
}
