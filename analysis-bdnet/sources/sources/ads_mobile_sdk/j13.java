package ads_mobile_sdk;

import defpackage.AbstractC3634my;
import defpackage.Ee0;
import defpackage.F20;
import defpackage.InterfaceC4129t90;

/* loaded from: classes.dex */
public final class j13 implements InterfaceC4129t90 {
    public final Ee0 a;
    public final Ee0 b;

    public j13(g13 g13Var, Ee0 ee0) {
        this.a = g13Var;
        this.b = ee0;
    }

    @Override // defpackage.InterfaceC3613me0, defpackage.Ub0
    public final Object get() {
        f13 f13Var = (f13) this.a.get();
        hq0 hq0Var = (hq0) this.b.get();
        AbstractC3634my.g(f13Var, "signalGenerationResponseKeySignalSource");
        AbstractC3634my.g(hq0Var, "flags");
        l13 l13Var = l13.a;
        q03 q03Var = q03.b;
        p23 p23Var = p23.a;
        return new w02(f13Var, l13Var, q03Var, F20.c(hq0Var, vu0.AD_RESPONSE_ENCRYPTION_KEY));
    }
}
