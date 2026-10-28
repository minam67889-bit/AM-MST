package defpackage;

import android.view.ViewGroup;
import dastan.prince.bdfreevpn.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class XX {
    public static final Z7 a;
    public static final ThreadLocal b;
    public static final ArrayList c;

    static {
        Z7 z7 = new Z7();
        z7.C = false;
        z7.J(new C0492Sp(2));
        z7.J(new C0064Cc());
        z7.J(new C0492Sp(1));
        a = z7;
        b = new ThreadLocal();
        c = new ArrayList();
    }

    public static void a(ViewGroup viewGroup, TX tx) {
        ArrayList arrayList = c;
        if (arrayList.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        arrayList.add(viewGroup);
        if (tx == null) {
            tx = a;
        }
        TX clone = tx.clone();
        ArrayList arrayList2 = (ArrayList) b().get(viewGroup);
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                ((TX) it.next()).w(viewGroup);
            }
        }
        clone.h(viewGroup, true);
        if (viewGroup.getTag(R.id.transition_current_scene) != null) {
            throw new ClassCastException();
        }
        viewGroup.setTag(R.id.transition_current_scene, null);
        WX wx = new WX();
        wx.a = clone;
        wx.b = viewGroup;
        viewGroup.addOnAttachStateChangeListener(wx);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(wx);
    }

    public static C6 b() {
        C6 c6;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (c6 = (C6) weakReference.get()) != null) {
            return c6;
        }
        C6 c62 = new C6(0);
        threadLocal.set(new WeakReference(c62));
        return c62;
    }
}
