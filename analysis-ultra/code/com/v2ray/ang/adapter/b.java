package com.v2ray.ang.adapter;

import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import com.v2ray.ang.viewmodel.ServerList;
import defpackage.yg0;
import java.util.ArrayList;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final class b extends DiffUtil$ItemCallback {
    @Override // androidx.recyclerview.widget.DiffUtil$ItemCallback
    public final boolean a(Object obj, Object obj2) {
        return ((ServerList) obj).equals((ServerList) obj2);
    }

    @Override // androidx.recyclerview.widget.DiffUtil$ItemCallback
    public final boolean b(Object obj, Object obj2) {
        ServerList serverList = (ServerList) obj;
        ServerList serverList2 = (ServerList) obj2;
        if (yg0.a(serverList.getName(), serverList2.getName()) && yg0.a(serverList.getServerIPHost(), serverList2.getServerIPHost())) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.DiffUtil$ItemCallback
    public final Object c(Object obj, Object obj2) {
        ServerList serverList = (ServerList) obj;
        ServerList serverList2 = (ServerList) obj2;
        ArrayList arrayList = new ArrayList();
        if (!yg0.a(serverList.getFlag(), serverList2.getFlag())) {
            arrayList.add("flag");
        }
        if (!yg0.a(serverList.getServerProtocol(), serverList2.getServerProtocol())) {
            arrayList.add("protocol");
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return null;
    }
}
