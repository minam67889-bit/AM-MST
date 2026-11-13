package ads_mobile_sdk;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import app.vpn.amtunnellite.R;
import com.google.android.libraries.ads.mobile.sdk.internal.nativead.InternalNativeAd;
import defpackage.AG;
import defpackage.AbstractActivityC0914cf;
import defpackage.AbstractC3317f30;
import defpackage.AbstractC4766xx;
import defpackage.C3488hE;
import defpackage.P90;
import defpackage.RunnableC4080p1;
import defpackage.RunnableC4699x3;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class rh2 extends AbstractC3317f30 {
    public final /* synthetic */ Context a;
    public final /* synthetic */ sh2 b;
    public final /* synthetic */ InternalNativeAd c;
    public final /* synthetic */ ImageView.ScaleType d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC3556i70
    public final void onDestroy() {
        this.c.destroy();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public rh2(Context context, sh2 sh2Var, InternalNativeAd internalNativeAd, ImageView.ScaleType scaleType) {
        this.a = context;
        this.b = sh2Var;
        this.c = internalNativeAd;
        this.d = scaleType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC3317f30
    public final void a(AbstractActivityC0914cf abstractActivityC0914cf, LinearLayout linearLayout) {
        Context context;
        AbstractC4766xx.p(abstractActivityC0914cf, "activity");
        AG ag = new AG(abstractActivityC0914cf);
        ag.setTag("ad_view_tag");
        ag.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        linearLayout.setBackgroundColor(-1);
        linearLayout.addView(ag);
        LinearLayout linearLayout2 = new LinearLayout(abstractActivityC0914cf);
        linearLayout2.setTag("layout_tag");
        linearLayout2.setOrientation(1);
        linearLayout2.setBackgroundColor(-1);
        linearLayout2.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ag.addView(linearLayout2);
        Resources resources = this.a.getResources();
        if (resources == null) {
            return;
        }
        String string = resources.getString(R.string.native_headline);
        AbstractC4766xx.o(string, "getString(...)");
        linearLayout2.addView(sh2.a(this.b, abstractActivityC0914cf, string, "headline_header_tag"));
        String str = (String) this.c.a.d.get("headline");
        if (str == null) {
            str = "";
        }
        View b = sh2.b(this.b, abstractActivityC0914cf, str, "headline_tag");
        ag.setHeadlineView(b);
        linearLayout2.addView(b);
        String string2 = resources.getString(R.string.native_body);
        AbstractC4766xx.o(string2, "getString(...)");
        linearLayout2.addView(sh2.a(this.b, abstractActivityC0914cf, string2, "body_header_tag"));
        String str2 = (String) this.c.a.d.get("body");
        if (str2 == null) {
            str2 = "";
        }
        View b2 = sh2.b(this.b, abstractActivityC0914cf, str2, "body_tag");
        ag.setBodyView(b2);
        linearLayout2.addView(b2);
        String string3 = resources.getString(R.string.native_media_view);
        AbstractC4766xx.o(string3, "getString(...)");
        linearLayout2.addView(sh2.a(this.b, abstractActivityC0914cf, string3, "media_view_header_tag"));
        C3488hE c3488hE = new C3488hE(abstractActivityC0914cf);
        c3488hE.setTag("media_view_tag");
        c3488hE.setImageScaleType(this.d);
        linearLayout2.addView(c3488hE);
        l12 l12Var = new l12(this.c);
        ag.getNativeAdViewContainer().a(c3488hE, "3010");
        fa faVar = new fa(ag, 20);
        synchronized (c3488hE) {
            c3488hE.b = faVar;
        }
        ImageView.ScaleType scaleType = c3488hE.a;
        if (scaleType != null) {
            faVar.a(scaleType);
        }
        p32 nativeAdViewContainer = ag.getNativeAdViewContainer();
        InternalNativeAd internalNativeAd = l12Var.b;
        nativeAdViewContainer.getClass();
        AbstractC4766xx.p(internalNativeAd, "newNativeAd");
        synchronized (nativeAdViewContainer) {
            try {
                if (!nativeAdViewContainer.d.get()) {
                    InternalNativeAd internalNativeAd2 = nativeAdViewContainer.i;
                    if (internalNativeAd2 != null) {
                        nativeAdViewContainer.c(internalNativeAd2);
                    }
                    P90.Vo.getClass();
                    Handler handler = n32.b;
                    handler.post(new RunnableC4080p1(nativeAdViewContainer, 25));
                    nativeAdViewContainer.b(internalNativeAd);
                    String str3 = internalNativeAd.a.v;
                    GestureDetector gestureDetector = null;
                    if (str3 != null) {
                        if (str3.length() <= 0) {
                            str3 = null;
                        }
                        if (str3 != null) {
                            handler.post(new RunnableC4699x3(19, nativeAdViewContainer, str3));
                        }
                    }
                    FrameLayout frameLayout = nativeAdViewContainer.b;
                    if (frameLayout != null && (context = frameLayout.getContext()) != null) {
                        if (internalNativeAd.e.e() != 0) {
                            gestureDetector = new GestureDetector(context, new i52(internalNativeAd.e, new WeakReference(nativeAdViewContainer.b)));
                        }
                        nativeAdViewContainer.g = gestureDetector;
                    }
                    nativeAdViewContainer.i = internalNativeAd;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
