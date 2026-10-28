package defpackage;

import android.content.Context;
import android.view.View;
import app.vpn.amtunnellite.R;

/* renamed from: e1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3235e1 extends CE {
    public final /* synthetic */ int m = 0;
    public final /* synthetic */ C3543i1 n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3235e1(C3543i1 c3543i1, Context context, MenuC3948nE menuC3948nE, C3466h1 c3466h1) {
        super(R.attr.actionOverflowMenuStyle, 0, menuC3948nE, context, c3466h1, true);
        this.n = c3543i1;
        this.g = 8388613;
        C4532uu c4532uu = c3543i1.w;
        this.i = c4532uu;
        AE ae = this.j;
        if (ae != null) {
            ae.d(c4532uu);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.CE
    public final void c() {
        switch (this.m) {
            case 0:
                this.n.t = null;
                super.c();
                break;
            default:
                C3543i1 c3543i1 = this.n;
                MenuC3948nE menuC3948nE = c3543i1.c;
                if (menuC3948nE != null) {
                    menuC3948nE.c(true);
                }
                c3543i1.s = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C3235e1(C3543i1 c3543i1, Context context, AU au, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, au, context, view, false);
        this.n = c3543i1;
        if (!au.A.e()) {
            View view2 = c3543i1.i;
            this.f = view2 == null ? (View) c3543i1.h : view2;
        }
        C4532uu c4532uu = c3543i1.w;
        this.i = c4532uu;
        AE ae = this.j;
        if (ae != null) {
            ae.d(c4532uu);
        }
    }
}
