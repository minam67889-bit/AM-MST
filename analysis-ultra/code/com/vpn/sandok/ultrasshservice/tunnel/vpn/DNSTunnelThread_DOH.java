package com.vpn.sandok.ultrasshservice.tunnel.vpn;

import android.content.Context;
import com.vpn.sandok.ultrasshservice.config.Settings;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.util.CustomNativeLoader;
import com.vpn.sandok.ultrasshservice.util.StreamGobbler;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public class DNSTunnelThread_DOH extends Thread {
    private static final String DNS_BIN = "dnsproxy";
    private Process dnsProcess;
    private File filedns;
    private Settings mConfig;
    private Context mContext;

    public DNSTunnelThread_DOH(Context context) {
        this.mContext = context;
        this.mConfig = new Settings(context);
    }

    @Override // java.lang.Thread
    public void interrupt() {
        Process process = this.dnsProcess;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.filedns;
            if (file != null) {
                VpnUtils.killProcess(file);
            }
        } catch (Exception unused) {
        }
        this.dnsProcess = null;
        this.filedns = null;
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            this.mConfig.getPrefsPrivate();
            File loadNativeBinary = CustomNativeLoader.loadNativeBinary(this.mContext, DNS_BIN, new File(this.mContext.getFilesDir(), DNS_BIN));
            this.filedns = loadNativeBinary;
            if (loadNativeBinary != null) {
                SkStatus.logInfo("<b>DoH:</b> Starting dnsproxy<br>URL: https://dns.google/dns-query");
                this.dnsProcess = Runtime.getRuntime().exec(this.filedns.getCanonicalPath() + " --listen-addr=127.0.0.1:5353 --https-server-address=https://dns.google/dns-query --fallback-servers=8.8.8.8:53 --timeout=10s --cache");
                StreamGobbler.OnLineListener onLineListener = new StreamGobbler.OnLineListener() { // from class: com.vpn.sandok.ultrasshservice.tunnel.vpn.DNSTunnelThread_DOH.1
                    @Override // com.vpn.sandok.ultrasshservice.util.StreamGobbler.OnLineListener
                    public void onLine(String str) {
                        SkStatus.logInfo("<b>DoH:</b> " + str);
                    }
                };
                StreamGobbler streamGobbler = new StreamGobbler(this.dnsProcess.getInputStream(), onLineListener);
                StreamGobbler streamGobbler2 = new StreamGobbler(this.dnsProcess.getErrorStream(), onLineListener);
                streamGobbler.start();
                streamGobbler2.start();
                this.dnsProcess.waitFor();
                return;
            }
            throw new IOException("dnsproxy binary not found");
        } catch (IOException | InterruptedException e) {
            SkStatus.logInfo("<b>DoH Error:</b> " + e.getMessage());
        }
    }
}
