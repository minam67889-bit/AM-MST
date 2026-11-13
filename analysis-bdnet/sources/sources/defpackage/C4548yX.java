package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import dastan.prince.bdfreevpn.R;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: yX, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C4548yX implements InterfaceC0414Pp {
    public final Object a;
    public final Object b;
    public Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public C4548yX(XL xl, XL xl2, XL xl3, XL xl4, XL xl5, XL xl6, C2835cv c2835cv) {
        this.a = xl;
        this.b = xl2;
        this.c = xl3;
        this.d = xl4;
        this.e = xl5;
        this.f = xl6;
        this.g = c2835cv;
    }

    public void a(String str) {
        C0148Fi c0148Fi = (C0148Fi) this.e;
        synchronized (c0148Fi) {
            try {
                if (((C4130tA) ((AtomicMarkableReference) c0148Fi.b).getReference()).b(str)) {
                    AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) c0148Fi.b;
                    atomicMarkableReference.set((C4130tA) atomicMarkableReference.getReference(), true);
                    RunnableC3954r1 runnableC3954r1 = new RunnableC3954r1(c0148Fi, 17);
                    AtomicReference atomicReference = (AtomicReference) c0148Fi.c;
                    while (!atomicReference.compareAndSet(null, runnableC3954r1)) {
                        if (atomicReference.get() != null) {
                            return;
                        }
                    }
                    ((ExecutorC3221hi) ((C2853d6) ((C4548yX) c0148Fi.d).b).c).a(runnableC3954r1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.YL
    public Object get() {
        return new C3357jT((C2958eS) ((XL) this.a).get(), (XR) ((XL) this.b).get(), (TR) ((XL) this.c).get(), (VW) ((XL) this.d).get(), (InterfaceC3142gj) ((XL) this.e).get(), (C3747oL) ((XL) this.f).get(), (InterfaceC0613Xg) ((C2835cv) this.g).b);
    }

    public C4548yX(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(C4548yX.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public C4548yX(String str, C0156Fq c0156Fq, C2853d6 c2853d6) {
        this.d = new C0148Fi(this, false);
        this.e = new C0148Fi(this, true);
        this.f = new U3(6, (byte) 0);
        this.g = new AtomicMarkableReference(null, false);
        this.c = str;
        this.a = new C0712aG(c0156Fq);
        this.b = c2853d6;
    }
}
