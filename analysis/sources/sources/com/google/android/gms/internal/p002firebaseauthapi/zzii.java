package com.google.android.gms.internal.p002firebaseauthapi;

import defpackage.T60;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzii {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzbm zza(zzch zzchVar, zzqh<zzbm> zzqhVar) {
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
                zzbt zzb = zza.zzb();
                if (zzb instanceof zzdm) {
                    zzd = ((zzdm) zzb).zzd();
                } else {
                    if (!(zzb instanceof zzon)) {
                        throw new GeneralSecurityException(T60.x("Cannot get output prefix for key of class ", zzb.getClass().getName(), " with parameters ", String.valueOf(zzb.zza())));
                    }
                    zzd = ((zzon) zzb).zzd();
                }
                zzpwVar.zza(zzd, new zzih(zzqhVar.zza(zza), zza.zza()));
            }
        }
        zzoq zzoqVar = (zzoq) zzchVar.zza(zzoq.class);
        if (zzoqVar == null || zzoqVar.zza()) {
            zzotVar = zzow.zza;
            zzotVar2 = zzotVar;
        } else {
            zzou zza2 = zzpc.zzb().zza();
            zzot zza3 = zza2.zza(zzchVar, zzoqVar, "aead", "encrypt");
            zzotVar2 = zza2.zza(zzchVar, zzoqVar, "aead", "decrypt");
            zzotVar = zza3;
        }
        return new zzik(new zzih(zzqhVar.zza(zzchVar.zzc()), zzchVar.zzc().zza()), zzpwVar.zza(), zzotVar, zzotVar2);
    }
}
