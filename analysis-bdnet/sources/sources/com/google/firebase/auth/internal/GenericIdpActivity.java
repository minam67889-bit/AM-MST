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
import com.google.android.gms.internal.p002firebaseauthapi.zzaft;
import com.google.android.gms.internal.p002firebaseauthapi.zzafu;
import com.google.android.gms.internal.p002firebaseauthapi.zzaij;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.FirebaseAuth;
import defpackage.B00;
import defpackage.C0213Hv;
import defpackage.C0493Sq;
import defpackage.C3298ig0;
import defpackage.FR;
import defpackage.Gg0;
import defpackage.Hg0;
import defpackage.ZL;
import defpackage.mg0;
import defpackage.wg0;
import defpackage.xg0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class GenericIdpActivity extends q implements zzaea {
    public static long b;
    public static final /* synthetic */ int c = 0;
    public boolean a = false;

    static {
        wg0 wg0Var = wg0.b;
    }

    public final Uri.Builder g(Uri.Builder builder, Intent intent, String str, String str2) {
        String jSONObject;
        String stringExtra = intent.getStringExtra("com.google.firebase.auth.KEY_API_KEY");
        String stringExtra2 = intent.getStringExtra("com.google.firebase.auth.KEY_PROVIDER_ID");
        String stringExtra3 = intent.getStringExtra("com.google.firebase.auth.KEY_TENANT_ID");
        String stringExtra4 = intent.getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("com.google.firebase.auth.KEY_PROVIDER_SCOPES");
        String join = (stringArrayListExtra == null || stringArrayListExtra.isEmpty()) ? null : TextUtils.join(",", stringArrayListExtra);
        Bundle bundleExtra = intent.getBundleExtra("com.google.firebase.auth.KEY_PROVIDER_CUSTOM_PARAMS");
        if (bundleExtra == null) {
            jSONObject = null;
        } else {
            JSONObject jSONObject2 = new JSONObject();
            try {
                for (String str3 : bundleExtra.keySet()) {
                    String string = bundleExtra.getString(str3);
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject2.put(str3, string);
                    }
                }
            } catch (JSONException unused) {
                Log.e("GenericIdpActivity", "Unexpected JSON exception when serializing developer specified custom params");
            }
            jSONObject = jSONObject2.toString();
        }
        String uuid = UUID.randomUUID().toString();
        String zza = zzaed.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        C0213Hv c0213Hv = C0213Hv.g;
        Context applicationContext = getApplicationContext();
        String str4 = jSONObject;
        String str5 = join;
        synchronized (c0213Hv) {
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotEmpty(uuid);
            Preconditions.checkNotEmpty(zza);
            Preconditions.checkNotEmpty(stringExtra4);
            SharedPreferences l = C0213Hv.l(applicationContext, str);
            C0213Hv.m(l);
            SharedPreferences.Editor edit = l.edit();
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".SESSION_ID", zza);
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".OPERATION", action);
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".PROVIDER_ID", stringExtra2);
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".FIREBASE_APP_NAME", stringExtra4);
            edit.putString("com.google.firebase.auth.api.gms.config.tenant.id", stringExtra3);
            edit.apply();
        }
        String a = Hg0.c(getApplicationContext(), C0493Sq.e(stringExtra4).f()).a();
        if (TextUtils.isEmpty(a)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            h(B00.s("Failed to generate/retrieve public encryption key for Generic IDP flow."));
            return null;
        }
        if (zza == null) {
            return null;
        }
        builder.appendQueryParameter("eid", "p").appendQueryParameter("v", "X" + stringExtra5).appendQueryParameter("authType", "signInWithRedirect").appendQueryParameter("apiKey", stringExtra).appendQueryParameter("providerId", stringExtra2).appendQueryParameter("sessionId", zza).appendQueryParameter("eventId", uuid).appendQueryParameter("apn", str).appendQueryParameter("sha1Cert", str2).appendQueryParameter("publicKey", a);
        if (!TextUtils.isEmpty(str5)) {
            builder.appendQueryParameter("scopes", str5);
        }
        if (!TextUtils.isEmpty(str4)) {
            builder.appendQueryParameter("customParameters", str4);
        }
        if (!TextUtils.isEmpty(stringExtra3)) {
            builder.appendQueryParameter("tid", stringExtra3);
        }
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
        mg0.a(getApplicationContext(), status);
        finish();
    }

    public final void i() {
        b = 0L;
        this.a = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        FR.g(this).l(intent);
        mg0.a(this, B00.s("WEB_CONTEXT_CANCELED"));
        finish();
    }

    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("GenericIdpActivity", "Could not do operation - unknown action: " + action);
            i();
            return;
        }
        long currentTimeMillis = DefaultClock.getInstance().currentTimeMillis();
        if (currentTimeMillis - b < 30000) {
            Log.e("GenericIdpActivity", "Could not start operation - already in progress");
            return;
        }
        b = currentTimeMillis;
        if (bundle != null) {
            this.a = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
        }
    }

    @Override // defpackage.AbstractActivityC4087sf, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override // androidx.fragment.app.q, android.app.Activity
    public final void onResume() {
        Gg0 gg0;
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.a) {
                i();
                return;
            }
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                C0493Sq e = C0493Sq.e(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e);
                if (zzaft.zza(e)) {
                    e.a();
                    zza(g(Uri.parse(zzaft.zza(e.c.a)).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.p);
                } else {
                    new zzady(packageName, lowerCase, getIntent(), e, this).executeOnExecutor(firebaseAuth.r, new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName + " " + String.valueOf(e2));
                zzaed.zzb(this, packageName);
            }
            this.a = true;
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("firebaseError")) {
            h(xg0.a(intent.getStringExtra("firebaseError")));
            return;
        }
        if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
            i();
            return;
        }
        String stringExtra = intent.getStringExtra("link");
        String stringExtra2 = intent.getStringExtra("eventId");
        String packageName2 = getPackageName();
        boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
        synchronized (C0213Hv.g) {
            Preconditions.checkNotEmpty(packageName2);
            Preconditions.checkNotEmpty(stringExtra2);
            SharedPreferences l = C0213Hv.l(this, packageName2);
            String str = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".SESSION_ID";
            String str2 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".OPERATION";
            String str3 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".PROVIDER_ID";
            String str4 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".FIREBASE_APP_NAME";
            gg0 = null;
            String string = l.getString(str, null);
            String string2 = l.getString(str2, null);
            String string3 = l.getString(str3, null);
            String string4 = l.getString("com.google.firebase.auth.api.gms.config.tenant.id", null);
            String string5 = l.getString(str4, null);
            SharedPreferences.Editor edit = l.edit();
            edit.remove(str);
            edit.remove(str2);
            edit.remove(str3);
            edit.remove(str4);
            edit.apply();
            if (string != null && string2 != null && string3 != null) {
                gg0 = new Gg0(string, string2, string3, string4, string5);
            }
        }
        if (gg0 == null) {
            i();
        }
        if (booleanExtra) {
            stringExtra = Hg0.c(getApplicationContext(), C0493Sq.e(gg0.e).f()).b(stringExtra);
        }
        zzaij zzaijVar = new zzaij(gg0, stringExtra);
        String str5 = gg0.d;
        String str6 = gg0.b;
        zzaijVar.zzb(str5);
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(str6) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(str6) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(str6)) {
            Log.e("GenericIdpActivity", "unsupported operation: ".concat(str6));
            i();
            return;
        }
        b = 0L;
        this.a = false;
        Intent intent2 = new Intent();
        SafeParcelableSerializer.serializeToIntentExtra(zzaijVar, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
        intent2.putExtra("com.google.firebase.auth.internal.OPERATION", str6);
        intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        FR.g(this).l(intent2);
        SharedPreferences.Editor edit2 = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit2.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzaijVar));
        edit2.putString("operation", str6);
        edit2.putString("tenantId", str5);
        edit2.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit2.commit();
        finish();
    }

    @Override // defpackage.AbstractActivityC4087sf, defpackage.AbstractActivityC4008rf, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.a);
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
        Log.e("GenericIdpActivity", "Found hermetic configuration for identityToolkit URL: " + zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaea
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
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
            C3298ig0 c3298ig0 = new C3298ig0(0);
            c3298ig0.c = this;
            c3298ig0.b = str;
            forResult.addOnCompleteListener(c3298ig0);
            return;
        }
        throw new ClassCastException();
    }
}
