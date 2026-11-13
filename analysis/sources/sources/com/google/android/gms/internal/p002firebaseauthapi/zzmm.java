package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjd;
import com.google.android.gms.internal.p002firebaseauthapi.zzkq;
import com.google.android.gms.internal.p002firebaseauthapi.zzxg;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.EncodedKeySpec;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzmm {
    private static final zzpx<zzks, zzbs> zza = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmp
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzmh.zza((zzks) zzbtVar);
        }
    }, zzks.class, zzbs.class);
    private static final zzpx<zzla, zzbr> zzb = zzpx.zza(new zzpz() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmo
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzpz
        public final Object zza(zzbt zzbtVar) {
            return zzmg.zza((zzla) zzbtVar);
        }
    }, zzla.class, zzbr.class);
    private static final zzcu<zzbs> zzc = zzol.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbs.class, zzxa.zzf());
    private static final zzbw<zzbr> zzd = zzol.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbr.class, zzxg.zza.ASYMMETRIC_PUBLIC, zzxd.d_());
    private static final zzob<zzkq> zze = new zzob() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmq
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzob
        public final zzbt zza(zzcs zzcsVar, Integer num) {
            zzks zzb2;
            zzb2 = zzmm.zzb((zzkq) zzcsVar, num);
            return zzb2;
        }
    };

    public static final class zza extends EncodedKeySpec {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.security.spec.EncodedKeySpec
        public final String getFormat() {
            throw new NoSuchMethodError();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzks zzb(zzkq zzkqVar, Integer num) {
        zzaau zza2;
        zzaav zza3;
        if (zzkqVar.zze().equals(zzkq.zzf.zzd)) {
            byte[] zza4 = zzaas.zza();
            zza3 = zzaav.zza(zza4, zzbu.zza());
            zza2 = zzaau.zza(zzaas.zza(zza4));
        } else if (zzkqVar.zze().equals(zzkq.zzf.zza) || zzkqVar.zze().equals(zzkq.zzf.zzb) || zzkqVar.zze().equals(zzkq.zzf.zzc)) {
            zzzq zzd2 = zzms.zzd(zzkqVar.zze());
            KeyPair zza5 = zzzn.zza(zzzn.zza(zzd2));
            zza2 = zzaau.zza(zzzn.zza(zzd2, zzzp.UNCOMPRESSED, ((ECPublicKey) zza5.getPublic()).getW()));
            zza3 = zzaav.zza(zznu.zza(((ECPrivateKey) zza5.getPrivate()).getS(), zzms.zzb(zzkqVar.zze())), zzbu.zza());
        } else {
            if (!zzkqVar.zze().equals(zzkq.zzf.zze)) {
                throw new GeneralSecurityException("Unknown KEM ID");
            }
            Provider zza6 = zznt.zza();
            if (zza6 == null) {
                throw new GeneralSecurityException("Can't generate X-Wing key as Conscrypt is not available");
            }
            try {
                KeyPair generateKeyPair = KeyPairGenerator.getInstance("XWING", zza6).generateKeyPair();
                KeyFactory keyFactory = KeyFactory.getInstance("XWING", zza6);
                zzaau zza7 = zzaau.zza(((zza) keyFactory.getKeySpec(generateKeyPair.getPublic(), zza.class)).getEncoded());
                zza3 = zzaav.zza(((zza) keyFactory.getKeySpec(generateKeyPair.getPrivate(), zza.class)).getEncoded(), zzbu.zza());
                zza2 = zza7;
            } catch (Exception e) {
                throw new GeneralSecurityException("Can't generate X-Wing key", e);
            }
        }
        return zzks.zza(zzla.zza(zzkqVar, zza2, num), zza3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zza(boolean z) {
        if (!zzjd.zza.zza.zza()) {
            throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
        }
        zzkv.zza();
        zzpd zza2 = zzpd.zza();
        HashMap hashMap = new HashMap();
        zzkq.zzd zzc2 = zzkq.zzc();
        zzkq.zze zzeVar = zzkq.zze.zza;
        zzkq.zzd zza3 = zzc2.zza(zzeVar);
        zzkq.zzf zzfVar = zzkq.zzf.zzd;
        zzkq.zzd zza4 = zza3.zza(zzfVar);
        zzkq.zzc zzcVar = zzkq.zzc.zza;
        zzkq.zzd zza5 = zza4.zza(zzcVar);
        zzkq.zzb zzbVar = zzkq.zzb.zza;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza5.zza(zzbVar).zza());
        zzkq.zzd zzc3 = zzkq.zzc();
        zzkq.zze zzeVar2 = zzkq.zze.zzc;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc3.zza(zzeVar2).zza(zzfVar).zza(zzcVar).zza(zzbVar).zza());
        zzkq.zzd zza6 = zzkq.zzc().zza(zzeVar).zza(zzfVar).zza(zzcVar);
        zzkq.zzb zzbVar2 = zzkq.zzb.zzb;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zza6.zza(zzbVar2).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar).zza(zzcVar).zza(zzbVar2).zza());
        zzkq.zzd zza7 = zzkq.zzc().zza(zzeVar).zza(zzfVar).zza(zzcVar);
        zzkq.zzb zzbVar3 = zzkq.zzb.zzc;
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zza7.zza(zzbVar3).zza());
        hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar).zza(zzcVar).zza(zzbVar3).zza());
        zzkq.zzd zza8 = zzkq.zzc().zza(zzeVar);
        zzkq.zzf zzfVar2 = zzkq.zzf.zza;
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza8.zza(zzfVar2).zza(zzcVar).zza(zzbVar).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar2).zza(zzcVar).zza(zzbVar).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzkq.zzc().zza(zzeVar).zza(zzfVar2).zza(zzcVar).zza(zzbVar2).zza());
        hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar2).zza(zzcVar).zza(zzbVar2).zza());
        zzkq.zzd zza9 = zzkq.zzc().zza(zzeVar);
        zzkq.zzf zzfVar3 = zzkq.zzf.zzb;
        zzkq.zzd zza10 = zza9.zza(zzfVar3);
        zzkq.zzc zzcVar2 = zzkq.zzc.zzb;
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zza10.zza(zzcVar2).zza(zzbVar).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar3).zza(zzcVar2).zza(zzbVar).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzkq.zzc().zza(zzeVar).zza(zzfVar3).zza(zzcVar2).zza(zzbVar2).zza());
        hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar3).zza(zzcVar2).zza(zzbVar2).zza());
        zzkq.zzd zza11 = zzkq.zzc().zza(zzeVar);
        zzkq.zzf zzfVar4 = zzkq.zzf.zzc;
        zzkq.zzd zza12 = zza11.zza(zzfVar4);
        zzkq.zzc zzcVar3 = zzkq.zzc.zzc;
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zza12.zza(zzcVar3).zza(zzbVar).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar4).zza(zzcVar3).zza(zzbVar).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzkq.zzc().zza(zzeVar).zza(zzfVar4).zza(zzcVar3).zza(zzbVar2).zza());
        hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzkq.zzc().zza(zzeVar2).zza(zzfVar4).zza(zzcVar3).zza(zzbVar2).zza());
        zza2.zza(Collections.unmodifiableMap(hashMap));
        zzpg.zza().zza(zza);
        zzpg.zza().zza(zzb);
        zzoy.zza().zza(zze, zzkq.class);
        zzoe.zza().zza((zzbw) zzc, true);
        zzoe.zza().zza((zzbw) zzd, false);
    }
}
