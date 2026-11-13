package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import app.vpn.amtunnellite.R;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class X1 extends ArrayAdapter {
    public final List a;
    public final SharedPreferences b;
    public final ArrayList c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public X1(Context context, ArrayList arrayList) {
        super(context, R.layout.network_item, arrayList);
        this.a = arrayList;
        this.c = new ArrayList(arrayList);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.b = defaultSharedPreferences;
        defaultSharedPreferences.edit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public final Filter getFilter() {
        return new W1(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i) {
        return (JSONObject) this.a.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.network_item, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.network_item_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.network_item_info);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.network_item_icon);
        this.b.getString("LastCheckedNetwork", "");
        JSONObject jSONObject = (JSONObject) this.a.get(i);
        try {
            String string = jSONObject.getString("message");
            if (string.isEmpty()) {
                string = "AM TUNNEL LITE";
            }
            textView2.setText(string);
            textView.setText(Html.fromHtml(jSONObject.getString("friendly_name")));
            imageView.setImageResource(R.drawable.ic_app_icon);
        } catch (Exception e) {
            Toast makeText = Toast.makeText(getContext(), "Network Error: " + e.getMessage(), 1);
            y.׳شڬزڮ();
            makeText.show();
        }
        return inflate;
    }
}
