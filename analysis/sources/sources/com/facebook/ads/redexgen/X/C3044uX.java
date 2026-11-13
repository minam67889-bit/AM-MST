package com.facebook.ads.redexgen.X;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.facebook.ads.redexgen.X.uX, reason: case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C3044uX {
    public static String[] A0F = {"O1TuWn2oVwfpJb25zzM", "NZTmxIpTWNay1IFhf77gwSiN", "6YvTj0PDYBf9oabc", "hLQUOH3WvfdqypgyVrSf", "", "dKhZhLlhjCHlFiT3p", "O", "gvExGT1ovF"};
    public final float A00;
    public final int A01;
    public final LA A02;
    public final C2119fN A03;
    public final C1333Hi A04;
    public final InterfaceC2599nG A05;
    public final C2607nO A06;
    public final C2792qT A07;
    public final InterfaceC2834r9 A08;
    public final ViewOnClickListenerC1259El A09;
    public final C1156Am A0A;
    public final C1914c2 A0B;
    public final String A0C;
    public final boolean A0D;
    public final boolean A0E;

    public C3044uX(float f, String str, C1333Hi c1333Hi, C2119fN c2119fN, LA la, InterfaceC2834r9 interfaceC2834r9, ViewOnClickListenerC1259El viewOnClickListenerC1259El, int i, boolean z, InterfaceC2599nG interfaceC2599nG, C1914c2 c1914c2, C2792qT c2792qT, C1156Am c1156Am, C2607nO c2607nO, boolean z2) {
        this.A00 = f;
        this.A0C = str;
        this.A09 = viewOnClickListenerC1259El;
        this.A03 = c2119fN;
        this.A0E = z2;
        this.A0D = z;
        this.A01 = i;
        this.A04 = c1333Hi;
        this.A05 = interfaceC2599nG;
        this.A08 = interfaceC2834r9;
        this.A0B = c1914c2;
        this.A07 = c2792qT;
        this.A02 = la;
        this.A0A = c1156Am;
        this.A06 = c2607nO;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.6q] */
    private C10736q A00() {
        final C1333Hi c1333Hi = this.A04;
        final ViewOnClickListenerC1259El viewOnClickListenerC1259El = this.A09;
        final int i = this.A01;
        final boolean z = this.A0D;
        final C2119fN c2119fN = this.A03;
        final String str = this.A0C;
        final InterfaceC2599nG interfaceC2599nG = this.A05;
        final InterfaceC2834r9 interfaceC2834r9 = this.A08;
        final C1914c2 c1914c2 = this.A0B;
        final C2792qT c2792qT = this.A07;
        final LA la = this.A02;
        final C1156Am c1156Am = this.A0A;
        final C2607nO c2607nO = this.A06;
        final boolean z2 = this.A0E;
        return new AbstractC1266Es(c1333Hi, viewOnClickListenerC1259El, i, z, c2119fN, str, interfaceC2599nG, interfaceC2834r9, c1914c2, c2792qT, la, c1156Am, c2607nO, z2) { // from class: com.facebook.ads.redexgen.X.6q
            public static String[] A00 = {"N7OXH9qvlWTVssEr7oGSyhpdDSDxGSId", "py7bPco3tvsxXK6yI01oyx5Scso4tYiS", "D3qQdq9vwJXGPXeaW4sym", "rA9GQuWh1v8MwEQs19L99", "iUGelHI5q3GSb2vmggMKT6aEm", "A5eSnha6sZZ4dJLba8wbFJzM", "rjAjh6IcodbMlLfnEBSZmavITDcFPq33", "zNVhygPMyaCS9fHd3QkcxD9ci33V1esn"};
            public static final int A01 = (int) (AbstractC2760px.A02 * 152.0f);

            {
                int i2 = getResources().getConfiguration().orientation;
                A00();
                A07(i2);
                A09(i2);
                AbstractC2801qc.A0L(this.A0Q);
                A06(i2);
                A02(i2);
                A05(i2);
                A0A(((AbstractC1266Es) this).A06, i2);
                A0A(((AbstractC1266Es) this).A05, i2);
                A04(i2);
                A03(i2);
                A08(i2);
                A0B(((AbstractC1266Es) this).A04, i2);
                addView(this.A0P);
            }

            private void A00() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.addRule(13);
                int i2 = (int) (getResources().getDisplayMetrics().widthPixels * 0.1f);
                layoutParams.setMargins(i2, 0, i2, 0);
                this.A0O.setLayoutParams(layoutParams);
            }

            private void A01(int i2) {
                if (((AbstractC2999to) this).A08.getParent() != null) {
                    AbstractC2801qc.A0K(((AbstractC2999to) this).A08);
                }
                if (i2 == 1) {
                    A10(this.A0P);
                    this.A0P.addView(this.A0K);
                    this.A0P.addView(this.A0H);
                    this.A0P.addView(((AbstractC2999to) this).A08);
                    this.A0P.addView(this.A0L);
                    this.A0P.addView(this.A0W);
                    A0x(this.A0P, ((AbstractC1266Es) this).A06);
                    A0x(this.A0P, ((AbstractC1266Es) this).A05);
                    return;
                }
                this.A0O.addView(((AbstractC2999to) this).A09);
                this.A0O.addView(this.A0R);
                this.A0O.addView(this.A0Q);
                this.A0O.addView(((AbstractC2999to) this).A08);
                this.A0O.addView(this.A0H);
                A10(this.A0O);
                this.A0O.addView(this.A0K);
                this.A0P.addView(this.A0W);
                this.A0P.addView(this.A0O);
                this.A0P.addView(this.A0L);
                A0x(this.A0P, ((AbstractC1266Es) this).A06);
                A0x(this.A0P, ((AbstractC1266Es) this).A05);
            }

            private void A02(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0L.getLayoutParams();
                layoutParams.setMargins(0, 0, AbstractC2758pv.A0n, 0);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                this.A0L.setLayoutParams(layoutParams);
                this.A0L.setPadding(AbstractC2758pv.A0y, AbstractC2758pv.A0y, 0, 0);
            }

            private void A03(int i2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, AbstractC1266Es.A0j);
                if (i2 == 1) {
                    if (this.A0H.getVisibility() == 8) {
                        boolean A11 = A11();
                        String[] strArr = A00;
                        if (strArr[7].charAt(10) == strArr[6].charAt(10)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A00;
                        strArr2[2] = "SF52naqpOAMEycSjQDLj4";
                        strArr2[3] = "cdx5YmHkb5dM57PeCCgIj";
                        if (A11 && ((AbstractC1266Es) this).A04 != null) {
                            layoutParams.addRule(2, ((AbstractC1266Es) this).A04.getId());
                            layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0y);
                        }
                    }
                    layoutParams.addRule(2, this.A0H.getId());
                    layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0e);
                } else {
                    if (this.A0S.A2D()) {
                        layoutParams.height = AbstractC1266Es.A0h;
                    }
                    layoutParams.setMargins(0, 0, 0, 0);
                    layoutParams.addRule(3, this.A0K.getId());
                }
                layoutParams.addRule(14);
                ((AbstractC2999to) this).A08.setLayoutParams(layoutParams);
                A0p();
            }

            private void A04(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0K.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.removeRule(3);
                    layoutParams.addRule(2, ((AbstractC2999to) this).A08.getId());
                } else {
                    layoutParams.removeRule(2);
                    layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0y);
                    layoutParams.addRule(3, this.A0Q.getId());
                }
                ImageView imageView = this.A0K;
                if (A00[0].charAt(8) != 'l') {
                    throw new RuntimeException();
                }
                String[] strArr = A00;
                strArr[7] = "IjkPzmoEpckjtFDhj4UQM5Ml7YrDt4BZ";
                strArr[6] = "nHJbeh13cLnfv31BDPeT35ciiI16K5e6";
                imageView.setLayoutParams(layoutParams);
            }

            private void A05(int i2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.bottomMargin = AbstractC2758pv.A0e;
                if (i2 == 1) {
                    layoutParams.removeRule(11);
                    layoutParams.addRule(7, ((AbstractC2999to) this).A08.getId());
                    layoutParams.rightMargin = 0;
                } else {
                    layoutParams.removeRule(7);
                    layoutParams.addRule(11);
                    layoutParams.rightMargin = AbstractC2758pv.A0e;
                }
                layoutParams.addRule(12);
                this.A0W.setLayoutParams(layoutParams);
            }

            private void A06(int i2) {
                int horizontalMargin;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0Q.getLayoutParams();
                if (i2 == 1) {
                    horizontalMargin = AbstractC2758pv.A0s;
                    this.A0Q.setMaxLines(4);
                    this.A0Q.setTextSize(18.0f);
                } else {
                    horizontalMargin = AbstractC2758pv.A0y;
                    if (this.A0S.A2D()) {
                        this.A0Q.setMaxLines(1);
                        this.A0Q.setTextSize(15.0f);
                    } else {
                        this.A0Q.setMaxLines(2);
                        this.A0Q.setTextSize(18.0f);
                    }
                }
                layoutParams.setMargins(horizontalMargin, AbstractC2758pv.A0y, horizontalMargin, AbstractC2758pv.A0e);
                layoutParams.addRule(14);
                layoutParams.addRule(3, this.A0R.getId());
                layoutParams.addRule(14);
                this.A0Q.setTypeface(Typeface.DEFAULT);
                this.A0Q.setLayoutParams(layoutParams);
                if (this.A0S.A2S()) {
                    this.A0Q.setVisibility(8);
                }
            }

            private void A07(int i2) {
                int i3;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2999to) this).A09.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.width = A01;
                    layoutParams.height = A01;
                    layoutParams.setMargins(0, (-A01) / 4, 0, 0);
                    i3 = 30;
                } else {
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(14);
                    int i4 = this.A0S.A2D() ? AbstractC1266Es.A0i : AbstractC1266Es.A0n;
                    layoutParams.width = i4;
                    layoutParams.height = i4;
                    layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                    i3 = 15;
                }
                if (!this.A0b) {
                    ((AbstractC2999to) this).A09.setRadius(i3);
                }
                layoutParams.addRule(14);
                ((AbstractC2999to) this).A09.setLayoutParams(layoutParams);
            }

            private void A08(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0H.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.removeRule(3);
                    if (this.A0W.getVisibility() == 0) {
                        layoutParams.addRule(2, this.A0W.getId());
                    } else {
                        layoutParams.addRule(2, this.A0L.getId());
                    }
                    C2945sw c2945sw = ((AbstractC1266Es) this).A06;
                    String[] strArr = A00;
                    if (strArr[2].length() != strArr[3].length()) {
                        throw new RuntimeException();
                    }
                    A00[1] = "pkgCqU4xuuzJEPrjMmcRMnI5zMbCYgZH";
                    if ((c2945sw != null || ((AbstractC1266Es) this).A05 != null) && A11()) {
                        layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0o);
                    } else if (((AbstractC1266Es) this).A06 != null) {
                        layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0c);
                    } else {
                        layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0j);
                    }
                } else {
                    layoutParams.removeRule(2);
                    layoutParams.addRule(3, ((AbstractC2999to) this).A08.getId());
                    layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                }
                this.A0H.setLayoutParams(layoutParams);
            }

            private void A09(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0R.getLayoutParams();
                this.A0R.setTypeface(Typeface.DEFAULT_BOLD);
                if (this.A0S.A2D() && i2 == 2) {
                    this.A0R.setMaxLines(1);
                    this.A0R.setTextSize(24.0f);
                } else {
                    this.A0R.setMaxLines(2);
                    this.A0R.setTextSize(30.0f);
                }
                int i3 = 0;
                if (i2 == 1) {
                    i3 = AbstractC2758pv.A0n;
                }
                int horizontalMargin = AbstractC2758pv.A0e;
                layoutParams.setMargins(i3, horizontalMargin, i3, 0);
                layoutParams.addRule(14);
                int horizontalMargin2 = ((AbstractC2999to) this).A09.getId();
                layoutParams.addRule(3, horizontalMargin2);
                this.A0R.setLayoutParams(layoutParams);
            }

            private void A0A(View view, int i2) {
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    if (i2 == 1) {
                        if (((AbstractC1266Es) this).A04 != null && A11()) {
                            layoutParams.setMargins(0, AbstractC2758pv.A0c, 0, AbstractC2758pv.A0e);
                        } else {
                            int i3 = AbstractC2758pv.A0e;
                            String[] strArr = A00;
                            if (strArr[2].length() != strArr[3].length()) {
                                throw new RuntimeException();
                            }
                            A00[0] = "DMGzPe6klow89SRd0J6stTUI5Mbu60X5";
                            layoutParams.setMargins(0, 0, 0, i3);
                        }
                        layoutParams.addRule(5, ((AbstractC2999to) this).A08.getId());
                    } else {
                        layoutParams.addRule(9);
                        layoutParams.setMargins(AbstractC2758pv.A0c, 0, 0, AbstractC2758pv.A0e);
                    }
                    layoutParams.addRule(12);
                    view.setLayoutParams(layoutParams);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:26:0x009f, code lost:
            
                if (r6 == 0) goto L28;
             */
            /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
            
                r5.addRule(2, r7.A0W.getId());
             */
            /* JADX WARN: Code restructure failed: missing block: B:28:0x00b6, code lost:
            
                r5.addRule(2, r7.A0L.getId());
             */
            /* JADX WARN: Code restructure failed: missing block: B:30:0x00b3, code lost:
            
                if (r6 == 0) goto L28;
             */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            private void A0B(TextView textView, int i2) {
                if (textView == null || textView.getVisibility() != 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.removeRule(3);
                    if (((AbstractC1266Es) this).A06 != null) {
                        layoutParams.addRule(2, ((AbstractC1266Es) this).A06.getId());
                    } else {
                        C2941ss c2941ss = ((AbstractC1266Es) this).A05;
                        String[] strArr = A00;
                        if (strArr[2].length() != strArr[3].length()) {
                            throw new RuntimeException();
                        }
                        A00[5] = "7Aa81cuxTMzXgKpYQgIdybnp";
                        if (c2941ss != null) {
                            layoutParams.addRule(2, ((AbstractC1266Es) this).A05.getId());
                        } else {
                            int visibility = this.A0W.getVisibility();
                            String[] strArr2 = A00;
                            if (strArr2[7].charAt(10) != strArr2[6].charAt(10)) {
                                String[] strArr3 = A00;
                                strArr3[7] = "8GCUdxIZzh0VfuC0yo4L0asmTu6bbOt5";
                                strArr3[6] = "i7JBpSyDiqBcV3IKdLvNk0rN2itmYwZD";
                            } else {
                                A00[4] = "Kvb9AZhg4S8TJRZjQdKMuhwAs";
                            }
                        }
                    }
                    if (this.A0H.getVisibility() == 8) {
                        layoutParams.addRule(5, ((AbstractC2999to) this).A08.getId());
                    } else {
                        layoutParams.addRule(5, this.A0H.getId());
                    }
                } else {
                    layoutParams.removeRule(2);
                    layoutParams.removeRule(5);
                    layoutParams.addRule(3, this.A0H.getId());
                }
                layoutParams.setMargins(0, AbstractC2758pv.A0y, 0, 0);
                textView.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es, com.facebook.ads.redexgen.X.AbstractC2999to
            public final void A0l(int i2) {
                super.A0l(i2);
                AbstractC2801qc.A0e(this.A0O, ((AbstractC2999to) this).A09, this.A0R, this.A0H, ((AbstractC1266Es) this).A04, this.A0Q, this.A0L, this.A0W, ((AbstractC1266Es) this).A06, ((AbstractC1266Es) this).A05, this.A0K);
                A00();
                A07(i2);
                A0B(((AbstractC1266Es) this).A04, i2);
                A08(i2);
                A04(i2);
                A03(i2);
                A09(i2);
                A06(i2);
                A02(i2);
                A05(i2);
                A0A(((AbstractC1266Es) this).A06, i2);
                A0A(((AbstractC1266Es) this).A05, i2);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0u(int i2) {
                if (this.A0c) {
                    A0v(6000L);
                    this.A0a.set(true);
                }
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0y(ViewGroup viewGroup, RelativeLayout relativeLayout, int i2) {
                if (i2 == 1) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2999to) this).A09.getLayoutParams();
                    layoutParams.addRule(3, relativeLayout.getId());
                    ((AbstractC2999to) this).A09.setLayoutParams(layoutParams);
                    viewGroup.addView(((AbstractC2999to) this).A09);
                    viewGroup.addView(this.A0R);
                    viewGroup.addView(this.A0Q);
                }
                A01(i2);
                if (this.A0a.get()) {
                    A0v(600L);
                }
            }
        };
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.6p] */
    private C10726p A01() {
        final C1333Hi c1333Hi = this.A04;
        final ViewOnClickListenerC1259El viewOnClickListenerC1259El = this.A09;
        final int i = this.A01;
        final boolean z = this.A0D;
        final C2119fN c2119fN = this.A03;
        final String str = this.A0C;
        final InterfaceC2599nG interfaceC2599nG = this.A05;
        final InterfaceC2834r9 interfaceC2834r9 = this.A08;
        final C1914c2 c1914c2 = this.A0B;
        final C2792qT c2792qT = this.A07;
        final LA la = this.A02;
        final C1156Am c1156Am = this.A0A;
        final C2607nO c2607nO = this.A06;
        final boolean z2 = this.A0E;
        return new AbstractC1266Es(c1333Hi, viewOnClickListenerC1259El, i, z, c2119fN, str, interfaceC2599nG, interfaceC2834r9, c1914c2, c2792qT, la, c1156Am, c2607nO, z2) { // from class: com.facebook.ads.redexgen.X.6p
            public static String[] A01 = {"w2MruuTxQjeEuCnQM0ZHhHdcmTNB1USi", "6K6VNPn2YLW2ZrNc2sI3DavsPsosvAiV", "f186QDxce1fMV0BMlLkIEs0I4ATzIgHU", "tOqpuIkHfWAVhjumuWHKejLMN0x9qdDU", "9wqmpQD59qXO0Kv8VXPyLW2OuvLE6qrg", "kvssjmIOMrWVMwuQ1zprvpNUtXH75TG", "rhbBsv7k5W6F84eKmDZbkRDsGXunUcVd", "jx4ZTAhwuVpgMHQxB0XMyjmjRHDJ6LBz"};
            public final Runnable A00 = new RunnableC3006tv(this);

            {
                int i2 = getResources().getConfiguration().orientation;
                A08(i2);
                A0E(i2);
                A04();
                A09(i2);
                A0D(i2);
                A0F(i2);
                A0C(i2);
                A03();
                A02();
                A05();
                A0H(((AbstractC1266Es) this).A04);
                A0A(i2);
                A0B(i2);
                A0G(((AbstractC1266Es) this).A06, i2);
                A0G(((AbstractC1266Es) this).A05, i2);
                A06(i2);
                this.A0P.addView(this.A0N);
                addView(this.A0P);
            }

            private void A00() {
                AbstractC2801qc.A0e(((AbstractC2999to) this).A09, this.A0R, ((AbstractC2999to) this).A08, this.A0H, ((AbstractC1266Es) this).A04, this.A0Q, this.A0L, this.A0W, ((AbstractC1266Es) this).A06, ((AbstractC1266Es) this).A05, this.A0K, this.A0O);
            }

            private void A01() {
                A0w(this.A0N, -1291845632, new float[]{72.0f, 72.0f, 72.0f, 72.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            }

            private void A02() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, AbstractC1266Es.A0j);
                layoutParams.addRule(3, this.A0K.getId());
                if (this.A0K.getVisibility() == 0) {
                    layoutParams.setMargins(0, AbstractC2758pv.A0y, 0, 0);
                } else {
                    if (this.A0S.A2D()) {
                        layoutParams.height = AbstractC1266Es.A0h;
                    }
                    layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                }
                layoutParams.addRule(14);
                ((AbstractC2999to) this).A08.setLayoutParams(layoutParams);
                A0p();
            }

            private void A03() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0K.getLayoutParams();
                layoutParams.addRule(3, this.A0Q.getId());
                if (this.A0K.getVisibility() == 0) {
                    layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, 0, 0);
                }
                this.A0K.setLayoutParams(layoutParams);
            }

            private void A04() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                layoutParams.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.37f);
                layoutParams.addRule(13);
                this.A0O.setLayoutParams(layoutParams);
            }

            private void A05() {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0H.getLayoutParams();
                layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                layoutParams.addRule(3, ((AbstractC2999to) this).A08.getId());
                this.A0H.setLayoutParams(layoutParams);
            }

            private void A06(int i2) {
                A00();
                if (i2 == 1) {
                    this.A0N.addView(((AbstractC2999to) this).A09);
                    this.A0N.addView(this.A0R);
                    this.A0N.addView(this.A0Q);
                    this.A0N.addView(this.A0K);
                    this.A0N.addView(((AbstractC2999to) this).A08);
                    this.A0N.addView(this.A0H);
                    A10(this.A0N);
                    this.A0N.addView(this.A0L);
                    this.A0N.addView(this.A0W);
                    A0x(this.A0N, ((AbstractC1266Es) this).A06);
                    A0x(this.A0N, ((AbstractC1266Es) this).A05);
                    return;
                }
                this.A0O.addView(((AbstractC2999to) this).A09);
                this.A0O.addView(this.A0R);
                this.A0O.addView(this.A0Q);
                this.A0O.addView(((AbstractC2999to) this).A08);
                this.A0O.addView(this.A0H);
                A10(this.A0O);
                this.A0O.addView(this.A0K);
                this.A0P.addView(this.A0W);
                this.A0P.addView(this.A0O);
                this.A0P.addView(this.A0L);
                A0x(this.A0P, ((AbstractC1266Es) this).A06);
                A0x(this.A0P, ((AbstractC1266Es) this).A05);
            }

            private void A07(int i2) {
                if (i2 == 2) {
                    this.A0G.removeCallbacks(this.A00);
                    this.A0N.setLayoutTransition(null);
                }
            }

            private void A08(int i2) {
                if (i2 == 1) {
                    ((AbstractC1266Es) this).A07 = new C1149Af(this.A0N, 400, 100, 0);
                    this.A0Z.set(false);
                }
            }

            private void A09(int i2) {
                RelativeLayout.LayoutParams layoutParams;
                if (i2 == 1) {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -2);
                    this.A0N.setGravity(80);
                    layoutParams.setMargins(AbstractC2758pv.A0e, 0, AbstractC2758pv.A0e, 0);
                    this.A0N.setPadding(AbstractC2758pv.A0h, 0, AbstractC2758pv.A0h, 0);
                    A01();
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                    this.A0N.setGravity(1);
                    A0w(this.A0N, 0, null);
                }
                this.A0N.setLayoutParams(layoutParams);
            }

            private void A0A(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0L.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.removeRule(12);
                    layoutParams.removeRule(11);
                    layoutParams.setMargins(0, AbstractC2758pv.A0f, 0, 0);
                    layoutParams.addRule(11);
                    layoutParams.addRule(3, this.A0H.getId());
                } else {
                    layoutParams.setMargins(0, 0, AbstractC2758pv.A0n, 0);
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                }
                this.A0L.setLayoutParams(layoutParams);
                this.A0L.setPadding(AbstractC2758pv.A0y, AbstractC2758pv.A0y, 0, 0);
            }

            private void A0B(int i2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                if (i2 == 1) {
                    layoutParams.removeRule(12);
                    layoutParams.addRule(11);
                    C2945sw c2945sw = ((AbstractC1266Es) this).A06;
                    if (A01[5].length() == 31) {
                        A01[2] = "jk8MHOf2W2kKaKmDluR5lfBML8d6cl5O";
                        if ((c2945sw != null || ((AbstractC1266Es) this).A05 != null) && ((AbstractC1266Es) this).A04 != null && A11()) {
                            layoutParams.addRule(3, ((AbstractC1266Es) this).A04.getId());
                        } else {
                            layoutParams.addRule(3, this.A0H.getId());
                        }
                        if (((AbstractC1266Es) this).A06 != null) {
                            layoutParams.setMargins(0, AbstractC2758pv.A0c, 0, AbstractC2758pv.A0e);
                        } else {
                            int i3 = AbstractC2758pv.A0i;
                            if (A01[5].length() == 31) {
                                String[] strArr = A01;
                                strArr[0] = "n0buZTWHssWkfTtPz0PhhqMcNNJ2BST6";
                                strArr[7] = "2zJN7Pe1o4QWUWRiE0kHU2O0nWEbNaFy";
                                layoutParams.setMargins(0, i3, 0, AbstractC2758pv.A0e);
                            }
                        }
                    }
                    throw new RuntimeException();
                }
                layoutParams.removeRule(3);
                layoutParams.setMargins(0, 0, AbstractC2758pv.A0e, AbstractC2758pv.A0e);
                layoutParams.addRule(12);
                layoutParams.addRule(11);
                this.A0W.setLayoutParams(layoutParams);
            }

            private void A0C(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0Q.getLayoutParams();
                layoutParams.addRule(14);
                layoutParams.addRule(3, this.A0R.getId());
                layoutParams.setMargins(AbstractC2758pv.A0y, AbstractC2758pv.A0y, AbstractC2758pv.A0y, 0);
                this.A0Q.setLayoutParams(layoutParams);
                if (i2 == 1) {
                    this.A0Q.setTextSize(18.0f);
                    String[] strArr = A01;
                    if (strArr[6].charAt(9) != strArr[3].charAt(9)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[0] = "d0PHJldGB62beqnrX0Wv60vy32jQ1PcC";
                    strArr2[7] = "uLYOVKGqiFbiVjVd60cSpiIAL47dkY1D";
                    if (this.A0Z.get()) {
                        this.A0Q.setVisibility(8);
                        this.A0Q.setMaxLines(2);
                    }
                } else {
                    if (this.A0S.A2D()) {
                        this.A0Q.setMaxLines(1);
                        this.A0Q.setTextSize(15.0f);
                    } else {
                        this.A0Q.setMaxLines(2);
                        String[] strArr3 = A01;
                        if (strArr3[6].charAt(9) != strArr3[3].charAt(9)) {
                            this.A0Q.setTextSize(18.0f);
                        } else {
                            String[] strArr4 = A01;
                            strArr4[1] = "fRgpX5yp5qwUnrrjlw1Imbl87YnpN2OV";
                            strArr4[4] = "hy5kROOsylyvZnxx8Hqlg4ojsqhpujt5";
                            this.A0Q.setTextSize(18.0f);
                        }
                    }
                    this.A0Q.setVisibility(0);
                }
                if (this.A0S.A2S()) {
                    this.A0Q.setVisibility(8);
                }
            }

            private void A0D(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2999to) this).A09.getLayoutParams();
                if (i2 == 1) {
                    if (this.A0Z.get()) {
                        C3036uP c3036uP = ((AbstractC2999to) this).A09;
                        String[] strArr = A01;
                        if (strArr[0].charAt(17) != strArr[7].charAt(17)) {
                            throw new RuntimeException();
                        }
                        String[] strArr2 = A01;
                        strArr2[0] = "H7xUkLmt3v9kJhFuI0vt843KTUofFKpo";
                        strArr2[7] = "CxVOrho7d03SIjWr50TQyFVtO9TWO2zD";
                        c3036uP.setVisibility(8);
                    }
                    layoutParams.width = AbstractC1266Es.A0m;
                    layoutParams.height = AbstractC1266Es.A0m;
                    layoutParams.setMargins(0, (-AbstractC1266Es.A0m) / 2, 0, 0);
                } else {
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(14);
                    int i3 = this.A0S.A2D() ? AbstractC1266Es.A0i : AbstractC1266Es.A0n;
                    layoutParams.width = i3;
                    layoutParams.height = i3;
                    layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                    ((AbstractC2999to) this).A09.setVisibility(0);
                }
                layoutParams.addRule(14);
                ((AbstractC2999to) this).A09.setLayoutParams(layoutParams);
            }

            private void A0E(int i2) {
                if (i2 == 1) {
                    this.A0P.setClipChildren(false);
                    if (A01[5].length() != 31) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A01;
                    strArr[0] = "Bym7KFlyw5tUAh72V0qwieKJYoRzJx2E";
                    strArr[7] = "gAaO1eJVAsX9f211J0tzuuuMf0m8aX5o";
                    this.A0P.setClipToPadding(false);
                    this.A0P.setGravity(80);
                    return;
                }
                this.A0P.setGravity(8388659);
            }

            private void A0F(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0R.getLayoutParams();
                layoutParams.addRule(14);
                layoutParams.addRule(3, ((AbstractC2999to) this).A09.getId());
                layoutParams.setMargins(0, AbstractC2758pv.A0f, 0, 0);
                this.A0R.setTypeface(Typeface.DEFAULT_BOLD);
                if (this.A0S.A2D() && i2 == 2) {
                    this.A0R.setMaxLines(1);
                    this.A0R.setTextSize(24.0f);
                } else {
                    this.A0R.setMaxLines(2);
                    this.A0R.setTextSize(30.0f);
                }
                this.A0R.setLayoutParams(layoutParams);
                if (i2 == 1) {
                    if (this.A0Z.get()) {
                        this.A0R.setVisibility(8);
                        return;
                    }
                    return;
                }
                this.A0R.setVisibility(0);
            }

            private void A0G(View view, int i2) {
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    if (i2 == 1) {
                        if (((AbstractC1266Es) this).A04 != null && A11()) {
                            int id = ((AbstractC1266Es) this).A04.getId();
                            if (A01[5].length() != 31) {
                                throw new RuntimeException();
                            }
                            String[] strArr = A01;
                            strArr[1] = "dVRPb1xd0TpHjh6ta2zoGKUsQLj9LhVW";
                            strArr[4] = "OXH0gDyhR94T8SBEBxqIRV07J3RZB9NN";
                            layoutParams.addRule(3, id);
                        } else {
                            layoutParams.addRule(3, this.A0H.getId());
                        }
                        layoutParams.setMargins(0, AbstractC2758pv.A0c, 0, AbstractC2758pv.A0e);
                    } else {
                        layoutParams.addRule(12);
                        layoutParams.setMargins(AbstractC2758pv.A0e, 0, 0, AbstractC2758pv.A0e);
                    }
                    layoutParams.addRule(9);
                    view.setLayoutParams(layoutParams);
                }
            }

            private void A0H(TextView textView) {
                if (textView == null || textView.getVisibility() != 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                layoutParams.addRule(3, this.A0H.getId());
                layoutParams.setMargins(0, AbstractC2758pv.A0y, 0, 0);
                textView.setLayoutParams(layoutParams);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es, com.facebook.ads.redexgen.X.AbstractC2999to
            public final void A0l(int i2) {
                super.A0l(i2);
                A07(i2);
                A00();
                A0E(i2);
                A09(i2);
                A04();
                A0D(i2);
                A0H(((AbstractC1266Es) this).A04);
                A05();
                A03();
                A02();
                A0F(i2);
                A0C(i2);
                A0A(i2);
                A0B(i2);
                A0G(((AbstractC1266Es) this).A06, i2);
                A0G(((AbstractC1266Es) this).A05, i2);
                A06(i2);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0u(int i2) {
                if (this.A0c && !this.A0a.get()) {
                    A0v(6000L);
                    this.A0a.set(true);
                }
                if (((AbstractC1266Es) this).A07 == null || i2 == 2) {
                    return;
                }
                C1149Af c1149Af = ((AbstractC1266Es) this).A07;
                String[] strArr = A01;
                if (strArr[0].charAt(17) != strArr[7].charAt(17)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A01;
                strArr2[6] = "CE040Fr2pWMVnhrWCMpdDFM51OXa8IOQ";
                strArr2[3] = "VF4YYGdiYWPWjPyvbRvbDjFFThiDmlKg";
                c1149Af.A4b(true, false);
                this.A0Z.set(true);
                this.A0G.postDelayed(this.A00, 5000L);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0w(View view, int i2, float[] fArr) {
                if (!this.A0S.A2f()) {
                    super.A0w(view, i2, fArr);
                } else {
                    view.setBackgroundColor(0);
                }
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0y(ViewGroup viewGroup, RelativeLayout relativeLayout, int i2) {
                if (this.A0a.get()) {
                    A0v(600L);
                }
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC2999to
            public void setInfo(C2117fL c2117fL, C2121fP c2121fP, String str2, String str3, InterfaceC2771q8 interfaceC2771q8, InterfaceC3018u7 interfaceC3018u7) {
                super.setInfo(c2117fL, c2121fP, str2, str3, interfaceC2771q8, interfaceC3018u7);
            }
        };
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [com.facebook.ads.redexgen.X.6o] */
    private C10716o A02() {
        final C1333Hi c1333Hi = this.A04;
        final ViewOnClickListenerC1259El viewOnClickListenerC1259El = this.A09;
        final int i = this.A01;
        final boolean z = this.A0D;
        final C2119fN c2119fN = this.A03;
        final String str = this.A0C;
        final InterfaceC2599nG interfaceC2599nG = this.A05;
        final InterfaceC2834r9 interfaceC2834r9 = this.A08;
        final C1914c2 c1914c2 = this.A0B;
        final C2792qT c2792qT = this.A07;
        final LA la = this.A02;
        final C1156Am c1156Am = this.A0A;
        final C2607nO c2607nO = this.A06;
        final boolean z2 = this.A0E;
        return new AbstractC1266Es(c1333Hi, viewOnClickListenerC1259El, i, z, c2119fN, str, interfaceC2599nG, interfaceC2834r9, c1914c2, c2792qT, la, c1156Am, c2607nO, z2) { // from class: com.facebook.ads.redexgen.X.6o
            public static String[] A00 = {"ZdP7RIDHTegYTA857OuOKarMoq6oyDOK", "0xVcxoX3x7G1vFRJQBVlBDtJrXKnSXIJ", "pZ1raRvYE9l4AysfKmY4I9P1cn1xKPPp", "xw9xrzpmOq7j0b1iIQWYbXLPL8WW3uCu", "q4IkRRjoazS96QEMndmkn0VgDKaKJRYz", "h0JEzdCJ1C77dZroCgBDRcRoPrLrQvhJ", "", "NvWq0RY"};
            public static final int A02 = (int) (AbstractC2760px.A02 * 152.0f);
            public static final int A01 = (int) (AbstractC2760px.A02 * 60.0f);

            {
                int i2 = getResources().getConfiguration().orientation;
                A03(i2);
                A04(i2);
                A0A(i2);
                A01();
                A07(i2);
                A06(i2);
                A0D(i2);
                A08(i2);
                A0E(((AbstractC1266Es) this).A06, i2);
                A0E(((AbstractC1266Es) this).A05, i2);
                A0C(i2);
                AbstractC2801qc.A0L(this.A0Q);
                if (i2 == 1) {
                    A09(i2);
                }
                A0B(i2);
                A02(i2);
                A05(i2);
                this.A0P.addView(this.A0N);
                addView(this.A0P);
            }

            private void A00() {
                AbstractC2801qc.A0e(((AbstractC2999to) this).A09, this.A0R, ((AbstractC2999to) this).A08, this.A0H, ((AbstractC1266Es) this).A04, this.A0Q, this.A0K, this.A0L, this.A0W, ((AbstractC1266Es) this).A06, ((AbstractC1266Es) this).A05, this.A0M, this.A0O);
            }

            private void A01() {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.addRule(15);
                layoutParams.addRule(11);
                this.A0M.setLayoutParams(layoutParams);
                this.A0M.setGravity(1);
                this.A0M.setOrientation(1);
            }

            private void A02(int i2) {
                A00();
                if (i2 == 1) {
                    TextView textView = ((AbstractC1266Es) this).A04;
                    String[] strArr = A00;
                    if (strArr[0].charAt(11) != strArr[4].charAt(11)) {
                        String[] strArr2 = A00;
                        strArr2[2] = "GNslrYpomqFk7gxssF2TvId3Ky512eO1";
                        strArr2[1] = "IP8fEd7eeIxo3bLBWJPUIOE3OYAw5FyL";
                        if (textView != null && ((AbstractC1266Es) this).A04.getVisibility() == 0) {
                            this.A0P.addView(((AbstractC1266Es) this).A04);
                        }
                        this.A0P.addView(this.A0H);
                        this.A0P.addView(this.A0W);
                        this.A0P.addView(((AbstractC2999to) this).A08);
                        this.A0P.addView(this.A0K);
                        A0x(this.A0P, ((AbstractC1266Es) this).A06);
                        A0x(this.A0P, ((AbstractC1266Es) this).A05);
                        this.A0P.addView(this.A0L);
                    }
                    throw new RuntimeException();
                }
                this.A0M.addView(this.A0K);
                this.A0M.addView(((AbstractC2999to) this).A08);
                this.A0O.addView(this.A0M);
                this.A0O.addView(((AbstractC2999to) this).A09);
                this.A0O.addView(this.A0R);
                this.A0N.addView(this.A0W);
                this.A0N.addView(this.A0O);
                this.A0N.addView(this.A0H);
                if (((AbstractC1266Es) this).A04 != null && ((AbstractC1266Es) this).A04.getVisibility() == 0) {
                    RelativeLayout relativeLayout = this.A0N;
                    if (A00[6].length() == 0) {
                        String[] strArr3 = A00;
                        strArr3[5] = "prpJbaOS3C74qQUCc19ITfwjID7M3amC";
                        strArr3[3] = "ZP4Exlhucz76QZqKl6CmwcUS7C1VN0wP";
                        relativeLayout.addView(((AbstractC1266Es) this).A04);
                    }
                    throw new RuntimeException();
                }
                A0x(this.A0N, ((AbstractC1266Es) this).A05);
                A0x(this.A0N, ((AbstractC1266Es) this).A06);
                this.A0P.addView(this.A0L);
            }

            private void A03(int i2) {
                if (i2 == 2) {
                    ((AbstractC1266Es) this).A07 = new C1149Af(this.A0N, 400, 100, 0);
                    this.A0Z.set(false);
                }
            }

            private void A04(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0N.getLayoutParams();
                layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0e);
                if (i2 == 1) {
                    this.A0N.setVisibility(8);
                } else {
                    layoutParams.width = (int) (getResources().getDisplayMetrics().widthPixels * 0.4f);
                    layoutParams.height = -2;
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    this.A0N.setPadding(AbstractC2758pv.A0e, AbstractC2758pv.A0e, AbstractC2758pv.A0e, AbstractC2758pv.A0e);
                    A0w(this.A0N, -1728053248, new float[]{32.0f, 32.0f, 0.0f, 0.0f, 0.0f, 0.0f, 32.0f, 32.0f});
                    this.A0N.setVisibility(0);
                }
                this.A0N.setLayoutParams(layoutParams);
            }

            private void A05(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0L.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.removeRule(20);
                    layoutParams.addRule(21);
                    layoutParams.setMargins(0, 0, AbstractC2758pv.A0n, 0);
                    this.A0L.setPadding(AbstractC2758pv.A0y, AbstractC2758pv.A0y, 0, 0);
                } else {
                    layoutParams.removeRule(21);
                    layoutParams.addRule(20);
                    layoutParams.setMargins(AbstractC2758pv.A0n, 0, 0, 0);
                }
                layoutParams.addRule(12);
                this.A0L.setPadding(0, AbstractC2758pv.A0y, AbstractC2758pv.A0y, 0);
                this.A0L.setLayoutParams(layoutParams);
            }

            private void A06(int i2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, AbstractC1266Es.A0j);
                if (i2 == 1) {
                    layoutParams.removeRule(15);
                    ((AbstractC1266Es) this).A02 = 30;
                    layoutParams.addRule(14);
                    layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0e);
                    if (this.A0H.getVisibility() == 8 && A11()) {
                        TextView textView = ((AbstractC1266Es) this).A04;
                        String[] strArr = A00;
                        if (strArr[2].charAt(13) == strArr[1].charAt(13)) {
                            throw new RuntimeException();
                        }
                        A00[7] = "UWLIWpc";
                        if (textView != null) {
                            TextView textView2 = ((AbstractC1266Es) this).A04;
                            String[] strArr2 = A00;
                            if (strArr2[0].charAt(11) == strArr2[4].charAt(11)) {
                                throw new RuntimeException();
                            }
                            A00[6] = "";
                            layoutParams.addRule(2, textView2.getId());
                            ((AbstractC2999to) this).A08.setMinWidth(-1);
                        }
                    }
                    layoutParams.addRule(2, this.A0H.getId());
                    ((AbstractC2999to) this).A08.setMinWidth(-1);
                } else {
                    layoutParams.removeRule(2);
                    ((AbstractC1266Es) this).A02 = 16;
                    layoutParams.width = -2;
                    layoutParams.height = AbstractC1266Es.A0o;
                    if (this.A0K.getVisibility() != 0) {
                        layoutParams.addRule(15);
                    }
                    layoutParams.setMargins(0, 0, 0, 0);
                    ((AbstractC2999to) this).A08.setMinWidth((int) (getResources().getDisplayMetrics().widthPixels * 0.12f));
                }
                layoutParams.addRule(14);
                ((AbstractC2999to) this).A08.setLayoutParams(layoutParams);
                ((AbstractC2999to) this).A08.setPadding(AbstractC2758pv.A0r, 0, AbstractC2758pv.A0r, 0);
                A0p();
            }

            private void A07(int i2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(AbstractC1266Es.A0k, AbstractC1266Es.A0k);
                if (i2 == 1) {
                    layoutParams.addRule(2, ((AbstractC2999to) this).A08.getId());
                    layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0y);
                    layoutParams.addRule(14);
                } else {
                    layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0r);
                    layoutParams.removeRule(14);
                    layoutParams.removeRule(2);
                }
                this.A0K.setLayoutParams(layoutParams);
            }

            private void A08(int i2) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                layoutParams.removeRule(12);
                layoutParams.removeRule(3);
                if (i2 != 1) {
                    layoutParams.addRule(3, this.A0H.getId());
                    layoutParams.addRule(11);
                    if ((((AbstractC1266Es) this).A06 != null || ((AbstractC1266Es) this).A05 != null) && A11()) {
                        layoutParams.setMargins(0, AbstractC2758pv.A0n, 0, 0);
                    } else {
                        int i3 = AbstractC2758pv.A0e;
                        String[] strArr = A00;
                        if (strArr[5].charAt(10) != strArr[3].charAt(10)) {
                            throw new RuntimeException();
                        }
                        A00[6] = "";
                        layoutParams.setMargins(0, i3, 0, 0);
                    }
                } else {
                    layoutParams.addRule(12);
                    View view = this.A0H;
                    if (A00[6].length() == 0) {
                        String[] strArr2 = A00;
                        strArr2[0] = "UegSUzPY6a1YmmucmP9PzI1bolm6NSQT";
                        strArr2[4] = "86d6c4M8QWcX1rRFyPEzQxT8ry0QZowZ";
                        if (view.getVisibility() == 0) {
                            View view2 = this.A0H;
                            String[] strArr3 = A00;
                            if (strArr3[5].charAt(10) == strArr3[3].charAt(10)) {
                                String[] strArr4 = A00;
                                strArr4[2] = "qTs1DrVvJqPlKWy3MDjzGcuBjxhBpOME";
                                strArr4[1] = "MosGDa6N3ncbsfOWyb0hWwCGrF3I8eCi";
                                layoutParams.addRule(7, view2.getId());
                                layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0e);
                            }
                        } else {
                            int id = ((AbstractC2999to) this).A08.getId();
                            if (A00[7].length() == 7) {
                                String[] strArr5 = A00;
                                strArr5[2] = "WRhsd4EseqxBuQ7TeHaQMNEcxMTLnWNo";
                                strArr5[1] = "wkf3IfIwpDRXmhLKXSaZfOFauDwKjO5k";
                                layoutParams.addRule(7, id);
                                layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0e);
                            }
                        }
                    }
                    throw new RuntimeException();
                }
                this.A0W.setLayoutParams(layoutParams);
            }

            private void A09(int i2) {
                if (i2 == 1) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0Q.getLayoutParams();
                    layoutParams.addRule(14);
                    layoutParams.addRule(3, this.A0R.getId());
                    layoutParams.setMargins(AbstractC2758pv.A0s, 0, AbstractC2758pv.A0s, AbstractC2758pv.A0y);
                    this.A0Q.setTypeface(Typeface.DEFAULT);
                    this.A0Q.setTextSize(18.0f);
                    this.A0Q.setLayoutParams(layoutParams);
                    this.A0Q.setMaxLines(2);
                }
                if (this.A0S.A2S()) {
                    this.A0Q.setVisibility(8);
                }
            }

            private void A0A(int i2) {
                int topMargin;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2999to) this).A09.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.width = A02;
                    layoutParams.height = A02;
                    layoutParams.setMargins(0, (-A02) / 4, 0, 0);
                    layoutParams.addRule(14);
                    topMargin = 30;
                } else {
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(14);
                    layoutParams.width = A01;
                    layoutParams.height = A01;
                    layoutParams.setMargins(0, 0, AbstractC2758pv.A0y, 0);
                    topMargin = 12;
                }
                if (!this.A0b) {
                    ((AbstractC2999to) this).A09.setRadius(topMargin);
                }
                ((AbstractC2999to) this).A09.setLayoutParams(layoutParams);
            }

            private void A0B(int i2) {
                if (((AbstractC1266Es) this).A04 == null || ((AbstractC1266Es) this).A04.getVisibility() != 0) {
                    return;
                }
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC1266Es) this).A04.getLayoutParams();
                layoutParams.removeRule(5);
                layoutParams.removeRule(3);
                layoutParams.removeRule(2);
                if (i2 != 1) {
                    layoutParams.addRule(3, this.A0H.getId());
                    layoutParams.setMargins(0, AbstractC2758pv.A0r, 0, 0);
                } else {
                    C2945sw c2945sw = ((AbstractC1266Es) this).A06;
                    String[] strArr = A00;
                    if (strArr[2].charAt(13) == strArr[1].charAt(13)) {
                        throw new RuntimeException();
                    }
                    A00[6] = "";
                    if (c2945sw != null) {
                        layoutParams.addRule(2, ((AbstractC1266Es) this).A06.getId());
                        layoutParams.setMargins(0, AbstractC2758pv.A0y, 0, AbstractC2758pv.A0c);
                    } else if (((AbstractC1266Es) this).A05 != null) {
                        layoutParams.addRule(2, ((AbstractC1266Es) this).A05.getId());
                        layoutParams.setMargins(0, AbstractC2758pv.A0y, 0, AbstractC2758pv.A0e);
                    } else {
                        C2941ss c2941ss = this.A0W;
                        String[] strArr2 = A00;
                        if (strArr2[5].charAt(10) != strArr2[3].charAt(10)) {
                            throw new RuntimeException();
                        }
                        String[] strArr3 = A00;
                        strArr3[5] = "H0DnQ7pAPS7TgO2RbhOBIqObWeAvJWnH";
                        strArr3[3] = "JEmLHXESxR7HHh8U12jIDFIXN4KHMJoP";
                        if (c2941ss.getVisibility() == 0) {
                            layoutParams.addRule(2, this.A0W.getId());
                        } else {
                            LinearLayout linearLayout = this.A0L;
                            String[] strArr4 = A00;
                            if (strArr4[5].charAt(10) != strArr4[3].charAt(10)) {
                                layoutParams.addRule(2, linearLayout.getId());
                            } else {
                                A00[7] = "O4EXCGz";
                                layoutParams.addRule(2, linearLayout.getId());
                            }
                        }
                        layoutParams.setMargins(0, AbstractC2758pv.A0y, 0, 0);
                    }
                    if (this.A0H.getVisibility() != 8) {
                        layoutParams.addRule(5, this.A0H.getId());
                    } else {
                        layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0c);
                        layoutParams.addRule(5, ((AbstractC2999to) this).A08.getId());
                    }
                }
                ((AbstractC1266Es) this).A04.setLayoutParams(layoutParams);
            }

            private void A0C(int i2) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0H.getLayoutParams();
                layoutParams.removeRule(2);
                layoutParams.removeRule(3);
                if (i2 == 1) {
                    if (this.A0W.getVisibility() == 0) {
                        layoutParams.addRule(2, this.A0W.getId());
                    } else {
                        layoutParams.addRule(2, this.A0L.getId());
                    }
                    if ((((AbstractC1266Es) this).A06 != null || ((AbstractC1266Es) this).A05 != null) && A11()) {
                        layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0n);
                    } else {
                        C2945sw c2945sw = ((AbstractC1266Es) this).A06;
                        if (A00[6].length() == 0) {
                            A00[6] = "";
                            if (c2945sw != null) {
                                layoutParams.setMargins(AbstractC2758pv.A0n, 0, AbstractC2758pv.A0n, AbstractC2758pv.A0c);
                            } else {
                                int i3 = AbstractC2758pv.A0n;
                                int i4 = AbstractC2758pv.A0n;
                                int i5 = AbstractC2758pv.A0i;
                                String[] strArr = A00;
                                if (strArr[5].charAt(10) == strArr[3].charAt(10)) {
                                    String[] strArr2 = A00;
                                    strArr2[5] = "i7c2OsDlkF7LIW0z0jxIiqDNdPleI1om";
                                    strArr2[3] = "4k8rjLr3Y773faVf0yk9Wt1pSF1ArNUc";
                                    layoutParams.setMargins(i3, 0, i4, i5);
                                }
                            }
                        }
                        throw new RuntimeException();
                    }
                } else {
                    int i6 = AbstractC2758pv.A0y;
                    if (A00[6].length() != 0) {
                        String[] strArr3 = A00;
                        strArr3[0] = "tK9KsoPKhA1YAhpxXMTlVPSVjfTZ7gGI";
                        strArr3[4] = "I0JLMnKHkym5jm8gEfUkZxH0uOmVd6mz";
                        layoutParams.setMargins(0, i6, 0, 0);
                        layoutParams.addRule(3, this.A0O.getId());
                    } else {
                        String[] strArr4 = A00;
                        strArr4[2] = "IvF4qACPUyBizMVeesqXNdUTQFca7LR3";
                        strArr4[1] = "TZkhdK2YqVdrkPOGD2sdbbEPxDmCKiCX";
                        layoutParams.setMargins(0, i6, 0, 0);
                        layoutParams.addRule(3, this.A0O.getId());
                    }
                }
                this.A0H.setLayoutParams(layoutParams);
            }

            private void A0D(int i2) {
                int i3;
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.A0R.getLayoutParams();
                if (i2 == 1) {
                    layoutParams.removeRule(1);
                    layoutParams.removeRule(15);
                    layoutParams.removeRule(0);
                    i3 = 4;
                    layoutParams.addRule(14);
                    layoutParams.addRule(3, ((AbstractC2999to) this).A09.getId());
                    int i4 = AbstractC2758pv.A0n;
                    int i5 = AbstractC2758pv.A0e;
                    int textAlignment = AbstractC2758pv.A0n;
                    layoutParams.setMargins(i4, i5, textAlignment, AbstractC2758pv.A0y);
                    this.A0R.setTypeface(Typeface.DEFAULT_BOLD);
                    this.A0R.setTextSize(30.0f);
                    this.A0R.setMaxLines(2);
                } else {
                    layoutParams.removeRule(3);
                    layoutParams.removeRule(14);
                    i3 = 5;
                    layoutParams.addRule(15);
                    layoutParams.addRule(1, ((AbstractC2999to) this).A09.getId());
                    layoutParams.addRule(0, this.A0M.getId());
                    layoutParams.setMargins(0, 0, AbstractC2758pv.A0y, 0);
                    this.A0R.setTypeface(Typeface.DEFAULT);
                    this.A0R.setTextSize(20.0f);
                    this.A0R.setMaxLines(1);
                }
                this.A0R.setTextAlignment(i3);
                this.A0R.setLayoutParams(layoutParams);
                this.A0R.setEllipsize(TextUtils.TruncateAt.END);
            }

            private void A0E(View view, int i2) {
                if (view != null) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                    if (i2 == 1) {
                        if (this.A0H.getVisibility() == 0) {
                            layoutParams.addRule(5, this.A0H.getId());
                        } else {
                            layoutParams.addRule(5, ((AbstractC2999to) this).A08.getId());
                        }
                        layoutParams.addRule(12);
                        layoutParams.setMargins(0, 0, 0, AbstractC2758pv.A0e);
                    } else {
                        layoutParams.addRule(3, this.A0H.getId());
                        layoutParams.addRule(9);
                        if (A11()) {
                            layoutParams.setMargins(0, AbstractC2758pv.A0n, 0, 0);
                        } else {
                            layoutParams.setMargins(0, AbstractC2758pv.A0e, 0, 0);
                        }
                    }
                    view.setLayoutParams(layoutParams);
                }
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es, com.facebook.ads.redexgen.X.AbstractC2999to
            public final void A0l(int i2) {
                super.A0l(i2);
                A00();
                A04(i2);
                A05(i2);
                A08(i2);
                A0B(i2);
                A0C(i2);
                A01();
                A07(i2);
                A06(i2);
                A0A(i2);
                A0D(i2);
                A09(i2);
                A0E(((AbstractC1266Es) this).A06, i2);
                A0E(((AbstractC1266Es) this).A05, i2);
                A02(i2);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0u(int i2) {
                if (this.A0c) {
                    A0v(6000L);
                    this.A0a.set(true);
                }
                if (((AbstractC1266Es) this).A07 != null) {
                    if (A00[7].length() != 7) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A00;
                    strArr[5] = "3nXTMTqUis7q97yNmf6c9EsvEyWwtH3N";
                    strArr[3] = "5mL0iog8M87OGH3k6R5fTmC7aBi7Lokn";
                    if (i2 == 2) {
                        ((AbstractC1266Es) this).A07.A4b(true, false);
                    }
                }
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC1266Es
            public final void A0y(ViewGroup viewGroup, RelativeLayout relativeLayout, int i2) {
                if (i2 == 1) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) ((AbstractC2999to) this).A09.getLayoutParams();
                    int id = relativeLayout.getId();
                    if (A00[6].length() != 0) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A00;
                    strArr[2] = "wdriGZo2hgqYKYZIDop91peOPSYUIru9";
                    strArr[1] = "JHtXCRTweEvPjls9z2bLTvJm8mG7CTMr";
                    layoutParams.addRule(3, id);
                    ((AbstractC2999to) this).A09.setLayoutParams(layoutParams);
                    viewGroup.addView(((AbstractC2999to) this).A09);
                    viewGroup.addView(this.A0R);
                    viewGroup.addView(this.A0Q);
                }
                AtomicBoolean atomicBoolean = this.A0a;
                if (A00[7].length() != 7) {
                    throw new RuntimeException();
                }
                A00[7] = "lXrHYVj";
                if (atomicBoolean.get()) {
                    A0v(600L);
                }
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC2999to
            public void setInfo(C2117fL c2117fL, C2121fP c2121fP, String str2, String str3, InterfaceC2771q8 interfaceC2771q8, InterfaceC3018u7 interfaceC3018u7) {
                super.setInfo(c2117fL, c2121fP, str2, str3, interfaceC2771q8, interfaceC3018u7);
            }

            @Override // com.facebook.ads.redexgen.X.AbstractC2999to
            public void setTitleMaxLines(int i2) {
                this.A0R.setMaxLines(i2);
                this.A0R.setEllipsize(TextUtils.TruncateAt.END);
            }
        };
    }

    public final AbstractC1266Es A03() {
        if (AbstractC2736pZ.A03(this.A00)) {
            return A01();
        }
        if (AbstractC2736pZ.A05(this.A00)) {
            return A02();
        }
        C10736q A00 = A00();
        String[] strArr = A0F;
        if (strArr[0].length() == strArr[2].length()) {
            throw new RuntimeException();
        }
        A0F[3] = "jzMDxjSUEsvxnEl";
        return A00;
    }
}
