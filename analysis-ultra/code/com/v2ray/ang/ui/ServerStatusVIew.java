package com.v2ray.ang.ui;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.m;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.trilead.ssh2.sftp.AttribFlags;
import com.v2ray.ang.Hometab;
import com.v2ray.ang.adapter.ServerStatusAdapter;
import com.v2ray.ang.viewmodel.ConfigData;
import com.v2ray.ang.viewmodel.ServerList;
import defpackage.h3;
import defpackage.l8;
import defpackage.mn;
import defpackage.n8;
import defpackage.p61;
import defpackage.xm;
import defpackage.zq0;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/v2ray/ang/ui/ServerStatusVIew;", "Landroidx/appcompat/app/AppCompatActivity;", "<init>", "()V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerStatusVIew extends AppCompatActivity {
    public static final /* synthetic */ int c = 0;
    public final Lazy b = kotlin.c.b(new l8(this, 20));

    public final List g(String str) {
        String str2;
        Lazy lazy = zq0.a;
        String d = zq0.u().d("KidConfigMM1");
        if (d != null && d.length() != 0) {
            str2 = String.valueOf(zq0.u().d("KidConfigMM1"));
        } else {
            InputStream open = getAssets().open("configfile.json");
            open.getClass();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, xm.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
            try {
                String b = kotlin.io.d.b(bufferedReader);
                bufferedReader.close();
                str2 = b;
            } finally {
            }
        }
        Hometab.n.getClass();
        ConfigData configData = (ConfigData) new Gson().c(Hometab.Companion.a(str2), new TypeToken(ConfigData.class));
        if (str != null) {
            List<ServerList> servers = configData.getServers();
            ArrayList arrayList = new ArrayList();
            for (Object obj : servers) {
                if (kotlin.text.g.w(((ServerList) obj).getServerProtocol(), str, true)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
        return configData.getServers();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.List, T] */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        androidx.activity.c.a(this);
        super.onCreate(bundle);
        Lazy lazy = this.b;
        setContentView(((h3) lazy.getValue()).a);
        n8.c(this);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ?? g = g(null);
        ref$ObjectRef.element = g;
        ServerStatusAdapter serverStatusAdapter = new ServerStatusAdapter(this, g, m.a(this));
        ((h3) lazy.getValue()).d.setAdapter(serverStatusAdapter);
        ((h3) lazy.getValue()).c.setOnClickListener(new p61(this, ref$ObjectRef, serverStatusAdapter, 0));
        ((h3) lazy.getValue()).b.setOnClickListener(new mn(this, 11));
    }
}
