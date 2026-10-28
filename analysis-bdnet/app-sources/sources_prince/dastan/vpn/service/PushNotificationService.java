package prince.dastan.vpn.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.os.Bundle;
import com.google.firebase.messaging.FirebaseMessagingService;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3131gc0;
import defpackage.AbstractC4179tr;
import defpackage.C2835cv;
import defpackage.C3144gl;
import defpackage.C4138tI;
import defpackage.C4454xI;
import defpackage.ServiceConnectionC4375wI;
import defpackage.VN;

/* loaded from: classes2.dex */
public class PushNotificationService extends FirebaseMessagingService {
    @Override // com.google.firebase.messaging.FirebaseMessagingService
    public final void c(VN vn) {
        if (vn.g == null) {
            Bundle bundle = vn.f;
            if (C2835cv.D(bundle)) {
                vn.g = new C3144gl(new C2835cv(bundle));
            }
        }
        C3144gl c3144gl = vn.g;
        String str = c3144gl.a;
        if (c3144gl == null) {
            Bundle bundle2 = vn.f;
            if (C2835cv.D(bundle2)) {
                vn.g = new C3144gl(new C2835cv(bundle2));
            }
        }
        String str2 = vn.g.b;
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(AbstractC4179tr.c());
        Notification.Builder autoCancel = AbstractC4179tr.b(this).setContentTitle(str).setContentText(str2).setSmallIcon(R.drawable.ic_app_icon_small).setAutoCancel(true);
        if (AbstractC3131gc0.g(this, "android.permission.POST_NOTIFICATIONS") != 0) {
            return;
        }
        C4454xI c4454xI = new C4454xI(this);
        Notification build = autoCancel.build();
        Bundle bundle3 = build.extras;
        if (bundle3 == null || !bundle3.getBoolean("android.support.useSideChannel")) {
            c4454xI.a.notify(null, 1, build);
            return;
        }
        C4138tI c4138tI = new C4138tI(getPackageName(), build);
        synchronized (C4454xI.e) {
            try {
                if (C4454xI.f == null) {
                    C4454xI.f = new ServiceConnectionC4375wI(getApplicationContext());
                }
                C4454xI.f.b.obtainMessage(0, c4138tI).sendToTarget();
            } catch (Throwable th) {
                throw th;
            }
        }
        c4454xI.a.cancel(null, 1);
    }
}
