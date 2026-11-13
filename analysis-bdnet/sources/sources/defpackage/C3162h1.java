package defpackage;

import android.content.Context;
import android.view.View;
import dastan.prince.bdfreevpn.R;

/* renamed from: h1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3162h1 extends C4056sF {
    public final /* synthetic */ int l = 1;
    public final /* synthetic */ C3480l1 m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3162h1(C3480l1 c3480l1, Context context, MenuC2945eF menuC2945eF, View view) {
        super(R.attr.actionOverflowMenuStyle, menuC2945eF, context, view, true);
        this.m = c3480l1;
        this.f = 8388613;
        C0136Ew c0136Ew = c3480l1.w;
        this.h = c0136Ew;
        AbstractC3899qF abstractC3899qF = this.i;
        if (abstractC3899qF != null) {
            abstractC3899qF.d(c0136Ew);
        }
    }

    @Override // defpackage.C4056sF
    public final void c() {
        switch (this.l) {
            case 0:
                C3480l1 c3480l1 = this.m;
                c3480l1.t = null;
                c3480l1.getClass();
                super.c();
                break;
            default:
                C3480l1 c3480l12 = this.m;
                MenuC2945eF menuC2945eF = c3480l12.c;
                if (menuC2945eF != null) {
                    menuC2945eF.c(true);
                }
                c3480l12.s = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C3162h1(C3480l1 c3480l1, Context context, SubMenuC4625zV subMenuC4625zV, View view) {
        super(R.attr.actionOverflowMenuStyle, subMenuC4625zV, context, view, false);
        this.m = c3480l1;
        if ((subMenuC4625zV.A.x & 32) != 32) {
            View view2 = c3480l1.i;
            this.e = view2 == null ? (View) c3480l1.h : view2;
        }
        C0136Ew c0136Ew = c3480l1.w;
        this.h = c0136Ew;
        AbstractC3899qF abstractC3899qF = this.i;
        if (abstractC3899qF != null) {
            abstractC3899qF.d(c0136Ew);
        }
    }
}
