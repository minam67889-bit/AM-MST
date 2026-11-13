package com.v2ray.ang.service;

import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.os.PowerManager;
import android.os.StrictMode;
import android.os.SystemClock;
import com.google.android.gms.ads.RequestConfiguration;
import com.v2ray.ang.service.V2RayVpnService;
import com.v2ray.ang.util.MyContextWrapper;
import defpackage.bm1;
import defpackage.cu0;
import defpackage.he1;
import defpackage.hv;
import defpackage.hz;
import defpackage.l71;
import defpackage.lv;
import defpackage.oy;
import defpackage.ul1;
import defpackage.xu;
import defpackage.yg0;
import defpackage.yq0;
import defpackage.zq0;
import defpackage.zr;
import j$.util.Objects;
import java.io.File;
import java.io.FileDescriptor;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.c;
import kotlin.jvm.functions.Function0;
import kotlin.text.Regex;
import libv2ray.CoreController;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/v2ray/ang/service/V2RayVpnService;", "Landroid/net/VpnService;", "Lcom/v2ray/ang/service/ServiceControl;", "<init>", "()V", "Companion", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class V2RayVpnService extends VpnService implements ServiceControl {
    public static final /* synthetic */ int h = 0;
    public ParcelFileDescriptor a;
    public boolean b;
    public Process c;
    public final Lazy d = c.b(new yq0(25));
    public final Lazy e;
    public final Lazy f;
    public PowerManager.WakeLock g;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/v2ray/ang/service/V2RayVpnService$Companion;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "VPN_MTU", "I", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "PRIVATE_VLAN4_CLIENT", "Ljava/lang/String;", "PRIVATE_VLAN4_ROUTER", "PRIVATE_VLAN6_CLIENT", "PRIVATE_VLAN6_ROUTER", "TUN2SOCKS", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion(xu xuVar) {
        }
    }

    static {
        new Companion(null);
    }

    public V2RayVpnService() {
        final int i = 0;
        this.e = c.b(new Function0(this) { // from class: am1
            public final /* synthetic */ V2RayVpnService b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i2 = i;
                V2RayVpnService v2RayVpnService = this.b;
                switch (i2) {
                    case 0:
                        int i3 = V2RayVpnService.h;
                        Object systemService = v2RayVpnService.getSystemService("connectivity");
                        systemService.getClass();
                        return (ConnectivityManager) systemService;
                    default:
                        int i4 = V2RayVpnService.h;
                        return new bm1(v2RayVpnService);
                }
            }
        });
        final int i2 = 1;
        this.f = c.b(new Function0(this) { // from class: am1
            public final /* synthetic */ V2RayVpnService b;

            {
                this.b = this;
            }

            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                int i22 = i2;
                V2RayVpnService v2RayVpnService = this.b;
                switch (i22) {
                    case 0:
                        int i3 = V2RayVpnService.h;
                        Object systemService = v2RayVpnService.getSystemService("connectivity");
                        systemService.getClass();
                        return (ConnectivityManager) systemService;
                    default:
                        int i4 = V2RayVpnService.h;
                        return new bm1(v2RayVpnService);
                }
            }
        });
    }

    public final void a() {
        Regex regex = ul1.a;
        Lazy lazy = zq0.a;
        ArrayList j = kotlin.collections.c.j(new File(getApplicationContext().getApplicationInfo().nativeLibraryDir, "libtun2socks.so").getAbsolutePath(), "--netif-ipaddr", "10.10.14.2", "--netif-netmask", "255.255.255.252", "--socks-server-addr", hz.o(ul1.y(Integer.parseInt("10808"), zq0.z().d("pref_socks_port")), "127.0.0.1:"), "--tunmtu", "1500", "--sock-path", "sock_path", "--enable-udprelay", "--loglevel", "notice");
        if (zq0.z().b("pref_prefer_ipv6", false)) {
            j.add("--netif-ip6addr");
            j.add("fc00::10:10:14:2");
        }
        if (zq0.z().b("pref_local_dns_enabled", false)) {
            int y = ul1.y(Integer.parseInt("10853"), zq0.z().d("pref_local_dns_port"));
            j.add("--dnsgw");
            j.add("127.0.0.1:" + y);
        }
        j.toString();
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(j);
            processBuilder.redirectErrorStream(true);
            Process start = processBuilder.directory(getApplicationContext().getFilesDir()).start();
            start.getClass();
            this.c = start;
            new Thread(new he1(this, 2)).start();
            Process process = this.c;
            if (process != null) {
                Objects.toString(process);
                b();
            } else {
                yg0.N("process");
                throw null;
            }
        } catch (Exception unused) {
        }
    }

    @Override // android.app.Service, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        ContextWrapper contextWrapper;
        if (context != null) {
            MyContextWrapper.Companion companion = MyContextWrapper.a;
            Locale b = l71.b();
            companion.getClass();
            contextWrapper = MyContextWrapper.Companion.a(context, b);
        } else {
            contextWrapper = null;
        }
        super.attachBaseContext(contextWrapper);
    }

    public final void b() {
        ParcelFileDescriptor parcelFileDescriptor = this.a;
        if (parcelFileDescriptor != null) {
            FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
            String absolutePath = new File(getApplicationContext().getFilesDir(), "sock_path").getAbsolutePath();
            lv lvVar = oy.a;
            kotlinx.coroutines.c.d(zr.a(hv.c), null, null, new V2RayVpnService$sendFd$1(absolutePath, fileDescriptor, null), 3);
            return;
        }
        yg0.N("mInterface");
        throw null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(24:5|(1:7)|8|(22:100|(2:107|(2:109|(5:111|(4:114|(3:116|117|118)(1:120)|119|112)|121|122|(3:124|(3:127|(1:139)(0)|125)|141)))(22:142|(7:144|(4:147|(3:152|153|154)|155|145)|158|159|(3:164|(3:167|(1:180)(1:172)|165)|182)|161|162)(1:183)|163|(3:12|(2:15|13)|16)(1:99)|17|(2:19|(1:21)(1:22))|23|(1:25)|26|(4:29|(3:31|32|33)(1:35)|34|27)|36|37|(4:40|(3:42|43|44)(1:46)|45|38)|47|48|(1:50)(1:98)|(1:52)|53|(3:55|(1:(1:58))(1:(1:96))|(2:60|(6:63|(2:74|75)(1:65)|66|73|72|61)))(1:97)|76|77|(7:79|80|(2:82|(1:84))|85|86|87|88)(2:92|93)))|102|(0)(0)|17|(0)|23|(0)|26|(1:27)|36|37|(1:38)|47|48|(0)(0)|(0)|53|(0)(0)|76|77|(0)(0))(0)|10|(0)(0)|17|(0)|23|(0)|26|(1:27)|36|37|(1:38)|47|48|(0)(0)|(0)|53|(0)(0)|76|77|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x026c A[Catch: Exception -> 0x0276, TryCatch #2 {Exception -> 0x0276, blocks: (B:77:0x0268, B:79:0x026c, B:92:0x0270, B:93:0x0275), top: B:76:0x0268 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0270 A[Catch: Exception -> 0x0276, TryCatch #2 {Exception -> 0x0276, blocks: (B:77:0x0268, B:79:0x026c, B:92:0x0270, B:93:0x0275), top: B:76:0x0268 }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0265  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0177  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instructions count: 703
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.service.V2RayVpnService.c():void");
    }

    public final void d(boolean z) {
        Process process;
        this.b = false;
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                ((ConnectivityManager) this.e.getValue()).unregisterNetworkCallback((bm1) this.f.getValue());
            } catch (Exception unused) {
            }
        }
        try {
            process = this.c;
        } catch (Exception unused2) {
        }
        if (process != null) {
            process.destroy();
            CoreController coreController = b.a;
            b.f();
            if (z) {
                stopSelf();
                try {
                    ParcelFileDescriptor parcelFileDescriptor = this.a;
                    if (parcelFileDescriptor != null) {
                        parcelFileDescriptor.close();
                        return;
                    } else {
                        yg0.N("mInterface");
                        throw null;
                    }
                } catch (Exception unused3) {
                    return;
                }
            }
            return;
        }
        yg0.N("process");
        throw null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        Object systemService = getSystemService("power");
        systemService.getClass();
        PowerManager.WakeLock newWakeLock = ((PowerManager) systemService).newWakeLock(1, "V2Ray::VpnWakeLock");
        this.g = newWakeLock;
        if (newWakeLock != null) {
            newWakeLock.acquire();
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        CoreController coreController = b.a;
        b.a(new SoftReference(this));
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        cu0.a();
        PowerManager.WakeLock wakeLock = this.g;
        if (wakeLock != null) {
            wakeLock.release();
        }
        this.g = null;
    }

    @Override // android.net.VpnService
    public final void onRevoke() {
        if (this.b) {
            d(false);
            c();
        }
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Lazy lazy = zq0.a;
        zq0.u().h(elapsedRealtime, "v2rayTime");
        CoreController coreController = b.a;
        if (b.c()) {
            c();
            return 1;
        }
        return 1;
    }

    @Override // com.v2ray.ang.service.ServiceControl
    public final void startService() {
        c();
    }

    @Override // com.v2ray.ang.service.ServiceControl
    public final void stopService() {
        d(true);
    }

    @Override // com.v2ray.ang.service.ServiceControl
    public final boolean vpnProtect(int i) {
        return protect(i);
    }

    @Override // com.v2ray.ang.service.ServiceControl
    public final Service getService() {
        return this;
    }
}
