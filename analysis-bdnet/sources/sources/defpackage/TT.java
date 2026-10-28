package defpackage;

import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class TT implements Runnable {
    public final /* synthetic */ SocksDNSService a;

    public TT(SocksDNSService socksDNSService) {
        this.a = socksDNSService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SocksDNSService.F = false;
        SocksDNSService socksDNSService = this.a;
        socksDNSService.stopForeground(true);
        socksDNSService.stopSelf();
        SkStatus.removeStateListener(socksDNSService);
    }
}
