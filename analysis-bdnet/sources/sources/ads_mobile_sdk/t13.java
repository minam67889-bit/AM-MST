package ads_mobile_sdk;

import defpackage.InterfaceC0470Rt;
import defpackage.RA;
import defpackage.W50;

/* loaded from: classes.dex */
public final class t13 extends RA implements InterfaceC0470Rt {
    public final /* synthetic */ String a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t13(String str) {
        super(0);
        this.a = str;
    }

    @Override // defpackage.InterfaceC0470Rt
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String invoke() {
        return W50.m("CSRB SignalLoader unencrypted params: ", this.a);
    }
}
