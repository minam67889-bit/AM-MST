package androidx.fragment.app;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.t;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0651Ys;
import defpackage.AbstractC0758at;
import defpackage.AbstractC4023rt;
import defpackage.C0136Ew;
import defpackage.C0595Wo;
import defpackage.C0756ar;
import defpackage.C0838bt;
import defpackage.C2833ct;
import defpackage.C2835cv;
import defpackage.C2882dV;
import defpackage.C2912dt;
import defpackage.C2992et;
import defpackage.C3072ft;
import defpackage.C3374jf;
import defpackage.C3550lt;
import defpackage.C3673nQ;
import defpackage.C3897qD;
import defpackage.C4102st;
import defpackage.C4586z1;
import defpackage.E9;
import defpackage.EB;
import defpackage.EnumC4526yB;
import defpackage.F1;
import defpackage.G1;
import defpackage.H1;
import defpackage.InterfaceC0874cJ;
import defpackage.InterfaceC3105gF;
import defpackage.InterfaceC3189hJ;
import defpackage.InterfaceC3232ht;
import defpackage.InterfaceC3269iJ;
import defpackage.InterfaceC3587mJ;
import defpackage.InterfaceC3708nt;
import defpackage.InterfaceC3910qQ;
import defpackage.InterfaceC4115t20;
import defpackage.InterfaceC4405wg;
import defpackage.S7;
import defpackage.W50;
import defpackage.XI;
import defpackage.YI;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class t {
    public F1 A;
    public F1 B;
    public ArrayDeque C;
    public boolean D;
    public boolean E;
    public boolean F;
    public boolean G;
    public boolean H;
    public ArrayList I;
    public ArrayList J;
    public ArrayList K;
    public u L;
    public final S7 M;
    public boolean b;
    public ArrayList d;
    public ArrayList e;
    public XI g;
    public final C0595Wo l;
    public final CopyOnWriteArrayList m;
    public final C0838bt n;
    public final C0838bt o;
    public final C0838bt p;
    public final C0838bt q;
    public final C2912dt r;
    public int s;
    public AbstractC0758at t;
    public AbstractC0651Ys u;
    public l v;
    public l w;
    public final C2992et x;
    public final C0756ar y;
    public F1 z;
    public final ArrayList a = new ArrayList();
    public final x c = new x();
    public final s f = new s(this);
    public final C2833ct h = new C2833ct(this);
    public final AtomicInteger i = new AtomicInteger();
    public final Map j = Collections.synchronizedMap(new HashMap());
    public final Map k = Collections.synchronizedMap(new HashMap());

    /* JADX WARN: Type inference failed for: r0v12, types: [bt] */
    /* JADX WARN: Type inference failed for: r0v13, types: [bt] */
    /* JADX WARN: Type inference failed for: r0v14, types: [bt] */
    /* JADX WARN: Type inference failed for: r0v15, types: [bt] */
    public t() {
        Collections.synchronizedMap(new HashMap());
        this.l = new C0595Wo(this);
        this.m = new CopyOnWriteArrayList();
        final int i = 0;
        this.n = new InterfaceC4405wg(this) { // from class: bt
            public final /* synthetic */ t b;

            {
                this.b = this;
            }

            @Override // defpackage.InterfaceC4405wg
            public final void accept(Object obj) {
                switch (i) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        t tVar = this.b;
                        if (tVar.I()) {
                            tVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        t tVar2 = this.b;
                        if (tVar2.I() && num.intValue() == 80) {
                            tVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        NG ng = (NG) obj;
                        t tVar3 = this.b;
                        if (tVar3.I()) {
                            tVar3.m(ng.a, false);
                            break;
                        }
                        break;
                    default:
                        C0796bK c0796bK = (C0796bK) obj;
                        t tVar4 = this.b;
                        if (tVar4.I()) {
                            tVar4.r(c0796bK.a, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i2 = 1;
        this.o = new InterfaceC4405wg(this) { // from class: bt
            public final /* synthetic */ t b;

            {
                this.b = this;
            }

            @Override // defpackage.InterfaceC4405wg
            public final void accept(Object obj) {
                switch (i2) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        t tVar = this.b;
                        if (tVar.I()) {
                            tVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        t tVar2 = this.b;
                        if (tVar2.I() && num.intValue() == 80) {
                            tVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        NG ng = (NG) obj;
                        t tVar3 = this.b;
                        if (tVar3.I()) {
                            tVar3.m(ng.a, false);
                            break;
                        }
                        break;
                    default:
                        C0796bK c0796bK = (C0796bK) obj;
                        t tVar4 = this.b;
                        if (tVar4.I()) {
                            tVar4.r(c0796bK.a, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i3 = 2;
        this.p = new InterfaceC4405wg(this) { // from class: bt
            public final /* synthetic */ t b;

            {
                this.b = this;
            }

            @Override // defpackage.InterfaceC4405wg
            public final void accept(Object obj) {
                switch (i3) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        t tVar = this.b;
                        if (tVar.I()) {
                            tVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        t tVar2 = this.b;
                        if (tVar2.I() && num.intValue() == 80) {
                            tVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        NG ng = (NG) obj;
                        t tVar3 = this.b;
                        if (tVar3.I()) {
                            tVar3.m(ng.a, false);
                            break;
                        }
                        break;
                    default:
                        C0796bK c0796bK = (C0796bK) obj;
                        t tVar4 = this.b;
                        if (tVar4.I()) {
                            tVar4.r(c0796bK.a, false);
                            break;
                        }
                        break;
                }
            }
        };
        final int i4 = 3;
        this.q = new InterfaceC4405wg(this) { // from class: bt
            public final /* synthetic */ t b;

            {
                this.b = this;
            }

            @Override // defpackage.InterfaceC4405wg
            public final void accept(Object obj) {
                switch (i4) {
                    case 0:
                        Configuration configuration = (Configuration) obj;
                        t tVar = this.b;
                        if (tVar.I()) {
                            tVar.h(false, configuration);
                            break;
                        }
                        break;
                    case 1:
                        Integer num = (Integer) obj;
                        t tVar2 = this.b;
                        if (tVar2.I() && num.intValue() == 80) {
                            tVar2.l(false);
                            break;
                        }
                        break;
                    case 2:
                        NG ng = (NG) obj;
                        t tVar3 = this.b;
                        if (tVar3.I()) {
                            tVar3.m(ng.a, false);
                            break;
                        }
                        break;
                    default:
                        C0796bK c0796bK = (C0796bK) obj;
                        t tVar4 = this.b;
                        if (tVar4.I()) {
                            tVar4.r(c0796bK.a, false);
                            break;
                        }
                        break;
                }
            }
        };
        this.r = new C2912dt(this);
        this.s = -1;
        this.x = new C2992et(this);
        this.y = new C0756ar(20);
        this.C = new ArrayDeque();
        this.M = new S7(this, 11);
    }

    public static boolean G(int i) {
        return Log.isLoggable("FragmentManager", i);
    }

    public static boolean H(l lVar) {
        if (lVar.mHasMenu && lVar.mMenuVisible) {
            return true;
        }
        Iterator it = lVar.mChildFragmentManager.c.e().iterator();
        boolean z = false;
        while (it.hasNext()) {
            l lVar2 = (l) it.next();
            if (lVar2 != null) {
                z = H(lVar2);
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    public static boolean J(l lVar) {
        if (lVar == null) {
            return true;
        }
        t tVar = lVar.mFragmentManager;
        return lVar.equals(tVar.w) && J(tVar.v);
    }

    public static void Y(l lVar) {
        if (G(2)) {
            Log.v("FragmentManager", "show: " + lVar);
        }
        if (lVar.mHidden) {
            lVar.mHidden = false;
            lVar.mHiddenChanged = !lVar.mHiddenChanged;
        }
    }

    public final l A(int i) {
        x xVar = this.c;
        ArrayList arrayList = xVar.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            l lVar = (l) arrayList.get(size);
            if (lVar != null && lVar.mFragmentId == i) {
                return lVar;
            }
        }
        for (w wVar : xVar.b.values()) {
            if (wVar != null) {
                l lVar2 = wVar.c;
                if (lVar2.mFragmentId == i) {
                    return lVar2;
                }
            }
        }
        return null;
    }

    public final l B(String str) {
        x xVar = this.c;
        ArrayList arrayList = xVar.a;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            l lVar = (l) arrayList.get(size);
            if (lVar != null && str.equals(lVar.mTag)) {
                return lVar;
            }
        }
        for (w wVar : xVar.b.values()) {
            if (wVar != null) {
                l lVar2 = wVar.c;
                if (str.equals(lVar2.mTag)) {
                    return lVar2;
                }
            }
        }
        return null;
    }

    public final ViewGroup C(l lVar) {
        ViewGroup viewGroup = lVar.mContainer;
        if (viewGroup != null) {
            return viewGroup;
        }
        if (lVar.mContainerId <= 0 || !this.u.c()) {
            return null;
        }
        View b = this.u.b(lVar.mContainerId);
        if (b instanceof ViewGroup) {
            return (ViewGroup) b;
        }
        return null;
    }

    public final C2992et D() {
        l lVar = this.v;
        return lVar != null ? lVar.mFragmentManager.D() : this.x;
    }

    public final C0756ar E() {
        l lVar = this.v;
        return lVar != null ? lVar.mFragmentManager.E() : this.y;
    }

    public final void F(l lVar) {
        if (G(2)) {
            Log.v("FragmentManager", "hide: " + lVar);
        }
        if (lVar.mHidden) {
            return;
        }
        lVar.mHidden = true;
        lVar.mHiddenChanged = true ^ lVar.mHiddenChanged;
        X(lVar);
    }

    public final boolean I() {
        l lVar = this.v;
        if (lVar == null) {
            return true;
        }
        return lVar.isAdded() && this.v.getParentFragmentManager().I();
    }

    public final void K(int i, boolean z) {
        HashMap hashMap;
        AbstractC0758at abstractC0758at;
        if (this.t == null && i != -1) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.s) {
            this.s = i;
            x xVar = this.c;
            Iterator it = xVar.a.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                hashMap = xVar.b;
                if (!hasNext) {
                    break;
                }
                w wVar = (w) hashMap.get(((l) it.next()).mWho);
                if (wVar != null) {
                    wVar.j();
                }
            }
            for (w wVar2 : hashMap.values()) {
                if (wVar2 != null) {
                    wVar2.j();
                    l lVar = wVar2.c;
                    if (lVar.mRemoving && !lVar.isInBackStack()) {
                        if (lVar.mBeingSaved && !xVar.c.containsKey(lVar.mWho)) {
                            wVar2.m();
                        }
                        xVar.h(wVar2);
                    }
                }
            }
            Iterator it2 = xVar.d().iterator();
            while (it2.hasNext()) {
                w wVar3 = (w) it2.next();
                l lVar2 = wVar3.c;
                if (lVar2.mDeferStart) {
                    if (this.b) {
                        this.H = true;
                    } else {
                        lVar2.mDeferStart = false;
                        wVar3.j();
                    }
                }
            }
            if (this.D && (abstractC0758at = this.t) != null && this.s == 7) {
                ((p) abstractC0758at).e.invalidateOptionsMenu();
                this.D = false;
            }
        }
    }

    public final void L() {
        if (this.t == null) {
            return;
        }
        this.E = false;
        this.F = false;
        this.L.g = false;
        for (l lVar : this.c.f()) {
            if (lVar != null) {
                lVar.noteStateNotSaved();
            }
        }
    }

    public final boolean M() {
        return N(-1, 0);
    }

    public final boolean N(int i, int i2) {
        x(false);
        w(true);
        l lVar = this.w;
        if (lVar != null && i < 0 && lVar.getChildFragmentManager().M()) {
            return true;
        }
        boolean O = O(this.I, this.J, i, i2);
        if (O) {
            this.b = true;
            try {
                Q(this.I, this.J);
            } finally {
                d();
            }
        }
        a0();
        boolean z = this.H;
        x xVar = this.c;
        if (z) {
            this.H = false;
            Iterator it = xVar.d().iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                l lVar2 = wVar.c;
                if (lVar2.mDeferStart) {
                    if (this.b) {
                        this.H = true;
                    } else {
                        lVar2.mDeferStart = false;
                        wVar.j();
                    }
                }
            }
        }
        xVar.b.values().removeAll(Collections.singleton(null));
        return O;
    }

    public final boolean O(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        boolean z = (i2 & 1) != 0;
        ArrayList arrayList3 = this.d;
        int i3 = -1;
        if (arrayList3 != null && !arrayList3.isEmpty()) {
            if (i < 0) {
                i3 = z ? 0 : this.d.size() - 1;
            } else {
                int size = this.d.size() - 1;
                while (size >= 0) {
                    a aVar = (a) this.d.get(size);
                    if (i >= 0 && i == aVar.r) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    i3 = size;
                } else if (z) {
                    i3 = size;
                    while (i3 > 0) {
                        a aVar2 = (a) this.d.get(i3 - 1);
                        if (i < 0 || i != aVar2.r) {
                            break;
                        }
                        i3--;
                    }
                } else if (size != this.d.size() - 1) {
                    i3 = size + 1;
                }
            }
        }
        if (i3 < 0) {
            return false;
        }
        for (int size2 = this.d.size() - 1; size2 >= i3; size2--) {
            arrayList.add((a) this.d.remove(size2));
            arrayList2.add(Boolean.TRUE);
        }
        return true;
    }

    public final void P(l lVar) {
        if (G(2)) {
            Log.v("FragmentManager", "remove: " + lVar + " nesting=" + lVar.mBackStackNesting);
        }
        boolean isInBackStack = lVar.isInBackStack();
        if (lVar.mDetached && isInBackStack) {
            return;
        }
        x xVar = this.c;
        synchronized (xVar.a) {
            xVar.a.remove(lVar);
        }
        lVar.mAdded = false;
        if (H(lVar)) {
            this.D = true;
        }
        lVar.mRemoving = true;
        X(lVar);
    }

    public final void Q(ArrayList arrayList, ArrayList arrayList2) {
        if (arrayList.isEmpty()) {
            return;
        }
        if (arrayList.size() != arrayList2.size()) {
            throw new IllegalStateException("Internal error with the back stack records");
        }
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            if (!((a) arrayList.get(i)).o) {
                if (i2 != i) {
                    z(arrayList, arrayList2, i2, i);
                }
                i2 = i + 1;
                if (((Boolean) arrayList2.get(i)).booleanValue()) {
                    while (i2 < size && ((Boolean) arrayList2.get(i2)).booleanValue() && !((a) arrayList.get(i2)).o) {
                        i2++;
                    }
                }
                z(arrayList, arrayList2, i, i2);
                i = i2 - 1;
            }
            i++;
        }
        if (i2 != size) {
            z(arrayList, arrayList2, i2, size);
        }
    }

    public final void R(Parcelable parcelable) {
        int i;
        C0595Wo c0595Wo;
        int i2;
        w wVar;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3 = (Bundle) parcelable;
        for (String str : bundle3.keySet()) {
            if (str.startsWith("result_") && (bundle2 = bundle3.getBundle(str)) != null) {
                bundle2.setClassLoader(this.t.b.getClassLoader());
                this.k.put(str.substring(7), bundle2);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : bundle3.keySet()) {
            if (str2.startsWith("fragment_") && (bundle = bundle3.getBundle(str2)) != null) {
                bundle.setClassLoader(this.t.b.getClassLoader());
                arrayList.add((v) bundle.getParcelable("state"));
            }
        }
        x xVar = this.c;
        HashMap hashMap = xVar.c;
        hashMap.clear();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            v vVar = (v) it.next();
            hashMap.put(vVar.b, vVar);
        }
        C3550lt c3550lt = (C3550lt) bundle3.getParcelable("state");
        if (c3550lt == null) {
            return;
        }
        HashMap hashMap2 = xVar.b;
        hashMap2.clear();
        Iterator it2 = c3550lt.a.iterator();
        while (true) {
            boolean hasNext = it2.hasNext();
            i = 2;
            c0595Wo = this.l;
            if (!hasNext) {
                break;
            }
            v vVar2 = (v) xVar.c.remove((String) it2.next());
            if (vVar2 != null) {
                l lVar = (l) this.L.b.get(vVar2.b);
                if (lVar != null) {
                    if (G(2)) {
                        Log.v("FragmentManager", "restoreSaveState: re-attaching retained " + lVar);
                    }
                    wVar = new w(c0595Wo, xVar, lVar, vVar2);
                } else {
                    wVar = new w(this.l, this.c, this.t.b.getClassLoader(), D(), vVar2);
                }
                l lVar2 = wVar.c;
                lVar2.mFragmentManager = this;
                if (G(2)) {
                    Log.v("FragmentManager", "restoreSaveState: active (" + lVar2.mWho + "): " + lVar2);
                }
                wVar.k(this.t.b.getClassLoader());
                xVar.g(wVar);
                wVar.e = this.s;
            }
        }
        u uVar = this.L;
        uVar.getClass();
        Iterator it3 = new ArrayList(uVar.b.values()).iterator();
        while (it3.hasNext()) {
            l lVar3 = (l) it3.next();
            if (hashMap2.get(lVar3.mWho) == null) {
                if (G(2)) {
                    Log.v("FragmentManager", "Discarding retained Fragment " + lVar3 + " that was not found in the set of active Fragments " + c3550lt.a);
                }
                this.L.f(lVar3);
                lVar3.mFragmentManager = this;
                w wVar2 = new w(c0595Wo, xVar, lVar3);
                wVar2.e = 1;
                wVar2.j();
                lVar3.mRemoving = true;
                wVar2.j();
            }
        }
        ArrayList<String> arrayList2 = c3550lt.b;
        xVar.a.clear();
        if (arrayList2 != null) {
            for (String str3 : arrayList2) {
                l b = xVar.b(str3);
                if (b == null) {
                    throw new IllegalStateException(W50.D("No instantiated fragment for (", str3, ")"));
                }
                if (G(2)) {
                    Log.v("FragmentManager", "restoreSaveState: added (" + str3 + "): " + b);
                }
                xVar.a(b);
            }
        }
        if (c3550lt.c != null) {
            this.d = new ArrayList(c3550lt.c.length);
            int i3 = 0;
            while (true) {
                b[] bVarArr = c3550lt.c;
                if (i3 >= bVarArr.length) {
                    break;
                }
                b bVar = bVarArr[i3];
                bVar.getClass();
                a aVar = new a(this);
                int i4 = 0;
                int i5 = 0;
                while (true) {
                    int[] iArr = bVar.a;
                    if (i4 >= iArr.length) {
                        break;
                    }
                    C4102st c4102st = new C4102st();
                    int i6 = i4 + 1;
                    int i7 = i;
                    c4102st.a = iArr[i4];
                    if (G(i7)) {
                        Log.v("FragmentManager", "Instantiate " + aVar + " op #" + i5 + " base fragment #" + iArr[i6]);
                    }
                    c4102st.h = EnumC4526yB.values()[bVar.c[i5]];
                    c4102st.i = EnumC4526yB.values()[bVar.d[i5]];
                    int i8 = i4 + 2;
                    c4102st.c = iArr[i6] != 0;
                    int i9 = iArr[i8];
                    c4102st.d = i9;
                    int i10 = iArr[i4 + 3];
                    c4102st.e = i10;
                    int i11 = i4 + 5;
                    int i12 = iArr[i4 + 4];
                    c4102st.f = i12;
                    i4 += 6;
                    int i13 = iArr[i11];
                    c4102st.g = i13;
                    aVar.b = i9;
                    aVar.c = i10;
                    aVar.d = i12;
                    aVar.e = i13;
                    aVar.b(c4102st);
                    i5++;
                    i = i7;
                }
                int i14 = i;
                aVar.f = bVar.e;
                aVar.h = bVar.f;
                aVar.g = true;
                aVar.i = bVar.h;
                aVar.j = bVar.i;
                aVar.k = bVar.j;
                aVar.l = bVar.k;
                aVar.m = bVar.l;
                aVar.n = bVar.m;
                aVar.o = bVar.n;
                aVar.r = bVar.g;
                int i15 = 0;
                while (true) {
                    ArrayList arrayList3 = bVar.b;
                    if (i15 >= arrayList3.size()) {
                        break;
                    }
                    String str4 = (String) arrayList3.get(i15);
                    if (str4 != null) {
                        ((C4102st) aVar.a.get(i15)).b = xVar.b(str4);
                    }
                    i15++;
                }
                aVar.d(1);
                if (G(i14)) {
                    StringBuilder w = W50.w(i3, "restoreAllState: back stack #", " (index ");
                    w.append(aVar.r);
                    w.append("): ");
                    w.append(aVar);
                    Log.v("FragmentManager", w.toString());
                    PrintWriter printWriter = new PrintWriter(new C3897qD());
                    aVar.f("  ", printWriter, false);
                    printWriter.close();
                }
                this.d.add(aVar);
                i3++;
                i = i14;
            }
            i2 = 0;
        } else {
            i2 = 0;
            this.d = null;
        }
        this.i.set(c3550lt.d);
        String str5 = c3550lt.e;
        if (str5 != null) {
            l b2 = xVar.b(str5);
            this.w = b2;
            q(b2);
        }
        ArrayList arrayList4 = c3550lt.f;
        if (arrayList4 != null) {
            for (int i16 = i2; i16 < arrayList4.size(); i16++) {
                this.j.put((String) arrayList4.get(i16), (E9) c3550lt.g.get(i16));
            }
        }
        this.C = new ArrayDeque(c3550lt.h);
    }

    public final Bundle S() {
        int i;
        ArrayList arrayList;
        b[] bVarArr;
        int size;
        Bundle bundle = new Bundle();
        Iterator it = e().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            f fVar = (f) it.next();
            if (fVar.e) {
                if (G(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Forcing postponed operations");
                }
                fVar.e = false;
                fVar.d();
            }
        }
        Iterator it2 = e().iterator();
        while (it2.hasNext()) {
            ((f) it2.next()).g();
        }
        x(true);
        this.E = true;
        this.L.g = true;
        x xVar = this.c;
        xVar.getClass();
        HashMap hashMap = xVar.b;
        ArrayList arrayList2 = new ArrayList(hashMap.size());
        for (w wVar : hashMap.values()) {
            if (wVar != null) {
                wVar.m();
                l lVar = wVar.c;
                arrayList2.add(lVar.mWho);
                if (G(2)) {
                    Log.v("FragmentManager", "Saved state of " + lVar + ": " + lVar.mSavedFragmentState);
                }
            }
        }
        x xVar2 = this.c;
        xVar2.getClass();
        ArrayList arrayList3 = new ArrayList(xVar2.c.values());
        if (!arrayList3.isEmpty()) {
            x xVar3 = this.c;
            synchronized (xVar3.a) {
                try {
                    if (xVar3.a.isEmpty()) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList(xVar3.a.size());
                        Iterator it3 = xVar3.a.iterator();
                        while (it3.hasNext()) {
                            l lVar2 = (l) it3.next();
                            arrayList.add(lVar2.mWho);
                            if (G(2)) {
                                Log.v("FragmentManager", "saveAllState: adding fragment (" + lVar2.mWho + "): " + lVar2);
                            }
                        }
                    }
                } finally {
                }
            }
            ArrayList arrayList4 = this.d;
            if (arrayList4 == null || (size = arrayList4.size()) <= 0) {
                bVarArr = null;
            } else {
                bVarArr = new b[size];
                for (i = 0; i < size; i++) {
                    bVarArr[i] = new b((a) this.d.get(i));
                    if (G(2)) {
                        StringBuilder w = W50.w(i, "saveAllState: adding back stack #", ": ");
                        w.append(this.d.get(i));
                        Log.v("FragmentManager", w.toString());
                    }
                }
            }
            C3550lt c3550lt = new C3550lt();
            c3550lt.e = null;
            ArrayList arrayList5 = new ArrayList();
            c3550lt.f = arrayList5;
            ArrayList arrayList6 = new ArrayList();
            c3550lt.g = arrayList6;
            c3550lt.a = arrayList2;
            c3550lt.b = arrayList;
            c3550lt.c = bVarArr;
            c3550lt.d = this.i.get();
            l lVar3 = this.w;
            if (lVar3 != null) {
                c3550lt.e = lVar3.mWho;
            }
            arrayList5.addAll(this.j.keySet());
            arrayList6.addAll(this.j.values());
            c3550lt.h = new ArrayList(this.C);
            bundle.putParcelable("state", c3550lt);
            for (String str : this.k.keySet()) {
                bundle.putBundle(W50.m("result_", str), (Bundle) this.k.get(str));
            }
            Iterator it4 = arrayList3.iterator();
            while (it4.hasNext()) {
                v vVar = (v) it4.next();
                Bundle bundle2 = new Bundle();
                bundle2.putParcelable("state", vVar);
                bundle.putBundle("fragment_" + vVar.b, bundle2);
            }
        } else if (G(2)) {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return bundle;
        }
        return bundle;
    }

    public final void T() {
        synchronized (this.a) {
            try {
                if (this.a.size() == 1) {
                    this.t.c.removeCallbacks(this.M);
                    this.t.c.post(this.M);
                    a0();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void U(l lVar, boolean z) {
        ViewGroup C = C(lVar);
        if (C == null || !(C instanceof FragmentContainerView)) {
            return;
        }
        ((FragmentContainerView) C).setDrawDisappearingViewsLast(!z);
    }

    public final void V(l lVar, EnumC4526yB enumC4526yB) {
        if (lVar.equals(this.c.b(lVar.mWho)) && (lVar.mHost == null || lVar.mFragmentManager == this)) {
            lVar.mMaxState = enumC4526yB;
            return;
        }
        throw new IllegalArgumentException("Fragment " + lVar + " is not an active fragment of FragmentManager " + this);
    }

    public final void W(l lVar) {
        if (lVar != null) {
            if (!lVar.equals(this.c.b(lVar.mWho)) || (lVar.mHost != null && lVar.mFragmentManager != this)) {
                throw new IllegalArgumentException("Fragment " + lVar + " is not an active fragment of FragmentManager " + this);
            }
        }
        l lVar2 = this.w;
        this.w = lVar;
        q(lVar2);
        q(this.w);
    }

    public final void X(l lVar) {
        ViewGroup C = C(lVar);
        if (C != null) {
            if (lVar.getPopExitAnim() + lVar.getPopEnterAnim() + lVar.getExitAnim() + lVar.getEnterAnim() > 0) {
                if (C.getTag(R.id.visible_removing_fragment_view_tag) == null) {
                    C.setTag(R.id.visible_removing_fragment_view_tag, lVar);
                }
                ((l) C.getTag(R.id.visible_removing_fragment_view_tag)).setPopDirection(lVar.getPopDirection());
            }
        }
    }

    public final void Z(IllegalStateException illegalStateException) {
        Log.e("FragmentManager", illegalStateException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C3897qD());
        AbstractC0758at abstractC0758at = this.t;
        if (abstractC0758at == null) {
            try {
                u("  ", null, printWriter, new String[0]);
                throw illegalStateException;
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
                throw illegalStateException;
            }
        }
        try {
            ((p) abstractC0758at).e.dump("  ", null, printWriter, new String[0]);
            throw illegalStateException;
        } catch (Exception e2) {
            Log.e("FragmentManager", "Failed dumping state", e2);
            throw illegalStateException;
        }
    }

    public final w a(l lVar) {
        String str = lVar.mPreviousWho;
        if (str != null) {
            AbstractC4023rt.c(lVar, str);
        }
        if (G(2)) {
            Log.v("FragmentManager", "add: " + lVar);
        }
        w f = f(lVar);
        lVar.mFragmentManager = this;
        x xVar = this.c;
        xVar.g(f);
        if (!lVar.mDetached) {
            xVar.a(lVar);
            lVar.mRemoving = false;
            if (lVar.mView == null) {
                lVar.mHiddenChanged = false;
            }
            if (H(lVar)) {
                this.D = true;
            }
        }
        return f;
    }

    public final void a0() {
        synchronized (this.a) {
            try {
                if (!this.a.isEmpty()) {
                    this.h.setEnabled(true);
                    return;
                }
                C2833ct c2833ct = this.h;
                ArrayList arrayList = this.d;
                c2833ct.setEnabled((arrayList != null ? arrayList.size() : 0) > 0 && J(this.v));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(AbstractC0758at abstractC0758at, AbstractC0651Ys abstractC0651Ys, l lVar) {
        if (this.t != null) {
            throw new IllegalStateException("Already attached");
        }
        this.t = abstractC0758at;
        this.u = abstractC0651Ys;
        this.v = lVar;
        CopyOnWriteArrayList copyOnWriteArrayList = this.m;
        if (lVar != null) {
            copyOnWriteArrayList.add(new C3072ft(lVar));
        } else if (abstractC0758at instanceof InterfaceC3708nt) {
            copyOnWriteArrayList.add((InterfaceC3708nt) abstractC0758at);
        }
        if (this.v != null) {
            a0();
        }
        if (abstractC0758at instanceof YI) {
            YI yi = (YI) abstractC0758at;
            XI onBackPressedDispatcher = yi.getOnBackPressedDispatcher();
            this.g = onBackPressedDispatcher;
            EB eb = yi;
            if (lVar != null) {
                eb = lVar;
            }
            onBackPressedDispatcher.a(eb, this.h);
        }
        if (lVar != null) {
            u uVar = lVar.mFragmentManager.L;
            HashMap hashMap = uVar.c;
            u uVar2 = (u) hashMap.get(lVar.mWho);
            if (uVar2 == null) {
                uVar2 = new u(uVar.e);
                hashMap.put(lVar.mWho, uVar2);
            }
            this.L = uVar2;
        } else if (abstractC0758at instanceof InterfaceC4115t20) {
            this.L = (u) new C2835cv(((InterfaceC4115t20) abstractC0758at).getViewModelStore(), u.h).n(u.class);
        } else {
            this.L = new u(false);
        }
        u uVar3 = this.L;
        uVar3.g = this.E || this.F;
        this.c.d = uVar3;
        Object obj = this.t;
        if ((obj instanceof InterfaceC3910qQ) && lVar == null) {
            C3673nQ savedStateRegistry = ((InterfaceC3910qQ) obj).getSavedStateRegistry();
            savedStateRegistry.c("android:support:fragments", new C3374jf(this, 1));
            Bundle a = savedStateRegistry.a("android:support:fragments");
            if (a != null) {
                R(a);
            }
        }
        Object obj2 = this.t;
        if (obj2 instanceof H1) {
            G1 activityResultRegistry = ((H1) obj2).getActivityResultRegistry();
            String m = W50.m("FragmentManager:", lVar != null ? W50.q(lVar.mWho, ":", new StringBuilder()) : "");
            this.z = activityResultRegistry.c(W50.C(m, "StartActivityForResult"), new C4586z1(2), new C2882dV(this, 17));
            this.A = activityResultRegistry.c(W50.C(m, "StartIntentSenderForResult"), new C4586z1(3), new C2835cv(this, 19));
            this.B = activityResultRegistry.c(W50.C(m, "RequestPermissions"), new C4586z1(0), new C0136Ew(this, 19));
        }
        Object obj3 = this.t;
        if (obj3 instanceof InterfaceC0874cJ) {
            ((InterfaceC0874cJ) obj3).addOnConfigurationChangedListener(this.n);
        }
        Object obj4 = this.t;
        if (obj4 instanceof InterfaceC3587mJ) {
            ((InterfaceC3587mJ) obj4).addOnTrimMemoryListener(this.o);
        }
        Object obj5 = this.t;
        if (obj5 instanceof InterfaceC3189hJ) {
            ((InterfaceC3189hJ) obj5).addOnMultiWindowModeChangedListener(this.p);
        }
        Object obj6 = this.t;
        if (obj6 instanceof InterfaceC3269iJ) {
            ((InterfaceC3269iJ) obj6).addOnPictureInPictureModeChangedListener(this.q);
        }
        Object obj7 = this.t;
        if ((obj7 instanceof InterfaceC3105gF) && lVar == null) {
            ((InterfaceC3105gF) obj7).addMenuProvider(this.r);
        }
    }

    public final void c(l lVar) {
        if (G(2)) {
            Log.v("FragmentManager", "attach: " + lVar);
        }
        if (lVar.mDetached) {
            lVar.mDetached = false;
            if (lVar.mAdded) {
                return;
            }
            this.c.a(lVar);
            if (G(2)) {
                Log.v("FragmentManager", "add from attach: " + lVar);
            }
            if (H(lVar)) {
                this.D = true;
            }
        }
    }

    public final void d() {
        this.b = false;
        this.J.clear();
        this.I.clear();
    }

    public final HashSet e() {
        HashSet hashSet = new HashSet();
        Iterator it = this.c.d().iterator();
        while (it.hasNext()) {
            ViewGroup viewGroup = ((w) it.next()).c.mContainer;
            if (viewGroup != null) {
                hashSet.add(f.h(viewGroup, E()));
            }
        }
        return hashSet;
    }

    public final w f(l lVar) {
        String str = lVar.mWho;
        x xVar = this.c;
        w wVar = (w) xVar.b.get(str);
        if (wVar != null) {
            return wVar;
        }
        w wVar2 = new w(this.l, xVar, lVar);
        wVar2.k(this.t.b.getClassLoader());
        wVar2.e = this.s;
        return wVar2;
    }

    public final void g(l lVar) {
        if (G(2)) {
            Log.v("FragmentManager", "detach: " + lVar);
        }
        if (lVar.mDetached) {
            return;
        }
        lVar.mDetached = true;
        if (lVar.mAdded) {
            if (G(2)) {
                Log.v("FragmentManager", "remove from detach: " + lVar);
            }
            x xVar = this.c;
            synchronized (xVar.a) {
                xVar.a.remove(lVar);
            }
            lVar.mAdded = false;
            if (H(lVar)) {
                this.D = true;
            }
            X(lVar);
        }
    }

    public final void h(boolean z, Configuration configuration) {
        if (z && (this.t instanceof InterfaceC0874cJ)) {
            Z(new IllegalStateException("Do not call dispatchConfigurationChanged() on host. Host implements OnConfigurationChangedProvider and automatically dispatches configuration changes to fragments."));
            throw null;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null) {
                lVar.performConfigurationChanged(configuration);
                if (z) {
                    lVar.mChildFragmentManager.h(true, configuration);
                }
            }
        }
    }

    public final boolean i(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null && lVar.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final boolean j(Menu menu, MenuInflater menuInflater) {
        if (this.s < 1) {
            return false;
        }
        ArrayList arrayList = null;
        boolean z = false;
        for (l lVar : this.c.f()) {
            if (lVar != null && lVar.isMenuVisible() && lVar.performCreateOptionsMenu(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(lVar);
                z = true;
            }
        }
        if (this.e != null) {
            for (int i = 0; i < this.e.size(); i++) {
                l lVar2 = (l) this.e.get(i);
                if (arrayList == null || !arrayList.contains(lVar2)) {
                    lVar2.onDestroyOptionsMenu();
                }
            }
        }
        this.e = arrayList;
        return z;
    }

    public final void k() {
        boolean z = true;
        this.G = true;
        x(true);
        Iterator it = e().iterator();
        while (it.hasNext()) {
            ((f) it.next()).g();
        }
        AbstractC0758at abstractC0758at = this.t;
        boolean z2 = abstractC0758at instanceof InterfaceC4115t20;
        x xVar = this.c;
        if (z2) {
            z = xVar.d.f;
        } else {
            q qVar = abstractC0758at.b;
            if (qVar != null) {
                z = true ^ qVar.isChangingConfigurations();
            }
        }
        if (z) {
            Iterator it2 = this.j.values().iterator();
            while (it2.hasNext()) {
                for (String str : ((E9) it2.next()).a) {
                    u uVar = xVar.d;
                    uVar.getClass();
                    if (G(3)) {
                        Log.d("FragmentManager", "Clearing non-config state for saved state of Fragment " + str);
                    }
                    uVar.e(str);
                }
            }
        }
        t(-1);
        Object obj = this.t;
        if (obj instanceof InterfaceC3587mJ) {
            ((InterfaceC3587mJ) obj).removeOnTrimMemoryListener(this.o);
        }
        Object obj2 = this.t;
        if (obj2 instanceof InterfaceC0874cJ) {
            ((InterfaceC0874cJ) obj2).removeOnConfigurationChangedListener(this.n);
        }
        Object obj3 = this.t;
        if (obj3 instanceof InterfaceC3189hJ) {
            ((InterfaceC3189hJ) obj3).removeOnMultiWindowModeChangedListener(this.p);
        }
        Object obj4 = this.t;
        if (obj4 instanceof InterfaceC3269iJ) {
            ((InterfaceC3269iJ) obj4).removeOnPictureInPictureModeChangedListener(this.q);
        }
        Object obj5 = this.t;
        if (obj5 instanceof InterfaceC3105gF) {
            ((InterfaceC3105gF) obj5).removeMenuProvider(this.r);
        }
        this.t = null;
        this.u = null;
        this.v = null;
        if (this.g != null) {
            this.h.remove();
            this.g = null;
        }
        F1 f1 = this.z;
        if (f1 != null) {
            f1.b();
            this.A.b();
            this.B.b();
        }
    }

    public final void l(boolean z) {
        if (z && (this.t instanceof InterfaceC3587mJ)) {
            Z(new IllegalStateException("Do not call dispatchLowMemory() on host. Host implements OnTrimMemoryProvider and automatically dispatches low memory callbacks to fragments."));
            throw null;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null) {
                lVar.performLowMemory();
                if (z) {
                    lVar.mChildFragmentManager.l(true);
                }
            }
        }
    }

    public final void m(boolean z, boolean z2) {
        if (z2 && (this.t instanceof InterfaceC3189hJ)) {
            Z(new IllegalStateException("Do not call dispatchMultiWindowModeChanged() on host. Host implements OnMultiWindowModeChangedProvider and automatically dispatches multi-window mode changes to fragments."));
            throw null;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null) {
                lVar.performMultiWindowModeChanged(z);
                if (z2) {
                    lVar.mChildFragmentManager.m(z, true);
                }
            }
        }
    }

    public final void n() {
        Iterator it = this.c.e().iterator();
        while (it.hasNext()) {
            l lVar = (l) it.next();
            if (lVar != null) {
                lVar.onHiddenChanged(lVar.isHidden());
                lVar.mChildFragmentManager.n();
            }
        }
    }

    public final boolean o(MenuItem menuItem) {
        if (this.s < 1) {
            return false;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null && lVar.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public final void p(Menu menu) {
        if (this.s < 1) {
            return;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null) {
                lVar.performOptionsMenuClosed(menu);
            }
        }
    }

    public final void q(l lVar) {
        if (lVar != null) {
            if (lVar.equals(this.c.b(lVar.mWho))) {
                lVar.performPrimaryNavigationFragmentChanged();
            }
        }
    }

    public final void r(boolean z, boolean z2) {
        if (z2 && (this.t instanceof InterfaceC3269iJ)) {
            Z(new IllegalStateException("Do not call dispatchPictureInPictureModeChanged() on host. Host implements OnPictureInPictureModeChangedProvider and automatically dispatches picture-in-picture mode changes to fragments."));
            throw null;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null) {
                lVar.performPictureInPictureModeChanged(z);
                if (z2) {
                    lVar.mChildFragmentManager.r(z, true);
                }
            }
        }
    }

    public final boolean s(Menu menu) {
        boolean z = false;
        if (this.s < 1) {
            return false;
        }
        for (l lVar : this.c.f()) {
            if (lVar != null && lVar.isMenuVisible() && lVar.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public final void t(int i) {
        try {
            this.b = true;
            for (w wVar : this.c.b.values()) {
                if (wVar != null) {
                    wVar.e = i;
                }
            }
            K(i, false);
            Iterator it = e().iterator();
            while (it.hasNext()) {
                ((f) it.next()).g();
            }
            this.b = false;
            x(true);
        } catch (Throwable th) {
            this.b = false;
            throw th;
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(UserVerificationMethods.USER_VERIFY_PATTERN);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        l lVar = this.v;
        if (lVar != null) {
            sb.append(lVar.getClass().getSimpleName());
            sb.append("{");
            sb.append(Integer.toHexString(System.identityHashCode(this.v)));
            sb.append("}");
        } else {
            AbstractC0758at abstractC0758at = this.t;
            if (abstractC0758at != null) {
                sb.append(abstractC0758at.getClass().getSimpleName());
                sb.append("{");
                sb.append(Integer.toHexString(System.identityHashCode(this.t)));
                sb.append("}");
            } else {
                sb.append("null");
            }
        }
        sb.append("}}");
        return sb.toString();
    }

    public final void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        String C = W50.C(str, "    ");
        x xVar = this.c;
        xVar.getClass();
        String str2 = str + "    ";
        HashMap hashMap = xVar.b;
        if (!hashMap.isEmpty()) {
            printWriter.print(str);
            printWriter.println("Active Fragments:");
            for (w wVar : hashMap.values()) {
                printWriter.print(str);
                if (wVar != null) {
                    l lVar = wVar.c;
                    printWriter.println(lVar);
                    lVar.dump(str2, fileDescriptor, printWriter, strArr);
                } else {
                    printWriter.println("null");
                }
            }
        }
        ArrayList arrayList = xVar.a;
        int size3 = arrayList.size();
        if (size3 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i = 0; i < size3; i++) {
                l lVar2 = (l) arrayList.get(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(lVar2.toString());
            }
        }
        ArrayList arrayList2 = this.e;
        if (arrayList2 != null && (size2 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i2 = 0; i2 < size2; i2++) {
                l lVar3 = (l) this.e.get(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(lVar3.toString());
            }
        }
        ArrayList arrayList3 = this.d;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i3 = 0; i3 < size; i3++) {
                a aVar = (a) this.d.get(i3);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.f(C, printWriter, true);
            }
        }
        printWriter.print(str);
        printWriter.println("Back Stack Index: " + this.i.get());
        synchronized (this.a) {
            try {
                int size4 = this.a.size();
                if (size4 > 0) {
                    printWriter.print(str);
                    printWriter.println("Pending Actions:");
                    for (int i4 = 0; i4 < size4; i4++) {
                        Object obj = (InterfaceC3232ht) this.a.get(i4);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i4);
                        printWriter.print(": ");
                        printWriter.println(obj);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.t);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.u);
        if (this.v != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.v);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.s);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.E);
        printWriter.print(" mStopped=");
        printWriter.print(this.F);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.G);
        if (this.D) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.D);
        }
    }

    public final void v(InterfaceC3232ht interfaceC3232ht, boolean z) {
        if (!z) {
            if (this.t == null) {
                if (!this.G) {
                    throw new IllegalStateException("FragmentManager has not been attached to a host.");
                }
                throw new IllegalStateException("FragmentManager has been destroyed");
            }
            if (this.E || this.F) {
                throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
            }
        }
        synchronized (this.a) {
            try {
                if (this.t == null) {
                    if (!z) {
                        throw new IllegalStateException("Activity has been destroyed");
                    }
                } else {
                    this.a.add(interfaceC3232ht);
                    T();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void w(boolean z) {
        if (this.b) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        }
        if (this.t == null) {
            if (!this.G) {
                throw new IllegalStateException("FragmentManager has not been attached to a host.");
            }
            throw new IllegalStateException("FragmentManager has been destroyed");
        }
        if (Looper.myLooper() != this.t.c.getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        }
        if (!z && (this.E || this.F)) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        if (this.I == null) {
            this.I = new ArrayList();
            this.J = new ArrayList();
        }
    }

    public final boolean x(boolean z) {
        boolean z2;
        w(z);
        boolean z3 = false;
        while (true) {
            ArrayList arrayList = this.I;
            ArrayList arrayList2 = this.J;
            synchronized (this.a) {
                if (this.a.isEmpty()) {
                    z2 = false;
                } else {
                    try {
                        int size = this.a.size();
                        z2 = false;
                        for (int i = 0; i < size; i++) {
                            z2 |= ((InterfaceC3232ht) this.a.get(i)).a(arrayList, arrayList2);
                        }
                    } finally {
                    }
                }
            }
            if (!z2) {
                break;
            }
            this.b = true;
            try {
                Q(this.I, this.J);
                d();
                z3 = true;
            } catch (Throwable th) {
                d();
                throw th;
            }
        }
        a0();
        if (this.H) {
            this.H = false;
            Iterator it = this.c.d().iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                l lVar = wVar.c;
                if (lVar.mDeferStart) {
                    if (this.b) {
                        this.H = true;
                    } else {
                        lVar.mDeferStart = false;
                        wVar.j();
                    }
                }
            }
        }
        this.c.b.values().removeAll(Collections.singleton(null));
        return z3;
    }

    public final void y(a aVar, boolean z) {
        if (z && (this.t == null || this.G)) {
            return;
        }
        w(z);
        aVar.a(this.I, this.J);
        this.b = true;
        try {
            Q(this.I, this.J);
            d();
            a0();
            boolean z2 = this.H;
            x xVar = this.c;
            if (z2) {
                this.H = false;
                Iterator it = xVar.d().iterator();
                while (it.hasNext()) {
                    w wVar = (w) it.next();
                    l lVar = wVar.c;
                    if (lVar.mDeferStart) {
                        if (this.b) {
                            this.H = true;
                        } else {
                            lVar.mDeferStart = false;
                            wVar.j();
                        }
                    }
                }
            }
            xVar.b.values().removeAll(Collections.singleton(null));
        } catch (Throwable th) {
            d();
            throw th;
        }
    }

    public final void z(ArrayList arrayList, ArrayList arrayList2, int i, int i2) {
        ViewGroup viewGroup;
        boolean z;
        int i3;
        boolean z2;
        boolean z3;
        int i4;
        int i5;
        boolean z4;
        boolean z5;
        int i6;
        boolean z6 = ((a) arrayList.get(i)).o;
        ArrayList arrayList3 = this.K;
        if (arrayList3 == null) {
            this.K = new ArrayList();
        } else {
            arrayList3.clear();
        }
        ArrayList arrayList4 = this.K;
        x xVar = this.c;
        arrayList4.addAll(xVar.f());
        l lVar = this.w;
        int i7 = i;
        boolean z7 = false;
        while (true) {
            int i8 = 1;
            if (i7 >= i2) {
                boolean z8 = z6;
                this.K.clear();
                if (!z8 && this.s >= 1) {
                    for (int i9 = i; i9 < i2; i9++) {
                        Iterator it = ((a) arrayList.get(i9)).a.iterator();
                        while (it.hasNext()) {
                            l lVar2 = ((C4102st) it.next()).b;
                            if (lVar2 != null && lVar2.mFragmentManager != null) {
                                xVar.g(f(lVar2));
                            }
                        }
                    }
                }
                for (int i10 = i; i10 < i2; i10++) {
                    a aVar = (a) arrayList.get(i10);
                    if (((Boolean) arrayList2.get(i10)).booleanValue()) {
                        aVar.d(-1);
                        ArrayList arrayList5 = aVar.a;
                        boolean z9 = true;
                        for (int size = arrayList5.size() - 1; size >= 0; size--) {
                            C4102st c4102st = (C4102st) arrayList5.get(size);
                            l lVar3 = c4102st.b;
                            if (lVar3 != null) {
                                lVar3.mBeingSaved = false;
                                lVar3.setPopDirection(z9);
                                int i11 = aVar.f;
                                int i12 = 8194;
                                int i13 = 4097;
                                if (i11 != 4097) {
                                    if (i11 != 8194) {
                                        i12 = 4100;
                                        i13 = 8197;
                                        if (i11 != 8197) {
                                            if (i11 == 4099) {
                                                i12 = 4099;
                                            } else if (i11 != 4100) {
                                                i12 = 0;
                                            }
                                        }
                                    }
                                    i12 = i13;
                                }
                                lVar3.setNextTransition(i12);
                                lVar3.setSharedElementNames(aVar.n, aVar.m);
                            }
                            int i14 = c4102st.a;
                            t tVar = aVar.p;
                            switch (i14) {
                                case 1:
                                    lVar3.setAnimations(c4102st.d, c4102st.e, c4102st.f, c4102st.g);
                                    z9 = true;
                                    tVar.U(lVar3, true);
                                    tVar.P(lVar3);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + c4102st.a);
                                case 3:
                                    lVar3.setAnimations(c4102st.d, c4102st.e, c4102st.f, c4102st.g);
                                    tVar.a(lVar3);
                                    z9 = true;
                                case 4:
                                    lVar3.setAnimations(c4102st.d, c4102st.e, c4102st.f, c4102st.g);
                                    tVar.getClass();
                                    Y(lVar3);
                                    z9 = true;
                                case 5:
                                    lVar3.setAnimations(c4102st.d, c4102st.e, c4102st.f, c4102st.g);
                                    tVar.U(lVar3, true);
                                    tVar.F(lVar3);
                                    z9 = true;
                                case 6:
                                    lVar3.setAnimations(c4102st.d, c4102st.e, c4102st.f, c4102st.g);
                                    tVar.c(lVar3);
                                    z9 = true;
                                case 7:
                                    lVar3.setAnimations(c4102st.d, c4102st.e, c4102st.f, c4102st.g);
                                    tVar.U(lVar3, true);
                                    tVar.g(lVar3);
                                    z9 = true;
                                case 8:
                                    tVar.W(null);
                                    z9 = true;
                                case 9:
                                    tVar.W(lVar3);
                                    z9 = true;
                                case 10:
                                    tVar.V(lVar3, c4102st.h);
                                    z9 = true;
                            }
                        }
                    } else {
                        aVar.d(1);
                        ArrayList arrayList6 = aVar.a;
                        int size2 = arrayList6.size();
                        for (int i15 = 0; i15 < size2; i15++) {
                            C4102st c4102st2 = (C4102st) arrayList6.get(i15);
                            l lVar4 = c4102st2.b;
                            if (lVar4 != null) {
                                lVar4.mBeingSaved = false;
                                lVar4.setPopDirection(false);
                                lVar4.setNextTransition(aVar.f);
                                lVar4.setSharedElementNames(aVar.m, aVar.n);
                            }
                            int i16 = c4102st2.a;
                            t tVar2 = aVar.p;
                            switch (i16) {
                                case 1:
                                    lVar4.setAnimations(c4102st2.d, c4102st2.e, c4102st2.f, c4102st2.g);
                                    tVar2.U(lVar4, false);
                                    tVar2.a(lVar4);
                                case 2:
                                default:
                                    throw new IllegalArgumentException("Unknown cmd: " + c4102st2.a);
                                case 3:
                                    lVar4.setAnimations(c4102st2.d, c4102st2.e, c4102st2.f, c4102st2.g);
                                    tVar2.P(lVar4);
                                case 4:
                                    lVar4.setAnimations(c4102st2.d, c4102st2.e, c4102st2.f, c4102st2.g);
                                    tVar2.F(lVar4);
                                case 5:
                                    lVar4.setAnimations(c4102st2.d, c4102st2.e, c4102st2.f, c4102st2.g);
                                    tVar2.U(lVar4, false);
                                    Y(lVar4);
                                case 6:
                                    lVar4.setAnimations(c4102st2.d, c4102st2.e, c4102st2.f, c4102st2.g);
                                    tVar2.g(lVar4);
                                case 7:
                                    lVar4.setAnimations(c4102st2.d, c4102st2.e, c4102st2.f, c4102st2.g);
                                    tVar2.U(lVar4, false);
                                    tVar2.c(lVar4);
                                case 8:
                                    tVar2.W(lVar4);
                                case 9:
                                    tVar2.W(null);
                                case 10:
                                    tVar2.V(lVar4, c4102st2.i);
                            }
                        }
                    }
                }
                boolean booleanValue = ((Boolean) arrayList2.get(i2 - 1)).booleanValue();
                for (int i17 = i; i17 < i2; i17++) {
                    a aVar2 = (a) arrayList.get(i17);
                    if (booleanValue) {
                        for (int size3 = aVar2.a.size() - 1; size3 >= 0; size3--) {
                            l lVar5 = ((C4102st) aVar2.a.get(size3)).b;
                            if (lVar5 != null) {
                                f(lVar5).j();
                            }
                        }
                    } else {
                        Iterator it2 = aVar2.a.iterator();
                        while (it2.hasNext()) {
                            l lVar6 = ((C4102st) it2.next()).b;
                            if (lVar6 != null) {
                                f(lVar6).j();
                            }
                        }
                    }
                }
                K(this.s, true);
                HashSet hashSet = new HashSet();
                for (int i18 = i; i18 < i2; i18++) {
                    Iterator it3 = ((a) arrayList.get(i18)).a.iterator();
                    while (it3.hasNext()) {
                        l lVar7 = ((C4102st) it3.next()).b;
                        if (lVar7 != null && (viewGroup = lVar7.mContainer) != null) {
                            hashSet.add(f.h(viewGroup, E()));
                        }
                    }
                }
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    f fVar = (f) it4.next();
                    fVar.d = booleanValue;
                    fVar.j();
                    fVar.d();
                }
                for (int i19 = i; i19 < i2; i19++) {
                    a aVar3 = (a) arrayList.get(i19);
                    if (((Boolean) arrayList2.get(i19)).booleanValue() && aVar3.r >= 0) {
                        aVar3.r = -1;
                    }
                    aVar3.getClass();
                }
                return;
            }
            a aVar4 = (a) arrayList.get(i7);
            if (((Boolean) arrayList2.get(i7)).booleanValue()) {
                z = z6;
                i3 = i7;
                z2 = z7;
                int i20 = 1;
                ArrayList arrayList7 = this.K;
                ArrayList arrayList8 = aVar4.a;
                int size4 = arrayList8.size() - 1;
                while (size4 >= 0) {
                    C4102st c4102st3 = (C4102st) arrayList8.get(size4);
                    int i21 = c4102st3.a;
                    if (i21 != i20) {
                        if (i21 != 3) {
                            switch (i21) {
                                case 8:
                                    lVar = null;
                                    break;
                                case 9:
                                    lVar = c4102st3.b;
                                    break;
                                case 10:
                                    c4102st3.i = c4102st3.h;
                                    break;
                            }
                            size4--;
                            i20 = 1;
                        }
                        arrayList7.add(c4102st3.b);
                        size4--;
                        i20 = 1;
                    }
                    arrayList7.remove(c4102st3.b);
                    size4--;
                    i20 = 1;
                }
            } else {
                ArrayList arrayList9 = this.K;
                int i22 = 0;
                while (true) {
                    ArrayList arrayList10 = aVar4.a;
                    if (i22 < arrayList10.size()) {
                        C4102st c4102st4 = (C4102st) arrayList10.get(i22);
                        int i23 = c4102st4.a;
                        if (i23 != i8) {
                            z3 = z6;
                            if (i23 != 2) {
                                if (i23 == 3 || i23 == 6) {
                                    arrayList9.remove(c4102st4.b);
                                    l lVar8 = c4102st4.b;
                                    if (lVar8 == lVar) {
                                        arrayList10.add(i22, new C4102st(lVar8, 9));
                                        i22++;
                                        i5 = i7;
                                        z4 = z7;
                                        i4 = 1;
                                        lVar = null;
                                    }
                                } else if (i23 == 7) {
                                    i4 = 1;
                                } else if (i23 == 8) {
                                    arrayList10.add(i22, new C4102st(lVar, 9, 0));
                                    c4102st4.c = true;
                                    i22++;
                                    lVar = c4102st4.b;
                                }
                                i5 = i7;
                                z4 = z7;
                                i4 = 1;
                            } else {
                                l lVar9 = c4102st4.b;
                                int i24 = lVar9.mContainerId;
                                int size5 = arrayList9.size() - 1;
                                boolean z10 = false;
                                while (size5 >= 0) {
                                    int i25 = size5;
                                    l lVar10 = (l) arrayList9.get(size5);
                                    int i26 = i7;
                                    if (lVar10.mContainerId != i24) {
                                        z5 = z7;
                                    } else if (lVar10 == lVar9) {
                                        z5 = z7;
                                        z10 = true;
                                    } else {
                                        if (lVar10 == lVar) {
                                            z5 = z7;
                                            i6 = 0;
                                            arrayList10.add(i22, new C4102st(lVar10, 9, 0));
                                            i22++;
                                            lVar = null;
                                        } else {
                                            z5 = z7;
                                            i6 = 0;
                                        }
                                        C4102st c4102st5 = new C4102st(lVar10, 3, i6);
                                        c4102st5.d = c4102st4.d;
                                        c4102st5.f = c4102st4.f;
                                        c4102st5.e = c4102st4.e;
                                        c4102st5.g = c4102st4.g;
                                        arrayList10.add(i22, c4102st5);
                                        arrayList9.remove(lVar10);
                                        i22++;
                                        lVar = lVar;
                                    }
                                    size5 = i25 - 1;
                                    z7 = z5;
                                    i7 = i26;
                                }
                                i5 = i7;
                                z4 = z7;
                                i4 = 1;
                                if (z10) {
                                    arrayList10.remove(i22);
                                    i22--;
                                } else {
                                    c4102st4.a = 1;
                                    c4102st4.c = true;
                                    arrayList9.add(lVar9);
                                }
                            }
                            i22 += i4;
                            i8 = i4;
                            z6 = z3;
                            z7 = z4;
                            i7 = i5;
                        } else {
                            z3 = z6;
                            i4 = i8;
                        }
                        i5 = i7;
                        z4 = z7;
                        arrayList9.add(c4102st4.b);
                        i22 += i4;
                        i8 = i4;
                        z6 = z3;
                        z7 = z4;
                        i7 = i5;
                    } else {
                        z = z6;
                        i3 = i7;
                        z2 = z7;
                    }
                }
            }
            z7 = z2 || aVar4.g;
            i7 = i3 + 1;
            z6 = z;
        }
    }
}
