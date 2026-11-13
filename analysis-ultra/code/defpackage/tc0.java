package defpackage;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import android.widget.TextView;
import com.v2ray.ang.ui.HomeFragment;
import kotlin.Lazy;
import kotlin.jvm.functions.Function1;

/* compiled from: r8-map-id-6bfc5c3105a4be2b3e0ed36dbd4f8244cea9222f352ced40fd941a9b8aa981c8 */
/* loaded from: classes3.dex */
public final /* synthetic */ class tc0 implements Function1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ HomeFragment b;

    public /* synthetic */ tc0(HomeFragment homeFragment, int i) {
        this.a = i;
        this.b = homeFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        int i = this.a;
        mk1 mk1Var = mk1.a;
        HomeFragment homeFragment = this.b;
        switch (i) {
            case 0:
                int intValue = ((Integer) obj).intValue();
                int i2 = HomeFragment.f2;
                if (intValue != 0) {
                    if (intValue != 1) {
                        if (intValue != 2) {
                            if (intValue == 3) {
                                homeFragment.L().finish();
                            }
                        } else {
                            Uri parse = Uri.parse("https://vpnprous.com/");
                            try {
                                homeFragment.U(new Intent("android.intent.action.VIEW", parse));
                            } catch (ActivityNotFoundException unused) {
                                homeFragment.U(new Intent("android.intent.action.VIEW", parse));
                            }
                        }
                    } else {
                        homeFragment.j0();
                    }
                } else {
                    homeFragment.M0();
                }
                return mk1Var;
            case 1:
                Long l = (Long) obj;
                TextView textView = homeFragment.Y0;
                if (textView != null) {
                    l.getClass();
                    textView.setText(HomeFragment.s0(l.longValue()));
                }
                return mk1Var;
            case 2:
                Long l2 = (Long) obj;
                TextView textView2 = homeFragment.Z0;
                if (textView2 != null) {
                    l2.getClass();
                    textView2.setText(HomeFragment.s0(l2.longValue()));
                }
                return mk1Var;
            case 3:
                int i3 = HomeFragment.f2;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Lazy lazy = zq0.a;
                int c = (int) ((elapsedRealtime - zq0.u().c(0L, "v2rayTime")) / 1000);
                TextView textView3 = homeFragment.X0;
                if (textView3 != null) {
                    textView3.setText(HomeFragment.t0(c));
                }
                return mk1Var;
            default:
                int intValue2 = ((Integer) obj).intValue();
                int i4 = HomeFragment.f2;
                if (intValue2 != 0) {
                    if (intValue2 != 1) {
                        if (intValue2 != 2) {
                            if (intValue2 == 3) {
                                homeFragment.L().finish();
                            }
                        } else {
                            Uri parse2 = Uri.parse("https://vpnprous.com/");
                            try {
                                homeFragment.U(new Intent("android.intent.action.VIEW", parse2));
                            } catch (ActivityNotFoundException unused2) {
                                homeFragment.U(new Intent("android.intent.action.VIEW", parse2));
                            }
                        }
                    } else {
                        homeFragment.j0();
                    }
                } else {
                    homeFragment.M0();
                }
                return mk1Var;
        }
    }
}
