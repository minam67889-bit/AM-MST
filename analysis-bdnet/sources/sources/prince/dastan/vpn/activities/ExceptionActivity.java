package prince.dastan.vpn.activities;

import android.os.Bundle;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.I4;

/* loaded from: classes2.dex */
public class ExceptionActivity extends I4 {
    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.exception_drawer);
        ((TextView) findViewById(R.id.error)).setText(getIntent().getStringExtra("error"));
    }
}
