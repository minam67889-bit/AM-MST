package org.lsposed.lsparanoid;

/* loaded from: classes2.dex */
public class DeobfuscatorHelper {
    public static final int MAX_CHUNK_LENGTH = 8191;

    private DeobfuscatorHelper() {
    }

    private static long getCharAt(int i, String[] strArr, long j) {
        return (strArr[i / MAX_CHUNK_LENGTH].charAt(i % MAX_CHUNK_LENGTH) << 32) ^ RandomHelper.next(j);
    }

    public static String getString(long j, String[] strArr) {
        long next = RandomHelper.next(RandomHelper.seed(4294967295L & j));
        long j2 = (next >>> 32) & 65535;
        long next2 = RandomHelper.next(next);
        int i = (int) (((j >>> 32) ^ j2) ^ ((next2 >>> 16) & (-65536)));
        long charAt = getCharAt(i, strArr, next2);
        int i2 = (int) ((charAt >>> 32) & 65535);
        char[] cArr = new char[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            charAt = getCharAt(i + i3 + 1, strArr, charAt);
            cArr[i3] = (char) ((charAt >>> 32) & 65535);
        }
        return new String(cArr);
    }
}
