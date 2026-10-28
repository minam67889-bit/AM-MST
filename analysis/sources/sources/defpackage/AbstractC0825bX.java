package defpackage;

import android.view.ViewGroup;
import app.vpn.amtunnellite.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: bX, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0825bX {
    public static final J7 a;
    public static final ThreadLocal b;
    public static final ArrayList c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        J7 j7 = new J7();
        j7.C = false;
        j7.J(new C4758xp(2));
        j7.J(new C3974nc());
        j7.J(new C4758xp(1));
        a = j7;
        b = new ThreadLocal();
        c = new ArrayList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(ViewGroup viewGroup, XW xw) {
        ArrayList arrayList = c;
        if (!arrayList.contains(viewGroup) && viewGroup.isLaidOut()) {
            arrayList.add(viewGroup);
            if (xw == null) {
                xw = a;
            }
            XW clone = xw.clone();
            ArrayList arrayList2 = (ArrayList) b().get(viewGroup);
            if (arrayList2 != null && arrayList2.size() > 0) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((XW) it.next()).w(viewGroup);
                }
            }
            clone.h(viewGroup, true);
            AbstractC4575vQ.B(viewGroup.getTag(R.id.transition_current_scene));
            viewGroup.setTag(R.id.transition_current_scene, null);
            ViewTreeObserverOnPreDrawListenerC0736aX viewTreeObserverOnPreDrawListenerC0736aX = new ViewTreeObserverOnPreDrawListenerC0736aX();
            viewTreeObserverOnPreDrawListenerC0736aX.a = clone;
            viewTreeObserverOnPreDrawListenerC0736aX.b = viewGroup;
            viewGroup.addOnAttachStateChangeListener(viewTreeObserverOnPreDrawListenerC0736aX);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(viewTreeObserverOnPreDrawListenerC0736aX);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C3705k6 b() {
        C3705k6 c3705k6;
        ThreadLocal threadLocal = b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (c3705k6 = (C3705k6) weakReference.get()) != null) {
            return c3705k6;
        }
        C3705k6 c3705k62 = new C3705k6();
        threadLocal.set(new WeakReference(c3705k62));
        return c3705k62;
    }
}
