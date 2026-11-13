package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.AbstractC4575vQ;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyStore;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;

/* loaded from: classes.dex */
final class zzno implements zzbm {
    private final SecretKey zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzno(String str, KeyStore keyStore) {
        SecretKey secretKey = (SecretKey) keyStore.getKey(str, null);
        this.zza = secretKey;
        if (secretKey == null) {
            throw new InvalidKeyException(AbstractC4575vQ.r("Keystore cannot load the key with ID: ", str));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zza(byte[] bArr, byte[] bArr2) {
        if (bArr.length < 28) {
            throw new BadPaddingException("ciphertext too short");
        }
        GCMParameterSpec gCMParameterSpec = new GCMParameterSpec(UserVerificationMethods.USER_VERIFY_PATTERN, bArr, 0, 12);
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(2, this.zza, gCMParameterSpec);
        cipher.updateAAD(bArr2);
        return cipher.doFinal(bArr, 12, bArr.length - 12);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzbm
    public final byte[] zzb(byte[] bArr, byte[] bArr2) {
        if (bArr.length > 2147483619) {
            throw new GeneralSecurityException("plaintext too long");
        }
        byte[] bArr3 = new byte[bArr.length + 28];
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(1, this.zza);
        cipher.updateAAD(bArr2);
        if (cipher.doFinal(bArr, 0, bArr.length, bArr3, 12) != bArr.length + 16) {
            throw new GeneralSecurityException("encryption failed: bytesWritten is wrong");
        }
        byte[] iv = cipher.getIV();
        if (iv.length != 12) {
            throw new GeneralSecurityException("IV has unexpected length");
        }
        System.arraycopy(iv, 0, bArr3, 0, 12);
        return bArr3;
    }
}
