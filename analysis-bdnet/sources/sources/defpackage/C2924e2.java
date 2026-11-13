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
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import dastan.prince.bdfreevpn.R;
import java.util.ArrayList;
import org.json.JSONObject;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: e2, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C2924e2 extends ArrayAdapter {
    public final ArrayList a;
    public final SharedPreferences b;
    public final ArrayList c;
    public final VPNClient d;
    public final boolean e;
    public final C0223If f;

    public C2924e2(Context context, ArrayList arrayList, boolean z) {
        super(context, R.layout.network_item, arrayList);
        this.a = arrayList;
        this.c = new ArrayList(arrayList);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        this.b = defaultSharedPreferences;
        defaultSharedPreferences.edit();
        this.d = (VPNClient) context;
        this.e = z;
        this.f = C0223If.d(getContext());
    }

    public static void a(C2924e2 c2924e2, String str) {
        U3 u3 = new U3(c2924e2.getContext(), R.style.MyDialogTheme);
        Q3 q3 = (Q3) u3.c;
        q3.e = "Delete Confirmation";
        q3.g = W50.D("Do you want to remove ", str, "?");
        u3.f("YES", new DialogInterfaceOnClickListenerC0770b2(c2924e2, str));
        u3.e("NO", null);
        u3.g();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public final Filter getFilter() {
        return new C2845d2(this);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final Object getItem(int i) {
        return (JSONObject) this.a.get(i);
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.network_item_drop, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.network_item_title);
        TextView textView2 = (TextView) inflate.findViewById(R.id.network_item_info);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.network_item_icon);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.network_delete_icon);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.network_export_icon);
        ImageView imageView4 = (ImageView) inflate.findViewById(R.id.create_tweak_icon);
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(R.id.network_selection_frame);
        this.b.getString("LastCheckedNetwork", "");
        JSONObject jSONObject = (JSONObject) this.a.get(i);
        boolean z = this.e;
        if (z) {
            imageView2.setVisibility(0);
            imageView3.setVisibility(0);
            imageView4.setVisibility(8);
            if (this.f.h() == i) {
                frameLayout.setBackgroundColor(-16711936);
            }
            imageView2.setOnClickListener(new ViewOnClickListenerC0849c2(this, jSONObject, 0));
            imageView3.setOnClickListener(new ViewOnClickListenerC0849c2(this, jSONObject, 1));
        } else {
            imageView2.setOnClickListener(null);
            imageView2.setVisibility(8);
            imageView3.setOnClickListener(null);
            imageView3.setVisibility(8);
            imageView4.setVisibility(0);
            imageView4.setOnClickListener(new ViewOnClickListenerC2840d(this, 2));
        }
        try {
            String string = jSONObject.getString("message");
            if (string.isEmpty()) {
                textView2.setText("BD NET VPN");
            } else {
                textView2.setText(string);
            }
            if (string.contains("Custom Tweak") && z) {
                imageView2.setVisibility(0);
                imageView3.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
                imageView3.setVisibility(8);
            }
            textView.setText(Html.fromHtml(jSONObject.getString("friendly_name")));
            imageView.setImageResource(R.drawable.ic_app_icon);
            return inflate;
        } catch (Exception e) {
            Toast.makeText(getContext(), "Network Error: " + e.getMessage(), 1).show();
            return inflate;
        }
    }
}
