package prince.udp.vpn.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.IBinder;
import android.widget.Toast;
import com.wireguard.android.backend.GoBackend;
import com.wireguard.android.backend.Tunnel;
import com.wireguard.config.Interface;
import com.wireguard.config.Peer;
import defpackage.AL;
import defpackage.AbstractC2816jL;
import defpackage.AbstractC2879kf;
import defpackage.AbstractC3192qa;
import defpackage.C2507db;
import defpackage.InterfaceC2869kL;
import defpackage.InterfaceC3497wE;
import defpackage.RunnableC2765iL;
import defpackage.Ww;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.TunnelUtils;
import prince.udp.vpn.service.vpn.logger.ConnectionStatus;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class WGService extends Service implements SkStatus.StateListener {
    public static InterfaceC2869kL r;
    public static long s;
    public static InterfaceC3497wE t;
    public GoBackend a;
    public AL b;
    public C2507db c;
    public String d;
    public NotificationManager e;
    public ConnectivityManager f;
    public Ww m;
    public String n;
    public String o;
    public String p;
    public String q;

    static {
        "#ERR IndexError: string index out of range";
        "#ERR IndexError: string index out of range";
        "#ERR IndexError: string index out of range";
        s = 0L;
    }

    public static PendingIntent b(Context context) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) UDPClient.class), 67108864);
    }

    public static String c() {
        long time = new Date().getTime();
        long j = s;
        long j2 = time - j;
        if (j == 0) {
            return "#ERR IndexError: string index out of range";
        }
        return String.format("#ERR IndexError: string index out of range", Long.valueOf((j2 / 3600000) % 24), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60));
    }

    public final void a() {
        NotificationManager notificationManager = (NotificationManager) getSystemService("#ERR IndexError: string index out of range");
        NotificationChannel notificationChannel = new NotificationChannel("#ERR IndexError: string index out of range", getString(2131951717), 1);
        notificationChannel.setDescription(getString(2131951713));
        notificationChannel.enableLights(false);
        notificationChannel.setLightColor(2131100642);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel("#ERR IndexError: string index out of range", getString(2131951718), 2);
        notificationChannel2.setDescription(getString(2131951714));
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(2131100642);
        notificationManager.createNotificationChannel(notificationChannel2);
        NotificationChannel notificationChannel3 = new NotificationChannel("#ERR IndexError: string index out of range", getString(2131951719), 1);
        notificationChannel3.setDescription(getString(2131951715));
        notificationChannel3.setLightColor(2131100642);
        notificationManager.createNotificationChannel(notificationChannel3);
    }

    public final void d(String str, String str2, String str3, ConnectionStatus connectionStatus) {
        int i = AbstractC2816jL.a[connectionStatus.ordinal()];
        NotificationManager notificationManager = (NotificationManager) getSystemService("#ERR IndexError: string index out of range");
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            a();
            new Notification.Builder(this, "#ERR IndexError: string index out of range");
        } else if (i2 >= 28) {
            a();
            new Notification.Builder(this, "#ERR IndexError: string index out of range");
        } else {
            new Notification.Builder(this);
        }
        Notification.Builder ongoing = new Notification.Builder(this).setContentTitle(getString(2131951660)).setOnlyAlertOnce(true).setOngoing(true);
        ongoing.setCategory("#ERR IndexError: string index out of range");
        ongoing.setLocalOnly(true);
        int i3 = str3.equals("#ERR IndexError: string index out of range") ? -2 : str3.equals("#ERR IndexError: string index out of range") ? 2 : 0;
        ongoing.setSmallIcon(2131230926);
        if (SkStatus.getLastState().equals("#ERR IndexError: string index out of range")) {
            str = "#ERR IndexError: string index out of range" + this.c.c();
        }
        ongoing.setContentText(str);
        ongoing.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) UDPClient.class), 201326592));
        if (i3 != 0) {
            try {
                ongoing.getClass().getMethod("#ERR IndexError: string index out of range", Integer.TYPE).invoke(ongoing, Integer.valueOf(i3));
                ongoing.getClass().getMethod("#ERR IndexError: string index out of range", Boolean.TYPE).invoke(ongoing, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                SkStatus.logException(e);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            ongoing.setChannelId(str3);
        }
        if (str2 != null && !str2.equals("#ERR IndexError: string index out of range")) {
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
        String str4 = this.q;
        if (str4 != null && !str3.equals(str4)) {
            notificationManager.cancel(this.q.hashCode());
        }
        this.q = str3;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, AL] */
    public final void e() {
        String string;
        Inet4Address inet4Address;
        this.b = new Object();
        Interface.Builder builder = new Interface.Builder();
        Peer.Builder builder2 = new Peer.Builder();
        this.a = new GoBackend(this);
        InetAddress byName = InetAddress.getByName("#ERR IndexError: string index out of range");
        InetAddress byName2 = InetAddress.getByName("#ERR IndexError: string index out of range");
        ArrayList arrayList = new ArrayList();
        arrayList.add(byName);
        arrayList.add(byName2);
        try {
            Integer valueOf = Integer.valueOf(new Random().nextInt(1001));
            String R = AbstractC2879kf.R(getApplicationContext(), "#ERR IndexError: string index out of range" + valueOf + "#ERR IndexError: string index out of range");
            this.n = AbstractC2879kf.G(R, "#ERR IndexError: string index out of range");
            this.o = AbstractC2879kf.G(R, "#ERR IndexError: string index out of range");
            this.p = AbstractC2879kf.G(R, "#ERR IndexError: string index out of range");
        } catch (Exception unused) {
            AbstractC2879kf.V(getApplicationContext(), "#ERR IndexError: string index out of range");
            ((UDPClient) r).i("#ERR IndexError: string index out of range");
            InterfaceC2869kL interfaceC2869kL = r;
            if (interfaceC2869kL != null) {
                ((UDPClient) interfaceC2869kL).E();
            } else {
                AbstractC2879kf.V(getApplicationContext(), "#ERR IndexError: string index out of range");
            }
            s = 0L;
            Ww ww = this.m;
            if (ww != null) {
                ww.b = true;
            }
            SkStatus.removeStateListener(this);
            TunnelManagerHelper.stopWg(getApplicationContext());
        }
        String b = this.c.b();
        this.d = b;
        int i = 0;
        InetAddress[] inetAddressArr = new InetAddress[0];
        try {
            inetAddressArr = InetAddress.getAllByName(b);
        } catch (UnknownHostException unused2) {
            AbstractC2879kf.V(getApplicationContext(), "#ERR IndexError: string index out of range");
            ((UDPClient) r).i("#ERR IndexError: string index out of range");
            InterfaceC2869kL interfaceC2869kL2 = r;
            if (interfaceC2869kL2 != null) {
                ((UDPClient) interfaceC2869kL2).E();
            } else {
                AbstractC2879kf.V(getApplicationContext(), "#ERR IndexError: string index out of range");
            }
            s = 0L;
            Ww ww2 = this.m;
            if (ww2 != null) {
                ww2.b = true;
            }
            SkStatus.removeStateListener(this);
            TunnelManagerHelper.stopWg(getApplicationContext());
        }
        try {
            int length = inetAddressArr.length;
            while (true) {
                if (i >= length) {
                    inet4Address = null;
                    break;
                }
                InetAddress inetAddress = inetAddressArr[i];
                if (inetAddress instanceof Inet4Address) {
                    inet4Address = (Inet4Address) inetAddress;
                    break;
                }
                i++;
            }
            this.d = inet4Address.getHostAddress();
        } catch (Exception unused3) {
        }
        C2507db c2507db = this.c;
        c2507db.getClass();
        if (c2507db.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range").isEmpty()) {
            string = "#ERR IndexError: string index out of range";
        } else {
            C2507db c2507db2 = this.c;
            c2507db2.getClass();
            string = c2507db2.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range");
        }
        new Thread(new RunnableC2765iL(this, builder, arrayList, builder2, string)).start();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        this.c = new C2507db(getApplicationContext());
        s = new Date().getTime();
        this.f = (ConnectivityManager) getSystemService("#ERR IndexError: string index out of range");
        if (this.e == null) {
            this.e = (NotificationManager) getSystemService("#ERR IndexError: string index out of range");
        }
        AbstractC3192qa.f(getApplicationContext());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        s = 0L;
        try {
            if (this.a.getState(this.b) == Tunnel.State.UP) {
                this.a.setState(this.b, Tunnel.State.DOWN, null);
                ((UDPClient) r).i("#ERR IndexError: string index out of range");
                SkStatus.updateStateString("#ERR IndexError: string index out of range", getString(2131952180));
                SkStatus.logInfo("#ERR IndexError: string index out of range");
            }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "#ERR IndexError: string index out of range" + e.getMessage(), 0).show();
        }
        Ww ww = this.m;
        if (ww != null) {
            ww.b = true;
        }
        SkStatus.removeStateListener(this);
        stopForeground(true);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        SkStatus.addStateListener(this);
        Ww ww = new Ww(3);
        ww.b = false;
        ww.c = 1000L;
        this.m = ww;
        new Thread(this.m, "#ERR IndexError: string index out of range").start();
        String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        d(string, string, "#ERR IndexError: string index out of range", ConnectionStatus.LEVEL_START);
        try {
            String string2 = "#ERR IndexError: string index out of range";
            NetworkInfo activeNetworkInfo = this.f.getActiveNetworkInfo();
            SkStatus.logInfo(String.format(string2, (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? "#ERR IndexError: string index out of range" : TunnelUtils.getLocalIpAddress()));
            e();
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "#ERR IndexError: string index out of range" + e.getMessage(), 0).show();
        }
        return 1;
    }

    @Override // prince.udp.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        if (AL.a.name().equals("#ERR IndexError: string index out of range")) {
            return;
        }
        String string = "#ERR IndexError: string index out of range";
        if (connectionStatus == ConnectionStatus.LEVEL_CONNECTED) {
            string = "#ERR IndexError: string index out of range";
        }
        String string2 = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        d(string2, string2, string, connectionStatus);
    }
}
