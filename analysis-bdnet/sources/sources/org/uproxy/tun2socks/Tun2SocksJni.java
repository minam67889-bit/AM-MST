package org.uproxy.tun2socks;

import android.util.Log;

/* loaded from: classes2.dex */
public class Tun2SocksJni {
    static {
        System.loadLibrary("tun2socks");
    }

    public static void logTun2Socks(String str, String str2, String str3) {
        Log.i("Tun2Socks", str + " (" + str2 + "): " + str3);
    }

    public static native int runTun2Socks(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, int i4);

    public static native int terminateTun2Socks();
}
