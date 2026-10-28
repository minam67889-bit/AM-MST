package defpackage;

import android.os.CountDownTimer;
import android.os.Handler;
import android.widget.TextView;
import app.vpn.amtunnellite.R;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.PDRService;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.WGService;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class GY implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ UDPClient b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ GY(UDPClient uDPClient, int i) {
        this.a = i;
        this.b = uDPClient;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x016c  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        TextView textView;
        StringBuilder sb;
        String c;
        TextView textView2;
        long j;
        TextView textView3;
        long j2;
        TextView textView4;
        StringBuilder sb2;
        String c2;
        TextView textView5;
        String string;
        int i = 1;
        UDPClient uDPClient = this.b;
        switch (this.a) {
            case 0:
                if (uDPClient.i.f() != 12) {
                    if (SocksDNSService.n) {
                    }
                } else if (DNSLiteService.o) {
                }
                uDPClient.B();
                break;
            case 1:
                if (!SocksDNSService.n) {
                    uDPClient.C();
                    break;
                }
                break;
            case 2:
                String str = UDPClient.U;
                uDPClient.k(true);
                uDPClient.G();
                uDPClient.H();
                break;
            case 3:
                if (uDPClient.i.f() == 6 || uDPClient.i.f() == 11) {
                    textView = uDPClient.f;
                    sb = new StringBuilder();
                    sb.append(Deobfuscator$AMTUNNELLITE$app.getString(-151778385530529L));
                    c = SocksDNSService.c();
                } else if (uDPClient.i.f() == 12) {
                    textView = uDPClient.f;
                    sb = new StringBuilder();
                    sb.append(Deobfuscator$AMTUNNELLITE$app.getString(-152220767162017L));
                    c = DNSLiteService.c();
                } else if (uDPClient.i.f() == 13) {
                    textView = uDPClient.f;
                    sb = new StringBuilder();
                    sb.append(Deobfuscator$AMTUNNELLITE$app.getString(-152164932587169L));
                    c = SuperService.b();
                } else if (uDPClient.i.f() == 14) {
                    textView = uDPClient.f;
                    sb = new StringBuilder();
                    sb.append(Deobfuscator$AMTUNNELLITE$app.getString(-152194997358241L));
                    c = PDRService.b();
                } else {
                    textView = uDPClient.f;
                    sb = new StringBuilder();
                    sb.append(Deobfuscator$AMTUNNELLITE$app.getString(-152139162783393L));
                    c = WGService.c();
                }
                sb.append(c);
                textView.setText(sb.toString());
                break;
            case 4:
                uDPClient.getClass();
                String lastState = SkStatus.getLastState();
                boolean isTunnelActive = SkStatus.isTunnelActive();
                if (Deobfuscator$AMTUNNELLITE$app.getString(-148488440581793L).equals(lastState)) {
                    uDPClient.z(uDPClient.getString(R.string.connecting));
                    uDPClient.h.setTextColor(-65536);
                    uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                    textView2 = uDPClient.S;
                    j = -148939412147873L;
                } else if (Deobfuscator$AMTUNNELLITE$app.getString(-148797678227105L).equals(lastState)) {
                    uDPClient.z(uDPClient.getString(R.string.state_stopping));
                    uDPClient.h.setTextColor(-65536);
                    uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                    textView2 = uDPClient.S;
                    j = -148836332932769L;
                } else {
                    if (Deobfuscator$AMTUNNELLITE$app.getString(-149244354825889L).equals(lastState) && uDPClient.i.f() == 10) {
                        uDPClient.z(uDPClient.getString(R.string.state_disconnected));
                        uDPClient.h.setTextColor(-65536);
                        uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                        textView2 = uDPClient.S;
                        j = -149128390708897L;
                    }
                    if (SkStatus.getLastState().equals(Deobfuscator$AMTUNNELLITE$app.getString(-148986656788129L))) {
                        if (SkStatus.getLastState().equals(Deobfuscator$AMTUNNELLITE$app.getString(-149373203844769L))) {
                            uDPClient.h.setText(uDPClient.getString(R.string.connected));
                            uDPClient.h.setTextColor(-16711936);
                            uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_connected);
                            uDPClient.S.setText(Deobfuscator$AMTUNNELLITE$app.getString(-149261534695073L));
                            uDPClient.u = Deobfuscator$AMTUNNELLITE$app.getString(-167291807403681L);
                        } else if (SkStatus.getLastState().equals(Deobfuscator$AMTUNNELLITE$app.getString(-167317577207457L))) {
                            uDPClient.h.setText(uDPClient.getString(R.string.connecting));
                            uDPClient.h.setTextColor(-65536);
                            uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                            uDPClient.S.setText(Deobfuscator$AMTUNNELLITE$app.getString(-167210203025057L));
                            if (uDPClient.i.f() != 14) {
                                uDPClient.t = new CountDownTimerC4040oT(uDPClient).start();
                            }
                        } else {
                            uDPClient.h.setText(SkStatus.getLocalizedState(SkStatus.getLastState()));
                            uDPClient.h.setTextColor(-65536);
                            uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                            textView3 = uDPClient.S;
                            j2 = -167618224918177L;
                        }
                        if (uDPClient.i.f() != 6 || uDPClient.i.f() == 11) {
                            textView4 = uDPClient.f;
                            sb2 = new StringBuilder();
                            sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167493670866593L));
                            c2 = SocksDNSService.c();
                        } else if (uDPClient.i.f() == 12) {
                            textView4 = uDPClient.f;
                            sb2 = new StringBuilder();
                            sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167506555768481L));
                            c2 = DNSLiteService.c();
                        } else if (uDPClient.i.f() == 13) {
                            textView4 = uDPClient.f;
                            sb2 = new StringBuilder();
                            sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167467901062817L));
                            c2 = SuperService.b();
                        } else if (uDPClient.i.f() == 14) {
                            textView4 = uDPClient.f;
                            sb2 = new StringBuilder();
                            sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167893102825121L));
                            c2 = PDRService.b();
                        } else {
                            textView4 = uDPClient.f;
                            sb2 = new StringBuilder();
                            sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167923167596193L));
                            c2 = WGService.c();
                        }
                        sb2.append(c2);
                        textView4.setText(sb2.toString());
                        uDPClient.k(!isTunnelActive);
                        break;
                    } else {
                        int localizedState = SkStatus.getLocalizedState(Deobfuscator$AMTUNNELLITE$app.getString(-149493462929057L));
                        uDPClient.h.setVisibility(0);
                        if (!uDPClient.getString(localizedState).contains(Deobfuscator$AMTUNNELLITE$app.getString(-143536343289505L))) {
                            uDPClient.h.setText(localizedState);
                        }
                        if (localizedState == R.string.auth_failed) {
                            uDPClient.h.setTextColor(-65536);
                            textView5 = uDPClient.h;
                            string = uDPClient.getString(R.string.invalid);
                        } else if (localizedState == R.string.disconnected || localizedState == R.string.auth_failed) {
                            uDPClient.h.setTextColor(-65536);
                            textView5 = uDPClient.h;
                            string = uDPClient.getString(R.string.disconnected);
                        } else {
                            if (localizedState == R.string.connected) {
                                uDPClient.h.setText(uDPClient.getString(R.string.connected));
                                uDPClient.h.setTextColor(-16711936);
                            }
                            uDPClient.h.setTextColor(-65536);
                            uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                            textView3 = uDPClient.S;
                            j2 = -149514937765537L;
                        }
                        textView5.setText(string);
                        uDPClient.h.setTextColor(-65536);
                        uDPClient.R.setBackgroundResource(R.drawable.bg_status_dot_disconnected);
                        textView3 = uDPClient.S;
                        j2 = -149514937765537L;
                    }
                    textView3.setText(Deobfuscator$AMTUNNELLITE$app.getString(j2));
                    if (uDPClient.i.f() != 6) {
                    }
                    textView4 = uDPClient.f;
                    sb2 = new StringBuilder();
                    sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167493670866593L));
                    c2 = SocksDNSService.c();
                    sb2.append(c2);
                    textView4.setText(sb2.toString());
                    uDPClient.k(!isTunnelActive);
                }
                textView2.setText(Deobfuscator$AMTUNNELLITE$app.getString(j));
                if (SkStatus.getLastState().equals(Deobfuscator$AMTUNNELLITE$app.getString(-148986656788129L))) {
                }
                textView3.setText(Deobfuscator$AMTUNNELLITE$app.getString(j2));
                if (uDPClient.i.f() != 6) {
                }
                textView4 = uDPClient.f;
                sb2 = new StringBuilder();
                sb2.append(Deobfuscator$AMTUNNELLITE$app.getString(-167493670866593L));
                c2 = SocksDNSService.c();
                sb2.append(c2);
                textView4.setText(sb2.toString());
                uDPClient.k(!isTunnelActive);
                break;
            default:
                CountDownTimer countDownTimer = uDPClient.t;
                if (countDownTimer != null) {
                    countDownTimer.cancel();
                }
                uDPClient.G();
                uDPClient.getClass();
                new Handler().postDelayed(new GY(uDPClient, i), 2000L);
                break;
        }
    }
}
