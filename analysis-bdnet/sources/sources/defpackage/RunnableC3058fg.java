package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
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
import dastan.prince.bdfreevpn.R;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: fg, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC3058fg implements Runnable {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ RunnableC3058fg(int i) {
        this.a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AbstractC0161Fv abstractC0161Fv;
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
                    C3975rD.c().a(ConstraintProxyUpdateReceiver.a, "Updating proxies: BatteryNotLowProxy enabled (" + booleanExtra + "), BatteryChargingProxy enabled (" + booleanExtra2 + "), StorageNotLowProxy (" + booleanExtra3 + "), NetworkStateProxy enabled (" + booleanExtra4 + ")", new Throwable[0]);
                    AJ.a(context, ConstraintProxy$BatteryNotLowProxy.class, booleanExtra);
                    AJ.a(context, ConstraintProxy$BatteryChargingProxy.class, booleanExtra2);
                    AJ.a(context, ConstraintProxy$StorageNotLowProxy.class, booleanExtra3);
                    AJ.a(context, ConstraintProxy$NetworkStateProxy.class, booleanExtra4);
                    return;
                } finally {
                    pendingResult.finish();
                }
            case 1:
                C3599mV c3599mV = (C3599mV) this.b;
                c3599mV.getClass();
                C0148Fi c0148Fi = (C0148Fi) this.c;
                V20 v20 = (V20) c0148Fi.d;
                if (v20 == null) {
                    String str2 = (String) c0148Fi.b;
                    C3083g10 c3083g10 = c3599mV.l;
                    if (c3083g10 != null) {
                        VPNClient vPNClient = c3083g10.a;
                        try {
                            String replace = str2.replace(Deobfuscator$BDNETVPN$app.getString(-41428586428299L), Deobfuscator$BDNETVPN$app.getString(-41437176362891L)).replace(Deobfuscator$BDNETVPN$app.getString(-41441471330187L), Deobfuscator$BDNETVPN$app.getString(-41450061264779L));
                            int i = F00.a;
                            try {
                                str = AbstractC4569ym.c(replace, AbstractC4569ym.a);
                            } catch (Exception unused) {
                            }
                            JSONObject jSONObject = new JSONObject(str);
                            String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-41454356232075L));
                            String str3 = VPNClient.f0;
                            if (VPNClient.o(vPNClient, string, vPNClient.x())) {
                                JSONArray jSONArray = new JSONArray();
                                try {
                                    JSONArray jSONArray2 = vPNClient.h().getJSONArray(Deobfuscator$BDNETVPN$app.getString(-54657085699979L));
                                    for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                        JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                                        if (jSONObject2.optString(Deobfuscator$BDNETVPN$app.getString(-54695740405643L), Deobfuscator$BDNETVPN$app.getString(-54730100144011L)).startsWith(Deobfuscator$BDNETVPN$app.getString(-54734395111307L))) {
                                            jSONArray.put(jSONObject2);
                                        }
                                    }
                                } catch (Exception unused2) {
                                }
                                JSONArray jSONArray3 = jSONObject.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-41488715970443L));
                                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                    JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                                    String optString = jSONObject3.optString(Deobfuscator$BDNETVPN$app.getString(-41527370676107L));
                                    if (optString != null) {
                                        for (int i4 = 0; i4 < jSONArray3.length(); i4++) {
                                            if (optString.equalsIgnoreCase(jSONArray3.getJSONObject(i4).optString(Deobfuscator$BDNETVPN$app.getString(-54790229686155L), Deobfuscator$BDNETVPN$app.getString(-54850359228299L)))) {
                                                break;
                                            }
                                        }
                                    }
                                    jSONArray3.put(jSONObject3);
                                }
                                FileOutputStream fileOutputStream = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-41587500218251L)));
                                fileOutputStream.write(F00.b(jSONObject.toString(2)).getBytes());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-41643334793099L));
                                VPNClient.p(vPNClient);
                            } else if (vPNClient.n) {
                                SweetToast.info(vPNClient.getApplicationContext(), vPNClient.getString(R.string.noupdate_msg));
                            }
                        } catch (Exception e) {
                            String message = e.getMessage();
                            vPNClient.getClass();
                            Log.e(Deobfuscator$BDNETVPN$app.getString(-55872561444747L), message);
                        }
                    }
                } else {
                    C0407Pi c0407Pi = c3599mV.e;
                    if (c0407Pi != null) {
                        Deobfuscator$BDNETVPN$app.getString(-41712054269835L);
                        v20.getMessage();
                        c0407Pi.a.getClass();
                    }
                }
                if (c0148Fi.a) {
                    c3599mV.a("intermediate-response");
                } else {
                    c3599mV.b("done");
                }
                RunnableC3320j1 runnableC3320j1 = (RunnableC3320j1) this.d;
                if (runnableC3320j1 != null) {
                    runnableC3320j1.run();
                    return;
                }
                return;
            case 2:
                View view = (View) this.c;
                if (view == null || (overScroller = (abstractC0161Fv = (AbstractC0161Fv) this.d).d) == null) {
                    return;
                }
                boolean computeScrollOffset = overScroller.computeScrollOffset();
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b;
                if (computeScrollOffset) {
                    abstractC0161Fv.w(coordinatorLayout, view, abstractC0161Fv.d.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
                AppBarLayout appBarLayout = (AppBarLayout) view;
                ((AppBarLayout.BaseBehavior) abstractC0161Fv).C(coordinatorLayout, appBarLayout);
                if (appBarLayout.k) {
                    appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.z(coordinatorLayout)));
                    return;
                }
                return;
            case 3:
                try {
                    z = ((Boolean) ((C3278iS) this.d).get()).booleanValue();
                } catch (InterruptedException | ExecutionException unused3) {
                }
                ((C4220uL) this.b).a((String) this.c, z);
                return;
            case 4:
                C3194hO c3194hO = (C3194hO) this.d;
                C3176h8 c3176h8 = (C3176h8) this.b;
                c3194hO.b(c3176h8, (TaskCompletionSource) this.c);
                ((AtomicInteger) c3194hO.i.c).set(0);
                double min = Math.min(3600000.0d, Math.pow(c3194hO.b, c3194hO.a()) * (60000.0d / c3194hO.a));
                String str4 = "Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(min / 1000.0d)) + " s for report: " + c3176h8.b;
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str4, null);
                }
                try {
                    Thread.sleep((long) min);
                    return;
                } catch (InterruptedException unused4) {
                    return;
                }
            case 5:
                try {
                    obj = ((CallableC4417ws) this.b).call();
                } catch (Exception unused5) {
                }
                ((Handler) this.d).post(new RunnableC3320j1((C4496xs) this.c, obj, 16, z2));
                return;
            case 6:
                ((C0777b50) this.b).f.g((String) this.c, (C0595Wo) this.d);
                return;
            case 7:
                C3091g50 j = ((WorkDatabase) this.b).n().j((String) this.c);
                if (j == null || !j.b()) {
                    return;
                }
                synchronized (((C0887cW) this.d).c) {
                    ((C0887cW) this.d).f.put((String) this.c, j);
                    ((C0887cW) this.d).g.add(j);
                    C0887cW c0887cW = (C0887cW) this.d;
                    c0887cW.h.b(c0887cW.g);
                }
                return;
            case 8:
                C3278iS c3278iS = (C3278iS) this.c;
                RunnableC3648n50 runnableC3648n50 = (RunnableC3648n50) this.d;
                try {
                    ((C3278iS) this.b).get();
                    C3975rD.c().a(RunnableC3648n50.s, "Starting work for " + runnableC3648n50.d.c, new Throwable[0]);
                    C3278iS d = runnableC3648n50.e.d();
                    runnableC3648n50.q = d;
                    c3278iS.k(d);
                    return;
                } catch (Throwable th) {
                    c3278iS.j(th);
                    return;
                }
            default:
                String str5 = (String) this.c;
                RunnableC3648n50 runnableC3648n502 = (RunnableC3648n50) this.d;
                try {
                    try {
                        GC gc = (GC) ((C3278iS) this.b).get();
                        if (gc == null) {
                            C3975rD.c().b(RunnableC3648n50.s, runnableC3648n502.d.c + " returned a null result. Treating it as a failure.", new Throwable[0]);
                        } else {
                            C3975rD.c().a(RunnableC3648n50.s, String.format("%s returned a %s result.", runnableC3648n502.d.c, gc), new Throwable[0]);
                            runnableC3648n502.g = gc;
                        }
                    } finally {
                        runnableC3648n502.b();
                    }
                } catch (InterruptedException e2) {
                    e = e2;
                    C3975rD.c().b(RunnableC3648n50.s, str5 + " failed because it threw an exception/error", e);
                } catch (CancellationException e3) {
                    C3975rD.c().d(RunnableC3648n50.s, str5 + " was cancelled", e3);
                } catch (ExecutionException e4) {
                    e = e4;
                    C3975rD.c().b(RunnableC3648n50.s, str5 + " failed because it threw an exception/error", e);
                }
                runnableC3648n502.b();
                return;
        }
    }

    public /* synthetic */ RunnableC3058fg(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public /* synthetic */ RunnableC3058fg(Object obj, Object obj2, Object obj3, int i, boolean z) {
        this.a = i;
        this.d = obj;
        this.b = obj2;
        this.c = obj3;
    }
}
