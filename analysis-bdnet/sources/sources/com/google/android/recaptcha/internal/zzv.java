package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.play.core.integrity.IntegrityManagerFactory;
import defpackage.AbstractC0538Uj;
import defpackage.AbstractC0616Xj;
import defpackage.AbstractC3264iE;
import defpackage.AbstractC4322ve;
import defpackage.AbstractC4401we;
import defpackage.C0742af;
import defpackage.C3227ho;
import defpackage.EnumC3299ih;
import defpackage.GO;
import defpackage.InterfaceC0198Hg;
import defpackage.InterfaceC3220hh;
import defpackage.W80;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzv extends zze {
    private final zzek zza;
    private final List zzb;
    private zzle zzc;
    private final Map zzd;

    public /* synthetic */ zzv(Context context, zzek zzekVar, zzbi zzbiVar, List list, int i, AbstractC0616Xj abstractC0616Xj) {
        zzab zzabVar = new zzab(zzekVar.zza());
        zzp zzpVar = new zzp(zzekVar.zza());
        zzm zzmVar = new zzm(zzekVar.zza(), context.getContentResolver());
        zzn zznVar = new zzn(zzekVar.zza());
        zzek zza = zzekVar.zza();
        InterfaceC3220hh zzc = zzbiVar.zzc();
        List k0 = AbstractC4322ve.k0(zzabVar, zzpVar, zzmVar, zznVar, new zzae(zza, context, zzc, new zzan(context, zzc, zza, IntegrityManagerFactory.createStandard(context), 28800000L), new zzbs(GoogleApiAvailabilityLight.getInstance())));
        this.zza = zzekVar;
        this.zzb = k0;
        this.zzd = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzsi zzq(String str) {
        Map map;
        List list = (List) this.zzd.remove(str);
        if (list != null) {
            List<zzaa> list2 = list;
            int E = AbstractC3264iE.E(AbstractC4401we.n0(list2, 10));
            if (E < 16) {
                E = 16;
            }
            map = new LinkedHashMap(E);
            for (zzaa zzaaVar : list2) {
                map.put(Integer.valueOf(zzaaVar.zzb()), zzaaVar);
            }
        } else {
            map = C3227ho.a;
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
                throw new C0742af();
            }
            zzte zza2 = ((zzw) zzaaVar).zza();
            zzle zzleVar3 = this.zzc;
            zzleVar = zzleVar3 != null ? zzleVar3 : null;
            byte[] zzd2 = zza2.zzd();
            zzf.zze(zzcf.zza(zzkh.zzh().zzi(zzd2, 0, zzd2.length), zzleVar));
        }
        return (zzsx) zzf.zzk();
    }

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
        ArrayList arrayList2 = new ArrayList(AbstractC4401we.n0(values, 10));
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList2.add(zzr((zzaa) it.next()));
        }
        zzf.zze(arrayList2);
        return (zzsz) zzf.zzk();
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final zzen zza(String str) {
        zzek zzekVar = this.zza;
        zzekVar.zzc(str);
        return zzekVar.zzf(35);
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final zzen zzb() {
        zzek zzekVar = this.zza;
        zzekVar.zzc(zzekVar.zzd());
        return zzekVar.zzf(34);
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final Object zzd(String str, InterfaceC0198Hg interfaceC0198Hg) {
        return zzq(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzf(String str, InterfaceC0198Hg interfaceC0198Hg) {
        zzq zzqVar;
        int i;
        if (interfaceC0198Hg instanceof zzq) {
            zzqVar = (zzq) interfaceC0198Hg;
            int i2 = zzqVar.zzc;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zzqVar.zzc = i2 - Integer.MIN_VALUE;
                Object obj = zzqVar.zza;
                EnumC3299ih enumC3299ih = EnumC3299ih.a;
                i = zzqVar.zzc;
                if (i != 0) {
                    W80.U(obj);
                    zzs zzsVar = new zzs(this, str, null);
                    zzqVar.zzc = 1;
                    obj = AbstractC0538Uj.m(zzsVar, zzqVar);
                    if (obj == enumC3299ih) {
                        return enumC3299ih;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W80.U(obj);
                }
                return ((GO) obj).a;
            }
        }
        zzqVar = new zzq(this, interfaceC0198Hg);
        Object obj2 = zzqVar.zza;
        EnumC3299ih enumC3299ih2 = EnumC3299ih.a;
        i = zzqVar.zzc;
        if (i != 0) {
        }
        return ((GO) obj2).a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // com.google.android.recaptcha.internal.zze
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzh(zzsc zzscVar, InterfaceC0198Hg interfaceC0198Hg) {
        zzt zztVar;
        int i;
        if (interfaceC0198Hg instanceof zzt) {
            zztVar = (zzt) interfaceC0198Hg;
            int i2 = zztVar.zzc;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zztVar.zzc = i2 - Integer.MIN_VALUE;
                Object obj = zztVar.zza;
                EnumC3299ih enumC3299ih = EnumC3299ih.a;
                i = zztVar.zzc;
                if (i != 0) {
                    W80.U(obj);
                    zzu zzuVar = new zzu(zzscVar, this, null);
                    zztVar.zzc = 1;
                    obj = AbstractC0538Uj.m(zzuVar, zztVar);
                    if (obj == enumC3299ih) {
                        return enumC3299ih;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W80.U(obj);
                }
                return ((GO) obj).a;
            }
        }
        zztVar = new zzt(this, interfaceC0198Hg);
        Object obj2 = zztVar.zza;
        EnumC3299ih enumC3299ih2 = EnumC3299ih.a;
        i = zztVar.zzc;
        if (i != 0) {
        }
        return ((GO) obj2).a;
    }

    @Override // com.google.android.recaptcha.internal.zze
    public final void zzk(zzsr zzsrVar) {
        Iterator it = this.zzb.iterator();
        while (it.hasNext()) {
            ((zzy) it.next()).zze(zzsrVar);
        }
    }

    public final Map zzo() {
        return this.zzd;
    }
}
