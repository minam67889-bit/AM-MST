package androidx.fragment.app;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0758at;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC4023rt;
import defpackage.C0595Wo;
import defpackage.C2992et;
import defpackage.C3787ot;
import defpackage.C3945qt;
import defpackage.EnumC4526yB;
import defpackage.InterfaceC4115t20;
import defpackage.ViewOnAttachStateChangeListenerC2970ec;
import defpackage.W50;
import defpackage.ZT;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class w {
    public final C0595Wo a;
    public final x b;
    public final l c;
    public boolean d = false;
    public int e = -1;

    public w(C0595Wo c0595Wo, x xVar, l lVar) {
        this.a = c0595Wo;
        this.b = xVar;
        this.c = lVar;
    }

    public final void a() {
        View view;
        View view2;
        x xVar = this.b;
        xVar.getClass();
        l lVar = this.c;
        ViewGroup viewGroup = lVar.mContainer;
        int i = -1;
        if (viewGroup != null) {
            ArrayList arrayList = xVar.a;
            int indexOf = arrayList.indexOf(lVar);
            int i2 = indexOf - 1;
            while (true) {
                if (i2 < 0) {
                    while (true) {
                        indexOf++;
                        if (indexOf >= arrayList.size()) {
                            break;
                        }
                        l lVar2 = (l) arrayList.get(indexOf);
                        if (lVar2.mContainer == viewGroup && (view = lVar2.mView) != null) {
                            i = viewGroup.indexOfChild(view);
                            break;
                        }
                    }
                } else {
                    l lVar3 = (l) arrayList.get(i2);
                    if (lVar3.mContainer == viewGroup && (view2 = lVar3.mView) != null) {
                        i = viewGroup.indexOfChild(view2) + 1;
                        break;
                    }
                    i2--;
                }
            }
        }
        lVar.mContainer.addView(lVar.mView, i);
    }

    public final void b() {
        boolean G = t.G(3);
        l lVar = this.c;
        if (G) {
            Log.d("FragmentManager", "moveto ATTACHED: " + lVar);
        }
        l lVar2 = lVar.mTarget;
        w wVar = null;
        x xVar = this.b;
        if (lVar2 != null) {
            w wVar2 = (w) xVar.b.get(lVar2.mWho);
            if (wVar2 == null) {
                throw new IllegalStateException("Fragment " + lVar + " declared target fragment " + lVar.mTarget + " that does not belong to this FragmentManager!");
            }
            lVar.mTargetWho = lVar.mTarget.mWho;
            lVar.mTarget = null;
            wVar = wVar2;
        } else {
            String str = lVar.mTargetWho;
            if (str != null && (wVar = (w) xVar.b.get(str)) == null) {
                StringBuilder sb = new StringBuilder("Fragment ");
                sb.append(lVar);
                sb.append(" declared target fragment ");
                throw new IllegalStateException(W50.q(lVar.mTargetWho, " that does not belong to this FragmentManager!", sb));
            }
        }
        if (wVar != null) {
            wVar.j();
        }
        t tVar = lVar.mFragmentManager;
        lVar.mHost = tVar.t;
        lVar.mParentFragment = tVar.v;
        C0595Wo c0595Wo = this.a;
        c0595Wo.l(false);
        lVar.performAttach();
        c0595Wo.f(false);
    }

    public final int c() {
        z zVar;
        l lVar = this.c;
        if (lVar.mFragmentManager == null) {
            return lVar.mState;
        }
        int i = this.e;
        int ordinal = lVar.mMaxState.ordinal();
        if (ordinal == 1) {
            i = Math.min(i, 0);
        } else if (ordinal == 2) {
            i = Math.min(i, 1);
        } else if (ordinal == 3) {
            i = Math.min(i, 5);
        } else if (ordinal != 4) {
            i = Math.min(i, -1);
        }
        if (lVar.mFromLayout) {
            if (lVar.mInLayout) {
                i = Math.max(this.e, 2);
                View view = lVar.mView;
                if (view != null && view.getParent() == null) {
                    i = Math.min(i, 2);
                }
            } else {
                i = this.e < 4 ? Math.min(i, lVar.mState) : Math.min(i, 1);
            }
        }
        if (!lVar.mAdded) {
            i = Math.min(i, 1);
        }
        ViewGroup viewGroup = lVar.mContainer;
        if (viewGroup != null) {
            f i2 = f.i(viewGroup, lVar.getParentFragmentManager());
            i2.getClass();
            z f = i2.f(lVar);
            r6 = f != null ? f.b : 0;
            Iterator it = i2.c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    zVar = null;
                    break;
                }
                zVar = (z) it.next();
                if (zVar.c.equals(lVar) && !zVar.f) {
                    break;
                }
            }
            if (zVar != null && (r6 == 0 || r6 == 1)) {
                r6 = zVar.b;
            }
        }
        if (r6 == 2) {
            i = Math.min(i, 6);
        } else if (r6 == 3) {
            i = Math.max(i, 3);
        } else if (lVar.mRemoving) {
            i = lVar.isInBackStack() ? Math.min(i, 1) : Math.min(i, -1);
        }
        if (lVar.mDeferStart && lVar.mState < 5) {
            i = Math.min(i, 4);
        }
        if (t.G(2)) {
            Log.v("FragmentManager", "computeExpectedState() of " + i + " for " + lVar);
        }
        return i;
    }

    public final void d() {
        boolean G = t.G(3);
        l lVar = this.c;
        if (G) {
            Log.d("FragmentManager", "moveto CREATED: " + lVar);
        }
        if (lVar.mIsCreated) {
            lVar.restoreChildFragmentState(lVar.mSavedFragmentState);
            lVar.mState = 1;
        } else {
            C0595Wo c0595Wo = this.a;
            c0595Wo.n(false);
            lVar.performCreate(lVar.mSavedFragmentState);
            c0595Wo.h(false);
        }
    }

    public final void e() {
        String str;
        l lVar = this.c;
        if (lVar.mFromLayout) {
            return;
        }
        if (t.G(3)) {
            Log.d("FragmentManager", "moveto CREATE_VIEW: " + lVar);
        }
        LayoutInflater performGetLayoutInflater = lVar.performGetLayoutInflater(lVar.mSavedFragmentState);
        ViewGroup viewGroup = lVar.mContainer;
        if (viewGroup == null) {
            int i = lVar.mContainerId;
            if (i == 0) {
                viewGroup = null;
            } else {
                if (i == -1) {
                    throw new IllegalArgumentException(ZT.k("Cannot create fragment ", lVar, " for a container view with no id"));
                }
                viewGroup = (ViewGroup) lVar.mFragmentManager.u.b(i);
                if (viewGroup == null) {
                    if (!lVar.mRestored) {
                        try {
                            str = lVar.getResources().getResourceName(lVar.mContainerId);
                        } catch (Resources.NotFoundException unused) {
                            str = "unknown";
                        }
                        throw new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(lVar.mContainerId) + " (" + str + ") for fragment " + lVar);
                    }
                } else if (!(viewGroup instanceof FragmentContainerView)) {
                    C3945qt c3945qt = AbstractC4023rt.a;
                    AbstractC4023rt.b(new C3787ot(lVar, "Attempting to add fragment " + lVar + " to container " + viewGroup + " which is not a FragmentContainerView"));
                    AbstractC4023rt.a(lVar).getClass();
                }
            }
        }
        lVar.mContainer = viewGroup;
        lVar.performCreateView(performGetLayoutInflater, viewGroup, lVar.mSavedFragmentState);
        View view = lVar.mView;
        if (view != null) {
            view.setSaveFromParentEnabled(false);
            lVar.mView.setTag(R.id.fragment_container_view_tag, lVar);
            if (viewGroup != null) {
                a();
            }
            if (lVar.mHidden) {
                lVar.mView.setVisibility(8);
            }
            View view2 = lVar.mView;
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            if (view2.isAttachedToWindow()) {
                lVar.mView.requestApplyInsets();
            } else {
                View view3 = lVar.mView;
                view3.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC2970ec(view3, 2));
            }
            lVar.performViewCreated();
            this.a.s(false);
            int visibility = lVar.mView.getVisibility();
            lVar.setPostOnViewCreatedAlpha(lVar.mView.getAlpha());
            if (lVar.mContainer != null && visibility == 0) {
                View findFocus = lVar.mView.findFocus();
                if (findFocus != null) {
                    lVar.setFocusedView(findFocus);
                    if (t.G(2)) {
                        Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + lVar);
                    }
                }
                lVar.mView.setAlpha(0.0f);
            }
        }
        lVar.mState = 2;
    }

    public final void f() {
        l b;
        boolean G = t.G(3);
        l lVar = this.c;
        if (G) {
            Log.d("FragmentManager", "movefrom CREATED: " + lVar);
        }
        boolean z = true;
        boolean z2 = lVar.mRemoving && !lVar.isInBackStack();
        x xVar = this.b;
        if (z2 && !lVar.mBeingSaved) {
        }
        if (!z2) {
            u uVar = xVar.d;
            if (!((uVar.b.containsKey(lVar.mWho) && uVar.e) ? uVar.f : true)) {
                String str = lVar.mTargetWho;
                if (str != null && (b = xVar.b(str)) != null && b.mRetainInstance) {
                    lVar.mTarget = b;
                }
                lVar.mState = 0;
                return;
            }
        }
        AbstractC0758at abstractC0758at = lVar.mHost;
        if (abstractC0758at instanceof InterfaceC4115t20) {
            z = xVar.d.f;
        } else {
            q qVar = abstractC0758at.b;
            if (qVar != null) {
                z = true ^ qVar.isChangingConfigurations();
            }
        }
        if ((z2 && !lVar.mBeingSaved) || z) {
            xVar.d.d(lVar);
        }
        lVar.performDestroy();
        this.a.i(false);
        Iterator it = xVar.d().iterator();
        while (it.hasNext()) {
            w wVar = (w) it.next();
            if (wVar != null) {
                String str2 = lVar.mWho;
                l lVar2 = wVar.c;
                if (str2.equals(lVar2.mTargetWho)) {
                    lVar2.mTarget = lVar;
                    lVar2.mTargetWho = null;
                }
            }
        }
        String str3 = lVar.mTargetWho;
        if (str3 != null) {
            lVar.mTarget = xVar.b(str3);
        }
        xVar.h(this);
    }

    public final void g() {
        View view;
        boolean G = t.G(3);
        l lVar = this.c;
        if (G) {
            Log.d("FragmentManager", "movefrom CREATE_VIEW: " + lVar);
        }
        ViewGroup viewGroup = lVar.mContainer;
        if (viewGroup != null && (view = lVar.mView) != null) {
            viewGroup.removeView(view);
        }
        lVar.performDestroyView();
        this.a.t(false);
        lVar.mContainer = null;
        lVar.mView = null;
        lVar.mViewLifecycleOwner = null;
        lVar.mViewLifecycleOwnerLiveData.h(null);
        lVar.mInLayout = false;
    }

    public final void h() {
        boolean G = t.G(3);
        l lVar = this.c;
        if (G) {
            Log.d("FragmentManager", "movefrom ATTACHED: " + lVar);
        }
        lVar.performDetach();
        this.a.j(false);
        lVar.mState = -1;
        lVar.mHost = null;
        lVar.mParentFragment = null;
        lVar.mFragmentManager = null;
        if (!lVar.mRemoving || lVar.isInBackStack()) {
            u uVar = this.b.d;
            if (!((uVar.b.containsKey(lVar.mWho) && uVar.e) ? uVar.f : true)) {
                return;
            }
        }
        if (t.G(3)) {
            Log.d("FragmentManager", "initState called for fragment: " + lVar);
        }
        lVar.initState();
    }

    public final void i() {
        l lVar = this.c;
        if (lVar.mFromLayout && lVar.mInLayout && !lVar.mPerformedCreateView) {
            if (t.G(3)) {
                Log.d("FragmentManager", "moveto CREATE_VIEW: " + lVar);
            }
            lVar.performCreateView(lVar.performGetLayoutInflater(lVar.mSavedFragmentState), null, lVar.mSavedFragmentState);
            View view = lVar.mView;
            if (view != null) {
                view.setSaveFromParentEnabled(false);
                lVar.mView.setTag(R.id.fragment_container_view_tag, lVar);
                if (lVar.mHidden) {
                    lVar.mView.setVisibility(8);
                }
                lVar.performViewCreated();
                this.a.s(false);
                lVar.mState = 2;
            }
        }
    }

    public final void j() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        ViewGroup viewGroup3;
        boolean z = this.d;
        l lVar = this.c;
        if (z) {
            if (t.G(2)) {
                Log.v("FragmentManager", "Ignoring re-entrant call to moveToExpectedState() for " + lVar);
                return;
            }
            return;
        }
        try {
            this.d = true;
            boolean z2 = false;
            while (true) {
                int c = c();
                int i = lVar.mState;
                x xVar = this.b;
                if (c == i) {
                    if (!z2 && i == -1 && lVar.mRemoving && !lVar.isInBackStack() && !lVar.mBeingSaved) {
                        if (t.G(3)) {
                            Log.d("FragmentManager", "Cleaning up state of never attached fragment: " + lVar);
                        }
                        xVar.d.d(lVar);
                        xVar.h(this);
                        if (t.G(3)) {
                            Log.d("FragmentManager", "initState called for fragment: " + lVar);
                        }
                        lVar.initState();
                    }
                    if (lVar.mHiddenChanged) {
                        if (lVar.mView != null && (viewGroup = lVar.mContainer) != null) {
                            f i2 = f.i(viewGroup, lVar.getParentFragmentManager());
                            if (lVar.mHidden) {
                                i2.getClass();
                                if (t.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing hide operation for fragment " + lVar);
                                }
                                i2.b(3, 1, this);
                            } else {
                                i2.getClass();
                                if (t.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing show operation for fragment " + lVar);
                                }
                                i2.b(2, 1, this);
                            }
                        }
                        t tVar = lVar.mFragmentManager;
                        if (tVar != null && lVar.mAdded && t.H(lVar)) {
                            tVar.D = true;
                        }
                        lVar.mHiddenChanged = false;
                        lVar.onHiddenChanged(lVar.mHidden);
                        lVar.mChildFragmentManager.n();
                    }
                    this.d = false;
                    return;
                }
                C0595Wo c0595Wo = this.a;
                if (c <= i) {
                    switch (i - 1) {
                        case -1:
                            h();
                            break;
                        case 0:
                            if (lVar.mBeingSaved) {
                                if (((v) xVar.c.get(lVar.mWho)) == null) {
                                    m();
                                }
                            }
                            f();
                            break;
                        case 1:
                            g();
                            lVar.mState = 1;
                            break;
                        case 2:
                            lVar.mInLayout = false;
                            lVar.mState = 2;
                            break;
                        case 3:
                            if (t.G(3)) {
                                Log.d("FragmentManager", "movefrom ACTIVITY_CREATED: " + lVar);
                            }
                            if (lVar.mBeingSaved) {
                                m();
                            } else if (lVar.mView != null && lVar.mSavedViewState == null) {
                                n();
                            }
                            if (lVar.mView != null && (viewGroup2 = lVar.mContainer) != null) {
                                f i3 = f.i(viewGroup2, lVar.getParentFragmentManager());
                                i3.getClass();
                                if (t.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing remove operation for fragment " + lVar);
                                }
                                i3.b(1, 3, this);
                            }
                            lVar.mState = 3;
                            break;
                        case 4:
                            if (t.G(3)) {
                                Log.d("FragmentManager", "movefrom STARTED: " + lVar);
                            }
                            lVar.performStop();
                            c0595Wo.r(false);
                            break;
                        case 5:
                            lVar.mState = 5;
                            break;
                        case 6:
                            if (t.G(3)) {
                                Log.d("FragmentManager", "movefrom RESUMED: " + lVar);
                            }
                            lVar.performPause();
                            c0595Wo.k(false);
                            break;
                    }
                } else {
                    switch (i + 1) {
                        case 0:
                            b();
                            break;
                        case 1:
                            d();
                            break;
                        case 2:
                            i();
                            e();
                            break;
                        case 3:
                            if (t.G(3)) {
                                Log.d("FragmentManager", "moveto ACTIVITY_CREATED: " + lVar);
                            }
                            lVar.performActivityCreated(lVar.mSavedFragmentState);
                            c0595Wo.e(false);
                            break;
                        case 4:
                            if (lVar.mView != null && (viewGroup3 = lVar.mContainer) != null) {
                                f i4 = f.i(viewGroup3, lVar.getParentFragmentManager());
                                int c2 = ZT.c(lVar.mView.getVisibility());
                                i4.getClass();
                                if (t.G(2)) {
                                    Log.v("FragmentManager", "SpecialEffectsController: Enqueuing add operation for fragment " + lVar);
                                }
                                i4.b(c2, 2, this);
                            }
                            lVar.mState = 4;
                            break;
                        case 5:
                            if (t.G(3)) {
                                Log.d("FragmentManager", "moveto STARTED: " + lVar);
                            }
                            lVar.performStart();
                            c0595Wo.q(false);
                            break;
                        case 6:
                            lVar.mState = 6;
                            break;
                        case 7:
                            l();
                            break;
                    }
                }
                z2 = true;
            }
        } catch (Throwable th) {
            this.d = false;
            throw th;
        }
    }

    public final void k(ClassLoader classLoader) {
        l lVar = this.c;
        Bundle bundle = lVar.mSavedFragmentState;
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        lVar.mSavedViewState = lVar.mSavedFragmentState.getSparseParcelableArray("android:view_state");
        lVar.mSavedViewRegistryState = lVar.mSavedFragmentState.getBundle("android:view_registry_state");
        lVar.mTargetWho = lVar.mSavedFragmentState.getString("android:target_state");
        if (lVar.mTargetWho != null) {
            lVar.mTargetRequestCode = lVar.mSavedFragmentState.getInt("android:target_req_state", 0);
        }
        Boolean bool = lVar.mSavedUserVisibleHint;
        if (bool != null) {
            lVar.mUserVisibleHint = bool.booleanValue();
            lVar.mSavedUserVisibleHint = null;
        } else {
            lVar.mUserVisibleHint = lVar.mSavedFragmentState.getBoolean("android:user_visible_hint", true);
        }
        if (lVar.mUserVisibleHint) {
            return;
        }
        lVar.mDeferStart = true;
    }

    public final void l() {
        boolean G = t.G(3);
        l lVar = this.c;
        if (G) {
            Log.d("FragmentManager", "moveto RESUMED: " + lVar);
        }
        View focusedView = lVar.getFocusedView();
        if (focusedView != null) {
            if (focusedView != lVar.mView) {
                for (ViewParent parent = focusedView.getParent(); parent != null; parent = parent.getParent()) {
                    if (parent != lVar.mView) {
                    }
                }
            }
            boolean requestFocus = focusedView.requestFocus();
            if (t.G(2)) {
                StringBuilder sb = new StringBuilder("requestFocus: Restoring focused view ");
                sb.append(focusedView);
                sb.append(" ");
                sb.append(requestFocus ? "succeeded" : "failed");
                sb.append(" on Fragment ");
                sb.append(lVar);
                sb.append(" resulting in focused view ");
                sb.append(lVar.mView.findFocus());
                Log.v("FragmentManager", sb.toString());
            }
        }
        lVar.setFocusedView(null);
        lVar.performResume();
        this.a.o(false);
        lVar.mSavedFragmentState = null;
        lVar.mSavedViewState = null;
        lVar.mSavedViewRegistryState = null;
    }

    public final void m() {
        l lVar = this.c;
        v vVar = new v(lVar);
        if (lVar.mState <= -1 || vVar.m != null) {
            vVar.m = lVar.mSavedFragmentState;
        } else {
            Bundle bundle = new Bundle();
            lVar.performSaveInstanceState(bundle);
            this.a.p(false);
            if (bundle.isEmpty()) {
                bundle = null;
            }
            if (lVar.mView != null) {
                n();
            }
            if (lVar.mSavedViewState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putSparseParcelableArray("android:view_state", lVar.mSavedViewState);
            }
            if (lVar.mSavedViewRegistryState != null) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBundle("android:view_registry_state", lVar.mSavedViewRegistryState);
            }
            if (!lVar.mUserVisibleHint) {
                if (bundle == null) {
                    bundle = new Bundle();
                }
                bundle.putBoolean("android:user_visible_hint", lVar.mUserVisibleHint);
            }
            vVar.m = bundle;
            if (lVar.mTargetWho != null) {
                if (bundle == null) {
                    vVar.m = new Bundle();
                }
                vVar.m.putString("android:target_state", lVar.mTargetWho);
                int i = lVar.mTargetRequestCode;
                if (i != 0) {
                    vVar.m.putInt("android:target_req_state", i);
                }
            }
        }
    }

    public final void n() {
        l lVar = this.c;
        if (lVar.mView == null) {
            return;
        }
        if (t.G(2)) {
            Log.v("FragmentManager", "Saving view state for fragment " + lVar + " with view " + lVar.mView);
        }
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        lVar.mView.saveHierarchyState(sparseArray);
        if (sparseArray.size() > 0) {
            lVar.mSavedViewState = sparseArray;
        }
        Bundle bundle = new Bundle();
        lVar.mViewLifecycleOwner.d.b(bundle);
        if (bundle.isEmpty()) {
            return;
        }
        lVar.mSavedViewRegistryState = bundle;
    }

    public w(C0595Wo c0595Wo, x xVar, ClassLoader classLoader, C2992et c2992et, v vVar) {
        this.a = c0595Wo;
        this.b = xVar;
        l instantiate = l.instantiate(c2992et.a.t.b, vVar.a, null);
        Bundle bundle = vVar.j;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        instantiate.setArguments(bundle);
        instantiate.mWho = vVar.b;
        instantiate.mFromLayout = vVar.c;
        instantiate.mRestored = true;
        instantiate.mFragmentId = vVar.d;
        instantiate.mContainerId = vVar.e;
        instantiate.mTag = vVar.f;
        instantiate.mRetainInstance = vVar.g;
        instantiate.mRemoving = vVar.h;
        instantiate.mDetached = vVar.i;
        instantiate.mHidden = vVar.k;
        instantiate.mMaxState = EnumC4526yB.values()[vVar.l];
        Bundle bundle2 = vVar.m;
        if (bundle2 != null) {
            instantiate.mSavedFragmentState = bundle2;
        } else {
            instantiate.mSavedFragmentState = new Bundle();
        }
        this.c = instantiate;
        if (t.G(2)) {
            Log.v("FragmentManager", "Instantiated fragment " + instantiate);
        }
    }

    public w(C0595Wo c0595Wo, x xVar, l lVar, v vVar) {
        this.a = c0595Wo;
        this.b = xVar;
        this.c = lVar;
        lVar.mSavedViewState = null;
        lVar.mSavedViewRegistryState = null;
        lVar.mBackStackNesting = 0;
        lVar.mInLayout = false;
        lVar.mAdded = false;
        l lVar2 = lVar.mTarget;
        lVar.mTargetWho = lVar2 != null ? lVar2.mWho : null;
        lVar.mTarget = null;
        Bundle bundle = vVar.m;
        if (bundle != null) {
            lVar.mSavedFragmentState = bundle;
        } else {
            lVar.mSavedFragmentState = new Bundle();
        }
    }
}
