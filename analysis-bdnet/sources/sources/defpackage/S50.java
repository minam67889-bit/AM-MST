package defpackage;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import com.google.android.gms.tasks.Task;
import dastan.prince.bdfreevpn.R;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CancellationException;
import org.chromium.base.metrics.ScopedSysTraceEvent;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.utils.PUtils;

/* loaded from: classes.dex */
public abstract class S50 {
    public static boolean A;
    public static Class B;
    public static boolean C;
    public static Field D;
    public static boolean E;
    public static Field F;
    public static boolean G;
    public static final C2853d6 d;
    public static C2853d6 e;
    public static final S40 l;
    public static final S40 m;
    public static final S40 n;
    public static final S40 o;
    public static final S40 p;
    public static boolean v;
    public static Method w;
    public static boolean x;
    public static Field y;
    public static Field z;
    public static final Q2 a = new Q2("RESUME_TOKEN", 5);
    public static final Q2 b = new Q2("REMOVED_TASK", 5);
    public static final Q2 c = new Q2("CLOSED_EMPTY", 5);
    public static final Q2 f = new Q2("STATE_REG", 5);
    public static final Q2 g = new Q2("STATE_COMPLETED", 5);
    public static final Q2 h = new Q2("STATE_CANCELLED", 5);
    public static final Q2 i = new Q2("NO_RESULT", 5);
    public static final Q2 j = new Q2("PARAM_CLAUSE_0", 5);
    public static final S40 k = new S40(1, 2, 0);
    public static final S40 q = new S40(11, 12, 6);
    public static final T50 r = new T50(10);
    public static final T50 s = new T50(19);
    public static final C4084sd0 t = new C4084sd0(0);
    public static final C4084sd0 u = new C4084sd0(9);

    static {
        Object obj = null;
        d = new C2853d6(obj, obj, obj, 29);
        int i2 = 4;
        l = new S40(3, i2, 1);
        m = new S40(i2, 5, 2);
        int i3 = 7;
        n = new S40(6, i3, 3);
        int i4 = 8;
        o = new S40(i3, i4, 4);
        p = new S40(i4, 9, 5);
    }

    public static int A(Object obj, InterfaceC4620zQ interfaceC4620zQ, byte[] bArr, int i2, int i3, int i4, C4201u6 c4201u6) {
        OF of = (OF) interfaceC4620zQ;
        int i5 = c4201u6.d + 1;
        c4201u6.d = i5;
        if (i5 >= 100) {
            throw new C4107sy("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int F2 = of.F(obj, bArr, i2, i3, i4, c4201u6);
        c4201u6.d--;
        c4201u6.c = obj;
        return F2;
    }

    public static int B(Object obj, InterfaceC4620zQ interfaceC4620zQ, byte[] bArr, int i2, int i3, C4201u6 c4201u6) {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = k(i5, bArr, i4, c4201u6);
            i5 = c4201u6.a;
        }
        int i6 = i4;
        if (i5 < 0 || i5 > i3 - i6) {
            throw C4107sy.e();
        }
        int i7 = c4201u6.d + 1;
        c4201u6.d = i7;
        if (i7 >= 100) {
            throw new C4107sy("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i8 = i6 + i5;
        interfaceC4620zQ.g(obj, bArr, i6, i8, c4201u6);
        c4201u6.d--;
        c4201u6.c = obj;
        return i8;
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x014a, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C4218uJ C(C4316vb... c4316vbArr) {
        int i2;
        int i3 = 0;
        if (c4316vbArr.length == 0) {
            return new C4218uJ(new C4316vb[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(new C4122t6(c4316vbArr, false));
        if (arrayList.size() > 1) {
            Collections.sort(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(c4316vbArr.length);
        for (C4316vb c4316vb : c4316vbArr) {
            arrayList2.add(-1);
        }
        Integer[] numArr = (Integer[]) arrayList2.toArray(new Integer[0]);
        Object[] copyOf = Arrays.copyOf(numArr, numArr.length);
        AbstractC3634my.g(copyOf, "elements");
        ArrayList arrayList3 = copyOf.length == 0 ? new ArrayList() : new ArrayList(new C4122t6(copyOf, true));
        int length = c4316vbArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            C4316vb c4316vb2 = c4316vbArr[i4];
            int i6 = i5 + 1;
            int size = arrayList.size();
            int size2 = arrayList.size();
            if (size < 0) {
                throw new IllegalArgumentException(W50.j(size, "fromIndex (0) is greater than toIndex (", ")."));
            }
            if (size > size2) {
                throw new IndexOutOfBoundsException("toIndex (" + size + ") is greater than size (" + size2 + ").");
            }
            int i7 = size - 1;
            int i8 = 0;
            while (true) {
                if (i8 > i7) {
                    i2 = -(i8 + 1);
                    break;
                }
                i2 = (i8 + i7) >>> 1;
                int i9 = AbstractC3634my.i((Comparable) arrayList.get(i2), c4316vb2);
                if (i9 < 0) {
                    i8 = i2 + 1;
                } else if (i9 > 0) {
                    i7 = i2 - 1;
                }
            }
            arrayList3.set(i2, Integer.valueOf(i5));
            i4++;
            i5 = i6;
        }
        if (((C4316vb) arrayList.get(0)).c() <= 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i10 = 0;
        while (i10 < arrayList.size()) {
            C4316vb c4316vb3 = (C4316vb) arrayList.get(i10);
            int i11 = i10 + 1;
            int i12 = i11;
            while (i12 < arrayList.size()) {
                C4316vb c4316vb4 = (C4316vb) arrayList.get(i12);
                c4316vb4.getClass();
                AbstractC3634my.g(c4316vb3, "prefix");
                if (c4316vb4.h(c4316vb3, c4316vb3.c())) {
                    if (c4316vb4.c() == c4316vb3.c()) {
                        throw new IllegalArgumentException(("duplicate option: " + c4316vb4).toString());
                    }
                    if (((Number) arrayList3.get(i12)).intValue() > ((Number) arrayList3.get(i10)).intValue()) {
                        arrayList.remove(i12);
                        arrayList3.remove(i12);
                    } else {
                        i12++;
                    }
                }
            }
            i10 = i11;
        }
        C0451Ra c0451Ra = new C0451Ra();
        b(0L, c0451Ra, 0, arrayList, 0, arrayList.size(), arrayList3);
        int[] iArr = new int[(int) (c0451Ra.b / 4)];
        while (!c0451Ra.b()) {
            iArr[i3] = c0451Ra.k();
            i3++;
        }
        Object[] copyOf2 = Arrays.copyOf(c4316vbArr, c4316vbArr.length);
        AbstractC3634my.f(copyOf2, "copyOf(this, size)");
        return new C4218uJ((C4316vb[]) copyOf2, iArr);
    }

    public static String D(Context context, String str) {
        InputStream open = context.getResources().getAssets().open(str);
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            StringBuilder sb = new StringBuilder();
            char[] cArr = new char[4096];
            while (true) {
                int read = bufferedReader.read(cArr, 0, 4096);
                if (read <= 0) {
                    return sb.toString();
                }
                sb.append(cArr, 0, read);
            }
        } finally {
            open.close();
        }
    }

    public static Set E(Object obj) {
        Set singleton = Collections.singleton(obj);
        AbstractC3634my.f(singleton, "singleton(...)");
        return singleton;
    }

    public static void F(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            AbstractC4311vX.a(view, charSequence);
            return;
        }
        ViewOnLongClickListenerC4469xX viewOnLongClickListenerC4469xX = ViewOnLongClickListenerC4469xX.k;
        if (viewOnLongClickListenerC4469xX != null && viewOnLongClickListenerC4469xX.a == view) {
            ViewOnLongClickListenerC4469xX.b(null);
        }
        if (!TextUtils.isEmpty(charSequence)) {
            new ViewOnLongClickListenerC4469xX(view, charSequence);
            return;
        }
        ViewOnLongClickListenerC4469xX viewOnLongClickListenerC4469xX2 = ViewOnLongClickListenerC4469xX.l;
        if (viewOnLongClickListenerC4469xX2 != null && viewOnLongClickListenerC4469xX2.a == view) {
            viewOnLongClickListenerC4469xX2.a();
        }
        view.setOnLongClickListener(null);
        view.setLongClickable(false);
        view.setOnHoverListener(null);
    }

    public static boolean H(int i2, int i3, int i4, int i5) {
        return (i4 == 1 || i4 == 2 || (i4 == 4 && i2 != 2)) || (i5 == 1 || i5 == 2 || (i5 == 4 && i3 != 2));
    }

    public static final Object I(InterfaceC0613Xg interfaceC0613Xg, Object obj, Object obj2, InterfaceC3233hu interfaceC3233hu, InterfaceC0198Hg interfaceC0198Hg) {
        Object invoke;
        Object h0 = AbstractC0538Uj.h0(interfaceC0613Xg, obj2);
        try {
            CU cu = new CU(interfaceC0198Hg, interfaceC0613Xg);
            if (interfaceC3233hu == null) {
                AbstractC3634my.g(interfaceC3233hu, "<this>");
                InterfaceC0613Xg context = cu.getContext();
                Object c3713ny = context == C0912co.a ? new C3713ny(cu) : new C3792oy(cu, context);
                AbstractC0731aZ.e(2, interfaceC3233hu);
                invoke = interfaceC3233hu.invoke(obj, c3713ny);
            } else {
                AbstractC0731aZ.e(2, interfaceC3233hu);
                invoke = interfaceC3233hu.invoke(obj, cu);
            }
            AbstractC0538Uj.N(interfaceC0613Xg, h0);
            if (invoke == EnumC3299ih.a) {
                AbstractC3634my.g(interfaceC0198Hg, "frame");
            }
            return invoke;
        } catch (Throwable th) {
            AbstractC0538Uj.N(interfaceC0613Xg, h0);
            throw th;
        }
    }

    public static final Object a(Task task, C0033Ax c0033Ax) {
        if (!task.isComplete()) {
            C0582Wb c0582Wb = new C0582Wb(1, w(c0033Ax));
            c0582Wb.s();
            task.addOnCompleteListener(ExecutorC4094sl.b, new WT(c0582Wb));
            Object r2 = c0582Wb.r();
            EnumC3299ih enumC3299ih = EnumC3299ih.a;
            return r2;
        }
        Exception exception = task.getException();
        if (exception != null) {
            throw exception;
        }
        if (!task.isCanceled()) {
            return task.getResult();
        }
        throw new CancellationException("Task " + task + " was cancelled normally.");
    }

    public static void b(long j2, C0451Ra c0451Ra, int i2, ArrayList arrayList, int i3, int i4, ArrayList arrayList2) {
        int i5;
        int i6;
        ArrayList arrayList3;
        long j3;
        int i7;
        int i8 = i2;
        ArrayList arrayList4 = arrayList;
        ArrayList arrayList5 = arrayList2;
        if (i3 >= i4) {
            throw new IllegalArgumentException("Failed requirement.");
        }
        for (int i9 = i3; i9 < i4; i9++) {
            if (((C4316vb) arrayList4.get(i9)).c() < i8) {
                throw new IllegalArgumentException("Failed requirement.");
            }
        }
        C4316vb c4316vb = (C4316vb) arrayList.get(i3);
        C4316vb c4316vb2 = (C4316vb) arrayList4.get(i4 - 1);
        if (i8 == c4316vb.c()) {
            int intValue = ((Number) arrayList5.get(i3)).intValue();
            int i10 = i3 + 1;
            C4316vb c4316vb3 = (C4316vb) arrayList4.get(i10);
            i5 = i10;
            i6 = intValue;
            c4316vb = c4316vb3;
        } else {
            i5 = i3;
            i6 = -1;
        }
        if (c4316vb.f(i8) == c4316vb2.f(i8)) {
            int min = Math.min(c4316vb.c(), c4316vb2.c());
            int i11 = 0;
            for (int i12 = i8; i12 < min && c4316vb.f(i12) == c4316vb2.f(i12); i12++) {
                i11++;
            }
            long j4 = 4;
            long j5 = (c0451Ra.b / j4) + j2 + 2 + i11 + 1;
            c0451Ra.A(-i11);
            c0451Ra.A(i6);
            int i13 = i8 + i11;
            while (i8 < i13) {
                c0451Ra.A(c4316vb.f(i8) & 255);
                i8++;
            }
            if (i5 + 1 == i4) {
                if (i13 != ((C4316vb) arrayList4.get(i5)).c()) {
                    throw new IllegalStateException("Check failed.");
                }
                c0451Ra.A(((Number) arrayList5.get(i5)).intValue());
                return;
            } else {
                C0451Ra c0451Ra2 = new C0451Ra();
                c0451Ra.A(((int) ((c0451Ra2.b / j4) + j5)) * (-1));
                b(j5, c0451Ra2, i13, arrayList4, i5, i4, arrayList5);
                c0451Ra.x(c0451Ra2);
                return;
            }
        }
        int i14 = 1;
        for (int i15 = i5 + 1; i15 < i4; i15++) {
            if (((C4316vb) arrayList4.get(i15 - 1)).f(i8) != ((C4316vb) arrayList4.get(i15)).f(i8)) {
                i14++;
            }
        }
        long j6 = 4;
        long j7 = (c0451Ra.b / j6) + j2 + 2 + (i14 * 2);
        c0451Ra.A(i14);
        c0451Ra.A(i6);
        for (int i16 = i5; i16 < i4; i16++) {
            int f2 = ((C4316vb) arrayList4.get(i16)).f(i8);
            if (i16 == i5 || f2 != ((C4316vb) arrayList4.get(i16 - 1)).f(i8)) {
                c0451Ra.A(f2 & 255);
            }
        }
        C0451Ra c0451Ra3 = new C0451Ra();
        int i17 = i5;
        while (i17 < i4) {
            byte f3 = ((C4316vb) arrayList4.get(i17)).f(i8);
            int i18 = i17 + 1;
            int i19 = i18;
            while (true) {
                if (i19 >= i4) {
                    i19 = i4;
                    break;
                } else if (f3 != ((C4316vb) arrayList4.get(i19)).f(i8)) {
                    break;
                } else {
                    i19++;
                }
            }
            if (i18 == i19 && i8 + 1 == ((C4316vb) arrayList4.get(i17)).c()) {
                c0451Ra.A(((Number) arrayList5.get(i17)).intValue());
                arrayList3 = arrayList5;
                j3 = j7;
                i7 = i19;
            } else {
                c0451Ra.A(((int) ((c0451Ra3.b / j6) + j7)) * (-1));
                arrayList3 = arrayList5;
                j3 = j7;
                i7 = i19;
                b(j3, c0451Ra3, i8 + 1, arrayList, i17, i7, arrayList3);
                arrayList4 = arrayList;
            }
            j7 = j3;
            i17 = i7;
            arrayList5 = arrayList3;
        }
        c0451Ra.x(c0451Ra3);
    }

    public static void c(Context context) {
        String packageName = context.getPackageName();
        if (!context.getString(R.string.app).equals(Deobfuscator$BDNETVPN$app.getString(-167842358851467L))) {
            int i2 = F00.a;
            PUtils.killProcess();
        }
        if (!packageName.equals(Deobfuscator$BDNETVPN$app.getString(-167889603491723L))) {
            int i3 = F00.a;
            PUtils.killProcess();
        }
        int i4 = AbstractC0480Sd.a;
        String path = context.getFilesDir().getPath();
        if (path.contains(Deobfuscator$BDNETVPN$app.getString(-156520825059211L))) {
            int i5 = F00.a;
            PUtils.killProcess();
        } else {
            int i6 = 0;
            for (int i7 = 0; i7 < path.length() && i6 <= 3; i7++) {
                if (path.charAt(i7) == '.') {
                    i6++;
                }
            }
            if (i6 > 3) {
                int i8 = F00.a;
                PUtils.killProcess();
            }
        }
        int i9 = F00.a;
        try {
            if (!Arrays.asList(Deobfuscator$BDNETVPN$app.getString(-168246085777291L), Deobfuscator$BDNETVPN$app.getString(-168422179436427L)).contains(F00.c(context))) {
                PUtils.killProcess();
            }
        } catch (Exception unused) {
        }
        PUtils.checkSignature(context);
        if ((context.getApplicationInfo().flags & 2) != 0) {
            PUtils.killProcess();
        }
    }

    public static final double d(double d2, EnumC4016rm enumC4016rm, EnumC4016rm enumC4016rm2) {
        AbstractC3634my.g(enumC4016rm, "sourceUnit");
        AbstractC3634my.g(enumC4016rm2, "targetUnit");
        long convert = enumC4016rm2.a.convert(1L, enumC4016rm.a);
        return convert > 0 ? d2 * convert : d2 / r8.convert(1L, r9);
    }

    public static final long e(long j2, EnumC4016rm enumC4016rm, EnumC4016rm enumC4016rm2) {
        AbstractC3634my.g(enumC4016rm, "sourceUnit");
        AbstractC3634my.g(enumC4016rm2, "targetUnit");
        return enumC4016rm2.a.convert(j2, enumC4016rm.a);
    }

    public static int f(byte[] bArr, int i2, C4201u6 c4201u6) {
        int l2 = l(bArr, i2, c4201u6);
        int i3 = c4201u6.a;
        if (i3 < 0) {
            throw C4107sy.c();
        }
        if (i3 > bArr.length - l2) {
            throw C4107sy.e();
        }
        if (i3 == 0) {
            c4201u6.c = AbstractC4158tb.b;
            return l2;
        }
        c4201u6.c = AbstractC4158tb.d(bArr, l2, i3);
        return l2 + i3;
    }

    public static int g(int i2, byte[] bArr) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static long h(int i2, byte[] bArr) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static int i(InterfaceC4620zQ interfaceC4620zQ, int i2, byte[] bArr, int i3, int i4, InterfaceC0578Vx interfaceC0578Vx, C4201u6 c4201u6) {
        Object d2 = interfaceC4620zQ.d();
        InterfaceC4620zQ interfaceC4620zQ2 = interfaceC4620zQ;
        byte[] bArr2 = bArr;
        int i5 = i4;
        C4201u6 c4201u62 = c4201u6;
        int B2 = B(d2, interfaceC4620zQ2, bArr2, i3, i5, c4201u62);
        interfaceC4620zQ2.b(d2);
        c4201u62.c = d2;
        interfaceC0578Vx.add(d2);
        while (B2 < i5) {
            C4201u6 c4201u63 = c4201u62;
            int i6 = i5;
            int l2 = l(bArr2, B2, c4201u63);
            if (i2 != c4201u63.a) {
                break;
            }
            byte[] bArr3 = bArr2;
            InterfaceC4620zQ interfaceC4620zQ3 = interfaceC4620zQ2;
            Object d3 = interfaceC4620zQ3.d();
            B2 = B(d3, interfaceC4620zQ3, bArr3, l2, i6, c4201u63);
            interfaceC4620zQ2 = interfaceC4620zQ3;
            bArr2 = bArr3;
            i5 = i6;
            c4201u62 = c4201u63;
            interfaceC4620zQ2.b(d3);
            c4201u62.c = d3;
            interfaceC0578Vx.add(d3);
        }
        return B2;
    }

    public static int j(int i2, byte[] bArr, int i3, int i4, C4550yZ c4550yZ, C4201u6 c4201u6) {
        if ((i2 >>> 3) == 0) {
            throw new C4107sy("Protocol message contained an invalid tag (zero).");
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int n2 = n(bArr, i3, c4201u6);
            c4550yZ.d(i2, Long.valueOf(c4201u6.b));
            return n2;
        }
        if (i5 == 1) {
            c4550yZ.d(i2, Long.valueOf(h(i3, bArr)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int l2 = l(bArr, i3, c4201u6);
            int i6 = c4201u6.a;
            if (i6 < 0) {
                throw C4107sy.c();
            }
            if (i6 > bArr.length - l2) {
                throw C4107sy.e();
            }
            if (i6 == 0) {
                c4550yZ.d(i2, AbstractC4158tb.b);
            } else {
                c4550yZ.d(i2, AbstractC4158tb.d(bArr, l2, i6));
            }
            return l2 + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw new C4107sy("Protocol message contained an invalid tag (zero).");
            }
            c4550yZ.d(i2, Integer.valueOf(g(i3, bArr)));
            return i3 + 4;
        }
        C4550yZ c2 = C4550yZ.c();
        int i7 = (i2 & (-8)) | 4;
        int i8 = c4201u6.d + 1;
        c4201u6.d = i8;
        if (i8 >= 100) {
            throw new C4107sy("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int l3 = l(bArr, i3, c4201u6);
            int i10 = c4201u6.a;
            if (i10 == i7) {
                i9 = i10;
                i3 = l3;
                break;
            }
            i3 = j(i10, bArr, l3, i4, c2, c4201u6);
            i9 = i10;
        }
        c4201u6.d--;
        if (i3 > i4 || i9 != i7) {
            throw C4107sy.d();
        }
        c4550yZ.d(i2, c2);
        return i3;
    }

    public static int k(int i2, byte[] bArr, int i3, C4201u6 c4201u6) {
        int i4 = i2 & ScopedSysTraceEvent.MAX_SECTION_NAME_LEN;
        int i5 = i3 + 1;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            c4201u6.a = i4 | (b2 << 7);
            return i5;
        }
        int i6 = i4 | ((b2 & Byte.MAX_VALUE) << 7);
        int i7 = i3 + 2;
        byte b3 = bArr[i5];
        if (b3 >= 0) {
            c4201u6.a = i6 | (b3 << 14);
            return i7;
        }
        int i8 = i6 | ((b3 & Byte.MAX_VALUE) << 14);
        int i9 = i3 + 3;
        byte b4 = bArr[i7];
        if (b4 >= 0) {
            c4201u6.a = i8 | (b4 << 21);
            return i9;
        }
        int i10 = i8 | ((b4 & Byte.MAX_VALUE) << 21);
        int i11 = i3 + 4;
        byte b5 = bArr[i9];
        if (b5 >= 0) {
            c4201u6.a = i10 | (b5 << 28);
            return i11;
        }
        int i12 = i10 | ((b5 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i13 = i11 + 1;
            if (bArr[i11] >= 0) {
                c4201u6.a = i12;
                return i13;
            }
            i11 = i13;
        }
    }

    public static int l(byte[] bArr, int i2, C4201u6 c4201u6) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return k(b2, bArr, i3, c4201u6);
        }
        c4201u6.a = b2;
        return i3;
    }

    public static int m(int i2, byte[] bArr, int i3, int i4, InterfaceC0578Vx interfaceC0578Vx, C4201u6 c4201u6) {
        AbstractC0085Cx abstractC0085Cx = (AbstractC0085Cx) interfaceC0578Vx;
        int l2 = l(bArr, i3, c4201u6);
        abstractC0085Cx.b(c4201u6.a);
        while (l2 < i4) {
            int l3 = l(bArr, l2, c4201u6);
            if (i2 != c4201u6.a) {
                break;
            }
            l2 = l(bArr, l3, c4201u6);
            abstractC0085Cx.b(c4201u6.a);
        }
        return l2;
    }

    public static int n(byte[] bArr, int i2, C4201u6 c4201u6) {
        int i3 = i2 + 1;
        long j2 = bArr[i2];
        if (j2 >= 0) {
            c4201u6.b = j2;
            return i3;
        }
        int i4 = i2 + 2;
        byte b2 = bArr[i3];
        long j3 = (j2 & 127) | ((b2 & Byte.MAX_VALUE) << 7);
        int i5 = 7;
        while (b2 < 0) {
            int i6 = i4 + 1;
            i5 += 7;
            j3 |= (r10 & Byte.MAX_VALUE) << i5;
            b2 = bArr[i4];
            i4 = i6;
        }
        c4201u6.b = j3;
        return i4;
    }

    public static void o(ArrayList arrayList) {
        HashMap hashMap = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i2 = 0;
            if (!it.hasNext()) {
                Iterator it2 = hashMap.values().iterator();
                while (it2.hasNext()) {
                    for (C0355Ni c0355Ni : (Set) it2.next()) {
                        for (C0643Yk c0643Yk : c0355Ni.a.c) {
                            if (c0643Yk.c == 0) {
                                Set<C0355Ni> set = (Set) hashMap.get(new C0381Oi(c0643Yk.a, c0643Yk.b == 2));
                                if (set != null) {
                                    for (C0355Ni c0355Ni2 : set) {
                                        c0355Ni.b.add(c0355Ni2);
                                        c0355Ni2.c.add(c0355Ni);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = hashMap.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    C0355Ni c0355Ni3 = (C0355Ni) it4.next();
                    if (c0355Ni3.c.isEmpty()) {
                        hashSet2.add(c0355Ni3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    C0355Ni c0355Ni4 = (C0355Ni) hashSet2.iterator().next();
                    hashSet2.remove(c0355Ni4);
                    i2++;
                    Iterator it5 = c0355Ni4.b.iterator();
                    while (it5.hasNext()) {
                        C0355Ni c0355Ni5 = (C0355Ni) it5.next();
                        c0355Ni5.c.remove(c0355Ni4);
                        if (c0355Ni5.c.isEmpty()) {
                            hashSet2.add(c0355Ni5);
                        }
                    }
                }
                if (i2 == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it6 = hashSet.iterator();
                while (it6.hasNext()) {
                    C0355Ni c0355Ni6 = (C0355Ni) it6.next();
                    if (!c0355Ni6.c.isEmpty() && !c0355Ni6.b.isEmpty()) {
                        arrayList2.add(c0355Ni6.a);
                    }
                }
                throw new C0750al("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
            }
            C2976ef c2976ef = (C2976ef) it.next();
            C0355Ni c0355Ni7 = new C0355Ni(c2976ef);
            for (C3669nM c3669nM : c2976ef.b) {
                boolean z2 = c2976ef.e == 0;
                C0381Oi c0381Oi = new C0381Oi(c3669nM, !z2);
                if (!hashMap.containsKey(c0381Oi)) {
                    hashMap.put(c0381Oi, new HashSet());
                }
                Set set2 = (Set) hashMap.get(c0381Oi);
                if (!set2.isEmpty() && z2) {
                    throw new IllegalArgumentException("Multiple components provide " + c3669nM + ".");
                }
                set2.add(c0355Ni7);
            }
        }
    }

    public static boolean p(View view, KeyEvent keyEvent) {
        ArrayList arrayList;
        int size;
        int indexOfKey;
        WeakHashMap weakHashMap = AbstractC2925e20.a;
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        ArrayList arrayList2 = C2846d20.d;
        C2846d20 c2846d20 = (C2846d20) view.getTag(R.id.tag_unhandled_key_event_manager);
        WeakReference weakReference = null;
        if (c2846d20 == null) {
            c2846d20 = new C2846d20();
            c2846d20.a = null;
            c2846d20.b = null;
            c2846d20.c = null;
            view.setTag(R.id.tag_unhandled_key_event_manager, c2846d20);
        }
        WeakReference weakReference2 = c2846d20.c;
        if (weakReference2 != null && weakReference2.get() == keyEvent) {
            return false;
        }
        c2846d20.c = new WeakReference(keyEvent);
        if (c2846d20.b == null) {
            c2846d20.b = new SparseArray();
        }
        SparseArray sparseArray = c2846d20.b;
        if (keyEvent.getAction() == 1 && (indexOfKey = sparseArray.indexOfKey(keyEvent.getKeyCode())) >= 0) {
            weakReference = (WeakReference) sparseArray.valueAt(indexOfKey);
            sparseArray.removeAt(indexOfKey);
        }
        if (weakReference == null) {
            weakReference = (WeakReference) sparseArray.get(keyEvent.getKeyCode());
        }
        if (weakReference == null) {
            return false;
        }
        View view2 = (View) weakReference.get();
        if (view2 == null || !view2.isAttachedToWindow() || (arrayList = (ArrayList) view2.getTag(R.id.tag_unhandled_key_listeners)) == null || (size = arrayList.size() - 1) < 0) {
            return true;
        }
        arrayList.get(size).getClass();
        throw new ClassCastException();
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:63:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean q(InterfaceC3180hA interfaceC3180hA, View view, Window.Callback callback, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener;
        Window window;
        boolean z2 = false;
        if (interfaceC3180hA != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                return interfaceC3180hA.superDispatchKeyEvent(keyEvent);
            }
            if (callback instanceof Activity) {
                Activity activity = (Activity) callback;
                activity.onUserInteraction();
                Window window2 = activity.getWindow();
                if (window2.hasFeature(8)) {
                    ActionBar actionBar = activity.getActionBar();
                    if (keyEvent.getKeyCode() == 82 && actionBar != null) {
                        if (!v) {
                            try {
                                w = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
                            } catch (NoSuchMethodException unused) {
                            }
                            v = true;
                        }
                        Method method = w;
                        if (method != null) {
                            try {
                                Object invoke = method.invoke(actionBar, keyEvent);
                                if (invoke != null) {
                                    z2 = ((Boolean) invoke).booleanValue();
                                }
                            } catch (IllegalAccessException | InvocationTargetException unused2) {
                            }
                        }
                        if (z2) {
                            return true;
                        }
                    }
                }
                if (window2.superDispatchKeyEvent(keyEvent)) {
                    return true;
                }
                View decorView = window2.getDecorView();
                if (AbstractC2925e20.c(decorView, keyEvent)) {
                    return true;
                }
                return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
            }
            if (callback instanceof Dialog) {
                Dialog dialog = (Dialog) callback;
                if (!x) {
                    try {
                        Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                        y = declaredField;
                        declaredField.setAccessible(true);
                    } catch (NoSuchFieldException unused3) {
                    }
                    x = true;
                }
                Field field = y;
                if (field != null) {
                    try {
                        onKeyListener = (DialogInterface.OnKeyListener) field.get(dialog);
                    } catch (IllegalAccessException unused4) {
                    }
                    if (onKeyListener == null && onKeyListener.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
                        return true;
                    }
                    window = dialog.getWindow();
                    if (!window.superDispatchKeyEvent(keyEvent)) {
                        return true;
                    }
                    View decorView2 = window.getDecorView();
                    if (AbstractC2925e20.c(decorView2, keyEvent)) {
                        return true;
                    }
                    return keyEvent.dispatch(dialog, decorView2 != null ? decorView2.getKeyDispatcherState() : null, dialog);
                }
                onKeyListener = null;
                if (onKeyListener == null) {
                }
                window = dialog.getWindow();
                if (!window.superDispatchKeyEvent(keyEvent)) {
                }
            } else if ((view != null && AbstractC2925e20.c(view, keyEvent)) || interfaceC3180hA.superDispatchKeyEvent(keyEvent)) {
                return true;
            }
        }
        return false;
    }

    public static H30 r(C3774og c3774og, int i2, ArrayList arrayList, H30 h30) {
        int i3;
        int i4 = i2 == 0 ? c3774og.m0 : c3774og.n0;
        if (i4 != -1 && (h30 == null || i4 != h30.b)) {
            int i5 = 0;
            while (true) {
                if (i5 >= arrayList.size()) {
                    break;
                }
                H30 h302 = (H30) arrayList.get(i5);
                if (h302.b == i4) {
                    if (h30 != null) {
                        h30.c(i2, h302);
                        arrayList.remove(h30);
                    }
                    h30 = h302;
                } else {
                    i5++;
                }
            }
        } else if (i4 != -1) {
            return h30;
        }
        if (h30 == null) {
            if (c3774og instanceof AbstractC0394Ov) {
                AbstractC0394Ov abstractC0394Ov = (AbstractC0394Ov) c3774og;
                int i6 = 0;
                while (true) {
                    if (i6 >= abstractC0394Ov.q0) {
                        i3 = -1;
                        break;
                    }
                    C3774og c3774og2 = abstractC0394Ov.p0[i6];
                    if ((i2 == 0 && (i3 = c3774og2.m0) != -1) || (i2 == 1 && (i3 = c3774og2.n0) != -1)) {
                        break;
                    }
                    i6++;
                }
                if (i3 != -1) {
                    int i7 = 0;
                    while (true) {
                        if (i7 >= arrayList.size()) {
                            break;
                        }
                        H30 h303 = (H30) arrayList.get(i7);
                        if (h303.b == i3) {
                            h30 = h303;
                            break;
                        }
                        i7++;
                    }
                }
            }
            if (h30 == null) {
                h30 = new H30();
                h30.a = new ArrayList();
                h30.d = null;
                h30.e = -1;
                int i8 = H30.f;
                H30.f = i8 + 1;
                h30.b = i8;
                h30.c = i2;
            }
            arrayList.add(h30);
        }
        ArrayList arrayList2 = h30.a;
        if (arrayList2.contains(c3774og)) {
            return h30;
        }
        arrayList2.add(c3774og);
        if (c3774og instanceof C4183tv) {
            C4183tv c4183tv = (C4183tv) c3774og;
            c4183tv.s0.c(c4183tv.t0 == 0 ? 1 : 0, h30, arrayList);
        }
        int i9 = h30.b;
        if (i2 == 0) {
            c3774og.m0 = i9;
            c3774og.H.c(i2, h30, arrayList);
            c3774og.J.c(i2, h30, arrayList);
        } else {
            c3774og.n0 = i9;
            c3774og.I.c(i2, h30, arrayList);
            c3774og.L.c(i2, h30, arrayList);
            c3774og.K.c(i2, h30, arrayList);
        }
        c3774og.O.c(i2, h30, arrayList);
        return h30;
    }

    public static final InterfaceC0502Sz s(InterfaceC3989rR interfaceC3989rR) {
        AbstractC3634my.g(interfaceC3989rR, "<this>");
        if (interfaceC3989rR instanceof C4068sR) {
            return s(((C4068sR) interfaceC3989rR).a);
        }
        return null;
    }

    public static int t(Context context, int i2, int i3) {
        Integer num;
        TypedValue Y = AbstractC0731aZ.Y(context, i2);
        if (Y != null) {
            int i4 = Y.resourceId;
            num = Integer.valueOf(i4 != 0 ? context.getColor(i4) : Y.data);
        } else {
            num = null;
        }
        return num != null ? num.intValue() : i3;
    }

    public static int u(View view, int i2) {
        Context context = view.getContext();
        TypedValue c0 = AbstractC0731aZ.c0(view.getContext(), i2, view.getClass().getCanonicalName());
        int i3 = c0.resourceId;
        return i3 != 0 ? context.getColor(i3) : c0.data;
    }

    public static Object v(Bundle bundle, String str) {
        if (Build.VERSION.SDK_INT >= 34) {
            return H0.b(bundle, str);
        }
        Parcelable parcelable = bundle.getParcelable(str);
        if (C4349w1.class.isInstance(parcelable)) {
            return parcelable;
        }
        return null;
    }

    public static InterfaceC0198Hg w(InterfaceC0198Hg interfaceC0198Hg) {
        InterfaceC0198Hg intercepted;
        AbstractC3634my.g(interfaceC0198Hg, "<this>");
        AbstractC0224Ig abstractC0224Ig = interfaceC0198Hg instanceof AbstractC0224Ig ? (AbstractC0224Ig) interfaceC0198Hg : null;
        return (abstractC0224Ig == null || (intercepted = abstractC0224Ig.intercepted()) == null) ? interfaceC0198Hg : intercepted;
    }

    public static boolean x(int i2) {
        if (i2 == 0) {
            return false;
        }
        ThreadLocal threadLocal = AbstractC0118Ee.a;
        double[] dArr = (double[]) threadLocal.get();
        if (dArr == null) {
            dArr = new double[3];
            threadLocal.set(dArr);
        }
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d2 = red / 255.0d;
        double pow = d2 < 0.04045d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d);
        double d3 = green / 255.0d;
        double pow2 = d3 < 0.04045d ? d3 / 12.92d : Math.pow((d3 + 0.055d) / 1.055d, 2.4d);
        double d4 = blue / 255.0d;
        double pow3 = d4 < 0.04045d ? d4 / 12.92d : Math.pow((d4 + 0.055d) / 1.055d, 2.4d);
        dArr[0] = ((0.1805d * pow3) + (0.3576d * pow2) + (0.4124d * pow)) * 100.0d;
        double d5 = ((0.0722d * pow3) + (0.7152d * pow2) + (0.2126d * pow)) * 100.0d;
        dArr[1] = d5;
        dArr[2] = ((pow3 * 0.9505d) + (pow2 * 0.1192d) + (pow * 0.0193d)) * 100.0d;
        return d5 / 100.0d > 0.5d;
    }

    public static boolean y(byte b2) {
        return b2 > -65;
    }

    public static int z(int i2, int i3, float f2) {
        return AbstractC0118Ee.b(AbstractC0118Ee.d(i3, Math.round(Color.alpha(i3) * f2)), i2);
    }
}
