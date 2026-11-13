package defpackage;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.SplashActivity;
import prince.udp.vpn.activities.UDPApplication;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final class EE extends CountDownTimer {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ AbstractActivityC0513c2 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EE(SplashActivity splashActivity, long j) {
        super(j, 1000L);
        this.b = splashActivity;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EE(UDPClient uDPClient) {
        super(10000L, 1000L);
        this.b = uDPClient;
    }

    private final void a(long j) {
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        AbstractActivityC0513c2 abstractActivityC0513c2 = this.b;
        switch (this.a) {
            case 0:
                SplashActivity splashActivity = (SplashActivity) abstractActivityC0513c2;
                Application application = splashActivity.getApplication();
                if (!(application instanceof UDPApplication)) {
                    splashActivity.startActivity(new Intent(splashActivity, (Class<?>) UDPClient.class));
                    splashActivity.finish();
                    return;
                } else {
                    C2701hA c2701hA = new C2701hA(this, 2);
                    C3501wI c3501wI = ((UDPApplication) application).a;
                    int i = C3501wI.e;
                    c3501wI.b(splashActivity, c2701hA);
                    return;
                }
            default:
                UDPClient uDPClient = (UDPClient) abstractActivityC0513c2;
                if (Arrays.asList("Running").contains(uDPClient.B)) {
                    uDPClient.F();
                    uDPClient.getClass();
                    new Handler().postDelayed(new NI(uDPClient, 0), 2000L);
                    if (!uDPClient.X) {
                        new Handler(Looper.getMainLooper()).post(new EJ(uDPClient.getApplicationContext(), "Auto Reconnect Enabled! Please wait...", 1));
                        uDPClient.X = true;
                    }
                }
                uDPClient.A.cancel();
                return;
        }
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        switch (this.a) {
            case 0:
                return;
            default:
                String str = UDPClient.Z;
                ((UDPClient) this.b).getClass();
                return;
        }
    }
}
