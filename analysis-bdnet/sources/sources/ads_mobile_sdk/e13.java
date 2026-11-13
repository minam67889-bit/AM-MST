package ads_mobile_sdk;

import defpackage.AbstractC3634my;
import defpackage.C3991rT;
import defpackage.Mc0;
import defpackage.W50;

/* loaded from: classes.dex */
public final class e13 implements Mc0 {
    public final String a;

    public e13(String str) {
        this.a = str;
    }

    @Override // defpackage.Mc0
    public final void a(C3991rT c3991rT) {
        AbstractC3634my.g(c3991rT, "signals");
        c3991rT.N = this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e13) && AbstractC3634my.a(this.a, ((e13) obj).a);
    }

    public final int hashCode() {
        String str = this.a;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        return W50.D("SignalGenerationResponseKeySignal(encryptionKey=", this.a, ")");
    }
}
