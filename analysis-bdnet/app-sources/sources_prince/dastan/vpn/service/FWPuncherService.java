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
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import dastan.prince.bdfreevpn.R;
import defpackage.A0;
import defpackage.AbstractC0051Bp;
import defpackage.AbstractC0482Sf;
import defpackage.AbstractC3131gc0;
import defpackage.BinderC0077Cp;
import defpackage.C0025Ap;
import defpackage.C0223If;
import defpackage.C2882dV;
import defpackage.C2930e5;
import defpackage.C3462kl;
import defpackage.C4651zp;
import defpackage.F00;
import defpackage.RunnableC0129Ep;
import defpackage.S50;
import defpackage.S7;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.TunnelState;
import prince.dastan.vpn.service.vpn.TunnelVpnManager;
import prince.dastan.vpn.service.vpn.TunnelVpnService;
import prince.dastan.vpn.service.vpn.TunnelVpnSettings;
import prince.dastan.vpn.service.vpn.logger.ConnectionStatus;
import prince.dastan.vpn.service.vpn.logger.SkStatus;
import prince.dastan.vpn.utils.PUtils;

/* loaded from: classes2.dex */
public class FWPuncherService extends Service implements Runnable, Handler.Callback, SkStatus.StateListener {
    public static boolean o;
    public static final int p;
    public static long q;
    public static VPNClient r;
    public static VPNClient s;
    public static final String t;
    public static final String u;
    public Thread a;
    public Handler b;
    public C0223If c;
    public VPNClient d;
    public Process e;
    public File f;
    public NotificationManager g;
    public ConnectivityManager h;
    public RunnableC0129Ep i;
    public String j;
    public String l;
    public final C4651zp k = new C4651zp(this);
    public final C0025Ap m = new C0025Ap(0);
    public final C2930e5 n = new C2930e5(this, 2);

    static {
        Deobfuscator$BDNETVPN$app.getString(-79941558171531L);
        Deobfuscator$BDNETVPN$app.getString(-79984507844491L);
        Deobfuscator$BDNETVPN$app.getString(-80139126667147L);
        Deobfuscator$BDNETVPN$app.getString(-80186371307403L);
        Deobfuscator$BDNETVPN$app.getString(-80255090784139L);
        o = false;
        p = 10801;
        q = 0L;
        t = FWPuncherService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-80323810260875L);
        u = FWPuncherService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-80435479410571L);
    }

    public static PendingIntent c(Context context) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) VPNClient.class), 67108864);
    }

    public static String d() {
        long time = new Date().getTime();
        long j = q;
        long j2 = time - j;
        if (j == 0) {
            return Deobfuscator$BDNETVPN$app.getString(-79902903465867L);
        }
        return String.format(Locale.US, Deobfuscator$BDNETVPN$app.getString(-79838478956427L), Long.valueOf((j2 / 3600000) % 24), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60));
    }

    public static boolean e() {
        TunnelState tunnelState = TunnelState.getTunnelState();
        return tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null;
    }

    public final synchronized void a() {
        synchronized (this) {
            if (e()) {
                SkStatus.logInfo(R.string.service_tunnel_stopping, new Object[0]);
                TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                if (tunnelManager != null) {
                    tunnelManager.signalStopService();
                }
                try {
                    unregisterReceiver(this.k);
                } catch (IllegalArgumentException unused) {
                }
            }
        }
    }

    public final void b() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-79293018109835L));
        String string = getString(R.string.channel_name_background);
        A0.B();
        NotificationChannel e = A0.e(Deobfuscator$BDNETVPN$app.getString(-79348852684683L), string);
        e.setDescription(getString(R.string.channel_description_background));
        e.enableLights(false);
        e.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(e);
        String string2 = getString(R.string.channel_name_status);
        A0.B();
        NotificationChannel z = A0.z(Deobfuscator$BDNETVPN$app.getString(-79396097324939L), string2);
        z.setDescription(getString(R.string.channel_description_status));
        z.enableLights(true);
        z.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(z);
        String string3 = getString(R.string.channel_name_userreq);
        A0.B();
        NotificationChannel e2 = A0.e(Deobfuscator$BDNETVPN$app.getString(-79464816801675L), string3);
        e2.setDescription(getString(R.string.channel_description_userreq));
        e2.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(e2);
    }

    public final void f() {
        String message;
        try {
            NetworkInfo activeNetworkInfo = this.h.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                message = Deobfuscator$BDNETVPN$app.getString(-79670975231883L);
            } else {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtypeName == null) {
                    subtypeName = Deobfuscator$BDNETVPN$app.getString(-79731104774027L);
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    extraInfo = Deobfuscator$BDNETVPN$app.getString(-79735399741323L);
                }
                message = String.format(Deobfuscator$BDNETVPN$app.getString(-79739694708619L), activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState(), extraInfo, subtypeName);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        SkStatus.logInfo(message);
    }

    public final void g(String str, String str2, String str3, ConnectionStatus connectionStatus) {
        int i = AbstractC0051Bp.a[connectionStatus.ordinal()];
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-78605823342475L));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            b();
            A0.w(this, Deobfuscator$BDNETVPN$app.getString(-78661657917323L));
        } else if (i2 >= 28) {
            b();
            A0.w(this, Deobfuscator$BDNETVPN$app.getString(-78730377394059L));
        } else {
            new Notification.Builder(this);
        }
        Notification.Builder ongoing = new Notification.Builder(this).setContentTitle(getString(R.string.app)).setOnlyAlertOnce(true).setOngoing(true);
        ongoing.setCategory(Deobfuscator$BDNETVPN$app.getString(-78799096870795L));
        ongoing.setLocalOnly(true);
        int i3 = str3.equals(Deobfuscator$BDNETVPN$app.getString(-78833456609163L)) ? -2 : str3.equals(Deobfuscator$BDNETVPN$app.getString(-78880701249419L)) ? 2 : 0;
        ongoing.setSmallIcon(R.drawable.ic_app_icon);
        if (SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-78949420726155L))) {
            ongoing.setContentText(Deobfuscator$BDNETVPN$app.getString(-78992370399115L) + this.c.g());
        } else {
            ongoing.setContentText(str);
        }
        ongoing.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VPNClient.class), 201326592));
        if (i3 != 0) {
            try {
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-79056794908555L), Integer.TYPE).invoke(ongoing, Integer.valueOf(i3));
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-79108334516107L), Boolean.TYPE).invoke(ongoing, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                SkStatus.logException(e);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            ongoing.setChannelId(str3);
        }
        if (str2 != null && !str2.equals(Deobfuscator$BDNETVPN$app.getString(-79052499941259L))) {
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
        String str4 = this.l;
        if (str4 != null && !str3.equals(str4)) {
            notificationManager.cancel(this.l.hashCode());
        }
        this.l = str3;
    }

    public final void h() {
        String pDecrypt;
        String[] strArr;
        Inet4Address inet4Address;
        SkStatus.logInfo(R.string.service_tunnel_start, new Object[0]);
        IntentFilter intentFilter = new IntentFilter(Deobfuscator$BDNETVPN$app.getString(-76192051722123L));
        intentFilter.addAction(Deobfuscator$BDNETVPN$app.getString(-76316605773707L));
        AbstractC3131gc0.H(getApplicationContext(), this.k, intentFilter);
        String format = String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-76419684988811L), Integer.valueOf(p));
        if (this.c.n() == 3) {
            pDecrypt = this.j;
        } else if (this.c.n() == 0) {
            pDecrypt = this.j;
        } else {
            C0223If c0223If = this.c;
            c0223If.getClass();
            pDecrypt = c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-161863764375435L), Deobfuscator$BDNETVPN$app.getString(-161945368754059L)).equals(Deobfuscator$BDNETVPN$app.getString(-76475519563659L)) ? PUtils.pDecrypt(getApplicationContext(), this.c.j()) : this.c.j();
        }
        try {
            InetAddress[] allByName = InetAddress.getAllByName(pDecrypt);
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
            pDecrypt = inet4Address.getHostAddress();
        } catch (UnknownHostException unused) {
            i();
            F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-76496994400139L));
        }
        String[] strArr2 = {pDecrypt};
        if (this.c.c().booleanValue()) {
            C0223If c0223If2 = this.c;
            c0223If2.getClass();
            strArr = c0223If2.a.getString(Deobfuscator$BDNETVPN$app.getString(-162327620843403L), Deobfuscator$BDNETVPN$app.getString(-162396340320139L)).split(Deobfuscator$BDNETVPN$app.getString(-76574303811467L));
            for (int i2 = 0; i2 < strArr.length; i2++) {
                strArr[i2] = strArr[i2].trim();
            }
        } else {
            strArr = new String[]{Deobfuscator$BDNETVPN$app.getString(-76582893746059L), Deobfuscator$BDNETVPN$app.getString(-76617253484427L)};
        }
        String[] strArr3 = strArr;
        if (e()) {
            Log.d(Deobfuscator$BDNETVPN$app.getString(-76651613222795L), Deobfuscator$BDNETVPN$app.getString(-76694562895755L));
            F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-76797642110859L));
            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
            if (tunnelManager != null) {
                tunnelManager.restartTunnel(format);
                return;
            }
            return;
        }
        Intent intent = new Intent(getApplicationContext(), (Class<?>) TunnelVpnService.class);
        intent.setFlags(268435456);
        intent.putExtra(Deobfuscator$BDNETVPN$app.getString(-76913606227851L), new TunnelVpnSettings(format, true, strArr3, true, null, strArr2, false, false, new String[0], true, false));
        if (startService(intent) == null) {
            SkStatus.logInfo(R.string.service_tunnel_failed, new Object[0]);
            throw new IOException(getString(R.string.vpn_service_failed));
        }
        TunnelState.getTunnelState().setStartingTunnelManager();
        SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-76965145835403L), Deobfuscator$BDNETVPN$app.getString(-77008095508363L));
        r.addStatus(Deobfuscator$BDNETVPN$app.getString(-77085404919691L));
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            TunnelManagerHelper.startSsh(getApplicationContext());
            return true;
        }
        if (i != 2) {
            return true;
        }
        VPNClient vPNClient = this.d;
        CountDownTimer countDownTimer = vPNClient.C;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        vPNClient.R();
        vPNClient.J();
        return true;
    }

    public final void i() {
        SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-77128354592651L), getString(R.string.stopping_service_ssh));
        SkStatus.logInfo(getString(R.string.stopping_service_ssh));
        new Thread(new S7(this, 8)).start();
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return new BinderC0077Cp(this);
    }

    @Override // android.app.Service
    public final void onCreate() {
        this.b = new Handler(this);
        this.h = (ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-75543511660427L));
        if (this.g == null) {
            this.g = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-75599346235275L));
        }
        S50.c(getApplicationContext());
        super.onCreate();
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.i(Deobfuscator$BDNETVPN$app.getString(-75655180810123L), Deobfuscator$BDNETVPN$app.getString(-75698130483083L));
        this.h.registerDefaultNetworkCallback(this.m);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(u);
        intentFilter.addAction(t);
        AbstractC3131gc0.H(this, this.n, intentFilter);
        SkStatus.addStateListener(this);
        RunnableC0129Ep runnableC0129Ep = new RunnableC0129Ep(0);
        runnableC0129Ep.b = false;
        this.i = runnableC0129Ep;
        new Thread(this.i, Deobfuscator$BDNETVPN$app.getString(-75762554992523L)).start();
        if (intent == null || !Deobfuscator$BDNETVPN$app.getString(-75822684534667L).equals(intent.getAction())) {
            String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
            g(string, string, Deobfuscator$BDNETVPN$app.getString(-75977303357323L), ConnectionStatus.LEVEL_START);
            if (intent != null) {
                if (Deobfuscator$BDNETVPN$app.getString(-76046022834059L).equals(intent.getAction())) {
                    q = new Date().getTime();
                    this.a = new Thread(this, Deobfuscator$BDNETVPN$app.getString(-76071792637835L));
                    this.c = C0223If.d(this);
                    o = true;
                    Thread thread = this.a;
                    if (thread != null) {
                        thread.interrupt();
                    }
                    this.a.start();
                }
            }
        }
        return 2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Inet4Address inet4Address;
        String pEncrypt;
        try {
            this.f = new File(getApplicationInfo().nativeLibraryDir, Deobfuscator$BDNETVPN$app.getString(-77167009298315L));
            int i = this.c.n() == 2 ? 1 : this.c.n() == 3 ? 2 : this.c.n() == 5 ? 3 : 0;
            C0223If c0223If = this.c;
            c0223If.getClass();
            if (c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-163006225676171L), Deobfuscator$BDNETVPN$app.getString(-163074945152907L)).equals(Deobfuscator$BDNETVPN$app.getString(-77338807990155L))) {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(this.c.l());
                    int length = allByName.length;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= length) {
                            inet4Address = null;
                            break;
                        }
                        InetAddress inetAddress = allByName[i2];
                        if (inetAddress instanceof Inet4Address) {
                            inet4Address = (Inet4Address) inetAddress;
                            break;
                        }
                        i2++;
                    }
                    this.j = inet4Address.getHostAddress();
                } catch (UnknownHostException unused) {
                    i();
                    F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-77360282826635L));
                }
            } else {
                this.j = this.c.l();
            }
            C0223If c0223If2 = this.c;
            c0223If2.getClass();
            String string = c0223If2.a.getString(Deobfuscator$BDNETVPN$app.getString(-158771387922315L), Deobfuscator$BDNETVPN$app.getString(-158827222497163L));
            StringBuilder sb = new StringBuilder();
            sb.append(this.c.j());
            sb.append(Deobfuscator$BDNETVPN$app.getString(-77437592237963L));
            C0223If c0223If3 = this.c;
            c0223If3.getClass();
            sb.append(c0223If3.a.getString(Deobfuscator$BDNETVPN$app.getString(-158883057072011L), Deobfuscator$BDNETVPN$app.getString(-158930301712267L)));
            String sb2 = sb.toString();
            Locale locale = Locale.ENGLISH;
            String format = String.format(locale, String.valueOf(i), new Object[0]);
            C0223If c0223If4 = this.c;
            c0223If4.getClass();
            if (c0223If4.a.getString(Deobfuscator$BDNETVPN$app.getString(-161863764375435L), Deobfuscator$BDNETVPN$app.getString(-161945368754059L)).equals(Deobfuscator$BDNETVPN$app.getString(-77446182172555L))) {
                Context applicationContext = getApplicationContext();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(PUtils.pDecrypt(getApplicationContext(), this.c.j()));
                sb3.append(Deobfuscator$BDNETVPN$app.getString(-77467657009035L));
                C0223If c0223If5 = this.c;
                c0223If5.getClass();
                sb3.append(c0223If5.a.getString(Deobfuscator$BDNETVPN$app.getString(-158883057072011L), Deobfuscator$BDNETVPN$app.getString(-158930301712267L)));
                pEncrypt = PUtils.pEncrypt(applicationContext, sb3.toString());
            } else if (i == 2) {
                Context applicationContext2 = getApplicationContext();
                StringBuilder sb4 = new StringBuilder();
                sb4.append(this.j);
                sb4.append(Deobfuscator$BDNETVPN$app.getString(-77484836878219L));
                C0223If c0223If6 = this.c;
                c0223If6.getClass();
                sb4.append(c0223If6.a.getString(Deobfuscator$BDNETVPN$app.getString(-158573819426699L), Deobfuscator$BDNETVPN$app.getString(-158612474132363L)));
                pEncrypt = PUtils.pEncrypt(applicationContext2, sb4.toString());
            } else if (i == 0) {
                Context applicationContext3 = getApplicationContext();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.j);
                sb5.append(Deobfuscator$BDNETVPN$app.getString(-77476246943627L));
                C0223If c0223If7 = this.c;
                c0223If7.getClass();
                sb5.append(c0223If7.a.getString(Deobfuscator$BDNETVPN$app.getString(-158517984851851L), Deobfuscator$BDNETVPN$app.getString(-158556639557515L)));
                pEncrypt = PUtils.pEncrypt(applicationContext3, sb5.toString());
            } else {
                pEncrypt = PUtils.pEncrypt(getApplicationContext(), sb2);
            }
            File file = new File(this.f.getCanonicalPath());
            ArrayList arrayList = new ArrayList();
            arrayList.add(file.getAbsolutePath());
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77493426812811L));
            arrayList.add(format);
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77519196616587L));
            arrayList.add(String.format(locale, Deobfuscator$BDNETVPN$app.getString(-77553556354955L) + AbstractC0482Sf.a, new Object[0]));
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77600800995211L));
            arrayList.add(String.format(locale, pEncrypt, new Object[0]));
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77630865766283L));
            arrayList.add(String.format(locale, getString(R.string.app), new Object[0]));
            if (i == 1) {
                if (this.c.f().contains(Deobfuscator$BDNETVPN$app.getString(-77665225504651L))) {
                    arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77721060079499L));
                }
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77776894654347L));
                arrayList.add(String.format(locale, string, new Object[0]));
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77815549360011L));
                arrayList.add(String.format(locale, PUtils.pEncrypt(getApplicationContext(), this.j), new Object[0]));
            } else if (i == 2) {
                if (this.c.f().contains(Deobfuscator$BDNETVPN$app.getString(-77841319163787L))) {
                    arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77897153738635L));
                }
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-77952988313483L));
                arrayList.add(String.format(locale, this.c.m(), new Object[0]));
                C0223If c0223If8 = this.c;
                c0223If8.getClass();
                if (c0223If8.a.getString(Deobfuscator$BDNETVPN$app.getString(-161584591501195L), Deobfuscator$BDNETVPN$app.getString(-161649016010635L)).equals(Deobfuscator$BDNETVPN$app.getString(-77974463149963L))) {
                    arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78000232953739L));
                }
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78068952430475L));
                C0223If c0223If9 = this.c;
                c0223If9.getClass();
                arrayList.add(String.format(locale, c0223If9.a.getString(Deobfuscator$BDNETVPN$app.getString(-161722030454667L), Deobfuscator$BDNETVPN$app.getString(-161773570062219L)), new Object[0]));
            } else if (i == 3) {
                if (this.c.f().contains(Deobfuscator$BDNETVPN$app.getString(-78120492038027L))) {
                    arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78176326612875L));
                }
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78232161187723L));
                arrayList.add(String.format(locale, string, new Object[0]));
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78270815893387L));
                arrayList.add(String.format(locale, this.c.m(), new Object[0]));
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78292290729867L));
                arrayList.add(String.format(locale, PUtils.pEncrypt(getApplicationContext(), this.j), new Object[0]));
                C0223If c0223If10 = this.c;
                c0223If10.getClass();
                if (c0223If10.a.getString(Deobfuscator$BDNETVPN$app.getString(-161584591501195L), Deobfuscator$BDNETVPN$app.getString(-161649016010635L)).equals(Deobfuscator$BDNETVPN$app.getString(-78318060533643L))) {
                    arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78343830337419L));
                }
                arrayList.add(Deobfuscator$BDNETVPN$app.getString(-78412549814155L));
                C0223If c0223If11 = this.c;
                c0223If11.getClass();
                arrayList.add(String.format(locale, c0223If11.a.getString(Deobfuscator$BDNETVPN$app.getString(-161722030454667L), Deobfuscator$BDNETVPN$app.getString(-161773570062219L)), new Object[0]));
            }
            this.e = new ProcessBuilder(new String[0]).command((String[]) arrayList.toArray(new String[0])).redirectErrorStream(true).start();
            C2882dV c2882dV = new C2882dV(this, 16);
            C3462kl c3462kl = new C3462kl(this.e.getInputStream(), c2882dV);
            C3462kl c3462kl2 = new C3462kl(this.e.getErrorStream(), c2882dV);
            c3462kl.start();
            c3462kl2.start();
        } catch (Exception e) {
            SkStatus.logInfo(String.format(Deobfuscator$BDNETVPN$app.getString(-78575758571403L), Deobfuscator$BDNETVPN$app.getString(-78464089421707L), e.getMessage()));
        }
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        if (this.a == null) {
            return;
        }
        String string = Deobfuscator$BDNETVPN$app.getString(-79533536278411L);
        if (connectionStatus == ConnectionStatus.LEVEL_CONNECTED) {
            string = Deobfuscator$BDNETVPN$app.getString(-79602255755147L);
        }
        String string2 = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        g(string2, string2, string, connectionStatus);
    }
}
