package prince.dastan.vpn.activities;

import android.os.Bundle;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3623mn;
import defpackage.C0223If;
import defpackage.CountDownTimerC3163h10;
import defpackage.I4;

/* loaded from: classes2.dex */
public class SplashActivity extends I4 {
    public C0223If b;

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.splash);
        new CountDownTimerC3163h10(this, 3000L, 2).start();
        AbstractC3623mn.a(this);
        this.b = C0223If.d(getApplicationContext());
    }
}
