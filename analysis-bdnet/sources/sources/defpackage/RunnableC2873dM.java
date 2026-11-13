package defpackage;

import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: dM, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC2873dM implements Runnable {
    public final /* synthetic */ PsiphonDNSService a;

    public RunnableC2873dM(PsiphonDNSService psiphonDNSService) {
        this.a = psiphonDNSService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PsiphonDNSService psiphonDNSService = this.a;
        psiphonDNSService.stopForeground(true);
        psiphonDNSService.stopSelf();
        SkStatus.removeStateListener(psiphonDNSService);
    }
}
