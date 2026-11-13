package defpackage;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.InflateException;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p002firebaseauthapi.zzahy;
import com.google.android.gms.internal.p002firebaseauthapi.zzaiz;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.objectweb.asm.Opcodes;

/* renamed from: kI, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2866kI {
    public static final C0367Xh f;
    public static final C0367Xh g;
    public static final C3505wM i;
    public static final C3505wM j;
    public static final C3505wM k;
    public static final C3505wM l;
    public static final C3505wM m;
    public static boolean o = true;
    public static final int[] a = new int[0];
    public static final Object[] b = new Object[0];
    public static final C2727hk c = new C2727hk(14);
    public static final Object d = new Object();
    public static final C0253Pn e = new C0253Pn(21, (byte) 0);
    public static final C3505wM h = new C3505wM(1, 2, 0);
    public static final C3505wM n = new C3505wM(11, 12, 6);

    static {
        int i2 = 3;
        f = new C0367Xh("NONE", i2);
        g = new C0367Xh("PENDING", i2);
        int i3 = 4;
        i = new C3505wM(3, i3, 1);
        j = new C3505wM(i3, 5, 2);
        int i4 = 7;
        k = new C3505wM(6, i4, 3);
        int i5 = 8;
        l = new C3505wM(i4, i5, 4);
        m = new C3505wM(i5, 9, 5);
    }

    public static final void A(InterfaceC3352tc interfaceC3352tc, Throwable th) {
        try {
            B1 b1 = (B1) interfaceC3352tc.get(C0033Bh.c);
            if (b1 != null) {
                b1.e(interfaceC3352tc, th);
            } else {
                It.D(interfaceC3352tc, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                AbstractC3365tp.b(runtimeException, th);
                th = runtimeException;
            }
            It.D(interfaceC3352tc, th);
        }
    }

    public static int B(int i2) {
        if (i2 == 1) {
            return 0;
        }
        if (i2 == 2) {
            return 1;
        }
        if (i2 == 4) {
            return 2;
        }
        if (i2 == 8) {
            return 3;
        }
        if (i2 == 16) {
            return 4;
        }
        if (i2 == 32) {
            return 5;
        }
        if (i2 == 64) {
            return 6;
        }
        if (i2 == 128) {
            return 7;
        }
        if (i2 == 256) {
            return 8;
        }
        throw new IllegalArgumentException(AbstractC0041Bp.j(i2, "type needs to be >= FIRST and <= LAST, type="));
    }

    public static final void C(InterfaceC3121p8 interfaceC3121p8, InterfaceC2803j8 interfaceC2803j8) {
        if (!(interfaceC3121p8 instanceof C3226r8)) {
            throw new UnsupportedOperationException("third-party implementation of CancellableContinuation is not supported");
        }
        ((C3226r8) interfaceC3121p8).v(interfaceC2803j8);
    }

    public static boolean D(int i2) {
        return i2 >= 28 && i2 <= 31;
    }

    public static boolean E(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean F(int i2, Object obj) {
        if (obj instanceof InterfaceC0327Um) {
            return (obj instanceof InterfaceC2519dn ? ((InterfaceC2519dn) obj).getArity() : obj instanceof InterfaceC0070Dm ? 0 : obj instanceof InterfaceC0102Fm ? 1 : obj instanceof InterfaceC0312Tm ? 2 : obj instanceof InterfaceC0342Vm ? 3 : -1) == i2;
        }
        return false;
    }

    public static ValueAnimator G(Context context, Resources resources, Resources.Theme theme, AttributeSet attributeSet, ObjectAnimator objectAnimator, XmlResourceParser xmlResourceParser) {
        ValueAnimator valueAnimator;
        TypedArray typedArray;
        TypedArray typedArray2;
        ValueAnimator valueAnimator2;
        int i2 = 0;
        TypedArray Y = AbstractC3365tp.Y(resources, theme, attributeSet, AbstractC3192qa.h);
        TypedArray Y2 = AbstractC3365tp.Y(resources, theme, attributeSet, AbstractC3192qa.l);
        ValueAnimator valueAnimator3 = objectAnimator == null ? new ValueAnimator() : objectAnimator;
        long j2 = AbstractC3365tp.P(xmlResourceParser, "duration") ? Y.getInt(1, 300) : 300;
        long j3 = !AbstractC3365tp.P(xmlResourceParser, "startOffset") ? 0 : Y.getInt(2, 0);
        int i3 = !AbstractC3365tp.P(xmlResourceParser, "valueType") ? 4 : Y.getInt(7, 4);
        if (AbstractC3365tp.P(xmlResourceParser, "valueFrom") && AbstractC3365tp.P(xmlResourceParser, "valueTo")) {
            if (i3 == 4) {
                TypedValue peekValue = Y.peekValue(5);
                boolean z = peekValue != null;
                int i4 = z ? peekValue.type : 0;
                TypedValue peekValue2 = Y.peekValue(6);
                boolean z2 = peekValue2 != null;
                i3 = ((z && D(i4)) || (z2 && D(z2 ? peekValue2.type : 0))) ? 3 : 0;
            }
            PropertyValuesHolder w = w(Y, i3, 5, 6, "");
            if (w != null) {
                valueAnimator3.setValues(w);
            }
        }
        valueAnimator3.setDuration(j2);
        valueAnimator3.setStartDelay(j3);
        valueAnimator3.setRepeatCount(!AbstractC3365tp.P(xmlResourceParser, "repeatCount") ? 0 : Y.getInt(3, 0));
        valueAnimator3.setRepeatMode(!AbstractC3365tp.P(xmlResourceParser, "repeatMode") ? 1 : Y.getInt(4, 1));
        if (Y2 != null) {
            ObjectAnimator objectAnimator2 = (ObjectAnimator) valueAnimator3;
            String K = AbstractC3365tp.K(Y2, xmlResourceParser, "pathData", 1);
            if (K != null) {
                String K2 = AbstractC3365tp.K(Y2, xmlResourceParser, "propertyXName", 2);
                String K3 = AbstractC3365tp.K(Y2, xmlResourceParser, "propertyYName", 3);
                if (K2 == null && K3 == null) {
                    throw new InflateException(Y2.getPositionDescription() + " propertyXName or propertyYName is needed for PathData");
                }
                Path k2 = AbstractC3192qa.k(K);
                PathMeasure pathMeasure = new PathMeasure(k2, false);
                ArrayList arrayList = new ArrayList();
                arrayList.add(Float.valueOf(0.0f));
                float f2 = 0.0f;
                while (true) {
                    f2 += pathMeasure.getLength();
                    arrayList.add(Float.valueOf(f2));
                    if (!pathMeasure.nextContour()) {
                        break;
                    }
                    valueAnimator3 = valueAnimator3;
                }
                PathMeasure pathMeasure2 = new PathMeasure(k2, false);
                int min = Math.min(100, ((int) (f2 / 0.5f)) + 1);
                float[] fArr = new float[min];
                float[] fArr2 = new float[min];
                float[] fArr3 = new float[2];
                float f3 = f2 / (min - 1);
                valueAnimator = valueAnimator3;
                typedArray = Y;
                int i5 = 0;
                int i6 = 0;
                float f4 = 0.0f;
                while (true) {
                    if (i6 >= min) {
                        break;
                    }
                    int i7 = min;
                    pathMeasure2.getPosTan(f4 - ((Float) arrayList.get(i5)).floatValue(), fArr3, null);
                    fArr[i6] = fArr3[0];
                    fArr2[i6] = fArr3[1];
                    f4 += f3;
                    int i8 = i5 + 1;
                    if (i8 < arrayList.size() && f4 > ((Float) arrayList.get(i8)).floatValue()) {
                        pathMeasure2.nextContour();
                        i5 = i8;
                    }
                    i6++;
                    min = i7;
                }
                PropertyValuesHolder ofFloat = K2 != null ? PropertyValuesHolder.ofFloat(K2, fArr) : null;
                PropertyValuesHolder ofFloat2 = K3 != null ? PropertyValuesHolder.ofFloat(K3, fArr2) : null;
                if (ofFloat == null) {
                    i2 = 0;
                    objectAnimator2.setValues(ofFloat2);
                } else {
                    i2 = 0;
                    if (ofFloat2 == null) {
                        objectAnimator2.setValues(ofFloat);
                    } else {
                        objectAnimator2.setValues(ofFloat, ofFloat2);
                    }
                }
            } else {
                valueAnimator = valueAnimator3;
                typedArray = Y;
                objectAnimator2.setPropertyName(AbstractC3365tp.K(Y2, xmlResourceParser, "propertyName", 0));
            }
        } else {
            valueAnimator = valueAnimator3;
            typedArray = Y;
        }
        if (AbstractC3365tp.P(xmlResourceParser, "interpolator")) {
            typedArray2 = typedArray;
            i2 = typedArray2.getResourceId(i2, i2);
        } else {
            typedArray2 = typedArray;
        }
        if (i2 > 0) {
            valueAnimator2 = valueAnimator;
            valueAnimator2.setInterpolator(AnimationUtils.loadInterpolator(context, i2));
        } else {
            valueAnimator2 = valueAnimator;
        }
        typedArray2.recycle();
        if (Y2 != null) {
            Y2.recycle();
        }
        return valueAnimator2;
    }

    public static String H(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(str.charAt(i2));
            if (str2.length() > i2) {
                sb.append(str2.charAt(i2));
            }
        }
        return sb.toString();
    }

    public static MappedByteBuffer I(Context context, Uri uri) {
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(openFileDescriptor.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    openFileDescriptor.close();
                    return map;
                } finally {
                }
            } catch (Throwable th) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static void J(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    public static final Object K(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [Du, W9] */
    public static Du L(MappedByteBuffer mappedByteBuffer) {
        long j2;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i2 = duplicate.getShort() & 65535;
        if (i2 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        duplicate.position(duplicate.position() + 6);
        int i3 = 0;
        while (true) {
            if (i3 >= i2) {
                j2 = -1;
                break;
            }
            int i4 = duplicate.getInt();
            duplicate.position(duplicate.position() + 4);
            j2 = duplicate.getInt() & 4294967295L;
            duplicate.position(duplicate.position() + 4);
            if (1835365473 == i4) {
                break;
            }
            i3++;
        }
        if (j2 != -1) {
            duplicate.position(duplicate.position() + ((int) (j2 - duplicate.position())));
            duplicate.position(duplicate.position() + 12);
            long j3 = duplicate.getInt() & 4294967295L;
            for (int i5 = 0; i5 < j3; i5++) {
                int i6 = duplicate.getInt();
                long j4 = duplicate.getInt() & 4294967295L;
                duplicate.getInt();
                if (1164798569 == i6 || 1701669481 == i6) {
                    duplicate.position((int) (j4 + j2));
                    ?? w9 = new W9(2);
                    duplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int position = duplicate.position() + duplicate.getInt(duplicate.position());
                    w9.d = duplicate;
                    w9.a = position;
                    int i7 = position - duplicate.getInt(position);
                    w9.b = i7;
                    w9.c = ((ByteBuffer) w9.d).getShort(i7);
                    return w9;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static String M(Context context, String str) {
        InputStream open = context.getResources().getAssets().open(str);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[Opcodes.ACC_SYNTHETIC];
            while (true) {
                int read = bufferedReader.read(cArr, 0, Opcodes.ACC_SYNTHETIC);
                if (read <= 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } finally {
            open.close();
        }
    }

    public static void N(ViewGroup viewGroup, boolean z) {
        if (Build.VERSION.SDK_INT >= 29) {
            AbstractC3397uK.b(viewGroup, z);
        } else if (o) {
            try {
                AbstractC3397uK.b(viewGroup, z);
            } catch (NoSuchMethodError unused) {
                o = false;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [ep, cp] */
    public static C2573ep O(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new C2468cp(i2, i3 - 1, 1);
        }
        C2573ep c2573ep = C2573ep.d;
        return C2573ep.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x01d1, code lost:
    
        if (r7 == null) goto L135;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:241:0x010d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0304 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ed A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v80, types: [tg[], java.io.Serializable] */
    /* JADX WARN: Type inference failed for: r8v0, types: [oy] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void P(android.content.Context r18, java.util.concurrent.Executor r19, defpackage.InterfaceC3110oy r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC2866kI.P(android.content.Context, java.util.concurrent.Executor, oy, boolean):void");
    }

    public static Tu Q(zzahy zzahyVar) {
        if (zzahyVar == null) {
            return null;
        }
        if (TextUtils.isEmpty(zzahyVar.zze())) {
            if (zzahyVar.zzb() != null) {
                return new HH(zzahyVar.zzd(), zzahyVar.zzc(), zzahyVar.zza(), (zzaiz) Preconditions.checkNotNull(zzahyVar.zzb(), "totpInfo cannot be null."));
            }
            return null;
        }
        return new C3003mx(zzahyVar.zza(), zzahyVar.zzd(), zzahyVar.zzc(), Preconditions.checkNotEmpty(zzahyVar.zze()));
    }

    public static ArrayList R(List list) {
        if (list == null || list.isEmpty()) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Tu Q = Q((zzahy) it.next());
            if (Q != null) {
                arrayList.add(Q);
            }
        }
        return arrayList;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [iq, ta] */
    public static C3350ta a() {
        ?? c2785iq = new C2785iq(true);
        c2785iq.B(null);
        return c2785iq;
    }

    public static void b(int i2, Object obj) {
        if (obj == null || F(i2, obj)) {
            return;
        }
        ClassCastException classCastException = new ClassCastException(AbstractC3603yE.h(obj.getClass().getName(), " cannot be cast to ", AbstractC0041Bp.j(i2, "kotlin.jvm.functions.Function")));
        AbstractC3365tp.e0(classCastException, AbstractC2866kI.class.getName());
        throw classCastException;
    }

    public static final int c(int[] iArr, int i2, int i3) {
        AbstractC3365tp.q(iArr, "array");
        int i4 = i2 - 1;
        int i5 = 0;
        while (i5 <= i4) {
            int i6 = (i5 + i4) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i3) {
                i5 = i6 + 1;
            } else {
                if (i7 <= i3) {
                    return i6;
                }
                i4 = i6 - 1;
            }
        }
        return ~i5;
    }

    public static final int d(long[] jArr, int i2, long j2) {
        AbstractC3365tp.q(jArr, "array");
        int i3 = i2 - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            long j3 = jArr[i5];
            if (j3 < j2) {
                i4 = i5 + 1;
            } else {
                if (j3 <= j2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static final void e(int i2) {
        new Integer(i2);
    }

    public static final void f(InterfaceC0102Fm interfaceC0102Fm, Object obj, InterfaceC3352tc interfaceC3352tc) {
        C3562xa g2 = g(interfaceC0102Fm, obj, null);
        if (g2 != null) {
            A(interfaceC3352tc, g2);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [xa, java.lang.RuntimeException] */
    public static final C3562xa g(InterfaceC0102Fm interfaceC0102Fm, Object obj, C3562xa c3562xa) {
        try {
            interfaceC0102Fm.invoke(obj);
        } catch (Throwable th) {
            if (c3562xa == null || c3562xa.getCause() == th) {
                return new RuntimeException("Exception in undelivered element handler for " + obj, th);
            }
            AbstractC3365tp.b(c3562xa, th);
        }
        return c3562xa;
    }

    public static void h(String str, boolean z) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void i(int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void k(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static long l(long j2) {
        if (j2 < -4611686018427387903L) {
            return -4611686018427387903L;
        }
        if (j2 > 4611686018427387903L) {
            return 4611686018427387903L;
        }
        return j2;
    }

    public static boolean m(File file, Resources resources, int i2) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i2);
            try {
                boolean n2 = n(file, inputStream);
                k(inputStream);
                return n2;
            } catch (Throwable th) {
                th = th;
                k(inputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    public static boolean n(File file, InputStream inputStream) {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    k(fileOutputStream);
                    StrictMode.setThreadPolicy(allowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            k(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            k(fileOutputStream2);
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v1, types: [Hh, nl] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.C3044nl o(android.content.Context r8) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 28
            if (r0 < r1) goto Le
            pf r0 = new pf
            r1 = 12
            r0.<init>(r1)
            goto L15
        Le:
            Bh r0 = new Bh
            r1 = 12
            r0.<init>(r1)
        L15:
            android.content.pm.PackageManager r1 = r8.getPackageManager()
            java.lang.String r2 = "Package manager required to locate emoji font provider"
            j(r1, r2)
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r3 = "androidx.content.action.LOAD_EMOJI_FONT"
            r2.<init>(r3)
            r3 = 0
            java.util.List r2 = r1.queryIntentContentProviders(r2, r3)
            java.util.Iterator r2 = r2.iterator()
        L2e:
            boolean r4 = r2.hasNext()
            r5 = 0
            if (r4 == 0) goto L4a
            java.lang.Object r4 = r2.next()
            android.content.pm.ResolveInfo r4 = (android.content.pm.ResolveInfo) r4
            android.content.pm.ProviderInfo r4 = r4.providerInfo
            if (r4 == 0) goto L2e
            android.content.pm.ApplicationInfo r6 = r4.applicationInfo
            if (r6 == 0) goto L2e
            int r6 = r6.flags
            r7 = 1
            r6 = r6 & r7
            if (r6 != r7) goto L2e
            goto L4b
        L4a:
            r4 = r5
        L4b:
            if (r4 != 0) goto L4f
        L4d:
            r1 = r5
            goto L7e
        L4f:
            java.lang.String r2 = r4.authority     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            java.lang.String r4 = r4.packageName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            android.content.pm.Signature[] r0 = r0.t(r1, r4)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            r1.<init>()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            int r6 = r0.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
        L5d:
            if (r3 >= r6) goto L6b
            r7 = r0[r3]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            r1.add(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            int r3 = r3 + 1
            goto L5d
        L6b:
            java.util.List r0 = java.util.Collections.singletonList(r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            ll r1 = new ll     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            java.lang.String r3 = "emojicompat-emoji-font"
            r1.<init>(r2, r4, r3, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L77
            goto L7e
        L77:
            r0 = move-exception
            java.lang.String r1 = "emoji2.text.DefaultEmojiConfig"
            android.util.Log.wtf(r1, r0)
            goto L4d
        L7e:
            if (r1 != 0) goto L81
            goto L8b
        L81:
            nl r5 = new nl
            ml r0 = new ml
            r0.<init>(r8, r1)
            r5.<init>(r0)
        L8b:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC2866kI.o(android.content.Context):nl");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x03a5, code lost:
    
        r1 = new android.animation.Animator[r13.size()];
        r3 = r13.iterator();
        r14 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x03b4, code lost:
    
        if (r3.hasNext() == false) goto L217;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x03b6, code lost:
    
        r1[r14] = (android.animation.Animator) r3.next();
        r14 = r14 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x03c2, code lost:
    
        if (r32 != 0) goto L208;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x03c4, code lost:
    
        r31.playTogether(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x03c8, code lost:
    
        r31.playSequentially(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x03cb, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x03a1, code lost:
    
        if (r31 == null) goto L209;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x03a3, code lost:
    
        if (r13 == null) goto L209;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.animation.Animator p(android.content.Context r26, android.content.res.Resources r27, android.content.res.Resources.Theme r28, android.content.res.XmlResourceParser r29, android.util.AttributeSet r30, android.animation.AnimatorSet r31, int r32) {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC2866kI.p(android.content.Context, android.content.res.Resources, android.content.res.Resources$Theme, android.content.res.XmlResourceParser, android.util.AttributeSet, android.animation.AnimatorSet, int):android.animation.Animator");
    }

    public static AbstractC3556xK q(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(null);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new RuntimeException("Cannot create an instance of " + cls);
            }
            try {
                Object newInstance = declaredConstructor.newInstance(null);
                AbstractC3365tp.m(newInstance);
                return (AbstractC3556xK) newInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }

    public static void r(String str, String str2, Object obj) {
        String y = y(str);
        if (Log.isLoggable(y, 3)) {
            Log.d(y, String.format(str2, obj));
        }
    }

    public static void s(Exception exc, String str, String str2) {
        String y = y(str);
        if (Log.isLoggable(y, 6)) {
            Log.e(y, str2, exc);
        }
    }

    public static String t(R7 r7) {
        String str;
        StringBuilder sb = new StringBuilder(r7.size());
        for (int i2 = 0; i2 < r7.size(); i2++) {
            int a2 = r7.a(i2);
            if (a2 == 34) {
                str = "\\\"";
            } else if (a2 == 39) {
                str = "\\'";
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        str = "\\a";
                        break;
                    case 8:
                        str = "\\b";
                        break;
                    case 9:
                        str = "\\t";
                        break;
                    case 10:
                        str = "\\n";
                        break;
                    case 11:
                        str = "\\v";
                        break;
                    case 12:
                        str = "\\f";
                        break;
                    case 13:
                        str = "\\r";
                        break;
                    default:
                        if (a2 < 32 || a2 > 126) {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            a2 = (a2 & 7) + 48;
                        }
                        sb.append((char) a2);
                        continue;
                }
            } else {
                str = "\\\\";
            }
            sb.append(str);
        }
        return sb.toString();
    }

    public static Object u(Future future) {
        Object obj;
        boolean z = false;
        if (!future.isDone()) {
            throw new IllegalStateException(AbstractC2555eN.A("Future was expected to be done: %s", future));
        }
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public static final C3226r8 v(InterfaceC2560ec interfaceC2560ec) {
        C3226r8 c3226r8;
        C3226r8 c3226r82;
        if (!(interfaceC2560ec instanceof C0111Gg)) {
            return new C3226r8(1, interfaceC2560ec);
        }
        C0111Gg c0111Gg = (C0111Gg) interfaceC2560ec;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C0111Gg.n;
            Object obj = atomicReferenceFieldUpdater.get(c0111Gg);
            C0367Xh c0367Xh = AbstractC3090oe.g;
            c3226r8 = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(c0111Gg, c0367Xh);
                c3226r82 = null;
                break;
            }
            if (obj instanceof C3226r8) {
                while (!atomicReferenceFieldUpdater.compareAndSet(c0111Gg, obj, c0367Xh)) {
                    if (atomicReferenceFieldUpdater.get(c0111Gg) != obj) {
                        break;
                    }
                }
                c3226r82 = (C3226r8) obj;
                break loop0;
            }
            if (obj != c0367Xh && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c3226r82 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C3226r8.m;
            Object obj2 = atomicReferenceFieldUpdater2.get(c3226r82);
            if (!(obj2 instanceof C3403ua) || ((C3403ua) obj2).d == null) {
                C3226r8.f.set(c3226r82, 536870911);
                atomicReferenceFieldUpdater2.set(c3226r82, G0.a);
                c3226r8 = c3226r82;
            } else {
                c3226r82.o();
            }
            if (c3226r8 != null) {
                return c3226r8;
            }
        }
        return new C3226r8(2, interfaceC2560ec);
    }

    /* JADX WARN: Type inference failed for: r11v26, types: [android.animation.TypeEvaluator, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [android.animation.TypeEvaluator, java.lang.Object] */
    public static PropertyValuesHolder w(TypedArray typedArray, int i2, int i3, int i4, String str) {
        PropertyValuesHolder ofFloat;
        PropertyValuesHolder ofObject;
        TypedValue peekValue = typedArray.peekValue(i3);
        boolean z = peekValue != null;
        int i5 = z ? peekValue.type : 0;
        TypedValue peekValue2 = typedArray.peekValue(i4);
        boolean z2 = peekValue2 != null;
        int i6 = z2 ? peekValue2.type : 0;
        if (i2 == 4) {
            i2 = ((z && D(i5)) || (z2 && D(i6))) ? 3 : 0;
        }
        boolean z3 = i2 == 0;
        PropertyValuesHolder propertyValuesHolder = null;
        if (i2 == 2) {
            String string = typedArray.getString(i3);
            String string2 = typedArray.getString(i4);
            C2740hx[] j2 = AbstractC3192qa.j(string);
            C2740hx[] j3 = AbstractC3192qa.j(string2);
            if (j2 == null && j3 == null) {
                return null;
            }
            if (j2 == null) {
                if (j3 != null) {
                    return PropertyValuesHolder.ofObject(str, (TypeEvaluator) new Object(), j3);
                }
                return null;
            }
            ?? obj = new Object();
            if (j3 == null) {
                ofObject = PropertyValuesHolder.ofObject(str, (TypeEvaluator) obj, j2);
            } else {
                if (!AbstractC3192qa.c(j2, j3)) {
                    throw new InflateException(AbstractC3603yE.i(" Can't morph from ", string, " to ", string2));
                }
                ofObject = PropertyValuesHolder.ofObject(str, (TypeEvaluator) obj, j2, j3);
            }
            return ofObject;
        }
        J3 j32 = i2 == 3 ? J3.a : null;
        if (z3) {
            if (z) {
                float dimension = i5 == 5 ? typedArray.getDimension(i3, 0.0f) : typedArray.getFloat(i3, 0.0f);
                if (z2) {
                    ofFloat = PropertyValuesHolder.ofFloat(str, dimension, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
                } else {
                    ofFloat = PropertyValuesHolder.ofFloat(str, dimension);
                }
            } else {
                ofFloat = PropertyValuesHolder.ofFloat(str, i6 == 5 ? typedArray.getDimension(i4, 0.0f) : typedArray.getFloat(i4, 0.0f));
            }
            propertyValuesHolder = ofFloat;
        } else if (z) {
            int dimension2 = i5 == 5 ? (int) typedArray.getDimension(i3, 0.0f) : D(i5) ? typedArray.getColor(i3, 0) : typedArray.getInt(i3, 0);
            if (z2) {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : D(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
            } else {
                propertyValuesHolder = PropertyValuesHolder.ofInt(str, dimension2);
            }
        } else if (z2) {
            propertyValuesHolder = PropertyValuesHolder.ofInt(str, i6 == 5 ? (int) typedArray.getDimension(i4, 0.0f) : D(i6) ? typedArray.getColor(i4, 0) : typedArray.getInt(i4, 0));
        }
        if (propertyValuesHolder == null || j32 == null) {
            return propertyValuesHolder;
        }
        propertyValuesHolder.setEvaluator(j32);
        return propertyValuesHolder;
    }

    public static final Bundle x(Bundle bundle, String str) {
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        throw new IllegalArgumentException(AbstractC3603yE.x("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
    }

    public static String y(String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            return "TRuntime.".concat(str);
        }
        String concat = "TRuntime.".concat(str);
        return concat.length() > 23 ? concat.substring(0, 23) : concat;
    }

    public static File z(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i2 = 0; i2 < 100; i2++) {
            File file = new File(cacheDir, str + i2);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }
}
