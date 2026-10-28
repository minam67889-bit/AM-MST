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
import defpackage.L50;
import defpackage.RunnableC0129Ep;
import defpackage.RunnableC3954r1;
import defpackage.S50;
import defpackage.S7;
import defpackage.TO;
import defpackage.WT;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
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
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes2.dex */
public class XRayDNSService extends Service implements SkStatus.StateListener {
    public static long A;
    public static Thread B;
    public static TunnelManagerThread C;
    public static boolean D;
    public static VPNClient E;
    public static VPNClient F;
    public static final String G;
    public static final String H;
    public static final String z;
    public NotificationManager a;
    public Handler b;
    public ConnectivityManager c;
    public RunnableC0129Ep e;
    public C0223If f;
    public Process h;
    public File i;
    public String j;
    public String k;
    public String l;
    public String m;
    public File n;
    public Process r;
    public File s;
    public String w;
    public final BinderC0877cM d = new BinderC0877cM(this, 2);
    public final String g = Deobfuscator$BDNETVPN$app.getString(-98388442707851L);
    public boolean o = false;
    public boolean p = false;
    public final String q = Deobfuscator$BDNETVPN$app.getString(-98422802446219L);
    public boolean t = false;
    public boolean u = false;
    public boolean v = false;
    public final C0025Ap x = new C0025Ap(3);
    public final C2930e5 y = new C2930e5(this, 5);

    static {
        Deobfuscator$BDNETVPN$app.getString(-155971069245323L);
        Deobfuscator$BDNETVPN$app.getString(-156125688067979L);
        Deobfuscator$BDNETVPN$app.getString(-156172932708235L);
        Deobfuscator$BDNETVPN$app.getString(-156241652184971L);
        z = "XRayDNSService";
        A = 0L;
        D = false;
        G = XRayDNSService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-156310371661707L);
        H = XRayDNSService.class.getName() + Deobfuscator$BDNETVPN$app.getString(-156422040811403L);
    }

    public static PendingIntent b(Context context) {
        return PendingIntent.getActivity(context, 0, new Intent(context, (Class<?>) VPNClient.class), 67108864);
    }

    public static Inet4Address c(InetAddress[] inetAddressArr) {
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress instanceof Inet4Address) {
                return (Inet4Address) inetAddress;
            }
        }
        return null;
    }

    public static String d() {
        long time = new Date().getTime();
        long j = A;
        long j2 = time - j;
        if (j == 0) {
            return Deobfuscator$BDNETVPN$app.getString(-101038437529483L);
        }
        return String.format(Locale.US, Deobfuscator$BDNETVPN$app.getString(-100974013020043L), Long.valueOf((j2 / 3600000) % 24), Long.valueOf((j2 / 60000) % 60), Long.valueOf((j2 / 1000) % 60));
    }

    public static boolean g(File file, String str) {
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
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-100428552173451L));
        NotificationChannel notificationChannel = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-100484386748299L), getString(R.string.channel_name_background), 1);
        notificationChannel.setDescription(getString(R.string.channel_description_background));
        notificationChannel.enableLights(false);
        notificationChannel.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-100531631388555L), getString(R.string.channel_name_status), 2);
        notificationChannel2.setDescription(getString(R.string.channel_description_status));
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel2);
        NotificationChannel notificationChannel3 = new NotificationChannel(Deobfuscator$BDNETVPN$app.getString(-100600350865291L), getString(R.string.channel_name_userreq), 1);
        notificationChannel3.setDescription(getString(R.string.channel_description_userreq));
        notificationChannel3.setLightColor(R.color.primary_color);
        notificationManager.createNotificationChannel(notificationChannel3);
    }

    public final void e() {
        String[] strArr;
        String format;
        int valueOf;
        int valueOf2;
        String[] split;
        String str;
        try {
            try {
                this.i = new File(getApplicationInfo().nativeLibraryDir, this.g + Deobfuscator$BDNETVPN$app.getString(-101077092235147L));
                String l = this.f.l();
                if (l.contains(Deobfuscator$BDNETVPN$app.getString(-101236006025099L))) {
                    if (l.contains(Deobfuscator$BDNETVPN$app.getString(-101244595959691L))) {
                        String[] split2 = l.split(Deobfuscator$BDNETVPN$app.getString(-101253185894283L));
                        split = split2[new Random().nextInt(split2.length)].split(Deobfuscator$BDNETVPN$app.getString(-101261775828875L));
                        str = split[0];
                    } else {
                        split = l.split(Deobfuscator$BDNETVPN$app.getString(-101270365763467L));
                        str = split[0];
                    }
                    String str2 = str;
                    strArr = split;
                    l = str2;
                    this.p = true;
                } else {
                    strArr = null;
                }
                if (l.contains(Deobfuscator$BDNETVPN$app.getString(-101278955698059L))) {
                    String[] split3 = l.split(Deobfuscator$BDNETVPN$app.getString(-101287545632651L));
                    l = split3[new Random().nextInt(split3.length)];
                    if (l.contains(Deobfuscator$BDNETVPN$app.getString(-101296135567243L))) {
                        String replaceAll = l.replaceAll(Deobfuscator$BDNETVPN$app.getString(-101304725501835L), Deobfuscator$BDNETVPN$app.getString(-101339085240203L));
                        l = F00.f(Integer.valueOf(replaceAll.split(Deobfuscator$BDNETVPN$app.getString(-101343380207499L))[0]).intValue(), Integer.valueOf(replaceAll.split(Deobfuscator$BDNETVPN$app.getString(-101351970142091L))[1]).intValue()) + F00.e(l);
                    }
                } else if (l.contains(Deobfuscator$BDNETVPN$app.getString(-101360560076683L))) {
                    String replaceAll2 = l.replaceAll(Deobfuscator$BDNETVPN$app.getString(-101369150011275L), Deobfuscator$BDNETVPN$app.getString(-101403509749643L));
                    l = F00.f(Integer.valueOf(replaceAll2.split(Deobfuscator$BDNETVPN$app.getString(-101407804716939L))[0]).intValue(), Integer.valueOf(replaceAll2.split(Deobfuscator$BDNETVPN$app.getString(-101416394651531L))[1]).intValue()) + F00.e(this.f.l());
                }
                String str3 = l;
                if (this.f.n() == 8) {
                    this.m = this.f.l();
                } else if (this.f.n() == 11) {
                    this.m = this.f.l();
                } else if (this.f.r()) {
                    this.m = this.f.b();
                } else {
                    this.m = this.f.m();
                }
                if (this.m.contains(Deobfuscator$BDNETVPN$app.getString(-101424984586123L))) {
                    String[] split4 = this.m.split(Deobfuscator$BDNETVPN$app.getString(-101433574520715L));
                    String str4 = split4[new Random().nextInt(split4.length)];
                    if (str4.contains(Deobfuscator$BDNETVPN$app.getString(-101442164455307L))) {
                        String replaceAll3 = str4.replaceAll(Deobfuscator$BDNETVPN$app.getString(-101450754389899L), Deobfuscator$BDNETVPN$app.getString(-101485114128267L));
                        str4 = F00.f(Integer.valueOf(replaceAll3.split(Deobfuscator$BDNETVPN$app.getString(-101489409095563L))[0]).intValue(), Integer.valueOf(replaceAll3.split(Deobfuscator$BDNETVPN$app.getString(-101497999030155L))[1]).intValue()) + F00.e(str4);
                    }
                    this.m = str4;
                } else if (this.m.contains(Deobfuscator$BDNETVPN$app.getString(-101506588964747L))) {
                    String replaceAll4 = this.m.replaceAll(Deobfuscator$BDNETVPN$app.getString(-101515178899339L), Deobfuscator$BDNETVPN$app.getString(-101549538637707L));
                    if (this.f.n() == 8) {
                        this.m = F00.f(Integer.valueOf(replaceAll4.split(Deobfuscator$BDNETVPN$app.getString(-101553833605003L))[0]).intValue(), Integer.valueOf(replaceAll4.split(Deobfuscator$BDNETVPN$app.getString(-101562423539595L))[1]).intValue()) + F00.e(this.f.l());
                    } else {
                        this.m = F00.f(Integer.valueOf(replaceAll4.split(Deobfuscator$BDNETVPN$app.getString(-101571013474187L))[0]).intValue(), Integer.valueOf(replaceAll4.split(Deobfuscator$BDNETVPN$app.getString(-101579603408779L))[1]).intValue()) + F00.e(this.f.m());
                    }
                }
                InetAddress[] inetAddressArr = new InetAddress[0];
                try {
                    inetAddressArr = InetAddress.getAllByName(this.m);
                } catch (UnknownHostException unused) {
                    F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-101588193343371L));
                    VPNClient vPNClient = E;
                    if (vPNClient != null) {
                        vPNClient.stopSocksOpenVPN();
                    } else {
                        F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-101665502754699L));
                    }
                    TunnelManagerHelper.stopXRay(getApplicationContext());
                }
                try {
                    this.m = c(inetAddressArr).getHostAddress();
                } catch (Exception unused2) {
                }
                this.f.I(this.m);
                this.j = this.m;
                this.k = Deobfuscator$BDNETVPN$app.getString(-101794351773579L);
                this.l = Deobfuscator$BDNETVPN$app.getString(-101820121577355L);
                if (this.f.n() == 8) {
                    C0223If c0223If = this.f;
                    c0223If.getClass();
                    if (c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-158517984851851L), Deobfuscator$BDNETVPN$app.getString(-158556639557515L)).isEmpty()) {
                        valueOf2 = 443;
                    } else {
                        C0223If c0223If2 = this.f;
                        c0223If2.getClass();
                        valueOf2 = Integer.valueOf(Integer.parseInt(c0223If2.a.getString(Deobfuscator$BDNETVPN$app.getString(-158350481127307L), Deobfuscator$BDNETVPN$app.getString(-158389135832971L))));
                    }
                    format = String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-101845891381131L), this.k, this.l, this.j, valueOf2, this.f.m());
                } else if (this.f.n() == 11) {
                    C0223If c0223If3 = this.f;
                    c0223If3.getClass();
                    if (c0223If3.a.getString(Deobfuscator$BDNETVPN$app.getString(-158517984851851L), Deobfuscator$BDNETVPN$app.getString(-158556639557515L)).isEmpty()) {
                        valueOf = 853;
                    } else {
                        C0223If c0223If4 = this.f;
                        c0223If4.getClass();
                        valueOf = Integer.valueOf(Integer.parseInt(c0223If4.a.getString(Deobfuscator$BDNETVPN$app.getString(-158350481127307L), Deobfuscator$BDNETVPN$app.getString(-158389135832971L))));
                    }
                    format = String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-106862413182859L), this.k, this.l, this.m, Deobfuscator$BDNETVPN$app.getString(-111432258385803L), Deobfuscator$BDNETVPN$app.getString(-111483797993355L), valueOf);
                } else if (this.f.r()) {
                    format = String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-111513862764427L), this.k, this.l);
                } else if (this.p) {
                    C0223If c0223If5 = this.f;
                    c0223If5.getClass();
                    format = c0223If5.a.getString(Deobfuscator$BDNETVPN$app.getString(-160802907453323L), Deobfuscator$BDNETVPN$app.getString(-160858742028171L)).equals(Deobfuscator$BDNETVPN$app.getString(-135423945701259L)) ? this.f.j().equals(Deobfuscator$BDNETVPN$app.getString(-135445420537739L)) ? String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-135475485308811L), this.k, this.l, this.m, strArr[1], this.f.m(), str3, strArr[2]) : String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-140414697699211L), this.k, this.l, this.m, strArr[1], this.f.m(), this.f.j(), strArr[2]) : this.f.j().equals(Deobfuscator$BDNETVPN$app.getString(-145353910089611L)) ? String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-145383974860683L), this.k, this.l, this.m, strArr[1], str3, str3, strArr[2]) : String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-150323187251083L), this.k, this.l, this.m, strArr[1], this.f.j(), this.f.j(), strArr[2]);
                } else {
                    C0223If c0223If6 = this.f;
                    c0223If6.getClass();
                    format = c0223If6.a.getString(Deobfuscator$BDNETVPN$app.getString(-160802907453323L), Deobfuscator$BDNETVPN$app.getString(-160858742028171L)).equals(Deobfuscator$BDNETVPN$app.getString(-114898296993675L)) ? this.f.j().equals(Deobfuscator$BDNETVPN$app.getString(-114919771830155L)) ? String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-114949836601227L), this.k, this.l, this.m, this.f.m(), str3) : String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-120060847683467L), this.k, this.l, this.m, this.f.m(), this.f.j()) : this.f.j().equals(Deobfuscator$BDNETVPN$app.getString(-125171858765707L)) ? String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-125201923536779L), this.k, this.l, this.m, str3, str3) : String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-130312934619019L), this.k, this.l, this.m, this.f.j(), this.f.j());
                }
                File file = new File(getFilesDir().getPath(), Deobfuscator$BDNETVPN$app.getString(-155262399641483L));
                this.n = file;
                if (g(file, format)) {
                    this.h = new ProcessBuilder(new String[0]).command(new File(this.i.getCanonicalPath()).getAbsolutePath(), Deobfuscator$BDNETVPN$app.getString(-155305349314443L), Deobfuscator$BDNETVPN$app.getString(-155322529183627L), this.n.getAbsolutePath()).redirectErrorStream(true).start();
                    SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-155335414085515L), getString(R.string.state_connecting));
                    SkStatus.logInfo(R.string.state_connecting, new Object[0]);
                    E.addStatus(Deobfuscator$BDNETVPN$app.getString(-155382658725771L));
                    WT wt = new WT((Object) this);
                    C3462kl c3462kl = new C3462kl(this.h.getInputStream(), wt);
                    C3462kl c3462kl2 = new C3462kl(this.h.getErrorStream(), wt);
                    c3462kl.start();
                    c3462kl2.start();
                }
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused3) {
                j();
                l();
                VPNClient vPNClient2 = E;
                if (vPNClient2 != null) {
                    vPNClient2.stopSocksOpenVPN();
                } else {
                    F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-155713371207563L));
                }
                TunnelManagerHelper.stopXRay(getApplicationContext());
                F00.g(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-155842220226443L));
            }
        } catch (IOException unused4) {
        } catch (NullPointerException unused5) {
            j();
            l();
            VPNClient vPNClient3 = E;
            if (vPNClient3 != null) {
                vPNClient3.stopSocksOpenVPN();
            } else {
                F00.h(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-155490032908171L));
            }
            TunnelManagerHelper.stopXRay(getApplicationContext());
            F00.g(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-155618881927051L));
        }
    }

    public final void f() {
        String message;
        try {
            NetworkInfo activeNetworkInfo = this.c.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                message = Deobfuscator$BDNETVPN$app.getString(-100806509295499L);
            } else {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                if (subtypeName == null) {
                    subtypeName = Deobfuscator$BDNETVPN$app.getString(-100866638837643L);
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo == null) {
                    extraInfo = Deobfuscator$BDNETVPN$app.getString(-100870933804939L);
                }
                message = String.format(Deobfuscator$BDNETVPN$app.getString(-100875228772235L), activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState(), extraInfo, subtypeName);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        SkStatus.logInfo(message);
    }

    public final void h(String str, String str2, String str3, ConnectionStatus connectionStatus) {
        int i = L50.a[connectionStatus.ordinal()];
        NotificationManager notificationManager = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-99741357406091L));
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            a();
            new Notification.Builder(this, Deobfuscator$BDNETVPN$app.getString(-99797191980939L));
        } else if (i2 >= 28) {
            a();
            new Notification.Builder(this, Deobfuscator$BDNETVPN$app.getString(-99865911457675L));
        } else {
            new Notification.Builder(this);
        }
        Notification.Builder ongoing = new Notification.Builder(this).setContentTitle(getString(R.string.app)).setOnlyAlertOnce(true).setOngoing(true);
        ongoing.setCategory(Deobfuscator$BDNETVPN$app.getString(-99934630934411L));
        ongoing.setLocalOnly(true);
        int i3 = str3.equals(Deobfuscator$BDNETVPN$app.getString(-99968990672779L)) ? -2 : str3.equals(Deobfuscator$BDNETVPN$app.getString(-100016235313035L)) ? 2 : 0;
        ongoing.setSmallIcon(R.drawable.ic_app_icon);
        if (SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-100084954789771L))) {
            ongoing.setContentText(Deobfuscator$BDNETVPN$app.getString(-100127904462731L) + this.f.g());
        } else {
            ongoing.setContentText(str);
        }
        ongoing.setContentIntent(PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) VPNClient.class), 201326592));
        if (i3 != 0) {
            try {
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-100192328972171L), Integer.TYPE).invoke(ongoing, Integer.valueOf(i3));
                ongoing.getClass().getMethod(Deobfuscator$BDNETVPN$app.getString(-100243868579723L), Boolean.TYPE).invoke(ongoing, Boolean.TRUE);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                SkStatus.logException(e);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 26) {
            ongoing.setChannelId(str3);
        }
        if (str2 != null && !str2.equals(Deobfuscator$BDNETVPN$app.getString(-100188034004875L))) {
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

    public final void i() {
        if (!this.f.r()) {
            new Thread(new RunnableC3954r1(this, 23)).start();
            return;
        }
        try {
            this.s = new File(getApplicationInfo().nativeLibraryDir, this.q + Deobfuscator$BDNETVPN$app.getString(-98465752119179L));
            Deobfuscator$BDNETVPN$app.getString(-98551651465099L);
            String str = Deobfuscator$BDNETVPN$app.getString(-98581716236171L) + this.f.l();
            String b = this.f.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.s.getCanonicalPath());
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-98598896105355L));
            arrayList.add(b + Deobfuscator$BDNETVPN$app.getString(-98620370941835L));
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-98637550811019L));
            arrayList.add(getString(R.string.app));
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-98671910549387L));
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-98706270287755L));
            arrayList.add(str);
            arrayList.add(Deobfuscator$BDNETVPN$app.getString(-98736335058827L));
            ProcessBuilder processBuilder = new ProcessBuilder(arrayList);
            processBuilder.redirectErrorStream(true);
            this.r = processBuilder.start();
            TO to = new TO(this, 9);
            C3462kl c3462kl = new C3462kl(this.r.getInputStream(), to);
            C3462kl c3462kl2 = new C3462kl(this.r.getErrorStream(), to);
            c3462kl.start();
            c3462kl2.start();
        } catch (IOException unused) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-98800759568267L));
        }
    }

    public final void j() {
        if (this.f.r()) {
            Process process = this.r;
            if (process != null) {
                process.destroy();
            }
            try {
                File file = this.s;
                if (file != null) {
                    VpnUtils.killProcess(file);
                }
            } catch (Exception unused) {
            }
            this.r = null;
            this.s = null;
        }
    }

    public final synchronized void k() {
        try {
            this.t = false;
            A = 0L;
            j();
            l();
            TunnelManagerThread tunnelManagerThread = C;
            if (tunnelManagerThread != null) {
                tunnelManagerThread.stopAll();
                f();
                Thread thread = B;
                if (thread != null) {
                    thread.interrupt();
                    SkStatus.logInfo(R.string.tunnel_stop, new Object[0]);
                }
                C = null;
                D = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void l() {
        if (this.h != null) {
            E.addStatus(Deobfuscator$BDNETVPN$app.getString(-98994033096587L));
            this.h.destroy();
        }
        try {
            File file = this.i;
            if (file != null) {
                AbstractC3877q10.x(file);
            }
        } catch (Exception unused) {
        }
        File file2 = this.n;
        if (file2 != null && file2.exists()) {
            this.n.delete();
        }
        this.h = null;
        this.i = null;
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.d;
    }

    @Override // android.app.Service
    public final void onCreate() {
        Log.i(z, Deobfuscator$BDNETVPN$app.getString(-99049867671435L));
        super.onCreate();
        this.b = new Handler();
        this.c = (ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-99088522377099L));
        if (this.a == null) {
            this.a = (NotificationManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-99144356951947L));
        }
        this.f = C0223If.d(this);
        S50.c(getApplicationContext());
    }

    @Override // android.app.Service
    public final void onDestroy() {
        Log.i(z, Deobfuscator$BDNETVPN$app.getString(-99698407733131L));
        super.onDestroy();
        k();
        RunnableC0129Ep runnableC0129Ep = this.e;
        if (runnableC0129Ep != null) {
            runnableC0129Ep.b = true;
        }
        try {
            unregisterReceiver(this.y);
        } catch (IllegalArgumentException unused) {
        }
        try {
            this.c.unregisterNetworkCallback(this.x);
        } catch (IllegalArgumentException unused2) {
        }
        SkStatus.removeStateListener(this);
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        Log.i(z, Deobfuscator$BDNETVPN$app.getString(-99200191526795L));
        this.c.registerDefaultNetworkCallback(this.x);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(H);
        intentFilter.addAction(G);
        AbstractC3131gc0.H(this, this.y, intentFilter);
        SkStatus.addStateListener(this);
        RunnableC0129Ep runnableC0129Ep = new RunnableC0129Ep(3);
        runnableC0129Ep.b = false;
        this.e = runnableC0129Ep;
        new Thread(this.e, Deobfuscator$BDNETVPN$app.getString(-99264616036235L)).start();
        if (intent != null && Deobfuscator$BDNETVPN$app.getString(-99324745578379L).equals(intent.getAction())) {
            return 2;
        }
        String string = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        h(string, string, Deobfuscator$BDNETVPN$app.getString(-99479364401035L), ConnectionStatus.LEVEL_START);
        new Thread(new S7(this, 27)).start();
        return 2;
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        if (B == null) {
            return;
        }
        String string = Deobfuscator$BDNETVPN$app.getString(-100669070342027L);
        if (connectionStatus == ConnectionStatus.LEVEL_CONNECTED) {
            string = Deobfuscator$BDNETVPN$app.getString(-100737789818763L);
        }
        String string2 = getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
        h(string2, string2, string, connectionStatus);
    }
}
