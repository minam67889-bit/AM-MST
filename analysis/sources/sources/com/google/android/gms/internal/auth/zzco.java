package com.google.android.gms.internal.auth;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import defpackage.AbstractC3411gE;

/* loaded from: classes.dex */
final class zzco implements zzcl {
    private static zzco zza;
    private final Context zzb;
    private final ContentObserver zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzco() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzco zza(Context context) {
        zzco zzcoVar;
        synchronized (zzco.class) {
            try {
                if (zza == null) {
                    zza = AbstractC3411gE.i(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzco(context) : new zzco();
                }
                zzcoVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzcoVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void zze() {
        Context context;
        synchronized (zzco.class) {
            try {
                zzco zzcoVar = zza;
                if (zzcoVar != null && (context = zzcoVar.zzb) != null && zzcoVar.zzc != null) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
                zza = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzcl
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final String zzb(final String str) {
        Context context = this.zzb;
        if (context != null && !zzcc.zza(context)) {
            try {
                return (String) zzcj.zza(new zzck() { // from class: com.google.android.gms.internal.auth.zzcm
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.internal.auth.zzck
                    public final Object zza() {
                        return zzco.this.zzd(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: ".concat(String.valueOf(str)), e);
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ String zzd(String str) {
        return zzcb.zza(this.zzb.getContentResolver(), str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzco(Context context) {
        this.zzb = context;
        zzcn zzcnVar = new zzcn(this, null);
        this.zzc = zzcnVar;
        context.getContentResolver().registerContentObserver(zzcb.zza, true, zzcnVar);
    }
}
