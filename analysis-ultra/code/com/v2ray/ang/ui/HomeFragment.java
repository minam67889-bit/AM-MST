package com.v2ray.ang.ui;

import android.app.ActivityManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.contract.ActivityResultContracts$StartActivityForResult;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.widget.SearchView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.m;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import co.strongteam.ultra.R;
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sandok.tunnel.core.ConfigParser;
import com.sandok.tunnel.core.Connection;
import com.sandok.tunnel.core.VpnProfile;
import com.sandok.tunnel.service.InjectorService;
import com.sandok.tunnel.service.OpenVPNService;
import com.sandok.tunnel.utils.ConfigUtil;
import com.sandok.tunnel.utils.StatisticsGraphData;
import com.trilead.ssh2.sftp.AttribFlags;
import com.v2ray.ang.AngApplication;
import com.v2ray.ang.Hometab;
import com.v2ray.ang.adapter.NetworkAdapter;
import com.v2ray.ang.adapter.ServerAdapter;
import com.v2ray.ang.helper.Protocol;
import com.v2ray.ang.service.CountdownService;
import com.v2ray.ang.ui.HomeFragment;
import com.v2ray.ang.util.CircleProgressBar;
import com.v2ray.ang.util.ConfigUpdate;
import com.v2ray.ang.util.GoogleMobileAdsConsentManager;
import com.v2ray.ang.util.NetworkMonitor;
import com.v2ray.ang.viewmodel.ConfigData;
import com.v2ray.ang.viewmodel.ConfigViewModel;
import com.v2ray.ang.viewmodel.MainViewModel;
import com.v2ray.ang.viewmodel.NetworkList;
import com.v2ray.ang.viewmodel.ServerList;
import com.vpn.sandok.ultrasshservice.SocksHttpService;
import com.vpn.sandok.ultrasshservice.config.SettingsConstants;
import com.vpn.sandok.ultrasshservice.logger.ConnectionStatus;
import com.vpn.sandok.ultrasshservice.logger.LogItem;
import com.vpn.sandok.ultrasshservice.logger.SkStatus;
import com.vpn.sandok.ultrasshservice.tunnel.TunnelManagerHelper;
import com.vpn.sandok.ultrasshservice.tunnel.vpn.TunnelVpnService;
import defpackage.ad0;
import defpackage.bn0;
import defpackage.e4;
import defpackage.ec1;
import defpackage.g90;
import defpackage.hz;
import defpackage.j60;
import defpackage.jd0;
import defpackage.kd0;
import defpackage.lv;
import defpackage.nd0;
import defpackage.od0;
import defpackage.oy;
import defpackage.qf3;
import defpackage.r6;
import defpackage.tc0;
import defpackage.ul1;
import defpackage.vh;
import defpackage.xm;
import defpackage.xu;
import defpackage.yc0;
import defpackage.yg0;
import defpackage.zq0;
import defpackage.zr;
import j$.util.Objects;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.EmptyList;
import kotlin.collections.c;
import kotlin.io.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Reflection;
import kotlin.random.Random;
import kotlin.text.Regex;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobImpl;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.ContextScope;
import libv2ray.CoreController;
import libv2ray.Libv2ray;
import me.ibrahimsn.lib.SmoothBottomBar;
import net.openvpn.openvpn.ClientAPI_ConnectionInfo;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0003\u000b\f\rB\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/v2ray/ang/ui/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/sandok/tunnel/service/InjectorService$InjectorListener;", "Lcom/sandok/tunnel/service/OpenVPNService$EventReceiver;", "Lcom/v2ray/ang/adapter/ServerAdapter$ServerItemClickListener;", "Lcom/v2ray/ang/adapter/NetworkAdapter$NetworkItemClickListener;", "Lcom/v2ray/ang/util/ConfigUpdate$UpdateAvailable;", "Lcom/vpn/sandok/ultrasshservice/logger/SkStatus$StateListener;", "Lcom/vpn/sandok/ultrasshservice/logger/SkStatus$LogListener;", "<init>", "()V", "Companion", "OVPNConfig", "EpkiPost", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HomeFragment extends Fragment implements InjectorService.InjectorListener, OpenVPNService.EventReceiver, ServerAdapter.ServerItemClickListener, NetworkAdapter.NetworkItemClickListener, ConfigUpdate.UpdateAvailable, SkStatus.StateListener, SkStatus.LogListener {
    public static final /* synthetic */ int f2 = 0;
    public String A0;
    public LineChart A1;
    public String B0;
    public WeakReference B1;
    public String C0;
    public ContextScope C1;
    public String D0;
    public TextView D1;
    public String E0;
    public ImageView E1;
    public final Gson F0;
    public InterstitialAd F1;
    public List G0;
    public ConfigUpdate G1;
    public List H0;
    public boolean H1;
    public androidx.appcompat.app.g I0;
    public String I1;
    public TextView J0;
    public TextView J1;
    public TextView K0;
    public LinearLayout K1;
    public TextView L0;
    public SmoothBottomBar L1;
    public TextView M0;
    public ImageView M1;
    public TextView N0;
    public ImageView N1;
    public ImageView O0;
    public final ContextScope O1;
    public MaterialButton P0;
    public boolean P1;
    public final g90 Q0;
    public boolean Q1;
    public RelativeLayout R0;
    public int R1;
    public RelativeLayout S0;
    public boolean S1;
    public boolean T0;
    public final jd0 T1;
    public ConfigUtil U0;
    public int U1;
    public int V0;
    public final int V1;
    public final r6 W0;
    public boolean W1;
    public TextView X0;
    public List X1;
    public String Y;
    public TextView Y0;
    public OpenVPNService Y1;
    public String Z;
    public TextView Z0;
    public long Z1;
    public String a0;
    public TextView a1;
    public int a2;
    public String b0;
    public TextView b1;
    public final j60 b2;
    public boolean c0;
    public CardView c1;
    public final Handler c2;
    public String d0;
    public Job d1;
    public InjectorService d2;
    public String e0;
    public final ViewModelLazy e1;
    public final kd0 e2;
    public String f0;
    public final ViewModelLazy f1;
    public String g0;
    public NetworkMonitor g1;
    public boolean h0;
    public SwitchMaterial h1;
    public String i0;
    public final g90 i1;
    public String j0;
    public AdView j1;
    public String k0;
    public FrameLayout k1;
    public boolean l0;
    public GoogleMobileAdsConsentManager l1;
    public String m0;
    public final AtomicBoolean m1;
    public String n0;
    public final AtomicBoolean n1;
    public String o0;
    public RewardedAd o1;
    public boolean p0;
    public boolean p1;
    public String q0;
    public boolean q1;
    public String r0;
    public boolean r1;
    public String s0;
    public Job s1;
    public String t0;
    public long t1;
    public String u0;
    public MaterialButton u1;
    public String v0;
    public ProgressBar v1;
    public String w0;
    public int w1;
    public boolean x0;
    public long x1;
    public String y0;
    public long y1;
    public String z0;
    public CircleProgressBar z1;

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\t"}, d2 = {"Lcom/v2ray/ang/ui/HomeFragment$Companion;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "INTERSTITIAL_COOLDOWN_MS", "J", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "MAX_BANNER_RETRY_COUNT", "I", "BANNER_RETRY_BASE_DELAY_MS", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public Companion(xu xuVar) {
        }
    }

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bd\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007À\u0006\u0003"}, d2 = {"Lcom/v2ray/ang/ui/HomeFragment$EpkiPost;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "str", "Lmk1;", "post_dispatch", "(Ljava/lang/String;)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface EpkiPost {
        void post_dispatch(String str);
    }

    /* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/v2ray/ang/ui/HomeFragment$OVPNConfig;", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, SettingsConstants.TUNNELTYPE_KEY, RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, "host", "sni", "proxy", "proxyPort", "payload", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final /* data */ class OVPNConfig {
        public final int a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;

        public OVPNConfig(int i, String str, String str2, String str3, String str4, String str5) {
            ec1.T(str, str2, str3, str4, str5);
            this.a = i;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = str4;
            this.f = str5;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (obj instanceof OVPNConfig) {
                    OVPNConfig oVPNConfig = (OVPNConfig) obj;
                    if (this.a != oVPNConfig.a || !this.b.equals(oVPNConfig.b) || !this.c.equals(oVPNConfig.c) || !this.d.equals(oVPNConfig.d) || !this.e.equals(oVPNConfig.e) || !this.f.equals(oVPNConfig.f)) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.f.hashCode() + vh.c(vh.c(vh.c(vh.c(this.a * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("OVPNConfig(tunnelType=");
            sb.append(this.a);
            sb.append(", host=");
            sb.append(this.b);
            sb.append(", sni=");
            hz.H(sb, this.c, ", proxy=", this.d, ", proxyPort=");
            return hz.x(sb, this.e, ", payload=", this.f, ")");
        }
    }

    static {
        new Companion(null);
    }

    public HomeFragment() {
        super(R.layout.fragment_home);
        final int i = 1;
        this.h0 = true;
        this.l0 = true;
        this.x0 = true;
        this.F0 = new Gson();
        final int i2 = 0;
        this.Q0 = (g90) registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback(this) { // from class: uc0
            public final /* synthetic */ HomeFragment b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Uri uri;
                String str;
                int i3 = i2;
                HomeFragment homeFragment = this.b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i3) {
                    case 0:
                        int i4 = HomeFragment.f2;
                        activityResult.getClass();
                        if (activityResult.a == -1) {
                            homeFragment.F0();
                            return;
                        }
                        return;
                    default:
                        int i5 = HomeFragment.f2;
                        activityResult.getClass();
                        if (activityResult.a == -1) {
                            Intent intent = activityResult.b;
                            if (intent != null) {
                                uri = intent.getData();
                            } else {
                                uri = null;
                            }
                            if (uri != null) {
                                Context M = homeFragment.M();
                                Gson gson = homeFragment.F0;
                                InputStream openInputStream = M.getContentResolver().openInputStream(uri);
                                if (openInputStream != null) {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openInputStream, xm.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
                                    try {
                                        str = d.b(bufferedReader);
                                        bufferedReader.close();
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            if3.c(bufferedReader, th);
                                            throw th2;
                                        }
                                    }
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    try {
                                        if (Libv2ray.parseConfig(str)) {
                                            String gc = Libv2ray.gc();
                                            Hometab.Companion companion = Hometab.n;
                                            gc.getClass();
                                            companion.getClass();
                                            String a = Hometab.Companion.a(gc);
                                            new JSONObject(a);
                                            gson.getClass();
                                            Object c = gson.c(a, new TypeToken(NetworkList.class));
                                            c.getClass();
                                            List z = c.z((NetworkList) c);
                                            homeFragment.H0 = z;
                                            Lazy lazy = zq0.a;
                                            zq0.I(((NetworkList) c.r(z)).getName());
                                            List list = homeFragment.H0;
                                            if (list != null) {
                                                zq0.H(((NetworkList) c.r(list)).getTunnelType());
                                                homeFragment.z0();
                                                zq0.u().i("ConfigFile", gc);
                                                homeFragment.C0();
                                                return;
                                            }
                                            yg0.N("networkList");
                                            throw null;
                                        }
                                        Hometab.n.getClass();
                                        String a2 = Hometab.Companion.a(str);
                                        new JSONObject(a2);
                                        gson.getClass();
                                        Object c2 = gson.c(a2, new TypeToken(NetworkList.class));
                                        c2.getClass();
                                        List z2 = c.z((NetworkList) c2);
                                        homeFragment.H0 = z2;
                                        Lazy lazy2 = zq0.a;
                                        zq0.I(((NetworkList) c.r(z2)).getName());
                                        List list2 = homeFragment.H0;
                                        if (list2 != null) {
                                            zq0.H(((NetworkList) c.r(list2)).getTunnelType());
                                            homeFragment.z0();
                                            zq0.u().i("ConfigFile", str);
                                            homeFragment.C0();
                                            return;
                                        }
                                        yg0.N("networkList");
                                        throw null;
                                    } catch (Exception unused) {
                                        SwitchMaterial switchMaterial = homeFragment.h1;
                                        if (switchMaterial != null) {
                                            switchMaterial.setChecked(false);
                                        }
                                        qf3.N(homeFragment.M(), "Invalid File");
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        SwitchMaterial switchMaterial2 = homeFragment.h1;
                        if (switchMaterial2 != null) {
                            switchMaterial2.setChecked(false);
                            return;
                        }
                        return;
                }
            }
        });
        this.W0 = new r6(this, 2);
        this.e1 = new ViewModelLazy(Reflection.a(ConfigViewModel.class), new Function0<ViewModelStore>() { // from class: com.v2ray.ang.ui.HomeFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = Fragment.this.L().getViewModelStore();
                viewModelStore.getClass();
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.v2ray.ang.ui.HomeFragment$special$$inlined$activityViewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return Fragment.this.L().getDefaultViewModelProviderFactory();
            }
        });
        this.f1 = new ViewModelLazy(Reflection.a(MainViewModel.class), new Function0<ViewModelStore>() { // from class: com.v2ray.ang.ui.HomeFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = Fragment.this.L().getViewModelStore();
                viewModelStore.getClass();
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.v2ray.ang.ui.HomeFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return Fragment.this.L().getDefaultViewModelProviderFactory();
            }
        });
        this.i1 = (g90) registerForActivityResult(new ActivityResultContracts$StartActivityForResult(), new ActivityResultCallback(this) { // from class: uc0
            public final /* synthetic */ HomeFragment b;

            {
                this.b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Uri uri;
                String str;
                int i3 = i;
                HomeFragment homeFragment = this.b;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i3) {
                    case 0:
                        int i4 = HomeFragment.f2;
                        activityResult.getClass();
                        if (activityResult.a == -1) {
                            homeFragment.F0();
                            return;
                        }
                        return;
                    default:
                        int i5 = HomeFragment.f2;
                        activityResult.getClass();
                        if (activityResult.a == -1) {
                            Intent intent = activityResult.b;
                            if (intent != null) {
                                uri = intent.getData();
                            } else {
                                uri = null;
                            }
                            if (uri != null) {
                                Context M = homeFragment.M();
                                Gson gson = homeFragment.F0;
                                InputStream openInputStream = M.getContentResolver().openInputStream(uri);
                                if (openInputStream != null) {
                                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openInputStream, xm.a), AttribFlags.SSH_FILEXFER_ATTR_LINK_COUNT);
                                    try {
                                        str = d.b(bufferedReader);
                                        bufferedReader.close();
                                    } catch (Throwable th) {
                                        try {
                                            throw th;
                                        } catch (Throwable th2) {
                                            if3.c(bufferedReader, th);
                                            throw th2;
                                        }
                                    }
                                } else {
                                    str = null;
                                }
                                if (str != null) {
                                    try {
                                        if (Libv2ray.parseConfig(str)) {
                                            String gc = Libv2ray.gc();
                                            Hometab.Companion companion = Hometab.n;
                                            gc.getClass();
                                            companion.getClass();
                                            String a = Hometab.Companion.a(gc);
                                            new JSONObject(a);
                                            gson.getClass();
                                            Object c = gson.c(a, new TypeToken(NetworkList.class));
                                            c.getClass();
                                            List z = c.z((NetworkList) c);
                                            homeFragment.H0 = z;
                                            Lazy lazy = zq0.a;
                                            zq0.I(((NetworkList) c.r(z)).getName());
                                            List list = homeFragment.H0;
                                            if (list != null) {
                                                zq0.H(((NetworkList) c.r(list)).getTunnelType());
                                                homeFragment.z0();
                                                zq0.u().i("ConfigFile", gc);
                                                homeFragment.C0();
                                                return;
                                            }
                                            yg0.N("networkList");
                                            throw null;
                                        }
                                        Hometab.n.getClass();
                                        String a2 = Hometab.Companion.a(str);
                                        new JSONObject(a2);
                                        gson.getClass();
                                        Object c2 = gson.c(a2, new TypeToken(NetworkList.class));
                                        c2.getClass();
                                        List z2 = c.z((NetworkList) c2);
                                        homeFragment.H0 = z2;
                                        Lazy lazy2 = zq0.a;
                                        zq0.I(((NetworkList) c.r(z2)).getName());
                                        List list2 = homeFragment.H0;
                                        if (list2 != null) {
                                            zq0.H(((NetworkList) c.r(list2)).getTunnelType());
                                            homeFragment.z0();
                                            zq0.u().i("ConfigFile", str);
                                            homeFragment.C0();
                                            return;
                                        }
                                        yg0.N("networkList");
                                        throw null;
                                    } catch (Exception unused) {
                                        SwitchMaterial switchMaterial = homeFragment.h1;
                                        if (switchMaterial != null) {
                                            switchMaterial.setChecked(false);
                                        }
                                        qf3.N(homeFragment.M(), "Invalid File");
                                        return;
                                    }
                                }
                                return;
                            }
                            return;
                        }
                        SwitchMaterial switchMaterial2 = homeFragment.h1;
                        if (switchMaterial2 != null) {
                            switchMaterial2.setChecked(false);
                            return;
                        }
                        return;
                }
            }
        });
        this.m1 = new AtomicBoolean(false);
        this.n1 = new AtomicBoolean(false);
        this.w1 = 2;
        lv lvVar = oy.a;
        MainCoroutineDispatcher mainCoroutineDispatcher = bn0.a;
        JobImpl a = kotlinx.coroutines.g.a();
        mainCoroutineDispatcher.getClass();
        this.C1 = zr.a(kotlin.coroutines.b.d(a, mainCoroutineDispatcher));
        this.O1 = zr.a(kotlin.coroutines.b.d(mainCoroutineDispatcher.e(), (JobSupport) kotlinx.coroutines.a.c()).plus(new HomeFragment$special$$inlined$CoroutineExceptionHandler$1(CoroutineExceptionHandler.Key)));
        this.T1 = new jd0(this);
        this.V1 = 3;
        this.X1 = EmptyList.INSTANCE;
        this.a2 = -1;
        this.b2 = new j60(this, 4);
        this.c2 = new Handler(Looper.getMainLooper());
        this.e2 = new kd0(this);
    }

    public static void D0(HomeFragment homeFragment, FragmentActivity fragmentActivity, boolean z) {
        Lazy lazy = zq0.a;
        if (!qf3.C(zq0.u().e("CurrentVoucher", null))) {
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date());
            JSONArray jSONArray = new JSONArray(zq0.s());
            if (homeFragment.W()) {
                InterstitialAd interstitialAd = homeFragment.F1;
                if (interstitialAd == null) {
                    homeFragment.l0(fragmentActivity);
                    return;
                }
                interstitialAd.setFullScreenContentCallback(new od0(homeFragment, fragmentActivity, z, jSONArray, format));
                InterstitialAd interstitialAd2 = homeFragment.F1;
                if (interstitialAd2 != null) {
                    interstitialAd2.show(fragmentActivity);
                }
            }
        }
    }

    public static String d0() {
        StringBuilder sb = new StringBuilder(18);
        for (int i = 0; i < 18; i++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(Random.INSTANCE.nextInt(52)));
        }
        Regex regex = ul1.a;
        String sb2 = sb.toString();
        Charset charset = xm.a;
        byte[] bytes = "12345678901234567890123456789012".getBytes(charset);
        bytes.getClass();
        SecretKeySpec secretKeySpec = new SecretKeySpec(bytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] bArr = new byte[12];
        new SecureRandom().nextBytes(bArr);
        cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr));
        byte[] bytes2 = sb2.getBytes(charset);
        bytes2.getClass();
        byte[] doFinal = cipher.doFinal(bytes2);
        doFinal.getClass();
        int length = doFinal.length;
        byte[] copyOf = Arrays.copyOf(bArr, 12 + length);
        System.arraycopy(doFinal, 0, copyOf, 12, length);
        String encodeToString = Base64.encodeToString(copyOf, 2);
        encodeToString.getClass();
        return encodeToString;
    }

    public static ArrayList g0(Context context) {
        Object systemService = context.getSystemService("activity");
        systemService.getClass();
        ArrayList arrayList = new ArrayList();
        for (ActivityManager.RunningServiceInfo runningServiceInfo : ((ActivityManager) systemService).getRunningServices(Integer.MAX_VALUE)) {
            if (yg0.a(runningServiceInfo.service.getPackageName(), context.getPackageName())) {
                String className = runningServiceInfo.service.getClassName();
                className.getClass();
                arrayList.add(className);
            }
        }
        return arrayList;
    }

    public static String s0(long j) {
        float f = (float) j;
        if (f >= 1.0E12f) {
            return String.format("%.2f %s", Arrays.copyOf(new Object[]{Float.valueOf(f / 1.09951163E12f), "TB"}, 2));
        }
        if (f >= 1.0E9f) {
            return String.format("%.2f %s", Arrays.copyOf(new Object[]{Float.valueOf(f / 1.07374182E9f), "GB"}, 2));
        }
        if (f >= 1000000.0f) {
            return String.format("%.2f %s", Arrays.copyOf(new Object[]{Float.valueOf(f / 1048576.0f), "MB"}, 2));
        }
        if (f >= 1000.0f) {
            return String.format("%.2f %s", Arrays.copyOf(new Object[]{Float.valueOf(f / 1024.0f), "KB"}, 2));
        }
        return String.format("%.0f KB", Arrays.copyOf(new Object[]{Float.valueOf(f)}, 1));
    }

    public static String t0(int i) {
        return String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i / 3600), Integer.valueOf((i / 60) % 60), Integer.valueOf(i % 60)}, 3));
    }

    public static String v0(String str, String str2) {
        Hometab.Companion companion = Hometab.n;
        if (str == null) {
            str = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        companion.getClass();
        String a = Hometab.Companion.a(str);
        if (a.equals("[host]")) {
            if (str2 == null) {
                str2 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            return Hometab.Companion.a(str2);
        }
        return a;
    }

    public static String w0(long j) {
        long j2 = j / 86400000;
        long j3 = j / 3600000;
        long j4 = j / 60000;
        return String.format("%02d:%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j2), Long.valueOf(j3 - TimeUnit.DAYS.toHours(j2)), Long.valueOf(j4 - TimeUnit.HOURS.toMinutes(j3)), Long.valueOf((j / 1000) - TimeUnit.MINUTES.toSeconds(j4))}, 4));
    }

    public final void A0(String str) {
        if (o() && this.F != null) {
            str.getClass();
            if (kotlin.text.g.o(str, "Profile not found", false)) {
                kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$setStatusVIew$1(this, null), 3);
                return;
            }
            if (kotlin.text.g.o(str, "Fail", false)) {
                r0();
                return;
            }
            if (kotlin.text.g.o(str, "Reconnecting", false)) {
                TextView textView = this.J0;
                if (textView != null) {
                    textView.setText(str);
                }
                CircleProgressBar circleProgressBar = this.z1;
                if (circleProgressBar != null) {
                    circleProgressBar.setProgressWithAnimation(50.0f);
                    return;
                }
                return;
            }
            if (kotlin.text.g.o(str, "Success", false)) {
                TextView textView2 = this.J0;
                if (textView2 != null) {
                    textView2.setText("Connected");
                }
                I0();
                FragmentActivity L = L();
                if (SystemClock.elapsedRealtime() - this.t1 >= 180000 && W()) {
                    D0(this, L, false);
                }
                CircleProgressBar circleProgressBar2 = this.z1;
                if (circleProgressBar2 != null) {
                    circleProgressBar2.setProgressWithAnimation(100.0f);
                }
                Job job = this.d1;
                if (job != null) {
                    job.cancel((CancellationException) null);
                }
                b0(false);
                G0();
                return;
            }
            if (kotlin.text.g.o(str, "Connected", false)) {
                CircleProgressBar circleProgressBar3 = this.z1;
                if (circleProgressBar3 != null) {
                    circleProgressBar3.setProgressWithAnimation(100.0f);
                }
                TextView textView3 = this.J0;
                if (textView3 != null) {
                    textView3.setText("Connected");
                }
                I0();
                Job job2 = this.d1;
                if (job2 != null) {
                    job2.cancel((CancellationException) null);
                }
                FragmentActivity L2 = L();
                if (SystemClock.elapsedRealtime() - this.t1 >= 180000 && W()) {
                    D0(this, L2, false);
                }
                b0(false);
                G0();
                return;
            }
            if (kotlin.text.g.o(str, "Checking", false)) {
                TextView textView4 = this.J0;
                if (textView4 != null) {
                    textView4.setText(str);
                }
                Job job3 = this.d1;
                if (job3 != null) {
                    job3.cancel((CancellationException) null);
                }
                CircleProgressBar circleProgressBar4 = this.z1;
                if (circleProgressBar4 != null) {
                    circleProgressBar4.setProgressWithAnimation(95.0f);
                    return;
                }
                return;
            }
            if (kotlin.text.g.o(str, "Connecting", false)) {
                TextView textView5 = this.J0;
                if (textView5 != null) {
                    textView5.setText(str);
                }
                CircleProgressBar circleProgressBar5 = this.z1;
                if (circleProgressBar5 != null) {
                    circleProgressBar5.setProgressWithAnimation(95.0f);
                }
                Job job4 = this.d1;
                if (job4 != null) {
                    job4.cancel((CancellationException) null);
                }
                if (yg0.a(this.t0, "SSH") || yg0.a(this.t0, "DNSTT") || yg0.a(this.t0, "UDP Hysteria")) {
                    this.d1 = kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$setStatusVIew$2(this, null), 3);
                }
                if (yg0.a(this.f0, "V2ray")) {
                    Job job5 = this.d1;
                    if (job5 != null) {
                        job5.cancel((CancellationException) null);
                    }
                    this.d1 = kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$setStatusVIew$3(this, null), 3);
                    return;
                }
                return;
            }
            if (kotlin.text.g.o(str, "Waiting", false)) {
                TextView textView6 = this.J0;
                if (textView6 != null) {
                    textView6.setText(str);
                }
                CircleProgressBar circleProgressBar6 = this.z1;
                if (circleProgressBar6 != null) {
                    circleProgressBar6.setProgressWithAnimation(80.0f);
                }
                TextView textView7 = this.J0;
                if (textView7 != null) {
                    textView7.setText(str);
                }
                Job job6 = this.d1;
                if (job6 != null) {
                    job6.cancel((CancellationException) null);
                }
                this.d1 = kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$setStatusVIew$4(this, null), 3);
                return;
            }
            if (kotlin.text.g.o(str, "Unknown Open", false)) {
                TextView textView8 = this.J0;
                if (textView8 != null) {
                    textView8.setText(str);
                }
                CircleProgressBar circleProgressBar7 = this.z1;
                if (circleProgressBar7 != null) {
                    circleProgressBar7.setProgressWithAnimation(80.0f);
                }
                Job job7 = this.d1;
                if (job7 != null) {
                    job7.cancel((CancellationException) null);
                }
                this.d1 = kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$setStatusVIew$5(this, null), 3);
                return;
            }
            if (kotlin.text.g.o(str, "Authentication failed", false)) {
                TextView textView9 = this.J0;
                if (textView9 != null) {
                    textView9.setText(str);
                }
                CircleProgressBar circleProgressBar8 = this.z1;
                if (circleProgressBar8 != null) {
                    circleProgressBar8.setProgressWithAnimation(50.0f);
                }
                Job job8 = this.d1;
                if (job8 != null) {
                    job8.cancel((CancellationException) null);
                }
                this.d1 = kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$setStatusVIew$6(this, null), 3);
                return;
            }
            if (kotlin.text.g.o(str, "Starting", false)) {
                TextView textView10 = this.J0;
                if (textView10 != null) {
                    textView10.setText(str);
                }
                CircleProgressBar circleProgressBar9 = this.z1;
                if (circleProgressBar9 != null) {
                    circleProgressBar9.setProgressWithAnimation(70.0f);
                }
                TextView textView11 = this.J0;
                if (textView11 != null) {
                    textView11.setText(str);
                }
                Job job9 = this.d1;
                if (job9 != null) {
                    job9.cancel((CancellationException) null);
                    return;
                }
                return;
            }
            if (kotlin.text.g.o(str, "Disconnected", false)) {
                CircleProgressBar circleProgressBar10 = this.z1;
                if (circleProgressBar10 != null) {
                    circleProgressBar10.setProgressWithAnimation(0.0f);
                }
                TextView textView12 = this.J0;
                if (textView12 != null) {
                    textView12.setText(str);
                    return;
                }
                return;
            }
            boolean o = kotlin.text.g.o(str, "Authenticating", false);
            TextView textView13 = this.J0;
            if (o) {
                if (textView13 != null) {
                    textView13.setText(str);
                }
                CircleProgressBar circleProgressBar11 = this.z1;
                if (circleProgressBar11 != null) {
                    circleProgressBar11.setProgressWithAnimation(95.0f);
                }
                Job job10 = this.d1;
                if (job10 != null) {
                    job10.cancel((CancellationException) null);
                    return;
                }
                return;
            }
            if (textView13 != null) {
                textView13.setText(str);
            }
        }
    }

    public final void B0() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("COUNTDOWN_UPDATE");
        intentFilter.addAction("COUNTDOWN_FINISH");
        int i = Build.VERSION.SDK_INT;
        r6 r6Var = this.W0;
        if (i >= 33) {
            M().registerReceiver(r6Var, intentFilter, 2);
        } else {
            M().registerReceiver(r6Var, intentFilter);
        }
        Lazy lazy = zq0.a;
        String w0 = w0(zq0.B());
        TextView textView = this.b1;
        if (textView != null) {
            textView.setText(w0);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:184:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void C0() {
        /*
            Method dump skipped, instructions count: 712
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.C0():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [ld0, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void D() {
        this.D = true;
        if (this.h1 != null) {
            if (this.Y1 == null && kotlin.text.g.o(g0(M()).toString(), "OpenVPNService", false)) {
                Z();
            }
            C0();
            Handler handler = this.c2;
            j60 j60Var = this.b2;
            handler.removeCallbacks(j60Var);
            handler.postDelayed(j60Var, 1000L);
            if (W()) {
                l0(M());
            }
            if (this.x1 - this.y1 >= 180000) {
                Application application = L().getApplication();
                application.getClass();
                ((AngApplication) application).a(L(), new Object());
                this.y1 = this.x1;
            }
            ConfigUpdate configUpdate = this.G1;
            if (configUpdate != null) {
                configUpdate.a();
            }
        }
    }

    public final void E0(int i) {
        if (!yg0.a(f0().isRunning().d(), Boolean.TRUE) && !SkStatus.isTunnelActive()) {
            if (i != R.string.disconnected) {
                A0(j().getString(i));
                return;
            }
            return;
        }
        String.valueOf(SkStatus.isTunnelActive());
    }

    @Override // androidx.fragment.app.Fragment
    public final void F() {
        this.D = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x032d, code lost:
    
        if (r3.equals("UDP Hysteria") == false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0339, code lost:
    
        H0();
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x033c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0336, code lost:
    
        if (r3.equals("Slow DNS") == false) goto L113;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void F0() {
        /*
            Method dump skipped, instructions count: 904
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.F0():void");
    }

    public final void G0() {
        zr.b(this.C1, null);
        lv lvVar = oy.a;
        MainCoroutineDispatcher mainCoroutineDispatcher = bn0.a;
        JobImpl a = kotlinx.coroutines.g.a();
        mainCoroutineDispatcher.getClass();
        ContextScope a2 = zr.a(kotlin.coroutines.b.d(a, mainCoroutineDispatcher));
        this.C1 = a2;
        kotlinx.coroutines.c.d(a2, null, null, new HomeFragment$startPinging$1(this, null), 3);
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.google.android.gms.ads.initialization.OnInitializationCompleteListener, java.lang.Object] */
    @Override // androidx.fragment.app.Fragment
    public final void H(View view, Bundle bundle) {
        int i;
        FragmentActivity d;
        CardView cardView;
        String str;
        view.getClass();
        ConfigUtil configUtil = ConfigUtil.getInstance(M());
        configUtil.getClass();
        this.U0 = configUtil;
        int i2 = 1;
        M().bindService(new Intent(M(), (Class<?>) InjectorService.class), this.e2, 1);
        Z();
        if (y0()) {
            this.c1 = (CardView) view.findViewById(R.id.cardTimer);
            this.b1 = (TextView) view.findViewById(R.id.timerTextView);
            this.a1 = (TextView) view.findViewById(R.id.config_version);
            this.X0 = (TextView) view.findViewById(R.id.duration);
            this.Y0 = (TextView) view.findViewById(R.id.bytes_in);
            this.Z0 = (TextView) view.findViewById(R.id.bytes_out);
            this.J0 = (TextView) view.findViewById(R.id.Status);
            this.P0 = (MaterialButton) view.findViewById(R.id.btnconnect);
            this.K0 = (TextView) view.findViewById(R.id.tvServerProtocol);
            this.N0 = (TextView) view.findViewById(R.id.tvNetworkName);
            this.M0 = (TextView) view.findViewById(R.id.tvServerName);
            this.L0 = (TextView) view.findViewById(R.id.tvNetworkInfo);
            this.O0 = (ImageView) view.findViewById(R.id.imgServer);
            this.h1 = (SwitchMaterial) view.findViewById(R.id.swUseConfig);
            this.k1 = (FrameLayout) view.findViewById(R.id.framAdview);
            this.u1 = (MaterialButton) view.findViewById(R.id.btnAddtime);
            this.v1 = (ProgressBar) view.findViewById(R.id.PBLoader);
            this.z1 = (CircleProgressBar) view.findViewById(R.id.custom_progressBar);
            this.A1 = (LineChart) view.findViewById(R.id.lineChart);
            this.D1 = (TextView) view.findViewById(R.id.tvPing);
            this.E1 = (ImageView) view.findViewById(R.id.globe);
            this.R0 = (RelativeLayout) view.findViewById(R.id.relaServer);
            this.S0 = (RelativeLayout) view.findViewById(R.id.relaNetwork);
            this.J1 = (TextView) view.findViewById(R.id.timeleft);
            this.K1 = (LinearLayout) view.findViewById(R.id.linearExpiry);
            this.L1 = (SmoothBottomBar) view.findViewById(R.id.bottomBar);
            this.M1 = (ImageView) view.findViewById(R.id.mainSpeedBoost);
            this.N1 = (ImageView) view.findViewById(R.id.mainActiveBoost);
            ImageView imageView = this.M1;
            int i3 = 4;
            if (imageView != null) {
                imageView.setOnClickListener(new yc0(this, i3));
            }
            RelativeLayout relativeLayout = this.R0;
            if (relativeLayout != null) {
                relativeLayout.setOnClickListener(new yc0(this, 5));
            }
            RelativeLayout relativeLayout2 = this.S0;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new yc0(this, 6));
            }
            MaterialButton materialButton = this.u1;
            if (materialButton != null) {
                materialButton.setOnClickListener(new yc0(this, 7));
            }
            TextView textView = this.a1;
            if (textView != null) {
                ConfigData configValue = e0().getConfigValue();
                if (configValue != null) {
                    str = configValue.getVersion();
                } else {
                    str = null;
                }
                textView.setText(str);
            }
            SwitchMaterial switchMaterial = this.h1;
            if (switchMaterial != null) {
                Lazy lazy = zq0.a;
                switchMaterial.setChecked(zq0.t());
            }
            SwitchMaterial switchMaterial2 = this.h1;
            int i4 = 2;
            if (switchMaterial2 != null) {
                switchMaterial2.setOnCheckedChangeListener(new e4(this, i4));
            }
            MaterialButton materialButton2 = this.P0;
            if (materialButton2 != null) {
                materialButton2.setOnClickListener(new a(this, i2));
            }
            ConfigData configValue2 = e0().getConfigValue();
            configValue2.getClass();
            if (!configValue2.isTimerOn() && (cardView = this.c1) != null) {
                cardView.setVisibility(8);
            }
            ConfigData configValue3 = e0().getConfigValue();
            configValue3.getClass();
            Integer timetoadd = configValue3.getTimetoadd();
            if (timetoadd != null) {
                i = timetoadd.intValue();
            } else {
                i = 2;
            }
            this.w1 = i;
            MaterialButton materialButton3 = this.u1;
            if (materialButton3 != null) {
                materialButton3.setText("Add " + i + " Hrs");
            }
            B0();
            this.x1 = System.currentTimeMillis();
            if (!this.P1) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("COUNTDOWN_UPDATE");
                intentFilter.addAction("COUNTDOWN_FINISH");
                int i5 = Build.VERSION.SDK_INT;
                r6 r6Var = this.W0;
                if (i5 >= 33) {
                    M().registerReceiver(r6Var, intentFilter, 2);
                } else {
                    M().registerReceiver(r6Var, intentFilter);
                }
                this.P1 = true;
                Lazy lazy2 = zq0.a;
                String w0 = w0(zq0.B());
                TextView textView2 = this.b1;
                if (textView2 != null) {
                    textView2.setText(w0);
                }
            }
            kotlinx.coroutines.c.d(this.O1, null, null, new HomeFragment$loadAllData$1(this, null), 3);
            Context f = f();
            int i6 = 0;
            if (f != null && (d = d()) != null) {
                GoogleMobileAdsConsentManager a = GoogleMobileAdsConsentManager.b.a(f);
                this.l1 = a;
                a.a(d, new ad0(this));
                GoogleMobileAdsConsentManager googleMobileAdsConsentManager = this.l1;
                if (googleMobileAdsConsentManager != null) {
                    if (googleMobileAdsConsentManager.a.canRequestAds()) {
                        this.m1.set(true);
                        AtomicBoolean atomicBoolean = this.n1;
                        if (!atomicBoolean.getAndSet(true)) {
                            Context f3 = f();
                            if (f3 == null) {
                                atomicBoolean.set(false);
                            } else {
                                MobileAds.initialize(f3, new Object());
                            }
                        }
                        o0();
                        l0(f);
                        k0();
                    }
                } else {
                    yg0.N("googleMobileAdsConsentManager");
                    throw null;
                }
            }
            kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$onViewCreated$1(this, null), 3);
            this.G1 = new ConfigUpdate(this);
            SmoothBottomBar smoothBottomBar = this.L1;
            if (smoothBottomBar != null) {
                smoothBottomBar.setOnItemSelected(new tc0(this, i6));
            }
            SmoothBottomBar smoothBottomBar2 = this.L1;
            if (smoothBottomBar2 != null) {
                smoothBottomBar2.setOnItemReselected(new tc0(this, i3));
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x004a, code lost:
    
        if (r3.equals("Http/Ws Proxy") == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x00d1, code lost:
    
        if (r3.equals("Direct + Payload") == false) goto L59;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0032. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x037d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02cc  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x030d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void H0() {
        /*
            Method dump skipped, instructions count: 1038
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.H0():void");
    }

    public final void I0() {
        if (o() && e0().getConfigValue() != null) {
            ConfigData configValue = e0().getConfigValue();
            configValue.getClass();
            if (configValue.isTimerOn()) {
                LifecycleCoroutineScopeImpl a = m.a(l());
                lv lvVar = oy.a;
                kotlinx.coroutines.c.d(a, bn0.a, null, new HomeFragment$startTimer$1(this, null), 2);
            }
        }
    }

    public final void J0() {
        b0(true);
        this.T0 = false;
        zr.b(this.C1, null);
        CoreController coreController = com.v2ray.ang.service.b.a;
        com.v2ray.ang.service.b.g(L());
        if (SocksHttpService.isRunning) {
            TunnelManagerHelper.stopSocksHttp(L());
            SkStatus.updateStateString(SkStatus.SSH_DESCONECTADO, "Stopped");
        }
        if (SkStatus.isTunnelActive()) {
            TunnelManagerHelper.stopSocksHttp(L());
            SkStatus.updateStateString(SkStatus.SSH_DESCONECTADO, "Stopped");
        }
        StatisticsGraphData.getStatisticData().getDataTransferStats().stop();
        if (kotlin.text.g.o(g0(M()).toString(), "TunnelVpnService", false)) {
            Intent intent = new Intent(L(), (Class<?>) TunnelVpnService.class);
            intent.setAction("STOP");
            L().startService(intent);
        }
        InjectorService injectorService = this.d2;
        if (injectorService != null && InjectorService.isRunning) {
            injectorService.stopInjector();
        }
        L().stopService(new Intent(L(), (Class<?>) InjectorService.class));
        L0(true);
        a0();
        if (this.d2 != null) {
            M().unbindService(this.e2);
            this.d2 = null;
        }
        K0();
        Job job = this.d1;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
        A0("Disconnected");
    }

    public final void K0() {
        Context f = f();
        if (f != null) {
            M().stopService(new Intent(f, (Class<?>) CountdownService.class));
        }
    }

    public final void L0(boolean z) {
        Context M = M();
        Intent putExtra = new Intent(M(), (Class<?>) OpenVPNService.class).setAction(OpenVPNService.ACTION_DISCONNECT).putExtra("net.openvpn.openvpn.STOP", z);
        putExtra.getClass();
        M.startService(putExtra);
    }

    public final void M0() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(M(), R.style.BottomSheetTheme);
        View inflate = g().inflate(R.layout.update_dialog, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        Button button = (Button) inflate.findViewById(R.id.btnCleardata);
        Button button2 = (Button) inflate.findViewById(R.id.btnOnlineUpdate);
        final int i = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: wc0
            public final /* synthetic */ HomeFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i2 = i;
                BottomSheetDialog bottomSheetDialog2 = bottomSheetDialog;
                HomeFragment homeFragment = this.b;
                switch (i2) {
                    case 0:
                        int i3 = HomeFragment.f2;
                        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(homeFragment.M());
                        AlertController.AlertParams alertParams = materialAlertDialogBuilder.a;
                        alertParams.c = R.mipmap.ic_launcher_round;
                        alertParams.e = "Clear Setting/data";
                        alertParams.g = "Are you sure you want to reset all the data?";
                        materialAlertDialogBuilder.h("Yes", new zc0(homeFragment, 2));
                        materialAlertDialogBuilder.g("No", null);
                        materialAlertDialogBuilder.f();
                        bottomSheetDialog2.dismiss();
                        return;
                    default:
                        int i4 = HomeFragment.f2;
                        qf3.L(homeFragment.M(), "Checking Updates");
                        bottomSheetDialog2.dismiss();
                        return;
                }
            }
        });
        final int i2 = 1;
        button2.setOnClickListener(new View.OnClickListener(this) { // from class: wc0
            public final /* synthetic */ HomeFragment b;

            {
                this.b = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i22 = i2;
                BottomSheetDialog bottomSheetDialog2 = bottomSheetDialog;
                HomeFragment homeFragment = this.b;
                switch (i22) {
                    case 0:
                        int i3 = HomeFragment.f2;
                        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(homeFragment.M());
                        AlertController.AlertParams alertParams = materialAlertDialogBuilder.a;
                        alertParams.c = R.mipmap.ic_launcher_round;
                        alertParams.e = "Clear Setting/data";
                        alertParams.g = "Are you sure you want to reset all the data?";
                        materialAlertDialogBuilder.h("Yes", new zc0(homeFragment, 2));
                        materialAlertDialogBuilder.g("No", null);
                        materialAlertDialogBuilder.f();
                        bottomSheetDialog2.dismiss();
                        return;
                    default:
                        int i4 = HomeFragment.f2;
                        qf3.L(homeFragment.M(), "Checking Updates");
                        bottomSheetDialog2.dismiss();
                        return;
                }
            }
        });
        bottomSheetDialog.show();
    }

    public final boolean W() {
        GoogleMobileAdsConsentManager googleMobileAdsConsentManager;
        if (this.m1.get() && (googleMobileAdsConsentManager = this.l1) != null && googleMobileAdsConsentManager.a.canRequestAds()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0271  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X() {
        /*
            Method dump skipped, instructions count: 972
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.X():void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x05e5  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0607  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0612  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x061e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0624  */
    /* JADX WARN: Type inference failed for: r12v16, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v18, types: [T, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r12v20, types: [T, java.lang.Object, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y() {
        /*
            Method dump skipped, instructions count: 1882
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.Y():void");
    }

    public final void Z() {
        if (!this.W1) {
            M().bindService(new Intent(M(), (Class<?>) OpenVPNService.class).setAction(OpenVPNService.ACTION_BIND), this.T1, 65);
            this.W1 = true;
        }
    }

    public final void a0() {
        OpenVPNService openVPNService = this.Y1;
        if (openVPNService != null && this.W1) {
            if (this.S1) {
                openVPNService.client_detach(this);
                this.S1 = false;
            }
            try {
                M().unbindService(this.T1);
            } catch (IllegalArgumentException unused) {
            }
            this.Y1 = null;
            this.W1 = false;
        }
    }

    public final void b0(boolean z) {
        NetworkMonitor networkMonitor = this.g1;
        if (z) {
            if (networkMonitor != null) {
                networkMonitor.h.cancel((CancellationException) null);
            }
            this.g1 = null;
            MaterialButton materialButton = this.P0;
            if (materialButton != null) {
                materialButton.setText("Start");
            }
            RelativeLayout relativeLayout = this.S0;
            if (relativeLayout != null) {
                relativeLayout.setEnabled(true);
            }
            RelativeLayout relativeLayout2 = this.R0;
            if (relativeLayout2 != null) {
                relativeLayout2.setEnabled(true);
            }
            SwitchMaterial switchMaterial = this.h1;
            if (switchMaterial != null) {
                switchMaterial.setEnabled(true);
            }
            CircleProgressBar circleProgressBar = this.z1;
            if (circleProgressBar != null) {
                circleProgressBar.setProgressWithAnimation(0.0f);
                return;
            }
            return;
        }
        if (networkMonitor == null) {
            Context f = f();
            if (f != null) {
                networkMonitor = new NetworkMonitor(f, this.A1);
                this.g1 = networkMonitor;
            } else {
                return;
            }
        }
        NetworkMonitor.a(networkMonitor);
        MaterialButton materialButton2 = this.P0;
        if (materialButton2 != null) {
            materialButton2.setText("Stop");
        }
        RelativeLayout relativeLayout3 = this.S0;
        if (relativeLayout3 != null) {
            relativeLayout3.setEnabled(false);
        }
        RelativeLayout relativeLayout4 = this.R0;
        if (relativeLayout4 != null) {
            relativeLayout4.setEnabled(false);
        }
        SwitchMaterial switchMaterial2 = this.h1;
        if (switchMaterial2 != null) {
            switchMaterial2.setEnabled(false);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0042, code lost:
    
        if (kotlin.text.g.o(r1, "Trojan", false) == true) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList c0(java.util.List r9, java.lang.String r10, java.util.List r11) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.c0(java.util.List, java.lang.String, java.util.List):java.util.ArrayList");
    }

    public final ConfigViewModel e0() {
        return (ConfigViewModel) this.e1.getValue();
    }

    @Override // com.sandok.tunnel.service.OpenVPNService.EventReceiver
    public final void event(OpenVPNService.EventMsg eventMsg) {
        eventMsg.getClass();
        h0();
        u0(eventMsg);
    }

    public final MainViewModel f0() {
        return (MainViewModel) this.f1.getValue();
    }

    @Override // com.sandok.tunnel.service.OpenVPNService.EventReceiver
    public final PendingIntent get_configure_intent(int i) {
        int i2;
        if (Build.VERSION.SDK_INT >= 31) {
            i2 = 301989888;
        } else {
            i2 = 268435456;
        }
        return PendingIntent.getActivity(M(), i, L().getIntent(), i2);
    }

    public final boolean h0() {
        OpenVPNService openVPNService = this.Y1;
        if (openVPNService != null) {
            return openVPNService.is_active();
        }
        return false;
    }

    public final void i0(String str) {
        if (str == null) {
            ConfigData configValue = e0().getConfigValue();
            if (configValue != null) {
                str = configValue.getTelegram();
            } else {
                str = null;
            }
        }
        if (str != null && !kotlin.text.g.B(str)) {
            if (kotlin.text.g.R(str, "@", false)) {
                str = kotlin.text.g.I(str, "@");
            } else if (kotlin.text.g.R(str, "http://", false) || kotlin.text.g.R(str, "https://", false)) {
                str = kotlin.text.g.W(kotlin.text.g.V(str, "/"), "?");
            }
            String obj = kotlin.text.g.c0(str).toString();
            if (kotlin.text.g.B(obj)) {
                qf3.N(M(), "Invalid Telegram username");
                return;
            }
            try {
                U(new Intent("android.intent.action.VIEW", Uri.parse("tg://resolve?domain=".concat(obj))));
                return;
            } catch (ActivityNotFoundException unused) {
                U(new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/".concat(obj))));
                return;
            }
        }
        qf3.N(M(), "No Telegram link configured");
    }

    public final void j0() {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(M(), R.style.BottomSheetTheme);
        View inflate = g().inflate(R.layout.joinus_dialog, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        bottomSheetDialog.show();
        ImageView imageView = (ImageView) inflate.findViewById(R.id.imgTele);
        ImageView imageView2 = (ImageView) inflate.findViewById(R.id.imgWhatsApp);
        ImageView imageView3 = (ImageView) inflate.findViewById(R.id.imgFacebook);
        imageView.setOnClickListener(new yc0(this, 0));
        imageView2.setOnClickListener(new yc0(this, 1));
        imageView3.setOnClickListener(new yc0(this, 2));
    }

    public final void k0() {
        LifecycleOwner lifecycleOwner;
        if (W() && !this.Q1 && !this.r1 && (lifecycleOwner = (LifecycleOwner) this.Q.d()) != null) {
            LifecycleCoroutineScopeImpl a = m.a(lifecycleOwner);
            lv lvVar = oy.a;
            kotlinx.coroutines.c.d(a, bn0.a, null, new HomeFragment$loadBannerAds$1(this, null), 2);
        }
    }

    public final void l0(Context context) {
        if (W() && !this.q1 && this.F1 == null) {
            this.q1 = true;
            AdRequest build = new AdRequest.Builder().build();
            build.getClass();
            InterstitialAd.load(context, "ca-app-pub-7120795588295806/7170980403", build, new InterstitialAdLoadCallback() { // from class: com.v2ray.ang.ui.HomeFragment$loadInterstitial$1
                @Override // com.google.android.gms.ads.AdLoadCallback
                public final void onAdFailedToLoad(LoadAdError loadAdError) {
                    loadAdError.getClass();
                    HomeFragment homeFragment = HomeFragment.this;
                    homeFragment.q1 = false;
                    homeFragment.F1 = null;
                    loadAdError.getCode();
                    loadAdError.getDomain();
                    loadAdError.getMessage();
                }

                @Override // com.google.android.gms.ads.AdLoadCallback
                public final void onAdLoaded(InterstitialAd interstitialAd) {
                    InterstitialAd interstitialAd2 = interstitialAd;
                    interstitialAd2.getClass();
                    HomeFragment homeFragment = HomeFragment.this;
                    homeFragment.q1 = false;
                    homeFragment.F1 = interstitialAd2;
                }
            });
        }
    }

    public final void m0() {
        Object obj;
        List list = this.H0;
        if (list != null) {
            list.size();
            Lazy lazy = zq0.a;
            String C = zq0.C();
            if (C == null || C.length() == 0) {
                List list2 = this.H0;
                if (list2 != null) {
                    if (!list2.isEmpty()) {
                        List list3 = this.H0;
                        if (list3 != null) {
                            C = ((NetworkList) kotlin.collections.c.r(list3)).getName();
                            zq0.I(C);
                        } else {
                            yg0.N("networkList");
                            throw null;
                        }
                    }
                } else {
                    yg0.N("networkList");
                    throw null;
                }
            }
            List list4 = this.H0;
            if (list4 != null) {
                Iterator it = list4.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        if (yg0.a(((NetworkList) obj).getName(), C)) {
                            break;
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                NetworkList networkList = (NetworkList) obj;
                if (networkList == null) {
                    List list5 = this.H0;
                    if (list5 != null) {
                        networkList = (NetworkList) kotlin.collections.c.r(list5);
                        Lazy lazy2 = zq0.a;
                        zq0.I(networkList.getName());
                    } else {
                        yg0.N("networkList");
                        throw null;
                    }
                }
                this.Y = networkList.getName();
                networkList.getInfo();
                this.Z = networkList.getPayload();
                this.a0 = networkList.getProxyPort();
                this.b0 = networkList.getSNI();
                this.c0 = networkList.getDefaultProxy();
                this.d0 = networkList.getCustomProxy();
                this.e0 = networkList.getV2rayConfig();
                this.f0 = networkList.getTunnelType();
                this.g0 = networkList.getBugDNS();
                this.h0 = networkList.getSafeURI();
                this.i0 = networkList.getV2rayAddress();
                this.j0 = networkList.getV2rayPort();
                this.k0 = networkList.getV2rayHost();
                this.l0 = networkList.getV2ray_is_SNI();
                this.m0 = networkList.getV2raySNI();
                networkList.getV2rayServerNeed();
                this.n0 = networkList.getV2rayNetwork();
                this.o0 = networkList.getRoute();
                networkList.getIcon();
                this.p0 = networkList.getVinJect();
                this.H1 = networkList.getV2rayinSecure();
                Lazy lazy3 = zq0.a;
                String str = this.f0;
                if (str == null) {
                    str = "Http/Ws Proxy";
                }
                zq0.H(str);
                return;
            }
            yg0.N("networkList");
            throw null;
        }
        yg0.N("networkList");
        throw null;
    }

    public final void n0() {
        String replace;
        Connection[] connectionArr;
        String defaultOVPNCert;
        String replace2;
        try {
            File[] listFiles = L().getFilesDir().listFiles();
            if (listFiles != null) {
                for (File file : listFiles) {
                    String absolutePath = file.getAbsolutePath();
                    absolutePath.getClass();
                    String lowerCase = absolutePath.toLowerCase(Locale.ROOT);
                    lowerCase.getClass();
                    if (kotlin.text.g.u(lowerCase, ".ovpn", false)) {
                        file.delete();
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        List<ServerList> list = this.G0;
        if (list != null) {
            for (ServerList serverList : list) {
                if (kotlin.text.g.o(serverList.getServerProtocol(), "OVPN", false)) {
                    String obj = kotlin.text.g.d0(serverList.getName()).toString();
                    String openVPNTCPPort = serverList.getOpenVPNTCPPort();
                    if (!kotlin.text.g.w(serverList.getServerProtocol(), "Random", true) && openVPNTCPPort != null && openVPNTCPPort.length() != 0) {
                        if (serverList.getDefault_cert()) {
                            ConfigData configValue = e0().getConfigValue();
                            if (configValue != null && (defaultOVPNCert = configValue.getDefaultOVPNCert()) != null && (replace2 = new Regex("(?m)^\\s*proto\\s+tcp4-client\\s*$").replace(defaultOVPNCert, "proto tcp-client")) != null) {
                                replace = new Regex("(?m)^\\s*proto\\s+udp4\\s*$").replace(replace2, "proto udp");
                            } else {
                                replace = null;
                            }
                        } else {
                            Hometab.Companion companion = Hometab.n;
                            String customCertificate = serverList.getCustomCertificate();
                            companion.getClass();
                            replace = new Regex("(?m)^\\s*proto\\s+udp4\\s*$").replace(new Regex("(?m)^\\s*proto\\s+tcp4-client\\s*$").replace(Hometab.Companion.a(customCertificate), "proto tcp-client"), "proto udp");
                        }
                        if (replace != null && !kotlin.text.g.B(replace)) {
                            StringReader stringReader = new StringReader(replace);
                            ConfigParser configParser = new ConfigParser();
                            try {
                                configParser.parseConfig(stringReader);
                                VpnProfile convertProfile = configParser.convertProfile();
                                if (convertProfile != null && (connectionArr = convertProfile.mConnections) != null && connectionArr.length != 0) {
                                    Connection connection = connectionArr[0];
                                    connection.mServerName = "1.1.1.1";
                                    connection.mServerPort = openVPNTCPPort;
                                    connection.mUseCustomConfig = true;
                                    String str = URLEncoder.encode(obj) + ".ovpn";
                                    String configFile = convertProfile.getConfigFile(L(), true);
                                    FileOutputStream fileOutputStream = new FileOutputStream(new File(L().getFilesDir(), str));
                                    configFile.getClass();
                                    byte[] bytes = configFile.getBytes(xm.a);
                                    bytes.getClass();
                                    fileOutputStream.write(bytes);
                                    fileOutputStream.flush();
                                    fileOutputStream.close();
                                    OpenVPNService openVPNService = this.Y1;
                                    if (openVPNService != null) {
                                        openVPNService.refresh_profile_list();
                                    }
                                }
                            } catch (Exception e2) {
                                e2.getMessage();
                            }
                        }
                    }
                }
            }
            return;
        }
        yg0.N("serverList");
        throw null;
    }

    @Override // com.vpn.sandok.ultrasshservice.logger.SkStatus.LogListener
    public final void newLog(LogItem logItem) {
        logItem.getClass();
        if (logItem.getMessage() != null) {
            String message = logItem.getMessage();
            message.getClass();
            if (kotlin.text.g.o(message, "Failed to authenticate", false)) {
                kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$newLog$1(this, null), 3);
            }
            String message2 = logItem.getMessage();
            message2.getClass();
            if (kotlin.text.g.o(message2, "Invalid UDP Server", false)) {
                kotlinx.coroutines.c.d(m.a(this), null, null, new HomeFragment$newLog$2(this, null), 3);
            }
        }
        logItem.getLogtime();
        logItem.getMessage();
        Objects.toString(logItem.getLogLevel());
    }

    public final void o0() {
        Context f;
        if (W() && !this.p1 && (f = f()) != null) {
            MaterialButton materialButton = this.u1;
            if (materialButton != null) {
                materialButton.setVisibility(8);
            }
            ProgressBar progressBar = this.v1;
            if (progressBar != null) {
                progressBar.setVisibility(0);
            }
            if (this.o1 == null) {
                this.p1 = true;
                AdRequest build = new AdRequest.Builder().build();
                build.getClass();
                RewardedAd.load(f, "ca-app-pub-7120795588295806/2108418468", build, new RewardedAdLoadCallback() { // from class: com.v2ray.ang.ui.HomeFragment$loadRewardedAd$1
                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public final void onAdFailedToLoad(LoadAdError loadAdError) {
                        loadAdError.getClass();
                        HomeFragment homeFragment = HomeFragment.this;
                        homeFragment.o1 = null;
                        homeFragment.p1 = false;
                        MaterialButton materialButton2 = homeFragment.u1;
                        if (materialButton2 != null) {
                            materialButton2.setVisibility(0);
                        }
                        ProgressBar progressBar2 = homeFragment.v1;
                        if (progressBar2 != null) {
                            progressBar2.setVisibility(8);
                        }
                        loadAdError.getCode();
                        loadAdError.getDomain();
                        loadAdError.getMessage();
                    }

                    @Override // com.google.android.gms.ads.AdLoadCallback
                    public final void onAdLoaded(RewardedAd rewardedAd) {
                        RewardedAd rewardedAd2 = rewardedAd;
                        rewardedAd2.getClass();
                        HomeFragment homeFragment = HomeFragment.this;
                        homeFragment.o1 = rewardedAd2;
                        homeFragment.p1 = false;
                        MaterialButton materialButton2 = homeFragment.u1;
                        if (materialButton2 != null) {
                            materialButton2.setVisibility(0);
                        }
                        ProgressBar progressBar2 = homeFragment.v1;
                        if (progressBar2 != null) {
                            progressBar2.setVisibility(8);
                        }
                    }
                });
            }
        }
    }

    @Override // com.v2ray.ang.adapter.NetworkAdapter.NetworkItemClickListener
    public final void onNetworkClick(int i, String str) {
        str.getClass();
        androidx.appcompat.app.g gVar = this.I0;
        if (gVar != null) {
            gVar.dismiss();
        }
        Lazy lazy = zq0.a;
        zq0.H(str);
        m0();
        z0();
    }

    @Override // com.v2ray.ang.adapter.ServerAdapter.ServerItemClickListener
    public final void onServerClick(int i) {
        androidx.appcompat.app.g gVar = this.I0;
        if (gVar != null) {
            gVar.dismiss();
        }
        C0();
        p0();
    }

    @Override // com.v2ray.ang.util.ConfigUpdate.UpdateAvailable
    public final void onUpdateAvailable() {
        Toast.makeText(M(), "Config Updated", 0).show();
        y0();
        z0();
        ConfigData configValue = e0().getConfigValue();
        configValue.getClass();
        boolean isTimerOn = configValue.isTimerOn();
        CardView cardView = this.c1;
        if (!isTimerOn) {
            if (cardView != null) {
                cardView.setVisibility(8);
            }
        } else if (cardView != null) {
            cardView.setVisibility(0);
        }
        TextView textView = this.a1;
        if (textView != null) {
            Lazy lazy = zq0.a;
            String d = zq0.u().d("CurrentConfigVersion");
            if (d == null) {
                d = "1.01";
            }
            textView.setText(d);
        }
    }

    public final void p0() {
        List list;
        Lazy lazy = zq0.a;
        String d = zq0.u().d("Proto");
        List list2 = this.G0;
        if (list2 != null) {
            list2.size();
            String D = zq0.D();
            if (D == null || D.length() == 0) {
                List list3 = this.G0;
                if (list3 != null) {
                    if (!list3.isEmpty()) {
                        zq0.J("Auto Select Server");
                        D = "Auto Select Server";
                    }
                } else {
                    yg0.N("serverList");
                    throw null;
                }
            }
            String C = zq0.C();
            Protocol.a.getClass();
            Protocol.Companion.a(d);
            List list4 = this.G0;
            if (list4 != null) {
                List list5 = this.H0;
                if (list5 != null) {
                    ArrayList c0 = c0(list4, C, list5);
                    if (yg0.a(D, "Auto Select Server")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = c0.iterator();
                        while (it.hasNext()) {
                            Object next = it.next();
                            if (!kotlin.text.g.o(((ServerList) next).getName(), "Auto Select Server", true)) {
                                arrayList.add(next);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            list = kotlin.collections.c.z(kotlin.collections.c.F(arrayList, Random.INSTANCE));
                        } else {
                            list = EmptyList.INSTANCE;
                        }
                    } else {
                        ArrayList arrayList2 = new ArrayList();
                        Iterator it2 = c0.iterator();
                        while (it2.hasNext()) {
                            Object next2 = it2.next();
                            if (yg0.a(((ServerList) next2).getName(), D)) {
                                arrayList2.add(next2);
                            }
                        }
                        list = arrayList2;
                    }
                    this.X1 = list;
                    Objects.toString(list);
                    ServerList serverList = (ServerList) kotlin.collections.c.s(this.X1);
                    if (serverList != null) {
                        this.q0 = kotlin.text.g.c0(serverList.getName()).toString();
                        serverList.getFlag();
                        this.r0 = serverList.getServerIPHost();
                        this.s0 = serverList.getServerType();
                        this.t0 = serverList.getServerProtocol();
                        this.u0 = serverList.getOpenVPNTCPPort();
                        serverList.getOpenVPNUdpPort();
                        this.v0 = serverList.getSSH_Port();
                        this.w0 = serverList.getSSLPort();
                        this.x0 = serverList.getIsdefUser();
                        this.y0 = serverList.getOVPNUser();
                        this.z0 = serverList.getOVPNPass();
                        this.A0 = serverList.getUDP_obfs();
                        this.B0 = serverList.getUDP_user();
                        serverList.getDefault_cert();
                        serverList.getCustomCertificate();
                        this.C0 = serverList.getSlowDNSHost();
                        this.D0 = serverList.getSlowDNSKey();
                        serverList.getV2rayUUID();
                        serverList.getV2rayPath();
                        this.E0 = serverList.getTrojanPass();
                        serverList.getV2rayProtocol();
                        return;
                    }
                    return;
                }
                yg0.N("networkList");
                throw null;
            }
            yg0.N("serverList");
            throw null;
        }
        yg0.N("serverList");
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.v2ray.ang.ui.HomeFragment.OVPNConfig q0() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.q0():com.v2ray.ang.ui.HomeFragment$OVPNConfig");
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r0() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.r0():void");
    }

    @Override // com.sandok.tunnel.service.InjectorService.InjectorListener
    public final void startOpenVPN() {
        OpenVPNService.ProfileList profileList;
        OpenVPNService.Profile profile;
        FragmentActivity d;
        OpenVPNService openVPNService = this.Y1;
        if (openVPNService == null || (profileList = openVPNService.get_profile_list()) == null) {
            profileList = null;
        }
        if (profileList == null || (profile = profileList.get_profile_by_name(this.q0)) == null) {
            profile = null;
        }
        d dVar = new d(this);
        if (o() && d() != null && (d = d()) != null) {
            new Handler(d.getMainLooper());
            if (profile != null && profile.need_external_pki_alias()) {
                dVar.post_dispatch("DISABLE_CLIENT_CERT");
                if (o()) {
                    d.isFinishing();
                    return;
                }
                return;
            }
            dVar.post_dispatch(null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void t(Context context) {
        context.getClass();
        super.t(context);
        this.B1 = new WeakReference(context);
    }

    public final void u0(OpenVPNService.EventMsg eventMsg) {
        long currentTimeMillis = System.currentTimeMillis();
        int i = eventMsg.res_id;
        if (i == this.a2 && currentTimeMillis - this.Z1 < 200) {
            j().getString(i).getClass();
            return;
        }
        this.Z1 = currentTimeMillis;
        this.a2 = i;
        eventMsg.is_reflected(this);
        int i2 = eventMsg.res_id;
        if (i2 != R.string.auth_failed) {
            if (i2 != R.string.connected) {
                if (i2 == R.string.info_msg) {
                    String str = eventMsg.info;
                    str.getClass();
                    if (kotlin.text.g.R(str, "OPEN_URL:", false)) {
                        String str2 = eventMsg.info;
                        str2.getClass();
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str2.substring(9)));
                        intent.putExtra("com.android.browser.application_id", M().getPackageName());
                        if (intent.resolveActivity(M().getPackageManager()) != null) {
                            U(intent);
                        }
                    }
                }
            } else {
                I0();
            }
        } else {
            J0();
            qf3.L(M(), "Invalid Account");
        }
        if (eventMsg.priority >= 1) {
            if (eventMsg.res_id == R.string.connected) {
                ClientAPI_ConnectionInfo clientAPI_ConnectionInfo = eventMsg.conn_info;
                if (clientAPI_ConnectionInfo != null) {
                    clientAPI_ConnectionInfo.toString();
                }
                E0(eventMsg.res_id);
                return;
            }
            String str3 = eventMsg.info;
            str3.getClass();
            int length = str3.length();
            int i3 = eventMsg.res_id;
            if (length > 0) {
                String string = j().getString(i3);
                string.getClass();
                String.format("%s : %s", Arrays.copyOf(new Object[]{string, eventMsg.info}, 2));
                String string2 = j().getString(eventMsg.res_id);
                string2.getClass();
                if (kotlin.text.g.o(string2, "Server certificate verification failed", false)) {
                    qf3.L(M(), "Invalid Certificate");
                }
                String string3 = j().getString(eventMsg.res_id);
                string3.getClass();
                A0(string3);
                return;
            }
            E0(i3);
        }
    }

    @Override // com.vpn.sandok.ultrasshservice.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        str.getClass();
        str2.getClass();
        connectionStatus.getClass();
        LifecycleCoroutineScopeImpl a = m.a(this);
        lv lvVar = oy.a;
        kotlinx.coroutines.c.d(a, bn0.a, null, new HomeFragment$updateState$1(this, str2, null), 2);
        connectionStatus.toString();
    }

    @Override // androidx.fragment.app.Fragment
    public final void x() {
        this.D = true;
    }

    public final void x0() {
        Window window;
        View inflate = g().inflate(R.layout.server_list, (ViewGroup) null);
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(M(), R.style.FullScreenDialog);
        materialAlertDialogBuilder.a.r = inflate;
        androidx.appcompat.app.g a = materialAlertDialogBuilder.a();
        this.I0 = a;
        a.show();
        androidx.appcompat.app.g gVar = this.I0;
        if (gVar != null && (window = gVar.getWindow()) != null) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        SearchView searchView = (SearchView) inflate.findViewById(R.id.svServer);
        RecyclerView recyclerView = (RecyclerView) inflate.findViewById(R.id.rvNetwork);
        EditText editText = (EditText) searchView.findViewById(R.id.search_src_text);
        editText.setTextColor(M().getColor(R.color.colorAccent));
        editText.setHintTextColor(M().getColor(R.color.colorAccent));
        List list = this.G0;
        if (list != null) {
            ArrayList arrayList = new ArrayList(list);
            final ServerAdapter serverAdapter = new ServerAdapter(M(), L(), new ArrayList(), this);
            recyclerView.setLayoutManager(new LinearLayoutManager(M()));
            recyclerView.setAdapter(serverAdapter);
            recyclerView.setHasFixedSize(true);
            recyclerView.setItemViewCacheSize(20);
            Protocol.Companion companion = Protocol.a;
            Lazy lazy = zq0.a;
            String d = zq0.u().d("Proto");
            companion.getClass();
            Protocol.Companion.a(d);
            String C = zq0.C();
            List list2 = this.H0;
            if (list2 != null) {
                ArrayList c0 = c0(arrayList, C, list2);
                serverAdapter.h.b(c0);
                searchView.clearFocus();
                searchView.setOnQueryTextListener(new nd0(this, c0, serverAdapter));
                androidx.appcompat.app.g gVar2 = this.I0;
                if (gVar2 != null) {
                    gVar2.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: vc0
                        @Override // android.content.DialogInterface.OnDismissListener
                        public final void onDismiss(DialogInterface dialogInterface) {
                            int i = HomeFragment.f2;
                            ServerAdapter.this.i.clear();
                        }
                    });
                    return;
                }
                return;
            }
            yg0.N("networkList");
            throw null;
        }
        yg0.N("serverList");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void y() {
        this.D = true;
        zr.b(this.O1, null);
        this.J0 = null;
        this.K0 = null;
        this.L0 = null;
        this.M0 = null;
        this.N0 = null;
        this.O0 = null;
        this.P0 = null;
        this.R0 = null;
        this.S0 = null;
        this.X0 = null;
        this.Y0 = null;
        this.Z0 = null;
        this.a1 = null;
        this.b1 = null;
        this.c1 = null;
        this.h1 = null;
        this.u1 = null;
        this.v1 = null;
        this.z1 = null;
        this.A1 = null;
        androidx.appcompat.app.g gVar = this.I0;
        if (gVar != null) {
            gVar.dismiss();
        }
        this.I0 = null;
        this.o1 = null;
        this.F1 = null;
        Job job = this.s1;
        if (job != null) {
            job.cancel((CancellationException) null);
        }
        this.s1 = null;
        AdView adView = this.j1;
        if (adView != null) {
            adView.destroy();
        }
        this.j1 = null;
        FrameLayout frameLayout = this.k1;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
        this.k1 = null;
        this.Q1 = false;
        this.r1 = false;
        Job job2 = this.d1;
        if (job2 != null) {
            job2.cancel((CancellationException) null);
        }
        this.d1 = null;
        NetworkMonitor networkMonitor = this.g1;
        if (networkMonitor != null) {
            networkMonitor.h.cancel((CancellationException) null);
        }
        this.g1 = null;
        if (this.P1) {
            try {
                M().unregisterReceiver(this.W0);
                this.P1 = false;
            } catch (IllegalArgumentException unused) {
            }
        }
        a0();
        if (this.d2 != null) {
            M().unbindService(this.e2);
            this.d2 = null;
        }
        WeakReference weakReference = this.B1;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.B1 = null;
        zr.b(this.C1, null);
        ConfigUpdate configUpdate = this.G1;
        if (configUpdate != null) {
            zr.b(configUpdate.c, null);
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:1|(3:2|3|4)|(4:9|10|11|(5:61|62|63|64|65)(7:15|(2:17|(1:19))(3:45|(1:47)(1:60)|(3:49|50|51))|20|(1:22)(1:44)|(3:33|34|35)|24|(2:26|(1:28)(1:30))(2:31|32)))|71|72|73|74|10|11|(1:13)|61|62|63|64|65|(4:(1:57)|(0)|(1:80)|(1:41))) */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01d7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01d8, code lost:
    
        r0 = r0.getMessage();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01dc, code lost:
    
        if (r0 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01de, code lost:
    
        r0 = "Unknown error";
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean y0() {
        /*
            Method dump skipped, instructions count: 519
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.y0():boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
    
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x003e, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0072, code lost:
    
        if (r0 != null) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
    
        if (r0 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void z0() {
        /*
            r5 = this;
            kotlin.Lazy r0 = defpackage.zq0.a
            java.lang.String r0 = defpackage.zq0.C()
            com.v2ray.ang.helper.Protocol$Companion r1 = com.v2ray.ang.helper.Protocol.a
            com.tencent.mmkv.MMKV r2 = defpackage.zq0.u()
            java.lang.String r3 = "Proto"
            java.lang.String r2 = r2.d(r3)
            r1.getClass()
            com.v2ray.ang.helper.Protocol r1 = com.v2ray.ang.helper.Protocol.Companion.a(r2)
            java.util.List r2 = r5.G0
            r3 = 0
            if (r2 == 0) goto L97
            java.util.List r4 = r5.H0
            if (r4 == 0) goto L91
            java.util.ArrayList r0 = r5.c0(r2, r0, r4)
            com.v2ray.ang.helper.e r2 = com.v2ray.ang.helper.e.b
            boolean r2 = defpackage.yg0.a(r1, r2)
            java.lang.String r3 = "Auto Select Server"
            if (r2 == 0) goto L40
            java.lang.Object r0 = kotlin.collections.c.s(r0)
            com.v2ray.ang.viewmodel.ServerList r0 = (com.v2ray.ang.viewmodel.ServerList) r0
            if (r0 == 0) goto L84
            java.lang.String r0 = r0.getName()
            if (r0 == 0) goto L84
        L3e:
            r3 = r0
            goto L84
        L40:
            com.v2ray.ang.helper.a r2 = com.v2ray.ang.helper.a.b
            boolean r2 = defpackage.yg0.a(r1, r2)
            if (r2 != 0) goto L75
            com.v2ray.ang.helper.b r2 = com.v2ray.ang.helper.b.b
            boolean r2 = defpackage.yg0.a(r1, r2)
            if (r2 == 0) goto L51
            goto L75
        L51:
            com.v2ray.ang.helper.d r2 = com.v2ray.ang.helper.d.b
            boolean r2 = defpackage.yg0.a(r1, r2)
            if (r2 != 0) goto L66
            com.v2ray.ang.helper.c r2 = com.v2ray.ang.helper.c.b
            boolean r1 = defpackage.yg0.a(r1, r2)
            if (r1 == 0) goto L62
            goto L66
        L62:
            defpackage.p60.b()
            return
        L66:
            java.lang.Object r0 = kotlin.collections.c.s(r0)
            com.v2ray.ang.viewmodel.ServerList r0 = (com.v2ray.ang.viewmodel.ServerList) r0
            if (r0 == 0) goto L84
            java.lang.String r0 = r0.getName()
            if (r0 == 0) goto L84
            goto L3e
        L75:
            java.lang.Object r0 = kotlin.collections.c.s(r0)
            com.v2ray.ang.viewmodel.ServerList r0 = (com.v2ray.ang.viewmodel.ServerList) r0
            if (r0 == 0) goto L84
            java.lang.String r0 = r0.getName()
            if (r0 == 0) goto L84
            goto L3e
        L84:
            defpackage.zq0.J(r3)
            r5.C0()
            r5.m0()
            r5.p0()
            return
        L91:
            java.lang.String r5 = "networkList"
            defpackage.yg0.N(r5)
            throw r3
        L97:
            java.lang.String r5 = "serverList"
            defpackage.yg0.N(r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.v2ray.ang.ui.HomeFragment.z0():void");
    }

    @Override // com.vpn.sandok.ultrasshservice.logger.SkStatus.LogListener
    public final void onClear() {
    }

    @Override // com.sandok.tunnel.service.OpenVPNService.EventReceiver
    public final void log(OpenVPNService.LogMsg logMsg) {
    }
}
