package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import dastan.prince.bdfreevpn.R;
import java.net.URL;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: Ru, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class DialogInterfaceOnCancelListenerC0471Ru implements DialogInterface.OnCancelListener, View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener {
    public View a;
    public RadioGroup b;
    public V3 c;
    public Context d;
    public C0136Ew e;
    public SharedPreferences f;
    public SharedPreferences.Editor g;
    public EditText h;
    public Spinner i;
    public Spinner j;
    public RadioGroup k;
    public CheckBox l;
    public CheckBox m;
    public CheckBox n;
    public CheckBox o;
    public CheckBox p;
    public CheckBox q;
    public Button r;

    public final String a() {
        int selectedItemPosition = this.j.getSelectedItemPosition();
        RadioGroup radioGroup = this.b;
        int indexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        if (selectedItemPosition == 0) {
            return "[crlf]";
        }
        if (selectedItemPosition == 1) {
            return "[crlf][crlf]";
        }
        if (selectedItemPosition != 2) {
            return null;
        }
        return indexOfChild == 2 ? "[crlf][crlf]" : "[crlf]";
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00c9, code lost:
    
        if (r2 != 2) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b() {
        String D = W50.D("http://", this.h.getText().toString(), "/");
        try {
            D = new URL(D).getHost();
        } catch (Exception unused) {
        }
        String D2 = W50.D("Host: ", D, "[crlf]");
        String D3 = this.l.isChecked() ? W50.D("X-Online-Host: ", D, "[crlf]") : "";
        String D4 = this.m.isChecked() ? W50.D("X-Forward-Host: ", D, "[crlf]") : "";
        String D5 = this.n.isChecked() ? W50.D("X-Forwarded-For: ", D, "[crlf]") : "";
        String str = this.p.isChecked() ? "Proxy-Authorization: [auth][crlf]" : "";
        String str2 = this.o.isChecked() ? "Connection: Keep-Alive[crlf]" : "";
        StringBuilder sb = new StringBuilder();
        sb.append((String) this.i.getSelectedItem());
        sb.append(" ");
        sb.append("http://" + this.h.getText().toString() + "/");
        sb.append(" ");
        int selectedItemPosition = this.j.getSelectedItemPosition();
        RadioGroup radioGroup = this.b;
        int indexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        String str3 = "HTTP/1.1";
        if (indexOfChild != 0 && indexOfChild != 1) {
            if (indexOfChild == 2) {
                if (selectedItemPosition != 0) {
                    if (selectedItemPosition != 1) {
                    }
                }
                str3 = "[protocol]";
            }
            str3 = null;
        }
        String q = W50.q(str3, "[crlf]", sb);
        String str4 = this.q.isChecked() ? "CONNECT [host_port] [protocol][crlf][crlf]" : "[crlf]";
        RadioGroup radioGroup2 = this.k;
        int indexOfChild2 = radioGroup2.indexOfChild(radioGroup2.findViewById(radioGroup2.getCheckedRadioButtonId()));
        String str5 = this.b.getCheckedRadioButtonId() == R.id.split_instant ? "[instant_split]" : this.b.getCheckedRadioButtonId() == R.id.split_delay ? "[delay_split]" : this.b.getCheckedRadioButtonId() == R.id.split_none ? "" : null;
        int selectedItemPosition2 = this.j.getSelectedItemPosition();
        if (selectedItemPosition2 == 0) {
            StringBuilder sb2 = new StringBuilder("CONNECT ");
            sb2.append(c(indexOfChild2, D, a()));
            sb2.append(D2);
            ZT.s(sb2, D3, D4, D5, str);
            return W50.q(str2, str4, sb2);
        }
        if (selectedItemPosition2 != 1) {
            if (selectedItemPosition2 != 2) {
                return "";
            }
            StringBuilder sb3 = new StringBuilder("CONNECT ");
            sb3.append(c(indexOfChild2, D, a()));
            sb3.append(str5);
            ZT.s(sb3, q, D2, D3, D4);
            return W50.v(sb3, D5, str, str2, str4);
        }
        StringBuilder sb4 = new StringBuilder();
        sb4.append(q);
        sb4.append(D2);
        sb4.append(D3);
        sb4.append(D4);
        sb4.append(D5);
        ZT.s(sb4, str, str2, "[crlf]", str5);
        sb4.append("CONNECT ");
        return W50.q(c(indexOfChild2, D, "[crlf]"), str4, sb4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003a, code lost:
    
        r6 = "HTTP/1.1";
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
    
        if (r2 == 2) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0038, code lost:
    
        if (r2 == 2) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String c(int i, String str, String str2) {
        RadioGroup radioGroup = this.k;
        int indexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
        int selectedItemPosition = this.j.getSelectedItemPosition();
        RadioGroup radioGroup2 = this.b;
        int indexOfChild2 = radioGroup2.indexOfChild(radioGroup2.findViewById(radioGroup2.getCheckedRadioButtonId()));
        String str3 = "[protocol]";
        if (selectedItemPosition != 0 && selectedItemPosition != 1) {
            if (selectedItemPosition == 2) {
                if (indexOfChild != 0) {
                    if (indexOfChild == 1 || indexOfChild == 2) {
                    }
                }
            }
            str3 = null;
        }
        if (i == 0) {
            return W50.D("[host_port] ", str3, str2);
        }
        if (i != 1) {
            if (i != 2) {
                return null;
            }
            return W50.p("[host_port]@", str, " ", str3, str2);
        }
        return str + "@[host_port] " + str3 + str2;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        this.e.o();
        this.c.dismiss();
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id = radioGroup.getId();
        if (id == R.id.query_mode) {
            this.g.putInt("QUERY_MODE", radioGroup.indexOfChild((RadioButton) radioGroup.findViewById(i))).apply();
            return;
        }
        if (id == R.id.split_group) {
            int indexOfChild = radioGroup.indexOfChild(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
            if (indexOfChild == 0 || indexOfChild == 1) {
                this.j.setSelection(2);
                this.i.setSelection(1);
            } else {
                if (indexOfChild != 2) {
                    return;
                }
                this.j.setSelection(0);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        String obj = this.h.getText().toString();
        if (view.getId() != R.id.generate_payload) {
            if (view.getId() == R.id.close_generator_dialog) {
                this.e.o();
                this.c.dismiss();
                return;
            }
            return;
        }
        if (obj.isEmpty()) {
            Toast.makeText(this.d, "URL/Host is empty!", 1).show();
            return;
        }
        this.g.putString("URL_HOST", obj);
        this.g.putBoolean("ONLINE_HOST", this.l.isChecked());
        this.g.putBoolean("FORWARD_HOST", this.m.isChecked());
        this.g.putBoolean("REVERSE_PROXY", this.n.isChecked());
        this.g.putBoolean("KEEP_ALIVE", this.o.isChecked());
        this.g.putBoolean("PROXY_AUTH", this.p.isChecked());
        this.g.putBoolean("DUAL_CONNECT", this.q.isChecked());
        RadioGroup radioGroup = this.b;
        this.g.putInt("Split", this.b.indexOfChild((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())));
        this.g.putString("FIXED_PAYLOAD", b());
        this.g.apply();
        C0136Ew c0136Ew = this.e;
        String b = b();
        EditText editText = ((VPNClient) ((InterfaceC0497Su) c0136Ew.b)).v;
        if (editText != null) {
            editText.setText(b);
        }
        this.c.dismiss();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        int id = adapterView.getId();
        if (id == R.id.request_method) {
            this.g.putInt("SELECTED_REQUEST_METHOD", i).apply();
            this.g.putString("METHOD", (String) adapterView.getSelectedItem()).apply();
        } else if (id == R.id.inject_method) {
            if (i == 0) {
                ((RadioButton) this.b.getChildAt(2)).setChecked(true);
                this.i.setSelection(0);
            } else if (i == 1 || i == 2) {
                this.i.setSelection(1);
            }
            this.g.putInt("SELECTED_INJECT_METHOD", i).apply();
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
