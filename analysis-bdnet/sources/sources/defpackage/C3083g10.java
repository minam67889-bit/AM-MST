package defpackage;

import prince.dastan.vpn.activities.VPNClient;

/* renamed from: g10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3083g10 implements P1 {
    public final /* synthetic */ VPNClient a;

    public /* synthetic */ C3083g10(VPNClient vPNClient) {
        this.a = vPNClient;
    }

    @Override // defpackage.P1
    public void onAdFailedToLoad(SC sc) {
        AbstractC3634my.g(sc, "adError");
        VPNClient vPNClient = this.a;
        vPNClient.z = null;
        vPNClient.E = false;
    }

    @Override // defpackage.P1
    public void onAdLoaded(Object obj) {
        InterfaceC3475ky interfaceC3475ky = (InterfaceC3475ky) obj;
        VPNClient vPNClient = this.a;
        vPNClient.z = interfaceC3475ky;
        if (vPNClient.I && !vPNClient.E && vPNClient.H) {
            interfaceC3475ky.show(vPNClient);
            vPNClient.E = true;
            vPNClient.H = false;
        }
        interfaceC3475ky.setAdEventCallback(new C3321j10(this));
    }
}
