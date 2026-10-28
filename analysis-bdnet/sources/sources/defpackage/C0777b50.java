package defpackage;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.WorkDatabase_Impl;
import androidx.work.impl.background.systemjob.SystemJobService;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* renamed from: b50, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0777b50 extends AbstractC0697a50 {
    public static C0777b50 j;
    public static C0777b50 k;
    public static final Object l;
    public final Context a;
    public final C4306vS b;
    public final WorkDatabase c;
    public final C4452xG d;
    public final List e;
    public final C4220uL f;
    public final C2835cv g;
    public boolean h;
    public BroadcastReceiver.PendingResult i;

    static {
        C3975rD.e("WorkManagerImpl");
        j = null;
        k = null;
        l = new Object();
    }

    public C0777b50(Context context, C4306vS c4306vS, C4452xG c4452xG) {
        PO po;
        Executor executor;
        String str;
        boolean z = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        ExecutorC4147tR executorC4147tR = (ExecutorC4147tR) c4452xG.b;
        int i = WorkDatabase.k;
        if (z) {
            po = new PO(applicationContext, null);
            po.g = true;
        } else {
            String str2 = U40.a;
            po = new PO(applicationContext, "androidx.work.workdb");
            po.f = new WT((Object) applicationContext);
        }
        po.d = executorC4147tR;
        R40 r40 = new R40();
        if (po.c == null) {
            po.c = new ArrayList();
        }
        po.c.add(r40);
        po.a(S50.k);
        po.a(new T40(applicationContext, 2, 3));
        po.a(S50.l);
        po.a(S50.m);
        po.a(new T40(applicationContext, 5, 6));
        po.a(S50.n);
        po.a(S50.o);
        po.a(S50.p);
        po.a(new T40(applicationContext));
        po.a(new T40(applicationContext, 10, 11));
        po.a(S50.q);
        po.h = false;
        po.i = true;
        Context context2 = po.b;
        if (context2 == null) {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
        Executor executor2 = po.d;
        if (executor2 == null && po.e == null) {
            ExecutorC3964r6 executorC3964r6 = C4043s6.q;
            po.e = executorC3964r6;
            po.d = executorC3964r6;
        } else if (executor2 != null && po.e == null) {
            po.e = executor2;
        } else if (executor2 == null && (executor = po.e) != null) {
            po.d = executor;
        }
        if (po.f == null) {
            po.f = new C0213Hv(20);
        }
        OV ov = po.f;
        ArrayList arrayList = po.c;
        boolean z2 = po.g;
        ActivityManager activityManager = (ActivityManager) context2.getSystemService("activity");
        int i2 = (activityManager == null || activityManager.isLowRamDevice()) ? 2 : 3;
        Executor executor3 = po.d;
        C0434Qj c0434Qj = new C0434Qj(context2, po.a, ov, po.j, arrayList, z2, i2, executor3, po.e, po.h, po.i);
        int i3 = i2;
        String name = WorkDatabase.class.getPackage().getName();
        String canonicalName = WorkDatabase.class.getCanonicalName();
        String str3 = (name.isEmpty() ? canonicalName : canonicalName.substring(name.length() + 1)).replace('.', '_') + "_Impl";
        try {
            if (name.isEmpty()) {
                str = str3;
            } else {
                str = name + "." + str3;
            }
            RO ro = (RO) Class.forName(str).newInstance();
            PV e = ro.e(c0434Qj);
            ro.c = e;
            if (e instanceof PP) {
                ((PP) e).getClass();
            }
            boolean z3 = i3 == 3;
            e.setWriteAheadLoggingEnabled(z3);
            ro.g = arrayList;
            ro.b = executor3;
            new ArrayDeque();
            ro.e = z2;
            ro.f = z3;
            WorkDatabase workDatabase = (WorkDatabase) ro;
            Context applicationContext2 = context.getApplicationContext();
            C3975rD c3975rD = new C3975rD(c4306vS.a);
            synchronized (C3975rD.class) {
                C3975rD.b = c3975rD;
            }
            String str4 = AbstractC4541yQ.a;
            C3202hW c3202hW = new C3202hW(applicationContext2, this);
            AJ.a(applicationContext2, SystemJobService.class, true);
            C3975rD.c().a(AbstractC4541yQ.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
            List asList = Arrays.asList(c3202hW, new C3234hv(applicationContext2, c4306vS, c4452xG, this));
            C4220uL c4220uL = new C4220uL(context, c4306vS, c4452xG, workDatabase, asList);
            Context applicationContext3 = context.getApplicationContext();
            this.a = applicationContext3;
            this.b = c4306vS;
            this.d = c4452xG;
            this.c = workDatabase;
            this.e = asList;
            this.f = c4220uL;
            this.g = new C2835cv(workDatabase, 26);
            this.h = false;
            if (applicationContext3.isDeviceProtectedStorage()) {
                throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
            }
            this.d.g(new RunnableC0158Fs(applicationContext3, this));
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("cannot find implementation for " + WorkDatabase.class.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor" + WorkDatabase.class.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + WorkDatabase.class.getCanonicalName());
        }
    }

    public static C0777b50 b(Context context) {
        C0777b50 c0777b50;
        Object obj = l;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    c0777b50 = j;
                    if (c0777b50 == null) {
                        c0777b50 = k;
                    }
                }
                return c0777b50;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (c0777b50 != null) {
            return c0777b50;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        r4 = r4.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (defpackage.C0777b50.k != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        defpackage.C0777b50.k = new defpackage.C0777b50(r4, r5, new defpackage.C4452xG((java.util.concurrent.ExecutorService) r5.e));
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0030, code lost:
    
        defpackage.C0777b50.j = defpackage.C0777b50.k;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(Context context, C4306vS c4306vS) {
        synchronized (l) {
            try {
                C0777b50 c0777b50 = j;
                if (c0777b50 != null && k != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            } finally {
            }
        }
    }

    public final void d() {
        synchronized (l) {
            try {
                this.h = true;
                BroadcastReceiver.PendingResult pendingResult = this.i;
                if (pendingResult != null) {
                    pendingResult.finish();
                    this.i = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        ArrayList c;
        WorkDatabase workDatabase = this.c;
        Context context = this.a;
        String str = C3202hW.e;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (c = C3202hW.c(context, jobScheduler)) != null && !c.isEmpty()) {
            Iterator it = c.iterator();
            while (it.hasNext()) {
                C3202hW.a(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        C2859d9 n = workDatabase.n();
        WorkDatabase_Impl workDatabase_Impl = (WorkDatabase_Impl) n.a;
        workDatabase_Impl.b();
        C3042fW c3042fW = (C3042fW) n.i;
        C0366Nt a = c3042fW.a();
        workDatabase_Impl.c();
        try {
            a.d.executeUpdateDelete();
            workDatabase_Impl.h();
            workDatabase_Impl.f();
            c3042fW.c(a);
            AbstractC4541yQ.a(this.b, workDatabase, this.e);
        } catch (Throwable th) {
            workDatabase_Impl.f();
            c3042fW.c(a);
            throw th;
        }
    }

    public final void f(String str, C0595Wo c0595Wo) {
        C4452xG c4452xG = this.d;
        RunnableC3058fg runnableC3058fg = new RunnableC3058fg(6);
        runnableC3058fg.b = this;
        runnableC3058fg.c = str;
        runnableC3058fg.d = c0595Wo;
        c4452xG.g(runnableC3058fg);
    }
}
