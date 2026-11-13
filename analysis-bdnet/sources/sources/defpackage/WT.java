package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.webkit.WebViewStartUpConfig;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import dastan.prince.bdfreevpn.R;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewStartUpConfigBoundaryInterface;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.SplashActivity;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes.dex */
public class WT implements K00, OnCompleteListener, WebViewStartUpConfigBoundaryInterface, OV, InterfaceC3281iV, OnFailureListener {
    public Object a;

    public /* synthetic */ WT(Object obj) {
        this.a = obj;
    }

    public void a() {
        View view = (View) this.a;
        if (view != null) {
            ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    @Override // defpackage.K00
    public void b() {
        SplashActivity splashActivity = (SplashActivity) ((CountDownTimerC3163h10) this.a).b;
        splashActivity.startActivity(new Intent(splashActivity, (Class<?>) VPNClient.class));
        splashActivity.finish();
    }

    @Override // defpackage.OV
    public PV c(C0148Fi c0148Fi) {
        C0595Wo c0595Wo = (C0595Wo) c0148Fi.d;
        if (c0595Wo == null) {
            throw new IllegalArgumentException("Must set a callback to create the configuration.");
        }
        Context context = (Context) this.a;
        if (context == null) {
            throw new IllegalArgumentException("Must set a non-null context to create the configuration.");
        }
        String str = (String) c0148Fi.c;
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
        }
        C0148Fi c0148Fi2 = new C0148Fi(context, str, c0595Wo, true);
        return new C0340Mt((Context) c0148Fi2.b, (String) c0148Fi2.c, (C0595Wo) c0148Fi2.d, c0148Fi2.a);
    }

    @Override // org.chromium.support_lib_boundary.WebViewStartUpConfigBoundaryInterface
    public Executor getBackgroundExecutor() {
        return ((WebViewStartUpConfig) this.a).getBackgroundExecutor();
    }

    @Override // org.chromium.support_lib_boundary.WebViewStartUpConfigBoundaryInterface
    public Set getProfileNamesToLoad() {
        return ((WebViewStartUpConfig) this.a).getProfilesToLoadDuringStartup();
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        Exception exception = task.getException();
        C0582Wb c0582Wb = (C0582Wb) this.a;
        if (exception != null) {
            c0582Wb.resumeWith(W80.j(exception));
        } else if (task.isCanceled()) {
            c0582Wb.n(null);
        } else {
            c0582Wb.resumeWith(task.getResult());
        }
    }

    @Override // com.google.android.gms.tasks.OnFailureListener
    public void onFailure(Exception exc) {
        if (exc instanceof C3785or) {
            Logger logger = C3059fg0.e;
            logger.v("Failure to refresh token; scheduling refresh after failure", new Object[0]);
            C3059fg0 c3059fg0 = (C3059fg0) ((RunnableC3320j1) this.a).c;
            int i = (int) c3059fg0.b;
            c3059fg0.b = (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) ? 2 * c3059fg0.b : i != 960 ? 30L : 960L;
            c3059fg0.a = (c3059fg0.b * 1000) + DefaultClock.getInstance().currentTimeMillis();
            logger.v(W50.k(c3059fg0.a, "Scheduling refresh for "), new Object[0]);
            c3059fg0.c.postDelayed(c3059fg0.d, c3059fg0.b * 1000);
        }
    }

    @Override // defpackage.InterfaceC3281iV
    public void onLine(String str) {
        boolean contains = str.contains(Deobfuscator$BDNETVPN$app.getString(-96631801083787L));
        XRayDNSService xRayDNSService = (XRayDNSService) this.a;
        if (contains && !xRayDNSService.u) {
            if (!xRayDNSService.f.r()) {
                XRayDNSService.E.addStatus(Deobfuscator$BDNETVPN$app.getString(-96717700429707L));
                XRayDNSService.E.startSocksOpenVPN();
            }
            XRayDNSService.A = new Date().getTime();
            Thread thread = new Thread(XRayDNSService.C);
            XRayDNSService.B = thread;
            thread.start();
            SkStatus.logInfo(R.string.tunnel_start, new Object[0]);
            xRayDNSService.u = true;
        }
        if (str.contains(Deobfuscator$BDNETVPN$app.getString(-96760650102667L))) {
            VPNClient vPNClient = XRayDNSService.E;
            if (vPNClient != null) {
                vPNClient.stopSocksOpenVPN();
            } else {
                F00.h(xRayDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-96829369579403L));
            }
            SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-96958218598283L));
            TunnelManagerHelper.stopXRay(xRayDNSService.getApplicationContext());
        }
        if (str.contains(Deobfuscator$BDNETVPN$app.getString(-97177261930379L))) {
            SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-97288931080075L));
            SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-97576693888907L));
            if (xRayDNSService.o) {
                return;
            }
            F00.h(xRayDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-98019075520395L));
            xRayDNSService.o = true;
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewStartUpConfigBoundaryInterface
    public boolean shouldRunUiThreadStartUpTasks() {
        return ((WebViewStartUpConfig) this.a).shouldRunUiThreadStartUpTasks();
    }

    public WT(Context context) {
        boolean isEmpty;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.a = sharedPreferences;
        File file = new File(context.getNoBackupFilesDir(), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    isEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (isEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                synchronized (this) {
                    sharedPreferences.edit().clear().commit();
                }
            }
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e.getMessage());
            }
        }
    }
}
