package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;

/* renamed from: wY, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final /* synthetic */ class C4660wY implements AdapterView.OnItemClickListener {
    public final /* synthetic */ UDPClient a;
    public final /* synthetic */ X1 b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Spinner d;
    public final /* synthetic */ K3 e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ C4660wY(UDPClient uDPClient, X1 x1, String str, Spinner spinner, K3 k3) {
        this.a = uDPClient;
        this.b = x1;
        this.c = str;
        this.d = spinner;
        this.e = k3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        String str = this.c;
        Spinner spinner = this.d;
        String str2 = UDPClient.U;
        UDPClient uDPClient = this.a;
        uDPClient.getClass();
        JSONObject jSONObject = (JSONObject) this.b.a.get(i);
        if (jSONObject != null) {
            try {
                JSONArray jSONArray = new JSONObject(XP.a(uDPClient.s)).getJSONArray(Deobfuscator$AMTUNNELLITE$app.getString(-169306147065505L));
                String string = jSONObject.getString(Deobfuscator$AMTUNNELLITE$app.getString(-169246017523361L));
                int i2 = 0;
                while (true) {
                    if (i2 < jSONArray.length()) {
                        if (jSONArray.getJSONObject(i2).getString(Deobfuscator$AMTUNNELLITE$app.getString(-155033970740897L)).equals(string)) {
                            break;
                        } else {
                            i2++;
                        }
                    } else {
                        i2 = -1;
                        break;
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
