package androidx.fragment.app;

import android.animation.Animator;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import dastan.prince.bdfreevpn.R;
import defpackage.A1;
import defpackage.AbstractC0573Vs;
import defpackage.AbstractC0651Ys;
import defpackage.AbstractC0731aZ;
import defpackage.AbstractC0758at;
import defpackage.AbstractC3634my;
import defpackage.AbstractC3776oi;
import defpackage.AbstractC4023rt;
import defpackage.AbstractC4507y1;
import defpackage.AbstractC4605zB;
import defpackage.C0211Ht;
import defpackage.C0293Kx;
import defpackage.C0469Rs;
import defpackage.C0521Ts;
import defpackage.C0547Us;
import defpackage.C0599Ws;
import defpackage.C0601Wu;
import defpackage.C0627Xu;
import defpackage.C0742af;
import defpackage.C2835cv;
import defpackage.C2992et;
import defpackage.C3120gU;
import defpackage.C3152gt;
import defpackage.C3470kt;
import defpackage.C3673nQ;
import defpackage.C3752oQ;
import defpackage.C3787ot;
import defpackage.C3800p20;
import defpackage.C3831pQ;
import defpackage.C3945qt;
import defpackage.C3988rQ;
import defpackage.C4036s20;
import defpackage.C4416wr;
import defpackage.CV;
import defpackage.EB;
import defpackage.EnumC4447xB;
import defpackage.EnumC4526yB;
import defpackage.G1;
import defpackage.HB;
import defpackage.InterfaceC0031Av;
import defpackage.InterfaceC3708nt;
import defpackage.InterfaceC3879q20;
import defpackage.InterfaceC3910qQ;
import defpackage.InterfaceC3946qu;
import defpackage.InterfaceC4115t20;
import defpackage.InterfaceC4428x1;
import defpackage.MS;
import defpackage.PC;
import defpackage.RunnableC0495Ss;
import defpackage.S7;
import defpackage.TG;
import defpackage.W50;
import defpackage.WG;
import defpackage.XC;
import defpackage.YC;
import defpackage.ZT;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class l implements ComponentCallbacks, View.OnCreateContextMenuListener, EB, InterfaceC4115t20, InterfaceC0031Av, InterfaceC3910qQ {
    static final int ACTIVITY_CREATED = 4;
    static final int ATTACHED = 0;
    static final int AWAITING_ENTER_EFFECTS = 6;
    static final int AWAITING_EXIT_EFFECTS = 3;
    static final int CREATED = 1;
    static final int INITIALIZING = -1;
    static final int RESUMED = 7;
    static final int STARTED = 5;
    static final Object USE_DEFAULT_TRANSITION = new Object();
    static final int VIEW_CREATED = 2;
    boolean mAdded;
    C0547Us mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    InterfaceC3879q20 mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    t mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    AbstractC0758at mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    HB mLifecycleRegistry;
    l mParentFragment;
    boolean mPerformedCreateView;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    C3752oQ mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    l mTarget;
    int mTargetRequestCode;
    View mView;
    C0211Ht mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    t mChildFragmentManager = new C3470kt();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new RunnableC0495Ss(this, 0);
    EnumC4526yB mMaxState = EnumC4526yB.e;
    WG mViewLifecycleOwnerLiveData = new WG();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<AbstractC0573Vs> mOnPreAttachedListeners = new ArrayList<>();
    private final AbstractC0573Vs mSavedStateAttachListener = new h(this);

    public l() {
        d();
    }

    @Deprecated
    public static l instantiate(Context context, String str) {
        return instantiate(context, str, null);
    }

    public final C0547Us a() {
        if (this.mAnimationInfo == null) {
            C0547Us c0547Us = new C0547Us();
            c0547Us.i = null;
            Object obj = USE_DEFAULT_TRANSITION;
            c0547Us.j = obj;
            c0547Us.k = null;
            c0547Us.l = obj;
            c0547Us.m = null;
            c0547Us.n = obj;
            c0547Us.q = 1.0f;
            c0547Us.r = null;
            this.mAnimationInfo = c0547Us;
        }
        return this.mAnimationInfo;
    }

    public final int b() {
        EnumC4526yB enumC4526yB = this.mMaxState;
        return (enumC4526yB == EnumC4526yB.b || this.mParentFragment == null) ? enumC4526yB.ordinal() : Math.min(enumC4526yB.ordinal(), this.mParentFragment.b());
    }

    public final l c(boolean z) {
        String str;
        if (z) {
            C3945qt c3945qt = AbstractC4023rt.a;
            AbstractC4023rt.b(new C0627Xu(this, "Attempting to get target fragment from fragment " + this));
            AbstractC4023rt.a(this).getClass();
        }
        l lVar = this.mTarget;
        if (lVar != null) {
            return lVar;
        }
        t tVar = this.mFragmentManager;
        if (tVar == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return tVar.c.b(str);
    }

    public void callStartTransitionListener(boolean z) {
        ViewGroup viewGroup;
        t tVar;
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us != null) {
            c0547Us.s = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (tVar = this.mFragmentManager) == null) {
            return;
        }
        f h = f.h(viewGroup, tVar.E());
        h.j();
        if (z) {
            this.mHost.c.post(new S7(h, 10));
        } else {
            h.d();
        }
    }

    public AbstractC0651Ys createFragmentContainer() {
        return new i(this);
    }

    public final void d() {
        this.mLifecycleRegistry = new HB(this);
        this.mSavedStateRegistryController = new C3752oQ(new C3831pQ(this, new C4416wr(this, 4)));
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        AbstractC0573Vs abstractC0573Vs = this.mSavedStateAttachListener;
        if (this.mState >= 0) {
            abstractC0573Vs.a();
        } else {
            this.mOnPreAttachedListeners.add(abstractC0573Vs);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        l c = c(false);
        if (c != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(c);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            XC.a(this).b(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.u(W50.C(str, "  "), fileDescriptor, printWriter, strArr);
    }

    public final C0469Rs e(AbstractC4507y1 abstractC4507y1, InterfaceC3946qu interfaceC3946qu, InterfaceC4428x1 interfaceC4428x1) {
        if (this.mState > 1) {
            throw new IllegalStateException(ZT.k("Fragment ", this, " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate())."));
        }
        AtomicReference atomicReference = new AtomicReference();
        C0521Ts c0521Ts = new C0521Ts(this, interfaceC3946qu, atomicReference, abstractC4507y1, interfaceC4428x1);
        if (this.mState >= 0) {
            c0521Ts.a();
        } else {
            this.mOnPreAttachedListeners.add(c0521Ts);
        }
        return new C0469Rs(atomicReference);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    public l findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.c.c(str);
    }

    public String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final q getActivity() {
        AbstractC0758at abstractC0758at = this.mHost;
        if (abstractC0758at == null) {
            return null;
        }
        return abstractC0758at.a;
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null || (bool = c0547Us.p) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null || (bool = c0547Us.o) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public View getAnimatingAway() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        c0547Us.getClass();
        return null;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final t getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " has not been attached yet."));
    }

    public Context getContext() {
        AbstractC0758at abstractC0758at = this.mHost;
        if (abstractC0758at == null) {
            return null;
        }
        return abstractC0758at.b;
    }

    @Override // defpackage.InterfaceC0031Av
    public AbstractC3776oi getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && t.G(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        TG tg = new TG(0);
        LinkedHashMap linkedHashMap = tg.a;
        if (application != null) {
            linkedHashMap.put(C3800p20.d, application);
        }
        linkedHashMap.put(AbstractC0731aZ.g, this);
        linkedHashMap.put(AbstractC0731aZ.h, this);
        if (getArguments() != null) {
            linkedHashMap.put(AbstractC0731aZ.i, getArguments());
        }
        return tg;
    }

    public InterfaceC3879q20 getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && t.G(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new C3988rQ(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    public int getEnterAnim() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return 0;
        }
        return c0547Us.b;
    }

    public Object getEnterTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        return c0547Us.i;
    }

    public MS getEnterTransitionCallback() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        c0547Us.getClass();
        return null;
    }

    public int getExitAnim() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return 0;
        }
        return c0547Us.c;
    }

    public Object getExitTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        return c0547Us.k;
    }

    public MS getExitTransitionCallback() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        c0547Us.getClass();
        return null;
    }

    public View getFocusedView() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        return c0547Us.r;
    }

    @Deprecated
    public final t getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        AbstractC0758at abstractC0758at = this.mHost;
        if (abstractC0758at == null) {
            return null;
        }
        return ((p) abstractC0758at).e;
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // defpackage.EB
    public AbstractC4605zB getLifecycle() {
        return this.mLifecycleRegistry;
    }

    @Deprecated
    public XC getLoaderManager() {
        return XC.a(this);
    }

    public int getNextTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return 0;
        }
        return c0547Us.f;
    }

    public final l getParentFragment() {
        return this.mParentFragment;
    }

    public final t getParentFragmentManager() {
        t tVar = this.mFragmentManager;
        if (tVar != null) {
            return tVar;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " not associated with a fragment manager."));
    }

    public boolean getPopDirection() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return false;
        }
        return c0547Us.a;
    }

    public int getPopEnterAnim() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return 0;
        }
        return c0547Us.d;
    }

    public int getPopExitAnim() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return 0;
        }
        return c0547Us.e;
    }

    public float getPostOnViewCreatedAlpha() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return 1.0f;
        }
        return c0547Us.q;
    }

    public Object getReenterTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        Object obj = c0547Us.l;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        C3945qt c3945qt = AbstractC4023rt.a;
        AbstractC4023rt.b(new C0601Wu(this, "Attempting to get retain instance for fragment " + this));
        AbstractC4023rt.a(this).getClass();
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        Object obj = c0547Us.j;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // defpackage.InterfaceC3910qQ
    public final C3673nQ getSavedStateRegistry() {
        return this.mSavedStateRegistryController.b;
    }

    public Object getSharedElementEnterTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        return c0547Us.m;
    }

    public Object getSharedElementReturnTransition() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return null;
        }
        Object obj = c0547Us.n;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        C0547Us c0547Us = this.mAnimationInfo;
        return (c0547Us == null || (arrayList = c0547Us.g) == null) ? new ArrayList<>() : arrayList;
    }

    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        C0547Us c0547Us = this.mAnimationInfo;
        return (c0547Us == null || (arrayList = c0547Us.h) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getTag() {
        return this.mTag;
    }

    @Deprecated
    public final l getTargetFragment() {
        return c(true);
    }

    @Deprecated
    public final int getTargetRequestCode() {
        C3945qt c3945qt = AbstractC4023rt.a;
        AbstractC4023rt.b(new C0627Xu(this, "Attempting to get target request code from fragment " + this));
        AbstractC4023rt.a(this).getClass();
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    @Deprecated
    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public EB getViewLifecycleOwner() {
        C0211Ht c0211Ht = this.mViewLifecycleOwner;
        if (c0211Ht != null) {
            return c0211Ht;
        }
        throw new IllegalStateException("Can't access the Fragment View's LifecycleOwner when getView() is null i.e., before onCreateView() or after onDestroyView()");
    }

    public PC getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // defpackage.InterfaceC4115t20
    public C4036s20 getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        int b = b();
        EnumC4526yB enumC4526yB = EnumC4526yB.a;
        if (b == 1) {
            throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
        }
        HashMap hashMap = this.mFragmentManager.L.d;
        C4036s20 c4036s20 = (C4036s20) hashMap.get(this.mWho);
        if (c4036s20 != null) {
            return c4036s20;
        }
        C4036s20 c4036s202 = new C4036s20();
        hashMap.put(this.mWho, c4036s202);
        return c4036s202;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public void initState() {
        d();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new C3470kt();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        if (this.mHidden) {
            return true;
        }
        t tVar = this.mFragmentManager;
        if (tVar != null) {
            l lVar = this.mParentFragment;
            tVar.getClass();
            if (lVar == null ? false : lVar.isHidden()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        if (!this.mMenuVisible) {
            return false;
        }
        if (this.mFragmentManager != null) {
            l lVar = this.mParentFragment;
            if (!(lVar == null ? true : lVar.isMenuVisible())) {
                return false;
            }
        }
        return true;
    }

    public boolean isPostponed() {
        C0547Us c0547Us = this.mAnimationInfo;
        if (c0547Us == null) {
            return false;
        }
        return c0547Us.s;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        t tVar = this.mFragmentManager;
        if (tVar == null) {
            return false;
        }
        return tVar.E || tVar.F;
    }

    public final boolean isVisible() {
        View view;
        return (!isAdded() || isHidden() || (view = this.mView) == null || view.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void noteStateNotSaved() {
        this.mChildFragmentManager.L();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i, int i2, Intent intent) {
        if (t.G(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i + " resultCode: " + i2 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        AbstractC0758at abstractC0758at = this.mHost;
        q qVar = abstractC0758at == null ? null : abstractC0758at.a;
        if (qVar != null) {
            this.mCalled = false;
            onAttach((Activity) qVar);
        }
    }

    @Deprecated
    public void onAttachFragment(l lVar) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        t tVar = this.mChildFragmentManager;
        if (tVar.s >= 1) {
            return;
        }
        tVar.E = false;
        tVar.F = false;
        tVar.L.g = false;
        tVar.t(1);
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i = this.mContentLayoutId;
        if (i != 0) {
            return layoutInflater.inflate(i, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        AbstractC0758at abstractC0758at = this.mHost;
        q qVar = abstractC0758at == null ? null : abstractC0758at.a;
        if (qVar != null) {
            this.mCalled = false;
            onInflate((Activity) qVar, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public abstract void onSaveInstanceState(Bundle bundle);

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.L();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onActivityCreated()"));
        }
        if (t.G(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
        t tVar = this.mChildFragmentManager;
        tVar.E = false;
        tVar.F = false;
        tVar.L.g = false;
        tVar.t(4);
    }

    public void performAttach() {
        Iterator<AbstractC0573Vs> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.b(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach((Context) this.mHost.b);
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onAttach()"));
        }
        Iterator it2 = this.mFragmentManager.m.iterator();
        while (it2.hasNext()) {
            ((InterfaceC3708nt) it2.next()).a(this);
        }
        t tVar = this.mChildFragmentManager;
        tVar.E = false;
        tVar.F = false;
        tVar.L.g = false;
        tVar.t(0);
    }

    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.i(menuItem);
    }

    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.L();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.a(new j(this));
        this.mSavedStateRegistryController.a(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onCreate()"));
        }
        this.mLifecycleRegistry.e(EnumC4447xB.ON_CREATE);
    }

    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z = true;
        }
        return this.mChildFragmentManager.j(menu, menuInflater) | z;
    }

    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.L();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new C0211Ht(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.c != null) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
            return;
        }
        this.mViewLifecycleOwner.b();
        View view = this.mView;
        C0211Ht c0211Ht = this.mViewLifecycleOwner;
        AbstractC3634my.g(view, "<this>");
        view.setTag(R.id.view_tree_lifecycle_owner, c0211Ht);
        View view2 = this.mView;
        C0211Ht c0211Ht2 = this.mViewLifecycleOwner;
        AbstractC3634my.g(view2, "<this>");
        view2.setTag(R.id.view_tree_view_model_store_owner, c0211Ht2);
        View view3 = this.mView;
        C0211Ht c0211Ht3 = this.mViewLifecycleOwner;
        AbstractC3634my.g(view3, "<this>");
        view3.setTag(R.id.view_tree_saved_state_registry_owner, c0211Ht3);
        this.mViewLifecycleOwnerLiveData.h(this.mViewLifecycleOwner);
    }

    public void performDestroy() {
        this.mChildFragmentManager.k();
        this.mLifecycleRegistry.e(EnumC4447xB.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onDestroy()"));
        }
    }

    public void performDestroyView() {
        this.mChildFragmentManager.t(1);
        if (this.mView != null) {
            C0211Ht c0211Ht = this.mViewLifecycleOwner;
            c0211Ht.b();
            if (c0211Ht.c.h.compareTo(EnumC4526yB.c) >= 0) {
                this.mViewLifecycleOwner.a(EnumC4447xB.ON_DESTROY);
            }
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onDestroyView()"));
        }
        C3120gU c3120gU = XC.a(this).b.b;
        int i = c3120gU.c;
        for (int i2 = 0; i2 < i; i2++) {
            ((YC) c3120gU.d(i2)).j();
        }
        this.mPerformedCreateView = false;
    }

    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onDetach()"));
        }
        t tVar = this.mChildFragmentManager;
        if (tVar.G) {
            return;
        }
        tVar.k();
        this.mChildFragmentManager = new C3470kt();
    }

    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    public void performLowMemory() {
        onLowMemory();
    }

    public void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
    }

    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.o(menuItem);
    }

    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.p(menu);
    }

    public void performPause() {
        this.mChildFragmentManager.t(5);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC4447xB.ON_PAUSE);
        }
        this.mLifecycleRegistry.e(EnumC4447xB.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onPause()"));
        }
    }

    public void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
    }

    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z = true;
        }
        return this.mChildFragmentManager.s(menu) | z;
    }

    public void performPrimaryNavigationFragmentChanged() {
        this.mFragmentManager.getClass();
        boolean J = t.J(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != J) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(J);
            onPrimaryNavigationFragmentChanged(J);
            t tVar = this.mChildFragmentManager;
            tVar.a0();
            tVar.q(tVar.w);
        }
    }

    public void performResume() {
        this.mChildFragmentManager.L();
        this.mChildFragmentManager.x(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onResume()"));
        }
        HB hb = this.mLifecycleRegistry;
        EnumC4447xB enumC4447xB = EnumC4447xB.ON_RESUME;
        hb.e(enumC4447xB);
        if (this.mView != null) {
            this.mViewLifecycleOwner.c.e(enumC4447xB);
        }
        t tVar = this.mChildFragmentManager;
        tVar.E = false;
        tVar.F = false;
        tVar.L.g = false;
        tVar.t(7);
    }

    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.b(bundle);
        bundle.putParcelable("android:support:fragments", this.mChildFragmentManager.S());
    }

    public void performStart() {
        this.mChildFragmentManager.L();
        this.mChildFragmentManager.x(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onStart()"));
        }
        HB hb = this.mLifecycleRegistry;
        EnumC4447xB enumC4447xB = EnumC4447xB.ON_START;
        hb.e(enumC4447xB);
        if (this.mView != null) {
            this.mViewLifecycleOwner.c.e(enumC4447xB);
        }
        t tVar = this.mChildFragmentManager;
        tVar.E = false;
        tVar.F = false;
        tVar.L.g = false;
        tVar.t(5);
    }

    public void performStop() {
        t tVar = this.mChildFragmentManager;
        tVar.F = true;
        tVar.L.g = true;
        tVar.t(4);
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC4447xB.ON_STOP);
        }
        this.mLifecycleRegistry.e(EnumC4447xB.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onStop()"));
        }
    }

    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.t(2);
    }

    public void postponeEnterTransition() {
        a().s = true;
    }

    public final <I, O> A1 registerForActivityResult(AbstractC4507y1 abstractC4507y1, InterfaceC4428x1 interfaceC4428x1) {
        return e(abstractC4507y1, new k(this), interfaceC4428x1);
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    @Deprecated
    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to Activity"));
        }
        t parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.B == null) {
            parentFragmentManager.t.getClass();
            return;
        }
        parentFragmentManager.C.addLast(new C3152gt(this.mWho, i));
        parentFragmentManager.B.a(strArr);
    }

    public final q requireActivity() {
        q activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to an activity."));
    }

    public final Bundle requireArguments() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " does not have any arguments."));
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to a context."));
    }

    @Deprecated
    public final t requireFragmentManager() {
        return getParentFragmentManager();
    }

    public final Object requireHost() {
        Object host = getHost();
        if (host != null) {
            return host;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to a host."));
    }

    public final l requireParentFragment() {
        l parentFragment = getParentFragment();
        if (parentFragment != null) {
            return parentFragment;
        }
        if (getContext() == null) {
            throw new IllegalStateException(ZT.k("Fragment ", this, " is not attached to any Fragment or host"));
        }
        throw new IllegalStateException("Fragment " + this + " is not a child Fragment, it is directly attached to " + getContext());
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException(ZT.k("Fragment ", this, " did not return a View from onCreateView() or this was called before onCreateView()."));
    }

    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.R(parcelable);
        t tVar = this.mChildFragmentManager;
        tVar.E = false;
        tVar.F = false;
        tVar.L.g = false;
        tVar.t(1);
    }

    public final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            C0211Ht c0211Ht = this.mViewLifecycleOwner;
            c0211Ht.d.a(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new CV(ZT.k("Fragment ", this, " did not call through to super.onViewStateRestored()"));
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.a(EnumC4447xB.ON_CREATE);
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        a().p = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        a().o = Boolean.valueOf(z);
    }

    public void setAnimations(int i, int i2, int i3, int i4) {
        if (this.mAnimationInfo == null && i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return;
        }
        a().b = i;
        a().c = i2;
        a().d = i3;
        a().e = i4;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(MS ms) {
        a().getClass();
    }

    public void setEnterTransition(Object obj) {
        a().i = obj;
    }

    public void setExitSharedElementCallback(MS ms) {
        a().getClass();
    }

    public void setExitTransition(Object obj) {
        a().k = obj;
    }

    public void setFocusedView(View view) {
        a().r = view;
    }

    @Deprecated
    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (!isAdded() || isHidden()) {
                return;
            }
            ((p) this.mHost).e.invalidateOptionsMenu();
        }
    }

    public void setInitialSavedState(C0599Ws c0599Ws) {
        Bundle bundle;
        if (this.mFragmentManager != null) {
            throw new IllegalStateException("Fragment already added");
        }
        if (c0599Ws == null || (bundle = c0599Ws.a) == null) {
            bundle = null;
        }
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                ((p) this.mHost).e.invalidateOptionsMenu();
            }
        }
    }

    public void setNextTransition(int i) {
        if (this.mAnimationInfo == null && i == 0) {
            return;
        }
        a();
        this.mAnimationInfo.f = i;
    }

    public void setPopDirection(boolean z) {
        if (this.mAnimationInfo == null) {
            return;
        }
        a().a = z;
    }

    public void setPostOnViewCreatedAlpha(float f) {
        a().q = f;
    }

    public void setReenterTransition(Object obj) {
        a().l = obj;
    }

    @Deprecated
    public void setRetainInstance(boolean z) {
        C3945qt c3945qt = AbstractC4023rt.a;
        AbstractC4023rt.b(new C0601Wu(this, "Attempting to set retain instance for fragment " + this));
        AbstractC4023rt.a(this).getClass();
        this.mRetainInstance = z;
        t tVar = this.mFragmentManager;
        if (tVar == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z) {
            tVar.L.c(this);
        } else {
            tVar.L.f(this);
        }
    }

    public void setReturnTransition(Object obj) {
        a().j = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        a().m = obj;
    }

    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        a();
        C0547Us c0547Us = this.mAnimationInfo;
        c0547Us.g = arrayList;
        c0547Us.h = arrayList2;
    }

    public void setSharedElementReturnTransition(Object obj) {
        a().n = obj;
    }

    @Deprecated
    public void setTargetFragment(l lVar, int i) {
        if (lVar != null) {
            C3945qt c3945qt = AbstractC4023rt.a;
            AbstractC4023rt.b(new C0627Xu(this, "Attempting to set target fragment " + lVar + " with request code " + i + " for fragment " + this));
            AbstractC4023rt.a(this).getClass();
        }
        t tVar = this.mFragmentManager;
        t tVar2 = lVar != null ? lVar.mFragmentManager : null;
        if (tVar != null && tVar2 != null && tVar != tVar2) {
            throw new IllegalArgumentException(ZT.k("Fragment ", lVar, " must share the same FragmentManager to be set as a target fragment"));
        }
        for (l lVar2 = lVar; lVar2 != null; lVar2 = lVar2.c(false)) {
            if (lVar2.equals(this)) {
                throw new IllegalArgumentException("Setting " + lVar + " as the target of " + this + " would create a target cycle");
            }
        }
        if (lVar == null) {
            this.mTargetWho = null;
            this.mTarget = null;
        } else if (this.mFragmentManager == null || lVar.mFragmentManager == null) {
            this.mTargetWho = null;
            this.mTarget = lVar;
        } else {
            this.mTargetWho = lVar.mWho;
            this.mTarget = null;
        }
        this.mTargetRequestCode = i;
    }

    @Deprecated
    public void setUserVisibleHint(boolean z) {
        C3945qt c3945qt = AbstractC4023rt.a;
        AbstractC4023rt.b(new C3787ot(this, "Attempting to set user visible hint to " + z + " for fragment " + this));
        AbstractC4023rt.a(this).getClass();
        boolean z2 = false;
        if (!this.mUserVisibleHint && z && this.mState < 5 && this.mFragmentManager != null && isAdded() && this.mIsCreated) {
            t tVar = this.mFragmentManager;
            w f = tVar.f(this);
            l lVar = f.c;
            if (lVar.mDeferStart) {
                if (tVar.b) {
                    tVar.H = true;
                } else {
                    lVar.mDeferStart = false;
                    f.j();
                }
            }
        }
        this.mUserVisibleHint = z;
        if (this.mState < 5 && !z) {
            z2 = true;
        }
        this.mDeferStart = z2;
        if (this.mSavedFragmentState != null) {
            this.mSavedUserVisibleHint = Boolean.valueOf(z);
        }
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        AbstractC0758at abstractC0758at = this.mHost;
        if (abstractC0758at == null) {
            return false;
        }
        p pVar = (p) abstractC0758at;
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            pVar.getClass();
            if (TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
                return false;
            }
        }
        q qVar = pVar.e;
        if (i >= 32) {
            return qVar.shouldShowRequestPermissionRationale(str);
        }
        if (i != 31) {
            return qVar.shouldShowRequestPermissionRationale(str);
        }
        try {
            return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(qVar.getApplication().getPackageManager(), str)).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return qVar.shouldShowRequestPermissionRationale(str);
        }
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    @Deprecated
    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to Activity"));
        }
        if (t.G(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in startIntentSenderForResult() requestCode: " + i + " IntentSender: " + intentSender + " fillInIntent: " + intent + " options: " + bundle);
        }
        t parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.A == null) {
            AbstractC0758at abstractC0758at = parentFragmentManager.t;
            if (i == -1) {
                abstractC0758at.a.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
                return;
            } else {
                abstractC0758at.getClass();
                throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
            }
        }
        if (bundle != null) {
            if (intent == null) {
                intent = new Intent();
                intent.putExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", true);
            }
            if (t.G(2)) {
                Log.v("FragmentManager", "ActivityOptions " + bundle + " were added to fillInIntent " + intent + " for fragment " + this);
            }
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        AbstractC3634my.g(intentSender, "intentSender");
        C0293Kx c0293Kx = new C0293Kx(intentSender, intent, i2, i3);
        parentFragmentManager.C.addLast(new C3152gt(this.mWho, i));
        if (t.G(2)) {
            Log.v("FragmentManager", "Fragment " + this + "is launching an IntentSender for result ");
        }
        parentFragmentManager.A.a(c0293Kx);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !a().s) {
            return;
        }
        if (this.mHost == null) {
            a().s = false;
        } else if (Looper.myLooper() != this.mHost.c.getLooper()) {
            this.mHost.c.postAtFrontOfQueue(new RunnableC0495Ss(this, 1));
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(UserVerificationMethods.USER_VERIFY_PATTERN);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }

    @Deprecated
    public static l instantiate(Context context, String str, Bundle bundle) {
        try {
            l lVar = (l) C2992et.b(str, context.getClassLoader()).getConstructor(new Class[0]).newInstance(new Object[0]);
            if (bundle == null) {
                return lVar;
            }
            bundle.setClassLoader(lVar.getClass().getClassLoader());
            lVar.setArguments(bundle);
            return lVar;
        } catch (IllegalAccessException e) {
            throw new C0742af(W50.D("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e);
        } catch (InstantiationException e2) {
            throw new C0742af(W50.D("Unable to instantiate fragment ", str, ": make sure class name exists, is public, and has an empty constructor that is public"), e2);
        } catch (NoSuchMethodException e3) {
            throw new C0742af(W50.D("Unable to instantiate fragment ", str, ": could not find Fragment constructor"), e3);
        } catch (InvocationTargetException e4) {
            throw new C0742af(W50.D("Unable to instantiate fragment ", str, ": calling Fragment constructor caused an exception"), e4);
        }
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final void postponeEnterTransition(long j, TimeUnit timeUnit) {
        a().s = true;
        t tVar = this.mFragmentManager;
        Handler handler = tVar != null ? tVar.t.c : new Handler(Looper.getMainLooper());
        handler.removeCallbacks(this.mPostponedDurationRunnable);
        handler.postDelayed(this.mPostponedDurationRunnable, timeUnit.toMillis(j));
    }

    public final <I, O> A1 registerForActivityResult(AbstractC4507y1 abstractC4507y1, G1 g1, InterfaceC4428x1 interfaceC4428x1) {
        return e(abstractC4507y1, new C2835cv(g1, 18), interfaceC4428x1);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        AbstractC0758at abstractC0758at = this.mHost;
        if (abstractC0758at == null) {
            throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to Activity"));
        }
        abstractC0758at.b.startActivity(intent, bundle);
    }

    @Deprecated
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException(ZT.k("Fragment ", this, " not attached to Activity"));
        }
        t parentFragmentManager = getParentFragmentManager();
        if (parentFragmentManager.z == null) {
            AbstractC0758at abstractC0758at = parentFragmentManager.t;
            if (i == -1) {
                abstractC0758at.b.startActivity(intent, bundle);
                return;
            } else {
                abstractC0758at.getClass();
                throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
            }
        }
        parentFragmentManager.C.addLast(new C3152gt(this.mWho, i));
        if (intent != null && bundle != null) {
            intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundle);
        }
        parentFragmentManager.z.a(intent);
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        AbstractC0758at abstractC0758at = this.mHost;
        if (abstractC0758at != null) {
            q qVar = ((p) abstractC0758at).e;
            LayoutInflater cloneInContext = qVar.getLayoutInflater().cloneInContext(qVar);
            cloneInContext.setFactory2(this.mChildFragmentManager.f);
            return cloneInContext;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }
}
