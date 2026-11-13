package defpackage;

import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class K50 implements Runnable {
    public final /* synthetic */ XRayDNSService a;

    public K50(XRayDNSService xRayDNSService) {
        this.a = xRayDNSService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        XRayDNSService.D = false;
        XRayDNSService xRayDNSService = this.a;
        xRayDNSService.stopForeground(true);
        xRayDNSService.stopSelf();
        SkStatus.removeStateListener(xRayDNSService);
    }
}
