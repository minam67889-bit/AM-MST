package com.google.android.gms.internal.p002firebaseauthapi;

import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class zzlf implements zzbq {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final <P> P zza(zzch zzchVar, Class<P> cls) {
        Object zza;
        zzli unused;
        zzlg unused2;
        if (cls.equals(zzbr.class)) {
            unused = zzlc.zza;
            zza = zzli.zza(zzchVar, new zzqh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzle
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
                public final Object zza(zzck zzckVar) {
                    return zzlc.zzb(zzckVar);
                }
            });
        } else {
            if (!cls.equals(zzbs.class)) {
                throw new GeneralSecurityException("HybridConfigurationV1 can only create HybridEncrypt and HybridDecrypt primitives");
            }
            unused2 = zzlc.zzb;
            zza = zzlg.zza(zzchVar, new zzqh() { // from class: com.google.android.gms.internal.firebase-auth-api.zzlh
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.android.gms.internal.p002firebaseauthapi.zzqh
                public final Object zza(zzck zzckVar) {
                    return zzlc.zza(zzckVar);
                }
            });
        }
        return cls.cast(zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbq
    public final /* synthetic */ Object zza(Class cls) {
        return null;
    }
}
