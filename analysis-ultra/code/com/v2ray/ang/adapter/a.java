package com.v2ray.ang.adapter;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.v2ray.ang.viewmodel.NetworkList;
import defpackage.yg0;
import java.util.ArrayList;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final class a extends DiffUtil$ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil$ItemCallback
    public final boolean a(Object obj, Object obj2) {
        return ((NetworkList) obj).equals((NetworkList) obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil$ItemCallback
    public final boolean b(Object obj, Object obj2) {
        return yg0.a(((NetworkList) obj).getName(), ((NetworkList) obj2).getName());
    }

    @Override // androidx.recyclerview.widget.DiffUtil$ItemCallback
    public final Object c(Object obj, Object obj2) {
        NetworkList networkList = (NetworkList) obj;
        NetworkList networkList2 = (NetworkList) obj2;
        ArrayList arrayList = new ArrayList();
        if (!yg0.a(networkList.getInfo(), networkList2.getInfo())) {
            arrayList.add("info");
        }
        if (!yg0.a(networkList.getTunnelType(), networkList2.getTunnelType())) {
            arrayList.add("tunnel");
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return null;
    }
}
