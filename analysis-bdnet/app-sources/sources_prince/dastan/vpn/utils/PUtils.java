package prince.dastan.vpn.utils;

import android.content.Context;

/* loaded from: classes2.dex */
public class PUtils {
    static {
        System.loadLibrary("putils");
    }

    public static native void checkSignature(Context context);

    public static native void killProcess();

    public static native String pDecrypt(Context context, String str);

    public static native String pEncrypt(Context context, String str);
}
