package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* loaded from: classes.dex */
public final /* synthetic */ class AI implements AdapterView.OnItemClickListener {
    public final /* synthetic */ UDPClient a;
    public final /* synthetic */ C2481d1 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Spinner d;
    public final /* synthetic */ DialogInterfaceC3167q1 e;

    public /* synthetic */ AI(UDPClient uDPClient, C2481d1 c2481d1, String str, Spinner spinner, DialogInterfaceC3167q1 dialogInterfaceC3167q1) {
        this.a = uDPClient;
        this.b = c2481d1;
        this.c = str;
        this.d = spinner;
        this.e = dialogInterfaceC3167q1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.c;
        Spinner spinner = this.d;
        String str2 = UDPClient.Z;
        UDPClient uDPClient = this.a;
        uDPClient.getClass();
        JSONObject jSONObject = (JSONObject) this.b.a.get(i);
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = new JSONObject(SharedPreferencesC2597fC.a(uDPClient.z)).getJSONArray("#ERR IndexError: list index out of range");
                String string = jSONObject.getString("#ERR IndexError: list index out of range");
                int i2 = 0;
                while (true) {
                    if (i2 >= jSONArray.length()) {
                        i2 = -1;
                        break;
                    } else if (jSONArray.getJSONObject(i2).getString("#ERR IndexError: list index out of range").equals(string)) {
                        break;
                    } else {
                        i2++;
                    }
                }
                uDPClient.s(str);
                spinner.setSelection(i2);
            } catch (JSONException unused) {
            }
        }
        this.e.dismiss();
    }
}
