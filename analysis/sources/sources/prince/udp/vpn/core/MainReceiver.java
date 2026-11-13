package prince.udp.vpn.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.liapp.y;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.vpn.TunnelManagerHelper;

/* loaded from: classes2.dex */
public class MainReceiver extends BroadcastReceiver {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action == null) {
            return;
        }
        if (action.equals(y.گ֮۬۲ݮ(2086474779))) {
            TunnelManagerHelper.stopSocksHttp(context);
        } else if (action.equals(y.۳׭خ۲ݮ(1787143623))) {
            context.sendBroadcast(new Intent(SocksDNSService.p));
        }
    }
}
