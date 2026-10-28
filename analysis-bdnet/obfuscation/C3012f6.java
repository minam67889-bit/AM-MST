package defpackage;

import android.widget.CompoundButton;
import androidx.appcompat.widget.SwitchCompat;
import dastan.prince.bdfreevpn.R;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.AppListActivity;

/* renamed from: f6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3012f6 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ SwitchCompat a;
    public final /* synthetic */ AppListActivity b;

    public C3012f6(AppListActivity appListActivity, SwitchCompat switchCompat) {
        this.b = appListActivity;
        this.a = switchCompat;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        AppListActivity appListActivity = this.b;
        QQ qq = appListActivity.a.b;
        qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-162877376657291L), z);
        qq.apply();
        SwitchCompat switchCompat = this.a;
        if (z) {
            switchCompat.setText(appListActivity.getString(R.string.split_tunnel_info_selected_except));
        } else {
            switchCompat.setText(appListActivity.getString(R.string.split_tunnel_info_selected));
        }
    }
}
