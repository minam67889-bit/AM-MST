package defpackage;

import android.app.Notification;
import android.app.NotificationChannel;
import prince.dastan.vpn.service.PushNotificationService;

/* renamed from: tr, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC4179tr {
    public static /* synthetic */ Notification.Builder b(PushNotificationService pushNotificationService) {
        return new Notification.Builder(pushNotificationService, "MESSAGE");
    }

    public static /* synthetic */ NotificationChannel c() {
        return new NotificationChannel("MESSAGE", "Message Notification", 4);
    }

    public static /* synthetic */ NotificationChannel f(CharSequence charSequence, String str) {
        return new NotificationChannel(str, charSequence, 3);
    }

    public static /* synthetic */ NotificationChannel g(String str) {
        return new NotificationChannel("com.google.android.gms.availability", str, 4);
    }
}
