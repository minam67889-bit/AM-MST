package defpackage;

import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.vpn.TunnelManagerThread;

/* loaded from: classes2.dex */
public final class ZS implements TunnelManagerThread.OnStopCliente {
    public final /* synthetic */ SocksDNSService a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ZS(SocksDNSService socksDNSService) {
        this.a = socksDNSService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // prince.udp.vpn.service.vpn.TunnelManagerThread.OnStopCliente
    public final void onStop() {
        SocksDNSService socksDNSService = this.a;
        socksDNSService.b.post(new RunnableC0732aT(socksDNSService));
    }
}
