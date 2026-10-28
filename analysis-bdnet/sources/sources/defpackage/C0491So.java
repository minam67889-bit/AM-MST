package defpackage;

import android.content.Intent;
import android.os.Build;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import prince.dastan.vpn.activities.ExceptionActivity;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: So, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0491So implements Thread.UncaughtExceptionHandler {
    public final VPNClient a;

    public C0491So(VPNClient vPNClient) {
        this.a = vPNClient;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        VPNClient vPNClient = this.a;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        try {
            Intent intent = new Intent(vPNClient, (Class<?>) ExceptionActivity.class);
            intent.putExtra("error", "************ APPLICATION ERROR ************\n\n" + stringWriter.toString() + "\n************ DEVICE INFORMATION ***********\nBrand: " + Build.BRAND + "\nDevice: " + Build.DEVICE + "\nModel: " + Build.MODEL + "\nId: " + Build.ID + "\nProduct: " + Build.PRODUCT + "\n\n************ FIRMWARE ************\nSDK: " + Build.VERSION.SDK + "\nRelease: " + Build.VERSION.RELEASE + "\nIncremental: " + Build.VERSION.INCREMENTAL + "\nReport the bug to the developer!\n");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            vPNClient.startActivity(intent);
            vPNClient.finish();
        } catch (Throwable th2) {
            throw new NoClassDefFoundError(th2.getMessage());
        }
    }
}
