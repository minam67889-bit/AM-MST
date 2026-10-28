package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.database.Cursor;
import java.util.Arrays;
import org.chromium.base.metrics.ScopedSysTraceEvent;

/* renamed from: com.facebook.ads.redexgen.X.kd, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public abstract class AbstractC2440kd {
    public static byte[] A00;
    public static String[] A01 = {"BBXCQ1c8lWMx5iTCFSjBAsNmZ8", "uWpSMDe8Dl1QwAjraNXmi3HjN39WCwvV", "Nl77HN8SOPKSqciG8lmOC8DFY50qabgT", "qKAuPB5zte0w", "tHnAlNrx5zeOSNOAYBdYTMmeA", "muO01a58leOoeMmtxXp9cvgd3", "skgH0VF5dzwRL9wPv5", "Mbe4svBdXamA1BIwkYK5rcxDOVieSFVl"};

    public static String A01(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = copyOfRange.length;
            if (A01[2].charAt(14) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "5u7aTW8yax3G";
            strArr[6] = "UvSwr6xgQWJsIweShl";
            if (i4 >= length) {
                return new String(copyOfRange);
            }
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 109);
            i4++;
        }
    }

    public static void A02() {
        A00 = new byte[]{118, 126, 115, 115, 124, 118, 96, 125, 123, 118, 123, 118, 40, 36, 37, 63, 46, 37, 63, 113, 100, 100, 40, 36, 38, 101, 45, 42, 40, 46, 41, 36, 36, 32, 101, 32, 42, 63, 42, 37, 42, 101, 59, 57, 36, 61, 34, 47, 46, 57, 101, 10, 63, 63, 57, 34, 41, 62, 63, 34, 36, 37, 2, 47, 27, 57, 36, 61, 34, 47, 46, 57, 37, 32, 36, 32, 61, 22, 61, 59, 40, 42, 34, 32, 39, 46};
    }

    static {
        A02();
    }

    public static C2439kc A00(ContentResolver contentResolver) {
        String A012 = A01(72, 14, 36);
        String A013 = A01(3, 9, ScopedSysTraceEvent.MAX_SECTION_NAME_LEN);
        String A014 = A01(0, 3, 122);
        Cursor c = null;
        try {
            c = contentResolver.query(AbstractC2726pP.A00(A01(12, 60, 38)), new String[]{A014, A013, A012}, null, null, null);
            if (c == null || !c.moveToFirst()) {
                return new C2439kc(null, null, false);
            }
            String string = c.getString(c.getColumnIndex(A014));
            String attributionId = c.getString(c.getColumnIndex(A013));
            C2439kc c2439kc = new C2439kc(string, attributionId, Boolean.valueOf(c.getString(c.getColumnIndex(A012))).booleanValue());
            if (c != null) {
                c.close();
            }
            return c2439kc;
        } finally {
            if (c != null) {
                c.close();
            }
        }
    }
}
