package ads_mobile_sdk;

import android.net.NetworkCapabilities;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.InterfaceC3053fd0;
import defpackage.Z60;
import java.lang.reflect.Method;
import java.util.Map;

/* loaded from: classes.dex */
public final class c02 extends i43 {
    public final Map f;

    public c02(Z60 z60, InterfaceC3053fd0 interfaceC3053fd0, Map map, pd3 pd3Var) {
        super("+/d7gIvbguagmLkey/0il+BSVtw01dUkvQ7hE+VVtNobETkQZKm96h10rOo7+pys", "XaIU/OdVjAIW9PtvYtqiCUBtB8OlYoD0ROoq1PHrcDY=", z60, interfaceC3053fd0, pd3Var.a(nk0.EVENT_ID_NETWORK_SIGNALS_TASK));
        this.f = map;
    }

    @Override // ads_mobile_sdk.i43
    public final void a(Method method, Z60 z60) {
        int i;
        int i2;
        int i3;
        Object[] objArr = (Object[]) method.invoke("", (NetworkCapabilities) this.f.get("ntc"), (Long) this.f.get("vs"), (Long) this.f.get("vf"));
        objArr.getClass();
        synchronized (z60) {
            long longValue = ((Long) objArr[0]).longValue();
            z60.b();
            id idVar = (id) z60.b;
            i = idVar.bitField0_;
            idVar.bitField0_ = i | UserVerificationMethods.USER_VERIFY_ALL;
            idVar.netSignal_ = longValue;
            long longValue2 = ((Long) objArr[1]).longValue();
            if (longValue2 >= 0) {
                z60.b();
                id idVar2 = (id) z60.b;
                i3 = idVar2.bitField2_;
                idVar2.bitField2_ = i3 | 2048;
                idVar2.timeSinceVpnOnMs_ = longValue2;
            }
            long longValue3 = ((Long) objArr[2]).longValue();
            if (longValue3 >= 0) {
                z60.b();
                id idVar3 = (id) z60.b;
                i2 = idVar3.bitField2_;
                idVar3.bitField2_ = i2 | 4096;
                idVar3.adeventToVpnOffMs_ = longValue3;
            }
        }
    }
}
