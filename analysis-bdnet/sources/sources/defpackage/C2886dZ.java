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

/* renamed from: dZ, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C2886dZ extends AbstractC0199Hh {
    public static Class k;
    public static Constructor l;
    public static Method m;
    public static Method n;
    public static boolean o;

    public static boolean g0(Object obj, String str, int i, boolean z) {
        h0();
        try {
            return ((Boolean) m.invoke(obj, str, Integer.valueOf(i), Boolean.valueOf(z))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void h0() {
        Class<?> cls;
        Method method;
        Constructor<?> constructor;
        Method method2;
        if (o) {
            return;
        }
        o = true;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi21Impl", e.getClass().getName(), e);
            cls = null;
            method = null;
            constructor = null;
            method2 = null;
        }
        l = constructor;
        k = cls;
        m = method2;
        n = method;
    }

    @Override // defpackage.AbstractC0199Hh
    public Typeface A(Context context, C0054Bs c0054Bs, Resources resources, int i) {
        h0();
        try {
            Object newInstance = l.newInstance(new Object[0]);
            for (C0080Cs c0080Cs : c0054Bs.a) {
                File y = AbstractC0641Yi.y(context);
                if (y == null) {
                    return null;
                }
                try {
                    if (!AbstractC0641Yi.p(y, resources, c0080Cs.f)) {
                        return null;
                    }
                    if (!g0(newInstance, y.getPath(), c0080Cs.b, c0080Cs.c)) {
                        return null;
                    }
                    y.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    y.delete();
                }
            }
            h0();
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

    /* JADX WARN: Removed duplicated region for block: B:31:0x006c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // defpackage.AbstractC0199Hh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Typeface B(Context context, C0132Es[] c0132EsArr, int i) {
        File file;
        File y;
        Typeface createFromFile;
        String readlink;
        if (c0132EsArr.length >= 1) {
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(AbstractC0199Hh.K(c0132EsArr, i).a, "r", null);
                if (openFileDescriptor != null) {
                    try {
                        try {
                            readlink = Os.readlink("/proc/self/fd/" + openFileDescriptor.getFd());
                        } finally {
                        }
                    } catch (ErrnoException unused) {
                    }
                    try {
                        if (OsConstants.S_ISREG(Os.stat(readlink).st_mode)) {
                            file = new File(readlink);
                            if (file != null && file.canRead()) {
                                Typeface createFromFile2 = Typeface.createFromFile(file);
                                openFileDescriptor.close();
                                return createFromFile2;
                            }
                            FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                            y = AbstractC0641Yi.y(context);
                            if (y != null) {
                                try {
                                } catch (RuntimeException unused2) {
                                } catch (Throwable th) {
                                    y.delete();
                                    throw th;
                                }
                                if (AbstractC0641Yi.q(y, fileInputStream)) {
                                    createFromFile = Typeface.createFromFile(y.getPath());
                                    y.delete();
                                    fileInputStream.close();
                                    openFileDescriptor.close();
                                    return createFromFile;
                                }
                                y.delete();
                            }
                            createFromFile = null;
                            fileInputStream.close();
                            openFileDescriptor.close();
                            return createFromFile;
                        }
                        y = AbstractC0641Yi.y(context);
                        if (y != null) {
                        }
                        createFromFile = null;
                        fileInputStream.close();
                        openFileDescriptor.close();
                        return createFromFile;
                    } finally {
                    }
                    file = null;
                    if (file != null) {
                        Typeface createFromFile22 = Typeface.createFromFile(file);
                        openFileDescriptor.close();
                        return createFromFile22;
                    }
                    FileInputStream fileInputStream2 = new FileInputStream(openFileDescriptor.getFileDescriptor());
                } else if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                    return null;
                }
            } catch (IOException unused3) {
            }
        }
        return null;
    }
}
