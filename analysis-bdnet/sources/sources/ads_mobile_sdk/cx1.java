package ads_mobile_sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Base64;
import defpackage.AbstractC4311s10;
import defpackage.C4819yb0;
import defpackage.F40;
import defpackage.R40;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class cx1 {
    public final Context a;
    public final ts3 b;
    public final C0747a c;
    public final String d;
    public final boolean e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public cx1(Context context, ts3 ts3Var, C0747a c0747a, na naVar) {
        this.a = context;
        this.b = ts3Var;
        this.c = c0747a;
        this.d = naVar.M();
        this.e = naVar.G();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String a(long j) {
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        String str;
        Signature[] signatureArr;
        C4819yb0 v = th.v();
        String str2 = this.d;
        v.d$3();
        ((th) v.b).b(str2);
        v.d$3();
        ((th) v.b).w();
        String packageName = this.a.getPackageName();
        v.d$3();
        ((th) v.b).c(packageName);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        v.d$3();
        th thVar = (th) v.b;
        i = thVar.bitField0_;
        thVar.bitField0_ = i | 4;
        thVar.evtTime_ = currentTimeMillis;
        long currentTimeMillis2 = (System.currentTimeMillis() - j) / 1000;
        v.d$3();
        th thVar2 = (th) v.b;
        i2 = thVar2.bitField0_;
        thVar2.bitField0_ = i2 | 32;
        thVar2.uptSignal_ = currentTimeMillis2;
        if (this.e) {
            try {
                signatureArr = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 64).signatures;
            } catch (Exception unused) {
            }
            if (signatureArr != null && signatureArr.length > 0) {
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
                v.d$3();
                ((th) v.b).d(str);
            }
            str = "E";
            v.d$3();
            ((th) v.b).d(str);
        }
        try {
            long j2 = this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0).versionCode;
            v.d$3();
            th thVar3 = (th) v.b;
            i6 = thVar3.bitField0_;
            thVar3.bitField0_ = i6 | 16;
            thVar3.vcdSignal_ = j2;
        } catch (PackageManager.NameNotFoundException unused2) {
            v.d$3();
            th thVar4 = (th) v.b;
            i3 = thVar4.bitField0_;
            thVar4.bitField0_ = i3 | 16;
            thVar4.vcdSignal_ = -1L;
        }
        C0747a c0747a = this.c;
        synchronized (c0747a) {
            z = c0747a.d;
        }
        if (!z) {
            this.c.a();
        }
        R40 a = this.c.a(null, ((th) v.b()).c());
        a.d$3();
        bi biVar = (bi) a.b;
        biVar.getClass();
        biVar.protoName_ = 4;
        i4 = biVar.bitField0_;
        biVar.bitField0_ = i4 | 2;
        a.d$3();
        bi biVar2 = (bi) a.b;
        biVar2.getClass();
        biVar2.encryptionMethod_ = F40.t(2);
        i5 = biVar2.bitField0_;
        biVar2.bitField0_ = i5 | 4;
        return AbstractC4311s10.d(true).c(((bi) a.b()).c());
    }
}
