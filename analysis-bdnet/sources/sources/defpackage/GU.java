package defpackage;

import app.vpn.amtunnellite.R;
import java.io.File;
import java.io.PrintWriter;
import java.util.Locale;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class GU implements InterfaceC3581iU {
    public final /* synthetic */ int a;
    public final /* synthetic */ SuperService b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ GU(SuperService superService, int i) {
        this.a = i;
        this.b = superService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC3581iU
    public final void onLine(String str) {
        SuperService superService = this.b;
        int i = 1;
        switch (this.a) {
            case 0:
                if (str.contains(Deobfuscator$AMTUNNELLITE$app.getString(-163538005986977L))) {
                    I70.E(superService.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-163379092197025L));
                    UDPClient uDPClient = SuperService.w;
                    if (uDPClient != null) {
                        uDPClient.E();
                    } else {
                        I70.E(superService.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-163318962654881L));
                    }
                    TunnelManagerHelper.stopSuperDns(superService.getApplicationContext());
                }
                if (str.contains(Deobfuscator$AMTUNNELLITE$app.getString(-163739869449889L)) && !superService.l) {
                    try {
                        superService.e = new File(superService.getApplicationInfo().nativeLibraryDir, Deobfuscator$AMTUNNELLITE$app.getString(-185317785144993L));
                        String format = String.format(Locale.ENGLISH, Deobfuscator$AMTUNNELLITE$app.getString(-185614137888417L), Integer.valueOf(SuperService.t), Integer.valueOf(SuperService.u), Deobfuscator$AMTUNNELLITE$app.getString(-190480335834785L), Deobfuscator$AMTUNNELLITE$app.getString(-190368666685089L), Deobfuscator$AMTUNNELLITE$app.getString(-190407321390753L), Deobfuscator$AMTUNNELLITE$app.getString(-190317127077537L));
                        File file = new File(superService.getFilesDir().getPath(), Deobfuscator$AMTUNNELLITE$app.getString(-190287062306465L));
                        superService.o = file;
                        try {
                            PrintWriter printWriter = new PrintWriter(file);
                            printWriter.println(format);
                            printWriter.flush();
                            printWriter.close();
                            superService.d = new ProcessBuilder(new String[0]).command(new File(superService.e.getCanonicalPath()).getAbsolutePath(), Deobfuscator$AMTUNNELLITE$app.getString(-190244112633505L), Deobfuscator$AMTUNNELLITE$app.getString(-190226932764321L), superService.o.getAbsolutePath()).redirectErrorStream(true).start();
                            SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-190222637797025L), superService.getString(R.string.state_connecting));
                            SkStatus.logInfo(R.string.state_connecting, new Object[0]);
                            SuperService.w.i(Deobfuscator$AMTUNNELLITE$app.getString(-190716559036065L));
                            GU gu = new GU(superService, i);
                            C3371fl c3371fl = new C3371fl(superService.d.getInputStream(), gu);
                            C3371fl c3371fl2 = new C3371fl(superService.d.getErrorStream(), gu);
                            c3371fl.start();
                            c3371fl2.start();
                        } catch (Exception unused) {
                        }
                    } catch (Exception e) {
                        SkStatus.logInfo(String.format(Deobfuscator$AMTUNNELLITE$app.getString(-190497515703969L), Deobfuscator$AMTUNNELLITE$app.getString(-190630659690145L), e.getMessage()));
                    }
                    superService.l = true;
                }
                if (str.contains(Deobfuscator$AMTUNNELLITE$app.getString(-163679739907745L)) && superService.m && !superService.n) {
                    SkStatus.updateStateString(Deobfuscator$AMTUNNELLITE$app.getString(-163615315398305L), Deobfuscator$AMTUNNELLITE$app.getString(-164053402062497L));
                    SuperService.w.i(Deobfuscator$AMTUNNELLITE$app.getString(-163980387618465L));
                    superService.n = true;
                    break;
                }
                break;
            default:
                if (str.contains(Deobfuscator$AMTUNNELLITE$app.getString(-164006157422241L)) && !superService.m) {
                    try {
                        int i2 = SuperService.t;
                        superService.e();
                    } catch (Exception unused2) {
                        UDPClient uDPClient2 = SuperService.w;
                        if (uDPClient2 != null) {
                            uDPClient2.E();
                        } else {
                            I70.F(superService.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-163946027880097L));
                        }
                        TunnelManagerHelper.stopSuperDns(superService.getApplicationContext());
                        I70.E(superService.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-164366934675105L));
                    }
                    superService.m = true;
                }
                if (str.contains(Deobfuscator$AMTUNNELLITE$app.getString(-164186546048673L))) {
                    UDPClient uDPClient3 = SuperService.w;
                    if (uDPClient3 != null) {
                        uDPClient3.E();
                    } else {
                        I70.F(superService.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-164117826571937L));
                    }
                    TunnelManagerHelper.stopSuperDns(superService.getApplicationContext());
                    I70.E(superService.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-164538733366945L));
                    break;
                }
                break;
        }
    }
}
