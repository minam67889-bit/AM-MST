package ads_mobile_sdk;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import dastan.prince.bdfreevpn.R;
import defpackage.AbstractC3634my;
import defpackage.AbstractC4309vV;
import defpackage.C4471xZ;
import defpackage.InterfaceC3220hh;
import defpackage.XE;
import java.util.Map;

/* loaded from: classes.dex */
public final class ln1 {
    public final vh0 a;
    public final hn1 b;
    public final kv0 c;
    public final InterfaceC3220hh d;
    public final f0 e;

    public ln1(vh0 vh0Var, hn1 hn1Var, kv0 kv0Var, InterfaceC3220hh interfaceC3220hh, f0 f0Var) {
        AbstractC3634my.g(vh0Var, "deviceProperties");
        AbstractC3634my.g(hn1Var, "mraidAfmaDispatcher");
        AbstractC3634my.g(kv0Var, "gmaUtil");
        AbstractC3634my.g(interfaceC3220hh, "uiScope");
        AbstractC3634my.g(f0Var, "activityTracker");
        this.a = vh0Var;
        this.b = hn1Var;
        this.c = kv0Var;
        this.d = interfaceC3220hh;
        this.e = f0Var;
    }

    public final C4471xZ a(lw0 lw0Var, Map map) {
        String str;
        String str2;
        String str3;
        String str4;
        C4471xZ c4471xZ = C4471xZ.a;
        Activity b = this.e.b();
        if (b == null) {
            XE.r(this.d, null, new jn1(this, lw0Var, "Activity context is required to show calendar event alert.", null), 3);
            return c4471xZ;
        }
        vh0 vh0Var = this.a;
        vh0Var.getClass();
        Intent type = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
        AbstractC3634my.f(type, "setType(...)");
        if (!vh0Var.a(type)) {
            XE.r(this.d, null, new jn1(this, lw0Var, "This feature is not available on the device.", null), 3);
            return c4471xZ;
        }
        String str5 = (String) map.get("start_ticks");
        Long o0 = str5 != null ? AbstractC4309vV.o0(str5) : null;
        String str6 = (String) map.get("end_ticks");
        Long o02 = str6 != null ? AbstractC4309vV.o0(str6) : null;
        String str7 = (String) map.get("description");
        String str8 = str7 == null ? "" : str7;
        String str9 = (String) map.get("summary");
        String str10 = str9 == null ? "" : str9;
        String str11 = (String) map.get("location");
        String str12 = str11 == null ? "" : str11;
        Resources resources = b.getResources();
        if (resources == null || (str = resources.getString(R.string.mraid_create_calendar_event)) == null) {
            str = "Create calendar event";
        }
        if (resources == null || (str2 = resources.getString(R.string.mraid_allow_calendar_event)) == null) {
            str2 = "Allow Ad to create a calendar event?";
        }
        if (resources == null || (str3 = resources.getString(R.string.mraid_alert_accept)) == null) {
            str3 = "Accept";
        }
        if (resources == null || (str4 = resources.getString(R.string.mraid_alert_decline)) == null) {
            str4 = "Decline";
        }
        XE.r(this.d, null, new kn1(b, str, str2, str3, str4, str8, str12, str10, o0, o02, this, lw0Var, null), 3);
        return c4471xZ;
    }
}
