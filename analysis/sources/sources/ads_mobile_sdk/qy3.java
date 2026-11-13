package ads_mobile_sdk;

import android.content.Context;
import android.os.Build;
import android.view.View;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.C0583Vv;
import defpackage.C4669wd0;
import defpackage.InterfaceC4089p50;
import defpackage.InterfaceC4586va0;
import defpackage.RunnableC4080p1;
import defpackage.RunnableFutureC4351sX;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class qy3 implements InterfaceC4089p50, InterfaceC4586va0 {
    public static final String[] h = {"android:establish_vpn_service", "android:establish_vpn_manager"};
    public final C4669wd0 a;
    public final Context b;
    public final ExecutorService c;
    public long d = 0;
    public long e = 0;
    public long f = -1;
    public boolean g = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4089p50
    public final void b(HashMap hashMap) {
        c();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public qy3(Context context, C4669wd0 c4669wd0, ExecutorService executorService) {
        this.a = c4669wd0;
        this.b = context;
        this.c = executorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4586va0
    public final ListenableFuture a() {
        if (Build.VERSION.SDK_INT < 30) {
            return C0583Vv.b;
        }
        RunnableFutureC4351sX runnableFutureC4351sX = new RunnableFutureC4351sX(Executors.callable(new RunnableC4080p1(this, 27), null));
        this.c.execute(runnableFutureC4351sX);
        return runnableFutureC4351sX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4089p50
    public final void a(HashMap hashMap) {
        long j;
        long j2;
        c();
        synchronized (this) {
            try {
                j = this.g ? this.e - this.d : -1L;
            } finally {
            }
        }
        hashMap.put("vs", Long.valueOf(j));
        synchronized (this) {
            j2 = this.f;
            this.f = -1L;
        }
        hashMap.put("vf", Long.valueOf(j2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4089p50
    public final void a(HashMap hashMap, Context context, View view) {
        c();
    }
}
