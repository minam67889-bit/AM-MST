package prince.dastan.vpn.service.vpn;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;

/* loaded from: classes2.dex */
public class TunnelManagerHelper {
    public static void restartSocksHttp(Context context) {
        context.sendBroadcast(new Intent(SocksDNSService.I));
    }

    public static void startPsiphon(Context context) {
        Intent intent = new Intent(context, (Class<?>) PsiphonDNSService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void startSocksHttp(Context context) {
        Intent intent = new Intent(context, (Class<?>) SocksDNSService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void startSsh(Context context) {
        Intent intent = new Intent(context, (Class<?>) FWPuncherService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void startXRay(Context context) {
        Intent intent = new Intent(context, (Class<?>) XRayDNSService.class);
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public static void stopPsiphon(Context context) {
        context.sendBroadcast(new Intent(PsiphonDNSService.p));
    }

    public static void stopSocksHttp(Context context) {
        context.sendBroadcast(new Intent(SocksDNSService.J));
    }

    public static void stopSsh(Context context) {
        context.sendBroadcast(new Intent(FWPuncherService.u));
    }

    public static void stopXRay(Context context) {
        context.sendBroadcast(new Intent(XRayDNSService.H));
    }
}
