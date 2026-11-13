package defpackage;

import android.app.Application;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.f;
import androidx.fragment.app.z;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzaen;
import com.google.android.gms.internal.p002firebaseauthapi.zzahv;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: y0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC3589y0 implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public final Object c;

    public /* synthetic */ RunnableC3589y0(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    public RunnableC3589y0(C0430aO c0430aO, String str) {
        this.a = 20;
        Objects.requireNonNull(c0430aO);
        this.c = c0430aO;
        this.b = Preconditions.checkNotEmpty(str);
    }

    public /* synthetic */ RunnableC3589y0(Object obj, Object obj2, int i, boolean z) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public RunnableC3589y0(ExecutorC3495wC executorC3495wC) {
        this.a = 16;
        this.c = executorC3495wC;
    }

    private final void a() {
        try {
            b();
        } catch (Error e) {
            synchronized (((ExecutorC3495wC) this.c).b) {
                ((ExecutorC3495wC) this.c).c = 1;
                throw e;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0052, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0054, code lost:
    
        ((java.lang.Runnable) r10.b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0060, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0080, code lost:
    
        r10.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0062, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0063, code lost:
    
        defpackage.ExecutorC3495wC.f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b() {
        /*
            r10 = this;
            r0 = 0
            r1 = r0
        L2:
            java.lang.Object r2 = r10.c     // Catch: java.lang.Throwable -> L5e
            wC r2 = (defpackage.ExecutorC3495wC) r2     // Catch: java.lang.Throwable -> L5e
            java.util.ArrayDeque r2 = r2.b     // Catch: java.lang.Throwable -> L5e
            monitor-enter(r2)     // Catch: java.lang.Throwable -> L5e
            r3 = 1
            if (r0 != 0) goto L2c
            java.lang.Object r0 = r10.c     // Catch: java.lang.Throwable -> L20
            wC r0 = (defpackage.ExecutorC3495wC) r0     // Catch: java.lang.Throwable -> L20
            int r4 = r0.c     // Catch: java.lang.Throwable -> L20
            r5 = 4
            if (r4 != r5) goto L22
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L1f
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L1f:
            return
        L20:
            r0 = move-exception
            goto L83
        L22:
            long r6 = r0.d     // Catch: java.lang.Throwable -> L20
            r8 = 1
            long r6 = r6 + r8
            r0.d = r6     // Catch: java.lang.Throwable -> L20
            r0.c = r5     // Catch: java.lang.Throwable -> L20
            r0 = r3
        L2c:
            java.lang.Object r4 = r10.c     // Catch: java.lang.Throwable -> L20
            wC r4 = (defpackage.ExecutorC3495wC) r4     // Catch: java.lang.Throwable -> L20
            java.util.ArrayDeque r4 = r4.b     // Catch: java.lang.Throwable -> L20
            java.lang.Object r4 = r4.poll()     // Catch: java.lang.Throwable -> L20
            java.lang.Runnable r4 = (java.lang.Runnable) r4     // Catch: java.lang.Throwable -> L20
            r10.b = r4     // Catch: java.lang.Throwable -> L20
            if (r4 != 0) goto L4d
            java.lang.Object r0 = r10.c     // Catch: java.lang.Throwable -> L20
            wC r0 = (defpackage.ExecutorC3495wC) r0     // Catch: java.lang.Throwable -> L20
            r0.c = r3     // Catch: java.lang.Throwable -> L20
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            if (r1 == 0) goto L4c
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
        L4c:
            return
        L4d:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            boolean r2 = java.lang.Thread.interrupted()     // Catch: java.lang.Throwable -> L5e
            r1 = r1 | r2
            r2 = 0
            java.lang.Object r3 = r10.b     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
            java.lang.Runnable r3 = (java.lang.Runnable) r3     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
            r3.run()     // Catch: java.lang.Throwable -> L60 java.lang.RuntimeException -> L62
        L5b:
            r10.b = r2     // Catch: java.lang.Throwable -> L5e
            goto L2
        L5e:
            r0 = move-exception
            goto L85
        L60:
            r0 = move-exception
            goto L80
        L62:
            r3 = move-exception
            java.util.logging.Logger r4 = defpackage.ExecutorC3495wC.f     // Catch: java.lang.Throwable -> L60
            java.util.logging.Level r5 = java.util.logging.Level.SEVERE     // Catch: java.lang.Throwable -> L60
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L60
            r6.<init>()     // Catch: java.lang.Throwable -> L60
            java.lang.String r7 = "Exception while executing runnable "
            r6.append(r7)     // Catch: java.lang.Throwable -> L60
            java.lang.Object r7 = r10.b     // Catch: java.lang.Throwable -> L60
            java.lang.Runnable r7 = (java.lang.Runnable) r7     // Catch: java.lang.Throwable -> L60
            r6.append(r7)     // Catch: java.lang.Throwable -> L60
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L60
            r4.log(r5, r6, r3)     // Catch: java.lang.Throwable -> L60
            goto L5b
        L80:
            r10.b = r2     // Catch: java.lang.Throwable -> L5e
            throw r0     // Catch: java.lang.Throwable -> L5e
        L83:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L20
            throw r0     // Catch: java.lang.Throwable -> L5e
        L85:
            if (r1 == 0) goto L8e
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            r1.interrupt()
        L8e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.RunnableC3589y0.b():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11, types: [bk, tO] */
    @Override // java.lang.Runnable
    public final void run() {
        Kt kt;
        String string;
        Task<C3628yn> zza;
        int i = 0;
        switch (this.a) {
            case 0:
                A0 a0 = (A0) this.c;
                Mt mt = a0.c;
                if (mt != null && (kt = mt.e) != null) {
                    kt.g(mt);
                }
                View view = (View) a0.n;
                if (view != null && view.getWindowToken() != null) {
                    C3483w0 c3483w0 = (C3483w0) this.b;
                    if (!c3483w0.b()) {
                        if (c3483w0.f != null) {
                            c3483w0.d(0, 0, false, false);
                        }
                    }
                    a0.y = c3483w0;
                }
                a0.A = null;
                return;
            case 1:
                ((J0) this.b).a = this.c;
                return;
            case 2:
                ((Application) this.b).unregisterActivityLifecycleCallbacks((J0) this.c);
                return;
            case 3:
                try {
                    Method method = K0.d;
                    Object obj = this.c;
                    Object obj2 = this.b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        K0.e.invoke(obj2, obj, Boolean.FALSE);
                    }
                    return;
                } catch (RuntimeException e) {
                    if (e.getClass() == RuntimeException.class && e.getMessage() != null && e.getMessage().startsWith("Unable to stop")) {
                        throw e;
                    }
                    return;
                } catch (Throwable th) {
                    Log.e("ActivityRecreator", "Exception while invoking performStopActivity", th);
                    return;
                }
            case 4:
                try {
                    ((W7) this.c).b.put((C3128pF) this.b);
                    return;
                } catch (InterruptedException unused) {
                    return;
                }
            case 5:
                AbstractC0435ad abstractC0435ad = (AbstractC0435ad) ((Rw) this.b).b;
                if (abstractC0435ad != null) {
                    abstractC0435ad.C((Typeface) this.c);
                    return;
                }
                return;
            case 6:
                for (AbstractC3404ub abstractC3404ub : (List) this.b) {
                    Object obj3 = ((AbstractC0166Kb) this.c).e;
                    abstractC3404ub.b = obj3;
                    abstractC3404ub.d(abstractC3404ub.d, obj3);
                }
                return;
            case 7:
                synchronized (((ConstraintTrackingWorker) this.c).b) {
                    if (((ConstraintTrackingWorker) this.c).c) {
                        ((ConstraintTrackingWorker) this.c).d.i(new Object());
                    } else {
                        ((ConstraintTrackingWorker) this.c).d.k((Or) this.b);
                    }
                }
                return;
            case 8:
                ((C0230Of) this.b).a();
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Transition for operation " + ((z) this.c) + "has completed");
                    return;
                }
                return;
            case 9:
                C3686zs c = C3686zs.c();
                String str = C0365Xf.d;
                KM km = (KM) this.b;
                c.a(str, AbstractC3603yE.w("Scheduling work ", km.a), new Throwable[0]);
                ((C0365Xf) this.c).a.e(km);
                return;
            case 10:
                ((AdListener) this.b).onError((Ad) this.c, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network folder is inside of assets folder."));
                return;
            case 11:
                InterfaceC2730hn interfaceC2730hn = (InterfaceC2730hn) this.c;
                try {
                    interfaceC2730hn.onSuccess(AbstractC2866kI.u((Future) this.b));
                    return;
                } catch (ExecutionException e2) {
                    th = e2.getCause();
                    interfaceC2730hn.onFailure(th);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    interfaceC2730hn.onFailure(th);
                    return;
                }
            case 12:
                ((InterfaceC3121p8) this.b).a((C0178Kn) this.c);
                return;
            case 13:
                break;
            case 14:
                ((InterfaceC0256Qb) this.b).accept(this.c);
                return;
            case 15:
                ((InterfaceC3121p8) this.c).a((AbstractC3511wc) this.b);
                return;
            case 16:
                a();
                return;
            case 17:
                ExecutorC3654zC executorC3654zC = (ExecutorC3654zC) this.b;
                try {
                    ((Runnable) this.c).run();
                    return;
                } finally {
                    executorC3654zC.b();
                }
            case 18:
                f fVar = (f) this.c;
                ArrayList arrayList = fVar.b;
                z zVar = (z) this.b;
                arrayList.remove(zVar);
                fVar.c.remove(zVar);
                return;
            case 19:
                String string2 = "Invalid Authentication!";
                String str2 = (String) this.b;
                boolean contains = str2.contains(string2);
                UDPClient uDPClient = (UDPClient) this.c;
                if (contains) {
                    string = "Invalid";
                } else {
                    if (!str2.contains("Disconnected")) {
                        if (!str2.contains("Waiting for UDP response") && !str2.contains("Reconnecting...") && !str2.contains("Waiting...") && !str2.contains("Connecting")) {
                            if (!str2.contains("QUIC Connected")) {
                                if (str2.contains("UDP is running")) {
                                    uDPClient.J = true;
                                    return;
                                }
                                if (str2.contains("Connected") && uDPClient.I) {
                                    uDPClient.getClass();
                                    uDPClient.v();
                                    uDPClient.J = true;
                                    uDPClient.x();
                                    SweetToast.success(uDPClient.getApplicationContext(), uDPClient.getString(2131951762));
                                    uDPClient.B = "Connected";
                                    return;
                                }
                                return;
                            }
                            string = "QuicGood";
                        }
                        uDPClient.J = false;
                        return;
                    }
                    string = "Disconnected";
                }
                uDPClient.B = string;
                uDPClient.J = false;
                return;
            default:
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(C0399Zj.e((String) this.b));
                AbstractC0145Ik abstractC0145Ik = firebaseAuth.f;
                if (abstractC0145Ik != null) {
                    if (abstractC0145Ik == null) {
                        zza = Tasks.forException(zzaen.zza(new Status(17495)));
                    } else {
                        zzahv zzahvVar = ((SN) abstractC0145Ik).a;
                        zzahvVar.zzg();
                        zza = firebaseAuth.e.zza(firebaseAuth.a, abstractC0145Ik, zzahvVar.zzd(), (InterfaceC3348tO) new C0495bk(firebaseAuth, 1));
                    }
                    C0430aO.e.v("Token refreshing started", new Object[0]);
                    zza.addOnFailureListener(new Rw(this));
                    return;
                }
                return;
        }
        while (true) {
            try {
                ((Runnable) this.b).run();
            } catch (Throwable th3) {
                AbstractC2866kI.A(C2672gi.a, th3);
            }
            C2997mr c2997mr = (C2997mr) this.c;
            Runnable h = c2997mr.h();
            if (h == null) {
                return;
            }
            this.b = h;
            i++;
            if (i >= 16 && c2997mr.d.f(c2997mr)) {
                c2997mr.d.e(c2997mr, this);
                return;
            }
        }
    }

    public String toString() {
        switch (this.a) {
            case 11:
                C3 b0 = AbstractC2555eN.b0(this);
                C0071Dn c0071Dn = new C0071Dn(3, false);
                ((C0071Dn) b0.d).c = c0071Dn;
                b0.d = c0071Dn;
                c0071Dn.b = (InterfaceC2730hn) this.c;
                return b0.toString();
            case 16:
                Runnable runnable = (Runnable) this.b;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                return "SequentialExecutorWorker{state=" + AbstractC0041Bp.D(((ExecutorC3495wC) this.c).c) + "}";
            default:
                return super.toString();
        }
    }
}
