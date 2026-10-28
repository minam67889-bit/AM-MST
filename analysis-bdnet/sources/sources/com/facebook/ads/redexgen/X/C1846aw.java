package com.facebook.ads.redexgen.X;

import com.facebook.ads.androidx.media3.common.DrmInitData;

/* renamed from: com.facebook.ads.redexgen.X.aw, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C1846aw {
    public static String[] A0C = {"8V3AH1jFj1uCH77jnL5gp4Dcj8s8JrSM", "uVEOV64jTbCDi0V18Z8p9KlatCZHWnRb", "aJxaQfyqbyR1ntlpLHwHseR3oRN9Smur", "RjBE4eVJq7bpqZZeKNEZ67ufThpbLV11", "NmKxiyzWR", "JMTKFh", "be3pU6YoM", "2MIEm5bDWuGrUK7"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public C1837an A04;
    public C1863bD A05;
    public boolean A06;
    public final ZP A08;
    public final C1862bC A09 = new C1862bC();
    public final C1459Mk A07 = new C1459Mk();
    public final C1459Mk A0B = new C1459Mk(1);
    public final C1459Mk A0A = new C1459Mk();

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005f, code lost:
    
        if (r9 != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0061, code lost:
    
        r0 = com.google.android.gms.fido.fido2.api.common.UserVerificationMethods.USER_VERIFY_PATTERN;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
    
        r0 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
    
        if (r9 != false) goto L18;
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int A04(int i, int i2) {
        C1459Mk c1459Mk;
        int length;
        int i3;
        C1861bB A07 = A07();
        if (A07 == null) {
            return 0;
        }
        if (A07.A00 != 0) {
            c1459Mk = this.A09.A0H;
            length = A07.A00;
        } else {
            byte[] bArr = (byte[]) N1.A0f(A07.A04);
            this.A0A.A0j(bArr, bArr.length);
            c1459Mk = this.A0A;
            length = bArr.length;
        }
        boolean A06 = this.A09.A06(this.A01);
        String[] strArr = A0C;
        if (strArr[1].charAt(6) == strArr[0].charAt(6)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0C;
        strArr2[4] = "OtcMSLIlX";
        strArr2[6] = "XgpN2eLUS";
        boolean z = A06 || i2 != 0;
        byte[] A0l = this.A0B.A0l();
        if (A0C[7].length() != 15) {
            String[] strArr3 = A0C;
            strArr3[4] = "tgIDNgGjB";
            strArr3[6] = "jtXG7kQuk";
        } else {
            A0C[2] = "eRxyDAQwuIwVQ80Smqp4WU1lJfOBSGN5";
        }
        A0l[0] = (byte) (i3 | length);
        this.A0B.A0f(0);
        this.A08.AKA(this.A0B, 1, 1);
        this.A08.AKA(c1459Mk, length, 1);
        if (!z) {
            return length + 1;
        }
        if (!A06) {
            this.A07.A0d(8);
            byte[] A0l2 = this.A07.A0l();
            A0l2[0] = 0;
            A0l2[1] = 1;
            A0l2[2] = (byte) ((i2 >> 8) & 255);
            A0l2[3] = (byte) (i2 & 255);
            A0l2[4] = (byte) ((i >> 24) & 255);
            A0l2[5] = (byte) ((i >> 16) & 255);
            A0l2[6] = (byte) ((i >> 8) & 255);
            A0l2[7] = (byte) (i & 255);
            this.A08.AKA(this.A07, 8, 1);
            return length + 1 + 8;
        }
        C1459Mk c1459Mk2 = this.A09.A0H;
        int A0M = c1459Mk2.A0M();
        c1459Mk2.A0g(-2);
        int i4 = (A0M * 6) + 2;
        if (i2 != 0) {
            this.A07.A0d(i4);
            byte[] A0l3 = this.A07.A0l();
            c1459Mk2.A0k(A0l3, 0, i4);
            int i5 = (((A0l3[2] & 255) << 8) | (A0l3[3] & 255)) + i2;
            A0l3[2] = (byte) ((i5 >> 8) & 255);
            A0l3[3] = (byte) (i5 & 255);
            c1459Mk2 = this.A07;
        }
        this.A08.AKA(c1459Mk2, i4, 1);
        return length + 1 + i4;
    }

    public C1846aw(ZP zp, C1863bD c1863bD, C1837an c1837an) {
        this.A08 = zp;
        this.A05 = c1863bD;
        this.A04 = c1837an;
        A0C(c1863bD, c1837an);
    }

    public final int A02() {
        int i;
        if (!this.A06) {
            i = this.A05.A04[this.A01];
        } else {
            boolean[] zArr = this.A09.A0G;
            int flags = this.A01;
            i = zArr[flags] ? 1 : 0;
        }
        if (A07() != null) {
            return i | 1073741824;
        }
        return i;
    }

    public final int A03() {
        if (!this.A06) {
            return this.A05.A05[this.A01];
        }
        return this.A09.A0B[this.A01];
    }

    public final long A05() {
        if (!this.A06) {
            return this.A05.A06[this.A01];
        }
        return this.A09.A0E[this.A02];
    }

    public final long A06() {
        if (!this.A06) {
            long[] jArr = this.A05.A07;
            String[] strArr = A0C;
            if (strArr[1].charAt(6) == strArr[0].charAt(6)) {
                throw new RuntimeException();
            }
            A0C[5] = "mjoQKRu63KzbWmqupbcZb9H";
            return jArr[this.A01];
        }
        C1862bC c1862bC = this.A09;
        if (A0C[2].charAt(2) != 'x') {
            A0C[5] = "Z6Pv8tWM";
            return c1862bC.A00(this.A01);
        }
        A0C[5] = "7ODvdZhwoAjuY5fACjNYPENoE";
        return c1862bC.A00(this.A01);
    }

    public final C1861bB A07() {
        C1861bB A00;
        if (!this.A06) {
            return null;
        }
        int i = ((C1837an) N1.A0f(this.A09.A06)).A02;
        if (this.A09.A07 != null) {
            A00 = this.A09.A07;
        } else {
            A00 = this.A05.A03.A00(i);
        }
        if (A00 == null || !A00.A03) {
            return null;
        }
        C1861bB encryptionBox = A00;
        return encryptionBox;
    }

    public final void A08() {
        this.A09.A01();
        this.A01 = 0;
        this.A02 = 0;
        this.A00 = 0;
        this.A03 = 0;
        this.A06 = false;
    }

    public final void A09() {
        C1861bB A07 = A07();
        if (A07 == null) {
            return;
        }
        C1459Mk c1459Mk = this.A09.A0H;
        if (A07.A00 != 0) {
            c1459Mk.A0g(A07.A00);
        }
        boolean A06 = this.A09.A06(this.A01);
        if (A0C[7].length() != 15) {
            throw new RuntimeException();
        }
        A0C[7] = "ya3ecvWsgH5ZH1e";
        if (A06) {
            c1459Mk.A0g(c1459Mk.A0M() * 6);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0006 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0A(long j) {
        for (int i = this.A01; i < searchIndex && this.A09.A00(i) <= j; i++) {
            if (this.A09.A0G[i]) {
                this.A03 = i;
            }
        }
    }

    public final void A0B(DrmInitData drmInitData) {
        C1861bB encryptionBox = this.A05.A03.A00(((C1837an) N1.A0f(this.A09.A06)).A02);
        this.A08.A7E(this.A05.A03.A07.A07().A0u(drmInitData.A01(encryptionBox != null ? encryptionBox.A02 : null)).A14());
    }

    public final void A0C(C1863bD c1863bD, C1837an c1837an) {
        this.A05 = c1863bD;
        this.A04 = c1837an;
        this.A08.A7E(c1863bD.A03.A07);
        A08();
    }

    public final boolean A0D() {
        this.A01++;
        if (!this.A06) {
            return false;
        }
        this.A00++;
        if (this.A00 != this.A09.A0C[this.A02]) {
            return true;
        }
        this.A02++;
        this.A00 = 0;
        return false;
    }
}
