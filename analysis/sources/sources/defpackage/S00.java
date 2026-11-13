package defpackage;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import app.vpn.amtunnellite.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class S00 {
    public static final ArrayList d = new ArrayList();
    public WeakHashMap a;
    public SparseArray b;
    public WeakReference c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final View a(View view) {
        int size;
        WeakHashMap weakHashMap = this.a;
        if (weakHashMap != null && weakHashMap.containsKey(view)) {
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
            if (arrayList != null && arrayList.size() - 1 >= 0) {
                AbstractC4575vQ.B(arrayList.get(size));
                throw null;
            }
        }
        return null;
    }
}
