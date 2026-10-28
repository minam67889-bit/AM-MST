package prince.dastan.vpn.tethering;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;
import dastan.prince.bdfreevpn.R;
import defpackage.A0;
import defpackage.AbstractC3131gc0;
import defpackage.AbstractC4179tr;
import defpackage.C0798bM;
import defpackage.C3902qI;
import defpackage.RunnableC0334Mn;
import defpackage.S7;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes2.dex */
public class ProxyService extends Service {
    public static volatile ProxyService g;
    public static final String h = ProxyService.class.getName().concat("::stopservicebroadcast");
    public static boolean i;
    public final String a = "vpnshare_channel_id";
    public final String b = "vpnshare_channel_name";
    public final C0798bM c = new C0798bM(0);
    public int d = 8964;
    public Selector e;
    public ServerSocketChannel f;

    public ProxyService() {
        i = false;
    }

    public final synchronized void a() {
        if (i) {
            Log.d("ProxyService", "stop proxy server");
            i = false;
            try {
                this.e.wakeup();
                this.e.close();
                this.e = null;
            } catch (Exception e) {
                Log.e("ProxyService", "close selector exception.", e);
            }
            try {
                this.f.close();
                this.f = null;
            } catch (IOException e2) {
                Log.e("ProxyService", "close server exception.", e2);
            }
            stopForeground(true);
            stopSelf();
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        Log.d("VPNShareLogs", "onBind");
        return null;
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        g = this;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.c);
        } catch (IllegalArgumentException unused) {
        }
        if (g != null) {
            g.a();
        }
        g = null;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i2, int i3) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(h);
        AbstractC3131gc0.H(this, this.c, intentFilter);
        ProxyService proxyService = g;
        synchronized (proxyService) {
            try {
                if (!i) {
                    Log.d("ProxyService", "start proxy server");
                    try {
                        proxyService.e = Selector.open();
                        try {
                            ServerSocketChannel open = ServerSocketChannel.open();
                            proxyService.f = open;
                            open.configureBlocking(false);
                            while (true) {
                                if (proxyService.d >= 20146) {
                                    break;
                                }
                                try {
                                    proxyService.f.socket().bind(new InetSocketAddress(proxyService.d));
                                    Log.d("ProxyService", "proxy server listen port " + proxyService.d);
                                    break;
                                } catch (IOException unused) {
                                    proxyService.d++;
                                }
                            }
                            if (proxyService.d < 20146) {
                                try {
                                    proxyService.f.register(proxyService.e, 16);
                                    i = true;
                                    Thread thread = new Thread(new S7(proxyService, 16));
                                    thread.setDaemon(false);
                                    thread.setName("ProxyService");
                                    thread.start();
                                } catch (ClosedChannelException e) {
                                    Log.e("ProxyService", "register selector exception", e);
                                }
                            }
                        } catch (Exception e2) {
                            Log.e("ProxyService", "create server channel exception", e2);
                        }
                    } catch (Exception e3) {
                        Log.e("ProxyService", "create selector exception", e3);
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Intent intent2 = new Intent(this, (Class<?>) VPNClient.class);
        intent2.addFlags(131072);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent2, 335544320);
        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        int i4 = Build.VERSION.SDK_INT;
        String str = this.a;
        if (i4 >= 26) {
            A0.B();
            notificationManager.createNotificationChannel(AbstractC4179tr.f(this.b, str));
        }
        C3902qI c3902qI = new C3902qI(getApplicationContext(), str);
        c3902qI.e = C3902qI.b("VPNShare");
        c3902qI.f = C3902qI.b("Running!");
        c3902qI.g = activity;
        c3902qI.s.icon = R.drawable.ic_app_icon;
        if (i4 >= 34) {
            startForeground(1, c3902qI.a(), 1073741824);
        } else {
            startForeground(1, c3902qI.a());
        }
        new Thread(new RunnableC0334Mn(3)).start();
        return super.onStartCommand(intent, i2, i3);
    }
}
