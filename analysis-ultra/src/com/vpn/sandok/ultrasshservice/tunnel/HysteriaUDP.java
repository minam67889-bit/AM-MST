package com.vpn.sandok.ultrasshservice.tunnel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.sandok.tunnel.utils.ConfigUtil;
import com.trilead.ssh2.transport.TransportManager;
import com.trilead.ssh2.util.Tokenizer;
import com.vpn.sandok.ultrasshservice.config.Settings;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.TunnelState;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.TunnelVpnManager;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.TunnelVpnService;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.TunnelVpnSettings;
import com.vpn.sandok.ultrasshservice.util.StreamGobbler;
import com.vpn.sandok.ultrasshservice.util.securepreferences.SecurePreferences;
import defpackage.hz;
import defpackage.p60;
import defpackage.vh;
import defpackage.wl0;
import defpackage.zq0;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import kotlin.Lazy;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public class HysteriaUDP extends Thread {
    private String address;
    private String auth;
    private String ca;
    Context context;
    private String dir;
    private String dwon;
    private StreamGobbler err;
    private File fileConf;
    private File fileDns;
    private File fileca;
    private String hop_interval;
    private String idle_Timeout;
    private String listen;
    private Settings mConfig;
    private BroadcastReceiver m_vpnTunnelBroadcastReceiver = new BroadcastReceiver() { // from class: com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP.5
        @Override // android.content.BroadcastReceiver
        public synchronized void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TunnelVpnService.TUNNEL_VPN_START_BROADCAST.equals(action)) {
                    if (!intent.getBooleanExtra(TunnelVpnService.TUNNEL_VPN_START_SUCCESS_EXTRA, true)) {
                        HysteriaUDP.this.interrupt();
                    }
                } else if (TunnelVpnService.TUNNEL_VPN_DISCONNECT_BROADCAST.equals(action)) {
                    HysteriaUDP.this.interrupt();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    };
    private String obfs;
    private StreamGobbler out;
    private String rc_conn;
    private String rc_w;
    private String resolve_prefs;
    private String resolver;
    private String retry;
    private String serv;
    private String server;
    String serverAddr;
    private Process udpProcess;
    private Thread udpThread;
    private String up;

    public HysteriaUDP(Context context) {
        this.context = context;
        this.dir = context.getFilesDir().getPath();
        this.mConfig = new Settings(context);
    }

    public static InetAddress createInetAddress(String str) throws UnknownHostException {
        InetAddress parseIPv4Address = parseIPv4Address(str);
        if (parseIPv4Address != null) {
            return parseIPv4Address;
        }
        return InetAddress.getByName(str);
    }

    public static Inet4Address getIPv4Addresses(InetAddress[] inetAddressArr) {
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress instanceof Inet4Address) {
                return (Inet4Address) inetAddress;
            }
        }
        return null;
    }

    public static boolean isServiceVpnRunning() {
        TunnelState tunnelState = TunnelState.getTunnelState();
        if (!tunnelState.getStartingTunnelManager() && tunnelState.getTunnelManager() == null) {
            return false;
        }
        return true;
    }

    private static InetAddress parseIPv4Address(String str) throws UnknownHostException {
        String[] parseTokens;
        if (str == null || (parseTokens = Tokenizer.parseTokens(str, '.')) == null || parseTokens.length != 4) {
            return null;
        }
        byte[] bArr = new byte[4];
        for (int i = 0; i < 4; i++) {
            if (parseTokens[i].length() == 0 || parseTokens[i].length() > 3) {
                return null;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < parseTokens[i].length(); i3++) {
                char charAt = parseTokens[i].charAt(i3);
                if (charAt < '0' || charAt > '9') {
                    return null;
                }
                i2 = (i2 * 10) + (charAt - '0');
            }
            if (i2 > 255) {
                return null;
            }
            bArr[i] = (byte) i2;
        }
        return InetAddress.getByAddress(str, bArr);
    }

    private boolean printToFile(File file, String str) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // java.lang.Thread
    public void interrupt() {
        this.mConfig.setVpnDnsResolver(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        stopTunnelVpnService();
        SkStatus.updateStateString(SkStatus.SSH_PARANDO, this.context.getString(R.string.stopping_service_ssh));
        SkStatus.logInfo("<strong>" + this.context.getString(R.string.stopping_service_ssh) + "</strong>");
        new Thread(new Runnable() { // from class: com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP.4
            @Override // java.lang.Runnable
            public void run() {
                SkStatus.logInfo("Stopping UDP....");
                HysteriaUDP.this.stopThread();
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException unused) {
                }
                TunnelManagerHelper.stopSocksHttp(HysteriaUDP.this.context);
            }
        }).start();
        super.interrupt();
    }

    /* JADX WARN: Type inference failed for: r0v21, types: [com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP$1] */
    /* JADX WARN: Type inference failed for: r0v23, types: [com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP$2] */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        SkStatus.updateStateString(SkStatus.SSH_CONECTANDO, this.context.getString(R.string.state_connecting));
        SkStatus.logInfo("<strong>Starting UDP Hysteria</strong>");
        this.fileca = new File(this.dir, "zi.ca.crt");
        String sSHHost = ConfigUtil.getInstance(this.context).getSSHHost();
        this.serv = sSHHost;
        InetAddress[] inetAddressArr = new InetAddress[0];
        try {
            inetAddressArr = InetAddress.getAllByName(sSHHost);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            this.address = getIPv4Addresses(inetAddressArr).getHostAddress();
        } catch (Exception e2) {
            e2.printStackTrace();
            if (String.valueOf(e2).contains("on a null object reference")) {
                SkStatus.logInfo("<font color='red'><strong>Invalid UDP Server</strong></font>");
                stopThread();
            }
        }
        this.server = vh.s(new StringBuilder(), this.address, ":20000-50000");
        Lazy lazy = zq0.a;
        this.obfs = zq0.u().d("OBFS");
        this.auth = zq0.u().d("UDP_USER");
        this.up = "2";
        this.dwon = "3";
        this.retry = "3";
        new Object() { // from class: com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP.1
            int t;

            public String toString() {
                this.t = -1863007685;
                return new String(new byte[]{(byte) ((-1422702796) >>> 16), (byte) ((-970871079) >>> 21), (byte) ((-2074371888) >>> 2), (byte) (1667121230 >>> 20), (byte) ((-838130821) >>> 4), (byte) (1338087215 >>> 11), (byte) ((-478106240) >>> 20), (byte) ((-1863007685) >>> 10)});
            }
        }.toString();
        this.rc_conn = "31457280";
        new Object() { // from class: com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP.2
            int t;

            public String toString() {
                this.t = 1401574356;
                return new String(new byte[]{(byte) ((-932993183) >>> 17), (byte) ((-1428806450) >>> 2), (byte) ((-1264155459) >>> 13), (byte) ((-778607804) >>> 19), (byte) (1966175411 >>> 16), (byte) (471578224 >>> 15), (byte) ((-2012684839) >>> 10), (byte) ((-121001578) >>> 3), (byte) (1401574356 >>> 20)});
            }
        }.toString();
        this.rc_w = "107374182400";
        this.idle_Timeout = "60";
        this.hop_interval = "120";
        this.resolver = "udp://1.1.1.1:53";
        this.resolve_prefs = "64";
        this.listen = "127.0.0.1:1080";
        String s = vh.s(new StringBuilder(), this.dir, "/zi.ca.crt");
        this.ca = s;
        String str = this.server;
        String str2 = this.obfs;
        String str3 = this.auth;
        String str4 = this.up;
        String str5 = this.dwon;
        String str6 = this.retry;
        String str7 = this.listen;
        String str8 = this.rc_conn;
        String str9 = this.rc_w;
        String str10 = this.idle_Timeout;
        String str11 = this.hop_interval;
        String str12 = this.resolver;
        String str13 = this.resolve_prefs;
        StringBuilder A = hz.A("{\n  \"server\": \"", str, "\",\n  \"obfs\": \"", str2, "\",\n  \"auth_str\": \"");
        hz.H(A, str3, "\",\n  \"up_mbps\": ", str4, ",\n  \"down_mbps\": ");
        hz.H(A, str5, ",\n  \"retry\": ", str6, ",\n  \"retry_interval\": 1,\n  \"socks5\": {\n    \"listen\": \"");
        hz.H(A, str7, "\"\n  },\n  \"insecure\": true,\n  \"ca\": \"", s, "\",\n  \"recv_window_conn\": ");
        hz.H(A, str8, ",\n  \"recv_window\": ", str9, ",\n \"idle_timeout\": ");
        hz.H(A, str10, ",\n \"hop_interval\": ", str11, ",\n \"resolver\": \"");
        String x = hz.x(A, str12, "\",\n \"resolve_preference\": \"", str13, "\"\n}");
        this.fileConf = new File(this.dir, "config.json");
        if (printToFile(this.fileca, "-----BEGIN CERTIFICATE-----\nMIIDizCCAnOgAwIBAgIUGxLl5Ou4dR1h3c9lUcaM5bp4ZBswDQYJKoZIhvcNAQEL\nBQAwVTELMAkGA1UEBhMCQ04xCzAJBgNVBAgMAkdEMQswCQYDVQQHDAJTWjEUMBIG\nA1UECgwLWklWUE4sIEluYy4xFjAUBgNVBAMMDVpJVlBOIFJvb3QgQ0EwHhcNMjMw\nMjExMDkwMjM1WhcNMzMwMjA4MDkwMjM1WjBVMQswCQYDVQQGEwJDTjELMAkGA1UE\nCAwCR0QxCzAJBgNVBAcMAlNaMRQwEgYDVQQKDAtaSVZQTiwgSW5jLjEWMBQGA1UE\nAwwNWklWUE4gUm9vdCBDQTCCASIwDQYJKoZIhvcNAQEBBQADggEPADCCAQoCggEB\nAMQsHTq2UD4WDOvNUFGQuKd0PEitgQzSh12qH9aJ5jnCtbWjqVNDRQSW0ietg4Po\nqOfKLOBvGOJcGkrYlAAynnwsufdkZd2Jj2+FAXloAbMBK5cjqRANfPJ7ns3S5zL2\nt2+Xv/O6H58NL5QksyIHb2Vcosfelwuvj5Lq+MvyqGZikce5IaykgjjV0OsrBnsC\neK4yAeoxsqVixGwmcJDLGOIJDGYcDdaElqJqFCyOjOhLLDymx9JbeOb3DpiRNFNN\nlwXi2rfvpnmpGNwNt9sclWAQTL3cfV4GsCovT02r1qxcAqqRE4U1nqMRqk0KfyQn\nUebOat/0jNJI9YxJByuVBK0CAwEAAaNTMFEwHQYDVR0OBBYEFGk91bjhFZfcKkpm\n5SxVkqnSGhXBMB8GA1UdIwQYMBaAFGk91bjhFZfcKkpm5SxVkqnSGhXBMA8GA1Ud\nEwEB/wQFMAMBAf8wDQYJKoZIhvcNAQELBQADggEBAEr4aeE0ib5/7neEcRWCE1pg\nw0j/958bdaSdQJJvYEpc7brCHhp5lmNJA+MjVcCXCL4/8KfuEcyGNPPSPo7wbuYJ\nO9jsJmQOklfyvlKGJschvc8AZ0E0AGdrgGam1KApjrb6Xly5bqgV4KPBQ7KttBVw\nwFfTm0yjD3nAjaSXi3I/MG+gMGnUXoTMZa3iS2pomBMHLdTksiujbbH7RP9mzPT3\n7UvyVmtw7eQFEjEYceVWHlhXCjL9gpcJiX/wu9XzREDpNCqY2R3zb+ZGYuQD0L5h\nzv0u1CF+Cfkkg8luxol+aWc+1ac/8TGLV1WOGj4FuEMfxQPXWFqhc8VEyxZ/r/w=\n-----END CERTIFICATE-----") && printToFile(this.fileConf, x)) {
            File file = new File(this.context.getApplicationInfo().nativeLibraryDir, "libuz.so");
            this.fileDns = file;
            String[] strArr = {file.getAbsolutePath(), "client", "--config", this.fileConf.getAbsolutePath()};
            StreamGobbler.OnLineListener onLineListener = new StreamGobbler.OnLineListener() { // from class: com.vpn.sandok.ultrasshservice.tunnel.HysteriaUDP.3
                @Override // com.vpn.sandok.ultrasshservice.util.StreamGobbler.OnLineListener
                public void onLine(String str14) {
                    SecurePreferences prefsPrivate = HysteriaUDP.this.mConfig.getPrefsPrivate();
                    if (str14.contains("Connected")) {
                        SkStatus.logInfo("<font color='green'><strong>UDP Connected Successfully</strong></font>");
                        SkStatus.logInfo("<font color='#FF7F27'><strong>You are ready to go</strong></font>");
                        SkStatus.logInfo("<strong>" + HysteriaUDP.this.context.getString(R.string.state_connected) + "</strong>");
                        try {
                            HysteriaUDP.this.startTunnelVpnService();
                            return;
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (!str14.contains("no recent network activity")) {
                        if (!str14.contains("Connection to server lost") && !str14.contains("handshake did not complete in time")) {
                            if (str14.contains("Failed to parse client configuration")) {
                                SkStatus.logInfo("<font color='red'><strong>Invalid UDP setting</strong></font>");
                                HysteriaUDP.this.stopThread();
                                return;
                            } else if (str14.contains("auth error")) {
                                SkStatus.logInfo("<font color='red'><strong>Authentication failed, invalid password/expired/may logged-in on another device</strong></font>");
                                HysteriaUDP.this.stopThread();
                                return;
                            } else {
                                if (str14.contains("too many connections")) {
                                    SkStatus.logInfo("<font color='red'><strong>Same account on multi-device not support</strong></font>");
                                    HysteriaUDP.this.stopThread();
                                    return;
                                }
                                return;
                            }
                        }
                        SkStatus.logInfo("<font color='red'><strong>Please wait reconnecting UDP</strong></font>");
                        return;
                    }
                    if (prefsPrivate.getBoolean("reconnectup", false)) {
                        SkStatus.logInfo("<font color='red'><strong>Connection Lost retrying </strong></font>");
                        HysteriaUDP.this.stopThread();
                    } else {
                        SkStatus.logInfo("<font color='red'><strong>UDP connection Lost</strong></font>");
                        HysteriaUDP.this.stopThread();
                    }
                }
            };
            try {
                Process start = new ProcessBuilder(new String[0]).command(strArr).redirectErrorStream(true).start();
                this.udpProcess = start;
                this.out = new StreamGobbler(start.getInputStream(), onLineListener);
                this.err = new StreamGobbler(this.udpProcess.getErrorStream(), onLineListener);
                this.out.start();
                this.err.start();
                this.udpProcess.waitFor();
                return;
            } catch (IOException | InterruptedException e3) {
                e3.printStackTrace();
                return;
            }
        }
        interrupt();
    }

    public void startTunnelVpnService() throws IOException {
        String str;
        boolean z;
        IntentFilter intentFilter = new IntentFilter(TunnelVpnService.TUNNEL_VPN_DISCONNECT_BROADCAST);
        intentFilter.addAction(TunnelVpnService.TUNNEL_VPN_START_BROADCAST);
        wl0.a(this.context).b(this.m_vpnTunnelBroadcastReceiver, intentFilter);
        SkStatus.logInfo("starting tunnel service");
        if (this.mConfig.getVpnUdpForward()) {
            str = this.mConfig.getVpnUdpResolver();
        } else {
            str = null;
        }
        String str2 = str;
        try {
            String hostAddress = TransportManager.createInetAddress(this.serv).getHostAddress();
            this.serverAddr = hostAddress;
            String[] strArr = {hostAddress};
            String[] strArr2 = {this.mConfig.getVpnDnsResolver()};
            if (isServiceVpnRunning()) {
                TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
                if (tunnelManager != null) {
                    tunnelManager.restartTunnel("127.0.0.1:1080");
                    return;
                }
                return;
            }
            Intent intent = new Intent(this.context, (Class<?>) TunnelVpnService.class);
            intent.setFlags(268435456);
            if (str2 != null) {
                z = false;
            } else {
                z = true;
            }
            intent.putExtra(TunnelVpnManager.VPN_SETTINGS, new TunnelVpnSettings("127.0.0.1:1080", true, strArr2, z, str2, strArr, this.mConfig.getIsFilterApps(), this.mConfig.getIsFilterBypassMode(), this.mConfig.getFilterApps(), this.mConfig.getIsTetheringSubnet(), this.mConfig.getBypass()));
            if (this.context.startService(intent) != null) {
                TunnelState.getTunnelState().setStartingTunnelManager();
                SkStatus.updateStateString(SkStatus.SSH_CONECTADO, "Hysteria Connected");
                SkStatus.logInfo("<strong><html><font color='#008A00'>Connected</font></html></strong>");
            } else {
                SkStatus.logInfo("failed to start tunnel vpn service");
                p60.f("Falha ao iniciar Vpn Service");
            }
        } catch (UnknownHostException unused) {
            p60.f(this.context.getString(R.string.error_server_ip_invalid));
        }
    }

    public void stopThread() {
        StreamGobbler streamGobbler = this.out;
        if (streamGobbler != null) {
            streamGobbler.interrupt();
            this.out = null;
        }
        StreamGobbler streamGobbler2 = this.err;
        if (streamGobbler2 != null) {
            streamGobbler2.interrupt();
            this.err = null;
        }
        Process process = this.udpProcess;
        if (process != null) {
            process.destroy();
            this.udpProcess = null;
        }
        File file = this.fileConf;
        if (file != null && file.exists()) {
            this.fileConf.delete();
        }
        SkStatus.logInfo("Udp Process Stopped...");
        SkStatus.updateStateString(SkStatus.SSH_DESCONECTADO, this.context.getString(R.string.state_disconnected));
    }

    public synchronized void stopTunnelVpnService() {
        try {
            if (!isServiceVpnRunning()) {
                return;
            }
            SkStatus.logInfo("stopping tunnel service");
            TunnelVpnManager tunnelManager = TunnelState.getTunnelState().getTunnelManager();
            if (tunnelManager != null) {
                tunnelManager.signalStopService();
            }
            wl0.a(this.context).d(this.m_vpnTunnelBroadcastReceiver);
        } catch (Throwable th) {
            throw th;
        }
    }
}
