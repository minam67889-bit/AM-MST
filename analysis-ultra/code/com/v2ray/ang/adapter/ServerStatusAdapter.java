package com.v2ray.ang.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.recyclerview.widget.RecyclerView;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.v2ray.ang.viewmodel.ServerList;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcherImpl;
import kotlinx.coroutines.c;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\fB%\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/v2ray/ang/adapter/ServerStatusAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/v2ray/ang/adapter/ServerStatusAdapter$ViewHolder;", "Landroid/content/Context;", "context", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "Lcom/v2ray/ang/viewmodel/ServerList;", "items", "Lkotlinx/coroutines/CoroutineScope;", "scope", "<init>", "(Landroid/content/Context;Ljava/util/List;Lkotlinx/coroutines/CoroutineScope;)V", "ViewHolder", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ServerStatusAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context d;
    public List e;
    public final CoroutineScope f;
    public final LinkedHashMap g;
    public final ExecutorCoroutineDispatcherImpl h;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/v2ray/ang/adapter/ServerStatusAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "view", "<init>", "(Lcom/v2ray/ang/adapter/ServerStatusAdapter;Landroid/view/View;)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public final View u;
        public final TextView v;
        public final ImageView w;
        public final TextView x;
        public final TextView y;
        public final TextView z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(ServerStatusAdapter serverStatusAdapter, View view) {
            super(view);
            view.getClass();
            this.u = view;
            View findViewById = view.findViewById(R.id.itemName);
            findViewById.getClass();
            this.v = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.itemflag);
            findViewById2.getClass();
            this.w = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.itemProtocol);
            findViewById3.getClass();
            this.x = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.isol);
            findViewById4.getClass();
            this.y = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.ping);
            findViewById5.getClass();
            this.z = (TextView) findViewById5;
        }
    }

    public ServerStatusAdapter(Context context, List<ServerList> list, CoroutineScope coroutineScope) {
        context.getClass();
        list.getClass();
        coroutineScope.getClass();
        this.d = context;
        this.e = list;
        this.f = coroutineScope;
        this.g = new LinkedHashMap();
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(5);
        newFixedThreadPool.getClass();
        this.h = new ExecutorCoroutineDispatcherImpl(newFixedThreadPool);
    }

    public static void v(ViewHolder viewHolder, Pair pair) {
        boolean booleanValue = ((Boolean) pair.component1()).booleanValue();
        Long l = (Long) pair.component2();
        if (booleanValue) {
            TextView textView = viewHolder.y;
            TextView textView2 = viewHolder.z;
            textView.setText("Online");
            textView2.setText(l + "ms");
            viewHolder.y.setTextColor(-16711936);
            textView2.setTextColor(-16776961);
            return;
        }
        TextView textView3 = viewHolder.y;
        TextView textView4 = viewHolder.z;
        textView3.setText("Offline");
        textView4.setText("0ms");
        viewHolder.y.setTextColor(SupportMenu.CATEGORY_MASK);
        textView4.setTextColor(-7829368);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int c() {
        return this.e.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void k(RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        TextView textView = viewHolder2.z;
        TextView textView2 = viewHolder2.y;
        ServerList serverList = (ServerList) this.e.get(i);
        viewHolder2.v.setText(serverList.getName());
        AssetManager assets = this.d.getAssets();
        StringBuffer stringBuffer = new StringBuffer("flag/");
        String flag = serverList.getFlag();
        Locale locale = Locale.getDefault();
        locale.getClass();
        String upperCase = flag.toUpperCase(locale);
        upperCase.getClass();
        stringBuffer.append(upperCase);
        stringBuffer.append(".png");
        InputStream open = assets.open(stringBuffer.toString());
        open.getClass();
        viewHolder2.w.setImageDrawable(Drawable.createFromStream(open, null));
        viewHolder2.x.setText(serverList.getServerProtocol());
        Pair pair = (Pair) this.g.get(serverList.getServerIPHost());
        if (pair != null) {
            v(viewHolder2, pair);
            return;
        }
        textView2.setText("Checking...");
        textView.setText("...");
        textView2.setTextColor(-7829368);
        textView.setTextColor(-7829368);
        c.d(this.f, this.h, null, new ServerStatusAdapter$onBindViewHolder$1(this, serverList, viewHolder2, null), 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder m(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_server_status, viewGroup, false);
        inflate.getClass();
        return new ViewHolder(this, inflate);
    }

    public final void u(List list) {
        list.getClass();
        this.e = list;
        f();
    }
}
