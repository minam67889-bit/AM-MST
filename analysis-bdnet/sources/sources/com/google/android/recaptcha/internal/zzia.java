package com.google.android.recaptcha.internal;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzia implements zzih {
    private final Context zza;

    public zzia(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.recaptcha.internal.zzih
    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzie.zza(this, objArr);
    }

    @Override // com.google.android.recaptcha.internal.zzih
    public final Object zza(Object... objArr) {
        return zzap.zza(this.zza.getContentResolver());
    }
}
