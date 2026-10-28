package defpackage;

import android.content.Context;
import dastan.prince.bdfreevpn.R;

/* renamed from: xn, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4491xn {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public C4491xn(Context context) {
        boolean Z = AbstractC0731aZ.Z(context, R.attr.elevationOverlayEnabled, false);
        int t = S50.t(context, R.attr.elevationOverlayColor, 0);
        int t2 = S50.t(context, R.attr.elevationOverlayAccentColor, 0);
        int t3 = S50.t(context, R.attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = Z;
        this.b = t;
        this.c = t2;
        this.d = t3;
        this.e = f2;
    }
}
