package ads_mobile_sdk;

import ads_mobile_sdk.vz0;
import defpackage.C3176d90;
import defpackage.Hc0;

/* loaded from: classes.dex */
public final class xh extends vz0 {
    private static final xh DEFAULT_INSTANCE;
    public static final int c = 1;
    public static final int d = 3;
    public static final int e = 4;
    private int bitField0_;
    private long timestampMs_;
    private String keyIdentifier_ = "";
    private du encryptedAdAttestationStatemement_ = du.b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        xh xhVar = new xh();
        DEFAULT_INSTANCE = xhVar;
        vz0.a((Class<xh>) xh.class, xhVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean A() {
        return (this.bitField0_ & 1) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final du v() {
        return this.encryptedAdAttestationStatemement_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String w() {
        return this.keyIdentifier_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long x() {
        return this.timestampMs_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean y() {
        return (this.bitField0_ & 4) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean z() {
        return (this.bitField0_ & 2) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // ads_mobile_sdk.vz0
    public final Object a(vz0.d dVar, vz0 vz0Var) {
        int i = Hc0.a[dVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return vz0.b(xh.class);
                    }
                    return DEFAULT_INSTANCE;
                }
                return new i13(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"bitField0_", "timestampMs_", "keyIdentifier_", "encryptedAdAttestationStatemement_"});
            }
            return new C3176d90(DEFAULT_INSTANCE);
        }
        return new xh();
    }
}
