package defpackage;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.credentials.playservices.HiddenActivity;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewStartUpResult;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import dastan.prince.bdfreevpn.R;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.Thread;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import okhttp3.EventListener;
import org.chromium.net.impl.JavaUrlRequestUtils;
import org.chromium.net.impl.VersionSafeCallbacks;
import prince.dastan.vpn.activities.VPNClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: ic, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C3290ic implements InterfaceC4561yf, DI, InterfaceC0245Jb, InterfaceC0150Fk, Continuation, OX, OnSuccessListener, JavaUrlRequestUtils.CheckedRunnable, WV, EventListener.Factory, InterfaceC4428x1, OnCompleteListener, WebViewCompat.WebViewStartUpCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ C3290ic(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // defpackage.InterfaceC0245Jb
    public Object a(C0219Ib c0219Ib) {
        C0202Hk c0202Hk = (C0202Hk) this.b;
        c0202Hk.invokeOnCompletion(new C0535Ug(0, c0219Ib, c0202Hk));
        return "Deferred.asListenableFuture";
    }

    @Override // defpackage.OX
    public Object apply(Object obj) {
        ((C0206Ho) this.b).getClass();
        String e = SR.b.e((RR) obj);
        AbstractC3634my.f(e, "encode(...)");
        EnumC0465Ro enumC0465Ro = EnumC0465Ro.b;
        Log.d("FirebaseSessions", "Session Event Type: SESSION_START");
        byte[] bytes = e.getBytes(AbstractC0738ad.a);
        AbstractC3634my.f(bytes, "getBytes(...)");
        return bytes;
    }

    @Override // defpackage.InterfaceC0150Fk
    public void b(ZL zl) {
        C0043Bh c0043Bh = (C0043Bh) this.b;
        c0043Bh.getClass();
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
        }
        c0043Bh.b.set((C0043Bh) zl.get());
    }

    @Override // defpackage.WV
    public Object c() {
        SQLiteDatabase b;
        Object obj = this.b;
        switch (this.a) {
            case 21:
                TP tp = (TP) ((InterfaceC0299Ld) obj);
                tp.getClass();
                int i = C0376Od.e;
                FR fr = new FR();
                fr.b = null;
                fr.c = new ArrayList();
                fr.d = null;
                fr.a = "";
                HashMap hashMap = new HashMap();
                b = tp.b();
                b.beginTransaction();
                try {
                    C0376Od c0376Od = (C0376Od) TP.m(b.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new C3061fi(tp, hashMap, fr, 4));
                    b.setTransactionSuccessful();
                    return c0376Od;
                } finally {
                }
            case 22:
                TP tp2 = (TP) ((InterfaceC0439Qo) obj);
                long c = tp2.b.c() - tp2.d.d;
                b = tp2.b();
                b.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(c)};
                    Cursor rawQuery = b.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (rawQuery.moveToNext()) {
                        try {
                            tp2.h(rawQuery.getInt(0), EnumC3581mD.MESSAGE_TOO_OLD, rawQuery.getString(1));
                        } catch (Throwable th) {
                            rawQuery.close();
                            throw th;
                        }
                    }
                    rawQuery.close();
                    int delete = b.delete("events", "timestamp_ms < ?", strArr);
                    b.setTransactionSuccessful();
                    b.endTransaction();
                    return Integer.valueOf(delete);
                } finally {
                }
            default:
                TP tp3 = (TP) ((C3319j00) obj).i;
                b = tp3.b();
                b.beginTransaction();
                try {
                    b.compileStatement("DELETE FROM log_event_dropped").execute();
                    b.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + tp3.b.c()).execute();
                    b.setTransactionSuccessful();
                    return null;
                } finally {
                }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(29:74|75|(2:78|76)|79|80|(1:82)(1:161)|(1:84)(1:160)|85|(5:147|(1:149)|150|47d|155)(1:89)|90|(18:94|(1:96)(2:143|(1:145))|(3:98|(1:100)|101)(2:139|(2:141|142))|102|103|104|105|106|107|108|(8:130|131|(1:133)|134|121|122|(2:124|(1:126))|127)|117|(1:119)|120|121|122|(0)|127)|146|(0)(0)|102|103|104|105|106|107|108|(2:110|112)|130|131|(0)|134|121|122|(0)|127) */
    /* JADX WARN: Can't wrap try/catch for region: R(30:3|(3:5|(1:7)(1:177)|8)(1:178)|9|(1:11)(1:176)|12|(1:14)|(1:16)(1:175)|17|(3:171|172|(21:174|33|(1:35)|36|(4:39|(3:41|42|43)(1:45)|44|37)|46|47|48|49|(1:51)(1:164)|52|53|(1:55)|56|57|(1:59)|60|(1:62)|(1:64)(1:162)|65|(2:66|(3:68|(2:70|71)(1:73)|72)(29:74|75|(2:78|76)|79|80|(1:82)(1:161)|(1:84)(1:160)|85|(5:147|(1:149)|150|47d|155)(1:89)|90|(18:94|(1:96)(2:143|(1:145))|(3:98|(1:100)|101)(2:139|(2:141|142))|102|103|104|105|106|107|108|(8:130|131|(1:133)|134|121|122|(2:124|(1:126))|127)|117|(1:119)|120|121|122|(0)|127)|146|(0)(0)|102|103|104|105|106|107|108|(2:110|112)|130|131|(0)|134|121|122|(0)|127))))(3:21|(3:167|168|(1:170))(4:25|(2:28|26)|29|30)|31)|32|33|(0)|36|(1:37)|46|47|48|49|(0)(0)|52|53|(0)|56|57|(0)|60|(0)|(0)(0)|65|(3:66|(0)(0)|72)) */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x062c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x0648, code lost:
    
        android.util.Log.e(r2, "Crashlytics was not started due to an exception during initialization", r0);
        r11.g = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x06b1, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x06b2, code lost:
    
        r2 = "FirebaseCrashlytics";
        android.util.Log.e(r2, "Error retrieving app package info.", r0);
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:124:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0634  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x02cd A[Catch: NameNotFoundException -> 0x06b1, TryCatch #1 {NameNotFoundException -> 0x06b1, blocks: (B:49:0x02ab, B:51:0x02c2, B:53:0x02d4, B:56:0x02da, B:164:0x02cd), top: B:48:0x02ab }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x02c2 A[Catch: NameNotFoundException -> 0x06b1, TryCatch #1 {NameNotFoundException -> 0x06b1, blocks: (B:49:0x02ab, B:51:0x02c2, B:53:0x02d4, B:56:0x02da, B:164:0x02cd), top: B:48:0x02ab }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x02d8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x04d2  */
    @Override // defpackage.InterfaceC4561yf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object d(P2 p2) {
        C2853d6 c2853d6;
        long j;
        String str;
        C2853d6 c2853d62;
        String str2;
        int i;
        Throwable th;
        Iterator it;
        String str3;
        long currentTimeMillis;
        String num;
        String str4;
        String str5;
        int A;
        String[] strArr;
        int i2;
        String str6;
        Task task;
        Task onSuccessTask;
        boolean z;
        C0857c6 c0857c6;
        boolean exists;
        NetworkInfo activeNetworkInfo;
        Resources resources;
        C3436kS b;
        long longVersionCode;
        switch (this.a) {
            case 1:
                return this.b;
            default:
                int i3 = CrashlyticsRegistrar.d;
                CrashlyticsRegistrar crashlyticsRegistrar = (CrashlyticsRegistrar) this.b;
                crashlyticsRegistrar.getClass();
                long currentTimeMillis2 = System.currentTimeMillis();
                C0493Sq c0493Sq = (C0493Sq) p2.a(C0493Sq.class);
                InterfaceC3230hr interfaceC3230hr = (InterfaceC3230hr) p2.a(InterfaceC3230hr.class);
                C4139tJ h = p2.h(C0043Bh.class);
                C4139tJ h2 = p2.h(X3.class);
                C4139tJ h3 = p2.h(InterfaceC3943qr.class);
                ExecutorService executorService = (ExecutorService) p2.g(crashlyticsRegistrar.a);
                ExecutorService executorService2 = (ExecutorService) p2.g(crashlyticsRegistrar.b);
                ExecutorService executorService3 = (ExecutorService) p2.g(crashlyticsRegistrar.c);
                c0493Sq.a();
                Context context = c0493Sq.a;
                String packageName = context.getPackageName();
                Log.i("FirebaseCrashlytics", "Initializing Firebase Crashlytics 20.0.6 for " + packageName, null);
                C2853d6 c2853d63 = new C2853d6(executorService, executorService2);
                C0156Fq c0156Fq = new C0156Fq();
                String str7 = ((F8) C4254un.f.q(context)).a;
                c0156Fq.a = str7;
                File filesDir = context.getFilesDir();
                c0156Fq.b = filesDir;
                if (str7.isEmpty()) {
                    c2853d6 = c2853d63;
                    j = currentTimeMillis2;
                    str = ".com.google.firebase.crashlytics.files.v1";
                } else {
                    c2853d6 = c2853d63;
                    j = currentTimeMillis2;
                    StringBuilder sb = new StringBuilder(".crashlytics.v3");
                    sb.append(File.separator);
                    sb.append(str7.length() > 40 ? AbstractC0325Me.Q(str7) : str7.replaceAll("[^a-zA-Z0-9.]", "_"));
                    str = sb.toString();
                }
                File file = new File(filesDir, str);
                C0156Fq.d(file);
                c0156Fq.c = file;
                File file2 = new File(file, "open-sessions");
                C0156Fq.d(file2);
                c0156Fq.d = file2;
                File file3 = new File(file, "reports");
                C0156Fq.d(file3);
                c0156Fq.e = file3;
                File file4 = new File(file, "priority-reports");
                C0156Fq.d(file4);
                c0156Fq.f = file4;
                File file5 = new File(file, "native-reports");
                C0156Fq.d(file5);
                c0156Fq.g = file5;
                C0589Wi c0589Wi = new C0589Wi(c0493Sq);
                C0162Fw c0162Fw = new C0162Fw(context, packageName, interfaceC3230hr, c0589Wi);
                C0043Bh c0043Bh = new C0043Bh(h);
                C0694a4 c0694a4 = new C0694a4(h2);
                C3933qh c3933qh = new C3933qh(c0589Wi, c0156Fq);
                C4653zr c4653zr = C4653zr.a;
                EnumC0724aS enumC0724aS = EnumC0724aS.a;
                C4653zr c4653zr2 = C4653zr.a;
                C4495xr a = C4653zr.a(enumC0724aS);
                if (a.b != null) {
                    Log.d("FirebaseSessions", "Subscriber " + enumC0724aS + " already registered.");
                } else {
                    a.b = c3933qh;
                    Log.d("FirebaseSessions", "Subscriber " + enumC0724aS + " registered.");
                    a.a.countDown();
                }
                C4643zh c4643zh = new C4643zh(c0493Sq, c0162Fw, c0043Bh, c0589Wi, new Z3(c0694a4), new Z3(c0694a4), c0156Fq, c3933qh, new C0136Ew(h3, 29), c2853d6);
                C2853d6 c2853d64 = c2853d6;
                C2853d6 c2853d65 = c4643zh.o;
                c0493Sq.a();
                String str8 = c0493Sq.c.b;
                int A2 = AbstractC0325Me.A(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
                if (A2 == 0) {
                    A2 = AbstractC0325Me.A(context, "com.crashlytics.android.build_id", "string");
                }
                String string = A2 != 0 ? context.getResources().getString(A2) : null;
                ArrayList arrayList = new ArrayList();
                int A3 = AbstractC0325Me.A(context, "com.google.firebase.crashlytics.build_ids_lib", "array");
                int A4 = AbstractC0325Me.A(context, "com.google.firebase.crashlytics.build_ids_arch", "array");
                int A5 = AbstractC0325Me.A(context, "com.google.firebase.crashlytics.build_ids_build_id", "array");
                if (A3 == 0 || A4 == 0 || A5 == 0) {
                    c2853d62 = c2853d65;
                    str2 = str8;
                    String format = String.format("Could not find resources: %d %d %d", Integer.valueOf(A3), Integer.valueOf(A4), Integer.valueOf(A5));
                    i = 3;
                    if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                        th = null;
                        Log.d("FirebaseCrashlytics", format, null);
                        String m = W50.m("Mapping file ID is: ", string);
                        if (Log.isLoggable("FirebaseCrashlytics", i)) {
                            Log.d("FirebaseCrashlytics", m, th);
                        }
                        it = arrayList.iterator();
                        while (it.hasNext()) {
                            C2968eb c2968eb = (C2968eb) it.next();
                            StringBuilder x = W50.x("Build id for ", c2968eb.a, " on ");
                            x.append(c2968eb.b);
                            x.append(": ");
                            x.append(c2968eb.c);
                            String sb2 = x.toString();
                            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                                Log.d("FirebaseCrashlytics", sb2, null);
                            }
                        }
                        ML ml = new ML(context, 24);
                        String packageName2 = context.getPackageName();
                        String d = c0162Fw.d();
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName2, 0);
                        if (Build.VERSION.SDK_INT < 28) {
                            longVersionCode = packageInfo.getLongVersionCode();
                            num = Long.toString(longVersionCode);
                        } else {
                            num = Integer.toString(packageInfo.versionCode);
                        }
                        String str9 = num;
                        str4 = packageInfo.versionName;
                        if (str4 == null) {
                            str4 = "0.0";
                        }
                        String str10 = str4;
                        C0857c6 c0857c62 = new C0857c6(str2, string, arrayList, d, packageName2, str9, str10, ml);
                        str5 = str2;
                        String m2 = W50.m("Installer package name is: ", d);
                        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                            Log.v("FirebaseCrashlytics", m2, null);
                        }
                        C4254un c4254un = new C4254un(21);
                        String d2 = c0162Fw.d();
                        C4305vR c4305vR = new C4305vR(4);
                        C2882dV c2882dV = new C2882dV(c4305vR, 29);
                        C2835cv c2835cv = new C2835cv(c0156Fq);
                        Locale locale = Locale.US;
                        B2 b2 = new B2(W50.D("127.0.0.1", str5, "/settings"), c4254un);
                        String str11 = Build.MANUFACTURER;
                        String str12 = C0162Fw.h;
                        String n = W50.n(str11.replaceAll(str12, ""), "/", Build.MODEL.replaceAll(str12, ""));
                        String replaceAll = Build.VERSION.INCREMENTAL.replaceAll(str12, "");
                        String replaceAll2 = Build.VERSION.RELEASE.replaceAll(str12, "");
                        A = AbstractC0325Me.A(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
                        if (A == 0) {
                            A = AbstractC0325Me.A(context, "com.crashlytics.android.build_id", "string");
                        }
                        strArr = new String[]{A == 0 ? context.getResources().getString(A) : null, str5, str10, str9};
                        ArrayList arrayList2 = new ArrayList();
                        i2 = 0;
                        while (true) {
                            str6 = str5;
                            if (i2 < 4) {
                                Collections.sort(arrayList2);
                                StringBuilder sb3 = new StringBuilder();
                                Iterator it2 = arrayList2.iterator();
                                while (it2.hasNext()) {
                                    sb3.append((String) it2.next());
                                }
                                String sb4 = sb3.toString();
                                C4148tS c4148tS = new C4148tS(str6, n, replaceAll, replaceAll2, c0162Fw, sb4.length() > 0 ? AbstractC0325Me.Q(sb4) : null, str10, str9, ZT.i(d2 != null ? 4 : 1));
                                C2859d9 c2859d9 = new C2859d9();
                                AtomicReference atomicReference = new AtomicReference();
                                c2859d9.h = atomicReference;
                                c2859d9.i = new AtomicReference(new TaskCompletionSource());
                                c2859d9.a = context;
                                c2859d9.b = c4148tS;
                                c2859d9.d = c4305vR;
                                c2859d9.c = c2882dV;
                                c2859d9.e = c2835cv;
                                c2859d9.f = b2;
                                c2859d9.g = c0589Wi;
                                atomicReference.set(C0756ar.m(c4305vR));
                                boolean equals = ((Context) c2859d9.a).getSharedPreferences("com.google.firebase.crashlytics", 0).getString("existing_instance_identifier", "").equals(((C4148tS) c2859d9.b).f);
                                AtomicReference atomicReference2 = (AtomicReference) c2859d9.i;
                                AtomicReference atomicReference3 = (AtomicReference) c2859d9.h;
                                if (!equals || (b = c2859d9.b(1)) == null) {
                                    C3436kS b3 = c2859d9.b(3);
                                    if (b3 != null) {
                                        atomicReference3.set(b3);
                                        ((TaskCompletionSource) atomicReference2.get()).trySetResult(b3);
                                    }
                                    C0589Wi c0589Wi2 = (C0589Wi) c2859d9.g;
                                    Task task2 = c0589Wi2.f.getTask();
                                    synchronized (c0589Wi2.b) {
                                        task = c0589Wi2.c.getTask();
                                    }
                                    onSuccessTask = AbstractC0641Yi.L(task2, task).onSuccessTask((ExecutorC3221hi) c2853d64.b, new C0595Wo(c2859d9, c2853d64, 19, false));
                                } else {
                                    atomicReference3.set(b);
                                    ((TaskCompletionSource) atomicReference2.get()).trySetResult(b);
                                    onSuccessTask = Tasks.forResult(null);
                                }
                                onSuccessTask.addOnFailureListener(executorService3, new C0832bn(17));
                                C0156Fq c0156Fq2 = c4643zh.i;
                                Context context2 = c4643zh.a;
                                if (context2 != null && (resources = context2.getResources()) != null) {
                                    int A6 = AbstractC0325Me.A(context2, "com.crashlytics.RequireBuildId", "bool");
                                    if (A6 > 0) {
                                        z = resources.getBoolean(A6);
                                    } else {
                                        int A7 = AbstractC0325Me.A(context2, "com.crashlytics.RequireBuildId", "string");
                                        if (A7 > 0) {
                                            z = Boolean.parseBoolean(context2.getString(A7));
                                        }
                                    }
                                    if (z) {
                                        str3 = "FirebaseCrashlytics";
                                        if (Log.isLoggable(str3, 2)) {
                                            Log.v(str3, "Configured not to require a build ID.", null);
                                        }
                                        c0857c6 = c0857c62;
                                    } else {
                                        str3 = "FirebaseCrashlytics";
                                        c0857c6 = c0857c62;
                                        if (TextUtils.isEmpty(c0857c6.b)) {
                                            Log.e(str3, ".");
                                            Log.e(str3, ".     |  | ");
                                            Log.e(str3, ".     |  |");
                                            Log.e(str3, ".     |  |");
                                            Log.e(str3, ".   \\ |  | /");
                                            Log.e(str3, ".    \\    /");
                                            Log.e(str3, ".     \\  /");
                                            Log.e(str3, ".      \\/");
                                            Log.e(str3, ".");
                                            Log.e(str3, "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
                                            Log.e(str3, ".");
                                            Log.e(str3, ".      /\\");
                                            Log.e(str3, ".     /  \\");
                                            Log.e(str3, ".    /    \\");
                                            Log.e(str3, ".   / |  | \\");
                                            Log.e(str3, ".     |  |");
                                            Log.e(str3, ".     |  |");
                                            Log.e(str3, ".     |  |");
                                            Log.e(str3, ".");
                                            throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin");
                                        }
                                    }
                                    String str13 = new C4632zb().a;
                                    int i4 = 19;
                                    boolean z2 = false;
                                    c4643zh.f = new ML("crash_marker", c0156Fq2, i4, z2);
                                    c4643zh.e = new ML("initialization_marker", c0156Fq2, i4, z2);
                                    C2853d6 c2853d66 = c2853d62;
                                    C4548yX c4548yX = new C4548yX(str13, c0156Fq2, c2853d66);
                                    ML ml2 = new ML(c0156Fq2);
                                    C0595Wo c0595Wo = new C0595Wo(new EU[]{new C0213Hv(27)});
                                    C0136Ew c0136Ew = c4643zh.n;
                                    c0136Ew.getClass();
                                    ((C4139tJ) c0136Ew.b).a(new C4525yA(20));
                                    C0857c6 c0857c63 = c0857c6;
                                    c4643zh.g = new C4169th(c4643zh.a, c4643zh.h, c4643zh.b, c4643zh.i, c4643zh.f, c0857c63, c4548yX, ml2, P2.n(c4643zh.a, c4643zh.h, c4643zh.i, c0857c63, ml2, c4548yX, c0595Wo, c2859d9, c4643zh.c, c4643zh.l, c4643zh.o), c4643zh.m, c4643zh.k, c4643zh.l, c4643zh.o);
                                    ML ml3 = c4643zh.e;
                                    String str14 = (String) ml3.b;
                                    C0156Fq c0156Fq3 = (C0156Fq) ml3.c;
                                    c0156Fq3.getClass();
                                    exists = new File((File) c0156Fq3.c, str14).exists();
                                    Boolean.TRUE.equals((Boolean) ((ExecutorC3221hi) c2853d66.b).a.submit(new CallableC4327vh(c4643zh, 0)).get(3L, TimeUnit.SECONDS));
                                    C4169th c4169th = c4643zh.g;
                                    Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                    ((ExecutorC3221hi) c4169th.e.b).a(new I3(5, c4169th, str13));
                                    C3141gi c3141gi = new C3141gi(new C0136Ew(c4169th, 9), c2859d9, defaultUncaughtExceptionHandler, c4169th.j);
                                    c4169th.n = c3141gi;
                                    Thread.setDefaultUncaughtExceptionHandler(c3141gi);
                                    if (exists || (context2.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 && ((activeNetworkInfo = ((ConnectivityManager) context2.getSystemService("connectivity")).getActiveNetworkInfo()) == null || !activeNetworkInfo.isConnectedOrConnecting()))) {
                                        if (Log.isLoggable(str3, 3)) {
                                            Log.d(str3, "Successfully configured exception handler.", null);
                                        }
                                        ((ExecutorC3221hi) c2853d66.b).a(new RunnableC4248uh(c4643zh, c2859d9, 0));
                                        C0756ar c0756ar = new C0756ar(0);
                                        currentTimeMillis = System.currentTimeMillis() - j;
                                        if (currentTimeMillis > 16) {
                                            String str15 = "Initializing Crashlytics blocked main for " + currentTimeMillis + " ms";
                                            if (Log.isLoggable(str3, 3)) {
                                                Log.d(str3, str15, null);
                                            }
                                        }
                                        return c0756ar;
                                    }
                                    if (Log.isLoggable(str3, 3)) {
                                        Log.d(str3, "Crashlytics did not finish previous background initialization. Initializing synchronously.", null);
                                    }
                                    c4643zh.b(c2859d9);
                                    C0756ar c0756ar2 = new C0756ar(0);
                                    currentTimeMillis = System.currentTimeMillis() - j;
                                    if (currentTimeMillis > 16) {
                                    }
                                    return c0756ar2;
                                }
                                z = true;
                                if (z) {
                                }
                                String str132 = new C4632zb().a;
                                int i42 = 19;
                                boolean z22 = false;
                                c4643zh.f = new ML("crash_marker", c0156Fq2, i42, z22);
                                c4643zh.e = new ML("initialization_marker", c0156Fq2, i42, z22);
                                C2853d6 c2853d662 = c2853d62;
                                C4548yX c4548yX2 = new C4548yX(str132, c0156Fq2, c2853d662);
                                ML ml22 = new ML(c0156Fq2);
                                C0595Wo c0595Wo2 = new C0595Wo(new EU[]{new C0213Hv(27)});
                                C0136Ew c0136Ew2 = c4643zh.n;
                                c0136Ew2.getClass();
                                ((C4139tJ) c0136Ew2.b).a(new C4525yA(20));
                                C0857c6 c0857c632 = c0857c6;
                                c4643zh.g = new C4169th(c4643zh.a, c4643zh.h, c4643zh.b, c4643zh.i, c4643zh.f, c0857c632, c4548yX2, ml22, P2.n(c4643zh.a, c4643zh.h, c4643zh.i, c0857c632, ml22, c4548yX2, c0595Wo2, c2859d9, c4643zh.c, c4643zh.l, c4643zh.o), c4643zh.m, c4643zh.k, c4643zh.l, c4643zh.o);
                                ML ml32 = c4643zh.e;
                                String str142 = (String) ml32.b;
                                C0156Fq c0156Fq32 = (C0156Fq) ml32.c;
                                c0156Fq32.getClass();
                                exists = new File((File) c0156Fq32.c, str142).exists();
                                Boolean.TRUE.equals((Boolean) ((ExecutorC3221hi) c2853d662.b).a.submit(new CallableC4327vh(c4643zh, 0)).get(3L, TimeUnit.SECONDS));
                                C4169th c4169th2 = c4643zh.g;
                                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler2 = Thread.getDefaultUncaughtExceptionHandler();
                                ((ExecutorC3221hi) c4169th2.e.b).a(new I3(5, c4169th2, str132));
                                C3141gi c3141gi2 = new C3141gi(new C0136Ew(c4169th2, 9), c2859d9, defaultUncaughtExceptionHandler2, c4169th2.j);
                                c4169th2.n = c3141gi2;
                                Thread.setDefaultUncaughtExceptionHandler(c3141gi2);
                                if (exists) {
                                }
                                if (Log.isLoggable(str3, 3)) {
                                }
                                ((ExecutorC3221hi) c2853d662.b).a(new RunnableC4248uh(c4643zh, c2859d9, 0));
                                C0756ar c0756ar22 = new C0756ar(0);
                                currentTimeMillis = System.currentTimeMillis() - j;
                                if (currentTimeMillis > 16) {
                                }
                                return c0756ar22;
                            }
                            String str16 = strArr[i2];
                            String[] strArr2 = strArr;
                            if (str16 != null) {
                                arrayList2.add(str16.replace("-", "").toLowerCase(Locale.US));
                            }
                            i2++;
                            strArr = strArr2;
                            str5 = str6;
                        }
                    }
                } else {
                    String[] stringArray = context.getResources().getStringArray(A3);
                    String[] stringArray2 = context.getResources().getStringArray(A4);
                    String[] stringArray3 = context.getResources().getStringArray(A5);
                    str2 = str8;
                    if (stringArray.length == stringArray3.length && stringArray2.length == stringArray3.length) {
                        int i5 = 0;
                        while (i5 < stringArray3.length) {
                            int i6 = i5;
                            arrayList.add(new C2968eb(stringArray[i6], stringArray2[i6], stringArray3[i6]));
                            i5 = i6 + 1;
                            c2853d65 = c2853d65;
                        }
                        c2853d62 = c2853d65;
                    } else {
                        c2853d62 = c2853d65;
                        String format2 = String.format("Lengths did not match: %d %d %d", Integer.valueOf(stringArray.length), Integer.valueOf(stringArray2.length), Integer.valueOf(stringArray3.length));
                        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                            Log.d("FirebaseCrashlytics", format2, null);
                        }
                    }
                    i = 3;
                }
                th = null;
                String m3 = W50.m("Mapping file ID is: ", string);
                if (Log.isLoggable("FirebaseCrashlytics", i)) {
                }
                it = arrayList.iterator();
                while (it.hasNext()) {
                }
                ML ml4 = new ML(context, 24);
                String packageName22 = context.getPackageName();
                String d3 = c0162Fw.d();
                PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(packageName22, 0);
                if (Build.VERSION.SDK_INT < 28) {
                }
                String str92 = num;
                str4 = packageInfo2.versionName;
                if (str4 == null) {
                }
                String str102 = str4;
                C0857c6 c0857c622 = new C0857c6(str2, string, arrayList, d3, packageName22, str92, str102, ml4);
                str5 = str2;
                String m22 = W50.m("Installer package name is: ", d3);
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                }
                C4254un c4254un2 = new C4254un(21);
                String d22 = c0162Fw.d();
                C4305vR c4305vR2 = new C4305vR(4);
                C2882dV c2882dV2 = new C2882dV(c4305vR2, 29);
                C2835cv c2835cv2 = new C2835cv(c0156Fq);
                Locale locale2 = Locale.US;
                B2 b22 = new B2(W50.D("127.0.0.1", str5, "/settings"), c4254un2);
                String str112 = Build.MANUFACTURER;
                String str122 = C0162Fw.h;
                String n2 = W50.n(str112.replaceAll(str122, ""), "/", Build.MODEL.replaceAll(str122, ""));
                String replaceAll3 = Build.VERSION.INCREMENTAL.replaceAll(str122, "");
                String replaceAll22 = Build.VERSION.RELEASE.replaceAll(str122, "");
                A = AbstractC0325Me.A(context, "com.google.firebase.crashlytics.mapping_file_id", "string");
                if (A == 0) {
                }
                strArr = new String[]{A == 0 ? context.getResources().getString(A) : null, str5, str102, str92};
                ArrayList arrayList22 = new ArrayList();
                i2 = 0;
                while (true) {
                    str6 = str5;
                    if (i2 < 4) {
                    }
                    i2++;
                    strArr = strArr2;
                    str5 = str6;
                }
                break;
        }
    }

    public C3368jc e(C2853d6 c2853d6) {
        C3448kc c3448kc = (C3448kc) this.b;
        String t = AbstractC3634my.t("CctTransportBackend");
        boolean isLoggable = Log.isLoggable(t, 4);
        URL url = (URL) c2853d6.b;
        if (isLoggable) {
            Log.i(t, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(c3448kc.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) c2853d6.d;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    C2835cv c2835cv = c3448kc.a;
                    C0861c8 c0861c8 = (C0861c8) c2853d6.c;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    C4108sz c4108sz = (C4108sz) c2835cv.b;
                    C0398Oz c0398Oz = new C0398Oz(bufferedWriter, c4108sz.a, c4108sz.b, c4108sz.c, c4108sz.d);
                    c0398Oz.h(c0861c8);
                    c0398Oz.j();
                    c0398Oz.b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer valueOf = Integer.valueOf(responseCode);
                    String t2 = AbstractC3634my.t("CctTransportBackend");
                    if (Log.isLoggable(t2, 4)) {
                        Log.i(t2, String.format("Status Code: %d", valueOf));
                    }
                    AbstractC3634my.j("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    AbstractC3634my.j("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new C3368jc(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new C3368jc(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            C3368jc c3368jc = new C3368jc(responseCode, null, C3098g9.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return c3368jc;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (ConnectException e) {
            e = e;
            AbstractC3634my.k(e, "CctTransportBackend", "Couldn't open connection, returning with 500");
            return new C3368jc(500, null, 0L);
        } catch (UnknownHostException e2) {
            e = e2;
            AbstractC3634my.k(e, "CctTransportBackend", "Couldn't open connection, returning with 500");
            return new C3368jc(500, null, 0L);
        } catch (IOException e3) {
            e = e3;
            AbstractC3634my.k(e, "CctTransportBackend", "Couldn't encode request, returning with 400");
            return new C3368jc(400, null, 0L);
        } catch (C3782oo e4) {
            e = e4;
            AbstractC3634my.k(e, "CctTransportBackend", "Couldn't encode request, returning with 400");
            return new C3368jc(400, null, 0L);
        }
    }

    @Override // defpackage.InterfaceC4428x1
    public void f(Object obj) {
        String str = VPNClient.f0;
        VPNClient vPNClient = (VPNClient) this.b;
        vPNClient.getClass();
        if (((Boolean) obj).booleanValue()) {
            return;
        }
        SweetToast.info(vPNClient.getApplicationContext(), vPNClient.getString(R.string.notif_msg));
    }

    @Override // defpackage.DI
    public Object g() {
        Object obj = this.b;
        switch (this.a) {
            case 2:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(new Object[0]);
                } catch (IllegalAccessException e) {
                    XE xe = DN.a;
                    throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Failed to invoke constructor '" + DN.b(constructor) + "' with no args", e2);
                } catch (InvocationTargetException e3) {
                    throw new RuntimeException("Failed to invoke constructor '" + DN.b(constructor) + "' with no args", e3.getCause());
                }
            default:
                Class cls = (Class) obj;
                try {
                    return PZ.a.a(cls);
                } catch (Exception e4) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e4);
                }
        }
    }

    public boolean h(C0136Ew c0136Ew, int i, Bundle bundle) {
        InterfaceC4563yg interfaceC4563yg;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 25 && (i & 1) != 0) {
            try {
                ((InterfaceC4106sx) c0136Ew.b).c();
                Parcelable parcelable = (Parcelable) ((InterfaceC4106sx) c0136Ew.b).a();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e);
                return false;
            }
        }
        ClipDescription description = ((InterfaceC4106sx) c0136Ew.b).getDescription();
        InterfaceC4106sx interfaceC4106sx = (InterfaceC4106sx) c0136Ew.b;
        ClipData clipData = new ClipData(description, new ClipData.Item(interfaceC4106sx.b()));
        if (i2 >= 31) {
            interfaceC4563yg = new C0136Ew(clipData, 2);
        } else {
            C4642zg c4642zg = new C4642zg();
            c4642zg.b = clipData;
            c4642zg.c = 2;
            interfaceC4563yg = c4642zg;
        }
        interfaceC4563yg.c(interfaceC4106sx.d());
        interfaceC4563yg.setExtras(bundle);
        return AbstractC2925e20.i((C3568m5) this.b, interfaceC4563yg.build()) == null;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task task) {
        switch (this.a) {
            case 27:
                AbstractC0773b30.a((Intent) this.b);
                break;
            default:
                ((M40) this.b).b.trySetResult(null);
                break;
        }
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        Object obj2 = this.b;
        switch (this.a) {
            case 11:
                int i = HiddenActivity.c;
                ((C0446Qv) obj2).invoke(obj);
                break;
            case 12:
                int i2 = HiddenActivity.c;
                ((C0446Qv) obj2).invoke(obj);
                break;
            case 13:
                int i3 = HiddenActivity.c;
                ((C0446Qv) obj2).invoke(obj);
                break;
            default:
                int i4 = HiddenActivity.c;
                ((C0446Qv) obj2).invoke(obj);
                break;
        }
    }

    @Override // org.chromium.net.impl.JavaUrlRequestUtils.CheckedRunnable
    /* renamed from: run */
    public void mo28run() {
        ((VersionSafeCallbacks.UploadDataProviderWrapper) this.b).close();
    }

    @Override // com.google.android.gms.tasks.Continuation
    public Object then(Task task) {
        boolean z;
        switch (this.a) {
            case 7:
                return (Task) ((Callable) this.b).call();
            case 8:
                ((Runnable) this.b).run();
                return Tasks.forResult(null);
            case 10:
                ((P2) this.b).getClass();
                Bundle bundle = (Bundle) task.getResult(IOException.class);
                if (bundle == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                String string = bundle.getString("registration_id");
                if (string != null || (string = bundle.getString("unregistered")) != null) {
                    return string;
                }
                String string2 = bundle.getString("error");
                if ("RST".equals(string2)) {
                    throw new IOException("INSTANCE_ID_RESET");
                }
                if (string2 != null) {
                    throw new IOException(string2);
                }
                Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
                throw new IOException("SERVICE_NOT_AVAILABLE");
            case 19:
                ((P2) this.b).getClass();
                if (task.isSuccessful()) {
                    C3176h8 c3176h8 = (C3176h8) task.getResult();
                    C4254un c4254un = C4254un.e;
                    c4254un.l("Crashlytics report successfully enqueued to DataTransport: " + c3176h8.b);
                    File file = c3176h8.c;
                    if (file.delete()) {
                        c4254un.l("Deleted report file: " + file.getPath());
                    } else {
                        c4254un.v("Crashlytics could not delete report file: " + file.getPath(), null);
                    }
                    z = true;
                } else {
                    Log.w("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", task.getException());
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                ((CountDownLatch) this.b).countDown();
                return null;
        }
    }

    @Override // androidx.webkit.WebViewCompat.WebViewStartUpCallback
    public void onSuccess(WebViewStartUpResult webViewStartUpResult) {
        Uri uri = WebViewCompat.a;
        new Handler(Looper.getMainLooper()).post(new I3(15, (WebViewCompat.WebViewStartUpCallback) this.b, webViewStartUpResult));
    }
}
