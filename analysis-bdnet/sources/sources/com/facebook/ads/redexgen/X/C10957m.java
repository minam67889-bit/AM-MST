package com.facebook.ads.redexgen.X;

import android.content.ContentResolver;
import android.content.Intent;
import android.provider.Settings;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.activity.ActivityUtils;
import com.facebook.ads.internal.util.activity.AdActivityIntent;
import com.facebook.ads.internal.util.process.ProcessUtils;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.metrics.ScopedSysTraceEvent;

/* renamed from: com.facebook.ads.redexgen.X.7m, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C10957m extends LG {
    public static C2461kz A0D;
    public static byte[] A0E;
    public static String[] A0F = {"YJVWhBFSVFKs7NrWmWULGh", "0GvTyPfIpVaCupDTXIuhVv", "vKmpQ0k2zgunQxdAFsx7Wlk6dmYtSCUc", "dqRYVPDeGy45RCRFCWIUPRHRtp9NBigI", "NSweCua6lZ8ChPFZ3cKnaOBscLcsrWLc", "HenZyTRrHhMHTWT00jKprDJGPW9d4C4V", "lvvcgtkpn6JHhS0LrJ19j3FN0lJsZZOv", "GmBDkEWrzwPugE8SLtTHysECIxUFQGpg"};
    public long A00;
    public InterfaceC2102f6 A01;
    public C2103f7 A02;
    public AbstractC2109fD A03;
    public C1333Hi A04;
    public EnumC2670oR A05;
    public C1620Tb A06;
    public String A07;
    public String A08;
    public String A09;
    public String A0A;
    public final String A0B = UUID.randomUUID().toString();
    public final AtomicBoolean A0C = new AtomicBoolean();

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 126);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0E = new byte[]{56, 52, 54, 54, 48, 57, 48, 39, 58, 56, 48, 33, 48, 39, 10, 39, 58, 33, 52, 33, 60, 58, 59, 108, 99, 82, 108, 110, 121, 100, 123, 100, 121, 116, 9, 2, 11, 3, 4, 15, 14, 43, 14, 46, 11, 30, 11, 40, 31, 4, 14, 6, 15, 68, 76, 77, 64, 72, 93, 64, 70, 71, 109, 72, 93, 72, 12, 16, 29, 31, 25, 17, 25, 18, 8, 53, 24, 87, 85, 66, 67, 66, 65, 78, 73, 66, 67, 104, 85, 78, 66, 73, 83, 70, 83, 78, 72, 73, 108, 66, 94, 4, 19, 7, 3, 19, 5, 2, 34, 31, 27, 19, 104, Byte.MAX_VALUE, 109, 123, 104, 126, 73, Byte.MAX_VALUE, 104, 108, Byte.MAX_VALUE, 104, 79, 72, 86, 25, 14, 28, 10, 25, 15, 14, 15, 61, 2, 15, 14, 4, 42, 15, 47, 10, 31, 10, 41, 30, 5, 15, 7, 14, 87, 64, 82, 68, 87, 65, 64, 65, 122, 83, 76, 65, 64, 74, 124, 103, 96, 120, 124, 108, 64, 109, 83, 76, 64, 82, 113, 92, 85, 64};
    }

    static {
        A09();
    }

    private void A07() {
        C2215gw.A00(this.A04).A06(this.A02, this.A02.A00());
    }

    private void A08() {
        if (this.A02 != null) {
            try {
                C2215gw.A00(this.A04).A05(this.A02);
            } catch (Exception unused) {
            }
        }
    }

    private void A0A(Intent intent) {
        int i = super.A00;
        String A05 = A05(77, 24, 89);
        if (i != -1) {
            ContentResolver contentResolver = this.A04.getContentResolver();
            if (A0F[3].charAt(29) != 'i') {
                throw new RuntimeException();
            }
            String[] strArr = A0F;
            strArr[7] = "ryaiaZaF8EzuUPZd67FeoIG9jUALGHZG";
            strArr[6] = "XITZtpYy2wf6QHmOozCOnY6Xlkm3ca51";
            if (Settings.System.getInt(contentResolver, A05(1, 22, 43), 0) != 1) {
                int i2 = super.A00;
                if (A0F[2].charAt(2) != 'm') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0F;
                strArr2[1] = "mo2n49jFbf8CHvb7nubztA";
                strArr2[0] = "3h0LYrxRFByrgEG7Z48zJG";
                intent.putExtra(A05, i2);
                return;
            }
        }
        if (!C2578mv.A0f(this.A04)) {
            intent.putExtra(A05, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(final C1333Hi c1333Hi, final C1423Kz c1423Kz, final int i) {
        if (i >= c1423Kz.A2v()) {
            return;
        }
        final C10897g c10897g = (C10897g) c1423Kz.A2z(i);
        A0D = new C2461kz(c1333Hi);
        A0D.A0e(new C2607nO(c10897g.A37(), c1333Hi.A0A()));
        if (c10897g.A39().size() > 1) {
            AbstractC2155fx.A03(c1333Hi, A0D, c10897g);
        } else {
            AbstractC2155fx.A02(c1333Hi, A0D, c10897g);
        }
        final boolean z = i == 0;
        A0D.A0X(new KM(z) { // from class: com.facebook.ads.redexgen.X.7n
            @Override // com.facebook.ads.redexgen.X.KM
            public final void A00() {
                InterfaceC2102f6 interfaceC2102f6;
                interfaceC2102f6 = C10957m.this.A01;
                interfaceC2102f6.AGw(C10957m.this, AdError.CACHE_ERROR);
            }

            @Override // com.facebook.ads.redexgen.X.KM
            public final void A01(boolean z2) {
                AtomicBoolean atomicBoolean;
                InterfaceC2102f6 interfaceC2102f6;
                C10957m.A0D = null;
                if (z2) {
                    c1333Hi.A01().AKW(c10897g.A37(), c1423Kz.A30());
                }
                if (i == c1423Kz.A2x()) {
                    atomicBoolean = C10957m.this.A0C;
                    atomicBoolean.set(true);
                    interfaceC2102f6 = C10957m.this.A01;
                    interfaceC2102f6.AGt(C10957m.this);
                }
                C10957m.this.A0C(c1333Hi, c1423Kz, i + 1);
            }
        }, new C2454ks(c10897g.A1r(), A05(152, 14, 91), i));
    }

    private void A0D(boolean z) {
        if (this.A05 == EnumC2670oR.A0H) {
            A0F(z);
            return;
        }
        EnumC2670oR enumC2670oR = this.A05;
        String[] strArr = A0F;
        if (strArr[1].length() != strArr[0].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[4] = "1yOiFacRiwJanRzqDJ6A5hJ77lYfziAe";
        strArr2[5] = "McEelBumOV7dKb1zb6BdvUT5HG6VvrgI";
        if (enumC2670oR == EnumC2670oR.A0I) {
            C1333Hi c1333Hi = this.A04;
            C10897g c10897g = (C10897g) this.A03;
            InterfaceC2102f6 interfaceC2102f6 = this.A01;
            if (A0F[2].charAt(2) != 'm') {
                String[] strArr3 = A0F;
                strArr3[4] = "iuhCbiYTMBJ6bSiVa8laVFn7PspsTGXh";
                strArr3[5] = "G6DDtB1lS5Mkt2kKUdjWlkRFPy2AJN8W";
                AbstractC2101f5.A02(c1333Hi, c10897g, interfaceC2102f6, this.A0C, this);
                return;
            }
            A0F[3] = "ILTFu289iGTDK30YJZ974PSb1jdVwigU";
            AbstractC2101f5.A02(c1333Hi, c10897g, interfaceC2102f6, this.A0C, this);
            return;
        }
        if (this.A05 == EnumC2670oR.A0K) {
            A0G(z);
        } else if (this.A05 == EnumC2670oR.A0J) {
            A0E(z);
        } else {
            A0G(z);
        }
    }

    private void A0E(boolean z) {
        C2461kz c2461kz = new C2461kz(this.A04);
        boolean z2 = C2578mv.A2H(this.A04) && C2426kP.A0A(this.A03.A1x());
        if (z2) {
            C2426kP c2426kP = new C2426kP(c2461kz, this.A03.A1x(), this.A03.A1c(), this.A03.A1r(), z2, new LT(this));
            c2461kz.A0e(new C2607nO(((LA) this.A03).A37(), this.A04.A0A()));
            c2426kP.A0B();
            return;
        }
        AbstractC2154fw.A02(this.A04, (LA) this.A03, z, new LR(this));
    }

    private void A0F(boolean z) {
        C2461kz c2461kz = new C2461kz(this.A04);
        c2461kz.A0e(new C2607nO(((LA) this.A03).A37(), this.A04.A0A()));
        AbstractC2155fx.A03(this.A04, c2461kz, (C10897g) this.A03);
        c2461kz.A0X(new C1430Lg(this), new C2454ks(this.A03.A1r(), A05(152, 14, 91)));
    }

    private void A0G(boolean z) {
        boolean z2 = false;
        if (this.A03.A2L()) {
            C1423Kz c1423Kz = (C1423Kz) this.A03;
            for (int i = 0; i < c1423Kz.A2v(); i++) {
                if (!A0H(c1423Kz.A2z(i))) {
                    this.A01.AGw(this, AdError.INTERNAL_ERROR);
                    return;
                }
            }
            A0C(this.A04, c1423Kz, 0);
            return;
        }
        C2461kz c2461kz = new C2461kz(this.A04);
        c2461kz.A0e(new C2607nO(((LA) this.A03).A37(), this.A04.A0A()));
        if (C2578mv.A2H(this.A04) && C2426kP.A0A(this.A03.A1x())) {
            z2 = true;
        }
        boolean A2Q = this.A03.A2Q();
        if (z2) {
            C2426kP unifiedAssetsLoader = new C2426kP(c2461kz, this.A03.A1x(), this.A03.A1c(), this.A03.A1r(), z2, new C1428Le(this, A2Q));
            unifiedAssetsLoader.A0B();
            return;
        }
        C10897g c10897g = (C10897g) this.A03;
        if (TextUtils.isEmpty(c10897g.A32().A0I().A09())) {
            if (this.A05 == EnumC2670oR.A0L) {
                this.A04.A0F().AFT();
            }
            this.A01.AGw(this, AdError.INTERNAL_ERROR);
        } else {
            AbstractC2155fx.A02(this.A04, c2461kz, c10897g);
            c2461kz.A0X(new C10977o(this, z, A2Q, c10897g, this), new C2454ks(c10897g.A1r(), A05(152, 14, 91)));
        }
    }

    private boolean A0H(LA la) {
        boolean isCarouselAd = la.A39().size() > 1;
        if (isCarouselAd) {
            return true;
        }
        boolean isEmpty = TextUtils.isEmpty(la.A32().A0I().A09());
        if (A0F[3].charAt(29) != 'i') {
            throw new RuntimeException();
        }
        A0F[3] = "kjF6g6ww3qDDyel7svnLAojonSzXQi6O";
        if (isEmpty) {
            boolean isCarouselAd2 = TextUtils.isEmpty(la.A32().A0I().A08());
            if (isCarouselAd2) {
                return false;
            }
        }
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.LG
    public final int A0I() {
        if (this.A03 != null) {
            return this.A03.A1M();
        }
        String[] strArr = A0F;
        if (strArr[4].charAt(5) == strArr[5].charAt(5)) {
            throw new RuntimeException();
        }
        A0F[3] = "zy8kAWNFspHhc9OUOOhBHMIK4AaCMilm";
        return -1;
    }

    @Override // com.facebook.ads.redexgen.X.LG
    public final AbstractC2109fD A0J() {
        return this.A03;
    }

    @Override // com.facebook.ads.redexgen.X.LG
    public final boolean A0K() {
        if (!this.A0C.get()) {
            return false;
        }
        this.A03.A1z(super.A01);
        String A04 = C2189gV.A04(super.A02, this.A0B, this.A07);
        this.A03.A20(super.A02);
        this.A03.A24(A04);
        AdActivityIntent A06 = C2712p8.A06(this.A04);
        A06.putExtra(A05(174, 8, 91), this.A05);
        if (this.A05 == EnumC2670oR.A0H && this.A03.A2k()) {
            AbstractC2386jl.A02(this.A0B, (LA) this.A03);
        } else {
            EnumC2670oR enumC2670oR = this.A05;
            EnumC2670oR enumC2670oR2 = EnumC2670oR.A06;
            String[] strArr = A0F;
            if (strArr[1].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[1] = "L0ou65zbaEHIK9W1EiRqjH";
            strArr2[0] = "MlzKsAmmQguOmiSj0COpPP";
            if (enumC2670oR == enumC2670oR2 && this.A03.A2l()) {
                AbstractC2387jm.A02(this.A0B, (C1423Kz) this.A03);
            } else {
                A06.putExtra(A05(ScopedSysTraceEvent.MAX_SECTION_NAME_LEN, 25, 21), this.A03);
                A06.putExtra(A05(34, 19, 20), this.A03);
            }
        }
        A06.putExtra(A05(166, 8, 119), this.A0B);
        if (A04 != null) {
            A06.putExtra(A05(112, 15, 100), A04);
        }
        A06.putExtra(A05(66, 11, 2), this.A0A);
        A06.putExtra(A05(101, 11, 8), this.A00);
        if (this.A09 != null) {
            A06.putExtra(A05(53, 13, 87), this.A09);
        }
        A0A(A06);
        if (!ProcessUtils.isRemoteRenderingProcess()) {
            A06.setFlags(A06.getFlags() | 268435456);
        }
        ActivityUtils.A03(this.A04);
        try {
            if (ProcessUtils.isRemoteRenderingProcess()) {
                if (!C2712p8.A0K(this.A04, A06)) {
                    this.A04.A0F().AJQ();
                    if (this.A01 != null) {
                        this.A01.AGw(this, AdError.AD_PRESENTATION_ERROR);
                    }
                    return false;
                }
                return true;
            }
            C2712p8.A0D(this.A04, A06);
            return true;
        } catch (C2710p6 e) {
            if (this.A05 == EnumC2670oR.A0H && this.A03.A2k()) {
                AbstractC2386jl.A01(this.A0B);
            }
            if (this.A05 == EnumC2670oR.A06 && this.A03.A2l()) {
                AbstractC2387jm.A01(this.A0B);
            }
            Throwable cause = e.getCause();
            Throwable th = e;
            if (cause != null) {
                th = e.getCause();
            }
            this.A04.A08().ABz(A05(23, 11, 115), AbstractC2501lf.A01, new C2502lg(th));
            return true;
        }
    }

    public final void A0L(C1333Hi c1333Hi, InterfaceC2102f6 interfaceC2102f6, C2157fz c2157fz, boolean z, String str, String str2) {
        this.A0C.set(false);
        this.A04 = c1333Hi;
        this.A01 = interfaceC2102f6;
        this.A0A = c2157fz.A02();
        this.A00 = c2157fz.A00();
        this.A09 = str2;
        this.A07 = this.A0A != null ? this.A0A.split(A05(0, 1, 25))[0] : A05(0, 0, 20);
        this.A03 = AbstractC2109fD.A0H(c2157fz.A03(), this.A04);
        this.A03.A22(str);
        this.A03.A1y(c2157fz.A01().A06());
        if (this.A03.A2L()) {
            this.A08 = ((C1423Kz) this.A03).A32();
        } else {
            this.A08 = ((LA) this.A03).A37();
        }
        boolean A2Q = this.A03.A2Q();
        String[] strArr = A0F;
        if (strArr[7].charAt(31) == strArr[6].charAt(31)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0F;
        strArr2[7] = "T6UzDEu82kzY1KsvV3iHB7OkWnIxnMBs";
        strArr2[6] = "PWXGgNcAlDXPEXP1mMx0dPQCA8p68UI5";
        if (A2Q) {
            this.A05 = EnumC2670oR.A09;
            if (this.A03.A2B()) {
                this.A04.A0F().ALB(EnumC2026dr.A08);
            } else {
                this.A04.A0F().ALB(EnumC2026dr.A0A);
            }
        } else {
            switch (this.A03.A1L()) {
                case 0:
                    this.A05 = EnumC2670oR.A0K;
                    this.A04.A0F().ALB(EnumC2026dr.A0D);
                    break;
                case 1:
                    this.A05 = EnumC2670oR.A0J;
                    this.A04.A0F().ALB(EnumC2026dr.A0C);
                    break;
                case 2:
                    this.A05 = EnumC2670oR.A06;
                    this.A04.A0F().ALB(EnumC2026dr.A04);
                    break;
                case 3:
                    this.A05 = EnumC2670oR.A0H;
                    this.A04.A0F().ALB(EnumC2026dr.A03);
                    break;
                case 4:
                    this.A05 = EnumC2670oR.A0L;
                    C1333Hi c1333Hi2 = this.A04;
                    String[] strArr3 = A0F;
                    String str3 = strArr3[7];
                    String str4 = strArr3[6];
                    int experienceType = str3.charAt(31);
                    if (experienceType != str4.charAt(31)) {
                        String[] strArr4 = A0F;
                        strArr4[7] = "FFkeuuVk1meHqgTyMiNT7tgr8739x7mc";
                        strArr4[6] = "JwuXN3bqyC9CcnquHiHDyzq7R0rb3kLZ";
                        c1333Hi2.A0F().ALB(EnumC2026dr.A0E);
                        break;
                    } else {
                        String[] strArr5 = A0F;
                        strArr5[7] = "QuYSy7nqZhyT9avsyztjWhd8F7hW1wjU";
                        strArr5[6] = "5b6UXiMlNaCol2aZqv4zpvCfEMtgCuxD";
                        c1333Hi2.A0F().ALB(EnumC2026dr.A0E);
                        break;
                    }
                case 5:
                    if (!C2578mv.A1H(c1333Hi)) {
                        this.A01.AGw(this, AdError.INTERNAL_ERROR);
                        return;
                    }
                    this.A05 = EnumC2670oR.A0I;
                    this.A04.A0F().ALB(EnumC2026dr.A0B);
                    if (this.A03.A2o()) {
                        AbstractC2109fD abstractC2109fD = this.A03;
                        int experienceType2 = A0F[3].charAt(29);
                        if (experienceType2 != 105) {
                            A0F[3] = "i1vVIMuEE2CogviWDEosGc55NgD83ibP";
                            abstractC2109fD.A26(true);
                            break;
                        } else {
                            A0F[2] = "e7mQJdX4ST7JevLzoIctPRomcGPYY6Su";
                            abstractC2109fD.A26(true);
                            break;
                        }
                    }
                    break;
            }
        }
        if (C2578mv.A0u(c1333Hi)) {
            if (this.A03.A2L()) {
                C1423Kz c1423Kz = (C1423Kz) this.A03;
                for (int A2v = c1423Kz.A2v() - 1; A2v >= 0; A2v--) {
                    LA A2z = c1423Kz.A2z(A2v);
                    if (AbstractC2080ej.A06(this.A04, AbstractC2080ej.A01(c1333Hi, A2z.A1x(), A2z.A37()), c1333Hi.A0A())) {
                        this.A04.A0F().A5b();
                        c1423Kz.A34(A2v);
                        return;
                    }
                }
                if (c1423Kz.A2v() == 0) {
                    this.A01.AGw(this, AdError.NO_FILL);
                    return;
                }
            } else if (AbstractC2080ej.A06(this.A04, AbstractC2080ej.A01(c1333Hi, c2157fz.A03(), ((LA) this.A03).A37()), c1333Hi.A0A())) {
                this.A04.A0F().A5b();
                this.A01.AGw(this, AdError.NO_FILL);
                return;
            }
        }
        this.A02 = new C2103f7(this.A0B, this, interfaceC2102f6);
        A07();
        A0D(z);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2083en
    public final String A7z() {
        return this.A08;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2083en
    public final boolean ALe() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC2083en
    public final void onDestroy() {
        A08();
    }
}
