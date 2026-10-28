package prince.dastan.vpn.activities;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.widget.SwitchCompat;
import dastan.prince.bdfreevpn.R;
import defpackage.C0223If;
import defpackage.C3012f6;
import defpackage.C3092g6;
import defpackage.C3172h6;
import defpackage.C3252i6;
import defpackage.C3330j6;
import defpackage.QQ;
import defpackage.ViewOnClickListenerC2840d;
import defpackage.Y00;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.AppListActivity;

/* loaded from: classes2.dex */
public class AppListActivity extends Activity {
    public static final /* synthetic */ int d = 0;
    public C0223If a;
    public C3252i6 b;
    public boolean c = false;

    @Override // android.app.Activity
    public final void onCreate(Bundle bundle) {
        String[] strArr;
        super.onCreate(bundle);
        setContentView(R.layout.split_tunnel_drawer);
        this.a = new C0223If(getApplicationContext());
        final ListView listView = (ListView) findViewById(R.id.app_list_view);
        ImageView imageView = (ImageView) findViewById(R.id.backButton);
        SwitchCompat switchCompat = (SwitchCompat) findViewById(R.id.splitTunnelSwitch);
        SwitchCompat switchCompat2 = (SwitchCompat) findViewById(R.id.bypassModeSwitch);
        imageView.setOnClickListener(new ViewOnClickListenerC2840d(this, 4));
        C0223If c0223If = this.a;
        c0223If.getClass();
        switchCompat.setChecked(c0223If.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162688398096267L), false));
        switchCompat.setOnCheckedChangeListener(new Y00(this, 2));
        C0223If c0223If2 = this.a;
        c0223If2.getClass();
        switchCompat2.setChecked(c0223If2.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162817247115147L), false));
        C0223If c0223If3 = this.a;
        c0223If3.getClass();
        if (c0223If3.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-162817247115147L), false)) {
            switchCompat2.setText(getString(R.string.split_tunnel_info_selected_except));
        } else {
            switchCompat2.setText(getString(R.string.split_tunnel_info_selected));
        }
        switchCompat2.setOnCheckedChangeListener(new C3012f6(this, switchCompat2));
        Set a = this.a.a();
        C0223If c0223If4 = this.a;
        c0223If4.getClass();
        HashSet hashSet = new HashSet(Arrays.asList(c0223If4.a.getString(Deobfuscator$BDNETVPN$app.getString(-161460037449611L), Deobfuscator$BDNETVPN$app.getString(-161515872024459L)).split(";")));
        PackageManager packageManager = getPackageManager();
        this.b = new C3252i6(this);
        for (PackageInfo packageInfo : packageManager.getInstalledPackages(4096)) {
            if (!packageInfo.packageName.equals(getPackageName()) && !hashSet.contains(packageInfo.packageName) && (strArr = packageInfo.requestedPermissions) != null && Arrays.asList(strArr).contains("android.permission.INTERNET")) {
                boolean contains = a.contains(packageInfo.packageName);
                String charSequence = packageInfo.applicationInfo.loadLabel(packageManager).toString();
                C3330j6 c3330j6 = new C3330j6();
                c3330j6.a = packageInfo;
                c3330j6.b = contains;
                c3330j6.c = charSequence;
                this.b.add(c3330j6);
            }
        }
        EditText editText = new EditText(this);
        editText.setHint("Search");
        int i = (int) (getResources().getDisplayMetrics().density * 8.0f);
        editText.setPadding(i, i, i, i);
        listView.addHeaderView(editText, null, false);
        this.b.sort(new C3092g6(0));
        listView.setAdapter((ListAdapter) this.b);
        editText.addTextChangedListener(new C3172h6(this, 0));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: e6
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j) {
                int i3 = AppListActivity.d;
                AppListActivity appListActivity = AppListActivity.this;
                ListView listView2 = listView;
                if (i2 >= listView2.getHeaderViewsCount()) {
                    C3330j6 c3330j62 = (C3330j6) appListActivity.b.b.get(i2 - listView2.getHeaderViewsCount());
                    c3330j62.b = !c3330j62.b;
                    CheckBox checkBox = (CheckBox) view.findViewById(R.id.checked);
                    if (checkBox != null) {
                        checkBox.setChecked(c3330j62.b);
                    }
                    appListActivity.c = true;
                }
            }
        });
    }

    @Override // android.app.Activity
    public final void onDestroy() {
        if (this.c) {
            HashSet hashSet = new HashSet();
            Iterator it = this.b.a.iterator();
            while (it.hasNext()) {
                C3330j6 c3330j6 = (C3330j6) it.next();
                if (c3330j6.b) {
                    hashSet.add(c3330j6.a.packageName);
                }
            }
            QQ qq = this.a.b;
            qq.putStringSet(Deobfuscator$BDNETVPN$app.getString(-162611088684939L), hashSet);
            qq.apply();
        }
        super.onDestroy();
    }
}
