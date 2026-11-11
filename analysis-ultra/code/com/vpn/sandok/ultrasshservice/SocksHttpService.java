package com.vpn.sandok.ultrasshservice;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.SystemClock;
import android.os.Vibrator;
import androidx.preference.PreferenceManager;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.v2ray.ang.Hometab;
import com.vpn.sandok.ultrasshservice.config.Settings;
import com.vpn.sandok.ultrasshservice.config.SettingsConstants;
import com.vpn.sandok.ultrasshservice.logger.ConnectionStatus;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.tunnel.DNSTunnelThread;
import com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP;
import com.vpn.sandok.ultrasshservice.tunnel.TunnelManagerThread;
import com.vpn.sandok.ultrasshservice.tunnel.TunnelUtils;
import defpackage.n5;
import defpackage.wl0;
import defpackage.zq0;
import java.lang.reflect.InvocationTargetException;
import kotlin.Lazy;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public class SocksHttpService extends Service implements SkStatus.StateListener {
    public static final String ACTION_STOP = "SocksHttpService.STOP";
    public static final String NOTIFICATION_CHANNEL_BG_ID = "openvpn_bg";
    public static final String NOTIFICATION_CHANNEL_NEWSTATUS_ID = "openvpn_newstat";
    public static final String NOTIFICATION_CHANNEL_USERREQ_ID = "openvpn";
    private static final long NOTIFICATION_UPDATE_INTERVAL = 1000;
    private static final int PRIORITY_DEFAULT = 0;
    private static final int PRIORITY_MAX = 2;
    private static final int PRIORITY_MIN = -2;
    public static final String START_SERVICE = "com.vpn.sandok:startTunnel";
    private static final String TAG = "SocksHttpService";
    public static final String TUNNEL_SSH_RESTART_SERVICE = SocksHttpService.class.getName().concat("::restartservicebroadcast");
    public static final String TUNNEL_SSH_STOP_SERVICE = SocksHttpService.class.getName().concat("::stopservicebroadcast");
    public static boolean isRunning = false;
    private static String lastStateMsg;
    private static SharedPreferences sp;
    private static Thread udpThread;
    private ConnectivityManager connMgr;
    private String lastChannel;
    private Settings mConfig;
    private DNSTunnelThread mDnsThread;
    private Handler mHandler;
    private NotificationManager mNotificationManager;
    private Handler mNotificationUpdateHandler;
    private Runnable mNotificationUpdateRunnable;
    private Settings mPrefs;
    private TunnelManagerThread mTunnelManager;
    private Thread mTunnelThread;
    private Notification.Builder mNotifyBuilder = null;
    private ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.5
        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(Network network) {
            SkStatus.logDebug("Network available");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(Network network) {
            SkStatus.logDebug("Lost network");
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onUnavailable() {
            SkStatus.logDebug("Network unavailable");
        }
    };
    private BroadcastReceiver mTunnelSSHBroadcastReceiver = new BroadcastReceiver() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.6
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals(SocksHttpService.TUNNEL_SSH_RESTART_SERVICE)) {
                    new Thread(new Runnable() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.6.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SocksHttpService.this.mTunnelManager;
                        }
                    }).start();
                } else if (action.equals(SocksHttpService.TUNNEL_SSH_STOP_SERVICE)) {
                    SocksHttpService.this.endTunnelService();
                }
            }
        }
    };

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    /* renamed from: com.vpn.sandok.ultrasshservice.SocksHttpService$7, reason: invalid class name */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus;

        static {
            int[] iArr = new int[ConnectionStatus.values().length];
            $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus = iArr;
            try {
                iArr[ConnectionStatus.LEVEL_CONNECTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[ConnectionStatus.LEVEL_AUTH_FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[ConnectionStatus.LEVEL_NONETWORK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[ConnectionStatus.LEVEL_NOTCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[ConnectionStatus.LEVEL_CONNECTING_NO_SERVER_REPLY_YET.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[ConnectionStatus.LEVEL_CONNECTING_SERVER_REPLIED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[ConnectionStatus.UNKNOWN_LEVEL.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    private void addVpnActionsToNotification(Notification.Builder builder) {
        int i;
        if (Build.VERSION.SDK_INT >= 31) {
            i = 335544320;
        } else {
            i = 268435456;
        }
        Intent intent = new Intent(this, (Class<?>) MainReceiver.class);
        intent.setAction(MainReceiver.ACTION_SERVICE_RESTART);
        builder.addAction(R.drawable.ic_restore_24dp, getString(R.string.reconnect), PendingIntent.getBroadcast(this, 0, intent, i));
        Intent intent2 = new Intent(this, (Class<?>) MainReceiver.class);
        intent2.setAction(MainReceiver.ACTION_SERVICE_STOP);
        builder.addAction(R.drawable.pause, getString(R.string.notification_action_stop_v2ray), PendingIntent.getBroadcast(this, 0, intent2, i));
    }

    private void connectedVibrate() {
        if (getSharedPreferences(PreferenceManager.a(this), 0).getBoolean(SettingsConstants.VIBRATE, true)) {
            ((Vibrator) getSystemService("vibrator")).vibrate(150L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ConnectionStatus getConnectionStatusFromState(String str) {
        if (str != null && str.contains("connected")) {
            return ConnectionStatus.LEVEL_CONNECTED;
        }
        return ConnectionStatus.LEVEL_NOTCONNECTED;
    }

    public static PendingIntent getGraphPendingIntent(Context context) {
        int i;
        if (Build.VERSION.SDK_INT >= 31) {
            i = 67108864;
        } else {
            i = 0;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context, (Class<?>) Hometab.class));
        intent.addFlags(131072);
        return PendingIntent.getActivity(context, 0, intent, i);
    }

    private int getIconByConnectionStatus(ConnectionStatus connectionStatus) {
        switch (AnonymousClass7.$SwitchMap$com$vpn$sandok$ultrasshservice$logger$ConnectionStatus[connectionStatus.ordinal()]) {
            case 1:
                connectedVibrate();
                return R.drawable.ic_stat_name;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return R.drawable.ic_shield_reconnect;
            default:
                return R.drawable.ic_shield_disconnected;
        }
    }

    public static SharedPreferences getSharedPrefs() {
        return sp;
    }

    private void jbNotificationExtras(int i, Notification.Builder builder) {
        if (i != 0) {
            try {
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException e) {
                e = e;
            }
            try {
                builder.getClass().getMethod("setPriority", Integer.TYPE).invoke(builder, Integer.valueOf(i));
                builder.getClass().getMethod("setUsesChronometer", Boolean.TYPE).invoke(builder, Boolean.TRUE);
            } catch (IllegalAccessException e2) {
                e = e2;
                SkStatus.logException(e);
            } catch (IllegalArgumentException e3) {
                e = e3;
                SkStatus.logException(e);
            } catch (InvocationTargetException e4) {
                e = e4;
                SkStatus.logException(e);
            }
        }
    }

    private void lpNotificationExtras(Notification.Builder builder, String str) {
        builder.setCategory(str);
        builder.setLocalOnly(true);
    }

    private void showNotification(String str, String str2, long j, ConnectionStatus connectionStatus, Intent intent) {
        int iconByConnectionStatus = getIconByConnectionStatus(connectionStatus);
        if (this.mNotifyBuilder == null) {
            Notification.Builder builder = new Notification.Builder(this);
            StringBuilder sb = new StringBuilder();
            Lazy lazy = zq0.a;
            sb.append(zq0.D());
            sb.append(" | ");
            sb.append(zq0.C());
            Notification.Builder ongoing = builder.setContentTitle(sb.toString()).setOnlyAlertOnce(true).setOngoing(true);
            this.mNotifyBuilder = ongoing;
            addVpnActionsToNotification(ongoing);
            lpNotificationExtras(this.mNotifyBuilder, "service");
        }
        int i = Build.VERSION.SDK_INT;
        int i2 = 2;
        if (i >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            n5.f();
            NotificationChannel notificationChannel = new NotificationChannel(str2, getString(R.string.app), 2);
            notificationChannel.setDescription("Channel for foreground service");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (str2.equals(NOTIFICATION_CHANNEL_BG_ID)) {
            i2 = -2;
        } else if (!str2.equals(NOTIFICATION_CHANNEL_USERREQ_ID)) {
            i2 = 0;
        }
        this.mNotifyBuilder.setSmallIcon(iconByConnectionStatus);
        this.mNotifyBuilder.setContentText(str);
        this.mNotifyBuilder.setContentIntent(getGraphPendingIntent(this));
        if (j != 0) {
            this.mNotifyBuilder.setWhen(j);
        }
        jbNotificationExtras(i2, this.mNotifyBuilder);
        if (i >= 26) {
            this.mNotifyBuilder.setChannelId(str2);
        }
        if (str != null && !str.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            this.mNotifyBuilder.setTicker(str);
        }
        Notification build = this.mNotifyBuilder.build();
        int hashCode = str2.hashCode();
        startForeground(hashCode, build);
        this.mNotificationManager.notify(hashCode, build);
        String str3 = this.lastChannel;
        if (str3 != null && !str2.equals(str3)) {
            this.mNotificationManager.cancel(this.lastChannel.hashCode());
        }
        this.lastChannel = str2;
    }

    private void startNotificationUpdateLoop() {
        Runnable runnable = new Runnable() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                if (SocksHttpService.this.mTunnelThread != null || SocksHttpService.udpThread != null) {
                    String string = SocksHttpService.this.getString(SkStatus.getLocalizedState(SkStatus.getLastState()));
                    ConnectionStatus connectionStatusFromState = SocksHttpService.this.getConnectionStatusFromState(SkStatus.getLastState());
                    if (connectionStatusFromState.equals(ConnectionStatus.LEVEL_CONNECTED)) {
                        str = SocksHttpService.NOTIFICATION_CHANNEL_USERREQ_ID;
                    } else {
                        str = SocksHttpService.NOTIFICATION_CHANNEL_BG_ID;
                    }
                    SocksHttpService.this.updateNotificationQuiet(string, str, connectionStatusFromState);
                }
                SocksHttpService.this.mNotificationUpdateHandler.postDelayed(SocksHttpService.this.mNotificationUpdateRunnable, 1000L);
            }
        };
        this.mNotificationUpdateRunnable = runnable;
        this.mNotificationUpdateHandler.post(runnable);
    }

    private void startTunnelBroadcast() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.connMgr.registerDefaultNetworkCallback(this.networkCallback);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TUNNEL_SSH_STOP_SERVICE);
        intentFilter.addAction(TUNNEL_SSH_RESTART_SERVICE);
        wl0.a(this).b(this.mTunnelSSHBroadcastReceiver, intentFilter);
    }

    private void stopNotificationUpdateLoop() {
        Runnable runnable = this.mNotificationUpdateRunnable;
        if (runnable != null) {
            this.mNotificationUpdateHandler.removeCallbacks(runnable);
        }
    }

    private void stopTunnelBroadcast() {
        wl0.a(this).d(this.mTunnelSSHBroadcastReceiver);
        if (Build.VERSION.SDK_INT >= 24) {
            this.connMgr.unregisterNetworkCallback(this.networkCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateNotificationQuiet(String str, String str2, ConnectionStatus connectionStatus) {
        int iconByConnectionStatus = getIconByConnectionStatus(connectionStatus);
        if (this.mNotifyBuilder == null) {
            Notification.Builder builder = new Notification.Builder(this);
            StringBuilder sb = new StringBuilder();
            Lazy lazy = zq0.a;
            sb.append(zq0.D());
            sb.append(" | ");
            sb.append(zq0.C());
            Notification.Builder ongoing = builder.setContentTitle(sb.toString()).setOnlyAlertOnce(true).setOngoing(true);
            this.mNotifyBuilder = ongoing;
            addVpnActionsToNotification(ongoing);
            lpNotificationExtras(this.mNotifyBuilder, "service");
        }
        int i = Build.VERSION.SDK_INT;
        int i2 = 2;
        if (i >= 26) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            n5.f();
            NotificationChannel notificationChannel = new NotificationChannel(str2, getString(R.string.app), 2);
            notificationChannel.setDescription("Channel for foreground service");
            notificationManager.createNotificationChannel(notificationChannel);
        }
        if (str2.equals(NOTIFICATION_CHANNEL_BG_ID)) {
            i2 = -2;
        } else if (!str2.equals(NOTIFICATION_CHANNEL_USERREQ_ID)) {
            i2 = 0;
        }
        this.mNotifyBuilder.setSmallIcon(iconByConnectionStatus);
        this.mNotifyBuilder.setContentText(str);
        this.mNotifyBuilder.setContentIntent(getGraphPendingIntent(this));
        jbNotificationExtras(i2, this.mNotifyBuilder);
        if (i >= 26) {
            this.mNotifyBuilder.setChannelId(str2);
        }
        Notification build = this.mNotifyBuilder.build();
        int hashCode = str2.hashCode();
        startForeground(hashCode, build);
        this.mNotificationManager.notify(hashCode, build);
        String str3 = this.lastChannel;
        if (str3 != null && !str2.equals(str3)) {
            this.mNotificationManager.cancel(this.lastChannel.hashCode());
        }
        this.lastChannel = str2;
    }

    public void endTunnelService() {
        this.mHandler.post(new Runnable() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.3
            @Override // java.lang.Runnable
            public void run() {
                SocksHttpService.this.stopForeground(true);
                SocksHttpService.this.stopSelf();
                SkStatus.removeStateListener(SocksHttpService.this);
            }
        });
    }

    public String getIpPublic() {
        NetworkInfo activeNetworkInfo = this.connMgr.getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            return TunnelUtils.getLocalIpAddress();
        }
        return "Indisponivel";
    }

    public void networkStateChange(Context context, boolean z) {
        String message;
        try {
            NetworkInfo activeNetworkInfo = this.connMgr.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                message = "not connected";
            } else {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                String str = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                if (subtypeName == null) {
                    subtypeName = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                }
                String extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null) {
                    str = extraInfo;
                }
                message = String.format("%2$s %4$s to %1$s %3$s", activeNetworkInfo.getTypeName(), activeNetworkInfo.getDetailedState(), str, subtypeName);
            }
        } catch (Exception e) {
            message = e.getMessage();
        }
        if (z || !message.equals(lastStateMsg)) {
            SkStatus.logInfo(message);
        }
        lastStateMsg = message;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        sp = new Settings(this).getPrefsPrivate();
        this.mConfig = new Settings(this);
        this.mPrefs = new Settings(this);
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mNotificationUpdateHandler = new Handler(Looper.getMainLooper());
        this.connMgr = (ConnectivityManager) getSystemService("connectivity");
        this.mNotificationManager = (NotificationManager) getSystemService("notification");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        Lazy lazy = zq0.a;
        zq0.u().h(elapsedRealtime, "v2rayTime");
        isRunning = true;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopTunnel();
        stopTunnelBroadcast();
        SkStatus.removeStateListener(this);
        isRunning = false;
    }

    @Override // android.app.Service, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        SkStatus.logWarning("Low Memory Warning!");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        startTunnelBroadcast();
        SkStatus.addStateListener(this);
        if (intent != null && START_SERVICE.equals(intent.getAction())) {
            return 1;
        }
        if (intent != null && ACTION_STOP.equals(intent.getAction())) {
            endTunnelService();
            return 1;
        }
        showNotification(getString(SkStatus.getLocalizedState(SkStatus.getLastState())), NOTIFICATION_CHANNEL_NEWSTATUS_ID, 0L, ConnectionStatus.LEVEL_START, null);
        new Thread(new Runnable() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.1
            @Override // java.lang.Runnable
            public void run() {
                SocksHttpService.this.startTunnel();
            }
        }).start();
        return 1;
    }

    public synchronized void startTunnel() {
        try {
            SkStatus.updateStateString(SkStatus.SSH_INICIANDO, getString(R.string.starting_service_ssh));
            networkStateChange(this, true);
            SkStatus.logInfo("Ip Local: " + getIpPublic());
            try {
                int i = this.mPrefs.getPrefsPrivate().getInt(SettingsConstants.TUNNELTYPE_KEY, 1);
                if (i == 6) {
                    this.mPrefs.setBypass(true);
                    DNSTunnelThread dNSTunnelThread = new DNSTunnelThread(this);
                    this.mDnsThread = dNSTunnelThread;
                    dNSTunnelThread.start();
                }
                if (i == 7) {
                    HysteriaUDP hysteriaUDP = new HysteriaUDP(this);
                    udpThread = hysteriaUDP;
                    hysteriaUDP.start();
                    SkStatus.logInfo("Starting UDP");
                } else {
                    TunnelManagerThread tunnelManagerThread = new TunnelManagerThread(this.mHandler, this);
                    this.mTunnelManager = tunnelManagerThread;
                    tunnelManagerThread.setOnStopClienteListener(new TunnelManagerThread.OnStopCliente() { // from class: com.vpn.sandok.ultrasshservice.SocksHttpService.2
                        @Override // com.vpn.sandok.ultrasshservice.tunnel.TunnelManagerThread.OnStopCliente
                        public void onStop() {
                            SocksHttpService.this.endTunnelService();
                        }
                    });
                    Thread thread = new Thread(this.mTunnelManager);
                    this.mTunnelThread = thread;
                    thread.start();
                    SkStatus.logInfo("started Tunnel Thread");
                }
                startNotificationUpdateLoop();
            } catch (Exception e) {
                SkStatus.logException(e);
                endTunnelService();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void stopTunnel() {
        try {
            stopNotificationUpdateLoop();
            if (this.mPrefs.getPrefsPrivate().getInt(SettingsConstants.TUNNELTYPE_KEY, 1) == 6) {
                this.mPrefs.setBypass(false);
                DNSTunnelThread dNSTunnelThread = this.mDnsThread;
                if (dNSTunnelThread != null) {
                    dNSTunnelThread.interrupt();
                }
                this.mDnsThread = null;
            }
            TunnelManagerThread tunnelManagerThread = this.mTunnelManager;
            if (tunnelManagerThread != null) {
                tunnelManagerThread.stopAll();
                networkStateChange(this, true);
                Thread thread = this.mTunnelThread;
                if (thread != null) {
                    thread.interrupt();
                    SkStatus.logInfo("stopped Tunnel Thread");
                }
                this.mTunnelManager = null;
            }
            Thread thread2 = udpThread;
            if (thread2 != null && thread2.isAlive()) {
                udpThread.interrupt();
                SkStatus.logInfo("stopped UDP Tunnel Thread");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.vpn.sandok.ultrasshservice.logger.SkStatus.StateListener
    public void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        String str3;
        if (this.mTunnelThread == null && udpThread == null) {
            return;
        }
        if (connectionStatus.equals(ConnectionStatus.LEVEL_CONNECTED)) {
            str3 = NOTIFICATION_CHANNEL_USERREQ_ID;
        } else {
            str3 = NOTIFICATION_CHANNEL_BG_ID;
        }
        showNotification(getString(SkStatus.getLocalizedState(SkStatus.getLastState())), str3, 0L, connectionStatus, null);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
    }
}
