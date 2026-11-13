package ads_mobile_sdk;

import android.util.Base64;
import android.view.MotionEvent;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;
import defpackage.F40;
import defpackage.R40;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class dt1 {
    public final Object a;
    public final tn0 b;
    public final y9 c;
    public final boolean d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public dt1(Object obj, tn0 tn0Var, y9 y9Var, boolean z) {
        this.a = obj;
        this.b = tn0Var;
        this.c = y9Var;
        this.d = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String a(byte[] bArr) {
        int i;
        if (bArr == null) {
            return null;
        }
        R40 v = bi.v();
        v.d$3();
        bi biVar = (bi) v.b;
        biVar.getClass();
        biVar.encryptionMethod_ = F40.t(5);
        i = biVar.bitField0_;
        biVar.bitField0_ = i | 4;
        du a = du.a(bArr, 0, bArr.length);
        v.d$3();
        ((bi) v.b).a(a);
        return Base64.encodeToString(((bi) v.b()).c(), 11);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.a.getClass().getDeclaredMethod("close", null).invoke(this.a, null);
            y9 y9Var = this.c;
            ((st1) y9Var.a).a(3001, System.currentTimeMillis() - currentTimeMillis, null, null);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(Boolean.TRUE);
            taskCompletionSource.getTask();
        } catch (Exception e) {
            throw new ly3(AdError.INTERNAL_ERROR_2003, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void a(MotionEvent motionEvent) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.b.getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.a.getClass().getDeclaredMethod("he", Map.class).invoke(this.a, hashMap);
            y9 y9Var = this.c;
            ((st1) y9Var.a).a(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - currentTimeMillis, null, null);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(Boolean.TRUE);
            taskCompletionSource.getTask();
        } catch (Exception e) {
            throw new ly3(2005, e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized byte[] a(HashMap hashMap) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e) {
            this.c.a(2007, System.currentTimeMillis() - currentTimeMillis, e);
            return null;
        }
        return (byte[]) this.a.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.a, null, hashMap);
    }
}
