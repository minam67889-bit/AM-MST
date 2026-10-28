package com.google.android.gms.internal.auth;

import android.content.Context;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class zzdc {
    public static final /* synthetic */ int zzd = 0;
    private static volatile zzda zze;
    private static volatile boolean zzf;
    final zzcz zzb;
    final String zzc;
    private final Object zzj;
    private volatile int zzk = -1;
    private volatile Object zzl;
    private final boolean zzm;
    private static final Object zza = new Object();
    private static final AtomicReference zzg = new AtomicReference();
    private static final zzde zzh = new zzde(new Object() { // from class: com.google.android.gms.internal.auth.zzcu
    }, null);
    private static final AtomicInteger zzi = new AtomicInteger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ zzdc(zzcz zzczVar, String str, Object obj, boolean z, zzdb zzdbVar) {
        if (zzczVar.zzb == null) {
            throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
        }
        this.zzb = zzczVar;
        this.zzc = str;
        this.zzj = obj;
        this.zzm = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zzd() {
        zzi.incrementAndGet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void zze(final Context context) {
        if (zze == null) {
            Object obj = zza;
            synchronized (obj) {
                try {
                    if (zze == null) {
                        synchronized (obj) {
                            zzda zzdaVar = zze;
                            Context applicationContext = context.getApplicationContext();
                            if (applicationContext != null) {
                                context = applicationContext;
                            }
                            if (zzdaVar != null) {
                                if (zzdaVar.zza() != context) {
                                }
                            }
                            zzcg.zzd();
                            zzdd.zzc();
                            zzco.zze();
                            zze = new zzcd(context, zzdn.zza(new zzdj() { // from class: com.google.android.gms.internal.auth.zzct
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // com.google.android.gms.internal.auth.zzdj
                                public final Object zza() {
                                    Context context2 = context;
                                    int i = zzdc.zzd;
                                    return zzcp.zza(context2);
                                }
                            }));
                            zzi.incrementAndGet();
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                } finally {
                }
            }
        }
    }

    public abstract Object zza(Object obj);

    /* JADX WARN: Removed duplicated region for block: B:43:0x00a2 A[Catch: all -> 0x0054, TryCatch #0 {all -> 0x0054, blocks: (B:12:0x001c, B:14:0x0020, B:16:0x0026, B:18:0x002f, B:20:0x003d, B:22:0x0069, B:24:0x0073, B:27:0x00a4, B:29:0x00b4, B:31:0x00c8, B:32:0x00cb, B:33:0x00cf, B:34:0x007c, B:36:0x0082, B:39:0x0094, B:41:0x009a, B:43:0x00a2, B:44:0x0092, B:48:0x0059, B:49:0x00d4, B:50:0x00d9, B:51:0x00da), top: B:11:0x001c }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzb() {
        zzcl zza2;
        Object zzb;
        if (!this.zzm && this.zzc == null) {
            throw new NullPointerException("flagName must not be null");
        }
        int i = zzi.get();
        if (this.zzk < i) {
            synchronized (this) {
                try {
                    if (this.zzk < i) {
                        zzda zzdaVar = zze;
                        if (zzdaVar == null) {
                            throw new IllegalStateException("Must call PhenotypeFlag.init() first");
                        }
                        zzcz zzczVar = this.zzb;
                        boolean z = zzczVar.zzf;
                        if (zzczVar.zzb == null) {
                            Context zza3 = zzdaVar.zza();
                            String str = this.zzb.zza;
                            zza2 = zzdd.zza(zza3, null, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdc.zzd();
                                }
                            });
                        } else if (zzcq.zza(zzdaVar.zza(), this.zzb.zzb)) {
                            boolean z2 = this.zzb.zzh;
                            zza2 = zzcg.zza(zzdaVar.zza().getContentResolver(), this.zzb.zzb, new Runnable() { // from class: com.google.android.gms.internal.auth.zzcs
                                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    zzdc.zzd();
                                }
                            });
                        } else {
                            zza2 = null;
                        }
                        Object zza4 = (zza2 == null || (zzb = zza2.zzb(zzc())) == null) ? null : zza(zzb);
                        if (zza4 == null) {
                            if (!this.zzb.zze) {
                                String zzb2 = zzco.zza(zzdaVar.zza()).zzb(this.zzb.zze ? null : this.zzc);
                                if (zzb2 != null) {
                                    zza4 = zza(zzb2);
                                    if (zza4 == null) {
                                        zza4 = this.zzj;
                                    }
                                }
                            }
                            zza4 = null;
                            if (zza4 == null) {
                            }
                        }
                        zzdh zzdhVar = (zzdh) zzdaVar.zzb().zza();
                        if (zzdhVar.zzb()) {
                            zzci zzciVar = (zzci) zzdhVar.zza();
                            zzcz zzczVar2 = this.zzb;
                            String zza5 = zzciVar.zza(zzczVar2.zzb, null, zzczVar2.zzd, this.zzc);
                            zza4 = zza5 == null ? this.zzj : zza(zza5);
                        }
                        this.zzl = zza4;
                        this.zzk = i;
                    }
                } finally {
                }
            }
        }
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzc() {
        String str = this.zzb.zzd;
        return this.zzc;
    }
}
