package defpackage;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.os.Trace;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.IconCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FirebaseMessagingService;
import dastan.prince.bdfreevpn.R;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.ECPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import javax.net.ssl.HttpsURLConnection;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* renamed from: d6, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C2853d6 implements InterfaceC0853c4, InterfaceC0774b4, InterfaceC0414Pp, InterfaceC4106sx {
    public static volatile C2853d6 e;
    public static final Object f = new Object();
    public static final C3775oh g = new C3775oh(0);
    public static final C3854ph h = new C3854ph(0);
    public static final C3379ji i = new C3379ji();
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;

    public /* synthetic */ C2853d6(int i2, boolean z) {
        this.a = i2;
    }

    public static final C2853d6 A(C4446xA c4446xA) {
        AbstractC0731aZ c3658nB;
        boolean z;
        if (c4446xA.y() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        ArrayList arrayList = new ArrayList(c4446xA.y());
        for (C4367wA c4367wA : c4446xA.z()) {
            int A = c4367wA.A();
            try {
                c3658nB = c0(c4367wA);
                z = false;
            } catch (GeneralSecurityException e2) {
                if (AbstractC3074fv.a.a.get()) {
                    throw e2;
                }
                c3658nB = new C3658nB(d0(c4367wA));
                z = true;
            }
            if (AbstractC3074fv.a.a.get() && !S(c4367wA.C())) {
                throw new GeneralSecurityException("Parsing of a single key failed (wrong status) and Tink is configured via validateKeysetsOnParsing to reject such keysets.");
            }
            arrayList.add(new AA(c3658nB, c4367wA.C(), A, A == c4446xA.A(), z, AA.h));
        }
        return new C2853d6(Collections.unmodifiableList(arrayList), C3742oG.b);
    }

    public static void B(C2853d6 c2853d6, C0489Sm c0489Sm) {
        long[] jArr = (long[]) c2853d6.b;
        C2853d6 c2853d62 = c0489Sm.a;
        long[] jArr2 = (long[]) c2853d62.b;
        long[] jArr3 = c0489Sm.b;
        AbstractC3131gc0.A(jArr, jArr2, jArr3);
        long[] jArr4 = (long[]) c2853d62.c;
        long[] jArr5 = (long[]) c2853d6.c;
        long[] jArr6 = (long[]) c2853d62.d;
        AbstractC3131gc0.A(jArr5, jArr4, jArr6);
        AbstractC3131gc0.A((long[]) c2853d6.d, jArr6, jArr3);
    }

    public static final C2853d6 C(C4195u3 c4195u3) {
        int i2;
        EnumC3736oA enumC3736oA;
        int i3 = 0;
        C4326vg c4326vg = new C4326vg();
        C4604zA c4604zA = new C4604zA(c4195u3);
        C0213Hv c0213Hv = C0213Hv.d;
        c4604zA.c = c0213Hv;
        c4604zA.a = true;
        ArrayList arrayList = (ArrayList) c4326vg.c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C4604zA) it.next()).a = false;
        }
        arrayList.add(c4604zA);
        if (c4326vg.b) {
            throw new GeneralSecurityException("KeysetHandle.Builder#build must only be called once");
        }
        c4326vg.b = true;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i4 = 0; i4 < arrayList.size() - 1; i4++) {
            if (((C4604zA) arrayList.get(i4)).c == c0213Hv && ((C4604zA) arrayList.get(i4 + 1)).c != c0213Hv) {
                throw new GeneralSecurityException("Entries with 'withRandomId()' may only be followed by other entries with 'withRandomId()'.");
            }
        }
        HashSet hashSet = new HashSet();
        Iterator it2 = arrayList.iterator();
        Integer num = null;
        while (it2.hasNext()) {
            C4604zA c4604zA2 = (C4604zA) it2.next();
            c4604zA2.getClass();
            C0213Hv c0213Hv2 = c4604zA2.c;
            if (c0213Hv2 == null) {
                throw new GeneralSecurityException("No ID was set (with withFixedId or withRandomId)");
            }
            if (c0213Hv2 == c0213Hv) {
                int i5 = 0;
                while (true) {
                    if (i5 != 0 && !hashSet.contains(Integer.valueOf(i5))) {
                        break;
                    }
                    int i6 = AbstractC4585z00.a;
                    i5 = 0;
                    while (i5 == 0) {
                        byte[] a = KM.a(4);
                        i5 = (a[3] & 255) | ((a[0] & 255) << 24) | ((a[1] & 255) << 16) | ((a[2] & 255) << 8);
                    }
                }
                i2 = i5;
            } else {
                i2 = 0;
            }
            if (hashSet.contains(Integer.valueOf(i2))) {
                throw new GeneralSecurityException(W50.j(i2, "Id ", " is used twice in the keyset"));
            }
            hashSet.add(Integer.valueOf(i2));
            C4195u3 c4195u32 = c4604zA2.b;
            AbstractC0731aZ b = UG.b.b(c4195u32, c4195u32.a() ? Integer.valueOf(i2) : null);
            Object obj = R2.l;
            if (obj.equals(obj)) {
                enumC3736oA = EnumC3736oA.ENABLED;
            } else if (R2.m.equals(obj)) {
                enumC3736oA = EnumC3736oA.DISABLED;
            } else {
                if (!R2.n.equals(obj)) {
                    throw new IllegalStateException("Unknown key status");
                }
                enumC3736oA = EnumC3736oA.DESTROYED;
            }
            AA aa = new AA(b, enumC3736oA, i2, c4604zA2.a, false, AA.h);
            if (c4604zA2.a) {
                if (num != null) {
                    throw new GeneralSecurityException("Two primaries were set");
                }
                num = Integer.valueOf(i2);
            }
            arrayList2.add(aa);
        }
        if (num == null) {
            throw new GeneralSecurityException("No primary was set");
        }
        C3742oG c3742oG = (C3742oG) c4326vg.d;
        C2853d6 c2853d6 = new C2853d6(arrayList2, c3742oG);
        if (c3742oG.a.isEmpty()) {
            return c2853d6;
        }
        C4525yA c4525yA = new C4525yA(i3);
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        Iterator it3 = arrayList2.iterator();
        while (it3.hasNext()) {
            AA aa2 = (AA) it3.next();
            arrayList3.add(new AA(aa2.a, aa2.b, aa2.d, aa2.e, aa2.f, c4525yA));
        }
        return new C2853d6(arrayList3, c3742oG, c2853d6, 25);
    }

    public static C2853d6 H(Context context) {
        if (e == null) {
            synchronized (f) {
                try {
                    if (e == null) {
                        e = new C2853d6(context);
                    }
                } finally {
                }
            }
        }
        return e;
    }

    public static boolean S(EnumC3736oA enumC3736oA) {
        int ordinal = enumC3736oA.ordinal();
        return ordinal == 1 || ordinal == 2 || ordinal == 3;
    }

    public static void U(C0156Fq c0156Fq, String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        try {
            c0156Fq.c(str, "aqs.".concat(str2)).createNewFile();
        } catch (IOException e2) {
            Log.w("FirebaseCrashlytics", "Failed to persist App Quality Sessions session id.", e2);
        }
    }

    public static final C2853d6 W(C0035Az c0035Az) {
        try {
            ByteArrayInputStream byteArrayInputStream = c0035Az.a;
            try {
                try {
                    C4446xA b = C0035Az.b(AbstractC0243Iz.b(new String(A00.a(byteArrayInputStream), C0035Az.b)).l());
                    byteArrayInputStream.close();
                    try {
                        C4446xA C = C4446xA.C(b.d(), C3625mp.a());
                        g(C);
                        return A(C);
                    } catch (C4107sy unused) {
                        throw new GeneralSecurityException("invalid keyset");
                    }
                } catch (Throwable th) {
                    byteArrayInputStream.close();
                    throw th;
                }
            } catch (C0165Fz | IllegalStateException e2) {
                throw new IOException(e2);
            }
        } catch (C4107sy unused2) {
            throw new GeneralSecurityException("invalid keyset");
        }
    }

    public static AbstractC0731aZ c0(C4367wA c4367wA) {
        LL d0 = d0(c4367wA);
        C2947eH c2947eH = C2947eH.b;
        BR br = (BR) c2947eH.a.get();
        br.getClass();
        return !br.b.containsKey(new C4621zR(LL.class, d0.b)) ? new C3658nB(d0) : c2947eH.a(d0);
    }

    public static LL d0(C4367wA c4367wA) {
        return LL.a(c4367wA.z().A(), c4367wA.z().B(), c4367wA.z().z(), c4367wA.B(), c4367wA.B() == EnumC4534yJ.RAW ? null : Integer.valueOf(c4367wA.A()));
    }

    public static void g(C4446xA c4446xA) {
        for (C4367wA c4367wA : c4446xA.z()) {
            if (c4367wA.z().z() == EnumC3020fA.UNKNOWN_KEYMATERIAL || c4367wA.z().z() == EnumC3020fA.SYMMETRIC || c4367wA.z().z() == EnumC3020fA.ASYMMETRIC_PRIVATE) {
                throw new GeneralSecurityException(W50.o("keyset contains key material of type ", c4367wA.z().z().name(), " for type url ", c4367wA.z().A()));
            }
        }
    }

    public static final void r() {
        if (((Boolean) new C3300ii(0, i, C3379ji.class, "isBackgroundThread", "isBackgroundThread()Z", 0, 0).invoke()).booleanValue()) {
            return;
        }
        String str = "Must be called on a background thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public static final void s() {
        if (((Boolean) new C3300ii(0, i, C3379ji.class, "isBlockingThread", "isBlockingThread()Z", 0, 1).invoke()).booleanValue()) {
            return;
        }
        String str = "Must be called on a blocking thread, was called on " + Thread.currentThread().getName() + '.';
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public static C4367wA t(AbstractC0731aZ abstractC0731aZ, EnumC3736oA enumC3736oA, int i2) {
        LL ll = (LL) C2947eH.b.g(abstractC0731aZ);
        Integer C = abstractC0731aZ.C();
        if (C != null && C.intValue() != i2) {
            throw new GeneralSecurityException("Wrong ID set for key with ID requirement");
        }
        C4288vA E = C4367wA.E();
        C2940eA C2 = C3100gA.C();
        C2.d();
        C3100gA.v((C3100gA) C2.b, ll.a);
        C2.d();
        C3100gA.w((C3100gA) C2.b, ll.c);
        EnumC3020fA enumC3020fA = ll.d;
        C2.d();
        C3100gA.x((C3100gA) C2.b, enumC3020fA);
        E.d();
        C4367wA.v((C4367wA) E.b, (C3100gA) C2.a());
        E.d();
        C4367wA.x((C4367wA) E.b, enumC3736oA);
        E.d();
        C4367wA.y((C4367wA) E.b, i2);
        EnumC4534yJ enumC4534yJ = ll.e;
        E.d();
        C4367wA.w((C4367wA) E.b, enumC4534yJ);
        return (C4367wA) E.a();
    }

    public static String u(HashMap hashMap, String str) {
        StringBuilder sb = new StringBuilder();
        Iterator it = hashMap.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), "UTF-8") : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), "UTF-8") : "");
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return W50.n(str, "?", sb2);
        }
        if (!str.endsWith("&")) {
            sb2 = "&".concat(sb2);
        }
        return W50.C(str, sb2);
    }

    public static boolean v(Editable editable, KeyEvent keyEvent, boolean z) {
        C3443kZ[] c3443kZArr;
        if (KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            if (selectionStart != -1 && selectionEnd != -1 && selectionStart == selectionEnd && (c3443kZArr = (C3443kZ[]) editable.getSpans(selectionStart, selectionEnd, C3443kZ.class)) != null && c3443kZArr.length > 0) {
                for (C3443kZ c3443kZ : c3443kZArr) {
                    int spanStart = editable.getSpanStart(c3443kZ);
                    int spanEnd = editable.getSpanEnd(c3443kZ);
                    if ((z && spanStart == selectionStart) || ((!z && spanEnd == selectionStart) || (selectionStart > spanStart && selectionStart < spanEnd))) {
                        editable.delete(spanStart, spanEnd);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public AA D(int i2) {
        List list = (List) this.b;
        if (i2 < 0 || i2 >= list.size()) {
            StringBuilder w = W50.w(i2, "Invalid index ", " for keyset of size ");
            w.append(list.size());
            throw new IndexOutOfBoundsException(w.toString());
        }
        AA aa = (AA) list.get(i2);
        if (!S(aa.b)) {
            throw new IllegalStateException(W50.j(i2, "Keyset-Entry at position ", " has wrong status"));
        }
        if (aa.f) {
            throw new IllegalStateException(W50.j(i2, "Keyset-Entry at position ", " didn't parse correctly"));
        }
        return (AA) list.get(i2);
    }

    public View E(int i2) {
        return ((RecyclerView) ((C2882dV) this.b).b).getChildAt(J(i2));
    }

    public int F() {
        return ((RecyclerView) ((C2882dV) this.b).b).getChildCount() - ((ArrayList) this.d).size();
    }

    public List G() {
        if (((C3502lE) this.d) == null) {
            this.d = new C3502lE(this);
        }
        C3502lE c3502lE = (C3502lE) this.d;
        AbstractC3634my.d(c3502lE);
        return c3502lE;
    }

    public C4446xA I() {
        try {
            C4209uA B = C4446xA.B();
            for (AA aa : (List) this.b) {
                AbstractC0731aZ a = aa.a();
                int i2 = aa.d;
                C4367wA t = t(a, aa.b, i2);
                B.d();
                C4446xA.w((C4446xA) B.b, t);
                if (aa.e) {
                    B.d();
                    C4446xA.v((C4446xA) B.b, i2);
                }
            }
            return (C4446xA) B.a();
        } catch (GeneralSecurityException e2) {
            throw new C0742af(e2);
        }
    }

    public int J(int i2) {
        if (i2 < 0) {
            return -1;
        }
        int childCount = ((RecyclerView) ((C2882dV) this.b).b).getChildCount();
        int i3 = i2;
        while (i3 < childCount) {
            C3768od c3768od = (C3768od) this.c;
            int b = i2 - (i3 - c3768od.b(i3));
            if (b == 0) {
                while (c3768od.d(i3)) {
                    i3++;
                }
                return i3;
            }
            i3 += b;
        }
        return -1;
    }

    public AA K() {
        for (AA aa : (List) this.b) {
            if (aa != null && aa.e) {
                if (aa.c == R2.l) {
                    return aa;
                }
                throw new IllegalStateException("Keyset has primary which isn't enabled");
            }
        }
        throw new IllegalStateException("Keyset has no valid primary");
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00e7, code lost:
    
        r0 = r2.x(r5);
        r2 = defpackage.W50.w(r5, "Key parsing of key with index ", " and type_url ");
        r2.append(r0.z().A());
        r2.append(" failed, unable to get primitive");
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x010c, code lost:
    
        throw new java.security.GeneralSecurityException(r2.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object L() {
        C2853d6 c2853d6 = (C2853d6) this.d;
        C4446xA I = (c2853d6 == null ? this : c2853d6).I();
        int i2 = A00.a;
        int A = I.A();
        int i3 = 0;
        boolean z = true;
        int i4 = 0;
        boolean z2 = false;
        for (C4367wA c4367wA : I.z()) {
            if (c4367wA.C() == EnumC3736oA.ENABLED) {
                if (!c4367wA.D()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", Integer.valueOf(c4367wA.A())));
                }
                if (c4367wA.B() == EnumC4534yJ.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", Integer.valueOf(c4367wA.A())));
                }
                if (c4367wA.C() == EnumC3736oA.UNKNOWN_STATUS) {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", Integer.valueOf(c4367wA.A())));
                }
                if (c4367wA.A() == A) {
                    if (z2) {
                        throw new GeneralSecurityException("keyset contains multiple primary keys");
                    }
                    z2 = true;
                }
                if (c4367wA.z().z() != EnumC3020fA.ASYMMETRIC_PUBLIC) {
                    z = false;
                }
                i4++;
            }
        }
        if (i4 == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        }
        if (!z2 && !z) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        while (true) {
            List list = (List) this.b;
            if (i3 >= list.size()) {
                if (c2853d6 == null) {
                    c2853d6 = this;
                }
                C2951eL c2951eL = (C2951eL) C0793bH.b.a.get();
                HashMap hashMap = c2951eL.b;
                if (hashMap.containsKey(InterfaceC3112gM.class)) {
                    InterfaceC3111gL interfaceC3111gL = (InterfaceC3111gL) hashMap.get(InterfaceC3112gM.class);
                    return interfaceC3111gL.b(c2853d6, (C3742oG) this.c, new C4640zf(7, c2951eL, interfaceC3111gL));
                }
                throw new GeneralSecurityException("No wrapper found for " + InterfaceC3112gM.class);
            }
            if (((AA) list.get(i3)).f || !S(((AA) list.get(i3)).b)) {
                break;
            }
            i3++;
        }
    }

    public View M(int i2) {
        return ((RecyclerView) ((C2882dV) this.b).b).getChildAt(i2);
    }

    public int N() {
        return ((RecyclerView) ((C2882dV) this.b).b).getChildCount();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(82:5|(4:7|(1:9)|10|(2:12|(2:13|(2:15|(3:17|18|(1:20)(0))(1:21))(1:22)))(0))(0)|23|(79:250|251|(1:27)|28|29|30|(1:32)|247|34|35|(3:222|223|(74:225|(66:227|(1:229)|38|(1:40)|41|(1:43)|44|(2:46|(1:206)(56:50|51|(1:53)|54|(1:56)(2:196|(1:201)(1:200))|57|(1:59)|60|(1:62)(5:184|(1:186)|187|(1:189)(1:195)|(1:191)(2:192|(1:194)))|63|(1:65)(6:166|(4:169|(2:177|178)(1:175)|176|167)|179|180|(1:182)|183)|66|(1:68)(1:165)|(1:70)|71|(39:161|162|(1:77)|78|(1:80)(1:156)|81|(1:83)|84|(31:151|(1:155)|(1:88)|89|(27:146|(1:150)|(1:93)|94|(23:143|(1:145)|(1:98)|99|(1:101)|102|(1:104)|105|(3:107|(1:112)(1:110)|111)|113|(1:115)|116|(1:118)|119|(1:121)|122|(1:142)|124|(4:131|132|(1:134)(1:137)|135)|126|(1:128)|129|130)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)|73|(39:157|158|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)|75|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130))(1:221)|207|(2:216|217)|(1:215)(1:214)|51|(0)|54|(0)(0)|57|(0)|60|(0)(0)|63|(0)(0)|66|(0)(0)|(0)|71|(0)|73|(0)|75|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)|230|(69:232|(1:234)|38|(0)|41|(0)|44|(0)(0)|207|(1:209)|216|217|(1:212)|215|51|(0)|54|(0)(0)|57|(0)|60|(0)(0)|63|(0)(0)|66|(0)(0)|(0)|71|(0)|73|(0)|75|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)(1:243)|235|(3:237|(1:239)(1:241)|240)|242|38|(0)|41|(0)|44|(0)(0)|207|(0)|216|217|(0)|215|51|(0)|54|(0)(0)|57|(0)|60|(0)(0)|63|(0)(0)|66|(0)(0)|(0)|71|(0)|73|(0)|75|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130))|37|38|(0)|41|(0)|44|(0)(0)|207|(0)|216|217|(0)|215|51|(0)|54|(0)(0)|57|(0)|60|(0)(0)|63|(0)(0)|66|(0)(0)|(0)|71|(0)|73|(0)|75|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130)|25|(0)|28|29|30|(0)|247|34|35|(0)|37|38|(0)|41|(0)|44|(0)(0)|207|(0)|216|217|(0)|215|51|(0)|54|(0)(0)|57|(0)|60|(0)(0)|63|(0)(0)|66|(0)(0)|(0)|71|(0)|73|(0)|75|(0)|78|(0)(0)|81|(0)|84|(0)|86|(0)|89|(0)|91|(0)|94|(0)|96|(0)|99|(0)|102|(0)|105|(0)|113|(0)|116|(0)|119|(0)|122|(0)|124|(0)|126|(0)|129|130) */
    /* JADX WARN: Code restructure failed: missing block: B:219:0x021a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x021b, code lost:
    
        android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x00d2, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x00d3, code lost:
    
        android.util.Log.w("FirebaseMessaging", "Couldn't get own application info: " + r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ce, code lost:
    
        if (r0 != null) goto L34;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x04be  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x04d9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0512  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x051c  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x05b1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0548 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0532  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x03d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x03ab A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x036d  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x00f4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00cc A[Catch: NameNotFoundException -> 0x00d2, TRY_LEAVE, TryCatch #5 {NameNotFoundException -> 0x00d2, blocks: (B:30:0x00c6, B:32:0x00cc), top: B:29:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0289  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x03e3  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04b2  */
    /* JADX WARN: Type inference failed for: r0v107, types: [int] */
    /* JADX WARN: Type inference failed for: r0v135 */
    /* JADX WARN: Type inference failed for: r0v187 */
    /* JADX WARN: Type inference failed for: r0v188 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean O() {
        C0240Iw c0240Iw;
        FirebaseMessagingService firebaseMessagingService;
        C2835cv c2835cv;
        Bundle bundle;
        NotificationChannel notificationChannel;
        String string;
        NotificationChannel notificationChannel2;
        NotificationChannel notificationChannel3;
        String packageName;
        PackageManager packageManager;
        String A;
        String A2;
        String B;
        int i2;
        int i3;
        int i4;
        String B2;
        Uri defaultUri;
        String B3;
        Intent launchIntentForPackage;
        PendingIntent activity;
        PendingIntent broadcast;
        String B4;
        Integer valueOf;
        boolean o;
        String B5;
        Integer s;
        Integer s2;
        Integer s3;
        Long y;
        long[] C;
        int[] v;
        ?? r0;
        String B6;
        IconCompat iconCompat;
        boolean z;
        int i5;
        ApplicationInfo applicationInfo;
        char c = 4;
        if (((C2835cv) this.d).o("gcm.n.noui")) {
            return true;
        }
        FirebaseMessagingService firebaseMessagingService2 = (FirebaseMessagingService) this.c;
        if (!((KeyguardManager) firebaseMessagingService2.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!PlatformVersion.isAtLeastLollipop()) {
                SystemClock.sleep(10L);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) firebaseMessagingService2.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            return false;
                        }
                    }
                }
            }
        }
        String B7 = ((C2835cv) this.d).B("gcm.n.image");
        if (!TextUtils.isEmpty(B7)) {
            try {
                c0240Iw = new C0240Iw(new URL(B7));
            } catch (MalformedURLException unused) {
                Log.w("FirebaseMessaging", "Not downloading image, bad URL: " + B7);
            }
            if (c0240Iw != null) {
                ExecutorService executorService = (ExecutorService) this.b;
                TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
                c0240Iw.b = executorService.submit(new I3(9, c0240Iw, taskCompletionSource));
                c0240Iw.c = taskCompletionSource.getTask();
            }
            firebaseMessagingService = (FirebaseMessagingService) this.c;
            c2835cv = (C2835cv) this.d;
            AtomicInteger atomicInteger = AbstractC0274Ke.a;
            applicationInfo = firebaseMessagingService.getPackageManager().getApplicationInfo(firebaseMessagingService.getPackageName(), UserVerificationMethods.USER_VERIFY_PATTERN);
            if (applicationInfo != null) {
                bundle = applicationInfo.metaData;
            }
            bundle = Bundle.EMPTY;
            Bundle bundle2 = bundle;
            String B8 = c2835cv.B("gcm.n.android_channel_id");
            if (Build.VERSION.SDK_INT >= 26) {
                if (firebaseMessagingService.getPackageManager().getApplicationInfo(firebaseMessagingService.getPackageName(), 0).targetSdkVersion >= 26) {
                    NotificationManager notificationManager = (NotificationManager) firebaseMessagingService.getSystemService(NotificationManager.class);
                    if (!TextUtils.isEmpty(B8)) {
                        notificationChannel3 = notificationManager.getNotificationChannel(B8);
                        if (notificationChannel3 == null) {
                            Log.w("FirebaseMessaging", "Notification Channel requested (" + B8 + ") has not been created by the app. Manifest configuration, or default, value will be used.");
                        }
                        packageName = firebaseMessagingService.getPackageName();
                        Resources resources = firebaseMessagingService.getResources();
                        packageManager = firebaseMessagingService.getPackageManager();
                        C3902qI c3902qI = new C3902qI(firebaseMessagingService, B8);
                        A = c2835cv.A(packageName, resources, "gcm.n.title");
                        if (!TextUtils.isEmpty(A)) {
                            c3902qI.e = C3902qI.b(A);
                        }
                        A2 = c2835cv.A(packageName, resources, "gcm.n.body");
                        if (!TextUtils.isEmpty(A2)) {
                            c3902qI.f = C3902qI.b(A2);
                            C3823pI c3823pI = new C3823pI();
                            c3823pI.b = C3902qI.b(A2);
                            c3902qI.d(c3823pI);
                        }
                        B = c2835cv.B("gcm.n.icon");
                        if (TextUtils.isEmpty(B)) {
                            i2 = 2;
                        } else {
                            i4 = resources.getIdentifier(B, "drawable", packageName);
                            if ((i4 != 0 && AbstractC0274Ke.a(resources, i4)) || ((i4 = resources.getIdentifier(B, "mipmap", packageName)) != 0 && AbstractC0274Ke.a(resources, i4))) {
                                i2 = 2;
                                c3902qI.s.icon = i4;
                                B2 = c2835cv.B("gcm.n.sound2");
                                if (TextUtils.isEmpty(B2)) {
                                    B2 = c2835cv.B("gcm.n.sound");
                                }
                                if (!TextUtils.isEmpty(B2)) {
                                    defaultUri = null;
                                } else if ("default".equals(B2) || resources.getIdentifier(B2, "raw", packageName) == 0) {
                                    defaultUri = RingtoneManager.getDefaultUri(i2);
                                } else {
                                    defaultUri = Uri.parse("android.resource://" + packageName + "/raw/" + B2);
                                }
                                if (defaultUri != null) {
                                    Notification notification = c3902qI.s;
                                    notification.sound = defaultUri;
                                    notification.audioStreamType = -1;
                                    notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
                                }
                                B3 = c2835cv.B("gcm.n.click_action");
                                if (TextUtils.isEmpty(B3)) {
                                    launchIntentForPackage = new Intent(B3);
                                    launchIntentForPackage.setPackage(packageName);
                                    launchIntentForPackage.setFlags(268435456);
                                } else {
                                    String B9 = c2835cv.B("gcm.n.link_android");
                                    if (TextUtils.isEmpty(B9)) {
                                        B9 = c2835cv.B("gcm.n.link");
                                    }
                                    Uri parse = !TextUtils.isEmpty(B9) ? Uri.parse(B9) : null;
                                    if (parse != null) {
                                        launchIntentForPackage = new Intent("android.intent.action.VIEW");
                                        launchIntentForPackage.setPackage(packageName);
                                        launchIntentForPackage.setData(parse);
                                    } else {
                                        launchIntentForPackage = packageManager.getLaunchIntentForPackage(packageName);
                                        if (launchIntentForPackage == null) {
                                            Log.w("FirebaseMessaging", "No activity found to launch app");
                                        }
                                    }
                                }
                                AtomicInteger atomicInteger2 = AbstractC0274Ke.a;
                                if (launchIntentForPackage != null) {
                                    activity = null;
                                } else {
                                    launchIntentForPackage.addFlags(67108864);
                                    Bundle bundle3 = (Bundle) c2835cv.b;
                                    Bundle bundle4 = new Bundle(bundle3);
                                    for (String str : bundle3.keySet()) {
                                        char c2 = c;
                                        if (str.startsWith("google.c.") || str.startsWith("gcm.n.") || str.startsWith("gcm.notification.")) {
                                            bundle4.remove(str);
                                        }
                                        c = c2;
                                    }
                                    launchIntentForPackage.putExtras(bundle4);
                                    if (c2835cv.o("google.c.a.e")) {
                                        launchIntentForPackage.putExtra("gcm.n.analytics_data", c2835cv.I());
                                    }
                                    activity = PendingIntent.getActivity(firebaseMessagingService, atomicInteger2.incrementAndGet(), launchIntentForPackage, 1140850688);
                                }
                                c3902qI.g = activity;
                                broadcast = c2835cv.o("google.c.a.e") ? null : PendingIntent.getBroadcast(firebaseMessagingService, atomicInteger2.incrementAndGet(), new Intent("com.google.android.c2dm.intent.RECEIVE").setPackage(firebaseMessagingService.getPackageName()).putExtra(CloudMessagingReceiver.IntentKeys.WRAPPED_INTENT, new Intent(CloudMessagingReceiver.IntentActionKeys.NOTIFICATION_DISMISS).putExtras(c2835cv.I())), 1140850688);
                                if (broadcast != null) {
                                    c3902qI.s.deleteIntent = broadcast;
                                }
                                B4 = c2835cv.B("gcm.n.color");
                                if (!TextUtils.isEmpty(B4)) {
                                    try {
                                        valueOf = Integer.valueOf(Color.parseColor(B4));
                                    } catch (IllegalArgumentException unused2) {
                                        Log.w("FirebaseMessaging", "Color is invalid: " + B4 + ". Notification will use default color.");
                                    }
                                    if (valueOf != null) {
                                        c3902qI.o = valueOf.intValue();
                                    }
                                    o = c2835cv.o("gcm.n.sticky");
                                    Notification notification2 = c3902qI.s;
                                    if (o) {
                                        notification2.flags |= 16;
                                    } else {
                                        notification2.flags &= -17;
                                    }
                                    c3902qI.m = c2835cv.o("gcm.n.local_only");
                                    B5 = c2835cv.B("gcm.n.ticker");
                                    if (B5 != null) {
                                        c3902qI.s.tickerText = C3902qI.b(B5);
                                    }
                                    s = c2835cv.s("gcm.n.notification_priority");
                                    if (s != null) {
                                        if (s.intValue() < -2 || s.intValue() > i2) {
                                            Log.w("FirebaseMessaging", "notificationPriority is invalid " + s + ". Skipping setting notificationPriority.");
                                        }
                                        if (s != null) {
                                            c3902qI.j = s.intValue();
                                        }
                                        s2 = c2835cv.s("gcm.n.visibility");
                                        if (s2 != null) {
                                            if (s2.intValue() < -1 || s2.intValue() > 1) {
                                                Log.w("NotificationParams", "visibility is invalid: " + s2 + ". Skipping setting visibility.");
                                            }
                                            if (s2 != null) {
                                                c3902qI.p = s2.intValue();
                                            }
                                            s3 = c2835cv.s("gcm.n.notification_count");
                                            if (s3 != null) {
                                                if (s3.intValue() < 0) {
                                                    Log.w("FirebaseMessaging", "notificationCount is invalid: " + s3 + ". Skipping setting notificationCount.");
                                                }
                                                if (s3 != null) {
                                                    c3902qI.i = s3.intValue();
                                                }
                                                y = c2835cv.y();
                                                if (y != null) {
                                                    c3902qI.k = true;
                                                    c3902qI.s.when = y.longValue();
                                                }
                                                C = c2835cv.C();
                                                if (C != null) {
                                                    c3902qI.s.vibrate = C;
                                                }
                                                v = c2835cv.v();
                                                if (v != null) {
                                                    int i6 = v[0];
                                                    int i7 = v[1];
                                                    int i8 = v[2];
                                                    Notification notification3 = c3902qI.s;
                                                    notification3.ledARGB = i6;
                                                    notification3.ledOnMS = i7;
                                                    notification3.ledOffMS = i8;
                                                    notification3.flags = ((i7 == 0 || i8 == 0) ? 0 : 1) | ((-2) & notification3.flags);
                                                }
                                                boolean o2 = c2835cv.o("gcm.n.default_sound");
                                                boolean z2 = o2;
                                                if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                                                    z2 = (o2 ? 1 : 0) | 2;
                                                }
                                                r0 = z2;
                                                if (c2835cv.o("gcm.n.default_light_settings")) {
                                                    r0 = (z2 ? 1 : 0) | 4;
                                                }
                                                Notification notification4 = c3902qI.s;
                                                notification4.defaults = r0;
                                                if ((r0 & 4) != 0) {
                                                    notification4.flags |= 1;
                                                }
                                                B6 = c2835cv.B("gcm.n.tag");
                                                if (TextUtils.isEmpty(B6)) {
                                                    B6 = "FCM-Notification:" + SystemClock.uptimeMillis();
                                                }
                                                String str2 = B6;
                                                if (c0240Iw != null) {
                                                    try {
                                                        Bitmap bitmap = (Bitmap) Tasks.await((Task) Preconditions.checkNotNull(c0240Iw.c), 5L, TimeUnit.SECONDS);
                                                        c3902qI.c(bitmap);
                                                        C3744oI c3744oI = new C3744oI();
                                                        if (bitmap == null) {
                                                            iconCompat = null;
                                                            z = true;
                                                        } else {
                                                            z = true;
                                                            iconCompat = new IconCompat(1);
                                                            iconCompat.b = bitmap;
                                                        }
                                                        c3744oI.b = iconCompat;
                                                        c3744oI.c = null;
                                                        c3744oI.d = z;
                                                        c3902qI.d(c3744oI);
                                                    } catch (InterruptedException unused3) {
                                                        Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                                                        c0240Iw.close();
                                                        Thread.currentThread().interrupt();
                                                    } catch (ExecutionException e2) {
                                                        Log.w("FirebaseMessaging", "Failed to download image: " + e2.getCause());
                                                    } catch (TimeoutException unused4) {
                                                        Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                                                        c0240Iw.close();
                                                    }
                                                }
                                                if (Log.isLoggable("FirebaseMessaging", 3)) {
                                                    Log.d("FirebaseMessaging", "Showing notification");
                                                }
                                                ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str2, 0, c3902qI.a());
                                                return true;
                                            }
                                            s3 = null;
                                            if (s3 != null) {
                                            }
                                            y = c2835cv.y();
                                            if (y != null) {
                                            }
                                            C = c2835cv.C();
                                            if (C != null) {
                                            }
                                            v = c2835cv.v();
                                            if (v != null) {
                                            }
                                            boolean o22 = c2835cv.o("gcm.n.default_sound");
                                            boolean z22 = o22;
                                            if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                                            }
                                            r0 = z22;
                                            if (c2835cv.o("gcm.n.default_light_settings")) {
                                            }
                                            Notification notification42 = c3902qI.s;
                                            notification42.defaults = r0;
                                            if ((r0 & 4) != 0) {
                                            }
                                            B6 = c2835cv.B("gcm.n.tag");
                                            if (TextUtils.isEmpty(B6)) {
                                            }
                                            String str22 = B6;
                                            if (c0240Iw != null) {
                                            }
                                            if (Log.isLoggable("FirebaseMessaging", 3)) {
                                            }
                                            ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str22, 0, c3902qI.a());
                                            return true;
                                        }
                                        s2 = null;
                                        if (s2 != null) {
                                        }
                                        s3 = c2835cv.s("gcm.n.notification_count");
                                        if (s3 != null) {
                                        }
                                        s3 = null;
                                        if (s3 != null) {
                                        }
                                        y = c2835cv.y();
                                        if (y != null) {
                                        }
                                        C = c2835cv.C();
                                        if (C != null) {
                                        }
                                        v = c2835cv.v();
                                        if (v != null) {
                                        }
                                        boolean o222 = c2835cv.o("gcm.n.default_sound");
                                        boolean z222 = o222;
                                        if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                                        }
                                        r0 = z222;
                                        if (c2835cv.o("gcm.n.default_light_settings")) {
                                        }
                                        Notification notification422 = c3902qI.s;
                                        notification422.defaults = r0;
                                        if ((r0 & 4) != 0) {
                                        }
                                        B6 = c2835cv.B("gcm.n.tag");
                                        if (TextUtils.isEmpty(B6)) {
                                        }
                                        String str222 = B6;
                                        if (c0240Iw != null) {
                                        }
                                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                                        }
                                        ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str222, 0, c3902qI.a());
                                        return true;
                                    }
                                    s = null;
                                    if (s != null) {
                                    }
                                    s2 = c2835cv.s("gcm.n.visibility");
                                    if (s2 != null) {
                                    }
                                    s2 = null;
                                    if (s2 != null) {
                                    }
                                    s3 = c2835cv.s("gcm.n.notification_count");
                                    if (s3 != null) {
                                    }
                                    s3 = null;
                                    if (s3 != null) {
                                    }
                                    y = c2835cv.y();
                                    if (y != null) {
                                    }
                                    C = c2835cv.C();
                                    if (C != null) {
                                    }
                                    v = c2835cv.v();
                                    if (v != null) {
                                    }
                                    boolean o2222 = c2835cv.o("gcm.n.default_sound");
                                    boolean z2222 = o2222;
                                    if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                                    }
                                    r0 = z2222;
                                    if (c2835cv.o("gcm.n.default_light_settings")) {
                                    }
                                    Notification notification4222 = c3902qI.s;
                                    notification4222.defaults = r0;
                                    if ((r0 & 4) != 0) {
                                    }
                                    B6 = c2835cv.B("gcm.n.tag");
                                    if (TextUtils.isEmpty(B6)) {
                                    }
                                    String str2222 = B6;
                                    if (c0240Iw != null) {
                                    }
                                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                                    }
                                    ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str2222, 0, c3902qI.a());
                                    return true;
                                }
                                i5 = bundle2.getInt("com.google.firebase.messaging.default_notification_color", 0);
                                if (i5 != 0) {
                                    try {
                                        valueOf = Integer.valueOf(firebaseMessagingService.getColor(i5));
                                    } catch (Resources.NotFoundException unused5) {
                                        Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
                                    }
                                    if (valueOf != null) {
                                    }
                                    o = c2835cv.o("gcm.n.sticky");
                                    Notification notification22 = c3902qI.s;
                                    if (o) {
                                    }
                                    c3902qI.m = c2835cv.o("gcm.n.local_only");
                                    B5 = c2835cv.B("gcm.n.ticker");
                                    if (B5 != null) {
                                    }
                                    s = c2835cv.s("gcm.n.notification_priority");
                                    if (s != null) {
                                    }
                                    s = null;
                                    if (s != null) {
                                    }
                                    s2 = c2835cv.s("gcm.n.visibility");
                                    if (s2 != null) {
                                    }
                                    s2 = null;
                                    if (s2 != null) {
                                    }
                                    s3 = c2835cv.s("gcm.n.notification_count");
                                    if (s3 != null) {
                                    }
                                    s3 = null;
                                    if (s3 != null) {
                                    }
                                    y = c2835cv.y();
                                    if (y != null) {
                                    }
                                    C = c2835cv.C();
                                    if (C != null) {
                                    }
                                    v = c2835cv.v();
                                    if (v != null) {
                                    }
                                    boolean o22222 = c2835cv.o("gcm.n.default_sound");
                                    boolean z22222 = o22222;
                                    if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                                    }
                                    r0 = z22222;
                                    if (c2835cv.o("gcm.n.default_light_settings")) {
                                    }
                                    Notification notification42222 = c3902qI.s;
                                    notification42222.defaults = r0;
                                    if ((r0 & 4) != 0) {
                                    }
                                    B6 = c2835cv.B("gcm.n.tag");
                                    if (TextUtils.isEmpty(B6)) {
                                    }
                                    String str22222 = B6;
                                    if (c0240Iw != null) {
                                    }
                                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                                    }
                                    ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str22222, 0, c3902qI.a());
                                    return true;
                                }
                                valueOf = null;
                                if (valueOf != null) {
                                }
                                o = c2835cv.o("gcm.n.sticky");
                                Notification notification222 = c3902qI.s;
                                if (o) {
                                }
                                c3902qI.m = c2835cv.o("gcm.n.local_only");
                                B5 = c2835cv.B("gcm.n.ticker");
                                if (B5 != null) {
                                }
                                s = c2835cv.s("gcm.n.notification_priority");
                                if (s != null) {
                                }
                                s = null;
                                if (s != null) {
                                }
                                s2 = c2835cv.s("gcm.n.visibility");
                                if (s2 != null) {
                                }
                                s2 = null;
                                if (s2 != null) {
                                }
                                s3 = c2835cv.s("gcm.n.notification_count");
                                if (s3 != null) {
                                }
                                s3 = null;
                                if (s3 != null) {
                                }
                                y = c2835cv.y();
                                if (y != null) {
                                }
                                C = c2835cv.C();
                                if (C != null) {
                                }
                                v = c2835cv.v();
                                if (v != null) {
                                }
                                boolean o222222 = c2835cv.o("gcm.n.default_sound");
                                boolean z222222 = o222222;
                                if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                                }
                                r0 = z222222;
                                if (c2835cv.o("gcm.n.default_light_settings")) {
                                }
                                Notification notification422222 = c3902qI.s;
                                notification422222.defaults = r0;
                                if ((r0 & 4) != 0) {
                                }
                                B6 = c2835cv.B("gcm.n.tag");
                                if (TextUtils.isEmpty(B6)) {
                                }
                                String str222222 = B6;
                                if (c0240Iw != null) {
                                }
                                if (Log.isLoggable("FirebaseMessaging", 3)) {
                                }
                                ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str222222, 0, c3902qI.a());
                                return true;
                            }
                            i2 = 2;
                            Log.w("FirebaseMessaging", "Icon resource " + B + " not found. Notification will use default icon.");
                        }
                        i3 = bundle2.getInt("com.google.firebase.messaging.default_notification_icon", 0);
                        if (i3 != 0 || !AbstractC0274Ke.a(resources, i3)) {
                            i3 = packageManager.getApplicationInfo(packageName, 0).icon;
                        }
                        i4 = (i3 == 0 && AbstractC0274Ke.a(resources, i3)) ? i3 : 17301651;
                        c3902qI.s.icon = i4;
                        B2 = c2835cv.B("gcm.n.sound2");
                        if (TextUtils.isEmpty(B2)) {
                        }
                        if (!TextUtils.isEmpty(B2)) {
                        }
                        if (defaultUri != null) {
                        }
                        B3 = c2835cv.B("gcm.n.click_action");
                        if (TextUtils.isEmpty(B3)) {
                        }
                        AtomicInteger atomicInteger22 = AbstractC0274Ke.a;
                        if (launchIntentForPackage != null) {
                        }
                        c3902qI.g = activity;
                        if (c2835cv.o("google.c.a.e")) {
                        }
                        if (broadcast != null) {
                        }
                        B4 = c2835cv.B("gcm.n.color");
                        if (!TextUtils.isEmpty(B4)) {
                        }
                        i5 = bundle2.getInt("com.google.firebase.messaging.default_notification_color", 0);
                        if (i5 != 0) {
                        }
                        valueOf = null;
                        if (valueOf != null) {
                        }
                        o = c2835cv.o("gcm.n.sticky");
                        Notification notification2222 = c3902qI.s;
                        if (o) {
                        }
                        c3902qI.m = c2835cv.o("gcm.n.local_only");
                        B5 = c2835cv.B("gcm.n.ticker");
                        if (B5 != null) {
                        }
                        s = c2835cv.s("gcm.n.notification_priority");
                        if (s != null) {
                        }
                        s = null;
                        if (s != null) {
                        }
                        s2 = c2835cv.s("gcm.n.visibility");
                        if (s2 != null) {
                        }
                        s2 = null;
                        if (s2 != null) {
                        }
                        s3 = c2835cv.s("gcm.n.notification_count");
                        if (s3 != null) {
                        }
                        s3 = null;
                        if (s3 != null) {
                        }
                        y = c2835cv.y();
                        if (y != null) {
                        }
                        C = c2835cv.C();
                        if (C != null) {
                        }
                        v = c2835cv.v();
                        if (v != null) {
                        }
                        boolean o2222222 = c2835cv.o("gcm.n.default_sound");
                        boolean z2222222 = o2222222;
                        if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                        }
                        r0 = z2222222;
                        if (c2835cv.o("gcm.n.default_light_settings")) {
                        }
                        Notification notification4222222 = c3902qI.s;
                        notification4222222.defaults = r0;
                        if ((r0 & 4) != 0) {
                        }
                        B6 = c2835cv.B("gcm.n.tag");
                        if (TextUtils.isEmpty(B6)) {
                        }
                        String str2222222 = B6;
                        if (c0240Iw != null) {
                        }
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                        }
                        ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str2222222, 0, c3902qI.a());
                        return true;
                    }
                    B8 = bundle2.getString("com.google.firebase.messaging.default_notification_channel_id");
                    if (!TextUtils.isEmpty(B8)) {
                        notificationChannel2 = notificationManager.getNotificationChannel(B8);
                        if (notificationChannel2 == null) {
                            Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
                        }
                        packageName = firebaseMessagingService.getPackageName();
                        Resources resources2 = firebaseMessagingService.getResources();
                        packageManager = firebaseMessagingService.getPackageManager();
                        C3902qI c3902qI2 = new C3902qI(firebaseMessagingService, B8);
                        A = c2835cv.A(packageName, resources2, "gcm.n.title");
                        if (!TextUtils.isEmpty(A)) {
                        }
                        A2 = c2835cv.A(packageName, resources2, "gcm.n.body");
                        if (!TextUtils.isEmpty(A2)) {
                        }
                        B = c2835cv.B("gcm.n.icon");
                        if (TextUtils.isEmpty(B)) {
                        }
                        i3 = bundle2.getInt("com.google.firebase.messaging.default_notification_icon", 0);
                        if (i3 != 0) {
                        }
                        i3 = packageManager.getApplicationInfo(packageName, 0).icon;
                        if (i3 == 0) {
                        }
                        c3902qI2.s.icon = i4;
                        B2 = c2835cv.B("gcm.n.sound2");
                        if (TextUtils.isEmpty(B2)) {
                        }
                        if (!TextUtils.isEmpty(B2)) {
                        }
                        if (defaultUri != null) {
                        }
                        B3 = c2835cv.B("gcm.n.click_action");
                        if (TextUtils.isEmpty(B3)) {
                        }
                        AtomicInteger atomicInteger222 = AbstractC0274Ke.a;
                        if (launchIntentForPackage != null) {
                        }
                        c3902qI2.g = activity;
                        if (c2835cv.o("google.c.a.e")) {
                        }
                        if (broadcast != null) {
                        }
                        B4 = c2835cv.B("gcm.n.color");
                        if (!TextUtils.isEmpty(B4)) {
                        }
                        i5 = bundle2.getInt("com.google.firebase.messaging.default_notification_color", 0);
                        if (i5 != 0) {
                        }
                        valueOf = null;
                        if (valueOf != null) {
                        }
                        o = c2835cv.o("gcm.n.sticky");
                        Notification notification22222 = c3902qI2.s;
                        if (o) {
                        }
                        c3902qI2.m = c2835cv.o("gcm.n.local_only");
                        B5 = c2835cv.B("gcm.n.ticker");
                        if (B5 != null) {
                        }
                        s = c2835cv.s("gcm.n.notification_priority");
                        if (s != null) {
                        }
                        s = null;
                        if (s != null) {
                        }
                        s2 = c2835cv.s("gcm.n.visibility");
                        if (s2 != null) {
                        }
                        s2 = null;
                        if (s2 != null) {
                        }
                        s3 = c2835cv.s("gcm.n.notification_count");
                        if (s3 != null) {
                        }
                        s3 = null;
                        if (s3 != null) {
                        }
                        y = c2835cv.y();
                        if (y != null) {
                        }
                        C = c2835cv.C();
                        if (C != null) {
                        }
                        v = c2835cv.v();
                        if (v != null) {
                        }
                        boolean o22222222 = c2835cv.o("gcm.n.default_sound");
                        boolean z22222222 = o22222222;
                        if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                        }
                        r0 = z22222222;
                        if (c2835cv.o("gcm.n.default_light_settings")) {
                        }
                        Notification notification42222222 = c3902qI2.s;
                        notification42222222.defaults = r0;
                        if ((r0 & 4) != 0) {
                        }
                        B6 = c2835cv.B("gcm.n.tag");
                        if (TextUtils.isEmpty(B6)) {
                        }
                        String str22222222 = B6;
                        if (c0240Iw != null) {
                        }
                        if (Log.isLoggable("FirebaseMessaging", 3)) {
                        }
                        ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str22222222, 0, c3902qI2.a());
                        return true;
                    }
                    Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
                    notificationChannel = notificationManager.getNotificationChannel("fcm_fallback_notification_channel");
                    if (notificationChannel == null) {
                        int identifier = firebaseMessagingService.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", firebaseMessagingService.getPackageName());
                        if (identifier == 0) {
                            Log.e("FirebaseMessaging", "String resource \"fcm_fallback_notification_channel_label\" is not found. Using default string channel name.");
                            string = "Misc";
                        } else {
                            string = firebaseMessagingService.getString(identifier);
                        }
                        notificationManager.createNotificationChannel(A0.d(string));
                    }
                    B8 = "fcm_fallback_notification_channel";
                    packageName = firebaseMessagingService.getPackageName();
                    Resources resources22 = firebaseMessagingService.getResources();
                    packageManager = firebaseMessagingService.getPackageManager();
                    C3902qI c3902qI22 = new C3902qI(firebaseMessagingService, B8);
                    A = c2835cv.A(packageName, resources22, "gcm.n.title");
                    if (!TextUtils.isEmpty(A)) {
                    }
                    A2 = c2835cv.A(packageName, resources22, "gcm.n.body");
                    if (!TextUtils.isEmpty(A2)) {
                    }
                    B = c2835cv.B("gcm.n.icon");
                    if (TextUtils.isEmpty(B)) {
                    }
                    i3 = bundle2.getInt("com.google.firebase.messaging.default_notification_icon", 0);
                    if (i3 != 0) {
                    }
                    i3 = packageManager.getApplicationInfo(packageName, 0).icon;
                    if (i3 == 0) {
                    }
                    c3902qI22.s.icon = i4;
                    B2 = c2835cv.B("gcm.n.sound2");
                    if (TextUtils.isEmpty(B2)) {
                    }
                    if (!TextUtils.isEmpty(B2)) {
                    }
                    if (defaultUri != null) {
                    }
                    B3 = c2835cv.B("gcm.n.click_action");
                    if (TextUtils.isEmpty(B3)) {
                    }
                    AtomicInteger atomicInteger2222 = AbstractC0274Ke.a;
                    if (launchIntentForPackage != null) {
                    }
                    c3902qI22.g = activity;
                    if (c2835cv.o("google.c.a.e")) {
                    }
                    if (broadcast != null) {
                    }
                    B4 = c2835cv.B("gcm.n.color");
                    if (!TextUtils.isEmpty(B4)) {
                    }
                    i5 = bundle2.getInt("com.google.firebase.messaging.default_notification_color", 0);
                    if (i5 != 0) {
                    }
                    valueOf = null;
                    if (valueOf != null) {
                    }
                    o = c2835cv.o("gcm.n.sticky");
                    Notification notification222222 = c3902qI22.s;
                    if (o) {
                    }
                    c3902qI22.m = c2835cv.o("gcm.n.local_only");
                    B5 = c2835cv.B("gcm.n.ticker");
                    if (B5 != null) {
                    }
                    s = c2835cv.s("gcm.n.notification_priority");
                    if (s != null) {
                    }
                    s = null;
                    if (s != null) {
                    }
                    s2 = c2835cv.s("gcm.n.visibility");
                    if (s2 != null) {
                    }
                    s2 = null;
                    if (s2 != null) {
                    }
                    s3 = c2835cv.s("gcm.n.notification_count");
                    if (s3 != null) {
                    }
                    s3 = null;
                    if (s3 != null) {
                    }
                    y = c2835cv.y();
                    if (y != null) {
                    }
                    C = c2835cv.C();
                    if (C != null) {
                    }
                    v = c2835cv.v();
                    if (v != null) {
                    }
                    boolean o222222222 = c2835cv.o("gcm.n.default_sound");
                    boolean z222222222 = o222222222;
                    if (c2835cv.o("gcm.n.default_vibrate_timings")) {
                    }
                    r0 = z222222222;
                    if (c2835cv.o("gcm.n.default_light_settings")) {
                    }
                    Notification notification422222222 = c3902qI22.s;
                    notification422222222.defaults = r0;
                    if ((r0 & 4) != 0) {
                    }
                    B6 = c2835cv.B("gcm.n.tag");
                    if (TextUtils.isEmpty(B6)) {
                    }
                    String str222222222 = B6;
                    if (c0240Iw != null) {
                    }
                    if (Log.isLoggable("FirebaseMessaging", 3)) {
                    }
                    ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str222222222, 0, c3902qI22.a());
                    return true;
                }
            }
            B8 = null;
            packageName = firebaseMessagingService.getPackageName();
            Resources resources222 = firebaseMessagingService.getResources();
            packageManager = firebaseMessagingService.getPackageManager();
            C3902qI c3902qI222 = new C3902qI(firebaseMessagingService, B8);
            A = c2835cv.A(packageName, resources222, "gcm.n.title");
            if (!TextUtils.isEmpty(A)) {
            }
            A2 = c2835cv.A(packageName, resources222, "gcm.n.body");
            if (!TextUtils.isEmpty(A2)) {
            }
            B = c2835cv.B("gcm.n.icon");
            if (TextUtils.isEmpty(B)) {
            }
            i3 = bundle2.getInt("com.google.firebase.messaging.default_notification_icon", 0);
            if (i3 != 0) {
            }
            i3 = packageManager.getApplicationInfo(packageName, 0).icon;
            if (i3 == 0) {
            }
            c3902qI222.s.icon = i4;
            B2 = c2835cv.B("gcm.n.sound2");
            if (TextUtils.isEmpty(B2)) {
            }
            if (!TextUtils.isEmpty(B2)) {
            }
            if (defaultUri != null) {
            }
            B3 = c2835cv.B("gcm.n.click_action");
            if (TextUtils.isEmpty(B3)) {
            }
            AtomicInteger atomicInteger22222 = AbstractC0274Ke.a;
            if (launchIntentForPackage != null) {
            }
            c3902qI222.g = activity;
            if (c2835cv.o("google.c.a.e")) {
            }
            if (broadcast != null) {
            }
            B4 = c2835cv.B("gcm.n.color");
            if (!TextUtils.isEmpty(B4)) {
            }
            i5 = bundle2.getInt("com.google.firebase.messaging.default_notification_color", 0);
            if (i5 != 0) {
            }
            valueOf = null;
            if (valueOf != null) {
            }
            o = c2835cv.o("gcm.n.sticky");
            Notification notification2222222 = c3902qI222.s;
            if (o) {
            }
            c3902qI222.m = c2835cv.o("gcm.n.local_only");
            B5 = c2835cv.B("gcm.n.ticker");
            if (B5 != null) {
            }
            s = c2835cv.s("gcm.n.notification_priority");
            if (s != null) {
            }
            s = null;
            if (s != null) {
            }
            s2 = c2835cv.s("gcm.n.visibility");
            if (s2 != null) {
            }
            s2 = null;
            if (s2 != null) {
            }
            s3 = c2835cv.s("gcm.n.notification_count");
            if (s3 != null) {
            }
            s3 = null;
            if (s3 != null) {
            }
            y = c2835cv.y();
            if (y != null) {
            }
            C = c2835cv.C();
            if (C != null) {
            }
            v = c2835cv.v();
            if (v != null) {
            }
            boolean o2222222222 = c2835cv.o("gcm.n.default_sound");
            boolean z2222222222 = o2222222222;
            if (c2835cv.o("gcm.n.default_vibrate_timings")) {
            }
            r0 = z2222222222;
            if (c2835cv.o("gcm.n.default_light_settings")) {
            }
            Notification notification4222222222 = c3902qI222.s;
            notification4222222222.defaults = r0;
            if ((r0 & 4) != 0) {
            }
            B6 = c2835cv.B("gcm.n.tag");
            if (TextUtils.isEmpty(B6)) {
            }
            String str2222222222 = B6;
            if (c0240Iw != null) {
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
            }
            ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str2222222222, 0, c3902qI222.a());
            return true;
        }
        c0240Iw = null;
        if (c0240Iw != null) {
        }
        firebaseMessagingService = (FirebaseMessagingService) this.c;
        c2835cv = (C2835cv) this.d;
        AtomicInteger atomicInteger3 = AbstractC0274Ke.a;
        applicationInfo = firebaseMessagingService.getPackageManager().getApplicationInfo(firebaseMessagingService.getPackageName(), UserVerificationMethods.USER_VERIFY_PATTERN);
        if (applicationInfo != null) {
        }
        bundle = Bundle.EMPTY;
        Bundle bundle22 = bundle;
        String B82 = c2835cv.B("gcm.n.android_channel_id");
        if (Build.VERSION.SDK_INT >= 26) {
        }
        B82 = null;
        packageName = firebaseMessagingService.getPackageName();
        Resources resources2222 = firebaseMessagingService.getResources();
        packageManager = firebaseMessagingService.getPackageManager();
        C3902qI c3902qI2222 = new C3902qI(firebaseMessagingService, B82);
        A = c2835cv.A(packageName, resources2222, "gcm.n.title");
        if (!TextUtils.isEmpty(A)) {
        }
        A2 = c2835cv.A(packageName, resources2222, "gcm.n.body");
        if (!TextUtils.isEmpty(A2)) {
        }
        B = c2835cv.B("gcm.n.icon");
        if (TextUtils.isEmpty(B)) {
        }
        i3 = bundle22.getInt("com.google.firebase.messaging.default_notification_icon", 0);
        if (i3 != 0) {
        }
        i3 = packageManager.getApplicationInfo(packageName, 0).icon;
        if (i3 == 0) {
        }
        c3902qI2222.s.icon = i4;
        B2 = c2835cv.B("gcm.n.sound2");
        if (TextUtils.isEmpty(B2)) {
        }
        if (!TextUtils.isEmpty(B2)) {
        }
        if (defaultUri != null) {
        }
        B3 = c2835cv.B("gcm.n.click_action");
        if (TextUtils.isEmpty(B3)) {
        }
        AtomicInteger atomicInteger222222 = AbstractC0274Ke.a;
        if (launchIntentForPackage != null) {
        }
        c3902qI2222.g = activity;
        if (c2835cv.o("google.c.a.e")) {
        }
        if (broadcast != null) {
        }
        B4 = c2835cv.B("gcm.n.color");
        if (!TextUtils.isEmpty(B4)) {
        }
        i5 = bundle22.getInt("com.google.firebase.messaging.default_notification_color", 0);
        if (i5 != 0) {
        }
        valueOf = null;
        if (valueOf != null) {
        }
        o = c2835cv.o("gcm.n.sticky");
        Notification notification22222222 = c3902qI2222.s;
        if (o) {
        }
        c3902qI2222.m = c2835cv.o("gcm.n.local_only");
        B5 = c2835cv.B("gcm.n.ticker");
        if (B5 != null) {
        }
        s = c2835cv.s("gcm.n.notification_priority");
        if (s != null) {
        }
        s = null;
        if (s != null) {
        }
        s2 = c2835cv.s("gcm.n.visibility");
        if (s2 != null) {
        }
        s2 = null;
        if (s2 != null) {
        }
        s3 = c2835cv.s("gcm.n.notification_count");
        if (s3 != null) {
        }
        s3 = null;
        if (s3 != null) {
        }
        y = c2835cv.y();
        if (y != null) {
        }
        C = c2835cv.C();
        if (C != null) {
        }
        v = c2835cv.v();
        if (v != null) {
        }
        boolean o22222222222 = c2835cv.o("gcm.n.default_sound");
        boolean z22222222222 = o22222222222;
        if (c2835cv.o("gcm.n.default_vibrate_timings")) {
        }
        r0 = z22222222222;
        if (c2835cv.o("gcm.n.default_light_settings")) {
        }
        Notification notification42222222222 = c3902qI2222.s;
        notification42222222222.defaults = r0;
        if ((r0 & 4) != 0) {
        }
        B6 = c2835cv.B("gcm.n.tag");
        if (TextUtils.isEmpty(B6)) {
        }
        String str22222222222 = B6;
        if (c0240Iw != null) {
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
        }
        ((NotificationManager) ((FirebaseMessagingService) this.c).getSystemService("notification")).notify(str22222222222, 0, c3902qI2222.a());
        return true;
    }

    public boolean P(CharSequence charSequence, int i2, int i3, C3363jZ c3363jZ) {
        if ((c3363jZ.c & 3) == 0) {
            C3063fk c3063fk = (C3063fk) this.d;
            C3026fG b = c3363jZ.b();
            int a = b.a(8);
            if (a != 0) {
                ((ByteBuffer) b.d).getShort(a + b.a);
            }
            c3063fk.getClass();
            ThreadLocal threadLocal = C3063fk.b;
            if (threadLocal.get() == null) {
                threadLocal.set(new StringBuilder());
            }
            StringBuilder sb = (StringBuilder) threadLocal.get();
            sb.setLength(0);
            while (i2 < i3) {
                sb.append(charSequence.charAt(i2));
                i2++;
            }
            boolean hasGlyph = c3063fk.a.hasGlyph(sb.toString());
            int i4 = c3363jZ.c & 4;
            c3363jZ.c = hasGlyph ? i4 | 2 : i4 | 1;
        }
        return (c3363jZ.c & 3) == 2;
    }

    public void Q(String str, String str2) {
        ((HashMap) this.d).put(str, str2);
    }

    public void R(View view) {
        ((ArrayList) this.d).add(view);
        C2882dV c2882dV = (C2882dV) this.b;
        AbstractC4143tN I = RecyclerView.I(view);
        if (I != null) {
            int i2 = I.q;
            View view2 = I.a;
            if (i2 != -1) {
                I.p = i2;
            } else {
                WeakHashMap weakHashMap = AbstractC2925e20.a;
                I.p = view2.getImportantForAccessibility();
            }
            RecyclerView recyclerView = (RecyclerView) c2882dV.b;
            if (recyclerView.L()) {
                I.q = 4;
                recyclerView.q0.add(I);
            } else {
                WeakHashMap weakHashMap2 = AbstractC2925e20.a;
                view2.setImportantForAccessibility(4);
            }
        }
    }

    public boolean T(int i2, C0824bg c0824bg, C3774og c3774og) {
        int[] iArr = c3774og.o0;
        int i3 = iArr[0];
        C4077sa c4077sa = (C4077sa) this.c;
        c4077sa.a = i3;
        c4077sa.b = iArr[1];
        c4077sa.c = c3774og.n();
        c4077sa.d = c3774og.k();
        c4077sa.i = false;
        c4077sa.j = i2;
        boolean z = c4077sa.a == 3;
        boolean z2 = c4077sa.b == 3;
        boolean z3 = z && c3774og.V > 0.0f;
        boolean z4 = z2 && c3774og.V > 0.0f;
        int[] iArr2 = c3774og.s;
        if (z3 && iArr2[0] == 4) {
            c4077sa.a = 1;
        }
        if (z4 && iArr2[1] == 4) {
            c4077sa.b = 1;
        }
        c0824bg.b(c3774og, c4077sa);
        c3774og.J(c4077sa.e);
        c3774og.G(c4077sa.f);
        c3774og.D = c4077sa.h;
        c3774og.D(c4077sa.g);
        c4077sa.j = 0;
        return c4077sa.i;
    }

    public Object V(CharSequence charSequence, int i2, int i3, int i4, boolean z, InterfaceC0516Tn interfaceC0516Tn) {
        int i5;
        char c;
        C0542Un c0542Un = new C0542Un((C3186hG) ((NX) this.c).c);
        int codePointAt = Character.codePointAt(charSequence, i2);
        boolean z2 = true;
        int i6 = 0;
        int i7 = i2;
        loop0: while (true) {
            i5 = i7;
            while (i7 < i3 && i6 < i4 && z2) {
                SparseArray sparseArray = c0542Un.c.a;
                C3186hG c3186hG = sparseArray == null ? null : (C3186hG) sparseArray.get(codePointAt);
                if (c0542Un.a == 2) {
                    if (c3186hG != null) {
                        c0542Un.c = c3186hG;
                        c0542Un.f++;
                    } else {
                        if (codePointAt == 65038) {
                            c0542Un.a();
                        } else if (codePointAt != 65039) {
                            C3186hG c3186hG2 = c0542Un.c;
                            if (c3186hG2.b != null) {
                                if (c0542Un.f != 1) {
                                    c0542Un.d = c3186hG2;
                                    c0542Un.a();
                                } else if (c0542Un.b()) {
                                    c0542Un.d = c0542Un.c;
                                    c0542Un.a();
                                } else {
                                    c0542Un.a();
                                }
                                c = 3;
                            } else {
                                c0542Un.a();
                            }
                        }
                        c = 1;
                    }
                    c = 2;
                } else if (c3186hG == null) {
                    c0542Un.a();
                    c = 1;
                } else {
                    c0542Un.a = 2;
                    c0542Un.c = c3186hG;
                    c0542Un.f = 1;
                    c = 2;
                }
                c0542Un.e = codePointAt;
                if (c == 1) {
                    i7 = Character.charCount(Character.codePointAt(charSequence, i5)) + i5;
                    if (i7 < i3) {
                        codePointAt = Character.codePointAt(charSequence, i7);
                    }
                } else if (c == 2) {
                    int charCount = Character.charCount(codePointAt) + i7;
                    if (charCount < i3) {
                        codePointAt = Character.codePointAt(charSequence, charCount);
                    }
                    i7 = charCount;
                } else if (c == 3) {
                    if (z || !P(charSequence, i5, i7, c0542Un.d.b)) {
                        z2 = interfaceC0516Tn.b(charSequence, i5, i7, c0542Un.d.b);
                        i6++;
                    }
                }
            }
        }
        if (c0542Un.a == 2 && c0542Un.c.b != null && ((c0542Un.f > 1 || c0542Un.b()) && i6 < i4 && z2 && (z || !P(charSequence, i5, i7, c0542Un.c.b)))) {
            interfaceC0516Tn.b(charSequence, i5, i7, c0542Un.c.b);
        }
        return interfaceC0516Tn.a();
    }

    public void X(String str) {
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.b = str;
    }

    public void Y(int i2) {
        if (i2 != 16 && i2 != 32) {
            throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit and 256-bit AES keys are supported", Integer.valueOf(i2 * 8)));
        }
        this.b = Integer.valueOf(i2);
    }

    public void Z(int i2) {
        if (i2 < 10 || 16 < i2) {
            throw new GeneralSecurityException(W50.i(i2, "Invalid tag size for AesCmacParameters: "));
        }
        this.c = Integer.valueOf(i2);
    }

    @Override // defpackage.InterfaceC4106sx
    public Object a() {
        return null;
    }

    public void a0(C3853pg c3853pg, int i2, int i3, int i4) {
        int i5 = c3853pg.a0;
        int i6 = c3853pg.b0;
        c3853pg.a0 = 0;
        c3853pg.b0 = 0;
        c3853pg.J(i3);
        c3853pg.G(i4);
        if (i5 < 0) {
            c3853pg.a0 = 0;
        } else {
            c3853pg.a0 = i5;
        }
        if (i6 < 0) {
            c3853pg.b0 = 0;
        } else {
            c3853pg.b0 = i6;
        }
        C3853pg c3853pg2 = (C3853pg) this.d;
        c3853pg2.s0 = i2;
        c3853pg2.P();
    }

    @Override // defpackage.InterfaceC4106sx
    public Uri b() {
        return (Uri) this.b;
    }

    public byte[] b0() {
        long[] jArr = new long[10];
        long[] jArr2 = new long[10];
        long[] jArr3 = new long[10];
        long[] jArr4 = new long[10];
        long[] jArr5 = new long[10];
        long[] jArr6 = new long[10];
        long[] jArr7 = new long[10];
        long[] jArr8 = new long[10];
        long[] jArr9 = new long[10];
        long[] jArr10 = new long[10];
        long[] jArr11 = new long[10];
        long[] jArr12 = new long[10];
        long[] jArr13 = new long[10];
        long[] jArr14 = (long[]) this.d;
        AbstractC3131gc0.K(jArr4, jArr14);
        AbstractC3131gc0.K(jArr13, jArr4);
        AbstractC3131gc0.K(jArr12, jArr13);
        AbstractC3131gc0.A(jArr5, jArr12, jArr14);
        AbstractC3131gc0.A(jArr6, jArr5, jArr4);
        AbstractC3131gc0.K(jArr12, jArr6);
        AbstractC3131gc0.A(jArr7, jArr12, jArr5);
        AbstractC3131gc0.K(jArr12, jArr7);
        AbstractC3131gc0.K(jArr13, jArr12);
        AbstractC3131gc0.K(jArr12, jArr13);
        AbstractC3131gc0.K(jArr13, jArr12);
        AbstractC3131gc0.K(jArr12, jArr13);
        AbstractC3131gc0.A(jArr8, jArr12, jArr7);
        AbstractC3131gc0.K(jArr12, jArr8);
        AbstractC3131gc0.K(jArr13, jArr12);
        for (int i2 = 2; i2 < 10; i2 += 2) {
            AbstractC3131gc0.K(jArr12, jArr13);
            AbstractC3131gc0.K(jArr13, jArr12);
        }
        AbstractC3131gc0.A(jArr9, jArr13, jArr8);
        AbstractC3131gc0.K(jArr12, jArr9);
        AbstractC3131gc0.K(jArr13, jArr12);
        for (int i3 = 2; i3 < 20; i3 += 2) {
            AbstractC3131gc0.K(jArr12, jArr13);
            AbstractC3131gc0.K(jArr13, jArr12);
        }
        AbstractC3131gc0.A(jArr12, jArr13, jArr9);
        AbstractC3131gc0.K(jArr13, jArr12);
        AbstractC3131gc0.K(jArr12, jArr13);
        for (int i4 = 2; i4 < 10; i4 += 2) {
            AbstractC3131gc0.K(jArr13, jArr12);
            AbstractC3131gc0.K(jArr12, jArr13);
        }
        AbstractC3131gc0.A(jArr10, jArr12, jArr8);
        AbstractC3131gc0.K(jArr12, jArr10);
        AbstractC3131gc0.K(jArr13, jArr12);
        for (int i5 = 2; i5 < 50; i5 += 2) {
            AbstractC3131gc0.K(jArr12, jArr13);
            AbstractC3131gc0.K(jArr13, jArr12);
        }
        AbstractC3131gc0.A(jArr11, jArr13, jArr10);
        AbstractC3131gc0.K(jArr13, jArr11);
        AbstractC3131gc0.K(jArr12, jArr13);
        for (int i6 = 2; i6 < 100; i6 += 2) {
            AbstractC3131gc0.K(jArr13, jArr12);
            AbstractC3131gc0.K(jArr12, jArr13);
        }
        AbstractC3131gc0.A(jArr13, jArr12, jArr11);
        AbstractC3131gc0.K(jArr12, jArr13);
        AbstractC3131gc0.K(jArr13, jArr12);
        for (int i7 = 2; i7 < 50; i7 += 2) {
            AbstractC3131gc0.K(jArr12, jArr13);
            AbstractC3131gc0.K(jArr13, jArr12);
        }
        AbstractC3131gc0.A(jArr12, jArr13, jArr10);
        AbstractC3131gc0.K(jArr13, jArr12);
        AbstractC3131gc0.K(jArr12, jArr13);
        AbstractC3131gc0.K(jArr13, jArr12);
        AbstractC3131gc0.K(jArr12, jArr13);
        AbstractC3131gc0.K(jArr13, jArr12);
        AbstractC3131gc0.A(jArr, jArr13, jArr6);
        AbstractC3131gc0.A(jArr2, (long[]) this.b, jArr);
        AbstractC3131gc0.A(jArr3, (long[]) this.c, jArr);
        byte[] i8 = AbstractC3131gc0.i(jArr3);
        i8[31] = (byte) (((AbstractC3131gc0.i(jArr2)[0] & 1) << 7) ^ i8[31]);
        return i8;
    }

    @Override // defpackage.InterfaceC4106sx
    public void c() {
    }

    @Override // defpackage.InterfaceC4106sx
    public Uri d() {
        return (Uri) this.d;
    }

    @Override // defpackage.InterfaceC0774b4
    public void e(Bundle bundle) {
        synchronized (this.c) {
            try {
                C4254un c4254un = C4254un.e;
                c4254un.u("Logging event _ae to Firebase Analytics with params " + bundle);
                this.d = new CountDownLatch(1);
                ((C0136Ew) this.b).e(bundle);
                c4254un.u("Awaiting app exception callback from Analytics...");
                try {
                    if (((CountDownLatch) this.d).await(500, TimeUnit.MILLISECONDS)) {
                        c4254un.u("App exception callback received from Analytics listener.");
                    } else {
                        c4254un.v("Timeout exceeded while awaiting app exception callback from Analytics listener.", null);
                    }
                } catch (InterruptedException unused) {
                    Log.e("FirebaseCrashlytics", "Interrupted while awaiting app exception callback from Analytics listener.", null);
                }
                this.d = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e0(View view) {
        if (((ArrayList) this.d).remove(view)) {
            C2882dV c2882dV = (C2882dV) this.b;
            AbstractC4143tN I = RecyclerView.I(view);
            if (I != null) {
                int i2 = I.p;
                RecyclerView recyclerView = (RecyclerView) c2882dV.b;
                if (recyclerView.L()) {
                    I.q = i2;
                    recyclerView.q0.add(I);
                } else {
                    WeakHashMap weakHashMap = AbstractC2925e20.a;
                    I.a.setImportantForAccessibility(i2);
                }
                I.p = 0;
            }
        }
    }

    public void f(View view, int i2, boolean z) {
        RecyclerView recyclerView = (RecyclerView) ((C2882dV) this.b).b;
        int childCount = i2 < 0 ? recyclerView.getChildCount() : J(i2);
        ((C3768od) this.c).e(childCount, z);
        if (z) {
            R(view);
        }
        recyclerView.addView(view, childCount);
        RecyclerView.I(view);
    }

    public void f0(C3853pg c3853pg) {
        ArrayList arrayList = (ArrayList) this.b;
        arrayList.clear();
        int size = c3853pg.p0.size();
        for (int i2 = 0; i2 < size; i2++) {
            C3774og c3774og = (C3774og) c3853pg.p0.get(i2);
            int[] iArr = c3774og.o0;
            if (iArr[0] == 3 || iArr[1] == 3) {
                arrayList.add(c3774og);
            }
        }
        c3853pg.r0.b = true;
    }

    @Override // defpackage.YL
    public Object get() {
        Context context = (Context) ((C2835cv) this.b).b;
        InterfaceC0613Xg interfaceC0613Xg = (InterfaceC0613Xg) ((C2835cv) this.c).b;
        NR nr = (NR) ((XL) this.d).get();
        AbstractC3634my.g(context, "appContext");
        AbstractC3634my.g(interfaceC0613Xg, "blockingDispatcher");
        AbstractC3634my.g(nr, "sessionDataSerializer");
        return C0213Hv.h(nr, new C2882dV(new C3636n(nr, 1), 27), AbstractC0538Uj.a(interfaceC0613Xg), new C4258ur(context, 1));
    }

    @Override // defpackage.InterfaceC4106sx
    public ClipDescription getDescription() {
        return (ClipDescription) this.c;
    }

    public void h(View view, int i2, ViewGroup.LayoutParams layoutParams, boolean z) {
        RecyclerView recyclerView = (RecyclerView) ((C2882dV) this.b).b;
        int childCount = i2 < 0 ? recyclerView.getChildCount() : J(i2);
        ((C3768od) this.c).e(childCount, z);
        if (z) {
            R(view);
        }
        AbstractC4143tN I = RecyclerView.I(view);
        if (I != null) {
            if (!I.j() && !I.o()) {
                throw new IllegalArgumentException("Called attach on a child which is not detached: " + I + recyclerView.y());
            }
            I.j &= -257;
        }
        recyclerView.attachViewToParent(view, childCount, layoutParams);
    }

    public C4351w2 i() {
        C2882dV c2882dV;
        C4395wb a;
        C2 c2 = (C2) this.b;
        if (c2 == null || (c2882dV = (C2882dV) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (c2.a != ((C4395wb) c2882dV.b).a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (c2.a() && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!((C2) this.b).a() && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        B2 b2 = ((C2) this.b).c;
        if (b2 == B2.f) {
            a = AbstractC4613zJ.a;
        } else if (b2 == B2.e || b2 == B2.d) {
            a = AbstractC4613zJ.a(((Integer) this.d).intValue());
        } else {
            if (b2 != B2.c) {
                throw new IllegalStateException("Unknown AesCmacParametersParameters.Variant: " + ((C2) this.b).c);
            }
            a = AbstractC4613zJ.b(((Integer) this.d).intValue());
        }
        return new C4351w2((C2) this.b, (C2882dV) this.c, a, (Integer) this.d);
    }

    public C2 j() {
        Integer num = (Integer) this.b;
        if (num == null) {
            throw new GeneralSecurityException("key size not set");
        }
        if (((Integer) this.c) == null) {
            throw new GeneralSecurityException("tag size not set");
        }
        if (((B2) this.d) != null) {
            return new C2(num.intValue(), ((Integer) this.c).intValue(), (B2) this.d);
        }
        throw new GeneralSecurityException("variant not set");
    }

    @Override // defpackage.InterfaceC0853c4
    public void k(Bundle bundle, String str) {
        CountDownLatch countDownLatch = (CountDownLatch) this.d;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }

    public C3006f3 l() {
        C2882dV c2882dV;
        C4395wb b;
        C3324j3 c3324j3 = (C3324j3) this.b;
        if (c3324j3 == null || (c2882dV = (C2882dV) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (c3324j3.a != ((C4395wb) c2882dV.b).a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (c3324j3.a() && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!((C3324j3) this.b).a() && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        B2 b2 = ((C3324j3) this.b).d;
        if (b2 == B2.i) {
            b = AbstractC4613zJ.a;
        } else if (b2 == B2.h) {
            b = AbstractC4613zJ.a(((Integer) this.d).intValue());
        } else {
            if (b2 != B2.g) {
                throw new IllegalStateException("Unknown AesEaxParameters.Variant: " + ((C3324j3) this.b).d);
            }
            b = AbstractC4613zJ.b(((Integer) this.d).intValue());
        }
        return new C3006f3((C3324j3) this.b, (C2882dV) this.c, b, (Integer) this.d);
    }

    public C3880q3 m() {
        C2882dV c2882dV;
        C4395wb b;
        C4195u3 c4195u3 = (C4195u3) this.b;
        if (c4195u3 == null || (c2882dV = (C2882dV) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (c4195u3.a != ((C4395wb) c2882dV.b).a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (c4195u3.a() && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!((C4195u3) this.b).a() && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        Q2 q2 = ((C4195u3) this.b).d;
        if (q2 == Q2.j) {
            b = AbstractC4613zJ.a;
        } else if (q2 == Q2.i) {
            b = AbstractC4613zJ.a(((Integer) this.d).intValue());
        } else {
            if (q2 != Q2.h) {
                throw new IllegalStateException("Unknown AesGcmParameters.Variant: " + ((C4195u3) this.b).d);
            }
            b = AbstractC4613zJ.b(((Integer) this.d).intValue());
        }
        return new C3880q3((C4195u3) this.b, (C2882dV) this.c, b, (Integer) this.d);
    }

    public A3 n() {
        C2882dV c2882dV;
        C4395wb b;
        E3 e3 = (E3) this.b;
        if (e3 == null || (c2882dV = (C2882dV) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (e3.a != ((C4395wb) c2882dV.b).a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (e3.a() && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!((E3) this.b).a() && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        R2 r2 = ((E3) this.b).b;
        if (r2 == R2.h) {
            b = AbstractC4613zJ.a;
        } else if (r2 == R2.g) {
            b = AbstractC4613zJ.a(((Integer) this.d).intValue());
        } else {
            if (r2 != R2.f) {
                throw new IllegalStateException("Unknown AesGcmSivParameters.Variant: " + ((E3) this.b).b);
            }
            b = AbstractC4613zJ.b(((Integer) this.d).intValue());
        }
        return new A3((E3) this.b, (C2882dV) this.c, b, (Integer) this.d);
    }

    public C4286v9 o() {
        String str = ((String) this.b) == null ? " backendName" : "";
        if (((EnumC3191hL) this.d) == null) {
            str = str.concat(" priority");
        }
        if (str.isEmpty()) {
            return new C4286v9((String) this.b, (byte[]) this.c, (EnumC3191hL) this.d);
        }
        throw new IllegalStateException("Missing required properties:".concat(str));
    }

    public C0282Km p() {
        C4395wb a;
        C0074Cm c0074Cm = (C0074Cm) this.b;
        if (c0074Cm == null) {
            throw new GeneralSecurityException("Cannot build without parameters");
        }
        ECPoint eCPoint = (ECPoint) this.c;
        if (eCPoint == null) {
            throw new GeneralSecurityException("Cannot build without public point");
        }
        AbstractC0075Cn.b(eCPoint, c0074Cm.b.b.getCurve());
        if (((C0074Cm) this.b).a() && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!((C0074Cm) this.b).a() && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        Q2 q2 = ((C0074Cm) this.b).d;
        if (q2 == Q2.n) {
            a = AbstractC4613zJ.a;
        } else if (q2 == Q2.m || q2 == Q2.l) {
            a = AbstractC4613zJ.a(((Integer) this.d).intValue());
        } else {
            if (q2 != Q2.k) {
                throw new IllegalStateException("Unknown EcdsaParameters.Variant: " + ((C0074Cm) this.b).d);
            }
            a = AbstractC4613zJ.b(((Integer) this.d).intValue());
        }
        return new C0282Km((C0074Cm) this.b, (ECPoint) this.c, a, (Integer) this.d);
    }

    public C0602Wv q() {
        C2882dV c2882dV;
        C4395wb a;
        C2836cw c2836cw = (C2836cw) this.b;
        if (c2836cw == null || (c2882dV = (C2882dV) this.c) == null) {
            throw new GeneralSecurityException("Cannot build without parameters and/or key material");
        }
        if (c2836cw.a != ((C4395wb) c2882dV.b).a.length) {
            throw new GeneralSecurityException("Key size mismatch");
        }
        if (c2836cw.a() && ((Integer) this.d) == null) {
            throw new GeneralSecurityException("Cannot create key without ID requirement with parameters with ID requirement");
        }
        if (!((C2836cw) this.b).a() && ((Integer) this.d) != null) {
            throw new GeneralSecurityException("Cannot create key with ID requirement with parameters without ID requirement");
        }
        C0841bw c0841bw = ((C2836cw) this.b).c;
        if (c0841bw == C0841bw.e) {
            a = AbstractC4613zJ.a;
        } else if (c0841bw == C0841bw.d || c0841bw == C0841bw.c) {
            a = AbstractC4613zJ.a(((Integer) this.d).intValue());
        } else {
            if (c0841bw != C0841bw.b) {
                throw new IllegalStateException("Unknown HmacParameters.Variant: " + ((C2836cw) this.b).c);
            }
            a = AbstractC4613zJ.b(((Integer) this.d).intValue());
        }
        return new C0602Wv((C2836cw) this.b, (C2882dV) this.c, a, (Integer) this.d);
    }

    public String toString() {
        switch (this.a) {
            case 13:
                return ((C3768od) this.c).toString() + ", hidden list:" + ((ArrayList) this.d).size();
            case 25:
                C4446xA I = I();
                int i2 = A00.a;
                BA x = EA.x();
                int A = I.A();
                x.d();
                EA.v((EA) x.b, A);
                for (C4367wA c4367wA : I.z()) {
                    CA z = DA.z();
                    String A2 = c4367wA.z().A();
                    z.d();
                    DA.v((DA) z.b, A2);
                    EnumC3736oA C = c4367wA.C();
                    z.d();
                    DA.x((DA) z.b, C);
                    EnumC4534yJ B = c4367wA.B();
                    z.d();
                    DA.w((DA) z.b, B);
                    int A3 = c4367wA.A();
                    z.d();
                    DA.y((DA) z.b, A3);
                    DA da = (DA) z.a();
                    x.d();
                    EA.w((EA) x.b, da);
                }
                return ((EA) x.a()).toString();
            default:
                return super.toString();
        }
    }

    public void w(int i2) {
        AbstractC4143tN I;
        int J = J(i2);
        ((C3768od) this.c).f(J);
        RecyclerView recyclerView = (RecyclerView) ((C2882dV) this.b).b;
        View childAt = recyclerView.getChildAt(J);
        if (childAt != null && (I = RecyclerView.I(childAt)) != null) {
            if (I.j() && !I.o()) {
                throw new IllegalArgumentException("called detach on an already detached child " + I + recyclerView.y());
            }
            I.a(UserVerificationMethods.USER_VERIFY_HANDPRINT);
        }
        recyclerView.detachViewFromParent(J);
    }

    public void x(Bundle bundle) {
        HashSet hashSet;
        String string = ((Context) this.d).getString(R.string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet2 = new HashSet();
                Iterator<String> it = bundle.keySet().iterator();
                while (true) {
                    boolean hasNext = it.hasNext();
                    hashSet = (HashSet) this.c;
                    if (!hasNext) {
                        break;
                    }
                    String next = it.next();
                    if (string.equals(bundle.getString(next, null))) {
                        Class<?> cls = Class.forName(next);
                        if (InterfaceC3791ox.class.isAssignableFrom(cls)) {
                            hashSet.add(cls);
                        }
                    }
                }
                Iterator it2 = hashSet.iterator();
                while (it2.hasNext()) {
                    y((Class) it2.next(), hashSet2);
                }
            } catch (ClassNotFoundException e2) {
                throw new C0742af(e2);
            }
        }
    }

    public Object y(Class cls, HashSet hashSet) {
        Object obj;
        if (AbstractC3131gc0.y()) {
            try {
                AbstractC3131gc0.f(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (hashSet.contains(cls)) {
            throw new IllegalStateException("Cannot initialize " + cls.getName() + ". Cycle detected.");
        }
        HashMap hashMap = (HashMap) this.b;
        if (hashMap.containsKey(cls)) {
            obj = hashMap.get(cls);
        } else {
            hashSet.add(cls);
            try {
                InterfaceC3791ox interfaceC3791ox = (InterfaceC3791ox) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class> a = interfaceC3791ox.a();
                if (!a.isEmpty()) {
                    for (Class cls2 : a) {
                        if (!hashMap.containsKey(cls2)) {
                            y(cls2, hashSet);
                        }
                    }
                }
                obj = interfaceC3791ox.create((Context) this.d);
                hashSet.remove(cls);
                hashMap.put(cls, obj);
            } catch (Throwable th2) {
                throw new C0742af(th2);
            }
        }
        Trace.endSection();
        return obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public C4553yb z() {
        Throwable th;
        HttpsURLConnection httpsURLConnection;
        String u;
        String str;
        s();
        InputStream inputStream = null;
        String sb = null;
        inputStream = null;
        try {
            try {
                u = u((HashMap) this.b, (String) this.c);
                str = "GET Request URL: " + u;
            } catch (Throwable th2) {
                th = th2;
                httpsURLConnection = null;
                if (inputStream != null) {
                }
                if (httpsURLConnection != null) {
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        try {
            if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                Log.v("FirebaseCrashlytics", str, null);
            }
            httpsURLConnection = (HttpsURLConnection) new URL(u).openConnection();
            try {
                httpsURLConnection.setReadTimeout(10000);
                httpsURLConnection.setConnectTimeout(10000);
                httpsURLConnection.setRequestMethod("GET");
                for (Map.Entry entry : ((HashMap) this.d).entrySet()) {
                    httpsURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                httpsURLConnection.connect();
                int responseCode = httpsURLConnection.getResponseCode();
                InputStream inputStream2 = httpsURLConnection.getInputStream();
                if (inputStream2 != null) {
                    try {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2, "UTF-8"));
                        char[] cArr = new char[JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE];
                        StringBuilder sb2 = new StringBuilder();
                        while (true) {
                            int read = bufferedReader.read(cArr);
                            if (read == -1) {
                                break;
                            }
                            sb2.append(cArr, 0, read);
                        }
                        sb = sb2.toString();
                    } catch (Throwable th4) {
                        th = th4;
                        inputStream = inputStream2;
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (httpsURLConnection != null) {
                            httpsURLConnection.disconnect();
                        }
                        throw th;
                    }
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpsURLConnection.disconnect();
                return new C4553yb(responseCode, sb);
            } catch (Throwable th5) {
                th = th5;
            }
        } catch (Throwable th6) {
            th = th6;
            th = th;
            httpsURLConnection = null;
            if (inputStream != null) {
            }
            if (httpsURLConnection != null) {
            }
            throw th;
        }
    }

    public /* synthetic */ C2853d6(Object obj, Object obj2, Object obj3, int i2) {
        this.a = i2;
        this.b = obj;
        this.c = obj2;
        this.d = obj3;
    }

    public C2853d6(ExecutorService executorService, ExecutorService executorService2) {
        this.a = 2;
        AbstractC3634my.g(executorService, "backgroundExecutorService");
        AbstractC3634my.g(executorService2, "blockingExecutorService");
        this.b = new ExecutorC3221hi(executorService);
        this.c = new ExecutorC3221hi(executorService);
        Tasks.forResult(null);
        this.d = new ExecutorC3221hi(executorService2);
    }

    public C2853d6(HashMap hashMap, String str) {
        this.a = 23;
        this.c = str;
        this.b = hashMap;
        this.d = new HashMap();
    }

    public C2853d6(C0136Ew c0136Ew) {
        this.a = 10;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.c = new Object();
        this.b = c0136Ew;
    }

    public C2853d6(C2882dV c2882dV) {
        this.a = 13;
        this.b = c2882dV;
        this.c = new C3768od();
        this.d = new ArrayList();
    }

    public C2853d6(C0156Fq c0156Fq) {
        this.a = 1;
        this.c = null;
        this.d = null;
        this.b = c0156Fq;
    }

    public C2853d6(FirebaseMessagingService firebaseMessagingService, C2835cv c2835cv, ExecutorService executorService) {
        this.a = 15;
        this.b = executorService;
        this.c = firebaseMessagingService;
        this.d = c2835cv;
    }

    public C2853d6(C3853pg c3853pg) {
        this.a = 9;
        this.b = new ArrayList();
        this.c = new C4077sa();
        this.d = c3853pg;
    }

    public C2853d6(Context context) {
        this.a = 0;
        this.d = context.getApplicationContext();
        this.c = new HashSet();
        this.b = new HashMap();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2853d6(int i2) {
        this(new long[10], new long[10], new long[10], 17);
        this.a = i2;
        switch (i2) {
            case 20:
                this.b = new C2868dH(6);
                break;
            default:
                break;
        }
    }

    public C2853d6(C2853d6 c2853d6) {
        this.a = 17;
        this.b = Arrays.copyOf((long[]) c2853d6.b, 10);
        this.c = Arrays.copyOf((long[]) c2853d6.c, 10);
        this.d = Arrays.copyOf((long[]) c2853d6.d, 10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C2853d6(C0489Sm c0489Sm) {
        this(17);
        this.a = 17;
        B(this, c0489Sm);
    }

    public C2853d6(NX nx, C4254un c4254un, C3063fk c3063fk, Set set) {
        this.a = 18;
        this.b = c4254un;
        this.c = nx;
        this.d = c3063fk;
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int[] iArr = (int[]) it.next();
            String str = new String(iArr, 0, iArr.length);
            V(str, 0, str.length(), 1, true, new R2(str, 6));
        }
    }

    public C2853d6(Matcher matcher, CharSequence charSequence) {
        this.a = 28;
        AbstractC3634my.g(charSequence, "input");
        this.b = matcher;
        this.c = new C3582mE(this);
    }

    public C2853d6(List list, C3742oG c3742oG) {
        this.a = 25;
        this.b = list;
        this.c = c3742oG;
        if (AbstractC3074fv.a.a.get()) {
            HashSet hashSet = new HashSet();
            Iterator it = list.iterator();
            boolean z = false;
            while (it.hasNext()) {
                AA aa = (AA) it.next();
                boolean contains = hashSet.contains(Integer.valueOf(aa.d));
                int i2 = aa.d;
                if (!contains) {
                    hashSet.add(Integer.valueOf(i2));
                    if (aa.e) {
                        z = true;
                    }
                } else {
                    throw new GeneralSecurityException(W50.j(i2, "KeyID ", " is duplicated in the keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing."));
                }
            }
            if (!z) {
                throw new GeneralSecurityException("Primary key id not found in keyset, and Tink is configured to reject such keysets with the flag validateKeysetsOnParsing.");
            }
        }
        this.d = null;
    }
}
