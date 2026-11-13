package ads_mobile_sdk;

import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.AbstractC4589z20;
import defpackage.InterfaceC2858d80;
import defpackage.InterfaceC3053fd0;
import defpackage.Q70;
import defpackage.Z60;
import java.lang.reflect.Method;
import java.util.Map;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class oc3 extends i43 {
    public final Map f;
    public final InterfaceC3053fd0 g;
    public final DisplayMetrics h;

    public oc3(Z60 z60, InterfaceC3053fd0 interfaceC3053fd0, Map map, DisplayMetrics displayMetrics, pd3 pd3Var) {
        super("Cw5RXZSMI26nw/30vHkKZXhCVSbeu7r1v/PP3NXFsYfYjaZrqhQGj6OxdejSlrC9", "2sii5amj0RPRjj8JmAv2EuC/gfERRRXkZLJ91BUqhqM=", z60, interfaceC3053fd0, pd3Var.a(nk0.EVENT_ID_TOUCH_SIGNALS_TASK));
        this.g = interfaceC3053fd0;
        this.f = map;
        this.h = displayMetrics;
    }

    @Override // ads_mobile_sdk.i43
    public final void a(Method method, Z60 z60) {
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
        MotionEvent motionEvent = (MotionEvent) this.f.get("nv");
        try {
            Object[] objArr = (Object[]) method.invoke("", motionEvent, this.h);
            objArr.getClass();
            Q70 o = fd.o();
            Object obj = objArr[0];
            if (obj != null && objArr[1] != null) {
                long longValue = ((Long) obj).longValue();
                o.b();
                fd fdVar = (fd) o.b;
                i13 = fdVar.bitField0_;
                fdVar.bitField0_ = i13 | 1;
                fdVar.tcxSignal_ = longValue;
                long longValue2 = ((Long) objArr[1]).longValue();
                o.b();
                fd fdVar2 = (fd) o.b;
                i14 = fdVar2.bitField0_;
                fdVar2.bitField0_ = i14 | 2;
                fdVar2.tcySignal_ = longValue2;
            }
            Object obj2 = objArr[2];
            if (obj2 != null) {
                long longValue3 = ((Long) obj2).longValue();
                o.b();
                fd fdVar3 = (fd) o.b;
                i12 = fdVar3.bitField0_;
                fdVar3.bitField0_ = i12 | UserVerificationMethods.USER_VERIFY_PATTERN;
                fdVar3.tctMs_ = longValue3;
            }
            Object obj3 = objArr[3];
            if (obj3 != null) {
                long longValue4 = ((Long) obj3).longValue();
                o.b();
                fd fdVar4 = (fd) o.b;
                i11 = fdVar4.bitField0_;
                fdVar4.bitField0_ = i11 | 16;
                fdVar4.tcp_ = longValue4;
            }
            Object obj4 = objArr[4];
            if (obj4 != null) {
                long longValue5 = ((Long) obj4).longValue();
                o.b();
                fd fdVar5 = (fd) o.b;
                i10 = fdVar5.bitField0_;
                fdVar5.bitField0_ = i10 | 4;
                fdVar5.tcd_ = longValue5;
            }
            Object obj5 = objArr[5];
            if (obj5 != null) {
                ud udVar = ((Long) obj5).longValue() != 0 ? ud.ENUM_TRUE : ud.ENUM_FALSE;
                o.b();
                fd fdVar6 = (fd) o.b;
                fdVar6.getClass();
                fdVar6.obscured_ = udVar.a;
                i9 = fdVar6.bitField0_;
                fdVar6.bitField0_ = i9 | 64;
            }
            Object obj6 = objArr[6];
            if (obj6 != null) {
                long longValue6 = ((Long) obj6).longValue();
                o.b();
                fd fdVar7 = (fd) o.b;
                i8 = fdVar7.bitField0_;
                fdVar7.bitField0_ = i8 | UserVerificationMethods.USER_VERIFY_NONE;
                fdVar7.source_ = longValue6;
            }
            Object obj7 = objArr[7];
            if (obj7 != null) {
                long longValue7 = ((Long) obj7).longValue();
                o.b();
                fd fdVar8 = (fd) o.b;
                i7 = fdVar8.bitField0_;
                fdVar8.bitField0_ = i7 | UserVerificationMethods.USER_VERIFY_HANDPRINT;
                fdVar8.toolType_ = longValue7;
            }
            Object obj8 = objArr[8];
            if (obj8 != null) {
                ud udVar2 = ((Long) obj8).longValue() != 0 ? ud.ENUM_TRUE : ud.ENUM_FALSE;
                o.b();
                fd fdVar9 = (fd) o.b;
                fdVar9.getClass();
                fdVar9.isPhysicalTouch_ = udVar2.a;
                i6 = fdVar9.bitField0_;
                fdVar9.bitField0_ = i6 | UserVerificationMethods.USER_VERIFY_ALL;
            }
            synchronized (z60) {
                a(z60);
                zm1 zm1Var = (zm1) this.f.get("oe");
                if (zm1Var != null) {
                    long j = zm1Var.a;
                    if (j > 0) {
                        z60.b();
                        id idVar = (id) z60.b;
                        i4 = idVar.bitField1_;
                        idVar.bitField1_ = 8 | i4;
                        idVar.tcdnSignal_ = j;
                    }
                    long j2 = zm1Var.b;
                    if (j2 > 0) {
                        z60.b();
                        id idVar2 = (id) z60.b;
                        i3 = idVar2.bitField1_;
                        idVar2.bitField1_ = 4 | i3;
                        idVar2.tcmSignal_ = j2;
                    }
                    long j3 = zm1Var.c;
                    if (j3 > 0) {
                        z60.b();
                        id idVar3 = (id) z60.b;
                        i2 = idVar3.bitField1_;
                        idVar3.bitField1_ = 2 | i2;
                        idVar3.tcuSignal_ = j3;
                    }
                    long j4 = zm1Var.d;
                    if (j4 > 0) {
                        z60.b();
                        id idVar4 = (id) z60.b;
                        i = idVar4.bitField1_;
                        idVar4.bitField1_ = i | 16;
                        idVar4.tccSignal_ = j4;
                    }
                }
                a(o);
                z60.b();
                id idVar5 = (id) z60.b;
                fd fdVar10 = (fd) o.a();
                idVar5.getClass();
                idVar5.touch_ = fdVar10;
                i5 = idVar5.bitField1_;
                idVar5.bitField1_ = i5 | 262144;
                b(z60);
            }
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        } catch (Throwable th) {
            if (motionEvent != null) {
                motionEvent.recycle();
            }
            throw th;
        }
    }

    public final void b(Z60 z60) {
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        InterfaceC2858d80 interfaceC2858d80;
        InterfaceC2858d80 interfaceC2858d802;
        an1[] an1VarArr = (an1[]) this.f.get("ro");
        if (an1VarArr == null || (displayMetrics = this.h) == null || displayMetrics.density == 0.0f) {
            return;
        }
        for (int i3 = 0; i3 <= an1VarArr.length - 2; i3++) {
            an1 an1Var = an1VarArr[i3];
            Q70 o = fd.o();
            double d = an1Var.a;
            this.h.getClass();
            long round = Math.round(d / r6.density);
            o.b();
            fd fdVar = (fd) o.b;
            i = fdVar.bitField0_;
            fdVar.bitField0_ = i | 1;
            fdVar.tcxSignal_ = round;
            double d2 = an1Var.b;
            this.h.getClass();
            long round2 = Math.round(d2 / r2.density);
            o.b();
            fd fdVar2 = (fd) o.b;
            i2 = fdVar2.bitField0_;
            fdVar2.bitField0_ = i2 | 2;
            fdVar2.tcySignal_ = round2;
            fd fdVar3 = (fd) o.a();
            z60.b();
            id idVar = (id) z60.b;
            idVar.getClass();
            interfaceC2858d80 = idVar.previousTouches_;
            if (!((j) interfaceC2858d80).a) {
                idVar.previousTouches_ = AbstractC4589z20.g(interfaceC2858d80);
            }
            interfaceC2858d802 = idVar.previousTouches_;
            interfaceC2858d802.add(fdVar3);
        }
    }

    public final void a(Z60 z60) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        Method a = ((sm1) this.g).a("AK6ST2KxyBSP1PBiUGTwuvJe3J+f290byaKYwMmvvNt+SHBWDHg0rP+RYwCf3lGo", "+oUaclTOUDANSF48EqXQ7RccmwakuvNdSgDlm2HE/oQ=");
        a.getClass();
        Object[] objArr = (Object[]) a.invoke("", (MotionEvent) this.f.get("nv"), this.h);
        objArr.getClass();
        Object obj = objArr[0];
        if (obj != null) {
            long longValue = ((Long) obj).longValue();
            z60.b();
            id idVar = (id) z60.b;
            i5 = idVar.bitField0_;
            idVar.bitField0_ = i5 | JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE;
            idVar.tcxSignal_ = longValue;
        }
        Object obj2 = objArr[1];
        if (obj2 != null) {
            long longValue2 = ((Long) obj2).longValue();
            z60.b();
            id idVar2 = (id) z60.b;
            i4 = idVar2.bitField0_;
            idVar2.bitField0_ = i4 | 16384;
            idVar2.tcySignal_ = longValue2;
        }
        Object obj3 = objArr[2];
        if (obj3 != null) {
            long longValue3 = ((Long) obj3).longValue();
            z60.b();
            id idVar3 = (id) z60.b;
            i3 = idVar3.bitField0_;
            idVar3.bitField0_ = i3 | 32768;
            idVar3.tctSignal_ = longValue3;
        }
        Object obj4 = objArr[3];
        if (obj4 != null) {
            long longValue4 = ((Long) obj4).longValue();
            z60.b();
            id idVar4 = (id) z60.b;
            i2 = idVar4.bitField0_;
            idVar4.bitField0_ = i2 | 1073741824;
            idVar4.tcpSignal_ = longValue4;
        }
        Object obj5 = objArr[4];
        if (obj5 != null) {
            long longValue5 = ((Long) obj5).longValue();
            z60.b();
            id idVar5 = (id) z60.b;
            i = idVar5.bitField0_;
            idVar5.bitField0_ = i | Integer.MIN_VALUE;
            idVar5.tcdSignal_ = longValue5;
        }
    }

    public final void a(Q70 q70) {
        DisplayMetrics displayMetrics;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        zm1 zm1Var = (zm1) this.f.get("oe");
        if (zm1Var == null || zm1Var.a == 0 || (displayMetrics = this.h) == null) {
            return;
        }
        float f = displayMetrics.density;
        if (f != 0.0f) {
            long round = Math.round(zm1Var.g / f);
            q70.b();
            fd fdVar = (fd) q70.b;
            i = fdVar.bitField0_;
            fdVar.bitField0_ = i | 4096;
            fdVar.pathDistanceSignal_ = round;
            long round2 = Math.round((zm1Var.j - zm1Var.h) / this.h.density);
            q70.b();
            fd fdVar2 = (fd) q70.b;
            i2 = fdVar2.bitField0_;
            fdVar2.bitField0_ = i2 | JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE;
            fdVar2.viewXSignal_ = round2;
            long round3 = Math.round((zm1Var.k - zm1Var.i) / this.h.density);
            q70.b();
            fd fdVar3 = (fd) q70.b;
            i3 = fdVar3.bitField0_;
            fdVar3.bitField0_ = i3 | 16384;
            fdVar3.viewYSignal_ = round3;
            long round4 = Math.round(zm1Var.h / this.h.density);
            q70.b();
            fd fdVar4 = (fd) q70.b;
            i4 = fdVar4.bitField0_;
            fdVar4.bitField0_ = i4 | 131072;
            fdVar4.tcxDownSignal_ = round4;
            long round5 = Math.round(zm1Var.i / this.h.density);
            q70.b();
            fd fdVar5 = (fd) q70.b;
            i5 = fdVar5.bitField0_;
            fdVar5.bitField0_ = i5 | 262144;
            fdVar5.tcyDownSignal_ = round5;
            if (((MotionEvent) this.f.get("nv")) == null) {
                return;
            }
            long round6 = Math.round(((r1.getRawX() + (zm1Var.h - zm1Var.j)) - r1.getX()) / this.h.density);
            if (round6 != 0) {
                q70.b();
                fd fdVar6 = (fd) q70.b;
                i7 = fdVar6.bitField0_;
                fdVar6.bitField0_ = i7 | 32768;
                fdVar6.viewDxSignal_ = round6;
            }
            long round7 = Math.round(((r1.getRawY() + (zm1Var.i - zm1Var.k)) - r1.getY()) / this.h.density);
            if (round7 != 0) {
                q70.b();
                fd fdVar7 = (fd) q70.b;
                i6 = fdVar7.bitField0_;
                fdVar7.bitField0_ = i6 | 65536;
                fdVar7.viewDySignal_ = round7;
            }
        }
    }
}
