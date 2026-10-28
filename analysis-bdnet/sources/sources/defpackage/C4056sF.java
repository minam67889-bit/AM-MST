package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import dastan.prince.bdfreevpn.R;

/* renamed from: sF, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C4056sF {
    public final Context a;
    public final MenuC2945eF b;
    public final boolean c;
    public final int d;
    public View e;
    public boolean g;
    public InterfaceC4451xF h;
    public AbstractC3899qF i;
    public C3977rF j;
    public int f = 8388611;
    public final C3977rF k = new C3977rF(this);

    public C4056sF(int i, MenuC2945eF menuC2945eF, Context context, View view, boolean z) {
        this.a = context;
        this.b = menuC2945eF;
        this.e = view;
        this.c = z;
        this.d = i;
    }

    public final AbstractC3899qF a() {
        AbstractC3899qF mu;
        if (this.i == null) {
            Context context = this.a;
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getRealSize(point);
            if (Math.min(point.x, point.y) >= context.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width)) {
                mu = new ViewOnKeyListenerC3210hc(context, this.e, this.d, this.c);
            } else {
                View view = this.e;
                Context context2 = this.a;
                boolean z = this.c;
                mu = new MU(this.d, this.b, context2, view, z);
            }
            mu.k(this.b);
            mu.q(this.k);
            mu.m(this.e);
            mu.d(this.h);
            mu.n(this.g);
            mu.o(this.f);
            this.i = mu;
        }
        return this.i;
    }

    public final boolean b() {
        AbstractC3899qF abstractC3899qF = this.i;
        return abstractC3899qF != null && abstractC3899qF.a();
    }

    public void c() {
        this.i = null;
        C3977rF c3977rF = this.j;
        if (c3977rF != null) {
            c3977rF.onDismiss();
        }
    }

    public final void d(int i, int i2, boolean z, boolean z2) {
        AbstractC3899qF a = a();
        a.r(z2);
        if (z) {
            if ((Gravity.getAbsoluteGravity(this.f, this.e.getLayoutDirection()) & 7) == 5) {
                i -= this.e.getWidth();
            }
            a.p(i);
            a.s(i2);
            int i3 = (int) ((this.a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            a.a = new Rect(i - i3, i2 - i3, i + i3, i2 + i3);
        }
        a.show();
    }
}
