package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.redexgen.X.fl, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C2143fl {
    public static byte[] A05;
    public static String[] A06 = {"jJreqFAWfQsm2UlBXjWleQZy51A8w9r3", "B5vxrqY9e1pfFDILbPSJEQZe5Zep9JAF", "7hwRhDIA2xM98ucsNVPICP0872", "8yYdfjKxcW1uK5E8nS4F9bT", "cwoTvwLLOWGZrFwonmn2qn9xu", "wuc4L", "VoE60CbUCih", "1JGxuEjawtyxaKItdz1AQ1lnM"};
    public C2461kz A00;
    public EnumC2997tm A01 = EnumC2997tm.A06;
    public ArrayList<C1620Tb> A02 = new ArrayList<>();
    public final AbstractC2109fD A03;
    public final InterfaceC2142fk A04;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 96);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A05 = new byte[]{-97, -39, -27, -34, -35, -81, -44, -38, -53, -40, -44, -57, -46, -122, -85, -40, -40, -43, -40, -122, -104, -106, -106, -100, -122, -35, -49, -38, -50, -43, -37, -38, -122, -57, -122, -36, -57, -46, -49, -54, -122, -89, -54, -81, -44, -52, -43, -108, 31, 34, 29, 34, 31, 50, 31, 29, 32, 51, 44, 34, 42, 35, -45, -30, -37, -59, -54, -61, -53, -48, -63, -46, -61, -44, -61, -49, -43, -42, -37, -44, -36, -31, -40, -41, -76, -41, -73, -44, -25, -44, -75, -24, -31, -41, -33, -40, -38, -33, -27, -42, -29, -28, -27, -38, -27, -38, -46, -35, 15, 8, 3, 11, 15, -1, -29, -2};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 11 out of bounds for length 11
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public final void A0J(C1333Hi c1333Hi, EnumSet<CacheFlag> enumSet) {
        if (A0E() == EnumC2670oR.A05) {
            C1423Kz c1423Kz = (C1423Kz) this.A03;
            LA A2y = c1423Kz.A2y();
            if (A0C(c1333Hi, A2y) || A2y == null) {
                return;
            }
            this.A04.AIm();
            A0A(c1333Hi, enumSet, c1423Kz, A2y, 0, this.A04);
            return;
        }
        if (A0C(c1333Hi, (LA) this.A03)) {
            return;
        }
        this.A04.AIm();
        if (A0E() == EnumC2670oR.A0D) {
            A08(c1333Hi, (C10917i) this.A03);
        } else {
            A09(c1333Hi, enumSet, (C10917i) this.A03, -1, this.A04);
        }
    }

    static {
        A06();
    }

    public C2143fl(C1333Hi c1333Hi, C2157fz c2157fz, InterfaceC2142fk interfaceC2142fk, String str) {
        JSONObject dataObject = c2157fz.A03();
        this.A03 = A01(c1333Hi, c2157fz, str, dataObject);
        this.A04 = interfaceC2142fk;
    }

    private AdError A00(C1333Hi c1333Hi, LA la) {
        if (la == null || la.A39().isEmpty()) {
            c1333Hi.A08().ABz(A04(62, 3, 18), AbstractC2501lf.A0Z, new C2502lg(A04(5, 43, 6)));
            return AdError.internalError(AdError.INTERNAL_ERROR_2006);
        }
        return null;
    }

    public static AbstractC2109fD A01(C1333Hi c1333Hi, C2157fz c2157fz, String str, JSONObject jSONObject) {
        AbstractC2109fD abstractC2109fD = null;
        if (jSONObject.has(A04(65, 12, 2))) {
            try {
                abstractC2109fD = C1423Kz.A01(jSONObject, c1333Hi, true);
                abstractC2109fD.A27(true);
                abstractC2109fD.A23(A04(96, 12, 17));
            } catch (JSONException unused) {
            }
        }
        if (abstractC2109fD == null) {
            abstractC2109fD = C10917i.A00(jSONObject, c1333Hi);
        }
        abstractC2109fD.A22(str);
        C2521lz A01 = c2157fz.A01();
        if (A01 != null) {
            abstractC2109fD.A1y(A01.A06());
        }
        return abstractC2109fD;
    }

    private C2461kz A03(C1333Hi c1333Hi) {
        return this.A00 != null ? this.A00 : new C2461kz(c1333Hi);
    }

    private void A08(C1333Hi c1333Hi, C10917i c10917i) {
        C2133fb playableData = c10917i.A32().A0I().A07();
        A0B(playableData != null ? playableData.A0I() : EnumC2997tm.A06);
        KY ky = new KY(this);
        C2461kz c2461kz = new C2461kz(c1333Hi);
        boolean z = C2578mv.A2H(c1333Hi) && C2426kP.A0A(c10917i.A1x());
        if (z) {
            C2426kP unifiedAssetsLoader = new C2426kP(c2461kz, c10917i.A1x(), c10917i.A1c(), c10917i.A1r(), z, new KX(this));
            c2461kz.A0e(new C2607nO(c10917i.A37(), c1333Hi.A0A()));
            unifiedAssetsLoader.A0B();
            return;
        }
        AbstractC2154fw.A02(c1333Hi, c10917i, true, ky);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0094, code lost:
    
        if (r17 != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0096, code lost:
    
        r10 = new com.facebook.ads.redexgen.X.C2457kv(r29.A1Y(), r29.A1r(), r1);
        r10.A04 = true;
        r10.A03 = A04(0, 5, 17);
        r0.A0Y(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x00b2, code lost:
    
        r0.A0d(new com.facebook.ads.redexgen.X.C2459kx(r29.A35().A01(), com.facebook.ads.redexgen.X.C2704p0.A04, com.facebook.ads.redexgen.X.C2704p0.A04, r29.A1r(), A04(96, 12, 17)));
        r16 = r28.contains(com.facebook.ads.CacheFlag.VIDEO);
        r15 = 0;
        r14 = com.facebook.ads.redexgen.X.C2578mv.A33(r27, com.facebook.ads.redexgen.X.C1951cd.A03());
        r13 = r29.A39().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x00f1, code lost:
    
        if (r13.hasNext() == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00f3, code lost:
    
        r3 = r13.next();
        r21 = r3.A0I().A08();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0101, code lost:
    
        if (r21 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0103, code lost:
    
        r9 = new com.facebook.ads.redexgen.X.C2459kx(r21, com.facebook.ads.redexgen.X.AbstractC2150fs.A00(r3.A0I()), com.facebook.ads.redexgen.X.AbstractC2150fs.A01(r3.A0I()), r29.A1r(), A04(96, 12, 17));
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0128, code lost:
    
        if (r15 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x012a, code lost:
    
        r0.A0c(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x01b8, code lost:
    
        r0.A0d(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x012d, code lost:
    
        r12 = r3.A0L().A03().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x013d, code lost:
    
        if (r12.hasNext() == false) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x013f, code lost:
    
        r0.A0d(new com.facebook.ads.redexgen.X.C2459kx(r12.next(), -1, -1, r29.A1r(), A04(96, 12, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0164, code lost:
    
        if (r16 == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0172, code lost:
    
        if (android.text.TextUtils.isEmpty(r3.A0I().A09()) != false) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0174, code lost:
    
        r8 = new com.facebook.ads.redexgen.X.C2457kv(r3.A0I().A09(), r29.A1r(), A04(96, 12, 17), r3.A0I().A06());
        r8.A04 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x019b, code lost:
    
        if (r15 != 0) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x019d, code lost:
    
        if (r17 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x019f, code lost:
    
        if (r14 != false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x01a1, code lost:
    
        r0.A0Y(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x01a4, code lost:
    
        r15 = r15 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x01a8, code lost:
    
        r0.A0b(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01ac, code lost:
    
        if (r17 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01ae, code lost:
    
        if (r14 != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01b0, code lost:
    
        r0.A0Z(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01b4, code lost:
    
        r0.A0a(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x01cd, code lost:
    
        r8 = r29.A1w().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01d9, code lost:
    
        if (r8.hasNext() == false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x01db, code lost:
    
        r0.A0d(new com.facebook.ads.redexgen.X.C2459kx(r8.next().A02(), -1, -1, r29.A1r(), A04(96, 12, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x01fe, code lost:
    
        r8 = r29.A1v();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x020c, code lost:
    
        if (com.facebook.ads.redexgen.X.C2143fl.A06[5].length() == 5) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x020e, code lost:
    
        r2 = r8.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0216, code lost:
    
        if (r2.hasNext() == false) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0218, code lost:
    
        r0.A0d(new com.facebook.ads.redexgen.X.C2459kx(r2.next().A02(), -1, -1, r29.A1r(), A04(96, 12, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0250, code lost:
    
        if (r29.A2D() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x025a, code lost:
    
        if (android.text.TextUtils.isEmpty(r29.A1d()) != false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x025c, code lost:
    
        r0.A0d(new com.facebook.ads.redexgen.X.C2459kx(r29.A1d(), com.facebook.ads.redexgen.X.C1297Fy.A0A, com.facebook.ads.redexgen.X.C1297Fy.A0A, r29.A1r(), A04(96, 12, 17)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x027a, code lost:
    
        com.facebook.ads.redexgen.X.AbstractC2149fr.A00(r29, r0, r1);
        r0.A0X(new com.facebook.ads.redexgen.X.C1407Kh(r26, r27, r17, r29, r31), new com.facebook.ads.redexgen.X.C2454ks(r29.A1r(), r1, r30));
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x023b, code lost:
    
        r7 = com.facebook.ads.redexgen.X.C2143fl.A06;
        r7[1] = "1nyfEMUepOevYMJugZMvnGL65TcEtQKO";
        r7[0] = "8oN0yixDNSHwX0PkZXBy1Qxe5JRM3g8f";
        r2 = r8.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x01c9, code lost:
    
        if (r17 != false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void A09(C1333Hi c1333Hi, EnumSet<CacheFlag> enumSet, LA la, int i, InterfaceC2142fk interfaceC2142fk) {
        boolean isDSL = la.A2Q();
        C2461kz A03 = A03(c1333Hi);
        A03.A0e(new C2607nO(la.A37(), c1333Hi.A0A()));
        boolean z = C2578mv.A2H(c1333Hi) && C2426kP.A0A(la.A1x());
        if (A06[3].length() == 32) {
            throw new RuntimeException();
        }
        A06[5] = "QkQhg";
        if (z) {
            new C2426kP(A03, la.A1x(), la.A1c(), la.A1r(), z, new C1414Ko(this, c1333Hi, isDSL, la, interfaceC2142fk)).A0B();
            return;
        }
        String A04 = A04(96, 12, 17);
        String[] strArr = A06;
        if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
            String[] strArr2 = A06;
            strArr2[1] = "jVhVjw8PHVLop7GyU0UYPYiA56KfUjA6";
            strArr2[0] = "lzrrt2iICm45JkiVqVLOf6p257fg56KP";
        } else {
            String[] strArr3 = A06;
            strArr3[7] = "mMtIDEEqjJJ695eeXDndb9bWh";
            strArr3[4] = "Ebj8lqyUqzLrB8iZ5jF9tO70n";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A(C1333Hi c1333Hi, EnumSet<CacheFlag> enumSet, C1423Kz c1423Kz, LA la, int i, InterfaceC2142fk interfaceC2142fk) {
        A09(c1333Hi, enumSet, la, i, new C1418Ks(this, c1333Hi, la, c1423Kz, i, interfaceC2142fk, enumSet));
    }

    private void A0B(EnumC2997tm enumC2997tm) {
        this.A01 = enumC2997tm;
    }

    private boolean A0C(C1333Hi c1333Hi, LA la) {
        AdError A00 = A00(c1333Hi, la);
        if (A00 != null) {
            InterfaceC2142fk interfaceC2142fk = this.A04;
            String[] strArr = A06;
            if (strArr[1].charAt(24) != strArr[0].charAt(24)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[1] = "Dm6wm58uJ8qXwjtNx8Vtzbsb5Jkw9mit";
            strArr2[0] = "fLwuuFNg4tiwPdo6hP9t6x3v5l5Hcavg";
            interfaceC2142fk.ADk(A00);
            return true;
        }
        return false;
    }

    public final AbstractC2109fD A0D() {
        return this.A03;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a8, code lost:
    
        if (r3 != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b9, code lost:
    
        return com.facebook.ads.redexgen.X.EnumC2670oR.A0D;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b4, code lost:
    
        if (r3 != false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final EnumC2670oR A0E() {
        if (this.A03.A2L()) {
            return EnumC2670oR.A05;
        }
        LA la = (LA) this.A03;
        String[] strArr = A06;
        if (strArr[6].length() != strArr[2].length()) {
            A06[3] = "f4kXngrP8CD5dz";
            if (la.A2Q()) {
                return EnumC2670oR.A07;
            }
            if (la.A39().size() > 1) {
                EnumC2670oR enumC2670oR = EnumC2670oR.A0B;
                String[] strArr2 = A06;
                if (strArr2[7].length() == strArr2[4].length()) {
                    A06[3] = "ny";
                    return enumC2670oR;
                }
            } else {
                if (la.A32().A0I().A07() != null) {
                    boolean A2Z = la.A2Z();
                    String[] strArr3 = A06;
                    if (strArr3[6].length() == strArr3[2].length()) {
                        throw new RuntimeException();
                    }
                    A06[3] = "JH";
                    if (!A2Z) {
                        boolean A2m = la.A2m();
                        if (A06[3].length() != 32) {
                            String[] strArr4 = A06;
                            strArr4[1] = "93R6MUXHMTxUt8WfLt1oZ3ea5zubl3sl";
                            strArr4[0] = "9xXPI1nVQC4CSUB4soKlPH985bh9DAt9";
                        } else {
                            A06[3] = "ySAy4b6nQ";
                        }
                    }
                    return EnumC2670oR.A0F;
                }
                if (A0L(la)) {
                    return EnumC2670oR.A0E;
                }
                return EnumC2670oR.A0C;
            }
        }
        throw new RuntimeException();
    }

    public final EnumC2997tm A0F() {
        return this.A01;
    }

    public final String A0G() {
        if (this.A03.A2L()) {
            return ((C1423Kz) this.A03).A32();
        }
        return ((LA) this.A03).A37();
    }

    public final void A0H() {
        this.A04.ALr();
    }

    public final void A0I(Intent intent, RewardData rewardData, String str) {
        String stringExtra;
        String stringExtra2;
        this.A03.A20(rewardData);
        this.A03.A24(str);
        EnumC2670oR A0E = A0E();
        EnumC2670oR enumC2670oR = EnumC2670oR.A0B;
        String A04 = A04(108, 8, 58);
        if (A0E == enumC2670oR && this.A03.A2k() && (stringExtra2 = intent.getStringExtra(A04)) != null) {
            AbstractC2386jl.A02(stringExtra2, (LA) this.A03);
            return;
        }
        if (A0D().A2L()) {
            if (this.A03.A2l() && (stringExtra = intent.getStringExtra(A04)) != null) {
                AbstractC2387jm.A02(stringExtra, (C1423Kz) this.A03);
                return;
            }
            intent.putExtra(A04(77, 19, 19), this.A03);
        }
        intent.putExtra(A04(48, 14, 94), this.A03);
    }

    public final boolean A0K() {
        return this.A03.A2B();
    }

    public final boolean A0L(LA la) {
        return !TextUtils.isEmpty(la.A32().A0I().A09());
    }
}
