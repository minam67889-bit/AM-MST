package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a1;
import androidx.viewpager2.widget.ViewPager2;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.v2ray.ang.TabFragment;
import com.v2ray.ang.adapter.NetworkAdapter;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.viewmodel.ConfigData;
import com.v2ray.ang.viewmodel.NetworkList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1;
import kotlin.collections.c;
import kotlin.sequences.FilteringSequence;
import kotlin.sequences.b;
import kotlin.text.Regex;
import kotlin.text.g;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final /* synthetic */ class yc0 implements View.OnClickListener {
    public final /* synthetic */ int a;
    public final /* synthetic */ HomeFragment b;

    public /* synthetic */ yc0(HomeFragment homeFragment, int i) {
        this.a = i;
        this.b = homeFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Uri uri;
        String facebook;
        Window window;
        Window window2;
        int i = this.a;
        String str = null;
        int i2 = 1;
        int i3 = 0;
        HomeFragment homeFragment = this.b;
        switch (i) {
            case 0:
                int i4 = HomeFragment.f2;
                homeFragment.i0(null);
                return;
            case 1:
                int i5 = HomeFragment.f2;
                ConfigData configValue = homeFragment.e0().getConfigValue();
                if (configValue != null) {
                    str = configValue.getWhatsApp();
                }
                if (str != null && str.length() != 0) {
                    Uri parse = Uri.parse(g.c0(str).toString());
                    if (g.o(str, "chat.whatsapp.com", false)) {
                        uri = Uri.parse(g.M(str, "https://", "whatsapp://"));
                    } else if (g.o(str, "wa.me", false)) {
                        uri = Uri.parse(g.M(str, "https://wa.me/", "whatsapp://send?phone="));
                    } else {
                        uri = parse;
                    }
                    try {
                        homeFragment.U(new Intent("android.intent.action.VIEW", uri));
                        return;
                    } catch (ActivityNotFoundException unused) {
                        homeFragment.U(new Intent("android.intent.action.VIEW", parse));
                        return;
                    }
                }
                qf3.N(homeFragment.M(), "No WhatsApp link configured");
                return;
            case 2:
                int i6 = HomeFragment.f2;
                ConfigData configValue2 = homeFragment.e0().getConfigValue();
                if (configValue2 != null) {
                    str = configValue2.getFacebook();
                }
                if (str != null && str.length() != 0) {
                    ConfigData configValue3 = homeFragment.e0().getConfigValue();
                    if (configValue3 != null && (facebook = configValue3.getFacebook()) != null) {
                        g.V(facebook, "/");
                        Uri parse2 = Uri.parse("fb://facewebmodal/f?href=".concat(facebook));
                        Uri parse3 = Uri.parse(facebook);
                        try {
                            homeFragment.U(new Intent("android.intent.action.VIEW", parse2));
                            return;
                        } catch (ActivityNotFoundException unused2) {
                            homeFragment.U(new Intent("android.intent.action.VIEW", parse3));
                            return;
                        }
                    }
                    return;
                }
                qf3.N(homeFragment.M(), "No Facebook Link");
                return;
            case 3:
                int i7 = HomeFragment.f2;
                homeFragment.i0("@vpnprous_bot");
                return;
            case 4:
                int i8 = HomeFragment.f2;
                HomeFragment.D0(homeFragment, homeFragment.L(), true);
                return;
            case 5:
                int i9 = HomeFragment.f2;
                homeFragment.x0();
                return;
            case 6:
                int i10 = HomeFragment.f2;
                Lazy lazy = zq0.a;
                if (zq0.t()) {
                    qf3.N(homeFragment.M(), "Turn off use config first!!");
                    return;
                }
                Regex regex = ul1.a;
                Pair h = ul1.h(homeFragment.M());
                String k = ul1.k((String) h.getFirst());
                List list = homeFragment.H0;
                if (list != null) {
                    List f = b.f(new FilteringSequence(new CollectionsKt___CollectionsKt$asSequence$$inlined$Sequence$1(list), true, new t(k, 6)));
                    int i11 = -1;
                    if (f.isEmpty()) {
                        View inflate = homeFragment.g().inflate(R.layout.network_list, (ViewGroup) null);
                        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(homeFragment.M(), R.style.FullScreenDialog);
                        materialAlertDialogBuilder.a.r = inflate;
                        androidx.appcompat.app.g a = materialAlertDialogBuilder.a();
                        homeFragment.I0 = a;
                        a.show();
                        androidx.appcompat.app.g gVar = homeFragment.I0;
                        if (gVar != null && (window2 = gVar.getWindow()) != null) {
                            window2.setLayout(-1, -1);
                            window2.setBackgroundDrawable(new ColorDrawable(0));
                        }
                        SearchView searchView = (SearchView) inflate.findViewById(R.id.svNetwork);
                        searchView.getClass();
                        EditText editText = (EditText) searchView.findViewById(R.id.search_src_text);
                        int color = homeFragment.M().getColor(R.color.textColor);
                        editText.setTextColor(color);
                        editText.setHintTextColor(color);
                        NetworkAdapter networkAdapter = new NetworkAdapter(homeFragment.M(), new ArrayList(), homeFragment);
                        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rvNetwork);
                        recyclerView.setLayoutManager(new LinearLayoutManager(homeFragment.M()));
                        recyclerView.setAdapter(networkAdapter);
                        recyclerView.setHasFixedSize(true);
                        recyclerView.setItemViewCacheSize(20);
                        a1 a2 = recyclerView.getRecycledViewPool().a(0);
                        a2.b = 25;
                        ArrayList arrayList = a2.a;
                        while (arrayList.size() > 25) {
                            arrayList.remove(arrayList.size() - 1);
                        }
                        List list2 = homeFragment.H0;
                        if (list2 != null) {
                            networkAdapter.f.b(list2);
                            List list3 = homeFragment.H0;
                            if (list3 != null) {
                                Iterator it = list3.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        String name = ((NetworkList) it.next()).getName();
                                        Lazy lazy2 = zq0.a;
                                        if (yg0.a(name, zq0.C())) {
                                            i11 = i3;
                                        } else {
                                            i3++;
                                        }
                                    }
                                }
                                if (i11 >= 0) {
                                    recyclerView.h0(i11);
                                }
                                searchView.clearFocus();
                                searchView.setOnQueryTextListener(new pd0(homeFragment, networkAdapter));
                                return;
                            }
                            yg0.N("networkList");
                            throw null;
                        }
                        yg0.N("networkList");
                        throw null;
                    }
                    View inflate2 = LayoutInflater.from(homeFragment.M()).inflate(R.layout.dialog_tabs, (ViewGroup) null);
                    TabLayout tabLayout = (TabLayout) inflate2.findViewById(R.id.tabLayout);
                    ViewPager2 viewPager2 = (ViewPager2) inflate2.findViewById(R.id.viewPager);
                    SearchView searchView2 = (SearchView) inflate2.findViewById(R.id.searchView);
                    searchView2.getClass();
                    EditText editText2 = (EditText) searchView2.findViewById(R.id.search_src_text);
                    int color2 = homeFragment.M().getColor(R.color.colorAccent);
                    editText2.setTextColor(color2);
                    editText2.setHintTextColor(color2);
                    sd0 sd0Var = new sd0(homeFragment);
                    TabFragment.Companion companion = TabFragment.e0;
                    ArrayList arrayList2 = new ArrayList(f);
                    companion.getClass();
                    TabFragment tabFragment = new TabFragment();
                    tabFragment.a0 = arrayList2;
                    tabFragment.b0 = true;
                    tabFragment.c0 = sd0Var;
                    List list4 = homeFragment.H0;
                    if (list4 != null) {
                        ArrayList arrayList3 = new ArrayList(list4);
                        TabFragment tabFragment2 = new TabFragment();
                        tabFragment2.a0 = arrayList3;
                        tabFragment2.b0 = true;
                        tabFragment2.c0 = sd0Var;
                        List A = c.A(tabFragment, tabFragment2);
                        List A2 = c.A("Recommended", "All Country");
                        viewPager2.setAdapter(new qd0(homeFragment, A));
                        viewPager2.setOffscreenPageLimit(1);
                        new TabLayoutMediator(tabLayout, viewPager2, new b1(A2, 19)).a();
                        searchView2.setOnQueryTextListener(new rd0(tabFragment, tabFragment2));
                        MaterialAlertDialogBuilder materialAlertDialogBuilder2 = new MaterialAlertDialogBuilder(homeFragment.M(), R.style.FullScreenDialog);
                        materialAlertDialogBuilder2.a.r = inflate2;
                        androidx.appcompat.app.g a3 = materialAlertDialogBuilder2.a();
                        homeFragment.I0 = a3;
                        a3.show();
                        androidx.appcompat.app.g gVar2 = homeFragment.I0;
                        if (gVar2 != null && (window = gVar2.getWindow()) != null) {
                            window.setLayout(-1, -1);
                            window.setBackgroundDrawable(new ColorDrawable(0));
                            return;
                        }
                        return;
                    }
                    yg0.N("networkList");
                    throw null;
                }
                yg0.N("networkList");
                throw null;
            default:
                int i12 = HomeFragment.f2;
                if (!homeFragment.W()) {
                    qf3.L(homeFragment.M(), "Ads are not available yet");
                    return;
                }
                if (homeFragment.o1 != null) {
                    ConfigData configValue4 = homeFragment.e0().getConfigValue();
                    configValue4.getClass();
                    if (configValue4.isTimerOn()) {
                        MaterialAlertDialogBuilder materialAlertDialogBuilder3 = new MaterialAlertDialogBuilder(homeFragment.L());
                        AlertController.AlertParams alertParams = materialAlertDialogBuilder3.a;
                        alertParams.e = "Adding Time";
                        alertParams.g = hz.p(homeFragment.w1, "Watch advertisement to receive:\n\n• ", " additional hours.\n\nYou must watch the advertisement to completion to receive the reward.");
                        materialAlertDialogBuilder3.h("Watch", new zc0(homeFragment, i3));
                        materialAlertDialogBuilder3.g("Cancel", new zc0(homeFragment, i2));
                        androidx.appcompat.app.g a4 = materialAlertDialogBuilder3.a();
                        homeFragment.I0 = a4;
                        a4.show();
                        return;
                    }
                    RewardedAd rewardedAd = homeFragment.o1;
                    if (rewardedAd != null) {
                        rewardedAd.setFullScreenContentCallback(new td0(homeFragment, i3));
                    }
                    RewardedAd rewardedAd2 = homeFragment.o1;
                    if (rewardedAd2 != null) {
                        rewardedAd2.show(homeFragment.L(), new ad0(homeFragment));
                        return;
                    }
                    return;
                }
                homeFragment.o0();
                return;
        }
    }
}
