package ads_mobile_sdk;

import android.net.NetworkCapabilities;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.F40;
import defpackage.T60;
import defpackage.Uc0;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class l92 extends jj3 {
    public final Object f;
    public final /* synthetic */ int l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public l92(Uc0 uc0, zw1 zw1Var, na naVar, ts3 ts3Var) {
        super("WW47yStxc+Kn23SzlVFAtkW406rAiVNF7FaBmX6o9CgxQkQFUdWEOMSkrqtI78H7", "kf+iEov9hqWWX6mGICnxIdxLkafhWxGKH7t1rvtl8FM=", uc0, zw1Var, ts3Var.a(lq0.EVENT_ID_ENV_VERSION_SIGNALS_TASK));
        this.l = 2;
        this.f = naVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // ads_mobile_sdk.jj3
    public final void a(Method method, Uc0 uc0) {
        int i;
        int i2;
        Object obj;
        int i3;
        int i4;
        int i5;
        switch (this.l) {
            case 0:
                List list = (List) ((Map) this.f).get("vst");
                if (list != null) {
                    Object invoke = method.invoke("", list);
                    invoke.getClass();
                    Long l = (Long) invoke;
                    synchronized (uc0) {
                        try {
                            int _a$1 = T60._a$1(l.intValue());
                            if (_a$1 != 0) {
                                uc0.d$3();
                                fh fhVar = (fh) uc0.b;
                                fhVar.getClass();
                                fhVar.navigationTriggerType_ = F40.t(_a$1);
                                i = fhVar.bitField2_;
                                fhVar.bitField2_ = i | 16777216;
                            } else {
                                throw null;
                            }
                        } finally {
                        }
                    }
                    return;
                }
                return;
            case 1:
                Object[] objArr = (Object[]) method.invoke("", (NetworkCapabilities) ((Map) this.f).get("ntc"), (Long) ((Map) this.f).get("vs"), (Long) ((Map) this.f).get("vf"));
                objArr.getClass();
                synchronized (uc0) {
                    try {
                        long longValue = ((Long) objArr[0]).longValue();
                        uc0.d$3();
                        fh fhVar2 = (fh) uc0.b;
                        i2 = fhVar2.bitField0_;
                        fhVar2.bitField0_ = i2 | UserVerificationMethods.USER_VERIFY_ALL;
                        fhVar2.netSignal_ = longValue;
                        long longValue2 = ((Long) objArr[1]).longValue();
                        if (longValue2 >= 0) {
                            uc0.d$3();
                            fh fhVar3 = (fh) uc0.b;
                            i5 = fhVar3.bitField2_;
                            fhVar3.bitField2_ = i5 | 2048;
                            fhVar3.timeSinceVpnOnMs_ = longValue2;
                        }
                        long longValue3 = ((Long) objArr[2]).longValue();
                        if (longValue3 >= 0) {
                            uc0.d$3();
                            fh fhVar4 = (fh) uc0.b;
                            i4 = fhVar4.bitField2_;
                            fhVar4.bitField2_ = i4 | 4096;
                            fhVar4.adeventToVpnOffMs_ = longValue3;
                        }
                        if (objArr.length > 3 && (obj = objArr[3]) != null) {
                            int _a$2 = T60._a$2(((Long) obj).intValue());
                            if (_a$2 != 0) {
                                uc0.d$3();
                                fh fhVar5 = (fh) uc0.b;
                                fhVar5.getClass();
                                fhVar5.proxyDetectedSignal_ = T60.e(_a$2);
                                i3 = fhVar5.bitField2_;
                                fhVar5.bitField2_ = i3 | 16;
                            } else {
                                throw null;
                            }
                        }
                    } finally {
                    }
                }
                return;
            default:
                Object[] objArr2 = (Object[]) method.invoke("", ((na) this.f).M());
                objArr2.getClass();
                synchronized (uc0) {
                    String str = (String) objArr2[0];
                    uc0.d$3();
                    ((fh) uc0.b).d(str);
                    String str2 = (String) objArr2[1];
                    uc0.d$3();
                    ((fh) uc0.b).c(str2);
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public l92(Uc0 uc0, zw1 zw1Var, Map map, ts3 ts3Var, int i) {
        super("0NIT52uMLryaCDSaYUNTuLrzAq4mHtZo+PB3KlcFFwbeXateEvxa704CMxtRHbLJ", "s+ypGKrTCojCsgwPi6TAeYKzOJO0imQtS3SqSWBWtUM=", uc0, zw1Var, ts3Var.a(lq0.EVENT_ID_NAVIGATION_SIGNALS_TASK));
        this.l = i;
        switch (i) {
            case 1:
                super("6rtGdXQ0NfJtjALp1SU3EV8a8C+xU3leWzJkhweDj7Qc7b2AmiMUFfEFTlWg/y94", "2IeAOqgxQ9MuURMRwplUp+eIWsDyl3j/iScS6NWDc6A=", uc0, zw1Var, ts3Var.a(lq0.EVENT_ID_NETWORK_SIGNALS_TASK));
                this.f = map;
                break;
            default:
                this.f = map;
                break;
        }
    }
}
