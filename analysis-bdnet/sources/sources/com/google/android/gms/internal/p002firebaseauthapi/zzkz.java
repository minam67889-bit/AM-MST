package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzkz implements zzbq {
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final <P> P zza(zzch zzchVar, Class<P> cls) {
        zzlc unused;
        zzla unused2;
        if (cls.equals(zzbr.class)) {
            unused = zzkw.zza;
            return cls.cast(zzlc.zza(zzchVar, new zzpu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzky
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpu
                public final Object zza(zzck zzckVar) {
                    return zzkw.zzb(zzckVar);
                }
            }));
        }
        if (!cls.equals(zzbs.class)) {
            throw new GeneralSecurityException("HybridConfigurationV1 can only create HybridEncrypt and HybridDecrypt primitives");
        }
        unused2 = zzkw.zzb;
        return cls.cast(zzla.zza(zzchVar, new zzpu() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlb
            @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpu
            public final Object zza(zzck zzckVar) {
                return zzkw.zza(zzckVar);
            }
        }));
    }
}
