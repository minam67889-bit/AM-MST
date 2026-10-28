package defpackage;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class V8 extends AbstractC2988ep {
    public final byte[] a;
    public final byte[] b;

    public V8(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
        this.b = bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2988ep) {
            AbstractC2988ep abstractC2988ep = (AbstractC2988ep) obj;
            boolean z = abstractC2988ep instanceof V8;
            if (Arrays.equals(this.a, z ? ((V8) abstractC2988ep).a : ((V8) abstractC2988ep).a)) {
                if (Arrays.equals(this.b, z ? ((V8) abstractC2988ep).b : ((V8) abstractC2988ep).b)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.a) + ", encryptedBlob=" + Arrays.toString(this.b) + "}";
    }
}
