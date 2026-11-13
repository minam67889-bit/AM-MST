package prince.dastan.vpn.service;

import android.app.Notification;
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
import android.util.Log;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC2952eM;
import defpackage.AbstractC3131gc0;
import defpackage.BinderC0877cM;
import defpackage.C0025Ap;
import defpackage.C0223If;
import defpackage.C2930e5;
import defpackage.RunnableC0129Ep;
import defpackage.S50;
import defpackage.S7;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Locale;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.vpn.PsiphonTunnelManagerThread;
import prince.dastan.vpn.service.vpn.logger.ConnectionStatus;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class PsiphonDNSService extends Service implements SkStatus.StateListener {
    public static final String j;
    public static long k;
    public static Thread l;
    public static PsiphonTunnelManagerThread m;
    public static VPNClient n;
    public static final String o;
    public static final String p;
    public NotificationManager a;
    public Handler b;
    public ConnectivityManager c;
    public RunnableC0129Ep e;
    public C0223If f;
    public String g;
    public final BinderC0877cM d = new BinderC0877cM(this, 0);
    public final C0025Ap h = new C0025Ap(1);
    public final C2930e5 i = new C2930e5(this, 3);

    static {
        Deobfuscator$BDNETVPN$app.getString(-82780531554187L);
        Deobfuscator$BDNETVPN$app.getString(-82935150376843L);
        Deobfuscator$BDNETVPN$app.getString(-82982395017099L);
        Deobfuscator$BDNETVPN$app.getString(-83051114493835L);
        j = "PsiphonDNSService";
        k = 0L;
        o = PsiphonDNSService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-83119833970571L);
        p = PsiphonDNSService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-83231503120267L);
    }

    public static PendingIntent b(Context context) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) VPNClient.class), 67108864);
    }

    public static String c() {
        long time = new Date().getTime();
        long j2 = k;
        long j3 = time - j2;
        if (j2 == 0) {
            return Deobfuscator$BDNETVPN$app.getString(-82741876848523L);
        }
        return String.format(Locale.US, Deobfuscator$BDNETVPN$app.getString(-82677452339083L), Long.valueOf((j3 / 3600000) % 24), Long.valueOf((j3 / 60000) % 60), Long.valueOf((j3 / 1000) % 60));
    }

    public final void a() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-82131991492491L));
        NotificationChannel notificationChannel = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-82187826067339L), getString(R.string.channel_name_background), 1);
        notificationChannel.setDescription(getString(R.string.channel_description_background));
        notificationChannel.enableLights(false);
        notificationChannel.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-82235070707595L), getString(R.string.channel_name_status), 2);
        notificationChannel2.setDescription(getString(R.string.channel_description_status));
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel2);
        NotificationChannel notificationChannel3 = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-82303790184331L), getString(R.string.channel_name_userreq), 1);
        notificationChannel3.setDescription(getString(R.string.channel_description_userreq));
        notificationChannel3.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel3);
    }

    public final void d() {
        String message;
        try {
            NetworkInfo activeNetworkInfo = this.c.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                message = Deobfuscator$BDNETVPN$app.getString(-82509948614539L);
            } else {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtypeName == null) {
                    subtypeName = Deobfuscator$BDNETVPN$app.getString(-82570078156683L);
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    extraInfo = Deobfuscator$BDNETVPN$app.getString(-82574373123979L);
                }
                message = String.format(Deobfuscator$BDNETVPN$app.getString(-82578668091275L), activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState(), extraInfo, subtypeName);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        SkStatus.logInfo(message);
    }

    public final void e(String str, String str2, String str3, ConnectionStatus connectionStatus) {
        int i = AbstractC2952eM.a[connectionStatus.ordinal()];
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-81444796725131L));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            a();
            new Notification.Builder(this, Deobfuscator$BDNETVPN$app.getString(-81500631299979L));
        } else if (i2 >= 28) {
            a();
            new Notification.Builder(this, Deobfuscator$BDNETVPN$app.getString(-81569350776715L));
        } else {
            new Notification.Builder(this);
        }
        Notification.Builder ongoing = new Notification.Builder(this).setContentTitle(getString(R.string.app)).setOnlyAlertOnce(true).setOngoing(true);
        ongoing.setCategory(Deobfuscator$BDNETVPN$app.getString(-81638070253451L));
        ongoing.setLocalOnly(true);
        int i3 = str3.equals(Deobfuscator$BDNETVPN$app.getString(-81672429991819L)) ? -2 : str3.equals(Deobfuscator$BDNETVPN$app.getString(-81719674632075L)) ? 2 : 0;
        ongoing.setSmallIcon(R.drawable.ic_app_icon);
        if (SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-81788394108811L))) {
            ongoing.setContentText(Deobfuscator$BDNETVPN$app.getString(-81831343781771L) + this.f.g());
        } else {
            ongoing.setContentText(str);
        }
        ongoing.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VPNClient.class), 201326592));
        if (i3 != 0) {
            try {
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-81895768291211L), Integer.TYPE).invoke(ongoing, Integer.valueOf(i3));
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-81947307898763L), Boolean.TYPE).invoke(ongoing, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                SkStatus.logException(e);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            ongoing.setChannelId(str3);
        }
        if (str2 != null && !str2.equals(Deobfuscator$BDNETVPN$app.getString(-81891473323915L))) {
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
        String str4 = this.g;
        if (str4 != null && !str3.equals(str4)) {
            notificationManager.cancel(this.g.hashCode());
        }
        this.g = str3;
    }

    public final void f() {
        m = new PsiphonTunnelManagerThread(this.b, this);
        k = new Date().getTime();
        Thread thread = new Thread(m);
        l = thread;
        thread.start();
        SkStatus.logInfo(R.string.tunnel_start, new Object[0]);
    }

    public final synchronized void g() {
        try {
            k = 0L;
            PsiphonTunnelManagerThread psiphonTunnelManagerThread = m;
            if (psiphonTunnelManagerThread != null) {
                psiphonTunnelManagerThread.stopAll();
                d();
                Thread thread = l;
                if (thread != null) {
                    thread.interrupt();
                    SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                }
                m = null;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.d;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Log.i(j, Deobfuscator$BDNETVPN$app.getString(-80753306990475L));
        super.onCreate();
        this.b = new Handler();
        this.c = (ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-80791961696139L));
        if (this.a == null) {
            this.a = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-80847796270987L));
        }
        this.f = C0223If.d(this);
        S50.c(getApplicationContext());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.i(j, Deobfuscator$BDNETVPN$app.getString(-81401847052171L));
        super.onDestroy();
        g();
        RunnableC0129Ep runnableC0129Ep = this.e;
        if (runnableC0129Ep != null) {
            runnableC0129Ep.b = true;
        }
        try {
            unregisterReceiver(this.i);
        } catch (IllegalArgumentException unused) {
        }
        try {
            this.c.unregisterNetworkCallback(this.h);
        } catch (IllegalArgumentException unused2) {
        }
        SkStatus.removeStateListener(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.i(j, Deobfuscator$BDNETVPN$app.getString(-80903630845835L));
        this.c.registerDefaultNetworkCallback(this.h);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(p);
        intentFilter.addAction(o);
        AbstractC3131gc0.H(this, this.i, intentFilter);
        SkStatus.addStateListener(this);
        RunnableC0129Ep runnableC0129Ep = new RunnableC0129Ep(1);
        runnableC0129Ep.b = false;
        this.e = runnableC0129Ep;
        new Thread(this.e, Deobfuscator$BDNETVPN$app.getString(-80968055355275L)).start();
        if (intent != null && Deobfuscator$BDNETVPN$app.getString(-81028184897419L).equals(intent.getAction())) {
            return 2;
        }
        String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        e(string, string, Deobfuscator$BDNETVPN$app.getString(-81182803720075L), ConnectionStatus.LEVEL_START);
        new Thread(new S7(this, 17)).start();
        return 2;
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        if (l == null) {
            return;
        }
        String string = Deobfuscator$BDNETVPN$app.getString(-82372509661067L);
        if (connectionStatus == ConnectionStatus.LEVEL_CONNECTED) {
            string = Deobfuscator$BDNETVPN$app.getString(-82441229137803L);
        }
        String string2 = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        e(string2, string2, string, connectionStatus);
    }
}
