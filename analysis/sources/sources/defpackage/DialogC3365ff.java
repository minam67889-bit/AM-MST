package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.window.OnBackInvokedDispatcher;
import app.vpn.amtunnellite.R;

/* renamed from: ff, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class DialogC3365ff extends Dialog implements QA, ZH, InterfaceC4343sP {
    public TA a;
    public final C4113pP b;
    public final YH c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DialogC3365ff(Context context, int i) {
        super(context, i);
        AbstractC4766xx.p(context, "context");
        this.b = new C4113pP(new C4266rP(this, new C0462Re(this, 4)));
        this.c = new YH(new RunnableC4080p1(this, 6));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void a(DialogC3365ff dialogC3365ff) {
        AbstractC4766xx.p(dialogC3365ff, "this$0");
        super.onBackPressed();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC4766xx.p(view, "view");
        c();
        super.addContentView(view, layoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TA b() {
        TA ta = this.a;
        if (ta == null) {
            TA ta2 = new TA(this);
            this.a = ta2;
            return ta2;
        }
        return ta;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void c() {
        Window window = getWindow();
        AbstractC4766xx.m(window);
        View decorView = window.getDecorView();
        AbstractC4766xx.o(decorView, "window!!.decorView");
        decorView.setTag(R.id.view_tree_lifecycle_owner, this);
        Window window2 = getWindow();
        AbstractC4766xx.m(window2);
        View decorView2 = window2.getDecorView();
        AbstractC4766xx.o(decorView2, "window!!.decorView");
        decorView2.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, this);
        Window window3 = getWindow();
        AbstractC4766xx.m(window3);
        View decorView3 = window3.getDecorView();
        AbstractC4766xx.o(decorView3, "window!!.decorView");
        decorView3.setTag(R.id.view_tree_saved_state_registry_owner, this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.QA
    public final LA getLifecycle() {
        return b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.ZH
    public final YH getOnBackPressedDispatcher() {
        return this.c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC4343sP
    public final C4036oP getSavedStateRegistry() {
        return this.b.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.c.b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void onCreate(Bundle bundle) {
        OnBackInvokedDispatcher onBackInvokedDispatcher;
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            AbstractC4766xx.o(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            YH yh = this.c;
            yh.getClass();
            yh.e = onBackInvokedDispatcher;
            yh.c(yh.g);
        }
        this.b.a(bundle);
        b().e(JA.ON_CREATE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle onSaveInstanceState = super.onSaveInstanceState();
        AbstractC4766xx.o(onSaveInstanceState, "super.onSaveInstanceState()");
        this.b.b(onSaveInstanceState);
        return onSaveInstanceState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        b().e(JA.ON_RESUME);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void onStop() {
        b().e(JA.ON_DESTROY);
        this.a = null;
        super.onStop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void setContentView(int i) {
        c();
        super.setContentView(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void setContentView(View view) {
        AbstractC4766xx.p(view, "view");
        c();
        super.setContentView(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        AbstractC4766xx.p(view, "view");
        c();
        super.setContentView(view, layoutParams);
    }
}
