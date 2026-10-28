package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.messaging.FirebaseMessaging;
import dastan.prince.bdfreevpn.R;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* renamed from: Yi, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0641Yi implements HH {
    public static final InterfaceC0198Hg[] a = new InterfaceC0198Hg[0];
    public static final ExecutorC3964r6 b = new ExecutorC3964r6(1);
    public static final Q2 c = new Q2("COMPLETING_ALREADY", 5);
    public static final Q2 d = new Q2("COMPLETING_WAITING_CHILDREN", 5);
    public static final Q2 e = new Q2("COMPLETING_RETRY", 5);
    public static final Q2 f = new Q2("TOO_LATE_TO_CANCEL", 5);
    public static final Q2 g = new Q2("SEALED", 5);
    public static final C0753ao h = new C0753ao(false);
    public static final C0753ao i = new C0753ao(true);
    public static final byte[] j = {112, 114, 111, 0};
    public static final byte[] k = {112, 114, 109, 0};
    public static final int[] l = {R.attr.colorPrimary};
    public static final int[] m = {R.attr.colorPrimaryVariant};
    public static final T50 n = new T50(5);
    public static final T50 o = new T50(15);
    public static final T50 p = new T50(25);
    public static final C4084sd0 q = new C4084sd0(4);

    public static final void A(InterfaceC0613Xg interfaceC0613Xg, Throwable th) {
        try {
            InterfaceC0905ch interfaceC0905ch = (InterfaceC0905ch) interfaceC0613Xg.get(C0213Hv.b);
            if (interfaceC0905ch != null) {
                interfaceC0905ch.handleException(interfaceC0613Xg, th);
            } else {
                AbstractC0199Hh.S(interfaceC0613Xg, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                XE.b(runtimeException, th);
                th = runtimeException;
            }
            AbstractC0199Hh.S(interfaceC0613Xg, th);
        }
    }

    public static List C(Object obj) {
        List singletonList = Collections.singletonList(obj);
        AbstractC3634my.f(singletonList, "singletonList(...)");
        return singletonList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019a  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0190 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0176 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0135  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void D(Intent intent) {
        int parseInt;
        int i2;
        String string;
        String string2;
        Object[] objArr;
        String string3;
        String string4;
        long parseLong;
        String str;
        String str2;
        if (a0(intent)) {
            E(intent.getExtras(), "_nr");
        }
        int i3 = 0;
        if ((intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction())) ? false : t()) {
            InterfaceC3044fY interfaceC3044fY = (InterfaceC3044fY) FirebaseMessaging.n.get();
            if (interfaceC3044fY == null) {
                Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
                return;
            }
            XF xf = null;
            r4 = null;
            String str3 = null;
            if (intent != null) {
                Bundle extras = intent.getExtras();
                if (extras == null) {
                    extras = Bundle.EMPTY;
                }
                Object obj = extras.get("google.ttl");
                if (obj instanceof Integer) {
                    parseInt = ((Integer) obj).intValue();
                } else {
                    if (obj instanceof String) {
                        try {
                            parseInt = Integer.parseInt((String) obj);
                        } catch (NumberFormatException unused) {
                            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
                        }
                    }
                    i2 = 0;
                    string = extras.getString("google.to");
                    if (TextUtils.isEmpty(string)) {
                        try {
                            C0493Sq d2 = C0493Sq.d();
                            try {
                                Object obj2 = C3150gr.m;
                                Preconditions.checkArgument(true, "Null is not a valid value of FirebaseApp.");
                                string = (String) Tasks.await(((C3150gr) d2.b(InterfaceC3230hr.class)).c());
                            } catch (InterruptedException e2) {
                                e = e2;
                                throw new RuntimeException(e);
                            }
                        } catch (InterruptedException | ExecutionException e3) {
                            e = e3;
                        }
                    }
                    String str4 = string;
                    C0493Sq d3 = C0493Sq.d();
                    d3.a();
                    String packageName = d3.a.getPackageName();
                    VF vf = !C2835cv.D(extras) ? VF.DISPLAY_NOTIFICATION : VF.DATA_MESSAGE;
                    string2 = extras.getString("google.delivered_priority");
                    if (string2 == null) {
                        if (!"1".equals(extras.getString("google.priority_reduced"))) {
                            string2 = extras.getString("google.priority");
                        }
                        objArr = 2;
                        if (objArr == 2) {
                            i3 = 5;
                        } else if (objArr == 1) {
                            i3 = 10;
                        }
                        int i4 = i3;
                        string3 = extras.getString("google.message_id");
                        if (string3 == null) {
                            string3 = extras.getString("message_id");
                        }
                        String str5 = string3 != null ? string3 : "";
                        string4 = extras.getString("from");
                        if (string4 != null && string4.startsWith("/topics/")) {
                            str3 = string4;
                        }
                        String str6 = str3 != null ? str3 : "";
                        String string5 = extras.getString("collapse_key");
                        String str7 = string5 != null ? string5 : "";
                        String string6 = extras.getString("google.c.a.m_l");
                        String str8 = string6 != null ? string6 : "";
                        String string7 = extras.getString("google.c.a.c_l");
                        String str9 = string7 != null ? string7 : "";
                        if (extras.containsKey("google.c.sender.id")) {
                            try {
                                parseLong = Long.parseLong(extras.getString("google.c.sender.id"));
                            } catch (NumberFormatException e4) {
                                Log.w("FirebaseMessaging", "error parsing project number", e4);
                            }
                            xf = new XF(parseLong > 0 ? parseLong : 0L, str5, str4, vf, packageName, str7, i4, i2, str6, str8, str9);
                        }
                        C0493Sq d4 = C0493Sq.d();
                        d4.a();
                        C3864pr c3864pr = d4.c;
                        str = c3864pr.e;
                        if (str != null) {
                            try {
                                parseLong = Long.parseLong(str);
                            } catch (NumberFormatException e5) {
                                Log.w("FirebaseMessaging", "error parsing sender ID", e5);
                            }
                            xf = new XF(parseLong > 0 ? parseLong : 0L, str5, str4, vf, packageName, str7, i4, i2, str6, str8, str9);
                        }
                        d4.a();
                        str2 = c3864pr.b;
                        if (str2.startsWith("1:")) {
                            String[] split = str2.split(":");
                            if (split.length >= 2) {
                                String str10 = split[1];
                                if (!str10.isEmpty()) {
                                    try {
                                        parseLong = Long.parseLong(str10);
                                    } catch (NumberFormatException e6) {
                                        Log.w("FirebaseMessaging", "error parsing app ID", e6);
                                    }
                                }
                            }
                            parseLong = 0;
                        } else {
                            try {
                                parseLong = Long.parseLong(str2);
                            } catch (NumberFormatException e7) {
                                Log.w("FirebaseMessaging", "error parsing app ID", e7);
                            }
                        }
                        xf = new XF(parseLong > 0 ? parseLong : 0L, str5, str4, vf, packageName, str7, i4, i2, str6, str8, str9);
                    }
                    if ("high".equals(string2)) {
                        if (!"normal".equals(string2)) {
                            objArr = 0;
                        }
                        objArr = 2;
                    } else {
                        objArr = 1;
                    }
                    if (objArr == 2) {
                    }
                    int i42 = i3;
                    string3 = extras.getString("google.message_id");
                    if (string3 == null) {
                    }
                    if (string3 != null) {
                    }
                    string4 = extras.getString("from");
                    if (string4 != null) {
                        str3 = string4;
                    }
                    if (str3 != null) {
                    }
                    String string52 = extras.getString("collapse_key");
                    if (string52 != null) {
                    }
                    String string62 = extras.getString("google.c.a.m_l");
                    if (string62 != null) {
                    }
                    String string72 = extras.getString("google.c.a.c_l");
                    if (string72 != null) {
                    }
                    if (extras.containsKey("google.c.sender.id")) {
                    }
                    C0493Sq d42 = C0493Sq.d();
                    d42.a();
                    C3864pr c3864pr2 = d42.c;
                    str = c3864pr2.e;
                    if (str != null) {
                    }
                    d42.a();
                    str2 = c3864pr2.b;
                    if (str2.startsWith("1:")) {
                    }
                    xf = new XF(parseLong > 0 ? parseLong : 0L, str5, str4, vf, packageName, str7, i42, i2, str6, str8, str9);
                }
                i2 = parseInt;
                string = extras.getString("google.to");
                if (TextUtils.isEmpty(string)) {
                }
                String str42 = string;
                C0493Sq d32 = C0493Sq.d();
                d32.a();
                String packageName2 = d32.a.getPackageName();
                VF vf2 = !C2835cv.D(extras) ? VF.DISPLAY_NOTIFICATION : VF.DATA_MESSAGE;
                string2 = extras.getString("google.delivered_priority");
                if (string2 == null) {
                }
                if ("high".equals(string2)) {
                }
                if (objArr == 2) {
                }
                int i422 = i3;
                string3 = extras.getString("google.message_id");
                if (string3 == null) {
                }
                if (string3 != null) {
                }
                string4 = extras.getString("from");
                if (string4 != null) {
                }
                if (str3 != null) {
                }
                String string522 = extras.getString("collapse_key");
                if (string522 != null) {
                }
                String string622 = extras.getString("google.c.a.m_l");
                if (string622 != null) {
                }
                String string722 = extras.getString("google.c.a.c_l");
                if (string722 != null) {
                }
                if (extras.containsKey("google.c.sender.id")) {
                }
                C0493Sq d422 = C0493Sq.d();
                d422.a();
                C3864pr c3864pr22 = d422.c;
                str = c3864pr22.e;
                if (str != null) {
                }
                d422.a();
                str2 = c3864pr22.b;
                if (str2.startsWith("1:")) {
                }
                xf = new XF(parseLong > 0 ? parseLong : 0L, str5, str42, vf2, packageName2, str7, i422, i2, str6, str8, str9);
            }
            if (xf == null) {
                return;
            }
            try {
                ((C3124gY) interfaceC3044fY).a("FCM_CLIENT_EVENT_LOGGING", new C3703no("proto"), new C4525yA(13)).m(new R8(new YF(xf), EnumC3191hL.a, new C3496l9(Integer.valueOf(intent.getIntExtra("google.product_id", 111881503)))), new CP(15));
            } catch (RuntimeException e8) {
                Log.w("FirebaseMessaging", "Failed to send big query analytics payload.", e8);
            }
        }
    }

    public static void E(Bundle bundle, String str) {
        try {
            C0493Sq.d();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("google.c.a.c_id");
            if (string != null) {
                bundle2.putString("_nmid", string);
            }
            String string2 = bundle.getString("google.c.a.c_l");
            if (string2 != null) {
                bundle2.putString("_nmn", string2);
            }
            String string3 = bundle.getString("google.c.a.m_l");
            if (!TextUtils.isEmpty(string3)) {
                bundle2.putString("label", string3);
            }
            String string4 = bundle.getString("google.c.a.m_c");
            if (!TextUtils.isEmpty(string4)) {
                bundle2.putString("message_channel", string4);
            }
            String string5 = bundle.getString("from");
            if (string5 == null || !string5.startsWith("/topics/")) {
                string5 = null;
            }
            if (string5 != null) {
                bundle2.putString("_nt", string5);
            }
            String string6 = bundle.getString("google.c.a.ts");
            if (string6 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(string6));
                } catch (NumberFormatException e2) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e2);
                }
            }
            String string7 = bundle.containsKey("google.c.a.udt") ? bundle.getString("google.c.a.udt") : null;
            if (string7 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(string7));
                } catch (NumberFormatException e3) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e3);
                }
            }
            String str2 = C2835cv.D(bundle) ? "display" : "data";
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", str2);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            X3 x3 = (X3) C0493Sq.d().b(X3.class);
            if (x3 != null) {
                ((Y3) x3).a(AppMeasurement.FCM_ORIGIN, str, bundle2);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    public static MappedByteBuffer F(Context context, Uri uri) {
        ParcelFileDescriptor openFileDescriptor;
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r", null);
        } catch (IOException unused) {
        }
        if (openFileDescriptor == null) {
            if (openFileDescriptor != null) {
                openFileDescriptor.close();
                return null;
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
        } finally {
        }
    }

    public static TypedArray G(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        g(context, attributeSet, i2, i3);
        i(context, attributeSet, iArr, i2, i3, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
    }

    public static AbstractC4266uz H(C0295Kz c0295Kz) {
        int i2 = c0295Kz.o;
        if (i2 == 2) {
            c0295Kz.o = 1;
        }
        try {
            try {
                return Ke0.C(c0295Kz);
            } finally {
                c0295Kz.F(i2);
            }
        } catch (OutOfMemoryError | StackOverflowError e2) {
            throw new C0165Fz("Failed parsing JSON source: " + c0295Kz + " to Json", e2);
        }
    }

    public static AbstractC4266uz I(String str) {
        try {
            try {
                try {
                    C0295Kz c0295Kz = new C0295Kz(new StringReader(str));
                    AbstractC4266uz H = H(c0295Kz);
                    H.getClass();
                    if (!(H instanceof C0113Dz) && c0295Kz.C() != 10) {
                        throw new C0320Lz("Did not consume the entire document.");
                    }
                    return H;
                } catch (NumberFormatException e2) {
                    e = e2;
                    throw new C0320Lz(e);
                }
            } catch (IOException e3) {
                throw new C4661zz(e3);
            }
        } catch (LD | NumberFormatException e4) {
            e = e4;
        }
    }

    public static Task L(Task task, Task task2) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.getToken());
        C3061fi c3061fi = new C3061fi(taskCompletionSource, new AtomicBoolean(false), cancellationTokenSource, 0);
        ExecutorC3964r6 executorC3964r6 = b;
        task.continueWithTask(executorC3964r6, c3061fi);
        task2.continueWithTask(executorC3964r6, c3061fi);
        return taskCompletionSource.getTask();
    }

    public static final byte[] M(InputStream inputStream) {
        AbstractC3634my.g(inputStream, "<this>");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE, inputStream.available()));
        o(inputStream, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AbstractC3634my.f(byteArray, "toByteArray(...)");
        return byteArray;
    }

    public static int[] N(ByteArrayInputStream byteArrayInputStream, int i2) {
        int[] iArr = new int[i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
            iArr[i4] = i3;
        }
        return iArr;
    }

    public static C3542ll[] O(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, C3542ll[] c3542llArr) {
        byte[] bArr3 = AbstractC0538Uj.n;
        if (!Arrays.equals(bArr, bArr3)) {
            if (!Arrays.equals(bArr, AbstractC0538Uj.o)) {
                throw new IllegalStateException("Unsupported meta version");
            }
            int L = (int) AbstractC0538Uj.L(fileInputStream, 2);
            byte[] K = AbstractC0538Uj.K(fileInputStream, (int) AbstractC0538Uj.L(fileInputStream, 4), (int) AbstractC0538Uj.L(fileInputStream, 4));
            if (fileInputStream.read() > 0) {
                throw new IllegalStateException("Content found after the end of file");
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(K);
            try {
                C3542ll[] Q = Q(byteArrayInputStream, bArr2, L, c3542llArr);
                byteArrayInputStream.close();
                return Q;
            } catch (Throwable th) {
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (Arrays.equals(AbstractC0538Uj.i, bArr2)) {
            throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
        }
        if (!Arrays.equals(bArr, bArr3)) {
            throw new IllegalStateException("Unsupported meta version");
        }
        int L2 = (int) AbstractC0538Uj.L(fileInputStream, 1);
        byte[] K2 = AbstractC0538Uj.K(fileInputStream, (int) AbstractC0538Uj.L(fileInputStream, 4), (int) AbstractC0538Uj.L(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(K2);
        try {
            C3542ll[] P = P(byteArrayInputStream2, L2, c3542llArr);
            byteArrayInputStream2.close();
            return P;
        } catch (Throwable th3) {
            try {
                byteArrayInputStream2.close();
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
            }
            throw th3;
        }
    }

    public static C3542ll[] P(ByteArrayInputStream byteArrayInputStream, int i2, C3542ll[] c3542llArr) {
        if (byteArrayInputStream.available() == 0) {
            return new C3542ll[0];
        }
        if (i2 != c3542llArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i2];
        int[] iArr = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int L = (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
            iArr[i3] = (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
            strArr[i3] = new String(AbstractC0538Uj.J(byteArrayInputStream, L), StandardCharsets.UTF_8);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            C3542ll c3542ll = c3542llArr[i4];
            if (!c3542ll.b.equals(strArr[i4])) {
                throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
            }
            int i5 = iArr[i4];
            c3542ll.e = i5;
            c3542ll.h = N(byteArrayInputStream, i5);
        }
        return c3542llArr;
    }

    public static C3542ll[] Q(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i2, C3542ll[] c3542llArr) {
        if (byteArrayInputStream.available() == 0) {
            return new C3542ll[0];
        }
        if (i2 != c3542llArr.length) {
            throw new IllegalStateException("Mismatched number of dex files found in metadata");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            AbstractC0538Uj.L(byteArrayInputStream, 2);
            String str = new String(AbstractC0538Uj.J(byteArrayInputStream, (int) AbstractC0538Uj.L(byteArrayInputStream, 2)), StandardCharsets.UTF_8);
            long L = AbstractC0538Uj.L(byteArrayInputStream, 4);
            int L2 = (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
            C3542ll c3542ll = null;
            if (c3542llArr.length > 0) {
                int indexOf = str.indexOf("!");
                if (indexOf < 0) {
                    indexOf = str.indexOf(":");
                }
                String substring = indexOf > 0 ? str.substring(indexOf + 1) : str;
                int i4 = 0;
                while (true) {
                    if (i4 >= c3542llArr.length) {
                        break;
                    }
                    if (c3542llArr[i4].b.equals(substring)) {
                        c3542ll = c3542llArr[i4];
                        break;
                    }
                    i4++;
                }
            }
            if (c3542ll == null) {
                throw new IllegalStateException("Missing profile key: ".concat(str));
            }
            c3542ll.d = L;
            int[] N = N(byteArrayInputStream, L2);
            if (Arrays.equals(bArr, AbstractC0538Uj.m)) {
                c3542ll.e = L2;
                c3542ll.h = N;
            }
        }
        return c3542llArr;
    }

    public static C3542ll[] R(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (!Arrays.equals(bArr, AbstractC0538Uj.j)) {
            throw new IllegalStateException("Unsupported version");
        }
        int L = (int) AbstractC0538Uj.L(fileInputStream, 1);
        byte[] K = AbstractC0538Uj.K(fileInputStream, (int) AbstractC0538Uj.L(fileInputStream, 4), (int) AbstractC0538Uj.L(fileInputStream, 4));
        if (fileInputStream.read() > 0) {
            throw new IllegalStateException("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(K);
        try {
            C3542ll[] T = T(byteArrayInputStream, str, L);
            byteArrayInputStream.close();
            return T;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static final String S(InputStreamReader inputStreamReader) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE];
        int read = inputStreamReader.read(cArr);
        while (read >= 0) {
            stringWriter.write(cArr, 0, read);
            read = inputStreamReader.read(cArr);
        }
        String stringWriter2 = stringWriter.toString();
        AbstractC3634my.f(stringWriter2, "toString(...)");
        return stringWriter2;
    }

    public static C3542ll[] T(ByteArrayInputStream byteArrayInputStream, String str, int i2) {
        TreeMap treeMap;
        if (byteArrayInputStream.available() == 0) {
            return new C3542ll[0];
        }
        C3542ll[] c3542llArr = new C3542ll[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int L = (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
            int L2 = (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
            c3542llArr[i3] = new C3542ll(str, new String(AbstractC0538Uj.J(byteArrayInputStream, L), StandardCharsets.UTF_8), AbstractC0538Uj.L(byteArrayInputStream, 4), L2, (int) AbstractC0538Uj.L(byteArrayInputStream, 4), (int) AbstractC0538Uj.L(byteArrayInputStream, 4), new int[L2], new TreeMap());
        }
        for (int i4 = 0; i4 < i2; i4++) {
            C3542ll c3542ll = c3542llArr[i4];
            int available = byteArrayInputStream.available() - c3542ll.f;
            int i5 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = c3542ll.i;
                if (available2 <= available) {
                    break;
                }
                i5 += (int) AbstractC0538Uj.L(byteArrayInputStream, 2);
                treeMap.put(Integer.valueOf(i5), 1);
                for (int L3 = (int) AbstractC0538Uj.L(byteArrayInputStream, 2); L3 > 0; L3--) {
                    AbstractC0538Uj.L(byteArrayInputStream, 2);
                    int L4 = (int) AbstractC0538Uj.L(byteArrayInputStream, 1);
                    if (L4 != 6 && L4 != 7) {
                        while (L4 > 0) {
                            AbstractC0538Uj.L(byteArrayInputStream, 1);
                            for (int L5 = (int) AbstractC0538Uj.L(byteArrayInputStream, 1); L5 > 0; L5--) {
                                AbstractC0538Uj.L(byteArrayInputStream, 2);
                            }
                            L4--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() != available) {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
            c3542ll.h = N(byteArrayInputStream, c3542ll.e);
            int i6 = c3542ll.g;
            BitSet valueOf = BitSet.valueOf(AbstractC0538Uj.J(byteArrayInputStream, (((i6 * 2) + 7) & (-8)) / 8));
            for (int i7 = 0; i7 < i6; i7++) {
                int i8 = valueOf.get(i7) ? 2 : 0;
                if (valueOf.get(i7 + i6)) {
                    i8 |= 4;
                }
                if (i8 != 0) {
                    Integer num = (Integer) treeMap.get(Integer.valueOf(i7));
                    if (num == null) {
                        num = 0;
                    }
                    treeMap.put(Integer.valueOf(i7), Integer.valueOf(i8 | num.intValue()));
                }
            }
        }
        return c3542llArr;
    }

    public static void U(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor());
        Drawable mutate = drawable.mutate();
        mutate.setTintList(ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(mutate);
    }

    public static final void V(C0582Wb c0582Wb, InterfaceC0198Hg interfaceC0198Hg, boolean z) {
        Object obj = C0582Wb.g.get(c0582Wb);
        Throwable f2 = c0582Wb.f(obj);
        Object j2 = f2 != null ? W80.j(f2) : c0582Wb.g(obj);
        if (!z) {
            interfaceC0198Hg.resumeWith(j2);
            return;
        }
        AbstractC3634my.e(interfaceC0198Hg, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>");
        C4568yl c4568yl = (C4568yl) interfaceC0198Hg;
        AbstractC0224Ig abstractC0224Ig = c4568yl.e;
        InterfaceC0613Xg context = abstractC0224Ig.getContext();
        Object h0 = AbstractC0538Uj.h0(context, c4568yl.g);
        C4076sZ S = h0 != AbstractC0538Uj.p ? AbstractC0325Me.S(abstractC0224Ig, context, h0) : null;
        try {
            abstractC0224Ig.resumeWith(j2);
            if (S == null || S.U()) {
                AbstractC0538Uj.N(context, h0);
            }
        } catch (Throwable th) {
            if (S == null || S.U()) {
                AbstractC0538Uj.N(context, h0);
            }
            throw th;
        }
    }

    public static List W(List list) {
        return list instanceof AbstractC0525Tw ? ((AbstractC0525Tw) list).u() : list instanceof LC ? ((LC) list).a : list instanceof RandomAccess ? new JC(list) : new LC(list);
    }

    public static void Z(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = checkableImageButton.hasOnClickListeners();
        boolean z = onLongClickListener != null;
        boolean z2 = hasOnClickListeners || z;
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(hasOnClickListeners);
        checkableImageButton.setPressable(hasOnClickListeners);
        checkableImageButton.setLongClickable(z);
        checkableImageButton.setImportantForAccessibility(z2 ? 1 : 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(PW pw, InterfaceC3391ju interfaceC3391ju, Throwable th, AbstractC0224Ig abstractC0224Ig) {
        C0546Ur c0546Ur;
        int i2;
        try {
            if (abstractC0224Ig instanceof C0546Ur) {
                c0546Ur = (C0546Ur) abstractC0224Ig;
                int i3 = c0546Ur.v;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    c0546Ur.v = i3 - Integer.MIN_VALUE;
                    Object obj = c0546Ur.u;
                    Object obj2 = EnumC3299ih.a;
                    i2 = c0546Ur.v;
                    if (i2 != 0) {
                        W80.U(obj);
                        c0546Ur.t = th;
                        c0546Ur.v = 1;
                        if (interfaceC3391ju.invoke(pw, th, c0546Ur) == obj2) {
                            return obj2;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        th = c0546Ur.t;
                        W80.U(obj);
                    }
                    return C4471xZ.a;
                }
            }
            if (i2 != 0) {
            }
            return C4471xZ.a;
        } catch (Throwable th2) {
            if (th != null && th != th2) {
                XE.b(th2, th);
            }
            throw th2;
        }
        c0546Ur = new C0546Ur(abstractC0224Ig);
        Object obj3 = c0546Ur.u;
        Object obj22 = EnumC3299ih.a;
        i2 = c0546Ur.v;
    }

    public static boolean a0(Intent intent) {
        Bundle extras;
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return false;
        }
        return "1".equals(extras.getString("google.c.a.e"));
    }

    public static void b(StringBuilder sb, Object obj, InterfaceC0522Tt interfaceC0522Tt) {
        if (interfaceC0522Tt != null) {
            sb.append((CharSequence) interfaceC0522Tt.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            sb.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            sb.append(((Character) obj).charValue());
        } else {
            sb.append((CharSequence) obj.toString());
        }
    }

    /* JADX WARN: Finally extract failed */
    public static boolean b0(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, C3542ll[] c3542llArr) {
        long j2;
        ArrayList arrayList;
        int length;
        byte[] bArr2 = AbstractC0538Uj.i;
        int i2 = 0;
        if (!Arrays.equals(bArr, bArr2)) {
            byte[] bArr3 = AbstractC0538Uj.j;
            if (Arrays.equals(bArr, bArr3)) {
                byte[] r = r(c3542llArr, bArr3);
                AbstractC0538Uj.k0(byteArrayOutputStream, c3542llArr.length, 1);
                AbstractC0538Uj.k0(byteArrayOutputStream, r.length, 4);
                byte[] k2 = AbstractC0538Uj.k(r);
                AbstractC0538Uj.k0(byteArrayOutputStream, k2.length, 4);
                byteArrayOutputStream.write(k2);
                return true;
            }
            byte[] bArr4 = AbstractC0538Uj.l;
            if (Arrays.equals(bArr, bArr4)) {
                AbstractC0538Uj.k0(byteArrayOutputStream, c3542llArr.length, 1);
                for (C3542ll c3542ll : c3542llArr) {
                    int size = c3542ll.i.size() * 4;
                    String w = w(bArr4, c3542ll.a, c3542ll.b);
                    Charset charset = StandardCharsets.UTF_8;
                    AbstractC0538Uj.l0(byteArrayOutputStream, w.getBytes(charset).length);
                    AbstractC0538Uj.l0(byteArrayOutputStream, c3542ll.h.length);
                    AbstractC0538Uj.k0(byteArrayOutputStream, size, 4);
                    AbstractC0538Uj.k0(byteArrayOutputStream, c3542ll.c, 4);
                    byteArrayOutputStream.write(w.getBytes(charset));
                    Iterator it = c3542ll.i.keySet().iterator();
                    while (it.hasNext()) {
                        AbstractC0538Uj.l0(byteArrayOutputStream, ((Integer) it.next()).intValue());
                        AbstractC0538Uj.l0(byteArrayOutputStream, 0);
                    }
                    for (int i3 : c3542ll.h) {
                        AbstractC0538Uj.l0(byteArrayOutputStream, i3);
                    }
                }
                return true;
            }
            byte[] bArr5 = AbstractC0538Uj.k;
            if (Arrays.equals(bArr, bArr5)) {
                byte[] r2 = r(c3542llArr, bArr5);
                AbstractC0538Uj.k0(byteArrayOutputStream, c3542llArr.length, 1);
                AbstractC0538Uj.k0(byteArrayOutputStream, r2.length, 4);
                byte[] k3 = AbstractC0538Uj.k(r2);
                AbstractC0538Uj.k0(byteArrayOutputStream, k3.length, 4);
                byteArrayOutputStream.write(k3);
                return true;
            }
            byte[] bArr6 = AbstractC0538Uj.m;
            if (!Arrays.equals(bArr, bArr6)) {
                return false;
            }
            AbstractC0538Uj.l0(byteArrayOutputStream, c3542llArr.length);
            for (C3542ll c3542ll2 : c3542llArr) {
                String w2 = w(bArr6, c3542ll2.a, c3542ll2.b);
                Charset charset2 = StandardCharsets.UTF_8;
                AbstractC0538Uj.l0(byteArrayOutputStream, w2.getBytes(charset2).length);
                TreeMap treeMap = c3542ll2.i;
                AbstractC0538Uj.l0(byteArrayOutputStream, treeMap.size());
                AbstractC0538Uj.l0(byteArrayOutputStream, c3542ll2.h.length);
                AbstractC0538Uj.k0(byteArrayOutputStream, c3542ll2.c, 4);
                byteArrayOutputStream.write(w2.getBytes(charset2));
                Iterator it2 = treeMap.keySet().iterator();
                while (it2.hasNext()) {
                    AbstractC0538Uj.l0(byteArrayOutputStream, ((Integer) it2.next()).intValue());
                }
                for (int i4 : c3542ll2.h) {
                    AbstractC0538Uj.l0(byteArrayOutputStream, i4);
                }
            }
            return true;
        }
        ArrayList arrayList2 = new ArrayList(3);
        ArrayList arrayList3 = new ArrayList(3);
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        try {
            AbstractC0538Uj.l0(byteArrayOutputStream2, c3542llArr.length);
            int i5 = 2;
            int i6 = 2;
            for (C3542ll c3542ll3 : c3542llArr) {
                AbstractC0538Uj.k0(byteArrayOutputStream2, c3542ll3.c, 4);
                AbstractC0538Uj.k0(byteArrayOutputStream2, c3542ll3.d, 4);
                AbstractC0538Uj.k0(byteArrayOutputStream2, c3542ll3.g, 4);
                String w3 = w(bArr2, c3542ll3.a, c3542ll3.b);
                Charset charset3 = StandardCharsets.UTF_8;
                int length2 = w3.getBytes(charset3).length;
                AbstractC0538Uj.l0(byteArrayOutputStream2, length2);
                i6 = i6 + 14 + length2;
                byteArrayOutputStream2.write(w3.getBytes(charset3));
            }
            byte[] byteArray = byteArrayOutputStream2.toByteArray();
            if (i6 != byteArray.length) {
                throw new IllegalStateException("Expected size " + i6 + ", does not match actual size " + byteArray.length);
            }
            C3806p50 c3806p50 = new C3806p50(1, byteArray, false);
            byteArrayOutputStream2.close();
            arrayList2.add(c3806p50);
            ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i7 = 0;
            int i8 = 0;
            while (i7 < c3542llArr.length) {
                try {
                    C3542ll c3542ll4 = c3542llArr[i7];
                    AbstractC0538Uj.l0(byteArrayOutputStream3, i7);
                    AbstractC0538Uj.l0(byteArrayOutputStream3, c3542ll4.e);
                    i8 = i8 + 4 + (c3542ll4.e * i5);
                    int[] iArr = c3542ll4.h;
                    int length3 = iArr.length;
                    int i9 = i2;
                    int i10 = i5;
                    int i11 = i9;
                    while (i11 < length3) {
                        int i12 = iArr[i11];
                        AbstractC0538Uj.l0(byteArrayOutputStream3, i12 - i9);
                        i11++;
                        i9 = i12;
                    }
                    i7++;
                    i5 = i10;
                    i2 = 0;
                } catch (Throwable th) {
                }
            }
            byte[] byteArray2 = byteArrayOutputStream3.toByteArray();
            if (i8 != byteArray2.length) {
                throw new IllegalStateException("Expected size " + i8 + ", does not match actual size " + byteArray2.length);
            }
            C3806p50 c3806p502 = new C3806p50(3, byteArray2, true);
            byteArrayOutputStream3.close();
            arrayList2.add(c3806p502);
            byteArrayOutputStream3 = new ByteArrayOutputStream();
            int i13 = 0;
            int i14 = 0;
            while (i13 < c3542llArr.length) {
                try {
                    C3542ll c3542ll5 = c3542llArr[i13];
                    Iterator it3 = c3542ll5.i.entrySet().iterator();
                    int i15 = 0;
                    while (it3.hasNext()) {
                        i15 |= ((Integer) ((Map.Entry) it3.next()).getValue()).intValue();
                    }
                    ByteArrayOutputStream byteArrayOutputStream4 = new ByteArrayOutputStream();
                    try {
                        h0(byteArrayOutputStream4, i15, c3542ll5);
                        byte[] byteArray3 = byteArrayOutputStream4.toByteArray();
                        byteArrayOutputStream4.close();
                        byteArrayOutputStream4 = new ByteArrayOutputStream();
                        try {
                            i0(byteArrayOutputStream4, c3542ll5);
                            byte[] byteArray4 = byteArrayOutputStream4.toByteArray();
                            byteArrayOutputStream4.close();
                            AbstractC0538Uj.l0(byteArrayOutputStream3, i13);
                            int length4 = byteArray3.length + 2 + byteArray4.length;
                            int i16 = i14 + 6;
                            ArrayList arrayList4 = arrayList3;
                            AbstractC0538Uj.k0(byteArrayOutputStream3, length4, 4);
                            AbstractC0538Uj.l0(byteArrayOutputStream3, i15);
                            byteArrayOutputStream3.write(byteArray3);
                            byteArrayOutputStream3.write(byteArray4);
                            i14 = i16 + length4;
                            i13++;
                            arrayList3 = arrayList4;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                    try {
                        byteArrayOutputStream3.close();
                        throw th;
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
            }
            ArrayList arrayList5 = arrayList3;
            byte[] byteArray5 = byteArrayOutputStream3.toByteArray();
            if (i14 != byteArray5.length) {
                throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray5.length);
            }
            C3806p50 c3806p503 = new C3806p50(4, byteArray5, true);
            byteArrayOutputStream3.close();
            arrayList2.add(c3806p503);
            long j3 = 4;
            long size2 = j3 + j3 + 4 + (arrayList2.size() * 16);
            AbstractC0538Uj.k0(byteArrayOutputStream, arrayList2.size(), 4);
            int i17 = 0;
            while (i17 < arrayList2.size()) {
                C3806p50 c3806p504 = (C3806p50) arrayList2.get(i17);
                int i18 = c3806p504.a;
                if (i18 == 1) {
                    j2 = 0;
                } else if (i18 == 2) {
                    j2 = 1;
                } else if (i18 == 3) {
                    j2 = 2;
                } else if (i18 == 4) {
                    j2 = 3;
                } else {
                    if (i18 != 5) {
                        throw null;
                    }
                    j2 = 4;
                }
                AbstractC0538Uj.k0(byteArrayOutputStream, j2, 4);
                AbstractC0538Uj.k0(byteArrayOutputStream, size2, 4);
                byte[] bArr7 = c3806p504.b;
                if (c3806p504.c) {
                    long length5 = bArr7.length;
                    byte[] k4 = AbstractC0538Uj.k(bArr7);
                    arrayList = arrayList5;
                    arrayList.add(k4);
                    AbstractC0538Uj.k0(byteArrayOutputStream, k4.length, 4);
                    AbstractC0538Uj.k0(byteArrayOutputStream, length5, 4);
                    length = k4.length;
                } else {
                    arrayList = arrayList5;
                    arrayList.add(bArr7);
                    AbstractC0538Uj.k0(byteArrayOutputStream, bArr7.length, 4);
                    AbstractC0538Uj.k0(byteArrayOutputStream, 0L, 4);
                    length = bArr7.length;
                }
                size2 += length;
                i17++;
                arrayList5 = arrayList;
            }
            ArrayList arrayList6 = arrayList5;
            for (int i19 = 0; i19 < arrayList6.size(); i19++) {
                byteArrayOutputStream.write((byte[]) arrayList6.get(i19));
            }
            return true;
        } catch (Throwable th3) {
            try {
                byteArrayOutputStream2.close();
                throw th3;
            } catch (Throwable th4) {
                th3.addSuppressed(th4);
                throw th3;
            }
        }
    }

    public static void c(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                drawable.setTintList(colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
                drawable.setTintList(ColorStateList.valueOf(colorStateList.getColorForState(copyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                drawable.setTintMode(mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static final Object c0(Object obj) {
        InterfaceC3236hx interfaceC3236hx;
        C3314ix c3314ix = obj instanceof C3314ix ? (C3314ix) obj : null;
        return (c3314ix == null || (interfaceC3236hx = c3314ix.a) == null) ? obj : interfaceC3236hx;
    }

    public static void d0(String str) {
        Log.v("RootBeer", z() + String.valueOf(str));
    }

    public static void f0(ByteArrayOutputStream byteArrayOutputStream, C3542ll c3542ll) {
        i0(byteArrayOutputStream, c3542ll);
        int[] iArr = c3542ll.h;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = iArr[i2];
            AbstractC0538Uj.l0(byteArrayOutputStream, i4 - i3);
            i2++;
            i3 = i4;
        }
        int i5 = c3542ll.g;
        byte[] bArr = new byte[(((i5 * 2) + 7) & (-8)) / 8];
        for (Map.Entry entry : c3542ll.i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            if ((intValue2 & 2) != 0) {
                int i6 = intValue / 8;
                bArr[i6] = (byte) (bArr[i6] | (1 << (intValue % 8)));
            }
            if ((intValue2 & 4) != 0) {
                int i7 = intValue + i5;
                int i8 = i7 / 8;
                bArr[i8] = (byte) ((1 << (i7 % 8)) | bArr[i8]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void g(Context context, AttributeSet attributeSet, int i2, int i3) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.G, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(1, false);
        obtainStyledAttributes.recycle();
        if (z) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                j(context, m, "Theme.MaterialComponents");
            }
        }
        j(context, l, "Theme.AppCompat");
    }

    public static void g0(ByteArrayOutputStream byteArrayOutputStream, C3542ll c3542ll, String str) {
        Charset charset = StandardCharsets.UTF_8;
        AbstractC0538Uj.l0(byteArrayOutputStream, str.getBytes(charset).length);
        AbstractC0538Uj.l0(byteArrayOutputStream, c3542ll.e);
        AbstractC0538Uj.k0(byteArrayOutputStream, c3542ll.f, 4);
        AbstractC0538Uj.k0(byteArrayOutputStream, c3542ll.c, 4);
        AbstractC0538Uj.k0(byteArrayOutputStream, c3542ll.g, 4);
        byteArrayOutputStream.write(str.getBytes(charset));
    }

    public static void h(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void h0(ByteArrayOutputStream byteArrayOutputStream, int i2, C3542ll c3542ll) {
        int bitCount = Integer.bitCount(i2 & (-2));
        int i3 = c3542ll.g;
        byte[] bArr = new byte[(((bitCount * i3) + 7) & (-8)) / 8];
        for (Map.Entry entry : c3542ll.i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i4 = 0;
            for (int i5 = 1; i5 <= 4; i5 <<= 1) {
                if (i5 != 1 && (i5 & i2) != 0) {
                    if ((i5 & intValue2) == i5) {
                        int i6 = (i4 * i3) + intValue;
                        int i7 = i6 / 8;
                        bArr[i7] = (byte) ((1 << (i6 % 8)) | bArr[i7]);
                    }
                    i4++;
                }
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        if (r0.getResourceId(0, -1) != (-1)) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void i(Context context, AttributeSet attributeSet, int[] iArr, int i2, int i3, int... iArr2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, FM.G, i2, i3);
        boolean z = false;
        if (!obtainStyledAttributes.getBoolean(2, false)) {
            obtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, i3);
            for (int i4 : iArr2) {
                if (obtainStyledAttributes2.getResourceId(i4, -1) == -1) {
                    obtainStyledAttributes2.recycle();
                    break;
                }
            }
            obtainStyledAttributes2.recycle();
            z = true;
            obtainStyledAttributes.recycle();
            if (!z) {
                throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
            }
        }
    }

    public static void i0(ByteArrayOutputStream byteArrayOutputStream, C3542ll c3542ll) {
        int i2 = 0;
        for (Map.Entry entry : c3542ll.i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                AbstractC0538Uj.l0(byteArrayOutputStream, intValue - i2);
                AbstractC0538Uj.l0(byteArrayOutputStream, 0);
                i2 = intValue;
            }
        }
    }

    public static void j(Context context, int[] iArr, String str) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (!obtainStyledAttributes.hasValue(i2)) {
                obtainStyledAttributes.recycle();
                throw new IllegalArgumentException(W50.D("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        obtainStyledAttributes.recycle();
    }

    public static int k(C3907qN c3907qN, AbstractC0153Fn abstractC0153Fn, View view, View view2, AbstractC2953eN abstractC2953eN, boolean z) {
        if (abstractC2953eN.v() == 0 || c3907qN.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(AbstractC2953eN.H(view) - AbstractC2953eN.H(view2)) + 1;
        }
        return Math.min(abstractC0153Fn.l(), abstractC0153Fn.b(view2) - abstractC0153Fn.e(view));
    }

    public static int l(C3907qN c3907qN, AbstractC0153Fn abstractC0153Fn, View view, View view2, AbstractC2953eN abstractC2953eN, boolean z, boolean z2) {
        if (abstractC2953eN.v() == 0 || c3907qN.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (c3907qN.b() - Math.max(AbstractC2953eN.H(view), AbstractC2953eN.H(view2))) - 1) : Math.max(0, Math.min(AbstractC2953eN.H(view), AbstractC2953eN.H(view2)));
        if (z) {
            return Math.round((max * (Math.abs(abstractC0153Fn.b(view2) - abstractC0153Fn.e(view)) / (Math.abs(AbstractC2953eN.H(view) - AbstractC2953eN.H(view2)) + 1))) + (abstractC0153Fn.k() - abstractC0153Fn.e(view)));
        }
        return max;
    }

    public static int m(C3907qN c3907qN, AbstractC0153Fn abstractC0153Fn, View view, View view2, AbstractC2953eN abstractC2953eN, boolean z) {
        if (abstractC2953eN.v() == 0 || c3907qN.b() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c3907qN.b();
        }
        return (int) (((abstractC0153Fn.b(view2) - abstractC0153Fn.e(view)) / (Math.abs(AbstractC2953eN.H(view) - AbstractC2953eN.H(view2)) + 1)) * c3907qN.b());
    }

    public static ImageView.ScaleType n(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 5 ? i2 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    public static void o(InputStream inputStream, ByteArrayOutputStream byteArrayOutputStream) {
        AbstractC3634my.g(inputStream, "<this>");
        byte[] bArr = new byte[JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE];
        int read = inputStream.read(bArr);
        while (read >= 0) {
            byteArrayOutputStream.write(bArr, 0, read);
            read = inputStream.read(bArr);
        }
    }

    public static boolean p(File file, Resources resources, int i2) {
        InputStream inputStream;
        try {
            inputStream = resources.openRawResource(i2);
        } catch (Throwable th) {
            th = th;
            inputStream = null;
        }
        try {
            boolean q2 = q(file, inputStream);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused) {
                }
            }
            return q2;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static boolean q(File file, InputStream inputStream) {
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
            byte[] bArr = new byte[UserVerificationMethods.USER_VERIFY_ALL];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    try {
                        break;
                    } catch (IOException unused) {
                    }
                }
            }
            fileOutputStream.close();
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return true;
        } catch (IOException e3) {
            e = e3;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused2) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (fileOutputStream2 != null) {
                try {
                    fileOutputStream2.close();
                } catch (IOException unused3) {
                }
            }
            StrictMode.setThreadPolicy(allowThreadDiskWrites);
            throw th;
        }
    }

    public static byte[] r(C3542ll[] c3542llArr, byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        for (C3542ll c3542ll : c3542llArr) {
            i3 += ((((c3542ll.g * 2) + 7) & (-8)) / 8) + (c3542ll.e * 2) + w(bArr, c3542ll.a, c3542ll.b).getBytes(StandardCharsets.UTF_8).length + 16 + c3542ll.f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i3);
        if (Arrays.equals(bArr, AbstractC0538Uj.k)) {
            int length = c3542llArr.length;
            while (i2 < length) {
                C3542ll c3542ll2 = c3542llArr[i2];
                g0(byteArrayOutputStream, c3542ll2, w(bArr, c3542ll2.a, c3542ll2.b));
                f0(byteArrayOutputStream, c3542ll2);
                i2++;
            }
        } else {
            for (C3542ll c3542ll3 : c3542llArr) {
                g0(byteArrayOutputStream, c3542ll3, w(bArr, c3542ll3.a, c3542ll3.b));
            }
            int length2 = c3542llArr.length;
            while (i2 < length2) {
                f0(byteArrayOutputStream, c3542llArr[i2]);
                i2++;
            }
        }
        if (byteArrayOutputStream.size() == i3) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i3);
    }

    public static boolean s(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : listFiles) {
            z = s(file2) && z;
        }
        return z;
    }

    public static boolean t() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            C0493Sq.d();
            C0493Sq d2 = C0493Sq.d();
            d2.a();
            Context context = d2.a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), UserVerificationMethods.USER_VERIFY_PATTERN)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    public static void u(Serializable serializable) {
        Log.e("RootBeer", z() + String.valueOf(serializable));
        Log.e("QLog", z() + String.valueOf(serializable));
    }

    public static boolean v(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String w(byte[] bArr, String str, String str2) {
        byte[] bArr2 = AbstractC0538Uj.m;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = AbstractC0538Uj.l;
        String str3 = (equals || Arrays.equals(bArr, bArr3)) ? ":" : "!";
        if (str.length() <= 0) {
            if ("!".equals(str3)) {
                return str2.replace(":", "!");
            }
            if (":".equals(str3)) {
                return str2.replace("!", ":");
            }
        } else {
            if (str2.equals("classes.dex")) {
                return str;
            }
            if (str2.contains("!") || str2.contains(":")) {
                if ("!".equals(str3)) {
                    return str2.replace(":", "!");
                }
                if (":".equals(str3)) {
                    return str2.replace("!", ":");
                }
            } else if (!str2.endsWith(".apk")) {
                return W50.q((Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) ? ":" : "!", str2, ZT.m(str));
            }
        }
        return str2;
    }

    public static File y(Context context) {
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

    public static String z() {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        String methodName = stackTrace[2].getMethodName();
        String className = stackTrace[2].getClassName();
        int lineNumber = stackTrace[2].getLineNumber();
        return className.substring(className.lastIndexOf(46) + 1) + ": " + methodName + "() [" + lineNumber + "] - ";
    }

    public abstract boolean B();

    public abstract void J(O o2, O o3);

    public abstract void K(O o2, Thread thread);

    public abstract void X(boolean z);

    public abstract void Y(boolean z);

    public abstract boolean d(Q q2, C4583z c4583z, C4583z c4583z2);

    public abstract boolean e(Q q2, Object obj, Object obj2);

    public abstract TransformationMethod e0(TransformationMethod transformationMethod);

    public abstract boolean f(Q q2, O o2, O o3);

    public abstract InputFilter[] x(InputFilter[] inputFilterArr);
}
