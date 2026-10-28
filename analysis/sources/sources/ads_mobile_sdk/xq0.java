package ads_mobile_sdk;

import ads_mobile_sdk.vz0;
import defpackage.AbstractC4744xc0;
import defpackage.C3176d90;
import defpackage.InterfaceC4054od0;

/* loaded from: classes.dex */
public final class xq0 extends vz0 {
    private static final xq0 DEFAULT_INSTANCE;
    public static final int c = 1;
    public static final int d = 4;
    public static final int e = 2;
    public static final int f = 3;
    private int bitField0_;
    private boolean usersMatch_;
    private du clearBlob_ = du.b;
    private String clearBlobJs_ = "";
    private InterfaceC4054od0 encryptedBlob_ = bw2.e();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        xq0 xq0Var = new xq0();
        DEFAULT_INSTANCE = xq0Var;
        vz0.a((Class<xq0>) xq0.class, xq0Var);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // ads_mobile_sdk.vz0
    public final Object a(vz0.d dVar, vz0 vz0Var) {
        int i = AbstractC4744xc0.a[dVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        if (i != 5) {
                            return null;
                        }
                        return vz0.b(xq0.class);
                    }
                    return DEFAULT_INSTANCE;
                }
                return new i13(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ည\u0000\u0002\u001c\u0003ဇ\u0002\u0004ဈ\u0001", new Object[]{"bitField0_", "clearBlob_", "encryptedBlob_", "usersMatch_", "clearBlobJs_"});
            }
            return new C3176d90(DEFAULT_INSTANCE);
        }
        return new xq0();
    }
}
