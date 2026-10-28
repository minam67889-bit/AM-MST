package defpackage;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import dastan.prince.bdfreevpn.R;
import prince.dastan.vpn.activities.IPHunterActivity;

/* renamed from: ww, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC4421ww implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ IPHunterActivity b;

    public /* synthetic */ ViewOnClickListenerC4421ww(IPHunterActivity iPHunterActivity, int i) {
        this.a = i;
        this.b = iPHunterActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        IPHunterActivity iPHunterActivity = this.b;
        int i = 0;
        switch (this.a) {
            case 0:
                if (!iPHunterActivity.h) {
                    String string = Settings.Secure.getString(iPHunterActivity.getContentResolver(), "assistant");
                    if (string != null && string.contains("dastan.prince.bdfreevpn/prince.dastan.vpn.voice.MyInteractionService")) {
                        NetworkInfo activeNetworkInfo = ((ConnectivityManager) iPHunterActivity.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
                        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                            String trim = iPHunterActivity.c.getText().toString().trim();
                            if (!trim.isEmpty()) {
                                String[] split = trim.split(";");
                                String[] strArr = {iPHunterActivity.a()};
                                iPHunterActivity.g.notifyDataSetChanged();
                                iPHunterActivity.f.clear();
                                int length = split.length;
                                int i2 = 0;
                                while (true) {
                                    if (i2 < length) {
                                        String trim2 = split[i2].trim();
                                        if (!trim2.isEmpty() && strArr[0].startsWith(trim2)) {
                                            iPHunterActivity.runOnUiThread(new RunnableC4342vw(iPHunterActivity, W50.v(new StringBuilder("Found IP: "), strArr[0], " (Matches prefix: ", trim2, ")"), i));
                                            Context applicationContext = iPHunterActivity.getApplicationContext();
                                            int i3 = F00.a;
                                            new Handler(Looper.getMainLooper()).post(new S7(applicationContext, 24));
                                        } else {
                                            i2++;
                                        }
                                    } else {
                                        Thread thread = new Thread(new RunnableC0283Kn(iPHunterActivity, strArr, split, 2));
                                        iPHunterActivity.i = thread;
                                        thread.start();
                                    }
                                }
                                iPHunterActivity.a.setText("STOP IP HUNT");
                                iPHunterActivity.h = true;
                                iPHunterActivity.c.setEnabled(false);
                                break;
                            } else {
                                F00.h(iPHunterActivity.getApplicationContext(), "Please enter IP addresses to search");
                                break;
                            }
                        } else {
                            F00.h(iPHunterActivity.getApplicationContext(), "No internet connection!");
                            break;
                        }
                    } else {
                        U3 u3 = new U3(iPHunterActivity, R.style.MyDialogTheme);
                        Q3 q3 = (Q3) u3.c;
                        q3.e = "IP Hunter";
                        q3.g = "You need to make this app as the Default digital assistant app before you can use IP Hunter";
                        u3.f("OKAY", new DialogInterfaceOnClickListenerC4500xw(iPHunterActivity, i));
                        u3.e("LATER", new DialogInterfaceOnClickListenerC4579yw(0));
                        u3.g();
                        break;
                    }
                } else {
                    iPHunterActivity.b();
                    break;
                }
                break;
            default:
                iPHunterActivity.finish();
                break;
        }
    }
}
