package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzo;
import com.google.android.gms.ads.mediation.MediationAppOpenAd;
import com.google.android.gms.ads.mediation.MediationAppOpenAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.zzc;
import com.google.android.gms.dynamic.IObjectWrapper;
import defpackage.f82;
import defpackage.fj3;
import defpackage.g82;
import defpackage.i31;
import defpackage.p32;
import defpackage.rb0;
import defpackage.tj1;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes.dex */
public final class zzbwf extends zzbvr {
    public final RtbAdapter b;
    public MediationInterstitialAd c;
    public MediationRewardedAd d;
    public MediationAppOpenAd e;
    public String f = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    public zzbwf(RtbAdapter rtbAdapter) {
        this.b = rtbAdapter;
    }

    public static final Bundle b(String str) {
        zzo.zzi("Server parameters: ".concat(String.valueOf(str)));
        try {
            Bundle bundle = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                Bundle bundle2 = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle2.putString(next, jSONObject.getString(next));
                }
                return bundle2;
            }
            return bundle;
        } catch (JSONException e) {
            zzo.zzg(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, e);
            fj3.b();
            return null;
        }
    }

    public static final boolean c(zzm zzmVar) {
        if (!zzmVar.zzf) {
            com.google.android.gms.ads.internal.client.zzbb.zza();
            if (!zzf.zzw()) {
                return false;
            }
            return true;
        }
        return true;
    }

    public static final String d(zzm zzmVar, String str) {
        String str2 = zzmVar.zzu;
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return str2;
        }
    }

    public final Bundle a(zzm zzmVar) {
        Bundle bundle;
        Bundle bundle2 = zzmVar.zzm;
        if (bundle2 != null && (bundle = bundle2.getBundle(this.b.getClass().getName())) != null) {
            return bundle;
        }
        return new Bundle();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x000f. Please report as an issue. */
    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zze(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzr zzrVar, zzbvv zzbvvVar) {
        AdFormat adFormat;
        try {
            rb0 rb0Var = new rb0(29, this, zzbvvVar);
            RtbAdapter rtbAdapter = this.b;
            switch (str.hashCode()) {
                case -1396342996:
                    if (str.equals("banner")) {
                        adFormat = AdFormat.BANNER;
                        MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(mediationConfiguration);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                case -1052618729:
                    if (str.equals("native")) {
                        adFormat = AdFormat.NATIVE;
                        MediationConfiguration mediationConfiguration2 = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(mediationConfiguration2);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList2, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                case -239580146:
                    if (str.equals("rewarded")) {
                        adFormat = AdFormat.REWARDED;
                        MediationConfiguration mediationConfiguration22 = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList22 = new ArrayList();
                        arrayList22.add(mediationConfiguration22);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList22, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                case 604727084:
                    if (str.equals("interstitial")) {
                        adFormat = AdFormat.INTERSTITIAL;
                        MediationConfiguration mediationConfiguration222 = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList222 = new ArrayList();
                        arrayList222.add(mediationConfiguration222);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList222, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                case 1167692200:
                    if (str.equals("app_open")) {
                        adFormat = AdFormat.APP_OPEN_AD;
                        MediationConfiguration mediationConfiguration2222 = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList2222 = new ArrayList();
                        arrayList2222.add(mediationConfiguration2222);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList2222, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                case 1778294298:
                    if (str.equals("app_open_ad")) {
                        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().a(p32.nd)).booleanValue()) {
                            adFormat = AdFormat.APP_OPEN_AD;
                            MediationConfiguration mediationConfiguration22222 = new MediationConfiguration(adFormat, bundle2);
                            ArrayList arrayList22222 = new ArrayList();
                            arrayList22222.add(mediationConfiguration22222);
                            rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList22222, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                            return;
                        }
                    }
                    throw new IllegalArgumentException("Internal Error");
                case 1911491517:
                    if (str.equals("rewarded_interstitial")) {
                        adFormat = AdFormat.REWARDED_INTERSTITIAL;
                        MediationConfiguration mediationConfiguration222222 = new MediationConfiguration(adFormat, bundle2);
                        ArrayList arrayList222222 = new ArrayList();
                        arrayList222222.add(mediationConfiguration222222);
                        rtbAdapter.collectSignals(new RtbSignalData((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), arrayList222222, bundle, zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza)), rb0Var);
                        return;
                    }
                    throw new IllegalArgumentException("Internal Error");
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
        } catch (Throwable th) {
            zzo.zzg("Error generating signals for RTB", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.collectSignals");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final g82 zzf() {
        return g82.a(this.b.getVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final g82 zzg() {
        return g82.a(this.b.getSDKVersionInfo());
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final com.google.android.gms.ads.internal.client.zzed zzh() {
        MediationExtrasReceiver mediationExtrasReceiver = this.b;
        if (mediationExtrasReceiver instanceof com.google.android.gms.ads.mediation.zza) {
            try {
                return ((com.google.android.gms.ads.mediation.zza) mediationExtrasReceiver).getVideoController();
            } catch (Throwable th) {
                zzo.zzg(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, th);
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzi(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvg zzbvgVar, zzbtz zzbtzVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        try {
            this.b.loadRtbBannerAd(new MediationBannerAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza), this.f), new i31(this, 12, zzbvgVar, zzbtzVar));
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render banner ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbBannerAd");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzj(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvj zzbvjVar, zzbtz zzbtzVar) {
        try {
            this.b.loadRtbInterstitialAd(new MediationInterstitialAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), this.f), new tj1(this, zzbvjVar, zzbtzVar, 20, false));
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render interstitial ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbInterstitialAd");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final boolean zzk(IObjectWrapper iObjectWrapper) {
        MediationInterstitialAd mediationInterstitialAd = this.c;
        if (mediationInterstitialAd != null) {
            try {
                mediationInterstitialAd.showAd((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper));
                return true;
            } catch (Throwable th) {
                zzo.zzg(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, th);
                defpackage.n8.Q(iObjectWrapper, th, "adapter.showRtbInterstitialAd");
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzl(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvp zzbvpVar, zzbtz zzbtzVar) {
        try {
            this.b.loadRtbRewardedAd(new MediationRewardedAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), this.f), new tj1(this, zzbvpVar, zzbtzVar, 22, false));
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render rewarded ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbRewardedAd");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        MediationRewardedAd mediationRewardedAd = this.d;
        if (mediationRewardedAd != null) {
            try {
                mediationRewardedAd.showAd((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper));
                return true;
            } catch (Throwable th) {
                zzo.zzg(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, th);
                defpackage.n8.Q(iObjectWrapper, th, "adapter.showRtbRewardedAd");
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzn(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvm zzbvmVar, zzbtz zzbtzVar) {
        zzr(str, str2, zzmVar, iObjectWrapper, zzbvmVar, zzbtzVar, null);
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzo(String str) {
        this.f = str;
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzp(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvp zzbvpVar, zzbtz zzbtzVar) {
        try {
            this.b.loadRtbRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), this.f), new tj1(this, zzbvpVar, zzbtzVar, 22, false));
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render rewarded interstitial ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbRewardedInterstitialAd");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzq(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvg zzbvgVar, zzbtz zzbtzVar, com.google.android.gms.ads.internal.client.zzr zzrVar) {
        try {
            RtbAdapter rtbAdapter = this.b;
            b(str2);
            a(zzmVar);
            c(zzmVar);
            d(zzmVar, str2);
            zzc.zza(zzrVar.zze, zzrVar.zzb, zzrVar.zza);
            try {
                zzbvgVar.zzg(new AdError(7, rtbAdapter.getClass().getSimpleName().concat(" does not support interscroller ads."), MobileAds.ERROR_DOMAIN).zza());
            } catch (RemoteException e) {
                zzo.zzg(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, e);
            }
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render interscroller ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbInterscrollerAd");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzr(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvm zzbvmVar, zzbtz zzbtzVar, zzbkh zzbkhVar) {
        RtbAdapter rtbAdapter = this.b;
        try {
            rtbAdapter.loadRtbNativeAdMapper(new MediationNativeAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), this.f, zzbkhVar), new f82(this, zzbvmVar, zzbtzVar, 0));
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render native ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbNativeAdMapper");
            String message = th.getMessage();
            if (!TextUtils.isEmpty(message) && message.equals("Method is not found")) {
                try {
                    rtbAdapter.loadRtbNativeAd(new MediationNativeAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), this.f, zzbkhVar), new f82(this, zzbvmVar, zzbtzVar, 1));
                    return;
                } catch (Throwable th2) {
                    zzo.zzg("Adapter failed to render native ad.", th2);
                    defpackage.n8.Q(iObjectWrapper, th2, "adapter.loadRtbNativeAd");
                    fj3.b();
                    return;
                }
            }
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final void zzs(String str, String str2, zzm zzmVar, IObjectWrapper iObjectWrapper, zzbvd zzbvdVar, zzbtz zzbtzVar) {
        try {
            this.b.loadRtbAppOpenAd(new MediationAppOpenAdConfiguration((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper), str, b(str2), a(zzmVar), c(zzmVar), zzmVar.zzk, zzmVar.zzg, zzmVar.zzt, d(zzmVar, str2), this.f), new tj1(this, zzbvdVar, zzbtzVar, 21, false));
        } catch (Throwable th) {
            zzo.zzg("Adapter failed to render app open ad.", th);
            defpackage.n8.Q(iObjectWrapper, th, "adapter.loadRtbAppOpenAd");
            fj3.b();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbvs
    public final boolean zzt(IObjectWrapper iObjectWrapper) {
        MediationAppOpenAd mediationAppOpenAd = this.e;
        if (mediationAppOpenAd != null) {
            try {
                mediationAppOpenAd.showAd((Context) com.google.android.gms.dynamic.a.d(iObjectWrapper));
                return true;
            } catch (Throwable th) {
                zzo.zzg(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, th);
                defpackage.n8.Q(iObjectWrapper, th, "adapter.showRtbAppOpenAd");
                return true;
            }
        }
        return false;
    }
}
