package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public class CE {
    public final Context a;
    public final MenuC3948nE b;
    public final boolean c;
    public final int d;
    public final int e;
    public View f;
    public boolean h;
    public HE i;
    public AE j;
    public PopupWindow.OnDismissListener k;
    public int g = 8388611;
    public final BE l = new BE(this);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CE(int i, int i2, MenuC3948nE menuC3948nE, Context context, View view, boolean z) {
        this.a = context;
        this.b = menuC3948nE;
        this.f = view;
        this.c = z;
        this.d = i;
        this.e = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final AE a() {
        AE lt;
        if (this.j == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                lt = new ViewOnKeyListenerC0511Tb(this.a, this.f, this.d, this.e, this.c);
            } else {
                View view = this.f;
                int i = this.e;
                boolean z = this.c;
                Context context2 = this.a;
                lt = new LT(this.d, i, this.b, context2, view, z);
            }
            lt.k(this.b);
            lt.q(this.l);
            lt.m(this.f);
            lt.d(this.i);
            lt.n(this.h);
            lt.o(this.g);
            this.j = lt;
        }
        return this.j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean b() {
        AE ae = this.j;
        if (ae != null && ae.b()) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void c() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void d(int i, int i2, boolean z, boolean z2) {
        AE a = a();
        a.r(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.g, this.f.getLayoutDirection()) & 7) == 5) {
                i -= this.f.getWidth();
            }
            a.p(i);
            a.s(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a.a = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        a.show();
    }
}
