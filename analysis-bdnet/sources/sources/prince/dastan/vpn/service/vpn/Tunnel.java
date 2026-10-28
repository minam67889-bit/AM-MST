package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.VpnService;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.preference.PreferenceManager;
import com.google.android.gms.common.ConnectionResult;
import defpackage.C0223If;
import defpackage.C4553yb;
import defpackage.RQ;
import defpackage.VH;
import defpackage.WH;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import org.uproxy.tun2socks.Tun2SocksJni;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.Tun2Socks;
import prince.dastan.vpn.service.vpn.VpnUtils;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class Tunnel {
    private static final String DNS_RESOLVER_IP = "8.8.8.8";
    private static final int DNS_RESOLVER_PORT = 53;
    private static final String VPN_INTERFACE_NETMASK = "255.255.255.0";
    private static Tunnel mTunnel;
    private final HostService mHostService;
    private Pdnsd mPdnsd;
    private VpnUtils.PrivateAddress mPrivateAddress;
    private WH mRoutes;
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

    private Tunnel(HostService hostService) {
        this.mHostService = hostService;
        WH wh = new WH();
        wh.a = new TreeSet();
        this.mRoutes = wh;
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
            Locale locale = Locale.ENGLISH;
            String str4 = this.mPrivateAddress.mIpAddress + ":" + findAvailablePort;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.mHostService.getContext());
            defaultSharedPreferences.edit();
            Context context = this.mHostService.getContext();
            String str5 = this.mPrivateAddress.mIpAddress;
            String string = Deobfuscator$BDNETVPN$app.getString(-163311168354187L);
            String string2 = Deobfuscator$BDNETVPN$app.getString(-163358412994443L);
            String string3 = defaultSharedPreferences.getString(RQ.b(string), null);
            String a = RQ.a(string3);
            Pdnsd pdnsd = new Pdnsd(context, strArr, 53, str5, findAvailablePort, (string3 == null || a == null) ? string2 : a);
            this.mPdnsd = pdnsd;
            pdnsd.start();
            str3 = str4;
        } else {
            str3 = null;
        }
        Tun2Socks tun2Socks = new Tun2Socks(this.mHostService.getContext(), parcelFileDescriptor, this.mMtu, this.mPrivateAddress.mRouter, VPN_INTERFACE_NETMASK, str, str2, str3, z2);
        this.mTun2Socks = tun2Socks;
        tun2Socks.setOnTun2SocksListener(new Tun2Socks.OnTun2SocksListener() { // from class: prince.dastan.vpn.service.vpn.Tunnel.1
            @Override // prince.dastan.vpn.service.vpn.Tun2Socks.OnTun2SocksListener
            public void onStart() {
                Tunnel.this.mHostService.onDiagnosticMessage("tun2socks started");
            }

            @Override // prince.dastan.vpn.service.vpn.Tun2Socks.OnTun2SocksListener
            public void onStop() {
                Tunnel.this.mHostService.onDiagnosticMessage("tun2socks stopped");
                Tunnel.this.stop();
            }
        });
        this.mTun2Socks.start();
        this.mHostService.onTunnelConnected();
        return true;
    }

    private void startTun2Socks(final ParcelFileDescriptor parcelFileDescriptor, final int i, final String str, final String str2, final String str3, final String str4, final String str5, final String str6, final boolean z, final boolean z2) {
        if (this.mTun2SocksThread != null) {
            return;
        }
        Thread thread = new Thread(new Runnable() { // from class: prince.dastan.vpn.service.vpn.Tunnel.2
            @Override // java.lang.Runnable
            public void run() {
                Tun2SocksJni.runTun2Socks(parcelFileDescriptor.getFd(), i, str, str2, str3, str4, str5, str6, z ? 1 : 0, z2 ? 1 : 0);
            }
        });
        this.mTun2SocksThread = thread;
        thread.start();
        this.mHostService.onDiagnosticMessage("tun2socks started");
    }

    private boolean startVpn(boolean z, String[] strArr, String[] strArr2, boolean z2, boolean z3, String[] strArr3, boolean z4, boolean z5) {
        int i;
        StringBuilder sb = new StringBuilder("Routes: ");
        this.mPrivateAddress = VpnUtils.selectPrivateAddress();
        int length = strArr2.length;
        int i2 = 0;
        while (true) {
            i = 32;
            if (i2 >= length) {
                break;
            }
            this.mRoutes.a(new C4553yb(strArr2[i2], 32), false);
            i2++;
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
                        this.mRoutes.a(new C4553yb("0.0.0.0", 0), true);
                        this.mRoutes.a(new C4553yb("10.0.0.0", 8), false);
                        WH wh = this.mRoutes;
                        VpnUtils.PrivateAddress privateAddress2 = this.mPrivateAddress;
                        wh.a(new C4553yb(privateAddress2.mSubnet, privateAddress2.mPrefixLength), false);
                        if (z4) {
                            this.mRoutes.a(new C4553yb("192.168.42.0", 23), false);
                            this.mRoutes.a(new C4553yb("192.168.44.0", 24), false);
                            this.mRoutes.a(new C4553yb("192.168.49.0", 24), false);
                        }
                        this.mRoutes.a(new C4553yb("169.254.1.0", 24), false);
                        C0223If c0223If = new C0223If(this.mHostService.getContext());
                        if (!c0223If.p().booleanValue()) {
                            this.mRoutes.a(new C4553yb(c0223If.l(), 32), false);
                        }
                        int length2 = strArr.length;
                        int i3 = 0;
                        while (i3 < length2) {
                            String str = strArr[i3];
                            try {
                                addAddress.addDnsServer(str);
                                try {
                                    this.mRoutes.a(new C4553yb(str, i), z);
                                } catch (IllegalArgumentException e) {
                                    e = e;
                                    this.mHostService.onDiagnosticMessage("Error adding dns " + str + ", " + e.getLocalizedMessage());
                                    i3++;
                                    i = 32;
                                }
                            } catch (IllegalArgumentException e2) {
                                e = e2;
                            }
                            i3++;
                            i = 32;
                        }
                        String str2 = Build.VERSION.RELEASE;
                        addAddress.setMtu(this.mMtu);
                        Iterator it = this.mRoutes.c(true).iterator();
                        while (it.hasNext()) {
                            VH vh = (VH) it.next();
                            sb.append(String.format("%s/%d", vh.c(), Integer.valueOf(vh.b)));
                            sb.append(", ");
                        }
                        sb.deleteCharAt(sb.lastIndexOf(", "));
                        Iterator it2 = this.mRoutes.c(false).iterator();
                        while (it2.hasNext()) {
                        }
                        this.mHostService.onDiagnosticMessage(sb.toString());
                        VH vh2 = new VH(new C4553yb("224.0.0.0", 3), true);
                        Iterator it3 = this.mRoutes.d().iterator();
                        while (it3.hasNext()) {
                            VH vh3 = (VH) it3.next();
                            try {
                                if (vh2.a(vh3)) {
                                    SkStatus.logDebug("VPN: Ignoring multicast route: " + vh3.toString());
                                } else {
                                    addAddress.addRoute(vh3.c(), vh3.b);
                                }
                            } catch (IllegalArgumentException unused) {
                            }
                        }
                        if (!c0223If.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162688398096267L), false)) {
                            for (String str3 : c0223If.a.getString(Deobfuscator$BDNETVPN$app.getString(-161460037449611L), Deobfuscator$BDNETVPN$app.getString(-161515872024459L)).split(";")) {
                                try {
                                    if (!str3.equals("dastan.prince.bdfreevpn")) {
                                        addAddress.addDisallowedApplication(str3);
                                    }
                                } catch (PackageManager.NameNotFoundException unused2) {
                                }
                            }
                        } else if (c0223If.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162817247115147L), false)) {
                            for (String str4 : c0223If.a()) {
                                try {
                                    addAddress.addDisallowedApplication(str4);
                                    SkStatus.logInfo("Disallowed Application: " + str4);
                                } catch (PackageManager.NameNotFoundException unused3) {
                                }
                            }
                        } else {
                            for (String str5 : c0223If.a()) {
                                try {
                                    addAddress.addAllowedApplication(str5);
                                    SkStatus.logInfo("Allowed Application: " + str5);
                                } catch (PackageManager.NameNotFoundException unused4) {
                                }
                            }
                        }
                        ParcelFileDescriptor establish = c0223If.u().booleanValue() ? addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(XRayDNSService.b(this.mHostService.getContext())).establish() : c0223If.q().booleanValue() ? addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(PsiphonDNSService.b(this.mHostService.getContext())).establish() : (c0223If.p().booleanValue() && c0223If.s().booleanValue()) ? addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(FWPuncherService.c(this.mHostService.getContext())).establish() : addAddress.setSession(this.mHostService.getAppName()).setConfigureIntent(SocksDNSService.b(this.mHostService.getContext())).establish();
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
                    } catch (Throwable th) {
                        Locale.setDefault(locale);
                        throw th;
                    }
                } catch (SecurityException e3) {
                    throw new Exception("startVpn failed", e3);
                }
            } catch (IllegalStateException e4) {
                throw new Exception("startVpn failed", e4);
            }
        } catch (IllegalArgumentException e5) {
            throw new Exception("startVpn failed", e5);
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
            this.mHostService.onDiagnosticMessage("tun2socks stopped");
        }
    }

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

    public Object clone() {
        throw new CloneNotSupportedException();
    }

    public synchronized boolean startRouting(TunnelVpnSettings tunnelVpnSettings) {
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

    public synchronized boolean startTunneling(String str, String[] strArr, boolean z, String str2, boolean z2) {
        try {
        } catch (Throwable th) {
            th = th;
            while (true) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return routeThroughTunnel(str, strArr, z, str2, z2);
    }

    public synchronized void stop() {
        stopVpn();
    }

    public synchronized void stopTunneling() {
        stopRoutingThroughTunnel();
    }
}
