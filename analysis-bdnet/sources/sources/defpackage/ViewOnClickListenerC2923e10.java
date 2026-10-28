package defpackage;

import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.utils.PUtils;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: e10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC2923e10 implements View.OnClickListener {
    public final /* synthetic */ EditText a;
    public final /* synthetic */ Spinner b;
    public final /* synthetic */ EditText c;
    public final /* synthetic */ String[] d;
    public final /* synthetic */ String[] e;
    public final /* synthetic */ V3 f;
    public final /* synthetic */ EditText g;
    public final /* synthetic */ EditText h;
    public final /* synthetic */ Switch i;
    public final /* synthetic */ Spinner j;
    public final /* synthetic */ VPNClient k;

    public ViewOnClickListenerC2923e10(VPNClient vPNClient, EditText editText, Spinner spinner, EditText editText2, String[] strArr, String[] strArr2, V3 v3, EditText editText3, EditText editText4, Switch r10, Spinner spinner2) {
        this.k = vPNClient;
        this.a = editText;
        this.b = spinner;
        this.c = editText2;
        this.d = strArr;
        this.e = strArr2;
        this.f = v3;
        this.g = editText3;
        this.h = editText4;
        this.i = r10;
        this.j = spinner2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String str;
        boolean z;
        int i;
        String str2;
        String str3;
        String str4;
        Spinner spinner;
        Spinner spinner2;
        String str5;
        String str6;
        String str7;
        Spinner spinner3;
        Spinner spinner4;
        String str8;
        String str9;
        String str10;
        Spinner spinner5;
        Spinner spinner6;
        String str11;
        String str12;
        String str13;
        Spinner spinner7;
        Spinner spinner8;
        EditText editText;
        int i2;
        String str14;
        String str15;
        String str16;
        Spinner spinner9;
        Spinner spinner10;
        String str17;
        String str18;
        String str19;
        Spinner spinner11;
        Spinner spinner12;
        String str20;
        String str21;
        String str22;
        Spinner spinner13;
        Spinner spinner14;
        String str23;
        String str24;
        String str25;
        Spinner spinner15;
        Spinner spinner16;
        String obj = this.a.getText().toString();
        boolean isEmpty = obj.isEmpty();
        VPNClient vPNClient = this.k;
        if (isEmpty) {
            SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-23471328163723L));
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= vPNClient.a0.size()) {
                str = obj;
                z = false;
                i = 1;
                break;
            } else {
                if (obj.equalsIgnoreCase(((JSONObject) vPNClient.a0.get(i3)).optString(Deobfuscator$BDNETVPN$app.getString(-23561522476939L), Deobfuscator$BDNETVPN$app.getString(-23621652019083L)))) {
                    str = obj;
                    z = true;
                    i = 1;
                    break;
                }
                i3++;
            }
        }
        while (z) {
            StringBuilder m = ZT.m(obj);
            m.append(Deobfuscator$BDNETVPN$app.getString(-23625946986379L));
            m.append(i);
            m.append(Deobfuscator$BDNETVPN$app.getString(-23638831888267L));
            str = m.toString();
            int i4 = 0;
            while (true) {
                if (i4 >= vPNClient.a0.size()) {
                    z = false;
                    break;
                } else {
                    if (str.equalsIgnoreCase(((JSONObject) vPNClient.a0.get(i4)).optString(Deobfuscator$BDNETVPN$app.getString(-23647421822859L), Deobfuscator$BDNETVPN$app.getString(-23707551365003L)))) {
                        z = true;
                        break;
                    }
                    i4++;
                }
            }
            i++;
        }
        int selectedItemPosition = this.b.getSelectedItemPosition();
        V3 v3 = this.f;
        String[] strArr = this.e;
        String[] strArr2 = this.d;
        EditText editText2 = this.c;
        if (selectedItemPosition == 0) {
            if (str.isEmpty()) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-23711846332299L));
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-23836400383883L), str);
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-23896529926027L), Deobfuscator$BDNETVPN$app.getString(-23930889664395L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-23935184631691L), Deobfuscator$BDNETVPN$app.getString(-23969544370059L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-23973839337355L), Deobfuscator$BDNETVPN$app.getString(-23995314173835L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24025378944907L), Deobfuscator$BDNETVPN$app.getString(-24046853781387L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24076918552459L), Deobfuscator$BDNETVPN$app.getString(-24111278290827L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24115573258123L), Deobfuscator$BDNETVPN$app.getString(-24149932996491L));
                } else {
                    jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24244422277003L), Deobfuscator$BDNETVPN$app.getString(-24278782015371L) + editText2.getText().toString());
                }
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24347501492107L), Deobfuscator$BDNETVPN$app.getString(-24377566263179L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24407631034251L), Deobfuscator$BDNETVPN$app.getString(-24433400838027L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24459170641803L), Deobfuscator$BDNETVPN$app.getString(-24484940445579L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24515005216651L), Deobfuscator$BDNETVPN$app.getString(-24553659922315L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24605199529867L), Deobfuscator$BDNETVPN$app.getString(-24665329072011L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24686803908491L), Deobfuscator$BDNETVPN$app.getString(-24729753581451L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24755523385227L), Deobfuscator$BDNETVPN$app.getString(-24811357960075L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24832832796555L), Deobfuscator$BDNETVPN$app.getString(-24892962338699L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24918732142475L), Deobfuscator$BDNETVPN$app.getString(-24965976782731L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-24974566717323L), Deobfuscator$BDNETVPN$app.getString(-25047581161355L));
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-25073350965131L), Deobfuscator$BDNETVPN$app.getString(-25146365409163L));
                String string = Deobfuscator$BDNETVPN$app.getString(-25159250311051L);
                str23 = vPNClient.T;
                jSONObject.put(string, str23);
                String string2 = Deobfuscator$BDNETVPN$app.getString(-25215084885899L);
                str24 = vPNClient.U;
                jSONObject.put(string2, str24);
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-25258034558859L), strArr2[0]);
                jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-25331049002891L), strArr[0]);
                String string3 = Deobfuscator$BDNETVPN$app.getString(-25386883577739L);
                str25 = vPNClient.V;
                jSONObject.put(string3, str25);
                JSONObject h = vPNClient.h();
                h.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-25451308087179L)).put(jSONObject);
                FileOutputStream fileOutputStream = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-25489962792843L)));
                fileOutputStream.write(F00.b(h.toString(2)).getBytes());
                fileOutputStream.flush();
                fileOutputStream.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-25545797367691L));
                v3.dismiss();
                vPNClient.F();
                final int i5 = 0;
                while (i5 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i5)).getString(Deobfuscator$BDNETVPN$app.getString(-25657466517387L)))) {
                        spinner15 = vPNClient.x;
                        spinner15.setSelection(i5 == 0 ? 1 : 0);
                        spinner16 = vPNClient.x;
                        final int i6 = 0;
                        spinner16.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i6) {
                                    case 0:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i5);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i5++;
                }
                vPNClient.M(str, jSONObject);
                return;
            } catch (Exception e) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-25717596059531L) + e.getMessage());
                return;
            }
        }
        Spinner spinner17 = this.j;
        Switch r14 = this.i;
        EditText editText3 = this.h;
        EditText editText4 = this.g;
        if (selectedItemPosition == 1) {
            String obj2 = vPNClient.v.getText().toString();
            String obj3 = editText4.getText().toString();
            String obj4 = editText3.getText().toString();
            if (obj2.isEmpty() || ((obj3.isEmpty() && !r14.isChecked()) || (obj4.isEmpty() && !r14.isChecked()))) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-25794905470859L));
                return;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-25919459522443L), str);
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-25979589064587L), PUtils.pEncrypt(vPNClient.getApplicationContext(), obj2));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26013948802955L), Deobfuscator$BDNETVPN$app.getString(-26048308541323L));
                if (r14.isChecked()) {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26190042462091L), Deobfuscator$BDNETVPN$app.getString(-26211517298571L));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26241582069643L), Deobfuscator$BDNETVPN$app.getString(-26263056906123L));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26275941808011L), Deobfuscator$BDNETVPN$app.getString(-26348956252043L));
                } else {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26052603508619L), PUtils.pEncrypt(vPNClient.getApplicationContext(), obj3));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26074078345099L), obj4);
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26095553181579L), Deobfuscator$BDNETVPN$app.getString(-26168567625611L));
                }
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26374726055819L), Deobfuscator$BDNETVPN$app.getString(-26409085794187L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26413380761483L), Deobfuscator$BDNETVPN$app.getString(-26447740499851L));
                } else {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26533639845771L), Deobfuscator$BDNETVPN$app.getString(-26567999584139L) + editText2.getText().toString());
                }
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26636719060875L), Deobfuscator$BDNETVPN$app.getString(-26666783831947L));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26688258668427L), Deobfuscator$BDNETVPN$app.getString(-26714028472203L));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26739798275979L), Deobfuscator$BDNETVPN$app.getString(-26765568079755L));
                if (spinner17.getSelectedItemPosition() == 0) {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26795632850827L), Deobfuscator$BDNETVPN$app.getString(-26834287556491L));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26860057360267L), Deobfuscator$BDNETVPN$app.getString(-26920186902411L));
                } else if (spinner17.getSelectedItemPosition() == 1) {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-26945956706187L), Deobfuscator$BDNETVPN$app.getString(-26984611411851L));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27018971150219L), Deobfuscator$BDNETVPN$app.getString(-27079100692363L));
                } else {
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27104870496139L), Deobfuscator$BDNETVPN$app.getString(-27143525201803L));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27195064809355L), Deobfuscator$BDNETVPN$app.getString(-27255194351499L));
                }
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27276669187979L), Deobfuscator$BDNETVPN$app.getString(-27319618860939L));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27345388664715L), Deobfuscator$BDNETVPN$app.getString(-27401223239563L));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27422698076043L), Deobfuscator$BDNETVPN$app.getString(-27482827618187L));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27508597421963L), Deobfuscator$BDNETVPN$app.getString(-27555842062219L));
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27564431996811L), Deobfuscator$BDNETVPN$app.getString(-27637446440843L));
                String string4 = Deobfuscator$BDNETVPN$app.getString(-27646036375435L);
                str20 = vPNClient.T;
                jSONObject2.put(string4, str20);
                String string5 = Deobfuscator$BDNETVPN$app.getString(-27701870950283L);
                str21 = vPNClient.U;
                jSONObject2.put(string5, str21);
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27744820623243L), strArr2[0]);
                jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-27817835067275L), strArr[0]);
                String string6 = Deobfuscator$BDNETVPN$app.getString(-27873669642123L);
                str22 = vPNClient.V;
                jSONObject2.put(string6, str22);
                JSONObject h2 = vPNClient.h();
                h2.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-27938094151563L)).put(jSONObject2);
                FileOutputStream fileOutputStream2 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-27976748857227L)));
                fileOutputStream2.write(F00.b(h2.toString(2)).getBytes());
                fileOutputStream2.flush();
                fileOutputStream2.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-28032583432075L));
                v3.dismiss();
                vPNClient.F();
                final int i7 = 0;
                while (i7 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i7)).getString(Deobfuscator$BDNETVPN$app.getString(-28144252581771L)))) {
                        spinner13 = vPNClient.x;
                        spinner13.setSelection(i7 == 0 ? 1 : 0);
                        spinner14 = vPNClient.x;
                        final int i8 = 1;
                        spinner14.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i8) {
                                    case 0:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i7);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i7++;
                }
                vPNClient.M(str, jSONObject2);
                return;
            } catch (Exception e2) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-28204382123915L) + e2.getMessage());
                return;
            }
        }
        if (selectedItemPosition == 2) {
            String obj5 = vPNClient.v.getText().toString();
            if (str.isEmpty() || obj5.isEmpty()) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-28281691535243L));
                return;
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28406245586827L), str);
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28466375128971L), Deobfuscator$BDNETVPN$app.getString(-28500734867339L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28505029834635L), PUtils.pEncrypt(vPNClient.getApplicationContext(), obj5));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28539389573003L), Deobfuscator$BDNETVPN$app.getString(-28560864409483L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28565159376779L), Deobfuscator$BDNETVPN$app.getString(-28586634213259L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28590929180555L), Deobfuscator$BDNETVPN$app.getString(-28625288918923L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28629583886219L), Deobfuscator$BDNETVPN$app.getString(-28663943624587L));
                } else {
                    jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28745548003211L), Deobfuscator$BDNETVPN$app.getString(-28779907741579L) + editText2.getText().toString());
                }
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28848627218315L), Deobfuscator$BDNETVPN$app.getString(-28878691989387L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28895871858571L), Deobfuscator$BDNETVPN$app.getString(-28921641662347L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-28947411466123L), Deobfuscator$BDNETVPN$app.getString(-28973181269899L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29003246040971L), Deobfuscator$BDNETVPN$app.getString(-29041900746635L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29093440354187L), Deobfuscator$BDNETVPN$app.getString(-29153569896331L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29175044732811L), Deobfuscator$BDNETVPN$app.getString(-29217994405771L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29243764209547L), Deobfuscator$BDNETVPN$app.getString(-29299598784395L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29321073620875L), Deobfuscator$BDNETVPN$app.getString(-29381203163019L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29402677999499L), Deobfuscator$BDNETVPN$app.getString(-29449922639755L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29458512574347L), Deobfuscator$BDNETVPN$app.getString(-29531527018379L));
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29557296822155L), Deobfuscator$BDNETVPN$app.getString(-29630311266187L));
                String string7 = Deobfuscator$BDNETVPN$app.getString(-29638901200779L);
                str17 = vPNClient.T;
                jSONObject3.put(string7, str17);
                String string8 = Deobfuscator$BDNETVPN$app.getString(-29694735775627L);
                str18 = vPNClient.U;
                jSONObject3.put(string8, str18);
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29737685448587L), strArr2[0]);
                jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-29810699892619L), strArr[0]);
                String string9 = Deobfuscator$BDNETVPN$app.getString(-29866534467467L);
                str19 = vPNClient.V;
                jSONObject3.put(string9, str19);
                JSONObject h3 = vPNClient.h();
                h3.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-29930958976907L)).put(jSONObject3);
                FileOutputStream fileOutputStream3 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-29969613682571L)));
                fileOutputStream3.write(F00.b(h3.toString(2)).getBytes());
                fileOutputStream3.flush();
                fileOutputStream3.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-30025448257419L));
                v3.dismiss();
                vPNClient.F();
                final int i9 = 0;
                while (i9 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i9)).getString(Deobfuscator$BDNETVPN$app.getString(-30137117407115L)))) {
                        spinner11 = vPNClient.x;
                        spinner11.setSelection(i9 == 0 ? 1 : 0);
                        spinner12 = vPNClient.x;
                        final int i10 = 2;
                        spinner12.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i10) {
                                    case 0:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i9);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i9++;
                }
                vPNClient.M(str, jSONObject3);
                return;
            } catch (Exception e3) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-30197246949259L) + e3.getMessage());
                return;
            }
        }
        if (selectedItemPosition == 3) {
            editText = vPNClient.w;
            String obj6 = editText.getText().toString();
            String obj7 = vPNClient.v.getText().toString();
            String obj8 = editText4.getText().toString();
            String obj9 = editText3.getText().toString();
            if (obj7.isEmpty() || ((obj8.isEmpty() && !r14.isChecked()) || ((obj9.isEmpty() && !r14.isChecked()) || obj6.isEmpty()))) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-30274556360587L));
                return;
            }
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30399110412171L), str);
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30459239954315L), PUtils.pEncrypt(vPNClient.getApplicationContext(), obj7));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30493599692683L), PUtils.pEncrypt(vPNClient.getApplicationContext(), obj6));
                if (r14.isChecked()) {
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30570909104011L), Deobfuscator$BDNETVPN$app.getString(-30592383940491L));
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30622448711563L), Deobfuscator$BDNETVPN$app.getString(-30643923548043L));
                } else {
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30527959431051L), PUtils.pEncrypt(vPNClient.getApplicationContext(), obj8));
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30549434267531L), obj9);
                }
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30661103417227L), Deobfuscator$BDNETVPN$app.getString(-30695463155595L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30699758122891L), Deobfuscator$BDNETVPN$app.getString(-30734117861259L));
                } else {
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30841492043659L), Deobfuscator$BDNETVPN$app.getString(-30875851782027L) + editText2.getText().toString());
                }
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30944571258763L), Deobfuscator$BDNETVPN$app.getString(-30974636029835L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-30996110866315L), Deobfuscator$BDNETVPN$app.getString(-31021880670091L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31043355506571L), Deobfuscator$BDNETVPN$app.getString(-31069125310347L));
                if (spinner17.getSelectedItemPosition() == 0) {
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31099190081419L), Deobfuscator$BDNETVPN$app.getString(-31137844787083L));
                    jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31163614590859L), Deobfuscator$BDNETVPN$app.getString(-31223744133003L));
                    i2 = 1;
                } else {
                    i2 = 1;
                    if (spinner17.getSelectedItemPosition() == 1) {
                        jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31249513936779L), Deobfuscator$BDNETVPN$app.getString(-31288168642443L));
                        jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31322528380811L), Deobfuscator$BDNETVPN$app.getString(-31382657922955L));
                    } else {
                        jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31408427726731L), Deobfuscator$BDNETVPN$app.getString(-31447082432395L));
                        jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31498622039947L), Deobfuscator$BDNETVPN$app.getString(-31558751582091L));
                    }
                }
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31580226418571L), Deobfuscator$BDNETVPN$app.getString(-31623176091531L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31648945895307L), Deobfuscator$BDNETVPN$app.getString(-31704780470155L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31726255306635L), Deobfuscator$BDNETVPN$app.getString(-31786384848779L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31812154652555L), Deobfuscator$BDNETVPN$app.getString(-31859399292811L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31867989227403L), Deobfuscator$BDNETVPN$app.getString(-31941003671435L));
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-31962478507915L), Deobfuscator$BDNETVPN$app.getString(-32035492951947L));
                String string10 = Deobfuscator$BDNETVPN$app.getString(-32044082886539L);
                str14 = vPNClient.T;
                jSONObject4.put(string10, str14);
                String string11 = Deobfuscator$BDNETVPN$app.getString(-32099917461387L);
                str15 = vPNClient.U;
                jSONObject4.put(string11, str15);
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-32142867134347L), strArr2[0]);
                jSONObject4.put(Deobfuscator$BDNETVPN$app.getString(-32215881578379L), strArr[0]);
                String string12 = Deobfuscator$BDNETVPN$app.getString(-32271716153227L);
                str16 = vPNClient.V;
                jSONObject4.put(string12, str16);
                JSONObject h4 = vPNClient.h();
                h4.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-32336140662667L)).put(jSONObject4);
                FileOutputStream fileOutputStream4 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-32374795368331L)));
                fileOutputStream4.write(F00.b(h4.toString(2)).getBytes());
                fileOutputStream4.flush();
                fileOutputStream4.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-32430629943179L));
                v3.dismiss();
                vPNClient.F();
                final int i11 = 0;
                while (i11 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i11)).getString(Deobfuscator$BDNETVPN$app.getString(-32542299092875L)))) {
                        spinner9 = vPNClient.x;
                        spinner9.setSelection(i11 == 0 ? i2 : 0);
                        spinner10 = vPNClient.x;
                        final int i12 = 3;
                        spinner10.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i12) {
                                    case 0:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i11);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i11++;
                }
                vPNClient.M(str, jSONObject4);
                return;
            } catch (Exception e4) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-32602428635019L) + e4.getMessage());
                return;
            }
        }
        if (selectedItemPosition == 4) {
            String obj10 = vPNClient.v.getText().toString();
            if (str.isEmpty() || obj10.isEmpty()) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-32679738046347L));
                return;
            }
            try {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-32804292097931L), str);
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-32864421640075L), Deobfuscator$BDNETVPN$app.getString(-32898781378443L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-32903076345739L), obj10);
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-32937436084107L), Deobfuscator$BDNETVPN$app.getString(-32958910920587L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-32988975691659L), Deobfuscator$BDNETVPN$app.getString(-33010450528139L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33040515299211L), Deobfuscator$BDNETVPN$app.getString(-33074875037579L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33079170004875L), Deobfuscator$BDNETVPN$app.getString(-33113529743243L));
                } else {
                    jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33212313991051L), Deobfuscator$BDNETVPN$app.getString(-33246673729419L) + editText2.getText().toString());
                }
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33315393206155L), Deobfuscator$BDNETVPN$app.getString(-33345457977227L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33366932813707L), Deobfuscator$BDNETVPN$app.getString(-33392702617483L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33418472421259L), Deobfuscator$BDNETVPN$app.getString(-33444242225035L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33478601963403L), Deobfuscator$BDNETVPN$app.getString(-33517256669067L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33564501309323L), Deobfuscator$BDNETVPN$app.getString(-33624630851467L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33650400655243L), Deobfuscator$BDNETVPN$app.getString(-33693350328203L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33719120131979L), Deobfuscator$BDNETVPN$app.getString(-33774954706827L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33796429543307L), Deobfuscator$BDNETVPN$app.getString(-33856559085451L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33882328889227L), Deobfuscator$BDNETVPN$app.getString(-33929573529483L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-33938163464075L), Deobfuscator$BDNETVPN$app.getString(-34011177908107L));
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-34036947711883L), Deobfuscator$BDNETVPN$app.getString(-34109962155915L));
                String string13 = Deobfuscator$BDNETVPN$app.getString(-34122847057803L);
                str11 = vPNClient.T;
                jSONObject5.put(string13, str11);
                String string14 = Deobfuscator$BDNETVPN$app.getString(-34178681632651L);
                str12 = vPNClient.U;
                jSONObject5.put(string14, str12);
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-34221631305611L), strArr2[0]);
                jSONObject5.put(Deobfuscator$BDNETVPN$app.getString(-34294645749643L), strArr[0]);
                String string15 = Deobfuscator$BDNETVPN$app.getString(-34350480324491L);
                str13 = vPNClient.V;
                jSONObject5.put(string15, str13);
                JSONObject h5 = vPNClient.h();
                h5.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-34414904833931L)).put(jSONObject5);
                FileOutputStream fileOutputStream5 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-34453559539595L)));
                fileOutputStream5.write(F00.b(h5.toString(2)).getBytes());
                fileOutputStream5.flush();
                fileOutputStream5.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-34509394114443L));
                v3.dismiss();
                vPNClient.F();
                final int i13 = 0;
                while (i13 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i13)).getString(Deobfuscator$BDNETVPN$app.getString(-34621063264139L)))) {
                        spinner7 = vPNClient.x;
                        spinner7.setSelection(i13 == 0 ? 1 : 0);
                        spinner8 = vPNClient.x;
                        final int i14 = 4;
                        spinner8.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i14) {
                                    case 0:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i13);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i13++;
                }
                vPNClient.M(str, jSONObject5);
                return;
            } catch (Exception e5) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-34681192806283L) + e5.getMessage());
                return;
            }
        }
        if (selectedItemPosition == 5) {
            if (str.isEmpty()) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-34758502217611L));
                return;
            }
            try {
                JSONObject jSONObject6 = new JSONObject();
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-34883056269195L), str);
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-34943185811339L), Deobfuscator$BDNETVPN$app.getString(-34977545549707L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-34981840517003L), Deobfuscator$BDNETVPN$app.getString(-35016200255371L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35020495222667L), Deobfuscator$BDNETVPN$app.getString(-35041970059147L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35072034830219L), Deobfuscator$BDNETVPN$app.getString(-35093509666699L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35123574437771L), Deobfuscator$BDNETVPN$app.getString(-35157934176139L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35162229143435L), Deobfuscator$BDNETVPN$app.getString(-35196588881803L));
                } else {
                    jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35295373129611L), Deobfuscator$BDNETVPN$app.getString(-35329732867979L) + editText2.getText().toString());
                }
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35398452344715L), Deobfuscator$BDNETVPN$app.getString(-35428517115787L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35449991952267L), Deobfuscator$BDNETVPN$app.getString(-35475761756043L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35501531559819L), Deobfuscator$BDNETVPN$app.getString(-35527301363595L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35561661101963L), Deobfuscator$BDNETVPN$app.getString(-35600315807627L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35647560447883L), Deobfuscator$BDNETVPN$app.getString(-35707689990027L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35733459793803L), Deobfuscator$BDNETVPN$app.getString(-35776409466763L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35802179270539L), Deobfuscator$BDNETVPN$app.getString(-35858013845387L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35879488681867L), Deobfuscator$BDNETVPN$app.getString(-35939618224011L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-35965388027787L), Deobfuscator$BDNETVPN$app.getString(-36012632668043L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-36021222602635L), Deobfuscator$BDNETVPN$app.getString(-36094237046667L));
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-36120006850443L), Deobfuscator$BDNETVPN$app.getString(-36193021294475L));
                String string16 = Deobfuscator$BDNETVPN$app.getString(-36205906196363L);
                str8 = vPNClient.T;
                jSONObject6.put(string16, str8);
                String string17 = Deobfuscator$BDNETVPN$app.getString(-36261740771211L);
                str9 = vPNClient.U;
                jSONObject6.put(string17, str9);
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-36304690444171L), strArr2[0]);
                jSONObject6.put(Deobfuscator$BDNETVPN$app.getString(-36377704888203L), strArr[0]);
                String string18 = Deobfuscator$BDNETVPN$app.getString(-36433539463051L);
                str10 = vPNClient.V;
                jSONObject6.put(string18, str10);
                JSONObject h6 = vPNClient.h();
                h6.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-36497963972491L)).put(jSONObject6);
                FileOutputStream fileOutputStream6 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-36536618678155L)));
                fileOutputStream6.write(F00.b(h6.toString(2)).getBytes());
                fileOutputStream6.flush();
                fileOutputStream6.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-36592453253003L));
                v3.dismiss();
                vPNClient.F();
                final int i15 = 0;
                while (i15 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i15)).getString(Deobfuscator$BDNETVPN$app.getString(-36704122402699L)))) {
                        spinner5 = vPNClient.x;
                        spinner5.setSelection(i15 == 0 ? 1 : 0);
                        spinner6 = vPNClient.x;
                        final int i16 = 5;
                        spinner6.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i16) {
                                    case 0:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i15);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i15++;
                }
                vPNClient.M(str, jSONObject6);
                return;
            } catch (Exception e6) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-36764251944843L) + e6.getMessage());
                return;
            }
        }
        if (selectedItemPosition == 6) {
            if (str.isEmpty()) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-36841561356171L));
                return;
            }
            try {
                JSONObject jSONObject7 = new JSONObject();
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-36966115407755L), str);
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37026244949899L), Deobfuscator$BDNETVPN$app.getString(-37060604688267L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37064899655563L), Deobfuscator$BDNETVPN$app.getString(-37099259393931L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37103554361227L), Deobfuscator$BDNETVPN$app.getString(-37125029197707L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37155093968779L), Deobfuscator$BDNETVPN$app.getString(-37176568805259L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37223813445515L), Deobfuscator$BDNETVPN$app.getString(-37258173183883L));
                if (editText2.getText().toString().isEmpty()) {
                    jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37262468151179L), Deobfuscator$BDNETVPN$app.getString(-37296827889547L));
                } else {
                    jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37382727235467L), Deobfuscator$BDNETVPN$app.getString(-37417086973835L) + editText2.getText().toString());
                }
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37485806450571L), Deobfuscator$BDNETVPN$app.getString(-37515871221643L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37533051090827L), Deobfuscator$BDNETVPN$app.getString(-37558820894603L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37584590698379L), Deobfuscator$BDNETVPN$app.getString(-37610360502155L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37640425273227L), Deobfuscator$BDNETVPN$app.getString(-37679079978891L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37709144749963L), Deobfuscator$BDNETVPN$app.getString(-37769274292107L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37795044095883L), Deobfuscator$BDNETVPN$app.getString(-37837993768843L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37863763572619L), Deobfuscator$BDNETVPN$app.getString(-37919598147467L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-37941072983947L), Deobfuscator$BDNETVPN$app.getString(-38001202526091L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-38026972329867L), Deobfuscator$BDNETVPN$app.getString(-38074216970123L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-38082806904715L), Deobfuscator$BDNETVPN$app.getString(-38155821348747L));
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-38181591152523L), Deobfuscator$BDNETVPN$app.getString(-38254605596555L));
                String string19 = Deobfuscator$BDNETVPN$app.getString(-38267490498443L);
                str5 = vPNClient.T;
                jSONObject7.put(string19, str5);
                String string20 = Deobfuscator$BDNETVPN$app.getString(-38323325073291L);
                str6 = vPNClient.U;
                jSONObject7.put(string20, str6);
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-38366274746251L), strArr2[0]);
                jSONObject7.put(Deobfuscator$BDNETVPN$app.getString(-38439289190283L), strArr[0]);
                String string21 = Deobfuscator$BDNETVPN$app.getString(-38495123765131L);
                str7 = vPNClient.V;
                jSONObject7.put(string21, str7);
                JSONObject h7 = vPNClient.h();
                h7.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-38559548274571L)).put(jSONObject7);
                FileOutputStream fileOutputStream7 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-38598202980235L)));
                fileOutputStream7.write(F00.b(h7.toString(2)).getBytes());
                fileOutputStream7.flush();
                fileOutputStream7.close();
                SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-38654037555083L));
                v3.dismiss();
                vPNClient.F();
                final int i17 = 0;
                while (i17 < vPNClient.a0.size()) {
                    if (str.equals(((JSONObject) vPNClient.a0.get(i17)).getString(Deobfuscator$BDNETVPN$app.getString(-38765706704779L)))) {
                        spinner3 = vPNClient.x;
                        spinner3.setSelection(i17 == 0 ? 1 : 0);
                        spinner4 = vPNClient.x;
                        final int i18 = 6;
                        spinner4.postDelayed(new Runnable(this) { // from class: d10
                            public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                            {
                                this.b = this;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                switch (i18) {
                                    case 0:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    case 1:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    case 2:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    case 3:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    case 4:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    case 5:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    case 6:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                    default:
                                        this.b.k.x.setSelection(i17);
                                        break;
                                }
                            }
                        }, 100L);
                    }
                    i17++;
                }
                vPNClient.M(str, jSONObject7);
                return;
            } catch (Exception e7) {
                SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-38825836246923L) + e7.getMessage());
                return;
            }
        }
        if (str.isEmpty()) {
            SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-38903145658251L));
            return;
        }
        try {
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39027699709835L), str);
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39087829251979L), Deobfuscator$BDNETVPN$app.getString(-39122188990347L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39126483957643L), Deobfuscator$BDNETVPN$app.getString(-39160843696011L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39165138663307L), Deobfuscator$BDNETVPN$app.getString(-39186613499787L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39216678270859L), Deobfuscator$BDNETVPN$app.getString(-39238153107339L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39268217878411L), Deobfuscator$BDNETVPN$app.getString(-39302577616779L));
            if (editText2.getText().toString().isEmpty()) {
                jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39306872584075L), Deobfuscator$BDNETVPN$app.getString(-39341232322443L));
            } else {
                jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39457196439435L), Deobfuscator$BDNETVPN$app.getString(-39491556177803L) + editText2.getText().toString());
            }
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39560275654539L), Deobfuscator$BDNETVPN$app.getString(-39590340425611L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39611815262091L), Deobfuscator$BDNETVPN$app.getString(-39637585065867L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39663354869643L), Deobfuscator$BDNETVPN$app.getString(-39689124673419L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39719189444491L), Deobfuscator$BDNETVPN$app.getString(-39757844150155L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39800793823115L), Deobfuscator$BDNETVPN$app.getString(-39860923365259L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39886693169035L), Deobfuscator$BDNETVPN$app.getString(-39929642841995L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-39955412645771L), Deobfuscator$BDNETVPN$app.getString(-40011247220619L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-40032722057099L), Deobfuscator$BDNETVPN$app.getString(-40092851599243L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-40118621403019L), Deobfuscator$BDNETVPN$app.getString(-40165866043275L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-40174455977867L), Deobfuscator$BDNETVPN$app.getString(-40247470421899L));
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-40273240225675L), Deobfuscator$BDNETVPN$app.getString(-40346254669707L));
            String string22 = Deobfuscator$BDNETVPN$app.getString(-40359139571595L);
            str2 = vPNClient.T;
            jSONObject8.put(string22, str2);
            String string23 = Deobfuscator$BDNETVPN$app.getString(-40414974146443L);
            str3 = vPNClient.U;
            jSONObject8.put(string23, str3);
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-40457923819403L), strArr2[0]);
            jSONObject8.put(Deobfuscator$BDNETVPN$app.getString(-40530938263435L), strArr[0]);
            String string24 = Deobfuscator$BDNETVPN$app.getString(-40586772838283L);
            str4 = vPNClient.V;
            jSONObject8.put(string24, str4);
            JSONObject h8 = vPNClient.h();
            h8.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-40651197347723L)).put(jSONObject8);
            FileOutputStream fileOutputStream8 = new FileOutputStream(new File(vPNClient.getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-40689852053387L)));
            fileOutputStream8.write(F00.b(h8.toString(2)).getBytes());
            fileOutputStream8.flush();
            fileOutputStream8.close();
            SweetToast.success(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-40745686628235L));
            v3.dismiss();
            vPNClient.F();
            final int i19 = 0;
            while (i19 < vPNClient.a0.size()) {
                if (str.equals(((JSONObject) vPNClient.a0.get(i19)).getString(Deobfuscator$BDNETVPN$app.getString(-40857355777931L)))) {
                    spinner = vPNClient.x;
                    spinner.setSelection(i19 == 0 ? 1 : 0);
                    spinner2 = vPNClient.x;
                    final int i20 = 7;
                    spinner2.postDelayed(new Runnable(this) { // from class: d10
                        public final /* synthetic */ ViewOnClickListenerC2923e10 b;

                        {
                            this.b = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            switch (i20) {
                                case 0:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                case 1:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                case 2:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                case 3:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                case 4:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                case 5:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                case 6:
                                    this.b.k.x.setSelection(i19);
                                    break;
                                default:
                                    this.b.k.x.setSelection(i19);
                                    break;
                            }
                        }
                    }, 100L);
                }
                i19++;
            }
            vPNClient.M(str, jSONObject8);
        } catch (Exception e8) {
            SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-40917485320075L) + e8.getMessage());
        }
    }
}
