package defpackage;

import ads_mobile_sdk.C0747a;
import ads_mobile_sdk.bi;
import ads_mobile_sdk.fh;
import ads_mobile_sdk.lh3;
import ads_mobile_sdk.lq0;
import ads_mobile_sdk.qr3;
import ads_mobile_sdk.ts3;
import android.util.Base64;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final /* synthetic */ class Q80 implements Callable {
    public final /* synthetic */ int a;
    public final /* synthetic */ lh3 b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ Q80(lh3 lh3Var, int i) {
        this.a = i;
        this.b = lh3Var;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.a) {
            case 0:
                lh3 lh3Var = this.b;
                String str = lh3Var.d;
                C0747a c0747a = lh3Var.b;
                c0747a.getClass();
                Uc0 D = fh.D();
                D.d(T60.h(24));
                return Base64.encodeToString(c0747a.a(true, ((fh) D.b()).c(), str), 11);
            case 1:
                lh3 lh3Var2 = this.b;
                lh3Var2.getClass();
                lq0 lq0Var = lq0.EVENT_ID_ENCRYPTION;
                Q80 q80 = new Q80(lh3Var2, 2);
                ts3 ts3Var = lh3Var2.g;
                qr3 qr3Var = new qr3(lq0Var, ts3Var.b, ts3Var.a);
                try {
                    qr3Var.b();
                    Object call = q80.call();
                    qr3Var.a();
                    return (String) call;
                } catch (Throwable th) {
                    try {
                        qr3Var.a(th);
                        throw th;
                    } catch (Throwable th2) {
                        qr3Var.a();
                        throw th2;
                    }
                }
            default:
                lh3 lh3Var3 = this.b;
                fh fhVar = (fh) lh3Var3.e.b();
                String str2 = lh3Var3.d;
                C0747a c0747a2 = lh3Var3.b;
                c0747a2.getClass();
                try {
                    return Base64.encodeToString(((bi) c0747a2.a(str2, fhVar.c()).b()).c(), 11);
                } catch (IllegalArgumentException unused) {
                    Uc0 D2 = fh.D();
                    D2.d(T60.h(22));
                    return Base64.encodeToString(c0747a2.a(true, ((fh) D2.b()).c(), str2), 11);
                }
        }
    }
}
