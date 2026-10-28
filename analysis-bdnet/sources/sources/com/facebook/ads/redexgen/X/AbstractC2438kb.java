package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.facebook.ads.redexgen.X.kb, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public abstract class AbstractC2438kb {
    public static byte[] A00;
    public static String[] A01 = {"zJ7sRo3sU3MwvYkxVq5sKXU", "uwqdBBQkb", "sk1pAaPClwmr1DZFuM4XEVJDjMgj4luU", "2DEAuAVf", "LM1sVeBw6DNfIdZzIYsj5hqYQDPEhJFy", "hYSBjzGCwuKpFZFqojmwIwdxMJLMCyYz", "BWOi5Qn34m6VEGTMmYfzcDYeX0GTjOOy", "rscTiGR64sMWr7IEiXLU0M2EjoTwZlLg"};
    public static final AtomicReference<C2436kZ> A02;
    public static final AtomicReference<String> A03;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 52);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A00 = new byte[]{-98, -90, -95, -100, -84, -77, -94, -81, -81, -90, -95, -94, -95, -97, -88, -97, -84, -93, -99, -20, -25, -23, -28, -30, -14, -7, -24, -11, -11, -20, -25, -24};
    }

    static {
        A05();
        A02 = new AtomicReference<>();
        A03 = new AtomicReference<>(A04(0, 0, 68));
    }

    public static C2436kZ A00() {
        C2436kZ c2436kZ = A02.get();
        if (A01[6].charAt(15) == 'M') {
            String[] strArr = A01;
            strArr[3] = "GQnQs3ZS";
            strArr[1] = "yTwJu7KeR";
            C2436kZ c2436kZ2 = c2436kZ;
            if (c2436kZ2 == null) {
                C2436kZ A002 = C2436kZ.A00();
                String[] strArr2 = A01;
                if (strArr2[3].length() != strArr2[1].length()) {
                    A01[0] = "yvynwBtI7EoQ7kGRkYf58OE";
                    return A002;
                }
            } else {
                return c2436kZ2;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x000a, code lost:
    
        if (android.text.TextUtils.isEmpty(r6.A03()) != false) goto L5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C2436kZ A01(C2470lA c2470lA, C2436kZ c2436kZ) {
        if (c2436kZ != null) {
            try {
            } catch (Throwable t) {
                c2470lA.A08().ABz(A04(12, 7, 6), AbstractC2501lf.A1Q, new C2502lg(t));
            }
        }
        return AbstractC2443kh.A00(c2470lA);
        return c2436kZ;
    }

    public static C2436kZ A02(C2470lA c2470lA, C2436kZ c2436kZ, C2437ka c2437ka) {
        C2439kc c2439kc = null;
        try {
            if (AbstractC2576mt.A06(c2470lA) && (c2436kZ == null || TextUtils.isEmpty(c2436kZ.A03()))) {
                c2439kc = AbstractC2440kd.A00(c2470lA.getContentResolver());
            }
        } catch (Throwable th) {
            c2470lA.A08().ABz(A04(12, 7, 6), AbstractC2501lf.A1S, new C2502lg(th));
        }
        if (c2439kc != null && c2439kc.A01 != null) {
            A03.set(c2439kc.A01);
            c2437ka.A05(c2439kc.A01);
        }
        if (c2436kZ == null && c2439kc != null && !TextUtils.isEmpty(c2439kc.A00)) {
            return new C2436kZ(c2439kc.A00, c2439kc.A02, EnumC2435kY.A05);
        }
        return c2436kZ;
    }

    public static String A03() {
        String attributionId = A03.get();
        if (attributionId == null) {
            return A04(0, 0, 68);
        }
        return attributionId;
    }

    public static void A06(C2437ka c2437ka) {
        A02.set(c2437ka.A02());
        A03.set(c2437ka.A03());
    }

    public static void A07(C2470lA c2470lA) {
        long j;
        C2436kZ advertisingIdInfo;
        try {
            C2437ka c2437ka = new C2437ka(c2470lA);
            A06(c2437ka);
            if (A08()) {
                return;
            }
            C2436kZ advertisingIdInfo2 = A02.get();
            if (advertisingIdInfo2 != null && !TextUtils.isEmpty(advertisingIdInfo2.A03())) {
                j = advertisingIdInfo2.A01();
            } else {
                j = -1;
            }
            if (j > 0 && System.currentTimeMillis() - j < AbstractC2576mt.A00(c2470lA)) {
                return;
            }
            if (AbstractC2576mt.A07(c2470lA)) {
                advertisingIdInfo = A01(c2470lA, A02(c2470lA, null, c2437ka));
            } else {
                advertisingIdInfo = A02(c2470lA, A01(c2470lA, null), c2437ka);
            }
            if (advertisingIdInfo != null && !TextUtils.isEmpty(advertisingIdInfo.A03())) {
                A02.set(advertisingIdInfo);
                c2437ka.A04(advertisingIdInfo);
            }
        } catch (Throwable t) {
            c2470lA.A08().ABz(A04(12, 7, 6), AbstractC2501lf.A1R, new C2502lg(t));
        }
    }

    public static boolean A08() {
        boolean z = false;
        boolean updated = C2728pR.A04();
        if (updated) {
            if (A01[0].length() != 23) {
                throw new RuntimeException();
            }
            String[] strArr = A01;
            strArr[3] = "OqjdKmMb";
            strArr[1] = "Sbvi0a9C0";
            String A04 = A04(0, 12, 9);
            boolean updated2 = C2728pR.A05(A04);
            if (updated2) {
                A03.set(C2728pR.A01(A04));
                z = true;
            }
        }
        boolean A042 = C2728pR.A04();
        String[] strArr2 = A01;
        if (strArr2[5].charAt(29) != strArr2[4].charAt(29)) {
            A01[6] = "1QSggKSi3jrfAw1MbHCsavUz8mNGSj1M";
            if (!A042) {
                return z;
            }
        } else {
            A01[6] = "SqTb5lTJEle7YRZML8ItyxwGEN07wws1";
            if (!A042) {
                return z;
            }
        }
        String A043 = A04(19, 13, 79);
        boolean updated3 = C2728pR.A05(A043);
        if (updated3) {
            String A012 = C2728pR.A01(A043);
            AtomicReference<C2436kZ> atomicReference = A02;
            if (A012 == null) {
                A012 = A04(0, 0, 68);
            }
            atomicReference.set(new C2436kZ(A012, false, EnumC2435kY.A04));
            return true;
        }
        return z;
    }
}
