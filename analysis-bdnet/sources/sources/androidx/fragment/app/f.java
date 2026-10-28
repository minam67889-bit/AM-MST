package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import dastan.prince.bdfreevpn.R;
import defpackage.A6;
import defpackage.AbstractC0055Bt;
import defpackage.AbstractC2925e20;
import defpackage.AbstractC3245i20;
import defpackage.AbstractC4260ut;
import defpackage.AnimationAnimationListenerC4567yk;
import defpackage.C0020Ak;
import defpackage.C0547Us;
import defpackage.C0595Wo;
import defpackage.C0634Yb;
import defpackage.C0756ar;
import defpackage.C4438x6;
import defpackage.C4488xk;
import defpackage.C4655zt;
import defpackage.C6;
import defpackage.FR;
import defpackage.ML;
import defpackage.RunnableC0029At;
import defpackage.RunnableC0625Xs;
import defpackage.RunnableC3320j1;
import defpackage.RunnableC4646zk;
import defpackage.S7;
import defpackage.ViewTreeObserverOnPreDrawListenerC3666nJ;
import defpackage.ZT;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class f {
    public final ViewGroup a;
    public final ArrayList b = new ArrayList();
    public final ArrayList c = new ArrayList();
    public boolean d = false;
    public boolean e = false;

    public f(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public static void a(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int i = AbstractC3245i20.a;
        if (viewGroup.isTransitionGroup()) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                a(childAt, arrayList);
            }
        }
    }

    public static void e(C6 c6, View view) {
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        String transitionName = view.getTransitionName();
        if (transitionName != null) {
            c6.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    e(c6, childAt);
                }
            }
        }
    }

    public static f h(ViewGroup viewGroup, C0756ar c0756ar) {
        Object tag = viewGroup.getTag(R.id.special_effects_controller_view_tag);
        if (tag instanceof f) {
            return (f) tag;
        }
        c0756ar.getClass();
        f fVar = new f(viewGroup);
        viewGroup.setTag(R.id.special_effects_controller_view_tag, fVar);
        return fVar;
    }

    public static f i(ViewGroup viewGroup, t tVar) {
        return h(viewGroup, tVar.E());
    }

    public static void k(C6 c6, Collection collection) {
        Iterator it = ((C4438x6) c6.entrySet()).iterator();
        while (true) {
            A6 a6 = (A6) it;
            if (!a6.hasNext()) {
                return;
            }
            a6.next();
            View view = (View) a6.getValue();
            WeakHashMap weakHashMap = AbstractC2925e20.a;
            if (!collection.contains(view.getTransitionName())) {
                a6.remove();
            }
        }
    }

    public final void b(int i, int i2, w wVar) {
        synchronized (this.b) {
            try {
                C0634Yb c0634Yb = new C0634Yb();
                z f = f(wVar.c);
                if (f != null) {
                    f.c(i, i2);
                    return;
                }
                z zVar = new z(i, i2, wVar, c0634Yb);
                this.b.add(zVar);
                zVar.d.add(new y(this, zVar));
                zVar.d.add(new RunnableC3320j1(21, this, zVar));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6, types: [wT] */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    public final void c(ArrayList arrayList, boolean z) {
        int i;
        ArrayList arrayList2;
        String str;
        HashMap hashMap;
        String str2;
        ArrayList arrayList3;
        ?? r13;
        int i2;
        int i3;
        String str3;
        Iterator it;
        z zVar;
        Object obj;
        Object obj2;
        ArrayList arrayList4;
        View view;
        View view2;
        HashMap hashMap2;
        View view3;
        ArrayList arrayList5;
        Rect rect;
        ArrayList arrayList6;
        View view4;
        Iterator it2 = arrayList.iterator();
        z zVar2 = null;
        z zVar3 = null;
        while (true) {
            i = 2;
            if (!it2.hasNext()) {
                break;
            }
            z zVar4 = (z) it2.next();
            int d = ZT.d(zVar4.c.mView);
            int v = ZT.v(zVar4.a);
            if (v != 0) {
                if (v != 1) {
                    if (v != 2 && v != 3) {
                    }
                } else if (d != 2) {
                    zVar3 = zVar4;
                }
            }
            if (d == 2 && zVar2 == null) {
                zVar2 = zVar4;
            }
        }
        String str4 = " to ";
        String str5 = "FragmentManager";
        if (t.G(2)) {
            Log.v("FragmentManager", "Executing operations from " + zVar2 + " to " + zVar3);
        }
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        int i4 = 1;
        ArrayList arrayList9 = new ArrayList(arrayList);
        l lVar = ((z) arrayList.get(arrayList.size() - 1)).c;
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            int i5 = i;
            C0547Us c0547Us = ((z) it3.next()).c.mAnimationInfo;
            C0547Us c0547Us2 = lVar.mAnimationInfo;
            c0547Us.b = c0547Us2.b;
            c0547Us.c = c0547Us2.c;
            c0547Us.d = c0547Us2.d;
            c0547Us.e = c0547Us2.e;
            i = i5;
        }
        int i6 = i;
        Iterator it4 = arrayList.iterator();
        while (it4.hasNext()) {
            z zVar5 = (z) it4.next();
            C0634Yb c0634Yb = new C0634Yb();
            zVar5.d();
            HashSet hashSet = zVar5.e;
            hashSet.add(c0634Yb);
            d dVar = new d(zVar5, c0634Yb);
            dVar.d = false;
            dVar.c = z;
            arrayList7.add(dVar);
            C0634Yb c0634Yb2 = new C0634Yb();
            zVar5.d();
            hashSet.add(c0634Yb2);
            arrayList8.add(new C0020Ak(zVar5, c0634Yb2, z, !z ? zVar5 != zVar3 : zVar5 != zVar2));
            zVar5.d.add(new c(this, arrayList9, zVar5));
        }
        HashMap hashMap3 = new HashMap();
        Iterator it5 = arrayList8.iterator();
        AbstractC0055Bt abstractC0055Bt = null;
        while (it5.hasNext()) {
            C0020Ak c0020Ak = (C0020Ak) it5.next();
            if (!c0020Ak.b()) {
                Object obj3 = c0020Ak.c;
                AbstractC0055Bt c = c0020Ak.c(obj3);
                Object obj4 = c0020Ak.e;
                Iterator it6 = it5;
                AbstractC0055Bt c2 = c0020Ak.c(obj4);
                ArrayList arrayList10 = arrayList7;
                ArrayList arrayList11 = arrayList8;
                l lVar2 = c0020Ak.a.c;
                if (c != null && c2 != null && c != c2) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + lVar2 + " returned Transition " + obj3 + " which uses a different Transition  type than its shared element transition " + obj4);
                }
                if (c == null) {
                    c = c2;
                }
                if (abstractC0055Bt == null) {
                    abstractC0055Bt = c;
                } else if (c != null && abstractC0055Bt != c) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + lVar2 + " returned Transition " + obj3 + " which uses a different Transition  type than other Fragments.");
                }
                it5 = it6;
                arrayList7 = arrayList10;
                arrayList8 = arrayList11;
            }
        }
        ArrayList arrayList12 = arrayList7;
        ArrayList arrayList13 = arrayList8;
        ViewGroup viewGroup = this.a;
        if (abstractC0055Bt == null) {
            Iterator it7 = arrayList13.iterator();
            while (it7.hasNext()) {
                C0020Ak c0020Ak2 = (C0020Ak) it7.next();
                hashMap3.put(c0020Ak2.a, Boolean.FALSE);
                c0020Ak2.a();
            }
            arrayList2 = arrayList9;
            str = " to ";
            str2 = "FragmentManager";
            hashMap = hashMap3;
        } else {
            View view5 = new View(viewGroup.getContext());
            Rect rect2 = new Rect();
            ArrayList arrayList14 = new ArrayList();
            ArrayList arrayList15 = new ArrayList();
            C6 c6 = new C6(0);
            Iterator it8 = arrayList13.iterator();
            View view6 = null;
            Object obj5 = null;
            boolean z2 = false;
            while (it8.hasNext()) {
                String str6 = str4;
                Object obj6 = ((C0020Ak) it8.next()).e;
                if (obj6 == null || zVar2 == null || zVar3 == null) {
                    hashMap2 = hashMap3;
                    view3 = view5;
                    arrayList5 = arrayList9;
                    rect = rect2;
                    arrayList6 = arrayList15;
                    view6 = view6;
                } else {
                    Object r = abstractC0055Bt.r(abstractC0055Bt.f(obj6));
                    l lVar3 = zVar3.c;
                    View view7 = view6;
                    ArrayList<String> sharedElementSourceNames = lVar3.getSharedElementSourceNames();
                    arrayList5 = arrayList9;
                    l lVar4 = zVar2.c;
                    HashMap hashMap4 = hashMap3;
                    ArrayList<String> sharedElementSourceNames2 = lVar4.getSharedElementSourceNames();
                    View view8 = view5;
                    ArrayList<String> sharedElementTargetNames = lVar4.getSharedElementTargetNames();
                    Rect rect3 = rect2;
                    ArrayList arrayList16 = arrayList15;
                    int i7 = 0;
                    while (i7 < sharedElementTargetNames.size()) {
                        int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i7));
                        ArrayList<String> arrayList17 = sharedElementTargetNames;
                        if (indexOf != -1) {
                            sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i7));
                        }
                        i7++;
                        sharedElementTargetNames = arrayList17;
                    }
                    ArrayList<String> sharedElementTargetNames2 = lVar3.getSharedElementTargetNames();
                    if (z) {
                        lVar4.getEnterTransitionCallback();
                        lVar3.getExitTransitionCallback();
                    } else {
                        lVar4.getExitTransitionCallback();
                        lVar3.getEnterTransitionCallback();
                    }
                    int i8 = 0;
                    for (int size = sharedElementSourceNames.size(); i8 < size; size = size) {
                        c6.put(sharedElementSourceNames.get(i8), sharedElementTargetNames2.get(i8));
                        i8++;
                    }
                    if (t.G(i6)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        for (Iterator<String> it9 = sharedElementTargetNames2.iterator(); it9.hasNext(); it9 = it9) {
                            Log.v("FragmentManager", "Name: " + it9.next());
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator<String> it10 = sharedElementSourceNames.iterator(); it10.hasNext(); it10 = it10) {
                            Log.v("FragmentManager", "Name: " + it10.next());
                        }
                    }
                    C6 c62 = new C6(0);
                    e(c62, lVar4.mView);
                    c62.m(sharedElementSourceNames);
                    c6.m(c62.keySet());
                    C6 c63 = new C6(0);
                    e(c63, lVar3.mView);
                    c63.m(sharedElementTargetNames2);
                    c63.m(c6.values());
                    C4655zt c4655zt = AbstractC4260ut.a;
                    int i9 = c6.c - 1;
                    while (i9 >= 0) {
                        l lVar5 = lVar4;
                        if (!c63.containsKey((String) c6.i(i9))) {
                            c6.g(i9);
                        }
                        i9--;
                        lVar4 = lVar5;
                    }
                    l lVar6 = lVar4;
                    k(c62, c6.keySet());
                    k(c63, c6.values());
                    if (c6.isEmpty()) {
                        arrayList14.clear();
                        arrayList16.clear();
                        arrayList6 = arrayList16;
                        view6 = view7;
                        hashMap2 = hashMap4;
                        view3 = view8;
                        rect = rect3;
                        obj5 = null;
                    } else {
                        if (z) {
                            lVar6.getEnterTransitionCallback();
                        } else {
                            lVar3.getEnterTransitionCallback();
                        }
                        ViewTreeObserverOnPreDrawListenerC3666nJ.a(viewGroup, new RunnableC4646zk(zVar3, zVar2, z, c63));
                        arrayList14.addAll(c62.values());
                        if (sharedElementSourceNames.isEmpty()) {
                            view6 = view7;
                        } else {
                            view6 = (View) c62.get(sharedElementSourceNames.get(0));
                            abstractC0055Bt.m(view6, r);
                        }
                        arrayList6 = arrayList16;
                        arrayList6.addAll(c63.values());
                        if (sharedElementTargetNames2.isEmpty() || (view4 = (View) c63.get(sharedElementTargetNames2.get(0))) == null) {
                            rect = rect3;
                        } else {
                            rect = rect3;
                            ViewTreeObserverOnPreDrawListenerC3666nJ.a(viewGroup, new RunnableC3320j1(abstractC0055Bt, view4, rect));
                            z2 = true;
                        }
                        view3 = view8;
                        abstractC0055Bt.p(r, view3, arrayList14);
                        abstractC0055Bt.l(r, null, null, r, arrayList6);
                        Boolean bool = Boolean.TRUE;
                        hashMap2 = hashMap4;
                        hashMap2.put(zVar2, bool);
                        hashMap2.put(zVar3, bool);
                        obj5 = r;
                    }
                }
                view5 = view3;
                arrayList15 = arrayList6;
                rect2 = rect;
                hashMap3 = hashMap2;
                str4 = str6;
                arrayList9 = arrayList5;
            }
            View view9 = view6;
            arrayList2 = arrayList9;
            str = str4;
            hashMap = hashMap3;
            View view10 = view5;
            Rect rect4 = rect2;
            ArrayList arrayList18 = arrayList15;
            ArrayList arrayList19 = new ArrayList();
            Iterator it11 = arrayList13.iterator();
            Object obj7 = null;
            Object obj8 = null;
            while (it11.hasNext()) {
                Iterator it12 = it11;
                C0020Ak c0020Ak3 = (C0020Ak) it11.next();
                boolean b = c0020Ak3.b();
                C6 c64 = c6;
                z zVar6 = c0020Ak3.a;
                if (b) {
                    hashMap.put(zVar6, Boolean.FALSE);
                    c0020Ak3.a();
                    it11 = it12;
                    str5 = str5;
                    c6 = c64;
                } else {
                    String str7 = str5;
                    Object f = abstractC0055Bt.f(c0020Ak3.c);
                    boolean z3 = obj5 != null && (zVar6 == zVar2 || zVar6 == zVar3);
                    if (f == null) {
                        if (!z3) {
                            hashMap.put(zVar6, Boolean.FALSE);
                            c0020Ak3.a();
                        }
                        view = view10;
                        zVar = zVar3;
                        obj = obj5;
                        view2 = view9;
                    } else {
                        zVar = zVar3;
                        ArrayList arrayList20 = new ArrayList();
                        obj = obj5;
                        l lVar7 = zVar6.c;
                        Object obj9 = obj8;
                        a(lVar7.mView, arrayList20);
                        if (z3) {
                            if (zVar6 == zVar2) {
                                arrayList20.removeAll(arrayList14);
                            } else {
                                arrayList20.removeAll(arrayList18);
                            }
                        }
                        if (arrayList20.isEmpty()) {
                            abstractC0055Bt.a(view10, f);
                            view = view10;
                            arrayList4 = arrayList20;
                            obj2 = f;
                        } else {
                            abstractC0055Bt.b(f, arrayList20);
                            abstractC0055Bt.l(f, f, arrayList20, null, null);
                            obj2 = f;
                            arrayList4 = arrayList20;
                            view = view10;
                            if (zVar6.a == 3) {
                                arrayList2.remove(zVar6);
                                ArrayList arrayList21 = new ArrayList(arrayList4);
                                arrayList21.remove(lVar7.mView);
                                abstractC0055Bt.k(obj2, lVar7.mView, arrayList21);
                                ViewTreeObserverOnPreDrawListenerC3666nJ.a(viewGroup, new S7(arrayList4, 4));
                            }
                        }
                        if (zVar6.a == i6) {
                            arrayList19.addAll(arrayList4);
                            if (z2) {
                                abstractC0055Bt.n(obj2, rect4);
                            }
                            view2 = view9;
                        } else {
                            view2 = view9;
                            abstractC0055Bt.m(view2, obj2);
                        }
                        hashMap.put(zVar6, Boolean.TRUE);
                        if (c0020Ak3.d) {
                            obj8 = obj9;
                            obj7 = abstractC0055Bt.j(obj7, obj2);
                        } else {
                            obj8 = abstractC0055Bt.j(obj9, obj2);
                        }
                    }
                    it11 = it12;
                    view9 = view2;
                    str5 = str7;
                    view10 = view;
                    c6 = c64;
                    zVar3 = zVar;
                    obj5 = obj;
                    i6 = 2;
                }
            }
            z zVar7 = zVar3;
            C6 c65 = c6;
            String str8 = str5;
            Object i10 = abstractC0055Bt.i(obj7, obj8, obj5);
            if (i10 == null) {
                str2 = str8;
                zVar3 = zVar7;
            } else {
                Iterator it13 = arrayList13.iterator();
                while (it13.hasNext()) {
                    C0020Ak c0020Ak4 = (C0020Ak) it13.next();
                    if (!c0020Ak4.b()) {
                        z zVar8 = c0020Ak4.a;
                        z zVar9 = zVar7;
                        boolean z4 = obj5 != null && (zVar8 == zVar2 || zVar8 == zVar9);
                        if (c0020Ak4.c != null || z4) {
                            WeakHashMap weakHashMap = AbstractC2925e20.a;
                            if (viewGroup.isLaidOut()) {
                                str3 = str8;
                                it = it13;
                                abstractC0055Bt.o(i10, c0020Ak4.b, new RunnableC3320j1(c0020Ak4, zVar8, 9, false));
                            } else {
                                if (t.G(2)) {
                                    str3 = str8;
                                    Log.v(str3, "SpecialEffectsController: Container " + viewGroup + " has not been laid out. Completing operation " + zVar8);
                                } else {
                                    str3 = str8;
                                }
                                c0020Ak4.a();
                                it = it13;
                            }
                        } else {
                            it = it13;
                            str3 = str8;
                        }
                        it13 = it;
                        zVar7 = zVar9;
                        str8 = str3;
                    }
                }
                str2 = str8;
                zVar3 = zVar7;
                WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                if (viewGroup.isLaidOut()) {
                    AbstractC4260ut.a(4, arrayList19);
                    ArrayList arrayList22 = new ArrayList();
                    int size2 = arrayList18.size();
                    for (int i11 = 0; i11 < size2; i11++) {
                        View view11 = (View) arrayList18.get(i11);
                        WeakHashMap weakHashMap3 = AbstractC2925e20.a;
                        arrayList22.add(view11.getTransitionName());
                        view11.setTransitionName(null);
                    }
                    if (t.G(2)) {
                        Log.v(str2, ">>>>> Beginning transition <<<<<");
                        Log.v(str2, ">>>>> SharedElementFirstOutViews <<<<<");
                        for (Iterator it14 = arrayList14.iterator(); it14.hasNext(); it14 = it14) {
                            View view12 = (View) it14.next();
                            Log.v(str2, "View: " + view12 + " Name: " + view12.getTransitionName());
                        }
                        Log.v(str2, ">>>>> SharedElementLastInViews <<<<<");
                        for (Iterator it15 = arrayList18.iterator(); it15.hasNext(); it15 = it15) {
                            View view13 = (View) it15.next();
                            Log.v(str2, "View: " + view13 + " Name: " + view13.getTransitionName());
                        }
                    }
                    abstractC0055Bt.c(viewGroup, i10);
                    int size3 = arrayList18.size();
                    ArrayList arrayList23 = new ArrayList();
                    int i12 = 0;
                    while (i12 < size3) {
                        View view14 = (View) arrayList14.get(i12);
                        WeakHashMap weakHashMap4 = AbstractC2925e20.a;
                        String transitionName = view14.getTransitionName();
                        arrayList23.add(transitionName);
                        if (transitionName == null) {
                            i3 = size3;
                            arrayList3 = arrayList23;
                            i2 = i12;
                            r13 = c65;
                        } else {
                            arrayList3 = arrayList23;
                            view14.setTransitionName(null);
                            r13 = c65;
                            String str9 = (String) r13.get(transitionName);
                            i2 = i12;
                            int i13 = 0;
                            while (true) {
                                i3 = size3;
                                if (i13 >= size3) {
                                    break;
                                }
                                if (str9.equals(arrayList22.get(i13))) {
                                    ((View) arrayList18.get(i13)).setTransitionName(transitionName);
                                    break;
                                } else {
                                    i13++;
                                    size3 = i3;
                                }
                            }
                        }
                        i12 = i2 + 1;
                        c65 = r13;
                        size3 = i3;
                        arrayList23 = arrayList3;
                    }
                    ViewTreeObserverOnPreDrawListenerC3666nJ.a(viewGroup, new RunnableC0029At(size3, arrayList18, arrayList22, arrayList14, arrayList23));
                    AbstractC4260ut.a(0, arrayList19);
                    abstractC0055Bt.q(obj5, arrayList14, arrayList18);
                }
            }
        }
        boolean containsValue = hashMap.containsValue(Boolean.TRUE);
        Context context = viewGroup.getContext();
        ArrayList arrayList24 = new ArrayList();
        Iterator it16 = arrayList12.iterator();
        boolean z5 = false;
        while (it16.hasNext()) {
            d dVar2 = (d) it16.next();
            if (dVar2.b()) {
                dVar2.a();
            } else {
                C0595Wo c3 = dVar2.c(context);
                if (c3 == null) {
                    dVar2.a();
                } else {
                    Animator animator = (Animator) c3.c;
                    if (animator == null) {
                        arrayList24.add(dVar2);
                    } else {
                        z zVar10 = dVar2.a;
                        boolean equals = Boolean.TRUE.equals(hashMap.get(zVar10));
                        l lVar8 = zVar10.c;
                        if (equals) {
                            if (t.G(2)) {
                                Log.v(str2, "Ignoring Animator set on " + lVar8 + " as this Fragment was involved in a Transition.");
                            }
                            dVar2.a();
                        } else {
                            boolean z6 = zVar10.a == 3;
                            ArrayList arrayList25 = arrayList2;
                            if (z6) {
                                arrayList25.remove(zVar10);
                            }
                            View view15 = lVar8.mView;
                            viewGroup.startViewTransition(view15);
                            animator.addListener(new C4488xk(viewGroup, view15, z6, zVar10, dVar2));
                            animator.setTarget(view15);
                            animator.start();
                            if (t.G(2)) {
                                Log.v(str2, "Animator from operation " + zVar10 + " has started.");
                            }
                            dVar2.b.a(new ML(animator, zVar10, 22, false));
                            arrayList2 = arrayList25;
                            z5 = true;
                        }
                    }
                }
            }
        }
        ArrayList arrayList26 = arrayList2;
        Iterator it17 = arrayList24.iterator();
        while (it17.hasNext()) {
            d dVar3 = (d) it17.next();
            z zVar11 = dVar3.a;
            l lVar9 = zVar11.c;
            if (containsValue) {
                if (t.G(2)) {
                    Log.v(str2, "Ignoring Animation set on " + lVar9 + " as Animations cannot run alongside Transitions.");
                }
                dVar3.a();
            } else if (z5) {
                if (t.G(2)) {
                    Log.v(str2, "Ignoring Animation set on " + lVar9 + " as Animations cannot run alongside Animators.");
                }
                dVar3.a();
            } else {
                View view16 = lVar9.mView;
                C0595Wo c4 = dVar3.c(context);
                c4.getClass();
                Animation animation = (Animation) c4.b;
                animation.getClass();
                int i14 = i4;
                if (zVar11.a != i14) {
                    view16.startAnimation(animation);
                    dVar3.a();
                } else {
                    viewGroup.startViewTransition(view16);
                    RunnableC0625Xs runnableC0625Xs = new RunnableC0625Xs(animation, viewGroup, view16);
                    runnableC0625Xs.setAnimationListener(new AnimationAnimationListenerC4567yk(zVar11, viewGroup, view16, dVar3));
                    view16.startAnimation(runnableC0625Xs);
                    if (t.G(2)) {
                        Log.v(str2, "Animation from operation " + zVar11 + " has started.");
                    }
                }
                dVar3.b.a(new FR(view16, viewGroup, dVar3, zVar11));
                i4 = i14;
            }
        }
        Iterator it18 = arrayList26.iterator();
        while (it18.hasNext()) {
            z zVar12 = (z) it18.next();
            ZT.a(zVar12.c.mView, zVar12.a);
        }
        arrayList26.clear();
        if (t.G(2)) {
            Log.v(str2, "Completed executing operations from " + zVar2 + str + zVar3);
        }
    }

    public final void d() {
        if (this.e) {
            return;
        }
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        if (!viewGroup.isAttachedToWindow()) {
            g();
            this.d = false;
            return;
        }
        synchronized (this.b) {
            try {
                if (!this.b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.c);
                    this.c.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        z zVar = (z) it.next();
                        if (t.G(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + zVar);
                        }
                        zVar.a();
                        if (!zVar.g) {
                            this.c.add(zVar);
                        }
                    }
                    l();
                    ArrayList arrayList2 = new ArrayList(this.b);
                    this.b.clear();
                    this.c.addAll(arrayList2);
                    if (t.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Executing pending operations");
                    }
                    Iterator it2 = arrayList2.iterator();
                    while (it2.hasNext()) {
                        ((z) it2.next()).d();
                    }
                    c(arrayList2, this.d);
                    this.d = false;
                    if (t.G(2)) {
                        Log.v("FragmentManager", "SpecialEffectsController: Finished executing pending operations");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final z f(l lVar) {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (zVar.c.equals(lVar) && !zVar.f) {
                return zVar;
            }
        }
        return null;
    }

    public final void g() {
        String str;
        String str2;
        if (t.G(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Forcing all operations to complete");
        }
        ViewGroup viewGroup = this.a;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        boolean isAttachedToWindow = viewGroup.isAttachedToWindow();
        synchronized (this.b) {
            try {
                l();
                Iterator it = this.b.iterator();
                while (it.hasNext()) {
                    ((z) it.next()).d();
                }
                Iterator it2 = new ArrayList(this.c).iterator();
                while (it2.hasNext()) {
                    z zVar = (z) it2.next();
                    if (t.G(2)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.a + " is not attached to window. ";
                        }
                        sb.append(str2);
                        sb.append("Cancelling running operation ");
                        sb.append(zVar);
                        Log.v("FragmentManager", sb.toString());
                    }
                    zVar.a();
                }
                Iterator it3 = new ArrayList(this.b).iterator();
                while (it3.hasNext()) {
                    z zVar2 = (z) it3.next();
                    if (t.G(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (isAttachedToWindow) {
                            str = "";
                        } else {
                            str = "Container " + this.a + " is not attached to window. ";
                        }
                        sb2.append(str);
                        sb2.append("Cancelling pending operation ");
                        sb2.append(zVar2);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    zVar2.a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void j() {
        synchronized (this.b) {
            try {
                l();
                this.e = false;
                int size = this.b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    z zVar = (z) this.b.get(size);
                    int d = ZT.d(zVar.c.mView);
                    if (zVar.a == 2 && d != 2) {
                        this.e = zVar.c.isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void l() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            z zVar = (z) it.next();
            if (zVar.b == 2) {
                zVar.c(ZT.c(zVar.c.requireView().getVisibility()), 1);
            }
        }
    }
}
