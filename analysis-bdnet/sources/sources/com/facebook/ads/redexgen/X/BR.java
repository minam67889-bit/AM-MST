package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.chromium.base.metrics.ScopedSysTraceEvent;

/* JADX WARN: Unexpected interfaces in signature: [com.facebook.ads.internal.util.common.Stateful<android.os.Bundle>] */
/* loaded from: assets/audience_network/classes.dex */
public class BR {
    public static byte[] A0L;
    public static String[] A0M = {"nkjKj1MvUJoP2SJPYcgbaBjYPy4EsWOF", "UEaFlSlVJfgDxU2HAGuUlGjRHCZL3UC5", "HKOtxcgqDUvcB7Zt0rEFxuoEqCvYEtNO", "rowCAjgGiKT2zEBSq3xmGSL0Kf3UrlyG", "EJAz0i2eNdRPLBpGYGjYpv17GQTuD6uU", "hVbT72qq2pp8XHiEw", "RwROuq5e2nKVw7hJaeybV0hHAIDx5UQQ", "neuOh54FNoDLqHEFUxNtW4G7fWRiy4GW"};
    public int A01;
    public int A02;
    public InterfaceC2144fm A03;
    public boolean A05;
    public boolean A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public final JY A0C;
    public final C1333Hi A0D;
    public final InterfaceC2599nG A0E;
    public final InterfaceC2145fn A0F;
    public final InterfaceC2050eF A0G;
    public final C2048eD A0H;
    public final String A0J;
    public final Map<String, String> A0K;
    public final Object A0I = new Object();
    public int A00 = 0;
    public String A04 = null;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 34 out of bounds for length 23
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:636)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    public BR(C1333Hi c1333Hi, InterfaceC2599nG interfaceC2599nG, InterfaceC2145fn interfaceC2145fn, String str, boolean z, int i, int i2, boolean z2, Bundle bundle, Map<String, String> map, InterfaceC2050eF interfaceC2050eF) {
        this.A02 = 0;
        this.A01 = 0;
        this.A05 = false;
        this.A0B = false;
        this.A07 = false;
        this.A06 = false;
        this.A09 = false;
        this.A0A = false;
        this.A0D = c1333Hi;
        this.A0E = interfaceC2599nG;
        this.A0F = interfaceC2145fn;
        this.A0J = str;
        this.A0K = map;
        this.A08 = z;
        this.A07 = z2;
        this.A0G = interfaceC2050eF;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BT(this, 0.5d, -1.0d, 2.0d, true));
        arrayList.add(new BS(this, 1.0E-7d, -1.0d, 0.001d, false));
        if (bundle != null) {
            this.A0C = new JY(arrayList, bundle.getBundle(A0H(6, 16, 29)), this.A0G);
            this.A02 = bundle.getInt(A0H(97, 18, 63));
            this.A01 = bundle.getInt(A0H(79, 18, 116));
            this.A06 = bundle.getBoolean(A0H(146, 10, 26), false);
            this.A0A = bundle.getBoolean(A0H(171, 20, 95), false);
            this.A09 = bundle.getBoolean(A0H(156, 15, 100), false);
        } else {
            this.A02 = i;
            this.A01 = i2;
            this.A0C = new JY(arrayList, this.A0G);
        }
        this.A05 = C2578mv.A2Y(this.A0D);
        this.A0B = C2578mv.A2c(this.A0D);
        this.A0H = new C2048eD(new Handler(), this);
    }

    public static String A0H(int i, int i2, int i3) {
        byte[] copyOfRange = Arrays.copyOfRange(A0L, i, i + i2);
        for (int i4 = 0; i4 < copyOfRange.length; i4++) {
            copyOfRange[i4] = (byte) ((copyOfRange[i4] - i3) - 48);
        }
        return new String(copyOfRange);
    }

    public static void A0O() {
        A0L = new byte[]{11, 13, 30, 19, 25, 24, -82, -79, -98, -62, -82, -71, -74, -63, -58, -102, -82, -69, -82, -76, -78, -65, -18, 1, -10, -6, -14, -20, -6, 0, -98, -81, -92, -88, -96, -64, -63, -56, -69, -67, -48, -59, -55, -63, -69, -55, -49, -106, -105, -98, -111, -88, -90, -101, -97, -105, -111, -97, -91, -29, -12, -29, -20, -14, -35, -25, -20, -30, -29, -10, -31, -12, -21, -20, -24, -35, -11, -31, -18, 16, 5, 23, 24, -26, 19, 25, 18, 8, 5, 22, 29, -8, 13, 17, 9, -15, -9, -37, -48, -30, -29, -65, -31, -34, -42, -31, -44, -30, -30, -61, -40, -36, -44, -68, -62, -48, -58, -60, -41, -62, -48, -42, 23, 13, 32, 30, 9, 23, 29, 13, 5, 27, 23, -91, -89, -102, -91, 31, 35, -22, -18, -29, -25, -33, 13, 20, -67, -66, -85, -66, -81, -87, -82, -71, -72, -81, 7, 8, -11, 8, -7, -13, 1, 6, -9, -13, -6, -3, 6, -7, -8, 2, 3, -16, 3, -12, -18, 5, -8, -12, 6, -16, -15, -5, -12, -18, -11, -8, 1, -12, -13, -66, -77, -73, -81, 0, -10, -21, -9, -19, -18, 5, -5, -4, -16, 7, -74, -80, -88, -22, -28, -21, -1, -3, -14, -10, -18, -24, -10, -4, -26, -25, -49, -30, -29, -34, -13, -12, -34, -30, -29, -39, -74, -73, -83, -95, -72, -83, -97, -92, -102, -91, -83};
    }

    static {
        A0O();
    }

    private final float A0F() {
        return AbstractC2797qY.A00(this.A0D) * this.A0F.getVolume();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, String> A0J(EnumC2108fC enumC2108fC) {
        int currentPositionInMillis = this.A0F.getCurrentPositionInMillis();
        int i = this.A00 + 1;
        this.A00 = i;
        return A0K(enumC2108fC, currentPositionInMillis, i);
    }

    private Map<String, String> A0K(EnumC2108fC enumC2108fC, int i, int i2) {
        HashMap hashMap = new HashMap();
        AbstractC2797qY.A03(hashMap, this.A0F.getVideoStartReason() == EnumC2039e4.A03, !this.A0F.ABD());
        A0U(hashMap);
        A0S(hashMap);
        A0W(hashMap, i);
        A0V(hashMap);
        A0T(hashMap);
        A0n(enumC2108fC, hashMap);
        hashMap.put(A0H(0, 6, 122), String.valueOf(enumC2108fC.A00));
        hashMap.put(A0H(59, 11, 78), String.valueOf(i2));
        return hashMap;
    }

    private void A0M() {
        if (this.A07 && this.A06) {
            return;
        }
        A0R(this.A0J, A0J(EnumC2108fC.A04));
    }

    private void A0N() {
        if (this.A07 && this.A06) {
            return;
        }
        A0R(this.A0J, A0J(EnumC2108fC.A0A));
    }

    private final void A0P(int i, boolean z, boolean z2) {
        if (i <= 0.0d || i < this.A02) {
            return;
        }
        if (i > this.A02) {
            this.A0C.A06((i - this.A02) / 1000.0f, A0F());
            double AA9 = this.A0G.AA9();
            if (AA9 < 0.5d && C2578mv.A1i(this.A0D)) {
                InterfaceC2015df A0F = this.A0D.A0F();
                if (A0M[5].length() != 0) {
                    String[] strArr = A0M;
                    strArr[1] = "IXDsMs8MiMzYVjpFmNZXbOdNx8hS7U1p";
                    strArr[6] = "KaqaEYbZ8TBX2kyM8fVmd1OK78kemUif";
                    A0F.AM4(String.valueOf(AA9));
                }
                throw new RuntimeException();
            }
            this.A02 = i;
            if (z2 || i - this.A01 >= 5000) {
                String str = this.A0J;
                EnumC2108fC enumC2108fC = EnumC2108fC.A09;
                int i2 = this.A00 + 1;
                this.A00 = i2;
                if (A0M[2].charAt(23) != 'D') {
                    A0M[3] = "wbB4RsMYMdB1XlizYL2z4BWk89oMV6Tu";
                    A0R(str, A0K(enumC2108fC, i, i2));
                    this.A01 = this.A02;
                    this.A0C.A05();
                    return;
                }
                throw new RuntimeException();
            }
        }
        if (z) {
            if (this.A07 && this.A06) {
                return;
            }
            this.A06 = true;
            String str2 = this.A0J;
            EnumC2108fC enumC2108fC2 = EnumC2108fC.A09;
            int i3 = this.A00 + 1;
            this.A00 = i3;
            A0R(str2, A0K(enumC2108fC2, i, i3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0R(String str, Map<String, String> data) {
        this.A0E.AD1(str, data);
        if (this.A03 != null) {
            this.A03.AFo();
        }
    }

    private void A0S(Map<String, String> params) {
        C2193gZ A03 = this.A0C.A03();
        C2192gY A00 = A03.A00();
        params.put(A0H(226, 3, 77), String.valueOf(A00.A00()));
        params.put(A0H(229, 3, 60), String.valueOf(A00.A06()));
        params.put(A0H(232, 5, 16), String.valueOf(A00.A03()));
        params.put(A0H(212, 8, 89), String.valueOf(A00.A02() * 1000.0d));
        params.put(A0H(47, 12, 2), String.valueOf(A00.A01() * 1000.0d));
        params.put(A0H(122, 7, 122), String.valueOf(A00.A04() * 1000.0d));
        if (this.A04 != null) {
            params.put(A0H(220, 6, 64), this.A04);
        }
        C2192gY A01 = A03.A01();
        params.put(A0H(195, 3, 90), String.valueOf(A01.A00()));
        params.put(A0H(198, 3, 81), String.valueOf(A01.A06()));
        params.put(A0H(ads_mobile_sdk.fh.d1, 5, 95), String.valueOf(A01.A03()));
        params.put(A0H(22, 8, 93), String.valueOf(A01.A02() * 1000.0d));
        params.put(A0H(35, 12, 44), String.valueOf(A01.A01() * 1000.0d));
        params.put(A0H(115, 7, 51), String.valueOf(A01.A04() * 1000.0d));
    }

    private void A0T(Map<String, String> params) {
        if (this.A0K != null) {
            params.putAll(this.A0K);
        }
    }

    private void A0U(Map<String, String> map) {
        map.put(A0H(70, 9, 76), String.valueOf(this.A0F.AB8()));
        map.put(A0H(133, 4, 5), Long.toString(this.A0F.getInitialBufferTime()));
    }

    private void A0V(Map<String, String> params) {
        Rect rect = new Rect();
        this.A0F.getGlobalVisibleRect(rect);
        params.put(A0H(137, 2, ScopedSysTraceEvent.MAX_SECTION_NAME_LEN), String.valueOf(rect.top));
        params.put(A0H(131, 2, 123), String.valueOf(rect.left));
        params.put(A0H(129, 2, 109), String.valueOf(this.A0F.getMeasuredHeight()));
        params.put(A0H(144, 2, 109), String.valueOf(this.A0F.getMeasuredWidth()));
        WindowManager windowManager = (WindowManager) this.A0D.getSystemService(A0H(237, 6, 6));
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        params.put(A0H(206, 3, 16), String.valueOf(displayMetrics.heightPixels));
        params.put(A0H(209, 3, 68), String.valueOf(displayMetrics.widthPixels));
    }

    private void A0W(Map<String, String> map, int i) {
        map.put(A0H(30, 5, 11), String.valueOf(System.currentTimeMillis()));
        map.put(A0H(139, 5, 74), String.valueOf(this.A01 / 1000.0f));
        map.put(A0H(191, 4, 26), String.valueOf(i / 1000.0f));
    }

    public final int A0b() {
        return this.A02;
    }

    public final Bundle A0c() {
        A0l(A0b(), A0b());
        Bundle bundle = new Bundle();
        bundle.putInt(A0H(97, 18, 63), this.A02);
        bundle.putInt(A0H(79, 18, 116), this.A01);
        bundle.putBoolean(A0H(146, 10, 26), this.A06);
        bundle.putBoolean(A0H(171, 20, 95), this.A0A);
        bundle.putBoolean(A0H(156, 15, 100), this.A09);
        bundle.putBundle(A0H(6, 16, 29), this.A0C.A02());
        return bundle;
    }

    public final void A0d() {
        if (this.A07 && this.A06) {
            return;
        }
        A0R(this.A0J, A0J(EnumC2108fC.A07));
    }

    public final void A0e() {
        if (this.A07 && this.A06) {
            return;
        }
        A0R(this.A0J, A0J(EnumC2108fC.A08));
    }

    public final void A0f() {
        if (A0F() < 0.05d) {
            synchronized (this.A0I) {
                if (this.A08) {
                    A0M();
                    this.A08 = false;
                }
            }
            return;
        }
        synchronized (this.A0I) {
            if (!this.A08) {
                A0N();
                this.A08 = true;
            }
        }
    }

    public final void A0g() {
        this.A0D.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this.A0H);
    }

    public final void A0h() {
        this.A0D.getContentResolver().unregisterContentObserver(this.A0H);
    }

    public final void A0i(int i) {
        if (this.A07 && this.A06) {
            return;
        }
        this.A0C.A04();
        A0R(this.A0J, A0J(EnumC2108fC.A05));
        if (this.A05) {
            A0P(i, false, true);
        } else {
            A0P(i, false, ((double) i) < 2000.0d);
        }
        if (this.A0B) {
            this.A0C.A05();
        }
    }

    public final void A0j(int i) {
        A0P(i, true, false);
        if (!this.A07) {
            this.A01 = 0;
            this.A02 = 0;
        }
        this.A0C.A05();
        if (A0M[0].charAt(27) == 'x') {
            throw new RuntimeException();
        }
        String[] strArr = A0M;
        strArr[1] = "JPrD5J3vhe3pz0AJOAeTSkTsuFGXfUH2";
        strArr[6] = "ShZP65JTAKkcxxpQQxXBQksO2Rn2KUSA";
        this.A0C.A04();
    }

    public final void A0k(int i) {
        A0P(i, false, false);
    }

    public final void A0l(int i, int i2) {
        A0P(i, true, false);
        this.A01 = i2;
        this.A02 = i2;
        this.A0C.A05();
        this.A0C.A04();
    }

    public final void A0m(InterfaceC2144fm interfaceC2144fm) {
        this.A03 = interfaceC2144fm;
    }

    public void A0n(EnumC2108fC enumC2108fC, Map<String, String> params) {
    }

    public final void A0o(BR br) {
        br.A06 = this.A06;
        br.A07 = this.A07;
        br.A0A = this.A0A;
        br.A09 = this.A09;
        br.A02 = this.A02;
        br.A01 = this.A01;
    }
}
