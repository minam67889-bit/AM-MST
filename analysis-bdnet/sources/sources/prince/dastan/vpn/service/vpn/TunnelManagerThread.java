package prince.dastan.vpn.service.vpn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3131gc0;
import defpackage.C0223If;
import defpackage.F00;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class TunnelManagerThread implements Runnable {
    private static final int AUTH_TRIES = 1;
    private static final int RECONNECT_TRIES = 5;
    private static final String TAG = "TunnelManagerThread";
    private C0223If mConfig;
    private Context mContext;
    private Handler mHandler;
    private OnStopCliente mListener;
    private CountDownLatch mTunnelThreadStopSignal;
    private boolean mRunning = false;
    private boolean mStopping = false;
    private boolean mStarting = false;
    private boolean mConnected = false;
    public boolean mReconnecting = false;
    private BroadcastReceiver m_vpnTunnelBroadcastReceiver = new BroadcastReceiver() { // from class: prince.dastan.vpn.service.vpn.TunnelManagerThread.3
        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TunnelVpnService.TUNNEL_VPN_START_BROADCAST.equals(action)) {
                    if (!intent.getBooleanExtra(TunnelVpnService.TUNNEL_VPN_START_SUCCESS_EXTRA, true)) {
                        TunnelManagerThread.this.stopAll();
                    }
                } else if (TunnelVpnService.TUNNEL_VPN_DISCONNECT_BROADCAST.equals(action)) {
                    TunnelManagerThread.this.stopAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    };

    public interface OnStopCliente {
        void onStop();
    }

    public TunnelManagerThread(Handler handler, Context context) {
        this.mContext = context;
        this.mHandler = handler;
        this.mConfig = new C0223If(context);
    }

    public static boolean isServiceVpnRunning() {
        TunnelState tunnelState = TunnelState.getTunnelState();
        return tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null;
    }

    public synchronized void closeSSH() {
        stopForwarder();
    }

    public void reconnectSSH() {
        int i;
        if (this.mStarting || this.mStopping || this.mReconnecting) {
            return;
        }
        this.mReconnecting = true;
        closeSSH();
        SkStatus.updateStateString(SkStatus.SSH_RECONECTANDO, "Reconnecting..");
        try {
            Thread.sleep(1000L);
            while (!this.mStopping) {
                if (TunnelUtils.isNetworkOnline(this.mContext)) {
                    this.mStarting = true;
                    SkStatus.updateStateString(SkStatus.SSH_RECONECTANDO, "Reconnecting..");
                    SkStatus.logInfo("<strong>" + this.mContext.getString(R.string.state_reconnecting) + "</strong>");
                    try {
                        startClienteSSH();
                        this.mStarting = false;
                        this.mReconnecting = false;
                        return;
                    } catch (Exception unused) {
                        SkStatus.logInfo("<strong>" + this.mContext.getString(R.string.state_disconnected) + "</strong>");
                        this.mStarting = false;
                        i = 3;
                    }
                } else {
                    SkStatus.updateStateString(SkStatus.SSH_WAITING, "Waiting for network...");
                    SkStatus.logInfo(R.string.state_nonetwork, new Object[0]);
                    i = 5;
                }
                try {
                    Thread.sleep(i * 1000);
                } catch (InterruptedException unused2) {
                    this.mReconnecting = false;
                    return;
                }
            }
            this.mReconnecting = false;
        } catch (InterruptedException unused3) {
            this.mReconnecting = false;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.mStarting = true;
        this.mTunnelThreadStopSignal = new CountDownLatch(1);
        SkStatus.logInfo(this.mContext.getString(R.string.starting_service_ssh));
        int i = 0;
        while (true) {
            if (this.mStopping) {
                break;
            }
            try {
                try {
                } catch (Exception unused) {
                    SkStatus.logError("<strong>" + this.mContext.getString(R.string.state_disconnected) + "</strong>");
                    closeSSH();
                    Thread.sleep(3000L);
                }
                if (TunnelUtils.isNetworkOnline(this.mContext)) {
                    if (i > 0) {
                        SkStatus.logInfo("<strong>" + this.mContext.getString(R.string.state_reconnecting) + "</strong>");
                    }
                    try {
                        Thread.sleep(1000L);
                        startClienteSSH();
                        break;
                    } catch (InterruptedException unused2) {
                        stopAll();
                    }
                } else {
                    SkStatus.updateStateString(SkStatus.SSH_WAITING, this.mContext.getString(R.string.state_nonetwork));
                    SkStatus.logInfo(R.string.state_nonetwork, new Object[0]);
                    try {
                        Thread.sleep(5000L);
                        i++;
                    } catch (InterruptedException unused3) {
                        stopAll();
                    }
                }
                Thread.sleep(3000L);
                i++;
            } catch (InterruptedException unused4) {
                stopAll();
            }
            SkStatus.logError("<strong>" + this.mContext.getString(R.string.state_disconnected) + "</strong>");
            closeSSH();
        }
        this.mStarting = false;
        if (!this.mStopping) {
            try {
                this.mTunnelThreadStopSignal.await();
            } catch (InterruptedException unused5) {
                Thread.currentThread().interrupt();
            }
        }
        OnStopCliente onStopCliente = this.mListener;
        if (onStopCliente != null) {
            onStopCliente.onStop();
        }
    }

    public void setOnStopClienteListener(OnStopCliente onStopCliente) {
        this.mListener = onStopCliente;
    }

    public void startClienteSSH() {
        this.mStopping = false;
        this.mRunning = true;
        try {
            if (!this.mConfig.r()) {
                SkStatus.updateStateString(SkStatus.SSH_CONNECTED, "UDP Connected");
            }
            this.mConnected = true;
            startTunnelVpnService();
        } catch (Exception e) {
            this.mConnected = false;
            throw e;
        }
    }

    public void startForwarder(int i) {
        if (!this.mConnected) {
            throw new Exception();
        }
        startTunnelVpnService();
        new Thread(new Runnable() { // from class: prince.dastan.vpn.service.vpn.TunnelManagerThread.2
            @Override // java.lang.Runnable
            public void run() {
                while (TunnelManagerThread.this.mConnected) {
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
        }).start();
    }

    public void startTunnelVpnService() {
        String str;
        String[] strArr;
        if (!this.mConnected) {
            throw new IOException();
        }
        SkStatus.logInfo(R.string.service_tunnel_start, new Object[0]);
        IntentFilter intentFilter = new IntentFilter(TunnelVpnService.TUNNEL_VPN_DISCONNECT_BROADCAST);
        intentFilter.addAction(TunnelVpnService.TUNNEL_VPN_START_BROADCAST);
        AbstractC3131gc0.H(this.mContext, this.m_vpnTunnelBroadcastReceiver, intentFilter);
        if (this.mConfig.u().booleanValue()) {
            Locale locale = Locale.ENGLISH;
            str = "127.0.0.1:10808";
        } else {
            Locale locale2 = Locale.ENGLISH;
            str = "127.0.0.1:10802";
        }
        String str2 = str;
        String[] strArr2 = new String[0];
        if (this.mConfig.c().booleanValue()) {
            C0223If c0223If = this.mConfig;
            c0223If.getClass();
            strArr = c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-162327620843403L), Deobfuscator$BDNETVPN$app.getString(-162396340320139L)).split(";");
            for (int i = 0; i < strArr.length; i++) {
                strArr[i] = strArr[i].trim();
            }
        } else {
            strArr = new String[]{"1.1.1.1", "1.0.0.1"};
        }
        String[] strArr3 = strArr;
        if (isServiceVpnRunning()) {
            Log.d(TAG, "already running service");
            F00.h(this.mContext, "VPN Error, Restart Device!");
            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
            if (tunnelManager != null) {
                tunnelManager.restartTunnel(str2);
                return;
            }
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) TunnelVpnService.class);
        intent.setFlags(268435456);
        intent.putExtra(TunnelVpnManager.VPN_SETTINGS, new TunnelVpnSettings(str2, true, strArr3, true, null, strArr2, false, false, new String[0], true, false));
        if (this.mContext.startService(intent) == null) {
            SkStatus.logInfo(R.string.service_tunnel_failed, new Object[0]);
            throw new IOException(this.mContext.getString(R.string.vpn_service_failed));
        }
        TunnelState.getTunnelState().setStartingTunnelManager();
    }

    public void stopAll() {
        if (this.mStopping) {
            return;
        }
        SkStatus.updateStateString(SkStatus.SSH_STOPPING, this.mContext.getString(R.string.stopping_service_ssh));
        SkStatus.logInfo(this.mContext.getString(R.string.stopping_service_ssh));
        new Thread(new Runnable() { // from class: prince.dastan.vpn.service.vpn.TunnelManagerThread.1
            @Override // java.lang.Runnable
            public void run() {
                TunnelManagerThread.this.mStopping = true;
                if (TunnelManagerThread.this.mTunnelThreadStopSignal != null) {
                    TunnelManagerThread.this.mTunnelThreadStopSignal.countDown();
                }
                TunnelManagerThread.this.closeSSH();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                SkStatus.updateStateString(SkStatus.SSH_DISCONNECTED, TunnelManagerThread.this.mContext.getString(R.string.state_disconnected));
                TunnelManagerThread.this.mRunning = false;
                TunnelManagerThread.this.mStarting = false;
                TunnelManagerThread.this.mReconnecting = false;
            }
        }).start();
    }

    public void stopForwarder() {
        stopTunnelVpnService();
    }

    public synchronized void stopTunnelVpnService() {
        if (isServiceVpnRunning()) {
            SkStatus.logInfo(R.string.service_tunnel_stopping, new Object[0]);
            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
            if (tunnelManager != null) {
                tunnelManager.signalStopService();
            }
            try {
                this.mContext.unregisterReceiver(this.m_vpnTunnelBroadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
