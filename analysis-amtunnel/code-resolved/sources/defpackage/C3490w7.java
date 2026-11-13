package defpackage;

import android.content.IntentSender;
import android.util.Log;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import org.lsposed.lsparanoid.Deobfuscator$AMTUNNELLITE$app;
import prince.udp.vpn.activities.UDPClient;
import xyz.hasnat.sweettoast.SweetToast;

/* renamed from: w7, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C3490w7 implements OnSuccessListener, Ty {
    public boolean a;
    public final Object b;

    public C3490w7(C0253Pn c0253Pn, boolean z) {
        this.b = c0253Pn;
        this.a = z;
    }

    public /* synthetic */ C3490w7(Object obj, boolean z) {
        this.b = obj;
        this.a = z;
    }

    public C3490w7(StringBuilder sb) {
        this.b = sb;
        this.a = true;
    }

    public C3490w7(C3114p1 c3114p1) {
        AbstractC3365tp.q(c3114p1, "writer");
        this.b = c3114p1;
        this.a = true;
    }

    public C3490w7(boolean z, String str) {
        this.a = z;
        this.b = str;
    }

    @Override // defpackage.Ty
    public void a(Sy sy, int i) {
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

    public void c() {
        this.a = true;
    }

    public boolean d(CharSequence charSequence, int i) {
        if (charSequence == null || i < 0 || charSequence.length() - i < 0) {
            throw new IllegalArgumentException();
        }
        C0253Pn c0253Pn = (C0253Pn) this.b;
        if (c0253Pn == null) {
            return b();
        }
        int l = c0253Pn.l(charSequence, i);
        if (l == 0) {
            return true;
        }
        if (l != 1) {
            return b();
        }
        return false;
    }

    public void e() {
        this.a = false;
    }

    public void f() {
        this.a = false;
    }

    public void g(char c) {
        C3114p1 c3114p1 = (C3114p1) this.b;
        c3114p1.c(c3114p1.b, 1);
        char[] cArr = (char[]) c3114p1.c;
        int i = c3114p1.b;
        c3114p1.b = i + 1;
        cArr[i] = c;
    }

    public void h(int i) {
        long j = i;
        C3114p1 c3114p1 = (C3114p1) this.b;
        c3114p1.getClass();
        c3114p1.g(String.valueOf(j));
    }

    public void i(long j) {
        C3114p1 c3114p1 = (C3114p1) this.b;
        c3114p1.getClass();
        c3114p1.g(String.valueOf(j));
    }

    public void j(String str) {
        AbstractC3365tp.q(str, "v");
        ((C3114p1) this.b).g(str);
    }

    public void k(String str) {
        int i;
        AbstractC3365tp.q(str, AppMeasurementSdk.ConditionalUserProperty.VALUE);
        C3114p1 c3114p1 = (C3114p1) this.b;
        c3114p1.getClass();
        c3114p1.c(c3114p1.b, str.length() + 2);
        char[] cArr = (char[]) c3114p1.c;
        int i2 = c3114p1.b;
        int i3 = i2 + 1;
        cArr[i2] = '\"';
        int length = str.length();
        str.getChars(0, length, cArr, i3);
        int i4 = length + i3;
        int i5 = i3;
        while (i5 < i4) {
            char c = cArr[i5];
            byte[] bArr = AbstractC3075oF.b;
            if (c < bArr.length && bArr[c] != 0) {
                int length2 = str.length();
                for (int i6 = i5 - i3; i6 < length2; i6++) {
                    c3114p1.c(i5, 2);
                    char charAt = str.charAt(i6);
                    byte[] bArr2 = AbstractC3075oF.b;
                    if (charAt < bArr2.length) {
                        byte b = bArr2[charAt];
                        if (b == 0) {
                            i = i5 + 1;
                            ((char[]) c3114p1.c)[i5] = charAt;
                        } else {
                            if (b == 1) {
                                String str2 = AbstractC3075oF.a[charAt];
                                AbstractC3365tp.m(str2);
                                c3114p1.c(i5, str2.length());
                                str2.getChars(0, str2.length(), (char[]) c3114p1.c, i5);
                                int length3 = str2.length() + i5;
                                c3114p1.b = length3;
                                i5 = length3;
                            } else {
                                char[] cArr2 = (char[]) c3114p1.c;
                                cArr2[i5] = '\\';
                                cArr2[i5 + 1] = (char) b;
                                i5 += 2;
                                c3114p1.b = i5;
                            }
                        }
                    } else {
                        i = i5 + 1;
                        ((char[]) c3114p1.c)[i5] = charAt;
                    }
                    i5 = i;
                }
                c3114p1.c(i5, 1);
                ((char[]) c3114p1.c)[i5] = '\"';
                c3114p1.b = i5 + 1;
                return;
            }
            i5++;
        }
        cArr[i4] = '\"';
        c3114p1.b = i4 + 1;
    }

    public void l() {
    }

    public void m() {
    }

    @Override // com.google.android.gms.tasks.OnSuccessListener
    public void onSuccess(Object obj) {
        StringBuilder sb;
        int updateAvailability;
        AppUpdateInfo appUpdateInfo = (AppUpdateInfo) obj;
        C0134Ho c0134Ho = (C0134Ho) this.b;
        c0134Ho.q.getClass();
        if (this.a) {
            if (appUpdateInfo.updateAvailability() == 2) {
                if (c0134Ho.f == 1 && appUpdateInfo.isUpdateTypeAllowed(0)) {
                    try {
                        c0134Ho.b.startUpdateFlowForResult(appUpdateInfo, 0, c0134Ho.a, c0134Ho.c);
                    } catch (IntentSender.SendIntentException e) {
                        Log.e("InAppUpdateManager", "error in startAppUpdateFlexible", e);
                        InterfaceC0119Go interfaceC0119Go = c0134Ho.o;
                        if (interfaceC0119Go != null) {
                            SweetToast.error(((UDPClient) interfaceC0119Go).getApplicationContext(), "#ERR IndexError: list index out of range");
                        }
                    }
                } else if (appUpdateInfo.isUpdateTypeAllowed(1)) {
                    C0134Ho.j(c0134Ho, appUpdateInfo);
                }
                sb = new StringBuilder("checkForAppUpdate(): Update available. Version Code: ");
                updateAvailability = appUpdateInfo.availableVersionCode();
            } else if (appUpdateInfo.updateAvailability() == 1) {
                sb = new StringBuilder("checkForAppUpdate(): No Update available. Code: ");
                updateAvailability = appUpdateInfo.updateAvailability();
            }
            sb.append(updateAvailability);
            Log.d("InAppUpdateManager", sb.toString());
        }
        C0134Ho.d(c0134Ho);
    }
}
