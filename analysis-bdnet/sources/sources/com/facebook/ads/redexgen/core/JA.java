package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.DrmInitData;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;

/* loaded from: assets/audience_network/classes2.dex */
public final class JA {
    public static String[] A0C = {"uuzqWXLhVU5h", "MCiAyNDofRMgV8twnC7AiCrYM6kNh0jg", "HJXujHHcElJRTDtcfeo3Sy7Hv18RGZgy", "Amjr7hMXQx0e32VF8yWASHBDx37PervK", "NgKcffCH0RNam7yPBBIvJezNpINfNkiL", "oMs9elp", "apSAFH841DSL3paVepKSIoWcAWyBkdVZ", "h51QMR"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public J1 A04;
    public JR A05;
    public boolean A06;
    public final InterfaceC1313Hd A08;
    public final JQ A09 = new JQ();
    public final C10134v A07 = new C10134v();
    public final C10134v A0B = new C10134v(1);
    public final C10134v A0A = new C10134v();

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 15
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final int A04(int i, int i2) {
        C10134v c10134v;
        int length;
        JP A07 = A07();
        if (A07 == null) {
            return 0;
        }
        if (A07.A00 != 0) {
            c10134v = this.A09.A0H;
            length = A07.A00;
        } else {
            byte[] bArr = (byte[]) C5C.A0f(A07.A04);
            this.A0A.A0j(bArr, bArr.length);
            c10134v = this.A0A;
            length = bArr.length;
        }
        boolean A06 = this.A09.A06(this.A01);
        boolean z = A06 || i2 != 0;
        this.A0B.A0l()[0] = (byte) ((z ? UserVerificationMethods.USER_VERIFY_PATTERN : 0) | length);
        this.A0B.A0f(0);
        this.A08.AIs(this.A0B, 1, 1);
        this.A08.AIs(c10134v, length, 1);
        if (!z) {
            return length + 1;
        }
        if (!A06) {
            this.A07.A0d(8);
            byte[] A0l = this.A07.A0l();
            A0l[0] = 0;
            A0l[1] = 1;
            A0l[2] = (byte) ((i2 >> 8) & 255);
            A0l[3] = (byte) (i2 & 255);
            A0l[4] = (byte) ((i >> 24) & 255);
            A0l[5] = (byte) ((i >> 16) & 255);
            A0l[6] = (byte) ((i >> 8) & 255);
            A0l[7] = (byte) (i & 255);
            this.A08.AIs(this.A07, 8, 1);
            return length + 1 + 8;
        }
        C10134v c10134v2 = this.A09.A0H;
        int A0M = c10134v2.A0M();
        c10134v2.A0g(-2);
        int i3 = (A0M * 6) + 2;
        if (i2 != 0) {
            this.A07.A0d(i3);
            byte[] A0l2 = this.A07.A0l();
            c10134v2.A0k(A0l2, 0, i3);
            int i4 = (((A0l2[2] & 255) << 8) | (A0l2[3] & 255)) + i2;
            A0l2[2] = (byte) ((i4 >> 8) & 255);
            A0l2[3] = (byte) (i4 & 255);
            c10134v2 = this.A07;
        }
        this.A08.AIs(c10134v2, i3, 1);
        return length + 1 + i3;
    }

    public JA(InterfaceC1313Hd interfaceC1313Hd, JR jr, J1 j1) {
        this.A08 = interfaceC1313Hd;
        this.A05 = jr;
        this.A04 = j1;
        A0C(jr, j1);
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
        if (A07() == null) {
            return i;
        }
        String[] strArr = A0C;
        String str = strArr[3];
        String str2 = strArr[2];
        int charAt = str.charAt(20);
        int flags2 = str2.charAt(20);
        if (charAt != flags2) {
            throw new RuntimeException();
        }
        A0C[4] = "Hkeae3ogmEOju43arfP4ZrrsYFDfrpvf";
        return i | 1073741824;
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
            return this.A05.A07[this.A01];
        }
        return this.A09.A00(this.A01);
    }

    public final JP A07() {
        JP A00;
        if (!this.A06) {
            return null;
        }
        int i = ((J1) C5C.A0f(this.A09.A06)).A02;
        if (this.A09.A07 != null) {
            A00 = this.A09.A07;
        } else {
            A00 = this.A05.A03.A00(i);
        }
        if (A00 == null || !A00.A03) {
            return null;
        }
        JP encryptionBox = A00;
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
        JP A07 = A07();
        if (A07 == null) {
            return;
        }
        C10134v c10134v = this.A09.A0H;
        if (A07.A00 != 0) {
            c10134v.A0g(A07.A00);
        }
        if (this.A09.A06(this.A01)) {
            c10134v.A0g(c10134v.A0M() * 6);
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
        JP encryptionBox = this.A05.A03.A00(((J1) C5C.A0f(this.A09.A06)).A02);
        this.A08.A6e(this.A05.A03.A07.A07().A0u(drmInitData.A01(encryptionBox != null ? encryptionBox.A02 : null)).A14());
    }

    public final void A0C(JR jr, J1 j1) {
        this.A05 = jr;
        this.A04 = j1;
        this.A08.A6e(jr.A03.A07);
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
