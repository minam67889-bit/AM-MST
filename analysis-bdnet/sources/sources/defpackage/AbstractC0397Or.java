package defpackage;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import android.os.Trace;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: Or, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0397Or {
    public static final NC a = new NC(2);
    public static final C0762ah b = new C0762ah(3);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static J3 a(Context context, List list) {
        AbstractC3411gE.c("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                C0423Pr c0423Pr = (C0423Pr) list.get(i);
                ProviderInfo b2 = b(context.getPackageManager(), c0423Pr, context.getResources());
                if (b2 == null) {
                    J3 j3 = new J3(2);
                    Trace.endSection();
                    return j3;
                }
                arrayList.add(c(context, c0423Pr, b2.authority));
            }
            J3 j32 = new J3(arrayList);
            Trace.endSection();
            return j32;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ProviderInfo b(PackageManager packageManager, C0423Pr c0423Pr, Resources resources) {
        AbstractC3411gE.c("FontProvider.getProvider");
        try {
            List list = c0423Pr.d;
            String str = c0423Pr.a;
            String str2 = c0423Pr.b;
            if (list == null) {
                list = AbstractC4766xx.Q(resources, 0);
            }
            C0371Nr c0371Nr = new C0371Nr();
            c0371Nr.a = str;
            c0371Nr.b = str2;
            c0371Nr.c = list;
            NC nc = a;
            ProviderInfo providerInfo = (ProviderInfo) nc.get(c0371Nr);
            if (providerInfo != null) {
                return providerInfo;
            }
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(str, 0);
            if (resolveContentProvider != null) {
                if (resolveContentProvider.packageName.equals(str2)) {
                    Signature[] signatureArr = packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures;
                    ArrayList arrayList = new ArrayList();
                    for (Signature signature : signatureArr) {
                        arrayList.add(signature.toByteArray());
                    }
                    C0762ah c0762ah = b;
                    Collections.sort(arrayList, c0762ah);
                    for (int i = 0; i < list.size(); i++) {
                        ArrayList arrayList2 = new ArrayList((Collection) list.get(i));
                        Collections.sort(arrayList2, c0762ah);
                        if (arrayList.size() == arrayList2.size()) {
                            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                if (!Arrays.equals((byte[]) arrayList.get(i2), (byte[]) arrayList2.get(i2))) {
                                    break;
                                }
                            }
                            nc.put(c0371Nr, resolveContentProvider);
                            return resolveContentProvider;
                        }
                    }
                    Trace.endSection();
                    return null;
                }
                throw new PackageManager.NameNotFoundException("Found content provider " + str + ", but package was not " + str2);
            }
            throw new PackageManager.NameNotFoundException("No package found for authority: " + str);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C0773as[] c(Context context, C0423Pr c0423Pr, String str) {
        int i;
        int i2;
        Uri withAppendedId;
        int i3;
        boolean z;
        AbstractC3411gE.c("FontProvider.query");
        try {
            ArrayList arrayList = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            ContentProviderClient acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(build);
            Cursor cursor = null;
            try {
                String[] strArr = {"_id", "file_id", "font_ttc_index", "font_variation_settings", "font_weight", "font_italic", "result_code"};
                AbstractC3411gE.c("ContentQueryWrapper.query");
                try {
                    String[] strArr2 = {c0423Pr.c};
                    if (acquireUnstableContentProviderClient != null) {
                        try {
                            cursor = acquireUnstableContentProviderClient.query(build, strArr, "query = ?", strArr2, null, null);
                        } catch (RemoteException e) {
                            Log.w("FontsProvider", "Unable to query the content provider", e);
                        }
                    }
                    Trace.endSection();
                    if (cursor != null && cursor.getCount() > 0) {
                        int columnIndex = cursor.getColumnIndex("result_code");
                        ArrayList arrayList2 = new ArrayList();
                        int columnIndex2 = cursor.getColumnIndex("_id");
                        int columnIndex3 = cursor.getColumnIndex("file_id");
                        int columnIndex4 = cursor.getColumnIndex("font_ttc_index");
                        int columnIndex5 = cursor.getColumnIndex("font_weight");
                        int columnIndex6 = cursor.getColumnIndex("font_italic");
                        while (cursor.moveToNext()) {
                            if (columnIndex != -1) {
                                i = cursor.getInt(columnIndex);
                            } else {
                                i = 0;
                            }
                            if (columnIndex4 != -1) {
                                i2 = cursor.getInt(columnIndex4);
                            } else {
                                i2 = 0;
                            }
                            if (columnIndex3 == -1) {
                                withAppendedId = ContentUris.withAppendedId(build, cursor.getLong(columnIndex2));
                            } else {
                                withAppendedId = ContentUris.withAppendedId(build2, cursor.getLong(columnIndex3));
                            }
                            Uri uri = withAppendedId;
                            if (columnIndex5 != -1) {
                                i3 = cursor.getInt(columnIndex5);
                            } else {
                                i3 = 400;
                            }
                            int i4 = i3;
                            if (columnIndex6 != -1 && cursor.getInt(columnIndex6) == 1) {
                                z = true;
                            } else {
                                z = false;
                            }
                            arrayList2.add(new C0773as(uri, i2, i4, z, i));
                        }
                        arrayList = arrayList2;
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    if (acquireUnstableContentProviderClient != null) {
                        acquireUnstableContentProviderClient.close();
                    }
                    return (C0773as[]) arrayList.toArray(new C0773as[0]);
                } finally {
                    Trace.endSection();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                if (acquireUnstableContentProviderClient != null) {
                    acquireUnstableContentProviderClient.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
