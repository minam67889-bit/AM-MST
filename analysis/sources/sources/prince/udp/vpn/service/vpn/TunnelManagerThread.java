package prince.udp.vpn.service.vpn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import app.vpn.amtunnellite.R;
import com.liapp.y;
import defpackage.AbstractC4673wh;
import defpackage.C4363sf;
import defpackage.I70;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class TunnelManagerThread implements Runnable {
    private static final int AUTH_TRIES = 1;
    private static final int RECONNECT_TRIES = 5;
    private static final String TAG = "TunnelManagerThread";
    private C4363sf mConfig;
    private Context mContext;
    private Handler mHandler;
    private OnStopCliente mListener;
    private CountDownLatch mTunnelThreadStopSignal;
    private boolean mRunning = false;
    private boolean mStopping = false;
    private boolean mStarting = false;
    private boolean mConnected = false;
    public boolean mReconnecting = false;
    private BroadcastReceiver m_vpnTunnelBroadcastReceiver = new BroadcastReceiver() { // from class: prince.udp.vpn.service.vpn.TunnelManagerThread.3
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            TunnelManagerThread tunnelManagerThread;
            try {
                String action = intent.getAction();
                if ("tunnelVpnStartBroadcast".equals(action)) {
                    if (!intent.getBooleanExtra("tunnelVpnStartSuccessExtra", true)) {
                        tunnelManagerThread = TunnelManagerThread.this;
                        tunnelManagerThread.stopAll();
                    }
                } else if ("tunnelVpnDisconnectBroadcast".equals(action)) {
                    tunnelManagerThread = TunnelManagerThread.this;
                    tunnelManagerThread.stopAll();
                }
            } catch (Throwable th) {
                throw th;
            }
            throw th;
        }
    };

    public interface OnStopCliente {
        void onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TunnelManagerThread(Handler handler, Context context) {
        this.mContext = context;
        this.mHandler = handler;
        this.mConfig = new C4363sf(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isServiceVpnRunning() {
        TunnelState tunnelState = TunnelState.getTunnelState();
        return tunnelState.getStartingTunnelManager() || tunnelState.getTunnelManager() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void closeSSH() {
        stopForwarder();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reconnectSSH() {
        int i;
        if (this.mStarting || this.mStopping || this.mReconnecting) {
            return;
        }
        this.mReconnecting = true;
        closeSSH();
        String str = y.گ֮۬۲ݮ(2086485411);
        String str2 = y.׬ܮ֮ڱܭ(1520024016);
        SkStatus.updateStateString(str, str2);
        try {
            Thread.sleep(1000L);
            while (!this.mStopping) {
                if (TunnelUtils.isNetworkOnline(this.mContext)) {
                    this.mStarting = true;
                    SkStatus.updateStateString(str, str2);
                    String str3 = y.ܴٳݴܯޫ(-170325071);
                    StringBuilder sb = new StringBuilder(str3);
                    sb.append(this.mContext.getString(R.string.state_reconnecting));
                    String str4 = y.ܴ٭׮ڱܭ(-366440244);
                    sb.append(str4);
                    SkStatus.logInfo(sb.toString());
                    try {
                        startClienteSSH();
                        this.mStarting = false;
                        this.mReconnecting = false;
                        return;
                    } catch (Exception unused) {
                        SkStatus.logInfo(str3 + this.mContext.getString(R.string.state_disconnected) + str4);
                        this.mStarting = false;
                        i = 3;
                    }
                } else {
                    SkStatus.updateStateString(y.ܴٳݴܯޫ(-170325831), y.ܴ٭׮ڱܭ(-366439972));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        this.mStarting = true;
        this.mTunnelThreadStopSignal = new CountDownLatch(1);
        String str = y.ܴٳݴܯޫ(-170325071);
        StringBuilder sb = new StringBuilder(str);
        sb.append(this.mContext.getString(R.string.starting_service_ssh));
        String str2 = y.ܴ٭׮ڱܭ(-366440244);
        sb.append(str2);
        SkStatus.logInfo(sb.toString());
        int i = 0;
        while (true) {
            if (!this.mStopping) {
                try {
                } catch (Exception unused) {
                    SkStatus.logError(str + this.mContext.getString(R.string.state_disconnected) + str2);
                    closeSSH();
                    try {
                        Thread.sleep(3000L);
                    } catch (InterruptedException unused2) {
                        stopAll();
                    }
                }
                if (TunnelUtils.isNetworkOnline(this.mContext)) {
                    if (i > 0) {
                        SkStatus.logInfo(str + this.mContext.getString(R.string.state_reconnecting) + str2);
                    }
                    Thread.sleep(1000L);
                    startClienteSSH();
                    break;
                }
                SkStatus.updateStateString(SkStatus.SSH_WAITING, this.mContext.getString(R.string.state_nonetwork));
                SkStatus.logInfo(R.string.state_nonetwork, new Object[0]);
                try {
                    Thread.sleep(5000L);
                    i++;
                } catch (InterruptedException unused3) {
                    stopAll();
                }
            } else {
                break;
            }
        }
        this.mStarting = false;
        if (!this.mStopping) {
            try {
                this.mTunnelThreadStopSignal.await();
            } catch (InterruptedException unused4) {
                Thread.currentThread().interrupt();
            }
        }
        OnStopCliente onStopCliente = this.mListener;
        if (onStopCliente != null) {
            onStopCliente.onStop();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOnStopClienteListener(OnStopCliente onStopCliente) {
        this.mListener = onStopCliente;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startClienteSSH() {
        this.mStopping = false;
        this.mRunning = true;
        try {
            SkStatus.updateStateString(SkStatus.SSH_CONNECTED, "UDP Connected");
            this.mConnected = true;
            startTunnelVpnService();
        } catch (Exception e) {
            this.mConnected = false;
            throw e;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startForwarder(int i) {
        if (!this.mConnected) {
            throw new Exception();
        }
        startTunnelVpnService();
        new Thread(new Runnable() { // from class: prince.udp.vpn.service.vpn.TunnelManagerThread.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startTunnelVpnService() {
        if (!this.mConnected) {
            throw new IOException();
        }
        SkStatus.logInfo(R.string.service_tunnel_start, new Object[0]);
        IntentFilter intentFilter = new IntentFilter(y.ڮڴجۭݩ(1256564293));
        intentFilter.addAction(y.ڮڴجۭݩ(1256565077));
        AbstractC4673wh.N(this.mContext, this.m_vpnTunnelBroadcastReceiver, intentFilter);
        Locale locale = Locale.ENGLISH;
        String[] strArr = new String[0];
        String[] strArr2 = {VpnUtils.getNetworkDnsServer(this.mContext).get(0)};
        boolean isServiceVpnRunning = isServiceVpnRunning();
        String str = y.ܴ٭׮ڱܭ(-366436676);
        if (isServiceVpnRunning) {
            Log.d(TAG, y.ܴٳݴܯޫ(-170326903));
            I70.F(this.mContext, y.ܴ٭׮ڱܭ(-366437012));
            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
            if (tunnelManager != null) {
                tunnelManager.restartTunnel(str);
                return;
            }
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) TunnelVpnService.class);
        intent.setFlags(268435456);
        intent.putExtra(y.׬ܮ֮ڱܭ(1520023496), new TunnelVpnSettings(str, false, strArr2, false, null, strArr, false, false, new String[0], true, false));
        if (this.mContext.startService(intent) != null) {
            TunnelState.getTunnelState().setStartingTunnelManager();
        } else {
            SkStatus.logInfo(R.string.service_tunnel_failed, new Object[0]);
            throw new IOException(this.mContext.getString(R.string.vpn_service_failed));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void stopAll() {
        if (this.mStopping) {
            return;
        }
        SkStatus.updateStateString(y.ۮخݳ٬ۨ(1835704246), this.mContext.getString(R.string.stopping_service_ssh));
        SkStatus.logInfo(y.ܴٳݴܯޫ(-170325071) + this.mContext.getString(R.string.stopping_service_ssh) + y.ܴ٭׮ڱܭ(-366440244));
        new Thread(new Runnable() { // from class: prince.udp.vpn.service.vpn.TunnelManagerThread.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
                SkStatus.updateStateString(y.ۮخݳ٬ۨ(1835700438), TunnelManagerThread.this.mContext.getString(R.string.state_disconnected));
                TunnelManagerThread.this.mRunning = false;
                TunnelManagerThread.this.mStarting = false;
                TunnelManagerThread.this.mReconnecting = false;
            }
        }).start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void stopForwarder() {
        stopTunnelVpnService();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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
