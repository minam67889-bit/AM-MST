package prince.udp.vpn.service.vpn;

import android.content.Context;
import app.vpn.amtunnellite.R;
import com.liapp.y;
import defpackage.C3371fl;
import defpackage.InterfaceC3581iU;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public class Pdnsd extends Thread {
    private static final String PDNSD_BIN = "libpdnsd";
    private static final String PDNSD_SERVER = "server {\n label= \"%1$s\";\n ip = %2$s;\n port = %3$d;\n uptest = none;\n }\n";
    private static final String PDNSD_SERVER_TEST = "server {\n label= \"%1$s\";\n ip = %2$s;\n port = %3$d;\n reject = ::/0;\n reject_policy = negate;\n reject_recursively = on;\n timeout = 5;\n }\n";
    private static final String TAG = "PdnsdThread";
    private File filePdnsd;
    private Context mContext;
    private String[] mDnsHosts;
    private int mDnsPort;
    private String mPdnsdHost;
    private int mPdnsdPort;
    private Process mProcess;

    public interface OnPdnsdListener {
        void onStart();

        void onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Pdnsd(Context context, String[] strArr, int i, String str, int i2) {
        this.mContext = context;
        this.mDnsHosts = strArr;
        this.mDnsPort = i;
        this.mPdnsdHost = str;
        this.mPdnsdPort = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private File makePdnsdConf(File file, String[] strArr, int i, String str, int i2) {
        String readFromRaw = readFromRaw(this.mContext, R.raw.pdnsd_local);
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < strArr.length) {
            String str2 = strArr[i3];
            Locale locale = Locale.ENGLISH;
            StringBuilder sb2 = new StringBuilder(y.ܴ٭׮ڱܭ(-366444316));
            i3++;
            sb2.append(Integer.toString(i3));
            sb.append(String.format(locale, y.׬ܮ֮ڱܭ(1520020448), sb2.toString(), str2, Integer.valueOf(i)));
        }
        String format = String.format(Locale.ENGLISH, readFromRaw, sb.toString(), file.getCanonicalPath(), str, Integer.valueOf(i2));
        File file2 = new File(file, "pdnsd.conf");
        if (file2.exists()) {
            file2.delete();
        }
        saveTextFile(file2, format);
        File file3 = new File(file, "pdnsd.cache");
        if (!file3.exists()) {
            try {
                file3.createNewFile();
            } catch (Exception unused) {
            }
        }
        return file2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String readFromRaw(Context context, int i) {
        Scanner useDelimiter = new Scanner(context.getResources().openRawResource(i), y.ش۳ֲ׬٨(1672227906)).useDelimiter("\\A");
        StringBuilder sb = new StringBuilder();
        while (useDelimiter.hasNext()) {
            sb.append(useDelimiter.next());
        }
        useDelimiter.close();
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean saveTextFile(File file, String str) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(str);
            fileWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread
    public synchronized void interrupt() {
        super.interrupt();
        Process process = this.mProcess;
        if (process != null) {
            process.destroy();
        }
        try {
            File file = this.filePdnsd;
            if (file != null) {
                VpnUtils.killProcess(file);
            }
        } catch (Exception unused) {
        }
        this.mProcess = null;
        this.filePdnsd = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.mProcess != null) {
            return;
        }
        try {
            this.filePdnsd = new File(this.mContext.getApplicationInfo().nativeLibraryDir, "libpdnsd.so");
            this.mProcess = Runtime.getRuntime().exec(this.filePdnsd.getCanonicalPath() + " -v9 -c " + makePdnsdConf(this.mContext.getFilesDir(), this.mDnsHosts, this.mDnsPort, this.mPdnsdHost, this.mPdnsdPort).toString());
            InterfaceC3581iU interfaceC3581iU = new InterfaceC3581iU() { // from class: prince.udp.vpn.service.vpn.Pdnsd.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // defpackage.InterfaceC3581iU
                public void onLine(String str) {
                    SkStatus.logDebug(y.׬ܮ֮ڱܭ(1520020088) + str);
                }
            };
            C3371fl c3371fl = new C3371fl(this.mProcess.getInputStream(), interfaceC3581iU);
            C3371fl c3371fl2 = new C3371fl(this.mProcess.getErrorStream(), interfaceC3581iU);
            c3371fl.start();
            c3371fl2.start();
            this.mProcess.waitFor();
        } catch (IOException e) {
            SkStatus.logException(y.۳׭خ۲ݮ(1787138615), e);
        } catch (Exception e2) {
            SkStatus.logDebug(y.ܴ٭׮ڱܭ(-366440860) + e2);
        }
    }
}
