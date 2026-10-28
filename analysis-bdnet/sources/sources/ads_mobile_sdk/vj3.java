package ads_mobile_sdk;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Build;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.C0317Lw;
import defpackage.Fe0;
import defpackage.InterfaceC2977ef0;
import defpackage.InterfaceC3652n70;
import defpackage.P60;
import defpackage.RunnableFutureC3681nY;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class vj3 implements InterfaceC2977ef0, InterfaceC3652n70 {
    public static final String[] h = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    public final P60 a;
    public final Context b;
    public final ExecutorService c;
    public long d = 0;
    public long e = 0;
    public long f = -1;
    public boolean g = false;

    public vj3(Context context, P60 p60, ExecutorService executorService, String[] strArr) {
        this.a = p60;
        this.b = context;
        this.c = executorService;
    }

    @Override // defpackage.InterfaceC2977ef0
    public final void a(HashMap hashMap) {
        long j;
        c();
        synchronized (this) {
            try {
                j = this.g ? this.e - this.d : -1L;
            } finally {
            }
        }
        hashMap.put("vs", Long.valueOf(j));
        hashMap.put("vf", Long.valueOf(b()));
    }

    @Override // defpackage.InterfaceC2977ef0
    public final void b(HashMap hashMap) {
        c();
    }

    public final void c() {
        synchronized (this) {
            try {
                if (this.g) {
                    this.a.getClass();
                    this.e = System.currentTimeMillis();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        uj3 uj3Var = new uj3(this);
        try {
            Object systemService = this.b.getSystemService("appops");
            systemService.getClass();
            ((AppOpsManager) systemService).startWatchingActive(h, this.c, uj3Var);
        } catch (Throwable unused) {
        }
    }

    public final long b() {
        long j;
        synchronized (this) {
            j = this.f;
            this.f = -1L;
        }
        return j;
    }

    @Override // defpackage.InterfaceC2977ef0
    public final void a(HashMap hashMap, Context context, View view) {
        c();
    }

    @Override // defpackage.InterfaceC3652n70
    public final ListenableFuture a() {
        if (Build.VERSION.SDK_INT < 30) {
            return C0317Lw.b;
        }
        Fe0 fe0 = new Fe0(this, 0);
        ExecutorService executorService = this.c;
        RunnableFutureC3681nY runnableFutureC3681nY = new RunnableFutureC3681nY(Executors.callable(fe0, null));
        executorService.execute(runnableFutureC3681nY);
        return runnableFutureC3681nY;
    }
}
