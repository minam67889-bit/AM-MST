package defpackage;

import ads_mobile_sdk.ee;
import ads_mobile_sdk.j;
import ads_mobile_sdk.oq;
import ads_mobile_sdk.xs0;

/* renamed from: r70, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3967r70 extends xs0 {
    public final void d(oq oqVar) {
        InterfaceC2858d80 interfaceC2858d80;
        InterfaceC2858d80 interfaceC2858d802;
        b();
        ee eeVar = (ee) this.b;
        eeVar.getClass();
        oqVar.getClass();
        interfaceC2858d80 = eeVar.encryptedBlobs_;
        if (!((j) interfaceC2858d80).a) {
            eeVar.encryptedBlobs_ = AbstractC4589z20.g(interfaceC2858d80);
        }
        interfaceC2858d802 = eeVar.encryptedBlobs_;
        interfaceC2858d802.add(oqVar);
    }
}
