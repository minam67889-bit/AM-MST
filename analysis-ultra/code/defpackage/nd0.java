package defpackage;

import androidx.appcompat.widget.SearchView;
import com.v2ray.ang.adapter.ServerAdapter;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.viewmodel.ServerList;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.text.g;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final class nd0 implements SearchView.OnQueryTextListener {
    public final /* synthetic */ ArrayList a;
    public final /* synthetic */ ServerAdapter b;

    public nd0(HomeFragment homeFragment, ArrayList arrayList, ServerAdapter serverAdapter) {
        this.a = arrayList;
        this.b = serverAdapter;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        ArrayList arrayList;
        int i = HomeFragment.f2;
        ArrayList arrayList2 = this.a;
        if (str != null && !g.B(str)) {
            ArrayList arrayList3 = new ArrayList();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (g.o(((ServerList) next).getName(), str, true)) {
                    arrayList3.add(next);
                }
            }
            arrayList = new ArrayList(arrayList3);
        } else {
            arrayList = new ArrayList(arrayList2);
        }
        this.b.h.b(arrayList);
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        return false;
    }
}
