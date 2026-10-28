package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.internal.p002firebaseauthapi.zzac;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.recaptcha.RecaptchaAction;
import com.google.firebase.auth.FirebaseAuth;
import dastan.prince.bdfreevpn.R;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class P2 implements InterfaceC4245uf {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;

    public static C4284v8 i(C4284v8 c4284v8, ML ml, C4548yX c4548yX, Map map) {
        Map unmodifiableMap;
        Map unmodifiableMap2;
        Map unmodifiableMap3;
        C4205u8 a = c4284v8.a();
        String g = ((InterfaceC4178tq) ml.c).g();
        if (g != null) {
            a.e = new I8(g);
        } else if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", "No log data to include with this event.", null);
        }
        boolean isEmpty = map.isEmpty();
        C0148Fi c0148Fi = (C0148Fi) c4548yX.d;
        if (isEmpty) {
            C4130tA c4130tA = (C4130tA) ((AtomicMarkableReference) c0148Fi.b).getReference();
            synchronized (c4130tA) {
                unmodifiableMap2 = Collections.unmodifiableMap(new HashMap(c4130tA.a));
            }
        } else {
            C4130tA c4130tA2 = (C4130tA) ((AtomicMarkableReference) c0148Fi.b).getReference();
            synchronized (c4130tA2) {
                unmodifiableMap = Collections.unmodifiableMap(new HashMap(c4130tA2.a));
            }
            HashMap hashMap = new HashMap(unmodifiableMap);
            int i = 0;
            for (Map.Entry entry : map.entrySet()) {
                String a2 = C4130tA.a(UserVerificationMethods.USER_VERIFY_ALL, (String) entry.getKey());
                if (hashMap.size() < 64 || hashMap.containsKey(a2)) {
                    hashMap.put(a2, C4130tA.a(UserVerificationMethods.USER_VERIFY_ALL, (String) entry.getValue()));
                } else {
                    i++;
                }
            }
            if (i > 0) {
                Log.w("FirebaseCrashlytics", "Ignored " + i + " keys when adding event specific keys. Maximum allowable: 1024", null);
            }
            unmodifiableMap2 = Collections.unmodifiableMap(hashMap);
        }
        List q = q(unmodifiableMap2);
        C4130tA c4130tA3 = (C4130tA) ((AtomicMarkableReference) ((C0148Fi) c4548yX.e).b).getReference();
        synchronized (c4130tA3) {
            unmodifiableMap3 = Collections.unmodifiableMap(new HashMap(c4130tA3.a));
        }
        List q2 = q(unmodifiableMap3);
        if (!q.isEmpty() || !q2.isEmpty()) {
            C4363w8 c4363w8 = c4284v8.c;
            a.c = new C4363w8(c4363w8.a, q, q2, c4363w8.d, c4363w8.e, c4363w8.f, c4363w8.g);
        }
        return a.a();
    }

    public static AbstractC0614Xh j(C4284v8 c4284v8, C4548yX c4548yX) {
        List unmodifiableList;
        U3 u3 = (U3) c4548yX.f;
        synchronized (u3) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList((ArrayList) u3.c));
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < unmodifiableList.size(); i++) {
            OO oo = (OO) unmodifiableList.get(i);
            oo.getClass();
            J8 j8 = new J8();
            C3576m9 c3576m9 = (C3576m9) oo;
            String str = c3576m9.e;
            if (str == null) {
                throw new NullPointerException("Null variantId");
            }
            String str2 = c3576m9.b;
            if (str2 == null) {
                throw new NullPointerException("Null rolloutId");
            }
            j8.a = new L8(str2, str);
            String str3 = c3576m9.c;
            if (str3 == null) {
                throw new NullPointerException("Null parameterKey");
            }
            j8.b = str3;
            String str4 = c3576m9.d;
            if (str4 == null) {
                throw new NullPointerException("Null parameterValue");
            }
            j8.c = str4;
            j8.d = c3576m9.f;
            j8.e = (byte) (j8.e | 1);
            arrayList.add(j8.a());
        }
        if (arrayList.isEmpty()) {
            return c4284v8;
        }
        C4205u8 a = c4284v8.a();
        a.f = new M8(arrayList);
        return a.a();
    }

    public static boolean k(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static String m(InputStream inputStream) {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                byte[] bArr = new byte[JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE];
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        return byteArrayOutputStream2;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
            } finally {
            }
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static P2 n(Context context, C0162Fw c0162Fw, C0156Fq c0156Fq, C0857c6 c0857c6, ML ml, C4548yX c4548yX, C0595Wo c0595Wo, C2859d9 c2859d9, C0595Wo c0595Wo2, C3933qh c3933qh, C2853d6 c2853d6) {
        C0906ci c0906ci = new C0906ci(context, c0162Fw, c0857c6, c0595Wo, c2859d9);
        C2981ei c2981ei = new C2981ei(c0156Fq, c2859d9, c3933qh);
        C2902di c2902di = C0408Pj.b;
        C3204hY.b(context);
        C0408Pj c0408Pj = new C0408Pj(new C3194hO(C3204hY.a().c(new C4474xb(C0408Pj.c, C0408Pj.d)).a("FIREBASE_CRASHLYTICS_REPORT", new C3703no("json"), C0408Pj.e), c2859d9.f(), c0595Wo2));
        P2 p2 = new P2();
        p2.a = c0906ci;
        p2.b = c2981ei;
        p2.c = c0408Pj;
        p2.d = ml;
        p2.e = c4548yX;
        p2.f = c0162Fw;
        return p2;
    }

    public static ColorStateList o(Context context, int i) {
        int c = JW.c(context, R.attr.colorControlHighlight);
        int b = JW.b(context, R.attr.colorButtonNormal);
        int[] iArr = JW.b;
        int[] iArr2 = JW.d;
        int b2 = AbstractC0118Ee.b(c, i);
        return new ColorStateList(new int[][]{iArr, iArr2, JW.c, JW.f}, new int[]{b, b2, AbstractC0118Ee.b(c, i), i});
    }

    public static LayerDrawable p(C4302vO c4302vO, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable c = c4302vO.c(context, R.drawable.abc_star_black_48dp);
        Drawable c2 = c4302vO.c(context, R.drawable.abc_star_half_black_48dp);
        if ((c instanceof BitmapDrawable) && c.getIntrinsicWidth() == dimensionPixelSize && c.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) c;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            c.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c.draw(canvas);
            bitmapDrawable = new BitmapDrawable(createBitmap);
            bitmapDrawable2 = new BitmapDrawable(createBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((c2 instanceof BitmapDrawable) && c2.getIntrinsicWidth() == dimensionPixelSize && c2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) c2;
        } else {
            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap2);
            c2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            c2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static List q(Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str == null) {
                throw new NullPointerException("Null key");
            }
            String str2 = (String) entry.getValue();
            if (str2 == null) {
                throw new NullPointerException("Null value");
            }
            arrayList.add(new C3494l8(str, str2));
        }
        Collections.sort(arrayList, new C3854ph(4));
        return Collections.unmodifiableList(arrayList);
    }

    public static void x(Drawable drawable, int i, PorterDuff.Mode mode) {
        Drawable mutate = drawable.mutate();
        if (mode == null) {
            mode = C3408k5.b;
        }
        mutate.setColorFilter(C3408k5.c(i, mode));
    }

    public Task A(String str) {
        Task task;
        synchronized (this.a) {
            task = (Task) ((HashMap) this.b).get(str);
        }
        return task;
    }

    @Override // defpackage.InterfaceC4245uf
    public Object a(Class cls) {
        if (!((Set) this.a).contains(C3669nM.a(cls))) {
            throw new C0742af("Attempting to request an undeclared dependency " + cls + ".");
        }
        Object a = ((InterfaceC4245uf) this.f).a(cls);
        if (!cls.equals(InterfaceC3350jM.class)) {
            return a;
        }
        return new CO();
    }

    @Override // defpackage.InterfaceC4245uf
    public ZL b(C3669nM c3669nM) {
        if (((Set) this.e).contains(c3669nM)) {
            return ((InterfaceC4245uf) this.f).b(c3669nM);
        }
        throw new C0742af("Attempting to request an undeclared dependency Provider<Set<" + c3669nM + ">>.");
    }

    @Override // defpackage.InterfaceC4245uf
    public Set c(C3669nM c3669nM) {
        if (((Set) this.d).contains(c3669nM)) {
            return ((InterfaceC4245uf) this.f).c(c3669nM);
        }
        throw new C0742af("Attempting to request an undeclared dependency Set<" + c3669nM + ">.");
    }

    @Override // defpackage.InterfaceC4245uf
    public ZL d(Class cls) {
        return f(C3669nM.a(cls));
    }

    @Override // defpackage.InterfaceC4245uf
    public C4139tJ e(C3669nM c3669nM) {
        if (((Set) this.c).contains(c3669nM)) {
            return ((InterfaceC4245uf) this.f).e(c3669nM);
        }
        throw new C0742af("Attempting to request an undeclared dependency Deferred<" + c3669nM + ">.");
    }

    @Override // defpackage.InterfaceC4245uf
    public ZL f(C3669nM c3669nM) {
        if (((Set) this.b).contains(c3669nM)) {
            return ((InterfaceC4245uf) this.f).f(c3669nM);
        }
        throw new C0742af("Attempting to request an undeclared dependency Provider<" + c3669nM + ">.");
    }

    @Override // defpackage.InterfaceC4245uf
    public Object g(C3669nM c3669nM) {
        if (((Set) this.a).contains(c3669nM)) {
            return ((InterfaceC4245uf) this.f).g(c3669nM);
        }
        throw new C0742af("Attempting to request an undeclared dependency " + c3669nM + ".");
    }

    @Override // defpackage.InterfaceC4245uf
    public C4139tJ h(Class cls) {
        return e(C3669nM.a(cls));
    }

    public S2 l() {
        if (((Integer) this.a) == null) {
            throw new GeneralSecurityException("AES key size is not set");
        }
        if (((Integer) this.b) == null) {
            throw new GeneralSecurityException("HMAC key size is not set");
        }
        if (((Integer) this.c) == null) {
            throw new GeneralSecurityException("iv size is not set");
        }
        Integer num = (Integer) this.d;
        if (num == null) {
            throw new GeneralSecurityException("tag size is not set");
        }
        if (((Q2) this.e) == null) {
            throw new GeneralSecurityException("hash type is not set");
        }
        if (((R2) this.f) == null) {
            throw new GeneralSecurityException("variant is not set");
        }
        int intValue = num.intValue();
        Q2 q2 = (Q2) this.e;
        if (q2 == Q2.c) {
            if (intValue > 20) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 20 bytes for SHA1", num));
            }
        } else if (q2 == Q2.d) {
            if (intValue > 28) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 28 bytes for SHA224", num));
            }
        } else if (q2 == Q2.e) {
            if (intValue > 32) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 32 bytes for SHA256", num));
            }
        } else if (q2 == Q2.f) {
            if (intValue > 48) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 48 bytes for SHA384", num));
            }
        } else {
            if (q2 != Q2.g) {
                throw new GeneralSecurityException("unknown hash type; must be SHA1, SHA224, SHA256, SHA384 or SHA512");
            }
            if (intValue > 64) {
                throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; can be at most 64 bytes for SHA512", num));
            }
        }
        return new S2(((Integer) this.a).intValue(), ((Integer) this.b).intValue(), ((Integer) this.c).intValue(), ((Integer) this.d).intValue(), (R2) this.f, (Q2) this.e);
    }

    public ColorStateList r(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return AbstractC3131gc0.u(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return AbstractC3131gc0.u(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return o(context, JW.c(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return o(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return o(context, JW.c(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return AbstractC3131gc0.u(context, R.color.abc_tint_spinner);
            }
            if (k((int[]) this.b, i)) {
                return JW.d(context, R.attr.colorControlNormal);
            }
            if (k((int[]) this.e, i)) {
                return AbstractC3131gc0.u(context, R.color.abc_tint_default);
            }
            if (k((int[]) this.f, i)) {
                return AbstractC3131gc0.u(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return AbstractC3131gc0.u(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList d = JW.d(context, R.attr.colorSwitchThumbNormal);
        if (d == null || !d.isStateful()) {
            iArr[0] = JW.b;
            iArr2[0] = JW.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = JW.e;
            iArr2[1] = JW.c(context, R.attr.colorControlActivated);
            iArr[2] = JW.f;
            iArr2[2] = JW.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = JW.b;
            iArr[0] = iArr3;
            iArr2[0] = d.getColorForState(iArr3, 0);
            iArr[1] = JW.e;
            iArr2[1] = JW.c(context, R.attr.colorControlActivated);
            iArr[2] = JW.f;
            iArr2[2] = d.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:48:? -> B:43:0x0137). Please report as a decompilation issue!!! */
    public Task s(String str, Executor executor) {
        C3176h8 c3176h8;
        ArrayBlockingQueue arrayBlockingQueue;
        TaskCompletionSource taskCompletionSource;
        ArrayList b = ((C2981ei) this.b).b();
        ArrayList arrayList = new ArrayList();
        Iterator it = b.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            try {
                C2902di c2902di = C2981ei.g;
                String e = C2981ei.e(file);
                c2902di.getClass();
                arrayList.add(new C3176h8(C2902di.i(e), file.getName(), file));
            } catch (IOException e2) {
                Log.w("FirebaseCrashlytics", "Could not load report file " + file + "; deleting", e2);
                file.delete();
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            C3176h8 c3176h82 = (C3176h8) it2.next();
            if (str == null || str.equals(c3176h82.b)) {
                C0408Pj c0408Pj = (C0408Pj) this.c;
                C3096g8 c3096g8 = c3176h82.a;
                boolean z = true;
                if (c3096g8.f == null || c3096g8.g == null) {
                    C2910dr b2 = ((C0162Fw) this.f).b(true);
                    C3016f8 a = c3176h82.a.a();
                    a.e = b2.a;
                    C3016f8 a2 = a.a().a();
                    a2.f = b2.b;
                    c3176h8 = new C3176h8(a2.a(), c3176h82.b, c3176h82.c);
                } else {
                    c3176h8 = c3176h82;
                }
                boolean z2 = str != null;
                C3194hO c3194hO = c0408Pj.a;
                ArrayBlockingQueue arrayBlockingQueue2 = c3194hO.f;
                synchronized (arrayBlockingQueue2) {
                    try {
                        taskCompletionSource = new TaskCompletionSource();
                        if (z2) {
                            ((AtomicInteger) c3194hO.i.b).getAndIncrement();
                            if (c3194hO.f.size() >= c3194hO.e) {
                                z = false;
                            }
                            if (z) {
                                C4254un c4254un = C4254un.e;
                                c4254un.l("Enqueueing report: " + c3176h8.b);
                                c4254un.l("Queue size: " + c3194hO.f.size());
                                arrayBlockingQueue = arrayBlockingQueue2;
                                try {
                                    c3194hO.g.execute(new RunnableC3058fg(c3194hO, c3176h8, taskCompletionSource, 4, false));
                                    c4254un.l("Closing task for report: " + c3176h8.b);
                                    taskCompletionSource.trySetResult(c3176h8);
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            } else {
                                c3194hO.a();
                                String str2 = "Dropping report due to queue being full: " + c3176h8.b;
                                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                    Log.d("FirebaseCrashlytics", str2, null);
                                }
                                ((AtomicInteger) c3194hO.i.c).getAndIncrement();
                                taskCompletionSource.trySetResult(c3176h8);
                            }
                        } else {
                            c3194hO.b(c3176h8, taskCompletionSource);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        arrayBlockingQueue = arrayBlockingQueue2;
                        throw th;
                    }
                }
                arrayList2.add(taskCompletionSource.getTask().continueWith(executor, new C3290ic(this, 19)));
            }
        }
        return Tasks.whenAll(arrayList2);
    }

    public void t(int i) {
        if (i != 16 && i != 24 && i != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 16-byte, 24-byte and 32-byte AES keys are supported", Integer.valueOf(i)));
        }
        this.a = Integer.valueOf(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0157 A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void u(String str, Bundle bundle, boolean z) {
        String str2;
        String str3;
        InterfaceC0265Jv interfaceC0265Jv;
        boolean e;
        int i;
        bundle.putString("scope", "*");
        bundle.putString("sender", str);
        bundle.putString("subtype", str);
        C0493Sq c0493Sq = (C0493Sq) this.a;
        c0493Sq.a();
        bundle.putString("gmp_app_id", c0493Sq.c.b);
        bundle.putString("gmsv", Integer.toString(((C4580yx) this.b).c()));
        bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString("app_ver", ((C4580yx) this.b).a());
        C4580yx c4580yx = (C4580yx) this.b;
        synchronized (c4580yx) {
            try {
                if (((String) c4580yx.e) == null) {
                    c4580yx.j();
                }
                str2 = (String) c4580yx.e;
            } finally {
            }
        }
        bundle.putString("app_ver_name", str2);
        C0493Sq c0493Sq2 = (C0493Sq) this.a;
        c0493Sq2.a();
        try {
            str3 = Base64.encodeToString(MessageDigest.getInstance("SHA-1").digest(c0493Sq2.b.getBytes()), 11);
        } catch (NoSuchAlgorithmException unused) {
            str3 = "[HASH-ERROR]";
        }
        bundle.putString("firebase-app-name-hash", str3);
        if (z) {
            C0493Sq c0493Sq3 = (C0493Sq) this.a;
            c0493Sq3.a();
            bundle.putString("Goog-Api-Key", c0493Sq3.c.a);
        }
        try {
            String str4 = ((C0784b9) Tasks.await(((C3150gr) ((InterfaceC3230hr) this.f)).d())).a;
            if (TextUtils.isEmpty(str4)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString("Goog-Firebase-Installations-Auth", str4);
            }
        } catch (InterruptedException e2) {
            e = e2;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
            bundle.putString("appid", (String) Tasks.await(((C3150gr) ((InterfaceC3230hr) this.f)).c()));
            bundle.putString("cliv", "fcm-25.1.0");
            interfaceC0265Jv = (InterfaceC0265Jv) ((ZL) this.e).get();
            C0124Ek c0124Ek = (C0124Ek) ((ZL) this.d).get();
            if (interfaceC0265Jv == null) {
                return;
            } else {
                return;
            }
        } catch (ExecutionException e3) {
            e = e3;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
            bundle.putString("appid", (String) Tasks.await(((C3150gr) ((InterfaceC3230hr) this.f)).c()));
            bundle.putString("cliv", "fcm-25.1.0");
            interfaceC0265Jv = (InterfaceC0265Jv) ((ZL) this.e).get();
            C0124Ek c0124Ek2 = (C0124Ek) ((ZL) this.d).get();
            if (interfaceC0265Jv == null) {
            }
        }
        bundle.putString("appid", (String) Tasks.await(((C3150gr) ((InterfaceC3230hr) this.f)).c()));
        bundle.putString("cliv", "fcm-25.1.0");
        interfaceC0265Jv = (InterfaceC0265Jv) ((ZL) this.e).get();
        C0124Ek c0124Ek22 = (C0124Ek) ((ZL) this.d).get();
        if (interfaceC0265Jv == null || c0124Ek22 == null) {
            return;
        }
        C3302ik c3302ik = (C3302ik) interfaceC0265Jv;
        synchronized (c3302ik) {
            long currentTimeMillis = System.currentTimeMillis();
            C0342Mv c0342Mv = (C0342Mv) c3302ik.a.get();
            synchronized (c0342Mv) {
                e = c0342Mv.e(C0342Mv.b, currentTimeMillis);
            }
            if (e) {
                synchronized (c0342Mv) {
                    c0342Mv.a.a(new C3636n(c0342Mv, C0342Mv.b(System.currentTimeMillis())));
                }
                i = 3;
            } else {
                i = 1;
            }
        }
        if (i != 1) {
            bundle.putString("Firebase-Client-Log-Type", Integer.toString(ZT.v(i)));
            bundle.putString("Firebase-Client", c0124Ek22.a());
        }
    }

    public void v(int i) {
        if (i < 16) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size in bytes %d; HMAC key must be at least 16 bytes", Integer.valueOf(i)));
        }
        this.b = Integer.valueOf(i);
    }

    public void w(int i) {
        if (i < 12 || i > 16) {
            throw new GeneralSecurityException(String.format("Invalid IV size in bytes %d; IV size must be between 12 and 16 bytes", Integer.valueOf(i)));
        }
        this.c = Integer.valueOf(i);
    }

    public void y(int i) {
        if (i < 10) {
            throw new GeneralSecurityException(String.format("Invalid tag size in bytes %d; must be at least 10 bytes", Integer.valueOf(i)));
        }
        this.d = Integer.valueOf(i);
    }

    public Task z(String str, Boolean bool, RecaptchaAction recaptchaAction) {
        Task continueWithTask;
        if (zzac.zzc(str)) {
            str = "*";
        }
        Task A = A(str);
        if (bool.booleanValue() || A == null) {
            String str2 = zzac.zzc(str) ? "*" : str;
            if (bool.booleanValue() || (continueWithTask = A(str2)) == null) {
                FirebaseAuth firebaseAuth = (FirebaseAuth) this.e;
                continueWithTask = firebaseAuth.e.zza(firebaseAuth.i, "RECAPTCHA_ENTERPRISE").continueWithTask(new C3298ig0(this, str2));
            }
            A = continueWithTask;
        }
        return A.continueWithTask(new TO(this, recaptchaAction));
    }
}
