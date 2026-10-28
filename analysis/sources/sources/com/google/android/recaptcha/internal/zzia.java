package com.google.android.recaptcha.internal;

import android.content.Context;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class zzia implements zzih {

    @NotNull
    private final Context zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzia(@NotNull Context context) {
        this.zza = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzih
    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzie.zza(this, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zzih
    @Nullable
    public final Object zza(@NotNull Object... objArr) {
        return zzap.zza(this.zza.getContentResolver());
    }
}
