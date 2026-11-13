package defpackage;

import android.widget.CompoundButton;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.AppListActivity;

/* loaded from: classes2.dex */
public final class Y00 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ Y00(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        switch (this.a) {
            case 0:
                String[] strArr = (String[]) this.b;
                if (!z) {
                    strArr[0] = Deobfuscator$BDNETVPN$app.getString(-18570770478987L);
                    break;
                } else {
                    strArr[0] = Deobfuscator$BDNETVPN$app.getString(-18549295642507L);
                    break;
                }
            case 1:
                String[] strArr2 = (String[]) this.b;
                if (!z) {
                    strArr2[0] = Deobfuscator$BDNETVPN$app.getString(-18618015119243L);
                    break;
                } else {
                    strArr2[0] = Deobfuscator$BDNETVPN$app.getString(-18596540282763L);
                    break;
                }
            default:
                QQ qq = ((AppListActivity) this.b).a.b;
                qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-162752822605707L), z);
                qq.apply();
                break;
        }
    }
}
