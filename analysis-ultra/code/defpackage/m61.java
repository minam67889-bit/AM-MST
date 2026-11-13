package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.v2ray.ang.adapter.ServerAdapter;
import com.v2ray.ang.util.GoogleMobileAdsConsentManager;
import com.v2ray.ang.viewmodel.ServerList;
import defpackage.l61;
import defpackage.qf3;
import defpackage.td0;
import defpackage.zq0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.text.g;
import org.json.JSONArray;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final /* synthetic */ class m61 implements View.OnClickListener {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ ServerList b;
    public final /* synthetic */ ServerAdapter c;
    public final /* synthetic */ ServerAdapter.ServerViewHolder d;

    public /* synthetic */ m61(ServerAdapter serverAdapter, ServerAdapter.ServerViewHolder serverViewHolder, ServerList serverList) {
        this.c = serverAdapter;
        this.d = serverViewHolder;
        this.b = serverList;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.a;
        ServerAdapter.ServerViewHolder serverViewHolder = this.d;
        ServerList serverList = this.b;
        switch (i) {
            case 0:
                int i2 = ServerAdapter.ServerViewHolder.D;
                final ServerAdapter serverAdapter = this.c;
                boolean z = serverAdapter.g;
                Context context = serverAdapter.d;
                if (z) {
                    qf3.L(context, "Please wait!!!");
                    return;
                }
                final ImageView imageView = serverViewHolder.z;
                imageView.getClass();
                final ProgressBar progressBar = serverViewHolder.B;
                progressBar.getClass();
                final ImageView imageView2 = serverViewHolder.A;
                imageView2.getClass();
                final String obj = g.d0(serverList.getName()).toString();
                if (!GoogleMobileAdsConsentManager.b.a(context).a.canRequestAds()) {
                    qf3.L(context, "Ads are not available yet");
                    return;
                }
                if (!serverAdapter.g && serverAdapter.j == null) {
                    imageView.setVisibility(8);
                    progressBar.setVisibility(0);
                    serverAdapter.g = true;
                    AdRequest build = new AdRequest.Builder().build();
                    build.getClass();
                    qf3.L(context, "Loading Ads");
                    RewardedAd.load(context, "ca-app-pub-7120795588295806/2108418468", build, new RewardedAdLoadCallback() { // from class: com.v2ray.ang.adapter.ServerAdapter$loadRewardedAd$1
                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public final void onAdFailedToLoad(LoadAdError loadAdError) {
                            loadAdError.getClass();
                            ServerAdapter serverAdapter2 = ServerAdapter.this;
                            serverAdapter2.j = null;
                            qf3.L(serverAdapter2.d, "Failed to load ads");
                            loadAdError.getCode();
                            loadAdError.getDomain();
                            loadAdError.getMessage();
                            progressBar.setVisibility(8);
                            imageView.setVisibility(0);
                            serverAdapter2.g = false;
                        }

                        @Override // com.google.android.gms.ads.AdLoadCallback
                        public final void onAdLoaded(RewardedAd rewardedAd) {
                            RewardedAd rewardedAd2 = rewardedAd;
                            rewardedAd2.getClass();
                            ServerAdapter serverAdapter2 = ServerAdapter.this;
                            serverAdapter2.j = rewardedAd2;
                            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
                            Lazy lazy = zq0.a;
                            JSONArray jSONArray = new JSONArray(zq0.s());
                            RewardedAd rewardedAd3 = serverAdapter2.j;
                            if (rewardedAd3 != null) {
                                rewardedAd3.setFullScreenContentCallback(new td0(serverAdapter2, 1));
                                RewardedAd rewardedAd4 = serverAdapter2.j;
                                if (rewardedAd4 != null) {
                                    rewardedAd4.show(serverAdapter2.e, new l61(imageView2, jSONArray, serverAdapter2, obj, format));
                                }
                            }
                            progressBar.setVisibility(8);
                            serverAdapter2.g = false;
                        }
                    });
                    return;
                }
                return;
            default:
                int i3 = ServerAdapter.ServerViewHolder.D;
                Lazy lazy = zq0.a;
                zq0.J(serverList.getName());
                this.c.f.onServerClick(serverViewHolder.c());
                return;
        }
    }

    public /* synthetic */ m61(ServerList serverList, ServerAdapter serverAdapter, ServerAdapter.ServerViewHolder serverViewHolder) {
        this.b = serverList;
        this.c = serverAdapter;
        this.d = serverViewHolder;
    }
}
