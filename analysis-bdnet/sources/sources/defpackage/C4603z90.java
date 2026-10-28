package defpackage;

import ads_mobile_sdk.ed3;
import ads_mobile_sdk.fv0;
import ads_mobile_sdk.gv0;
import ads_mobile_sdk.kv0;
import ads_mobile_sdk.rc3;
import ads_mobile_sdk.vt0;
import ads_mobile_sdk.wt0;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: z90, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4603z90 {
    public static Uri a(Uri uri, String str) {
        AbstractC3634my.g(uri, "<this>");
        String uri2 = uri.toString();
        AbstractC3634my.f(uri2, "toString(...)");
        int B0 = AbstractC3757oV.B0(uri2, "&adurl", 0, 6);
        if (B0 == -1) {
            B0 = AbstractC3757oV.B0(uri2, "?adurl=", 0, 6);
        }
        if (B0 == -1) {
            Uri build = uri.buildUpon().appendQueryParameter("ms", str).build();
            AbstractC3634my.d(build);
            return build;
        }
        StringBuilder sb = new StringBuilder(str.length() + uri2.length() + 2 + 2);
        int i = B0 + 1;
        String substring = uri2.substring(0, i);
        AbstractC3634my.f(substring, "substring(...)");
        sb.append(substring);
        sb.append("ms=");
        sb.append(str);
        sb.append("&");
        String substring2 = uri2.substring(i);
        AbstractC3634my.f(substring2, "substring(...)");
        sb.append(substring2);
        String sb2 = sb.toString();
        AbstractC3634my.f(sb2, "toString(...)");
        return Uri.parse(sb2);
    }

    public static String c(Context context) {
        String string;
        AbstractC3634my.g(context, "context");
        AtomicReference atomicReference = kv0.g;
        String str = (String) atomicReference.get();
        if (str != null) {
            return str;
        }
        String str2 = "B3EEABB8EE11C2BE770B684D95219ECB";
        if (!U20.i() && (string = Settings.Secure.getString(context.getContentResolver(), "android_id")) != null && string.length() != 0) {
            str2 = f(string);
        }
        atomicReference.set(str2);
        return (String) atomicReference.get();
    }

    public static String d(String str, String str2) {
        C2853d6 a = KN.a(new KN(str), str2);
        if (a == null) {
            return null;
        }
        Collection G = a.G();
        AbstractC3715o abstractC3715o = (AbstractC3715o) G;
        if (abstractC3715o.a() < 2) {
            return null;
        }
        int a2 = abstractC3715o.a();
        for (int i = 1; i < a2; i++) {
            C3502lE c3502lE = (C3502lE) G;
            if (!AbstractC3757oV.D0((CharSequence) c3502lE.get(i))) {
                return (String) c3502lE.get(i);
            }
        }
        return null;
    }

    public static boolean e(Context context, String str) {
        AbstractC3634my.g(context, "context");
        return context.checkSelfPermission(str) == 0;
    }

    public static String f(String str) {
        for (int i = 0; i < 2; i++) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                byte[] bytes = str.getBytes(AbstractC0738ad.a);
                AbstractC3634my.f(bytes, "getBytes(...)");
                messageDigest.update(bytes);
                return String.format(Locale.US, "%032X", Arrays.copyOf(new Object[]{new BigInteger(1, messageDigest.digest())}, 1));
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(long j, InterfaceC0522Tt interfaceC0522Tt, AbstractC0224Ig abstractC0224Ig) {
        fv0 fv0Var;
        int i;
        int i2;
        try {
            if (abstractC0224Ig instanceof fv0) {
                fv0Var = (fv0) abstractC0224Ig;
                int i3 = fv0Var.c;
                if ((i3 & Integer.MIN_VALUE) != 0) {
                    fv0Var.c = i3 - Integer.MIN_VALUE;
                    Object obj = fv0Var.a;
                    EnumC3299ih enumC3299ih = EnumC3299ih.a;
                    i = fv0Var.c;
                    i2 = 1;
                    if (i != 0) {
                        W80.U(obj);
                        gv0 gv0Var = new gv0(interfaceC0522Tt, null);
                        fv0Var.c = 1;
                        obj = AbstractC3634my.N(j, gv0Var, fv0Var);
                        if (obj == enumC3299ih) {
                            return enumC3299ih;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        W80.U(obj);
                    }
                    return new vt0(obj);
                }
            }
            if (i != 0) {
            }
            return new vt0(obj);
        } catch (C0729aX e) {
            wt0 wt0Var = new wt0(e, i2);
            rc3 a = ed3.a();
            a.e().m = false;
            a.a(e);
            return wt0Var;
        }
        fv0Var = new fv0(this, abstractC0224Ig);
        Object obj2 = fv0Var.a;
        EnumC3299ih enumC3299ih2 = EnumC3299ih.a;
        i = fv0Var.c;
        i2 = 1;
    }
}
