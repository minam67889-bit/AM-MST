package com.v2ray.ang.adapter;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil$ItemCallback;
import androidx.recyclerview.widget.RecyclerView;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.gson.Gson;
import com.v2ray.ang.adapter.NetworkAdapter;
import com.v2ray.ang.viewmodel.NetworkList;
import defpackage.l8;
import defpackage.xm;
import defpackage.yg0;
import defpackage.yq0;
import defpackage.zq0;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.c;
import libv2ray.Libv2ray;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\r\u000eB/\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/v2ray/ang/adapter/NetworkAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/v2ray/ang/adapter/NetworkAdapter$ViewHolder;", "Landroid/content/Context;", "context", "Ljava/util/ArrayList;", "Lcom/v2ray/ang/viewmodel/NetworkList;", "Lkotlin/collections/ArrayList;", "initialItems", "Lcom/v2ray/ang/adapter/NetworkAdapter$NetworkItemClickListener;", "networkClick", "<init>", "(Landroid/content/Context;Ljava/util/ArrayList;Lcom/v2ray/ang/adapter/NetworkAdapter$NetworkItemClickListener;)V", "NetworkItemClickListener", "ViewHolder", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NetworkAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context d;
    public final NetworkItemClickListener e;
    public final AsyncListDiffer f;
    public final Lazy g;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\tÀ\u0006\u0003"}, d2 = {"Lcom/v2ray/ang/adapter/NetworkAdapter$NetworkItemClickListener;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "position", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "tType", "Lmk1;", "onNetworkClick", "(ILjava/lang/String;)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface NetworkItemClickListener {
        void onNetworkClick(int position, String tType);
    }

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/v2ray/ang/adapter/NetworkAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "v", "<init>", "(Lcom/v2ray/ang/adapter/NetworkAdapter;Landroid/view/View;)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        public static final /* synthetic */ int A = 0;
        public final TextView u;
        public final TextView v;
        public final ConstraintLayout w;
        public final ImageView x;
        public final ImageView y;
        public final Lazy z;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(NetworkAdapter networkAdapter, View view) {
            super(view);
            view.getClass();
            View findViewById = view.findViewById(R.id.tvNetworkName);
            findViewById.getClass();
            this.u = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.tvInfo);
            findViewById2.getClass();
            this.v = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.cardNetwork);
            findViewById3.getClass();
            this.w = (ConstraintLayout) findViewById3;
            View findViewById4 = view.findViewById(R.id.imgShareNetwork);
            findViewById4.getClass();
            this.x = (ImageView) findViewById4;
            View findViewById5 = view.findViewById(R.id.netIcon);
            findViewById5.getClass();
            this.y = (ImageView) findViewById5;
            this.z = c.b(new l8(networkAdapter, 9));
        }
    }

    public NetworkAdapter(Context context, ArrayList<NetworkList> arrayList, NetworkItemClickListener networkItemClickListener) {
        context.getClass();
        arrayList.getClass();
        networkItemClickListener.getClass();
        this.d = context;
        this.e = networkItemClickListener;
        AsyncListDiffer asyncListDiffer = new AsyncListDiffer(this, new DiffUtil$ItemCallback());
        this.f = asyncListDiffer;
        this.g = c.b(new yq0(8));
        asyncListDiffer.b(kotlin.collections.c.R(arrayList));
        t(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int c() {
        return this.f.f.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final long d(int i) {
        String name;
        List list = this.f.f;
        list.getClass();
        NetworkList networkList = (NetworkList) kotlin.collections.c.u(i, list);
        if (networkList != null && (name = networkList.getName()) != null) {
            return name.hashCode();
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void k(RecyclerView.ViewHolder viewHolder, final int i) {
        int i2;
        final ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        final NetworkList networkList = (NetworkList) this.f.f.get(i);
        networkList.getClass();
        TextView textView = viewHolder2.u;
        ConstraintLayout constraintLayout = viewHolder2.w;
        textView.setText(networkList.getName());
        TextView textView2 = viewHolder2.v;
        textView2.setText(networkList.getInfo());
        if (networkList.getInfo().length() == 0) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        textView2.setVisibility(i2);
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: ft0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Lazy lazy = zq0.a;
                NetworkList networkList2 = networkList;
                zq0.I(networkList2.getName());
                this.e.onNetworkClick(i, networkList2.getTunnelType());
            }
        });
        Lazy lazy = zq0.a;
        if (yg0.a(zq0.C(), networkList.getName())) {
            constraintLayout.setBackground((Drawable) viewHolder2.z.getValue());
        } else {
            constraintLayout.setBackground(null);
        }
        String icon = networkList.getIcon();
        if (icon != null) {
            try {
                InputStream open = this.d.getAssets().open("nets/".concat(icon));
                open.getClass();
                viewHolder2.y.setImageDrawable(Drawable.createFromStream(open, null));
                open.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        viewHolder2.x.setOnClickListener(new View.OnClickListener() { // from class: gt0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                final NetworkAdapter networkAdapter = NetworkAdapter.this;
                PopupMenu popupMenu = new PopupMenu(new ContextThemeWrapper(networkAdapter.d, R.style.PopupMenuLight), viewHolder2.x);
                popupMenu.getMenuInflater().inflate(R.menu.share_menu, popupMenu.getMenu());
                final int i3 = i;
                final NetworkList networkList2 = networkList;
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: ht0
                    @Override // android.widget.PopupMenu.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        int itemId = menuItem.getItemId();
                        NetworkAdapter networkAdapter2 = networkAdapter;
                        int i4 = i3;
                        NetworkList networkList3 = networkList2;
                        switch (itemId) {
                            case R.id.share_tele /* 2131297026 */:
                                networkAdapter2.u(i4, networkList3.getName(), "org.telegram.messenger");
                                return true;
                            case R.id.share_whatsapp /* 2131297027 */:
                                networkAdapter2.u(i4, networkList3.getName(), "com.whatsapp");
                                return true;
                            default:
                                return false;
                        }
                    }
                });
                popupMenu.show();
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void l(RecyclerView.ViewHolder viewHolder, int i, List list) {
        int i2;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        TextView textView = viewHolder2.v;
        list.getClass();
        if (list.isEmpty()) {
            k(viewHolder2, i);
            return;
        }
        NetworkList networkList = (NetworkList) this.f.f.get(i);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            obj.getClass();
            kotlin.collections.c.i(arrayList, (List) obj);
        }
        if (arrayList.contains("info")) {
            textView.setText(networkList.getInfo());
            if (networkList.getInfo().length() == 0) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            textView.setVisibility(i2);
        }
        arrayList.contains("tunnel");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder m(ViewGroup viewGroup, int i) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.network_item, viewGroup, false);
        inflate.getClass();
        return new ViewHolder(this, inflate);
    }

    public final void u(int i, String str, String str2) {
        List list = this.f.f;
        list.getClass();
        NetworkList networkList = (NetworkList) kotlin.collections.c.u(i, list);
        Context context = this.d;
        if (networkList == null) {
            Toast.makeText(context, "Item not found", 0).show();
            return;
        }
        try {
            String encrypt = Libv2ray.encrypt(((Gson) this.g.getValue()).g(networkList));
            String str3 = str + ".ultra";
            ContentResolver contentResolver = context.getContentResolver();
            Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
            Cursor query = contentResolver.query(uri, new String[]{"_id", "_display_name"}, "_display_name=?", new String[]{str3}, null);
            Uri uri2 = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        uri2 = Uri.withAppendedPath(uri, String.valueOf(query.getLong(query.getColumnIndexOrThrow("_id"))));
                    }
                    query.close();
                } finally {
                }
            }
            if (uri2 == null) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", str3);
                contentValues.put("mime_type", "application/x-ultra");
                contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS);
                uri2 = contentResolver.insert(uri, contentValues);
            }
            if (uri2 != null) {
                OutputStream openOutputStream = contentResolver.openOutputStream(uri2, "wt");
                if (openOutputStream != null) {
                    try {
                        encrypt.getClass();
                        byte[] bytes = encrypt.getBytes(xm.a);
                        bytes.getClass();
                        openOutputStream.write(bytes);
                        openOutputStream.flush();
                        openOutputStream.close();
                    } finally {
                    }
                }
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("application/x-ultra");
                intent.putExtra("android.intent.extra.STREAM", uri2);
                intent.putExtra("android.intent.extra.TEXT", "📢 Main Telegram Channel\nhttps://t.me/mdproxyvpn\n📂 File / Config Channel\nhttps://t.me/nurtunnelvpn\n💬 Comment & Support Group\nhttps://t.me/ipproxyvpn\n🔥 Ultra Tunnel VPN – Google Play\nhttps://play.google.com/store/apps/details?id=co.strongteam.ultra");
                intent.setPackage(str2);
                intent.addFlags(1);
                intent.addFlags(268435456);
                try {
                    context.startActivity(intent);
                    Toast.makeText(context, "Sharing to app...", 0).show();
                    return;
                } catch (Exception e) {
                    Toast.makeText(context, "App not installed", 0).show();
                    e.getMessage();
                    return;
                }
            }
            Toast.makeText(context, "Failed to create file", 0).show();
        } catch (Exception e2) {
            Toast.makeText(context, "Error sharing: " + e2.getMessage(), 0).show();
        }
    }
}
