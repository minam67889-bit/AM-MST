package prince.udp.vpn.service.vpn;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.util.Log;
import app.vpn.amtunnellite.R;
import com.liapp.y;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import prince.udp.vpn.service.vpn.Tunnel;

/* loaded from: classes2.dex */
public class TunnelVpnManager implements Tunnel.HostService {
    private static final String TAG = "TunnelManager";
    public static final String VPN_SETTINGS = "vpnSettings";
    private TunnelVpnSettings mSettings;
    private TunnelVpnService m_parentService;
    private Tunnel m_tunnel;
    private Thread m_tunnelThread;
    private CountDownLatch m_tunnelThreadStopSignal;
    private AtomicBoolean m_isStopping = new AtomicBoolean(false);
    private AtomicBoolean m_isReconnecting = new AtomicBoolean(false);

    public interface ManagerListener {
        void onLog(String str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TunnelVpnManager(TunnelVpnService tunnelVpnService) {
        this.m_tunnel = null;
        this.m_parentService = tunnelVpnService;
        this.m_tunnel = Tunnel.newTunnel(this);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00a7, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a4, code lost:
    
        if (r14.m_isReconnecting.get() == false) goto L17;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void runTunnel(String str, String[] strArr, boolean z, String str2, boolean z2) {
        String str3 = y.׬ܮ֮ڱܭ(1520323920);
        String str4 = y.ܴ٭׮ڱܭ(-365992612);
        String str5 = y.ش۳ֲ׬٨(1672171722);
        String str6 = y.׬ܮ֮ڱܭ(1520324376);
        this.m_isStopping.set(false);
        try {
            try {
                if (!this.m_tunnel.startTunneling(str, strArr, z, str2, z2)) {
                    throw new Exception("application is not prepared or revoked");
                }
                Log.i(str5, "VPN service running");
                this.m_parentService.broadcastVpnStart(true);
                try {
                    this.m_tunnelThreadStopSignal.await();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
                this.m_isStopping.set(true);
            } catch (Exception e) {
                Log.e(str5, str6 + e.getMessage());
                this.m_parentService.broadcastVpnStart(false);
            }
        } finally {
            if (this.m_isReconnecting.get()) {
                Log.i(str5, str4);
                this.m_tunnel.stopTunneling();
            } else {
                Log.i(str5, str3);
                this.m_tunnel.stop();
                this.m_parentService.stopForeground(true);
                this.m_parentService.stopSelf();
            }
            this.m_isReconnecting.set(false);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startTunnel() {
        this.m_tunnelThreadStopSignal = new CountDownLatch(1);
        Thread thread = new Thread(new Runnable() { // from class: prince.udp.vpn.service.vpn.TunnelVpnManager.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                TunnelVpnManager tunnelVpnManager = TunnelVpnManager.this;
                TunnelVpnManager.b(tunnelVpnManager, tunnelVpnManager.mSettings.mSocksServer, TunnelVpnManager.this.mSettings.mDnsResolver, TunnelVpnManager.this.mSettings.mDnsForward);
            }
        });
        this.m_tunnelThread = thread;
        thread.start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public String getAppName() {
        return getContext().getString(R.string.f105app);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public Context getContext() {
        return this.m_parentService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onDestroy() {
        if (this.m_tunnelThread == null) {
            return;
        }
        signalStopService();
        try {
            this.m_tunnelThread.join();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        this.m_tunnelThreadStopSignal = null;
        this.m_tunnelThread = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public void onDiagnosticMessage(String str) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int onStartCommand(Intent intent, int i, int i2) {
        String str;
        Log.i(TAG, "onStartCommand");
        if (intent == null) {
            str = "Failed to receive intent";
        } else {
            TunnelVpnSettings tunnelVpnSettings = (TunnelVpnSettings) intent.getParcelableExtra(y.׬ܮ֮ڱܭ(1520023496));
            this.mSettings = tunnelVpnSettings;
            if (tunnelVpnSettings == null) {
                str = "Failed to receive the Vpn Settings.";
            } else if (tunnelVpnSettings.mSocksServer == null) {
                str = "Failed to receive the socks server address.";
            } else {
                if (tunnelVpnSettings.mDnsResolver != null) {
                    try {
                        if (this.m_tunnel.startRouting(tunnelVpnSettings)) {
                            return 2;
                        }
                        Log.e(TAG, "Failed to establish VPN");
                        this.m_parentService.broadcastVpnStart(false);
                        return 2;
                    } catch (Exception e) {
                        Log.e(TAG, y.ۮخݳ٬ۨ(1835884598) + e.getMessage());
                        this.m_parentService.broadcastVpnStart(false);
                        return 2;
                    }
                }
                str = "Failed to receive the dns resolvers.";
            }
        }
        Log.e(TAG, str);
        this.m_parentService.broadcastVpnStart(false);
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public void onTunnelConnected() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public void onVpnEstablished() {
        startTunnel();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void restartTunnel(String str) {
        Log.i(y.ش۳ֲ׬٨(1672171722), y.۳׭خ۲ݮ(1786936583));
        if (str == null || str.equals(this.mSettings.mSocksServer)) {
            this.m_parentService.broadcastVpnStart(true);
            return;
        }
        this.mSettings.mSocksServer = str;
        this.m_isReconnecting.set(true);
        signalStopService();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void signalStopService() {
        CountDownLatch countDownLatch = this.m_tunnelThreadStopSignal;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* bridge */ /* synthetic */ void b(TunnelVpnManager tunnelVpnManager, String str, String[] strArr, boolean z) {
        tunnelVpnManager.runTunnel(str, strArr, z, y.۳׭خ۲ݮ(1786935647), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public VpnService getVpnService() {
        return this.m_parentService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.Tunnel.HostService
    public VpnService.Builder newVpnServiceBuilder() {
        return this.m_parentService.newBuilder();
    }
}
