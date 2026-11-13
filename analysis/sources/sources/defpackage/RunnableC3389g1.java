package defpackage;

import android.app.Application;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.f;
import androidx.fragment.app.z;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import app.vpn.amtunnellite.R;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.firebase.auth.FirebaseAuth;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: g1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC3389g1 implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public final Object c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC3389g1(int i, Object obj, Object obj2) {
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
    
        defpackage.ExecutorC4729xQ.f.a().log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0083, code lost:
    
        r10.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0085, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0048, code lost:
    
        if (r1 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00de, code lost:
    
        r1 = r1 | java.lang.Thread.interrupted();
        r2 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00e0, code lost:
    
        ((java.lang.Runnable) r10.b).run();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ee, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ef, code lost:
    
        defpackage.ExecutorC4652wQ.f.log(java.util.logging.Level.SEVERE, "Exception while executing runnable " + ((java.lang.Runnable) r10.b), (java.lang.Throwable) r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ec, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x010c, code lost:
    
        r10.b = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x010e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d5, code lost:
    
        if (r1 == false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:?, code lost:
    
        return;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a() {
        switch (this.a) {
            case 19:
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    try {
                        synchronized (((ExecutorC4652wQ) this.c).b) {
                            if (!z) {
                                ExecutorC4652wQ executorC4652wQ = (ExecutorC4652wQ) this.c;
                                if (executorC4652wQ.c != 4) {
                                    executorC4652wQ.d++;
                                    executorC4652wQ.c = 4;
                                    z = true;
                                }
                            }
                            Runnable runnable = (Runnable) ((ExecutorC4652wQ) this.c).b.poll();
                            this.b = runnable;
                            if (runnable == null) {
                                ((ExecutorC4652wQ) this.c).c = 1;
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
                        synchronized (((ExecutorC4729xQ) this.c).b) {
                            if (!z3) {
                                ExecutorC4729xQ executorC4729xQ = (ExecutorC4729xQ) this.c;
                                if (executorC4729xQ.c != 4) {
                                    executorC4729xQ.d++;
                                    executorC4729xQ.c = 4;
                                    z3 = true;
                                }
                            }
                            Runnable runnable2 = (Runnable) ((ExecutorC4729xQ) this.c).b.poll();
                            this.b = runnable2;
                            if (runnable2 == null) {
                                ((ExecutorC4729xQ) this.c).c = 1;
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
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC3794lE interfaceC3794lE;
        Throwable tryInternalFastPathGetFailure;
        String string;
        switch (this.a) {
            case 0:
                C3543i1 c3543i1 = (C3543i1) this.c;
                MenuC3948nE menuC3948nE = c3543i1.c;
                if (menuC3948nE != null && (interfaceC3794lE = menuC3948nE.e) != null) {
                    interfaceC3794lE.k(menuC3948nE);
                }
                View view = (View) c3543i1.h;
                if (view != null && view.getWindowToken() != null) {
                    C3235e1 c3235e1 = (C3235e1) this.b;
                    if (!c3235e1.b()) {
                        if (c3235e1.f != null) {
                            c3235e1.d(0, 0, false, false);
                        }
                    }
                    c3543i1.s = c3235e1;
                }
                c3543i1.u = null;
                return;
            case 1:
                ((C4233r1) this.b).a = this.c;
                return;
            case 2:
                ((Application) this.b).unregisterActivityLifecycleCallbacks((C4233r1) this.c);
                return;
            case 3:
                try {
                    Method method = AbstractC4310s1.d;
                    Object obj = this.c;
                    Object obj2 = this.b;
                    if (method != null) {
                        method.invoke(obj2, obj, Boolean.FALSE, "AppCompat recreation");
                    } else {
                        AbstractC4310s1.e.invoke(obj2, obj, Boolean.FALSE);
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
                    ((C3972nb) this.c).b.put((C3964nU) this.b);
                    return;
                } catch (InterruptedException unused) {
                    return;
                }
            case 5:
                AbstractC4766xx abstractC4766xx = (AbstractC4766xx) ((VP) this.b).b;
                if (abstractC4766xx != null) {
                    abstractC4766xx.M((Typeface) this.c);
                    return;
                }
                return;
            case 6:
                for (AbstractC0230If abstractC0230If : (List) this.b) {
                    Object obj3 = ((AbstractC0645Yf) this.c).e;
                    abstractC0230If.b = obj3;
                    abstractC0230If.d(abstractC0230If.d, obj3);
                }
                return;
            case 7:
                synchronized (((ConstraintTrackingWorker) this.c).g) {
                    if (((ConstraintTrackingWorker) this.c).h) {
                        ((ConstraintTrackingWorker) this.c).i.i(new MB());
                    } else {
                        ((ConstraintTrackingWorker) this.c).i.k((ListenableFuture) this.b);
                    }
                }
                return;
            case 8:
                ((BinderC3828li) this.c).b.onRelationshipValidationResult((Uri) this.b);
                return;
            case 9:
                ((BinderC3828li) this.c).b.onActivityResized((Bundle) this.b);
                return;
            case 10:
                ((C4599vk) this.b).a();
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "Transition for operation " + ((z) this.c) + "has completed");
                    return;
                }
                return;
            case 11:
                C4869zC d = C4869zC.d();
                String str = C0183Gk.d;
                O30 o30 = (O30) this.b;
                d.a(str, AbstractC4575vQ.r("Scheduling work ", o30.a), new Throwable[0]);
                ((C0183Gk) this.c).a.d(o30);
                return;
            case 12:
                ((AdListener) this.b).onError((Ad) this.c, new AdError(-1, "Can't load Audience Network Dex. Please, check that audience_network folder is inside of assets folder."));
                return;
            case 13:
                Future future = (Future) this.b;
                boolean z = future instanceof AbstractC4151px;
                InterfaceC0555Ut interfaceC0555Ut = (InterfaceC0555Ut) this.c;
                if (z && (tryInternalFastPathGetFailure = ((AbstractC4151px) future).tryInternalFastPathGetFailure()) != null) {
                    interfaceC0555Ut.onFailure(tryInternalFastPathGetFailure);
                    return;
                }
                try {
                    interfaceC0555Ut.onSuccess(AbstractC0607Wt.c(future));
                    return;
                } catch (ExecutionException e2) {
                    th = e2.getCause();
                    interfaceC0555Ut.onFailure(th);
                    return;
                } catch (Throwable th2) {
                    th = th2;
                    interfaceC0555Ut.onFailure(th);
                    return;
                }
            case 14:
                ((InterfaceC0200Hb) this.b).b((C0504Su) this.c);
                return;
            case 15:
                int i = 0;
                while (true) {
                    try {
                        ((Runnable) this.b).run();
                    } catch (Throwable th3) {
                        AbstractC0440Qi.u(C0393On.a, th3);
                    }
                    XA xa = (XA) this.c;
                    Runnable B = xa.B();
                    if (B != null) {
                        this.b = B;
                        i++;
                        if (i >= 16 && xa.d.w(xa)) {
                            xa.d.k(xa, this);
                            return;
                        }
                    } else {
                        return;
                    }
                }
                break;
            case 16:
                ((C3423gQ) ((InterfaceC3500hQ) this.b)).g((C3798lI) this.c, YY.a);
                return;
            case 17:
                ((InterfaceC3520hg) this.b).accept(this.c);
                return;
            case 18:
                ((InterfaceC0200Hb) this.c).b((AbstractC0334Mg) this.b);
                return;
            case 19:
                try {
                    a();
                    return;
                } catch (Error e3) {
                    synchronized (((ExecutorC4652wQ) this.c).b) {
                        ((ExecutorC4652wQ) this.c).c = 1;
                        throw e3;
                    }
                }
            case 20:
                try {
                    a();
                    return;
                } catch (Error e4) {
                    synchronized (((ExecutorC4729xQ) this.c).b) {
                        ((ExecutorC4729xQ) this.c).c = 1;
                        throw e4;
                    }
                }
            case 21:
                AQ aq = (AQ) this.b;
                try {
                    ((Runnable) this.c).run();
                    return;
                } finally {
                    aq.a();
                }
            case 22:
                f fVar = (f) this.c;
                ArrayList arrayList = fVar.b;
                z zVar = (z) this.b;
                arrayList.remove(zVar);
                fVar.c.remove(zVar);
                return;
            case 23:
                String string2 = Deobfuscator$AMTUNNELLITE$app.getString(-151451968016033L);
                String str2 = (String) this.b;
                boolean contains = str2.contains(string2);
                boolean z2 = false;
                UDPClient uDPClient = (UDPClient) this.c;
                if (contains) {
                    string = Deobfuscator$AMTUNNELLITE$app.getString(-151280169324193L);
                } else if (str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151314529062561L))) {
                    string = Deobfuscator$AMTUNNELLITE$app.getString(-151198564945569L);
                } else {
                    if (!str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151683896250017L)) && !str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151653831478945L)) && !str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151585112002209L)) && !str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151460557950625L))) {
                        if (str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151971659058849L))) {
                            string = Deobfuscator$AMTUNNELLITE$app.getString(-151898644614817L);
                        } else {
                            z2 = true;
                            if (!str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151937299320481L))) {
                                if (str2.contains(Deobfuscator$AMTUNNELLITE$app.getString(-151864284876449L)) && uDPClient.B) {
                                    uDPClient.getClass();
                                    uDPClient.v();
                                    uDPClient.C = true;
                                    uDPClient.x();
                                    SweetToast.success(uDPClient.getApplicationContext(), uDPClient.getString(R.string.connected_toast));
                                    uDPClient.u = Deobfuscator$AMTUNNELLITE$app.getString(-151752615726753L);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    uDPClient.C = z2;
                    return;
                }
                uDPClient.u = string;
                uDPClient.C = z2;
                return;
            default:
                C4374sq e5 = C4374sq.e((String) this.b);
                ((Qd0) e5.b(Qd0.class)).getClass();
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e5);
                if (firebaseAuth.o()) {
                    Task a = firebaseAuth.a();
                    Wd0.e.v("Token refreshing started", new Object[0]);
                    a.addOnFailureListener(new VP(this));
                    return;
                }
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        switch (this.a) {
            case 13:
                S5 P = AbstractC0440Qi.P(this);
                C4142po c4142po = new C4142po(10, false);
                ((C4142po) P.d).c = c4142po;
                P.d = c4142po;
                c4142po.b = (InterfaceC0555Ut) this.c;
                return P.toString();
            case 19:
                Runnable runnable = (Runnable) this.b;
                if (runnable != null) {
                    return "SequentialExecutorWorker{running=" + runnable + "}";
                }
                return "SequentialExecutorWorker{state=" + F40.D(((ExecutorC4652wQ) this.c).c) + "}";
            case 20:
                Runnable runnable2 = (Runnable) this.b;
                if (runnable2 != null) {
                    return "SequentialExecutorWorker{running=" + runnable2 + "}";
                }
                return "SequentialExecutorWorker{state=" + AbstractC4575vQ.G(((ExecutorC4729xQ) this.c).c) + "}";
            default:
                return super.toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC3389g1(BinderC3828li binderC3828li, int i, int i2, Bundle bundle) {
        this.a = 9;
        this.c = binderC3828li;
        this.b = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC3389g1(BinderC3828li binderC3828li, int i, Uri uri, boolean z, Bundle bundle) {
        this.a = 8;
        this.c = binderC3828li;
        this.b = uri;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC3389g1(Object obj, Object obj2, int i, boolean z) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC3389g1(Executor executor, int i) {
        this.a = i;
        this.c = executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC3389g1(Wd0 wd0, String str) {
        this.a = 24;
        Objects.requireNonNull(wd0);
        this.c = wd0;
        this.b = Preconditions.checkNotEmpty(str);
    }
}
