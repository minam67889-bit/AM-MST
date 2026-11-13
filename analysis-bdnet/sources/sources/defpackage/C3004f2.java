package defpackage;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;

/* renamed from: f2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C3004f2 extends ArrayAdapter {
    public SharedPreferences a;

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        String str;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.server_item_drop, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.server_item_title);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.server_item_icon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.server_description);
        this.a.getInt("ServerChecked", 0);
        try {
            str = (String) super.getItem(i);
            textView.setText(str);
            imageView.setImageResource(R.drawable.ic_app_icon);
        } catch (Exception unused) {
        }
        if (str.toLowerCase().contains("auto select")) {
            textView2.setText("Random");
            textView2.setTextColor(-16776961);
            return inflate;
        }
        textView2.setText("FREE");
        textView2.setTextColor(-65536);
        return inflate;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i) {
        return (String) super.getItem(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        String str;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.server_item_drop, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.server_item_title);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.server_item_icon);
        TextView textView2 = (TextView) inflate.findViewById(R.id.server_description);
        this.a.getInt("ServerChecked", 0);
        try {
            str = (String) super.getItem(i);
            textView.setText(str);
            imageView.setImageResource(R.drawable.ic_app_icon);
        } catch (Exception unused) {
        }
        if (str.toLowerCase().contains("auto select")) {
            textView2.setText("Random");
            textView2.setTextColor(-16776961);
            return inflate;
        }
        textView2.setText("FREE");
        textView2.setTextColor(-65536);
        return inflate;
    }
}
