package defpackage;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TimePicker;
import dastan.prince.bdfreevpn.R;
import java.util.Calendar;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes2.dex */
public final class X00 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ VPNClient b;

    public /* synthetic */ X00(VPNClient vPNClient, int i) {
        this.a = i;
        this.b = vPNClient;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        VPNClient vPNClient = this.b;
        switch (this.a) {
            case 0:
                final VPNClient vPNClient2 = this.b;
                if (!z) {
                    vPNClient2.L.setText(Deobfuscator$BDNETVPN$app.getString(-18450511394699L));
                    vPNClient2.T = Deobfuscator$BDNETVPN$app.getString(-18536410740619L);
                    break;
                } else {
                    String str = VPNClient.f0;
                    vPNClient2.getClass();
                    Calendar calendar = Calendar.getInstance();
                    vPNClient2.O = calendar.get(1);
                    vPNClient2.P = calendar.get(2);
                    vPNClient2.Q = calendar.get(5);
                    vPNClient2.R = calendar.get(11);
                    vPNClient2.S = calendar.get(12);
                    DatePickerDialog datePickerDialog = new DatePickerDialog(vPNClient2, new DatePickerDialog.OnDateSetListener() { // from class: Q00
                        @Override // android.app.DatePickerDialog.OnDateSetListener
                        public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
                            final VPNClient vPNClient3 = VPNClient.this;
                            vPNClient3.O = i;
                            vPNClient3.P = i2;
                            vPNClient3.Q = i3;
                            TimePickerDialog timePickerDialog = new TimePickerDialog(vPNClient3, new TimePickerDialog.OnTimeSetListener() { // from class: R00
                                @Override // android.app.TimePickerDialog.OnTimeSetListener
                                public final void onTimeSet(TimePicker timePicker, int i4, int i5) {
                                    VPNClient vPNClient4 = VPNClient.this;
                                    vPNClient4.R = i4;
                                    vPNClient4.S = i5;
                                    String str2 = vPNClient4.O + Deobfuscator$BDNETVPN$app.getString(-69891334698891L) + (vPNClient4.P + 1) + Deobfuscator$BDNETVPN$app.getString(-69899924633483L) + vPNClient4.Q + Deobfuscator$BDNETVPN$app.getString(-69908514568075L) + vPNClient4.R + Deobfuscator$BDNETVPN$app.getString(-69917104502667L) + vPNClient4.S;
                                    vPNClient4.T = str2;
                                    vPNClient4.L.setText(Deobfuscator$BDNETVPN$app.getString(-69925694437259L) + str2);
                                }
                            }, vPNClient3.R, vPNClient3.S, false);
                            timePickerDialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC3481l10(vPNClient3, 1));
                            timePickerDialog.show();
                        }
                    }, vPNClient2.O, vPNClient2.P, vPNClient2.Q);
                    datePickerDialog.setOnCancelListener(new DialogInterfaceOnCancelListenerC3481l10(vPNClient2, 0));
                    datePickerDialog.show();
                    break;
                }
            case 1:
                if (!z) {
                    vPNClient.U = Deobfuscator$BDNETVPN$app.getString(-18540705707915L);
                    break;
                } else {
                    vPNClient.getClass();
                    try {
                        U3 u3 = new U3(vPNClient, R.style.MyDialogTheme);
                        Q3 q3 = (Q3) u3.c;
                        q3.e = Deobfuscator$BDNETVPN$app.getString(-70007298815883L);
                        q3.n = false;
                        View inflate = LayoutInflater.from(vPNClient.getApplicationContext()).inflate(R.layout.hwid_dialog, (ViewGroup) null);
                        q3.r = inflate;
                        EditText editText = (EditText) inflate.findViewById(R.id.hwid_edittext);
                        u3.f(Deobfuscator$BDNETVPN$app.getString(-70050248488843L), null);
                        u3.e(Deobfuscator$BDNETVPN$app.getString(-70071723325323L), new P00(vPNClient, 1));
                        V3 a = u3.a();
                        a.show();
                        a.c(-1).setOnClickListener(new O00(vPNClient, editText, a, 2));
                        break;
                    } catch (Exception e) {
                        SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-70097493129099L) + e.getMessage());
                        return;
                    }
                }
            case 2:
                if (!z) {
                    QQ qq = vPNClient.m.b;
                    qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-160643993663371L), false);
                    qq.apply();
                    vPNClient.K.setText(Deobfuscator$BDNETVPN$app.getString(-17625877673867L));
                    break;
                } else {
                    QQ qq2 = vPNClient.m.b;
                    qq2.putBoolean(Deobfuscator$BDNETVPN$app.getString(-160643993663371L), true);
                    qq2.apply();
                    vPNClient.K.setText(Deobfuscator$BDNETVPN$app.getString(-17570043099019L));
                    String[] strArr = {Deobfuscator$BDNETVPN$app.getString(-46058561173387L), Deobfuscator$BDNETVPN$app.getString(-46122985682827L), Deobfuscator$BDNETVPN$app.getString(-46170230323083L), Deobfuscator$BDNETVPN$app.getString(-46213179996043L), Deobfuscator$BDNETVPN$app.getString(-46264719603595L), Deobfuscator$BDNETVPN$app.getString(-46316259211147L), Deobfuscator$BDNETVPN$app.getString(-46350618949515L)};
                    String[] strArr2 = {Deobfuscator$BDNETVPN$app.getString(-46406453524363L), Deobfuscator$BDNETVPN$app.getString(-46475173001099L), Deobfuscator$BDNETVPN$app.getString(-46543892477835L), Deobfuscator$BDNETVPN$app.getString(-46646971692939L), Deobfuscator$BDNETVPN$app.getString(-46758640842635L), Deobfuscator$BDNETVPN$app.getString(-46844540188555L), Deobfuscator$BDNETVPN$app.getString(-46973389207435L)};
                    View inflate2 = LayoutInflater.from(vPNClient.getApplicationContext()).inflate(R.layout.dialog_dns_selection, (ViewGroup) null);
                    Spinner spinner = (Spinner) inflate2.findViewById(R.id.dns_spinner);
                    ArrayAdapter arrayAdapter = new ArrayAdapter(vPNClient, android.R.layout.simple_spinner_item, strArr);
                    arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinner.setAdapter((SpinnerAdapter) arrayAdapter);
                    try {
                        C0223If c0223If = vPNClient.m;
                        c0223If.getClass();
                        spinner.setSelection(c0223If.a.getInt(Deobfuscator$BDNETVPN$app.getString(-162538074240907L), 0));
                    } catch (IndexOutOfBoundsException unused) {
                        spinner.setSelection(0);
                    }
                    U3 u32 = new U3(vPNClient, R.style.MyDialogTheme);
                    String string = Deobfuscator$BDNETVPN$app.getString(-47059288553355L);
                    Q3 q32 = (Q3) u32.c;
                    q32.e = string;
                    q32.n = true;
                    q32.r = inflate2;
                    u32.f(Deobfuscator$BDNETVPN$app.getString(-47136597964683L), new DialogInterfaceOnClickListenerC3561m10(vPNClient, spinner, strArr2));
                    u32.g();
                    break;
                }
            default:
                if (!z) {
                    vPNClient.V = Deobfuscator$BDNETVPN$app.getString(-18545000675211L);
                    break;
                } else {
                    vPNClient.getClass();
                    try {
                        U3 u33 = new U3(vPNClient, R.style.MyDialogTheme);
                        Q3 q33 = (Q3) u33.c;
                        q33.e = Deobfuscator$BDNETVPN$app.getString(-70153327703947L);
                        q33.n = false;
                        View inflate3 = LayoutInflater.from(vPNClient.getApplicationContext()).inflate(R.layout.password_dialog, (ViewGroup) null);
                        q33.r = inflate3;
                        EditText editText2 = (EditText) inflate3.findViewById(R.id.pw_edittext);
                        u33.f(Deobfuscator$BDNETVPN$app.getString(-70213457246091L), null);
                        u33.e(Deobfuscator$BDNETVPN$app.getString(-70234932082571L), new P00(vPNClient, 0));
                        V3 a2 = u33.a();
                        a2.show();
                        a2.c(-1).setOnClickListener(new O00(vPNClient, editText2, a2, 1));
                        break;
                    } catch (Exception e2) {
                        SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-70260701886347L) + e2.getMessage());
                        return;
                    }
                }
        }
    }
}
