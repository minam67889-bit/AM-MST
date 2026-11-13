package defpackage;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.appopen.AppOpenAd;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPApplication;

/* renamed from: wI, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3501wI {
    public static final /* synthetic */ int e = 0;
    public AppOpenAd a = null;
    public boolean b = false;
    public boolean c = false;
    public final /* synthetic */ UDPApplication d;

    static {
        "AppOpenAdManager";
        "ca-app-pub-6746713660924923/6382747342";
    }

    public C3501wI(UDPApplication uDPApplication) {
        this.d = uDPApplication;
    }

    public final void a(Context context) {
        if (this.b || this.a != null) {
            return;
        }
        this.b = true;
        AppOpenAd.load(context, "ca-app-pub-6746713660924923/6382747342", new AdRequest.Builder().build(), new C3395uI(this));
    }

    public final void b(Activity activity, InterfaceC3554xI interfaceC3554xI) {
        if (this.c) {
            return;
        }
        AppOpenAd appOpenAd = this.a;
        if (appOpenAd != null) {
            appOpenAd.setFullScreenContentCallback(new C3448vI(this, interfaceC3554xI, activity));
            this.c = true;
            this.a.show(activity);
            return;
        }
        interfaceC3554xI.b();
        long j = this.d.c.getLong("ao_ads_time", 0L);
        if (j != 0 && (j == 0 || System.currentTimeMillis() < j + 3600000)) {
            return;
        }
        a(activity);
    }
}
