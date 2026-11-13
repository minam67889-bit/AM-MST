package ads_mobile_sdk;

import defpackage.C4471xZ;
import defpackage.EnumC3299ih;
import defpackage.I00;
import defpackage.InterfaceC0198Hg;
import defpackage.InterfaceC3220hh;
import defpackage.InterfaceC3233hu;
import defpackage.MI;
import defpackage.RV;
import defpackage.W80;
import java.util.Set;
import prince.dastan.vpn.activities.VPNApplication;

/* loaded from: classes.dex */
public final class cb extends RV implements InterfaceC3233hu {
    public int a;
    public final /* synthetic */ MI b;
    public final /* synthetic */ nb c;
    public final /* synthetic */ Set d;
    public MI e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cb(InterfaceC0198Hg interfaceC0198Hg, MI mi, nb nbVar, Set set) {
        super(2, interfaceC0198Hg);
        this.b = mi;
        this.c = nbVar;
        this.d = set;
    }

    @Override // defpackage.X9
    public final InterfaceC0198Hg create(Object obj, InterfaceC0198Hg interfaceC0198Hg) {
        return new cb(interfaceC0198Hg, this.b, this.c, this.d);
    }

    @Override // defpackage.InterfaceC3233hu
    public final Object invoke(Object obj, Object obj2) {
        return ((cb) create((InterfaceC3220hh) obj, (InterfaceC0198Hg) obj2)).invokeSuspend(C4471xZ.a);
    }

    @Override // defpackage.X9
    public final Object invokeSuspend(Object obj) {
        MI mi;
        EnumC3299ih enumC3299ih = EnumC3299ih.a;
        int i = this.a;
        if (i == 0) {
            W80.U(obj);
            MI mi2 = this.b;
            nb nbVar = this.c;
            Set set = this.d;
            this.e = mi2;
            this.a = 1;
            nbVar.getClass();
            Object a = nb.a(nbVar, set, this);
            if (a == enumC3299ih) {
                return enumC3299ih;
            }
            mi = mi2;
            obj = a;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mi = this.e;
            W80.U(obj);
        }
        ((I00) mi).getClass();
        int i2 = VPNApplication.e;
        return C4471xZ.a;
    }
}
