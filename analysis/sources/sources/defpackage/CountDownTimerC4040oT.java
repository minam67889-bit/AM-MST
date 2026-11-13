package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.SplashActivity;
import prince.udp.vpn.activities.UDPApplication;
import prince.udp.vpn.activities.UDPClient;

/* renamed from: oT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class CountDownTimerC4040oT extends CountDownTimer {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ AbstractActivityC4701x4 b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CountDownTimerC4040oT(SplashActivity splashActivity, long j) {
        super(j, 1000L);
        this.b = splashActivity;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(long j) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.CountDownTimer
    public final void onFinish() {
        switch (this.a) {
            case 0:
                Activity activity = (SplashActivity) this.b;
                Application application = activity.getApplication();
                if (!(application instanceof UDPApplication)) {
                    activity.startActivity(new Intent(activity, (Class<?>) UDPClient.class));
                    activity.finish();
                    break;
                } else {
                    ((UDPApplication) application).a.b(activity, new VP(this, 6));
                    break;
                }
            default:
                List asList = Arrays.asList(Deobfuscator$AMTUNNELLITE$app.getString(-151112665599649L));
                UDPClient uDPClient = this.b;
                if (asList.contains(uDPClient.u)) {
                    uDPClient.F();
                    uDPClient.getClass();
                    new Handler().postDelayed(new GY(uDPClient, 0), 2000L);
                    if (!uDPClient.Q) {
                        new Handler(Looper.getMainLooper()).post(new RunnableC3234e00(uDPClient.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-151009586384545L), 1));
                        uDPClient.Q = true;
                    }
                }
                uDPClient.t.cancel();
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
        switch (this.a) {
            case 0:
                break;
            default:
                String str = UDPClient.U;
                this.b.getClass();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CountDownTimerC4040oT(UDPClient uDPClient) {
        super(10000L, 1000L);
        this.b = uDPClient;
    }
}
