package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.github.angads25.filepicker.widget.MaterialCheckbox;
import dastan.prince.bdfreevpn.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import prince.dastan.vpn.activities.VPNClient;

/* renamed from: rq, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4020rq extends BaseAdapter {
    public ArrayList a;
    public VPNClient b;
    public C2853d6 c;
    public C0136Ew d;

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.a.size();
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        return (C4099sq) this.a.get(i);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        C3942qq c3942qq;
        VPNClient vPNClient = this.b;
        if (view == null) {
            view = LayoutInflater.from(vPNClient).inflate(R.layout.dialog_file_list_item, viewGroup, false);
            c3942qq = new C3942qq();
            c3942qq.b = (TextView) view.findViewById(R.id.fname);
            c3942qq.c = (TextView) view.findViewById(R.id.ftype);
            c3942qq.a = (ImageView) view.findViewById(R.id.image_type);
            c3942qq.d = (MaterialCheckbox) view.findViewById(R.id.file_mark);
            view.setTag(c3942qq);
        } else {
            c3942qq = (C3942qq) view.getTag();
        }
        C4099sq c4099sq = (C4099sq) this.a.get(i);
        if (AbstractC3342jE.a.containsKey(c4099sq.b)) {
            view.setAnimation(AnimationUtils.loadAnimation(vPNClient, R.anim.marked_item_animation));
        } else {
            view.setAnimation(AnimationUtils.loadAnimation(vPNClient, R.anim.unmarked_item_animation));
        }
        boolean z = c4099sq.c;
        C2853d6 c2853d6 = this.c;
        if (z) {
            c3942qq.a.setImageResource(R.mipmap.ic_type_folder);
            c3942qq.a.setColorFilter(vPNClient.getResources().getColor(R.color.colorPrimary, vPNClient.getTheme()));
            c2853d6.getClass();
            c3942qq.d.setVisibility(4);
        } else {
            c3942qq.a.setImageResource(R.mipmap.ic_type_file);
            c3942qq.a.setColorFilter(vPNClient.getResources().getColor(R.color.colorAccent, vPNClient.getTheme()));
            c2853d6.getClass();
            c3942qq.d.setVisibility(0);
        }
        c3942qq.a.setContentDescription(c4099sq.a);
        c3942qq.b.setText(c4099sq.a);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("hh:mm aa", Locale.getDefault());
        Date date = new Date(c4099sq.d);
        TextView textView = c3942qq.c;
        if (i == 0 && c4099sq.a.startsWith(vPNClient.getString(R.string.label_parent_dir))) {
            textView.setText(R.string.label_parent_directory);
        } else {
            textView.setText(vPNClient.getString(R.string.last_edit) + simpleDateFormat.format(date) + ", " + simpleDateFormat2.format(date));
        }
        MaterialCheckbox materialCheckbox = c3942qq.d;
        if (materialCheckbox.getVisibility() == 0) {
            if (i == 0 && c4099sq.a.startsWith(vPNClient.getString(R.string.label_parent_dir))) {
                materialCheckbox.setVisibility(4);
            }
            if (AbstractC3342jE.a.containsKey(c4099sq.b)) {
                materialCheckbox.setChecked(true);
            } else {
                materialCheckbox.setChecked(false);
            }
        }
        materialCheckbox.setOnCheckedChangedListener(new C0595Wo(this, c4099sq, 1, false));
        return view;
    }
}
