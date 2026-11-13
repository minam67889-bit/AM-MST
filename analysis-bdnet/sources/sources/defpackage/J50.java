package defpackage;

import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerThread;

/* loaded from: classes2.dex */
public final class J50 implements TunnelManagerThread.OnStopCliente {
    public final /* synthetic */ XRayDNSService a;

    public J50(XRayDNSService xRayDNSService) {
        this.a = xRayDNSService;
    }

    @Override // prince.dastan.vpn.service.vpn.TunnelManagerThread.OnStopCliente
    public final void onStop() {
        XRayDNSService xRayDNSService = this.a;
        xRayDNSService.b.post(new K50(xRayDNSService));
    }
}
