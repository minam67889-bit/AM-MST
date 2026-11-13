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
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.appbar.AppBarLayout;
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

/* renamed from: Cb, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0043Cb implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ RunnableC0043Cb(int i) {
        this.a = i;
    }

    public RunnableC0043Cb(View view, QL ql, C0071Dn c0071Dn, ValueAnimator valueAnimator) {
        this.a = 9;
        this.b = view;
        this.c = c0071Dn;
        this.d = valueAnimator;
    }

    public /* synthetic */ RunnableC0043Cb(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public /* synthetic */ RunnableC0043Cb(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.a = i;
        this.d = obj;
        this.b = obj2;
        this.c = obj3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0223Nn abstractC0223Nn;
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
                    C3686zs.c().a(ConstraintProxyUpdateReceiver.a, "Updating proxies: BatteryNotLowProxy enabled (" + booleanExtra + "), BatteryChargingProxy enabled (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy enabled (" + booleanExtra4 + ")", new Throwable[0]);
                    Yw.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    Yw.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    Yw.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    Yw.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 1:
                ((AbstractC3151pm) this.b).getClass();
                AbstractC3151pm.g((View) this.c, (Rect) this.d);
                return;
            case 2:
                C3128pF c3128pF = (C3128pF) this.b;
                c3128pF.getClass();
                C3360tk c3360tk = (C3360tk) this.c;
                C2553eL c2553eL = (C2553eL) c3360tk.d;
                if (c2553eL == null) {
                    String str2 = (String) c3360tk.b;
                    FI fi = c3128pF.r;
                    if (fi != null) {
                        UDPClient uDPClient = fi.a;
                        try {
                            String replace = str2.replace("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range").replace("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
                            try {
                                str = AbstractC3622yh.c(replace, AbstractC3622yh.a);
                            } catch (Exception unused) {
                            }
                            JSONObject jSONObject = new JSONObject(str);
                            File file = new File(uDPClient.getFilesDir().getAbsolutePath() + "#ERR IndexError: list index out of range");
                            String string = jSONObject.getString("#ERR IndexError: list index out of range");
                            String str3 = UDPClient.Z;
                            if (UDPClient.h(uDPClient, string, uDPClient.n())) {
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                fileOutputStream.write(replace.getBytes());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                SweetToast.success(uDPClient.getApplicationContext(), "#ERR IndexError: list index out of range");
                                UDPClient.g(uDPClient);
                            } else if (uDPClient.q) {
                                SweetToast.info(uDPClient.getApplicationContext(), uDPClient.getString(2131952021));
                            }
                        } catch (Exception e) {
                            String message = e.getMessage();
                            uDPClient.getClass();
                            Log.e("#ERR IndexError: list index out of range", message);
                        }
                    }
                } else {
                    GI gi = c3128pF.e;
                    if (gi != null) {
                        "#ERR IndexError: list index out of range";
                        c2553eL.getMessage();
                        gi.a.getClass();
                    }
                }
                if (c3360tk.a) {
                    c3128pF.a("intermediate-response");
                } else {
                    c3128pF.b("done");
                }
                Runnable runnable = (Runnable) this.d;
                if (runnable != null) {
                    runnable.run();
                    return;
                }
                return;
            case 3:
                View view = (View) this.c;
                if (view == null || (overScroller = (abstractC0223Nn = (AbstractC0223Nn) this.d).d) == null) {
                    return;
                }
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b;
                if (computeScrollOffset) {
                    abstractC0223Nn.w(coordinatorLayout, view, abstractC0223Nn.d.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
                AppBarLayout appBarLayout = (AppBarLayout) view;
                ((AppBarLayout.BaseBehavior) abstractC0223Nn).C(coordinatorLayout, appBarLayout);
                if (appBarLayout.q) {
                    appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.z(coordinatorLayout)));
                    return;
                }
                return;
            case 4:
                try {
                    z = ((Boolean) ((Or) this.d).get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused2) {
                }
                ((InterfaceC0233Oi) this.b).b((String) this.c, z);
                return;
            case 5:
                C3387uA c3387uA = (C3387uA) this.d;
                C3012n5 c3012n5 = (C3012n5) this.b;
                c3387uA.b(c3012n5, (TaskCompletionSource) this.c);
                ((AtomicInteger) c3387uA.i.c).set(0);
                double min = Math.min(3600000.0d, Math.pow(c3387uA.b, c3387uA.a()) * (60000.0d / c3387uA.a));
                String str4 = "Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(min / 1000.0d)) + " s for report: " + c3012n5.b;
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
                ((Handler) this.d).post(new RunnableC3589y0((InterfaceC0256Qb) this.c, obj, 14, z2));
                return;
            case 7:
                ((EM) this.b).o.h((String) this.c, (C3) this.d);
                return;
            case 8:
                KM j = ((WorkDatabase) this.b).n().j((String) this.c);
                if (j == null || !j.b()) {
                    return;
                }
                synchronized (((C2760iG) this.d).c) {
                    ((C2760iG) this.d).f.put((String) this.c, j);
                    ((C2760iG) this.d).m.add(j);
                    C2760iG c2760iG = (C2760iG) this.d;
                    c2760iG.n.c(c2760iG.m);
                }
                return;
            case 9:
                LL.h((View) this.b, (C0071Dn) this.c);
                ((ValueAnimator) this.d).start();
                return;
            case 10:
                C2493dD c2493dD = (C2493dD) this.c;
                SM sm = (SM) this.d;
                try {
                    ((Or) this.b).get();
                    C3686zs.c().a(SM.z, "Starting work for " + sm.e.c, new Throwable[0]);
                    sm.x = sm.f.startWork();
                    c2493dD.k(sm.x);
                    return;
                } catch (Throwable th) {
                    c2493dD.j(th);
                    return;
                }
            default:
                String str5 = (String) this.c;
                SM sm2 = (SM) this.d;
                try {
                    try {
                        Sr sr = (Sr) ((C2493dD) this.b).get();
                        if (sr == null) {
                            C3686zs.c().b(SM.z, sm2.e.c + " returned a null result. Treating it as a failure.", new Throwable[0]);
                        } else {
                            C3686zs.c().a(SM.z, String.format("%s returned a %s result.", sm2.e.c, sr), new Throwable[0]);
                            sm2.n = sr;
                        }
                    } catch (InterruptedException e2) {
                        e = e2;
                        C3686zs.c().b(SM.z, str5 + " failed because it threw an exception/error", e);
                    } catch (CancellationException e3) {
                        C3686zs.c().e(SM.z, str5 + " was cancelled", e3);
                    } catch (ExecutionException e4) {
                        e = e4;
                        C3686zs.c().b(SM.z, str5 + " failed because it threw an exception/error", e);
                    }
                    sm2.c();
                    return;
                } catch (Throwable th2) {
                    sm2.c();
                    throw th2;
                }
        }
    }
}
