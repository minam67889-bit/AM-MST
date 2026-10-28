package ads_mobile_sdk;

import android.util.Base64;
import android.view.MotionEvent;
import com.facebook.ads.AdError;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;
import defpackage.AbstractC3769od0;
import defpackage.C3967r70;
import defpackage.Qd0;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class ej1 {
    public final Object a;
    public final Qd0 b;
    public final AbstractC3769od0 c;
    public final boolean d;

    public ej1(Object obj, Qd0 qd0, AbstractC3769od0 abstractC3769od0, boolean z) {
        this.a = obj;
        this.b = qd0;
        this.c = abstractC3769od0;
        this.d = z;
    }

    public final synchronized void a() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            this.a.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.a, new Object[0]);
            AbstractC3769od0 abstractC3769od0 = this.c;
            ((rj1) ((t6) abstractC3769od0).a).a(3001, System.currentTimeMillis() - currentTimeMillis, null, null);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(Boolean.TRUE);
            taskCompletionSource.getTask();
        } catch (Exception e) {
            throw new qj3(AdError.INTERNAL_ERROR_2003, e);
        }
    }

    public final synchronized int b() {
        try {
        } catch (Exception e) {
            throw new qj3(AdError.INTERNAL_ERROR_2006, e);
        }
        return ((Integer) this.a.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.a, new Object[0])).intValue();
    }

    public final synchronized boolean c() {
        try {
        } catch (Exception e) {
            throw new qj3(AdError.INTERNAL_ERROR_CODE, e);
        }
        return ((Boolean) this.a.getClass().getDeclaredMethod("init", new Class[0]).invoke(this.a, new Object[0])).booleanValue();
    }

    public final synchronized void a(MotionEvent motionEvent) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            ((li0) this.b).getClass();
            HashMap hashMap = new HashMap();
            hashMap.put("t", new Throwable());
            hashMap.put("aid", null);
            hashMap.put("evt", motionEvent);
            this.a.getClass().getDeclaredMethod("he", Map.class).invoke(this.a, hashMap);
            AbstractC3769od0 abstractC3769od0 = this.c;
            ((rj1) ((t6) abstractC3769od0).a).a(AuthApiStatusCodes.AUTH_API_SERVER_ERROR, System.currentTimeMillis() - currentTimeMillis, null, null);
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(Boolean.TRUE);
            taskCompletionSource.getTask();
        } catch (Exception e) {
            throw new qj3(2005, e);
        }
    }

    public static String a(byte[] bArr) {
        int i;
        if (bArr == null) {
            return null;
        }
        C3967r70 o = ee.o();
        sd sdVar = sd.DG;
        o.b();
        ee eeVar = (ee) o.b;
        eeVar.getClass();
        eeVar.encryptionMethod_ = sdVar.a;
        i = eeVar.bitField0_;
        eeVar.bitField0_ = i | 4;
        o.d(qq.a(bArr, 0, bArr.length));
        return Base64.encodeToString(((ee) o.a()).a(), 11);
    }

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
