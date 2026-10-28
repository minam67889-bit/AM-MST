package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import prince.udp.vpn.activities.a;
import prince.udp.vpn.service.DNSLiteService;

/* loaded from: classes2.dex */
public final class KY implements ServiceConnection {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KY(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        switch (this.a) {
            case 0:
                DNSLiteService dNSLiteService = ((BinderC0155Fi) iBinder).a;
                ((a) this.b).b = dNSLiteService;
                dNSLiteService.getClass();
                break;
            default:
                K40 k40 = (K40) this.b;
                k40.b.b("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
                k40.a().post(new I40(this, iBinder));
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        switch (this.a) {
            case 0:
                ((a) this.b).b = null;
                break;
            default:
                K40 k40 = (K40) this.b;
                k40.b.b("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
                k40.a().post(new J40(this, 0));
                break;
        }
    }
}
