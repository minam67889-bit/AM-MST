package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.provider.Settings;
import android.util.Pair;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.util.Arrays;

/* loaded from: assets/audience_network/classes.dex */
public final class QG {
    public static byte[] A02;
    public static String[] A03 = {"Jjjr15BdmU1e1w5XBAxt2PqiJzdOv9H6", "k5EK5bSpx4qNpEuGVXJnW5pYWqYUNfvd", "AuFAuVqlCp0La4ZX5vRqqcxSvweqnfrd", "rgtUQqvj1CQPkdNiIbMq9Uo2BIKwxK6f", "3bXj4pAfTFAaMN", "bLL1Nxt1kQUgiKBEh7uhxeED33aOUrvl", "nlm3QVdrlvA3GNEtxoNDxXWnARVyweou", "WvjZNIDYapQpgxo06ZNUbI8M0TgCs59c"};
    public static final QG A04;
    public static final QG A05;

    @MetaExoPlayerCustomization
    public static final AbstractC1682Vq<Integer, Integer> A06;
    public final int A00;
    public final int[] A01;

    public static String A05(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] ^ i3) ^ 23);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A02 = new byte[]{101, 105, 58, 60, 57, 57, 38, 59, 61, 44, 45, 12, 39, 42, 38, 45, 32, 39, 46, 58, 116, 66, 110, 98, 121, 108, 109, 49, 5, 20, 25, 31, 51, 17, 0, 17, 18, 25, 28, 25, 4, 25, 21, 3, 43, 29, 17, 8, 51, 24, 17, 30, 30, 21, 28, 51, 31, 5, 30, 4, 77, 28, 45, 37, 43, 41, 45, 58, 8, 7, 13, 27, 6, 0, 13, 71, 4, 12, 13, 0, 8, 71, 8, 10, 29, 0, 6, 7, 71, 33, 45, 36, 32, 54, 40, 60, 45, 32, 38, 54, 57, 37, 60, 46, 49, 62, 52, 34, 63, 57, 52, 126, 61, 53, 52, 57, 49, 126, 53, 40, 36, 34, 49, 126, 17, 5, 20, 25, 31, 15, 0, 28, 5, 23, 15, 3, 4, 17, 4, 21, 60, 51, 57, 47, 50, 52, 57, 115, 48, 56, 57, 52, 60, 115, 56, 37, 41, 47, 60, 115, 24, 19, 30, 18, 25, 20, 19, 26, 14, 103, 104, 98, 116, 105, 111, 98, 40, 107, 99, 98, 111, 103, 40, 99, 126, 114, 116, 103, 40, 75, 71, 94, 89, 69, 78, 71, 72, 72, 67, 74, 89, 69, 73, 83, 72, 82, 66, 95, 83, 66, 85, 73, 70, 75, 120, 84, 82, 85, 85, 72, 82, 73, 67, 120, 84, 72, 82, 73, 67, 120, 66, 73, 70, 69, 75, 66, 67, 13, 30, 12, 30};
    }

    static {
        A06();
        A04 = new QG(new int[]{2}, 8);
        A05 = new QG(new int[]{2, 5, 6}, 8);
        A06 = new C1683Vr().A05(5, 6).A05(17, 6).A05(7, 6).A05(18, 6).A05(6, 8).A05(8, 8).A05(14, 8).A07();
    }

    public QG(int[] iArr, int i) {
        if (iArr != null) {
            this.A01 = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.A01);
        } else {
            this.A01 = new int[0];
        }
        this.A00 = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004b, code lost:
    
        if (r4 != 5) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int A00(int i) {
        if (N1.A02 <= 28) {
            if (i == 7) {
                i = 8;
            } else {
                if (i != 3) {
                    if (A03[4].length() == 8) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A03;
                    strArr[7] = "KiNINnFwTf81PmXbmHW08nBZpQERddvf";
                    strArr[5] = "Y2CaNqhQ16llXRLdzrOdvyOrTRSc2v87";
                    if (i != 4) {
                    }
                }
                i = 6;
            }
        }
        if (N1.A02 <= 26 && A05(237, 4, 124).equals(N1.A03) && i == 1) {
            i = 2;
        }
        return N1.A01(i);
    }

    public static int A01(int i, int i2) {
        if (N1.A02 >= 29) {
            return QF.A00(i, i2);
        }
        return ((Integer) AbstractC1437Ln.A01(A06.getOrDefault(Integer.valueOf(i), 0))).intValue();
    }

    public static QG A02(Context context) {
        Intent intent = context.registerReceiver(null, new IntentFilter(A05(68, 36, 126)));
        return A03(context, intent);
    }

    public static QG A03(Context context, Intent intent) {
        if (A07() && Settings.Global.getInt(context.getContentResolver(), A05(206, 31, 48), 0) == 1) {
            return A05;
        }
        if (N1.A02 >= 29 && (N1.A18(context) || N1.A17(context))) {
            return new QG(QF.A01(), 8);
        }
        if (intent == null || intent.getIntExtra(A05(104, 36, 71), 0) == 0) {
            return A04;
        }
        return new QG(intent.getIntArrayExtra(A05(140, 29, 74)), intent.getIntExtra(A05(169, 37, 17), 8));
    }

    public static boolean A07() {
        if (N1.A02 >= 17) {
            if (A05(21, 6, 20).equals(N1.A05) || A05(61, 6, 83).equals(N1.A05)) {
                return true;
            }
        }
        return false;
    }

    public final int A08() {
        return this.A00;
    }

    public final Pair<Integer, Integer> A09(VC vc) {
        int channelCount;
        int channelConfig = L8.A03((String) AbstractC1437Ln.A01(vc.A0W), vc.A0R);
        if (!A06.containsKey(Integer.valueOf(channelConfig))) {
            return null;
        }
        if (channelConfig == 18 && !A0A(18)) {
            channelConfig = 6;
        } else if (channelConfig == 8 && !A0A(8)) {
            channelConfig = 7;
        }
        if (!A0A(channelConfig)) {
            return null;
        }
        int encoding = vc.A06;
        if (encoding == -1 || channelConfig == 18) {
            int i = vc.A0G;
            if (A03[0].charAt(21) != 'P') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[1] = "im8Toc9sdlxeSIkTkbHKRL54ibzm5AKd";
            strArr[2] = "E1ySJvazDXa0jNiMn3kQwKbv3M4CcROd";
            int encoding2 = i != -1 ? vc.A0G : 48000;
            channelCount = A01(channelConfig, encoding2);
        } else {
            channelCount = vc.A06;
            int encoding3 = this.A00;
            if (channelCount > encoding3) {
                return null;
            }
        }
        int encoding4 = A00(channelCount);
        if (encoding4 == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(channelConfig), Integer.valueOf(encoding4));
    }

    public final boolean A0A(int i) {
        return Arrays.binarySearch(this.A01, i) >= 0;
    }

    public final boolean A0B(VC vc) {
        return A09(vc) != null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QG)) {
            return false;
        }
        QG qg = (QG) obj;
        if (Arrays.equals(this.A01, qg.A01)) {
            int i = this.A00;
            if (A03[4].length() == 8) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[6] = "mNlTbAuwojXnkISqIBnkNSSSmOFdaBFK";
            strArr[3] = "6PhpWRJp8Yp2AjRuVgCmopriU4FRmjKX";
            if (i == qg.A00) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.A00 + (Arrays.hashCode(this.A01) * 31);
    }

    public final String toString() {
        return A05(27, 34, 103) + this.A00 + A05(0, 21, 94) + Arrays.toString(this.A01) + A05(67, 1, 112);
    }
}
