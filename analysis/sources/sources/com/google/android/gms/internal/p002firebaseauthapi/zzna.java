package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzna {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzbr zza(zzch zzchVar, zzqh<zzbr> zzqhVar) {
        if (!zzqu.zza(zzchVar)) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzoq zzoqVar = (zzoq) zzchVar.zza(zzoq.class);
        zzot zza = (zzoqVar == null || zzoqVar.zza()) ? zzow.zza : zzpc.zzb().zza().zza(zzchVar, zzoqVar, "hybrid_encrypt", "encrypt");
        zzck zzc = zzchVar.zzc();
        return new zznc(new zzmz(zzqhVar.zza(zzc), zzc.zza()), zza);
    }
}
