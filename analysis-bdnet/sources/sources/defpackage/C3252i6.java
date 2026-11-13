package defpackage;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import prince.dastan.vpn.activities.AppListActivity;

/* renamed from: i6, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3252i6 extends ArrayAdapter {
    public final ArrayList a;
    public final ArrayList b;
    public String c;

    public C3252i6(AppListActivity appListActivity) {
        super(appListActivity, R.layout.app_list_view);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = "";
    }

    @Override // android.widget.ArrayAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final void add(C3330j6 c3330j6) {
        this.a.add(c3330j6);
        String str = this.c;
        if ((str == null || str.length() == 0) ? true : c3330j6.c.toLowerCase().contains(str.toLowerCase())) {
            this.b.add(c3330j6);
        }
        notifyDataSetChanged();
    }

    public final void b(String str) {
        if (str == null) {
            str = "";
        }
        this.c = str;
        ArrayList arrayList = this.b;
        arrayList.clear();
        int length = this.c.length();
        ArrayList arrayList2 = this.a;
        if (length == 0) {
            arrayList.addAll(arrayList2);
        } else {
            String lowerCase = this.c.toLowerCase();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                C3330j6 c3330j6 = (C3330j6) it.next();
                String str2 = c3330j6.c;
                if (str2 != null && str2.toLowerCase().contains(lowerCase)) {
                    arrayList.add(c3330j6);
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter
    public final void clear() {
        this.a.clear();
        this.b.clear();
        notifyDataSetChanged();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final int getCount() {
        return this.b.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i) {
        return (C3330j6) this.b.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(R.layout.app_list_view, viewGroup, false);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        TextView textView = (TextView) inflate.findViewById(R.id.name);
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.checked);
        C3330j6 c3330j6 = (C3330j6) this.b.get(i);
        PackageManager packageManager = getContext().getPackageManager();
        ApplicationInfo applicationInfo = c3330j6.a.applicationInfo;
        imageView.setImageDrawable(applicationInfo.loadIcon(packageManager));
        textView.setText(applicationInfo.loadLabel(packageManager).toString());
        checkBox.setChecked(c3330j6.b);
        return inflate;
    }

    @Override // android.widget.ArrayAdapter
    public final void sort(Comparator comparator) {
        Collections.sort(this.a, comparator);
        b(this.c);
    }
}
