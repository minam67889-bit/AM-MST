package defpackage;

import ads_mobile_sdk.h41;
import ads_mobile_sdk.i2;
import ads_mobile_sdk.km;
import ads_mobile_sdk.r31;
import ads_mobile_sdk.tk0;
import ads_mobile_sdk.zn3;
import ads_mobile_sdk.zs0;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.widget.FrameLayout;
import app.vpn.amtunnellite.R;

/* loaded from: classes.dex */
public interface Z40 {
    km a();

    /* JADX WARN: Removed duplicated region for block: B:12:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static Object a(Z40 z40, h41 h41Var, i2 i2Var, tk0 tk0Var, InterfaceC4441tg interfaceC4441tg) {
        zs0 zs0Var;
        int i;
        String str;
        if (interfaceC4441tg instanceof zs0) {
            zs0Var = (zs0) interfaceC4441tg;
            int i2 = zs0Var.f;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                zs0Var.f = i2 - Integer.MIN_VALUE;
                Object obj = zs0Var.d;
                EnumC0516Tg enumC0516Tg = EnumC0516Tg.a;
                i = zs0Var.f;
                YY yy = YY.a;
                if (i != 0) {
                    AbstractC3354fY.n0(obj);
                    r31 r31Var = h41Var.a;
                    zs0Var.a = h41Var;
                    zs0Var.b = i2Var;
                    zs0Var.c = tk0Var;
                    zs0Var.f = 1;
                    z40.getClass();
                    C0508Sy c0508Sy = new C0508Sy();
                    c0508Sy.t("app_muted", String.valueOf(z40.a().d));
                    c0508Sy.t("app_volume", String.valueOf(z40.a().c));
                    Object a = r31Var.a(c0508Sy, "volume", zs0Var);
                    if (a != enumC0516Tg) {
                        a = yy;
                    }
                    if (a == enumC0516Tg) {
                        return enumC0516Tg;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    tk0Var = zs0Var.c;
                    i2Var = zs0Var.b;
                    h41Var = zs0Var.a;
                    AbstractC3354fY.n0(obj);
                }
                h41Var.b = tk0Var;
                if (i2Var.d0) {
                    Context context = h41Var.getContext();
                    AbstractC4766xx.o(context, "getContext(...)");
                    zn3 zn3Var = new zn3(context);
                    try {
                        str = context.getResources().getString(R.string.test_ad);
                    } catch (Resources.NotFoundException unused) {
                        str = "Test Ad";
                    }
                    zn3Var.setText(str);
                    zn3Var.setTextSize(15.0f);
                    zn3Var.setTextColor(-1);
                    zn3Var.setPadding(5, 0, 5, 0);
                    GradientDrawable gradientDrawable = new GradientDrawable();
                    gradientDrawable.setShape(0);
                    gradientDrawable.setColor(-12303292);
                    gradientDrawable.setCornerRadius(8.0f);
                    zn3Var.setBackground(gradientDrawable);
                    h41Var.addView(zn3Var, new FrameLayout.LayoutParams(-2, -2, 49));
                    h41Var.bringChildToFront(zn3Var);
                }
                return yy;
            }
        }
        zs0Var = new zs0(z40, interfaceC4441tg);
        Object obj2 = zs0Var.d;
        EnumC0516Tg enumC0516Tg2 = EnumC0516Tg.a;
        i = zs0Var.f;
        YY yy2 = YY.a;
        if (i != 0) {
        }
        h41Var.b = tk0Var;
        if (i2Var.d0) {
        }
        return yy2;
    }
}
