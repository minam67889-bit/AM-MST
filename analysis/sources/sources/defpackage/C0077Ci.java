package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.service.vpn.logger.SkStatus;

/* renamed from: Ci, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0077Ci extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.a) {
            case 0:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-170848040324769L));
                break;
            case 1:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-158362570395297L));
                break;
            case 2:
                SkStatus.logDebug("Available network");
                break;
            default:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-164457128988321L));
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.a) {
            case 0:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-170770730913441L));
                break;
            case 1:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-158835016797857L));
                break;
            case 2:
                SkStatus.logDebug("Network lost");
                break;
            default:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-164379819576993L));
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        switch (this.a) {
            case 0:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-170723486273185L));
                break;
            case 1:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-158770592288417L));
                break;
            case 2:
                SkStatus.logDebug("Network unavailable");
                break;
            default:
                SkStatus.logDebug(Deobfuscator$AMTUNNELLITE$app.getString(-164882330750625L));
                break;
        }
    }
}
