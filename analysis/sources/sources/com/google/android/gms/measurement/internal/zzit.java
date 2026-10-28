package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzair;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
final class zzit implements Callable {
    final /* synthetic */ zzbh zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzjd zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x01a9 A[Catch: all -> 0x007d, TryCatch #6 {all -> 0x007d, blocks: (B:10:0x0058, B:12:0x0063, B:13:0x0072, B:17:0x0081, B:19:0x0087, B:20:0x0097, B:22:0x00ae, B:23:0x00b5, B:25:0x00bf, B:26:0x00cc, B:28:0x00d6, B:29:0x00e3, B:31:0x00ee, B:32:0x00f6, B:34:0x010e, B:35:0x0111, B:37:0x012b, B:39:0x013b, B:41:0x0143, B:43:0x0149, B:44:0x014c, B:46:0x015b, B:48:0x0161, B:50:0x016b, B:53:0x0172, B:54:0x0184, B:56:0x018a, B:59:0x0194, B:60:0x01a5, B:62:0x01a9, B:65:0x01b4, B:68:0x017b, B:69:0x01d1, B:71:0x0202, B:73:0x020a, B:75:0x0210, B:77:0x022d, B:79:0x0237, B:80:0x0244, B:81:0x0256, B:83:0x025c, B:90:0x0274, B:92:0x029d, B:93:0x02a4, B:95:0x02aa, B:97:0x02de, B:155:0x0278), top: B:9:0x0058, inners: #0 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object call() {
        zzlp zzlpVar;
        byte[] bArr;
        zzpg zzpgVar;
        zzpn zzpnVar;
        zzpg zzpgVar2;
        zzh zzhVar;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        Bundle bundle;
        String str;
        zzic zzicVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        String str2;
        Object obj;
        zzbd zza;
        long j;
        zzaw zzj;
        Pair pair;
        Object obj2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzlp zzn = zzjdVar.zzL().zzn();
        zzn.zzg();
        zzic zzicVar3 = zzn.zzu;
        zzic.zzL();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str3 = this.zzb;
        Preconditions.checkNotEmpty(str3);
        String str4 = zzbhVar.zza;
        if (!"_iap".equals(str4) && !"_iapx".equals(str4)) {
            zzn.zzu.zzaW().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str3, str4);
            return null;
        }
        zzpg zzpgVar3 = zzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzi = com.google.android.gms.internal.measurement.zzib.zzi();
        zzpgVar3.zzj().zzb();
        try {
            zzh zzu = zzpgVar3.zzj().zzu(str3);
            if (zzu == null) {
                zzn.zzu.zzaW().zzj().zzb("Log and bundle not available. package_name", str3);
            } else if (zzu.zzD()) {
                com.google.android.gms.internal.measurement.zzic zzaE = com.google.android.gms.internal.measurement.zzid.zzaE();
                zzaE.zza(1);
                zzaE.zzC("android");
                if (!TextUtils.isEmpty(zzu.zzc())) {
                    zzaE.zzL(zzu.zzc());
                }
                if (!TextUtils.isEmpty(zzu.zzv())) {
                    zzaE.zzJ((String) Preconditions.checkNotNull(zzu.zzv()));
                }
                if (!TextUtils.isEmpty(zzu.zzr())) {
                    zzaE.zzM((String) Preconditions.checkNotNull(zzu.zzr()));
                }
                if (zzu.zzt() != -2147483648L) {
                    zzaE.zzaj((int) zzu.zzt());
                }
                zzaE.zzN(zzu.zzx());
                zzaE.zzar(zzu.zzB());
                String zzf = zzu.zzf();
                if (!TextUtils.isEmpty(zzf)) {
                    zzaE.zzad(zzf);
                }
                zzaE.zzay(zzu.zzak());
                zzjl zzB = zzn.zzg.zzB(str3);
                zzaE.zzY(zzu.zzz());
                if (zzicVar3.zzB() && zzn.zzu.zzc().zzC(zzaE.zzK()) && zzB.zzo(zzjk.AD_STORAGE) && !TextUtils.isEmpty(null)) {
                    zzaE.zzam(null);
                }
                zzaE.zzat(zzB.zzk());
                zzjk zzjkVar = zzjk.AD_STORAGE;
                if (zzB.zzo(zzjkVar) && zzu.zzac()) {
                    zznn zzq = zzpgVar3.zzq();
                    if (zzB.zzo(zzjkVar) && zzu.zzac()) {
                        pair = zzq.zzd(zzu.zzc());
                        if (zzu.zzac() && !TextUtils.isEmpty((CharSequence) pair.first)) {
                            try {
                                zzaE.zzQ(zzlp.zzc((String) pair.first, Long.toString(zzbhVar.zzd)));
                                obj2 = pair.second;
                                if (obj2 != null) {
                                    zzaE.zzT(((Boolean) obj2).booleanValue());
                                }
                            } catch (SecurityException e) {
                                zzn.zzu.zzaW().zzj().zzb("Resettable device id encryption failed", e.getMessage());
                                bArr = new byte[0];
                                zzpgVar = zzn.zzg;
                                zzj = zzpgVar.zzj();
                                zzj.zzd();
                                return bArr;
                            }
                        }
                    }
                    pair = new Pair("", Boolean.FALSE);
                    if (zzu.zzac()) {
                        zzaE.zzQ(zzlp.zzc((String) pair.first, Long.toString(zzbhVar.zzd)));
                        obj2 = pair.second;
                        if (obj2 != null) {
                        }
                    }
                }
                zzic zzicVar4 = zzn.zzu;
                zzicVar4.zzu().zzw();
                zzaE.zzF(Build.MODEL);
                zzicVar4.zzu().zzw();
                zzaE.zzE(Build.VERSION.RELEASE);
                zzaE.zzI((int) zzicVar4.zzu().zzb());
                zzaE.zzH(zzicVar4.zzu().zzc());
                try {
                    if (zzB.zzo(zzjk.ANALYTICS_STORAGE) && zzu.zzd() != null) {
                        zzaE.zzW(zzlp.zzc((String) Preconditions.checkNotNull(zzu.zzd()), Long.toString(zzbhVar.zzd)));
                    }
                    if (!TextUtils.isEmpty(zzu.zzl())) {
                        zzaE.zzah((String) Preconditions.checkNotNull(zzu.zzl()));
                    }
                    String zzc = zzu.zzc();
                    zzpg zzpgVar4 = zzn.zzg;
                    List zzn2 = zzpgVar4.zzj().zzn(zzc);
                    Iterator it = zzn2.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            zzpnVar = null;
                            break;
                        }
                        zzpnVar = (zzpn) it.next();
                        if ("_lte".equals(zzpnVar.zzc)) {
                            break;
                        }
                    }
                    if (zzpnVar == null || zzpnVar.zze == null) {
                        zzpn zzpnVar2 = new zzpn(zzc, "auto", "_lte", zzn.zzu.zzba().currentTimeMillis(), 0L);
                        zzn2.add(zzpnVar2);
                        zzpgVar4.zzj().zzl(zzpnVar2);
                    }
                    com.google.android.gms.internal.measurement.zziu[] zziuVarArr = new com.google.android.gms.internal.measurement.zziu[zzn2.size()];
                    for (int i = 0; i < zzn2.size(); i++) {
                        com.google.android.gms.internal.measurement.zzit zzm = com.google.android.gms.internal.measurement.zziu.zzm();
                        zzm.zzb(((zzpn) zzn2.get(i)).zzc);
                        zzm.zza(((zzpn) zzn2.get(i)).zzd);
                        zzpgVar4.zzp().zzc(zzm, ((zzpn) zzn2.get(i)).zze);
                        zziuVarArr[i] = (com.google.android.gms.internal.measurement.zziu) zzm.zzbd();
                    }
                    zzaE.zzq(Arrays.asList(zziuVarArr));
                    zzpg zzpgVar5 = zzn.zzg;
                    zzpgVar5.zzI(zzu, zzaE);
                    zzpgVar5.zzJ(zzu, zzaE);
                    zzgv zza2 = zzgv.zza(zzbhVar);
                    zzic zzicVar5 = zzn.zzu;
                    zzpp zzk = zzicVar5.zzk();
                    Bundle bundle2 = zza2.zze;
                    zzk.zzK(bundle2, zzpgVar4.zzj().zzV(str3));
                    zzicVar5.zzk().zzI(zza2, zzicVar5.zzc().zzd(str3));
                    zzlp zzlpVar2 = zzn;
                    try {
                        bundle2.putLong("_c", 1L);
                        zzicVar5.zzaW().zzj().zza("Marking in-app purchase as real-time");
                        bundle2.putLong("_r", 1L);
                        String str5 = zzbhVar.zzc;
                        bundle2.putString("_o", str5);
                        if (zzicVar5.zzk().zzad(zzaE.zzK(), zzu.zzay())) {
                            zzicVar5.zzk().zzO(bundle2, "_dbg", 1L);
                            zzicVar5.zzk().zzO(bundle2, "_r", 1L);
                        }
                        zzaw zzj2 = zzpgVar4.zzj();
                        String str6 = zzbhVar.zza;
                        zzbd zzf2 = zzj2.zzf(str3, str6);
                        if (zzf2 == null) {
                            bundle = bundle2;
                            str = str5;
                            zzicVar = zzicVar5;
                            zzicVar2 = zzaE;
                            zzpgVar2 = zzpgVar4;
                            zzhzVar = zzi;
                            str2 = str3;
                            zzhVar = zzu;
                            obj = null;
                            zza = new zzbd(str3, str6, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            zzpgVar2 = zzpgVar4;
                            zzhVar = zzu;
                            zzhzVar = zzi;
                            bundle = bundle2;
                            str = str5;
                            zzicVar = zzicVar5;
                            zzicVar2 = zzaE;
                            str2 = str3;
                            obj = null;
                            long j2 = zzf2.zzf;
                            zza = zzf2.zza(zzbhVar.zzd);
                            j = j2;
                        }
                        zzpgVar2.zzj().zzh(zza);
                        try {
                            zzic zzicVar6 = zzlpVar2.zzu;
                            zzlpVar2 = zzlpVar2;
                            zzbc zzbcVar = new zzbc(zzicVar6, str, str2, str6, zzbhVar.zzd, 0L, j, bundle);
                            com.google.android.gms.internal.measurement.zzhr zzp = com.google.android.gms.internal.measurement.zzhs.zzp();
                            zzp.zzo(zzbcVar.zzd);
                            zzp.zzl(zzbcVar.zzb);
                            zzp.zzq(zzbcVar.zzf);
                            zzbf zzbfVar = zzbcVar.zzg;
                            zzbe zzbeVar = new zzbe(zzbfVar);
                            while (zzbeVar.hasNext()) {
                                String next = zzbeVar.next();
                                com.google.android.gms.internal.measurement.zzhv zzn3 = com.google.android.gms.internal.measurement.zzhw.zzn();
                                zzn3.zzb(next);
                                Object zza3 = zzbfVar.zza(next);
                                if (zza3 != null) {
                                    zzpgVar2.zzp().zzd(zzn3, zza3);
                                    zzp.zzg(zzn3);
                                }
                            }
                            zzicVar2.zzg(zzp);
                            com.google.android.gms.internal.measurement.zzie zza4 = com.google.android.gms.internal.measurement.zzig.zza();
                            com.google.android.gms.internal.measurement.zzht zza5 = com.google.android.gms.internal.measurement.zzhu.zza();
                            zza5.zzb(zza.zzc);
                            zza5.zza(str6);
                            zza4.zza(zza5);
                            zzicVar2.zzap(zza4);
                            zzicVar2.zzaf(zzpgVar2.zzm().zzb(zzhVar.zzc(), Collections.emptyList(), zzicVar2.zzk(), Long.valueOf(zzp.zzn()), Long.valueOf(zzp.zzn()), false));
                            if (zzp.zzm()) {
                                zzicVar2.zzv(zzp.zzn());
                                zzicVar2.zzx(zzp.zzn());
                            }
                            long zzp2 = zzhVar.zzp();
                            if (zzp2 != 0) {
                                zzicVar2.zzA(zzp2);
                            }
                            long zzn4 = zzhVar.zzn();
                            if (zzn4 != 0) {
                                zzicVar2.zzy(zzn4);
                            } else if (zzp2 != 0) {
                                zzicVar2.zzy(zzp2);
                            }
                            String zzh = zzhVar.zzh();
                            zzair.zza();
                            String str7 = str2;
                            if (zzicVar.zzc().zzp(str7, zzfy.zzaM) && zzh != null) {
                                zzicVar2.zzau(zzh);
                            }
                            zzhVar.zzL();
                            zzicVar2.zzZ((int) zzhVar.zzG());
                            zzicVar.zzc().zzi();
                            zzicVar2.zzO(161000L);
                            zzicVar2.zzs(zzicVar.zzba().currentTimeMillis());
                            zzicVar2.zzae(true);
                            zzpgVar5.zzS(zzicVar2.zzK(), zzicVar2);
                            com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                            zzhzVar2.zze(zzicVar2);
                            zzh zzhVar2 = zzhVar;
                            zzhVar2.zzo(zzicVar2.zzu());
                            zzhVar2.zzq(zzicVar2.zzw());
                            zzpgVar2.zzj().zzv(zzhVar2, false, false);
                            zzpgVar2.zzj().zzc();
                            zzpgVar2.zzj().zzd();
                            try {
                                return zzpgVar2.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbd()).zzcd());
                            } catch (IOException e2) {
                                zzlpVar2.zzu.zzaW().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str7), e2);
                                return obj;
                            }
                        } catch (Throwable th) {
                            th = th;
                            zzlpVar = zzlpVar2;
                            zzlpVar.zzg.zzj().zzd();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        zzlpVar = zzlpVar2;
                    }
                } catch (SecurityException e3) {
                    zzlpVar = zzn;
                    try {
                        zzlpVar.zzu.zzaW().zzj().zzb("app instance id encryption failed", e3.getMessage());
                        bArr = new byte[0];
                        zzpgVar = zzlpVar.zzg;
                        zzj = zzpgVar.zzj();
                        zzj.zzd();
                        return bArr;
                    } catch (Throwable th3) {
                        th = th3;
                        zzlpVar.zzg.zzj().zzd();
                        throw th;
                    }
                }
            } else {
                zzn.zzu.zzaW().zzj().zzb("Log and bundle disabled. package_name", str3);
            }
            bArr = new byte[0];
            zzj = zzpgVar3.zzj();
            zzj.zzd();
            return bArr;
        } catch (Throwable th4) {
            th = th4;
            zzlpVar = zzn;
            zzlpVar.zzg.zzj().zzd();
            throw th;
        }
    }
}
