package com.vpn.sandok.ultrasshservice.tunnel;

import android.content.Context;
import com.vpn.sandok.ultrasshservice.config.Settings;
import com.vpn.sandok.ultrasshservice.config.SettingsConstants;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.VpnUtils;
import com.vpn.sandok.ultrasshservice.util.CustomNativeLoader;
import com.vpn.sandok.ultrasshservice.util.StreamGobbler;
import com.vpn.sandok.ultrasshservice.util.securepreferences.SecurePreferences;
import java.io.File;
import java.io.IOException;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public class DNSTunnelThread extends Thread {
    private static final String DNS_BIN = "libdns";
    private Process dnsProcess;
    private File filedns;
    private Settings mConfig;
    private Context mContext;

    public DNSTunnelThread(Context context) {
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
            SecurePreferences prefsPrivate = this.mConfig.getPrefsPrivate();
            String privString = this.mConfig.getPrivString(SettingsConstants.DNS_KEY);
            String privString2 = this.mConfig.getPrivString(SettingsConstants.CHAVE_KEY);
            String privString3 = this.mConfig.getPrivString(SettingsConstants.NAMESERVER_KEY);
            String string = prefsPrivate.getString(SettingsConstants.CHAVE_KEY, privString);
            String string2 = prefsPrivate.getString(SettingsConstants.NAMESERVER_KEY, privString2);
            String string3 = prefsPrivate.getString(SettingsConstants.DNS_KEY, privString3);
            StringBuilder sb = new StringBuilder();
            File loadNativeBinary = CustomNativeLoader.loadNativeBinary(this.mContext, DNS_BIN, new File(this.mContext.getFilesDir(), DNS_BIN));
            this.filedns = loadNativeBinary;
            if (loadNativeBinary != null) {
                sb.append(loadNativeBinary.getCanonicalPath());
                sb.append(" -udp " + string3 + ":53   -pubkey " + string + " " + string2 + " 127.0.0.1:2222");
                this.dnsProcess = Runtime.getRuntime().exec(sb.toString());
                StreamGobbler.OnLineListener onLineListener = new StreamGobbler.OnLineListener() { // from class: com.vpn.sandok.ultrasshservice.tunnel.DNSTunnelThread.1
                    @Override // com.vpn.sandok.ultrasshservice.util.StreamGobbler.OnLineListener
                    public void onLine(String str) {
                        SkStatus.logInfo("<b>DNS Client: </b>" + str);
                    }
                };
                StreamGobbler streamGobbler = new StreamGobbler(this.dnsProcess.getInputStream(), onLineListener);
                StreamGobbler streamGobbler2 = new StreamGobbler(this.dnsProcess.getErrorStream(), onLineListener);
                streamGobbler.start();
                streamGobbler2.start();
                this.dnsProcess.waitFor();
                return;
            }
            throw new IOException("DNS bin not found");
        } catch (IOException | InterruptedException unused) {
        }
    }
}
