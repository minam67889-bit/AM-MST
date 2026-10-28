package defpackage;

import android.content.Context;
import app.vpn.amtunnellite.R;

/* renamed from: jn, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3679jn {
    public static final int f = (int) Math.round(5.1000000000000005d);
    public final boolean a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3679jn(Context context) {
        boolean N = AbstractC0427Pv.N(context, R.attr.elevationOverlayEnabled, false);
        int A = AbstractC4766xx.A(context, R.attr.elevationOverlayColor, 0);
        int A2 = AbstractC4766xx.A(context, R.attr.elevationOverlayAccentColor, 0);
        int A3 = AbstractC4766xx.A(context, R.attr.colorSurface, 0);
        float f2 = context.getResources().getDisplayMetrics().density;
        this.a = N;
        this.b = A;
        this.c = A2;
        this.d = A3;
        this.e = f2;
    }
}
