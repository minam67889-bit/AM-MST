package ads_mobile_sdk;

import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import defpackage.AbstractC3354fY;
import defpackage.AbstractC3411gE;
import defpackage.AbstractC3518he;
import defpackage.AbstractC4331sD;
import defpackage.AbstractC4542v10;
import defpackage.AbstractC4766xx;
import defpackage.C0508Sy;
import defpackage.C3554i60;
import defpackage.C3755km;
import defpackage.C4742xb0;
import defpackage.EnumC0516Tg;
import defpackage.EnumC3909mm;
import defpackage.F50;
import defpackage.H10;
import defpackage.I80;
import defpackage.InterfaceC0231Ig;
import defpackage.InterfaceC0490Sg;
import defpackage.InterfaceC4441tg;
import defpackage.JI;
import defpackage.Nc0;
import defpackage.YY;
import defpackage.Zc0;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class ex0 extends eq {
    public static final long A;
    public static final int B;
    public static final List C;
    public static final C0508Sy D;
    public static final C0508Sy E;
    public static final C0508Sy F;
    public static final C0508Sy G;
    public static final C0508Sy H;
    public static final C0508Sy I;
    public static final C0508Sy J;
    public static final long z;
    public final Nc0 r;
    public final C3554i60 s;
    public final I80 t;
    public final C4742xb0 u;
    public final F50 v;
    public boolean w;
    public double x;
    public int y;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        int i = C3755km.d;
        EnumC3909mm enumC3909mm = EnumC3909mm.e;
        z = AbstractC3411gE.M0(20, enumC3909mm);
        A = AbstractC3411gE.M0(1, enumC3909mm);
        B = mm0.TIER_LOW.getNumber();
        C = AbstractC3518he.T("addtl_consent", "gdpr", "gdpr_consent", "gpp", "gpp_sid", "ltd", "npa", "rdp", "tfcd", "tfua", "us_privacy", "c", "correlator");
        C0508Sy c0508Sy = new C0508Sy();
        y11 y11Var = y11.AD_ID_INFO;
        c0508Sy.q(500, String.valueOf(y11Var.getNumber()));
        y11 y11Var2 = y11.AD_REQUEST;
        kj3 kj3Var = kj3.b;
        H10.e(c0508Sy, y11Var2, kj3Var);
        y11 y11Var3 = y11.AD_SPAM;
        kj3 kj3Var2 = kj3.e;
        H10.e(c0508Sy, y11Var3, kj3Var2);
        H10.e(c0508Sy, y11.AD_SIZE, kj3Var);
        H10.e(c0508Sy, y11.AD_TYPE, kj3Var);
        H10.e(c0508Sy, y11.APP_OPEN, kj3Var);
        H10.e(c0508Sy, y11.APP_PERMISSIONS, kj3Var);
        H10.e(c0508Sy, y11.APP_SET_ID, kj3Var);
        y11 y11Var4 = y11.AUDIO;
        kj3 kj3Var3 = kj3.d;
        H10.e(c0508Sy, y11Var4, kj3Var3);
        y11 y11Var5 = y11.BATTERY;
        H10.e(c0508Sy, y11Var5, kj3Var);
        y11 y11Var6 = y11.CLD;
        kj3 kj3Var4 = kj3.c;
        H10.e(c0508Sy, y11Var6, kj3Var4);
        y11 y11Var7 = y11.COARSE_LOCATION;
        H10.e(c0508Sy, y11Var7, kj3Var);
        H10.e(c0508Sy, y11.DEBUG_SIGNAL, kj3Var);
        H10.e(c0508Sy, y11.EXPERIMENT_IDS, kj3Var);
        H10.e(c0508Sy, y11.IN_MEMORY_SDK_CORE_DATA, kj3Var);
        H10.e(c0508Sy, y11.MEMORY, kj3Var);
        H10.e(c0508Sy, y11.OMID, kj3Var);
        H10.e(c0508Sy, y11.PACKAGE_INFO, kj3Var);
        H10.e(c0508Sy, y11.PER_APP_ID_V1, kj3Var);
        H10.e(c0508Sy, y11.PER_APP_ID_V2, kj3Var);
        H10.e(c0508Sy, y11.STATIC_DEVICE, kj3Var);
        H10.e(c0508Sy, y11.TELEPHONY, kj3Var);
        H10.e(c0508Sy, y11.CONSENT_STRINGS, kj3Var);
        H10.e(c0508Sy, y11.AD_ID_PERMISSION, kj3Var);
        H10.e(c0508Sy, y11.QUALITY, kj3Var);
        H10.e(c0508Sy, y11.REQUEST_ID, kj3Var);
        H10.e(c0508Sy, y11.SDK_ENV, kj3Var);
        H10.e(c0508Sy, y11.ADAPTER_VERSIONS, kj3Var);
        H10.e(c0508Sy, y11.RTB_SIGNAL, kj3Var2);
        H10.e(c0508Sy, y11.SESSION_ID, kj3Var);
        y11 y11Var8 = y11.TRUSTLESS_TOKEN;
        H10.e(c0508Sy, y11Var8, kj3Var);
        H10.e(c0508Sy, y11.FIREBASE_ANALYTICS, kj3Var4);
        H10.e(c0508Sy, y11.HAND_HELD, kj3Var4);
        H10.e(c0508Sy, y11.PHONE_ORIENTATION, kj3Var);
        H10.e(c0508Sy, y11.IS_DEVICE_HELD, kj3Var3);
        H10.e(c0508Sy, y11.INSPECTOR_SIGNAL, kj3Var4);
        H10.e(c0508Sy, y11.AMAZON_FIRE_AD_ID, kj3Var);
        H10.e(c0508Sy, y11.DISPLAY_COUNT, kj3Var);
        H10.e(c0508Sy, y11.CSRB_ECO_DATA, kj3Var);
        H10.e(c0508Sy, y11.PARENT_AD_CONFIG, kj3Var);
        H10.e(c0508Sy, y11.NATIVE_AD, kj3Var4);
        H10.e(c0508Sy, y11.ICON_AD, kj3Var);
        y11 y11Var9 = y11.UNDEFINED;
        H10.e(c0508Sy, y11Var9, kj3Var4);
        H10.e(c0508Sy, y11.AD_RESPONSE_ENCRYPTION_KEY, kj3Var3);
        H10.e(c0508Sy, y11.SCAR_SIGNAL_TYPE, kj3Var);
        H10.e(c0508Sy, y11.DEVICE_TIER, kj3Var);
        H10.e(c0508Sy, y11.PICTURE_IN_PICTURE_AD_REQUEST, kj3Var);
        H10.e(c0508Sy, y11.EOID, kj3Var);
        D = c0508Sy;
        C0508Sy c0508Sy2 = new C0508Sy();
        String valueOf = String.valueOf(y11Var.getNumber());
        Boolean bool = Boolean.TRUE;
        c0508Sy2.s(valueOf, bool);
        String valueOf2 = String.valueOf(y11Var4.getNumber());
        Boolean bool2 = Boolean.FALSE;
        c0508Sy2.s(valueOf2, bool2);
        c0508Sy2.s(String.valueOf(y11Var5.getNumber()), bool2);
        c0508Sy2.s(String.valueOf(y11Var7.getNumber()), bool2);
        c0508Sy2.s(String.valueOf(y11Var8.getNumber()), bool2);
        c0508Sy2.s(String.valueOf(y11Var9.getNumber()), bool2);
        E = c0508Sy2;
        C0508Sy c0508Sy3 = new C0508Sy();
        c0508Sy3.s(String.valueOf(y11Var.getNumber()), bool);
        c0508Sy3.s(String.valueOf(y11Var4.getNumber()), bool2);
        c0508Sy3.s(String.valueOf(y11Var5.getNumber()), bool2);
        c0508Sy3.s(String.valueOf(y11Var7.getNumber()), bool2);
        c0508Sy3.s(String.valueOf(y11Var8.getNumber()), bool2);
        c0508Sy3.s(String.valueOf(y11Var9.getNumber()), bool2);
        F = c0508Sy3;
        C0508Sy c0508Sy4 = new C0508Sy();
        c0508Sy4.q(0, String.valueOf(y11Var.getNumber()));
        c0508Sy4.q(0, String.valueOf(y11Var4.getNumber()));
        c0508Sy4.q(0, String.valueOf(y11Var5.getNumber()));
        c0508Sy4.q(0, String.valueOf(y11Var7.getNumber()));
        long M0 = AbstractC3411gE.M0(30, enumC3909mm);
        c0508Sy4.q(Long.valueOf(C3755km.e(M0)), String.valueOf(y11Var8.getNumber()));
        c0508Sy4.q(0, String.valueOf(y11Var9.getNumber()));
        G = c0508Sy4;
        C0508Sy c0508Sy5 = new C0508Sy();
        EnumC3909mm enumC3909mm2 = EnumC3909mm.f;
        long M02 = AbstractC3411gE.M0(10, enumC3909mm2);
        c0508Sy5.q(Long.valueOf(C3755km.e(M02)), String.valueOf(y11Var.getNumber()));
        long M03 = AbstractC3411gE.M0(30, enumC3909mm);
        c0508Sy5.q(Long.valueOf(C3755km.e(M03)), String.valueOf(y11Var4.getNumber()));
        long M04 = AbstractC3411gE.M0(5, enumC3909mm2);
        c0508Sy5.q(Long.valueOf(C3755km.e(M04)), String.valueOf(y11Var5.getNumber()));
        long M05 = AbstractC3411gE.M0(10, enumC3909mm2);
        c0508Sy5.q(Long.valueOf(C3755km.e(M05)), String.valueOf(y11Var7.getNumber()));
        long M06 = AbstractC3411gE.M0(AdSize.MEDIUM_RECTANGLE_WIDTH, enumC3909mm);
        c0508Sy5.q(Long.valueOf(C3755km.e(M06)), String.valueOf(y11Var8.getNumber()));
        c0508Sy5.q(0, String.valueOf(y11Var9.getNumber()));
        H = c0508Sy5;
        C0508Sy c0508Sy6 = new C0508Sy();
        c0508Sy6.s(String.valueOf(y11Var.getNumber()), bool);
        c0508Sy6.s(String.valueOf(y11Var4.getNumber()), bool2);
        c0508Sy6.s(String.valueOf(y11Var5.getNumber()), bool2);
        c0508Sy6.s(String.valueOf(y11Var7.getNumber()), bool2);
        c0508Sy6.s(String.valueOf(y11Var8.getNumber()), bool);
        c0508Sy6.s(String.valueOf(y11Var9.getNumber()), bool2);
        I = c0508Sy6;
        C0508Sy c0508Sy7 = new C0508Sy();
        c0508Sy7.s(String.valueOf(y11Var.getNumber()), bool2);
        c0508Sy7.s(String.valueOf(y11Var4.getNumber()), bool2);
        c0508Sy7.s(String.valueOf(y11Var5.getNumber()), bool2);
        c0508Sy7.s(String.valueOf(y11Var7.getNumber()), bool2);
        c0508Sy7.s(String.valueOf(y11Var8.getNumber()), bool2);
        c0508Sy7.s(String.valueOf(y11Var9.getNumber()), bool2);
        J = c0508Sy7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long H0() {
        int i = C3755km.d;
        return ((C3755km) a("gad:signal_collection_timeout_ms", AbstractC4542v10.a(60, EnumC3909mm.e, "gad:signal_collection_timeout_ms"), er.a$26)).a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean M0() {
        return ((Boolean) a("gads:url_encode_scar_ad_response_payload", Boolean.FALSE, er.a$9)).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean O() {
        return ((Boolean) a("gads:enable_stop_api:enabled", Boolean.TRUE, er.a$9)).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean P0() {
        return ((Boolean) a("gads:viewability_activity_lifecycle:enabled", Boolean.TRUE, er.a$9)).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String Q() {
        return (String) a("gads:firebase_analytics_class_name", "com.google.android.gms.measurement.api.AppMeasurementSdk", wr.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String R() {
        return (String) a("gads_firebase_analytics_url_macro", "%5Bgw_fbsaeid%5D", wr.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long Y() {
        int i = C3755km.d;
        return ((C3755km) a("gads:immersive_video_media_data_timeout_ms", AbstractC4542v10.a(5, EnumC3909mm.e, "gads:immersive_video_media_data_timeout_ms"), er.a$26)).a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean a0() {
        return ((Boolean) a("gads:inspector:enabled", Boolean.TRUE, er.a$9)).booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long p() {
        int i = C3755km.d;
        return ((C3755km) a("gads:adapter_initialization:timeout", AbstractC4542v10.a(30, EnumC3909mm.e, "gads:adapter_initialization:timeout"), er.a$28)).a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String s() {
        String encodeToString = Base64.encodeToString(new byte[]{0, 19, -48, -88, -79}, 0);
        AbstractC4766xx.o(encodeToString, "encodeToString(...)");
        return (String) a("gads:blob_encryption_public_key_first_hashed_bytes", encodeToString, wr.a);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ex0(Nc0 nc0, C3554i60 c3554i60, I80 i80, C4742xb0 c4742xb0, F50 f50, Zc0 zc0) {
        super(zc0);
        AbstractC4766xx.p(nc0, "consentFlags");
        AbstractC4766xx.p(c3554i60, "sdkCoreFlags");
        AbstractC4766xx.p(i80, "safeAreaFlags");
        AbstractC4766xx.p(c4742xb0, "adShieldFlags");
        AbstractC4766xx.p(f50, "persistentCacheFlags");
        AbstractC4766xx.p(zc0, "flagValueProvider");
        this.r = nc0;
        this.s = c3554i60;
        this.t = i80;
        this.u = c4742xb0;
        this.v = f50;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Object a(ex0 ex0Var, InterfaceC0231Ig interfaceC0231Ig, InterfaceC0490Sg interfaceC0490Sg, InterfaceC4441tg interfaceC4441tg) {
        bx0 bx0Var;
        int i;
        Boolean bool;
        Double d;
        double d2;
        Integer num;
        int i2;
        if (interfaceC4441tg instanceof bx0) {
            bx0Var = (bx0) interfaceC4441tg;
            int i3 = bx0Var.d;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                bx0Var.d = i3 - Integer.MIN_VALUE;
                Object obj = bx0Var.b;
                EnumC0516Tg enumC0516Tg = EnumC0516Tg.a;
                i = bx0Var.d;
                YY yy = YY.a;
                boolean z2 = true;
                if (i == 0) {
                    if (i == 1) {
                        ex0Var = bx0Var.a;
                        AbstractC3354fY.n0(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    AbstractC3354fY.n0(obj);
                    Zc0 zc0 = (Zc0) ex0Var.a;
                    bx0Var.a = ex0Var;
                    bx0Var.d = 1;
                    yw0 yw0Var = (yw0) zc0;
                    yw0Var.getClass();
                    Object b0 = AbstractC4766xx.b0(interfaceC0231Ig, new gj(yw0Var, interfaceC0490Sg, (InterfaceC4441tg) null), bx0Var);
                    if (b0 != enumC0516Tg) {
                        b0 = yy;
                    }
                    if (b0 == enumC0516Tg) {
                        return enumC0516Tg;
                    }
                }
                bool = (Boolean) ((yw0) ((Zc0) ex0Var.a)).a("gads:csrb:enabled", er.a$9);
                if (bool != null) {
                    z2 = bool.booleanValue();
                }
                ex0Var.w = z2;
                er erVar = er.a$2;
                Zc0 zc02 = (Zc0) ex0Var.a;
                d = (Double) ((yw0) zc02).a("gads:csrb_abtest_enabled:ratio", erVar);
                if (d == null) {
                    d2 = d.doubleValue();
                } else {
                    d2 = 0.0d;
                }
                ex0Var.x = d2;
                num = (Integer) ((yw0) zc02).a("gads:csrb_break_glass_mode", er.a$3);
                if (num == null) {
                    i2 = num.intValue();
                } else {
                    i2 = 0;
                }
                ex0Var.y = i2;
                return yy;
            }
        }
        bx0Var = new bx0(ex0Var, interfaceC4441tg);
        Object obj2 = bx0Var.b;
        EnumC0516Tg enumC0516Tg2 = EnumC0516Tg.a;
        i = bx0Var.d;
        YY yy2 = YY.a;
        boolean z22 = true;
        if (i == 0) {
        }
        bool = (Boolean) ((yw0) ((Zc0) ex0Var.a)).a("gads:csrb:enabled", er.a$9);
        if (bool != null) {
        }
        ex0Var.w = z22;
        er erVar2 = er.a$2;
        Zc0 zc022 = (Zc0) ex0Var.a;
        d = (Double) ((yw0) zc022).a("gads:csrb_abtest_enabled:ratio", erVar2);
        if (d == null) {
        }
        ex0Var.x = d2;
        num = (Integer) ((yw0) zc022).a("gads:csrb_break_glass_mode", er.a$3);
        if (num == null) {
        }
        ex0Var.y = i2;
        return yy2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long C() {
        return ((C3755km) a("gads:http_url_connection_factory:timeout_millis", new C3755km(z), er.a$26)).a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Map n0() {
        return (Map) a("gads:per_trace_sample_rate", AbstractC4331sD.T(new JI(String.valueOf(s11.CUI_NAME_SIGNAL.getNumber()), Double.valueOf(0.003d)), new JI(String.valueOf(s11.CUI_NAME_SIGNAL_UPDATE_SIGNALS.getNumber()), Double.valueOf(3.0E-4d)), new JI(String.valueOf(s11.CUI_NAME_ADREQUEST.getNumber()), Double.valueOf(0.1d)), new JI(String.valueOf(s11.CUI_NAME_SDKINIT_SDKCORE.getNumber()), Double.valueOf(0.1d)), new JI(String.valueOf(s11.CUI_NAME_WEBVIEW_INITIALIZATION.getNumber()), Double.valueOf(0.1d)), new JI(String.valueOf(s11.CUI_NAME_WEBVIEW_LOAD.getNumber()), Double.valueOf(0.1d)), new JI(String.valueOf(s11.CUI_NAME_INSTALL_REFERRER_DETAILS.getNumber()), Double.valueOf(1.0d)), new JI(String.valueOf(s11.CUI_NAME_INSTALL_REFERRER_TASK.getNumber()), Double.valueOf(1.0d)), new JI(String.valueOf(s11.CUI_NAME_POST_CLICK_LIFECYCLE_MONITORING.getNumber()), Double.valueOf(1.0d)), new JI(String.valueOf(s11.CUI_NAME_HSDP_SERVICE.getNumber()), Double.valueOf(1.0d)), new JI(String.valueOf(s11.CUI_NAME_AD_INSPECTOR_DISABLED.getNumber()), Double.valueOf(1.0d)), new JI(String.valueOf(s11.CUI_NAME_AD_INSPECTOR_GLOBAL_ALLOWLIST_OVERRIDE.getNumber()), Double.valueOf(1.0d))), er.a$16);
    }
}
