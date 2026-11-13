package com.google.android.recaptcha.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import defpackage.AbstractC4331sD;
import defpackage.AbstractC4766xx;
import defpackage.C0549Un;
import defpackage.JI;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class zzbe {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbe() {
        new ConcurrentHashMap();
        zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @NotNull
    public static final Set zza(@NotNull Context context) {
        try {
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            Object systemService = context.getSystemService("connectivity");
            AbstractC4766xx.n(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
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
            return C0549Un.a;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final Map zzb() {
        LinkedHashMap U = AbstractC4331sD.U(new JI(0, zzqi.NET_CAPABILITY_MMS), new JI(1, zzqi.NET_CAPABILITY_SUPL), new JI(2, zzqi.NET_CAPABILITY_DUN), new JI(3, zzqi.NET_CAPABILITY_FOTA), new JI(4, zzqi.NET_CAPABILITY_IMS), new JI(5, zzqi.NET_CAPABILITY_CBS), new JI(6, zzqi.NET_CAPABILITY_WIFI_P2P), new JI(7, zzqi.NET_CAPABILITY_IA), new JI(8, zzqi.NET_CAPABILITY_RCS), new JI(9, zzqi.NET_CAPABILITY_XCAP), new JI(10, zzqi.NET_CAPABILITY_EIMS), new JI(11, zzqi.NET_CAPABILITY_NOT_METERED), new JI(12, zzqi.NET_CAPABILITY_INTERNET), new JI(13, zzqi.NET_CAPABILITY_NOT_RESTRICTED), new JI(14, zzqi.NET_CAPABILITY_TRUSTED), new JI(15, zzqi.NET_CAPABILITY_NOT_VPN));
        int i = Build.VERSION.SDK_INT;
        U.put(17, zzqi.NET_CAPABILITY_CAPTIVE_PORTAL);
        U.put(16, zzqi.NET_CAPABILITY_VALIDATED);
        if (i >= 28) {
            U.put(18, zzqi.NET_CAPABILITY_NOT_ROAMING);
            U.put(19, zzqi.NET_CAPABILITY_FOREGROUND);
            U.put(20, zzqi.NET_CAPABILITY_NOT_CONGESTED);
            U.put(21, zzqi.NET_CAPABILITY_NOT_SUSPENDED);
        }
        if (i >= 29) {
            U.put(23, zzqi.NET_CAPABILITY_MCX);
        }
        if (i >= 30) {
            U.put(25, zzqi.NET_CAPABILITY_TEMPORARILY_NOT_METERED);
        }
        if (i >= 31) {
            U.put(32, zzqi.NET_CAPABILITY_HEAD_UNIT);
            U.put(29, zzqi.NET_CAPABILITY_ENTERPRISE);
        }
        if (i >= 33) {
            U.put(35, zzqi.NET_CAPABILITY_PRIORITIZE_BANDWIDTH);
            U.put(34, zzqi.NET_CAPABILITY_PRIORITIZE_LATENCY);
            U.put(33, zzqi.NET_CAPABILITY_MMTEL);
        }
        return U;
    }
}
