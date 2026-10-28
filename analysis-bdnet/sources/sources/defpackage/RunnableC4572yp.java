package defpackage;

import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: yp, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC4572yp implements Runnable {
    public final /* synthetic */ FWPuncherService a;

    public RunnableC4572yp(FWPuncherService fWPuncherService) {
        this.a = fWPuncherService;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FWPuncherService fWPuncherService = this.a;
        fWPuncherService.i();
        fWPuncherService.stopForeground(true);
        fWPuncherService.stopSelf();
        SkStatus.removeStateListener(fWPuncherService);
    }
}
