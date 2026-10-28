package ads_mobile_sdk;

import defpackage.Ef0;
import defpackage.Gf0;
import defpackage.U20;

/* loaded from: classes.dex */
public final class ae extends zs0 {
    private static final ae DEFAULT_INSTANCE;
    private static volatile Gf0 PARSER = null;
    public static final int c = 1;
    public static final int d = 3;
    public static final int e = 4;
    private int bitField0_;
    private long timestampMs_;
    private String keyIdentifier_ = "";
    private qq encryptedAdAttestationStatemement_ = qq.b;

    static {
        ae aeVar = new ae();
        DEFAULT_INSTANCE = aeVar;
        zs0.a(ae.class, aeVar);
    }

    @Override // ads_mobile_sdk.zs0
    public final Object a(int i, zs0 zs0Var) {
        Gf0 gf0;
        int a = U20.a(i);
        if (a == 0) {
            return (byte) 1;
        }
        if (a == 2) {
            return new on2(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"bitField0_", "timestampMs_", "keyIdentifier_", "encryptedAdAttestationStatemement_"});
        }
        if (a == 3) {
            return new ae();
        }
        if (a == 4) {
            return new Ef0(DEFAULT_INSTANCE);
        }
        if (a == 5) {
            return DEFAULT_INSTANCE;
        }
        if (a != 6) {
            throw null;
        }
        Gf0 gf02 = PARSER;
        if (gf02 != null) {
            return gf02;
        }
        synchronized (ae.class) {
            try {
                gf0 = PARSER;
                if (gf0 == null) {
                    gf0 = new ys0(DEFAULT_INSTANCE);
                    PARSER = gf0;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return gf0;
    }
}
