package prince.udp.vpn.service.vpn;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import prince.udp.vpn.service.DNSLiteService;
import prince.udp.vpn.service.PDRService;
import prince.udp.vpn.service.SocksDNSService;
import prince.udp.vpn.service.SuperService;
import prince.udp.vpn.service.WGService;

/* loaded from: classes2.dex */
public class TunnelManagerHelper {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startDNSLite(Context context) {
        Intent intent = new Intent(context, (Class<?>) DNSLiteService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startPdr(Context context) {
        Intent intent = new Intent(context, (Class<?>) PDRService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startSocksHttp(Context context) {
        Intent intent = new Intent(context, (Class<?>) SocksDNSService.class);
        TunnelUtils.restartRotate();
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startSuperDns(Context context) {
        Intent intent = new Intent(context, (Class<?>) SuperService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void startWg(Context context) {
        Intent intent = new Intent(context, (Class<?>) WGService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void stopDNSLite(Context context) {
        context.sendBroadcast(new Intent(DNSLiteService.u));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void stopPdr(Context context) {
        context.sendBroadcast(new Intent(PDRService.t));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void stopSocksHttp(Context context) {
        context.sendBroadcast(new Intent(SocksDNSService.q));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void stopSuperDns(Context context) {
        context.sendBroadcast(new Intent(SuperService.z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void stopWg(Context context) {
        context.stopService(new Intent(context, (Class<?>) WGService.class));
    }
}
