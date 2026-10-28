package defpackage;

import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* renamed from: aT, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class RunnableC0732aT implements Runnable {
    public final /* synthetic */ SocksDNSService a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC0732aT(SocksDNSService socksDNSService) {
        this.a = socksDNSService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        SocksDNSService.n = false;
        SocksDNSService socksDNSService = this.a;
        socksDNSService.stopForeground(true);
        socksDNSService.stopSelf();
        SkStatus.removeStateListener(socksDNSService);
    }
}
