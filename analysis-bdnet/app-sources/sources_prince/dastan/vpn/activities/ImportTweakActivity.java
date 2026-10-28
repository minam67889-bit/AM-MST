package prince.dastan.vpn.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

/* loaded from: classes2.dex */
public class ImportTweakActivity extends Activity {
    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Intent intent = getIntent();
        Uri data = intent != null ? intent.getData() : null;
        Intent intent2 = new Intent(this, (Class<?>) VPNClient.class);
        intent2.setAction("android.intent.action.VIEW");
        if (data != null) {
            intent2.setData(data);
        }
        intent2.addFlags(335544320);
        startActivity(intent2);
        finish();
    }
}
