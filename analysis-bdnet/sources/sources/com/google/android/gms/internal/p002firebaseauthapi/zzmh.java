package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzjb;
import com.google.android.gms.internal.p002firebaseauthapi.zzkk;
import com.google.android.gms.internal.p002firebaseauthapi.zzwj;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;
import java.security.spec.EllipticCurve;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzmh {
    private static final zzpn<zzkm, zzbs> zza = zzpn.zza(new Object() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmg
    }, zzkm.class, zzbs.class);
    private static final zzpn<zzku, zzbr> zzb = zzpn.zza(new Object() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmj
    }, zzku.class, zzbr.class);
    private static final zzcs<zzbs> zzc = zzny.zza("type.googleapis.com/google.crypto.tink.HpkePrivateKey", zzbs.class, zzwd.zzf());
    private static final zzbw<zzbr> zzd = zzny.zza("type.googleapis.com/google.crypto.tink.HpkePublicKey", zzbr.class, zzwj.zza.ASYMMETRIC_PUBLIC, zzwg.zzg());
    private static final zzno<zzkk> zze = new zzno() { // from class: com.google.android.gms.internal.firebase-auth-api.zzmi
        @Override // com.google.android.gms.internal.p002firebaseauthapi.zzno
        public final zzbt zza(zzcq zzcqVar, Integer num) {
            return zzmh.zza((zzkk) zzcqVar, num);
        }
    };

    public static /* synthetic */ zzkm zza(zzkk zzkkVar, Integer num) {
        byte[] bArr;
        zzzv zza2;
        zzzw zza3;
        if (zzkkVar.zze().equals(zzkk.zzf.zzd)) {
            byte[] zza4 = zzzt.zza();
            zza3 = zzzw.zza(zza4, zzbu.zza());
            zza2 = zzzv.zza(zzzt.zza(zza4));
        } else {
            if (!zzkkVar.zze().equals(zzkk.zzf.zza) && !zzkkVar.zze().equals(zzkk.zzf.zzb) && !zzkkVar.zze().equals(zzkk.zzf.zzc)) {
                throw new GeneralSecurityException("Unknown KEM ID");
            }
            zzyq zzc2 = zzml.zzc(zzkkVar.zze());
            KeyPair zza5 = zzyr.zza(zzyr.zza(zzc2));
            zzyt zzytVar = zzyt.UNCOMPRESSED;
            ECPoint w = ((ECPublicKey) zza5.getPublic()).getW();
            EllipticCurve curve = zzyr.zza(zzc2).getCurve();
            zzni.zza(w, curve);
            int zza6 = zzyr.zza(curve);
            int ordinal = zzytVar.ordinal();
            if (ordinal != 0) {
                if (ordinal == 1) {
                    int i = zza6 + 1;
                    bArr = new byte[i];
                    byte[] zza7 = zznh.zza(w.getAffineX());
                    System.arraycopy(zza7, 0, bArr, i - zza7.length, zza7.length);
                    bArr[0] = (byte) (w.getAffineY().testBit(0) ? 3 : 2);
                } else {
                    if (ordinal != 2) {
                        throw new GeneralSecurityException("invalid format:".concat(String.valueOf(zzytVar)));
                    }
                    int i2 = zza6 * 2;
                    bArr = new byte[i2];
                    byte[] zza8 = zznh.zza(w.getAffineX());
                    if (zza8.length > zza6) {
                        zza8 = Arrays.copyOfRange(zza8, zza8.length - zza6, zza8.length);
                    }
                    byte[] zza9 = zznh.zza(w.getAffineY());
                    if (zza9.length > zza6) {
                        zza9 = Arrays.copyOfRange(zza9, zza9.length - zza6, zza9.length);
                    }
                    System.arraycopy(zza9, 0, bArr, i2 - zza9.length, zza9.length);
                    System.arraycopy(zza8, 0, bArr, zza6 - zza8.length, zza8.length);
                }
            } else {
                int i3 = (zza6 * 2) + 1;
                bArr = new byte[i3];
                byte[] zza10 = zznh.zza(w.getAffineX());
                byte[] zza11 = zznh.zza(w.getAffineY());
                System.arraycopy(zza11, 0, bArr, i3 - zza11.length, zza11.length);
                System.arraycopy(zza10, 0, bArr, (zza6 + 1) - zza10.length, zza10.length);
                bArr[0] = 4;
            }
            zza2 = zzzv.zza(bArr);
            zza3 = zzzw.zza(zznh.zza(((ECPrivateKey) zza5.getPrivate()).getS(), zzml.zza(zzkkVar.zze())), zzbu.zza());
        }
        return zzkm.zza(zzku.zza(zzkkVar, zza2, num), zza3);
    }

    public static void zza(boolean z) {
        if (zzjb.zza.zza.zza()) {
            zzkp.zza();
            zzos zza2 = zzos.zza();
            HashMap hashMap = new HashMap();
            zzkk.zzd zzc2 = zzkk.zzc();
            zzkk.zze zzeVar = zzkk.zze.zza;
            zzkk.zzd zza3 = zzc2.zza(zzeVar);
            zzkk.zzf zzfVar = zzkk.zzf.zzd;
            zzkk.zzd zza4 = zza3.zza(zzfVar);
            zzkk.zzc zzcVar = zzkk.zzc.zza;
            zzkk.zzd zza5 = zza4.zza(zzcVar);
            zzkk.zzb zzbVar = zzkk.zzb.zza;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza5.zza(zzbVar).zza());
            zzkk.zzd zzc3 = zzkk.zzc();
            zzkk.zze zzeVar2 = zzkk.zze.zzc;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzc3.zza(zzeVar2).zza(zzfVar).zza(zzcVar).zza(zzbVar).zza());
            zzkk.zzd zza6 = zzkk.zzc().zza(zzeVar).zza(zzfVar).zza(zzcVar);
            zzkk.zzb zzbVar2 = zzkk.zzb.zzb;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zza6.zza(zzbVar2).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar).zza(zzcVar).zza(zzbVar2).zza());
            zzkk.zzd zza7 = zzkk.zzc().zza(zzeVar).zza(zzfVar).zza(zzcVar);
            zzkk.zzb zzbVar3 = zzkk.zzb.zzc;
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305", zza7.zza(zzbVar3).zza());
            hashMap.put("DHKEM_X25519_HKDF_SHA256_HKDF_SHA256_CHACHA20_POLY1305_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar).zza(zzcVar).zza(zzbVar3).zza());
            zzkk.zzd zza8 = zzkk.zzc().zza(zzeVar);
            zzkk.zzf zzfVar2 = zzkk.zzf.zza;
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM", zza8.zza(zzfVar2).zza(zzcVar).zza(zzbVar).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_128_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar2).zza(zzcVar).zza(zzbVar).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM", zzkk.zzc().zza(zzeVar).zza(zzfVar2).zza(zzcVar).zza(zzbVar2).zza());
            hashMap.put("DHKEM_P256_HKDF_SHA256_HKDF_SHA256_AES_256_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar2).zza(zzcVar).zza(zzbVar2).zza());
            zzkk.zzd zza9 = zzkk.zzc().zza(zzeVar);
            zzkk.zzf zzfVar3 = zzkk.zzf.zzb;
            zzkk.zzd zza10 = zza9.zza(zzfVar3);
            zzkk.zzc zzcVar2 = zzkk.zzc.zzb;
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM", zza10.zza(zzcVar2).zza(zzbVar).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_128_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar3).zza(zzcVar2).zza(zzbVar).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM", zzkk.zzc().zza(zzeVar).zza(zzfVar3).zza(zzcVar2).zza(zzbVar2).zza());
            hashMap.put("DHKEM_P384_HKDF_SHA384_HKDF_SHA384_AES_256_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar3).zza(zzcVar2).zza(zzbVar2).zza());
            zzkk.zzd zza11 = zzkk.zzc().zza(zzeVar);
            zzkk.zzf zzfVar4 = zzkk.zzf.zzc;
            zzkk.zzd zza12 = zza11.zza(zzfVar4);
            zzkk.zzc zzcVar3 = zzkk.zzc.zzc;
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM", zza12.zza(zzcVar3).zza(zzbVar).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_128_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar4).zza(zzcVar3).zza(zzbVar).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM", zzkk.zzc().zza(zzeVar).zza(zzfVar4).zza(zzcVar3).zza(zzbVar2).zza());
            hashMap.put("DHKEM_P521_HKDF_SHA512_HKDF_SHA512_AES_256_GCM_RAW", zzkk.zzc().zza(zzeVar2).zza(zzfVar4).zza(zzcVar3).zza(zzbVar2).zza());
            zza2.zza(Collections.unmodifiableMap(hashMap));
            zzov.zza().zza(zza);
            zzov.zza().zza(zzb);
            zzon.zza().zza(zze, zzkk.class);
            zznr.zza().zza(zzc, true);
            zznr.zza().zza(zzd, false);
            return;
        }
        throw new GeneralSecurityException("Registering HPKE Hybrid Encryption is not supported in FIPS mode");
    }
}
