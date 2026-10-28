package defpackage;

import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerThread;

/* loaded from: classes2.dex */
public final class ST implements TunnelManagerThread.OnStopCliente {
    public final /* synthetic */ SocksDNSService a;

    public ST(SocksDNSService socksDNSService) {
        this.a = socksDNSService;
    }

    @Override // prince.dastan.vpn.service.vpn.TunnelManagerThread.OnStopCliente
    public final void onStop() {
        SocksDNSService socksDNSService = this.a;
        socksDNSService.b.post(new TT(socksDNSService));
    }
}
