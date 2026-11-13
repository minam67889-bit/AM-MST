package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC0525Tw;
import defpackage.AbstractC3634my;
import defpackage.AbstractC3865ps;
import defpackage.AbstractC4577yu;
import defpackage.C0317Lw;
import defpackage.C4189u0;
import defpackage.C4294vG;
import defpackage.FV;
import defpackage.IC;
import defpackage.InterfaceC2913du;
import defpackage.L6;
import defpackage.RunnableFutureC3681nY;
import defpackage.ScheduledFutureC4136tG;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class zzrf {
    private static final Object zza = new Object();
    private static final Object zzb = new Object();
    private final Context zzc;
    private final FV zzd;
    private final FV zze;
    private final FV zzf;
    private final FV zzg;
    private final FV zzh;
    private final Uri zzi;
    private volatile zzni zzj;
    private final Uri zzk;
    private volatile zznk zzl;

    public zzrf(Context context, final FV fv, FV fv2, FV fv3) {
        this.zzc = context;
        this.zze = fv;
        this.zzd = fv3;
        this.zzf = fv2;
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
        this.zzg = AbstractC3634my.u(new FV() { // from class: com.google.android.gms.internal.measurement.zzre
            @Override // defpackage.FV
            public final /* synthetic */ Object get() {
                return zzrf.this.zzd();
            }
        });
        this.zzh = AbstractC3634my.u(new FV() { // from class: com.google.android.gms.internal.measurement.zzqy
            @Override // defpackage.FV
            public final Object get() {
                IC ic = (IC) FV.this.get();
                ic.getClass();
                zzrd zzrdVar = zzrd.zza;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                RunnableFutureC3681nY runnableFutureC3681nY = new RunnableFutureC3681nY(zzrdVar);
                return new ScheduledFutureC4136tG(runnableFutureC3681nY, ((C4294vG) ic).c.schedule(runnableFutureC3681nY, 10000L, timeUnit));
            }
        });
    }

    private final zzni zzg() {
        zzni zzniVar;
        zzni zzniVar2 = this.zzj;
        if (zzniVar2 != null) {
            return zzniVar2;
        }
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
                                zzni zzniVar3 = (zzni) ((zzru) this.zzf.get()).zza(this.zzi, zzb2);
                                StrictMode.setThreadPolicy(threadPolicy);
                                zzniVar = zzniVar3;
                            } finally {
                                StrictMode.setThreadPolicy(threadPolicy);
                            }
                        } catch (IOException unused) {
                        }
                        this.zzj = zzniVar;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzniVar;
    }

    public final ListenableFuture zza() {
        if (!zzky.zzb(this.zzc)) {
            if (TimeUnit.HOURS.toMillis(24L) + zzg().zze() < System.currentTimeMillis()) {
                IC ic = (IC) this.zze.get();
                ic.getClass();
                AbstractC3865ps i = AbstractC3865ps.i(AbstractC4577yu.f((ListenableFuture) this.zzh.get()));
                L6 l6 = new L6() { // from class: com.google.android.gms.internal.measurement.zzrc
                    @Override // defpackage.L6
                    public final /* synthetic */ ListenableFuture apply(Object obj) {
                        return zzrf.this.zzf((Void) obj);
                    }
                };
                i.getClass();
                return AbstractC4577yu.i(i, l6, ic);
            }
        }
        return C0317Lw.b;
    }

    public final boolean zzb(boolean z, zzabz zzabzVar) {
        zzni zzg = zzg();
        return zzg.zzc() && zzg.zzi().contains(zzabzVar);
    }

    public final zzqn zzc(boolean z) {
        zzni zzg = zzg();
        return new zzqn(zzg.zzc(), AbstractC0525Tw.r(zzg.zzi()), zzg.zzb(), zzg.zzd(), (zzg.zzj() && zzg.zzk().zzb() == ((long) Build.VERSION.SDK_INT)) ? zzg.zzk().zza() : "", AbstractC0525Tw.r(zzg.zzf()), AbstractC0525Tw.r(zzg.zzh()), zzg.zza(), zzg.zzm(), zzg.zzl(), zzg.zzn());
    }

    public final ListenableFuture zzd() {
        IC ic = (IC) this.zze.get();
        ic.getClass();
        zzmj zzmjVar = (zzmj) this.zzd.get();
        zzmjVar.getClass();
        AbstractC3865ps i = AbstractC3865ps.i(zzmjVar.zzd());
        zzqz zzqzVar = zzqz.zza;
        i.getClass();
        final C4189u0 h = AbstractC4577yu.h(AbstractC4577yu.a(i, zzmk.class, zzqzVar, ic), new InterfaceC2913du() { // from class: com.google.android.gms.internal.measurement.zzra
            @Override // defpackage.InterfaceC2913du
            public final /* synthetic */ Object apply(Object obj) {
                zzrf.this.zze((zzno) obj);
                return null;
            }
        }, ic);
        h.addListener(new Runnable() { // from class: com.google.android.gms.internal.measurement.zzrb
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                try {
                    AbstractC4577yu.c(ListenableFuture.this);
                } catch (Exception e) {
                    if (Log.isLoggable("StorageInfoHandler", 3)) {
                        Log.d("StorageInfoHandler", "Failed to get storage info from GMS", e);
                    }
                }
            }
        }, ic);
        return h;
    }

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

    public final /* synthetic */ ListenableFuture zzf(Void r1) {
        return AbstractC4577yu.f((ListenableFuture) this.zzg.get());
    }
}
