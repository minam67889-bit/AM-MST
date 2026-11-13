package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzdo;
import com.google.android.gms.internal.p002firebaseauthapi.zzed;
import com.google.android.gms.internal.p002firebaseauthapi.zzjb;
import com.google.android.gms.internal.p002firebaseauthapi.zzkf;
import com.google.android.gms.internal.p002firebaseauthapi.zzwj;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzkb {
    private static final zzpn<zzki, zzbs> zza = zzpn.zza(new Object() { // from class: com.google.android.gms.internal.firebase-auth-api.zzke
    }, zzki.class, zzbs.class);
    private static final zzpn<zzkl, zzbr> zzb = zzpn.zza(new Object() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkd
    }, zzkl.class, zzbr.class);
    private static final zzcs<zzbs> zzc = zzny.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey", zzbs.class, zzuv.zzf());
    private static final zzbw<zzbr> zzd = zzny.zza("type.googleapis.com/google.crypto.tink.EciesAeadHkdfPublicKey", zzbr.class, zzwj.zza.ASYMMETRIC_PUBLIC, zzuy.zzh());
    private static final zzno<zzkf> zze = new zzno() { // from class: com.google.android.gms.internal.firebase-auth-api.zzkg
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzno
        public final zzbt zza(zzcq zzcqVar, Integer num) {
            return zzkb.zza((zzkf) zzcqVar, num);
        }
    };

    public static /* synthetic */ zzki zza(zzkf zzkfVar, Integer num) {
        ECParameterSpec eCParameterSpec;
        zzkf.zzc zzd2 = zzkfVar.zzd();
        if (zzd2 == zzkf.zzc.zza) {
            eCParameterSpec = zzni.zza;
        } else if (zzd2 == zzkf.zzc.zzb) {
            eCParameterSpec = zzni.zzb;
        } else {
            if (zzd2 != zzkf.zzc.zzc) {
                throw new GeneralSecurityException("Unsupported curve type: ".concat(String.valueOf(zzd2)));
            }
            eCParameterSpec = zzni.zzc;
        }
        KeyPair zza2 = zzyr.zza(eCParameterSpec);
        return zzki.zza(zzkl.zza(zzkfVar, ((ECPublicKey) zza2.getPublic()).getW(), num), zzzu.zza(((ECPrivateKey) zza2.getPrivate()).getS(), zzbu.zza()));
    }

    public static String zza() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public static void zza(boolean z) {
        if (zzjb.zza.zza.zza()) {
            zzlr.zza();
            zzos zza2 = zzos.zza();
            HashMap hashMap = new HashMap();
            zzkf.zza zzc2 = zzkf.zzc();
            zzkf.zzc zzcVar = zzkf.zzc.zza;
            zzkf.zza zza3 = zzc2.zza(zzcVar);
            zzkf.zzb zzbVar = zzkf.zzb.zzc;
            zzkf.zza zza4 = zza3.zza(zzbVar);
            zzkf.zze zzeVar = zzkf.zze.zzb;
            zzkf.zza zza5 = zza4.zza(zzeVar);
            zzkf.zzd zzdVar = zzkf.zzd.zza;
            zzkf.zza zza6 = zza5.zza(zzdVar);
            zzed.zza zzc3 = zzed.zze().zza(12).zzb(16).zzc(16);
            zzed.zzb zzbVar2 = zzed.zzb.zzc;
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM", zza6.zza(zzc3.zza(zzbVar2).zza()).zza());
            zzkf.zza zza7 = zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar);
            zzkf.zzd zzdVar2 = zzkf.zzd.zzc;
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_RAW", zza7.zza(zzdVar2).zza(zzed.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
            zzkf.zza zza8 = zzkf.zzc().zza(zzcVar).zza(zzbVar);
            zzkf.zze zzeVar2 = zzkf.zze.zza;
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM", zza8.zza(zzeVar2).zza(zzdVar).zza(zzed.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_GCM_RAW", zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzed.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_GCM_COMPRESSED_WITHOUT_PREFIX", zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzed.zze().zza(12).zzb(16).zzc(16).zza(zzbVar2).zza()).zza());
            zzkf.zza zza9 = zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar);
            zzdo.zza zzc4 = zzdo.zzf().zza(16).zzb(32).zzd(16).zzc(16);
            zzdo.zzc zzcVar2 = zzdo.zzc.zzc;
            zzdo.zza zza10 = zzc4.zza(zzcVar2);
            zzdo.zzb zzbVar3 = zzdo.zzb.zzc;
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zza9.zza(zza10.zza(zzbVar3).zza()).zza());
            hashMap.put("ECIES_P256_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar).zza(zzdVar2).zza(zzdo.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzcVar2).zza(zzbVar3).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256", zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar).zza(zzdo.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzcVar2).zza(zzbVar3).zza()).zza());
            hashMap.put("ECIES_P256_COMPRESSED_HKDF_HMAC_SHA256_AES128_CTR_HMAC_SHA256_RAW", zzkf.zzc().zza(zzcVar).zza(zzbVar).zza(zzeVar2).zza(zzdVar2).zza(zzdo.zzf().zza(16).zzb(32).zzd(16).zzc(16).zza(zzcVar2).zza(zzbVar3).zza()).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzov.zza().zza(zza);
            zzov.zza().zza(zzb);
            zzon.zza().zza(zze, zzkf.class);
            zznr.zza().zza(zzc, true);
            zznr.zza().zza(zzd, false);
            return;
        }
        throw new GeneralSecurityException("Registering ECIES Hybrid Encryption is not supported in FIPS mode");
    }
}
