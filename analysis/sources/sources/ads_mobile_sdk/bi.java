package ads_mobile_sdk;

import ads_mobile_sdk.vz0;
import defpackage.Hc0;
import defpackage.InterfaceC4054od0;
import defpackage.R40;
import java.util.Objects;

/* loaded from: classes.dex */
public final class bi extends vz0 {
    private static final bi DEFAULT_INSTANCE;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    private int bitField0_;
    private InterfaceC4054od0 encryptedBlobs_ = bw2.e();
    private du hash_ = du.b;
    private int protoName_ = 1;
    private int encryptionMethod_ = 1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        bi biVar = new bi();
        DEFAULT_INSTANCE = biVar;
        vz0.a((Class<bi>) bi.class, biVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(du duVar) {
        Objects.requireNonNull(duVar);
        this.bitField0_ |= 1;
        this.hash_ = duVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static R40 v() {
        return (R40) DEFAULT_INSTANCE.h();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // ads_mobile_sdk.vz0
    public final Object a(vz0.d dVar, vz0 vz0Var) {
        int i = Hc0.a[dVar.ordinal()];
        if (i == 1) {
            return new bi();
        }
        if (i == 2) {
            return new R40(DEFAULT_INSTANCE);
        }
        if (i == 3) {
            return new i13(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"bitField0_", "encryptedBlobs_", "hash_", "protoName_", sw.a$3, "encryptionMethod_", cg.a$21});
        }
        if (i == 4) {
            return DEFAULT_INSTANCE;
        }
        if (i != 5) {
            return null;
        }
        return vz0.b(bi.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(du duVar) {
        Objects.requireNonNull(duVar);
        AbstractC0755i abstractC0755i = (AbstractC0755i) this.encryptedBlobs_;
        if (!abstractC0755i.b()) {
            this.encryptedBlobs_ = abstractC0755i.a(abstractC0755i.size() * 2);
        }
        this.encryptedBlobs_.add(duVar);
    }
}
