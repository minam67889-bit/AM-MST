package defpackage;

import android.app.Application;
import android.app.PictureInPictureUiState;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: sf, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractActivityC4087sf extends AbstractActivityC4008rf implements InterfaceC4115t20, InterfaceC0031Av, InterfaceC3910qQ, YI, H1, InterfaceC0874cJ, InterfaceC3587mJ, InterfaceC3189hJ, InterfaceC3269iJ, InterfaceC3105gF {
    private static final String ACTIVITY_RESULT_TAG = "android:support:activity-result";
    private static final C3534lf Companion = new C3534lf();
    private C4036s20 _viewModelStore;
    private final G1 activityResultRegistry;
    private int contentLayoutId;
    private final UA defaultViewModelProviderFactory$delegate;
    private boolean dispatchingOnMultiWindowModeChanged;
    private boolean dispatchingOnPictureInPictureModeChanged;
    private final UA fullyDrawnReporter$delegate;
    private boolean hasPictureInPictureSystemFeature;
    private final AtomicInteger nextLocalRequestCode;
    private final UA onBackPressedDispatcher$delegate;
    private final UA onBackPressedInput$delegate;
    private final CopyOnWriteArrayList<InterfaceC4405wg> onConfigurationChangedListeners;
    private final CopyOnWriteArrayList<InterfaceC4405wg> onMultiWindowModeChangedListeners;
    private final CopyOnWriteArrayList<InterfaceC4405wg> onNewIntentListeners;
    private final CopyOnWriteArrayList<InterfaceC4405wg> onPictureInPictureModeChangedListeners;
    private final CopyOnWriteArrayList<InterfaceC4405wg> onPictureInPictureUiStateChangedListeners;
    private final CopyOnWriteArrayList<InterfaceC4405wg> onTrimMemoryListeners;
    private final CopyOnWriteArrayList<Runnable> onUserLeaveHintListeners;
    private final InterfaceExecutorC3772of reportFullyDrawnExecutor;
    private final C3752oQ savedStateRegistryController;
    private final C0120Eg contextAwareHelper = new C0120Eg();
    private final C3343jF menuHostHelper = new C3343jF(new RunnableC3056ff(this, 1));

    public AbstractActivityC4087sf() {
        C3831pQ c3831pQ = new C3831pQ(this, new C4416wr(this, 4));
        this.savedStateRegistryController = new C3752oQ(c3831pQ);
        this.reportFullyDrawnExecutor = new ViewTreeObserverOnDrawListenerC3851pf(this);
        this.fullyDrawnReporter$delegate = W80.N(new C3136gf(this, 1));
        this.nextLocalRequestCode = new AtomicInteger();
        this.activityResultRegistry = new C3930qf(this);
        this.onConfigurationChangedListeners = new CopyOnWriteArrayList<>();
        this.onTrimMemoryListeners = new CopyOnWriteArrayList<>();
        this.onNewIntentListeners = new CopyOnWriteArrayList<>();
        this.onMultiWindowModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureModeChangedListeners = new CopyOnWriteArrayList<>();
        this.onPictureInPictureUiStateChangedListeners = new CopyOnWriteArrayList<>();
        this.onUserLeaveHintListeners = new CopyOnWriteArrayList<>();
        this.onBackPressedInput$delegate = W80.N(new C3136gf(this, 2));
        if (getLifecycle() == null) {
            throw new IllegalStateException("getLifecycle() returned null in ComponentActivity's constructor. Please make sure you are lazily constructing your Lifecycle in the first call to getLifecycle() rather than relying on field initialization.");
        }
        getLifecycle().a(new Cif(this, 0));
        getLifecycle().a(new Cif(this, 1));
        getLifecycle().a(new UM(this, 1));
        c3831pQ.a();
        AbstractC0731aZ.A(this);
        getSavedStateRegistry().c(ACTIVITY_RESULT_TAG, new C3374jf(this, 0));
        addOnContextAvailableListener(new InterfaceC2870dJ() { // from class: kf
            @Override // defpackage.InterfaceC2870dJ
            public final void a(AbstractActivityC4087sf abstractActivityC4087sf) {
                AbstractActivityC4087sf.e(AbstractActivityC4087sf.this, abstractActivityC4087sf);
            }
        });
        this.defaultViewModelProviderFactory$delegate = W80.N(new C3136gf(this, 3));
        this.onBackPressedDispatcher$delegate = W80.N(new C3136gf(this, 4));
    }

    public static Bundle a(AbstractActivityC4087sf abstractActivityC4087sf) {
        Bundle bundle = new Bundle();
        G1 g1 = abstractActivityC4087sf.activityResultRegistry;
        g1.getClass();
        LinkedHashMap linkedHashMap = g1.b;
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(linkedHashMap.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(linkedHashMap.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(g1.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", new Bundle(g1.g));
        return bundle;
    }

    public static final void access$ensureViewModelStore(AbstractActivityC4087sf abstractActivityC4087sf) {
        if (abstractActivityC4087sf._viewModelStore == null) {
            C3693nf c3693nf = (C3693nf) abstractActivityC4087sf.getLastNonConfigurationInstance();
            if (c3693nf != null) {
                abstractActivityC4087sf._viewModelStore = c3693nf.b;
            }
            if (abstractActivityC4087sf._viewModelStore == null) {
                abstractActivityC4087sf._viewModelStore = new C4036s20();
            }
        }
    }

    public static C0444Qt b(AbstractActivityC4087sf abstractActivityC4087sf) {
        return new C0444Qt(abstractActivityC4087sf.reportFullyDrawnExecutor, new C3136gf(abstractActivityC4087sf, 0));
    }

    public static void c(AbstractActivityC4087sf abstractActivityC4087sf, EB eb, EnumC4447xB enumC4447xB) {
        if (enumC4447xB == EnumC4447xB.ON_DESTROY) {
            abstractActivityC4087sf.contextAwareHelper.b = null;
            if (!abstractActivityC4087sf.isChangingConfigurations()) {
                abstractActivityC4087sf.getViewModelStore().a();
            }
            ViewTreeObserverOnDrawListenerC3851pf viewTreeObserverOnDrawListenerC3851pf = (ViewTreeObserverOnDrawListenerC3851pf) abstractActivityC4087sf.reportFullyDrawnExecutor;
            AbstractActivityC4087sf abstractActivityC4087sf2 = viewTreeObserverOnDrawListenerC3851pf.d;
            abstractActivityC4087sf2.getWindow().getDecorView().removeCallbacks(viewTreeObserverOnDrawListenerC3851pf);
            abstractActivityC4087sf2.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(viewTreeObserverOnDrawListenerC3851pf);
        }
    }

    public static void d(AbstractActivityC4087sf abstractActivityC4087sf) {
        try {
            super.onBackPressed();
        } catch (IllegalStateException e) {
            if (!AbstractC3634my.a(e.getMessage(), "Can not perform this action after onSaveInstanceState")) {
                throw e;
            }
        } catch (NullPointerException e2) {
            if (!AbstractC3634my.a(e2.getMessage(), "Attempt to invoke virtual method 'android.os.Handler android.app.FragmentHostCallback.getHandler()' on a null object reference")) {
                throw e2;
            }
        }
    }

    public static void e(AbstractActivityC4087sf abstractActivityC4087sf, AbstractActivityC4087sf abstractActivityC4087sf2) {
        AbstractC3634my.g(abstractActivityC4087sf2, "it");
        Bundle a = abstractActivityC4087sf.getSavedStateRegistry().a(ACTIVITY_RESULT_TAG);
        if (a != null) {
            G1 g1 = abstractActivityC4087sf.activityResultRegistry;
            g1.getClass();
            ArrayList<Integer> integerArrayList = a.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
            ArrayList<String> stringArrayList = a.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
            if (stringArrayList == null || integerArrayList == null) {
                return;
            }
            ArrayList<String> stringArrayList2 = a.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
            if (stringArrayList2 != null) {
                g1.d.addAll(stringArrayList2);
            }
            Bundle bundle = a.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT");
            Bundle bundle2 = g1.g;
            if (bundle != null) {
                bundle2.putAll(bundle);
            }
            int size = stringArrayList.size();
            for (int i = 0; i < size; i++) {
                String str = stringArrayList.get(i);
                LinkedHashMap linkedHashMap = g1.b;
                boolean containsKey = linkedHashMap.containsKey(str);
                LinkedHashMap linkedHashMap2 = g1.a;
                if (containsKey) {
                    Integer num = (Integer) linkedHashMap.remove(str);
                    if (bundle2.containsKey(str)) {
                        continue;
                    } else {
                        if ((linkedHashMap2 instanceof InterfaceC0580Vz) && !(linkedHashMap2 instanceof InterfaceC0632Xz)) {
                            AbstractC0731aZ.h0(linkedHashMap2, "kotlin.collections.MutableMap");
                            throw null;
                        }
                        linkedHashMap2.remove(num);
                    }
                }
                Integer num2 = integerArrayList.get(i);
                AbstractC3634my.f(num2, "get(...)");
                int intValue = num2.intValue();
                String str2 = stringArrayList.get(i);
                AbstractC3634my.f(str2, "get(...)");
                String str3 = str2;
                linkedHashMap2.put(Integer.valueOf(intValue), str3);
                linkedHashMap.put(str3, Integer.valueOf(intValue));
            }
        }
    }

    @Override // android.app.Activity
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        InterfaceExecutorC3772of interfaceExecutorC3772of = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC3634my.f(decorView, "getDecorView(...)");
        ((ViewTreeObserverOnDrawListenerC3851pf) interfaceExecutorC3772of).a(decorView);
        super.addContentView(view, layoutParams);
    }

    @Override // defpackage.InterfaceC3105gF
    public void addMenuProvider(InterfaceC4609zF interfaceC4609zF) {
        AbstractC3634my.g(interfaceC4609zF, "provider");
        C3343jF c3343jF = this.menuHostHelper;
        c3343jF.b.add(interfaceC4609zF);
        c3343jF.a.run();
    }

    @Override // defpackage.InterfaceC0874cJ
    public final void addOnConfigurationChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onConfigurationChangedListeners.add(interfaceC4405wg);
    }

    public final void addOnContextAvailableListener(InterfaceC2870dJ interfaceC2870dJ) {
        AbstractC3634my.g(interfaceC2870dJ, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        C0120Eg c0120Eg = this.contextAwareHelper;
        c0120Eg.getClass();
        AbstractActivityC4087sf abstractActivityC4087sf = c0120Eg.b;
        if (abstractActivityC4087sf != null) {
            interfaceC2870dJ.a(abstractActivityC4087sf);
        }
        c0120Eg.a.add(interfaceC2870dJ);
    }

    @Override // defpackage.InterfaceC3189hJ
    public final void addOnMultiWindowModeChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onMultiWindowModeChangedListeners.add(interfaceC4405wg);
    }

    public final void addOnNewIntentListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onNewIntentListeners.add(interfaceC4405wg);
    }

    @Override // defpackage.InterfaceC3269iJ
    public final void addOnPictureInPictureModeChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPictureInPictureModeChangedListeners.add(interfaceC4405wg);
    }

    public final void addOnPictureInPictureUiStateChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPictureInPictureUiStateChangedListeners.add(interfaceC4405wg);
    }

    @Override // defpackage.InterfaceC3587mJ
    public final void addOnTrimMemoryListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onTrimMemoryListeners.add(interfaceC4405wg);
    }

    public final void addOnUserLeaveHintListener(Runnable runnable) {
        AbstractC3634my.g(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onUserLeaveHintListeners.add(runnable);
    }

    public final void enterPictureInPictureMode(AbstractC0875cK abstractC0875cK) {
        AbstractC3634my.g(abstractC0875cK, "params");
        throw null;
    }

    @Override // defpackage.H1
    public final G1 getActivityResultRegistry() {
        return this.activityResultRegistry;
    }

    @Override // defpackage.InterfaceC0031Av
    public AbstractC3776oi getDefaultViewModelCreationExtras() {
        TG tg = new TG(0);
        Application application = getApplication();
        LinkedHashMap linkedHashMap = tg.a;
        if (application != null) {
            linkedHashMap.put(C3800p20.d, getApplication());
        }
        linkedHashMap.put(AbstractC0731aZ.g, this);
        linkedHashMap.put(AbstractC0731aZ.h, this);
        Intent intent = getIntent();
        Bundle extras = intent != null ? intent.getExtras() : null;
        if (extras != null) {
            linkedHashMap.put(AbstractC0731aZ.i, extras);
        }
        return tg;
    }

    public InterfaceC3879q20 getDefaultViewModelProviderFactory() {
        return (InterfaceC3879q20) this.defaultViewModelProviderFactory$delegate.getValue();
    }

    public C0444Qt getFullyDrawnReporter() {
        return (C0444Qt) this.fullyDrawnReporter$delegate.getValue();
    }

    public Object getLastCustomNonConfigurationInstance() {
        C3693nf c3693nf = (C3693nf) getLastNonConfigurationInstance();
        if (c3693nf != null) {
            return c3693nf.a;
        }
        return null;
    }

    @Override // defpackage.AbstractActivityC4008rf, defpackage.EB
    public AbstractC4605zB getLifecycle() {
        return super.getLifecycle();
    }

    public C4374wH getNavigationEventDispatcher() {
        return getOnBackPressedDispatcher().b().c;
    }

    @Override // defpackage.YI
    public final XI getOnBackPressedDispatcher() {
        return (XI) this.onBackPressedDispatcher$delegate.getValue();
    }

    @Override // defpackage.InterfaceC3910qQ
    public final C3673nQ getSavedStateRegistry() {
        return this.savedStateRegistryController.b;
    }

    @Override // defpackage.InterfaceC4115t20
    public C4036s20 getViewModelStore() {
        if (getApplication() == null) {
            throw new IllegalStateException("Your activity is not yet attached to the Application instance. You can't request ViewModel before onCreate call.");
        }
        if (this._viewModelStore == null) {
            C3693nf c3693nf = (C3693nf) getLastNonConfigurationInstance();
            if (c3693nf != null) {
                this._viewModelStore = c3693nf.b;
            }
            if (this._viewModelStore == null) {
                this._viewModelStore = new C4036s20();
            }
        }
        C4036s20 c4036s20 = this._viewModelStore;
        AbstractC3634my.d(c4036s20);
        return c4036s20;
    }

    public void initializeViewTreeOwners() {
        View decorView = getWindow().getDecorView();
        AbstractC3634my.f(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        View decorView2 = getWindow().getDecorView();
        AbstractC3634my.f(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_view_model_store_owner, this);
        View decorView3 = getWindow().getDecorView();
        AbstractC3634my.f(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        View decorView4 = getWindow().getDecorView();
        AbstractC3634my.f(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        View decorView5 = getWindow().getDecorView();
        AbstractC3634my.f(decorView5, "getDecorView(...)");
        decorView5.setTag(R.id.report_drawn, this);
        View decorView6 = getWindow().getDecorView();
        AbstractC3634my.f(decorView6, "getDecorView(...)");
        decorView6.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    public void invalidateMenu() {
        invalidateOptionsMenu();
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.activityResultRegistry.a(i, i2, intent)) {
            return;
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        ((C4252ul) this.onBackPressedInput$delegate.getValue()).a();
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        AbstractC3634my.g(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Iterator<InterfaceC4405wg> it = this.onConfigurationChangedListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(configuration);
        }
    }

    @Override // defpackage.AbstractActivityC4008rf, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.savedStateRegistryController.a(bundle);
        C0120Eg c0120Eg = this.contextAwareHelper;
        c0120Eg.getClass();
        c0120Eg.b = this;
        Iterator it = c0120Eg.a.iterator();
        while (it.hasNext()) {
            ((InterfaceC2870dJ) it.next()).a(this);
        }
        super.onCreate(bundle);
        int i = FragmentC3034fO.b;
        AbstractC2875dO.b(this);
        int i2 = this.contentLayoutId;
        if (i2 != 0) {
            setContentView(i2);
        }
        this.hasPictureInPictureSystemFeature = getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onCreatePanelMenu(int i, Menu menu) {
        AbstractC3634my.g(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onCreatePanelMenu(i, menu);
        C3343jF c3343jF = this.menuHostHelper;
        MenuInflater menuInflater = getMenuInflater();
        Iterator it = c3343jF.b.iterator();
        while (it.hasNext()) {
            ((C2912dt) ((InterfaceC4609zF) it.next())).a.j(menu, menuInflater);
        }
        return true;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        AbstractC3634my.g(menuItem, "item");
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        if (i == 0) {
            return this.menuHostHelper.a(menuItem);
        }
        return false;
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z) {
        if (this.dispatchingOnMultiWindowModeChanged) {
            return;
        }
        Iterator<InterfaceC4405wg> it = this.onMultiWindowModeChangedListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new NG(z));
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        AbstractC3634my.g(intent, "intent");
        super.onNewIntent(intent);
        Iterator<InterfaceC4405wg> it = this.onNewIntentListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onPanelClosed(int i, Menu menu) {
        AbstractC3634my.g(menu, "menu");
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            ((C2912dt) ((InterfaceC4609zF) it.next())).a.p(menu);
        }
        super.onPanelClosed(i, menu);
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z) {
        if (this.dispatchingOnPictureInPictureModeChanged) {
            return;
        }
        Iterator<InterfaceC4405wg> it = this.onPictureInPictureModeChangedListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(new C0796bK(z));
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureUiStateChanged(PictureInPictureUiState pictureInPictureUiState) {
        C4254un c4254un;
        AbstractC3634my.g(pictureInPictureUiState, "pipState");
        super.onPictureInPictureUiStateChanged(pictureInPictureUiState);
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            pictureInPictureUiState.isStashed();
            pictureInPictureUiState.isTransitioningToPip();
            c4254un = new C4254un(25);
        } else if (i >= 31) {
            pictureInPictureUiState.isStashed();
            c4254un = new C4254un(25);
        } else {
            c4254un = new C4254un(25);
        }
        Iterator<InterfaceC4405wg> it = this.onPictureInPictureUiStateChangedListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(c4254un);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onPreparePanel(int i, View view, Menu menu) {
        AbstractC3634my.g(menu, "menu");
        if (i != 0) {
            return true;
        }
        super.onPreparePanel(i, view, menu);
        Iterator it = this.menuHostHelper.b.iterator();
        while (it.hasNext()) {
            ((C2912dt) ((InterfaceC4609zF) it.next())).a.s(menu);
        }
        return true;
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        AbstractC3634my.g(strArr, "permissions");
        AbstractC3634my.g(iArr, "grantResults");
        if (this.activityResultRegistry.a(i, -1, new Intent().putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr).putExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS", iArr))) {
            return;
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    @Override // android.app.Activity
    public final Object onRetainNonConfigurationInstance() {
        C3693nf c3693nf;
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C4036s20 c4036s20 = this._viewModelStore;
        if (c4036s20 == null && (c3693nf = (C3693nf) getLastNonConfigurationInstance()) != null) {
            c4036s20 = c3693nf.b;
        }
        if (c4036s20 == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C3693nf c3693nf2 = new C3693nf();
        c3693nf2.a = onRetainCustomNonConfigurationInstance;
        c3693nf2.b = c4036s20;
        return c3693nf2;
    }

    @Override // defpackage.AbstractActivityC4008rf, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        AbstractC3634my.g(bundle, "outState");
        if (getLifecycle() instanceof HB) {
            AbstractC4605zB lifecycle = getLifecycle();
            AbstractC3634my.e(lifecycle, "null cannot be cast to non-null type androidx.lifecycle.LifecycleRegistry");
            EnumC4526yB enumC4526yB = EnumC4526yB.a;
            ((HB) lifecycle).g();
        }
        super.onSaveInstanceState(bundle);
        this.savedStateRegistryController.b(bundle);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        Iterator<InterfaceC4405wg> it = this.onTrimMemoryListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().accept(Integer.valueOf(i));
        }
    }

    @Override // android.app.Activity
    public void onUserLeaveHint() {
        super.onUserLeaveHint();
        Iterator<Runnable> it = this.onUserLeaveHintListeners.iterator();
        AbstractC3634my.f(it, "iterator(...)");
        while (it.hasNext()) {
            it.next().run();
        }
    }

    public Context peekAvailableContext() {
        return this.contextAwareHelper.b;
    }

    public final <I, O> A1 registerForActivityResult(AbstractC4507y1 abstractC4507y1, G1 g1, InterfaceC4428x1 interfaceC4428x1) {
        AbstractC3634my.g(abstractC4507y1, "contract");
        AbstractC3634my.g(g1, "registry");
        AbstractC3634my.g(interfaceC4428x1, "callback");
        return g1.d("activity_rq#" + this.nextLocalRequestCode.getAndIncrement(), this, abstractC4507y1, interfaceC4428x1);
    }

    @Override // defpackage.InterfaceC3105gF
    public void removeMenuProvider(InterfaceC4609zF interfaceC4609zF) {
        AbstractC3634my.g(interfaceC4609zF, "provider");
        this.menuHostHelper.b(interfaceC4609zF);
    }

    @Override // defpackage.InterfaceC0874cJ
    public final void removeOnConfigurationChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onConfigurationChangedListeners.remove(interfaceC4405wg);
    }

    public final void removeOnContextAvailableListener(InterfaceC2870dJ interfaceC2870dJ) {
        AbstractC3634my.g(interfaceC2870dJ, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        C0120Eg c0120Eg = this.contextAwareHelper;
        c0120Eg.getClass();
        c0120Eg.a.remove(interfaceC2870dJ);
    }

    @Override // defpackage.InterfaceC3189hJ
    public final void removeOnMultiWindowModeChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onMultiWindowModeChangedListeners.remove(interfaceC4405wg);
    }

    public final void removeOnNewIntentListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onNewIntentListeners.remove(interfaceC4405wg);
    }

    @Override // defpackage.InterfaceC3269iJ
    public final void removeOnPictureInPictureModeChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPictureInPictureModeChangedListeners.remove(interfaceC4405wg);
    }

    public final void removeOnPictureInPictureUiStateChangedListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onPictureInPictureUiStateChangedListeners.remove(interfaceC4405wg);
    }

    @Override // defpackage.InterfaceC3587mJ
    public final void removeOnTrimMemoryListener(InterfaceC4405wg interfaceC4405wg) {
        AbstractC3634my.g(interfaceC4405wg, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onTrimMemoryListeners.remove(interfaceC4405wg);
    }

    public final void removeOnUserLeaveHintListener(Runnable runnable) {
        AbstractC3634my.g(runnable, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onUserLeaveHintListeners.remove(runnable);
    }

    @Override // android.app.Activity
    public void reportFullyDrawn() {
        try {
            if (AbstractC3131gc0.y()) {
                AbstractC3131gc0.f("reportFullyDrawn() for ComponentActivity");
            }
            super.reportFullyDrawn();
            C0444Qt fullyDrawnReporter = getFullyDrawnReporter();
            synchronized (fullyDrawnReporter.a) {
                try {
                    fullyDrawnReporter.b = true;
                    Iterator it = fullyDrawnReporter.c.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC0470Rt) it.next()).invoke();
                    }
                    fullyDrawnReporter.c.clear();
                } finally {
                }
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        initializeViewTreeOwners();
        InterfaceExecutorC3772of interfaceExecutorC3772of = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC3634my.f(decorView, "getDecorView(...)");
        ((ViewTreeObserverOnDrawListenerC3851pf) interfaceExecutorC3772of).a(decorView);
        super.setContentView(i);
    }

    public final void setPictureInPictureParams(AbstractC0875cK abstractC0875cK) {
        AbstractC3634my.g(abstractC0875cK, "params");
        throw null;
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        AbstractC3634my.g(intent, "intent");
        super.startActivityForResult(intent, i);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        AbstractC3634my.g(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        AbstractC3634my.g(intent, "intent");
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        AbstractC3634my.g(intentSender, "intent");
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public final <I, O> A1 registerForActivityResult(AbstractC4507y1 abstractC4507y1, InterfaceC4428x1 interfaceC4428x1) {
        AbstractC3634my.g(abstractC4507y1, "contract");
        AbstractC3634my.g(interfaceC4428x1, "callback");
        return registerForActivityResult(abstractC4507y1, this.activityResultRegistry, interfaceC4428x1);
    }

    @Override // android.app.Activity
    public void onMultiWindowModeChanged(boolean z, Configuration configuration) {
        AbstractC3634my.g(configuration, "newConfig");
        this.dispatchingOnMultiWindowModeChanged = true;
        try {
            super.onMultiWindowModeChanged(z, configuration);
            this.dispatchingOnMultiWindowModeChanged = false;
            Iterator<InterfaceC4405wg> it = this.onMultiWindowModeChangedListeners.iterator();
            AbstractC3634my.f(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new NG(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnMultiWindowModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void onPictureInPictureModeChanged(boolean z, Configuration configuration) {
        AbstractC3634my.g(configuration, "newConfig");
        this.dispatchingOnPictureInPictureModeChanged = true;
        try {
            super.onPictureInPictureModeChanged(z, configuration);
            this.dispatchingOnPictureInPictureModeChanged = false;
            Iterator<InterfaceC4405wg> it = this.onPictureInPictureModeChangedListeners.iterator();
            AbstractC3634my.f(it, "iterator(...)");
            while (it.hasNext()) {
                it.next().accept(new C0796bK(z));
            }
        } catch (Throwable th) {
            this.dispatchingOnPictureInPictureModeChanged = false;
            throw th;
        }
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        initializeViewTreeOwners();
        InterfaceExecutorC3772of interfaceExecutorC3772of = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC3634my.f(decorView, "getDecorView(...)");
        ((ViewTreeObserverOnDrawListenerC3851pf) interfaceExecutorC3772of).a(decorView);
        super.setContentView(view);
    }

    public void addMenuProvider(InterfaceC4609zF interfaceC4609zF, EB eb) {
        AbstractC3634my.g(interfaceC4609zF, "provider");
        AbstractC3634my.g(eb, "owner");
        C3343jF c3343jF = this.menuHostHelper;
        c3343jF.b.add(interfaceC4609zF);
        c3343jF.a.run();
        AbstractC4605zB lifecycle = eb.getLifecycle();
        HashMap hashMap = c3343jF.c;
        C3265iF c3265iF = (C3265iF) hashMap.remove(interfaceC4609zF);
        if (c3265iF != null) {
            c3265iF.a.b(c3265iF.b);
            c3265iF.b = null;
        }
        hashMap.put(interfaceC4609zF, new C3265iF(lifecycle, new C3216hf(1, c3343jF, interfaceC4609zF)));
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        initializeViewTreeOwners();
        InterfaceExecutorC3772of interfaceExecutorC3772of = this.reportFullyDrawnExecutor;
        View decorView = getWindow().getDecorView();
        AbstractC3634my.f(decorView, "getDecorView(...)");
        ((ViewTreeObserverOnDrawListenerC3851pf) interfaceExecutorC3772of).a(decorView);
        super.setContentView(view, layoutParams);
    }

    public void addMenuProvider(final InterfaceC4609zF interfaceC4609zF, EB eb, final EnumC4526yB enumC4526yB) {
        AbstractC3634my.g(interfaceC4609zF, "provider");
        AbstractC3634my.g(eb, "owner");
        AbstractC3634my.g(enumC4526yB, "state");
        final C3343jF c3343jF = this.menuHostHelper;
        c3343jF.getClass();
        AbstractC4605zB lifecycle = eb.getLifecycle();
        HashMap hashMap = c3343jF.c;
        C3265iF c3265iF = (C3265iF) hashMap.remove(interfaceC4609zF);
        if (c3265iF != null) {
            c3265iF.a.b(c3265iF.b);
            c3265iF.b = null;
        }
        hashMap.put(interfaceC4609zF, new C3265iF(lifecycle, new CB() { // from class: hF
            @Override // defpackage.CB
            public final void f(EB eb2, EnumC4447xB enumC4447xB) {
                C3343jF c3343jF2 = C3343jF.this;
                c3343jF2.getClass();
                EnumC4447xB.Companion.getClass();
                EnumC4526yB enumC4526yB2 = enumC4526yB;
                int ordinal = enumC4526yB2.ordinal();
                EnumC4447xB enumC4447xB2 = null;
                EnumC4447xB enumC4447xB3 = ordinal != 2 ? ordinal != 3 ? ordinal != 4 ? null : EnumC4447xB.ON_RESUME : EnumC4447xB.ON_START : EnumC4447xB.ON_CREATE;
                InterfaceC4609zF interfaceC4609zF2 = interfaceC4609zF;
                Runnable runnable = c3343jF2.a;
                CopyOnWriteArrayList copyOnWriteArrayList = c3343jF2.b;
                if (enumC4447xB == enumC4447xB3) {
                    copyOnWriteArrayList.add(interfaceC4609zF2);
                    runnable.run();
                    return;
                }
                EnumC4447xB enumC4447xB4 = EnumC4447xB.ON_DESTROY;
                if (enumC4447xB == enumC4447xB4) {
                    c3343jF2.b(interfaceC4609zF2);
                    return;
                }
                int ordinal2 = enumC4526yB2.ordinal();
                if (ordinal2 == 2) {
                    enumC4447xB2 = enumC4447xB4;
                } else if (ordinal2 == 3) {
                    enumC4447xB2 = EnumC4447xB.ON_STOP;
                } else if (ordinal2 == 4) {
                    enumC4447xB2 = EnumC4447xB.ON_PAUSE;
                }
                if (enumC4447xB == enumC4447xB2) {
                    copyOnWriteArrayList.remove(interfaceC4609zF2);
                    runnable.run();
                }
            }
        }));
    }
}
