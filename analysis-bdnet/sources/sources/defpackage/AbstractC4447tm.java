package defpackage;

import java.io.UnsupportedEncodingException;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;

/* renamed from: tm, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4447tm {
    public static final String a = Deobfuscator$AMTUNNELLITE$app.getString(-209769033961121L);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int a(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        return ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3)) ^ (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] g = g(bArr, false);
        int i = 16;
        if (bArr2.length != 16) {
            byte[] bArr3 = new byte[16];
            if (bArr2.length < 16) {
                i = bArr2.length;
            }
            System.arraycopy(bArr2, 0, bArr3, 0, i);
            bArr2 = bArr3;
        }
        int[] g2 = g(bArr2, false);
        int length = g.length;
        int i2 = length - 1;
        if (i2 >= 1) {
            int i3 = (52 / length) + 6;
            int i4 = g[0];
            for (int i5 = i3 * (-1638454863); i5 != 0; i5 -= -1638454863) {
                int i6 = (i5 >>> 2) & 3;
                int i7 = i4;
                int i8 = i2;
                while (i8 > 0) {
                    i7 = g[i8] - a(i5, i7, g[i8 - 1], i8, i6, g2);
                    g[i8] = i7;
                    i8--;
                }
                i4 = g[0] - a(i5, i7, g[i2], i8, i6, g2);
                g[0] = i4;
            }
        }
        return f(g, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String c(String str, String str2) {
        byte[] bArr;
        try {
            try {
                bArr = b(AbstractC3354fY.m(str), str2.getBytes(Deobfuscator$AMTUNNELLITE$app.getString(-209829163503265L)));
            } catch (UnsupportedEncodingException unused) {
                bArr = null;
            }
            if (bArr == null) {
                return null;
            }
            return new String(bArr, Deobfuscator$AMTUNNELLITE$app.getString(-209794803764897L));
        } catch (UnsupportedEncodingException unused2) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] g = g(bArr, true);
        int i = 16;
        if (bArr2.length != 16) {
            byte[] bArr3 = new byte[16];
            if (bArr2.length < 16) {
                i = bArr2.length;
            }
            System.arraycopy(bArr2, 0, bArr3, 0, i);
            bArr2 = bArr3;
        }
        int[] g2 = g(bArr2, false);
        int length = g.length;
        int i2 = length - 1;
        if (i2 >= 1) {
            int i3 = (52 / length) + 6;
            int i4 = g[i2];
            int i5 = 0;
            while (true) {
                int i6 = i3 - 1;
                if (i3 <= 0) {
                    break;
                }
                int i7 = (-1638454863) + i5;
                int i8 = (i7 >>> 2) & 3;
                int i9 = i4;
                int i10 = 0;
                while (i10 < i2) {
                    int i11 = i10 + 1;
                    i9 = g[i10] + a(i7, g[i11], i9, i10, i8, g2);
                    g[i10] = i9;
                    i10 = i11;
                }
                i5 = i7;
                i4 = a(i5, g[0], i9, i10, i8, g2) + g[i2];
                g[i2] = i4;
                i3 = i6;
            }
        }
        return f(g, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final String e(String str, String str2) {
        byte[] bArr;
        String str3;
        try {
            bArr = d(str.getBytes(Deobfuscator$AMTUNNELLITE$app.getString(-209880703110817L)), str2.getBytes(Deobfuscator$AMTUNNELLITE$app.getString(-209923652783777L)));
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        char[] cArr = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
        StringBuilder sb = new StringBuilder();
        int length = bArr.length % 3;
        int length2 = bArr.length - length;
        int i = 0;
        while (i < length2) {
            int i2 = i + 2;
            int i3 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
            i += 3;
            int i4 = i3 | (bArr[i2] & 255);
            sb.append(cArr[i4 >> 18]);
            sb.append(cArr[(i4 >> 12) & 63]);
            sb.append(cArr[(i4 >> 6) & 63]);
            sb.append(cArr[i4 & 63]);
        }
        if (length == 1) {
            byte b = bArr[i];
            sb.append(cArr[(b & 255) >> 2]);
            sb.append(cArr[(b & 3) << 4]);
            str3 = "==";
        } else {
            if (length == 2) {
                int i5 = (bArr[1 + i] & 255) | ((bArr[i] & 255) << 8);
                sb.append(cArr[i5 >> 10]);
                sb.append(cArr[(i5 >> 4) & 63]);
                sb.append(cArr[(i5 & 15) << 2]);
                str3 = "=";
            }
            return sb.toString();
        }
        sb.append(str3);
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] f(int[] iArr, boolean z) {
        int length = iArr.length << 2;
        if (z) {
            int i = iArr[iArr.length - 1];
            int i2 = length - 4;
            if (i >= length - 7 && i <= i2) {
                length = i;
            } else {
                return null;
            }
        }
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) (iArr[i3 >>> 2] >>> ((i3 & 3) << 3));
        }
        return bArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int[] g(byte[] bArr, boolean z) {
        int length;
        int[] iArr;
        if ((bArr.length & 3) == 0) {
            length = bArr.length >>> 2;
        } else {
            length = (bArr.length >>> 2) + 1;
        }
        if (z) {
            iArr = new int[length + 1];
            iArr[length] = bArr.length;
        } else {
            iArr = new int[length];
        }
        int length2 = bArr.length;
        for (int i = 0; i < length2; i++) {
            int i2 = i >>> 2;
            iArr[i2] = iArr[i2] | ((bArr[i] & 255) << ((i & 3) << 3));
        }
        return iArr;
    }
}
