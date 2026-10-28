package prince.dastan.vpn.activities;

import ads_mobile_sdk.cf1;
import ads_mobile_sdk.dr2;
import ads_mobile_sdk.fb0;
import ads_mobile_sdk.gd0;
import ads_mobile_sdk.gt0;
import ads_mobile_sdk.m9;
import ads_mobile_sdk.md0;
import ads_mobile_sdk.n9;
import ads_mobile_sdk.ni1;
import ads_mobile_sdk.uc1;
import ads_mobile_sdk.vk;
import ads_mobile_sdk.xe1;
import ads_mobile_sdk.yl2;
import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.VpnService;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.os.Handler;
import android.os.StrictMode;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.consent_sdk.zza;
import com.google.android.gms.internal.consent_sdk.zzj;
import com.google.android.libraries.ads.mobile.sdk.banner.AdView;
import com.my.dialog.UpdateDialogHelper;
import dastan.prince.bdfreevpn.R;
import defpackage.A1;
import defpackage.AbstractC0641Yi;
import defpackage.AbstractC3131gc0;
import defpackage.AbstractC3623mn;
import defpackage.AbstractC3634my;
import defpackage.C0037Bb;
import defpackage.C0223If;
import defpackage.C0270Ka;
import defpackage.C0407Pi;
import defpackage.C0456Rf;
import defpackage.C0491So;
import defpackage.C0910cm;
import defpackage.C2853d6;
import defpackage.C2882dV;
import defpackage.C2924e2;
import defpackage.C2996ex;
import defpackage.C3004f2;
import defpackage.C3083g10;
import defpackage.C3228hp;
import defpackage.C3290ic;
import defpackage.C3393jw;
import defpackage.C3599mV;
import defpackage.C3986rO;
import defpackage.C4156ta;
import defpackage.C4227uS;
import defpackage.C4452xG;
import defpackage.C4489xl;
import defpackage.C4586z1;
import defpackage.CountDownTimerC3163h10;
import defpackage.DialogC4336vq;
import defpackage.DialogInterfaceOnClickListenerC3003f10;
import defpackage.DialogInterfaceOnClickListenerC4579yw;
import defpackage.F00;
import defpackage.InterfaceC0103Dp;
import defpackage.InterfaceC0142Fc;
import defpackage.InterfaceC0497Su;
import defpackage.InterfaceC0522Tt;
import defpackage.InterfaceC0644Yl;
import defpackage.InterfaceC3220hh;
import defpackage.InterfaceC3475ky;
import defpackage.J9;
import defpackage.Ke0;
import defpackage.L00;
import defpackage.M00;
import defpackage.M50;
import defpackage.Q3;
import defpackage.QH;
import defpackage.QQ;
import defpackage.RQ;
import defpackage.RunnableC0334Mn;
import defpackage.RunnableC3243i10;
import defpackage.RunnableC3320j1;
import defpackage.S1;
import defpackage.S50;
import defpackage.ServiceConnectionC3719o10;
import defpackage.T00;
import defpackage.TO;
import defpackage.U3;
import defpackage.V1;
import defpackage.V3;
import defpackage.VT;
import defpackage.ViewOnClickListenerC0848c10;
import defpackage.ViewOnTouchListenerC3543lm;
import defpackage.ViewOnTouchListenerC4212uD;
import defpackage.W00;
import defpackage.X00;
import defpackage.XE;
import defpackage.Y20;
import defpackage.ZT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import prince.dastan.vpn.service.FWPuncherService;
import prince.dastan.vpn.service.PsiphonDNSService;
import prince.dastan.vpn.service.SocksDNSService;
import prince.dastan.vpn.service.XRayDNSService;
import prince.dastan.vpn.service.vpn.TunnelManagerHelper;
import prince.dastan.vpn.service.vpn.TunnelUtils;
import prince.dastan.vpn.service.vpn.TunnelVpnManagerPsi;
import prince.dastan.vpn.service.vpn.logger.ConnectionStatus;
import prince.dastan.vpn.service.vpn.logger.SkStatus;
import prince.dastan.vpn.utils.PUtils;
import prince.dastan.vpn.view.CircleProgressBar;
import prince.dastan.vpn.view.RipplePulseLayout;
import smalihelper.heIran;
import xyz.hasnat.sweettoast.SweetToast;

/* loaded from: classes2.dex */
public class VPNClient extends a implements View.OnClickListener, AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, InterfaceC0497Su, TunnelVpnManagerPsi.SocksListener, SkStatus.StateListener, VT, M50, InterfaceC0103Dp, InterfaceC0644Yl {
    public static final String f0;
    public String A;
    public String B;
    public CountDownTimer C;
    public String D;
    public boolean E;
    public boolean F;
    public TextView G;
    public boolean H;
    public boolean I;
    public C0910cm J;
    public CheckBox K;
    public CheckBox L;
    public CheckBox M;
    public CheckBox N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public String T;
    public String U;
    public String V;
    public final String W;
    public final String X;
    public final String Y;
    public QQ Z;
    public ArrayList a0;
    public C2924e2 b0;
    public zzj c0;
    public RipplePulseLayout d;
    public boolean d0;
    public TextView e;
    public final A1 e0;
    public TextView f;
    public Button g;
    public Button h;
    public TextView i;
    public C2882dV j;
    public Spinner k;
    public TextView l;
    public C0223If m;
    public boolean n;
    public View o;
    public View p;
    public C3004f2 q;
    public ArrayList r;
    public int s;
    public TextView t;
    public TextView u;
    public EditText v;
    public EditText w;
    public Spinner x;
    public CircleProgressBar y;
    public InterfaceC3475ky z;

    static {
        Deobfuscator$BDNETVPN$app.getString(-72554214422411L);
        Deobfuscator$BDNETVPN$app.getString(-72597164095371L);
        Deobfuscator$BDNETVPN$app.getString(-72652998670219L);
        Deobfuscator$BDNETVPN$app.getString(-72708833245067L);
        f0 = Deobfuscator$BDNETVPN$app.getString(-72781847689099L);
    }

    public VPNClient() {
        this.c = new ServiceConnectionC3719o10(this, 0);
        this.E = false;
        this.F = false;
        this.H = false;
        this.I = false;
        this.T = Deobfuscator$BDNETVPN$app.getString(-44692761573259L);
        this.U = Deobfuscator$BDNETVPN$app.getString(-44697056540555L);
        this.V = Deobfuscator$BDNETVPN$app.getString(-44701351507851L);
        this.W = Deobfuscator$BDNETVPN$app.getString(-44705646475147L);
        this.X = Deobfuscator$BDNETVPN$app.getString(-44735711246219L);
        this.Y = Deobfuscator$BDNETVPN$app.getString(-44774365951883L);
        this.d0 = false;
        this.e0 = registerForActivityResult(new C4586z1(1), new C3290ic(this, 26));
    }

    public static boolean o(VPNClient vPNClient, String str, String str2) {
        vPNClient.getClass();
        String[] split = str.split(Deobfuscator$BDNETVPN$app.getString(-55335690532747L));
        String[] split2 = str2.split(Deobfuscator$BDNETVPN$app.getString(-55348575434635L));
        int i = 0;
        while (i < split.length && i < split2.length && split[i].equals(split2[i])) {
            i++;
        }
        if (i >= split.length || i >= split2.length) {
            if (Integer.signum(split.length - split2.length) > 0) {
                return true;
            }
        } else if (Integer.signum(Integer.valueOf(split[i]).compareTo(Integer.valueOf(split2[i]))) > 0) {
            return true;
        }
        return false;
    }

    public static void p(VPNClient vPNClient) {
        String string;
        String str;
        String string2;
        vPNClient.G();
        vPNClient.F();
        vPNClient.t.setText(vPNClient.getString(R.string.config_three) + Deobfuscator$BDNETVPN$app.getString(-55168186808203L) + vPNClient.x());
        if (vPNClient.m.i().intValue() == 3) {
            QQ qq = vPNClient.m.b;
            qq.putInt(Deobfuscator$BDNETVPN$app.getString(-161064900458379L), 0);
            qq.apply();
            vPNClient.j.D(Deobfuscator$BDNETVPN$app.getString(-55176776742795L), true);
        }
        C0223If c0223If = vPNClient.m;
        try {
            string = vPNClient.h().getString(Deobfuscator$BDNETVPN$app.getString(-48133030377355L));
        } catch (JSONException unused) {
            string = Deobfuscator$BDNETVPN$app.getString(-48184569984907L);
        }
        ZT.q(-161404202874763L, c0223If.b, string);
        C0223If c0223If2 = vPNClient.m;
        try {
            str = vPNClient.h().getString(Deobfuscator$BDNETVPN$app.getString(-68327966603147L));
        } catch (JSONException unused2) {
            str = null;
        }
        ZT.q(-162151527184267L, c0223If2.b, str);
        C0223If c0223If3 = vPNClient.m;
        try {
            string2 = vPNClient.h().getString(Deobfuscator$BDNETVPN$app.getString(-48480922728331L));
        } catch (JSONException unused3) {
            string2 = Deobfuscator$BDNETVPN$app.getString(-48523872401291L);
        }
        ZT.q(-163263923713931L, c0223If3.b, string2);
        int h = vPNClient.m.h();
        vPNClient.x.setSelection(h == 0 ? 1 : 0);
        vPNClient.x.postDelayed(new L00(vPNClient, h < vPNClient.B().length() ? h : 0, 1), 100L);
        QQ qq2 = vPNClient.m.b;
        qq2.putBoolean(Deobfuscator$BDNETVPN$app.getString(-163182319335307L), true);
        qq2.apply();
    }

    public static String q(long j) {
        String string;
        float f;
        float f2 = j;
        if (f2 >= 1.0E12f) {
            string = Deobfuscator$BDNETVPN$app.getString(-56473856866187L);
            f = 1.09951163E12f;
        } else if (f2 >= 1.0E9f) {
            string = Deobfuscator$BDNETVPN$app.getString(-56486741768075L);
            f = 1.07374182E9f;
        } else if (f2 >= 1000000.0f) {
            string = Deobfuscator$BDNETVPN$app.getString(-56499626669963L);
            f = 1048576.0f;
        } else {
            if (f2 < 1000.0f) {
                return String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-56525396473739L), Float.valueOf(f2));
            }
            string = Deobfuscator$BDNETVPN$app.getString(-56512511571851L);
            f = 1024.0f;
        }
        return String.format(Locale.ENGLISH, Deobfuscator$BDNETVPN$app.getString(-56546871310219L), Float.valueOf(f2 / f), string);
    }

    public static int v(JSONArray jSONArray, String str) {
        for (int i = 0; i < jSONArray.length(); i++) {
            if (jSONArray.getJSONObject(i).getString(Deobfuscator$BDNETVPN$app.getString(-45998431631243L)).equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public static String y() {
        MessageDigest messageDigest;
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer stringBuffer2 = new StringBuffer();
        StringBuffer stringBuffer3 = new StringBuffer();
        StringBuffer stringBuffer4 = new StringBuffer();
        StringBuffer stringBuffer5 = new StringBuffer();
        StringBuffer stringBuffer6 = new StringBuffer();
        StringBuffer stringBuffer7 = new StringBuffer();
        stringBuffer7.append(Build.SERIAL);
        stringBuffer7.append(Build.BOARD.length() % 5);
        stringBuffer6.append(stringBuffer7.toString());
        stringBuffer6.append(Build.BRAND.length() % 5);
        stringBuffer5.append(stringBuffer6.toString());
        stringBuffer5.append(Build.DEVICE.length() % 5);
        stringBuffer4.append(stringBuffer5.toString());
        stringBuffer4.append(Build.MANUFACTURER.length() % 5);
        stringBuffer3.append(stringBuffer4.toString());
        stringBuffer3.append(Build.MODEL.length() % 5);
        stringBuffer2.append(stringBuffer3.toString());
        stringBuffer2.append(Build.PRODUCT.length() % 5);
        stringBuffer.append(stringBuffer2.toString());
        stringBuffer.append(Build.HARDWARE);
        String stringBuffer8 = stringBuffer.toString();
        try {
            messageDigest = MessageDigest.getInstance(Deobfuscator$BDNETVPN$app.getString(-69981529012107L));
        } catch (NoSuchAlgorithmException unused) {
            messageDigest = null;
        }
        messageDigest.update(stringBuffer8.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            String hexString = Integer.toHexString(b & 255);
            while (hexString.length() < 2) {
                StringBuffer stringBuffer9 = new StringBuffer();
                stringBuffer9.append(Deobfuscator$BDNETVPN$app.getString(-69998708881291L));
                stringBuffer9.append(hexString);
                hexString = stringBuffer9.toString();
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase(Locale.getDefault());
    }

    public final String A() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-56190389024651L))).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.getTypeName() : Deobfuscator$BDNETVPN$app.getString(-56246223599499L);
    }

    public final JSONArray B() {
        try {
            return h().getJSONArray(Deobfuscator$BDNETVPN$app.getString(-73048135661451L));
        } catch (Exception unused) {
            return null;
        }
    }

    public final String C() {
        try {
            return h().getString(Deobfuscator$BDNETVPN$app.getString(-48188864952203L));
        } catch (JSONException unused) {
            return Deobfuscator$BDNETVPN$app.getString(-48223224690571L);
        }
    }

    public final void D(Intent intent) {
        Uri data;
        if (intent == null || !Deobfuscator$BDNETVPN$app.getString(-66343691712395L).equals(intent.getAction()) || (data = intent.getData()) == null) {
            return;
        }
        try {
            String readLine = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(data))).readLine();
            if (readLine == null) {
                readLine = Deobfuscator$BDNETVPN$app.getString(-67924239677323L);
            }
            JSONObject jSONObject = new JSONObject(PUtils.pDecrypt(getApplicationContext(), readLine));
            String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-66459655829387L));
            if (string.isEmpty()) {
                t(jSONObject);
            } else {
                N(string, jSONObject);
            }
        } catch (Exception unused) {
            SweetToast.error(this, Deobfuscator$BDNETVPN$app.getString(-66524080338827L));
        }
    }

    public final void E() {
        W00 w00 = new W00(this);
        C0407Pi c0407Pi = new C0407Pi(this);
        zza zza = zza.zza(this);
        ((Queue) zza.zzd().zzb.get()).add(Long.valueOf(System.currentTimeMillis()));
        zza.zzc().zzb(w00, c0407Pi, false);
    }

    public final void F() {
        try {
            this.a0.clear();
            JSONArray B = B();
            for (int i = 0; i < B.length(); i++) {
                this.a0.add(B.getJSONObject(i));
            }
            this.b0.notifyDataSetChanged();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-52230429177739L), B);
            this.B = RQ.b(jSONObject.toString());
        } catch (Exception e) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-52290558719883L) + e.getMessage());
        }
    }

    public final void G() {
        JSONArray jSONArray;
        try {
            this.r.clear();
            this.r.add(Deobfuscator$BDNETVPN$app.getString(-52032860682123L));
            try {
                jSONArray = h().getJSONArray(Deobfuscator$BDNETVPN$app.getString(-72992301086603L));
            } catch (Exception unused) {
                jSONArray = null;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                this.r.add(jSONArray.getJSONObject(i).getString(Deobfuscator$BDNETVPN$app.getString(-52114465060747L)));
            }
            this.q.notifyDataSetChanged();
        } catch (Exception e) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-52166004668299L) + e.getMessage());
        }
    }

    public final void H(String str) {
        JSONArray jSONArray;
        try {
            this.r.clear();
            this.r.add(Deobfuscator$BDNETVPN$app.getString(-53377185445771L));
            try {
                jSONArray = h().getJSONArray(Deobfuscator$BDNETVPN$app.getString(-72992301086603L));
            } catch (Exception unused) {
                jSONArray = null;
            }
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-53458789824395L)).equals(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-53497444530059L));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-53548984137611L), string);
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-53600523745163L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-53652063352715L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-53703602960267L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-53755142567819L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-53806682175371L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-53875401652107L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-53944121128843L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-53982775834507L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-54021430540171L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-54060085245835L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-54098739951499L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-54137394657163L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-54176049362827L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-54214704068491L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-54253358774155L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-54304898381707L)));
                    jSONObject2.put(Deobfuscator$BDNETVPN$app.getString(-54356437989259L), jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-54429452433291L)));
                    jSONArray2.put(jSONObject2);
                    this.r.add(string);
                }
            }
            this.q.notifyDataSetChanged();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put(Deobfuscator$BDNETVPN$app.getString(-54502466877323L), jSONArray2);
            this.A = RQ.b(jSONObject3.toString());
        } catch (Exception e) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-54558301452171L) + e.getMessage());
        }
    }

    public final void I() {
        AdView adView = new AdView(this);
        V1 v1 = V1.g;
        V1 f = Ke0.f(this, 360, 0);
        String string = Deobfuscator$BDNETVPN$app.getString(-47158072801163L);
        AbstractC3634my.g(string, "adUnitId");
        J9 j9 = new J9(string, new LinkedHashSet(), null, new LinkedHashMap(), new Bundle(), new HashSet(), new HashSet(), new LinkedHashMap(), null, f, AbstractC0641Yi.C(f), null, false);
        C4452xG c4452xG = new C4452xG(this, (ViewGroup) findViewById(R.id.adView), adView);
        InterfaceC0142Fc interfaceC0142Fc = adView.b;
        if (interfaceC0142Fc != null) {
            if (gt0.b) {
                throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
            }
            XE.r((InterfaceC3220hh) ((fb0) gt0.a.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).u.get(), null, new n9(interfaceC0142Fc, null), 3);
        }
        m9 m9Var = new m9(c4452xG, adView);
        if (gt0.b) {
            throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
        }
        ni1 ni1Var = gt0.a;
        uc1 uc1Var = (uc1) ((fb0) ni1Var.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).T2.get();
        if (gt0.b) {
            throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
        }
        fb0 fb0Var = ((fb0) ni1Var.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).c;
        dr2 dr2Var = dr2.f;
        Boolean bool = Boolean.FALSE;
        gd0 gd0Var = new gd0(fb0Var, j9, dr2Var, bool, bool, j9);
        uc1Var.a((InterfaceC0522Tt) new vk(gd0Var, m9Var, true, null));
        adView.b = (InterfaceC0142Fc) gd0Var.j.get();
    }

    public final void J() {
        new Handler().postDelayed(new RunnableC3243i10(this, 0), 2000L);
    }

    public final void K() {
        if (this.z == null) {
            String string = Deobfuscator$BDNETVPN$app.getString(-67992959154059L);
            AbstractC3634my.g(string, "adUnitId");
            S1 s1 = new S1(string, new LinkedHashSet(), null, new LinkedHashMap(), new Bundle(), new HashSet(), new HashSet(), new LinkedHashMap(), null);
            C3083g10 c3083g10 = new C3083g10(this);
            cf1.d.getClass();
            if (gt0.b) {
                throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
            }
            ni1 ni1Var = gt0.a;
            uc1 uc1Var = (uc1) ((fb0) ni1Var.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).T2.get();
            if (gt0.b) {
                throw new IllegalStateException("The Google Mobile Ads SDK is stopped. Please call MobileAds.initialize again.");
            }
            fb0 fb0Var = ((fb0) ni1Var.a("MobileAds.initialize must be called before using the Google Mobile Ads SDK.")).c;
            dr2 dr2Var = dr2.h;
            Boolean bool = Boolean.FALSE;
            uc1Var.a((InterfaceC0522Tt) new xe1((yl2) new md0(fb0Var, s1, s1, dr2Var, bool, bool).i.get(), c3083g10, null));
            this.E = false;
        }
    }

    public final void L() {
        String str;
        U3 u3 = new U3(this, R.style.MyDialogTheme);
        TextView textView = new TextView(this);
        try {
            str = h().getString(Deobfuscator$BDNETVPN$app.getString(-68160462878603L));
        } catch (JSONException unused) {
            str = null;
        }
        textView.setText(str);
        textView.setTextSize(11.0f);
        textView.setTextColor(-1);
        textView.setTypeface(Typeface.MONOSPACE);
        textView.setPadding(50, 30, 50, 30);
        textView.setGravity(8388611);
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        String string = Deobfuscator$BDNETVPN$app.getString(-68207707518859L);
        Q3 q3 = (Q3) u3.c;
        q3.e = string;
        q3.r = textView;
        q3.c = R.drawable.ic_app_icon;
        u3.e(Deobfuscator$BDNETVPN$app.getString(-68242067257227L), null);
        u3.g();
    }

    public final void M(final String str, JSONObject jSONObject) {
        try {
            final String pEncrypt = PUtils.pEncrypt(getApplicationContext(), jSONObject.toString());
            U3 u3 = new U3(this, R.style.MyDialogTheme);
            Q3 q3 = (Q3) u3.c;
            q3.e = Deobfuscator$BDNETVPN$app.getString(-50924759119755L);
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.export_dialog, (ViewGroup) null);
            q3.r = inflate;
            EditText editText = (EditText) inflate.findViewById(R.id.custom_expotweak_edittext);
            editText.setText(this.X + pEncrypt);
            editText.setFocusable(false);
            editText.setCursorVisible(false);
            editText.setTextIsSelectable(true);
            u3.f(Deobfuscator$BDNETVPN$app.getString(-51006363498379L), new T00(0, this, pEncrypt));
            u3.e(Deobfuscator$BDNETVPN$app.getString(-51027838334859L), null);
            String string = Deobfuscator$BDNETVPN$app.getString(-51053608138635L);
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: U00
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    Uri uri;
                    String str2 = str;
                    VPNClient vPNClient = VPNClient.this;
                    String str3 = vPNClient.Y;
                    String str4 = vPNClient.W;
                    int i2 = Build.VERSION.SDK_INT;
                    if (i2 < 29 && AbstractC3131gc0.g(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-70995141293963L)) != 0) {
                        F00.h(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-71175529920395L));
                        AbstractC3131gc0.I(vPNClient, new String[]{Deobfuscator$BDNETVPN$app.getString(-71390278285195L)}, 77);
                        return;
                    }
                    try {
                        String str5 = str2 + str4;
                        ContentValues contentValues = new ContentValues();
                        contentValues.put(Deobfuscator$BDNETVPN$app.getString(-71570666911627L), str5);
                        contentValues.put(Deobfuscator$BDNETVPN$app.getString(-71630796453771L), Deobfuscator$BDNETVPN$app.getString(-71673746126731L));
                        contentValues.put(Deobfuscator$BDNETVPN$app.getString(-71781120309131L), Environment.DIRECTORY_DOWNLOADS + Deobfuscator$BDNETVPN$app.getString(-71841249851275L) + str3);
                        String str6 = pEncrypt;
                        if (i2 < 29) {
                            File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), str3);
                            if (!file.exists()) {
                                file.mkdirs();
                            }
                            File file2 = new File(file, str5);
                            int i3 = 1;
                            while (file2.exists()) {
                                i3++;
                                file2 = new File(file, str5.replace(str4, Deobfuscator$BDNETVPN$app.getString(-71849839785867L) + i3 + Deobfuscator$BDNETVPN$app.getString(-71862724687755L) + str4));
                            }
                            FileOutputStream fileOutputStream = new FileOutputStream(file2);
                            try {
                                fileOutputStream.write(str6.getBytes());
                                fileOutputStream.flush();
                                fileOutputStream.close();
                                SweetToast.success(vPNClient, Deobfuscator$BDNETVPN$app.getString(-71871314622347L) + file2.getName());
                                return;
                            } finally {
                            }
                        }
                        uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                        try {
                            FileOutputStream fileOutputStream2 = (FileOutputStream) vPNClient.getContentResolver().openOutputStream(vPNClient.getContentResolver().insert(uri, contentValues));
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.write(str6.getBytes());
                                    fileOutputStream2.flush();
                                } finally {
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (Throwable th) {
                                            th.addSuppressed(th);
                                        }
                                    }
                                }
                            }
                            SweetToast.success(vPNClient, Deobfuscator$BDNETVPN$app.getString(-71982983772043L) + str5);
                            if (fileOutputStream2 != null) {
                                fileOutputStream2.close();
                                return;
                            }
                            return;
                        } catch (IOException e) {
                            SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-72094652921739L) + e.getMessage());
                            return;
                        }
                    } catch (Exception e2) {
                        SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-72189142202251L) + e2.getMessage());
                    }
                    SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-72189142202251L) + e2.getMessage());
                }
            };
            q3.l = string;
            q3.m = onClickListener;
            u3.g();
        } catch (Exception e) {
            SweetToast.error(this, Deobfuscator$BDNETVPN$app.getString(-51075082975115L) + e.getMessage());
        }
    }

    public final void N(final String str, final JSONObject jSONObject) {
        final EditText editText;
        final V3 a;
        try {
            U3 u3 = new U3(this, R.style.MyDialogTheme);
            Q3 q3 = (Q3) u3.c;
            q3.e = Deobfuscator$BDNETVPN$app.getString(-70402435807115L);
            q3.n = false;
            View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.password_dialog_import, (ViewGroup) null);
            q3.r = inflate;
            editText = (EditText) inflate.findViewById(R.id.pw_edittext);
            u3.f(Deobfuscator$BDNETVPN$app.getString(-70462565349259L), null);
            u3.e(Deobfuscator$BDNETVPN$app.getString(-70484040185739L), new M00(1));
            a = u3.a();
            a.show();
        } catch (Exception e) {
            e = e;
        }
        try {
            a.c(-1).setOnClickListener(new View.OnClickListener() { // from class: S00
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    String str2 = VPNClient.f0;
                    VPNClient vPNClient = VPNClient.this;
                    vPNClient.getClass();
                    String obj = editText.getText().toString();
                    if (obj.isEmpty()) {
                        SweetToast.error(vPNClient, Deobfuscator$BDNETVPN$app.getString(-70582824433547L));
                    } else if (!str.equals(obj)) {
                        SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-70694493583243L));
                    } else {
                        vPNClient.t(jSONObject);
                        a.dismiss();
                    }
                }
            });
        } catch (Exception e2) {
            e = e2;
            SweetToast.error(this, Deobfuscator$BDNETVPN$app.getString(-70509809989515L) + e.getMessage());
        }
    }

    public final void O(String str) {
        this.l.setVisibility(0);
        if (!str.contains(Deobfuscator$BDNETVPN$app.getString(-56387957520267L))) {
            this.l.setText(str);
        }
        if (str.equals(getString(R.string.auth_failed))) {
            this.l.setTextColor(-65536);
            this.l.setText(getString(R.string.invalid));
        } else if (str.equals(getString(R.string.disconnected)) || str.equals(getString(R.string.auth_failed))) {
            this.l.setTextColor(-65536);
            this.l.setText(getString(R.string.disconnected));
        } else if (str.equals(getString(R.string.connected))) {
            this.l.setTextColor(-16711936);
            this.l.setText(getString(R.string.connected));
        }
    }

    public final void P() {
        C0223If d;
        JSONObject jSONObject;
        String string;
        String string2;
        long j;
        long j2;
        int i;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        try {
            this.G.setText(getString(R.string.ip_three) + Deobfuscator$BDNETVPN$app.getString(-59364369856395L) + z() + Deobfuscator$BDNETVPN$app.getString(-59372959790987L) + A());
            C2882dV.y().x().c();
            d = C0223If.d(this);
            int selectedItemPosition = this.k.getSelectedItemPosition();
            int selectedItemPosition2 = this.x.getSelectedItemPosition();
            d.M(selectedItemPosition);
            JSONArray jSONArray = new JSONObject(RQ.a(this.A)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-59381549725579L));
            if (selectedItemPosition == 0) {
                this.s = new Random().nextInt(jSONArray.length());
            } else if (d.e().equals(Deobfuscator$BDNETVPN$app.getString(-59437384300427L))) {
                this.s = new Random().nextInt(jSONArray.length());
            } else {
                this.s = selectedItemPosition - 1;
            }
            JSONObject jSONObject2 = jSONArray.getJSONObject(this.s);
            jSONObject = new JSONObject(RQ.a(this.B)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-59458859136907L)).getJSONObject(selectedItemPosition2);
            String string8 = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-59518988679051L));
            jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-59570528286603L));
            jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-59630657828747L));
            string = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-59665017567115L));
            String string9 = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-59716557174667L));
            string2 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-59789571618699L));
            String string10 = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-59823931357067L));
            String string11 = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-59862586062731L));
            String string12 = jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-59901240768395L));
            String string13 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-59952780375947L));
            d.L(string8);
            d.z(string13);
            if (string9.equals(Deobfuscator$BDNETVPN$app.getString(-60012909918091L))) {
                string = PUtils.pDecrypt(getApplicationContext(), string);
            }
            if (!string2.equals(Deobfuscator$BDNETVPN$app.getString(-60034384754571L))) {
                j = -48442268022667L;
                j2 = -48420793186187L;
                if (string.contains(Deobfuscator$BDNETVPN$app.getString(-60292082792331L))) {
                    String[] split = string.split(Deobfuscator$BDNETVPN$app.getString(-60300672726923L));
                    String str = split[new Random().nextInt(split.length)];
                    if (str.contains(Deobfuscator$BDNETVPN$app.getString(-60309262661515L))) {
                        String replaceAll = str.replaceAll(Deobfuscator$BDNETVPN$app.getString(-60317852596107L), Deobfuscator$BDNETVPN$app.getString(-60352212334475L));
                        str = F00.f(Integer.valueOf(replaceAll.split(Deobfuscator$BDNETVPN$app.getString(-60356507301771L))[0]).intValue(), Integer.valueOf(replaceAll.split(Deobfuscator$BDNETVPN$app.getString(-60365097236363L))[1]).intValue()) + F00.e(str);
                    }
                    d.I(string2 + Deobfuscator$BDNETVPN$app.getString(-60373687170955L) + str);
                } else if (string.contains(Deobfuscator$BDNETVPN$app.getString(-60382277105547L))) {
                    String replaceAll2 = string.replaceAll(Deobfuscator$BDNETVPN$app.getString(-60390867040139L), Deobfuscator$BDNETVPN$app.getString(-60425226778507L));
                    d.I(string2 + Deobfuscator$BDNETVPN$app.getString(-60429521745803L) + F00.f(Integer.valueOf(replaceAll2.split(Deobfuscator$BDNETVPN$app.getString(-60438111680395L))[0]).intValue(), Integer.valueOf(replaceAll2.split(Deobfuscator$BDNETVPN$app.getString(-60446701614987L))[1]).intValue()) + F00.e(string));
                } else {
                    d.I(string2 + Deobfuscator$BDNETVPN$app.getString(-60455291549579L) + string);
                }
            } else if (string.contains(Deobfuscator$BDNETVPN$app.getString(-60038679721867L))) {
                String[] split2 = string.split(Deobfuscator$BDNETVPN$app.getString(-60047269656459L));
                j = -48442268022667L;
                String str2 = split2[new Random().nextInt(split2.length)];
                if (str2.contains(Deobfuscator$BDNETVPN$app.getString(-60055859591051L))) {
                    String replaceAll3 = str2.replaceAll(Deobfuscator$BDNETVPN$app.getString(-60064449525643L), Deobfuscator$BDNETVPN$app.getString(-60098809264011L));
                    StringBuilder sb = new StringBuilder();
                    j2 = -48420793186187L;
                    sb.append(F00.f(Integer.valueOf(replaceAll3.split(Deobfuscator$BDNETVPN$app.getString(-60103104231307L))[0]).intValue(), Integer.valueOf(replaceAll3.split(Deobfuscator$BDNETVPN$app.getString(-60111694165899L))[1]).intValue()));
                    sb.append(F00.e(str2));
                    str2 = sb.toString();
                } else {
                    j2 = -48420793186187L;
                }
                d.I(str2);
            } else {
                j = -48442268022667L;
                j2 = -48420793186187L;
                if (string.contains(Deobfuscator$BDNETVPN$app.getString(-60120284100491L))) {
                    String replaceAll4 = string.replaceAll(Deobfuscator$BDNETVPN$app.getString(-60128874035083L), Deobfuscator$BDNETVPN$app.getString(-60163233773451L));
                    d.I(F00.f(Integer.valueOf(replaceAll4.split(Deobfuscator$BDNETVPN$app.getString(-60167528740747L))[0]).intValue(), Integer.valueOf(replaceAll4.split(Deobfuscator$BDNETVPN$app.getString(-60176118675339L))[1]).intValue()) + F00.e(string));
                } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-60184708609931L))) {
                    try {
                        string7 = h().getString(Deobfuscator$BDNETVPN$app.getString(-48420793186187L));
                    } catch (JSONException unused) {
                        string7 = Deobfuscator$BDNETVPN$app.getString(-48442268022667L);
                    }
                    if (string7.contains(Deobfuscator$BDNETVPN$app.getString(-60210478413707L))) {
                        String[] split3 = string7.split(Deobfuscator$BDNETVPN$app.getString(-60219068348299L));
                        String str3 = split3[new Random().nextInt(split3.length)];
                        if (str3.contains(Deobfuscator$BDNETVPN$app.getString(-60227658282891L))) {
                            String replaceAll5 = str3.replaceAll(Deobfuscator$BDNETVPN$app.getString(-60236248217483L), Deobfuscator$BDNETVPN$app.getString(-60270607955851L));
                            str3 = F00.f(Integer.valueOf(replaceAll5.split(Deobfuscator$BDNETVPN$app.getString(-60274902923147L))[0]).intValue(), Integer.valueOf(replaceAll5.split(Deobfuscator$BDNETVPN$app.getString(-60283492857739L))[1]).intValue()) + F00.e(str3);
                        }
                        d.I(str3);
                    } else {
                        d.I(string7);
                    }
                } else {
                    d.I(string);
                }
            }
            d.J(jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-60463881484171L)));
            d.K(jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-60515421091723L)));
            d.P(jSONObject2.getString(Deobfuscator$BDNETVPN$app.getString(-60554075797387L)));
            d.R(string10);
            d.E(string11);
            d.w(string12);
            String string14 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-60622795274123L));
            String string15 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-60652860045195L));
            i = (string14.equals(Deobfuscator$BDNETVPN$app.getString(-60717284554635L)) && string15.equals(Deobfuscator$BDNETVPN$app.getString(-60747349325707L))) ? 0 : (!string14.equals(Deobfuscator$BDNETVPN$app.getString(-60798888933259L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-60816068802443L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-60863313442699L)) || string15.contains(Deobfuscator$BDNETVPN$app.getString(-60897673181067L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-60936327886731L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-60983572526987L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61030817167243L))) ? (!string14.equals(Deobfuscator$BDNETVPN$app.getString(-61073766840203L)) || !jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-61095241676683L)).equals(Deobfuscator$BDNETVPN$app.getString(-61121011480459L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61146781284235L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61194025924491L)) || string15.contains(Deobfuscator$BDNETVPN$app.getString(-61228385662859L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61267040368523L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61314285008779L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61361529649035L))) ? (!string14.equals(Deobfuscator$BDNETVPN$app.getString(-61404479321995L)) || !jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-61425954158475L)).equals(Deobfuscator$BDNETVPN$app.getString(-61451723962251L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61473198798731L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61520443438987L)) || string15.contains(Deobfuscator$BDNETVPN$app.getString(-61554803177355L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61593457883019L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61640702523275L)) || string15.equals(Deobfuscator$BDNETVPN$app.getString(-61687947163531L))) ? (string14.equals(Deobfuscator$BDNETVPN$app.getString(-61730896836491L)) && string15.equals(Deobfuscator$BDNETVPN$app.getString(-61748076705675L))) ? 6 : (string14.equals(Deobfuscator$BDNETVPN$app.getString(-61778141476747L)) && string15.equals(Deobfuscator$BDNETVPN$app.getString(-61799616313227L))) ? 7 : (string14.equals(Deobfuscator$BDNETVPN$app.getString(-61846860953483L)) && string15.equals(Deobfuscator$BDNETVPN$app.getString(-61868335789963L))) ? 11 : (string14.equals(Deobfuscator$BDNETVPN$app.getString(-61911285462923L)) && string15.equals(Deobfuscator$BDNETVPN$app.getString(-61928465332107L))) ? 8 : (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-60691514750859L)).equals(Deobfuscator$BDNETVPN$app.getString(-61962825070475L)) && string15.equals(Deobfuscator$BDNETVPN$app.getString(-61997184808843L))) ? 10 : 9 : 5 : 2 : 3;
            d.O(i);
            d.C(jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62044429449099L)));
            if (d.n() == 7) {
                d.H(true);
                d.Q(false);
                d.S(false);
                u(false);
                d.D(false);
            } else if (d.n() == 6) {
                d.H(false);
                d.Q(true);
                d.S(false);
                u(false);
                d.D(false);
            } else if (d.n() == 10) {
                d.H(false);
                d.Q(true);
                d.S(false);
                u(false);
                d.D(false);
            } else if (d.n() == 8) {
                d.H(false);
                d.Q(false);
                d.S(true);
                u(false);
                d.D(false);
            } else if (d.n() == 9) {
                d.H(false);
                d.Q(false);
                d.S(true);
                u(false);
                d.D(false);
            } else if (d.n() == 11) {
                d.H(false);
                d.Q(false);
                d.S(true);
                u(false);
                d.D(false);
            } else {
                d.H(false);
                d.Q(false);
                d.D(true);
                if (string15.contains(Deobfuscator$BDNETVPN$app.getString(-62104558991243L))) {
                    QQ qq = d.b;
                    qq.putBoolean(Deobfuscator$BDNETVPN$app.getString(-161326893463435L), true);
                    qq.apply();
                } else {
                    QQ qq2 = d.b;
                    qq2.putBoolean(Deobfuscator$BDNETVPN$app.getString(-161326893463435L), false);
                    qq2.apply();
                }
                d.S(false);
                u(false);
            }
            if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62130328795019L)).equals(Deobfuscator$BDNETVPN$app.getString(-62156098598795L))) {
                d.v(jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62199048271755L)));
                d.A(true);
                d.B(false);
            } else if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62233408010123L)).equals(Deobfuscator$BDNETVPN$app.getString(-62259177813899L))) {
                String[] a = new C0407Pi(this).a();
                String string16 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62293537552267L));
                if (string16.equals(Deobfuscator$BDNETVPN$app.getString(-62327897290635L))) {
                    d.v(d.l());
                    d.y(true);
                } else if (string16.equals(Deobfuscator$BDNETVPN$app.getString(-62332192257931L))) {
                    d.v(a[0]);
                    d.y(false);
                } else if (string16.equals(Deobfuscator$BDNETVPN$app.getString(-62370846963595L))) {
                    d.v(a[1]);
                    d.y(false);
                } else {
                    d.v(string16);
                    d.y(false);
                }
                d.A(true);
                d.B(true);
            } else if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62409501669259L)).equals(Deobfuscator$BDNETVPN$app.getString(-62435271473035L))) {
                d.v(d.l());
                d.A(true);
                d.B(false);
                d.y(true);
            } else {
                d.A(false);
                d.B(false);
                d.y(false);
            }
        } catch (Exception e) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-65080971327371L) + e.getMessage());
            r();
            return;
        }
        if (i == 2 || i == 5 || i == 0 || i == 9 || i == 10 || i == 11) {
            String string17 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62469631211403L));
            String string18 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-62491106047883L));
            if (string2.equals(Deobfuscator$BDNETVPN$app.getString(-62512580884363L))) {
                if (string17.equals(Deobfuscator$BDNETVPN$app.getString(-62516875851659L))) {
                    if (string.contains(Deobfuscator$BDNETVPN$app.getString(-62546940622731L))) {
                        String[] split4 = string.split(Deobfuscator$BDNETVPN$app.getString(-62555530557323L));
                        String str4 = split4[new Random().nextInt(split4.length)];
                        if (str4.contains(Deobfuscator$BDNETVPN$app.getString(-62564120491915L))) {
                            String replaceAll6 = str4.replaceAll(Deobfuscator$BDNETVPN$app.getString(-62572710426507L), Deobfuscator$BDNETVPN$app.getString(-62607070164875L));
                            str4 = F00.f(Integer.valueOf(replaceAll6.split(Deobfuscator$BDNETVPN$app.getString(-62611365132171L))[0]).intValue(), Integer.valueOf(replaceAll6.split(Deobfuscator$BDNETVPN$app.getString(-62619955066763L))[1]).intValue()) + F00.e(str4);
                        }
                        if (i != 9) {
                            d.F(str4);
                        } else {
                            d.F(Deobfuscator$BDNETVPN$app.getString(-62628545001355L));
                        }
                    } else if (string.contains(Deobfuscator$BDNETVPN$app.getString(-62658609772427L))) {
                        String replaceAll7 = string.replaceAll(Deobfuscator$BDNETVPN$app.getString(-62667199707019L), Deobfuscator$BDNETVPN$app.getString(-62701559445387L));
                        d.F(F00.f(Integer.valueOf(replaceAll7.split(Deobfuscator$BDNETVPN$app.getString(-62705854412683L))[0]).intValue(), Integer.valueOf(replaceAll7.split(Deobfuscator$BDNETVPN$app.getString(-62714444347275L))[1]).intValue()) + F00.e(string));
                    } else if (string.equals(Deobfuscator$BDNETVPN$app.getString(-62723034281867L))) {
                        try {
                            string3 = h().getString(Deobfuscator$BDNETVPN$app.getString(j2));
                        } catch (JSONException unused2) {
                            string3 = Deobfuscator$BDNETVPN$app.getString(j);
                        }
                        if (string3.contains(Deobfuscator$BDNETVPN$app.getString(-62748804085643L))) {
                            String[] split5 = string3.split(Deobfuscator$BDNETVPN$app.getString(-62757394020235L));
                            String str5 = split5[new Random().nextInt(split5.length)];
                            if (str5.contains(Deobfuscator$BDNETVPN$app.getString(-62765983954827L))) {
                                String replaceAll8 = str5.replaceAll(Deobfuscator$BDNETVPN$app.getString(-62774573889419L), Deobfuscator$BDNETVPN$app.getString(-62808933627787L));
                                str5 = F00.f(Integer.valueOf(replaceAll8.split(Deobfuscator$BDNETVPN$app.getString(-62813228595083L))[0]).intValue(), Integer.valueOf(replaceAll8.split(Deobfuscator$BDNETVPN$app.getString(-62821818529675L))[1]).intValue()) + F00.e(str5);
                            }
                            d.F(str5);
                        } else {
                            d.F(string3);
                        }
                    } else {
                        if (i == 9) {
                            string = Deobfuscator$BDNETVPN$app.getString(-62830408464267L);
                        }
                        d.F(string);
                    }
                } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-62860473235339L))) {
                    String[] split6 = string17.split(Deobfuscator$BDNETVPN$app.getString(-62869063169931L));
                    String str6 = split6[new Random().nextInt(split6.length)];
                    if (str6.contains(Deobfuscator$BDNETVPN$app.getString(-62877653104523L))) {
                        String replaceAll9 = str6.replaceAll(Deobfuscator$BDNETVPN$app.getString(-62886243039115L), Deobfuscator$BDNETVPN$app.getString(-62920602777483L));
                        str6 = F00.f(Integer.valueOf(replaceAll9.split(Deobfuscator$BDNETVPN$app.getString(-62924897744779L))[0]).intValue(), Integer.valueOf(replaceAll9.split(Deobfuscator$BDNETVPN$app.getString(-62933487679371L))[1]).intValue()) + F00.e(str6);
                    }
                    if (str6.contains(Deobfuscator$BDNETVPN$app.getString(-62942077613963L))) {
                        try {
                            d.F(F00.d(InetAddress.getByName(str6.split(Deobfuscator$BDNETVPN$app.getString(-62959257483147L))[0]), Integer.parseInt(str6.split(Deobfuscator$BDNETVPN$app.getString(-62967847417739L))[1])));
                        } catch (Exception unused3) {
                            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-62976437352331L));
                            this.F = true;
                        }
                    } else {
                        d.F(str6);
                    }
                } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-63053746763659L))) {
                    String replaceAll10 = string17.replaceAll(Deobfuscator$BDNETVPN$app.getString(-63062336698251L), Deobfuscator$BDNETVPN$app.getString(-63096696436619L));
                    d.F(F00.f(Integer.valueOf(replaceAll10.split(Deobfuscator$BDNETVPN$app.getString(-63100991403915L))[0]).intValue(), Integer.valueOf(replaceAll10.split(Deobfuscator$BDNETVPN$app.getString(-63109581338507L))[1]).intValue()) + F00.e(string17));
                } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-63118171273099L))) {
                    if (w().contains(Deobfuscator$BDNETVPN$app.getString(-63148236044171L))) {
                        String[] split7 = w().split(Deobfuscator$BDNETVPN$app.getString(-63156825978763L));
                        d.F(split7[new Random().nextInt(split7.length)]);
                    } else {
                        d.F(w());
                    }
                } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-63165415913355L))) {
                    if (C().contains(Deobfuscator$BDNETVPN$app.getString(-63186890749835L))) {
                        String[] split8 = C().split(Deobfuscator$BDNETVPN$app.getString(-63195480684427L));
                        try {
                            String pDecrypt = PUtils.pDecrypt(getApplicationContext(), split8[new Random().nextInt(split8.length)]);
                            d.F(F00.d(InetAddress.getByName(pDecrypt.split(Deobfuscator$BDNETVPN$app.getString(-63204070619019L))[0]), Integer.parseInt(pDecrypt.split(Deobfuscator$BDNETVPN$app.getString(-63212660553611L))[1])));
                        } catch (Exception unused4) {
                            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-63221250488203L));
                            this.F = true;
                        }
                    } else {
                        try {
                            String C = C();
                            d.F(F00.d(InetAddress.getByName(C.split(Deobfuscator$BDNETVPN$app.getString(-63298559899531L))[0]), Integer.parseInt(C.split(Deobfuscator$BDNETVPN$app.getString(-63307149834123L))[1])));
                        } catch (Exception unused5) {
                            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-63315739768715L));
                            this.F = true;
                        }
                    }
                } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-63393049180043L))) {
                    try {
                        d.F(F00.d(InetAddress.getByName(string17.split(Deobfuscator$BDNETVPN$app.getString(-63410229049227L))[0]), Integer.parseInt(string17.split(Deobfuscator$BDNETVPN$app.getString(-63418818983819L))[1])));
                    } catch (Exception unused6) {
                        SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-63427408918411L));
                        this.F = true;
                    }
                } else {
                    d.F(string17);
                }
                SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-65080971327371L) + e.getMessage());
                r();
                return;
            }
            if (string17.equals(Deobfuscator$BDNETVPN$app.getString(-63504718329739L))) {
                if (string.contains(Deobfuscator$BDNETVPN$app.getString(-63534783100811L))) {
                    String[] split9 = string.split(Deobfuscator$BDNETVPN$app.getString(-63543373035403L));
                    String str7 = split9[new Random().nextInt(split9.length)];
                    if (str7.contains(Deobfuscator$BDNETVPN$app.getString(-63551962969995L))) {
                        String replaceAll11 = str7.replaceAll(Deobfuscator$BDNETVPN$app.getString(-63560552904587L), Deobfuscator$BDNETVPN$app.getString(-63594912642955L));
                        str7 = F00.f(Integer.valueOf(replaceAll11.split(Deobfuscator$BDNETVPN$app.getString(-63599207610251L))[0]).intValue(), Integer.valueOf(replaceAll11.split(Deobfuscator$BDNETVPN$app.getString(-63607797544843L))[1]).intValue()) + F00.e(str7);
                    }
                    d.F(string2 + Deobfuscator$BDNETVPN$app.getString(-63616387479435L) + str7);
                } else if (string.contains(Deobfuscator$BDNETVPN$app.getString(-63624977414027L))) {
                    String replaceAll12 = string.replaceAll(Deobfuscator$BDNETVPN$app.getString(-63633567348619L), Deobfuscator$BDNETVPN$app.getString(-63667927086987L));
                    d.F(string2 + Deobfuscator$BDNETVPN$app.getString(-63672222054283L) + F00.f(Integer.valueOf(replaceAll12.split(Deobfuscator$BDNETVPN$app.getString(-63680811988875L))[0]).intValue(), Integer.valueOf(replaceAll12.split(Deobfuscator$BDNETVPN$app.getString(-63689401923467L))[1]).intValue()) + F00.e(string));
                } else {
                    d.F(string2 + Deobfuscator$BDNETVPN$app.getString(-63697991858059L) + string);
                }
            } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-63706581792651L))) {
                String[] split10 = string17.split(Deobfuscator$BDNETVPN$app.getString(-63715171727243L));
                String str8 = split10[new Random().nextInt(split10.length)];
                if (str8.contains(Deobfuscator$BDNETVPN$app.getString(-63723761661835L))) {
                    String replaceAll13 = str8.replaceAll(Deobfuscator$BDNETVPN$app.getString(-63732351596427L), Deobfuscator$BDNETVPN$app.getString(-63766711334795L));
                    str8 = F00.f(Integer.valueOf(replaceAll13.split(Deobfuscator$BDNETVPN$app.getString(-63771006302091L))[0]).intValue(), Integer.valueOf(replaceAll13.split(Deobfuscator$BDNETVPN$app.getString(-63779596236683L))[1]).intValue()) + F00.e(str8);
                }
                d.F(string2 + Deobfuscator$BDNETVPN$app.getString(-63788186171275L) + str8);
            } else if (string17.contains(Deobfuscator$BDNETVPN$app.getString(-63796776105867L))) {
                String replaceAll14 = string17.replaceAll(Deobfuscator$BDNETVPN$app.getString(-63805366040459L), Deobfuscator$BDNETVPN$app.getString(-63839725778827L));
                d.F(string2 + Deobfuscator$BDNETVPN$app.getString(-63844020746123L) + F00.f(Integer.valueOf(replaceAll14.split(Deobfuscator$BDNETVPN$app.getString(-63852610680715L))[0]).intValue(), Integer.valueOf(replaceAll14.split(Deobfuscator$BDNETVPN$app.getString(-63861200615307L))[1]).intValue()) + F00.e(string17));
            } else {
                d.F(string2 + Deobfuscator$BDNETVPN$app.getString(-63869790549899L) + string17);
            }
            if (string18.equals(Deobfuscator$BDNETVPN$app.getString(-63878380484491L))) {
                d.G(Deobfuscator$BDNETVPN$app.getString(-63908445255563L));
            } else if (string18.contains(Deobfuscator$BDNETVPN$app.getString(-63929920092043L))) {
                String[] split11 = string18.split(Deobfuscator$BDNETVPN$app.getString(-63938510026635L));
                d.G(split11[new Random().nextInt(split11.length)]);
            } else {
                d.G(string18);
            }
        }
        if (i == 6) {
            String string19 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-63947099961227L));
            if (string19.equals(Deobfuscator$BDNETVPN$app.getString(-63968574797707L))) {
                d.G(Deobfuscator$BDNETVPN$app.getString(-63998639568779L));
            } else {
                d.G(string19);
            }
        }
        if (i == 5) {
            d.N(jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64020114405259L)));
        } else {
            if (!jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64054474143627L)).contains(Deobfuscator$BDNETVPN$app.getString(-64088833881995L))) {
                if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64136078522251L)).contains(Deobfuscator$BDNETVPN$app.getString(-64170438260619L))) {
                    if (C().contains(Deobfuscator$BDNETVPN$app.getString(-64191913097099L))) {
                        String[] split12 = C().split(Deobfuscator$BDNETVPN$app.getString(-64200503031691L));
                        try {
                            String pDecrypt2 = PUtils.pDecrypt(getApplicationContext(), split12[new Random().nextInt(split12.length)]);
                            d.N(F00.d(InetAddress.getByName(pDecrypt2.split(Deobfuscator$BDNETVPN$app.getString(-64209092966283L))[0]), Integer.parseInt(pDecrypt2.split(Deobfuscator$BDNETVPN$app.getString(-64217682900875L))[1])));
                        } catch (Exception unused7) {
                            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-64226272835467L));
                            this.F = true;
                        }
                    } else {
                        try {
                            String C2 = C();
                            d.N(F00.d(InetAddress.getByName(C2.split(Deobfuscator$BDNETVPN$app.getString(-64303582246795L))[0]), Integer.parseInt(C2.split(Deobfuscator$BDNETVPN$app.getString(-64312172181387L))[1])));
                        } catch (Exception unused8) {
                            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-64320762115979L));
                            this.F = true;
                        }
                    }
                } else if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64398071527307L)).contains(Deobfuscator$BDNETVPN$app.getString(-64432431265675L))) {
                    try {
                        String string20 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64449611134859L));
                        d.N(F00.d(InetAddress.getByName(string20.split(Deobfuscator$BDNETVPN$app.getString(-64483970873227L))[0]), Integer.parseInt(string20.split(Deobfuscator$BDNETVPN$app.getString(-64492560807819L))[1])));
                    } catch (Exception unused9) {
                        SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-64501150742411L));
                        this.F = true;
                    }
                } else if (jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64578460153739L)).contains(Deobfuscator$BDNETVPN$app.getString(-64612819892107L))) {
                    String[] split13 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64621409826699L)).split(Deobfuscator$BDNETVPN$app.getString(-64655769565067L));
                    d.N(split13[new Random().nextInt(split13.length)]);
                } else {
                    d.N(jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64664359499659L)));
                }
                SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-65080971327371L) + e.getMessage());
                r();
                return;
            }
            if (w().contains(Deobfuscator$BDNETVPN$app.getString(-64118898653067L))) {
                String[] split14 = w().split(Deobfuscator$BDNETVPN$app.getString(-64127488587659L));
                d.N(split14[new Random().nextInt(split14.length)]);
            } else {
                d.N(w());
            }
        }
        String string21 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-64698719238027L));
        String string22 = Deobfuscator$BDNETVPN$app.getString(-64733078976395L);
        try {
            string4 = h().getString(Deobfuscator$BDNETVPN$app.getString(-64788913551243L));
        } catch (JSONException unused10) {
            string4 = Deobfuscator$BDNETVPN$app.getString(-48476627761035L);
        }
        String replace = string21.replace(string22, string4);
        String string23 = Deobfuscator$BDNETVPN$app.getString(-64836158191499L);
        try {
            string5 = h().getString(Deobfuscator$BDNETVPN$app.getString(-64913467602827L));
        } catch (JSONException unused11) {
            string5 = Deobfuscator$BDNETVPN$app.getString(-48476627761035L);
        }
        String replace2 = replace.replace(string23, string5);
        String string24 = Deobfuscator$BDNETVPN$app.getString(-64995071981451L);
        try {
            string6 = h().getString(Deobfuscator$BDNETVPN$app.getString(-65033726687115L));
        } catch (JSONException unused12) {
            string6 = Deobfuscator$BDNETVPN$app.getString(-48476627761035L);
        }
        d.x(replace2.replace(string24, string6));
        if (d.p().booleanValue()) {
            Q();
        } else if (!d.r()) {
            Q();
        } else {
            if (this.F) {
                return;
            }
            Q();
        }
    }

    public final void Q() {
        try {
            this.l.setText(getString(R.string.connecting));
            this.l.setTextColor(-65536);
            Intent prepare = VpnService.prepare(this);
            if (prepare != null) {
                SkStatus.updateStateString(Deobfuscator$BDNETVPN$app.getString(-59153916458891L), Deobfuscator$BDNETVPN$app.getString(-59239815804811L), R.string.state_user_vpn_permission, ConnectionStatus.LEVEL_WAITING_FOR_USER_INPUT);
                try {
                    startActivityForResult(prepare, 65);
                } catch (ActivityNotFoundException unused) {
                    SkStatus.logError(R.string.no_vpn_support_image);
                }
            } else {
                onActivityResult(65, -1, null);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.toString(), 1).show();
        }
    }

    public final void R() {
        C2882dV.y().x().d();
        FWPuncherService fWPuncherService = this.b;
        if (fWPuncherService != null && FWPuncherService.o) {
            fWPuncherService.getClass();
            FWPuncherService.o = false;
        }
        S();
        this.J.d.getClass();
        SkStatus.clearLog();
    }

    public final void S() {
        if (this.m.q().booleanValue()) {
            TunnelManagerHelper.stopPsiphon(this);
        } else if (this.m.t().booleanValue()) {
            TunnelManagerHelper.stopSocksHttp(this);
        } else if (this.m.u().booleanValue()) {
            TunnelManagerHelper.stopXRay(this);
        } else if (this.m.p().booleanValue() && this.m.s().booleanValue()) {
            TunnelManagerHelper.stopSsh(this);
        }
        u(true);
        getApplicationContext().deleteFile(Deobfuscator$BDNETVPN$app.getString(-59244110772107L));
    }

    public final void T(long j) {
        this.C = new CountDownTimerC3163h10(this, j, 1).start();
    }

    @Override // prince.dastan.vpn.service.vpn.TunnelVpnManagerPsi.SocksListener, defpackage.VT, defpackage.M50, defpackage.InterfaceC0103Dp
    public final void addStatus(String str) {
        runOnUiThread(new RunnableC3320j1(22, this, str));
    }

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void onActivityResult(int i, int i2, Intent intent) {
        Log.d(Deobfuscator$BDNETVPN$app.getString(-65712331519883L), String.format(Deobfuscator$BDNETVPN$app.getString(-65755281192843L), Integer.valueOf(i), Integer.valueOf(i2)));
        if (i == 65) {
            if (this.m.q().booleanValue()) {
                TunnelManagerHelper.startPsiphon(this);
                this.D = Deobfuscator$BDNETVPN$app.getString(-65939964786571L);
                return;
            }
            if (this.m.t().booleanValue()) {
                TunnelManagerHelper.startSocksHttp(this);
                this.D = Deobfuscator$BDNETVPN$app.getString(-66008684263307L);
                return;
            } else if (!this.m.p().booleanValue()) {
                TunnelManagerHelper.startXRay(this);
                return;
            } else {
                if (this.m.s().booleanValue()) {
                    this.D = Deobfuscator$BDNETVPN$app.getString(-66043044001675L);
                    startService(new Intent(this, (Class<?>) FWPuncherService.class).setAction(Deobfuscator$BDNETVPN$app.getString(-66137533282187L)));
                    return;
                }
                return;
            }
        }
        if (i != 1001) {
            super.onActivityResult(i, i2, intent);
            return;
        }
        if (i2 != -1 || intent == null) {
            return;
        }
        try {
            String readLine = new BufferedReader(new InputStreamReader(getContentResolver().openInputStream(intent.getData()))).readLine();
            if (readLine == null) {
                readLine = Deobfuscator$BDNETVPN$app.getString(-67924239677323L);
            }
            JSONObject jSONObject = new JSONObject(PUtils.pDecrypt(getApplicationContext(), readLine));
            String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-66163303085963L));
            if (string.isEmpty()) {
                t(jSONObject);
            } else {
                N(string, jSONObject);
            }
        } catch (Exception unused) {
            SweetToast.error(this, Deobfuscator$BDNETVPN$app.getString(-66227727595403L));
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup radioGroup, int i) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        int i = 0;
        if (id != R.id.connect) {
            if (id == R.id.disconnect) {
                U3 u3 = new U3(this, R.style.MyDialogTheme);
                String string = getString(R.string.disconnect_header);
                Q3 q3 = (Q3) u3.c;
                q3.e = string;
                q3.g = getString(R.string.disconnect_confirmation);
                q3.n = false;
                u3.e(Deobfuscator$BDNETVPN$app.getString(-69861269927819L), new DialogInterfaceOnClickListenerC4579yw(2));
                u3.f(Deobfuscator$BDNETVPN$app.getString(-69874154829707L), new DialogInterfaceOnClickListenerC3003f10(this, 4));
                u3.g();
                return;
            }
            return;
        }
        int i2 = F00.a;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-169195273549707L))).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-57401569802123L));
            return;
        }
        if (this.m.f().contains(Deobfuscator$BDNETVPN$app.getString(-57504649017227L))) {
            try {
                JSONObject jSONObject = new JSONObject(RQ.a(this.B)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-57560483592075L)).getJSONObject(this.x.getSelectedItemPosition());
                String string2 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-57620613134219L));
                String string3 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-57676447709067L));
                String string4 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-57719397382027L));
                String string5 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-57792411826059L));
                Calendar calendar = Calendar.getInstance();
                String format = String.format(Deobfuscator$BDNETVPN$app.getString(-57848246400907L), Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)));
                if (!string2.isEmpty()) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Deobfuscator$BDNETVPN$app.getString(-57955620583307L));
                    if (simpleDateFormat.parse(format).after(simpleDateFormat.parse(string2))) {
                        SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-58028635027339L));
                        return;
                    }
                }
                if (!string3.isEmpty() && !string3.equals(y())) {
                    SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-58127419275147L));
                    return;
                }
                if (string4.equals(Deobfuscator$BDNETVPN$app.getString(-58294922999691L)) && !A().toLowerCase().contains(Deobfuscator$BDNETVPN$app.getString(-58316397836171L))) {
                    SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-58346462607243L));
                    return;
                } else if (string5.equals(Deobfuscator$BDNETVPN$app.getString(-58531146200971L)) && new TO(getApplicationContext(), i).c()) {
                    SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-58552621037451L));
                    return;
                }
            } catch (Exception e) {
                SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-58733009663883L) + e.getMessage());
            }
        }
        if (!this.m.p().booleanValue() && !this.m.s().booleanValue()) {
            R();
        }
        this.F = false;
        P();
        this.H = true;
    }

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        boolean z;
        super.onCreate(bundle);
        Thread.setDefaultUncaughtExceptionHandler(new C0491So(this));
        Log.d(Deobfuscator$BDNETVPN$app.getString(-44813020657547L), String.format(Deobfuscator$BDNETVPN$app.getString(-44855970330507L), getIntent().toString()));
        setContentView(R.layout.activity_main_drawer);
        String packageName = getPackageName();
        String charSequence = getApplicationInfo().loadLabel(getPackageManager()).toString();
        if (!packageName.equals(Deobfuscator$BDNETVPN$app.getString(-68843362678667L))) {
            System.exit(0);
        }
        if (!charSequence.equals(Deobfuscator$BDNETVPN$app.getString(-68946441893771L))) {
            System.exit(0);
        }
        String packageName2 = getPackageName();
        String charSequence2 = getApplicationInfo().loadLabel(getPackageManager()).toString();
        if (!packageName2.equals(Deobfuscator$BDNETVPN$app.getString(-68693038823307L))) {
            System.exit(0);
        }
        if (!charSequence2.equals(Deobfuscator$BDNETVPN$app.getString(-68796118038411L))) {
            System.exit(0);
        }
        String packageName3 = getPackageName();
        String charSequence3 = getApplicationInfo().loadLabel(getPackageManager()).toString();
        if (!packageName3.equals(Deobfuscator$BDNETVPN$app.getString(-68993686534027L))) {
            System.exit(0);
        }
        if (!charSequence3.equals(Deobfuscator$BDNETVPN$app.getString(-69096765749131L))) {
            System.exit(0);
        }
        String packageName4 = getPackageName();
        String charSequence4 = getApplicationInfo().loadLabel(getPackageManager()).toString();
        if (!packageName4.equals(Deobfuscator$BDNETVPN$app.getString(-68542714967947L))) {
            System.exit(0);
        }
        if (!charSequence4.equals(Deobfuscator$BDNETVPN$app.getString(-68645794183051L))) {
            System.exit(0);
        }
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        String packageName5 = getPackageName();
        String charSequence5 = getApplicationInfo().loadLabel(getPackageManager()).toString();
        if (!packageName5.equals(Deobfuscator$BDNETVPN$app.getString(-44959049545611L))) {
            System.exit(0);
        }
        if (!charSequence5.equals(Deobfuscator$BDNETVPN$app.getString(-45062128760715L))) {
            System.exit(0);
        }
        this.m = C0223If.d(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        QQ qq = new QQ();
        qq.a = defaultSharedPreferences.edit();
        this.Z = qq;
        RQ rq = new RQ(this);
        C2882dV c2882dV = new C2882dV(23, false);
        c2882dV.b = rq;
        this.j = c2882dV;
        this.d = (RipplePulseLayout) findViewById(R.id.button_group);
        this.k = (Spinner) findViewById(R.id.profile);
        this.l = (TextView) findViewById(R.id.status);
        this.g = (Button) findViewById(R.id.connect);
        this.h = (Button) findViewById(R.id.disconnect);
        this.i = (TextView) findViewById(R.id.duration);
        this.e = (TextView) findViewById(R.id.bytes_in);
        this.f = (TextView) findViewById(R.id.bytes_out);
        this.y = (CircleProgressBar) findViewById(R.id.custom_progressBar);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.k.setOnItemSelectedListener(this);
        this.p = findViewById(R.id.server_layout);
        this.o = findViewById(R.id.network_layout);
        this.t = (TextView) findViewById(R.id.config_version);
        this.u = (TextView) findViewById(R.id.build_version);
        this.G = (TextView) findViewById(R.id.local_ip);
        this.x = (Spinner) findViewById(R.id.network_spin);
        CheckBox checkBox = (CheckBox) findViewById(R.id.dnsForwardCheck);
        this.K = checkBox;
        checkBox.setChecked(this.m.c().booleanValue());
        if (this.m.c().booleanValue()) {
            this.K.setText(Deobfuscator$BDNETVPN$app.getString(-45113668368267L));
        } else {
            this.K.setText(Deobfuscator$BDNETVPN$app.getString(-45169502943115L));
        }
        this.K.setOnCheckedChangeListener(new X00(this, 2));
        C0910cm c0910cm = new C0910cm();
        c0910cm.a = this;
        new Handler();
        c0910cm.e = getApplicationContext();
        this.J = c0910cm;
        c0910cm.b = (DrawerLayout) findViewById(R.id.drawerLayout);
        c0910cm.c = (RecyclerView) findViewById(R.id.recyclerDrawerView);
        DrawerLayout drawerLayout = c0910cm.b;
        if (drawerLayout.t == null) {
            drawerLayout.t = new ArrayList();
        }
        drawerLayout.t.add(this);
        boolean z2 = true;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        ViewOnTouchListenerC4212uD viewOnTouchListenerC4212uD = new ViewOnTouchListenerC4212uD();
        viewOnTouchListenerC4212uD.d = new Vector();
        viewOnTouchListenerC4212uD.e = new Vector();
        viewOnTouchListenerC4212uD.j = new Vector();
        viewOnTouchListenerC4212uD.k = -100;
        viewOnTouchListenerC4212uD.l = 3;
        viewOnTouchListenerC4212uD.g = this;
        viewOnTouchListenerC4212uD.i = linearLayoutManager;
        C0223If d = C0223If.d(this);
        d.getClass();
        if (d.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-159789295171467L), false)) {
            viewOnTouchListenerC4212uD.l = SkStatus.LogLevel.DEBUG.getInt();
        }
        viewOnTouchListenerC4212uD.d.clear();
        Collections.addAll(viewOnTouchListenerC4212uD.d, SkStatus.getlogbuffer());
        viewOnTouchListenerC4212uD.g();
        if (viewOnTouchListenerC4212uD.f == null) {
            viewOnTouchListenerC4212uD.f = new Handler(viewOnTouchListenerC4212uD);
        }
        SkStatus.addLogListener(viewOnTouchListenerC4212uD);
        c0910cm.d = viewOnTouchListenerC4212uD;
        viewOnTouchListenerC4212uD.h = c0910cm;
        c0910cm.c.setAdapter(viewOnTouchListenerC4212uD);
        c0910cm.c.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager2 = c0910cm.d.i;
        linearLayoutManager2.o0(linearLayoutManager2.B() - 1);
        c0910cm.b.setDrawerLockMode(0);
        K();
        this.r = new ArrayList();
        C3004f2 c3004f2 = new C3004f2(this, R.layout.server_item_drop, this.r);
        SharedPreferences defaultSharedPreferences2 = PreferenceManager.getDefaultSharedPreferences(this);
        c3004f2.a = defaultSharedPreferences2;
        defaultSharedPreferences2.edit();
        this.q = c3004f2;
        this.k.setAdapter((SpinnerAdapter) c3004f2);
        G();
        this.a0 = new ArrayList();
        C2924e2 c2924e2 = new C2924e2(this, this.a0, false);
        this.b0 = c2924e2;
        this.x.setAdapter((SpinnerAdapter) c2924e2);
        this.x.setOnTouchListener(new ViewOnTouchListenerC3543lm(this, 1));
        F();
        try {
            this.x.setSelection(this.m.h());
        } catch (IndexOutOfBoundsException unused) {
            this.x.setSelection(0);
        }
        try {
            Spinner spinner = this.k;
            C0223If c0223If = this.m;
            c0223If.getClass();
            spinner.setSelection(c0223If.a.getInt(Deobfuscator$BDNETVPN$app.getString(-157976818972555L), 0));
        } catch (IndexOutOfBoundsException unused2) {
            this.k.setSelection(0);
        }
        this.t.setText(getString(R.string.config_three) + Deobfuscator$BDNETVPN$app.getString(-45246812354443L) + x());
        TextView textView = this.u;
        StringBuilder sb = new StringBuilder();
        sb.append(getString(R.string.build_three));
        sb.append(Deobfuscator$BDNETVPN$app.getString(-45255402289035L));
        try {
            string = String.valueOf(getPackageManager().getPackageInfo(getPackageName(), 0).versionCode);
        } catch (PackageManager.NameNotFoundException unused3) {
            string = Deobfuscator$BDNETVPN$app.getString(-45109373400971L);
        }
        sb.append(string);
        textView.setText(sb.toString());
        this.G.setText(getString(R.string.ip_three) + Deobfuscator$BDNETVPN$app.getString(-45263992223627L) + z() + Deobfuscator$BDNETVPN$app.getString(-45272582158219L) + A());
        this.x.setOnItemSelectedListener(this);
        findViewById(R.id.flippy).setOnClickListener(new ViewOnClickListenerC0848c10(this, 1));
        findViewById(R.id.notiffy).setOnClickListener(new ViewOnClickListenerC0848c10(this, 2));
        I();
        if (SkStatus.isTunnelActive() && SkStatus.getLastState().equals(Deobfuscator$BDNETVPN$app.getString(-45281172092811L))) {
            addStatus(Deobfuscator$BDNETVPN$app.getString(-45324121765771L));
        } else if (SkStatus.isTunnelActive()) {
            addStatus(Deobfuscator$BDNETVPN$app.getString(-45367071438731L));
        }
        this.n = false;
        s();
        if (C2996ex.i == null) {
            C2996ex.i = new C2996ex(this);
        }
        C2996ex c2996ex = C2996ex.i;
        c2996ex.getClass();
        c2996ex.c = Deobfuscator$BDNETVPN$app.getString(-45474445621131L);
        c2996ex.g();
        c2996ex.d = Deobfuscator$BDNETVPN$app.getString(-45629064443787L);
        c2996ex.g();
        c2996ex.e = this;
        c2996ex.b.getAppUpdateInfo().addOnSuccessListener(new C0270Ka(c2996ex, z2));
        S50.c(getApplicationContext());
        C0456Rf c0456Rf = new C0456Rf();
        zzj zzb = zza.zza(this).zzb();
        this.c0 = zzb;
        zzb.requestConsentInfoUpdate(this, c0456Rf, new C0407Pi(this), new C4227uS(6));
        if (Build.VERSION.SDK_INT >= 33 && AbstractC3131gc0.g(this, Deobfuscator$BDNETVPN$app.getString(-56581231048587L)) != 0) {
            if (shouldShowRequestPermissionRationale(Deobfuscator$BDNETVPN$app.getString(-56744439805835L))) {
                SweetToast.info(getApplicationContext(), getString(R.string.notif_msg));
            } else {
                this.e0.a(Deobfuscator$BDNETVPN$app.getString(-56907648563083L));
            }
        }
        if (this.m.i().intValue() != 3) {
            C0223If c0223If2 = this.m;
            int intValue = c0223If2.i().intValue() + 1;
            QQ qq2 = c0223If2.b;
            qq2.putInt(Deobfuscator$BDNETVPN$app.getString(-161064900458379L), intValue);
            qq2.apply();
        }
        try {
            string2 = h().getString(Deobfuscator$BDNETVPN$app.getString(-48283354232715L));
        } catch (JSONException unused4) {
            string2 = Deobfuscator$BDNETVPN$app.getString(-48330598872971L);
        }
        String str = null;
        if (string2.equals(Deobfuscator$BDNETVPN$app.getString(-45650539280267L)) && this.m.i().intValue() == 3) {
            C2882dV c2882dV2 = this.j;
            String string6 = Deobfuscator$BDNETVPN$app.getString(-45672014116747L);
            c2882dV2.getClass();
            try {
                z = ((RQ) c2882dV2.b).getBoolean(string6, true);
                Log.d("PrefUtil", "get_boolean: " + string6 + "=" + z);
            } catch (ClassCastException unused5) {
                Log.d("PrefUtil", "get_boolean " + string6 + " class cast exception");
                z = true;
            }
            if (z) {
                U3 u3 = new U3(this, R.style.MyDialogTheme);
                TextView textView2 = new TextView(this);
                textView2.setText(getString(R.string.reminder_msg));
                textView2.setTextSize(12.0f);
                textView2.setTextColor(-1);
                textView2.setTypeface(Typeface.MONOSPACE);
                textView2.setPadding(50, 30, 50, 30);
                textView2.setGravity(8388611);
                textView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                String string7 = Deobfuscator$BDNETVPN$app.getString(-68263542093707L);
                Q3 q3 = (Q3) u3.c;
                q3.e = string7;
                q3.r = textView2;
                q3.c = R.drawable.ic_app_icon;
                u3.e(Deobfuscator$BDNETVPN$app.getString(-68306491766667L), null);
                u3.g();
                this.j.D(Deobfuscator$BDNETVPN$app.getString(-45757913462667L), false);
            }
        }
        try {
            string3 = h().getString(Deobfuscator$BDNETVPN$app.getString(-48356368676747L));
        } catch (JSONException unused6) {
            string3 = Deobfuscator$BDNETVPN$app.getString(-48395023382411L);
        }
        if (string3.equals(Deobfuscator$BDNETVPN$app.getString(-45843812808587L))) {
            L();
        }
        C0223If c0223If3 = this.m;
        try {
            string4 = h().getString(Deobfuscator$BDNETVPN$app.getString(-48133030377355L));
        } catch (JSONException unused7) {
            string4 = Deobfuscator$BDNETVPN$app.getString(-48184569984907L);
        }
        ZT.q(-161404202874763L, c0223If3.b, string4);
        C0223If c0223If4 = this.m;
        try {
            str = h().getString(Deobfuscator$BDNETVPN$app.getString(-68327966603147L));
        } catch (JSONException unused8) {
        }
        ZT.q(-162151527184267L, c0223If4.b, str);
        C0223If c0223If5 = this.m;
        try {
            string5 = h().getString(Deobfuscator$BDNETVPN$app.getString(-48480922728331L));
        } catch (JSONException unused9) {
            string5 = Deobfuscator$BDNETVPN$app.getString(-48523872401291L);
        }
        QQ qq3 = c0223If5.b;
        qq3.putString(Deobfuscator$BDNETVPN$app.getString(-163263923713931L), string5);
        qq3.apply();
        D(getIntent());
        if (this.b == null) {
            bindService(new Intent(this, (Class<?>) FWPuncherService.class), this.c, 1);
        }
        SkStatus.addStateListener(this);
        TunnelVpnManagerPsi.setSocksListener(this);
        FWPuncherService.r = this;
        FWPuncherService.s = this;
        SocksDNSService.H = this;
        SocksDNSService.G = this;
        PsiphonDNSService.n = this;
        XRayDNSService.F = this;
        XRayDNSService.E = this;
        AbstractC3623mn.a(this);
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // defpackage.I4, androidx.fragment.app.q, android.app.Activity
    public final void onDestroy() {
        SkStatus.removeStateListener(this);
        SkStatus.removeLogListener(this.J.d);
        if (this.b != null) {
            unbindService(this.c);
            this.b = null;
        }
        Log.d(Deobfuscator$BDNETVPN$app.getString(-56250518566795L), Deobfuscator$BDNETVPN$app.getString(-56293468239755L));
        super.onDestroy();
    }

    @Override // defpackage.InterfaceC0644Yl
    public void onDrawerClosed(View view) {
        view.getId();
    }

    @Override // defpackage.InterfaceC0644Yl
    public void onDrawerOpened(View view) {
        view.getId();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i, long j) {
        if (adapterView.getId() == R.id.network_spin) {
            try {
                JSONObject jSONObject = new JSONObject(RQ.a(this.B)).getJSONArray(Deobfuscator$BDNETVPN$app.getString(-65128215967627L)).getJSONObject(this.x.getSelectedItemPosition());
                H(jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65188345509771L)));
                QQ qq = this.Z;
                qq.putString(f0, jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65227000215435L)));
                qq.apply();
                C0223If c0223If = this.m;
                String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65287129757579L));
                QQ qq2 = c0223If.b;
                qq2.putString(Deobfuscator$BDNETVPN$app.getString(-157482897733515L), string);
                qq2.apply();
                C0223If c0223If2 = this.m;
                String string2 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65321489495947L));
                QQ qq3 = c0223If2.b;
                qq3.putString(Deobfuscator$BDNETVPN$app.getString(-157624631654283L), string2);
                qq3.apply();
                C0223If c0223If3 = this.m;
                String string3 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65360144201611L));
                QQ qq4 = c0223If3.b;
                qq4.putString(Deobfuscator$BDNETVPN$app.getString(-160747072878475L), string3);
                qq4.apply();
                C0223If c0223If4 = this.m;
                String string4 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65403093874571L));
                QQ qq5 = c0223If4.b;
                qq5.putString(Deobfuscator$BDNETVPN$app.getString(-160880216864651L), string4);
                qq5.apply();
                C0223If c0223If5 = this.m;
                String string5 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65458928449419L));
                QQ qq6 = c0223If5.b;
                qq6.putString(Deobfuscator$BDNETVPN$app.getString(-161520166991755L), string5);
                qq6.apply();
                C0223If c0223If6 = this.m;
                String string6 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65519057991563L));
                QQ qq7 = c0223If6.b;
                qq7.putString(Deobfuscator$BDNETVPN$app.getString(-161670490847115L), string6);
                qq7.apply();
                C0223If c0223If7 = this.m;
                String string7 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65566302631819L));
                QQ qq8 = c0223If7.b;
                qq8.putString(Deobfuscator$BDNETVPN$app.getString(-161782159996811L), string7);
                qq8.apply();
                C0223If c0223If8 = this.m;
                String string8 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-65639317075851L));
                QQ qq9 = c0223If8.b;
                qq9.putString(Deobfuscator$BDNETVPN$app.getString(-161971138557835L), string8);
                qq9.apply();
                C0223If c0223If9 = this.m;
                int selectedItemPosition = this.x.getSelectedItemPosition();
                QQ qq10 = c0223If9.b;
                qq10.putInt(Deobfuscator$BDNETVPN$app.getString(-158084193154955L), selectedItemPosition);
                qq10.apply();
            } catch (Exception unused) {
            }
        }
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d(Deobfuscator$BDNETVPN$app.getString(-55941280921483L), String.format(Deobfuscator$BDNETVPN$app.getString(-55984230594443L), intent.toString()));
        setIntent(intent);
        D(intent);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.menu_update) {
            this.n = true;
            SweetToast.info(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-56100194711435L));
            s();
            return true;
        }
        if (itemId != R.id.menu_clear_data) {
            return super.onOptionsItemSelected(menuItem);
        }
        U3 u3 = new U3(this, R.style.MyDialogTheme);
        String string = Deobfuscator$BDNETVPN$app.getString(-58767369402251L);
        Q3 q3 = (Q3) u3.c;
        q3.e = string;
        q3.g = Deobfuscator$BDNETVPN$app.getString(-58814614042507L);
        u3.f(Deobfuscator$BDNETVPN$app.getString(-59110966785931L), new DialogInterfaceOnClickListenerC3003f10(this, 2));
        u3.e(Deobfuscator$BDNETVPN$app.getString(-59123851687819L), null);
        u3.g();
        return true;
    }

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr.length != 0) {
            if (i != 99) {
                if (i != 530) {
                    return;
                }
                SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-57070857320331L));
                return;
            }
            if (iArr.length > 0) {
                for (int i2 : iArr) {
                    if (i2 == 0) {
                        C2853d6 c2853d6 = new C2853d6(14, false);
                        c2853d6.b = new File("/mnt");
                        c2853d6.c = new File("/mnt");
                        c2853d6.d = new File("/mnt");
                        c2853d6.b = Environment.getExternalStorageDirectory();
                        DialogC4336vq dialogC4336vq = new DialogC4336vq(this);
                        dialogC4336vq.l = null;
                        dialogC4336vq.m = null;
                        dialogC4336vq.n = null;
                        dialogC4336vq.a = this;
                        dialogC4336vq.f = c2853d6;
                        dialogC4336vq.i = new C3228hp(c2853d6);
                        dialogC4336vq.h = new ArrayList();
                        dialogC4336vq.setTitle(Deobfuscator$BDNETVPN$app.getString(-55361460336523L));
                        dialogC4336vq.g = new W00(this);
                        String string = Deobfuscator$BDNETVPN$app.getString(-55443064715147L);
                        if (string != null) {
                            dialogC4336vq.m = string.toString();
                        } else {
                            dialogC4336vq.m = null;
                        }
                        String string2 = Deobfuscator$BDNETVPN$app.getString(-55473129486219L);
                        if (string2 != null) {
                            dialogC4336vq.n = string2.toString();
                        } else {
                            dialogC4336vq.n = null;
                        }
                        dialogC4336vq.show();
                    } else {
                        SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-57182526470027L));
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        heIran.get(this);
        UpdateDialogHelper.fetchUpdateInfoAndShowDialog(this);
        K();
        if (this.b == null) {
            bindService(new Intent(this, (Class<?>) FWPuncherService.class), this.c, 1);
        }
        SkStatus.addStateListener(this);
        TunnelVpnManagerPsi.setSocksListener(this);
        FWPuncherService.r = this;
        FWPuncherService.s = this;
        SocksDNSService.H = this;
        SocksDNSService.G = this;
        PsiphonDNSService.n = this;
        XRayDNSService.F = this;
        XRayDNSService.E = this;
        this.n = false;
        s();
        C0910cm c0910cm = this.J;
        C0223If d = C0223If.d(c0910cm.e);
        d.getClass();
        if (d.a.getBoolean(Deobfuscator$BDNETVPN$app.getString(-159789295171467L), false)) {
            c0910cm.d.l = 4;
        } else {
            c0910cm.d.l = 3;
        }
        this.G.setText(getString(R.string.ip_three) + Deobfuscator$BDNETVPN$app.getString(-56173209155467L) + z() + Deobfuscator$BDNETVPN$app.getString(-56181799090059L) + A());
        super.onResume();
    }

    public final void r() {
        U3 u3 = new U3(this, R.style.MyDialogTheme);
        String string = Deobfuscator$BDNETVPN$app.getString(-69474722871179L);
        Q3 q3 = (Q3) u3.c;
        q3.e = string;
        q3.g = Deobfuscator$BDNETVPN$app.getString(-69534852413323L);
        q3.n = false;
        u3.f(Deobfuscator$BDNETVPN$app.getString(-69839795091339L), new DialogInterfaceOnClickListenerC3003f10(this, 3));
        u3.g();
    }

    @Override // prince.dastan.vpn.service.vpn.TunnelVpnManagerPsi.SocksListener, defpackage.VT
    public final void restartSocksOpenVPN() {
        runOnUiThread(new RunnableC3243i10(this, 3));
    }

    public final void s() {
        C3599mV c3599mV = new C3599mV(Deobfuscator$BDNETVPN$app.getString(-54854654195595L), new C3083g10(this), new C0407Pi(this));
        File file = new File(getCacheDir(), "volley");
        try {
            int i = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        C3986rO c3986rO = new C3986rO(new C4489xl(file), new C4156ta(new C3393jw()));
        C0037Bb c0037Bb = c3986rO.j;
        if (c0037Bb != null) {
            c0037Bb.e = true;
            c0037Bb.interrupt();
        }
        int i2 = 0;
        while (true) {
            QH[] qhArr = c3986rO.i;
            if (i2 >= qhArr.length) {
                break;
            }
            QH qh = qhArr[i2];
            if (qh != null) {
                qh.e = true;
                qh.interrupt();
            }
            i2++;
        }
        C0037Bb c0037Bb2 = new C0037Bb(c3986rO.d, c3986rO.e, c3986rO.f, c3986rO.h);
        c3986rO.j = c0037Bb2;
        c0037Bb2.start();
        for (int i3 = 0; i3 < c3986rO.i.length; i3++) {
            QH qh2 = new QH(c3986rO.e, c3986rO.g, c3986rO.f, c3986rO.h);
            c3986rO.i[i3] = qh2;
            qh2.start();
        }
        c3599mV.g = c3986rO;
        synchronized (c3986rO.c) {
            c3986rO.c.add(c3599mV);
        }
        c3599mV.f = Integer.valueOf(c3986rO.a.incrementAndGet());
        c3599mV.a("add-to-queue");
        if (!c3599mV.h) {
            c3986rO.e.add(c3599mV);
            return;
        }
        synchronized (c3986rO.b) {
            try {
                String c = c3599mV.c();
                if (c3986rO.b.containsKey(c)) {
                    Queue queue = (Queue) c3986rO.b.get(c);
                    if (queue == null) {
                        queue = new LinkedList();
                    }
                    queue.add(c3599mV);
                    c3986rO.b.put(c, queue);
                    if (Y20.a) {
                        Y20.c("Request for cacheKey=%s is in flight, putting on hold.", c);
                    }
                } else {
                    c3986rO.b.put(c, null);
                    c3986rO.d.add(c3599mV);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // prince.dastan.vpn.service.vpn.TunnelVpnManagerPsi.SocksListener, defpackage.VT, defpackage.M50
    public final void startSocksOpenVPN() {
        runOnUiThread(new RunnableC0334Mn(6));
    }

    @Override // prince.dastan.vpn.service.vpn.TunnelVpnManagerPsi.SocksListener, defpackage.VT, defpackage.M50, defpackage.InterfaceC0103Dp
    public final void stopSocksOpenVPN() {
        runOnUiThread(new RunnableC3243i10(this, 2));
    }

    public final void t(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-66640044455819L));
            String string2 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-66695879030667L));
            String string3 = jSONObject.getString(Deobfuscator$BDNETVPN$app.getString(-66738828703627L));
            Calendar calendar = Calendar.getInstance();
            String format = String.format(Deobfuscator$BDNETVPN$app.getString(-66794663278475L), Integer.valueOf(calendar.get(1)), Integer.valueOf(calendar.get(2) + 1), Integer.valueOf(calendar.get(5)), Integer.valueOf(calendar.get(11)), Integer.valueOf(calendar.get(12)));
            if (!string.isEmpty()) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Deobfuscator$BDNETVPN$app.getString(-66902037460875L));
                if (simpleDateFormat.parse(format).after(simpleDateFormat.parse(string))) {
                    SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-66975051904907L));
                    return;
                }
            }
            if (!string2.isEmpty() && !string2.equals(y())) {
                SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-67073836152715L));
                return;
            }
            if (string3.equals(Deobfuscator$BDNETVPN$app.getString(-67241339877259L)) && new TO(getApplicationContext(), 0).c()) {
                SweetToast.error(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-67262814713739L));
                return;
            }
            String optString = jSONObject.optString(Deobfuscator$BDNETVPN$app.getString(-67443203340171L), Deobfuscator$BDNETVPN$app.getString(-67503332882315L));
            JSONObject h = h();
            JSONArray jSONArray = h.getJSONArray(Deobfuscator$BDNETVPN$app.getString(-67507627849611L));
            String str = optString;
            int i = 1;
            loop0: while (true) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    if (str.equalsIgnoreCase(jSONArray.getJSONObject(i2).optString(Deobfuscator$BDNETVPN$app.getString(-67928534644619L), Deobfuscator$BDNETVPN$app.getString(-67988664186763L)))) {
                        break;
                    }
                }
                str = optString + Deobfuscator$BDNETVPN$app.getString(-67546282555275L) + i + Deobfuscator$BDNETVPN$app.getString(-67559167457163L);
                i++;
            }
            jSONObject.put(Deobfuscator$BDNETVPN$app.getString(-67567757391755L), str);
            jSONArray.put(jSONObject);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(getFilesDir(), Deobfuscator$BDNETVPN$app.getString(-67627886933899L)));
            fileOutputStream.write(F00.b(h.toString(2)).getBytes());
            fileOutputStream.close();
            SweetToast.success(this, Deobfuscator$BDNETVPN$app.getString(-67679426541451L));
            F();
            int i3 = 0;
            while (i3 < this.a0.size()) {
                if (str.equals(((JSONObject) this.a0.get(i3)).getString(Deobfuscator$BDNETVPN$app.getString(-67799685625739L)))) {
                    this.x.setSelection(i3 == 0 ? 1 : 0);
                    this.x.postDelayed(new L00(this, i3, 2), 100L);
                }
                i3++;
            }
        } catch (Exception e) {
            SweetToast.error(this, Deobfuscator$BDNETVPN$app.getString(-67859815167883L) + e.getMessage());
        }
    }

    public final void u(boolean z) {
        if (z) {
            findViewById(R.id.graph_layout).setVisibility(8);
            this.h.setVisibility(8);
            this.g.setVisibility(0);
        } else {
            findViewById(R.id.graph_layout).setVisibility(0);
            this.h.setVisibility(0);
            this.g.setVisibility(8);
        }
        this.p.setEnabled(z);
        this.o.setEnabled(z);
        this.x.setEnabled(z);
        this.k.setEnabled(z);
        this.K.setEnabled(z);
    }

    @Override // prince.dastan.vpn.service.vpn.logger.SkStatus.StateListener
    public final void updateState(String str, String str2, int i, ConnectionStatus connectionStatus, Intent intent) {
        runOnUiThread(new RunnableC3243i10(this, 5));
    }

    public final String w() {
        try {
            return h().getString(Deobfuscator$BDNETVPN$app.getString(-48008476325771L));
        } catch (JSONException unused) {
            return Deobfuscator$BDNETVPN$app.getString(-48047131031435L);
        }
    }

    public final String x() {
        Deobfuscator$BDNETVPN$app.getString(-47634814171019L);
        try {
            return h().getString(Deobfuscator$BDNETVPN$app.getString(-47720713516939L));
        } catch (JSONException unused) {
            return Deobfuscator$BDNETVPN$app.getString(-47755073255307L);
        }
    }

    public final String z() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService(Deobfuscator$BDNETVPN$app.getString(-45865287645067L))).getActiveNetworkInfo();
        return (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? Deobfuscator$BDNETVPN$app.getString(-45921122219915L) : TunnelUtils.getLocalIpAddress();
    }
}
