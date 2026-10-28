package defpackage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class G8 {
    public final String a;
    public final Integer b;
    public final C0601Wn c;
    public final long d;
    public final long e;
    public final Map f;
    public final Integer g;
    public final String h;
    public final byte[] i;
    public final byte[] j;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public G8(String str, Integer num, C0601Wn c0601Wn, long j, long j2, Map map, Integer num2, String str2, byte[] bArr, byte[] bArr2) {
        this.a = str;
        this.b = num;
        this.c = c0601Wn;
        this.d = j;
        this.e = j2;
        this.f = map;
        this.g = num2;
        this.h = str2;
        this.i = bArr;
        this.j = bArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String a(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int b(String str) {
        String str2 = (String) this.f.get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final F8 c() {
        F8 f8 = new F8();
        String str = this.a;
        if (str != null) {
            f8.a = str;
            f8.c = this.b;
            f8.d = this.g;
            f8.b = this.h;
            f8.i = this.i;
            f8.j = this.j;
            f8.d(this.c);
            f8.f = Long.valueOf(this.d);
            f8.g = Long.valueOf(this.e);
            f8.h = new HashMap(this.f);
            return f8;
        }
        throw new NullPointerException("Null transportName");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof G8)) {
            return false;
        }
        G8 g8 = (G8) obj;
        if (this.a.equals(g8.a)) {
            Integer num = g8.b;
            Integer num2 = this.b;
            if (num2 != null ? num2.equals(num) : num == null) {
                if (this.c.equals(g8.c) && this.d == g8.d && this.e == g8.e && this.f.equals(g8.f)) {
                    Integer num3 = g8.g;
                    Integer num4 = this.g;
                    if (num4 != null ? num4.equals(num3) : num3 == null) {
                        String str = g8.h;
                        String str2 = this.h;
                        if (str2 != null ? str2.equals(str) : str == null) {
                            if (Arrays.equals(this.i, g8.i) && Arrays.equals(this.j, g8.j)) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.a.hashCode() ^ 1000003) * 1000003;
        int i = 0;
        Integer num = this.b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int hashCode4 = (((hashCode3 ^ hashCode) * 1000003) ^ this.c.hashCode()) * 1000003;
        long j = this.d;
        int i2 = (hashCode4 ^ ((int) (j ^ (j >>> 32)))) * 1000003;
        long j2 = this.e;
        int hashCode5 = (((i2 ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003) ^ this.f.hashCode()) * 1000003;
        Integer num2 = this.g;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i3 = (hashCode5 ^ hashCode2) * 1000003;
        String str = this.h;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((i3 ^ i) * 1000003) ^ Arrays.hashCode(this.i)) * 1000003) ^ Arrays.hashCode(this.j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "EventInternal{transportName=" + this.a + ", code=" + this.b + ", encodedPayload=" + this.c + ", eventMillis=" + this.d + ", uptimeMillis=" + this.e + ", autoMetadata=" + this.f + ", productId=" + this.g + ", pseudonymousId=" + this.h + ", experimentIdsClear=" + Arrays.toString(this.i) + ", experimentIdsEncrypted=" + Arrays.toString(this.j) + "}";
    }
}
