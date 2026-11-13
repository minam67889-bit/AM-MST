package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.ParcelFileDescriptor;
import defpackage.C3462kl;
import defpackage.InterfaceC3281iV;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class Tun2Socks extends Thread implements InterfaceC3281iV {
    private static final String TAG = "Tun2Socks";
    private static final String TUN2SOCKS_BIN = "libtun2socks";
    private File fileTun2Socks;
    private Context mContext;
    private String mDnsResolverAddress;
    private OnTun2SocksListener mListener;
    private String mSocksServerAddress;
    private String mUdpgwServerAddress;
    private boolean mUdpgwTransparentDNS;
    private ParcelFileDescriptor mVpnInterfaceFileDescriptor;
    private int mVpnInterfaceMTU;
    private String mVpnIpAddress;
    private String mVpnNetMask;
    private Process tun2SocksProcess;

    public interface OnTun2SocksListener {
        void onStart();

        void onStop();
    }

    public Tun2Socks(Context context, ParcelFileDescriptor parcelFileDescriptor, int i, String str, String str2, String str3, String str4, String str5, boolean z) {
        this.mContext = context;
        this.mVpnInterfaceFileDescriptor = parcelFileDescriptor;
        this.mVpnInterfaceMTU = i;
        this.mVpnIpAddress = str;
        this.mVpnNetMask = str2;
        this.mSocksServerAddress = str3;
        this.mUdpgwServerAddress = str4;
        this.mDnsResolverAddress = str5;
        this.mUdpgwTransparentDNS = z;
    }

    private boolean sendFd(ParcelFileDescriptor parcelFileDescriptor, File file) {
        SkStatus.logDebug("Sending Fd to sock");
        for (int i = 10; i >= 0; i--) {
            try {
                LocalSocket localSocket = new LocalSocket();
                localSocket.connect(new LocalSocketAddress(file.getAbsolutePath(), LocalSocketAddress.Namespace.FILESYSTEM));
                localSocket.setFileDescriptorsForSend(new FileDescriptor[]{parcelFileDescriptor.getFileDescriptor()});
                localSocket.getOutputStream().write(42);
                localSocket.shutdownOutput();
                localSocket.close();
                return true;
            } catch (IOException unused) {
                Thread.sleep(500L);
            }
        }
        return false;
    }

    @Override // java.lang.Thread
    public void interrupt() {
        super.interrupt();
        Process process = this.tun2SocksProcess;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.fileTun2Socks;
            if (file != null) {
                VpnUtils.killProcess(file);
            }
        } catch (Exception unused) {
        }
        this.tun2SocksProcess = null;
        this.fileTun2Socks = null;
    }

    @Override // defpackage.InterfaceC3281iV
    public void onLine(String str) {
        SkStatus.logDebug("Tun2Socks: " + str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        OnTun2SocksListener onTun2SocksListener = this.mListener;
        if (onTun2SocksListener != null) {
            onTun2SocksListener.onStart();
        }
        try {
            try {
                StringBuilder sb = new StringBuilder();
                this.fileTun2Socks = new File(this.mContext.getApplicationInfo().nativeLibraryDir, "libtun2socks.so");
                if (this.mVpnInterfaceFileDescriptor != null) {
                    File file = new File(this.mContext.getDataDir(), "sock_path");
                    try {
                        if (!file.exists()) {
                            file.createNewFile();
                        }
                        sb.append(this.fileTun2Socks.getCanonicalPath());
                        sb.append(" --netif-ipaddr " + this.mVpnIpAddress);
                        sb.append(" --netif-netmask " + this.mVpnNetMask);
                        sb.append(" --socks-server-addr " + this.mSocksServerAddress);
                        sb.append(" --tunmtu " + Integer.toString(this.mVpnInterfaceMTU));
                        sb.append(" --tunfd " + this.mVpnInterfaceFileDescriptor.getFd());
                        sb.append(" --sock " + file.getAbsolutePath());
                        sb.append(" --loglevel " + Integer.toString(3));
                        if (this.mUdpgwServerAddress != null) {
                            if (this.mUdpgwTransparentDNS) {
                                sb.append(" --udpgw-transparent-dns");
                            }
                            sb.append(" --udpgw-remote-server-addr " + this.mUdpgwServerAddress);
                        }
                        if (this.mDnsResolverAddress != null) {
                            sb.append(" --dnsgw " + this.mDnsResolverAddress);
                        }
                        Process exec = Runtime.getRuntime().exec(sb.toString());
                        this.tun2SocksProcess = exec;
                        C3462kl c3462kl = new C3462kl(exec.getInputStream(), this);
                        C3462kl c3462kl2 = new C3462kl(this.tun2SocksProcess.getErrorStream(), this);
                        c3462kl.start();
                        c3462kl2.start();
                        if (!sendFd(this.mVpnInterfaceFileDescriptor, file)) {
                            throw new IOException("Failed to send Fd to sock, this may not be supported on your device. Please contact the developer.");
                        }
                        this.tun2SocksProcess.waitFor();
                    } catch (IOException unused) {
                        throw new IOException("Failed to create file: " + file.getCanonicalPath());
                    }
                }
            } catch (IOException e) {
                SkStatus.logException("Tun2Socks Error", e);
            }
        } catch (Exception e2) {
            SkStatus.logDebug("Tun2Socks Error: " + e2.getMessage());
        }
        this.tun2SocksProcess = null;
        OnTun2SocksListener onTun2SocksListener2 = this.mListener;
        if (onTun2SocksListener2 != null) {
            onTun2SocksListener2.onStop();
        }
    }

    public void setOnTun2SocksListener(OnTun2SocksListener onTun2SocksListener) {
        this.mListener = onTun2SocksListener;
    }
}
