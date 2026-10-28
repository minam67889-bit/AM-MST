package defpackage;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;
import java.util.Arrays;
import java.util.List;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.SplashActivity;
import prince.dastan.vpn.activities.VPNApplication;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: h10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class CountDownTimerC3163h10 extends CountDownTimer {
    public final /* synthetic */ int a;
    public final /* synthetic */ I4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountDownTimerC3163h10(I4 i4, long j, int i) {
        super(j, 1000L);
        this.a = i;
        this.b = i4;
    }

    private final void a(long j) {
    }

    private final void b(long j) {
    }

    private final void c(long j) {
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        switch (this.a) {
            case 0:
                List asList = Arrays.asList(Deobfuscator$BDNETVPN$app.getString(-42373479233419L));
                VPNClient vPNClient = (VPNClient) this.b;
                if (asList.contains(vPNClient.D)) {
                    vPNClient.R();
                    vPNClient.J();
                    if (!vPNClient.d0) {
                        F00.i(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-42467968513931L));
                        vPNClient.d0 = true;
                    }
                }
                vPNClient.C.cancel();
                break;
            case 1:
                VPNClient vPNClient2 = (VPNClient) this.b;
                if (vPNClient2.m.r()) {
                    if (Arrays.asList(Deobfuscator$BDNETVPN$app.getString(-42635472238475L)).contains(vPNClient2.D)) {
                        vPNClient2.R();
                        vPNClient2.J();
                        if (!vPNClient2.d0) {
                            F00.i(vPNClient2.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-42742846420875L));
                            vPNClient2.d0 = true;
                        }
                    }
                } else if (Arrays.asList(Deobfuscator$BDNETVPN$app.getString(-42910350145419L)).contains(vPNClient2.D)) {
                    vPNClient2.R();
                    vPNClient2.J();
                    if (!vPNClient2.d0) {
                        F00.i(vPNClient2.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-42944709883787L));
                        vPNClient2.d0 = true;
                    }
                }
                vPNClient2.C.cancel();
                break;
            default:
                SplashActivity splashActivity = (SplashActivity) this.b;
                C0223If c0223If = splashActivity.b;
                c0223If.getClass();
                if (!c0223If.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-163100714956683L), true)) {
                    Application application = splashActivity.getApplication();
                    if (!(application instanceof VPNApplication)) {
                        splashActivity.startActivity(new Intent(splashActivity, (Class<?>) VPNClient.class));
                        splashActivity.finish();
                        break;
                    } else {
                        ((VPNApplication) application).a.b(splashActivity, new WT(this));
                        break;
                    }
                } else {
                    splashActivity.startActivity(new Intent(splashActivity, (Class<?>) VPNClient.class));
                    splashActivity.finish();
                    break;
                }
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        int i = this.a;
    }
}
