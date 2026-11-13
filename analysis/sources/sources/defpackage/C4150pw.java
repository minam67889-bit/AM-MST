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
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.utils.PUtils;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: pw, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4150pw implements PA {
    public static C4150pw m;
    public final AbstractActivityC4701x4 a;
    public final AppUpdateManager b;
    public final int c;
    public InterfaceC4073ow i;
    public US j;
    public final C3996nw l;
    public String d = "An update has just been downloaded.";
    public String e = "RESTART";
    public int f = 1;
    public boolean g = true;
    public boolean h = false;
    public final C0338Mk k = new C0338Mk();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C4150pw(AbstractActivityC4701x4 abstractActivityC4701x4) {
        boolean z = false;
        C3996nw c3996nw = new C3996nw(this);
        this.l = c3996nw;
        this.a = abstractActivityC4701x4;
        this.c = 530;
        d();
        this.b = AppUpdateManagerFactory.create(abstractActivityC4701x4);
        abstractActivityC4701x4.getLifecycle().a(this);
        if (this.f == 1) {
            this.b.registerListener(c3996nw);
        }
        this.b.getAppUpdateInfo().addOnSuccessListener(new C4431ta(this, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(C4150pw c4150pw) {
        UDPClient uDPClient = c4150pw.i;
        if (uDPClient != null) {
            UDPClient uDPClient2 = uDPClient;
            InstallState installState = (InstallState) c4150pw.k.a;
            if (installState != null && installState.installStatus() == 11) {
                uDPClient2.getApplicationContext();
                PUtils.killProcess();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void b(C4150pw c4150pw) {
        int i;
        if (!c4150pw.h) {
            US us = c4150pw.j;
            if (us != null && us.b()) {
                c4150pw.j.a(3);
            }
            US us2 = c4150pw.j;
            us2.getClass();
            MQ h = MQ.h();
            int i2 = us2.k;
            int i3 = -2;
            if (i2 != -2) {
                int i4 = Build.VERSION.SDK_INT;
                AccessibilityManager accessibilityManager = us2.A;
                if (i4 >= 29) {
                    if (us2.B) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                    i3 = accessibilityManager.getRecommendedTimeoutMillis(i2, 3 | i);
                } else {
                    if (us2.B && accessibilityManager.isTouchExplorationEnabled()) {
                        i2 = -2;
                    }
                    i3 = i2;
                }
            }
            W9 w9 = us2.t;
            synchronized (h.b) {
                try {
                    if (h.l(w9)) {
                        WS ws = (WS) h.d;
                        ws.b = i3;
                        ((Handler) h.c).removeCallbacksAndMessages(ws);
                        h.u((WS) h.d);
                    } else {
                        WS ws2 = (WS) h.e;
                        if (ws2 != null && w9 != null && ws2.a.get() == w9) {
                            ((WS) h.e).b = i3;
                        } else {
                            h.e = new WS(i3, w9);
                        }
                        WS ws3 = (WS) h.d;
                        if (ws3 == null || !h.b(ws3, 4)) {
                            h.d = null;
                            h.z();
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void c(C4150pw c4150pw, AppUpdateInfo appUpdateInfo) {
        c4150pw.getClass();
        try {
            c4150pw.b.startUpdateFlowForResult(appUpdateInfo, 1, c4150pw.a, c4150pw.c);
        } catch (IntentSender.SendIntentException e) {
            Log.e("InAppUpdateManager", "error in startAppUpdateImmediate", e);
            UDPClient uDPClient = c4150pw.i;
            if (uDPClient != null) {
                SweetToast.error(uDPClient.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-146572885167777L));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d() {
        ViewGroup viewGroup;
        int i;
        View findViewById = this.a.getWindow().getDecorView().findViewById(R.id.content);
        String str = this.d;
        int[] iArr = US.C;
        ViewGroup viewGroup2 = null;
        while (!(findViewById instanceof CoordinatorLayout)) {
            if (findViewById instanceof FrameLayout) {
                if (findViewById.getId() == 16908290) {
                    break;
                } else {
                    viewGroup2 = (ViewGroup) findViewById;
                }
            }
            if (findViewById != null) {
                Object parent = findViewById.getParent();
                if (parent instanceof View) {
                    findViewById = (View) parent;
                } else {
                    findViewById = null;
                }
            }
            if (findViewById == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        viewGroup = (ViewGroup) findViewById;
        if (viewGroup != null) {
            Context context = viewGroup.getContext();
            LayoutInflater from = LayoutInflater.from(context);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(US.C);
            int resourceId = obtainStyledAttributes.getResourceId(0, -1);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
            obtainStyledAttributes.recycle();
            if (resourceId != -1 && resourceId2 != -1) {
                i = app.vpn.amtunnellite.R.layout.mtrl_layout_snackbar_include;
            } else {
                i = app.vpn.amtunnellite.R.layout.design_layout_snackbar_include;
            }
            SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate(i, viewGroup, false);
            final US us = new US(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
            Y9 y9 = us.i;
            ((SnackbarContentLayout) y9.getChildAt(0)).getMessageView().setText(str);
            us.k = -2;
            this.j = us;
            String str2 = this.e;
            final T0 t0 = new T0(this, 2);
            Button actionView = ((SnackbarContentLayout) y9.getChildAt(0)).getActionView();
            if (!TextUtils.isEmpty(str2)) {
                us.B = true;
                actionView.setVisibility(0);
                actionView.setText(str2);
                actionView.setOnClickListener(new View.OnClickListener() { // from class: TS
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        US us2 = US.this;
                        us2.getClass();
                        t0.onClick(view);
                        us2.a(1);
                    }
                });
                return;
            }
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            us.B = false;
            return;
        }
        throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @InterfaceC3415gI(JA.ON_DESTROY)
    public void onDestroy() {
        C3996nw c3996nw;
        AppUpdateManager appUpdateManager = this.b;
        if (appUpdateManager != null && (c3996nw = this.l) != null) {
            appUpdateManager.unregisterListener(c3996nw);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @InterfaceC3415gI(JA.ON_RESUME)
    public void onResume() {
        if (this.g) {
            this.b.getAppUpdateInfo().addOnSuccessListener(new C0338Mk(this));
        }
    }
}
