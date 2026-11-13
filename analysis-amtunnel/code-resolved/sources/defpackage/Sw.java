package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* loaded from: classes2.dex */
public final class Sw extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int a;

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.a) {
            case 0:
                SkStatus.logDebug("#ERR IndexError: list index out of range");
                return;
            case 1:
                SkStatus.logDebug("Available network");
                return;
            default:
                SkStatus.logDebug("#ERR IndexError: list index out of range");
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.a) {
            case 0:
                SkStatus.logDebug("#ERR IndexError: list index out of range");
                return;
            case 1:
                SkStatus.logDebug("Network lost");
                return;
            default:
                SkStatus.logDebug("#ERR IndexError: list index out of range");
                return;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        switch (this.a) {
            case 0:
                SkStatus.logDebug("#ERR IndexError: list index out of range");
                return;
            case 1:
                SkStatus.logDebug("Network unavailable");
                return;
            default:
                SkStatus.logDebug("#ERR IndexError: list index out of range");
                return;
        }
    }
}
