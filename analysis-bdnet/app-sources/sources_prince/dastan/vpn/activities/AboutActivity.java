package prince.dastan.vpn.activities;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.ViewOnClickListenerC2840d;

/* loaded from: classes2.dex */
public class AboutActivity extends Activity {
    public TextView a;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTheme(R.style.AppTheme_NoActionBar);
        setContentView(R.layout.about_us);
        ((LinearLayout) findViewById(R.id.about_back)).setOnClickListener(new ViewOnClickListenerC2840d(this, 0));
        this.a = (TextView) findViewById(R.id.name_version);
        try {
            String str = getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
            String valueOf = String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
            this.a.setText("Build: " + valueOf);
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
