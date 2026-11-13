package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.ParcelFileDescriptor;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: iY, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C3585iY extends AbstractC4817ya0 {
    public static Class k;
    public static Constructor l;
    public static Method m;
    public static Method n;
    public static boolean o;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean h0(Object obj, String str, int i, boolean z) {
        i0();
        try {
            return ((Boolean) m.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void i0() {
        Method method;
        Class<?> cls;
        Method method2;
        if (o) {
            return;
        }
        o = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            method = null;
            cls = null;
            method2 = null;
        }
        l = constructor;
        k = cls;
        m = method2;
        n = method;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public Typeface u(Context context, C0631Xr c0631Xr, Resources resources, int i) {
        i0();
        try {
            Object newInstance = l.newInstance(null);
            for (C0657Yr c0657Yr : c0631Xr.a) {
                File E = AbstractC4747xe.E(context);
                if (E == null) {
                    return null;
                }
                try {
                    if (!AbstractC4747xe.v(E, resources, c0657Yr.f)) {
                        return null;
                    }
                    if (!h0(newInstance, E.getPath(), c0657Yr.b, c0657Yr.c)) {
                        return null;
                    }
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    E.delete();
                }
            }
            i0();
            try {
                Object newInstance2 = Array.newInstance((Class<?>) k, 1);
                Array.set(newInstance2, 0, newInstance);
                return (Typeface) n.invoke(null, newInstance2);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractC4817ya0
    public Typeface v(Context context, C0773as[] c0773asArr, int i) {
        File file;
        String readlink;
        if (c0773asArr.length < 1) {
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(D(c0773asArr, i).a, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                try {
                    readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                } catch (ErrnoException unused) {
                }
                try {
                    if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                        file = new File(readlink);
                        if (file != null && file.canRead()) {
                            Typeface createFromFile = Typeface.createFromFile(file);
                            openFileDescriptor.close();
                            return createFromFile;
                        }
                        FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                        Typeface x = x(context, fileInputStream);
                        fileInputStream.close();
                        openFileDescriptor.close();
                        return x;
                    }
                    Typeface x2 = x(context, fileInputStream);
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return x2;
                } finally {
                }
                file = null;
                if (file != null) {
                    Typeface createFromFile2 = Typeface.createFromFile(file);
                    openFileDescriptor.close();
                    return createFromFile2;
                }
                FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
            } finally {
            }
        } catch (IOException unused2) {
            return null;
        }
    }
}
