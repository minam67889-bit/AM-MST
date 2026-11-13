package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.graphics.drawable.Drawable;
import prince.dastan.vpn.service.FWPuncherService;

/* loaded from: classes.dex */
public abstract /* synthetic */ class A0 {
    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ NotificationChannel d(String str) {
        return new NotificationChannel("fcm_fallback_notification_channel", str, 3);
    }

    public static /* synthetic */ NotificationChannel e(String str, String str2) {
        return new NotificationChannel(str, str2, 1);
    }

    public static /* synthetic */ void m() {
    }

    public static /* synthetic */ void w(FWPuncherService fWPuncherService, String str) {
        new Notification.Builder(fWPuncherService, str);
    }

    public static /* bridge */ /* synthetic */ boolean x(Drawable drawable) {
        return drawable instanceof AdaptiveIconDrawable;
    }

    public static /* synthetic */ NotificationChannel z(String str, String str2) {
        return new NotificationChannel(str, str2, 2);
    }
}
