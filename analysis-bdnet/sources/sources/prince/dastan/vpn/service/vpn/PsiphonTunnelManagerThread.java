package prince.dastan.vpn.service.vpn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3131gc0;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class PsiphonTunnelManagerThread implements Runnable {
    private static final int AUTH_TRIES = 1;
    private static final int RECONNECT_TRIES = 5;
    private static final String TAG = "PsiphonTunnelManagerThread";
    private Context mContext;
    private Handler mHandler;
    private OnStopCliente mListener;
    private CountDownLatch mTunnelThreadStopSignal;
    private boolean mRunning = false;
    private boolean mStopping = false;
    private boolean mStarting = false;
    private boolean mConnected = false;
    public boolean mReconnecting = false;
    private BroadcastReceiver m_vpnTunnelBroadcastReceiver = new BroadcastReceiver() { // from class: prince.dastan.vpn.service.vpn.PsiphonTunnelManagerThread.2
        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (Deobfuscator$BDNETVPN$app.getString(-93071273195403L).equals(action)) {
                    if (!intent.getBooleanExtra(Deobfuscator$BDNETVPN$app.getString(-93178647377803L), true)) {
                        PsiphonTunnelManagerThread.this.stopAll();
                    }
                } else if (Deobfuscator$BDNETVPN$app.getString(-93298906462091L).equals(action)) {
                    PsiphonTunnelManagerThread.this.stopAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    };

    public interface OnStopCliente {
        void onStop();
    }

    public PsiphonTunnelManagerThread(Handler handler, Context context) {
        this.mContext = context;
        this.mHandler = handler;
    }

    public static boolean isServiceVpnRunning() {
        return TunnelState.getTunnelState().getTunnelManagerPsi() != null;
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
        try {
            Thread.sleep(1000L);
            while (!this.mStopping) {
                if (TunnelUtils.isNetworkOnline(this.mContext)) {
                    this.mStarting = true;
                    try {
                        startClienteSSH();
                        this.mStarting = false;
                        this.mReconnecting = false;
                        return;
                    } catch (Exception unused) {
                        this.mStarting = false;
                        i = 3;
                    }
                } else {
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
                    SkStatus.logError(Deobfuscator$BDNETVPN$app.getString(-93543719597963L) + this.mContext.getString(R.string.state_disconnected) + Deobfuscator$BDNETVPN$app.getString(-93582374303627L));
                    closeSSH();
                    Thread.sleep(3000L);
                }
                if (TunnelUtils.isNetworkOnline(this.mContext)) {
                    if (i > 0) {
                        SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-93462115219339L) + this.mContext.getString(R.string.state_reconnecting) + Deobfuscator$BDNETVPN$app.getString(-93500769925003L));
                    }
                    try {
                        Thread.sleep(1000L);
                        startClienteSSH();
                        break;
                    } catch (InterruptedException unused2) {
                        stopAll();
                    }
                } else {
                    SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-93427755480971L), this.mContext.getString(R.string.state_nonetwork));
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
            SkStatus.logError(Deobfuscator$BDNETVPN$app.getString(-93543719597963L) + this.mContext.getString(R.string.state_disconnected) + Deobfuscator$BDNETVPN$app.getString(-93582374303627L));
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
            SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-93663978682251L), Deobfuscator$BDNETVPN$app.getString(-93711223322507L));
            this.mConnected = true;
            startTunnelVpnService();
        } catch (Exception e) {
            this.mConnected = false;
            throw e;
        }
    }

    public void startTunnelVpnService() {
        if (!this.mConnected) {
            throw new IOException();
        }
        SkStatus.logInfo(R.string.service_tunnel_start, new Object[0]);
        IntentFilter intentFilter = new IntentFilter(Deobfuscator$BDNETVPN$app.getString(-93792827701131L));
        intentFilter.addAction(Deobfuscator$BDNETVPN$app.getString(-93921676720011L));
        AbstractC3131gc0.H(this.mContext, this.m_vpnTunnelBroadcastReceiver, intentFilter);
        if (isServiceVpnRunning()) {
            Log.d(TAG, Deobfuscator$BDNETVPN$app.getString(-94029050902411L));
            TunnelVpnManagerPsi tunnelManagerPsi = TunnelState.getTunnelState().getTunnelManagerPsi();
            if (tunnelManagerPsi != null) {
                tunnelManagerPsi.restartTunnel();
                return;
            }
            return;
        }
        Intent intent = new Intent(this.mContext, (Class<?>) PsiphonVpnService.class);
        intent.setFlags(268435456);
        if (this.mContext.startService(intent) != null) {
            TunnelState.getTunnelState().setStartingTunnelManager();
        } else {
            SkStatus.logInfo(R.string.service_tunnel_failed, new Object[0]);
            throw new IOException(this.mContext.getString(R.string.vpn_service_failed));
        }
    }

    public void stopAll() {
        if (this.mStopping) {
            return;
        }
        SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-93625323976587L), this.mContext.getString(R.string.stopping_service_ssh));
        SkStatus.logInfo(this.mContext.getString(R.string.stopping_service_ssh));
        new Thread(new Runnable() { // from class: prince.dastan.vpn.service.vpn.PsiphonTunnelManagerThread.1
            @Override // java.lang.Runnable
            public void run() {
                PsiphonTunnelManagerThread.this.mStopping = true;
                if (PsiphonTunnelManagerThread.this.mTunnelThreadStopSignal != null) {
                    PsiphonTunnelManagerThread.this.mTunnelThreadStopSignal.countDown();
                }
                PsiphonTunnelManagerThread.this.closeSSH();
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException unused) {
                }
                SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-93015438620555L), PsiphonTunnelManagerThread.this.mContext.getString(R.string.state_disconnected));
                PsiphonTunnelManagerThread.this.mRunning = false;
                PsiphonTunnelManagerThread.this.mStarting = false;
                PsiphonTunnelManagerThread.this.mReconnecting = false;
            }
        }).start();
    }

    public void stopForwarder() {
        stopTunnelVpnService();
    }

    public synchronized void stopTunnelVpnService() {
        if (isServiceVpnRunning()) {
            TunnelVpnManagerPsi tunnelManagerPsi = TunnelState.getTunnelState().getTunnelManagerPsi();
            if (tunnelManagerPsi != null) {
                tunnelManagerPsi.signalStopService();
            }
            try {
                this.mContext.unregisterReceiver(this.m_vpnTunnelBroadcastReceiver);
            } catch (IllegalArgumentException unused) {
            }
        }
    }
}
