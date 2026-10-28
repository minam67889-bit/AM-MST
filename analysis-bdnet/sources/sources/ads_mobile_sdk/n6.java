package ads_mobile_sdk;

import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import defpackage.AbstractC3019f90;
import defpackage.C4086se0;
import defpackage.C4325vf0;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class n6 extends AbstractC3019f90 {
    public final l6 a;
    public C4325vf0 c;
    public p6 d;
    public final String g;
    public final xq0 b = new xq0();
    public boolean e = false;
    public boolean f = false;

    public n6(k6 k6Var, l6 l6Var, String str) {
        this.a = l6Var;
        this.g = str;
        c();
        if (l6Var.a() == m6.b || l6Var.a() == m6.c) {
            WebView d = l6Var.d();
            C4086se0 c4086se0 = new C4086se0(str);
            if (d != null && !d.getSettings().getJavaScriptEnabled()) {
                d.getSettings().setJavaScriptEnabled(true);
            }
            c4086se0.a(d);
            this.d = c4086se0;
        } else {
            this.d = new bs1(str, l6Var.c(), l6Var.b());
        }
        this.d.c();
        o6.a().a(this);
        this.d.a(k6Var);
    }

    @Override // defpackage.AbstractC3019f90
    public final void a() {
        if (this.f) {
            return;
        }
        this.c.clear();
        if (!this.f) {
            this.b.a.clear();
        }
        this.f = true;
        p6 p6Var = this.d;
        y22.a.a((WebView) p6Var.b.get(), "finishSession", p6Var.a);
        o6 o6Var = o6.c;
        boolean z = o6Var.b.size() > 0;
        o6Var.a.remove(this);
        o6Var.b.remove(this);
        if (z && o6Var.b.size() <= 0) {
            h42 a = h42.a();
            a.getClass();
            ne3 ne3Var = ne3.g;
            ne3Var.getClass();
            Handler handler = ne3.i;
            if (handler != null) {
                handler.removeCallbacks(ne3.k);
                ne3.i = null;
            }
            ne3Var.a.clear();
            ne3.h.post(new ke3(ne3Var));
            j6 j6Var = j6.d;
            j6Var.a = false;
            j6Var.c = null;
            hi0 hi0Var = a.d;
            hi0Var.b.getContentResolver().unregisterContentObserver(hi0Var);
        }
        this.d.b();
        this.d = null;
    }

    @Override // defpackage.AbstractC3019f90
    public final void b() {
        if (this.e || this.d == null) {
            return;
        }
        this.e = true;
        o6 o6Var = o6.c;
        boolean z = o6Var.b.size() > 0;
        o6Var.b.add(this);
        if (!z) {
            h42 a = h42.a();
            a.getClass();
            j6 j6Var = j6.d;
            j6Var.c = a;
            j6Var.b();
            ne3.g.getClass();
            if (ne3.i == null) {
                Handler handler = new Handler(Looper.getMainLooper());
                ne3.i = handler;
                handler.post(ne3.j);
                ne3.i.postDelayed(ne3.k, 200L);
            }
            hi0 hi0Var = a.d;
            hi0Var.h.submit(new gi0(hi0Var));
            hi0Var.b.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, hi0Var);
        }
        float f = h42.a().a;
        p6 p6Var = this.d;
        y22 y22Var = y22.a;
        y22Var.a((WebView) p6Var.b.get(), "setDeviceVolume", Float.valueOf(f), p6Var.a);
        p6 p6Var2 = this.d;
        Date date = p.f.b;
        Date date2 = date != null ? (Date) date.clone() : null;
        p6Var2.getClass();
        if (date2 != null) {
            JSONObject jSONObject = new JSONObject();
            u32.a(jSONObject, "timestamp", Long.valueOf(date2.getTime()));
            y22Var.a((WebView) p6Var2.b.get(), "setLastActivity", jSONObject);
        }
        this.d.a(this, this.a);
    }

    public final void c() {
        this.c = new C4325vf0(null);
    }

    @Override // defpackage.AbstractC3019f90
    public final void a(View view) {
        if (this.f || ((View) this.c.get()) == view) {
            return;
        }
        this.c = new C4325vf0(view);
        this.d.a();
        Collection<n6> unmodifiableCollection = Collections.unmodifiableCollection(o6.c.a);
        if (unmodifiableCollection == null || unmodifiableCollection.isEmpty()) {
            return;
        }
        for (n6 n6Var : unmodifiableCollection) {
            if (n6Var != this && ((View) n6Var.c.get()) == view) {
                n6Var.c.clear();
            }
        }
    }
}
