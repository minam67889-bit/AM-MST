package defpackage;

import android.R;
import android.content.Context;
import android.content.IntentSender;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.FrameLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.SnackbarContentLayout;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.utils.PUtils;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: ex, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2996ex implements DB {
    public static C2996ex i;
    public final VPNClient a;
    public final AppUpdateManager b;
    public VPNClient e;
    public MT f;
    public final C2916dx h;
    public String c = "An update has just been downloaded.";
    public String d = "RESTART";
    public final C2835cv g = new C2835cv(20);

    public C2996ex(VPNClient vPNClient) {
        C2916dx c2916dx = new C2916dx(this);
        this.h = c2916dx;
        this.a = vPNClient;
        g();
        this.b = AppUpdateManagerFactory.create(vPNClient);
        vPNClient.getLifecycle().a(this);
        this.b.registerListener(c2916dx);
        this.b.getAppUpdateInfo().addOnSuccessListener(new C0270Ka((Object) this, false));
    }

    public static void a(C2996ex c2996ex) {
        InstallState installState;
        VPNClient vPNClient = c2996ex.e;
        if (vPNClient == null || (installState = (InstallState) c2996ex.g.b) == null || installState.installStatus() != 11) {
            return;
        }
        vPNClient.getApplicationContext();
        int i2 = F00.a;
        PUtils.killProcess();
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0042, code lost:
    
        if (r7.isTouchExplorationEnabled() != false) goto L9;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x004a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void c(C2996ex c2996ex) {
        c2996ex.getClass();
        MT mt = c2996ex.f;
        if (mt != null && mt.b()) {
            c2996ex.f.a(3);
        }
        MT mt2 = c2996ex.f;
        mt2.getClass();
        NX f = NX.f();
        int i2 = mt2.k;
        boolean z = false;
        if (i2 != -2) {
            int i3 = Build.VERSION.SDK_INT;
            AccessibilityManager accessibilityManager = mt2.A;
            if (i3 >= 29) {
                i2 = accessibilityManager.getRecommendedTimeoutMillis(i2, 3 | (mt2.B ? 4 : 0));
            } else if (mt2.B) {
            }
            C3683na c3683na = mt2.t;
            synchronized (f.a) {
                try {
                    if (f.i(c3683na)) {
                        OT ot = (OT) f.c;
                        ot.b = i2;
                        ((Handler) f.b).removeCallbacksAndMessages(ot);
                        f.q((OT) f.c);
                        return;
                    }
                    OT ot2 = (OT) f.d;
                    if (ot2 != null && ot2.a.get() == c3683na) {
                        z = true;
                    }
                    if (z) {
                        ((OT) f.d).b = i2;
                    } else {
                        f.d = new OT(i2, c3683na);
                    }
                    OT ot3 = (OT) f.c;
                    if (ot3 == null || !f.c(ot3, 4)) {
                        f.c = null;
                        f.u();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        i2 = -2;
        C3683na c3683na2 = mt2.t;
        synchronized (f.a) {
        }
    }

    public static void e(C2996ex c2996ex, AppUpdateInfo appUpdateInfo) {
        c2996ex.getClass();
        try {
            c2996ex.b.startUpdateFlowForResult(appUpdateInfo, 1, c2996ex.a, 530);
        } catch (IntentSender.SendIntentException e) {
            Log.e("InAppUpdateManager", "error in startAppUpdateImmediate", e);
            VPNClient vPNClient = c2996ex.e;
            if (vPNClient != null) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-68375211243403L));
            }
        }
    }

    public final void g() {
        ViewGroup viewGroup;
        int i2 = 0;
        View findViewById = this.a.getWindow().getDecorView().findViewById(R.id.content);
        String str = this.c;
        int[] iArr = MT.C;
        ViewGroup viewGroup2 = null;
        while (true) {
            if (findViewById instanceof CoordinatorLayout) {
                viewGroup = (ViewGroup) findViewById;
                break;
            }
            if (findViewById instanceof FrameLayout) {
                if (findViewById.getId() == 16908290) {
                    viewGroup = (ViewGroup) findViewById;
                    break;
                }
                viewGroup2 = (ViewGroup) findViewById;
            }
            if (findViewById != null) {
                Object parent = findViewById.getParent();
                findViewById = parent instanceof View ? (View) parent : null;
            }
            if (findViewById == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        Context context = viewGroup.getContext();
        LayoutInflater from = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(MT.C);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate((resourceId == -1 || resourceId2 == -1) ? dastan.prince.bdfreevpn.R.layout.design_layout_snackbar_include : dastan.prince.bdfreevpn.R.layout.mtrl_layout_snackbar_include, viewGroup, false);
        MT mt = new MT(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
        AbstractC3841pa abstractC3841pa = mt.i;
        ((SnackbarContentLayout) abstractC3841pa.getChildAt(0)).getMessageView().setText(str);
        mt.k = -2;
        this.f = mt;
        String str2 = this.d;
        ViewOnClickListenerC2840d viewOnClickListenerC2840d = new ViewOnClickListenerC2840d(this, 5);
        Button actionView = ((SnackbarContentLayout) abstractC3841pa.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(str2)) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            mt.B = false;
        } else {
            mt.B = true;
            actionView.setVisibility(0);
            actionView.setText(str2);
            actionView.setOnClickListener(new LT(i2, mt, viewOnClickListenerC2840d));
        }
    }

    @InterfaceC3109gJ(EnumC4447xB.ON_DESTROY)
    public void onDestroy() {
        AppUpdateManager appUpdateManager = this.b;
        if (appUpdateManager != null) {
            appUpdateManager.unregisterListener(this.h);
        }
    }

    @InterfaceC3109gJ(EnumC4447xB.ON_RESUME)
    public void onResume() {
        this.b.getAppUpdateInfo().addOnSuccessListener(new C2882dV(this, 19));
    }
}
