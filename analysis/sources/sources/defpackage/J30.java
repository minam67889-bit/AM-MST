package defpackage;

import android.app.ActivityManager;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.BroadcastReceiver;
import android.content.Context;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemjob.SystemJobService;
import app.vpn.amtunnellite.R;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class J30 extends V00 {
    public static J30 j;
    public static J30 k;
    public static final Object l;
    public final Context a;
    public final CR b;
    public final WorkDatabase c;
    public final LQ d;
    public final List e;
    public final C4800yK f;
    public final C0338Mk g;
    public boolean h;
    public BroadcastReceiver.PendingResult i;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        C4869zC.g("WorkManagerImpl");
        j = null;
        k = null;
        l = new Object();
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x00ee, code lost:
    
        if (r6 != null) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0179 A[Catch: InstantiationException -> 0x0249, IllegalAccessException -> 0x0261, ClassNotFoundException -> 0x0279, TryCatch #3 {ClassNotFoundException -> 0x0279, IllegalAccessException -> 0x0261, InstantiationException -> 0x0249, blocks: (B:30:0x0171, B:33:0x018d, B:58:0x0179), top: B:29:0x0171 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public J30(Context context, CR cr, LQ lq) {
        TN tn;
        Executor executor;
        ActivityManager activityManager;
        int i;
        int i2;
        String name;
        String str;
        String str2;
        WU e;
        boolean z;
        boolean z2 = false;
        boolean z3 = context.getResources().getBoolean(R.bool.workmanager_test_configuration);
        Context applicationContext = context.getApplicationContext();
        AQ aq = (AQ) lq.a;
        int i3 = WorkDatabase.k;
        if (z3) {
            tn = new TN(applicationContext, null);
            tn.h = true;
        } else {
            String str3 = D30.a;
            tn = new TN(applicationContext, "androidx.work.workdb");
            tn.g = new C0158Fl(applicationContext, z2);
        }
        tn.e = aq;
        A30 a30 = new A30();
        if (tn.d == null) {
            tn.d = new ArrayList();
        }
        tn.d.add(a30);
        tn.a(AbstractC0427Pv.f);
        tn.a(new C30(applicationContext, 2, 3));
        tn.a(AbstractC0427Pv.g);
        tn.a(AbstractC0427Pv.h);
        tn.a(new C30(applicationContext, 5, 6));
        tn.a(AbstractC0427Pv.i);
        tn.a(AbstractC0427Pv.j);
        tn.a(AbstractC0427Pv.k);
        tn.a(new C30(applicationContext));
        tn.a(new C30(applicationContext, 10, 11));
        tn.a(AbstractC0427Pv.l);
        tn.i = false;
        tn.j = true;
        Context context2 = tn.c;
        if (context2 != null) {
            Class cls = tn.a;
            if (cls != null) {
                Executor executor2 = tn.e;
                try {
                    if (executor2 == null && tn.f == null) {
                        executor = C0705a6.t;
                        tn.f = executor;
                    } else {
                        if (executor2 != null && tn.f == null) {
                            tn.f = executor2;
                        } else if (executor2 == null) {
                            executor = tn.f;
                        }
                        if (tn.g == null) {
                            tn.g = new C3363fd0();
                        }
                        VU vu = tn.g;
                        ArrayList arrayList = tn.d;
                        boolean z4 = tn.h;
                        activityManager = (ActivityManager) context2.getSystemService("activity");
                        if (activityManager == null && !activityManager.isLowRamDevice()) {
                            i = 3;
                        } else {
                            i = 2;
                        }
                        Executor executor3 = tn.e;
                        i2 = i;
                        C0260Jj c0260Jj = new C0260Jj(context2, tn.b, vu, tn.k, arrayList, z4, i2, executor3, tn.f, tn.i, tn.j);
                        name = cls.getPackage().getName();
                        String canonicalName = cls.getCanonicalName();
                        str = (name.isEmpty() ? canonicalName : canonicalName.substring(name.length() + 1)).replace('.', '_') + "_Impl";
                        if (!name.isEmpty()) {
                            str2 = str;
                        } else {
                            str2 = name + "." + str;
                        }
                        UN un = (UN) Class.forName(str2).newInstance();
                        e = un.e(c0260Jj);
                        un.c = e;
                        if (e instanceof OO) {
                            ((OO) e).getClass();
                        }
                        if (i2 != 3) {
                            z = true;
                        } else {
                            z = false;
                        }
                        e.setWriteAheadLoggingEnabled(z);
                        un.g = arrayList;
                        un.b = executor3;
                        new ArrayDeque();
                        un.e = z4;
                        un.f = z;
                        WorkDatabase workDatabase = (WorkDatabase) un;
                        Context applicationContext2 = context.getApplicationContext();
                        C4869zC c4869zC = new C4869zC(cr.a, false);
                        synchronized (C4869zC.class) {
                            C4869zC.b = c4869zC;
                        }
                        String str4 = AP.a;
                        C4042oV c4042oV = new C4042oV(applicationContext2, this);
                        EI.a(applicationContext2, SystemJobService.class, true);
                        C4869zC.d().a(AP.a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
                        List asList = Arrays.asList(c4042oV, new C0063Bu(applicationContext2, cr, lq, this));
                        C4800yK c4800yK = new C4800yK(context, cr, lq, workDatabase, asList);
                        Context applicationContext3 = context.getApplicationContext();
                        this.a = applicationContext3;
                        this.b = cr;
                        this.d = lq;
                        this.c = workDatabase;
                        this.e = asList;
                        this.f = c4800yK;
                        this.g = new C0338Mk(workDatabase);
                        this.h = false;
                        if (!applicationContext3.isDeviceProtectedStorage()) {
                            this.d.c(new RunnableC0851bs(applicationContext3, this));
                            return;
                        }
                        throw new IllegalStateException("Cannot initialize WorkManager in direct boot mode");
                    }
                    if (!name.isEmpty()) {
                    }
                    UN un2 = (UN) Class.forName(str2).newInstance();
                    e = un2.e(c0260Jj);
                    un2.c = e;
                    if (e instanceof OO) {
                    }
                    if (i2 != 3) {
                    }
                    e.setWriteAheadLoggingEnabled(z);
                    un2.g = arrayList;
                    un2.b = executor3;
                    new ArrayDeque();
                    un2.e = z4;
                    un2.f = z;
                    WorkDatabase workDatabase2 = (WorkDatabase) un2;
                    Context applicationContext22 = context.getApplicationContext();
                    C4869zC c4869zC2 = new C4869zC(cr.a, false);
                    synchronized (C4869zC.class) {
                    }
                } catch (ClassNotFoundException unused) {
                    throw new RuntimeException("cannot find implementation for " + cls.getCanonicalName() + ". " + str + " does not exist");
                } catch (IllegalAccessException unused2) {
                    throw new RuntimeException("Cannot access the constructor" + cls.getCanonicalName());
                } catch (InstantiationException unused3) {
                    throw new RuntimeException("Failed to create an instance of " + cls.getCanonicalName());
                }
                tn.e = executor;
                if (tn.g == null) {
                }
                VU vu2 = tn.g;
                ArrayList arrayList2 = tn.d;
                boolean z42 = tn.h;
                activityManager = (ActivityManager) context2.getSystemService("activity");
                if (activityManager == null) {
                }
                i = 2;
                Executor executor32 = tn.e;
                i2 = i;
                C0260Jj c0260Jj2 = new C0260Jj(context2, tn.b, vu2, tn.k, arrayList2, z42, i2, executor32, tn.f, tn.i, tn.j);
                name = cls.getPackage().getName();
                String canonicalName2 = cls.getCanonicalName();
                if (name.isEmpty()) {
                }
                str = (name.isEmpty() ? canonicalName2 : canonicalName2.substring(name.length() + 1)).replace('.', '_') + "_Impl";
            } else {
                throw new IllegalArgumentException("Must provide an abstract class that extends RoomDatabase");
            }
        } else {
            throw new IllegalArgumentException("Cannot provide null context for the database.");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static J30 v(Context context) {
        J30 j30;
        Object obj = l;
        synchronized (obj) {
            try {
                synchronized (obj) {
                    j30 = j;
                    if (j30 == null) {
                        j30 = k;
                    }
                }
                return j30;
            } catch (Throwable th) {
                throw th;
            } finally {
            }
        }
        if (j30 != null) {
            return j30;
        }
        context.getApplicationContext();
        throw new IllegalStateException("WorkManager is not initialized properly.  You have explicitly disabled WorkManagerInitializer in your manifest, have not manually called WorkManager#initialize at this point, and your Application does not implement Configuration.Provider.");
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0018, code lost:
    
        r6 = r6.getApplicationContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x001e, code lost:
    
        if (defpackage.J30.k != null) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0020, code lost:
    
        r3 = (java.util.concurrent.ExecutorService) r7.e;
        r2 = new defpackage.LQ();
        r2.b = new android.os.Handler(android.os.Looper.getMainLooper());
        r2.c = new defpackage.ExecutorC3345fP(r2, 1);
        r2.a = new defpackage.AQ(r3);
        defpackage.J30.k = new defpackage.J30(r6, r7, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004a, code lost:
    
        defpackage.J30.j = defpackage.J30.k;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void w(Context context, CR cr) {
        synchronized (l) {
            try {
                J30 j30 = j;
                if (j30 != null && k != null) {
                    throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class level Javadoc for more information.");
                }
            } finally {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void x() {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void y() {
        ArrayList c;
        WorkDatabase workDatabase = this.c;
        Context context = this.a;
        String str = C4042oV.e;
        JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
        if (jobScheduler != null && (c = C4042oV.c(context, jobScheduler)) != null && !c.isEmpty()) {
            Iterator it = c.iterator();
            while (it.hasNext()) {
                C4042oV.a(jobScheduler, ((JobInfo) it.next()).getId());
            }
        }
        Q8 n = workDatabase.n();
        UN un = (UN) n.a;
        un.b();
        C3888mV c3888mV = (C3888mV) n.i;
        C3839lt a = c3888mV.a();
        un.c();
        try {
            a.d.executeUpdateDelete();
            un.h();
            un.f();
            c3888mV.c(a);
            AP.a(this.b, workDatabase, this.e);
        } catch (Throwable th) {
            un.f();
            c3888mV.c(a);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void z(String str, C4142po c4142po) {
        LQ lq = this.d;
        RunnableC0437Qf runnableC0437Qf = new RunnableC0437Qf(7);
        runnableC0437Qf.b = this;
        runnableC0437Qf.c = str;
        runnableC0437Qf.d = c4142po;
        lq.c(runnableC0437Qf);
    }
}
