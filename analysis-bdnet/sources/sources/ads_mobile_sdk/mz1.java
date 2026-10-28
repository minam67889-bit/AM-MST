package ads_mobile_sdk;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.Process;
import android.provider.MediaStore;
import defpackage.AbstractC0536Ua;
import defpackage.AbstractC3411gE;
import defpackage.AbstractC4766xx;
import defpackage.C0777aw;
import defpackage.C3208dc0;
import defpackage.C4662wa;
import defpackage.InterfaceC0490Sg;
import defpackage.InterfaceC0872c60;
import defpackage.NM;
import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class mz1 {
    public static final NM i = new NM("[^/\\\\\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$");
    public final an0 a;
    public final ix1 b;
    public final InterfaceC0490Sg c;
    public final InterfaceC0490Sg d;
    public final InterfaceC0872c60 e;
    public final f0 f;
    public final g83 g;
    public final ks3 h;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public mz1(an0 an0Var, ix1 ix1Var, InterfaceC0490Sg interfaceC0490Sg, InterfaceC0490Sg interfaceC0490Sg2, InterfaceC0872c60 interfaceC0872c60, f0 f0Var, g83 g83Var, ks3 ks3Var) {
        AbstractC4766xx.p(an0Var, "deviceProperties");
        AbstractC4766xx.p(ix1Var, "mraidAfmaDispatcher");
        AbstractC4766xx.p(interfaceC0490Sg, "uiScope");
        AbstractC4766xx.p(interfaceC0490Sg2, "backgroundScope");
        AbstractC4766xx.p(interfaceC0872c60, "httpClient");
        AbstractC4766xx.p(f0Var, "activityTracker");
        AbstractC4766xx.p(g83Var, "rootTraceCreator");
        AbstractC4766xx.p(ks3Var, "traceMetaSet");
        this.a = an0Var;
        this.b = ix1Var;
        this.c = interfaceC0490Sg;
        this.d = interfaceC0490Sg2;
        this.e = interfaceC0872c60;
        this.f = f0Var;
        this.g = g83Var;
        this.h = ks3Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x017e  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(mz1 mz1Var, ByteArrayInputStream byteArrayInputStream, String str, String str2, Context context, r31 r31Var) {
        AssetFileDescriptor assetFileDescriptor;
        int i2;
        int i3;
        int i4;
        FileOutputStream createOutputStream;
        mz1Var.getClass();
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/" + str2);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 30) {
            contentValues.put("is_pending", (Integer) 1);
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            mz1Var.a("Unable to store picture", r31Var, true);
            return;
        }
        v93 v93Var = v93.d;
        String[] strArr = w93.a;
        ContentResolver contentResolver2 = context.getContentResolver();
        Uri parse = i5 < 30 ? Uri.parse(insert.toString()) : insert;
        String scheme = parse.getScheme();
        if ("android.resource".equals(scheme)) {
            assetFileDescriptor = contentResolver2.openAssetFileDescriptor(parse, "w");
        } else if ("content".equals(scheme)) {
            String authority = parse.getAuthority();
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
            int i6 = 64;
            if (resolveContentProvider == null) {
                int lastIndexOf = authority.lastIndexOf(64);
                if (lastIndexOf > -1) {
                    authority = authority.substring(lastIndexOf + 1);
                    i2 = 0;
                    resolveContentProvider = context.getPackageManager().resolveContentProvider(authority, 0);
                } else {
                    i2 = 0;
                    resolveContentProvider = resolveContentProvider;
                }
                if (resolveContentProvider == null) {
                    v93Var.getClass();
                    assetFileDescriptor = contentResolver2.openAssetFileDescriptor(parse, "w");
                    if (assetFileDescriptor == null) {
                        throw new FileNotFoundException("Content resolver returned null value.");
                    }
                }
            } else {
                i2 = 0;
            }
            C0777aw listIterator = v93Var.b.listIterator(i2);
            while (true) {
                i3 = 3;
                if (!listIterator.hasNext()) {
                    i4 = 1;
                    break;
                }
                ((C3208dc0) listIterator.next()).getClass();
                if (parse.getAuthority().lastIndexOf(i6) > -1 && AbstractC3411gE.i(context, "android.permission.INTERACT_ACROSS_USERS") == 0) {
                    i3 = 2;
                }
                if (i3 == 0) {
                    throw null;
                }
                i4 = 1;
                int i7 = i3 - 1;
                if (i7 == 0) {
                    i3 = 1;
                    break;
                } else {
                    if (i7 == 1) {
                        i3 = 2;
                        break;
                    }
                    i6 = 64;
                }
            }
            if (i3 == 0) {
                throw null;
            }
            int i8 = i3 - 1;
            if (i8 != 0) {
                if (i8 != i4 && !context.getPackageName().equals(resolveContentProvider.packageName)) {
                    if (context.checkUriPermission(parse, Process.myPid(), Process.myUid(), 2) != 0 && resolveContentProvider.exported) {
                        String[] strArr2 = w93.b;
                        int length = strArr2.length;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= length) {
                                int i10 = 1;
                                String[] strArr3 = w93.c;
                                int length2 = strArr3.length;
                                int i11 = 0;
                                while (true) {
                                    if (i11 >= length2) {
                                        String[] strArr4 = w93.a;
                                        int i12 = 0;
                                        while (i12 < 7) {
                                            String str3 = strArr4[i12];
                                            if (str3.charAt(str3.length() - i10) == '.') {
                                                if (resolveContentProvider.packageName.startsWith(str3)) {
                                                }
                                                i12++;
                                                i10 = 1;
                                            } else {
                                                if (resolveContentProvider.packageName.equals(str3)) {
                                                }
                                                i12++;
                                                i10 = 1;
                                            }
                                        }
                                    } else {
                                        if (strArr3[i11].equals(authority)) {
                                            break;
                                        }
                                        i10 = 1;
                                        i11++;
                                    }
                                }
                            } else if (strArr2[i9].equals(authority)) {
                                break;
                            } else {
                                i9++;
                            }
                        }
                    }
                }
                throw new FileNotFoundException("Can't open content uri.");
            }
            assetFileDescriptor = contentResolver2.openAssetFileDescriptor(parse, "w");
            if (assetFileDescriptor == null) {
            }
        } else {
            if (!"file".equals(scheme)) {
                throw new FileNotFoundException("Unsupported scheme");
            }
            AssetFileDescriptor openAssetFileDescriptor = contentResolver2.openAssetFileDescriptor(parse, "w");
            if (openAssetFileDescriptor == null) {
                throw new FileNotFoundException("Content resolver returned null value.");
            }
            try {
                w93.a(context, openAssetFileDescriptor.getParcelFileDescriptor(), parse, v93Var);
                assetFileDescriptor = openAssetFileDescriptor;
            } catch (FileNotFoundException e) {
                try {
                    openAssetFileDescriptor.close();
                    throw e;
                } catch (IOException e2) {
                    e.addSuppressed(e2);
                    throw e;
                }
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
        }
        if (assetFileDescriptor != null) {
            try {
                createOutputStream = assetFileDescriptor.createOutputStream();
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
        } else {
            createOutputStream = null;
        }
        int i13 = AbstractC0536Ua.a;
        createOutputStream.getClass();
        byte[] bArr = new byte[JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read == -1) {
                break;
            } else {
                createOutputStream.write(bArr, 0, read);
            }
        }
        if (i5 >= 30) {
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(insert, contentValues, null, null);
        }
        f01.a(new ad2(2, str, insert));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(String str, r31 r31Var, boolean z) {
        C4662wa c4662wa = f01.a;
        f01.c("Store picture error: " + str, null);
        if (z) {
            xs3.a(6, str, null);
        }
        AbstractC4766xx.J(this.c, null, null, new iz1(this, r31Var, str, null), 3);
    }
}
