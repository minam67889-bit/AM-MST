package ads_mobile_sdk;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.webkit.URLUtil;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3288ib;
import defpackage.AbstractC3634my;
import defpackage.AbstractC3715o;
import defpackage.C2853d6;
import defpackage.C3502lE;
import defpackage.C3518lU;
import defpackage.C4471xZ;
import defpackage.InterfaceC3220hh;
import defpackage.Ja0;
import defpackage.KN;
import defpackage.W50;
import defpackage.XE;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.regex.Matcher;
import org.chromium.net.impl.JavaUploadDataSinkBase;

/* loaded from: classes.dex */
public final class ip1 {
    public static final KN i = new KN("[^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$");
    public final vh0 a;
    public final hn1 b;
    public final InterfaceC3220hh c;
    public final InterfaceC3220hh d;
    public final Ja0 e;
    public final f0 f;
    public final wt2 g;
    public final gd3 h;

    public ip1(vh0 vh0Var, hn1 hn1Var, InterfaceC3220hh interfaceC3220hh, InterfaceC3220hh interfaceC3220hh2, Ja0 ja0, f0 f0Var, wt2 wt2Var, gd3 gd3Var) {
        AbstractC3634my.g(vh0Var, "deviceProperties");
        AbstractC3634my.g(hn1Var, "mraidAfmaDispatcher");
        AbstractC3634my.g(interfaceC3220hh, "uiScope");
        AbstractC3634my.g(interfaceC3220hh2, "backgroundScope");
        AbstractC3634my.g(ja0, "httpClient");
        AbstractC3634my.g(f0Var, "activityTracker");
        AbstractC3634my.g(wt2Var, "rootTraceCreator");
        AbstractC3634my.g(gd3Var, "traceMetaSet");
        this.a = vh0Var;
        this.b = hn1Var;
        this.c = interfaceC3220hh;
        this.d = interfaceC3220hh2;
        this.e = ja0;
        this.f = f0Var;
        this.g = wt2Var;
        this.h = gd3Var;
    }

    public final void a(String str, lw0 lw0Var, boolean z) {
        C3518lU c3518lU = mt0.a;
        mt0.c("Store picture error: " + str, null);
        if (z) {
            td3.a(str, null, 6);
        }
        XE.r(this.c, null, new ep1(this, lw0Var, str, null), 3);
    }

    public final C4471xZ a(lw0 lw0Var, Map map) {
        return a(this, map, lw0Var);
    }

    public static C4471xZ a(ip1 ip1Var, Map map, lw0 lw0Var) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean c = ip1Var.a.c();
        C4471xZ c4471xZ = C4471xZ.a;
        if (!c) {
            ip1Var.a("This feature is not available on the device.", lw0Var, true);
            return c4471xZ;
        }
        Activity b = ip1Var.f.b();
        if (b == null) {
            ip1Var.a("Activity context is required to show store picture event alert.", lw0Var, true);
            return c4471xZ;
        }
        String str5 = (String) map.get("iurl");
        if (str5 != null && str5.length() != 0) {
            if (!URLUtil.isValidUrl(str5)) {
                ip1Var.a(W50.D("Invalid image url: ", str5, "."), lw0Var, true);
                return c4471xZ;
            }
            String lastPathSegment = Uri.parse(str5).getLastPathSegment();
            if (lastPathSegment == null) {
                ip1Var.a("No image file name in ".concat(str5), lw0Var, true);
                return c4471xZ;
            }
            KN kn = i;
            kn.getClass();
            Matcher matcher = kn.a.matcher(lastPathSegment);
            AbstractC3634my.f(matcher, "matcher(...)");
            C2853d6 c2853d6 = !matcher.matches() ? null : new C2853d6(matcher, lastPathSegment);
            if (c2853d6 != null && ((AbstractC3715o) c2853d6.G()).a() == 3) {
                String str6 = (String) ((C3502lE) c2853d6.G()).get(2);
                Resources resources = b.getResources();
                if (resources == null || (str = resources.getString(R.string.mraid_allow_store_picture)) == null) {
                    str = "Allow Ad to store image in Picture gallery?";
                }
                String str7 = str;
                if (resources == null || (str2 = resources.getString(R.string.mraid_save_image)) == null) {
                    str2 = "Save image";
                }
                if (resources == null || (str3 = resources.getString(R.string.mraid_alert_accept)) == null) {
                    str3 = "Accept";
                }
                if (resources == null || (str4 = resources.getString(R.string.mraid_alert_decline)) == null) {
                    str4 = "Decline";
                }
                XE.r(ip1Var.c, null, new fp1(b, str2, str7, str3, str4, ip1Var, str5, lastPathSegment, str6, lw0Var, null), 3);
                return c4471xZ;
            }
            ip1Var.a("Invalid image file name: ".concat(lastPathSegment), lw0Var, true);
            return c4471xZ;
        }
        ip1Var.a("Image url cannot be empty.", lw0Var, true);
        return c4471xZ;
    }

    public final void a(ByteArrayInputStream byteArrayInputStream, String str, String str2, Context context, lw0 lw0Var) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str);
        contentValues.put("mime_type", "image/" + str2);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            contentValues.put("is_pending", (Integer) 1);
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            a("Unable to store picture", lw0Var, true);
            return;
        }
        FileOutputStream a = pv2.a(context, insert, ov2.d);
        int i3 = AbstractC3288ib.a;
        byteArrayInputStream.getClass();
        a.getClass();
        byte[] bArr = new byte[JavaUploadDataSinkBase.DEFAULT_UPLOAD_BUFFER_SIZE];
        while (true) {
            int read = byteArrayInputStream.read(bArr);
            if (read == -1) {
                break;
            } else {
                a.write(bArr, 0, read);
            }
        }
        if (i2 >= 30) {
            contentValues.clear();
            contentValues.put("is_pending", (Integer) 0);
            contentResolver.update(insert, contentValues, null, null);
        }
        C3518lU c3518lU = mt0.a;
        mt0.a(new dp1(str, insert));
    }
}
