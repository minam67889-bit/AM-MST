package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;

/* renamed from: e5, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C2930e5 extends BroadcastReceiver {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C2930e5(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        switch (this.a) {
            case 0:
                ((AbstractC3010f5) this.b).g();
                break;
            case 1:
                if (intent != null) {
                    ((AbstractC0399Pa) this.b).g(intent);
                    break;
                }
                break;
            case 2:
                String action = intent.getAction();
                if (action != null) {
                    if (!action.equals(FWPuncherService.t)) {
                        if (action.equals(FWPuncherService.u)) {
                            FWPuncherService fWPuncherService = (FWPuncherService) this.b;
                            fWPuncherService.b.post(new RunnableC4572yp(fWPuncherService));
                            break;
                        }
                    } else {
                        new Thread(new RunnableC0334Mn(1)).start();
                        break;
                    }
                }
                break;
            case 3:
                String action2 = intent.getAction();
                if (action2 != null) {
                    if (!action2.equals(PsiphonDNSService.o)) {
                        if (action2.equals(PsiphonDNSService.p)) {
                            PsiphonDNSService psiphonDNSService = (PsiphonDNSService) this.b;
                            psiphonDNSService.b.post(new RunnableC2873dM(psiphonDNSService));
                            break;
                        }
                    } else {
                        new Thread(new RunnableC0334Mn(4)).start();
                        break;
                    }
                }
                break;
            case 4:
                String action3 = intent.getAction();
                if (action3 != null) {
                    if (!action3.equals(SocksDNSService.I)) {
                        if (action3.equals(SocksDNSService.J)) {
                            SocksDNSService socksDNSService = (SocksDNSService) this.b;
                            socksDNSService.b.post(new TT(socksDNSService));
                            break;
                        }
                    } else {
                        new Thread(new RunnableC0334Mn(5)).start();
                        break;
                    }
                }
                break;
            default:
                String action4 = intent.getAction();
                if (action4 != null) {
                    if (!action4.equals(XRayDNSService.G)) {
                        if (action4.equals(XRayDNSService.H)) {
                            XRayDNSService xRayDNSService = (XRayDNSService) this.b;
                            xRayDNSService.b.post(new K50(xRayDNSService));
                            break;
                        }
                    } else {
                        new Thread(new RunnableC0334Mn(7)).start();
                        break;
                    }
                }
                break;
        }
    }
}
