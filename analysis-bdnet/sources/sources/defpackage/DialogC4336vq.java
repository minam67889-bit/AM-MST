package defpackage;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.github.angads25.filepicker.widget.MaterialCheckbox;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import dastan.prince.bdfreevpn.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: vq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogC4336vq extends Dialog implements AdapterView.OnItemClickListener {
    public VPNClient a;
    public ListView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public C2853d6 f;
    public W00 g;
    public ArrayList h;
    public C3228hp i;
    public C4020rq j;
    public Button k;
    public String l;
    public String m;
    public String n;

    public final void a() {
        TextView textView = this.e;
        if (textView == null || this.c == null) {
            return;
        }
        if (this.l == null) {
            if (textView.getVisibility() == 0) {
                this.e.setVisibility(4);
            }
            if (this.c.getVisibility() == 4) {
                this.c.setVisibility(0);
                return;
            }
            return;
        }
        if (textView.getVisibility() == 4) {
            this.e.setVisibility(0);
        }
        this.e.setText(this.l);
        if (this.c.getVisibility() == 0) {
            this.c.setVisibility(4);
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        HashMap hashMap = AbstractC3342jE.a;
        AbstractC3342jE.a = new HashMap();
        this.h.clear();
        super.dismiss();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        String charSequence = this.c.getText().toString();
        if (this.h.size() <= 0) {
            super.onBackPressed();
            return;
        }
        File file = new File(((C4099sq) this.h.get(0)).b);
        C2853d6 c2853d6 = this.f;
        if (charSequence.equals(((File) c2853d6.b).getName())) {
            super.onBackPressed();
        } else {
            this.c.setText(file.getName());
            this.d.setText(file.getAbsolutePath());
            this.h.clear();
            if (!file.getName().equals(((File) c2853d6.b).getName())) {
                C4099sq c4099sq = new C4099sq();
                c4099sq.a = this.a.getString(R.string.label_parent_dir);
                c4099sq.c = true;
                c4099sq.b = file.getParentFile().getAbsolutePath();
                c4099sq.d = file.lastModified();
                this.h.add(c4099sq);
            }
            this.h = B00.o(this.h, file, this.i);
            this.j.notifyDataSetChanged();
        }
        a();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.dialog_main);
        this.b = (ListView) findViewById(R.id.fileList);
        this.k = (Button) findViewById(R.id.select);
        int size = AbstractC3342jE.a.size();
        VPNClient vPNClient = this.a;
        if (size == 0) {
            this.k.setEnabled(false);
            int color = vPNClient.getResources().getColor(R.color.colorAccent, vPNClient.getTheme());
            this.k.setTextColor(Color.argb(UserVerificationMethods.USER_VERIFY_PATTERN, Color.red(color), Color.green(color), Color.blue(color)));
        }
        this.c = (TextView) findViewById(R.id.dname);
        this.e = (TextView) findViewById(R.id.title);
        this.d = (TextView) findViewById(R.id.dir_path);
        Button button = (Button) findViewById(R.id.cancel);
        String str = this.n;
        if (str != null) {
            button.setText(str);
        }
        this.k.setOnClickListener(new ViewOnClickListenerC4257uq(this, 0));
        button.setOnClickListener(new ViewOnClickListenerC4257uq(this, 1));
        ArrayList arrayList = this.h;
        C4020rq c4020rq = new C4020rq();
        c4020rq.a = arrayList;
        c4020rq.b = vPNClient;
        c4020rq.c = this.f;
        this.j = c4020rq;
        c4020rq.d = new C0136Ew(this, 18);
        this.b.setAdapter((ListAdapter) c4020rq);
        a();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        if (this.h.size() > i) {
            C4099sq c4099sq = (C4099sq) this.h.get(i);
            if (!c4099sq.c) {
                ((MaterialCheckbox) view.findViewById(R.id.file_mark)).performClick();
                return;
            }
            boolean canRead = new File(c4099sq.b).canRead();
            VPNClient vPNClient = this.a;
            if (!canRead) {
                Toast.makeText(vPNClient, R.string.error_dir_access, 0).show();
                return;
            }
            File file = new File(c4099sq.b);
            this.c.setText(file.getName());
            a();
            this.d.setText(file.getAbsolutePath());
            this.h.clear();
            if (!file.getName().equals(((File) this.f.b).getName())) {
                C4099sq c4099sq2 = new C4099sq();
                c4099sq2.a = vPNClient.getString(R.string.label_parent_dir);
                c4099sq2.c = true;
                c4099sq2.b = file.getParentFile().getAbsolutePath();
                c4099sq2.d = file.lastModified();
                this.h.add(c4099sq2);
            }
            this.h = B00.o(this.h, file, this.i);
            this.j.notifyDataSetChanged();
        }
    }

    @Override // android.app.Dialog
    public final void onStart() {
        File file;
        super.onStart();
        String str = this.m;
        VPNClient vPNClient = this.a;
        if (str == null) {
            str = vPNClient.getResources().getString(R.string.choose_button_label);
        }
        this.m = str;
        this.k.setText(str);
        if (vPNClient.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
            this.h.clear();
            C2853d6 c2853d6 = this.f;
            if (((File) c2853d6.d).isDirectory()) {
                String absolutePath = ((File) c2853d6.d).getAbsolutePath();
                String absolutePath2 = ((File) c2853d6.b).getAbsolutePath();
                if (!absolutePath.equals(absolutePath2) && absolutePath.contains(absolutePath2)) {
                    file = new File(((File) c2853d6.d).getAbsolutePath());
                    C4099sq c4099sq = new C4099sq();
                    c4099sq.a = vPNClient.getString(R.string.label_parent_dir);
                    c4099sq.c = true;
                    c4099sq.b = file.getParentFile().getAbsolutePath();
                    c4099sq.d = file.lastModified();
                    this.h.add(c4099sq);
                    this.c.setText(file.getName());
                    this.d.setText(file.getAbsolutePath());
                    a();
                    this.h = B00.o(this.h, file, this.i);
                    this.j.notifyDataSetChanged();
                    this.b.setOnItemClickListener(this);
                }
            }
            file = (((File) c2853d6.b).exists() && ((File) c2853d6.b).isDirectory()) ? new File(((File) c2853d6.b).getAbsolutePath()) : new File(((File) c2853d6.c).getAbsolutePath());
            this.c.setText(file.getName());
            this.d.setText(file.getAbsolutePath());
            a();
            this.h = B00.o(this.h, file, this.i);
            this.j.notifyDataSetChanged();
            this.b.setOnItemClickListener(this);
        }
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        if (charSequence != null) {
            this.l = charSequence.toString();
        } else {
            this.l = null;
        }
        a();
    }

    @Override // android.app.Dialog
    public final void show() {
        VPNClient vPNClient = this.a;
        if (vPNClient.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") != 0) {
            vPNClient.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 112);
            return;
        }
        super.show();
        String str = this.m;
        if (str == null) {
            str = vPNClient.getResources().getString(R.string.choose_button_label);
        }
        this.m = str;
        this.k.setText(str);
        int size = AbstractC3342jE.a.size();
        if (size == 0) {
            this.k.setText(this.m);
            return;
        }
        this.k.setText(this.m + " (" + size + ") ");
    }
}
