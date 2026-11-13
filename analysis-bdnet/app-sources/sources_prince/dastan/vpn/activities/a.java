package prince.dastan.vpn.activities;

import android.widget.Toast;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import defpackage.AbstractC4569ym;
import defpackage.F00;
import defpackage.I4;
import defpackage.S50;
import defpackage.ServiceConnectionC3719o10;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.lsposed.lsparanoid.Deobfuscator$BDNETVPN$app;
import prince.dastan.vpn.service.FWPuncherService;

/* loaded from: classes2.dex */
public abstract class a extends I4 {
    public FWPuncherService b;
    public ServiceConnectionC3719o10 c;

    static {
        Deobfuscator$BDNETVPN$app.getString(-73086790367115L);
    }

    public static String i(FileInputStream fileInputStream) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            char[] cArr = new char[UserVerificationMethods.USER_VERIFY_ALL];
            while (true) {
                int read = bufferedReader.read(cArr, 0, UserVerificationMethods.USER_VERIFY_ALL);
                if (read <= 0) {
                    break;
                }
                sb.append(cArr, 0, read);
            }
        } catch (Exception unused) {
        }
        return sb.toString();
    }

    public final JSONObject h() {
        String str;
        String str2;
        File file = new File(getFilesDir().getAbsolutePath() + Deobfuscator$BDNETVPN$app.getString(-72854862133131L));
        try {
            if (file.exists()) {
                String i = i(new FileInputStream(file));
                int i2 = F00.a;
                try {
                    str2 = AbstractC4569ym.c(i, AbstractC4569ym.a);
                } catch (Exception unused) {
                    str2 = null;
                }
                return new JSONObject(str2);
            }
            String D = S50.D(getApplicationContext(), Deobfuscator$BDNETVPN$app.getString(-72910696707979L));
            int i3 = F00.a;
            try {
                str = AbstractC4569ym.c(D, AbstractC4569ym.a);
            } catch (Exception unused2) {
                str = null;
            }
            return new JSONObject(str);
        } catch (Exception e) {
            Toast.makeText((VPNClient) this, Deobfuscator$BDNETVPN$app.getString(-72962236315531L) + e.getMessage(), 1).show();
            return null;
        }
    }
}
