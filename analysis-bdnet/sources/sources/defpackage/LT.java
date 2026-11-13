package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes.dex */
public final /* synthetic */ class LT implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ LT(int i, Object obj, Object obj2) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Object obj = this.c;
        Object obj2 = this.b;
        switch (this.a) {
            case 0:
                ((ViewOnClickListenerC2840d) obj).onClick(view);
                ((MT) obj2).a(1);
                break;
            default:
                String str = VPNClient.f0;
                VPNClient vPNClient = (VPNClient) obj2;
                View inflate = vPNClient.getLayoutInflater().inflate(R.layout.custom_tweak_dialog, (ViewGroup) null);
                EditText editText = (EditText) inflate.findViewById(R.id.custom_tweak_name);
                EditText editText2 = (EditText) inflate.findViewById(R.id.custom_tweak_message);
                editText2.setHint(Deobfuscator$BDNETVPN$app.getString(-49700693440395L));
                Spinner spinner = (Spinner) inflate.findViewById(R.id.custom_tweak_mode);
                TextView textView = (TextView) inflate.findViewById(R.id.custom_preload_title);
                Spinner spinner2 = (Spinner) inflate.findViewById(R.id.preload_pay);
                TextView textView2 = (TextView) inflate.findViewById(R.id.tweak_type_title);
                Spinner spinner3 = (Spinner) inflate.findViewById(R.id.custom_tweak_type);
                TextView textView3 = (TextView) inflate.findViewById(R.id.tweak_mode_title);
                TextView textView4 = (TextView) inflate.findViewById(R.id.proxy_settings);
                vPNClient.v = (EditText) inflate.findViewById(R.id.custom_tweak_edit);
                vPNClient.w = (EditText) inflate.findViewById(R.id.custom_tweak_sni);
                EditText editText3 = (EditText) inflate.findViewById(R.id.custom_tweak_proxy);
                EditText editText4 = (EditText) inflate.findViewById(R.id.custom_tweak_proxy_port);
                Switch r4 = (Switch) inflate.findViewById(R.id.custom_tweak_default_proxy);
                View findViewById = inflate.findViewById(R.id.custom_tweak_proxy_layout);
                View findViewById2 = inflate.findViewById(R.id.custom_tweak_sni_layout);
                View findViewById3 = inflate.findViewById(R.id.payload_lay);
                ImageView imageView = (ImageView) inflate.findViewById(R.id.custom_tweak_generate);
                vPNClient.L = (CheckBox) inflate.findViewById(R.id.tweak_expiry_date);
                vPNClient.M = (CheckBox) inflate.findViewById(R.id.tweak_hwid_lock);
                vPNClient.N = (CheckBox) inflate.findViewById(R.id.tweak_password_lock);
                CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.tweak_mobile_data);
                CheckBox checkBox2 = (CheckBox) inflate.findViewById(R.id.tweak_block_root);
                vPNClient.T = Deobfuscator$BDNETVPN$app.getString(-49739348146059L);
                vPNClient.U = Deobfuscator$BDNETVPN$app.getString(-49743643113355L);
                vPNClient.V = Deobfuscator$BDNETVPN$app.getString(-49747938080651L);
                String[] strArr = {Deobfuscator$BDNETVPN$app.getString(-49752233047947L)};
                String[] strArr2 = {Deobfuscator$BDNETVPN$app.getString(-49778002851723L)};
                vPNClient.L.setOnCheckedChangeListener(new X00(vPNClient, 0));
                vPNClient.M.setOnCheckedChangeListener(new X00(vPNClient, 1));
                vPNClient.N.setOnCheckedChangeListener(new X00(vPNClient, 3));
                checkBox.setOnCheckedChangeListener(new Y00(strArr, 0));
                checkBox2.setOnCheckedChangeListener(new Y00(strArr2, 1));
                imageView.setVisibility(8);
                textView3.setText(Deobfuscator$BDNETVPN$app.getString(-49803772655499L));
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-49808067622795L));
                vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-49812362590091L));
                vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-49816657557387L));
                findViewById.setVisibility(8);
                findViewById2.setVisibility(8);
                findViewById3.setVisibility(8);
                r4.setVisibility(8);
                textView.setVisibility(8);
                spinner2.setVisibility(8);
                textView4.setVisibility(8);
                textView2.setVisibility(8);
                spinner3.setVisibility(8);
                boolean[] zArr = {false};
                String[] strArr3 = {Deobfuscator$BDNETVPN$app.getString(-49820952524683L), Deobfuscator$BDNETVPN$app.getString(-49851017295755L), Deobfuscator$BDNETVPN$app.getString(-49872492132235L), Deobfuscator$BDNETVPN$app.getString(-49889672001419L), Deobfuscator$BDNETVPN$app.getString(-49932621674379L), Deobfuscator$BDNETVPN$app.getString(-49966981412747L), Deobfuscator$BDNETVPN$app.getString(-50001341151115L), Deobfuscator$BDNETVPN$app.getString(-50022815987595L)};
                String[] strArr4 = {Deobfuscator$BDNETVPN$app.getString(-50074355595147L), Deobfuscator$BDNETVPN$app.getString(-50121600235403L), Deobfuscator$BDNETVPN$app.getString(-50168844875659L)};
                String[] strArr5 = {Deobfuscator$BDNETVPN$app.getString(-50198909646731L), Deobfuscator$BDNETVPN$app.getString(-50220384483211L), Deobfuscator$BDNETVPN$app.getString(-50271924090763L), Deobfuscator$BDNETVPN$app.getString(-50323463698315L), Deobfuscator$BDNETVPN$app.getString(-50426542913419L), Deobfuscator$BDNETVPN$app.getString(-50512442259339L), Deobfuscator$BDNETVPN$app.getString(-50611226507147L), Deobfuscator$BDNETVPN$app.getString(-50692830885771L)};
                spinner.setAdapter((SpinnerAdapter) new ArrayAdapter(vPNClient, android.R.layout.simple_dropdown_item_1line, strArr3));
                spinner.setSelection(0, false);
                spinner.setOnItemSelectedListener(new Z00(vPNClient, imageView, textView3, findViewById, findViewById2, findViewById3, r4, textView, spinner2, textView4, textView2, spinner3, zArr));
                spinner3.setAdapter((SpinnerAdapter) new ArrayAdapter(vPNClient, android.R.layout.simple_dropdown_item_1line, strArr4));
                spinner3.setSelection(0, false);
                r4.setOnCheckedChangeListener(new C0689a10(findViewById, editText3, editText4));
                spinner2.setAdapter((SpinnerAdapter) new ArrayAdapter(vPNClient, android.R.layout.simple_dropdown_item_1line, strArr5));
                spinner2.setSelection(0, false);
                spinner2.setOnItemSelectedListener(new C0769b10(vPNClient, zArr));
                Button button = (Button) inflate.findViewById(R.id.custok_tweak_save);
                V3 a = new U3(vPNClient, R.style.MyDialogTheme).a();
                a.setTitle(Deobfuscator$BDNETVPN$app.getString(-50757255395211L));
                T3 t3 = a.g;
                t3.g = inflate;
                t3.h = false;
                imageView.setOnClickListener(new ViewOnClickListenerC0848c10(vPNClient, 0));
                button.setOnClickListener(new ViewOnClickListenerC2923e10(vPNClient, editText, spinner, editText2, strArr, strArr2, a, editText3, editText4, r4, spinner3));
                a.show();
                ((V3) obj).dismiss();
                break;
        }
    }
}
