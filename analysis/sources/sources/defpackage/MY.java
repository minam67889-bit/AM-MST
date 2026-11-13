package defpackage;

import android.content.Context;
import app.vpn.amtunnellite.R;
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
public final class MY extends Thread {
    public static LY q;
    public Context a;
    public String b;
    public Process c;
    public File d;
    public C4363sf e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public String n;
    public String o;
    public File p;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        Deobfuscator$AMTUNNELLITE$app.getString(-184707899788961L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Inet4Address a(InetAddress[] inetAddressArr) {
        for (InetAddress inetAddress : inetAddressArr) {
            if (inetAddress instanceof Inet4Address) {
                return (Inet4Address) inetAddress;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread
    public final void interrupt() {
        if (this.c != null) {
            q.i(Deobfuscator$AMTUNNELLITE$app.getString(-184231158419105L));
            this.c.destroy();
        }
        try {
            File file = this.d;
            if (file != null) {
                AbstractC4817ya0.P(file);
            }
        } catch (Exception unused) {
        }
        File file2 = this.p;
        if (file2 != null && file2.exists()) {
            this.p.delete();
        }
        this.c = null;
        this.d = null;
        super.interrupt();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        File file;
        String format;
        C4363sf c4363sf = this.e;
        Context context = this.a;
        try {
            try {
                String str = context.getApplicationInfo().nativeLibraryDir;
                c4363sf.getClass();
                boolean equals = c4363sf.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-206337355091617L), Deobfuscator$AMTUNNELLITE$app.getString(-206285815484065L)).equals(Deobfuscator$AMTUNNELLITE$app.getString(-180181004258977L));
                String str2 = this.b;
                if (equals && c4363sf.f() == 11) {
                    file = new File(str, str2 + Deobfuscator$AMTUNNELLITE$app.getString(-180159529422497L));
                } else if (c4363sf.f() == 6) {
                    file = new File(str, str2 + Deobfuscator$AMTUNNELLITE$app.getString(-180073630076577L));
                } else {
                    file = new File(str, Deobfuscator$AMTUNNELLITE$app.getString(-180056450207393L));
                }
                this.d = file;
                if (this.d == null) {
                    q.i(Deobfuscator$AMTUNNELLITE$app.getString(-180086514978465L));
                    throw new IOException(Deobfuscator$AMTUNNELLITE$app.getString(-180576141250209L));
                }
                this.o = c4363sf.f() == 11 ? c4363sf.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-202368805310113L), Deobfuscator$AMTUNNELLITE$app.getString(-202806891974305L)) : c4363sf.b();
                if (this.o.contains(Deobfuscator$AMTUNNELLITE$app.getString(-180498831838881L))) {
                    String[] split = this.o.split(Deobfuscator$AMTUNNELLITE$app.getString(-180421522427553L));
                    this.o = split[new Random().nextInt(split.length)];
                }
                InetAddress[] inetAddressArr = new InetAddress[0];
                try {
                    inetAddressArr = InetAddress.getAllByName(this.o);
                } catch (UnknownHostException unused) {
                    I70.F(context, Deobfuscator$AMTUNNELLITE$app.getString(-180412932492961L));
                    q.i(Deobfuscator$AMTUNNELLITE$app.getString(-180335623081633L));
                    UDPClient uDPClient = q;
                    if (uDPClient != null) {
                        uDPClient.E();
                    } else {
                        I70.F(context, Deobfuscator$AMTUNNELLITE$app.getString(-180820954386081L));
                    }
                    TunnelManagerHelper.stopSocksHttp(context);
                }
                try {
                    this.o = a(inetAddressArr).getHostAddress();
                } catch (Exception unused2) {
                }
                String str3 = this.o;
                WP wp = c4363sf.b;
                wp.putString(Deobfuscator$AMTUNNELLITE$app.getString(-205585735814817L), str3);
                wp.apply();
                this.i = this.o + Deobfuscator$AMTUNNELLITE$app.getString(-180722170138273L) + new String[]{Deobfuscator$AMTUNNELLITE$app.getString(-180692105367201L)}[new Random().nextInt(1)];
                this.l = Deobfuscator$AMTUNNELLITE$app.getString(-180713580203681L);
                this.j = Deobfuscator$AMTUNNELLITE$app.getString(-180704990269089L);
                this.k = Deobfuscator$AMTUNNELLITE$app.getString(-180627680857761L);
                this.h = Deobfuscator$AMTUNNELLITE$app.getString(-180619090923169L);
                this.m = Deobfuscator$AMTUNNELLITE$app.getString(-180597616086689L);
                String string = Deobfuscator$AMTUNNELLITE$app.getString(-181078652423841L);
                this.f = string;
                this.g = String.valueOf((Integer.parseInt(string) * 5) / 2);
                this.n = Deobfuscator$AMTUNNELLITE$app.getString(-181125897064097L);
                if (c4363sf.f() == 11) {
                    format = c4363sf.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-206337355091617L), Deobfuscator$AMTUNNELLITE$app.getString(-206285815484065L)).equals(Deobfuscator$AMTUNNELLITE$app.getString(-181117307129505L)) ? String.format(Locale.ENGLISH, Deobfuscator$AMTUNNELLITE$app.getString(-181027112816289L), PUtils.pEncrypt(context, Deobfuscator$AMTUNNELLITE$app.getString(-181722897518241L)), this.n, this.l, this.j, this.k, this.h, this.m, this.f, this.g, context.getString(R.string.f105app)) : String.format(Locale.ENGLISH, Deobfuscator$AMTUNNELLITE$app.getString(-181735782420129L), Deobfuscator$AMTUNNELLITE$app.getString(-183054337380001L), this.n, this.j, this.k, this.h, this.m, this.f, this.g, context.getString(R.string.f105app));
                } else {
                    format = String.format(Locale.ENGLISH, Deobfuscator$AMTUNNELLITE$app.getString(-182998502805153L), PUtils.pEncrypt(context, this.i), this.n, this.l, this.j, this.k, this.h, this.m, this.f, this.g, context.getString(R.string.f105app));
                }
                File file2 = new File(context.getFilesDir().getPath(), Deobfuscator$AMTUNNELLITE$app.getString(-183625568030369L));
                this.p = file2;
                if (b(file2, format)) {
                    this.c = new ProcessBuilder(new String[0]).command(new File(this.d.getCanonicalPath()).getAbsolutePath(), Deobfuscator$AMTUNNELLITE$app.getString(-184123784236705L), Deobfuscator$AMTUNNELLITE$app.getString(-184153849007777L), this.p.getAbsolutePath()).redirectErrorStream(true).start();
                    SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-184055064759969L), context.getString(R.string.state_connecting));
                    SkStatus.logInfo(R.string.state_connecting, new Object[0]);
                    q.i(Deobfuscator$AMTUNNELLITE$app.getString(-184067949661857L));
                    VP vp = new VP(this, 15);
                    C3371fl c3371fl = new C3371fl(this.c.getInputStream(), vp);
                    C3371fl c3371fl2 = new C3371fl(this.c.getErrorStream(), vp);
                    c3371fl.start();
                    c3371fl2.start();
                    this.c.waitFor();
                }
            } catch (NullPointerException unused3) {
                q.i(Deobfuscator$AMTUNNELLITE$app.getString(-183900445937313L));
                UDPClient uDPClient2 = q;
                if (uDPClient2 != null) {
                    uDPClient2.E();
                } else {
                    I70.F(context, Deobfuscator$AMTUNNELLITE$app.getString(-184385777241761L));
                }
                TunnelManagerHelper.stopSocksHttp(context);
                I70.E(context, Deobfuscator$AMTUNNELLITE$app.getString(-184256928222881L));
            }
        } catch (IOException | InterruptedException unused4) {
        }
    }
}
