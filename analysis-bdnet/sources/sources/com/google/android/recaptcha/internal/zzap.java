package com.google.android.recaptcha.internal;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

/* loaded from: classes.dex */
public final class zzap {
    public static final String zza(ContentResolver contentResolver) {
        Cursor query = contentResolver.query(Uri.parse("content://com.google.android.gsf.gservices"), null, null, new String[]{"android_id"}, null);
        if (query == null || !query.moveToFirst() || query.getColumnCount() < 2) {
            return "";
        }
        String valueOf = String.valueOf(Long.parseLong(query.getString(1)));
        query.close();
        return valueOf;
    }
}
