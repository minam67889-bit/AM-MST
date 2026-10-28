package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.webkit.WebView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.android.recaptcha.RecaptchaTasksClient;
import com.scottyab.rootbeer.RootBeerNative;
import dastan.prince.bdfreevpn.R;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Scanner;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class TO implements InterfaceC0414Pp, InterfaceC3281iV, InterfaceC0608Xb, InterfaceC0870cF, WebMessageListenerBoundaryInterface, Continuation {
    public final /* synthetic */ int a;
    public Object b;

    public static boolean a(String str) {
        boolean z = false;
        for (String str2 : AbstractC0325Me.z()) {
            String C = W50.C(str2, str);
            if (new File(str2, str).exists()) {
                AbstractC0641Yi.d0(C + " binary detected!");
                z = true;
            }
        }
        return z;
    }

    public boolean b(ArrayList arrayList) {
        PackageManager packageManager = ((Context) this.b).getPackageManager();
        Iterator it = arrayList.iterator();
        boolean z = false;
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                packageManager.getPackageInfo(str, 0);
                AbstractC0641Yi.u(str + " ROOT management app detected!");
                z = true;
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean c() {
        boolean z;
        String[] strArr;
        boolean z2;
        String[] strArr2;
        boolean z3;
        String[] strArr3;
        Process process;
        boolean z4;
        boolean z5;
        InputStream inputStream;
        InputStream inputStream2;
        if (!b(new ArrayList(Arrays.asList(AbstractC0325Me.c)))) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(Arrays.asList(AbstractC0325Me.d));
            if (!b(arrayList) && !a("su")) {
                HashMap hashMap = new HashMap();
                hashMap.put("ro.debuggable", "1");
                hashMap.put("ro.secure", "0");
                try {
                    inputStream2 = Runtime.getRuntime().exec("getprop").getInputStream();
                } catch (IOException | NoSuchElementException e) {
                    e.printStackTrace();
                }
                if (inputStream2 != null) {
                    strArr = new Scanner(inputStream2).useDelimiter("\\A").next().split("\n");
                    if (strArr != null) {
                        z2 = false;
                    } else {
                        z2 = false;
                        for (String str : strArr) {
                            for (String str2 : hashMap.keySet()) {
                                if (str.contains(str2)) {
                                    String D = W50.D("[", (String) hashMap.get(str2), "]");
                                    if (str.contains(D)) {
                                        AbstractC0641Yi.d0(str2 + " = " + D + " detected!");
                                        z2 = true;
                                    }
                                }
                            }
                        }
                    }
                    if (!z2) {
                        try {
                            inputStream = Runtime.getRuntime().exec("mount").getInputStream();
                        } catch (IOException | NoSuchElementException e2) {
                            e2.printStackTrace();
                        }
                        if (inputStream != null) {
                            strArr2 = new Scanner(inputStream).useDelimiter("\\A").next().split("\n");
                            if (strArr2 != null) {
                                z3 = false;
                            } else {
                                int length = strArr2.length;
                                int i = 0;
                                z3 = false;
                                while (i < length) {
                                    String str3 = strArr2[i];
                                    String[] split = str3.split(" ");
                                    if (split.length < 6) {
                                        AbstractC0641Yi.u("Error formatting mount line: ".concat(str3));
                                    } else {
                                        String str4 = split[2];
                                        String str5 = split[5];
                                        String[] strArr4 = AbstractC0325Me.f;
                                        int i2 = 0;
                                        while (i2 < 7) {
                                            String str6 = strArr4[i2];
                                            if (str4.equalsIgnoreCase(str6)) {
                                                str5 = str5.replace("(", "").replace(")", "");
                                                String[] split2 = str5.split(",");
                                                int length2 = split2.length;
                                                int i3 = 0;
                                                while (i3 < length2) {
                                                    strArr3 = strArr2;
                                                    if (split2[i3].equalsIgnoreCase("rw")) {
                                                        AbstractC0641Yi.d0(str6 + " path is mounted with rw permissions! " + str3);
                                                        z3 = true;
                                                        break;
                                                    }
                                                    i3++;
                                                    strArr2 = strArr3;
                                                }
                                            }
                                            strArr3 = strArr2;
                                            i2++;
                                            strArr2 = strArr3;
                                        }
                                    }
                                    i++;
                                    strArr2 = strArr2;
                                }
                            }
                            if (!z3) {
                                String str7 = Build.TAGS;
                                if (!(str7 != null && str7.contains("test-keys"))) {
                                    try {
                                        process = Runtime.getRuntime().exec(new String[]{"which", "su"});
                                    } catch (Throwable unused) {
                                        process = null;
                                    }
                                    try {
                                        z4 = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine() != null;
                                        process.destroy();
                                    } catch (Throwable unused2) {
                                        if (process != null) {
                                            process.destroy();
                                        }
                                        z4 = false;
                                        if (!z4) {
                                        }
                                        z = true;
                                        return z;
                                    }
                                    if (!z4) {
                                        if (RootBeerNative.a) {
                                            String[] z6 = AbstractC0325Me.z();
                                            int length3 = z6.length;
                                            String[] strArr5 = new String[length3];
                                            for (int i4 = 0; i4 < length3; i4++) {
                                                strArr5[i4] = W50.q(z6[i4], "su", new StringBuilder());
                                            }
                                            RootBeerNative rootBeerNative = new RootBeerNative();
                                            z = true;
                                            try {
                                                rootBeerNative.setLogDebugMessages(true);
                                                if (rootBeerNative.checkForRoot(strArr5) > 0) {
                                                    z5 = true;
                                                }
                                            } catch (UnsatisfiedLinkError unused3) {
                                            }
                                            z5 = false;
                                        } else {
                                            AbstractC0641Yi.u("We could not load the native library to test for root");
                                            z5 = false;
                                            z = true;
                                        }
                                        if (!z5 && !a("magisk")) {
                                            return false;
                                        }
                                        return z;
                                    }
                                }
                            }
                        }
                        strArr2 = null;
                        if (strArr2 != null) {
                        }
                        if (!z3) {
                        }
                    }
                }
                strArr = null;
                if (strArr != null) {
                }
                if (!z2) {
                }
            }
        }
        z = true;
        return z;
    }

    @Override // defpackage.InterfaceC0608Xb
    public void e() {
        ((z) this.b).a();
    }

    @Override // defpackage.YL
    public Object get() {
        return new C0883cS((C3357jT) ((XL) this.b).get());
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
    }

    @Override // defpackage.InterfaceC0870cF
    public boolean i(MenuC2945eF menuC2945eF, MenuItem menuItem) {
        ((Toolbar) this.b).getClass();
        return false;
    }

    @Override // defpackage.InterfaceC3281iV
    public void onLine(String str) {
        switch (this.a) {
            case 3:
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-83330287368075L))) {
                    SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-83373237041035L));
                    SocksDNSService.G.startSocksOpenVPN();
                    Thread thread = new Thread(SocksDNSService.E);
                    SocksDNSService.D = thread;
                    thread.start();
                    SkStatus.logInfo(R.string.tunnel_start, new Object[0]);
                }
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-83416186713995L))) {
                    SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-83467726321547L));
                }
                boolean contains = str.contains(Deobfuscator$BDNETVPN$app.getString(-83532150830987L));
                SocksDNSService socksDNSService = (SocksDNSService) this.b;
                if (contains) {
                    SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-83579395471243L));
                    VPNClient vPNClient = SocksDNSService.G;
                    if (vPNClient != null) {
                        vPNClient.stopSocksOpenVPN();
                    } else {
                        F00.h(socksDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-83682474686347L));
                    }
                    F00.h(socksDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-83811323705227L));
                    TunnelManagerHelper.stopSocksHttp(socksDNSService.getApplicationContext());
                }
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-83961647560587L))) {
                    SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-83996007298955L));
                    VPNClient vPNClient2 = SocksDNSService.G;
                    if (vPNClient2 != null) {
                        vPNClient2.stopSocksOpenVPN();
                    } else {
                        F00.h(socksDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-84051841873803L));
                    }
                    SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-84180690892683L));
                    TunnelManagerHelper.stopSocksHttp(socksDNSService.getApplicationContext());
                }
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-84399734224779L))) {
                    VPNClient vPNClient3 = SocksDNSService.G;
                    if (vPNClient3 != null) {
                        vPNClient3.stopSocksOpenVPN();
                    } else {
                        F00.h(socksDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-84468453701515L));
                    }
                    TunnelManagerHelper.stopSocksHttp(socksDNSService.getApplicationContext());
                }
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-84597302720395L))) {
                    SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-84653137295243L), Deobfuscator$BDNETVPN$app.getString(-84708971870091L));
                    SocksDNSService.G.addStatus(Deobfuscator$BDNETVPN$app.getString(-84777691346827L));
                    new Thread(new RunnableC3954r1(this, 15)).start();
                }
                str.contains(Deobfuscator$BDNETVPN$app.getString(-84846410823563L));
                break;
            default:
                boolean contains2 = str.contains(Deobfuscator$BDNETVPN$app.getString(-95996145923979L));
                XRayDNSService xRayDNSService = (XRayDNSService) this.b;
                if (contains2) {
                    F00.h(xRayDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-96094930171787L));
                    VPNClient vPNClient4 = XRayDNSService.E;
                    if (vPNClient4 != null) {
                        vPNClient4.stopSocksOpenVPN();
                    } else {
                        F00.h(xRayDNSService.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-96223779190667L));
                    }
                    TunnelManagerHelper.stopXRay(xRayDNSService.getApplicationContext());
                }
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-96352628209547L)) && !xRayDNSService.t) {
                    new Thread(new RunnableC3954r1(xRayDNSService, 23)).start();
                    xRayDNSService.t = true;
                }
                if (str.contains(Deobfuscator$BDNETVPN$app.getString(-96412757751691L)) && xRayDNSService.u && !xRayDNSService.v) {
                    SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-96468592326539L), Deobfuscator$BDNETVPN$app.getString(-96511541999499L));
                    XRayDNSService.E.addStatus(Deobfuscator$BDNETVPN$app.getString(-96588851410827L));
                    xRayDNSService.v = true;
                    break;
                }
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z, InvocationHandler invocationHandler2) {
        C3087g30 c3087g30;
        C3087g30 c3087g302;
        WebMessageBoundaryInterface webMessageBoundaryInterface = (WebMessageBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessageBoundaryInterface.class, invocationHandler);
        InvocationHandler[] ports = webMessageBoundaryInterface.getPorts();
        AbstractC3247i30[] abstractC3247i30Arr = new AbstractC3247i30[ports.length];
        for (int i = 0; i < ports.length; i++) {
            InvocationHandler invocationHandler3 = ports[i];
            C3325j30 c3325j30 = new C3325j30();
            c3325j30.b = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler3);
            abstractC3247i30Arr[i] = c3325j30;
        }
        if (AbstractC4196u30.e.b()) {
            WebMessagePayloadBoundaryInterface webMessagePayloadBoundaryInterface = (WebMessagePayloadBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePayloadBoundaryInterface.class, webMessageBoundaryInterface.getMessagePayload());
            int type = webMessagePayloadBoundaryInterface.getType();
            if (type == 0) {
                c3087g30 = new C3087g30(webMessagePayloadBoundaryInterface.getAsString(), abstractC3247i30Arr);
            } else {
                if (type != 1) {
                    c3087g302 = null;
                    if (c3087g302 == null) {
                        JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(JsReplyProxyBoundaryInterface.class, invocationHandler2);
                        ((InterfaceC3959r30) this.b).onPostMessage(webView, c3087g302, uri, z, (C0371Ny) jsReplyProxyBoundaryInterface.getOrCreatePeer(new CallableC4327vh(jsReplyProxyBoundaryInterface, 1)));
                        return;
                    }
                    return;
                }
                c3087g30 = new C3087g30(webMessagePayloadBoundaryInterface.getAsArrayBuffer(), abstractC3247i30Arr);
            }
        } else {
            c3087g30 = new C3087g30(webMessageBoundaryInterface.getData(), abstractC3247i30Arr);
        }
        c3087g302 = c3087g30;
        if (c3087g302 == null) {
        }
    }

    @Override // defpackage.InterfaceC0870cF
    public void q(MenuC2945eF menuC2945eF) {
        Toolbar toolbar = (Toolbar) this.b;
        C3480l1 c3480l1 = toolbar.a.t;
        if (c3480l1 == null || !c3480l1.k()) {
            Iterator it = toolbar.G.b.iterator();
            while (it.hasNext()) {
                ((C2912dt) ((InterfaceC4609zF) it.next())).a.s(menuC2945eF);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* synthetic */ Object then(Task task) {
        if (task.isSuccessful()) {
            return ((RecaptchaTasksClient) task.getResult()).executeTask((RecaptchaAction) this.b);
        }
        Exception exc = (Exception) Preconditions.checkNotNull(task.getException());
        if (!(exc instanceof ng0)) {
            return Tasks.forException(exc);
        }
        if (Log.isLoggable("RecaptchaHandler", 4)) {
            Log.i("RecaptchaHandler", "Ignoring error related to fetching recaptcha config - " + exc.getMessage());
        }
        return Tasks.forResult("");
    }

    public /* synthetic */ TO(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    public TO(P2 p2, RecaptchaAction recaptchaAction) {
        this.a = 11;
        this.b = recaptchaAction;
        Objects.requireNonNull(p2);
    }
}
