package prince.udp.vpn.service.vpn;

import android.content.Context;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.ParcelFileDescriptor;
import com.liapp.y;
import defpackage.C3371fl;
import defpackage.InterfaceC3581iU;
import java.io.File;
import java.io.FileDescriptor;
import java.io.IOException;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class Tun2Socks extends Thread implements InterfaceC3581iU {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean sendFd(ParcelFileDescriptor parcelFileDescriptor, File file) {
        SkStatus.logDebug(y.ܴ٭׮ڱܭ(-366441084));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC3581iU
    public void onLine(String str) {
        SkStatus.logDebug(y.ڮڴجۭݩ(1256569541) + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setOnTun2SocksListener(OnTun2SocksListener onTun2SocksListener) {
        this.mListener = onTun2SocksListener;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        String str = y.گ֮۬۲ݮ(2086478379);
        String str2 = y.ڮڴجۭݩ(1256570261);
        String str3 = y.ش۳ֲ׬٨(1672265570);
        String str4 = y.۳׭خ۲ݮ(1787139511);
        String str5 = y.گ֮۬۲ݮ(2086479019);
        String str6 = y.ڮڴجۭݩ(1256570781);
        String str7 = y.ش۳ֲ׬٨(1672265050);
        String str8 = y.ش۳ֲ׬٨(1672264954);
        String str9 = y.ش۳ֲ׬٨(1672264770);
        String str10 = y.ش۳ֲ׬٨(1672258474);
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
                        sb.append(str10 + this.mVpnIpAddress);
                        sb.append(str9 + this.mVpnNetMask);
                        sb.append(str8 + this.mSocksServerAddress);
                        sb.append(str7 + Integer.toString(this.mVpnInterfaceMTU));
                        sb.append(str6 + this.mVpnInterfaceFileDescriptor.getFd());
                        sb.append(str5 + file.getAbsolutePath());
                        sb.append(str4 + Integer.toString(3));
                        if (this.mUdpgwServerAddress != null) {
                            if (this.mUdpgwTransparentDNS) {
                                sb.append(" --udpgw-transparent-dns");
                            }
                            sb.append(str3 + this.mUdpgwServerAddress);
                        }
                        if (this.mDnsResolverAddress != null) {
                            sb.append(str2 + this.mDnsResolverAddress);
                        }
                        Process exec = Runtime.getRuntime().exec(sb.toString());
                        this.tun2SocksProcess = exec;
                        C3371fl c3371fl = new C3371fl(exec.getInputStream(), this);
                        C3371fl c3371fl2 = new C3371fl(this.tun2SocksProcess.getErrorStream(), this);
                        c3371fl.start();
                        c3371fl2.start();
                        if (sendFd(this.mVpnInterfaceFileDescriptor, file)) {
                            this.tun2SocksProcess.waitFor();
                        } else {
                            throw new IOException("Failed to send Fd to sock, this may not be supported on your device. Please contact the developer.");
                        }
                    } catch (IOException unused) {
                        throw new IOException(str + file.getCanonicalPath());
                    }
                }
            } catch (Exception e) {
                SkStatus.logDebug(y.ܴٳݴܯޫ(-170324551) + e.getMessage());
            }
        } catch (IOException e2) {
            SkStatus.logException(y.ܴٳݴܯޫ(-170324959), e2);
        }
        this.tun2SocksProcess = null;
        OnTun2SocksListener onTun2SocksListener2 = this.mListener;
        if (onTun2SocksListener2 != null) {
            onTun2SocksListener2.onStop();
        }
    }
}
