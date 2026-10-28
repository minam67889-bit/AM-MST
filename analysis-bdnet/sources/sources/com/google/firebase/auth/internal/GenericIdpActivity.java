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
import com.google.android.gms.common.annotation.KeepName;
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
import com.google.android.gms.internal.p002firebaseauthapi.zzagq;
import com.google.android.gms.internal.p002firebaseauthapi.zzagr;
import com.google.android.gms.internal.p002firebaseauthapi.zzajg;
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
import defpackage.we0;
import defpackage.xe0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

@KeepName
/* loaded from: classes.dex */
public class GenericIdpActivity extends q implements zzaex {
    public static long b;
    public static final /* synthetic */ int c = 0;
    public boolean a = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        ne0 ne0Var = ne0.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Uri.Builder d(Uri.Builder builder, Intent intent, String str, String str2) {
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
        String zza = zzafa.zza(this, UUID.randomUUID().toString());
        String action = intent.getAction();
        String stringExtra5 = intent.getStringExtra("com.google.firebase.auth.internal.CLIENT_VERSION");
        Q60 q60 = Q60.d;
        Context applicationContext = getApplicationContext();
        String str4 = jSONObject;
        String str5 = join;
        synchronized (q60) {
            Preconditions.checkNotEmpty(str);
            Preconditions.checkNotEmpty(uuid);
            Preconditions.checkNotEmpty(zza);
            Preconditions.checkNotEmpty(stringExtra4);
            SharedPreferences u = Q60.u(applicationContext, str);
            Q60.v(u);
            SharedPreferences.Editor edit = u.edit();
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".SESSION_ID", zza);
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".OPERATION", action);
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".PROVIDER_ID", stringExtra2);
            edit.putString("com.google.firebase.auth.internal.EVENT_ID." + uuid + ".FIREBASE_APP_NAME", stringExtra4);
            edit.putString("com.google.firebase.auth.api.gms.config.tenant.id", stringExtra3);
            edit.apply();
        }
        String a = xe0.c(getApplicationContext(), C4374sq.e(stringExtra4).f()).a();
        if (TextUtils.isEmpty(a)) {
            Log.e("GenericIdpActivity", "Could not generate an encryption key for Generic IDP - cancelling flow.");
            e(H10.k("Failed to generate/retrieve public encryption key for Generic IDP flow."));
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void e(Status status) {
        b = 0L;
        this.a = false;
        Intent intent = new Intent();
        HashMap hashMap = oe0.a;
        SafeParcelableSerializer.serializeToIntentExtra(status, intent, "com.google.firebase.auth.internal.STATUS");
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        MQ.f(this).v(intent);
        ce0.a(getApplicationContext(), status);
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
        ce0.a(this, H10.k("WEB_CONTEXT_CANCELED"));
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC0914cf, defpackage.AbstractActivityC0838bf, android.app.Activity
    public final void onCreate(Bundle bundle) {
        y.׳شڬزڮ(this);
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(action) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(action) && !"android.intent.action.VIEW".equals(action)) {
            Log.e("GenericIdpActivity", "Could not do operation - unknown action: " + action);
            f();
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractActivityC0914cf, android.app.Activity
    public final void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.fragment.app.q, defpackage.AbstractActivityC0838bf, android.app.Activity
    public final void onResume() {
        we0 we0Var;
        y.ج֯ܬֱح(this);
        super.onResume();
        if (!"android.intent.action.VIEW".equals(getIntent().getAction())) {
            if (this.a) {
                f();
                return;
            }
            String packageName = getPackageName();
            try {
                String lowerCase = Hex.bytesToStringUppercase(AndroidUtilsLight.getPackageCertificateHashBytes(this, packageName)).toLowerCase(Locale.US);
                C4374sq e = C4374sq.e(getIntent().getStringExtra("com.google.firebase.auth.KEY_FIREBASE_APP_NAME"));
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(e);
                if (zzagq.zza(e)) {
                    e.a();
                    zza(d(Uri.parse(zzagq.zza(e.c.a)).buildUpon(), getIntent(), packageName, lowerCase).build(), packageName, firebaseAuth.p);
                } else {
                    new zzaev(packageName, lowerCase, getIntent(), e, this).executeOnExecutor(firebaseAuth.r, new Void[0]);
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.e("GenericIdpActivity", "Could not get package signature: " + packageName + " " + String.valueOf(e2));
                zzafa.zzb(this, packageName);
            }
            this.a = true;
            return;
        }
        Intent intent = getIntent();
        if (intent.hasExtra("firebaseError")) {
            e(oe0.a(intent.getStringExtra("firebaseError")));
            return;
        }
        if (!intent.hasExtra("link") || !intent.hasExtra("eventId")) {
            f();
            return;
        }
        String stringExtra = intent.getStringExtra("link");
        String stringExtra2 = intent.getStringExtra("eventId");
        String packageName2 = getPackageName();
        boolean booleanExtra = intent.getBooleanExtra("encryptionEnabled", true);
        synchronized (Q60.d) {
            Preconditions.checkNotEmpty(packageName2);
            Preconditions.checkNotEmpty(stringExtra2);
            SharedPreferences u = Q60.u(this, packageName2);
            String str = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".SESSION_ID";
            String str2 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".OPERATION";
            String str3 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".PROVIDER_ID";
            String str4 = "com.google.firebase.auth.internal.EVENT_ID." + stringExtra2 + ".FIREBASE_APP_NAME";
            we0Var = null;
            String string = u.getString(str, null);
            String string2 = u.getString(str2, null);
            String string3 = u.getString(str3, null);
            String string4 = u.getString("com.google.firebase.auth.api.gms.config.tenant.id", null);
            String string5 = u.getString(str4, null);
            SharedPreferences.Editor edit = u.edit();
            edit.remove(str);
            edit.remove(str2);
            edit.remove(str3);
            edit.remove(str4);
            edit.apply();
            if (string != null && string2 != null && string3 != null) {
                we0Var = new we0(string, string2, string3, string4, string5);
            }
        }
        if (we0Var == null) {
            f();
        }
        if (booleanExtra) {
            stringExtra = xe0.c(getApplicationContext(), C4374sq.e(we0Var.e).f()).b(stringExtra);
        }
        zzajg zzajgVar = new zzajg(we0Var, stringExtra);
        String str5 = we0Var.d;
        String str6 = we0Var.b;
        zzajgVar.zzb(str5);
        if (!"com.google.firebase.auth.internal.NONGMSCORE_SIGN_IN".equals(str6) && !"com.google.firebase.auth.internal.NONGMSCORE_LINK".equals(str6) && !"com.google.firebase.auth.internal.NONGMSCORE_REAUTHENTICATE".equals(str6)) {
            Log.e("GenericIdpActivity", "unsupported operation: " + str6);
            f();
            return;
        }
        b = 0L;
        this.a = false;
        Intent intent2 = new Intent();
        SafeParcelableSerializer.serializeToIntentExtra(zzajgVar, intent2, "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST");
        intent2.putExtra("com.google.firebase.auth.internal.OPERATION", str6);
        intent2.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        MQ.f(this).v(intent2);
        SharedPreferences.Editor edit2 = getApplicationContext().getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit2.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzajgVar));
        edit2.putString("operation", str6);
        edit2.putString("tenantId", str5);
        edit2.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit2.commit();
        finish();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.AbstractActivityC0914cf, defpackage.AbstractActivityC0838bf, android.app.Activity
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.a);
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
        Log.e("GenericIdpActivity", "Found hermetic configuration for identityToolkit URL: " + zza);
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final HttpURLConnection zza(URL url) {
        try {
            return (HttpURLConnection) zza.zza().zza(url, "client-firebase-auth-api");
        } catch (IOException unused) {
            Log.e("GenericIdpActivity", "Error generating URL connection");
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaex
    public final void zza(Uri uri, String str, InterfaceC3188dL interfaceC3188dL) {
        AbstractC4575vQ.B(interfaceC3188dL.get());
        Task forResult = Tasks.forResult(uri);
        C4142po c4142po = new C4142po(28, false);
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
