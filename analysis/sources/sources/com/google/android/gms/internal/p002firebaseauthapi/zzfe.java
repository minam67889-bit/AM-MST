package com.google.android.gms.internal.p002firebaseauthapi;

import defpackage.AbstractC4575vQ;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzfe implements zzbm {
    private static final byte[] zza = new byte[0];
    private static final Set<String> zzb;
    private final String zzc;
    private final zzcs zzd;
    private final zzbm zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        HashSet hashSet = new HashSet();
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesGcmSivKey");
        hashSet.add("type.googleapis.com/google.crypto.tink.AesEaxKey");
        zzb = Collections.unmodifiableSet(hashSet);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    private zzfe(zzxk zzxkVar, zzbm zzbmVar) {
        if (!zzb.contains(zzxkVar.zzf())) {
            throw new IllegalArgumentException(AbstractC4575vQ.E("Unsupported DEK key type: ", zzxkVar.zzf(), ". Only Tink AEAD key types are supported."));
        }
        this.zzc = zzxkVar.zzf();
        this.zzd = zzdg.zza(((zzxk) ((zzalt) zzxk.zza(zzxkVar).zza(zzyi.RAW).zze())).zzk());
        this.zze = zzbmVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzbm zza(zzdo zzdoVar, zzbm zzbmVar) {
        try {
            return new zzfe(zzxk.zza(zzdg.zza(zzdoVar), zzalf.zza()), zzbmVar);
        } catch (zzamd e) {
            throw new GeneralSecurityException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        zzbt zza2 = zzoy.zza().zza(this.zzd, (Integer) null);
        byte[] zzb2 = this.zze.zzb(zzpf.zza().zza((zzpf) zza2, zzbu.zza()).zzc().zzc(), zza);
        if (zzb2.length > 4096) {
            throw new GeneralSecurityException("length of encrypted DEK too large");
        }
        byte[] zzb3 = ((zzbm) zzpg.zza().zza((zzpg) zza2, zzbm.class)).zzb(bArr, bArr2);
        return ByteBuffer.allocate(zzb2.length + 4 + zzb3.length).putInt(zzb2.length).put(zzb2).put(zzb3).array();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        try {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int i = wrap.getInt();
            if (i <= 0 || i > 4096 || i > bArr.length - 4) {
                throw new GeneralSecurityException("length of encrypted DEK too large");
            }
            byte[] bArr3 = new byte[i];
            wrap.get(bArr3, 0, i);
            byte[] bArr4 = new byte[wrap.remaining()];
            wrap.get(bArr4, 0, wrap.remaining());
            return ((zzbm) zzpg.zza().zza((zzpg) zzpf.zza().zza(zzct.zza(this.zzc, zzakb.zza(this.zze.zza(bArr3, zza)), zzcw.zzb, zzcv.zzd, null), zzbu.zza()), zzbm.class)).zza(bArr4, bArr2);
        } catch (IndexOutOfBoundsException e) {
            e = e;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (NegativeArraySizeException e2) {
            e = e2;
            throw new GeneralSecurityException("invalid ciphertext", e);
        } catch (BufferUnderflowException e3) {
            e = e3;
            throw new GeneralSecurityException("invalid ciphertext", e);
        }
    }
}
