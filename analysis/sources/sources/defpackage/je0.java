package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzaaw;
import com.google.android.gms.internal.p002firebaseauthapi.zzaia;
import com.google.android.gms.internal.p002firebaseauthapi.zzbm;
import com.google.android.gms.internal.p002firebaseauthapi.zzjg;
import com.google.android.gms.internal.p002firebaseauthapi.zznl;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class je0 {
    public Context a;
    public String b;
    public SharedPreferences c;
    public Logger d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Pd0 a(JSONObject jSONObject) {
        JSONArray jSONArray;
        JSONArray jSONArray2;
        SafeParcelable safeParcelable;
        Sd0 a;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = "2";
            String string3 = jSONObject.getString("version");
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray3 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray3.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(Be0.G(jSONArray3.getString(i)));
            }
            Pd0 pd0 = new Pd0(C4374sq.e(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                pd0.f = (zzaia) Preconditions.checkNotNull(zzaia.zzb(string));
            }
            if (!z) {
                pd0.m = Boolean.FALSE;
            }
            pd0.l = str;
            if (jSONObject.has("userMetadata") && (a = Sd0.a(jSONObject.getJSONObject("userMetadata"))) != null) {
                pd0.n = a;
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray2 = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray2.getString(i2));
                    String optString = jSONObject2.optString("factorIdKey");
                    if ("phone".equals(optString)) {
                        safeParcelable = C3262eJ.H(jSONObject2);
                    } else if (Objects.equals(optString, "totp")) {
                        safeParcelable = OW.H(jSONObject2);
                    } else {
                        safeParcelable = null;
                    }
                    arrayList2.add(safeParcelable);
                }
                pd0.J(arrayList2);
            }
            if (jSONObject.has("passkeyInfo") && (jSONArray = jSONObject.getJSONArray("passkeyInfo")) != null) {
                ArrayList arrayList3 = new ArrayList();
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList3.add(Vd0.H(new JSONObject(jSONArray.getString(i3))));
                }
                pd0.r = arrayList3;
            }
            return pd0;
        } catch (zzaaw e) {
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void b(String str, String str2) {
        String encodeToString;
        he0 a = he0.a(this.a, this.b);
        a.getClass();
        Preconditions.checkNotNull(str2);
        zznl zznlVar = a.b;
        String str3 = null;
        if (zznlVar == null) {
            Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to encrypt data");
        } else {
            try {
                synchronized (zznlVar) {
                    encodeToString = Base64.encodeToString(((zzbm) a.b.zza().zza(zzjg.zza(), zzbm.class)).zzb(str2.getBytes(StandardCharsets.UTF_8), null), 2);
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

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String c(String str) {
        String str2;
        String string = this.c.getString(str, null);
        if (string == null) {
            return null;
        }
        if (string.startsWith("ENCRYPTED:")) {
            he0 a = he0.a(this.a, this.b);
            String substring = string.substring(10);
            a.getClass();
            Preconditions.checkNotNull(substring);
            zznl zznlVar = a.b;
            if (zznlVar == null) {
                Log.e("FirebearStorageCryptoHelper", "KeysetManager failed to initialize - unable to decrypt data");
                return null;
            }
            try {
                synchronized (zznlVar) {
                    str2 = new String(((zzbm) a.b.zza().zza(zzjg.zza(), zzbm.class)).zza(Base64.decode(substring, 2), null), StandardCharsets.UTF_8);
                }
                return str2;
            } catch (IllegalArgumentException | GeneralSecurityException e) {
                Log.e("FirebearStorageCryptoHelper", "Exception encountered while decrypting bytes:\n" + e.getMessage());
                return null;
            }
        }
        return string;
    }
}
