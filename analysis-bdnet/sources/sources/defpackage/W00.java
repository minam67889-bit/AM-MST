package defpackage;

import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes2.dex */
public final class W00 implements InterfaceC0261Jr, InterfaceC3559m00 {
    public final /* synthetic */ VPNClient a;

    public /* synthetic */ W00(VPNClient vPNClient) {
        this.a = vPNClient;
    }

    @Override // defpackage.InterfaceC3559m00
    public void onConsentFormLoadSuccess(InterfaceC0352Nf interfaceC0352Nf) {
        String str = VPNClient.f0;
        VPNClient vPNClient = this.a;
        vPNClient.getClass();
        if (vPNClient.c0.getConsentStatus() == 0) {
            interfaceC0352Nf.show(vPNClient, new C3640n10(this, 0));
        }
        if (vPNClient.c0.getConsentStatus() == 2) {
            interfaceC0352Nf.show(vPNClient, new C3640n10(this, 1));
        }
    }
}
