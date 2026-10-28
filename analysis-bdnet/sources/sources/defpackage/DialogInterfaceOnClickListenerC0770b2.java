package defpackage;

import android.content.DialogInterface;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: b2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnClickListenerC0770b2 implements DialogInterface.OnClickListener {
    public final /* synthetic */ String a;
    public final /* synthetic */ C2924e2 b;

    public DialogInterfaceOnClickListenerC0770b2(C2924e2 c2924e2, String str) {
        this.b = c2924e2;
        this.a = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        C2924e2 c2924e2 = this.b;
        VPNClient vPNClient = c2924e2.d;
        String str = this.a;
        vPNClient.getClass();
        try {
            JSONObject h = vPNClient.h();
            JSONArray jSONArray = h.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-51672083429259L));
            jSONArray.remove(VPNClient.v(jSONArray, str));
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-51710738134923L)));
                fileOutputStream.write(F00.b(h.toString(2)).getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException e) {
                Toast.makeText(vPNClient, Deobfuscator$BDNETVPN$app.getString(-51766572709771L) + e.getMessage(), 1).show();
            }
            Toast.makeText(vPNClient, Deobfuscator$BDNETVPN$app.getString(-51830997219211L) + str, 1).show();
        } catch (JSONException unused) {
        }
        vPNClient.F();
        int h2 = vPNClient.m.h();
        vPNClient.x.setSelection(h2 != 0 ? 0 : 1);
        if (h2 >= vPNClient.B().length()) {
            h2 = 0;
        }
        vPNClient.x.postDelayed(new L00(vPNClient, h2, 0), 100L);
        ArrayList arrayList = c2924e2.c;
        arrayList.clear();
        arrayList.addAll(c2924e2.a);
        c2924e2.notifyDataSetChanged();
    }
}
