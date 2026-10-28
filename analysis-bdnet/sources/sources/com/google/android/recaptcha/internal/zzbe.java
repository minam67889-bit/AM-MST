package com.google.android.recaptcha.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import defpackage.AbstractC3264iE;
import defpackage.AbstractC3634my;
import defpackage.C3385jo;
import defpackage.EJ;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class zzbe {
    public zzbe() {
        new ConcurrentHashMap();
        zzb();
    }

    public static final Set zza(Context context) {
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Object systemService = context.getSystemService("connectivity");
            AbstractC3634my.e(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null && networkCapabilities.hasTransport(1)) {
                linkedHashSet.add(zzqi.TRANSPORT_WIFI);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(0)) {
                linkedHashSet.add(zzqi.TRANSPORT_CELLULAR);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(4)) {
                linkedHashSet.add(zzqi.TRANSPORT_VPN);
            }
            if (networkCapabilities != null && networkCapabilities.hasTransport(3)) {
                linkedHashSet.add(zzqi.TRANSPORT_ETHERNET);
            }
            if (networkCapabilities != null && networkCapabilities.hasCapability(16)) {
                linkedHashSet.add(zzqi.NET_CAPABILITY_VALIDATED);
            }
            return linkedHashSet;
        } catch (Exception unused) {
            return C3385jo.a;
        }
    }

    private static final Map zzb() {
        LinkedHashMap H = AbstractC3264iE.H(new EJ(0, zzqi.NET_CAPABILITY_MMS), new EJ(1, zzqi.NET_CAPABILITY_SUPL), new EJ(2, zzqi.NET_CAPABILITY_DUN), new EJ(3, zzqi.NET_CAPABILITY_FOTA), new EJ(4, zzqi.NET_CAPABILITY_IMS), new EJ(5, zzqi.NET_CAPABILITY_CBS), new EJ(6, zzqi.NET_CAPABILITY_WIFI_P2P), new EJ(7, zzqi.NET_CAPABILITY_IA), new EJ(8, zzqi.NET_CAPABILITY_RCS), new EJ(9, zzqi.NET_CAPABILITY_XCAP), new EJ(10, zzqi.NET_CAPABILITY_EIMS), new EJ(11, zzqi.NET_CAPABILITY_NOT_METERED), new EJ(12, zzqi.NET_CAPABILITY_INTERNET), new EJ(13, zzqi.NET_CAPABILITY_NOT_RESTRICTED), new EJ(14, zzqi.NET_CAPABILITY_TRUSTED), new EJ(15, zzqi.NET_CAPABILITY_NOT_VPN));
        int i = Build.VERSION.SDK_INT;
        H.put(17, zzqi.NET_CAPABILITY_CAPTIVE_PORTAL);
        H.put(16, zzqi.NET_CAPABILITY_VALIDATED);
        if (i >= 28) {
            H.put(18, zzqi.NET_CAPABILITY_NOT_ROAMING);
            H.put(19, zzqi.NET_CAPABILITY_FOREGROUND);
            H.put(20, zzqi.NET_CAPABILITY_NOT_CONGESTED);
            H.put(21, zzqi.NET_CAPABILITY_NOT_SUSPENDED);
        }
        if (i >= 29) {
            H.put(23, zzqi.NET_CAPABILITY_MCX);
        }
        if (i >= 30) {
            H.put(25, zzqi.NET_CAPABILITY_TEMPORARILY_NOT_METERED);
        }
        if (i >= 31) {
            H.put(32, zzqi.NET_CAPABILITY_HEAD_UNIT);
            H.put(29, zzqi.NET_CAPABILITY_ENTERPRISE);
        }
        if (i >= 33) {
            H.put(35, zzqi.NET_CAPABILITY_PRIORITIZE_BANDWIDTH);
            H.put(34, zzqi.NET_CAPABILITY_PRIORITIZE_LATENCY);
            H.put(33, zzqi.NET_CAPABILITY_MMTEL);
        }
        return H;
    }
}
