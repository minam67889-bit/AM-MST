package defpackage;

import android.content.ClipData;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContentInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.g;
import androidx.fragment.app.l;
import androidx.fragment.app.t;
import androidx.fragment.app.x;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.MissingFormatArgumentException;
import java.util.Set;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.PDoQService;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.logger.SkStatus;
import prince.udp.vpn.utils.PUtils;

/* renamed from: yn, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3628yn implements InterfaceC2684gu, InterfaceC3116p3, InterfaceC3484w1, A7, Tt, InterfaceC0316Ub, InterfaceC3431v1, InterfaceC2949lw, MediaViewListener, InterfaceC2780il, InterfaceC0550cn, N0, InterfaceC2916lF, InterfaceC3057ny, InterfaceC2500dK {
    public static volatile C3628yn c;
    public static final DK d = new Object();
    public final /* synthetic */ int a;
    public Object b;

    public C3628yn(int i) {
        this.a = i;
        switch (i) {
            case 5:
                this.b = new AtomicInteger(0);
                return;
            case 13:
                this.b = new WE(WI.b);
                return;
            default:
                this.b = new HashSet();
                return;
        }
    }

    public /* synthetic */ C3628yn(int i, boolean z) {
        this.a = i;
    }

    public C3628yn(EK ek, BK bk) {
        this.a = 1;
        AbstractC3365tp.q(ek, "store");
        C0123Hd c0123Hd = C0123Hd.b;
        this.a = 1;
        AbstractC3365tp.q(ek, "store");
        AbstractC3365tp.q(c0123Hd, "defaultCreationExtras");
        this.b = new DC(ek, bk, c0123Hd);
    }

    public C3628yn(Context context, Uri uri) {
        this.a = 18;
        this.b = context.getContentResolver().acquireUnstableContentProviderClient(uri);
    }

    public C3628yn(Bundle bundle) {
        this.a = 25;
        if (bundle == null) {
            throw new NullPointerException("data");
        }
        this.b = new Bundle(bundle);
    }

    public C3628yn(ContentInfo contentInfo) {
        this.a = 10;
        contentInfo.getClass();
        this.b = X6.k(contentInfo);
    }

    public /* synthetic */ C3628yn(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public static boolean J(Bundle bundle) {
        return "1".equals(bundle.getString("gcm.n.e")) || "1".equals(bundle.getString("gcm.n.e".replace("gcm.n.", "gcm.notification.")));
    }

    public static String N(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public static String P(String str) {
        return str.startsWith("gcm.n.") ? str.substring(6) : str;
    }

    public JSONArray A(String str) {
        String H = H(str);
        if (TextUtils.isEmpty(H)) {
            return null;
        }
        try {
            return new JSONArray(H);
        } catch (JSONException unused) {
            Log.w("NotificationParams", "Malformed JSON for key " + P(str) + ": " + H + ", falling back to default");
            return null;
        }
    }

    public int[] B() {
        String str;
        JSONArray A = A("gcm.n.light_settings");
        if (A == null) {
            return null;
        }
        int[] iArr = new int[3];
        try {
            if (A.length() != 3) {
                throw new JSONException("lightSettings don't have all three fields");
            }
            int parseColor = Color.parseColor(A.optString(0));
            if (parseColor == -16777216) {
                throw new IllegalArgumentException("Transparent color is invalid");
            }
            iArr[0] = parseColor;
            iArr[1] = A.optInt(1);
            iArr[2] = A.optInt(2);
            return iArr;
        } catch (IllegalArgumentException e) {
            str = "LightSettings is invalid: " + A + ". " + e.getMessage() + ". Skipping setting LightSettings";
            Log.w("NotificationParams", str);
            return null;
        } catch (JSONException unused) {
            str = "LightSettings is invalid: " + A + ". Skipping setting LightSettings";
            Log.w("NotificationParams", str);
            return null;
        }
    }

    public Object[] C(String str) {
        JSONArray A = A(str.concat("_loc_args"));
        if (A == null) {
            return null;
        }
        int length = A.length();
        String[] strArr = new String[length];
        for (int i = 0; i < length; i++) {
            strArr[i] = A.optString(i);
        }
        return strArr;
    }

    public String D(String str) {
        return H(str.concat("_loc_key"));
    }

    public Long E() {
        String H = H("gcm.n.event_time");
        if (TextUtils.isEmpty(H)) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(H));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + P("gcm.n.event_time") + "(" + H + ") into a long");
            return null;
        }
    }

    public String F(String str, Resources resources, String str2) {
        String H = H(str2);
        if (!TextUtils.isEmpty(H)) {
            return H;
        }
        String D = D(str2);
        if (TextUtils.isEmpty(D)) {
            return null;
        }
        int identifier = resources.getIdentifier(D, "string", str);
        if (identifier == 0) {
            Log.w("NotificationParams", P(str2.concat("_loc_key")) + " resource not found: " + str2 + " Default value will be used.");
            return null;
        }
        Object[] C = C(str2);
        if (C == null) {
            return resources.getString(identifier);
        }
        try {
            return resources.getString(identifier, C);
        } catch (MissingFormatArgumentException e) {
            Log.w("NotificationParams", "Missing format argument for " + P(str2) + ": " + Arrays.toString(C) + " Default value will be used.", e);
            return null;
        }
    }

    public Set G() {
        Set unmodifiableSet;
        synchronized (((HashSet) this.b)) {
            unmodifiableSet = Collections.unmodifiableSet((HashSet) this.b);
        }
        return unmodifiableSet;
    }

    public String H(String str) {
        Bundle bundle = (Bundle) this.b;
        if (!bundle.containsKey(str) && str.startsWith("gcm.n.")) {
            String replace = !str.startsWith("gcm.n.") ? str : str.replace("gcm.n.", "gcm.notification.");
            if (bundle.containsKey(replace)) {
                str = replace;
            }
        }
        return bundle.getString(str);
    }

    public long[] I() {
        JSONArray A = A("gcm.n.vibrate_timings");
        if (A == null) {
            return null;
        }
        try {
            if (A.length() <= 1) {
                throw new JSONException("vibrateTimings have invalid length");
            }
            int length = A.length();
            long[] jArr = new long[length];
            for (int i = 0; i < length; i++) {
                jArr[i] = A.optLong(i);
            }
            return jArr;
        } catch (NumberFormatException | JSONException unused) {
            Log.w("NotificationParams", "User defined vibrateTimings is invalid: " + A + ". Skipping setting vibrateTimings.");
            return null;
        }
    }

    public void K(View view) {
        if (view.getParent() != null) {
            view.setVisibility(8);
        }
        ((AbstractC2645g7) this.b).a(0);
    }

    public void L(C2801j6 c2801j6, Thread thread, Throwable th) {
        C0212Nc c0212Nc = (C0212Nc) this.b;
        synchronized (c0212Nc) {
            String str = "Handling uncaught exception \"" + th + "\" from thread " + thread.getName();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str, null);
            }
            AbstractC3192qa.G();
            try {
                FJ.a(((ExecutorC0029Bd) c0212Nc.e.b).b(new CallableC0182Lc(c0212Nc, System.currentTimeMillis(), th, thread, c2801j6)));
            } catch (TimeoutException unused) {
                Log.e("FirebaseCrashlytics", "Cannot send reports. Timed out while fetching settings.", null);
            } catch (Exception e) {
                Log.e("FirebaseCrashlytics", "Error handling uncaught exception", e);
            }
        }
    }

    public Bundle M() {
        Bundle bundle = (Bundle) this.b;
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle.keySet()) {
            if (!str.startsWith("google.c.a.") && !str.equals("from")) {
                bundle2.remove(str);
            }
        }
        return bundle2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0031, code lost:
    
        if (r7.a > r3.a) goto L16;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(defpackage.UE r7) {
        /*
            r6 = this;
            java.lang.String r0 = "newState"
            defpackage.AbstractC3365tp.q(r7, r0)
        L5:
            java.lang.Object r0 = r6.b
            WE r0 = (defpackage.WE) r0
            r0.getClass()
            Xh r1 = defpackage.AbstractC3090oe.i
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r2 = defpackage.WE.e
            java.lang.Object r2 = r2.get(r0)
            if (r2 != r1) goto L17
            r2 = 0
        L17:
            r3 = r2
            UE r3 = (defpackage.UE) r3
            boolean r4 = r3 instanceof defpackage.C3111oz
            if (r4 == 0) goto L20
            r4 = 1
            goto L26
        L20:
            WI r4 = defpackage.WI.b
            boolean r4 = defpackage.AbstractC3365tp.d(r3, r4)
        L26:
            if (r4 == 0) goto L29
            goto L33
        L29:
            boolean r4 = r3 instanceof defpackage.C2931le
            if (r4 == 0) goto L35
            int r4 = r3.a
            int r5 = r7.a
            if (r5 <= r4) goto L39
        L33:
            r3 = r7
            goto L39
        L35:
            boolean r4 = r3 instanceof defpackage.C0294Sj
            if (r4 == 0) goto L47
        L39:
            if (r2 != 0) goto L3c
            r2 = r1
        L3c:
            if (r3 != 0) goto L3f
            goto L40
        L3f:
            r1 = r3
        L40:
            boolean r0 = r0.e(r2, r1)
            if (r0 == 0) goto L5
            return
        L47:
            xa r7 = new xa
            r7.<init>()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C3628yn.O(UE):void");
    }

    @Override // defpackage.InterfaceC2684gu
    public void a(Mt mt, boolean z) {
        if (mt instanceof CF) {
            ((CF) mt).z.k().c(false);
        }
        InterfaceC2684gu interfaceC2684gu = ((A0) this.b).e;
        if (interfaceC2684gu != null) {
            interfaceC2684gu.a(mt, z);
        }
    }

    @Override // defpackage.InterfaceC0550cn
    public Object apply() {
        return (W0) this.b;
    }

    @Override // defpackage.InterfaceC0316Ub
    public ClipData b() {
        ClipData clip;
        clip = ((ContentInfo) this.b).getClip();
        return clip;
    }

    @Override // defpackage.InterfaceC2500dK
    public int c(View view) {
        Cz cz = (Cz) view.getLayoutParams();
        ((Bz) this.b).getClass();
        return (view.getLeft() - ((Cz) view.getLayoutParams()).b.left) - ((ViewGroup.MarginLayoutParams) cz).leftMargin;
    }

    @Override // defpackage.InterfaceC2780il
    public void close() {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.b;
        if (contentProviderClient != null) {
            contentProviderClient.release();
        }
    }

    @Override // defpackage.N0
    public void d(Object obj) {
        M0 m0 = (M0) obj;
        t tVar = (t) this.b;
        C0341Vl c0341Vl = (C0341Vl) tVar.C.pollFirst();
        if (c0341Vl == null) {
            Log.w("FragmentManager", "No Activities were started for result for " + this);
            return;
        }
        x xVar = tVar.c;
        String str = c0341Vl.a;
        l c2 = xVar.c(str);
        if (c2 != null) {
            c2.onActivityResult(c0341Vl.b, m0.a, m0.b);
        } else {
            Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str);
        }
    }

    @Override // defpackage.Tt
    public void e(Mt mt, MenuItem menuItem) {
        ((C8) this.b).m.removeCallbacksAndMessages(mt);
    }

    @Override // defpackage.InterfaceC2500dK
    public int f() {
        return ((Bz) this.b).E();
    }

    @Override // defpackage.A7
    public void g(C0257Qc c0257Qc) {
        this.b = c0257Qc;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    @Override // defpackage.InterfaceC2780il
    public Cursor h(Uri uri, String[] strArr, String[] strArr2) {
        ContentProviderClient contentProviderClient = (ContentProviderClient) this.b;
        if (contentProviderClient == null) {
            return null;
        }
        try {
            return contentProviderClient.query(uri, strArr, "query = ?", strArr2, null, null);
        } catch (RemoteException e) {
            Log.w("FontsProvider", "Unable to query the content provider", e);
            return null;
        }
    }

    public void i(int i) {
    }

    @Override // defpackage.InterfaceC2500dK
    public int j() {
        Bz bz = (Bz) this.b;
        return bz.n - bz.F();
    }

    @Override // defpackage.InterfaceC3484w1
    public void k(Bundle bundle, String str) {
        C0257Qc c0257Qc = (C0257Qc) this.b;
        if (c0257Qc != null) {
            try {
                String str2 = "$A$:" + N(bundle, str);
                C0287Sc c0287Sc = c0257Qc.a;
                c0287Sc.getClass();
                ((ExecutorC0029Bd) c0287Sc.o.b).a(new RunnableC0272Rc(c0287Sc, System.currentTimeMillis() - c0287Sc.d, str2, 0));
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override // defpackage.Tt
    public void l(Mt mt, Ut ut) {
        C8 c8 = (C8) this.b;
        c8.m.removeCallbacksAndMessages(null);
        ArrayList arrayList = c8.o;
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            } else if (mt == ((B8) arrayList.get(i)).b) {
                break;
            } else {
                i++;
            }
        }
        if (i == -1) {
            return;
        }
        int i2 = i + 1;
        c8.m.postAtTime(new A8(this, i2 < arrayList.size() ? (B8) arrayList.get(i2) : null, ut, mt, 0), mt, SystemClock.uptimeMillis() + 200);
    }

    @Override // defpackage.InterfaceC0316Ub
    public int m() {
        int flags;
        flags = ((ContentInfo) this.b).getFlags();
        return flags;
    }

    @Override // defpackage.InterfaceC0316Ub
    public ContentInfo n() {
        return (ContentInfo) this.b;
    }

    @Override // defpackage.InterfaceC2500dK
    public View o(int i) {
        return ((Bz) this.b).u(i);
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onComplete(MediaView mediaView) {
        MediationNativeAdCallback mediationNativeAdCallback = ((C3042nj) this.b).c;
        if (mediationNativeAdCallback != null) {
            mediationNativeAdCallback.onVideoComplete();
        }
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onEnterFullscreen(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onExitFullscreen(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onFullscreenBackground(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onFullscreenForeground(MediaView mediaView) {
    }

    @Override // defpackage.InterfaceC2916lF
    public void onLine(String str) {
        int i = 0;
        boolean contains = str.contains("#ERR IndexError: list index out of range");
        PDoQService pDoQService = (PDoQService) this.b;
        if (contains && !pDoQService.r) {
            SkStatus.updateStateString("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range");
            SkStatus.logInfo("#ERR IndexError: list index out of range");
            ((UDPClient) PDoQService.z).i("#ERR IndexError: list index out of range");
            try {
                pDoQService.e = new File(pDoQService.getApplicationInfo().nativeLibraryDir, "#ERR IndexError: list index out of range");
                String absolutePath = new File(pDoQService.e.getCanonicalPath()).getAbsolutePath();
                String string = "#ERR IndexError: list index out of range";
                Locale locale = Locale.ENGLISH;
                pDoQService.d = new ProcessBuilder(new String[0]).command(absolutePath, string, String.format(locale, PUtils.pEncrypt(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range"), new Object[0]), "#ERR IndexError: list index out of range", String.format(locale, pDoQService.getString(2131951660), new Object[0])).redirectErrorStream(true).start();
                Rw rw = new Rw(pDoQService, i);
                C3303sg c3303sg = new C3303sg(pDoQService.d.getInputStream(), rw);
                C3303sg c3303sg2 = new C3303sg(pDoQService.d.getErrorStream(), rw);
                c3303sg.start();
                c3303sg2.start();
            } catch (Exception e) {
                SkStatus.logInfo(String.format("#ERR IndexError: list index out of range", "#ERR IndexError: list index out of range", e.getMessage()));
            }
            pDoQService.r = true;
        }
        if (str.contains("#ERR IndexError: list index out of range")) {
            AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
            Vw vw = PDoQService.z;
            if (vw != null) {
                ((UDPClient) vw).E();
            } else {
                AbstractC2879kf.U(pDoQService.getApplicationContext(), "#ERR IndexError: list index out of range");
            }
            TunnelManagerHelper.stopPDoQ(pDoQService.getApplicationContext());
        }
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onPause(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onPlay(MediaView mediaView) {
    }

    @Override // com.facebook.ads.MediaViewListener
    public void onVolumeChange(MediaView mediaView, float f) {
    }

    public void p(int i) {
    }

    @Override // defpackage.InterfaceC0316Ub
    public int q() {
        int source;
        source = ((ContentInfo) this.b).getSource();
        return source;
    }

    @Override // defpackage.InterfaceC2500dK
    public int r(View view) {
        Cz cz = (Cz) view.getLayoutParams();
        ((Bz) this.b).getClass();
        return view.getRight() + ((Cz) view.getLayoutParams()).b.right + ((ViewGroup.MarginLayoutParams) cz).rightMargin;
    }

    @Override // defpackage.InterfaceC3431v1
    public void s(Bundle bundle) {
        ((C3272s1) ((InterfaceC3219r1) this.b)).a("clx", "_ae", bundle);
    }

    public void t(int i, float f) {
    }

    public String toString() {
        switch (this.a) {
            case 10:
                return "ContentInfoCompat{" + ((ContentInfo) this.b) + "}";
            default:
                return super.toString();
        }
    }

    @Override // defpackage.InterfaceC2684gu
    public boolean u(Mt mt) {
        A0 a0 = (A0) this.b;
        if (mt == a0.c) {
            return false;
        }
        ((CF) mt).A.getClass();
        a0.getClass();
        InterfaceC2684gu interfaceC2684gu = a0.e;
        if (interfaceC2684gu != null) {
            return interfaceC2684gu.u(mt);
        }
        return false;
    }

    @Override // defpackage.InterfaceC2949lw
    public void v(Object obj) {
        if (((InterfaceC2681gr) obj) != null) {
            g gVar = (g) this.b;
            if (g.access$200(gVar)) {
                View requireView = gVar.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (g.access$000(gVar) != null) {
                    if (Log.isLoggable("FragmentManager", 3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + g.access$000(gVar));
                    }
                    g.access$000(gVar).setContentView(requireView);
                }
            }
        }
    }

    public AbstractC3556xK w(Class cls) {
        String str;
        A9 a = Wz.a(cls);
        Class cls2 = a.a;
        AbstractC3365tp.q(cls2, "jClass");
        String str2 = null;
        if (!cls2.isAnonymousClass() && !cls2.isLocalClass()) {
            boolean isArray = cls2.isArray();
            HashMap hashMap = A9.c;
            if (isArray) {
                Class<?> componentType = cls2.getComponentType();
                if (componentType.isPrimitive() && (str = (String) hashMap.get(componentType.getName())) != null) {
                    str2 = str.concat("Array");
                }
                if (str2 == null) {
                    str2 = "kotlin.Array";
                }
            } else {
                str2 = (String) hashMap.get(cls2.getName());
                if (str2 == null) {
                    str2 = cls2.getCanonicalName();
                }
            }
        }
        if (str2 != null) {
            return ((DC) this.b).f(a, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(str2));
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
    }

    public boolean x(String str) {
        String H = H(str);
        return "1".equals(H) || Boolean.parseBoolean(H);
    }

    public UE y() {
        WE we = (WE) this.b;
        we.getClass();
        C0367Xh c0367Xh = AbstractC3090oe.i;
        Object obj = WE.e.get(we);
        if (obj == c0367Xh) {
            obj = null;
        }
        return (UE) obj;
    }

    public Integer z(String str) {
        String H = H(str);
        if (TextUtils.isEmpty(H)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(H));
        } catch (NumberFormatException unused) {
            Log.w("NotificationParams", "Couldn't parse value of " + P(str) + "(" + H + ") into an int");
            return null;
        }
    }
}
