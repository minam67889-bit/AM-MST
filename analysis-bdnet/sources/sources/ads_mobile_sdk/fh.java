package ads_mobile_sdk;

import ads_mobile_sdk.vz0;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.Hc0;
import defpackage.InterfaceC3823ld0;
import defpackage.InterfaceC4054od0;
import defpackage.Uc0;
import java.util.Objects;

/* loaded from: classes.dex */
public final class fh extends vz0 {
    public static final int A = 29;
    public static final int A0 = 96;
    public static final int B = 31;
    public static final int B0 = 82;
    public static final int C = 32;
    public static final int C0 = 83;
    public static final int D = 33;
    public static final int D0 = 84;
    private static final fh DEFAULT_INSTANCE;
    public static final int E = 34;
    public static final int E0 = 85;
    public static final int F = 35;
    public static final int F0 = 86;
    public static final int G = 36;
    public static final int G0 = 87;
    public static final int H = 37;
    public static final int H0 = 97;
    public static final int I = 38;
    public static final int I0 = 88;
    public static final int J = 39;
    public static final int J0 = 89;
    public static final int K = 40;
    public static final int K0 = 103;
    public static final int L = 41;
    public static final int L0 = 90;
    public static final int M = 42;
    public static final int M0 = 91;
    public static final int N = 44;
    public static final int N0 = 92;
    public static final int O = 45;
    public static final int O0 = 93;
    public static final int P = 46;
    public static final int P0 = 94;
    public static final int Q = 47;
    public static final int Q0 = 98;
    public static final int R = 74;
    public static final int R0 = 99;
    public static final int S = 48;
    public static final int S0 = 100;
    public static final int T = 49;
    public static final int T0 = 101;
    public static final int U = 51;
    public static final int U0 = 102;
    public static final int V = 52;
    public static final int V0 = 104;
    public static final int W = 53;
    public static final int W0 = 105;
    public static final int X = 54;
    public static final int X0 = 21;
    public static final int Y = 55;
    public static final int Y0 = 24;
    public static final int Z = 56;
    public static final int Z0 = 26;
    public static final int a0 = 50;
    public static final int a1 = 28;
    public static final int b0 = 43;
    public static final int b1 = 30;
    public static final int c = 1;
    public static final int c0 = 57;
    public static final int c1 = 25;
    public static final int d = 2;
    public static final int d0 = 58;
    public static final int d1 = 201;
    public static final int e = 3;
    public static final int e0 = 59;
    public static final int e1 = 301;
    public static final int f = 4;
    public static final int f0 = 60;
    public static final int f1 = 302;
    public static final int g = 5;
    public static final int g0 = 61;
    public static final int g1 = 106;
    public static final int h = 6;
    public static final int h0 = 71;
    public static final int h1 = 107;
    public static final int i = 7;
    public static final int i0 = 72;
    public static final int i1 = 108;
    public static final int j = 8;
    public static final int j0 = 62;
    public static final int j1 = 109;
    public static final int k = 9;
    public static final int k0 = 63;
    public static final int k1 = 110;
    public static final int l = 10;
    public static final int l0 = 67;
    public static final int l1 = 111;
    public static final int m = 11;
    public static final int m0 = 64;
    public static final int n = 12;
    public static final int n0 = 65;
    public static final int o = 13;
    public static final int o0 = 66;
    public static final int p = 14;
    public static final int p0 = 95;
    public static final int q = 15;
    public static final int q0 = 68;
    public static final int r = 16;
    public static final int r0 = 69;
    public static final int s = 17;
    public static final int s0 = 70;
    public static final int t = 18;
    public static final int t0 = 73;
    public static final int u = 19;
    public static final int u0 = 76;
    public static final int v = 20;
    public static final int v0 = 77;
    public static final int w = 22;
    public static final int w0 = 78;
    public static final int x = 23;
    public static final int x0 = 79;
    public static final int y = 27;
    public static final int y0 = 80;
    public static final int z = 75;
    public static final int z0 = 81;
    private long actSignal_;
    private long acxSignal_;
    private long acySignal_;
    private long aczSignal_;
    private hh adAttestationSignal_;
    private long attSignal_;
    private long atvSignal_;
    private int bitField0_;
    private int bitField1_;
    private int bitField2_;
    private int bitField3_;
    private long btlSignal_;
    private long btsSignal_;
    private int debuggerStateSignal_;
    private boolean didOptOut_;
    private int encryptionMethod_;
    private long evtTime_;
    private int fallbackSignalsType_;
    private jg hwInfo_;
    private lg inputEvent_;
    private boolean iomSignal_;
    private long jbkSignal_;
    private ng keyEvent_;
    private long keyId_;
    private long lastKnownDeviceTrustworthiness_;
    private long lastKnownHumannessScore_;
    private int mpSignal_;
    private int navigationTriggerType_;
    private long netSignal_;
    private int niSignal_;
    private long ornSignal_;
    private int protoName_;
    private long psnSignal_;
    private xh rawAdAttestationSignal_;
    private long reqType_;
    private zh requestData_;
    private yg screenInfo_;
    private ah soundInfoSignal_;
    private long swzSignal_;
    private long tctSignal_;
    private long tcxSignal_;
    private long tcySignal_;
    private ch touch_;
    private long uhSignal_;
    private long uptSignal_;
    private long usgSignal_;
    private long utzSignal_;
    private long uwSignal_;
    private long vcdSignal_;
    private long visSignal_;
    private eh visibilitySignal_;
    private int activeExperimentIdsMemoizedSerializedSize = -1;
    private String osVersion_ = "";
    private String afmaVersion_ = "";
    private String stkSignal_ = "";
    private String intSignal_ = "";
    private String midSignal_ = "D";
    private String cerSignal_ = "";
    private String vnmSignal_ = "";
    private long tcpSignal_ = -1;
    private long tcdSignal_ = -1;
    private long tcuSignal_ = -1;
    private long tcmSignal_ = -1;
    private long tcdnSignal_ = -1;
    private long tccSignal_ = -1;
    private long cpuSignal_ = -1;
    private long stkDepthSignal_ = -1;
    private String appIdSignal_ = "D";
    private String installerSignal_ = "D";
    private long timeSinceInstallMinutes_ = -1;
    private int usbConnectedSignal_ = 1000;
    private int adbEnabledSignal_ = 1000;
    private long deviceElapsedRealTimeSignal_ = -1;
    private long deviceUptimeSignal_ = -1;
    private long timeOnScreenMs_ = -1;
    private long percentAdOnScreen_ = -1;
    private long percentScreenCoveredByAd_ = -1;
    private int isNativeViewPerformclickMissing_ = 1000;
    private InterfaceC4054od0 previousTouches_ = bw2.e();
    private long gmscoreVersionSignal_ = -1;
    private long batteryTemperatureSignal_ = -1;
    private long processImportanceSignal_ = -1;
    private long screenStateSignal_ = -1;
    private long recentForegroundTimeSignal_ = -1;
    private long totalForegroundTimeSignal_ = -1;
    private long activityIntentSignal_ = -1;
    private long activityStackSizeSignal_ = -1;
    private String activityNameSignal_ = "D";
    private long pkgNameDetailSignal_ = -1;
    private long attitudeSignal_ = -1;
    private int proxyDetectedSignal_ = 1000;
    private int launcherActivityEnabled_ = 1000;
    private String sftnIdSignal_ = "D";
    private InterfaceC4054od0 resetCounters_ = bw2.e();
    private int vpnSignal_ = 1000;
    private InterfaceC4054od0 functionDenylistSignal_ = bw2.e();
    private String deviceModelSignal_ = "";
    private long timeSinceVpnOnMs_ = -1;
    private long adeventToVpnOffMs_ = -1;
    private long impressionDurationMs_ = -1;
    private long impressionDurationHighAttentionMs_ = -1;
    private long virtualIntegrityType_ = -1;
    private String adshieldVersion_ = "";
    private long lastKnownTrustDecisionLabel_ = -1;
    private long bootCountSignal_ = -1;
    private String lccSignal_ = "";
    private String llcSignal_ = "";
    private long ratSignal_ = -1;
    private long pmSignal_ = -1;
    private String didSignal_ = "";
    private int didSignalType_ = 2;
    private String didSignalAndroidAdId_ = "";
    private long experimentalInt64Signal_ = -1;
    private String experimentalStringSignal_ = "";
    private InterfaceC3823ld0 activeExperimentIds_ = xh1.e();
    private long clsSignal_ = -1;
    private int isLauncherSignal_ = 1000;
    private int iosomSignal_ = 1000;
    private String sccSignal_ = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        fh fhVar = new fh();
        DEFAULT_INSTANCE = fhVar;
        vz0.a((Class<fh>) fh.class, fhVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c(String str) {
        Objects.requireNonNull(str);
        this.bitField2_ |= 262144;
        this.adshieldVersion_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void h(String str) {
        Objects.requireNonNull(str);
        this.bitField1_ |= UserVerificationMethods.USER_VERIFY_HANDPRINT;
        this.installerSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static fh a(byte[] bArr, er0 er0Var) {
        return (fh) vz0.a(DEFAULT_INSTANCE, bArr, er0Var);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(ch chVar) {
        this.touch_ = chVar;
        this.bitField1_ |= 262144;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Uc0 D() {
        return (Uc0) DEFAULT_INSTANCE.h();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean A() {
        return (this.bitField1_ & 1048576) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean B() {
        return (this.bitField0_ & 524288) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean C() {
        return (this.bitField3_ & 64) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // ads_mobile_sdk.vz0
    public final Object a(vz0.d dVar, vz0 vz0Var) {
        int i2 = Hc0.a[dVar.ordinal()];
        if (i2 == 1) {
            return new fh();
        }
        if (i2 == 2) {
            return new Uc0(DEFAULT_INSTANCE);
        }
        if (i2 == 3) {
            cg cgVar = cg.a;
            cg cgVar2 = cg.a$26;
            return new i13(DEFAULT_INSTANCE, "\u0001r\u0000\u0004\u0001Įr\u0000\u0004\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ`\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈa\u0019ဂe\u001a᠌b\u001bဈ\u0016\u001cဇc\u001dဈ\u0018\u001eဈd\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌AEဉBFဂCGဂ8Hဂ9I᠌DJဂ)Kဈ\u0017L᠌EMဈFN\u001bO᠌GP\u001bQဉHRဈJSဂKTဂLUဂMVဂNWဂOXဂQYဈRZဉT[ဉU\\ဂV]ဂW^᠌X_᠌@`ဉIaဂPbဈYcဈZdဂ[eဂ\\f᠌]gဂShဉ^iဇ_j'kဂil᠌jm᠌kn᠌loဈmÉဉfĭဂgĮဈh", new Object[]{"bitField0_", "bitField1_", "bitField2_", "bitField3_", "osVersion_", "afmaVersion_", "atvSignal_", "attSignal_", "btsSignal_", "btlSignal_", "acxSignal_", "acySignal_", "aczSignal_", "actSignal_", "netSignal_", "ornSignal_", "stkSignal_", "tcxSignal_", "tcySignal_", "tctSignal_", "uptSignal_", "visSignal_", "swzSignal_", "psnSignal_", "reqType_", "jbkSignal_", "usgSignal_", "didSignal_", "evtTime_", "didSignalType_", cgVar, "intSignal_", "didOptOut_", "cerSignal_", "didSignalAndroidAdId_", "uwSignal_", "uhSignal_", "utzSignal_", "vnmSignal_", "vcdSignal_", "tcpSignal_", "tcdSignal_", "adAttestationSignal_", "tcuSignal_", "tcmSignal_", "tcdnSignal_", "tccSignal_", "previousTouches_", ch.class, "cpuSignal_", "stkDepthSignal_", "appIdSignal_", "installerSignal_", "usbConnectedSignal_", cgVar2, "adbEnabledSignal_", cgVar2, "touch_", "deviceElapsedRealTimeSignal_", "deviceUptimeSignal_", "timeOnScreenMs_", "percentAdOnScreen_", "percentScreenCoveredByAd_", "isNativeViewPerformclickMissing_", cgVar2, "visibilitySignal_", "gmscoreVersionSignal_", "batteryTemperatureSignal_", "processImportanceSignal_", "screenStateSignal_", "activityIntentSignal_", "activityStackSizeSignal_", "pkgNameDetailSignal_", "encryptionMethod_", cg.a$21, "protoName_", sw.a$3, "activityNameSignal_", "debuggerStateSignal_", sw.a$10, "requestData_", "attitudeSignal_", "recentForegroundTimeSignal_", "totalForegroundTimeSignal_", "proxyDetectedSignal_", cgVar2, "timeSinceInstallMinutes_", "midSignal_", "launcherActivityEnabled_", cgVar2, "sftnIdSignal_", "resetCounters_", wg.class, "vpnSignal_", cgVar2, "functionDenylistSignal_", bg.class, "soundInfoSignal_", "deviceModelSignal_", "timeSinceVpnOnMs_", "adeventToVpnOffMs_", "impressionDurationMs_", "impressionDurationHighAttentionMs_", "lastKnownDeviceTrustworthiness_", "virtualIntegrityType_", "adshieldVersion_", "inputEvent_", "keyEvent_", "lastKnownTrustDecisionLabel_", "bootCountSignal_", "navigationTriggerType_", cg.a$25, "fallbackSignalsType_", cg.a$6, "screenInfo_", "lastKnownHumannessScore_", "lccSignal_", "llcSignal_", "ratSignal_", "pmSignal_", "niSignal_", cg.a$28, "keyId_", "hwInfo_", "iomSignal_", "activeExperimentIds_", "clsSignal_", "isLauncherSignal_", cgVar2, "iosomSignal_", cgVar2, "mpSignal_", cg.a$20, "sccSignal_", "rawAdAttestationSignal_", "experimentalInt64Signal_", "experimentalStringSignal_"});
        }
        if (i2 == 4) {
            return DEFAULT_INSTANCE;
        }
        if (i2 != 5) {
            return null;
        }
        return vz0.b(fh.class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(String str) {
        Objects.requireNonNull(str);
        this.bitField1_ |= 268435456;
        this.activityNameSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(String str) {
        Objects.requireNonNull(str);
        this.bitField0_ |= 2;
        this.afmaVersion_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e(String str) {
        Objects.requireNonNull(str);
        this.bitField1_ |= UserVerificationMethods.USER_VERIFY_PATTERN;
        this.appIdSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f(String str) {
        Objects.requireNonNull(str);
        this.bitField0_ |= 16777216;
        this.cerSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void g(String str) {
        Objects.requireNonNull(str);
        this.bitField2_ |= UserVerificationMethods.USER_VERIFY_ALL;
        this.deviceModelSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void i(String str) {
        Objects.requireNonNull(str);
        this.bitField0_ |= 4194304;
        this.intSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void j(String str) {
        Objects.requireNonNull(str);
        this.bitField0_ |= 1;
        this.osVersion_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void k(String str) {
        Objects.requireNonNull(str);
        this.bitField0_ |= 268435456;
        this.vnmSignal_ = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long v() {
        return this.gmscoreVersionSignal_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String w() {
        return this.intSignal_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long x() {
        return this.psnSignal_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final xh y() {
        xh xhVar;
        xh xhVar2 = this.rawAdAttestationSignal_;
        if (xhVar2 != null) {
            return xhVar2;
        }
        xhVar = xh.DEFAULT_INSTANCE;
        return xhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long z() {
        return this.recentForegroundTimeSignal_;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(ch chVar) {
        AbstractC0755i abstractC0755i = (AbstractC0755i) this.previousTouches_;
        if (!abstractC0755i.b()) {
            this.previousTouches_ = abstractC0755i.a(abstractC0755i.size() * 2);
        }
        this.previousTouches_.add(chVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(eh ehVar) {
        this.visibilitySignal_ = ehVar;
        this.bitField1_ |= 524288;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(lg lgVar) {
        this.inputEvent_ = lgVar;
        this.bitField2_ |= 1048576;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(xh xhVar) {
        Objects.requireNonNull(xhVar);
        this.rawAdAttestationSignal_ = xhVar;
        this.bitField3_ |= 64;
    }
}
