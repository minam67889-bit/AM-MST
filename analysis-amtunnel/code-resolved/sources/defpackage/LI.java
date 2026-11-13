package defpackage;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final class LI extends FullScreenContentCallback {
    public final /* synthetic */ MI a;

    public LI(MI mi) {
        this.a = mi;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdDismissedFullScreenContent() {
        UDPClient uDPClient = this.a.a;
        uDPClient.x = null;
        uDPClient.C = false;
        SharedPreferencesEditorC2544eC sharedPreferencesEditorC2544eC = (SharedPreferencesEditorC2544eC) uDPClient.D.edit();
        sharedPreferencesEditorC2544eC.putLong("last_ads_time", System.currentTimeMillis());
        sharedPreferencesEditorC2544eC.apply();
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdFailedToShowFullScreenContent(AdError adError) {
        UDPClient uDPClient = this.a.a;
        uDPClient.x = null;
        uDPClient.C = false;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdShowedFullScreenContent() {
    }
}
