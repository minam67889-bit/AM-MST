package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Point;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.redexgen.X.8h, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C11148h extends R9 {
    public static byte[] A07;
    public static String[] A08 = {"N3ZG1EAeWs47seL3n7lh4Wuuxpt5dQ9S", "oZrngbnpXdb0MQsdT0zVvrp", "Fim13Buiqg0QqQi", "NCw8HvhGeegFdSJV0JTkOh", "1Y8AJD0wDjMc9jtVVPnZ14pSQIsLBm5S", "5vnPQraei", "qi33", "eVlKumeRx"};
    public static final AbstractC1669Vc<Integer> A09;
    public static final AbstractC1669Vc<Integer> A0A;
    public VL A00;
    public C11158i A01;
    public WR A02;
    public final Context A03;
    public final WY A04;
    public final Object A05;
    public final boolean A06;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008b A[SYNTHETIC] */
    @MetaExoPlayerCustomization
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <T extends WT<T>> Pair<WX, Integer> A0A(int i, C1691Wa c1691Wa, int[][][] iArr, WS<T> ws, Comparator<List<T>> comparator) {
        List arrayList;
        ArrayList arrayList2 = new ArrayList();
        int A02 = c1691Wa.A02();
        int i2 = 0;
        loop0: while (i2 < A02) {
            if (i == c1691Wa.A03(i2)) {
                RY A072 = c1691Wa.A07(i2);
                for (int i3 = 0; i3 < A072.A01; i3++) {
                    U8 A05 = A072.A05(i3);
                    List<T> A5o = ws.A5o(i2, A05, iArr[i2][i3]);
                    boolean[] zArr = new boolean[A05.A01];
                    ArrayList arrayList3 = new ArrayList();
                    ArrayList arrayList4 = new ArrayList();
                    for (int i4 = 0; i4 < A05.A01; i4++) {
                        T t = A5o.get(i4);
                        int A082 = t.A08();
                        if (!zArr[i4] && A082 != 0) {
                            if (A082 == 1) {
                                arrayList = AbstractC11299l.A04(t);
                                String[] strArr = A08;
                                if (strArr[5].length() != strArr[7].length()) {
                                    break loop0;
                                }
                                A08[2] = "ZAJHyq1TMCFZthjm457ogzB9XlfcGEFJ";
                                arrayList3.add(t);
                            } else {
                                arrayList = new ArrayList();
                                arrayList.add(t);
                                for (int i5 = i4 + 1; i5 < A05.A01; i5++) {
                                    T t2 = A5o.get(i5);
                                    if (t2.A08() == 2 && t.A09(t2)) {
                                        arrayList.add(t2);
                                        zArr[i5] = true;
                                    }
                                }
                            }
                            arrayList4.add(arrayList);
                        }
                    }
                    if (this.A01.A0A) {
                        boolean isEmpty = arrayList3.isEmpty();
                        if (A08[4].charAt(13) != 'L') {
                            A08[1] = "2CpqC9UnHnvdpm4Z";
                            if (isEmpty) {
                            }
                            if (arrayList3.size() != A05.A01) {
                                arrayList4.clear();
                                arrayList4.add(arrayList3);
                            }
                        } else {
                            String[] strArr2 = A08;
                            strArr2[5] = "wigRhAYLK";
                            strArr2[7] = "JAXAgZPha";
                            if (isEmpty) {
                            }
                            if (arrayList3.size() != A05.A01) {
                            }
                        }
                    }
                    arrayList2.addAll(arrayList4);
                }
            }
            i2++;
            if (A08[2].length() == 0) {
                throw new RuntimeException();
            }
            String[] strArr3 = A08;
            strArr3[6] = "sOOT";
            strArr3[3] = "kMH3ngEeEucpvaC7iBfT6l";
        }
        if (arrayList2.isEmpty()) {
            return null;
        }
        List list = (List) Collections.max(arrayList2, comparator);
        int[] iArr2 = new int[list.size()];
        for (int i6 = 0; i6 < list.size(); i6++) {
            iArr2[i6] = ((WT) list.get(i6)).A01;
        }
        WT wt = (WT) list.get(0);
        return Pair.create(new WX(wt.A03, iArr2), Integer.valueOf(wt.A00));
    }

    public static String A0J(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 98);
        }
        return new String(copyOfRange);
    }

    public static void A0M() {
        A07 = new byte[]{-52, -84, -32, -49, -44, -38, -117, -50, -45, -52, -39, -39, -48, -41, -117, -50, -38, -32, -39, -33, -117, -50, -38, -39, -34, -33, -35, -52, -44, -39, -33, -34, -117, -50, -52, -39, -39, -38, -33, -117, -51, -48, -117, -52, -37, -37, -41, -44, -48, -49, -117, -30, -44, -33, -45, -38, -32, -33, -117, -35, -48, -47, -48, -35, -48, -39, -50, -48, -117, -33, -38, -117, -82, -38, -39, -33, -48, -29, -33, -103, -117, -83, -32, -44, -41, -49, -117, -33, -45, -48, -117, -33, -35, -52, -50, -42, -117, -34, -48, -41, -48, -50, -33, -38, -35, -117, -44, -39, -34, -33, -52, -39, -50, -48, -117, -30, -44, -33, -45, -117, -38, -39, -48, -117, -38, -47, -117, -33, -45, -48, -117, -39, -38, -39, -104, -49, -48, -37, -35, -48, -50, -52, -33, -48, -49, -117, -50, -38, -39, -34, -33, -35, -32, -50, -33, -38, -35, -34, -117, -33, -45, -52, -33, -117, -33, -52, -42, -48, -117, -52, -117, -82, -38, -39, -33, -48, -29, -33, -117, -52, -35, -46, -32, -40, -48, -39, -33, -103, -41, -8, -7, -12, 8, -1, 7, -25, 5, -12, -10, -2, -26, -8, -1, -8, -10, 7, 2, 5, -46, -26, -43, -38, -32, -96, -46, -44, -92, -27, -7, -24, -19, -13, -77, -27, -25, -72, 58, 78, 61, 66, 72, 8, 62, 58, 60, 12, 19, 39, 22, 27, 33, -31, 23, 19, 21, -27, -33, 28, 33, 21, -38, -45, -55, -4, -17, -22, -21, -11, -75, -25, -4, -74, -73, 2, -11, -16, -15, -5, -69, -19, 2, -17, 60, 47, 42, 43, 53, -11, 42, 53, 50, 40, 63, -13, 60, 47, 57, 47, 53, 52, 60, 47, 42, 43, 53, -11, 46, 43, 60, 41, 10, -3, -8, -7, 3, -61, 12, -63, 10, 2, -8, -62, 3, 2, -58, -62, 10, 4, -51};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 7 out of bounds for length 6
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public static void A0N(RY ry, U1 u1, Map<Integer, U6> map) {
        U6 u6;
        for (int i = 0; i < ry.A01; i++) {
            U6 u62 = u1.A0G.get(ry.A05(i));
            if (u62 != null && ((u6 = map.get(Integer.valueOf(u62.A01()))) == null || (u6.A01.isEmpty() && !u62.A01.isEmpty()))) {
                map.put(Integer.valueOf(u62.A01()), u62);
            }
        }
    }

    static {
        A0M();
        A09 = AbstractC1669Vc.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.WL
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11148h.A05((Integer) obj, (Integer) obj2);
            }
        });
        A0A = AbstractC1669Vc.A04(new Comparator() { // from class: com.facebook.ads.redexgen.X.WM
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return C11148h.A06((Integer) obj, (Integer) obj2);
            }
        });
    }

    @Deprecated
    public C11148h() {
        this(C11158i.A0J, new RT());
    }

    @Deprecated
    public C11148h(U1 u1, WY wy) {
        this(u1, wy, null);
    }

    public C11148h(U1 u1, WY wy, Context context) {
        this.A05 = new Object();
        this.A03 = context != null ? context.getApplicationContext() : null;
        this.A04 = wy;
        if (u1 instanceof C11158i) {
            this.A01 = (C11158i) u1;
        } else {
            C11158i defaultParameters = context == null ? C11158i.A0J : C11158i.A02(context);
            this.A01 = defaultParameters.A0P().A0u(u1).A0p();
        }
        this.A00 = VL.A07;
        this.A06 = context != null && N1.A18(context);
        if (!this.A06 && context != null && N1.A02 >= 32) {
            this.A02 = WR.A00(context);
        }
        if (this.A01.A08 && context == null) {
            MV.A07(A0J(188, 20, 49), A0J(1, 187, 9));
        }
    }

    @MetaExoPlayerCustomization
    public C11148h(WY wy) {
        this(C11158i.A0J, wy);
    }

    public static int A00(int i, int i2) {
        if (i != 0 && i == i2) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return Integer.bitCount(i & i2);
    }

    public static int A02(VC vc, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(vc.A0V)) {
            return 4;
        }
        String A0K = A0K(str);
        String A0K2 = A0K(vc.A0V);
        if (A0K2 == null || A0K == null) {
            return (z && A0K2 == null) ? 1 : 0;
        }
        if (A0K2.startsWith(A0K) || A0K.startsWith(A0K2)) {
            return 3;
        }
        String A0J = A0J(0, 1, 61);
        String str2 = N1.A1P(A0K2, A0J)[0];
        String formatLanguage = N1.A1P(A0K, A0J)[0];
        if (!str2.equals(formatLanguage)) {
            return 0;
        }
        return 2;
    }

    /* JADX WARN: Incorrect condition in loop: B:8:0x0024 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A03(U8 u8, int i, int i2, boolean z) {
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        int i3 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
        if (A08[0].charAt(25) == 'O') {
            throw new RuntimeException();
        }
        A08[1] = "wfFv1AieXG9eNvhmPq2a11ljL";
        for (int i4 = 0; i4 < maxVideoPixelsToRetain; i4++) {
            VC format = u8.A08(i4);
            int maxVideoPixelsToRetain = format.A0L;
            if (maxVideoPixelsToRetain > 0) {
                int maxVideoPixelsToRetain2 = format.A0A;
                if (maxVideoPixelsToRetain2 > 0) {
                    int i5 = format.A0L;
                    int maxVideoPixelsToRetain3 = format.A0A;
                    Point A092 = A09(z, i, i2, i5, maxVideoPixelsToRetain3);
                    int i6 = format.A0L;
                    int maxVideoPixelsToRetain4 = format.A0A;
                    int i7 = i6 * maxVideoPixelsToRetain4;
                    int i8 = format.A0L;
                    int maxVideoPixelsToRetain5 = A092.x;
                    if (i8 >= ((int) (maxVideoPixelsToRetain5 * 0.98f))) {
                        int videoPixels = format.A0A;
                        int i9 = A08[4].charAt(13);
                        if (i9 != 76) {
                            A08[2] = "ADP1T0Hh";
                            int maxVideoPixelsToRetain6 = A092.y;
                            if (videoPixels < ((int) (maxVideoPixelsToRetain6 * 0.98f))) {
                            }
                            if (i7 >= i3) {
                                i3 = i7;
                            }
                        } else {
                            A08[2] = "3Njng6TDHfmlDodg";
                            int maxVideoPixelsToRetain7 = A092.y;
                            if (videoPixels < ((int) (maxVideoPixelsToRetain7 * 0.98f))) {
                            }
                            if (i7 >= i3) {
                            }
                        }
                    }
                }
            }
        }
        return i3;
    }

    public static /* synthetic */ int A05(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            return num2.intValue() == -1 ? 0 : -1;
        }
        if (num2.intValue() == -1) {
            return 1;
        }
        return num.intValue() - num2.intValue();
    }

    public static /* synthetic */ int A06(Integer num, Integer num2) {
        return 0;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int A07(String str) {
        char c;
        if (str == null) {
            return 0;
        }
        switch (str.hashCode()) {
            case -1851077871:
                if (str.equals(A0J(272, 18, 100))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -1662735862:
                if (str.equals(A0J(253, 10, 36))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1662541442:
                if (str.equals(A0J(290, 10, 100))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1331836730:
                if (str.equals(A0J(263, 9, 42))) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1599127257:
                if (str.equals(A0J(AdSize.MEDIUM_RECTANGLE_WIDTH, 19, 50))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
        }
        return 0;
    }

    @MetaExoPlayerCustomization
    public static Point A09(boolean z, int i, int i2, int i3, int i4) {
        if (z) {
            if ((i3 > i4) != (i > i2)) {
                String[] strArr = A08;
                if (strArr[6].length() == strArr[3].length()) {
                    throw new RuntimeException();
                }
                A08[2] = "MRAL2PEWT7Lor36iYCvDrRdop0p2Kv";
                i = i2;
                i2 = i;
            }
        }
        if (i3 * i2 >= i4 * i) {
            return new Point(i, N1.A05(i * i4, i3));
        }
        return new Point(N1.A05(i2 * i3, i4), i2);
    }

    private final Pair<WX, Integer> A0B(C1691Wa c1691Wa, int[][][] iArr, final C11158i c11158i, final String str) throws AnonymousClass96 {
        return A0A(3, c1691Wa, iArr, new WS() { // from class: com.facebook.ads.redexgen.X.RP
            @Override // com.facebook.ads.redexgen.X.WS
            public final List A5o(int i, U8 u8, int[] iArr2) {
                AbstractC11299l A02;
                A02 = RI.A02(i, u8, C11158i.this, iArr2, str);
                return A02;
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.WK
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RI.A01((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<WX, Integer> A0C(C1691Wa c1691Wa, int[][][] iArr, int[] iArr2, final C11158i c11158i) throws AnonymousClass96 {
        final boolean z = false;
        int i = 0;
        while (true) {
            if (i < c1691Wa.A02()) {
                if (2 == c1691Wa.A03(i) && c1691Wa.A07(i).A01 > 0) {
                    z = true;
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return A0A(1, c1691Wa, iArr, new WS() { // from class: com.facebook.ads.redexgen.X.RQ
            @Override // com.facebook.ads.redexgen.X.WS
            public final List A5o(int i2, U8 u8, int[] iArr3) {
                return C11148h.this.A0e(c11158i, z, i2, u8, iArr3);
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.WJ
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RO.A02((List) obj, (List) obj2);
            }
        });
    }

    private final Pair<WX, Integer> A0D(C1691Wa c1691Wa, int[][][] iArr, final int[] iArr2, final C11158i c11158i, final String str) throws AnonymousClass96 {
        return A0A(2, c1691Wa, iArr, new WS() { // from class: com.facebook.ads.redexgen.X.RS
            @Override // com.facebook.ads.redexgen.X.WS
            public final List A5o(int i, U8 u8, int[] iArr3) {
                AbstractC11299l A06;
                A06 = RH.A06(i, u8, C11158i.this, iArr3, str, iArr2[i]);
                return A06;
            }
        }, new Comparator() { // from class: com.facebook.ads.redexgen.X.WI
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return RH.A05((List) obj, (List) obj2);
            }
        });
    }

    private final WX A0E(int i, RY ry, int[][] iArr, C11158i c11158i) throws AnonymousClass96 {
        U8 u8 = null;
        int i2 = 0;
        WO wo = null;
        for (int trackIndex = 0; trackIndex < ry.A01; trackIndex++) {
            U8 trackGroup = ry.A05(trackIndex);
            int[] iArr2 = iArr[trackIndex];
            for (int groupIndex = 0; groupIndex < trackGroup.A01; groupIndex++) {
                int selectedTrackIndex = iArr2[groupIndex];
                if (A0S(selectedTrackIndex, c11158i.A0B)) {
                    WO wo2 = new WO(trackGroup.A08(groupIndex), iArr2[groupIndex]);
                    if (wo == null || wo2.compareTo(wo) > 0) {
                        u8 = trackGroup;
                        i2 = groupIndex;
                        wo = wo2;
                    }
                }
            }
        }
        if (u8 == null) {
            return null;
        }
        return new WX(u8, i2);
    }

    public static String A0K(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, A0J(AdSize.MEDIUM_RECTANGLE_HEIGHT, 3, 3))) {
            return null;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0L() {
        boolean z;
        synchronized (this.A05) {
            z = this.A01.A08 && !this.A06 && N1.A02 >= 32 && this.A02 != null && this.A02.A06();
        }
        if (z) {
            A01();
        }
    }

    public static void A0P(C1691Wa c1691Wa, U1 u1, WX[] wxArr) {
        WX wx;
        int A02 = c1691Wa.A02();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < A02; i++) {
            A0N(c1691Wa.A07(i), u1, hashMap);
        }
        A0N(c1691Wa.A06(), u1, hashMap);
        for (int i2 = 0; i2 < A02; i2++) {
            int rendererCount = c1691Wa.A03(i2);
            U6 u6 = (U6) hashMap.get(Integer.valueOf(rendererCount));
            if (u6 != null) {
                if (!u6.A01.isEmpty() && c1691Wa.A07(i2).A04(u6.A00) != -1) {
                    wx = new WX(u6.A00, AnonymousClass19.A0B(u6.A01));
                } else {
                    wx = null;
                }
                wxArr[i2] = wx;
            }
        }
    }

    public static void A0Q(C1691Wa c1691Wa, C11158i c11158i, WX[] wxArr) {
        WX wx;
        int A02 = c1691Wa.A02();
        for (int i = 0; i < A02; i++) {
            RY trackGroups = c1691Wa.A07(i);
            if (c11158i.A0S(i, trackGroups)) {
                RJ A0Q = c11158i.A0Q(i, trackGroups);
                if (A0Q != null) {
                    int rendererCount = A0Q.A03.length;
                    if (rendererCount != 0) {
                        int rendererCount2 = A0Q.A00;
                        U8 A05 = trackGroups.A05(rendererCount2);
                        int[] iArr = A0Q.A03;
                        int rendererIndex = A0Q.A02;
                        wx = new WX(A05, iArr, rendererIndex);
                        wxArr[i] = wx;
                    }
                }
                wx = null;
                wxArr[i] = wx;
            }
        }
    }

    public static void A0R(C1691Wa c1691Wa, int[][][] iArr, C1529Ph[] c1529PhArr, RA[] raArr) {
        int i = -1;
        int i2 = -1;
        int i3 = 1;
        int i4 = 0;
        while (true) {
            int tunnelingAudioRendererIndex = c1691Wa.A02();
            if (i4 >= tunnelingAudioRendererIndex) {
                break;
            }
            int i5 = c1691Wa.A03(i4);
            RA ra = raArr[i4];
            if ((i5 == 1 || i5 == 2) && ra != null && A0W(iArr[i4], c1691Wa.A07(i4), ra)) {
                if (i5 == 1) {
                    if (i != -1) {
                        i3 = 0;
                        break;
                    }
                    i = i4;
                } else {
                    if (i2 != -1) {
                        i3 = 0;
                        break;
                    }
                    i2 = i4;
                }
            }
            i4++;
        }
        int tunnelingAudioRendererIndex2 = (i == -1 || i2 == -1) ? 0 : 1;
        if ((i3 & tunnelingAudioRendererIndex2) != 0) {
            C1529Ph c1529Ph = new C1529Ph(true);
            c1529PhArr[i] = c1529Ph;
            c1529PhArr[i2] = c1529Ph;
        }
    }

    @MetaExoPlayerCustomization
    public static boolean A0S(int i, boolean z) {
        int A03 = PX.A03(i);
        return A03 == 4 || (z && A03 == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0T(VC vc) {
        boolean z;
        synchronized (this.A05) {
            z = !this.A01.A08 || this.A06 || vc.A06 <= 2 || (A0U(vc) && (N1.A02 < 32 || this.A02 == null || !this.A02.A06())) || (N1.A02 >= 32 && this.A02 != null && this.A02.A06() && this.A02.A04() && this.A02.A05() && this.A02.A07(this.A00, vc));
        }
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static boolean A0U(VC vc) {
        char c;
        if (vc.A0W == null) {
            return false;
        }
        String str = vc.A0W;
        int hashCode = str.hashCode();
        String[] strArr = A08;
        if (strArr[6].length() == strArr[3].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A08;
        strArr2[6] = "Km1e";
        strArr2[3] = "HhuKc9C19fuqudqOrF8WI4";
        switch (hashCode) {
            case -2123537834:
                if (str.equals(A0J(236, 14, 80))) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 187078296:
                if (str.equals(A0J(208, 9, 15))) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 187078297:
                if (str.equals(A0J(217, 9, 34))) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1504578661:
                if (str.equals(A0J(226, 10, 119))) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public static boolean A0W(int[][] iArr, RY ry, RA ra) {
        if (ra == null) {
            return false;
        }
        int A04 = ry.A04(ra.A9y());
        for (int i = 0; i < ra.length(); i++) {
            int trackGroupIndex = PX.A05(iArr[A04][ra.A8t(i)]);
            if (trackGroupIndex != 32) {
                return false;
            }
        }
        return true;
    }

    private final WX[] A0X(C1691Wa c1691Wa, int[][][] iArr, int[] iArr2, C11158i c11158i) throws AnonymousClass96 {
        String str;
        int A02 = c1691Wa.A02();
        WX[] wxArr = new WX[A02];
        Pair<WX, Integer> A0C = A0C(c1691Wa, iArr, iArr2, c11158i);
        if (A0C != null) {
            int intValue = ((Integer) A0C.second).intValue();
            WX wx = (WX) A0C.first;
            if (A08[1].length() == 30) {
                throw new RuntimeException();
            }
            String[] strArr = A08;
            strArr[6] = "i1l7";
            strArr[3] = "8gR5IAybtJJSc0KWEFd8Nb";
            wxArr[intValue] = wx;
        }
        if (A0C == null) {
            str = null;
        } else {
            U8 u8 = ((WX) A0C.first).A01;
            int rendererCount = ((WX) A0C.first).A02[0];
            str = u8.A08(rendererCount).A0V;
        }
        Pair<WX, Integer> A0D = A0D(c1691Wa, iArr, iArr2, c11158i, str);
        if (A0D != null) {
            wxArr[((Integer) A0D.second).intValue()] = (WX) A0D.first;
        }
        Pair<WX, Integer> A0B = A0B(c1691Wa, iArr, c11158i, str);
        if (A0B != null) {
            wxArr[((Integer) A0B.second).intValue()] = (WX) A0B.first;
        }
        for (int i = 0; i < A02; i++) {
            int A03 = c1691Wa.A03(i);
            if (A03 != 2 && A03 != 1 && A03 != 3) {
                wxArr[i] = A0E(A03, c1691Wa.A07(i), iArr[i], c11158i);
            }
        }
        return wxArr;
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1698Wi
    public final boolean A0Y() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.X.R9
    @MetaExoPlayerCustomization
    public final Pair<C1529Ph[], RA[]> A0d(C1691Wa c1691Wa, int[][][] iArr, int[] iArr2, C1577Rk c1577Rk, Timeline timeline) throws AnonymousClass96 {
        C11158i c11158i;
        synchronized (this.A05) {
            try {
                c11158i = this.A01;
                if (c11158i.A08 && N1.A02 >= 32 && this.A02 != null) {
                    this.A02.A03(this, (Looper) AbstractC1437Ln.A02(Looper.myLooper()));
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        int A02 = c1691Wa.A02();
        WX[] A0X = A0X(c1691Wa, iArr, iArr2, c11158i);
        A0P(c1691Wa, c11158i, A0X);
        A0Q(c1691Wa, c11158i, A0X);
        for (int rendererCount = 0; rendererCount < A02; rendererCount++) {
            int A03 = c1691Wa.A03(rendererCount);
            if (c11158i.A0R(rendererCount) || c11158i.A0H.contains(Integer.valueOf(A03))) {
                A0X[rendererCount] = null;
            }
        }
        RA[] A6A = this.A04.A6A(A0X, A00(), c1577Rk, timeline);
        C1529Ph[] c1529PhArr = new C1529Ph[A02];
        for (int i = 0; i < A02; i++) {
            c1529PhArr[i] = !(c11158i.A0R(i) || c11158i.A0H.contains(Integer.valueOf(c1691Wa.A03(i)))) && (c1691Wa.A03(i) == -2 || A6A[i] != null) ? C1529Ph.A01 : null;
        }
        if (c11158i.A0D) {
            A0R(c1691Wa, iArr, c1529PhArr, A6A);
        }
        return Pair.create(c1529PhArr, A6A);
    }

    public final /* synthetic */ AbstractC11299l A0e(C11158i c11158i, boolean z, int i, U8 u8, int[] iArr) {
        return RO.A03(i, u8, c11158i, iArr, z, new InterfaceC1709Wt() { // from class: com.facebook.ads.redexgen.X.RR
            @Override // com.facebook.ads.redexgen.X.InterfaceC1709Wt
            public final boolean A4d(Object obj) {
                boolean A0T;
                A0T = C11148h.this.A0T((VC) obj);
                return A0T;
            }
        });
    }
}
