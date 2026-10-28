package defpackage;

import android.widget.RadioGroup;
import app.vpn.amtunnellite.R;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes2.dex */
public final class HY implements RadioGroup.OnCheckedChangeListener {
    public final /* synthetic */ UDPClient a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HY(UDPClient uDPClient) {
        this.a = uDPClient;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        long j;
        UDPClient uDPClient = this.a;
        if (i == R.id.udpMode) {
            uDPClient.i.k(6);
            j = -152491350101665L;
        } else if (i == R.id.fdnsMode) {
            uDPClient.i.k(11);
            j = -152538594741921L;
        } else if (i == R.id.dnsliteMode) {
            uDPClient.i.k(12);
            j = -152422630624929L;
        } else if (i == R.id.superDnsMode) {
            uDPClient.i.k(13);
            j = -152383975919265L;
        } else if (i == R.id.pdrMode) {
            uDPClient.i.k(14);
            j = -152418335657633L;
        } else {
            return;
        }
        uDPClient.u(Deobfuscator$AMTUNNELLITE$app.getString(j));
    }
}
