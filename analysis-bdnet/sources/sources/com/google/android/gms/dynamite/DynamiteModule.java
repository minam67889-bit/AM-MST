package com.google.android.gms.dynamite;

import android.content.ContentProviderClient;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import defpackage.C4;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzc = null;
    private static String zzd = null;
    private static boolean zze = false;
    private static int zzf = -1;
    private static Boolean zzg;
    private static zzp zzl;
    private static zzq zzm;
    private final Context zzk;
    private static final ThreadLocal zzh = new ThreadLocal();
    private static final ThreadLocal zzi = new zze();
    private static final VersionPolicy.IVersions zzj = new zzf();
    public static final VersionPolicy PREFER_REMOTE = new zzg();
    public static final VersionPolicy PREFER_LOCAL = new zzh();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzk();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzl();
    public static final VersionPolicy zza = new zzm();
    public static final VersionPolicy zzb = new zzc();

    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    public static class LoadingException extends Exception {
        public /* synthetic */ LoadingException(String str, Throwable th, byte[] bArr) {
            super(str, th);
        }

        public /* synthetic */ LoadingException(String str, byte[] bArr) {
            super(str);
        }
    }

    public interface VersionPolicy {

        public interface IVersions {
            int zza(Context context, String str, boolean z);

            int zzb(Context context, String str);
        }

        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions);
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzk = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 61);
            sb.append("com.google.android.gms.dynamite.descriptors.");
            sb.append(str);
            sb.append(".ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(sb.toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            String valueOf = String.valueOf(declaredField.get(null));
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 50 + String.valueOf(str).length() + 1);
            sb2.append("Module descriptor id '");
            sb2.append(valueOf);
            sb2.append("' didn't match expected id '");
            sb2.append(str);
            sb2.append("'");
            Log.e("DynamiteModule", sb2.toString());
            return 0;
        } catch (ClassNotFoundException unused) {
            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 45);
            sb3.append("Local module descriptor class for ");
            sb3.append(str);
            sb3.append(" not found.");
            Log.w("DynamiteModule", sb3.toString());
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02d7 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x02e6 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02dd A[DONT_GENERATE] */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule load(Context context, VersionPolicy versionPolicy, String str) {
        Context context2;
        int i;
        DynamiteModule zze2;
        int i2;
        Boolean bool;
        IObjectWrapper zze3;
        zzq zzqVar;
        boolean z;
        IObjectWrapper zze4;
        ?? r4 = ":";
        Context applicationContext = context.getApplicationContext();
        byte[] bArr = null;
        if (applicationContext == null) {
            throw new LoadingException("null application Context", null);
        }
        ThreadLocal threadLocal = zzh;
        zzn zznVar = (zzn) threadLocal.get();
        zzn zznVar2 = new zzn(null);
        threadLocal.set(zznVar2);
        ThreadLocal threadLocal2 = zzi;
        Long l = (Long) threadLocal2.get();
        long longValue = l.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.uptimeMillis()));
            VersionPolicy.SelectionResult selectModule = versionPolicy.selectModule(context, str, zzj);
            int i3 = selectModule.localVersion;
            int i4 = selectModule.remoteVersion;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26 + String.valueOf(i3).length() + 19 + String.valueOf(str).length() + 1 + String.valueOf(i4).length());
            sb.append("Considering local module ");
            sb.append(str);
            sb.append(":");
            sb.append(i3);
            sb.append(" and remote module ");
            sb.append(str);
            sb.append(":");
            sb.append(i4);
            Log.i("DynamiteModule", sb.toString());
            int i5 = selectModule.selection;
            if (i5 != 0) {
                if (i5 == -1) {
                    if (selectModule.localVersion != 0) {
                        i5 = -1;
                    }
                }
                if (i5 != 1 || selectModule.remoteVersion != 0) {
                    if (i5 == -1) {
                        DynamiteModule zze5 = zze(applicationContext, str);
                        if (longValue == 0) {
                            threadLocal2.remove();
                        } else {
                            threadLocal2.set(l);
                        }
                        Cursor cursor = zznVar2.zza;
                        if (cursor != null) {
                            cursor.close();
                        }
                        threadLocal.set(zznVar);
                        return zze5;
                    }
                    if (i5 != 1) {
                        StringBuilder sb2 = new StringBuilder(String.valueOf(i5).length() + 36);
                        sb2.append("VersionPolicy returned invalid code:");
                        sb2.append(i5);
                        throw new LoadingException(sb2.toString(), null);
                    }
                    try {
                        try {
                            i2 = selectModule.remoteVersion;
                        } catch (LoadingException e) {
                            e = e;
                            context2 = context;
                            String message = e.getMessage();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(message).length() + 30);
                            sb3.append("Failed to load remote module: ");
                            sb3.append(message);
                            Log.w("DynamiteModule", sb3.toString());
                            i = selectModule.localVersion;
                            if (i != 0 || versionPolicy.selectModule(context2, str, new zzo(i, 0)).selection != -1) {
                                throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                            }
                            zze2 = zze(applicationContext, str);
                            return zze2;
                        }
                    } catch (LoadingException e2) {
                        e = e2;
                        context2 = r4;
                        String message2 = e.getMessage();
                        StringBuilder sb32 = new StringBuilder(String.valueOf(message2).length() + 30);
                        sb32.append("Failed to load remote module: ");
                        sb32.append(message2);
                        Log.w("DynamiteModule", sb32.toString());
                        i = selectModule.localVersion;
                        if (i != 0) {
                        }
                        throw new LoadingException("Remote load failed. No local fallback found.", e, null);
                    }
                    try {
                        synchronized (DynamiteModule.class) {
                            if (!zzb(context)) {
                                throw new LoadingException("Remote loading disabled", null);
                            }
                            bool = zzc;
                        }
                        if (bool == null) {
                            throw new LoadingException("Failed to determine which loading route to use.", null);
                        }
                        if (bool.booleanValue()) {
                            StringBuilder sb4 = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(i2).length());
                            sb4.append("Selected remote version of ");
                            sb4.append(str);
                            sb4.append(", version >= ");
                            sb4.append(i2);
                            Log.i("DynamiteModule", sb4.toString());
                            synchronized (DynamiteModule.class) {
                                zzqVar = zzm;
                            }
                            if (zzqVar == null) {
                                throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
                            }
                            zzn zznVar3 = (zzn) threadLocal.get();
                            if (zznVar3 == null || zznVar3.zza == null) {
                                throw new LoadingException("No result cursor", null);
                            }
                            Context applicationContext2 = context.getApplicationContext();
                            Cursor cursor2 = zznVar3.zza;
                            ObjectWrapper.wrap(null);
                            synchronized (DynamiteModule.class) {
                                z = zzf >= 2;
                            }
                            if (z) {
                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                zze4 = zzqVar.zzf(ObjectWrapper.wrap(applicationContext2), str, i2, ObjectWrapper.wrap(cursor2));
                            } else {
                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                zze4 = zzqVar.zze(ObjectWrapper.wrap(applicationContext2), str, i2, ObjectWrapper.wrap(cursor2));
                            }
                            Context context3 = (Context) ObjectWrapper.unwrap(zze4);
                            if (context3 == null) {
                                throw new LoadingException("Failed to get module context", bArr);
                            }
                            zze2 = new DynamiteModule(context3);
                        } else {
                            StringBuilder sb5 = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(i2).length());
                            sb5.append("Selected remote version of ");
                            sb5.append(str);
                            sb5.append(", version >= ");
                            sb5.append(i2);
                            Log.i("DynamiteModule", sb5.toString());
                            zzp zzg2 = zzg(context);
                            if (zzg2 == null) {
                                throw new LoadingException("Failed to create IDynamiteLoader.", null);
                            }
                            int zzi2 = zzg2.zzi();
                            if (zzi2 >= 3) {
                                zzn zznVar4 = (zzn) threadLocal.get();
                                if (zznVar4 == null) {
                                    throw new LoadingException("No cached result cursor holder", null);
                                }
                                zze3 = zzg2.zzk(ObjectWrapper.wrap(context), str, i2, ObjectWrapper.wrap(zznVar4.zza));
                            } else if (zzi2 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                zze3 = zzg2.zzg(ObjectWrapper.wrap(context), str, i2);
                            } else {
                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                zze3 = zzg2.zze(ObjectWrapper.wrap(context), str, i2);
                            }
                            Object unwrap = ObjectWrapper.unwrap(zze3);
                            if (unwrap == null) {
                                throw new LoadingException("Failed to load remote module.", null);
                            }
                            zze2 = new DynamiteModule((Context) unwrap);
                        }
                        return zze2;
                    } catch (RemoteException e3) {
                        throw new LoadingException("Failed to load remote module.", e3, null);
                    } catch (LoadingException e4) {
                        throw e4;
                    } catch (Throwable th) {
                        CrashUtils.addDynamiteErrorToDropBox(context, th);
                        throw new LoadingException("Failed to load remote module.", th, null);
                    }
                }
            }
            int i6 = selectModule.localVersion;
            int i7 = selectModule.remoteVersion;
            StringBuilder sb6 = new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(i6).length() + 23 + String.valueOf(i7).length() + 1);
            sb6.append("No acceptable module ");
            sb6.append(str);
            sb6.append(" found. Local version is ");
            sb6.append(i6);
            sb6.append(" and remote version is ");
            sb6.append(i7);
            sb6.append(".");
            throw new LoadingException(sb6.toString(), null);
        } finally {
            if (longValue == 0) {
                zzi.remove();
            } else {
                zzi.set(l);
            }
            Cursor cursor3 = zznVar2.zza;
            if (cursor3 != null) {
                cursor3.close();
            }
            zzh.set(zznVar);
        }
    }

    public static int zza(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException remoteException;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzc;
                int i = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e) {
                        String obj = e.toString();
                        StringBuilder sb = new StringBuilder(obj.length() + 30);
                        sb.append("Failed to load module via V2: ");
                        sb.append(obj);
                        Log.w("DynamiteModule", sb.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                zzf(classLoader);
                            } catch (LoadingException unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!zzb(context)) {
                                return 0;
                            }
                            if (!zze) {
                                Boolean bool2 = Boolean.TRUE;
                                if (!bool2.equals(null)) {
                                    try {
                                        int zzc2 = zzc(context, str, z, true);
                                        String str2 = zzd;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader zza2 = zzb.zza();
                                            if (zza2 == null) {
                                                if (Build.VERSION.SDK_INT >= 29) {
                                                    C4.d();
                                                    String str3 = zzd;
                                                    Preconditions.checkNotNull(str3);
                                                    zza2 = C4.b(str3, ClassLoader.getSystemClassLoader());
                                                } else {
                                                    String str4 = zzd;
                                                    Preconditions.checkNotNull(str4);
                                                    zza2 = new zzd(str4, ClassLoader.getSystemClassLoader());
                                                }
                                            }
                                            zzf(zza2);
                                            declaredField.set(null, zza2);
                                            zzc = bool2;
                                            return zzc2;
                                        }
                                        return zzc2;
                                    } catch (LoadingException unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                            declaredField.set(null, ClassLoader.getSystemClassLoader());
                            bool = Boolean.FALSE;
                        }
                        zzc = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzc(context, str, z, false);
                    } catch (LoadingException e2) {
                        String message = e2.getMessage();
                        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 42);
                        sb2.append("Failed to retrieve remote module version: ");
                        sb2.append(message);
                        Log.w("DynamiteModule", sb2.toString());
                        return 0;
                    }
                }
                zzp zzg2 = zzg(context);
                if (zzg2 != null) {
                    try {
                        try {
                            int zzi2 = zzg2.zzi();
                            if (zzi2 >= 3) {
                                zzn zznVar = (zzn) zzh.get();
                                if (zznVar == null || (cursor = zznVar.zza) == null) {
                                    Cursor cursor2 = (Cursor) ObjectWrapper.unwrap(zzg2.zzj(ObjectWrapper.wrap(context), str, z, ((Long) zzi.get()).longValue()));
                                    if (cursor2 != null) {
                                        try {
                                            if (cursor2.moveToFirst()) {
                                                int i2 = cursor2.getInt(0);
                                                r4 = (i2 <= 0 || !zzd(cursor2)) ? cursor2 : null;
                                                if (r4 != null) {
                                                    r4.close();
                                                }
                                                i = i2;
                                            }
                                        } catch (RemoteException e3) {
                                            remoteException = e3;
                                            r4 = cursor2;
                                            String message2 = remoteException.getMessage();
                                            StringBuilder sb3 = new StringBuilder(String.valueOf(message2).length() + 42);
                                            sb3.append("Failed to retrieve remote module version: ");
                                            sb3.append(message2);
                                            Log.w("DynamiteModule", sb3.toString());
                                            if (r4 != null) {
                                                r4.close();
                                            }
                                            return i;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            r4 = cursor2;
                                            if (r4 == null) {
                                                throw th;
                                            }
                                            r4.close();
                                            throw th;
                                        }
                                    }
                                    Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                    if (cursor2 != null) {
                                        cursor2.close();
                                    }
                                } else {
                                    i = cursor.getInt(0);
                                }
                            } else if (zzi2 == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                i = zzg2.zzh(ObjectWrapper.wrap(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                i = zzg2.zzf(ObjectWrapper.wrap(context), str, z);
                            }
                        } catch (RemoteException e4) {
                            remoteException = e4;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                return i;
            }
        } catch (Throwable th4) {
            CrashUtils.addDynamiteErrorToDropBox(context, th4);
            throw th4;
        }
    }

    private static boolean zzb(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(zzg)) {
            return true;
        }
        boolean z = false;
        if (zzg == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", true != PlatformVersion.isAtLeastQ() ? 0 : 268435456);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            zzg = Boolean.valueOf(z);
            if (z && (applicationInfo = resolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zze = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x014b, code lost:
    
        r8.close();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x0147: MOVE (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]) (LINE:328), block:B:114:0x0147 */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0189  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00ef A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0163 A[Catch: all -> 0x0141, TryCatch #0 {all -> 0x0141, blocks: (B:15:0x00ef, B:17:0x00f5, B:20:0x00fd, B:33:0x012a, B:40:0x0133, B:44:0x0139, B:45:0x0140, B:11:0x014f, B:12:0x015d, B:51:0x015f, B:53:0x0163, B:54:0x0185, B:55:0x0186), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0186 A[Catch: all -> 0x0141, TRY_LEAVE, TryCatch #0 {all -> 0x0141, blocks: (B:15:0x00ef, B:17:0x00f5, B:20:0x00fd, B:33:0x012a, B:40:0x0133, B:44:0x0139, B:45:0x0140, B:11:0x014f, B:12:0x015d, B:51:0x015f, B:53:0x0163, B:54:0x0185, B:55:0x0186), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int zzc(Context context, String str, boolean z, boolean z2) {
        Throwable th;
        Exception exc;
        Cursor cursor;
        Cursor query;
        MatrixCursor matrixCursor;
        Cursor cursor2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        try {
            try {
                boolean z3 = true;
                Uri build = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartUptime", String.valueOf(((Long) zzi.get()).longValue())).build();
                ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
                boolean z4 = false;
                if (acquireUnstableContentProviderClient != null) {
                    try {
                        query = acquireUnstableContentProviderClient.query(build, null, null, null, null);
                    } catch (RemoteException unused) {
                    } catch (Throwable th2) {
                        acquireUnstableContentProviderClient.release();
                        throw th2;
                    }
                    if (query != null) {
                        try {
                            int count = query.getCount();
                            int columnCount = query.getColumnCount();
                            matrixCursor = new MatrixCursor(query.getColumnNames(), count);
                            for (int i = 0; i < count; i++) {
                                if (!query.moveToPosition(i)) {
                                    throw new RemoteException("Cursor read incomplete (ContentProvider dead?)");
                                }
                                Object[] objArr4 = new Object[columnCount];
                                for (int i2 = 0; i2 < columnCount; i2++) {
                                    int type = query.getType(i2);
                                    if (type == 0) {
                                        objArr4[i2] = null;
                                    } else if (type == 1) {
                                        objArr4[i2] = Long.valueOf(query.getLong(i2));
                                    } else if (type == 2) {
                                        objArr4[i2] = Double.valueOf(query.getDouble(i2));
                                    } else if (type == 3) {
                                        objArr4[i2] = query.getString(i2);
                                    } else {
                                        if (type != 4) {
                                            throw new RemoteException("Unknown column type");
                                        }
                                        objArr4[i2] = query.getBlob(i2);
                                    }
                                }
                                matrixCursor.addRow(objArr4);
                            }
                            query.close();
                            acquireUnstableContentProviderClient.release();
                            if (matrixCursor != null) {
                                try {
                                    if (matrixCursor.moveToFirst()) {
                                        int i3 = matrixCursor.getInt(0);
                                        if (i3 > 0) {
                                            synchronized (DynamiteModule.class) {
                                                try {
                                                    zzd = matrixCursor.getString(2);
                                                    int columnIndex = matrixCursor.getColumnIndex("loaderVersion");
                                                    if (columnIndex >= 0) {
                                                        zzf = matrixCursor.getInt(columnIndex);
                                                    }
                                                    int columnIndex2 = matrixCursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                                    if (columnIndex2 >= 0) {
                                                        if (matrixCursor.getInt(columnIndex2) == 0) {
                                                            z3 = false;
                                                        }
                                                        zze = z3;
                                                        z4 = z3;
                                                    }
                                                } finally {
                                                }
                                            }
                                            if (zzd(matrixCursor)) {
                                                matrixCursor = null;
                                            }
                                        }
                                        if (z2 && z4) {
                                            throw new LoadingException("forcing fallback to container DynamiteLoader impl", objArr2 == true ? 1 : 0);
                                        }
                                        return i3;
                                    }
                                } catch (Exception e) {
                                    exc = e;
                                    if (!(exc instanceof LoadingException)) {
                                        throw exc;
                                    }
                                    String message = exc.getMessage();
                                    StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 25);
                                    sb.append("V2 version check failed: ");
                                    sb.append(message);
                                    throw new LoadingException(sb.toString(), exc, objArr == true ? 1 : 0);
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", objArr3 == true ? 1 : 0);
                        } finally {
                        }
                    }
                    acquireUnstableContentProviderClient.release();
                }
                matrixCursor = null;
                if (matrixCursor != null) {
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new LoadingException("Failed to connect to dynamite module ContentResolver.", objArr3 == true ? 1 : 0);
            } catch (Throwable th3) {
                th = th3;
                cursor2 = cursor;
                if (cursor2 != null) {
                    throw th;
                }
                cursor2.close();
                throw th;
            }
        } catch (Exception e2) {
            exc = e2;
            if (!(exc instanceof LoadingException)) {
            }
        } catch (Throwable th4) {
            th = th4;
            if (cursor2 != null) {
            }
        }
    }

    private static boolean zzd(Cursor cursor) {
        zzn zznVar = (zzn) zzh.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static DynamiteModule zze(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzf(ClassLoader classLoader) {
        zzq zzqVar;
        byte[] bArr = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzqVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzqVar = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
            }
            zzm = zzqVar;
        } catch (ClassNotFoundException e) {
            e = e;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (IllegalAccessException e2) {
            e = e2;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (InstantiationException e3) {
            e = e3;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (NoSuchMethodException e4) {
            e = e4;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        } catch (InvocationTargetException e5) {
            e = e5;
            throw new LoadingException("Failed to instantiate dynamite loader", e, bArr);
        }
    }

    private static zzp zzg(Context context) {
        zzp zzpVar;
        synchronized (DynamiteModule.class) {
            zzp zzpVar2 = zzl;
            if (zzpVar2 != null) {
                return zzpVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzpVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzpVar = queryLocalInterface instanceof zzp ? (zzp) queryLocalInterface : new zzp(iBinder);
                }
                if (zzpVar != null) {
                    zzl = zzpVar;
                    return zzpVar;
                }
            } catch (Exception e) {
                String message = e.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 45);
                sb.append("Failed to load IDynamiteLoader from GmsCore: ");
                sb.append(message);
                Log.e("DynamiteModule", sb.toString());
            }
            return null;
        }
    }

    public Context getModuleContext() {
        return this.zzk;
    }

    public IBinder instantiate(String str) {
        try {
            return (IBinder) this.zzk.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
