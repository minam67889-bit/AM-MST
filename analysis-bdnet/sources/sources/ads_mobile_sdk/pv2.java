package ads_mobile_sdk;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.system.ErrnoException;
import android.system.Os;
import android.system.OsConstants;
import android.system.StructStat;
import defpackage.AbstractC3131gc0;
import defpackage.C0447Qw;
import defpackage.Gb0;
import defpackage.U20;
import defpackage.W50;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class pv2 {
    public static final String[] a = {"com.android.", "com.google.", "com.chrome.", "com.nest.", "com.waymo.", "com.waze", "com.waze."};
    public static final String[] b;
    public static final String[] c;

    static {
        String str = Build.HARDWARE;
        b = new String[]{"media", (str.equals("goldfish") || str.equals("ranchu")) ? "androidx.test.services.storage.runfiles" : ""};
        int i = Build.VERSION.SDK_INT;
        c = new String[]{i <= 25 ? "com.google.android.inputmethod.latin.inputcontent" : "", i <= 25 ? "com.google.android.inputmethod.latin.dev.inputcontent" : "", "com.google.android.apps.docs.storage.legacy"};
    }

    public static File[] a(Context context) {
        return context.getExternalFilesDirs(null);
    }

    public static File[] b(Context context) {
        return context.getExternalCacheDirs();
    }

    public static void a(ParcelFileDescriptor parcelFileDescriptor, String str) {
        try {
            StructStat fstat = Os.fstat(parcelFileDescriptor.getFileDescriptor());
            try {
                StructStat lstat = Os.lstat(str);
                if (OsConstants.S_ISLNK(lstat.st_mode)) {
                    throw new FileNotFoundException(W50.m("Can't open file: ", str));
                }
                if (fstat.st_dev != lstat.st_dev || fstat.st_ino != lstat.st_ino) {
                    throw new FileNotFoundException(W50.m("Can't open file: ", str));
                }
            } catch (ErrnoException e) {
                throw new IOException(e);
            }
        } catch (ErrnoException e2) {
            throw new IOException(e2);
        }
    }

    public static boolean a(Context context, String str) {
        try {
            for (File file : a(context)) {
                if (file != null) {
                    String canonicalPath = file.getCanonicalPath();
                    if (!canonicalPath.endsWith("/")) {
                        canonicalPath = canonicalPath.concat("/");
                    }
                    if (str.startsWith(canonicalPath)) {
                        return true;
                    }
                }
            }
            try {
                for (File file2 : b(context)) {
                    if (file2 != null) {
                        String canonicalPath2 = file2.getCanonicalPath();
                        if (!canonicalPath2.endsWith("/")) {
                            canonicalPath2 = canonicalPath2.concat("/");
                        }
                        if (str.startsWith(canonicalPath2)) {
                            return true;
                        }
                    }
                }
                return false;
            } catch (NullPointerException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        } catch (NullPointerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new RuntimeException(e4);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
    
        if (r13 == false) goto L69;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static FileOutputStream a(Context context, Uri uri, ov2 ov2Var) {
        AssetFileDescriptor assetFileDescriptor;
        int i;
        boolean z;
        ContentResolver contentResolver = context.getContentResolver();
        if (Build.VERSION.SDK_INT < 30) {
            uri = Uri.parse(uri.toString());
        }
        String scheme = uri.getScheme();
        if ("android.resource".equals(scheme)) {
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "w");
        } else if ("content".equals(scheme)) {
            String authority = uri.getAuthority();
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            if (resolveContentProvider == null) {
                int lastIndexOf = authority.lastIndexOf(64);
                if (lastIndexOf > -1) {
                    authority = authority.substring(lastIndexOf + 1);
                    resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
                }
                if (resolveContentProvider == null) {
                    z = !ov2Var.a;
                }
            }
            C0447Qw listIterator = ov2Var.b.listIterator(0);
            while (true) {
                i = 3;
                if (!listIterator.hasNext()) {
                    break;
                }
                ((Gb0) listIterator.next()).getClass();
                if (uri.getAuthority().lastIndexOf(64) > -1 && AbstractC3131gc0.h(context, "android.permission.INTERACT_ACROSS_USERS") == 0) {
                    i = 2;
                }
                int a2 = U20.a(i);
                if (a2 == 0) {
                    i = 1;
                    break;
                }
                if (a2 == 1) {
                    i = 2;
                    break;
                }
            }
            int a3 = U20.a(i);
            if (a3 != 0) {
                if (a3 != 1) {
                    if (context.getPackageName().equals(resolveContentProvider.packageName)) {
                        z = ov2Var.a;
                    } else if (!ov2Var.a) {
                        if (context.checkUriPermission(uri, Process.myPid(), Process.myUid(), 2) != 0 && resolveContentProvider.exported) {
                            String[] strArr = b;
                            int length = strArr.length;
                            int i2 = 0;
                            while (true) {
                                if (i2 < length) {
                                    if (strArr[i2].equals(authority)) {
                                        break;
                                    }
                                    i2++;
                                } else {
                                    String[] strArr2 = c;
                                    int length2 = strArr2.length;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < length2) {
                                            if (strArr2[i3].equals(authority)) {
                                                break;
                                            }
                                            i3++;
                                        } else {
                                            String[] strArr3 = a;
                                            for (int i4 = 0; i4 < 7; i4++) {
                                                String str = strArr3[i4];
                                                if (str.charAt(str.length() - 1) == '.') {
                                                    if (!resolveContentProvider.packageName.startsWith(str)) {
                                                    }
                                                } else if (!resolveContentProvider.packageName.equals(str)) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                throw new FileNotFoundException("Can't open content uri.");
            }
            assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "w");
            if (assetFileDescriptor == null) {
                throw new FileNotFoundException("Content resolver returned null value.");
            }
        } else if ("file".equals(scheme)) {
            AssetFileDescriptor openAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "w");
            if (openAssetFileDescriptor != null) {
                try {
                    a(context, openAssetFileDescriptor.getParcelFileDescriptor(), uri, ov2Var);
                    assetFileDescriptor = openAssetFileDescriptor;
                } catch (FileNotFoundException e) {
                    try {
                        openAssetFileDescriptor.close();
                    } catch (IOException e2) {
                        e.addSuppressed(e2);
                    }
                    throw e;
                } catch (IOException e3) {
                    FileNotFoundException fileNotFoundException = new FileNotFoundException("Validation failed.");
                    fileNotFoundException.initCause(e3);
                    try {
                        openAssetFileDescriptor.close();
                        throw fileNotFoundException;
                    } catch (IOException e4) {
                        fileNotFoundException.addSuppressed(e4);
                        throw fileNotFoundException;
                    }
                }
            } else {
                throw new FileNotFoundException("Content resolver returned null value.");
            }
        } else {
            throw new FileNotFoundException("Unsupported scheme");
        }
        if (assetFileDescriptor == null) {
            return null;
        }
        try {
            return assetFileDescriptor.createOutputStream();
        } catch (IOException e5) {
            FileNotFoundException fileNotFoundException2 = new FileNotFoundException("Unable to create stream");
            fileNotFoundException2.initCause(e5);
            try {
                assetFileDescriptor.close();
                throw fileNotFoundException2;
            } catch (IOException e6) {
                fileNotFoundException2.addSuppressed(e6);
                throw fileNotFoundException2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
    
        if (r4.startsWith(r3) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0066, code lost:
    
        r3 = r2.createDeviceProtectedStorageContext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006a, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x006c, code lost:
    
        r3 = r3.getDataDir();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0070, code lost:
    
        if (r3 == null) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0072, code lost:
    
        r3 = r3.getCanonicalPath();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x007a, code lost:
    
        if (r3.endsWith("/") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x007c, code lost:
    
        r3 = r3.concat("/");
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0084, code lost:
    
        if (r4.startsWith(r3) == false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
    
        r2 = a(r2, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0086, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0063, code lost:
    
        if (r4.startsWith(r3) != false) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context, ParcelFileDescriptor parcelFileDescriptor, Uri uri, ov2 ov2Var) {
        boolean z;
        String canonicalPath = new File(uri.getPath()).getCanonicalPath();
        a(parcelFileDescriptor, canonicalPath);
        if (!canonicalPath.startsWith("/proc/") && !canonicalPath.startsWith("/data/misc/")) {
            ov2Var.getClass();
            C0447Qw listIterator = ov2Var.c.listIterator(0);
            if (!listIterator.hasNext()) {
                File dataDir = context.getDataDir();
                if (dataDir != null) {
                    String canonicalPath2 = dataDir.getCanonicalPath();
                    if (!canonicalPath2.endsWith("/")) {
                        canonicalPath2 = canonicalPath2.concat("/");
                    }
                } else {
                    String canonicalPath3 = Environment.getDataDirectory().getCanonicalPath();
                    if (!canonicalPath3.endsWith("/")) {
                        canonicalPath3 = canonicalPath3.concat("/");
                    }
                }
                if (z == ov2Var.a) {
                    return;
                }
            } else {
                listIterator.next().getClass();
                throw new ClassCastException();
            }
        }
        throw new FileNotFoundException("Can't open file: ".concat(canonicalPath));
    }
}
