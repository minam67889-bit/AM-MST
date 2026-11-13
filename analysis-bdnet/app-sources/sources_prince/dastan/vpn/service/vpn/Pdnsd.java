package prince.dastan.vpn.service.vpn;

import android.content.Context;
import dastan.prince.bdfreevpn.R;
import defpackage.C3462kl;
import defpackage.InterfaceC3281iV;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

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
    private String mQueryMethod;

    public interface OnPdnsdListener {
        void onStart();

        void onStop();
    }

    public Pdnsd(Context context, String[] strArr, int i, String str, int i2, String str2) {
        this.mContext = context;
        this.mDnsHosts = strArr;
        this.mDnsPort = i;
        this.mPdnsdHost = str;
        this.mPdnsdPort = i2;
        this.mQueryMethod = str2;
    }

    private File makePdnsdConf(File file, String[] strArr, int i, String str, int i2, String str2) {
        String readFromRaw = readFromRaw(this.mContext, R.raw.pdnsd_local);
        StringBuilder sb = new StringBuilder();
        int i3 = 0;
        while (i3 < strArr.length) {
            String str3 = strArr[i3];
            Locale locale = Locale.ENGLISH;
            StringBuilder sb2 = new StringBuilder("server");
            i3++;
            sb2.append(Integer.toString(i3));
            sb.append(String.format(locale, PDNSD_SERVER, sb2.toString(), str3, Integer.valueOf(i)));
        }
        String format = String.format(Locale.ENGLISH, readFromRaw, sb.toString(), file.getCanonicalPath(), str, Integer.valueOf(i2), str2);
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

    public static String readFromRaw(Context context, int i) {
        Scanner useDelimiter = new Scanner(context.getResources().openRawResource(i), "UTF-8").useDelimiter("\\A");
        StringBuilder sb = new StringBuilder();
        while (useDelimiter.hasNext()) {
            sb.append(useDelimiter.next());
        }
        useDelimiter.close();
        return sb.toString();
    }

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

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        if (this.mProcess != null) {
            return;
        }
        try {
            this.filePdnsd = new File(this.mContext.getApplicationInfo().nativeLibraryDir, "libpdnsd.so");
        } catch (IOException e) {
            e = e;
        } catch (Exception e2) {
            e = e2;
        }
        try {
            this.mProcess = Runtime.getRuntime().exec(this.filePdnsd.getCanonicalPath() + " -v9 -c " + makePdnsdConf(this.mContext.getFilesDir(), this.mDnsHosts, this.mDnsPort, this.mPdnsdHost, this.mPdnsdPort, this.mQueryMethod).toString());
            InterfaceC3281iV interfaceC3281iV = new InterfaceC3281iV() { // from class: prince.dastan.vpn.service.vpn.Pdnsd.1
                @Override // defpackage.InterfaceC3281iV
                public void onLine(String str) {
                    SkStatus.logDebug("Pdnsd: " + str);
                }
            };
            C3462kl c3462kl = new C3462kl(this.mProcess.getInputStream(), interfaceC3281iV);
            C3462kl c3462kl2 = new C3462kl(this.mProcess.getErrorStream(), interfaceC3281iV);
            c3462kl.start();
            c3462kl2.start();
            this.mProcess.waitFor();
        } catch (IOException e3) {
            e = e3;
            SkStatus.logException("Pdnsd Error", e);
        } catch (Exception e4) {
            e = e4;
            SkStatus.logDebug("Pdnsd Error: " + e);
        }
    }
}
