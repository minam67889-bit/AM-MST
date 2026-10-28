package defpackage;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.widget.Toolbar;
import com.github.angads25.filepicker.widget.MaterialCheckbox;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import dastan.prince.bdfreevpn.R;
import java.util.HashMap;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.AboutActivity;
import prince.dastan.vpn.activities.AppListActivity;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: d, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC2840d implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;

    public /* synthetic */ ViewOnClickListenerC2840d(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Message message;
        Message message2;
        Message message3;
        Message message4 = null;
        message4 = null;
        Object obj = this.b;
        switch (this.a) {
            case 0:
                ((AboutActivity) obj).finish();
                break;
            case 1:
                ((AbstractC3797p1) obj).a();
                break;
            case 2:
                final VPNClient vPNClient = ((C2924e2) obj).d;
                vPNClient.getClass();
                U3 u3 = new U3(vPNClient, R.style.MyDialogTheme);
                String string = Deobfuscator$BDNETVPN$app.getString(-50800205068171L);
                Q3 q3 = (Q3) u3.c;
                q3.e = string;
                View inflate = LayoutInflater.from(vPNClient.getApplicationContext()).inflate(R.layout.tweak_dialog, (ViewGroup) null);
                q3.r = inflate;
                final EditText editText = (EditText) inflate.findViewById(R.id.custom_tweak_edittext);
                Button button = (Button) inflate.findViewById(R.id.importBtn);
                u3.e(Deobfuscator$BDNETVPN$app.getString(-50843154741131L), new M00(0));
                u3.f(Deobfuscator$BDNETVPN$app.getString(-50873219512203L), null);
                q3.l = Deobfuscator$BDNETVPN$app.getString(-50894694348683L);
                q3.m = null;
                final V3 a = u3.a();
                button.setOnClickListener(new ViewOnClickListenerC4074sX(vPNClient, a));
                a.setOnShowListener(new DialogInterface.OnShowListener() { // from class: N00
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        String str = VPNClient.f0;
                        VPNClient vPNClient2 = VPNClient.this;
                        vPNClient2.getClass();
                        V3 v3 = a;
                        Button c = v3.c(-1);
                        v3.c(-3).setOnClickListener(new LT(1, vPNClient2, v3));
                        c.setOnClickListener(new O00(vPNClient2, editText, v3, 0));
                    }
                });
                a.show();
                break;
            case 3:
                T3 t3 = (T3) obj;
                if (view == t3.i && (message3 = t3.k) != null) {
                    message4 = Message.obtain(message3);
                } else if (view == t3.l && (message2 = t3.n) != null) {
                    message4 = Message.obtain(message2);
                } else if (view == t3.o && (message = t3.q) != null) {
                    message4 = Message.obtain(message);
                }
                if (message4 != null) {
                    message4.sendToTarget();
                }
                t3.F.obtainMessage(1, t3.b).sendToTarget();
                break;
            case 4:
                ((AppListActivity) obj).finish();
                break;
            case 5:
                ((C2996ex) obj).b.completeUpdate();
                break;
            case 6:
                C0910cm c0910cm = ((ViewOnTouchListenerC4212uD) obj).h;
                break;
            case 7:
                C4608zE c4608zE = (C4608zE) obj;
                int i = c4608zE.e;
                if (i != 2) {
                    if (i == 1) {
                        c4608zE.g(2);
                        c4608zE.g.announceForAccessibility(c4608zE.getString(R.string.mtrl_picker_toggled_to_year_selection));
                        break;
                    }
                } else {
                    c4608zE.g(1);
                    c4608zE.h.announceForAccessibility(c4608zE.getString(R.string.mtrl_picker_toggled_to_day_selection));
                    break;
                }
                break;
            case 8:
                MaterialCheckbox materialCheckbox = (MaterialCheckbox) obj;
                materialCheckbox.setChecked(!materialCheckbox.e);
                InterfaceC0795bJ interfaceC0795bJ = materialCheckbox.f;
                boolean z = materialCheckbox.e;
                C0595Wo c0595Wo = (C0595Wo) interfaceC0795bJ;
                C4099sq c4099sq = (C4099sq) c0595Wo.b;
                C4020rq c4020rq = (C4020rq) c0595Wo.c;
                if (z) {
                    c4020rq.c.getClass();
                    HashMap hashMap = AbstractC3342jE.a;
                    HashMap hashMap2 = new HashMap();
                    AbstractC3342jE.a = hashMap2;
                    hashMap2.put(c4099sq.b, c4099sq);
                } else {
                    AbstractC3342jE.a.remove(c4099sq.b);
                }
                DialogC4336vq dialogC4336vq = (DialogC4336vq) c4020rq.d.b;
                String str = dialogC4336vq.m;
                VPNClient vPNClient2 = dialogC4336vq.a;
                if (str == null) {
                    str = vPNClient2.getResources().getString(R.string.choose_button_label);
                }
                dialogC4336vq.m = str;
                int size = AbstractC3342jE.a.size();
                if (size == 0) {
                    dialogC4336vq.k.setEnabled(false);
                    int color = vPNClient2.getResources().getColor(R.color.colorAccent, vPNClient2.getTheme());
                    dialogC4336vq.k.setTextColor(Color.argb(UserVerificationMethods.USER_VERIFY_PATTERN, Color.red(color), Color.green(color), Color.blue(color)));
                    dialogC4336vq.k.setText(dialogC4336vq.m);
                } else {
                    dialogC4336vq.k.setEnabled(true);
                    dialogC4336vq.k.setTextColor(vPNClient2.getResources().getColor(R.color.colorAccent, vPNClient2.getTheme()));
                    dialogC4336vq.k.setText(dialogC4336vq.m + " (" + size + ") ");
                }
                dialogC4336vq.f.getClass();
                dialogC4336vq.j.notifyDataSetChanged();
                break;
            default:
                C3759oX c3759oX = ((Toolbar) obj).L;
                C3503lF c3503lF = c3759oX != null ? c3759oX.b : null;
                if (c3503lF != null) {
                    c3503lF.collapseActionView();
                    break;
                }
                break;
        }
    }

    public ViewOnClickListenerC2840d(ViewOnTouchListenerC4212uD viewOnTouchListenerC4212uD, int i, String str) {
        this.a = 6;
        this.b = viewOnTouchListenerC4212uD;
    }
}
