package ads_mobile_sdk;

import defpackage.AbstractC3634my;
import defpackage.AbstractC3913qT;
import defpackage.InterfaceC0198Hg;
import defpackage.Sc0;
import defpackage.Sf0;
import java.util.List;

/* loaded from: classes.dex */
public final class f13 implements Sc0 {
    public final g30 a;
    public final AbstractC3913qT b;
    public final List c;
    public final boolean d;
    public final List e;

    public f13(hq0 hq0Var, g30 g30Var, AbstractC3913qT abstractC3913qT) {
        AbstractC3634my.g(hq0Var, "flags");
        AbstractC3634my.g(g30Var, "cryptoUtil");
        AbstractC3634my.g(abstractC3913qT, "signalRequest");
        this.a = g30Var;
        this.b = abstractC3913qT;
        this.c = hq0Var.O();
        this.d = hq0Var.o0();
        this.e = hq0Var.J();
    }

    @Override // defpackage.Sc0
    public final vu0 a() {
        return vu0.AD_RESPONSE_ENCRYPTION_KEY;
    }

    @Override // defpackage.Sc0
    public final Object d(InterfaceC0198Hg interfaceC0198Hg) {
        if (!(this.d ? this.e : this.c).contains(String.valueOf(this.b.k.getNumber()))) {
            return new vt0(new e13(null));
        }
        Sf0 b = this.a.b();
        if (b instanceof pt0) {
            return (pt0) b;
        }
        AbstractC3634my.e(b, "null cannot be cast to non-null type com.google.android.libraries.ads.mobile.sdk.internal.util.GmaResult.Success<T of com.google.android.libraries.ads.mobile.sdk.internal.util.GmaResult.Companion.returnIfError>");
        return new vt0(new e13((String) ((vt0) b).b));
    }
}
