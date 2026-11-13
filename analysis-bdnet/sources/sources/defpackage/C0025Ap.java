package defpackage;

import android.net.ConnectivityManager;
import android.net.Network;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.vpn.logger.SkStatus;

/* renamed from: Ap, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0025Ap extends ConnectivityManager.NetworkCallback {
    public final /* synthetic */ int a;

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onAvailable(Network network) {
        switch (this.a) {
            case 0:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-75324468328331L));
                break;
            case 1:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-80534263658379L));
                break;
            case 2:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-85297382389643L));
                break;
            default:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-98169399375755L));
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onLost(Network network) {
        switch (this.a) {
            case 0:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-75401777739659L));
                break;
            case 1:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-80611573069707L));
                break;
            case 2:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-85374691800971L));
                break;
            default:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-98246708787083L));
                break;
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public final void onUnavailable() {
        switch (this.a) {
            case 0:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-75457612314507L));
                break;
            case 1:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-80667407644555L));
                break;
            case 2:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-85430526375819L));
                break;
            default:
                SkStatus.logDebug(Deobfuscator$BDNETVPN$app.getString(-98302543361931L));
                break;
        }
    }
}
