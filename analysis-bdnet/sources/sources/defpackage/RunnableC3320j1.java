package defpackage;

import android.app.Application;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.f;
import androidx.fragment.app.t;
import androidx.fragment.app.z;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadz;
import com.google.android.gms.internal.p002firebaseauthapi.zzahd;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.auth.FirebaseAuth;
import dastan.prince.bdfreevpn.R;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: j1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC3320j1 implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public final Object c;

    public /* synthetic */ RunnableC3320j1(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0051, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        ((java.lang.Runnable) r10.b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0061, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0062, code lost:
    
        defpackage.ExecutorC3911qR.f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x007f, code lost:
    
        r10.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0081, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (r1 == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00da, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00dc, code lost:
    
        ((java.lang.Runnable) r10.b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00e8, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0108, code lost:
    
        r10.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x010a, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ea, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00eb, code lost:
    
        defpackage.ExecutorC3832pR.f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d1, code lost:
    
        if (r1 == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        switch (this.a) {
            case 18:
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    try {
                        synchronized (((ExecutorC3832pR) this.c).b) {
                            if (!z) {
                                ExecutorC3832pR executorC3832pR = (ExecutorC3832pR) this.c;
                                if (executorC3832pR.c != 4) {
                                    executorC3832pR.d++;
                                    executorC3832pR.c = 4;
                                    z = true;
                                }
                            }
                            Runnable runnable = (Runnable) ((ExecutorC3832pR) this.c).b.poll();
                            this.b = runnable;
                            if (runnable == null) {
                                ((ExecutorC3832pR) this.c).c = 1;
                                break;
                            }
                        }
                        if (!z2) {
                            return;
                        }
                    } finally {
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                return;
            default:
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    try {
                        synchronized (((ExecutorC3911qR) this.c).b) {
                            if (!z3) {
                                ExecutorC3911qR executorC3911qR = (ExecutorC3911qR) this.c;
                                if (executorC3911qR.c != 4) {
                                    executorC3911qR.d++;
                                    executorC3911qR.c = 4;
                                    z3 = true;
                                }
                            }
                            Runnable runnable2 = (Runnable) ((ExecutorC3911qR) this.c).b.poll();
                            this.b = runnable2;
                            if (runnable2 == null) {
                                ((ExecutorC3911qR) this.c).c = 1;
                                break;
                            }
                        }
                        if (!z4) {
                            return;
                        }
                    } finally {
                    }
                }
                Thread.currentThread().interrupt();
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [Tq, vg0] */
    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC0870cF interfaceC0870cF;
        Throwable tryInternalFastPathGetFailure;
        Task<C2882dV> zza;
        switch (this.a) {
            case 0:
                C3480l1 c3480l1 = (C3480l1) this.c;
                MenuC2945eF menuC2945eF = c3480l1.c;
                if (menuC2945eF != null && (interfaceC0870cF = menuC2945eF.e) != null) {
                    interfaceC0870cF.q(menuC2945eF);
                }
                View view = (View) c3480l1.h;
                if (view != null && view.getWindowToken() != null) {
                    C3162h1 c3162h1 = (C3162h1) this.b;
                    if (!c3162h1.b()) {
                        if (c3162h1.e != null) {
                            c3162h1.d(0, 0, false, false);
                        }
                    }
                    c3480l1.s = c3162h1;
                }
                c3480l1.u = null;
                return;
            case 1:
                ((C4112t1) this.b).a = this.c;
                return;
            case 2:
                ((Application) this.b).unregisterActivityLifecycleCallbacks((C4112t1) this.c);
                return;
            case 3:
                try {
                    Method method = AbstractC4191u1.d;
                    Object obj = this.c;
                    Object obj2 = this.b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        AbstractC4191u1.e.invoke(obj2, obj, Boolean.FALSE);
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
                    ((C0037Bb) this.c).b.put((C3599mV) this.b);
                    return;
                } catch (InterruptedException unused) {
                    return;
                }
            case 5:
                AbstractC0731aZ abstractC0731aZ = (AbstractC0731aZ) ((WT) this.b).a;
                if (abstractC0731aZ != null) {
                    abstractC0731aZ.U((Typeface) this.c);
                    return;
                }
                return;
            case 6:
                Iterator it = ((ArrayList) this.b).iterator();
                while (it.hasNext()) {
                    AbstractC0612Xf abstractC0612Xf = (AbstractC0612Xf) it.next();
                    Object obj3 = ((AbstractC3695ng) this.c).e;
                    abstractC0612Xf.b = obj3;
                    abstractC0612Xf.d(abstractC0612Xf.d, obj3);
                }
                return;
            case 7:
                synchronized (((ConstraintTrackingWorker) this.c).g) {
                    if (((ConstraintTrackingWorker) this.c).h) {
                        ((ConstraintTrackingWorker) this.c).i.i(new EC());
                    } else {
                        ((ConstraintTrackingWorker) this.c).i.k((ListenableFuture) this.b);
                    }
                }
                return;
            case 8:
                AbstractC0055Bt.g((View) this.b, (Rect) this.c);
                return;
            case 9:
                ((C0020Ak) this.b).a();
                if (t.G(2)) {
                    Log.v("FragmentManager", "Transition for operation " + ((z) this.c) + "has completed");
                    return;
                }
                return;
            case 10:
                C3975rD c = C3975rD.c();
                String str = C0306Lk.d;
                C3091g50 c3091g50 = (C3091g50) this.b;
                c.a(str, W50.m("Scheduling work ", c3091g50.a), new Throwable[0]);
                ((C0306Lk) this.c).a.d(c3091g50);
                return;
            case 11:
                ((AdListener) this.b).onError((Ad) this.c, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network folder is inside of assets folder."));
                return;
            case 12:
                ListenableFuture listenableFuture = (ListenableFuture) this.b;
                boolean z = listenableFuture instanceof AbstractC2917dy;
                InterfaceC4419wu interfaceC4419wu = (InterfaceC4419wu) this.c;
                if (z && (tryInternalFastPathGetFailure = ((AbstractC2917dy) listenableFuture).tryInternalFastPathGetFailure()) != null) {
                    interfaceC4419wu.onFailure(tryInternalFastPathGetFailure);
                    return;
                }
                try {
                    interfaceC4419wu.onSuccess(AbstractC4577yu.c(listenableFuture));
                    return;
                } catch (Error e2) {
                    e = e2;
                    interfaceC4419wu.onFailure(e);
                    return;
                } catch (RuntimeException e3) {
                    e = e3;
                    interfaceC4419wu.onFailure(e);
                    return;
                } catch (ExecutionException e4) {
                    interfaceC4419wu.onFailure(e4.getCause());
                    return;
                }
            case 13:
                ((C0582Wb) this.b).B((C4578yv) this.c);
                return;
            case 14:
                int i = 0;
                while (true) {
                    try {
                        ((Runnable) this.b).run();
                    } catch (Throwable th2) {
                        AbstractC0641Yi.A(C0912co.a, th2);
                    }
                    MB mb = (MB) this.c;
                    Runnable k = mb.k();
                    if (k == null) {
                        return;
                    }
                    this.b = k;
                    i++;
                    if (i >= 16) {
                        AbstractC0826bh abstractC0826bh = mb.d;
                        if (abstractC0826bh.h(mb)) {
                            abstractC0826bh.f(mb, this);
                            return;
                        }
                    }
                }
            case 15:
                ((C0723aR) ((InterfaceC0803bR) this.b)).g((C3507lJ) this.c, C4471xZ.a);
                return;
            case 16:
                ((C4496xs) this.b).accept(this.c);
                return;
            case 17:
                ((C0582Wb) this.c).B((C0834bp) this.b);
                return;
            case 18:
                try {
                    a();
                    return;
                } catch (Error e5) {
                    synchronized (((ExecutorC3832pR) this.c).b) {
                        ((ExecutorC3832pR) this.c).c = 1;
                        throw e5;
                    }
                }
            case 19:
                try {
                    a();
                    return;
                } catch (Error e6) {
                    synchronized (((ExecutorC3911qR) this.c).b) {
                        ((ExecutorC3911qR) this.c).c = 1;
                        throw e6;
                    }
                }
            case 20:
                ExecutorC4147tR executorC4147tR = (ExecutorC4147tR) this.b;
                try {
                    ((Runnable) this.c).run();
                    return;
                } finally {
                    executorC4147tR.a();
                }
            case 21:
                f fVar = (f) this.c;
                ArrayList arrayList = fVar.b;
                z zVar = (z) this.b;
                arrayList.remove(zVar);
                fVar.c.remove(zVar);
                return;
            case 22:
                VPNClient vPNClient = (VPNClient) this.c;
                boolean booleanValue = vPNClient.m.t().booleanValue();
                String str2 = (String) this.b;
                if (!booleanValue) {
                    vPNClient.D = str2;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43279717332875L))) {
                    vPNClient.y.setProgressWithAnimation(0.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.b();
                    if (vPNClient.m.t().booleanValue()) {
                        vPNClient.D = Deobfuscator$BDNETVPN$app.getString(-43382796547979L);
                    }
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43417156286347L))) {
                    vPNClient.y.setProgressWithAnimation(0.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.b();
                    if (vPNClient.m.t().booleanValue()) {
                        vPNClient.D = Deobfuscator$BDNETVPN$app.getString(-43472990861195L);
                    }
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43528825436043L))) {
                    vPNClient.y.setProgressWithAnimation(60.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.a();
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43636199618443L))) {
                    vPNClient.y.setProgressWithAnimation(60.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.a();
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43683444258699L))) {
                    vPNClient.y.setProgressWithAnimation(60.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.a();
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43777933539211L))) {
                    vPNClient.y.setProgressWithAnimation(60.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.a();
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43872422819723L))) {
                    vPNClient.y.setProgressWithAnimation(30.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.a();
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43919667459979L))) {
                    vPNClient.y.setProgressWithAnimation(30.0f);
                    vPNClient.y.setColor(-65536);
                    vPNClient.d.a();
                    vPNClient.I = false;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-43988386936715L))) {
                    vPNClient.y.setProgressWithAnimation(100.0f);
                    vPNClient.y.setColor(-16711936);
                    vPNClient.d.a();
                    vPNClient.I = true;
                    return;
                }
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-44052811446155L)) && vPNClient.H) {
                    vPNClient.y.setProgressWithAnimation(100.0f);
                    vPNClient.y.setColor(-16711936);
                    vPNClient.d.a();
                    vPNClient.I();
                    if (vPNClient.m.t().booleanValue()) {
                        vPNClient.D = Deobfuscator$BDNETVPN$app.getString(-44095761119115L);
                    }
                    vPNClient.I = true;
                    InterfaceC3475ky interfaceC3475ky = vPNClient.z;
                    if (interfaceC3475ky == null) {
                        vPNClient.K();
                    } else if (!vPNClient.E) {
                        interfaceC3475ky.show(vPNClient);
                        vPNClient.E = true;
                        vPNClient.H = false;
                    }
                    SweetToast.success(vPNClient.getApplicationContext(), vPNClient.getString(R.string.connected_toast));
                    QQ qq = vPNClient.m.b;
                    qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-163182319335307L), false);
                    qq.apply();
                    return;
                }
                return;
            default:
                C0493Sq e7 = C0493Sq.e((String) this.b);
                ((C0745ag0) e7.b(C0745ag0.class)).getClass();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e7);
                if (firebaseAuth.a() != null) {
                    AbstractC0053Br abstractC0053Br = firebaseAuth.f;
                    if (abstractC0053Br == null) {
                        zza = Tasks.forException(zzadz.zza(new Status(17495)));
                    } else {
                        zzahd zzahdVar = ((Zf0) abstractC0053Br).f;
                        zzahdVar.zzg();
                        zza = firebaseAuth.e.zza(firebaseAuth.a, abstractC0053Br, zzahdVar.zzd(), (vg0) new C0519Tq(firebaseAuth, 1));
                    }
                    C3059fg0.e.v("Token refreshing started", new Object[0]);
                    zza.addOnFailureListener(new WT(this));
                    return;
                }
                return;
        }
    }

    public String toString() {
        switch (this.a) {
            case 12:
                C4452xG z = XE.z(this);
                C0595Wo c0595Wo = new C0595Wo(10, false);
                ((C0595Wo) z.d).c = c0595Wo;
                z.d = c0595Wo;
                c0595Wo.b = (InterfaceC4419wu) this.c;
                return z.toString();
            case 18:
                Runnable runnable = (Runnable) this.b;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                StringBuilder sb = new StringBuilder("SequentialExecutorWorker{state=");
                int i = ((ExecutorC3832pR) this.c).c;
                sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb.append("}");
                return sb.toString();
            case 19:
                Runnable runnable2 = (Runnable) this.b;
                if (runnable2 != null) {
                    return "SequentialExecutorWorker{running=" + runnable2 + "}";
                }
                StringBuilder sb2 = new StringBuilder("SequentialExecutorWorker{state=");
                int i2 = ((ExecutorC3911qR) this.c).c;
                sb2.append(i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "null" : "RUNNING" : "QUEUED" : "QUEUING" : "IDLE");
                sb2.append("}");
                return sb2.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ RunnableC3320j1(Object obj, Object obj2, int i, boolean z) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    public /* synthetic */ RunnableC3320j1(Executor executor, int i) {
        this.a = i;
        this.c = executor;
    }

    public RunnableC3320j1(C3059fg0 c3059fg0, String str) {
        this.a = 23;
        Objects.requireNonNull(c3059fg0);
        this.c = c3059fg0;
        this.b = Preconditions.checkNotEmpty(str);
    }

    public RunnableC3320j1(AbstractC0055Bt abstractC0055Bt, View view, Rect rect) {
        this.a = 8;
        this.b = view;
        this.c = rect;
    }
}
