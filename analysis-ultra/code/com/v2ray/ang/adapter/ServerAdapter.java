package com.v2ray.ang.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs$CastExtraArgs;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.v2ray.ang.viewmodel.ServerList;
import defpackage.m61;
import defpackage.yg0;
import defpackage.zq0;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.c;
import kotlin.text.g;
import org.json.JSONArray;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u000f\u0010B7\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/v2ray/ang/adapter/ServerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/v2ray/ang/adapter/ServerAdapter$ServerViewHolder;", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "mActivity", "Ljava/util/ArrayList;", "Lcom/v2ray/ang/viewmodel/ServerList;", "Lkotlin/collections/ArrayList;", "initialList", "Lcom/v2ray/ang/adapter/ServerAdapter$ServerItemClickListener;", ServiceSpecificExtraArgs$CastExtraArgs.LISTENER, "<init>", "(Landroid/content/Context;Landroid/app/Activity;Ljava/util/ArrayList;Lcom/v2ray/ang/adapter/ServerAdapter$ServerItemClickListener;)V", "ServerViewHolder", "ServerItemClickListener", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerAdapter extends RecyclerView.Adapter<ServerViewHolder> {
    public final Context d;
    public final Activity e;
    public final ServerItemClickListener f;
    public boolean g;
    public final AsyncListDiffer h;
    public final LinkedHashMap i;
    public RewardedAd j;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/v2ray/ang/adapter/ServerAdapter$ServerItemClickListener;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "position", "Lmk1;", "onServerClick", "(I)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface ServerItemClickListener {
        void onServerClick(int position);
    }

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/v2ray/ang/adapter/ServerAdapter$ServerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "<init>", "(Lcom/v2ray/ang/adapter/ServerAdapter;Landroid/view/View;)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ServerViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int D = 0;
        public final ImageView A;
        public final ProgressBar B;
        public final /* synthetic */ ServerAdapter C;
        public final TextView u;
        public final ImageView v;
        public final TextView w;
        public final MaterialRadioButton x;
        public final ConstraintLayout y;
        public final ImageView z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ServerViewHolder(ServerAdapter serverAdapter, View view) {
            super(view);
            view.getClass();
            this.C = serverAdapter;
            View findViewById = view.findViewById(R.id.tvServerName);
            findViewById.getClass();
            this.u = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.serverFlag);
            findViewById2.getClass();
            this.v = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.tvServerProto);
            findViewById3.getClass();
            this.w = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.rbServer);
            findViewById4.getClass();
            this.x = (MaterialRadioButton) findViewById4;
            View findViewById5 = view.findViewById(R.id.cardServer);
            findViewById5.getClass();
            this.y = (ConstraintLayout) findViewById5;
            this.z = (ImageView) view.findViewById(R.id.imgSpeedBoost);
            this.A = (ImageView) view.findViewById(R.id.imgBoosted);
            this.B = (ProgressBar) view.findViewById(R.id.pbBoost);
        }

        public final void s(ServerList serverList, List list) {
            ImageView imageView;
            TextView textView = this.w;
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    obj.getClass();
                    c.i(arrayList, (List) obj);
                }
                if (arrayList.contains("flag")) {
                    t(serverList.getFlag());
                }
                if (arrayList.contains("protocol")) {
                    textView.setText(serverList.getServerInfo());
                    return;
                }
                return;
            }
            Lazy lazy = zq0.a;
            JSONArray jSONArray = new JSONArray(zq0.s());
            String obj2 = g.d0(serverList.getName()).toString();
            ServerAdapter serverAdapter = this.C;
            serverAdapter.getClass();
            obj2.getClass();
            int length = jSONArray.length();
            int i = 0;
            while (true) {
                ImageView imageView2 = this.A;
                imageView = this.z;
                if (i < length) {
                    if (yg0.a(jSONArray.getJSONObject(i).getString("name"), obj2)) {
                        imageView2.setVisibility(0);
                        imageView.setVisibility(8);
                        break;
                    }
                    i++;
                } else {
                    imageView2.setVisibility(8);
                    imageView.setVisibility(0);
                    break;
                }
            }
            if (g.o(serverList.getName(), "Auto", false)) {
                imageView.setVisibility(8);
            }
            imageView.setOnClickListener(new m61(serverAdapter, this, serverList));
            this.u.setText(g.c0(serverList.getName()).toString());
            textView.setText(serverList.getServerInfo());
            t(serverList.getFlag());
            m61 m61Var = new m61(serverList, serverAdapter, this);
            ConstraintLayout constraintLayout = this.y;
            constraintLayout.setOnClickListener(m61Var);
            Lazy lazy2 = zq0.a;
            boolean w = g.w(zq0.D(), serverList.getName(), false);
            MaterialRadioButton materialRadioButton = this.x;
            if (w) {
                materialRadioButton.setChecked(true);
                materialRadioButton.setEnabled(false);
                constraintLayout.setBackground(serverAdapter.d.getDrawable(R.drawable.network_item_selected));
            } else {
                constraintLayout.setBackground(null);
                materialRadioButton.setChecked(false);
                materialRadioButton.setEnabled(false);
            }
        }

        public final void t(String str) {
            Drawable drawable;
            ServerAdapter serverAdapter = this.C;
            LinkedHashMap linkedHashMap = serverAdapter.i;
            Context context = serverAdapter.d;
            Object obj = linkedHashMap.get(str);
            if (obj == null) {
                try {
                    Locale locale = Locale.getDefault();
                    locale.getClass();
                    String upperCase = str.toUpperCase(locale);
                    upperCase.getClass();
                    InputStream open = context.getAssets().open("flag/" + upperCase + ".png");
                    open.getClass();
                    drawable = Drawable.createFromStream(open, null);
                } catch (Exception unused) {
                    drawable = context.getDrawable(R.drawable.ic_mymenu);
                }
                obj = drawable;
                linkedHashMap.put(str, obj);
            }
            this.v.setImageDrawable((Drawable) obj);
        }
    }

    public ServerAdapter(Context context, Activity activity, ArrayList<ServerList> arrayList, ServerItemClickListener serverItemClickListener) {
        context.getClass();
        activity.getClass();
        arrayList.getClass();
        serverItemClickListener.getClass();
        this.d = context;
        this.e = activity;
        this.f = serverItemClickListener;
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(this, new DiffUtil$ItemCallback());
        this.h = asyncListDiffer;
        this.i = new LinkedHashMap();
        asyncListDiffer.b(arrayList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int c() {
        return this.h.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void k(RecyclerView.ViewHolder viewHolder, int i) {
        Object obj = this.h.f.get(i);
        obj.getClass();
        ((ServerViewHolder) viewHolder).s((ServerList) obj, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void l(RecyclerView.ViewHolder viewHolder, int i, List list) {
        ServerViewHolder serverViewHolder = (ServerViewHolder) viewHolder;
        list.getClass();
        if (list.isEmpty()) {
            k(serverViewHolder, i);
            return;
        }
        Object obj = this.h.f.get(i);
        obj.getClass();
        serverViewHolder.s((ServerList) obj, list);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder m(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.server_item, viewGroup, false);
        inflate.getClass();
        return new ServerViewHolder(this, inflate);
    }
}
