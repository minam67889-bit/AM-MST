package ads_mobile_sdk;

import defpackage.Hf0;

/* loaded from: classes.dex */
public enum sd implements Hf0 {
    UNKNOWN_ENCRYPTION_METHOD(0),
    BITSLICER(1),
    TINK_HYBRID(2),
    UNENCRYPTED(3),
    DG(4),
    DG_XTEA(5),
    ADSHIELD_3(6);

    public final int a;

    sd(int i2) {
        this.a = i2;
    }

    @Override // defpackage.Hf0
    public final int getNumber() {
        return this.a;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + sd.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.a + " name=" + name() + '>';
    }
}
