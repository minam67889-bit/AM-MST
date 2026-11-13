package defpackage;

import android.content.ClipData;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.l;
import androidx.fragment.app.t;
import androidx.fragment.app.x;
import androidx.profileinstaller.ProfileInstallReceiver;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import dastan.prince.bdfreevpn.R;
import java.io.Closeable;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: dV, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2882dV implements InterfaceC0870cF, InterfaceC4484xg, Q5, OI, InterfaceC0853c4, InterfaceC0373Oa, InterfaceC0610Xd, InterfaceC0016Ag, SuccessContinuation, V0, InterfaceC4255uo, InterfaceC3281iV, InterfaceC4428x1, OnSuccessListener, InterfaceC3898qE, AL, Q10, InterfaceC3696nh {
    public static C2882dV c;
    public static final C0108Du d = new C0108Du(1);
    public final /* synthetic */ int a;
    public Object b;

    public /* synthetic */ C2882dV(int i, boolean z) {
        this.a = i;
    }

    public static C2882dV A(int i) {
        return new C2882dV(C4395wb.a(KM.a(i)), 28);
    }

    public static String C(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public static synchronized C2882dV y() {
        C2882dV c2882dV;
        synchronized (C2882dV.class) {
            try {
                if (c == null) {
                    C2882dV c2882dV2 = new C2882dV(0, false);
                    C0886cV c0886cV = new C0886cV();
                    c0886cV.d();
                    c2882dV2.b = c0886cV;
                    c = c2882dV2;
                }
                c2882dV = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c2882dV;
    }

    public void B(int i) {
        RecyclerView recyclerView = (RecyclerView) this.b;
        View childAt = recyclerView.getChildAt(i);
        if (childAt != null) {
            RecyclerView.I(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i);
    }

    public void D(String str, boolean z) {
        QQ qq = (QQ) ((RQ) this.b).edit();
        qq.putBoolean(str, z);
        Log.d("PrefUtil", "set_boolean: " + str + "=" + z);
        qq.apply();
    }

    public void E(int i, Object obj, BQ bq) {
        C3532le c3532le = (C3532le) this.b;
        c3532le.v0(i, 3);
        bq.e((AbstractC2841d0) obj, c3532le.o);
        c3532le.v0(i, 4);
    }

    @Override // defpackage.InterfaceC0016Ag
    public ClipData a() {
        ClipData clip;
        clip = ((ContentInfo) this.b).getClip();
        return clip;
    }

    @Override // defpackage.InterfaceC3696nh
    public Object b(C3617mh c3617mh) {
        return ((InterfaceC0522Tt) this.b).invoke(c3617mh);
    }

    @Override // defpackage.InterfaceC0610Xd
    public void c(Closeable closeable, Throwable th, Throwable th2) {
        if (th == th2) {
            return;
        }
        try {
            ((Method) this.b).invoke(th, th2);
        } catch (Throwable unused) {
            AbstractC0532Ud.a.log(Level.WARNING, "Suppressing exception thrown when closing " + closeable, th2);
        }
    }

    @Override // defpackage.V0
    public boolean d(View view) {
        DrawerLayout drawerLayout = (DrawerLayout) this.b;
        if (!DrawerLayout.k(view) || drawerLayout.g(view) == 2) {
            return false;
        }
        drawerLayout.b(view);
        return true;
    }

    @Override // defpackage.AL
    public void e(int i, Serializable serializable) {
        String str;
        switch (i) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i == 6 || i == 7 || i == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
        ((ProfileInstallReceiver) this.b).setResultCode(i);
    }

    @Override // defpackage.InterfaceC4428x1
    public void f(Object obj) {
        C4349w1 c4349w1 = (C4349w1) obj;
        t tVar = (t) this.b;
        C3152gt c3152gt = (C3152gt) tVar.C.pollFirst();
        if (c3152gt == null) {
            Log.w("FragmentManager", "No Activities were started for result for " + this);
            return;
        }
        x xVar = tVar.c;
        String str = c3152gt.a;
        l c2 = xVar.c(str);
        if (c2 != null) {
            c2.onActivityResult(c3152gt.b, c4349w1.a, c4349w1.b);
        } else {
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    public void g(int i) {
    }

    @Override // defpackage.InterfaceC0016Ag
    public int getFlags() {
        int flags;
        flags = ((ContentInfo) this.b).getFlags();
        return flags;
    }

    @Override // defpackage.Q10
    public int h() {
        AbstractC2953eN abstractC2953eN = (AbstractC2953eN) this.b;
        return abstractC2953eN.n - abstractC2953eN.F();
    }

    @Override // defpackage.InterfaceC0870cF
    public boolean i(MenuC2945eF menuC2945eF, MenuItem menuItem) {
        InterfaceC3718o1 interfaceC3718o1 = ((ActionMenuView) this.b).z;
        return interfaceC3718o1 != null && ((Toolbar) ((QO) interfaceC3718o1).a).G.a(menuItem);
    }

    @Override // defpackage.Q10
    public int j(View view) {
        C3033fN c3033fN = (C3033fN) view.getLayoutParams();
        ((AbstractC2953eN) this.b).getClass();
        return (view.getLeft() - ((C3033fN) view.getLayoutParams()).b.left) - ((ViewGroup.MarginLayoutParams) c3033fN).leftMargin;
    }

    @Override // defpackage.InterfaceC0853c4
    public void k(Bundle bundle, String str) {
        C4406wh c4406wh = (C4406wh) this.b;
        if (c4406wh != null) {
            try {
                final String str2 = "$A$:" + C(bundle, str);
                final C4643zh c4643zh = c4406wh.a;
                c4643zh.getClass();
                final long currentTimeMillis = System.currentTimeMillis() - c4643zh.d;
                ((ExecutorC3221hi) c4643zh.o.b).b(new Callable() { // from class: xh
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        final C4643zh c4643zh2 = C4643zh.this;
                        ExecutorC3221hi executorC3221hi = (ExecutorC3221hi) c4643zh2.o.c;
                        final long j = currentTimeMillis;
                        final String str3 = str2;
                        return executorC3221hi.a(new Runnable() { // from class: yh
                            @Override // java.lang.Runnable
                            public final void run() {
                                C4169th c4169th = C4643zh.this.g;
                                C3141gi c3141gi = c4169th.n;
                                if (c3141gi == null || !c3141gi.e.get()) {
                                    ((InterfaceC4178tq) c4169th.i.c).h(j, str3);
                                }
                            }
                        });
                    }
                });
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override // defpackage.InterfaceC4255uo
    public Object l(String str) {
        return ((InterfaceC4413wo) this.b).f(str, null);
    }

    @Override // defpackage.OI
    public C4119t40 m(View view, C4119t40 c4119t40) {
        int a = c4119t40.a();
        AbstractC3920qa abstractC3920qa = (AbstractC3920qa) this.b;
        abstractC3920qa.m = a;
        abstractC3920qa.n = c4119t40.b();
        abstractC3920qa.o = c4119t40.c();
        abstractC3920qa.f();
        return c4119t40;
    }

    @Override // defpackage.AL
    public void n() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // defpackage.InterfaceC0016Ag
    public ContentInfo o() {
        return (ContentInfo) this.b;
    }

    @Override // defpackage.InterfaceC3281iV
    public void onLine(String str) {
        boolean contains = str.contains(Deobfuscator$BDNETVPN$app.getString(-73602186442635L));
        FWPuncherService fWPuncherService = (FWPuncherService) this.b;
        if (contains) {
            SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-73756805265291L), fWPuncherService.getString(R.string.state_connecting));
            SkStatus.logInfo(R.string.state_connecting, new Object[0]);
            FWPuncherService.r.addStatus(Deobfuscator$BDNETVPN$app.getString(-73804049905547L));
        }
        if (str.contains(Deobfuscator$BDNETVPN$app.getString(-73898539186059L))) {
            try {
                boolean z = FWPuncherService.o;
                fWPuncherService.h();
            } catch (Exception unused) {
                fWPuncherService.i();
                F00.h(fWPuncherService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-73975848597387L));
            }
        }
        if (str.contains(Deobfuscator$BDNETVPN$app.getString(-74087517747083L))) {
            SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-74182007027595L), Deobfuscator$BDNETVPN$app.getString(-74237841602443L));
            FWPuncherService.r.addStatus(Deobfuscator$BDNETVPN$app.getString(-74306561079179L));
            fWPuncherService.a();
        }
        if (str.contains(Deobfuscator$BDNETVPN$app.getString(-74375280555915L))) {
            F00.h(fWPuncherService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-74474064803723L));
            VPNClient vPNClient = FWPuncherService.r;
            if (vPNClient != null) {
                vPNClient.stopSocksOpenVPN();
            } else {
                F00.h(fWPuncherService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-74602913822603L));
            }
            TunnelManagerHelper.stopSsh(fWPuncherService.getApplicationContext());
        }
        if (str.contains(Deobfuscator$BDNETVPN$app.getString(-74731762841483L))) {
            FWPuncherService.r.addStatus(Deobfuscator$BDNETVPN$app.getString(-74779007481739L));
            VPNClient vPNClient2 = FWPuncherService.r;
            if (vPNClient2 != null) {
                vPNClient2.stopSocksOpenVPN();
            } else {
                F00.h(fWPuncherService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-74882086696843L));
            }
            F00.h(fWPuncherService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-75010935715723L));
            TunnelManagerHelper.stopSsh(fWPuncherService.getApplicationContext());
        }
        if (!str.contains(Deobfuscator$BDNETVPN$app.getString(-75161259571083L)) || FWPuncherService.e()) {
            return;
        }
        try {
            fWPuncherService.h();
        } catch (Exception unused2) {
            fWPuncherService.i();
            F00.h(fWPuncherService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-75212799178635L));
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
        C2996ex c2996ex = (C2996ex) this.b;
        c2996ex.g.getClass();
        if (appUpdateInfo.installStatus() == 11) {
            C2996ex.c(c2996ex);
            C2996ex.a(c2996ex);
            Log.d("InAppUpdateManager", "checkNewAppVersionState(): resuming flexible update. Code: " + appUpdateInfo.updateAvailability());
        }
        if (appUpdateInfo.updateAvailability() == 3) {
            C2996ex.e(c2996ex, appUpdateInfo);
            Log.d("InAppUpdateManager", "checkNewAppVersionState(): resuming immediate update. Code: " + appUpdateInfo.updateAvailability());
        }
    }

    @Override // defpackage.Q10
    public View p(int i) {
        return ((AbstractC2953eN) this.b).u(i);
    }

    @Override // defpackage.InterfaceC0870cF
    public void q(MenuC2945eF menuC2945eF) {
        TO to = ((ActionMenuView) this.b).u;
        if (to != null) {
            to.q(menuC2945eF);
        }
    }

    @Override // defpackage.Q10
    public int r() {
        return ((AbstractC2953eN) this.b).E();
    }

    public void s(int i) {
    }

    @Override // defpackage.InterfaceC0016Ag
    public int t() {
        int source;
        source = ((ContentInfo) this.b).getSource();
        return source;
    }

    @Override // com.google.android.gms.tasks.SuccessContinuation
    public Task then(Object obj) {
        if (((C3436kS) obj) == null) {
            Log.w("FirebaseCrashlytics", "Received null app settings, cannot send reports at crash time.", null);
            return Tasks.forResult(null);
        }
        C4169th c4169th = ((CallableC4011rh) this.b).e;
        return Tasks.whenAll((Task<?>[]) new Task[]{C4169th.a(c4169th), c4169th.m.s(null, (ExecutorC3221hi) c4169th.e.b)});
    }

    public String toString() {
        switch (this.a) {
            case 10:
                return "ContentInfoCompat{" + ((ContentInfo) this.b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.Q10
    public int u(View view) {
        C3033fN c3033fN = (C3033fN) view.getLayoutParams();
        ((AbstractC2953eN) this.b).getClass();
        return view.getRight() + ((C3033fN) view.getLayoutParams()).b.right + ((ViewGroup.MarginLayoutParams) c3033fN).rightMargin;
    }

    @Override // defpackage.InterfaceC0373Oa
    public void v(C4406wh c4406wh) {
        this.b = c4406wh;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    public void w(int i, float f) {
    }

    public synchronized C0886cV x() {
        return (C0886cV) this.b;
    }

    public C3436kS z(JSONObject jSONObject) {
        InterfaceC3990rS c4227uS;
        int i = jSONObject.getInt("settings_version");
        if (i != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.", null);
            c4227uS = new C0756ar(14);
        } else {
            c4227uS = new C4227uS(0);
        }
        return c4227uS.i((C4305vR) this.b, jSONObject);
    }

    public /* synthetic */ C2882dV(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public C2882dV(C3532le c3532le) {
        this.a = 9;
        AbstractC0763ay.a(c3532le, "output");
        this.b = c3532le;
        c3532le.o = this;
    }

    public C2882dV(int i) {
        Handler handler;
        Handler handler2;
        this.a = i;
        switch (i) {
            case 12:
                Looper mainLooper = Looper.getMainLooper();
                if (Build.VERSION.SDK_INT >= 28) {
                    handler2 = AbstractC0072Ck.b(mainLooper);
                } else {
                    try {
                        handler = (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(mainLooper, null, Boolean.TRUE);
                    } catch (IllegalAccessException e) {
                        e = e;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                        handler2 = handler;
                        this.b = handler2;
                        return;
                    } catch (InstantiationException e2) {
                        e = e2;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                        handler2 = handler;
                        this.b = handler2;
                        return;
                    } catch (NoSuchMethodException e3) {
                        e = e3;
                        Log.w("HandlerCompat", "Unable to invoke Handler(Looper, Callback, boolean) constructor", e);
                        handler = new Handler(mainLooper);
                        handler2 = handler;
                        this.b = handler2;
                        return;
                    } catch (InvocationTargetException e4) {
                        Throwable cause = e4.getCause();
                        if (!(cause instanceof RuntimeException)) {
                            if (cause instanceof Error) {
                                throw ((Error) cause);
                            }
                            throw new RuntimeException(cause);
                        }
                        throw ((RuntimeException) cause);
                    }
                    handler2 = handler;
                }
                this.b = handler2;
                return;
            default:
                RL rl = RL.c;
                Object obj = d;
                try {
                    obj = (GF) Class.forName("androidx.datastore.preferences.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                } catch (Exception unused) {
                }
                GF[] gfArr = {C0108Du.b, obj};
                OD od = new OD();
                od.a = gfArr;
                Charset charset = AbstractC0763ay.a;
                this.b = od;
                return;
        }
    }

    public C2882dV(CallableC4011rh callableC4011rh, String str) {
        this.a = 11;
        this.b = callableC4011rh;
    }

    public C2882dV(ContentInfo contentInfo) {
        this.a = 10;
        contentInfo.getClass();
        this.b = AbstractC2966ea.p(contentInfo);
    }
}
