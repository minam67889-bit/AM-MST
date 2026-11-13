package defpackage;

import android.content.Intent;
import android.os.Build;
import android.view.View;
import dastan.prince.bdfreevpn.R;
import prince.dastan.vpn.activities.VPNShareActivity;
import prince.dastan.vpn.tethering.ProxyService;

/* renamed from: p10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC3798p10 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNShareActivity b;

    public /* synthetic */ ViewOnClickListenerC3798p10(VPNShareActivity vPNShareActivity, int i) {
        this.a = i;
        this.b = vPNShareActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        VPNShareActivity vPNShareActivity = this.b;
        switch (this.a) {
            case 0:
                int i = VPNShareActivity.f;
                vPNShareActivity.getClass();
                Intent intent = new Intent();
                intent.setClassName("com.android.settings", "com.android.settings.TetherSettings");
                vPNShareActivity.startActivity(intent);
                break;
            case 1:
                Intent intent2 = new Intent(vPNShareActivity.getApplicationContext(), (Class<?>) ProxyService.class);
                if (Build.VERSION.SDK_INT >= 26) {
                    vPNShareActivity.getApplicationContext().startForegroundService(intent2);
                } else {
                    vPNShareActivity.getApplicationContext().startService(intent2);
                }
                vPNShareActivity.b.setVisibility(8);
                vPNShareActivity.c.setVisibility(0);
                vPNShareActivity.a.setText(String.format("Proxy IP: ".concat(VPNShareActivity.a()), new Object[0]).concat(" Proxy Port: 8964"));
                F00.i(vPNShareActivity.getApplicationContext(), "VPNShare Started!");
                break;
            case 2:
                vPNShareActivity.b.setVisibility(0);
                vPNShareActivity.c.setVisibility(8);
                vPNShareActivity.getApplicationContext().sendBroadcast(new Intent(ProxyService.h));
                vPNShareActivity.a.setText(vPNShareActivity.getString(R.string.vpnshare_notrunning));
                F00.i(vPNShareActivity.getApplicationContext(), "VPNShare Stopped!");
                break;
            default:
                vPNShareActivity.finish();
                break;
        }
    }
}
