package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* renamed from: com.facebook.ads.redexgen.X.j4, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C2343j4 {
    public static byte[] A09;
    public static String[] A0A = {"ulA9tMpXJ0Fgz3L6", "kmBp6JcSqPlb9eogqvbvj6g5ppHVaWSS", "klPqAM4BpBJNr6xIOjiQhoS6UO4TrOHS", "7VyM9GgXJuu8YzSYQI3HrMroeBYRJajD", "jF2bnw6E6wYHKm8plX11kYiLrSAbSJmD", "6pBnRch9VxXRPJwtqH0gd323b09mKXXU", "Clk2oRExhn8z5HC1wWkAqM8aEwWEfAA8", "Myq33IQdIYqIzBMhSJhfspyke76FBM0c"};
    public C2342j3 A01;
    public AbstractC2351jC A04;
    public final /* synthetic */ C7O A08;
    public final ArrayList<AbstractC2353jE> A05 = new ArrayList<>();
    public ArrayList<AbstractC2353jE> A02 = null;
    public final ArrayList<AbstractC2353jE> A06 = new ArrayList<>();
    public final List<AbstractC2353jE> A07 = Collections.unmodifiableList(this.A05);
    public int A03 = 2;
    public int A00 = 2;

    public static String A04(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A09, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 58);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A09 = new byte[]{-91, -18, -8, -58, -7, -7, -26, -24, -19, -22, -23, -65, -59, -32, 39, 30, 30, 43, 29, 44, -14, -53, -48, -62, -21, 22, 7, 15, -62, 5, 17, 23, 16, 22, -36, -38, -33, 36, 37, 18, 37, 22, -21, -120, 122, -83, -50, -69, -50, -65, 122, -61, -50, -65, -57, 122, -67, -55, -49, -56, -50, 122, -61, -51, 122, -13, 17, 28, 28, 21, 20, -48, 35, 19, 34, 17, 32, -48, 38, 25, 21, 39, -48, 39, 25, 36, 24, -48, 17, 30, -48, 25, 30, 38, 17, 28, 25, 20, -48, 38, 25, 21, 39, -34, -48, -7, 30, 38, 17, 28, 25, 20, -48, 38, 25, 21, 39, 35, -48, 19, 17, 30, 30, 31, 36, -48, 18, 21, -48, 34, 21, 37, 35, 21, 20, -48, 22, 34, 31, 29, -48, 35, 19, 34, 17, 32, -36, -48, 36, 24, 21, 41, -48, 35, 24, 31, 37, 28, 20, -48, 34, 21, 18, 31, 37, 30, 20, -48, 22, 34, 31, 29, -48, 34, 21, 19, 41, 19, 28, 21, 34, -48, 32, 31, 31, 28, -34, -13, 24, 13, 25, 24, 29, 19, 29, 30, 15, 24, 13, 35, -54, 14, 15, 30, 15, 13, 30, 15, 14, -40, -54, -13, 24, 32, 11, 22, 19, 14, -54, 19, 30, 15, 23, -54, 26, 25, 29, 19, 30, 19, 25, 24, -54, -125, -88, -99, -87, -88, -83, -93, -83, -82, -97, -88, -99, -77, 90, -98, -97, -82, -97, -99, -82, -97, -98, 104, 90, -125, -88, -80, -101, -90, -93, -98, 90, -80, -93, -97, -79, 90, -94, -87, -90, -98, -97, -84, 90, -101, -98, -101, -86, -82, -97, -84, 90, -86, -87, -83, -93, -82, -93, -87, -88, -73, -36, -28, -49, -38, -41, -46, -114, -41, -30, -45, -37, -114, -34, -35, -31, -41, -30, -41, -35, -36, -114, -36, -20, -5, -22, -7, -7, -18, -19, -87, -8, -5, -87, -22, -3, -3, -22, -20, -15, -18, -19, -87, -1, -14, -18, 0, -4, -87, -10, -22, 2, -87, -9, -8, -3, -87, -21, -18, -87, -5, -18, -20, 2, -20, -11, -18, -19, -73, -87, -14, -4, -36, -20, -5, -22, -7, -61, -102, -77, -74, 102, -86, -85, -70, -89, -87, -82, -85, -86, 102, -68, -81, -85, -67, 102, -71, -82, -75, -69, -78, -86, 102, -88, -85, 102, -72, -85, -77, -75, -68, -85, -86, 102, -84, -72, -75, -77, 102, -104, -85, -87, -65, -87, -78, -85, -72, -100, -81, -85, -67, 102, -88, -85, -84, -75, -72, -85, 102, -81, -70, 102, -87, -89, -76, 102, -88, -85, 102, -72, -85, -87, -65, -87, -78, -85, -86, Byte.MIN_VALUE, 102, -38, -8, -1, -17, -12, -19, -90, -6, -11, -90, -8, -21, -23, -1, -23, -14, -21, -90, -25, -12, -90, -17, -19, -12, -11, -8, -21, -22, -90, -4, -17, -21, -3, -90, -18, -11, -14, -22, -21, -8, -76, -90, -33, -11, -5, -90, -7, -18, -11, -5, -14, -22, -90, -20, -17, -8, -7, -6, -90, -23, -25, -14, -14, -90, -7, -6, -11, -10, -49, -19, -12, -11, -8, -17, -12, -19, -36, -17, -21, -3, -82, -4, -17, -21, -3, -81, -90, -24, -21, -20, -11, -8, -21, -90, -23, -25, -14, -14, -17, -12, -19, -90, -8, -21, -23, -1, -23, -14, -21, -76, -78, -80, -65, -95, -76, -80, -62, -111, -70, -67, -101, -70, -66, -76, -65, -76, -70, -71, -116, -71, -81, -97, -60, -69, -80, -66, -61, -53, -74, -63, -66, -71, 117, -59, -60, -56, -66, -55, -66, -60, -61, 117, -28, -39, -15, -25, -19, -20, -104, -31, -26, -36, -35, -16, -104, -21, -32, -25, -19, -28, -36, -104, -26, -25, -20, -104, -38, -35, -104, -91, -87, -104, -39, -34, -20, -35, -22, -104, -19, -26, -32, -31, -36, -31, -26, -33, -104, -39, -104, -18, -31, -35, -17, -78, -12, -13, -37, -18, -22, -4, -41, -22, -24, -2, -24, -15, -22, -23};
    }

    static {
        A05();
    }

    public C2343j4(C7O c7o) {
        this.A08 = c7o;
    }

    private final View A00(int i, boolean z) {
        return A0J(i, z, Long.MAX_VALUE).A0H;
    }

    private final AbstractC2353jE A01(int i) {
        int size;
        int A0D;
        if (this.A02 == null || (size = this.A02.size()) == 0) {
            return null;
        }
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC2353jE abstractC2353jE = this.A02.get(i2);
            if (!abstractC2353jE.A0t()) {
                int i3 = abstractC2353jE.A0T();
                if (i3 == i) {
                    abstractC2353jE.A0e(32);
                    return abstractC2353jE;
                }
            }
        }
        if (this.A08.A04.A0O() && (A0D = this.A08.A00.A0D(i)) > 0) {
            int offsetPosition = this.A08.A04.A0B();
            if (A0D < offsetPosition) {
                long A0D2 = this.A08.A04.A0D(A0D);
                for (int i4 = 0; i4 < size; i4++) {
                    AbstractC2353jE abstractC2353jE2 = this.A02.get(i4);
                    if (!abstractC2353jE2.A0t() && abstractC2353jE2.A0V() == A0D2) {
                        abstractC2353jE2.A0e(32);
                        return abstractC2353jE2;
                    }
                }
            }
        }
        return null;
    }

    private final AbstractC2353jE A02(int i, boolean z) {
        View A08;
        int size = this.A05.size();
        for (int i2 = 0; i2 < size; i2++) {
            AbstractC2353jE abstractC2353jE = this.A05.get(i2);
            if (!abstractC2353jE.A0t()) {
                int scrapCount = abstractC2353jE.A0T();
                if (scrapCount == i && !abstractC2353jE.A0m() && (this.A08.A0s.A09 || !abstractC2353jE.A0n())) {
                    abstractC2353jE.A0e(32);
                    return abstractC2353jE;
                }
            }
        }
        if (!z && (A08 = this.A08.A01.A08(i)) != null) {
            AbstractC2353jE A0F = C7O.A0F(A08);
            this.A08.A01.A0G(A08);
            int A07 = this.A08.A01.A07(A08);
            if (A07 != -1) {
                this.A08.A01.A0C(A07);
                A0X(A08);
                A0F.A0e(8224);
                return A0F;
            }
            throw new IllegalStateException(A04(604, 52, 62) + A0F + this.A08.A1L());
        }
        int size2 = this.A06.size();
        for (int i3 = 0; i3 < size2; i3++) {
            AbstractC2353jE abstractC2353jE2 = this.A06.get(i3);
            if (!abstractC2353jE2.A0m()) {
                int scrapCount2 = abstractC2353jE2.A0T();
                if (scrapCount2 == i) {
                    if (!z) {
                        this.A06.remove(i3);
                    }
                    return abstractC2353jE2;
                }
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0046, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ec A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final AbstractC2353jE A03(long j, int i, boolean z) {
        int count = this.A05.size();
        int i2 = count - 1;
        while (true) {
            if (i2 >= 0) {
                AbstractC2353jE abstractC2353jE = this.A05.get(i2);
                if (abstractC2353jE.A0V() == j && !abstractC2353jE.A0t()) {
                    int count2 = abstractC2353jE.A0S();
                    if (i == count2) {
                        abstractC2353jE.A0e(32);
                        if (abstractC2353jE.A0n()) {
                            C7O c7o = this.A08;
                            int i3 = A0A[4].charAt(3);
                            if (i3 == 98) {
                                A0A[0] = "q3aWXTgT7NsVf007";
                                if (!c7o.A0s.A07()) {
                                    String[] strArr = A0A;
                                    String str = strArr[2];
                                    String str2 = strArr[1];
                                    int cacheSize = str.charAt(0);
                                    int count3 = str2.charAt(0);
                                    if (cacheSize != count3) {
                                        A0A[4] = "NC6bFXUosLdTEwJsXrsHGkbXBsQUMG7q";
                                        abstractC2353jE.A0f(2, 14);
                                    } else {
                                        String[] strArr2 = A0A;
                                        strArr2[2] = "kBSMDIkt47Rx4hHhTamY1xnSrMWRxYxp";
                                        strArr2[1] = "kToZLwND7zKVFlbtf8XZb6UwHA5zPLAu";
                                        abstractC2353jE.A0f(2, 14);
                                    }
                                }
                            }
                        }
                        return abstractC2353jE;
                    }
                    if (!z) {
                        this.A05.remove(i2);
                        this.A08.removeDetachedView(abstractC2353jE.A0H, false);
                        A0W(abstractC2353jE.A0H);
                    }
                }
                i2--;
            } else {
                int count4 = this.A06.size();
                for (int i4 = count4 - 1; i4 >= 0; i4--) {
                    AbstractC2353jE abstractC2353jE2 = this.A06.get(i4);
                    if (abstractC2353jE2.A0V() == j) {
                        int A0S = abstractC2353jE2.A0S();
                        int cacheSize2 = A0A[0].length();
                        if (cacheSize2 != 16) {
                            String[] strArr3 = A0A;
                            strArr3[7] = "lrD7iCy3KBiO8gA6PsFToJiVZrW1xMAl";
                            strArr3[6] = "amz9CZtibeJcU8bEqG7a4ZYgRNeZgxWk";
                            if (i == A0S) {
                                if (!z) {
                                    ArrayList<AbstractC2353jE> arrayList = this.A06;
                                    String[] strArr4 = A0A;
                                    String str3 = strArr4[5];
                                    String str4 = strArr4[3];
                                    int cacheSize3 = str3.charAt(0);
                                    int count5 = str4.charAt(0);
                                    if (cacheSize3 != count5) {
                                        String[] strArr5 = A0A;
                                        strArr5[5] = "or4YmCu0ppqzW1VFAnuQtpcwvOCNSyKL";
                                        strArr5[3] = "x7G8xrEgau2heO3LEdjWfX9qC3RDyC0d";
                                        arrayList.remove(i4);
                                    } else {
                                        arrayList.remove(i4);
                                    }
                                }
                                return abstractC2353jE2;
                            }
                            if (z) {
                                A07(i4);
                                String[] strArr6 = A0A;
                                String str5 = strArr6[2];
                                String str6 = strArr6[1];
                                int cacheSize4 = str5.charAt(0);
                                int count6 = str6.charAt(0);
                                if (cacheSize4 == count6) {
                                    A0A[4] = "2lrbY7WLbUziAPe6QkcwvBQ2VEr9QFta";
                                    return null;
                                }
                            }
                        } else {
                            String[] strArr7 = A0A;
                            strArr7[2] = "kYzWBiiTSiU3KogqfJ4EJctPAodLTQqF";
                            strArr7[1] = "kIBKgO4naDZyukeXVXxcwMENrZxoY36q";
                            if (i == A0S) {
                                if (!z) {
                                }
                                return abstractC2353jE2;
                            }
                            if (z) {
                            }
                        }
                    }
                }
                return null;
            }
        }
    }

    private final void A06() {
        boolean z;
        int count = this.A06.size();
        for (int count2 = count - 1; count2 >= 0; count2--) {
            A07(count2);
        }
        this.A06.clear();
        z = C7O.A1E;
        if (z) {
            this.A08.A02.A02();
        }
    }

    private final void A07(int i) {
        A0e(this.A06.get(i), true);
        this.A06.remove(i);
    }

    private void A08(ViewGroup viewGroup, boolean z) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt instanceof ViewGroup) {
                String[] strArr = A0A;
                String str = strArr[7];
                String str2 = strArr[6];
                int charAt = str.charAt(8);
                int i = str2.charAt(8);
                if (charAt == i) {
                    throw new RuntimeException();
                }
                A0A[4] = "0ZJbYELQTNKw4GYvMFOIJ2JFgvUoupt2";
                A08((ViewGroup) childAt, true);
            }
        }
        if (!z) {
            return;
        }
        if (viewGroup.getVisibility() == 4) {
            viewGroup.setVisibility(0);
            viewGroup.setVisibility(4);
        } else {
            int visibility = viewGroup.getVisibility();
            viewGroup.setVisibility(4);
            viewGroup.setVisibility(visibility);
        }
    }

    private void A09(AbstractC2353jE abstractC2353jE) {
        if (this.A08.A1x()) {
            View view = abstractC2353jE.A0H;
            if (AbstractC2255hb.A00(view) == 0) {
                AbstractC2255hb.A09(view, 1);
            }
            if (!AbstractC2255hb.A0F(view)) {
                abstractC2353jE.A0e(16384);
                AbstractC2255hb.A0B(view, this.A08.A09.A0A());
            }
        }
    }

    private void A0A(AbstractC2353jE abstractC2353jE) {
        if (abstractC2353jE.A0H instanceof ViewGroup) {
            A08((ViewGroup) abstractC2353jE.A0H, false);
        }
    }

    private final void A0B(AbstractC2353jE abstractC2353jE) {
        if (0 != 0) {
            throw new NullPointerException(A04(656, 14, 75));
        }
        if (this.A08.A04 != null) {
            this.A08.A04.A0K(abstractC2353jE);
        }
        if (this.A08.A0s != null) {
            this.A08.A0t.A0B(abstractC2353jE);
        }
    }

    private final boolean A0C(AbstractC2353jE abstractC2353jE) {
        if (abstractC2353jE.A0n()) {
            return this.A08.A0s.A07();
        }
        if (abstractC2353jE.A03 >= 0 && abstractC2353jE.A03 < this.A08.A04.A0B()) {
            if (!this.A08.A0s.A07()) {
                int A0C = this.A08.A04.A0C(abstractC2353jE.A03);
                int type = abstractC2353jE.A0S();
                if (A0C != type) {
                    return false;
                }
            }
            return !this.A08.A04.A0O() || abstractC2353jE.A0V() == this.A08.A04.A0D(abstractC2353jE.A03);
        }
        throw new IndexOutOfBoundsException(A04(233, 60, 0) + abstractC2353jE + this.A08.A1L());
    }

    private boolean A0D(AbstractC2353jE abstractC2353jE, int i, int i2, long startBindNs) {
        abstractC2353jE.A08 = this.A08;
        int A0S = abstractC2353jE.A0S();
        long nanoTime = this.A08.getNanoTime();
        if (startBindNs != Long.MAX_VALUE) {
            C2342j3 c2342j3 = this.A01;
            String[] strArr = A0A;
            String str = strArr[5];
            String str2 = strArr[3];
            int charAt = str.charAt(0);
            int viewType = str2.charAt(0);
            if (charAt == viewType) {
                throw new RuntimeException();
            }
            A0A[0] = "We3abAYlnqMpJzTP";
            if (!c2342j3.A0A(A0S, nanoTime, startBindNs)) {
                return false;
            }
        }
        this.A08.A04.A0L(abstractC2353jE, i);
        this.A01.A05(abstractC2353jE.A0S(), this.A08.getNanoTime() - nanoTime);
        A09(abstractC2353jE);
        if (this.A08.A0s.A07()) {
            abstractC2353jE.A04 = i2;
            return true;
        }
        return true;
    }

    public final int A0E() {
        return this.A05.size();
    }

    public final int A0F(int i) {
        if (i >= 0) {
            C7O c7o = this.A08;
            if (A0A[0].length() != 16) {
                throw new RuntimeException();
            }
            A0A[0] = "3KxCBQFQ0qPnaRqJ";
            if (i < c7o.A0s.A03()) {
                if (!this.A08.A0s.A07()) {
                    return i;
                }
                return this.A08.A00.A0D(i);
            }
        }
        throw new IndexOutOfBoundsException(A04(587, 17, 27) + i + A04(43, 22, 32) + this.A08.A0s.A03() + this.A08.A1L());
    }

    public final View A0G(int i) {
        return this.A05.get(i).A0H;
    }

    public final View A0H(int i) {
        return A00(i, false);
    }

    public final C2342j3 A0I() {
        if (this.A01 == null) {
            this.A01 = new C2342j3();
        }
        return this.A01;
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x026b, code lost:
    
        if (r5 == false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0271, code lost:
    
        if (r9.A0m() == false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x02a1, code lost:
    
        if (r5 == false) goto L106;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final AbstractC2353jE A0J(int i, boolean z, long j) {
        C2336ix c2336ix;
        boolean fromScrapOrHiddenOrCache;
        C7O A0H;
        if (i >= 0 && i < this.A08.A0s.A03()) {
            boolean z2 = false;
            AbstractC2353jE abstractC2353jE = null;
            boolean fromScrapOrHiddenOrCache2 = this.A08.A0s.A07();
            if (fromScrapOrHiddenOrCache2) {
                abstractC2353jE = A01(i);
                z2 = abstractC2353jE != null;
            }
            if (abstractC2353jE == null && (abstractC2353jE = A02(i, z)) != null) {
                boolean fromScrapOrHiddenOrCache3 = A0C(abstractC2353jE);
                if (!fromScrapOrHiddenOrCache3) {
                    if (!z) {
                        abstractC2353jE.A0e(4);
                        boolean fromScrapOrHiddenOrCache4 = abstractC2353jE.A0o();
                        if (fromScrapOrHiddenOrCache4) {
                            this.A08.removeDetachedView(abstractC2353jE.A0H, false);
                            abstractC2353jE.A0d();
                        } else {
                            boolean fromScrapOrHiddenOrCache5 = abstractC2353jE.A0t();
                            if (fromScrapOrHiddenOrCache5) {
                                abstractC2353jE.A0Z();
                            }
                        }
                        A0c(abstractC2353jE);
                    }
                    abstractC2353jE = null;
                } else {
                    z2 = true;
                }
            }
            if (abstractC2353jE == null) {
                int A0D = this.A08.A00.A0D(i);
                if (A0D < 0 || A0D >= this.A08.A04.A0B()) {
                    throw new IndexOutOfBoundsException(A04(187, 46, 112) + i + A04(13, 8, 126) + A0D + A04(35, 8, 119) + this.A08.A0s.A03() + this.A08.A1L());
                }
                int A0C = this.A08.A04.A0C(A0D);
                boolean fromScrapOrHiddenOrCache6 = this.A08.A04.A0O();
                if (fromScrapOrHiddenOrCache6 && (abstractC2353jE = A03(this.A08.A04.A0D(A0D), A0C, z)) != null) {
                    abstractC2353jE.A03 = A0D;
                    z2 = true;
                }
                if (abstractC2353jE == null && 0 != 0) {
                    throw new NullPointerException(A04(562, 25, 17));
                }
                if (abstractC2353jE == null && (abstractC2353jE = A0I().A03(A0C)) != null) {
                    abstractC2353jE.A0b();
                    boolean fromScrapOrHiddenOrCache7 = C7O.A1C;
                    if (fromScrapOrHiddenOrCache7) {
                        A0A(abstractC2353jE);
                    }
                }
                if (abstractC2353jE == null) {
                    long nanoTime = this.A08.getNanoTime();
                    if (j != Long.MAX_VALUE) {
                        boolean fromScrapOrHiddenOrCache8 = this.A01.A0B(A0C, nanoTime, j);
                        if (!fromScrapOrHiddenOrCache8) {
                            String[] strArr = A0A;
                            if (strArr[7].charAt(8) != strArr[6].charAt(8)) {
                                A0A[4] = "fdYbLns5cH4Uqi6qZhk44zURNmgZymnf";
                                return null;
                            }
                            throw new RuntimeException();
                        }
                    }
                    abstractC2353jE = this.A08.A04.A0E(this.A08, A0C);
                    fromScrapOrHiddenOrCache = C7O.A1E;
                    if (fromScrapOrHiddenOrCache && (A0H = C7O.A0H(abstractC2353jE.A0H)) != null) {
                        abstractC2353jE.A09 = new WeakReference<>(A0H);
                    }
                    this.A01.A06(A0C, this.A08.getNanoTime() - nanoTime);
                }
            }
            if (z2 && !this.A08.A0s.A07() && abstractC2353jE.A0v(JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE)) {
                abstractC2353jE.A0f(0, JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE);
                if (this.A08.A0s.A0C) {
                    int changeFlags = AbstractC2331is.A06(abstractC2353jE);
                    C2330ir info = this.A08.A05.A0F(this.A08.A0s, abstractC2353jE, changeFlags | 4096, abstractC2353jE.A0W());
                    this.A08.A1r(abstractC2353jE, info);
                }
            }
            boolean z3 = false;
            if (this.A08.A0s.A07() && abstractC2353jE.A0l()) {
                abstractC2353jE.A04 = i;
            } else {
                if (abstractC2353jE.A0l()) {
                    boolean A0r = abstractC2353jE.A0r();
                    String[] strArr2 = A0A;
                    if (strArr2[7].charAt(8) != strArr2[6].charAt(8)) {
                        A0A[0] = "CFgmPUuP3iY97c6j";
                    }
                    throw new RuntimeException();
                }
                int A0D2 = this.A08.A00.A0D(i);
                String[] strArr3 = A0A;
                if (strArr3[5].charAt(0) != strArr3[3].charAt(0)) {
                    String[] strArr4 = A0A;
                    strArr4[7] = "X7QTRdk7uAM61axx4OEln6Aqdeva9JgC";
                    strArr4[6] = "2m6xaCXVB1m17nX7qirmFmeuDGGSO6lD";
                    z3 = A0D(abstractC2353jE, A0D2, i, j);
                }
                throw new RuntimeException();
            }
            View view = abstractC2353jE.A0H;
            if (A0A[4].charAt(3) == 'b') {
                String[] strArr5 = A0A;
                strArr5[5] = "ymmTOXtQojU6rRVoJMbBfUBDtyf096Lh";
                strArr5[3] = "VCdUEMmmzbvfUZbBbNepcELfQrdDFyYX";
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams == null) {
                    c2336ix = (C2336ix) this.A08.generateDefaultLayoutParams();
                    abstractC2353jE.A0H.setLayoutParams(c2336ix);
                } else if (!this.A08.checkLayoutParams(layoutParams)) {
                    ViewGroup.LayoutParams generateLayoutParams = this.A08.generateLayoutParams(layoutParams);
                    String[] strArr6 = A0A;
                    if (strArr6[2].charAt(0) == strArr6[1].charAt(0)) {
                        String[] strArr7 = A0A;
                        strArr7[2] = "kqh2PWeHxAL2DpvJL4iRMn0O7hIhaGbv";
                        strArr7[1] = "kmhB7ilmrFE2abkLd0sKBmmWm2mWDiPj";
                        c2336ix = (C2336ix) generateLayoutParams;
                        abstractC2353jE.A0H.setLayoutParams(c2336ix);
                    }
                } else {
                    c2336ix = (C2336ix) layoutParams;
                }
                c2336ix.A00 = abstractC2353jE;
                c2336ix.A02 = z2 && z3;
                return abstractC2353jE;
            }
            throw new RuntimeException();
        }
        throw new IndexOutOfBoundsException(A04(293, 22, 52) + i + A04(12, 1, 99) + i + A04(21, 14, 104) + this.A08.A0s.A03() + this.A08.A1L());
    }

    public final List<AbstractC2353jE> A0K() {
        return this.A07;
    }

    public final void A0L() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            this.A06.get(i).A0X();
        }
        int i2 = this.A05.size();
        for (int scrapCount = 0; scrapCount < i2; scrapCount++) {
            this.A05.get(scrapCount).A0X();
        }
        ArrayList<AbstractC2353jE> arrayList = this.A02;
        String[] strArr = A0A;
        String str = strArr[2];
        String str2 = strArr[1];
        int scrapCount2 = str.charAt(0);
        int cachedCount = str2.charAt(0);
        if (scrapCount2 != cachedCount) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0A;
        strArr2[7] = "w7WcMXH384MQxArKBWq9tfOfmOANhXYh";
        strArr2[6] = "ji6HgViVTGyvfONq8Vqt8Uaju4D1iJHU";
        if (arrayList != null) {
            int changedScrapCount = this.A02.size();
            for (int scrapCount3 = 0; scrapCount3 < changedScrapCount; scrapCount3++) {
                this.A02.get(scrapCount3).A0X();
            }
        }
    }

    public final void A0M() {
        this.A05.clear();
        if (this.A02 != null) {
            this.A02.clear();
        }
    }

    public final void A0N() {
        int size = this.A06.size();
        for (int i = 0; i < size; i++) {
            C2336ix c2336ix = (C2336ix) this.A06.get(i).A0H.getLayoutParams();
            if (c2336ix != null) {
                c2336ix.A01 = true;
            }
        }
    }

    public final void A0O() {
        if (this.A08.A04 != null && this.A08.A04.A0O()) {
            int size = this.A06.size();
            for (int i = 0; i < size; i++) {
                AbstractC2353jE abstractC2353jE = this.A06.get(i);
                int i2 = A0A[0].length();
                if (i2 != 16) {
                    throw new RuntimeException();
                }
                String[] strArr = A0A;
                strArr[2] = "kx9etu5Uswf3mlSSd54JM5SDJxoMGNTv";
                strArr[1] = "kxxNK4Rys8aPJuu822sP3fs8sDM7v1G0";
                if (abstractC2353jE != null) {
                    abstractC2353jE.A0e(6);
                    abstractC2353jE.A0j(null);
                }
            }
            return;
        }
        A06();
    }

    public final void A0P() {
        int extraCache;
        if (this.A08.A06 != null) {
            AbstractC2335iw abstractC2335iw = this.A08.A06;
            if (A0A[0].length() == 16) {
                String[] strArr = A0A;
                strArr[2] = "kSelswvDf1EbxUzrii1mBr6dHJR0d4zj";
                strArr[1] = "kcuGN1lunmBh6z5P1vsNJWvgiUTpOK0Q";
                extraCache = abstractC2335iw.A00;
            }
            throw new RuntimeException();
        }
        extraCache = 0;
        this.A00 = this.A03 + extraCache;
        int extraCache2 = this.A06.size();
        for (int i = extraCache2 - 1; i >= 0; i--) {
            int size = this.A06.size();
            String[] strArr2 = A0A;
            String str = strArr2[2];
            String str2 = strArr2[1];
            int i2 = str.charAt(0);
            int extraCache3 = str2.charAt(0);
            if (i2 != extraCache3) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0A;
            strArr3[2] = "kpxxdOz3cEfo3MLV8RPQuR2Jasv2n6jF";
            strArr3[1] = "kgO1H2GjmHeLX2ZusVi9gFRUJKE1zGI0";
            int extraCache4 = this.A00;
            if (size > extraCache4) {
                A07(i);
            } else {
                return;
            }
        }
    }

    public final void A0Q() {
        this.A05.clear();
        A06();
    }

    public final void A0R(int i) {
        this.A03 = i;
        A0P();
    }

    public final void A0S(int i, int i2) {
        int size = this.A06.size();
        for (int i3 = 0; i3 < size; i3++) {
            AbstractC2353jE abstractC2353jE = this.A06.get(i3);
            if (abstractC2353jE != null) {
                int cachedCount = abstractC2353jE.A03;
                if (cachedCount >= i) {
                    abstractC2353jE.A0h(i2, true);
                }
            }
        }
    }

    public final void A0T(int i, int i2) {
        int i3;
        int i4;
        int i5;
        if (i < i2) {
            i3 = i;
            i4 = i2;
            i5 = -1;
        } else {
            i3 = i2;
            i4 = i;
            i5 = 1;
        }
        int size = this.A06.size();
        for (int i6 = 0; i6 < size; i6++) {
            AbstractC2353jE abstractC2353jE = this.A06.get(i6);
            if (abstractC2353jE != null) {
                int start = abstractC2353jE.A03;
                if (start >= i3) {
                    int start2 = abstractC2353jE.A03;
                    if (start2 > i4) {
                        continue;
                    } else {
                        int i7 = abstractC2353jE.A03;
                        String[] strArr = A0A;
                        String str = strArr[5];
                        String str2 = strArr[3];
                        int end = str.charAt(0);
                        int start3 = str2.charAt(0);
                        if (end == start3) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A0A;
                        strArr2[2] = "kvvW4F2OCwdEIl1qwIuxYVFpmp0ugJY5";
                        strArr2[1] = "kzcCp2wTfEGQm2KGuN32b5oIYABnQWPG";
                        if (i7 == i) {
                            int end2 = i2 - i;
                            abstractC2353jE.A0h(end2, false);
                        } else {
                            abstractC2353jE.A0h(i5, false);
                        }
                    }
                } else {
                    continue;
                }
            }
        }
    }

    public final void A0U(int i, int i2) {
        int positionEnd;
        int i3 = i + i2;
        for (int i4 = this.A06.size() - 1; i4 >= 0; i4--) {
            AbstractC2353jE abstractC2353jE = this.A06.get(i4);
            if (abstractC2353jE != null && (positionEnd = abstractC2353jE.A03) >= i && positionEnd < i3) {
                abstractC2353jE.A0e(2);
                A07(i4);
            }
        }
    }

    public final void A0V(int i, int i2, boolean z) {
        int i3 = i + i2;
        int removedEnd = this.A06.size();
        for (int i4 = removedEnd - 1; i4 >= 0; i4--) {
            AbstractC2353jE abstractC2353jE = this.A06.get(i4);
            if (abstractC2353jE != null) {
                int removedEnd2 = abstractC2353jE.A03;
                if (removedEnd2 >= i3) {
                    int removedEnd3 = -i2;
                    abstractC2353jE.A0h(removedEnd3, z);
                } else {
                    int removedEnd4 = abstractC2353jE.A03;
                    if (removedEnd4 >= i) {
                        abstractC2353jE.A0e(8);
                        A07(i4);
                    }
                }
            }
        }
    }

    public final void A0W(View view) {
        AbstractC2353jE A0F = C7O.A0F(view);
        A0F.A0F = null;
        A0F.A0G = false;
        A0F.A0Z();
        A0c(A0F);
    }

    public final void A0X(View view) {
        AbstractC2353jE A0F = C7O.A0F(view);
        if (A0F.A0v(12) || !A0F.A0q() || this.A08.A25(A0F)) {
            boolean A0m = A0F.A0m();
            if (A0A[0].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A0A;
            strArr[5] = "cscHAR4ImnAFzAxZJ9yqjMNa91RcN8Vb";
            strArr[3] = "pspTzLDNU823NSI2ymIgIumCpfqVQlal";
            if (!A0m || A0F.A0n() || this.A08.A04.A0O()) {
                A0F.A0i(this, false);
                this.A05.add(A0F);
                return;
            }
            throw new IllegalArgumentException(A04(65, 122, 118) + this.A08.A1L());
        }
        if (this.A02 == null) {
            this.A02 = new ArrayList<>();
        }
        A0F.A0i(this, true);
        this.A02.add(A0F);
    }

    public final void A0Y(View view) {
        AbstractC2353jE A0F = C7O.A0F(view);
        if (A0F.A0p()) {
            this.A08.removeDetachedView(view, false);
        }
        if (A0F.A0o()) {
            A0F.A0d();
        } else if (A0F.A0t()) {
            A0F.A0Z();
        }
        A0c(A0F);
    }

    public final void A0Z(AbstractC2323ik abstractC2323ik, AbstractC2323ik abstractC2323ik2, boolean z) {
        A0Q();
        A0I().A08(abstractC2323ik, abstractC2323ik2, z);
    }

    public final void A0a(C2342j3 c2342j3) {
        if (this.A01 != null) {
            C2342j3 c2342j32 = this.A01;
            String[] strArr = A0A;
            if (strArr[7].charAt(8) == strArr[6].charAt(8)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0A;
            strArr2[5] = "eg5celMCH5XhNc8VzkIGx3YtNAPnP9H4";
            strArr2[3] = "1J6YUmXidV7MMEP0bzwuQdNnIs5cPq10";
            c2342j32.A04();
        }
        this.A01 = c2342j3;
        if (c2342j3 != null) {
            this.A01.A07(this.A08.getAdapter());
        }
    }

    public final void A0b(AbstractC2351jC abstractC2351jC) {
        this.A04 = abstractC2351jC;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x00a4, code lost:
    
        if (r0 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c2, code lost:
    
        if (r5 > 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c4, code lost:
    
        r0 = r10.A0v(526);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00ca, code lost:
    
        if (r0 != false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cc, code lost:
    
        r2 = r9.A06.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d4, code lost:
    
        if (r2 < r9.A00) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d6, code lost:
    
        if (r2 <= 0) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d8, code lost:
    
        A07(0);
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00dd, code lost:
    
        r0 = com.facebook.ads.redexgen.X.C7O.A1E;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e1, code lost:
    
        if (r0 == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00e3, code lost:
    
        if (r2 <= 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e5, code lost:
    
        r0 = r9.A08.A02.A05(r10.A03);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ef, code lost:
    
        if (r0 != false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f1, code lost:
    
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
    
        if (r2 < 0) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00f5, code lost:
    
        r1 = r9.A06.get(r2).A03;
        r0 = r9.A08.A02.A05(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0107, code lost:
    
        if (r0 != false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0128, code lost:
    
        r2 = r2 - 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0109, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010b, code lost:
    
        r9.A06.add(r2, r10);
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0111, code lost:
    
        if (r7 != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0113, code lost:
    
        A0e(r10, true);
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0132, code lost:
    
        if (r5 > 0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x012b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void A0c(AbstractC2353jE abstractC2353jE) {
        boolean A0K;
        boolean transientStatePreventsRecycling;
        boolean z;
        String[] strArr;
        if (abstractC2353jE.A0o() || abstractC2353jE.A0H.getParent() != null) {
            throw new IllegalArgumentException(A04(315, 56, 79) + abstractC2353jE.A0o() + A04(0, 12, 75) + (abstractC2353jE.A0H.getParent() != null) + this.A08.A1L());
        }
        boolean A0p = abstractC2353jE.A0p();
        String[] strArr2 = A0A;
        if (strArr2[2].charAt(0) != strArr2[1].charAt(0)) {
            throw new RuntimeException();
        }
        A0A[4] = "QZZbfikyhDCMiV1imXgamooHNWBI4VfH";
        if (!A0p) {
            if (abstractC2353jE.A0s()) {
                throw new IllegalArgumentException(A04(452, 110, 76) + this.A08.A1L());
            }
            A0K = abstractC2353jE.A0K();
            if (this.A08.A04 != null && A0K) {
                boolean transientStatePreventsRecycling2 = this.A08.A04.A0P(abstractC2353jE);
                if (transientStatePreventsRecycling2) {
                    transientStatePreventsRecycling = true;
                    z = false;
                    boolean z2 = false;
                    if (!transientStatePreventsRecycling) {
                        boolean transientStatePreventsRecycling3 = abstractC2353jE.A0u();
                    }
                    int i = this.A00;
                    strArr = A0A;
                    if (strArr[2].charAt(0) == strArr[1].charAt(0)) {
                        A0A[4] = "JXkbPmQXP2BcwiEI3FqqjfiGok6rwhAB";
                    } else {
                        A0A[4] = "iMRb6lH7bzEtCSJD4TfZYArDATXy6kqw";
                    }
                    this.A08.A0t.A0B(abstractC2353jE);
                    if (z && !z2 && A0K) {
                        abstractC2353jE.A08 = null;
                        return;
                    }
                    return;
                }
            }
            transientStatePreventsRecycling = false;
            z = false;
            boolean z22 = false;
            if (!transientStatePreventsRecycling) {
            }
            int i2 = this.A00;
            strArr = A0A;
            if (strArr[2].charAt(0) == strArr[1].charAt(0)) {
            }
            this.A08.A0t.A0B(abstractC2353jE);
            if (z) {
                return;
            } else {
                return;
            }
        }
        throw new IllegalArgumentException(A04(371, 81, 12) + abstractC2353jE + this.A08.A1L());
    }

    public final void A0d(AbstractC2353jE abstractC2353jE) {
        boolean z;
        z = abstractC2353jE.A0G;
        if (z) {
            this.A02.remove(abstractC2353jE);
        } else {
            this.A05.remove(abstractC2353jE);
        }
        abstractC2353jE.A0F = null;
        abstractC2353jE.A0G = false;
        abstractC2353jE.A0Z();
    }

    public final void A0e(AbstractC2353jE abstractC2353jE, boolean z) {
        C7O.A0t(abstractC2353jE);
        if (abstractC2353jE.A0v(16384)) {
            abstractC2353jE.A0f(0, 16384);
            AbstractC2255hb.A0B(abstractC2353jE.A0H, null);
        }
        if (z) {
            A0B(abstractC2353jE);
        }
        abstractC2353jE.A08 = null;
        A0I().A09(abstractC2353jE);
    }
}
