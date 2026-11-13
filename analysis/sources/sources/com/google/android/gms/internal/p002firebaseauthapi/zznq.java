package com.google.android.gms.internal.p002firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.util.Arrays;
import java.util.Locale;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public final class zznq implements zzco {
    private static final Object zza = new Object();

    public static final class zza {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public zza() {
            zznq.zza();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zznq() {
        this(new zza());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean zzc(String str) {
        synchronized (zza) {
            try {
                String zza2 = zzaap.zza("android-keystore://", str);
                if (zznp.zzb(zza2)) {
                    return false;
                }
                KeyGenParameterSpec build = new KeyGenParameterSpec.Builder(zza2, 3).setKeySize(UserVerificationMethods.USER_VERIFY_HANDPRINT).setBlockModes(CodePackage.GCM).setEncryptionPaddings("NoPadding").build();
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES", "AndroidKeyStore");
                keyGenerator.init(build);
                keyGenerator.generateKey();
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzco
    public final zzbm zza(String str) {
        zznr zznrVar;
        try {
            synchronized (zza) {
                try {
                    zznrVar = new zznr(zzaap.zza("android-keystore://", str));
                    byte[] zza2 = zzqm.zza(10);
                    byte[] bArr = new byte[0];
                    if (!Arrays.equals(zza2, zznrVar.zza(zznrVar.zzb(zza2, bArr), bArr))) {
                        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zznrVar;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzco
    public final boolean zzb(String str) {
        return str.toLowerCase(Locale.US).startsWith("android-keystore://");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zznq(zza zzaVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ boolean zza() {
        return true;
    }
}
