package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdw;
import com.google.android.gms.internal.p002firebaseauthapi.zzel;
import com.google.android.gms.internal.p002firebaseauthapi.zzjd;
import com.google.android.gms.internal.p002firebaseauthapi.zzkl;
import com.google.android.gms.internal.p002firebaseauthapi.zzxg;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzkh {
    private static final zzpx<zzko, zzbs> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkk
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzk.zza((zzko) zzbtVar);
        }
    }, zzko.class, zzbs.class);
    private static final zzpx<zzkr, zzbr> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkj
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzzj.zza((zzkr) zzbtVar);
        }
    }, zzkr.class, zzbr.class);
    private static final zzcu<zzbs> zzc = zzol.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzbs.class, zzvs.zzf());
    private static final zzbw<zzbr> zzd = zzol.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzbr.class, zzxg.zza.ASYMMETRIC_PUBLIC, zzvv.zzh());
    private static final zzob<zzkl> zze = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkm
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            return zzkh.zza((zzkl) zzcsVar, num);
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ zzko zza(zzkl zzklVar, Integer num) {
        ECParameterSpec eCParameterSpec;
        zzkl.zzc zzd2 = zzklVar.zzd();
        if (zzd2 == zzkl.zzc.zza) {
            eCParameterSpec = zznv.zza;
        } else if (zzd2 == zzkl.zzc.zzb) {
            eCParameterSpec = zznv.zzb;
        } else {
            if (zzd2 != zzkl.zzc.zzc) {
                throw new GeneralSecurityException("Unsupported curve type: ".concat(String.valueOf(zzd2)));
            }
            eCParameterSpec = zznv.zzc;
        }
        KeyPair zza2 = zzzn.zza(eCParameterSpec);
        return zzko.zza(zzkr.zza(zzklVar, ((ECPublicKey) zza2.getPublic()).getW(), num), zzaat.zza(((ECPrivateKey) zza2.getPrivate()).getS(), zzbu.zza()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(boolean z) {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
        }
        zzlx.zza();
        zzpd zza2 = zzpd.zza();
        HashMap hashMap = new HashMap();
        zzkl.zza zzc2 = zzkl.zzc();
        zzkl.zzc zzcVar = zzkl.zzc.zza;
        zzkl.zza zza3 = zzc2.zza(zzcVar);
        zzkl.zzb zzbVar = zzkl.zzb.zzc;
        zzkl.zza zza4 = zza3.zza(zzbVar);
        zzkl.zze zzeVar = zzkl.zze.zzb;
        zzkl.zza zza5 = zza4.zza(zzeVar);
        zzkl.zzd zzdVar = zzkl.zzd.zza;
        zzkl.zza zza6 = zza5.zza(zzdVar);
        zzel.zza zzc3 = zzel.zze().zza(12).zzb(16).zzc(16);
        zzel.zzb zzbVar2 = zzel.zzb.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zza6.zza(zzc3.zza(zzbVar2).zza()).zza());
        zzkl.zza zza7 = zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar);
        zzkl.zzd zzdVar2 = zzkl.zzd.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zza7.zza(zzdVar2).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        zzkl.zza zza8 = zzkl.zzc().zza(zzcVar).zza(zzbVar);
        zzkl.zze zzeVar2 = zzkl.zze.zza;
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zza8.zza(zzeVar2).zza(zzdVar).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzel.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
        zzkl.zza zza9 = zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar);
        zzdw.zza zzc4 = zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16);
        zzdw.zzc zzcVar2 = zzdw.zzc.zzc;
        zzdw.zza zza10 = zzc4.zza(zzcVar2);
        zzdw.zzb zzbVar3 = zzdw.zzb.zzc;
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zza9.zza(zza10.zza(zzbVar3).zza()).zza());
        hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar2).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzcVar2).zza(zzbVar3).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzcVar2).zza(zzbVar3).zza()).zza());
        hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkl.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzdw.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzcVar2).zza(zzbVar3).zza()).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
        zzoy.zza().zza(zze, zzkl.class);
        zzoe.zza().zza((zzbw) zzc, true);
        zzoe.zza().zza((zzbw) zzd, false);
    }
}
