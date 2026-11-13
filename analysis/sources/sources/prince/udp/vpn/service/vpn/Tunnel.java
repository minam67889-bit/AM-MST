package prince.udp.vpn.service.vpn;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.ConnectionResult;
import com.liapp.y;
import defpackage.C3741kb;
import defpackage.XG;
import defpackage.XP;
import defpackage.YG;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import org.uproxy.tun2socks.Tun2SocksJni;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.WGService;
import prince.udp.vpn.service.vpn.Tun2Socks;
import prince.udp.vpn.service.vpn.VpnUtils;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class Tunnel {
    private static final String DNS_RESOLVER_IP = "8.8.8.8";
    private static final int DNS_RESOLVER_PORT = 53;
    private static final String VPN_INTERFACE_NETMASK = "255.255.255.0";
    private static Tunnel mTunnel;
    private final HostService mHostService;
    private Pdnsd mPdnsd;
    private VpnUtils.PrivateAddress mPrivateAddress;
    private YG mRoutes;
    private Tun2Socks mTun2Socks;
    private Thread mTun2SocksThread;
    private int mMtu = ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED;
    private AtomicReference<ParcelFileDescriptor> mTunFd = new AtomicReference<>();
    private AtomicBoolean mRoutingThroughTunnel = new AtomicBoolean(false);

    public interface HostService {
        String getAppName();

        Context getContext();

        Object getVpnService();

        Object newVpnServiceBuilder();

        void onDiagnosticMessage(String str);

        void onTunnelConnected();

        void onVpnEstablished();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized Tunnel newTunnel(HostService hostService) {
        Tunnel tunnel;
        synchronized (Tunnel.class) {
            try {
                Tunnel tunnel2 = mTunnel;
                if (tunnel2 != null) {
                    tunnel2.stop();
                }
                tunnel = new Tunnel(hostService);
                mTunnel = tunnel;
            } catch (Throwable th) {
                throw th;
            }
        }
        return tunnel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean routeThroughTunnel(String str, String[] strArr, boolean z, String str2, boolean z2) {
        ParcelFileDescriptor parcelFileDescriptor;
        String str3;
        if (!this.mRoutingThroughTunnel.compareAndSet(false, true) || (parcelFileDescriptor = this.mTunFd.get()) == null) {
            return false;
        }
        if (z) {
            int findAvailablePort = VpnUtils.findAvailablePort(8091, 10);
            Locale locale = Locale.ENGLISH;
            str3 = this.mPrivateAddress.mIpAddress + y.ܴٳݴܯޫ(-170209159) + findAvailablePort;
            Pdnsd pdnsd = new Pdnsd(this.mHostService.getContext(), strArr, 53, this.mPrivateAddress.mIpAddress, findAvailablePort);
            this.mPdnsd = pdnsd;
            pdnsd.start();
        } else {
            str3 = null;
        }
        Tun2Socks tun2Socks = new Tun2Socks(this.mHostService.getContext(), parcelFileDescriptor, this.mMtu, this.mPrivateAddress.mRouter, y.ڮڴجۭݩ(1256563429), str, str2, str3, z2);
        this.mTun2Socks = tun2Socks;
        tun2Socks.setOnTun2SocksListener(new Tun2Socks.OnTun2SocksListener() { // from class: prince.udp.vpn.service.vpn.Tunnel.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // prince.udp.vpn.service.vpn.Tun2Socks.OnTun2SocksListener
            public void onStart() {
                Tunnel.this.mHostService.onDiagnosticMessage(y.گ֮۬۲ݮ(2086484819));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // prince.udp.vpn.service.vpn.Tun2Socks.OnTun2SocksListener
            public void onStop() {
                Tunnel.this.mHostService.onDiagnosticMessage(y.ܴ٭׮ڱܭ(-366439060));
                Tunnel.this.stop();
            }
        });
        this.mTun2Socks.start();
        this.mHostService.onTunnelConnected();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void startTun2Socks(final ParcelFileDescriptor parcelFileDescriptor, final int i, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final boolean z, final boolean z2) {
        if (this.mTun2SocksThread != null) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: prince.udp.vpn.service.vpn.Tunnel.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                Tun2SocksJni.runTun2Socks(parcelFileDescriptor.getFd(), i, str, str2, str3, str4, str5, str6, z ? 1 : 0, z2 ? 1 : 0);
            }
        });
        this.mTun2SocksThread = thread;
        thread.start();
        this.mHostService.onDiagnosticMessage(y.گ֮۬۲ݮ(2086484819));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void stopRoutingThroughTunnel() {
        Tun2Socks tun2Socks = this.mTun2Socks;
        if (tun2Socks != null && tun2Socks.isAlive()) {
            this.mTun2Socks.interrupt();
        }
        this.mTun2Socks = null;
        Pdnsd pdnsd = this.mPdnsd;
        if (pdnsd != null && pdnsd.isAlive()) {
            this.mPdnsd.interrupt();
        }
        this.mPdnsd = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void stopTun2Socks() {
        if (this.mTun2SocksThread != null) {
            try {
                Tun2SocksJni.terminateTun2Socks();
                this.mTun2SocksThread.join();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            this.mTun2SocksThread = null;
            this.mRoutingThroughTunnel.set(false);
            this.mHostService.onDiagnosticMessage(y.ܴ٭׮ڱܭ(-366439060));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void stopVpn() {
        stopRoutingThroughTunnel();
        ParcelFileDescriptor andSet = this.mTunFd.getAndSet(null);
        if (andSet != null) {
            try {
                this.mHostService.onDiagnosticMessage("<strong>Disconnected</strong>");
                andSet.close();
            } catch (IOException unused) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object clone() {
        throw new CloneNotSupportedException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean startRouting(TunnelVpnSettings tunnelVpnSettings) {
        return startVpn(tunnelVpnSettings.mDnsForward, tunnelVpnSettings.mDnsResolver, tunnelVpnSettings.mExcludeIps, tunnelVpnSettings.mEnableFilterApps, tunnelVpnSettings.mFilterBypassMode, tunnelVpnSettings.mFilterApps, tunnelVpnSettings.mTetheringSubnet, tunnelVpnSettings.bypass);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean startTunneling(String str, String[] strArr, boolean z, String str2, boolean z2) {
        return routeThroughTunnel(str, strArr, z, str2, z2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void stop() {
        stopVpn();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void stopTunneling() {
        stopRoutingThroughTunnel();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Tunnel(HostService hostService) {
        this.mHostService = hostService;
        YG yg = new YG();
        yg.a = new TreeSet();
        this.mRoutes = yg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean startVpn(boolean z, String[] strArr, String[] strArr2, boolean z2, boolean z3, String[] strArr3, boolean z4, boolean z5) {
        int i;
        VpnService.Builder configureIntent;
        HostService hostService;
        String str;
        boolean z6 = z;
        String[] strArr4 = strArr;
        String str2 = y.ܴٳݴܯޫ(-170324239);
        StringBuilder sb = new StringBuilder(y.۳׭خ۲ݮ(1787137039));
        this.mPrivateAddress = VpnUtils.selectPrivateAddress();
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            i = 32;
            if (i2 >= length) {
                break;
            }
            this.mRoutes.a(new C3741kb(strArr2[i2], 32), false);
            i2++;
        }
        Locale locale = Locale.getDefault();
        try {
            try {
                try {
                    Locale.setDefault(new Locale("en"));
                    VpnService.Builder builder = (VpnService.Builder) this.mHostService.newVpnServiceBuilder();
                    VpnUtils.PrivateAddress privateAddress = this.mPrivateAddress;
                    VpnService.Builder addAddress = builder.addAddress(privateAddress.mIpAddress, privateAddress.mPrefixLength);
                    this.mRoutes.a(new C3741kb("0.0.0.0", 0), true);
                    this.mRoutes.a(new C3741kb("10.0.0.0", 8), false);
                    YG yg = this.mRoutes;
                    VpnUtils.PrivateAddress privateAddress2 = this.mPrivateAddress;
                    yg.a(new C3741kb(privateAddress2.mSubnet, privateAddress2.mPrefixLength), false);
                    if (z4) {
                        this.mRoutes.a(new C3741kb("192.168.42.0", 23), false);
                        this.mRoutes.a(new C3741kb("192.168.44.0", 24), false);
                        this.mRoutes.a(new C3741kb("192.168.49.0", 24), false);
                    }
                    this.mRoutes.a(new C3741kb("169.254.1.0", 24), false);
                    XP xp = new XP(this.mHostService.getContext());
                    xp.edit();
                    if (xp.getInt(Deobfuscator$AMTUNNELLITE$app.getString(-204971555491489L), 6) != 12 && xp.getInt(Deobfuscator$AMTUNNELLITE$app.getString(-204971555491489L), 6) != 13 && xp.getInt(Deobfuscator$AMTUNNELLITE$app.getString(-204971555491489L), 6) != 14) {
                        this.mRoutes.a(new C3741kb(xp.getString(Deobfuscator$AMTUNNELLITE$app.getString(-203708835106465L), Deobfuscator$AMTUNNELLITE$app.getString(-203730309942945L)), 32), false);
                    }
                    String str3 = y.گ֮۬۲ݮ(2086592147);
                    if (z6) {
                        int length2 = strArr4.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            String str4 = strArr4[i3];
                            try {
                                addAddress.addDnsServer(str4);
                                this.mRoutes.a(new C3741kb(str4, i), z6);
                            } catch (IllegalArgumentException e) {
                                this.mHostService.onDiagnosticMessage("Error adding dns " + str4 + str3 + e.getLocalizedMessage());
                            }
                            i3++;
                            z6 = z;
                            strArr4 = strArr;
                            i = 32;
                        }
                    }
                    String str5 = Build.VERSION.RELEASE;
                    addAddress.setMtu(this.mMtu);
                    Iterator it = this.mRoutes.c(true).iterator();
                    while (it.hasNext()) {
                        XG xg = (XG) it.next();
                        sb.append(String.format("%s/%d", xg.b(), Integer.valueOf(xg.b)));
                        sb.append(str3);
                    }
                    sb.deleteCharAt(sb.lastIndexOf(str3));
                    Iterator it2 = this.mRoutes.c(false).iterator();
                    while (it2.hasNext()) {
                    }
                    this.mHostService.onDiagnosticMessage(sb.toString());
                    XG xg2 = new XG(new C3741kb("224.0.0.0", 3), true);
                    Iterator it3 = this.mRoutes.d().iterator();
                    while (it3.hasNext()) {
                        XG xg3 = (XG) it3.next();
                        try {
                            BigInteger a = xg2.a();
                            BigInteger c = xg2.c();
                            BigInteger a2 = xg3.a();
                            BigInteger c2 = xg3.c();
                            boolean z7 = a.compareTo(a2) != 1;
                            boolean z8 = c.compareTo(c2) != -1;
                            if (z7 && z8) {
                                SkStatus.logDebug("VPN: Ignoring multicast route: " + xg3.toString());
                            } else {
                                addAddress.addRoute(xg3.b(), xg3.b);
                            }
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (z2) {
                        for (String str6 : strArr3) {
                            String str7 = y.گ֮۬۲ݮ(2086458571);
                            if (z3) {
                                try {
                                    addAddress.addDisallowedApplication(str6);
                                    hostService = this.mHostService;
                                    str = "Filtro de Apps: Vpn desativada para \"" + str6 + str7;
                                } catch (PackageManager.NameNotFoundException unused2) {
                                    this.mHostService.onDiagnosticMessage("Aplicativo \"" + str6 + "\" não encontrado. Filtro de Apps não irá funcionar, verifique as configurações.");
                                }
                            } else {
                                addAddress.addAllowedApplication(str6);
                                hostService = this.mHostService;
                                str = "Filtro de Apps: Vpn ativada para \"" + str6 + str7;
                            }
                            hostService.onDiagnosticMessage(str);
                        }
                    }
                    if (xp.getInt(Deobfuscator$AMTUNNELLITE$app.getString(-204971555491489L), 6) == 10) {
                        configureIntent = addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(WGService.b(this.mHostService.getContext()));
                    } else {
                        configureIntent = xp.getInt(Deobfuscator$AMTUNNELLITE$app.getString(-204971555491489L), 6) == 12 ? addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(DNSLiteService.b(this.mHostService.getContext())) : addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(SocksDNSService.b(this.mHostService.getContext()));
                    }
                    ParcelFileDescriptor establish = configureIntent.establish();
                    if (establish == null) {
                        Locale.setDefault(locale);
                        return false;
                    }
                    this.mTunFd.set(establish);
                    this.mRoutingThroughTunnel.set(false);
                    this.mHostService.onVpnEstablished();
                    this.mRoutes.b();
                    Locale.setDefault(locale);
                    return true;
                } catch (IllegalArgumentException e2) {
                    throw new Exception(str2, e2);
                }
            } catch (IllegalStateException e3) {
                throw new Exception(str2, e3);
            } catch (SecurityException e4) {
                throw new Exception(str2, e4);
            }
        } catch (Throwable th) {
            Locale.setDefault(locale);
            throw th;
        }
    }
}
