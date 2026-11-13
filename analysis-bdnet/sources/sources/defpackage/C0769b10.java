package defpackage;

import android.view.View;
import android.widget.AdapterView;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: b10, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0769b10 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ boolean[] a;
    public final /* synthetic */ VPNClient b;

    public C0769b10(VPNClient vPNClient, boolean[] zArr) {
        this.b = vPNClient;
        this.a = zArr;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        boolean[] zArr = this.a;
        VPNClient vPNClient = this.b;
        if (i == 0) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-19086166554507L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-19090461521803L));
                return;
            }
            return;
        }
        if (i == 1) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-19094756489099L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-19584382760843L));
                return;
            }
            return;
        }
        if (i == 2) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-19605857597323L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-20147023476619L));
                return;
            }
            return;
        }
        if (i == 3) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-20168498313099L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-20881462884235L));
                return;
            }
            return;
        }
        if (i == 4) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-20902937720715L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-21671736866699L));
                return;
            }
            return;
        }
        if (i == 5) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-21693211703179L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-22376111503243L));
                return;
            }
            return;
        }
        if (i == 6) {
            vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-22397586339723L));
            if (zArr[0]) {
                vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-23136320714635L));
                return;
            }
            return;
        }
        vPNClient.v.setText(Deobfuscator$BDNETVPN$app.getString(-23157795551115L));
        if (zArr[0]) {
            vPNClient.w.setText(Deobfuscator$BDNETVPN$app.getString(-23467033196427L));
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
