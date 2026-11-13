package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC0607Wt;
import defpackage.AbstractC3228dw;
import defpackage.C0583Vv;
import defpackage.C4231r0;
import defpackage.EF;
import defpackage.GF;
import defpackage.InterfaceC0062Bt;
import defpackage.InterfaceC4397t6;
import defpackage.Lr;
import defpackage.MU;
import defpackage.QB;
import defpackage.RunnableFutureC4351sX;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzrf {
    private static final Object zza = new Object();
    private static final Object zzb = new Object();
    private final Context zzc;
    private final MU zzd;
    private final MU zze;
    private final MU zzf;
    private final MU zzg;
    private final MU zzh;
    private final Uri zzi;
    private volatile zzni zzj;
    private final Uri zzk;
    private volatile zznk zzl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzrf(Context context, final MU mu, MU mu2, MU mu3) {
        this.zzc = context;
        this.zze = mu;
        this.zzd = mu3;
        this.zzf = mu2;
        zzrz zza2 = zzsa.zza(context);
        zza2.zzb("phenotype_storage_info");
        zza2.zzc("storage-info.pb");
        this.zzi = zza2.zzd();
        zzrz zza3 = zzsa.zza(context);
        zza3.zzb("phenotype_storage_info");
        zza3.zzc("device-encrypted-storage-info.pb");
        if (zzky.zza()) {
            zza3.zza();
        }
        this.zzk = zza3.zzd();
        this.zzg = AbstractC0363Nj.r(new MU() { // from class: com.google.android.gms.internal.measurement.zzre
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // defpackage.MU
            public final /* synthetic */ Object get() {
                return zzrf.this.zzd();
            }
        });
        this.zzh = AbstractC0363Nj.r(new MU() { // from class: com.google.android.gms.internal.measurement.zzqy
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // defpackage.MU
            public final Object get() {
                QB qb = (QB) MU.this.get();
                qb.getClass();
                zzrd zzrdVar = zzrd.zza;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                RunnableFutureC4351sX runnableFutureC4351sX = new RunnableFutureC4351sX(zzrdVar);
                return new EF(runnableFutureC4351sX, ((GF) qb).c.schedule(runnableFutureC4351sX, 10000L, timeUnit));
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzni zzg() {
        zzni zzniVar = this.zzj;
        if (zzniVar == null) {
            synchronized (zza) {
                try {
                    zzniVar = this.zzj;
                    if (zzniVar == null) {
                        zzniVar = zzni.zzp();
                        if (zzky.zzc(this.zzc)) {
                            zzss zzb2 = zzss.zzb(zzniVar);
                            StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
                            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskReads().build());
                            try {
                                try {
                                    zzni zzniVar2 = (zzni) ((zzru) this.zzf.get()).zza(this.zzi, zzb2);
                                    StrictMode.setThreadPolicy(threadPolicy);
                                    zzniVar = zzniVar2;
                                } finally {
                                    StrictMode.setThreadPolicy(threadPolicy);
                                }
                            } catch (IOException unused) {
                            }
                            this.zzj = zzniVar;
                        }
                    }
                } finally {
                }
            }
        }
        return zzniVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ListenableFuture zza() {
        if (!zzky.zzb(this.zzc)) {
            if (TimeUnit.HOURS.toMillis(24L) + zzg().zze() < System.currentTimeMillis()) {
                QB qb = (QB) this.zze.get();
                qb.getClass();
                Lr i = Lr.i(AbstractC0607Wt.f((ListenableFuture) this.zzh.get()));
                InterfaceC4397t6 interfaceC4397t6 = new InterfaceC4397t6() { // from class: com.google.android.gms.internal.measurement.zzrc
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // defpackage.InterfaceC4397t6
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzrf.this.zzf((Void) obj);
                    }
                };
                i.getClass();
                return AbstractC0607Wt.i(i, interfaceC4397t6, qb);
            }
        }
        return C0583Vv.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzb(boolean z, zzabz zzabzVar) {
        zzni zzg = zzg();
        return zzg.zzc() && zzg.zzi().contains(zzabzVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzqn zzc(boolean z) {
        zzni zzg = zzg();
        return new zzqn(zzg.zzc(), AbstractC3228dw.o(zzg.zzi()), zzg.zzb(), zzg.zzd(), (zzg.zzj() && zzg.zzk().zzb() == ((long) Build.VERSION.SDK_INT)) ? zzg.zzk().zza() : "", AbstractC3228dw.o(zzg.zzf()), AbstractC3228dw.o(zzg.zzh()), zzg.zza(), zzg.zzm(), zzg.zzl(), zzg.zzn());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ListenableFuture zzd() {
        QB qb = (QB) this.zze.get();
        qb.getClass();
        zzmj zzmjVar = (zzmj) this.zzd.get();
        zzmjVar.getClass();
        Lr i = Lr.i(zzmjVar.zzd());
        zzqz zzqzVar = zzqz.zza;
        i.getClass();
        final C4231r0 h = AbstractC0607Wt.h(AbstractC0607Wt.a(i, zzmk.class, zzqzVar, qb), new InterfaceC0062Bt() { // from class: com.google.android.gms.internal.measurement.zzra
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // defpackage.InterfaceC0062Bt
            public final /* synthetic */ Object apply(Object obj) {
                zzrf.this.zze((zzno) obj);
                return null;
            }
        }, qb);
        h.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzrb
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    AbstractC0607Wt.c(ListenableFuture.this);
                } catch (Exception e) {
                    if (Log.isLoggable("StorageInfoHandler", 3)) {
                        Log.d("StorageInfoHandler", "Failed to get storage info from GMS", e);
                    }
                }
            }
        }, qb);
        return h;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ Void zze(zzno zznoVar) {
        zzse zzseVar = new zzse();
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitDiskWrites().build());
        try {
            try {
                synchronized (zza) {
                    zzru zzruVar = (zzru) this.zzf.get();
                    Uri uri = this.zzi;
                    zzsv zzb2 = zzsv.zzb(zznoVar.zza());
                    zzb2.zzc(zzseVar);
                    zzruVar.zza(uri, zzb2);
                    this.zzj = zznoVar.zza();
                }
                synchronized (zzb) {
                    zzru zzruVar2 = (zzru) this.zzf.get();
                    Uri uri2 = this.zzk;
                    zzsv zzb3 = zzsv.zzb(zznoVar.zzb());
                    zzb3.zzc(zzseVar);
                    zzruVar2.zza(uri2, zzb3);
                    this.zzl = zznoVar.zzb();
                }
                StrictMode.setThreadPolicy(threadPolicy);
                return null;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final /* synthetic */ ListenableFuture zzf(Void r1) {
        return AbstractC0607Wt.f((ListenableFuture) this.zzg.get());
    }
}
