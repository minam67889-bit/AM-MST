package com.vpn.sandok.ultrasshservice.tunnel.vpn;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.vpn.sandok.ultrasshservice.SocksHttpService;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.NetworkSpace;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.Pdnsd;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.Tun2Socks;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.VpnUtils;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public class Tunnel {
    private static final String DNS_RESOLVER_IP = "8.8.8.8";
    private static final int DNS_RESOLVER_PORT = 53;
    private static final String VPN_INTERFACE_NETMASK = "255.255.255.0";
    private static Tunnel mTunnel;
    private final HostService mHostService;
    private Pdnsd mPdnsd;
    private VpnUtils.PrivateAddress mPrivateAddress;
    private Tun2Socks mTun2Socks;
    private int mMtu = TunnelConstants.VPN_INTERFACE_MTU;
    private AtomicReference<ParcelFileDescriptor> mTunFd = new AtomicReference<>();
    private AtomicBoolean mRoutingThroughTunnel = new AtomicBoolean(false);
    private NetworkSpace mRoutes = new NetworkSpace();

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    /* loaded from: classes3.dex */
    public interface HostService {
        String getAppName();

        Context getContext();

        Object getVpnService();

        Object newVpnServiceBuilder();

        void onDiagnosticMessage(String str);

        void onTunnelConnected();

        void onVpnEstablished();
    }

    private Tunnel(HostService hostService) {
        this.mHostService = hostService;
    }

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

    private boolean routeThroughTunnel(String str, String[] strArr, boolean z, String str2, boolean z2) {
        ParcelFileDescriptor parcelFileDescriptor;
        String str3;
        if (!this.mRoutingThroughTunnel.compareAndSet(false, true) || (parcelFileDescriptor = this.mTunFd.get()) == null) {
            return false;
        }
        if (z) {
            int findAvailablePort = VpnUtils.findAvailablePort(8091, 10);
            str3 = String.format("%s:%d", this.mPrivateAddress.mIpAddress, Integer.valueOf(findAvailablePort));
            Pdnsd pdnsd = new Pdnsd(this.mHostService.getContext(), strArr, 53, this.mPrivateAddress.mIpAddress, findAvailablePort);
            this.mPdnsd = pdnsd;
            pdnsd.setOnPdnsdListener(new Pdnsd.OnPdnsdListener() { // from class: com.vpn.sandok.ultrasshservice.tunnel.vpn.Tunnel.1
                @Override // com.vpn.sandok.ultrasshservice.tunnel.vpn.Pdnsd.OnPdnsdListener
                public void onStart() {
                    Tunnel.this.mHostService.onDiagnosticMessage("pdnsd started");
                }

                @Override // com.vpn.sandok.ultrasshservice.tunnel.vpn.Pdnsd.OnPdnsdListener
                public void onStop() {
                    Tunnel.this.mHostService.onDiagnosticMessage("pdnsd stopped");
                    Tunnel.this.stop();
                }
            });
            this.mPdnsd.start();
        } else {
            str3 = null;
        }
        Tun2Socks tun2Socks = new Tun2Socks(this.mHostService.getContext(), parcelFileDescriptor, this.mMtu, this.mPrivateAddress.mRouter, "255.255.255.0", str, str2, str3, z2);
        this.mTun2Socks = tun2Socks;
        tun2Socks.setOnTun2SocksListener(new Tun2Socks.OnTun2SocksListener() { // from class: com.vpn.sandok.ultrasshservice.tunnel.vpn.Tunnel.2
            @Override // com.vpn.sandok.ultrasshservice.tunnel.vpn.Tun2Socks.OnTun2SocksListener
            public void onStart() {
                Tunnel.this.mHostService.onDiagnosticMessage("tun2socks started");
            }

            @Override // com.vpn.sandok.ultrasshservice.tunnel.vpn.Tun2Socks.OnTun2SocksListener
            public void onStop() {
                Tunnel.this.mHostService.onDiagnosticMessage("tun2socks stopped");
                Tunnel.this.stop();
            }
        });
        this.mTun2Socks.start();
        this.mHostService.onTunnelConnected();
        return true;
    }

    private boolean startVpn(boolean z, String[] strArr, String[] strArr2, boolean z2, boolean z3, String[] strArr3, boolean z4, boolean z5) throws Exception {
        StringBuilder sb = new StringBuilder("Routes: ");
        this.mPrivateAddress = VpnUtils.selectPrivateAddress();
        for (String str : strArr2) {
            this.mRoutes.addIP(new CIDRIP(str, 32), false);
        }
        Locale locale = Locale.getDefault();
        try {
            try {
                try {
                    try {
                        Locale.setDefault(new Locale("en"));
                        VpnService.Builder builder = (VpnService.Builder) this.mHostService.newVpnServiceBuilder();
                        VpnUtils.PrivateAddress privateAddress = this.mPrivateAddress;
                        VpnService.Builder addAddress = builder.addAddress(privateAddress.mIpAddress, privateAddress.mPrefixLength);
                        this.mRoutes.addIP(new CIDRIP("0.0.0.0", 0), true);
                        this.mRoutes.addIP(new CIDRIP("10.0.0.0", 8), false);
                        NetworkSpace networkSpace = this.mRoutes;
                        VpnUtils.PrivateAddress privateAddress2 = this.mPrivateAddress;
                        networkSpace.addIP(new CIDRIP(privateAddress2.mSubnet, privateAddress2.mPrefixLength), false);
                        if (z4) {
                            this.mRoutes.addIP(new CIDRIP("192.168.42.0", 23), false);
                            this.mRoutes.addIP(new CIDRIP("192.168.44.0", 24), false);
                            this.mRoutes.addIP(new CIDRIP("192.168.49.0", 24), false);
                        }
                        for (String str2 : strArr) {
                            try {
                                addAddress.addDnsServer(str2);
                                this.mRoutes.addIP(new CIDRIP(str2, 32), z);
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                        String str3 = Build.VERSION.RELEASE;
                        addAddress.setMtu(this.mMtu);
                        for (NetworkSpace.IpAddress ipAddress : this.mRoutes.getNetworks(true)) {
                            sb.append(String.format("%s/%d", ipAddress.getIPv4Address(), Integer.valueOf(ipAddress.networkMask)));
                            sb.append(", ");
                        }
                        sb.deleteCharAt(sb.lastIndexOf(", "));
                        for (NetworkSpace.IpAddress ipAddress2 : this.mRoutes.getNetworks(false)) {
                        }
                        this.mHostService.onDiagnosticMessage(sb.toString());
                        NetworkSpace.IpAddress ipAddress3 = new NetworkSpace.IpAddress(new CIDRIP("224.0.0.0", 3), true);
                        for (NetworkSpace.IpAddress ipAddress4 : this.mRoutes.getPositiveIPList()) {
                            try {
                                if (ipAddress3.containsNet(ipAddress4)) {
                                    SkStatus.logDebug("VPN: Ignoring multicast route: " + ipAddress4.toString());
                                } else {
                                    addAddress.addRoute(ipAddress4.getIPv4Address(), ipAddress4.networkMask);
                                }
                            } catch (IllegalArgumentException unused2) {
                            }
                        }
                        if (z5) {
                            this.mHostService.onDiagnosticMessage("<strong>SlowDNS Bypass OK</strong>");
                            addAddress.addDisallowedApplication(this.mHostService.getContext().getPackageName());
                        }
                        if (z2) {
                            for (String str4 : strArr3) {
                                if (z3) {
                                    try {
                                        addAddress.addDisallowedApplication(str4);
                                        this.mHostService.onDiagnosticMessage("Apps Filter: Vpn disabled for \"" + str4 + "\"");
                                    } catch (PackageManager.NameNotFoundException unused3) {
                                        this.mHostService.onDiagnosticMessage("App \"" + str4 + "\" not found. Apps filter will not work, check the settings.");
                                    }
                                } else {
                                    addAddress.addAllowedApplication(str4);
                                    this.mHostService.onDiagnosticMessage("Apps Filter: Vpn enabled for \"" + str4 + "\"");
                                }
                            }
                        }
                        ParcelFileDescriptor establish = addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(SocksHttpService.getGraphPendingIntent(this.mHostService.getContext())).establish();
                        if (establish == null) {
                            Locale.setDefault(locale);
                            return false;
                        }
                        this.mTunFd.set(establish);
                        this.mRoutingThroughTunnel.set(false);
                        this.mHostService.onVpnEstablished();
                        this.mRoutes.clear();
                        Locale.setDefault(locale);
                        return true;
                    } catch (Throwable th) {
                        Locale.setDefault(locale);
                        throw th;
                    }
                } catch (IllegalStateException e) {
                    throw new Exception("startVpn failed", e);
                }
            } catch (SecurityException e2) {
                throw new Exception("startVpn failed", e2);
            }
        } catch (IllegalArgumentException e3) {
            throw new Exception("startVpn failed", e3);
        }
    }

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

    private void stopVpn() {
        stopRoutingThroughTunnel();
        ParcelFileDescriptor andSet = this.mTunFd.getAndSet(null);
        if (andSet != null) {
            try {
                this.mHostService.onDiagnosticMessage("closing VPN interface");
                andSet.close();
            } catch (IOException unused) {
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public synchronized boolean startRouting(TunnelVpnSettings tunnelVpnSettings) throws Exception {
        try {
            try {
                return startVpn(tunnelVpnSettings.mDnsForward, tunnelVpnSettings.mDnsResolver, tunnelVpnSettings.mExcludeIps, tunnelVpnSettings.mEnableFilterApps, tunnelVpnSettings.mFilterBypassMode, tunnelVpnSettings.mFilterApps, tunnelVpnSettings.mTetheringSubnet, tunnelVpnSettings.bypass);
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public synchronized boolean startTunneling(String str, String[] strArr, boolean z, String str2, boolean z2) throws Exception {
        return routeThroughTunnel(str, strArr, z, str2, z2);
    }

    public synchronized void stop() {
        stopVpn();
    }

    public synchronized void stopTunneling() {
        stopRoutingThroughTunnel();
    }
}
