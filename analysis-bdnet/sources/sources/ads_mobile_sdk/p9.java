package ads_mobile_sdk;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import defpackage.C4129pc0;
import defpackage.Jb0;
import defpackage.Xb0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class p9 {
    public final n9 a;
    public Xb0 c;
    public r9 d;
    public final String g;
    public final mv h;
    public final ux0 b = new ux0();
    public boolean e = false;
    public boolean f = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b() {
        if (this.e || this.d == null) {
            return;
        }
        this.e = true;
        q9 q9Var = q9.c;
        boolean z = q9Var.b.size() > 0;
        q9Var.b.add(this);
        if (!z) {
            cf2 a = cf2.a();
            a.getClass();
            l9 l9Var = l9.d;
            l9Var.c = a;
            l9Var.a = true;
            boolean a2 = l9Var.a();
            l9Var.b = a2;
            l9Var.a(a2);
            rt3.g.getClass();
            if (rt3.i == null) {
                Handler handler = new Handler(Looper.getMainLooper());
                rt3.i = handler;
                handler.post(rt3.j);
                rt3.i.postDelayed(rt3.k, 200L);
            }
            pn0 pn0Var = a.d;
            pn0Var.h.submit(new g22(pn0Var, 2));
            pn0Var.b.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, pn0Var);
        }
        float f = cf2.a().a;
        r9 r9Var = this.d;
        G g = G.a;
        g.a((WebView) r9Var.b.get(), "setDeviceVolume", Float.valueOf(f), r9Var.a);
        r9 r9Var2 = this.d;
        Date date = o.f.b;
        Date date2 = date != null ? (Date) date.clone() : null;
        r9Var2.getClass();
        if (date2 != null) {
            JSONObject jSONObject = new JSONObject();
            pe2.a(jSONObject, "timestamp", Long.valueOf(date2.getTime()));
            g.a((WebView) r9Var2.b.get(), "setLastActivity", jSONObject);
        }
        r9 r9Var3 = this.d;
        ArrayList a3 = Cdo.a((Context) fa.b.a).a();
        r9Var3.getClass();
        try {
            JSONArray a4 = r9.a(a3);
            JSONObject jSONObject2 = new JSONObject();
            pe2.a(jSONObject2, "supportedAttestationMechanisms", a4);
            g.a((WebView) r9Var3.b.get(), "setSupportedAttestations", jSONObject2);
        } catch (JSONException e) {
            Log.e("OMIDLIB", "Error creating JSON object publishSupportedAttestationMechanisms", e);
        }
        this.d.a(this, this.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public p9(m9 m9Var, n9 n9Var, String str) {
        r9 c4129pc0;
        WebViewClient webViewClient;
        mv mvVar = new mv();
        mvVar.a = new Xb0(null);
        this.h = mvVar;
        this.a = n9Var;
        this.g = str;
        this.c = new Xb0(null);
        o9 o9Var = o9.b;
        o9 o9Var2 = (o9) n9Var.h;
        if (o9Var2 != o9Var && o9Var2 != o9.c) {
            c4129pc0 = new h22(str, Collections.unmodifiableMap((HashMap) n9Var.d));
        } else {
            c4129pc0 = new C4129pc0(str);
            WebView webView = (WebView) n9Var.b;
            if (webView != null && Build.VERSION.SDK_INT >= 26 && Cdo.a((Context) fa.b.a).a().size() > 0) {
                webViewClient = webView.getWebViewClient();
                webView.setWebViewClient(new cz3(webViewClient));
            }
            if (webView != null && !webView.getSettings().getJavaScriptEnabled()) {
                webView.getSettings().setJavaScriptEnabled(true);
            }
            c4129pc0.b = new Xb0(webView);
        }
        this.d = c4129pc0;
        this.d.c();
        q9.c.a.add(this);
        r9 r9Var = this.d;
        G g = G.a;
        WebView webView2 = (WebView) r9Var.b.get();
        JSONObject jSONObject = new JSONObject();
        pe2.a(jSONObject, "impressionOwner", m9Var.a);
        pe2.a(jSONObject, "mediaEventsOwner", m9Var.b);
        pe2.a(jSONObject, "creativeType", m9Var.d);
        pe2.a(jSONObject, "impressionType", m9Var.e);
        pe2.a(jSONObject, "isolateVerificationScripts", Boolean.valueOf(m9Var.c));
        g.a(webView2, "init", jSONObject, r9Var.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a() {
        if (this.f) {
            return;
        }
        mv mvVar = this.h;
        View view = (View) ((Xb0) mvVar.a).get();
        if (view != null) {
            s9 s9Var = (s9) mvVar.c;
            if (s9Var != null) {
                view.removeOnAttachStateChangeListener(s9Var);
                mvVar.c = null;
            }
            if (((Jb0) mvVar.b) != null) {
                if (view.getViewTreeObserver().isAlive()) {
                    view.getViewTreeObserver().removeOnWindowFocusChangeListener((Jb0) mvVar.b);
                }
                mvVar.b = null;
            }
        }
        ((Xb0) mvVar.a).clear();
        this.c.clear();
        if (!this.f) {
            this.b.a.clear();
        }
        this.f = true;
        r9 r9Var = this.d;
        G.a.a((WebView) r9Var.b.get(), "finishSession", r9Var.a);
        q9 q9Var = q9.c;
        boolean z = q9Var.b.size() > 0;
        q9Var.a.remove(this);
        ArrayList arrayList = q9Var.b;
        arrayList.remove(this);
        if (z && arrayList.size() <= 0) {
            cf2 a = cf2.a();
            a.getClass();
            rt3 rt3Var = rt3.g;
            rt3Var.getClass();
            Handler handler = rt3.i;
            if (handler != null) {
                handler.removeCallbacks(rt3.k);
                rt3.i = null;
            }
            rt3Var.a.clear();
            rt3.h.post(new g22(rt3Var, 3));
            l9 l9Var = l9.d;
            l9Var.a = false;
            l9Var.c = null;
            pn0 pn0Var = a.d;
            pn0Var.b.getContentResolver().unregisterContentObserver(pn0Var);
        }
        this.d.b();
        this.d = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(View view) {
        if (this.f || ((View) this.c.get()) == view) {
            return;
        }
        mv mvVar = this.h;
        View view2 = (View) ((Xb0) mvVar.a).get();
        if (view2 != null) {
            s9 s9Var = (s9) mvVar.c;
            if (s9Var != null) {
                view2.removeOnAttachStateChangeListener(s9Var);
                mvVar.c = null;
            }
            if (((Jb0) mvVar.b) != null) {
                if (view2.getViewTreeObserver().isAlive()) {
                    view2.getViewTreeObserver().removeOnWindowFocusChangeListener((Jb0) mvVar.b);
                }
                mvVar.b = null;
            }
        }
        ((Xb0) mvVar.a).clear();
        if (view != null) {
            mvVar.a = new Xb0(view);
            s9 s9Var2 = new s9(mvVar);
            mvVar.c = s9Var2;
            view.addOnAttachStateChangeListener(s9Var2);
            if (view.isAttachedToWindow()) {
                mvVar.a(view);
            }
        }
        this.c = new Xb0(view);
        this.d.a$2();
        Collection<p9> unmodifiableCollection = Collections.unmodifiableCollection(q9.c.a);
        if (unmodifiableCollection == null || unmodifiableCollection.isEmpty()) {
            return;
        }
        for (p9 p9Var : unmodifiableCollection) {
            if (p9Var != this && ((View) p9Var.c.get()) == view) {
                p9Var.c.clear();
            }
        }
    }
}
