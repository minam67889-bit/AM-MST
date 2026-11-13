package prince.dastan.vpn.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import defpackage.ViewOnClickListenerC3798p10;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Iterator;
import prince.dastan.vpn.tethering.ProxyService;

/* loaded from: classes2.dex */
public class VPNShareActivity extends Activity {
    public static final /* synthetic */ int f = 0;
    public TextView a;
    public Button b;
    public Button c;
    public Button d;
    public ImageView e;

    public static String a() {
        try {
            Iterator it = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
            while (it.hasNext()) {
                for (InetAddress inetAddress : Collections.list(((NetworkInterface) it.next()).getInetAddresses())) {
                    if (!inetAddress.isLoopbackAddress()) {
                        String hostAddress = inetAddress.getHostAddress();
                        if (hostAddress.indexOf(58) < 0) {
                            return hostAddress;
                        }
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.vpnshare_drawer);
        this.d = (Button) findViewById(R.id.WiFiTetherButton);
        this.b = (Button) findViewById(R.id.cb_enable);
        this.c = (Button) findViewById(R.id.cb_disable);
        this.a = (TextView) findViewById(R.id.proxy);
        this.e = (ImageView) findViewById(R.id.backButton);
        this.d.setOnClickListener(new ViewOnClickListenerC3798p10(this, 0));
        this.b.setOnClickListener(new ViewOnClickListenerC3798p10(this, 1));
        this.c.setOnClickListener(new ViewOnClickListenerC3798p10(this, 2));
        this.e.setOnClickListener(new ViewOnClickListenerC3798p10(this, 3));
        if (ProxyService.i) {
            this.b.setVisibility(8);
            this.c.setVisibility(0);
            this.a.setText(String.format("Proxy IP: ".concat(a()), new Object[0]).concat(" Proxy Port: 8964"));
        } else {
            this.b.setVisibility(0);
            this.c.setVisibility(8);
            this.a.setText(getString(R.string.vpnshare_notrunning));
        }
    }
}
