package com.google.android.gms.internal.p002firebaseauthapi;

import defpackage.W50;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class zzie {
    public static zzbm zza(zzch zzchVar, zzpu<zzbm> zzpuVar) {
        zzoi zzoiVar;
        zzoi zzoiVar2;
        zzzv zzc;
        zzpi zzpiVar = new zzpi();
        for (int i = 0; i < zzchVar.zza(); i++) {
            zzck zza = zzchVar.zza(i);
            if (zza.zzc().equals(zzbv.zza)) {
                zzbt zzb = zza.zzb();
                if (zzb instanceof zzde) {
                    zzc = ((zzde) zzb).zzd();
                } else {
                    if (!(zzb instanceof zzoa)) {
                        throw new GeneralSecurityException(W50.o("Cannot get output prefix for key of class ", zzb.getClass().getName(), " with parameters ", String.valueOf(zzb.zza())));
                    }
                    zzc = ((zzoa) zzb).zzc();
                }
                zzpiVar.zza(zzc, new zzid(zzpuVar.zza(zza), zza.zza()));
            }
        }
        zzof zzofVar = (zzof) zzchVar.zza(zzof.class);
        if (zzofVar == null || zzofVar.zza()) {
            zzoiVar = zzol.zza;
            zzoiVar2 = zzoiVar;
        } else {
            zzoj zza2 = zzor.zzb().zza();
            zzoi zza3 = zza2.zza(zzchVar, zzofVar, "aead", "encrypt");
            zzoiVar2 = zza2.zza(zzchVar, zzofVar, "aead", "decrypt");
            zzoiVar = zza3;
        }
        return new zzig(new zzid(zzpuVar.zza(zzchVar.zzc()), zzchVar.zzc().zza()), zzpiVar.zza(), zzoiVar, zzoiVar2);
    }
}
