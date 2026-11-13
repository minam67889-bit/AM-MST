package defpackage;

import ads_mobile_sdk.mo1;
import android.content.Context;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes2.dex */
public final class AY implements InterfaceC4902zf, PZ, OZ, K1 {
    public final /* synthetic */ UDPClient a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.K1
    public void onAdFailedToLoad(ZB zb) {
        AbstractC4766xx.p(zb, "adError");
        UDPClient uDPClient = this.a;
        uDPClient.q = null;
        uDPClient.v = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.K1
    public void onAdLoaded(Object obj) {
        InterfaceC4689wx interfaceC4689wx = (InterfaceC4689wx) obj;
        Context context = this.a;
        ((UDPClient) context).q = interfaceC4689wx;
        if (((UDPClient) context).C && !((UDPClient) context).v && ((UDPClient) context).B) {
            long j = ((UDPClient) context).w.getLong(Deobfuscator$AMTUNNELLITE$app.getString(-151172795141793L), 0L);
            if (j == 0) {
                mo1 mo1Var = (mo1) ((UDPClient) context).q;
                mo1Var.getClass();
                mo1Var.b.a(context);
            } else if (j != 0 && System.currentTimeMillis() >= j + 60000) {
                mo1 mo1Var2 = (mo1) ((UDPClient) context).q;
                mo1Var2.getClass();
                mo1Var2.b.a(context);
            }
            ((UDPClient) context).v = true;
            ((UDPClient) context).B = false;
        }
        FY fy = new FY(this);
        mo1 mo1Var3 = (mo1) interfaceC4689wx;
        mo1Var3.getClass();
        mo1Var3.c.setValue(mo1Var3, mo1.e[0], fy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.OZ
    public void onConsentFormLoadFailure(C3455gs c3455gs) {
        this.a.r();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.PZ
    public void onConsentFormLoadSuccess(InterfaceC4748xf interfaceC4748xf) {
        String str = UDPClient.U;
        UDPClient uDPClient = this.a;
        uDPClient.getClass();
        if (uDPClient.A.getConsentStatus() == 0) {
            interfaceC4748xf.show(uDPClient, new BY(this, 0));
        }
        if (uDPClient.A.getConsentStatus() == 2) {
            interfaceC4748xf.show(uDPClient, new BY(this, 1));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4902zf
    public void onConsentInfoUpdateSuccess() {
        UDPClient uDPClient = this.a;
        if (uDPClient.A.isConsentFormAvailable()) {
            uDPClient.r();
        }
    }
}
