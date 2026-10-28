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
import defpackage.AbstractC3131gc0;
import defpackage.AbstractC3877q10;
import defpackage.BinderC0877cM;
import defpackage.C0025Ap;
import defpackage.C0223If;
import defpackage.C2930e5;
import defpackage.C3462kl;
import defpackage.F00;
import defpackage.RT;
import defpackage.RunnableC0129Ep;
import defpackage.S50;
import defpackage.S7;
import defpackage.TO;
import defpackage.UT;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.TunnelManagerThread;
import prince.dastan.vpn.service.vpn.VpnUtils;
import prince.dastan.vpn.service.vpn.logger.ConnectionStatus;
import prince.dastan.vpn.service.vpn.logger.SkStatus;
import prince.dastan.vpn.utils.PUtils;
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes2.dex */
public class SocksDNSService extends Service implements SkStatus.StateListener {
    public static final String B;
    public static long C;
    public static Thread D;
    public static TunnelManagerThread E;
    public static boolean F;
    public static VPNClient G;
    public static VPNClient H;
    public static final String I;
    public static final String J;
    public NotificationManager a;
    public Handler b;
    public ConnectivityManager c;
    public RunnableC0129Ep e;
    public C0223If f;
    public String g;
    public Process j;
    public File k;
    public String l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public File v;
    public Process w;
    public File x;
    public String y;
    public final BinderC0877cM d = new BinderC0877cM(this, 1);
    public final String h = Deobfuscator$BDNETVPN$app.getString(-85516425721739L);
    public final String i = Deobfuscator$BDNETVPN$app.getString(-85550785460107L);
    public final C0025Ap z = new C0025Ap(2);
    public final C2930e5 A = new C2930e5(this, 4);

    static {
        Deobfuscator$BDNETVPN$app.getString(-92465682806667L);
        Deobfuscator$BDNETVPN$app.getString(-92620301629323L);
        Deobfuscator$BDNETVPN$app.getString(-92667546269579L);
        Deobfuscator$BDNETVPN$app.getString(-92736265746315L);
        B = "SocksDNSService";
        C = 0L;
        F = false;
        I = SocksDNSService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-92804985223051L);
        J = SocksDNSService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-92916654372747L);
    }

    public static PendingIntent b(Context context) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) VPNClient.class), 67108864);
    }

    public static String c() {
        long time = new Date().getTime();
        long j = C;
        long j2 = time - j;
        if (j == 0) {
            return Deobfuscator$BDNETVPN$app.getString(-88295269562251L);
        }
        return String.format(Locale.US, Deobfuscator$BDNETVPN$app.getString(-88230845052811L), Long.valueOf((j2 / 3600000) % 24), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60));
    }

    public static boolean f(File file, String str) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final void a() {
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-87685384206219L));
        NotificationChannel notificationChannel = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-87741218781067L), getString(R.string.channel_name_background), 1);
        notificationChannel.setDescription(getString(R.string.channel_description_background));
        notificationChannel.enableLights(false);
        notificationChannel.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-87788463421323L), getString(R.string.channel_name_status), 2);
        notificationChannel2.setDescription(getString(R.string.channel_description_status));
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel2);
        NotificationChannel notificationChannel3 = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-87857182898059L), getString(R.string.channel_name_userreq), 1);
        notificationChannel3.setDescription(getString(R.string.channel_description_userreq));
        notificationChannel3.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel3);
    }

    public final void d() {
        String format;
        Inet4Address inet4Address;
        try {
            try {
                h();
                String str = getApplicationInfo().nativeLibraryDir;
                C0223If c0223If = this.f;
                c0223If.getClass();
                boolean equals = c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-162203066791819L), Deobfuscator$BDNETVPN$app.getString(-162254606399371L)).equals(Deobfuscator$BDNETVPN$app.getString(-88333924267915L));
                String str2 = this.i;
                if (equals && this.f.o() && this.f.t().booleanValue()) {
                    this.k = new File(str, str2 + Deobfuscator$BDNETVPN$app.getString(-88346809169803L));
                } else if (this.f.o() || !this.f.t().booleanValue()) {
                    this.k = new File(str, this.h + Deobfuscator$BDNETVPN$app.getString(-88381168908171L));
                } else {
                    this.k = new File(str, str2 + Deobfuscator$BDNETVPN$app.getString(-88363989038987L));
                }
                if (this.k == null) {
                    G.addStatus(Deobfuscator$BDNETVPN$app.getString(-88398348777355L));
                    throw new IOException(Deobfuscator$BDNETVPN$app.getString(-88458478319499L));
                }
                if (this.f.o()) {
                    this.u = this.g;
                } else {
                    this.u = this.f.l();
                }
                if (this.u.contains(Deobfuscator$BDNETVPN$app.getString(-88535787730827L))) {
                    String[] split = this.u.split(Deobfuscator$BDNETVPN$app.getString(-88544377665419L));
                    String str3 = split[new Random().nextInt(split.length)];
                    if (str3.contains(Deobfuscator$BDNETVPN$app.getString(-88552967600011L))) {
                        String replaceAll = str3.replaceAll(Deobfuscator$BDNETVPN$app.getString(-88561557534603L), Deobfuscator$BDNETVPN$app.getString(-88595917272971L));
                        str3 = F00.f(Integer.valueOf(replaceAll.split(Deobfuscator$BDNETVPN$app.getString(-88600212240267L))[0]).intValue(), Integer.valueOf(replaceAll.split(Deobfuscator$BDNETVPN$app.getString(-88608802174859L))[1]).intValue()) + F00.e(str3);
                    }
                    this.u = str3;
                } else if (this.u.contains(Deobfuscator$BDNETVPN$app.getString(-88617392109451L))) {
                    String replaceAll2 = this.u.replaceAll(Deobfuscator$BDNETVPN$app.getString(-88625982044043L), Deobfuscator$BDNETVPN$app.getString(-88660341782411L));
                    this.u = F00.f(Integer.valueOf(replaceAll2.split(Deobfuscator$BDNETVPN$app.getString(-88664636749707L))[0]).intValue(), Integer.valueOf(replaceAll2.split(Deobfuscator$BDNETVPN$app.getString(-88673226684299L))[1]).intValue()) + F00.e(this.f.l());
                }
                InetAddress[] inetAddressArr = new InetAddress[0];
                try {
                    inetAddressArr = InetAddress.getAllByName(this.u);
                } catch (UnknownHostException unused) {
                    F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-88681816618891L));
                    VPNClient vPNClient = G;
                    if (vPNClient != null) {
                        vPNClient.stopSocksOpenVPN();
                    } else {
                        F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-88759126030219L));
                    }
                    TunnelManagerHelper.stopSocksHttp(getApplicationContext());
                }
                try {
                    int length = inetAddressArr.length;
                    int i = 0;
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
                    this.u = inet4Address.getHostAddress();
                } catch (Exception unused2) {
                }
                this.f.I(this.u);
                StringBuilder sb = new StringBuilder();
                sb.append(this.u);
                sb.append(Deobfuscator$BDNETVPN$app.getString(-88887975049099L));
                C0223If c0223If2 = this.f;
                c0223If2.getClass();
                sb.append(c0223If2.a.getString(Deobfuscator$BDNETVPN$app.getString(-158883057072011L), Deobfuscator$BDNETVPN$app.getString(-158930301712267L)));
                this.o = sb.toString();
                this.r = Deobfuscator$BDNETVPN$app.getString(-88896564983691L);
                this.p = Deobfuscator$BDNETVPN$app.getString(-88905154918283L);
                this.q = Deobfuscator$BDNETVPN$app.getString(-88913744852875L);
                this.n = Deobfuscator$BDNETVPN$app.getString(-88922334787467L);
                this.s = Deobfuscator$BDNETVPN$app.getString(-88935219689355L);
                String string = Deobfuscator$BDNETVPN$app.getString(-89003939166091L);
                this.l = string;
                this.m = String.valueOf((Integer.parseInt(string) * 5) / 2);
                this.t = Deobfuscator$BDNETVPN$app.getString(-89034003937163L);
                Deobfuscator$BDNETVPN$app.getString(-89042593871755L);
                if (this.f.o()) {
                    C0223If c0223If3 = this.f;
                    c0223If3.getClass();
                    format = c0223If3.a.getString(Deobfuscator$BDNETVPN$app.getString(-162203066791819L), Deobfuscator$BDNETVPN$app.getString(-162254606399371L)).equals(Deobfuscator$BDNETVPN$app.getString(-89046888839051L)) ? String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-89059773740939L), PUtils.pEncrypt(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-90013256480651L)), this.t, this.r, this.p, this.q, this.n, this.s, this.l, this.m, getString(R.string.app)) : String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-90077680990091L), PUtils.pEncrypt(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-90949559351179L)), this.t, this.p, this.q, this.n, this.s, this.l, this.m, getString(R.string.app));
                } else {
                    format = String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-91013983860619L), PUtils.pEncrypt(getApplicationContext(), this.o), this.t, this.r, this.p, this.q, this.n, this.s, this.l, this.m, getString(R.string.app));
                }
                File file = new File(getFilesDir().getPath(), Deobfuscator$BDNETVPN$app.getString(-91967466600331L));
                this.v = file;
                if (f(file, format)) {
                    this.j = new ProcessBuilder(new String[0]).command(new File(this.k.getCanonicalPath()).getAbsolutePath(), Deobfuscator$BDNETVPN$app.getString(-92019006207883L), Deobfuscator$BDNETVPN$app.getString(-92049070978955L), this.v.getAbsolutePath()).redirectErrorStream(true).start();
                    SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-92087725684619L), getString(R.string.state_connecting));
                    SkStatus.logInfo(R.string.state_connecting, new Object[0]);
                    G.addStatus(Deobfuscator$BDNETVPN$app.getString(-92134970324875L));
                    TO to = new TO(this, 3);
                    C3462kl c3462kl = new C3462kl(this.j.getInputStream(), to);
                    C3462kl c3462kl2 = new C3462kl(this.j.getErrorStream(), to);
                    c3462kl.start();
                    c3462kl2.start();
                    this.j.waitFor();
                }
            } catch (NullPointerException unused3) {
                i();
                k();
                VPNClient vPNClient2 = G;
                if (vPNClient2 != null) {
                    vPNClient2.stopSocksOpenVPN();
                } else {
                    F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-92242344507275L));
                }
                TunnelManagerHelper.stopSocksHttp(getApplicationContext());
                F00.g(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-92371193526155L));
            }
        } catch (IOException | InterruptedException unused4) {
        }
    }

    public final void e() {
        String message;
        try {
            NetworkInfo activeNetworkInfo = this.c.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                message = Deobfuscator$BDNETVPN$app.getString(-88063341328267L);
            } else {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtypeName == null) {
                    subtypeName = Deobfuscator$BDNETVPN$app.getString(-88123470870411L);
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    extraInfo = Deobfuscator$BDNETVPN$app.getString(-88127765837707L);
                }
                message = String.format(Deobfuscator$BDNETVPN$app.getString(-88132060805003L), activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState(), extraInfo, subtypeName);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        SkStatus.logInfo(message);
    }

    public final void g(String str, String str2, String str3, ConnectionStatus connectionStatus) {
        int i = UT.a[connectionStatus.ordinal()];
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-86998189438859L));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            a();
            new Notification.Builder(this, Deobfuscator$BDNETVPN$app.getString(-87054024013707L));
        } else if (i2 >= 28) {
            a();
            new Notification.Builder(this, Deobfuscator$BDNETVPN$app.getString(-87122743490443L));
        } else {
            new Notification.Builder(this);
        }
        Notification.Builder ongoing = new Notification.Builder(this).setContentTitle(getString(R.string.app)).setOnlyAlertOnce(true).setOngoing(true);
        ongoing.setCategory(Deobfuscator$BDNETVPN$app.getString(-87191462967179L));
        ongoing.setLocalOnly(true);
        int i3 = str3.equals(Deobfuscator$BDNETVPN$app.getString(-87225822705547L)) ? -2 : str3.equals(Deobfuscator$BDNETVPN$app.getString(-87273067345803L)) ? 2 : 0;
        ongoing.setSmallIcon(R.drawable.ic_app_icon);
        if (SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-87341786822539L))) {
            ongoing.setContentText(Deobfuscator$BDNETVPN$app.getString(-87384736495499L) + this.f.g());
        } else {
            ongoing.setContentText(str);
        }
        ongoing.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VPNClient.class), 201326592));
        if (i3 != 0) {
            try {
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-87449161004939L), Integer.TYPE).invoke(ongoing, Integer.valueOf(i3));
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-87500700612491L), Boolean.TYPE).invoke(ongoing, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                SkStatus.logException(e);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            ongoing.setChannelId(str3);
        }
        if (str2 != null && !str2.equals(Deobfuscator$BDNETVPN$app.getString(-87444866037643L))) {
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
        String str4 = this.y;
        if (str4 != null && !str3.equals(str4)) {
            notificationManager.cancel(this.y.hashCode());
        }
        this.y = str3;
    }

    public final void h() {
        Inet4Address inet4Address;
        if (!this.f.o() || this.f.r()) {
            return;
        }
        try {
            this.x = new File(getApplicationInfo().nativeLibraryDir, Deobfuscator$BDNETVPN$app.getString(-85598030100363L));
            File file = new File(this.x.getCanonicalPath());
            String b = this.f.b();
            C0223If c0223If = this.f;
            c0223If.getClass();
            if (c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-163006225676171L), Deobfuscator$BDNETVPN$app.getString(-163074945152907L)).equals(Deobfuscator$BDNETVPN$app.getString(-85735469053835L))) {
                try {
                    InetAddress[] allByName = InetAddress.getAllByName(this.f.b());
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
                    b = inet4Address.getHostAddress();
                    this.g = b;
                } catch (UnknownHostException unused) {
                    F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-85756943890315L));
                    VPNClient vPNClient = G;
                    if (vPNClient != null) {
                        vPNClient.stopSocksOpenVPN();
                    } else {
                        F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-85834253301643L));
                    }
                    TunnelManagerHelper.stopSocksHttp(getApplicationContext());
                }
            } else {
                b = this.f.b();
                this.g = b;
            }
            this.w = new ProcessBuilder(new String[0]).command(file.getAbsolutePath(), Deobfuscator$BDNETVPN$app.getString(-85963102320523L), PUtils.pEncrypt(getApplicationContext(), b + Deobfuscator$BDNETVPN$app.getString(-85997462058891L)), Deobfuscator$BDNETVPN$app.getString(-86014641928075L), getString(R.string.app)).redirectErrorStream(true).start();
            RT rt = new RT(0);
            C3462kl c3462kl = new C3462kl(this.w.getInputStream(), rt);
            C3462kl c3462kl2 = new C3462kl(this.w.getErrorStream(), rt);
            c3462kl.start();
            c3462kl2.start();
        } catch (IOException unused2) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-86049001666443L));
        }
    }

    public final void i() {
        if (!this.f.o() || this.f.r()) {
            return;
        }
        Process process = this.w;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.x;
            if (file != null) {
                VpnUtils.killProcess(file);
            }
        } catch (Exception unused) {
        }
        this.w = null;
        this.x = null;
    }

    public final synchronized void j() {
        try {
            C = 0L;
            i();
            k();
            TunnelManagerThread tunnelManagerThread = E;
            if (tunnelManagerThread != null) {
                tunnelManagerThread.stopAll();
                e();
                Thread thread = D;
                if (thread != null) {
                    thread.interrupt();
                    SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                }
                E = null;
                F = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void k() {
        if (this.j != null) {
            G.addStatus(Deobfuscator$BDNETVPN$app.getString(-86250865129355L));
            this.j.destroy();
        }
        try {
            File file = this.k;
            if (file != null) {
                AbstractC3877q10.x(file);
            }
        } catch (Exception unused) {
        }
        File file2 = this.v;
        if (file2 != null && file2.exists()) {
            this.v.delete();
        }
        this.j = null;
        this.k = null;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.d;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Log.i(B, Deobfuscator$BDNETVPN$app.getString(-86306699704203L));
        super.onCreate();
        this.b = new Handler();
        this.c = (ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-86345354409867L));
        if (this.a == null) {
            this.a = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-86401188984715L));
        }
        this.f = C0223If.d(this);
        S50.c(getApplicationContext());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.i(B, Deobfuscator$BDNETVPN$app.getString(-86955239765899L));
        super.onDestroy();
        j();
        RunnableC0129Ep runnableC0129Ep = this.e;
        if (runnableC0129Ep != null) {
            runnableC0129Ep.b = true;
        }
        try {
            unregisterReceiver(this.A);
        } catch (IllegalArgumentException unused) {
        }
        try {
            this.c.unregisterNetworkCallback(this.z);
        } catch (IllegalArgumentException unused2) {
        }
        SkStatus.removeStateListener(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.i(B, Deobfuscator$BDNETVPN$app.getString(-86457023559563L));
        this.c.registerDefaultNetworkCallback(this.z);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(J);
        intentFilter.addAction(I);
        AbstractC3131gc0.H(this, this.A, intentFilter);
        SkStatus.addStateListener(this);
        RunnableC0129Ep runnableC0129Ep = new RunnableC0129Ep(2);
        runnableC0129Ep.b = false;
        this.e = runnableC0129Ep;
        new Thread(this.e, Deobfuscator$BDNETVPN$app.getString(-86521448069003L)).start();
        if (intent != null && Deobfuscator$BDNETVPN$app.getString(-86581577611147L).equals(intent.getAction())) {
            return 2;
        }
        String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        g(string, string, Deobfuscator$BDNETVPN$app.getString(-86736196433803L), ConnectionStatus.LEVEL_START);
        new Thread(new S7(this, 20)).start();
        return 2;
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        if (D == null) {
            return;
        }
        String string = Deobfuscator$BDNETVPN$app.getString(-87925902374795L);
        if (connectionStatus == ConnectionStatus.LEVEL_CONNECTED) {
            string = Deobfuscator$BDNETVPN$app.getString(-87994621851531L);
        }
        String string2 = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        g(string2, string2, string, connectionStatus);
    }
}
