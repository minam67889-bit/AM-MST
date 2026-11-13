package defpackage;

import ads_mobile_sdk.dd0;
import ads_mobile_sdk.dr2;
import ads_mobile_sdk.fb0;
import ads_mobile_sdk.gt0;
import ads_mobile_sdk.ni1;
import ads_mobile_sdk.pg;
import ads_mobile_sdk.pk2;
import ads_mobile_sdk.uc1;
import ads_mobile_sdk.ug;
import android.app.Activity;
import android.os.Bundle;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNApplication;

/* renamed from: eX, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C2963eX {
    public boolean a;
    public boolean b;
    public Object c;
    public Object d;

    public void a() {
        if (this.a || ((InterfaceC3570m6) this.c) != null) {
            return;
        }
        this.a = true;
        String string = Deobfuscator$BDNETVPN$app.getString(-17183496042379L);
        AbstractC3634my.g(string, "adUnitId");
        S1 s1 = new S1(string, new LinkedHashSet(), null, new LinkedHashMap(), new Bundle(), new HashSet(), new HashSet(), new LinkedHashMap(), null);
        QO qo = new QO(this);
        ug.d.getClass();
        if (gt0.b) {
            throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
        }
        ni1 ni1Var = gt0.a;
        uc1 uc1Var = (uc1) ((fb0) ni1Var.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).T2.get();
        if (gt0.b) {
            throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
        }
        fb0 fb0Var = ((fb0) ni1Var.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).c;
        dr2 dr2Var = dr2.e;
        Boolean bool = Boolean.FALSE;
        uc1Var.a((InterfaceC0522Tt) new pg((pk2) new dd0(fb0Var, s1, s1, dr2Var, bool, bool).i.get(), qo, null));
    }

    public void b(Activity activity, K00 k00) {
        if (this.b) {
            return;
        }
        InterfaceC3570m6 interfaceC3570m6 = (InterfaceC3570m6) this.c;
        boolean z = interfaceC3570m6 != null;
        VPNApplication vPNApplication = (VPNApplication) this.d;
        if (z) {
            interfaceC3570m6.setAdEventCallback(new J00(this, k00));
            C0223If c0223If = vPNApplication.d;
            c0223If.getClass();
            if (c0223If.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-163100714956683L), true)) {
                return;
            }
            this.b = true;
            ((InterfaceC3570m6) this.c).show(activity);
            return;
        }
        k00.b();
        long j = vPNApplication.c.getLong(Deobfuscator$BDNETVPN$app.getString(-17350999766923L), 0L);
        if (j == 0) {
            a();
        } else {
            if (j == 0 || System.currentTimeMillis() < j + 14400000) {
                return;
            }
            a();
        }
    }
}
