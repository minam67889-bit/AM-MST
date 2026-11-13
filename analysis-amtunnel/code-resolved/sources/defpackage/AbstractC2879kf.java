package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewParent;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.tasks.Task;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.signature.SignatureVisitor;

/* renamed from: kf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC2879kf {
    public static final C0367Xh a = new C0367Xh("RESUME_TOKEN", 3);
    public static final String[] b = {"standard", "accelerate", "decelerate", "linear"};
    public static final C0253Pn c = new C0253Pn(16, (byte) 0);
    public static final boolean[] d = new boolean[3];
    public static final C0253Pn e = new C0253Pn(23, (byte) 0);
    public static final C0033Bh f = new C0033Bh(24);
    public static final C2727hk g = new C2727hk(24);
    public static final Object h = new Object();
    public static char[] i = new char[24];
    public static Field j;
    public static boolean k;
    public static Class l;
    public static boolean m;
    public static Field n;
    public static boolean o;
    public static Field p;
    public static boolean q;

    public static final String A(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static Intent B(Activity activity) {
        Intent parentActivityIntent = activity.getParentActivityIntent();
        if (parentActivityIntent != null) {
            return parentActivityIntent;
        }
        try {
            String D = D(activity, activity.getComponentName());
            if (D == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, D);
            try {
                return D(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + D + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Intent C(Context context, ComponentName componentName) {
        String D = D(context, componentName);
        if (D == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), D);
        return D(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String D(Context context, ComponentName componentName) {
        String string;
        PackageManager packageManager = context.getPackageManager();
        int i2 = Build.VERSION.SDK_INT;
        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, i2 >= 29 ? 269222528 : i2 >= 24 ? 787072 : 640);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static final int E(int i2, int i3, int i4) {
        if (i4 > 0) {
            if (i2 >= i3) {
                return i3;
            }
            int i5 = i3 % i4;
            if (i5 < 0) {
                i5 += i4;
            }
            int i6 = i2 % i4;
            if (i6 < 0) {
                i6 += i4;
            }
            int i7 = (i5 - i6) % i4;
            if (i7 < 0) {
                i7 += i4;
            }
            return i3 - i7;
        }
        if (i4 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        }
        if (i2 <= i3) {
            return i3;
        }
        int i8 = -i4;
        int i9 = i2 % i8;
        if (i9 < 0) {
            i9 += i8;
        }
        int i10 = i3 % i8;
        if (i10 < 0) {
            i10 += i8;
        }
        int i11 = (i9 - i10) % i8;
        if (i11 < 0) {
            i11 += i8;
        }
        return i3 + i11;
    }

    public static final BB F(FK fk) {
        AbstractC3365tp.q(fk, "<this>");
        C2727hk c2727hk = new C2727hk(23);
        AbstractC0138Id defaultViewModelCreationExtras = fk instanceof InterfaceC0208Mn ? ((InterfaceC0208Mn) fk).getDefaultViewModelCreationExtras() : C0123Hd.b;
        AbstractC3365tp.q(defaultViewModelCreationExtras, "extras");
        EK viewModelStore = fk.getViewModelStore();
        AbstractC3365tp.q(viewModelStore, "store");
        return (BB) new DC(viewModelStore, c2727hk, defaultViewModelCreationExtras).f(Wz.a(BB.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static String G(String str, String str2) {
        StringBuilder o2 = AbstractC3603yE.o(str2);
        o2.append("#ERR IndexError: string index out of range");
        Matcher matcher = Pattern.compile(o2.toString()).matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    public static final int H(InterfaceC3548xC interfaceC3548xC, InterfaceC3548xC[] interfaceC3548xCArr) {
        AbstractC3365tp.q(interfaceC3548xCArr, "typeParams");
        int hashCode = (interfaceC3548xC.a().hashCode() * 31) + Arrays.hashCode(interfaceC3548xCArr);
        int f2 = interfaceC3548xC.f();
        int i2 = 1;
        while (true) {
            int i3 = 0;
            if (!(f2 > 0)) {
                break;
            }
            int i4 = f2 - 1;
            int i5 = i2 * 31;
            String a2 = interfaceC3548xC.i(interfaceC3548xC.f() - f2).a();
            if (a2 != null) {
                i3 = a2.hashCode();
            }
            i2 = i5 + i3;
            f2 = i4;
        }
        int f3 = interfaceC3548xC.f();
        int i6 = 1;
        while (true) {
            if (!(f3 > 0)) {
                return (((hashCode * 31) + i2) * 31) + i6;
            }
            int i7 = f3 - 1;
            int i8 = i6 * 31;
            AbstractC3090oe e2 = interfaceC3548xC.i(interfaceC3548xC.f() - f3).e();
            i6 = i8 + (e2 != null ? e2.hashCode() : 0);
            f3 = i7;
        }
    }

    public static final void I(C2969mF c2969mF, String str) {
        AbstractC3365tp.q(c2969mF, "<this>");
        AbstractC3365tp.q(str, "entity");
        c2969mF.l(c2969mF.a - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static boolean J(int i2, Rect rect, Rect rect2) {
        if (i2 == 17) {
            int i3 = rect.right;
            int i4 = rect2.right;
            return (i3 > i4 || rect.left >= i4) && rect.left > rect2.left;
        }
        if (i2 == 33) {
            int i5 = rect.bottom;
            int i6 = rect2.bottom;
            return (i5 > i6 || rect.top >= i6) && rect.top > rect2.top;
        }
        if (i2 == 66) {
            int i7 = rect.left;
            int i8 = rect2.left;
            return (i7 < i8 || rect.right <= i8) && rect.right < rect2.right;
        }
        if (i2 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i9 = rect.top;
        int i10 = rect2.top;
        return (i9 < i10 || rect.bottom <= i10) && rect.bottom < rect2.bottom;
    }

    public static boolean K(String str) {
        V1 v1 = AbstractC3557xL.a;
        Set<InterfaceC0538cb> unmodifiableSet = Collections.unmodifiableSet(W1.c);
        HashSet hashSet = new HashSet();
        for (InterfaceC0538cb interfaceC0538cb : unmodifiableSet) {
            if (((W1) interfaceC0538cb).a.equals(str)) {
                hashSet.add(interfaceC0538cb);
            }
        }
        if (hashSet.isEmpty()) {
            throw new RuntimeException("Unknown feature ".concat(str));
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            W1 w1 = (W1) ((InterfaceC0538cb) it.next());
            if (w1.a() || w1.b()) {
                return true;
            }
        }
        return false;
    }

    public static int L(int i2, Rect rect, Rect rect2) {
        int i3;
        int i4;
        if (i2 == 17) {
            i3 = rect.left;
            i4 = rect2.right;
        } else if (i2 == 33) {
            i3 = rect.top;
            i4 = rect2.bottom;
        } else if (i2 == 66) {
            i3 = rect2.left;
            i4 = rect.right;
        } else {
            if (i2 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i3 = rect2.top;
            i4 = rect.bottom;
        }
        return Math.max(0, i3 - i4);
    }

    public static final CharSequence M(CharSequence charSequence, int i2) {
        AbstractC3365tp.q(charSequence, "<this>");
        if (charSequence.length() < 200) {
            return charSequence;
        }
        if (i2 == -1) {
            int length = charSequence.length() - 60;
            if (length <= 0) {
                return charSequence;
            }
            return "....." + charSequence.subSequence(length, charSequence.length()).toString();
        }
        int i3 = i2 - 30;
        int i4 = i2 + 30;
        String str = i3 <= 0 ? "" : ".....";
        String str2 = i4 >= charSequence.length() ? "" : ".....";
        StringBuilder o2 = AbstractC3603yE.o(str);
        if (i3 < 0) {
            i3 = 0;
        }
        int length2 = charSequence.length();
        if (i4 > length2) {
            i4 = length2;
        }
        o2.append(charSequence.subSequence(i3, i4).toString());
        o2.append(str2);
        return o2.toString();
    }

    public static int N(int i2, Rect rect, Rect rect2) {
        int height;
        int i3;
        int height2;
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            height = (rect.width() / 2) + rect.left;
            i3 = rect2.left;
            height2 = rect2.width();
            return Math.abs(height - ((height2 / 2) + i3));
        }
        height = (rect.height() / 2) + rect.top;
        i3 = rect2.top;
        height2 = rect2.height();
        return Math.abs(height - ((height2 / 2) + i3));
    }

    public static InterfaceC3352tc O(InterfaceC3246rc interfaceC3246rc, InterfaceC3299sc interfaceC3299sc) {
        AbstractC3365tp.q(interfaceC3299sc, "key");
        return AbstractC3365tp.d(interfaceC3246rc.getKey(), interfaceC3299sc) ? C2672gi.a : interfaceC3246rc;
    }

    public static InterfaceC3352tc P(InterfaceC3246rc interfaceC3246rc, InterfaceC3352tc interfaceC3352tc) {
        AbstractC3365tp.q(interfaceC3352tc, "context");
        return interfaceC3352tc == C2672gi.a ? interfaceC3246rc : (InterfaceC3352tc) interfaceC3352tc.fold(interfaceC3246rc, new C2927la(1));
    }

    public static int Q(char[] cArr, int i2, char c2, int i3, boolean z, int i4) {
        int i5;
        if (!z && i2 <= 0) {
            return i3;
        }
        if ((!z || i4 < 3) && i2 <= 99) {
            i5 = i3;
        } else {
            int i6 = i2 / 100;
            cArr[i3] = (char) (i6 + 48);
            i5 = i3 + 1;
            i2 -= i6 * 100;
        }
        if ((z && i4 >= 2) || i2 > 9 || i3 != i5) {
            int i7 = i2 / 10;
            cArr[i5] = (char) (i7 + 48);
            i5++;
            i2 -= i7 * 10;
        }
        cArr[i5] = (char) (i2 + 48);
        cArr[i5 + 1] = c2;
        return i5 + 2;
    }

    public static String R(Context context, String str) {
        InputStream open = context.getResources().getAssets().open("#ERR IndexError: string index out of range" + str);
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

    public static Set S(Object... objArr) {
        int length = objArr.length;
        if (length == 0) {
            return C2882ki.a;
        }
        if (length == 1) {
            Set singleton = Collections.singleton(objArr[0]);
            AbstractC3365tp.p(singleton, "singleton(...)");
            return singleton;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet(Xs.q0(objArr.length));
        for (Object obj : objArr) {
            linkedHashSet.add(obj);
        }
        return linkedHashSet;
    }

    public static void T(View view, C3528wt c3528wt) {
        C0081Eh c0081Eh = c3528wt.b.c;
        if (c0081Eh == null || !c0081Eh.a) {
            return;
        }
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ((View) parent).getElevation();
        }
        C3422ut c3422ut = c3528wt.b;
        if (c3422ut.n != f2) {
            c3422ut.n = f2;
            c3528wt.t();
        }
    }

    public static void U(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new EJ(context, str, 0));
    }

    public static void V(Context context, String str) {
        new Handler(Looper.getMainLooper()).post(new EJ(context, str, 2));
    }

    public static final WM W(C2837jq c2837jq, InterfaceC3548xC interfaceC3548xC) {
        AbstractC3365tp.q(c2837jq, "<this>");
        AbstractC3365tp.q(interfaceC3548xC, "desc");
        AbstractC3090oe e2 = interfaceC3548xC.e();
        if (e2 instanceof AbstractC3426ux) {
            return WM.f;
        }
        if (!AbstractC3365tp.d(e2, AF.q)) {
            if (!AbstractC3365tp.d(e2, AF.r)) {
                return WM.c;
            }
            InterfaceC3548xC i2 = i(interfaceC3548xC.i(0), c2837jq.b);
            AbstractC3090oe e3 = i2.e();
            if ((e3 instanceof Sx) || AbstractC3365tp.d(e3, AC.q)) {
                return WM.e;
            }
            if (!c2837jq.a.d) {
                throw b(i2);
            }
        }
        return WM.d;
    }

    public static final void X(C2969mF c2969mF, Number number) {
        AbstractC3365tp.q(c2969mF, "<this>");
        C2969mF.m(c2969mF, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static byte[] Y(N7 n7) {
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int min = Math.min(Opcodes.ACC_ANNOTATION, Math.max(128, Integer.highestOneBit(0) * 2));
        int i2 = 0;
        while (i2 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i2);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int i3 = 0;
            while (i3 < min2) {
                int read = n7.read(bArr, i3, min2 - i3);
                if (read == -1) {
                    return m(i2, arrayDeque);
                }
                i3 += read;
                i2 += read;
            }
            long j2 = min * (min < 4096 ? 4 : 2);
            min = j2 > 2147483647L ? Api.BaseClientBuilder.API_PRIORITY_OTHER : j2 < -2147483648L ? Integer.MIN_VALUE : (int) j2;
        }
        if (n7.read() == -1) {
            return m(2147483639, arrayDeque);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static final String Z(InterfaceC2560ec interfaceC2560ec) {
        Object z;
        if (interfaceC2560ec instanceof C0111Gg) {
            return ((C0111Gg) interfaceC2560ec).toString();
        }
        try {
            z = interfaceC2560ec + '@' + A(interfaceC2560ec);
        } catch (Throwable th) {
            z = AbstractC3365tp.z(th);
        }
        if (OA.a(z) != null) {
            z = interfaceC2560ec.getClass().getName() + '@' + A(interfaceC2560ec);
        }
        return (String) z;
    }

    public static final C3208qq a(Number number, String str) {
        return new C3208qq("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) M(str, -1)), 1);
    }

    public static final long a0(int i2, EnumC3199qh enumC3199qh) {
        AbstractC3365tp.q(enumC3199qh, "unit");
        return enumC3199qh.compareTo(EnumC3199qh.d) <= 0 ? r(AbstractC3365tp.w(i2, enumC3199qh, EnumC3199qh.b)) : b0(i2, enumC3199qh);
    }

    public static final C3208qq b(InterfaceC3548xC interfaceC3548xC) {
        return new C3208qq("Value of type '" + interfaceC3548xC.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + interfaceC3548xC.e() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.", 1);
    }

    public static final long b0(long j2, EnumC3199qh enumC3199qh) {
        AbstractC3365tp.q(enumC3199qh, "unit");
        EnumC3199qh enumC3199qh2 = EnumC3199qh.b;
        long w = AbstractC3365tp.w(4611686018426999999L, enumC3199qh2, enumC3199qh);
        if ((-w) <= j2 && j2 <= w) {
            return r(AbstractC3365tp.w(j2, enumC3199qh, enumC3199qh2));
        }
        EnumC3199qh enumC3199qh3 = EnumC3199qh.c;
        AbstractC3365tp.q(enumC3199qh3, "targetUnit");
        return q(AbstractC2866kI.l(enumC3199qh3.a.convert(j2, enumC3199qh.a)));
    }

    public static final C3208qq c(int i2, String str) {
        AbstractC3365tp.q(str, "message");
        if (i2 >= 0) {
            str = "Unexpected JSON token at offset " + i2 + ": " + str;
        }
        return new C3208qq(str, 0);
    }

    public static final C3208qq d(int i2, String str, String str2) {
        AbstractC3365tp.q(str, "message");
        AbstractC3365tp.q(str2, "input");
        return c(i2, str + "\nJSON input: " + ((Object) M(str2, i2)));
    }

    public static void e(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static final Object f(Task task, C0404Zo c0404Zo) {
        if (!task.isComplete()) {
            C3226r8 c3226r8 = new C3226r8(1, AbstractC3192qa.y(c0404Zo));
            c3226r8.s();
            task.addOnCompleteListener(ExecutorC0016Ag.b, new Rw(c3226r8, 12));
            Object r = c3226r8.r();
            EnumC0044Cc enumC0044Cc = EnumC0044Cc.a;
            return r;
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

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
    
        if (r10.bottom <= r12.top) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0043, code lost:
    
        if (r9 == 17) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
    
        if (r9 != 66) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0048, code lost:
    
        r11 = L(r9, r10, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r9 == 17) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x004e, code lost:
    
        if (r9 == 33) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0050, code lost:
    
        if (r9 == 66) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0052, code lost:
    
        if (r9 != 130) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        r9 = r12.bottom;
        r10 = r10.bottom;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        if (r11 >= java.lang.Math.max(1, r9 - r10)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0076, code lost:
    
        return true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005f, code lost:
    
        throw new java.lang.IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        r9 = r12.right;
        r10 = r10.right;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        r9 = r10.top;
        r10 = r12.top;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006a, code lost:
    
        r9 = r10.left;
        r10 = r12.left;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0033, code lost:
    
        if (r10.right <= r12.left) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x003a, code lost:
    
        if (r10.top >= r12.bottom) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0041, code lost:
    
        if (r10.left >= r12.right) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean g(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = h(r9, r10, r11)
            boolean r1 = h(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L78
            if (r0 != 0) goto Lf
            goto L78
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L77
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L77
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L77
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L77
        L43:
            if (r9 == r5) goto L77
            if (r9 != r4) goto L48
            goto L77
        L48:
            int r11 = L(r9, r10, r11)
            if (r9 == r5) goto L6a
            if (r9 == r3) goto L65
            if (r9 == r4) goto L60
            if (r9 != r1) goto L5a
            int r9 = r12.bottom
            int r10 = r10.bottom
        L58:
            int r9 = r9 - r10
            goto L6f
        L5a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L60:
            int r9 = r12.right
            int r10 = r10.right
            goto L58
        L65:
            int r9 = r10.top
            int r10 = r12.top
            goto L58
        L6a:
            int r9 = r10.left
            int r10 = r12.left
            goto L58
        L6f:
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L76
            r2 = r6
        L76:
            return r2
        L77:
            return r6
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC2879kf.g(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean h(int i2, Rect rect, Rect rect2) {
        if (i2 != 17) {
            if (i2 != 33) {
                if (i2 != 66) {
                    if (i2 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static final InterfaceC3548xC i(InterfaceC3548xC interfaceC3548xC, C0253Pn c0253Pn) {
        AbstractC3365tp.q(interfaceC3548xC, "<this>");
        AbstractC3365tp.q(c0253Pn, "module");
        if (!AbstractC3365tp.d(interfaceC3548xC.e(), AC.p)) {
            return interfaceC3548xC.isInline() ? i(interfaceC3548xC.i(0), c0253Pn) : interfaceC3548xC;
        }
        AbstractC3192qa.p(interfaceC3548xC);
        return interfaceC3548xC;
    }

    public static void j(C0196Mb c0196Mb, C3526wr c3526wr, C0181Lb c0181Lb) {
        c0181Lb.n = -1;
        c0181Lb.o = -1;
        int i2 = c0196Mb.o0[0];
        int[] iArr = c0181Lb.o0;
        if (i2 != 2 && iArr[0] == 4) {
            C3245rb c3245rb = c0181Lb.H;
            int i3 = c3245rb.g;
            int n2 = c0196Mb.n();
            C3245rb c3245rb2 = c0181Lb.J;
            int i4 = n2 - c3245rb2.g;
            c3245rb.i = c3526wr.k(c3245rb);
            c3245rb2.i = c3526wr.k(c3245rb2);
            c3526wr.d(c3245rb.i, i3);
            c3526wr.d(c3245rb2.i, i4);
            c0181Lb.n = 2;
            c0181Lb.X = i3;
            int i5 = i4 - i3;
            c0181Lb.T = i5;
            int i6 = c0181Lb.a0;
            if (i5 < i6) {
                c0181Lb.T = i6;
            }
        }
        if (c0196Mb.o0[1] == 2 || iArr[1] != 4) {
            return;
        }
        C3245rb c3245rb3 = c0181Lb.I;
        int i7 = c3245rb3.g;
        int k2 = c0196Mb.k();
        C3245rb c3245rb4 = c0181Lb.K;
        int i8 = k2 - c3245rb4.g;
        c3245rb3.i = c3526wr.k(c3245rb3);
        c3245rb4.i = c3526wr.k(c3245rb4);
        c3526wr.d(c3245rb3.i, i7);
        c3526wr.d(c3245rb4.i, i8);
        if (c0181Lb.Z > 0 || c0181Lb.f0 == 8) {
            C3245rb c3245rb5 = c0181Lb.L;
            C3656zE k3 = c3526wr.k(c3245rb5);
            c3245rb5.i = k3;
            c3526wr.d(k3, c0181Lb.Z + i7);
        }
        c0181Lb.o = 2;
        c0181Lb.Y = i7;
        int i9 = i8 - i7;
        c0181Lb.U = i9;
        int i10 = c0181Lb.b0;
        if (i9 < i10) {
            c0181Lb.U = i10;
        }
    }

    public static final void k(int i2) {
        if (i2 < 1) {
            throw new IllegalArgumentException(AbstractC0041Bp.j(i2, "Expected positive parallelism level, but got ").toString());
        }
    }

    public static final void l(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC3365tp.b(th, th2);
            }
        }
    }

    public static byte[] m(int i2, ArrayDeque arrayDeque) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i2) {
            return bArr;
        }
        int length = i2 - bArr.length;
        byte[] copyOf = Arrays.copyOf(bArr, i2);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int min = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i2 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static C2563ef n(CC cc, Rw rw, List list, InterfaceC0028Bc interfaceC0028Bc, InterfaceC0070Dm interfaceC0070Dm) {
        AbstractC3365tp.q(cc, "serializer");
        AbstractC3365tp.q(list, "migrations");
        AbstractC3365tp.q(interfaceC0028Bc, "scope");
        C0174Kj c0174Kj = new C0174Kj(cc, C0144Ij.b, interfaceC0070Dm);
        InterfaceC0122Hc interfaceC0122Hc = rw;
        if (rw == null) {
            interfaceC0122Hc = new C2727hk(21);
        }
        return new C2563ef(c0174Kj, It.E(new C3248re(list, null)), interfaceC0122Hc, interfaceC0028Bc);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [ad, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v2, types: [ad, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v3, types: [ad, java.lang.Object] */
    public static AbstractC0435ad o(int i2) {
        if (i2 != 0 && i2 == 1) {
            return new Object();
        }
        return new Object();
    }

    public static final C3600yB p(C2738hv c2738hv) {
        C0253Pn c0253Pn = e;
        LinkedHashMap linkedHashMap = c2738hv.a;
        IB ib = (IB) linkedHashMap.get(c0253Pn);
        if (ib == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        FK fk = (FK) linkedHashMap.get(f);
        if (fk == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(g);
        String str = (String) linkedHashMap.get(C3628yn.d);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        DB b2 = ib.getSavedStateRegistry().b();
        Bundle bundle2 = null;
        AB ab = b2 instanceof AB ? (AB) b2 : null;
        if (ab == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = F(fk).b;
        C3600yB c3600yB = (C3600yB) linkedHashMap2.get(str);
        if (c3600yB != null) {
            return c3600yB;
        }
        ab.b();
        Bundle bundle3 = ab.c;
        if (bundle3 != null && !(!bundle3.containsKey(str))) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = AbstractC0435ad.d((C2476cx[]) Arrays.copyOf(new C2476cx[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                ab.c = null;
            }
            bundle2 = bundle4;
        }
        C3600yB n2 = It.n(bundle2, bundle);
        linkedHashMap2.put(str, n2);
        return n2;
    }

    public static final long q(long j2) {
        long j3 = (j2 << 1) + 1;
        int i2 = C3093oh.d;
        int i3 = AbstractC3146ph.a;
        return j3;
    }

    public static final long r(long j2) {
        long j3 = j2 << 1;
        int i2 = C3093oh.d;
        int i3 = AbstractC3146ph.a;
        return j3;
    }

    public static final void s(IB ib) {
        AbstractC3365tp.q(ib, "<this>");
        EnumC0449ar enumC0449ar = ((C2786ir) ib.getLifecycle()).c;
        if (enumC0449ar != EnumC0449ar.b && enumC0449ar != EnumC0449ar.c) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (ib.getSavedStateRegistry().b() == null) {
            AB ab = new AB(ib.getSavedStateRegistry(), (FK) ib);
            ib.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", ab);
            ib.getLifecycle().a(new C3217qz(ab, 3));
        }
    }

    public static final boolean t(int i2, int i3) {
        return (i2 & i3) == i3;
    }

    public static final C3676zi u(Enum[] enumArr) {
        AbstractC3365tp.q(enumArr, "entries");
        return new C3676zi(enumArr);
    }

    public static void v(Object obj) {
        LongSparseArray longSparseArray;
        if (!m) {
            try {
                l = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e2) {
                Log.e("ResourcesFlusher", "Could not find ThemedResourceCache class", e2);
            }
            m = true;
        }
        Class cls = l;
        if (cls == null) {
            return;
        }
        if (!o) {
            try {
                Field declaredField = cls.getDeclaredField("mUnthemedEntries");
                n = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
                Log.e("ResourcesFlusher", "Could not retrieve ThemedResourceCache#mUnthemedEntries field", e3);
            }
            o = true;
        }
        Field field = n;
        if (field == null) {
            return;
        }
        try {
            longSparseArray = (LongSparseArray) field.get(obj);
        } catch (IllegalAccessException e4) {
            Log.e("ResourcesFlusher", "Could not retrieve value from ThemedResourceCache#mUnthemedEntries", e4);
            longSparseArray = null;
        }
        if (longSparseArray != null) {
            longSparseArray.clear();
        }
    }

    public static void w(long j2, PrintWriter printWriter) {
        synchronized (h) {
            printWriter.print(new String(i, 0, x(j2)));
        }
    }

    public static int x(long j2) {
        char c2;
        int i2;
        int i3;
        int i4;
        int i5;
        if (i.length < 0) {
            i = new char[0];
        }
        char[] cArr = i;
        if (j2 == 0) {
            cArr[0] = '0';
            return 1;
        }
        if (j2 > 0) {
            c2 = SignatureVisitor.EXTENDS;
        } else {
            j2 = -j2;
            c2 = SignatureVisitor.SUPER;
        }
        int i6 = (int) (j2 % 1000);
        int floor = (int) Math.floor(j2 / 1000);
        if (floor > 86400) {
            i2 = floor / 86400;
            floor -= 86400 * i2;
        } else {
            i2 = 0;
        }
        if (floor > 3600) {
            i3 = floor / 3600;
            floor -= i3 * 3600;
        } else {
            i3 = 0;
        }
        if (floor > 60) {
            int i7 = floor / 60;
            i4 = floor - (i7 * 60);
            i5 = i7;
        } else {
            i4 = floor;
            i5 = 0;
        }
        cArr[0] = c2;
        int Q = Q(cArr, i2, 'd', 1, false, 0);
        int Q2 = Q(cArr, i3, 'h', Q, Q != 1, 0);
        int Q3 = Q(cArr, i5, 'm', Q2, Q2 != 1, 0);
        int Q4 = Q(cArr, i6, 'm', Q(cArr, i4, 's', Q3, Q3 != 1, 0), true, 0);
        cArr[Q4] = 's';
        return Q4 + 1;
    }

    public static InterfaceC3246rc y(InterfaceC3246rc interfaceC3246rc, InterfaceC3299sc interfaceC3299sc) {
        AbstractC3365tp.q(interfaceC3299sc, "key");
        if (AbstractC3365tp.d(interfaceC3246rc.getKey(), interfaceC3299sc)) {
            return interfaceC3246rc;
        }
        return null;
    }

    public static String z(Context context) {
        StringBuilder sb = new StringBuilder();
        for (Signature signature : context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures) {
            byte[] byteArray = signature.toByteArray();
            MessageDigest messageDigest = MessageDigest.getInstance("#ERR IndexError: string index out of range");
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            char[] cArr = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            char[] cArr2 = new char[digest.length * 2];
            for (int i2 = 0; i2 < digest.length; i2++) {
                byte b2 = digest[i2];
                int i3 = i2 * 2;
                cArr2[i3] = cArr[(b2 & 255) >>> 4];
                cArr2[i3 + 1] = cArr[b2 & 15];
            }
            sb.append(new String(cArr2));
        }
        return sb.toString();
    }
}
