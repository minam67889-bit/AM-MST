package defpackage;

import ads_mobile_sdk.lv2;
import ads_mobile_sdk.r00;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import dastan.prince.bdfreevpn.R;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: lm, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnTouchListenerC3543lm implements View.OnTouchListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewOnTouchListenerC3543lm(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Object obj = this.b;
        switch (this.a) {
            case 0:
                C3780om c3780om = (C3780om) obj;
                c3780om.getClass();
                if (motionEvent.getAction() == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - c3780om.o;
                    if (uptimeMillis < 0 || uptimeMillis > 300) {
                        c3780om.m = false;
                    }
                    c3780om.u();
                    c3780om.m = true;
                    c3780om.o = SystemClock.uptimeMillis();
                }
                return false;
            case 1:
                String str = VPNClient.f0;
                final VPNClient vPNClient = (VPNClient) obj;
                if (motionEvent.getAction() == 1) {
                    View inflate = vPNClient.getLayoutInflater().inflate(R.layout.searchable_listview, (ViewGroup) null);
                    U3 u3 = new U3(vPNClient);
                    Q3 q3 = (Q3) u3.c;
                    q3.r = inflate;
                    q3.n = false;
                    SearchView searchView = (SearchView) inflate.findViewById(R.id.search_view);
                    ListView listView = (ListView) inflate.findViewById(R.id.list_view);
                    final C2924e2 c2924e2 = new C2924e2(vPNClient, vPNClient.a0, true);
                    listView.setAdapter((ListAdapter) c2924e2);
                    searchView.setOnQueryTextListener(new C3401k10(c2924e2));
                    u3.e(Deobfuscator$BDNETVPN$app.getString(-45972661827467L), new DialogInterfaceOnClickListenerC4500xw(c2924e2, 1));
                    final V3 a = u3.a();
                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: V00
                        @Override // android.widget.AdapterView.OnItemClickListener
                        public final void onItemClick(AdapterView adapterView, View view2, int i, long j) {
                            String str2 = VPNClient.f0;
                            VPNClient vPNClient2 = VPNClient.this;
                            JSONObject jSONObject = (JSONObject) c2924e2.a.get(i);
                            if (jSONObject != null) {
                                try {
                                    int v = VPNClient.v(new JSONObject(RQ.a(vPNClient2.B)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-72433955338123L)), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-72494084880267L)));
                                    vPNClient2.F();
                                    vPNClient2.x.setSelection(v);
                                } catch (JSONException unused) {
                                }
                            }
                            a.dismiss();
                        }
                    });
                    int h = vPNClient.m.h();
                    if (h >= 0 && h < c2924e2.a.size()) {
                        listView.setSelection(h);
                    }
                    a.show();
                }
                return true;
            default:
                return r00.a((lv2) obj, view, motionEvent);
        }
    }
}
