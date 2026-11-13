package com.google.android.gms.internal.p002firebaseauthapi;

import android.security.keystore.KeyGenParameterSpec;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.stats.CodePackage;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.util.Arrays;
import javax.crypto.KeyGenerator;

/* loaded from: classes.dex */
public final class zznd {
    private static final Object zza = new Object();

    public static final class zza {
        public zza() {
            zznd.zza();
        }
    }

    public zznd() {
        this(new zza());
    }

    public static /* synthetic */ boolean zza() {
        return true;
    }

    public static boolean zzb(String str) {
        synchronized (zza) {
            try {
                String zza2 = zzzq.zza("android-keystore://", str);
                if (zznc.zzb(zza2)) {
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

    private zznd(zza zzaVar) {
    }

    public static zzbm zza(String str) {
        zzne zzneVar;
        try {
            synchronized (zza) {
                try {
                    zzneVar = new zzne(zzzq.zza("android-keystore://", str));
                    byte[] zza2 = zzpz.zza(10);
                    byte[] bArr = new byte[0];
                    if (!Arrays.equals(zza2, zzneVar.zza(zzneVar.zzb(zza2, bArr), bArr))) {
                        throw new KeyStoreException("cannot use Android Keystore: encryption/decryption of non-empty message and empty aad returns an incorrect result");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return zzneVar;
        } catch (IOException e) {
            throw new GeneralSecurityException(e);
        }
    }
}
