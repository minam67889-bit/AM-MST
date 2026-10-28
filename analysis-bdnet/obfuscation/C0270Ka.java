package defpackage;

import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.activities.VPNClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: Ka, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0270Ka implements OnSuccessListener, InterfaceC3984rM {
    public boolean a;
    public final Object b;

    public /* synthetic */ C0270Ka(Object obj) {
        this.b = obj;
        this.a = true;
    }

    @Override // defpackage.InterfaceC3984rM
    public void a(C3906qM c3906qM, int i) {
        boolean z = this.a;
        StringBuilder sb = (StringBuilder) this.b;
        if (z) {
            this.a = false;
        } else {
            sb.append(", ");
        }
        sb.append(i);
    }

    public boolean b() {
        return this.a;
    }

    public boolean c(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        if (((C0213Hv) this.b) == null) {
            return b();
        }
        char c = 2;
        for (int i2 = 0; i2 < i && c == 2; i2++) {
            byte directionality = Character.getDirectionality(charSequence.charAt(i2));
            C0270Ka c0270Ka = AbstractC4626zW.a;
            if (directionality != 0) {
                if (directionality != 1 && directionality != 2) {
                    switch (directionality) {
                        case 14:
                        case 15:
                            break;
                        case 16:
                        case 17:
                            break;
                        default:
                            c = 2;
                            break;
                    }
                }
                c = 0;
            }
            c = 1;
        }
        if (c == 0) {
            return true;
        }
        if (c != 1) {
            return b();
        }
        return false;
    }

    public void d() {
        this.a = false;
    }

    public void e(char c) {
        U3 u3 = (U3) this.b;
        u3.b(u3.b, 1);
        char[] cArr = (char[]) u3.c;
        int i = u3.b;
        u3.b = i + 1;
        cArr[i] = c;
    }

    public void f() {
    }

    public void g() {
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
        C2996ex c2996ex = (C2996ex) this.b;
        C2835cv c2835cv = c2996ex.g;
        if (this.a) {
            if (appUpdateInfo.updateAvailability() == 2) {
                if (appUpdateInfo.isUpdateTypeAllowed(0)) {
                    try {
                        c2996ex.b.startUpdateFlowForResult(appUpdateInfo, 0, c2996ex.a, 530);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e("InAppUpdateManager", "error in startAppUpdateFlexible", e);
                        VPNClient vPNClient = c2996ex.e;
                        if (vPNClient != null) {
                            SweetToast.error(vPNClient.getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-68375211243403L));
                        }
                    }
                } else if (appUpdateInfo.isUpdateTypeAllowed(1)) {
                    C2996ex.e(c2996ex, appUpdateInfo);
                }
                Log.d("InAppUpdateManager", "checkForAppUpdate(): Update available. Version Code: " + appUpdateInfo.availableVersionCode());
            } else if (appUpdateInfo.updateAvailability() == 1) {
                Log.d("InAppUpdateManager", "checkForAppUpdate(): No Update available. Code: " + appUpdateInfo.updateAvailability());
            }
        }
        C2996ex.a(c2996ex);
    }

    public /* synthetic */ C0270Ka(Object obj, boolean z) {
        this.b = obj;
        this.a = z;
    }

    public C0270Ka(C0213Hv c0213Hv, boolean z) {
        this.b = c0213Hv;
        this.a = z;
    }

    public C0270Ka(boolean z, String str) {
        this.a = z;
        this.b = str;
    }
}
