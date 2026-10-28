package defpackage;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import org.json.JSONException;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: c10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC0848c10 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNClient b;

    public /* synthetic */ ViewOnClickListenerC0848c10(VPNClient vPNClient, int i) {
        this.a = i;
        this.b = vPNClient;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str = null;
        VPNClient vPNClient = this.b;
        switch (this.a) {
            case 0:
                C0136Ew c0136Ew = new C0136Ew((char) 0, 20);
                c0136Ew.b = vPNClient;
                DialogInterfaceOnCancelListenerC0471Ru dialogInterfaceOnCancelListenerC0471Ru = new DialogInterfaceOnCancelListenerC0471Ru();
                dialogInterfaceOnCancelListenerC0471Ru.d = vPNClient;
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(vPNClient);
                dialogInterfaceOnCancelListenerC0471Ru.f = defaultSharedPreferences;
                dialogInterfaceOnCancelListenerC0471Ru.g = defaultSharedPreferences.edit();
                View inflate = LayoutInflater.from(vPNClient).inflate(R.layout.generator_main, (ViewGroup) null);
                dialogInterfaceOnCancelListenerC0471Ru.h = (EditText) inflate.findViewById(R.id.url_host);
                dialogInterfaceOnCancelListenerC0471Ru.b = (RadioGroup) inflate.findViewById(R.id.split_group);
                dialogInterfaceOnCancelListenerC0471Ru.i = (Spinner) inflate.findViewById(R.id.request_method);
                dialogInterfaceOnCancelListenerC0471Ru.j = (Spinner) inflate.findViewById(R.id.inject_method);
                dialogInterfaceOnCancelListenerC0471Ru.k = (RadioGroup) inflate.findViewById(R.id.query_mode);
                dialogInterfaceOnCancelListenerC0471Ru.l = (CheckBox) inflate.findViewById(R.id.online_host);
                dialogInterfaceOnCancelListenerC0471Ru.m = (CheckBox) inflate.findViewById(R.id.forward_host);
                dialogInterfaceOnCancelListenerC0471Ru.n = (CheckBox) inflate.findViewById(R.id.reverse_proxy);
                dialogInterfaceOnCancelListenerC0471Ru.o = (CheckBox) inflate.findViewById(R.id.keep_alive);
                dialogInterfaceOnCancelListenerC0471Ru.p = (CheckBox) inflate.findViewById(R.id.paygen_proxy_auth);
                dialogInterfaceOnCancelListenerC0471Ru.q = (CheckBox) inflate.findViewById(R.id.dual_connect);
                dialogInterfaceOnCancelListenerC0471Ru.r = (Button) inflate.findViewById(R.id.generate_payload);
                dialogInterfaceOnCancelListenerC0471Ru.a = inflate.findViewById(R.id.close_generator_dialog);
                dialogInterfaceOnCancelListenerC0471Ru.i.setAdapter((SpinnerAdapter) new ArrayAdapter(vPNClient, R.layout.spinner_item, new String[]{"CONNECT", "GET", "POST", "HEAD", "PUT", "PATCH", "DELETE"}));
                dialogInterfaceOnCancelListenerC0471Ru.j.setAdapter((SpinnerAdapter) new ArrayAdapter(vPNClient, R.layout.spinner_item, new String[]{"Normal", "Front Inject", "Back Inject"}));
                ((RadioButton) dialogInterfaceOnCancelListenerC0471Ru.k.getChildAt(dialogInterfaceOnCancelListenerC0471Ru.f.getInt("QUERY_MODE", 0))).setChecked(true);
                ((RadioButton) dialogInterfaceOnCancelListenerC0471Ru.b.getChildAt(dialogInterfaceOnCancelListenerC0471Ru.f.getInt("Split", 2))).setChecked(true);
                dialogInterfaceOnCancelListenerC0471Ru.h.setText(dialogInterfaceOnCancelListenerC0471Ru.f.getString("URL_HOST", ""));
                dialogInterfaceOnCancelListenerC0471Ru.i.setSelection(dialogInterfaceOnCancelListenerC0471Ru.f.getInt("SELECTED_REQUEST_METHOD", 0), false);
                dialogInterfaceOnCancelListenerC0471Ru.j.setSelection(dialogInterfaceOnCancelListenerC0471Ru.f.getInt("SELECTED_INJECT_METHOD", 0), false);
                dialogInterfaceOnCancelListenerC0471Ru.l.setChecked(dialogInterfaceOnCancelListenerC0471Ru.f.getBoolean("ONLINE_HOST", false));
                dialogInterfaceOnCancelListenerC0471Ru.m.setChecked(dialogInterfaceOnCancelListenerC0471Ru.f.getBoolean("FORWARD_HOST", false));
                dialogInterfaceOnCancelListenerC0471Ru.n.setChecked(dialogInterfaceOnCancelListenerC0471Ru.f.getBoolean("REVERSE_PROXY", false));
                dialogInterfaceOnCancelListenerC0471Ru.o.setChecked(dialogInterfaceOnCancelListenerC0471Ru.f.getBoolean("KEEP_ALIVE", false));
                dialogInterfaceOnCancelListenerC0471Ru.p.setChecked(dialogInterfaceOnCancelListenerC0471Ru.f.getBoolean("PROXY_AUTH", false));
                dialogInterfaceOnCancelListenerC0471Ru.q.setChecked(dialogInterfaceOnCancelListenerC0471Ru.f.getBoolean("DUAL_CONNECT", false));
                dialogInterfaceOnCancelListenerC0471Ru.b.setOnCheckedChangeListener(dialogInterfaceOnCancelListenerC0471Ru);
                dialogInterfaceOnCancelListenerC0471Ru.i.setOnItemSelectedListener(dialogInterfaceOnCancelListenerC0471Ru);
                dialogInterfaceOnCancelListenerC0471Ru.j.setOnItemSelectedListener(dialogInterfaceOnCancelListenerC0471Ru);
                dialogInterfaceOnCancelListenerC0471Ru.k.setOnCheckedChangeListener(dialogInterfaceOnCancelListenerC0471Ru);
                dialogInterfaceOnCancelListenerC0471Ru.r.setOnClickListener(dialogInterfaceOnCancelListenerC0471Ru);
                dialogInterfaceOnCancelListenerC0471Ru.a.setOnClickListener(dialogInterfaceOnCancelListenerC0471Ru);
                V3 a = new U3(vPNClient).a();
                dialogInterfaceOnCancelListenerC0471Ru.c = a;
                T3 t3 = a.g;
                t3.g = inflate;
                t3.h = false;
                a.setOnCancelListener(dialogInterfaceOnCancelListenerC0471Ru);
                dialogInterfaceOnCancelListenerC0471Ru.e = c0136Ew;
                dialogInterfaceOnCancelListenerC0471Ru.c.show();
                return;
            case 1:
                String str2 = VPNClient.f0;
                ArrayList arrayList = new ArrayList();
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47368526198667L), -16738048, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_updates)));
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47398590969739L), -11046774, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_plane)));
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47437245675403L), -23296, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_fb_group)));
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47480195348363L), -8388608, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_tunnel_types)));
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47548914825099L), -16777077, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_radio)));
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47591864498059L), -16738048, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_status)));
                arrayList.add(new KS(Deobfuscator$BDNETVPN$app.getString(-47613339334539L), -2541267, BitmapFactory.decodeResource(vPNClient.getResources(), R.drawable.ic_exit)));
                C0287Kr c0287Kr = new C0287Kr(vPNClient.getBaseContext(), vPNClient.getWindow(), view);
                c0287Kr.setShareItemList(arrayList);
                c0287Kr.setItemDuration(200);
                c0287Kr.setBackgroundColor(1610612736);
                c0287Kr.setAnimType(1);
                c0287Kr.setSeparateLineColor(0);
                ArrayList arrayList2 = c0287Kr.v;
                if (arrayList2.size() == 0) {
                    throw new RuntimeException("At least set one shareItem");
                }
                ArrayList arrayList3 = c0287Kr.y;
                arrayList3.clear();
                for (int i = 0; i < arrayList2.size(); i++) {
                    ArrayList arrayList4 = new ArrayList();
                    int i2 = c0287Kr.a;
                    ValueAnimator ofFloat = i2 != 1 ? i2 != 2 ? ValueAnimator.ofFloat(0.0f) : ValueAnimator.ofFloat(0.0f, -3.0f, 0.0f) : ValueAnimator.ofFloat(0.0f, 3.0f, 0.0f);
                    ofFloat.addUpdateListener(new C0244Ja(c0287Kr, 2));
                    ValueAnimator ofFloat2 = ValueAnimator.ofFloat(-90.0f, 8.0f, 0.0f);
                    ofFloat2.addUpdateListener(new C0183Gr(c0287Kr, i));
                    arrayList4.add(ofFloat2);
                    arrayList4.add(ofFloat);
                    AnimatorSet animatorSet = new AnimatorSet();
                    animatorSet.setDuration(c0287Kr.i);
                    animatorSet.setInterpolator(new LinearInterpolator());
                    animatorSet.playTogether(arrayList4);
                    arrayList3.add(animatorSet);
                    animatorSet.addListener(new C0209Hr(c0287Kr, i));
                }
                ((AnimatorSet) arrayList3.get(0)).start();
                c0287Kr.setOnFlipClickListener(new W00(vPNClient));
                return;
            default:
                String str3 = VPNClient.f0;
                try {
                    str = vPNClient.h().getString(Deobfuscator$BDNETVPN$app.getString(-68160462878603L));
                } catch (JSONException unused) {
                }
                if (str.equals(Deobfuscator$BDNETVPN$app.getString(-41299737409419L))) {
                    F00.i(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-41304032376715L));
                    return;
                } else {
                    vPNClient.L();
                    return;
                }
        }
    }
}
