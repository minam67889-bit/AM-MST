package com.google.android.gms.internal.p002firebaseauthapi;

import defpackage.T60;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzkd {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzbp zza(zzch zzchVar, zzqh<zzbp> zzqhVar) {
        zzot zzotVar;
        zzot zzotVar2;
        zzaau zzd;
        if (!zzqu.zza(zzchVar)) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
        zzpw zzpwVar = new zzpw();
        for (int i = 0; i < zzchVar.zza(); i++) {
            zzck zza = zzchVar.zza(i);
            if (zza.zzc().equals(zzbv.zza)) {
                zzbp zza2 = zzqhVar.zza(zza);
                zzbt zzb = zza.zzb();
                if (zzb instanceof zzjr) {
                    zzd = ((zzjr) zzb).zze();
                } else {
                    if (!(zzb instanceof zzon)) {
                        throw new GeneralSecurityException(T60.x("Cannot get output prefix for key of class ", zzb.getClass().getName(), " with parameters ", String.valueOf(zzb.zza())));
                    }
                    zzd = ((zzon) zzb).zzd();
                }
                zzpwVar.zza(zzd, new zzkg(zza2, zza.zza()));
            }
        }
        zzoq zzoqVar = (zzoq) zzchVar.zza(zzoq.class);
        if (zzoqVar == null || zzoqVar.zza()) {
            zzotVar = zzow.zza;
            zzotVar2 = zzotVar;
        } else {
            zzou zza3 = zzpc.zzb().zza();
            zzotVar = zza3.zza(zzchVar, zzoqVar, "daead", "encrypt");
            zzotVar2 = zza3.zza(zzchVar, zzoqVar, "daead", "decrypt");
        }
        return new zzkf(new zzkg(zzqhVar.zza(zzchVar.zzc()), zzchVar.zzc().zza()), zzpwVar.zza(), zzotVar, zzotVar2);
    }
}
