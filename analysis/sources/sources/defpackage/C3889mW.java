package defpackage;

import ads_mobile_sdk.bq;
import ads_mobile_sdk.cm1;
import ads_mobile_sdk.do0;
import ads_mobile_sdk.e63;
import ads_mobile_sdk.fz;
import ads_mobile_sdk.j53;
import ads_mobile_sdk.kl;
import ads_mobile_sdk.md0;
import ads_mobile_sdk.nb0;
import ads_mobile_sdk.nk;
import ads_mobile_sdk.om;
import ads_mobile_sdk.sk;
import ads_mobile_sdk.vf0;
import ads_mobile_sdk.vh1;
import ads_mobile_sdk.zx2;
import ads_mobile_sdk.zz0;
import android.app.Activity;
import android.os.Bundle;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPApplication;

/* renamed from: mW, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C3889mW {
    public boolean a;
    public boolean b;
    public Object c;
    public Object d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void a() {
        InterfaceC0706a60 do0Var;
        InterfaceC0706a60 do0Var2;
        InterfaceC0706a60 do0Var3;
        InterfaceC0706a60 do0Var4;
        if (!this.a && ((V5) this.c) == null) {
            this.a = true;
            String string = Deobfuscator$AMTUNNELLITE$app.getString(-149613722013345L);
            AbstractC4766xx.p(string, "adUnitId");
            N1 n1 = new N1(string, new LinkedHashSet(), null, new LinkedHashMap(), new Bundle(), new HashSet(), new HashSet(), new LinkedHashMap(), null, null, 0L, false);
            VP vp = new VP(this, 13);
            sk.d.getClass();
            InterfaceC4779y40.a.getClass();
            cm1 cm1Var = (cm1) ((vf0) zz0.a()).q3.get();
            vf0 vf0Var = (vf0) zz0.a();
            j53 j53Var = j53.e;
            Boolean bool = Boolean.FALSE;
            vh1 vh1Var = AbstractC3789l90.a;
            InterfaceC0706a60 e63Var = new e63((InterfaceC0706a60) vh1Var, (InterfaceC0706a60) vh1Var, (InterfaceC4095p80) vh1Var, 3);
            if (e63Var instanceof do0) {
                do0Var = e63Var;
            } else {
                do0Var = new do0(e63Var);
            }
            vf0 vf0Var2 = vf0Var.c;
            InterfaceC0706a60 klVar = new kl(vf0Var2.w0, 6);
            if (klVar instanceof do0) {
                do0Var2 = klVar;
            } else {
                do0Var2 = new do0(klVar);
            }
            vh1 a = vh1.a(j53Var);
            vh1 a2 = vh1.a(bool);
            InterfaceC0706a60 interfaceC0706a60 = do0Var2;
            InterfaceC0706a60 nb0Var = new nb0(vf0Var2.P0, a, new md0(vh1.a(n1)), interfaceC0706a60, vh1.a(bool), vf0Var2.h, vf0Var2.t, vh1Var);
            if (nb0Var instanceof do0) {
                do0Var3 = nb0Var;
            } else {
                do0Var3 = new do0(nb0Var);
            }
            vh1 a3 = vh1.a(n1);
            InterfaceC0706a60 interfaceC0706a602 = AbstractC0427Pv.m;
            if (!(interfaceC0706a602 instanceof do0)) {
                interfaceC0706a602 = new do0(interfaceC0706a602);
            }
            om omVar = vf0Var2.u;
            InterfaceC0706a60 fzVar = new fz(omVar, interfaceC0706a602, 5);
            if (fzVar instanceof do0) {
                do0Var4 = fzVar;
            } else {
                do0Var4 = new do0(fzVar);
            }
            InterfaceC0706a60 bqVar = new bq(vf0Var2.c4, omVar, do0Var, vf0Var2.t, vf0Var2.G, do0Var2, a, vf0Var2.d, a2, do0Var3, a3, vf0Var2.k1, do0Var4, vf0Var2.e0, 1);
            if (!(bqVar instanceof do0)) {
                bqVar = new do0(bqVar);
            }
            cm1Var.a((InterfaceC4300rt) new nk((zx2) bqVar.get(), vp, null, 0));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void b(Activity activity, InterfaceC4275rY interfaceC4275rY) {
        if (this.b) {
            return;
        }
        V5 v5 = (V5) this.c;
        if (v5 != null) {
            C4199qY c4199qY = new C4199qY(this, interfaceC4275rY);
            sk skVar = (sk) v5;
            skVar.getClass();
            skVar.c.setValue(skVar, sk.e[0], c4199qY);
            this.b = true;
            sk skVar2 = (sk) ((V5) this.c);
            skVar2.getClass();
            AbstractC4766xx.p(activity, "activity");
            skVar2.b.a(activity);
            return;
        }
        interfaceC4275rY.d();
        long j = ((UDPApplication) this.d).c.getLong(Deobfuscator$AMTUNNELLITE$app.getString(-150073283514017L), 0L);
        if (j == 0 || (j != 0 && System.currentTimeMillis() >= j + 3600000)) {
            a();
        }
    }
}
