package com.v2ray.ang;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts$RequestPermission;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewpager2.widget.ViewPager2;
import co.strongteam.ultra.R;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.tasks.Task;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.firebase.messaging.FirebaseMessaging;
import com.v2ray.ang.Hometab;
import com.v2ray.ang.ui.BaseActivity;
import com.v2ray.ang.ui.MainPagerAdapter;
import com.v2ray.ang.util.GoogleMobileAdsConsentManager;
import com.v2ray.ang.viewmodel.ConfigData;
import com.v2ray.ang.viewmodel.ConfigViewModel;
import defpackage.b1;
import defpackage.k02;
import defpackage.k5;
import defpackage.l8;
import defpackage.mn;
import defpackage.p60;
import defpackage.qf3;
import defpackage.t;
import defpackage.uc3;
import defpackage.ul1;
import defpackage.v7;
import defpackage.vd0;
import defpackage.wd0;
import defpackage.wl0;
import defpackage.xd0;
import defpackage.xu;
import defpackage.y2;
import defpackage.yd0;
import defpackage.yg0;
import defpackage.zq0;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Regex;
import libv2ray.Libv2ray;
import org.json.JSONArray;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/v2ray/ang/Hometab;", "Lcom/v2ray/ang/ui/BaseActivity;", "<init>", "()V", "Action", "Companion", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class Hometab extends BaseActivity {
    public static final Companion n = new Companion(null);
    public DrawerLayout d;
    public NavigationView e;
    public MaterialToolbar f;
    public boolean i;
    public AppUpdateManager k;
    public final ViewModelLazy l;
    public final Lazy c = kotlin.c.b(new l8(this, 6));
    public Action g = Action.NONE;
    public final ActivityResultLauncher h = registerForActivityResult(new ActivityResultContracts$RequestPermission(), new vd0(this, 0));
    public final int j = 123;
    public final wd0 m = new InstallStateUpdatedListener() { // from class: wd0
        @Override // com.google.android.play.core.listener.StateUpdatedListener
        public final void onStateUpdate(InstallState installState) {
            InstallState installState2 = installState;
            Hometab.Companion companion = Hometab.n;
            installState2.getClass();
            if (installState2.c() == 11) {
                AppUpdateManager appUpdateManager = Hometab.this.k;
                if (appUpdateManager != null) {
                    appUpdateManager.completeUpdate();
                } else {
                    yg0.N("appUpdateManager");
                    throw null;
                }
            }
        }
    };

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/v2ray/ang/Hometab$Action;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "<init>", "(Ljava/lang/String;I)V", "NONE", "POST_NOTIFICATIONS", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Action {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Action[] $VALUES;
        public static final Action NONE = new Action("NONE", 0);
        public static final Action POST_NOTIFICATIONS = new Action("POST_NOTIFICATIONS", 1);

        private static final /* synthetic */ Action[] $values() {
            return new Action[]{NONE, POST_NOTIFICATIONS};
        }

        static {
            Action[] $values = $values();
            $VALUES = $values;
            $ENTRIES = kotlin.enums.a.a($values);
        }

        private Action(String str, int i) {
        }

        public static EnumEntries<Action> getEntries() {
            return $ENTRIES;
        }

        public static Action valueOf(String str) {
            return (Action) Enum.valueOf(Action.class, str);
        }

        public static Action[] values() {
            return (Action[]) $VALUES.clone();
        }
    }

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lcom/v2ray/ang/Hometab$Companion;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "S_BIND_CALLED", "I", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion(xu xuVar) {
        }

        public static String a(String str) {
            str.getClass();
            try {
                String do_ = Libv2ray.do_(str);
                do_.getClass();
                return do_;
            } catch (Throwable unused) {
                return str;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [wd0] */
    public Hometab() {
        final Function0 function0 = null;
        this.l = new ViewModelLazy(Reflection.a(ConfigViewModel.class), new Function0<ViewModelStore>() { // from class: com.v2ray.ang.Hometab$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return ComponentActivity.this.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.v2ray.ang.Hometab$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return ComponentActivity.this.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.v2ray.ang.Hometab$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = Function0.this;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                return this.getDefaultViewModelCreationExtras();
            }
        });
    }

    public final y2 h() {
        return (y2) this.c.getValue();
    }

    public final ConfigData i() {
        return ((ConfigViewModel) this.l.getValue()).getConfigValue();
    }

    @Override // com.v2ray.ang.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle bundle) {
        boolean z;
        wl0 wl0Var;
        boolean z2;
        int i;
        super.onCreate(bundle);
        setContentView(h().a);
        DrawerLayout drawerLayout = h().b;
        drawerLayout.getClass();
        this.d = drawerLayout;
        this.e = h().c;
        MaterialToolbar materialToolbar = h().e;
        this.f = materialToolbar;
        setSupportActionBar(materialToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.p(getDrawable(R.drawable.ic_mymenu));
            supportActionBar.m(true);
        }
        Regex regex = ul1.a;
        Pair h = ul1.h(this);
        String m = ul1.m();
        String f = ul1.f(this);
        ActionBar supportActionBar2 = getSupportActionBar();
        if (supportActionBar2 != null) {
            StringBuilder sb = new StringBuilder(ul1.k((String) h.getFirst()));
            sb.append("->");
            sb.append((String) h.getSecond());
            sb.append("-");
            sb.append(m + "->" + f);
            supportActionBar2.r(sb.toString());
        }
        DrawerLayout drawerLayout2 = this.d;
        if (drawerLayout2 != null) {
            MaterialToolbar materialToolbar2 = this.f;
            if (materialToolbar2 != null) {
                ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout2, materialToolbar2, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
                DrawerLayout drawerLayout3 = this.d;
                if (drawerLayout3 != null) {
                    drawerLayout3.a(actionBarDrawerToggle);
                    DrawerLayout drawerLayout4 = actionBarDrawerToggle.b;
                    View f2 = drawerLayout4.f(8388611);
                    if (f2 != null) {
                        z = DrawerLayout.m(f2);
                    } else {
                        z = false;
                    }
                    if (z) {
                        actionBarDrawerToggle.a(1.0f);
                    } else {
                        actionBarDrawerToggle.a(0.0f);
                    }
                    if (actionBarDrawerToggle.e) {
                        DrawerArrowDrawable drawerArrowDrawable = actionBarDrawerToggle.c;
                        View f3 = drawerLayout4.f(8388611);
                        if (f3 != null) {
                            z2 = DrawerLayout.m(f3);
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            i = actionBarDrawerToggle.g;
                        } else {
                            i = actionBarDrawerToggle.f;
                        }
                        ActionBarDrawerToggle.Delegate delegate = actionBarDrawerToggle.a;
                        if (!actionBarDrawerToggle.h && !delegate.isNavigationVisible()) {
                            actionBarDrawerToggle.h = true;
                        }
                        delegate.setActionBarUpIndicator(drawerArrowDrawable, i);
                    }
                    MaterialToolbar materialToolbar3 = this.f;
                    if (materialToolbar3 != null) {
                        materialToolbar3.setOnMenuItemClickListener(new xd0(this));
                        NavigationView navigationView = this.e;
                        if (navigationView != null) {
                            navigationView.setNavigationItemSelectedListener(new xd0(this));
                            NavigationView navigationView2 = this.e;
                            if (navigationView2 != null) {
                                navigationView2.setItemIconTintList(k5.i(this, R.color.card_mainLayoutColor));
                                ViewPager2 viewPager2 = h().f;
                                TabLayout tabLayout = h().d;
                                viewPager2.setAdapter(new MainPagerAdapter(this));
                                new TabLayoutMediator(tabLayout, viewPager2, new p60(14)).a();
                                yd0 yd0Var = new yd0(this);
                                ArrayList arrayList = tabLayout.L;
                                if (!arrayList.contains(yd0Var)) {
                                    arrayList.add(yd0Var);
                                }
                                if (Build.VERSION.SDK_INT >= 33 && k5.a(this, "android.permission.POST_NOTIFICATIONS") != 0) {
                                    this.g = Action.POST_NOTIFICATIONS;
                                    this.h.a("android.permission.POST_NOTIFICATIONS");
                                }
                                String stringExtra = getIntent().getStringExtra("SAN_CONTENT");
                                if (stringExtra != null && stringExtra.equals("invalid")) {
                                    qf3.N(this, "Invalid Config");
                                }
                                synchronized (k02.class) {
                                    wl0Var = k02.a;
                                    if (wl0Var == null) {
                                        Context applicationContext = getApplicationContext();
                                        if (applicationContext == null) {
                                            applicationContext = this;
                                        }
                                        wl0 wl0Var2 = new wl0(new uc3(applicationContext));
                                        k02.a = wl0Var2;
                                        wl0Var = wl0Var2;
                                    }
                                }
                                AppUpdateManager zza = wl0Var.zza();
                                zza.getClass();
                                this.k = zza;
                                Task<v7> appUpdateInfo = zza.getAppUpdateInfo();
                                appUpdateInfo.getClass();
                                appUpdateInfo.d(new b1(new t(this, 7), 20));
                                FirebaseMessaging.c().i.p(new p60(0)).o(new p60(13));
                                Lazy lazy = zq0.a;
                                JSONArray jSONArray = new JSONArray(zq0.s());
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                                Date date = new Date();
                                for (int length = jSONArray.length() - 1; -1 < length; length--) {
                                    String optString = jSONArray.getJSONObject(length).optString("dateCreated", null);
                                    if (optString != null) {
                                        try {
                                            Date parse = simpleDateFormat.parse(optString);
                                            if (parse != null && date.getTime() - parse.getTime() >= 259200000) {
                                                jSONArray.remove(length);
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                                Lazy lazy2 = zq0.a;
                                String jSONArray2 = jSONArray.toString();
                                jSONArray2.getClass();
                                zq0.u().i("BoostedServer", jSONArray2);
                                GoogleMobileAdsConsentManager.b.a(this).a(this, new p60(15));
                                NavigationView navigationView3 = this.e;
                                if (navigationView3 != null) {
                                    View childAt = navigationView3.i.b.getChildAt(0);
                                    CardView cardView = (CardView) childAt.findViewById(R.id.cardVIPLOGIN);
                                    TextView textView = (TextView) childAt.findViewById(R.id.vip_login_text);
                                    mn mnVar = new mn(this, 3);
                                    cardView.setOnClickListener(mnVar);
                                    textView.setOnClickListener(mnVar);
                                    if (zq0.u().e("CurrentVoucher", null) != null) {
                                        textView.setText("VIP ACCESS");
                                    }
                                    cardView.setClickable(true);
                                    cardView.setFocusable(true);
                                    cardView.setBackground(getDrawable(R.drawable.ripple_effect));
                                    return;
                                }
                                yg0.N("navigationView");
                                throw null;
                            }
                            yg0.N("navigationView");
                            throw null;
                        }
                        yg0.N("navigationView");
                        throw null;
                    }
                    yg0.N("toolbar");
                    throw null;
                }
                yg0.N("drawerLayout");
                throw null;
            }
            yg0.N("toolbar");
            throw null;
        }
        yg0.N("drawerLayout");
        throw null;
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        AppUpdateManager appUpdateManager = this.k;
        if (appUpdateManager != null) {
            appUpdateManager.unregisterListener(this.m);
        } else {
            yg0.N("appUpdateManager");
            throw null;
        }
    }

    @Override // android.app.Activity
    public final boolean onPrepareOptionsMenu(Menu menu) {
        menu.getClass();
        MenuItem findItem = menu.findItem(R.id.action_clear_logs);
        if (findItem != null) {
            findItem.setVisible(this.i);
        }
        MenuItem findItem2 = menu.findItem(R.id.releaseNotes);
        if (findItem2 != null) {
            findItem2.setVisible(!this.i);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
