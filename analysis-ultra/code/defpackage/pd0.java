package defpackage;

import androidx.appcompat.widget.SearchView;
import com.v2ray.ang.adapter.NetworkAdapter;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.viewmodel.NetworkList;
import java.util.ArrayList;
import java.util.List;
import kotlin.text.g;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final class pd0 implements SearchView.OnQueryTextListener {
    public final /* synthetic */ HomeFragment a;
    public final /* synthetic */ NetworkAdapter b;

    public pd0(HomeFragment homeFragment, NetworkAdapter networkAdapter) {
        this.a = homeFragment;
        this.b = networkAdapter;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.recyclerview.widget.AsyncListDiffer] */
    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextChange(String str) {
        ?? r0;
        HomeFragment homeFragment = this.a;
        if (str != null && !g.B(str)) {
            List list = homeFragment.H0;
            if (list != null) {
                r0 = new ArrayList();
                for (Object obj : list) {
                    if (g.o(((NetworkList) obj).getName(), str, true)) {
                        r0.add(obj);
                    }
                }
            } else {
                yg0.N("networkList");
                throw null;
            }
        } else {
            List list2 = homeFragment.H0;
            if (list2 != null) {
                r0 = list2;
            } else {
                yg0.N("networkList");
                throw null;
            }
        }
        this.b.f.b(r0);
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public final boolean onQueryTextSubmit(String str) {
        return false;
    }
}
