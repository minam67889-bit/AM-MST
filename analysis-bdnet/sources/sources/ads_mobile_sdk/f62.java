package ads_mobile_sdk;

import defpackage.Gf0;
import defpackage.U20;
import defpackage.X50;

/* loaded from: classes.dex */
public final class f62 extends zs0 {
    private static final f62 DEFAULT_INSTANCE;
    private static volatile Gf0 PARSER = null;
    public static final int c = 1;
    public static final int d = 2;
    private int bitField0_;
    private qq encryptedProgram_ = qq.b;
    private h62 metadata_;

    static {
        f62 f62Var = new f62();
        DEFAULT_INSTANCE = f62Var;
        zs0.a(f62.class, f62Var);
    }

    public static f62 o() {
        return DEFAULT_INSTANCE;
    }

    @Override // ads_mobile_sdk.zs0
    public final Object a(int i, zs0 zs0Var) {
        Gf0 gf0;
        int a = U20.a(i);
        if (a == 0) {
            return (byte) 1;
        }
        if (a == 2) {
            return new on2(DEFAULT_INSTANCE, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001", new Object[]{"bitField0_", "metadata_", "encryptedProgram_"});
        }
        if (a == 3) {
            return new f62();
        }
        if (a == 4) {
            return new X50(DEFAULT_INSTANCE);
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
        synchronized (f62.class) {
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

    public final qq p() {
        return this.encryptedProgram_;
    }

    public final h62 q() {
        h62 h62Var = this.metadata_;
        return h62Var == null ? h62.o() : h62Var;
    }

    public final boolean r() {
        return (this.bitField0_ & 2) != 0;
    }

    public final boolean s() {
        return (this.bitField0_ & 1) != 0;
    }
}
