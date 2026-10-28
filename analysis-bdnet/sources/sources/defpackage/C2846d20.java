package defpackage;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import dastan.prince.bdfreevpn.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* renamed from: d20, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C2846d20 {
    public static final ArrayList d = new ArrayList();
    public WeakHashMap a;
    public SparseArray b;
    public WeakReference c;

    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.a;
        if (weakHashMap == null || !weakHashMap.containsKey(view)) {
            return null;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View a = a(viewGroup.getChildAt(childCount));
                if (a != null) {
                    return a;
                }
            }
        }
        ArrayList arrayList = (ArrayList) view.getTag(R.id.tag_unhandled_key_listeners);
        if (arrayList == null || arrayList.size() - 1 < 0) {
            return null;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }
}
