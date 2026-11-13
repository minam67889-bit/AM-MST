package defpackage;

import java.io.UnsupportedEncodingException;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;

/* renamed from: ym, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC4569ym {
    public static final String a = Deobfuscator$BDNETVPN$app.getString(-164539529000843L);

    public static int a(int i, int i2, int i3, int i4, int i5, int[] iArr) {
        return ((i ^ i2) + (iArr[(i4 & 3) ^ i5] ^ i3)) ^ (((i3 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i3 << 4)));
    }

    public static final byte[] b(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] g = g(bArr, false);
        if (bArr2.length != 16) {
            byte[] bArr3 = new byte[16];
            if (bArr2.length < 16) {
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArr3, 0, 16);
            }
            bArr2 = bArr3;
        }
        int[] g2 = g(bArr2, false);
        int length = g.length;
        int i = length - 1;
        if (i >= 1) {
            int i2 = (52 / length) + 6;
            int i3 = g[0];
            for (int i4 = i2 * (-1638454863); i4 != 0; i4 -= -1638454863) {
                int i5 = (i4 >>> 2) & 3;
                int i6 = i3;
                int i7 = i;
                while (i7 > 0) {
                    i6 = g[i7] - a(i4, i6, g[i7 - 1], i7, i5, g2);
                    g[i7] = i6;
                    i7--;
                }
                i3 = g[0] - a(i4, i6, g[i], i7, i5, g2);
                g[0] = i3;
            }
        }
        return f(g, true);
    }

    public static final String c(String str, String str2) {
        byte[] bArr;
        try {
            try {
                bArr = b(W80.m(str), str2.getBytes(Deobfuscator$BDNETVPN$app.getString(-164410679981963L)));
            } catch (UnsupportedEncodingException unused) {
                bArr = null;
            }
            if (bArr != null) {
                return new String(bArr, Deobfuscator$BDNETVPN$app.getString(-164513759197067L));
            }
        } catch (UnsupportedEncodingException unused2) {
        }
        return null;
    }

    public static final byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr.length == 0) {
            return bArr;
        }
        int[] g = g(bArr, true);
        if (bArr2.length != 16) {
            byte[] bArr3 = new byte[16];
            if (bArr2.length < 16) {
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            } else {
                System.arraycopy(bArr2, 0, bArr3, 0, 16);
            }
            bArr2 = bArr3;
        }
        int[] g2 = g(bArr2, false);
        int length = g.length;
        int i = length - 1;
        if (i >= 1) {
            int i2 = (52 / length) + 6;
            int i3 = g[i];
            int i4 = 0;
            while (true) {
                int i5 = i2 - 1;
                if (i2 <= 0) {
                    break;
                }
                i4 -= 1638454863;
                int i6 = (i4 >>> 2) & 3;
                int i7 = i3;
                int i8 = 0;
                while (i8 < i) {
                    int i9 = i8 + 1;
                    i7 = g[i8] + a(i4, g[i9], i7, i8, i6, g2);
                    g[i8] = i7;
                    i8 = i9;
                }
                i3 = g[i] + a(i4, g[0], i7, i8, i6, g2);
                g[i] = i3;
                i2 = i5;
            }
        }
        return f(g, false);
    }

    public static final String e(String str, String str2) {
        byte[] bArr;
        try {
            bArr = d(str.getBytes(Deobfuscator$BDNETVPN$app.getString(-164359140374411L)), str2.getBytes(Deobfuscator$BDNETVPN$app.getString(-164384910178187L)));
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
            sb.append("==");
        } else if (length == 2) {
            int i5 = (bArr[1 + i] & 255) | ((bArr[i] & 255) << 8);
            sb.append(cArr[i5 >> 10]);
            sb.append(cArr[(i5 >> 4) & 63]);
            sb.append(cArr[(i5 & 15) << 2]);
            sb.append("=");
        }
        return sb.toString();
    }

    public static byte[] f(int[] iArr, boolean z) {
        int length = iArr.length << 2;
        if (z) {
            int i = iArr[iArr.length - 1];
            int i2 = length - 4;
            if (i < length - 7 || i > i2) {
                return null;
            }
            length = i;
        }
        byte[] bArr = new byte[length];
        for (int i3 = 0; i3 < length; i3++) {
            bArr[i3] = (byte) (iArr[i3 >>> 2] >>> ((i3 & 3) << 3));
        }
        return bArr;
    }

    public static int[] g(byte[] bArr, boolean z) {
        int[] iArr;
        int length = (bArr.length & 3) == 0 ? bArr.length >>> 2 : (bArr.length >>> 2) + 1;
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
