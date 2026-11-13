package ads_mobile_sdk;

import android.content.Context;
import android.content.res.Resources;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC0325Me;
import defpackage.AbstractC0538Uj;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC3634my;
import defpackage.AbstractC4266uz;
import defpackage.C0139Ez;
import defpackage.C0729aX;
import defpackage.C3147go;
import defpackage.C4471xZ;
import defpackage.EnumC3299ih;
import defpackage.Ge0;
import defpackage.InterfaceC0198Hg;
import defpackage.InterfaceC0613Xg;
import defpackage.InterfaceC3215he0;
import defpackage.InterfaceC4058sH;
import defpackage.Sf0;
import defpackage.W50;
import defpackage.W80;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class cr1 {
    public final Context a;
    public final InterfaceC0613Xg b;
    public final ou1 c;
    public final zu1 d;
    public final InterfaceC4058sH e;
    public final hq0 f;
    public final InterfaceC3215he0 g;

    public cr1(Context context, InterfaceC0613Xg interfaceC0613Xg, ou1 ou1Var, zu1 zu1Var, InterfaceC4058sH interfaceC4058sH, hq0 hq0Var, InterfaceC3215he0 interfaceC3215he0) {
        AbstractC3634my.g(context, "context");
        AbstractC3634my.g(interfaceC0613Xg, "backgroundContext");
        AbstractC3634my.g(ou1Var, "nativeAssetsLoader");
        AbstractC3634my.g(zu1Var, "nativeCustomAssetsLoader");
        AbstractC3634my.g(interfaceC4058sH, "nativeRequest");
        AbstractC3634my.g(hq0Var, "flags");
        AbstractC3634my.g(interfaceC3215he0, "traceLogger");
        this.a = context;
        this.b = interfaceC0613Xg;
        this.c = ou1Var;
        this.d = zu1Var;
        this.e = interfaceC4058sH;
        this.f = hq0Var;
        this.g = interfaceC3215he0;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009f A[Catch: all -> 0x00af, TryCatch #5 {all -> 0x00af, blocks: (B:23:0x0098, B:25:0x009f, B:27:0x00a6, B:29:0x00aa, B:31:0x00ae, B:32:0x00b1, B:33:0x00b6, B:34:0x00b7, B:35:0x00be, B:36:0x00bf, B:37:0x00c6, B:38:0x00c7), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00c7 A[Catch: all -> 0x00af, TRY_LEAVE, TryCatch #5 {all -> 0x00af, blocks: (B:23:0x0098, B:25:0x009f, B:27:0x00a6, B:29:0x00aa, B:31:0x00ae, B:32:0x00b1, B:33:0x00b6, B:34:0x00b7, B:35:0x00be, B:36:0x00bf, B:37:0x00c6, B:38:0x00c7), top: B:22:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(cr1 cr1Var, oq1 oq1Var, lw0 lw0Var, InterfaceC0198Hg interfaceC0198Hg) {
        ar1 ar1Var;
        int i;
        rc3 a;
        C0729aX th;
        rc3 rc3Var;
        C0729aX e;
        long R;
        br1 br1Var;
        cr1Var.getClass();
        if (interfaceC0198Hg instanceof ar1) {
            ar1Var = (ar1) interfaceC0198Hg;
            int i2 = ar1Var.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                ar1Var.e = i2 - Integer.MIN_VALUE;
                Object obj = ar1Var.c;
                EnumC3299ih enumC3299ih = EnumC3299ih.a;
                i = ar1Var.e;
                if (i != 0) {
                    W80.U(obj);
                    pu0 pu0Var = pu0.CUI_NAME_LOAD_NATIVE_IMMERSIVE_VIDEO_MEDIA_DATA;
                    WeakHashMap weakHashMap = ed3.a;
                    a = ed3.a(pu0Var, C3147go.a, true);
                    try {
                        ix0 d = lw0Var.d();
                        if (d == null) {
                            throw new au0(new tt0("Video controller is null.", fb1.a));
                        }
                        try {
                            R = cr1Var.f.R();
                            br1Var = new br1(d, oq1Var, null);
                        } catch (C0729aX e2) {
                            e = e2;
                        }
                        try {
                            ar1Var.a = a;
                            ar1Var.b = a;
                            ar1Var.e = 1;
                            if (AbstractC3634my.N(R, br1Var, ar1Var) == enumC3299ih) {
                                return enumC3299ih;
                            }
                            rc3Var = a;
                        } catch (C0729aX e3) {
                            e = e3;
                            e = e;
                            throw new au0(new qt0(e, fb1.j, "Immersive video media data timed out."));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        rc3Var = a;
                        a.b(th);
                        if (!(th instanceof Ge0)) {
                            throw th;
                        }
                        a.a(th);
                        if (th instanceof C0729aX) {
                            throw new ev0(th);
                        }
                        if (th instanceof CancellationException) {
                            throw new dt0(th);
                        }
                        if (th instanceof au0) {
                            throw th;
                        }
                        throw new it0(th);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    rc3Var = ar1Var.b;
                    try {
                        try {
                            W80.U(obj);
                        } catch (C0729aX e4) {
                            e = e4;
                            throw new au0(new qt0(e, fb1.j, "Immersive video media data timed out."));
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        a = ar1Var.a;
                        try {
                            a.b(th);
                            if (!(th instanceof Ge0)) {
                            }
                        } finally {
                        }
                    }
                }
                C4471xZ c4471xZ = C4471xZ.a;
                AbstractC0325Me.k(rc3Var, null);
                return c4471xZ;
            }
        }
        ar1Var = new ar1(cr1Var, interfaceC0198Hg);
        Object obj2 = ar1Var.c;
        EnumC3299ih enumC3299ih2 = EnumC3299ih.a;
        i = ar1Var.e;
        if (i != 0) {
        }
        C4471xZ c4471xZ2 = C4471xZ.a;
        AbstractC0325Me.k(rc3Var, null);
        return c4471xZ2;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(a2 a2Var, C0139Ez c0139Ez, sb2 sb2Var, InterfaceC0198Hg interfaceC0198Hg) {
        qq1 qq1Var;
        int i;
        oq1 oq1Var;
        try {
            if (interfaceC0198Hg instanceof qq1) {
                qq1Var = (qq1) interfaceC0198Hg;
                int i2 = qq1Var.d;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    qq1Var.d = i2 - Integer.MIN_VALUE;
                    Object obj = qq1Var.b;
                    EnumC3299ih enumC3299ih = EnumC3299ih.a;
                    i = qq1Var.d;
                    if (i != 0) {
                        W80.U(obj);
                        oq1 oq1Var2 = new oq1();
                        Sf0 a = a(this.a, oq1Var2, a2Var, c0139Ez);
                        if (a instanceof pt0) {
                            return (pt0) a;
                        }
                        AbstractC3634my.e(a, "null cannot be cast to non-null type com.google.android.libraries.ads.mobile.sdk.internal.util.GmaResult.Success<T of com.google.android.libraries.ads.mobile.sdk.internal.util.GmaResult.Companion.returnIfError>");
                        zq1 zq1Var = new zq1(sb2Var, oq1Var2, this, c0139Ez, null);
                        qq1Var.a = oq1Var2;
                        qq1Var.d = 1;
                        if (AbstractC0538Uj.m(zq1Var, qq1Var) == enumC3299ih) {
                            return enumC3299ih;
                        }
                        oq1Var = oq1Var2;
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        oq1Var = qq1Var.a;
                        W80.U(obj);
                    }
                    return new vt0(oq1Var);
                }
            }
            if (i != 0) {
            }
            return new vt0(oq1Var);
        } catch (au0 e) {
            return e.a;
        }
        qq1Var = new qq1(this, interfaceC0198Hg);
        Object obj2 = qq1Var.b;
        EnumC3299ih enumC3299ih2 = EnumC3299ih.a;
        i = qq1Var.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #3 {all -> 0x002b, blocks: (B:11:0x0027, B:12:0x0052, B:14:0x0058), top: B:10:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[Catch: all -> 0x0080, TryCatch #0 {all -> 0x0080, blocks: (B:22:0x0069, B:24:0x0070, B:26:0x0077, B:28:0x007b, B:30:0x007f, B:31:0x0082, B:32:0x0087, B:33:0x0088, B:34:0x008f, B:35:0x0090, B:36:0x0097, B:37:0x0098), top: B:21:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0098 A[Catch: all -> 0x0080, TRY_LEAVE, TryCatch #0 {all -> 0x0080, blocks: (B:22:0x0069, B:24:0x0070, B:26:0x0077, B:28:0x007b, B:30:0x007f, B:31:0x0082, B:32:0x0087, B:33:0x0088, B:34:0x008f, B:35:0x0090, B:36:0x0097, B:37:0x0098), top: B:21:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(a2 a2Var, C0139Ez c0139Ez, sb2 sb2Var, InterfaceC0198Hg interfaceC0198Hg) {
        pq1 pq1Var;
        int i;
        rc3 a;
        C0729aX th;
        rc3 rc3Var;
        rc3 rc3Var2;
        Sf0 sf0;
        if (interfaceC0198Hg instanceof pq1) {
            pq1Var = (pq1) interfaceC0198Hg;
            int i2 = pq1Var.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                pq1Var.e = i2 - Integer.MIN_VALUE;
                Object obj = pq1Var.c;
                Object obj2 = EnumC3299ih.a;
                i = pq1Var.e;
                if (i != 0) {
                    W80.U(obj);
                    pu0 pu0Var = pu0.CUI_NAME_LOAD_NATIVE_ASSETS;
                    WeakHashMap weakHashMap = ed3.a;
                    a = ed3.a(pu0Var, C3147go.a, true);
                    try {
                        pq1Var.a = a;
                        pq1Var.b = a;
                        pq1Var.e = 1;
                        Object b = b(a2Var, c0139Ez, sb2Var, pq1Var);
                        if (b == obj2) {
                            return obj2;
                        }
                        rc3Var2 = a;
                        obj = b;
                        rc3Var = rc3Var2;
                    } catch (Throwable th2) {
                        th = th2;
                        rc3Var = a;
                        a.b(th);
                        if (th instanceof Ge0) {
                            a.a(th);
                            if (!(th instanceof C0729aX)) {
                                if (!(th instanceof CancellationException)) {
                                    if (th instanceof au0) {
                                        throw th;
                                    }
                                    throw new it0(th);
                                }
                                throw new dt0(th);
                            }
                            throw new ev0(th);
                        }
                        throw th;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    rc3Var = pq1Var.b;
                    rc3Var2 = pq1Var.a;
                    try {
                        W80.U(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        a = rc3Var2;
                        try {
                            a.b(th);
                            if (th instanceof Ge0) {
                            }
                        } finally {
                        }
                    }
                }
                sf0 = (Sf0) obj;
                if (sf0 instanceof pt0) {
                    td3.a((pt0) sf0, false);
                }
                AbstractC0325Me.k(rc3Var, null);
                return sf0;
            }
        }
        pq1Var = new pq1(this, interfaceC0198Hg);
        Object obj3 = pq1Var.c;
        Object obj22 = EnumC3299ih.a;
        i = pq1Var.e;
        if (i != 0) {
        }
        sf0 = (Sf0) obj3;
        if (sf0 instanceof pt0) {
        }
        AbstractC0325Me.k(rc3Var, null);
        return sf0;
    }

    public final Sf0 a(Context context, oq1 oq1Var, a2 a2Var, C0139Ez c0139Ez) {
        String a;
        String a2;
        String r;
        String r2;
        String r3;
        String r4;
        String r5;
        String str;
        a = ii1.a(c0139Ez, "extra_response_info", "");
        if (a.length() > 0) {
            try {
                oq1Var.w = AbstractC0641Yi.I(a).l();
            } catch (Exception e) {
                ((yc3) this.g).a("Failed to parse extra_response_info", e);
            }
        }
        int a3 = ii1.a(c0139Ez, "template_id", -1);
        oq1Var.a = a3;
        if (a3 == 3) {
            oq1Var.b = mq1.b;
        } else {
            if (a3 != 6) {
                return new tt0("Invalid native ad template id!");
            }
            oq1Var.b = mq1.a;
        }
        AbstractC4266uz y = c0139Ez.y("custom_template_id");
        String r6 = y != null ? y.r() : null;
        oq1Var.c = r6;
        if (oq1Var.b == mq1.b && r6 == null) {
            return new tt0("No custom template id for custom template ad response.");
        }
        oq1Var.e = Double.valueOf(Double.parseDouble(ii1.a(c0139Ez, "rating", "-1.0")));
        AbstractC4266uz y2 = c0139Ez.y("headline");
        String r7 = y2 != null ? y2.r() : null;
        if (a2Var.c0) {
            int i = v83.a;
            AbstractC3634my.g(context, "context");
            try {
                str = context.getResources().getString(R.string.test_ad);
                AbstractC3634my.d(str);
            } catch (Resources.NotFoundException unused) {
                str = "Test Ad";
            }
            r7 = W50.n(str, ": ", r7);
        }
        if (r7 != null) {
            oq1Var.d.put("headline", r7);
        }
        AbstractC4266uz y3 = c0139Ez.y("body");
        if (y3 != null && (r5 = y3.r()) != null) {
            oq1Var.d.put("body", r5);
        }
        AbstractC4266uz y4 = c0139Ez.y("call_to_action");
        if (y4 != null && (r4 = y4.r()) != null) {
            oq1Var.d.put("call_to_action", r4);
        }
        AbstractC4266uz y5 = c0139Ez.y("store");
        if (y5 != null && (r3 = y5.r()) != null) {
            oq1Var.d.put("store", r3);
        }
        AbstractC4266uz y6 = c0139Ez.y("price");
        if (y6 != null && (r2 = y6.r()) != null) {
            oq1Var.d.put("price", r2);
        }
        AbstractC4266uz y7 = c0139Ez.y("advertiser");
        if (y7 != null && (r = y7.r()) != null) {
            oq1Var.d.put("advertiser", r);
        }
        a2 = ii1.a(c0139Ez, "app_id", "");
        if (a2.length() > 0) {
            oq1Var.d.put("package_name", a2);
        }
        oq1Var.u = this.e.k();
        return new vt0(C4471xZ.a);
    }
}
