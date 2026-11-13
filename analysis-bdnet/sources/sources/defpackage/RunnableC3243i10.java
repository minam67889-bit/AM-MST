package defpackage;

import android.net.TrafficStats;
import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: i10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC3243i10 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNClient b;

    public /* synthetic */ RunnableC3243i10(VPNClient vPNClient, int i) {
        this.a = i;
        this.b = vPNClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0232  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0250  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        boolean z;
        long j;
        long j2;
        long j3;
        int i = 1;
        switch (this.a) {
            case 0:
                VPNClient vPNClient = this.b;
                if (vPNClient.m.t().booleanValue()) {
                    if (SocksDNSService.F) {
                        return;
                    }
                    vPNClient.P();
                    return;
                } else if (vPNClient.m.r()) {
                    if (XRayDNSService.D) {
                        return;
                    }
                    vPNClient.P();
                    return;
                } else {
                    if (FWPuncherService.o) {
                        return;
                    }
                    vPNClient.P();
                    return;
                }
            case 1:
                VPNClient vPNClient2 = this.b;
                if (vPNClient2.m.t().booleanValue()) {
                    if (SocksDNSService.F) {
                        return;
                    }
                    vPNClient2.Q();
                    return;
                } else {
                    if (FWPuncherService.o) {
                        return;
                    }
                    vPNClient2.Q();
                    return;
                }
            case 2:
                String str = VPNClient.f0;
                VPNClient vPNClient3 = this.b;
                vPNClient3.u(true);
                vPNClient3.S();
                vPNClient3.l.setTextColor(-65536);
                vPNClient3.O(vPNClient3.getString(R.string.disconnected));
                vPNClient3.R();
                CountDownTimer countDownTimer = vPNClient3.C;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                    return;
                }
                return;
            case 3:
                VPNClient vPNClient4 = this.b;
                CountDownTimer countDownTimer2 = vPNClient4.C;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                }
                if (vPNClient4.m.t().booleanValue()) {
                    vPNClient4.S();
                    new Handler().postDelayed(new RunnableC3243i10(vPNClient4, i), 2000L);
                    return;
                }
                if (vPNClient4.b != null && FWPuncherService.o) {
                    FWPuncherService.o = false;
                }
                vPNClient4.S();
                new Handler().postDelayed(new RunnableC3243i10(vPNClient4, i), 2000L);
                return;
            case 4:
                if (this.b.m.q().booleanValue()) {
                    this.b.i.setText(this.b.getString(R.string.duration_three) + PsiphonDNSService.c());
                } else if (this.b.m.t().booleanValue()) {
                    this.b.i.setText(this.b.getString(R.string.duration_three) + SocksDNSService.c());
                } else if (!this.b.m.p().booleanValue()) {
                    this.b.i.setText(this.b.getString(R.string.duration_three) + XRayDNSService.d());
                } else if (this.b.m.s().booleanValue()) {
                    this.b.i.setText(this.b.getString(R.string.duration_three) + FWPuncherService.d());
                }
                if (!this.b.m.p().booleanValue() || this.b.m.s().booleanValue()) {
                    C0886cV x = C2882dV.y().x();
                    synchronized (x) {
                        z = x.a;
                    }
                    if (z) {
                        C0886cV x2 = C2882dV.y().x();
                        synchronized (x2) {
                            long totalRxBytes = TrafficStats.getTotalRxBytes();
                            j = totalRxBytes - x2.c;
                            x2.c = totalRxBytes;
                        }
                        C0223If c0223If = this.b.m;
                        c0223If.getClass();
                        long j4 = c0223If.a.getLong(Deobfuscator$BDNETVPN$app.getString(-160171547260811L), 0L) + j;
                        QQ qq = c0223If.b;
                        qq.putLong(Deobfuscator$BDNETVPN$app.getString(-160137187522443L), j4);
                        qq.apply();
                        C0886cV x3 = C2882dV.y().x();
                        synchronized (x3) {
                            long totalTxBytes = TrafficStats.getTotalTxBytes();
                            j2 = totalTxBytes - x3.b;
                            x3.b = totalTxBytes;
                        }
                        C0223If c0223If2 = this.b.m;
                        c0223If2.getClass();
                        long j5 = c0223If2.a.getLong(Deobfuscator$BDNETVPN$app.getString(-160244561704843L), 0L) + j2;
                        QQ qq2 = c0223If2.b;
                        qq2.putLong(Deobfuscator$BDNETVPN$app.getString(-160205906999179L), j5);
                        qq2.apply();
                        VPNClient vPNClient5 = this.b;
                        TextView textView = vPNClient5.e;
                        C0223If c0223If3 = vPNClient5.m;
                        c0223If3.getClass();
                        textView.setText(VPNClient.q(c0223If3.a.getLong(Deobfuscator$BDNETVPN$app.getString(-160171547260811L), 0L)));
                        VPNClient vPNClient6 = this.b;
                        TextView textView2 = vPNClient6.f;
                        C0223If c0223If4 = vPNClient6.m;
                        c0223If4.getClass();
                        textView2.setText(VPNClient.q(c0223If4.a.getLong(Deobfuscator$BDNETVPN$app.getString(-160244561704843L), 0L)));
                        return;
                    }
                    return;
                }
                return;
            default:
                VPNClient vPNClient7 = this.b;
                String lastState = SkStatus.getLastState();
                boolean isTunnelActive = SkStatus.isTunnelActive();
                if (Deobfuscator$BDNETVPN$app.getString(-69165485225867L).equals(lastState)) {
                    vPNClient7.O(vPNClient7.getString(R.string.connecting));
                    vPNClient7.l.setTextColor(-65536);
                } else if (Deobfuscator$BDNETVPN$app.getString(-69204139931531L).equals(lastState)) {
                    vPNClient7.O(vPNClient7.getString(R.string.state_stopping));
                    vPNClient7.l.setTextColor(-65536);
                }
                if (SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-69242794637195L))) {
                    int localizedState = SkStatus.getLocalizedState(Deobfuscator$BDNETVPN$app.getString(-69285744310155L));
                    vPNClient7.l.setVisibility(0);
                    if (!vPNClient7.getString(localizedState).contains(Deobfuscator$BDNETVPN$app.getString(-56430907193227L))) {
                        vPNClient7.l.setText(localizedState);
                    }
                    if (localizedState == R.string.auth_failed) {
                        vPNClient7.l.setTextColor(-65536);
                        vPNClient7.l.setText(vPNClient7.getString(R.string.invalid));
                    } else if (localizedState == R.string.disconnected || localizedState == R.string.auth_failed) {
                        vPNClient7.l.setTextColor(-65536);
                        vPNClient7.l.setText(vPNClient7.getString(R.string.disconnected));
                    } else if (localizedState == R.string.connected) {
                        vPNClient7.l.setText(vPNClient7.getString(R.string.connected));
                        vPNClient7.l.setTextColor(-16711936);
                    }
                    vPNClient7.l.setTextColor(-65536);
                } else {
                    if (!SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-69341578885003L))) {
                        if (SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-69427478230923L))) {
                            vPNClient7.y.setProgressWithAnimation(30.0f);
                            vPNClient7.y.setColor(-65536);
                            vPNClient7.d.a();
                            vPNClient7.l.setText(vPNClient7.getString(R.string.connecting));
                            vPNClient7.l.setTextColor(-65536);
                            if (!vPNClient7.m.p().booleanValue() || !vPNClient7.m.s().booleanValue()) {
                                j3 = -160137187522443L;
                                if (vPNClient7.m.t().booleanValue()) {
                                    if (Integer.parseInt(vPNClient7.m.k()) >= 10) {
                                        vPNClient7.T(Integer.parseInt(vPNClient7.m.k()) * 1000);
                                    } else {
                                        vPNClient7.T(10000L);
                                    }
                                } else if (vPNClient7.m.r()) {
                                    if (Integer.parseInt(vPNClient7.m.k()) >= 10) {
                                        vPNClient7.T(Integer.parseInt(vPNClient7.m.k()) * 1000);
                                    } else {
                                        vPNClient7.T(10000L);
                                    }
                                }
                            } else if (Integer.parseInt(vPNClient7.m.k()) >= 3) {
                                vPNClient7.C = new CountDownTimerC3163h10(vPNClient7, Integer.parseInt(vPNClient7.m.k()) * 1000, 0).start();
                            } else {
                                vPNClient7.C = new CountDownTimerC3163h10(vPNClient7, 3000L, 0).start();
                            }
                        } else {
                            j3 = -160137187522443L;
                            vPNClient7.l.setText(SkStatus.getLocalizedState(SkStatus.getLastState()));
                            vPNClient7.l.setTextColor(-65536);
                            vPNClient7.y.setColor(-65536);
                            vPNClient7.d.b();
                        }
                        if (!vPNClient7.m.q().booleanValue()) {
                            vPNClient7.i.setText(vPNClient7.getString(R.string.duration_three) + PsiphonDNSService.c());
                        } else if (vPNClient7.m.t().booleanValue()) {
                            vPNClient7.i.setText(vPNClient7.getString(R.string.duration_three) + SocksDNSService.c());
                        } else if (!vPNClient7.m.p().booleanValue()) {
                            vPNClient7.i.setText(vPNClient7.getString(R.string.duration_three) + XRayDNSService.d());
                        } else if (vPNClient7.m.s().booleanValue()) {
                            vPNClient7.i.setText(vPNClient7.getString(R.string.duration_three) + FWPuncherService.d());
                        }
                        vPNClient7.u(!isTunnelActive);
                        QQ qq3 = vPNClient7.m.b;
                        qq3.putLong(Deobfuscator$BDNETVPN$app.getString(j3), 0L);
                        qq3.apply();
                        QQ qq4 = vPNClient7.m.b;
                        qq4.putLong(Deobfuscator$BDNETVPN$app.getString(-160205906999179L), 0L);
                        qq4.apply();
                        return;
                    }
                    vPNClient7.y.setProgressWithAnimation(100.0f);
                    vPNClient7.y.setColor(-16711936);
                    vPNClient7.d.a();
                    vPNClient7.l.setText(vPNClient7.getString(R.string.connected));
                    vPNClient7.l.setTextColor(-16711936);
                    vPNClient7.D = Deobfuscator$BDNETVPN$app.getString(-69384528557963L);
                }
                j3 = -160137187522443L;
                if (!vPNClient7.m.q().booleanValue()) {
                }
                vPNClient7.u(!isTunnelActive);
                QQ qq32 = vPNClient7.m.b;
                qq32.putLong(Deobfuscator$BDNETVPN$app.getString(j3), 0L);
                qq32.apply();
                QQ qq42 = vPNClient7.m.b;
                qq42.putLong(Deobfuscator$BDNETVPN$app.getString(-160205906999179L), 0L);
                qq42.apply();
                return;
        }
    }
}
