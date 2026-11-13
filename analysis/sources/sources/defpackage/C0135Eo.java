package defpackage;

import android.content.Intent;
import android.os.Build;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import prince.udp.vpn.activities.ExceptionActivity;

/* renamed from: Eo, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0135Eo implements Thread.UncaughtExceptionHandler {
    public final AbstractActivityC4701x4 a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C0135Eo(AbstractActivityC4701x4 abstractActivityC4701x4) {
        this.a = abstractActivityC4701x4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        AbstractActivityC4701x4 abstractActivityC4701x4 = this.a;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        try {
            Intent intent = new Intent(abstractActivityC4701x4, (Class<?>) ExceptionActivity.class);
            intent.putExtra("error", "************ APPLICATION ERROR ************\n\n" + stringWriter.toString() + "\n************ DEVICE INFORMATION ***********\nBrand: " + Build.BRAND + "\nDevice: " + Build.DEVICE + "\nModel: " + Build.MODEL + "\nId: " + Build.ID + "\nProduct: " + Build.PRODUCT + "\n\n************ FIRMWARE ************\nSDK: " + Build.VERSION.SDK + "\nRelease: " + Build.VERSION.RELEASE + "\nIncremental: " + Build.VERSION.INCREMENTAL + "\nReport the bug to the developer!\n");
            intent.addFlags(268435456);
            intent.addFlags(67108864);
            abstractActivityC4701x4.startActivity(intent);
            abstractActivityC4701x4.finish();
        } catch (Throwable th2) {
            throw new NoClassDefFoundError(th2.getMessage());
        }
    }
}
