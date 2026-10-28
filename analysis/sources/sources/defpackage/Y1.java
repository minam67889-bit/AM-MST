package defpackage;

import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import app.vpn.amtunnellite.R;

/* loaded from: classes2.dex */
public final class Y1 extends ArrayAdapter {
    public SharedPreferences a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public final View getDropDownView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.server_item_drop, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.server_item_title);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.server_item_icon);
        this.a.getInt("ServerChecked", 0);
        try {
            textView.setText((String) super.getItem(i));
            imageView.setImageResource(R.drawable.ic_app_icon);
        } catch (Exception unused) {
        }
        return inflate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i) {
        return (String) super.getItem(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.server_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.server_item_title);
        this.a.getInt("ServerChecked", 0);
        try {
            textView.setText((String) super.getItem(i));
        } catch (Exception unused) {
        }
        return inflate;
    }
}
