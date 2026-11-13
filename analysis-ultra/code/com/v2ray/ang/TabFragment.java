package com.v2ray.ang;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.v2ray.ang.adapter.NetworkAdapter;
import com.v2ray.ang.viewmodel.NetworkList;
import defpackage.j60;
import defpackage.sd0;
import defpackage.xu;
import defpackage.yg0;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.text.g;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/v2ray/ang/TabFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "Companion", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TabFragment extends Fragment {
    public static final Companion e0 = new Companion(null);
    public RecyclerView Y;
    public final ArrayList Z = new ArrayList();
    public ArrayList a0 = new ArrayList();
    public boolean b0;
    public sd0 c0;
    public NetworkAdapter d0;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/v2ray/ang/TabFragment$Companion;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion(xu xuVar) {
        }
    }

    public final void W(String str) {
        if (this.b0 && this.d0 != null) {
            boolean B = g.B(str);
            ArrayList arrayList = this.a0;
            if (!B) {
                ArrayList arrayList2 = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if (g.o(((NetworkList) next).getName(), str, true)) {
                        arrayList2.add(next);
                    }
                }
                arrayList = arrayList2;
            }
            NetworkAdapter networkAdapter = this.d0;
            if (networkAdapter != null) {
                arrayList.getClass();
                networkAdapter.f.b(arrayList);
            } else {
                yg0.N("adapter");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View w(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.getClass();
        View inflate = layoutInflater.inflate(R.layout.fragment_tab, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.recyclerView);
        findViewById.getClass();
        this.Y = (RecyclerView) findViewById;
        ArrayList arrayList = this.Z;
        arrayList.clear();
        arrayList.addAll(this.a0);
        RecyclerView recyclerView = this.Y;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(M()));
            sd0 sd0Var = this.c0;
            if (sd0Var != null) {
                NetworkAdapter networkAdapter = new NetworkAdapter(M(), new ArrayList(), sd0Var);
                this.d0 = networkAdapter;
                RecyclerView recyclerView2 = this.Y;
                if (recyclerView2 != null) {
                    recyclerView2.setAdapter(networkAdapter);
                    NetworkAdapter networkAdapter2 = this.d0;
                    if (networkAdapter2 != null) {
                        ArrayList arrayList2 = this.a0;
                        arrayList2.getClass();
                        networkAdapter2.f.b(arrayList2);
                        RecyclerView recyclerView3 = this.Y;
                        if (recyclerView3 != null) {
                            recyclerView3.post(new j60(this, 28));
                            return inflate;
                        }
                        yg0.N("recyclerView");
                        throw null;
                    }
                    yg0.N("adapter");
                    throw null;
                }
                yg0.N("recyclerView");
                throw null;
            }
            return inflate;
        }
        yg0.N("recyclerView");
        throw null;
    }
}
