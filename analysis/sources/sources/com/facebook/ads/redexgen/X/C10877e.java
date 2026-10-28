package com.facebook.ads.redexgen.X;

import com.facebook.ads.CacheFlag;
import java.util.EnumSet;

/* renamed from: com.facebook.ads.redexgen.X.7e, reason: invalid class name and case insensitive filesystem */
/* loaded from: assets/audience_network/classes.dex */
public final class C10877e extends KI {
    public static String[] A00 = {"Ze8NKKgwBfy46YDq5I0lzRS5nG7yrU8J", "E1ojaS3uTXsRavQORrTdUhX9c7MV5aHd", "ItCt9Q9mXWs9PIywah58uBD5YWxogfVc", "TvzxiXVOv8ol3X69Q34742hsr7pKLonV", "WogP6aaFjSX27EG5W88ejxN6ir7ZffIG", "o9NxBVrFd1YzPTzVCo2rgQ7Rf3HS8hqa", "2XopQN6Gw1", "j82AvX7B8A16DzVk8Gq1uvpNrrFgPLHx"};

    public C10877e(C1333Hi c1333Hi, C2156fy c2156fy) {
        super(c1333Hi, c2156fy);
    }

    private KG A00(Runnable runnable) {
        return new KG(this, runnable);
    }

    @Override // com.facebook.ads.redexgen.X.KI
    public final AbstractC2109fD A0H() {
        C1440Lq successfullyLoadedAdapter = (C1440Lq) this.A01;
        if (successfullyLoadedAdapter != null) {
            return successfullyLoadedAdapter.A09();
        }
        return null;
    }

    @Override // com.facebook.ads.redexgen.X.KI
    public final void A0O() {
        C1440Lq interstitialAdapter = (C1440Lq) this.A01;
        if (interstitialAdapter != null) {
            interstitialAdapter.A0B();
        }
    }

    @Override // com.facebook.ads.redexgen.X.KI
    public final void A0Q(InterfaceC2083en interfaceC2083en, C2520ly c2520ly, C2518lw c2518lw, C2157fz c2157fz) {
        C1440Lq c1440Lq = (C1440Lq) interfaceC2083en;
        KH kh = new KH(this, c2157fz, c1440Lq);
        A0G().postDelayed(kh, c2520ly.A05().A05());
        EnumSet<CacheFlag> enumSet = this.A08.A0B;
        if (enumSet == null) {
            enumSet = CacheFlag.ALL;
            if (A00[7].charAt(1) == 'D') {
                throw new RuntimeException();
            }
            A00[5] = "sZ24rCHUkfT3uSPodHZqWzeJet0EqBqU";
        }
        c1440Lq.A0A(this.A0B, A00(kh), c2157fz, enumSet, this.A08.A04, this.A08.A05, this.A08.A02);
    }
}
