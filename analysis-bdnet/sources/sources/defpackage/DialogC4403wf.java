package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import dastan.prince.bdfreevpn.R;

/* renamed from: wf, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogC4403wf extends Dialog implements EB, YI, InterfaceC3910qQ {
    public HB a;
    public final C3752oQ b;
    public final YV c;
    public final YV d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialogC4403wf(Context context, int i) {
        super(context, i);
        AbstractC3634my.g(context, "context");
        this.b = new C3752oQ(new C3831pQ(this, new C4416wr(this, 4)));
        final int i2 = 0;
        this.c = W80.N(new InterfaceC0470Rt(this) { // from class: vf
            public final /* synthetic */ DialogC4403wf b;

            {
                this.b = this;
            }

            @Override // defpackage.InterfaceC0470Rt
            public final Object invoke() {
                switch (i2) {
                    case 0:
                        C4252ul c4252ul = new C4252ul();
                        this.b.getOnBackPressedDispatcher().b().c.a(c4252ul);
                        return c4252ul;
                    default:
                        return new XI(new RunnableC3954r1(this.b, 5));
                }
            }
        });
        final int i3 = 1;
        this.d = W80.N(new InterfaceC0470Rt(this) { // from class: vf
            public final /* synthetic */ DialogC4403wf b;

            {
                this.b = this;
            }

            @Override // defpackage.InterfaceC0470Rt
            public final Object invoke() {
                switch (i3) {
                    case 0:
                        C4252ul c4252ul = new C4252ul();
                        this.b.getOnBackPressedDispatcher().b().c.a(c4252ul);
                        return c4252ul;
                    default:
                        return new XI(new RunnableC3954r1(this.b, 5));
                }
            }
        });
    }

    public static void a(DialogC4403wf dialogC4403wf) {
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC3634my.g(view, "view");
        b();
        super.addContentView(view, layoutParams);
    }

    public final void b() {
        Window window = getWindow();
        AbstractC3634my.d(window);
        View decorView = window.getDecorView();
        AbstractC3634my.f(decorView, "getDecorView(...)");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        AbstractC3634my.d(window2);
        View decorView2 = window2.getDecorView();
        AbstractC3634my.f(decorView2, "getDecorView(...)");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        AbstractC3634my.d(window3);
        View decorView3 = window3.getDecorView();
        AbstractC3634my.f(decorView3, "getDecorView(...)");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
        Window window4 = getWindow();
        AbstractC3634my.d(window4);
        View decorView4 = window4.getDecorView();
        AbstractC3634my.f(decorView4, "getDecorView(...)");
        decorView4.setTag(R.id.view_tree_navigation_event_dispatcher_owner, this);
    }

    @Override // defpackage.EB
    public final AbstractC4605zB getLifecycle() {
        HB hb = this.a;
        if (hb != null) {
            return hb;
        }
        HB hb2 = new HB(this);
        this.a = hb2;
        return hb2;
    }

    @Override // defpackage.YI
    public final XI getOnBackPressedDispatcher() {
        return (XI) this.d.getValue();
    }

    @Override // defpackage.InterfaceC3910qQ
    public final C3673nQ getSavedStateRegistry() {
        return this.b.b;
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        ((C4252ul) this.c.getValue()).a();
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            XI onBackPressedDispatcher = getOnBackPressedDispatcher();
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            AbstractC3634my.f(onBackInvokedDispatcher, "getOnBackInvokedDispatcher(...)");
            onBackPressedDispatcher.d(onBackInvokedDispatcher);
        }
        this.b.a(bundle);
        HB hb = this.a;
        if (hb == null) {
            hb = new HB(this);
            this.a = hb;
        }
        hb.e(EnumC4447xB.ON_CREATE);
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        AbstractC3634my.f(onSaveInstanceState, "onSaveInstanceState(...)");
        this.b.b(onSaveInstanceState);
        return onSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        HB hb = this.a;
        if (hb == null) {
            hb = new HB(this);
            this.a = hb;
        }
        hb.e(EnumC4447xB.ON_RESUME);
    }

    @Override // android.app.Dialog
    public void onStop() {
        HB hb = this.a;
        if (hb == null) {
            hb = new HB(this);
            this.a = hb;
        }
        hb.e(EnumC4447xB.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        b();
        super.setContentView(i);
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        AbstractC3634my.g(view, "view");
        b();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC3634my.g(view, "view");
        b();
        super.setContentView(view, layoutParams);
    }
}
