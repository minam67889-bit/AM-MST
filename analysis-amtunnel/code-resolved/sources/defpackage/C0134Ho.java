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

/* renamed from: Ho, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0134Ho implements InterfaceC2628fr {
    public static C0134Ho s;
    public final AbstractActivityC0513c2 a;
    public final AppUpdateManager b;
    public final int c;
    public InterfaceC0119Go o;
    public C3127pE p;
    public final C0104Fo r;
    public String d = "An update has just been downloaded.";
    public String e = "RESTART";
    public int f = 1;
    public boolean m = true;
    public boolean n = false;
    public final C3628yn q = new C3628yn(22, false);

    public C0134Ho(AbstractActivityC0513c2 abstractActivityC0513c2) {
        C0104Fo c0104Fo = new C0104Fo(this);
        this.r = c0104Fo;
        this.a = abstractActivityC0513c2;
        this.c = 530;
        k();
        this.b = AppUpdateManagerFactory.create(abstractActivityC0513c2);
        abstractActivityC0513c2.getLifecycle().a(this);
        if (this.f == 1) {
            this.b.registerListener(c0104Fo);
        }
        this.b.getAppUpdateInfo().addOnSuccessListener(new C3490w7((Object) this, false));
    }

    public static void d(C0134Ho c0134Ho) {
        InterfaceC0119Go interfaceC0119Go = c0134Ho.o;
        if (interfaceC0119Go != null) {
            UDPClient uDPClient = (UDPClient) interfaceC0119Go;
            InstallState installState = (InstallState) c0134Ho.q.b;
            if (installState == null || installState.installStatus() != 11) {
                return;
            }
            uDPClient.getApplicationContext();
            PUtils.killProcess();
        }
    }

    public static void i(C0134Ho c0134Ho) {
        if (c0134Ho.n) {
            return;
        }
        C3127pE c3127pE = c0134Ho.p;
        if (c3127pE != null && c3127pE.b()) {
            c0134Ho.p.a(3);
        }
        C3127pE c3127pE2 = c0134Ho.p;
        c3127pE2.getClass();
        DC e = DC.e();
        int i = c3127pE2.k;
        int i2 = -2;
        if (i != -2) {
            int i3 = Build.VERSION.SDK_INT;
            AccessibilityManager accessibilityManager = c3127pE2.A;
            if (i3 >= 29) {
                i2 = accessibilityManager.getRecommendedTimeoutMillis(i, 3 | (c3127pE2.B ? 4 : 0));
            } else {
                if (c3127pE2.B && accessibilityManager.isTouchExplorationEnabled()) {
                    i = -2;
                }
                i2 = i;
            }
        }
        C2487d7 c2487d7 = c3127pE2.t;
        synchronized (e.a) {
            try {
                if (e.i(c2487d7)) {
                    C3232rE c3232rE = (C3232rE) e.c;
                    c3232rE.b = i2;
                    ((Handler) e.b).removeCallbacksAndMessages(c3232rE);
                    e.l((C3232rE) e.c);
                } else {
                    C3232rE c3232rE2 = (C3232rE) e.d;
                    if (c3232rE2 == null || c2487d7 == null || c3232rE2.a.get() != c2487d7) {
                        e.d = new C3232rE(i2, c2487d7);
                    } else {
                        ((C3232rE) e.d).b = i2;
                    }
                    C3232rE c3232rE3 = (C3232rE) e.c;
                    if (c3232rE3 == null || !e.a(c3232rE3, 4)) {
                        e.c = null;
                        e.n();
                    }
                }
            } finally {
            }
        }
    }

    public static void j(C0134Ho c0134Ho, AppUpdateInfo appUpdateInfo) {
        c0134Ho.getClass();
        try {
            c0134Ho.b.startUpdateFlowForResult(appUpdateInfo, 1, c0134Ho.a, c0134Ho.c);
        } catch (IntentSender.SendIntentException e) {
            Log.e("InAppUpdateManager", "error in startAppUpdateImmediate", e);
            InterfaceC0119Go interfaceC0119Go = c0134Ho.o;
            if (interfaceC0119Go != null) {
                SweetToast.error(((UDPClient) interfaceC0119Go).getApplicationContext(), "#ERR IndexError: list index out of range");
            }
        }
    }

    public final void k() {
        ViewGroup viewGroup;
        View findViewById = this.a.getWindow().getDecorView().findViewById(R.id.content);
        String str = this.d;
        int[] iArr = C3127pE.C;
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
                findViewById = parent instanceof View ? (View) parent : null;
            }
            if (findViewById == null) {
                viewGroup = viewGroup2;
                break;
            }
        }
        viewGroup = (ViewGroup) findViewById;
        if (viewGroup == null) {
            throw new IllegalArgumentException("No suitable parent found from the given view. Please provide a valid view.");
        }
        Context context = viewGroup.getContext();
        LayoutInflater from = LayoutInflater.from(context);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(C3127pE.C);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        obtainStyledAttributes.recycle();
        SnackbarContentLayout snackbarContentLayout = (SnackbarContentLayout) from.inflate((resourceId == -1 || resourceId2 == -1) ? 2131558454 : 2131558529, viewGroup, false);
        final C3127pE c3127pE = new C3127pE(context, viewGroup, snackbarContentLayout, snackbarContentLayout);
        AbstractC2592f7 abstractC2592f7 = c3127pE.i;
        ((SnackbarContentLayout) abstractC2592f7.getChildAt(0)).getMessageView().setText(str);
        c3127pE.k = -2;
        this.p = c3127pE;
        String str2 = this.e;
        final ViewOnClickListenerC2901l0 viewOnClickListenerC2901l0 = new ViewOnClickListenerC2901l0(this, 2);
        Button actionView = ((SnackbarContentLayout) abstractC2592f7.getChildAt(0)).getActionView();
        if (TextUtils.isEmpty(str2)) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
            c3127pE.B = false;
        } else {
            c3127pE.B = true;
            actionView.setVisibility(0);
            actionView.setText(str2);
            actionView.setOnClickListener(new View.OnClickListener() { // from class: oE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    C3127pE c3127pE2 = C3127pE.this;
                    c3127pE2.getClass();
                    viewOnClickListenerC2901l0.onClick(view);
                    c3127pE2.a(1);
                }
            });
        }
    }

    @Cw(Zq.ON_DESTROY)
    public void onDestroy() {
        C0104Fo c0104Fo;
        AppUpdateManager appUpdateManager = this.b;
        if (appUpdateManager == null || (c0104Fo = this.r) == null) {
            return;
        }
        appUpdateManager.unregisterListener(c0104Fo);
    }

    @Cw(Zq.ON_RESUME)
    public void onResume() {
        if (this.m) {
            this.b.getAppUpdateInfo().addOnSuccessListener(new C3417uo(this, 22));
        }
    }
}
