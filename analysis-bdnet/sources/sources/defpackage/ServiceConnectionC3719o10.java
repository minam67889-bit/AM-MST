package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.FWPuncherService;

/* renamed from: o10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ServiceConnectionC3719o10 implements ServiceConnection {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ServiceConnectionC3719o10(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        switch (this.a) {
            case 0:
                FWPuncherService fWPuncherService = ((BinderC0077Cp) iBinder).a;
                VPNClient vPNClient = (VPNClient) this.b;
                vPNClient.b = fWPuncherService;
                fWPuncherService.d = vPNClient;
                break;
            default:
                C3173h60 c3173h60 = (C3173h60) this.b;
                c3173h60.b.b("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
                c3173h60.a().post(new C2854d60(this, iBinder));
                break;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.a) {
            case 0:
                ((VPNClient) this.b).b = null;
                break;
            default:
                C3173h60 c3173h60 = (C3173h60) this.b;
                c3173h60.b.b("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
                c3173h60.a().post(new C2933e60(this, 0));
                break;
        }
    }
}
