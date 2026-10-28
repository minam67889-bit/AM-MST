package ads_mobile_sdk;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.C3627j50;
import defpackage.T60;
import defpackage.Uc0;
import java.lang.reflect.Method;
import java.util.Map;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class oa3 extends jj3 {
    public final Object f;
    public final Object g;
    public final Map h;
    public final /* synthetic */ int l = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public oa3(Uc0 uc0, zw1 zw1Var, fl3 fl3Var, Context context, Map map, ts3 ts3Var) {
        super("JOzC6/ZgCwSvEVJCUSvoCbmKtBo3jCGU50ZjBIYBqYyjn6f8szB9X4gQSZiZdGxW", "WNDs4S5wyhYtg4w6BjmRCnxPTCgBBdruB89hqkSRK58=", uc0, zw1Var, ts3Var.a(lq0.EVENT_ID_SCREEN_SIGNALS_TASK));
        this.f = fl3Var;
        this.g = context;
        this.h = map;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(C3627j50 c3627j50) {
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Map map = this.h;
        zc1 zc1Var = (zc1) map.get("oe");
        if (zc1Var == null || zc1Var.a == 0 || (displayMetrics = (DisplayMetrics) this.g) == null) {
            return;
        }
        float f = displayMetrics.density;
        if (f != 0.0f) {
            long round = Math.round(zc1Var.g / f);
            c3627j50.d$3();
            ch chVar = (ch) c3627j50.b;
            i = chVar.bitField0_;
            chVar.bitField0_ = i | 4096;
            chVar.pathDistanceSignal_ = round;
            long round2 = Math.round((zc1Var.j - zc1Var.h) / displayMetrics.density);
            c3627j50.d$3();
            ch chVar2 = (ch) c3627j50.b;
            i2 = chVar2.bitField0_;
            chVar2.bitField0_ = i2 | JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE;
            chVar2.viewXSignal_ = round2;
            long round3 = Math.round((zc1Var.k - zc1Var.i) / displayMetrics.density);
            c3627j50.d$3();
            ch chVar3 = (ch) c3627j50.b;
            i3 = chVar3.bitField0_;
            chVar3.bitField0_ = i3 | 16384;
            chVar3.viewYSignal_ = round3;
            long round4 = Math.round(zc1Var.h / displayMetrics.density);
            c3627j50.d$3();
            ch chVar4 = (ch) c3627j50.b;
            i4 = chVar4.bitField0_;
            chVar4.bitField0_ = i4 | 131072;
            chVar4.tcxDownSignal_ = round4;
            long round5 = Math.round(zc1Var.i / displayMetrics.density);
            c3627j50.d$3();
            ch chVar5 = (ch) c3627j50.b;
            i5 = chVar5.bitField0_;
            chVar5.bitField0_ = i5 | 262144;
            chVar5.tcyDownSignal_ = round5;
            if (((MotionEvent) map.get("nv")) == null) {
                return;
            }
            long round6 = Math.round(((r0.getRawX() + (zc1Var.h - zc1Var.j)) - r0.getX()) / displayMetrics.density);
            if (round6 != 0) {
                c3627j50.d$3();
                ch chVar6 = (ch) c3627j50.b;
                i7 = chVar6.bitField0_;
                chVar6.bitField0_ = i7 | 32768;
                chVar6.viewDxSignal_ = round6;
            }
            long round7 = Math.round(((r0.getRawY() + (zc1Var.i - zc1Var.k)) - r0.getY()) / displayMetrics.density);
            if (round7 != 0) {
                c3627j50.d$3();
                ch chVar7 = (ch) c3627j50.b;
                i6 = chVar7.bitField0_;
                chVar7.bitField0_ = i6 | 65536;
                chVar7.viewDySignal_ = round7;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(Uc0 uc0) {
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        ad1[] ad1VarArr = (ad1[]) this.h.get("ro");
        if (ad1VarArr != null && (displayMetrics = (DisplayMetrics) this.g) != null && displayMetrics.density != 0.0f) {
            for (int i3 = 0; i3 <= ad1VarArr.length - 2; i3++) {
                ad1 ad1Var = ad1VarArr[i3];
                C3627j50 v = ch.v();
                long round = Math.round(ad1Var.a / displayMetrics.density);
                v.d$3();
                ch chVar = (ch) v.b;
                i = chVar.bitField0_;
                chVar.bitField0_ = i | 1;
                chVar.tcxSignal_ = round;
                long round2 = Math.round(ad1Var.b / displayMetrics.density);
                v.d$3();
                ch chVar2 = (ch) v.b;
                i2 = chVar2.bitField0_;
                chVar2.bitField0_ = i2 | 2;
                chVar2.tcySignal_ = round2;
                ch chVar3 = (ch) v.b();
                uc0.d$3();
                ((fh) uc0.b).a(chVar3);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public oa3(Uc0 uc0, zw1 zw1Var, Map map, DisplayMetrics displayMetrics, ts3 ts3Var) {
        super("wIGOLfnk1nzTsp6li7k0BsIlCG7uMPqg0o75hlXQhc8b+SsFCnmi/DiYWcMC2l6c", "GnZ/3TJK6yLIUnfdHCU3GsIzeXoNAV7fJenlMCT7Qj4=", uc0, zw1Var, ts3Var.a(lq0.EVENT_ID_TOUCH_SIGNALS_TASK));
        this.f = zw1Var;
        this.h = map;
        this.g = displayMetrics;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // ads_mobile_sdk.jj3
    public final void a(Method method, Uc0 uc0) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        switch (this.l) {
            case 0:
                Integer valueOf = Integer.valueOf(((fl3) this.f).ordinal());
                Context context = (Context) this.g;
                Object obj = this.h.get("up");
                Boolean bool = Boolean.TRUE;
                if (obj == null) {
                    obj = bool;
                }
                Object[] objArr = (Object[]) method.invoke("", valueOf, context, obj);
                objArr.getClass();
                synchronized (uc0) {
                    try {
                        if (((fl3) this.f) == fl3.a) {
                            Object obj2 = objArr[0];
                            if (obj2 == null) {
                                obj2 = -1L;
                            }
                            long longValue = ((Long) obj2).longValue();
                            uc0.d$3();
                            fh fhVar = (fh) uc0.b;
                            i3 = fhVar.bitField0_;
                            fhVar.bitField0_ = i3 | 33554432;
                            fhVar.uwSignal_ = longValue;
                            Object obj3 = objArr[1];
                            if (obj3 == null) {
                                obj3 = -1L;
                            }
                            long longValue2 = ((Long) obj3).longValue();
                            uc0.d$3();
                            fh fhVar2 = (fh) uc0.b;
                            i4 = fhVar2.bitField0_;
                            fhVar2.bitField0_ = i4 | 67108864;
                            fhVar2.uhSignal_ = longValue2;
                        }
                        long longValue3 = ((Long) objArr[2]).longValue();
                        uc0.d$3();
                        fh fhVar3 = (fh) uc0.b;
                        i = fhVar3.bitField0_;
                        fhVar3.bitField0_ = i | 2048;
                        fhVar3.ornSignal_ = longValue3;
                        long longValue4 = ((Long) objArr[3]).longValue();
                        uc0.d$3();
                        fh fhVar4 = (fh) uc0.b;
                        i2 = fhVar4.bitField1_;
                        fhVar4.bitField1_ = i2 | 8388608;
                        fhVar4.screenStateSignal_ = longValue4;
                    } finally {
                    }
                }
                return;
            default:
                MotionEvent motionEvent = (MotionEvent) this.h.get("nv");
                try {
                    Object[] objArr2 = (Object[]) method.invoke("", motionEvent, (DisplayMetrics) this.g);
                    objArr2.getClass();
                    C3627j50 v = ch.v();
                    Object obj4 = objArr2[0];
                    if (obj4 != null && objArr2[1] != null) {
                        long longValue5 = ((Long) obj4).longValue();
                        v.d$3();
                        ch chVar = (ch) v.b;
                        i16 = chVar.bitField0_;
                        chVar.bitField0_ = i16 | 1;
                        chVar.tcxSignal_ = longValue5;
                        long longValue6 = ((Long) objArr2[1]).longValue();
                        v.d$3();
                        ch chVar2 = (ch) v.b;
                        i17 = chVar2.bitField0_;
                        chVar2.bitField0_ = i17 | 2;
                        chVar2.tcySignal_ = longValue6;
                    }
                    Object obj5 = objArr2[2];
                    if (obj5 != null) {
                        long longValue7 = ((Long) obj5).longValue();
                        v.d$3();
                        ch chVar3 = (ch) v.b;
                        i15 = chVar3.bitField0_;
                        chVar3.bitField0_ = i15 | UserVerificationMethods.USER_VERIFY_PATTERN;
                        chVar3.tctMs_ = longValue7;
                    }
                    Object obj6 = objArr2[3];
                    if (obj6 != null) {
                        long longValue8 = ((Long) obj6).longValue();
                        v.d$3();
                        ch chVar4 = (ch) v.b;
                        i14 = chVar4.bitField0_;
                        chVar4.bitField0_ = i14 | 16;
                        chVar4.tcp_ = longValue8;
                    }
                    Object obj7 = objArr2[4];
                    if (obj7 != null) {
                        long longValue9 = ((Long) obj7).longValue();
                        v.d$3();
                        ch chVar5 = (ch) v.b;
                        i13 = chVar5.bitField0_;
                        chVar5.bitField0_ = i13 | 4;
                        chVar5.tcd_ = longValue9;
                    }
                    Object obj8 = objArr2[5];
                    if (obj8 != null) {
                        int i18 = ((Long) obj8).longValue() != 0 ? 2 : 1;
                        v.d$3();
                        ch chVar6 = (ch) v.b;
                        chVar6.getClass();
                        chVar6.obscured_ = T60.e(i18);
                        i12 = chVar6.bitField0_;
                        chVar6.bitField0_ = i12 | 64;
                    }
                    Object obj9 = objArr2[6];
                    if (obj9 != null) {
                        long longValue10 = ((Long) obj9).longValue();
                        v.d$3();
                        ch chVar7 = (ch) v.b;
                        i11 = chVar7.bitField0_;
                        chVar7.bitField0_ = i11 | UserVerificationMethods.USER_VERIFY_NONE;
                        chVar7.source_ = longValue10;
                    }
                    Object obj10 = objArr2[7];
                    if (obj10 != null) {
                        long longValue11 = ((Long) obj10).longValue();
                        v.d$3();
                        ch chVar8 = (ch) v.b;
                        i10 = chVar8.bitField0_;
                        chVar8.bitField0_ = i10 | UserVerificationMethods.USER_VERIFY_HANDPRINT;
                        chVar8.toolType_ = longValue11;
                    }
                    Object obj11 = objArr2[8];
                    if (obj11 != null) {
                        int i19 = ((Long) obj11).longValue() != 0 ? 2 : 1;
                        v.d$3();
                        ch chVar9 = (ch) v.b;
                        chVar9.getClass();
                        chVar9.isPhysicalTouch_ = T60.e(i19);
                        i9 = chVar9.bitField0_;
                        chVar9.bitField0_ = i9 | UserVerificationMethods.USER_VERIFY_ALL;
                    }
                    synchronized (uc0) {
                        a(uc0);
                        zc1 zc1Var = (zc1) this.h.get("oe");
                        if (zc1Var != null) {
                            long j = zc1Var.a;
                            if (j > 0) {
                                uc0.d$3();
                                fh fhVar5 = (fh) uc0.b;
                                i8 = fhVar5.bitField1_;
                                fhVar5.bitField1_ = 8 | i8;
                                fhVar5.tcdnSignal_ = j;
                            }
                            long j2 = zc1Var.b;
                            if (j2 > 0) {
                                uc0.d$3();
                                fh fhVar6 = (fh) uc0.b;
                                i7 = fhVar6.bitField1_;
                                fhVar6.bitField1_ = 4 | i7;
                                fhVar6.tcmSignal_ = j2;
                            }
                            long j3 = zc1Var.c;
                            if (j3 > 0) {
                                uc0.d$3();
                                fh fhVar7 = (fh) uc0.b;
                                i6 = fhVar7.bitField1_;
                                fhVar7.bitField1_ = 2 | i6;
                                fhVar7.tcuSignal_ = j3;
                            }
                            long j4 = zc1Var.d;
                            if (j4 > 0) {
                                uc0.d$3();
                                fh fhVar8 = (fh) uc0.b;
                                i5 = fhVar8.bitField1_;
                                fhVar8.bitField1_ = i5 | 16;
                                fhVar8.tccSignal_ = j4;
                            }
                        }
                        a(v);
                        uc0.d$3();
                        ((fh) uc0.b).b((ch) v.b());
                        b(uc0);
                    }
                    if (motionEvent != null) {
                        motionEvent.recycle();
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    if (motionEvent != null) {
                        motionEvent.recycle();
                    }
                    throw th;
                }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a(Uc0 uc0) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Method a = ((zw1) this.f).a("ptkaUVDTLfNqaGRtRIraqNrTprMtGmt3IzCNSoNMVOfIZ9Ss/9Vh6PY9L+QVC4mg", "knYhVkDhcPjoxZ4MXCS3A9MdUHLgzvVXsVl0JJ2BOEQ=");
        a.getClass();
        Object[] objArr = (Object[]) a.invoke("", (MotionEvent) this.h.get("nv"), (DisplayMetrics) this.g);
        objArr.getClass();
        Object obj = objArr[0];
        if (obj != null) {
            long longValue = ((Long) obj).longValue();
            uc0.d$3();
            fh fhVar = (fh) uc0.b;
            i5 = fhVar.bitField0_;
            fhVar.bitField0_ = i5 | JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE;
            fhVar.tcxSignal_ = longValue;
        }
        Object obj2 = objArr[1];
        if (obj2 != null) {
            long longValue2 = ((Long) obj2).longValue();
            uc0.d$3();
            fh fhVar2 = (fh) uc0.b;
            i4 = fhVar2.bitField0_;
            fhVar2.bitField0_ = i4 | 16384;
            fhVar2.tcySignal_ = longValue2;
        }
        Object obj3 = objArr[2];
        if (obj3 != null) {
            long longValue3 = ((Long) obj3).longValue();
            uc0.d$3();
            fh fhVar3 = (fh) uc0.b;
            i3 = fhVar3.bitField0_;
            fhVar3.bitField0_ = i3 | 32768;
            fhVar3.tctSignal_ = longValue3;
        }
        Object obj4 = objArr[3];
        if (obj4 != null) {
            long longValue4 = ((Long) obj4).longValue();
            uc0.d$3();
            fh fhVar4 = (fh) uc0.b;
            i2 = fhVar4.bitField0_;
            fhVar4.bitField0_ = i2 | 1073741824;
            fhVar4.tcpSignal_ = longValue4;
        }
        Object obj5 = objArr[4];
        if (obj5 != null) {
            long longValue5 = ((Long) obj5).longValue();
            uc0.d$3();
            fh fhVar5 = (fh) uc0.b;
            i = fhVar5.bitField0_;
            fhVar5.bitField0_ = i | Integer.MIN_VALUE;
            fhVar5.tcdSignal_ = longValue5;
        }
    }
}
