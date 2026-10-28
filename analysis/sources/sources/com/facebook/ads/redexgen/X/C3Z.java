package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* renamed from: com.facebook.ads.redexgen.X.3Z, reason: invalid class name */
/* loaded from: assets/audience_network/classes.dex */
public final class C3Z extends C4H implements InterfaceC1524Ox {
    public static byte[] A0J;
    public static String[] A0K = {"dJ1YV3jThjOwmigxZfa0WIEeV1TCs5d", "hQKoR2s3XjG2tZwsIwpqT2xBbm3fjsKt", "xiXXnVe2lpGRoK7OeNWdVisEgpez07tP", "LSwr", "ihVCdHgoZFWIWG03j", "mJMbvy0sGnDWHltuIsS6w9lBBRVC4B86", "ZAPRWjlsGBrRu8ymN", "xuGgiynb"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public MediaFormat A06;
    public VC A07;
    public PW A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public boolean A0D;
    public final Context A0E;
    public final C1544Qd A0F;
    public final boolean A0G;
    public final boolean A0H;
    public final InterfaceC1555Qo A0I;

    public static String A07(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0J, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 83);
        }
        return new String(copyOfRange);
    }

    public static void A09() {
        A0J = new byte[]{98, 74, 75, 70, 78, 108, 64, 75, 74, 76, 110, 90, 75, 70, 64, 125, 74, 65, 75, 74, 93, 74, 93, 116, 118, 99, 21, 104, 126, 120, 21, 90, 90, 88, 21, 95, 94, 88, 95, 93, 72, 62, 119, Byte.MAX_VALUE, Byte.MAX_VALUE, 119, 124, 117, 62, 98, 113, 103, 62, 116, 117, 115, Byte.MAX_VALUE, 116, 117, 98, 61, 61, 63, 113, 56, 46, 63, 113, 57, 58, 58, 57, 63, 40, 113, 40, 37, 44, 57, 42, 42, 40, 102, 63, 42, 57, 44, 46, 63, 102, 57, 46, 45, 102, 39, 46, 61, 46, 39, 74, 94, 79, 66, 68, 4, 89, 74, 92, 50, 57, 48, 63, 63, 52, 61, 124, 50, 62, 36, 63, 37, 23, 26, 13, 16, 19, 11, 26, 113, 124, 107, 118, 104, 117, 109, 124, 15, 3, 26, 79, 11, 12, 18, 23, 22, 79, 17, 11, 24, 7, 16, 20, 16, 24, 94, 67, 7, 82, 29, 7, 3, 29, 7, 1, 79, 77, 86, 80, 77, 86, 75, 70, 39, 53, 57, 36, 56, 49, 121, 38, 53, 32, 49, 98, 112, 124, 98, 100, Byte.MAX_VALUE, 118, 115, 108, 123, 102, 111, 101, 125, 108};
    }

    static {
        A09();
    }

    public C3Z(Context context, C1716Xc c1716Xc, C1719Xf c1719Xf, TG tg, InterfaceC1587Ru interfaceC1587Ru, boolean z, boolean z2, boolean z3, Handler handler, InterfaceC1545Qe interfaceC1545Qe, QG qg, LZ... lzArr) {
        this(context, c1716Xc, c1719Xf, tg, interfaceC1587Ru, z, z2, z3, handler, interfaceC1545Qe, new SI(qg, lzArr));
    }

    public C3Z(Context context, C1716Xc c1716Xc, C1719Xf c1719Xf, TG tg, InterfaceC1587Ru interfaceC1587Ru, boolean z, boolean z2, boolean z3, Handler handler, InterfaceC1545Qe interfaceC1545Qe, InterfaceC1555Qo interfaceC1555Qo) {
        super(1, c1716Xc, c1719Xf, tg, interfaceC1587Ru, z, false, 0, 0);
        this.A01 = 0;
        this.A02 = 0;
        this.A05 = 0L;
        this.A0E = context.getApplicationContext();
        this.A0I = interfaceC1555Qo;
        this.A0G = z2;
        this.A0H = z3;
        this.A0F = new C1544Qd(handler, interfaceC1545Qe);
        interfaceC1555Qo.AKn(new SG(this));
        interfaceC1555Qo.AKi(c1716Xc.A0E);
    }

    @MetaExoPlayerCustomization
    private int A00() {
        int i = this.A0z.A09;
        if (this.A0z.A0I) {
            int i2 = this.A0z.A03;
            int i3 = this.A0z.A04;
            int xHEAACEffectType = this.A0z.A05;
            return YE.A00(i2, i3, xHEAACEffectType);
        }
        return i;
    }

    public static int A01(VC vc) {
        if (A07(99, 9, 120).equals(vc.A0W)) {
            return vc.A0C;
        }
        return 2;
    }

    private int A02(C1609Sq c1609Sq, VC vc) {
        if (A07(38, 22, 67).equals(c1609Sq.A03) && N1.A02 < 24 && (N1.A02 != 23 || !N1.A18(this.A0E))) {
            return -1;
        }
        return vc.A0B;
    }

    private final int A03(C1609Sq c1609Sq, VC vc, VC[] vcArr) {
        int maxInputSize = A02(c1609Sq, vc);
        return maxInputSize;
    }

    private final MediaFormat A04(VC vc, String str, int i) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(A07(150, 4, 46), str);
        mediaFormat.setInteger(A07(108, 13, 2), vc.A06);
        mediaFormat.setInteger(A07(172, 11, 7), vc.A0G);
        MX.A06(mediaFormat, vc.A0X);
        MX.A04(mediaFormat, A07(136, 14, 49), i);
        if (N1.A02 >= 23) {
            mediaFormat.setInteger(A07(164, 8, 108), 0);
        }
        if (vc.A0R != null && vc.A0R.equals(A07(154, 10, 96)) && this.A0z.A0J) {
            mediaFormat.setInteger(A07(60, 19, 15), A00());
            mediaFormat.setInteger(A07(79, 20, 24), this.A0z.A0A);
        }
        return mediaFormat;
    }

    public static /* synthetic */ PW A05(C3Z c3z) {
        return null;
    }

    private void A08() {
        long A8G = this.A0I.A8G(AB7());
        if (A8G != Long.MIN_VALUE) {
            if (!this.A0A) {
                long newCurrentPositionUs = this.A04;
                A8G = Math.max(newCurrentPositionUs, A8G);
            }
            this.A04 = A8G;
            this.A0A = false;
        }
    }

    private boolean A0A(VC vc) {
        String str = vc.A0W;
        String mimeType = A07(99, 9, 120);
        if (mimeType.equals(str)) {
            return false;
        }
        return this.A0I.ALg(vc);
    }

    public static boolean A0B(String str) {
        if (N1.A02 < 24 && A07(23, 15, 104).equals(str)) {
            if (A07(183, 7, 66).equals(N1.A05) && (N1.A03.startsWith(A07(190, 8, 90)) || N1.A03.startsWith(A07(121, 7, 44)) || N1.A03.startsWith(A07(UserVerificationMethods.USER_VERIFY_PATTERN, 8, 74)))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.AnonymousClass97
    public final void A1X() {
        super.A1X();
        this.A0I.AID();
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.AnonymousClass97
    public final void A1Y() {
        A08();
        this.A0I.pause();
        super.A1Y();
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.AnonymousClass97
    public final void A1Z() {
        try {
            this.A0I.flush();
            try {
                super.A1Z();
            } finally {
            }
        } catch (Throwable th) {
            try {
                super.A1Z();
                throw th;
            } finally {
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.AnonymousClass97
    public final void A1a(long j, boolean z) throws AnonymousClass96 {
        super.A1a(j, z);
        if (this.A0C) {
            this.A0I.A72();
        } else {
            this.A0I.flush();
        }
        this.A04 = j;
        this.A09 = true;
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.AnonymousClass97
    public final void A1b(boolean z, boolean z2) throws AnonymousClass96 {
        super.A1b(z, z2);
        this.A0F.A08(this.A0h);
        if (A1V().A00) {
            this.A0I.A6v();
        } else {
            this.A0I.A6Y();
        }
        this.A0I.AKy(A1W());
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final int A1g(InterfaceC1606Sn interfaceC1606Sn, C1609Sq c1609Sq, VC vc, VC vc2) {
        if (this.A0z.A0U && A02(c1609Sq, vc2) <= this.A00 && c1609Sq.A0U(vc, vc2, true) && vc.A08 == 0 && vc.A09 == 0 && vc2.A08 == 0 && vc2.A09 == 0) {
            return 1;
        }
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        if (r2.ALi(r1, r12.A0C) != false) goto L21;
     */
    @Override // com.facebook.ads.redexgen.X.C4H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int A1h(TG tg, InterfaceC1587Ru interfaceC1587Ru, VC vc) throws TK {
        int i;
        String str = vc.A0W;
        int adaptiveSupport = 0;
        if (!L8.A0C(str)) {
            return 0;
        }
        int i2 = N1.A02 >= 21 ? 32 : 0;
        boolean A1G = C4H.A1G(vc);
        int i3 = 4;
        if (A1G && A0A(vc) && TN.A0I() != null) {
            return i2 | 8 | 4;
        }
        String mimeType = A07(99, 9, 120);
        if (mimeType.equals(str)) {
            InterfaceC1555Qo interfaceC1555Qo = this.A0I;
            int tunnelingSupport = vc.A06;
        }
        if (this.A0I.ALi(vc.A06, 2)) {
            List<C1609Sq> A1l = A1l(tg, vc, false);
            if (A1l.isEmpty()) {
                return PX.A00(1);
            }
            if (!A1G) {
                return PX.A00(2);
            }
            C1609Sq c1609Sq = A1l.get(0);
            if (N1.A02 < 21 || ((vc.A0G == -1 || c1609Sq.A0Q(vc.A0G)) && (vc.A06 == -1 || c1609Sq.A0P(vc.A06)))) {
                adaptiveSupport = 1;
            }
            if (adaptiveSupport != 0 && c1609Sq.A0T(vc)) {
                i = 16;
            } else {
                i = 8;
            }
            if (adaptiveSupport == 0) {
                i3 = 3;
            }
            return i | i2 | i3;
        }
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0039, code lost:
    
        if (r3 != false) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003b, code lost:
    
        r0 = com.facebook.ads.redexgen.X.TN.A0I();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003f, code lost:
    
        if (r0 == null) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0041, code lost:
    
        r3 = java.util.Collections.singletonList(r0);
        r0 = com.facebook.ads.redexgen.X.C3Z.A0K[3];
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0050, code lost:
    
        if (r0.length() == 19) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
    
        com.facebook.ads.redexgen.X.C3Z.A0K[0] = "wzAq8m9B4I3i9ifDjepFX8ivHYW1Clz";
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0064, code lost:
    
        r2 = com.facebook.ads.redexgen.X.C3Z.A0K;
        r2[2] = "SdIYnzIVnDGBOVLyaHZ6DsfwYGmLymel";
        r2[1] = "h3QOruHZ6rG9P1RQjfureWnYKyouTutT";
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0070, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x007c, code lost:
    
        return java.util.Collections.unmodifiableList(r5.A8P(r6.A0W, r7, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        if (r3 != false) goto L13;
     */
    @Override // com.facebook.ads.redexgen.X.C4H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<C1609Sq> A1l(TG tg, VC vc, boolean z) throws TK {
        String mimeType = vc.A0W;
        if (mimeType == null) {
            List<C1609Sq> emptyList = Collections.emptyList();
            String[] strArr = A0K;
            String str = strArr[4];
            String mimeType2 = strArr[6];
            if (str.length() != mimeType2.length()) {
                throw new RuntimeException();
            }
            A0K[7] = "Pcas";
            return emptyList;
        }
        boolean A0A = A0A(vc);
        String mimeType3 = A0K[0];
        if (mimeType3.length() == 31) {
            A0K[7] = "JffLfi0vHy3seiOp3go0b68";
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final void A1o() throws AnonymousClass96 {
        try {
            this.A0I.AIF();
        } catch (C1554Qn e) {
            throw A1T(e, e.A01, e.A02, 5002);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final void A1s(VC vc) throws AnonymousClass96 {
        super.A1s(vc);
        this.A07 = vc;
        this.A0F.A05(this.A07, null);
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final void A1u(T2 t2) {
        if (this.A09 && !t2.A04()) {
            long j = t2.A01;
            if (A0K[0].length() == 31) {
                String[] strArr = A0K;
                strArr[2] = "SvawHhH1x8GbPGYUd1Y93MPn0ACiLicP";
                strArr[1] = "6uHIbcitojGzvCSlo3fyQ1WMRiEqRzHo";
                if (Math.abs(j - this.A04) > 500000) {
                    long j2 = t2.A01;
                    String[] strArr2 = A0K;
                    if (strArr2[4].length() == strArr2[6].length()) {
                        String[] strArr3 = A0K;
                        strArr3[2] = "17kJanhEdfGiqUZJVBg8atWLh4Sw2avR";
                        strArr3[1] = "vy2AT52lYTGJeQ2NFQyQo8ExJNUAUNN6";
                        this.A04 = j2;
                    }
                }
                if (A0K[7].length() == 24) {
                    throw new RuntimeException();
                }
                A0K[7] = "8wBdcseJYz9EbvVXqSDskBqQX";
                this.A09 = false;
                return;
            }
            throw new RuntimeException();
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:12:0x004e */
    @Override // com.facebook.ads.redexgen.X.C4H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A1v(InterfaceC1606Sn interfaceC1606Sn, MediaFormat mediaFormat) throws AnonymousClass96 {
        int i;
        MediaFormat mediaFormat2;
        int[] iArr;
        if (this.A06 != null) {
            i = L8.A00(this.A06.getString(A07(150, 4, 46)));
            mediaFormat2 = this.A06;
        } else {
            i = A01(this.A07);
            mediaFormat2 = mediaFormat;
        }
        String A07 = A07(108, 13, 2);
        int channelCount = mediaFormat2.getInteger(A07);
        String A072 = A07(172, 11, 7);
        int encoding = mediaFormat2.getInteger(A072);
        this.A03 = encoding * channelCount;
        try {
            if (this.A0B && channelCount == 6) {
                int encoding2 = this.A07.A06;
                if (encoding2 < 6) {
                    int encoding3 = this.A07.A06;
                    iArr = new int[encoding3];
                    for (int i2 = 0; i2 < encoding; i2++) {
                        iArr[i2] = i2;
                    }
                    C1404Ke A0i = new C1404Ke().A11(A07(99, 9, 120)).A0i(i);
                    int encoding4 = mediaFormat.getInteger(A07);
                    C1404Ke A0b = A0i.A0b(encoding4);
                    int encoding5 = mediaFormat.getInteger(A072);
                    VC audioSinkInputFormat = A0b.A0m(encoding5).A14();
                    this.A0I.A5i(audioSinkInputFormat, 0, iArr);
                    return;
                }
            }
            this.A0I.A5i(audioSinkInputFormat, 0, iArr);
            return;
        } catch (C1548Qh e) {
            throw A1S(e, e.A00, 5001);
        }
        iArr = null;
        C1404Ke A0i2 = new C1404Ke().A11(A07(99, 9, 120)).A0i(i);
        int encoding42 = mediaFormat.getInteger(A07);
        C1404Ke A0b2 = A0i2.A0b(encoding42);
        int encoding52 = mediaFormat.getInteger(A072);
        VC audioSinkInputFormat2 = A0b2.A0m(encoding52).A14();
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final void A1w(C1609Sq c1609Sq, InterfaceC1606Sn interfaceC1606Sn, VC vc, MediaCrypto mediaCrypto) {
        this.A00 = A03(c1609Sq, vc, A1e());
        this.A0B = A0B(c1609Sq.A03);
        String str = c1609Sq.A02;
        String A07 = A07(99, 9, 120);
        this.A0D = A07.equals(str) && !A07.equals(vc.A0W);
        MediaFormat A04 = A04(vc, c1609Sq.A01, this.A00);
        interfaceC1606Sn.A5h(A04, null, mediaCrypto, 0, null);
        if (this.A0D) {
            this.A06 = A04;
            this.A06.setString(A07(150, 4, 46), vc.A0W);
        } else {
            this.A06 = null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    @MetaExoPlayerCustomization
    public final void A1x(String str) {
        this.A0F.A0F(str);
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    public final void A1y(String str, long j, long j2) {
        this.A0F.A0G(str, j, j2);
    }

    @Override // com.facebook.ads.redexgen.X.C4H
    @MetaExoPlayerCustomization
    public final boolean A22() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0088, code lost:
    
        if (r9 == 2) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008a, code lost:
    
        if (r22 != 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
    
        if (r14.A03 <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009b, code lost:
    
        if ((r20.limit() - r20.position()) < 12) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
    
        r10 = r20.position();
        r3 = r20.limit();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b2, code lost:
    
        if (com.facebook.ads.redexgen.X.C3Z.A0K[0].length() == 31) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b9, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c4, code lost:
    
        com.facebook.ads.redexgen.X.C3Z.A0K[5] = "T4Ha6vahPkn7JLf1kooUxHz23Qk1EB7y";
        r20.position(10);
        r9 = r20.getShort();
        r20.position(r10);
        r20.limit(r3);
        r2 = r14.A01;
        r1 = r20.limit();
        r0 = r20.position();
        r14.A01 = r2 + (r1 - r0);
        r0 = r14.A02;
        r14.A02 = r0 + 1;
        r2 = r14.A05;
        r0 = java.lang.Math.abs(r9);
        r14.A05 = r2 + r0;
        r1 = r14.A01;
        r0 = r14.A03;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00fb, code lost:
    
        if (r1 < (r0 * 2)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00fd, code lost:
    
        r9 = r14.A0F;
        r2 = r14.A05;
        r0 = r14.A02;
        r9.A00((int) (r2 / r0));
        r14.A01 = 0;
        r14.A02 = 0;
        r14.A05 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c1, code lost:
    
        if (r9 == 2) goto L24;
     */
    @Override // com.facebook.ads.redexgen.X.C4H
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean A23(long j, long j2, InterfaceC1606Sn interfaceC1606Sn, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z, boolean z2) throws AnonymousClass96 {
        if (this.A0D && (i2 & 2) != 0) {
            interfaceC1606Sn.AIw(i, false);
            String[] strArr = A0K;
            if (strArr[2].charAt(10) == strArr[1].charAt(10)) {
                A0K[7] = "SOFul";
                return true;
            }
        } else if (z) {
            interfaceC1606Sn.AIw(i, false);
            this.A0h.A0B++;
            InterfaceC1555Qo interfaceC1555Qo = this.A0I;
            String[] strArr2 = A0K;
            if (strArr2[2].charAt(10) == strArr2[1].charAt(10)) {
                A0K[7] = "dm9Z";
                interfaceC1555Qo.AAL();
                return true;
            }
        } else {
            if (this.A0H) {
                int valuePosition = A01(this.A07);
                if (A0K[0].length() != 31) {
                    String[] strArr3 = A0K;
                    strArr3[4] = "0sbBAAcGvWGKMA8r4";
                    strArr3[6] = "5rO2opBK86KQihg1G";
                } else {
                    A0K[5] = "DybQt325eBIiRLQUNvPK7uVyMMMzVB4X";
                }
            }
            if (this.A0G) {
                int limit = byteBuffer.limit();
                int originalPosition = byteBuffer.position();
                if (limit > originalPosition) {
                    int position = byteBuffer.position();
                    int limit2 = byteBuffer.limit();
                    int originalPosition2 = limit2 - position;
                    ByteBuffer allocate = ByteBuffer.allocate(originalPosition2);
                    allocate.put(byteBuffer);
                    allocate.flip();
                    byteBuffer.position(position);
                    byteBuffer.limit(limit2);
                    C1544Qd c1544Qd = this.A0F;
                    byte[] array = allocate.array();
                    long j4 = j3 / 1000;
                    if (A0K[5].charAt(29) != 'B') {
                        String[] strArr4 = A0K;
                        strArr4[4] = "j1VYMrRVdKYDgwGLl";
                        strArr4[6] = "b8eXuv6yHVusngmMs";
                        c1544Qd.A0K(array, j4);
                    } else {
                        A0K[0] = "goZfJfG4UP4V3eYdjCcrhPCvumv5bJg";
                        c1544Qd.A0K(array, j4);
                    }
                }
            }
            try {
                if (!this.A0I.AAI(byteBuffer, j3, 1)) {
                    return false;
                }
                interfaceC1606Sn.AIw(i, false);
                this.A0h.A09++;
                return true;
            } catch (C1549Qi e) {
                throw A1T(e, this.A07, e.A02, 5001);
            } catch (C1554Qn e2) {
                throw A1T(e2, this.A0g, e2.A02, 5002);
            }
        }
        throw new RuntimeException();
    }

    public final void A26() {
        this.A0A = true;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass97, com.facebook.ads.redexgen.X.InterfaceC1599Sg
    public final InterfaceC1524Ox A95() {
        return this;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1524Ox
    public final UW A9P() {
        return this.A0I.A9P();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1524Ox
    public final long A9S() {
        if (A9n() == 2) {
            A08();
        }
        return this.A04;
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass97, com.facebook.ads.redexgen.X.PR
    public final void AAM(int i, Object obj) throws AnonymousClass96 {
        switch (i) {
            case 2:
                this.A0I.setVolume(((Float) obj).floatValue());
                break;
            case 3:
                this.A0I.AKY((VL) obj);
                break;
            case 4:
            case 5:
            case 7:
            case 8:
            default:
                super.AAM(i, obj);
                break;
            case 6:
                this.A0I.AKa((C1390Jq) obj);
                break;
            case 9:
                this.A0I.AL6(((Boolean) obj).booleanValue());
                break;
            case 10:
                this.A0I.AKZ(((Integer) obj).intValue());
                break;
            case 11:
                this.A08 = null;
                break;
            case 12:
                if (N1.A02 >= 23) {
                    RG.A00(this.A0I, obj);
                    break;
                }
                break;
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.InterfaceC1599Sg
    public final boolean AB7() {
        return super.AB7() && this.A0I.AB7();
    }

    @Override // com.facebook.ads.redexgen.X.C4H, com.facebook.ads.redexgen.X.InterfaceC1599Sg
    public final boolean ABM() {
        return this.A0I.AAS() || super.ABM();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1524Ox
    public final void AKv(UW uw) {
        this.A0I.AKv(uw);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1599Sg, com.facebook.ads.redexgen.X.InterfaceC1528Pe
    public final String getName() {
        return A07(0, 23, 124);
    }
}
