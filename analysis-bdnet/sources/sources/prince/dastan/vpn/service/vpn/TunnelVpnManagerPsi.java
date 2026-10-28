package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import ca.psiphon.PsiphonTunnel;
import dastan.prince.bdfreevpn.R;
import defpackage.C0223If;
import defpackage.F00;
import defpackage.S50;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.vpn.logger.SkStatus;
import prince.dastan.vpn.utils.PUtils;

/* loaded from: classes2.dex */
public class TunnelVpnManagerPsi implements PsiphonTunnel.HostService {
    private static final String TAG = Deobfuscator$BDNETVPN$app.getString(-95923131479947L);
    private static PsiphonTunnel m_tunnel;
    public static SocksListener socksListener;
    private C0223If mConfig;
    private Context mContext;
    private PsiphonVpnService m_parentService;
    private Thread m_tunnelThread;
    private CountDownLatch m_tunnelThreadStopSignal;
    private AtomicBoolean m_isStopping = new AtomicBoolean(false);
    private AtomicBoolean m_isReconnecting = new AtomicBoolean(false);

    public interface ManagerListener {
        void onLog(String str);
    }

    public interface SocksListener {
        void addStatus(String str);

        void restartSocksOpenVPN();

        void startSocksOpenVPN();

        void stopSocksOpenVPN();
    }

    public TunnelVpnManagerPsi(Context context, PsiphonVpnService psiphonVpnService) {
        this.mContext = context;
        this.m_parentService = psiphonVpnService;
        m_tunnel = PsiphonTunnel.newPsiphonTunnel(this, true);
        this.mConfig = C0223If.d(context);
    }

    public static String getServerEntries(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
            sb.append(Deobfuscator$BDNETVPN$app.getString(-95914541545355L));
        }
        return sb.toString();
    }

    public static String loadServerDat(Context context, String str) {
        return S50.D(context, str);
    }

    private static byte[] readInputStreamToBytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[16384];
        while (true) {
            int read = inputStream.read(bArr, 0, 16384);
            if (read == -1) {
                byteArrayOutputStream.flush();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private static String readInputStreamToString(InputStream inputStream) {
        return new String(readInputStreamToBytes(inputStream), Deobfuscator$BDNETVPN$app.getString(-95609598867339L));
    }

    public static void setSocksListener(SocksListener socksListener2) {
        socksListener = socksListener2;
    }

    private void startTunnel() {
        this.m_tunnelThreadStopSignal = new CountDownLatch(1);
        Thread thread = new Thread(new Runnable() { // from class: prince.dastan.vpn.service.vpn.TunnelVpnManagerPsi.1
            @Override // java.lang.Runnable
            public void run() {
                TunnelVpnManagerPsi.this.startPsiphon();
            }
        });
        this.m_tunnelThread = thread;
        thread.start();
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public String getAppName() {
        return this.mContext.getString(R.string.app);
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public Context getContext() {
        return this.m_parentService;
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public String getPsiphonConfig() {
        try {
            return new JSONObject(readInputStreamToString(this.mContext.getResources().openRawResource(R.raw.psiphon_config))).toString();
        } catch (IOException e) {
            F00.g(this.mContext, Deobfuscator$BDNETVPN$app.getString(-94991123576715L) + e.getMessage());
            socksListener.stopSocksOpenVPN();
            TunnelManagerHelper.stopPsiphon(this.mContext);
            return Deobfuscator$BDNETVPN$app.getString(-95257411549067L);
        } catch (JSONException e2) {
            F00.g(this.mContext, Deobfuscator$BDNETVPN$app.getString(-95124267562891L) + e2.getMessage());
            socksListener.stopSocksOpenVPN();
            TunnelManagerHelper.stopPsiphon(this.mContext);
            return Deobfuscator$BDNETVPN$app.getString(-95257411549067L);
        }
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public Object getVpnService() {
        return this.m_parentService;
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public Object newVpnServiceBuilder() {
        return this.m_parentService.newBuilder();
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onAvailableEgressRegions(List<String> list) {
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onConnected() {
        socksListener.addStatus(Deobfuscator$BDNETVPN$app.getString(-94613166454667L));
        socksListener.startSocksOpenVPN();
        SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-94656116127627L), Deobfuscator$BDNETVPN$app.getString(-94699065800587L));
        SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-94776375211915L));
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onConnecting() {
        socksListener.addStatus(Deobfuscator$BDNETVPN$app.getString(-94565921814411L));
    }

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

    @Override // ca.psiphon.PsiphonTunnel.HostLogger
    public void onDiagnosticMessage(String str) {
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onHomepage(String str) {
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onHttpProxyPortInUse(int i) {
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onListeningHttpProxyPort(int i) {
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onListeningSocksProxyPort(int i) {
        SkStatus.logInfo(R.string.connecting, new Object[0]);
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onSocksProxyPortInUse(int i) {
        SocksListener socksListener2 = socksListener;
        if (socksListener2 != null) {
            socksListener2.stopSocksOpenVPN();
        } else {
            F00.h(this.mContext, Deobfuscator$BDNETVPN$app.getString(-94132130117515L));
        }
        SkStatus.logInfo(Deobfuscator$BDNETVPN$app.getString(-94260979136395L));
        TunnelManagerHelper.stopPsiphon(this.mContext);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        Log.i(Deobfuscator$BDNETVPN$app.getString(-95261706516363L), Deobfuscator$BDNETVPN$app.getString(-95334720960395L));
        try {
            startTunnel();
            return 2;
        } catch (Exception unused) {
            this.m_parentService.broadcastVpnStart(false);
            return 2;
        }
    }

    @Override // ca.psiphon.PsiphonTunnel.HostService
    public void onUpstreamProxyError(String str) {
        socksListener.stopSocksOpenVPN();
        TunnelManagerHelper.stopPsiphon(this.mContext);
    }

    public void restartTunnel() {
        Log.i(Deobfuscator$BDNETVPN$app.getString(-95454980044683L), Deobfuscator$BDNETVPN$app.getString(-95527994488715L));
        this.m_isReconnecting.set(true);
        m_tunnel = PsiphonTunnel.newPsiphonTunnel(this, true);
        startTunnel();
    }

    public void signalStopService() {
        CountDownLatch countDownLatch = this.m_tunnelThreadStopSignal;
        if (countDownLatch != null) {
            countDownLatch.countDown();
        }
        PsiphonTunnel psiphonTunnel = m_tunnel;
        if (psiphonTunnel != null) {
            psiphonTunnel.stop();
            m_tunnel = null;
        }
        socksListener.addStatus(Deobfuscator$BDNETVPN$app.getString(-95399145469835L));
    }

    public void startPsiphon() {
        String l = this.mConfig.l();
        String string = Deobfuscator$BDNETVPN$app.getString(-95635368671115L);
        try {
            string = loadServerDat(this.mContext, Deobfuscator$BDNETVPN$app.getString(-95639663638411L));
        } catch (Exception e) {
            F00.g(this.mContext, Deobfuscator$BDNETVPN$app.getString(-95686908278667L) + e.getMessage());
            socksListener.stopSocksOpenVPN();
            TunnelManagerHelper.stopPsiphon(this.mContext);
        }
        try {
            m_tunnel.startRouting();
            if (l.equals(Deobfuscator$BDNETVPN$app.getString(-95789987493771L))) {
                m_tunnel.startTunneling(PUtils.pDecrypt(this.mContext, string));
            } else {
                m_tunnel.startTunneling(PUtils.pDecrypt(this.mContext, l));
            }
        } catch (PsiphonTunnel.Exception e2) {
            F00.g(this.mContext, Deobfuscator$BDNETVPN$app.getString(-95811462330251L) + e2.getMessage());
            socksListener.stopSocksOpenVPN();
            TunnelManagerHelper.stopPsiphon(this.mContext);
        }
    }
}
