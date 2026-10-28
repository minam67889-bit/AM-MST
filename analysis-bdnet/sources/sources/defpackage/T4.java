package defpackage;

import ads_mobile_sdk.ra3;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.PDRService;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.SuperService;

/* loaded from: classes.dex */
public final class T4 extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T4() {
        this.a = 6;
        this.b = ra3.d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        boolean z;
        boolean z2;
        switch (this.a) {
            case 0:
                ((U4) this.b).m();
                break;
            case 1:
                if (intent != null) {
                    ((AbstractC4816ya) this.b).g(intent);
                    break;
                }
                break;
            case 2:
                String action = intent.getAction();
                if (action != null) {
                    if (action.equals(DNSLiteService.t)) {
                        new Thread(new RunnableC0103Di(0)).start();
                        break;
                    } else if (action.equals(DNSLiteService.u)) {
                        DNSLiteService dNSLiteService = (DNSLiteService) this.b;
                        dNSLiteService.b.post(new RunnableC0025Ai(dNSLiteService, 0));
                        break;
                    }
                }
                break;
            case 3:
                String action2 = intent.getAction();
                if (action2 != null) {
                    if (action2.equals(PDRService.s)) {
                        new Thread(new RunnableC0103Di(3)).start();
                        break;
                    } else if (action2.equals(PDRService.t)) {
                        PDRService pDRService = (PDRService) this.b;
                        pDRService.b.post(new AI(pDRService, 0));
                        break;
                    }
                }
                break;
            case 4:
                String action3 = intent.getAction();
                if (action3 != null) {
                    if (action3.equals(SocksDNSService.p)) {
                        new Thread(new RunnableC0103Di(4)).start();
                        break;
                    } else if (action3.equals(SocksDNSService.q)) {
                        SocksDNSService socksDNSService = (SocksDNSService) this.b;
                        socksDNSService.b.post(new RunnableC0732aT(socksDNSService));
                        break;
                    }
                }
                break;
            case 5:
                String action4 = intent.getAction();
                if (action4 != null) {
                    if (action4.equals(SuperService.y)) {
                        new Thread(new RunnableC0103Di(5)).start();
                        break;
                    } else if (action4.equals(SuperService.z)) {
                        SuperService superService = (SuperService) this.b;
                        superService.b.post(new FU(superService, 0));
                        break;
                    }
                }
                break;
            default:
                boolean equals = intent.getAction().equals("android.intent.action.SCREEN_OFF");
                ra3 ra3Var = (ra3) this.b;
                if (equals) {
                    z = ra3Var.c;
                    z2 = true;
                } else if (intent.getAction().equals("android.intent.action.SCREEN_ON")) {
                    z = ra3Var.c;
                    z2 = false;
                }
                ra3Var.a(z2, z);
                ra3Var.b = z2;
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ T4(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }
}
