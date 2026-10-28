package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.q;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Hex;
import com.google.android.gms.internal.p002firebaseauthapi.zza;
import com.google.android.gms.internal.p002firebaseauthapi.zzady;
import com.google.android.gms.internal.p002firebaseauthapi.zzaea;
import com.google.android.gms.internal.p002firebaseauthapi.zzaed;
import com.google.android.gms.internal.p002firebaseauthapi.zzaep;
import com.google.android.gms.internal.p002firebaseauthapi.zzaft;
import com.google.android.gms.internal.p002firebaseauthapi.zzafu;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import defpackage.B00;
import defpackage.C0213Hv;
import defpackage.C0493Sq;
import defpackage.C3298ig0;
import defpackage.FR;
import defpackage.Hg0;
import defpackage.ZL;
import defpackage.mg0;
import defpackage.wg0;
import defpackage.xg0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class RecaptchaActivity extends q implements zzaea {
    public static long b;
    public static final wg0 c = wg0.b;
    public boolean a = false;

    public final Uri.Builder g(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        C0493Sq e = C0493Sq.e(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e);
        C0213Hv c0213Hv = C0213Hv.g;
        Context applicationContext = getApplicationContext();
        synchronized (c0213Hv) {
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotEmpty(uuid);
            SharedPreferences l = C0213Hv.l(applicationContext, str);
            C0213Hv.m(l);
            SharedPreferences.Editor edit = l.edit();
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".FIREBASE_APP_NAME", stringExtra3);
            edit.apply();
        }
        String a = Hg0.c(getApplicationContext(), e.f()).a();
        String str3 = null;
        if (TextUtils.isEmpty(a)) {
            Log.e("RecaptchaActivity", "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            h(B00.s("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        synchronized (firebaseAuth.g) {
        }
        if (TextUtils.isEmpty(null)) {
            str3 = zzaep.zza();
        }
        builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", str3).appendQueryParameter("eventId", uuid).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", a);
        return builder;
    }

    public final void h(Status status) {
        b = 0L;
        this.a = false;
        Intent intent = new Intent();
        HashMap hashMap = xg0.a;
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        FR.g(this).l(intent);
        c.a.getClass();
        Preconditions.checkNotNull(this);
        mg0.b(getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        finish();
    }

    public final void i() {
        b = 0L;
        this.a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        FR.g(this).l(intent);
        c.a.getClass();
        Preconditions.checkNotNull(this);
        mg0.b(getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        finish();
    }

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("RecaptchaActivity", "Could not do operation - unknown action: " + action);
            i();
            return;
        }
        long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
        if (currentTimeMillis - b < 30000) {
            Log.e("RecaptchaActivity", "Could not start operation - already in progress");
            return;
        }
        b = currentTimeMillis;
        if (bundle != null) {
            this.a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW");
        }
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        RecaptchaActivity recaptchaActivity;
        String str;
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.a) {
                i();
                return;
            }
            Intent intent = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                C0493Sq e = C0493Sq.e(intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e);
                if (zzaft.zza(e)) {
                    recaptchaActivity = this;
                    e.a();
                    zza(g(Uri.parse(zzaft.zza(e.c.a)).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.p);
                } else {
                    recaptchaActivity = this;
                    new zzady(packageName, lowerCase, intent, e, recaptchaActivity).executeOnExecutor(firebaseAuth.r, new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                recaptchaActivity = this;
                Log.e("RecaptchaActivity", "Could not get package signature: " + packageName + " " + String.valueOf(e2));
                zzaed.zzb(this, packageName);
            }
            recaptchaActivity.a = true;
            return;
        }
        Intent intent2 = getIntent();
        if (intent2.hasExtra("firebaseError")) {
            h(xg0.a(intent2.getStringExtra("firebaseError")));
            return;
        }
        if (!intent2.hasExtra("link") || !intent2.hasExtra("eventId")) {
            i();
            return;
        }
        String stringExtra = intent2.getStringExtra("link");
        C0213Hv c0213Hv = C0213Hv.g;
        Context applicationContext = getApplicationContext();
        String packageName2 = getPackageName();
        String stringExtra2 = intent2.getStringExtra("eventId");
        synchronized (c0213Hv) {
            Preconditions.checkNotEmpty(packageName2);
            Preconditions.checkNotEmpty(stringExtra2);
            SharedPreferences l = C0213Hv.l(applicationContext, packageName2);
            String str2 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".OPERATION";
            str = null;
            String string = l.getString(str2, null);
            String str3 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".FIREBASE_APP_NAME";
            String string2 = l.getString(str3, null);
            SharedPreferences.Editor edit = l.edit();
            edit.remove(str2);
            edit.remove(str3);
            edit.apply();
            if (!TextUtils.isEmpty(string)) {
                str = string2;
            }
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("RecaptchaActivity", "Failed to find registration for this event - failing to prevent session injection.");
            h(B00.s("Failed to find registration for this reCAPTCHA event"));
        }
        if (intent2.getBooleanExtra("encryptionEnabled", true)) {
            stringExtra = Hg0.c(getApplicationContext(), C0493Sq.e(str).f()).b(stringExtra);
        }
        String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
        b = 0L;
        this.a = false;
        Intent intent3 = new Intent();
        intent3.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
        intent3.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent3.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        FR.g(this).l(intent3);
        SharedPreferences.Editor edit2 = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit2.putString("recaptchaToken", queryParameter);
        edit2.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        edit2.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit2.commit();
        finish();
    }

    @Override // defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.a);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return g(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final String zza(String str) {
        String zza = zzafu.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza)) {
            return zzaft.zzb(str);
        }
        Log.e("RecaptchaActivity", "Found hermetic configuration for identityToolkit URL: " + zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zzaea.zza.e("Error generating connection", new Object[0]);
            return null;
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final void zza(String str, Status status) {
        if (status == null) {
            i();
        } else {
            h(status);
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final void zza(Uri uri, String str, ZL zl) {
        if (zl.get() == null) {
            Task forResult = Tasks.forResult(uri);
            C3298ig0 c3298ig0 = new C3298ig0(1);
            c3298ig0.c = this;
            c3298ig0.b = str;
            forResult.addOnCompleteListener(c3298ig0);
            return;
        }
        throw new ClassCastException();
    }
}
