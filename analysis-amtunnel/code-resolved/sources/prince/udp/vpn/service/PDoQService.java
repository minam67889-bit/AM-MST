package prince.udp.vpn.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import defpackage.A2;
import defpackage.AbstractC0239Oo;
import defpackage.AbstractC0487bc;
import defpackage.AbstractC2879kf;
import defpackage.AbstractC3192qa;
import defpackage.AbstractC3454vO;
import defpackage.C2507db;
import defpackage.C3303sg;
import defpackage.C3628yn;
import defpackage.Pw;
import defpackage.Qw;
import defpackage.Sw;
import defpackage.Uw;
import defpackage.Vw;
import defpackage.Ww;
import defpackage.Xw;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.TunnelState;
import prince.udp.vpn.service.vpn.TunnelVpnManager;
import prince.udp.vpn.service.vpn.TunnelVpnService;
import prince.udp.vpn.service.vpn.TunnelVpnSettings;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.ConnectionStatus;
import prince.udp.vpn.service.vpn.logger.SkStatus;
import prince.udp.vpn.utils.PUtils;

/* loaded from: classes2.dex */
public class PDoQService extends Service implements Runnable, Handler.Callback, SkStatus.StateListener {
    public static Xw A;
    public static final String B;
    public static final String C;
    public static boolean w;
    public static final int x;
    public static long y;
    public static Vw z;
    public Thread a;
    public Handler b;
    public C2507db c;
    public Process d;
    public File e;
    public Process f;
    public File m;
    public NotificationManager n;
    public ConnectivityManager o;
    public Ww p;
    public String q;
    public boolean r;
    public String t;
    public final Qw s = new Qw(this, 0);
    public final Sw u = new Sw(0);
    public final A2 v = new A2(this, 3);

    static {
        "PDoQ";
        "app.vpn.amtunnellite:startTunnel";
        "openvpn_bg";
        "openvpn_newstat";
        "openvpn_userreq";
        w = false;
        x = 10801;
        y = 0L;
        B = PDoQService.class.getName() + "::restartservicebroadcast";
        C = PDoQService.class.getName() + "::stopservicebroadcast";
    }

    public static PendingIntent c(Context context) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) UDPClient.class), 67108864);
    }

    public static String d() {
        long time = new Date().getTime();
        long j = y;
        long j2 = time - j;
        if (j == 0) {
            return "00:00:00";
        }
        return String.format("%02d:%02d:%02d", Long.valueOf((j2 / 3600000) % 24), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60));
    }

    public final synchronized void a() {
        i();
    }

    public final void b() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        String string = getString(2131951717);
        AbstractC3454vO.k();
        NotificationChannel e = AbstractC0239Oo.e("openvpn_bg", string);
        e.setDescription(getString(2131951713));
        e.enableLights(false);
        e.setLightColor(2131100642);
        notificationManager.createNotificationChannel(e);
        String string2 = getString(2131951718);
        AbstractC3454vO.k();
        NotificationChannel A2 = AbstractC0239Oo.A("openvpn_newstat", string2);
        A2.setDescription(getString(2131951714));
        A2.enableLights(true);
        A2.setLightColor(2131100642);
        notificationManager.createNotificationChannel(A2);
        String string3 = getString(2131951719);
        AbstractC3454vO.k();
        NotificationChannel e2 = AbstractC0239Oo.e("openvpn_userreq", string3);
        e2.setDescription(getString(2131951715));
        e2.setLightColor(2131100642);
        notificationManager.createNotificationChannel(e2);
    }

    public final void e() {
        String message;
        try {
            NetworkInfo activeNetworkInfo = this.o.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                message = "not connected";
            } else {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtypeName == null) {
                    subtypeName = "";
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    extraInfo = "";
                }
                message = String.format("%2$s %4$s to %1$s %3$s", activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState(), extraInfo, subtypeName);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        SkStatus.logInfo(message);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(java.lang.String r9, java.lang.String r10, java.lang.String r11, prince.udp.vpn.service.vpn.logger.ConnectionStatus r12) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: prince.udp.vpn.service.PDoQService.f(java.lang.String, java.lang.String, java.lang.String, prince.udp.vpn.service.vpn.logger.ConnectionStatus):void");
    }

    public final void g() {
        String[] strArr;
        SkStatus.logInfo(2131952159, new Object[0]);
        IntentFilter intentFilter = new IntentFilter("tunnelVpnDisconnectBroadcast");
        intentFilter.addAction("tunnelVpnStartBroadcast");
        AbstractC0487bc.registerReceiver(getApplicationContext(), this.s, intentFilter, 2);
        String format = String.format(Locale.ENGLISH, "127.0.0.1:%s", Integer.valueOf(x));
        C2507db c2507db = this.c;
        c2507db.getClass();
        if (c2507db.a.getBoolean("#ERR IndexError: string index out of range", false)) {
            C2507db c2507db2 = this.c;
            c2507db2.getClass();
            String string = c2507db2.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range");
            if (string.contains(";")) {
                String[] split = string.split(";");
                ArrayList arrayList = new ArrayList();
                for (String str : split) {
                    arrayList.add(str);
                }
                strArr = (String[]) arrayList.toArray(new String[0]);
            } else {
                strArr = new String[]{string};
            }
        } else {
            strArr = new String[]{this.q};
        }
        String[] strArr2 = strArr;
        String[] strArr3 = {VpnUtils.getNetworkDnsServer(getApplicationContext()).get(0)};
        TunnelState tunnelState = TunnelState.getTunnelState();
        if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
            Log.d("PDoQ", "already running service");
            AbstractC2879kf.V(getApplicationContext(), "VPN Error, Restart Device!");
            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
            if (tunnelManager != null) {
                tunnelManager.restartTunnel(format);
                return;
            }
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) TunnelVpnService.class);
        intent.setFlags(268435456);
        intent.putExtra("vpnSettings", new TunnelVpnSettings(format, false, strArr3, false, null, strArr2, false, false, new String[0], true, false));
        if (startService(intent) == null) {
            SkStatus.logInfo(2131952158, new Object[0]);
            throw new IOException(getString(2131952239));
        }
        TunnelState.getTunnelState().setStartingTunnelManager();
        SkStatus.updateStateString("CONNECTED", "PDoQ Connected");
        ((UDPClient) z).i("Connected");
    }

    public final void h() {
        SkStatus.updateStateString("STOPPING", getString(2131952199));
        SkStatus.logInfo("<strong>" + getString(2131952199) + "</strong>");
        new Thread(new Pw(this, 1)).start();
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 1) {
            TunnelManagerHelper.startPDoQ(getApplicationContext());
        }
        return true;
    }

    public final void i() {
        synchronized (this) {
            TunnelState tunnelState = TunnelState.getTunnelState();
            if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
                SkStatus.logInfo(2131952160, new Object[0]);
                TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                if (tunnelManager != null) {
                    tunnelManager.signalStopService();
                }
                try {
                    unregisterReceiver(this.s);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new Uw(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        this.b = new Handler(this);
        this.o = (ConnectivityManager) getSystemService("connectivity");
        if (this.n == null) {
            this.n = (NotificationManager) getSystemService("notification");
        }
        AbstractC3192qa.f(getApplicationContext());
        super.onCreate();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.i("PDoQ", "onStartCommand");
        if (Build.VERSION.SDK_INT >= 24) {
            this.o.registerDefaultNetworkCallback(this.u);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(C);
        intentFilter.addAction(B);
        AbstractC0487bc.registerReceiver(this, this.v, intentFilter, 2);
        SkStatus.addStateListener(this);
        Ww ww = new Ww(0);
        ww.b = false;
        ww.c = 1000L;
        this.p = ww;
        new Thread(this.p, "Status Poller").start();
        if (intent != null && "app.vpn.amtunnellite:startTunnel".equals(intent.getAction())) {
            return 2;
        }
        String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        f(string, string, "openvpn_newstat", ConnectionStatus.LEVEL_START);
        if (intent != null) {
            if ("START".equals(intent.getAction())) {
                y = new Date().getTime();
                this.a = new Thread(this, "InjectorThread");
                this.c = C2507db.a(this);
                w = true;
                Thread thread = this.a;
                if (thread != null) {
                    thread.interrupt();
                }
                this.a.start();
            }
        }
        return 2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String format;
        Inet4Address inet4Address;
        try {
            this.m = new File(getApplicationInfo().nativeLibraryDir, "libpdoq.so");
            String str = "ns-" + this.c.b();
            C2507db c2507db = this.c;
            c2507db.getClass();
            if (!c2507db.a.getBoolean("#ERR IndexError: string index out of range", false)) {
                C2507db c2507db2 = this.c;
                c2507db2.getClass();
                if (c2507db2.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range").equals("Direct")) {
                    try {
                        InetAddress[] allByName = InetAddress.getAllByName(this.c.b());
                        int length = allByName.length;
                        int i = 0;
                        while (true) {
                            if (i >= length) {
                                inet4Address = null;
                                break;
                            }
                            InetAddress inetAddress = allByName[i];
                            if (inetAddress instanceof Inet4Address) {
                                inet4Address = (Inet4Address) inetAddress;
                                break;
                            }
                            i++;
                        }
                        this.q = inet4Address.getHostAddress();
                    } catch (UnknownHostException unused) {
                        h();
                        AbstractC2879kf.U(getApplicationContext(), "Error Parsing IP!");
                    }
                } else {
                    C2507db c2507db3 = this.c;
                    c2507db3.getClass();
                    this.q = c2507db3.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range");
                }
            }
            File file = new File(this.m.getCanonicalPath());
            ArrayList arrayList = new ArrayList();
            arrayList.add(file.getAbsolutePath());
            arrayList.add("-d");
            Locale locale = Locale.ENGLISH;
            arrayList.add(String.format(locale, PUtils.pEncrypt(getApplicationContext(), str), new Object[0]));
            C2507db c2507db4 = this.c;
            c2507db4.getClass();
            if (c2507db4.a.getBoolean("#ERR IndexError: string index out of range", false)) {
                C2507db c2507db5 = this.c;
                c2507db5.getClass();
                String string = c2507db5.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range");
                if (string.contains(";")) {
                    for (String str2 : string.split(";")) {
                        arrayList.add("-r");
                        arrayList.add(String.format(Locale.ENGLISH, str2, new Object[0]));
                    }
                    arrayList.add("-a");
                    arrayList.add(String.format(Locale.ENGLISH, getString(2131951660), new Object[0]));
                    this.f = new ProcessBuilder(new String[0]).command((String[]) arrayList.toArray(new String[0])).redirectErrorStream(true).start();
                    SkStatus.updateStateString("CONNECTING", getString(2131952179));
                    SkStatus.logInfo(2131952179, new Object[0]);
                    ((UDPClient) z).i("PDoQ Connecting...");
                    C3628yn c3628yn = new C3628yn(this, 26);
                    C3303sg c3303sg = new C3303sg(this.f.getInputStream(), c3628yn);
                    C3303sg c3303sg2 = new C3303sg(this.f.getErrorStream(), c3628yn);
                    c3303sg.start();
                    c3303sg2.start();
                }
                arrayList.add("-r");
                format = String.format(locale, string, new Object[0]);
            } else {
                arrayList.add("-r");
                format = String.format(locale, this.q, new Object[0]);
            }
            arrayList.add(format);
            arrayList.add("-a");
            arrayList.add(String.format(Locale.ENGLISH, getString(2131951660), new Object[0]));
            this.f = new ProcessBuilder(new String[0]).command((String[]) arrayList.toArray(new String[0])).redirectErrorStream(true).start();
            SkStatus.updateStateString("CONNECTING", getString(2131952179));
            SkStatus.logInfo(2131952179, new Object[0]);
            ((UDPClient) z).i("PDoQ Connecting...");
            C3628yn c3628yn2 = new C3628yn(this, 26);
            C3303sg c3303sg3 = new C3303sg(this.f.getInputStream(), c3628yn2);
            C3303sg c3303sg22 = new C3303sg(this.f.getErrorStream(), c3628yn2);
            c3303sg3.start();
            c3303sg22.start();
        } catch (Exception e) {
            SkStatus.logInfo(String.format("%s: %s", "PDoQ DNS Exception", e.getMessage()));
        }
    }

    @Override // prince.udp.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        if (this.a == null) {
            return;
        }
        String string = "openvpn_newstat";
        if (connectionStatus == ConnectionStatus.LEVEL_CONNECTED) {
            string = "openvpn_userreq";
        }
        String string2 = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        f(string2, string2, string, connectionStatus);
    }
}
