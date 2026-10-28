package prince.dastan.vpn.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import defpackage.C0223If;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;

/* loaded from: classes2.dex */
public class MainReceiver extends BroadcastReceiver {
    public C0223If a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a = C0223If.d(context);
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (!action.equals("sshtunnelservicestop")) {
            if (action.equals("sshTunnelServiceRestsrt")) {
                context.sendBroadcast(this.a.q().booleanValue() ? new Intent(PsiphonDNSService.o) : this.a.u().booleanValue() ? new Intent(XRayDNSService.G) : this.a.s().booleanValue() ? new Intent(FWPuncherService.t) : new Intent(SocksDNSService.I));
            }
        } else {
            if (this.a.q().booleanValue()) {
                TunnelManagerHelper.stopPsiphon(context);
                return;
            }
            if (this.a.u().booleanValue()) {
                TunnelManagerHelper.stopXRay(context);
            } else if (this.a.s().booleanValue()) {
                TunnelManagerHelper.stopSsh(context);
            } else {
                TunnelManagerHelper.stopSocksHttp(context);
            }
        }
    }
}
