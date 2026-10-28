package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes2.dex */
public final class JY implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ TextView c;
    public final /* synthetic */ EditText d;
    public final /* synthetic */ C4363sf e;
    public final /* synthetic */ UDPClient f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ JY(UDPClient uDPClient, TextView textView, TextView textView2, EditText editText, C4363sf c4363sf, int i) {
        this.a = i;
        this.f = uDPClient;
        this.b = textView;
        this.c = textView2;
        this.d = editText;
        this.e = c4363sf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void a(AdapterView adapterView) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void b(AdapterView adapterView) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        char c;
        char c2;
        switch (this.a) {
            case 0:
                UDPClient uDPClient = this.f;
                try {
                    String string = new JSONObject(XP.a(uDPClient.s)).getJSONArray(Deobfuscator$AMTUNNELLITE$app.getString(-152315256442529L)).getJSONObject(i).getString(Deobfuscator$AMTUNNELLITE$app.getString(-152323846377121L));
                    String[] c3 = new C0158Fl(uDPClient.getApplicationContext(), false).c();
                    boolean equals = string.equals(Deobfuscator$AMTUNNELLITE$app.getString(-152770522975905L));
                    TextView textView = this.c;
                    TextView textView2 = this.b;
                    EditText editText = this.d;
                    C4363sf c4363sf = this.e;
                    if (equals) {
                        textView2.setVisibility(0);
                        textView.setVisibility(0);
                        editText.setVisibility(0);
                        c4363sf.getClass();
                        editText.setText(c4363sf.a.getString(Deobfuscator$AMTUNNELLITE$app.getString(-206607938031265L), Deobfuscator$AMTUNNELLITE$app.getString(-206466204110497L)));
                        uDPClient.O = true;
                        break;
                    } else {
                        textView2.setVisibility(8);
                        textView.setVisibility(8);
                        editText.setVisibility(8);
                        uDPClient.O = false;
                        switch (string.hashCode()) {
                            case -1331586071:
                                if (string.equals(Deobfuscator$AMTUNNELLITE$app.getString(-152654558858913L))) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1439206999:
                                if (string.equals(Deobfuscator$AMTUNNELLITE$app.getString(-152800587746977L))) {
                                    c = 0;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 1439207000:
                                if (string.equals(Deobfuscator$AMTUNNELLITE$app.getString(-152701803499169L))) {
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
                            String str = c3[0];
                            if (str == null || !UDPClient.p(str)) {
                                I70.F(uDPClient.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-152633084022433L));
                                uDPClient.N = false;
                            } else {
                                c4363sf.i(str);
                                c4363sf.g(false);
                                uDPClient.N = true;
                            }
                        } else if (c != 1) {
                            if (c == 2) {
                                c4363sf.i(Deobfuscator$AMTUNNELLITE$app.getString(-153011041144481L));
                                c4363sf.g(false);
                            } else if (!UDPClient.q(string)) {
                                uDPClient.f(Deobfuscator$AMTUNNELLITE$app.getString(-152903666962081L));
                                uDPClient.N = false;
                                break;
                            } else {
                                c4363sf.i(string);
                                c4363sf.g(false);
                            }
                            uDPClient.N = true;
                            break;
                        } else {
                            String str2 = c3[1];
                            if (str2 == null || !UDPClient.p(str2)) {
                                I70.F(uDPClient.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-153062580752033L));
                                uDPClient.N = false;
                            } else {
                                c4363sf.i(str2);
                                c4363sf.g(false);
                                uDPClient.N = true;
                            }
                        }
                    }
                } catch (Exception e) {
                    I70.F(uDPClient.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-152839242452641L) + e.getMessage());
                    return;
                }
                break;
            default:
                UDPClient uDPClient2 = this.f;
                try {
                    String string2 = new JSONObject(XP.a(uDPClient2.s)).getJSONArray(Deobfuscator$AMTUNNELLITE$app.getString(-153337458658977L)).getJSONObject(i).getString(Deobfuscator$AMTUNNELLITE$app.getString(-153277329116833L));
                    String[] c4 = new C0158Fl(uDPClient2.getApplicationContext(), false).c();
                    boolean equals2 = string2.equals(Deobfuscator$AMTUNNELLITE$app.getString(-153311688855201L));
                    TextView textView3 = this.c;
                    TextView textView4 = this.b;
                    EditText editText2 = this.d;
                    C4363sf c4363sf2 = this.e;
                    if (equals2) {
                        textView4.setVisibility(0);
                        textView3.setVisibility(0);
                        editText2.setVisibility(0);
                        editText2.setText(c4363sf2.d());
                        uDPClient2.P = true;
                        break;
                    } else {
                        textView4.setVisibility(8);
                        textView3.setVisibility(8);
                        editText2.setVisibility(8);
                        uDPClient2.P = false;
                        switch (string2.hashCode()) {
                            case -1637431966:
                                if (string2.equals(Deobfuscator$AMTUNNELLITE$app.getString(-153144185130657L))) {
                                    c2 = 2;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -420921968:
                                if (string2.equals(Deobfuscator$AMTUNNELLITE$app.getString(-153204314672801L))) {
                                    c2 = 0;
                                    break;
                                }
                                c2 = 65535;
                                break;
                            case -420921967:
                                if (string2.equals(Deobfuscator$AMTUNNELLITE$app.getString(-153217199574689L))) {
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
                            String str3 = c4[0];
                            if (str3 == null || !UDPClient.p(str3)) {
                                I70.F(uDPClient2.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-153539322121889L));
                                uDPClient2.N = false;
                            } else {
                                c4363sf2.j(Deobfuscator$AMTUNNELLITE$app.getString(-153646696304289L) + str3);
                                c4363sf2.h(false);
                                uDPClient2.N = true;
                            }
                        } else if (c2 != 1) {
                            if (c2 == 2) {
                                c4363sf2.j(Deobfuscator$AMTUNNELLITE$app.getString(-153827084930721L));
                                c4363sf2.h(false);
                            } else if (!UDPClient.o(string2)) {
                                uDPClient2.f(Deobfuscator$AMTUNNELLITE$app.getString(-153831379898017L));
                                uDPClient2.N = false;
                                break;
                            } else {
                                c4363sf2.j(string2);
                                c4363sf2.h(false);
                            }
                            uDPClient2.N = true;
                            break;
                        } else {
                            String str4 = c4[1];
                            if (str4 == null || !UDPClient.p(str4)) {
                                I70.F(uDPClient2.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-153397588201121L));
                                uDPClient2.N = false;
                            } else {
                                c4363sf2.j(Deobfuscator$AMTUNNELLITE$app.getString(-153487782514337L) + str4);
                                c4363sf2.h(false);
                                uDPClient2.N = true;
                            }
                        }
                    }
                } catch (Exception e2) {
                    I70.F(uDPClient2.getApplicationContext(), Deobfuscator$AMTUNNELLITE$app.getString(-153668171140769L) + e2.getMessage());
                }
                break;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i = this.a;
    }
}
