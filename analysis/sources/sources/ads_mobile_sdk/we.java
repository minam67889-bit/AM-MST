package ads_mobile_sdk;

import defpackage.AbstractC3354fY;
import defpackage.EnumC0516Tg;
import defpackage.InterfaceC0166Ft;
import defpackage.InterfaceC0490Sg;
import defpackage.InterfaceC4441tg;
import defpackage.W70;
import defpackage.YU;
import defpackage.YY;
import java.util.Set;
import prince.udp.vpn.activities.UDPApplication;

/* loaded from: classes.dex */
public final class we extends YU implements InterfaceC0166Ft {
    public int a;
    public final /* synthetic */ W70 b;
    public final /* synthetic */ hf c;
    public final /* synthetic */ Set d;
    public W70 e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC0166Ft
    public final Object invoke(Object obj, Object obj2) {
        return ((we) create((InterfaceC0490Sg) obj, (InterfaceC4441tg) obj2)).invokeSuspend(YY.a);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.G9
    public final Object invokeSuspend(Object obj) {
        W70 w70;
        EnumC0516Tg enumC0516Tg = EnumC0516Tg.a;
        int i = this.a;
        if (i == 0) {
            AbstractC3354fY.n0(obj);
            W70 w702 = this.b;
            this.e = w702;
            this.a = 1;
            hf hfVar = this.c;
            hfVar.getClass();
            Object a = hf.a(hfVar, this.d, this);
            if (a == enumC0516Tg) {
                return enumC0516Tg;
            }
            w70 = w702;
            obj = a;
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            w70 = this.e;
            AbstractC3354fY.n0(obj);
        }
        w70.getClass();
        int i2 = UDPApplication.d;
        return YY.a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public we(InterfaceC4441tg interfaceC4441tg, W70 w70, hf hfVar, Set set) {
        super(2, interfaceC4441tg);
        this.b = w70;
        this.c = hfVar;
        this.d = set;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.G9
    public final InterfaceC4441tg create(Object obj, InterfaceC4441tg interfaceC4441tg) {
        return new we(interfaceC4441tg, this.b, this.c, this.d);
    }
}
