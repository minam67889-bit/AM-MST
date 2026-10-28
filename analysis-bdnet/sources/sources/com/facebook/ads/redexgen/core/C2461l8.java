package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.l8, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes2.dex */
public final class C2461l8 implements H1 {
    public static String[] A04 = {"sdKdmhexVnrlWGhX9TH5KtuHBxlX2", "B98Zkm438dg3YkwTFsWcwjYsIqopE2cW", "q7DFl2FydsE0DWNk8QJk98tFdBPGU17r", "uw89PlDwsU5CTp5ALy1o", "HmpI", "x0Unc4LQNUVImDERNKiE", "Klo4tVDdc3zNBBgsT3eAMryjwXw3w", "mmy2vPNb8zCZX"};
    public final int A00;
    public final int A01;
    public final C10134v A02 = new C10134v();
    public final AnonymousClass53 A03;

    public C2461l8(int i, AnonymousClass53 anonymousClass53, int i2) {
        this.A00 = i;
        this.A03 = anonymousClass53;
        this.A01 = i2;
    }

    private C1309Gz A00(C10134v c10134v, long j, long j2) {
        int A00;
        int A002;
        int A0A = c10134v.A0A();
        long j3 = -1;
        long j4 = -1;
        long lastPcrTimeUsInRange = -9223372036854775807L;
        while (c10134v.A07() >= 188 && (A002 = (A00 = LI.A00(c10134v.A0l(), c10134v.A09(), A0A)) + 188) <= A0A) {
            long A01 = LI.A01(c10134v, A00, this.A00);
            if (A01 != -9223372036854775807L) {
                long A06 = this.A03.A06(A01);
                if (A06 > j) {
                    String[] strArr = A04;
                    if (strArr[1].charAt(12) == strArr[2].charAt(12)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A04;
                    strArr2[3] = "aExFpEIrb6zE8t35yvld";
                    strArr2[5] = "jMLoot3yN0lnttWSwPI3";
                    if (lastPcrTimeUsInRange == -9223372036854775807L) {
                        return C1309Gz.A04(A06, j2);
                    }
                    return C1309Gz.A03(j2 + j3);
                }
                long j5 = A06 + 100000;
                String[] strArr3 = A04;
                if (strArr3[1].charAt(12) != strArr3[2].charAt(12)) {
                    String[] strArr4 = A04;
                    strArr4[3] = "ZHgwZuqrkfLn2FTfbKUV";
                    strArr4[5] = "99YI6qOyfmrUQVvNk1ZB";
                    if (j5 > j) {
                        return C1309Gz.A03(A00 + j2);
                    }
                    j3 = A00;
                    lastPcrTimeUsInRange = A06;
                } else {
                    A04[4] = "5ynNf";
                    if (j5 > j) {
                        return C1309Gz.A03(A00 + j2);
                    }
                    j3 = A00;
                    lastPcrTimeUsInRange = A06;
                }
            }
            c10134v.A0f(A002);
            j4 = A002;
        }
        if (lastPcrTimeUsInRange != -9223372036854775807L) {
            return C1309Gz.A05(lastPcrTimeUsInRange, j2 + j4);
        }
        return C1309Gz.A03;
    }

    @Override // com.facebook.ads.redexgen.core.H1
    public final void AFs() {
        this.A02.A0i(C5C.A07);
    }

    @Override // com.facebook.ads.redexgen.core.H1
    public final C1309Gz AIw(InterfaceC2557ms interfaceC2557ms, long j) throws IOException {
        long A8n = interfaceC2557ms.A8n();
        int min = (int) Math.min(this.A01, interfaceC2557ms.A8O() - A8n);
        this.A02.A0d(min);
        interfaceC2557ms.AGt(this.A02.A0l(), 0, min);
        return A00(this.A02, j, A8n);
    }
}
