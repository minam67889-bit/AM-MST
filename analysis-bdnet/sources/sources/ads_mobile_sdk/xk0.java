package ads_mobile_sdk;

import defpackage.C0894cb0;
import defpackage.Gf0;
import defpackage.InterfaceC2858d80;
import defpackage.U20;

/* loaded from: classes.dex */
public final class xk0 extends zs0 {
    private static final xk0 DEFAULT_INSTANCE;
    private static volatile Gf0 PARSER = null;
    public static final int c = 1;
    public static final int d = 4;
    public static final int e = 2;
    public static final int f = 3;
    private int bitField0_;
    private boolean usersMatch_;
    private qq clearBlob_ = qq.b;
    private String clearBlobJs_ = "";
    private InterfaceC2858d80 encryptedBlob_ = zs0.h();

    static {
        xk0 xk0Var = new xk0();
        DEFAULT_INSTANCE = xk0Var;
        zs0.a(xk0.class, xk0Var);
    }

    @Override // ads_mobile_sdk.zs0
    public final Object a(int i, zs0 zs0Var) {
        Gf0 gf0;
        int a = U20.a(i);
        if (a == 0) {
            return (byte) 1;
        }
        if (a == 2) {
            return new on2(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ည\u0000\u0002\u001c\u0003ဇ\u0002\u0004ဈ\u0001", new Object[]{"bitField0_", "clearBlob_", "encryptedBlob_", "usersMatch_", "clearBlobJs_"});
        }
        if (a == 3) {
            return new xk0();
        }
        if (a == 4) {
            return new C0894cb0(DEFAULT_INSTANCE);
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
        synchronized (xk0.class) {
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
