package ads_mobile_sdk;

import defpackage.C3967r70;
import defpackage.Gf0;
import defpackage.InterfaceC2858d80;
import defpackage.U20;

/* loaded from: classes.dex */
public final class ee extends zs0 {
    private static final ee DEFAULT_INSTANCE;
    private static volatile Gf0 PARSER = null;
    public static final int c = 1;
    public static final int d = 2;
    public static final int e = 3;
    public static final int f = 4;
    private int bitField0_;
    private InterfaceC2858d80 encryptedBlobs_ = zs0.h();
    private qq hash_ = qq.b;
    private int protoName_ = 1;
    private int encryptionMethod_ = 1;

    static {
        ee eeVar = new ee();
        DEFAULT_INSTANCE = eeVar;
        zs0.a(ee.class, eeVar);
    }

    @Override // ads_mobile_sdk.zs0
    public final Object a(int i, zs0 zs0Var) {
        Gf0 gf0;
        int a = U20.a(i);
        if (a == 0) {
            return (byte) 1;
        }
        if (a == 2) {
            return new on2(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"bitField0_", "encryptedBlobs_", "hash_", "protoName_", xd.a, "encryptionMethod_", rd.a});
        }
        if (a == 3) {
            return new ee();
        }
        if (a == 4) {
            return new C3967r70(DEFAULT_INSTANCE);
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
        synchronized (ee.class) {
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

    public static C3967r70 o() {
        return (C3967r70) DEFAULT_INSTANCE.e();
    }
}
