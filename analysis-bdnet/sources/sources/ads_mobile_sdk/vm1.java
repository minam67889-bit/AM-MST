package ads_mobile_sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import defpackage.AbstractC2887da;
import defpackage.C0732aa;
import defpackage.C3967r70;
import defpackage.C4639ze0;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class vm1 {
    public final Context a;
    public final pd3 b;
    public final a c;
    public final String d;
    public final boolean e;

    public vm1(Context context, pd3 pd3Var, a aVar, f7 f7Var) {
        this.a = context;
        this.b = pd3Var;
        this.c = aVar;
        this.d = f7Var.D();
        this.e = f7Var.x();
    }

    public final String a(long j) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        boolean z;
        int i7;
        int i8;
        int i9;
        String str;
        int i10;
        C4639ze0 o = wd.o();
        String str2 = this.d;
        o.b();
        wd wdVar = (wd) o.b;
        wdVar.getClass();
        str2.getClass();
        i = wdVar.bitField0_;
        wdVar.bitField0_ = i | 2;
        wdVar.afmaVersion_ = str2;
        o.b();
        wd wdVar2 = (wd) o.b;
        wdVar2.getClass();
        i2 = wdVar2.bitField0_;
        wdVar2.bitField0_ = i2 | 1;
        wdVar2.adshieldVersion_ = "0.928791362";
        String packageName = this.a.getPackageName();
        o.b();
        wd wdVar3 = (wd) o.b;
        wdVar3.getClass();
        packageName.getClass();
        i3 = wdVar3.bitField0_;
        wdVar3.bitField0_ = i3 | 8;
        wdVar3.appIdSignal_ = packageName;
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        o.b();
        wd wdVar4 = (wd) o.b;
        i4 = wdVar4.bitField0_;
        wdVar4.bitField0_ = i4 | 4;
        wdVar4.evtTime_ = currentTimeMillis;
        long currentTimeMillis2 = (System.currentTimeMillis() - j) / 1000;
        o.b();
        wd wdVar5 = (wd) o.b;
        i5 = wdVar5.bitField0_;
        wdVar5.bitField0_ = i5 | 32;
        wdVar5.uptSignal_ = currentTimeMillis2;
        if (this.e) {
            try {
                Signature[] signatureArr = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures;
                if (signatureArr == null || signatureArr.length <= 0) {
                    str = "E";
                } else {
                    byte[] digest = MessageDigest.getInstance("SHA-1").digest(signatureArr[0].toByteArray());
                    StringBuilder sb = new StringBuilder();
                    for (byte b : digest) {
                        String hexString = Integer.toHexString(b & 255);
                        if (hexString.length() == 1) {
                            sb.append('0');
                        }
                        sb.append(hexString);
                    }
                    str = Base64.encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8), 11);
                }
            } catch (Exception unused) {
                str = "E";
            }
            o.b();
            wd wdVar6 = (wd) o.b;
            wdVar6.getClass();
            str.getClass();
            i10 = wdVar6.bitField0_;
            wdVar6.bitField0_ = 64 | i10;
            wdVar6.cerSignal_ = str;
        }
        try {
            long j2 = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
            o.b();
            wd wdVar7 = (wd) o.b;
            i9 = wdVar7.bitField0_;
            wdVar7.bitField0_ = i9 | 16;
            wdVar7.vcdSignal_ = j2;
        } catch (PackageManager.NameNotFoundException unused2) {
            o.b();
            wd wdVar8 = (wd) o.b;
            i6 = wdVar8.bitField0_;
            wdVar8.bitField0_ = i6 | 16;
            wdVar8.vcdSignal_ = -1L;
        }
        a aVar = this.c;
        synchronized (aVar) {
            z = aVar.d;
        }
        if (!z) {
            this.c.a();
        }
        C3967r70 a = this.c.a((String) null, ((wd) o.a()).a());
        a.b();
        ee eeVar = (ee) a.b;
        eeVar.getClass();
        eeVar.protoName_ = 4;
        i7 = eeVar.bitField0_;
        eeVar.bitField0_ = i7 | 2;
        sd sdVar = sd.BITSLICER;
        a.b();
        ee eeVar2 = (ee) a.b;
        eeVar2.getClass();
        eeVar2.encryptionMethod_ = sdVar.a;
        i8 = eeVar2.bitField0_;
        eeVar2.bitField0_ = i8 | 4;
        byte[] a2 = ((ee) a.a()).a();
        C0732aa c0732aa = AbstractC2887da.b;
        Character ch = c0732aa.e;
        AbstractC2887da abstractC2887da = c0732aa;
        if (ch != null) {
            abstractC2887da = c0732aa.h(c0732aa.d, null);
        }
        return abstractC2887da.c(a2);
    }
}
