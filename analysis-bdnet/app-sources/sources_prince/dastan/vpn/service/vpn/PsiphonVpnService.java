package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.content.Intent;
import android.net.VpnService;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes2.dex */
public class PsiphonVpnService extends VpnService {
    private static final String LOG_TAG = "PsiphonVpnService";
    public static final String TUNNEL_VPN_DISCONNECT_BROADCAST = "psiphonVpnDisconnectBroadcast";
    public static final String TUNNEL_VPN_START_BROADCAST = "psiphonVpnStartBroadcast";
    public static final String TUNNEL_VPN_START_SUCCESS_EXTRA = "psiphonVpnStartSuccessExtra";
    private Context mContext;
    private final IBinder m_binder = new LocalBinder();
    private TunnelVpnManagerPsi m_tunnelManager;

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public PsiphonVpnService getService() {
            return PsiphonVpnService.this;
        }
    }

    private void dispatchBroadcast(Intent intent) {
        sendBroadcast(intent);
    }

    public void broadcastVpnDisconnect() {
        dispatchBroadcast(new Intent(TUNNEL_VPN_DISCONNECT_BROADCAST));
    }

    public void broadcastVpnStart(boolean z) {
        Intent intent = new Intent(TUNNEL_VPN_START_BROADCAST);
        intent.putExtra(TUNNEL_VPN_START_SUCCESS_EXTRA, z);
        dispatchBroadcast(intent);
    }

    public VpnService.Builder newBuilder() {
        return new VpnService.Builder(this);
    }

    @Override // android.net.VpnService, android.app.Service
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        return (action == null || !action.equals("android.net.VpnService")) ? this.m_binder : super.onBind(intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d(LOG_TAG, "on create");
        this.mContext = getApplicationContext();
        this.m_tunnelManager = new TunnelVpnManagerPsi(this.mContext, this);
        TunnelState.getTunnelState().setTunnelManagerPsi(this.m_tunnelManager);
    }

    @Override // android.app.Service
    public void onDestroy() {
        Log.i(LOG_TAG, "on destroy");
        TunnelState.getTunnelState().setTunnelManagerPsi(null);
        this.m_tunnelManager.onDestroy();
    }

    @Override // android.net.VpnService
    public void onRevoke() {
        broadcastVpnDisconnect();
        stopSelf();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.d(LOG_TAG, "on start");
        return this.m_tunnelManager.onStartCommand(intent, i, i2);
    }
}
