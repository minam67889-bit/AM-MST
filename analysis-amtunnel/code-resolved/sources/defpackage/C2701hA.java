package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowInsetsController;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.SplashActivity;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* renamed from: hA, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2701hA implements InterfaceC3554xI, InterfaceC2916lF, Kt, InterfaceC0418aC, InterfaceC3663zL, Continuation {
    public static C2701hA c;
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ C2701hA(int i) {
        this.a = i;
    }

    public C2701hA(Context context) {
        boolean isEmpty;
        this.a = 3;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.b = sharedPreferences;
        File file = new File(AbstractC0487bc.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
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
                d();
            }
        } catch (IOException e) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e.getMessage());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [Rw, xE] */
    public C2701hA(View view) {
        Rw rw;
        this.a = 1;
        if (Build.VERSION.SDK_INT >= 30) {
            ?? rw2 = new Rw(view, 7);
            rw2.c = view;
            rw = rw2;
        } else {
            rw = new Rw(view, 7);
        }
        this.b = rw;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [Rw, java.lang.Object, xE] */
    public C2701hA(WindowInsetsController windowInsetsController) {
        this.a = 1;
        ?? rw = new Rw((Object) null, 7);
        rw.d = windowInsetsController;
        this.b = rw;
    }

    public /* synthetic */ C2701hA(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public void a() {
        String string = "PRINCE_F";
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = (SharedPreferencesEditorC2544eC) ((SharedPreferencesC2597fC) this.b).edit();
        sharedPreferencesEditorC2544eC.putBoolean(string, true);
        sharedPreferencesEditorC2544eC.apply();
    }

    @Override // defpackage.InterfaceC3554xI
    public void b() {
        SplashActivity splashActivity = (SplashActivity) ((EE) this.b).b;
        splashActivity.getClass();
        splashActivity.startActivity(new Intent(splashActivity, (Class<?>) UDPClient.class));
        splashActivity.finish();
    }

    @Override // defpackage.Kt
    public boolean c(Mt mt, MenuItem menuItem) {
        ((Toolbar) this.b).getClass();
        return false;
    }

    @Override // defpackage.InterfaceC3663zL
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.b).createWebView(webView));
    }

    public synchronized void d() {
        ((SharedPreferences) this.b).edit().clear().commit();
    }

    public void e() {
        AbstractC3605yG abstractC3605yG = (AbstractC3605yG) this.b;
        abstractC3605yG.getClass();
        String str = ((AG) abstractC3605yG).b;
        if (str == null) {
            throw new AssertionError();
        }
        throw new AssertionError(str);
    }

    @Override // defpackage.Kt
    public void g(Mt mt) {
        Toolbar toolbar = (Toolbar) this.b;
        A0 a0 = toolbar.a.z;
        if (a0 == null || !a0.k()) {
            Iterator it = toolbar.M.b.iterator();
            while (it.hasNext()) {
                ((C0296Sl) ((InterfaceC2788iu) it.next())).a.s(mt);
            }
        }
    }

    @Override // defpackage.InterfaceC3663zL
    public ProfileStoreBoundaryInterface getProfileStore() {
        return (ProfileStoreBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ProfileStoreBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.b).getProfileStore());
    }

    @Override // defpackage.InterfaceC3663zL
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(StaticsBoundaryInterface.class, ((WebViewProviderFactoryBoundaryInterface) this.b).getStatics());
    }

    @Override // defpackage.InterfaceC3663zL
    public String[] i() {
        return ((WebViewProviderFactoryBoundaryInterface) this.b).getSupportedFeatures();
    }

    @Override // defpackage.InterfaceC2916lF
    public void onLine(String str) {
        switch (this.a) {
            case 4:
                boolean contains = str.contains("Xray 24.11.30");
                SuperService superService = (SuperService) this.b;
                if (contains && !superService.s) {
                    try {
                        int i = SuperService.z;
                        superService.f();
                    } catch (Exception unused) {
                        HF hf = SuperService.C;
                        if (hf != null) {
                            ((UDPClient) hf).E();
                        } else {
                            AbstractC2879kf.V(superService.getApplicationContext(), "Error, Reconnect/Restart App!");
                        }
                        TunnelManagerHelper.stopSuperDns(superService.getApplicationContext());
                        AbstractC2879kf.U(superService.getApplicationContext(), "Error running VPNService!");
                    }
                    superService.s = true;
                }
                if (str.contains("Failed to start")) {
                    HF hf2 = SuperService.C;
                    if (hf2 != null) {
                        ((UDPClient) hf2).E();
                    } else {
                        AbstractC2879kf.V(superService.getApplicationContext(), "Error, Reconnect/Restart App!");
                    }
                    TunnelManagerHelper.stopSuperDns(superService.getApplicationContext());
                    AbstractC2879kf.U(superService.getApplicationContext(), "Failed to start!");
                    return;
                }
                return;
            default:
                if (str.contains("Connected")) {
                    ((UDPClient) TI.w).i("Connected");
                    ((UDPClient) TI.w).runOnUiThread(new RunnableC0247Ph(4));
                    Thread thread = SocksDNSService.r;
                    Thread thread2 = new Thread(SocksDNSService.s);
                    SocksDNSService.r = thread2;
                    thread2.start();
                    SkStatus.logInfo(2131952220, new Object[0]);
                }
                if (str.contains("UDP running")) {
                    ((UDPClient) TI.w).i("UDP is running");
                }
                boolean contains2 = str.contains("auth error");
                TI ti = (TI) this.b;
                if (contains2) {
                    ((UDPClient) TI.w).i("Invalid Authentication!");
                    SI si = TI.w;
                    if (si != null) {
                        ((UDPClient) si).E();
                    } else {
                        AbstractC2879kf.V(ti.a, "Error, Reconnect/Restart App!");
                    }
                    AbstractC2879kf.V(ti.a, "Invalid Account! Contact developer");
                    TunnelManagerHelper.stopSocksHttp(ti.a);
                }
                if (str.contains("exiting")) {
                    SI si2 = TI.w;
                    if (si2 != null) {
                        ((UDPClient) si2).E();
                    } else {
                        AbstractC2879kf.V(ti.a, "Error, Reconnect/Restart App!");
                    }
                    TunnelManagerHelper.stopSocksHttp(ti.a);
                }
                if (str.contains("unknown command")) {
                    SI si3 = TI.w;
                    if (si3 != null) {
                        ((UDPClient) si3).E();
                    } else {
                        AbstractC2879kf.V(ti.a, "Error, Reconnect/Restart App!");
                    }
                    TunnelManagerHelper.stopSocksHttp(ti.a);
                }
                if (str.contains("reconnecting")) {
                    SkStatus.updateStateString("RECONECTANDO", "Reconnecting...");
                    ((UDPClient) TI.w).i("Reconnecting...");
                    new Thread(new H0(this, 18)).start();
                }
                str.contains("network is unreachable");
                return;
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        String str;
        boolean isSuccessful = task.isSuccessful();
        AbstractC2555eN abstractC2555eN = (AbstractC2555eN) this.b;
        if (isSuccessful) {
            str = (String) task.getResult();
        } else {
            Log.e("RecaptchaCallWrapper", "Failed to get Recaptcha token, error - " + ((Exception) Preconditions.checkNotNull(task.getException())).getMessage() + "\n\n Failing open with a fake token.");
            str = "NO_RECAPTCHA";
        }
        return abstractC2555eN.o0(str);
    }
}
