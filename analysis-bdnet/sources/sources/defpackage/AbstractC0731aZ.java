package defpackage;

import android.R;
import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.view.inputmethod.EditorInfo;
import com.google.android.gms.common.api.Api;
import com.google.android.material.appbar.AppBarLayout;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.RoundingMode;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import org.achartengine.renderer.DefaultRenderer;
import org.chromium.base.metrics.ScopedSysTraceEvent;

/* renamed from: aZ, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public abstract class AbstractC0731aZ {
    public static final C4254un g;
    public static final C0756ar h;
    public static final C0213Hv i;
    public static final float[][] a = {new float[]{0.401288f, 0.650173f, -0.051461f}, new float[]{-0.250268f, 1.204414f, 0.045854f}, new float[]{-0.002079f, 0.048952f, 0.953127f}};
    public static final float[][] b = {new float[]{1.8620678f, -1.0112547f, 0.14918678f}, new float[]{0.38752654f, 0.62144744f, -0.00897398f}, new float[]{-0.0158415f, -0.03412294f, 1.0499644f}};
    public static final float[] c = {95.047f, 100.0f, 108.883f};
    public static final float[][] d = {new float[]{0.41233894f, 0.35762063f, 0.18051042f}, new float[]{0.2126f, 0.7152f, 0.0722f}, new float[]{0.01932141f, 0.11916382f, 0.9503448f}};
    public static final String[] e = new String[0];
    public static final Object f = new Object();
    public static final int[] j = {R.attr.stateListAnimator};
    public static final T50 k = new T50(9);
    public static final O90 l = new O90();
    public static final T50 m = new T50(29);
    public static final C4084sd0 n = new C4084sd0(8);

    static {
        int i2 = 28;
        g = new C4254un(i2);
        h = new C0756ar(i2);
        i = new C0213Hv(i2);
    }

    public static final void A(InterfaceC3910qQ interfaceC3910qQ) {
        EnumC4526yB enumC4526yB = ((HB) interfaceC3910qQ.getLifecycle()).h;
        if (enumC4526yB == EnumC4526yB.b || enumC4526yB == EnumC4526yB.c) {
            if (interfaceC3910qQ.getSavedStateRegistry().b() == null) {
                C3354jQ c3354jQ = new C3354jQ(interfaceC3910qQ.getSavedStateRegistry(), (InterfaceC4115t20) interfaceC3910qQ);
                interfaceC3910qQ.getSavedStateRegistry().c("androidx.lifecycle.internal.SavedStateHandlesProvider", c3354jQ);
                interfaceC3910qQ.getLifecycle().a(new UM(c3354jQ, 3));
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("Failed to enable `SavedStateHandle` for `" + interfaceC3910qQ + "`. The `Lifecycle.State` must be `INITIALIZED` or `CREATED`, but was `" + enumC4526yB + "`. You must call `enableSavedStateHandles()` before the `Lifecycle.State` moves to `STARTED`.").toString());
    }

    public static final AbstractC0826bh B(Executor executor) {
        ExecutorC3381jk executorC3381jk;
        ExecutorC0047Bl executorC0047Bl = executor instanceof ExecutorC0047Bl ? (ExecutorC0047Bl) executor : null;
        return (executorC0047Bl == null || (executorC3381jk = executorC0047Bl.a) == null) ? new C0834bp(executor) : executorC3381jk;
    }

    public static float D(String[] strArr, int i2) {
        float parseFloat = Float.parseFloat(strArr[i2]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    public static final InterfaceC0786bA E(InterfaceC0786bA interfaceC0786bA) {
        AbstractC3634my.g(interfaceC0786bA, "<this>");
        return interfaceC0786bA.d().g() ? interfaceC0786bA : new C4533yI(interfaceC0786bA);
    }

    public static final Object F(Optional optional, Object obj) {
        AbstractC3634my.g(optional, "<this>");
        return optional.isPresent() ? optional.get() : obj;
    }

    public static final Object G(Optional optional) {
        AbstractC3634my.g(optional, "<this>");
        return optional.orElse(null);
    }

    public static final C3434kQ I(InterfaceC4115t20 interfaceC4115t20) {
        C3276iQ c3276iQ = new C3276iQ();
        AbstractC3776oi defaultViewModelCreationExtras = interfaceC4115t20 instanceof InterfaceC0031Av ? ((InterfaceC0031Av) interfaceC4115t20).getDefaultViewModelCreationExtras() : C3697ni.b;
        AbstractC3634my.g(defaultViewModelCreationExtras, "extras");
        C4036s20 viewModelStore = interfaceC4115t20.getViewModelStore();
        AbstractC3634my.g(viewModelStore, "store");
        return (C3434kQ) new NX(viewModelStore, c3276iQ, defaultViewModelCreationExtras).h(AbstractC4617zN.a(C3434kQ.class), "androidx.lifecycle.internal.SavedStateHandlesVM");
    }

    public static int J(Set set) {
        Iterator it = set.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    public static int K(float f2) {
        if (f2 < 1.0f) {
            return DefaultRenderer.BACKGROUND_COLOR;
        }
        if (f2 > 99.0f) {
            return -1;
        }
        float f3 = (f2 + 16.0f) / 116.0f;
        float f4 = f2 > 8.0f ? f3 * f3 * f3 : f2 / 903.2963f;
        float f5 = f3 * f3 * f3;
        boolean z = f5 > 0.008856452f;
        float f6 = z ? f5 : ((f3 * 116.0f) - 16.0f) / 903.2963f;
        if (!z) {
            f5 = ((f3 * 116.0f) - 16.0f) / 903.2963f;
        }
        float[] fArr = c;
        return AbstractC0118Ee.a(f6 * fArr[0], f4 * fArr[1], f5 * fArr[2]);
    }

    public static boolean L(int i2, Object obj) {
        if (obj instanceof InterfaceC3311iu) {
            if ((obj instanceof InterfaceC4024ru ? ((InterfaceC4024ru) obj).getArity() : obj instanceof InterfaceC0470Rt ? 0 : obj instanceof InterfaceC0522Tt ? 1 : obj instanceof InterfaceC3233hu ? 2 : obj instanceof InterfaceC3391ju ? 3 : -1) == i2) {
                return true;
            }
        }
        return false;
    }

    public static boolean M(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static boolean N(byte b2) {
        return b2 > -65;
    }

    public static float O(int i2) {
        float f2 = i2 / 255.0f;
        return (f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((f2 + 0.055f) / 1.055f, 2.4000000953674316d)) * 100.0f;
    }

    public static int P(int i2) {
        RoundingMode roundingMode = RoundingMode.UNNECESSARY;
        if (i2 <= 0) {
            throw new IllegalArgumentException(W50.j(i2, "x (", ") must be > 0"));
        }
        switch (AbstractC0163Fx.a[roundingMode.ordinal()]) {
            case 1:
                if (!((i2 > 0) & (((i2 + (-1)) & i2) == 0))) {
                    throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                }
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i2 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i2);
                return (31 - numberOfLeadingZeros) + ((~(~(((-1257966797) >>> numberOfLeadingZeros) - i2))) >>> 31);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i2);
    }

    public static int Q(Object obj, AQ aq, byte[] bArr, int i2, int i3, int i4, C4201u6 c4201u6) {
        PF pf = (PF) aq;
        int i5 = c4201u6.d + 1;
        c4201u6.d = i5;
        if (i5 >= 100) {
            throw new C4186ty("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int I = pf.I(obj, bArr, i2, i3, i4, c4201u6);
        c4201u6.d--;
        c4201u6.c = obj;
        return I;
    }

    public static int R(Object obj, AQ aq, byte[] bArr, int i2, int i3, C4201u6 c4201u6) {
        int i4 = i2 + 1;
        int i5 = bArr[i2];
        if (i5 < 0) {
            i4 = s(i5, bArr, i4, c4201u6);
            i5 = c4201u6.a;
        }
        int i6 = i4;
        if (i5 < 0 || i5 > i3 - i6) {
            throw C4186ty.g();
        }
        int i7 = c4201u6.d + 1;
        c4201u6.d = i7;
        if (i7 >= 100) {
            throw new C4186ty("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i8 = i6 + i5;
        aq.f(obj, bArr, i6, i8, c4201u6);
        c4201u6.d--;
        c4201u6.c = obj;
        return i8;
    }

    public static HashSet S(int i2) {
        int ceil;
        if (i2 < 3) {
            AbstractC0199Hh.q(i2, "expectedSize");
            ceil = i2 + 1;
        } else {
            ceil = i2 < 1073741824 ? (int) Math.ceil(i2 / 0.75d) : Api.BaseClientBuilder.API_PRIORITY_OTHER;
        }
        return new HashSet(ceil);
    }

    public static final Object X(Object obj) {
        return obj instanceof C0663Ze ? W80.j(((C0663Ze) obj).a) : obj;
    }

    public static TypedValue Y(Context context, int i2) {
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return typedValue;
        }
        return null;
    }

    public static boolean Z(Context context, int i2, boolean z) {
        TypedValue Y = Y(context, i2);
        return (Y == null || Y.type != 18) ? z : Y.data != 0;
    }

    public static void a(byte b2, byte b3, byte b4, byte b5, char[] cArr, int i2) {
        if (!N(b3)) {
            if ((((b3 + 112) + (b2 << 28)) >> 30) == 0 && !N(b4) && !N(b5)) {
                int i3 = ((b2 & 7) << 18) | ((b3 & 63) << 12) | ((b4 & 63) << 6) | (b5 & 63);
                cArr[i2] = (char) ((i3 >>> 10) + 55232);
                cArr[i2 + 1] = (char) ((i3 & 1023) + 56320);
                return;
            }
        }
        throw C4186ty.b();
    }

    public static int a0(Context context, int i2, int i3) {
        TypedValue Y = Y(context, i2);
        return (Y == null || Y.type != 16) ? i3 : Y.data;
    }

    public static void b(byte b2, byte b3, char[] cArr, int i2) {
        if (b2 < -62 || N(b3)) {
            throw C4186ty.b();
        }
        cArr[i2] = (char) (((b2 & 31) << 6) | (b3 & 63));
    }

    public static TimeInterpolator b0(Context context, int i2, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String valueOf = String.valueOf(typedValue.string);
        if (!M(valueOf, "cubic-bezier") && !M(valueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (M(valueOf, "cubic-bezier")) {
            String[] split = valueOf.substring(13, valueOf.length() - 1).split(",");
            if (split.length == 4) {
                return new PathInterpolator(D(split, 0), D(split, 1), D(split, 2), D(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        }
        if (!M(valueOf, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(valueOf));
        }
        String substring = valueOf.substring(5, valueOf.length() - 1);
        Path path = new Path();
        try {
            SJ.b(W80.k(substring), path);
            return new PathInterpolator(path);
        } catch (RuntimeException e2) {
            throw new RuntimeException("Error in parsing ".concat(substring), e2);
        }
    }

    public static void c(byte b2, byte b3, byte b4, char[] cArr, int i2) {
        if (N(b3) || ((b2 == -32 && b3 < -96) || ((b2 == -19 && b3 >= -96) || N(b4)))) {
            throw C4186ty.b();
        }
        cArr[i2] = (char) (((b2 & 15) << 12) | ((b3 & 63) << 6) | (b4 & 63));
    }

    public static TypedValue c0(Context context, int i2, String str) {
        TypedValue Y = Y(context, i2);
        if (Y != null) {
            return Y;
        }
        throw new IllegalArgumentException(String.format("%1$s requires a value for the %2$s attribute to be set in your app theme. You can either set the attribute in your theme or update your theme to inherit from Theme.MaterialComponents (or a descendant).", str, context.getResources().getResourceName(i2)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:162:0x028e, code lost:
    
        if (r8.d == r6) goto L190;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x010c, code lost:
    
        if (r4.d == r8) goto L75;
     */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0695 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x06a1  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x06ac  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x06b5  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x06bc  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x06cc  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x06d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:288:0x06ec A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:289:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0116 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void d(C3853pg c3853pg, ZB zb, ArrayList arrayList, int i2) {
        int i3;
        C4397wc[] c4397wcArr;
        int i4;
        int i5;
        float f2;
        float f3;
        boolean z;
        C3774og c3774og;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        C0560Vf[] c0560VfArr;
        int i6;
        C4397wc[] c4397wcArr2;
        C3774og c3774og2;
        ZB zb2;
        C0726aU c0726aU;
        C0560Vf c0560Vf;
        C0726aU c0726aU2;
        C3774og c3774og3;
        int i7;
        C0560Vf c0560Vf2;
        C0726aU c0726aU3;
        C3774og c3774og4;
        C3774og c3774og5;
        int i8;
        C0560Vf c0560Vf3;
        int i9;
        C0560Vf[] c0560VfArr2;
        C0560Vf c0560Vf4;
        C0726aU c0726aU4;
        C0726aU c0726aU5;
        int size;
        float f4;
        ArrayList arrayList2;
        int i10;
        float f5;
        C3774og c3774og6;
        int i11;
        float f6;
        C4397wc[] c4397wcArr3;
        boolean z6;
        int i12;
        C3774og c3774og7;
        int i13;
        int i14;
        int i15;
        C0560Vf c0560Vf5;
        C3774og c3774og8;
        C3853pg c3853pg2 = c3853pg;
        ZB zb3 = zb;
        ArrayList arrayList3 = arrayList;
        if (i2 == 0) {
            i3 = c3853pg2.y0;
            c4397wcArr = c3853pg2.B0;
            i4 = 0;
        } else {
            i3 = c3853pg2.z0;
            c4397wcArr = c3853pg2.A0;
            i4 = 2;
        }
        int i16 = i3;
        C4397wc[] c4397wcArr4 = c4397wcArr;
        int i17 = 0;
        while (i17 < i16) {
            C4397wc c4397wc = c4397wcArr4[i17];
            boolean z7 = c4397wc.q;
            C3774og c3774og9 = c4397wc.a;
            int i18 = 3;
            int i19 = 8;
            if (z7) {
                i5 = i17;
                f2 = 0.0f;
            } else {
                int i20 = c4397wc.l;
                int i21 = i20 * 2;
                C3774og c3774og10 = c3774og9;
                C3774og c3774og11 = c3774og10;
                boolean z8 = false;
                f2 = 0.0f;
                while (!z8) {
                    c4397wc.i++;
                    c3774og10.l0[i20] = null;
                    c3774og10.k0[i20] = null;
                    int i22 = c3774og10.f0;
                    C0560Vf[] c0560VfArr3 = c3774og10.P;
                    if (i22 != i19) {
                        c3774og10.j(i20);
                        c0560VfArr3[i21].e();
                        int i23 = i21 + 1;
                        c0560VfArr3[i23].e();
                        c0560VfArr3[i21].e();
                        c0560VfArr3[i23].e();
                        if (c4397wc.b == null) {
                            c4397wc.b = c3774og10;
                        }
                        c4397wc.d = c3774og10;
                        int i24 = c3774og10.o0[i20];
                        if (i24 == i18) {
                            int i25 = c3774og10.s[i20];
                            if (i25 == 0 || i25 == i18 || i25 == 2) {
                                c4397wc.j++;
                                float f7 = c3774og10.j0[i20];
                                if (f7 > 0.0f) {
                                    i14 = i17;
                                    c4397wc.k += f7;
                                } else {
                                    i14 = i17;
                                }
                                i15 = i20;
                                if (c3774og10.f0 != 8 && i24 == 3 && (i25 == 0 || i25 == 3)) {
                                    if (f7 < 0.0f) {
                                        c4397wc.n = true;
                                    } else {
                                        c4397wc.o = true;
                                    }
                                    if (c4397wc.h == null) {
                                        c4397wc.h = new ArrayList();
                                    }
                                    c4397wc.h.add(c3774og10);
                                }
                                if (c4397wc.f == null) {
                                    c4397wc.f = c3774og10;
                                }
                                C3774og c3774og12 = c4397wc.g;
                                if (c3774og12 != null) {
                                    c3774og12.k0[i15] = c3774og10;
                                }
                                c4397wc.g = c3774og10;
                            } else {
                                i14 = i17;
                                i15 = i20;
                            }
                            if (i15 == 0) {
                                if (c3774og10.q == 0 && c3774og10.t == 0) {
                                    int i26 = c3774og10.u;
                                }
                            } else if (c3774og10.r == 0 && c3774og10.w == 0) {
                                int i27 = c3774og10.x;
                            }
                            if (c3774og11 != c3774og10) {
                                c3774og11.l0[i15] = c3774og10;
                            }
                            c0560Vf5 = c0560VfArr3[i21 + 1].f;
                            if (c0560Vf5 != null) {
                                c3774og8 = c0560Vf5.d;
                                C0560Vf c0560Vf6 = c3774og8.P[i21].f;
                                if (c0560Vf6 != null) {
                                }
                            }
                            c3774og8 = null;
                            if (c3774og8 != null) {
                                c3774og8 = c3774og10;
                                z8 = true;
                            }
                            c3774og11 = c3774og10;
                            i20 = i15;
                            i18 = 3;
                            i19 = 8;
                            c3774og10 = c3774og8;
                            i17 = i14;
                        }
                    }
                    i14 = i17;
                    i15 = i20;
                    if (c3774og11 != c3774og10) {
                    }
                    c0560Vf5 = c0560VfArr3[i21 + 1].f;
                    if (c0560Vf5 != null) {
                    }
                    c3774og8 = null;
                    if (c3774og8 != null) {
                    }
                    c3774og11 = c3774og10;
                    i20 = i15;
                    i18 = 3;
                    i19 = 8;
                    c3774og10 = c3774og8;
                    i17 = i14;
                }
                i5 = i17;
                int i28 = i20;
                C3774og c3774og13 = c4397wc.b;
                if (c3774og13 != null) {
                    c3774og13.P[i21].e();
                }
                C3774og c3774og14 = c4397wc.d;
                if (c3774og14 != null) {
                    c3774og14.P[i21 + 1].e();
                }
                c4397wc.c = c3774og10;
                if (i28 == 0 && c4397wc.m) {
                    c4397wc.e = c3774og10;
                } else {
                    c4397wc.e = c3774og9;
                }
                c4397wc.p = c4397wc.o && c4397wc.n;
            }
            c4397wc.q = true;
            if (arrayList3 == null || arrayList3.contains(c3774og9)) {
                C3774og c3774og15 = c4397wc.c;
                C3774og c3774og16 = c4397wc.b;
                C3774og c3774og17 = c4397wc.d;
                C3774og c3774og18 = c4397wc.e;
                float f8 = c4397wc.k;
                boolean z9 = c3853pg2.o0[i2] == 2;
                if (i2 == 0) {
                    int i29 = c3774og18.h0;
                    boolean z10 = i29 == 0;
                    boolean z11 = i29 == 1;
                    z = i29 == 2;
                    z2 = z9;
                    z4 = z11;
                    z3 = z10;
                    z5 = false;
                    f3 = f8;
                    c3774og = c3774og9;
                } else {
                    int i30 = c3774og18.i0;
                    boolean z12 = i30 == 0;
                    boolean z13 = i30 == 1;
                    f3 = f8;
                    z = i30 == 2;
                    c3774og = c3774og9;
                    z2 = z9;
                    z3 = z12;
                    z4 = z13;
                    z5 = false;
                }
                while (true) {
                    c0560VfArr = c3853pg2.P;
                    if (z5) {
                        break;
                    }
                    C0560Vf c0560Vf7 = c3774og.P[i4];
                    int i31 = z ? 1 : 4;
                    int e2 = c0560Vf7.e();
                    boolean z14 = z5;
                    int[] iArr = c3774og.o0;
                    boolean z15 = z;
                    boolean z16 = iArr[i2] == 3 && c3774og.s[i2] == 0;
                    C0560Vf c0560Vf8 = c0560Vf7.f;
                    if (c0560Vf8 != null && c3774og != c3774og9) {
                        e2 = c0560Vf8.e() + e2;
                    }
                    int i32 = e2;
                    if (z15 && c3774og != c3774og9 && c3774og != c3774og16) {
                        i31 = 8;
                    }
                    boolean z17 = z16;
                    C0560Vf c0560Vf9 = c0560Vf7.f;
                    if (c0560Vf9 != null) {
                        if (c3774og == c3774og16) {
                            i12 = i16;
                            zb3.f(c0560Vf7.i, c0560Vf9.i, i32, 6);
                        } else {
                            i12 = i16;
                            zb3.f(c0560Vf7.i, c0560Vf9.i, i32, 8);
                        }
                        if (z17 && !z15) {
                            i31 = 5;
                        }
                        zb3.e(c0560Vf7.i, c0560Vf7.f.i, i32, (c3774og == c3774og16 && z15 && c3774og.R[i2]) ? 5 : i31);
                    } else {
                        i12 = i16;
                    }
                    C0560Vf[] c0560VfArr4 = c3774og.P;
                    if (z2) {
                        if (c3774og.f0 == 8 || iArr[i2] != 3) {
                            i13 = 0;
                        } else {
                            i13 = 0;
                            zb3.f(c0560VfArr4[i4 + 1].i, c0560VfArr4[i4].i, 0, 5);
                        }
                        zb3.f(c0560VfArr4[i4].i, c0560VfArr[i4].i, i13, 8);
                    }
                    C0560Vf c0560Vf10 = c0560VfArr4[i4 + 1].f;
                    if (c0560Vf10 != null) {
                        c3774og7 = c0560Vf10.d;
                        C0560Vf c0560Vf11 = c3774og7.P[i4].f;
                        if (c0560Vf11 != null) {
                        }
                    }
                    c3774og7 = null;
                    if (c3774og7 != null) {
                        c3774og = c3774og7;
                        z5 = z14;
                    } else {
                        z5 = true;
                    }
                    z = z15;
                    i16 = i12;
                }
                boolean z18 = z;
                i6 = i16;
                if (c3774og17 != null) {
                    int i33 = i4 + 1;
                    if (c3774og15.P[i33].f != null) {
                        C0560Vf c0560Vf12 = c3774og17.P[i33];
                        if (c3774og17.o0[i2] == 3 && c3774og17.s[i2] == 0 && !z18) {
                            C0560Vf c0560Vf13 = c0560Vf12.f;
                            if (c0560Vf13.d == c3853pg2) {
                                zb3.e(c0560Vf12.i, c0560Vf13.i, -c0560Vf12.e(), 5);
                                zb3.g(c0560Vf12.i, c3774og15.P[i33].f.i, -c0560Vf12.e(), 6);
                            }
                        }
                        if (z18) {
                            C0560Vf c0560Vf14 = c0560Vf12.f;
                            if (c0560Vf14.d == c3853pg2) {
                                zb3.e(c0560Vf12.i, c0560Vf14.i, -c0560Vf12.e(), 4);
                            }
                        }
                        zb3.g(c0560Vf12.i, c3774og15.P[i33].f.i, -c0560Vf12.e(), 6);
                    }
                }
                if (z2) {
                    int i34 = i4 + 1;
                    C0726aU c0726aU6 = c0560VfArr[i34].i;
                    C0560Vf c0560Vf15 = c3774og15.P[i34];
                    zb3.f(c0726aU6, c0560Vf15.i, c0560Vf15.e(), 8);
                }
                ArrayList arrayList4 = c4397wc.h;
                if (arrayList4 != null && (size = arrayList4.size()) > 1) {
                    if (c4397wc.n && !c4397wc.p) {
                        f3 = c4397wc.j;
                    }
                    C3774og c3774og19 = null;
                    float f9 = f2;
                    int i35 = 0;
                    while (i35 < size) {
                        C3774og c3774og20 = (C3774og) arrayList4.get(i35);
                        float f10 = c3774og20.j0[i2];
                        C0560Vf[] c0560VfArr5 = c3774og20.P;
                        if (f10 >= f2) {
                            f4 = f10;
                        } else if (c4397wc.p) {
                            arrayList2 = arrayList4;
                            i10 = size;
                            zb3.e(c0560VfArr5[i4 + 1].i, c0560VfArr5[i4].i, 0, 4);
                            z6 = false;
                            i11 = i35;
                            f6 = f2;
                            c4397wcArr3 = c4397wcArr4;
                            i35 = i11 + 1;
                            c4397wcArr4 = c4397wcArr3;
                            arrayList4 = arrayList2;
                            size = i10;
                            f2 = f6;
                        } else {
                            f4 = 1.0f;
                        }
                        arrayList2 = arrayList4;
                        i10 = size;
                        if (f4 == f2) {
                            z6 = false;
                            zb3.e(c0560VfArr5[i4 + 1].i, c0560VfArr5[i4].i, 0, 8);
                            i11 = i35;
                            f6 = f2;
                            c4397wcArr3 = c4397wcArr4;
                            i35 = i11 + 1;
                            c4397wcArr4 = c4397wcArr3;
                            arrayList4 = arrayList2;
                            size = i10;
                            f2 = f6;
                        } else {
                            if (c3774og19 != null) {
                                C0560Vf[] c0560VfArr6 = c3774og19.P;
                                C0726aU c0726aU7 = c0560VfArr6[i4].i;
                                int i36 = i4 + 1;
                                C0726aU c0726aU8 = c0560VfArr6[i36].i;
                                f5 = f4;
                                C0726aU c0726aU9 = c0560VfArr5[i4].i;
                                C0726aU c0726aU10 = c0560VfArr5[i36].i;
                                c3774og6 = c3774og20;
                                E6 l2 = zb3.l();
                                i11 = i35;
                                float f11 = f2;
                                l2.b = f11;
                                f6 = f11;
                                if (f3 == f11 || f9 == f5) {
                                    c4397wcArr3 = c4397wcArr4;
                                    l2.d.g(c0726aU7, 1.0f);
                                    l2.d.g(c0726aU8, -1.0f);
                                    l2.d.g(c0726aU10, 1.0f);
                                    l2.d.g(c0726aU9, -1.0f);
                                } else {
                                    if (f9 == f6) {
                                        l2.d.g(c0726aU7, 1.0f);
                                        l2.d.g(c0726aU8, -1.0f);
                                    } else if (f4 == f2) {
                                        l2.d.g(c0726aU9, 1.0f);
                                        l2.d.g(c0726aU10, -1.0f);
                                    } else {
                                        float f12 = (f9 / f3) / (f5 / f3);
                                        c4397wcArr3 = c4397wcArr4;
                                        l2.d.g(c0726aU7, 1.0f);
                                        l2.d.g(c0726aU8, -1.0f);
                                        l2.d.g(c0726aU10, f12);
                                        l2.d.g(c0726aU9, -f12);
                                    }
                                    c4397wcArr3 = c4397wcArr4;
                                }
                                zb3.c(l2);
                            } else {
                                f5 = f4;
                                c3774og6 = c3774og20;
                                i11 = i35;
                                f6 = f2;
                                c4397wcArr3 = c4397wcArr4;
                            }
                            c3774og19 = c3774og6;
                            f9 = f5;
                            i35 = i11 + 1;
                            c4397wcArr4 = c4397wcArr3;
                            arrayList4 = arrayList2;
                            size = i10;
                            f2 = f6;
                        }
                    }
                }
                c4397wcArr2 = c4397wcArr4;
                if (c3774og16 == null || !(c3774og16 == c3774og17 || z18)) {
                    c3774og2 = c3774og17;
                    if (z3 && c3774og16 != null) {
                        int i37 = c4397wc.j;
                        boolean z19 = i37 > 0 && c4397wc.i == i37;
                        C3774og c3774og21 = c3774og16;
                        C3774og c3774og22 = c3774og21;
                        while (c3774og21 != null) {
                            C3774og c3774og23 = c3774og21.l0[i2];
                            while (true) {
                                if (c3774og23 == null) {
                                    i7 = 8;
                                    break;
                                }
                                i7 = 8;
                                if (c3774og23.f0 != 8) {
                                    break;
                                } else {
                                    c3774og23 = c3774og23.l0[i2];
                                }
                            }
                            if (c3774og23 != null || c3774og21 == c3774og2) {
                                C0560Vf[] c0560VfArr7 = c3774og21.P;
                                C0560Vf c0560Vf16 = c0560VfArr7[i4];
                                C0726aU c0726aU11 = c0560Vf16.i;
                                C0560Vf c0560Vf17 = c0560Vf16.f;
                                C0726aU c0726aU12 = c0560Vf17 != null ? c0560Vf17.i : null;
                                if (c3774og22 != c3774og21) {
                                    c0726aU12 = c3774og22.P[i4 + 1].i;
                                } else if (c3774og21 == c3774og16) {
                                    C0560Vf c0560Vf18 = c3774og9.P[i4].f;
                                    c0726aU12 = c0560Vf18 != null ? c0560Vf18.i : null;
                                }
                                int e3 = c0560Vf16.e();
                                int i38 = i4 + 1;
                                int e4 = c0560VfArr7[i38].e();
                                if (c3774og23 != null) {
                                    c0560Vf2 = c3774og23.P[i4];
                                    c0726aU3 = c0560Vf2.i;
                                } else {
                                    c0560Vf2 = c3774og15.P[i38].f;
                                    c0726aU3 = c0560Vf2 != null ? c0560Vf2.i : null;
                                }
                                C0726aU c0726aU13 = c0560VfArr7[i38].i;
                                if (c0560Vf2 != null) {
                                    e4 += c0560Vf2.e();
                                }
                                int e5 = c3774og22.P[i38].e() + e3;
                                if (c0726aU11 == null || c0726aU12 == null || c0726aU3 == null || c0726aU13 == null) {
                                    c3774og4 = c3774og9;
                                    c3774og5 = c3774og22;
                                    i8 = 8;
                                } else {
                                    if (c3774og21 == c3774og16) {
                                        e5 = c3774og16.P[i4].e();
                                    }
                                    if (c3774og21 == c3774og2) {
                                        e4 = c3774og2.P[i38].e();
                                    }
                                    c3774og4 = c3774og9;
                                    c3774og5 = c3774og22;
                                    i8 = 8;
                                    zb.b(c0726aU11, c0726aU12, e5, 0.5f, c0726aU3, c0726aU13, e4, z19 ? 8 : 5);
                                }
                            } else {
                                c3774og4 = c3774og9;
                                c3774og5 = c3774og22;
                                i8 = i7;
                            }
                            if (c3774og21.f0 != i8) {
                                c3774og5 = c3774og21;
                            }
                            c3774og21 = c3774og23;
                            c3774og22 = c3774og5;
                            c3774og9 = c3774og4;
                        }
                    } else if (z4 && c3774og16 != null) {
                        int i39 = c4397wc.j;
                        boolean z20 = i39 > 0 && c4397wc.i == i39;
                        C3774og c3774og24 = c3774og16;
                        C3774og c3774og25 = c3774og24;
                        while (c3774og24 != null) {
                            C3774og c3774og26 = c3774og24.l0[i2];
                            while (c3774og26 != null && c3774og26.f0 == 8) {
                                c3774og26 = c3774og26.l0[i2];
                            }
                            if (c3774og24 != c3774og16 && c3774og24 != c3774og2 && c3774og26 != null) {
                                if (c3774og26 == c3774og2) {
                                    c3774og26 = null;
                                }
                                C0560Vf[] c0560VfArr8 = c3774og24.P;
                                C0560Vf c0560Vf19 = c0560VfArr8[i4];
                                C0726aU c0726aU14 = c0560Vf19.i;
                                int i40 = i4 + 1;
                                C0726aU c0726aU15 = c3774og25.P[i40].i;
                                int e6 = c0560Vf19.e();
                                int e7 = c0560VfArr8[i40].e();
                                if (c3774og26 != null) {
                                    c0560Vf = c3774og26.P[i4];
                                    c0726aU2 = c0560Vf.i;
                                    C0560Vf c0560Vf20 = c0560Vf.f;
                                    c0726aU = c0560Vf20 != null ? c0560Vf20.i : null;
                                } else {
                                    C0560Vf c0560Vf21 = c3774og2.P[i4];
                                    C0726aU c0726aU16 = c0560Vf21 != null ? c0560Vf21.i : null;
                                    c0726aU = c0560VfArr8[i40].i;
                                    c0560Vf = c0560Vf21;
                                    c0726aU2 = c0726aU16;
                                }
                                if (c0560Vf != null) {
                                    e7 += c0560Vf.e();
                                }
                                int e8 = c3774og25.P[i40].e() + e6;
                                C0726aU c0726aU17 = c0726aU2;
                                int i41 = e7;
                                C0726aU c0726aU18 = c0726aU;
                                int i42 = z20 ? 8 : 4;
                                if (c0726aU14 == null || c0726aU15 == null || c0726aU17 == null || c0726aU18 == null) {
                                    c3774og3 = c3774og26;
                                } else {
                                    c3774og3 = c3774og26;
                                    zb.b(c0726aU14, c0726aU15, e8, 0.5f, c0726aU17, c0726aU18, i41, i42);
                                }
                                c3774og26 = c3774og3;
                            }
                            if (c3774og24.f0 != 8) {
                                c3774og25 = c3774og24;
                            }
                            c3774og24 = c3774og26;
                        }
                        C0560Vf c0560Vf22 = c3774og16.P[i4];
                        C0560Vf c0560Vf23 = c3774og9.P[i4].f;
                        int i43 = i4 + 1;
                        C0560Vf c0560Vf24 = c3774og2.P[i43];
                        C0560Vf c0560Vf25 = c3774og15.P[i43].f;
                        if (c0560Vf23 != null) {
                            if (c3774og16 != c3774og2) {
                                zb.e(c0560Vf22.i, c0560Vf23.i, c0560Vf22.e(), 5);
                            } else if (c0560Vf25 != null) {
                                zb2 = zb;
                                zb2.b(c0560Vf22.i, c0560Vf23.i, c0560Vf22.e(), 0.5f, c0560Vf24.i, c0560Vf25.i, c0560Vf24.e(), 5);
                                if (c0560Vf25 != null && c3774og16 != c3774og2) {
                                    zb2.e(c0560Vf24.i, c0560Vf25.i, -c0560Vf24.e(), 5);
                                }
                                if ((!z3 || z4) && c3774og16 != null && c3774og16 != c3774og2) {
                                    C0560Vf[] c0560VfArr9 = c3774og16.P;
                                    c0560Vf3 = c0560VfArr9[i4];
                                    if (c3774og2 == null) {
                                        c3774og2 = c3774og16;
                                    }
                                    i9 = i4 + 1;
                                    c0560VfArr2 = c3774og2.P;
                                    c0560Vf4 = c0560VfArr2[i9];
                                    C0560Vf c0560Vf26 = c0560Vf3.f;
                                    c0726aU4 = c0560Vf26 != null ? c0560Vf26.i : null;
                                    C0560Vf c0560Vf27 = c0560Vf4.f;
                                    c0726aU5 = c0560Vf27 != null ? c0560Vf27.i : null;
                                    if (c3774og15 != c3774og2) {
                                        C0560Vf c0560Vf28 = c3774og15.P[i9].f;
                                        c0726aU5 = c0560Vf28 != null ? c0560Vf28.i : null;
                                    }
                                    if (c3774og16 == c3774og2) {
                                        c0560Vf4 = c0560VfArr9[i9];
                                    }
                                    if (c0726aU4 == null && c0726aU5 != null) {
                                        zb2.b(c0560Vf3.i, c0726aU4, c0560Vf3.e(), 0.5f, c0726aU5, c0560Vf4.i, c0560VfArr2[i9].e(), 5);
                                    }
                                }
                            }
                        }
                        zb2 = zb;
                        if (c0560Vf25 != null) {
                            zb2.e(c0560Vf24.i, c0560Vf25.i, -c0560Vf24.e(), 5);
                        }
                        if (!z3) {
                        }
                        C0560Vf[] c0560VfArr92 = c3774og16.P;
                        c0560Vf3 = c0560VfArr92[i4];
                        if (c3774og2 == null) {
                        }
                        i9 = i4 + 1;
                        c0560VfArr2 = c3774og2.P;
                        c0560Vf4 = c0560VfArr2[i9];
                        C0560Vf c0560Vf262 = c0560Vf3.f;
                        if (c0560Vf262 != null) {
                        }
                        C0560Vf c0560Vf272 = c0560Vf4.f;
                        if (c0560Vf272 != null) {
                        }
                        if (c3774og15 != c3774og2) {
                        }
                        if (c3774og16 == c3774og2) {
                        }
                        if (c0726aU4 == null) {
                            zb2.b(c0560Vf3.i, c0726aU4, c0560Vf3.e(), 0.5f, c0726aU5, c0560Vf4.i, c0560VfArr2[i9].e(), 5);
                        }
                    }
                } else {
                    C0560Vf c0560Vf29 = c3774og9.P[i4];
                    int i44 = i4 + 1;
                    C0560Vf c0560Vf30 = c3774og15.P[i44];
                    C0560Vf c0560Vf31 = c0560Vf29.f;
                    C0726aU c0726aU19 = c0560Vf31 != null ? c0560Vf31.i : null;
                    C0560Vf c0560Vf32 = c0560Vf30.f;
                    C0726aU c0726aU20 = c0560Vf32 != null ? c0560Vf32.i : null;
                    C0560Vf c0560Vf33 = c3774og16.P[i4];
                    if (c3774og17 != null) {
                        c0560Vf30 = c3774og17.P[i44];
                    }
                    if (c0726aU19 == null || c0726aU20 == null) {
                        c3774og2 = c3774og17;
                    } else {
                        float f13 = i2 == 0 ? c3774og18.c0 : c3774og18.d0;
                        int e9 = c0560Vf33.e();
                        int e10 = c0560Vf30.e();
                        C0726aU c0726aU21 = c0560Vf33.i;
                        C0726aU c0726aU22 = c0560Vf30.i;
                        C0726aU c0726aU23 = c0726aU19;
                        c3774og2 = c3774og17;
                        zb3.b(c0726aU21, c0726aU23, e9, f13, c0726aU20, c0726aU22, e10, 7);
                    }
                }
                zb2 = zb;
                if (!z3) {
                }
                C0560Vf[] c0560VfArr922 = c3774og16.P;
                c0560Vf3 = c0560VfArr922[i4];
                if (c3774og2 == null) {
                }
                i9 = i4 + 1;
                c0560VfArr2 = c3774og2.P;
                c0560Vf4 = c0560VfArr2[i9];
                C0560Vf c0560Vf2622 = c0560Vf3.f;
                if (c0560Vf2622 != null) {
                }
                C0560Vf c0560Vf2722 = c0560Vf4.f;
                if (c0560Vf2722 != null) {
                }
                if (c3774og15 != c3774og2) {
                }
                if (c3774og16 == c3774og2) {
                }
                if (c0726aU4 == null) {
                }
            } else {
                i6 = i16;
                c4397wcArr2 = c4397wcArr4;
            }
            i17 = i5 + 1;
            c3853pg2 = c3853pg;
            zb3 = zb;
            arrayList3 = arrayList;
            c4397wcArr4 = c4397wcArr2;
            i16 = i6;
        }
    }

    public static byte[] d0(C2853d6 c2853d6) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            C4446xA I = c2853d6.I();
            try {
                int a2 = I.a(null);
                Logger logger = AbstractC3612me.r;
                if (a2 > 4096) {
                    a2 = 4096;
                }
                C3372je c3372je = new C3372je(byteArrayOutputStream, a2);
                I.f(c3372je);
                if (c3372je.v > 0) {
                    c3372je.r0();
                }
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (IOException unused) {
            throw new GeneralSecurityException("Serialize keyset failed");
        }
    }

    public static void e(int i2, Object obj) {
        if (obj == null || L(i2, obj)) {
            return;
        }
        h0(obj, "kotlin.jvm.functions.Function" + i2);
        throw null;
    }

    public static void e0(AppBarLayout appBarLayout, float f2) {
        int integer = appBarLayout.getResources().getInteger(dastan.prince.bdfreevpn.R.integer.app_bar_elevation_anim_duration);
        StateListAnimator stateListAnimator = new StateListAnimator();
        long j2 = integer;
        stateListAnimator.addState(new int[]{R.attr.state_enabled, dastan.prince.bdfreevpn.R.attr.state_liftable, -2130969742}, ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(j2));
        stateListAnimator.addState(new int[]{R.attr.state_enabled}, ObjectAnimator.ofFloat(appBarLayout, "elevation", f2).setDuration(j2));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(appBarLayout, "elevation", 0.0f).setDuration(0L));
        appBarLayout.setStateListAnimator(stateListAnimator);
    }

    public static void f0(EditorInfo editorInfo, CharSequence charSequence, int i2, int i3) {
        if (editorInfo.extras == null) {
            editorInfo.extras = new Bundle();
        }
        editorInfo.extras.putCharSequence("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SURROUNDING_TEXT", charSequence != null ? new SpannableStringBuilder(charSequence) : null);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_HEAD", i2);
        editorInfo.extras.putInt("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_SELECTION_END", i3);
    }

    public static int g0(int i2, byte[] bArr, int i3, int i4, C4201u6 c4201u6) {
        if ((i2 >>> 3) == 0) {
            throw C4186ty.a();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            return v(bArr, i3, c4201u6);
        }
        if (i5 == 1) {
            return i3 + 8;
        }
        if (i5 == 2) {
            return t(bArr, i3, c4201u6) + c4201u6.a;
        }
        if (i5 != 3) {
            if (i5 == 5) {
                return i3 + 4;
            }
            throw C4186ty.a();
        }
        int i6 = (i2 & (-8)) | 4;
        int i7 = 0;
        while (i3 < i4) {
            i3 = t(bArr, i3, c4201u6);
            i7 = c4201u6.a;
            if (i7 == i6) {
                break;
            }
            i3 = g0(i7, bArr, i3, i4, c4201u6);
        }
        if (i3 > i4 || i7 != i6) {
            throw C4186ty.f();
        }
        return i3;
    }

    public static void h0(Object obj, String str) {
        ClassCastException classCastException = new ClassCastException(W50.n(obj == null ? "null" : obj.getClass().getName(), " cannot be cast to ", str));
        AbstractC3634my.F(classCastException, AbstractC0731aZ.class.getName());
        throw classCastException;
    }

    public static final long i0(double d2, EnumC4016rm enumC4016rm) {
        double d3 = S50.d(d2, enumC4016rm, EnumC4016rm.b);
        if (Double.isNaN(d3)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long H = Ke0.H(d3);
        return (-4611686018426999999L > H || H >= 4611686018427000000L) ? y(Ke0.H(S50.d(d2, enumC4016rm, EnumC4016rm.d))) : z(H);
    }

    public static C0679Zu j(GetTopicsResponse getTopicsResponse) {
        List topics;
        List encryptedTopics;
        byte[] encryptedTopic;
        String keyIdentifier;
        byte[] encapsulatedKey;
        long taxonomyVersion;
        long modelVersion;
        int topicId;
        AbstractC3634my.g(getTopicsResponse, "response");
        ArrayList arrayList = new ArrayList();
        topics = getTopicsResponse.getTopics();
        Iterator it = topics.iterator();
        while (it.hasNext()) {
            Topic k2 = AbstractC3645n4.k(it.next());
            taxonomyVersion = k2.getTaxonomyVersion();
            modelVersion = k2.getModelVersion();
            topicId = k2.getTopicId();
            arrayList.add(new C4627zX(taxonomyVersion, topicId, modelVersion));
        }
        ArrayList arrayList2 = new ArrayList();
        encryptedTopics = getTopicsResponse.getEncryptedTopics();
        Iterator it2 = encryptedTopics.iterator();
        while (it2.hasNext()) {
            EncryptedTopic a2 = AbstractC0760av.a(it2.next());
            encryptedTopic = a2.getEncryptedTopic();
            AbstractC3634my.f(encryptedTopic, "encryptedTopic.encryptedTopic");
            keyIdentifier = a2.getKeyIdentifier();
            AbstractC3634my.f(keyIdentifier, "encryptedTopic.keyIdentifier");
            encapsulatedKey = a2.getEncapsulatedKey();
            AbstractC3634my.f(encapsulatedKey, "encryptedTopic.encapsulatedKey");
            arrayList2.add(new C3861po(encryptedTopic, keyIdentifier, encapsulatedKey));
        }
        return new C0679Zu(arrayList, arrayList2);
    }

    public static final long j0(int i2, EnumC4016rm enumC4016rm) {
        AbstractC3634my.g(enumC4016rm, "unit");
        return enumC4016rm.compareTo(EnumC4016rm.e) <= 0 ? z(S50.e(i2, enumC4016rm, EnumC4016rm.b)) : k0(i2, enumC4016rm);
    }

    public static void k(long[] jArr, long[] jArr2, int i2) {
        int i3 = -i2;
        for (int i4 = 0; i4 < 10; i4++) {
            long j2 = jArr[i4];
            jArr[i4] = ((int) j2) ^ ((((int) j2) ^ ((int) jArr2[i4])) & i3);
        }
    }

    public static final long k0(long j2, EnumC4016rm enumC4016rm) {
        AbstractC3634my.g(enumC4016rm, "unit");
        EnumC4016rm enumC4016rm2 = EnumC4016rm.b;
        long e2 = S50.e(4611686018426999999L, enumC4016rm2, enumC4016rm);
        if ((-e2) <= j2 && j2 <= e2) {
            return z(S50.e(j2, enumC4016rm, enumC4016rm2));
        }
        EnumC4016rm enumC4016rm3 = EnumC4016rm.d;
        AbstractC3634my.g(enumC4016rm3, "targetUnit");
        return x(AbstractC0538Uj.i(enumC4016rm3.a.convert(j2, enumC4016rm.a)));
    }

    public static final C3116gQ l(TG tg) {
        C4254un c4254un = g;
        LinkedHashMap linkedHashMap = tg.a;
        InterfaceC3910qQ interfaceC3910qQ = (InterfaceC3910qQ) linkedHashMap.get(c4254un);
        if (interfaceC3910qQ == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        InterfaceC4115t20 interfaceC4115t20 = (InterfaceC4115t20) linkedHashMap.get(h);
        if (interfaceC4115t20 == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(i);
        String str = (String) linkedHashMap.get(C2835cv.e);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        InterfaceC3594mQ b2 = interfaceC3910qQ.getSavedStateRegistry().b();
        Bundle bundle2 = null;
        C3354jQ c3354jQ = b2 instanceof C3354jQ ? (C3354jQ) b2 : null;
        if (c3354jQ == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        LinkedHashMap linkedHashMap2 = I(interfaceC4115t20).b;
        C3116gQ c3116gQ = (C3116gQ) linkedHashMap2.get(str);
        if (c3116gQ != null) {
            return c3116gQ;
        }
        c3354jQ.b();
        Bundle bundle3 = c3354jQ.c;
        if (bundle3 != null && bundle3.containsKey(str)) {
            Bundle bundle4 = bundle3.getBundle(str);
            if (bundle4 == null) {
                bundle4 = W80.d((EJ[]) Arrays.copyOf(new EJ[0], 0));
            }
            bundle3.remove(str);
            if (bundle3.isEmpty()) {
                c3354jQ.c = null;
            }
            bundle2 = bundle4;
        }
        C3116gQ o = AbstractC0325Me.o(bundle2, bundle);
        linkedHashMap2.put(str, o);
        return o;
    }

    public static Class l0(Class cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Byte.TYPE ? Byte.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Void.TYPE ? Void.class : cls;
    }

    public static int m(byte[] bArr, int i2, C4201u6 c4201u6) {
        int t = t(bArr, i2, c4201u6);
        int i3 = c4201u6.a;
        if (i3 < 0) {
            throw C4186ty.e();
        }
        if (i3 > bArr.length - t) {
            throw C4186ty.g();
        }
        if (i3 == 0) {
            c4201u6.c = AbstractC4237ub.b;
            return t;
        }
        c4201u6.c = AbstractC4237ub.d(bArr, t, i3);
        return t + i3;
    }

    public static float m0() {
        return ((float) Math.pow((50.0f + 16.0d) / 116.0d, 3.0d)) * 100.0f;
    }

    public static int n(int i2, byte[] bArr) {
        return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
    }

    public static long o(int i2, byte[] bArr) {
        return ((bArr[i2 + 7] & 255) << 56) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16) | ((bArr[i2 + 3] & 255) << 24) | ((bArr[i2 + 4] & 255) << 32) | ((bArr[i2 + 5] & 255) << 40) | ((bArr[i2 + 6] & 255) << 48);
    }

    public static int p(AQ aq, byte[] bArr, int i2, int i3, int i4, C4201u6 c4201u6) {
        Object d2 = aq.d();
        int Q = Q(d2, aq, bArr, i2, i3, i4, c4201u6);
        aq.b(d2);
        c4201u6.c = d2;
        return Q;
    }

    public static int q(AQ aq, int i2, byte[] bArr, int i3, int i4, InterfaceC0604Wx interfaceC0604Wx, C4201u6 c4201u6) {
        Object d2 = aq.d();
        AQ aq2 = aq;
        byte[] bArr2 = bArr;
        int i5 = i4;
        C4201u6 c4201u62 = c4201u6;
        int R = R(d2, aq2, bArr2, i3, i5, c4201u62);
        aq2.b(d2);
        c4201u62.c = d2;
        interfaceC0604Wx.add(d2);
        while (R < i5) {
            C4201u6 c4201u63 = c4201u62;
            int i6 = i5;
            int t = t(bArr2, R, c4201u63);
            if (i2 != c4201u63.a) {
                break;
            }
            byte[] bArr3 = bArr2;
            AQ aq3 = aq2;
            Object d3 = aq3.d();
            R = R(d3, aq3, bArr3, t, i6, c4201u63);
            aq2 = aq3;
            bArr2 = bArr3;
            i5 = i6;
            c4201u62 = c4201u63;
            aq2.b(d3);
            c4201u62.c = d3;
            interfaceC0604Wx.add(d3);
        }
        return R;
    }

    public static int r(int i2, byte[] bArr, int i3, int i4, C4629zZ c4629zZ, C4201u6 c4201u6) {
        if ((i2 >>> 3) == 0) {
            throw C4186ty.a();
        }
        int i5 = i2 & 7;
        if (i5 == 0) {
            int v = v(bArr, i3, c4201u6);
            c4629zZ.f(i2, Long.valueOf(c4201u6.b));
            return v;
        }
        if (i5 == 1) {
            c4629zZ.f(i2, Long.valueOf(o(i3, bArr)));
            return i3 + 8;
        }
        if (i5 == 2) {
            int t = t(bArr, i3, c4201u6);
            int i6 = c4201u6.a;
            if (i6 < 0) {
                throw C4186ty.e();
            }
            if (i6 > bArr.length - t) {
                throw C4186ty.g();
            }
            if (i6 == 0) {
                c4629zZ.f(i2, AbstractC4237ub.b);
            } else {
                c4629zZ.f(i2, AbstractC4237ub.d(bArr, t, i6));
            }
            return t + i6;
        }
        if (i5 != 3) {
            if (i5 != 5) {
                throw C4186ty.a();
            }
            c4629zZ.f(i2, Integer.valueOf(n(i3, bArr)));
            return i3 + 4;
        }
        C4629zZ c4629zZ2 = new C4629zZ();
        int i7 = (i2 & (-8)) | 4;
        int i8 = c4201u6.d + 1;
        c4201u6.d = i8;
        if (i8 >= 100) {
            throw new C4186ty("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
        int i9 = 0;
        while (true) {
            if (i3 >= i4) {
                break;
            }
            int t2 = t(bArr, i3, c4201u6);
            i9 = c4201u6.a;
            if (i9 == i7) {
                i3 = t2;
                break;
            }
            i3 = r(i9, bArr, t2, i4, c4629zZ2, c4201u6);
        }
        c4201u6.d--;
        if (i3 > i4 || i9 != i7) {
            throw C4186ty.f();
        }
        c4629zZ.f(i2, c4629zZ2);
        return i3;
    }

    public static int s(int i2, byte[] bArr, int i3, C4201u6 c4201u6) {
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

    public static int t(byte[] bArr, int i2, C4201u6 c4201u6) {
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 < 0) {
            return s(b2, bArr, i3, c4201u6);
        }
        c4201u6.a = b2;
        return i3;
    }

    public static int u(int i2, byte[] bArr, int i3, int i4, InterfaceC0604Wx interfaceC0604Wx, C4201u6 c4201u6) {
        C0111Dx c0111Dx = (C0111Dx) interfaceC0604Wx;
        int t = t(bArr, i3, c4201u6);
        c0111Dx.b(c4201u6.a);
        while (t < i4) {
            int t2 = t(bArr, t, c4201u6);
            if (i2 != c4201u6.a) {
                break;
            }
            t = t(bArr, t2, c4201u6);
            c0111Dx.b(c4201u6.a);
        }
        return t;
    }

    public static int v(byte[] bArr, int i2, C4201u6 c4201u6) {
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

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0037, code lost:
    
        if (r0 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003a, code lost:
    
        if (r4 > 0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r4 < 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int w(int i2, int i3) {
        RoundingMode roundingMode = RoundingMode.CEILING;
        roundingMode.getClass();
        if (i3 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        int i4 = i2 / i3;
        int i5 = i2 - (i3 * i4);
        if (i5 != 0) {
            int i6 = ((i2 ^ i3) >> 31) | 1;
            switch (AbstractC0163Fx.a[roundingMode.ordinal()]) {
                case 1:
                    if (i5 != 0) {
                        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
                    }
                case 2:
                    return i4;
                case 3:
                    break;
                case 4:
                    return i4 + i6;
                case 5:
                    break;
                case 6:
                case 7:
                case 8:
                    int abs = Math.abs(i5);
                    int abs2 = abs - (Math.abs(i3) - abs);
                    if (abs2 == 0) {
                        RoundingMode roundingMode2 = RoundingMode.HALF_UP;
                        RoundingMode roundingMode3 = RoundingMode.HALF_EVEN;
                    }
                    return i4;
                default:
                    throw new AssertionError();
            }
        }
        return i4;
    }

    public static final long x(long j2) {
        long j3 = (j2 << 1) + 1;
        int i2 = C3859pm.d;
        int i3 = AbstractC3938qm.a;
        return j3;
    }

    public static final long y(long j2) {
        return (-4611686018426L > j2 || j2 >= 4611686018427L) ? x(AbstractC0538Uj.i(j2)) : z(j2 * 1000000);
    }

    public static final long z(long j2) {
        long j3 = j2 << 1;
        int i2 = C3859pm.d;
        int i3 = AbstractC3938qm.a;
        return j3;
    }

    public abstract Integer C();

    public abstract GJ H();

    public abstract void T(int i2);

    public abstract void U(Typeface typeface);

    public abstract void V(C3795p0 c3795p0, C3795p0 c3795p02);

    public abstract void W(C3795p0 c3795p0, Thread thread);

    public void f(int i2) {
        new Handler(Looper.getMainLooper()).post(new RunnableC4539yO(this, i2, 0));
    }

    public abstract boolean g(AbstractC3874q0 abstractC3874q0, C3558m0 c3558m0, C3558m0 c3558m02);

    public abstract boolean h(AbstractC3874q0 abstractC3874q0, Object obj, Object obj2);

    public abstract boolean i(AbstractC3874q0 abstractC3874q0, C3795p0 c3795p0, C3795p0 c3795p02);
}
