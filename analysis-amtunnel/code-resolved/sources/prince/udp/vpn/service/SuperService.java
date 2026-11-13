package prince.udp.vpn.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import defpackage.A2;
import defpackage.AbstractC0487bc;
import defpackage.AbstractC2879kf;
import defpackage.AbstractC3192qa;
import defpackage.C2507db;
import defpackage.C3303sg;
import defpackage.FF;
import defpackage.GF;
import defpackage.HF;
import defpackage.IF;
import defpackage.Qw;
import defpackage.Rw;
import defpackage.Sw;
import defpackage.Ww;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
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

/* loaded from: classes2.dex */
public class SuperService extends Service implements Runnable, Handler.Callback, SkStatus.StateListener {
    public static final int A;
    public static long B;
    public static HF C;
    public static IF D;
    public static final String E;
    public static final String F;
    public static final int z;
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
    public File u;
    public String w;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public final Qw v = new Qw(this, 1);
    public final Sw x = new Sw(2);
    public final A2 y = new A2(this, 5);

    static {
        "SuperDNS";
        "app.vpn.amtunnellite:startTunnel";
        "openvpn_bg";
        "openvpn_newstat";
        "openvpn_userreq";
        z = 10801;
        A = 10802;
        B = 0L;
        E = SuperService.class.getName() + "::restartservicebroadcast";
        F = SuperService.class.getName() + "::stopservicebroadcast";
    }

    public static String c() {
        long time = new Date().getTime();
        long j = B;
        long j2 = time - j;
        if (j == 0) {
            return "00:00:00";
        }
        return String.format("%02d:%02d:%02d", Long.valueOf((j2 / 3600000) % 24), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60));
    }

    public final synchronized void a() {
        h();
    }

    public final void b() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        NotificationChannel notificationChannel = new NotificationChannel("openvpn_bg", getString(2131951717), 1);
        notificationChannel.setDescription(getString(2131951713));
        notificationChannel.enableLights(false);
        notificationChannel.setLightColor(2131100642);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel("openvpn_newstat", getString(2131951718), 2);
        notificationChannel2.setDescription(getString(2131951714));
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(2131100642);
        notificationManager.createNotificationChannel(notificationChannel2);
        NotificationChannel notificationChannel3 = new NotificationChannel("openvpn_userreq", getString(2131951719), 1);
        notificationChannel3.setDescription(getString(2131951715));
        notificationChannel3.setLightColor(2131100642);
        notificationManager.createNotificationChannel(notificationChannel3);
    }

    public final void d() {
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

    public final void e(String str, String str2, String str3, ConnectionStatus connectionStatus) {
        int i = GF.a[connectionStatus.ordinal()];
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            b();
            new Notification.Builder(this, "openvpn_newstat");
        } else if (i2 >= 28) {
            b();
            new Notification.Builder(this, "openvpn_newstat");
        } else {
            new Notification.Builder(this);
        }
        Notification.Builder ongoing = new Notification.Builder(this).setContentTitle(getString(2131951660)).setOnlyAlertOnce(true).setOngoing(true);
        ongoing.setCategory("service");
        ongoing.setLocalOnly(true);
        int i3 = str3.equals("openvpn_bg") ? -2 : str3.equals("openvpn_userreq") ? 2 : 0;
        ongoing.setSmallIcon(2131230926);
        if (SkStatus.getLastState().equals("CONNECTED")) {
            str = "Connected to " + this.c.c();
        }
        ongoing.setContentText(str);
        ongoing.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) UDPClient.class), 201326592));
        if (i3 != 0) {
            try {
                ongoing.getClass().getMethod("setPriority", Integer.TYPE).invoke(ongoing, Integer.valueOf(i3));
                ongoing.getClass().getMethod("setUsesChronometer", Boolean.TYPE).invoke(ongoing, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                SkStatus.logException(e);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            ongoing.setChannelId(str3);
        }
        if (str2 != null && !str2.equals("")) {
            ongoing.setTicker(str2);
        }
        Notification build = ongoing.build();
        int hashCode = str3.hashCode();
        notificationManager.notify(hashCode, build);
        if (i4 >= 34) {
            startForeground(hashCode, build, 1073741824);
        } else {
            startForeground(hashCode, build);
        }
        String str4 = this.w;
        if (str4 != null && !str3.equals(str4)) {
            notificationManager.cancel(this.w.hashCode());
        }
        this.w = str3;
    }

    public final void f() {
        Inet4Address inet4Address;
        SkStatus.logInfo(2131952159, new Object[0]);
        IntentFilter intentFilter = new IntentFilter("tunnelVpnDisconnectBroadcast");
        intentFilter.addAction("tunnelVpnStartBroadcast");
        AbstractC0487bc.registerReceiver(getApplicationContext(), this.v, intentFilter, 2);
        String format = String.format(Locale.ENGLISH, "127.0.0.1:%s", Integer.valueOf(z));
        String str = this.q;
        try {
            InetAddress[] allByName = InetAddress.getAllByName(str);
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
            str = inet4Address.getHostAddress();
        } catch (UnknownHostException unused) {
            HF hf = C;
            if (hf != null) {
                ((UDPClient) hf).E();
            } else {
                AbstractC2879kf.V(getApplicationContext(), "Error, Reconnect/Restart App!");
            }
            TunnelManagerHelper.stopSuperDns(getApplicationContext());
            AbstractC2879kf.U(getApplicationContext(), "Error Parsing IP!");
        }
        String[] strArr = {str};
        String[] strArr2 = {VpnUtils.getNetworkDnsServer(getApplicationContext()).get(0)};
        TunnelState tunnelState = TunnelState.getTunnelState();
        if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
            Log.d("SuperDNS", "already running service");
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
        intent.putExtra("vpnSettings", new TunnelVpnSettings(format, false, strArr2, false, null, strArr, false, false, new String[0], true, false));
        if (startService(intent) != null) {
            TunnelState.getTunnelState().setStartingTunnelManager();
        } else {
            SkStatus.logInfo(2131952158, new Object[0]);
            throw new IOException(getString(2131952239));
        }
    }

    public final void g() {
        SkStatus.updateStateString("STOPPING", getString(2131952199));
        SkStatus.logInfo("<strong>" + getString(2131952199) + "</strong>");
        new Thread(new FF(this, 1)).start();
    }

    public final void h() {
        synchronized (this) {
            TunnelState tunnelState = TunnelState.getTunnelState();
            if (tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null) {
                SkStatus.logInfo(2131952160, new Object[0]);
                TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                if (tunnelManager != null) {
                    tunnelManager.signalStopService();
                }
                try {
                    unregisterReceiver(this.v);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        return true;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new Binder();
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
        Log.i("SuperDNS", "onStartCommand");
        if (Build.VERSION.SDK_INT >= 24) {
            this.o.registerDefaultNetworkCallback(this.x);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(F);
        intentFilter.addAction(E);
        AbstractC0487bc.registerReceiver(this, this.y, intentFilter, 2);
        SkStatus.addStateListener(this);
        Ww ww = new Ww(2);
        ww.b = false;
        ww.c = 1000L;
        this.p = ww;
        new Thread(this.p, "Status Poller").start();
        if (intent != null && "app.vpn.amtunnellite:startTunnel".equals(intent.getAction())) {
            return 2;
        }
        String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        e(string, string, "openvpn_newstat", ConnectionStatus.LEVEL_START);
        if (intent != null) {
            if ("START".equals(intent.getAction())) {
                B = new Date().getTime();
                this.a = new Thread(this, "InjectorThread");
                this.c = C2507db.a(this);
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
        StringBuilder sb;
        Inet4Address inet4Address;
        try {
            this.m = new File(getApplicationInfo().nativeLibraryDir, "libsuperdns.so");
            String str = "sl" + this.c.b();
            String string = "prince";
            String string2 = "-udp";
            String string3 = "8.8.8.8:53";
            C2507db c2507db = this.c;
            c2507db.getClass();
            if (c2507db.a.getBoolean("isCustomSuperSet", false)) {
                if (this.c.d().startsWith("udp://")) {
                    this.q = this.c.d().split("udp://")[1];
                    string2 = "-udp";
                    sb = new StringBuilder();
                    sb.append(this.q);
                    sb.append(":53");
                } else {
                    if (!this.c.d().startsWith("doh://")) {
                        if (this.c.d().startsWith("dot://")) {
                            this.q = this.c.d().split("dot://")[1];
                            string2 = "-dot";
                            sb = new StringBuilder();
                            sb.append(this.q);
                            sb.append(":853");
                        }
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(this.m.getCanonicalPath());
                        arrayList.add(string2);
                        arrayList.add(string3);
                        arrayList.add("-utls");
                        arrayList.add(new String[]{"Chrome", "Firefox"}[new Random().nextInt(2)]);
                        arrayList.add("-frequency");
                        C2507db c2507db2 = this.c;
                        c2507db2.getClass();
                        arrayList.add(String.valueOf(c2507db2.a.getInt("SUPER_DNS_FREQUENCY", 0)));
                        arrayList.add("-report");
                        arrayList.add(getString(2131951660));
                        arrayList.add("-pubkey");
                        arrayList.add(string);
                        arrayList.add(str);
                        arrayList.add("127.0.0.1:7000");
                        this.f = new ProcessBuilder(new String[0]).command((String[]) arrayList.toArray(new String[0])).redirectErrorStream(true).start();
                        Rw rw = new Rw(this, 10);
                        C3303sg c3303sg = new C3303sg(this.f.getInputStream(), rw);
                        C3303sg c3303sg2 = new C3303sg(this.f.getErrorStream(), rw);
                        c3303sg.start();
                        c3303sg2.start();
                        return;
                    }
                    this.q = this.c.d().split("doh://")[1];
                    string2 = "-doh";
                    sb = new StringBuilder();
                    sb.append("https://");
                    sb.append(this.q);
                    sb.append("/dns-query");
                }
                string3 = sb.toString();
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(this.m.getCanonicalPath());
                arrayList2.add(string2);
                arrayList2.add(string3);
                arrayList2.add("-utls");
                arrayList2.add(new String[]{"Chrome", "Firefox"}[new Random().nextInt(2)]);
                arrayList2.add("-frequency");
                C2507db c2507db22 = this.c;
                c2507db22.getClass();
                arrayList2.add(String.valueOf(c2507db22.a.getInt("SUPER_DNS_FREQUENCY", 0)));
                arrayList2.add("-report");
                arrayList2.add(getString(2131951660));
                arrayList2.add("-pubkey");
                arrayList2.add(string);
                arrayList2.add(str);
                arrayList2.add("127.0.0.1:7000");
                this.f = new ProcessBuilder(new String[0]).command((String[]) arrayList2.toArray(new String[0])).redirectErrorStream(true).start();
                Rw rw2 = new Rw(this, 10);
                C3303sg c3303sg3 = new C3303sg(this.f.getInputStream(), rw2);
                C3303sg c3303sg22 = new C3303sg(this.f.getErrorStream(), rw2);
                c3303sg3.start();
                c3303sg22.start();
                return;
            }
            if (this.c.e().startsWith("udp://")) {
                String[] split = this.c.e().split("udp://");
                if (split[1].equals("direct")) {
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
                        HF hf = C;
                        if (hf != null) {
                            ((UDPClient) hf).E();
                        } else {
                            AbstractC2879kf.V(getApplicationContext(), "Error, Reconnect/Restart App!");
                        }
                        TunnelManagerHelper.stopSuperDns(getApplicationContext());
                        AbstractC2879kf.U(getApplicationContext(), "Error Parsing IP!");
                    }
                } else {
                    this.q = split[1];
                }
                string2 = "-udp";
                sb = new StringBuilder();
                sb.append(this.q);
                sb.append(":53");
            } else {
                if (!this.c.e().startsWith("doh://")) {
                    if (this.c.e().startsWith("dot://")) {
                        this.q = this.c.e().split("dot://")[1];
                        string2 = "-dot";
                        sb = new StringBuilder();
                        sb.append(this.q);
                        sb.append(":853");
                    }
                    ArrayList arrayList22 = new ArrayList();
                    arrayList22.add(this.m.getCanonicalPath());
                    arrayList22.add(string2);
                    arrayList22.add(string3);
                    arrayList22.add("-utls");
                    arrayList22.add(new String[]{"Chrome", "Firefox"}[new Random().nextInt(2)]);
                    arrayList22.add("-frequency");
                    C2507db c2507db222 = this.c;
                    c2507db222.getClass();
                    arrayList22.add(String.valueOf(c2507db222.a.getInt("SUPER_DNS_FREQUENCY", 0)));
                    arrayList22.add("-report");
                    arrayList22.add(getString(2131951660));
                    arrayList22.add("-pubkey");
                    arrayList22.add(string);
                    arrayList22.add(str);
                    arrayList22.add("127.0.0.1:7000");
                    this.f = new ProcessBuilder(new String[0]).command((String[]) arrayList22.toArray(new String[0])).redirectErrorStream(true).start();
                    Rw rw22 = new Rw(this, 10);
                    C3303sg c3303sg32 = new C3303sg(this.f.getInputStream(), rw22);
                    C3303sg c3303sg222 = new C3303sg(this.f.getErrorStream(), rw22);
                    c3303sg32.start();
                    c3303sg222.start();
                    return;
                }
                this.q = this.c.e().split("doh://")[1];
                string2 = "-doh";
                sb = new StringBuilder();
                sb.append("https://");
                sb.append(this.q);
                sb.append("/dns-query");
            }
            string3 = sb.toString();
            ArrayList arrayList222 = new ArrayList();
            arrayList222.add(this.m.getCanonicalPath());
            arrayList222.add(string2);
            arrayList222.add(string3);
            arrayList222.add("-utls");
            arrayList222.add(new String[]{"Chrome", "Firefox"}[new Random().nextInt(2)]);
            arrayList222.add("-frequency");
            C2507db c2507db2222 = this.c;
            c2507db2222.getClass();
            arrayList222.add(String.valueOf(c2507db2222.a.getInt("SUPER_DNS_FREQUENCY", 0)));
            arrayList222.add("-report");
            arrayList222.add(getString(2131951660));
            arrayList222.add("-pubkey");
            arrayList222.add(string);
            arrayList222.add(str);
            arrayList222.add("127.0.0.1:7000");
            this.f = new ProcessBuilder(new String[0]).command((String[]) arrayList222.toArray(new String[0])).redirectErrorStream(true).start();
            Rw rw222 = new Rw(this, 10);
            C3303sg c3303sg322 = new C3303sg(this.f.getInputStream(), rw222);
            C3303sg c3303sg2222 = new C3303sg(this.f.getErrorStream(), rw222);
            c3303sg322.start();
            c3303sg2222.start();
            return;
        } catch (Exception e) {
            SkStatus.logInfo(String.format("%s: %s", "SuperDNS Exception", e.getMessage()));
        }
        SkStatus.logInfo(String.format("%s: %s", "SuperDNS Exception", e.getMessage()));
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
        e(string2, string2, string, connectionStatus);
    }
}
