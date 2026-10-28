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
import com.google.android.gms.internal.p002firebaseauthapi.zzaev;
import com.google.android.gms.internal.p002firebaseauthapi.zzaex;
import com.google.android.gms.internal.p002firebaseauthapi.zzafa;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.internal.p002firebaseauthapi.zzagq;
import com.google.android.gms.internal.p002firebaseauthapi.zzagr;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import com.liapp.y;
import defpackage.AbstractC4575vQ;
import defpackage.C4142po;
import defpackage.C4374sq;
import defpackage.H10;
import defpackage.InterfaceC3188dL;
import defpackage.MQ;
import defpackage.Q60;
import defpackage.ce0;
import defpackage.ne0;
import defpackage.oe0;
import defpackage.xe0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class RecaptchaActivity extends q implements zzaex {
    public static long b;
    public static final ne0 c = ne0.b;
    public boolean a = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri.Builder d(Uri.Builder builder, Intent intent, String str, String str2) {
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String uuid = UUID.randomUUID().toString();
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME");
        C4374sq e = C4374sq.e(stringExtra3);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e);
        Q60 q60 = Q60.d;
        Context applicationContext = getApplicationContext();
        synchronized (q60) {
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotEmpty(uuid);
            SharedPreferences u = Q60.u(applicationContext, str);
            Q60.v(u);
            SharedPreferences.Editor edit = u.edit();
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".FIREBASE_APP_NAME", stringExtra3);
            edit.apply();
        }
        String a = xe0.c(getApplicationContext(), e.f()).a();
        String str3 = null;
        if (TextUtils.isEmpty(a)) {
            Log.e("RecaptchaActivity", "Could not generate an encryption key for reCAPTCHA - cancelling flow.");
            e(H10.k("Failed to generate/retrieve public encryption key for reCAPTCHA flow."));
            return null;
        }
        synchronized (firebaseAuth.g) {
        }
        if (TextUtils.isEmpty(null)) {
            str3 = zzafm.zza();
        }
        builder.appendQueryParameter("apiKey", stringExtra).appendQueryParameter("authType", "verifyApp").appendQueryParameter("apn", str).appendQueryParameter("hl", str3).appendQueryParameter("eventId", uuid).appendQueryParameter("v", "X" + stringExtra2).appendQueryParameter("eid", "p").appendQueryParameter("appName", stringExtra3).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", a);
        return builder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e(Status status) {
        b = 0L;
        this.a = false;
        Intent intent = new Intent();
        HashMap hashMap = oe0.a;
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        MQ.f(this).v(intent);
        c.a.getClass();
        Preconditions.checkNotNull(this);
        ce0.b(getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void f() {
        b = 0L;
        this.a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        MQ.f(this).v(intent);
        c.a.getClass();
        Preconditions.checkNotNull(this);
        ce0.b(getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC0914cf, defpackage.AbstractActivityC0838bf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        y.׳شڬزڮ(this);
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("RecaptchaActivity", "Could not do operation - unknown action: " + action);
            f();
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractActivityC0914cf, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC0838bf, android.app.Activity
    public final void onResume() {
        String string;
        boolean isEmpty;
        y.ج֯ܬֱح(this);
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.a) {
                f();
                return;
            }
            Intent intent = getIntent();
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                C4374sq e = C4374sq.e(intent.getStringExtra("com.google.firebase.auth.internal.FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e);
                if (zzagq.zza(e)) {
                    e.a();
                    zza(d(Uri.parse(zzagq.zza(e.c.a)).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.p);
                } else {
                    new zzaev(packageName, lowerCase, intent, e, this).executeOnExecutor(firebaseAuth.r, new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("RecaptchaActivity", "Could not get package signature: " + packageName + " " + String.valueOf(e2));
                zzafa.zzb(this, packageName);
            }
            this.a = true;
            return;
        }
        Intent intent2 = getIntent();
        if (intent2.hasExtra("firebaseError")) {
            e(oe0.a(intent2.getStringExtra("firebaseError")));
            return;
        }
        if (!intent2.hasExtra("link") || !intent2.hasExtra("eventId")) {
            f();
            return;
        }
        String stringExtra = intent2.getStringExtra("link");
        Q60 q60 = Q60.d;
        Context applicationContext = getApplicationContext();
        String packageName2 = getPackageName();
        String stringExtra2 = intent2.getStringExtra("eventId");
        synchronized (q60) {
            Preconditions.checkNotEmpty(packageName2);
            Preconditions.checkNotEmpty(stringExtra2);
            SharedPreferences u = Q60.u(applicationContext, packageName2);
            String str = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".OPERATION";
            String string2 = u.getString(str, null);
            String str2 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".FIREBASE_APP_NAME";
            string = u.getString(str2, null);
            SharedPreferences.Editor edit = u.edit();
            edit.remove(str);
            edit.remove(str2);
            edit.apply();
            isEmpty = TextUtils.isEmpty(string2);
        }
        String str3 = isEmpty ? null : string;
        if (TextUtils.isEmpty(str3)) {
            Log.e("RecaptchaActivity", "Failed to find registration for this event - failing to prevent session injection.");
            e(H10.k("Failed to find registration for this reCAPTCHA event"));
        }
        if (intent2.getBooleanExtra("encryptionEnabled", true)) {
            stringExtra = xe0.c(getApplicationContext(), C4374sq.e(str3).f()).b(stringExtra);
        }
        String queryParameter = Uri.parse(stringExtra).getQueryParameter("recaptchaToken");
        b = 0L;
        this.a = false;
        Intent intent3 = new Intent();
        intent3.putExtra("com.google.firebase.auth.internal.RECAPTCHA_TOKEN", queryParameter);
        intent3.putExtra("com.google.firebase.auth.internal.OPERATION", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        intent3.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        MQ.f(this).v(intent3);
        SharedPreferences.Editor edit2 = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit2.putString("recaptchaToken", queryParameter);
        edit2.putString("operation", "com.google.firebase.auth.internal.ACTION_SHOW_RECAPTCHA");
        edit2.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit2.commit();
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractActivityC0914cf, defpackage.AbstractActivityC0838bf, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_ALREADY_STARTED_RECAPTCHA_FLOW", this.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final Uri.Builder zza(Intent intent, String str, String str2) {
        return d(new Uri.Builder().scheme("https").appendPath("__").appendPath("auth").appendPath("handler"), intent, str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final String zza(String str) {
        String zza = zzagr.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza)) {
            return zzagq.zzb(str);
        }
        Log.e("RecaptchaActivity", "Found hermetic configuration for identityToolkit URL: " + zza);
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            zzaex.zza.e("Error generating connection", new Object[0]);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zza(Uri uri, String str, InterfaceC3188dL interfaceC3188dL) {
        AbstractC4575vQ.B(interfaceC3188dL.get());
        Task forResult = Tasks.forResult(uri);
        C4142po c4142po = new C4142po(29, false);
        c4142po.b = this;
        c4142po.c = str;
        forResult.addOnCompleteListener(c4142po);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zza(String str, Status status) {
        if (status == null) {
            f();
        } else {
            e(status);
        }
    }
}
