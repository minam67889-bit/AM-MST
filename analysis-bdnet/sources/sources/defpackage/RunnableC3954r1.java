package defpackage;

import ads_mobile_sdk.et0;
import ads_mobile_sdk.fb0;
import ads_mobile_sdk.fh2;
import ads_mobile_sdk.ft0;
import ads_mobile_sdk.gt0;
import ads_mobile_sdk.h02;
import ads_mobile_sdk.jt1;
import ads_mobile_sdk.ls0;
import ads_mobile_sdk.mc1;
import ads_mobile_sdk.ni1;
import ads_mobile_sdk.qq2;
import ads_mobile_sdk.uc1;
import ads_mobile_sdk.vb3;
import ads_mobile_sdk.yv;
import ads_mobile_sdk.zv;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.webkit.WebViewCompat;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.carousel.CarouselLayoutManager;
import com.google.android.material.sidesheet.SideSheetBehavior;
import com.google.android.material.textfield.TextInputLayout;
import dastan.prince.bdfreevpn.R;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.nio.MappedByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import org.chromium.net.impl.JavaUploadDataSinkBase;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNApplication;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.TunnelUtils;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: r1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC3954r1 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ RunnableC3954r1(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    private final void a() {
        C3164h2 c3164h2 = (C3164h2) this.b;
        synchronized (((ArrayDeque) c3164h2.e)) {
            SharedPreferences.Editor edit = ((SharedPreferences) c3164h2.b).edit();
            String str = (String) c3164h2.c;
            StringBuilder sb = new StringBuilder();
            Iterator it = ((ArrayDeque) c3164h2.e).iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
                sb.append((String) c3164h2.d);
            }
            edit.putString(str, sb.toString()).apply();
        }
    }

    private final void b() {
        C0148Fi c0148Fi = (C0148Fi) this.b;
        Map map = null;
        ((AtomicReference) c0148Fi.c).set(null);
        synchronized (c0148Fi) {
            if (((AtomicMarkableReference) c0148Fi.b).isMarked()) {
                C4130tA c4130tA = (C4130tA) ((AtomicMarkableReference) c0148Fi.b).getReference();
                synchronized (c4130tA) {
                    map = Collections.unmodifiableMap(new HashMap(c4130tA.a));
                }
                AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) c0148Fi.b;
                atomicMarkableReference.set((C4130tA) atomicMarkableReference.getReference(), false);
            }
        }
        if (map != null) {
            C4548yX c4548yX = (C4548yX) c0148Fi.d;
            ((C0712aG) c4548yX.a).h((String) c4548yX.c, map, c0148Fi.a);
        }
    }

    private final void c() {
        Object obj;
        VPNApplication vPNApplication = (VPNApplication) this.b;
        int i = VPNApplication.e;
        String string = Deobfuscator$BDNETVPN$app.getString(-17402539374475L);
        AbstractC3634my.g(string, "applicationId");
        Bundle bundle = new Bundle();
        EnumC3512lO enumC3512lO = EnumC3512lO.b;
        EnumC3592mO enumC3592mO = EnumC3592mO.b;
        C3671nO c3671nO = new C3671nO(EnumC3352jO.b, new ArrayList(new C4122t6(new String[]{"B3EEABB8EE11C2BE770B684D95219ECB"}, true)), EnumC3432kO.b);
        C3712nx c3712nx = new C3712nx(string, c3671nO, bundle);
        I00 i00 = new I00();
        Context applicationContext = vPNApplication.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            throw new IllegalArgumentException("The provided application context is not an instance of Application. The Google Mobile Ads SDK should not be used from contexts like BroadcastReceivers, only Services and Activities.");
        }
        ni1 ni1Var = gt0.a;
        if (!ni1Var.b()) {
            int i2 = zv.k;
            int i3 = C3859pm.d;
            XE.r(AbstractC0538Uj.a(new C0834bp(new yv(new ThreadPoolExecutor(1, 1, C3859pm.k(0L, EnumC4016rm.e), TimeUnit.SECONDS, new LinkedBlockingQueue(), new vb3(null, "WebView"))))), null, new et0(applicationContext, null), 3);
        }
        gt0.b = false;
        ft0 ft0Var = new ft0(vPNApplication, applicationContext, c3712nx);
        synchronized (ni1Var) {
            try {
                if (ni1Var.a == null) {
                    ni1Var.a = ft0Var.invoke();
                }
                obj = ni1Var.a;
                if (obj == null) {
                    AbstractC3634my.K("backingField");
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        fb0 fb0Var = (fb0) obj;
        ((qq2) fb0Var.a1.get()).a(c3671nO);
        uc1 uc1Var = (uc1) fb0Var.T2.get();
        uc1Var.getClass();
        XE.u(C0912co.a, new mc1(uc1Var, i00, null));
        synchronized (AbstractC0731aZ.f) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03f1  */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [android.os.Handler] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        Object obj;
        Handler handler;
        Application application;
        long j;
        long j2;
        boolean z;
        int i;
        boolean z2;
        SocksDNSService socksDNSService;
        int i2 = 2;
        boolean z3 = false;
        boolean z4 = true;
        switch (this.a) {
            case 0:
                Activity activity = (Activity) this.b;
                if (activity.isFinishing()) {
                    return;
                }
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 28) {
                    Class cls = AbstractC4191u1.a;
                    activity.recreate();
                    return;
                }
                Class cls2 = AbstractC4191u1.a;
                ?? r5 = 26;
                boolean z5 = i3 == 26 || i3 == 27;
                Method method = AbstractC4191u1.f;
                if ((!z5 || method != null) && (AbstractC4191u1.e != null || AbstractC4191u1.d != null)) {
                    try {
                        Object obj2 = AbstractC4191u1.c.get(activity);
                        if (obj2 != null && (obj = AbstractC4191u1.b.get(activity)) != null) {
                            Application application2 = activity.getApplication();
                            C4112t1 c4112t1 = new C4112t1(activity);
                            application2.registerActivityLifecycleCallbacks(c4112t1);
                            Handler handler2 = AbstractC4191u1.g;
                            ?? r6 = 1;
                            handler2.post(new RunnableC3320j1(c4112t1, obj2, true ? 1 : 0, false));
                            C4112t1 c4112t12 = (i3 == 26 || i3 == 27) ? 1 : null;
                            try {
                                if (c4112t12 != null) {
                                    try {
                                        Boolean bool = Boolean.FALSE;
                                        r5 = application2;
                                        r6 = handler2;
                                        c4112t12 = c4112t1;
                                        method.invoke(obj, obj2, null, null, 0, bool, null, null, bool, bool);
                                    } catch (Throwable th) {
                                        th = th;
                                        handler = handler2;
                                        application = application2;
                                        c4112t12 = c4112t1;
                                        handler.post(new RunnableC3320j1(application, c4112t12, i2, false));
                                        throw th;
                                    }
                                } else {
                                    r5 = application2;
                                    c4112t12 = c4112t1;
                                    r6 = handler2;
                                    activity.recreate();
                                }
                                r6.post(new RunnableC3320j1(r5, c4112t12, i2, false));
                                return;
                            } catch (Throwable th2) {
                                th = th2;
                                application = r5;
                                handler = r6;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                activity.recreate();
                return;
            case 1:
                C2882dV c2882dV = ((C4355w4) this.b).c;
                c2882dV.getClass();
                long uptimeMillis = SystemClock.uptimeMillis();
                C4355w4 c4355w4 = (C4355w4) c2882dV.b;
                c4355w4.getClass();
                long uptimeMillis2 = SystemClock.uptimeMillis();
                int i4 = 0;
                while (true) {
                    ArrayList arrayList = c4355w4.b;
                    if (i4 >= arrayList.size()) {
                        if (c4355w4.f) {
                            for (int size = arrayList.size() - 1; size >= 0; size--) {
                                if (arrayList.get(size) == null) {
                                    arrayList.remove(size);
                                }
                            }
                            if (arrayList.size() == 0 && Build.VERSION.SDK_INT >= 33) {
                                ML ml = c4355w4.h;
                                ValueAnimator.unregisterDurationScaleChangeListener((C4197u4) ml.b);
                                ml.b = null;
                            }
                            c4355w4.f = false;
                        }
                        if (arrayList.size() > 0) {
                            ML ml2 = c4355w4.e;
                            ml2.getClass();
                            ((Choreographer) ml2.b).postFrameCallback(new ChoreographerFrameCallbackC4276v4(c4355w4.d));
                            return;
                        }
                        return;
                    }
                    C3598mU c3598mU = (C3598mU) arrayList.get(i4);
                    if (c3598mU == null) {
                        z2 = z4;
                        j = uptimeMillis;
                        j2 = uptimeMillis2;
                    } else {
                        C4386wT c4386wT = c4355w4.a;
                        Long l = (Long) c4386wT.get(c3598mU);
                        if (l != null) {
                            if (l.longValue() < uptimeMillis2) {
                                c4386wT.remove(c3598mU);
                            } else {
                                j = uptimeMillis;
                                j2 = uptimeMillis2;
                                z2 = z4;
                            }
                        }
                        long j3 = c3598mU.f;
                        if (j3 == 0) {
                            c3598mU.f = uptimeMillis;
                            c3598mU.c(c3598mU.b);
                            j = uptimeMillis;
                            j2 = uptimeMillis2;
                        } else {
                            long j4 = uptimeMillis - j3;
                            c3598mU.f = uptimeMillis;
                            float f = C3598mU.b().g;
                            long j5 = f == 0.0f ? 2147483647L : (long) (j4 / f);
                            if (c3598mU.l) {
                                float f2 = c3598mU.k;
                                if (f2 != Float.MAX_VALUE) {
                                    j = uptimeMillis;
                                    c3598mU.j.i = f2;
                                    c3598mU.k = Float.MAX_VALUE;
                                } else {
                                    j = uptimeMillis;
                                }
                                c3598mU.b = (float) c3598mU.j.i;
                                c3598mU.a = 0.0f;
                                c3598mU.l = z3;
                                j2 = uptimeMillis2;
                            } else {
                                j = uptimeMillis;
                                if (c3598mU.k != Float.MAX_VALUE) {
                                    long j6 = j5 / 2;
                                    C4174tm a = c3598mU.j.a(c3598mU.b, c3598mU.a, j6);
                                    C3677nU c3677nU = c3598mU.j;
                                    c3677nU.i = c3598mU.k;
                                    c3598mU.k = Float.MAX_VALUE;
                                    C4174tm a2 = c3677nU.a(a.a, a.b, j6);
                                    c3598mU.b = a2.a;
                                    c3598mU.a = a2.b;
                                    j2 = uptimeMillis2;
                                } else {
                                    j2 = uptimeMillis2;
                                    C4174tm a3 = c3598mU.j.a(c3598mU.b, c3598mU.a, j5);
                                    c3598mU.b = a3.a;
                                    c3598mU.a = a3.b;
                                }
                                float max = Math.max(c3598mU.b, -3.4028235E38f);
                                c3598mU.b = max;
                                c3598mU.b = Math.min(max, Float.MAX_VALUE);
                                float f3 = c3598mU.a;
                                C3677nU c3677nU2 = c3598mU.j;
                                c3677nU2.getClass();
                                if (Math.abs(f3) >= c3677nU2.e || Math.abs(r0 - ((float) c3677nU2.i)) >= c3677nU2.d) {
                                    z = false;
                                    float min = Math.min(c3598mU.b, Float.MAX_VALUE);
                                    c3598mU.b = min;
                                    float max2 = Math.max(min, -3.4028235E38f);
                                    c3598mU.b = max2;
                                    c3598mU.c(max2);
                                    if (z) {
                                        c3598mU.e = false;
                                        C4355w4 b = C3598mU.b();
                                        b.a.remove(c3598mU);
                                        ArrayList arrayList2 = b.b;
                                        int indexOf = arrayList2.indexOf(c3598mU);
                                        if (indexOf >= 0) {
                                            arrayList2.set(indexOf, null);
                                            i = 1;
                                            b.f = true;
                                        } else {
                                            i = 1;
                                        }
                                        c3598mU.f = 0L;
                                        int i5 = 0;
                                        while (true) {
                                            ArrayList arrayList3 = c3598mU.h;
                                            if (i5 >= arrayList3.size()) {
                                                for (int size2 = arrayList3.size() - i; size2 >= 0; size2--) {
                                                    if (arrayList3.get(size2) == null) {
                                                        arrayList3.remove(size2);
                                                    }
                                                }
                                            } else {
                                                if (arrayList3.get(i5) != null) {
                                                    arrayList3.get(i5).getClass();
                                                    throw new ClassCastException();
                                                }
                                                i5 += i;
                                            }
                                        }
                                    }
                                } else {
                                    c3598mU.b = (float) c3598mU.j.i;
                                    c3598mU.a = 0.0f;
                                }
                            }
                            z = true;
                            float min2 = Math.min(c3598mU.b, Float.MAX_VALUE);
                            c3598mU.b = min2;
                            float max22 = Math.max(min2, -3.4028235E38f);
                            c3598mU.b = max22;
                            c3598mU.c(max22);
                            if (z) {
                            }
                        }
                        z2 = true;
                    }
                    i4++;
                    z4 = z2;
                    uptimeMillis = j;
                    uptimeMillis2 = j2;
                    z3 = false;
                }
                break;
            case 2:
                ((CarouselLayoutManager) this.b).m0();
                return;
            case 3:
                ((C0273Kd) this.b).t(true);
                return;
            case 4:
                ViewTreeObserverOnDrawListenerC3851pf viewTreeObserverOnDrawListenerC3851pf = (ViewTreeObserverOnDrawListenerC3851pf) this.b;
                Runnable runnable = viewTreeObserverOnDrawListenerC3851pf.b;
                if (runnable != null) {
                    runnable.run();
                    viewTreeObserverOnDrawListenerC3851pf.b = null;
                    return;
                }
                return;
            case 5:
                DialogC4403wf.a((DialogC4403wf) this.b);
                return;
            case 6:
                C3780om c3780om = (C3780om) this.b;
                boolean isPopupShowing = c3780om.h.isPopupShowing();
                c3780om.t(isPopupShowing);
                c3780om.m = isPopupShowing;
                return;
            case 7:
                C4259us c4259us = (C4259us) this.b;
                synchronized (c4259us.d) {
                    try {
                        if (c4259us.h == null) {
                            return;
                        }
                        try {
                            C0132Es c = c4259us.c();
                            int i6 = c.f;
                            if (i6 == 2) {
                                synchronized (c4259us.d) {
                                }
                            }
                            if (i6 != 0) {
                                throw new RuntimeException("fetchFonts result is not OK. (" + i6 + ")");
                            }
                            try {
                                int i7 = MX.a;
                                Trace.beginSection("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                                C4254un c4254un = c4259us.c;
                                Context context = c4259us.a;
                                c4254un.getClass();
                                C0132Es[] c0132EsArr = {c};
                                AbstractC0199Hh abstractC0199Hh = AbstractC0890cZ.a;
                                AbstractC3131gc0.f("TypefaceCompat.createFromFontInfo");
                                try {
                                    Typeface B = AbstractC0890cZ.a.B(context, c0132EsArr, 0);
                                    Trace.endSection();
                                    MappedByteBuffer F = AbstractC0641Yi.F(c4259us.a, c.a);
                                    if (F == null || B == null) {
                                        throw new RuntimeException("Unable to open file.");
                                    }
                                    try {
                                        Trace.beginSection("EmojiCompat.MetadataRepo.create");
                                        NX nx = new NX(B, AbstractC0538Uj.I(F));
                                        Trace.endSection();
                                        synchronized (c4259us.d) {
                                            try {
                                                AbstractC0325Me abstractC0325Me = c4259us.h;
                                                if (abstractC0325Me != null) {
                                                    abstractC0325Me.O(nx);
                                                }
                                            } finally {
                                            }
                                        }
                                        c4259us.b();
                                        return;
                                    } finally {
                                        int i8 = MX.a;
                                    }
                                } finally {
                                    Trace.endSection();
                                }
                            } finally {
                            }
                        } catch (Throwable th3) {
                            synchronized (c4259us.d) {
                                try {
                                    AbstractC0325Me abstractC0325Me2 = c4259us.h;
                                    if (abstractC0325Me2 != null) {
                                        abstractC0325Me2.N(th3);
                                    }
                                    c4259us.b();
                                    return;
                                } finally {
                                }
                            }
                        }
                    } finally {
                    }
                }
            case 8:
                ((JavaUploadDataSinkBase) this.b).lambda$readFromProvider$2();
                return;
            case 9:
                MaterialButton.a((MaterialButton) this.b);
                return;
            case 10:
                C4062sL c4062sL = (C4062sL) this.b;
                int i9 = c4062sL.b;
                HB hb = c4062sL.f;
                if (i9 == 0) {
                    c4062sL.c = true;
                    hb.e(EnumC4447xB.ON_PAUSE);
                }
                if (c4062sL.a == 0 && c4062sL.c) {
                    hb.e(EnumC4447xB.ON_STOP);
                    c4062sL.d = true;
                    return;
                }
                return;
            case 11:
                ((HM) this.b).m();
                return;
            case 12:
                a();
                return;
            case 13:
                C0347Na c0347Na = (C0347Na) this.b;
                c0347Na.c = false;
                SideSheetBehavior sideSheetBehavior = (SideSheetBehavior) c0347Na.e;
                C3165h20 c3165h20 = sideSheetBehavior.i;
                if (c3165h20 != null && c3165h20.g()) {
                    c0347Na.a(c0347Na.b);
                    return;
                } else {
                    if (sideSheetBehavior.h == 2) {
                        sideSheetBehavior.s(c0347Na.b);
                        return;
                    }
                    return;
                }
            case 14:
                String str = SocksDNSService.B;
                ((SocksDNSService) this.b).d();
                return;
            case 15:
                int i10 = 0;
                while (true) {
                    socksDNSService = (SocksDNSService) ((TO) this.b).b;
                    if (!TunnelUtils.isNetworkOnline(socksDNSService.getApplicationContext()) && i10 < 60) {
                        SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-84945195071371L), Deobfuscator$BDNETVPN$app.getString(-84979554809739L));
                        SkStatus.logInfo(R.string.state_nonetwork, new Object[0]);
                        SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-85065454155659L));
                        try {
                            Thread.sleep(2000L);
                            i10 += 2;
                        } catch (InterruptedException unused2) {
                            return;
                        }
                    }
                }
                if (TunnelUtils.isNetworkOnline(socksDNSService.getApplicationContext())) {
                    VPNClient vPNClient = SocksDNSService.G;
                    if (vPNClient != null) {
                        vPNClient.restartSocksOpenVPN();
                        return;
                    }
                    return;
                }
                SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-85112698795915L));
                VPNClient vPNClient2 = SocksDNSService.G;
                if (vPNClient2 != null) {
                    vPNClient2.stopSocksOpenVPN();
                } else {
                    F00.h(socksDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-85168533370763L));
                }
                TunnelManagerHelper.stopSocksHttp(socksDNSService.getApplicationContext());
                return;
            case 16:
                ((TextInputLayout) this.b).e.requestLayout();
                return;
            case 17:
                b();
                return;
            case 18:
                c();
                return;
            case 19:
                View view = (View) this.b;
                ((InputMethodManager) view.getContext().getSystemService(InputMethodManager.class)).showSoftInput(view, 1);
                return;
            case 20:
                Uri uri = WebViewCompat.a;
                ((WebViewCompat.WebViewStartUpCallback) this.b).onSuccess(new RT(7));
                return;
            case 21:
                StringBuilder sb = new StringBuilder("Service took too long to process intent: ");
                M40 m40 = (M40) this.b;
                sb.append(m40.a.getAction());
                sb.append(" finishing.");
                Log.w("FirebaseMessaging", sb.toString());
                m40.b.trySetResult(null);
                return;
            case 22:
                Z40 z40 = (Z40) this.b;
                z40.getClass();
                ((TP) z40.d).i(new L40(z40));
                return;
            case 23:
                String str2 = XRayDNSService.z;
                ((XRayDNSService) this.b).e();
                return;
            case 24:
                ((fh2) this.b).c();
                return;
            case 25:
                ((h02) this.b).c();
                return;
            case 26:
                jt1.a((jt1) this.b);
                return;
            case 27:
                ((ls0) this.b).b();
                return;
            default:
                ((HttpURLConnection) this.b).disconnect();
                return;
        }
    }
}
