package com.vpn.sandok.ultrasshservice.tunnel.vpn;

import android.content.Context;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.util.CustomNativeLoader;
import com.vpn.sandok.ultrasshservice.util.StreamGobbler;
import defpackage.qf3;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public class Tun2Socks extends Thread implements StreamGobbler.OnLineListener {
    private static final String TAG = "Tun2Socks";
    private static final String TUN2SOCKS_BIN = "libsocks";
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

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    /* loaded from: classes3.dex */
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

    private boolean sendFd(ParcelFileDescriptor parcelFileDescriptor, File file) throws InterruptedException {
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
    public synchronized void interrupt() {
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

    @Override // com.vpn.sandok.ultrasshservice.util.StreamGobbler.OnLineListener
    public void onLine(String str) {
        SkStatus.logDebug("Tun2Socks: " + str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        StringBuilder sb;
        File loadNativeBinary;
        File file;
        OnTun2SocksListener onTun2SocksListener = this.mListener;
        if (onTun2SocksListener != null) {
            onTun2SocksListener.onStart();
        }
        try {
            try {
                sb = new StringBuilder();
                loadNativeBinary = CustomNativeLoader.loadNativeBinary(this.mContext, TUN2SOCKS_BIN, new File(this.mContext.getFilesDir(), TUN2SOCKS_BIN));
                this.fileTun2Socks = loadNativeBinary;
            } catch (IOException e) {
                SkStatus.logException("Tun2Socks Error", e);
            }
        } catch (Exception e2) {
            SkStatus.logDebug("Tun2Socks Error: " + e2.getMessage());
        }
        if (loadNativeBinary != null) {
            if (this.mVpnInterfaceFileDescriptor != null) {
                Context context = this.mContext;
                if (Build.VERSION.SDK_INT >= 24) {
                    file = qf3.j(context);
                } else {
                    String str = context.getApplicationInfo().dataDir;
                    if (str != null) {
                        file = new File(str);
                    } else {
                        file = null;
                    }
                }
                File file2 = new File(file, "sock_path");
                try {
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    sb.append(this.fileTun2Socks.getCanonicalPath());
                    sb.append(" --netif-ipaddr " + this.mVpnIpAddress);
                    sb.append(" --netif-netmask " + this.mVpnNetMask);
                    sb.append(" --socks-server-addr " + this.mSocksServerAddress);
                    sb.append(" --tunmtu " + Integer.toString(this.mVpnInterfaceMTU));
                    sb.append(" --tunfd " + this.mVpnInterfaceFileDescriptor.getFd());
                    sb.append(" --sock " + file2.getAbsolutePath());
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
                    StreamGobbler streamGobbler = new StreamGobbler(exec.getInputStream(), this);
                    StreamGobbler streamGobbler2 = new StreamGobbler(this.tun2SocksProcess.getErrorStream(), this);
                    streamGobbler.start();
                    streamGobbler2.start();
                    if (sendFd(this.mVpnInterfaceFileDescriptor, file2)) {
                        this.tun2SocksProcess.waitFor();
                    } else {
                        throw new IOException("Failed to send Fd to sock, this may not be supported on your device. Contact the developer.");
                    }
                } catch (IOException unused) {
                    throw new IOException("Failed to create file: " + file2.getCanonicalPath());
                }
            }
            this.tun2SocksProcess = null;
            OnTun2SocksListener onTun2SocksListener2 = this.mListener;
            if (onTun2SocksListener2 != null) {
                onTun2SocksListener2.onStop();
                return;
            }
            return;
        }
        throw new IOException("Bin libsocks not found");
    }

    public void setOnTun2SocksListener(OnTun2SocksListener onTun2SocksListener) {
        this.mListener = onTun2SocksListener;
    }
}
