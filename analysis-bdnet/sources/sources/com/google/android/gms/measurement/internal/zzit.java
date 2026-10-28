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

    public zzit(zzjd zzjdVar, zzbh zzbhVar, String str) {
        this.zza = zzbhVar;
        this.zzb = str;
        Objects.requireNonNull(zzjdVar);
        this.zzc = zzjdVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x01a8 A[Catch: all -> 0x007b, TryCatch #3 {all -> 0x007b, blocks: (B:10:0x0057, B:12:0x0062, B:15:0x007e, B:17:0x0084, B:18:0x0096, B:20:0x00ad, B:21:0x00b4, B:23:0x00be, B:24:0x00cb, B:26:0x00d5, B:27:0x00e2, B:29:0x00ed, B:30:0x00f5, B:32:0x010d, B:33:0x0110, B:35:0x012a, B:37:0x013a, B:39:0x0142, B:41:0x0148, B:42:0x014b, B:44:0x015a, B:46:0x0160, B:48:0x016a, B:51:0x0171, B:52:0x0183, B:54:0x0189, B:57:0x0193, B:58:0x01a4, B:60:0x01a8, B:63:0x01b3, B:67:0x017a, B:68:0x01d3, B:70:0x0204, B:72:0x020c, B:74:0x0212, B:76:0x022d, B:78:0x0237, B:79:0x0244, B:80:0x0256, B:82:0x025c, B:89:0x0275, B:91:0x029a, B:92:0x02a1, B:94:0x02a7, B:96:0x02db, B:98:0x0342, B:99:0x0356, B:101:0x0363, B:103:0x03bc, B:104:0x03fa, B:106:0x0400, B:109:0x0411, B:114:0x041c, B:116:0x0462, B:117:0x0470, B:119:0x0478, B:120:0x047b, B:122:0x0483, B:123:0x048c, B:126:0x04a1, B:127:0x04a4, B:137:0x0489, B:138:0x039f, B:139:0x0279, B:143:0x0526), top: B:9:0x0057, inners: #0, #1 }] */
    @Override // java.util.concurrent.Callable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* bridge */ /* synthetic */ Object call() {
        byte[] bArr;
        zzpg zzpgVar;
        zzpn zzpnVar;
        zzpg zzpgVar2;
        com.google.android.gms.internal.measurement.zzhz zzhzVar;
        zzh zzhVar;
        zzic zzicVar;
        com.google.android.gms.internal.measurement.zzic zzicVar2;
        Bundle bundle;
        String str;
        Object obj;
        boolean z;
        zzbd zza;
        long j;
        Pair pair;
        Object obj2;
        byte[] bArr2;
        zzjd zzjdVar = this.zzc;
        zzjdVar.zzL().zzaa();
        zzlp zzn = zzjdVar.zzL().zzn();
        zzn.zzg();
        zzic zzicVar3 = zzn.zzu;
        zzic.zzL();
        zzbh zzbhVar = this.zza;
        Preconditions.checkNotNull(zzbhVar);
        String str2 = this.zzb;
        Preconditions.checkNotEmpty(str2);
        String str3 = zzbhVar.zza;
        if (!"_iap".equals(str3) && !"_iapx".equals(str3)) {
            zzn.zzu.zzaW().zzj().zzc("Generating a payload for this event is not available. package_name, event_name", str2, str3);
            return null;
        }
        zzpg zzpgVar3 = zzn.zzg;
        com.google.android.gms.internal.measurement.zzhz zzi = com.google.android.gms.internal.measurement.zzib.zzi();
        zzpgVar3.zzj().zzb();
        try {
            zzh zzu = zzpgVar3.zzj().zzu(str2);
            if (zzu == null) {
                zzn.zzu.zzaW().zzj().zzb("Log and bundle not available. package_name", str2);
                bArr2 = new byte[0];
            } else {
                if (zzu.zzD()) {
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
                    zzjl zzB = zzn.zzg.zzB(str2);
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
                                    zzpgVar.zzj().zzd();
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
                        zzk.zzK(bundle2, zzpgVar4.zzj().zzV(str2));
                        zzicVar5.zzk().zzI(zza2, zzicVar5.zzc().zzd(str2));
                        bundle2.putLong("_c", 1L);
                        zzicVar5.zzaW().zzj().zza("Marking in-app purchase as real-time");
                        bundle2.putLong("_r", 1L);
                        String str4 = zzbhVar.zzc;
                        bundle2.putString("_o", str4);
                        if (zzicVar5.zzk().zzad(zzaE.zzK(), zzu.zzay())) {
                            zzicVar5.zzk().zzO(bundle2, "_dbg", 1L);
                            zzicVar5.zzk().zzO(bundle2, "_r", 1L);
                        }
                        zzaw zzj = zzpgVar4.zzj();
                        String str5 = zzbhVar.zza;
                        zzbd zzf2 = zzj.zzf(str2, str5);
                        if (zzf2 == null) {
                            zzhVar = zzu;
                            zzicVar = zzicVar5;
                            zzicVar2 = zzaE;
                            zzpgVar2 = zzpgVar5;
                            obj = null;
                            z = true;
                            zzhzVar = zzi;
                            str = str4;
                            bundle = bundle2;
                            zza = new zzbd(str2, str5, 0L, 0L, 0L, zzbhVar.zzd, 0L, null, null, null, null);
                            j = 0;
                        } else {
                            zzpgVar2 = zzpgVar5;
                            zzhzVar = zzi;
                            zzhVar = zzu;
                            zzicVar = zzicVar5;
                            zzicVar2 = zzaE;
                            bundle = bundle2;
                            str = str4;
                            obj = null;
                            z = true;
                            long j2 = zzf2.zzf;
                            zza = zzf2.zza(zzbhVar.zzd);
                            j = j2;
                        }
                        zzbd zzbdVar = zza;
                        zzpgVar4.zzj().zzh(zzbdVar);
                        com.google.android.gms.internal.measurement.zzic zzicVar6 = zzicVar2;
                        zzpg zzpgVar6 = zzpgVar2;
                        boolean z2 = z;
                        com.google.android.gms.internal.measurement.zzhz zzhzVar2 = zzhzVar;
                        zzbc zzbcVar = new zzbc(zzn.zzu, str, str2, str5, zzbhVar.zzd, 0L, j, bundle);
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
                                zzpgVar4.zzp().zzd(zzn3, zza3);
                                zzp.zzg(zzn3);
                            }
                        }
                        zzicVar6.zzg(zzp);
                        com.google.android.gms.internal.measurement.zzie zza4 = com.google.android.gms.internal.measurement.zzig.zza();
                        com.google.android.gms.internal.measurement.zzht zza5 = com.google.android.gms.internal.measurement.zzhu.zza();
                        zza5.zzb(zzbdVar.zzc);
                        zza5.zza(str5);
                        zza4.zza(zza5);
                        zzicVar6.zzap(zza4);
                        zzicVar6.zzaf(zzpgVar4.zzm().zzb(zzhVar.zzc(), Collections.EMPTY_LIST, zzicVar6.zzk(), Long.valueOf(zzp.zzn()), Long.valueOf(zzp.zzn()), false));
                        if (zzp.zzm()) {
                            zzicVar6.zzv(zzp.zzn());
                            zzicVar6.zzx(zzp.zzn());
                        }
                        long zzp2 = zzhVar.zzp();
                        if (zzp2 != 0) {
                            zzicVar6.zzA(zzp2);
                        }
                        long zzn4 = zzhVar.zzn();
                        if (zzn4 != 0) {
                            zzicVar6.zzy(zzn4);
                        } else if (zzp2 != 0) {
                            zzicVar6.zzy(zzp2);
                        }
                        String zzh = zzhVar.zzh();
                        zzair.zza();
                        if (zzicVar.zzc().zzp(str2, zzfy.zzaM) && zzh != null) {
                            zzicVar6.zzau(zzh);
                        }
                        zzhVar.zzL();
                        zzicVar6.zzZ((int) zzhVar.zzG());
                        zzicVar.zzc().zzi();
                        zzicVar6.zzO(161000L);
                        zzicVar6.zzs(zzicVar.zzba().currentTimeMillis());
                        zzicVar6.zzae(z2);
                        zzpgVar6.zzS(zzicVar6.zzK(), zzicVar6);
                        zzhzVar2.zze(zzicVar6);
                        zzh zzhVar2 = zzhVar;
                        zzhVar2.zzo(zzicVar6.zzu());
                        zzhVar2.zzq(zzicVar6.zzw());
                        zzpgVar4.zzj().zzv(zzhVar2, false, false);
                        zzpgVar4.zzj().zzc();
                        zzpgVar4.zzj().zzd();
                        try {
                            return zzpgVar4.zzp().zzv(((com.google.android.gms.internal.measurement.zzib) zzhzVar2.zzbd()).zzcd());
                        } catch (IOException e2) {
                            zzn.zzu.zzaW().zzb().zzc("Data loss. Failed to bundle and serialize. appId", zzgu.zzl(str2), e2);
                            return obj;
                        }
                    } catch (SecurityException e3) {
                        zzn.zzu.zzaW().zzj().zzb("app instance id encryption failed", e3.getMessage());
                        bArr = new byte[0];
                        zzpgVar = zzn.zzg;
                        zzpgVar.zzj().zzd();
                        return bArr;
                    }
                }
                zzn.zzu.zzaW().zzj().zzb("Log and bundle disabled. package_name", str2);
                bArr2 = new byte[0];
            }
            zzpgVar3.zzj().zzd();
            return bArr2;
        } catch (Throwable th) {
            zzn.zzg.zzj().zzd();
            throw th;
        }
    }
}
