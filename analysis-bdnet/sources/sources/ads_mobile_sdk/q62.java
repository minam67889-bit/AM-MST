package ads_mobile_sdk;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.libraries.ads.mobile.sdk.internal.nativead.InternalNativeAd;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractActivityC4087sf;
import defpackage.AbstractC3634my;
import defpackage.C3979rH;
import defpackage.Sa0;
import defpackage.YE;

/* loaded from: classes.dex */
public final class q62 extends Sa0 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ r62 b;
    public final /* synthetic */ InternalNativeAd c;
    public final /* synthetic */ ImageView.ScaleType d;

    public q62(Context context, r62 r62Var, InternalNativeAd internalNativeAd, ImageView.ScaleType scaleType) {
        this.a = context;
        this.b = r62Var;
        this.c = internalNativeAd;
        this.d = scaleType;
    }

    @Override // defpackage.Sa0
    public final void a(AbstractActivityC4087sf abstractActivityC4087sf, LinearLayout linearLayout) {
        AbstractC3634my.g(abstractActivityC4087sf, "activity");
        AbstractC3634my.g(linearLayout, "layout");
        C3979rH c3979rH = new C3979rH(abstractActivityC4087sf);
        c3979rH.setTag("ad_view_tag");
        c3979rH.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(-1);
        linearLayout.addView(c3979rH);
        LinearLayout linearLayout2 = new LinearLayout(abstractActivityC4087sf);
        linearLayout2.setTag("layout_tag");
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        c3979rH.addView(linearLayout2);
        Resources resources = this.a.getResources();
        if (resources == null) {
            return;
        }
        String string = resources.getString(R.string.native_headline);
        AbstractC3634my.f(string, "getString(...)");
        linearLayout2.addView(r62.a(this.b, abstractActivityC4087sf, string, "headline_header_tag"));
        String str = (String) this.c.p.d.get("headline");
        if (str == null) {
            str = "";
        }
        View b = r62.b(this.b, abstractActivityC4087sf, str, "headline_tag");
        c3979rH.setHeadlineView(b);
        linearLayout2.addView(b);
        String string2 = resources.getString(R.string.native_body);
        AbstractC3634my.f(string2, "getString(...)");
        linearLayout2.addView(r62.a(this.b, abstractActivityC4087sf, string2, "body_header_tag"));
        String str2 = (String) this.c.p.d.get("body");
        if (str2 == null) {
            str2 = "";
        }
        View b2 = r62.b(this.b, abstractActivityC4087sf, str2, "body_tag");
        c3979rH.setBodyView(b2);
        linearLayout2.addView(b2);
        String string3 = resources.getString(R.string.native_media_view);
        AbstractC3634my.f(string3, "getString(...)");
        linearLayout2.addView(r62.a(this.b, abstractActivityC4087sf, string3, "media_view_header_tag"));
        YE ye = new YE(abstractActivityC4087sf);
        ye.setTag("media_view_tag");
        ye.setImageScaleType(this.d);
        linearLayout2.addView(ye);
        hr1 hr1Var = new hr1(this.c);
        c3979rH.getNativeAdViewContainer().a(ye, "3010");
        gt1 gt1Var = new gt1(c3979rH);
        synchronized (ye) {
            ye.c = gt1Var;
        }
        ImageView.ScaleType scaleType = ye.a;
        if (scaleType != null) {
            gt1Var.a(scaleType);
        }
        c3979rH.getNativeAdViewContainer().a(hr1Var.b);
    }

    @Override // defpackage.J80
    public final void onDestroy() {
        this.c.destroy();
    }
}
