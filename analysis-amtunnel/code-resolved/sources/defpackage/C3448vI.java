package defpackage;

import android.app.Activity;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;

/* renamed from: vI, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3448vI extends FullScreenContentCallback {
    public final /* synthetic */ InterfaceC3554xI a;
    public final /* synthetic */ Activity b;
    public final /* synthetic */ C3501wI c;

    public C3448vI(C3501wI c3501wI, InterfaceC3554xI interfaceC3554xI, Activity activity) {
        this.c = c3501wI;
        this.a = interfaceC3554xI;
        this.b = activity;
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdDismissedFullScreenContent() {
        C3501wI c3501wI = this.c;
        c3501wI.a = null;
        c3501wI.c = false;
        this.a.b();
        long j = c3501wI.d.c.getLong("#ERR IndexError: list index out of range", 0L);
        Activity activity = this.b;
        if (j != 0 && (j == 0 || System.currentTimeMillis() < j + 3600000)) {
            return;
        }
        c3501wI.a(activity);
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdFailedToShowFullScreenContent(AdError adError) {
        C3501wI c3501wI = this.c;
        c3501wI.a = null;
        c3501wI.c = false;
        this.a.b();
        long j = c3501wI.d.c.getLong("#ERR IndexError: list index out of range", 0L);
        Activity activity = this.b;
        if (j != 0 && (j == 0 || System.currentTimeMillis() < j + 3600000)) {
            return;
        }
        c3501wI.a(activity);
    }

    @Override // com.google.android.gms.ads.FullScreenContentCallback
    public final void onAdShowedFullScreenContent() {
    }
}
