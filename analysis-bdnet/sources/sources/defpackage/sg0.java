package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzahd;
import com.google.android.gms.internal.p002firebaseauthapi.zzbm;
import com.google.android.gms.internal.p002firebaseauthapi.zzje;
import com.google.android.gms.internal.p002firebaseauthapi.zzmy;
import com.google.android.gms.internal.p002firebaseauthapi.zzzx;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class sg0 {
    public Context a;
    public String b;
    public SharedPreferences c;
    public Logger d;

    public final Zf0 a(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        C0825bg0 a;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String string3 = jSONObject.getString("version");
            String str = string3 != null ? string3 : "2";
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(Lg0.b(jSONArray3.getString(i)));
            }
            Zf0 zf0 = new Zf0(C0493Sq.e(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zf0.f = (zzahd) Preconditions.checkNotNull(zzahd.zzb(string));
            }
            if (!z) {
                zf0.m = Boolean.FALSE;
            }
            zf0.l = str;
            if (jSONObject.has("userMetadata") && (a = C0825bg0.a(jSONObject.getJSONObject("userMetadata"))) != null) {
                zf0.n = a;
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i2));
                    String optString = jSONObject2.optString("factorIdKey");
                    arrayList2.add("phone".equals(optString) ? ZJ.r(jSONObject2) : Objects.equals(optString, "totp") ? KX.r(jSONObject2) : null);
                }
                zf0.t(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList3.add(C2979eg0.q(new JSONObject(jSONArray.getString(i3))));
                }
                zf0.r = arrayList3;
            }
            return zf0;
        } catch (zzzx e) {
            e = e;
            this.d.wtf(e);
            return null;
        } catch (ArrayIndexOutOfBoundsException e2) {
            e = e2;
            this.d.wtf(e);
            return null;
        } catch (IllegalArgumentException e3) {
            e = e3;
            this.d.wtf(e);
            return null;
        } catch (JSONException e4) {
            e = e4;
            this.d.wtf(e);
            return null;
        }
    }

    public final void b(String str, String str2) {
        String encodeToString;
        qg0 a = qg0.a(this.a, this.b);
        a.getClass();
        Preconditions.checkNotNull(str2);
        zzmy zzmyVar = a.b;
        String str3 = null;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to encrypt data");
        } else {
            try {
                synchronized (zzmyVar) {
                    encodeToString = Base64.encodeToString(((zzbm) a.b.zza().zza(zzje.zza(), zzbm.class)).zzb(str2.getBytes(StandardCharsets.UTF_8), null), 2);
                }
                str3 = encodeToString;
            } catch (GeneralSecurityException e) {
                Log.e("FirebearStorageCryptoHelper", "Exception encountered while encrypting bytes:\n" + e.getMessage());
            }
        }
        if (str3 != null) {
            this.c.edit().putString(str, "ENCRYPTED:".concat(str3)).apply();
        }
    }

    public final String c(String str) {
        String str2;
        String string = this.c.getString(str, null);
        if (string == null) {
            return null;
        }
        if (!string.startsWith("ENCRYPTED:")) {
            return string;
        }
        qg0 a = qg0.a(this.a, this.b);
        String substring = string.substring(10);
        a.getClass();
        Preconditions.checkNotNull(substring);
        zzmy zzmyVar = a.b;
        if (zzmyVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to decrypt data");
            return null;
        }
        try {
            synchronized (zzmyVar) {
                str2 = new String(((zzbm) a.b.zza().zza(zzje.zza(), zzbm.class)).zza(Base64.decode(substring, 2), null), StandardCharsets.UTF_8);
            }
            return str2;
        } catch (IllegalArgumentException | GeneralSecurityException e) {
            Log.e("FirebearStorageCryptoHelper", "Exception encountered while decrypting bytes:\n" + e.getMessage());
            return null;
        }
    }
}
