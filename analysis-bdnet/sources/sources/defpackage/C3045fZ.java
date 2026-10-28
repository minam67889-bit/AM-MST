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

/* renamed from: fZ, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3045fZ extends C2886dZ {
    public final Class p;
    public final Constructor q;
    public final Method r;
    public final Method s;
    public final Method t;
    public final Method u;
    public final Method v;

    public C3045fZ() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = n0(cls);
            Class cls2 = Integer.TYPE;
            method3 = cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
            method4 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            method5 = o0(cls);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e.getClass().getName()), e);
            cls = null;
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
        this.u = method;
        this.v = method5;
    }

    public static Method n0(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // defpackage.C2886dZ, defpackage.AbstractC0199Hh
    public final Typeface A(Context context, C0054Bs c0054Bs, Resources resources, int i) {
        Method method = this.r;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.A(context, c0054Bs, resources, i);
        }
        Object m0 = m0();
        if (m0 != null) {
            C0080Cs[] c0080CsArr = c0054Bs.a;
            int length = c0080CsArr.length;
            int i2 = 0;
            while (i2 < length) {
                C0080Cs c0080Cs = c0080CsArr[i2];
                String str = c0080Cs.a;
                FontVariationAxis[] fromFontVariationSettings = FontVariationAxis.fromFontVariationSettings(c0080Cs.d);
                Context context2 = context;
                if (!j0(context2, m0, str, c0080Cs.e, c0080Cs.b, c0080Cs.c ? 1 : 0, fromFontVariationSettings)) {
                    i0(m0);
                    return null;
                }
                i2++;
                context = context2;
            }
            if (l0(m0)) {
                return k0(m0);
            }
        }
        return null;
    }

    @Override // defpackage.C2886dZ, defpackage.AbstractC0199Hh
    public final Typeface B(Context context, C0132Es[] c0132EsArr, int i) {
        Typeface k0;
        boolean z;
        if (c0132EsArr.length >= 1) {
            Method method = this.r;
            if (method == null) {
                Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
            }
            if (method != null) {
                HashMap hashMap = new HashMap();
                for (C0132Es c0132Es : c0132EsArr) {
                    if (c0132Es.f == 0) {
                        Uri uri = c0132Es.a;
                        if (!hashMap.containsKey(uri)) {
                            hashMap.put(uri, AbstractC0641Yi.F(context, uri));
                        }
                    }
                }
                Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
                Object m0 = m0();
                if (m0 != null) {
                    int length = c0132EsArr.length;
                    int i2 = 0;
                    boolean z2 = false;
                    while (i2 < length) {
                        C0132Es c0132Es2 = c0132EsArr[i2];
                        ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(c0132Es2.a);
                        if (byteBuffer != null) {
                            try {
                                z = ((Boolean) this.s.invoke(m0, byteBuffer, Integer.valueOf(c0132Es2.b), null, Integer.valueOf(c0132Es2.c), Integer.valueOf(c0132Es2.d ? 1 : 0))).booleanValue();
                            } catch (IllegalAccessException | InvocationTargetException unused) {
                                z = false;
                            }
                            if (!z) {
                                i0(m0);
                                return null;
                            }
                            z2 = true;
                        }
                        i2++;
                        z2 = z2;
                    }
                    if (!z2) {
                        i0(m0);
                        return null;
                    }
                    if (l0(m0) && (k0 = k0(m0)) != null) {
                        return Typeface.create(k0, i);
                    }
                }
            } else {
                C0132Es K = AbstractC0199Hh.K(c0132EsArr, i);
                try {
                    ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(K.a, "r", null);
                    if (openFileDescriptor != null) {
                        try {
                            Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(K.c).setItalic(K.d).build();
                            openFileDescriptor.close();
                            return build;
                        } finally {
                        }
                    }
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                        return null;
                    }
                } catch (IOException unused2) {
                }
            }
        }
        return null;
    }

    @Override // defpackage.AbstractC0199Hh
    public final Typeface D(Context context, Resources resources, int i, String str, int i2) {
        Method method = this.r;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        if (method == null) {
            return super.D(context, resources, i, str, i2);
        }
        Object m0 = m0();
        if (m0 != null) {
            if (!j0(context, m0, str, 0, -1, -1, null)) {
                i0(m0);
                return null;
            }
            if (l0(m0)) {
                return k0(m0);
            }
        }
        return null;
    }

    public final void i0(Object obj) {
        try {
            this.u.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean j0(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.r.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface k0(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) this.p, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) this.v.invoke(null, newInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean l0(Object obj) {
        try {
            return ((Boolean) this.t.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Object m0() {
        try {
            return this.q.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public Method o0(Class cls) {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
