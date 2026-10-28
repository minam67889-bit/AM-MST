package defpackage;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* loaded from: classes2.dex */
public final class Z00 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ ImageView a;
    public final /* synthetic */ TextView b;
    public final /* synthetic */ View c;
    public final /* synthetic */ View d;
    public final /* synthetic */ View e;
    public final /* synthetic */ Switch f;
    public final /* synthetic */ TextView g;
    public final /* synthetic */ Spinner h;
    public final /* synthetic */ TextView i;
    public final /* synthetic */ TextView j;
    public final /* synthetic */ Spinner k;
    public final /* synthetic */ boolean[] l;
    public final /* synthetic */ VPNClient m;

    public Z00(VPNClient vPNClient, ImageView imageView, TextView textView, View view, View view2, View view3, Switch r7, TextView textView2, Spinner spinner, TextView textView3, TextView textView4, Spinner spinner2, boolean[] zArr) {
        this.m = vPNClient;
        this.a = imageView;
        this.b = textView;
        this.c = view;
        this.d = view2;
        this.e = view3;
        this.f = r7;
        this.g = textView2;
        this.h = spinner;
        this.i = textView3;
        this.j = textView4;
        this.k = spinner2;
        this.l = zArr;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        boolean[] zArr = this.l;
        Spinner spinner = this.k;
        TextView textView = this.j;
        TextView textView2 = this.i;
        Spinner spinner2 = this.h;
        TextView textView3 = this.g;
        Switch r8 = this.f;
        View view2 = this.e;
        View view3 = this.d;
        View view4 = this.c;
        TextView textView4 = this.b;
        ImageView imageView = this.a;
        VPNClient vPNClient = this.m;
        if (i == 0) {
            imageView.setVisibility(8);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-18643784923019L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-18648079890315L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-18652374857611L));
            vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-18656669824907L));
            view4.setVisibility(8);
            view3.setVisibility(8);
            view2.setVisibility(8);
            r8.setVisibility(8);
            textView3.setVisibility(8);
            spinner2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            spinner.setVisibility(8);
            zArr[0] = false;
            return;
        }
        if (i == 1) {
            imageView.setVisibility(0);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-18660964792203L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-18695324530571L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-18699619497867L));
            vPNClient.v.setHint(vPNClient.getString(R.string.payload_hint));
            view4.setVisibility(0);
            view3.setVisibility(8);
            view2.setVisibility(0);
            r8.setVisibility(0);
            textView3.setVisibility(0);
            spinner2.setVisibility(0);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            spinner.setVisibility(0);
            zArr[0] = false;
            return;
        }
        if (i == 2) {
            imageView.setVisibility(8);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-18716799367051L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-18755454072715L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-18759749040011L));
            vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-18776928909195L));
            view4.setVisibility(8);
            view3.setVisibility(8);
            view2.setVisibility(0);
            r8.setVisibility(8);
            textView3.setVisibility(8);
            spinner2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            spinner.setVisibility(8);
            zArr[0] = false;
            return;
        }
        if (i == 3) {
            imageView.setVisibility(0);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-18849943353227L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-18884303091595L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-18888598058891L));
            vPNClient.v.setHint(vPNClient.getString(R.string.payload_hint));
            view4.setVisibility(0);
            view3.setVisibility(0);
            view2.setVisibility(0);
            r8.setVisibility(8);
            textView3.setVisibility(0);
            spinner2.setVisibility(0);
            textView2.setVisibility(0);
            textView.setVisibility(0);
            spinner.setVisibility(0);
            zArr[0] = true;
            return;
        }
        if (i == 4) {
            imageView.setVisibility(8);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-18905777928075L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-18953022568331L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-18957317535627L));
            vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-18974497404811L));
            view4.setVisibility(8);
            view3.setVisibility(8);
            view2.setVisibility(0);
            r8.setVisibility(8);
            textView3.setVisibility(8);
            spinner2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            spinner.setVisibility(8);
            zArr[0] = false;
            return;
        }
        if (i == 5) {
            imageView.setVisibility(8);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-19026037012363L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-19030331979659L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-19034626946955L));
            vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-19038921914251L));
            view4.setVisibility(8);
            view3.setVisibility(8);
            view2.setVisibility(8);
            r8.setVisibility(8);
            textView3.setVisibility(8);
            spinner2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            spinner.setVisibility(8);
            zArr[0] = false;
            return;
        }
        if (i == 6) {
            imageView.setVisibility(8);
            textView4.setText(Deobfuscator$BDNETVPN$app.getString(-19043216881547L));
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-19047511848843L));
            vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-19051806816139L));
            vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-19056101783435L));
            view4.setVisibility(8);
            view3.setVisibility(8);
            view2.setVisibility(8);
            r8.setVisibility(8);
            textView3.setVisibility(8);
            spinner2.setVisibility(8);
            textView2.setVisibility(8);
            textView.setVisibility(8);
            spinner.setVisibility(8);
            zArr[0] = false;
            return;
        }
        imageView.setVisibility(8);
        textView4.setText(Deobfuscator$BDNETVPN$app.getString(-19060396750731L));
        vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-19064691718027L));
        vPNClient.w.setHint(Deobfuscator$BDNETVPN$app.getString(-19068986685323L));
        vPNClient.v.setHint(Deobfuscator$BDNETVPN$app.getString(-19073281652619L));
        view4.setVisibility(8);
        view3.setVisibility(8);
        view2.setVisibility(8);
        r8.setVisibility(8);
        textView3.setVisibility(8);
        spinner2.setVisibility(8);
        textView2.setVisibility(8);
        textView.setVisibility(8);
        spinner.setVisibility(8);
        zArr[0] = false;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
