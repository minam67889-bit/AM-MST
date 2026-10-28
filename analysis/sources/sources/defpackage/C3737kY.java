package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: kY, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3737kY extends C3585iY {
    public final Class p;
    public final Constructor q;
    public final Method r;
    public final Method s;
    public final Method t;
    public final Method u;
    public final Method v;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3737kY() {
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            method2 = p0(cls2);
            Class cls3 = Integer.TYPE;
            method3 = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method4 = cls2.getMethod("freeze", null);
            method5 = cls2.getMethod("abortCreation", null);
            method = q0(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            method = null;
            constructor = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.p = cls;
        this.q = constructor;
        this.r = method2;
        this.s = method3;
        this.t = method4;
        this.u = method5;
        this.v = method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Method p0(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void j0(Object obj) {
        try {
            this.u.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean k0(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.r.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Typeface l0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.p, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.v.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean m0(Object obj) {
        try {
            return ((Boolean) this.t.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean n0() {
        Method method = this.r;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method != null) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object o0() {
        try {
            return this.q.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Method q0(Class cls) {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.C3585iY, defpackage.AbstractC4817ya0
    public final Typeface u(Context context, C0631Xr c0631Xr, Resources resources, int i) {
        if (!n0()) {
            return super.u(context, c0631Xr, resources, i);
        }
        Object o0 = o0();
        if (o0 == null) {
            return null;
        }
        for (C0657Yr c0657Yr : c0631Xr.a) {
            if (!k0(context, o0, c0657Yr.a, c0657Yr.e, c0657Yr.b, c0657Yr.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(c0657Yr.d))) {
                j0(o0);
                return null;
            }
        }
        if (!m0(o0)) {
            return null;
        }
        return l0(o0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.C3585iY, defpackage.AbstractC4817ya0
    public final Typeface v(Context context, C0773as[] c0773asArr, int i) {
        Typeface l0;
        boolean z;
        if (c0773asArr.length < 1) {
            return null;
        }
        if (!n0()) {
            C0773as D = D(c0773asArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(D.a, "r", null);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(D.c).setItalic(D.d).build();
                    openFileDescriptor.close();
                    return build;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap hashMap = new HashMap();
        for (C0773as c0773as : c0773asArr) {
            if (c0773as.e == 0) {
                Uri uri = c0773as.a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, AbstractC4747xe.L(context, uri));
                }
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Object o0 = o0();
        if (o0 == null) {
            return null;
        }
        int length = c0773asArr.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            C0773as c0773as2 = c0773asArr[i2];
            ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(c0773as2.a);
            if (byteBuffer != null) {
                try {
                    z = ((Boolean) this.s.invoke(o0, byteBuffer, Integer.valueOf(c0773as2.b), null, Integer.valueOf(c0773as2.c), Integer.valueOf(c0773as2.d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    z = false;
                }
                if (!z) {
                    j0(o0);
                    return null;
                }
                z2 = true;
            }
            i2++;
            z2 = z2;
        }
        if (!z2) {
            j0(o0);
            return null;
        }
        if (!m0(o0) || (l0 = l0(o0)) == null) {
            return null;
        }
        return Typeface.create(l0, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public final Typeface y(Context context, Resources resources, int i, String str, int i2) {
        if (!n0()) {
            return super.y(context, resources, i, str, i2);
        }
        Object o0 = o0();
        if (o0 == null) {
            return null;
        }
        if (!k0(context, o0, str, 0, -1, -1, null)) {
            j0(o0);
            return null;
        }
        if (!m0(o0)) {
            return null;
        }
        return l0(o0);
    }
}
