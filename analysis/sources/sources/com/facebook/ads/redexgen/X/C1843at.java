package com.facebook.ads.redexgen.X;

import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

/* renamed from: com.facebook.ads.redexgen.X.at, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C1843at {
    public static String[] A0A = {"hn1FHZJnLh3thuxxKEIhZTqnlh5aWEbw", "qDjh889adJz1MC", "vY3CRqHO1bVmmLT8Hq7gqQ8FFHoNB", "cMHnnSo25D50Rxc59rDVSvzIsgO5hE1C", "TK2vIC7x9g9unoc", "GEWgj", "ZHEG6A7QvYcS4oy88WRiW8fDIFxtCxmZ", "QYDDDh5QI"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C1837an A04;
    public C1860bA A05;
    public final ZP A06;
    public final C1862bC A07 = new C1862bC();
    public final C1459Mk A09 = new C1459Mk(1);
    public final C1459Mk A08 = new C1459Mk();

    public C1843at(ZP zp) {
        this.A06 = zp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public C1861bB A00() {
        C1861bB A00;
        int i = this.A07.A06.A02;
        if (this.A07.A07 != null) {
            A00 = this.A07.A07;
        } else {
            A00 = this.A05.A00(i);
        }
        if (A00 != null) {
            boolean z = A00.A03;
            String[] strArr = A0A;
            String str = strArr[1];
            String str2 = strArr[4];
            int length = str.length();
            int sampleDescriptionIndex = str2.length();
            if (length == sampleDescriptionIndex) {
                throw new RuntimeException();
            }
            A0A[6] = "M7WQN7echjzu5PJ9kXxaPiCmmnvjA1W3";
            if (z) {
                return A00;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C1861bB A00 = A00();
        if (A00 == null) {
            return;
        }
        C1862bC c1862bC = this.A07;
        if (A0A[3].charAt(17) != 'r') {
            throw new RuntimeException();
        }
        A0A[6] = "2xb7HPeFQWra9WDOakKd0dOCmGEctuq2";
        C1459Mk sampleEncryptionData = c1862bC.A0H;
        if (A00.A00 != 0) {
            sampleEncryptionData.A0g(A00.A00);
        }
        if (this.A07.A06(this.A01)) {
            sampleEncryptionData.A0g(sampleEncryptionData.A0M() * 6);
        }
    }

    public final int A04() {
        C1459Mk c1459Mk;
        int vectorSize;
        C1861bB A00 = A00();
        if (A00 == null) {
            return 0;
        }
        if (A00.A00 != 0) {
            c1459Mk = this.A07.A0H;
            vectorSize = A00.A00;
        } else {
            byte[] initVectorData = A00.A04;
            this.A08.A0j(initVectorData, initVectorData.length);
            c1459Mk = this.A08;
            vectorSize = initVectorData.length;
        }
        boolean A06 = this.A07.A06(this.A01);
        this.A09.A00[0] = (byte) ((A06 ? UserVerificationMethods.USER_VERIFY_PATTERN : 0) | vectorSize);
        this.A09.A0f(0);
        ZP zp = this.A06;
        C1459Mk initializationVectorData = this.A09;
        zp.AK9(initializationVectorData, 1);
        this.A06.AK9(c1459Mk, vectorSize);
        if (!A06) {
            return vectorSize + 1;
        }
        C1459Mk c1459Mk2 = this.A07.A0H;
        int A0M = c1459Mk2.A0M();
        c1459Mk2.A0g(-2);
        int i = (A0M * 6) + 2;
        this.A06.AK9(c1459Mk2, i);
        return vectorSize + 1 + i;
    }

    public final void A05() {
        this.A07.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A06(long j) {
        for (int i = this.A01; i < searchIndex && this.A07.A00(i) < j; i++) {
            C1862bC c1862bC = this.A07;
            if (A0A[6].charAt(17) == 'a') {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[5] = "UiDsF";
            strArr[7] = "D9RX4x7Ey";
            if (c1862bC.A0G[i]) {
                this.A03 = i;
            }
        }
    }

    public final void A07(DrmInitData drmInitData) {
        C1861bB encryptionBox = this.A05.A00(this.A07.A06.A02);
        this.A06.A7E(this.A05.A07.A09(drmInitData.A01(encryptionBox != null ? encryptionBox.A02 : null)));
    }

    public final void A08(C1860bA c1860bA, C1837an c1837an) {
        this.A05 = (C1860bA) AbstractC1437Ln.A01(c1860bA);
        this.A04 = (C1837an) AbstractC1437Ln.A01(c1837an);
        this.A06.A7E(c1860bA.A07);
        A05();
    }

    public final boolean A09() {
        this.A01++;
        this.A00++;
        if (this.A00 != this.A07.A0C[this.A02]) {
            return true;
        }
        this.A02++;
        this.A00 = 0;
        return false;
    }
}
