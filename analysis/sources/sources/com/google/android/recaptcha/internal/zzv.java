package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import defpackage.AbstractC0363Nj;
import defpackage.AbstractC0467Rj;
import defpackage.AbstractC3354fY;
import defpackage.AbstractC3518he;
import defpackage.AbstractC3595ie;
import defpackage.AbstractC4331sD;
import defpackage.C0307Le;
import defpackage.C0497Sn;
import defpackage.EnumC0516Tg;
import defpackage.InterfaceC0490Sg;
import defpackage.InterfaceC4441tg;
import defpackage.JN;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public final class zzv extends zze {

    @NotNull
    private final zzek zza;

    @NotNull
    private final List zzb;
    private zzle zzc;

    @NotNull
    private final Map zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ zzv(Context context, zzek zzekVar, zzbi zzbiVar, List list, int i, AbstractC0467Rj abstractC0467Rj) {
        zzab zzabVar = new zzab(zzekVar.zza());
        zzp zzpVar = new zzp(zzekVar.zza());
        zzm zzmVar = new zzm(zzekVar.zza(), context.getContentResolver());
        zzn zznVar = new zzn(zzekVar.zza());
        zzek zza = zzekVar.zza();
        InterfaceC0490Sg zzc = zzbiVar.zzc();
        List T = AbstractC3518he.T(zzabVar, zzpVar, zzmVar, zznVar, new zzae(zza, context, zzc, new zzan(context, zzc, zza, IntegrityManagerFactory.createStandard(context), 28800000L), new zzbs(GoogleApiAvailabilityLight.getInstance())));
        this.zza = zzekVar;
        this.zzb = T;
        this.zzd = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzsi zzq(String str) {
        Map map;
        List list = (List) this.zzd.remove(str);
        if (list != null) {
            List<zzaa> list2 = list;
            int R = AbstractC4331sD.R(AbstractC3595ie.W(list2, 10));
            if (R < 16) {
                R = 16;
            }
            map = new LinkedHashMap(R);
            for (zzaa zzaaVar : list2) {
                map.put(Integer.valueOf(zzaaVar.zzb()), zzaaVar);
            }
        } else {
            map = C0497Sn.a;
        }
        zzsz zzs = zzs(map, str);
        zzsh zzf = zzsi.zzf();
        zzf.zze(str);
        zzsf zzf2 = zzsg.zzf();
        byte[] zzd = zzs.zzd();
        zzf2.zze(zzkh.zzh().zzi(zzd, 0, zzd.length));
        zzf.zzf(zzf2);
        return (zzsi) zzf.zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzsx zzr(zzaa zzaaVar) {
        zzle zzleVar;
        zzsv zzf = zzsx.zzf();
        zzf.zzq(3);
        if (zzaaVar instanceof zzx) {
            zzti zza = ((zzx) zzaaVar).zza();
            zzle zzleVar2 = this.zzc;
            zzleVar = zzleVar2 != null ? zzleVar2 : null;
            byte[] zzd = zza.zzd();
            zzf.zzf(zzcf.zza(zzkh.zzh().zzi(zzd, 0, zzd.length), zzleVar));
        } else {
            if (!(zzaaVar instanceof zzw)) {
                throw new C0307Le();
            }
            zzte zza2 = ((zzw) zzaaVar).zza();
            zzle zzleVar3 = this.zzc;
            zzleVar = zzleVar3 != null ? zzleVar3 : null;
            byte[] zzd2 = zza2.zzd();
            zzf.zze(zzcf.zza(zzkh.zzh().zzi(zzd2, 0, zzd2.length), zzleVar));
        }
        return (zzsx) zzf.zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzsz zzs(Map map, String str) {
        zzsy zzf = zzsz.zzf();
        zzf.zzq(str);
        List list = this.zzb;
        ArrayList<zzy> arrayList = new ArrayList();
        for (Object obj : list) {
            if (((zzy) obj).zzf()) {
                arrayList.add(obj);
            }
        }
        for (zzy zzyVar : arrayList) {
            if (!map.containsKey(Integer.valueOf(zzyVar.zza()))) {
                int zza = zzyVar.zza();
                zztd zzf2 = zzte.zzf();
                zzf2.zzf(zza);
                zzf2.zzr(13);
                zzf2.zzq(27);
                zzf.zzf(zzr(new zzw(zza, (zzte) zzf2.zzk())));
            }
        }
        Collection values = map.values();
        ArrayList arrayList2 = new ArrayList(AbstractC3595ie.W(values, 10));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList2.add(zzr((zzaa) it.next()));
        }
        zzf.zze(arrayList2);
        return (zzsz) zzf.zzk();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zze
    @NotNull
    public final zzen zza(@NotNull String str) {
        zzek zzekVar = this.zza;
        zzekVar.zzc(str);
        return zzekVar.zzf(35);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zze
    @NotNull
    public final zzen zzb() {
        zzek zzekVar = this.zza;
        zzekVar.zzc(zzekVar.zzd());
        return zzekVar.zzf(34);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zze
    @Nullable
    public final Object zzd(@NotNull String str, @NotNull InterfaceC4441tg interfaceC4441tg) {
        return zzq(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zze
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzf(@NotNull String str, @NotNull InterfaceC4441tg interfaceC4441tg) {
        zzq zzqVar;
        int i;
        if (interfaceC4441tg instanceof zzq) {
            zzqVar = (zzq) interfaceC4441tg;
            int i2 = zzqVar.zzc;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zzqVar.zzc = i2 - Integer.MIN_VALUE;
                Object obj = zzqVar.zza;
                EnumC0516Tg enumC0516Tg = EnumC0516Tg.a;
                i = zzqVar.zzc;
                if (i != 0) {
                    AbstractC3354fY.n0(obj);
                    zzs zzsVar = new zzs(this, str, null);
                    zzqVar.zzc = 1;
                    obj = AbstractC0363Nj.d(zzsVar, zzqVar);
                    if (obj == enumC0516Tg) {
                        return enumC0516Tg;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC3354fY.n0(obj);
                }
                return ((JN) obj).a;
            }
        }
        zzqVar = new zzq(this, interfaceC4441tg);
        Object obj2 = zzqVar.zza;
        EnumC0516Tg enumC0516Tg2 = EnumC0516Tg.a;
        i = zzqVar.zzc;
        if (i != 0) {
        }
        return ((JN) obj2).a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zze
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzh(@NotNull zzsc zzscVar, @NotNull InterfaceC4441tg interfaceC4441tg) {
        zzt zztVar;
        int i;
        if (interfaceC4441tg instanceof zzt) {
            zztVar = (zzt) interfaceC4441tg;
            int i2 = zztVar.zzc;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zztVar.zzc = i2 - Integer.MIN_VALUE;
                Object obj = zztVar.zza;
                EnumC0516Tg enumC0516Tg = EnumC0516Tg.a;
                i = zztVar.zzc;
                if (i != 0) {
                    AbstractC3354fY.n0(obj);
                    zzu zzuVar = new zzu(zzscVar, this, null);
                    zztVar.zzc = 1;
                    obj = AbstractC0363Nj.d(zzuVar, zztVar);
                    if (obj == enumC0516Tg) {
                        return enumC0516Tg;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC3354fY.n0(obj);
                }
                return ((JN) obj).a;
            }
        }
        zztVar = new zzt(this, interfaceC4441tg);
        Object obj2 = zztVar.zza;
        EnumC0516Tg enumC0516Tg2 = EnumC0516Tg.a;
        i = zztVar.zzc;
        if (i != 0) {
        }
        return ((JN) obj2).a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.recaptcha.internal.zze
    public final void zzk(@NotNull zzsr zzsrVar) {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            ((zzy) it.next()).zze(zzsrVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @NotNull
    public final Map zzo() {
        return this.zzd;
    }
}
