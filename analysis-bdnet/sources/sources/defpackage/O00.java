package defpackage;

import android.view.View;
import android.widget.EditText;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.utils.PUtils;
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes2.dex */
public final /* synthetic */ class O00 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNClient b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ V3 d;

    public /* synthetic */ O00(VPNClient vPNClient, EditText editText, V3 v3, int i) {
        this.a = i;
        this.b = vPNClient;
        this.c = editText;
        this.d = v3;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        V3 v3 = this.d;
        EditText editText = this.c;
        VPNClient vPNClient = this.b;
        switch (this.a) {
            case 0:
                String str = VPNClient.f0;
                vPNClient.getClass();
                try {
                    JSONObject jSONObject = new JSONObject(PUtils.pDecrypt(vPNClient.getApplicationContext(), editText.getText().toString().split(vPNClient.X)[1]));
                    String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-72283631482763L));
                    if (string.isEmpty()) {
                        vPNClient.t(jSONObject);
                    } else {
                        vPNClient.N(string, jSONObject);
                    }
                    v3.dismiss();
                    break;
                } catch (Exception unused) {
                    SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-72348055992203L));
                    return;
                }
            case 1:
                String str2 = VPNClient.f0;
                vPNClient.getClass();
                String obj = editText.getText().toString();
                if (!obj.isEmpty()) {
                    vPNClient.V = obj;
                    v3.dismiss();
                    break;
                } else {
                    SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-70780392929163L));
                    break;
                }
            default:
                String str3 = VPNClient.f0;
                vPNClient.getClass();
                String obj2 = editText.getText().toString();
                if (!obj2.isEmpty()) {
                    vPNClient.U = obj2;
                    v3.dismiss();
                    break;
                } else {
                    SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-70896357046155L));
                    break;
                }
        }
    }
}
