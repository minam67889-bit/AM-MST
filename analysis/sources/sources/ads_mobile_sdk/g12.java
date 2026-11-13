package ads_mobile_sdk;

import android.content.Context;
import android.content.res.Resources;
import app.vpn.amtunnellite.R;
import defpackage.AbstractC0249Iy;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC3354fY;
import defpackage.AbstractC4575vQ;
import defpackage.AbstractC4747xe;
import defpackage.AbstractC4766xx;
import defpackage.BG;
import defpackage.C0471Rn;
import defpackage.C0508Sy;
import defpackage.C3506hW;
import defpackage.EnumC0516Tg;
import defpackage.InterfaceC0231Ig;
import defpackage.InterfaceC3821lc0;
import defpackage.InterfaceC3975nc0;
import defpackage.InterfaceC4441tg;
import defpackage.YY;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class g12 {
    public final Context a;
    public final InterfaceC0231Ig b;
    public final v42 c;
    public final g52 d;
    public final BG e;
    public final ex0 f;
    public final as3 g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public g12(Context context, InterfaceC0231Ig interfaceC0231Ig, v42 v42Var, g52 g52Var, BG bg, ex0 ex0Var, as3 as3Var) {
        AbstractC4766xx.p(context, "context");
        AbstractC4766xx.p(interfaceC0231Ig, "backgroundContext");
        AbstractC4766xx.p(v42Var, "nativeAssetsLoader");
        AbstractC4766xx.p(g52Var, "nativeCustomAssetsLoader");
        AbstractC4766xx.p(bg, "nativeRequest");
        AbstractC4766xx.p(ex0Var, "flags");
        AbstractC4766xx.p(as3Var, "traceLogger");
        this.a = context;
        this.b = interfaceC0231Ig;
        this.c = v42Var;
        this.d = g52Var;
        this.e = bg;
        this.f = ex0Var;
        this.g = as3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0070 A[Catch: all -> 0x002f, TRY_LEAVE, TryCatch #5 {all -> 0x002f, blocks: (B:11:0x002b, B:12:0x006a, B:14:0x0070, B:20:0x0081, B:21:0x008f), top: B:10:0x002b }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00aa A[Catch: all -> 0x00b6, TryCatch #2 {all -> 0x00b6, blocks: (B:25:0x00a3, B:27:0x00aa, B:29:0x00ae, B:31:0x00b2, B:32:0x00b8, B:34:0x00bc, B:36:0x00c0, B:38:0x00c4, B:39:0x00c5, B:40:0x00ca, B:41:0x00cb, B:42:0x00d2, B:43:0x00d3, B:44:0x00da, B:45:0x00db), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00db A[Catch: all -> 0x00b6, TRY_LEAVE, TryCatch #2 {all -> 0x00b6, blocks: (B:25:0x00a3, B:27:0x00aa, B:29:0x00ae, B:31:0x00b2, B:32:0x00b8, B:34:0x00bc, B:36:0x00c0, B:38:0x00c4, B:39:0x00c5, B:40:0x00ca, B:41:0x00cb, B:42:0x00d2, B:43:0x00d3, B:44:0x00da, B:45:0x00db), top: B:24:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(g12 g12Var, s02 s02Var, r31 r31Var, InterfaceC4441tg interfaceC4441tg) {
        e12 e12Var;
        Object obj;
        int i;
        rr3 a;
        C3506hW th;
        rr3 rr3Var;
        C3506hW e;
        g12Var.getClass();
        if (interfaceC4441tg instanceof e12) {
            e12Var = (e12) interfaceC4441tg;
            int i2 = e12Var.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                e12Var.e = i2 - Integer.MIN_VALUE;
                Object obj2 = e12Var.c;
                obj = EnumC0516Tg.a;
                i = e12Var.e;
                InterfaceC4441tg interfaceC4441tg2 = null;
                if (i != 0) {
                    AbstractC3354fY.n0(obj2);
                    s11 s11Var = s11.CUI_NAME_LOAD_NATIVE_IMMERSIVE_VIDEO_MEDIA_DATA;
                    WeakHashMap weakHashMap = hs3.a;
                    a = hs3.a(s11Var, C0471Rn.a, true);
                    try {
                        q41 d = r31Var.d();
                        if (d == null) {
                            throw new w01(new m01("Video controller is null.", kk1.a));
                        }
                        try {
                            long Y = g12Var.f.Y();
                            js jsVar = new js(d, s02Var, interfaceC4441tg2, 9);
                            e12Var.a = a;
                            e12Var.b = a;
                            e12Var.e = 1;
                            if (AbstractC0363Nj.M(Y, jsVar, e12Var) != obj) {
                                rr3Var = a;
                            }
                            return obj;
                        } catch (C3506hW e2) {
                            e = e2;
                            throw new w01(new j01(e, kk1.j, "Immersive video media data timed out."));
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        rr3Var = a;
                        a.b(th);
                        if (!(th instanceof InterfaceC3975nc0)) {
                            throw th;
                        }
                        if (!(th instanceof C3506hW) && !(th instanceof CancellationException)) {
                            a.a(th);
                        }
                        if (th instanceof C3506hW) {
                            throw new i21(th);
                        }
                        if (th instanceof CancellationException) {
                            throw new wz0(th);
                        }
                        if (th instanceof w01) {
                            throw th;
                        }
                        throw new b01(th);
                    }
                }
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                rr3Var = e12Var.b;
                try {
                    try {
                        AbstractC3354fY.n0(obj2);
                    } catch (C3506hW e3) {
                        e = e3;
                        throw new w01(new j01(e, kk1.j, "Immersive video media data timed out."));
                    }
                } catch (Throwable th3) {
                    th = th3;
                    a = e12Var.a;
                    try {
                        a.b(th);
                        if (!(th instanceof InterfaceC3975nc0)) {
                        }
                    } finally {
                    }
                }
                obj = YY.a;
                if (obj instanceof i01) {
                    xs3.a((i01) obj, false);
                }
                AbstractC4747xe.l(rr3Var, null);
                return obj;
            }
        }
        e12Var = new e12(g12Var, interfaceC4441tg);
        Object obj22 = e12Var.c;
        obj = EnumC0516Tg.a;
        i = e12Var.e;
        InterfaceC4441tg interfaceC4441tg22 = null;
        if (i != 0) {
        }
        obj = YY.a;
        if (obj instanceof i01) {
        }
        AbstractC4747xe.l(rr3Var, null);
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(i2 i2Var, C0508Sy c0508Sy, eo2 eo2Var, InterfaceC4441tg interfaceC4441tg) {
        u02 u02Var;
        int i;
        q02 q02Var;
        String str;
        InterfaceC3821lc0 q01Var;
        String o;
        String o2;
        String o3;
        String o4;
        String o5;
        String o6;
        String str2;
        s02 s02Var;
        try {
            if (interfaceC4441tg instanceof u02) {
                u02Var = (u02) interfaceC4441tg;
                int i2 = u02Var.d;
                if ((i2 & Integer.MIN_VALUE) != 0) {
                    u02Var.d = i2 - Integer.MIN_VALUE;
                    Object obj = u02Var.b;
                    EnumC0516Tg enumC0516Tg = EnumC0516Tg.a;
                    i = u02Var.d;
                    if (i == 0) {
                        if (i == 1) {
                            s02Var = u02Var.a;
                            AbstractC3354fY.n0(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        AbstractC3354fY.n0(obj);
                        s02 s02Var2 = new s02();
                        String a = ds1.a(c0508Sy, "extra_response_info", "");
                        if (a.length() > 0) {
                            try {
                                s02Var2.w = AbstractC4747xe.R(a).i();
                            } catch (Exception e) {
                                this.g.a("Failed to parse extra_response_info", (Throwable) e);
                            }
                        }
                        int a2 = ds1.a(c0508Sy, "template_id", -1);
                        s02Var2.a = a2;
                        if (a2 != 3) {
                            if (a2 != 6) {
                                q01Var = new m01("Invalid native ad template id!");
                                if (!(q01Var instanceof i01)) {
                                    return (i01) q01Var;
                                }
                                d12 d12Var = new d12(eo2Var, s02Var2, this, c0508Sy, null);
                                u02Var.a = s02Var2;
                                u02Var.d = 1;
                                if (AbstractC0363Nj.d(d12Var, u02Var) == enumC0516Tg) {
                                    return enumC0516Tg;
                                }
                                s02Var = s02Var2;
                            } else {
                                q02Var = q02.a;
                            }
                        } else {
                            q02Var = q02.b;
                        }
                        s02Var2.b = q02Var;
                        AbstractC0249Iy v = c0508Sy.v("custom_template_id");
                        String str3 = null;
                        if (v != null) {
                            str = v.o();
                        } else {
                            str = null;
                        }
                        s02Var2.c = str;
                        if (s02Var2.b == q02.b && str == null) {
                            q01Var = new m01("No custom template id for custom template ad response.");
                        } else {
                            s02Var2.e = Double.valueOf(Double.parseDouble(ds1.a(c0508Sy, "rating", "-1.0")));
                            AbstractC0249Iy v2 = c0508Sy.v("headline");
                            if (v2 != null) {
                                str3 = v2.o();
                            }
                            if (i2Var.d0) {
                                int i3 = zn3.a;
                                Context context = this.a;
                                AbstractC4766xx.p(context, "context");
                                try {
                                    str2 = context.getResources().getString(R.string.test_ad);
                                    AbstractC4766xx.m(str2);
                                } catch (Resources.NotFoundException unused) {
                                    str2 = "Test Ad";
                                }
                                str3 = AbstractC4575vQ.s(str2, ": ", str3);
                            }
                            Map map = s02Var2.d;
                            if (str3 != null) {
                                map.put("headline", str3);
                            }
                            AbstractC0249Iy v3 = c0508Sy.v("body");
                            if (v3 != null && (o6 = v3.o()) != null) {
                                map.put("body", o6);
                            }
                            AbstractC0249Iy v4 = c0508Sy.v("call_to_action");
                            if (v4 != null && (o5 = v4.o()) != null) {
                                map.put("call_to_action", o5);
                            }
                            AbstractC0249Iy v5 = c0508Sy.v("store");
                            if (v5 != null && (o4 = v5.o()) != null) {
                                map.put("store", o4);
                            }
                            AbstractC0249Iy v6 = c0508Sy.v("price");
                            if (v6 != null && (o3 = v6.o()) != null) {
                                map.put("price", o3);
                            }
                            AbstractC0249Iy v7 = c0508Sy.v("advertiser");
                            if (v7 != null && (o2 = v7.o()) != null) {
                                map.put("advertiser", o2);
                            }
                            AbstractC0249Iy v8 = c0508Sy.v("creative_summary");
                            if (v8 != null && (o = v8.o()) != null) {
                                map.put("creative_summary", o);
                            }
                            String a3 = ds1.a(c0508Sy, "app_id", "");
                            if (a3.length() > 0) {
                                map.put("package_name", a3);
                            }
                            s02Var2.u = this.e.l();
                            q01Var = new q01(YY.a);
                        }
                        if (!(q01Var instanceof i01)) {
                        }
                    }
                    return new q01(s02Var);
                }
            }
            if (i == 0) {
            }
            return new q01(s02Var);
        } catch (w01 e2) {
            return e2.a;
        }
        u02Var = new u02(this, interfaceC4441tg);
        Object obj2 = u02Var.b;
        EnumC0516Tg enumC0516Tg2 = EnumC0516Tg.a;
        i = u02Var.d;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0058 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #2 {all -> 0x002b, blocks: (B:11:0x0027, B:12:0x0052, B:14:0x0058), top: B:10:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070 A[Catch: all -> 0x007c, TryCatch #3 {all -> 0x007c, blocks: (B:22:0x0069, B:24:0x0070, B:26:0x0074, B:28:0x0078, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:35:0x008a, B:36:0x008b, B:37:0x0090, B:38:0x0091, B:39:0x0098, B:40:0x0099, B:41:0x00a0, B:42:0x00a1), top: B:21:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a1 A[Catch: all -> 0x007c, TRY_LEAVE, TryCatch #3 {all -> 0x007c, blocks: (B:22:0x0069, B:24:0x0070, B:26:0x0074, B:28:0x0078, B:29:0x007e, B:31:0x0082, B:33:0x0086, B:35:0x008a, B:36:0x008b, B:37:0x0090, B:38:0x0091, B:39:0x0098, B:40:0x0099, B:41:0x00a0, B:42:0x00a1), top: B:21:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object a(i2 i2Var, C0508Sy c0508Sy, eo2 eo2Var, InterfaceC4441tg interfaceC4441tg) {
        t02 t02Var;
        int i;
        rr3 a;
        C3506hW th;
        rr3 rr3Var;
        rr3 rr3Var2;
        InterfaceC3821lc0 interfaceC3821lc0;
        if (interfaceC4441tg instanceof t02) {
            t02Var = (t02) interfaceC4441tg;
            int i2 = t02Var.e;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                t02Var.e = i2 - Integer.MIN_VALUE;
                Object obj = t02Var.c;
                Object obj2 = EnumC0516Tg.a;
                i = t02Var.e;
                if (i != 0) {
                    AbstractC3354fY.n0(obj);
                    s11 s11Var = s11.CUI_NAME_LOAD_NATIVE_ASSETS;
                    WeakHashMap weakHashMap = hs3.a;
                    a = hs3.a(s11Var, C0471Rn.a, true);
                    try {
                        t02Var.a = a;
                        t02Var.b = a;
                        t02Var.e = 1;
                        Object b = b(i2Var, c0508Sy, eo2Var, t02Var);
                        if (b == obj2) {
                            return obj2;
                        }
                        rr3Var2 = a;
                        obj = b;
                        rr3Var = rr3Var2;
                    } catch (Throwable th2) {
                        th = th2;
                        rr3Var = a;
                        a.b(th);
                        if (!(th instanceof InterfaceC3975nc0)) {
                            throw th;
                        }
                        if (!(th instanceof C3506hW) && !(th instanceof CancellationException)) {
                            a.a(th);
                        }
                        if (th instanceof C3506hW) {
                            throw new i21(th);
                        }
                        if (th instanceof CancellationException) {
                            throw new wz0(th);
                        }
                        if (th instanceof w01) {
                            throw th;
                        }
                        throw new b01(th);
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    rr3Var = t02Var.b;
                    rr3Var2 = t02Var.a;
                    try {
                        AbstractC3354fY.n0(obj);
                    } catch (Throwable th3) {
                        th = th3;
                        a = rr3Var2;
                        try {
                            a.b(th);
                            if (!(th instanceof InterfaceC3975nc0)) {
                            }
                        } finally {
                        }
                    }
                }
                interfaceC3821lc0 = (InterfaceC3821lc0) obj;
                if (interfaceC3821lc0 instanceof i01) {
                    xs3.a((i01) interfaceC3821lc0, false);
                }
                AbstractC4747xe.l(rr3Var, null);
                return interfaceC3821lc0;
            }
        }
        t02Var = new t02(this, interfaceC4441tg);
        Object obj3 = t02Var.c;
        Object obj22 = EnumC0516Tg.a;
        i = t02Var.e;
        if (i != 0) {
        }
        interfaceC3821lc0 = (InterfaceC3821lc0) obj3;
        if (interfaceC3821lc0 instanceof i01) {
        }
        AbstractC4747xe.l(rr3Var, null);
        return interfaceC3821lc0;
    }
}
