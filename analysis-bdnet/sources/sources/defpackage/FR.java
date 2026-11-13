package defpackage;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.d;
import androidx.fragment.app.q;
import androidx.fragment.app.t;
import androidx.fragment.app.z;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzadz;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.recaptcha.RecaptchaAction;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class FR implements InterfaceC0608Xb, InterfaceC0440Qp, Continuation {
    public static FR e;
    public static final Object f = new Object();
    public static FR g;
    public Object a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ FR(Object obj, Object obj2, Object obj3, Object obj4) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.d = obj4;
    }

    public static synchronized FR f() {
        FR fr;
        synchronized (FR.class) {
            try {
                if (e == null) {
                    FR fr2 = new FR();
                    fr2.a = null;
                    fr2.b = null;
                    fr2.c = null;
                    fr2.d = new ArrayDeque();
                    e = fr2;
                }
                fr = e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fr;
    }

    public static FR g(q qVar) {
        FR fr;
        synchronized (f) {
            try {
                if (g == null) {
                    Context applicationContext = qVar.getApplicationContext();
                    FR fr2 = new FR();
                    fr2.b = new HashMap();
                    fr2.c = new HashMap();
                    fr2.d = new ArrayList();
                    fr2.a = applicationContext;
                    new R3(fr2, applicationContext.getMainLooper());
                    g = fr2;
                }
                fr = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return fr;
    }

    public C3324j3 a() {
        Integer num = (Integer) this.a;
        if (num == null) {
            throw new GeneralSecurityException("Key size is not set");
        }
        if (((Integer) this.b) == null) {
            throw new GeneralSecurityException("IV size is not set");
        }
        if (((B2) this.d) == null) {
            throw new GeneralSecurityException("Variant is not set");
        }
        if (((Integer) this.c) != null) {
            return new C3324j3(num.intValue(), ((Integer) this.b).intValue(), ((Integer) this.c).intValue(), (B2) this.d);
        }
        throw new GeneralSecurityException("Tag size is not set");
    }

    public C0074Cm b() {
        B2 b2 = (B2) this.a;
        if (b2 == null) {
            throw new GeneralSecurityException("signature encoding is not set");
        }
        C0048Bm c0048Bm = (C0048Bm) this.b;
        if (c0048Bm == null) {
            throw new GeneralSecurityException("EC curve type is not set");
        }
        R2 r2 = (R2) this.c;
        if (r2 == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        Q2 q2 = (Q2) this.d;
        if (q2 == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (c0048Bm == C0048Bm.c && r2 != R2.i) {
            throw new GeneralSecurityException("NIST_P256 requires SHA256");
        }
        C0048Bm c0048Bm2 = C0048Bm.d;
        R2 r22 = R2.k;
        if (c0048Bm == c0048Bm2 && r2 != R2.j && r2 != r22) {
            throw new GeneralSecurityException("NIST_P384 requires SHA384 or SHA512");
        }
        if (c0048Bm != C0048Bm.e || r2 == r22) {
            return new C0074Cm(b2, c0048Bm, r2, q2);
        }
        throw new GeneralSecurityException("NIST_P521 requires SHA512");
    }

    public C2836cw c() {
        Integer num = (Integer) this.a;
        if (num == null) {
            throw new GeneralSecurityException("key size is not set");
        }
        if (((Integer) this.b) == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (((C0761aw) this.c) == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (((C0841bw) this.d) == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        if (num.intValue() < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; must be at least 16 bytes", (Integer) this.a));
        }
        Integer num2 = (Integer) this.b;
        int intValue = num2.intValue();
        C0761aw c0761aw = (C0761aw) this.c;
        if (intValue < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", num2));
        }
        if (c0761aw == C0761aw.b) {
            if (intValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num2));
            }
        } else if (c0761aw == C0761aw.c) {
            if (intValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num2));
            }
        } else if (c0761aw == C0761aw.d) {
            if (intValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num2));
            }
        } else if (c0761aw == C0761aw.e) {
            if (intValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num2));
            }
        } else {
            if (c0761aw != C0761aw.f) {
                throw new GeneralSecurityException("unknown hash type; must be SHA256, SHA384 or SHA512");
            }
            if (intValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num2));
            }
        }
        return new C2836cw(((Integer) this.a).intValue(), ((Integer) this.b).intValue(), (C0841bw) this.d, (C0761aw) this.c);
    }

    public JV d(AbstractC3797p1 abstractC3797p1) {
        ArrayList arrayList = (ArrayList) this.c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            JV jv = (JV) arrayList.get(i);
            if (jv != null && jv.b == abstractC3797p1) {
                return jv;
            }
        }
        JV jv2 = new JV((Context) this.b, abstractC3797p1);
        arrayList.add(jv2);
        return jv2;
    }

    @Override // defpackage.InterfaceC0608Xb
    public void e() {
        View view = (View) this.a;
        view.clearAnimation();
        ((ViewGroup) this.b).endViewTransition(view);
        ((d) this.c).a();
        if (t.G(2)) {
            Log.v("FragmentManager", "Animation from operation " + ((z) this.d) + " has been cancelled.");
        }
    }

    @Override // defpackage.YL
    public Object get() {
        return new Z40((Executor) ((YL) this.a).get(), (InterfaceC0439Qo) ((YL) this.b).get(), (C0631Xy) ((C4452xG) this.c).get(), (XV) ((YL) this.d).get());
    }

    public boolean h(Context context) {
        if (((Boolean) this.c) == null) {
            this.c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!((Boolean) this.b).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.c).booleanValue();
    }

    public boolean i(Context context) {
        if (((Boolean) this.b) == null) {
            this.b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!((Boolean) this.b).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.b).booleanValue();
    }

    public boolean j(AbstractC3797p1 abstractC3797p1, MenuItem menuItem) {
        return ((ActionMode.Callback) this.a).onActionItemClicked(d(abstractC3797p1), new MenuItemC3820pF((Context) this.b, (NV) menuItem));
    }

    public boolean k(AbstractC3797p1 abstractC3797p1, MenuC2945eF menuC2945eF) {
        JV d = d(abstractC3797p1);
        C4386wT c4386wT = (C4386wT) this.d;
        Menu menu = (Menu) c4386wT.get(menuC2945eF);
        if (menu == null) {
            menu = new CF((Context) this.b, menuC2945eF);
            c4386wT.put(menuC2945eF, menu);
        }
        return ((ActionMode.Callback) this.a).onCreateActionMode(d, menu);
    }

    public void l(Intent intent) {
        synchronized (((HashMap) this.b)) {
            try {
                intent.getAction();
                String resolveTypeIfNeeded = intent.resolveTypeIfNeeded(((Context) this.a).getContentResolver());
                intent.getData();
                String scheme = intent.getScheme();
                intent.getCategories();
                boolean z = (intent.getFlags() & 8) != 0;
                if (z) {
                    Log.v("LocalBroadcastManager", "Resolving type " + resolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList = (ArrayList) ((HashMap) this.c).get(intent.getAction());
                if (arrayList != null) {
                    if (z) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList);
                    }
                    if (arrayList.size() > 0) {
                        if (arrayList.get(0) != null) {
                            throw new ClassCastException();
                        }
                        if (!z) {
                            throw null;
                        }
                        throw null;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m(int i) {
        if (i != 12 && i != 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; acceptable values have 12 or 16 bytes", Integer.valueOf(i)));
        }
        this.b = Integer.valueOf(i);
    }

    public void n(int i) {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.a = Integer.valueOf(i);
    }

    public void o() {
        this.c = 16;
    }

    @Override // com.google.android.gms.tasks.Continuation
    public /* synthetic */ Object then(Task task) {
        if (task.isSuccessful() || !zzadz.zzc((Exception) Preconditions.checkNotNull(task.getException()))) {
            return task;
        }
        boolean isLoggable = Log.isLoggable("RecaptchaCallWrapper", 4);
        String str = (String) this.a;
        if (isLoggable) {
            Log.i("RecaptchaCallWrapper", "Invalid token - Refreshing Recaptcha Enterprise config and fetching new token for tenant " + str);
        }
        return ((P2) this.b).z(str, Boolean.TRUE, (RecaptchaAction) this.c).continueWithTask((QO) this.d);
    }
}
