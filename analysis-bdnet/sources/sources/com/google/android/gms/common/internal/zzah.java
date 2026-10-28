package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;

/* loaded from: classes.dex */
public final class zzah {
    private static final Uri zza = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bd A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Intent zza(Context context, zzn zznVar) {
        Bundle bundle;
        ContentProviderClient acquireUnstableContentProviderClient;
        String zza2 = zznVar.zza();
        if (zza2 == null) {
            return new Intent().setComponent(zznVar.zzc());
        }
        Intent intent = null;
        if (zznVar.zzd()) {
            Bundle bundle2 = new Bundle();
            bundle2.putString("serviceActionBundleKey", zza2);
            try {
                acquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(zza);
            } catch (RemoteException e) {
                e = e;
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
                if (bundle != null) {
                }
                if (intent == null) {
                }
                if (intent == null) {
                }
            } catch (IllegalArgumentException e2) {
                e = e2;
                Log.w("ServiceBindIntentUtils", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundle = null;
                if (bundle != null) {
                }
                if (intent == null) {
                }
                if (intent == null) {
                }
            }
            if (acquireUnstableContentProviderClient == null) {
                throw new RemoteException("Failed to acquire ContentProviderClient");
            }
            try {
                bundle = acquireUnstableContentProviderClient.call("serviceIntentCall", null, bundle2);
                acquireUnstableContentProviderClient.release();
                if (bundle != null) {
                    Intent intent2 = (Intent) bundle.getParcelable("serviceResponseIntentKey");
                    if (intent2 != null) {
                        intent = intent2;
                    } else {
                        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("serviceMissingResolutionIntentKey");
                        if (pendingIntent != null) {
                            StringBuilder sb = new StringBuilder(zza2.length() + 72);
                            sb.append("Dynamic lookup for intent failed for action ");
                            sb.append(zza2);
                            sb.append(" but has possible resolution");
                            Log.w("ServiceBindIntentUtils", sb.toString());
                            throw new zzaf(new ConnectionResult(25, pendingIntent));
                        }
                    }
                }
                if (intent == null) {
                    Log.w("ServiceBindIntentUtils", "Dynamic lookup for intent failed for action: ".concat(zza2));
                }
            } catch (Throwable th) {
                acquireUnstableContentProviderClient.release();
                throw th;
            }
        }
        return intent == null ? new Intent(zza2).setPackage(zznVar.zzb()) : intent;
    }
}
