package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public final class GW implements InterfaceC4527up {
    public final Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GW(InterfaceC0813bL interfaceC0813bL, InterfaceC0813bL interfaceC0813bL2, InterfaceC0813bL interfaceC0813bL3, InterfaceC0813bL interfaceC0813bL4, InterfaceC0813bL interfaceC0813bL5, InterfaceC0813bL interfaceC0813bL6, InterfaceC0813bL interfaceC0813bL7) {
        this.a = interfaceC0813bL;
        this.b = interfaceC0813bL2;
        this.c = interfaceC0813bL3;
        this.d = interfaceC0813bL4;
        this.e = interfaceC0813bL5;
        this.f = interfaceC0813bL6;
        this.g = interfaceC0813bL7;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // defpackage.InterfaceC0890cL
    public Object get() {
        return new C4039oS((C3884mR) ((InterfaceC0813bL) this.a).get(), (C3270eR) ((InterfaceC0813bL) this.b).get(), (InterfaceC0730aR) ((InterfaceC0813bL) this.c).get(), (C0901cW) ((InterfaceC0813bL) this.d).get(), (InterfaceC0648Yi) ((InterfaceC0813bL) this.e).get(), (C4338sK) ((InterfaceC0813bL) this.f).get(), (InterfaceC0231Ig) ((InterfaceC0813bL) this.g).get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GW(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.d = layoutParams;
        this.e = new Rect();
        this.f = new int[2];
        this.g = new int[2];
        this.a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.b = inflate;
        this.c = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(GW.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }
}
