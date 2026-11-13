package com.facebook.ads.redexgen.X;

import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* renamed from: com.facebook.ads.redexgen.X.8t, reason: invalid class name */
/* loaded from: assets/audience_network/classes.dex */
public final class C8t implements InterfaceC1578Rl, InterfaceC1579Rm {
    public static String[] A06 = {"j7ubs5bwgBez5KDYUpPY3y9IUQxc", "JOAIKi1HLeUTl2tk5bOhUejHSMD1BwGe", "YxHHt2R32vuln3OS2w6ZQ7XqQwwfs", "aupLwo0WeDrisWiY1FBdNsKSCvzUPpFe", "KV0q3mJ2COCv3zNe1TKQIxAqT8En", "VvmcfsKIDFg0hFd1fCD4fg9J7lYLhQDg", "7uek9E1vo9MWNmtvovjiW3PoQelKtD61", "xssxyHNHBfHwiy7JIZEyvUKZcMkbPmVh"};
    public long A00;
    public long A01;
    public long A02;
    public InterfaceC1579Rm A03;
    public C1581Ro[] A04 = new C1581Ro[0];
    public final InterfaceC1578Rl A05;

    public C8t(InterfaceC1578Rl interfaceC1578Rl, boolean z, long j, long j2) {
        this.A05 = interfaceC1578Rl;
        this.A02 = z ? j : -9223372036854775807L;
        this.A01 = j;
        this.A00 = j2;
    }

    private C1531Pj A00(long j, C1531Pj c1531Pj) {
        long toleranceBeforeUs = N1.A0T(c1531Pj.A01, 0L, j - this.A01);
        long A0T = N1.A0T(c1531Pj.A00, 0L, this.A00 == Long.MIN_VALUE ? Long.MAX_VALUE : this.A00 - j);
        if (toleranceBeforeUs == c1531Pj.A01 && A0T == c1531Pj.A00) {
            return c1531Pj;
        }
        return new C1531Pj(toleranceBeforeUs, A0T);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.VI
    /* renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final void AEW(InterfaceC1578Rl interfaceC1578Rl) {
        ((InterfaceC1579Rm) AbstractC1437Ln.A01(this.A03)).AEW(this);
    }

    public static boolean A02(long j, RA[] raArr) {
        if (j != 0) {
            for (RA ra : raArr) {
                if (A06[3].charAt(14) == 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[6] = "fGuJHx4aftfK4nNvykLU6KmljzgT82dn";
                strArr[5] = "kD9XBGQyLMsMzCVi6Yj91l7kD05F7qTo";
                if (ra != null) {
                    VC A9f = ra.A9f();
                    if (!L8.A0G(A9f.A0W, A9f.A0R)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean A03() {
        return this.A02 != -9223372036854775807L;
    }

    @Override // com.facebook.ads.redexgen.X.VJ
    @MetaExoPlayerCustomization
    public final void A5O(long j) {
        this.A05.A5O(j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final boolean A5l(long j) {
        return this.A05.A5l(j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final void A6Z(long j, boolean z) {
        this.A05.A6Z(j, z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final long A7R(long j, C1531Pj c1531Pj) {
        if (j == this.A01) {
            return this.A01;
        }
        return this.A05.A7R(j, A00(j, c1531Pj));
    }

    @Override // com.facebook.ads.redexgen.X.VJ
    @MetaExoPlayerCustomization
    public final long A7g(long j) {
        return this.A05.A7g(j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final long A7i() {
        long A7i = this.A05.A7i();
        if (A7i == Long.MIN_VALUE || (this.A00 != Long.MIN_VALUE && A7i >= this.A00)) {
            return Long.MIN_VALUE;
        }
        return A7i;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final long A9E() {
        long A9E = this.A05.A9E();
        if (A9E != Long.MIN_VALUE) {
            if (this.A00 != Long.MIN_VALUE) {
                long j = this.A00;
                if (A06[3].charAt(14) == 'B') {
                    throw new RuntimeException();
                }
                String[] strArr = A06;
                strArr[4] = "xQnkrCD7Wc1JZKFxJsjRaCrFf9eL";
                strArr[0] = "QqNj2pBz7mrHzdsygHykcydjOmZN";
                if (A9E >= j) {
                }
            }
            return A9E;
        }
        return Long.MIN_VALUE;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final RY A9z() {
        return this.A05.A9z();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final void ADJ() throws IOException {
        if (0 == 0) {
            this.A05.ADJ();
            return;
        }
        throw null;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1579Rm
    public final void AGX(InterfaceC1578Rl interfaceC1578Rl) {
        if (0 != 0) {
            return;
        }
        ((InterfaceC1579Rm) AbstractC1437Ln.A01(this.A03)).AGX(this);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final void AII(InterfaceC1579Rm interfaceC1579Rm, long j) {
        this.A03 = interfaceC1579Rm;
        this.A05.AII(this, j);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final long AId() {
        if (A03()) {
            long childDiscontinuityUs = this.A02;
            this.A02 = -9223372036854775807L;
            long initialDiscontinuityUs = AId();
            return initialDiscontinuityUs != -9223372036854775807L ? initialDiscontinuityUs : childDiscontinuityUs;
        }
        long AId = this.A05.AId();
        if (AId == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z = true;
        AbstractC1437Ln.A08(AId >= this.A01);
        long discontinuityUs = this.A00;
        if (discontinuityUs != Long.MIN_VALUE && AId > this.A00) {
            z = false;
        }
        AbstractC1437Ln.A08(z);
        return AId;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    public final void AIk(long j) {
        this.A05.AIk(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0053, code lost:
    
        if (r7 > r10.A00) goto L21;
     */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long AKQ(@MetaExoPlayerCustomization long j, boolean z) {
        this.A02 = -9223372036854775807L;
        boolean z2 = false;
        for (C1581Ro c1581Ro : this.A04) {
            if (c1581Ro != null) {
                c1581Ro.A00();
            }
        }
        long AKQ = this.A05.AKQ(j, z);
        if (AKQ != j) {
            if (AKQ >= this.A01) {
                long j2 = this.A00;
                String[] strArr = A06;
                if (strArr[4].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                A06[2] = "YjAFFIZthIBm8p803KJts";
                if (j2 != Long.MIN_VALUE) {
                }
            }
            AbstractC1437Ln.A08(z2);
            return AKQ;
        }
        z2 = true;
        AbstractC1437Ln.A08(z2);
        return AKQ;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0063, code lost:
    
        if (r7 <= r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d  */
    @Override // com.facebook.ads.redexgen.X.InterfaceC1578Rl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final long AKR(RA[] raArr, boolean[] zArr, VF[] vfArr, boolean[] zArr2, long j) {
        long j2;
        boolean z;
        int i;
        this.A04 = new C1581Ro[vfArr.length];
        VF[] vfArr2 = new VF[vfArr.length];
        int i2 = 0;
        while (true) {
            VF vf = null;
            if (i2 >= vfArr.length) {
                break;
            }
            this.A04[i2] = (C1581Ro) vfArr[i2];
            VF[] childStreams = this.A04;
            if (childStreams[i2] != null) {
                vf = this.A04[i2].A01;
            }
            vfArr2[i2] = vf;
            i2++;
        }
        long AKR = this.A05.AKR(raArr, zArr, vfArr2, zArr2, j);
        if (A03() && j == this.A01 && A02(this.A01, raArr)) {
            j2 = AKR;
        } else {
            j2 = -9223372036854775807L;
        }
        this.A02 = j2;
        if (AKR != j) {
            long enablePositionUs = this.A01;
            if (AKR >= enablePositionUs) {
                long enablePositionUs2 = this.A00;
                if (enablePositionUs2 != Long.MIN_VALUE) {
                    long enablePositionUs3 = this.A00;
                }
            }
            z = false;
            AbstractC1437Ln.A08(z);
            for (i = 0; i < vfArr.length; i++) {
                if (vfArr2[i] == null) {
                    VF[] childStreams2 = this.A04;
                    childStreams2[i] = null;
                } else {
                    VF[] childStreams3 = this.A04;
                    if (childStreams3[i] == null || this.A04[i].A01 != vfArr2[i]) {
                        this.A04[i] = new C1581Ro(this, vfArr2[i]);
                    }
                }
                VF[] childStreams4 = this.A04;
                vfArr[i] = childStreams4[i];
            }
            return AKR;
        }
        z = true;
        AbstractC1437Ln.A08(z);
        while (i < vfArr.length) {
        }
        return AKR;
    }

    @Override // com.facebook.ads.redexgen.X.VJ
    @MetaExoPlayerCustomization
    public final void AKu(boolean z) {
        this.A05.AKu(z);
    }

    @Override // com.facebook.ads.redexgen.X.VJ
    @MetaExoPlayerCustomization
    public final void ALv(byte b) {
        this.A05.ALv(b);
    }
}
