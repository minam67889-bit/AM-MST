package defpackage;

import android.animation.ValueAnimator;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryChargingProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$BatteryNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$NetworkStateProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxy$StorageNotLowProxy;
import androidx.work.impl.background.systemalarm.ConstraintProxyUpdateReceiver;
import app.vpn.amtunnellite.R;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.appbar.AppBarLayout;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: Qf, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0437Qf implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC0437Qf(int i) {
        this.a = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0686Zu abstractC0686Zu;
        OverScroller overScroller;
        String str = null;
        Object obj = null;
        boolean z = true;
        boolean z2 = false;
        switch (this.a) {
            case 0:
                BroadcastReceiver.PendingResult pendingResult = (BroadcastReceiver.PendingResult) this.d;
                Context context = (Context) this.c;
                Intent intent = (Intent) this.b;
                try {
                    boolean booleanExtra = intent.getBooleanExtra("KEY_BATTERY_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra2 = intent.getBooleanExtra("KEY_BATTERY_CHARGING_PROXY_ENABLED", false);
                    boolean booleanExtra3 = intent.getBooleanExtra("KEY_STORAGE_NOT_LOW_PROXY_ENABLED", false);
                    boolean booleanExtra4 = intent.getBooleanExtra("KEY_NETWORK_STATE_PROXY_ENABLED", false);
                    C4869zC.d().a(ConstraintProxyUpdateReceiver.a, "Updating proxies: BatteryNotLowProxy enabled (" + booleanExtra + "), BatteryChargingProxy enabled (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy enabled (" + booleanExtra4 + ")", new Throwable[0]);
                    EI.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    EI.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    EI.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    EI.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 1:
                ((AbstractC0658Ys) this.b).getClass();
                AbstractC0658Ys.g((View) this.c, (Rect) this.d);
                return;
            case 2:
                C3964nU c3964nU = (C3964nU) this.b;
                c3964nU.getClass();
                C4213qi c4213qi = (C4213qi) this.c;
                I10 i10 = (I10) c4213qi.d;
                if (i10 == null) {
                    String str2 = (String) c4213qi.b;
                    AY ay = c3964nU.l;
                    if (ay != null) {
                        UDPClient uDPClient = ay.a;
                        try {
                            String replace = str2.replace(Deobfuscator$AMTUNNELLITE$app.getString(-150399701028513L), Deobfuscator$AMTUNNELLITE$app.getString(-150872147431073L)).replace(Deobfuscator$AMTUNNELLITE$app.getString(-150859262529185L), Deobfuscator$AMTUNNELLITE$app.getString(-150850672594593L));
                            try {
                                str = AbstractC4447tm.c(replace, AbstractC4447tm.a);
                            } catch (Exception unused) {
                            }
                            JSONObject jSONObject = new JSONObject(str);
                            File file = new File(uDPClient.getFilesDir().getAbsolutePath() + Deobfuscator$AMTUNNELLITE$app.getString(-150854967561889L));
                            String string = jSONObject.getString(Deobfuscator$AMTUNNELLITE$app.getString(-150803427954337L));
                            String str3 = UDPClient.U;
                            if (UDPClient.h(uDPClient, string, uDPClient.n())) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(replace.getBytes());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                SweetToast.success(uDPClient.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-150837787692705L));
                                UDPClient.g(uDPClient);
                            } else if (uDPClient.k) {
                                SweetToast.info(uDPClient.getApplicationContext(), uDPClient.getString(R.string.noupdate_msg));
                            }
                        } catch (Exception e) {
                            String message = e.getMessage();
                            uDPClient.getClass();
                            Log.e(Deobfuscator$AMTUNNELLITE$app.getString(-142694529699489L), message);
                        }
                    }
                } else {
                    AY ay2 = c3964nU.e;
                    if (ay2 != null) {
                        Deobfuscator$AMTUNNELLITE$app.getString(-150769068215969L);
                        i10.getMessage();
                        ay2.a.getClass();
                    }
                }
                if (c4213qi.a) {
                    c3964nU.a("intermediate-response");
                } else {
                    c3964nU.b("done");
                }
                Runnable runnable = (Runnable) this.d;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 3:
                View view = (View) this.c;
                if (view != null && (overScroller = (abstractC0686Zu = (AbstractC0686Zu) this.d).d) != null) {
                    boolean computeScrollOffset = overScroller.computeScrollOffset();
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b;
                    if (computeScrollOffset) {
                        abstractC0686Zu.w(coordinatorLayout, view, abstractC0686Zu.d.getCurrY());
                        view.postOnAnimation(this);
                        return;
                    }
                    AppBarLayout appBarLayout = (AppBarLayout) view;
                    ((AppBarLayout.BaseBehavior) abstractC0686Zu).C(coordinatorLayout, appBarLayout);
                    if (appBarLayout.k) {
                        appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.z(coordinatorLayout)));
                        return;
                    }
                    return;
                }
                return;
            case 4:
                try {
                    z = ((Boolean) ((ListenableFuture) this.d).get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused2) {
                }
                ((InterfaceC0213Ho) this.b).a((String) this.c, z);
                return;
            case 5:
                C3726kN c3726kN = (C3726kN) this.d;
                R7 r7 = (R7) this.b;
                c3726kN.b(r7, (TaskCompletionSource) this.c);
                ((AtomicInteger) c3726kN.i.c).set(0);
                double min = Math.min(3600000.0d, Math.pow(c3726kN.b, c3726kN.a()) * (60000.0d / c3726kN.a));
                String str4 = "Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(min / 1000.0d)) + " s for report: " + r7.b;
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str4, null);
                }
                try {
                    Thread.sleep((long) min);
                    return;
                } catch (InterruptedException unused3) {
                    return;
                }
            case 6:
                try {
                    obj = ((Callable) this.b).call();
                } catch (Exception unused4) {
                }
                ((Handler) this.d).post(new RunnableC3389g1((InterfaceC3520hg) this.c, obj, 17, z2));
                return;
            case 7:
                ((J30) this.b).f.g((String) this.c, (C4142po) this.d);
                return;
            case 8:
                O30 j = ((WorkDatabase) this.b).n().j((String) this.c);
                if (j != null && j.b()) {
                    synchronized (((C3657jV) this.d).c) {
                        ((C3657jV) this.d).f.put((String) this.c, j);
                        ((C3657jV) this.d).g.add(j);
                        C3657jV c3657jV = (C3657jV) this.d;
                        c3657jV.h.b(c3657jV.g);
                    }
                    return;
                }
                return;
            case 9:
                I20.h((View) this.b, (C4142po) this.c);
                ((ValueAnimator) this.d).start();
                return;
            case 10:
                C4192qR c4192qR = (C4192qR) this.c;
                V30 v30 = (V30) this.d;
                try {
                    ((ListenableFuture) this.b).get();
                    C4869zC.d().a(V30.s, "Starting work for " + v30.d.c, new Throwable[0]);
                    C4192qR d = v30.e.d();
                    v30.q = d;
                    c4192qR.k(d);
                    return;
                } catch (Throwable th) {
                    c4192qR.j(th);
                    return;
                }
            default:
                String str5 = (String) this.c;
                V30 v302 = (V30) this.d;
                try {
                    try {
                        OB ob = (OB) ((C4192qR) this.b).get();
                        if (ob == null) {
                            C4869zC.d().c(V30.s, v302.d.c + " returned a null result. Treating it as a failure.", new Throwable[0]);
                        } else {
                            C4869zC.d().a(V30.s, String.format("%s returned a %s result.", v302.d.c, ob), new Throwable[0]);
                            v302.g = ob;
                        }
                    } catch (Throwable th2) {
                        v302.c();
                        throw th2;
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    C4869zC.d().c(V30.s, str5 + " failed because it threw an exception/error", e);
                } catch (CancellationException e3) {
                    C4869zC.d().e(V30.s, str5 + " was cancelled", e3);
                } catch (ExecutionException e4) {
                    e = e4;
                    C4869zC.d().c(V30.s, str5 + " failed because it threw an exception/error", e);
                }
                v302.c();
                return;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC0437Qf(View view, N20 n20, C4142po c4142po, ValueAnimator valueAnimator) {
        this.a = 9;
        this.b = view;
        this.c = c4142po;
        this.d = valueAnimator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC0437Qf(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RunnableC0437Qf(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.a = i;
        this.d = obj;
        this.b = obj2;
        this.c = obj3;
    }
}
