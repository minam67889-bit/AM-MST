package ads_mobile_sdk;

import ads_mobile_sdk.l23;
import com.google.common.util.concurrent.ListenableFuture;
import defpackage.AbstractC0525Tw;
import defpackage.AbstractC4577yu;
import defpackage.C0196He;
import defpackage.C0222Ie;
import defpackage.Ee0;
import defpackage.HC;
import defpackage.InterfaceC3053fd0;
import defpackage.Z60;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class l23 {
    public final HC a;
    public final a b;
    public final Set c;
    public final String d;
    public final Z60 e;
    public final InterfaceC3053fd0 f;
    public final pd3 g;

    public l23(HC hc, a aVar, InterfaceC3053fd0 interfaceC3053fd0, i63 i63Var, String str, Z60 z60, Ee0 ee0, Ee0 ee02, Ee0 ee03, pd3 pd3Var) {
        this.a = hc;
        this.b = aVar;
        this.d = str;
        this.f = interfaceC3053fd0;
        this.e = z60;
        this.g = pd3Var;
        int ordinal = i63Var.ordinal();
        if (ordinal == 0) {
            this.c = (Set) ee0.get();
        } else if (ordinal == 1) {
            this.c = (Set) ee02.get();
        } else {
            if (ordinal != 2) {
                throw new IllegalStateException();
            }
            this.c = (Set) ee03.get();
        }
    }

    public final String a() {
        pd3 pd3Var = this.g;
        try {
            new qc3(nk0.EVENT_ID_ENCRYPTION, pd3Var.b, pd3Var.a).b();
            return c();
        } finally {
        }
    }

    public final ListenableFuture b() {
        boolean z;
        a aVar = this.b;
        synchronized (aVar) {
            z = aVar.d;
        }
        if (!z) {
            return AbstractC4577yu.e(Integer.toString(7));
        }
        if (!((sm1) this.f).b()) {
            final int i = 0;
            return AbstractC4577yu.g(this.a, new Callable(this) { // from class: la0
                public final /* synthetic */ l23 b;

                {
                    this.b = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    switch (i) {
                        case 0:
                            return this.b.d();
                        default:
                            return this.b.a();
                    }
                }
            });
        }
        ArrayList arrayList = new ArrayList(this.c.size());
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            arrayList.add(this.a.submit((Callable) it.next()));
        }
        AbstractC0525Tw q = AbstractC0525Tw.q(arrayList);
        final int i2 = 1;
        Callable callable = new Callable(this) { // from class: la0
            public final /* synthetic */ l23 b;

            {
                this.b = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                switch (i2) {
                    case 0:
                        return this.b.d();
                    default:
                        return this.b.a();
                }
            }
        };
        C0222Ie c0222Ie = new C0222Ie(q, false, false);
        c0222Ie.i = new C0196He(c0222Ie, callable);
        c0222Ie.n();
        return c0222Ie;
    }

    public final /* synthetic */ String c() {
        return this.b.a((id) this.e.a(), this.d);
    }

    public final /* synthetic */ String d() {
        return this.b.a(xc.PSN_INITIALIZATION_FAIL, this.d);
    }
}
