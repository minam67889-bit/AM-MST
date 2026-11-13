package defpackage;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class I8 extends AbstractC0498So {
    public final byte[] a;
    public final byte[] b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public I8(byte[] bArr, byte[] bArr2) {
        this.a = bArr;
        this.b = bArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        byte[] bArr;
        byte[] bArr2;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC0498So)) {
            return false;
        }
        AbstractC0498So abstractC0498So = (AbstractC0498So) obj;
        boolean z = abstractC0498So instanceof I8;
        if (z) {
            bArr = ((I8) abstractC0498So).a;
        } else {
            bArr = ((I8) abstractC0498So).a;
        }
        if (Arrays.equals(this.a, bArr)) {
            if (z) {
                bArr2 = ((I8) abstractC0498So).b;
            } else {
                bArr2 = ((I8) abstractC0498So).b;
            }
            if (Arrays.equals(this.b, bArr2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return ((Arrays.hashCode(this.a) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "ExperimentIds{clearBlob=" + Arrays.toString(this.a) + ", encryptedBlob=" + Arrays.toString(this.b) + "}";
    }
}
