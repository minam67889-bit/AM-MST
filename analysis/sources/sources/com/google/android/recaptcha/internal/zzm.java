package com.google.android.recaptcha.internal;

import android.content.ContentResolver;
import defpackage.AbstractC0440Qi;
import defpackage.InterfaceC4441tg;
import defpackage.YY;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class zzm implements zzy {

    @NotNull
    private final zzek zza;

    @NotNull
    private final ContentResolver zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzm(@NotNull zzek zzekVar, @NotNull ContentResolver contentResolver) {
        this.zza = zzekVar;
        this.zzb = contentResolver;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzy
    public final int zza() {
        return 17;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzy
    @NotNull
    public final zzek zzb() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzy
    @Nullable
    public final Object zzc(@NotNull String str, @NotNull InterfaceC4441tg interfaceC4441tg) {
        zzen zzb = zzz.zzb(this, str);
        String zza = zzap.zza(this.zzb);
        zzb.zza();
        zztf zzf = zzti.zzf();
        zztg zzf2 = zzth.zzf();
        zzf2.zzw(zza);
        zzf.zze(AbstractC0440Qi.x(zzf2.zzk()));
        return zzz.zza(this, (zzti) zzf.zzk());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzy
    @Nullable
    public final Object zzd(@NotNull zzse zzseVar, @NotNull InterfaceC4441tg interfaceC4441tg) {
        zzz.zzc(this).zza();
        return YY.a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzy
    public final void zze(@NotNull zzsr zzsrVar) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzy
    public final boolean zzf() {
        return true;
    }
}
