package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.common.api.Api;
import com.google.android.material.appbar.MaterialToolbar;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.GeneralSecurityException;
import java.security.Provider;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public abstract class XE implements SK {
    public static Method g;
    public static boolean h;
    public final /* synthetic */ int a;
    public static final int[] b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    public static final String[] c = {"standard", "accelerate", "decelerate", "linear"};
    public static final int[] d = {R.attr.theme, dastan.prince.bdfreevpn.R.attr.theme};
    public static final int[] e = {dastan.prince.bdfreevpn.R.attr.materialThemeOverlay};
    public static final Object f = new Object();
    public static final C3092g6 i = new C3092g6(6);
    public static final T50 j = new T50(8);
    public static final T50 k = new T50(18);
    public static final T50 l = new T50(28);
    public static final C4084sd0 m = new C4084sd0(7);

    public /* synthetic */ XE(int i2) {
        this.a = i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object A(InterfaceC0613Xg interfaceC0613Xg, InterfaceC3233hu interfaceC3233hu, InterfaceC0198Hg interfaceC0198Hg) {
        Object c0;
        InterfaceC0613Xg context = interfaceC0198Hg.getContext();
        InterfaceC0613Xg plus = !((Boolean) interfaceC0613Xg.fold(Boolean.FALSE, new C0144Fe(2))).booleanValue() ? context.plus(interfaceC0613Xg) : AbstractC0325Me.v(context, interfaceC0613Xg, false);
        AbstractC0325Me.q(plus);
        if (plus == context) {
            HQ hq = new HQ(interfaceC0198Hg, plus);
            c0 = AbstractC3634my.H(hq, hq, interfaceC3233hu);
        } else {
            C0756ar c0756ar = C0756ar.b;
            if (AbstractC3634my.a(plus.get(c0756ar), context.get(c0756ar))) {
                C4076sZ c4076sZ = new C4076sZ(interfaceC0198Hg, plus);
                InterfaceC0613Xg interfaceC0613Xg2 = c4076sZ.c;
                Object h0 = AbstractC0538Uj.h0(interfaceC0613Xg2, null);
                try {
                    Object H = AbstractC3634my.H(c4076sZ, c4076sZ, interfaceC3233hu);
                    AbstractC0538Uj.N(interfaceC0613Xg2, h0);
                    c0 = H;
                } catch (Throwable th) {
                    AbstractC0538Uj.N(interfaceC0613Xg2, h0);
                    throw th;
                }
            } else {
                C4647zl c4647zl = new C4647zl(interfaceC0198Hg, plus);
                try {
                    AbstractC3634my.E(S50.w(((X9) interfaceC3233hu).create(c4647zl, c4647zl)), C4471xZ.a);
                    while (true) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = C4647zl.e;
                        int i2 = atomicIntegerFieldUpdater.get(c4647zl);
                        if (i2 != 0) {
                            if (i2 != 2) {
                                throw new IllegalStateException("Already suspended");
                            }
                            c0 = AbstractC0641Yi.c0(C3316iz.a.get(c4647zl));
                            if (c0 instanceof C0663Ze) {
                                throw ((C0663Ze) c0).a;
                            }
                        } else if (atomicIntegerFieldUpdater.compareAndSet(c4647zl, 0, 1)) {
                            c0 = EnumC3299ih.a;
                            break;
                        }
                    }
                } catch (Throwable th2) {
                    c4647zl.resumeWith(W80.j(th2));
                    throw th2;
                }
            }
        }
        EnumC3299ih enumC3299ih = EnumC3299ih.a;
        return c0;
    }

    public static Context B(Context context, AttributeSet attributeSet, int i2, int i3) {
        return C(context, attributeSet, i2, i3, new int[0]);
    }

    public static Context C(Context context, AttributeSet attributeSet, int i2, int i3, int[] iArr) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e, i2, i3);
        int[] iArr2 = {obtainStyledAttributes.getResourceId(0, 0)};
        obtainStyledAttributes.recycle();
        int i4 = iArr2[0];
        boolean z = (context instanceof C0172Gg) && ((C0172Gg) context).a == i4;
        if (i4 == 0 || z) {
            return context;
        }
        C0172Gg c0172Gg = new C0172Gg(context, i4);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        if (iArr.length > 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            for (int i5 = 0; i5 < iArr.length; i5++) {
                iArr3[i5] = obtainStyledAttributes2.getResourceId(i5, 0);
            }
            obtainStyledAttributes2.recycle();
        }
        for (int i6 = 0; i6 < length; i6++) {
            int i7 = iArr3[i6];
            if (i7 != 0) {
                c0172Gg.getTheme().applyStyle(i7, true);
            }
        }
        TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, d);
        int resourceId = obtainStyledAttributes3.getResourceId(0, 0);
        int resourceId2 = obtainStyledAttributes3.getResourceId(1, 0);
        obtainStyledAttributes3.recycle();
        if (resourceId == 0) {
            resourceId = resourceId2;
        }
        if (resourceId != 0) {
            c0172Gg.getTheme().applyStyle(resourceId, true);
        }
        return c0172Gg;
    }

    public static final C0559Ve a(Object obj) {
        C0559Ve c0559Ve = new C0559Ve();
        c0559Ve.D(obj);
        return c0559Ve;
    }

    public static void b(Throwable th, Throwable th2) {
        AbstractC3634my.g(th, "<this>");
        AbstractC3634my.g(th2, "exception");
        if (th != th2) {
            Integer num = AbstractC0086Cy.a;
            if (num == null || num.intValue() >= 19) {
                th.addSuppressed(th2);
                return;
            }
            Method method = AbstractC2950eK.a;
            if (method != null) {
                method.invoke(th, th2);
            }
        }
    }

    public static C0202Hk c(InterfaceC3220hh interfaceC3220hh, InterfaceC0613Xg interfaceC0613Xg, InterfaceC3233hu interfaceC3233hu, int i2) {
        if ((i2 & 1) != 0) {
            interfaceC0613Xg = C0912co.a;
        }
        EnumC3458kh enumC3458kh = EnumC3458kh.a;
        InterfaceC0613Xg L = AbstractC0325Me.L(interfaceC3220hh, interfaceC0613Xg);
        EnumC3458kh enumC3458kh2 = EnumC3458kh.a;
        C0202Hk c0202Hk = new C0202Hk(L, true);
        c0202Hk.T(enumC3458kh, c0202Hk, interfaceC3233hu);
        return c0202Hk;
    }

    public static void d(int i2, int i3, int i4) {
        if (i2 >= 0 && i3 <= i4) {
            if (i2 > i3) {
                throw new IllegalArgumentException(W50.l("startIndex: ", i2, i3, " > endIndex: "));
            }
            return;
        }
        throw new IndexOutOfBoundsException("startIndex: " + i2 + ", endIndex: " + i3 + ", size: " + i4);
    }

    public static void e(int i2, int i3, int i4) {
        if (i2 >= 0 && i3 <= i4) {
            if (i2 > i3) {
                throw new IllegalArgumentException(W50.l("fromIndex: ", i2, i3, " > toIndex: "));
            }
            return;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i2 + ", toIndex: " + i3 + ", size: " + i4);
    }

    public static SK f(F2 f2) {
        C2882dV c2882dV = f2.p;
        byte[] b2 = ((C4395wb) c2882dV.b).b();
        TK tk = new TK();
        AbstractC3955r10.a(b2.length);
        SecretKeySpec secretKeySpec = new SecretKeySpec(b2, "AES");
        if (!ZT.e(1)) {
            throw new GeneralSecurityException("Can not use AES-CMAC in FIPS-mode.");
        }
        Cipher cipher = (Cipher) TK.a.get();
        cipher.init(1, secretKeySpec);
        AbstractC0325Me.p(AbstractC0325Me.p(cipher.doFinal(new byte[16])));
        try {
            Provider E = Ke0.E();
            if (E == null) {
                throw new GeneralSecurityException("Conscrypt not available");
            }
            Mac.getInstance("AESCMAC", E);
            return new C0756ar(tk, new C0213Hv(((C4395wb) c2882dV.b).b(), E));
        } catch (GeneralSecurityException unused) {
            return tk;
        }
    }

    public static AbstractC3642n20 g(Class cls) {
        try {
            Constructor declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!Modifier.isPublic(declaredConstructor.getModifiers())) {
                throw new RuntimeException("Cannot create an instance of " + cls);
            }
            try {
                Object newInstance = declaredConstructor.newInstance(new Object[0]);
                AbstractC3634my.d(newInstance);
                return (AbstractC3642n20) newInstance;
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + cls, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + cls, e3);
            }
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Cannot create an instance of " + cls, e4);
        }
    }

    public static int j(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        return cursor.getColumnIndexOrThrow("`" + str + "`");
    }

    public static Drawable k(Context context, int i2) {
        return C4302vO.b().c(context, i2);
    }

    public static final C0582Wb l(InterfaceC0198Hg interfaceC0198Hg) {
        C0582Wb c0582Wb;
        C0582Wb c0582Wb2;
        if (!(interfaceC0198Hg instanceof C4568yl)) {
            return new C0582Wb(1, interfaceC0198Hg);
        }
        C4568yl c4568yl = (C4568yl) interfaceC0198Hg;
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = C4568yl.h;
            Object obj = atomicReferenceFieldUpdater.get(c4568yl);
            Q2 q2 = AbstractC3634my.c;
            c0582Wb = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(c4568yl, q2);
                c0582Wb2 = null;
                break;
            }
            if (obj instanceof C0582Wb) {
                while (!atomicReferenceFieldUpdater.compareAndSet(c4568yl, obj, q2)) {
                    if (atomicReferenceFieldUpdater.get(c4568yl) != obj) {
                        break;
                    }
                }
                c0582Wb2 = (C0582Wb) obj;
                break loop0;
            }
            if (obj != q2 && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (c0582Wb2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = C0582Wb.g;
            Object obj2 = atomicReferenceFieldUpdater2.get(c0582Wb2);
            if (!(obj2 instanceof C0611Xe) || ((C0611Xe) obj2).d == null) {
                C0582Wb.f.set(c0582Wb2, 536870911);
                atomicReferenceFieldUpdater2.set(c0582Wb2, C3876q1.a);
                c0582Wb = c0582Wb2;
            } else {
                c0582Wb2.o();
            }
            if (c0582Wb != null) {
                return c0582Wb;
            }
        }
        return new C0582Wb(2, interfaceC0198Hg);
    }

    public static ArrayList n(MaterialToolbar materialToolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < materialToolbar.getChildCount(); i2++) {
            View childAt = materialToolbar.getChildAt(i2);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static void o() {
        int i2 = C3859pm.d;
    }

    public static boolean p(byte b2) {
        return b2 > -65;
    }

    public static LU r(InterfaceC3220hh interfaceC3220hh, InterfaceC0613Xg interfaceC0613Xg, InterfaceC3233hu interfaceC3233hu, int i2) {
        EnumC3458kh enumC3458kh = EnumC3458kh.d;
        if ((i2 & 1) != 0) {
            interfaceC0613Xg = C0912co.a;
        }
        if ((i2 & 2) != 0) {
            enumC3458kh = EnumC3458kh.a;
        }
        InterfaceC0613Xg L = AbstractC0325Me.L(interfaceC3220hh, interfaceC0613Xg);
        LU xa = enumC3458kh == EnumC3458kh.b ? new XA(L, interfaceC3233hu) : new LU(L, true);
        xa.T(enumC3458kh, xa, interfaceC3233hu);
        return xa;
    }

    public static C2853d6 t(String str) {
        try {
            return C2853d6.W(new C0035Az(new ByteArrayInputStream(str.getBytes(C0035Az.b))));
        } catch (IOException unused) {
            throw new GeneralSecurityException("Parse keyset failed");
        }
    }

    public static final Object u(InterfaceC0613Xg interfaceC0613Xg, InterfaceC3233hu interfaceC3233hu) {
        AbstractC0413Po abstractC0413Po;
        InterfaceC0613Xg v;
        Thread currentThread = Thread.currentThread();
        InterfaceC0587Wg interfaceC0587Wg = C0756ar.b;
        InterfaceC0250Jg interfaceC0250Jg = (InterfaceC0250Jg) interfaceC0613Xg.get(interfaceC0587Wg);
        C0912co c0912co = C0912co.a;
        if (interfaceC0250Jg == null) {
            abstractC0413Po = KW.a();
            v = AbstractC0325Me.v(c0912co, interfaceC0613Xg.plus(abstractC0413Po), true);
            C4330vk c4330vk = AbstractC0073Cl.a;
            if (v != c4330vk && v.get(interfaceC0587Wg) == null) {
                v = v.plus(c4330vk);
            }
        } else {
            if (interfaceC0250Jg instanceof AbstractC0413Po) {
            }
            abstractC0413Po = (AbstractC0413Po) KW.a.get();
            v = AbstractC0325Me.v(c0912co, interfaceC0613Xg, true);
            C4330vk c4330vk2 = AbstractC0073Cl.a;
            if (v != c4330vk2 && v.get(interfaceC0587Wg) == null) {
                v = v.plus(c4330vk2);
            }
        }
        C0062Ca c0062Ca = new C0062Ca(v, currentThread, abstractC0413Po);
        c0062Ca.T(EnumC3458kh.a, c0062Ca, interfaceC3233hu);
        AbstractC0413Po abstractC0413Po2 = c0062Ca.e;
        if (abstractC0413Po2 != null) {
            int i2 = AbstractC0413Po.f;
            abstractC0413Po2.q(false);
        }
        while (!Thread.interrupted()) {
            try {
                long r = abstractC0413Po2 != null ? abstractC0413Po2.r() : Long.MAX_VALUE;
                if (c0062Ca.isCompleted()) {
                    if (abstractC0413Po2 != null) {
                        int i3 = AbstractC0413Po.f;
                        abstractC0413Po2.k(false);
                    }
                    Object c0 = AbstractC0641Yi.c0(C3316iz.a.get(c0062Ca));
                    C0663Ze c0663Ze = c0 instanceof C0663Ze ? (C0663Ze) c0 : null;
                    if (c0663Ze == null) {
                        return c0;
                    }
                    throw c0663Ze.a;
                }
                LockSupport.parkNanos(c0062Ca, r);
            } catch (Throwable th) {
                if (abstractC0413Po2 != null) {
                    int i4 = AbstractC0413Po.f;
                    abstractC0413Po2.k(false);
                }
                throw th;
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        c0062Ca.l(interruptedException);
        throw interruptedException;
    }

    public static final long w(long j2, long j3, long j4, String str) {
        String str2;
        int i2 = AbstractC3282iW.a;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            return j2;
        }
        Long o0 = AbstractC4309vV.o0(str2);
        if (o0 == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + str2 + '\'').toString());
        }
        long longValue = o0.longValue();
        if (j3 <= longValue && longValue <= j4) {
            return longValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + longValue + '\'').toString());
    }

    public static int x(int i2, int i3, String str) {
        return (int) w(i2, 1, (i3 & 8) != 0 ? Api.BaseClientBuilder.API_PRIORITY_OTHER : 2097150, str);
    }

    public static int y(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i2});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public static C4452xG z(Object obj) {
        return new C4452xG(obj.getClass().getSimpleName());
    }

    public abstract Method h(Class cls, Field field);

    public int hashCode() {
        switch (this.a) {
            case 26:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public abstract Constructor i(Class cls);

    public abstract String[] m(Class cls);

    public abstract boolean q(Class cls);

    public abstract AbstractC3634my s(int i2, byte[] bArr);

    public String toString() {
        switch (this.a) {
            case 26:
                String b2 = AbstractC4617zN.a(getClass()).b();
                AbstractC3634my.d(b2);
                return b2;
            default:
                return super.toString();
        }
    }

    public XE(byte[] bArr) {
        this.a = 19;
        if (!ZT.e(1)) {
            throw new GeneralSecurityException("Can not use ChaCha20Poly1305 in FIPS-mode.");
        }
        s(1, bArr);
        s(0, bArr);
    }
}
