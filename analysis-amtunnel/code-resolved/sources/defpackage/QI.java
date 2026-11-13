package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final class QI implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ EditText d;
    public final /* synthetic */ C2507db e;
    public final /* synthetic */ UDPClient f;

    public /* synthetic */ QI(UDPClient uDPClient, TextView textView, TextView textView2, EditText editText, C2507db c2507db, int i) {
        this.a = i;
        this.f = uDPClient;
        this.b = textView;
        this.c = textView2;
        this.d = editText;
        this.e = c2507db;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        char c;
        char c2;
        switch (this.a) {
            case 0:
                UDPClient uDPClient = this.f;
                try {
                    String string = new JSONObject(SharedPreferencesC2597fC.a(uDPClient.z)).getJSONArray("Networks_Mode").getJSONObject(i).getString("payload");
                    String[] b = new C0231Og(uDPClient.getApplicationContext(), false).b();
                    boolean equals = string.equals("custom");
                    TextView textView = this.c;
                    TextView textView2 = this.b;
                    EditText editText = this.d;
                    C2507db c2507db = this.e;
                    if (equals) {
                        textView2.setVisibility(0);
                        textView.setVisibility(0);
                        editText.setVisibility(0);
                        c2507db.getClass();
                        editText.setText(c2507db.a.getString("PDOQ_CUSTOM_DNS", "8.8.8.8"));
                        uDPClient.V = true;
                        return;
                    }
                    textView2.setVisibility(8);
                    textView.setVisibility(8);
                    editText.setVisibility(8);
                    uDPClient.V = false;
                    switch (string.hashCode()) {
                        case -1331586071:
                            if (string.equals("direct")) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1439206999:
                            if (string.equals("autodns1")) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 1439207000:
                            if (string.equals("autodns2")) {
                                c = 1;
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
                    if (c == 0) {
                        String str = b[0];
                        if (str == null || !UDPClient.p(str)) {
                            AbstractC2879kf.V(uDPClient.getApplicationContext(), "DNS Not Found! Flight Mode!");
                            uDPClient.U = false;
                            return;
                        } else {
                            c2507db.i(str);
                            c2507db.g(false);
                            uDPClient.U = true;
                            return;
                        }
                    }
                    if (c == 1) {
                        String str2 = b[1];
                        if (str2 == null || !UDPClient.p(str2)) {
                            AbstractC2879kf.V(uDPClient.getApplicationContext(), "DNS Not Found! Flight Mode!");
                            uDPClient.U = false;
                            return;
                        } else {
                            c2507db.i(str2);
                            c2507db.g(false);
                            uDPClient.U = true;
                            return;
                        }
                    }
                    if (c == 2) {
                        c2507db.i("Direct");
                        c2507db.g(false);
                    } else if (!UDPClient.q(string)) {
                        uDPClient.f("IP Address only!");
                        uDPClient.U = false;
                        return;
                    } else {
                        c2507db.i(string);
                        c2507db.g(false);
                    }
                    uDPClient.U = true;
                    return;
                } catch (Exception e) {
                    AbstractC2879kf.V(uDPClient.getApplicationContext(), "DNS Error: " + e.getMessage());
                    return;
                }
            default:
                UDPClient uDPClient2 = this.f;
                try {
                    String string2 = new JSONObject(SharedPreferencesC2597fC.a(uDPClient2.z)).getJSONArray("Networks_Mode").getJSONObject(i).getString("payload");
                    String[] b2 = new C0231Og(uDPClient2.getApplicationContext(), false).b();
                    boolean equals2 = string2.equals("custom");
                    TextView textView3 = this.c;
                    TextView textView4 = this.b;
                    EditText editText2 = this.d;
                    C2507db c2507db2 = this.e;
                    if (equals2) {
                        textView4.setVisibility(0);
                        textView3.setVisibility(0);
                        editText2.setVisibility(0);
                        editText2.setText(c2507db2.d());
                        uDPClient2.W = true;
                        return;
                    }
                    textView4.setVisibility(8);
                    textView3.setVisibility(8);
                    editText2.setVisibility(8);
                    uDPClient2.W = false;
                    switch (string2.hashCode()) {
                        case -1637431966:
                            if (string2.equals("udp://direct")) {
                                c2 = 2;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -420921968:
                            if (string2.equals("udp://autodns1")) {
                                c2 = 0;
                                break;
                            }
                            c2 = 65535;
                            break;
                        case -420921967:
                            if (string2.equals("udp://autodns2")) {
                                c2 = 1;
                                break;
                            }
                            c2 = 65535;
                            break;
                        default:
                            c2 = 65535;
                            break;
                    }
                    if (c2 == 0) {
                        String str3 = b2[0];
                        if (str3 == null || !UDPClient.p(str3)) {
                            AbstractC2879kf.V(uDPClient2.getApplicationContext(), "DNS Not Found! Flight Mode!");
                            uDPClient2.U = false;
                            return;
                        }
                        c2507db2.j("udp://" + str3);
                        c2507db2.h(false);
                        uDPClient2.U = true;
                        return;
                    }
                    if (c2 != 1) {
                        if (c2 == 2) {
                            c2507db2.j("udp://direct");
                            c2507db2.h(false);
                        } else if (!UDPClient.o(string2)) {
                            uDPClient2.f("Invalid DNS Protocol!");
                            uDPClient2.U = false;
                            return;
                        } else {
                            c2507db2.j(string2);
                            c2507db2.h(false);
                        }
                        uDPClient2.U = true;
                        return;
                    }
                    String str4 = b2[1];
                    if (str4 == null || !UDPClient.p(str4)) {
                        AbstractC2879kf.V(uDPClient2.getApplicationContext(), "DNS Not Found! Flight Mode!");
                        uDPClient2.U = false;
                        return;
                    }
                    c2507db2.j("udp://" + str4);
                    c2507db2.h(false);
                    uDPClient2.U = true;
                    return;
                } catch (Exception e2) {
                    AbstractC2879kf.V(uDPClient2.getApplicationContext(), "DNS Error: " + e2.getMessage());
                    return;
                }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.a;
    }
}
