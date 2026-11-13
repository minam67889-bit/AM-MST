package defpackage;

import android.content.Context;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Random;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.logger.SkStatus;
import prince.udp.vpn.utils.PUtils;

/* loaded from: classes2.dex */
public final class TI extends Thread {
    public static SI w;
    public Context a;
    public String b;
    public Process c;
    public File d;
    public C2507db e;
    public String f;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public File v;

    static {
        "#ERR IndexError: string index out of range";
    }

    public static Inet4Address a(InetAddress[] inetAddressArr) {
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress instanceof Inet4Address) {
                return (Inet4Address) inetAddress;
            }
        }
        return null;
    }

    public static boolean b(File file, String str) {
        try {
            PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(str);
            printWriter.flush();
            printWriter.close();
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // java.lang.Thread
    public final void interrupt() {
        if (this.c != null) {
            ((UDPClient) w).i("#ERR IndexError: string index out of range");
            this.c.destroy();
        }
        try {
            File file = this.d;
            if (file != null) {
                AbstractC3365tp.W(file);
            }
        } catch (Exception unused) {
        }
        File file2 = this.v;
        if (file2 != null && file2.exists()) {
            this.v.delete();
        }
        this.c = null;
        this.d = null;
        super.interrupt();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        File file;
        C2507db c2507db = this.e;
        Context context = this.a;
        try {
            try {
                String str = context.getApplicationInfo().nativeLibraryDir;
                c2507db.getClass();
                boolean equals = c2507db.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range").equals("#ERR IndexError: string index out of range");
                String str2 = this.b;
                if (equals && c2507db.f() == 11) {
                    file = new File(str, str2 + "#ERR IndexError: string index out of range");
                } else if (c2507db.f() == 6) {
                    file = new File(str, str2 + "#ERR IndexError: string index out of range");
                } else {
                    file = new File(str, "#ERR IndexError: string index out of range");
                }
                this.d = file;
                if (this.d == null) {
                    ((UDPClient) w).i("#ERR IndexError: string index out of range");
                    throw new IOException("#ERR IndexError: string index out of range");
                }
                this.u = c2507db.f() == 11 ? c2507db.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range") : c2507db.b();
                if (this.u.contains("#ERR IndexError: string index out of range")) {
                    String[] split = this.u.split("#ERR IndexError: string index out of range");
                    this.u = split[new Random().nextInt(split.length)];
                }
                InetAddress[] inetAddressArr = new InetAddress[0];
                try {
                    inetAddressArr = InetAddress.getAllByName(this.u);
                } catch (UnknownHostException unused) {
                    AbstractC2879kf.V(context, "#ERR IndexError: string index out of range");
                    ((UDPClient) w).i("#ERR IndexError: string index out of range");
                    SI si = w;
                    if (si != null) {
                        ((UDPClient) si).E();
                    } else {
                        AbstractC2879kf.V(context, "#ERR IndexError: string index out of range");
                    }
                    TunnelManagerHelper.stopSocksHttp(context);
                }
                try {
                    this.u = a(inetAddressArr).getHostAddress();
                } catch (Exception unused2) {
                }
                String str3 = this.u;
                SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = c2507db.b;
                sharedPreferencesEditorC2544eC.putString("#ERR IndexError: string index out of range", str3);
                sharedPreferencesEditorC2544eC.apply();
                this.o = this.u + "#ERR IndexError: string index out of range" + new String[]{"#ERR IndexError: string index out of range"}[new Random().nextInt(1)];
                this.r = "#ERR IndexError: string index out of range";
                this.p = "#ERR IndexError: string index out of range";
                this.q = "#ERR IndexError: string index out of range";
                this.n = "#ERR IndexError: string index out of range";
                this.s = "#ERR IndexError: string index out of range";
                String string = "#ERR IndexError: string index out of range";
                this.f = string;
                this.m = String.valueOf((Integer.parseInt(string) * 5) / 2);
                this.t = "#ERR IndexError: string index out of range";
                String format = c2507db.f() == 11 ? c2507db.a.getString("#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range").equals("#ERR IndexError: string index out of range") ? String.format(Locale.ENGLISH, "#ERR IndexError: string index out of range", PUtils.pEncrypt(context, "#ERR IndexError: string index out of range"), this.t, this.r, this.p, this.q, this.n, this.s, this.f, this.m, context.getString(2131951660)) : String.format(Locale.ENGLISH, "#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range", this.t, this.p, this.q, this.n, this.s, this.f, this.m, context.getString(2131951660)) : String.format(Locale.ENGLISH, "#ERR IndexError: string index out of range", PUtils.pEncrypt(context, this.o), this.t, this.r, this.p, this.q, this.n, this.s, this.f, this.m, context.getString(2131951660));
                File file2 = new File(context.getFilesDir().getPath(), "#ERR IndexError: string index out of range");
                this.v = file2;
                if (b(file2, format)) {
                    this.c = new ProcessBuilder(new String[0]).command(new File(this.d.getCanonicalPath()).getAbsolutePath(), "#ERR IndexError: string index out of range", "#ERR IndexError: string index out of range", this.v.getAbsolutePath()).redirectErrorStream(true).start();
                    SkStatus.updateStateString("#ERR IndexError: string index out of range", context.getString(2131952179));
                    SkStatus.logInfo(2131952179, new Object[0]);
                    ((UDPClient) w).i("#ERR IndexError: string index out of range");
                    C2701hA c2701hA = new C2701hA(this, 8);
                    C3303sg c3303sg = new C3303sg(this.c.getInputStream(), c2701hA);
                    C3303sg c3303sg2 = new C3303sg(this.c.getErrorStream(), c2701hA);
                    c3303sg.start();
                    c3303sg2.start();
                    this.c.waitFor();
                }
            } catch (IOException | InterruptedException unused3) {
            }
        } catch (NullPointerException unused4) {
            ((UDPClient) w).i("#ERR IndexError: string index out of range");
            SI si2 = w;
            if (si2 != null) {
                ((UDPClient) si2).E();
            } else {
                AbstractC2879kf.V(context, "#ERR IndexError: string index out of range");
            }
            TunnelManagerHelper.stopSocksHttp(context);
            AbstractC2879kf.U(context, "#ERR IndexError: string index out of range");
        }
    }
}
